package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e
  extends JceStruct
{
  static ArrayList<g> RNz;
  public int RMA = 0;
  public long RNw = 0L;
  public ArrayList<g> RNx = null;
  public double RNy = 0.0D;
  public int action = 0;
  public double lat = 0.0D;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138424);
    this.RNw = paramJceInputStream.read(this.RNw, 0, true);
    if (RNz == null)
    {
      RNz = new ArrayList();
      g localg = new g();
      RNz.add(localg);
    }
    this.RNx = ((ArrayList)paramJceInputStream.read(RNz, 1, true));
    this.RMA = paramJceInputStream.read(this.RMA, 2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.lat = paramJceInputStream.read(this.lat, 4, false);
    this.RNy = paramJceInputStream.read(this.RNy, 5, false);
    AppMethodBeat.o(138424);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138423);
    paramJceOutputStream.write(this.RNw, 0);
    paramJceOutputStream.write(this.RNx, 1);
    if (this.RMA != 0) {
      paramJceOutputStream.write(this.RMA, 2);
    }
    if (this.action != 0) {
      paramJceOutputStream.write(this.action, 3);
    }
    if (this.lat != 0.0D) {
      paramJceOutputStream.write(this.lat, 4);
    }
    if (this.RNy != 0.0D) {
      paramJceOutputStream.write(this.RNy, 5);
    }
    AppMethodBeat.o(138423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.a.b.e
 * JD-Core Version:    0.7.0.1
 */