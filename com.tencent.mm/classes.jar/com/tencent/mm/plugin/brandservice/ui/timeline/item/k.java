package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z;
import com.tencent.mm.an.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.protocal.protobuf.eny;
import com.tencent.mm.protocal.protobuf.enz;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"TAG", "", "value", "", "isOpenFollow", "()Z", "setOpenFollow", "(Z)V", "doBizFeedbackReq", "", "cardType", "", "levelType", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "selectFeedback", "", "bizInfo", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getRecycleCardList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecycleCard;", "getRecycleCardListProto", "isSupportStyle", "style", "plugin-brandservice_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class k
{
  private static boolean vJv = true;
  
  public static final boolean GY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static final int a(com.tencent.mm.am.c paramc1, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc2, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(302786);
    s.u(paramc2, "$noName_3");
    s.u(paramp, "$noName_4");
    paramc1 = (pg)c.c.b(paramc1.otC);
    if (paramc1 == null)
    {
      AppMethodBeat.o(302786);
      return 0;
    }
    paramString = aa.acFb;
    aa.atj().encode("RecycleCardMaxMsgCount", paramc1.YSK);
    d.d("MicroMsg.BizRecycleCardLogic", (kotlin.g.a.a)new a(paramc1));
    AppMethodBeat.o(302786);
    return 0;
  }
  
  public static final void a(int paramInt, flj paramflj, List<String> paramList, ab paramab)
  {
    AppMethodBeat.i(302775);
    s.u(paramflj, "wrapper");
    s.u(paramab, "bizInfo");
    switch (paramflj.style)
    {
    default: 
      AppMethodBeat.o(302775);
      return;
    }
    if ((paramflj.abLM == null) || (Util.isNullOrNil((List)paramflj.abLM.YSB)))
    {
      AppMethodBeat.o(302775);
      return;
    }
    Object localObject1 = ah.aiuX;
    localObject1 = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject1).otE = ((com.tencent.mm.bx.a)new pf());
    ((com.tencent.mm.am.c.a)localObject1).otF = ((com.tencent.mm.bx.a)new pg());
    ((com.tencent.mm.am.c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/timeline/bizfeedback";
    ((com.tencent.mm.am.c.a)localObject1).funcId = 4898;
    Object localObject2 = ah.aiuX;
    com.tencent.mm.am.c localc = ((com.tencent.mm.am.c.a)localObject1).bEF();
    localObject1 = c.b.b(localc.otB);
    if (localObject1 == null)
    {
      paramflj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizFeedbackReq");
      AppMethodBeat.o(302775);
      throw paramflj;
    }
    pf localpf = (pf)localObject1;
    localpf.YSC = 3;
    localObject1 = new LinkedList();
    localObject2 = paramflj.abLM.YSB;
    s.s(localObject2, "wrapper.extraInfo.BizInfo");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (qo)((Iterator)localObject3).next();
      pv localpv = new pv();
      localpv.YRs = ((qo)localObject4).UserName;
      LinkedList localLinkedList = new LinkedList();
      Object localObject5 = ((qo)localObject4).YVI;
      s.s(localObject5, "it.AppMsg");
      Object localObject6 = (Iterable)localObject5;
      localObject5 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject6, 10));
      localObject6 = ((Iterable)localObject6).iterator();
      while (((Iterator)localObject6).hasNext()) {
        ((Collection)localObject5).add(((qn)((Iterator)localObject6).next()).YQK);
      }
      localLinkedList.addAll((Collection)localObject5);
      localObject5 = ah.aiuX;
      localpv.YTk = localLinkedList;
      localpv.YTn = ((qo)localObject4).vhX;
      localObject4 = ah.aiuX;
      ((Collection)localObject2).add(localpv);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localObject2 = ah.aiuX;
    localpf.YSB = ((LinkedList)localObject1);
    localpf.bcb = paramflj.style;
    localObject2 = paramflj.event;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localpf.YSD = ((String)localObject1);
    localpf.YSE = paramflj.abry;
    localObject2 = paramflj.abLM.YSF;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localpf.YSF = ((String)localObject1);
    localObject2 = paramflj.abLM.YSJ;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localpf.YSJ = ((String)localObject1);
    localpf.DVu = paramflj.hRR;
    localpf.lPK = k(paramab);
    paramab = aa.acFb;
    aa.jX(11L);
    Log.i("MicroMsg.BizTLRecCardUtil", s.X("doBizFeedbackReq recycleCardList size = ", Integer.valueOf(localpf.lPK.size())));
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramflj = ah.aiuX;
      paramflj = ah.aiuX;
      z.a(localc, new k..ExternalSyntheticLambda0(localc));
      AppMethodBeat.o(302775);
      return;
      paramab = new pe();
      paramab.YRs = ((qo)paramflj.abLM.YSB.get(0)).UserName;
      if (!Util.isNullOrNil(paramList))
      {
        paramflj = new LinkedList();
        s.checkNotNull(paramList);
        localObject1 = (Iterable)paramList;
        paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          localObject2 = new dtq();
          ((dtq)localObject2).nUB = ((String)localObject3);
          localObject3 = ah.aiuX;
          paramList.add(localObject2);
        }
        paramflj.addAll((Collection)paramList);
        paramList = ah.aiuX;
        paramab.YHU = paramflj;
      }
      paramflj = ah.aiuX;
      localpf.YSH = paramab;
      continue;
      if (paramflj.style == 102)
      {
        paramflj = new vv();
        if (!Util.isNullOrNil(paramList))
        {
          paramab = new LinkedList();
          s.checkNotNull(paramList);
          localObject1 = (Iterable)paramList;
          paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            localObject2 = new dtq();
            ((dtq)localObject2).nUB = ((String)localObject3);
            localObject3 = ah.aiuX;
            paramList.add(localObject2);
          }
          paramab.addAll((Collection)paramList);
          paramList = ah.aiuX;
          paramflj.YHU = paramab;
        }
        paramList = ah.aiuX;
        localpf.YSG = paramflj;
      }
      else
      {
        paramflj = new vv();
        paramflj.hAO = 1;
        paramList = ah.aiuX;
        localpf.YSG = paramflj;
      }
    }
  }
  
  public static final boolean dds()
  {
    return vJv;
  }
  
  public static final void ddt()
  {
    AppMethodBeat.i(302722);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yOu, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      vJv = bool;
      AppMethodBeat.o(302722);
      return;
    }
  }
  
  public static final String ddu()
  {
    AppMethodBeat.i(302737);
    Object localObject = new enz();
    ((enz)localObject).lPK = k(null);
    localObject = Base64.encode(((enz)localObject).toByteArray(), 2);
    s.s(localObject, "encode(recycleCardList.t…eArray(), Base64.NO_WRAP)");
    Charset localCharset = StandardCharsets.UTF_8;
    s.s(localCharset, "UTF_8");
    localObject = new String((byte[])localObject, localCharset);
    AppMethodBeat.o(302737);
    return localObject;
  }
  
  private static LinkedList<eny> k(ab paramab)
  {
    AppMethodBeat.i(302748);
    Object localObject1 = aa.acFb;
    int i = kotlin.k.k.qv(kotlin.k.k.qu(aa.atj().decodeInt("RecycleCardMaxMsgCount", 10), 2), 50);
    Object localObject2 = af.bHl().nT(620757041, i);
    localObject1 = new LinkedList();
    if (localObject2 != null)
    {
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      Object localObject4;
      label143:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        ab localab = (ab)localObject4;
        if ((paramab == null) || (localab.field_msgId != paramab.field_msgId)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label143;
          }
          ((Collection)localObject2).add(localObject4);
          break;
        }
      }
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ab)((Iterator)localObject2).next();
        localObject4 = new eny();
        paramab = ((ab)localObject3).iYp();
        if (paramab == null) {}
        for (paramab = null;; paramab = paramab.hRR)
        {
          ((eny)localObject4).DVu = paramab;
          ((eny)localObject4).YUq = ((ab)localObject3).field_msgId;
          ((eny)localObject4).absq = String.valueOf(((ab)localObject3).field_msgId);
          ((LinkedList)localObject1).add(localObject4);
          break;
        }
      }
    }
    AppMethodBeat.o(302748);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(pg parampg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.k
 * JD-Core Version:    0.7.0.1
 */