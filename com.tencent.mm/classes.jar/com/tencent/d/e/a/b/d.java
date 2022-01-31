package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d
  extends JceStruct
{
  static b wNU;
  public int errorCode = 0;
  public b wNT = null;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.errorCode = paramJceInputStream.read(this.errorCode, 0, true);
    if (wNU == null) {
      wNU = new b();
    }
    this.wNT = ((b)paramJceInputStream.read(wNU, 1, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.errorCode, 0);
    if (this.wNT != null) {
      paramJceOutputStream.write(this.wNT, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.d.e.a.b.d
 * JD-Core Version:    0.7.0.1
 */