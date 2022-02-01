package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dup;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends c
{
  List<dup> syV;
  private SparseArray<com.tencent.mm.plugin.brandservice.ui.base.a> syW;
  private int syX;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5770);
    this.syV = null;
    this.syW = new SparseArray();
    setReporter(new c.b()
    {
      public final void a(c paramAnonymousc, com.tencent.mm.ui.base.sortview.a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(5769);
        rn localrn = g.this.GD(paramAnonymousInt3);
        paramAnonymousa = new StringBuilder().append(Util.nullAsNil(g.this.sxa)).append(",").append(paramAnonymousInt1).append(",").append(Util.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.sxi).append(",");
        if (localrn == null) {}
        for (paramAnonymousc = "";; paramAnonymousc = localrn.Sas + ",0")
        {
          paramAnonymousc = paramAnonymousc;
          h.IzE.kvStat(10866, paramAnonymousc);
          Log.d("MicroMsg.SearchOrRecommendBizAdapter", "report : ".concat(String.valueOf(paramAnonymousc)));
          AppMethodBeat.o(5769);
          return;
        }
      }
    });
    AppMethodBeat.o(5770);
  }
  
  public final Object[] GF(int paramInt)
  {
    AppMethodBeat.i(5776);
    Object localObject2 = GC(paramInt);
    Object localObject1 = GD(paramInt);
    if (localObject2 != null)
    {
      localObject2 = ((c.a)localObject2).sxl;
      if (paramInt < this.syX)
      {
        paramInt = 39;
        if (localObject1 == null) {
          break label83;
        }
      }
      label83:
      for (localObject1 = ((rn)localObject1).Sas;; localObject1 = "")
      {
        AppMethodBeat.o(5776);
        return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
        paramInt = 56;
        break;
      }
    }
    localObject1 = super.GF(paramInt);
    AppMethodBeat.o(5776);
    return localObject1;
  }
  
  public final com.tencent.mm.ui.base.sortview.a GI(int paramInt)
  {
    AppMethodBeat.i(5775);
    int i = super.getCount();
    if (i != 0)
    {
      localObject1 = super.GI(paramInt);
      AppMethodBeat.o(5775);
      return localObject1;
    }
    Object localObject2 = (com.tencent.mm.plugin.brandservice.ui.base.a)this.syW.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.syV.size() > 0)
      {
        localObject1 = this.syV.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label229;
        }
        localObject2 = (dup)((Iterator)localObject1).next();
        if (i != paramInt) {
          break label180;
        }
        if (((dup)localObject2).UaS != null) {
          break label168;
        }
        localObject1 = null;
        label110:
        ecj localecj = (ecj)((dup)localObject2).UaU.get(0);
        localObject2 = localObject1;
        localObject1 = localecj;
      }
    }
    for (;;)
    {
      localObject1 = new b(localObject1, (String)localObject2);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).GJ(paramInt);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).setPosition(paramInt);
      this.syW.put(paramInt, localObject1);
      AppMethodBeat.o(5775);
      return localObject1;
      label168:
      localObject1 = ((dup)localObject2).UaS.toString();
      break label110;
      label180:
      if (paramInt < ((dup)localObject2).UaU.size() + i)
      {
        localObject1 = (ecj)((dup)localObject2).UaU.get(paramInt - i);
        localObject2 = null;
      }
      else
      {
        i = ((dup)localObject2).UaU.size() + i;
        break;
        label229:
        localObject2 = null;
        localObject1 = null;
      }
    }
  }
  
  public final void a(rn paramrn, boolean paramBoolean)
  {
    AppMethodBeat.i(5772);
    super.a(paramrn, paramBoolean);
    if (this.syX == 0) {
      this.syX = super.getCount();
    }
    AppMethodBeat.o(5772);
  }
  
  public final void czz()
  {
    AppMethodBeat.i(5774);
    super.czz();
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
      if (this.syV != null)
      {
        Iterator localIterator = this.syV.iterator();
        if (localIterator.hasNext())
        {
          dup localdup = (dup)localIterator.next();
          if ((localdup == null) || (localdup.UaU == null)) {
            break label93;
          }
          i += localdup.UaU.size();
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
  
  public final void m(String paramString, List<rn> paramList)
  {
    AppMethodBeat.i(5771);
    super.m(paramString, paramList);
    this.syX = super.getCount();
    AppMethodBeat.o(5771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.g
 * JD-Core Version:    0.7.0.1
 */