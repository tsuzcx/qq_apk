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
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.caa;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.x;
import java.util.LinkedList;

public final class a
{
  public static boolean G(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(151316);
    if (paramai == null)
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (!com.tencent.mm.storage.ai.aNc(paramai.field_username))
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (bs.isNullOrNil(paramai.field_openImAppid))
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if ("3552365301".equals(paramai.field_openImAppid))
    {
      AppMethodBeat.o(151316);
      return true;
    }
    AppMethodBeat.o(151316);
    return false;
  }
  
  public static String H(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(151318);
    if (paramai == null)
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (!com.tencent.mm.storage.ai.aNc(paramai.field_username))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (bs.isNullOrNil(paramai.field_openImAppid))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paramai = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bB(paramai.field_openImAppid, paramai.field_descWordingId);
    if (bs.isNullOrNil(paramai))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paramai = "＠".concat(String.valueOf(paramai));
    AppMethodBeat.o(151318);
    return paramai;
  }
  
  public static CharSequence a(com.tencent.mm.storage.ai paramai, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151317);
    paramai = H(paramai);
    if (paramai == null)
    {
      AppMethodBeat.o(151317);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    int i = paramCharSequence.length();
    paramCharSequence.append(paramai);
    int j = paramCharSequence.length();
    paramCharSequence.setSpan(new ForegroundColorSpan(com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getColor(2131100723)), i, j, 33);
    AppMethodBeat.o(151317);
    return paramCharSequence;
  }
  
