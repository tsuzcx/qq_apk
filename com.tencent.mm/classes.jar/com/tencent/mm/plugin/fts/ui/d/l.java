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
  public String tvd;
  
  public l(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final int GQ(int paramInt)
  {
    AppMethodBeat.i(112210);
    int k = this.txY.size();
    int j = 0;
    if (j < k)
    {
      e.a locala = (e.a)this.txY.get(j);
      locala.tvN = paramInt;
      int i = paramInt;
      if (locala.tvO) {
        i = paramInt + 1;
      }
      if (locala.lKC.size() > 3) {
        if (locala.tvQ)
        {
          i += 3;
          label85:
          locala.tvP = i;
          paramInt = i;
          if (locala.rKf) {
            paramInt = i + 1;
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i += locala.lKC.size();
        break label85;
        paramInt = i + locala.lKC.size();
        locala.tvP = paramInt;
      }
    }
    AppMethodBeat.o(112210);
    return paramInt;
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(ap paramap, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112208);
    this.tCT = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.tvi = e.tvL;
    paramHashSet.tvd = this.tvd;
    paramHashSet.tvj = this;
    paramHashSet.handler = paramap;
    paramHashSet.jQN = 10;
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
    if (parama.tvO)
    {
      i = paramInt - parama.tvN - 1;
      localObject = localm;
      if (i >= 0)
      {
        localObject = localm;
        if (i < parama.lKC.size())
        {
          localm = (m)parama.lKC.get(i);
          if (!localm.tuh.equals("no_result​")) {
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
      i = paramInt - parama.tvN;
      break;
      label105:
      localObject = new p(paramInt);
      ((p)localObject).kjY = localm;
      ((p)localObject).tAX = parama.tvR;
      ((p)localObject).tun = ((p)localObject).kjY.tun;
      ((p)localObject).pLM = -14;
      ((p)localObject).dlp = 2;
      ((p)localObject).gf(localm.type, localm.tug);
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
      if (paramk.tvl.size() > 0)
      {
        int i = 0;
        if (i < paramk.tvl.size())
        {
          paramHashSet = new e.a();
          paramHashSet.tvO = true;
          paramHashSet.tvR = ((m)paramk.tvl.get(i));
          paramHashSet.tun = paramk.tun;
          paramHashSet.lKC = ((List)paramHashSet.tvR.userData);
          if ((paramHashSet.lKC.size() > 3) && (i != paramk.tvl.size() - 1)) {
            paramHashSet.tvQ = true;
          }
          for (paramHashSet.rKf = true;; paramHashSet.rKf = false)
          {
            this.txY.add(paramHashSet);
            i += 1;
            break;
            paramHashSet.tvQ = false;
          }
        }
        AppMethodBeat.o(112209);
        return;
      }
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.tun = paramk.tun;
      paramHashSet.tvO = false;
      paramk = new m();
      paramk.tuh = "no_result​";
      paramHashSet.lKC = new ArrayList();
      paramHashSet.lKC.add(paramk);
      this.txY.add(paramHashSet);
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
      if (i < this.txY.size())
      {
        paramView = (e.a)this.txY.get(i);
        if (paramView.tvP == parama.position)
        {
          paramBoolean = bool;
          if (!paramView.tvQ) {
            paramBoolean = true;
          }
          paramView.tvQ = paramBoolean;
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
    localo.tAX = parama.tvR;
    localo.tun = localo.tAX.tun;
    AppMethodBeat.o(112211);
    return localo;
  }
  
  protected int cTS()
  {
    return 2;
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.n d(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112212);
    c localc = new c(paramInt);
    localc.resId = 2131759689;
    localc.sSq = parama.tvQ;
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