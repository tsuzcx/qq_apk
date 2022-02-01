package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static c JSi;
  static ArrayList<b> JSj;
  static d JSk;
  public c JSf = null;
  public ArrayList<b> JSg = null;
  public d JSh = null;
  
  static
  {
    AppMethodBeat.i(138331);
    JSi = new c();
    JSj = new ArrayList();
    b localb = new b();
    JSj.add(localb);
    JSk = new d();
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
    this.JSf = ((c)paramJceInputStream.read(JSi, 0, false));
    this.JSg = ((ArrayList)paramJceInputStream.read(JSj, 1, false));
    this.JSh = ((d)paramJceInputStream.read(JSk, 2, false));
    AppMethodBeat.o(138330);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138329);
    if (this.JSf != null) {
      paramJceOutputStream.write(this.JSf, 0);
    }
    if (this.JSg != null) {
      paramJceOutputStream.write(this.JSg, 1);
    }
    if (this.JSh != null) {
      paramJceOutputStream.write(this.JSh, 2);
    }
    AppMethodBeat.o(138329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.a
 * JD-Core Version:    0.7.0.1
 */