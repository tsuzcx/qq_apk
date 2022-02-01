package com.qq.a.a;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.HashMap;

public final class c
  extends b
{
  static HashMap<String, HashMap<String, byte[]>> cim = null;
  protected RequestPacket cil;
  
  public c()
  {
    AppMethodBeat.i(186369);
    this.cil = new RequestPacket();
    this.cil.iVersion = 2;
    AppMethodBeat.o(186369);
  }
  
  public final byte[] Km()
  {
    AppMethodBeat.i(186373);
    if (this.cil.sServantName.equals(""))
    {
      localObject = new IllegalArgumentException("servantName can not is null");
      AppMethodBeat.o(186373);
      throw ((Throwable)localObject);
    }
    if (this.cil.sFuncName.equals(""))
    {
      localObject = new IllegalArgumentException("funcName can not is null");
      AppMethodBeat.o(186373);
      throw ((Throwable)localObject);
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.cij);
    ((JceOutputStream)localObject).write(this.cig, 0);
    this.cil.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.cij);
    writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    localObject = localByteBuffer.array();
    AppMethodBeat.o(186373);
    return localObject;
  }
  
  public final void Kn()
  {
    this.cil.iRequestId = 1;
  }
  
  public final <T> void c(String paramString, T paramT)
  {
    AppMethodBeat.i(186371);
    if (paramString.startsWith("."))
    {
      paramString = new IllegalArgumentException("put name can not startwith . ");
      AppMethodBeat.o(186371);
      throw paramString;
    }
    super.c(paramString, paramT);
    AppMethodBeat.o(186371);
  }
  
  public final void cS(String paramString)
  {
    this.cil.sServantName = paramString;
  }
  
  public final void cT(String paramString)
  {
    this.cil.sFuncName = paramString;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(186384);
    this.cil.display(paramStringBuilder, paramInt);
    AppMethodBeat.o(186384);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(186381);
    this.cil.readFrom(paramJceInputStream);
    AppMethodBeat.o(186381);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(186377);
    this.cil.writeTo(paramJceOutputStream);
    AppMethodBeat.o(186377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.qq.a.a.c
 * JD-Core Version:    0.7.0.1
 */