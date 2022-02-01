package com.tencent.mm.compatible.i;

import android.annotation.TargetApi;
import android.media.MediaRecorder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.io.FileDescriptor;

@TargetApi(16)
public final class e
  extends MediaRecorder
{
  private FileDescriptor jvV;
  private q mFile;
  
  /* Error */
  public final void prepare()
  {
    // Byte code:
    //   0: ldc 20
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 28	com/tencent/mm/compatible/i/e:jvV	Ljava/io/FileDescriptor;
    //   9: ifnull +21 -> 30
    //   12: aload_0
    //   13: aload_0
    //   14: getfield 28	com/tencent/mm/compatible/i/e:jvV	Ljava/io/FileDescriptor;
    //   17: invokespecial 32	android/media/MediaRecorder:setOutputFile	(Ljava/io/FileDescriptor;)V
    //   20: aload_0
    //   21: invokespecial 34	android/media/MediaRecorder:prepare	()V
    //   24: ldc 20
    //   26: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: aload_0
    //   31: getfield 39	com/tencent/mm/compatible/i/e:mFile	Lcom/tencent/mm/vfs/q;
    //   34: ifnull +91 -> 125
    //   37: aload_0
    //   38: getfield 39	com/tencent/mm/compatible/i/e:mFile	Lcom/tencent/mm/vfs/q;
    //   41: ldc 41
    //   43: invokestatic 47	com/tencent/mm/vfs/u:h	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   46: astore_3
    //   47: aconst_null
    //   48: astore_2
    //   49: aload_0
    //   50: aload_3
    //   51: invokevirtual 53	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   54: invokespecial 32	android/media/MediaRecorder:setOutputFile	(Ljava/io/FileDescriptor;)V
    //   57: aload_0
    //   58: invokespecial 34	android/media/MediaRecorder:prepare	()V
    //   61: aload_3
    //   62: ifnull +57 -> 119
    //   65: aload_3
    //   66: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
    //   69: ldc 20
    //   71: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: return
    //   75: astore_2
    //   76: ldc 20
    //   78: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_2
    //   82: athrow
    //   83: astore_1
    //   84: aload_3
    //   85: ifnull +11 -> 96
    //   88: aload_2
    //   89: ifnull +23 -> 112
    //   92: aload_3
    //   93: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
    //   96: ldc 20
    //   98: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_1
    //   102: athrow
    //   103: astore_3
    //   104: aload_2
    //   105: aload_3
    //   106: invokevirtual 60	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   109: goto -13 -> 96
    //   112: aload_3
    //   113: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
    //   116: goto -20 -> 96
    //   119: ldc 20
    //   121: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: return
    //   125: new 62	java/io/IOException
    //   128: dup
    //   129: ldc 64
    //   131: invokespecial 67	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   134: astore_1
    //   135: ldc 20
    //   137: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_1
    //   141: athrow
    //   142: astore_1
    //   143: goto -59 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	e
    //   83	19	1	localObject1	java.lang.Object
    //   134	7	1	localIOException	java.io.IOException
    //   142	1	1	localObject2	java.lang.Object
    //   48	1	2	localObject3	java.lang.Object
    //   75	30	2	localThrowable1	java.lang.Throwable
    //   46	47	3	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   103	10	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   49	61	75	java/lang/Throwable
    //   76	83	83	finally
    //   92	96	103	java/lang/Throwable
    //   49	61	142	finally
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
    this.jvV = paramFileDescriptor;
  }
  
  public final void setOutputFile(String paramString)
  {
    AppMethodBeat.i(155941);
    if (paramString == null) {}
    for (paramString = null;; paramString = new q(paramString))
    {
      this.mFile = paramString;
      this.jvV = null;
      AppMethodBeat.o(155941);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.i.e
 * JD-Core Version:    0.7.0.1
 */