package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ak;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.luckymoney.model.am;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.g.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.d.a;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiReceiveUI
  extends LuckyMoneyBaseUI
{
  private int EGM = 0;
  private TextView EGU;
  private TextView EGV;
  private View EGW;
  private ImageView EGX;
  private TextView EGY;
  private View EGZ;
  private TextView EHa;
  private Button EHb;
  private TextView EHc;
  private CheckBox EHd;
  private int EHe;
  private String EHf = null;
  private int EHg = 0;
  private am EHh;
  private RealnameGuideHelper EHi;
  private TextView Euj;
  private ImageView Eus;
  private TextView Evi;
  private Button Evj;
  private View Evn;
  private String ExZ = null;
  private ImageView Exp;
  private String Eyn = null;
  private s tipDialog = null;
  
  private void bC(int paramInt, String paramString)
  {
    AppMethodBeat.i(65501);
    Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_errmsg", paramString);
    setResult(paramInt, localIntent);
    AppMethodBeat.o(65501);
  }
  
  private void init()
  {
    AppMethodBeat.i(65495);
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(65483);
        if ((LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this) != null) && (LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this).isShowing())) {
          LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this).dismiss();
        }
        LuckyMoneyBusiReceiveUI.this.EGu.forceCancel();
        if ((LuckyMoneyBusiReceiveUI.b(LuckyMoneyBusiReceiveUI.this).getVisibility() == 8) || (LuckyMoneyBusiReceiveUI.c(LuckyMoneyBusiReceiveUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
          LuckyMoneyBusiReceiveUI.this.finish();
        }
        AppMethodBeat.o(65483);
      }
    });
    if (this.EHe == 3) {
      doSceneProgress(new ak(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
    }
    for (;;)
    {
      bC(0, "");
      AppMethodBeat.o(65495);
      return;
      if (this.EHe == 4)
      {
        doSceneProgress(new ak(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        continue;
      }
      try
      {
        this.ExZ = Uri.parse(Util.nullAsNil(this.Eyn)).getQueryParameter("sendid");
        label242:
        if (!Util.isNullOrNil(this.ExZ))
        {
          doSceneProgress(new am(this.ExZ, this.Eyn, this.EHe, getIntent().getStringExtra("packageExt")), false);
          continue;
        }
        finish();
        Log.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
      }
      catch (Exception localException)
      {
        break label242;
      }
    }
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_busi_receive_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65498);
    this.Evn = findViewById(a.f.lucky_money_busi_receive_ll);
    this.Eus = ((ImageView)findViewById(a.f.lucky_money_busi_receive_sender_avatar));
    this.Evi = ((TextView)findViewById(a.f.lucky_money_busi_receive_sender_nickname));
    this.EGV = ((TextView)findViewById(a.f.lucky_money_busi_receive_maindesc));
    this.EGU = ((TextView)findViewById(a.f.lucky_money_busi_receive_subdesc));
    this.Evj = ((Button)findViewById(a.f.lucky_money_busi_receive_open));
    this.Exp = ((ImageView)findViewById(a.f.lucky_money_busi_recieve_close_btn));
    this.EGW = findViewById(a.f.lucky_money_busi_amount_area);
    this.Euj = ((TextView)findViewById(a.f.lucky_money_busi_amount));
    this.EGX = ((ImageView)findViewById(a.f.lucky_money_busi_recieve_watermask));
    this.EGY = ((TextView)findViewById(a.f.lucky_money_busi_recieve_check_detail));
    this.EGZ = findViewById(a.f.lucky_money_busi_receive_share_area);
    this.EHa = ((TextView)findViewById(a.f.lucky_money_busi_receive_share_hintmess));
    this.EHb = ((Button)findViewById(a.f.lucky_money_busi_share_btn));
    this.EHc = ((TextView)findViewById(a.f.lucky_money_busi_receive_savetips));
    this.EHd = ((CheckBox)findViewById(a.f.lucky_money_busi_subcribe));
    this.Exp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65485);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
        paramAnonymousView.putString("realname_verify_process_jump_plugin", "luckymoney");
        if ((LuckyMoneyBusiReceiveUI.d(LuckyMoneyBusiReceiveUI.this) != null) && (LuckyMoneyBusiReceiveUI.d(LuckyMoneyBusiReceiveUI.this).a(LuckyMoneyBusiReceiveUI.this, paramAnonymousView, null, null, true))) {
          LuckyMoneyBusiReceiveUI.e(LuckyMoneyBusiReceiveUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65485);
          return;
          LuckyMoneyBusiReceiveUI.this.finish();
        }
      }
    });
    setContentViewVisibility(8);
    AppMethodBeat.o(65498);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(65500);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(65500);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), str });
        if (!Util.isNullOrNil(str)) {
          doSceneProgress(new bg(str, this.ExZ, "v1.0"));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65494);
    super.onCreate(paramBundle);
    this.Eyn = getIntent().getStringExtra("key_native_url");
    this.EHe = getIntent().getIntExtra("key_way", 5);
    this.EGM = getIntent().getIntExtra("key_static_from_scene", 0);
    Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + Util.nullAsNil(this.Eyn) + ", mWay=" + this.EHe);
    init();
    com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    initView();
    addSceneEndListener(980);
    AppMethodBeat.o(65494);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65497);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    removeSceneEndListener(980);
    AppMethodBeat.o(65497);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(65496);
    if ((paramIntent != null) && (paramIntent.hasExtra("key_is_realname_verify_process")))
    {
      if (paramIntent.getIntExtra("realname_verify_process_ret", 0) == -1)
      {
        Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
        init();
        AppMethodBeat.o(65496);
        return;
      }
      Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
      bC(-1, "");
      finish();
    }
    AppMethodBeat.o(65496);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(65499);
    if ((paramq instanceof am))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.EHh = ((am)paramq);
        paramString = new af();
        paramString.field_mNativeUrl = this.Eyn;
        paramString.field_hbType = this.EHh.gbo;
        paramString.field_hbStatus = this.EHh.gbp;
        paramString.field_receiveStatus = this.EHh.gbq;
        u.gJk().a(paramString);
        this.ExZ = this.EHh.ybP;
        this.EHg = this.EHh.gbo;
        com.tencent.mm.plugin.report.service.h.IzE.a(13050, new Object[] { Integer.valueOf(this.EGM), Integer.valueOf(1), this.EHh.EAV });
        if (this.EHh.gbq == 2)
        {
          bC(-1, "");
          doSceneProgress(new ap(this.ExZ, 11, 0, this.Eyn, "v1.0"), false);
          AppMethodBeat.o(65499);
          return true;
        }
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        ag.r(this.Eus, this.EHh.EBa);
        ag.a(getContext(), this.Evi, this.EHh.EAP);
        ag.o(this.EGX, this.EHh.Ezq);
        if ((this.EHh.gbq != 1) && (this.EHh.gbp != 4) && (this.EHh.gbp != 5) && (this.EHh.gbp != 1)) {
          if (!Util.isNullOrNil(this.EHh.EAV))
          {
            this.EHf = this.EHh.EAV;
            if (this.EHh.EAW == 1) {
              this.EHd.setVisibility(8);
            }
          }
          else
          {
            this.Evj.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65486);
                b localb = new b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
                if (LuckyMoneyBusiReceiveUI.f(LuckyMoneyBusiReceiveUI.this).isChecked()) {
                  com.tencent.mm.plugin.report.service.h.IzE.a(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this)), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).EAV });
                }
                for (;;)
                {
                  LuckyMoneyBusiReceiveUI.i(LuckyMoneyBusiReceiveUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(65486);
                  return;
                  com.tencent.mm.plugin.report.service.h.IzE.a(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this)), Integer.valueOf(2), "" });
                }
              }
            });
            if (Util.isNullOrNil(this.EHh.EyY)) {
              break label523;
            }
            this.EGU.setText(this.EHh.EyY);
            label402:
            if (Util.isNullOrNil(this.EHh.EBb)) {
              break label535;
            }
            this.EGV.setText(this.EHh.EBb);
          }
        }
        for (;;)
        {
          ag.a(this.Evn, null);
          getContentView().setVisibility(0);
          break;
          Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.EHh.EAV);
          if (this.EHh.EAT == 1) {
            this.EHd.setChecked(true);
          }
          for (;;)
          {
            this.EHd.setText(this.EHh.EAU);
            break;
            this.EHd.setChecked(false);
          }
          label523:
          this.EGU.setVisibility(8);
          break label402;
          label535:
          this.EGV.setVisibility(8);
          continue;
          com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          this.EGU.setVisibility(4);
          this.EGV.setText(this.EHh.EyY);
          this.Evj.setVisibility(8);
          if (this.EHg == 1)
          {
            this.EGY.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65487);
                Object localObject = new b();
                ((b)localObject).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
                com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
                localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                ((Intent)localObject).putExtra("key_sendid", LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).ybP);
                ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView = LuckyMoneyBusiReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyBusiReceiveUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65487);
              }
            });
            this.EGY.setVisibility(0);
          }
          else
          {
            this.EGY.setVisibility(8);
          }
        }
      }
    }
    else if ((paramq instanceof al))
    {
      ag.d(this.Evj);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bC(-1, "");
        paramq = (al)paramq;
        paramString = new af();
        paramString.field_mNativeUrl = this.Eyn;
        paramString.field_hbType = paramq.EAX.gbo;
        paramString.field_receiveAmount = paramq.EAX.gbJ;
        paramString.field_receiveTime = System.currentTimeMillis();
        paramString.field_hbStatus = paramq.EAX.gbp;
        paramString.field_receiveStatus = paramq.EAX.gbq;
        if (paramString.field_receiveAmount > 0L) {
          u.gJk().a(paramString);
        }
        if (com.tencent.mm.plugin.wallet_core.utils.g.a(paramq.EAY))
        {
          Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "should intercept");
          setContentViewVisibility(8);
          new com.tencent.mm.plugin.wallet_core.utils.g(this).a(paramq.EAY, new g.a()
          {
            public final void a(coi paramAnonymouscoi)
            {
              AppMethodBeat.i(271095);
              Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "click intercept button");
              LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this, "");
              LuckyMoneyBusiReceiveUI.this.finish();
              AppMethodBeat.o(271095);
            }
          });
          AppMethodBeat.o(65499);
          return true;
        }
        if (paramq.gbq == 2)
        {
          if ((paramq.tVd <= 1) || ((paramq.Ezn != null) && (paramq.Ezn.jqz != 1)))
          {
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
            paramString = new Intent();
            paramString.putExtra("key_sendid", paramq.ybP);
            paramString.putExtra("key_static_from_scene", this.EGM);
            if (paramq.Evs != null) {
              paramString.putExtra("key_realname_guide_helper", paramq.Evs);
            }
            try
            {
              paramString.putExtra("key_detail_info", paramq.EAX.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              if (com.tencent.mm.n.h.axc().getInt("PlayCoinSound", 0) > 0) {
                paramString.putExtra("play_sound", true);
              }
              c.b(getContext(), "luckymoney", ".ui.LuckyMoneyBusiDetailUI", paramString);
              finish();
              AppMethodBeat.o(65499);
              return true;
            }
            catch (IOException paramq)
            {
              for (;;)
              {
                Log.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramq.getLocalizedMessage());
              }
            }
          }
          paramString = findViewById(a.f.lucky_money_busi_receive_top_ll);
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramString.getHeight());
          localTranslateAnimation.setDuration(400L);
          localTranslateAnimation.setFillAfter(true);
          localTranslateAnimation.setAnimationListener(new LuckyMoneyBusiReceiveUI.8(this, paramString));
          paramString.startAnimation(localTranslateAnimation);
          this.Euj.setText(com.tencent.mm.wallet_core.ui.g.formatMoney2f(paramq.gbJ / 100.0D));
          this.Evi.setText(paramq.EAP);
          this.EGU.setVisibility(8);
          this.EGV.setVisibility(8);
          this.EGW.setVisibility(0);
          this.Evj.setVisibility(8);
          if (!Util.isNullOrNil(paramq.EAS))
          {
            paramString = paramq.EAS;
            this.EHb.setText(paramString);
            this.EHc.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + paramq.tVd);
            if ((paramq.tVd <= 1) && ((paramq.Ezn == null) || (paramq.Ezn.jqz != 1))) {
              break label1384;
            }
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
            this.EHi = paramq.Evs;
            this.EHb.setOnClickListener(new LuckyMoneyBusiReceiveUI.9(this, paramq));
            label1357:
            this.EHb.setVisibility(0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(65499);
          return true;
          paramString = getString(a.i.lucky_money_share);
          break;
          label1384:
          this.EHb.setOnClickListener(new LuckyMoneyBusiReceiveUI.10(this));
          break label1357;
          this.EGU.setVisibility(4);
          this.EGV.setText(paramq.EyY);
          this.Evj.setVisibility(8);
          if (this.EHg == 1)
          {
            this.EGY.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(272054);
                Object localObject = new b();
                ((b)localObject).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
                localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                if (paramq.Evs != null) {
                  ((Intent)localObject).putExtra("key_realname_guide_helper", paramq.Evs);
                }
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                ((Intent)localObject).putExtra("key_sendid", paramq.ybP);
                ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView = LuckyMoneyBusiReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyBusiReceiveUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(272054);
              }
            });
            this.EGY.setVisibility(0);
          }
          else
          {
            this.EGY.setVisibility(8);
          }
        }
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
        paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
        this.Evj.setBackgroundResource(a.e.festival_lucky_money_open_btn_normal);
        boolean bool = ag.a(this, paramInt2, paramq, paramString, false, new LuckyMoneyBusiReceiveUI.2(this), new d.a()
        {
          public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(271816);
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
            AppMethodBeat.o(271816);
            return null;
          }
        }, 1005);
        AppMethodBeat.o(65499);
        return bool;
      }
    }
    else
    {
      if ((paramq instanceof bg))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.ui.base.h.cO(this, getString(a.i.has_send));
          com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
          finish();
          AppMethodBeat.o(65499);
          return true;
        }
        com.tencent.mm.ui.base.h.cO(this, paramString);
        AppMethodBeat.o(65499);
        return true;
      }
      if ((paramq instanceof ak))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          doSceneProgress(new am(this.ExZ, this.Eyn, this.EHe, getIntent().getStringExtra("packageExt")));
          AppMethodBeat.o(65499);
          return true;
        }
      }
      else
      {
        if ((paramq instanceof ah))
        {
          AppMethodBeat.o(65499);
          return true;
        }
        if ((paramq instanceof ap))
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.hide();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramq = (ap)paramq;
            paramString = new Intent();
            paramString.setClass(getContext(), LuckyMoneyBusiDetailUI.class);
            try
            {
              paramString.putExtra("key_detail_info", paramq.EAX.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              paramString.putExtra("key_native_url", this.Eyn);
              paramString.putExtra("key_sendid", this.ExZ);
              paramString.putExtra("key_static_from_scene", this.EGM);
              paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
              com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramString.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              finish();
              AppMethodBeat.o(65499);
              return true;
            }
            catch (IOException paramq)
            {
              for (;;)
              {
                Log.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramq.getLocalizedMessage());
              }
            }
          }
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      bC(2, paramString);
    }
    AppMethodBeat.o(65499);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI
 * JD-Core Version:    0.7.0.1
 */