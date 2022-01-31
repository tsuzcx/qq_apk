package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.c.a.a;
import com.tencent.mm.plugin.ipcall.a.g.a;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import junit.framework.Assert;

@com.tencent.mm.ui.base.a(3)
public class IPCallTalkUI
  extends MMActivity
  implements j.a
{
  private String fsv;
  private int lvA;
  private int lvB;
  private String lvw;
  private String lvx;
  private String lvy;
  private String lvz;
  private j lzm;
  
  private void init()
  {
    this.lzm = new j(this);
    this.lzm.lzX = this;
    j localj = this.lzm;
    Object localObject2 = this.fsv;
    Object localObject3 = this.lvw;
    Object localObject4 = this.lvx;
    String str1 = this.lvy;
    Object localObject1 = this.lvz;
    int i = this.lvA;
    int j = this.lvB;
    localj.lAd = localj.lzV.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
    y.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[] { localObject2, localObject3, localObject4, str1, localObject1, Boolean.valueOf(localj.lAd) });
    localj.lzL = ((ImageView)localj.lzV.findViewById(R.h.talk_ui_default_avatar));
    localj.dpY = ((ImageView)localj.lzV.findViewById(R.h.talk_ui_avatar_iv));
    localj.lzJ = ((EditText)localj.lzV.findViewById(R.h.talk_ui_nickname_tv));
    localj.eXu = ((TextView)localj.lzV.findViewById(R.h.talk_ui_status_tv));
    localj.lzK = ((TextView)localj.lzV.findViewById(R.h.talk_ui_phone_num_tv));
    localj.lzM = ((IPCallFuncButton)localj.lzV.findViewById(R.h.talk_ui_mute_button));
    localj.lzN = ((IPCallFuncButton)localj.lzV.findViewById(R.h.talk_ui_dial_button));
    localj.lzO = ((IPCallFuncButton)localj.lzV.findViewById(R.h.talk_ui_speaker_button));
    localj.lzP = ((ImageButton)localj.lzV.findViewById(R.h.talk_ui_hangout_button));
    localj.lzS = ((ImageButton)localj.lzV.findViewById(R.h.ipcall_mini_action));
    localj.lzQ = ((TextView)localj.lzV.findViewById(R.h.voip_net_status_hint));
    localj.lzR = localj.lzV.findViewById(R.h.voip_net_status_hint_layout);
    localj.ltd = ((DialPad)localj.lzV.findViewById(R.h.dial_pad));
    if (localj.lAd)
    {
      localj.fsv = i.bcg().loW.nickname;
      localj.lzU = i.bcg().loW.lqf;
      localj.lvz = i.bcg().loW.bYR;
      localj.lvx = i.bcg().loW.caK;
      localj.lvw = i.bcg().loW.lqe;
      localj.lzT = i.bcg().loW.lqh;
      y.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", new Object[] { localj.fsv, localj.lzU, localj.lvz, localj.lvx, localj.lvw, Integer.valueOf(localj.lzT) });
      localj.bdj();
      localj.bdk();
      i.bck();
      y.i("MicroMsg.TalkUIController", com.tencent.mm.plugin.ipcall.a.f.stateToString(i.bck().mCurrentState));
      localj.sT(i.bck().mCurrentState);
      localObject1 = i.bcg().loW.lqf;
      localObject2 = i.bcg().loW.lqg;
      if (!bk.bl((String)localObject2))
      {
        localj.FU((String)localObject2);
        localj.lzK.setText(com.tencent.mm.plugin.ipcall.b.a.Ge((String)localObject2));
      }
      for (;;)
      {
        if (i.bck().bcb())
        {
          localObject1 = localj.lzO;
          i.bcj();
          ((IPCallFuncButton)localObject1).setChecked(com.tencent.mm.plugin.ipcall.a.b.a.ys());
          localj.lzM.setChecked(i.bcj().lqp.dnJ);
        }
        return;
        if (!bk.bl((String)localObject1))
        {
          localj.FU((String)localObject1);
          localj.lzK.setText(com.tencent.mm.plugin.ipcall.b.a.Ge((String)localObject1));
        }
      }
    }
    if (i.bck().bca())
    {
      com.tencent.mm.ui.base.h.a(localj.lzV, R.l.in_wechat_out_tip, R.l.app_tip, false, new j.1(localj));
      return;
    }
    localj.bdj();
    localj.fsv = ((String)localObject2);
    localj.lvw = ((String)localObject3);
    localj.lvx = ((String)localObject4);
    localj.lvy = str1;
    localj.lvA = i;
    localj.lvB = j;
    if (!bk.bl(localj.lvw)) {
      localj.lvw = com.tencent.mm.plugin.ipcall.b.c.Gi(localj.lvw);
    }
    if (bk.bl(localj.lvy))
    {
      if (com.tencent.mm.plugin.ipcall.b.a.Gc(localj.lvw))
      {
        localObject2 = com.tencent.mm.plugin.ipcall.b.a.Ga(localj.lvw);
        if (bk.bl((String)localObject2)) {
          localj.lvw = com.tencent.mm.plugin.ipcall.b.a.Gd(localj.lvw);
        }
      }
      else
      {
        localj.lvy = com.tencent.mm.plugin.ipcall.b.c.bdr();
      }
    }
    else
    {
      y.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[] { localj.lvy });
      localObject2 = com.tencent.mm.plugin.ipcall.a.c.bbS();
      localObject3 = localj.lvy;
      if (!((com.tencent.mm.plugin.ipcall.a.c)localObject2).dBn) {
        ((com.tencent.mm.plugin.ipcall.a.c)localObject2).gO(false);
      }
      if (!bk.bl((String)localObject3))
      {
        localObject3 = ((String)localObject3).replace("+", "");
        i.bco().C(bk.getInt((String)localObject3, 0), bk.UY());
        ((com.tencent.mm.plugin.ipcall.a.c)localObject2).bbU();
      }
      if (bk.bl(localj.fsv)) {
        localj.fsv = com.tencent.mm.plugin.ipcall.b.a.aw(localj.lzV, localj.lvw);
      }
      localj.lvz = ((String)localObject1);
      if ((bk.bl(localj.lvy)) || (com.tencent.mm.plugin.ipcall.b.a.Gc(localj.lvw))) {
        break label1196;
      }
      localj.lzU = (localj.lvy + localj.lvw);
      if (localj.lzU.startsWith("+")) {}
    }
    label1196:
    for (localj.lzU = ("+" + localj.lzU);; localj.lzU = localj.lvw)
    {
      y.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[] { localj.lzU });
      if (!com.tencent.mm.plugin.ipcall.a.c.bbS().sE(bk.getInt(localj.lvy, -1))) {
        break label1209;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.aC(12058, localj.lvy);
      com.tencent.mm.ui.base.h.a(localj.lzV, localj.lzV.getString(R.l.callout_country_restriction_hint), localj.lzV.getString(R.l.callout_country_restriction_hint_title), false, new j.6(localj));
      return;
      localj.lvw = com.tencent.mm.plugin.ipcall.b.a.Gf(localj.lvw);
      localj.lvy = ((String)localObject2);
      break;
    }
    label1209:
    if (!aq.isNetworkConnected(localj.lzV))
    {
      Toast.makeText(localj.lzV, R.l.voip_net_unavailable, 1).show();
      localj.lzV.finish();
      return;
    }
    long l1 = localj.lzV.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1L);
    long l2 = System.currentTimeMillis();
    if ((l1 > l2) && (l1 != -1L))
    {
      y.i("MicroMsg.TalkUIController", "onDisasterHappen");
      com.tencent.mm.ui.base.h.a(localj.lzV, localj.lzV.getString(R.l.ip_call_disaster_invalid, new Object[] { String.valueOf((l1 - l2) / 1000L + 1L) }), localj.lzV.getString(R.l.ip_call_alter_tip), localj.lzV.getString(R.l.ip_call_alter_tip_ok), false, new j.5(localj));
      return;
    }
    localj.bdk();
    String str2;
    String str3;
    int k;
    if ((!localj.lAd) || (!i.bck().bca()))
    {
      localj.lzT = com.tencent.mm.plugin.ipcall.b.a.dE(localj.lvx, localj.lvw);
      localj.sT(1);
      localObject2 = localj.lzW;
      localObject3 = localj.fsv;
      localObject4 = localj.lvw;
      str1 = localj.lvz;
      str2 = localj.lzU;
      str3 = localj.lvx;
      i = localj.lzT;
      j = localj.lvA;
      k = localj.lvB;
      if (!i.bck().bca()) {
        break label1569;
      }
      y.i("MicroMsg.IPCallManager", "startIPCall, already start!");
      y.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[] { localj.lzU });
      localObject1 = i.bci();
      localObject2 = localj.lvy;
      y.d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", new Object[] { localObject2 });
      if (!bk.bl((String)localObject2)) {
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).countryCode = ((String)localObject2);
      }
    }
    localj.lAf = false;
    return;
    label1569:
    y.i("MicroMsg.IPCallManager", "startIPCall");
    i.bcg().loN = ((g.a)localObject2);
    i.bch().lqL = ((a.a)localObject2);
    i.bck().mCurrentState = -1;
    ((com.tencent.mm.plugin.ipcall.c)localObject2).ch();
    ((com.tencent.mm.plugin.ipcall.c)localObject2).loj = ((TelephonyManager)ae.getContext().getSystemService("phone"));
    ((com.tencent.mm.plugin.ipcall.c)localObject2).loj.listen(((com.tencent.mm.plugin.ipcall.c)localObject2).lok, 32);
    com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.plugin.ipcall.c)localObject2).lol);
    y.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", new Object[] { str2, str3 });
    localObject1 = new k();
    ((k)localObject1).field_phonenumber = str2;
    if (!bk.bl(str3))
    {
      com.tencent.mm.plugin.ipcall.a.g.c localc = i.bcm().FA(str3);
      if ((localc != null) && (localc.ujK != -1L))
      {
        ((k)localObject1).field_addressId = localc.ujK;
        label1734:
        if (i == -1) {
          break label2349;
        }
        ((k)localObject1).field_phoneType = i;
        label1745:
        ((k)localObject1).field_calltime = bk.UY();
        ((k)localObject1).field_status = 1;
        if (!i.bcn().b((com.tencent.mm.sdk.e.c)localObject1)) {
          break label2358;
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.ipcall.c)localObject2).loh = ((k)localObject1);
      com.tencent.mm.plugin.ipcall.c.dPi.postDelayed(((com.tencent.mm.plugin.ipcall.c)localObject2).lon, 1754L);
      ((com.tencent.mm.plugin.ipcall.c)localObject2).loi = false;
      localObject1 = i.bci();
      y.d("MicroMsg.IPCallReportHelper", "reset");
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqN = 0;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqO = 0;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqP = 0;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqQ = 0;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqR = 0;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqS = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqT = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqU = 0;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqV = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqW = 0;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lpD = 0;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lpE = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqX = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).fjn = "";
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqY = 0;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lqZ = "";
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lrb = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lra = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).loq = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lrc = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lrd = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lri = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lrh = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lre = "";
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lrf = "";
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).countryCode = "";
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lrj = 0L;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lrk = 0;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lrl = 0;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lrm = 0;
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject1).lrn = 0;
      i.bck().mCurrentState = -1;
      y.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", new Object[] { str1, str2 });
      localObject1 = i.bcg();
      y.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", new Object[] { str1, str2 });
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).bWb = false;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loX = false;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loI = 0;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loJ = 0;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loK = 0;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loL = false;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loM = false;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loY = false;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW = new com.tencent.mm.plugin.ipcall.a.a.c();
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW.nickname = ((String)localObject3);
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW.lqe = ((String)localObject4);
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW.caK = str3;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW.lqf = str2;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW.bYR = str1;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW.lpG = ((int)System.currentTimeMillis());
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW.lpH = j;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW.lpI = k;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW.lqh = i;
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loO.a(((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW);
      ((com.tencent.mm.plugin.ipcall.a.g)localObject1).loT.a(((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW);
      y.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.g)localObject1).loW.lpG) });
      i.bck().sF(1);
      localObject1 = i.bch();
      if (!((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).lqK) {
        break label2364;
      }
      y.d("MicroMsg.IPCallEngineManager", "already start engine");
      com.tencent.mm.plugin.ipcall.c.dPi.removeCallbacks(((com.tencent.mm.plugin.ipcall.c)localObject2).lom);
      com.tencent.mm.plugin.ipcall.c.dPi.postDelayed(((com.tencent.mm.plugin.ipcall.c)localObject2).lom, 60000L);
      break;
      ((k)localObject1).field_addressId = -1L;
      break label1734;
      ((k)localObject1).field_addressId = -1L;
      break label1734;
      label2349:
      ((k)localObject1).field_phoneType = -1;
      break label1745;
      label2358:
      localObject1 = null;
    }
    label2364:
    ((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).bcB();
    y.i("MicroMsg.IPCallEngineManager", "start engine");
    if (((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).lqG.isInited)
    {
      ((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).lqG.kb(false);
      ((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).lqG.reset();
    }
    ((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).lqG.pUz = 1;
    l1 = System.currentTimeMillis();
    localObject3 = ((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).lqG;
    ((v2protocal)localObject3).netType = com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext());
    if (((v2protocal)localObject3).netType == 5) {
      ((v2protocal)localObject3).netType = 4;
    }
    ((v2protocal)localObject3).pVv = new int[((v2protocal)localObject3).defaultWidth * ((v2protocal)localObject3).defaultHeight];
    com.tencent.mm.kernel.g.DN();
    ((v2protocal)localObject3).pUx = com.tencent.mm.kernel.a.CK();
    i = m.yR();
    if ((i & 0x400) != 0)
    {
      com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec_v7a.so");
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
    }
    for (;;)
    {
      j = Build.VERSION.SDK_INT;
      k = OpenGlRender.getGLVersion();
      localObject4 = ((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay();
      int m = ((Display)localObject4).getWidth();
      int n = ((Display)localObject4).getHeight();
      i = ((v2protocal)localObject3).init(((v2protocal)localObject3).netType, 65538, ((v2protocal)localObject3).defaultWidth << 16 | ((v2protocal)localObject3).defaultHeight, m << 16 | n, ((v2protocal)localObject3).pUx, i | j << 16 | k << 24, com.tencent.mm.compatible.util.e.dOO + "app_lib/", 4);
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "protocal init ret :" + i + ",uin= " + ((v2protocal)localObject3).pUx);
      ((v2protocal)localObject3).isInited = true;
      if (i < 0) {
        ((v2protocal)localObject3).reset();
      }
      y.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
      if ((((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).lqG.field_capInfo != null) && (((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).lqG.exchangeCabInfo(((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).lqG.field_capInfo, ((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).lqG.field_capInfo.length) < 0))
      {
        y.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
        i.bci().lqW = 24;
      }
      if (i < 0) {
        y.e("MicroMsg.IPCallEngineManager", "engine init failed!");
      }
      ((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).lqG.pUz = 1;
      ((com.tencent.mm.plugin.ipcall.a.c.a)localObject1).lqK = true;
      break;
      if ((i & 0x200) != 0)
      {
        com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec.so");
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
        Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
      }
      else
      {
        com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec_v5.so");
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
        Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
      }
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ip_call_talk_ui;
  }
  
  public final void hd(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    ai.l(new IPCallTalkUI.1(this), 3000L);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().addFlags(6946944);
    this.fsv = getIntent().getStringExtra("IPCallTalkUI_nickname");
    this.lvw = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
    this.lvx = getIntent().getStringExtra("IPCallTalkUI_contactId");
    this.lvy = getIntent().getStringExtra("IPCallTalkUI_countryCode");
    this.lvz = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
    this.lvA = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
    this.lvB = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
    y.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[] { this.fsv, this.lvw, this.lvx, this.lvy, this.lvz, Integer.valueOf(this.lvA), Integer.valueOf(this.lvB) });
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null);
    y.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
    if (!bool) {
      return;
    }
    init();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    setScreenEnable(true);
    if (this.lzm != null)
    {
      j localj = this.lzm;
      y.i("MicroMsg.TalkUIController", "onDestroy");
      localj.lzW.lof = null;
      i.bcj().bER = null;
      i.bcj().lqt = null;
      i.bcj().a(null);
      Object localObject = i.bcj();
      ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).lqq.lqD = null;
      localObject = ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).lqq;
      ((com.tencent.mm.plugin.ipcall.a.b.d)localObject).iah.crJ();
      ((com.tencent.mm.plugin.ipcall.a.b.d)localObject).ial.crK();
      localj.lzV = null;
      localj.lzX = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.lzm != null)
    {
      int i;
      if (i.bck().bcb()) {
        if (paramInt == 25)
        {
          i = i.bcj().bcy();
          if (i == -1) {
            break label79;
          }
          au.Hy().gr(i);
          i = 1;
        }
      }
      while (i != 0)
      {
        return true;
        if (paramInt == 24)
        {
          i = i.bcj().bcy();
          if (i != -1)
          {
            au.Hy().gq(i);
            i = 1;
            continue;
          }
        }
        label79:
        i = 0;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    y.d("MicroMsg.IPCallTalkUI", "onPause");
    super.onPause();
    if (this.lzm != null) {
      y.d("MicroMsg.TalkUIController", "onPause");
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.IPCallTalkUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      init();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new IPCallTalkUI.2(this), new IPCallTalkUI.3(this));
  }
  
  protected void onResume()
  {
    y.d("MicroMsg.IPCallTalkUI", "onResume");
    super.onResume();
    if (this.lzm != null)
    {
      y.d("MicroMsg.TalkUIController", "onResume");
      au.getNotification().cancel(42);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI
 * JD-Core Version:    0.7.0.1
 */