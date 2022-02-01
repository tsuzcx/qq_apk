package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.a.e.a;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.z.a;
import com.tencent.mm.z.c;
import java.util.List;
import java.util.Map;

final class am$6$1
  implements Runnable
{
  am$6$1(am.6 param6, String paramString, f.a parama) {}
  
  public final void run()
  {
    int k = 1;
    AppMethodBeat.i(112877);
    k localk = am.bIZ();
    Object localObject1 = this.iOr;
    String str1 = this.gLP.fTo.uKZ;
    ad.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is ".concat(String.valueOf(str1)));
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = bw.K((String)localObject1, "sysmsg");
      if (localObject2 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          ad.e("MicroMsg.CardMsgManager", "card msg == null");
          AppMethodBeat.o(112877);
          return;
          localObject1 = new g();
          Object localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.card_type");
          label151:
          label361:
          String str2;
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3)))
          {
            ((g)localObject1).field_card_type = bt.getInt((String)localObject3, 0);
            ((g)localObject1).field_title = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.title"));
            ((g)localObject1).field_description = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.description"));
            ((g)localObject1).field_logo_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_url"));
            ((g)localObject1).field_logo_color = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_color"));
            localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.time");
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
              break label1176;
            }
            if (bt.getLong((String)localObject3, 0L) < 2147483647L) {
              break label1162;
            }
            ((g)localObject1).field_time = 2147483647;
            label269:
            ((g)localObject1).field_card_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.card_id"));
            ((g)localObject1).field_card_tp_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.card_tp_id"));
            ((g)localObject1).field_msg_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_id"));
            localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_type");
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
              break label1192;
            }
            ((g)localObject1).field_msg_type = bt.getInt((String)localObject3, 0);
            localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.jump_type");
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
              break label1201;
            }
            ((g)localObject1).field_jump_type = bt.getInt((String)localObject3, 0);
            label402:
            ((g)localObject1).field_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.url"));
            str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.text");
            if (!TextUtils.isEmpty(str2))
            {
              localObject3 = new qm();
              ((qm)localObject3).text = str2;
              ((qm)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.button.url"));
              str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.action_type");
              if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                break label1210;
              }
              ((qm)localObject3).ntg = bt.getInt(str2, 0);
              label515:
              ((g)localObject1).nsX = ((qm)localObject3);
            }
          }
          try
          {
            ((g)localObject1).field_buttonData = ((g)localObject1).nsX.toByteArray();
            str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.text");
            if (!TextUtils.isEmpty(str2))
            {
              localObject3 = new rd();
              ((rd)localObject3).text = str2;
              ((rd)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.url"));
              str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.type");
              if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                break label1260;
              }
              ((rd)localObject3).type = bt.getInt(str2, 0);
              str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.endtime");
              if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                break label1283;
              }
              if (Long.valueOf(str2).longValue() < 2147483647L) {
                break label1269;
              }
              ((rd)localObject3).wmA = 2147483647;
              ((g)localObject1).nsY = ((rd)localObject3);
            }
          }
          catch (Exception localException1)
          {
            try
            {
              for (;;)
              {
                ((g)localObject1).field_operData = ((g)localObject1).nsY.toByteArray();
                localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.report_scene");
                if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                  break label1340;
                }
                ((g)localObject1).field_report_scene = bt.getInt((String)localObject3, 0);
                ((g)localObject1).field_read_state = 1;
                ((g)localObject1).field_accept_buttons = k.g((Map)localObject2, ".sysmsg.carditemmsg");
                ((g)localObject1).field_jump_buttons = k.f((Map)localObject2, ".sysmsg.carditemmsg");
                localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.get_layout_scene");
                if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                  break label1349;
                }
                ((g)localObject1).ntb = bt.getInt((String)localObject3, 0);
                ((g)localObject1).field_consumed_box_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.consumed_box_id"));
                ((g)localObject1).nsR = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_wording"));
                ((g)localObject1).nsS = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_buff"));
                ((g)localObject1).nsT = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_icon_url"));
                ((g)localObject1).nsU = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.title"));
                ((g)localObject1).nsV = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.icon_url"));
                localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_scene");
                if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                  break label1358;
                }
                ((g)localObject1).ntc = bt.getInt((String)localObject3, 0);
                ad.i("MicroMsg.CardMsgManager", "msg_scene is ".concat(String.valueOf(localObject3)));
                localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.need_check");
                ad.i("MicroMsg.CardMsgManager", "need_check:".concat(String.valueOf(localObject3)));
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label1367;
                }
                ((g)localObject1).nsW = ((String)localObject3).equals("true");
                str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.all_unavailable");
                ad.i("MicroMsg.CardMsgManager", "all_Unavailable:".concat(String.valueOf(localObject3)));
                if (TextUtils.isEmpty(str2)) {
                  break label1376;
                }
                ((g)localObject1).ntd = str2.equals("true");
                ((g)localObject1).field_unavailable_qr_code_list = k.h((Map)localObject2, ".sysmsg.carditemmsg");
                if ((!"true".equals(((Map)localObject2).get(".sysmsg.carditemmsg.need_pull_card_entrance"))) && (!"1".equals(((Map)localObject2).get(".sysmsg.carditemmsg.need_pull_card_entrance")))) {
                  break label1385;
                }
                bool = true;
                ((g)localObject1).field_need_pull_card_entrance = bool;
                break;
                ((g)localObject1).field_card_type = 0;
                break label151;
                label1162:
                ((g)localObject1).field_time = bt.getInt((String)localObject3, 0);
                break label269;
                label1176:
                ((g)localObject1).field_time = ((int)(System.currentTimeMillis() / 1000L));
                break label269;
                label1192:
                ((g)localObject1).field_msg_type = 0;
                break label361;
                label1201:
                ((g)localObject1).field_jump_type = 1;
                break label402;
                label1210:
                ((qm)localObject3).ntg = 0;
                break label515;
                localException1 = localException1;
                ad.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[] { localException1.getMessage() });
                ad.printErrStackTrace("MicroMsg.CardMsgInfo", localException1, "", new Object[0]);
                continue;
                label1260:
                localException1.type = 0;
                continue;
                label1269:
                localException1.wmA = bt.getInt(str2, 0);
              }
              label1283:
              localException1.wmA = ((int)(System.currentTimeMillis() / 1000L));
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                ad.e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", new Object[] { localException2.getMessage() });
                ad.printErrStackTrace("MicroMsg.CardMsgInfo", localException2, "", new Object[0]);
                continue;
                label1340:
                ((g)localObject1).field_report_scene = 2;
                continue;
                label1349:
                ((g)localObject1).ntb = 0;
                continue;
                label1358:
                ((g)localObject1).ntc = 0;
                continue;
                label1367:
                ((g)localObject1).nsW = false;
                continue;
                label1376:
                ((g)localObject1).ntd = false;
                continue;
                label1385:
                boolean bool = false;
              }
            }
          }
        }
      }
      if (TextUtils.isEmpty(((g)localObject1).field_card_id)) {
        ad.e("MicroMsg.CardMsgManager", "card id == null");
      }
      localObject2 = ((g)localObject1).field_msg_id;
      ((g)localObject1).field_msg_id = str1;
      if (TextUtils.isEmpty(((g)localObject1).field_msg_id)) {
        ((g)localObject1).field_msg_id = ((String)localObject2);
      }
      if (TextUtils.isEmpty(((g)localObject1).field_msg_id)) {
        ((g)localObject1).field_msg_id = System.currentTimeMillis();
      }
      ad.i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + ((g)localObject1).field_msg_id);
      ad.i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + ((g)localObject1).field_msg_type);
      if (((g)localObject1).ntb != 0) {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhu, Integer.valueOf(((g)localObject1).ntb));
      }
      ad.i("MicroMsg.CardMsgManager", "reddot_buff is " + ((g)localObject1).nsS);
      if (TextUtils.isEmpty(((g)localObject1).nsS)) {
        break label1962;
      }
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhq, ((g)localObject1).nsS);
      if ((((g)localObject1).field_msg_type & 0x1) != 0)
      {
        ad.i("MicroMsg.CardMsgManager", "msg_tips_title is " + ((g)localObject1).nsU);
        ad.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + ((g)localObject1).nsV);
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhs, ((g)localObject1).nsU);
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fht, ((g)localObject1).nsV);
      }
      if ((((g)localObject1).field_msg_type & 0x40) == 0) {
        break label1973;
      }
      c.adr().w(262152, true);
    }
    label1725:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ad.i("MicroMsg.CardMsgManager", "has card new msg, return");
        label1739:
        if ((((g)localObject1).field_msg_type & 0x1) != 0)
        {
          if (localk.Qp(((g)localObject1).field_msg_id)) {
            break label2652;
          }
          localk.nrj.add(localObject1);
          k.c((g)localObject1);
          if ((((g)localObject1).field_msg_type & 0x80) != 0) {
            localk.nrk += 1;
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.afB().afk().set(139268, Integer.valueOf(localk.nrk));
        localk.a((g)localObject1);
        if ((((g)localObject1).field_msg_type & 0x2) != 0)
        {
          am.bIU();
          b.yP(((g)localObject1).ntb);
        }
        if ((((g)localObject1).field_msg_type & 0x4) != 0) {
          localk.onChange();
        }
        if ((((g)localObject1).field_msg_type & 0x8) != 0) {
          am.bJb().F(((g)localObject1).field_card_id, ((g)localObject1).field_card_tp_id, ((g)localObject1).field_report_scene);
        }
        if ((((g)localObject1).field_msg_type & 0x400) != 0)
        {
          ((g)localObject1).bIQ();
          am.bJl().b((g)localObject1);
        }
        if (((((g)localObject1).field_msg_type & 0x1000) != 0) && (((g)localObject1).field_need_pull_card_entrance))
        {
          localObject1 = com.tencent.mm.plugin.card.model.a.e.nuM;
          e.a.bJr();
        }
        com.tencent.mm.plugin.card.d.l.bMK();
        AppMethodBeat.o(112877);
        return;
        ad.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
        break;
        if ((((g)localObject1).field_msg_type & 0x4000) == 0) {
          break label2716;
        }
        c.adr().w(262152, true);
        if ((((g)localObject1).field_msg_type & 0x10000) != 0) {
          break label1725;
        }
        c.adr().cK(262152, 266241);
        break label1725;
        ad.i("MicroMsg.CardMsgManager", "not has new!");
        int j;
        if ((((g)localObject1).field_msg_type & 0x20) != 0)
        {
          c.adr().x(262152, true);
          ad.i("MicroMsg.CardMsgManager", "has reddot");
          i = 1;
          if (TextUtils.isEmpty(((g)localObject1).nsR)) {
            break label2396;
          }
          ad.i("MicroMsg.CardMsgManager", "reddot_wording is " + ((g)localObject1).nsR);
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fho, ((g)localObject1).nsR);
          c.adr().a(ae.a.Fhi, true);
          j = 1;
          label2127:
          ad.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + ((g)localObject1).nsT);
          if (TextUtils.isEmpty(((g)localObject1).nsT)) {
            break label2409;
          }
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhr, ((g)localObject1).nsT);
          c.adr().a(ae.a.Fhj, true);
          if ((i == 0) || (j == 0) || (k == 0))
          {
            if ((i == 0) || (j == 0) || (k != 0)) {
              break label2422;
            }
            c.adr().a(ae.a.Fhj, false);
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhr, "");
          }
        }
        for (;;)
        {
          if ((i == 0) && (j == 0) && (k == 0)) {
            break label2650;
          }
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FhF, ((g)localObject1).field_card_id);
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FhG, Boolean.valueOf(((g)localObject1).nsW));
          ad.i("MicroMsg.CardMsgManager", "card_id:" + ((g)localObject1).field_card_id + "  need_check:" + ((g)localObject1).nsW);
          break;
          if ((((g)localObject1).field_msg_type & 0x2000) != 0)
          {
            c.adr().x(262152, true);
            if ((((g)localObject1).field_msg_type & 0x10000) == 0) {
              c.adr().cK(262152, 266241);
            }
            i = 1;
            break label2061;
          }
          ad.e("MicroMsg.CardMsgManager", "not has reddot!");
          i = 0;
          break label2061;
          label2396:
          ad.e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
          j = 0;
          break label2127;
          label2409:
          ad.e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
          k = 0;
          break label2191;
          label2422:
          if ((i != 0) && (j == 0) && (k != 0))
          {
            c.adr().a(ae.a.Fhi, false);
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fho, "");
          }
          else if ((i == 0) && (j != 0) && (k != 0))
          {
            c.adr().x(262152, false);
          }
          else if ((i != 0) && (j == 0) && (k == 0))
          {
            c.adr().a(ae.a.Fhj, false);
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhr, "");
            c.adr().a(ae.a.Fhi, false);
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fho, "");
          }
          else if ((i == 0) && (j != 0) && (k == 0))
          {
            c.adr().a(ae.a.Fhj, false);
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhr, "");
            c.adr().x(262152, false);
          }
          else if ((i == 0) && (j == 0) && (k != 0))
          {
            c.adr().a(ae.a.Fhi, false);
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fho, "");
            c.adr().x(262152, false);
          }
        }
        label2650:
        break label1739;
        label2652:
        ad.e("MicroMsg.CardMsgManager", "msg for id " + ((g)localObject1).field_msg_id + " is exist!!");
        localk.Qq(((g)localObject1).field_msg_id);
        localk.nrj.add(localObject1);
        k.c((g)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.6.1
 * JD-Core Version:    0.7.0.1
 */