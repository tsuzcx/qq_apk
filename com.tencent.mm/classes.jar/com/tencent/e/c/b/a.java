package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static c ahsO;
  static ArrayList<b> ahsP;
  static d ahsQ;
  public c ahsL = null;
  public ArrayList<b> ahsM = null;
  public d ahsN = null;
  
  static
  {
    AppMethodBeat.i(138331);
    ahsO = new c();
    ahsP = new ArrayList();
    b localb = new b();
    ahsP.add(localb);
    ahsQ = new d();
    AppMethodBeat.o(138331);
  }
  
  public final JceStruct newInit()
  {
    AppMethodBeat.i(138328);
    a locala = new a();
    AppMethodBeat.o(138328);
    return locala;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138330);
    this.ahsL = ((c)paramJceInputStream.read(ahsO, 0, false));
    this.ahsM = ((ArrayList)paramJceInputStream.read(ahsP, 1, false));
    this.ahsN = ((d)paramJceInputStream.read(ahsQ, 2, false));
    AppMethodBeat.o(138330);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138329);
    if (this.ahsL != null) {
      paramJceOutputStream.write(this.ahsL, 0);
    }
    if (this.ahsM != null) {
      paramJceOutputStream.write(this.ahsM, 1);
    }
    if (this.ahsN != null) {
      paramJceOutputStream.write(this.ahsN, 2);
    }
    AppMethodBeat.o(138329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.c.b.a
 * JD-Core Version:    0.7.0.1
 */