package com.tencent.h.a.b.a;

import android.content.Context;
import com.tencent.g.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d;
import java.util.ArrayList;

public class b
{
  private static b ZSL;
  private com.tencent.g.a.a.a ZSM;
  
  private b()
  {
    AppMethodBeat.i(208774);
    this.ZSM = new com.tencent.g.a.a.a();
    AppMethodBeat.o(208774);
  }
  
  public static b itT()
  {
    AppMethodBeat.i(208775);
    if (ZSL == null) {}
    try
    {
      if (ZSL == null) {
        ZSL = new b();
      }
      b localb = ZSL;
      AppMethodBeat.o(208775);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(208775);
    }
  }
  
  public static int itU()
  {
    return 5;
  }
  
  public final a a(com.tencent.h.a.a.c paramc, ArrayList<d> paramArrayList, ArrayList<String> paramArrayList1)
  {
    a locala = null;
    AppMethodBeat.i(208776);
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(208776);
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
        locala.ZSJ = paramc;
        locala.ZSK = new ArrayList(paramArrayList1);
      }
      paramArrayList1.clear();
      paramArrayList.clear();
      AppMethodBeat.o(208776);
      return locala;
      paramc = com.tencent.g.a.a.a.bM(paramArrayList);
      localObject = "V_301096_2_C_" + com.tencent.g.c.c.getAppVersionName((Context)localObject) + "_" + com.tencent.g.c.c.getAppVersionCode((Context)localObject);
      localb = new a.b();
      localb.uFI = "com.tencent.turingsmi";
      localb.ZRu = ((String)localObject);
      localb.ZRv = "1.0.1";
      localb.mSdkVersion = "2";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */