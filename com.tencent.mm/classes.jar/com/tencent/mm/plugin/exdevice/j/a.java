package com.tencent.mm.plugin.exdevice.j;

import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.Assert;

public final class a
{
  private final int jHT = 1024;
  private ByteBuffer jHU;
  private ByteBuffer jHV;
  
  public a(int paramInt)
  {
    y.d("MicroMsg.exdevice.AutoBuffer", "******AutoBuffer****** capacity = " + paramInt);
    if (paramInt >= 0)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      this.jHV = ByteBuffer.allocate(paramInt);
      this.jHU = this.jHV.asReadOnlyBuffer();
      if (this.jHV == null) {
        break label95;
      }
      bool1 = true;
      label72:
      Assert.assertTrue(bool1);
      if (this.jHU == null) {
        break label100;
      }
    }
    label95:
    label100:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label72;
    }
  }
  
  public final void O(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    Assert.assertTrue(true);
    if (paramInt >= 0)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramArrayOfByte.length < 0) {
        break label98;
      }
      bool1 = true;
      label24:
      Assert.assertTrue(bool1);
      if (paramArrayOfByte.length < paramInt + 0) {
        break label103;
      }
      bool1 = true;
      label38:
      Assert.assertTrue(bool1);
      if (this.jHU.remaining() < paramInt) {
        break label108;
      }
    }
    label98:
    label103:
    label108:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      y.d("MicroMsg.exdevice.AutoBuffer", "readByte dstOffset = 0 byteCount = " + paramInt);
      this.jHU.get(paramArrayOfByte, 0, paramInt);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label24;
      bool1 = false;
      break label38;
    }
  }
  
  public final void P(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    Assert.assertTrue(true);
    if (paramInt >= 0)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramArrayOfByte == null) {
        break label177;
      }
    }
    label177:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      y.d("MicroMsg.exdevice.AutoBuffer", "writeByte srcOffset = 0 byteCount = " + paramInt);
      if (paramInt <= this.jHV.remaining()) {
        break label183;
      }
      y.d("MicroMsg.exdevice.AutoBuffer", "byteCount > mWriteStream.remaining() Recalloc");
      y.d("MicroMsg.exdevice.AutoBuffer", "getCapacity = " + this.jHV.capacity());
      ByteBuffer localByteBuffer = ByteBuffer.allocate(this.jHV.capacity() + paramInt + 1024);
      int i = this.jHU.position();
      localByteBuffer.put(this.jHV.array());
      localByteBuffer.put(paramArrayOfByte, 0, paramInt);
      this.jHV = localByteBuffer;
      this.jHU = localByteBuffer.asReadOnlyBuffer();
      this.jHU.position(i);
      return;
      bool1 = false;
      break;
    }
    label183:
    this.jHV.put(paramArrayOfByte, 0, paramInt);
  }
  
  public final int getSize()
  {
    y.d("MicroMsg.exdevice.AutoBuffer", "size = " + this.jHV.position());
    return this.jHV.position();
  }
  
  public final short readShort()
  {
    if (getSize() <= 1) {
      throw new IOException("There is only one byte in array");
    }
    short s = this.jHU.getShort();
    y.d("MicroMsg.exdevice.AutoBuffer", "getShort = " + s);
    return s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.a
 * JD-Core Version:    0.7.0.1
 */