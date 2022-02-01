package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class c
  extends JceStruct
{
  static ArrayList<g> ahYj;
  static int ahYk;
  static int ahYl;
  public ArrayList<g> ahYi = null;
  public long ahuO = 0L;
  public int ahuw = 0;
  public int ahux = 0;
  
  static
  {
    AppMethodBeat.i(212186);
    ahYj = new ArrayList();
    g localg = new g();
    ahYj.add(localg);
    ahYk = 0;
    ahYl = 0;
    AppMethodBeat.o(212186);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(212201);
    this.ahuO = paramJceInputStream.read(this.ahuO, 0, true);
    this.ahYi = ((ArrayList)paramJceInputStream.read(ahYj, 1, true));
    this.ahuw = paramJceInputStream.read(this.ahuw, 2, false);
    this.ahux = paramJceInputStream.read(this.ahux, 3, false);
    AppMethodBeat.o(212201);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(212193);
    paramJceOutputStream.write(this.ahuO, 0);
    paramJceOutputStream.write(this.ahYi, 1);
    paramJceOutputStream.write(this.ahuw, 2);
    paramJceOutputStream.write(this.ahux, 3);
    AppMethodBeat.o(212193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.b.c
 * JD-Core Version:    0.7.0.1
 */