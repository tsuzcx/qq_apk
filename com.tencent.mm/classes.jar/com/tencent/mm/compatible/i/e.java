package com.tencent.mm.compatible.i;

import android.annotation.TargetApi;
import android.media.MediaRecorder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import java.io.File;
import java.io.FileDescriptor;

@TargetApi(16)
public final class e
  extends MediaRecorder
{
  private FileDescriptor gLG;
  private o mFile;
  
  /* Error */
  public final void prepare()
  {
    // Byte code:
    //   0: ldc 20
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 28	com/tencent/mm/compatible/i/e:gLG	Ljava/io/FileDescriptor;
    //   9: ifnull +21 -> 30
    //   12: aload_0
    //   13: aload_0
    //   14: getfield 28	com/tencent/mm/compatible/i/e:gLG	Ljava/io/FileDescriptor;
    //   17: invokespecial 32	android/media/MediaRecorder:setOutputFile	(Ljava/io/FileDescriptor;)V
    //   20: aload_0
    //   21: invokespecial 34	android/media/MediaRecorder:prepare	()V
    //   24: ldc 20
    //   26: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: aload_0
    //   31: getfield 39	com/tencent/mm/compatible/i/e:mFile	Lcom/tencent/mm/vfs/o;
    //   34: ifnull +100 -> 134
    //   37: aload_0
    //   38: getfield 39	com/tencent/mm/compatible/i/e:mFile	Lcom/tencent/mm/vfs/o;
    //   41: astore_1
    //   42: aload_1
    //   43: getfield 45	com/tencent/mm/vfs/o:mUri	Landroid/net/Uri;
    //   46: aload_1
    //   47: invokevirtual 49	com/tencent/mm/vfs/o:heo	()Lcom/tencent/mm/vfs/g$e;
    //   50: ldc 51
    //   52: invokestatic 57	com/tencent/mm/vfs/s:a	(Landroid/net/Uri;Lcom/tencent/mm/vfs/g$e;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_2
    //   58: aload_0
    //   59: aload_3
    //   60: invokevirtual 63	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   63: invokespecial 32	android/media/MediaRecorder:setOutputFile	(Ljava/io/FileDescriptor;)V
    //   66: aload_0
    //   67: invokespecial 34	android/media/MediaRecorder:prepare	()V
    //   70: aload_3
    //   71: ifnull +57 -> 128
    //   74: aload_3
    //   75: invokevirtual 66	android/os/ParcelFileDescriptor:close	()V
    //   78: ldc 20
    //   80: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_2
    //   85: ldc 20
    //   87: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_2
    //   91: athrow
    //   92: astore_1
    //   93: aload_3
    //   94: ifnull +11 -> 105
    //   97: aload_2
    //   98: ifnull +23 -> 121
    //   101: aload_3
    //   102: invokevirtual 66	android/os/ParcelFileDescriptor:close	()V
    //   105: ldc 20
    //   107: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_1
    //   111: athrow
    //   112: astore_3
    //   113: aload_2
    //   114: aload_3
    //   115: invokevirtual 70	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   118: goto -13 -> 105
    //   121: aload_3
    //   122: invokevirtual 66	android/os/ParcelFileDescriptor:close	()V
    //   125: goto -20 -> 105
    //   128: ldc 20
    //   130: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: return
    //   134: new 72	java/io/IOException
    //   137: dup
    //   138: ldc 74
    //   140: invokespecial 77	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   143: astore_1
    //   144: ldc 20
    //   146: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: athrow
    //   151: astore_1
    //   152: goto -59 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	e
    //   41	6	1	localo	o
    //   92	19	1	localObject1	java.lang.Object
    //   143	7	1	localIOException	java.io.IOException
    //   151	1	1	localObject2	java.lang.Object
    //   57	1	2	localObject3	java.lang.Object
    //   84	30	2	localThrowable1	java.lang.Throwable
    //   55	47	3	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   112	10	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   58	70	84	java/lang/Throwable
    //   85	92	92	finally
    //   101	105	112	java/lang/Throwable
    //   58	70	151	finally
  }
  
  @Deprecated
  public final void setOutputFile(File paramFile)
  {
    AppMethodBeat.i(155942);
    setOutputFile(paramFile.getPath());
    AppMethodBeat.o(155942);
  }
  
  public final void setOutputFile(FileDescriptor paramFileDescriptor)
  {
    this.mFile = null;
    this.gLG = paramFileDescriptor;
  }
  
  public final void setOutputFile(String paramString)
  {
    AppMethodBeat.i(155941);
    if (paramString == null) {}
    for (paramString = null;; paramString = new o(paramString))
    {
      this.mFile = paramString;
      this.gLG = null;
      AppMethodBeat.o(155941);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.i.e
 * JD-Core Version:    0.7.0.1
 */