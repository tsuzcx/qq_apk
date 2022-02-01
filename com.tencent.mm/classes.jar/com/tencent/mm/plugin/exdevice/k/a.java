package com.tencent.mm.plugin.exdevice.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.Assert;

public final class a
{
  private final int qoS;
  private ByteBuffer qoT;
  private ByteBuffer qoU;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(24311);
    this.qoS = 1024;
    ad.d("MicroMsg.exdevice.AutoBuffer", "******AutoBuffer****** capacity = ".concat(String.valueOf(paramInt)));
    if (paramInt >= 0)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      this.qoU = ByteBuffer.allocate(paramInt);
      this.qoT = this.qoU.asReadOnlyBuffer();
      if (this.qoU == null) {
        break label100;
      }
      bool1 = true;
      label71:
      Assert.assertTrue(bool1);
      if (this.qoT == null) {
        break label105;
      }
    }
    label100:
    label105:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      AppMethodBeat.o(24311);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label71;
    }
  }
  
  private int getCapacity()
  {
    AppMethodBeat.i(24312);
    ad.d("MicroMsg.exdevice.AutoBuffer", "getCapacity = " + this.qoU.capacity());
    int i = this.qoU.capacity();
    AppMethodBeat.o(24312);
    return i;
  }
  
  public final void R(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(24315);
    Assert.assertTrue(true);
    if (paramInt >= 0)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramArrayOfByte.length < 0) {
        break label103;
      }
      bool1 = true;
      label30:
      Assert.assertTrue(bool1);
      if (paramArrayOfByte.length < paramInt + 0) {
        break label108;
      }
      bool1 = true;
      label44:
      Assert.assertTrue(bool1);
      if (this.qoT.remaining() < paramInt) {
        break label113;
      }
    }
    label103:
    label108:
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      ad.d("MicroMsg.exdevice.AutoBuffer", "readByte dstOffset = 0 byteCount = ".concat(String.valueOf(paramInt)));
      this.qoT.get(paramArrayOfByte, 0, paramInt);
      AppMethodBeat.o(24315);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label30;
      bool1 = false;
      break label44;
    }
  }
  
  public final void S(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(24316);
    Assert.assertTrue(true);
    if (paramInt >= 0)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramArrayOfByte == null) {
        break label152;
      }
    }
    label152:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      ad.d("MicroMsg.exdevice.AutoBuffer", "writeByte srcOffset = 0 byteCount = ".concat(String.valueOf(paramInt)));
      if (paramInt <= this.qoU.remaining()) {
        break label158;
      }
      ad.d("MicroMsg.exdevice.AutoBuffer", "byteCount > mWriteStream.remaining() Recalloc");
      ByteBuffer localByteBuffer = ByteBuffer.allocate(getCapacity() + paramInt + 1024);
      int i = this.qoT.position();
      localByteBuffer.put(this.qoU.array());
      localByteBuffer.put(paramArrayOfByte, 0, paramInt);
      this.qoU = localByteBuffer;
      this.qoT = localByteBuffer.asReadOnlyBuffer();
      this.qoT.position(i);
      AppMethodBeat.o(24316);
      return;
      bool1 = false;
      break;
    }
    label158:
    this.qoU.put(paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(24316);
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(24313);
    ad.d("MicroMsg.exdevice.AutoBuffer", "size = " + this.qoU.position());
    int i = this.qoU.position();
    AppMethodBeat.o(24313);
    return i;
  }
  
  public final short readShort()
  {
    AppMethodBeat.i(24314);
    if (getSize() <= 1)
    {
      IOException localIOException = new IOException("There is only one byte in array");
      AppMethodBeat.o(24314);
      throw localIOException;
    }
    short s = this.qoT.getShort();
    ad.d("MicroMsg.exdevice.AutoBuffer", "getShort = ".concat(String.valueOf(s)));
    AppMethodBeat.o(24314);
    return s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.k.a
 * JD-Core Version:    0.7.0.1
 */