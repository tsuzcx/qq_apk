package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class m
{
  public static void a(m.a parama, g paramg)
  {
    AppMethodBeat.i(102698);
    if ((paramg.field_favProto.wVc == null) || (paramg.field_favProto.wVc.isEmpty()))
    {
      AppMethodBeat.o(102698);
      return;
    }
    Object localObject = ((aca)paramg.field_favProto.wVc.getFirst()).wTC;
    if (localObject == null)
    {
      AppMethodBeat.o(102698);
      return;
    }
    d locald = new d();
    locald.k("20source_publishid", ((acd)localObject).fiV + ",");
    locald.k("21uxinfo", ((acd)localObject).fiU + ",");
    locald.k("22clienttime", bo.aoy() + ",");
    locald.k("23video_statu", ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      locald.k("24source_type", i + ",");
      locald.k("25scene", "5,");
      locald.k("26action_type", m.a.a(parama) + ",");
      locald.k("27scene_chatname", ",");
      locald.k("28scene_username", paramg.field_fromUser + ",");
      locald.k("29curr_publishid", ",");
      locald.k("30curr_msgid", "0,");
      locald.k("31curr_favid", paramg.field_id + ",");
      locald.k("32elapsed_time", "0,");
      locald.k("33load_time", "0,");
      locald.k("34is_load_complete", "0,");
      locald.k("35destination", "0,");
      locald.k("36chatroom_membercount", "0,");
      ab.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + locald.Fg());
      ((c)com.tencent.mm.kernel.g.E(c.class)).e(12990, new Object[] { locald });
      AppMethodBeat.o(102698);
      return;
    }
  }
  
  public static void a(m.c paramc, g paramg, m.d paramd, int paramInt)
  {
    AppMethodBeat.i(102699);
    if ((paramg.field_favProto.wVc == null) || (paramg.field_favProto.wVc.isEmpty()))
    {
      AppMethodBeat.o(102699);
      return;
    }
    acd localacd = ((aca)paramg.field_favProto.wVc.getFirst()).wTC;
    if (localacd == null)
    {
      AppMethodBeat.o(102699);
      return;
    }
    d locald = new d();
    locald.k("20source_publishid", localacd.fiV + ",");
    locald.k("21uxinfo", localacd.fiU + ",");
    locald.k("22clienttime", bo.aoy() + ",");
    locald.k("23video_statu", m.d.a(paramd) + ",");
    paramd = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      locald.k("24source_type", i + ",");
      locald.k("25scene", "5,");
      locald.k("26action_type", m.c.a(paramc) + ",");
      locald.k("27scene_chatname", ",");
      locald.k("28scene_username", paramg.field_fromUser + ",");
      locald.k("29curr_publishid", ",");
      locald.k("30curr_msgid", "0,");
      locald.k("31curr_favid", paramg.field_id + ",");
      locald.k("32chatroom_membercount", "0,");
      locald.k("33chatroom_toMemberCount", paramInt + ",");
      ab.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + locald.Fg());
      h.qsU.e(12991, new Object[] { locald });
      AppMethodBeat.o(102699);
      return;
    }
  }
  
  public static void w(g paramg)
  {
    AppMethodBeat.i(102697);
    if ((paramg.field_favProto.wVc == null) || (paramg.field_favProto.wVc.isEmpty()))
    {
      AppMethodBeat.o(102697);
      return;
    }
    aca localaca = (aca)paramg.field_favProto.wVc.getFirst();
    Object localObject = localaca.wTC;
    if (localObject == null)
    {
      AppMethodBeat.o(102697);
      return;
    }
    d locald = new d();
    locald.k("20source_publishid", ((acd)localObject).fiV + ",");
    locald.k("21uxinfo", ((acd)localObject).fiU + ",");
    locald.k("22clienttime", bo.aoy() + ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      locald.k("23source_type", i + ",");
      locald.k("24scene", "5,");
      locald.k("25scene_chatname", ",");
      locald.k("26scene_username", paramg.field_fromUser + ",");
      locald.k("27curr_publishid", ",");
      locald.k("28curr_msgid", "0,");
      locald.k("29curr_favid", paramg.field_id + ",");
      locald.k("30isdownload", "0,");
      locald.k("31chatroom_membercount", "0,");
      ((i)com.tencent.mm.kernel.g.E(i.class)).b(localaca.cGU, locald);
      ab.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + locald.Fg());
      h.qsU.e(12989, new Object[] { locald });
      AppMethodBeat.o(102697);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.m
 * JD-Core Version:    0.7.0.1
 */