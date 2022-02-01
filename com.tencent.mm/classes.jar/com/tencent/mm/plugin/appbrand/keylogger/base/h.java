package com.tencent.mm.plugin.appbrand.keylogger.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public final d kEY;
  public List<h> kEZ;
  public final String kFa;
  
  public h(d paramd, String paramString)
  {
    this.kEY = paramd;
    this.kFa = paramString;
  }
  
  public static void a(h paramh, b paramb)
  {
    AppMethodBeat.i(194889);
    if (paramh == null)
    {
      AppMethodBeat.o(194889);
      return;
    }
    if (paramb == null)
    {
      AppMethodBeat.o(194889);
      return;
    }
    paramb.a(paramh);
    paramh = paramh.kEZ;
    if ((paramh == null) || (paramh.isEmpty()))
    {
      AppMethodBeat.o(194889);
      return;
    }
    int i = 0;
    while (i < paramh.size())
    {
      a((h)paramh.get(i), paramb);
      i += 1;
    }
    AppMethodBeat.o(194889);
  }
  
  public static boolean a(d paramd)
  {
    AppMethodBeat.i(194890);
    if ((paramd.getType() == 3) || (paramd.getType() == 2))
    {
      AppMethodBeat.o(194890);
      return true;
    }
    AppMethodBeat.o(194890);
    return false;
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(194888);
    if (!a(this.kEY))
    {
      ad.e("StepNode", "addChild but not a node group");
      AppMethodBeat.o(194888);
      return;
    }
    if (this.kEZ == null) {
      this.kEZ = new ArrayList();
    }
    this.kEZ.add(paramh);
    AppMethodBeat.o(194888);
  }
  
  public final List<h> bga()
  {
    return this.kEZ;
  }
  
  public final a bgb()
  {
    if ((this.kEY instanceof a)) {
      return (a)this.kEY;
    }
    return null;
  }
  
  public static abstract interface b
  {
    public abstract void a(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.h
 * JD-Core Version:    0.7.0.1
 */