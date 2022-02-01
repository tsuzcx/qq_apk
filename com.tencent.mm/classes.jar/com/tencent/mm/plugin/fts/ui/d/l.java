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
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class l
  extends k
{
  public String wWT;
  
  public l(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final int Nn(int paramInt)
  {
    AppMethodBeat.i(112210);
    int k = this.wZO.size();
    int j = 0;
    if (j < k)
    {
      e.a locala = (e.a)this.wZO.get(j);
      locala.wXD = paramInt;
      int i = paramInt;
      if (locala.wXE) {
        i = paramInt + 1;
      }
      if (locala.mWl.size() > 3) {
        if (locala.wXG)
        {
          i += 3;
          label85:
          locala.wXF = i;
          paramInt = i;
          if (locala.tuG) {
            paramInt = i + 1;
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i += locala.mWl.size();
        break label85;
        paramInt = i + locala.mWl.size();
        locala.wXF = paramInt;
      }
    }
    AppMethodBeat.o(112210);
    return paramInt;
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112208);
    this.xeL = false;
    paramHashSet = new j();
    paramHashSet.query = this.query;
    paramHashSet.wWY = e.wXB;
    paramHashSet.wWT = this.wWT;
    paramHashSet.wWZ = this;
    paramHashSet.handler = paramMMHandler;
    paramHashSet.kXb = 10;
    paramMMHandler = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112208);
    return paramMMHandler;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112213);
    m localm = null;
    int i;
    Object localObject;
    if (parama.wXE)
    {
      i = paramInt - parama.wXD - 1;
      localObject = localm;
      if (i >= 0)
      {
        localObject = localm;
        if (i < parama.mWl.size())
        {
          localm = (m)parama.mWl.get(i);
          if (!localm.wVX.equals("no_result​")) {
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
      i = paramInt - parama.wXD;
      break;
      label105:
      localObject = new p(paramInt);
      ((p)localObject).lqW = localm;
      ((p)localObject).xcP = parama.wXH;
      ((p)localObject).wWd = ((p)localObject).lqW.wWd;
      ((p)localObject).rjr = -14;
      ((p)localObject).dDG = 2;
      ((p)localObject).gE(localm.type, localm.wVW);
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.k paramk, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112209);
    switch (paramk.resultCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112209);
      return;
      if (paramk.wXb.size() > 0)
      {
        int i = 0;
        if (i < paramk.wXb.size())
        {
          paramHashSet = new e.a();
          paramHashSet.wXE = true;
          paramHashSet.wXH = ((m)paramk.wXb.get(i));
          paramHashSet.wWd = paramk.wWd;
          paramHashSet.mWl = ((List)paramHashSet.wXH.userData);
          if ((paramHashSet.mWl.size() > 3) && (i != paramk.wXb.size() - 1)) {
            paramHashSet.wXG = true;
          }
          for (paramHashSet.tuG = true;; paramHashSet.tuG = false)
          {
            this.wZO.add(paramHashSet);
            i += 1;
            break;
            paramHashSet.wXG = false;
          }
        }
        AppMethodBeat.o(112209);
        return;
      }
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.wWd = paramk.wWd;
      paramHashSet.wXE = false;
      paramk = new m();
      paramk.wVX = "no_result​";
      paramHashSet.mWl = new ArrayList();
      paramHashSet.mWl.add(paramk);
      this.wZO.add(paramHashSet);
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
      if (i < this.wZO.size())
      {
        paramView = (e.a)this.wZO.get(i);
        if (paramView.wXF == parama.position)
        {
          paramBoolean = bool;
          if (!paramView.wXG) {
            paramBoolean = true;
          }
          paramView.wXG = paramBoolean;
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
    localo.xcP = parama.wXH;
    localo.wWd = localo.xcP.wWd;
    AppMethodBeat.o(112211);
    return localo;
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.n d(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112212);
    c localc = new c(paramInt);
    localc.resId = 2131761010;
    localc.wke = parama.wXG;
    AppMethodBeat.o(112212);
    return localc;
  }
  
  protected int dPI()
  {
    return 2;
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