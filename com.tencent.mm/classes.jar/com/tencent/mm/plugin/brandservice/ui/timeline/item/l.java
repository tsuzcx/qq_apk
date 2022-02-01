package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.ao.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.dby;
import com.tencent.mm.protocal.protobuf.dva;
import com.tencent.mm.protocal.protobuf.dvb;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"TAG", "", "value", "", "isOpenFollow", "()Z", "setOpenFollow", "(Z)V", "doBizFeedbackReq", "", "cardType", "", "levelType", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "selectFeedback", "", "bizInfo", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getRecycleCardList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecycleCard;", "getRecycleCardListProto", "isSupportStyle", "style", "plugin-brandservice_release"})
public final class l
{
  private static boolean sDG = true;
  
  public static final boolean Gz(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static final void a(int paramInt, eqg parameqg, List<String> paramList, z paramz)
  {
    AppMethodBeat.i(259133);
    p.k(parameqg, "wrapper");
    p.k(paramz, "bizInfo");
    switch (parameqg.style)
    {
    default: 
      AppMethodBeat.o(259133);
      return;
    }
    if ((parameqg.UsF == null) || (Util.isNullOrNil((List)parameqg.UsF.RVd)))
    {
      AppMethodBeat.o(259133);
      return;
    }
    Object localObject1 = new d.a();
    ((d.a)localObject1).c((com.tencent.mm.cd.a)new nz());
    ((d.a)localObject1).d((com.tencent.mm.cd.a)new oa());
    ((d.a)localObject1).TW("/cgi-bin/mmbiz-bin/timeline/bizfeedback");
    ((d.a)localObject1).vD(4898);
    Object localObject2 = x.aazN;
    com.tencent.mm.an.d locald = ((d.a)localObject1).bgN();
    localObject1 = locald.bhX();
    if (localObject1 == null)
    {
      parameqg = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizFeedbackReq");
      AppMethodBeat.o(259133);
      throw parameqg;
    }
    nz localnz = (nz)localObject1;
    localnz.RVe = 3;
    localObject1 = new LinkedList();
    localObject2 = parameqg.UsF.RVd;
    p.j(localObject2, "wrapper.extraInfo.BizInfo");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (pf)((Iterator)localObject3).next();
      om localom = new om();
      localom.RTS = ((pf)localObject4).UserName;
      LinkedList localLinkedList = new LinkedList();
      Object localObject5 = ((pf)localObject4).RXM;
      p.j(localObject5, "it.AppMsg");
      Object localObject6 = (Iterable)localObject5;
      localObject5 = (Collection)new ArrayList(j.a((Iterable)localObject6, 10));
      localObject6 = ((Iterable)localObject6).iterator();
      while (((Iterator)localObject6).hasNext()) {
        ((Collection)localObject5).add(((pe)((Iterator)localObject6).next()).RTk);
      }
      localLinkedList.addAll((Collection)localObject5);
      localObject5 = x.aazN;
      localom.RVG = localLinkedList;
      localom.RVJ = ((pf)localObject4).rWI;
      localObject4 = x.aazN;
      ((Collection)localObject2).add(localom);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localObject2 = x.aazN;
    localnz.RVd = ((LinkedList)localObject1);
    localnz.RVf = parameqg.style;
    localObject2 = parameqg.event;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localnz.RVg = ((String)localObject1);
    localnz.RVh = parameqg.Uaw;
    localObject2 = parameqg.UsF.RVi;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localnz.RVi = ((String)localObject1);
    localObject2 = parameqg.UsF.RVm;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localnz.RVm = ((String)localObject1);
    localnz.zaX = parameqg.fMh;
    localnz.jmy = m(paramz);
    paramz = y.VdH;
    y.HG(11L);
    Log.i("MicroMsg.BizTLRecCardUtil", "doBizFeedbackReq recycleCardList size = " + localnz.jmy.size());
    switch (paramInt)
    {
    }
    for (;;)
    {
      parameqg = x.aazN;
      parameqg = x.aazN;
      com.tencent.mm.an.aa.a(locald, (aa.a)new a(locald));
      AppMethodBeat.o(259133);
      return;
      paramz = new ny();
      paramz.RTS = ((pf)parameqg.UsF.RVd.get(0)).UserName;
      if (!Util.isNullOrNil(paramList))
      {
        parameqg = new LinkedList();
        if (paramList == null) {
          p.iCn();
        }
        localObject1 = (Iterable)paramList;
        paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          localObject2 = new dby();
          ((dby)localObject2).lpy = ((String)localObject3);
          localObject3 = x.aazN;
          paramList.add(localObject2);
        }
        parameqg.addAll((Collection)paramList);
        paramList = x.aazN;
        paramz.RKA = parameqg;
      }
      parameqg = x.aazN;
      localnz.RVk = paramz;
      continue;
      switch (parameqg.style)
      {
      default: 
        parameqg = new ue();
        parameqg.fwq = 1;
        paramList = x.aazN;
        localnz.RVj = parameqg;
        break;
      case 102: 
        parameqg = new ue();
        if (!Util.isNullOrNil(paramList))
        {
          paramz = new LinkedList();
          if (paramList == null) {
            p.iCn();
          }
          localObject1 = (Iterable)paramList;
          paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            localObject2 = new dby();
            ((dby)localObject2).lpy = ((String)localObject3);
            localObject3 = x.aazN;
            paramList.add(localObject2);
          }
          paramz.addAll((Collection)paramList);
          paramList = x.aazN;
          parameqg.RKA = paramz;
        }
        paramList = x.aazN;
        localnz.RVj = parameqg;
      }
    }
  }
  
  public static final boolean cAs()
  {
    return sDG;
  }
  
  public static final void cAt()
  {
    AppMethodBeat.i(259126);
    if (((b)h.ae(b.class)).a(b.a.vAF, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      sDG = bool;
      AppMethodBeat.o(259126);
      return;
    }
  }
  
  public static final String cAu()
  {
    AppMethodBeat.i(259127);
    Object localObject = new dvb();
    ((dvb)localObject).jmy = m(null);
    localObject = Base64.encode(((dvb)localObject).toByteArray(), 2);
    p.j(localObject, "Base64.encode(recycleCar…eArray(), Base64.NO_WRAP)");
    Charset localCharset = StandardCharsets.UTF_8;
    p.j(localCharset, "StandardCharsets.UTF_8");
    localObject = new String((byte[])localObject, localCharset);
    AppMethodBeat.o(259127);
    return localObject;
  }
  
  private static LinkedList<dva> m(z paramz)
  {
    AppMethodBeat.i(259128);
    Object localObject1 = y.VdH;
    int i = i.ow(i.ov(y.bcJ().decodeInt("RecycleCardMaxMsgCount", 10), 2), 50);
    Object localObject2 = af.bjB().md(620757041, i);
    localObject1 = new LinkedList();
    if (localObject2 != null)
    {
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject4;
      label144:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        z localz = (z)localObject4;
        if ((paramz == null) || (localz.field_msgId != paramz.field_msgId)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label144;
          }
          ((Collection)localObject2).add(localObject4);
          break;
        }
      }
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (z)((Iterator)localObject2).next();
        localObject4 = new dva();
        p.j(localObject3, "info");
        paramz = ((z)localObject3).hwL();
        if (paramz != null) {}
        for (paramz = paramz.fMh;; paramz = null)
        {
          ((dva)localObject4).zaX = paramz;
          ((dva)localObject4).RWK = ((z)localObject3).field_msgId;
          ((dva)localObject4).Ubj = String.valueOf(((z)localObject3).field_msgId);
          ((LinkedList)localObject1).add(localObject4);
          break;
        }
      }
    }
    AppMethodBeat.o(259128);
    return localObject1;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements aa.a
  {
    a(com.tencent.mm.an.d paramd) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(265327);
      p.k(paramd, "<anonymous parameter 3>");
      p.k(paramq, "<anonymous parameter 4>");
      paramString = this.sDH;
      p.j(paramString, "rr");
      paramString = (oa)paramString.bhY();
      if (paramString == null)
      {
        AppMethodBeat.o(265327);
        return 0;
      }
      paramd = y.VdH;
      y.bcJ().encode("RecycleCardMaxMsgCount", paramString.RVn);
      com.tencent.mm.ae.d.b("MicroMsg.BizRecycleCardLogic", (kotlin.g.a.a)new kotlin.g.b.q(paramString) {});
      AppMethodBeat.o(265327);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.l
 * JD-Core Version:    0.7.0.1
 */