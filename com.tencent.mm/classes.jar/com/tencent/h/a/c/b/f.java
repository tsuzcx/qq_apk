package com.tencent.h.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class f
  extends JceStruct
{
  static ArrayList<c> ZTT;
  static ArrayList<i> ZTU;
  static ArrayList<h> ZTV;
  static e ZTW;
  public long ZTP = 0L;
  public ArrayList<i> ZTQ = null;
  public ArrayList<h> ZTR = null;
  public e ZTS = null;
  public int Zqj = 0;
  public ArrayList<c> mXB = null;
  
  static
  {
    AppMethodBeat.i(208578);
    ZTT = new ArrayList();
    Object localObject = new c();
    ZTT.add(localObject);
    ZTU = new ArrayList();
    localObject = new i();
    ZTU.add(localObject);
    ZTV = new ArrayList();
    localObject = new h();
    ZTV.add(localObject);
    ZTW = new e();
    AppMethodBeat.o(208578);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(208576);
    this.ZTP = paramJceInputStream.read(this.ZTP, 0, true);
    this.mXB = ((ArrayList)paramJceInputStream.read(ZTT, 1, false));
    this.Zqj = paramJceInputStream.read(this.Zqj, 2, false);
    this.ZTQ = ((ArrayList)paramJceInputStream.read(ZTU, 3, false));
    this.ZTR = ((ArrayList)paramJceInputStream.read(ZTV, 4, false));
    this.ZTS = ((e)paramJceInputStream.read(ZTW, 5, false));
    AppMethodBeat.o(208576);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(208575);
    paramJceOutputStream.write(this.ZTP, 0);
    if (this.mXB != null) {
      paramJceOutputStream.write(this.mXB, 1);
    }
    paramJceOutputStream.write(this.Zqj, 2);
    if (this.ZTQ != null) {
      paramJceOutputStream.write(this.ZTQ, 3);
    }
    if (this.ZTR != null) {
      paramJceOutputStream.write(this.ZTR, 4);
    }
    if (this.ZTS != null) {
      paramJceOutputStream.write(this.ZTS, 5);
    }
    AppMethodBeat.o(208575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.b.f
 * JD-Core Version:    0.7.0.1
 */