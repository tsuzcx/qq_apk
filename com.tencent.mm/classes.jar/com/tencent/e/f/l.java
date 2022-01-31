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
  static HashMap<String, byte[]> BlN = null;
  protected String BlJ;
  protected RequestPacket BlK;
  protected HashMap<String, byte[]> BlL;
  private HashMap<String, Object> BlM;
  
  public l()
  {
    AppMethodBeat.i(114622);
    this.BlJ = "UTF-8";
    this.BlK = new RequestPacket();
    this.BlL = new HashMap();
    this.BlM = new HashMap();
    this.BlK.iVersion = 3;
    AppMethodBeat.o(114622);
  }
  
  public final byte[] AJ()
  {
    AppMethodBeat.i(114624);
    if (this.BlK.sServantName == null) {
      this.BlK.sServantName = "";
    }
    if (this.BlK.sFuncName == null) {
      this.BlK.sFuncName = "";
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.BlJ);
    ((JceOutputStream)localObject).write(this.BlL, 0);
    this.BlK.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.BlJ);
    this.BlK.writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    localObject = localByteBuffer.array();
    AppMethodBeat.o(114624);
    return localObject;
  }
  
  public final void awG(String paramString)
  {
    this.BlJ = paramString;
  }
  
  public final void awH(String paramString)
  {
    this.BlK.sServantName = paramString;
  }
  
  public final void awI(String paramString)
  {
    this.BlK.sFuncName = paramString;
  }
  
  public final void dUW()
  {
    this.BlK.iRequestId = 3;
  }
  
  public final <T> void put(String paramString, T paramT)
  {
    AppMethodBeat.i(114623);
    if ((paramString.startsWith(".")) || (paramT == null) || ((paramT instanceof Set)))
    {
      paramString = new IllegalArgumentException("wup put err");
      AppMethodBeat.o(114623);
      throw paramString;
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding(this.BlJ);
    localJceOutputStream.write(paramT, 0);
    paramT = JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
    this.BlL.put(paramString, paramT);
    AppMethodBeat.o(114623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.f.l
 * JD-Core Version:    0.7.0.1
 */