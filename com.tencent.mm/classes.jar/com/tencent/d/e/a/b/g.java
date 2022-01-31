package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class g
  extends JceStruct
{
  static Map<Integer, ArrayList<f>> wOd;
  public int wNG = 0;
  public int wNH = 0;
  public int wNI = 0;
  public int wNJ = 0;
  public long wOa = 0L;
  public Map<Integer, ArrayList<f>> wOb = null;
  public int wOc = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.wOa = paramJceInputStream.read(this.wOa, 0, true);
    if (wOd == null)
    {
      wOd = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new f());
      wOd.put(Integer.valueOf(0), localArrayList);
    }
    this.wOb = ((Map)paramJceInputStream.read(wOd, 1, true));
    this.wNG = paramJceInputStream.read(this.wNG, 2, false);
    this.wNH = paramJceInputStream.read(this.wNH, 3, false);
    this.wNI = paramJceInputStream.read(this.wNI, 4, false);
    this.wNJ = paramJceInputStream.read(this.wNJ, 5, false);
    this.wOc = paramJceInputStream.read(this.wOc, 6, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wOa, 0);
    paramJceOutputStream.write(this.wOb, 1);
    paramJceOutputStream.write(this.wNG, 2);
    paramJceOutputStream.write(this.wNH, 3);
    paramJceOutputStream.write(this.wNI, 4);
    paramJceOutputStream.write(this.wNJ, 5);
    if (this.wOc != 0) {
      paramJceOutputStream.write(this.wOc, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.e.a.b.g
 * JD-Core Version:    0.7.0.1
 */