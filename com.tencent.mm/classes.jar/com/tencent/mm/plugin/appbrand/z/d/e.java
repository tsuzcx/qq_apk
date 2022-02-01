package com.tencent.mm.plugin.appbrand.z.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  implements c
{
  protected static byte[] mWq = new byte[0];
  protected boolean mWr;
  protected d.a mWs;
  private ByteBuffer mWt;
  protected boolean mWu;
  
  public e() {}
  
  public e(d.a parama)
  {
    AppMethodBeat.i(156660);
    this.mWs = parama;
    this.mWt = ByteBuffer.wrap(mWq);
    AppMethodBeat.o(156660);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(156661);
    this.mWr = paramd.bCE();
    this.mWs = paramd.bCG();
    this.mWt = paramd.bCD();
    this.mWu = paramd.bCF();
    AppMethodBeat.o(156661);
  }
  
  public void A(ByteBuffer paramByteBuffer)
  {
    this.mWt = paramByteBuffer;
  }
  
  public final void a(d.a parama)
  {
    this.mWs = parama;
  }
  
  public ByteBuffer bCD()
  {
    return this.mWt;
  }
  
  public final boolean bCE()
  {
    return this.mWr;
  }
  
  public final boolean bCF()
  {
    return this.mWu;
  }
  
  public final d.a bCG()
  {
    return this.mWs;
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(156662);
    ByteBuffer localByteBuffer1 = paramd.bCD();
    if (this.mWt == null)
    {
      this.mWt = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.mWt.put(localByteBuffer1);
      localByteBuffer1.reset();
      this.mWr = paramd.bCE();
      AppMethodBeat.o(156662);
      return;
    }
    localByteBuffer1.mark();
    this.mWt.position(this.mWt.limit());
    this.mWt.limit(this.mWt.capacity());
    if (localByteBuffer1.remaining() > this.mWt.remaining())
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.mWt.capacity());
      this.mWt.flip();
      localByteBuffer2.put(this.mWt);
      localByteBuffer2.put(localByteBuffer1);
      this.mWt = localByteBuffer2;
    }
    for (;;)
    {
      this.mWt.rewind();
      localByteBuffer1.reset();
      break;
      this.mWt.put(localByteBuffer1);
    }
  }
  
  public final void hS(boolean paramBoolean)
  {
    this.mWr = paramBoolean;
  }
  
  public final void hT(boolean paramBoolean)
  {
    this.mWu = paramBoolean;
  }
  
  public String toString()
  {
    AppMethodBeat.i(156663);
    String str = "Framedata{ optcode:" + this.mWs + ", fin:" + this.mWr + ", payloadlength:[pos:" + this.mWt.position() + ", len:" + this.mWt.remaining() + "], payload:" + Arrays.toString(b.VW(new String(this.mWt.array()))) + "}";
    AppMethodBeat.o(156663);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.d.e
 * JD-Core Version:    0.7.0.1
 */