package com.tencent.mm.plugin.appbrand.ae.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  implements c
{
  protected static byte[] ojp = new byte[0];
  protected boolean ojq;
  protected d.a ojr;
  private ByteBuffer ojs;
  protected boolean ojt;
  
  public e() {}
  
  public e(d.a parama)
  {
    AppMethodBeat.i(156660);
    this.ojr = parama;
    this.ojs = ByteBuffer.wrap(ojp);
    AppMethodBeat.o(156660);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(156661);
    this.ojq = paramd.bZI();
    this.ojr = paramd.bZK();
    this.ojs = paramd.bZH();
    this.ojt = paramd.bZJ();
    AppMethodBeat.o(156661);
  }
  
  public void A(ByteBuffer paramByteBuffer)
  {
    this.ojs = paramByteBuffer;
  }
  
  public final void a(d.a parama)
  {
    this.ojr = parama;
  }
  
  public ByteBuffer bZH()
  {
    return this.ojs;
  }
  
  public final boolean bZI()
  {
    return this.ojq;
  }
  
  public final boolean bZJ()
  {
    return this.ojt;
  }
  
  public final d.a bZK()
  {
    return this.ojr;
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(156662);
    ByteBuffer localByteBuffer1 = paramd.bZH();
    if (this.ojs == null)
    {
      this.ojs = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.ojs.put(localByteBuffer1);
      localByteBuffer1.reset();
      this.ojq = paramd.bZI();
      AppMethodBeat.o(156662);
      return;
    }
    localByteBuffer1.mark();
    this.ojs.position(this.ojs.limit());
    this.ojs.limit(this.ojs.capacity());
    if (localByteBuffer1.remaining() > this.ojs.remaining())
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.ojs.capacity());
      this.ojs.flip();
      localByteBuffer2.put(this.ojs);
      localByteBuffer2.put(localByteBuffer1);
      this.ojs = localByteBuffer2;
    }
    for (;;)
    {
      this.ojs.rewind();
      localByteBuffer1.reset();
      break;
      this.ojs.put(localByteBuffer1);
    }
  }
  
  public final void iX(boolean paramBoolean)
  {
    this.ojq = paramBoolean;
  }
  
  public final void iY(boolean paramBoolean)
  {
    this.ojt = paramBoolean;
  }
  
  public String toString()
  {
    AppMethodBeat.i(156663);
    String str = "Framedata{ optcode:" + this.ojr + ", fin:" + this.ojq + ", payloadlength:[pos:" + this.ojs.position() + ", len:" + this.ojs.remaining() + "], payload:" + Arrays.toString(b.afS(new String(this.ojs.array()))) + "}";
    AppMethodBeat.o(156663);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.d.e
 * JD-Core Version:    0.7.0.1
 */