package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e
  extends JceStruct
{
  static ArrayList<g> MkZ;
  public int MjZ = 0;
  public long MkW = 0L;
  public ArrayList<g> MkX = null;
  public double MkY = 0.0D;
  public int action = 0;
  public double lat = 0.0D;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138424);
    this.MkW = paramJceInputStream.read(this.MkW, 0, true);
    if (MkZ == null)
    {
      MkZ = new ArrayList();
      g localg = new g();
      MkZ.add(localg);
    }
    this.MkX = ((ArrayList)paramJceInputStream.read(MkZ, 1, true));
    this.MjZ = paramJceInputStream.read(this.MjZ, 2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.lat = paramJceInputStream.read(this.lat, 4, false);
    this.MkY = paramJceInputStream.read(this.MkY, 5, false);
    AppMethodBeat.o(138424);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138423);
    paramJceOutputStream.write(this.MkW, 0);
    paramJceOutputStream.write(this.MkX, 1);
    if (this.MjZ != 0) {
      paramJceOutputStream.write(this.MjZ, 2);
    }
    if (this.action != 0) {
      paramJceOutputStream.write(this.action, 3);
    }
    if (this.lat != 0.0D) {
      paramJceOutputStream.write(this.lat, 4);
    }
    if (this.MkY != 0.0D) {
      paramJceOutputStream.write(this.MkY, 5);
    }
    AppMethodBeat.o(138423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.e
 * JD-Core Version:    0.7.0.1
 */