package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e
  extends JceStruct
{
  static ArrayList<g> ahuM;
  public int action = 0;
  public int ahtO = 0;
  public long ahuJ = 0L;
  public ArrayList<g> ahuK = null;
  public double ahuL = 0.0D;
  public double lat = 0.0D;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138424);
    this.ahuJ = paramJceInputStream.read(this.ahuJ, 0, true);
    if (ahuM == null)
    {
      ahuM = new ArrayList();
      g localg = new g();
      ahuM.add(localg);
    }
    this.ahuK = ((ArrayList)paramJceInputStream.read(ahuM, 1, true));
    this.ahtO = paramJceInputStream.read(this.ahtO, 2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.lat = paramJceInputStream.read(this.lat, 4, false);
    this.ahuL = paramJceInputStream.read(this.ahuL, 5, false);
    AppMethodBeat.o(138424);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138423);
    paramJceOutputStream.write(this.ahuJ, 0);
    paramJceOutputStream.write(this.ahuK, 1);
    if (this.ahtO != 0) {
      paramJceOutputStream.write(this.ahtO, 2);
    }
    if (this.action != 0) {
      paramJceOutputStream.write(this.action, 3);
    }
    if (this.lat != 0.0D) {
      paramJceOutputStream.write(this.lat, 4);
    }
    if (this.ahuL != 0.0D) {
      paramJceOutputStream.write(this.ahuL, 5);
    }
    AppMethodBeat.o(138423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.b.e
 * JD-Core Version:    0.7.0.1
 */