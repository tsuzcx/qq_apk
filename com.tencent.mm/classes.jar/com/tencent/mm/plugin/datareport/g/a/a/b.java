package com.tencent.mm.plugin.datareport.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datareport.f.c;
import com.tencent.mm.plugin.datareport.h.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class b
{
  Stack<c> xhG;
  
  public b()
  {
    AppMethodBeat.i(262952);
    this.xhG = new Stack();
    AppMethodBeat.o(262952);
  }
  
  public final c dtK()
  {
    AppMethodBeat.i(262978);
    if (this.xhG.size() <= 0)
    {
      AppMethodBeat.o(262978);
      return null;
    }
    c localc = (c)this.xhG.peek();
    AppMethodBeat.o(262978);
    return localc;
  }
  
  public final c dtL()
  {
    AppMethodBeat.i(262992);
    if (this.xhG.size() <= 0)
    {
      AppMethodBeat.o(262992);
      return null;
    }
    c localc = (c)this.xhG.get(0);
    AppMethodBeat.o(262992);
    return localc;
  }
  
  public final c dtM()
  {
    AppMethodBeat.i(263027);
    c localc = (c)this.xhG.pop();
    AppMethodBeat.o(263027);
    return localc;
  }
  
  public final List<c> dtN()
  {
    AppMethodBeat.i(263052);
    if (this.xhG.size() <= 0)
    {
      AppMethodBeat.o(263052);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (this.xhG.size() > 0) {
      localArrayList.add((c)this.xhG.pop());
    }
    AppMethodBeat.o(263052);
    return localArrayList;
  }
  
  public final void e(c paramc)
  {
    AppMethodBeat.i(262967);
    if (paramc == null)
    {
      AppMethodBeat.o(262967);
      return;
    }
    paramc.xhp = this.xhG.size();
    this.xhG.push(paramc);
    a.Jx(this.xhG.size());
    AppMethodBeat.o(262967);
  }
  
  public final List<c> f(c paramc)
  {
    AppMethodBeat.i(263004);
    if ((paramc == null) || (this.xhG.size() <= 0))
    {
      AppMethodBeat.o(263004);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = this.xhG.size() - 1;
    while (i >= 0)
    {
      c localc = (c)this.xhG.get(i);
      if (localc != null)
      {
        if (localc.b(paramc)) {
          break;
        }
        localArrayList.add(localc);
      }
      i -= 1;
    }
    AppMethodBeat.o(263004);
    return localArrayList;
  }
  
  public final boolean g(c paramc)
  {
    AppMethodBeat.i(263017);
    if ((paramc == null) || (this.xhG.size() <= 0))
    {
      AppMethodBeat.o(263017);
      return false;
    }
    int i = this.xhG.size() - 1;
    while (i >= 0)
    {
      c localc = (c)this.xhG.get(i);
      if ((localc != null) && (localc.b(paramc)))
      {
        AppMethodBeat.o(263017);
        return true;
      }
      i -= 1;
    }
    AppMethodBeat.o(263017);
    return false;
  }
  
  public final List<c> h(c paramc)
  {
    AppMethodBeat.i(263041);
    if ((paramc == null) || (this.xhG.size() <= 0))
    {
      AppMethodBeat.o(263041);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    c localc;
    if (this.xhG.size() > 0) {
      localc = (c)this.xhG.peek();
    }
    while ((localc != null) && (!localc.b(paramc)))
    {
      localArrayList.add((c)this.xhG.pop());
      if (this.xhG.size() > 0)
      {
        localc = (c)this.xhG.peek();
        continue;
        localc = null;
      }
      else
      {
        localc = null;
      }
    }
    AppMethodBeat.o(263041);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.g.a.a.b
 * JD-Core Version:    0.7.0.1
 */