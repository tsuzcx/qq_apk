package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import com.google.android.exoplayer2.h.f;
import javax.crypto.CipherInputStream;

final class a
  implements f
{
  private final f aJk;
  private final byte[] aJl;
  private CipherInputStream aJm;
  private final byte[] azp;
  
  public a(f paramf, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.aJk = paramf;
    this.azp = paramArrayOfByte1;
    this.aJl = paramArrayOfByte2;
  }
  
  /* Error */
  public final long a(com.google.android.exoplayer2.h.i parami)
  {
    // Byte code:
    //   0: ldc 37
    //   2: invokestatic 43	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   5: astore_2
    //   6: new 45	javax/crypto/spec/SecretKeySpec
    //   9: dup
    //   10: aload_0
    //   11: getfield 22	com/google/android/exoplayer2/source/b/a:azp	[B
    //   14: ldc 47
    //   16: invokespecial 50	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   19: astore_3
    //   20: new 52	javax/crypto/spec/IvParameterSpec
    //   23: dup
    //   24: aload_0
    //   25: getfield 24	com/google/android/exoplayer2/source/b/a:aJl	[B
    //   28: invokespecial 55	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   31: astore 4
    //   33: aload_2
    //   34: iconst_2
    //   35: aload_3
    //   36: aload 4
    //   38: invokevirtual 59	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   41: aload_0
    //   42: new 61	javax/crypto/CipherInputStream
    //   45: dup
    //   46: new 63	com/google/android/exoplayer2/h/h
    //   49: dup
    //   50: aload_0
    //   51: getfield 20	com/google/android/exoplayer2/source/b/a:aJk	Lcom/google/android/exoplayer2/h/f;
    //   54: aload_1
    //   55: invokespecial 66	com/google/android/exoplayer2/h/h:<init>	(Lcom/google/android/exoplayer2/h/f;Lcom/google/android/exoplayer2/h/i;)V
    //   58: aload_2
    //   59: invokespecial 69	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   62: putfield 71	com/google/android/exoplayer2/source/b/a:aJm	Ljavax/crypto/CipherInputStream;
    //   65: ldc2_w 72
    //   68: lreturn
    //   69: astore_1
    //   70: new 75	java/lang/RuntimeException
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 78	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   78: athrow
    //   79: astore_1
    //   80: new 75	java/lang/RuntimeException
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 78	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   88: athrow
    //   89: astore_1
    //   90: goto -10 -> 80
    //   93: astore_1
    //   94: goto -24 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	a
    //   0	97	1	parami	com.google.android.exoplayer2.h.i
    //   5	54	2	localCipher	javax.crypto.Cipher
    //   19	17	3	localSecretKeySpec	javax.crypto.spec.SecretKeySpec
    //   31	6	4	localIvParameterSpec	javax.crypto.spec.IvParameterSpec
    // Exception table:
    //   from	to	target	type
    //   0	6	69	java/security/NoSuchAlgorithmException
    //   33	41	79	java/security/InvalidKeyException
    //   33	41	89	java/security/InvalidAlgorithmParameterException
    //   0	6	93	javax/crypto/NoSuchPaddingException
  }
  
  public final void close()
  {
    this.aJm = null;
    this.aJk.close();
  }
  
  public final Uri getUri()
  {
    return this.aJk.getUri();
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.aJm != null) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.aC(bool);
      paramInt2 = this.aJm.read(paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = -1;
      }
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a
 * JD-Core Version:    0.7.0.1
 */