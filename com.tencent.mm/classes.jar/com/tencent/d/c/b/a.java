package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends JceStruct
{
  static c Zog;
  static ArrayList<b> Zoh;
  static d Zoi;
  public c Zod = null;
  public ArrayList<b> Zoe = null;
  public d Zof = null;
  
  static
  {
    AppMethodBeat.i(138331);
    Zog = new c();
    Zoh = new ArrayList();
    b localb = new b();
    Zoh.add(localb);
    Zoi = new d();
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
    this.Zod = ((c)paramJceInputStream.read(Zog, 0, false));
    this.Zoe = ((ArrayList)paramJceInputStream.read(Zoh, 1, false));
    this.Zof = ((d)paramJceInputStream.read(Zoi, 2, false));
    AppMethodBeat.o(138330);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138329);
    if (this.Zod != null) {
      paramJceOutputStream.write(this.Zod, 0);
    }
    if (this.Zoe != null) {
      paramJceOutputStream.write(this.Zoe, 1);
    }
    if (this.Zof != null) {
      paramJceOutputStream.write(this.Zof, 2);
    }
    AppMethodBeat.o(138329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.a
 * JD-Core Version:    0.7.0.1
 */