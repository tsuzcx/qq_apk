package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class m
{
  public static void a(a parama, g paramg)
  {
    AppMethodBeat.i(103438);
    if ((paramg.field_favProto.ppH == null) || (paramg.field_favProto.ppH.isEmpty()))
    {
      AppMethodBeat.o(103438);
      return;
    }
    Object localObject = ((aml)paramg.field_favProto.ppH.getFirst()).Lwn;
    if (localObject == null)
    {
      AppMethodBeat.o(103438);
      return;
    }
    com.tencent.mm.modelsns.m localm = new com.tencent.mm.modelsns.m();
    localm.n("20source_publishid", ((amo)localObject).izg + ",");
    localm.n("21uxinfo", ((amo)localObject).izf + ",");
    localm.n("22clienttime", Util.nowMilliSecond() + ",");
    localm.n("23video_statu", ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localm.n("24source_type", i + ",");
      localm.n("25scene", "5,");
      localm.n("26action_type", a.a(parama) + ",");
      localm.n("27scene_chatname", ",");
      localm.n("28scene_username", paramg.field_fromUser + ",");
      localm.n("29curr_publishid", ",");
      localm.n("30curr_msgid", "0,");
      localm.n("31curr_favid", paramg.field_id + ",");
      localm.n("32elapsed_time", "0,");
      localm.n("33load_time", "0,");
      localm.n("34is_load_complete", "0,");
      localm.n("35destination", "0,");
      localm.n("36chatroom_membercount", "0,");
      Log.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + localm.abW());
      ((d)com.tencent.mm.kernel.g.af(d.class)).a(12990, new Object[] { localm });
      AppMethodBeat.o(103438);
      return;
    }
  }
  
  public static void a(c paramc, g paramg, d paramd, int paramInt)
  {
    AppMethodBeat.i(103439);
    if ((paramg.field_favProto.ppH == null) || (paramg.field_favProto.ppH.isEmpty()))
    {
      AppMethodBeat.o(103439);
      return;
    }
    amo localamo = ((aml)paramg.field_favProto.ppH.getFirst()).Lwn;
    if (localamo == null)
    {
      AppMethodBeat.o(103439);
      return;
    }
    com.tencent.mm.modelsns.m localm = new com.tencent.mm.modelsns.m();
    localm.n("20source_publishid", localamo.izg + ",");
    localm.n("21uxinfo", localamo.izf + ",");
    localm.n("22clienttime", Util.nowMilliSecond() + ",");
    localm.n("23video_statu", d.a(paramd) + ",");
    paramd = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localm.n("24source_type", i + ",");
      localm.n("25scene", "5,");
      localm.n("26action_type", c.a(paramc) + ",");
      localm.n("27scene_chatname", ",");
      localm.n("28scene_username", paramg.field_fromUser + ",");
      localm.n("29curr_publishid", ",");
      localm.n("30curr_msgid", "0,");
      localm.n("31curr_favid", paramg.field_id + ",");
      localm.n("32chatroom_membercount", "0,");
      localm.n("33chatroom_toMemberCount", paramInt + ",");
      Log.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + localm.abW());
      h.CyF.a(12991, new Object[] { localm });
      AppMethodBeat.o(103439);
      return;
    }
  }
  
  public static void x(g paramg)
  {
    AppMethodBeat.i(103437);
    if ((paramg.field_favProto.ppH == null) || (paramg.field_favProto.ppH.isEmpty()))
    {
      AppMethodBeat.o(103437);
      return;
    }
    aml localaml = (aml)paramg.field_favProto.ppH.getFirst();
    Object localObject = localaml.Lwn;
    if (localObject == null)
    {
      AppMethodBeat.o(103437);
      return;
    }
    com.tencent.mm.modelsns.m localm = new com.tencent.mm.modelsns.m();
    localm.n("20source_publishid", ((amo)localObject).izg + ",");
    localm.n("21uxinfo", ((amo)localObject).izf + ",");
    localm.n("22clienttime", Util.nowMilliSecond() + ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localm.n("23source_type", i + ",");
      localm.n("24scene", "5,");
      localm.n("25scene_chatname", ",");
      localm.n("26scene_username", paramg.field_fromUser + ",");
      localm.n("27curr_publishid", ",");
      localm.n("28curr_msgid", "0,");
      localm.n("29curr_favid", paramg.field_id + ",");
      localm.n("30isdownload", "0,");
      localm.n("31chatroom_membercount", "0,");
      ((j)com.tencent.mm.kernel.g.af(j.class)).b(localaml.ean, localm);
      Log.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + localm.abW());
      h.CyF.a(12989, new Object[] { localm });
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
      taL = new a("PlayIcon", 0, 1);
      taM = new a("EnterFullScreen", 1, 2);
      taN = new a("EnterCompleteVideo", 2, 3);
      taO = new a("DetailInVideo", 3, 4);
      taP = new a("LeavelFullScreen", 4, 5);
      taQ = new a("LeaveCompleteVideo", 5, 6);
      taR = new a("SightLoaded", 6, 7);
      taS = new a[] { taL, taM, taN, taO, taP, taQ, taR };
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
      taT = new b("Sight", 0, 1);
      taU = new b("AdUrl", 1, 2);
      taV = new b("Chat", 2, 3);
      taW = new b("TalkChat", 3, 4);
      taX = new b("Fav", 4, 5);
      taY = new b[] { taT, taU, taV, taW, taX };
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
      taZ = new c("Chat", 0, 2);
      tba = new c("Chatroom", 1, 3);
      tbb = new c("Sns", 2, 4);
      tbc = new c[] { taZ, tba, tbb };
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
      tbd = new d("Samll", 0, 1);
      tbe = new d("Full", 1, 2);
      tbf = new d("Complete", 2, 3);
      tbg = new d[] { tbd, tbe, tbf };
      AppMethodBeat.o(103436);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.m
 * JD-Core Version:    0.7.0.1
 */