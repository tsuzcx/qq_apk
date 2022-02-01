package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.c;
import com.tencent.mm.plugin.fts.ui.a.o;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.plugin.fts.ui.o.g;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class l
  extends k
{
  public String BIO;
  
  public l(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final int SB(int paramInt)
  {
    AppMethodBeat.i(112210);
    int k = this.BLN.size();
    int j = 0;
    if (j < k)
    {
      e.a locala = (e.a)this.BLN.get(j);
      locala.BJz = paramInt;
      int i = paramInt;
      if (locala.BJA) {
        i = paramInt + 1;
      }
      if (locala.pWR.size() > 3) {
        if (locala.BJC)
        {
          i += 3;
          label85:
          locala.BJB = i;
          paramInt = i;
          if (locala.xcp) {
            paramInt = i + 1;
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i += locala.pWR.size();
        break label85;
        paramInt = i + locala.pWR.size();
        locala.BJB = paramInt;
      }
    }
    AppMethodBeat.o(112210);
    return paramInt;
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(MMHandler paramMMHandler, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(112208);
    this.BQU = false;
    paramHashSet = new j();
    paramHashSet.query = getQuery();
    paramHashSet.BIT = e.BJx;
    paramHashSet.BIO = this.BIO;
    paramHashSet.BIU = this;
    paramHashSet.handler = paramMMHandler;
    paramHashSet.nRn = 10;
    paramMMHandler = ((com.tencent.mm.plugin.fts.a.n)h.ag(com.tencent.mm.plugin.fts.a.n.class)).search(3, paramHashSet);
    AppMethodBeat.o(112208);
    return paramMMHandler;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112213);
    m localm = null;
    int i;
    Object localObject;
    if (parama.BJA)
    {
      i = paramInt - parama.BJz - 1;
      localObject = localm;
      if (i >= 0)
      {
        localObject = localm;
        if (i < parama.pWR.size())
        {
          localm = (m)parama.pWR.get(i);
          if (!localm.BHS.equals("no_result​")) {
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
      i = paramInt - parama.BJz;
      break;
      label105:
      localObject = new p(paramInt);
      ((p)localObject).olG = localm;
      ((p)localObject).BON = parama.BJD;
      ((p)localObject).BHY = ((p)localObject).olG.BHY;
      ((p)localObject).uMD = -14;
      ((p)localObject).fwp = 2;
      ((p)localObject).hx(localm.type, localm.BHR);
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
      if (paramk.BIW.size() > 0)
      {
        int i = 0;
        if (i < paramk.BIW.size())
        {
          paramHashSet = new e.a();
          paramHashSet.BJA = true;
          paramHashSet.BJD = ((m)paramk.BIW.get(i));
          paramHashSet.BHY = paramk.BHY;
          paramHashSet.pWR = ((List)paramHashSet.BJD.BJh);
          if ((paramHashSet.pWR.size() > 3) && (i != paramk.BIW.size() - 1)) {
            paramHashSet.BJC = true;
          }
          for (paramHashSet.xcp = true;; paramHashSet.xcp = false)
          {
            this.BLN.add(paramHashSet);
            i += 1;
            break;
            paramHashSet.BJC = false;
          }
        }
        AppMethodBeat.o(112209);
        return;
      }
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.BHY = paramk.BHY;
      paramHashSet.BJA = false;
      paramk = new m();
      paramk.BHS = "no_result​";
      paramHashSet.pWR = new ArrayList();
      paramHashSet.pWR.add(paramk);
      this.BLN.add(paramHashSet);
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
      if (i < this.BLN.size())
      {
        paramView = (e.a)this.BLN.get(i);
        if (paramView.BJB == parama.position)
        {
          paramBoolean = bool;
          if (!paramView.BJC) {
            paramBoolean = true;
          }
          paramView.BJC = paramBoolean;
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
    localo.BON = parama.BJD;
    localo.BHY = localo.BON.BHY;
    AppMethodBeat.o(112211);
    return localo;
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.n d(int paramInt, e.a parama)
  {
    AppMethodBeat.i(112212);
    c localc = new c(paramInt);
    localc.resId = o.g.fts_header_message;
    localc.AUY = parama.BJC;
    AppMethodBeat.o(112212);
    return localc;
  }
  
  protected int esh()
  {
    return 2;
  }
  
  public int getType()
  {
    return 176;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.l
 * JD-Core Version:    0.7.0.1
 */