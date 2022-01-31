package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.ParcelFileDescriptor;

final class ImageManager$zzb
  implements Runnable
{
  private final Uri mUri;
  private final ParcelFileDescriptor zzaEr;
  
  public ImageManager$zzb(ImageManager paramImageManager, Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.mUri = paramUri;
    this.zzaEr = paramParcelFileDescriptor;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 36
    //   2: invokestatic 42	com/google/android/gms/common/internal/zzc:zzdk	(Ljava/lang/String;)V
    //   5: iconst_0
    //   6: istore_1
    //   7: iconst_0
    //   8: istore_2
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 26	com/google/android/gms/common/images/ImageManager$zzb:zzaEr	Landroid/os/ParcelFileDescriptor;
    //   18: ifnull +23 -> 41
    //   21: aload_0
    //   22: getfield 26	com/google/android/gms/common/images/ImageManager$zzb:zzaEr	Landroid/os/ParcelFileDescriptor;
    //   25: invokevirtual 48	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   28: invokestatic 54	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;)Landroid/graphics/Bitmap;
    //   31: astore_3
    //   32: iload_2
    //   33: istore_1
    //   34: aload_0
    //   35: getfield 26	com/google/android/gms/common/images/ImageManager$zzb:zzaEr	Landroid/os/ParcelFileDescriptor;
    //   38: invokevirtual 57	android/os/ParcelFileDescriptor:close	()V
    //   41: new 59	java/util/concurrent/CountDownLatch
    //   44: dup
    //   45: iconst_1
    //   46: invokespecial 62	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   49: astore 4
    //   51: aload_0
    //   52: getfield 19	com/google/android/gms/common/images/ImageManager$zzb:zzaEq	Lcom/google/android/gms/common/images/ImageManager;
    //   55: invokestatic 66	com/google/android/gms/common/images/ImageManager:zzg	(Lcom/google/android/gms/common/images/ImageManager;)Landroid/os/Handler;
    //   58: new 68	com/google/android/gms/common/images/ImageManager$zze
    //   61: dup
    //   62: aload_0
    //   63: getfield 19	com/google/android/gms/common/images/ImageManager$zzb:zzaEq	Lcom/google/android/gms/common/images/ImageManager;
    //   66: aload_0
    //   67: getfield 24	com/google/android/gms/common/images/ImageManager$zzb:mUri	Landroid/net/Uri;
    //   70: aload_3
    //   71: iload_1
    //   72: aload 4
    //   74: invokespecial 71	com/google/android/gms/common/images/ImageManager$zze:<init>	(Lcom/google/android/gms/common/images/ImageManager;Landroid/net/Uri;Landroid/graphics/Bitmap;ZLjava/util/concurrent/CountDownLatch;)V
    //   77: invokevirtual 77	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   80: pop
    //   81: aload 4
    //   83: invokevirtual 80	java/util/concurrent/CountDownLatch:await	()V
    //   86: return
    //   87: astore_3
    //   88: aload_0
    //   89: getfield 24	com/google/android/gms/common/images/ImageManager$zzb:mUri	Landroid/net/Uri;
    //   92: invokestatic 86	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   95: astore_3
    //   96: new 88	java/lang/StringBuilder
    //   99: dup
    //   100: aload_3
    //   101: invokestatic 86	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   104: invokevirtual 92	java/lang/String:length	()I
    //   107: bipush 34
    //   109: iadd
    //   110: invokespecial 93	java/lang/StringBuilder:<init>	(I)V
    //   113: ldc 95
    //   115: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_3
    //   119: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: iconst_1
    //   124: istore_1
    //   125: aload 4
    //   127: astore_3
    //   128: goto -94 -> 34
    //   131: astore_3
    //   132: aload_0
    //   133: getfield 24	com/google/android/gms/common/images/ImageManager$zzb:mUri	Landroid/net/Uri;
    //   136: invokestatic 86	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   139: astore_3
    //   140: new 88	java/lang/StringBuilder
    //   143: dup
    //   144: aload_3
    //   145: invokestatic 86	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   148: invokevirtual 92	java/lang/String:length	()I
    //   151: bipush 32
    //   153: iadd
    //   154: invokespecial 93	java/lang/StringBuilder:<init>	(I)V
    //   157: ldc 101
    //   159: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_3
    //   163: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: return
    //   168: astore 4
    //   170: goto -129 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	zzb
    //   6	119	1	bool1	boolean
    //   8	25	2	bool2	boolean
    //   10	61	3	localBitmap	android.graphics.Bitmap
    //   87	1	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   95	33	3	localObject	Object
    //   131	1	3	localInterruptedException	java.lang.InterruptedException
    //   139	24	3	str	java.lang.String
    //   12	114	4	localCountDownLatch	java.util.concurrent.CountDownLatch
    //   168	1	4	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   21	32	87	java/lang/OutOfMemoryError
    //   81	86	131	java/lang/InterruptedException
    //   34	41	168	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.zzb
 * JD-Core Version:    0.7.0.1
 */