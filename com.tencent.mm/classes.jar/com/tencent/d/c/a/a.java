package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a
  extends JceStruct
{
  public int wLx = 0;
  public int wLy = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wLx = paramJceInputStream.read(this.wLx, 0, true);
    this.wLy = paramJceInputStream.read(this.wLy, 1, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wLx, 0);
    paramJceOutputStream.write(this.wLy, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.d.c.a.a
 * JD-Core Version:    0.7.0.1
 */