package com.tencent.h.a.b.a;

import android.content.Context;
import com.tencent.g.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import e.d;
import java.util.ArrayList;

public class b
{
  private static b ahXl;
  private com.tencent.g.a.a.a ahXm;
  
  private b()
  {
    AppMethodBeat.i(212130);
    this.ahXm = new com.tencent.g.a.a.a();
    AppMethodBeat.o(212130);
  }
  
  public static b kdp()
  {
    AppMethodBeat.i(212140);
    if (ahXl == null) {}
    try
    {
      if (ahXl == null) {
        ahXl = new b();
      }
      b localb = ahXl;
      AppMethodBeat.o(212140);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(212140);
    }
  }
  
  public static int kdq()
  {
    return 5;
  }
  
  public final a a(com.tencent.h.a.a.c paramc, ArrayList<d> paramArrayList, ArrayList<String> paramArrayList1)
  {
    a locala = null;
    AppMethodBeat.i(212161);
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(212161);
      return null;
    }
    Object localObject = paramc.mAppContext;
    if ((localObject == null) || (paramArrayList.isEmpty())) {}
    a.b localb;
    for (paramc = null;; paramc = com.tencent.g.a.a.a.a(localb, paramc))
    {
      if (paramc != null)
      {
        locala = new a();
        locala.ahXj = paramc;
        locala.ahXk = new ArrayList(paramArrayList1);
      }
      paramArrayList1.clear();
      paramArrayList.clear();
      AppMethodBeat.o(212161);
      return locala;
      paramc = com.tencent.g.a.a.a.cm(paramArrayList);
      localObject = "V_301096_3_C_" + com.tencent.g.c.c.getAppVersionName((Context)localObject) + "_" + com.tencent.g.c.c.getAppVersionCode((Context)localObject);
      localb = new a.b();
      localb.xOk = "com.tencent.turingsmi";
      localb.ahVP = ((String)localObject);
      localb.ahVQ = "1.0.2";
      localb.ahVR = "3";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */