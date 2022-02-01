package com.tencent.mm.compatible.i;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;

public final class c
{
  public final MediaExtractor lZm;
  
  public c()
  {
    AppMethodBeat.i(155923);
    this.lZm = new MediaExtractor();
    AppMethodBeat.o(155923);
  }
  
  public final MediaFormat getTrackFormat(int paramInt)
  {
    AppMethodBeat.i(155930);
    MediaFormat localMediaFormat = this.lZm.getTrackFormat(paramInt);
    AppMethodBeat.o(155930);
    return localMediaFormat;
  }
  
  public final int readSampleData(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(240853);
    paramInt = this.lZm.readSampleData(paramByteBuffer, paramInt);
    AppMethodBeat.o(240853);
    return paramInt;
  }
  
  public final void seekTo(long paramLong, int paramInt)
  {
    AppMethodBeat.i(155933);
    this.lZm.seekTo(paramLong, paramInt);
    AppMethodBeat.o(155933);
  }
  
  public final void selectTrack(int paramInt)
  {
    AppMethodBeat.i(155931);
    this.lZm.selectTrack(paramInt);
    AppMethodBeat.o(155931);
  }
  
  public final void setDataSource(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(155926);
    this.lZm.setDataSource(paramFileDescriptor);
    AppMethodBeat.o(155926);
  }
  
  public final void setDataSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(155927);
    this.lZm.setDataSource(paramFileDescriptor, paramLong1, paramLong2);
    AppMethodBeat.o(155927);
  }
  
  /* Error */
  public final void setDataSource(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 58
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: iconst_0
    //   7: invokestatic 64	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   10: ifnull +52 -> 62
    //   13: aload_0
    //   14: getfield 22	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   17: aload_1
    //   18: aconst_null
    //   19: invokevirtual 67	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   22: ldc 58
    //   24: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: astore_2
    //   29: ldc 69
    //   31: new 71	java/lang/StringBuilder
    //   34: dup
    //   35: ldc 73
    //   37: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_1
    //   41: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 81
    //   46: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: invokevirtual 85	java/io/IOException:getMessage	()Ljava/lang/String;
    //   53: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 94	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_1
    //   63: ldc 96
    //   65: invokestatic 100	com/tencent/mm/vfs/y:qk	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   68: astore_3
    //   69: aload_0
    //   70: getfield 22	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   73: aload_3
    //   74: invokevirtual 106	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   77: invokevirtual 50	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 109	android/os/ParcelFileDescriptor:close	()V
    //   88: ldc 58
    //   90: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: astore_2
    //   95: aload_3
    //   96: ifnull +7 -> 103
    //   99: aload_3
    //   100: invokevirtual 109	android/os/ParcelFileDescriptor:close	()V
    //   103: ldc 58
    //   105: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_2
    //   109: athrow
    //   110: astore_2
    //   111: ldc 69
    //   113: new 71	java/lang/StringBuilder
    //   116: dup
    //   117: ldc 111
    //   119: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload_1
    //   123: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 81
    //   128: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_2
    //   132: invokevirtual 85	java/io/IOException:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 94	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 22	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   148: aload_1
    //   149: aconst_null
    //   150: invokevirtual 67	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   153: ldc 58
    //   155: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: return
    //   159: astore_3
    //   160: aload_2
    //   161: aload_3
    //   162: invokevirtual 117	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   165: goto -62 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	c
    //   0	168	1	paramString	java.lang.String
    //   28	22	2	localIOException1	java.io.IOException
    //   94	15	2	localObject	Object
    //   110	51	2	localIOException2	java.io.IOException
    //   68	32	3	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   159	3	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   13	22	28	java/io/IOException
    //   69	80	94	finally
    //   62	69	110	java/io/IOException
    //   84	88	110	java/io/IOException
    //   103	110	110	java/io/IOException
    //   160	165	110	java/io/IOException
    //   99	103	159	finally
  }
  
  public final void unselectTrack(int paramInt)
  {
    AppMethodBeat.i(155932);
    this.lZm.unselectTrack(paramInt);
    AppMethodBeat.o(155932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.i.c
 * JD-Core Version:    0.7.0.1
 */