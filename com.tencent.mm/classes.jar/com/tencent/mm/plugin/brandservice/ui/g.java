package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends c
{
  List<cmu> nxR;
  private SparseArray<com.tencent.mm.plugin.brandservice.ui.base.a> nxS;
  private int nxT;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5770);
    this.nxR = null;
    this.nxS = new SparseArray();
    setReporter(new c.b()
    {
      public final void a(c paramAnonymousc, com.tencent.mm.ui.base.sortview.a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(5769);
        pm localpm = g.this.yz(paramAnonymousInt3);
        paramAnonymousa = new StringBuilder().append(bs.nullAsNil(g.this.nvW)).append(",").append(paramAnonymousInt1).append(",").append(bs.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.nwe).append(",");
        if (localpm == null) {}
        for (paramAnonymousc = "";; paramAnonymousc = localpm.EfU + ",0")
        {
          paramAnonymousc = paramAnonymousc;
          h.wUl.kvStat(10866, paramAnonymousc);
          ac.d("MicroMsg.SearchOrRecommendBizAdapter", "report : ".concat(String.valueOf(paramAnonymousc)));
          AppMethodBeat.o(5769);
          return;
        }
      }
    });
    AppMethodBeat.o(5770);
  }
  
  public final void a(pm parampm, boolean paramBoolean)
  {
    AppMethodBeat.i(5772);
    super.a(parampm, paramBoolean);
    if (this.nxT == 0) {
      this.nxT = super.getCount();
    }
    AppMethodBeat.o(5772);
  }
  
  public final void bJz()
  {
    AppMethodBeat.i(5774);
    super.bJz();
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
      if (this.nxR != null)
      {
        Iterator localIterator = this.nxR.iterator();
        if (localIterator.hasNext())
        {
          cmu localcmu = (cmu)localIterator.next();
          if ((localcmu == null) || (localcmu.FAf == null)) {
            break label93;
          }
          i += localcmu.FAf.size();
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
  
  public final void k(String paramString, List<pm> paramList)
  {
    AppMethodBeat.i(5771);
    super.k(paramString, paramList);
    this.nxT = super.getCount();
    AppMethodBeat.o(5771);
  }
  
  public final Object[] yB(int paramInt)
  {
    AppMethodBeat.i(5776);
    Object localObject2 = yy(paramInt);
    Object localObject1 = yz(paramInt);
    if (localObject2 != null)
    {
      localObject2 = ((c.a)localObject2).nwh;
      if (paramInt < this.nxT)
      {
        paramInt = 39;
        if (localObject1 == null) {
          break label83;
        }
      }
      label83:
      for (localObject1 = ((pm)localObject1).EfU;; localObject1 = "")
      {
        AppMethodBeat.o(5776);
        return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
        paramInt = 56;
        break;
      }
    }
    localObject1 = super.yB(paramInt);
    AppMethodBeat.o(5776);
    return localObject1;
  }
  
  public final com.tencent.mm.ui.base.sortview.a yE(int paramInt)
  {
    AppMethodBeat.i(5775);
    int i = super.getCount();
    if (i != 0)
    {
      localObject1 = super.yE(paramInt);
      AppMethodBeat.o(5775);
      return localObject1;
    }
    Object localObject2 = (com.tencent.mm.plugin.brandservice.ui.base.a)this.nxS.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.nxR.size() > 0)
      {
        localObject1 = this.nxR.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label229;
        }
        localObject2 = (cmu)((Iterator)localObject1).next();
        if (i != paramInt) {
          break label180;
        }
        if (((cmu)localObject2).FAd != null) {
          break label168;
        }
        localObject1 = null;
        label110:
        cti localcti = (cti)((cmu)localObject2).FAf.get(0);
        localObject2 = localObject1;
        localObject1 = localcti;
      }
    }
    for (;;)
    {
      localObject1 = new b(localObject1, (String)localObject2);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).yF(paramInt);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).setPosition(paramInt);
      this.nxS.put(paramInt, localObject1);
      AppMethodBeat.o(5775);
      return localObject1;
      label168:
      localObject1 = ((cmu)localObject2).FAd.toString();
      break label110;
      label180:
      if (paramInt < ((cmu)localObject2).FAf.size() + i)
      {
        localObject1 = (cti)((cmu)localObject2).FAf.get(paramInt - i);
        localObject2 = null;
      }
      else
      {
        i = ((cmu)localObject2).FAf.size() + i;
        break;
        label229:
        localObject2 = null;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.g
 * JD-Core Version:    0.7.0.1
 */