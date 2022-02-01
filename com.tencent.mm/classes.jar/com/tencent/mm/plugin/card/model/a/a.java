package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.rk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.n.d;
import d.v;
import d.y;
import java.nio.charset.Charset;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr;", "", "()V", "Companion", "plugin-card_release"})
public final class a
{
  private static final String TAG = "MicroMsg.CardSnapshotMgr";
  public static final a nuE;
  
  static
  {
    AppMethodBeat.i(112380);
    nuE = new a((byte)0);
    TAG = "MicroMsg.CardSnapshotMgr";
    AppMethodBeat.o(112380);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCouponListSortInfo", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "getVipCardListSortInfo", "loadCouponCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "loadHomePageSnapshot", "", "storeList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "topList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "cardSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadHomePageV3Snapshot", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "loadInvalidTicketPageSnapshot", "", "invalidTicketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "loadTicketPageSnapshot", "jumpList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "ticketList", "licenseList", "loadVipCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "saveCouponCardListSnapshot", "response", "saveCouponListSortInfo", "sortInfo", "saveHomePageSnapshot", "sortInfoList", "saveHomePageV3Snapshot", "saveInvalidTicketPageSnapshot", "saveTicketPageSnapshot", "saveVipCardListSnapshot", "saveVipCardListSortInfo", "plugin-card_release"})
  public static final class a
  {
    public static awi bJm()
    {
      AppMethodBeat.i(192662);
      ad.d(a.access$getTAG$cp(), "load home page v3 snapshot");
      Object localObject1 = g.afB();
      k.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).afk().get(ae.a.Fur, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(192662);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new awi();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(192662);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (awi)localObject1;
        AppMethodBeat.o(192662);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static awe bJn()
    {
      AppMethodBeat.i(192663);
      ad.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.afB();
      k.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).afk().get(ae.a.Fus, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(192663);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new awe();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(192663);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (awe)localObject1;
        AppMethodBeat.o(192663);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static rk bJo()
    {
      AppMethodBeat.i(192664);
      ad.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.afB();
      k.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).afk().get(ae.a.Fut, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(192664);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new rk();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(192664);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (rk)localObject1;
        AppMethodBeat.o(192664);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static ast bJp()
    {
      AppMethodBeat.i(192665);
      ad.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.afB();
      k.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).afk().get(ae.a.Fuu, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(192665);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new ast();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(192665);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (ast)localObject1;
        AppMethodBeat.o(192665);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    public static rk bJq()
    {
      AppMethodBeat.i(192666);
      ad.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.afB();
      k.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).afk().get(ae.a.Fuv, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(192666);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new rk();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(192666);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (rk)localObject1;
        AppMethodBeat.o(192666);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    public static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      public b(rk paramrk)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    public static final class e
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      public e(rk paramrk)
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