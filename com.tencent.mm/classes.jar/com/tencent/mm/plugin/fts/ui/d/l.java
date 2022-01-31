package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.a.c;
import com.tencent.mm.plugin.fts.ui.a.o;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class l
  extends k
{
  public String mSO;
  
  public l(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public com.tencent.mm.plugin.fts.a.a.a a(ak paramak, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62092);
    this.naH = false;
    paramHashSet = new i();
    paramHashSet.query = this.query;
    paramHashSet.mST = e.mTw;
    paramHashSet.mSO = this.mSO;
    paramHashSet.mSU = this;
    paramHashSet.handler = paramak;
    paramHashSet.hdl = 10;
    paramak = ((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).search(3, paramHashSet);
    AppMethodBeat.o(62092);
    return paramak;
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62097);
    com.tencent.mm.plugin.fts.a.a.l locall = null;
    int i;
    Object localObject;
    if (parama.mTz)
    {
      i = paramInt - parama.mTy - 1;
      localObject = locall;
      if (i >= 0)
      {
        localObject = locall;
        if (i < parama.mTC.size())
        {
          locall = (com.tencent.mm.plugin.fts.a.a.l)parama.mTC.get(i);
          if (!locall.mRV.equals("no_result​")) {
            break label105;
          }
          localObject = new com.tencent.mm.plugin.fts.ui.a.l(paramInt);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(62097);
      return localObject;
      i = paramInt - parama.mTy;
      break;
      label105:
      localObject = new p(paramInt);
      ((p)localObject).hrL = locall;
      ((p)localObject).mYP = parama.mTE;
      ((p)localObject).mRX = ((p)localObject).hrL.mRX;
      ((p)localObject).lox = -14;
      ((p)localObject).showType = 2;
      ((p)localObject).es(locall.type, locall.mRU);
    }
  }
  
  public final void a(j paramj, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(62093);
    switch (paramj.bpE)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62093);
      return;
      if (paramj.mSW.size() > 0)
      {
        int i = 0;
        if (i < paramj.mSW.size())
        {
          paramHashSet = new e.a();
          paramHashSet.mTz = true;
          paramHashSet.mTE = ((com.tencent.mm.plugin.fts.a.a.l)paramj.mSW.get(i));
          paramHashSet.mRX = paramj.mRX;
          paramHashSet.mTC = ((List)paramHashSet.mTE.userData);
          if ((paramHashSet.mTC.size() > 3) && (i != paramj.mSW.size() - 1)) {
            paramHashSet.mTD = true;
          }
          for (paramHashSet.mTB = true;; paramHashSet.mTB = false)
          {
            this.mVO.add(paramHashSet);
            i += 1;
            break;
            paramHashSet.mTD = false;
          }
        }
        AppMethodBeat.o(62093);
        return;
      }
      paramHashSet = new e.a();
      paramHashSet.businessType = -2;
      paramHashSet.mRX = paramj.mRX;
      paramHashSet.mTz = false;
      paramj = new com.tencent.mm.plugin.fts.a.a.l();
      paramj.mRV = "no_result​";
      paramHashSet.mTC = new ArrayList();
      paramHashSet.mTC.add(paramj);
      this.mVO.add(paramHashSet);
    }
  }
  
  public final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(62098);
    super.a(paramView, parama, paramBoolean);
    int i;
    if ((parama instanceof c)) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.mVO.size())
      {
        paramView = (e.a)this.mVO.get(i);
        if (paramView.mTA == parama.position)
        {
          paramBoolean = bool;
          if (!paramView.mTD) {
            paramBoolean = true;
          }
          paramView.mTD = paramBoolean;
        }
      }
      else
      {
        AppMethodBeat.o(62098);
        return true;
      }
      i += 1;
    }
  }
  
  public com.tencent.mm.plugin.fts.ui.a.k b(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62095);
    o localo = new o(paramInt);
    localo.mYP = parama.mTE;
    localo.mRX = localo.mYP.mRX;
    AppMethodBeat.o(62095);
    return localo;
  }
  
  protected int bDc()
  {
    return 2;
  }
  
  public final com.tencent.mm.plugin.fts.ui.a.n c(int paramInt, e.a parama)
  {
    AppMethodBeat.i(62096);
    c localc = new c(paramInt);
    localc.resId = 2131300216;
    localc.mYy = parama.mTD;
    AppMethodBeat.o(62096);
    return localc;
  }
  
  public int getType()
  {
    return 176;
  }
  
  public final int wt(int paramInt)
  {
    AppMethodBeat.i(62094);
    int k = this.mVO.size();
    int j = 0;
    if (j < k)
    {
      e.a locala = (e.a)this.mVO.get(j);
      locala.mTy = paramInt;
      int i = paramInt;
      if (locala.mTz) {
        i = paramInt + 1;
      }
      if (locala.mTC.size() > 3) {
        if (locala.mTD)
        {
          i += 3;
          label85:
          locala.mTA = i;
          paramInt = i;
          if (locala.mTB) {
            paramInt = i + 1;
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i += locala.mTC.size();
        break label85;
        paramInt = i + locala.mTC.size();
        locala.mTA = paramInt;
      }
    }
    AppMethodBeat.o(62094);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.l
 * JD-Core Version:    0.7.0.1
 */