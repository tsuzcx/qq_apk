package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c
  extends JceStruct
{
  public int errCode = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.errCode = paramJceInputStream.read(this.errCode, 0, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.errCode != 0) {
      paramJceOutputStream.write(this.errCode, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.d.e.a.b.c
 * JD-Core Version:    0.7.0.1
 */