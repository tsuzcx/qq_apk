package com.tencent.mm.compatible.h;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class c
{
  public final MediaExtractor fKr;
  
  public c()
  {
    AppMethodBeat.i(155923);
    this.fKr = new MediaExtractor();
    AppMethodBeat.o(155923);
  }
  
  public final boolean advance()
  {
    AppMethodBeat.i(210546);
    boolean bool = this.fKr.advance();
    AppMethodBeat.o(210546);
    return bool;
  }
  
  public final long getSampleTime()
  {
    AppMethodBeat.i(210547);
    long l = this.fKr.getSampleTime();
    AppMethodBeat.o(210547);
    return l;
  }
  
  public final int getSampleTrackIndex()
  {
    AppMethodBeat.i(155936);
    int i = this.fKr.getSampleTrackIndex();
    AppMethodBeat.o(155936);
    return i;
  }
  
  public final int getTrackCount()
  {
    AppMethodBeat.i(210545);
    int i = this.fKr.getTrackCount();
    AppMethodBeat.o(210545);
    return i;
  }
  
  public final MediaFormat getTrackFormat(int paramInt)
  {
    AppMethodBeat.i(155930);
    MediaFormat localMediaFormat = this.fKr.getTrackFormat(paramInt);
    AppMethodBeat.o(155930);
    return localMediaFormat;
  }
  
  public final int j(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(155935);
    int i = this.fKr.readSampleData(paramByteBuffer, 0);
    AppMethodBeat.o(155935);
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(210544);
    this.fKr.release();
    AppMethodBeat.o(210544);
  }
  
  /* Error */
  public final void sI(String paramString)
  {
    // Byte code:
    //   0: ldc 71
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 73
    //   8: invokestatic 79	com/tencent/mm/vfs/i:lY	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   11: astore 4
    //   13: aload_0
    //   14: getfield 25	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   17: aload 4
    //   19: invokevirtual 85	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   22: invokevirtual 89	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   25: aload 4
    //   27: ifnull +8 -> 35
    //   30: aload 4
    //   32: invokevirtual 92	android/os/ParcelFileDescriptor:close	()V
    //   35: ldc 71
    //   37: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: astore_3
    //   42: ldc 71
    //   44: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_3
    //   48: athrow
    //   49: astore_2
    //   50: aload 4
    //   52: ifnull +12 -> 64
    //   55: aload_3
    //   56: ifnull +75 -> 131
    //   59: aload 4
    //   61: invokevirtual 92	android/os/ParcelFileDescriptor:close	()V
    //   64: ldc 71
    //   66: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_2
    //   70: athrow
    //   71: astore_2
    //   72: ldc 94
    //   74: new 96	java/lang/StringBuilder
    //   77: dup
    //   78: ldc 98
    //   80: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload_1
    //   84: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc 106
    //   89: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_2
    //   93: invokevirtual 110	java/io/IOException:getMessage	()Ljava/lang/String;
    //   96: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 119	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 25	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   109: aload_1
    //   110: aconst_null
    //   111: invokevirtual 122	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   114: ldc 71
    //   116: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: astore 4
    //   122: aload_3
    //   123: aload 4
    //   125: invokevirtual 126	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   128: goto -64 -> 64
    //   131: aload 4
    //   133: invokevirtual 92	android/os/ParcelFileDescriptor:close	()V
    //   136: goto -72 -> 64
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_3
    //   142: goto -92 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	c
    //   0	145	1	paramString	String
    //   49	21	2	localObject1	Object
    //   71	22	2	localIOException	java.io.IOException
    //   139	1	2	localObject2	Object
    //   41	82	3	localThrowable1	java.lang.Throwable
    //   141	1	3	localObject3	Object
    //   11	49	4	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   120	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   13	25	41	java/lang/Throwable
    //   42	49	49	finally
    //   5	13	71	java/io/IOException
    //   30	35	71	java/io/IOException
    //   59	64	71	java/io/IOException
    //   64	71	71	java/io/IOException
    //   122	128	71	java/io/IOException
    //   131	136	71	java/io/IOException
    //   59	64	120	java/lang/Throwable
    //   13	25	139	finally
  }
  
  public final void seekTo(long paramLong, int paramInt)
  {
    AppMethodBeat.i(155933);
    this.fKr.seekTo(paramLong, paramInt);
    AppMethodBeat.o(155933);
  }
  
  public final void selectTrack(int paramInt)
  {
    AppMethodBeat.i(155931);
    this.fKr.selectTrack(paramInt);
    AppMethodBeat.o(155931);
  }
  
  public final void setDataSource(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(155926);
    this.fKr.setDataSource(paramFileDescriptor);
    AppMethodBeat.o(155926);
  }
  
  public final void setDataSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(155927);
    this.fKr.setDataSource(paramFileDescriptor, paramLong1, paramLong2);
    AppMethodBeat.o(155927);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(210543);
    sI(paramString);
    AppMethodBeat.o(210543);
  }
  
  public final void unselectTrack(int paramInt)
  {
    AppMethodBeat.i(155932);
    this.fKr.unselectTrack(paramInt);
    AppMethodBeat.o(155932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.h.c
 * JD-Core Version:    0.7.0.1
 */