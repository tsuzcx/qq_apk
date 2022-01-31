package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class g
  extends JceStruct
{
  static Map<Integer, ArrayList<f>> BlB;
  public int BlA = 0;
  public int Blf = 0;
  public int Blg = 0;
  public int Blh = 0;
  public int Bli = 0;
  public long Bly = 0L;
  public Map<Integer, ArrayList<f>> Blz = null;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114587);
    this.Bly = paramJceInputStream.read(this.Bly, 0, true);
    if (BlB == null)
    {
      BlB = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new f());
      BlB.put(Integer.valueOf(0), localArrayList);
    }
    this.Blz = ((Map)paramJceInputStream.read(BlB, 1, true));
    this.Blf = paramJceInputStream.read(this.Blf, 2, false);
    this.Blg = paramJceInputStream.read(this.Blg, 3, false);
    this.Blh = paramJceInputStream.read(this.Blh, 4, false);
    this.Bli = paramJceInputStream.read(this.Bli, 5, false);
    this.BlA = paramJceInputStream.read(this.BlA, 6, false);
    AppMethodBeat.o(114587);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114586);
    paramJceOutputStream.write(this.Bly, 0);
    paramJceOutputStream.write(this.Blz, 1);
    paramJceOutputStream.write(this.Blf, 2);
    paramJceOutputStream.write(this.Blg, 3);
    paramJceOutputStream.write(this.Blh, 4);
    paramJceOutputStream.write(this.Bli, 5);
    if (this.BlA != 0) {
      paramJceOutputStream.write(this.BlA, 6);
    }
    AppMethodBeat.o(114586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.b.g
 * JD-Core Version:    0.7.0.1
 */