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
  static HashMap<String, byte[]> MlJ = null;
  protected String MlF;
  protected RequestPacket MlG;
  protected HashMap<String, byte[]> MlH;
  private HashMap<String, Object> MlI;
  
  public l()
  {
    AppMethodBeat.i(138485);
    this.MlF = "UTF-8";
    this.MlG = new RequestPacket();
    this.MlH = new HashMap();
    this.MlI = new HashMap();
    this.MlG.iVersion = 3;
    AppMethodBeat.o(138485);
  }
  
  public final byte[] LA()
  {
    AppMethodBeat.i(138487);
    if (this.MlG.sServantName == null) {
      this.MlG.sServantName = "";
    }
    if (this.MlG.sFuncName == null) {
      this.MlG.sFuncName = "";
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.MlF);
    ((JceOutputStream)localObject).write(this.MlH, 0);
    this.MlG.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.MlF);
    this.MlG.writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    localObject = localByteBuffer.array();
    AppMethodBeat.o(138487);
    return localObject;
  }
  
  public final void baR(String paramString)
  {
    this.MlF = paramString;
  }
  
  public final void baS(String paramString)
  {
    this.MlG.sServantName = paramString;
  }
  
  public final void baT(String paramString)
  {
    this.MlG.sFuncName = paramString;
  }
  
  public final void fYH()
  {
    this.MlG.iRequestId = 3;
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
    localJceOutputStream.setServerEncoding(this.MlF);
    localJceOutputStream.write(paramT, 0);
    paramT = JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
    this.MlH.put(paramString, paramT);
    AppMethodBeat.o(138486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.f.l
 * JD-Core Version:    0.7.0.1
 */