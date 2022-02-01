package com.tencent.d.e.a.b;

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
  static Map<Integer, ArrayList<f>> IsF;
  public long IsC = 0L;
  public Map<Integer, ArrayList<f>> IsD = null;
  public int IsE = 0;
  public int Isj = 0;
  public int Isk = 0;
  public int Isl = 0;
  public int Ism = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138428);
    this.IsC = paramJceInputStream.read(this.IsC, 0, true);
    if (IsF == null)
    {
      IsF = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new f());
      IsF.put(Integer.valueOf(0), localArrayList);
    }
    this.IsD = ((Map)paramJceInputStream.read(IsF, 1, true));
    this.Isj = paramJceInputStream.read(this.Isj, 2, false);
    this.Isk = paramJceInputStream.read(this.Isk, 3, false);
    this.Isl = paramJceInputStream.read(this.Isl, 4, false);
    this.Ism = paramJceInputStream.read(this.Ism, 5, false);
    this.IsE = paramJceInputStream.read(this.IsE, 6, false);
    AppMethodBeat.o(138428);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138427);
    paramJceOutputStream.write(this.IsC, 0);
    paramJceOutputStream.write(this.IsD, 1);
    paramJceOutputStream.write(this.Isj, 2);
    paramJceOutputStream.write(this.Isk, 3);
    paramJceOutputStream.write(this.Isl, 4);
    paramJceOutputStream.write(this.Ism, 5);
    if (this.IsE != 0) {
      paramJceOutputStream.write(this.IsE, 6);
    }
    AppMethodBeat.o(138427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.e.a.b.g
 * JD-Core Version:    0.7.0.1
 */