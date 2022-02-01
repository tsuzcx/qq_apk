package com.tencent.mm.openim.room.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.pf;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dxc;
import com.tencent.mm.protocal.protobuf.dxd;
import com.tencent.mm.protocal.protobuf.dxe;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import java.util.LinkedList;

public final class a
{
  public static boolean W(au paramau)
  {
    AppMethodBeat.i(151316);
    if (paramau == null)
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (!au.bwO(paramau.field_username))
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if (Util.isNullOrNil(paramau.field_openImAppid))
    {
      AppMethodBeat.o(151316);
      return false;
    }
    if ("3552365301".equals(paramau.field_openImAppid))
    {
      AppMethodBeat.o(151316);
      return true;
    }
    AppMethodBeat.o(151316);
    return false;
  }
  
  public static String X(au paramau)
  {
    AppMethodBeat.i(151318);
    if (paramau == null)
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (!au.bwO(paramau.field_username))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    if (Util.isNullOrNil(paramau.field_openImAppid))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paramau = ((com.tencent.mm.openim.api.e)h.ax(com.tencent.mm.openim.api.e.class)).cc(paramau.field_openImAppid, paramau.field_descWordingId);
    if (Util.isNullOrNil(paramau))
    {
      AppMethodBeat.o(151318);
      return null;
    }
    paramau = "＠".concat(String.valueOf(paramau));
    AppMethodBeat.o(151318);
    return paramau;
  }
  
  public static String Y(au paramau)
  {
    AppMethodBeat.i(236144);
    if (paramau == null)
    {
      AppMethodBeat.o(236144);
      return null;
    }
    if (!au.bwQ(paramau.field_username))
    {
      AppMethodBeat.o(236144);
      return null;
    }
    if (Util.isNullOrNil(paramau.field_openImAppid))
    {
      AppMethodBeat.o(236144);
      return null;
    }
    paramau = ((com.tencent.mm.openim.api.e)h.ax(com.tencent.mm.openim.api.e.class)).cc(paramau.field_openImAppid, paramau.field_descWordingId);
    if (Util.isNullOrNil(paramau))
    {
      AppMethodBeat.o(236144);
      return null;
    }
    paramau = "＠".concat(String.valueOf(paramau));
    AppMethodBeat.o(236144);
    return paramau;
  }
  
