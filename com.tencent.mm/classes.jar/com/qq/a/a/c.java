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
  static HashMap<String, HashMap<String, byte[]>> cgl = null;
  protected RequestPacket cgk;
  
  public c()
  {
    AppMethodBeat.i(187109);
    this.cgk = new RequestPacket();
    this.cgk.iVersion = 2;
    AppMethodBeat.o(187109);
  }
  
  public final byte[] IJ()
  {
    AppMethodBeat.i(187111);
    if (this.cgk.sServantName.equals(""))
    {
      localObject = new IllegalArgumentException("servantName can not is null");
      AppMethodBeat.o(187111);
      throw ((Throwable)localObject);
    }
    if (this.cgk.sFuncName.equals(""))
    {
      localObject = new IllegalArgumentException("funcName can not is null");
      AppMethodBeat.o(187111);
      throw ((Throwable)localObject);
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.cgh);
    ((JceOutputStream)localObject).write(this.cge, 0);
    this.cgk.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.cgh);
    writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    localObject = localByteBuffer.array();
    AppMethodBeat.o(187111);
    return localObject;
  }
  
  public final void IK()
  {
    this.cgk.iRequestId = 1;
  }
  
  public final void cy(String paramString)
  {
    this.cgk.sServantName = paramString;
  }
  
  public final void cz(String paramString)
  {
    this.cgk.sFuncName = paramString;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(187114);
    this.cgk.display(paramStringBuilder, paramInt);
    AppMethodBeat.o(187114);
  }
  
  public final <T> void put(String paramString, T paramT)
  {
    AppMethodBeat.i(187110);
    if (paramString.startsWith("."))
    {
      paramString = new IllegalArgumentException("put name can not startwith . ");
      AppMethodBeat.o(187110);
      throw paramString;
    }
    super.put(paramString, paramT);
    AppMethodBeat.o(187110);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(187113);
    this.cgk.readFrom(paramJceInputStream);
    AppMethodBeat.o(187113);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(187112);
    this.cgk.writeTo(paramJceOutputStream);
    AppMethodBeat.o(187112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.qq.a.a.c
 * JD-Core Version:    0.7.0.1
 */