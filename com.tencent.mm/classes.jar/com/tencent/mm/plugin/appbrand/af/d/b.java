package com.tencent.mm.plugin.appbrand.af.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.c.c;
import java.nio.ByteBuffer;

public final class b
  extends e
  implements a
{
  static final ByteBuffer rlv;
  private int code;
  private String dbT;
  
  static
  {
    AppMethodBeat.i(156656);
    rlv = ByteBuffer.allocate(0);
    AppMethodBeat.o(156656);
  }
  
  public b()
  {
    super(d.a.rlB);
    AppMethodBeat.i(156649);
    jX(true);
    AppMethodBeat.o(156649);
  }
  
  public b(int paramInt, String paramString)
  {
    super(d.a.rlB);
    AppMethodBeat.i(156650);
    jX(true);
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
          paramString = new com.tencent.mm.plugin.appbrand.af.c.b("A close frame must have a closecode if it has a reason");
          AppMethodBeat.o(156650);
          throw paramString;
        }
        AppMethodBeat.o(156650);
        return;
      }
      paramString = com.tencent.mm.plugin.appbrand.af.f.b.anx(paramString);
      ByteBuffer localByteBuffer1 = ByteBuffer.allocate(4);
      localByteBuffer1.putInt(i);
      localByteBuffer1.position(2);
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(paramString.length + 2);
      localByteBuffer2.put(localByteBuffer1);
      localByteBuffer2.put(paramString);
      localByteBuffer2.rewind();
      x(localByteBuffer2);
      AppMethodBeat.o(156650);
      return;
    }
  }
  
  private void cmA()
  {
    AppMethodBeat.i(156651);
    this.code = 1005;
    Object localObject = super.cmC();
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
  
  private void cmB()
  {
    AppMethodBeat.i(156652);
    if (this.code == 1005)
    {
      this.dbT = com.tencent.mm.plugin.appbrand.af.f.b.y(super.cmC());
      AppMethodBeat.o(156652);
      return;
    }
    ByteBuffer localByteBuffer = super.cmC();
    int i = localByteBuffer.position();
    try
    {
      localByteBuffer.position(localByteBuffer.position() + 2);
      this.dbT = com.tencent.mm.plugin.appbrand.af.f.b.y(localByteBuffer);
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
  
  public final ByteBuffer cmC()
  {
    AppMethodBeat.i(156655);
    if (this.code == 1005)
    {
      localByteBuffer = rlv;
      AppMethodBeat.o(156655);
      return localByteBuffer;
    }
    ByteBuffer localByteBuffer = super.cmC();
    AppMethodBeat.o(156655);
    return localByteBuffer;
  }
  
  public final int cmz()
  {
    return this.code;
  }
  
  public final String getMessage()
  {
    return this.dbT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(156653);
    String str = super.toString() + "code: " + this.code;
    AppMethodBeat.o(156653);
    return str;
  }
  
  public final void x(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(156654);
    super.x(paramByteBuffer);
    cmA();
    cmB();
    AppMethodBeat.o(156654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.d.b
 * JD-Core Version:    0.7.0.1
 */