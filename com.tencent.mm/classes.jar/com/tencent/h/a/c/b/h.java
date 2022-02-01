package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class h
  extends JceStruct
{
  static ArrayList<Double> ZTT;
  public long Zqh = 0L;
  public ArrayList<Double> mXB = null;
  
  static
  {
    AppMethodBeat.i(208011);
    ZTT = new ArrayList();
    ZTT.add(Double.valueOf(0.0D));
    AppMethodBeat.o(208011);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(208008);
    this.Zqh = paramJceInputStream.read(this.Zqh, 0, true);
    this.mXB = ((ArrayList)paramJceInputStream.read(ZTT, 1, true));
    AppMethodBeat.o(208008);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(208007);
    paramJceOutputStream.write(this.Zqh, 0);
    paramJceOutputStream.write(this.mXB, 1);
    AppMethodBeat.o(208007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.b.h
 * JD-Core Version:    0.7.0.1
 */