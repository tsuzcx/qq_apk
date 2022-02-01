package com.tencent.mm.plugin.appbrand.aa.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  implements c
{
  protected static byte[] mRh = new byte[0];
  protected boolean mRi;
  protected d.a mRj;
  private ByteBuffer mRk;
  protected boolean mRl;
  
  public e() {}
  
  public e(d.a parama)
  {
    AppMethodBeat.i(156660);
    this.mRj = parama;
    this.mRk = ByteBuffer.wrap(mRh);
    AppMethodBeat.o(156660);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(156661);
    this.mRi = paramd.bBK();
    this.mRj = paramd.bBM();
    this.mRk = paramd.bBJ();
    this.mRl = paramd.bBL();
    AppMethodBeat.o(156661);
  }
  
  public void A(ByteBuffer paramByteBuffer)
  {
    this.mRk = paramByteBuffer;
  }
  
  public final void a(d.a parama)
  {
    this.mRj = parama;
  }
  
  public ByteBuffer bBJ()
  {
    return this.mRk;
  }
  
  public final boolean bBK()
  {
    return this.mRi;
  }
  
  public final boolean bBL()
  {
    return this.mRl;
  }
  
  public final d.a bBM()
  {
    return this.mRj;
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(156662);
    ByteBuffer localByteBuffer1 = paramd.bBJ();
    if (this.mRk == null)
    {
      this.mRk = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.mRk.put(localByteBuffer1);
      localByteBuffer1.reset();
      this.mRi = paramd.bBK();
      AppMethodBeat.o(156662);
      return;
    }
    localByteBuffer1.mark();
    this.mRk.position(this.mRk.limit());
    this.mRk.limit(this.mRk.capacity());
    if (localByteBuffer1.remaining() > this.mRk.remaining())
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.mRk.capacity());
      this.mRk.flip();
      localByteBuffer2.put(this.mRk);
      localByteBuffer2.put(localByteBuffer1);
      this.mRk = localByteBuffer2;
    }
    for (;;)
    {
      this.mRk.rewind();
      localByteBuffer1.reset();
      break;
      this.mRk.put(localByteBuffer1);
    }
  }
  
  public final void hS(boolean paramBoolean)
  {
    this.mRi = paramBoolean;
  }
  
  public final void hT(boolean paramBoolean)
  {
    this.mRl = paramBoolean;
  }
  
  public String toString()
  {
    AppMethodBeat.i(156663);
    String str = "Framedata{ optcode:" + this.mRj + ", fin:" + this.mRi + ", payloadlength:[pos:" + this.mRk.position() + ", len:" + this.mRk.remaining() + "], payload:" + Arrays.toString(b.Vl(new String(this.mRk.array()))) + "}";
    AppMethodBeat.o(156663);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.d.e
 * JD-Core Version:    0.7.0.1
 */