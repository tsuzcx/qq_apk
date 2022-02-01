package com.tencent.mm.plugin.exdevice.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.Assert;

public final class a
{
  private final int yEZ;
  private ByteBuffer yFa;
  private ByteBuffer yFb;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(24311);
    this.yEZ = 1024;
    Log.d("MicroMsg.exdevice.AutoBuffer", "******AutoBuffer****** capacity = ".concat(String.valueOf(paramInt)));
    if (paramInt >= 0)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      this.yFb = ByteBuffer.allocate(paramInt);
      this.yFa = this.yFb.asReadOnlyBuffer();
      if (this.yFb == null) {
        break label100;
      }
      bool1 = true;
      label71:
      Assert.assertTrue(bool1);
      if (this.yFa == null) {
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
  
  private int dHp()
  {
    AppMethodBeat.i(24312);
    Log.d("MicroMsg.exdevice.AutoBuffer", "getCapacity = " + this.yFb.capacity());
    int i = this.yFb.capacity();
    AppMethodBeat.o(24312);
    return i;
  }
  
  public final void U(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(24315);
    Assert.assertTrue(true);
    if (paramInt >= 0)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramArrayOfByte.length < 0) {
        break label110;
      }
      bool1 = true;
      label30:
      Assert.assertTrue(bool1);
      if (paramArrayOfByte.length < paramInt + 0) {
        break label115;
      }
      bool1 = true;
      label44:
      Assert.assertTrue(bool1);
      if (this.yFa.remaining() < paramInt) {
        break label120;
      }
    }
    label110:
    label115:
    label120:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      Log.d("MicroMsg.exdevice.AutoBuffer", "readByte dstOffset = 0 byteCount = " + paramInt);
      this.yFa.get(paramArrayOfByte, 0, paramInt);
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
  
  public final void V(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(24316);
    Assert.assertTrue(true);
    if (paramInt >= 0)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (paramArrayOfByte == null) {
        break label159;
      }
    }
    label159:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      Log.d("MicroMsg.exdevice.AutoBuffer", "writeByte srcOffset = 0 byteCount = " + paramInt);
      if (paramInt <= this.yFb.remaining()) {
        break label165;
      }
      Log.d("MicroMsg.exdevice.AutoBuffer", "byteCount > mWriteStream.remaining() Recalloc");
      ByteBuffer localByteBuffer = ByteBuffer.allocate(dHp() + paramInt + 1024);
      int i = this.yFa.position();
      localByteBuffer.put(this.yFb.array());
      localByteBuffer.put(paramArrayOfByte, 0, paramInt);
      this.yFb = localByteBuffer;
      this.yFa = localByteBuffer.asReadOnlyBuffer();
      this.yFa.position(i);
      AppMethodBeat.o(24316);
      return;
      bool1 = false;
      break;
    }
    label165:
    this.yFb.put(paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(24316);
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(24313);
    Log.d("MicroMsg.exdevice.AutoBuffer", "size = " + this.yFb.position());
    int i = this.yFb.position();
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
    short s = this.yFa.getShort();
    Log.d("MicroMsg.exdevice.AutoBuffer", "getShort = ".concat(String.valueOf(s)));
    AppMethodBeat.o(24314);
    return s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.k.a
 * JD-Core Version:    0.7.0.1
 */