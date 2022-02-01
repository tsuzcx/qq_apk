package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class n
{
  public static void a(a parama, g paramg)
  {
    AppMethodBeat.i(103438);
    if ((paramg.field_favProto.syG == null) || (paramg.field_favProto.syG.isEmpty()))
    {
      AppMethodBeat.o(103438);
      return;
    }
    Object localObject = ((anm)paramg.field_favProto.syG.getFirst()).SyM;
    if (localObject == null)
    {
      AppMethodBeat.o(103438);
      return;
    }
    com.tencent.mm.modelsns.n localn = new com.tencent.mm.modelsns.n();
    localn.m("20source_publishid", ((anp)localObject).loy + ",");
    localn.m("21uxinfo", ((anp)localObject).lox + ",");
    localn.m("22clienttime", Util.nowMilliSecond() + ",");
    localn.m("23video_statu", ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localn.m("24source_type", i + ",");
      localn.m("25scene", "5,");
      localn.m("26action_type", a.a(parama) + ",");
      localn.m("27scene_chatname", ",");
      localn.m("28scene_username", paramg.field_fromUser + ",");
      localn.m("29curr_publishid", ",");
      localn.m("30curr_msgid", "0,");
      localn.m("31curr_favid", paramg.field_id + ",");
      localn.m("32elapsed_time", "0,");
      localn.m("33load_time", "0,");
      localn.m("34is_load_complete", "0,");
      localn.m("35destination", "0,");
      localn.m("36chatroom_membercount", "0,");
      Log.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + localn.agI());
      ((d)com.tencent.mm.kernel.h.ae(d.class)).a(12990, new Object[] { localn });
      AppMethodBeat.o(103438);
      return;
    }
  }
  
  public static void a(c paramc, g paramg, d paramd, int paramInt)
  {
    AppMethodBeat.i(103439);
    if ((paramg.field_favProto.syG == null) || (paramg.field_favProto.syG.isEmpty()))
    {
      AppMethodBeat.o(103439);
      return;
    }
    anp localanp = ((anm)paramg.field_favProto.syG.getFirst()).SyM;
    if (localanp == null)
    {
      AppMethodBeat.o(103439);
      return;
    }
    com.tencent.mm.modelsns.n localn = new com.tencent.mm.modelsns.n();
    localn.m("20source_publishid", localanp.loy + ",");
    localn.m("21uxinfo", localanp.lox + ",");
    localn.m("22clienttime", Util.nowMilliSecond() + ",");
    localn.m("23video_statu", d.a(paramd) + ",");
    paramd = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localn.m("24source_type", i + ",");
      localn.m("25scene", "5,");
      localn.m("26action_type", c.a(paramc) + ",");
      localn.m("27scene_chatname", ",");
      localn.m("28scene_username", paramg.field_fromUser + ",");
      localn.m("29curr_publishid", ",");
      localn.m("30curr_msgid", "0,");
      localn.m("31curr_favid", paramg.field_id + ",");
      localn.m("32chatroom_membercount", "0,");
      localn.m("33chatroom_toMemberCount", paramInt + ",");
      Log.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + localn.agI());
      com.tencent.mm.plugin.report.service.h.IzE.a(12991, new Object[] { localn });
      AppMethodBeat.o(103439);
      return;
    }
  }
  
  public static void x(g paramg)
  {
    AppMethodBeat.i(103437);
    if ((paramg.field_favProto.syG == null) || (paramg.field_favProto.syG.isEmpty()))
    {
      AppMethodBeat.o(103437);
      return;
    }
    anm localanm = (anm)paramg.field_favProto.syG.getFirst();
    Object localObject = localanm.SyM;
    if (localObject == null)
    {
      AppMethodBeat.o(103437);
      return;
    }
    com.tencent.mm.modelsns.n localn = new com.tencent.mm.modelsns.n();
    localn.m("20source_publishid", ((anp)localObject).loy + ",");
    localn.m("21uxinfo", ((anp)localObject).lox + ",");
    localn.m("22clienttime", Util.nowMilliSecond() + ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localn.m("23source_type", i + ",");
      localn.m("24scene", "5,");
      localn.m("25scene_chatname", ",");
      localn.m("26scene_username", paramg.field_fromUser + ",");
      localn.m("27curr_publishid", ",");
      localn.m("28curr_msgid", "0,");
      localn.m("29curr_favid", paramg.field_id + ",");
      localn.m("30isdownload", "0,");
      localn.m("31chatroom_membercount", "0,");
      ((k)com.tencent.mm.kernel.h.ae(k.class)).b(localanm.fUk, localn);
      Log.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + localn.agI());
      com.tencent.mm.plugin.report.service.h.IzE.a(12989, new Object[] { localn });
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
      wGQ = new a("PlayIcon", 0, 1);
      wGR = new a("EnterFullScreen", 1, 2);
      wGS = new a("EnterCompleteVideo", 2, 3);
      wGT = new a("DetailInVideo", 3, 4);
      wGU = new a("LeavelFullScreen", 4, 5);
      wGV = new a("LeaveCompleteVideo", 5, 6);
      wGW = new a("SightLoaded", 6, 7);
      wGX = new a[] { wGQ, wGR, wGS, wGT, wGU, wGV, wGW };
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
      wGY = new b("Sight", 0, 1);
      wGZ = new b("AdUrl", 1, 2);
      wHa = new b("Chat", 2, 3);
      wHb = new b("TalkChat", 3, 4);
      wHc = new b("Fav", 4, 5);
      wHd = new b[] { wGY, wGZ, wHa, wHb, wHc };
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
      wHe = new c("Chat", 0, 2);
      wHf = new c("Chatroom", 1, 3);
      wHg = new c("Sns", 2, 4);
      wHh = new c[] { wHe, wHf, wHg };
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
      wHi = new d("Samll", 0, 1);
      wHj = new d("Full", 1, 2);
      wHk = new d("Complete", 2, 3);
      wHl = new d[] { wHi, wHj, wHk };
      AppMethodBeat.o(103436);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.n
 * JD-Core Version:    0.7.0.1
 */