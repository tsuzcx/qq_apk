package com.tencent.mm.plugin.appbrand.u.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u.c.c;
import java.nio.ByteBuffer;

public final class b
  extends e
  implements a
{
  static final ByteBuffer iZE;
  private int code;
  private String hVK;
  
  static
  {
    AppMethodBeat.i(73258);
    iZE = ByteBuffer.allocate(0);
    AppMethodBeat.o(73258);
  }
  
  public b()
  {
    super(d.a.iZK);
    AppMethodBeat.i(73251);
    eY(true);
    AppMethodBeat.o(73251);
  }
  
  public b(int paramInt, String paramString)
  {
    super(d.a.iZK);
    AppMethodBeat.i(73252);
    eY(true);
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
          paramString = new com.tencent.mm.plugin.appbrand.u.c.b("A close frame must have a closecode if it has a reason");
          AppMethodBeat.o(73252);
          throw paramString;
        }
        AppMethodBeat.o(73252);
        return;
      }
      paramString = com.tencent.mm.plugin.appbrand.u.f.b.FA(paramString);
      ByteBuffer localByteBuffer1 = ByteBuffer.allocate(4);
      localByteBuffer1.putInt(i);
      localByteBuffer1.position(2);
      ByteBuffer localByteBuffer2 = ByteBuffer.allocate(paramString.length + 2);
      localByteBuffer2.put(localByteBuffer1);
      localByteBuffer2.put(paramString);
      localByteBuffer2.rewind();
      w(localByteBuffer2);
      AppMethodBeat.o(73252);
      return;
    }
  }
  
  private void aOj()
  {
    AppMethodBeat.i(73253);
    this.code = 1005;
    Object localObject = super.aOl();
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
        AppMethodBeat.o(73253);
        throw ((Throwable)localObject);
      }
    }
    ((ByteBuffer)localObject).reset();
    AppMethodBeat.o(73253);
  }
  
  private void aOk()
  {
    AppMethodBeat.i(73254);
    if (this.code == 1005)
    {
      this.hVK = com.tencent.mm.plugin.appbrand.u.f.b.x(super.aOl());
      AppMethodBeat.o(73254);
      return;
    }
    ByteBuffer localByteBuffer = super.aOl();
    int i = localByteBuffer.position();
    try
    {
      localByteBuffer.position(localByteBuffer.position() + 2);
      this.hVK = com.tencent.mm.plugin.appbrand.u.f.b.x(localByteBuffer);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      c localc = new c(localIllegalArgumentException);
      AppMethodBeat.o(73254);
      throw localc;
    }
    finally
    {
      localByteBuffer.position(i);
      AppMethodBeat.o(73254);
    }
  }
  
  public final int aOi()
  {
    return this.code;
  }
  
  public final ByteBuffer aOl()
  {
    AppMethodBeat.i(73257);
    if (this.code == 1005)
    {
      localByteBuffer = iZE;
      AppMethodBeat.o(73257);
      return localByteBuffer;
    }
    ByteBuffer localByteBuffer = super.aOl();
    AppMethodBeat.o(73257);
    return localByteBuffer;
  }
  
  public final String getMessage()
  {
    return this.hVK;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(73255);
    String str = super.toString() + "code: " + this.code;
    AppMethodBeat.o(73255);
    return str;
  }
  
  public final void w(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(73256);
    super.w(paramByteBuffer);
    aOj();
    aOk();
    AppMethodBeat.o(73256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.d.b
 * JD-Core Version:    0.7.0.1
 */