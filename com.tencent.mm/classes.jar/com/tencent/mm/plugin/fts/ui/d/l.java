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
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class l
  extends k
{
  public String tFU;
  
  public l(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final int Hn(int paramInt)
  {
    AppMethodBeat.i(112210);
    int k = this.tIP.size();
    int j = 0;
    if (j < k)
    {
      e.a locala = (e.a)this.tIP.get(j);
      locala.tGE = paramInt;
      int i = paramInt;
      if (locala.tGF) {
        i = paramInt + 1;
      }
      if (locala.lPc.size() > 3) {
        if (locala.tGH)
        {
          i += 3;
          label85:
          locala.tGG = i;
          paramInt = i;
          if (locala.rRg) {
            paramInt = i + 1;
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i += locala.lPc.size();
        break label85;
        paramInt = i + locala.lPc.size();
        locala.tGG = paramInt;
      }
    }
    AppMethodBeat.o(112210);
    return paramInt;
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(aq paramaq, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112208);
    this.tNK = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.tFZ = e.tGC;
    paramHashSet.tFU = this.tFU;
    paramHashSet.tGa = this;
    paramHashSet.handler = paramaq;
    paramHashSet.jUf = 10;
    paramaq = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112208);
    return paramaq;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112213);
    m localm = null;
    int i;
    Object localObject;
    if (parama.tGF)
    {
      i = paramInt - parama.tGE - 1;
      localObject = localm;
      if (i >= 0)
      {
        localObject = localm;
        if (i < parama.lPc.size())
        {
          localm = (m)parama.lPc.get(i);
          if (!localm.tEY.equals("no_result​")) {
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
      i = paramInt - parama.tGE;
      break;
      label105:
      localObject = new p(paramInt);
      ((p)localObject).kno = localm;
      ((p)localObject).tLO = parama.tGI;
      ((p)localObject).tFe = ((p)localObject).kno.tFe;
      ((p)localObject).pSr = -14;
      ((p)localObject).dmr = 2;
      ((p)localObject).gf(localm.type, localm.tEX);
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112209);
    switch (paramk.bZU)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112209);
      return;
      if (paramk.tGc.size() > 0)
      {
        int i = 0;
        if (i < paramk.tGc.size())
        {
          paramHashSet = new e.a();
          paramHashSet.tGF = true;
          paramHashSet.tGI = ((m)paramk.tGc.get(i));
          paramHashSet.tFe = paramk.tFe;
          paramHashSet.lPc = ((List)paramHashSet.tGI.userData);
          if ((paramHashSet.lPc.size() > 3) && (i != paramk.tGc.size() - 1)) {
            paramHashSet.tGH = true;
          }
          for (paramHashSet.rRg = true;; paramHashSet.rRg = false)
          {
            this.tIP.add(paramHashSet);
            i += 1;
            break;
            paramHashSet.tGH = false;
          }
        }
        AppMethodBeat.o(112209);
        return;
      }
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.tFe = paramk.tFe;
      paramHashSet.tGF = false;
      paramk = new m();
      paramk.tEY = "no_result​";
      paramHashSet.lPc = new ArrayList();
      paramHashSet.lPc.add(paramk);
      this.tIP.add(paramHashSet);
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
      if (i < this.tIP.size())
      {
        paramView = (e.a)this.tIP.get(i);
        if (paramView.tGG == parama.position)
        {
          paramBoolean = bool;
          if (!paramView.tGH) {
            paramBoolean = true;
          }
          paramView.tGH = paramBoolean;
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
    localo.tLO = parama.tGI;
    localo.tFe = localo.tLO.tFe;
    AppMethodBeat.o(112211);
    return localo;
  }
  
  protected int cWx()
  {
    return 2;
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.n d(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112212);
    c localc = new c(paramInt);
    localc.resId = 2131759689;
    localc.tdC = parama.tGH;
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