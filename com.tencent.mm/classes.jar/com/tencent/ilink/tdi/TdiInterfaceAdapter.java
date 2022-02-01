package com.tencent.ilink.tdi;

public class TdiInterfaceAdapter
{
  public static native void autoLogin(long paramLong);
  
  public static native void cancel(long paramLong, int paramInt);
  
  public static native void cancelAppRequest(long paramLong, int paramInt);
  
  public static native int cancelOAuth(long paramLong, byte[] paramArrayOfByte);
  
  public static native void cancelRequest(long paramLong, int paramInt);
  
  public static native void checkLoginQrCode(long paramLong);
  
  public static native long create(String paramString);
  
  public static native void destroy(long paramLong);
  
  public static native void faceExtVerify(long paramLong, byte[] paramArrayOfByte);
  
  public static native void faceLogin(long paramLong, byte[] paramArrayOfByte);
  
  public static native void faceRecognize(long paramLong, byte[] paramArrayOfByte);
  
  public static native void faceRecognizeConfig(long paramLong, byte[] paramArrayOfByte);
  
  public static native int getAppPushToken(long paramLong, byte[] paramArrayOfByte);
  
  public static native void getLoginQrCode(long paramLong, byte[] paramArrayOfByte);
  
  public static native int getOAuthCode(long paramLong, byte[] paramArrayOfByte);
  
  public static native byte[] getUserInfo(long paramLong);
  
  public static native void init(long paramLong, byte[] paramArrayOfByte);
  
  public static native void logout(long paramLong);
  
  public static native void oauthLogin(long paramLong, byte[] paramArrayOfByte);
  
  public static native void qrCodeLogin(long paramLong, byte[] paramArrayOfByte);
  
  public static native void requestUploadLogfiles(long paramLong, int paramInt1, int paramInt2);
  
  public static native int sendAppRequest(long paramLong, byte[] paramArrayOfByte);
  
  public static native void setSmcBaseInfo(long paramLong, byte[] paramArrayOfByte);
  
  public static native void setSmcUin(long paramLong, int paramInt);
  
  public static native void thirdAppLogin(long paramLong, byte[] paramArrayOfByte);
  
  public static native void uninit(long paramLong);
  
  public static native void updateIlinkToken(long paramLong, byte[] paramArrayOfByte);
  
  public static native void visitorLogin(long paramLong, byte[] paramArrayOfByte);
  
  public static native void writeKvData(long paramLong, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ilink.tdi.TdiInterfaceAdapter
 * JD-Core Version:    0.7.0.1
 */