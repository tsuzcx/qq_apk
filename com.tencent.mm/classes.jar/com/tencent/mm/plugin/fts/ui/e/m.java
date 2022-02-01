package com.tencent.mm.plugin.fts.ui.e;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.b.r;
import com.tencent.mm.plugin.fts.ui.b.s;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class m
  extends k
{
  public String Htw;
  
  public m(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final int Wi(int paramInt)
  {
    AppMethodBeat.i(112210);
    int k = this.HwJ.size();
    int j = 0;
    if (j < k)
    {
      e.a locala = (e.a)this.HwJ.get(j);
      locala.Huj = paramInt;
      int i = paramInt;
      if (locala.Huk) {
        i = paramInt + 1;
      }
      if (locala.tbH.size() > 3) {
        if (locala.vpw)
        {
          i += 3;
          label85:
          locala.Hul = i;
          paramInt = i;
          if (locala.ABD) {
            paramInt = i + 1;
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i += locala.tbH.size();
        break label85;
        paramInt = i + locala.tbH.size();
        locala.Hul = paramInt;
      }
    }
    AppMethodBeat.o(112210);
    return paramInt;
  }
  
  public com.tencent.mm.plugin.fts.a.a.c a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112208);
    this.HCE = false;
    paramHashSet = new com.tencent.mm.plugin.fts.a.a.l();
    paramHashSet.query = getQuery();
    paramHashSet.HtB = e.Huh;
    paramHashSet.Htw = this.Htw;
    paramHashSet.HtC = this;
    paramHashSet.handler = paramMMHandler;
    paramHashSet.qRb = 10;
    paramMMHandler = ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112208);
    return paramMMHandler;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112213);
    o localo = null;
    int i;
    Object localObject;
    if (parama.Huk)
    {
      i = paramInt - parama.Huj - 1;
      localObject = localo;
      if (i >= 0)
      {
        localObject = localo;
        if (i < parama.tbH.size())
        {
          localo = (o)parama.tbH.get(i);
          if (!localo.Hsz.equals("no_result​")) {
            break label105;
          }
          localObject = new com.tencent.mm.plugin.fts.ui.b.l(paramInt);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112213);
      return localObject;
      i = paramInt - parama.Huj;
      break;
      label105:
      localObject = new s(paramInt);
      ((s)localObject).rpp = localo;
      ((s)localObject).HAD = parama.Hum;
      ((s)localObject).FWt = ((s)localObject).rpp.FWt;
      ((s)localObject).xVf = -14;
      ((s)localObject).hAN = 2;
      ((s)localObject).iW(localo.type, localo.subtype);
    }
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.a.m paramm, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112209);
    switch (paramm.resultCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112209);
      return;
      if (paramm.HtF.size() > 0)
      {
        int i = 0;
        if (i < paramm.HtF.size())
        {
          paramHashSet = new e.a();
          paramHashSet.Huk = true;
          paramHashSet.Hum = ((o)paramm.HtF.get(i));
          paramHashSet.FWt = paramm.FWt;
          paramHashSet.tbH = ((List)paramHashSet.Hum.HtQ);
          if ((paramHashSet.tbH.size() > 3) && (i != paramm.HtF.size() - 1)) {
            paramHashSet.vpw = true;
          }
          for (paramHashSet.ABD = true;; paramHashSet.ABD = false)
          {
            this.HwJ.add(paramHashSet);
            i += 1;
            break;
            paramHashSet.vpw = false;
          }
        }
        AppMethodBeat.o(112209);
        return;
      }
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.FWt = paramm.FWt;
      paramHashSet.Huk = false;
      paramm = new o();
      paramm.Hsz = "no_result​";
      paramHashSet.tbH = new ArrayList();
      paramHashSet.tbH.add(paramm);
      this.HwJ.add(paramHashSet);
    }
  }
  
  public final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(112214);
    super.a(paramView, parama, paramBoolean);
    int i;
    if ((parama instanceof com.tencent.mm.plugin.fts.ui.b.c)) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.HwJ.size())
      {
        paramView = (e.a)this.HwJ.get(i);
        if (paramView.Hul == parama.position)
        {
          paramBoolean = bool;
          if (!paramView.vpw) {
            paramBoolean = true;
          }
          paramView.vpw = paramBoolean;
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
  
  public com.tencent.mm.plugin.fts.ui.b.k c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112211);
    r localr = new r(paramInt);
    localr.HAD = parama.Hum;
    localr.FWt = localr.HAD.FWt;
    AppMethodBeat.o(112211);
    return localr;
  }
  
  public final com.tencent.mm.plugin.fts.ui.b.n d(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112212);
    com.tencent.mm.plugin.fts.ui.b.c localc = new com.tencent.mm.plugin.fts.ui.b.c(paramInt);
    localc.resId = p.g.fts_header_message;
    localc.Gxy = parama.vpw;
    AppMethodBeat.o(112212);
    return localc;
  }
  
  protected int fzf()
  {
    return 2;
  }
  
  public int getType()
  {
    return 176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.e.m
 * JD-Core Version:    0.7.0.1
 */