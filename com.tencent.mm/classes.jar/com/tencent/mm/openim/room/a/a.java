package com.tencent.mm.openim.room.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.a.hg;
import com.tencent.mm.h.a.kd;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bax;
import com.tencent.mm.protocal.c.bay;
import com.tencent.mm.protocal.c.baz;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.u;
import java.util.LinkedList;

public final class a
{
  public static CharSequence a(ad paramad, CharSequence paramCharSequence)
  {
    paramad = z(paramad);
    if (paramad == null) {
      return paramCharSequence;
    }
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    int i = paramCharSequence.length();
    paramCharSequence.append(paramad);
    int j = paramCharSequence.length();
    paramCharSequence.setSpan(new ForegroundColorSpan(ae.getContext().getResources().getColor(a.b.open_im_display_name_color)), i, j, 33);
    return paramCharSequence;
  }
  
  public static void a(bax parambax)
  {
    if (!parambax.ePR.toLowerCase().endsWith("@im.chatroom"))
    {
      y.e("OpenIMChatRoomContactLogic", "updateChatroom: bad room:[" + parambax.ePR + "]");
      return;
    }
    Object localObject2 = parambax.ePR;
    Object localObject3 = new com.tencent.mm.k.a.a.a();
    ((com.tencent.mm.k.a.a.a)localObject3).dng = parambax.twR.txd;
    ((com.tencent.mm.k.a.a.a)localObject3).dtJ = parambax.tfo;
    if (parambax.tfo != 0) {
      ((com.tencent.mm.k.a.a.a)localObject3).bSZ = parambax.tfo;
    }
    Object localObject1;
    if (((com.tencent.mm.plugin.chatroom.a.b)g.r(com.tencent.mm.plugin.chatroom.a.b.class)).G((String)localObject2, ((com.tencent.mm.k.a.a.a)localObject3).bSZ))
    {
      localObject1 = new hg();
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    }
    Object localObject4 = new kd();
    ((kd)localObject4).bSY.chatroomName = ((String)localObject2);
    ((kd)localObject4).bSY.bSZ = ((com.tencent.mm.k.a.a.a)localObject3).bSZ;
    Object localObject5 = new oa();
    int i;
    if (parambax.tfp == null)
    {
      i = 0;
      ((oa)localObject5).dne = i;
      ((oa)localObject5).sLB = aa.pj(parambax.ePR);
      ((oa)localObject5).sLA = parambax.tfp.txe;
      if (parambax.tfp != null) {
        break label874;
      }
      localObject1 = new LinkedList();
      label234:
      ((oa)localObject5).sLz = ((LinkedList)localObject1);
      ((com.tencent.mm.plugin.chatroom.a.b)g.r(com.tencent.mm.plugin.chatroom.a.b.class)).a((String)localObject2, parambax.twR.aHm, (oa)localObject5, q.Gj(), (com.tencent.mm.k.a.a.a)localObject3, (com.tencent.mm.sdk.b.b)localObject4);
      localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().in(parambax.ePR);
      if (localObject1 != null) {
        break label955;
      }
      localObject1 = new u();
      ((u)localObject1).field_chatroomname = parambax.ePR;
    }
    label439:
    label953:
    label955:
    for (;;)
    {
      ((u)localObject1).field_chatroomVersion = parambax.tfo;
      localObject4 = parambax.ePR;
      localObject5 = parambax.twR;
      i locali = o.Kh();
      boolean bool;
      if ((!bk.bl((String)localObject4)) && (!bk.bl(((bay)localObject5).twX)))
      {
        localObject3 = locali.kp((String)localObject4);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = new h();
          ((h)localObject2).username = ((String)localObject4);
        }
        ((h)localObject2).ebT = ((bay)localObject5).twW;
        ((h)localObject2).ebS = ((bay)localObject5).twX;
        ((h)localObject2).cCq = 3;
        if (bk.bl(((bay)localObject5).twW)) {
          break label889;
        }
        bool = true;
        ((h)localObject2).bK(bool);
        locali.a((h)localObject2);
        if ((((bay)localObject5).twY == 2) && (!q.Gj().equals(localObject4)))
        {
          o.JQ();
          d.B((String)localObject4, false);
          o.JQ();
          d.B((String)localObject4, true);
          o.Kj().kb((String)localObject4);
        }
      }
      ((u)localObject1).field_roomowner = ((bay)localObject5).aHm;
      if (((u)localObject1).field_chatroomnoticePublishTime <= ((bay)localObject5).txc)
      {
        ((u)localObject1).field_chatroomnotice = ((bay)localObject5).ioW;
        ((u)localObject1).field_chatroomnoticeEditor = ((bay)localObject5).txb;
        ((u)localObject1).field_chatroomnoticePublishTime = ((bay)localObject5).txc;
      }
      ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().a((com.tencent.mm.sdk.e.c)localObject1);
      g.DQ();
      localObject1 = ((j)g.r(j.class)).Fw().abl(parambax.ePR);
      int k = ((ao)localObject1).field_type;
      ((ad)localObject1).dt(parambax.app_id);
      label634:
      int j;
      if (parambax.twR != null)
      {
        i = 1;
        if (bk.bl(parambax.twR.bSM)) {
          break label900;
        }
        j = 1;
        if ((i & j) != 0) {
          ((ad)localObject1).dk(parambax.twR.bSM);
        }
        ((ad)localObject1).setUsername(parambax.ePR);
        ((ad)localObject1).fp(parambax.twV);
        ((ad)localObject1).setType(parambax.twU & parambax.mdq);
        ((ad)localObject1).fp(parambax.twV);
        ((ad)localObject1).fq(parambax.twT);
        y.i("OpenIMChatRoomContactLogic", "updateChatroom done %s", new Object[] { ((ao)localObject1).field_username });
        g.DQ();
        ((j)g.r(j.class)).Fw().U((ad)localObject1);
        if ((((ao)localObject1).field_type & 0x800) == 0) {
          break label905;
        }
        if ((localObject1 == null) || ((k & 0x800) != (((ao)localObject1).field_type & 0x800))) {
          ((j)g.r(j.class)).FB().abB(((ao)localObject1).field_username);
        }
      }
      for (;;)
      {
        if (bk.bl(parambax.app_id)) {
          break label953;
        }
        ((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).r(parambax.app_id, x.fB(ae.getContext()), "");
        return;
        i = parambax.tfp.svR.size();
        break;
        label874:
        localObject1 = b.c.ae(parambax.tfp.svR);
        break label234;
        label889:
        bool = false;
        break label439;
        i = 0;
        break label634;
        j = 0;
        break label649;
        if ((localObject1 == null) || ((k & 0x800) != (((ao)localObject1).field_type & 0x800))) {
          ((j)g.r(j.class)).FB().abC(((ao)localObject1).field_username);
        }
      }
      break;
    }
  }
  
  public static String z(ad paramad)
  {
    if (paramad == null) {
      return null;
    }
    if (!ad.aaU(paramad.field_username)) {
      return null;
    }
    if (bk.bl(paramad.field_openImAppid)) {
      return null;
    }
    if ("3552365301".equals(paramad.field_openImAppid))
    {
      paramad = ((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).aK(paramad.field_openImAppid, paramad.field_descWordingId);
      if (bk.bl(paramad)) {
        return null;
      }
      return "＠" + paramad;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.a
 * JD-Core Version:    0.7.0.1
 */