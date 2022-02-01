package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class f
  extends JceStruct
{
  static ArrayList<c> ahYt;
  static ArrayList<i> ahYu;
  static ArrayList<h> ahYv;
  static e ahYw;
  public long ahYp = 0L;
  public ArrayList<i> ahYq = null;
  public ArrayList<h> ahYr = null;
  public e ahYs = null;
  public int ahuQ = 0;
  public ArrayList<c> pUj = null;
  
  static
  {
    AppMethodBeat.i(212182);
    ahYt = new ArrayList();
    Object localObject = new c();
    ahYt.add(localObject);
    ahYu = new ArrayList();
    localObject = new i();
    ahYu.add(localObject);
    ahYv = new ArrayList();
    localObject = new h();
    ahYv.add(localObject);
    ahYw = new e();
    AppMethodBeat.o(212182);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(212197);
    this.ahYp = paramJceInputStream.read(this.ahYp, 0, true);
    this.pUj = ((ArrayList)paramJceInputStream.read(ahYt, 1, false));
    this.ahuQ = paramJceInputStream.read(this.ahuQ, 2, false);
    this.ahYq = ((ArrayList)paramJceInputStream.read(ahYu, 3, false));
    this.ahYr = ((ArrayList)paramJceInputStream.read(ahYv, 4, false));
    this.ahYs = ((e)paramJceInputStream.read(ahYw, 5, false));
    AppMethodBeat.o(212197);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(212190);
    paramJceOutputStream.write(this.ahYp, 0);
    if (this.pUj != null) {
      paramJceOutputStream.write(this.pUj, 1);
    }
    paramJceOutputStream.write(this.ahuQ, 2);
    if (this.ahYq != null) {
      paramJceOutputStream.write(this.ahYq, 3);
    }
    if (this.ahYr != null) {
      paramJceOutputStream.write(this.ahYr, 4);
    }
    if (this.ahYs != null) {
      paramJceOutputStream.write(this.ahYs, 5);
    }
    AppMethodBeat.o(212190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.b.f
 * JD-Core Version:    0.7.0.1
 */