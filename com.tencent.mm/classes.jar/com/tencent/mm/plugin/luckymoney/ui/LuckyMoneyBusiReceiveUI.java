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
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.f;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.d.a;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiReceiveUI
  extends LuckyMoneyBaseUI
{
  private p tipDialog = null;
  private TextView vjR;
  private TextView vkQ;
  private Button vkR;
  private View vkV;
  private ImageView vka;
  private ImageView vmZ;
  private String vuW = null;
  private TextView vvA;
  private CheckBox vvB;
  private int vvC;
  private String vvD = null;
  private int vvE = 0;
  private af vvF;
  private RealnameGuideHelper vvG;
  private String vvi = null;
  private int vvk = 0;
  private TextView vvs;
  private TextView vvt;
  private View vvu;
  private ImageView vvv;
  private TextView vvw;
  private View vvx;
  private TextView vvy;
  private Button vvz;
  
  private void bt(int paramInt, String paramString)
  {
    AppMethodBeat.i(65501);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
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
        LuckyMoneyBusiReceiveUI.this.vuU.forceCancel();
        if ((LuckyMoneyBusiReceiveUI.b(LuckyMoneyBusiReceiveUI.this).getVisibility() == 8) || (LuckyMoneyBusiReceiveUI.c(LuckyMoneyBusiReceiveUI.this).getVisibility() == 4))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
          LuckyMoneyBusiReceiveUI.this.finish();
        }
        AppMethodBeat.o(65483);
      }
    });
    if (this.vvC == 3) {
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ad(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
    }
    for (;;)
    {
      bt(0, "");
      AppMethodBeat.o(65495);
      return;
      if (this.vvC == 4)
      {
        doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ad(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        continue;
      }
      try
      {
        this.vuW = Uri.parse(bt.nullAsNil(this.vvi)).getQueryParameter("sendid");
        label241:
        if (!bt.isNullOrNil(this.vuW))
        {
          doSceneProgress(new af(this.vuW, this.vvi, this.vvC, getIntent().getStringExtra("packageExt")), false);
          continue;
        }
        finish();
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
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
    this.vkV = findViewById(2131301721);
    this.vka = ((ImageView)findViewById(2131301725));
    this.vkQ = ((TextView)findViewById(2131301726));
    this.vvt = ((TextView)findViewById(2131301722));
    this.vvs = ((TextView)findViewById(2131301730));
    this.vkR = ((Button)findViewById(2131301723));
    this.vmZ = ((ImageView)findViewById(2131301733));
    this.vvu = findViewById(2131301720);
    this.vjR = ((TextView)findViewById(2131301719));
    this.vvv = ((ImageView)findViewById(2131301734));
    this.vvw = ((TextView)findViewById(2131301732));
    this.vvx = findViewById(2131301727);
    this.vvy = ((TextView)findViewById(2131301728));
    this.vvz = ((Button)findViewById(2131301735));
    this.vvA = ((TextView)findViewById(2131301724));
    this.vvB = ((CheckBox)findViewById(2131301736));
    this.vmZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65485);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
        com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), str });
        if (!bt.isNullOrNil(str)) {
          doSceneProgress(new at(str, this.vuW, "v1.0"));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65494);
    super.onCreate(paramBundle);
    this.vvi = getIntent().getStringExtra("key_native_url");
    this.vvC = getIntent().getIntExtra("key_way", 5);
    this.vvk = getIntent().getIntExtra("key_static_from_scene", 0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + bt.nullAsNil(this.vvi) + ", mWay=" + this.vvC);
    init();
    com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
        init();
        AppMethodBeat.o(65496);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
      bt(-1, "");
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
        this.vvF = ((af)paramn);
        paramString = new com.tencent.mm.plugin.wallet_core.model.ae();
        paramString.field_mNativeUrl = this.vvi;
        paramString.field_hbType = this.vvF.dNM;
        paramString.field_hbStatus = this.vvF.dNN;
        paramString.field_receiveStatus = this.vvF.dNO;
        t.eFu().a(paramString);
        this.vuW = this.vvF.vkl;
        this.vvE = this.vvF.dNM;
        com.tencent.mm.plugin.report.service.g.yhR.f(13050, new Object[] { Integer.valueOf(this.vvk), Integer.valueOf(1), this.vvF.vpM });
        if (this.vvF.dNO == 2)
        {
          bt(-1, "");
          doSceneProgress(new ah(this.vuW, 11, 0, this.vvi, "v1.0"), false);
          AppMethodBeat.o(65499);
          return true;
        }
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        z.o(this.vka, this.vvF.vpQ);
        z.a(getContext(), this.vkQ, this.vvF.vpG);
        z.l(this.vvv, this.vvF.vou);
        if ((this.vvF.dNO != 1) && (this.vvF.dNN != 4) && (this.vvF.dNN != 5) && (this.vvF.dNN != 1)) {
          if (!bt.isNullOrNil(this.vvF.vpM))
          {
            this.vvD = this.vvF.vpM;
            if (this.vvF.vpN == 1) {
              this.vvB.setVisibility(8);
            }
          }
          else
          {
            this.vkR.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65486);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
                if (LuckyMoneyBusiReceiveUI.f(LuckyMoneyBusiReceiveUI.this).isChecked()) {
                  com.tencent.mm.plugin.report.service.g.yhR.f(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this)), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).vpM });
                }
                for (;;)
                {
                  LuckyMoneyBusiReceiveUI.i(LuckyMoneyBusiReceiveUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(65486);
                  return;
                  com.tencent.mm.plugin.report.service.g.yhR.f(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this)), Integer.valueOf(2), "" });
                }
              }
            });
            if (bt.isNullOrNil(this.vvF.voc)) {
              break label523;
            }
            this.vvs.setText(this.vvF.voc);
            label402:
            if (bt.isNullOrNil(this.vvF.vpR)) {
              break label535;
            }
            this.vvt.setText(this.vvF.vpR);
          }
        }
        for (;;)
        {
          z.a(this.vkV, null);
          getContentView().setVisibility(0);
          break;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.vvF.vpM);
          if (this.vvF.vpK == 1) {
            this.vvB.setChecked(true);
          }
          for (;;)
          {
            this.vvB.setText(this.vvF.vpL);
            break;
            this.vvB.setChecked(false);
          }
          label523:
          this.vvs.setVisibility(8);
          break label402;
          label535:
          this.vvt.setVisibility(8);
          continue;
          com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          this.vvs.setVisibility(4);
          this.vvt.setText(this.vvF.voc);
          this.vkR.setVisibility(8);
          if (this.vvE == 1)
          {
            this.vvw.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65487);
                Object localObject = new b();
                ((b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
                com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
                localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                ((Intent)localObject).putExtra("key_sendid", LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).vkl);
                ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView = LuckyMoneyBusiReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyBusiReceiveUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65487);
              }
            });
            this.vvw.setVisibility(0);
          }
          else
          {
            this.vvw.setVisibility(8);
          }
        }
      }
    }
    else if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.ae))
    {
      z.d(this.vkR);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bt(-1, "");
        paramn = (com.tencent.mm.plugin.luckymoney.model.ae)paramn;
        paramString = new com.tencent.mm.plugin.wallet_core.model.ae();
        paramString.field_mNativeUrl = this.vvi;
        paramString.field_hbType = paramn.vpO.dNM;
        paramString.field_receiveAmount = paramn.vpO.dOa;
        paramString.field_receiveTime = System.currentTimeMillis();
        paramString.field_hbStatus = paramn.vpO.dNN;
        paramString.field_receiveStatus = paramn.vpO.dNO;
        if (paramString.field_receiveAmount > 0L) {
          t.eFu().a(paramString);
        }
        if (paramn.dNO == 2)
        {
          if ((paramn.par <= 1) || ((paramn.vor != null) && (paramn.vor.fYO != 1)))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
            paramString = new Intent();
            paramString.putExtra("key_sendid", paramn.vkl);
            paramString.putExtra("key_static_from_scene", this.vvk);
            if (paramn.vla != null) {
              paramString.putExtra("key_realname_guide_helper", paramn.vla);
            }
            try
            {
              paramString.putExtra("key_detail_info", paramn.vpO.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              if (com.tencent.mm.n.g.acA().getInt("PlayCoinSound", 0) > 0) {
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
                com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramn.getLocalizedMessage());
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
          this.vjR.setText(com.tencent.mm.wallet_core.ui.e.C(paramn.dOa / 100.0D));
          this.vkQ.setText(paramn.vpG);
          this.vvs.setVisibility(8);
          this.vvt.setVisibility(8);
          this.vvu.setVisibility(0);
          this.vkR.setVisibility(8);
          if (!bt.isNullOrNil(paramn.vpJ))
          {
            paramString = paramn.vpJ;
            this.vvz.setText(paramString);
            this.vvA.setVisibility(0);
            com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + paramn.par);
            if ((paramn.par <= 1) && ((paramn.vor == null) || (paramn.vor.fYO != 1))) {
              break label1327;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
            this.vvG = paramn.vla;
            this.vvz.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65491);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                LuckyMoneyBusiReceiveUI.k(LuckyMoneyBusiReceiveUI.this).setVisibility(4);
                LuckyMoneyBusiReceiveUI.l(LuckyMoneyBusiReceiveUI.this).setVisibility(8);
                LuckyMoneyBusiReceiveUI.m(LuckyMoneyBusiReceiveUI.this).setVisibility(8);
                if ((paramn.vor != null) && (!bt.isNullOrNil(paramn.vor.vnN))) {}
                for (paramAnonymousView = paramn.vor.vnN;; paramAnonymousView = LuckyMoneyBusiReceiveUI.this.getString(2131760966))
                {
                  LuckyMoneyBusiReceiveUI.n(LuckyMoneyBusiReceiveUI.this).setText(paramAnonymousView);
                  LuckyMoneyBusiReceiveUI.o(LuckyMoneyBusiReceiveUI.this).setText(paramn.vpH);
                  LuckyMoneyBusiReceiveUI.p(LuckyMoneyBusiReceiveUI.this).setVisibility(0);
                  LuckyMoneyBusiReceiveUI.n(LuckyMoneyBusiReceiveUI.this).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(65489);
                      b localb = new b();
                      localb.bd(paramAnonymous2View);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                      com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
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
            this.vvz.setVisibility(0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(65499);
          return true;
          paramString = getString(2131760965);
          break;
          label1327:
          this.vvz.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65492);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              LuckyMoneyBusiReceiveUI.this.finish();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65492);
            }
          });
          break label1300;
          this.vvs.setVisibility(4);
          this.vvt.setText(paramn.voc);
          this.vkR.setVisibility(8);
          if (this.vvE == 1)
          {
            this.vvw.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65493);
                Object localObject = new b();
                ((b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
                localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                if (paramn.vla != null) {
                  ((Intent)localObject).putExtra("key_realname_guide_helper", paramn.vla);
                }
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                ((Intent)localObject).putExtra("key_sendid", paramn.vkl);
                ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView = LuckyMoneyBusiReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyBusiReceiveUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65493);
              }
            });
            this.vvw.setVisibility(0);
          }
          else
          {
            this.vvw.setVisibility(8);
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
        this.vkR.setBackgroundResource(2131232316);
        new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        };
        boolean bool = z.a(this, paramInt2, paramn, paramString, false, new d.a()
        {
          public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(65484);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
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
          com.tencent.mm.ui.base.h.cl(this, getString(2131760233));
          com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
          finish();
          AppMethodBeat.o(65499);
          return true;
        }
        com.tencent.mm.ui.base.h.cl(this, paramString);
        AppMethodBeat.o(65499);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.ad))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          doSceneProgress(new af(this.vuW, this.vvi, this.vvC, getIntent().getStringExtra("packageExt")));
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
              paramString.putExtra("key_detail_info", paramn.vpO.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              paramString.putExtra("key_native_url", this.vvi);
              paramString.putExtra("key_sendid", this.vuW);
              paramString.putExtra("key_static_from_scene", this.vvk);
              paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramString.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              finish();
              AppMethodBeat.o(65499);
              return true;
            }
            catch (IOException paramn)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramn.getLocalizedMessage());
              }
            }
          }
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      bt(2, paramString);
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