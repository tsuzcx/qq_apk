package com.tencent.mm.plugin.appbrand.appusage;

import a.d.b.g;
import a.p;
import android.support.v7.g.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.bvi;
import com.tencent.mm.protocal.c.bvj;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class c$c
  implements d
{
  c$c(c paramc, android.support.v7.g.c.b paramb, PInt paramPInt, List paramList, c.b paramb1, ArrayList paramArrayList) {}
  
  public final void A(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.fHV;
    ((PInt)localObject1).value += paramInt2;
    y.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onRemoved position=" + paramInt1 + " count=" + paramInt2);
    int i = paramInt1 + paramInt2 - 1;
    if (paramInt1 <= i)
    {
      paramInt2 = paramInt1;
      for (;;)
      {
        localObject1 = (LocalUsageInfo)this.fHY.remove(paramInt1);
        Object localObject2 = this.fHX;
        if (localObject2 != null)
        {
          g.j(localObject1, "info");
          ((c.b)localObject2).d((LocalUsageInfo)localObject1);
        }
        localObject2 = this.fHT;
        z.a locala = z.fJE;
        localObject1 = c.a((LocalUsageInfo)localObject1);
        if (localObject1 == null) {
          g.cUk();
        }
        c.a((c)localObject2, z.a.b((bvi)localObject1));
        if (paramInt2 == i) {
          break;
        }
        paramInt2 += 1;
      }
    }
  }
  
  public final void B(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = this.fHV;
    ((PInt)localObject1).value += 1;
    y.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onMoved from " + paramInt1 + " to " + paramInt2);
    localObject1 = (LocalUsageInfo)this.fHY.remove(paramInt1);
    this.fHY.add(paramInt2, localObject1);
    Object localObject3 = (LocalUsageInfo)this.fHY.get(paramInt2);
    label101:
    Object localObject4;
    if (paramInt2 == 0)
    {
      localObject1 = null;
      if (paramInt2 + 1 != this.fHY.size()) {
        break label230;
      }
      localObject4 = this.fHX;
      if (localObject4 != null)
      {
        g.j(localObject3, "self");
        ((c.b)localObject4).c((LocalUsageInfo)localObject3);
      }
      localObject4 = this.fHT;
      localObject5 = z.fJE;
      localObject3 = c.a((LocalUsageInfo)localObject3);
      if (localObject3 == null) {
        g.cUk();
      }
      localObject1 = c.a((LocalUsageInfo)localObject1);
      localObject2 = c.a((LocalUsageInfo)localObject2);
      g.k(localObject3, "self");
      if (!z.a.adx()) {
        break label253;
      }
      if ((localObject1 == null) && (localObject2 == null)) {
        break label248;
      }
    }
    label230:
    label248:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((!p.xoi) || (paramInt1 != 0)) {
        break label253;
      }
      throw ((Throwable)new AssertionError("Assertion failed"));
      localObject1 = (LocalUsageInfo)this.fHY.get(paramInt2 - 1);
      break;
      localObject2 = (LocalUsageInfo)this.fHY.get(paramInt2 + 1);
      break label101;
    }
    label253:
    Object localObject5 = new bvj();
    ((bvj)localObject5).tMc = ((bvi)localObject3);
    ((bvj)localObject5).tMf = 3;
    ((bvj)localObject5).tMd = ((bvi)localObject1);
    ((bvj)localObject5).tMe = ((bvi)localObject2);
    c.a((c)localObject4, (bvj)localObject5);
  }
  
  public final void a(int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void z(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.fHV;
    ((PInt)localObject1).value += paramInt2;
    y.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onInserted position=" + paramInt1 + " count=" + paramInt2);
    label73:
    Object localObject2;
    if (paramInt1 + paramInt2 == this.fHW.size())
    {
      localObject1 = null;
      paramInt2 = paramInt1 + paramInt2 - 1;
      if (paramInt1 > paramInt2) {
        return;
      }
      localObject2 = (LocalUsageInfo)this.fHW.get(paramInt1);
      if (paramInt1 != 0) {
        break label191;
      }
    }
    label191:
    for (LocalUsageInfo localLocalUsageInfo = null;; localLocalUsageInfo = (LocalUsageInfo)this.fHW.get(paramInt1 - 1))
    {
      Object localObject3 = this.fHX;
      if (localObject3 != null) {
        ((c.b)localObject3).b((LocalUsageInfo)localObject2);
      }
      localObject3 = this.fHT;
      z.a locala = z.fJE;
      localObject2 = c.a((LocalUsageInfo)localObject2);
      if (localObject2 == null) {
        g.cUk();
      }
      c.a((c)localObject3, z.a.a((bvi)localObject2, c.a(localLocalUsageInfo), c.a((LocalUsageInfo)localObject1)));
      if (paramInt1 == paramInt2) {
        return;
      }
      paramInt1 += 1;
      break label73;
      localObject1 = (LocalUsageInfo)this.fHW.get(paramInt1 + paramInt2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.c.c
 * JD-Core Version:    0.7.0.1
 */