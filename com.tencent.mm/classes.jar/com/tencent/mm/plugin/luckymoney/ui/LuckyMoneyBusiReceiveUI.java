package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.d.a;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiReceiveUI
  extends LuckyMoneyBaseUI
{
  private p tipDialog = null;
  private TextView vHA;
  private View vHB;
  private TextView vHC;
  private Button vHD;
  private TextView vHE;
  private CheckBox vHF;
  private int vHG;
  private String vHH = null;
  private int vHI = 0;
  private af vHJ;
  private RealnameGuideHelper vHK;
  private String vHa = null;
  private String vHm = null;
  private int vHo = 0;
  private TextView vHw;
  private TextView vHx;
  private View vHy;
  private ImageView vHz;
  private TextView vvW;
  private TextView vwV;
  private Button vwW;
  private ImageView vwf;
  private View vxa;
  private ImageView vze;
  
  private void bs(int paramInt, String paramString)
  {
    AppMethodBeat.i(65501);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_errmsg", paramString);
    setResult(paramInt, localIntent);
    AppMethodBeat.o(65501);
  }
  
  private void init()
  {
    AppMethodBeat.i(65495);
    this.tipDialog = com.tencent.mm.ui.base.h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(65483);
        if ((LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this) != null) && (LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this).isShowing())) {
          LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this).dismiss();
        }
        LuckyMoneyBusiReceiveUI.this.vGY.forceCancel();
        if ((LuckyMoneyBusiReceiveUI.b(LuckyMoneyBusiReceiveUI.this).getVisibility() == 8) || (LuckyMoneyBusiReceiveUI.c(LuckyMoneyBusiReceiveUI.this).getVisibility() == 4))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
          LuckyMoneyBusiReceiveUI.this.finish();
        }
        AppMethodBeat.o(65483);
      }
    });
    if (this.vHG == 3) {
      doSceneProgress(new ad(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
    }
    for (;;)
    {
      bs(0, "");
      AppMethodBeat.o(65495);
      return;
      if (this.vHG == 4)
      {
        doSceneProgress(new ad(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        continue;
      }
      try
      {
        this.vHa = Uri.parse(bu.nullAsNil(this.vHm)).getQueryParameter("sendid");
        label241:
        if (!bu.isNullOrNil(this.vHa))
        {
          doSceneProgress(new af(this.vHa, this.vHm, this.vHG, getIntent().getStringExtra("packageExt")), false);
          continue;
        }
        finish();
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
      }
      catch (Exception localException)
      {
        break label241;
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131494631;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65498);
    this.vxa = findViewById(2131301721);
    this.vwf = ((ImageView)findViewById(2131301725));
    this.vwV = ((TextView)findViewById(2131301726));
    this.vHx = ((TextView)findViewById(2131301722));
    this.vHw = ((TextView)findViewById(2131301730));
    this.vwW = ((Button)findViewById(2131301723));
    this.vze = ((ImageView)findViewById(2131301733));
    this.vHy = findViewById(2131301720);
    this.vvW = ((TextView)findViewById(2131301719));
    this.vHz = ((ImageView)findViewById(2131301734));
    this.vHA = ((TextView)findViewById(2131301732));
    this.vHB = findViewById(2131301727);
    this.vHC = ((TextView)findViewById(2131301728));
    this.vHD = ((Button)findViewById(2131301735));
    this.vHE = ((TextView)findViewById(2131301724));
    this.vHF = ((CheckBox)findViewById(2131301736));
    this.vze.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65485);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
        com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), str });
        if (!bu.isNullOrNil(str)) {
          doSceneProgress(new at(str, this.vHa, "v1.0"));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65494);
    super.onCreate(paramBundle);
    this.vHm = getIntent().getStringExtra("key_native_url");
    this.vHG = getIntent().getIntExtra("key_way", 5);
    this.vHo = getIntent().getIntExtra("key_static_from_scene", 0);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + bu.nullAsNil(this.vHm) + ", mWay=" + this.vHG);
    init();
    com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
        init();
        AppMethodBeat.o(65496);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
      bs(-1, "");
      finish();
    }
    AppMethodBeat.o(65496);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(65499);
    if ((paramn instanceof af))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.vHJ = ((af)paramn);
        paramString = new com.tencent.mm.plugin.wallet_core.model.ae();
        paramString.field_mNativeUrl = this.vHm;
        paramString.field_hbType = this.vHJ.dPc;
        paramString.field_hbStatus = this.vHJ.dPd;
        paramString.field_receiveStatus = this.vHJ.dPe;
        t.eJb().a(paramString);
        this.vHa = this.vHJ.vwq;
        this.vHI = this.vHJ.dPc;
        com.tencent.mm.plugin.report.service.g.yxI.f(13050, new Object[] { Integer.valueOf(this.vHo), Integer.valueOf(1), this.vHJ.vBR });
        if (this.vHJ.dPe == 2)
        {
          bs(-1, "");
          doSceneProgress(new ah(this.vHa, 11, 0, this.vHm, "v1.0"), false);
          AppMethodBeat.o(65499);
          return true;
        }
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        z.o(this.vwf, this.vHJ.vBV);
        z.a(getContext(), this.vwV, this.vHJ.vBL);
        z.l(this.vHz, this.vHJ.vAz);
        if ((this.vHJ.dPe != 1) && (this.vHJ.dPd != 4) && (this.vHJ.dPd != 5) && (this.vHJ.dPd != 1)) {
          if (!bu.isNullOrNil(this.vHJ.vBR))
          {
            this.vHH = this.vHJ.vBR;
            if (this.vHJ.vBS == 1) {
              this.vHF.setVisibility(8);
            }
          }
          else
          {
            this.vwW.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65486);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
                if (LuckyMoneyBusiReceiveUI.f(LuckyMoneyBusiReceiveUI.this).isChecked()) {
                  com.tencent.mm.plugin.report.service.g.yxI.f(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this)), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).vBR });
                }
                for (;;)
                {
                  LuckyMoneyBusiReceiveUI.i(LuckyMoneyBusiReceiveUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(65486);
                  return;
                  com.tencent.mm.plugin.report.service.g.yxI.f(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this)), Integer.valueOf(2), "" });
                }
              }
            });
            if (bu.isNullOrNil(this.vHJ.vAh)) {
              break label523;
            }
            this.vHw.setText(this.vHJ.vAh);
            label402:
            if (bu.isNullOrNil(this.vHJ.vBW)) {
              break label535;
            }
            this.vHx.setText(this.vHJ.vBW);
          }
        }
        for (;;)
        {
          z.a(this.vxa, null);
          getContentView().setVisibility(0);
          break;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.vHJ.vBR);
          if (this.vHJ.vBP == 1) {
            this.vHF.setChecked(true);
          }
          for (;;)
          {
            this.vHF.setText(this.vHJ.vBQ);
            break;
            this.vHF.setChecked(false);
          }
          label523:
          this.vHw.setVisibility(8);
          break label402;
          label535:
          this.vHx.setVisibility(8);
          continue;
          com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          this.vHw.setVisibility(4);
          this.vHx.setText(this.vHJ.vAh);
          this.vwW.setVisibility(8);
          if (this.vHI == 1)
          {
            this.vHA.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65487);
                Object localObject = new b();
                ((b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
                com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
                localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                ((Intent)localObject).putExtra("key_sendid", LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).vwq);
                ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView = LuckyMoneyBusiReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyBusiReceiveUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65487);
              }
            });
            this.vHA.setVisibility(0);
          }
          else
          {
            this.vHA.setVisibility(8);
          }
        }
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.ae))
    {
      z.d(this.vwW);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bs(-1, "");
        paramn = (com.tencent.mm.plugin.luckymoney.model.ae)paramn;
        paramString = new com.tencent.mm.plugin.wallet_core.model.ae();
        paramString.field_mNativeUrl = this.vHm;
        paramString.field_hbType = paramn.vBT.dPc;
        paramString.field_receiveAmount = paramn.vBT.dPq;
        paramString.field_receiveTime = System.currentTimeMillis();
        paramString.field_hbStatus = paramn.vBT.dPd;
        paramString.field_receiveStatus = paramn.vBT.dPe;
        if (paramString.field_receiveAmount > 0L) {
          t.eJb().a(paramString);
        }
        if (paramn.dPe == 2)
        {
          if ((paramn.pgV <= 1) || ((paramn.vAw != null) && (paramn.vAw.gaV != 1)))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
            paramString = new Intent();
            paramString.putExtra("key_sendid", paramn.vwq);
            paramString.putExtra("key_static_from_scene", this.vHo);
            if (paramn.vxf != null) {
              paramString.putExtra("key_realname_guide_helper", paramn.vxf);
            }
            try
            {
              paramString.putExtra("key_detail_info", paramn.vBT.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              if (com.tencent.mm.n.g.acL().getInt("PlayCoinSound", 0) > 0) {
                paramString.putExtra("play_sound", true);
              }
              d.b(getContext(), "luckymoney", ".ui.LuckyMoneyBusiDetailUI", paramString);
              finish();
              AppMethodBeat.o(65499);
              return true;
            }
            catch (IOException paramn)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramn.getLocalizedMessage());
              }
            }
          }
          paramString = findViewById(2131301731);
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramString.getHeight());
          localTranslateAnimation.setDuration(400L);
          localTranslateAnimation.setFillAfter(true);
          localTranslateAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(65488);
              paramString.setVisibility(8);
              AppMethodBeat.o(65488);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation) {}
          });
          paramString.startAnimation(localTranslateAnimation);
          this.vvW.setText(com.tencent.mm.wallet_core.ui.f.C(paramn.dPq / 100.0D));
          this.vwV.setText(paramn.vBL);
          this.vHw.setVisibility(8);
          this.vHx.setVisibility(8);
          this.vHy.setVisibility(0);
          this.vwW.setVisibility(8);
          if (!bu.isNullOrNil(paramn.vBO))
          {
            paramString = paramn.vBO;
            this.vHD.setText(paramString);
            this.vHE.setVisibility(0);
            com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + paramn.pgV);
            if ((paramn.pgV <= 1) && ((paramn.vAw == null) || (paramn.vAw.gaV != 1))) {
              break label1327;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
            this.vHK = paramn.vxf;
            this.vHD.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65491);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                LuckyMoneyBusiReceiveUI.k(LuckyMoneyBusiReceiveUI.this).setVisibility(4);
                LuckyMoneyBusiReceiveUI.l(LuckyMoneyBusiReceiveUI.this).setVisibility(8);
                LuckyMoneyBusiReceiveUI.m(LuckyMoneyBusiReceiveUI.this).setVisibility(8);
                if ((paramn.vAw != null) && (!bu.isNullOrNil(paramn.vAw.vzS))) {}
                for (paramAnonymousView = paramn.vAw.vzS;; paramAnonymousView = LuckyMoneyBusiReceiveUI.this.getString(2131760966))
                {
                  LuckyMoneyBusiReceiveUI.n(LuckyMoneyBusiReceiveUI.this).setText(paramAnonymousView);
                  LuckyMoneyBusiReceiveUI.o(LuckyMoneyBusiReceiveUI.this).setText(paramn.vBM);
                  LuckyMoneyBusiReceiveUI.p(LuckyMoneyBusiReceiveUI.this).setVisibility(0);
                  LuckyMoneyBusiReceiveUI.n(LuckyMoneyBusiReceiveUI.this).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(65489);
                      b localb = new b();
                      localb.bd(paramAnonymous2View);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                      com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
                      z.a(LuckyMoneyBusiReceiveUI.this, 1, false);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(65489);
                    }
                  });
                  z.a(LuckyMoneyBusiReceiveUI.k(LuckyMoneyBusiReceiveUI.this), new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(65490);
                      LuckyMoneyBusiReceiveUI.k(LuckyMoneyBusiReceiveUI.this).setVisibility(0);
                      AppMethodBeat.o(65490);
                    }
                  });
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(65491);
                  return;
                }
              }
            });
            label1300:
            this.vHD.setVisibility(0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(65499);
          return true;
          paramString = getString(2131760965);
          break;
          label1327:
          this.vHD.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65492);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              LuckyMoneyBusiReceiveUI.this.finish();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65492);
            }
          });
          break label1300;
          this.vHw.setVisibility(4);
          this.vHx.setText(paramn.vAh);
          this.vwW.setVisibility(8);
          if (this.vHI == 1)
          {
            this.vHA.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65493);
                Object localObject = new b();
                ((b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
                localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                if (paramn.vxf != null) {
                  ((Intent)localObject).putExtra("key_realname_guide_helper", paramn.vxf);
                }
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                ((Intent)localObject).putExtra("key_sendid", paramn.vwq);
                ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView = LuckyMoneyBusiReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyBusiReceiveUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65493);
              }
            });
            this.vHA.setVisibility(0);
          }
          else
          {
            this.vHA.setVisibility(8);
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
        this.vwW.setBackgroundResource(2131232316);
        new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        };
        boolean bool = z.a(this, paramInt2, paramn, paramString, false, new d.a()
        {
          public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(65484);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
            AppMethodBeat.o(65484);
            return null;
          }
        }, 1005);
        AppMethodBeat.o(65499);
        return bool;
      }
    }
    else
    {
      if ((paramn instanceof at))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.ui.base.h.cm(this, getString(2131760233));
          com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
          finish();
          AppMethodBeat.o(65499);
          return true;
        }
        com.tencent.mm.ui.base.h.cm(this, paramString);
        AppMethodBeat.o(65499);
        return true;
      }
      if ((paramn instanceof ad))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          doSceneProgress(new af(this.vHa, this.vHm, this.vHG, getIntent().getStringExtra("packageExt")));
          AppMethodBeat.o(65499);
          return true;
        }
      }
      else
      {
        if ((paramn instanceof aa))
        {
          AppMethodBeat.o(65499);
          return true;
        }
        if ((paramn instanceof ah))
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.hide();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramn = (ah)paramn;
            paramString = new Intent();
            paramString.setClass(getContext(), LuckyMoneyBusiDetailUI.class);
            try
            {
              paramString.putExtra("key_detail_info", paramn.vBT.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              paramString.putExtra("key_native_url", this.vHm);
              paramString.putExtra("key_sendid", this.vHa);
              paramString.putExtra("key_static_from_scene", this.vHo);
              paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramString.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              finish();
              AppMethodBeat.o(65499);
              return true;
            }
            catch (IOException paramn)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramn.getLocalizedMessage());
              }
            }
          }
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      bs(2, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI
 * JD-Core Version:    0.7.0.1
 */