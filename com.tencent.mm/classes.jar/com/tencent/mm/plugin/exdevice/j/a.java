package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.Assert;

public final class a
{
  private final int lRr;
  private ByteBuffer lRs;
  private ByteBuffer lRt;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(20237);
    this.lRr = 1024;
    ab.d("MicroMsg.exdevice.AutoBuffer", "******AutoBuffer****** capacity = ".concat(String.valueOf(paramInt)));
    if (paramInt >= 0)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      this.lRt = ByteBuffer.allocate(paramInt);
      this.lRs = this.lRt.asReadOnlyBuffer();
      if (this.lRt == null) {
        break label100;
      }
      bool1 = true;
      label71:
      Assert.assertTrue(bool1);
      if (this.lRs == null) {
        break label105;
      }
    }
    label100:
    label105:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      AppMethodBeat.o(20237);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label71;
    }
  }
  
  private int getCapacity()
  {
    AppMethodBeat.i(20238);
    ab.d("MicroMsg.exdevice.AutoBuffer", "getCapacity = " + this.lRt.capacity());
    int i = this.lRt.capacity();
    AppMethodBeat.o(20238);
    return i;
  }
  
  public final void P(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(20241);
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
      if (this.lRs.remaining() < paramInt) {
        break label113;
      }
    }
    label103:
    label108:
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      ab.d("MicroMsg.exdevice.AutoBuffer", "readByte dstOffset = 0 byteCount = ".concat(String.valueOf(paramInt)));
      this.lRs.get(paramArrayOfByte, 0, paramInt);
      AppMethodBeat.o(20241);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label30;
      bool1 = false;
      break label44;
    }
  }
  
  public final void Q(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(20242);
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
      ab.d("MicroMsg.exdevice.AutoBuffer", "writeByte srcOffset = 0 byteCount = ".concat(String.valueOf(paramInt)));
      if (paramInt <= this.lRt.remaining()) {
        break label158;
      }
      ab.d("MicroMsg.exdevice.AutoBuffer", "byteCount > mWriteStream.remaining() Recalloc");
      ByteBuffer localByteBuffer = ByteBuffer.allocate(getCapacity() + paramInt + 1024);
      int i = this.lRs.position();
      localByteBuffer.put(this.lRt.array());
      localByteBuffer.put(paramArrayOfByte, 0, paramInt);
      this.lRt = localByteBuffer;
      this.lRs = localByteBuffer.asReadOnlyBuffer();
      this.lRs.position(i);
      AppMethodBeat.o(20242);
      return;
      bool1 = false;
      break;
    }
    label158:
    this.lRt.put(paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(20242);
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(20239);
    ab.d("MicroMsg.exdevice.AutoBuffer", "size = " + this.lRt.position());
    int i = this.lRt.position();
    AppMethodBeat.o(20239);
    return i;
  }
  
  public final short readShort()
  {
    AppMethodBeat.i(20240);
    if (getSize() <= 1)
    {
      IOException localIOException = new IOException("There is only one byte in array");
      AppMethodBeat.o(20240);
      throw localIOException;
    }
    short s = this.lRs.getShort();
    ab.d("MicroMsg.exdevice.AutoBuffer", "getShort = ".concat(String.valueOf(s)));
    AppMethodBeat.o(20240);
    return s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.a
 * JD-Core Version:    0.7.0.1
 */