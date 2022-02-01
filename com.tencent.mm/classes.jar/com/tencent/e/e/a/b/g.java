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
  static Map<Integer, ArrayList<f>> RNE;
  public long RNB = 0L;
  public Map<Integer, ArrayList<f>> RNC = null;
  public int RND = 0;
  public int RNi = 0;
  public int RNj = 0;
  public int RNk = 0;
  public int RNl = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138428);
    this.RNB = paramJceInputStream.read(this.RNB, 0, true);
    if (RNE == null)
    {
      RNE = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new f());
      RNE.put(Integer.valueOf(0), localArrayList);
    }
    this.RNC = ((Map)paramJceInputStream.read(RNE, 1, true));
    this.RNi = paramJceInputStream.read(this.RNi, 2, false);
    this.RNj = paramJceInputStream.read(this.RNj, 3, false);
    this.RNk = paramJceInputStream.read(this.RNk, 4, false);
    this.RNl = paramJceInputStream.read(this.RNl, 5, false);
    this.RND = paramJceInputStream.read(this.RND, 6, false);
    AppMethodBeat.o(138428);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138427);
    paramJceOutputStream.write(this.RNB, 0);
    paramJceOutputStream.write(this.RNC, 1);
    paramJceOutputStream.write(this.RNi, 2);
    paramJceOutputStream.write(this.RNj, 3);
    paramJceOutputStream.write(this.RNk, 4);
    paramJceOutputStream.write(this.RNl, 5);
    if (this.RND != 0) {
      paramJceOutputStream.write(this.RND, 6);
    }
    AppMethodBeat.o(138427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.a.b.g
 * JD-Core Version:    0.7.0.1
 */