  public static CharSequence a(au paramau, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(151317);
    paramau = X(paramau);
    if (paramau == null)
    {
      AppMethodBeat.o(151317);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    int i = paramCharSequence.length();
    paramCharSequence.append(paramau);
    int j = paramCharSequence.length();
    paramCharSequence.setSpan(new ForegroundColorSpan(MMApplicationContext.getContext().getResources().getColor(c.b.open_im_display_name_color)), i, j, 33);
    AppMethodBeat.o(151317);
    return paramCharSequence;
  }
  
  private static void a(dxc paramdxc)
  {
    AppMethodBeat.i(151313);
    String str = paramdxc.pss;
    com.tencent.mm.h.a.a.a locala = new com.tencent.mm.h.a.a.a();
    locala.lyL = paramdxc.abcY.abdj;
    locala.lPM = paramdxc.aavC;
    if (paramdxc.aavC != 0) {
      locala.hSm = paramdxc.aavC;
    }
    pf localpf = new pf();
    localpf.hSl.chatroomName = str;
    localpf.hSl.hSm = locala.hSm;
    zg localzg = new zg();
    int i;
    if (paramdxc.aavD == null)
    {
      i = 0;
      localzg.lyF = i;
      localzg.ZhM = w.Sk(paramdxc.pss);
      localzg.ZhL = paramdxc.aavD.abdl;
      if (paramdxc.aavD != null) {
        break label207;
      }
    }
    label207:
    for (LinkedList localLinkedList = new LinkedList();; localLinkedList = b.c.cq(paramdxc.aavD.YFR))
    {
      localzg.ZhK = localLinkedList;
      ((com.tencent.mm.plugin.chatroom.a.a)h.ax(com.tencent.mm.plugin.chatroom.a.a.class)).a(str, paramdxc.abcY.cXV, localzg, z.bAM(), locala, localpf);
      AppMethodBeat.o(151313);
      return;
      i = paramdxc.aavD.YFR.size();
      break;
    }
  }
  
  public static void a(dxc paramdxc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236138);
    if (!paramdxc.pss.toLowerCase().endsWith("@im.chatroom"))
    {
      Log.e("OpenIMChatRoomContactLogic", "updateChatroom: bad room:[" + paramdxc.pss + "]");
      AppMethodBeat.o(236138);
      return;
    }
    a(paramdxc);
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramdxc.pss);
    Object localObject = localaj;
    if (localaj == null)
    {
      localObject = new aj();
      ((aj)localObject).field_chatroomname = paramdxc.pss;
    }
    if (paramInt1 != -1) {
      ((aj)localObject).field_oldChatroomVersion = paramInt1;
    }
    if (paramInt2 != -1) {
      ((aj)localObject).field_chatroomVersion = paramInt2;
    }
    ((aj)localObject).iZg().type = paramdxc.abcY.ZRR;
    ((aj)localObject).c(((aj)localObject).iZg());
    a(paramdxc.pss, (aj)localObject, paramdxc.abcY);
    h.baF();
    localObject = ((n)h.ax(n.class)).bzA().JE(paramdxc.pss);
    int i = ((az)localObject).field_type;
    ((au)localObject).Bg(paramdxc.app_id);
    if (paramdxc.abcY != null)
    {
      paramInt1 = 1;
      if (Util.isNullOrNil(paramdxc.abcY.topic)) {
        break label485;
      }
      paramInt2 = 1;
      label240:
      if ((paramInt1 & paramInt2) != 0) {
        ((au)localObject).setNickname(paramdxc.abcY.topic);
      }
      ((au)localObject).setUsername(paramdxc.pss);
      ((au)localObject).py(paramdxc.ZJt);
      ((au)localObject).setType(paramdxc.abdb & paramdxc.KRj);
      ((au)localObject).py(paramdxc.ZJt);
      ((au)localObject).pz(paramdxc.abda);
      ((au)localObject).gP(paramdxc.abcY.abdk);
      Log.i("OpenIMChatRoomContactLogic", "updateChatroom done %s, chatroom_business_type:%s ", new Object[] { ((az)localObject).field_username, Long.valueOf(paramdxc.abcY.abdk) });
      h.baF();
      ((n)h.ax(n.class)).bzA().aA((au)localObject);
      if ((((az)localObject).field_type & 0x800) == 0) {
        break label490;
      }
      if ((localObject == null) || ((i & 0x800) != (((az)localObject).field_type & 0x800))) {
        ((n)h.ax(n.class)).bzG().bxT(((az)localObject).field_username);
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramdxc.app_id)) {
        ((com.tencent.mm.openim.api.e)h.ax(com.tencent.mm.openim.api.e.class)).y(paramdxc.app_id, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), "");
      }
      AppMethodBeat.o(236138);
      return;
      paramInt1 = 0;
      break;
      label485:
      paramInt2 = 0;
      break label240;
      label490:
      if ((localObject == null) || ((i & 0x800) != (((az)localObject).field_type & 0x800))) {
        ((n)h.ax(n.class)).bzG().bxU(((az)localObject).field_username);
      }
    }
  }
  
  private static void a(String paramString, aj paramaj, dxd paramdxd)
  {
    AppMethodBeat.i(151315);
    k localk = q.bFE();
    j localj1;
    if ((!Util.isNullOrNil(paramString)) && (!Util.isNullOrNil(paramdxd.abdd)))
    {
      j localj2 = localk.LS(paramString);
      localj1 = localj2;
      if (localj2 == null)
      {
        localj1 = new j();
        localj1.username = paramString;
      }
      localj1.osN = paramdxd.abdc;
      localj1.osM = paramdxd.abdd;
      localj1.jZY = 3;
      if (Util.isNullOrNil(paramdxd.abdc)) {
        break label244;
      }
    }
    label244:
    for (boolean bool = true;; bool = false)
    {
      localj1.gX(bool);
      localk.b(localj1);
      if ((paramdxd.abde == 2) && (!z.bAM().equals(paramString)))
      {
        q.bFp();
        AvatarStorage.T(paramString, false);
        q.bFp();
        AvatarStorage.T(paramString, true);
        q.bFG().LB(paramString);
      }
      paramaj.field_roomowner = paramdxd.cXV;
      if (paramaj.field_chatroomnoticePublishTime <= paramdxd.abdi)
      {
        if (Util.isNullOrNil(paramdxd.announcement)) {
          paramaj.field_chatroomNoticeNew = 0;
        }
        paramaj.field_chatroomnotice = paramdxd.announcement;
        paramaj.field_chatroomnoticeEditor = paramdxd.abdh;
        paramaj.field_chatroomnoticePublishTime = paramdxd.abdi;
      }
      ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().replace(paramaj);
      AppMethodBeat.o(151315);
      return;
    }
  }
  
  public static boolean bSp()
  {
    AppMethodBeat.i(184257);
    if (com.tencent.mm.plugin.appbrand.af.b.getPackageInfo(MMApplicationContext.getContext(), "com.tencent.wework") != null)
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