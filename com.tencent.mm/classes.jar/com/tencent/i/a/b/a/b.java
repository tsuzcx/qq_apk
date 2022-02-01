package com.tencent.i.a.b.a;

import android.content.Context;
import com.tencent.h.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d;
import java.util.ArrayList;

public class b
{
  private static b Sri;
  private com.tencent.h.a.a.a Srj;
  
  private b()
  {
    AppMethodBeat.i(214700);
    this.Srj = new com.tencent.h.a.a.a();
    AppMethodBeat.o(214700);
  }
  
  public static a a(com.tencent.i.a.a.c paramc, ArrayList<d> paramArrayList, ArrayList<String> paramArrayList1)
  {
    a locala = null;
    AppMethodBeat.i(214702);
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(214702);
      return null;
    }
    Object localObject = paramc.mAppContext;
    if ((localObject == null) || (paramArrayList == null) || (paramArrayList.isEmpty())) {}
    a.b localb;
    for (paramc = null;; paramc = com.tencent.h.a.a.a.a(localb, paramc))
    {
      if (paramc != null)
      {
        locala = new a();
        locala.Srg = paramc;
        locala.Srh = new ArrayList(paramArrayList1);
      }
      paramArrayList1.clear();
      paramArrayList.clear();
      AppMethodBeat.o(214702);
      return locala;
      paramc = com.tencent.h.a.a.a.bB(paramArrayList);
      localObject = "V_301096_2_C_" + com.tencent.h.c.c.getAppVersionName((Context)localObject) + "_" + com.tencent.h.c.c.getAppVersionCode((Context)localObject);
      localb = new a.b();
      localb.rcD = "com.tencent.turingsmi";
      localb.SpP = ((String)localObject);
      localb.SpQ = "1.0.1";
      localb.mSdkVersion = "2";
    }
  }
  
  public static b hqm()
  {
    AppMethodBeat.i(214701);
    if (Sri == null) {}
    try
    {
      if (Sri == null) {
        Sri = new b();
      }
      b localb = Sri;
      AppMethodBeat.o(214701);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(214701);
    }
  }
  
  public static int hqn()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */