package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends c
{
  List<crx> nZp;
  private SparseArray<com.tencent.mm.plugin.brandservice.ui.base.a> nZq;
  private int nZr;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5770);
    this.nZp = null;
    this.nZq = new SparseArray();
    setReporter(new c.b()
    {
      public final void a(c paramAnonymousc, com.tencent.mm.ui.base.sortview.a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(5769);
        qr localqr = g.this.zj(paramAnonymousInt3);
        paramAnonymousa = new StringBuilder().append(bt.nullAsNil(g.this.nXu)).append(",").append(paramAnonymousInt1).append(",").append(bt.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.nXC).append(",");
        if (localqr == null) {}
        for (paramAnonymousc = "";; paramAnonymousc = localqr.FMt + ",0")
        {
          paramAnonymousc = paramAnonymousc;
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10866, paramAnonymousc);
          ad.d("MicroMsg.SearchOrRecommendBizAdapter", "report : ".concat(String.valueOf(paramAnonymousc)));
          AppMethodBeat.o(5769);
          return;
        }
      }
    });
    AppMethodBeat.o(5770);
  }
  
  public final void a(qr paramqr, boolean paramBoolean)
  {
    AppMethodBeat.i(5772);
    super.a(paramqr, paramBoolean);
    if (this.nZr == 0) {
      this.nZr = super.getCount();
    }
    AppMethodBeat.o(5772);
  }
  
  public final void bNS()
  {
    AppMethodBeat.i(5774);
    super.bNS();
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
      if (this.nZp != null)
      {
        Iterator localIterator = this.nZp.iterator();
        if (localIterator.hasNext())
        {
          crx localcrx = (crx)localIterator.next();
          if ((localcrx == null) || (localcrx.Hkt == null)) {
            break label93;
          }
          i += localcrx.Hkt.size();
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
  
  public final void l(String paramString, List<qr> paramList)
  {
    AppMethodBeat.i(5771);
    super.l(paramString, paramList);
    this.nZr = super.getCount();
    AppMethodBeat.o(5771);
  }
  
  public final Object[] zl(int paramInt)
  {
    AppMethodBeat.i(5776);
    Object localObject2 = zi(paramInt);
    Object localObject1 = zj(paramInt);
    if (localObject2 != null)
    {
      localObject2 = ((c.a)localObject2).nXF;
      if (paramInt < this.nZr)
      {
        paramInt = 39;
        if (localObject1 == null) {
          break label83;
        }
      }
      label83:
      for (localObject1 = ((qr)localObject1).FMt;; localObject1 = "")
      {
        AppMethodBeat.o(5776);
        return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
        paramInt = 56;
        break;
      }
    }
    localObject1 = super.zl(paramInt);
    AppMethodBeat.o(5776);
    return localObject1;
  }
  
  public final com.tencent.mm.ui.base.sortview.a zo(int paramInt)
  {
    AppMethodBeat.i(5775);
    int i = super.getCount();
    if (i != 0)
    {
      localObject1 = super.zo(paramInt);
      AppMethodBeat.o(5775);
      return localObject1;
    }
    Object localObject2 = (com.tencent.mm.plugin.brandservice.ui.base.a)this.nZq.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.nZp.size() > 0)
      {
        localObject1 = this.nZp.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label229;
        }
        localObject2 = (crx)((Iterator)localObject1).next();
        if (i != paramInt) {
          break label180;
        }
        if (((crx)localObject2).Hkr != null) {
          break label168;
        }
        localObject1 = null;
        label110:
        cys localcys = (cys)((crx)localObject2).Hkt.get(0);
        localObject2 = localObject1;
        localObject1 = localcys;
      }
    }
    for (;;)
    {
      localObject1 = new b(localObject1, (String)localObject2);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).zp(paramInt);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).setPosition(paramInt);
      this.nZq.put(paramInt, localObject1);
      AppMethodBeat.o(5775);
      return localObject1;
      label168:
      localObject1 = ((crx)localObject2).Hkr.toString();
      break label110;
      label180:
      if (paramInt < ((crx)localObject2).Hkt.size() + i)
      {
        localObject1 = (cys)((crx)localObject2).Hkt.get(paramInt - i);
        localObject2 = null;
      }
      else
      {
        i = ((crx)localObject2).Hkt.size() + i;
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