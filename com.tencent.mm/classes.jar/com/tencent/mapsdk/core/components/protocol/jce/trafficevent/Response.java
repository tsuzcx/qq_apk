package com.tencent.mapsdk.core.components.protocol.jce.trafficevent;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class Response
  extends MapJceStruct
{
  static ArrayList<Detail> a;
  public ArrayList<Detail> detail = null;
  public short error = 0;
  public String msg = "";
  
  static
  {
    AppMethodBeat.i(221243);
    a = new ArrayList();
    Detail localDetail = new Detail();
    a.add(localDetail);
    AppMethodBeat.o(221243);
  }
  
  public Response() {}
  
  public Response(short paramShort, String paramString, ArrayList<Detail> paramArrayList)
  {
    this.error = paramShort;
    this.msg = paramString;
    this.detail = paramArrayList;
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221263);
    this.error = paramm.a(this.error, 0, true);
    this.msg = paramm.b(1, false);
    this.detail = ((ArrayList)paramm.a(a, 2, false));
    AppMethodBeat.o(221263);
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221251);
    paramn.a(this.error, 0);
    if (this.msg != null) {
      paramn.a(this.msg, 1);
    }
    if (this.detail != null) {
      paramn.a(this.detail, 2);
    }
    AppMethodBeat.o(221251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Response
 * JD-Core Version:    0.7.0.1
 */