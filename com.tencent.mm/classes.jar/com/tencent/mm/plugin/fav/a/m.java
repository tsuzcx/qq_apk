package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.plugin.sns.c.j;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class m
{
  public static void a(a parama, g paramg)
  {
    AppMethodBeat.i(103438);
    if ((paramg.field_favProto.mVb == null) || (paramg.field_favProto.mVb.isEmpty()))
    {
      AppMethodBeat.o(103438);
      return;
    }
    Object localObject = ((afy)paramg.field_favProto.mVb.getFirst()).DgZ;
    if (localObject == null)
    {
      AppMethodBeat.o(103438);
      return;
    }
    f localf = new f();
    localf.o("20source_publishid", ((agb)localObject).gJC + ",");
    localf.o("21uxinfo", ((agb)localObject).gJB + ",");
    localf.o("22clienttime", bt.eGO() + ",");
    localf.o("23video_statu", ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localf.o("24source_type", i + ",");
      localf.o("25scene", "5,");
      localf.o("26action_type", a.a(parama) + ",");
      localf.o("27scene_chatname", ",");
      localf.o("28scene_username", paramg.field_fromUser + ",");
      localf.o("29curr_publishid", ",");
      localf.o("30curr_msgid", "0,");
      localf.o("31curr_favid", paramg.field_id + ",");
      localf.o("32elapsed_time", "0,");
      localf.o("33load_time", "0,");
      localf.o("34is_load_complete", "0,");
      localf.o("35destination", "0,");
      localf.o("36chatroom_membercount", "0,");
      ad.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + localf.PW());
      ((d)com.tencent.mm.kernel.g.ab(d.class)).f(12990, new Object[] { localf });
      AppMethodBeat.o(103438);
      return;
    }
  }
  
  public static void a(c paramc, g paramg, m.d paramd, int paramInt)
  {
    AppMethodBeat.i(103439);
    if ((paramg.field_favProto.mVb == null) || (paramg.field_favProto.mVb.isEmpty()))
    {
      AppMethodBeat.o(103439);
      return;
    }
    agb localagb = ((afy)paramg.field_favProto.mVb.getFirst()).DgZ;
    if (localagb == null)
    {
      AppMethodBeat.o(103439);
      return;
    }
    f localf = new f();
    localf.o("20source_publishid", localagb.gJC + ",");
    localf.o("21uxinfo", localagb.gJB + ",");
    localf.o("22clienttime", bt.eGO() + ",");
    localf.o("23video_statu", m.d.a(paramd) + ",");
    paramd = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localf.o("24source_type", i + ",");
      localf.o("25scene", "5,");
      localf.o("26action_type", c.a(paramc) + ",");
      localf.o("27scene_chatname", ",");
      localf.o("28scene_username", paramg.field_fromUser + ",");
      localf.o("29curr_publishid", ",");
      localf.o("30curr_msgid", "0,");
      localf.o("31curr_favid", paramg.field_id + ",");
      localf.o("32chatroom_membercount", "0,");
      localf.o("33chatroom_toMemberCount", paramInt + ",");
      ad.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + localf.PW());
      h.vKh.f(12991, new Object[] { localf });
      AppMethodBeat.o(103439);
      return;
    }
  }
  
  public static void x(g paramg)
  {
    AppMethodBeat.i(103437);
    if ((paramg.field_favProto.mVb == null) || (paramg.field_favProto.mVb.isEmpty()))
    {
      AppMethodBeat.o(103437);
      return;
    }
    afy localafy = (afy)paramg.field_favProto.mVb.getFirst();
    Object localObject = localafy.DgZ;
    if (localObject == null)
    {
      AppMethodBeat.o(103437);
      return;
    }
    f localf = new f();
    localf.o("20source_publishid", ((agb)localObject).gJC + ",");
    localf.o("21uxinfo", ((agb)localObject).gJB + ",");
    localf.o("22clienttime", bt.eGO() + ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localf.o("23source_type", i + ",");
      localf.o("24scene", "5,");
      localf.o("25scene_chatname", ",");
      localf.o("26scene_username", paramg.field_fromUser + ",");
      localf.o("27curr_publishid", ",");
      localf.o("28curr_msgid", "0,");
      localf.o("29curr_favid", paramg.field_id + ",");
      localf.o("30isdownload", "0,");
      localf.o("31chatroom_membercount", "0,");
      ((j)com.tencent.mm.kernel.g.ab(j.class)).b(localafy.dxG, localf);
      ad.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + localf.PW());
      h.vKh.f(12989, new Object[] { localf });
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
      qam = new a("PlayIcon", 0, 1);
      qan = new a("EnterFullScreen", 1, 2);
      qao = new a("EnterCompleteVideo", 2, 3);
      qap = new a("DetailInVideo", 3, 4);
      qaq = new a("LeavelFullScreen", 4, 5);
      qar = new a("LeaveCompleteVideo", 5, 6);
      qas = new a("SightLoaded", 6, 7);
      qat = new a[] { qam, qan, qao, qap, qaq, qar, qas };
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
      qau = new b("Sight", 0, 1);
      qav = new b("AdUrl", 1, 2);
      qaw = new b("Chat", 2, 3);
      qax = new b("TalkChat", 3, 4);
      qay = new b("Fav", 4, 5);
      qaz = new b[] { qau, qav, qaw, qax, qay };
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
      qaA = new c("Chat", 0, 2);
      qaB = new c("Chatroom", 1, 3);
      qaC = new c("Sns", 2, 4);
      qaD = new c[] { qaA, qaB, qaC };
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