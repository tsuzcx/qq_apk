package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.czm;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends c
{
  List<csr> oeY;
  private SparseArray<com.tencent.mm.plugin.brandservice.ui.base.a> oeZ;
  private int ofa;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5770);
    this.oeY = null;
    this.oeZ = new SparseArray();
    setReporter(new c.b()
    {
      public final void a(c paramAnonymousc, com.tencent.mm.ui.base.sortview.a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(5769);
        qt localqt = g.this.zs(paramAnonymousInt3);
        paramAnonymousa = new StringBuilder().append(bu.nullAsNil(g.this.odd)).append(",").append(paramAnonymousInt1).append(",").append(bu.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.odl).append(",");
        if (localqt == null) {}
        for (paramAnonymousc = "";; paramAnonymousc = localqt.GeS + ",0")
        {
          paramAnonymousc = paramAnonymousc;
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10866, paramAnonymousc);
          ae.d("MicroMsg.SearchOrRecommendBizAdapter", "report : ".concat(String.valueOf(paramAnonymousc)));
          AppMethodBeat.o(5769);
          return;
        }
      }
    });
    AppMethodBeat.o(5770);
  }
  
  public final void a(qt paramqt, boolean paramBoolean)
  {
    AppMethodBeat.i(5772);
    super.a(paramqt, paramBoolean);
    if (this.ofa == 0) {
      this.ofa = super.getCount();
    }
    AppMethodBeat.o(5772);
  }
  
  public final void bOP()
  {
    AppMethodBeat.i(5774);
    super.bOP();
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
      if (this.oeY != null)
      {
        Iterator localIterator = this.oeY.iterator();
        if (localIterator.hasNext())
        {
          csr localcsr = (csr)localIterator.next();
          if ((localcsr == null) || (localcsr.HDT == null)) {
            break label93;
          }
          i += localcsr.HDT.size();
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
  
  public final void l(String paramString, List<qt> paramList)
  {
    AppMethodBeat.i(5771);
    super.l(paramString, paramList);
    this.ofa = super.getCount();
    AppMethodBeat.o(5771);
  }
  
  public final Object[] zu(int paramInt)
  {
    AppMethodBeat.i(5776);
    Object localObject2 = zr(paramInt);
    Object localObject1 = zs(paramInt);
    if (localObject2 != null)
    {
      localObject2 = ((c.a)localObject2).odo;
      if (paramInt < this.ofa)
      {
        paramInt = 39;
        if (localObject1 == null) {
          break label83;
        }
      }
      label83:
      for (localObject1 = ((qt)localObject1).GeS;; localObject1 = "")
      {
        AppMethodBeat.o(5776);
        return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
        paramInt = 56;
        break;
      }
    }
    localObject1 = super.zu(paramInt);
    AppMethodBeat.o(5776);
    return localObject1;
  }
  
  public final com.tencent.mm.ui.base.sortview.a zx(int paramInt)
  {
    AppMethodBeat.i(5775);
    int i = super.getCount();
    if (i != 0)
    {
      localObject1 = super.zx(paramInt);
      AppMethodBeat.o(5775);
      return localObject1;
    }
    Object localObject2 = (com.tencent.mm.plugin.brandservice.ui.base.a)this.oeZ.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.oeY.size() > 0)
      {
        localObject1 = this.oeY.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label229;
        }
        localObject2 = (csr)((Iterator)localObject1).next();
        if (i != paramInt) {
          break label180;
        }
        if (((csr)localObject2).HDR != null) {
          break label168;
        }
        localObject1 = null;
        label110:
        czm localczm = (czm)((csr)localObject2).HDT.get(0);
        localObject2 = localObject1;
        localObject1 = localczm;
      }
    }
    for (;;)
    {
      localObject1 = new b(localObject1, (String)localObject2);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).zy(paramInt);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).setPosition(paramInt);
      this.oeZ.put(paramInt, localObject1);
      AppMethodBeat.o(5775);
      return localObject1;
      label168:
      localObject1 = ((csr)localObject2).HDR.toString();
      break label110;
      label180:
      if (paramInt < ((csr)localObject2).HDT.size() + i)
      {
        localObject1 = (czm)((csr)localObject2).HDT.get(paramInt - i);
        localObject2 = null;
      }
      else
      {
        i = ((csr)localObject2).HDT.size() + i;
        break;
        label229:
        localObject2 = null;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.g
 * JD-Core Version:    0.7.0.1
 */