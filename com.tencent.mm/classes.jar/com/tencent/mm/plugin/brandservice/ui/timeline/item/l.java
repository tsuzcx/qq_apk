package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.csz;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.dlj;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.protocal.protobuf.uc;
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
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"TAG", "", "value", "", "isOpenFollow", "()Z", "setOpenFollow", "(Z)V", "doBizFeedbackReq", "", "cardType", "", "levelType", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "selectFeedback", "", "bizInfo", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getRecycleCardList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecycleCard;", "getRecycleCardListProto", "isSupportStyle", "style", "plugin-brandservice_release"})
public final class l
{
  private static boolean put = true;
  
  public static final boolean CT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static final void a(int paramInt, ege paramege, List<String> paramList, z paramz)
  {
    AppMethodBeat.i(195301);
    p.h(paramege, "wrapper");
    p.h(paramz, "bizInfo");
    switch (paramege.style)
    {
    default: 
      AppMethodBeat.o(195301);
      return;
    }
    if ((paramege.Nga == null) || (Util.isNullOrNil((List)paramege.Nga.KUf)))
    {
      AppMethodBeat.o(195301);
      return;
    }
    Object localObject1 = new d.a();
    ((d.a)localObject1).c((com.tencent.mm.bw.a)new oj());
    ((d.a)localObject1).d((com.tencent.mm.bw.a)new ok());
    ((d.a)localObject1).MB("/cgi-bin/mmbiz-bin/timeline/bizfeedback");
    ((d.a)localObject1).sG(4898);
    Object localObject2 = x.SXb;
    com.tencent.mm.ak.d locald = ((d.a)localObject1).aXF();
    localObject1 = locald.aYJ();
    if (localObject1 == null)
    {
      paramege = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizFeedbackReq");
      AppMethodBeat.o(195301);
      throw paramege;
    }
    oj localoj = (oj)localObject1;
    localoj.KUg = 3;
    localObject1 = new LinkedList();
    localObject2 = paramege.Nga.KUf;
    p.g(localObject2, "wrapper.extraInfo.BizInfo");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (pj)((Iterator)localObject3).next();
      os localos = new os();
      localos.KSV = ((pj)localObject4).UserName;
      LinkedList localLinkedList = new LinkedList();
      Object localObject5 = ((pj)localObject4).KWy;
      p.g(localObject5, "it.AppMsg");
      Object localObject6 = (Iterable)localObject5;
      localObject5 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject6, 10));
      localObject6 = ((Iterable)localObject6).iterator();
      while (((Iterator)localObject6).hasNext()) {
        ((Collection)localObject5).add(((pi)((Iterator)localObject6).next()).KSj);
      }
      localLinkedList.addAll((Collection)localObject5);
      localObject5 = x.SXb;
      localos.KUB = localLinkedList;
      localos.KUE = ((pj)localObject4).oUJ;
      localObject4 = x.SXb;
      ((Collection)localObject2).add(localos);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localObject2 = x.SXb;
    localoj.KUf = ((LinkedList)localObject1);
    localoj.KUh = paramege.style;
    localObject2 = paramege.event;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localoj.KUi = ((String)localObject1);
    localoj.KUj = paramege.MOC;
    localObject2 = paramege.Nga.KUk;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localoj.KUk = ((String)localObject1);
    localObject2 = paramege.Nga.KUo;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localoj.KUo = ((String)localObject1);
    localoj.KUp = paramege.dSJ;
    localoj.gCs = m(paramz);
    paramz = y.NPP;
    y.Bt(11L);
    Log.i("MicroMsg.BizTLRecCardUtil", "doBizFeedbackReq recycleCardList size = " + localoj.gCs.size());
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramege = x.SXb;
      paramege = x.SXb;
      com.tencent.mm.ak.aa.a(locald, (aa.a)new a(locald));
      AppMethodBeat.o(195301);
      return;
      paramz = new oi();
      paramz.KSV = ((pj)paramege.Nga.KUf.get(0)).UserName;
      if (!Util.isNullOrNil(paramList))
      {
        paramege = new LinkedList();
        if (paramList == null) {
          p.hyc();
        }
        localObject1 = (Iterable)paramList;
        paramList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          localObject2 = new csz();
          ((csz)localObject2).iAc = ((String)localObject3);
          localObject3 = x.SXb;
          paramList.add(localObject2);
        }
        paramege.addAll((Collection)paramList);
        paramList = x.SXb;
        paramz.KJk = paramege;
      }
      paramege = x.SXb;
      localoj.KUm = paramz;
      continue;
      switch (paramege.style)
      {
      default: 
        paramege = new uc();
        paramege.dDH = 1;
        paramList = x.SXb;
        localoj.KUl = paramege;
        break;
      case 102: 
        paramege = new uc();
        if (!Util.isNullOrNil(paramList))
        {
          paramz = new LinkedList();
          if (paramList == null) {
            p.hyc();
          }
          localObject1 = (Iterable)paramList;
          paramList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            localObject2 = new csz();
            ((csz)localObject2).iAc = ((String)localObject3);
            localObject3 = x.SXb;
            paramList.add(localObject2);
          }
          paramz.addAll((Collection)paramList);
          paramList = x.SXb;
          paramege.KJk = paramz;
        }
        paramList = x.SXb;
        localoj.KUl = paramege;
      }
    }
  }
  
  public static final boolean cmL()
  {
    return put;
  }
  
  public static final void cmM()
  {
    AppMethodBeat.i(195298);
    if (((b)g.af(b.class)).a(b.a.rUa, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      put = bool;
      AppMethodBeat.o(195298);
      return;
    }
  }
  
  public static final String cmN()
  {
    AppMethodBeat.i(195299);
    Object localObject = new dlj();
    ((dlj)localObject).gCs = m(null);
    localObject = Base64.encode(((dlj)localObject).toByteArray(), 2);
    p.g(localObject, "Base64.encode(recycleCar…eArray(), Base64.NO_WRAP)");
    Charset localCharset = StandardCharsets.UTF_8;
    p.g(localCharset, "StandardCharsets.UTF_8");
    localObject = new String((byte[])localObject, localCharset);
    AppMethodBeat.o(195299);
    return localObject;
  }
  
  private static LinkedList<dli> m(z paramz)
  {
    AppMethodBeat.i(195300);
    Object localObject1 = y.NPP;
    int i = kotlin.k.j.na(kotlin.k.j.mZ(y.aTI().decodeInt("RecycleCardMaxMsgCount", 10), 2), 50);
    Object localObject2 = ag.ban().kL(620757041, i);
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
        localObject4 = new dli();
        p.g(localObject3, "info");
        paramz = ((z)localObject3).gAD();
        if (paramz != null) {}
        for (paramz = paramz.dSJ;; paramz = null)
        {
          ((dli)localObject4).KUp = paramz;
          ((dli)localObject4).KVE = ((z)localObject3).field_msgId;
          ((dli)localObject4).MPi = String.valueOf(((z)localObject3).field_msgId);
          ((LinkedList)localObject1).add(localObject4);
          break;
        }
      }
    }
    AppMethodBeat.o(195300);
    return localObject1;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements aa.a
  {
    a(com.tencent.mm.ak.d paramd) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(195297);
      p.h(paramd, "<anonymous parameter 3>");
      p.h(paramq, "<anonymous parameter 4>");
      paramString = this.puu;
      p.g(paramString, "rr");
      paramString = (ok)paramString.aYK();
      if (paramString == null)
      {
        AppMethodBeat.o(195297);
        return 0;
      }
      paramd = y.NPP;
      y.aTI().encode("RecycleCardMaxMsgCount", paramString.KUq);
      com.tencent.mm.ac.d.b("MicroMsg.BizRecycleCardLogic", (kotlin.g.a.a)new kotlin.g.b.q(paramString) {});
      AppMethodBeat.o(195297);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.l
 * JD-Core Version:    0.7.0.1
 */