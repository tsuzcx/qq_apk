package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends c
{
  List<dkz> ppW;
  private SparseArray<com.tencent.mm.plugin.brandservice.ui.base.a> ppX;
  private int ppY;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5770);
    this.ppW = null;
    this.ppX = new SparseArray();
    setReporter(new c.b()
    {
      public final void a(c paramAnonymousc, com.tencent.mm.ui.base.sortview.a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(5769);
        ru localru = g.this.CX(paramAnonymousInt3);
        paramAnonymousa = new StringBuilder().append(Util.nullAsNil(g.this.poa)).append(",").append(paramAnonymousInt1).append(",").append(Util.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.poi).append(",");
        if (localru == null) {}
        for (paramAnonymousc = "";; paramAnonymousc = localru.KZj + ",0")
        {
          paramAnonymousc = paramAnonymousc;
          h.CyF.kvStat(10866, paramAnonymousc);
          Log.d("MicroMsg.SearchOrRecommendBizAdapter", "report : ".concat(String.valueOf(paramAnonymousc)));
          AppMethodBeat.o(5769);
          return;
        }
      }
    });
    AppMethodBeat.o(5770);
  }
  
  public final Object[] CZ(int paramInt)
  {
    AppMethodBeat.i(5776);
    Object localObject2 = CW(paramInt);
    Object localObject1 = CX(paramInt);
    if (localObject2 != null)
    {
      localObject2 = ((c.a)localObject2).pol;
      if (paramInt < this.ppY)
      {
        paramInt = 39;
        if (localObject1 == null) {
          break label83;
        }
      }
      label83:
      for (localObject1 = ((ru)localObject1).KZj;; localObject1 = "")
      {
        AppMethodBeat.o(5776);
        return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
        paramInt = 56;
        break;
      }
    }
    localObject1 = super.CZ(paramInt);
    AppMethodBeat.o(5776);
    return localObject1;
  }
  
  public final com.tencent.mm.ui.base.sortview.a Dc(int paramInt)
  {
    AppMethodBeat.i(5775);
    int i = super.getCount();
    if (i != 0)
    {
      localObject1 = super.Dc(paramInt);
      AppMethodBeat.o(5775);
      return localObject1;
    }
    Object localObject2 = (com.tencent.mm.plugin.brandservice.ui.base.a)this.ppX.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.ppW.size() > 0)
      {
        localObject1 = this.ppW.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label229;
        }
        localObject2 = (dkz)((Iterator)localObject1).next();
        if (i != paramInt) {
          break label180;
        }
        if (((dkz)localObject2).MOT != null) {
          break label168;
        }
        localObject1 = null;
        label110:
        dsn localdsn = (dsn)((dkz)localObject2).MOV.get(0);
        localObject2 = localObject1;
        localObject1 = localdsn;
      }
    }
    for (;;)
    {
      localObject1 = new b(localObject1, (String)localObject2);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).Dd(paramInt);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).setPosition(paramInt);
      this.ppX.put(paramInt, localObject1);
      AppMethodBeat.o(5775);
      return localObject1;
      label168:
      localObject1 = ((dkz)localObject2).MOT.toString();
      break label110;
      label180:
      if (paramInt < ((dkz)localObject2).MOV.size() + i)
      {
        localObject1 = (dsn)((dkz)localObject2).MOV.get(paramInt - i);
        localObject2 = null;
      }
      else
      {
        i = ((dkz)localObject2).MOV.size() + i;
        break;
        label229:
        localObject2 = null;
        localObject1 = null;
      }
    }
  }
  
  public final void a(ru paramru, boolean paramBoolean)
  {
    AppMethodBeat.i(5772);
    super.a(paramru, paramBoolean);
    if (this.ppY == 0) {
      this.ppY = super.getCount();
    }
    AppMethodBeat.o(5772);
  }
  
  public final void clV()
  {
    AppMethodBeat.i(5774);
    super.clV();
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
      if (this.ppW != null)
      {
        Iterator localIterator = this.ppW.iterator();
        if (localIterator.hasNext())
        {
          dkz localdkz = (dkz)localIterator.next();
          if ((localdkz == null) || (localdkz.MOV == null)) {
            break label93;
          }
          i += localdkz.MOV.size();
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
  
  public final void m(String paramString, List<ru> paramList)
  {
    AppMethodBeat.i(5771);
    super.m(paramString, paramList);
    this.ppY = super.getCount();
    AppMethodBeat.o(5771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.g
 * JD-Core Version:    0.7.0.1
 */