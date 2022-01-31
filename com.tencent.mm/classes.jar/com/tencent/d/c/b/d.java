package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d
  extends JceStruct
{
  public String egI = "";
  public String model = "";
  public String platform = "";
  public int root = 0;
  public String wMI = "";
  public String wMJ = "";
  public int wMK = 0;
  public String wML = "";
  
  public final JceStruct newInit()
  {
    return new d();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wMI = paramJceInputStream.readString(0, false);
    this.wMJ = paramJceInputStream.readString(1, false);
    this.egI = paramJceInputStream.readString(2, false);
    this.model = paramJceInputStream.readString(3, false);
    this.wMK = paramJceInputStream.read(this.wMK, 4, false);
    this.wML = paramJceInputStream.readString(5, false);
    this.platform = paramJceInputStream.readString(6, false);
    this.root = paramJceInputStream.read(this.root, 7, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.wMI != null) {
      paramJceOutputStream.write(this.wMI, 0);
    }
    if (this.wMJ != null) {
      paramJceOutputStream.write(this.wMJ, 1);
    }
    if (this.egI != null) {
      paramJceOutputStream.write(this.egI, 2);
    }
    if (this.model != null) {
      paramJceOutputStream.write(this.model, 3);
    }
    if (this.wMK != 0) {
      paramJceOutputStream.write(this.wMK, 4);
    }
    if (this.wML != null) {
      paramJceOutputStream.write(this.wML, 5);
    }
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 6);
    }
    if (this.root != 0) {
      paramJceOutputStream.write(this.root, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.c.b.d
 * JD-Core Version:    0.7.0.1
 */