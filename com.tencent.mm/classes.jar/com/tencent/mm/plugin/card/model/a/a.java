package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.d;
import d.v;
import d.z;
import java.nio.charset.Charset;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr;", "", "()V", "Companion", "plugin-card_release"})
public final class a
{
  private static final String TAG = "MicroMsg.CardSnapshotMgr";
  public static final a oHA;
  
  static
  {
    AppMethodBeat.i(112380);
    oHA = new a((byte)0);
    TAG = "MicroMsg.CardSnapshotMgr";
    AppMethodBeat.o(112380);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCouponListSortInfo", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "getVipCardListSortInfo", "loadCouponCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "loadHomePageSnapshot", "", "storeList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "topList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "cardSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadHomePageV3Snapshot", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "loadInvalidTicketPageSnapshot", "", "invalidTicketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "loadTicketPageSnapshot", "jumpList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "ticketList", "licenseList", "Lcom/tencent/mm/protocal/protobuf/PageUnderList;", "loadVipCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "saveCouponCardListSnapshot", "response", "saveCouponListSortInfo", "sortInfo", "saveHomePageSnapshot", "sortInfoList", "saveHomePageV3Snapshot", "saveInvalidTicketPageSnapshot", "saveTicketPageSnapshot", "saveVipCardListSnapshot", "saveVipCardListSortInfo", "plugin-card_release"})
  public static final class a
  {
    public static beu bWt()
    {
      AppMethodBeat.i(218392);
      ae.d(a.access$getTAG$cp(), "load home page v3 snapshot");
      Object localObject1 = g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).ajA().get(am.a.IZq, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(218392);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new beu();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(218392);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (beu)localObject1;
        AppMethodBeat.o(218392);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static beq bWu()
    {
      AppMethodBeat.i(218393);
      ae.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).ajA().get(am.a.IZr, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(218393);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new beq();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(218393);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (beq)localObject1;
        AppMethodBeat.o(218393);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static tq bWv()
    {
      AppMethodBeat.i(218394);
      ae.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).ajA().get(am.a.IZs, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(218394);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new tq();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(218394);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (tq)localObject1;
        AppMethodBeat.o(218394);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static bal bWw()
    {
      AppMethodBeat.i(218395);
      ae.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).ajA().get(am.a.IZt, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(218395);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new bal();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(218395);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (bal)localObject1;
        AppMethodBeat.o(218395);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static tq bWx()
    {
      AppMethodBeat.i(218396);
      ae.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).ajA().get(am.a.IZu, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(218396);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new tq();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(218396);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (tq)localObject1;
        AppMethodBeat.o(218396);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    public static final class b
      extends q
      implements d.g.a.a<z>
    {
      public b(tq paramtq)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    public static final class e
      extends q
      implements d.g.a.a<z>
    {
      public e(tq paramtq)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.a
 * JD-Core Version:    0.7.0.1
 */