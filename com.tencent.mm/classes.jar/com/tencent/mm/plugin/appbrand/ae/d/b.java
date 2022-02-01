package com.tencent.mm.plugin.appbrand.ae.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.c.c;
import java.nio.ByteBuffer;

public final class b
  extends e
  implements a
{
  static final ByteBuffer ojh;
  private String cXS;
  private int code;
  
  static
  {
    AppMethodBeat.i(156656);
    ojh = ByteBuffer.allocate(0);
    AppMethodBeat.o(156656);
  }
  
  public b()
  {
    super(d.a.ojn);
    AppMethodBeat.i(156649);
    iX(true);
    AppMethodBeat.o(156649);
  }
  
  public b(int paramInt, String paramString)
  {
    super(d.a.ojn);
    AppMethodBeat.i(156650);
    iX(true);
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 1015)
      {
        paramString = "";
        i = 1005;
      }
      if (i == 1005)
      {
        if (paramString.length() > 0)
        {
          paramString = new com.tencent.mm.plugin.appbrand.ae.c.b("A close frame must have a closecode if it has a reason");
          AppMethodBeat.o(156650);
          throw paramString;
        }
        AppMethodBeat.o(156650);
        return;
      }
      paramString = com.tencent.mm.plugin.appbrand.ae.f.b.afS(paramString);
      ByteBuffer localByteBuffer1 = ByteBuffer.allocate(4);
      localByteBuffer1.putInt(i);
      localByteBuffer1.position(2);
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(paramString.length + 2);
      localByteBuffer2.put(localByteBuffer1);
      localByteBuffer2.put(paramString);
      localByteBuffer2.rewind();
      A(localByteBuffer2);
      AppMethodBeat.o(156650);
      return;
    }
  }
  
  private void bZF()
  {
    AppMethodBeat.i(156651);
    this.code = 1005;
    Object localObject = super.bZH();
    ((ByteBuffer)localObject).mark();
    if (((ByteBuffer)localObject).remaining() >= 2)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.position(2);
      localByteBuffer.putShort(((ByteBuffer)localObject).getShort());
      localByteBuffer.position(0);
      this.code = localByteBuffer.getInt();
      if ((this.code == 1006) || (this.code == 1015) || (this.code == 1005) || (this.code > 4999) || (this.code < 1000) || (this.code == 1004))
      {
        localObject = new c("closecode must not be sent over the wire: " + this.code);
        AppMethodBeat.o(156651);
        throw ((Throwable)localObject);
      }
    }
    ((ByteBuffer)localObject).reset();
    AppMethodBeat.o(156651);
  }
  
  private void bZG()
  {
    AppMethodBeat.i(156652);
    if (this.code == 1005)
    {
      this.cXS = com.tencent.mm.plugin.appbrand.ae.f.b.B(super.bZH());
      AppMethodBeat.o(156652);
      return;
    }
    ByteBuffer localByteBuffer = super.bZH();
    int i = localByteBuffer.position();
    try
    {
      localByteBuffer.position(localByteBuffer.position() + 2);
      this.cXS = com.tencent.mm.plugin.appbrand.ae.f.b.B(localByteBuffer);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      c localc = new c(localIllegalArgumentException);
      AppMethodBeat.o(156652);
      throw localc;
    }
    finally
    {
      localByteBuffer.position(i);
      AppMethodBeat.o(156652);
    }
  }
  
  public final void A(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(156654);
    super.A(paramByteBuffer);
    bZF();
    bZG();
    AppMethodBeat.o(156654);
  }
  
  public final int bZE()
  {
    return this.code;
  }
  
  public final ByteBuffer bZH()
  {
    AppMethodBeat.i(156655);
    if (this.code == 1005)
    {
      localByteBuffer = ojh;
      AppMethodBeat.o(156655);
      return localByteBuffer;
    }
    ByteBuffer localByteBuffer = super.bZH();
    AppMethodBeat.o(156655);
    return localByteBuffer;
  }
  
  public final String getMessage()
  {
    return this.cXS;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(156653);
    String str = super.toString() + "code: " + this.code;
    AppMethodBeat.o(156653);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.d.b
 * JD-Core Version:    0.7.0.1
 */