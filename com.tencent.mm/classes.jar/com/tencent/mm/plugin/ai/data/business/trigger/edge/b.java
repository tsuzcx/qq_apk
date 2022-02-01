package com.tencent.mm.plugin.ai.data.business.trigger.edge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.eg;
import com.tencent.mm.autogen.a.eg.a;
import com.tencent.mm.autogen.mmdata.rpt.ah;
import com.tencent.mm.autogen.mmdata.rpt.ai;
import com.tencent.mm.autogen.mmdata.rpt.bm;
import com.tencent.mm.autogen.mmdata.rpt.bn;
import com.tencent.mm.plugin.ai.d.d;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.extension.reddot.q;
import com.tencent.mm.pointers.PFloat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import org.json.JSONObject;

public final class b
  extends a
{
  private static int[] qnI;
  private c qnJ;
  private IListener<eg> qnK;
  
  static
  {
    int[] arrayOfInt = new int[5];
    qnI = arrayOfInt;
    arrayOfInt[0] = 1;
    qnI[1] = 2;
    qnI[2] = 4;
    qnI[3] = 8;
    qnI[4] = 16;
  }
  
  public b()
  {
    super("MicroMsg.DiscoverExposeEdgeTrigger", c.a.zrf, c.a.zre, c.a.zrg);
    AppMethodBeat.i(267690);
    this.qnJ = new c();
    this.qnK = new DiscoverExposeEdgeTrigger.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(267690);
  }
  
  final String M(JSONObject paramJSONObject)
  {
    return "";
  }
  
  public final void aoW()
  {
    AppMethodBeat.i(267699);
    super.aoW();
    this.qnK.alive();
    AppMethodBeat.o(267699);
  }
  
  final boolean dH(Object paramObject)
  {
    return true;
  }
  
  final String dI(Object paramObject)
  {
    int i = 1;
    long l = 0L;
    AppMethodBeat.i(267732);
    try
    {
      if ((paramObject instanceof eg))
      {
        Object localObject1 = (eg)paramObject;
        paramObject = this.qnJ;
        Object localObject2 = paramObject.qnO;
        ((bm)localObject2).isk = ((bm)localObject2).F("fromSid", ((eg)localObject1).hDZ.hEa, true);
        localObject2 = ((bm)localObject2).ey(((eg)localObject1).hDZ.hEb);
        ((bm)localObject2).ism = ((eg)localObject1).hDZ.hEc;
        ((bm)localObject2).isn = ((bm)localObject2).F("findFriendsEntryRedDot", com.tencent.mm.plugin.ai.data.business.global.c.caj().cal(), true);
        com.tencent.mm.plugin.ai.d.e.caH();
        localObject1 = d.TV("calendar_statistics_discover");
        if (localObject1 != null) {
          paramObject.qnO.ez(((ai)localObject1).iog).isx = ((ai)localObject1).ioi;
        }
        paramObject = this.qnJ.qnO;
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        paramObject.irW = com.tencent.mm.plugin.ai.data.business.global.b.bZX();
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        paramObject.irX = com.tencent.mm.plugin.ai.data.business.global.b.bZY();
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        paramObject.isi = com.tencent.mm.plugin.ai.data.business.global.b.cae();
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        paramObject.isj = com.tencent.mm.plugin.ai.data.business.global.b.caf();
        paramObject = this.qnJ;
        localObject1 = paramObject.qnO.kZ("");
        ((bm)localObject1).irN = 0L;
        ((bm)localObject1).irO = 0L;
        localObject1 = paramObject.qnO.ew(0L);
        ((bm)localObject1).irQ = 0L;
        ((bm)localObject1).irR = 0L;
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        localObject1 = com.tencent.mm.plugin.ai.data.business.global.b.bZZ();
        if (localObject1 != null)
        {
          localObject2 = paramObject.qnO.kZ(((p)localObject1).field_tipsId);
          ((bm)localObject2).irN = ((p)localObject1).field_ctrType;
          ((bm)localObject2).ew(((p)localObject1).field_time);
          com.tencent.mm.plugin.ai.data.business.global.b.bZW();
          localObject1 = com.tencent.mm.plugin.ai.data.business.global.b.a((p)localObject1);
          if (localObject1 != null)
          {
            paramObject.qnO.isO = ((bxq)localObject1).aagw;
            localObject2 = new PInt();
            PString localPString = new PString();
            com.tencent.mm.plugin.ai.data.business.global.b.bZW();
            if (com.tencent.mm.plugin.ai.data.business.global.b.a((bxq)localObject1, (PInt)localObject2, localPString))
            {
              bm localbm = paramObject.qnO;
              localbm.isN = localbm.F("finderPushScene", localPString.value, true);
              localbm.isM = ((PInt)localObject2).value;
            }
            if (((bxq)localObject1).aagu != null)
            {
              localObject2 = paramObject.qnO;
              ((bm)localObject2).irO = ((bxq)localObject1).show_type;
              ((bm)localObject2).irQ = ((bxq)localObject1).aagu.ZlK;
              ((bm)localObject2).irR = ((bxq)localObject1).aagu.ZlM;
            }
          }
        }
        localObject1 = paramObject.qnO.la("");
        ((bm)localObject1).irZ = 0L;
        ((bm)localObject1).isa = 0L;
        localObject1 = paramObject.qnO.ex(0L);
        ((bm)localObject1).isc = 0L;
        ((bm)localObject1).isd = 0L;
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        localObject1 = com.tencent.mm.plugin.ai.data.business.global.b.cag();
        if (localObject1 != null)
        {
          localObject2 = paramObject.qnO.la(((p)localObject1).field_tipsId);
          ((bm)localObject2).irZ = ((p)localObject1).field_ctrType;
          ((bm)localObject2).ex(((p)localObject1).field_time);
          com.tencent.mm.plugin.ai.data.business.global.b.bZW();
          localObject1 = com.tencent.mm.plugin.ai.data.business.global.b.b((p)localObject1);
          if (localObject1 != null)
          {
            paramObject.qnO.isQ = ((bxq)localObject1).aagw;
            localObject2 = new PInt();
            com.tencent.mm.plugin.ai.data.business.global.b.bZW();
            if (com.tencent.mm.plugin.ai.data.business.global.b.a((bxq)localObject1, (PInt)localObject2)) {
              paramObject.qnO.isP = ((PInt)localObject2).value;
            }
            if (((bxq)localObject1).aagu != null)
            {
              localObject2 = paramObject.qnO;
              ((bm)localObject2).isa = ((bxq)localObject1).show_type;
              ((bm)localObject2).isc = ((bxq)localObject1).aagu.ZlK;
              ((bm)localObject2).isd = ((bxq)localObject1).aagu.ZlM;
            }
          }
        }
        paramObject = paramObject.qnO;
        paramObject.isp = com.tencent.mm.plugin.ai.data.business.finder.e.bZM().qlU.size();
        paramObject.isq = com.tencent.mm.plugin.ai.data.business.finder.e.bZM().qlV.size();
        paramObject = this.qnJ;
        localObject1 = paramObject.qnO;
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        localObject2 = q.ASF;
        ((bm)localObject1).irU = q.eaQ();
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        localObject2 = q.ASF;
        ((bm)localObject1).irV = q.eaP();
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        ((bm)localObject1).irS = com.tencent.mm.plugin.ai.data.business.global.b.caa();
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        ((bm)localObject1).irT = com.tencent.mm.plugin.ai.data.business.global.b.cab();
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        localObject2 = q.ASF;
        ((bm)localObject1).isg = q.eaT();
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        localObject2 = q.ASF;
        ((bm)localObject1).ish = q.eaS();
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        ((bm)localObject1).ise = com.tencent.mm.plugin.ai.data.business.global.b.cah();
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        ((bm)localObject1).isf = com.tencent.mm.plugin.ai.data.business.global.b.cai();
        com.tencent.mm.plugin.ai.data.business.finder.e.bZM();
        ((bm)localObject1).isr = com.tencent.mm.plugin.ai.data.business.finder.e.bZP();
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        ((bm)localObject1).isU = com.tencent.mm.plugin.ai.data.business.global.b.cad();
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        ((bm)localObject1).isT = com.tencent.mm.plugin.ai.data.business.global.b.cac();
        com.tencent.mm.plugin.ai.d.e.caH();
        localObject1 = d.TW("calendar_statistics_sync");
        if (localObject1 != null)
        {
          localObject2 = paramObject.qnO;
          ((bm)localObject2).iss = ((ah)localObject1).ioc;
          ((bm)localObject2).ist = ((ah)localObject1).iod;
          ((bm)localObject2).isu = ((ah)localObject1).ioe;
          ((bm)localObject2).isv = ((ah)localObject1).iof;
        }
        com.tencent.mm.plugin.ai.d.e.caH();
        localObject1 = d.TV("calendar_statistics_finder");
        if (localObject1 != null)
        {
          localObject2 = paramObject.qnO.eA(((ai)localObject1).iog);
          ((bm)localObject2).isz = ((ai)localObject1).ioh;
          ((bm)localObject2).isA = ((ai)localObject1).ioi;
          ((bm)localObject2).isB = ((ai)localObject1).iol;
          ((bm)localObject2).isC = ((ai)localObject1).iom;
          ((bm)localObject2).isD = ((ai)localObject1).ion;
          ((bm)localObject2).eB(((ai)localObject1).ioj);
        }
        com.tencent.mm.plugin.ai.d.e.caH();
        localObject1 = d.TV("calendar_statistics_live");
        if (localObject1 != null)
        {
          paramObject = paramObject.qnO.eC(((ai)localObject1).iog);
          paramObject.isG = ((ai)localObject1).ioh;
          paramObject.isH = ((ai)localObject1).ioi;
          paramObject.isI = ((ai)localObject1).iol;
          paramObject.isJ = ((ai)localObject1).iom;
          paramObject.isK = ((ai)localObject1).ion;
          paramObject.eD(((ai)localObject1).ioj);
        }
        localObject1 = this.qnJ;
        if (com.tencent.mm.plugin.ai.data.business.global.a.bZV() >= 3) {}
        for (;;)
        {
          paramObject = new PFloat();
          com.tencent.mm.plugin.ai.data.business.global.a.a(paramObject);
          localObject1 = ((c)localObject1).qnO;
          ((bm)localObject1).iso = ((bm)localObject1).F("netType", NetStatusUtil.getIOSOldNetType(MMApplicationContext.getContext()), true);
          ((bm)localObject1).ijs = com.tencent.mm.plugin.ai.data.business.global.f.cao().qmE;
          if (i != 0) {
            l = 1L;
          }
          ((bm)localObject1).isR = l;
          ((bm)localObject1).isS = ((int)(paramObject.value * 100.0F));
          Log.d("MicroMsg.DiscoverExposeEdgeTrigger", "collectEdgeArgs input [%s]", new Object[] { this.qnJ.qnO.aIF() });
          paramObject = this.qnJ.qnO.aIE();
          AppMethodBeat.o(267732);
          return paramObject;
          i = 0;
        }
      }
      return "";
    }
    catch (Exception paramObject)
    {
      Log.w("MicroMsg.DiscoverExposeEdgeTrigger", "collectEdgeArgs trigger input class error");
      AppMethodBeat.o(267732);
    }
  }
  
  final long t(String paramString, Object paramObject)
  {
    AppMethodBeat.i(267743);
    long l = Util.currentTicks();
    if (!Util.isNullOrNil(paramString)) {}
    for (paramString = new bn(paramString);; paramString = null)
    {
      if (paramString == null)
      {
        AppMethodBeat.o(267743);
        return -1L;
      }
      Log.d("MicroMsg.DiscoverExposeEdgeTrigger", "handle edge result [%s]", new Object[] { paramString.aIF() });
      int j = (int)paramString.isX;
      int i = 0;
      if (i < qnI.length)
      {
        switch (qnI[i])
        {
        }
        for (;;)
        {
          i += 1;
          break;
          if ((j & 0x1) > 0)
          {
            com.tencent.mm.plugin.ai.data.business.finder.e.bZM().yJ((int)paramString.isY);
            continue;
            if ((j & 0x2) > 0)
            {
              com.tencent.mm.plugin.ai.data.business.finder.e.bZM();
              com.tencent.mm.plugin.ai.data.business.finder.e.TL("FinderEntrance");
              continue;
              if ((j & 0x4) > 0)
              {
                com.tencent.mm.plugin.ai.data.business.finder.e.bZM().bZS();
                continue;
                if ((j & 0x8) > 0)
                {
                  com.tencent.mm.plugin.ai.data.business.finder.e.bZM();
                  com.tencent.mm.plugin.ai.data.business.finder.e.TL("NearbyEntrance");
                  com.tencent.mm.plugin.ai.data.business.finder.e.bZM();
                  com.tencent.mm.plugin.ai.data.business.finder.e.TL("FinderLiveEntrance");
                  continue;
                  if ((j & 0x10) > 0) {
                    com.tencent.mm.plugin.ai.data.business.finder.e.bZM().bZT();
                  }
                }
              }
            }
          }
        }
      }
      if ((paramString.isZ > 0L) && (!Util.isNullOrNil(paramString.ita))) {
        com.tencent.mm.plugin.report.f.Ozc.kvStat((int)paramString.isZ, paramString.ita.replaceAll("#", ","));
      }
      Log.d("MicroMsg.DiscoverExposeEdgeTrigger", "handle Edge Result resultCode[%d] scene[%d] cost[%d]", new Object[] { Integer.valueOf(j), Long.valueOf(paramString.isY), Long.valueOf(Util.ticksToNow(l)) });
      l = j;
      AppMethodBeat.o(267743);
      return l;
    }
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(267704);
    super.unRegister();
    this.qnK.dead();
    AppMethodBeat.o(267704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.edge.b
 * JD-Core Version:    0.7.0.1
 */