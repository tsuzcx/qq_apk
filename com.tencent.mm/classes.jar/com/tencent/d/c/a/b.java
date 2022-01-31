package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b
  extends JceStruct
{
  public int wLA = 0;
  public int wLB = 0;
  public int wLz = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wLz = paramJceInputStream.read(this.wLz, 1, true);
    this.wLA = paramJceInputStream.read(this.wLA, 2, true);
    this.wLB = paramJceInputStream.read(this.wLB, 3, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wLz, 1);
    paramJceOutputStream.write(this.wLA, 2);
    paramJceOutputStream.write(this.wLB, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.c.a.b
 * JD-Core Version:    0.7.0.1
 */