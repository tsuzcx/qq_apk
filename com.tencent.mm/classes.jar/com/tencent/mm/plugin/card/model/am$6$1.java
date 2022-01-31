package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.a.f;
import com.tencent.mm.plugin.card.model.a.f.a;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.a;
import com.tencent.mm.x.c;
import java.util.List;
import java.util.Map;

final class am$6$1
  implements Runnable
{
  am$6$1(am.6 param6, String paramString, e.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(87938);
    k localk = am.bch();
    Object localObject1 = this.gWF;
    String str1 = this.fkG.eyJ.pIG;
    ab.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is ".concat(String.valueOf(str1)));
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = br.F((String)localObject1, "sysmsg");
      if (localObject2 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          ab.e("MicroMsg.CardMsgManager", "card msg == null");
          AppMethodBeat.o(87938);
          return;
          localObject1 = new g();
          Object localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.card_type");
          label151:
          label365:
          String str2;
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3)))
          {
            ((g)localObject1).field_card_type = Integer.valueOf((String)localObject3).intValue();
            ((g)localObject1).field_title = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.title"));
            ((g)localObject1).field_description = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.description"));
            ((g)localObject1).field_logo_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_url"));
            ((g)localObject1).field_logo_color = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_color"));
            localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.time");
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
              break label1194;
            }
            if (Long.valueOf((String)localObject3).longValue() < 2147483647L) {
              break label1178;
            }
            ((g)localObject1).field_time = 2147483647;
            label271:
            ((g)localObject1).field_card_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.card_id"));
            ((g)localObject1).field_card_tp_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.card_tp_id"));
            ((g)localObject1).field_msg_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_id"));
            localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_type");
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
              break label1210;
            }
            ((g)localObject1).field_msg_type = Integer.valueOf((String)localObject3).intValue();
            localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.jump_type");
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
              break label1219;
            }
            ((g)localObject1).field_jump_type = Integer.valueOf((String)localObject3).intValue();
            label408:
            ((g)localObject1).field_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.url"));
            str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.text");
            if (!TextUtils.isEmpty(str2))
            {
              localObject3 = new oh();
              ((oh)localObject3).text = str2;
              ((oh)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.button.url"));
              str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.action_type");
              if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                break label1228;
              }
              ((oh)localObject3).knS = Integer.valueOf(str2).intValue();
              label523:
              ((g)localObject1).knJ = ((oh)localObject3);
            }
          }
          try
          {
            ((g)localObject1).field_buttonData = ((g)localObject1).knJ.toByteArray();
            str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.text");
            if (!TextUtils.isEmpty(str2))
            {
              localObject3 = new ov();
              ((ov)localObject3).text = str2;
              ((ov)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.url"));
              str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.type");
              if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                break label1278;
              }
              ((ov)localObject3).type = Integer.valueOf(str2).intValue();
              str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.endtime");
              if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                break label1303;
              }
              if (Long.valueOf(str2).longValue() < 2147483647L) {
                break label1287;
              }
              ((ov)localObject3).qNK = 2147483647;
              ((g)localObject1).knK = ((ov)localObject3);
            }
          }
          catch (Exception localException1)
          {
            try
            {
              for (;;)
              {
                ((g)localObject1).field_operData = ((g)localObject1).knK.toByteArray();
                localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.report_scene");
                if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                  break label1360;
                }
                ((g)localObject1).field_report_scene = Integer.valueOf((String)localObject3).intValue();
                ((g)localObject1).field_read_state = 1;
                ((g)localObject1).field_accept_buttons = k.i((Map)localObject2, ".sysmsg.carditemmsg");
                ((g)localObject1).field_jump_buttons = k.h((Map)localObject2, ".sysmsg.carditemmsg");
                localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.get_layout_scene");
                if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                  break label1369;
                }
                ((g)localObject1).knN = Integer.valueOf((String)localObject3).intValue();
                ((g)localObject1).field_consumed_box_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.consumed_box_id"));
                ((g)localObject1).knD = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_wording"));
                ((g)localObject1).knE = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_buff"));
                ((g)localObject1).knF = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_icon_url"));
                ((g)localObject1).knG = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.title"));
                ((g)localObject1).knH = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.icon_url"));
                localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_scene");
                if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                  break label1378;
                }
                ((g)localObject1).knO = Integer.valueOf((String)localObject3).intValue();
                ab.i("MicroMsg.CardMsgManager", "msg_scene is ".concat(String.valueOf(localObject3)));
                localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.need_check");
                ab.i("MicroMsg.CardMsgManager", "need_check:".concat(String.valueOf(localObject3)));
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label1387;
                }
                ((g)localObject1).knI = ((String)localObject3).equals("true");
                str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.all_unavailable");
                ab.i("MicroMsg.CardMsgManager", "all_Unavailable:".concat(String.valueOf(localObject3)));
                if (TextUtils.isEmpty(str2)) {
                  break label1396;
                }
                ((g)localObject1).knP = str2.equals("true");
                ((g)localObject1).field_unavailable_qr_code_list = k.j((Map)localObject2, ".sysmsg.carditemmsg");
                if ((!"true".equals(((Map)localObject2).get(".sysmsg.carditemmsg.need_pull_card_entrance"))) && (!"1".equals(((Map)localObject2).get(".sysmsg.carditemmsg.need_pull_card_entrance")))) {
                  break label1405;
                }
                bool = true;
                ((g)localObject1).field_need_pull_card_entrance = bool;
                break;
                ((g)localObject1).field_card_type = 0;
                break label151;
                label1178:
                ((g)localObject1).field_time = Integer.valueOf((String)localObject3).intValue();
                break label271;
                label1194:
                ((g)localObject1).field_time = ((int)(System.currentTimeMillis() / 1000L));
                break label271;
                label1210:
                ((g)localObject1).field_msg_type = 0;
                break label365;
                label1219:
                ((g)localObject1).field_jump_type = 1;
                break label408;
                label1228:
                ((oh)localObject3).knS = 0;
                break label523;
                localException1 = localException1;
                ab.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[] { localException1.getMessage() });
                ab.printErrStackTrace("MicroMsg.CardMsgInfo", localException1, "", new Object[0]);
                continue;
                label1278:
                localException1.type = 0;
                continue;
                label1287:
                localException1.qNK = Integer.valueOf(str2).intValue();
              }
              label1303:
              localException1.qNK = ((int)(System.currentTimeMillis() / 1000L));
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                ab.e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", new Object[] { localException2.getMessage() });
                ab.printErrStackTrace("MicroMsg.CardMsgInfo", localException2, "", new Object[0]);
                continue;
                label1360:
                ((g)localObject1).field_report_scene = 2;
                continue;
                label1369:
                ((g)localObject1).knN = 0;
                continue;
                label1378:
                ((g)localObject1).knO = 0;
                continue;
                label1387:
                ((g)localObject1).knI = false;
                continue;
                label1396:
                ((g)localObject1).knP = false;
                continue;
                label1405:
                boolean bool = false;
              }
            }
          }
        }
      }
      if (TextUtils.isEmpty(((g)localObject1).field_card_id)) {
        ab.e("MicroMsg.CardMsgManager", "card id == null");
      }
      localObject2 = ((g)localObject1).field_msg_id;
      ((g)localObject1).field_msg_id = str1;
      if (TextUtils.isEmpty(((g)localObject1).field_msg_id)) {
        ((g)localObject1).field_msg_id = ((String)localObject2);
      }
      if (TextUtils.isEmpty(((g)localObject1).field_msg_id)) {
        ((g)localObject1).field_msg_id = System.currentTimeMillis();
      }
      ab.i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + ((g)localObject1).field_msg_id);
      ab.i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + ((g)localObject1).field_msg_type);
      if (((g)localObject1).knN != 0) {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyZ, Integer.valueOf(((g)localObject1).knN));
      }
      ab.i("MicroMsg.CardMsgManager", "reddot_buff is " + ((g)localObject1).knE);
      if (TextUtils.isEmpty(((g)localObject1).knE)) {
        break label1983;
      }
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyV, ((g)localObject1).knE);
      if ((((g)localObject1).field_msg_type & 0x1) != 0)
      {
        ab.i("MicroMsg.CardMsgManager", "msg_tips_title is " + ((g)localObject1).knG);
        ab.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + ((g)localObject1).knH);
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyX, ((g)localObject1).knG);
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyY, ((g)localObject1).knH);
      }
      if ((((g)localObject1).field_msg_type & 0x40) == 0) {
        break label1994;
      }
      c.PJ().x(262152, true);
    }
    label1745:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ab.i("MicroMsg.CardMsgManager", "has card new msg, return");
        label1759:
        if ((((g)localObject1).field_msg_type & 0x1) != 0)
        {
          if (localk.HF(((g)localObject1).field_msg_id)) {
            break label2675;
          }
          localk.kmd.add(localObject1);
          k.c((g)localObject1);
          if ((((g)localObject1).field_msg_type & 0x80) != 0) {
            localk.kme += 1;
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.RL().Ru().set(139268, Integer.valueOf(localk.kme));
        localk.a((g)localObject1);
        if ((((g)localObject1).field_msg_type & 0x2) != 0)
        {
          am.bcc();
          b.sW(((g)localObject1).knN);
        }
        if ((((g)localObject1).field_msg_type & 0x4) != 0) {
          localk.onChange();
        }
        if ((((g)localObject1).field_msg_type & 0x8) != 0) {
          am.bcj().w(((g)localObject1).field_card_id, ((g)localObject1).field_card_tp_id, ((g)localObject1).field_report_scene);
        }
        if ((((g)localObject1).field_msg_type & 0x400) != 0)
        {
          ((g)localObject1).bbY();
          am.bct().b((g)localObject1);
        }
        if (((((g)localObject1).field_msg_type & 0x1000) != 0) && (((g)localObject1).field_need_pull_card_entrance))
        {
          localObject1 = f.kpw;
          f.a.fW(true);
        }
        com.tencent.mm.plugin.card.d.l.bfz();
        AppMethodBeat.o(87938);
        return;
        ab.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
        break;
        if ((((g)localObject1).field_msg_type & 0x4000) == 0) {
          break label2739;
        }
        c.PJ().x(262152, true);
        if ((((g)localObject1).field_msg_type & 0x10000) != 0) {
          break label1745;
        }
        c.PJ().ce(262152, 266241);
        break label1745;
        ab.i("MicroMsg.CardMsgManager", "not has new!");
        int j;
        label2148:
        int k;
        if ((((g)localObject1).field_msg_type & 0x20) != 0)
        {
          c.PJ().y(262152, true);
          ab.i("MicroMsg.CardMsgManager", "has reddot");
          i = 1;
          if (TextUtils.isEmpty(((g)localObject1).knD)) {
            break label2419;
          }
          ab.i("MicroMsg.CardMsgManager", "reddot_wording is " + ((g)localObject1).knD);
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyT, ((g)localObject1).knD);
          c.PJ().a(ac.a.yyN, true);
          j = 1;
          ab.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + ((g)localObject1).knF);
          if (TextUtils.isEmpty(((g)localObject1).knF)) {
            break label2432;
          }
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyW, ((g)localObject1).knF);
          c.PJ().a(ac.a.yyO, true);
          k = 1;
          if ((i == 0) || (j == 0) || (k == 0))
          {
            if ((i == 0) || (j == 0) || (k != 0)) {
              break label2445;
            }
            c.PJ().a(ac.a.yyO, false);
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyW, "");
          }
        }
        for (;;)
        {
          if ((i == 0) && (j == 0) && (k == 0)) {
            break label2673;
          }
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yzk, ((g)localObject1).field_card_id);
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yzl, Boolean.valueOf(((g)localObject1).knI));
          ab.i("MicroMsg.CardMsgManager", "card_id:" + ((g)localObject1).field_card_id + "  need_check:" + ((g)localObject1).knI);
          break;
          if ((((g)localObject1).field_msg_type & 0x2000) != 0)
          {
            c.PJ().y(262152, true);
            if ((((g)localObject1).field_msg_type & 0x10000) == 0) {
              c.PJ().ce(262152, 266241);
            }
            i = 1;
            break label2082;
          }
          ab.e("MicroMsg.CardMsgManager", "not has reddot!");
          i = 0;
          break label2082;
          label2419:
          ab.e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
          j = 0;
          break label2148;
          ab.e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
          k = 0;
          break label2214;
          if ((i != 0) && (j == 0) && (k != 0))
          {
            c.PJ().a(ac.a.yyN, false);
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyT, "");
          }
          else if ((i == 0) && (j != 0) && (k != 0))
          {
            c.PJ().y(262152, false);
          }
          else if ((i != 0) && (j == 0) && (k == 0))
          {
            c.PJ().a(ac.a.yyO, false);
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyW, "");
            c.PJ().a(ac.a.yyN, false);
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyT, "");
          }
          else if ((i == 0) && (j != 0) && (k == 0))
          {
            c.PJ().a(ac.a.yyO, false);
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyW, "");
            c.PJ().y(262152, false);
          }
          else if ((i == 0) && (j == 0) && (k != 0))
          {
            c.PJ().a(ac.a.yyN, false);
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyT, "");
            c.PJ().y(262152, false);
          }
        }
        label2673:
        break label1759;
        label2675:
        ab.e("MicroMsg.CardMsgManager", "msg for id " + ((g)localObject1).field_msg_id + " is exist!!");
        localk.HG(((g)localObject1).field_msg_id);
        localk.kmd.add(localObject1);
        k.c((g)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.6.1
 * JD-Core Version:    0.7.0.1
 */