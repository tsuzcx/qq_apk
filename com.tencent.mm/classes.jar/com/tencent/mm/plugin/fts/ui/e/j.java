package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.i;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class j
  extends k
{
  public j(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112200);
    this.HCE = false;
    com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
    locall.query = getQuery();
    locall.HtA = paramHashSet;
    locall.HtC = this;
    locall.handler = paramMMHandler;
    paramMMHandler = ((n)h.az(n.class)).search(3, locall);
    AppMethodBeat.o(112200);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112202);
    int i = paramInt - parama.Huj;
    if (parama.Huk) {
      i -= 1;
    }
    for (;;)
    {
      o localo = null;
      Object localObject = localo;
      if (i < parama.tbH.size())
      {
        localObject = localo;
        if (i >= 0)
        {
          localo = (o)parama.tbH.get(i);
          if (!localo.Hsz.equals("create_talker_message​")) {
            break label130;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hup = false;
          this.HCE = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hur = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).FWt = parama.FWt;
        }
        AppMethodBeat.o(112202);
        return localObject;
        label130:
        if (localo.Hsz.equals("no_result​"))
        {
          localObject = new com.tencent.mm.plugin.fts.ui.b.l(paramInt);
        }
        else
        {
          localObject = new com.tencent.mm.plugin.fts.ui.b.m(paramInt);
          ((com.tencent.mm.plugin.fts.ui.b.m)localObject).rpp = localo;
          ((com.tencent.mm.plugin.fts.ui.b.m)localObject).iW(localo.type, localo.subtype);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112201);
    paramHashSet = paramm.HtF;
    Object localObject;
    if (hS(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (o)paramHashSet.get(0);
        if (((o)localObject).Hsz.equals("create_talker_message​"))
        {
          e.a locala = new e.a();
          locala.Huk = false;
          locala.tbH = new ArrayList();
          locala.tbH.add(localObject);
          locala.FWt = paramm.FWt;
          locala.businessType = -2;
          this.HwJ.add(locala);
          paramHashSet.remove(0);
        }
      }
      localObject = new e.a();
      ((e.a)localObject).businessType = -2;
      ((e.a)localObject).FWt = paramm.FWt;
      if (paramHashSet.size() != 0) {
        break label213;
      }
      ((e.a)localObject).Huk = false;
      paramm = new o();
      paramm.Hsz = "no_result​";
      ((e.a)localObject).tbH = new ArrayList();
      ((e.a)localObject).tbH.add(paramm);
    }
    for (;;)
    {
      this.HwJ.add(localObject);
      AppMethodBeat.o(112201);
      return;
      label213:
      ((e.a)localObject).tbH = paramHashSet;
    }
  }
  
  public final int getType()
  {
    return 4176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.j
 * JD-Core Version:    0.7.0.1
 */