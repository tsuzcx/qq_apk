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
  static Map<Integer, ArrayList<f>> Zqk;
  public int ZpO = 0;
  public int ZpP = 0;
  public int ZpQ = 0;
  public int ZpR = 0;
  public long Zqh = 0L;
  public Map<Integer, ArrayList<f>> Zqi = null;
  public int Zqj = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138428);
    this.Zqh = paramJceInputStream.read(this.Zqh, 0, true);
    if (Zqk == null)
    {
      Zqk = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new f());
      Zqk.put(Integer.valueOf(0), localArrayList);
    }
    this.Zqi = ((Map)paramJceInputStream.read(Zqk, 1, true));
    this.ZpO = paramJceInputStream.read(this.ZpO, 2, false);
    this.ZpP = paramJceInputStream.read(this.ZpP, 3, false);
    this.ZpQ = paramJceInputStream.read(this.ZpQ, 4, false);
    this.ZpR = paramJceInputStream.read(this.ZpR, 5, false);
    this.Zqj = paramJceInputStream.read(this.Zqj, 6, false);
    AppMethodBeat.o(138428);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138427);
    paramJceOutputStream.write(this.Zqh, 0);
    paramJceOutputStream.write(this.Zqi, 1);
    paramJceOutputStream.write(this.ZpO, 2);
    paramJceOutputStream.write(this.ZpP, 3);
    paramJceOutputStream.write(this.ZpQ, 4);
    paramJceOutputStream.write(this.ZpR, 5);
    if (this.Zqj != 0) {
      paramJceOutputStream.write(this.Zqj, 6);
    }
    AppMethodBeat.o(138427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.g
 * JD-Core Version:    0.7.0.1
 */