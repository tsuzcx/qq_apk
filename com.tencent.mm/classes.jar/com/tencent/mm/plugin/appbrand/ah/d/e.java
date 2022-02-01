package com.tencent.mm.plugin.appbrand.ah.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ah.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  implements c
{
  protected static byte[] uvm = new byte[0];
  protected boolean uvn;
  protected d.a uvo;
  private ByteBuffer uvp;
  protected boolean uvq;
  
  public e() {}
  
  public e(d.a parama)
  {
    AppMethodBeat.i(156660);
    this.uvo = parama;
    this.uvp = ByteBuffer.wrap(uvm);
    AppMethodBeat.o(156660);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(156661);
    this.uvn = paramd.cOo();
    this.uvo = paramd.cOq();
    this.uvp = paramd.cOn();
    this.uvq = paramd.cOp();
    AppMethodBeat.o(156661);
  }
  
  public void D(ByteBuffer paramByteBuffer)
  {
    this.uvp = paramByteBuffer;
  }
  
  public final void a(d.a parama)
  {
    this.uvo = parama;
  }
  
  public ByteBuffer cOn()
  {
    return this.uvp;
  }
  
  public final boolean cOo()
  {
    return this.uvn;
  }
  
  public final boolean cOp()
  {
    return this.uvq;
  }
  
  public final d.a cOq()
  {
    return this.uvo;
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(156662);
    ByteBuffer localByteBuffer1 = paramd.cOn();
    if (this.uvp == null)
    {
      this.uvp = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.uvp.put(localByteBuffer1);
      localByteBuffer1.reset();
      this.uvn = paramd.cOo();
      AppMethodBeat.o(156662);
      return;
    }
    localByteBuffer1.mark();
    this.uvp.position(this.uvp.limit());
    this.uvp.limit(this.uvp.capacity());
    if (localByteBuffer1.remaining() > this.uvp.remaining())
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.uvp.capacity());
      this.uvp.flip();
      localByteBuffer2.put(this.uvp);
      localByteBuffer2.put(localByteBuffer1);
      this.uvp = localByteBuffer2;
    }
    for (;;)
    {
      this.uvp.rewind();
      localByteBuffer1.reset();
      break;
      this.uvp.put(localByteBuffer1);
    }
  }
  
  public final void lh(boolean paramBoolean)
  {
    this.uvn = paramBoolean;
  }
  
  public final void li(boolean paramBoolean)
  {
    this.uvq = paramBoolean;
  }
  
  public String toString()
  {
    AppMethodBeat.i(156663);
    String str = "Framedata{ optcode:" + this.uvo + ", fin:" + this.uvn + ", payloadlength:[pos:" + this.uvp.position() + ", len:" + this.uvp.remaining() + "], payload:" + Arrays.toString(b.agV(new String(this.uvp.array()))) + "}";
    AppMethodBeat.o(156663);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.d.e
 * JD-Core Version:    0.7.0.1
 */