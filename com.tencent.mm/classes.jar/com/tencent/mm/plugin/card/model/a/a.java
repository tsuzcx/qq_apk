package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.protocal.protobuf.byc;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.protocal.protobuf.ux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr;", "", "()V", "Companion", "plugin-card_release"})
public final class a
{
  private static final String TAG = "MicroMsg.CardSnapshotMgr";
  public static final a trh;
  
  static
  {
    AppMethodBeat.i(112380);
    trh = new a((byte)0);
    TAG = "MicroMsg.CardSnapshotMgr";
    AppMethodBeat.o(112380);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCouponListSortInfo", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "getVipCardListSortInfo", "loadCouponCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "loadCouponGiftCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "loadCouponHistoryCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "loadHomePageSnapshot", "", "storeList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "topList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "cardSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadHomePageV3Snapshot", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "loadInvalidTicketPageSnapshot", "", "invalidTicketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "loadMemberCardHistoryListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "loadTicketPageSnapshot", "jumpList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "ticketList", "licenseList", "Lcom/tencent/mm/protocal/protobuf/PageUnderList;", "loadVipCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "saveCouponAndGiftCardListSnapshot", "response", "saveCouponCardListSnapshot", "saveCouponHistoryCardListSnapshot", "saveCouponListSortInfo", "sortInfo", "saveHomePageSnapshot", "sortInfoList", "saveHomePageV3Snapshot", "saveInvalidTicketPageSnapshot", "saveMemberCardHistoryListSnapshot", "saveTicketPageSnapshot", "saveVipCardListSnapshot", "saveVipCardListSortInfo", "plugin-card_release"})
  public static final class a
  {
    public static void a(bth parambth)
    {
      AppMethodBeat.i(244273);
      p.k(parambth, "response");
      Log.d(a.access$getTAG$cp(), "save coupon and gift card list snapshot");
      com.tencent.mm.ae.d.h((kotlin.g.a.a)new a(parambth));
      AppMethodBeat.o(244273);
    }
    
    public static byk cHJ()
    {
      AppMethodBeat.i(244267);
      Log.d(a.access$getTAG$cp(), "load home page v3 snapshot");
      Object localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((f)localObject1).aHp().get(ar.a.Vwc, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(244267);
        return null;
      }
      localObject1 = (com.tencent.mm.cd.a)new byk();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(244267);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (byk)localObject1;
        AppMethodBeat.o(244267);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static bye cHK()
    {
      AppMethodBeat.i(244268);
      Log.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((f)localObject1).aHp().get(ar.a.Vwd, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(244268);
        return null;
      }
      localObject1 = (com.tencent.mm.cd.a)new bye();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(244268);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (bye)localObject1;
        AppMethodBeat.o(244268);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static ux cHL()
    {
      AppMethodBeat.i(244269);
      Log.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((f)localObject1).aHp().get(ar.a.Vwe, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(244269);
        return null;
      }
      localObject1 = (com.tencent.mm.cd.a)new ux();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(244269);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (ux)localObject1;
        AppMethodBeat.o(244269);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static btj cHM()
    {
      AppMethodBeat.i(244270);
      Log.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((f)localObject1).aHp().get(ar.a.Vwf, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(244270);
        return null;
      }
      localObject1 = (com.tencent.mm.cd.a)new btj();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(244270);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (btj)localObject1;
        AppMethodBeat.o(244270);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static bth cHN()
    {
      AppMethodBeat.i(244272);
      Log.d(a.access$getTAG$cp(), "load coupon and gift card list snapshot");
      Object localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((f)localObject1).aHp().get(ar.a.Vwg, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(244272);
        return null;
      }
      localObject1 = (com.tencent.mm.cd.a)new bth();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(244272);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (bth)localObject1;
        AppMethodBeat.o(244272);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static btf cHO()
    {
      AppMethodBeat.i(244274);
      Log.d(a.access$getTAG$cp(), "load coupon History card list snapshot");
      Object localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((f)localObject1).aHp().get(ar.a.Vwh, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(244274);
        return null;
      }
      localObject1 = (com.tencent.mm.cd.a)new btf();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(244274);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (btf)localObject1;
        AppMethodBeat.o(244274);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static byc cHP()
    {
      AppMethodBeat.i(244275);
      Log.d(a.access$getTAG$cp(), "load coupon History card list snapshot");
      Object localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((f)localObject1).aHp().get(ar.a.Vwi, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(244275);
        return null;
      }
      localObject1 = (com.tencent.mm.cd.a)new byc();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(244275);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (byc)localObject1;
        AppMethodBeat.o(244275);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static ux cHQ()
    {
      AppMethodBeat.i(244277);
      Log.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((f)localObject1).aHp().get(ar.a.Vwj, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(244277);
        return null;
      }
      localObject1 = (com.tencent.mm.cd.a)new ux();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(244277);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (ux)localObject1;
        AppMethodBeat.o(244277);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(bth parambth)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    public static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      public b(btj parambtj)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    public static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      public c(btf parambtf)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    public static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      public d(ux paramux)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    public static final class e
      extends q
      implements kotlin.g.a.a<x>
    {
      public e(byk parambyk)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    public static final class f
      extends q
      implements kotlin.g.a.a<x>
    {
      public f(byc parambyc)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    public static final class g
      extends q
      implements kotlin.g.a.a<x>
    {
      public g(bye parambye)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    public static final class h
      extends q
      implements kotlin.g.a.a<x>
    {
      public h(ux paramux)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.a
 * JD-Core Version:    0.7.0.1
 */