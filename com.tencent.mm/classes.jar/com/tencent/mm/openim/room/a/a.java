package com.tencent.mm.openim.room.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;

public final class a
{
  public static boolean G(am paramam)
  {
    AppMethodBeat.i(151316);
    if (paramam == null)
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (!am.aSQ(paramam.field_username))
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (bt.isNullOrNil(paramam.field_openImAppid))
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if ("3552365301".equals(paramam.field_openImAppid))
    {
      AppMethodBeat.o(151316);
      return true;
    }
    AppMethodBeat.o(151316);
    return false;
  }
  
  public static String H(am paramam)
  {
    AppMethodBeat.i(151318);
    if (paramam == null)
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (!am.aSQ(paramam.field_username))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (bt.isNullOrNil(paramam.field_openImAppid))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paramam = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bC(paramam.field_openImAppid, paramam.field_descWordingId);
    if (bt.isNullOrNil(paramam))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paramam = "＠".concat(String.valueOf(paramam));
    AppMethodBeat.o(151318);
    return paramam;
  }
  
  public static CharSequence a(am paramam, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151317);
    paramam = H(paramam);
    if (paramam == null)
    {
      AppMethodBeat.o(151317);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    int i = paramCharSequence.length();
    paramCharSequence.append(paramam);
    int j = paramCharSequence.length();
    paramCharSequence.setSpan(new ForegroundColorSpan(aj.getContext().getResources().getColor(2131100723)), i, j, 33);
    AppMethodBeat.o(151317);
    return paramCharSequence;
  }
  
  private static void a(cep paramcep)
  {
    AppMethodBeat.i(151313);
    String str = paramcep.iHB;
    com.tencent.mm.k.a.a.a locala = new com.tencent.mm.k.a.a.a();
    locala.maxCount = paramcep.GYB.GYM;
    locala.fVi = paramcep.GAX;
    if (paramcep.GAX != 0) {
      locala.dAm = paramcep.GAX;
    }
    mn localmn = new mn();
    localmn.dAl.chatroomName = str;
    localmn.dAl.dAm = locala.dAm;
    vv localvv = new vv();
    int i;
    if (paramcep.GAY == null)
    {
      i = 0;
      localvv.fLb = i;
      localvv.FVm = z.IX(paramcep.iHB);
      localvv.FVl = paramcep.GAY.GYP;
      if (paramcep.GAY != null) {
        break label207;
      }
    }
    label207:
    for (LinkedList localLinkedList = new LinkedList();; localLinkedList = b.c.aF(paramcep.GAY.Fvu))
    {
      localvv.FVk = localLinkedList;
      ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).a(str, paramcep.GYB.buG, localvv, u.aAm(), locala, localmn);
      AppMethodBeat.o(151313);
      return;
      i = paramcep.GAY.Fvu.size();
      break;
    }
  }
  
  public static void a(cep paramcep, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195298);
    if (!paramcep.iHB.toLowerCase().endsWith("@im.chatroom"))
    {
      ad.e("OpenIMChatRoomContactLogic", "updateChatroom: bad room:[" + paramcep.iHB + "]");
      AppMethodBeat.o(195298);
      return;
    }
    a(paramcep);
    ab localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(paramcep.iHB);
    Object localObject = localab;
    if (localab == null)
    {
      localObject = new ab();
      ((ab)localObject).field_chatroomname = paramcep.iHB;
    }
    if (paramInt1 != -1) {
      ((ab)localObject).field_oldChatroomVersion = paramInt1;
    }
    if (paramInt2 != -1) {
      ((ab)localObject).field_chatroomVersion = paramInt2;
    }
    ((ab)localObject).fpL().type = paramcep.GYB.GYN;
    ((ab)localObject).c(((ab)localObject).fpL());
    a(paramcep.iHB, (ab)localObject, paramcep.GYB);
    g.ajD();
    localObject = ((l)g.ab(l.class)).azp().Bf(paramcep.iHB);
    int i = ((aw)localObject).field_type;
    ((am)localObject).tc(paramcep.app_id);
    if (paramcep.GYB != null)
    {
      paramInt1 = 1;
      if (bt.isNullOrNil(paramcep.GYB.dzZ)) {
        break label484;
      }
      paramInt2 = 1;
      label239:
      if ((paramInt1 & paramInt2) != 0) {
        ((am)localObject).sT(paramcep.GYB.dzZ);
      }
      ((am)localObject).setUsername(paramcep.iHB);
      ((am)localObject).kh(paramcep.Gmy);
      ((am)localObject).setType(paramcep.GYE & paramcep.vKb);
      ((am)localObject).kh(paramcep.Gmy);
      ((am)localObject).ki(paramcep.GYD);
      ((am)localObject).qs(paramcep.GYB.GYO);
      ad.i("OpenIMChatRoomContactLogic", "updateChatroom done %s, chatroom_business_type:%s ", new Object[] { ((aw)localObject).field_username, Long.valueOf(paramcep.GYB.GYO) });
      g.ajD();
      ((l)g.ab(l.class)).azp().af((am)localObject);
      if ((((aw)localObject).field_type & 0x800) == 0) {
        break label489;
      }
      if ((localObject == null) || ((i & 0x800) != (((aw)localObject).field_type & 0x800))) {
        ((l)g.ab(l.class)).azv().aTF(((aw)localObject).field_username);
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramcep.app_id)) {
        ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).s(paramcep.app_id, ac.iM(aj.getContext()), "");
      }
      AppMethodBeat.o(195298);
      return;
      paramInt1 = 0;
      break;
      label484:
      paramInt2 = 0;
      break label239;
      label489:
      if ((localObject == null) || ((i & 0x800) != (((aw)localObject).field_type & 0x800))) {
        ((l)g.ab(l.class)).azv().aTG(((aw)localObject).field_username);
      }
    }
  }
  
  private static void a(String paramString, ab paramab, ceq paramceq)
  {
    AppMethodBeat.i(151315);
    j localj = p.aEx();
    i locali1;
    if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(paramceq.GYG)))
    {
      i locali2 = localj.Dj(paramString);
      locali1 = locali2;
      if (locali2 == null)
      {
        locali1 = new i();
        locali1.username = paramString;
      }
      locali1.hMX = paramceq.GYF;
      locali1.hMW = paramceq.GYG;
      locali1.ePj = 3;
      if (bt.isNullOrNil(paramceq.GYF)) {
        break label229;
      }
    }
    label229:
    for (boolean bool = true;; bool = false)
    {
      locali1.eB(bool);
      localj.b(locali1);
      if ((paramceq.GYH == 2) && (!u.aAm().equals(paramString)))
      {
        p.aEk();
        com.tencent.mm.ak.e.L(paramString, false);
        p.aEk();
        com.tencent.mm.ak.e.L(paramString, true);
        p.aEz().CU(paramString);
      }
      paramab.field_roomowner = paramceq.buG;
      if (paramab.field_chatroomnoticePublishTime <= paramceq.GYL)
      {
        paramab.field_chatroomnotice = paramceq.oBR;
        paramab.field_chatroomnoticeEditor = paramceq.GYK;
        paramab.field_chatroomnoticePublishTime = paramceq.GYL;
      }
      ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().replace(paramab);
      AppMethodBeat.o(151315);
      return;
    }
  }
  
  public static boolean aPB()
  {
    AppMethodBeat.i(184257);
    if (com.tencent.mm.plugin.appbrand.z.b.getPackageInfo(aj.getContext(), "com.tencent.wework") != null)
    {
      AppMethodBeat.o(184257);
      return true;
    }
    AppMethodBeat.o(184257);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.a
 * JD-Core Version:    0.7.0.1
 */