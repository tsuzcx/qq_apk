package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.c;
import com.tencent.mm.plugin.fts.ui.a.o;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class l
  extends k
{
  public String syC;
  
  public l(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final int FB(int paramInt)
  {
    AppMethodBeat.i(112210);
    int k = this.sBx.size();
    int j = 0;
    if (j < k)
    {
      e.a locala = (e.a)this.sBx.get(j);
      locala.szm = paramInt;
      int i = paramInt;
      if (locala.szn) {
        i = paramInt + 1;
      }
      if (locala.lnk.size() > 3) {
        if (locala.szp)
        {
          i += 3;
          label85:
          locala.szo = i;
          paramInt = i;
          if (locala.qYO) {
            paramInt = i + 1;
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i += locala.lnk.size();
        break label85;
        paramInt = i + locala.lnk.size();
        locala.szo = paramInt;
      }
    }
    AppMethodBeat.o(112210);
    return paramInt;
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112208);
    this.sFZ = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.syH = e.szk;
    paramHashSet.syC = this.syC;
    paramHashSet.syI = this;
    paramHashSet.handler = paramao;
    paramHashSet.jwR = 10;
    paramao = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112208);
    return paramao;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112213);
    m localm = null;
    int i;
    Object localObject;
    if (parama.szn)
    {
      i = paramInt - parama.szm - 1;
      localObject = localm;
      if (i >= 0)
      {
        localObject = localm;
        if (i < parama.lnk.size())
        {
          localm = (m)parama.lnk.get(i);
          if (!localm.sxG.equals("no_result​")) {
            break label105;
          }
          localObject = new com.tencent.mm.plugin.fts.ui.a.l(paramInt);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112213);
      return localObject;
      i = paramInt - parama.szm;
      break;
      label105:
      localObject = new p(paramInt);
      ((p)localObject).jPN = localm;
      ((p)localObject).sEg = parama.szq;
      ((p)localObject).sxM = ((p)localObject).jPN.sxM;
      ((p)localObject).pil = -14;
      ((p)localObject).cZX = 2;
      ((p)localObject).fP(localm.type, localm.sxF);
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112209);
    switch (paramk.bPH)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112209);
      return;
      if (paramk.syK.size() > 0)
      {
        int i = 0;
        if (i < paramk.syK.size())
        {
          paramHashSet = new e.a();
          paramHashSet.szn = true;
          paramHashSet.szq = ((m)paramk.syK.get(i));
          paramHashSet.sxM = paramk.sxM;
          paramHashSet.lnk = ((List)paramHashSet.szq.userData);
          if ((paramHashSet.lnk.size() > 3) && (i != paramk.syK.size() - 1)) {
            paramHashSet.szp = true;
          }
          for (paramHashSet.qYO = true;; paramHashSet.qYO = false)
          {
            this.sBx.add(paramHashSet);
            i += 1;
            break;
            paramHashSet.szp = false;
          }
        }
        AppMethodBeat.o(112209);
        return;
      }
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.sxM = paramk.sxM;
      paramHashSet.szn = false;
      paramk = new m();
      paramk.sxG = "no_result​";
      paramHashSet.lnk = new ArrayList();
      paramHashSet.lnk.add(paramk);
      this.sBx.add(paramHashSet);
    }
  }
  
  public final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(112214);
    super.a(paramView, parama, paramBoolean);
    int i;
    if ((parama instanceof c)) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.sBx.size())
      {
        paramView = (e.a)this.sBx.get(i);
        if (paramView.szo == parama.position)
        {
          paramBoolean = bool;
          if (!paramView.szp) {
            paramBoolean = true;
          }
          paramView.szp = paramBoolean;
        }
      }
      else
      {
        AppMethodBeat.o(112214);
        return true;
      }
      i += 1;
    }
  }
  
  public com.tencent.mm.plugin.fts.ui.a.k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112211);
    o localo = new o(paramInt);
    localo.sEg = parama.szq;
    localo.sxM = localo.sEg.sxM;
    AppMethodBeat.o(112211);
    return localo;
  }
  
  protected int cLz()
  {
    return 2;
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.n d(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112212);
    c localc = new c(paramInt);
    localc.resId = 2131759689;
    localc.rVH = parama.szp;
    AppMethodBeat.o(112212);
    return localc;
  }
  
  public int getType()
  {
    return 176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.l
 * JD-Core Version:    0.7.0.1
 */