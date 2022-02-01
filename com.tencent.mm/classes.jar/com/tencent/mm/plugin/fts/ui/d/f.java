package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.d;
import com.tencent.mm.plugin.fts.ui.a.e;
import com.tencent.mm.plugin.fts.ui.a.i;
import com.tencent.mm.plugin.fts.ui.a.l;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class f
  extends k
{
  public x sCD;
  public String syB;
  
  public f(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112184);
    this.sFZ = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.syB = this.syB;
    paramHashSet.syI = this;
    paramHashSet.handler = paramao;
    paramHashSet.jwR = 3;
    paramao = ((n)g.ad(n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112184);
    return paramao;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112187);
    int i = paramInt - parama.szm;
    if (parama.szn) {
      i -= 1;
    }
    for (;;)
    {
      m localm = null;
      Object localObject = localm;
      if (i < parama.lnk.size())
      {
        localObject = localm;
        if (i >= 0)
        {
          localm = (m)parama.lnk.get(i);
          if (!localm.sxG.equals("create_talker_message​")) {
            break label139;
          }
          localObject = new i(paramInt);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szt = false;
          ((i)localObject).syB = this.syB;
          this.sFZ = true;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).szv = (i + 1);
          ((com.tencent.mm.plugin.fts.a.d.a.a)localObject).sxM = parama.sxM;
        }
        AppMethodBeat.o(112187);
        return localObject;
        label139:
        if (localm.sxG.equals("no_result​"))
        {
          localObject = new l(paramInt);
        }
        else
        {
          localObject = new d(i);
          ((d)localObject).jPN = localm;
          ((d)localObject).sxM = parama.sxM;
          ((d)localObject).sCD = this.sCD;
          ((d)localObject).fP(localm.type, localm.sxF);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112185);
    paramHashSet = paramk.syK;
    Object localObject;
    if (dJ(paramHashSet))
    {
      if (paramHashSet.size() > 0)
      {
        localObject = (m)paramHashSet.get(0);
        if (((m)localObject).sxG.equals("create_talker_message​"))
        {
          e.a locala = new e.a();
          locala.szn = false;
          locala.lnk = new ArrayList();
          locala.lnk.add(localObject);
          locala.sxM = paramk.sxM;
          locala.businessType = -2;
          this.sBx.add(locala);
          paramHashSet.remove(0);
        }
      }
      localObject = new e.a();
      ((e.a)localObject).businessType = -2;
      ((e.a)localObject).sxM = paramk.sxM;
      if (paramHashSet.size() != 0) {
        break label213;
      }
      ((e.a)localObject).szn = false;
      paramk = new m();
      paramk.sxG = "no_result​";
      ((e.a)localObject).lnk = new ArrayList();
      ((e.a)localObject).lnk.add(paramk);
    }
    for (;;)
    {
      this.sBx.add(localObject);
      AppMethodBeat.o(112185);
      return;
      label213:
      ((e.a)localObject).lnk = paramHashSet;
    }
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112186);
    e locale = new e(paramInt);
    locale.talker = this.syB;
    locale.count = parama.lnk.size();
    AppMethodBeat.o(112186);
    return locale;
  }
  
  public final int getType()
  {
    return 160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.f
 * JD-Core Version:    0.7.0.1
 */