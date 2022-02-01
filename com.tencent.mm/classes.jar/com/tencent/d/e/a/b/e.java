package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e
  extends JceStruct
{
  static ArrayList<g> Zqf;
  public int Zpg = 0;
  public long Zqc = 0L;
  public ArrayList<g> Zqd = null;
  public double Zqe = 0.0D;
  public int action = 0;
  public double lat = 0.0D;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138424);
    this.Zqc = paramJceInputStream.read(this.Zqc, 0, true);
    if (Zqf == null)
    {
      Zqf = new ArrayList();
      g localg = new g();
      Zqf.add(localg);
    }
    this.Zqd = ((ArrayList)paramJceInputStream.read(Zqf, 1, true));
    this.Zpg = paramJceInputStream.read(this.Zpg, 2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.lat = paramJceInputStream.read(this.lat, 4, false);
    this.Zqe = paramJceInputStream.read(this.Zqe, 5, false);
    AppMethodBeat.o(138424);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138423);
    paramJceOutputStream.write(this.Zqc, 0);
    paramJceOutputStream.write(this.Zqd, 1);
    if (this.Zpg != 0) {
      paramJceOutputStream.write(this.Zpg, 2);
    }
    if (this.action != 0) {
      paramJceOutputStream.write(this.action, 3);
    }
    if (this.lat != 0.0D) {
      paramJceOutputStream.write(this.lat, 4);
    }
    if (this.Zqe != 0.0D) {
      paramJceOutputStream.write(this.Zqe, 5);
    }
    AppMethodBeat.o(138423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.b.e
 * JD-Core Version:    0.7.0.1
 */