  private static void a(bzy parambzy)
  {
    AppMethodBeat.i(151313);
    String str = parambzy.ioe;
    com.tencent.mm.j.a.a.a locala = new com.tencent.mm.j.a.a.a();
    locala.maxCount = parambzy.FoP.Fpb;
    locala.fBU = parambzy.ERF;
    if (parambzy.ERF != 0) {
      locala.doy = parambzy.ERF;
    }
    me localme = new me();
    localme.dox.chatroomName = str;
    localme.dox.doy = locala.doy;
    ua localua = new ua();
    int i;
    if (parambzy.ERG == null)
    {
      i = 0;
      localua.fsB = i;
      localua.Eod = z.FI(parambzy.ioe);
      localua.Eoc = parambzy.ERG.Fpe;
      if (parambzy.ERG != null) {
        break label207;
      }
    }
    label207:
    for (LinkedList localLinkedList = new LinkedList();; localLinkedList = b.c.aE(parambzy.ERG.DQg))
    {
      localua.Eob = localLinkedList;
      ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).a(str, parambzy.FoP.bkl, localua, u.axw(), locala, localme);
      AppMethodBeat.o(151313);
      return;
      i = parambzy.ERG.DQg.size();
      break;
    }
  }
  
  public static void a(bzy parambzy, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210349);
    if (!parambzy.ioe.toLowerCase().endsWith("@im.chatroom"))
    {
      ac.e("OpenIMChatRoomContactLogic", "updateChatroom: bad room:[" + parambzy.ioe + "]");
      AppMethodBeat.o(210349);
      return;
    }
    a(parambzy);
    x localx = ((c)g.ab(c.class)).awK().xN(parambzy.ioe);
    Object localObject = localx;
    if (localx == null)
    {
      localObject = new x();
      ((x)localObject).field_chatroomname = parambzy.ioe;
    }
    if (paramInt1 != -1) {
      ((x)localObject).field_oldChatroomVersion = paramInt1;
    }
    if (paramInt2 != -1) {
      ((x)localObject).field_chatroomVersion = paramInt2;
    }
    ((x)localObject).eZJ().type = parambzy.FoP.Fpc;
    ((x)localObject).c(((x)localObject).eZJ());
    a(parambzy.ioe, (x)localObject, parambzy.FoP);
    g.agS();
    localObject = ((k)g.ab(k.class)).awB().aNt(parambzy.ioe);
    int i = ((av)localObject).field_type;
    ((com.tencent.mm.storage.ai)localObject).qs(parambzy.app_id);
    if (parambzy.FoP != null)
    {
      paramInt1 = 1;
      if (bs.isNullOrNil(parambzy.FoP.dol)) {
        break label484;
      }
      paramInt2 = 1;
      label239:
      if ((paramInt1 & paramInt2) != 0) {
        ((com.tencent.mm.storage.ai)localObject).qj(parambzy.FoP.dol);
      }
      ((com.tencent.mm.storage.ai)localObject).setUsername(parambzy.ioe);
      ((com.tencent.mm.storage.ai)localObject).jJ(parambzy.FoT);
      ((com.tencent.mm.storage.ai)localObject).setType(parambzy.FoS & parambzy.uGY);
      ((com.tencent.mm.storage.ai)localObject).jJ(parambzy.FoT);
      ((com.tencent.mm.storage.ai)localObject).jK(parambzy.FoR);
      ((com.tencent.mm.storage.ai)localObject).os(parambzy.FoP.Fpd);
      ac.i("OpenIMChatRoomContactLogic", "updateChatroom done %s, chatroom_business_type:%s ", new Object[] { ((av)localObject).field_username, Long.valueOf(parambzy.FoP.Fpd) });
      g.agS();
      ((k)g.ab(k.class)).awB().af((com.tencent.mm.storage.ai)localObject);
      if ((((av)localObject).field_type & 0x800) == 0) {
        break label489;
      }
      if ((localObject == null) || ((i & 0x800) != (((av)localObject).field_type & 0x800))) {
        ((k)g.ab(k.class)).awG().aNO(((av)localObject).field_username);
      }
    }
    for (;;)
    {
      if (!bs.isNullOrNil(parambzy.app_id)) {
        ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).t(parambzy.app_id, ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext()), "");
      }
      AppMethodBeat.o(210349);
      return;
      paramInt1 = 0;
      break;
      label484:
      paramInt2 = 0;
      break label239;
      label489:
      if ((localObject == null) || ((i & 0x800) != (((av)localObject).field_type & 0x800))) {
        ((k)g.ab(k.class)).awG().aNP(((av)localObject).field_username);
      }
    }
  }
  
  private static void a(String paramString, x paramx, bzz parambzz)
  {
    AppMethodBeat.i(151315);
    j localj = p.aBw();
    i locali1;
    if ((!bs.isNullOrNil(paramString)) && (!bs.isNullOrNil(parambzz.FoV)))
    {
      i locali2 = localj.Ak(paramString);
      locali1 = locali2;
      if (locali2 == null)
      {
        locali1 = new i();
        locali1.username = paramString;
      }
      locali1.huF = parambzz.FoU;
      locali1.huE = parambzz.FoV;
      locali1.exK = 3;
      if (bs.isNullOrNil(parambzz.FoU)) {
        break label229;
      }
    }
    label229:
    for (boolean bool = true;; bool = false)
    {
      locali1.ez(bool);
      localj.b(locali1);
      if ((parambzz.FoW == 2) && (!u.axw().equals(paramString)))
      {
        p.aBh();
        e.L(paramString, false);
        p.aBh();
        e.L(paramString, true);
        p.aBy().zV(paramString);
      }
      paramx.field_roomowner = parambzz.bkl;
      if (paramx.field_chatroomnoticePublishTime <= parambzz.Fpa)
      {
        paramx.field_chatroomnotice = parambzz.nYx;
        paramx.field_chatroomnoticeEditor = parambzz.FoZ;
        paramx.field_chatroomnoticePublishTime = parambzz.Fpa;
      }
      ((c)g.ab(c.class)).awK().replace(paramx);
      AppMethodBeat.o(151315);
      return;
    }
  }
  
  public static boolean aMo()
  {
    AppMethodBeat.i(184257);
    if (com.tencent.mm.plugin.appbrand.z.b.getPackageInfo(com.tencent.mm.sdk.platformtools.ai.getContext(), "com.tencent.wework") != null)
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