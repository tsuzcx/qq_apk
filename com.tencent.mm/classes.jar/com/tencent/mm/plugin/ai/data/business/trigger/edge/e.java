package com.tencent.mm.plugin.ai.data.business.trigger.edge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jp;
import com.tencent.mm.autogen.a.jp.a;
import com.tencent.mm.autogen.a.nk;
import com.tencent.mm.autogen.mmdata.rpt.ai;
import com.tencent.mm.autogen.mmdata.rpt.dy;
import com.tencent.mm.autogen.mmdata.rpt.dz;
import com.tencent.mm.plugin.ai.data.business.global.c;
import com.tencent.mm.plugin.ai.data.business.global.g;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.extension.reddot.q;
import com.tencent.mm.pointers.PFloat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class e
  extends a
{
  private static int[] qnI;
  private HashSet<String> qnT;
  private f qnU;
  private IListener<nk> qnV;
  private IListener<jp> qnW;
  
  static
  {
    int[] arrayOfInt = new int[2];
    qnI = arrayOfInt;
    arrayOfInt[0] = 32;
    qnI[1] = 64;
  }
  
  public e()
  {
    super("MicroMsg.FinderGotTabTipsEdgeTrigger", c.a.zrM, c.a.zrL, c.a.zrN);
    AppMethodBeat.i(267693);
    this.qnT = new HashSet();
    this.qnU = new f();
    this.qnV = new FinderGotTabTipsEdgeTrigger.1(this, com.tencent.mm.app.f.hfK);
    this.qnW = new FinderGotTabTipsEdgeTrigger.2(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(267693);
  }
  
  private static boolean a(jp paramjp, List<btw> paramList1, List<btw> paramList2)
  {
    AppMethodBeat.i(267703);
    if (paramjp == null)
    {
      AppMethodBeat.o(267703);
      return false;
    }
    for (;;)
    {
      int j;
      try
      {
        bxh localbxh = new bxh();
        localbxh.parseFrom(paramjp.hLg.hLi.ZFn.toByteArray());
        if ((localbxh.aace != null) && (!localbxh.aace.isEmpty()))
        {
          j = 0;
          Object localObject;
          if (j < localbxh.aace.size())
          {
            paramjp = ((bxi)localbxh.aace.get(j)).aagf;
            if ((paramjp == null) || (paramjp.aabA == null)) {
              break label310;
            }
            Iterator localIterator = paramjp.aabA.iterator();
            if (!localIterator.hasNext()) {
              break label310;
            }
            localObject = (bxq)localIterator.next();
            if ((localObject == null) || (Util.isNullOrNil(((bxq)localObject).path))) {
              break label304;
            }
            localObject = ((bxq)localObject).path;
            i = -1;
          }
          switch (((String)localObject).hashCode())
          {
          case -58348260: 
            if (((String)localObject).equals("FinderEntrance")) {
              i = 0;
            }
            break;
          case 691368744: 
            if (((String)localObject).equals("FinderLiveEntrance"))
            {
              i = 1;
              break;
              paramList1.add(paramjp);
              i = 1;
              break label306;
              paramList2.add(paramjp);
              i = 1;
              break label306;
              AppMethodBeat.o(267703);
              return true;
            }
            break;
          }
        }
      }
      catch (Exception paramjp)
      {
        Log.printErrStackTrace("MicroMsg.FinderGotTabTipsEdgeTrigger", paramjp, "collect edge args error.", new Object[0]);
        AppMethodBeat.o(267703);
        return false;
      }
      switch (i)
      {
      }
      label304:
      int i = 0;
      label306:
      if (i != 0) {
        label310:
        j += 1;
      }
    }
  }
  
  private static jp dK(Object paramObject)
  {
    if ((paramObject instanceof jp)) {
      return (jp)paramObject;
    }
    return null;
  }
  
  final String M(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(267725);
    Object localObject = null;
    if (paramJSONObject != null) {
      localObject = paramJSONObject.optString("nothitscene", "");
    }
    paramJSONObject = new HashSet();
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          paramJSONObject.add(localObject[i]);
          i += 1;
        }
      }
    }
    this.qnT = paramJSONObject;
    paramJSONObject = String.format("not Hit Expt Scene {%s} ", new Object[] { this.qnT });
    AppMethodBeat.o(267725);
    return paramJSONObject;
  }
  
  public final void aoW()
  {
    AppMethodBeat.i(267714);
    super.aoW();
    this.qnW.alive();
    this.qnV.alive();
    AppMethodBeat.o(267714);
  }
  
  final boolean dH(Object paramObject)
  {
    AppMethodBeat.i(267730);
    paramObject = dK(paramObject);
    if (paramObject == null)
    {
      AppMethodBeat.o(267730);
      return false;
    }
    if (this.qnT.contains(Integer.valueOf(paramObject.hLg.scene)))
    {
      AppMethodBeat.o(267730);
      return false;
    }
    AppMethodBeat.o(267730);
    return true;
  }
  
  final String dI(Object paramObject)
  {
    AppMethodBeat.i(267751);
    long l2 = Util.currentTicks();
    Object localObject3 = dK(paramObject);
    if (localObject3 == null)
    {
      AppMethodBeat.o(267751);
      return "";
    }
    Object localObject1 = new ArrayList();
    paramObject = new ArrayList();
    label102:
    Object localObject2;
    int i;
    Object localObject4;
    label259:
    label349:
    int j;
    if (a((jp)localObject3, (List)localObject1, paramObject))
    {
      if (!((List)localObject1).isEmpty())
      {
        localObject1 = (btw)((List)localObject1).get(0);
        if (paramObject.isEmpty()) {
          break label1244;
        }
        paramObject = (btw)paramObject.get(0);
        localObject2 = this.qnU;
        i = ((jp)localObject3).hLg.scene;
        localObject3 = ((f)localObject2).qoa;
        ((dy)localObject3).iBi = i;
        ((dy)localObject3).iBj = Util.nowMilliSecond();
        if (localObject1 == null) {
          break label1249;
        }
        ((f)localObject2).qoa.oc(((btw)localObject1).ZYN).iBl = ((btw)localObject1).type;
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        localObject1 = com.tencent.mm.plugin.ai.data.business.global.b.a((btw)localObject1);
        if (localObject1 != null)
        {
          localObject3 = new PInt();
          localObject4 = new PString();
          com.tencent.mm.plugin.ai.data.business.global.b.bZW();
          if (com.tencent.mm.plugin.ai.data.business.global.b.a((bxq)localObject1, (PInt)localObject3, (PString)localObject4))
          {
            dy localdy = ((f)localObject2).qoa;
            localdy.iBm = ((PInt)localObject3).value;
            localdy.od(((PString)localObject4).value);
          }
          ((f)localObject2).qoa.iBo = ((bxq)localObject1).aagw;
        }
        if (paramObject == null) {
          break label1287;
        }
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        localObject1 = com.tencent.mm.plugin.ai.data.business.global.b.b(paramObject);
        if (localObject1 != null)
        {
          localObject3 = new PInt();
          com.tencent.mm.plugin.ai.data.business.global.b.bZW();
          if (com.tencent.mm.plugin.ai.data.business.global.b.a((bxq)localObject1, (PInt)localObject3)) {
            ((f)localObject2).qoa.iBr = ((PInt)localObject3).value;
          }
          ((f)localObject2).qoa.iBs = ((bxq)localObject1).aagw;
        }
        ((f)localObject2).qoa.oe(paramObject.ZYN).iBq = paramObject.type;
      }
    }
    else
    {
      paramObject = this.qnU;
      localObject1 = paramObject.qoa.of("");
      ((dy)localObject1).iBu = 0L;
      ((dy)localObject1).iBv = 0L;
      localObject1 = ((dy)localObject1).og("");
      ((dy)localObject1).iBx = 0L;
      localObject1 = ((dy)localObject1).eK(0L);
      ((dy)localObject1).iBA = 0L;
      ((dy)localObject1).iBz = 0L;
      com.tencent.mm.plugin.ai.data.business.global.b.bZW();
      localObject1 = com.tencent.mm.plugin.ai.data.business.global.b.bZZ();
      if (localObject1 != null)
      {
        localObject2 = paramObject.qoa.of(((p)localObject1).field_tipsId);
        ((dy)localObject2).iBu = ((p)localObject1).field_ctrType;
        ((dy)localObject2).eK(((p)localObject1).field_time);
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        localObject1 = com.tencent.mm.plugin.ai.data.business.global.b.a((p)localObject1);
        if (localObject1 != null)
        {
          paramObject.qoa.iBx = ((bxq)localObject1).aagw;
          localObject2 = new PInt();
          localObject3 = new PString();
          com.tencent.mm.plugin.ai.data.business.global.b.bZW();
          if (com.tencent.mm.plugin.ai.data.business.global.b.a((bxq)localObject1, (PInt)localObject2, (PString)localObject3))
          {
            localObject4 = paramObject.qoa;
            ((dy)localObject4).iBv = ((PInt)localObject2).value;
            ((dy)localObject4).og(((PString)localObject3).value);
          }
          if (((bxq)localObject1).aagu != null)
          {
            localObject2 = paramObject.qoa;
            ((dy)localObject2).iBz = ((bxq)localObject1).aagu.ZlK;
            ((dy)localObject2).iBA = ((bxq)localObject1).aagu.ZlM;
          }
        }
      }
      localObject1 = paramObject.qoa.oh("");
      ((dy)localObject1).iBC = 0L;
      ((dy)localObject1).iBE = 0L;
      localObject1 = ((dy)localObject1).eL(0L);
      ((dy)localObject1).iBH = 0L;
      ((dy)localObject1).iBG = 0L;
      com.tencent.mm.plugin.ai.data.business.global.b.bZW();
      localObject1 = com.tencent.mm.plugin.ai.data.business.global.b.cag();
      if (localObject1 != null)
      {
        localObject2 = paramObject.qoa.oh(((p)localObject1).field_tipsId);
        ((dy)localObject2).iBC = ((p)localObject1).field_ctrType;
        ((dy)localObject2).eL(((p)localObject1).field_time);
        com.tencent.mm.plugin.ai.data.business.global.b.bZW();
        localObject1 = com.tencent.mm.plugin.ai.data.business.global.b.b((p)localObject1);
        if (localObject1 != null)
        {
          paramObject.qoa.iBE = ((bxq)localObject1).aagw;
          localObject2 = new PInt();
          com.tencent.mm.plugin.ai.data.business.global.b.bZW();
          if (com.tencent.mm.plugin.ai.data.business.global.b.a((bxq)localObject1, (PInt)localObject2)) {
            paramObject.qoa.iBD = ((PInt)localObject2).value;
          }
          if (((bxq)localObject1).aagu != null)
          {
            paramObject = paramObject.qoa;
            paramObject.iBG = ((bxq)localObject1).aagu.ZlK;
            paramObject.iBH = ((bxq)localObject1).aagu.ZlM;
          }
        }
      }
      localObject3 = this.qnU;
      if (com.tencent.mm.plugin.ai.data.business.global.a.bZV() < 3) {
        break label1316;
      }
      i = 1;
      label805:
      localObject1 = new PFloat();
      com.tencent.mm.plugin.ai.data.business.global.a.a((PFloat)localObject1);
      paramObject = new PString();
      localObject2 = new PLong();
      localObject4 = com.tencent.mm.plugin.ai.data.business.global.d.cam();
      if (((com.tencent.mm.plugin.ai.data.business.global.d)localObject4).qmu == null) {
        break label1321;
      }
      paramObject.value = ((com.tencent.mm.plugin.ai.data.business.global.d)localObject4).qmu.id;
      ((PLong)localObject2).value = ((com.tencent.mm.plugin.ai.data.business.global.d)localObject4).qmu.hEc;
      j = 1;
      label877:
      localObject3 = ((f)localObject3).qoa;
      ((dy)localObject3).iso = ((dy)localObject3).F("netType", NetStatusUtil.getIOSOldNetType(MMApplicationContext.getContext()), true);
      ((dy)localObject3).iBI = com.tencent.mm.plugin.ai.data.business.global.f.cao().qmE;
      if (j == 0) {
        break label1326;
      }
      paramObject = paramObject.value;
      label937:
      ((dy)localObject3).ikm = ((dy)localObject3).F("currSessionId", paramObject, true);
      if (j == 0) {
        break label1333;
      }
      l1 = ((PLong)localObject2).value;
      label963:
      ((dy)localObject3).iko = l1;
      if (i == 0) {
        break label1339;
      }
      l1 = 1L;
      label977:
      ((dy)localObject3).isR = l1;
      ((dy)localObject3).isS = ((int)(((PFloat)localObject1).value * 100.0F));
      paramObject = this.qnU;
      localObject1 = paramObject.qoa;
      ((dy)localObject1).isn = ((dy)localObject1).F("findFriendsEntryRedDot", c.caj().cal(), true);
      if (!c.caj().bZI()) {
        break label1345;
      }
    }
    label1287:
    label1316:
    label1321:
    label1326:
    label1333:
    label1339:
    label1345:
    for (long l1 = 1L;; l1 = 0L)
    {
      ((dy)localObject1).iBJ = l1;
      com.tencent.mm.plugin.ai.d.e.caH();
      localObject1 = com.tencent.mm.plugin.ai.d.d.TV("calendar_statistics_discover");
      if (localObject1 != null) {
        paramObject.qoa.eM(((ai)localObject1).iog).isx = ((ai)localObject1).ioi;
      }
      paramObject = this.qnU.qoa;
      com.tencent.mm.plugin.ai.data.business.global.b.bZW();
      localObject1 = q.ASF;
      paramObject.irU = q.eaQ();
      com.tencent.mm.plugin.ai.data.business.global.b.bZW();
      localObject1 = q.ASF;
      paramObject.irV = q.eaP();
      com.tencent.mm.plugin.ai.data.business.global.b.bZW();
      localObject1 = q.ASF;
      paramObject.isg = q.eaT();
      com.tencent.mm.plugin.ai.data.business.global.b.bZW();
      localObject1 = q.ASF;
      paramObject.ish = q.eaS();
      com.tencent.mm.plugin.ai.data.business.global.b.bZW();
      paramObject.isU = com.tencent.mm.plugin.ai.data.business.global.b.cad();
      com.tencent.mm.plugin.ai.data.business.global.b.bZW();
      paramObject.isT = com.tencent.mm.plugin.ai.data.business.global.b.cac();
      Log.d("MicroMsg.FinderGotTabTipsEdgeTrigger", "collect edge args [%s] cost[%d]", new Object[] { this.qnU.qoa.aIF(), Long.valueOf(Util.ticksToNow(l2)) });
      paramObject = this.qnU.qoa.aIE();
      AppMethodBeat.o(267751);
      return paramObject;
      localObject1 = null;
      break;
      label1244:
      paramObject = null;
      break label102;
      label1249:
      localObject1 = ((f)localObject2).qoa.oc("");
      ((dy)localObject1).iBl = 0L;
      ((dy)localObject1).iBm = 0L;
      ((dy)localObject1).od("").iBo = 0L;
      break label259;
      paramObject = ((f)localObject2).qoa.oe("");
      paramObject.iBq = 0L;
      paramObject.iBr = 0L;
      paramObject.iBs = 0L;
      break label349;
      i = 0;
      break label805;
      j = 0;
      break label877;
      paramObject = "-1";
      break label937;
      l1 = 0L;
      break label963;
      l1 = 0L;
      break label977;
    }
  }
  
  final long t(String paramString, Object paramObject)
  {
    AppMethodBeat.i(267760);
    long l = Util.currentTicks();
    paramObject = dK(paramObject);
    if (paramObject == null)
    {
      AppMethodBeat.o(267760);
      return -1L;
    }
    int k;
    bxh localbxh;
    if (!Util.isNullOrNil(paramString))
    {
      paramString = new dz(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(267760);
        return -1L;
      }
      Log.d("MicroMsg.FinderGotTabTipsEdgeTrigger", "handle edge result [%s]", new Object[] { paramString.aIF() });
      k = (int)paramString.isX;
      localbxh = new bxh();
    }
    for (;;)
    {
      int j;
      bxi localbxi;
      btw localbtw;
      Iterator localIterator;
      bxq localbxq;
      String str;
      try
      {
        localbxh.parseFrom(paramObject.hLg.hLi.ZFn.toByteArray());
        if ((localbxh.aace != null) && (!localbxh.aace.isEmpty()))
        {
          j = 0;
          if (j >= localbxh.aace.size()) {
            break label598;
          }
          localbxi = (bxi)localbxh.aace.get(j);
          localbtw = localbxi.aagf;
          if ((localbtw == null) || (localbtw.aabA == null)) {
            break label659;
          }
          localIterator = localbtw.aabA.iterator();
          if (!localIterator.hasNext()) {
            break label659;
          }
          localbxq = (bxq)localIterator.next();
          if ((localbxq == null) || (Util.isNullOrNil(localbxq.path))) {
            continue;
          }
          str = localbxq.path;
          i = -1;
        }
        switch (str.hashCode())
        {
        case -58348260: 
          if (((k & 0x80) <= 0) || (!com.tencent.mm.plugin.ai.data.business.finder.e.bZM().a(localbxq.path, localbxi, localbxq.icon_url, paramObject.hLg.scene))) {
            break label622;
          }
          i = 1;
          Log.i("MicroMsg.FinderGotTabTipsEdgeTrigger", "push finder entrance tips to cache [%s]", new Object[] { localbtw.ZYN });
          if ((k & 0x20) > 0)
          {
            i = 1;
            Log.i("MicroMsg.FinderGotTabTipsEdgeTrigger", "drop finder entrance tips [%s]", new Object[] { localbtw.ZYN });
          }
          if (i == 0) {
            continue;
          }
          localIterator.remove();
          continue;
          label377:
          if (!str.equals("FinderEntrance")) {
            break label632;
          }
        }
      }
      catch (Exception paramObject)
      {
        if ((paramString.isZ > 0L) && (!Util.isNullOrNil(paramString.ita))) {
          com.tencent.mm.plugin.report.f.Ozc.kvStat((int)paramString.isZ, paramString.ita.replaceAll("#", ","));
        }
        Log.d("MicroMsg.FinderGotTabTipsEdgeTrigger", "handle Edge Result resultCode[%d] cost[%d]", new Object[] { Integer.valueOf(k), Long.valueOf(Util.ticksToNow(l)) });
        l = k;
        AppMethodBeat.o(267760);
        return l;
      }
      int i = 0;
      break label632;
      if (str.equals("FinderLiveEntrance"))
      {
        i = 1;
        break label632;
        if (((k & 0x100) > 0) && (com.tencent.mm.plugin.ai.data.business.finder.e.bZM().a(localbxq.path, localbxi, localbxq.icon_url, paramObject.hLg.scene)))
        {
          i = 1;
          Log.i("MicroMsg.FinderGotTabTipsEdgeTrigger", "push finder live entrance tips to cache [%s]", new Object[] { localbtw.ZYN });
        }
        for (;;)
        {
          if ((k & 0x40) > 0)
          {
            i = 1;
            Log.i("MicroMsg.FinderGotTabTipsEdgeTrigger", "drop finder live entrance tips [%s]", new Object[] { localbtw.ZYN });
          }
          if (i == 0) {
            break;
          }
          localIterator.remove();
          break;
          label598:
          com.tencent.mm.plugin.ai.data.business.finder.e.bZM();
          com.tencent.mm.plugin.ai.data.business.finder.e.a(localbxh, paramObject.hLg.scene);
          break label377;
          i = 0;
        }
        label622:
        i = 0;
        continue;
        paramString = null;
        break;
      }
      label632:
      switch (i)
      {
      }
      continue;
      label659:
      j += 1;
    }
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(267719);
    super.unRegister();
    this.qnW.dead();
    this.qnV.dead();
    AppMethodBeat.o(267719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.edge.e
 * JD-Core Version:    0.7.0.1
 */