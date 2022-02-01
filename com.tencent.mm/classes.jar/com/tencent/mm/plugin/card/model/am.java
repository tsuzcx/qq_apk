package com.tencent.mm.plugin.card.model;

import android.app.Application;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.PluginCard;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.plugin.card.sharecard.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class am
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private aq mHandler;
  private com.tencent.mm.plugin.card.b.b oGU;
  private c oGV;
  private al oGW;
  private h oGX;
  private com.tencent.mm.plugin.card.b.m oGY;
  private com.tencent.mm.plugin.card.sharecard.a.a oGZ;
  private com.tencent.mm.plugin.card.sharecard.model.k oHa;
  private com.tencent.mm.plugin.card.sharecard.model.o oHb;
  private com.tencent.mm.plugin.card.sharecard.a.c oHc;
  private com.tencent.mm.plugin.card.b.k oHd;
  private com.tencent.mm.plugin.card.b.e oHe;
  private com.tencent.mm.plugin.card.b.l oHf;
  private com.tencent.mm.plugin.card.b.d oHg;
  private com.tencent.mm.plugin.card.b.j oHh;
  private com.tencent.mm.plugin.card.b.c oHi;
  private com.tencent.mm.plugin.card.b.g oHj;
  private l oHk;
  private j oHl;
  private com.tencent.mm.sdk.b.c oHm;
  private com.tencent.mm.sdk.b.c oHn;
  private com.tencent.mm.sdk.b.c oHo;
  private com.tencent.mm.plugin.card.ui.b oHp;
  private com.tencent.mm.sdk.b.c oHq;
  private com.tencent.mm.sdk.b.c oHr;
  private cf.a oHs;
  private cf.a oHt;
  private com.tencent.mm.sdk.b.c<jw> oHu;
  
  static
  {
    AppMethodBeat.i(112903);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return c.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new am.9());
    baseDBFactories.put(Integer.valueOf("CARDMSGINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return h.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SHARECARDINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.card.sharecard.model.k.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new am.12());
    baseDBFactories.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new am.2());
    baseDBFactories.put(Integer.valueOf("CARDQRCODEDATAINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return l.SQL_CREATE;
      }
    });
    AppMethodBeat.o(112903);
  }
  
  public am()
  {
    AppMethodBeat.i(112881);
    this.oHd = null;
    this.oHe = null;
    this.oHf = null;
    this.oHg = null;
    this.oHh = null;
    this.mHandler = new aq(Looper.getMainLooper());
    this.oHm = new n();
    this.oHn = new com.tencent.mm.plugin.card.b.o();
    this.oHo = new com.tencent.mm.plugin.card.b.a();
    this.oHp = new com.tencent.mm.plugin.card.ui.b();
    this.oHq = new am.1(this);
    this.oHr = new am.5(this);
    this.oHs = new cf.a()
    {
      public final void a(final com.tencent.mm.ak.e.a paramAnonymousa)
      {
        AppMethodBeat.i(112878);
        final String str = z.a(paramAnonymousa.gte.FNI);
        if ((str == null) || (str.length() == 0))
        {
          ae.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
          AppMethodBeat.o(112878);
          return;
        }
        am.a(am.this).post(new Runnable()
        {
          public final void run()
          {
            int k = 1;
            AppMethodBeat.i(112877);
            com.tencent.mm.plugin.card.b.k localk = am.bWg();
            Object localObject1 = str;
            String str1 = paramAnonymousa.gte.xrk;
            ae.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is ".concat(String.valueOf(str1)));
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              Object localObject2 = bx.M((String)localObject1, "sysmsg");
              if (localObject2 == null) {
                localObject1 = null;
              }
              for (;;)
              {
                if (localObject1 == null)
                {
                  ae.e("MicroMsg.CardMsgManager", "card msg == null");
                  AppMethodBeat.o(112877);
                  return;
                  localObject1 = new g();
                  Object localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.card_type");
                  label151:
                  label361:
                  String str2;
                  if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3)))
                  {
                    ((g)localObject1).field_card_type = bu.getInt((String)localObject3, 0);
                    ((g)localObject1).field_title = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.title"));
                    ((g)localObject1).field_description = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.description"));
                    ((g)localObject1).field_logo_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_url"));
                    ((g)localObject1).field_logo_color = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_color"));
                    localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.time");
                    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                      break label1176;
                    }
                    if (bu.getLong((String)localObject3, 0L) < 2147483647L) {
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
                    ((g)localObject1).field_msg_type = bu.getInt((String)localObject3, 0);
                    localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.jump_type");
                    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                      break label1201;
                    }
                    ((g)localObject1).field_jump_type = bu.getInt((String)localObject3, 0);
                    label402:
                    ((g)localObject1).field_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.url"));
                    str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.text");
                    if (!TextUtils.isEmpty(str2))
                    {
                      localObject3 = new sr();
                      ((sr)localObject3).text = str2;
                      ((sr)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.button.url"));
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.action_type");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                        break label1210;
                      }
                      ((sr)localObject3).oGc = bu.getInt(str2, 0);
                      label515:
                      ((g)localObject1).oFT = ((sr)localObject3);
                    }
                  }
                  try
                  {
                    ((g)localObject1).field_buttonData = ((g)localObject1).oFT.toByteArray();
                    str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.text");
                    if (!TextUtils.isEmpty(str2))
                    {
                      localObject3 = new tj();
                      ((tj)localObject3).text = str2;
                      ((tj)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.url"));
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.type");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                        break label1260;
                      }
                      ((tj)localObject3).type = bu.getInt(str2, 0);
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.endtime");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                        break label1283;
                      }
                      if (Long.valueOf(str2).longValue() < 2147483647L) {
                        break label1269;
                      }
                      ((tj)localObject3).zcL = 2147483647;
                      ((g)localObject1).oFU = ((tj)localObject3);
                    }
                  }
                  catch (Exception localException1)
                  {
                    try
                    {
                      for (;;)
                      {
                        ((g)localObject1).field_operData = ((g)localObject1).oFU.toByteArray();
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.report_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                          break label1340;
                        }
                        ((g)localObject1).field_report_scene = bu.getInt((String)localObject3, 0);
                        ((g)localObject1).field_read_state = 1;
                        ((g)localObject1).field_accept_buttons = com.tencent.mm.plugin.card.b.k.h((Map)localObject2, ".sysmsg.carditemmsg");
                        ((g)localObject1).field_jump_buttons = com.tencent.mm.plugin.card.b.k.g((Map)localObject2, ".sysmsg.carditemmsg");
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.get_layout_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                          break label1349;
                        }
                        ((g)localObject1).oFX = bu.getInt((String)localObject3, 0);
                        ((g)localObject1).field_consumed_box_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.consumed_box_id"));
                        ((g)localObject1).oFN = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_wording"));
                        ((g)localObject1).oFO = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_buff"));
                        ((g)localObject1).oFP = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_icon_url"));
                        ((g)localObject1).oFQ = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.title"));
                        ((g)localObject1).oFR = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.icon_url"));
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                          break label1358;
                        }
                        ((g)localObject1).oFY = bu.getInt((String)localObject3, 0);
                        ae.i("MicroMsg.CardMsgManager", "msg_scene is ".concat(String.valueOf(localObject3)));
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.need_check");
                        ae.i("MicroMsg.CardMsgManager", "need_check:".concat(String.valueOf(localObject3)));
                        if (TextUtils.isEmpty((CharSequence)localObject3)) {
                          break label1367;
                        }
                        ((g)localObject1).oFS = ((String)localObject3).equals("true");
                        str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.all_unavailable");
                        ae.i("MicroMsg.CardMsgManager", "all_Unavailable:".concat(String.valueOf(localObject3)));
                        if (TextUtils.isEmpty(str2)) {
                          break label1376;
                        }
                        ((g)localObject1).oFZ = str2.equals("true");
                        ((g)localObject1).field_unavailable_qr_code_list = com.tencent.mm.plugin.card.b.k.i((Map)localObject2, ".sysmsg.carditemmsg");
                        if ((!"true".equals(((Map)localObject2).get(".sysmsg.carditemmsg.need_pull_card_entrance"))) && (!"1".equals(((Map)localObject2).get(".sysmsg.carditemmsg.need_pull_card_entrance")))) {
                          break label1385;
                        }
                        bool = true;
                        ((g)localObject1).field_need_pull_card_entrance = bool;
                        break;
                        ((g)localObject1).field_card_type = 0;
                        break label151;
                        label1162:
                        ((g)localObject1).field_time = bu.getInt((String)localObject3, 0);
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
                        ((sr)localObject3).oGc = 0;
                        break label515;
                        localException1 = localException1;
                        ae.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[] { localException1.getMessage() });
                        ae.printErrStackTrace("MicroMsg.CardMsgInfo", localException1, "", new Object[0]);
                        continue;
                        label1260:
                        localException1.type = 0;
                        continue;
                        label1269:
                        localException1.zcL = bu.getInt(str2, 0);
                      }
                      label1283:
                      localException1.zcL = ((int)(System.currentTimeMillis() / 1000L));
                    }
                    catch (Exception localException2)
                    {
                      for (;;)
                      {
                        ae.e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", new Object[] { localException2.getMessage() });
                        ae.printErrStackTrace("MicroMsg.CardMsgInfo", localException2, "", new Object[0]);
                        continue;
                        label1340:
                        ((g)localObject1).field_report_scene = 2;
                        continue;
                        label1349:
                        ((g)localObject1).oFX = 0;
                        continue;
                        label1358:
                        ((g)localObject1).oFY = 0;
                        continue;
                        label1367:
                        ((g)localObject1).oFS = false;
                        continue;
                        label1376:
                        ((g)localObject1).oFZ = false;
                        continue;
                        label1385:
                        boolean bool = false;
                      }
                    }
                  }
                }
              }
              if (TextUtils.isEmpty(((g)localObject1).field_card_id)) {
                ae.e("MicroMsg.CardMsgManager", "card id == null");
              }
              localObject2 = ((g)localObject1).field_msg_id;
              ((g)localObject1).field_msg_id = str1;
              if (TextUtils.isEmpty(((g)localObject1).field_msg_id)) {
                ((g)localObject1).field_msg_id = ((String)localObject2);
              }
              if (TextUtils.isEmpty(((g)localObject1).field_msg_id)) {
                ((g)localObject1).field_msg_id = System.currentTimeMillis();
              }
              ae.i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + ((g)localObject1).field_msg_id);
              ae.i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + ((g)localObject1).field_msg_type);
              if (((g)localObject1).oFX != 0) {
                com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILX, Integer.valueOf(((g)localObject1).oFX));
              }
              ae.i("MicroMsg.CardMsgManager", "reddot_buff is " + ((g)localObject1).oFO);
              if (TextUtils.isEmpty(((g)localObject1).oFO)) {
                break label1962;
              }
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILT, ((g)localObject1).oFO);
              if ((((g)localObject1).field_msg_type & 0x1) != 0)
              {
                ae.i("MicroMsg.CardMsgManager", "msg_tips_title is " + ((g)localObject1).oFQ);
                ae.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + ((g)localObject1).oFR);
                com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILV, ((g)localObject1).oFQ);
                com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILW, ((g)localObject1).oFR);
              }
              if ((((g)localObject1).field_msg_type & 0x40) == 0) {
                break label1973;
              }
              com.tencent.mm.y.c.ahI().w(262152, true);
            }
            label1725:
            for (int i = 1;; i = 0)
            {
              if (i != 0)
              {
                ae.i("MicroMsg.CardMsgManager", "has card new msg, return");
                label1739:
                if ((((g)localObject1).field_msg_type & 0x1) != 0)
                {
                  if (localk.Zb(((g)localObject1).field_msg_id)) {
                    break label2652;
                  }
                  localk.oEg.add(localObject1);
                  com.tencent.mm.plugin.card.b.k.c((g)localObject1);
                  if ((((g)localObject1).field_msg_type & 0x80) != 0) {
                    localk.oEh += 1;
                  }
                }
              }
              for (;;)
              {
                com.tencent.mm.kernel.g.ajR().ajA().set(139268, Integer.valueOf(localk.oEh));
                localk.a((g)localObject1);
                if ((((g)localObject1).field_msg_type & 0x2) != 0)
                {
                  am.bWb();
                  com.tencent.mm.plugin.card.b.b.AA(((g)localObject1).oFX);
                }
                if ((((g)localObject1).field_msg_type & 0x4) != 0) {
                  localk.onChange();
                }
                if ((((g)localObject1).field_msg_type & 0x8) != 0) {
                  am.bWi().H(((g)localObject1).field_card_id, ((g)localObject1).field_card_tp_id, ((g)localObject1).field_report_scene);
                }
                if ((((g)localObject1).field_msg_type & 0x400) != 0)
                {
                  ((g)localObject1).bVX();
                  am.bWs().b((g)localObject1);
                }
                if (((((g)localObject1).field_msg_type & 0x1000) != 0) && (((g)localObject1).field_need_pull_card_entrance))
                {
                  localObject1 = com.tencent.mm.plugin.card.model.a.e.oHI;
                  com.tencent.mm.plugin.card.model.a.e.a.bWy();
                }
                com.tencent.mm.plugin.card.d.l.bZP();
                AppMethodBeat.o(112877);
                return;
                ae.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
                break;
                if ((((g)localObject1).field_msg_type & 0x4000) == 0) {
                  break label2716;
                }
                com.tencent.mm.y.c.ahI().w(262152, true);
                if ((((g)localObject1).field_msg_type & 0x10000) != 0) {
                  break label1725;
                }
                com.tencent.mm.y.c.ahI().cK(262152, 266241);
                break label1725;
                ae.i("MicroMsg.CardMsgManager", "not has new!");
                int j;
                if ((((g)localObject1).field_msg_type & 0x20) != 0)
                {
                  com.tencent.mm.y.c.ahI().x(262152, true);
                  ae.i("MicroMsg.CardMsgManager", "has reddot");
                  i = 1;
                  if (TextUtils.isEmpty(((g)localObject1).oFN)) {
                    break label2396;
                  }
                  ae.i("MicroMsg.CardMsgManager", "reddot_wording is " + ((g)localObject1).oFN);
                  com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILR, ((g)localObject1).oFN);
                  com.tencent.mm.y.c.ahI().a(am.a.ILL, true);
                  j = 1;
                  label2127:
                  ae.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + ((g)localObject1).oFP);
                  if (TextUtils.isEmpty(((g)localObject1).oFP)) {
                    break label2409;
                  }
                  com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILU, ((g)localObject1).oFP);
                  com.tencent.mm.y.c.ahI().a(am.a.ILM, true);
                  if ((i == 0) || (j == 0) || (k == 0))
                  {
                    if ((i == 0) || (j == 0) || (k != 0)) {
                      break label2422;
                    }
                    com.tencent.mm.y.c.ahI().a(am.a.ILM, false);
                    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILU, "");
                  }
                }
                for (;;)
                {
                  if ((i == 0) && (j == 0) && (k == 0)) {
                    break label2650;
                  }
                  com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMi, ((g)localObject1).field_card_id);
                  com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMj, Boolean.valueOf(((g)localObject1).oFS));
                  ae.i("MicroMsg.CardMsgManager", "card_id:" + ((g)localObject1).field_card_id + "  need_check:" + ((g)localObject1).oFS);
                  break;
                  if ((((g)localObject1).field_msg_type & 0x2000) != 0)
                  {
                    com.tencent.mm.y.c.ahI().x(262152, true);
                    if ((((g)localObject1).field_msg_type & 0x10000) == 0) {
                      com.tencent.mm.y.c.ahI().cK(262152, 266241);
                    }
                    i = 1;
                    break label2061;
                  }
                  ae.e("MicroMsg.CardMsgManager", "not has reddot!");
                  i = 0;
                  break label2061;
                  label2396:
                  ae.e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
                  j = 0;
                  break label2127;
                  label2409:
                  ae.e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
                  k = 0;
                  break label2191;
                  label2422:
                  if ((i != 0) && (j == 0) && (k != 0))
                  {
                    com.tencent.mm.y.c.ahI().a(am.a.ILL, false);
                    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILR, "");
                  }
                  else if ((i == 0) && (j != 0) && (k != 0))
                  {
                    com.tencent.mm.y.c.ahI().x(262152, false);
                  }
                  else if ((i != 0) && (j == 0) && (k == 0))
                  {
                    com.tencent.mm.y.c.ahI().a(am.a.ILM, false);
                    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILU, "");
                    com.tencent.mm.y.c.ahI().a(am.a.ILL, false);
                    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILR, "");
                  }
                  else if ((i == 0) && (j != 0) && (k == 0))
                  {
                    com.tencent.mm.y.c.ahI().a(am.a.ILM, false);
                    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILU, "");
                    com.tencent.mm.y.c.ahI().x(262152, false);
                  }
                  else if ((i == 0) && (j == 0) && (k != 0))
                  {
                    com.tencent.mm.y.c.ahI().a(am.a.ILL, false);
                    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILR, "");
                    com.tencent.mm.y.c.ahI().x(262152, false);
                  }
                }
                label2650:
                break label1739;
                label2652:
                ae.e("MicroMsg.CardMsgManager", "msg for id " + ((g)localObject1).field_msg_id + " is exist!!");
                localk.Zc(((g)localObject1).field_msg_id);
                localk.oEg.add(localObject1);
                com.tencent.mm.plugin.card.b.k.c((g)localObject1);
              }
            }
          }
        });
        AppMethodBeat.o(112878);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.oHt = new cf.a()
    {
      public final void a(final com.tencent.mm.ak.e.a paramAnonymousa)
      {
        AppMethodBeat.i(112880);
        final String str = z.a(paramAnonymousa.gte.FNI);
        if ((str == null) || (str.length() == 0))
        {
          ae.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
          AppMethodBeat.o(112880);
          return;
        }
        am.a(am.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(112879);
            Object localObject1 = am.bWm();
            Object localObject2 = str;
            ae.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is ".concat(String.valueOf(paramAnonymousa.gte.xrk)));
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject2 = bx.M((String)localObject2, "sysmsg");
              if (localObject2 == null)
              {
                localObject1 = null;
                if (localObject1 == null)
                {
                  ae.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
                  AppMethodBeat.o(112879);
                }
              }
              else
              {
                localObject1 = new c.a((com.tencent.mm.plugin.card.sharecard.a.c)localObject1);
                String str = (String)((Map)localObject2).get(".sysmsg.notifysharecard.state_flag");
                if ((!TextUtils.isEmpty(str)) && (com.tencent.mm.plugin.card.d.l.isNumeric(str))) {}
                for (((c.a)localObject1).oId = bu.getInt(str, 0);; ((c.a)localObject1).oId = 0)
                {
                  ((c.a)localObject1).username = ((String)((Map)localObject2).get(".sysmsg.notifysharecard.username"));
                  ((c.a)localObject1).dJb = ((String)((Map)localObject2).get(".sysmsg.notifysharecard.card_id"));
                  break;
                }
              }
              if (TextUtils.isEmpty(((c.a)localObject1).dJb)) {
                ae.e("MicroMsg.ShareCardMsgMgr", "card id == null");
              }
              ae.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + ((c.a)localObject1).dJb);
              am.bWj().bWD();
              com.tencent.mm.plugin.card.d.l.bZR();
            }
            AppMethodBeat.o(112879);
          }
        });
        AppMethodBeat.o(112880);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.oHu = new am.4(this);
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(m.oGh);
    if (!localk.exists()) {
      localk.mkdirs();
    }
    localk = new com.tencent.mm.vfs.k(m.oGi);
    if (!localk.exists()) {
      localk.mkdirs();
    }
    AppMethodBeat.o(112881);
  }
  
  public static com.tencent.mm.plugin.card.b.b bWb()
  {
    AppMethodBeat.i(112885);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oGU == null) {
      getCore().oGU = new com.tencent.mm.plugin.card.b.b();
    }
    com.tencent.mm.plugin.card.b.b localb = getCore().oGU;
    AppMethodBeat.o(112885);
    return localb;
  }
  
  public static c bWc()
  {
    AppMethodBeat.i(112886);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oGV == null) {
      getCore().oGV = new c(com.tencent.mm.kernel.g.ajR().gDX);
    }
    c localc = getCore().oGV;
    AppMethodBeat.o(112886);
    return localc;
  }
  
  public static al bWd()
  {
    AppMethodBeat.i(112887);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oGW == null) {
      getCore().oGW = new al(com.tencent.mm.kernel.g.ajR().gDX);
    }
    al localal = getCore().oGW;
    AppMethodBeat.o(112887);
    return localal;
  }
  
  public static h bWe()
  {
    AppMethodBeat.i(112888);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oGX == null) {
      getCore().oGX = new h(com.tencent.mm.kernel.g.ajR().gDX);
    }
    h localh = getCore().oGX;
    AppMethodBeat.o(112888);
    return localh;
  }
  
  public static com.tencent.mm.plugin.card.b.m bWf()
  {
    AppMethodBeat.i(112889);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oGY == null) {
      getCore().oGY = new com.tencent.mm.plugin.card.b.m();
    }
    com.tencent.mm.plugin.card.b.m localm = getCore().oGY;
    AppMethodBeat.o(112889);
    return localm;
  }
  
  public static com.tencent.mm.plugin.card.b.k bWg()
  {
    AppMethodBeat.i(112890);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oHd == null) {
      getCore().oHd = new com.tencent.mm.plugin.card.b.k();
    }
    com.tencent.mm.plugin.card.b.k localk = getCore().oHd;
    AppMethodBeat.o(112890);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.b.e bWh()
  {
    AppMethodBeat.i(112891);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oHe == null) {
      getCore().oHe = new com.tencent.mm.plugin.card.b.e();
    }
    com.tencent.mm.plugin.card.b.e locale = getCore().oHe;
    AppMethodBeat.o(112891);
    return locale;
  }
  
  public static com.tencent.mm.plugin.card.b.l bWi()
  {
    AppMethodBeat.i(112892);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oHf == null) {
      getCore().oHf = new com.tencent.mm.plugin.card.b.l();
    }
    com.tencent.mm.plugin.card.b.l locall = getCore().oHf;
    AppMethodBeat.o(112892);
    return locall;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.a bWj()
  {
    AppMethodBeat.i(112893);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oGZ == null) {
      getCore().oGZ = new com.tencent.mm.plugin.card.sharecard.a.a();
    }
    com.tencent.mm.plugin.card.sharecard.a.a locala = getCore().oGZ;
    AppMethodBeat.o(112893);
    return locala;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.k bWk()
  {
    AppMethodBeat.i(112894);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oHa == null) {
      getCore().oHa = new com.tencent.mm.plugin.card.sharecard.model.k(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.plugin.card.sharecard.model.k localk = getCore().oHa;
    AppMethodBeat.o(112894);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.o bWl()
  {
    AppMethodBeat.i(112895);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oHb == null) {
      getCore().oHb = new com.tencent.mm.plugin.card.sharecard.model.o(com.tencent.mm.kernel.g.ajR().gDX);
    }
    com.tencent.mm.plugin.card.sharecard.model.o localo = getCore().oHb;
    AppMethodBeat.o(112895);
    return localo;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.c bWm()
  {
    AppMethodBeat.i(112896);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oHc == null) {
      getCore().oHc = new com.tencent.mm.plugin.card.sharecard.a.c();
    }
    com.tencent.mm.plugin.card.sharecard.a.c localc = getCore().oHc;
    AppMethodBeat.o(112896);
    return localc;
  }
  
  public static com.tencent.mm.plugin.card.b.d bWn()
  {
    AppMethodBeat.i(112897);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oHg == null) {
      getCore().oHg = new com.tencent.mm.plugin.card.b.d();
    }
    com.tencent.mm.plugin.card.b.d locald = getCore().oHg;
    AppMethodBeat.o(112897);
    return locald;
  }
  
  public static com.tencent.mm.plugin.card.b.j bWo()
  {
    AppMethodBeat.i(112898);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oHh == null) {
      getCore().oHh = new com.tencent.mm.plugin.card.b.j();
    }
    com.tencent.mm.plugin.card.b.j localj = getCore().oHh;
    AppMethodBeat.o(112898);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.c bWp()
  {
    AppMethodBeat.i(112899);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oHi == null) {
      getCore().oHi = new com.tencent.mm.plugin.card.b.c();
    }
    com.tencent.mm.plugin.card.b.c localc = getCore().oHi;
    AppMethodBeat.o(112899);
    return localc;
  }
  
  public static l bWq()
  {
    AppMethodBeat.i(112900);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oHk == null) {
      getCore().oHk = new l(com.tencent.mm.kernel.g.ajR().gDX);
    }
    l locall = getCore().oHk;
    AppMethodBeat.o(112900);
    return locall;
  }
  
  public static j bWr()
  {
    AppMethodBeat.i(112901);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oHl == null) {
      getCore().oHl = new j(com.tencent.mm.kernel.g.ajR().gDX);
    }
    j localj = getCore().oHl;
    AppMethodBeat.o(112901);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.g bWs()
  {
    AppMethodBeat.i(112902);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (getCore().oHj == null) {
      getCore().oHj = new com.tencent.mm.plugin.card.b.g();
    }
    com.tencent.mm.plugin.card.b.g localg = getCore().oHj;
    AppMethodBeat.o(112902);
    return localg;
  }
  
  private static am getCore()
  {
    AppMethodBeat.i(112882);
    Object localObject = (com.tencent.mm.plugin.card.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.card.a.a.class);
    if (localObject != null) {}
    for (localObject = ((PluginCard)localObject).getCore();; localObject = null)
    {
      AppMethodBeat.o(112882);
      return localObject;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(112883);
    ae.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.sdk.b.a.IvT.c(this.oHq);
    com.tencent.mm.sdk.b.a.IvT.c(this.oHr);
    com.tencent.mm.sdk.b.a.IvT.c(this.oHm);
    com.tencent.mm.sdk.b.a.IvT.c(this.oHn);
    com.tencent.mm.sdk.b.a.IvT.c(this.oHo);
    com.tencent.mm.sdk.b.a.IvT.c(this.oHu);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("carditemmsg", this.oHs, true);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("notifysharecard", this.oHt, true);
    this.oHd = null;
    if (this.oHe != null)
    {
      this.oHe.oDp.clear();
      this.oHe = null;
    }
    if (this.oGY != null) {
      ??? = this.oGY;
    }
    synchronized (((com.tencent.mm.plugin.card.b.m)???).oEi)
    {
      ((com.tencent.mm.plugin.card.b.m)???).oEi.clear();
      synchronized (((com.tencent.mm.plugin.card.b.m)???).oEj)
      {
        ((com.tencent.mm.plugin.card.b.m)???).oEj.clear();
        com.tencent.mm.kernel.g.ajQ().gDv.b(1058, (f)???);
        ??? = com.tencent.mm.modelgeo.d.aIh();
        if (??? != null) {
          ((com.tencent.mm.modelgeo.b)???).c((b.a)???);
        }
        if (((com.tencent.mm.plugin.card.b.m)???).oEl != null) {
          com.tencent.mm.kernel.g.ajQ().gDv.a(((com.tencent.mm.plugin.card.b.m)???).oEl);
        }
        this.oGY = null;
        if (this.oGU != null)
        {
          this.oGU.detach();
          this.oGU = null;
        }
        if (this.oGZ != null) {
          ??? = this.oGZ;
        }
      }
    }
    synchronized (((com.tencent.mm.plugin.card.sharecard.a.a)???).lock)
    {
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).pendingList.clear();
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).oCV.clear();
      if (((com.tencent.mm.plugin.card.sharecard.a.a)???).oHT != null) {
        com.tencent.mm.kernel.g.ajQ().gDv.a(((com.tencent.mm.plugin.card.sharecard.a.a)???).oHT);
      }
      com.tencent.mm.kernel.g.ajQ().gDv.b(1132, (f)???);
      this.oGZ = null;
      if (this.oHg != null)
      {
        this.oHg.release();
        ??? = this.oHg;
        ((com.tencent.mm.plugin.card.b.d)???).oCX.clear();
        ((com.tencent.mm.plugin.card.b.d)???).oDj.clear();
        ((com.tencent.mm.plugin.card.b.d)???).oDk.clear();
        ((com.tencent.mm.plugin.card.b.d)???).oDl.clear();
        ((com.tencent.mm.plugin.card.b.d)???).oDn = false;
        this.oHg = null;
      }
      if (this.oHh == null) {
        break label573;
      }
      ??? = this.oHh;
      com.tencent.mm.kernel.g.ajQ().gDv.b(1078, (f)???);
      ??? = ((com.tencent.mm.plugin.card.b.j)???).oDU.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        Runnable localRunnable = (Runnable)((com.tencent.mm.plugin.card.b.j)???).oDW.get(str);
        ((com.tencent.mm.plugin.card.b.j)???).oDW.remove(str);
        ((com.tencent.mm.plugin.card.b.j)???).oDV.removeCallbacks(localRunnable);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(112883);
        throw localObject2;
        localObject3 = finally;
        AppMethodBeat.o(112883);
        throw localObject3;
      }
    }
    localObject3.oDT.clear();
    localObject3.oDU.clear();
    localObject3.oDW.clear();
    this.oHh = null;
    label573:
    if (this.oHi != null)
    {
      this.oHi.release();
      this.oHi = null;
    }
    if (this.oHj != null)
    {
      this.oHj.release();
      this.oHj = null;
    }
    this.oHf = null;
    com.tencent.mm.plugin.card.ui.b localb = this.oHp;
    com.tencent.mm.plugin.card.ui.b.bAa().registerActivityLifecycleCallbacks(localb);
    if (paramBoolean) {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IZw, Integer.valueOf(1));
    }
    AppMethodBeat.o(112883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(112884);
    if (getCore().oGU != null) {
      getCore().oGU.detach();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.oHq);
    com.tencent.mm.sdk.b.a.IvT.d(this.oHr);
    com.tencent.mm.sdk.b.a.IvT.d(this.oHm);
    com.tencent.mm.sdk.b.a.IvT.d(this.oHn);
    com.tencent.mm.sdk.b.a.IvT.d(this.oHo);
    com.tencent.mm.sdk.b.a.IvT.d(this.oHu);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("carditemmsg", this.oHs, true);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("notifysharecard", this.oHt, true);
    com.tencent.mm.plugin.card.ui.b localb = this.oHp;
    com.tencent.mm.plugin.card.ui.b.bAa().unregisterActivityLifecycleCallbacks(localb);
    AppMethodBeat.o(112884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am
 * JD-Core Version:    0.7.0.1
 */