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
  public final MediaExtractor fGK;
  
  public c()
  {
    AppMethodBeat.i(155923);
    this.fGK = new MediaExtractor();
    AppMethodBeat.o(155923);
  }
  
  public final boolean advance()
  {
    AppMethodBeat.i(204029);
    boolean bool = this.fGK.advance();
    AppMethodBeat.o(204029);
    return bool;
  }
  
  public final long getSampleTime()
  {
    AppMethodBeat.i(204030);
    long l = this.fGK.getSampleTime();
    AppMethodBeat.o(204030);
    return l;
  }
  
  public final int getSampleTrackIndex()
  {
    AppMethodBeat.i(155936);
    int i = this.fGK.getSampleTrackIndex();
    AppMethodBeat.o(155936);
    return i;
  }
  
  public final int getTrackCount()
  {
    AppMethodBeat.i(204028);
    int i = this.fGK.getTrackCount();
    AppMethodBeat.o(204028);
    return i;
  }
  
  public final MediaFormat getTrackFormat(int paramInt)
  {
    AppMethodBeat.i(155930);
    MediaFormat localMediaFormat = this.fGK.getTrackFormat(paramInt);
    AppMethodBeat.o(155930);
    return localMediaFormat;
  }
  
  public final int j(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(155935);
    int i = this.fGK.readSampleData(paramByteBuffer, 0);
    AppMethodBeat.o(155935);
    return i;
  }
  
  /* Error */
  public final void px(String paramString)
  {
    // Byte code:
    //   0: ldc 67
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 69
    //   8: invokestatic 75	com/tencent/mm/vfs/i:lB	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   11: astore 4
    //   13: aload_0
    //   14: getfield 25	com/tencent/mm/compatible/h/c:fGK	Landroid/media/MediaExtractor;
    //   17: aload 4
    //   19: invokevirtual 81	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   22: invokevirtual 85	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   25: aload 4
    //   27: ifnull +8 -> 35
    //   30: aload 4
    //   32: invokevirtual 88	android/os/ParcelFileDescriptor:close	()V
    //   35: ldc 67
    //   37: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: astore_3
    //   42: ldc 67
    //   44: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_3
    //   48: athrow
    //   49: astore_2
    //   50: aload 4
    //   52: ifnull +12 -> 64
    //   55: aload_3
    //   56: ifnull +75 -> 131
    //   59: aload 4
    //   61: invokevirtual 88	android/os/ParcelFileDescriptor:close	()V
    //   64: ldc 67
    //   66: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_2
    //   70: athrow
    //   71: astore_2
    //   72: ldc 90
    //   74: new 92	java/lang/StringBuilder
    //   77: dup
    //   78: ldc 94
    //   80: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload_1
    //   84: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc 102
    //   89: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_2
    //   93: invokevirtual 106	java/io/IOException:getMessage	()Ljava/lang/String;
    //   96: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 115	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 25	com/tencent/mm/compatible/h/c:fGK	Landroid/media/MediaExtractor;
    //   109: aload_1
    //   110: aconst_null
    //   111: invokevirtual 118	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   114: ldc 67
    //   116: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: astore 4
    //   122: aload_3
    //   123: aload 4
    //   125: invokevirtual 122	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   128: goto -64 -> 64
    //   131: aload 4
    //   133: invokevirtual 88	android/os/ParcelFileDescriptor:close	()V
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
  
  public final void release()
  {
    AppMethodBeat.i(204027);
    this.fGK.release();
    AppMethodBeat.o(204027);
  }
  
  public final void seekTo(long paramLong, int paramInt)
  {
    AppMethodBeat.i(155933);
    this.fGK.seekTo(paramLong, paramInt);
    AppMethodBeat.o(155933);
  }
  
  public final void selectTrack(int paramInt)
  {
    AppMethodBeat.i(155931);
    this.fGK.selectTrack(paramInt);
    AppMethodBeat.o(155931);
  }
  
  public final void setDataSource(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(155926);
    this.fGK.setDataSource(paramFileDescriptor);
    AppMethodBeat.o(155926);
  }
  
  public final void setDataSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(155927);
    this.fGK.setDataSource(paramFileDescriptor, paramLong1, paramLong2);
    AppMethodBeat.o(155927);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(204026);
    px(paramString);
    AppMethodBeat.o(204026);
  }
  
  public final void unselectTrack(int paramInt)
  {
    AppMethodBeat.i(155932);
    this.fGK.unselectTrack(paramInt);
    AppMethodBeat.o(155932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.h.c
 * JD-Core Version:    0.7.0.1
 */