package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static ArrayList<b> RLA;
  static d RLB;
  static c RLz;
  public c RLw = null;
  public ArrayList<b> RLx = null;
  public d RLy = null;
  
  static
  {
    AppMethodBeat.i(138331);
    RLz = new c();
    RLA = new ArrayList();
    b localb = new b();
    RLA.add(localb);
    RLB = new d();
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
    this.RLw = ((c)paramJceInputStream.read(RLz, 0, false));
    this.RLx = ((ArrayList)paramJceInputStream.read(RLA, 1, false));
    this.RLy = ((d)paramJceInputStream.read(RLB, 2, false));
    AppMethodBeat.o(138330);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138329);
    if (this.RLw != null) {
      paramJceOutputStream.write(this.RLw, 0);
    }
    if (this.RLx != null) {
      paramJceOutputStream.write(this.RLx, 1);
    }
    if (this.RLy != null) {
      paramJceOutputStream.write(this.RLy, 2);
    }
    AppMethodBeat.o(138329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.c.b.a
 * JD-Core Version:    0.7.0.1
 */