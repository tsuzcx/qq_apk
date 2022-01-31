package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class m
{
  public static void a(m.a parama, g paramg)
  {
    if ((paramg.field_favProto.sXc == null) || (paramg.field_favProto.sXc.isEmpty())) {}
    do
    {
      return;
      localObject = ((xv)paramg.field_favProto.sXc.getFirst()).sVG;
    } while (localObject == null);
    d locald = new d();
    locald.j("20source_publishid", ((xy)localObject).dSW + ",");
    locald.j("21uxinfo", ((xy)localObject).dSV + ",");
    locald.j("22clienttime", bk.UY() + ",");
    locald.j("23video_statu", ",");
    Object localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      locald.j("24source_type", i + ",");
      locald.j("25scene", "5,");
      locald.j("26action_type", m.a.a(parama) + ",");
      locald.j("27scene_chatname", ",");
      locald.j("28scene_username", paramg.field_fromUser + ",");
      locald.j("29curr_publishid", ",");
      locald.j("30curr_msgid", "0,");
      locald.j("31curr_favid", paramg.field_id + ",");
      locald.j("32elapsed_time", "0,");
      locald.j("33load_time", "0,");
      locald.j("34is_load_complete", "0,");
      locald.j("35destination", "0,");
      locald.j("36chatroom_membercount", "0,");
      y.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + locald.uJ());
      ((c)com.tencent.mm.kernel.g.r(c.class)).f(12990, new Object[] { locald });
      return;
    }
  }
  
  public static void a(m.c paramc, g paramg, m.d paramd, int paramInt)
  {
    if ((paramg.field_favProto.sXc == null) || (paramg.field_favProto.sXc.isEmpty())) {}
    xy localxy;
    do
    {
      return;
      localxy = ((xv)paramg.field_favProto.sXc.getFirst()).sVG;
    } while (localxy == null);
    d locald = new d();
    locald.j("20source_publishid", localxy.dSW + ",");
    locald.j("21uxinfo", localxy.dSV + ",");
    locald.j("22clienttime", bk.UY() + ",");
    locald.j("23video_statu", m.d.a(paramd) + ",");
    paramd = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      locald.j("24source_type", i + ",");
      locald.j("25scene", "5,");
      locald.j("26action_type", m.c.a(paramc) + ",");
      locald.j("27scene_chatname", ",");
      locald.j("28scene_username", paramg.field_fromUser + ",");
      locald.j("29curr_publishid", ",");
      locald.j("30curr_msgid", "0,");
      locald.j("31curr_favid", paramg.field_id + ",");
      locald.j("32chatroom_membercount", "0,");
      locald.j("33chatroom_toMemberCount", paramInt + ",");
      y.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + locald.uJ());
      h.nFQ.f(12991, new Object[] { locald });
      return;
    }
  }
  
  public static void w(g paramg)
  {
    if ((paramg.field_favProto.sXc == null) || (paramg.field_favProto.sXc.isEmpty())) {}
    xv localxv;
    do
    {
      return;
      localxv = (xv)paramg.field_favProto.sXc.getFirst();
      localObject = localxv.sVG;
    } while (localObject == null);
    d locald = new d();
    locald.j("20source_publishid", ((xy)localObject).dSW + ",");
    locald.j("21uxinfo", ((xy)localObject).dSV + ",");
    locald.j("22clienttime", bk.UY() + ",");
    Object localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      locald.j("23source_type", i + ",");
      locald.j("24scene", "5,");
      locald.j("25scene_chatname", ",");
      locald.j("26scene_username", paramg.field_fromUser + ",");
      locald.j("27curr_publishid", ",");
      locald.j("28curr_msgid", "0,");
      locald.j("29curr_favid", paramg.field_id + ",");
      locald.j("30isdownload", "0,");
      locald.j("31chatroom_membercount", "0,");
      ((i)com.tencent.mm.kernel.g.r(i.class)).b(localxv.bYN, locald);
      y.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + locald.uJ());
      h.nFQ.f(12989, new Object[] { locald });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.m
 * JD-Core Version:    0.7.0.1
 */