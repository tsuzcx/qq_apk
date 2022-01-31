package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e
  extends JceStruct
{
  static ArrayList<g> Blw;
  public int Bkw = 0;
  public long Blt = 0L;
  public ArrayList<g> Blu = null;
  public double Blv = 0.0D;
  public int action = 0;
  public double lat = 0.0D;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114583);
    this.Blt = paramJceInputStream.read(this.Blt, 0, true);
    if (Blw == null)
    {
      Blw = new ArrayList();
      g localg = new g();
      Blw.add(localg);
    }
    this.Blu = ((ArrayList)paramJceInputStream.read(Blw, 1, true));
    this.Bkw = paramJceInputStream.read(this.Bkw, 2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.lat = paramJceInputStream.read(this.lat, 4, false);
    this.Blv = paramJceInputStream.read(this.Blv, 5, false);
    AppMethodBeat.o(114583);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114582);
    paramJceOutputStream.write(this.Blt, 0);
    paramJceOutputStream.write(this.Blu, 1);
    if (this.Bkw != 0) {
      paramJceOutputStream.write(this.Bkw, 2);
    }
    if (this.action != 0) {
      paramJceOutputStream.write(this.action, 3);
    }
    if (this.lat != 0.0D) {
      paramJceOutputStream.write(this.lat, 4);
    }
    if (this.Blv != 0.0D) {
      paramJceOutputStream.write(this.Blv, 5);
    }
    AppMethodBeat.o(114582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.e.e.a.b.e
 * JD-Core Version:    0.7.0.1
 */