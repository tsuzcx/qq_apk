package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static c LLZ;
  static ArrayList<b> LMa;
  static d LMb;
  public c LLW = null;
  public ArrayList<b> LLX = null;
  public d LLY = null;
  
  static
  {
    AppMethodBeat.i(138331);
    LLZ = new c();
    LMa = new ArrayList();
    b localb = new b();
    LMa.add(localb);
    LMb = new d();
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
    this.LLW = ((c)paramJceInputStream.read(LLZ, 0, false));
    this.LLX = ((ArrayList)paramJceInputStream.read(LMa, 1, false));
    this.LLY = ((d)paramJceInputStream.read(LMb, 2, false));
    AppMethodBeat.o(138330);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138329);
    if (this.LLW != null) {
      paramJceOutputStream.write(this.LLW, 0);
    }
    if (this.LLX != null) {
      paramJceOutputStream.write(this.LLX, 1);
    }
    if (this.LLY != null) {
      paramJceOutputStream.write(this.LLY, 2);
    }
    AppMethodBeat.o(138329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.a
 * JD-Core Version:    0.7.0.1
 */