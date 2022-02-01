package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.n.d;
import d.v;
import d.y;
import java.nio.charset.Charset;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr;", "", "()V", "Companion", "plugin-card_release"})
public final class a
{
  private static final String TAG = "MicroMsg.CardSnapshotMgr";
  public static final a nXE;
  
  static
  {
    AppMethodBeat.i(112380);
    nXE = new a((byte)0);
    TAG = "MicroMsg.CardSnapshotMgr";
    AppMethodBeat.o(112380);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCouponListSortInfo", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "getVipCardListSortInfo", "loadCouponCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "loadHomePageSnapshot", "", "storeList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "topList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "cardSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadHomePageV3Snapshot", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "loadInvalidTicketPageSnapshot", "", "invalidTicketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "loadTicketPageSnapshot", "jumpList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "ticketList", "licenseList", "loadVipCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "saveCouponCardListSnapshot", "response", "saveCouponListSortInfo", "sortInfo", "saveHomePageSnapshot", "sortInfoList", "saveHomePageV3Snapshot", "saveInvalidTicketPageSnapshot", "saveTicketPageSnapshot", "saveVipCardListSnapshot", "saveVipCardListSortInfo", "plugin-card_release"})
  public static final class a
  {
    public static azw bQA()
    {
      AppMethodBeat.i(206237);
      ac.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.agR();
      k.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).agA().get(ah.a.GSm, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(206237);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new azw();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(206237);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (azw)localObject1;
        AppMethodBeat.o(206237);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static ru bQB()
    {
      AppMethodBeat.i(206238);
      ac.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.agR();
      k.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).agA().get(ah.a.GSn, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(206238);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new ru();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(206238);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (ru)localObject1;
        AppMethodBeat.o(206238);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static avx bQC()
    {
      AppMethodBeat.i(206239);
      ac.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.agR();
      k.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).agA().get(ah.a.GSo, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(206239);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new avx();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(206239);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (avx)localObject1;
        AppMethodBeat.o(206239);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static ru bQD()
    {
      AppMethodBeat.i(206240);
      ac.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.agR();
      k.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).agA().get(ah.a.GSp, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(206240);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new ru();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(206240);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (ru)localObject1;
        AppMethodBeat.o(206240);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static baa bQz()
    {
      AppMethodBeat.i(206236);
      ac.d(a.access$getTAG$cp(), "load home page v3 snapshot");
      Object localObject1 = g.agR();
      k.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).agA().get(ah.a.GSl, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(206236);
        return null;
      }
      localObject1 = (com.tencent.mm.bw.a)new baa();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(206236);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (baa)localObject1;
        AppMethodBeat.o(206236);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    public static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      public b(ru paramru)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    public static final class e
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      public e(ru paramru)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.a
 * JD-Core Version:    0.7.0.1
 */