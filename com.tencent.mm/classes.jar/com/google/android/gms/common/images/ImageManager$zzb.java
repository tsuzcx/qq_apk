package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.ParcelFileDescriptor;

final class ImageManager$zzb
  implements Runnable
{
  private final Uri mUri;
  private final ParcelFileDescriptor zzph;
  
  public ImageManager$zzb(ImageManager paramImageManager, Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.mUri = paramUri;
    this.zzph = paramParcelFileDescriptor;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 35
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 43
    //   7: invokestatic 49	com/google/android/gms/common/internal/Asserts:checkNotMainThread	(Ljava/lang/String;)V
    //   10: iconst_0
    //   11: istore_1
    //   12: iconst_0
    //   13: istore_2
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 4
    //   19: aload_0
    //   20: getfield 26	com/google/android/gms/common/images/ImageManager$zzb:zzph	Landroid/os/ParcelFileDescriptor;
    //   23: ifnull +23 -> 46
    //   26: aload_0
    //   27: getfield 26	com/google/android/gms/common/images/ImageManager$zzb:zzph	Landroid/os/ParcelFileDescriptor;
    //   30: invokevirtual 55	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   33: invokestatic 61	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;)Landroid/graphics/Bitmap;
    //   36: astore_3
    //   37: iload_2
    //   38: istore_1
    //   39: aload_0
    //   40: getfield 26	com/google/android/gms/common/images/ImageManager$zzb:zzph	Landroid/os/ParcelFileDescriptor;
    //   43: invokevirtual 64	android/os/ParcelFileDescriptor:close	()V
    //   46: new 66	java/util/concurrent/CountDownLatch
    //   49: dup
    //   50: iconst_1
    //   51: invokespecial 68	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   54: astore 4
    //   56: aload_0
    //   57: getfield 19	com/google/android/gms/common/images/ImageManager$zzb:zzpg	Lcom/google/android/gms/common/images/ImageManager;
    //   60: invokestatic 72	com/google/android/gms/common/images/ImageManager:zzg	(Lcom/google/android/gms/common/images/ImageManager;)Landroid/os/Handler;
    //   63: new 74	com/google/android/gms/common/images/ImageManager$zze
    //   66: dup
    //   67: aload_0
    //   68: getfield 19	com/google/android/gms/common/images/ImageManager$zzb:zzpg	Lcom/google/android/gms/common/images/ImageManager;
    //   71: aload_0
    //   72: getfield 24	com/google/android/gms/common/images/ImageManager$zzb:mUri	Landroid/net/Uri;
    //   75: aload_3
    //   76: iload_1
    //   77: aload 4
    //   79: invokespecial 77	com/google/android/gms/common/images/ImageManager$zze:<init>	(Lcom/google/android/gms/common/images/ImageManager;Landroid/net/Uri;Landroid/graphics/Bitmap;ZLjava/util/concurrent/CountDownLatch;)V
    //   82: invokevirtual 83	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   85: pop
    //   86: aload 4
    //   88: invokevirtual 86	java/util/concurrent/CountDownLatch:await	()V
    //   91: ldc 35
    //   93: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: astore_3
    //   98: aload_0
    //   99: getfield 24	com/google/android/gms/common/images/ImageManager$zzb:mUri	Landroid/net/Uri;
    //   102: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   105: astore_3
    //   106: new 97	java/lang/StringBuilder
    //   109: dup
    //   110: aload_3
    //   111: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   114: invokevirtual 101	java/lang/String:length	()I
    //   117: bipush 34
    //   119: iadd
    //   120: invokespecial 102	java/lang/StringBuilder:<init>	(I)V
    //   123: ldc 104
    //   125: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_3
    //   129: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: iconst_1
    //   134: istore_1
    //   135: aload 4
    //   137: astore_3
    //   138: goto -99 -> 39
    //   141: astore_3
    //   142: aload_0
    //   143: getfield 24	com/google/android/gms/common/images/ImageManager$zzb:mUri	Landroid/net/Uri;
    //   146: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   149: astore_3
    //   150: new 97	java/lang/StringBuilder
    //   153: dup
    //   154: aload_3
    //   155: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   158: invokevirtual 101	java/lang/String:length	()I
    //   161: bipush 32
    //   163: iadd
    //   164: invokespecial 102	java/lang/StringBuilder:<init>	(I)V
    //   167: ldc 110
    //   169: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_3
    //   173: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc 35
    //   179: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: return
    //   183: astore 4
    //   185: goto -139 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	zzb
    //   11	124	1	bool1	boolean
    //   13	25	2	bool2	boolean
    //   15	61	3	localBitmap	android.graphics.Bitmap
    //   97	1	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   105	33	3	localObject	Object
    //   141	1	3	localInterruptedException	java.lang.InterruptedException
    //   149	24	3	str	java.lang.String
    //   17	119	4	localCountDownLatch	java.util.concurrent.CountDownLatch
    //   183	1	4	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   26	37	97	java/lang/OutOfMemoryError
    //   86	91	141	java/lang/InterruptedException
    //   39	46	183	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.zzb
 * JD-Core Version:    0.7.0.1
 */