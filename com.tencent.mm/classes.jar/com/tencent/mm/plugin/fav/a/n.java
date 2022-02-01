package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.plugin.sns.c.l;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class n
{
  public static void a(a parama, g paramg)
  {
    AppMethodBeat.i(103438);
    if ((paramg.field_favProto.vEn == null) || (paramg.field_favProto.vEn.isEmpty()))
    {
      AppMethodBeat.o(103438);
      return;
    }
    Object localObject = ((arf)paramg.field_favProto.vEn.getFirst()).ZzE;
    if (localObject == null)
    {
      AppMethodBeat.o(103438);
      return;
    }
    com.tencent.mm.modelsns.n localn = new com.tencent.mm.modelsns.n();
    localn.s("20source_publishid", ((ari)localObject).nTB + ",");
    localn.s("21uxinfo", ((ari)localObject).nTA + ",");
    localn.s("22clienttime", Util.nowMilliSecond() + ",");
    localn.s("23video_statu", ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localn.s("24source_type", i + ",");
      localn.s("25scene", "5,");
      localn.s("26action_type", a.a(parama) + ",");
      localn.s("27scene_chatname", ",");
      localn.s("28scene_username", paramg.field_fromUser + ",");
      localn.s("29curr_publishid", ",");
      localn.s("30curr_msgid", "0,");
      localn.s("31curr_favid", paramg.field_id + ",");
      localn.s("32elapsed_time", "0,");
      localn.s("33load_time", "0,");
      localn.s("34is_load_complete", "0,");
      localn.s("35destination", "0,");
      localn.s("36chatroom_membercount", "0,");
      Log.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + localn.aIF());
      ((d)com.tencent.mm.kernel.h.ax(d.class)).b(12990, new Object[] { localn });
      AppMethodBeat.o(103438);
      return;
    }
  }
  
  public static void a(c paramc, g paramg, d paramd, int paramInt)
  {
    AppMethodBeat.i(103439);
    if ((paramg.field_favProto.vEn == null) || (paramg.field_favProto.vEn.isEmpty()))
    {
      AppMethodBeat.o(103439);
      return;
    }
    ari localari = ((arf)paramg.field_favProto.vEn.getFirst()).ZzE;
    if (localari == null)
    {
      AppMethodBeat.o(103439);
      return;
    }
    com.tencent.mm.modelsns.n localn = new com.tencent.mm.modelsns.n();
    localn.s("20source_publishid", localari.nTB + ",");
    localn.s("21uxinfo", localari.nTA + ",");
    localn.s("22clienttime", Util.nowMilliSecond() + ",");
    localn.s("23video_statu", d.a(paramd) + ",");
    paramd = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localn.s("24source_type", i + ",");
      localn.s("25scene", "5,");
      localn.s("26action_type", c.a(paramc) + ",");
      localn.s("27scene_chatname", ",");
      localn.s("28scene_username", paramg.field_fromUser + ",");
      localn.s("29curr_publishid", ",");
      localn.s("30curr_msgid", "0,");
      localn.s("31curr_favid", paramg.field_id + ",");
      localn.s("32chatroom_membercount", "0,");
      localn.s("33chatroom_toMemberCount", paramInt + ",");
      Log.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + localn.aIF());
      com.tencent.mm.plugin.report.service.h.OAn.b(12991, new Object[] { localn });
      AppMethodBeat.o(103439);
      return;
    }
  }
  
  public static void x(g paramg)
  {
    AppMethodBeat.i(103437);
    if ((paramg.field_favProto.vEn == null) || (paramg.field_favProto.vEn.isEmpty()))
    {
      AppMethodBeat.o(103437);
      return;
    }
    arf localarf = (arf)paramg.field_favProto.vEn.getFirst();
    Object localObject = localarf.ZzE;
    if (localObject == null)
    {
      AppMethodBeat.o(103437);
      return;
    }
    com.tencent.mm.modelsns.n localn = new com.tencent.mm.modelsns.n();
    localn.s("20source_publishid", ((ari)localObject).nTB + ",");
    localn.s("21uxinfo", ((ari)localObject).nTA + ",");
    localn.s("22clienttime", Util.nowMilliSecond() + ",");
    localObject = new StringBuilder();
    if (paramg.field_type == 16) {}
    for (int i = 1;; i = 2)
    {
      localn.s("23source_type", i + ",");
      localn.s("24scene", "5,");
      localn.s("25scene_chatname", ",");
      localn.s("26scene_username", paramg.field_fromUser + ",");
      localn.s("27curr_publishid", ",");
      localn.s("28curr_msgid", "0,");
      localn.s("29curr_favid", paramg.field_id + ",");
      localn.s("30isdownload", "0,");
      localn.s("31chatroom_membercount", "0,");
      ((l)com.tencent.mm.kernel.h.ax(l.class)).b(localarf.iah, localn);
      Log.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + localn.aIF());
      com.tencent.mm.plugin.report.service.h.OAn.b(12989, new Object[] { localn });
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
      AcZ = new a("PlayIcon", 0, 1);
      Ada = new a("EnterFullScreen", 1, 2);
      Adb = new a("EnterCompleteVideo", 2, 3);
      Adc = new a("DetailInVideo", 3, 4);
      Add = new a("LeavelFullScreen", 4, 5);
      Ade = new a("LeaveCompleteVideo", 5, 6);
      Adf = new a("SightLoaded", 6, 7);
      Adg = new a[] { AcZ, Ada, Adb, Adc, Add, Ade, Adf };
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
      Adh = new b("Sight", 0, 1);
      Adi = new b("AdUrl", 1, 2);
      Adj = new b("Chat", 2, 3);
      Adk = new b("TalkChat", 3, 4);
      Adl = new b("Fav", 4, 5);
      Adm = new b[] { Adh, Adi, Adj, Adk, Adl };
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
      Adn = new c("Chat", 0, 2);
      Ado = new c("Chatroom", 1, 3);
      Adp = new c("Sns", 2, 4);
      Adq = new c[] { Adn, Ado, Adp };
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
      Adr = new d("Samll", 0, 1);
      Ads = new d("Full", 1, 2);
      Adt = new d("Complete", 2, 3);
      Adu = new d[] { Adr, Ads, Adt };
      AppMethodBeat.o(103436);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.n
 * JD-Core Version:    0.7.0.1
 */