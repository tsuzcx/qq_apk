package com.tencent.mm.plugin.card.model;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.g.a.ik.a;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.g.a.jn.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.PluginCard;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.plugin.card.model.a.e.a;
import com.tencent.mm.plugin.card.sharecard.a.c.a;
import com.tencent.mm.plugin.card.ui.CardHomePageUI;
import com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI;
import com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class am
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ao mHandler;
  private com.tencent.mm.plugin.card.b.b nWY;
  private c nWZ;
  private al nXa;
  private h nXb;
  private com.tencent.mm.plugin.card.b.m nXc;
  private com.tencent.mm.plugin.card.sharecard.a.a nXd;
  private com.tencent.mm.plugin.card.sharecard.model.k nXe;
  private com.tencent.mm.plugin.card.sharecard.model.o nXf;
  private com.tencent.mm.plugin.card.sharecard.a.c nXg;
  private com.tencent.mm.plugin.card.b.k nXh;
  private com.tencent.mm.plugin.card.b.e nXi;
  private com.tencent.mm.plugin.card.b.l nXj;
  private com.tencent.mm.plugin.card.b.d nXk;
  private com.tencent.mm.plugin.card.b.j nXl;
  private com.tencent.mm.plugin.card.b.c nXm;
  private com.tencent.mm.plugin.card.b.g nXn;
  private l nXo;
  private j nXp;
  private com.tencent.mm.sdk.b.c nXq;
  private com.tencent.mm.sdk.b.c nXr;
  private com.tencent.mm.sdk.b.c nXs;
  private com.tencent.mm.plugin.card.ui.b nXt;
  private com.tencent.mm.sdk.b.c nXu;
  private com.tencent.mm.sdk.b.c nXv;
  private cc.a nXw;
  private cc.a nXx;
  private com.tencent.mm.sdk.b.c<jn> nXy;
  
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
    baseDBFactories.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return j.SQL_CREATE;
      }
    });
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
    this.nXh = null;
    this.nXi = null;
    this.nXj = null;
    this.nXk = null;
    this.nXl = null;
    this.mHandler = new ao(Looper.getMainLooper());
    this.nXq = new n();
    this.nXr = new com.tencent.mm.plugin.card.b.o();
    this.nXs = new com.tencent.mm.plugin.card.b.a();
    this.nXt = new com.tencent.mm.plugin.card.ui.b();
    this.nXu = new com.tencent.mm.sdk.b.c() {};
    this.nXv = new am.5(this);
    this.nXw = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(112878);
        final String str = z.a(paramAnonymousa.fXi.DPV);
        if ((str == null) || (str.length() == 0))
        {
          ac.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
          AppMethodBeat.o(112878);
          return;
        }
        am.a(am.this).post(new Runnable()
        {
          public final void run()
          {
            int k = 1;
            AppMethodBeat.i(112877);
            com.tencent.mm.plugin.card.b.k localk = am.bQm();
            Object localObject1 = str;
            String str1 = paramAnonymousa.fXi.vTQ;
            ac.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is ".concat(String.valueOf(str1)));
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              Object localObject2 = bv.L((String)localObject1, "sysmsg");
              if (localObject2 == null) {
                localObject1 = null;
              }
              for (;;)
              {
                if (localObject1 == null)
                {
                  ac.e("MicroMsg.CardMsgManager", "card msg == null");
                  AppMethodBeat.o(112877);
                  return;
                  localObject1 = new g();
                  Object localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.card_type");
                  label151:
                  label361:
                  String str2;
                  if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3)))
                  {
                    ((g)localObject1).field_card_type = bs.getInt((String)localObject3, 0);
                    ((g)localObject1).field_title = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.title"));
                    ((g)localObject1).field_description = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.description"));
                    ((g)localObject1).field_logo_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_url"));
                    ((g)localObject1).field_logo_color = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_color"));
                    localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.time");
                    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                      break label1176;
                    }
                    if (bs.getLong((String)localObject3, 0L) < 2147483647L) {
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
                    ((g)localObject1).field_msg_type = bs.getInt((String)localObject3, 0);
                    localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.jump_type");
                    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                      break label1201;
                    }
                    ((g)localObject1).field_jump_type = bs.getInt((String)localObject3, 0);
                    label402:
                    ((g)localObject1).field_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.url"));
                    str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.text");
                    if (!TextUtils.isEmpty(str2))
                    {
                      localObject3 = new qw();
                      ((qw)localObject3).text = str2;
                      ((qw)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.button.url"));
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.action_type");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                        break label1210;
                      }
                      ((qw)localObject3).nWg = bs.getInt(str2, 0);
                      label515:
                      ((g)localObject1).nVX = ((qw)localObject3);
                    }
                  }
                  try
                  {
                    ((g)localObject1).field_buttonData = ((g)localObject1).nVX.toByteArray();
                    str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.text");
                    if (!TextUtils.isEmpty(str2))
                    {
                      localObject3 = new rn();
                      ((rn)localObject3).text = str2;
                      ((rn)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.url"));
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.type");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                        break label1260;
                      }
                      ((rn)localObject3).type = bs.getInt(str2, 0);
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.endtime");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                        break label1283;
                      }
                      if (Long.valueOf(str2).longValue() < 2147483647L) {
                        break label1269;
                      }
                      ((rn)localObject3).xxQ = 2147483647;
                      ((g)localObject1).nVY = ((rn)localObject3);
                    }
                  }
                  catch (Exception localException1)
                  {
                    try
                    {
                      for (;;)
                      {
                        ((g)localObject1).field_operData = ((g)localObject1).nVY.toByteArray();
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.report_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                          break label1340;
                        }
                        ((g)localObject1).field_report_scene = bs.getInt((String)localObject3, 0);
                        ((g)localObject1).field_read_state = 1;
                        ((g)localObject1).field_accept_buttons = com.tencent.mm.plugin.card.b.k.g((Map)localObject2, ".sysmsg.carditemmsg");
                        ((g)localObject1).field_jump_buttons = com.tencent.mm.plugin.card.b.k.f((Map)localObject2, ".sysmsg.carditemmsg");
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.get_layout_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                          break label1349;
                        }
                        ((g)localObject1).nWb = bs.getInt((String)localObject3, 0);
                        ((g)localObject1).field_consumed_box_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.consumed_box_id"));
                        ((g)localObject1).nVR = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_wording"));
                        ((g)localObject1).nVS = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_buff"));
                        ((g)localObject1).nVT = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_icon_url"));
                        ((g)localObject1).nVU = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.title"));
                        ((g)localObject1).nVV = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.icon_url"));
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                          break label1358;
                        }
                        ((g)localObject1).nWc = bs.getInt((String)localObject3, 0);
                        ac.i("MicroMsg.CardMsgManager", "msg_scene is ".concat(String.valueOf(localObject3)));
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.need_check");
                        ac.i("MicroMsg.CardMsgManager", "need_check:".concat(String.valueOf(localObject3)));
                        if (TextUtils.isEmpty((CharSequence)localObject3)) {
                          break label1367;
                        }
                        ((g)localObject1).nVW = ((String)localObject3).equals("true");
                        str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.all_unavailable");
                        ac.i("MicroMsg.CardMsgManager", "all_Unavailable:".concat(String.valueOf(localObject3)));
                        if (TextUtils.isEmpty(str2)) {
                          break label1376;
                        }
                        ((g)localObject1).nWd = str2.equals("true");
                        ((g)localObject1).field_unavailable_qr_code_list = com.tencent.mm.plugin.card.b.k.h((Map)localObject2, ".sysmsg.carditemmsg");
                        if ((!"true".equals(((Map)localObject2).get(".sysmsg.carditemmsg.need_pull_card_entrance"))) && (!"1".equals(((Map)localObject2).get(".sysmsg.carditemmsg.need_pull_card_entrance")))) {
                          break label1385;
                        }
                        bool = true;
                        ((g)localObject1).field_need_pull_card_entrance = bool;
                        break;
                        ((g)localObject1).field_card_type = 0;
                        break label151;
                        label1162:
                        ((g)localObject1).field_time = bs.getInt((String)localObject3, 0);
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
                        ((qw)localObject3).nWg = 0;
                        break label515;
                        localException1 = localException1;
                        ac.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[] { localException1.getMessage() });
                        ac.printErrStackTrace("MicroMsg.CardMsgInfo", localException1, "", new Object[0]);
                        continue;
                        label1260:
                        localException1.type = 0;
                        continue;
                        label1269:
                        localException1.xxQ = bs.getInt(str2, 0);
                      }
                      label1283:
                      localException1.xxQ = ((int)(System.currentTimeMillis() / 1000L));
                    }
                    catch (Exception localException2)
                    {
                      for (;;)
                      {
                        ac.e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", new Object[] { localException2.getMessage() });
                        ac.printErrStackTrace("MicroMsg.CardMsgInfo", localException2, "", new Object[0]);
                        continue;
                        label1340:
                        ((g)localObject1).field_report_scene = 2;
                        continue;
                        label1349:
                        ((g)localObject1).nWb = 0;
                        continue;
                        label1358:
                        ((g)localObject1).nWc = 0;
                        continue;
                        label1367:
                        ((g)localObject1).nVW = false;
                        continue;
                        label1376:
                        ((g)localObject1).nWd = false;
                        continue;
                        label1385:
                        boolean bool = false;
                      }
                    }
                  }
                }
              }
              if (TextUtils.isEmpty(((g)localObject1).field_card_id)) {
                ac.e("MicroMsg.CardMsgManager", "card id == null");
              }
              localObject2 = ((g)localObject1).field_msg_id;
              ((g)localObject1).field_msg_id = str1;
              if (TextUtils.isEmpty(((g)localObject1).field_msg_id)) {
                ((g)localObject1).field_msg_id = ((String)localObject2);
              }
              if (TextUtils.isEmpty(((g)localObject1).field_msg_id)) {
                ((g)localObject1).field_msg_id = System.currentTimeMillis();
              }
              ac.i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + ((g)localObject1).field_msg_id);
              ac.i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + ((g)localObject1).field_msg_type);
              if (((g)localObject1).nWb != 0) {
                com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFj, Integer.valueOf(((g)localObject1).nWb));
              }
              ac.i("MicroMsg.CardMsgManager", "reddot_buff is " + ((g)localObject1).nVS);
              if (TextUtils.isEmpty(((g)localObject1).nVS)) {
                break label1962;
              }
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFf, ((g)localObject1).nVS);
              if ((((g)localObject1).field_msg_type & 0x1) != 0)
              {
                ac.i("MicroMsg.CardMsgManager", "msg_tips_title is " + ((g)localObject1).nVU);
                ac.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + ((g)localObject1).nVV);
                com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFh, ((g)localObject1).nVU);
                com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFi, ((g)localObject1).nVV);
              }
              if ((((g)localObject1).field_msg_type & 0x40) == 0) {
                break label1973;
              }
              com.tencent.mm.y.c.aeH().w(262152, true);
            }
            label1725:
            for (int i = 1;; i = 0)
            {
              if (i != 0)
              {
                ac.i("MicroMsg.CardMsgManager", "has card new msg, return");
                label1739:
                if ((((g)localObject1).field_msg_type & 0x1) != 0)
                {
                  if (localk.UB(((g)localObject1).field_msg_id)) {
                    break label2652;
                  }
                  localk.nUj.add(localObject1);
                  com.tencent.mm.plugin.card.b.k.c((g)localObject1);
                  if ((((g)localObject1).field_msg_type & 0x80) != 0) {
                    localk.nUk += 1;
                  }
                }
              }
              for (;;)
              {
                com.tencent.mm.kernel.g.agR().agA().set(139268, Integer.valueOf(localk.nUk));
                localk.a((g)localObject1);
                if ((((g)localObject1).field_msg_type & 0x2) != 0)
                {
                  am.bQh();
                  com.tencent.mm.plugin.card.b.b.zF(((g)localObject1).nWb);
                }
                if ((((g)localObject1).field_msg_type & 0x4) != 0) {
                  localk.onChange();
                }
                if ((((g)localObject1).field_msg_type & 0x8) != 0) {
                  am.bQo().G(((g)localObject1).field_card_id, ((g)localObject1).field_card_tp_id, ((g)localObject1).field_report_scene);
                }
                if ((((g)localObject1).field_msg_type & 0x400) != 0)
                {
                  ((g)localObject1).bQd();
                  am.bQy().b((g)localObject1);
                }
                if (((((g)localObject1).field_msg_type & 0x1000) != 0) && (((g)localObject1).field_need_pull_card_entrance))
                {
                  localObject1 = com.tencent.mm.plugin.card.model.a.e.nXM;
                  e.a.bQE();
                }
                com.tencent.mm.plugin.card.d.l.bTV();
                AppMethodBeat.o(112877);
                return;
                ac.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
                break;
                if ((((g)localObject1).field_msg_type & 0x4000) == 0) {
                  break label2716;
                }
                com.tencent.mm.y.c.aeH().w(262152, true);
                if ((((g)localObject1).field_msg_type & 0x10000) != 0) {
                  break label1725;
                }
                com.tencent.mm.y.c.aeH().cI(262152, 266241);
                break label1725;
                ac.i("MicroMsg.CardMsgManager", "not has new!");
                int j;
                if ((((g)localObject1).field_msg_type & 0x20) != 0)
                {
                  com.tencent.mm.y.c.aeH().x(262152, true);
                  ac.i("MicroMsg.CardMsgManager", "has reddot");
                  i = 1;
                  if (TextUtils.isEmpty(((g)localObject1).nVR)) {
                    break label2396;
                  }
                  ac.i("MicroMsg.CardMsgManager", "reddot_wording is " + ((g)localObject1).nVR);
                  com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFd, ((g)localObject1).nVR);
                  com.tencent.mm.y.c.aeH().a(ah.a.GEX, true);
                  j = 1;
                  label2127:
                  ac.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + ((g)localObject1).nVT);
                  if (TextUtils.isEmpty(((g)localObject1).nVT)) {
                    break label2409;
                  }
                  com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFg, ((g)localObject1).nVT);
                  com.tencent.mm.y.c.aeH().a(ah.a.GEY, true);
                  if ((i == 0) || (j == 0) || (k == 0))
                  {
                    if ((i == 0) || (j == 0) || (k != 0)) {
                      break label2422;
                    }
                    com.tencent.mm.y.c.aeH().a(ah.a.GEY, false);
                    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFg, "");
                  }
                }
                for (;;)
                {
                  if ((i == 0) && (j == 0) && (k == 0)) {
                    break label2650;
                  }
                  com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFu, ((g)localObject1).field_card_id);
                  com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFv, Boolean.valueOf(((g)localObject1).nVW));
                  ac.i("MicroMsg.CardMsgManager", "card_id:" + ((g)localObject1).field_card_id + "  need_check:" + ((g)localObject1).nVW);
                  break;
                  if ((((g)localObject1).field_msg_type & 0x2000) != 0)
                  {
                    com.tencent.mm.y.c.aeH().x(262152, true);
                    if ((((g)localObject1).field_msg_type & 0x10000) == 0) {
                      com.tencent.mm.y.c.aeH().cI(262152, 266241);
                    }
                    i = 1;
                    break label2061;
                  }
                  ac.e("MicroMsg.CardMsgManager", "not has reddot!");
                  i = 0;
                  break label2061;
                  label2396:
                  ac.e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
                  j = 0;
                  break label2127;
                  label2409:
                  ac.e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
                  k = 0;
                  break label2191;
                  label2422:
                  if ((i != 0) && (j == 0) && (k != 0))
                  {
                    com.tencent.mm.y.c.aeH().a(ah.a.GEX, false);
                    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFd, "");
                  }
                  else if ((i == 0) && (j != 0) && (k != 0))
                  {
                    com.tencent.mm.y.c.aeH().x(262152, false);
                  }
                  else if ((i != 0) && (j == 0) && (k == 0))
                  {
                    com.tencent.mm.y.c.aeH().a(ah.a.GEY, false);
                    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFg, "");
                    com.tencent.mm.y.c.aeH().a(ah.a.GEX, false);
                    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFd, "");
                  }
                  else if ((i == 0) && (j != 0) && (k == 0))
                  {
                    com.tencent.mm.y.c.aeH().a(ah.a.GEY, false);
                    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFg, "");
                    com.tencent.mm.y.c.aeH().x(262152, false);
                  }
                  else if ((i == 0) && (j == 0) && (k != 0))
                  {
                    com.tencent.mm.y.c.aeH().a(ah.a.GEX, false);
                    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFd, "");
                    com.tencent.mm.y.c.aeH().x(262152, false);
                  }
                }
                label2650:
                break label1739;
                label2652:
                ac.e("MicroMsg.CardMsgManager", "msg for id " + ((g)localObject1).field_msg_id + " is exist!!");
                localk.UC(((g)localObject1).field_msg_id);
                localk.nUj.add(localObject1);
                com.tencent.mm.plugin.card.b.k.c((g)localObject1);
              }
            }
          }
        });
        AppMethodBeat.o(112878);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.nXx = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(112880);
        final String str = z.a(paramAnonymousa.fXi.DPV);
        if ((str == null) || (str.length() == 0))
        {
          ac.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
          AppMethodBeat.o(112880);
          return;
        }
        am.a(am.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(112879);
            Object localObject1 = am.bQs();
            Object localObject2 = str;
            ac.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is ".concat(String.valueOf(paramAnonymousa.fXi.vTQ)));
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject2 = bv.L((String)localObject2, "sysmsg");
              if (localObject2 == null)
              {
                localObject1 = null;
                if (localObject1 == null)
                {
                  ac.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
                  AppMethodBeat.o(112879);
                }
              }
              else
              {
                localObject1 = new c.a((com.tencent.mm.plugin.card.sharecard.a.c)localObject1);
                String str = (String)((Map)localObject2).get(".sysmsg.notifysharecard.state_flag");
                if ((!TextUtils.isEmpty(str)) && (com.tencent.mm.plugin.card.d.l.isNumeric(str))) {}
                for (((c.a)localObject1).nYh = bs.getInt(str, 0);; ((c.a)localObject1).nYh = 0)
                {
                  ((c.a)localObject1).username = ((String)((Map)localObject2).get(".sysmsg.notifysharecard.username"));
                  ((c.a)localObject1).dvO = ((String)((Map)localObject2).get(".sysmsg.notifysharecard.card_id"));
                  break;
                }
              }
              if (TextUtils.isEmpty(((c.a)localObject1).dvO)) {
                ac.e("MicroMsg.ShareCardMsgMgr", "card id == null");
              }
              ac.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + ((c.a)localObject1).dvO);
              am.bQp().bQJ();
              com.tencent.mm.plugin.card.d.l.bTX();
            }
            AppMethodBeat.o(112879);
          }
        });
        AppMethodBeat.o(112880);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.nXy = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(jn paramAnonymousjn)
      {
        AppMethodBeat.i(112874);
        int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GSr, Integer.valueOf(1))).intValue();
        int j = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GSu, Integer.valueOf(1))).intValue();
        boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GSw, Boolean.FALSE)).booleanValue();
        ac.i("MicroMsg.SubCoreCard", "goto card version: %s, trade area: %s, newVersion2: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
        Object localObject;
        Context localContext;
        if (bool) {
          if (paramAnonymousjn.dlb.context != null)
          {
            localObject = new Intent(paramAnonymousjn.dlb.context, CardHomePageV3UI.class);
            localContext = paramAnonymousjn.dlb.context;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.card.b.k.bPX();
            if (paramAnonymousjn.dlb.enterScene == 1) {
              com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(3) });
            }
          }
        }
        for (;;)
        {
          paramAnonymousjn = com.tencent.mm.plugin.card.model.a.e.nXM;
          e.a.bQE();
          AppMethodBeat.o(112874);
          return true;
          if (j == 2)
          {
            paramAnonymousjn = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GSv, "");
            if (!bs.isNullOrNil(paramAnonymousjn)) {
              try
              {
                paramAnonymousjn = (rm)new rm().parseFrom(paramAnonymousjn.getBytes(d.n.d.ISO_8859_1));
                com.tencent.mm.plugin.card.d.b.H(paramAnonymousjn.AZE, paramAnonymousjn.AZF, paramAnonymousjn.BGS);
              }
              catch (IOException paramAnonymousjn)
              {
                ac.printErrStackTrace("MicroMsg.SubCoreCard", paramAnonymousjn, "", new Object[0]);
              }
            }
          }
          else if (i == 1)
          {
            if (paramAnonymousjn.dlb.context != null)
            {
              localObject = new Intent(paramAnonymousjn.dlb.context, CardHomePageNewUI.class);
              localContext = paramAnonymousjn.dlb.context;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.card.b.k.bPX();
              if (paramAnonymousjn.dlb.enterScene == 1) {
                com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(3) });
              }
            }
          }
          else
          {
            if (paramAnonymousjn.dlb.context != null)
            {
              localObject = new Intent(paramAnonymousjn.dlb.context, CardHomePageUI.class);
              ((Intent)localObject).putExtra("key_from_scene", 22);
              ((Intent)localObject).putExtra("key_home_page_from_scene", paramAnonymousjn.dlb.scene);
              localContext = paramAnonymousjn.dlb.context;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/card/model/SubCoreCard$12", "callback", "(Lcom/tencent/mm/autogen/events/GotoCardHomePageEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.card.b.k.bPX();
              if (paramAnonymousjn.dlb.enterScene == 1) {
                com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(2) });
              }
            }
            paramAnonymousjn.dlc.targetActivity = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
          }
        }
      }
    };
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(m.nWl);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(m.nWm);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(112881);
  }
  
  public static com.tencent.mm.plugin.card.b.b bQh()
  {
    AppMethodBeat.i(112885);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nWY == null) {
      getCore().nWY = new com.tencent.mm.plugin.card.b.b();
    }
    com.tencent.mm.plugin.card.b.b localb = getCore().nWY;
    AppMethodBeat.o(112885);
    return localb;
  }
  
  public static c bQi()
  {
    AppMethodBeat.i(112886);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nWZ == null) {
      getCore().nWZ = new c(com.tencent.mm.kernel.g.agR().ghG);
    }
    c localc = getCore().nWZ;
    AppMethodBeat.o(112886);
    return localc;
  }
  
  public static al bQj()
  {
    AppMethodBeat.i(112887);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXa == null) {
      getCore().nXa = new al(com.tencent.mm.kernel.g.agR().ghG);
    }
    al localal = getCore().nXa;
    AppMethodBeat.o(112887);
    return localal;
  }
  
  public static h bQk()
  {
    AppMethodBeat.i(112888);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXb == null) {
      getCore().nXb = new h(com.tencent.mm.kernel.g.agR().ghG);
    }
    h localh = getCore().nXb;
    AppMethodBeat.o(112888);
    return localh;
  }
  
  public static com.tencent.mm.plugin.card.b.m bQl()
  {
    AppMethodBeat.i(112889);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXc == null) {
      getCore().nXc = new com.tencent.mm.plugin.card.b.m();
    }
    com.tencent.mm.plugin.card.b.m localm = getCore().nXc;
    AppMethodBeat.o(112889);
    return localm;
  }
  
  public static com.tencent.mm.plugin.card.b.k bQm()
  {
    AppMethodBeat.i(112890);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXh == null) {
      getCore().nXh = new com.tencent.mm.plugin.card.b.k();
    }
    com.tencent.mm.plugin.card.b.k localk = getCore().nXh;
    AppMethodBeat.o(112890);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.b.e bQn()
  {
    AppMethodBeat.i(112891);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXi == null) {
      getCore().nXi = new com.tencent.mm.plugin.card.b.e();
    }
    com.tencent.mm.plugin.card.b.e locale = getCore().nXi;
    AppMethodBeat.o(112891);
    return locale;
  }
  
  public static com.tencent.mm.plugin.card.b.l bQo()
  {
    AppMethodBeat.i(112892);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXj == null) {
      getCore().nXj = new com.tencent.mm.plugin.card.b.l();
    }
    com.tencent.mm.plugin.card.b.l locall = getCore().nXj;
    AppMethodBeat.o(112892);
    return locall;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.a bQp()
  {
    AppMethodBeat.i(112893);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXd == null) {
      getCore().nXd = new com.tencent.mm.plugin.card.sharecard.a.a();
    }
    com.tencent.mm.plugin.card.sharecard.a.a locala = getCore().nXd;
    AppMethodBeat.o(112893);
    return locala;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.k bQq()
  {
    AppMethodBeat.i(112894);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXe == null) {
      getCore().nXe = new com.tencent.mm.plugin.card.sharecard.model.k(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.plugin.card.sharecard.model.k localk = getCore().nXe;
    AppMethodBeat.o(112894);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.o bQr()
  {
    AppMethodBeat.i(112895);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXf == null) {
      getCore().nXf = new com.tencent.mm.plugin.card.sharecard.model.o(com.tencent.mm.kernel.g.agR().ghG);
    }
    com.tencent.mm.plugin.card.sharecard.model.o localo = getCore().nXf;
    AppMethodBeat.o(112895);
    return localo;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.c bQs()
  {
    AppMethodBeat.i(112896);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXg == null) {
      getCore().nXg = new com.tencent.mm.plugin.card.sharecard.a.c();
    }
    com.tencent.mm.plugin.card.sharecard.a.c localc = getCore().nXg;
    AppMethodBeat.o(112896);
    return localc;
  }
  
  public static com.tencent.mm.plugin.card.b.d bQt()
  {
    AppMethodBeat.i(112897);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXk == null) {
      getCore().nXk = new com.tencent.mm.plugin.card.b.d();
    }
    com.tencent.mm.plugin.card.b.d locald = getCore().nXk;
    AppMethodBeat.o(112897);
    return locald;
  }
  
  public static com.tencent.mm.plugin.card.b.j bQu()
  {
    AppMethodBeat.i(112898);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXl == null) {
      getCore().nXl = new com.tencent.mm.plugin.card.b.j();
    }
    com.tencent.mm.plugin.card.b.j localj = getCore().nXl;
    AppMethodBeat.o(112898);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.c bQv()
  {
    AppMethodBeat.i(112899);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXm == null) {
      getCore().nXm = new com.tencent.mm.plugin.card.b.c();
    }
    com.tencent.mm.plugin.card.b.c localc = getCore().nXm;
    AppMethodBeat.o(112899);
    return localc;
  }
  
  public static l bQw()
  {
    AppMethodBeat.i(112900);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXo == null) {
      getCore().nXo = new l(com.tencent.mm.kernel.g.agR().ghG);
    }
    l locall = getCore().nXo;
    AppMethodBeat.o(112900);
    return locall;
  }
  
  public static j bQx()
  {
    AppMethodBeat.i(112901);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXp == null) {
      getCore().nXp = new j(com.tencent.mm.kernel.g.agR().ghG);
    }
    j localj = getCore().nXp;
    AppMethodBeat.o(112901);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.g bQy()
  {
    AppMethodBeat.i(112902);
    com.tencent.mm.kernel.g.agP().afT();
    if (getCore().nXn == null) {
      getCore().nXn = new com.tencent.mm.plugin.card.b.g();
    }
    com.tencent.mm.plugin.card.b.g localg = getCore().nXn;
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
    ac.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.sdk.b.a.GpY.c(this.nXu);
    com.tencent.mm.sdk.b.a.GpY.c(this.nXv);
    com.tencent.mm.sdk.b.a.GpY.c(this.nXq);
    com.tencent.mm.sdk.b.a.GpY.c(this.nXr);
    com.tencent.mm.sdk.b.a.GpY.c(this.nXs);
    com.tencent.mm.sdk.b.a.GpY.c(this.nXy);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("carditemmsg", this.nXw, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("notifysharecard", this.nXx, true);
    this.nXh = null;
    if (this.nXi != null)
    {
      this.nXi.nTs.clear();
      this.nXi = null;
    }
    if (this.nXc != null) {
      ??? = this.nXc;
    }
    synchronized (((com.tencent.mm.plugin.card.b.m)???).nUl)
    {
      ((com.tencent.mm.plugin.card.b.m)???).nUl.clear();
      synchronized (((com.tencent.mm.plugin.card.b.m)???).nUm)
      {
        ((com.tencent.mm.plugin.card.b.m)???).nUm.clear();
        com.tencent.mm.kernel.g.agQ().ghe.b(1058, (com.tencent.mm.ak.g)???);
        ??? = com.tencent.mm.modelgeo.d.aEL();
        if (??? != null) {
          ((com.tencent.mm.modelgeo.b)???).c((b.a)???);
        }
        if (((com.tencent.mm.plugin.card.b.m)???).nUo != null) {
          com.tencent.mm.kernel.g.agQ().ghe.a(((com.tencent.mm.plugin.card.b.m)???).nUo);
        }
        this.nXc = null;
        if (this.nWY != null)
        {
          this.nWY.detach();
          this.nWY = null;
        }
        if (this.nXd != null) {
          ??? = this.nXd;
        }
      }
    }
    synchronized (((com.tencent.mm.plugin.card.sharecard.a.a)???).lock)
    {
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).pendingList.clear();
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).nSY.clear();
      if (((com.tencent.mm.plugin.card.sharecard.a.a)???).nXX != null) {
        com.tencent.mm.kernel.g.agQ().ghe.a(((com.tencent.mm.plugin.card.sharecard.a.a)???).nXX);
      }
      com.tencent.mm.kernel.g.agQ().ghe.b(1132, (com.tencent.mm.ak.g)???);
      this.nXd = null;
      if (this.nXk != null)
      {
        this.nXk.release();
        ??? = this.nXk;
        ((com.tencent.mm.plugin.card.b.d)???).nTa.clear();
        ((com.tencent.mm.plugin.card.b.d)???).nTm.clear();
        ((com.tencent.mm.plugin.card.b.d)???).nTn.clear();
        ((com.tencent.mm.plugin.card.b.d)???).nTo.clear();
        ((com.tencent.mm.plugin.card.b.d)???).nTq = false;
        this.nXk = null;
      }
      if (this.nXl == null) {
        break label573;
      }
      ??? = this.nXl;
      com.tencent.mm.kernel.g.agQ().ghe.b(1078, (com.tencent.mm.ak.g)???);
      ??? = ((com.tencent.mm.plugin.card.b.j)???).nTX.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        Runnable localRunnable = (Runnable)((com.tencent.mm.plugin.card.b.j)???).nTZ.get(str);
        ((com.tencent.mm.plugin.card.b.j)???).nTZ.remove(str);
        ((com.tencent.mm.plugin.card.b.j)???).nTY.removeCallbacks(localRunnable);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(112883);
        throw localObject2;
        localObject3 = finally;
        AppMethodBeat.o(112883);
        throw localObject3;
      }
    }
    localObject3.nTW.clear();
    localObject3.nTX.clear();
    localObject3.nTZ.clear();
    this.nXl = null;
    label573:
    if (this.nXm != null)
    {
      this.nXm.release();
      this.nXm = null;
    }
    if (this.nXn != null)
    {
      this.nXn.release();
      this.nXn = null;
    }
    this.nXj = null;
    com.tencent.mm.plugin.card.ui.b localb = this.nXt;
    com.tencent.mm.plugin.card.ui.b.buZ().registerActivityLifecycleCallbacks(localb);
    if (paramBoolean) {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GSr, Integer.valueOf(1));
    }
    AppMethodBeat.o(112883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(112884);
    if (getCore().nWY != null) {
      getCore().nWY.detach();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.nXu);
    com.tencent.mm.sdk.b.a.GpY.d(this.nXv);
    com.tencent.mm.sdk.b.a.GpY.d(this.nXq);
    com.tencent.mm.sdk.b.a.GpY.d(this.nXr);
    com.tencent.mm.sdk.b.a.GpY.d(this.nXs);
    com.tencent.mm.sdk.b.a.GpY.d(this.nXy);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("carditemmsg", this.nXw, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("notifysharecard", this.nXx, true);
    com.tencent.mm.plugin.card.ui.b localb = this.nXt;
    com.tencent.mm.plugin.card.ui.b.buZ().unregisterActivityLifecycleCallbacks(localb);
    AppMethodBeat.o(112884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am
 * JD-Core Version:    0.7.0.1
 */