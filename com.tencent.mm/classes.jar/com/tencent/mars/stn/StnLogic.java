package com.tencent.mars.stn;

import com.tencent.mars.Mars;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class StnLogic
{
  public static final int CONNECTED = 4;
  public static final int CONNECTTING = 3;
  public static int ECHECK_NEVER = 0;
  public static int ECHECK_NEXT = 0;
  public static int ECHECK_NOW = 0;
  public static final int GATEWAY_FAILED = 1;
  public static final int INVALID_TASK_ID = -1;
  public static final int NETWORK_UNAVAILABLE = 0;
  public static final int NETWORK_UNKNOWN = -1;
  public static int RESP_FAIL_HANDLE_DEFAULT = 0;
  public static int RESP_FAIL_HANDLE_NORMAL = 0;
  public static int RESP_FAIL_HANDLE_SESSION_TIMEOUT = 0;
  public static int RESP_FAIL_HANDLE_TASK_END = 0;
  public static final int SERVER_DOWN = 5;
  public static final int SERVER_FAILED = 2;
  private static final String TAG = "mars.StnLogic";
  private static StnLogic.ICallBack callBack;
  public static final int ectDial = 2;
  public static final int ectDns = 3;
  public static final int ectEnDecode = 7;
  public static final int ectFalse = 1;
  public static final int ectHttp = 5;
  public static final int ectLocal = 9;
  public static final int ectNetMsgXP = 6;
  public static final int ectOK = 0;
  public static final int ectServer = 8;
  public static final int ectSocket = 4;
  
  static
  {
    try
    {
      ArrayList localArrayList = getLoadLibraries();
      Mars.checkLoadedModules(localArrayList, "mars.StnLogic");
      ECHECK_NOW = 0;
      ECHECK_NEXT = 1;
      ECHECK_NEVER = 2;
      RESP_FAIL_HANDLE_NORMAL = 0;
      RESP_FAIL_HANDLE_DEFAULT = -1;
      RESP_FAIL_HANDLE_SESSION_TIMEOUT = -13;
      RESP_FAIL_HANDLE_TASK_END = -14;
      callBack = null;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject = null;
        Mars.loadDefaultMarsLibrary();
      }
    }
  }
  
  private static int buf2Resp(int paramInt1, Object paramObject, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt2)
  {
    return 0;
  }
  
  private static int buf2Resp(int paramInt1, Object paramObject, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    if (callBack == null) {
      return RESP_FAIL_HANDLE_TASK_END;
    }
    return callBack.buf2Resp(paramInt1, paramObject, paramArrayOfByte, paramArrayOfInt1, paramArrayOfInt2, paramInt2);
  }
  
  public static native void clearTask();
  
  private static String exception2String(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  private static native ArrayList<String> getLoadLibraries();
  
  private static int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2, int[] paramArrayOfInt)
  {
    if (callBack == null) {
      return ECHECK_NEVER;
    }
    return callBack.getLongLinkIdentifyCheckBuffer(paramByteArrayOutputStream1, paramByteArrayOutputStream2, paramArrayOfInt);
  }
  
  public static native boolean hasTask(int paramInt);
  
  public static boolean isLogoned()
  {
    if (callBack == null) {
      return false;
    }
    return callBack.isLogoned();
  }
  
  public static native void keepSignalling();
  
  private static boolean makesureAuthed(String paramString)
  {
    if (callBack == null) {
      return false;
    }
    return callBack.makesureAuthed(paramString);
  }
  
  public static native void makesureLongLinkConnected();
  
  private static void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (callBack == null) {
      return;
    }
    callBack.networkAnalysisCallBack(paramInt1, paramInt2, paramBoolean, paramString);
  }
  
  private static boolean onLongLinkIdentifyResp(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (callBack == null) {
      return false;
    }
    return callBack.onLongLinkIdentifyResp(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  private static String[] onNewDns(String paramString)
  {
    if (callBack == null) {
      return null;
    }
    return callBack.onNewDns(paramString);
  }
  
  private static void onPush(int paramInt, byte[] paramArrayOfByte)
  {
    if (callBack == null) {
      return;
    }
    callBack.onPush(paramInt, paramArrayOfByte);
  }
  
  private static int onTaskEnd(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    if (callBack == null) {
      return 0;
    }
    return callBack.onTaskEnd(paramInt1, paramObject, paramInt2, paramInt3);
  }
  
  public static native void redoTask();
  
  private static void reportConnectStatus(int paramInt1, int paramInt2)
  {
    if (callBack == null) {
      return;
    }
    callBack.reportConnectInfo(paramInt1, paramInt2);
  }
  
  private static void reportTaskProfile(String paramString) {}
  
  private static boolean req2Buf(int paramInt1, Object paramObject, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2, String paramString)
  {
    if (callBack == null) {
      return false;
    }
    return callBack.req2Buf(paramInt1, paramObject, paramByteArrayOutputStream, paramArrayOfInt, paramInt2, paramString);
  }
  
  public static void requestDoSync()
  {
    if (callBack == null) {
      return;
    }
    callBack.requestDoSync();
  }
  
  private static String[] requestNetCheckShortLinkHosts()
  {
    if (callBack == null) {
      return null;
    }
    return callBack.requestNetCheckShortLinkHosts();
  }
  
  public static native void reset();
  
  public static native void setBackupIPs(String paramString, String[] paramArrayOfString);
  
  public static void setCallBack(StnLogic.ICallBack paramICallBack)
  {
    callBack = paramICallBack;
  }
  
  public static native void setDebugIP(String paramString1, String paramString2);
  
  public static void setLonglinkSvrAddr(String paramString, int[] paramArrayOfInt)
  {
    setLonglinkSvrAddr(paramString, paramArrayOfInt, null);
  }
  
  public static native void setLonglinkSvrAddr(String paramString1, int[] paramArrayOfInt, String paramString2);
  
  public static native void setProductID(short paramShort);
  
  public static void setShortlinkSvrAddr(int paramInt)
  {
    setShortlinkSvrAddr(paramInt, null);
  }
  
  public static native void setShortlinkSvrAddr(int paramInt, String paramString);
  
  public static native void setSignallingStrategy(long paramLong1, long paramLong2);
  
  public static native boolean startNetworkAnalysis();
  
  public static native void startTask(StnLogic.Task paramTask);
  
  public static native void stopSignalling();
  
  public static native void stopTask(int paramInt);
  
  private static void trafficData(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.stn.StnLogic
 * JD-Core Version:    0.7.0.1
 */