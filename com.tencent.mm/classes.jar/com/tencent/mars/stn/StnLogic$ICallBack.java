package com.tencent.mars.stn;

import java.io.ByteArrayOutputStream;

public abstract interface StnLogic$ICallBack
{
  public static final int BaseNetDetectEnd = 2;
  public static final int DetectConnectFail = 1;
  public static final int DetectConnectOK = 0;
  public static final int DetectEnd = 4;
  public static final int DetectLongLinkEnd = 0;
  public static final int DetectNotStart = 3;
  public static final int DetectShortLinkEnd = 1;
  public static final int DetectTimeout = 2;
  
  public abstract int buf2Resp(int paramInt1, Object paramObject, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2);
  
  public abstract int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2, int[] paramArrayOfInt);
  
  public abstract boolean isLogoned();
  
  public abstract boolean makesureAuthed(String paramString);
  
  public abstract void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, String paramString);
  
  public abstract boolean onLongLinkIdentifyResp(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract String[] onNewDns(String paramString);
  
  public abstract void onPush(int paramInt, byte[] paramArrayOfByte);
  
  public abstract int onTaskEnd(int paramInt1, Object paramObject, int paramInt2, int paramInt3);
  
  public abstract void reportConnectInfo(int paramInt1, int paramInt2);
  
  public abstract boolean req2Buf(int paramInt1, Object paramObject, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2, String paramString);
  
  public abstract void requestDoSync();
  
  public abstract String[] requestNetCheckShortLinkHosts();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mars.stn.StnLogic.ICallBack
 * JD-Core Version:    0.7.0.1
 */