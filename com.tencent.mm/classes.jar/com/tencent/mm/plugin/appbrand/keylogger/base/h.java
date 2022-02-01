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
  public final d pQw;
  private List<h> pQx;
  public final String pQy;
  
  private h(d paramd, String paramString)
  {
    this.pQw = paramd;
    this.pQy = paramString;
  }
  
  public static void a(h paramh, b paramb)
  {
    AppMethodBeat.i(208789);
    if (paramh == null)
    {
      AppMethodBeat.o(208789);
      return;
    }
    if (paramb == null)
    {
      AppMethodBeat.o(208789);
      return;
    }
    paramb.a(paramh);
    paramh = paramh.pQx;
    if ((paramh == null) || (paramh.isEmpty()))
    {
      AppMethodBeat.o(208789);
      return;
    }
    int i = 0;
    while (i < paramh.size())
    {
      a((h)paramh.get(i), paramb);
      i += 1;
    }
    AppMethodBeat.o(208789);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(208791);
    if ((paramd.getType() == 3) || (paramd.getType() == 2))
    {
      AppMethodBeat.o(208791);
      return true;
    }
    AppMethodBeat.o(208791);
    return false;
  }
  
  private void b(h paramh)
  {
    AppMethodBeat.i(208788);
    if (!a(this.pQw))
    {
      Log.e("StepNode", "addChild but not a node group");
      AppMethodBeat.o(208788);
      return;
    }
    if (this.pQx == null) {
      this.pQx = new ArrayList();
    }
    this.pQx.add(paramh);
    AppMethodBeat.o(208788);
  }
  
  public static h f(List<d> paramList, String paramString)
  {
    AppMethodBeat.i(208790);
    h localh1 = new h(new a(), "");
    localh1.b(new h((d)paramList.get(0), ""));
    HashMap localHashMap = new HashMap();
    int i = 1;
    if (i < paramList.size() - 1)
    {
      d locald = (d)paramList.get(i);
      int j = locald.bZq();
      if (j <= 0)
      {
        j = locald.bZp();
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
        if ((localh2 != null) && ((Util.isNullOrNil(locald.bZr())) || (Util.isNullOrNil(paramString)) || (paramString.equals(locald.bZr()))))
        {
          if (a(localh2.pQw)) {
            break label250;
          }
          Log.e("StepNode", "addChild but not a node group");
          localObject = null;
          label219:
          if (!a(locald)) {
            break label368;
          }
          localHashMap.put(Integer.valueOf(locald.bZp()), localObject);
        }
      }
      label250:
      if (localh2.pQx == null) {
        localh2.pQx = new ArrayList();
      }
      if (localh2.pQw.getType() == 3)
      {
        localObject = "-";
        label288:
        if (Util.isNullOrNil(localh2.pQy)) {
          break label377;
        }
      }
      label368:
      label377:
      for (Object localObject = String.format("%s%s%d", new Object[] { localh2.pQy, localObject, Integer.valueOf(localh2.pQx.size() + 1) });; localObject = String.format("%d", new Object[] { Integer.valueOf(localh2.pQx.size() + 1) }))
      {
        localObject = new h(locald, (String)localObject);
        localh2.pQx.add(localObject);
        break label219;
        break;
        localObject = ".";
        break label288;
      }
    }
    localh1.b(new h((d)paramList.get(paramList.size() - 1), ""));
    AppMethodBeat.o(208790);
    return localh1;
  }
  
  public final List<h> bZs()
  {
    return this.pQx;
  }
  
  public final a bZt()
  {
    if ((this.pQw instanceof a)) {
      return (a)this.pQw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.h
 * JD-Core Version:    0.7.0.1
 */