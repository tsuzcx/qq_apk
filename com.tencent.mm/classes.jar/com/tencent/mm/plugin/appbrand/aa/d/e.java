package com.tencent.mm.plugin.appbrand.aa.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  implements c
{
  protected static byte[] mqB = new byte[0];
  protected boolean mqC;
  protected d.a mqD;
  private ByteBuffer mqE;
  protected boolean mqF;
  
  public e() {}
  
  public e(d.a parama)
  {
    AppMethodBeat.i(156660);
    this.mqD = parama;
    this.mqE = ByteBuffer.wrap(mqB);
    AppMethodBeat.o(156660);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(156661);
    this.mqC = paramd.bxF();
    this.mqD = paramd.bxH();
    this.mqE = paramd.bxE();
    this.mqF = paramd.bxG();
    AppMethodBeat.o(156661);
  }
  
  public void A(ByteBuffer paramByteBuffer)
  {
    this.mqE = paramByteBuffer;
  }
  
  public final void a(d.a parama)
  {
    this.mqD = parama;
  }
  
  public ByteBuffer bxE()
  {
    return this.mqE;
  }
  
  public final boolean bxF()
  {
    return this.mqC;
  }
  
  public final boolean bxG()
  {
    return this.mqF;
  }
  
  public final d.a bxH()
  {
    return this.mqD;
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(156662);
    ByteBuffer localByteBuffer1 = paramd.bxE();
    if (this.mqE == null)
    {
      this.mqE = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.mqE.put(localByteBuffer1);
      localByteBuffer1.reset();
      this.mqC = paramd.bxF();
      AppMethodBeat.o(156662);
      return;
    }
    localByteBuffer1.mark();
    this.mqE.position(this.mqE.limit());
    this.mqE.limit(this.mqE.capacity());
    if (localByteBuffer1.remaining() > this.mqE.remaining())
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.mqE.capacity());
      this.mqE.flip();
      localByteBuffer2.put(this.mqE);
      localByteBuffer2.put(localByteBuffer1);
      this.mqE = localByteBuffer2;
    }
    for (;;)
    {
      this.mqE.rewind();
      localByteBuffer1.reset();
      break;
      this.mqE.put(localByteBuffer1);
    }
  }
  
  public final void hH(boolean paramBoolean)
  {
    this.mqC = paramBoolean;
  }
  
  public final void hI(boolean paramBoolean)
  {
    this.mqF = paramBoolean;
  }
  
  public String toString()
  {
    AppMethodBeat.i(156663);
    String str = "Framedata{ optcode:" + this.mqD + ", fin:" + this.mqC + ", payloadlength:[pos:" + this.mqE.position() + ", len:" + this.mqE.remaining() + "], payload:" + Arrays.toString(b.RG(new String(this.mqE.array()))) + "}";
    AppMethodBeat.o(156663);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.d.e
 * JD-Core Version:    0.7.0.1
 */