package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a;
import com.tencent.mm.aa.c;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.a.e;
import com.tencent.mm.plugin.card.model.a.e.a;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.List;
import java.util.Map;

final class am$6$1
  implements Runnable
{
  am$6$1(am.6 param6, String paramString, h.a parama) {}
  
  public final void run()
  {
    int k = 1;
    AppMethodBeat.i(112877);
    k localk = am.cHw();
    Object localObject1 = this.nHw;
    String str1 = this.lrj.jQG.HlH;
    Log.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is ".concat(String.valueOf(str1)));
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
      if (localObject2 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          Log.e("MicroMsg.CardMsgManager", "card msg == null");
          AppMethodBeat.o(112877);
          return;
          localObject1 = new g();
          Object localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.card_type");
          label152:
          label362:
          String str2;
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3)))
          {
            ((g)localObject1).field_card_type = Util.getInt((String)localObject3, 0);
            ((g)localObject1).field_title = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.title"));
            ((g)localObject1).field_description = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.description"));
            ((g)localObject1).field_logo_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_url"));
            ((g)localObject1).field_logo_color = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_color"));
            localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.time");
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
              break label1177;
            }
            if (Util.getLong((String)localObject3, 0L) < 2147483647L) {
              break label1163;
            }
            ((g)localObject1).field_time = 2147483647;
            label270:
            ((g)localObject1).field_card_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.card_id"));
            ((g)localObject1).field_card_tp_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.card_tp_id"));
            ((g)localObject1).field_msg_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_id"));
            localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_type");
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
              break label1193;
            }
            ((g)localObject1).field_msg_type = Util.getInt((String)localObject3, 0);
            localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.jump_type");
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
              break label1202;
            }
            ((g)localObject1).field_jump_type = Util.getInt((String)localObject3, 0);
            label403:
            ((g)localObject1).field_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.url"));
            str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.text");
            if (!TextUtils.isEmpty(str2))
            {
              localObject3 = new ty();
              ((ty)localObject3).text = str2;
              ((ty)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.button.url"));
              str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.action_type");
              if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                break label1211;
              }
              ((ty)localObject3).tpK = Util.getInt(str2, 0);
              label516:
              ((g)localObject1).tpB = ((ty)localObject3);
            }
          }
          try
          {
            ((g)localObject1).field_buttonData = ((g)localObject1).tpB.toByteArray();
            str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.text");
            if (!TextUtils.isEmpty(str2))
            {
              localObject3 = new uq();
              ((uq)localObject3).text = str2;
              ((uq)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.url"));
              str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.type");
              if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                break label1261;
              }
              ((uq)localObject3).type = Util.getInt(str2, 0);
              str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.endtime");
              if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                break label1284;
              }
              if (Long.valueOf(str2).longValue() < 2147483647L) {
                break label1270;
              }
              ((uq)localObject3).Jnj = 2147483647;
              ((g)localObject1).tpC = ((uq)localObject3);
            }
          }
          catch (Exception localException1)
          {
            try
            {
              for (;;)
              {
                ((g)localObject1).field_operData = ((g)localObject1).tpC.toByteArray();
                localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.report_scene");
                if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                  break label1341;
                }
                ((g)localObject1).field_report_scene = Util.getInt((String)localObject3, 0);
                ((g)localObject1).field_read_state = 1;
                ((g)localObject1).field_accept_buttons = k.i((Map)localObject2, ".sysmsg.carditemmsg");
                ((g)localObject1).field_jump_buttons = k.h((Map)localObject2, ".sysmsg.carditemmsg");
                localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.get_layout_scene");
                if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                  break label1350;
                }
                ((g)localObject1).tpF = Util.getInt((String)localObject3, 0);
                ((g)localObject1).field_consumed_box_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.consumed_box_id"));
                ((g)localObject1).tpv = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_wording"));
                ((g)localObject1).tpw = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_buff"));
                ((g)localObject1).tpx = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_icon_url"));
                ((g)localObject1).tpy = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.title"));
                ((g)localObject1).tpz = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.icon_url"));
                localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_scene");
                if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                  break label1359;
                }
                ((g)localObject1).tpG = Util.getInt((String)localObject3, 0);
                Log.i("MicroMsg.CardMsgManager", "msg_scene is ".concat(String.valueOf(localObject3)));
                localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.need_check");
                Log.i("MicroMsg.CardMsgManager", "need_check:".concat(String.valueOf(localObject3)));
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label1368;
                }
                ((g)localObject1).tpA = ((String)localObject3).equals("true");
                str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.all_unavailable");
                Log.i("MicroMsg.CardMsgManager", "all_Unavailable:".concat(String.valueOf(localObject3)));
                if (TextUtils.isEmpty(str2)) {
                  break label1377;
                }
                ((g)localObject1).tpH = str2.equals("true");
                ((g)localObject1).field_unavailable_qr_code_list = k.j((Map)localObject2, ".sysmsg.carditemmsg");
                if ((!"true".equals(((Map)localObject2).get(".sysmsg.carditemmsg.need_pull_card_entrance"))) && (!"1".equals(((Map)localObject2).get(".sysmsg.carditemmsg.need_pull_card_entrance")))) {
                  break label1386;
                }
                bool = true;
                ((g)localObject1).field_need_pull_card_entrance = bool;
                break;
                ((g)localObject1).field_card_type = 0;
                break label152;
                label1163:
                ((g)localObject1).field_time = Util.getInt((String)localObject3, 0);
                break label270;
                label1177:
                ((g)localObject1).field_time = ((int)(System.currentTimeMillis() / 1000L));
                break label270;
                label1193:
                ((g)localObject1).field_msg_type = 0;
                break label362;
                label1202:
                ((g)localObject1).field_jump_type = 1;
                break label403;
                label1211:
                ((ty)localObject3).tpK = 0;
                break label516;
                localException1 = localException1;
                Log.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[] { localException1.getMessage() });
                Log.printErrStackTrace("MicroMsg.CardMsgInfo", localException1, "", new Object[0]);
                continue;
                label1261:
                localException1.type = 0;
                continue;
                label1270:
                localException1.Jnj = Util.getInt(str2, 0);
              }
              label1284:
              localException1.Jnj = ((int)(System.currentTimeMillis() / 1000L));
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Log.e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", new Object[] { localException2.getMessage() });
                Log.printErrStackTrace("MicroMsg.CardMsgInfo", localException2, "", new Object[0]);
                continue;
                label1341:
                ((g)localObject1).field_report_scene = 2;
                continue;
                label1350:
                ((g)localObject1).tpF = 0;
                continue;
                label1359:
                ((g)localObject1).tpG = 0;
                continue;
                label1368:
                ((g)localObject1).tpA = false;
                continue;
                label1377:
                ((g)localObject1).tpH = false;
                continue;
                label1386:
                boolean bool = false;
              }
            }
          }
        }
      }
      if (TextUtils.isEmpty(((g)localObject1).field_card_id)) {
        Log.e("MicroMsg.CardMsgManager", "card id == null");
      }
      localObject2 = ((g)localObject1).field_msg_id;
      ((g)localObject1).field_msg_id = str1;
      if (TextUtils.isEmpty(((g)localObject1).field_msg_id)) {
        ((g)localObject1).field_msg_id = ((String)localObject2);
      }
      if (TextUtils.isEmpty(((g)localObject1).field_msg_id)) {
        ((g)localObject1).field_msg_id = System.currentTimeMillis();
      }
      Log.i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + ((g)localObject1).field_msg_id);
      Log.i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + ((g)localObject1).field_msg_type);
      if (((g)localObject1).tpF != 0) {
        h.aHG().aHp().set(ar.a.VhZ, Integer.valueOf(((g)localObject1).tpF));
      }
      Log.i("MicroMsg.CardMsgManager", "reddot_buff is " + ((g)localObject1).tpw);
      if (TextUtils.isEmpty(((g)localObject1).tpw)) {
        break label1963;
      }
      h.aHG().aHp().set(ar.a.VhV, ((g)localObject1).tpw);
      if ((((g)localObject1).field_msg_type & 0x1) != 0)
      {
        Log.i("MicroMsg.CardMsgManager", "msg_tips_title is " + ((g)localObject1).tpy);
        Log.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + ((g)localObject1).tpz);
        h.aHG().aHp().set(ar.a.VhX, ((g)localObject1).tpy);
        h.aHG().aHp().set(ar.a.VhY, ((g)localObject1).tpz);
      }
      if ((((g)localObject1).field_msg_type & 0x40) == 0) {
        break label1974;
      }
      c.aFn().C(262152, true);
    }
    label1726:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.CardMsgManager", "has card new msg, return");
        label1740:
        if ((((g)localObject1).field_msg_type & 0x1) != 0)
        {
          if (localk.aqT(((g)localObject1).field_msg_id)) {
            break label2653;
          }
          localk.tnP.add(localObject1);
          k.c((g)localObject1);
          if ((((g)localObject1).field_msg_type & 0x80) != 0) {
            localk.tnQ += 1;
          }
        }
      }
      for (;;)
      {
        h.aHG().aHp().i(139268, Integer.valueOf(localk.tnQ));
        localk.a((g)localObject1);
        if ((((g)localObject1).field_msg_type & 0x2) != 0)
        {
          am.cHr();
          b.HG(((g)localObject1).tpF);
        }
        if ((((g)localObject1).field_msg_type & 0x4) != 0) {
          localk.onChange();
        }
        if ((((g)localObject1).field_msg_type & 0x8) != 0) {
          am.cHy().K(((g)localObject1).field_card_id, ((g)localObject1).field_card_tp_id, ((g)localObject1).field_report_scene);
        }
        if ((((g)localObject1).field_msg_type & 0x400) != 0)
        {
          ((g)localObject1).cHn();
          am.cHI().b((g)localObject1);
        }
        if (((((g)localObject1).field_msg_type & 0x1000) != 0) && (((g)localObject1).field_need_pull_card_entrance))
        {
          localObject1 = e.trs;
          e.a.cHR();
        }
        com.tencent.mm.plugin.card.d.l.cLg();
        AppMethodBeat.o(112877);
        return;
        Log.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
        break;
        if ((((g)localObject1).field_msg_type & 0x4000) == 0) {
          break label2717;
        }
        c.aFn().C(262152, true);
        if ((((g)localObject1).field_msg_type & 0x10000) != 0) {
          break label1726;
        }
        c.aFn().dl(262152, 266241);
        break label1726;
        Log.i("MicroMsg.CardMsgManager", "not has new!");
        int j;
        if ((((g)localObject1).field_msg_type & 0x20) != 0)
        {
          c.aFn().D(262152, true);
          Log.i("MicroMsg.CardMsgManager", "has reddot");
          i = 1;
          if (TextUtils.isEmpty(((g)localObject1).tpv)) {
            break label2397;
          }
          Log.i("MicroMsg.CardMsgManager", "reddot_wording is " + ((g)localObject1).tpv);
          h.aHG().aHp().set(ar.a.VhT, ((g)localObject1).tpv);
          c.aFn().a(ar.a.VhN, true);
          j = 1;
          label2128:
          Log.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + ((g)localObject1).tpx);
          if (TextUtils.isEmpty(((g)localObject1).tpx)) {
            break label2410;
          }
          h.aHG().aHp().set(ar.a.VhW, ((g)localObject1).tpx);
          c.aFn().a(ar.a.VhO, true);
          if ((i == 0) || (j == 0) || (k == 0))
          {
            if ((i == 0) || (j == 0) || (k != 0)) {
              break label2423;
            }
            c.aFn().a(ar.a.VhO, false);
            h.aHG().aHp().set(ar.a.VhW, "");
          }
        }
        for (;;)
        {
          if ((i == 0) && (j == 0) && (k == 0)) {
            break label2651;
          }
          h.aHG().aHp().set(ar.a.Vik, ((g)localObject1).field_card_id);
          h.aHG().aHp().set(ar.a.Vil, Boolean.valueOf(((g)localObject1).tpA));
          Log.i("MicroMsg.CardMsgManager", "card_id:" + ((g)localObject1).field_card_id + "  need_check:" + ((g)localObject1).tpA);
          break;
          if ((((g)localObject1).field_msg_type & 0x2000) != 0)
          {
            c.aFn().D(262152, true);
            if ((((g)localObject1).field_msg_type & 0x10000) == 0) {
              c.aFn().dl(262152, 266241);
            }
            i = 1;
            break label2062;
          }
          Log.e("MicroMsg.CardMsgManager", "not has reddot!");
          i = 0;
          break label2062;
          label2397:
          Log.e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
          j = 0;
          break label2128;
          label2410:
          Log.e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
          k = 0;
          break label2192;
          label2423:
          if ((i != 0) && (j == 0) && (k != 0))
          {
            c.aFn().a(ar.a.VhN, false);
            h.aHG().aHp().set(ar.a.VhT, "");
          }
          else if ((i == 0) && (j != 0) && (k != 0))
          {
            c.aFn().D(262152, false);
          }
          else if ((i != 0) && (j == 0) && (k == 0))
          {
            c.aFn().a(ar.a.VhO, false);
            h.aHG().aHp().set(ar.a.VhW, "");
            c.aFn().a(ar.a.VhN, false);
            h.aHG().aHp().set(ar.a.VhT, "");
          }
          else if ((i == 0) && (j != 0) && (k == 0))
          {
            c.aFn().a(ar.a.VhO, false);
            h.aHG().aHp().set(ar.a.VhW, "");
            c.aFn().D(262152, false);
          }
          else if ((i == 0) && (j == 0) && (k != 0))
          {
            c.aFn().a(ar.a.VhN, false);
            h.aHG().aHp().set(ar.a.VhT, "");
            c.aFn().D(262152, false);
          }
        }
        label2651:
        break label1740;
        label2653:
        Log.e("MicroMsg.CardMsgManager", "msg for id " + ((g)localObject1).field_msg_id + " is exist!!");
        localk.aqU(((g)localObject1).field_msg_id);
        localk.tnP.add(localObject1);
        k.c((g)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.6.1
 * JD-Core Version:    0.7.0.1
 */