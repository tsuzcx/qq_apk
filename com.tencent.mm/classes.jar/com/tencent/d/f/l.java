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
  static HashMap<String, byte[]> LOL = null;
  protected String LOH;
  protected RequestPacket LOI;
  protected HashMap<String, byte[]> LOJ;
  private HashMap<String, Object> LOK;
  
  public l()
  {
    AppMethodBeat.i(138485);
    this.LOH = "UTF-8";
    this.LOI = new RequestPacket();
    this.LOJ = new HashMap();
    this.LOK = new HashMap();
    this.LOI.iVersion = 3;
    AppMethodBeat.o(138485);
  }
  
  public final byte[] Ls()
  {
    AppMethodBeat.i(138487);
    if (this.LOI.sServantName == null) {
      this.LOI.sServantName = "";
    }
    if (this.LOI.sFuncName == null) {
      this.LOI.sFuncName = "";
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.LOH);
    ((JceOutputStream)localObject).write(this.LOJ, 0);
    this.LOI.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.LOH);
    this.LOI.writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    localObject = localByteBuffer.array();
    AppMethodBeat.o(138487);
    return localObject;
  }
  
  public final void aZo(String paramString)
  {
    this.LOH = paramString;
  }
  
  public final void aZp(String paramString)
  {
    this.LOI.sServantName = paramString;
  }
  
  public final void aZq(String paramString)
  {
    this.LOI.sFuncName = paramString;
  }
  
  public final void fUi()
  {
    this.LOI.iRequestId = 3;
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
    localJceOutputStream.setServerEncoding(this.LOH);
    localJceOutputStream.write(paramT, 0);
    paramT = JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
    this.LOJ.put(paramString, paramT);
    AppMethodBeat.o(138486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.f.l
 * JD-Core Version:    0.7.0.1
 */