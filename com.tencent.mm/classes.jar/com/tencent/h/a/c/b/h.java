package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class h
  extends JceStruct
{
  static ArrayList<Double> ahYt;
  public long ahuO = 0L;
  public ArrayList<Double> pUj = null;
  
  static
  {
    AppMethodBeat.i(212178);
    ahYt = new ArrayList();
    ahYt.add(Double.valueOf(0.0D));
    AppMethodBeat.o(212178);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(212191);
    this.ahuO = paramJceInputStream.read(this.ahuO, 0, true);
    this.pUj = ((ArrayList)paramJceInputStream.read(ahYt, 1, true));
    AppMethodBeat.o(212191);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(212184);
    paramJceOutputStream.write(this.ahuO, 0);
    paramJceOutputStream.write(this.pUj, 1);
    AppMethodBeat.o(212184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.b.h
 * JD-Core Version:    0.7.0.1
 */