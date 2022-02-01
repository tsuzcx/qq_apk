package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static c MiY;
  static ArrayList<b> MiZ;
  static d Mja;
  public c MiV = null;
  public ArrayList<b> MiW = null;
  public d MiX = null;
  
  static
  {
    AppMethodBeat.i(138331);
    MiY = new c();
    MiZ = new ArrayList();
    b localb = new b();
    MiZ.add(localb);
    Mja = new d();
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
    this.MiV = ((c)paramJceInputStream.read(MiY, 0, false));
    this.MiW = ((ArrayList)paramJceInputStream.read(MiZ, 1, false));
    this.MiX = ((d)paramJceInputStream.read(Mja, 2, false));
    AppMethodBeat.o(138330);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138329);
    if (this.MiV != null) {
      paramJceOutputStream.write(this.MiV, 0);
    }
    if (this.MiW != null) {
      paramJceOutputStream.write(this.MiW, 1);
    }
    if (this.MiX != null) {
      paramJceOutputStream.write(this.MiX, 2);
    }
    AppMethodBeat.o(138329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.a
 * JD-Core Version:    0.7.0.1
 */