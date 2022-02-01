package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends c
{
  List<chr> mVr;
  private SparseArray<com.tencent.mm.plugin.brandservice.ui.base.a> mVs;
  private int mVt;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5770);
    this.mVr = null;
    this.mVs = new SparseArray();
    setReporter(new c.b()
    {
      public final void a(c paramAnonymousc, com.tencent.mm.ui.base.sortview.a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(5769);
        pf localpf = g.this.xH(paramAnonymousInt3);
        paramAnonymousa = new StringBuilder().append(bt.nullAsNil(g.this.mTE)).append(",").append(paramAnonymousInt1).append(",").append(bt.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.mTM).append(",");
        if (localpf == null) {}
        for (paramAnonymousc = "";; paramAnonymousc = localpf.CNs + ",0")
        {
          paramAnonymousc = paramAnonymousc;
          h.vKh.kvStat(10866, paramAnonymousc);
          ad.d("MicroMsg.SearchOrRecommendBizAdapter", "report : ".concat(String.valueOf(paramAnonymousc)));
          AppMethodBeat.o(5769);
          return;
        }
      }
    });
    AppMethodBeat.o(5770);
  }
  
  public final void a(pf parampf, boolean paramBoolean)
  {
    AppMethodBeat.i(5772);
    super.a(parampf, paramBoolean);
    if (this.mVt == 0) {
      this.mVt = super.getCount();
    }
    AppMethodBeat.o(5772);
  }
  
  public final void bCw()
  {
    AppMethodBeat.i(5774);
    super.bCw();
    AppMethodBeat.o(5774);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(5773);
    int i = super.getCount();
    int j = i;
    if (i == 0)
    {
      j = i;
      if (this.mVr != null)
      {
        Iterator localIterator = this.mVr.iterator();
        if (localIterator.hasNext())
        {
          chr localchr = (chr)localIterator.next();
          if ((localchr == null) || (localchr.Edj == null)) {
            break label93;
          }
          i += localchr.Edj.size();
        }
      }
    }
    label93:
    for (;;)
    {
      break;
      j = i;
      AppMethodBeat.o(5773);
      return j;
    }
  }
  
  public final void m(String paramString, List<pf> paramList)
  {
    AppMethodBeat.i(5771);
    super.m(paramString, paramList);
    this.mVt = super.getCount();
    AppMethodBeat.o(5771);
  }
  
  public final Object[] xJ(int paramInt)
  {
    AppMethodBeat.i(5776);
    Object localObject2 = xG(paramInt);
    Object localObject1 = xH(paramInt);
    if (localObject2 != null)
    {
      localObject2 = ((c.a)localObject2).mTP;
      if (paramInt < this.mVt)
      {
        paramInt = 39;
        if (localObject1 == null) {
          break label83;
        }
      }
      label83:
      for (localObject1 = ((pf)localObject1).CNs;; localObject1 = "")
      {
        AppMethodBeat.o(5776);
        return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
        paramInt = 56;
        break;
      }
    }
    localObject1 = super.xJ(paramInt);
    AppMethodBeat.o(5776);
    return localObject1;
  }
  
  public final com.tencent.mm.ui.base.sortview.a xN(int paramInt)
  {
    AppMethodBeat.i(5775);
    int i = super.getCount();
    if (i != 0)
    {
      localObject1 = super.xN(paramInt);
      AppMethodBeat.o(5775);
      return localObject1;
    }
    Object localObject2 = (com.tencent.mm.plugin.brandservice.ui.base.a)this.mVs.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.mVr.size() > 0)
      {
        localObject1 = this.mVr.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label229;
        }
        localObject2 = (chr)((Iterator)localObject1).next();
        if (i != paramInt) {
          break label180;
        }
        if (((chr)localObject2).Edh != null) {
          break label168;
        }
        localObject1 = null;
        label110:
        cob localcob = (cob)((chr)localObject2).Edj.get(0);
        localObject2 = localObject1;
        localObject1 = localcob;
      }
    }
    for (;;)
    {
      localObject1 = new b(localObject1, (String)localObject2);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).xO(paramInt);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).setPosition(paramInt);
      this.mVs.put(paramInt, localObject1);
      AppMethodBeat.o(5775);
      return localObject1;
      label168:
      localObject1 = ((chr)localObject2).Edh.toString();
      break label110;
      label180:
      if (paramInt < ((chr)localObject2).Edj.size() + i)
      {
        localObject1 = (cob)((chr)localObject2).Edj.get(paramInt - i);
        localObject2 = null;
      }
      else
      {
        i = ((chr)localObject2).Edj.size() + i;
        break;
        label229:
        localObject2 = null;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.g
 * JD-Core Version:    0.7.0.1
 */