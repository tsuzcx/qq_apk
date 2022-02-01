package com.tencent.mm.openim.room.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cfk;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.vy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import java.util.LinkedList;

public final class a
{
  public static boolean N(an paraman)
  {
    AppMethodBeat.i(151316);
    if (paraman == null)
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (!an.aUq(paraman.field_username))
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (bu.isNullOrNil(paraman.field_openImAppid))
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if ("3552365301".equals(paraman.field_openImAppid))
    {
      AppMethodBeat.o(151316);
      return true;
    }
    AppMethodBeat.o(151316);
    return false;
  }
  
  public static String O(an paraman)
  {
    AppMethodBeat.i(151318);
    if (paraman == null)
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (!an.aUq(paraman.field_username))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (bu.isNullOrNil(paraman.field_openImAppid))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paraman = ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).bC(paraman.field_openImAppid, paraman.field_descWordingId);
    if (bu.isNullOrNil(paraman))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paraman = "＠".concat(String.valueOf(paraman));
    AppMethodBeat.o(151318);
    return paraman;
  }
  
  public static CharSequence a(an paraman, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151317);
    paraman = O(paraman);
    if (paraman == null)
    {
      AppMethodBeat.o(151317);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    int i = paramCharSequence.length();
    paramCharSequence.append(paraman);
    int j = paramCharSequence.length();
    paramCharSequence.setSpan(new ForegroundColorSpan(ak.getContext().getResources().getColor(2131100723)), i, j, 33);
    AppMethodBeat.o(151317);
    return paramCharSequence;
  }
  
  private static void a(cfj paramcfj)
  {
    AppMethodBeat.i(151313);
    String str = paramcfj.iKu;
    com.tencent.mm.k.a.a.a locala = new com.tencent.mm.k.a.a.a();
    locala.maxCount = paramcfj.Hsc.Hsn;
    locala.fXo = paramcfj.GUx;
    if (paramcfj.GUx != 0) {
      locala.dBr = paramcfj.GUx;
    }
    mo localmo = new mo();
    localmo.dBq.chatroomName = str;
    localmo.dBq.dBr = locala.dBr;
    vy localvy = new vy();
    int i;
    if (paramcfj.GUy == null)
    {
      i = 0;
      localvy.fNf = i;
      localvy.GnL = z.Jw(paramcfj.iKu);
      localvy.GnK = paramcfj.GUy.Hsq;
      if (paramcfj.GUy != null) {
        break label207;
      }
    }
    label207:
    for (LinkedList localLinkedList = new LinkedList();; localLinkedList = b.c.aF(paramcfj.GUy.FNS))
    {
      localvy.GnJ = localLinkedList;
      ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).a(str, paramcfj.Hsc.buG, localvy, v.aAC(), locala, localmo);
      AppMethodBeat.o(151313);
      return;
      i = paramcfj.GUy.FNS.size();
      break;
    }
  }
  
  public static void a(cfj paramcfj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218751);
    if (!paramcfj.iKu.toLowerCase().endsWith("@im.chatroom"))
    {
      ae.e("OpenIMChatRoomContactLogic", "updateChatroom: bad room:[" + paramcfj.iKu + "]");
      AppMethodBeat.o(218751);
      return;
    }
    a(paramcfj);
    ac localac = ((c)g.ab(c.class)).azP().Bx(paramcfj.iKu);
    Object localObject = localac;
    if (localac == null)
    {
      localObject = new ac();
      ((ac)localObject).field_chatroomname = paramcfj.iKu;
    }
    if (paramInt1 != -1) {
      ((ac)localObject).field_oldChatroomVersion = paramInt1;
    }
    if (paramInt2 != -1) {
      ((ac)localObject).field_chatroomVersion = paramInt2;
    }
    ((ac)localObject).ftL().type = paramcfj.Hsc.Hso;
    ((ac)localObject).c(((ac)localObject).ftL());
    a(paramcfj.iKu, (ac)localObject, paramcfj.Hsc);
    g.ajS();
    localObject = ((l)g.ab(l.class)).azF().BH(paramcfj.iKu);
    int i = ((aw)localObject).field_type;
    ((an)localObject).tx(paramcfj.app_id);
    if (paramcfj.Hsc != null)
    {
      paramInt1 = 1;
      if (bu.isNullOrNil(paramcfj.Hsc.dBe)) {
        break label484;
      }
      paramInt2 = 1;
      label239:
      if ((paramInt1 & paramInt2) != 0) {
        ((an)localObject).to(paramcfj.Hsc.dBe);
      }
      ((an)localObject).setUsername(paramcfj.iKu);
      ((an)localObject).kj(paramcfj.GFG);
      ((an)localObject).setType(paramcfj.Hsf & paramcfj.vWf);
      ((an)localObject).kj(paramcfj.GFG);
      ((an)localObject).kk(paramcfj.Hse);
      ((an)localObject).qF(paramcfj.Hsc.Hsp);
      ae.i("OpenIMChatRoomContactLogic", "updateChatroom done %s, chatroom_business_type:%s ", new Object[] { ((aw)localObject).field_username, Long.valueOf(paramcfj.Hsc.Hsp) });
      g.ajS();
      ((l)g.ab(l.class)).azF().am((an)localObject);
      if ((((aw)localObject).field_type & 0x800) == 0) {
        break label489;
      }
      if ((localObject == null) || ((i & 0x800) != (((aw)localObject).field_type & 0x800))) {
        ((l)g.ab(l.class)).azL().aVg(((aw)localObject).field_username);
      }
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramcfj.app_id)) {
        ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).s(paramcfj.app_id, ad.iR(ak.getContext()), "");
      }
      AppMethodBeat.o(218751);
      return;
      paramInt1 = 0;
      break;
      label484:
      paramInt2 = 0;
      break label239;
      label489:
      if ((localObject == null) || ((i & 0x800) != (((aw)localObject).field_type & 0x800))) {
        ((l)g.ab(l.class)).azL().aVh(((aw)localObject).field_username);
      }
    }
  }
  
  private static void a(String paramString, ac paramac, cfk paramcfk)
  {
    AppMethodBeat.i(151315);
    j localj = p.aEN();
    i locali1;
    if ((!bu.isNullOrNil(paramString)) && (!bu.isNullOrNil(paramcfk.Hsh)))
    {
      i locali2 = localj.DL(paramString);
      locali1 = locali2;
      if (locali2 == null)
      {
        locali1 = new i();
        locali1.username = paramString;
      }
      locali1.hPQ = paramcfk.Hsg;
      locali1.hPP = paramcfk.Hsh;
      locali1.eQU = 3;
      if (bu.isNullOrNil(paramcfk.Hsg)) {
        break label229;
      }
    }
    label229:
    for (boolean bool = true;; bool = false)
    {
      locali1.eD(bool);
      localj.b(locali1);
      if ((paramcfk.Hsi == 2) && (!v.aAC().equals(paramString)))
      {
        p.aEA();
        e.L(paramString, false);
        p.aEA();
        e.L(paramString, true);
        p.aEP().Dw(paramString);
      }
      paramac.field_roomowner = paramcfk.buG;
      if (paramac.field_chatroomnoticePublishTime <= paramcfk.Hsm)
      {
        paramac.field_chatroomnotice = paramcfk.oIt;
        paramac.field_chatroomnoticeEditor = paramcfk.Hsl;
        paramac.field_chatroomnoticePublishTime = paramcfk.Hsm;
      }
      ((c)g.ab(c.class)).azP().replace(paramac);
      AppMethodBeat.o(151315);
      return;
    }
  }
  
  public static boolean aQa()
  {
    AppMethodBeat.i(184257);
    if (com.tencent.mm.plugin.appbrand.y.b.getPackageInfo(ak.getContext(), "com.tencent.wework") != null)
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