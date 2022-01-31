package com.tencent.d.f;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class l
{
  static HashMap<String, byte[]> wOp = null;
  protected String wOl = "UTF-8";
  protected RequestPacket wOm = new RequestPacket();
  protected HashMap<String, byte[]> wOn = new HashMap();
  private HashMap<String, Object> wOo = new HashMap();
  
  public l()
  {
    this.wOm.iVersion = 3;
  }
  
  public final void afL(String paramString)
  {
    this.wOl = paramString;
  }
  
  public final void afM(String paramString)
  {
    this.wOm.sServantName = paramString;
  }
  
  public final void afN(String paramString)
  {
    this.wOm.sFuncName = paramString;
  }
  
  public final void cPd()
  {
    this.wOm.iRequestId = 3;
  }
  
  public final <T> void put(String paramString, T paramT)
  {
    if ((paramString.startsWith(".")) || (paramT == null) || ((paramT instanceof Set))) {
      throw new IllegalArgumentException("wup put err");
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding(this.wOl);
    localJceOutputStream.write(paramT, 0);
    paramT = JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
    this.wOn.put(paramString, paramT);
  }
  
  public final byte[] ss()
  {
    if (this.wOm.sServantName == null) {
      this.wOm.sServantName = "";
    }
    if (this.wOm.sFuncName == null) {
      this.wOm.sFuncName = "";
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.wOl);
    ((JceOutputStream)localObject).write(this.wOn, 0);
    this.wOm.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.wOl);
    this.wOm.writeTo((JceOutputStream)localObject);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    int i = localObject.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
    localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
    return localByteBuffer.array();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.f.l
 * JD-Core Version:    0.7.0.1
 */