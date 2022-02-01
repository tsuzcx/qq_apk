package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class c
  extends JceStruct
{
  static ArrayList<g> Sse;
  static int Ssf;
  static int Ssg;
  public long RNB = 0L;
  public int RNi = 0;
  public int RNj = 0;
  public ArrayList<g> Ssd = null;
  
  static
  {
    AppMethodBeat.i(214755);
    Sse = new ArrayList();
    g localg = new g();
    Sse.add(localg);
    Ssf = 0;
    Ssg = 0;
    AppMethodBeat.o(214755);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214754);
    this.RNB = paramJceInputStream.read(this.RNB, 0, true);
    this.Ssd = ((ArrayList)paramJceInputStream.read(Sse, 1, true));
    this.RNi = paramJceInputStream.read(this.RNi, 2, false);
    this.RNj = paramJceInputStream.read(this.RNj, 3, false);
    AppMethodBeat.o(214754);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214753);
    paramJceOutputStream.write(this.RNB, 0);
    paramJceOutputStream.write(this.Ssd, 1);
    paramJceOutputStream.write(this.RNi, 2);
    paramJceOutputStream.write(this.RNj, 3);
    AppMethodBeat.o(214753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.b.c
 * JD-Core Version:    0.7.0.1
 */