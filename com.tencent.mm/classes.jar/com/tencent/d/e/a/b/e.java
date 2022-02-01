package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e
  extends JceStruct
{
  static ArrayList<g> LOa;
  public long LNX = 0L;
  public ArrayList<g> LNY = null;
  public double LNZ = 0.0D;
  public int LNa = 0;
  public int action = 0;
  public double lat = 0.0D;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138424);
    this.LNX = paramJceInputStream.read(this.LNX, 0, true);
    if (LOa == null)
    {
      LOa = new ArrayList();
      g localg = new g();
      LOa.add(localg);
    }
    this.LNY = ((ArrayList)paramJceInputStream.read(LOa, 1, true));
    this.LNa = paramJceInputStream.read(this.LNa, 2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.lat = paramJceInputStream.read(this.lat, 4, false);
    this.LNZ = paramJceInputStream.read(this.LNZ, 5, false);
    AppMethodBeat.o(138424);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138423);
    paramJceOutputStream.write(this.LNX, 0);
    paramJceOutputStream.write(this.LNY, 1);
    if (this.LNa != 0) {
      paramJceOutputStream.write(this.LNa, 2);
    }
    if (this.action != 0) {
      paramJceOutputStream.write(this.action, 3);
    }
    if (this.lat != 0.0D) {
      paramJceOutputStream.write(this.lat, 4);
    }
    if (this.LNZ != 0.0D) {
      paramJceOutputStream.write(this.LNZ, 5);
    }
    AppMethodBeat.o(138423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.e
 * JD-Core Version:    0.7.0.1
 */