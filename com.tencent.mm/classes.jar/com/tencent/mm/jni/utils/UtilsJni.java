package com.tencent.mm.jni.utils;

public class UtilsJni
{
  public static native long CreateHybridEcdhCryptoEngine(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
  
  public static native byte[] Ecdh(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native byte[] EcdsaSign(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native int EcdsaVerify(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
  
  public static native byte[][] GenEcdhKeyPair();
  
  public static native byte[][] GenEcdsaKeyPair();
  
  public static native byte[] HKDF(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, int paramInt);
  
  public static native byte[] HybridEcdhDecrypt(long paramLong, byte[] paramArrayOfByte);
  
  public static native byte[] HybridEcdhEncrypt(long paramLong, byte[] paramArrayOfByte);
  
  public static native void ReleaseHybridEcdhCryptoEngine(long paramLong);
  
  public static native void ResetHybridEcdhCryptoEngine(long paramLong);
  
  public static native byte[] cryptGenRandom(int paramInt);
  
  public static native int doEcdsaSHAVerify(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
  
  public static native int doEcdsaVerify(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.jni.utils.UtilsJni
 * JD-Core Version:    0.7.0.1
 */