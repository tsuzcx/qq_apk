package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class m
{
  public static void a(a parama, g paramg)
  {
    AppMethodBeat.i(103438);
    if ((paramg.field_favProto.oeJ == null) || (paramg.field_favProto.oeJ.isEmpty()))
    {
      AppMethodBeat.o(103438);
      return;
    }
    Object localObject = ((ajx)paramg.field_favProto.oeJ.getFirst()).GAA;
    if (localObject == null)
    {
      AppMethodBeat.o(103438);
      return;
    }
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("20source_publishid", ((aka)localObject).hFa + ",");
    localg.m("21uxinfo", ((aka)localObject).hEZ + ",");
    localg.m("22clienttime", bu.fpO() + ",");
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
      ae.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + localg.RD());
      ((d)com.tencent.mm.kernel.g.ab(d.class)).f(12990, new Object[] { localg });
      AppMethodBeat.o(103438);
      return;
    }
  }
  
  public static void a(c paramc, g paramg, d paramd, int paramInt)
  {
    AppMethodBeat.i(103439);
    if ((paramg.field_favProto.oeJ == null) || (paramg.field_favProto.oeJ.isEmpty()))
    {
      AppMethodBeat.o(103439);
      return;
    }
    aka localaka = ((ajx)paramg.field_favProto.oeJ.getFirst()).GAA;
    if (localaka == null)
    {
      AppMethodBeat.o(103439);
      return;
    }
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("20source_publishid", localaka.hFa + ",");
    localg.m("21uxinfo", localaka.hEZ + ",");
    localg.m("22clienttime", bu.fpO() + ",");
    localg.m("23video_statu", d.a(paramd) + ",");
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
      ae.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + localg.RD());
      com.tencent.mm.plugin.report.service.g.yxI.f(12991, new Object[] { localg });
      AppMethodBeat.o(103439);
      return;
    }
  }
  
  public static void x(g paramg)
  {
    AppMethodBeat.i(103437);
    if ((paramg.field_favProto.oeJ == null) || (paramg.field_favProto.oeJ.isEmpty()))
    {
      AppMethodBeat.o(103437);
      return;
    }
    ajx localajx = (ajx)paramg.field_favProto.oeJ.getFirst();
    Object localObject = localajx.GAA;
    if (localObject == null)
    {
      AppMethodBeat.o(103437);
      return;
    }
    com.tencent.mm.modelsns.g localg = new com.tencent.mm.modelsns.g();
    localg.m("20source_publishid", ((aka)localObject).hFa + ",");
    localg.m("21uxinfo", ((aka)localObject).hEZ + ",");
    localg.m("22clienttime", bu.fpO() + ",");
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
      ((j)com.tencent.mm.kernel.g.ab(j.class)).b(localajx.dIA, localg);
      ae.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + localg.RD());
      com.tencent.mm.plugin.report.service.g.yxI.f(12989, new Object[] { localg });
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
      rBg = new a("PlayIcon", 0, 1);
      rBh = new a("EnterFullScreen", 1, 2);
      rBi = new a("EnterCompleteVideo", 2, 3);
      rBj = new a("DetailInVideo", 3, 4);
      rBk = new a("LeavelFullScreen", 4, 5);
      rBl = new a("LeaveCompleteVideo", 5, 6);
      rBm = new a("SightLoaded", 6, 7);
      rBn = new a[] { rBg, rBh, rBi, rBj, rBk, rBl, rBm };
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
      rBo = new b("Sight", 0, 1);
      rBp = new b("AdUrl", 1, 2);
      rBq = new b("Chat", 2, 3);
      rBr = new b("TalkChat", 3, 4);
      rBs = new b("Fav", 4, 5);
      rBt = new b[] { rBo, rBp, rBq, rBr, rBs };
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
      rBu = new c("Chat", 0, 2);
      rBv = new c("Chatroom", 1, 3);
      rBw = new c("Sns", 2, 4);
      rBx = new c[] { rBu, rBv, rBw };
      AppMethodBeat.o(103433);
    }
    
    private c(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum d
  {
    private int value = 0;
    
    static
    {
      AppMethodBeat.i(103436);
      rBy = new d("Samll", 0, 1);
      rBz = new d("Full", 1, 2);
      rBA = new d("Complete", 2, 3);
      rBB = new d[] { rBy, rBz, rBA };
      AppMethodBeat.o(103436);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.m
 * JD-Core Version:    0.7.0.1
 */