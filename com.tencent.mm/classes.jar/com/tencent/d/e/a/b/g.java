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
  static Map<Integer, ArrayList<f>> Mle;
  public int MkI = 0;
  public int MkJ = 0;
  public int MkK = 0;
  public int MkL = 0;
  public long Mlb = 0L;
  public Map<Integer, ArrayList<f>> Mlc = null;
  public int Mld = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138428);
    this.Mlb = paramJceInputStream.read(this.Mlb, 0, true);
    if (Mle == null)
    {
      Mle = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new f());
      Mle.put(Integer.valueOf(0), localArrayList);
    }
    this.Mlc = ((Map)paramJceInputStream.read(Mle, 1, true));
    this.MkI = paramJceInputStream.read(this.MkI, 2, false);
    this.MkJ = paramJceInputStream.read(this.MkJ, 3, false);
    this.MkK = paramJceInputStream.read(this.MkK, 4, false);
    this.MkL = paramJceInputStream.read(this.MkL, 5, false);
    this.Mld = paramJceInputStream.read(this.Mld, 6, false);
    AppMethodBeat.o(138428);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138427);
    paramJceOutputStream.write(this.Mlb, 0);
    paramJceOutputStream.write(this.Mlc, 1);
    paramJceOutputStream.write(this.MkI, 2);
    paramJceOutputStream.write(this.MkJ, 3);
    paramJceOutputStream.write(this.MkK, 4);
    paramJceOutputStream.write(this.MkL, 5);
    if (this.Mld != 0) {
      paramJceOutputStream.write(this.Mld, 6);
    }
    AppMethodBeat.o(138427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.g
 * JD-Core Version:    0.7.0.1
 */