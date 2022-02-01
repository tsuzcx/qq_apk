package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.ShareToQZoneBack;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ShareResultDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MessageShareActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import dyh;
import dyi;
import dyj;
import dyk;
import dyl;
import dyq;
import dyr;
import dys;
import dyv;
import dyw;
import dza;
import dzb;
import dzf;
import dzh;
import dzi;
import dzl;
import dzm;
import dzn;
import dzo;
import dzp;
import dzq;
import dzr;
import dzs;
import dzt;
import dzu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mqq.app.BasePadActivity;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class ForwardOperations
  implements DialogInterface.OnDismissListener, ShareToQZoneBack
{
  public static final int A = 1;
  public static final int B = 2;
  private static final int E = 100;
  private static final int F = 36;
  public static final String F = "emoInputType";
  private static final int G = 86400000;
  private static final int H = 209715200;
  private static final int I = 1;
  public static final String I = "public_account";
  private static final int J = 2;
  public static final String J = "web_share";
  private static final int K = 3;
  private static final int L = 0;
  private static final int M = 1;
  public static String M;
  private static final String Q = "k_qzone";
  private static final String R = "k_send";
  private static final String S = "share";
  static final int jdField_a_of_type_Int = 20000;
  public static Object a;
  public static final String a = "ForwardOperations";
  public static final int b = 20001;
  public static final String b = "friend_forward_photo";
  protected static final int c = 50001;
  public static final String c = "forward_photo_to_dataline";
  public static final int d = 45;
  public static final String d = "forward_photo_no_nav";
  public static final int e = 60;
  public static final String e = "com.tencent.intent.QQ_FORWARD";
  public static final int f = 1;
  public static final String f = "com.tencent.intent.QQ_FORWARD";
  public static final int g = 2;
  public static final String g = "k_back";
  protected static final int h = 0;
  public static final String h = "appid";
  protected static final int i = -1;
  public static final String i = "UTF-8";
  protected static final int j = 3;
  public static final String j = "com.qzone";
  protected static final int k = 3;
  public static final String k = "isFromFavorites";
  protected static final int l = 1002;
  public static final String l = "isMigSdkShare";
  protected static final int m = 1003;
  public static final String m = "MigSdkShareNotDone";
  protected static final int n = 1004;
  public static final String n = "shareToQQ";
  protected static final int o = 1005;
  public static final String o = "shareToQzone";
  protected static final int p = 0;
  public static final String p = "sendToMyComputer";
  protected static final int q = 1;
  public static final String q = "addToQQFavorites";
  protected static final int r = 2;
  public static final String r = "shareToTroopBar";
  protected static final int s = 16;
  public static final String s = "tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}";
  protected static final int t = 1000;
  public static final String t = "tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel";
  protected static final int u = 200;
  protected static final String u = "targetUrl";
  protected static final String v = "audioUrl";
  protected static final String w = "imageUrl";
  protected static final String x = "sourceUrl";
  protected static final String y = "sourceIcon";
  public static final int z = 0;
  public static final String z = "send_hb_success";
  String A = null;
  public String B;
  public int C;
  public String C;
  int D;
  public String D;
  public String E;
  public String G = null;
  public String H;
  public String K = "";
  public String L;
  public String N;
  String O;
  String P;
  private float jdField_a_of_type_Float;
  public long a;
  public Activity a;
  public Intent a;
  public Bundle a;
  public final Handler a;
  public ResultReceiver a;
  protected ShareResultDialog a;
  public ForwardOperations.CancelCallback a;
  SendMultiPictureHelper jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper;
  public QQAppInterface a;
  private ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  protected AbsShareMsg a;
  public QQCustomDialog a;
  protected QQProgressDialog a;
  public GetAppInfoProto.GetAppinfoResponse a;
  private dzu jdField_a_of_type_Dzu = new dzu(this);
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  protected BusinessObserver a;
  public boolean a;
  public long b;
  @SuppressLint({"HandlerLeak"})
  private Handler b;
  public ShareResultDialog b;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  public boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  public int v;
  public int w;
  public int x;
  int y;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public ForwardOperations(Activity paramActivity, QQAppInterface paramQQAppInterface, Intent paramIntent, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog = null;
    this.jdField_a_of_type_AndroidOsHandler = new dyh(this, Looper.getMainLooper());
    this.jdField_D_of_type_Int = 5;
    this.jdField_b_of_type_AndroidOsHandler = new dza(this);
    this.jdField_a_of_type_MqqObserverBusinessObserver = new dzm(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    this.v = paramIntent.getIntExtra("forward_type", -1);
    this.w = paramIntent.getIntExtra("req_type", 2147483647);
    this.B = paramIntent.getStringExtra("forward_thumb");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("forward_urldrawable", false);
    this.jdField_C_of_type_JavaLangString = paramIntent.getStringExtra("forward_urldrawable_thumb_url");
    this.jdField_D_of_type_JavaLangString = paramIntent.getStringExtra("forward_urldrawable_big_url");
    this.E = paramIntent.getStringExtra("forward_text");
    this.y = paramIntent.getIntExtra("FORWARD_EMOPGK_ID", -1);
    this.H = this.jdField_a_of_type_AndroidOsBundle.getString("pluginName");
    if (this.v == 2)
    {
      this.E = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131365742);
      if (this.v == 0) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo"));
      }
      this.f = paramIntent.getBooleanExtra("k_qzone", false);
      if ((!"com.tencent.intent.QQ_FORWARD".equals(paramIntent.getAction())) && ((!this.f) || (!paramIntent.getBooleanExtra("k_send", true)))) {
        break label1156;
      }
    }
    label1156:
    for (boolean bool = true;; bool = false)
    {
      for (;;)
      {
        this.jdField_b_of_type_Boolean = bool;
        if (this.v == 2)
        {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
          if (this.jdField_a_of_type_Long > 0L) {
            Share.a(paramQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramQQAppInterface.a(), this.jdField_a_of_type_Long, this.jdField_a_of_type_MqqObserverBusinessObserver);
          }
          e();
          paramActivity = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
          paramActivity.putInt("req_type", 1);
          paramActivity = StructMsgFactory.a(paramActivity);
          if ((paramActivity != null) && ((paramActivity instanceof AbsShareMsg))) {
            this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)paramActivity);
          }
        }
        if (paramIntent.getBooleanExtra("frommqq_conversation_btn", false))
        {
          ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).setCanLock(false);
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "msgtab_shortcut", "digital_camera", 0, 0, "", "", "", "");
        }
        f();
        i();
        return;
        if ((this.v == 0) || (this.v == 1))
        {
          paramActivity = paramIntent.getData();
          if (paramActivity == null) {
            break;
          }
          a(paramActivity);
          break;
        }
        if (this.v == -1)
        {
          if (this.E != null) {
            break;
          }
          paramActivity = (SpannableString)this.jdField_a_of_type_AndroidOsBundle.get("forward_text");
          if (paramActivity == null) {
            break;
          }
          this.E = paramActivity.toString();
          break;
        }
        if (this.v == -2)
        {
          paramActivity = paramIntent.getData();
          if (paramActivity == null) {
            break;
          }
          paramActivity = paramActivity.toString();
          paramActivity = paramActivity.substring(paramActivity.indexOf("geo:")).split(",");
          if (paramActivity.length <= 1) {
            break;
          }
          Double.parseDouble(paramActivity[0]);
          Double.parseDouble(paramActivity[1]);
          break;
        }
        if ((this.v == -3) || (this.v == 19) || (this.v == 20))
        {
          paramActivity = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
          if ((paramActivity == null) || (!(paramActivity instanceof AbsShareMsg))) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)paramActivity);
          break;
        }
        if (this.v != 11) {
          break label1130;
        }
        this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
        this.K = "";
        paramActivity = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
        paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
        if ((this.w == 5) && (TextUtils.isEmpty(paramActivity)) && (TextUtils.isEmpty(paramBundle)))
        {
          a(-1, "请选择图片", "分享的图片不存在");
          try
          {
            OpenSdkStatic.a().a(1, "SHARE_CHECK_AGENT", paramQQAppInterface.a(), String.valueOf(this.jdField_a_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享的图片不存在");
            return;
          }
          catch (Exception paramActivity)
          {
            return;
          }
        }
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
          e();
        }
        paramBundle = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
        if (!TextUtils.isEmpty(paramActivity)) {
          paramBundle.putString("image_url_remote", paramActivity);
        }
        paramActivity = StructMsgFactory.a(paramBundle);
        if (!AbsShareMsg.class.isInstance(paramActivity))
        {
          a(-1, "分享类型错误", "类型错误");
          try
          {
            OpenSdkStatic.a().a(1, "SHARE_CHECK_AGENT", paramQQAppInterface.a(), String.valueOf(this.jdField_a_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "类型错误");
            return;
          }
          catch (Exception paramActivity)
          {
            return;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)paramActivity);
        if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name") != null))
        {
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          this.e = true;
          long l1 = System.currentTimeMillis() / 1000L;
          paramActivity = AgentActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name"), l1 + "");
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOperations", 2, "-->sdk_share, getting appinfo in construct. sign: " + paramActivity);
          }
          Share.a(paramQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramQQAppInterface.a(), this.jdField_a_of_type_Long, paramActivity, l1, this.jdField_a_of_type_MqqObserverBusinessObserver);
        }
        try
        {
          OpenSdkStatic.a().a(0, "SHARE_CHECK_AGENT", paramQQAppInterface.a(), String.valueOf(this.jdField_a_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
        }
        catch (Exception paramActivity) {}
      }
      break;
      label1130:
      if (this.v != 15) {
        break;
      }
      this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)paramIntent.getParcelableExtra("choose_friend_callback"));
      break;
    }
  }
  
  private int a(int paramInt)
  {
    float f1 = 1.0F;
    if (paramInt > 150) {
      f1 = paramInt / 100;
    }
    if (this.jdField_a_of_type_Float <= 1.5D) {
      return (int)(f1 * 9.0F);
    }
    if (this.jdField_a_of_type_Float <= 2.0D) {
      return (int)(f1 * 9.0F);
    }
    return (int)(f1 * 4.0F);
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null) {}
    switch (paramFileManagerEntity.cloudType)
    {
    case 4: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("dataline", 2, "FileManagerEntity->cloudType 转 ForwardFileInfo->type， 未识别的cloudType[" + paramFileManagerEntity.cloudType);
      }
    case 3: 
    case 5: 
      return 10000;
    case 6: 
    case 7: 
      return 10009;
    case 1: 
      return 10002;
    }
    return 10003;
  }
  
  private Intent a()
  {
    return this.jdField_a_of_type_AndroidContentIntent;
  }
  
  private Drawable a(Bitmap paramBitmap)
  {
    Object localObject = null;
    Bitmap localBitmap = ImageUtil.a(paramBitmap, a(0));
    paramBitmap = localObject;
    if (localBitmap != null) {
      paramBitmap = new BitmapDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), localBitmap);
    }
    return paramBitmap;
  }
  
  private Drawable a(Drawable paramDrawable)
  {
    return a(SkinUtils.a(paramDrawable));
  }
  
  public static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity)
  {
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(a(paramFileManagerEntity));
    localForwardFileInfo.d(paramFileManagerEntity.cloudType);
    localForwardFileInfo.b(paramFileManagerEntity.nSessionId);
    localForwardFileInfo.c(paramFileManagerEntity.uniseq);
    localForwardFileInfo.d(paramFileManagerEntity.fileName);
    localForwardFileInfo.d(paramFileManagerEntity.fileSize);
    localForwardFileInfo.a(paramFileManagerEntity.strFilePath);
    localForwardFileInfo.c(paramFileManagerEntity.WeiYunFileId);
    if ((paramFileManagerEntity.strLargeThumPath != null) && (paramFileManagerEntity.strLargeThumPath.length() > 0)) {
      localForwardFileInfo.f(paramFileManagerEntity.strLargeThumPath);
    }
    for (;;)
    {
      if (paramFileManagerEntity.Uuid != null) {
        localForwardFileInfo.b(paramFileManagerEntity.Uuid);
      }
      if (paramFileManagerEntity.TroopUin != 0L) {
        localForwardFileInfo.a(paramFileManagerEntity.TroopUin);
      }
      if (paramFileManagerEntity.strTroopFileID != null) {
        localForwardFileInfo.e(paramFileManagerEntity.strTroopFileID);
      }
      return localForwardFileInfo;
      localForwardFileInfo.f(paramFileManagerEntity.strThumbPath);
    }
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file"))) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
    if (str.equals("content")) {
      try
      {
        paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
        int i1 = paramContext.getColumnIndexOrThrow("_data");
        paramContext.moveToFirst();
        paramUri = paramContext.getString(i1);
        paramContext.close();
        return paramUri;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static String a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    Object localObject = null;
    Context localContext = BaseApplicationImpl.getContext();
    try
    {
      paramString = localContext.getContentResolver().query(paramUri, new String[] { "_data" }, paramString, paramArrayOfString, null);
      if ((paramString == null) || (paramString != null)) {
        paramString.close();
      }
    }
    finally
    {
      try
      {
        if (paramString.moveToFirst())
        {
          paramUri = paramString.getString(paramString.getColumnIndexOrThrow("_data"));
          if (paramString != null) {
            paramString.close();
          }
          return paramUri;
        }
        if (paramString != null) {
          paramString.close();
        }
        return null;
      }
      finally {}
      paramUri = finally;
      paramString = localObject;
    }
    throw paramUri;
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    Object localObject = "";
    String str2 = paramBundle.getString("title");
    String str1 = paramBundle.getString("desc");
    paramBundle = (Bundle)localObject;
    if (!TextUtils.isEmpty(str2)) {
      paramBundle = "" + str2;
    }
    localObject = paramBundle;
    if (!TextUtils.isEmpty(str1))
    {
      if (TextUtils.isEmpty(paramBundle)) {
        break label168;
      }
      paramBundle = paramBundle + "\n";
    }
    label168:
    for (localObject = paramBundle + str1; !TextUtils.isEmpty(paramString); localObject = str1)
    {
      paramBundle = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramBundle = (String)localObject + "\n";
        paramBundle = paramBundle + paramString;
      }
      return paramBundle;
    }
    return localObject;
  }
  
  private void a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, BookShareAdviceEditActivity.class);
    localIntent.putExtra("qrreceivername", paramString);
    localIntent.putExtras(paramIntent);
    paramActivity.startActivityForResult(localIntent, 20001);
  }
  
  public static final void a(Context paramContext, boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramContext == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("sdk_share", 2, "sdk callback=" + paramBoolean);
    }
    Intent localIntent = new Intent();
    if (paramBoolean) {
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), paramString })));
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("qqshare", 2, paramContext.getMessage());
      return;
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), paramString })));
    }
  }
  
  private void a(Intent paramIntent, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    boolean bool1;
    do
    {
      return;
      boolean bool2 = paramBundle.getBoolean("isFromFavorites");
      bool1 = bool2;
      if (!bool2)
      {
        String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          bool1 = bool2;
          if (str.equals(this.jdField_a_of_type_AndroidAppActivity.getString(2131364671))) {
            bool1 = true;
          }
        }
      }
    } while (!bool1);
    paramBundle.putBoolean("isBack2Root", true);
    paramBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131366025));
    paramIntent.putExtras(paramBundle);
  }
  
  private void a(Uri paramUri, String paramString, InputStream paramInputStream, long paramLong)
  {
    this.g = true;
    ThreadManager.b(new dyv(this, paramString, paramInputStream, paramLong, paramUri));
    a(2131368636);
  }
  
  private void a(String paramString)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131558902);
    localQQCustomDialog.setContentView(2130903216);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131367300));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131366374), new dys(this));
    localQQCustomDialog.show();
  }
  
  private void a(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    if (paramQQCustomDialog == null) {}
    do
    {
      return;
      if (this.v != 2) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null);
    paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null));
    return;
    if ((this.v == 1001) || (this.v == -4))
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("stuctmsg_bytes");
      if (localObject != null)
      {
        localObject = StructMsgFactory.a((byte[])localObject);
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(AIOUtils.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(-5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        paramQQCustomDialog.addView(((AbsStructMsg)localObject).getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      }
    }
    while (((this.v != -3) && (this.v != 11) && (this.v != 19) && (this.v != 20)) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null))
    {
      LinearLayout.LayoutParams localLayoutParams;
      if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) {
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new dyl(this, paramString, paramQQCustomDialog));
      return;
    }
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForGeneralShare)) {
      ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
    }
    for (;;)
    {
      paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), (LinearLayout.LayoutParams)localObject);
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      } else if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) {
        ((LinearLayout.LayoutParams)localObject).setMargins(AIOUtils.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Object localObject = new Intent();
    if ((paramInt == 1000) || (paramInt == 1004) || (paramInt == 1020)) {
      this.jdField_a_of_type_AndroidOsBundle.putString("troop_uin", this.A);
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramString2);
    this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", paramInt);
    this.jdField_a_of_type_AndroidOsBundle.putString("uinname", paramString3);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    if (this.v == 0) {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", this.jdField_a_of_type_AndroidAppActivity.getString(2131366025));
    }
    if (AppConstants.Y.equals(paramString2)) {
      if (this.v == 11) {
        h();
      }
    }
    for (;;)
    {
      return;
      if (((Intent)localObject).getBooleanExtra("MigSdkShareNotDone", false))
      {
        h();
        return;
      }
      g();
      return;
      if (paramInt == 6002)
      {
        paramString1 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
        paramString3 = paramString1.a(Long.parseLong(paramString2));
        paramString1.a(this.jdField_a_of_type_AndroidAppActivity, paramString3);
        if (a().getBooleanExtra("sendMultiple", false))
        {
          paramString1 = a().getStringExtra("forward_filepath");
          label236:
          paramString3 = (RouterHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50);
          localObject = new ArrayList();
        }
      }
      try
      {
        ((ArrayList)localObject).add(new FileInfo(paramString1));
        paramString3.a((ArrayList)localObject, null, null, Long.parseLong(paramString2));
        return;
        paramString1 = a().getStringExtra("forward_filepath");
        break label236;
        if (AppConstants.ai.equals(paramString2))
        {
          c();
          return;
        }
        int i1;
        if (this.v == 1)
        {
          this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
          if (a().getBooleanExtra("sendMultiple", false))
          {
            if (a().getBooleanExtra("isFromShare", false)) {
              this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper = new SendMultiPictureHelper((BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
            }
            localObject = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
            if ((localObject == null) || (!(localObject instanceof ArrayList))) {
              continue;
            }
            localObject = (ArrayList)localObject;
            ArrayList localArrayList = new ArrayList();
            i1 = 0;
            while (i1 < ((ArrayList)localObject).size())
            {
              localArrayList.add(a((Uri)((ArrayList)localObject).get(i1)));
              i1 += 1;
            }
            if (localArrayList.size() <= 0) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper.a(paramString1, paramString2, paramInt, paramString3, this.v, this.jdField_a_of_type_AndroidOsBundle, localArrayList);
            return;
          }
          if (paramInt == 1008)
          {
            paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
            paramString1.putExtra("chat_subType", PublicAccountManager.a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          }
          while (a().getBooleanExtra("isFromShare", false))
          {
            this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
            paramString1.addFlags(67108864);
            paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
            a(paramString1, this.jdField_a_of_type_AndroidOsBundle);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
            this.jdField_a_of_type_AndroidAppActivity.finish();
            return;
            paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
          }
          this.jdField_a_of_type_AndroidOsBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePadActivity)) {
            ((BasePadActivity)this.jdField_a_of_type_AndroidAppActivity).noFinishAnim();
          }
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramString1);
          this.jdField_a_of_type_AndroidAppActivity.finish();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004047", "0X8004047", 0, 0, "", "", "", "");
          return;
          if (this.v == 0)
          {
            if (paramInt == 1008)
            {
              paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
              paramString1.putExtra("chat_subType", PublicAccountManager.a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
            }
            while (a().getBooleanExtra("isFromShare", false))
            {
              this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
              paramString1.addFlags(67108864);
              paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
              a(paramString1, this.jdField_a_of_type_AndroidOsBundle);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
              this.jdField_a_of_type_AndroidAppActivity.finish();
              return;
              paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
            }
            paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          }
          else if (this.v == 9)
          {
            paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
            paramString1.addFlags(67108864);
            paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          }
          else if (this.v == -1)
          {
            if (paramInt == 1008)
            {
              paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
              paramString1.putExtra("chat_subType", PublicAccountManager.a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
            }
            while (a().getBooleanExtra("isFromShare", false))
            {
              this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
              paramString1.addFlags(67108864);
              this.jdField_a_of_type_AndroidOsBundle.putString("forward_text", this.E);
              paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
              a(paramString1, this.jdField_a_of_type_AndroidOsBundle);
              paramString1.setClass(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
              this.jdField_a_of_type_AndroidAppActivity.finish();
              return;
              paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
            }
            this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
            paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          }
          else if (this.v == 10)
          {
            this.jdField_a_of_type_AndroidOsBundle.putString("forward_text", this.E);
            paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
            paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          }
          else
          {
            if (this.v == 11)
            {
              if ("-1010".equals(paramString2))
              {
                b();
                if (this.w != 1) {
                  break label1386;
                }
                paramString3 = "1";
                label1197:
                paramString1 = "1";
                if (paramInt != 0) {
                  break label1426;
                }
                paramString1 = "1";
              }
              for (;;)
              {
                if (!"-1010".equals(paramString2)) {
                  break label1672;
                }
                paramString1 = "4";
                ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", this.jdField_a_of_type_Long + "", "10", "12", "0", paramString3, paramString2, paramString1, false);
                return;
                a(paramString2, paramInt, paramString3);
                switch (paramInt)
                {
                default: 
                  i1 = 1;
                }
                for (;;)
                {
                  try
                  {
                    OpenSdkStatic.a().a(0, "SHARE_TO_QQ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(i1), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
                  }
                  catch (Exception paramString1) {}
                  break;
                  i1 = 1;
                  continue;
                  i1 = 2;
                  continue;
                  i1 = 3;
                }
                label1386:
                if (this.w == 2)
                {
                  paramString3 = "3";
                  break label1197;
                }
                if (this.w == 5)
                {
                  paramString3 = "2";
                  break label1197;
                }
                paramString3 = "4";
                break label1197;
                label1426:
                if (1 == paramInt) {
                  paramString1 = "2";
                } else if (3000 == paramInt) {
                  paramString1 = "3";
                }
              }
            }
            if (this.v == 2)
            {
              a(paramString2, paramInt, paramString3);
              return;
            }
            if (this.v == -3)
            {
              this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
              if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
              {
                StructMsgForImageShare.sendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, paramString2, paramInt);
                paramString1 = (String)localObject;
              }
              else
              {
                paramString1 = new Intent();
                paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
              }
            }
            else
            {
              if (this.v == 17)
              {
                a(paramString2, paramInt, this.jdField_a_of_type_AndroidOsBundle);
                return;
              }
              if (this.v == 18)
              {
                b(paramString2, paramInt, this.jdField_a_of_type_AndroidOsBundle);
                return;
              }
              if (this.v == 19)
              {
                paramString1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
                paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
                paramString1.setFlags(67108864);
                paramString1.putExtra("isBack2Root", true);
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString1);
                this.jdField_a_of_type_AndroidAppActivity.finish();
                return;
              }
              paramString1 = new Intent();
              paramString1.putExtras(this.jdField_a_of_type_AndroidOsBundle);
            }
          }
        }
      }
      catch (FileNotFoundException paramString1)
      {
        label1672:
        for (;;) {}
      }
    }
  }
  
  private boolean a(Uri paramUri)
  {
    Object localObject = a(paramUri);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (this.v == 1) {}
      for (paramUri = this.jdField_a_of_type_AndroidAppActivity.getString(2131368627);; paramUri = a())
      {
        localObject = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131558902);
        ((QQCustomDialog)localObject).setContentView(2130903216);
        ((QQCustomDialog)localObject).setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131367300));
        ((QQCustomDialog)localObject).setMessage(paramUri);
        ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
        ((QQCustomDialog)localObject).setCancelable(false);
        ((QQCustomDialog)localObject).setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131366374), new dyq(this));
        ((QQCustomDialog)localObject).show();
        return false;
      }
    }
    paramUri = new File((String)localObject);
    long l1 = paramUri.length();
    if ((!this.g) && (!this.h) && (l1 == 0L))
    {
      paramUri = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131558902);
      paramUri.setContentView(2130903216);
      paramUri.setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131367300));
      paramUri.setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131368629));
      paramUri.setCanceledOnTouchOutside(false);
      paramUri.setCancelable(false);
      paramUri.setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131366374), new dyr(this));
      paramUri.show();
      return false;
    }
    String str = paramUri.getName();
    boolean bool = paramUri.canRead();
    if ((!this.g) && (!this.h) && (!bool))
    {
      this.v = -1;
      this.E = this.jdField_a_of_type_AndroidOsBundle.getString("android.intent.extra.TEXT");
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_type", -1);
      return false;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", (String)localObject);
    if (l1 < 1024L) {
      paramUri = l1 + " bytes";
    }
    for (;;)
    {
      if (this.v == 1) {
        this.B = ((String)localObject);
      }
      this.E = (this.jdField_a_of_type_AndroidAppActivity.getString(2131368117) + str + "\n" + this.jdField_a_of_type_AndroidAppActivity.getString(2131368118) + paramUri);
      return true;
      if (l1 < 1048576L)
      {
        paramUri = l1 / 1024L + " KB";
      }
      else
      {
        paramUri = new DecimalFormat("##0.00");
        paramUri = paramUri.format(l1 / 1048576.0D) + " MB";
      }
    }
  }
  
  private static void b(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      return;
      paramString = paramString.listFiles();
      int i2 = paramString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = paramString[i1];
        if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
          localObject.delete();
        }
        i1 += 1;
      }
    }
  }
  
  private void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
      }
      d();
      this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
      dyw localdyw = new dyw(this);
      dzn localdzn = new dzn(this);
      paramString3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_text");
      paramString1 = paramString3;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString1 = paramString3;
        if (SubString.a(paramString3, "UTF-8") > 105) {
          paramString1 = SubString.a(paramString3, 105, "UTF-8", "...");
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364728), paramString1, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131365736), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364729), localdyw, localdzn);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new dzo(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageCount(null);
      a(this.B, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      this.A = paramString2;
    } while (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private boolean b()
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.e)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOperations", 2, "-->sdk_share, checkAppinfoLocked, getappinfo already executing...");
          }
          try
          {
            jdField_a_of_type_JavaLangObject.wait();
            if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ForwardOperations", 2, "-->sdk_share, response is null and show result dialog.");
            }
            return true;
          }
          catch (InterruptedException localInterruptedException1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ForwardOperations", 2, "check app info locked ex", localInterruptedException1);
            continue;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse == null)
      {
        this.e = true;
        long l1 = System.currentTimeMillis() / 1000L;
        String str = AgentActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name"), l1 + "");
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOperations", 2, "-->sdk_share, checkAppinfoLocked, sign: " + str + ", appinfo is null.");
        }
        Share.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_Long, str, l1, this.jdField_a_of_type_MqqObserverBusinessObserver);
        try
        {
          jdField_a_of_type_JavaLangObject.wait();
        }
        catch (InterruptedException localInterruptedException2) {}
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOperations", 2, "check app info locked ex", localInterruptedException2);
        }
      }
    }
    int i1 = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.ret.get();
    if ((i1 == 110507) || (i1 == 110401))
    {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new dzf(this, i1));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOperations", 2, "-->sdk_share, response ret: " + i1 + " and show result dialog.");
      }
      return false;
    }
    return true;
  }
  
  /* Error */
  private String c(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 222	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   4: invokevirtual 1252	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore 8
    //   9: aload 8
    //   11: aload_1
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 696	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 6
    //   21: aload 6
    //   23: ifnonnull +34 -> 57
    //   26: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +12 -> 41
    //   32: ldc 48
    //   34: iconst_2
    //   35: ldc_w 1254
    //   38: invokestatic 1256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload 6
    //   43: ifnull +10 -> 53
    //   46: aload 6
    //   48: invokeinterface 708 1 0
    //   53: aconst_null
    //   54: astore_1
    //   55: aload_1
    //   56: areturn
    //   57: aload 6
    //   59: ldc_w 1258
    //   62: invokeinterface 1261 2 0
    //   67: istore_2
    //   68: aload 6
    //   70: ldc_w 1263
    //   73: invokeinterface 1261 2 0
    //   78: istore_3
    //   79: aload 6
    //   81: invokeinterface 704 1 0
    //   86: pop
    //   87: aload 6
    //   89: iload_3
    //   90: invokeinterface 1266 2 0
    //   95: lstore 4
    //   97: lload 4
    //   99: l2f
    //   100: invokestatic 1271	com/tencent/mobileqq/utils/FileUtils:b	()F
    //   103: fcmpl
    //   104: ifle +30 -> 134
    //   107: aload_0
    //   108: getfield 222	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   111: ldc_w 1272
    //   114: invokevirtual 786	android/app/Activity:getString	(I)Ljava/lang/String;
    //   117: putstatic 1274	com/tencent/mobileqq/activity/ForwardOperations:M	Ljava/lang/String;
    //   120: aload 6
    //   122: ifnull +10 -> 132
    //   125: aload 6
    //   127: invokeinterface 708 1 0
    //   132: aconst_null
    //   133: areturn
    //   134: iload_2
    //   135: iconst_m1
    //   136: if_icmpne +145 -> 281
    //   139: new 509	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 510	java/lang/StringBuilder:<init>	()V
    //   146: invokestatic 503	java/lang/System:currentTimeMillis	()J
    //   149: invokevirtual 514	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   152: ldc 182
    //   154: invokevirtual 517	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: astore 7
    //   162: new 509	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 510	java/lang/StringBuilder:<init>	()V
    //   169: aload_0
    //   170: getfield 222	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   173: invokevirtual 1278	android/app/Activity:getExternalCacheDir	()Ljava/io/File;
    //   176: invokevirtual 1281	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: ldc_w 1283
    //   182: invokevirtual 517	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 43
    //   187: invokevirtual 517	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc_w 1283
    //   193: invokevirtual 517	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: astore 9
    //   201: aload 9
    //   203: invokestatic 1284	com/tencent/mobileqq/activity/ForwardOperations:b	(Ljava/lang/String;)V
    //   206: new 509	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 510	java/lang/StringBuilder:<init>	()V
    //   213: aload 9
    //   215: invokevirtual 517	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 9
    //   220: aload 7
    //   222: invokestatic 1287	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   225: invokevirtual 517	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: astore 7
    //   233: new 672	java/io/File
    //   236: dup
    //   237: aload 9
    //   239: invokespecial 677	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: astore 9
    //   244: aload 9
    //   246: invokevirtual 1142	java/io/File:exists	()Z
    //   249: ifne +45 -> 294
    //   252: aload 9
    //   254: invokevirtual 1290	java/io/File:mkdirs	()Z
    //   257: ifne +37 -> 294
    //   260: aload_0
    //   261: ldc_w 1292
    //   264: invokespecial 824	com/tencent/mobileqq/activity/ForwardOperations:a	(Ljava/lang/String;)V
    //   267: aload 6
    //   269: ifnull +10 -> 279
    //   272: aload 6
    //   274: invokeinterface 708 1 0
    //   279: aconst_null
    //   280: areturn
    //   281: aload 6
    //   283: iload_2
    //   284: invokeinterface 705 2 0
    //   289: astore 7
    //   291: goto -129 -> 162
    //   294: aload 8
    //   296: aload_1
    //   297: invokevirtual 1296	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   300: astore 8
    //   302: aload 8
    //   304: ifnonnull +32 -> 336
    //   307: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +12 -> 322
    //   313: ldc 48
    //   315: iconst_2
    //   316: ldc_w 1298
    //   319: invokestatic 1256	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: aload 6
    //   324: ifnull +10 -> 334
    //   327: aload 6
    //   329: invokeinterface 708 1 0
    //   334: aconst_null
    //   335: areturn
    //   336: lload 4
    //   338: ldc2_w 1299
    //   341: lcmp
    //   342: ifle +156 -> 498
    //   345: aload_0
    //   346: iconst_1
    //   347: putfield 1103	com/tencent/mobileqq/activity/ForwardOperations:h	Z
    //   350: new 830	com/tencent/mobileqq/utils/QQCustomDialog
    //   353: dup
    //   354: aload_0
    //   355: getfield 222	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   358: ldc_w 831
    //   361: invokespecial 834	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   364: astore 9
    //   366: aload 9
    //   368: ldc_w 835
    //   371: invokevirtual 838	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   374: aload 9
    //   376: aload_0
    //   377: getfield 222	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   380: ldc_w 839
    //   383: invokevirtual 786	android/app/Activity:getString	(I)Ljava/lang/String;
    //   386: invokevirtual 843	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   389: pop
    //   390: aload 9
    //   392: aload_0
    //   393: getfield 222	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   396: ldc_w 1301
    //   399: invokevirtual 786	android/app/Activity:getString	(I)Ljava/lang/String;
    //   402: invokevirtual 847	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   405: pop
    //   406: aload 9
    //   408: iconst_0
    //   409: invokevirtual 850	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   412: aload 9
    //   414: iconst_0
    //   415: invokevirtual 853	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   418: aload 9
    //   420: aload_0
    //   421: getfield 222	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   424: ldc_w 1302
    //   427: invokevirtual 786	android/app/Activity:getString	(I)Ljava/lang/String;
    //   430: new 1304	dyt
    //   433: dup
    //   434: aload_0
    //   435: aload 8
    //   437: invokespecial 1307	dyt:<init>	(Lcom/tencent/mobileqq/activity/ForwardOperations;Ljava/io/InputStream;)V
    //   440: invokevirtual 861	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   443: pop
    //   444: aload 9
    //   446: aload_0
    //   447: getfield 222	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   450: ldc_w 1308
    //   453: invokevirtual 786	android/app/Activity:getString	(I)Ljava/lang/String;
    //   456: new 1310	dyu
    //   459: dup
    //   460: aload_0
    //   461: aload_1
    //   462: aload 7
    //   464: aload 8
    //   466: lload 4
    //   468: invokespecial 1312	dyu:<init>	(Lcom/tencent/mobileqq/activity/ForwardOperations;Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   471: invokevirtual 1315	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   474: pop
    //   475: aload 9
    //   477: invokevirtual 864	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   480: aload 7
    //   482: astore_1
    //   483: aload 6
    //   485: ifnull -430 -> 55
    //   488: aload 6
    //   490: invokeinterface 708 1 0
    //   495: aload 7
    //   497: areturn
    //   498: aload_0
    //   499: aload_1
    //   500: aload 7
    //   502: aload 8
    //   504: lload 4
    //   506: invokespecial 822	com/tencent/mobileqq/activity/ForwardOperations:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   509: goto -29 -> 480
    //   512: astore 7
    //   514: aload 6
    //   516: astore_1
    //   517: aload 7
    //   519: astore 6
    //   521: aload_0
    //   522: iconst_0
    //   523: putfield 801	com/tencent/mobileqq/activity/ForwardOperations:g	Z
    //   526: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   529: ifeq +14 -> 543
    //   532: ldc 48
    //   534: iconst_2
    //   535: ldc_w 1317
    //   538: aload 6
    //   540: invokestatic 1319	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   543: aload_1
    //   544: ifnull +9 -> 553
    //   547: aload_1
    //   548: invokeinterface 708 1 0
    //   553: aconst_null
    //   554: areturn
    //   555: astore_1
    //   556: aconst_null
    //   557: astore 6
    //   559: aload 6
    //   561: ifnull +10 -> 571
    //   564: aload 6
    //   566: invokeinterface 708 1 0
    //   571: aload_1
    //   572: athrow
    //   573: astore_1
    //   574: goto -15 -> 559
    //   577: astore 7
    //   579: aload_1
    //   580: astore 6
    //   582: aload 7
    //   584: astore_1
    //   585: goto -26 -> 559
    //   588: astore 6
    //   590: aconst_null
    //   591: astore_1
    //   592: goto -71 -> 521
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	ForwardOperations
    //   0	595	1	paramUri	Uri
    //   67	217	2	i1	int
    //   78	12	3	i2	int
    //   95	410	4	l1	long
    //   19	562	6	localObject1	Object
    //   588	1	6	localException1	Exception
    //   160	341	7	str	String
    //   512	6	7	localException2	Exception
    //   577	6	7	localObject2	Object
    //   7	496	8	localObject3	Object
    //   199	277	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   26	41	512	java/lang/Exception
    //   57	120	512	java/lang/Exception
    //   139	162	512	java/lang/Exception
    //   162	267	512	java/lang/Exception
    //   281	291	512	java/lang/Exception
    //   294	302	512	java/lang/Exception
    //   307	322	512	java/lang/Exception
    //   345	480	512	java/lang/Exception
    //   498	509	512	java/lang/Exception
    //   9	21	555	finally
    //   26	41	573	finally
    //   57	120	573	finally
    //   139	162	573	finally
    //   162	267	573	finally
    //   281	291	573	finally
    //   294	302	573	finally
    //   307	322	573	finally
    //   345	480	573	finally
    //   498	509	573	finally
    //   521	543	577	finally
    //   9	21	588	java/lang/Exception
  }
  
  private final void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ssoGetTicketNoPasswd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 4096, this.jdField_a_of_type_Dzu);
  }
  
  private void g()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
    localIntent.putExtra("send_data_line", true);
    if (a().getBooleanExtra("isFromShare", false))
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
    }
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localIntent.putExtra("MigSdkShareNotDone", false);
    ArrayList localArrayList1;
    if (a().getBooleanExtra("sendMultiple", false))
    {
      localArrayList1 = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array");
      if (localArrayList1 == null) {
        break label586;
      }
    }
    for (;;)
    {
      ArrayList localArrayList2;
      Object localObject2;
      Object localObject1;
      try
      {
        localArrayList1 = (ArrayList)localArrayList1;
        localArrayList2 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
        if (this.v == 12)
        {
          localObject2 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("PhotoConst.PHOTO_PATHS");
          switch (this.v)
          {
          default: 
            localIntent.putExtra("sendMultiple", true);
            if (localArrayList1 == null) {
              localIntent.putStringArrayListExtra("dataline_forward_pathlist", (ArrayList)localObject2);
            }
            this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
            this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
            localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
            this.jdField_a_of_type_AndroidAppActivity.setResult(0, localIntent);
            this.jdField_a_of_type_AndroidAppActivity.finish();
            return;
          }
        }
      }
      catch (ClassCastException localClassCastException)
      {
        localObject1 = null;
        continue;
      }
      if (localObject1 == null)
      {
        localObject2 = new ArrayList();
        int i1 = 0;
        for (;;)
        {
          if (i1 < localArrayList2.size())
          {
            Uri localUri = (Uri)localArrayList2.get(i1);
            ((ArrayList)localObject2).add(a(this.jdField_a_of_type_AndroidAppActivity, localUri));
            i1 += 1;
            continue;
            localIntent.putExtra("dataline_forward_type", 100);
            break;
            localIntent.putExtra("dataline_forward_type", 101);
            break;
            switch (this.v)
            {
            default: 
              break;
            case -1: 
              localIntent.putExtra("dataline_forward_type", 102);
              localIntent.putExtra("dataline_forward_text", this.E);
              break;
            case 0: 
              localIntent.putExtra("dataline_forward_type", 100);
              if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
              {
                localObject2 = a().getStringExtra("forward_filepath");
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
                }
                localIntent.putExtra("dataline_forward_path", (String)localObject1);
                break;
              }
              localIntent.putExtra("dataline_forward_path", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a());
              break;
            case 1: 
              localIntent.putExtra("dataline_forward_type", 101);
              localObject2 = a().getStringExtra("forward_extra");
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = a().getStringExtra("forward_filepath");
              }
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
              }
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
              }
              localIntent.putExtra("dataline_forward_path", (String)localObject1);
              break;
            }
          }
        }
      }
      else
      {
        localObject2 = null;
        continue;
        label586:
        localObject1 = null;
      }
    }
  }
  
  private void h()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("audio_url");
    String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardHandlerActivity.class);
    localIntent.putExtra("send_data_line", true);
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qqfav_extra_multi_pic");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_multi_pic_path_list");
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qdshare_file");
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
      switch (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type"))
      {
      case 3: 
      case 4: 
      default: 
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", "无效的图片链接");
      }
    }
    Bundle localBundle;
    for (;;)
    {
      localBundle = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
      localBundle.putBoolean("isBack2Root", false);
      localBundle.putBoolean("is_share_flag", true);
      localBundle.putLong("res_share_id", AppShareIDUtil.a(this.jdField_a_of_type_Long));
      localBundle.putString("res_pkg_name", str2);
      localBundle.putString("res_detail_url", str1);
      localBundle.putString("app_name", str3);
      localBundle.putString("image_url_remote", (String)localObject2);
      localBundle.putString("image_url", str5);
      if (!TextUtils.isEmpty(str4)) {
        localBundle.putString("audio_url", str4);
      }
      if ((this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
      {
        localObject2 = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
        str1 = Share.a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 16);
        if (((GetAppInfoProto.AndroidInfo)localObject2).sourceUrl != null) {
          break label1057;
        }
        localObject1 = "";
        label376:
        localBundle.putString("struct_share_key_source_url", (String)localObject1);
        if (str1 != null) {
          break label1069;
        }
        localObject1 = "";
        label393:
        localBundle.putString("struct_share_key_source_icon", (String)localObject1);
        if (((GetAppInfoProto.AndroidInfo)localObject2).messagetail != null) {
          break label1075;
        }
        localObject1 = "";
        label413:
        localBundle.putString("struct_share_key_source_name", (String)localObject1);
        if (((GetAppInfoProto.AndroidInfo)localObject2).packName != null) {
          break label1087;
        }
        localObject1 = "";
        label433:
        localBundle.putString("struct_share_key_source_a_action_data", (String)localObject1);
      }
      localObject1 = new Intent();
      ((Intent)localObject1).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), "shareToQQ" })));
      localIntent.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject1, 268435456));
      if (((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) && (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))) {
        ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
      }
      localIntent.setFlags(67108864);
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
        break label1099;
      }
      localBundle.putBoolean("MigSdkShareNotDone", false);
      localBundle.putBoolean("isMigSdkShare", true);
      localObject1 = (LiteActivity)this.jdField_a_of_type_AndroidAppActivity;
      localIntent.putExtras(localBundle);
      ((LiteActivity)localObject1).a(localIntent);
      return;
      if (bool2)
      {
        localIntent.putExtra("dataline_forward_type", 100);
        if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          localIntent.putExtra("dataline_forward_path", (String)localObject1);
        } else {
          localIntent.putExtra("dataline_forward_path", str5);
        }
      }
      else
      {
        localObject1 = a(this.jdField_a_of_type_AndroidOsBundle, "");
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", (String)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004931", "0X8004931", 0, 0, "", "", "", "");
        if (QLog.isColorLevel())
        {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send text:0X8004931.");
          continue;
          localIntent.putExtra("dataline_forward_type", 101);
          localIntent.putExtra("dataline_forward_path", str5);
          continue;
          localObject1 = a(this.jdField_a_of_type_AndroidOsBundle, str4);
          localIntent.putExtra("dataline_forward_type", 102);
          localIntent.putExtra("dataline_forward_text", (String)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
          if (QLog.isColorLevel())
          {
            QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
            continue;
            if (bool1)
            {
              localIntent.putExtra("dataline_forward_type", 101);
              if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
                localIntent.putExtra("dataline_forward_path", (String)localObject1);
              } else {
                localIntent.putExtra("dataline_forward_path", str5);
              }
            }
            else
            {
              localObject1 = a(this.jdField_a_of_type_AndroidOsBundle, str1);
              localIntent.putExtra("dataline_forward_type", 102);
              localIntent.putExtra("dataline_forward_text", (String)localObject1);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
              if (QLog.isColorLevel())
              {
                QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                continue;
                if ((TextUtils.isEmpty(str5)) || (!TextUtils.isEmpty((CharSequence)localObject2))) {
                  break;
                }
                localIntent.putExtra("dataline_forward_type", 101);
                localIntent.putExtra("dataline_forward_path", str5);
              }
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty(str1))
    {
      if (HttpUtil.a((String)localObject2)) {
        break label1156;
      }
      localObject1 = "无效的图片链接";
    }
    for (;;)
    {
      localIntent.putExtra("dataline_forward_type", 102);
      localIntent.putExtra("dataline_forward_text", (String)localObject1);
      break;
      localObject1 = str1;
      continue;
      label1057:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).sourceUrl.get();
      break label376;
      label1069:
      localObject1 = str1;
      break label393;
      label1075:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).messagetail.get();
      break label413;
      label1087:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).packName.get();
      break label433;
      label1099:
      localIntent.putExtras(localBundle);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      a(0, "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800659D", "0X800659D", 0, 0, "", "", "", "");
      return;
      label1156:
      localObject1 = localObject2;
    }
  }
  
  private void i()
  {
    Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay();
    int i1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131493054);
    int i2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131493052);
    this.x = ((localDisplay.getWidth() - i1 * 2 - (AIOConstants.c - 1) * i2) / AIOConstants.c);
  }
  
  public int a()
  {
    return this.v;
  }
  
  protected int a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return 1;
    }
    if (paramArrayList.size() > 5)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqfav", 2, "gotoQfavShareMsg|image type.more than 5");
      }
      return 3;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (QfavUtil.a(str, -1L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqfav", 2, "gotoQfavShareMsg|image type.picture too big [" + str + "]");
        }
        QfavReport.a(null, "Net_AddFav", 8, 3, -3);
        return 2;
      }
    }
    return 0;
  }
  
  public String a()
  {
    if (M == null) {
      return this.jdField_a_of_type_AndroidAppActivity.getString(2131368628);
    }
    return M;
  }
  
  protected String a(Uri paramUri)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOperations", 2, "uri= " + paramUri);
    }
    Object localObject;
    if ((VersionUtils.i()) && ("com.android.fileexplorer.fileprovider".equalsIgnoreCase(paramUri.getAuthority())))
    {
      localObject = paramUri.getPathSegments();
      if ((((List)localObject).size() >= 2) && ("external_files".equalsIgnoreCase((String)((List)localObject).get(0))))
      {
        paramUri = paramUri.getPath().replaceFirst("\\/external_files", AppConstants.aE);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOperations", 2, "Nougat path: " + paramUri);
        }
        return paramUri;
      }
    }
    else if (VersionUtils.h())
    {
      localObject = paramUri.getPathSegments();
      if ((((List)localObject).size() < 2) || (!"document".equals(((List)localObject).get(0)))) {
        break label388;
      }
      localObject = (String)((List)localObject).get(1);
      if ("com.android.externalstorage.documents".equals(paramUri.getAuthority()))
      {
        localObject = ((String)localObject).split(":");
        if ("primary".equalsIgnoreCase(localObject[0])) {
          return Environment.getExternalStorageDirectory() + "/" + localObject[1];
        }
      }
      else
      {
        if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority())) {
          return a(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf((String)localObject).longValue()), null, null);
        }
        if ("com.android.providers.media.documents".equals(paramUri.getAuthority()))
        {
          localObject = ((String)localObject).split(":");
          paramUri = localObject[0];
          if ("image".equals(paramUri)) {
            paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
          }
        }
      }
    }
    for (;;)
    {
      return a(paramUri, "_id=?", new String[] { localObject[1] });
      if ("video".equals(paramUri))
      {
        paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
      }
      else if ("audio".equals(paramUri))
      {
        paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        continue;
        if ("com.google.android.apps.photos.content".equals(paramUri.getAuthority())) {}
        label388:
        do
        {
          return b(paramUri);
        } while ((((List)localObject).size() < 2) || (!"my_external".equals(((List)localObject).get(0))) || (!"com.android.contacts.files".equals(paramUri.getAuthority())));
        paramUri = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
        int i1 = 1;
        while (i1 < ((List)localObject).size())
        {
          paramUri.append('/').append((String)((List)localObject).get(i1));
          i1 += 1;
        }
        return paramUri.toString();
      }
      else
      {
        paramUri = null;
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    if ((this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper.d();
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492923));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1157	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   4: ifnull +20 -> 24
    //   7: aload_0
    //   8: getfield 1157	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   11: invokevirtual 1160	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   14: ifeq +10 -> 24
    //   17: aload_0
    //   18: getfield 1157	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   21: invokevirtual 1625	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   24: aload_0
    //   25: invokevirtual 1168	com/tencent/mobileqq/activity/ForwardOperations:d	()V
    //   28: new 1644	dzg
    //   31: dup
    //   32: aload_0
    //   33: iload_2
    //   34: aload_3
    //   35: iload 4
    //   37: aload 5
    //   39: invokespecial 1647	dzg:<init>	(Lcom/tencent/mobileqq/activity/ForwardOperations;ILjava/lang/String;ILjava/lang/String;)V
    //   42: astore 7
    //   44: iload_2
    //   45: iconst_1
    //   46: if_icmpne +42 -> 88
    //   49: iload_1
    //   50: ifne +38 -> 88
    //   53: aload_0
    //   54: iconst_1
    //   55: putfield 188	com/tencent/mobileqq/activity/ForwardOperations:d	Z
    //   58: aload_0
    //   59: getfield 224	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   62: ldc_w 377
    //   65: ldc 182
    //   67: ldc 182
    //   69: ldc_w 1649
    //   72: ldc_w 1649
    //   75: iconst_0
    //   76: iconst_0
    //   77: ldc 182
    //   79: ldc 182
    //   81: ldc 182
    //   83: ldc 182
    //   85: invokestatic 386	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   92: ifnonnull +176 -> 268
    //   95: aload_0
    //   96: new 1162	com/tencent/biz/widgets/ShareResultDialog
    //   99: dup
    //   100: aload_0
    //   101: getfield 222	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   104: invokespecial 1652	com/tencent/biz/widgets/ShareResultDialog:<init>	(Landroid/content/Context;)V
    //   107: putfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   110: aload_0
    //   111: getfield 222	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   114: ldc_w 854
    //   117: invokevirtual 786	android/app/Activity:getString	(I)Ljava/lang/String;
    //   120: astore 5
    //   122: aload 5
    //   124: astore_3
    //   125: aload_0
    //   126: getfield 247	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   129: ldc_w 784
    //   132: invokevirtual 302	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +32 -> 170
    //   141: new 509	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 510	java/lang/StringBuilder:<init>	()V
    //   148: aload 5
    //   150: invokevirtual 517	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: getfield 247	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   157: ldc_w 784
    //   160: invokevirtual 302	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: invokevirtual 517	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore_3
    //   170: aload_0
    //   171: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   174: aload_3
    //   175: aload 7
    //   177: invokevirtual 1655	com/tencent/biz/widgets/ShareResultDialog:a	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    //   180: aload_0
    //   181: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   184: ldc_w 1656
    //   187: invokevirtual 1657	com/tencent/biz/widgets/ShareResultDialog:a	(I)V
    //   190: aload_0
    //   191: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   194: astore_3
    //   195: iload_1
    //   196: ifne +82 -> 278
    //   199: iconst_1
    //   200: istore 6
    //   202: aload_3
    //   203: iload 6
    //   205: invokevirtual 1659	com/tencent/biz/widgets/ShareResultDialog:a	(Z)V
    //   208: iload_2
    //   209: iconst_2
    //   210: if_icmpne +74 -> 284
    //   213: aload_0
    //   214: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   217: ldc_w 1660
    //   220: invokevirtual 1657	com/tencent/biz/widgets/ShareResultDialog:a	(I)V
    //   223: aload_0
    //   224: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   227: iconst_0
    //   228: invokevirtual 1661	com/tencent/biz/widgets/ShareResultDialog:b	(I)V
    //   231: aload_0
    //   232: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   235: ldc_w 1662
    //   238: invokevirtual 1664	com/tencent/biz/widgets/ShareResultDialog:c	(I)V
    //   241: aload_0
    //   242: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   245: aload_0
    //   246: getfield 222	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   249: ldc_w 1665
    //   252: invokevirtual 786	android/app/Activity:getString	(I)Ljava/lang/String;
    //   255: aload 7
    //   257: invokevirtual 1667	com/tencent/biz/widgets/ShareResultDialog:b	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    //   260: aload_0
    //   261: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   264: invokevirtual 1668	com/tencent/biz/widgets/ShareResultDialog:show	()V
    //   267: return
    //   268: aload_0
    //   269: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   272: invokevirtual 1166	com/tencent/biz/widgets/ShareResultDialog:dismiss	()V
    //   275: goto -165 -> 110
    //   278: iconst_0
    //   279: istore 6
    //   281: goto -79 -> 202
    //   284: iload_1
    //   285: ifne +60 -> 345
    //   288: aload_0
    //   289: getfield 260	com/tencent/mobileqq/activity/ForwardOperations:v	I
    //   292: bipush 11
    //   294: if_icmpne +39 -> 333
    //   297: invokestatic 461	com/tencent/open/business/viareport/OpenSdkStatic:a	()Lcom/tencent/open/business/viareport/OpenSdkStatic;
    //   300: iconst_0
    //   301: ldc_w 1073
    //   304: aload_0
    //   305: getfield 224	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   308: invokevirtual 344	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   311: aload_0
    //   312: getfield 340	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_Long	J
    //   315: invokestatic 467	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   318: ldc_w 1052
    //   321: invokestatic 473	android/os/SystemClock:elapsedRealtime	()J
    //   324: invokestatic 478	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   327: iconst_0
    //   328: iconst_1
    //   329: aconst_null
    //   330: invokevirtual 481	com/tencent/open/business/viareport/OpenSdkStatic:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   333: aload_0
    //   334: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   337: aconst_null
    //   338: aconst_null
    //   339: invokevirtual 1667	com/tencent/biz/widgets/ShareResultDialog:b	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    //   342: goto -82 -> 260
    //   345: iload_1
    //   346: sipush 1002
    //   349: if_icmpne +41 -> 390
    //   352: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq +13 -> 368
    //   358: ldc_w 750
    //   361: iconst_2
    //   362: ldc_w 1670
    //   365: invokestatic 534	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: aload_0
    //   369: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   372: aload_0
    //   373: getfield 222	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   376: ldc_w 1671
    //   379: invokevirtual 786	android/app/Activity:getString	(I)Ljava/lang/String;
    //   382: aload 7
    //   384: invokevirtual 1667	com/tencent/biz/widgets/ShareResultDialog:b	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
    //   387: goto -127 -> 260
    //   390: iload_1
    //   391: sipush 1003
    //   394: if_icmpne +16 -> 410
    //   397: aload_0
    //   398: getfield 186	com/tencent/mobileqq/activity/ForwardOperations:jdField_a_of_type_ComTencentBizWidgetsShareResultDialog	Lcom/tencent/biz/widgets/ShareResultDialog;
    //   401: ldc_w 1672
    //   404: invokevirtual 1657	com/tencent/biz/widgets/ShareResultDialog:a	(I)V
    //   407: goto -39 -> 368
    //   410: iload_1
    //   411: sipush 1004
    //   414: if_icmpne +22 -> 436
    //   417: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq -52 -> 368
    //   423: ldc_w 750
    //   426: iconst_2
    //   427: ldc_w 1674
    //   430: invokestatic 534	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: goto -65 -> 368
    //   436: iload_1
    //   437: sipush 1005
    //   440: if_icmpne -72 -> 368
    //   443: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq -78 -> 368
    //   449: ldc_w 750
    //   452: iconst_2
    //   453: ldc_w 1676
    //   456: invokestatic 534	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: goto -91 -> 368
    //   462: astore_3
    //   463: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq -199 -> 267
    //   469: ldc_w 750
    //   472: iconst_2
    //   473: ldc_w 1678
    //   476: invokestatic 534	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: return
    //   480: astore_3
    //   481: goto -148 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	this	ForwardOperations
    //   0	484	1	paramInt1	int
    //   0	484	2	paramInt2	int
    //   0	484	3	paramString1	String
    //   0	484	4	paramInt3	int
    //   0	484	5	paramString2	String
    //   200	80	6	bool	boolean
    //   42	341	7	localdzg	dzg
    // Exception table:
    //   from	to	target	type
    //   260	267	462	java/lang/Exception
    //   297	333	480	java/lang/Exception
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    a(paramInt, 1, null, 0, null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void a(Intent paramIntent)
  {
    int i2 = 1;
    d();
    paramIntent = paramIntent.getStringExtra("result");
    if (QLog.isColorLevel()) {
      QLog.d("Q.send_hong_bao", 2, "ForwardOperations.onActivityResult_sendHongBao(). result_from_cai_fu_tong_SDK=" + paramIntent);
    }
    label324:
    label372:
    for (;;)
    {
      int i1;
      int i3;
      try
      {
        paramIntent = new JSONObject(paramIntent);
        i1 = i2;
        if (paramIntent.has("resultCode"))
        {
          i3 = paramIntent.getInt("resultCode");
          if (i3 != 0) {
            break label254;
          }
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "红包已发送", 1).a();
          paramIntent = new Intent("Common_BroadcastReceiver");
          paramIntent.putExtra("send_hb_success", true);
          this.jdField_a_of_type_AndroidAppActivity.sendBroadcast(paramIntent);
          if (a())
          {
            ((BasePadActivity)this.jdField_a_of_type_AndroidAppActivity).closeModalWindow();
            break label372;
          }
        }
        else
        {
          if (i1 == 0) {
            break;
          }
          if (this.jdField_D_of_type_Int <= 0) {
            break label324;
          }
          this.jdField_D_of_type_Int -= 1;
          paramIntent = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, "发送失败", this.jdField_a_of_type_AndroidAppActivity.getString(2131367598), null, null);
          paramIntent.setPositiveButton(2131367599, new dyi(this, paramIntent));
          paramIntent.setNegativeButton(2131365736, new dyj(this, paramIntent));
          paramIntent.show();
          return;
        }
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
      label254:
      if (i3 != 66201004)
      {
        i1 = i2;
        if (i3 != 66209015) {}
      }
      else
      {
        paramIntent = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, "发送失败", this.jdField_a_of_type_AndroidAppActivity.getString(2131367598), null, null);
        paramIntent.setNegativeButton(2131366374, new dzt(this, paramIntent));
        paramIntent.show();
        i1 = 0;
        continue;
        paramIntent = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, "发送失败", this.jdField_a_of_type_AndroidAppActivity.getString(2131367598), null, null);
        paramIntent.setNegativeButton(2131366374, new dyk(this, paramIntent));
        paramIntent.show();
        return;
        i1 = 0;
      }
    }
  }
  
  public void a(String paramString, int paramInt, Bundle paramBundle)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(BaseApplicationImpl.a, 2131365941, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492923));
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("listid", paramBundle.getString("hb_id"));
        localJSONObject2.put("send_uin", paramBundle.getString("send_uin"));
        localJSONObject2.put("hb_type", Integer.parseInt(paramBundle.getString("hb_type")));
        switch (paramInt)
        {
        case 1: 
          localJSONObject2.put("recv_uin", paramString);
          localJSONObject2.put("appid", String.valueOf(AppSetting.a));
          localJSONObject2.put("from_memo", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          localJSONObject1.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localJSONObject1.put("viewTag", "qpay_hb_share");
          localJSONObject1.put("extra_data", localJSONObject2);
        }
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject2;
        continue;
      }
      paramString = new Bundle();
      paramString.putString("json", localJSONObject1.toString());
      paramString.putString("callbackSn", "0");
      if (QLog.isColorLevel()) {
        QLog.d("Q.send_hong_bao", 2, "ForwardOperations.forwardTo(). passed data=" + paramString.toString());
      }
      this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, PayBridgeActivity.class);
      this.jdField_a_of_type_AndroidContentIntent.putExtras(paramString);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("pay_requestcode", 5);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 20002);
      a(2131367600);
      return;
      localJSONObject2.put("recv_type", 3);
      continue;
      localJSONObject2.put("recv_type", 2);
      continue;
      localJSONObject2.put("recv_type", 1);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    a(2131363688);
    new dzb(this, paramString1, paramInt, paramString2).start();
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((a() != null) && ((a().getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (a().getBooleanExtra("qqfav_extra_from_system_share", false))))
    {
      b(paramString1, paramInt, paramString2, paramString3);
      break label44;
    }
    label44:
    while ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    this.N = paramString1;
    this.jdField_C_of_type_Int = paramInt;
    this.O = paramString2;
    this.P = paramString3;
    Object localObject1;
    Object localObject2;
    if (this.v == 1001)
    {
      if (this.w == 13) {
        a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentIntent, paramString1);
      }
    }
    else
    {
      if (this.v == 13)
      {
        localObject1 = new dzp(this);
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramInt, "0", paramString3, paramString1, true, paramString2, true, true, (Handler.Callback)localObject1, null);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "10", "", "", "");
        return;
      }
      if (this.v == 14)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramString1);
        this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", paramInt);
        this.jdField_a_of_type_AndroidOsBundle.putInt("FORWARD_EMOPGK_ID", this.y);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", true);
        this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
        this.jdField_a_of_type_AndroidContentIntent.addFlags(268435456);
        this.jdField_a_of_type_AndroidContentIntent.addFlags(67108864);
        this.jdField_a_of_type_AndroidContentIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("FORWARD_EMOPGK_ID", true).commit();
        this.jdField_a_of_type_AndroidAppActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_send_nonaio_suc", 0, 0, "", "", "", "FORWARD_EMOPGK_ID");
        return;
      }
      if (this.v == 15)
      {
        paramString2 = new ArrayList();
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        if ((paramInt == 0) || (paramInt == 1004))
        {
          paramString2.add(paramString1);
          ((ArrayList)localObject1).add("");
          ((ArrayList)localObject2).add(paramString3);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
          {
            paramString1 = new Bundle();
            paramString1.putStringArrayList("choose_friend_uins", paramString2);
            paramString1.putStringArrayList("choose_friend_phones", (ArrayList)localObject1);
            paramString1.putStringArrayList("choose_friend_names", (ArrayList)localObject2);
            this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().postDelayed(new dzq(this, paramString1), 100L);
          }
          if (this.jdField_a_of_type_AndroidAppActivity == null) {
            break;
          }
          this.jdField_a_of_type_AndroidAppActivity.setResult(1);
          this.jdField_a_of_type_AndroidAppActivity.finish();
          return;
          if (paramInt == 1006)
          {
            paramString2.add("");
            ((ArrayList)localObject1).add(paramString1);
            ((ArrayList)localObject2).add(paramString3);
          }
        }
      }
      if (this.v == 16)
      {
        a(2131367583);
        long l1 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("appid", -1L);
        UiApiPlugin.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, new String[] { paramString1 }, new int[] { paramInt });
        return;
      }
      if (this.v == 18)
      {
        paramString2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
        localObject1 = a().getExtras();
        ((Bundle)localObject1).putString("uin", paramString1);
        ((Bundle)localObject1).putInt("uintype", paramInt);
        ((Bundle)localObject1).putString("uinname", paramString3);
        paramString2.putExtras((Bundle)localObject1);
        paramString1 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(74);
        if (paramString1 != null) {
          paramString2.putExtra("input_text_redpacket", paramString1.a());
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString2);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
      }
    }
    if (AppConstants.Y.equals(paramString1)) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.getInt("emoInputType", 0);
      if (this.v == 11)
      {
        if ((AppConstants.Y.equals(paramString1)) || (AppConstants.ai.equals(paramString1))) {
          this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 0);
        }
      }
      else {
        label797:
        if (this.jdField_a_of_type_Long != 55901189L) {
          break label1434;
        }
      }
      label1434:
      for (localObject1 = null;; localObject1 = paramString3)
      {
        if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
        }
        d();
        paramString3 = new dzr(this, paramInt, paramString2, paramString1, paramString3);
        localObject2 = new dzs(this);
        paramInt = this.jdField_a_of_type_AndroidOsBundle.getInt("emoInputType", 0);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (paramString1 = "发送到 " + (String)localObject1;; paramString1 = (String)localObject1)
        {
          if (paramInt == 0)
          {
            localObject1 = this.jdField_a_of_type_AndroidAppActivity;
            String str = this.E;
            if (this.v != 19)
            {
              paramInt = 2131366313;
              label934:
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a((Context)localObject1, 230, paramString1, str, 2131365736, paramInt, paramString3, (DialogInterface.OnClickListener)localObject2);
              label957:
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(this);
              if (this.v != 0) {
                break label1197;
              }
              if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("forward_type")))
              {
                QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131368633), 1).a();
                this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
              }
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageMaxLine(2);
            a(this.B, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
            this.A = paramString2;
            if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
            return;
            if ("-1010".equals(paramString1))
            {
              this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 1);
              break label797;
            }
            this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 2);
            break label797;
            paramInt = 2131366314;
            break label934;
            if (paramInt == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramString1, this.E, null, paramString3, (DialogInterface.OnClickListener)localObject2);
              break label957;
            }
            if (paramInt == 2)
            {
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, paramString1, this.E, null, paramString3, (DialogInterface.OnClickListener)localObject2);
              break label957;
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, paramString1, this.E, 2131365736, 2131366313, paramString3, (DialogInterface.OnClickListener)localObject2);
            break label957;
            label1197:
            if (this.v == 1)
            {
              if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("forward_type")))
              {
                QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131368633), 1).a();
                this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
              }
              if (!TextUtils.isEmpty(this.B)) {
                this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
              }
            }
            else if (this.v == 12)
            {
              if ((this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("forward_type")))
              {
                QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131368633), 1).a();
                this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
              }
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageCount(this.E);
            }
            else if (this.v == -2)
            {
              paramString1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_location_string");
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString1);
            }
            else if (this.v == 2)
            {
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage("");
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageWithEmo(this.E, this.jdField_a_of_type_Float);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, HashMap paramHashMap)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(1003, 0, paramString1, paramInt, paramString2);
      return;
    }
    if ((this.w != 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("image_url"))))
    {
      a(1002, 0, paramString1, paramInt, paramString2);
      return;
    }
    if (paramHashMap.containsKey("imageUrl"))
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", (String)paramHashMap.get("imageUrl"));
      this.jdField_a_of_type_AndroidOsBundle.remove("image_url");
    }
    if (paramHashMap.containsKey("audioUrl")) {
      this.jdField_a_of_type_AndroidOsBundle.putString("audio_url", (String)paramHashMap.get("audioUrl"));
    }
    if (paramHashMap.containsKey("targetUrl")) {
      this.jdField_a_of_type_AndroidOsBundle.putString("detail_url", (String)paramHashMap.get("targetUrl"));
    }
    if (paramHashMap.containsKey("sourceUrl")) {
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", (String)paramHashMap.get("sourceUrl"));
    }
    if (paramHashMap.containsKey("sourceIcon")) {
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", (String)paramHashMap.get("sourceIcon"));
    }
    paramHashMap = new Intent(this.jdField_a_of_type_AndroidAppActivity, MessageShareActivity.class);
    Bundle localBundle = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    localBundle.putString("uin", paramString1);
    localBundle.putInt("uintype", paramInt);
    localBundle.putString("uinname", paramString2);
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
      ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
    }
    paramHashMap.putExtras(localBundle);
    paramHashMap.setFlags(67108864);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramHashMap);
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sha_share2qq", 1, "", "", String.valueOf(this.jdField_a_of_type_Long));
    if (this.w == 5) {}
    for (paramString2 = "connect_sharepic";; paramString2 = "connect_share2qq")
    {
      Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2, "send", this.jdField_a_of_type_Long, b(), String.valueOf(paramInt));
      a(0, "", "");
      return;
    }
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePadActivity)) && (((BasePadActivity)this.jdField_a_of_type_AndroidAppActivity).isModeleWindow());
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID;
    }
    return 0;
  }
  
  public String b(Uri paramUri)
  {
    Object localObject = null;
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file"))) {
      localObject = new File(paramUri.getPath()).getAbsolutePath();
    }
    for (;;)
    {
      return localObject;
      if (str.equals("content")) {
        try
        {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
          int i1 = ((Cursor)localObject).getColumnIndexOrThrow("_data");
          ((Cursor)localObject).moveToFirst();
          str = ((Cursor)localObject).getString(i1);
          ((Cursor)localObject).close();
          localObject = str;
          if (!new File(str).canRead())
          {
            localObject = c(paramUri);
            return localObject;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return c(paramUri);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    a(2131363688);
    new dzi(this).start();
  }
  
  public void b(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    d();
    String str;
    if (this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog == null)
    {
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog = new ShareResultDialog(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.b(null, null);
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131366374);
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.a(str, new dzh(this));
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.a(2131363523);
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131363681);
      }
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.b(str);
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.show();
      return;
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
  }
  
  public void b(String paramString, int paramInt, Bundle paramBundle) {}
  
  public int c()
  {
    try
    {
      l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str1;
        Object localObject2;
        int i5;
        int i6;
        label202:
        label212:
        long l1 = 0L;
        label252:
        localException1.printStackTrace();
        String str2 = "";
        continue;
        label264:
        this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title");
        continue;
        label278:
        i1 = i6;
        if (this.v != 11) {
          break;
        }
        i1 = i6;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) {
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
        {
          localObject2 = QfavUtil.a((StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
          i3 = i2;
          ArrayList localArrayList;
          if (localObject2 != null)
          {
            localArrayList = new ArrayList();
            localArrayList.add(((StructMsgItemImage)localObject2).j);
            i3 = a(localArrayList);
            if (i3 == 0) {
              break label367;
            }
          }
          for (;;)
          {
            i2 = 1;
            i1 = 3;
            break;
            label367:
            i3 = i2;
            if (QfavBuilder.a(localArrayList, true, a().getStringExtra("qqfav_extra_richmedia_title"), a().getStringExtra("qqfav_extra_mixed_msg"), true, this.jdField_a_of_type_Long, (String)localObject1).a(l1, str2).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
              i3 = 0;
            }
          }
        }
        if (a().getBooleanExtra("qqfav_extra_pic_share", false))
        {
          i1 = 8;
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("qqfav_extra_multi_pic_path_list");
          boolean bool = a().getBooleanExtra("qqfav_extra_only_pic", true);
          if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
            break label768;
          }
          i1 = a((ArrayList)localObject2);
          if (i1 != 0) {}
          for (;;)
          {
            if ((!bool) || (1 != ((ArrayList)localObject2).size())) {
              break label762;
            }
            i2 = 3;
            label515:
            i4 = ((ArrayList)localObject2).size();
            i3 = i1;
            i1 = i2;
            i2 = i4;
            label529:
            break;
            i1 = i5;
            if (QfavBuilder.a((ArrayList)localObject2, bool, a().getStringExtra("qqfav_extra_richmedia_title"), a().getStringExtra("qqfav_extra_mixed_msg"), true, this.jdField_a_of_type_Long, (String)localObject1).a(l1, str2).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
              i1 = 0;
            }
          }
        }
        Object localObject1 = QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getXmlBytes());
        i3 = 0;
        if (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
          break label757;
        }
        i3 = 2;
        i2 = 10;
        label629:
        i1 = i2;
        if (!QfavBuilder.a(i3, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSummary, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentCover, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSrc, (byte[])localObject1, true, this.jdField_a_of_type_Long).a(l1, str2).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
          break;
        }
        i3 = 0;
        i4 = 0;
        i1 = i2;
        i2 = i4;
      }
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", i1, 0, 68, i2, "", "");
      return i3;
    }
    try
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131364738);
      }
      i2 = 1;
      i5 = 1;
      i3 = 1;
      i4 = 1;
      i6 = -1;
      if (this.v != -1) {
        break label278;
      }
      i1 = 1;
      if ((TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"))) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg")))) {
        break label749;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"))) {
        break label264;
      }
      this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg");
      if (!QfavBuilder.a(null, false, this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg"), true, this.jdField_a_of_type_Long, (String)localObject1).a(l1, str1).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
        break label773;
      }
      i1 = 0;
    }
    catch (Exception localException2)
    {
      break label252;
      i2 = 0;
      i3 = i4;
      break label212;
      i2 = 2;
      break label629;
      i2 = 8;
      break label515;
      i2 = 0;
      break label529;
      i1 = 1;
      break label202;
    }
    i2 = 0;
    i4 = 1;
    i3 = i1;
    i1 = i4;
    if (a().getBooleanExtra("qqfav_extra_from_system_share", false))
    {
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", i1, 0, 67, i2, "", "");
      return i3;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new dzl(this));
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void e()
  {
    Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("title");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("desc");
    Object localObject2 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = localObject3;
      if (((String)localObject3).endsWith("...")) {
        localObject2 = ((String)localObject3).substring(0, ((String)localObject3).lastIndexOf("..."));
      }
    }
    localObject3 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = localObject1;
      if (((String)localObject1).endsWith("...")) {
        localObject3 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf("..."));
      }
    }
    localObject1 = localObject2;
    if (SubString.a((String)localObject2, "UTF-8") > 45) {
      localObject1 = SubString.a((String)localObject2, 45, "UTF-8", null);
    }
    Object localObject4 = localObject3;
    if (SubString.a((String)localObject3, "UTF-8") > 90) {
      localObject4 = SubString.a((String)localObject3, 90, "UTF-8", null);
    }
    localObject2 = localObject4;
    if (SubString.a((String)localObject1, "UTF-8") + SubString.a((String)localObject4, "UTF-8") > 105) {
      localObject2 = SubString.a((String)localObject4, 105 - ((String)localObject1).length(), "UTF-8", "...");
    }
    if ((localObject1 != null) && (!((String)localObject1).endsWith("...")) && (!((String)localObject1).equals(this.jdField_a_of_type_AndroidOsBundle.getString("title")))) {
      localObject1 = (String)localObject1 + "...";
    }
    for (;;)
    {
      if ((localObject2 != null) && (!((String)localObject2).endsWith("...")) && (!((String)localObject2).equals(this.jdField_a_of_type_AndroidOsBundle.getString("desc")))) {
        localObject2 = (String)localObject2 + "...";
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("title", (String)localObject1);
        this.jdField_a_of_type_AndroidOsBundle.putString("desc", (String)localObject2);
        return;
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof DirectForwardActivity)) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004048", "0X8004048", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardOperations
 * JD-Core Version:    0.7.0.1
 */