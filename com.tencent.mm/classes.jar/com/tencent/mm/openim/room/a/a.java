package com.tencent.mm.openim.room.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.e;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.f.a.nx;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dfa;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.LinkedList;

public final class a
{
  public static boolean U(as paramas)
  {
    AppMethodBeat.i(151316);
    if (paramas == null)
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (!as.bvK(paramas.field_username))
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (Util.isNullOrNil(paramas.field_openImAppid))
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if ("3552365301".equals(paramas.field_openImAppid))
    {
      AppMethodBeat.o(151316);
      return true;
    }
    AppMethodBeat.o(151316);
    return false;
  }
  
  public static String V(as paramas)
  {
    AppMethodBeat.i(151318);
    if (paramas == null)
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (!as.bvK(paramas.field_username))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (Util.isNullOrNil(paramas.field_openImAppid))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paramas = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).bR(paramas.field_openImAppid, paramas.field_descWordingId);
    if (Util.isNullOrNil(paramas))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paramas = "＠".concat(String.valueOf(paramas));
    AppMethodBeat.o(151318);
    return paramas;
  }
  
  public static CharSequence a(as paramas, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151317);
    paramas = V(paramas);
    if (paramas == null)
    {
      AppMethodBeat.o(151317);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    int i = paramCharSequence.length();
    paramCharSequence.append(paramas);
    int j = paramCharSequence.length();
    paramCharSequence.setSpan(new ForegroundColorSpan(MMApplicationContext.getContext().getResources().getColor(c.b.open_im_display_name_color)), i, j, 33);
    AppMethodBeat.o(151317);
    return paramCharSequence;
  }
  
  private static void a(dfa paramdfa)
  {
    AppMethodBeat.i(151313);
    String str = paramdfa.mye;
    com.tencent.mm.k.a.a.a locala = new com.tencent.mm.k.a.a.a();
    locala.iWH = paramdfa.TMH.TMS;
    locala.jmA = paramdfa.Tij;
    if (paramdfa.Tij != 0) {
      locala.fMC = paramdfa.Tij;
    }
    nx localnx = new nx();
    localnx.fMB.chatroomName = str;
    localnx.fMB.fMC = locala.fMC;
    xm localxm = new xm();
    int i;
    if (paramdfa.Tik == null)
    {
      i = 0;
      localxm.iWB = i;
      localxm.SjG = com.tencent.mm.platformtools.z.ZW(paramdfa.mye);
      localxm.SjF = paramdfa.Tik.TMU;
      if (paramdfa.Tik != null) {
        break label207;
      }
    }
    label207:
    for (LinkedList localLinkedList = new LinkedList();; localLinkedList = b.c.aL(paramdfa.Tik.RIQ))
    {
      localxm.SjE = localLinkedList;
      ((com.tencent.mm.plugin.chatroom.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.a.class)).a(str, paramdfa.TMH.bec, localxm, com.tencent.mm.model.z.bcZ(), locala, localnx);
      AppMethodBeat.o(151313);
      return;
      i = paramdfa.Tik.RIQ.size();
      break;
    }
  }
  
  public static void a(dfa paramdfa, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195623);
    if (!paramdfa.mye.toLowerCase().endsWith("@im.chatroom"))
    {
      Log.e("OpenIMChatRoomContactLogic", "updateChatroom: bad room:[" + paramdfa.mye + "]");
      AppMethodBeat.o(195623);
      return;
    }
    a(paramdfa);
    ah localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramdfa.mye);
    Object localObject = localah;
    if (localah == null)
    {
      localObject = new ah();
      ((ah)localObject).field_chatroomname = paramdfa.mye;
    }
    if (paramInt1 != -1) {
      ((ah)localObject).field_oldChatroomVersion = paramInt1;
    }
    if (paramInt2 != -1) {
      ((ah)localObject).field_chatroomVersion = paramInt2;
    }
    ((ah)localObject).hxC().type = paramdfa.TMH.SLO;
    ((ah)localObject).c(((ah)localObject).hxC());
    a(paramdfa.mye, (ah)localObject, paramdfa.TMH);
    com.tencent.mm.kernel.h.aHH();
    localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramdfa.mye);
    int i = ((ax)localObject).field_type;
    ((as)localObject).IB(paramdfa.app_id);
    if (paramdfa.TMH != null)
    {
      paramInt1 = 1;
      if (Util.isNullOrNil(paramdfa.TMH.topic)) {
        break label485;
      }
      paramInt2 = 1;
      label240:
      if ((paramInt1 & paramInt2) != 0) {
        ((as)localObject).setNickname(paramdfa.TMH.topic);
      }
      ((as)localObject).setUsername(paramdfa.mye);
      ((as)localObject).pz(paramdfa.SGE);
      ((as)localObject).setType(paramdfa.TMK & paramdfa.EVJ);
      ((as)localObject).pz(paramdfa.SGE);
      ((as)localObject).pA(paramdfa.TMJ);
      ((as)localObject).Ez(paramdfa.TMH.TMT);
      Log.i("OpenIMChatRoomContactLogic", "updateChatroom done %s, chatroom_business_type:%s ", new Object[] { ((ax)localObject).field_username, Long.valueOf(paramdfa.TMH.TMT) });
      com.tencent.mm.kernel.h.aHH();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().au((as)localObject);
      if ((((ax)localObject).field_type & 0x800) == 0) {
        break label490;
      }
      if ((localObject == null) || ((i & 0x800) != (((ax)localObject).field_type & 0x800))) {
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwD(((ax)localObject).field_username);
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramdfa.app_id)) {
        ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).v(paramdfa.app_id, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), "");
      }
      AppMethodBeat.o(195623);
      return;
      paramInt1 = 0;
      break;
      label485:
      paramInt2 = 0;
      break label240;
      label490:
      if ((localObject == null) || ((i & 0x800) != (((ax)localObject).field_type & 0x800))) {
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwE(((ax)localObject).field_username);
      }
    }
  }
  
  private static void a(String paramString, ah paramah, dfb paramdfb)
  {
    AppMethodBeat.i(151315);
    k localk = q.bhP();
    j localj1;
    if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(paramdfb.TMM)))
    {
      j localj2 = localk.TS(paramString);
      localj1 = localj2;
      if (localj2 == null)
      {
        localj1 = new j();
        localj1.username = paramString;
      }
      localj1.lBe = paramdfb.TML;
      localj1.lBd = paramdfb.TMM;
      localj1.hDc = 3;
      if (Util.isNullOrNil(paramdfb.TML)) {
        break label244;
      }
    }
    label244:
    for (boolean bool = true;; bool = false)
    {
      localj1.gg(bool);
      localk.b(localj1);
      if ((paramdfb.TMN == 2) && (!com.tencent.mm.model.z.bcZ().equals(paramString)))
      {
        q.bhz();
        com.tencent.mm.am.f.P(paramString, false);
        q.bhz();
        com.tencent.mm.am.f.P(paramString, true);
        q.bhR().TB(paramString);
      }
      paramah.field_roomowner = paramdfb.bec;
      if (paramah.field_chatroomnoticePublishTime <= paramdfb.TMR)
      {
        if (Util.isNullOrNil(paramdfb.announcement)) {
          paramah.field_chatroomNoticeNew = 0;
        }
        paramah.field_chatroomnotice = paramdfb.announcement;
        paramah.field_chatroomnoticeEditor = paramdfb.TMQ;
        paramah.field_chatroomnoticePublishTime = paramdfb.TMR;
      }
      ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().replace(paramah);
      AppMethodBeat.o(151315);
      return;
    }
  }
  
  public static boolean buq()
  {
    AppMethodBeat.i(184257);
    if (com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(MMApplicationContext.getContext(), "com.tencent.wework") != null)
    {
      AppMethodBeat.o(184257);
      return true;
    }
    AppMethodBeat.o(184257);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.a
 * JD-Core Version:    0.7.0.1
 */