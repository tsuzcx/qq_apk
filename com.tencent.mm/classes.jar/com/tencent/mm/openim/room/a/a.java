package com.tencent.mm.openim.room.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.w;
import java.util.LinkedList;

public final class a
{
  public static boolean F(af paramaf)
  {
    AppMethodBeat.i(151316);
    if (paramaf == null)
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (!af.aHH(paramaf.field_username))
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (bt.isNullOrNil(paramaf.field_openImAppid))
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if ("3552365301".equals(paramaf.field_openImAppid))
    {
      AppMethodBeat.o(151316);
      return true;
    }
    AppMethodBeat.o(151316);
    return false;
  }
  
  public static String G(af paramaf)
  {
    AppMethodBeat.i(151318);
    if (paramaf == null)
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (!af.aHH(paramaf.field_username))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (bt.isNullOrNil(paramaf.field_openImAppid))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paramaf = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bt(paramaf.field_openImAppid, paramaf.field_descWordingId);
    if (bt.isNullOrNil(paramaf))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paramaf = "＠".concat(String.valueOf(paramaf));
    AppMethodBeat.o(151318);
    return paramaf;
  }
  
  public static CharSequence a(af paramaf, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151317);
    paramaf = G(paramaf);
    if (paramaf == null)
    {
      AppMethodBeat.o(151317);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    int i = paramCharSequence.length();
    paramCharSequence.append(paramaf);
    int j = paramCharSequence.length();
    paramCharSequence.setSpan(new ForegroundColorSpan(com.tencent.mm.sdk.platformtools.aj.getContext().getResources().getColor(2131100723)), i, j, 33);
    AppMethodBeat.o(151317);
    return paramCharSequence;
  }
  
