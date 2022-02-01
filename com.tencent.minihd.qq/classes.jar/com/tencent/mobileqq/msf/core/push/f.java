package com.tencent.mobileqq.msf.core.push;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat.Builder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.c.e.a;
import com.tencent.mobileqq.msf.core.c.i;
import com.tencent.mobileqq.msf.core.p;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.n;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.pb.offlinepush.C2CMsgReadedNotify;
import com.tencent.msf.service.protocol.pb.offlinepush.C2CTmpOffMsgHead;
import com.tencent.msf.service.protocol.pb.offlinepush.DisMsgReadedNotify;
import com.tencent.msf.service.protocol.pb.offlinepush.DiscussOffInfo;
import com.tencent.msf.service.protocol.pb.offlinepush.GroupOffInfo;
import com.tencent.msf.service.protocol.pb.offlinepush.PbPushOffMsg;
import com.tencent.msf.service.protocol.pb.offlinepush.PbPushOffReadedNotify;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class f
  extends BroadcastReceiver
{
  public static int A = 10103;
  public static int B = 10104;
  public static final String E = "com.tencent.mobileqq.msf.receiveofflinepush";
  public static final String F = "com.tencent.mobileqq.msf.offlinepushclearall";
  public static final String G = "com.tencent.mobileqq.msf.devlockquickloginpush";
  public static final String H = "com.tencent.mobileqq.msf.devlockquickloginpushclear";
  public static final String I = "com.tencent.mobileqq.action.QQWiFi";
  public static final String J = "com.tencent.mobileqq.msf.qqwifi.missions";
  public static final String K = "com.tencent.mobileqq.msf.qqwifi.settings";
  public static final String L = "com.tencent.mobileqq.msf.qqwifi.redtouch";
  public static final String M = "com.tencent.mobileqq.msf.qqwifi.map";
  public static final String N = "com.tencent.mobileqq.msf.qqwifi.autoconnect";
  public static final String O = "com.tencent.mobileqq.msf.receiveofflinepushav";
  public static final String P = "com.tencent.mobileqq.msf.offlinepushclearallav";
  static final int R = 20140416;
  public static final String a = "app_push_info_";
  public static final int aa = 0;
  public static final int ab = 1;
  public static final int ac = 2;
  public static final int ad = 3;
  public static final int ae = -56;
  public static final int af = -55;
  private static final int[] aj = { 1, 1, 1, 5, 5, 10, 10, 30, 30, 60, 60, 900, 900 };
  private static int ak = 0;
  private static final long[] ar = { 100L, 200L, 200L, 100L };
  private static final String as = "com.tencent.mobileqq.broadcast.pcactiveQQ";
  static final String e = "MSF.C.PushManager";
  static final String f = "PCActivePush";
  static SimpleDateFormat g = new SimpleDateFormat("dd HH:mm:ss");
  public static boolean n = false;
  public static String o = "0";
  public static volatile boolean p = false;
  static final String q = "OnlinePush.ReqPush";
  static final String r = "CliNotifySvc.SvcReqPush";
  static final String s = "StatSvc.QueryHB";
  static int y = 10101;
  static int z = 10102;
  ArrayList C = new ArrayList();
  ArrayList D = new ArrayList();
  public MediaPlayer Q;
  Handler S = new l(this);
  String T = Environment.getExternalStorageDirectory().getAbsolutePath();
  String U = this.T + "/Tencent/MobileQQ/";
  String V = "head/";
  String W = this.U + this.V + "_hd/";
  String X = this.U + this.V + "_thd/";
  String Y = this.V + "_hd/";
  String Z = this.U + ".billd_urldrawable/";
  private Object aA = new Object();
  String ag = "message.ring.switch";
  String ah = "message.vibrate.switch";
  String ai = "message.ring.care";
  private final int al = 1;
  private PendingIntent am;
  private b an;
  private Handler ao = new g(this);
  private boolean ap = false;
  private long aq = 0L;
  private AtomicBoolean at = new AtomicBoolean(false);
  private String au = "0";
  private int av = -1;
  private PendingIntent aw = null;
  private BroadcastReceiver ax = new k(this);
  private int ay;
  private boolean az = false;
  MsfCore b;
  String c = "";
  String d = "";
  public ConcurrentHashMap h = new ConcurrentHashMap();
  public d i;
  AlarmManager j;
  b k = new b();
  int l = -1;
  boolean m = false;
  volatile Object t = new Object();
  int u = 30000;
  long v = 0L;
  final long w = 300000L;
  long x = 0L;
  
  public f(MsfCore paramMsfCore)
  {
    this.b = paramMsfCore;
    this.i = new d(this);
    this.k.setName("MsfCorePushManager");
    this.an = new b(paramMsfCore);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i1 = i2;
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg unknow msgtype:" + paramInt1);
      }
      i1 = -1;
    case 9: 
    case 10: 
    case 16: 
    case 17: 
    case 31: 
    case 79: 
    case 97: 
    case 120: 
    case 132: 
    case 133: 
    case 166: 
    case 167: 
    case 208: 
    case 529: 
    case 734: 
      return i1;
    case 42: 
    case 83: 
      return 1;
    case 215: 
    case 519: 
      i1 = i2;
      switch (paramInt2)
      {
      case 1: 
      case 11: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg unknow dwVideoType:" + paramInt2);
        }
        return -1;
      case 2: 
      case 12: 
        return 2;
      }
      return 1;
    case 140: 
    case 141: 
      return 2;
    }
    return 3;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      if (paramBitmap == null) {
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      Object localObject = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect((RectF)localObject, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localObject = new Matrix();
      ((Matrix)localObject).setRectToRect(new RectF(localRect1), new RectF(localRect2), Matrix.ScaleToFit.FILL);
      localCanvas.drawBitmap(Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true), localRect2, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f1 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    int i1 = (paramInt1 + paramInt2) / 2;
    int i2 = (int)(f1 * 4.0D);
    if (i1 <= 70) {
      i1 = (int)(2.0D * f1);
    }
    for (;;)
    {
      paramInt1 = (int)(paramInt1 * f1);
      paramInt2 = (int)(f1 * paramInt2);
      return a(paramBitmap, i1, paramInt1, paramInt2);
      if (i1 <= 100) {
        i1 = (int)(f1 * 4.0D);
      } else if (i1 <= 128) {
        i1 = (int)(8.0D * f1);
      } else {
        i1 = (int)((paramInt1 / 100 * 4 + 8) * f1);
      }
    }
  }
  
  private MediaPlayer a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = paramContext.getResources().openRawResourceFd(paramInt);
      if (paramContext == null) {
        return null;
      }
      MediaPlayer localMediaPlayer = new MediaPlayer();
      a(localMediaPlayer);
      localMediaPlayer.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
      paramContext.close();
      localMediaPlayer.prepare();
      return localMediaPlayer;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "createAndSetAudioStreamType  create failed:", paramContext);
      }
    }
    return null;
  }
  
  private MediaPlayer a(Context paramContext, Uri paramUri)
  {
    try
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      a(localMediaPlayer);
      localMediaPlayer.setDataSource(paramContext, paramUri);
      localMediaPlayer.prepare();
      return localMediaPlayer;
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "createAndSetAudioStreamType create failed:", paramContext);
      }
    }
    return null;
  }
  
  static Object a(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws Exception
  {
    paramString = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
    paramString.setAccessible(true);
    return paramString.invoke(paramObject, paramArrayOfObject);
  }
  
  static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject)
    throws Exception
  {
    return a(paramObject, paramString, a(paramArrayOfObject), paramArrayOfObject);
  }
  
  static Object a(String paramString1, String paramString2, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
    throws Exception
  {
    paramString1 = Class.forName(paramString1);
    return paramString1.getDeclaredMethod(paramString2, paramArrayOfClass).invoke(paramString1, paramArrayOfObject);
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", Long.toString(paramLong), "OnlinePush.RespPush");
    Object localObject = BaseApplication.getContext().getPackageName();
    localToServiceMsg.setAppId(((a)this.h.get(localObject)).a);
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.setRequestSsoSeq(paramInt1);
    localToServiceMsg.setNeedCallback(false);
    localObject = new com.tencent.msf.service.protocol.c.b();
    ((com.tencent.msf.service.protocol.c.b)localObject).a = paramLong;
    ((com.tencent.msf.service.protocol.c.b)localObject).c = paramInt2;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("OnlinePush.RespPush");
    localUniPacket.setFuncName("SvcRespPushMsg");
    localUniPacket.setRequestId(paramInt1);
    localUniPacket.put("resp", localObject);
    localToServiceMsg.putWupBuffer(localUniPacket.encode());
    this.b.sender.b(localToServiceMsg);
  }
  
  private void a(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.setAudioStreamType(q());
  }
  
  private void a(String paramString, int paramInt)
  {
    if (com.tencent.mobileqq.msf.service.c.a())
    {
      QLog.d("PCActivePush", 1, "stop tryActiveQQ by mainProcessReady");
      try
      {
        BaseApplication.getContext().unregisterReceiver(this.ax);
        HashMap localHashMap1 = new HashMap();
        localHashMap1.put("account", paramString);
        localHashMap1.put("retryIndex", String.valueOf(paramInt));
        localHashMap1.put("reason", "mainProcessReady");
        this.b.getStatReporter().a("dim.Msf.PCActiveQQResult", true, 0L, 0L, localHashMap1, false, false);
        this.at.set(false);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
        }
      }
    }
    if (paramInt >= com.tencent.mobileqq.msf.core.a.a.I())
    {
      QLog.d("PCActivePush", 1, "stop tryActiveQQ index: " + paramInt);
      try
      {
        BaseApplication.getContext().unregisterReceiver(this.ax);
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("account", paramString);
        localHashMap2.put("retryIndex", String.valueOf(paramInt));
        localHashMap2.put("reason", "tryTooMuch");
        this.b.getStatReporter().a("dim.Msf.PCActiveQQResult", false, 0L, 0L, localHashMap2, false, false);
        this.at.set(false);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
    QLog.d("PCActivePush", 1, "tryActiveQQ index: " + paramInt);
    Intent localIntent = new Intent("com.tencent.mobileqq.broadcast.qq");
    localIntent.putExtra("k_start_mode", 1);
    localIntent.putExtra("k_pcactive_uin", paramString);
    localIntent.putExtra("k_pcactive_retryIndex", paramInt);
    BaseApplication.getContext().sendBroadcast(localIntent);
    this.au = paramString;
    this.av = paramInt;
    localIntent = new Intent("com.tencent.mobileqq.broadcast.pcactiveQQ");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("retryIndex", paramInt + 1);
    this.aw = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, localIntent, 134217728);
    this.j.set(0, System.currentTimeMillis() + 300000, this.aw);
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    
    if (SettingCloneUtil.readValue(paramContext, "" + paramLong, "通知时指示灯闪烁", "qqsetting_notify_blncontrol_key", true))
    {
      boolean bool = SettingCloneUtil.readValue(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg isNoDisturbMode:" + bool);
        }
        int i1 = Calendar.getInstance().get(11);
        if ((i1 < 23) && (i1 >= 8)) {}
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  private boolean a(SharedPreferences paramSharedPreferences)
  {
    try
    {
      if ((this.C != null) && (this.C.size() > 0))
      {
        offlinepush.PbPushOffMsg localPbPushOffMsg = ((a)this.C.get(this.C.size() - 1)).a;
        boolean bool = paramSharedPreferences.contains("special_sound_type" + localPbPushOffMsg.to_uin.get() + localPbPushOffMsg.from_uin.get());
        return bool;
      }
    }
    catch (Exception paramSharedPreferences)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushManager", 2, "-->isSpecialCareSound...exception=" + paramSharedPreferences.getMessage());
      }
      paramSharedPreferences.printStackTrace();
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return (paramString1.equals(paramString2)) || (paramString1.equals(paramString2 + ":video")) || (paramString1.equals(paramString2 + ":QQ"));
  }
  
  static Class[] a(Object[] paramArrayOfObject)
  {
    Object localObject = (Class[])null;
    if (paramArrayOfObject != null)
    {
      Class[] arrayOfClass = new Class[paramArrayOfObject.length];
      int i1 = 0;
      int i2 = paramArrayOfObject.length;
      localObject = arrayOfClass;
      if (i1 < i2)
      {
        if (paramArrayOfObject[i1] != null)
        {
          arrayOfClass[i1] = paramArrayOfObject[i1].getClass();
          label45:
          if (arrayOfClass[i1] != Integer.class) {
            break label79;
          }
          arrayOfClass[i1] = Integer.TYPE;
        }
        for (;;)
        {
          i1 += 1;
          break;
          arrayOfClass[i1] = String.class;
          break label45;
          label79:
          if (arrayOfClass[i1] == Boolean.class) {
            arrayOfClass[i1] = Boolean.TYPE;
          }
        }
      }
    }
    return localObject;
  }
  
  public static boolean b(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    boolean bool;
    if (localTelephonyManager != null) {
      if (localTelephonyManager.getCallState() != 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "isCalling: " + bool);
      }
      return bool;
      int i1;
      try
      {
        if (((Integer)a(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) })).intValue() != 0)
        {
          bool = true;
          continue;
        }
        i1 = ((Integer)a(localTelephonyManager, "getCallStateGemini", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) })).intValue();
        if (i1 != 0) {
          bool = true;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "1 isCalling Exception", localException);
        }
      }
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone2");
        if (paramContext != null) {
          if (paramContext.getCallState() != 0) {
            bool = true;
          }
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
        try
        {
          if (((Integer)a(paramContext, "getCallStateGemini", new Object[] { Integer.valueOf(0) })).intValue() != 0)
          {
            bool = true;
            continue;
          }
          i1 = ((Integer)a(paramContext, "getCallStateGemini", new Object[] { Integer.valueOf(1) })).intValue();
          if (i1 != 0) {
            bool = true;
          }
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "2 isCalling Exception", paramContext);
          }
        }
        try
        {
          paramContext = a("android.telephony.MSimTelephonyManager", "getDefault", null, null);
          if (((Integer)a(paramContext, "getCallState", new Object[] { Integer.valueOf(0) })).intValue() != 0)
          {
            bool = true;
          }
          else
          {
            i1 = ((Integer)a(paramContext, "getCallState", new Object[] { Integer.valueOf(1) })).intValue();
            if (i1 != 0) {
              bool = true;
            } else {
              bool = false;
            }
          }
        }
        catch (Exception paramContext)
        {
          bool = false;
        }
      }
    }
  }
  
  private Object[] b(int paramInt, String paramString)
  {
    if ((paramInt != 3) && (paramInt == 1)) {
      new StringBuilder().append("troop_").append(paramString).toString();
    }
    return new Object[] { Integer.valueOf(paramInt), paramString };
  }
  
  private Object[] b(offlinepush.PbPushOffMsg paramPbPushOffMsg)
  {
    Object localObject5 = null;
    String str;
    int i1;
    if (paramPbPushOffMsg.msg_str.has())
    {
      str = paramPbPushOffMsg.msg_str.get().toStringUtf8();
      i1 = a(paramPbPushOffMsg.msg_type.get(), paramPbPushOffMsg.dwViedoType.get());
      this.l = i1;
    }
    Object localObject1;
    Object localObject4;
    Object localObject3;
    label253:
    long l1;
    switch (i1)
    {
    default: 
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg no msg str exit");
      }
      return null;
    case 0: 
      if ((paramPbPushOffMsg.from_nick.has()) && (paramPbPushOffMsg.from_nick.get().toStringUtf8().length() != 0))
      {
        localObject1 = paramPbPushOffMsg.from_nick.get().toStringUtf8();
        if (!paramPbPushOffMsg.from_uin.has()) {
          break label253;
        }
        paramPbPushOffMsg.from_uin.get();
        paramPbPushOffMsg = a(0, "" + paramPbPushOffMsg.from_uin.get());
        localObject4 = null;
        localObject2 = localObject1;
        localObject3 = localObject5;
        localObject1 = localObject4;
      }
    case 1: 
    case 2: 
      for (;;)
      {
        return new Object[] { Integer.valueOf(i1), str, localObject2, paramPbPushOffMsg, localObject1, localObject3 };
        localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
        break;
        localObject3 = null;
        localObject2 = localObject1;
        paramPbPushOffMsg = "";
        localObject1 = localObject3;
        localObject3 = localObject5;
        continue;
        if (paramPbPushOffMsg.discuss_info.has())
        {
          if (paramPbPushOffMsg.discuss_info.discuss_remark.has())
          {
            localObject1 = paramPbPushOffMsg.discuss_info.discuss_remark.get().toStringUtf8();
            label312:
            if (!paramPbPushOffMsg.discuss_info.dis_name.has()) {
              break label467;
            }
          }
          label467:
          for (localObject2 = paramPbPushOffMsg.discuss_info.dis_name.get().toStringUtf8();; localObject2 = Long.toString(paramPbPushOffMsg.discuss_info.discuss_uin.get()))
          {
            if (!paramPbPushOffMsg.discuss_info.discuss_uin.has()) {
              break label502;
            }
            l1 = paramPbPushOffMsg.discuss_info.discuss_uin.get();
            if (localObject2 != null)
            {
              localObject3 = localObject2;
              if (((String)localObject2).length() != 0) {}
            }
            else
            {
              localObject3 = Long.toString(l1);
            }
            paramPbPushOffMsg = a(3, "" + l1);
            localObject2 = localObject1;
            localObject1 = localObject3;
            localObject3 = localObject5;
            break;
            if (paramPbPushOffMsg.from_nick.has())
            {
              localObject1 = paramPbPushOffMsg.from_nick.get().toStringUtf8();
              break label312;
            }
            localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
            break label312;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get discuss msg, but no msg.discuss_info exit");
        }
        return null;
        label502:
        localObject4 = localObject1;
        paramPbPushOffMsg = "";
        localObject1 = localObject2;
        localObject3 = localObject5;
        localObject2 = localObject4;
        continue;
        if (paramPbPushOffMsg.c2c_tmp_msg_head.has())
        {
          if ((paramPbPushOffMsg.from_nick.has()) && (paramPbPushOffMsg.from_nick.get().toStringUtf8().length() != 0)) {
            localObject1 = paramPbPushOffMsg.from_nick.get().toStringUtf8();
          }
          for (;;)
          {
            if (!paramPbPushOffMsg.c2c_tmp_msg_head.group_uin.has()) {
              break label779;
            }
            l1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_uin.get();
            paramPbPushOffMsg = a(3, "" + l1);
            localObject3 = null;
            localObject2 = localObject1;
            localObject1 = localObject3;
            localObject3 = localObject5;
            break;
            if (paramPbPushOffMsg.c2c_tmp_msg_head.discuss_remark.has())
            {
              localObject1 = paramPbPushOffMsg.c2c_tmp_msg_head.discuss_remark.get().toStringUtf8();
            }
            else if (paramPbPushOffMsg.c2c_tmp_msg_head.group_card.has())
            {
              localObject1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_card.get().toStringUtf8();
            }
            else if (paramPbPushOffMsg.c2c_tmp_msg_head.group_name.has())
            {
              localObject1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_name.get().toStringUtf8();
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get c2c temp msg, no nick find use from_uin");
              }
              localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get c2c temp msg, but no msg.c2c_tmp_msg_head exit");
        }
        return null;
        label779:
        if (paramPbPushOffMsg.c2c_tmp_msg_head.group_code.has())
        {
          l1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_code.get();
          paramPbPushOffMsg = a(3, "" + l1);
          localObject3 = null;
          localObject2 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject5;
        }
        else
        {
          localObject3 = null;
          localObject2 = localObject1;
          paramPbPushOffMsg = "";
          localObject1 = localObject3;
          localObject3 = localObject5;
        }
      }
    }
    if (paramPbPushOffMsg.group_info.has()) {
      if (paramPbPushOffMsg.group_info.group_card.has())
      {
        localObject1 = paramPbPushOffMsg.group_info.group_card.get().toStringUtf8();
        label905:
        if (!paramPbPushOffMsg.group_info.group_name.has()) {
          break label1085;
        }
      }
    }
    label1085:
    for (Object localObject2 = paramPbPushOffMsg.group_info.group_name.get().toStringUtf8();; localObject2 = null)
    {
      if (paramPbPushOffMsg.group_info.group_code.has())
      {
        l1 = paramPbPushOffMsg.group_info.group_code.get();
        if (localObject2 != null)
        {
          paramPbPushOffMsg = (offlinepush.PbPushOffMsg)localObject2;
          if (((String)localObject2).length() != 0) {}
        }
        else
        {
          paramPbPushOffMsg = Long.toString(l1);
        }
        localObject3 = a(1, "" + l1);
        localObject4 = null;
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = paramPbPushOffMsg;
        paramPbPushOffMsg = (offlinepush.PbPushOffMsg)localObject1;
        localObject1 = localObject4;
        break;
        localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
        break label905;
      }
      localObject3 = null;
      localObject4 = localObject1;
      paramPbPushOffMsg = "";
      localObject1 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject4;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get troop msg, but no msg.group_info exit");
      }
      return null;
    }
  }
  
  private Object[] b(boolean paramBoolean)
  {
    Object[] arrayOfObject;
    Object localObject;
    String str1;
    String str2;
    String str3;
    long l1;
    if ((this.C.size() == 1) && (!paramBoolean))
    {
      arrayOfObject = new Object[4];
      localObject = b(((a)this.C.get(0)).a);
      if (localObject == null) {
        return null;
      }
      switch (((Integer)localObject[0]).intValue())
      {
      default: 
        return null;
      case 0: 
      case 2: 
        str1 = "[离线消息]" + localObject[2] + ":" + localObject[1];
        str2 = localObject[2] + "[离线消息]";
        str3 = (String)localObject[1];
        arrayOfObject[0] = str1;
        arrayOfObject[1] = str2;
        arrayOfObject[2] = str3;
        arrayOfObject[3] = localObject[3];
        return arrayOfObject;
      case 1: 
        str1 = "[离线消息]" + localObject[2] + "(" + localObject[4] + "):" + localObject[1];
        str2 = localObject[4] + "[离线消息]";
        str3 = localObject[2] + ":" + localObject[1];
        arrayOfObject[0] = str1;
        arrayOfObject[1] = str2;
        arrayOfObject[2] = str3;
        arrayOfObject[3] = localObject[3];
        return arrayOfObject;
      }
      if (!((a)this.C.get(0)).a.msg_flag.has()) {
        break label1810;
      }
      l1 = ((a)this.C.get(0)).a.msg_flag.get();
      if ((0x2 & l1) == 2L) {
        str1 = "[有人@我]";
      }
    }
    for (;;)
    {
      str2 = "[离线消息]" + str1 + localObject[2] + ":" + localObject[1];
      str3 = localObject[5] + "[离线消息]";
      str1 = str1 + localObject[2] + ":" + localObject[1];
      arrayOfObject[0] = str2;
      arrayOfObject[1] = str3;
      arrayOfObject[2] = str1;
      arrayOfObject[3] = localObject[3];
      return arrayOfObject;
      if ((l1 & 1L) == 1L)
      {
        str1 = "[特别关注]";
        continue;
        int i1 = r();
        if ((i1 == 1) && (!paramBoolean))
        {
          arrayOfObject = b(((a)this.C.get(this.C.size() - 1)).a);
          if (arrayOfObject == null) {
            return null;
          }
          localObject = new Object[4];
          switch (((Integer)arrayOfObject[0]).intValue())
          {
          default: 
            return null;
          case 0: 
          case 2: 
            str1 = "[离线消息]" + arrayOfObject[2] + ":" + arrayOfObject[1];
            str2 = arrayOfObject[2] + "[" + this.C.size() + "条离线消息]";
            str3 = (String)arrayOfObject[1];
            localObject[0] = str1;
            localObject[1] = str2;
            localObject[2] = str3;
            localObject[3] = arrayOfObject[3];
            return localObject;
          case 1: 
            int i2 = s();
            if (i2 == 1) {}
            for (i1 = 1; i1 != 0; i1 = 0)
            {
              str1 = "[离线消息]" + arrayOfObject[2] + "(" + arrayOfObject[4] + "):" + arrayOfObject[1];
              str2 = arrayOfObject[4] + "[" + this.C.size() + "条离线消息]";
              str3 = arrayOfObject[2] + ":" + arrayOfObject[1];
              localObject[0] = str1;
              localObject[1] = str2;
              localObject[2] = str3;
              localObject[3] = arrayOfObject[3];
              return localObject;
            }
            localObject[2] = ("有" + i2 + "个联系人给你发来" + this.C.size() + "条离线消息");
            localObject[3] = arrayOfObject[3];
            localObject[1] = "QQ[离线消息]";
            localObject[0] = ("[离线消息]" + arrayOfObject[2] + "(" + arrayOfObject[4] + "):" + arrayOfObject[1]);
            return localObject;
          }
          if (!((a)this.C.get(0)).a.msg_flag.has()) {
            break label1803;
          }
          l1 = ((a)this.C.get(this.C.size() - 1)).a.msg_flag.get();
          if ((0x2 & l1) == 2L) {
            str1 = "[有人@我]";
          }
        }
        for (;;)
        {
          str2 = "[离线消息]" + str1 + arrayOfObject[2] + ":" + arrayOfObject[1];
          str3 = arrayOfObject[5] + "[" + this.C.size() + "条离线消息]";
          str1 = str1 + arrayOfObject[2] + ":" + arrayOfObject[1];
          localObject[0] = str2;
          localObject[1] = str3;
          localObject[2] = str1;
          localObject[3] = arrayOfObject[3];
          return localObject;
          if ((l1 & 1L) == 1L)
          {
            str1 = "[特别关注]";
            continue;
            arrayOfObject = b(((a)this.C.get(this.C.size() - 1)).a);
            if (arrayOfObject == null) {
              return null;
            }
            switch (((Integer)arrayOfObject[0]).intValue())
            {
            default: 
              break;
            case 0: 
            case 2: 
              str1 = "有" + i1 + "个联系人给你发来" + this.C.size() + "条离线消息";
              localObject = arrayOfObject[3];
              return new Object[] { "[离线消息]" + arrayOfObject[2] + ":" + arrayOfObject[1], "QQ[离线消息]", str1, localObject };
            case 1: 
              str1 = "有" + i1 + "个联系人给你发来" + this.C.size() + "条离线消息";
              localObject = arrayOfObject[3];
              return new Object[] { "[离线消息]" + arrayOfObject[2] + "(" + arrayOfObject[4] + "):" + arrayOfObject[1], "QQ[离线消息]", str1, localObject };
            case 3: 
              if (((a)this.C.get(0)).a.msg_flag.has())
              {
                l1 = ((a)this.C.get(this.C.size() - 1)).a.msg_flag.get();
                if ((0x2 & l1) == 2L) {
                  str1 = "[有人@我]";
                }
              }
              for (;;)
              {
                return new Object[] { "[离线消息]" + str1 + arrayOfObject[2] + ":" + arrayOfObject[1], "QQ[离线消息]", "有" + i1 + "个联系人给你发来" + this.C.size() + "条离线消息", arrayOfObject[3] };
                if ((l1 & 1L) == 1L) {
                  str1 = "[特别关注]";
                } else {
                  str1 = "";
                }
              }
            }
          }
          label1803:
          str1 = "";
        }
      }
      else
      {
        label1810:
        str1 = "";
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    offlinepush.PbPushOffMsg localPbPushOffMsg;
    Context localContext;
    if (this.C.size() > 0)
    {
      localPbPushOffMsg = ((a)this.C.get(0)).a;
      localContext = BaseApplication.getContext();
      localObject1 = b(paramBoolean);
      if (localObject1 == null) {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "Decode Message error, exit now");
        }
      }
    }
    else
    {
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(y);
      return;
    }
    Object localObject2 = (String)localObject1[0];
    Object localObject3 = (String)localObject1[1];
    String str = (String)localObject1[2];
    Object localObject1 = BitmapFactory.decodeFile((String)localObject1[3]);
    if (localObject1 != null) {
      localObject1 = a((Bitmap)localObject1, 50, 50);
    }
    for (;;)
    {
      for (;;)
      {
        NotificationManager localNotificationManager = (NotificationManager)localContext.getSystemService("notification");
        localObject2 = new NotificationCompat.Builder(localContext).setContentTitle((CharSequence)localObject3).setContentText(str).setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis());
        label189:
        int i1;
        if (localObject1 != null)
        {
          ((NotificationCompat.Builder)localObject2).setLargeIcon((Bitmap)localObject1);
          if (Build.VERSION.SDK_INT < 11) {
            ((NotificationCompat.Builder)localObject2).setSmallIcon(BaseApplication.qqlaunchicon);
          }
          if (a(localContext, localPbPushOffMsg.to_uin.get()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.PushManager", 2, "isShowNofityLight=true");
            }
            i1 = Calendar.getInstance().get(11);
            if ((i1 < 23) && (i1 < 8)) {}
            ((NotificationCompat.Builder)localObject2).setLights(-16711936, 2000, 2000);
          }
          ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getBroadcast(localContext, 0, new Intent("com.tencent.mobileqq.msf.receiveofflinepush"), 0));
          ((NotificationCompat.Builder)localObject2).setDeleteIntent(PendingIntent.getBroadcast(localContext, 0, new Intent("com.tencent.mobileqq.msf.offlinepushclearall"), 0));
          localObject1 = ((NotificationCompat.Builder)localObject2).build();
          if (localNotificationManager != null) {
            localNotificationManager.cancel(y);
          }
          localNotificationManager.notify(y, (Notification)localObject1);
          localObject1 = PreferenceManager.getDefaultSharedPreferences(localContext);
          localObject2 = localContext.getSharedPreferences("com.tencent.mobileqq_preferences", 4);
          if (c(String.valueOf(localPbPushOffMsg.to_uin.get()), localContext) != 0) {
            break label774;
          }
          if (a(String.valueOf(localPbPushOffMsg.to_uin.get()), localContext) != 1) {
            break label769;
          }
          i1 = 1;
          label405:
          if ((b(String.valueOf(localPbPushOffMsg.to_uin.get()), localContext) == 1) && (w()))
          {
            localObject3 = (Vibrator)localContext.getSystemService("vibrator");
            if (!a((SharedPreferences)localObject2)) {
              break label805;
            }
            ((Vibrator)localObject3).vibrate(1000L);
          }
          label463:
          if ((i1 != 0) && (v()))
          {
            if (QLog.isColorLevel()) {
              QLog.i("PushManager", 2, "-->isSpecialCareSound:" + a((SharedPreferences)localObject2));
            }
            if (a((SharedPreferences)localObject2))
            {
              i1 = ((SharedPreferences)localObject1).getInt("sound_type" + localPbPushOffMsg.to_uin.get(), BaseApplication.defaultNotifSoundResourceId);
              i1 = ((SharedPreferences)localObject2).getInt("special_sound_type" + ((a)this.C.get(this.C.size() - 1)).a.to_uin.get() + ((a)this.C.get(this.C.size() - 1)).a.from_uin.get(), i1);
              if (i1 != 1) {
                break label817;
              }
            }
          }
        }
        try
        {
          ((SharedPreferences)localObject2).getInt("defaulut_special_sound_source" + i1, i1);
          label769:
          label774:
          label805:
          label817:
          do
          {
            if ((a(String.valueOf(localPbPushOffMsg.to_uin.get()), localContext) != 1) || (!v())) {
              break;
            }
            a(((SharedPreferences)localObject1).getInt("sound_type" + localPbPushOffMsg.to_uin.get(), BaseApplication.defaultNotifSoundResourceId), false);
            return;
            ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapFactory.decodeResource(localContext.getResources(), BaseApplication.qqlaunchicon));
            break label189;
            i1 = 0;
            break label405;
            if (c(String.valueOf(localPbPushOffMsg.to_uin.get()), localContext) == 1) {}
            for (i1 = 1;; i1 = 0) {
              break;
            }
            ((Vibrator)localObject3).vibrate(ar, -1);
            break label463;
            localObject2 = ((SharedPreferences)localObject2).getString("special_sound_url" + i1, "");
          } while (TextUtils.isEmpty((CharSequence)localObject2));
          localObject2 = new File(BaseApplication.getContext().getFilesDir(), (String)localObject2);
          if (((File)localObject2).exists())
          {
            a(((File)localObject2).getAbsolutePath(), false);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("PushManager", 2, "special sound play exception|" + localException.getMessage());
            }
            localException.printStackTrace();
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("PushManager", 2, "-->special sound not exist.");
            }
          }
        }
      }
    }
  }
  
  private boolean c(offlinepush.PbPushOffMsg paramPbPushOffMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg msg_type:0x" + Integer.toHexString(paramPbPushOffMsg.msg_type.get()) + " dwViedoType:" + paramPbPushOffMsg.dwViedoType.get());
    }
    return (paramPbPushOffMsg.msg_type.get() == 734) || (paramPbPushOffMsg.msg_type.get() == 215) || (paramPbPushOffMsg.msg_type.get() == 519);
  }
  
  private void e(String paramString)
  {
    a locala = (a)this.h.get(paramString);
    locala.n = String.valueOf(com.tencent.mobileqq.msf.core.c.e(BaseApplication.getContext()));
    JceOutputStream localJceOutputStream = new JceOutputStream();
    locala.writeTo(localJceOutputStream);
    MsfStore.getNativeConfigStore().setConfig("app_push_info_" + paramString, HexUtil.bytes2HexStr(localJceOutputStream.toByteArray()));
  }
  
  private int r()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.C.iterator();
    label106:
    for (;;)
    {
      Long localLong;
      if (localIterator1.hasNext())
      {
        localLong = Long.valueOf(((a)localIterator1.next()).a.from_uin.get());
        Iterator localIterator2 = localArrayList.iterator();
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
        } while (!((Long)localIterator2.next()).equals(localLong));
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label106;
        }
        localArrayList.add(localLong);
        break;
        return localArrayList.size();
      }
    }
  }
  
  private int s()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.C.iterator();
    label178:
    for (;;)
    {
      Object localObject;
      if (localIterator1.hasNext())
      {
        localObject = (a)localIterator1.next();
        switch (a(((a)localObject).a.msg_type.get(), ((a)localObject).a.dwViedoType.get()))
        {
        case 0: 
        default: 
          break;
        case 1: 
          if (!((a)localObject).a.discuss_info.has()) {
            continue;
          }
          localObject = Long.valueOf(((a)localObject).a.discuss_info.discuss_uin.get());
          Iterator localIterator2 = localArrayList.iterator();
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
          } while (!((Long)localIterator2.next()).equals(localObject));
        }
      }
      else
      {
        for (int i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            break label178;
          }
          localArrayList.add(localObject);
          break;
          return localArrayList.size();
        }
      }
    }
  }
  
  private Object[] t()
  {
    Object[] arrayOfObject1;
    Object[] arrayOfObject2;
    Object localObject;
    String str2;
    String str1;
    if (this.D.size() == 1)
    {
      arrayOfObject1 = new Object[4];
      arrayOfObject2 = b(((a)this.D.get(0)).a);
      if (arrayOfObject2 == null) {
        return null;
      }
      switch (((Integer)arrayOfObject2[0]).intValue())
      {
      default: 
        return null;
      case 0: 
      case 2: 
        localObject = "[离线消息]" + arrayOfObject2[2] + ":" + arrayOfObject2[1];
        str2 = arrayOfObject2[2] + "[离线消息]";
        str1 = (String)arrayOfObject2[1];
        if (b(BaseApplication.getContext())) {
          if (((String)arrayOfObject2[1]).contains("视频"))
          {
            localObject = arrayOfObject2[2] + "给你发起过视频通话，请结束当前电话后回拨。";
            str1 = "给你发起过视频通话，请结束当前电话后回拨。";
            if (((String)arrayOfObject2[1]).contains("语音"))
            {
              str1 = "给你发起过语音通话，请结束当前电话后回拨。";
              localObject = arrayOfObject2[2] + "给你发起过语音通话，请结束当前电话后回拨。";
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      arrayOfObject1[0] = localObject;
      arrayOfObject1[1] = str2;
      arrayOfObject1[2] = str1;
      arrayOfObject1[3] = arrayOfObject2[3];
      return arrayOfObject1;
      localObject = "[离线消息]" + arrayOfObject2[2] + "(" + arrayOfObject2[4] + "):" + arrayOfObject2[1];
      str1 = arrayOfObject2[4] + "[离线消息]";
      str2 = arrayOfObject2[2] + ":" + arrayOfObject2[1];
      arrayOfObject1[0] = localObject;
      arrayOfObject1[1] = str1;
      arrayOfObject1[2] = str2;
      arrayOfObject1[3] = arrayOfObject2[3];
      return arrayOfObject1;
      localObject = new Object[4];
      str1 = "收到" + this.D.size() + "个未接来电";
      localObject[2] = str1;
      localObject[1] = "QQ[离线消息]";
      localObject[0] = ("[离线消息]QQ " + str1);
      return localObject;
      break;
    }
  }
  
  private void u()
  {
    offlinepush.PbPushOffMsg localPbPushOffMsg;
    Context localContext;
    if (this.D.size() > 0)
    {
      localPbPushOffMsg = ((a)this.D.get(0)).a;
      localContext = BaseApplication.getContext();
      localObject1 = t();
      if (localObject1 == null) {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "Decode Message error, exit now");
        }
      }
    }
    else
    {
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(z);
      return;
    }
    Object localObject2 = (String)localObject1[0];
    String str1 = (String)localObject1[1];
    String str2 = (String)localObject1[2];
    Object localObject1 = BitmapFactory.decodeFile((String)localObject1[3]);
    if (localObject1 != null) {
      localObject1 = a((Bitmap)localObject1, 50, 50);
    }
    for (;;)
    {
      NotificationManager localNotificationManager = (NotificationManager)localContext.getSystemService("notification");
      localObject2 = new NotificationCompat.Builder(localContext).setContentTitle(str1).setContentText(str2).setAutoCancel(true).setSmallIcon(BaseApplication.appnewavmsgicon).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis());
      if (localObject1 != null) {
        ((NotificationCompat.Builder)localObject2).setLargeIcon((Bitmap)localObject1);
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT < 11) {
          ((NotificationCompat.Builder)localObject2).setSmallIcon(BaseApplication.qqlaunchicon);
        }
        if (a(localContext, localPbPushOffMsg.to_uin.get()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "isShowNofityLight=true");
          }
          int i1 = Calendar.getInstance().get(11);
          if ((i1 < 23) && (i1 < 8)) {}
          ((NotificationCompat.Builder)localObject2).setLights(-16711936, 2000, 2000);
        }
        ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getBroadcast(localContext, 0, new Intent("com.tencent.mobileqq.msf.receiveofflinepushav"), 0));
        ((NotificationCompat.Builder)localObject2).setDeleteIntent(PendingIntent.getBroadcast(localContext, 0, new Intent("com.tencent.mobileqq.msf.offlinepushclearallav"), 0));
        localObject1 = ((NotificationCompat.Builder)localObject2).build();
        if (localNotificationManager != null) {
          localNotificationManager.cancel(z);
        }
        localNotificationManager.notify(z, (Notification)localObject1);
        if ((a(String.valueOf(localPbPushOffMsg.to_uin.get()), localContext) == 1) && (v())) {
          a(PreferenceManager.getDefaultSharedPreferences(localContext).getInt("sound_type" + localPbPushOffMsg.to_uin.get(), BaseApplication.defaultNotifSoundResourceId), false);
        }
        if ((b(String.valueOf(localPbPushOffMsg.to_uin.get()), localContext) != 1) || (!w())) {
          break;
        }
        ((Vibrator)localContext.getSystemService("vibrator")).vibrate(ar, -1);
        return;
        ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapFactory.decodeResource(localContext.getResources(), BaseApplication.qqlaunchicon));
      }
    }
  }
  
  private boolean v()
  {
    return com.tencent.qphone.base.util.a.b();
  }
  
  private boolean w()
  {
    return (com.tencent.qphone.base.util.a.d()) || ((com.tencent.qphone.base.util.a.b()) && (com.tencent.qphone.base.util.a.c()));
  }
  
  public int a(String paramString)
  {
    Iterator localIterator = this.h.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.h.get(localObject);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).k.uin.equals(paramString)))
      {
        if (((a)localObject).c == 0L) {
          return -2;
        }
        return ((a)localObject).k.iStatus;
      }
    }
    return -1;
  }
  
  public int a(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 1;
    }
    paramString = paramContext.getSharedPreferences(paramString, 4).getString(this.ag, String.valueOf(1));
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 1;
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject = BaseApplication.getContext().getFilesDir().getPath();
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      localStringBuilder.append(this.W);
      localObject = b(paramInt, paramString);
      switch (((Integer)localObject[0]).intValue())
      {
      }
    }
    for (;;)
    {
      localObject = MD5.toMD5(paramString);
      localObject = MD5.toMD5((String)localObject + paramString);
      localStringBuilder.append(MD5.toMD5((String)localObject + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append((String)localObject + this.Y);
      break;
      localStringBuilder.append("troop_sys_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("sys_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("discussion_");
      continue;
      localStringBuilder.append("troop_");
    }
  }
  
  public void a()
  {
    try
    {
      if (!this.m)
      {
        this.k.start();
        this.m = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   6: ifnull +30 -> 36
    //   9: aload_0
    //   10: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   13: invokevirtual 1366	android/media/MediaPlayer:isPlaying	()Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   28: invokevirtual 1369	android/media/MediaPlayer:release	()V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   36: iload_1
    //   37: sipush 1000
    //   40: if_icmpeq +72 -> 112
    //   43: aload_0
    //   44: aload_0
    //   45: invokestatic 464	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   48: iload_1
    //   49: invokespecial 1371	com/tencent/mobileqq/msf/core/push/f:a	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   52: putfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   55: aload_0
    //   56: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   59: ifnull -38 -> 21
    //   62: aload_0
    //   63: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   66: new 1373	com/tencent/mobileqq/msf/core/push/j
    //   69: dup
    //   70: aload_0
    //   71: invokespecial 1374	com/tencent/mobileqq/msf/core/push/j:<init>	(Lcom/tencent/mobileqq/msf/core/push/f;)V
    //   74: invokevirtual 1378	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   77: aload_0
    //   78: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   81: invokevirtual 1379	android/media/MediaPlayer:start	()V
    //   84: aload_0
    //   85: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   88: iload_2
    //   89: invokevirtual 1382	android/media/MediaPlayer:setLooping	(Z)V
    //   92: goto -71 -> 21
    //   95: astore 4
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   102: aload 4
    //   104: athrow
    //   105: astore 4
    //   107: aload_0
    //   108: monitorexit
    //   109: aload 4
    //   111: athrow
    //   112: aload_0
    //   113: aload_0
    //   114: invokestatic 464	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   117: getstatic 1388	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   120: invokespecial 1390	com/tencent/mobileqq/msf/core/push/f:a	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   123: putfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   126: goto -71 -> 55
    //   129: astore 4
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   136: goto -100 -> 36
    //   139: astore 4
    //   141: goto -120 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	f
    //   0	144	1	paramInt	int
    //   0	144	2	paramBoolean	boolean
    //   16	2	3	bool	boolean
    //   95	8	4	localObject1	Object
    //   105	5	4	localObject2	Object
    //   129	1	4	localException1	Exception
    //   139	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	31	95	finally
    //   2	17	105	finally
    //   31	36	105	finally
    //   43	55	105	finally
    //   55	92	105	finally
    //   97	105	105	finally
    //   112	126	105	finally
    //   131	136	105	finally
    //   24	31	129	java/lang/Exception
    //   2	17	139	java/lang/Exception
    //   31	36	139	java/lang/Exception
    //   43	55	139	java/lang/Exception
    //   55	92	139	java/lang/Exception
    //   97	105	139	java/lang/Exception
    //   112	126	139	java/lang/Exception
    //   131	136	139	java/lang/Exception
  }
  
  public void a(long paramLong)
  {
    long l1;
    if (paramLong < 30000L)
    {
      if (!QLog.isColorLevel()) {
        break label202;
      }
      QLog.d("MSF.C.PushManager", 2, "queryPushIntervTime less than 30000,change to 30000.");
      l1 = 30000L;
    }
    for (;;)
    {
      if (this.am != null) {
        a(BaseApplication.getContext());
      }
      Intent localIntent = new Intent(this.d);
      localIntent.setAction(this.d);
      this.am = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, localIntent, 0);
      this.j = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
      this.j.set(0, System.currentTimeMillis() + l1, this.am);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "register " + this.d + " alarm alive send at " + g.format(Long.valueOf(System.currentTimeMillis() + l1)));
      }
      return;
      l1 = paramLong;
      if (paramLong > 3600000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "queryPushIntervTime greater than 600000 ,change to 600000.");
        }
        l1 = 3600000L;
        continue;
        label202:
        l1 = 30000L;
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.am != null) {
      this.j.cancel(this.am);
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    this.c = (Build.MODEL + "|" + Build.VERSION.RELEASE);
    this.d = (MsfSdkUtils.getProcessName(paramContext) + "_" + getClass().hashCode());
    paramContext = new IntentFilter();
    paramContext.addAction(this.d);
    BaseApplication.getContext().registerReceiver(this, paramContext);
    this.j = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    a(paramBoolean);
  }
  
  public void a(a parama, m paramm)
  {
    if (parama.c > 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "send " + parama.b + " push register, pushId is " + parama.c);
      }
      this.i.a(parama, null, false, paramm);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MSF.C.PushManager", 2, parama.b + " queryPushId is " + parama.c + " ,skip register.");
  }
  
  public void a(CommandCallbackerInfo paramCommandCallbackerInfo, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      String str = com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " appCmdCallbacker " + paramCommandCallbackerInfo);
      }
      if (!this.h.containsKey(str)) {
        this.h.putIfAbsent(str, new a(str));
      }
      ((a)this.h.get(str)).m = paramCommandCallbackerInfo;
      paramCommandCallbackerInfo = com.tencent.mobileqq.msf.service.h.a(paramToServiceMsg);
      paramCommandCallbackerInfo.setMsgSuccess();
      this.b.addRespToQuque(paramToServiceMsg, paramCommandCallbackerInfo);
      e(str);
      return;
    }
    finally {}
  }
  
  public void a(PushRegisterInfo paramPushRegisterInfo, ToServiceMsg paramToServiceMsg)
  {
    String str;
    try
    {
      str = com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg);
      if (!a(str, BaseApplication.getContext().getPackageName())) {
        break label322;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv unRegisterPush ");
      }
      if (!this.h.containsKey(str)) {
        this.h.putIfAbsent(str, new a(str));
      }
      ((a)this.h.get(str)).k = paramPushRegisterInfo;
      ((a)this.h.get(str)).a = paramToServiceMsg.getAppId();
      ((a)this.h.get(str)).c = 0L;
      this.i.a((a)this.h.get(str), paramToServiceMsg, true, m.b);
      paramToServiceMsg = ((a)this.h.get(str)).k.pushIds;
      paramPushRegisterInfo = paramPushRegisterInfo.pushIds;
      ArrayList localArrayList = new ArrayList();
      paramToServiceMsg = paramToServiceMsg.iterator();
      while (paramToServiceMsg.hasNext())
      {
        long l1 = ((Long)paramToServiceMsg.next()).longValue();
        if (!paramPushRegisterInfo.contains(Long.valueOf(l1))) {
          localArrayList.add(Long.valueOf(l1));
        }
      }
      ((a)this.h.get(str)).k.pushIds = localArrayList;
    }
    finally {}
    if (((a)this.h.get(str)).c == 0L) {
      ((a)this.h.get(str)).k = null;
    }
    e(str);
    for (;;)
    {
      return;
      label322:
      if (QLog.isColorLevel()) {
        QLog.e("MSF.C.PushManager", 2, "recv other processName:" + str + " recv unRegisterPush ");
      }
    }
  }
  
  public void a(com.tencent.mobileqq.msf.sdk.m paramm, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg) + " recv ProxyRegisterInfo " + paramm);
      }
      if (!this.h.containsKey(paramm.b)) {
        this.h.putIfAbsent(paramm.b, new a(paramm.b));
      }
      Object localObject = (a)this.h.get(paramm.b);
      ((a)localObject).a = paramm.a;
      ((a)localObject).m = paramm.e;
      ((a)localObject).l = paramm.d;
      localObject = com.tencent.mobileqq.msf.core.l.a(paramToServiceMsg);
      ((FromServiceMsg)localObject).setMsgSuccess();
      this.b.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject);
      e(paramm.b);
      return;
    }
    finally {}
  }
  
  public void a(offlinepush.PbPushOffMsg paramPbPushOffMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onRecvDevlockQuickloginOfflinePush start...");
    }
    try
    {
      if (paramPbPushOffMsg.msg_str.has())
      {
        paramPbPushOffMsg = new String(paramPbPushOffMsg.msg_str.get().toByteArray(), "utf-8");
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvDevlockQuickloginOfflinePush  maintip=" + paramPbPushOffMsg);
        }
        localContext = BaseApplication.getContext();
        Bitmap localBitmap = BitmapFactory.decodeResource(localContext.getResources(), BaseApplication.devlockQuickloginIcon);
        Object localObject = localBitmap;
        if (localBitmap != null) {
          localObject = a(localBitmap, 50, 50);
        }
        paramPbPushOffMsg = new NotificationCompat.Builder(localContext).setContentTitle("一键验证").setContentText(paramPbPushOffMsg).setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker("一键验证").setWhen(System.currentTimeMillis());
        if (localObject == null) {
          break label289;
        }
        paramPbPushOffMsg.setLargeIcon((Bitmap)localObject);
        if (Build.VERSION.SDK_INT < 11) {
          paramPbPushOffMsg.setSmallIcon(BaseApplication.qqlaunchicon);
        }
        paramPbPushOffMsg.setContentIntent(PendingIntent.getBroadcast(localContext, 0, new Intent("com.tencent.mobileqq.msf.receiveofflinepush"), 0));
        paramPbPushOffMsg.setDeleteIntent(PendingIntent.getBroadcast(localContext, 0, new Intent("com.tencent.mobileqq.msf.devlockquickloginpushclear"), 0));
        paramPbPushOffMsg = paramPbPushOffMsg.build();
        localObject = (NotificationManager)localContext.getSystemService("notification");
        if (localObject != null)
        {
          ((NotificationManager)localObject).cancel(A);
          ((NotificationManager)localObject).notify(A, paramPbPushOffMsg);
          this.S.removeMessages(20140416);
          this.S.sendEmptyMessageDelayed(20140416, 120000L);
        }
      }
    }
    catch (Exception paramPbPushOffMsg)
    {
      for (;;)
      {
        Context localContext;
        paramPbPushOffMsg.printStackTrace();
        paramPbPushOffMsg = null;
        continue;
        label289:
        paramPbPushOffMsg.setLargeIcon(BitmapFactory.decodeResource(localContext.getResources(), BaseApplication.qqlaunchicon));
      }
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onConnClosed " + parama);
    }
    p = false;
    this.i.d = false;
    this.x = 0L;
    this.aq = 0L;
    parama = new h(this);
    parama.setName("onConnClosedPushThread");
    parama.start();
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    Iterator localIterator = this.h.keySet().iterator();
    int i1 = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = (a)this.h.get(localObject);
        if (localObject != null) {
          if (paramFromServiceMsg.getServiceCmd().equals("CliNotifySvc.SvcReqPush"))
          {
            localObject = new UniPacket(true);
            ((UniPacket)localObject).setEncodeName("UTF-8");
            try
            {
              ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
            }
            catch (Throwable paramFromServiceMsg)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager", 2, "decode PushMsg error " + paramFromServiceMsg, paramFromServiceMsg);
              }
            }
          }
        }
      }
    }
    while ((i1 != 0) || (!QLog.isColorLevel())) {
      for (;;)
      {
        Object localObject;
        return;
        if (paramFromServiceMsg.getServiceCmd().equals("StatSvc.QueryHB"))
        {
          if (com.tencent.mobileqq.msf.core.a.a.t)
          {
            ((a)localObject).i = this.b.nowSocketConnAdd;
            ((a)localObject).f = System.currentTimeMillis();
            a((a)localObject, m.f);
            i1 = 1;
          }
          else if (QLog.isColorLevel())
          {
            QLog.e("MSF.C.PushManager", 2, "recv push StatSvc.QueryHB, but do not support useAnyPacketAsPushHB ");
          }
        }
        else if (paramFromServiceMsg.isSuccess())
        {
          if (a((a)localObject, paramFromServiceMsg)) {
            i1 = 1;
          }
        }
        else
        {
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
            e.a().a(e.a.c, paramFromServiceMsg.getWupBuffer(), 3);
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "recv error onRecvPushMsg FromServiceMsg  " + paramFromServiceMsg);
          }
        }
      }
    }
    QLog.w("MSF.C.PushManager", 2, "found not handle push msg " + paramFromServiceMsg);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    this.i.a(paramFromServiceMsg, paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, m paramm)
  {
    if (this.ao.hasMessages(1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "remove message handler mLoadPushInfoHandler");
      }
      this.ao.removeMessages(1);
    }
    String str = com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg);
    if (a(str, BaseApplication.getContext().getPackageName()))
    {
      if (!this.h.containsKey(str)) {
        this.h.putIfAbsent(str, new a(str));
      }
      localPushRegisterInfo = n.b(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv regPush ");
      }
      locala = (a)this.h.get(str);
      if ((locala != null) && (locala.k != null) && (locala.c != 0L) && (locala.k.uin.equals(localPushRegisterInfo.uin)) && (locala.k.iStatus == localPushRegisterInfo.iStatus) && (locala.k.bKikPC == localPushRegisterInfo.bKikPC) && (locala.k.bKikWeak == localPushRegisterInfo.bKikWeak) && (locala.k.timeStamp == localPushRegisterInfo.timeStamp) && (locala.k.iLargeSeq == localPushRegisterInfo.iLargeSeq))
      {
        if (QLog.isColorLevel()) {
          QLog.e("MSF.C.PushManager", 2, "handlerPush also register Push " + MD5.toMD5(localPushRegisterInfo.uin) + "iStatus:" + localPushRegisterInfo.iStatus);
        }
        paramm = com.tencent.mobileqq.msf.service.h.a(paramToServiceMsg);
        paramm.setMsgSuccess();
        this.b.addRespToQuque(paramToServiceMsg, paramm);
        if ((localPushRegisterInfo.iStatus != 95) && (localPushRegisterInfo.iStatus != 21))
        {
          this.b.stopPCActivePolling("regPush");
          MsfService.core.pushManager.l();
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        PushRegisterInfo localPushRegisterInfo;
        a locala;
        return;
        if (QLog.isColorLevel()) {
          QLog.e("MSF.C.PushManager", 2, "handlerPush not found the same register Push " + MD5.toMD5(localPushRegisterInfo.uin) + " iStatus:" + localPushRegisterInfo.iStatus);
        }
        locala.k = localPushRegisterInfo;
        locala.a = paramToServiceMsg.getAppId();
        Iterator localIterator = localPushRegisterInfo.pushIds.iterator();
        while (localIterator.hasNext()) {
          locala.c = (((Long)localIterator.next()).longValue() | locala.c);
        }
        e(str);
        this.i.a(locala, paramToServiceMsg, false, paramm);
      }
    }
    QLog.e("MSF.C.PushManager", 2, "recv other processName:" + str + " recv regPush ");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.i.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(String paramString, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg) + " recv proxyUnRegister " + paramString);
      }
      this.h.remove(paramString);
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.core.l.a(paramToServiceMsg);
      localFromServiceMsg.setMsgSuccess();
      this.b.addRespToQuque(paramToServiceMsg, localFromServiceMsg);
      MsfStore.getNativeConfigStore().removeConfig("app_push_info_" + paramString);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   6: ifnull +30 -> 36
    //   9: aload_0
    //   10: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   13: invokevirtual 1366	android/media/MediaPlayer:isPlaying	()Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   28: invokevirtual 1369	android/media/MediaPlayer:release	()V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   36: aload_0
    //   37: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   40: ifnonnull +14 -> 54
    //   43: aload_0
    //   44: new 498	android/media/MediaPlayer
    //   47: dup
    //   48: invokespecial 499	android/media/MediaPlayer:<init>	()V
    //   51: putfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   54: aload_0
    //   55: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   58: invokevirtual 1708	android/media/MediaPlayer:reset	()V
    //   61: aload_0
    //   62: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   65: new 1710	java/io/FileInputStream
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 1711	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   73: invokevirtual 1714	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   76: invokevirtual 1717	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   84: invokespecial 502	com/tencent/mobileqq/msf/core/push/f:a	(Landroid/media/MediaPlayer;)V
    //   87: aload_0
    //   88: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   91: invokevirtual 525	android/media/MediaPlayer:prepare	()V
    //   94: aload_0
    //   95: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   98: new 1719	com/tencent/mobileqq/msf/core/push/i
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 1720	com/tencent/mobileqq/msf/core/push/i:<init>	(Lcom/tencent/mobileqq/msf/core/push/f;)V
    //   106: invokevirtual 1378	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   109: aload_0
    //   110: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   113: invokevirtual 1379	android/media/MediaPlayer:start	()V
    //   116: aload_0
    //   117: getfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   120: iload_2
    //   121: invokevirtual 1382	android/media/MediaPlayer:setLooping	(Z)V
    //   124: goto -103 -> 21
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 713	java/lang/Exception:printStackTrace	()V
    //   132: goto -111 -> 21
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_1
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   146: aload_1
    //   147: athrow
    //   148: astore 4
    //   150: aload_0
    //   151: aconst_null
    //   152: putfield 1363	com/tencent/mobileqq/msf/core/push/f:Q	Landroid/media/MediaPlayer;
    //   155: goto -119 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	f
    //   0	158	1	paramString	String
    //   0	158	2	paramBoolean	boolean
    //   16	2	3	bool	boolean
    //   148	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	17	127	java/lang/Exception
    //   31	36	127	java/lang/Exception
    //   36	54	127	java/lang/Exception
    //   54	124	127	java/lang/Exception
    //   141	148	127	java/lang/Exception
    //   150	155	127	java/lang/Exception
    //   2	17	135	finally
    //   31	36	135	finally
    //   36	54	135	finally
    //   54	124	135	finally
    //   128	132	135	finally
    //   141	148	135	finally
    //   150	155	135	finally
    //   24	31	140	finally
    //   24	31	148	java/lang/Exception
  }
  
  public void a(boolean paramBoolean)
  {
    String[] arrayOfString = MsfStore.getNativeConfigStore().getConfigList("app_push_info_");
    Object localObject1;
    int i4;
    int i2;
    label143:
    Object localObject2;
    if ((true == paramBoolean) && (arrayOfString == null) && (ak < aj.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "loop to loadAppPushInfo with time " + aj[ak] + " seconds");
      }
      localObject1 = this.ao.obtainMessage();
      ((Message)localObject1).what = 1;
      ((Message)localObject1).obj = Boolean.valueOf(paramBoolean);
      this.ao.sendMessageDelayed((Message)localObject1, aj[ak] * 1000);
      ak += 1;
      i4 = com.tencent.mobileqq.msf.core.c.e(BaseApplication.getContext());
      int i5 = arrayOfString.length;
      i2 = 0;
      if (i2 >= i5) {
        return;
      }
      localObject2 = HexUtil.hexStr2Bytes(arrayOfString[i2]);
      localObject1 = new a();
      ((a)localObject1).readFrom(new JceInputStream((byte[])localObject2));
      localObject2 = BaseApplication.getContext().getPackageName();
      if (a(((a)localObject1).b, (String)localObject2)) {
        break label336;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MSF.C.PushManager", 2, "filter other push process. processName:" + ((a)localObject1).b);
      }
      MsfStore.getNativeConfigStore().removeConfig("app_push_info_" + ((a)localObject1).b);
    }
    label292:
    label331:
    label336:
    label865:
    label872:
    for (;;)
    {
      i2 += 1;
      break label143;
      localObject1 = this.b.getStatReporter();
      boolean bool;
      long l1;
      if (arrayOfString == null)
      {
        bool = false;
        l1 = ak;
        if (true != paramBoolean) {
          break label331;
        }
      }
      for (int i1 = 0;; i1 = 1)
      {
        ((com.tencent.mobileqq.msf.core.c.m)localObject1).a("dim.Msf.LoadPushTimes", bool, l1, i1, null, false, false);
        break;
        bool = true;
        break label292;
      }
      this.h.put(((a)localObject1).b, localObject1);
      if ((((a)localObject1).k != null) && (((a)localObject1).c > 0L))
      {
        int i3 = 0;
        if (i4 == -1)
        {
          i3 = 1;
          i1 = i3;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.PushManager", 2, "nVersionCode:" + i4 + " sendMsgPushRegister now");
            i1 = i3;
          }
          if (i1 == 0) {
            break label865;
          }
          if ((localObject1 != null) && (((a)localObject1).k != null)) {
            this.b.getAccountCenter().b(((a)localObject1).k.uin, "autoRegPush");
          }
          this.i.a((a)localObject1, null, false, m.a);
        }
        for (;;)
        {
          if (n) {
            break label872;
          }
          n = true;
          o = ((a)localObject1).k.uin;
          break;
          localObject2 = String.valueOf(i4);
          if (((a)localObject1).n != null)
          {
            if (((a)localObject1).n.equals(localObject2))
            {
              i3 = 1;
              i1 = i3;
              if (!QLog.isColorLevel()) {
                break label426;
              }
              QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + ((a)localObject1).n + " strVersionCode:" + (String)localObject2 + " sendMsgPushRegister now");
              i1 = i3;
              break label426;
            }
            if (paramBoolean)
            {
              i3 = 1;
              i1 = i3;
              if (!QLog.isColorLevel()) {
                break label426;
              }
              QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + ((a)localObject1).n + " bBoot:" + paramBoolean + " strVersionCode:" + (String)localObject2 + " sendMsgPushRegister now");
              i1 = i3;
              break label426;
            }
            i1 = i3;
            if (!QLog.isColorLevel()) {
              break label426;
            }
            QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + ((a)localObject1).n + " strVersionCode:" + (String)localObject2 + " no need sendMsgPushRegister");
            i1 = i3;
            break label426;
          }
          if (paramBoolean)
          {
            i3 = 1;
            i1 = i3;
            if (!QLog.isColorLevel()) {
              break label426;
            }
            QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + ((a)localObject1).n + " bBoot:" + paramBoolean + " sendMsgPushRegister now");
            i1 = i3;
            break label426;
          }
          i1 = i3;
          if (!QLog.isColorLevel()) {
            break label426;
          }
          QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + ((a)localObject1).n + " bBoot:" + paramBoolean + " no need sendMsgPushRegister");
          i1 = i3;
          break label426;
          ((a)localObject1).c = 0L;
        }
      }
    }
    label426:
  }
  
  public boolean a(a parama, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parama.m != null)
    {
      bool1 = bool2;
      if (parama.m.uin.equals(paramFromServiceMsg.getUin()))
      {
        Iterator localIterator = parama.m.cmds.iterator();
        bool1 = false;
        if (localIterator.hasNext())
        {
          if (!((String)localIterator.next()).equals(paramFromServiceMsg.getServiceCmd())) {
            break label120;
          }
          paramFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
          MsfSdkUtils.addFromMsgProcessName(parama.b, paramFromServiceMsg);
          paramFromServiceMsg.setMsfCommand(MsfCommand.onRecvPushMsg);
          this.b.addRespToQuque(null, paramFromServiceMsg);
          bool1 = true;
        }
      }
    }
    label120:
    for (;;)
    {
      break;
      return bool1;
    }
  }
  
  public int b(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 1;
    }
    paramString = paramContext.getSharedPreferences(paramString, 4).getString(this.ah, String.valueOf(1));
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 1;
  }
  
  public void b(long paramLong)
  {
    this.aq = paramLong;
  }
  
  public void b(CommandCallbackerInfo paramCommandCallbackerInfo, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      String str = com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv unRegisterCmdCall ");
      }
      if (!this.h.containsKey(str)) {
        this.h.putIfAbsent(str, new a(str));
      }
      ((a)this.h.get(str)).m = paramCommandCallbackerInfo;
      paramCommandCallbackerInfo = com.tencent.mobileqq.msf.service.h.a(paramToServiceMsg);
      paramCommandCallbackerInfo.setMsgSuccess();
      this.b.addRespToQuque(paramToServiceMsg, paramCommandCallbackerInfo);
      e(str);
      return;
    }
    finally {}
  }
  
  public void b(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded getted");
    }
    long l1 = 0L;
    offlinepush.PbPushOffReadedNotify localPbPushOffReadedNotify;
    Object localObject1;
    Object localObject2;
    int i1;
    long l2;
    Iterator localIterator;
    a locala;
    try
    {
      localPbPushOffReadedNotify = new offlinepush.PbPushOffReadedNotify();
      localObject1 = paramFromServiceMsg.getWupBuffer();
      localObject2 = new byte[localObject1.length - 4];
      System.arraycopy(localObject1, 4, localObject2, 0, localObject1.length - 4);
      localPbPushOffReadedNotify.mergeFrom((byte[])localObject2);
      i1 = localPbPushOffReadedNotify.cNotifyType.get();
      if ((i1 & 0x1) == 0) {
        break label333;
      }
      localObject1 = new ArrayList();
      localObject2 = localPbPushOffReadedNotify.vC2CReadedNotify.get().iterator();
      l1 = 0L;
      while (((Iterator)localObject2).hasNext())
      {
        l2 = ((offlinepush.C2CMsgReadedNotify)((Iterator)localObject2).next()).lPeerUin.get();
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded C2C uin:" + l2);
        }
        localIterator = this.C.iterator();
        while (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          l1 = locala.a.to_uin.get();
          if (locala.a.from_uin.get() == l2) {
            ((List)localObject1).add(locala);
          }
        }
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPushReaded decode error:" + paramFromServiceMsg, paramFromServiceMsg);
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded remove" + ((List)localObject1).size() + " message");
    }
    this.C.removeAll((Collection)localObject1);
    label333:
    if ((i1 & 0x4) != 0)
    {
      localObject1 = new ArrayList();
      localObject2 = localPbPushOffReadedNotify.vDisReadedNotify.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        l2 = ((offlinepush.DisMsgReadedNotify)((Iterator)localObject2).next()).lDisUin.get();
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded Discuss uin:" + l2);
        }
        localIterator = this.C.iterator();
        while (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          l1 = locala.a.to_uin.get();
          if (locala.a.discuss_info.discuss_uin.get() == l2) {
            ((List)localObject1).add(locala);
          }
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded remove" + ((List)localObject1).size() + " message");
      }
      this.C.removeAll((Collection)localObject1);
    }
    for (;;)
    {
      i1 = BaseApplication.getContext().getSharedPreferences("unreadcount", 4).getInt("unread", -1);
      int i2 = this.C.size();
      BadgeUtilImpl.setBadge(BaseApplication.getContext(), i1 + i2);
      c(true);
      a(l1, paramFromServiceMsg.getRequestSsoSeq(), localPbPushOffReadedNotify.svr_ip.get());
      return;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.i.b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void b(String paramString)
  {
    try
    {
      String str = BaseApplication.getContext().getPackageName();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv KickedMsg ");
      }
      a locala = (a)this.h.get(str);
      if ((locala != null) && (locala.k != null) && (locala.k.uin.equals(paramString)))
      {
        locala.c = 0L;
        locala.k = null;
        e(str);
      }
      if (this.b.getAccountCenter().i().equals(paramString))
      {
        this.b.getAccountCenter().b("0", "onKicked");
        this.b.stopPCActivePolling("onKicked");
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    Iterator localIterator = this.h.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.h.get(localObject);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).c != 0L)) {
        return true;
      }
    }
    return false;
  }
  
  public int c(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 1;
    }
    paramString = paramContext.getSharedPreferences(paramString, 4).getString(this.ai, String.valueOf(1));
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 1;
  }
  
  public void c()
  {
    synchronized (this.t)
    {
      this.t.notify();
      return;
    }
  }
  
  public void c(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg getted");
    }
    if (MsfService.getCore().getUinPushStatus(paramFromServiceMsg.getUin()) != 95) {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg client status:" + MsfService.getCore().getUinPushStatus(paramFromServiceMsg.getUin()) + " drop now");
      }
    }
    int i1;
    do
    {
      do
      {
        do
        {
          return;
          if (!com.tencent.mobileqq.msf.service.c.a()) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg mobileqq is running drop now");
        return;
        localObject = this.C.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          i1 = ((a)((Iterator)localObject).next()).b;
        } while (paramFromServiceMsg.getRequestSsoSeq() != i1);
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get duplicate msg drop now.");
      return;
      localObject = this.D.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i1 = ((a)((Iterator)localObject).next()).b;
      } while (paramFromServiceMsg.getRequestSsoSeq() != i1);
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get duplicate av msg drop now ssoseq:" + i1);
    return;
    Object localObject = new a();
    for (;;)
    {
      offlinepush.PbPushOffMsg localPbPushOffMsg;
      try
      {
        localPbPushOffMsg = new offlinepush.PbPushOffMsg();
        byte[] arrayOfByte1 = paramFromServiceMsg.getWupBuffer();
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 4];
        System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 0, arrayOfByte1.length - 4);
        localPbPushOffMsg.mergeFrom(arrayOfByte2);
        ((a)localObject).a = localPbPushOffMsg;
        ((a)localObject).b = paramFromServiceMsg.getRequestSsoSeq();
        if (!c(localPbPushOffMsg)) {
          break label436;
        }
        this.D.add(localObject);
        u();
        a(localPbPushOffMsg.to_uin.get(), paramFromServiceMsg.getRequestSsoSeq(), localPbPushOffMsg.svr_ip.get());
        i1 = BaseApplication.getContext().getSharedPreferences("unreadcount", 4).getInt("unread", -5);
        int i2 = this.C.size();
        int i3 = this.D.size();
        BadgeUtilImpl.setBadge(BaseApplication.getContext(), i1 + (i2 + i3));
        return;
      }
      catch (Exception paramFromServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg decode error:" + paramFromServiceMsg, paramFromServiceMsg);
      return;
      label436:
      if (localPbPushOffMsg.msg_type.get() == 528)
      {
        a(localPbPushOffMsg);
      }
      else
      {
        this.C.add(localObject);
        c(false);
      }
    }
  }
  
  public void c(String paramString)
  {
    QLog.d("PCActivePush", 1, "onPCActive");
    ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(y);
    this.C.clear();
    this.at.set(true);
    BaseApplication.getContext().registerReceiver(this.ax, new IntentFilter("com.tencent.mobileqq.broadcast.pcactiveQQ"));
    this.av = 0;
    this.au = paramString;
    a(paramString, 0);
  }
  
  public void d()
  {
    synchronized (this.t)
    {
      this.t.notify();
      p = false;
      return;
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MSF.C.PushManager", 2, "MSF onNotificationQQWiFi=" + paramString);
    }
    BaseApplication.getContext().startActivity(new Intent(paramString));
  }
  
  public long e()
  {
    if (this.x == 0L) {
      return 300000L;
    }
    return this.x;
  }
  
  void f()
  {
    Iterator localIterator = this.h.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.h.get(localObject);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).c != 0L))
      {
        try
        {
          long l1 = System.currentTimeMillis();
          if ((((a)localObject).f == 0L) || (l1 - ((a)localObject).f <= 25200000L)) {
            break label134;
          }
          a((a)localObject, m.d);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          QLog.w("MSF.C.PushManager", 2, localException.toString(), localException);
          continue;
          label134:
          if ((p) && (localException.i != null) && (this.b.nowSocketConnAdd != null) && (localException.i.equals(this.b.nowSocketConnAdd)))
          {
            this.i.a(localException, false);
          }
          else
          {
            ToServiceMsg localToServiceMsg;
            if (this.b.nowSocketConnAdd == null)
            {
              localToServiceMsg = MsfMsgUtil.getConnOpenMsg("");
              MsfSdkUtils.addToMsgProcessName("", localToServiceMsg);
              this.b.sendSsoMsg(localToServiceMsg);
              a(e());
            }
            else
            {
              a(localToServiceMsg, m.e);
            }
          }
        }
      }
    }
  }
  
  public long g()
  {
    return this.aq;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onNotificationClearAll");
    }
    this.C.clear();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onNotificationClearAllAV");
    }
    this.D.clear();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "clearOfflinePushNotification");
    }
    ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(y);
    this.C.clear();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "clearOfflinePushNotificationAV");
    }
    ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(z);
    this.D.clear();
  }
  
  public void l()
  {
    if (this.at.get()) {
      QLog.d("PCActivePush", 1, "stop tryActiveQQ by regPush");
    }
    try
    {
      BaseApplication.getContext().unregisterReceiver(this.ax);
      HashMap localHashMap = new HashMap();
      localHashMap.put("account", this.au);
      localHashMap.put("retryIndex", String.valueOf(this.av));
      localHashMap.put("reason", "regpush");
      this.b.getStatReporter().a("dim.Msf.PCActiveQQResult", true, 0L, 0L, localHashMap, false, false);
      if ((this.aw == null) || (this.j == null)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.j.cancel(this.aw);
        this.at.set(false);
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onNotificationBroadcast");
    }
    Context localContext = BaseApplication.getContext();
    ((NotificationManager)localContext.getSystemService("notification")).cancel(y);
    this.C.clear();
    try
    {
      if (b())
      {
        localIntent = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
        localIntent.addFlags(268435456);
        localContext.startActivity(localIntent);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "uin kicked out");
      }
      Intent localIntent = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
      localIntent.addFlags(268435456);
      localContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "Start QQ failed" + localException);
      }
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onAVNotificationBroadcast");
    }
    Context localContext = BaseApplication.getContext();
    ((NotificationManager)localContext.getSystemService("notification")).cancel(z);
    this.D.clear();
    try
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
      localIntent.addFlags(268435456);
      localContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSF.C.PushManager", 2, "Start QQ failed" + localException);
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "clearDevlockQuickloginNotification");
    }
    NotificationManager localNotificationManager = (NotificationManager)BaseApplication.getContext().getSystemService("notification");
    if (localNotificationManager != null) {
      localNotificationManager.cancel(A);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "alarm receive " + paramIntent);
    }
    for (;;)
    {
      boolean bool;
      synchronized (this.t)
      {
        this.t.notify();
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "QQWiFi : starScan from alarmReceiver!");
        }
        p.a().c();
        if (this.ap) {
          p.a().e();
        }
        if (QLog.isColorLevel())
        {
          this.b.netFlowStore.a(paramContext, paramIntent);
          if (this.ap) {
            break label166;
          }
          bool = true;
          this.ap = bool;
          if (this.b.getStandyModeManager() != null) {
            this.b.getStandyModeManager().c();
          }
          return;
        }
      }
      if (this.ap)
      {
        this.b.netFlowStore.a(paramContext, paramIntent);
        continue;
        label166:
        bool = false;
      }
    }
  }
  
  public b p()
  {
    return this.an;
  }
  
  public int q()
  {
    return 3;
  }
  
  class a
  {
    public offlinepush.PbPushOffMsg a;
    public int b;
    
    a() {}
  }
  
  class b
    extends Thread
  {
    b() {}
    
    public void run()
    {
      synchronized (f.this.t)
      {
        try
        {
          f.this.t.wait();
          f.this.f();
          i.e();
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("MSF.C.PushManager", 2, localInterruptedException.toString(), localInterruptedException);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.f
 * JD-Core Version:    0.7.0.1
 */