package com.tencent.d.f;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class l
{
  static HashMap<String, byte[]> Ith = null;
  protected String Itd;
  protected RequestPacket Ite;
  protected HashMap<String, byte[]> Itf;
  private HashMap<String, Object> Itg;
  
  public l()
  {
    AppMethodBeat.i(138485);
    this.Itd = "UTF-8";
    this.Ite = new RequestPacket();
    this.Itf = new HashMap();
    this.Itg = new HashMap();
    this.Ite.iVersion = 3;
    AppMethodBeat.o(138485);
  }
  
  public final byte[] Kj()
  {
    AppMethodBeat.i(138487);
    if (this.Ite.sServantName == null) {
      this.Ite.sServantName = "";
    }
    if (this.Ite.sFuncName == null) {
      this.Ite.sFuncName = "";
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.Itd);
    ((JceOutputStream)localObject).write(this.Itf, 0);
    this.Ite.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.Itd);
    this.Ite.writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    localObject = localByteBuffer.array();
    AppMethodBeat.o(138487);
    return localObject;
  }
  
  public final void aNL(String paramString)
  {
    this.Itd = paramString;
  }
  
  public final void aNM(String paramString)
  {
    this.Ite.sServantName = paramString;
  }
  
  public final void aNN(String paramString)
  {
    this.Ite.sFuncName = paramString;
  }
  
  public final void fmA()
  {
    this.Ite.iRequestId = 3;
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
    localJceOutputStream.setServerEncoding(this.Itd);
    localJceOutputStream.write(paramT, 0);
    paramT = JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
    this.Itf.put(paramString, paramT);
    AppMethodBeat.o(138486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.f.l
 * JD-Core Version:    0.7.0.1
 */