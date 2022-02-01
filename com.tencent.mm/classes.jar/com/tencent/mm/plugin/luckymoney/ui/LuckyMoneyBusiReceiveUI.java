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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.d.a;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiReceiveUI
  extends LuckyMoneyBaseUI
{
  private p tipDialog = null;
  private TextView uhh;
  private ImageView uhq;
  private TextView uih;
  private Button uii;
  private View uim;
  private ImageView ukr;
  private String usF = null;
  private int usH = 0;
  private TextView usP;
  private TextView usQ;
  private View usR;
  private ImageView usS;
  private TextView usT;
  private View usU;
  private TextView usV;
  private Button usW;
  private TextView usX;
  private CheckBox usY;
  private int usZ;
  private String ust = null;
  private String uta = null;
  private int utb = 0;
  private af utc;
  private RealnameGuideHelper utd;
  
  private void bp(int paramInt, String paramString)
  {
    AppMethodBeat.i(65501);
    ac.i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
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
        LuckyMoneyBusiReceiveUI.this.usr.forceCancel();
        if ((LuckyMoneyBusiReceiveUI.b(LuckyMoneyBusiReceiveUI.this).getVisibility() == 8) || (LuckyMoneyBusiReceiveUI.c(LuckyMoneyBusiReceiveUI.this).getVisibility() == 4))
        {
          ac.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
          LuckyMoneyBusiReceiveUI.this.finish();
        }
        AppMethodBeat.o(65483);
      }
    });
    if (this.usZ == 3) {
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ad(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
    }
    for (;;)
    {
      bp(0, "");
      AppMethodBeat.o(65495);
      return;
      if (this.usZ == 4)
      {
        doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ad(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        continue;
      }
      try
      {
        this.ust = Uri.parse(bs.nullAsNil(this.usF)).getQueryParameter("sendid");
        label241:
        if (!bs.isNullOrNil(this.ust))
        {
          doSceneProgress(new af(this.ust, this.usF, this.usZ, getIntent().getStringExtra("packageExt")), false);
          continue;
        }
        finish();
        ac.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
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
    this.uim = findViewById(2131301721);
    this.uhq = ((ImageView)findViewById(2131301725));
    this.uih = ((TextView)findViewById(2131301726));
    this.usQ = ((TextView)findViewById(2131301722));
    this.usP = ((TextView)findViewById(2131301730));
    this.uii = ((Button)findViewById(2131301723));
    this.ukr = ((ImageView)findViewById(2131301733));
    this.usR = findViewById(2131301720);
    this.uhh = ((TextView)findViewById(2131301719));
    this.usS = ((ImageView)findViewById(2131301734));
    this.usT = ((TextView)findViewById(2131301732));
    this.usU = findViewById(2131301727);
    this.usV = ((TextView)findViewById(2131301728));
    this.usW = ((Button)findViewById(2131301735));
    this.usX = ((TextView)findViewById(2131301724));
    this.usY = ((CheckBox)findViewById(2131301736));
    this.ukr.setOnClickListener(new View.OnClickListener()
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
        com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), str });
        if (!bs.isNullOrNil(str)) {
          doSceneProgress(new at(str, this.ust, "v1.0"));
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65494);
    super.onCreate(paramBundle);
    this.usF = getIntent().getStringExtra("key_native_url");
    this.usZ = getIntent().getIntExtra("key_way", 5);
    this.usH = getIntent().getIntExtra("key_static_from_scene", 0);
    ac.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + bs.nullAsNil(this.usF) + ", mWay=" + this.usZ);
    init();
    com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
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
        ac.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
        init();
        AppMethodBeat.o(65496);
        return;
      }
      ac.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
      bp(-1, "");
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
        this.utc = ((af)paramn);
        paramString = new com.tencent.mm.plugin.wallet_core.model.ad();
        paramString.field_mNativeUrl = this.usF;
        paramString.field_hbType = this.utc.dBz;
        paramString.field_hbStatus = this.utc.dBA;
        paramString.field_receiveStatus = this.utc.dBB;
        s.eru().a(paramString);
        this.ust = this.utc.uhB;
        this.utb = this.utc.dBz;
        com.tencent.mm.plugin.report.service.h.wUl.f(13050, new Object[] { Integer.valueOf(this.usH), Integer.valueOf(1), this.utc.ung });
        if (this.utc.dBB == 2)
        {
          bp(-1, "");
          doSceneProgress(new ah(this.ust, 11, 0, this.usF, "v1.0"), false);
          AppMethodBeat.o(65499);
          return true;
        }
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        z.o(this.uhq, this.utc.unk);
        z.a(getContext(), this.uih, this.utc.una);
        z.l(this.usS, this.utc.ulO);
        if ((this.utc.dBB != 1) && (this.utc.dBA != 4) && (this.utc.dBA != 5) && (this.utc.dBA != 1)) {
          if (!bs.isNullOrNil(this.utc.ung))
          {
            this.uta = this.utc.ung;
            if (this.utc.unh == 1) {
              this.usY.setVisibility(8);
            }
          }
          else
          {
            this.uii.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65486);
                com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
                if (LuckyMoneyBusiReceiveUI.f(LuckyMoneyBusiReceiveUI.this).isChecked()) {
                  com.tencent.mm.plugin.report.service.h.wUl.f(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this)), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).ung });
                }
                for (;;)
                {
                  LuckyMoneyBusiReceiveUI.i(LuckyMoneyBusiReceiveUI.this);
                  AppMethodBeat.o(65486);
                  return;
                  com.tencent.mm.plugin.report.service.h.wUl.f(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this)), Integer.valueOf(2), "" });
                }
              }
            });
            if (bs.isNullOrNil(this.utc.ulw)) {
              break label523;
            }
            this.usP.setText(this.utc.ulw);
            label402:
            if (bs.isNullOrNil(this.utc.unl)) {
              break label535;
            }
            this.usQ.setText(this.utc.unl);
          }
        }
        for (;;)
        {
          z.a(this.uim, null);
          getContentView().setVisibility(0);
          break;
          ac.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.utc.ung);
          if (this.utc.une == 1) {
            this.usY.setChecked(true);
          }
          for (;;)
          {
            this.usY.setText(this.utc.unf);
            break;
            this.usY.setChecked(false);
          }
          label523:
          this.usP.setVisibility(8);
          break label402;
          label535:
          this.usQ.setVisibility(8);
          continue;
          com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          this.usP.setVisibility(4);
          this.usQ.setText(this.utc.ulw);
          this.uii.setVisibility(8);
          if (this.utb == 1)
          {
            this.usT.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65487);
                com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
                Object localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                ((Intent)localObject).putExtra("key_sendid", LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).uhB);
                ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView = LuckyMoneyBusiReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyBusiReceiveUI.this.finish();
                AppMethodBeat.o(65487);
              }
            });
            this.usT.setVisibility(0);
          }
          else
          {
            this.usT.setVisibility(8);
          }
        }
      }
    }
    else if ((paramn instanceof ae))
    {
      z.d(this.uii);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bp(-1, "");
        paramn = (ae)paramn;
        paramString = new com.tencent.mm.plugin.wallet_core.model.ad();
        paramString.field_mNativeUrl = this.usF;
        paramString.field_hbType = paramn.uni.dBz;
        paramString.field_receiveAmount = paramn.uni.dBN;
        paramString.field_receiveTime = System.currentTimeMillis();
        paramString.field_hbStatus = paramn.uni.dBA;
        paramString.field_receiveStatus = paramn.uni.dBB;
        if (paramString.field_receiveAmount > 0L) {
          s.eru().a(paramString);
        }
        if (paramn.dBB == 2)
        {
          if ((paramn.owW <= 1) || ((paramn.ulL != null) && (paramn.ulL.fFp != 1)))
          {
            ac.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
            paramString = new Intent();
            paramString.putExtra("key_sendid", paramn.uhB);
            paramString.putExtra("key_static_from_scene", this.usH);
            if (paramn.uis != null) {
              paramString.putExtra("key_realname_guide_helper", paramn.uis);
            }
            try
            {
              paramString.putExtra("key_detail_info", paramn.uni.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              if (g.ZY().getInt("PlayCoinSound", 0) > 0) {
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
                ac.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramn.getLocalizedMessage());
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
          this.uhh.setText(com.tencent.mm.wallet_core.ui.e.C(paramn.dBN / 100.0D));
          this.uih.setText(paramn.una);
          this.usP.setVisibility(8);
          this.usQ.setVisibility(8);
          this.usR.setVisibility(0);
          this.uii.setVisibility(8);
          if (!bs.isNullOrNil(paramn.und))
          {
            paramString = paramn.und;
            this.usW.setText(paramString);
            this.usX.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
            ac.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + paramn.owW);
            if ((paramn.owW <= 1) && ((paramn.ulL == null) || (paramn.ulL.fFp != 1))) {
              break label1327;
            }
            ac.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
            this.utd = paramn.uis;
            this.usW.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65491);
                LuckyMoneyBusiReceiveUI.k(LuckyMoneyBusiReceiveUI.this).setVisibility(4);
                LuckyMoneyBusiReceiveUI.l(LuckyMoneyBusiReceiveUI.this).setVisibility(8);
                LuckyMoneyBusiReceiveUI.m(LuckyMoneyBusiReceiveUI.this).setVisibility(8);
                if ((paramn.ulL != null) && (!bs.isNullOrNil(paramn.ulL.ulh))) {}
                for (paramAnonymousView = paramn.ulL.ulh;; paramAnonymousView = LuckyMoneyBusiReceiveUI.this.getString(2131760966))
                {
                  LuckyMoneyBusiReceiveUI.n(LuckyMoneyBusiReceiveUI.this).setText(paramAnonymousView);
                  LuckyMoneyBusiReceiveUI.o(LuckyMoneyBusiReceiveUI.this).setText(paramn.unb);
                  LuckyMoneyBusiReceiveUI.p(LuckyMoneyBusiReceiveUI.this).setVisibility(0);
                  LuckyMoneyBusiReceiveUI.n(LuckyMoneyBusiReceiveUI.this).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(65489);
                      com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
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
            this.usW.setVisibility(0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(65499);
          return true;
          paramString = getString(2131760965);
          break;
          label1327:
          this.usW.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65492);
              LuckyMoneyBusiReceiveUI.this.finish();
              AppMethodBeat.o(65492);
            }
          });
          break label1300;
          this.usP.setVisibility(4);
          this.usQ.setText(paramn.ulw);
          this.uii.setVisibility(8);
          if (this.utb == 1)
          {
            this.usT.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65493);
                Object localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                if (paramn.uis != null) {
                  ((Intent)localObject).putExtra("key_realname_guide_helper", paramn.uis);
                }
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                ((Intent)localObject).putExtra("key_sendid", paramn.uhB);
                ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView = LuckyMoneyBusiReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyBusiReceiveUI.this.finish();
                AppMethodBeat.o(65493);
              }
            });
            this.usT.setVisibility(0);
          }
          else
          {
            this.usT.setVisibility(8);
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
        this.uii.setBackgroundResource(2131232316);
        new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        };
        boolean bool = z.a(this, paramInt2, paramn, paramString, false, new d.a()
        {
          public final Intent r(int paramAnonymousInt, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(65484);
            ac.i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
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
          com.tencent.mm.ui.base.h.cg(this, getString(2131760233));
          com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
          finish();
          AppMethodBeat.o(65499);
          return true;
        }
        com.tencent.mm.ui.base.h.cg(this, paramString);
        AppMethodBeat.o(65499);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.ad))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          doSceneProgress(new af(this.ust, this.usF, this.usZ, getIntent().getStringExtra("packageExt")));
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
              paramString.putExtra("key_detail_info", paramn.uni.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              paramString.putExtra("key_native_url", this.usF);
              paramString.putExtra("key_sendid", this.ust);
              paramString.putExtra("key_static_from_scene", this.usH);
              paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramString.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              finish();
              AppMethodBeat.o(65499);
              return true;
            }
            catch (IOException paramn)
            {
              for (;;)
              {
                ac.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramn.getLocalizedMessage());
              }
            }
          }
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      bp(2, paramString);
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