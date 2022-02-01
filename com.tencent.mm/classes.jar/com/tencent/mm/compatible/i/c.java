package com.tencent.mm.compatible.i;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class c
{
  public final MediaExtractor gLF;
  
  public c()
  {
    AppMethodBeat.i(155923);
    this.gLF = new MediaExtractor();
    AppMethodBeat.o(155923);
  }
  
  public final boolean advance()
  {
    AppMethodBeat.i(186058);
    boolean bool = this.gLF.advance();
    AppMethodBeat.o(186058);
    return bool;
  }
  
  public final int getSampleFlags()
  {
    AppMethodBeat.i(204401);
    int i = this.gLF.getSampleFlags();
    AppMethodBeat.o(204401);
    return i;
  }
  
  public final long getSampleTime()
  {
    AppMethodBeat.i(186059);
    long l = this.gLF.getSampleTime();
    AppMethodBeat.o(186059);
    return l;
  }
  
  public final int getSampleTrackIndex()
  {
    AppMethodBeat.i(155936);
    int i = this.gLF.getSampleTrackIndex();
    AppMethodBeat.o(155936);
    return i;
  }
  
  public final int getTrackCount()
  {
    AppMethodBeat.i(186057);
    int i = this.gLF.getTrackCount();
    AppMethodBeat.o(186057);
    return i;
  }
  
  public final MediaFormat getTrackFormat(int paramInt)
  {
    AppMethodBeat.i(155930);
    MediaFormat localMediaFormat = this.gLF.getTrackFormat(paramInt);
    AppMethodBeat.o(155930);
    return localMediaFormat;
  }
  
  public final int readSampleData(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(204400);
    paramInt = this.gLF.readSampleData(paramByteBuffer, paramInt);
    AppMethodBeat.o(204400);
    return paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(186056);
    this.gLF.release();
    AppMethodBeat.o(186056);
  }
  
  public final void seekTo(long paramLong, int paramInt)
  {
    AppMethodBeat.i(155933);
    this.gLF.seekTo(paramLong, paramInt);
    AppMethodBeat.o(155933);
  }
  
  public final void selectTrack(int paramInt)
  {
    AppMethodBeat.i(155931);
    this.gLF.selectTrack(paramInt);
    AppMethodBeat.o(155931);
  }
  
  public final void setDataSource(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(155926);
    this.gLF.setDataSource(paramFileDescriptor);
    AppMethodBeat.o(155926);
  }
  
  public final void setDataSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(155927);
    this.gLF.setDataSource(paramFileDescriptor, paramLong1, paramLong2);
    AppMethodBeat.o(155927);
  }
  
  /* Error */
  public final void setDataSource(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 90
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: iconst_0
    //   7: invokestatic 96	com/tencent/mm/vfs/s:k	(Ljava/lang/String;Z)Ljava/lang/String;
    //   10: ifnull +52 -> 62
    //   13: aload_0
    //   14: getfield 25	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   17: aload_1
    //   18: aconst_null
    //   19: invokevirtual 99	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   22: ldc 90
    //   24: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: astore_2
    //   29: ldc 101
    //   31: new 103	java/lang/StringBuilder
    //   34: dup
    //   35: ldc 105
    //   37: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_1
    //   41: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 113
    //   46: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: invokevirtual 117	java/io/IOException:getMessage	()Ljava/lang/String;
    //   53: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 126	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_1
    //   63: ldc 128
    //   65: invokestatic 132	com/tencent/mm/vfs/s:nv	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   68: astore 4
    //   70: aload_0
    //   71: getfield 25	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   74: aload 4
    //   76: invokevirtual 138	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   79: invokevirtual 80	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   82: aload 4
    //   84: ifnull +8 -> 92
    //   87: aload 4
    //   89: invokevirtual 141	android/os/ParcelFileDescriptor:close	()V
    //   92: ldc 90
    //   94: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_3
    //   99: ldc 90
    //   101: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_3
    //   105: athrow
    //   106: astore_2
    //   107: aload 4
    //   109: ifnull +12 -> 121
    //   112: aload_3
    //   113: ifnull +75 -> 188
    //   116: aload 4
    //   118: invokevirtual 141	android/os/ParcelFileDescriptor:close	()V
    //   121: ldc 90
    //   123: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_2
    //   127: athrow
    //   128: astore_2
    //   129: ldc 101
    //   131: new 103	java/lang/StringBuilder
    //   134: dup
    //   135: ldc 143
    //   137: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload_1
    //   141: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 113
    //   146: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_2
    //   150: invokevirtual 117	java/io/IOException:getMessage	()Ljava/lang/String;
    //   153: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 126	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_0
    //   163: getfield 25	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   166: aload_1
    //   167: aconst_null
    //   168: invokevirtual 99	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   171: ldc 90
    //   173: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: return
    //   177: astore 4
    //   179: aload_3
    //   180: aload 4
    //   182: invokevirtual 147	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   185: goto -64 -> 121
    //   188: aload 4
    //   190: invokevirtual 141	android/os/ParcelFileDescriptor:close	()V
    //   193: goto -72 -> 121
    //   196: astore_2
    //   197: aconst_null
    //   198: astore_3
    //   199: goto -92 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	c
    //   0	202	1	paramString	java.lang.String
    //   28	22	2	localIOException1	java.io.IOException
    //   106	21	2	localObject1	Object
    //   128	22	2	localIOException2	java.io.IOException
    //   196	1	2	localObject2	Object
    //   98	82	3	localThrowable1	java.lang.Throwable
    //   198	1	3	localObject3	Object
    //   68	49	4	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   177	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   13	22	28	java/io/IOException
    //   70	82	98	java/lang/Throwable
    //   99	106	106	finally
    //   62	70	128	java/io/IOException
    //   87	92	128	java/io/IOException
    //   116	121	128	java/io/IOException
    //   121	128	128	java/io/IOException
    //   179	185	128	java/io/IOException
    //   188	193	128	java/io/IOException
    //   116	121	177	java/lang/Throwable
    //   70	82	196	finally
  }
  
  public final void unselectTrack(int paramInt)
  {
    AppMethodBeat.i(155932);
    this.gLF.unselectTrack(paramInt);
    AppMethodBeat.o(155932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.i.c
 * JD-Core Version:    0.7.0.1
 */