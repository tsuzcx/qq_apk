package com.tencent.mm.plugin.finder.extension.reddot;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nk;
import com.tencent.mm.autogen.a.nk.a;
import com.tencent.mm.autogen.mmdata.rpt.df;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

class FinderDynamicTimeHelper$3
  extends IListener<nk>
{
  FinderDynamicTimeHelper$3(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(366660);
    this.__eventId = nk.class.getName().hashCode();
    AppMethodBeat.o(366660);
  }
  
  private boolean a(nk paramnk)
  {
    AppMethodBeat.i(366681);
    if ((paramnk == null) || (paramnk.hPM == null))
    {
      AppMethodBeat.o(366681);
      return false;
    }
    if (!this.APM.APG)
    {
      AppMethodBeat.o(366681);
      return false;
    }
    a locala;
    if (paramnk.hPM.hPN == 19943L)
    {
      locala = this.APM;
      paramnk = paramnk.hPM.content;
      if (!Util.isNullOrNil(paramnk))
      {
        paramnk = paramnk.split(",");
        if ((paramnk != null) && (paramnk.length >= 5)) {
          break label99;
        }
      }
    }
    label99:
    do
    {
      AppMethodBeat.o(366681);
      return false;
      localObject = paramnk[1];
    } while ((!"143".equals(paramnk[6])) || (!"All".equals(localObject)));
    long l1 = locala.APH;
    Object localObject = new PBool();
    long l2 = Util.getLong(paramnk[2], 0L);
    long l3 = l2 / 1000L + 1L;
    label217:
    label222:
    df localdf;
    if (locala.APB != null)
    {
      if (l3 > locala.z) {
        break label548;
      }
      if (locala.APD > 0)
      {
        locala.APC = 0;
        locala.APD = 0;
        locala.APH = locala.p;
        ((PBool)localObject).value = true;
        locala.sz();
      }
    }
    else
    {
      localdf = locala.APA;
      localdf.iza = l1;
      localdf.izb = locala.APH;
      localdf.iyZ = localdf.F("ConfigJson", locala.APF.replaceAll(",", ";"), true);
      localdf = localdf.eF(l2);
      localdf.ijk = localdf.F("SessionId", paramnk[0], true);
      localdf = localdf.eG(Util.getLong(paramnk[4], 0L));
      if (locala.APB == null) {
        break label735;
      }
      paramnk = locala.APB.field_tipsId;
      label326:
      localdf.ikf = localdf.F("TipsId", paramnk, true);
      if (locala.APB == null) {
        break label742;
      }
      i = locala.APB.field_ctrType;
      label357:
      localdf.iyT = i;
      localdf.iyY = locala.APD;
      localdf.iyX = locala.APC;
      if (!((PBool)localObject).value) {
        break label747;
      }
    }
    label548:
    label735:
    label742:
    label747:
    for (int i = 1;; i = 0)
    {
      localdf.izd = i;
      localdf.bMH();
      a.showDebugToast(locala.APA.aIF());
      break;
      ((PBool)localObject).value = false;
      locala.APC += 1;
      l3 = (locala.APJ * ((1.0D - Math.pow(locala.q, locala.APC)) / (1.0D - locala.q)));
      locala.APH = (locala.p + l3);
      locala.APH = Math.min(locala.APH, locala.m);
      Log.i("MicroMsg.FinderDynamicTimeHelper", "drop redDotDynamicTime[%d] sn[%d] dropRedDotCount[%d]", new Object[] { Long.valueOf(locala.APH), Long.valueOf(l3), Integer.valueOf(locala.APC) });
      break label217;
      if (l3 < locala.o) {
        break label222;
      }
      if (locala.APC > 0)
      {
        locala.APD = 0;
        locala.APC = 0;
        locala.APH = locala.p;
        ((PBool)localObject).value = true;
      }
      for (;;)
      {
        locala.sz();
        break;
        ((PBool)localObject).value = false;
        locala.APD += 1;
        l3 = (locala.APK * ((1.0D - Math.pow(locala.q, locala.APD)) / (1.0D - locala.q)));
        locala.APH = (locala.p - l3);
        locala.APH = Math.max(locala.APH, locala.n);
        Log.i("MicroMsg.FinderDynamicTimeHelper", "deepRead redDotDynamicTime[%d] sn[%d] dropRedDotCount[%d]", new Object[] { Long.valueOf(locala.APH), Long.valueOf(l3), Integer.valueOf(locala.APD) });
      }
      paramnk = "";
      break label326;
      i = 0;
      break label357;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.FinderDynamicTimeHelper.3
 * JD-Core Version:    0.7.0.1
 */