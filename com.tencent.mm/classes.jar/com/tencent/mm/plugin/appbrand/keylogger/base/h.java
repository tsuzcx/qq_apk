package com.tencent.mm.plugin.appbrand.keylogger.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public final d lHO;
  public List<h> lHP;
  public final String lHQ;
  
  public h(d paramd, String paramString)
  {
    this.lHO = paramd;
    this.lHQ = paramString;
  }
  
  public static void a(h paramh, b paramb)
  {
    AppMethodBeat.i(201283);
    if (paramh == null)
    {
      AppMethodBeat.o(201283);
      return;
    }
    if (paramb == null)
    {
      AppMethodBeat.o(201283);
      return;
    }
    paramb.a(paramh);
    paramh = paramh.lHP;
    if ((paramh == null) || (paramh.isEmpty()))
    {
      AppMethodBeat.o(201283);
      return;
    }
    int i = 0;
    while (i < paramh.size())
    {
      a((h)paramh.get(i), paramb);
      i += 1;
    }
    AppMethodBeat.o(201283);
  }
  
  public static boolean a(d paramd)
  {
    AppMethodBeat.i(201284);
    if ((paramd.getType() == 3) || (paramd.getType() == 2))
    {
      AppMethodBeat.o(201284);
      return true;
    }
    AppMethodBeat.o(201284);
    return false;
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(201282);
    if (!a(this.lHO))
    {
      ae.e("StepNode", "addChild but not a node group");
      AppMethodBeat.o(201282);
      return;
    }
    if (this.lHP == null) {
      this.lHP = new ArrayList();
    }
    this.lHP.add(paramh);
    AppMethodBeat.o(201282);
  }
  
  public final List<h> brp()
  {
    return this.lHP;
  }
  
  public final a brq()
  {
    if ((this.lHO instanceof a)) {
      return (a)this.lHO;
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