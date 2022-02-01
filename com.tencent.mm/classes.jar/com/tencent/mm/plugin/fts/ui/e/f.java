package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.d;
import com.tencent.mm.plugin.fts.ui.b.e;
import com.tencent.mm.plugin.fts.ui.b.i;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class f
  extends k
{
  public String Htv;
  public aj Hyy;
  
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112184);
    this.HCE = false;
    paramHashSet = new com.tencent.mm.plugin.fts.a.a.l();
    paramHashSet.query = getQuery();
    paramHashSet.Htv = this.Htv;
    paramHashSet.HtC = this;
    paramHashSet.handler = paramMMHandler;
    paramHashSet.qRb = 3;
    paramMMHandler = ((n)h.az(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112184);
    return paramMMHandler;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112187);
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
            break label139;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).Hup = false;
          ((i)localObject).Htv = this.Htv;
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
        AppMethodBeat.o(112187);
        return localObject;
        label139:
        if (localo.Hsz.equals("no_result​"))
        {
          localObject = new com.tencent.mm.plugin.fts.ui.b.l(paramInt);
        }
        else
        {
          localObject = new d(i);
          ((d)localObject).rpp = localo;
          ((d)localObject).FWt = parama.FWt;
          ((d)localObject).Hyy = this.Hyy;
          ((d)localObject).iW(localo.type, localo.subtype);
        }
      }
    }
  }
  
  public final void a(m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112185);
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
      AppMethodBeat.o(112185);
      return;
      label213:
      ((e.a)localObject).tbH = paramHashSet;
    }
  }
  
  public final com.tencent.mm.plugin.fts.ui.b.k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112186);
    e locale = new e(paramInt);
    locale.talker = this.Htv;
    locale.count = parama.tbH.size();
    AppMethodBeat.o(112186);
    return locale;
  }
  
  public final int getType()
  {
    return 160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.f
 * JD-Core Version:    0.7.0.1
 */