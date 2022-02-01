package com.tencent.mm.plugin.appbrand.keylogger.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h
{
  public final d mPD;
  private List<h> mPE;
  public final String mPF;
  
  private h(d paramd, String paramString)
  {
    this.mPD = paramd;
    this.mPF = paramString;
  }
  
  public static void a(h paramh, b paramb)
  {
    AppMethodBeat.i(221327);
    if (paramh == null)
    {
      AppMethodBeat.o(221327);
      return;
    }
    if (paramb == null)
    {
      AppMethodBeat.o(221327);
      return;
    }
    paramb.a(paramh);
    paramh = paramh.mPE;
    if ((paramh == null) || (paramh.isEmpty()))
    {
      AppMethodBeat.o(221327);
      return;
    }
    int i = 0;
    while (i < paramh.size())
    {
      a((h)paramh.get(i), paramb);
      i += 1;
    }
    AppMethodBeat.o(221327);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(221329);
    if ((paramd.getType() == 3) || (paramd.getType() == 2))
    {
      AppMethodBeat.o(221329);
      return true;
    }
    AppMethodBeat.o(221329);
    return false;
  }
  
  private void b(h paramh)
  {
    AppMethodBeat.i(221326);
    if (!a(this.mPD))
    {
      Log.e("StepNode", "addChild but not a node group");
      AppMethodBeat.o(221326);
      return;
    }
    if (this.mPE == null) {
      this.mPE = new ArrayList();
    }
    this.mPE.add(paramh);
    AppMethodBeat.o(221326);
  }
  
  public static h f(List<d> paramList, String paramString)
  {
    AppMethodBeat.i(221328);
    h localh1 = new h(new a(), "");
    localh1.b(new h((d)paramList.get(0), ""));
    HashMap localHashMap = new HashMap();
    int i = 1;
    if (i < paramList.size() - 1)
    {
      d locald = (d)paramList.get(i);
      int j = locald.bMZ();
      if (j <= 0)
      {
        j = locald.bMY();
        localObject = new h(locald, "");
        localh1.b((h)localObject);
        localHashMap.put(Integer.valueOf(j), localObject);
      }
      h localh2;
      for (;;)
      {
        i += 1;
        break;
        localh2 = (h)localHashMap.get(Integer.valueOf(j));
        if ((localh2 != null) && ((Util.isNullOrNil(locald.category())) || (Util.isNullOrNil(paramString)) || (paramString.equals(locald.category()))))
        {
          if (a(localh2.mPD)) {
            break label250;
          }
          Log.e("StepNode", "addChild but not a node group");
          localObject = null;
          label219:
          if (!a(locald)) {
            break label368;
          }
          localHashMap.put(Integer.valueOf(locald.bMY()), localObject);
        }
      }
      label250:
      if (localh2.mPE == null) {
        localh2.mPE = new ArrayList();
      }
      if (localh2.mPD.getType() == 3)
      {
        localObject = "-";
        label288:
        if (Util.isNullOrNil(localh2.mPF)) {
          break label377;
        }
      }
      label368:
      label377:
      for (Object localObject = String.format("%s%s%d", new Object[] { localh2.mPF, localObject, Integer.valueOf(localh2.mPE.size() + 1) });; localObject = String.format("%d", new Object[] { Integer.valueOf(localh2.mPE.size() + 1) }))
      {
        localObject = new h(locald, (String)localObject);
        localh2.mPE.add(localObject);
        break label219;
        break;
        localObject = ".";
        break label288;
      }
    }
    localh1.b(new h((d)paramList.get(paramList.size() - 1), ""));
    AppMethodBeat.o(221328);
    return localh1;
  }
  
  public final List<h> bNa()
  {
    return this.mPE;
  }
  
  public final a bNb()
  {
    if ((this.mPD instanceof a)) {
      return (a)this.mPD;
    }
    return null;
  }
  
  static final class a
    extends g
  {}
  
  public static abstract interface b
  {
    public abstract void a(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.h
 * JD-Core Version:    0.7.0.1
 */