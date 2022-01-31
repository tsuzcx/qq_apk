package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static c wLX = new c();
  static ArrayList<b> wLY = new ArrayList();
  static d wLZ = new d();
  public c wLU = null;
  public ArrayList<b> wLV = null;
  public d wLW = null;
  
  static
  {
    b localb = new b();
    wLY.add(localb);
  }
  
  public final JceStruct newInit()
  {
    return new a();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wLU = ((c)paramJceInputStream.read(wLX, 0, false));
    this.wLV = ((ArrayList)paramJceInputStream.read(wLY, 1, false));
    this.wLW = ((d)paramJceInputStream.read(wLZ, 2, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.wLU != null) {
      paramJceOutputStream.write(this.wLU, 0);
    }
    if (this.wLV != null) {
      paramJceOutputStream.write(this.wLV, 1);
    }
    if (this.wLW != null) {
      paramJceOutputStream.write(this.wLW, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.d.c.b.a
 * JD-Core Version:    0.7.0.1
 */