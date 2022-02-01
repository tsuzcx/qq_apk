package com.tencent.mm.plugin.appbrand.keylogger.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public final d lDp;
  public List<h> lDq;
  public final String lDr;
  
  public h(d paramd, String paramString)
  {
    this.lDp = paramd;
    this.lDr = paramString;
  }
  
  public static void a(h paramh, b paramb)
  {
    AppMethodBeat.i(187716);
    if (paramh == null)
    {
      AppMethodBeat.o(187716);
      return;
    }
    if (paramb == null)
    {
      AppMethodBeat.o(187716);
      return;
    }
    paramb.a(paramh);
    paramh = paramh.lDq;
    if ((paramh == null) || (paramh.isEmpty()))
    {
      AppMethodBeat.o(187716);
      return;
    }
    int i = 0;
    while (i < paramh.size())
    {
      a((h)paramh.get(i), paramb);
      i += 1;
    }
    AppMethodBeat.o(187716);
  }
  
  public static boolean a(d paramd)
  {
    AppMethodBeat.i(187717);
    if ((paramd.getType() == 3) || (paramd.getType() == 2))
    {
      AppMethodBeat.o(187717);
      return true;
    }
    AppMethodBeat.o(187717);
    return false;
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(187715);
    if (!a(this.lDp))
    {
      ad.e("StepNode", "addChild but not a node group");
      AppMethodBeat.o(187715);
      return;
    }
    if (this.lDq == null) {
      this.lDq = new ArrayList();
    }
    this.lDq.add(paramh);
    AppMethodBeat.o(187715);
  }
  
  public final List<h> bqF()
  {
    return this.lDq;
  }
  
  public final a bqG()
  {
    if ((this.lDp instanceof a)) {
      return (a)this.lDp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.h
 * JD-Core Version:    0.7.0.1
 */