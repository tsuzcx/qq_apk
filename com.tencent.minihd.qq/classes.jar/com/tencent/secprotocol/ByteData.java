package com.tencent.secprotocol;

import a.a.a.b.a;
import a.a.a.b.d;
import a.a.a.b.e;
import a.a.a.b.f;
import a.a.a.b.g;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.secprotocol.t.ReportLogHelper;
import com.tencent.secprotocol.t.s;
import com.tencent.secprotocol.utils.IPutListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ByteData
{
  public static final String BMP_ARRIVE_TIME = "bmp_arrive_time_stamp";
  public static final int MSG_DATA_BMP = 164;
  public static final int MSG_DATA_ORDER = 165;
  public static final int MSG_DATA_UPING = 163;
  public static final int MSG_DATA_WRITE_SP = 162;
  public static final int MSG_INTERNAL_DATA_UPING = 161;
  public static final String MY_VERSION = "0.3.7";
  public static final long REQUEST_TIME_BUFF = 43200L;
  public static final int RH_SCV = 1;
  public static final String SP_MARK_TIME = "mark_time_";
  public static final String TIME_STAMP_NAME = "byte_data_time_stamp";
  public static final String VAL_ARRIVE_TIME = "val_arrive_time";
  public static boolean isMsf = false;
  public static final boolean isPrint = false;
  public static Handler mDataHandler;
  public static String processName = "";
  public static String sSessionID = "";
  public a.a.a.b.b cData = null;
  public String filterName = "";
  public boolean filterStatus = false;
  public HandlerThread handlerThread = null;
  public a mBmpMgr = null;
  public Context mContext = null;
  public boolean mPoxyInit = false;
  public boolean mPoxyNativeLoaded = false;
  public final String mThradName = "ByteThread";
  public String mUin = null;
  public final byte[] status = { 0, 0, 0, 0 };
  
  public ByteData()
  {
    try
    {
      this.handlerThread = new HandlerThread("ByteThread");
      this.handlerThread.start();
      mDataHandler = new e(this.handlerThread.getLooper());
      return;
    }
    catch (Exception localException)
    {
      this.status[3] = 11;
      localException.printStackTrace();
    }
  }
  
  private boolean checkObject(long paramLong, Object paramObject)
  {
    if (paramLong == 0L) {}
    while (((paramObject instanceof byte[])) && (paramObject != null) && (((byte[])paramObject).length > 0)) {
      return false;
    }
    return true;
  }
  
  private boolean checkProgressName()
  {
    if (!processName.isEmpty())
    {
      String[] arrayOfString = processName.split(":");
      logCat("poxy_java", "temp[temp.length-1]: " + arrayOfString[(arrayOfString.length - 1)]);
      if (arrayOfString[(arrayOfString.length - 1)].equalsIgnoreCase("msf"))
      {
        isMsf = true;
        return isMsf;
      }
    }
    return isMsf;
  }
  
  private boolean checkToa()
  {
    if (!isMsf)
    {
      Object localObject = this.mContext.getSharedPreferences("bmp_arrive_time_stamp_" + processName, 0);
      long l1 = System.currentTimeMillis();
      long l2 = l1 - ((SharedPreferences)localObject).getLong("val_arrive_time", 0L);
      if ((l2 > 43200L) && (l2 > 0L))
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putLong("val_arrive_time", l1);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    else
    {
      return true;
    }
    return false;
  }
  
  private native byte[] getByte(Context paramContext, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  private Context getContext()
  {
    return this.mContext;
  }
  
  public static ByteData getInstance()
  {
    return d.a;
  }
  
  private void initLoadlibrary()
  {
    if (this.mPoxyInit) {}
    while (this.mPoxyNativeLoaded) {
      return;
    }
    if (a.a.a.a.b.b(this.mContext, "poxy"))
    {
      this.mPoxyNativeLoaded = true;
      this.mPoxyInit = true;
      return;
    }
    this.status[3] = 10;
  }
  
  public static void logCat(String paramString1, String paramString2) {}
  
  private native int putByte(Context paramContext, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  private void putDwoning(int paramInt1, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2)
  {
    if ((!this.mPoxyNativeLoaded) || (!this.mPoxyInit) || (paramObject1 == null)) {
      return;
    }
    long l1 = paramInt1;
    long l2 = paramInt2;
    long l3 = paramInt3;
    try
    {
      putByte(null, l1, l2, l3, 0L, paramObject1, this.cData.b, null, paramObject2);
      return;
    }
    catch (Exception paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  private void setContext(Context paramContext)
  {
    if ((paramContext instanceof Context)) {
      this.mContext = paramContext;
    }
  }
  
  private void writeSp(long paramLong)
  {
    try
    {
      if (this.mPoxyNativeLoaded)
      {
        if (!this.mPoxyInit) {
          return;
        }
        Object localObject = s.md5sum(this.cData.e);
        localObject = this.mContext.getSharedPreferences("mark_time_" + processName + "_" + (String)localObject, 4).edit();
        ((SharedPreferences.Editor)localObject).putLong("byte_data_time_stamp", paramLong);
        ((SharedPreferences.Editor)localObject).commit();
        sSessionID = String.valueOf(paramLong);
        this.cData.f = sSessionID;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public byte[] getCode(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if (checkObject(paramLong1, paramObject4))
    {
      paramObject1 = this.status;
      paramObject1[3] = 12;
      return paramObject1;
    }
    if ((this.status[1] != 0) || (!this.mPoxyNativeLoaded) || (!this.mPoxyInit))
    {
      paramObject1 = this.status;
      if (paramObject1[3] == 0) {
        paramObject1[3] = 13;
      }
      return this.status;
    }
    this.cData.e = ((String)paramObject3);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.cData.b);
    localArrayList.add(String.valueOf(1));
    localArrayList.add(this.cData.e);
    localArrayList.add((String)paramObject5);
    localArrayList.add(this.cData.d);
    localArrayList.add(this.cData.f);
    localArrayList.add((String)paramObject1);
    localArrayList.add(this.cData.g);
    localArrayList.add(processName);
    ReportLogHelper.report(5, 0);
    return getByte(this.mContext, paramLong1, paramLong2, paramLong3, paramLong4, (String[])localArrayList.toArray(new String[localArrayList.size()]), paramObject2, paramObject3, paramObject4);
  }
  
  public byte[] getSign(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return getCode(1L, 0L, 0L, 0L, "", "", paramString1, paramArrayOfByte, paramString2);
  }
  
  public void init(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((paramContext == getInstance().getContext()) || (this.mPoxyInit) || (paramContext == null))
    {
      logCat("poxy_java", "init fail!");
      return;
    }
    try
    {
      processName = s.getProcessName(paramContext);
      this.mBmpMgr = new a(paramContext, processName);
      this.cData = new a.a.a.b.b(paramContext, paramString1, "", paramString2, paramString3, paramString4, sSessionID, paramString5, "0.3.7");
      setContext(paramContext);
      initLoadlibrary();
      checkProgressName();
      logCat("poxy_java", "isMsf: " + isMsf);
      ReportLogHelper.report(4, 0);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void processFilterSwitch(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.isEmpty(paramString)))
    {
      Log.d("ByteData", "[warning]: Process name is empty !");
      return;
    }
    if (paramBoolean)
    {
      this.filterStatus = paramBoolean;
      this.filterName = paramString;
      return;
    }
    this.filterStatus = paramBoolean;
    this.filterName = "";
  }
  
  public void putUping(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    try
    {
      d locald = new d(paramInt2, paramInt3, paramObject);
      Message localMessage = mDataHandler.obtainMessage(paramInt1);
      localMessage.obj = locald;
      logCat("ByteData", "poxy_java --> putType: " + paramInt1 + " cmd: " + paramInt2 + " reqTyep: " + paramInt3 + " cabk report log " + paramObject);
      mDataHandler.sendMessage(localMessage);
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public void runTime(final int paramInt1, final String paramString, final int paramInt2)
  {
    if ((!this.mPoxyNativeLoaded) || (!this.mPoxyInit)) {}
    while ((this.filterStatus) && (!processName.equals(this.filterName))) {
      return;
    }
    try
    {
      mDataHandler.post(new c(paramInt1, paramInt2, paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setData(final String paramString)
  {
    if ((!this.mPoxyNativeLoaded) || (!this.mPoxyInit)) {
      return;
    }
    try
    {
      mDataHandler.post(new a(paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setDataEx(final String paramString1, final String paramString2)
  {
    if ((!this.mPoxyNativeLoaded) || (!this.mPoxyInit)) {
      return;
    }
    try
    {
      mDataHandler.post(new b(paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public class a
    implements Runnable
  {
    public a(String paramString) {}
    
    public void run()
    {
      try
      {
        if (!ByteData.access$100(ByteData.this))
        {
          ByteData.logCat("poxy_java", "time is not arrive！");
          return;
        }
        ReportLogHelper.report(2, 4);
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new f(ByteData.access$200(ByteData.this)).a(10, 1, paramString, ByteData.access$300(ByteData.this));
        JSONObject localJSONObject3 = ByteData.access$400(ByteData.this).a();
        localJSONObject1.put(g.a(19), localJSONObject2);
        localJSONObject1.put(g.a(20), localJSONObject3);
        ByteData.access$500(ByteData.this, 164, 10, 0, localJSONObject1.toString(), new a());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public class a
      implements IPutListener
    {
      public a() {}
      
      public void onResult(Object paramObject, int paramInt)
      {
        if ((paramInt == 0) && (paramObject != null))
        {
          ByteData.access$400(ByteData.this).a((String)paramObject);
          ByteData.logCat("poxy_java", "data: " + paramObject);
        }
      }
    }
  }
  
  public class b
    implements Runnable
  {
    public b(String paramString1, String paramString2) {}
    
    public void run()
    {
      try
      {
        ByteData.access$300(ByteData.this).e = paramString1;
        ReportLogHelper.report(3, 2);
        final e locale = new e();
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject3 = new f(ByteData.access$200(ByteData.this)).a(11, 1, paramString2, ByteData.access$300(ByteData.this));
        JSONObject localJSONObject1 = new JSONObject();
        try
        {
          localJSONObject1.put(g.a(24), 1);
          localJSONObject1.put(g.a(26), "");
          localJSONObject1.put(g.a(25), "");
          localJSONObject2.put(g.a(19), localJSONObject3);
          localJSONObject2.put(g.a(20), localJSONObject1);
          ByteData.access$500(ByteData.this, 165, 11, 0, localJSONObject2.toString(), new a(locale));
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            Object localObject = null;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public class a
      implements IPutListener
    {
      public a(e parame) {}
      
      public void onResult(Object paramObject, int paramInt)
      {
        if ((paramInt == 0) && (paramObject != null))
        {
          locale.a(ByteData.b.this.b, (String)paramObject);
          ByteData.logCat("poxy_java", "test, data: " + paramObject);
        }
      }
    }
  }
  
  public class c
    implements Runnable
  {
    public c(int paramInt1, int paramInt2, String paramString) {}
    
    public void run()
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ByteData.access$300(ByteData.this).b);
      localArrayList.add(String.valueOf(1));
      localArrayList.add(ByteData.access$300(ByteData.this).e);
      localArrayList.add("");
      localArrayList.add(ByteData.access$300(ByteData.this).d);
      localArrayList.add(ByteData.access$300(ByteData.this).f);
      localArrayList.add("");
      localArrayList.add(ByteData.access$300(ByteData.this).g);
      localArrayList.add(ByteData.access$600());
      ByteData localByteData = ByteData.this;
      ByteData.access$700(localByteData, ByteData.access$200(localByteData), 2L, paramInt1, 0L, paramInt2, (String[])localArrayList.toArray(new String[localArrayList.size()]), ByteData.access$300(ByteData.this).g, ByteData.access$300(ByteData.this).d, paramString);
    }
  }
  
  public static class d
  {
    public static final ByteData a = new ByteData(null);
  }
  
  public class e
    extends Handler
  {
    public e(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      d locald = (d)paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 162: 
        ByteData.access$900(ByteData.this, Long.valueOf((String)locald.c).longValue());
        return;
      }
      ByteData.logCat("java_poxy", "cmd: " + locald.a + " reqType: " + locald.b);
      ByteData.access$500(ByteData.this, paramMessage.what, locald.a, locald.b, locald.c, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData
 * JD-Core Version:    0.7.0.1
 */