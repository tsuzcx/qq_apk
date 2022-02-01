package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.enn;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ewa;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends c
{
  List<enn> vEC;
  private SparseArray<com.tencent.mm.plugin.brandservice.ui.base.a> vED;
  private int vEE;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5770);
    this.vEC = null;
    this.vED = new SparseArray();
    setReporter(new c.b()
    {
      public final void a(c paramAnonymousc, com.tencent.mm.ui.base.sortview.a paramAnonymousa, int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(5769);
        sy localsy = h.this.Hc(paramAnonymousInt3);
        paramAnonymousa = new StringBuilder().append(Util.nullAsNil(h.this.vCH)).append(",").append(paramAnonymousInt1).append(",").append(Util.nullAsNil(paramAnonymousString)).append(",").append(paramAnonymousInt2).append(",").append(paramAnonymousc.vCP).append(",");
        if (localsy == null) {}
        for (paramAnonymousc = "";; paramAnonymousc = localsy.YYr + ",0")
        {
          paramAnonymousc = paramAnonymousc;
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10866, paramAnonymousc);
          Log.d("MicroMsg.SearchOrRecommendBizAdapter", "report : ".concat(String.valueOf(paramAnonymousc)));
          AppMethodBeat.o(5769);
          return;
        }
      }
    });
    AppMethodBeat.o(5770);
  }
  
  public final Object[] He(int paramInt)
  {
    AppMethodBeat.i(5776);
    Object localObject2 = Hb(paramInt);
    Object localObject1 = Hc(paramInt);
    if (localObject2 != null)
    {
      localObject2 = ((c.a)localObject2).vCS;
      if (paramInt < this.vEE)
      {
        paramInt = 39;
        if (localObject1 == null) {
          break label83;
        }
      }
      label83:
      for (localObject1 = ((sy)localObject1).YYr;; localObject1 = "")
      {
        AppMethodBeat.o(5776);
        return new Object[] { this, localObject2, Integer.valueOf(paramInt), localObject1 };
        paramInt = 56;
        break;
      }
    }
    localObject1 = super.He(paramInt);
    AppMethodBeat.o(5776);
    return localObject1;
  }
  
  public final com.tencent.mm.ui.base.sortview.a Hh(int paramInt)
  {
    AppMethodBeat.i(5775);
    int i = super.getCount();
    if (i != 0)
    {
      localObject1 = super.Hh(paramInt);
      AppMethodBeat.o(5775);
      return localObject1;
    }
    Object localObject2 = (com.tencent.mm.plugin.brandservice.ui.base.a)this.vED.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.vEC.size() > 0)
      {
        localObject1 = this.vEC.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label229;
        }
        localObject2 = (enn)((Iterator)localObject1).next();
        if (i != paramInt) {
          break label180;
        }
        if (((enn)localObject2).abrZ != null) {
          break label168;
        }
        localObject1 = null;
        label110:
        ewa localewa = (ewa)((enn)localObject2).absb.get(0);
        localObject2 = localObject1;
        localObject1 = localewa;
      }
    }
    for (;;)
    {
      localObject1 = new b(localObject1, (String)localObject2);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).Hi(paramInt);
      ((com.tencent.mm.plugin.brandservice.ui.base.a)localObject1).setPosition(paramInt);
      this.vED.put(paramInt, localObject1);
      AppMethodBeat.o(5775);
      return localObject1;
      label168:
      localObject1 = ((enn)localObject2).abrZ.toString();
      break label110;
      label180:
      if (paramInt < ((enn)localObject2).absb.size() + i)
      {
        localObject1 = (ewa)((enn)localObject2).absb.get(paramInt - i);
        localObject2 = null;
      }
      else
      {
        i = ((enn)localObject2).absb.size() + i;
        break;
        label229:
        localObject2 = null;
        localObject1 = null;
      }
    }
  }
  
  public final void a(sy paramsy, boolean paramBoolean)
  {
    AppMethodBeat.i(5772);
    super.a(paramsy, paramBoolean);
    if (this.vEE == 0) {
      this.vEE = super.getCount();
    }
    AppMethodBeat.o(5772);
  }
  
  public final void dcr()
  {
    AppMethodBeat.i(5774);
    super.dcr();
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
      if (this.vEC != null)
      {
        Iterator localIterator = this.vEC.iterator();
        if (localIterator.hasNext())
        {
          enn localenn = (enn)localIterator.next();
          if ((localenn == null) || (localenn.absb == null)) {
            break label93;
          }
          i += localenn.absb.size();
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
  
  public final void r(String paramString, List<sy> paramList)
  {
    AppMethodBeat.i(5771);
    super.r(paramString, paramList);
    this.vEE = super.getCount();
    AppMethodBeat.o(5771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.h
 * JD-Core Version:    0.7.0.1
 */