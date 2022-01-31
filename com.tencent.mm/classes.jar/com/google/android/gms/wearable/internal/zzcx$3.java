package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.internal.zzaad.zzb;

class zzcx$3
  implements Runnable
{
  zzcx$3(zzcx paramzzcx, Uri paramUri, zzaad.zzb paramzzb, String paramString, long paramLong1, long paramLong2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 49
    //   2: iconst_2
    //   3: invokestatic 55	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   6: pop
    //   7: ldc 57
    //   9: aload_0
    //   10: getfield 28	com/google/android/gms/wearable/internal/zzcx$3:zzbBz	Landroid/net/Uri;
    //   13: invokevirtual 63	android/net/Uri:getScheme	()Ljava/lang/String;
    //   16: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifne +24 -> 43
    //   22: aload_0
    //   23: getfield 30	com/google/android/gms/wearable/internal/zzcx$3:zzbVh	Lcom/google/android/gms/internal/zzaad$zzb;
    //   26: new 71	com/google/android/gms/common/api/Status
    //   29: dup
    //   30: bipush 10
    //   32: ldc 73
    //   34: invokespecial 76	com/google/android/gms/common/api/Status:<init>	(ILjava/lang/String;)V
    //   37: invokeinterface 82 2 0
    //   42: return
    //   43: new 84	java/io/File
    //   46: dup
    //   47: aload_0
    //   48: getfield 28	com/google/android/gms/wearable/internal/zzcx$3:zzbBz	Landroid/net/Uri;
    //   51: invokevirtual 87	android/net/Uri:getPath	()Ljava/lang/String;
    //   54: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_2
    //   58: aload_2
    //   59: ldc 91
    //   61: invokestatic 97	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 26	com/google/android/gms/wearable/internal/zzcx$3:zzbVi	Lcom/google/android/gms/wearable/internal/zzcx;
    //   69: invokevirtual 101	com/google/android/gms/wearable/internal/zzcx:zzxD	()Landroid/os/IInterface;
    //   72: checkcast 103	com/google/android/gms/wearable/internal/zzbw
    //   75: new 105	com/google/android/gms/wearable/internal/zzcw$zzr
    //   78: dup
    //   79: aload_0
    //   80: getfield 30	com/google/android/gms/wearable/internal/zzcx$3:zzbVh	Lcom/google/android/gms/internal/zzaad$zzb;
    //   83: invokespecial 108	com/google/android/gms/wearable/internal/zzcw$zzr:<init>	(Lcom/google/android/gms/internal/zzaad$zzb;)V
    //   86: aload_0
    //   87: getfield 32	com/google/android/gms/wearable/internal/zzcx$3:zzaiD	Ljava/lang/String;
    //   90: aload_1
    //   91: aload_0
    //   92: getfield 34	com/google/android/gms/wearable/internal/zzcx$3:zzbUd	J
    //   95: aload_0
    //   96: getfield 36	com/google/android/gms/wearable/internal/zzcx$3:zzbUe	J
    //   99: invokeinterface 112 8 0
    //   104: aload_1
    //   105: invokevirtual 115	android/os/ParcelFileDescriptor:close	()V
    //   108: return
    //   109: astore_1
    //   110: return
    //   111: astore_1
    //   112: aload_2
    //   113: invokestatic 119	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: astore_1
    //   117: new 121	java/lang/StringBuilder
    //   120: dup
    //   121: aload_1
    //   122: invokestatic 119	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokevirtual 125	java/lang/String:length	()I
    //   128: bipush 46
    //   130: iadd
    //   131: invokespecial 128	java/lang/StringBuilder:<init>	(I)V
    //   134: ldc 130
    //   136: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_1
    //   140: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_0
    //   145: getfield 30	com/google/android/gms/wearable/internal/zzcx$3:zzbVh	Lcom/google/android/gms/internal/zzaad$zzb;
    //   148: new 71	com/google/android/gms/common/api/Status
    //   151: dup
    //   152: bipush 13
    //   154: invokespecial 135	com/google/android/gms/common/api/Status:<init>	(I)V
    //   157: invokeinterface 82 2 0
    //   162: return
    //   163: astore_2
    //   164: aload_0
    //   165: getfield 30	com/google/android/gms/wearable/internal/zzcx$3:zzbVh	Lcom/google/android/gms/internal/zzaad$zzb;
    //   168: new 71	com/google/android/gms/common/api/Status
    //   171: dup
    //   172: bipush 8
    //   174: invokespecial 135	com/google/android/gms/common/api/Status:<init>	(I)V
    //   177: invokeinterface 82 2 0
    //   182: aload_1
    //   183: invokevirtual 115	android/os/ParcelFileDescriptor:close	()V
    //   186: return
    //   187: astore_1
    //   188: return
    //   189: astore_2
    //   190: aload_1
    //   191: invokevirtual 115	android/os/ParcelFileDescriptor:close	()V
    //   194: aload_2
    //   195: athrow
    //   196: astore_1
    //   197: goto -3 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	3
    //   64	41	1	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   109	1	1	localIOException1	java.io.IOException
    //   111	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   116	67	1	str	String
    //   187	4	1	localIOException2	java.io.IOException
    //   196	1	1	localIOException3	java.io.IOException
    //   57	56	2	localFile	java.io.File
    //   163	1	2	localRemoteException	android.os.RemoteException
    //   189	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   104	108	109	java/io/IOException
    //   58	65	111	java/io/FileNotFoundException
    //   65	104	163	android/os/RemoteException
    //   182	186	187	java/io/IOException
    //   65	104	189	finally
    //   164	182	189	finally
    //   190	194	196	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcx.3
 * JD-Core Version:    0.7.0.1
 */