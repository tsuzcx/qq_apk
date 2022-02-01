package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.eg;
import com.tencent.mm.autogen.a.su;
import com.tencent.mm.autogen.mmdata.rpt.gd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.s;

public final class o
{
  private gd ASu;
  IListener<su> qmS;
  IListener<eg> qmT;
  
  protected o()
  {
    AppMethodBeat.i(366797);
    this.ASu = new gd();
    this.qmT = new FinderRedDotTrigger.1(this, f.hfK);
    this.qmS = new FinderRedDotTrigger.2(this, f.hfK);
    AppMethodBeat.o(366797);
  }
  
  private static void TL(String paramString)
  {
    AppMethodBeat.i(366805);
    ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().TL(paramString);
    AppMethodBeat.o(366805);
  }
  
  private void a(int paramInt, bxq parambxq)
  {
    AppMethodBeat.i(366824);
    if ((parambxq == null) || (parambxq.aagu == null))
    {
      AppMethodBeat.o(366824);
      return;
    }
    try
    {
      Object localObject = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su(parambxq.path);
      gd localgd = this.ASu;
      localgd.ilm = paramInt;
      localgd = localgd.qS(parambxq.path);
      localgd.iKv = parambxq.aagx;
      localgd.iKw = parambxq.aagy;
      localgd.iKx = parambxq.aagu.ZlK;
      if (localObject != null) {}
      for (localObject = ((p)localObject).field_tipsId;; localObject = "")
      {
        localObject = localgd.qR((String)localObject);
        ((gd)localObject).iKy = parambxq.aagz;
        ((gd)localObject).iKz = cn.bDw();
        ((gd)localObject).bMH();
        AppMethodBeat.o(366824);
        return;
      }
      return;
    }
    catch (Exception parambxq)
    {
      AppMethodBeat.o(366824);
    }
  }
  
  private static int b(bxq parambxq)
  {
    AppMethodBeat.i(366813);
    if ((parambxq == null) || (parambxq.aagu == null))
    {
      AppMethodBeat.o(366813);
      return 0;
    }
    if ((parambxq.aagx <= 0) || (parambxq.aagy <= 0))
    {
      AppMethodBeat.o(366813);
      return 0;
    }
    try
    {
      Log.d("MicroMsg.FinderRedDotTrigger", "checkFinderTipsShowInfo path=%s [%d %d] strategy=%d", new Object[] { parambxq.path, Integer.valueOf(parambxq.aagu.ZlK), Integer.valueOf(parambxq.aagx), Integer.valueOf(parambxq.aagy) });
      int i = parambxq.aagu.ZlK;
      int j = parambxq.aagx;
      if (i < j)
      {
        AppMethodBeat.o(366813);
        return 0;
      }
      if (parambxq.aagu.ZlK >= parambxq.aagx)
      {
        i = parambxq.aagy;
        AppMethodBeat.o(366813);
        return i;
      }
    }
    catch (Exception parambxq)
    {
      AppMethodBeat.o(366813);
    }
    return 0;
  }
  
  final boolean avG(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(366862);
    i locali = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
    s.u(paramString, "path");
    p localp = locali.Su(paramString);
    bxq localbxq;
    Object localObject1;
    if (localp != null)
    {
      localbxq = localp.avK(paramString);
      if (localbxq == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label288;
        }
        if (localbxq != null) {
          break label241;
        }
        localObject1 = null;
        label70:
        if (((Integer)localObject1).intValue() <= 0) {
          break label288;
        }
        if (localbxq != null) {
          break label254;
        }
        localObject1 = null;
        label86:
        s.checkNotNull(localObject1);
        if (((adf)localObject1).ZlN != 0) {
          break label288;
        }
        long l1 = cn.getSyncServerTimeSecond();
        long l2 = localp.field_time / 1000L;
        if (localbxq != null) {
          break label264;
        }
        localObject1 = null;
        label123:
        if (l1 - l2 <= ((Long)localObject1).longValue()) {
          break label288;
        }
        if (localbxq != null) {
          break label278;
        }
        localObject1 = localObject2;
        label145:
        s.checkNotNull(localObject1);
        ((adf)localObject1).ZlN = 1;
        p.a(localp, (MAutoStorage)locali.AQt);
      }
    }
    label264:
    label278:
    label288:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        a(3, ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp(paramString));
      }
      Log.d("MicroMsg.FinderRedDotTrigger", "checkRedDotColdTimeExpiredWhenEnter path[%s] needSync[%b]", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(366862);
      return bool;
      localObject1 = localbxq.aagu;
      break;
      label241:
      localObject1 = Integer.valueOf(localbxq.aagz);
      break label70;
      label254:
      localObject1 = localbxq.aagu;
      break label86;
      localObject1 = Long.valueOf(localbxq.aagz);
      break label123;
      localObject1 = localbxq.aagu;
      break label145;
    }
  }
  
  final boolean avH(String paramString)
  {
    AppMethodBeat.i(366872);
    bxq localbxq = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp(paramString);
    int i = b(localbxq);
    if (i == 1) {
      a(1, localbxq);
    }
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.FinderRedDotTrigger", "checkRedDotExposeLimitWhenEnter path[%s] = strategy[%d] needSync[%b]", new Object[] { paramString, Integer.valueOf(i), Boolean.valueOf(bool) });
      AppMethodBeat.o(366872);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.o
 * JD-Core Version:    0.7.0.1
 */