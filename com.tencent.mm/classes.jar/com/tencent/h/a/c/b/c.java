package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class c
  extends JceStruct
{
  static ArrayList<g> ZTJ;
  static int ZTK;
  static int ZTL;
  public ArrayList<g> ZTI = null;
  public int ZpO = 0;
  public int ZpP = 0;
  public long Zqh = 0L;
  
  static
  {
    AppMethodBeat.i(207478);
    ZTJ = new ArrayList();
    g localg = new g();
    ZTJ.add(localg);
    ZTK = 0;
    ZTL = 0;
    AppMethodBeat.o(207478);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207477);
    this.Zqh = paramJceInputStream.read(this.Zqh, 0, true);
    this.ZTI = ((ArrayList)paramJceInputStream.read(ZTJ, 1, true));
    this.ZpO = paramJceInputStream.read(this.ZpO, 2, false);
    this.ZpP = paramJceInputStream.read(this.ZpP, 3, false);
    AppMethodBeat.o(207477);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207475);
    paramJceOutputStream.write(this.Zqh, 0);
    paramJceOutputStream.write(this.ZTI, 1);
    paramJceOutputStream.write(this.ZpO, 2);
    paramJceOutputStream.write(this.ZpP, 3);
    AppMethodBeat.o(207475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.b.c
 * JD-Core Version:    0.7.0.1
 */