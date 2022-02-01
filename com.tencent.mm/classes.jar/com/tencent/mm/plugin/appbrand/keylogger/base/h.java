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
  public final d sUW;
  public List<h> sUX;
  public final String sUY;
  
  private h(d paramd, String paramString)
  {
    this.sUW = paramd;
    this.sUY = paramString;
  }
  
  public static void a(h paramh, b paramb)
  {
    AppMethodBeat.i(319526);
    if (paramh == null)
    {
      AppMethodBeat.o(319526);
      return;
    }
    if (paramb == null)
    {
      AppMethodBeat.o(319526);
      return;
    }
    paramb.a(paramh);
    paramh = paramh.sUX;
    if ((paramh == null) || (paramh.isEmpty()))
    {
      AppMethodBeat.o(319526);
      return;
    }
    int i = 0;
    while (i < paramh.size())
    {
      a((h)paramh.get(i), paramb);
      i += 1;
    }
    AppMethodBeat.o(319526);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(319543);
    if ((paramd.getType() == 3) || (paramd.getType() == 2))
    {
      AppMethodBeat.o(319543);
      return true;
    }
    AppMethodBeat.o(319543);
    return false;
  }
  
  private void b(h paramh)
  {
    AppMethodBeat.i(319522);
    if (!a(this.sUW))
    {
      Log.e("StepNode", "addChild but not a node group");
      AppMethodBeat.o(319522);
      return;
    }
    if (this.sUX == null) {
      this.sUX = new ArrayList();
    }
    this.sUX.add(paramh);
    AppMethodBeat.o(319522);
  }
  
  public static h h(List<d> paramList, String paramString)
  {
    AppMethodBeat.i(319539);
    h localh1 = new h(new a(), "");
    localh1.b(new h((d)paramList.get(0), ""));
    HashMap localHashMap = new HashMap();
    int i = 1;
    if (i < paramList.size() - 1)
    {
      d locald = (d)paramList.get(i);
      int j = locald.czC();
      if (j <= 0)
      {
        j = locald.czB();
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
        if ((localh2 != null) && ((Util.isNullOrNil(locald.czD())) || (Util.isNullOrNil(paramString)) || (paramString.equals(locald.czD()))))
        {
          if (a(localh2.sUW)) {
            break label250;
          }
          Log.e("StepNode", "addChild but not a node group");
          localObject = null;
          label219:
          if (!a(locald)) {
            break label368;
          }
          localHashMap.put(Integer.valueOf(locald.czB()), localObject);
        }
      }
      label250:
      if (localh2.sUX == null) {
        localh2.sUX = new ArrayList();
      }
      if (localh2.sUW.getType() == 3)
      {
        localObject = "-";
        label288:
        if (Util.isNullOrNil(localh2.sUY)) {
          break label377;
        }
      }
      label368:
      label377:
      for (Object localObject = String.format("%s%s%d", new Object[] { localh2.sUY, localObject, Integer.valueOf(localh2.sUX.size() + 1) });; localObject = String.format("%d", new Object[] { Integer.valueOf(localh2.sUX.size() + 1) }))
      {
        localObject = new h(locald, (String)localObject);
        localh2.sUX.add(localObject);
        break label219;
        break;
        localObject = ".";
        break label288;
      }
    }
    localh1.b(new h((d)paramList.get(paramList.size() - 1), ""));
    AppMethodBeat.o(319539);
    return localh1;
  }
  
  public final a czE()
  {
    if ((this.sUW instanceof a)) {
      return (a)this.sUW;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.h
 * JD-Core Version:    0.7.0.1
 */