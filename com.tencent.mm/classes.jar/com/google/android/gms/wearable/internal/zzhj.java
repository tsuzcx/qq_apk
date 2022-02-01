package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzhj
  implements Runnable
{
  zzhj(zzhg paramzzhg, Uri paramUri, BaseImplementation.ResultHolder paramResultHolder, String paramString, long paramLong1, long paramLong2) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 51
    //   7: iconst_2
    //   8: invokestatic 57	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   11: pop
    //   12: ldc 59
    //   14: aload_0
    //   15: getfield 23	com/google/android/gms/wearable/internal/zzhj:zzco	Landroid/net/Uri;
    //   18: invokevirtual 65	android/net/Uri:getScheme	()Ljava/lang/String;
    //   21: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifne +29 -> 53
    //   27: aload_0
    //   28: getfield 25	com/google/android/gms/wearable/internal/zzhj:zzfh	Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;
    //   31: new 73	com/google/android/gms/common/api/Status
    //   34: dup
    //   35: bipush 10
    //   37: ldc 75
    //   39: invokespecial 78	com/google/android/gms/common/api/Status:<init>	(ILjava/lang/String;)V
    //   42: invokeinterface 84 2 0
    //   47: ldc 43
    //   49: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: new 89	java/io/File
    //   56: dup
    //   57: aload_0
    //   58: getfield 23	com/google/android/gms/wearable/internal/zzhj:zzco	Landroid/net/Uri;
    //   61: invokevirtual 92	android/net/Uri:getPath	()Ljava/lang/String;
    //   64: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore_2
    //   68: aload_2
    //   69: ldc 96
    //   71: invokestatic 102	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   74: astore_1
    //   75: aload_0
    //   76: getfield 21	com/google/android/gms/wearable/internal/zzhj:zzfi	Lcom/google/android/gms/wearable/internal/zzhg;
    //   79: invokevirtual 108	com/google/android/gms/wearable/internal/zzhg:getService	()Landroid/os/IInterface;
    //   82: checkcast 110	com/google/android/gms/wearable/internal/zzep
    //   85: new 112	com/google/android/gms/wearable/internal/zzhc
    //   88: dup
    //   89: aload_0
    //   90: getfield 25	com/google/android/gms/wearable/internal/zzhj:zzfh	Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;
    //   93: invokespecial 115	com/google/android/gms/wearable/internal/zzhc:<init>	(Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;)V
    //   96: aload_0
    //   97: getfield 27	com/google/android/gms/wearable/internal/zzhj:zzcs	Ljava/lang/String;
    //   100: aload_1
    //   101: aload_0
    //   102: getfield 29	com/google/android/gms/wearable/internal/zzhj:zzcq	J
    //   105: aload_0
    //   106: getfield 31	com/google/android/gms/wearable/internal/zzhj:zzcr	J
    //   109: invokeinterface 119 8 0
    //   114: aload_1
    //   115: invokevirtual 122	android/os/ParcelFileDescriptor:close	()V
    //   118: ldc 43
    //   120: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: return
    //   124: astore_1
    //   125: aload_2
    //   126: invokestatic 126	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: astore_1
    //   130: new 128	java/lang/StringBuilder
    //   133: dup
    //   134: aload_1
    //   135: invokestatic 126	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   138: invokevirtual 132	java/lang/String:length	()I
    //   141: bipush 46
    //   143: iadd
    //   144: invokespecial 134	java/lang/StringBuilder:<init>	(I)V
    //   147: ldc 136
    //   149: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_0
    //   158: getfield 25	com/google/android/gms/wearable/internal/zzhj:zzfh	Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;
    //   161: new 73	com/google/android/gms/common/api/Status
    //   164: dup
    //   165: bipush 13
    //   167: invokespecial 141	com/google/android/gms/common/api/Status:<init>	(I)V
    //   170: invokeinterface 84 2 0
    //   175: ldc 43
    //   177: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: return
    //   181: astore_1
    //   182: ldc 43
    //   184: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: return
    //   188: astore_2
    //   189: aload_0
    //   190: getfield 25	com/google/android/gms/wearable/internal/zzhj:zzfh	Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;
    //   193: new 73	com/google/android/gms/common/api/Status
    //   196: dup
    //   197: bipush 8
    //   199: invokespecial 141	com/google/android/gms/common/api/Status:<init>	(I)V
    //   202: invokeinterface 84 2 0
    //   207: aload_1
    //   208: invokevirtual 122	android/os/ParcelFileDescriptor:close	()V
    //   211: ldc 43
    //   213: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: return
    //   217: astore_1
    //   218: ldc 43
    //   220: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: return
    //   224: astore_2
    //   225: aload_1
    //   226: invokevirtual 122	android/os/ParcelFileDescriptor:close	()V
    //   229: ldc 43
    //   231: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_2
    //   235: athrow
    //   236: astore_1
    //   237: goto -8 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	zzhj
    //   74	41	1	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   124	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   129	24	1	str	String
    //   181	27	1	localIOException1	java.io.IOException
    //   217	9	1	localIOException2	java.io.IOException
    //   236	1	1	localIOException3	java.io.IOException
    //   67	59	2	localFile	java.io.File
    //   188	1	2	localRemoteException	android.os.RemoteException
    //   224	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   68	75	124	java/io/FileNotFoundException
    //   114	118	181	java/io/IOException
    //   75	114	188	android/os/RemoteException
    //   207	211	217	java/io/IOException
    //   75	114	224	finally
    //   189	207	224	finally
    //   225	229	236	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhj
 * JD-Core Version:    0.7.0.1
 */