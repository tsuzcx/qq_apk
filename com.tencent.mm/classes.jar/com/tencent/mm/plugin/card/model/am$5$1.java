package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.ly;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.a;
import com.tencent.mm.y.c;
import java.util.List;
import java.util.Map;

final class am$5$1
  implements Runnable
{
  am$5$1(am.5 param5, String paramString, e.a parama) {}
  
  public final void run()
  {
    k localk = am.aAw();
    Object localObject1 = this.fEp;
    String str1 = this.dUx.dBs.ndp;
    y.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is " + str1);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = bn.s((String)localObject1, "sysmsg");
      if (localObject2 != null) {
        break label96;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        y.e("MicroMsg.CardMsgManager", "card msg == null");
        return;
        label96:
        localObject1 = new g();
        Object localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.card_type");
        label148:
        label362:
        String str2;
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (com.tencent.mm.plugin.card.d.l.yS((String)localObject3)))
        {
          ((g)localObject1).field_card_type = Integer.valueOf((String)localObject3).intValue();
          ((g)localObject1).field_title = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.title"));
          ((g)localObject1).field_description = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.description"));
          ((g)localObject1).field_logo_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_url"));
          ((g)localObject1).field_logo_color = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_color"));
          localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.time");
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.yS((String)localObject3))) {
            break label1163;
          }
          if (Long.valueOf((String)localObject3).longValue() < 2147483647L) {
            break label1147;
          }
          ((g)localObject1).field_time = 2147483647;
          label268:
          ((g)localObject1).field_card_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.card_id"));
          ((g)localObject1).field_card_tp_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.card_tp_id"));
          ((g)localObject1).field_msg_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_id"));
          localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_type");
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.yS((String)localObject3))) {
            break label1179;
          }
          ((g)localObject1).field_msg_type = Integer.valueOf((String)localObject3).intValue();
          localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.jump_type");
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.yS((String)localObject3))) {
            break label1188;
          }
          ((g)localObject1).field_jump_type = Integer.valueOf((String)localObject3).intValue();
          label405:
          ((g)localObject1).field_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.url"));
          str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.text");
          if (!TextUtils.isEmpty(str2))
          {
            localObject3 = new lt();
            ((lt)localObject3).text = str2;
            ((lt)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.button.url"));
            str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.action_type");
            if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.yS(str2))) {
              break label1197;
            }
            ((lt)localObject3).imX = Integer.valueOf(str2).intValue();
            label520:
            ((g)localObject1).imN = ((lt)localObject3);
          }
        }
        try
        {
          ((g)localObject1).field_buttonData = ((g)localObject1).imN.toByteArray();
          str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.text");
          if (!TextUtils.isEmpty(str2))
          {
            localObject3 = new ly();
            ((ly)localObject3).text = str2;
            ((ly)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.url"));
            str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.type");
            if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.yS(str2))) {
              break label1247;
            }
            ((ly)localObject3).type = Integer.valueOf(str2).intValue();
            str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.endtime");
            if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.yS(str2))) {
              break label1272;
            }
            if (Long.valueOf(str2).longValue() < 2147483647L) {
              break label1256;
            }
            ((ly)localObject3).nZA = 2147483647;
            ((g)localObject1).imO = ((ly)localObject3);
          }
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              ((g)localObject1).field_operData = ((g)localObject1).imO.toByteArray();
              localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.report_scene");
              if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.yS((String)localObject3))) {
                break label1329;
              }
              ((g)localObject1).field_report_scene = Integer.valueOf((String)localObject3).intValue();
              ((g)localObject1).field_read_state = 1;
              ((g)localObject1).field_accept_buttons = k.i((Map)localObject2, ".sysmsg.carditemmsg");
              ((g)localObject1).field_jump_buttons = k.h((Map)localObject2, ".sysmsg.carditemmsg");
              localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.get_layout_scene");
              if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.yS((String)localObject3))) {
                break label1338;
              }
              ((g)localObject1).imR = Integer.valueOf((String)localObject3).intValue();
              ((g)localObject1).field_consumed_box_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.consumed_box_id"));
              ((g)localObject1).imH = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_wording"));
              ((g)localObject1).imI = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_buff"));
              ((g)localObject1).imJ = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_icon_url"));
              ((g)localObject1).imK = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.title"));
              ((g)localObject1).imL = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.icon_url"));
              localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_scene");
              if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.yS((String)localObject3))) {
                break label1347;
              }
              ((g)localObject1).imS = Integer.valueOf((String)localObject3).intValue();
              y.i("MicroMsg.CardMsgManager", "msg_scene is " + (String)localObject3);
              localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.need_check");
              y.i("MicroMsg.CardMsgManager", "need_check:" + (String)localObject3);
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label1356;
              }
              ((g)localObject1).imM = ((String)localObject3).equals("true");
              str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.all_unavailable");
              y.i("MicroMsg.CardMsgManager", "all_Unavailable:" + (String)localObject3);
              if (TextUtils.isEmpty(str2)) {
                break label1365;
              }
              ((g)localObject1).imT = str2.equals("true");
              ((g)localObject1).field_unavailable_qr_code_list = k.j((Map)localObject2, ".sysmsg.carditemmsg");
              break;
              ((g)localObject1).field_card_type = 0;
              break label148;
              label1147:
              ((g)localObject1).field_time = Integer.valueOf((String)localObject3).intValue();
              break label268;
              label1163:
              ((g)localObject1).field_time = ((int)(System.currentTimeMillis() / 1000L));
              break label268;
              label1179:
              ((g)localObject1).field_msg_type = 0;
              break label362;
              label1188:
              ((g)localObject1).field_jump_type = 1;
              break label405;
              label1197:
              ((lt)localObject3).imX = 0;
              break label520;
              localException1 = localException1;
              y.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[] { localException1.getMessage() });
              y.printErrStackTrace("MicroMsg.CardMsgInfo", localException1, "", new Object[0]);
              continue;
              label1247:
              localException1.type = 0;
              continue;
              label1256:
              localException1.nZA = Integer.valueOf(str2).intValue();
            }
            label1272:
            localException1.nZA = ((int)(System.currentTimeMillis() / 1000L));
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              y.e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", new Object[] { localException2.getMessage() });
              y.printErrStackTrace("MicroMsg.CardMsgInfo", localException2, "", new Object[0]);
              continue;
              label1329:
              ((g)localObject1).field_report_scene = 2;
              continue;
              label1338:
              ((g)localObject1).imR = 0;
              continue;
              label1347:
              ((g)localObject1).imS = 0;
              continue;
              label1356:
              ((g)localObject1).imM = false;
              continue;
              label1365:
              ((g)localObject1).imT = false;
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty(((g)localObject1).field_card_id)) {
      y.e("MicroMsg.CardMsgManager", "card id == null");
    }
    Object localObject2 = ((g)localObject1).field_msg_id;
    ((g)localObject1).field_msg_id = str1;
    if (TextUtils.isEmpty(((g)localObject1).field_msg_id)) {
      ((g)localObject1).field_msg_id = ((String)localObject2);
    }
    if (TextUtils.isEmpty(((g)localObject1).field_msg_id)) {
      ((g)localObject1).field_msg_id = System.currentTimeMillis();
    }
    y.i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + ((g)localObject1).field_msg_id);
    y.i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + ((g)localObject1).field_msg_type);
    if (((g)localObject1).imR != 0) {
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upd, Integer.valueOf(((g)localObject1).imR));
    }
    y.i("MicroMsg.CardMsgManager", "reddot_buff is " + ((g)localObject1).imI);
    if (!TextUtils.isEmpty(((g)localObject1).imI))
    {
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uoZ, ((g)localObject1).imI);
      if ((((g)localObject1).field_msg_type & 0x1) != 0)
      {
        y.i("MicroMsg.CardMsgManager", "msg_tips_title is " + ((g)localObject1).imK);
        y.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + ((g)localObject1).imL);
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upb, ((g)localObject1).imK);
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upc, ((g)localObject1).imL);
      }
      boolean bool2 = c.BS().bb(262152, 266256);
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if ((((g)localObject1).field_msg_type & 0x40) != 0)
        {
          c.BS().v(262152, true);
          bool1 = true;
        }
      }
      if (!bool1) {
        break label1952;
      }
      y.i("MicroMsg.CardMsgManager", "has card new msg, return");
      label1751:
      if ((((g)localObject1).field_msg_type & 0x1) != 0)
      {
        if (localk.ye(((g)localObject1).field_msg_id)) {
          break label2533;
        }
        localk.ilf.add(localObject1);
        k.c((g)localObject1);
        if ((((g)localObject1).field_msg_type & 0x80) != 0) {
          localk.ilg += 1;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.DP().Dz().o(139268, Integer.valueOf(localk.ilg));
      localk.a((g)localObject1);
      if ((((g)localObject1).field_msg_type & 0x2) != 0)
      {
        am.aAr();
        b.oM(((g)localObject1).imR);
      }
      if ((((g)localObject1).field_msg_type & 0x4) != 0) {
        localk.axs();
      }
      if ((((g)localObject1).field_msg_type & 0x8) != 0) {
        am.aAy().r(((g)localObject1).field_card_id, ((g)localObject1).field_card_tp_id, ((g)localObject1).field_report_scene);
      }
      if ((((g)localObject1).field_msg_type & 0x400) != 0)
      {
        ((g)localObject1).aAm();
        am.aAI().b((g)localObject1);
      }
      com.tencent.mm.plugin.card.d.l.aDc();
      return;
      y.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
      break;
      label1952:
      y.i("MicroMsg.CardMsgManager", "not has new!");
      int i = 0;
      label1993:
      int j;
      label2061:
      int k;
      if ((((g)localObject1).field_msg_type & 0x20) != 0)
      {
        c.BS().w(262152, true);
        y.i("MicroMsg.CardMsgManager", "has reddot");
        i = 1;
        j = 0;
        if (TextUtils.isEmpty(((g)localObject1).imH)) {
          break label2281;
        }
        y.i("MicroMsg.CardMsgManager", "reddot_wording is " + ((g)localObject1).imH);
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uoX, ((g)localObject1).imH);
        c.BS().a(ac.a.uoR, true);
        j = 1;
        k = 0;
        y.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + ((g)localObject1).imJ);
        if (TextUtils.isEmpty(((g)localObject1).imJ)) {
          break label2292;
        }
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upa, ((g)localObject1).imJ);
        c.BS().a(ac.a.uoS, true);
        k = 1;
        label2129:
        if ((i == 0) || (j == 0) || (k == 0))
        {
          if ((i == 0) || (j == 0) || (k != 0)) {
            break label2303;
          }
          c.BS().a(ac.a.uoS, false);
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upa, "");
        }
      }
      for (;;)
      {
        if ((i == 0) && (j == 0) && (k == 0)) {
          break label2531;
        }
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upo, ((g)localObject1).field_card_id);
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upp, Boolean.valueOf(((g)localObject1).imM));
        y.i("MicroMsg.CardMsgManager", "card_id:" + ((g)localObject1).field_card_id + "  need_check:" + ((g)localObject1).imM);
        break;
        y.e("MicroMsg.CardMsgManager", "not has reddot!");
        break label1993;
        label2281:
        y.e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
        break label2061;
        label2292:
        y.e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
        break label2129;
        label2303:
        if ((i != 0) && (j == 0) && (k != 0))
        {
          c.BS().a(ac.a.uoR, false);
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uoX, "");
        }
        else if ((i == 0) && (j != 0) && (k != 0))
        {
          c.BS().w(262152, false);
        }
        else if ((i != 0) && (j == 0) && (k == 0))
        {
          c.BS().a(ac.a.uoS, false);
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upa, "");
          c.BS().a(ac.a.uoR, false);
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uoX, "");
        }
        else if ((i == 0) && (j != 0) && (k == 0))
        {
          c.BS().a(ac.a.uoS, false);
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upa, "");
          c.BS().w(262152, false);
        }
        else if ((i == 0) && (j == 0) && (k != 0))
        {
          c.BS().a(ac.a.uoR, false);
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uoX, "");
          c.BS().w(262152, false);
        }
      }
      label2531:
      break label1751;
      label2533:
      y.e("MicroMsg.CardMsgManager", "msg for id " + ((g)localObject1).field_msg_id + " is exist!!");
      localk.yf(((g)localObject1).field_msg_id);
      localk.ilf.add(localObject1);
      k.c((g)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.5.1
 * JD-Core Version:    0.7.0.1
 */