package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static d IqA;
  static c Iqy;
  static ArrayList<b> Iqz;
  public c Iqv = null;
  public ArrayList<b> Iqw = null;
  public d Iqx = null;
  
  static
  {
    AppMethodBeat.i(138331);
    Iqy = new c();
    Iqz = new ArrayList();
    b localb = new b();
    Iqz.add(localb);
    IqA = new d();
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
    this.Iqv = ((c)paramJceInputStream.read(Iqy, 0, false));
    this.Iqw = ((ArrayList)paramJceInputStream.read(Iqz, 1, false));
    this.Iqx = ((d)paramJceInputStream.read(IqA, 2, false));
    AppMethodBeat.o(138330);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138329);
    if (this.Iqv != null) {
      paramJceOutputStream.write(this.Iqv, 0);
    }
    if (this.Iqw != null) {
      paramJceOutputStream.write(this.Iqw, 1);
    }
    if (this.Iqx != null) {
      paramJceOutputStream.write(this.Iqx, 2);
    }
    AppMethodBeat.o(138329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.c.b.a
 * JD-Core Version:    0.7.0.1
 */