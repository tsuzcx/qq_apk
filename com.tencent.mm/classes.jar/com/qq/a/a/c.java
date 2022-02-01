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
  static HashMap<String, HashMap<String, byte[]>> dYL = null;
  protected RequestPacket dYK;
  
  public c()
  {
    AppMethodBeat.i(208272);
    this.dYK = new RequestPacket();
    this.dYK.iVersion = 2;
    AppMethodBeat.o(208272);
  }
  
  public final byte[] akn()
  {
    AppMethodBeat.i(208289);
    if (this.dYK.sServantName.equals(""))
    {
      localObject = new IllegalArgumentException("servantName can not is null");
      AppMethodBeat.o(208289);
      throw ((Throwable)localObject);
    }
    if (this.dYK.sFuncName.equals(""))
    {
      localObject = new IllegalArgumentException("funcName can not is null");
      AppMethodBeat.o(208289);
      throw ((Throwable)localObject);
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.dYI);
    ((JceOutputStream)localObject).write(this.dYF, 0);
    this.dYK.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.dYI);
    writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    localObject = localByteBuffer.array();
    AppMethodBeat.o(208289);
    return localObject;
  }
  
  public final void ako()
  {
    this.dYK.iRequestId = 1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(208308);
    this.dYK.display(paramStringBuilder, paramInt);
    AppMethodBeat.o(208308);
  }
  
  public final void em(String paramString)
  {
    this.dYK.sServantName = paramString;
  }
  
  public final void en(String paramString)
  {
    this.dYK.sFuncName = paramString;
  }
  
  public final <T> void j(String paramString, T paramT)
  {
    AppMethodBeat.i(208281);
    if (paramString.startsWith("."))
    {
      paramString = new IllegalArgumentException("put name can not startwith . ");
      AppMethodBeat.o(208281);
      throw paramString;
    }
    super.j(paramString, paramT);
    AppMethodBeat.o(208281);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(208307);
    this.dYK.readFrom(paramJceInputStream);
    AppMethodBeat.o(208307);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(208303);
    this.dYK.writeTo(paramJceOutputStream);
    AppMethodBeat.o(208303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.qq.a.a.c
 * JD-Core Version:    0.7.0.1
 */