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
  static HashMap<String, byte[]> ahvt = null;
  protected HashMap<String, byte[]> ahvs;
  private HashMap<String, Object> dYH;
  protected String dYI;
  protected RequestPacket dYK;
  
  public l()
  {
    AppMethodBeat.i(138485);
    this.dYI = "UTF-8";
    this.dYK = new RequestPacket();
    this.ahvs = new HashMap();
    this.dYH = new HashMap();
    this.dYK.iVersion = 3;
    AppMethodBeat.o(138485);
  }
  
  public final byte[] akn()
  {
    AppMethodBeat.i(138487);
    if (this.dYK.sServantName == null) {
      this.dYK.sServantName = "";
    }
    if (this.dYK.sFuncName == null) {
      this.dYK.sFuncName = "";
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.dYI);
    ((JceOutputStream)localObject).write(this.ahvs, 0);
    this.dYK.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.dYI);
    this.dYK.writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    localObject = localByteBuffer.array();
    AppMethodBeat.o(138487);
    return localObject;
  }
  
  public final void ako()
  {
    this.dYK.iRequestId = 3;
  }
  
  public final void bFC(String paramString)
  {
    this.dYI = paramString;
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
    AppMethodBeat.i(138486);
    if ((paramString.startsWith(".")) || (paramT == null) || ((paramT instanceof Set)))
    {
      paramString = new IllegalArgumentException("wup put err");
      AppMethodBeat.o(138486);
      throw paramString;
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding(this.dYI);
    localJceOutputStream.write(paramT, 0);
    paramT = JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
    this.ahvs.put(paramString, paramT);
    AppMethodBeat.o(138486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.f.l
 * JD-Core Version:    0.7.0.1
 */