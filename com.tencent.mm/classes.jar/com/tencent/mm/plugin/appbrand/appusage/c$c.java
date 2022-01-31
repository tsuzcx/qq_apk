package com.tencent.mm.plugin.appbrand.appusage;

import a.aa;
import a.f.b.j;
import a.l;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$applyDiff$1$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-appbrand-integration_release"})
public final class c$c
  implements d
{
  c$c(c paramc, android.support.v7.h.c.b paramb, PInt paramPInt, List paramList, c.b paramb1, ArrayList paramArrayList) {}
  
  public final void C(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134491);
    Object localObject1 = this.haN;
    ((PInt)localObject1).value += paramInt2;
    ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onInserted position=" + paramInt1 + " count=" + paramInt2);
    label78:
    Object localObject2;
    if (paramInt1 + paramInt2 == this.haO.size())
    {
      localObject1 = null;
      paramInt2 = paramInt1 + paramInt2 - 1;
      if (paramInt1 > paramInt2) {
        break label216;
      }
      localObject2 = (LocalUsageInfo)this.haO.get(paramInt1);
      if (paramInt1 != 0) {
        break label196;
      }
    }
    label196:
    for (LocalUsageInfo localLocalUsageInfo = null;; localLocalUsageInfo = (LocalUsageInfo)this.haO.get(paramInt1 - 1))
    {
      Object localObject3 = this.haP;
      if (localObject3 != null) {
        ((c.b)localObject3).b((LocalUsageInfo)localObject2);
      }
      localObject3 = this.haL;
      z.a locala = z.hcx;
      localObject2 = c.a((LocalUsageInfo)localObject2);
      if (localObject2 == null) {
        j.ebi();
      }
      c.a((c)localObject3, z.a.a((cgb)localObject2, c.a(localLocalUsageInfo), c.a((LocalUsageInfo)localObject1)));
      if (paramInt1 == paramInt2) {
        break label216;
      }
      paramInt1 += 1;
      break label78;
      localObject1 = (LocalUsageInfo)this.haO.get(paramInt1 + paramInt2);
      break;
    }
    label216:
    AppMethodBeat.o(134491);
  }
  
  public final void D(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134492);
    Object localObject1 = this.haN;
    ((PInt)localObject1).value += paramInt2;
    ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onRemoved position=" + paramInt1 + " count=" + paramInt2);
    int i = paramInt1 + paramInt2 - 1;
    if (paramInt1 <= i)
    {
      paramInt2 = paramInt1;
      for (;;)
      {
        localObject1 = (LocalUsageInfo)this.haQ.remove(paramInt1);
        Object localObject2 = this.haP;
        if (localObject2 != null)
        {
          j.p(localObject1, "info");
          ((c.b)localObject2).d((LocalUsageInfo)localObject1);
        }
        localObject2 = this.haL;
        z.a locala = z.hcx;
        localObject1 = c.a((LocalUsageInfo)localObject1);
        if (localObject1 == null) {
          j.ebi();
        }
        c.a((c)localObject2, z.a.b((cgb)localObject1));
        if (paramInt2 == i) {
          break;
        }
        paramInt2 += 1;
      }
    }
    AppMethodBeat.o(134492);
  }
  
  public final void E(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(134493);
    Object localObject1 = this.haN;
    ((PInt)localObject1).value += 1;
    ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onMoved from " + paramInt1 + " to " + paramInt2);
    localObject1 = (LocalUsageInfo)this.haQ.remove(paramInt1);
    this.haQ.add(paramInt2, localObject1);
    localObject1 = this.haQ.get(paramInt2);
    j.p(localObject1, "tempList[toPosition]");
    Object localObject3 = (LocalUsageInfo)localObject1;
    label114:
    Object localObject4;
    if (paramInt2 == 0)
    {
      localObject1 = null;
      if (paramInt2 + 1 != this.haQ.size()) {
        break label243;
      }
      localObject4 = this.haP;
      if (localObject4 != null) {
        ((c.b)localObject4).c((LocalUsageInfo)localObject3);
      }
      localObject4 = this.haL;
      localObject5 = z.hcx;
      localObject3 = c.a((LocalUsageInfo)localObject3);
      if (localObject3 == null) {
        j.ebi();
      }
      localObject1 = c.a((LocalUsageInfo)localObject1);
      localObject2 = c.a((LocalUsageInfo)localObject2);
      j.q(localObject3, "self");
      if (!z.a.axE()) {
        break label266;
      }
      if ((localObject1 == null) && (localObject2 == null)) {
        break label261;
      }
    }
    label261:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((!aa.BMh) || (paramInt1 != 0)) {
        break label266;
      }
      localObject1 = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(134493);
      throw ((Throwable)localObject1);
      localObject1 = (LocalUsageInfo)this.haQ.get(paramInt2 - 1);
      break;
      label243:
      localObject2 = (LocalUsageInfo)this.haQ.get(paramInt2 + 1);
      break label114;
    }
    label266:
    Object localObject5 = new cgc();
    ((cgc)localObject5).xQO = ((cgb)localObject3);
    ((cgc)localObject5).xQR = 3;
    ((cgc)localObject5).xQP = ((cgb)localObject1);
    ((cgc)localObject5).xQQ = ((cgb)localObject2);
    c.a((c)localObject4, (cgc)localObject5);
    AppMethodBeat.o(134493);
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.c.c
 * JD-Core Version:    0.7.0.1
 */