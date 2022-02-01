package com.tencent.mm.plugin.appbrand.ab.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  implements c
{
  protected static byte[] lOB = new byte[0];
  protected boolean lOC;
  protected d.a lOD;
  private ByteBuffer lOE;
  protected boolean lOF;
  
  public e() {}
  
  public e(d.a parama)
  {
    AppMethodBeat.i(156660);
    this.lOD = parama;
    this.lOE = ByteBuffer.wrap(lOB);
    AppMethodBeat.o(156660);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(156661);
    this.lOC = paramd.bqF();
    this.lOD = paramd.bqH();
    this.lOE = paramd.bqE();
    this.lOF = paramd.bqG();
    AppMethodBeat.o(156661);
  }
  
  public void A(ByteBuffer paramByteBuffer)
  {
    this.lOE = paramByteBuffer;
  }
  
  public final void a(d.a parama)
  {
    this.lOD = parama;
  }
  
  public ByteBuffer bqE()
  {
    return this.lOE;
  }
  
  public final boolean bqF()
  {
    return this.lOC;
  }
  
  public final boolean bqG()
  {
    return this.lOF;
  }
  
  public final d.a bqH()
  {
    return this.lOD;
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(156662);
    ByteBuffer localByteBuffer1 = paramd.bqE();
    if (this.lOE == null)
    {
      this.lOE = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.lOE.put(localByteBuffer1);
      localByteBuffer1.reset();
      this.lOC = paramd.bqF();
      AppMethodBeat.o(156662);
      return;
    }
    localByteBuffer1.mark();
    this.lOE.position(this.lOE.limit());
    this.lOE.limit(this.lOE.capacity());
    if (localByteBuffer1.remaining() > this.lOE.remaining())
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.lOE.capacity());
      this.lOE.flip();
      localByteBuffer2.put(this.lOE);
      localByteBuffer2.put(localByteBuffer1);
      this.lOE = localByteBuffer2;
    }
    for (;;)
    {
      this.lOE.rewind();
      localByteBuffer1.reset();
      break;
      this.lOE.put(localByteBuffer1);
    }
  }
  
  public final void hk(boolean paramBoolean)
  {
    this.lOC = paramBoolean;
  }
  
  public final void hl(boolean paramBoolean)
  {
    this.lOF = paramBoolean;
  }
  
  public String toString()
  {
    AppMethodBeat.i(156663);
    String str = "Framedata{ optcode:" + this.lOD + ", fin:" + this.lOC + ", payloadlength:[pos:" + this.lOE.position() + ", len:" + this.lOE.remaining() + "], payload:" + Arrays.toString(b.Nx(new String(this.lOE.array()))) + "}";
    AppMethodBeat.o(156663);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.d.e
 * JD-Core Version:    0.7.0.1
 */