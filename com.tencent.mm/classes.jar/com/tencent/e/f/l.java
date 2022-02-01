package com.tencent.e.f;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class l
{
  static HashMap<String, byte[]> ROg = null;
  protected HashMap<String, byte[]> ROf;
  private HashMap<String, Object> cgg;
  protected String cgh;
  protected RequestPacket cgk;
  
  public l()
  {
    AppMethodBeat.i(138485);
    this.cgh = "UTF-8";
    this.cgk = new RequestPacket();
    this.ROf = new HashMap();
    this.cgg = new HashMap();
    this.cgk.iVersion = 3;
    AppMethodBeat.o(138485);
  }
  
  public final byte[] IJ()
  {
    AppMethodBeat.i(138487);
    if (this.cgk.sServantName == null) {
      this.cgk.sServantName = "";
    }
    if (this.cgk.sFuncName == null) {
      this.cgk.sFuncName = "";
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.cgh);
    ((JceOutputStream)localObject).write(this.ROf, 0);
    this.cgk.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.cgh);
    this.cgk.writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    localObject = localByteBuffer.array();
    AppMethodBeat.o(138487);
    return localObject;
  }
  
  public final void IK()
  {
    this.cgk.iRequestId = 3;
  }
  
  public final void bqf(String paramString)
  {
    this.cgh = paramString;
  }
  
  public final void cy(String paramString)
  {
    this.cgk.sServantName = paramString;
  }
  
  public final void cz(String paramString)
  {
    this.cgk.sFuncName = paramString;
  }
  
  public final <T> void put(String paramString, T paramT)
  {
    AppMethodBeat.i(138486);
    if ((paramString.startsWith(".")) || (paramT == null) || ((paramT instanceof Set)))
    {
      paramString = new IllegalArgumentException("wup put err");
      AppMethodBeat.o(138486);
      throw paramString;
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding(this.cgh);
    localJceOutputStream.write(paramT, 0);
    paramT = JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
    this.ROf.put(paramString, paramT);
    AppMethodBeat.o(138486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.f.l
 * JD-Core Version:    0.7.0.1
 */