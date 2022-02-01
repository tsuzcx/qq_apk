package com.tencent.mm.plugin.appbrand.keylogger.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public final d lgr;
  public List<h> lgs;
  public final String lgt;
  
  public h(d paramd, String paramString)
  {
    this.lgr = paramd;
    this.lgt = paramString;
  }
  
  public static void a(h paramh, b paramb)
  {
    AppMethodBeat.i(201044);
    if (paramh == null)
    {
      AppMethodBeat.o(201044);
      return;
    }
    if (paramb == null)
    {
      AppMethodBeat.o(201044);
      return;
    }
    paramb.a(paramh);
    paramh = paramh.lgs;
    if ((paramh == null) || (paramh.isEmpty()))
    {
      AppMethodBeat.o(201044);
      return;
    }
    int i = 0;
    while (i < paramh.size())
    {
      a((h)paramh.get(i), paramb);
      i += 1;
    }
    AppMethodBeat.o(201044);
  }
  
  public static boolean a(d paramd)
  {
    AppMethodBeat.i(201045);
    if ((paramd.getType() == 3) || (paramd.getType() == 2))
    {
      AppMethodBeat.o(201045);
      return true;
    }
    AppMethodBeat.o(201045);
    return false;
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(201043);
    if (!a(this.lgr))
    {
      ac.e("StepNode", "addChild but not a node group");
      AppMethodBeat.o(201043);
      return;
    }
    if (this.lgs == null) {
      this.lgs = new ArrayList();
    }
    this.lgs.add(paramh);
    AppMethodBeat.o(201043);
  }
  
  public final List<h> bmU()
  {
    return this.lgs;
  }
  
  public final a bmV()
  {
    if ((this.lgr instanceof a)) {
      return (a)this.lgr;
    }
    return null;
  }
  
  public static final class a
    extends g
  {}
  
  public static abstract interface b
  {
    public abstract void a(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.h
 * JD-Core Version:    0.7.0.1
 */