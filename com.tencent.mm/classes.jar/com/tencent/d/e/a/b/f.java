package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class f
  extends JceStruct
{
  public long wNZ = 0L;
  public float x = 0.0F;
  public float y = 0.0F;
  public float z = 0.0F;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wNZ = paramJceInputStream.read(this.wNZ, 0, true);
    this.x = paramJceInputStream.read(this.x, 1, true);
    this.y = paramJceInputStream.read(this.y, 2, true);
    this.z = paramJceInputStream.read(this.z, 3, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wNZ, 0);
    paramJceOutputStream.write(this.x, 1);
    paramJceOutputStream.write(this.y, 2);
    paramJceOutputStream.write(this.z, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.d.e.a.b.f
 * JD-Core Version:    0.7.0.1
 */