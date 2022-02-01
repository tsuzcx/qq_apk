package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.protocal.protobuf.wo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr;", "", "()V", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a wvG;
  
  static
  {
    AppMethodBeat.i(112380);
    wvG = new a((byte)0);
    TAG = "MicroMsg.CardSnapshotMgr";
    AppMethodBeat.o(112380);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCouponListSortInfo", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "getVipCardListSortInfo", "loadCouponCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "loadCouponGiftCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "loadCouponHistoryCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "loadHomePageSnapshot", "", "storeList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "topList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "cardSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadHomePageV3Snapshot", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "loadInvalidTicketPageSnapshot", "", "invalidTicketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "loadMemberCardHistoryListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "loadTicketPageSnapshot", "jumpList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "ticketList", "licenseList", "Lcom/tencent/mm/protocal/protobuf/PageUnderList;", "loadVipCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "saveCouponAndGiftCardListSnapshot", "response", "saveCouponCardListSnapshot", "saveCouponHistoryCardListSnapshot", "saveCouponListSortInfo", "sortInfo", "saveHomePageSnapshot", "sortInfoList", "saveHomePageV3Snapshot", "saveInvalidTicketPageSnapshot", "saveMemberCardHistoryListSnapshot", "saveTicketPageSnapshot", "saveVipCardListSnapshot", "saveVipCardListSortInfo", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(cia paramcia)
    {
      AppMethodBeat.i(294566);
      s.u(paramcia, "response");
      Log.d(a.access$getTAG$cp(), "save coupon and gift card list snapshot");
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new a(paramcia));
      AppMethodBeat.o(294566);
    }
    
    public static cnn dla()
    {
      AppMethodBeat.i(294548);
      Log.d(a.access$getTAG$cp(), "load home page v3 snapshot");
      Object localObject3 = (String)h.baE().ban().get(at.a.acXM, "");
      Object localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(294548);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new cnn();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(294548);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (cnn)localObject1;
        AppMethodBeat.o(294548);
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
    
    public static cnh dlb()
    {
      AppMethodBeat.i(294550);
      Log.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject3 = (String)h.baE().ban().get(at.a.acXN, "");
      Object localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(294550);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new cnh();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(294550);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (cnh)localObject1;
        AppMethodBeat.o(294550);
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
    
    public static wo dlc()
    {
      AppMethodBeat.i(294554);
      Log.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject3 = (String)h.baE().ban().get(at.a.acXO, "");
      Object localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(294554);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new wo();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(294554);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (wo)localObject1;
        AppMethodBeat.o(294554);
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
    
    public static cic dld()
    {
      AppMethodBeat.i(294556);
      Log.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject3 = (String)h.baE().ban().get(at.a.acXP, "");
      Object localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(294556);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new cic();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(294556);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (cic)localObject1;
        AppMethodBeat.o(294556);
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
    
    public static cia dle()
    {
      AppMethodBeat.i(294563);
      Log.d(a.access$getTAG$cp(), "load coupon and gift card list snapshot");
      Object localObject3 = (String)h.baE().ban().get(at.a.acXQ, "");
      Object localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(294563);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new cia();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(294563);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (cia)localObject1;
        AppMethodBeat.o(294563);
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
    
    public static chy dlf()
    {
      AppMethodBeat.i(294569);
      Log.d(a.access$getTAG$cp(), "load coupon History card list snapshot");
      Object localObject3 = (String)h.baE().ban().get(at.a.acXR, "");
      Object localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(294569);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new chy();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(294569);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (chy)localObject1;
        AppMethodBeat.o(294569);
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
    
    public static cnf dlg()
    {
      AppMethodBeat.i(294572);
      Log.d(a.access$getTAG$cp(), "load coupon History card list snapshot");
      Object localObject3 = (String)h.baE().ban().get(at.a.acXS, "");
      Object localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(294572);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new cnf();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(294572);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (cnf)localObject1;
        AppMethodBeat.o(294572);
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
    
    public static wo dlh()
    {
      AppMethodBeat.i(294576);
      Log.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject3 = (String)h.baE().ban().get(at.a.acXT, "");
      Object localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(294576);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new wo();
      Charset localCharset = kotlin.n.d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(294576);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (wo)localObject1;
        AppMethodBeat.o(294576);
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
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(cia paramcia)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    public static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      public b(cic paramcic)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    public static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      public c(chy paramchy)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    public static final class d
      extends u
      implements kotlin.g.a.a<ah>
    {
      public d(wo paramwo)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    public static final class e
      extends u
      implements kotlin.g.a.a<ah>
    {
      public e(cnn paramcnn)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    public static final class f
      extends u
      implements kotlin.g.a.a<ah>
    {
      public f(cnf paramcnf)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    public static final class g
      extends u
      implements kotlin.g.a.a<ah>
    {
      public g(cnh paramcnh)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    public static final class h
      extends u
      implements kotlin.g.a.a<ah>
    {
      public h(wo paramwo)
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