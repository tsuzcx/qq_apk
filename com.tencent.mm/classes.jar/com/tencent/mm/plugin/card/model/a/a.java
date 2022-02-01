package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import d.n.d;
import d.v;
import java.nio.charset.Charset;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr;", "", "()V", "Companion", "plugin-card_release"})
public final class a
{
  private static final String TAG = "MicroMsg.CardSnapshotMgr";
  public static final a oAY;
  
  static
  {
    AppMethodBeat.i(112380);
    oAY = new a((byte)0);
    TAG = "MicroMsg.CardSnapshotMgr";
    AppMethodBeat.o(112380);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCouponListSortInfo", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "getVipCardListSortInfo", "loadCouponCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "loadHomePageSnapshot", "", "storeList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "topList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "cardSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadHomePageV3Snapshot", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "loadInvalidTicketPageSnapshot", "", "invalidTicketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "loadTicketPageSnapshot", "jumpList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "ticketList", "licenseList", "Lcom/tencent/mm/protocal/protobuf/PageUnderList;", "loadVipCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "saveCouponCardListSnapshot", "response", "saveCouponListSortInfo", "sortInfo", "saveHomePageSnapshot", "sortInfoList", "saveHomePageV3Snapshot", "saveInvalidTicketPageSnapshot", "saveTicketPageSnapshot", "saveVipCardListSnapshot", "saveVipCardListSortInfo", "plugin-card_release"})
  public static final class a
  {
    public static bee bVe()
    {
      AppMethodBeat.i(215431);
      ad.d(a.access$getTAG$cp(), "load home page v3 snapshot");
      Object localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).ajl().get(al.a.IEQ, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(215431);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new bee();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(215431);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (bee)localObject1;
        AppMethodBeat.o(215431);
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
    
    public static bea bVf()
    {
      AppMethodBeat.i(215432);
      ad.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).ajl().get(al.a.IER, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(215432);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new bea();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(215432);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (bea)localObject1;
        AppMethodBeat.o(215432);
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
    
    public static to bVg()
    {
      AppMethodBeat.i(215433);
      ad.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).ajl().get(al.a.IES, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(215433);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new to();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(215433);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (to)localObject1;
        AppMethodBeat.o(215433);
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
    
    public static azv bVh()
    {
      AppMethodBeat.i(215434);
      ad.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).ajl().get(al.a.IET, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(215434);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new azv();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(215434);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (azv)localObject1;
        AppMethodBeat.o(215434);
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
    
    public static to bVi()
    {
      AppMethodBeat.i(215435);
      ad.d(a.access$getTAG$cp(), "load vip card list snapshot");
      Object localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject3 = (String)((e)localObject1).ajl().get(al.a.IEU, "");
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(215435);
        return null;
      }
      localObject1 = (com.tencent.mm.bx.a)new to();
      Charset localCharset = d.ISO_8859_1;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(215435);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (to)localObject1;
        AppMethodBeat.o(215435);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.a
 * JD-Core Version:    0.7.0.1
 */