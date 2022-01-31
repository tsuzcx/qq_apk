package com.tencent.mm.plugin.appbrand.u.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  implements c
{
  protected static byte[] iZM = new byte[0];
  protected boolean iZN;
  protected d.a iZO;
  private ByteBuffer iZP;
  protected boolean iZQ;
  
  public e() {}
  
  public e(d.a parama)
  {
    AppMethodBeat.i(73262);
    this.iZO = parama;
    this.iZP = ByteBuffer.wrap(iZM);
    AppMethodBeat.o(73262);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(73263);
    this.iZN = paramd.aOm();
    this.iZO = paramd.aOo();
    this.iZP = paramd.aOl();
    this.iZQ = paramd.aOn();
    AppMethodBeat.o(73263);
  }
  
  public final void a(d.a parama)
  {
    this.iZO = parama;
  }
  
  public ByteBuffer aOl()
  {
    return this.iZP;
  }
  
  public final boolean aOm()
  {
    return this.iZN;
  }
  
  public final boolean aOn()
  {
    return this.iZQ;
  }
  
  public final d.a aOo()
  {
    return this.iZO;
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(73264);
    ByteBuffer localByteBuffer1 = paramd.aOl();
    if (this.iZP == null)
    {
      this.iZP = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.iZP.put(localByteBuffer1);
      localByteBuffer1.reset();
      this.iZN = paramd.aOm();
      AppMethodBeat.o(73264);
      return;
    }
    localByteBuffer1.mark();
    this.iZP.position(this.iZP.limit());
    this.iZP.limit(this.iZP.capacity());
    if (localByteBuffer1.remaining() > this.iZP.remaining())
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.iZP.capacity());
      this.iZP.flip();
      localByteBuffer2.put(this.iZP);
      localByteBuffer2.put(localByteBuffer1);
      this.iZP = localByteBuffer2;
    }
    for (;;)
    {
      this.iZP.rewind();
      localByteBuffer1.reset();
      break;
      this.iZP.put(localByteBuffer1);
    }
  }
  
  public final void eY(boolean paramBoolean)
  {
    this.iZN = paramBoolean;
  }
  
  public final void eZ(boolean paramBoolean)
  {
    this.iZQ = paramBoolean;
  }
  
  public String toString()
  {
    AppMethodBeat.i(73265);
    String str = "Framedata{ optcode:" + this.iZO + ", fin:" + this.iZN + ", payloadlength:[pos:" + this.iZP.position() + ", len:" + this.iZP.remaining() + "], payload:" + Arrays.toString(b.FA(new String(this.iZP.array()))) + "}";
    AppMethodBeat.o(73265);
    return str;
  }
  
  public void w(ByteBuffer paramByteBuffer)
  {
    this.iZP = paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.d.e
 * JD-Core Version:    0.7.0.1
 */