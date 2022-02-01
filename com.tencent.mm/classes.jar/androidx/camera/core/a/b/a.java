package androidx.camera.core.a.b;

import androidx.camera.core.ag;
import androidx.camera.core.ag.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class a
{
  public static byte[] h(ag paramag)
  {
    AppMethodBeat.i(199137);
    Object localObject = paramag.is()[0];
    ag.a locala1 = paramag.is()[1];
    ag.a locala2 = paramag.is()[2];
    ByteBuffer localByteBuffer3 = ((ag.a)localObject).getBuffer();
    ByteBuffer localByteBuffer1 = locala1.getBuffer();
    ByteBuffer localByteBuffer2 = locala2.getBuffer();
    localByteBuffer3.rewind();
    localByteBuffer1.rewind();
    localByteBuffer2.rewind();
    int k = localByteBuffer3.remaining();
    int i = 0;
    byte[] arrayOfByte = new byte[paramag.getWidth() * paramag.getHeight() / 2 + k];
    int j = 0;
    while (j < paramag.getHeight())
    {
      localByteBuffer3.get(arrayOfByte, i, paramag.getWidth());
      i += paramag.getWidth();
      localByteBuffer3.position(Math.min(k, localByteBuffer3.position() - paramag.getWidth() + ((ag.a)localObject).getRowStride()));
      j += 1;
    }
    int i1 = paramag.getHeight() / 2;
    int i2 = paramag.getWidth() / 2;
    int i3 = locala2.getRowStride();
    int i4 = locala1.getRowStride();
    int i5 = locala2.getPixelStride();
    int i6 = locala1.getPixelStride();
    paramag = new byte[i3];
    localObject = new byte[i4];
    k = 0;
    j = i;
    i = k;
    while (i < i1)
    {
      localByteBuffer2.get(paramag, 0, Math.min(i3, localByteBuffer2.remaining()));
      localByteBuffer1.get((byte[])localObject, 0, Math.min(i4, localByteBuffer1.remaining()));
      int n = 0;
      int m = 0;
      k = 0;
      while (k < i2)
      {
        int i7 = j + 1;
        arrayOfByte[j] = paramag[n];
        j = i7 + 1;
        arrayOfByte[i7] = localObject[m];
        n += i5;
        m += i6;
        k += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(199137);
    return arrayOfByte;
  }
  
  public static float min(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(199124);
    paramFloat1 = Math.min(Math.min(paramFloat1, paramFloat2), Math.min(paramFloat3, paramFloat4));
    AppMethodBeat.o(199124);
    return paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.a.b.a
 * JD-Core Version:    0.7.0.1
 */