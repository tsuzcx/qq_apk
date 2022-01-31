package com.tencent.mm.plugin.appbrand.w.d;

import com.tencent.mm.plugin.appbrand.w.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  implements c
{
  protected static byte[] hno = new byte[0];
  protected boolean hnp;
  protected d.a hnq;
  private ByteBuffer hnr;
  protected boolean hns;
  
  public e() {}
  
  public e(d.a parama)
  {
    this.hnq = parama;
    this.hnr = ByteBuffer.wrap(hno);
  }
  
  public e(d paramd)
  {
    this.hnp = paramd.aqL();
    this.hnq = paramd.aqN();
    this.hnr = paramd.aqK();
    this.hns = paramd.aqM();
  }
  
  public final void a(d.a parama)
  {
    this.hnq = parama;
  }
  
  public ByteBuffer aqK()
  {
    return this.hnr;
  }
  
  public final boolean aqL()
  {
    return this.hnp;
  }
  
  public final boolean aqM()
  {
    return this.hns;
  }
  
  public final d.a aqN()
  {
    return this.hnq;
  }
  
  public final void dI(boolean paramBoolean)
  {
    this.hnp = paramBoolean;
  }
  
  public final void dJ(boolean paramBoolean)
  {
    this.hns = paramBoolean;
  }
  
  public final void e(d paramd)
  {
    ByteBuffer localByteBuffer1 = paramd.aqK();
    if (this.hnr == null)
    {
      this.hnr = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.hnr.put(localByteBuffer1);
      localByteBuffer1.reset();
      this.hnp = paramd.aqL();
      return;
    }
    localByteBuffer1.mark();
    this.hnr.position(this.hnr.limit());
    this.hnr.limit(this.hnr.capacity());
    if (localByteBuffer1.remaining() > this.hnr.remaining())
    {
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.hnr.capacity());
      this.hnr.flip();
      localByteBuffer2.put(this.hnr);
      localByteBuffer2.put(localByteBuffer1);
      this.hnr = localByteBuffer2;
    }
    for (;;)
    {
      this.hnr.rewind();
      localByteBuffer1.reset();
      break;
      this.hnr.put(localByteBuffer1);
    }
  }
  
  public String toString()
  {
    return "Framedata{ optcode:" + this.hnq + ", fin:" + this.hnp + ", payloadlength:[pos:" + this.hnr.position() + ", len:" + this.hnr.remaining() + "], payload:" + Arrays.toString(b.wU(new String(this.hnr.array()))) + "}";
  }
  
  public void v(ByteBuffer paramByteBuffer)
  {
    this.hnr = paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.d.e
 * JD-Core Version:    0.7.0.1
 */