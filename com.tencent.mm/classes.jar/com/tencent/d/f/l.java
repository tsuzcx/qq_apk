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
  static HashMap<String, byte[]> JUR = null;
  protected String JUN;
  protected RequestPacket JUO;
  protected HashMap<String, byte[]> JUP;
  private HashMap<String, Object> JUQ;
  
  public l()
  {
    AppMethodBeat.i(138485);
    this.JUN = "UTF-8";
    this.JUO = new RequestPacket();
    this.JUP = new HashMap();
    this.JUQ = new HashMap();
    this.JUO.iVersion = 3;
    AppMethodBeat.o(138485);
  }
  
  public final byte[] JT()
  {
    AppMethodBeat.i(138487);
    if (this.JUO.sServantName == null) {
      this.JUO.sServantName = "";
    }
    if (this.JUO.sFuncName == null) {
      this.JUO.sFuncName = "";
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.JUN);
    ((JceOutputStream)localObject).write(this.JUP, 0);
    this.JUO.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.JUN);
    this.JUO.writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    localObject = localByteBuffer.array();
    AppMethodBeat.o(138487);
    return localObject;
  }
  
  public final void aTo(String paramString)
  {
    this.JUN = paramString;
  }
  
  public final void aTp(String paramString)
  {
    this.JUO.sServantName = paramString;
  }
  
  public final void aTq(String paramString)
  {
    this.JUO.sFuncName = paramString;
  }
  
  public final void fCQ()
  {
    this.JUO.iRequestId = 3;
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
    localJceOutputStream.setServerEncoding(this.JUN);
    localJceOutputStream.write(paramT, 0);
    paramT = JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
    this.JUP.put(paramString, paramT);
    AppMethodBeat.o(138486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.f.l
 * JD-Core Version:    0.7.0.1
 */