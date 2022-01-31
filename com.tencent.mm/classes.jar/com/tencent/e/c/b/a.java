package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static c Bjv;
  static ArrayList<b> Bjw;
  static d Bjx;
  public c Bjs = null;
  public ArrayList<b> Bjt = null;
  public d Bju = null;
  
  static
  {
    AppMethodBeat.i(114490);
    Bjv = new c();
    Bjw = new ArrayList();
    b localb = new b();
    Bjw.add(localb);
    Bjx = new d();
    AppMethodBeat.o(114490);
  }
  
  public final JceStruct newInit()
  {
    AppMethodBeat.i(114487);
    a locala = new a();
    AppMethodBeat.o(114487);
    return locala;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114489);
    this.Bjs = ((c)paramJceInputStream.read(Bjv, 0, false));
    this.Bjt = ((ArrayList)paramJceInputStream.read(Bjw, 1, false));
    this.Bju = ((d)paramJceInputStream.read(Bjx, 2, false));
    AppMethodBeat.o(114489);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114488);
    if (this.Bjs != null) {
      paramJceOutputStream.write(this.Bjs, 0);
    }
    if (this.Bjt != null) {
      paramJceOutputStream.write(this.Bjt, 1);
    }
    if (this.Bju != null) {
      paramJceOutputStream.write(this.Bju, 2);
    }
    AppMethodBeat.o(114488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.c.b.a
 * JD-Core Version:    0.7.0.1
 */