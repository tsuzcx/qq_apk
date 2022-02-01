package com.tencent.maas.camerafun;

import android.media.Image;
import android.media.Image.Plane;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class MJImage
{
  private final int height;
  private final a[] planes;
  private final long timestamp;
  private final int width;
  
  public MJImage(int paramInt1, int paramInt2, a[] paramArrayOfa, long paramLong)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.planes = paramArrayOfa;
    this.timestamp = paramLong;
  }
  
  private static ByteBuffer clone(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(216861);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramByteBuffer.capacity());
    paramByteBuffer.rewind();
    localByteBuffer.put(paramByteBuffer);
    paramByteBuffer.rewind();
    localByteBuffer.flip();
    AppMethodBeat.o(216861);
    return localByteBuffer;
  }
  
  public static MJImage newInstance(Image paramImage)
  {
    AppMethodBeat.i(216857);
    Image.Plane[] arrayOfPlane = paramImage.getPlanes();
    a[] arrayOfa = new a[arrayOfPlane.length];
    int i = 0;
    while (i < arrayOfPlane.length)
    {
      Image.Plane localPlane = arrayOfPlane[i];
      arrayOfa[i] = new a(localPlane.getRowStride(), localPlane.getPixelStride(), clone(localPlane.getBuffer()));
      i += 1;
    }
    paramImage = new MJImage(paramImage.getWidth(), paramImage.getHeight(), arrayOfa, paramImage.getTimestamp());
    AppMethodBeat.o(216857);
    return paramImage;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public a[] getPlanes()
  {
    return this.planes;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public static class a
  {
    private final ByteBuffer buffer;
    private final int pixelStride;
    private final int rowStride;
    
    public a(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer)
    {
      this.rowStride = paramInt1;
      this.pixelStride = paramInt2;
      this.buffer = paramByteBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJImage
 * JD-Core Version:    0.7.0.1
 */