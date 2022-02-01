package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class m
{
  public static void a(a parama, g paramg)
  {
    AppMethodBeat.i(103438);
    if ((paramg.field_favProto.nxC == null) || (paramg.field_favProto.nxC.isEmpty()))
    {
      AppMethodBeat.o(103438);
      return;
    }
    Object localObject = ((agx)paramg.field_favProto.nxC.getFirst()).EAf;
    if (localObject == null)
    {
      AppMethodBeat.o(103438);
      return;
    }
    f localf = new f();
    localf.n("20source_publishid", ((aha)localObject).hkc + ",");
    localf.n("21uxinfo", ((aha)localObject).hkb + ",");
    localf.n("22clienttime", bs.eWj() + ",");
    localf.n("23video_statu", ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localf.n("24source_type", i + ",");
      localf.n("25scene", "5,");
      localf.n("26action_type", a.a(parama) + ",");
      localf.n("27scene_chatname", ",");
      localf.n("28scene_username", paramg.field_fromUser + ",");
      localf.n("29curr_publishid", ",");
      localf.n("30curr_msgid", "0,");
      localf.n("31curr_favid", paramg.field_id + ",");
      localf.n("32elapsed_time", "0,");
      localf.n("33load_time", "0,");
      localf.n("34is_load_complete", "0,");
      localf.n("35destination", "0,");
      localf.n("36chatroom_membercount", "0,");
      ac.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + localf.PS());
      ((d)com.tencent.mm.kernel.g.ab(d.class)).f(12990, new Object[] { localf });
      AppMethodBeat.o(103438);
      return;
    }
  }
  
  public static void a(c paramc, g paramg, d paramd, int paramInt)
  {
    AppMethodBeat.i(103439);
    if ((paramg.field_favProto.nxC == null) || (paramg.field_favProto.nxC.isEmpty()))
    {
      AppMethodBeat.o(103439);
      return;
    }
    aha localaha = ((agx)paramg.field_favProto.nxC.getFirst()).EAf;
    if (localaha == null)
    {
      AppMethodBeat.o(103439);
      return;
    }
    f localf = new f();
    localf.n("20source_publishid", localaha.hkc + ",");
    localf.n("21uxinfo", localaha.hkb + ",");
    localf.n("22clienttime", bs.eWj() + ",");
    localf.n("23video_statu", d.a(paramd) + ",");
    paramd = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localf.n("24source_type", i + ",");
      localf.n("25scene", "5,");
      localf.n("26action_type", c.a(paramc) + ",");
      localf.n("27scene_chatname", ",");
      localf.n("28scene_username", paramg.field_fromUser + ",");
      localf.n("29curr_publishid", ",");
      localf.n("30curr_msgid", "0,");
      localf.n("31curr_favid", paramg.field_id + ",");
      localf.n("32chatroom_membercount", "0,");
      localf.n("33chatroom_toMemberCount", paramInt + ",");
      ac.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + localf.PS());
      h.wUl.f(12991, new Object[] { localf });
      AppMethodBeat.o(103439);
      return;
    }
  }
  
  public static void x(g paramg)
  {
    AppMethodBeat.i(103437);
    if ((paramg.field_favProto.nxC == null) || (paramg.field_favProto.nxC.isEmpty()))
    {
      AppMethodBeat.o(103437);
      return;
    }
    agx localagx = (agx)paramg.field_favProto.nxC.getFirst();
    Object localObject = localagx.EAf;
    if (localObject == null)
    {
      AppMethodBeat.o(103437);
      return;
    }
    f localf = new f();
    localf.n("20source_publishid", ((aha)localObject).hkc + ",");
    localf.n("21uxinfo", ((aha)localObject).hkb + ",");
    localf.n("22clienttime", bs.eWj() + ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localf.n("23source_type", i + ",");
      localf.n("24scene", "5,");
      localf.n("25scene_chatname", ",");
      localf.n("26scene_username", paramg.field_fromUser + ",");
      localf.n("27curr_publishid", ",");
      localf.n("28curr_msgid", "0,");
      localf.n("29curr_favid", paramg.field_id + ",");
      localf.n("30isdownload", "0,");
      localf.n("31chatroom_membercount", "0,");
      ((j)com.tencent.mm.kernel.g.ab(j.class)).b(localagx.dvs, localf);
      ac.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + localf.PS());
      h.wUl.f(12989, new Object[] { localf });
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
      qIS = new a("PlayIcon", 0, 1);
      qIT = new a("EnterFullScreen", 1, 2);
      qIU = new a("EnterCompleteVideo", 2, 3);
      qIV = new a("DetailInVideo", 3, 4);
      qIW = new a("LeavelFullScreen", 4, 5);
      qIX = new a("LeaveCompleteVideo", 5, 6);
      qIY = new a("SightLoaded", 6, 7);
      qIZ = new a[] { qIS, qIT, qIU, qIV, qIW, qIX, qIY };
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
      qJa = new b("Sight", 0, 1);
      qJb = new b("AdUrl", 1, 2);
      qJc = new b("Chat", 2, 3);
      qJd = new b("TalkChat", 3, 4);
      qJe = new b("Fav", 4, 5);
      qJf = new b[] { qJa, qJb, qJc, qJd, qJe };
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
      qJg = new c("Chat", 0, 2);
      qJh = new c("Chatroom", 1, 3);
      qJi = new c("Sns", 2, 4);
      qJj = new c[] { qJg, qJh, qJi };
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
      qJk = new d("Samll", 0, 1);
      qJl = new d("Full", 1, 2);
      qJm = new d("Complete", 2, 3);
      qJn = new d[] { qJk, qJl, qJm };
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