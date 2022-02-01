package com.tencent.mm.plugin.card.model;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.a.jv.a;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.PluginCard;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.plugin.card.sharecard.a.c.a;
import com.tencent.mm.plugin.card.ui.CardHomePageUI;
import com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI;
import com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class am
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ap mHandler;
  private com.tencent.mm.plugin.card.sharecard.a.c oAA;
  private com.tencent.mm.plugin.card.b.k oAB;
  private com.tencent.mm.plugin.card.b.e oAC;
  private com.tencent.mm.plugin.card.b.l oAD;
  private com.tencent.mm.plugin.card.b.d oAE;
  private com.tencent.mm.plugin.card.b.j oAF;
  private com.tencent.mm.plugin.card.b.c oAG;
  private com.tencent.mm.plugin.card.b.g oAH;
  private l oAI;
  private j oAJ;
  private com.tencent.mm.sdk.b.c oAK;
  private com.tencent.mm.sdk.b.c oAL;
  private com.tencent.mm.sdk.b.c oAM;
  private com.tencent.mm.plugin.card.ui.b oAN;
  private com.tencent.mm.sdk.b.c oAO;
  private com.tencent.mm.sdk.b.c oAP;
  private cd.a oAQ;
  private cd.a oAR;
  private com.tencent.mm.sdk.b.c<jv> oAS;
  private com.tencent.mm.plugin.card.b.b oAs;
  private c oAt;
  private al oAu;
  private h oAv;
  private com.tencent.mm.plugin.card.b.m oAw;
  private com.tencent.mm.plugin.card.sharecard.a.a oAx;
  private com.tencent.mm.plugin.card.sharecard.model.k oAy;
  private com.tencent.mm.plugin.card.sharecard.model.o oAz;
  
  static
  {
    AppMethodBeat.i(112903);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("USERCARDINFO_TABLE".hashCode()), new am.8());
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
    this.oAB = null;
    this.oAC = null;
    this.oAD = null;
    this.oAE = null;
    this.oAF = null;
    this.mHandler = new ap(Looper.getMainLooper());
    this.oAK = new n();
    this.oAL = new com.tencent.mm.plugin.card.b.o();
    this.oAM = new com.tencent.mm.plugin.card.b.a();
    this.oAN = new com.tencent.mm.plugin.card.ui.b();
    this.oAO = new am.1(this);
    this.oAP = new am.5(this);
    this.oAQ = new cd.a()
    {
      public final void a(final com.tencent.mm.al.e.a paramAnonymousa)
      {
        AppMethodBeat.i(112878);
        final String str = z.a(paramAnonymousa.gqE.Fvk);
        if ((str == null) || (str.length() == 0))
        {
          ad.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
          AppMethodBeat.o(112878);
          return;
        }
        am.a(am.this).post(new Runnable()
        {
          public final void run()
          {
            int k = 1;
            AppMethodBeat.i(112877);
            com.tencent.mm.plugin.card.b.k localk = am.bUR();
            Object localObject1 = str;
            String str1 = paramAnonymousa.gqE.xbt;
            ad.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is ".concat(String.valueOf(str1)));
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              Object localObject2 = bw.M((String)localObject1, "sysmsg");
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
                      localObject3 = new sp();
                      ((sp)localObject3).text = str2;
                      ((sp)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.button.url"));
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.action_type");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                        break label1210;
                      }
                      ((sp)localObject3).ozA = bt.getInt(str2, 0);
                      label515:
                      ((g)localObject1).ozr = ((sp)localObject3);
                    }
                  }
                  try
                  {
                    ((g)localObject1).field_buttonData = ((g)localObject1).ozr.toByteArray();
                    str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.text");
                    if (!TextUtils.isEmpty(str2))
                    {
                      localObject3 = new th();
                      ((th)localObject3).text = str2;
                      ((th)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.url"));
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.type");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                        break label1260;
                      }
                      ((th)localObject3).type = bt.getInt(str2, 0);
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.endtime");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                        break label1283;
                      }
                      if (Long.valueOf(str2).longValue() < 2147483647L) {
                        break label1269;
                      }
                      ((th)localObject3).yMB = 2147483647;
                      ((g)localObject1).ozs = ((th)localObject3);
                    }
                  }
                  catch (Exception localException1)
                  {
                    try
                    {
                      for (;;)
                      {
                        ((g)localObject1).field_operData = ((g)localObject1).ozs.toByteArray();
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.report_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                          break label1340;
                        }
                        ((g)localObject1).field_report_scene = bt.getInt((String)localObject3, 0);
                        ((g)localObject1).field_read_state = 1;
                        ((g)localObject1).field_accept_buttons = com.tencent.mm.plugin.card.b.k.h((Map)localObject2, ".sysmsg.carditemmsg");
                        ((g)localObject1).field_jump_buttons = com.tencent.mm.plugin.card.b.k.g((Map)localObject2, ".sysmsg.carditemmsg");
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.get_layout_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                          break label1349;
                        }
                        ((g)localObject1).ozv = bt.getInt((String)localObject3, 0);
                        ((g)localObject1).field_consumed_box_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.consumed_box_id"));
                        ((g)localObject1).ozl = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_wording"));
                        ((g)localObject1).ozm = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_buff"));
                        ((g)localObject1).ozn = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_icon_url"));
                        ((g)localObject1).ozo = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.title"));
                        ((g)localObject1).ozp = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.icon_url"));
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                          break label1358;
                        }
                        ((g)localObject1).ozw = bt.getInt((String)localObject3, 0);
                        ad.i("MicroMsg.CardMsgManager", "msg_scene is ".concat(String.valueOf(localObject3)));
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.need_check");
                        ad.i("MicroMsg.CardMsgManager", "need_check:".concat(String.valueOf(localObject3)));
                        if (TextUtils.isEmpty((CharSequence)localObject3)) {
                          break label1367;
                        }
                        ((g)localObject1).ozq = ((String)localObject3).equals("true");
                        str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.all_unavailable");
                        ad.i("MicroMsg.CardMsgManager", "all_Unavailable:".concat(String.valueOf(localObject3)));
                        if (TextUtils.isEmpty(str2)) {
                          break label1376;
                        }
                        ((g)localObject1).ozx = str2.equals("true");
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
                        ((sp)localObject3).ozA = 0;
                        break label515;
                        localException1 = localException1;
                        ad.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[] { localException1.getMessage() });
                        ad.printErrStackTrace("MicroMsg.CardMsgInfo", localException1, "", new Object[0]);
                        continue;
                        label1260:
                        localException1.type = 0;
                        continue;
                        label1269:
                        localException1.yMB = bt.getInt(str2, 0);
                      }
                      label1283:
                      localException1.yMB = ((int)(System.currentTimeMillis() / 1000L));
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
                        ((g)localObject1).ozv = 0;
                        continue;
                        label1358:
                        ((g)localObject1).ozw = 0;
                        continue;
                        label1367:
                        ((g)localObject1).ozq = false;
                        continue;
                        label1376:
                        ((g)localObject1).ozx = false;
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
              if (((g)localObject1).ozv != 0) {
                com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IrB, Integer.valueOf(((g)localObject1).ozv));
              }
              ad.i("MicroMsg.CardMsgManager", "reddot_buff is " + ((g)localObject1).ozm);
              if (TextUtils.isEmpty(((g)localObject1).ozm)) {
                break label1962;
              }
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Irx, ((g)localObject1).ozm);
              if ((((g)localObject1).field_msg_type & 0x1) != 0)
              {
                ad.i("MicroMsg.CardMsgManager", "msg_tips_title is " + ((g)localObject1).ozo);
                ad.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + ((g)localObject1).ozp);
                com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Irz, ((g)localObject1).ozo);
                com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IrA, ((g)localObject1).ozp);
              }
              if ((((g)localObject1).field_msg_type & 0x40) == 0) {
                break label1973;
              }
              com.tencent.mm.z.c.aht().w(262152, true);
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
                  if (localk.Yk(((g)localObject1).field_msg_id)) {
                    break label2652;
                  }
                  localk.oxE.add(localObject1);
                  com.tencent.mm.plugin.card.b.k.c((g)localObject1);
                  if ((((g)localObject1).field_msg_type & 0x80) != 0) {
                    localk.oxF += 1;
                  }
                }
              }
              for (;;)
              {
                com.tencent.mm.kernel.g.ajC().ajl().set(139268, Integer.valueOf(localk.oxF));
                localk.a((g)localObject1);
                if ((((g)localObject1).field_msg_type & 0x2) != 0)
                {
                  am.bUM();
                  com.tencent.mm.plugin.card.b.b.Ao(((g)localObject1).ozv);
                }
                if ((((g)localObject1).field_msg_type & 0x4) != 0) {
                  localk.onChange();
                }
                if ((((g)localObject1).field_msg_type & 0x8) != 0) {
                  am.bUT().H(((g)localObject1).field_card_id, ((g)localObject1).field_card_tp_id, ((g)localObject1).field_report_scene);
                }
                if ((((g)localObject1).field_msg_type & 0x400) != 0)
                {
                  ((g)localObject1).bUI();
                  am.bVd().b((g)localObject1);
                }
                if (((((g)localObject1).field_msg_type & 0x1000) != 0) && (((g)localObject1).field_need_pull_card_entrance))
                {
                  localObject1 = com.tencent.mm.plugin.card.model.a.e.oBg;
                  com.tencent.mm.plugin.card.model.a.e.a.bVj();
                }
                com.tencent.mm.plugin.card.d.l.bYA();
                AppMethodBeat.o(112877);
                return;
                ad.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
                break;
                if ((((g)localObject1).field_msg_type & 0x4000) == 0) {
                  break label2716;
                }
                com.tencent.mm.z.c.aht().w(262152, true);
                if ((((g)localObject1).field_msg_type & 0x10000) != 0) {
                  break label1725;
                }
                com.tencent.mm.z.c.aht().cK(262152, 266241);
                break label1725;
                ad.i("MicroMsg.CardMsgManager", "not has new!");
                int j;
                if ((((g)localObject1).field_msg_type & 0x20) != 0)
                {
                  com.tencent.mm.z.c.aht().x(262152, true);
                  ad.i("MicroMsg.CardMsgManager", "has reddot");
                  i = 1;
                  if (TextUtils.isEmpty(((g)localObject1).ozl)) {
                    break label2396;
                  }
                  ad.i("MicroMsg.CardMsgManager", "reddot_wording is " + ((g)localObject1).ozl);
                  com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Irv, ((g)localObject1).ozl);
                  com.tencent.mm.z.c.aht().a(al.a.Irp, true);
                  j = 1;
                  label2127:
                  ad.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + ((g)localObject1).ozn);
                  if (TextUtils.isEmpty(((g)localObject1).ozn)) {
                    break label2409;
                  }
                  com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iry, ((g)localObject1).ozn);
                  com.tencent.mm.z.c.aht().a(al.a.Irq, true);
                  if ((i == 0) || (j == 0) || (k == 0))
                  {
                    if ((i == 0) || (j == 0) || (k != 0)) {
                      break label2422;
                    }
                    com.tencent.mm.z.c.aht().a(al.a.Irq, false);
                    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iry, "");
                  }
                }
                for (;;)
                {
                  if ((i == 0) && (j == 0) && (k == 0)) {
                    break label2650;
                  }
                  com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IrM, ((g)localObject1).field_card_id);
                  com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IrN, Boolean.valueOf(((g)localObject1).ozq));
                  ad.i("MicroMsg.CardMsgManager", "card_id:" + ((g)localObject1).field_card_id + "  need_check:" + ((g)localObject1).ozq);
                  break;
                  if ((((g)localObject1).field_msg_type & 0x2000) != 0)
                  {
                    com.tencent.mm.z.c.aht().x(262152, true);
                    if ((((g)localObject1).field_msg_type & 0x10000) == 0) {
                      com.tencent.mm.z.c.aht().cK(262152, 266241);
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
                    com.tencent.mm.z.c.aht().a(al.a.Irp, false);
                    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Irv, "");
                  }
                  else if ((i == 0) && (j != 0) && (k != 0))
                  {
                    com.tencent.mm.z.c.aht().x(262152, false);
                  }
                  else if ((i != 0) && (j == 0) && (k == 0))
                  {
                    com.tencent.mm.z.c.aht().a(al.a.Irq, false);
                    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iry, "");
                    com.tencent.mm.z.c.aht().a(al.a.Irp, false);
                    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Irv, "");
                  }
                  else if ((i == 0) && (j != 0) && (k == 0))
                  {
                    com.tencent.mm.z.c.aht().a(al.a.Irq, false);
                    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iry, "");
                    com.tencent.mm.z.c.aht().x(262152, false);
                  }
                  else if ((i == 0) && (j == 0) && (k != 0))
                  {
                    com.tencent.mm.z.c.aht().a(al.a.Irp, false);
                    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Irv, "");
                    com.tencent.mm.z.c.aht().x(262152, false);
                  }
                }
                label2650:
                break label1739;
                label2652:
                ad.e("MicroMsg.CardMsgManager", "msg for id " + ((g)localObject1).field_msg_id + " is exist!!");
                localk.Yl(((g)localObject1).field_msg_id);
                localk.oxE.add(localObject1);
                com.tencent.mm.plugin.card.b.k.c((g)localObject1);
              }
            }
          }
        });
        AppMethodBeat.o(112878);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.oAR = new cd.a()
    {
      public final void a(final com.tencent.mm.al.e.a paramAnonymousa)
      {
        AppMethodBeat.i(112880);
        final String str = z.a(paramAnonymousa.gqE.Fvk);
        if ((str == null) || (str.length() == 0))
        {
          ad.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
          AppMethodBeat.o(112880);
          return;
        }
        am.a(am.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(112879);
            Object localObject1 = am.bUX();
            Object localObject2 = str;
            ad.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is ".concat(String.valueOf(paramAnonymousa.gqE.xbt)));
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject2 = bw.M((String)localObject2, "sysmsg");
              if (localObject2 == null)
              {
                localObject1 = null;
                if (localObject1 == null)
                {
                  ad.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
                  AppMethodBeat.o(112879);
                }
              }
              else
              {
                localObject1 = new c.a((com.tencent.mm.plugin.card.sharecard.a.c)localObject1);
                String str = (String)((Map)localObject2).get(".sysmsg.notifysharecard.state_flag");
                if ((!TextUtils.isEmpty(str)) && (com.tencent.mm.plugin.card.d.l.isNumeric(str))) {}
                for (((c.a)localObject1).oBB = bt.getInt(str, 0);; ((c.a)localObject1).oBB = 0)
                {
                  ((c.a)localObject1).username = ((String)((Map)localObject2).get(".sysmsg.notifysharecard.username"));
                  ((c.a)localObject1).dHX = ((String)((Map)localObject2).get(".sysmsg.notifysharecard.card_id"));
                  break;
                }
              }
              if (TextUtils.isEmpty(((c.a)localObject1).dHX)) {
                ad.e("MicroMsg.ShareCardMsgMgr", "card id == null");
              }
              ad.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + ((c.a)localObject1).dHX);
              am.bUU().bVo();
              com.tencent.mm.plugin.card.d.l.bYC();
            }
            AppMethodBeat.o(112879);
          }
        });
        AppMethodBeat.o(112880);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.oAS = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(jv paramAnonymousjv)
      {
        AppMethodBeat.i(112874);
        int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEW, Integer.valueOf(1))).intValue();
        int j = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEZ, Integer.valueOf(1))).intValue();
        boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFb, Boolean.FALSE)).booleanValue();
        ad.i("MicroMsg.SubCoreCard", "goto card version: %s, trade area: %s, newVersion2: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
        Object localObject;
        Context localContext;
        if (bool) {
          if (paramAnonymousjv.dwO.context != null)
          {
            localObject = new Intent(paramAnonymousjv.dwO.context, CardHomePageV3UI.class);
            localContext = paramAnonymousjv.dwO.context;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.card.b.k.bUC();
            if (paramAnonymousjv.dwO.enterScene == 1) {
              com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(3) });
            }
          }
        }
        for (;;)
        {
          paramAnonymousjv = com.tencent.mm.plugin.card.model.a.e.oBg;
          com.tencent.mm.plugin.card.model.a.e.a.bVj();
          AppMethodBeat.o(112874);
          return true;
          if (j == 2)
          {
            paramAnonymousjv = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFa, "");
            if (!bt.isNullOrNil(paramAnonymousjv)) {
              try
              {
                paramAnonymousjv = (tg)new tg().parseFrom(paramAnonymousjv.getBytes(d.n.d.ISO_8859_1));
                com.tencent.mm.plugin.card.d.b.I(paramAnonymousjv.CzQ, paramAnonymousjv.CzR, paramAnonymousjv.Dhk);
              }
              catch (IOException paramAnonymousjv)
              {
                ad.printErrStackTrace("MicroMsg.SubCoreCard", paramAnonymousjv, "", new Object[0]);
              }
            }
          }
          else if (i == 1)
          {
            if (paramAnonymousjv.dwO.context != null)
            {
              localObject = new Intent(paramAnonymousjv.dwO.context, CardHomePageNewUI.class);
              localContext = paramAnonymousjv.dwO.context;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.card.b.k.bUC();
              if (paramAnonymousjv.dwO.enterScene == 1) {
                com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(3) });
              }
            }
          }
          else
          {
            if (paramAnonymousjv.dwO.context != null)
            {
              localObject = new Intent(paramAnonymousjv.dwO.context, CardHomePageUI.class);
              ((Intent)localObject).putExtra("key_from_scene", 22);
              ((Intent)localObject).putExtra("key_home_page_from_scene", paramAnonymousjv.dwO.scene);
              localContext = paramAnonymousjv.dwO.context;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.card.b.k.bUC();
              if (paramAnonymousjv.dwO.enterScene == 1) {
                com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(2) });
              }
            }
            paramAnonymousjv.dwP.targetActivity = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
          }
        }
      }
    };
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(m.ozF);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(m.ozG);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(112881);
  }
  
  public static com.tencent.mm.plugin.card.b.b bUM()
  {
    AppMethodBeat.i(112885);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAs == null) {
      getCore().oAs = new com.tencent.mm.plugin.card.b.b();
    }
    com.tencent.mm.plugin.card.b.b localb = getCore().oAs;
    AppMethodBeat.o(112885);
    return localb;
  }
  
  public static c bUN()
  {
    AppMethodBeat.i(112886);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAt == null) {
      getCore().oAt = new c(com.tencent.mm.kernel.g.ajC().gBq);
    }
    c localc = getCore().oAt;
    AppMethodBeat.o(112886);
    return localc;
  }
  
  public static al bUO()
  {
    AppMethodBeat.i(112887);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAu == null) {
      getCore().oAu = new al(com.tencent.mm.kernel.g.ajC().gBq);
    }
    al localal = getCore().oAu;
    AppMethodBeat.o(112887);
    return localal;
  }
  
  public static h bUP()
  {
    AppMethodBeat.i(112888);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAv == null) {
      getCore().oAv = new h(com.tencent.mm.kernel.g.ajC().gBq);
    }
    h localh = getCore().oAv;
    AppMethodBeat.o(112888);
    return localh;
  }
  
  public static com.tencent.mm.plugin.card.b.m bUQ()
  {
    AppMethodBeat.i(112889);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAw == null) {
      getCore().oAw = new com.tencent.mm.plugin.card.b.m();
    }
    com.tencent.mm.plugin.card.b.m localm = getCore().oAw;
    AppMethodBeat.o(112889);
    return localm;
  }
  
  public static com.tencent.mm.plugin.card.b.k bUR()
  {
    AppMethodBeat.i(112890);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAB == null) {
      getCore().oAB = new com.tencent.mm.plugin.card.b.k();
    }
    com.tencent.mm.plugin.card.b.k localk = getCore().oAB;
    AppMethodBeat.o(112890);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.b.e bUS()
  {
    AppMethodBeat.i(112891);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAC == null) {
      getCore().oAC = new com.tencent.mm.plugin.card.b.e();
    }
    com.tencent.mm.plugin.card.b.e locale = getCore().oAC;
    AppMethodBeat.o(112891);
    return locale;
  }
  
  public static com.tencent.mm.plugin.card.b.l bUT()
  {
    AppMethodBeat.i(112892);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAD == null) {
      getCore().oAD = new com.tencent.mm.plugin.card.b.l();
    }
    com.tencent.mm.plugin.card.b.l locall = getCore().oAD;
    AppMethodBeat.o(112892);
    return locall;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.a bUU()
  {
    AppMethodBeat.i(112893);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAx == null) {
      getCore().oAx = new com.tencent.mm.plugin.card.sharecard.a.a();
    }
    com.tencent.mm.plugin.card.sharecard.a.a locala = getCore().oAx;
    AppMethodBeat.o(112893);
    return locala;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.k bUV()
  {
    AppMethodBeat.i(112894);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAy == null) {
      getCore().oAy = new com.tencent.mm.plugin.card.sharecard.model.k(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.plugin.card.sharecard.model.k localk = getCore().oAy;
    AppMethodBeat.o(112894);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.o bUW()
  {
    AppMethodBeat.i(112895);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAz == null) {
      getCore().oAz = new com.tencent.mm.plugin.card.sharecard.model.o(com.tencent.mm.kernel.g.ajC().gBq);
    }
    com.tencent.mm.plugin.card.sharecard.model.o localo = getCore().oAz;
    AppMethodBeat.o(112895);
    return localo;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.c bUX()
  {
    AppMethodBeat.i(112896);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAA == null) {
      getCore().oAA = new com.tencent.mm.plugin.card.sharecard.a.c();
    }
    com.tencent.mm.plugin.card.sharecard.a.c localc = getCore().oAA;
    AppMethodBeat.o(112896);
    return localc;
  }
  
  public static com.tencent.mm.plugin.card.b.d bUY()
  {
    AppMethodBeat.i(112897);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAE == null) {
      getCore().oAE = new com.tencent.mm.plugin.card.b.d();
    }
    com.tencent.mm.plugin.card.b.d locald = getCore().oAE;
    AppMethodBeat.o(112897);
    return locald;
  }
  
  public static com.tencent.mm.plugin.card.b.j bUZ()
  {
    AppMethodBeat.i(112898);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAF == null) {
      getCore().oAF = new com.tencent.mm.plugin.card.b.j();
    }
    com.tencent.mm.plugin.card.b.j localj = getCore().oAF;
    AppMethodBeat.o(112898);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.c bVa()
  {
    AppMethodBeat.i(112899);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAG == null) {
      getCore().oAG = new com.tencent.mm.plugin.card.b.c();
    }
    com.tencent.mm.plugin.card.b.c localc = getCore().oAG;
    AppMethodBeat.o(112899);
    return localc;
  }
  
  public static l bVb()
  {
    AppMethodBeat.i(112900);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAI == null) {
      getCore().oAI = new l(com.tencent.mm.kernel.g.ajC().gBq);
    }
    l locall = getCore().oAI;
    AppMethodBeat.o(112900);
    return locall;
  }
  
  public static j bVc()
  {
    AppMethodBeat.i(112901);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAJ == null) {
      getCore().oAJ = new j(com.tencent.mm.kernel.g.ajC().gBq);
    }
    j localj = getCore().oAJ;
    AppMethodBeat.o(112901);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.g bVd()
  {
    AppMethodBeat.i(112902);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (getCore().oAH == null) {
      getCore().oAH = new com.tencent.mm.plugin.card.b.g();
    }
    com.tencent.mm.plugin.card.b.g localg = getCore().oAH;
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
    ad.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.sdk.b.a.IbL.c(this.oAO);
    com.tencent.mm.sdk.b.a.IbL.c(this.oAP);
    com.tencent.mm.sdk.b.a.IbL.c(this.oAK);
    com.tencent.mm.sdk.b.a.IbL.c(this.oAL);
    com.tencent.mm.sdk.b.a.IbL.c(this.oAM);
    com.tencent.mm.sdk.b.a.IbL.c(this.oAS);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("carditemmsg", this.oAQ, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("notifysharecard", this.oAR, true);
    this.oAB = null;
    if (this.oAC != null)
    {
      this.oAC.owN.clear();
      this.oAC = null;
    }
    if (this.oAw != null) {
      ??? = this.oAw;
    }
    synchronized (((com.tencent.mm.plugin.card.b.m)???).oxG)
    {
      ((com.tencent.mm.plugin.card.b.m)???).oxG.clear();
      synchronized (((com.tencent.mm.plugin.card.b.m)???).oxH)
      {
        ((com.tencent.mm.plugin.card.b.m)???).oxH.clear();
        com.tencent.mm.kernel.g.ajB().gAO.b(1058, (f)???);
        ??? = com.tencent.mm.modelgeo.d.aHQ();
        if (??? != null) {
          ((com.tencent.mm.modelgeo.b)???).c((b.a)???);
        }
        if (((com.tencent.mm.plugin.card.b.m)???).oxJ != null) {
          com.tencent.mm.kernel.g.ajB().gAO.a(((com.tencent.mm.plugin.card.b.m)???).oxJ);
        }
        this.oAw = null;
        if (this.oAs != null)
        {
          this.oAs.detach();
          this.oAs = null;
        }
        if (this.oAx != null) {
          ??? = this.oAx;
        }
      }
    }
    synchronized (((com.tencent.mm.plugin.card.sharecard.a.a)???).lock)
    {
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).pendingList.clear();
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).owt.clear();
      if (((com.tencent.mm.plugin.card.sharecard.a.a)???).oBr != null) {
        com.tencent.mm.kernel.g.ajB().gAO.a(((com.tencent.mm.plugin.card.sharecard.a.a)???).oBr);
      }
      com.tencent.mm.kernel.g.ajB().gAO.b(1132, (f)???);
      this.oAx = null;
      if (this.oAE != null)
      {
        this.oAE.release();
        ??? = this.oAE;
        ((com.tencent.mm.plugin.card.b.d)???).owv.clear();
        ((com.tencent.mm.plugin.card.b.d)???).owH.clear();
        ((com.tencent.mm.plugin.card.b.d)???).owI.clear();
        ((com.tencent.mm.plugin.card.b.d)???).owJ.clear();
        ((com.tencent.mm.plugin.card.b.d)???).owL = false;
        this.oAE = null;
      }
      if (this.oAF == null) {
        break label573;
      }
      ??? = this.oAF;
      com.tencent.mm.kernel.g.ajB().gAO.b(1078, (f)???);
      ??? = ((com.tencent.mm.plugin.card.b.j)???).oxs.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        Runnable localRunnable = (Runnable)((com.tencent.mm.plugin.card.b.j)???).oxu.get(str);
        ((com.tencent.mm.plugin.card.b.j)???).oxu.remove(str);
        ((com.tencent.mm.plugin.card.b.j)???).oxt.removeCallbacks(localRunnable);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(112883);
        throw localObject2;
        localObject3 = finally;
        AppMethodBeat.o(112883);
        throw localObject3;
      }
    }
    localObject3.oxr.clear();
    localObject3.oxs.clear();
    localObject3.oxu.clear();
    this.oAF = null;
    label573:
    if (this.oAG != null)
    {
      this.oAG.release();
      this.oAG = null;
    }
    if (this.oAH != null)
    {
      this.oAH.release();
      this.oAH = null;
    }
    this.oAD = null;
    com.tencent.mm.plugin.card.ui.b localb = this.oAN;
    com.tencent.mm.plugin.card.ui.b.bzf().registerActivityLifecycleCallbacks(localb);
    if (paramBoolean) {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEW, Integer.valueOf(1));
    }
    AppMethodBeat.o(112883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(112884);
    if (getCore().oAs != null) {
      getCore().oAs.detach();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.oAO);
    com.tencent.mm.sdk.b.a.IbL.d(this.oAP);
    com.tencent.mm.sdk.b.a.IbL.d(this.oAK);
    com.tencent.mm.sdk.b.a.IbL.d(this.oAL);
    com.tencent.mm.sdk.b.a.IbL.d(this.oAM);
    com.tencent.mm.sdk.b.a.IbL.d(this.oAS);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("carditemmsg", this.oAQ, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("notifysharecard", this.oAR, true);
    com.tencent.mm.plugin.card.ui.b localb = this.oAN;
    com.tencent.mm.plugin.card.ui.b.bzf().unregisterActivityLifecycleCallbacks(localb);
    AppMethodBeat.o(112884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am
 * JD-Core Version:    0.7.0.1
 */