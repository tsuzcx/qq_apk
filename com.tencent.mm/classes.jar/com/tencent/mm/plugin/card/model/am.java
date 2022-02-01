package com.tencent.mm.plugin.card.model;

import android.app.Application;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.ji.a;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.PluginCard;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.plugin.card.model.a.e.a;
import com.tencent.mm.plugin.card.sharecard.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class am
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private MMHandler mHandler;
  private com.tencent.mm.plugin.card.b.b pUA;
  private c pUB;
  private al pUC;
  private h pUD;
  private com.tencent.mm.plugin.card.b.m pUE;
  private com.tencent.mm.plugin.card.sharecard.a.a pUF;
  private com.tencent.mm.plugin.card.sharecard.model.k pUG;
  private com.tencent.mm.plugin.card.sharecard.model.o pUH;
  private com.tencent.mm.plugin.card.sharecard.a.c pUI;
  private com.tencent.mm.plugin.card.b.k pUJ;
  private com.tencent.mm.plugin.card.b.e pUK;
  private com.tencent.mm.plugin.card.b.l pUL;
  private com.tencent.mm.plugin.card.b.d pUM;
  private com.tencent.mm.plugin.card.b.j pUN;
  private com.tencent.mm.plugin.card.b.c pUO;
  private com.tencent.mm.plugin.card.b.g pUP;
  private l pUQ;
  private j pUR;
  private IListener pUS;
  private IListener pUT;
  private IListener pUU;
  private com.tencent.mm.plugin.card.ui.b pUV;
  private IListener pUW;
  private IListener pUX;
  private cj.a pUY;
  private cj.a pUZ;
  private IListener<kl> pVa;
  
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
    this.pUJ = null;
    this.pUK = null;
    this.pUL = null;
    this.pUM = null;
    this.pUN = null;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.pUS = new n();
    this.pUT = new com.tencent.mm.plugin.card.b.o();
    this.pUU = new com.tencent.mm.plugin.card.b.a();
    this.pUV = new com.tencent.mm.plugin.card.ui.b();
    this.pUW = new IListener() {};
    this.pUX = new am.5(this);
    this.pUY = new cj.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(112878);
        final String str = z.a(paramAnonymousa.heO.KHn);
        if ((str == null) || (str.length() == 0))
        {
          Log.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
          AppMethodBeat.o(112878);
          return;
        }
        am.a(am.this).post(new Runnable()
        {
          public final void run()
          {
            int k = 1;
            AppMethodBeat.i(112877);
            com.tencent.mm.plugin.card.b.k localk = am.ctU();
            Object localObject1 = str;
            String str1 = paramAnonymousa.heO.Brn;
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
                      localObject3 = new tw();
                      ((tw)localObject3).text = str2;
                      ((tw)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.button.url"));
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.action_type");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                        break label1211;
                      }
                      ((tw)localObject3).pTI = Util.getInt(str2, 0);
                      label516:
                      ((g)localObject1).pTA = ((tw)localObject3);
                    }
                  }
                  try
                  {
                    ((g)localObject1).field_buttonData = ((g)localObject1).pTA.toByteArray();
                    str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.text");
                    if (!TextUtils.isEmpty(str2))
                    {
                      localObject3 = new uo();
                      ((uo)localObject3).text = str2;
                      ((uo)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.url"));
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.type");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                        break label1261;
                      }
                      ((uo)localObject3).type = Util.getInt(str2, 0);
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.endtime");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.d.l.isNumeric(str2))) {
                        break label1284;
                      }
                      if (Long.valueOf(str2).longValue() < 2147483647L) {
                        break label1270;
                      }
                      ((uo)localObject3).DhD = 2147483647;
                      ((g)localObject1).pTB = ((uo)localObject3);
                    }
                  }
                  catch (Exception localException1)
                  {
                    try
                    {
                      for (;;)
                      {
                        ((g)localObject1).field_operData = ((g)localObject1).pTB.toByteArray();
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.report_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                          break label1341;
                        }
                        ((g)localObject1).field_report_scene = Util.getInt((String)localObject3, 0);
                        ((g)localObject1).field_read_state = 1;
                        ((g)localObject1).field_accept_buttons = com.tencent.mm.plugin.card.b.k.i((Map)localObject2, ".sysmsg.carditemmsg");
                        ((g)localObject1).field_jump_buttons = com.tencent.mm.plugin.card.b.k.h((Map)localObject2, ".sysmsg.carditemmsg");
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.get_layout_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                          break label1350;
                        }
                        ((g)localObject1).pTE = Util.getInt((String)localObject3, 0);
                        ((g)localObject1).field_consumed_box_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.consumed_box_id"));
                        ((g)localObject1).pTu = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_wording"));
                        ((g)localObject1).pTv = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_buff"));
                        ((g)localObject1).pTw = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_icon_url"));
                        ((g)localObject1).pTx = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.title"));
                        ((g)localObject1).pTy = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.icon_url"));
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject3))) {
                          break label1359;
                        }
                        ((g)localObject1).pTF = Util.getInt((String)localObject3, 0);
                        Log.i("MicroMsg.CardMsgManager", "msg_scene is ".concat(String.valueOf(localObject3)));
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.need_check");
                        Log.i("MicroMsg.CardMsgManager", "need_check:".concat(String.valueOf(localObject3)));
                        if (TextUtils.isEmpty((CharSequence)localObject3)) {
                          break label1368;
                        }
                        ((g)localObject1).pTz = ((String)localObject3).equals("true");
                        str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.all_unavailable");
                        Log.i("MicroMsg.CardMsgManager", "all_Unavailable:".concat(String.valueOf(localObject3)));
                        if (TextUtils.isEmpty(str2)) {
                          break label1377;
                        }
                        ((g)localObject1).pTG = str2.equals("true");
                        ((g)localObject1).field_unavailable_qr_code_list = com.tencent.mm.plugin.card.b.k.j((Map)localObject2, ".sysmsg.carditemmsg");
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
                        ((tw)localObject3).pTI = 0;
                        break label516;
                        localException1 = localException1;
                        Log.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[] { localException1.getMessage() });
                        Log.printErrStackTrace("MicroMsg.CardMsgInfo", localException1, "", new Object[0]);
                        continue;
                        label1261:
                        localException1.type = 0;
                        continue;
                        label1270:
                        localException1.DhD = Util.getInt(str2, 0);
                      }
                      label1284:
                      localException1.DhD = ((int)(System.currentTimeMillis() / 1000L));
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
                        ((g)localObject1).pTE = 0;
                        continue;
                        label1359:
                        ((g)localObject1).pTF = 0;
                        continue;
                        label1368:
                        ((g)localObject1).pTz = false;
                        continue;
                        label1377:
                        ((g)localObject1).pTG = false;
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
              if (((g)localObject1).pTE != 0) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTZ, Integer.valueOf(((g)localObject1).pTE));
              }
              Log.i("MicroMsg.CardMsgManager", "reddot_buff is " + ((g)localObject1).pTv);
              if (TextUtils.isEmpty(((g)localObject1).pTv)) {
                break label1963;
              }
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTV, ((g)localObject1).pTv);
              if ((((g)localObject1).field_msg_type & 0x1) != 0)
              {
                Log.i("MicroMsg.CardMsgManager", "msg_tips_title is " + ((g)localObject1).pTx);
                Log.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + ((g)localObject1).pTy);
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTX, ((g)localObject1).pTx);
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTY, ((g)localObject1).pTy);
              }
              if ((((g)localObject1).field_msg_type & 0x40) == 0) {
                break label1974;
              }
              com.tencent.mm.y.c.axV().A(262152, true);
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
                  if (localk.ajg(((g)localObject1).field_msg_id)) {
                    break label2653;
                  }
                  localk.pRP.add(localObject1);
                  com.tencent.mm.plugin.card.b.k.c((g)localObject1);
                  if ((((g)localObject1).field_msg_type & 0x80) != 0) {
                    localk.pRQ += 1;
                  }
                }
              }
              for (;;)
              {
                com.tencent.mm.kernel.g.aAh().azQ().set(139268, Integer.valueOf(localk.pRQ));
                localk.a((g)localObject1);
                if ((((g)localObject1).field_msg_type & 0x2) != 0)
                {
                  am.ctP();
                  com.tencent.mm.plugin.card.b.b.Ef(((g)localObject1).pTE);
                }
                if ((((g)localObject1).field_msg_type & 0x4) != 0) {
                  localk.onChange();
                }
                if ((((g)localObject1).field_msg_type & 0x8) != 0) {
                  am.ctW().G(((g)localObject1).field_card_id, ((g)localObject1).field_card_tp_id, ((g)localObject1).field_report_scene);
                }
                if ((((g)localObject1).field_msg_type & 0x400) != 0)
                {
                  ((g)localObject1).ctL();
                  am.cug().b((g)localObject1);
                }
                if (((((g)localObject1).field_msg_type & 0x1000) != 0) && (((g)localObject1).field_need_pull_card_entrance))
                {
                  localObject1 = com.tencent.mm.plugin.card.model.a.e.pVr;
                  e.a.cup();
                }
                com.tencent.mm.plugin.card.d.l.cxE();
                AppMethodBeat.o(112877);
                return;
                Log.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
                break;
                if ((((g)localObject1).field_msg_type & 0x4000) == 0) {
                  break label2717;
                }
                com.tencent.mm.y.c.axV().A(262152, true);
                if ((((g)localObject1).field_msg_type & 0x10000) != 0) {
                  break label1726;
                }
                com.tencent.mm.y.c.axV().cQ(262152, 266241);
                break label1726;
                Log.i("MicroMsg.CardMsgManager", "not has new!");
                int j;
                if ((((g)localObject1).field_msg_type & 0x20) != 0)
                {
                  com.tencent.mm.y.c.axV().B(262152, true);
                  Log.i("MicroMsg.CardMsgManager", "has reddot");
                  i = 1;
                  if (TextUtils.isEmpty(((g)localObject1).pTu)) {
                    break label2397;
                  }
                  Log.i("MicroMsg.CardMsgManager", "reddot_wording is " + ((g)localObject1).pTu);
                  com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTT, ((g)localObject1).pTu);
                  com.tencent.mm.y.c.axV().a(ar.a.NTN, true);
                  j = 1;
                  label2128:
                  Log.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + ((g)localObject1).pTw);
                  if (TextUtils.isEmpty(((g)localObject1).pTw)) {
                    break label2410;
                  }
                  com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTW, ((g)localObject1).pTw);
                  com.tencent.mm.y.c.axV().a(ar.a.NTO, true);
                  if ((i == 0) || (j == 0) || (k == 0))
                  {
                    if ((i == 0) || (j == 0) || (k != 0)) {
                      break label2423;
                    }
                    com.tencent.mm.y.c.axV().a(ar.a.NTO, false);
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTW, "");
                  }
                }
                for (;;)
                {
                  if ((i == 0) && (j == 0) && (k == 0)) {
                    break label2651;
                  }
                  com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NUk, ((g)localObject1).field_card_id);
                  com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NUl, Boolean.valueOf(((g)localObject1).pTz));
                  Log.i("MicroMsg.CardMsgManager", "card_id:" + ((g)localObject1).field_card_id + "  need_check:" + ((g)localObject1).pTz);
                  break;
                  if ((((g)localObject1).field_msg_type & 0x2000) != 0)
                  {
                    com.tencent.mm.y.c.axV().B(262152, true);
                    if ((((g)localObject1).field_msg_type & 0x10000) == 0) {
                      com.tencent.mm.y.c.axV().cQ(262152, 266241);
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
                    com.tencent.mm.y.c.axV().a(ar.a.NTN, false);
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTT, "");
                  }
                  else if ((i == 0) && (j != 0) && (k != 0))
                  {
                    com.tencent.mm.y.c.axV().B(262152, false);
                  }
                  else if ((i != 0) && (j == 0) && (k == 0))
                  {
                    com.tencent.mm.y.c.axV().a(ar.a.NTO, false);
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTW, "");
                    com.tencent.mm.y.c.axV().a(ar.a.NTN, false);
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTT, "");
                  }
                  else if ((i == 0) && (j != 0) && (k == 0))
                  {
                    com.tencent.mm.y.c.axV().a(ar.a.NTO, false);
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTW, "");
                    com.tencent.mm.y.c.axV().B(262152, false);
                  }
                  else if ((i == 0) && (j == 0) && (k != 0))
                  {
                    com.tencent.mm.y.c.axV().a(ar.a.NTN, false);
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTT, "");
                    com.tencent.mm.y.c.axV().B(262152, false);
                  }
                }
                label2651:
                break label1740;
                label2653:
                Log.e("MicroMsg.CardMsgManager", "msg for id " + ((g)localObject1).field_msg_id + " is exist!!");
                localk.ajh(((g)localObject1).field_msg_id);
                localk.pRP.add(localObject1);
                com.tencent.mm.plugin.card.b.k.c((g)localObject1);
              }
            }
          }
        });
        AppMethodBeat.o(112878);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.pUZ = new cj.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(112880);
        final String str = z.a(paramAnonymousa.heO.KHn);
        if ((str == null) || (str.length() == 0))
        {
          Log.e("MicroMsg.SubCoreCard.notifyShareCardListener", "onReceiveMsg, msgContent is null");
          AppMethodBeat.o(112880);
          return;
        }
        am.a(am.this).post(new Runnable()
        {
          public final void run()
          {
            c.a locala = null;
            AppMethodBeat.i(112879);
            Object localObject2 = am.cua();
            Object localObject1 = str;
            Log.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is ".concat(String.valueOf(paramAnonymousa.heO.Brn)));
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
              if (localObject1 == null)
              {
                if (locala == null)
                {
                  Log.e("MicroMsg.ShareCardMsgMgr", "card msg == null");
                  AppMethodBeat.o(112879);
                }
              }
              else
              {
                locala = new c.a((com.tencent.mm.plugin.card.sharecard.a.c)localObject2);
                localObject2 = (String)((Map)localObject1).get(".sysmsg.notifysharecard.state_flag");
                if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (com.tencent.mm.plugin.card.d.l.isNumeric((String)localObject2))) {}
                for (locala.pVR = Util.getInt((String)localObject2, 0);; locala.pVR = 0)
                {
                  locala.username = ((String)((Map)localObject1).get(".sysmsg.notifysharecard.username"));
                  locala.eaO = ((String)((Map)localObject1).get(".sysmsg.notifysharecard.card_id"));
                  break;
                }
              }
              if (TextUtils.isEmpty(locala.eaO)) {
                Log.e("MicroMsg.ShareCardMsgMgr", "card id == null");
              }
              Log.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + locala.eaO);
              am.ctX().cuu();
              com.tencent.mm.plugin.card.d.l.cxG();
            }
            AppMethodBeat.o(112879);
          }
        });
        AppMethodBeat.o(112880);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.pVa = new am.4(this);
    com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(m.pTN);
    if (!localo.exists()) {
      localo.mkdirs();
    }
    localo = new com.tencent.mm.vfs.o(m.pTO);
    if (!localo.exists()) {
      localo.mkdirs();
    }
    AppMethodBeat.o(112881);
  }
  
  public static com.tencent.mm.plugin.card.b.b ctP()
  {
    AppMethodBeat.i(112885);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUA == null) {
      getCore().pUA = new com.tencent.mm.plugin.card.b.b();
    }
    com.tencent.mm.plugin.card.b.b localb = getCore().pUA;
    AppMethodBeat.o(112885);
    return localb;
  }
  
  public static c ctQ()
  {
    AppMethodBeat.i(112886);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUB == null) {
      getCore().pUB = new c(com.tencent.mm.kernel.g.aAh().hqK);
    }
    c localc = getCore().pUB;
    AppMethodBeat.o(112886);
    return localc;
  }
  
  public static al ctR()
  {
    AppMethodBeat.i(112887);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUC == null) {
      getCore().pUC = new al(com.tencent.mm.kernel.g.aAh().hqK);
    }
    al localal = getCore().pUC;
    AppMethodBeat.o(112887);
    return localal;
  }
  
  public static h ctS()
  {
    AppMethodBeat.i(112888);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUD == null) {
      getCore().pUD = new h(com.tencent.mm.kernel.g.aAh().hqK);
    }
    h localh = getCore().pUD;
    AppMethodBeat.o(112888);
    return localh;
  }
  
  public static com.tencent.mm.plugin.card.b.m ctT()
  {
    AppMethodBeat.i(112889);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUE == null) {
      getCore().pUE = new com.tencent.mm.plugin.card.b.m();
    }
    com.tencent.mm.plugin.card.b.m localm = getCore().pUE;
    AppMethodBeat.o(112889);
    return localm;
  }
  
  public static com.tencent.mm.plugin.card.b.k ctU()
  {
    AppMethodBeat.i(112890);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUJ == null) {
      getCore().pUJ = new com.tencent.mm.plugin.card.b.k();
    }
    com.tencent.mm.plugin.card.b.k localk = getCore().pUJ;
    AppMethodBeat.o(112890);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.b.e ctV()
  {
    AppMethodBeat.i(112891);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUK == null) {
      getCore().pUK = new com.tencent.mm.plugin.card.b.e();
    }
    com.tencent.mm.plugin.card.b.e locale = getCore().pUK;
    AppMethodBeat.o(112891);
    return locale;
  }
  
  public static com.tencent.mm.plugin.card.b.l ctW()
  {
    AppMethodBeat.i(112892);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUL == null) {
      getCore().pUL = new com.tencent.mm.plugin.card.b.l();
    }
    com.tencent.mm.plugin.card.b.l locall = getCore().pUL;
    AppMethodBeat.o(112892);
    return locall;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.a ctX()
  {
    AppMethodBeat.i(112893);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUF == null) {
      getCore().pUF = new com.tencent.mm.plugin.card.sharecard.a.a();
    }
    com.tencent.mm.plugin.card.sharecard.a.a locala = getCore().pUF;
    AppMethodBeat.o(112893);
    return locala;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.k ctY()
  {
    AppMethodBeat.i(112894);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUG == null) {
      getCore().pUG = new com.tencent.mm.plugin.card.sharecard.model.k(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.plugin.card.sharecard.model.k localk = getCore().pUG;
    AppMethodBeat.o(112894);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.o ctZ()
  {
    AppMethodBeat.i(112895);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUH == null) {
      getCore().pUH = new com.tencent.mm.plugin.card.sharecard.model.o(com.tencent.mm.kernel.g.aAh().hqK);
    }
    com.tencent.mm.plugin.card.sharecard.model.o localo = getCore().pUH;
    AppMethodBeat.o(112895);
    return localo;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.c cua()
  {
    AppMethodBeat.i(112896);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUI == null) {
      getCore().pUI = new com.tencent.mm.plugin.card.sharecard.a.c();
    }
    com.tencent.mm.plugin.card.sharecard.a.c localc = getCore().pUI;
    AppMethodBeat.o(112896);
    return localc;
  }
  
  public static com.tencent.mm.plugin.card.b.d cub()
  {
    AppMethodBeat.i(112897);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUM == null) {
      getCore().pUM = new com.tencent.mm.plugin.card.b.d();
    }
    com.tencent.mm.plugin.card.b.d locald = getCore().pUM;
    AppMethodBeat.o(112897);
    return locald;
  }
  
  public static com.tencent.mm.plugin.card.b.j cuc()
  {
    AppMethodBeat.i(112898);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUN == null) {
      getCore().pUN = new com.tencent.mm.plugin.card.b.j();
    }
    com.tencent.mm.plugin.card.b.j localj = getCore().pUN;
    AppMethodBeat.o(112898);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.c cud()
  {
    AppMethodBeat.i(112899);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUO == null) {
      getCore().pUO = new com.tencent.mm.plugin.card.b.c();
    }
    com.tencent.mm.plugin.card.b.c localc = getCore().pUO;
    AppMethodBeat.o(112899);
    return localc;
  }
  
  public static l cue()
  {
    AppMethodBeat.i(112900);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUQ == null) {
      getCore().pUQ = new l(com.tencent.mm.kernel.g.aAh().hqK);
    }
    l locall = getCore().pUQ;
    AppMethodBeat.o(112900);
    return locall;
  }
  
  public static j cuf()
  {
    AppMethodBeat.i(112901);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUR == null) {
      getCore().pUR = new j(com.tencent.mm.kernel.g.aAh().hqK);
    }
    j localj = getCore().pUR;
    AppMethodBeat.o(112901);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.b.g cug()
  {
    AppMethodBeat.i(112902);
    com.tencent.mm.kernel.g.aAf().azk();
    if (getCore().pUP == null) {
      getCore().pUP = new com.tencent.mm.plugin.card.b.g();
    }
    com.tencent.mm.plugin.card.b.g localg = getCore().pUP;
    AppMethodBeat.o(112902);
    return localg;
  }
  
  private static am getCore()
  {
    AppMethodBeat.i(112882);
    Object localObject = (com.tencent.mm.plugin.card.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.card.a.a.class);
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
    Log.i("MicroMsg.SubCoreCard", "onAccountPostReset, updated = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    EventCenter.instance.addListener(this.pUW);
    EventCenter.instance.addListener(this.pUX);
    EventCenter.instance.addListener(this.pUS);
    EventCenter.instance.addListener(this.pUT);
    EventCenter.instance.addListener(this.pUU);
    EventCenter.instance.addListener(this.pVa);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("carditemmsg", this.pUY, true);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("notifysharecard", this.pUZ, true);
    this.pUJ = null;
    if (this.pUK != null)
    {
      this.pUK.pQY.clear();
      this.pUK = null;
    }
    if (this.pUE != null) {
      ??? = this.pUE;
    }
    synchronized (((com.tencent.mm.plugin.card.b.m)???).pRR)
    {
      ((com.tencent.mm.plugin.card.b.m)???).pRR.clear();
      synchronized (((com.tencent.mm.plugin.card.b.m)???).pRS)
      {
        ((com.tencent.mm.plugin.card.b.m)???).pRS.clear();
        com.tencent.mm.kernel.g.aAg().hqi.b(1058, (i)???);
        ??? = com.tencent.mm.modelgeo.d.bca();
        if (??? != null) {
          ((com.tencent.mm.modelgeo.b)???).c((b.a)???);
        }
        if (((com.tencent.mm.plugin.card.b.m)???).pRU != null) {
          com.tencent.mm.kernel.g.aAg().hqi.a(((com.tencent.mm.plugin.card.b.m)???).pRU);
        }
        this.pUE = null;
        if (this.pUA != null)
        {
          this.pUA.detach();
          this.pUA = null;
        }
        if (this.pUF != null) {
          ??? = this.pUF;
        }
      }
    }
    synchronized (((com.tencent.mm.plugin.card.sharecard.a.a)???).lock)
    {
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).pendingList.clear();
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).pQE.clear();
      if (((com.tencent.mm.plugin.card.sharecard.a.a)???).pVH != null) {
        com.tencent.mm.kernel.g.aAg().hqi.a(((com.tencent.mm.plugin.card.sharecard.a.a)???).pVH);
      }
      com.tencent.mm.kernel.g.aAg().hqi.b(1132, (i)???);
      this.pUF = null;
      if (this.pUM != null)
      {
        this.pUM.release();
        ??? = this.pUM;
        ((com.tencent.mm.plugin.card.b.d)???).pQG.clear();
        ((com.tencent.mm.plugin.card.b.d)???).pQS.clear();
        ((com.tencent.mm.plugin.card.b.d)???).pQT.clear();
        ((com.tencent.mm.plugin.card.b.d)???).pQU.clear();
        ((com.tencent.mm.plugin.card.b.d)???).pQW = false;
        this.pUM = null;
      }
      if (this.pUN == null) {
        break label573;
      }
      ??? = this.pUN;
      com.tencent.mm.kernel.g.aAg().hqi.b(1078, (i)???);
      ??? = ((com.tencent.mm.plugin.card.b.j)???).pRD.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        Runnable localRunnable = (Runnable)((com.tencent.mm.plugin.card.b.j)???).pRF.get(str);
        ((com.tencent.mm.plugin.card.b.j)???).pRF.remove(str);
        ((com.tencent.mm.plugin.card.b.j)???).pRE.removeCallbacks(localRunnable);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(112883);
        throw localObject2;
        localObject3 = finally;
        AppMethodBeat.o(112883);
        throw localObject3;
      }
    }
    localObject3.pRC.clear();
    localObject3.pRD.clear();
    localObject3.pRF.clear();
    this.pUN = null;
    label573:
    if (this.pUO != null)
    {
      this.pUO.release();
      this.pUO = null;
    }
    if (this.pUP != null)
    {
      this.pUP.release();
      this.pUP = null;
    }
    this.pUL = null;
    com.tencent.mm.plugin.card.ui.b localb = this.pUV;
    com.tencent.mm.plugin.card.ui.b.bWY().registerActivityLifecycleCallbacks(localb);
    if (paramBoolean) {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oib, Integer.valueOf(1));
    }
    AppMethodBeat.o(112883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(112884);
    if (getCore().pUA != null) {
      getCore().pUA.detach();
    }
    EventCenter.instance.removeListener(this.pUW);
    EventCenter.instance.removeListener(this.pUX);
    EventCenter.instance.removeListener(this.pUS);
    EventCenter.instance.removeListener(this.pUT);
    EventCenter.instance.removeListener(this.pUU);
    EventCenter.instance.removeListener(this.pVa);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("carditemmsg", this.pUY, true);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("notifysharecard", this.pUZ, true);
    com.tencent.mm.plugin.card.ui.b localb = this.pUV;
    com.tencent.mm.plugin.card.ui.b.bWY().unregisterActivityLifecycleCallbacks(localb);
    AppMethodBeat.o(112884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am
 * JD-Core Version:    0.7.0.1
 */