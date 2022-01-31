package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class e
  extends JceStruct
{
  static ArrayList<g> wNY;
  public int action = 0;
  public double lat = 0.0D;
  public int wMX = 0;
  public long wNV = 0L;
  public ArrayList<g> wNW = null;
  public double wNX = 0.0D;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wNV = paramJceInputStream.read(this.wNV, 0, true);
    if (wNY == null)
    {
      wNY = new ArrayList();
      g localg = new g();
      wNY.add(localg);
    }
    this.wNW = ((ArrayList)paramJceInputStream.read(wNY, 1, true));
    this.wMX = paramJceInputStream.read(this.wMX, 2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.lat = paramJceInputStream.read(this.lat, 4, false);
    this.wNX = paramJceInputStream.read(this.wNX, 5, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wNV, 0);
    paramJceOutputStream.write(this.wNW, 1);
    if (this.wMX != 0) {
      paramJceOutputStream.write(this.wMX, 2);
    }
    if (this.action != 0) {
      paramJceOutputStream.write(this.action, 3);
    }
    if (this.lat != 0.0D) {
      paramJceOutputStream.write(this.lat, 4);
    }
    if (this.wNX != 0.0D) {
      paramJceOutputStream.write(this.wNX, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.d.e.a.b.e
 * JD-Core Version:    0.7.0.1
 */