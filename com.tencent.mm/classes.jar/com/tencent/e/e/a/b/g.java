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
  static Map<Integer, ArrayList<f>> ahuR;
  public long ahuO = 0L;
  public Map<Integer, ArrayList<f>> ahuP = null;
  public int ahuQ = 0;
  public int ahuw = 0;
  public int ahux = 0;
  public int ahuy = 0;
  public int ahuz = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138428);
    this.ahuO = paramJceInputStream.read(this.ahuO, 0, true);
    if (ahuR == null)
    {
      ahuR = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new f());
      ahuR.put(Integer.valueOf(0), localArrayList);
    }
    this.ahuP = ((Map)paramJceInputStream.read(ahuR, 1, true));
    this.ahuw = paramJceInputStream.read(this.ahuw, 2, false);
    this.ahux = paramJceInputStream.read(this.ahux, 3, false);
    this.ahuy = paramJceInputStream.read(this.ahuy, 4, false);
    this.ahuz = paramJceInputStream.read(this.ahuz, 5, false);
    this.ahuQ = paramJceInputStream.read(this.ahuQ, 6, false);
    AppMethodBeat.o(138428);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138427);
    paramJceOutputStream.write(this.ahuO, 0);
    paramJceOutputStream.write(this.ahuP, 1);
    paramJceOutputStream.write(this.ahuw, 2);
    paramJceOutputStream.write(this.ahux, 3);
    paramJceOutputStream.write(this.ahuy, 4);
    paramJceOutputStream.write(this.ahuz, 5);
    if (this.ahuQ != 0) {
      paramJceOutputStream.write(this.ahuQ, 6);
    }
    AppMethodBeat.o(138427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.b.g
 * JD-Core Version:    0.7.0.1
 */