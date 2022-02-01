package com.tencent.g.d;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class a
{
  static HashMap<String, byte[]> ZqM = null;
  protected HashMap<String, byte[]> ZqL;
  private HashMap<String, Object> cii;
  protected String cij;
  protected RequestPacket cil;
  
  public a()
  {
    AppMethodBeat.i(207975);
    this.cij = "UTF-8";
    this.cil = new RequestPacket();
    this.ZqL = new HashMap();
    this.cii = new HashMap();
    this.cil.iVersion = 3;
    AppMethodBeat.o(207975);
  }
  
  public final byte[] Km()
  {
    AppMethodBeat.i(207985);
    if (this.cil.sServantName == null) {
      this.cil.sServantName = "";
    }
    if (this.cil.sFuncName == null) {
      this.cil.sFuncName = "";
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.cij);
    ((JceOutputStream)localObject).write(this.ZqL, 0);
    this.cil.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.cij);
    this.cil.writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    localObject = localByteBuffer.array();
    AppMethodBeat.o(207985);
    return localObject;
  }
  
  public final void Kn()
  {
    this.cil.iRequestId = 3;
  }
  
  public final void bCX(String paramString)
  {
    this.cij = paramString;
  }
  
  public final <T> void c(String paramString, T paramT)
  {
    AppMethodBeat.i(207982);
    if ((paramString.startsWith(".")) || (paramT == null) || ((paramT instanceof Set)))
    {
      paramString = new IllegalArgumentException("wup put err");
      AppMethodBeat.o(207982);
      throw paramString;
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding(this.cij);
    localJceOutputStream.write(paramT, 0);
    paramT = JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
    this.ZqL.put(paramString, paramT);
    AppMethodBeat.o(207982);
  }
  
  public final void cS(String paramString)
  {
    this.cil.sServantName = paramString;
  }
  
  public final void cT(String paramString)
  {
    this.cil.sFuncName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.d.a
 * JD-Core Version:    0.7.0.1
 */