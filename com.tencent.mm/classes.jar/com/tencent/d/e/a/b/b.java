package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b
  extends JceStruct
{
  public String bwK = "";
  public String wNL = "";
  public int wNR = 0;
  public float wNS = 0.0F;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wNL = paramJceInputStream.readString(0, true);
    this.wNR = paramJceInputStream.read(this.wNR, 1, true);
    this.wNS = paramJceInputStream.read(this.wNS, 2, true);
    this.bwK = paramJceInputStream.readString(3, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wNL, 0);
    paramJceOutputStream.write(this.wNR, 1);
    paramJceOutputStream.write(this.wNS, 2);
    if (this.bwK != null) {
      paramJceOutputStream.write(this.bwK, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.d.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */