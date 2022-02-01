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
  static Map<Integer, ArrayList<f>> LOf;
  public int LNJ = 0;
  public int LNK = 0;
  public int LNL = 0;
  public int LNM = 0;
  public long LOc = 0L;
  public Map<Integer, ArrayList<f>> LOd = null;
  public int LOe = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138428);
    this.LOc = paramJceInputStream.read(this.LOc, 0, true);
    if (LOf == null)
    {
      LOf = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new f());
      LOf.put(Integer.valueOf(0), localArrayList);
    }
    this.LOd = ((Map)paramJceInputStream.read(LOf, 1, true));
    this.LNJ = paramJceInputStream.read(this.LNJ, 2, false);
    this.LNK = paramJceInputStream.read(this.LNK, 3, false);
    this.LNL = paramJceInputStream.read(this.LNL, 4, false);
    this.LNM = paramJceInputStream.read(this.LNM, 5, false);
    this.LOe = paramJceInputStream.read(this.LOe, 6, false);
    AppMethodBeat.o(138428);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138427);
    paramJceOutputStream.write(this.LOc, 0);
    paramJceOutputStream.write(this.LOd, 1);
    paramJceOutputStream.write(this.LNJ, 2);
    paramJceOutputStream.write(this.LNK, 3);
    paramJceOutputStream.write(this.LNL, 4);
    paramJceOutputStream.write(this.LNM, 5);
    if (this.LOe != 0) {
      paramJceOutputStream.write(this.LOe, 6);
    }
    AppMethodBeat.o(138427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.g
 * JD-Core Version:    0.7.0.1
 */