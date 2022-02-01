package com.tencent.mm.openim.room.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.protocal.protobuf.cvr;
import com.tencent.mm.protocal.protobuf.cvs;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;

public final class a
{
  public static boolean N(as paramas)
  {
    AppMethodBeat.i(151316);
    if (paramas == null)
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (!as.bjp(paramas.field_username))
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
  
  public static String O(as paramas)
  {
    AppMethodBeat.i(151318);
    if (paramas == null)
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (!as.bjp(paramas.field_username))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (Util.isNullOrNil(paramas.field_openImAppid))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paramas = ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).bN(paramas.field_openImAppid, paramas.field_descWordingId);
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
    paramas = O(paramas);
    if (paramas == null)
    {
      AppMethodBeat.o(151317);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    int i = paramCharSequence.length();
    paramCharSequence.append(paramas);
    int j = paramCharSequence.length();
    paramCharSequence.setSpan(new ForegroundColorSpan(MMApplicationContext.getContext().getResources().getColor(2131100917)), i, j, 33);
    AppMethodBeat.o(151317);
    return paramCharSequence;
  }
  
  private static void a(cvq paramcvq)
  {
    AppMethodBeat.i(151313);
    String str = paramcvq.jHa;
    com.tencent.mm.k.a.a.a locala = new com.tencent.mm.k.a.a.a();
    locala.maxCount = paramcvq.MBa.MBl;
    locala.gCu = paramcvq.LYP;
    if (paramcvq.LYP != 0) {
      locala.dTg = paramcvq.LYP;
    }
    nf localnf = new nf();
    localnf.dTf.chatroomName = str;
    localnf.dTf.dTg = locala.dTg;
    xg localxg = new xg();
    int i;
    if (paramcvq.LYQ == null)
    {
      i = 0;
      localxg.gsq = i;
      localxg.Lip = com.tencent.mm.platformtools.z.Su(paramcvq.jHa);
      localxg.Lio = paramcvq.LYQ.MBn;
      if (paramcvq.LYQ != null) {
        break label207;
      }
    }
    label207:
    for (LinkedList localLinkedList = new LinkedList();; localLinkedList = b.c.aN(paramcvq.LYQ.KHx))
    {
      localxg.Lin = localLinkedList;
      ((com.tencent.mm.plugin.chatroom.a.b)g.af(com.tencent.mm.plugin.chatroom.a.b.class)).a(str, paramcvq.MBa.buA, localxg, com.tencent.mm.model.z.aTY(), locala, localnf);
      AppMethodBeat.o(151313);
      return;
      i = paramcvq.LYQ.KHx.size();
      break;
    }
  }
  
  public static void a(cvq paramcvq, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223651);
    if (!paramcvq.jHa.toLowerCase().endsWith("@im.chatroom"))
    {
      Log.e("OpenIMChatRoomContactLogic", "updateChatroom: bad room:[" + paramcvq.jHa + "]");
      AppMethodBeat.o(223651);
      return;
    }
    a(paramcvq);
    ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramcvq.jHa);
    Object localObject = localah;
    if (localah == null)
    {
      localObject = new ah();
      ((ah)localObject).field_chatroomname = paramcvq.jHa;
    }
    if (paramInt1 != -1) {
      ((ah)localObject).field_oldChatroomVersion = paramInt1;
    }
    if (paramInt2 != -1) {
      ((ah)localObject).field_chatroomVersion = paramInt2;
    }
    ((ah)localObject).gBr().type = paramcvq.MBa.LGU;
    ((ah)localObject).c(((ah)localObject).gBr());
    a(paramcvq.jHa, (ah)localObject, paramcvq.MBa);
    g.aAi();
    localObject = ((l)g.af(l.class)).aSN().Kn(paramcvq.jHa);
    int i = ((ax)localObject).field_type;
    ((as)localObject).BN(paramcvq.app_id);
    if (paramcvq.MBa != null)
    {
      paramInt1 = 1;
      if (Util.isNullOrNil(paramcvq.MBa.dST)) {
        break label484;
      }
      paramInt2 = 1;
      label239:
      if ((paramInt1 & paramInt2) != 0) {
        ((as)localObject).setNickname(paramcvq.MBa.dST);
      }
      ((as)localObject).setUsername(paramcvq.jHa);
      ((as)localObject).nl(paramcvq.LDk);
      ((as)localObject).setType(paramcvq.MBd & paramcvq.zqk);
      ((as)localObject).nl(paramcvq.LDk);
      ((as)localObject).nm(paramcvq.MBc);
      ((as)localObject).yy(paramcvq.MBa.MBm);
      Log.i("OpenIMChatRoomContactLogic", "updateChatroom done %s, chatroom_business_type:%s ", new Object[] { ((ax)localObject).field_username, Long.valueOf(paramcvq.MBa.MBm) });
      g.aAi();
      ((l)g.af(l.class)).aSN().ao((as)localObject);
      if ((((ax)localObject).field_type & 0x800) == 0) {
        break label489;
      }
      if ((localObject == null) || ((i & 0x800) != (((ax)localObject).field_type & 0x800))) {
        ((l)g.af(l.class)).aST().bke(((ax)localObject).field_username);
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramcvq.app_id)) {
        ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).s(paramcvq.app_id, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), "");
      }
      AppMethodBeat.o(223651);
      return;
      paramInt1 = 0;
      break;
      label484:
      paramInt2 = 0;
      break label239;
      label489:
      if ((localObject == null) || ((i & 0x800) != (((ax)localObject).field_type & 0x800))) {
        ((l)g.af(l.class)).aST().bkf(((ax)localObject).field_username);
      }
    }
  }
  
  private static void a(String paramString, ah paramah, cvr paramcvr)
  {
    AppMethodBeat.i(151315);
    j localj = p.aYB();
    i locali1;
    if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(paramcvr.MBf)))
    {
      i locali2 = localj.Mx(paramString);
      locali1 = locali2;
      if (locali2 == null)
      {
        locali1 = new i();
        locali1.username = paramString;
      }
      locali1.iKX = paramcvr.MBe;
      locali1.iKW = paramcvr.MBf;
      locali1.fuz = 3;
      if (Util.isNullOrNil(paramcvr.MBe)) {
        break label229;
      }
    }
    label229:
    for (boolean bool = true;; bool = false)
    {
      locali1.fv(bool);
      localj.b(locali1);
      if ((paramcvr.MBg == 2) && (!com.tencent.mm.model.z.aTY().equals(paramString)))
      {
        p.aYn();
        com.tencent.mm.aj.e.N(paramString, false);
        p.aYn();
        com.tencent.mm.aj.e.N(paramString, true);
        p.aYD().Mg(paramString);
      }
      paramah.field_roomowner = paramcvr.buA;
      if (paramah.field_chatroomnoticePublishTime <= paramcvr.MBk)
      {
        paramah.field_chatroomnotice = paramcvr.pWh;
        paramah.field_chatroomnoticeEditor = paramcvr.MBj;
        paramah.field_chatroomnoticePublishTime = paramcvr.MBk;
      }
      ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().replace(paramah);
      AppMethodBeat.o(151315);
      return;
    }
  }
  
  public static boolean bkC()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.a
 * JD-Core Version:    0.7.0.1
 */