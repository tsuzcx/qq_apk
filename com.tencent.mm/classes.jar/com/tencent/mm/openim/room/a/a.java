package com.tencent.mm.openim.room.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bhy;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.u;
import java.util.LinkedList;

public final class a
{
  public static String A(ad paramad)
  {
    AppMethodBeat.i(78974);
    if (paramad == null)
    {
      AppMethodBeat.o(78974);
      return null;
    }
    if (!ad.arf(paramad.field_username))
    {
      AppMethodBeat.o(78974);
      return null;
    }
    if (bo.isNullOrNil(paramad.field_openImAppid))
    {
      AppMethodBeat.o(78974);
      return null;
    }
    paramad = ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).bd(paramad.field_openImAppid, paramad.field_descWordingId);
    if (bo.isNullOrNil(paramad))
    {
      AppMethodBeat.o(78974);
      return null;
    }
    paramad = "＠".concat(String.valueOf(paramad));
    AppMethodBeat.o(78974);
    return paramad;
  }
  
  public static CharSequence a(ad paramad, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(78973);
    paramad = A(paramad);
    if (paramad == null)
    {
      AppMethodBeat.o(78973);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    int i = paramCharSequence.length();
    paramCharSequence.append(paramad);
    int j = paramCharSequence.length();
    paramCharSequence.setSpan(new ForegroundColorSpan(ah.getContext().getResources().getColor(2131690334)), i, j, 33);
    AppMethodBeat.o(78973);
    return paramCharSequence;
  }
  
  private static void a(bhx parambhx)
  {
    AppMethodBeat.i(78969);
    String str = parambhx.gfM;
    com.tencent.mm.j.a.a.a locala = new com.tencent.mm.j.a.a.a();
    locala.eeH = parambhx.xwW.xxi;
    locala.elw = parambhx.xdz;
    if (parambhx.xdz != 0) {
      locala.cAE = parambhx.xdz;
    }
    if (((com.tencent.mm.plugin.chatroom.a.b)g.E(com.tencent.mm.plugin.chatroom.a.b.class)).N(str, locala.cAE))
    {
      localObject = new hk();
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    kq localkq = new kq();
    localkq.cAD.chatroomName = str;
    localkq.cAD.cAE = locala.cAE;
    rc localrc = new rc();
    int i;
    if (parambhx.xdA == null)
    {
      i = 0;
      localrc.eeF = i;
      localrc.wJo = com.tencent.mm.platformtools.aa.wA(parambhx.gfM);
      localrc.wJn = parambhx.xdA.xxk;
      if (parambhx.xdA != null) {
        break label245;
      }
    }
    label245:
    for (Object localObject = new LinkedList();; localObject = b.c.am(parambhx.xdA.wpb))
    {
      localrc.wJm = ((LinkedList)localObject);
      ((com.tencent.mm.plugin.chatroom.a.b)g.E(com.tencent.mm.plugin.chatroom.a.b.class)).a(str, parambhx.xwW.aOg, localrc, r.Zn(), locala, localkq);
      AppMethodBeat.o(78969);
      return;
      i = parambhx.xdA.wpb.size();
      break;
    }
  }
  
  private static void a(String paramString, u paramu, bhy parambhy)
  {
    AppMethodBeat.i(78971);
    i locali = o.adg();
    h localh1;
    if ((!bo.isNullOrNil(paramString)) && (!bo.isNullOrNil(parambhy.xxc)))
    {
      h localh2 = locali.rj(paramString);
      localh1 = localh2;
      if (localh2 == null)
      {
        localh1 = new h();
        localh1.username = paramString;
      }
      localh1.fsl = parambhy.xxb;
      localh1.fsk = parambhy.xxc;
      localh1.dqB = 3;
      if (bo.isNullOrNil(parambhy.xxb)) {
        break label227;
      }
    }
    label227:
    for (boolean bool = true;; bool = false)
    {
      localh1.cM(bool);
      locali.b(localh1);
      if ((parambhy.xxd == 2) && (!r.Zn().equals(paramString)))
      {
        o.acQ();
        d.F(paramString, false);
        o.acQ();
        d.F(paramString, true);
        o.adi().qU(paramString);
      }
      paramu.field_roomowner = parambhy.aOg;
      if (paramu.field_chatroomnoticePublishTime <= parambhy.xxh)
      {
        paramu.field_chatroomnotice = parambhy.kqd;
        paramu.field_chatroomnoticeEditor = parambhy.xxg;
        paramu.field_chatroomnoticePublishTime = parambhy.xxh;
      }
      ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().replace(paramu);
      AppMethodBeat.o(78971);
      return;
    }
  }
  
  public static void b(bhx parambhx)
  {
    AppMethodBeat.i(78970);
    if (!parambhx.gfM.toLowerCase().endsWith("@im.chatroom"))
    {
      ab.e("OpenIMChatRoomContactLogic", "updateChatroom: bad room:[" + parambhx.gfM + "]");
      AppMethodBeat.o(78970);
      return;
    }
    a(parambhx);
    u localu = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(parambhx.gfM);
    Object localObject = localu;
    if (localu == null)
    {
      localObject = new u();
      ((u)localObject).field_chatroomname = parambhx.gfM;
    }
    ((u)localObject).field_chatroomVersion = parambhx.xdz;
    ((u)localObject).dwm().type = parambhx.xwW.xxj;
    ((u)localObject).c(((u)localObject).dwm());
    a(parambhx.gfM, (u)localObject, parambhx.xwW);
    g.RM();
    localObject = ((j)g.E(j.class)).YA().arw(parambhx.gfM);
    int k = ((aq)localObject).field_type;
    ((ad)localObject).jy(parambhx.app_id);
    int i;
    int j;
    if (parambhx.xwW != null)
    {
      i = 1;
      if (bo.isNullOrNil(parambhx.xwW.cAr)) {
        break label454;
      }
      j = 1;
      label232:
      if ((i & j) != 0) {
        ((ad)localObject).jp(parambhx.xwW.cAr);
      }
      ((ad)localObject).setUsername(parambhx.gfM);
      ((ad)localObject).hA(parambhx.xxa);
      ((ad)localObject).setType(parambhx.xwZ & parambhx.oDM);
      ((ad)localObject).hA(parambhx.xxa);
      ((ad)localObject).hB(parambhx.xwY);
      ab.i("OpenIMChatRoomContactLogic", "updateChatroom done %s", new Object[] { ((aq)localObject).field_username });
      g.RM();
      ((j)g.E(j.class)).YA().X((ad)localObject);
      if ((((aq)localObject).field_type & 0x800) == 0) {
        break label459;
      }
      if ((localObject == null) || ((k & 0x800) != (((aq)localObject).field_type & 0x800))) {
        ((j)g.E(j.class)).YF().arN(((aq)localObject).field_username);
      }
    }
    for (;;)
    {
      if (!bo.isNullOrNil(parambhx.app_id)) {
        ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).u(parambhx.app_id, com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext()), "");
      }
      AppMethodBeat.o(78970);
      return;
      i = 0;
      break;
      label454:
      j = 0;
      break label232;
      label459:
      if ((localObject == null) || ((k & 0x800) != (((aq)localObject).field_type & 0x800))) {
        ((j)g.E(j.class)).YF().arO(((aq)localObject).field_username);
      }
    }
  }
  
  public static boolean z(ad paramad)
  {
    AppMethodBeat.i(78972);
    if (paramad == null)
    {
      AppMethodBeat.o(78972);
      return false;
    }
    if (!ad.arf(paramad.field_username))
    {
      AppMethodBeat.o(78972);
      return false;
    }
    if (bo.isNullOrNil(paramad.field_openImAppid))
    {
      AppMethodBeat.o(78972);
      return false;
    }
    if ("3552365301".equals(paramad.field_openImAppid))
    {
      AppMethodBeat.o(78972);
      return true;
    }
    AppMethodBeat.o(78972);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.a
 * JD-Core Version:    0.7.0.1
 */