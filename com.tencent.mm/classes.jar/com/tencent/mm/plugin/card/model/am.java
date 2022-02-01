package com.tencent.mm.plugin.card.model;

import android.app.Application;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.mg;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.card.PluginCard;
import com.tencent.mm.plugin.card.mgr.AcceptCardEventListener;
import com.tencent.mm.plugin.card.mgr.GiftCardEventListenser;
import com.tencent.mm.plugin.card.mgr.ShareCardEventListener;
import com.tencent.mm.plugin.card.mgr.i;
import com.tencent.mm.plugin.card.model.a.e;
import com.tencent.mm.plugin.card.model.a.e.a;
import com.tencent.mm.plugin.card.sharecard.a.c.a;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class am
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private MMHandler mHandler;
  private IListener<mg> wvA;
  private com.tencent.mm.plugin.card.mgr.a wva;
  private c wvb;
  private al wvc;
  private h wvd;
  private com.tencent.mm.plugin.card.mgr.l wve;
  private com.tencent.mm.plugin.card.sharecard.a.a wvf;
  private com.tencent.mm.plugin.card.sharecard.model.k wvg;
  private o wvh;
  private com.tencent.mm.plugin.card.sharecard.a.c wvi;
  private com.tencent.mm.plugin.card.mgr.j wvj;
  private com.tencent.mm.plugin.card.mgr.d wvk;
  private com.tencent.mm.plugin.card.mgr.k wvl;
  private com.tencent.mm.plugin.card.mgr.c wvm;
  private i wvn;
  private com.tencent.mm.plugin.card.mgr.b wvo;
  private com.tencent.mm.plugin.card.mgr.f wvp;
  private l wvq;
  private j wvr;
  private IListener wvs;
  private IListener wvt;
  private IListener wvu;
  private com.tencent.mm.plugin.card.ui.b wvv;
  private IListener wvw;
  private IListener wvx;
  private cl.a wvy;
  private cl.a wvz;
  
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
    baseDBFactories.put(Integer.valueOf("PENDINGCARDIDINFO_TABLE".hashCode()), new am.6());
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
    baseDBFactories.put(Integer.valueOf("SHARECARDSYNCITEMINFO_TABLE".hashCode()), new am.9());
    baseDBFactories.put(Integer.valueOf("CARDQRCODECONFI_TABLE".hashCode()), new am.1());
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
    this.wvj = null;
    this.wvk = null;
    this.wvl = null;
    this.wvm = null;
    this.wvn = null;
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.wvs = new GiftCardEventListenser();
    this.wvt = new ShareCardEventListener();
    this.wvu = new AcceptCardEventListener();
    this.wvv = new com.tencent.mm.plugin.card.ui.b();
    this.wvw = new SubCoreCard.1(this, com.tencent.mm.app.f.hfK);
    this.wvx = new SubCoreCard.2(this, com.tencent.mm.app.f.hfK);
    this.wvy = new cl.a()
    {
      public final void a(final g.a paramAnonymousa)
      {
        AppMethodBeat.i(112878);
        final String str = w.a(paramAnonymousa.mpN.YFG);
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
            com.tencent.mm.plugin.card.mgr.j localj = am.dkN();
            Object localObject1 = str;
            String str1 = paramAnonymousa.mpN.Njv;
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
                  if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (com.tencent.mm.plugin.card.c.l.isNumeric((String)localObject3)))
                  {
                    ((g)localObject1).field_card_type = Util.getInt((String)localObject3, 0);
                    ((g)localObject1).field_title = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.title"));
                    ((g)localObject1).field_description = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.description"));
                    ((g)localObject1).field_logo_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_url"));
                    ((g)localObject1).field_logo_color = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.logo_color"));
                    localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.time");
                    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.c.l.isNumeric((String)localObject3))) {
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
                    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.c.l.isNumeric((String)localObject3))) {
                      break label1193;
                    }
                    ((g)localObject1).field_msg_type = Util.getInt((String)localObject3, 0);
                    localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.jump_type");
                    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.c.l.isNumeric((String)localObject3))) {
                      break label1202;
                    }
                    ((g)localObject1).field_jump_type = Util.getInt((String)localObject3, 0);
                    label403:
                    ((g)localObject1).field_url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.url"));
                    str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.text");
                    if (!TextUtils.isEmpty(str2))
                    {
                      localObject3 = new vp();
                      ((vp)localObject3).text = str2;
                      ((vp)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.button.url"));
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.button.action_type");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.c.l.isNumeric(str2))) {
                        break label1211;
                      }
                      ((vp)localObject3).wuj = Util.getInt(str2, 0);
                      label516:
                      ((g)localObject1).wua = ((vp)localObject3);
                    }
                  }
                  try
                  {
                    ((g)localObject1).field_buttonData = ((g)localObject1).wua.toByteArray();
                    str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.text");
                    if (!TextUtils.isEmpty(str2))
                    {
                      localObject3 = new wh();
                      ((wh)localObject3).text = str2;
                      ((wh)localObject3).url = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.url"));
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.type");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.c.l.isNumeric(str2))) {
                        break label1261;
                      }
                      ((wh)localObject3).type = Util.getInt(str2, 0);
                      str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.opt_region.endtime");
                      if ((TextUtils.isEmpty(str2)) || (!com.tencent.mm.plugin.card.c.l.isNumeric(str2))) {
                        break label1284;
                      }
                      if (Long.valueOf(str2).longValue() < 2147483647L) {
                        break label1270;
                      }
                      ((wh)localObject3).PzZ = 2147483647;
                      ((g)localObject1).wub = ((wh)localObject3);
                    }
                  }
                  catch (Exception localException1)
                  {
                    try
                    {
                      for (;;)
                      {
                        ((g)localObject1).field_operData = ((g)localObject1).wub.toByteArray();
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.report_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.c.l.isNumeric((String)localObject3))) {
                          break label1341;
                        }
                        ((g)localObject1).field_report_scene = Util.getInt((String)localObject3, 0);
                        ((g)localObject1).field_read_state = 1;
                        ((g)localObject1).field_accept_buttons = com.tencent.mm.plugin.card.mgr.j.k((Map)localObject2, ".sysmsg.carditemmsg");
                        ((g)localObject1).field_jump_buttons = com.tencent.mm.plugin.card.mgr.j.j((Map)localObject2, ".sysmsg.carditemmsg");
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.get_layout_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.c.l.isNumeric((String)localObject3))) {
                          break label1350;
                        }
                        ((g)localObject1).wue = Util.getInt((String)localObject3, 0);
                        ((g)localObject1).field_consumed_box_id = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.consumed_box_id"));
                        ((g)localObject1).wtU = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_wording"));
                        ((g)localObject1).wtV = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_buff"));
                        ((g)localObject1).wtW = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.reddot_icon_url"));
                        ((g)localObject1).wtX = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.title"));
                        ((g)localObject1).wtY = ((String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_tips.icon_url"));
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.msg_scene");
                        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!com.tencent.mm.plugin.card.c.l.isNumeric((String)localObject3))) {
                          break label1359;
                        }
                        ((g)localObject1).wuf = Util.getInt((String)localObject3, 0);
                        Log.i("MicroMsg.CardMsgManager", "msg_scene is ".concat(String.valueOf(localObject3)));
                        localObject3 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.need_check");
                        Log.i("MicroMsg.CardMsgManager", "need_check:".concat(String.valueOf(localObject3)));
                        if (TextUtils.isEmpty((CharSequence)localObject3)) {
                          break label1368;
                        }
                        ((g)localObject1).wtZ = ((String)localObject3).equals("true");
                        str2 = (String)((Map)localObject2).get(".sysmsg.carditemmsg.all_unavailable");
                        Log.i("MicroMsg.CardMsgManager", "all_Unavailable:".concat(String.valueOf(localObject3)));
                        if (TextUtils.isEmpty(str2)) {
                          break label1377;
                        }
                        ((g)localObject1).wug = str2.equals("true");
                        ((g)localObject1).field_unavailable_qr_code_list = com.tencent.mm.plugin.card.mgr.j.l((Map)localObject2, ".sysmsg.carditemmsg");
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
                        ((vp)localObject3).wuj = 0;
                        break label516;
                        localException1 = localException1;
                        Log.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[] { localException1.getMessage() });
                        Log.printErrStackTrace("MicroMsg.CardMsgInfo", localException1, "", new Object[0]);
                        continue;
                        label1261:
                        localException1.type = 0;
                        continue;
                        label1270:
                        localException1.PzZ = Util.getInt(str2, 0);
                      }
                      label1284:
                      localException1.PzZ = ((int)(System.currentTimeMillis() / 1000L));
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
                        ((g)localObject1).wue = 0;
                        continue;
                        label1359:
                        ((g)localObject1).wuf = 0;
                        continue;
                        label1368:
                        ((g)localObject1).wtZ = false;
                        continue;
                        label1377:
                        ((g)localObject1).wug = false;
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
              if (((g)localObject1).wue != 0) {
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acJt, Integer.valueOf(((g)localObject1).wue));
              }
              Log.i("MicroMsg.CardMsgManager", "reddot_buff is " + ((g)localObject1).wtV);
              if (TextUtils.isEmpty(((g)localObject1).wtV)) {
                break label1963;
              }
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acJp, ((g)localObject1).wtV);
              if ((((g)localObject1).field_msg_type & 0x1) != 0)
              {
                Log.i("MicroMsg.CardMsgManager", "msg_tips_title is " + ((g)localObject1).wtX);
                Log.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + ((g)localObject1).wtY);
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acJr, ((g)localObject1).wtX);
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acJs, ((g)localObject1).wtY);
              }
              if ((((g)localObject1).field_msg_type & 0x40) == 0) {
                break label1974;
              }
              com.tencent.mm.aa.c.aYo().Q(262152, true);
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
                  if (localj.aky(((g)localObject1).field_msg_id)) {
                    break label2653;
                  }
                  localj.wsq.add(localObject1);
                  com.tencent.mm.plugin.card.mgr.j.c((g)localObject1);
                  if ((((g)localObject1).field_msg_type & 0x80) != 0) {
                    localj.wsr += 1;
                  }
                }
              }
              for (;;)
              {
                com.tencent.mm.kernel.h.baE().ban().B(139268, Integer.valueOf(localj.wsr));
                localj.a((g)localObject1);
                if ((((g)localObject1).field_msg_type & 0x2) != 0)
                {
                  am.dkI();
                  com.tencent.mm.plugin.card.mgr.a.Ih(((g)localObject1).wue);
                }
                if ((((g)localObject1).field_msg_type & 0x4) != 0) {
                  localj.onChange();
                }
                if ((((g)localObject1).field_msg_type & 0x8) != 0) {
                  am.dkP().R(((g)localObject1).field_card_id, ((g)localObject1).field_card_tp_id, ((g)localObject1).field_report_scene);
                }
                if ((((g)localObject1).field_msg_type & 0x400) != 0)
                {
                  ((g)localObject1).dkE();
                  am.dkZ().b((g)localObject1);
                }
                if (((((g)localObject1).field_msg_type & 0x1000) != 0) && (((g)localObject1).field_need_pull_card_entrance))
                {
                  localObject1 = e.wvR;
                  e.a.dli();
                }
                com.tencent.mm.plugin.card.c.l.doO();
                AppMethodBeat.o(112877);
                return;
                Log.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
                break;
                if ((((g)localObject1).field_msg_type & 0x4000) == 0) {
                  break label2717;
                }
                com.tencent.mm.aa.c.aYo().Q(262152, true);
                if ((((g)localObject1).field_msg_type & 0x10000) != 0) {
                  break label1726;
                }
                com.tencent.mm.aa.c.aYo().dX(262152, 266241);
                break label1726;
                Log.i("MicroMsg.CardMsgManager", "not has new!");
                int j;
                if ((((g)localObject1).field_msg_type & 0x20) != 0)
                {
                  com.tencent.mm.aa.c.aYo().R(262152, true);
                  Log.i("MicroMsg.CardMsgManager", "has reddot");
                  i = 1;
                  if (TextUtils.isEmpty(((g)localObject1).wtU)) {
                    break label2397;
                  }
                  Log.i("MicroMsg.CardMsgManager", "reddot_wording is " + ((g)localObject1).wtU);
                  com.tencent.mm.kernel.h.baE().ban().set(at.a.acJn, ((g)localObject1).wtU);
                  com.tencent.mm.aa.c.aYo().a(at.a.acJh, true);
                  j = 1;
                  label2128:
                  Log.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + ((g)localObject1).wtW);
                  if (TextUtils.isEmpty(((g)localObject1).wtW)) {
                    break label2410;
                  }
                  com.tencent.mm.kernel.h.baE().ban().set(at.a.acJq, ((g)localObject1).wtW);
                  com.tencent.mm.aa.c.aYo().a(at.a.acJi, true);
                  if ((i == 0) || (j == 0) || (k == 0))
                  {
                    if ((i == 0) || (j == 0) || (k != 0)) {
                      break label2423;
                    }
                    com.tencent.mm.aa.c.aYo().a(at.a.acJi, false);
                    com.tencent.mm.kernel.h.baE().ban().set(at.a.acJq, "");
                  }
                }
                for (;;)
                {
                  if ((i == 0) && (j == 0) && (k == 0)) {
                    break label2651;
                  }
                  com.tencent.mm.kernel.h.baE().ban().set(at.a.acJE, ((g)localObject1).field_card_id);
                  com.tencent.mm.kernel.h.baE().ban().set(at.a.acJF, Boolean.valueOf(((g)localObject1).wtZ));
                  Log.i("MicroMsg.CardMsgManager", "card_id:" + ((g)localObject1).field_card_id + "  need_check:" + ((g)localObject1).wtZ);
                  break;
                  if ((((g)localObject1).field_msg_type & 0x2000) != 0)
                  {
                    com.tencent.mm.aa.c.aYo().R(262152, true);
                    if ((((g)localObject1).field_msg_type & 0x10000) == 0) {
                      com.tencent.mm.aa.c.aYo().dX(262152, 266241);
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
                    com.tencent.mm.aa.c.aYo().a(at.a.acJh, false);
                    com.tencent.mm.kernel.h.baE().ban().set(at.a.acJn, "");
                  }
                  else if ((i == 0) && (j != 0) && (k != 0))
                  {
                    com.tencent.mm.aa.c.aYo().R(262152, false);
                  }
                  else if ((i != 0) && (j == 0) && (k == 0))
                  {
                    com.tencent.mm.aa.c.aYo().a(at.a.acJi, false);
                    com.tencent.mm.kernel.h.baE().ban().set(at.a.acJq, "");
                    com.tencent.mm.aa.c.aYo().a(at.a.acJh, false);
                    com.tencent.mm.kernel.h.baE().ban().set(at.a.acJn, "");
                  }
                  else if ((i == 0) && (j != 0) && (k == 0))
                  {
                    com.tencent.mm.aa.c.aYo().a(at.a.acJi, false);
                    com.tencent.mm.kernel.h.baE().ban().set(at.a.acJq, "");
                    com.tencent.mm.aa.c.aYo().R(262152, false);
                  }
                  else if ((i == 0) && (j == 0) && (k != 0))
                  {
                    com.tencent.mm.aa.c.aYo().a(at.a.acJh, false);
                    com.tencent.mm.kernel.h.baE().ban().set(at.a.acJn, "");
                    com.tencent.mm.aa.c.aYo().R(262152, false);
                  }
                }
                label2651:
                break label1740;
                label2653:
                Log.e("MicroMsg.CardMsgManager", "msg for id " + ((g)localObject1).field_msg_id + " is exist!!");
                localj.akz(((g)localObject1).field_msg_id);
                localj.wsq.add(localObject1);
                com.tencent.mm.plugin.card.mgr.j.c((g)localObject1);
              }
            }
          }
        });
        AppMethodBeat.o(112878);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.wvz = new cl.a()
    {
      public final void a(final g.a paramAnonymousa)
      {
        AppMethodBeat.i(112880);
        final String str = w.a(paramAnonymousa.mpN.YFG);
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
            Object localObject2 = am.dkT();
            Object localObject1 = str;
            Log.i("MicroMsg.ShareCardMsgMgr", "sharecard onReceiveMsg msgId is ".concat(String.valueOf(paramAnonymousa.mpN.Njv)));
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
                if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (com.tencent.mm.plugin.card.c.l.isNumeric((String)localObject2))) {}
                for (locala.wwq = Util.getInt((String)localObject2, 0);; locala.wwq = 0)
                {
                  locala.username = ((String)((Map)localObject1).get(".sysmsg.notifysharecard.username"));
                  locala.iaI = ((String)((Map)localObject1).get(".sysmsg.notifysharecard.card_id"));
                  break;
                }
              }
              if (TextUtils.isEmpty(locala.iaI)) {
                Log.e("MicroMsg.ShareCardMsgMgr", "card id == null");
              }
              Log.i("MicroMsg.ShareCardMsgMgr", "sharecard doSyncNetScene card id is " + locala.iaI);
              am.dkQ().dln();
              com.tencent.mm.plugin.card.c.l.doQ();
            }
            AppMethodBeat.o(112879);
          }
        });
        AppMethodBeat.o(112880);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.wvA = new SubCoreCard.12(this, com.tencent.mm.app.f.hfK);
    u localu = new u(m.wun);
    if (!localu.jKS()) {
      localu.jKY();
    }
    localu = new u(m.wuo);
    if (!localu.jKS()) {
      localu.jKY();
    }
    AppMethodBeat.o(112881);
  }
  
  public static com.tencent.mm.plugin.card.mgr.a dkI()
  {
    AppMethodBeat.i(112885);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wva == null) {
      getCore().wva = new com.tencent.mm.plugin.card.mgr.a();
    }
    com.tencent.mm.plugin.card.mgr.a locala = getCore().wva;
    AppMethodBeat.o(112885);
    return locala;
  }
  
  public static c dkJ()
  {
    AppMethodBeat.i(112886);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvb == null) {
      getCore().wvb = new c(com.tencent.mm.kernel.h.baE().mCN);
    }
    c localc = getCore().wvb;
    AppMethodBeat.o(112886);
    return localc;
  }
  
  public static al dkK()
  {
    AppMethodBeat.i(112887);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvc == null) {
      getCore().wvc = new al(com.tencent.mm.kernel.h.baE().mCN);
    }
    al localal = getCore().wvc;
    AppMethodBeat.o(112887);
    return localal;
  }
  
  public static h dkL()
  {
    AppMethodBeat.i(112888);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvd == null) {
      getCore().wvd = new h(com.tencent.mm.kernel.h.baE().mCN);
    }
    h localh = getCore().wvd;
    AppMethodBeat.o(112888);
    return localh;
  }
  
  public static com.tencent.mm.plugin.card.mgr.l dkM()
  {
    AppMethodBeat.i(112889);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wve == null) {
      getCore().wve = new com.tencent.mm.plugin.card.mgr.l();
    }
    com.tencent.mm.plugin.card.mgr.l locall = getCore().wve;
    AppMethodBeat.o(112889);
    return locall;
  }
  
  public static com.tencent.mm.plugin.card.mgr.j dkN()
  {
    AppMethodBeat.i(112890);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvj == null) {
      getCore().wvj = new com.tencent.mm.plugin.card.mgr.j();
    }
    com.tencent.mm.plugin.card.mgr.j localj = getCore().wvj;
    AppMethodBeat.o(112890);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.mgr.d dkO()
  {
    AppMethodBeat.i(112891);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvk == null) {
      getCore().wvk = new com.tencent.mm.plugin.card.mgr.d();
    }
    com.tencent.mm.plugin.card.mgr.d locald = getCore().wvk;
    AppMethodBeat.o(112891);
    return locald;
  }
  
  public static com.tencent.mm.plugin.card.mgr.k dkP()
  {
    AppMethodBeat.i(112892);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvl == null) {
      getCore().wvl = new com.tencent.mm.plugin.card.mgr.k();
    }
    com.tencent.mm.plugin.card.mgr.k localk = getCore().wvl;
    AppMethodBeat.o(112892);
    return localk;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.a dkQ()
  {
    AppMethodBeat.i(112893);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvf == null) {
      getCore().wvf = new com.tencent.mm.plugin.card.sharecard.a.a();
    }
    com.tencent.mm.plugin.card.sharecard.a.a locala = getCore().wvf;
    AppMethodBeat.o(112893);
    return locala;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.model.k dkR()
  {
    AppMethodBeat.i(112894);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvg == null) {
      getCore().wvg = new com.tencent.mm.plugin.card.sharecard.model.k(com.tencent.mm.kernel.h.baE().mCN);
    }
    com.tencent.mm.plugin.card.sharecard.model.k localk = getCore().wvg;
    AppMethodBeat.o(112894);
    return localk;
  }
  
  public static o dkS()
  {
    AppMethodBeat.i(112895);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvh == null) {
      getCore().wvh = new o(com.tencent.mm.kernel.h.baE().mCN);
    }
    o localo = getCore().wvh;
    AppMethodBeat.o(112895);
    return localo;
  }
  
  public static com.tencent.mm.plugin.card.sharecard.a.c dkT()
  {
    AppMethodBeat.i(112896);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvi == null) {
      getCore().wvi = new com.tencent.mm.plugin.card.sharecard.a.c();
    }
    com.tencent.mm.plugin.card.sharecard.a.c localc = getCore().wvi;
    AppMethodBeat.o(112896);
    return localc;
  }
  
  public static com.tencent.mm.plugin.card.mgr.c dkU()
  {
    AppMethodBeat.i(112897);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvm == null) {
      getCore().wvm = new com.tencent.mm.plugin.card.mgr.c();
    }
    com.tencent.mm.plugin.card.mgr.c localc = getCore().wvm;
    AppMethodBeat.o(112897);
    return localc;
  }
  
  public static i dkV()
  {
    AppMethodBeat.i(112898);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvn == null) {
      getCore().wvn = new i();
    }
    i locali = getCore().wvn;
    AppMethodBeat.o(112898);
    return locali;
  }
  
  public static com.tencent.mm.plugin.card.mgr.b dkW()
  {
    AppMethodBeat.i(112899);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvo == null) {
      getCore().wvo = new com.tencent.mm.plugin.card.mgr.b();
    }
    com.tencent.mm.plugin.card.mgr.b localb = getCore().wvo;
    AppMethodBeat.o(112899);
    return localb;
  }
  
  public static l dkX()
  {
    AppMethodBeat.i(112900);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvq == null) {
      getCore().wvq = new l(com.tencent.mm.kernel.h.baE().mCN);
    }
    l locall = getCore().wvq;
    AppMethodBeat.o(112900);
    return locall;
  }
  
  public static j dkY()
  {
    AppMethodBeat.i(112901);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvr == null) {
      getCore().wvr = new j(com.tencent.mm.kernel.h.baE().mCN);
    }
    j localj = getCore().wvr;
    AppMethodBeat.o(112901);
    return localj;
  }
  
  public static com.tencent.mm.plugin.card.mgr.f dkZ()
  {
    AppMethodBeat.i(112902);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (getCore().wvp == null) {
      getCore().wvp = new com.tencent.mm.plugin.card.mgr.f();
    }
    com.tencent.mm.plugin.card.mgr.f localf = getCore().wvp;
    AppMethodBeat.o(112902);
    return localf;
  }
  
  private static am getCore()
  {
    AppMethodBeat.i(112882);
    Object localObject = (com.tencent.mm.plugin.card.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.card.a.a.class);
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
    this.wvw.alive();
    this.wvx.alive();
    this.wvs.alive();
    this.wvt.alive();
    this.wvu.alive();
    this.wvA.alive();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("carditemmsg", this.wvy, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("notifysharecard", this.wvz, true);
    this.wvj = null;
    if (this.wvk != null)
    {
      this.wvk.wrx.clear();
      this.wvk = null;
    }
    if (this.wve != null) {
      ??? = this.wve;
    }
    synchronized (((com.tencent.mm.plugin.card.mgr.l)???).wss)
    {
      ((com.tencent.mm.plugin.card.mgr.l)???).wss.clear();
      synchronized (((com.tencent.mm.plugin.card.mgr.l)???).wst)
      {
        ((com.tencent.mm.plugin.card.mgr.l)???).wst.clear();
        com.tencent.mm.kernel.h.baD().mCm.b(1058, (com.tencent.mm.am.h)???);
        ??? = com.tencent.mm.modelgeo.d.bJl();
        if (??? != null) {
          ((com.tencent.mm.modelgeo.b)???).a((b.a)???);
        }
        if (((com.tencent.mm.plugin.card.mgr.l)???).wsv != null) {
          com.tencent.mm.kernel.h.baD().mCm.a(((com.tencent.mm.plugin.card.mgr.l)???).wsv);
        }
        this.wve = null;
        if (this.wva != null)
        {
          this.wva.detach();
          this.wva = null;
        }
        if (this.wvf != null) {
          ??? = this.wvf;
        }
      }
    }
    synchronized (((com.tencent.mm.plugin.card.sharecard.a.a)???).lock)
    {
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).pendingList.clear();
      ((com.tencent.mm.plugin.card.sharecard.a.a)???).wre.clear();
      if (((com.tencent.mm.plugin.card.sharecard.a.a)???).wwg != null) {
        com.tencent.mm.kernel.h.baD().mCm.a(((com.tencent.mm.plugin.card.sharecard.a.a)???).wwg);
      }
      com.tencent.mm.kernel.h.baD().mCm.b(1132, (com.tencent.mm.am.h)???);
      this.wvf = null;
      if (this.wvm != null)
      {
        this.wvm.release();
        ??? = this.wvm;
        ((com.tencent.mm.plugin.card.mgr.c)???).eNV.clear();
        ((com.tencent.mm.plugin.card.mgr.c)???).wrr.clear();
        ((com.tencent.mm.plugin.card.mgr.c)???).wrs.clear();
        ((com.tencent.mm.plugin.card.mgr.c)???).wrt.clear();
        ((com.tencent.mm.plugin.card.mgr.c)???).wrv = false;
        this.wvm = null;
      }
      if (this.wvn == null) {
        break label549;
      }
      ??? = this.wvn;
      com.tencent.mm.kernel.h.baD().mCm.b(1078, (com.tencent.mm.am.h)???);
      ??? = ((i)???).wse.iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        Runnable localRunnable = (Runnable)((i)???).wsg.get(str);
        ((i)???).wsg.remove(str);
        ((i)???).wsf.removeCallbacks(localRunnable);
        continue;
        localObject2 = finally;
        AppMethodBeat.o(112883);
        throw localObject2;
        localObject3 = finally;
        AppMethodBeat.o(112883);
        throw localObject3;
      }
    }
    localObject3.wsd.clear();
    localObject3.wse.clear();
    localObject3.wsg.clear();
    this.wvn = null;
    label549:
    if (this.wvo != null)
    {
      this.wvo.release();
      this.wvo = null;
    }
    if (this.wvp != null)
    {
      this.wvp.release();
      this.wvp = null;
    }
    this.wvl = null;
    com.tencent.mm.plugin.card.ui.b localb = this.wvv;
    com.tencent.mm.plugin.card.ui.b.cKQ().registerActivityLifecycleCallbacks(localb);
    if (paramBoolean) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acYc, Integer.valueOf(1));
    }
    AppMethodBeat.o(112883);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(112884);
    if (getCore().wva != null) {
      getCore().wva.detach();
    }
    this.wvw.dead();
    this.wvx.dead();
    this.wvs.dead();
    this.wvt.dead();
    this.wvu.dead();
    this.wvA.dead();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("carditemmsg", this.wvy, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("notifysharecard", this.wvz, true);
    com.tencent.mm.plugin.card.ui.b localb = this.wvv;
    com.tencent.mm.plugin.card.ui.b.cKQ().unregisterActivityLifecycleCallbacks(localb);
    AppMethodBeat.o(112884);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am
 * JD-Core Version:    0.7.0.1
 */