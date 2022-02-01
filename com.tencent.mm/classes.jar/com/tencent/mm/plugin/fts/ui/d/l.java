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
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class l
  extends k
{
  public String rpI;
  
  public l(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final int DF(int paramInt)
  {
    AppMethodBeat.i(112210);
    int k = this.rsD.size();
    int j = 0;
    if (j < k)
    {
      e.a locala = (e.a)this.rsD.get(j);
      locala.rqs = paramInt;
      int i = paramInt;
      if (locala.rqt) {
        i = paramInt + 1;
      }
      if (locala.kLN.size() > 3) {
        if (locala.rqv)
        {
          i += 3;
          label85:
          locala.rqu = i;
          paramInt = i;
          if (locala.qpI) {
            paramInt = i + 1;
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i += locala.kLN.size();
        break label85;
        paramInt = i + locala.kLN.size();
        locala.rqu = paramInt;
      }
    }
    AppMethodBeat.o(112210);
    return paramInt;
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112208);
    this.rxh = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.rpN = e.rqq;
    paramHashSet.rpI = this.rpI;
    paramHashSet.rpO = this;
    paramHashSet.handler = paramap;
    paramHashSet.iWB = 10;
    paramap = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112208);
    return paramap;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112213);
    m localm = null;
    int i;
    Object localObject;
    if (parama.rqt)
    {
      i = paramInt - parama.rqs - 1;
      localObject = localm;
      if (i >= 0)
      {
        localObject = localm;
        if (i < parama.kLN.size())
        {
          localm = (m)parama.kLN.get(i);
          if (!localm.roN.equals("no_result​")) {
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
      i = paramInt - parama.rqs;
      break;
      label105:
      localObject = new p(paramInt);
      ((p)localObject).jpy = localm;
      ((p)localObject).rvo = parama.rqw;
      ((p)localObject).roS = ((p)localObject).jpy.roS;
      ((p)localObject).oEL = -14;
      ((p)localObject).dcz = 2;
      ((p)localObject).fI(localm.type, localm.roM);
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112209);
    switch (paramk.bRZ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112209);
      return;
      if (paramk.rpQ.size() > 0)
      {
        int i = 0;
        if (i < paramk.rpQ.size())
        {
          paramHashSet = new e.a();
          paramHashSet.rqt = true;
          paramHashSet.rqw = ((m)paramk.rpQ.get(i));
          paramHashSet.roS = paramk.roS;
          paramHashSet.kLN = ((List)paramHashSet.rqw.userData);
          if ((paramHashSet.kLN.size() > 3) && (i != paramk.rpQ.size() - 1)) {
            paramHashSet.rqv = true;
          }
          for (paramHashSet.qpI = true;; paramHashSet.qpI = false)
          {
            this.rsD.add(paramHashSet);
            i += 1;
            break;
            paramHashSet.rqv = false;
          }
        }
        AppMethodBeat.o(112209);
        return;
      }
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.roS = paramk.roS;
      paramHashSet.rqt = false;
      paramk = new m();
      paramk.roN = "no_result​";
      paramHashSet.kLN = new ArrayList();
      paramHashSet.kLN.add(paramk);
      this.rsD.add(paramHashSet);
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
      if (i < this.rsD.size())
      {
        paramView = (e.a)this.rsD.get(i);
        if (paramView.rqu == parama.position)
        {
          paramBoolean = bool;
          if (!paramView.rqv) {
            paramBoolean = true;
          }
          paramView.rqv = paramBoolean;
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
    localo.rvo = parama.rqw;
    localo.roS = localo.rvo.roS;
    AppMethodBeat.o(112211);
    return localo;
  }
  
  protected int cyn()
  {
    return 2;
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.n d(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112212);
    c localc = new c(paramInt);
    localc.resId = 2131759689;
    localc.qVx = parama.rqv;
    AppMethodBeat.o(112212);
    return localc;
  }
  
  public int getType()
  {
    return 176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.l
 * JD-Core Version:    0.7.0.1
 */