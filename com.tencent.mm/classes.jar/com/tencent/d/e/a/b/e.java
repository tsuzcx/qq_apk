package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e
  extends JceStruct
{
  static ArrayList<g> IsA;
  public int Irz = 0;
  public long Isx = 0L;
  public ArrayList<g> Isy = null;
  public double Isz = 0.0D;
  public int action = 0;
  public double lat = 0.0D;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138424);
    this.Isx = paramJceInputStream.read(this.Isx, 0, true);
    if (IsA == null)
    {
      IsA = new ArrayList();
      g localg = new g();
      IsA.add(localg);
    }
    this.Isy = ((ArrayList)paramJceInputStream.read(IsA, 1, true));
    this.Irz = paramJceInputStream.read(this.Irz, 2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.lat = paramJceInputStream.read(this.lat, 4, false);
    this.Isz = paramJceInputStream.read(this.Isz, 5, false);
    AppMethodBeat.o(138424);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138423);
    paramJceOutputStream.write(this.Isx, 0);
    paramJceOutputStream.write(this.Isy, 1);
    if (this.Irz != 0) {
      paramJceOutputStream.write(this.Irz, 2);
    }
    if (this.action != 0) {
      paramJceOutputStream.write(this.action, 3);
    }
    if (this.lat != 0.0D) {
      paramJceOutputStream.write(this.lat, 4);
    }
    if (this.Isz != 0.0D) {
      paramJceOutputStream.write(this.Isz, 5);
    }
    AppMethodBeat.o(138423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.e.a.b.e
 * JD-Core Version:    0.7.0.1
 */