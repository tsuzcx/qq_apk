package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class m
{
  public static void a(a parama, g paramg)
  {
    AppMethodBeat.i(103438);
    if ((paramg.field_favProto.nZa == null) || (paramg.field_favProto.nZa.isEmpty()))
    {
      AppMethodBeat.o(103438);
      return;
    }
    Object localObject = ((ajn)paramg.field_favProto.nZa.getFirst()).GhR;
    if (localObject == null)
    {
      AppMethodBeat.o(103438);
      return;
    }
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("20source_publishid", ((ajq)localObject).hCl + ",");
    localg.m("21uxinfo", ((ajq)localObject).hCk + ",");
    localg.m("22clienttime", bt.flT() + ",");
    localg.m("23video_statu", ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localg.m("24source_type", i + ",");
      localg.m("25scene", "5,");
      localg.m("26action_type", a.a(parama) + ",");
      localg.m("27scene_chatname", ",");
      localg.m("28scene_username", paramg.field_fromUser + ",");
      localg.m("29curr_publishid", ",");
      localg.m("30curr_msgid", "0,");
      localg.m("31curr_favid", paramg.field_id + ",");
      localg.m("32elapsed_time", "0,");
      localg.m("33load_time", "0,");
      localg.m("34is_load_complete", "0,");
      localg.m("35destination", "0,");
      localg.m("36chatroom_membercount", "0,");
      ad.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + localg.RE());
      ((d)com.tencent.mm.kernel.g.ab(d.class)).f(12990, new Object[] { localg });
      AppMethodBeat.o(103438);
      return;
    }
  }
  
  public static void a(c paramc, g paramg, m.d paramd, int paramInt)
  {
    AppMethodBeat.i(103439);
    if ((paramg.field_favProto.nZa == null) || (paramg.field_favProto.nZa.isEmpty()))
    {
      AppMethodBeat.o(103439);
      return;
    }
    ajq localajq = ((ajn)paramg.field_favProto.nZa.getFirst()).GhR;
    if (localajq == null)
    {
      AppMethodBeat.o(103439);
      return;
    }
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("20source_publishid", localajq.hCl + ",");
    localg.m("21uxinfo", localajq.hCk + ",");
    localg.m("22clienttime", bt.flT() + ",");
    localg.m("23video_statu", m.d.a(paramd) + ",");
    paramd = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localg.m("24source_type", i + ",");
      localg.m("25scene", "5,");
      localg.m("26action_type", c.a(paramc) + ",");
      localg.m("27scene_chatname", ",");
      localg.m("28scene_username", paramg.field_fromUser + ",");
      localg.m("29curr_publishid", ",");
      localg.m("30curr_msgid", "0,");
      localg.m("31curr_favid", paramg.field_id + ",");
      localg.m("32chatroom_membercount", "0,");
      localg.m("33chatroom_toMemberCount", paramInt + ",");
      ad.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + localg.RE());
      com.tencent.mm.plugin.report.service.g.yhR.f(12991, new Object[] { localg });
      AppMethodBeat.o(103439);
      return;
    }
  }
  
  public static void x(g paramg)
  {
    AppMethodBeat.i(103437);
    if ((paramg.field_favProto.nZa == null) || (paramg.field_favProto.nZa.isEmpty()))
    {
      AppMethodBeat.o(103437);
      return;
    }
    ajn localajn = (ajn)paramg.field_favProto.nZa.getFirst();
    Object localObject = localajn.GhR;
    if (localObject == null)
    {
      AppMethodBeat.o(103437);
      return;
    }
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("20source_publishid", ((ajq)localObject).hCl + ",");
    localg.m("21uxinfo", ((ajq)localObject).hCk + ",");
    localg.m("22clienttime", bt.flT() + ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localg.m("23source_type", i + ",");
      localg.m("24scene", "5,");
      localg.m("25scene_chatname", ",");
      localg.m("26scene_username", paramg.field_fromUser + ",");
      localg.m("27curr_publishid", ",");
      localg.m("28curr_msgid", "0,");
      localg.m("29curr_favid", paramg.field_id + ",");
      localg.m("30isdownload", "0,");
      localg.m("31chatroom_membercount", "0,");
      ((j)com.tencent.mm.kernel.g.ab(j.class)).b(localajn.dHv, localg);
      ad.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + localg.RE());
      com.tencent.mm.plugin.report.service.g.yhR.f(12989, new Object[] { localg });
      AppMethodBeat.o(103437);
      return;
    }
  }
  
  public static enum a
  {
    private int value = 0;
    
    static
    {
      AppMethodBeat.i(103427);
      rsT = new a("PlayIcon", 0, 1);
      rsU = new a("EnterFullScreen", 1, 2);
      rsV = new a("EnterCompleteVideo", 2, 3);
      rsW = new a("DetailInVideo", 3, 4);
      rsX = new a("LeavelFullScreen", 4, 5);
      rsY = new a("LeaveCompleteVideo", 5, 6);
      rsZ = new a("SightLoaded", 6, 7);
      rta = new a[] { rsT, rsU, rsV, rsW, rsX, rsY, rsZ };
      AppMethodBeat.o(103427);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum b
  {
    public int value = 0;
    
    static
    {
      AppMethodBeat.i(103430);
      rtb = new b("Sight", 0, 1);
      rtc = new b("AdUrl", 1, 2);
      rtd = new b("Chat", 2, 3);
      rte = new b("TalkChat", 3, 4);
      rtf = new b("Fav", 4, 5);
      rtg = new b[] { rtb, rtc, rtd, rte, rtf };
      AppMethodBeat.o(103430);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum c
  {
    private int value = 0;
    
    static
    {
      AppMethodBeat.i(103433);
      rth = new c("Chat", 0, 2);
      rti = new c("Chatroom", 1, 3);
      rtj = new c("Sns", 2, 4);
      rtk = new c[] { rth, rti, rtj };
      AppMethodBeat.o(103433);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.m
 * JD-Core Version:    0.7.0.1
 */