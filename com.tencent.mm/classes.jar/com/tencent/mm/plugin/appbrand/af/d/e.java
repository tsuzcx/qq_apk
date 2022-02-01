package com.tencent.mm.plugin.appbrand.af.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  implements c
{
  protected static byte[] rlD = new byte[0];
  protected boolean rlE;
  protected d.a rlF;
  private ByteBuffer rlG;
  protected boolean rlH;
  
  public e() {}
  
  public e(d.a parama)
  {
    AppMethodBeat.i(156660);
    this.rlF = parama;
    this.rlG = ByteBuffer.wrap(rlD);
    AppMethodBeat.o(156660);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(156661);
    this.rlE = paramd.cmD();
    this.rlF = paramd.cmF();
    this.rlG = paramd.cmC();
    this.rlH = paramd.cmE();
    AppMethodBeat.o(156661);
  }
  
  public final void a(d.a parama)
  {
    this.rlF = parama;
  }
  
  public ByteBuffer cmC()
  {
    return this.rlG;
  }
  
  public final boolean cmD()
  {
    return this.rlE;
  }
  
  public final boolean cmE()
  {
    return this.rlH;
  }
  
  public final d.a cmF()
  {
    return this.rlF;
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(156662);
    ByteBuffer localByteBuffer1 = paramd.cmC();
    if (this.rlG == null)
    {
      this.rlG = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.rlG.put(localByteBuffer1);
      localByteBuffer1.reset();
      this.rlE = paramd.cmD();
      AppMethodBeat.o(156662);
      return;
    }
    localByteBuffer1.mark();
    this.rlG.position(this.rlG.limit());
    this.rlG.limit(this.rlG.capacity());
    if (localByteBuffer1.remaining() > this.rlG.remaining())
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.rlG.capacity());
      this.rlG.flip();
      localByteBuffer2.put(this.rlG);
      localByteBuffer2.put(localByteBuffer1);
      this.rlG = localByteBuffer2;
    }
    for (;;)
    {
      this.rlG.rewind();
      localByteBuffer1.reset();
      break;
      this.rlG.put(localByteBuffer1);
    }
  }
  
  public final void jX(boolean paramBoolean)
  {
    this.rlE = paramBoolean;
  }
  
  public final void jY(boolean paramBoolean)
  {
    this.rlH = paramBoolean;
  }
  
  public String toString()
  {
    AppMethodBeat.i(156663);
    String str = "Framedata{ optcode:" + this.rlF + ", fin:" + this.rlE + ", payloadlength:[pos:" + this.rlG.position() + ", len:" + this.rlG.remaining() + "], payload:" + Arrays.toString(b.anx(new String(this.rlG.array()))) + "}";
    AppMethodBeat.o(156663);
    return str;
  }
  
  public void x(ByteBuffer paramByteBuffer)
  {
    this.rlG = paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.d.e
 * JD-Core Version:    0.7.0.1
 */