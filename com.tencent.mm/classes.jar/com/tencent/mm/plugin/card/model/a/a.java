package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr;", "", "()V", "Companion", "plugin-card_release"})
public final class a
{
  private static final String TAG = "MicroMsg.CardSnapshotMgr";
  public static final a pVg;
  
  static
  {
    AppMethodBeat.i(112380);
    pVg = new a((byte)0);
    TAG = "MicroMsg.CardSnapshotMgr";
    AppMethodBeat.o(112380);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCouponListSortInfo", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "getVipCardListSortInfo", "loadCouponCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "loadCouponGiftCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "loadCouponHistoryCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "loadHomePageSnapshot", "", "storeList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "topList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "cardSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadHomePageV3Snapshot", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "loadInvalidTicketPageSnapshot", "", "invalidTicketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "loadMemberCardHistoryListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "loadTicketPageSnapshot", "jumpList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "ticketList", "licenseList", "Lcom/tencent/mm/protocal/protobuf/PageUnderList;", "loadVipCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "saveCouponAndGiftCardListSnapshot", "response", "saveCouponCardListSnapshot", "saveCouponHistoryCardListSnapshot", "saveCouponListSortInfo", "sortInfo", "saveHomePageSnapshot", "sortInfoList", "saveHomePageV3Snapshot", "saveInvalidTicketPageSnapshot", "saveMemberCardHistoryListSnapshot", "saveTicketPageSnapshot", "saveVipCardListSnapshot", "saveVipCardListSortInfo", "plugin-card_release"})
  public static final class a
  {
    public static void a(bly parambly)
    {
      AppMethodBeat.i(201366);
      p.h(parambly, "response");
      Log.d(a.access$getTAG$cp(), "save coupon and gift card list snapshot");
      com.tencent.mm.ac.d.i((kotlin.g.a.a)new a(parambly));
      AppMethodBeat.o(201366);
    }
    
    public static bqq cuh()
    {
      AppMethodBeat.i(201361);
      Log.d(a.access$getTAG$cp(), "load home page v3 snapshot");
      Object localObject1 = g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).azQ().get(ar.a.OhM, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(201361);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new bqq();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(201361);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (bqq)localObject1;
        AppMethodBeat.o(201361);
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
    
    public static bqk cui()
    {
      AppMethodBeat.i(201362);
      Log.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).azQ().get(ar.a.OhN, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(201362);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new bqk();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(201362);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (bqk)localObject1;
        AppMethodBeat.o(201362);
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
    
    public static uv cuj()
    {
      AppMethodBeat.i(201363);
      Log.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).azQ().get(ar.a.OhO, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(201363);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new uv();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(201363);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (uv)localObject1;
        AppMethodBeat.o(201363);
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
    
    public static bma cuk()
    {
      AppMethodBeat.i(201364);
      Log.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).azQ().get(ar.a.OhP, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(201364);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new bma();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(201364);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (bma)localObject1;
        AppMethodBeat.o(201364);
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
    
    public static bly cul()
    {
      AppMethodBeat.i(201365);
      Log.d(a.access$getTAG$cp(), "load coupon and gift card list snapshot");
      Object localObject1 = g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).azQ().get(ar.a.OhQ, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(201365);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new bly();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(201365);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (bly)localObject1;
        AppMethodBeat.o(201365);
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
    
    public static blw cum()
    {
      AppMethodBeat.i(201367);
      Log.d(a.access$getTAG$cp(), "load coupon History card list snapshot");
      Object localObject1 = g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).azQ().get(ar.a.OhR, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(201367);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new blw();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(201367);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (blw)localObject1;
        AppMethodBeat.o(201367);
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
    
    public static bqi cun()
    {
      AppMethodBeat.i(201368);
      Log.d(a.access$getTAG$cp(), "load coupon History card list snapshot");
      Object localObject1 = g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).azQ().get(ar.a.OhS, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(201368);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new bqi();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(201368);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (bqi)localObject1;
        AppMethodBeat.o(201368);
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
    
    public static uv cuo()
    {
      AppMethodBeat.i(201369);
      Log.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).azQ().get(ar.a.OhT, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(201369);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new uv();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(201369);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (uv)localObject1;
        AppMethodBeat.o(201369);
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
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(bly parambly)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    public static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      public b(bma parambma)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    public static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      public c(blw paramblw)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    public static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      public d(uv paramuv)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    public static final class e
      extends q
      implements kotlin.g.a.a<x>
    {
      public e(bqq parambqq)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    public static final class f
      extends q
      implements kotlin.g.a.a<x>
    {
      public f(bqi parambqi)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    public static final class g
      extends q
      implements kotlin.g.a.a<x>
    {
      public g(bqk parambqk)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    public static final class h
      extends q
      implements kotlin.g.a.a<x>
    {
      public h(uv paramuv)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.a
 * JD-Core Version:    0.7.0.1
 */