  private static void a(bvg parambvg)
  {
    AppMethodBeat.i(151313);
    String str = parambvg.hNI;
    com.tencent.mm.j.a.a.a locala = new com.tencent.mm.j.a.a.a();
    locala.maxCount = parambvg.DSt.DSF;
    locala.fyn = parambvg.Dwk;
    if (parambvg.Dwk != 0) {
      locala.dqN = parambvg.Dwk;
    }
    if (((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).U(str, locala.dqN))
    {
      localObject = new ie();
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    lv locallv = new lv();
    locallv.dqM.chatroomName = str;
    locallv.dqM.dqN = locala.dqN;
    tq localtq = new tq();
    int i;
    if (parambvg.Dwl == null)
    {
      i = 0;
      localtq.fpb = i;
      localtq.CVt = z.BE(parambvg.hNI);
      localtq.CVs = parambvg.Dwl.DSI;
      if (parambvg.Dwl != null) {
        break label245;
      }
    }
    label245:
    for (Object localObject = new LinkedList();; localObject = b.c.aH(parambvg.Dwl.CxK))
    {
      localtq.CVr = ((LinkedList)localObject);
      ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).a(str, parambvg.DSt.bjG, localtq, u.aqG(), locala, locallv);
      AppMethodBeat.o(151313);
      return;
      i = parambvg.Dwl.CxK.size();
      break;
    }
  }
  
  private static void a(String paramString, w paramw, bvh parambvh)
  {
    AppMethodBeat.i(151315);
    j localj = p.auF();
    i locali1;
    if ((!bt.isNullOrNil(paramString)) && (!bt.isNullOrNil(parambvh.DSz)))
    {
      i locali2 = localj.we(paramString);
      locali1 = locali2;
      if (locali2 == null)
      {
        locali1 = new i();
        locali1.username = paramString;
      }
      locali1.gUg = parambvh.DSy;
      locali1.gUf = parambvh.DSz;
      locali1.evo = 3;
      if (bt.isNullOrNil(parambvh.DSy)) {
        break label227;
      }
    }
    label227:
    for (boolean bool = true;; bool = false)
    {
      locali1.ee(bool);
      localj.b(locali1);
      if ((parambvh.DSA == 2) && (!u.aqG().equals(paramString)))
      {
        p.auq();
        e.K(paramString, false);
        p.auq();
        e.K(paramString, true);
        p.auH().vP(paramString);
      }
      paramw.field_roomowner = parambvh.bjG;
      if (paramw.field_chatroomnoticePublishTime <= parambvh.DSE)
      {
        paramw.field_chatroomnotice = parambvh.nvx;
        paramw.field_chatroomnoticeEditor = parambvh.DSD;
        paramw.field_chatroomnoticePublishTime = parambvh.DSE;
      }
      ((c)g.ab(c.class)).apV().replace(paramw);
      AppMethodBeat.o(151315);
      return;
    }
  }
  
  public static boolean aFx()
  {
    AppMethodBeat.i(184257);
    if (com.tencent.mm.plugin.appbrand.aa.b.getPackageInfo(com.tencent.mm.sdk.platformtools.aj.getContext(), "com.tencent.wework") != null)
    {
      AppMethodBeat.o(184257);
      return true;
    }
    AppMethodBeat.o(184257);
    return false;
  }
  
  public static void b(bvg parambvg)
  {
    AppMethodBeat.i(151314);
    if (!parambvg.hNI.toLowerCase().endsWith("@im.chatroom"))
    {
      ad.e("OpenIMChatRoomContactLogic", "updateChatroom: bad room:[" + parambvg.hNI + "]");
      AppMethodBeat.o(151314);
      return;
    }
    a(parambvg);
    w localw = ((c)g.ab(c.class)).apV().tH(parambvg.hNI);
    Object localObject = localw;
    if (localw == null)
    {
      localObject = new w();
      ((w)localObject).field_chatroomname = parambvg.hNI;
    }
    ((w)localObject).field_chatroomVersion = parambvg.Dwk;
    ((w)localObject).eKm().type = parambvg.DSt.DSG;
    ((w)localObject).c(((w)localObject).eKm());
    a(parambvg.hNI, (w)localObject, parambvg.DSt);
    g.afC();
    localObject = ((k)g.ab(k.class)).apM().aHY(parambvg.hNI);
    int k = ((au)localObject).field_type;
    ((af)localObject).nm(parambvg.app_id);
    int i;
    int j;
    if (parambvg.DSt != null)
    {
      i = 1;
      if (bt.isNullOrNil(parambvg.DSt.dqA)) {
        break label479;
      }
      j = 1;
      label232:
      if ((i & j) != 0) {
        ((af)localObject).nd(parambvg.DSt.dqA);
      }
      ((af)localObject).setUsername(parambvg.hNI);
      ((af)localObject).jL(parambvg.DSx);
      ((af)localObject).setType(parambvg.DSw & parambvg.tyA);
      ((af)localObject).jL(parambvg.DSx);
      ((af)localObject).jM(parambvg.DSv);
      ((af)localObject).kQ(parambvg.DSt.DSH);
      ad.i("OpenIMChatRoomContactLogic", "updateChatroom done %s, chatroom_business_type:%s ", new Object[] { ((au)localObject).field_username, Long.valueOf(parambvg.DSt.DSH) });
      g.afC();
      ((k)g.ab(k.class)).apM().ae((af)localObject);
      if ((((au)localObject).field_type & 0x800) == 0) {
        break label484;
      }
      if ((localObject == null) || ((k & 0x800) != (((au)localObject).field_type & 0x800))) {
        ((k)g.ab(k.class)).apR().aIt(((au)localObject).field_username);
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(parambvg.app_id)) {
        ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).t(parambvg.app_id, ac.ir(com.tencent.mm.sdk.platformtools.aj.getContext()), "");
      }
      AppMethodBeat.o(151314);
      return;
      i = 0;
      break;
      label479:
      j = 0;
      break label232;
      label484:
      if ((localObject == null) || ((k & 0x800) != (((au)localObject).field_type & 0x800))) {
        ((k)g.ab(k.class)).apR().aIu(((au)localObject).field_username);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.a
 * JD-Core Version:    0.7.0.1
 */