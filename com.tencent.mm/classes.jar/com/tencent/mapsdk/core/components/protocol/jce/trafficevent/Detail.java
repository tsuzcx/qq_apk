package com.tencent.mapsdk.core.components.protocol.jce.trafficevent;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class Detail
  extends MapJceStruct
{
  static Basic a;
  static ArrayList<Float> b;
  public Basic basic = null;
  public ArrayList<Float> coord = null;
  
  static
  {
    AppMethodBeat.i(221254);
    a = new Basic();
    b = new ArrayList();
    b.add(Float.valueOf(0.0F));
    AppMethodBeat.o(221254);
  }
  
  public Detail() {}
  
  public Detail(Basic paramBasic, ArrayList<Float> paramArrayList)
  {
    this.basic = paramBasic;
    this.coord = paramArrayList;
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221268);
    this.basic = ((Basic)paramm.a(a, 0, true));
    this.coord = ((ArrayList)paramm.a(b, 1, false));
    AppMethodBeat.o(221268);
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221262);
    paramn.a(this.basic, 0);
    if (this.coord != null) {
      paramn.a(this.coord, 1);
    }
    AppMethodBeat.o(221262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail
 * JD-Core Version:    0.7.0.1
 */