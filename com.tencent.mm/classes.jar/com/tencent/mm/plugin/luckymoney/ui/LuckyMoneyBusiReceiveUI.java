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
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.f;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.d.a;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiReceiveUI
  extends LuckyMoneyBaseUI
{
  private TextView sYT;
  private TextView sZS;
  private Button sZT;
  private View sZX;
  private ImageView sZc;
  private ImageView tcc;
  private p tipDialog = null;
  private TextView tkA;
  private View tkB;
  private TextView tkC;
  private Button tkD;
  private TextView tkE;
  private CheckBox tkF;
  private int tkG;
  private String tkH = null;
  private int tkI = 0;
  private af tkJ;
  private RealnameGuideHelper tkK;
  private String tka = null;
  private String tkm = null;
  private int tko = 0;
  private TextView tkw;
  private TextView tkx;
  private View tky;
  private ImageView tkz;
  
  private void bk(int paramInt, String paramString)
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
        LuckyMoneyBusiReceiveUI.this.tjY.forceCancel();
        if ((LuckyMoneyBusiReceiveUI.b(LuckyMoneyBusiReceiveUI.this).getVisibility() == 8) || (LuckyMoneyBusiReceiveUI.c(LuckyMoneyBusiReceiveUI.this).getVisibility() == 4))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
          LuckyMoneyBusiReceiveUI.this.finish();
        }
        AppMethodBeat.o(65483);
      }
    });
    if (this.tkG == 3) {
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ad(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
    }
    for (;;)
    {
      bk(0, "");
      AppMethodBeat.o(65495);
      return;
      if (this.tkG == 4)
      {
        doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ad(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        continue;
      }
      try
      {
        this.tka = Uri.parse(bt.nullAsNil(this.tkm)).getQueryParameter("sendid");
        label241:
        if (!bt.isNullOrNil(this.tka))
        {
          doSceneProgress(new af(this.tka, this.tkm, this.tkG, getIntent().getStringExtra("packageExt")), false);
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
    this.sZX = findViewById(2131301721);
    this.sZc = ((ImageView)findViewById(2131301725));
    this.sZS = ((TextView)findViewById(2131301726));
    this.tkx = ((TextView)findViewById(2131301722));
    this.tkw = ((TextView)findViewById(2131301730));
    this.sZT = ((Button)findViewById(2131301723));
    this.tcc = ((ImageView)findViewById(2131301733));
    this.tky = findViewById(2131301720);
    this.sYT = ((TextView)findViewById(2131301719));
    this.tkz = ((ImageView)findViewById(2131301734));
    this.tkA = ((TextView)findViewById(2131301732));
    this.tkB = findViewById(2131301727);
    this.tkC = ((TextView)findViewById(2131301728));
    this.tkD = ((Button)findViewById(2131301735));
    this.tkE = ((TextView)findViewById(2131301724));
    this.tkF = ((CheckBox)findViewById(2131301736));
    this.tcc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65485);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
        paramAnonymousView.putString("realname_verify_process_jump_plugin", "luckymoney");
        if ((LuckyMoneyBusiReceiveUI.d(LuckyMoneyBusiReceiveUI.this) != null) && (LuckyMoneyBusiReceiveUI.d(LuckyMoneyBusiReceiveUI.this).a(LuckyMoneyBusiReceiveUI.this, paramAnonymousView, null, null, true)))
        {
          LuckyMoneyBusiReceiveUI.e(LuckyMoneyBusiReceiveUI.this);
          AppMethodBeat.o(65485);
          return;
        }
        LuckyMoneyBusiReceiveUI.this.finish();
        AppMethodBeat.o(65485);
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
        com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), str });
        if (!bt.isNullOrNil(str)) {
          doSceneProgress(new at(str, this.tka, "v1.0"));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65494);
    super.onCreate(paramBundle);
    this.tkm = getIntent().getStringExtra("key_native_url");
    this.tkG = getIntent().getIntExtra("key_way", 5);
    this.tko = getIntent().getIntExtra("key_static_from_scene", 0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + bt.nullAsNil(this.tkm) + ", mWay=" + this.tkG);
    init();
    com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
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
      bk(-1, "");
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
        this.tkJ = ((af)paramn);
        paramString = new com.tencent.mm.plugin.wallet_core.model.ad();
        paramString.field_mNativeUrl = this.tkm;
        paramString.field_hbType = this.tkJ.dDN;
        paramString.field_hbStatus = this.tkJ.dDO;
        paramString.field_receiveStatus = this.tkJ.dDP;
        s.ebY().a(paramString);
        this.tka = this.tkJ.sZn;
        this.tkI = this.tkJ.dDN;
        com.tencent.mm.plugin.report.service.h.vKh.f(13050, new Object[] { Integer.valueOf(this.tko), Integer.valueOf(1), this.tkJ.teR });
        if (this.tkJ.dDP == 2)
        {
          bk(-1, "");
          doSceneProgress(new ah(this.tka, 11, 0, this.tkm, "v1.0"), false);
          AppMethodBeat.o(65499);
          return true;
        }
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        z.o(this.sZc, this.tkJ.teV);
        z.a(getContext(), this.sZS, this.tkJ.teL);
        z.l(this.tkz, this.tkJ.tdz);
        if ((this.tkJ.dDP != 1) && (this.tkJ.dDO != 4) && (this.tkJ.dDO != 5) && (this.tkJ.dDO != 1)) {
          if (!bt.isNullOrNil(this.tkJ.teR))
          {
            this.tkH = this.tkJ.teR;
            if (this.tkJ.teS == 1) {
              this.tkF.setVisibility(8);
            }
          }
          else
          {
            this.sZT.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65486);
                com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
                if (LuckyMoneyBusiReceiveUI.f(LuckyMoneyBusiReceiveUI.this).isChecked()) {
                  com.tencent.mm.plugin.report.service.h.vKh.f(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this)), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).teR });
                }
                for (;;)
                {
                  LuckyMoneyBusiReceiveUI.i(LuckyMoneyBusiReceiveUI.this);
                  AppMethodBeat.o(65486);
                  return;
                  com.tencent.mm.plugin.report.service.h.vKh.f(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this)), Integer.valueOf(2), "" });
                }
              }
            });
            if (bt.isNullOrNil(this.tkJ.tdh)) {
              break label523;
            }
            this.tkw.setText(this.tkJ.tdh);
            label402:
            if (bt.isNullOrNil(this.tkJ.teW)) {
              break label535;
            }
            this.tkx.setText(this.tkJ.teW);
          }
        }
        for (;;)
        {
          z.a(this.sZX, null);
          getContentView().setVisibility(0);
          break;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.tkJ.teR);
          if (this.tkJ.teP == 1) {
            this.tkF.setChecked(true);
          }
          for (;;)
          {
            this.tkF.setText(this.tkJ.teQ);
            break;
            this.tkF.setChecked(false);
          }
          label523:
          this.tkw.setVisibility(8);
          break label402;
          label535:
          this.tkx.setVisibility(8);
          continue;
          com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          this.tkw.setVisibility(4);
          this.tkx.setText(this.tkJ.tdh);
          this.sZT.setVisibility(8);
          if (this.tkI == 1)
          {
            this.tkA.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65487);
                com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
                Object localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                ((Intent)localObject).putExtra("key_sendid", LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).sZn);
                ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView = LuckyMoneyBusiReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyBusiReceiveUI.this.finish();
                AppMethodBeat.o(65487);
              }
            });
            this.tkA.setVisibility(0);
          }
          else
          {
            this.tkA.setVisibility(8);
          }
        }
      }
    }
    else if ((paramn instanceof ae))
    {
      z.d(this.sZT);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bk(-1, "");
        paramn = (ae)paramn;
        paramString = new com.tencent.mm.plugin.wallet_core.model.ad();
        paramString.field_mNativeUrl = this.tkm;
        paramString.field_hbType = paramn.teT.dDN;
        paramString.field_receiveAmount = paramn.teT.dEb;
        paramString.field_receiveTime = System.currentTimeMillis();
        paramString.field_hbStatus = paramn.teT.dDO;
        paramString.field_receiveStatus = paramn.teT.dDP;
        if (paramString.field_receiveAmount > 0L) {
          s.ebY().a(paramString);
        }
        if (paramn.dDP == 2)
        {
          if ((paramn.nTB <= 1) || ((paramn.tdw != null) && (paramn.tdw.fBI != 1)))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
            paramString = new Intent();
            paramString.putExtra("key_sendid", paramn.sZn);
            paramString.putExtra("key_static_from_scene", this.tko);
            if (paramn.tac != null) {
              paramString.putExtra("key_realname_guide_helper", paramn.tac);
            }
            try
            {
              paramString.putExtra("key_detail_info", paramn.teT.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              if (g.Zd().getInt("PlayCoinSound", 0) > 0) {
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
          this.sYT.setText(com.tencent.mm.wallet_core.ui.e.D(paramn.dEb / 100.0D));
          this.sZS.setText(paramn.teL);
          this.tkw.setVisibility(8);
          this.tkx.setVisibility(8);
          this.tky.setVisibility(0);
          this.sZT.setVisibility(8);
          if (!bt.isNullOrNil(paramn.teO))
          {
            paramString = paramn.teO;
            this.tkD.setText(paramString);
            this.tkE.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + paramn.nTB);
            if ((paramn.nTB <= 1) && ((paramn.tdw == null) || (paramn.tdw.fBI != 1))) {
              break label1327;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
            this.tkK = paramn.tac;
            this.tkD.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65491);
                LuckyMoneyBusiReceiveUI.k(LuckyMoneyBusiReceiveUI.this).setVisibility(4);
                LuckyMoneyBusiReceiveUI.l(LuckyMoneyBusiReceiveUI.this).setVisibility(8);
                LuckyMoneyBusiReceiveUI.m(LuckyMoneyBusiReceiveUI.this).setVisibility(8);
                if ((paramn.tdw != null) && (!bt.isNullOrNil(paramn.tdw.tcS))) {}
                for (paramAnonymousView = paramn.tdw.tcS;; paramAnonymousView = LuckyMoneyBusiReceiveUI.this.getString(2131760966))
                {
                  LuckyMoneyBusiReceiveUI.n(LuckyMoneyBusiReceiveUI.this).setText(paramAnonymousView);
                  LuckyMoneyBusiReceiveUI.o(LuckyMoneyBusiReceiveUI.this).setText(paramn.teM);
                  LuckyMoneyBusiReceiveUI.p(LuckyMoneyBusiReceiveUI.this).setVisibility(0);
                  LuckyMoneyBusiReceiveUI.n(LuckyMoneyBusiReceiveUI.this).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(65489);
                      com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
                      z.a(LuckyMoneyBusiReceiveUI.this, 1, false);
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
                  AppMethodBeat.o(65491);
                  return;
                }
              }
            });
            label1300:
            this.tkD.setVisibility(0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(65499);
          return true;
          paramString = getString(2131760965);
          break;
          label1327:
          this.tkD.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65492);
              LuckyMoneyBusiReceiveUI.this.finish();
              AppMethodBeat.o(65492);
            }
          });
          break label1300;
          this.tkw.setVisibility(4);
          this.tkx.setText(paramn.tdh);
          this.sZT.setVisibility(8);
          if (this.tkI == 1)
          {
            this.tkA.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65493);
                Object localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                if (paramn.tac != null) {
                  ((Intent)localObject).putExtra("key_realname_guide_helper", paramn.tac);
                }
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                ((Intent)localObject).putExtra("key_sendid", paramn.sZn);
                ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView = LuckyMoneyBusiReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyBusiReceiveUI.this.finish();
                AppMethodBeat.o(65493);
              }
            });
            this.tkA.setVisibility(0);
          }
          else
          {
            this.tkA.setVisibility(8);
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
        this.sZT.setBackgroundResource(2131232316);
        new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        };
        boolean bool = z.a(this, paramInt2, paramn, paramString, false, new d.a()
        {
          public final Intent q(int paramAnonymousInt, Bundle paramAnonymousBundle)
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
          com.tencent.mm.ui.base.h.cf(this, getString(2131760233));
          com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
          finish();
          AppMethodBeat.o(65499);
          return true;
        }
        com.tencent.mm.ui.base.h.cf(this, paramString);
        AppMethodBeat.o(65499);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.ad))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          doSceneProgress(new af(this.tka, this.tkm, this.tkG, getIntent().getStringExtra("packageExt")));
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
              paramString.putExtra("key_detail_info", paramn.teT.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              paramString.putExtra("key_native_url", this.tkm);
              paramString.putExtra("key_sendid", this.tka);
              paramString.putExtra("key_static_from_scene", this.tko);
              paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramString.lS(0));
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
      bk(2, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI
 * JD-Core Version:    0.7.0.1
 */