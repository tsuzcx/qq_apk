package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class h
  extends JceStruct
{
  static ArrayList<Double> Ssq;
  public long RNB = 0L;
  public ArrayList<Double> kgc = null;
  
  static
  {
    AppMethodBeat.i(214767);
    Ssq = new ArrayList();
    Ssq.add(Double.valueOf(0.0D));
    AppMethodBeat.o(214767);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214766);
    this.RNB = paramJceInputStream.read(this.RNB, 0, true);
    this.kgc = ((ArrayList)paramJceInputStream.read(Ssq, 1, true));
    AppMethodBeat.o(214766);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214765);
    paramJceOutputStream.write(this.RNB, 0);
    paramJceOutputStream.write(this.kgc, 1);
    AppMethodBeat.o(214765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.b.h
 * JD-Core Version:    0.7.0.1
 */