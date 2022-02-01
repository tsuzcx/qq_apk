package com.tencent.mm.plugin.luckymoney.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.k.f;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.luckymoney.model.am;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.bh;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.j.a;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.wallet_core.e.a;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class LuckyMoneyBusiReceiveUI
  extends LuckyMoneyBaseUI
{
  private boolean KAa = false;
  private TextView KAe;
  private TextView KAf;
  private View KAg;
  private ImageView KAh;
  private TextView KAi;
  private View KAj;
  private TextView KAk;
  private Button KAl;
  private TextView KAm;
  private CheckBox KAn;
  private int KAo;
  private String KAp = null;
  private int KAq = 0;
  private an KAr;
  private RealnameGuideHelper KAs;
  private TextView KmQ;
  private ImageView KmZ;
  private TextView KnP;
  private Button KnQ;
  private ImageView KnR;
  private View KnV;
  private ImageView KpY;
  private String KqM = null;
  private String Kra = null;
  private int KzV = 0;
  private w tipDialog = null;
  
  private void cj(int paramInt, String paramString)
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
    this.tipDialog = k.a(getContext(), getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(65483);
        if ((LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this) != null) && (LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this).isShowing())) {
          LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this).dismiss();
        }
        LuckyMoneyBusiReceiveUI.this.KzD.forceCancel();
        if ((LuckyMoneyBusiReceiveUI.b(LuckyMoneyBusiReceiveUI.this).getVisibility() == 8) || (LuckyMoneyBusiReceiveUI.c(LuckyMoneyBusiReceiveUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
          LuckyMoneyBusiReceiveUI.this.finish();
        }
        AppMethodBeat.o(65483);
      }
    });
    if (this.KAo == 3) {
      doSceneProgress(new al(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
    }
    for (;;)
    {
      cj(0, "");
      AppMethodBeat.o(65495);
      return;
      if (this.KAo == 4)
      {
        doSceneProgress(new al(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        continue;
      }
      try
      {
        this.KqM = Uri.parse(Util.nullAsNil(this.Kra)).getQueryParameter("sendid");
        label246:
        if (!Util.isNullOrNil(this.KqM))
        {
          doSceneProgress(new an(this.KqM, this.Kra, this.KAo, getIntent().getStringExtra("packageExt")), false);
          continue;
        }
        finish();
        Log.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
      }
      catch (Exception localException)
      {
        break label246;
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(284277);
    super.finish();
    if (this.KAa)
    {
      Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "finish from normalBusiLuckyMoney");
      overridePendingTransition(a.a.toast_fade_in, 0);
    }
    AppMethodBeat.o(284277);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_busi_receive_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65498);
    this.KnV = findViewById(a.f.lucky_money_busi_receive_ll);
    this.KmZ = ((ImageView)findViewById(a.f.lucky_money_busi_receive_sender_avatar));
    this.KnP = ((TextView)findViewById(a.f.lucky_money_busi_receive_sender_nickname));
    this.KAf = ((TextView)findViewById(a.f.lucky_money_busi_receive_maindesc));
    this.KAe = ((TextView)findViewById(a.f.lucky_money_busi_receive_subdesc));
    this.KnQ = ((Button)findViewById(a.f.lucky_money_busi_receive_open));
    this.KnR = ((ImageView)findViewById(a.f.lucky_money_recieve_open_animateview));
    this.KpY = ((ImageView)findViewById(a.f.lucky_money_busi_recieve_close_btn));
    this.KAg = findViewById(a.f.lucky_money_busi_amount_area);
    this.KmQ = ((TextView)findViewById(a.f.lucky_money_busi_amount));
    this.KAh = ((ImageView)findViewById(a.f.lucky_money_busi_recieve_watermask));
    this.KAi = ((TextView)findViewById(a.f.lucky_money_busi_recieve_check_detail));
    this.KAj = findViewById(a.f.lucky_money_busi_receive_share_area);
    this.KAk = ((TextView)findViewById(a.f.lucky_money_busi_receive_share_hintmess));
    this.KAl = ((Button)findViewById(a.f.lucky_money_busi_share_btn));
    this.KAm = ((TextView)findViewById(a.f.lucky_money_busi_receive_savetips));
    this.KAn = ((CheckBox)findViewById(a.f.lucky_money_busi_subcribe));
    this.KpY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65485);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    default: 
    case 1: 
      for (;;)
      {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(65500);
        return;
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          str = paramIntent.getStringExtra("Select_Conv_User");
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), str });
          if (!Util.isNullOrNil(str)) {
            doSceneProgress(new bh(str, this.KqM, "v1.0"));
          }
        }
      }
    }
    if (paramIntent != null) {}
    for (String str = paramIntent.getStringExtra("key_result_errmsg");; str = "")
    {
      cj(paramInt2, str);
      finish();
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65494);
    super.onCreate(paramBundle);
    this.Kra = getIntent().getStringExtra("key_native_url");
    this.KAo = getIntent().getIntExtra("key_way", 5);
    this.KzV = getIntent().getIntExtra("key_static_from_scene", 0);
    Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + Util.nullAsNil(this.Kra) + ", mWay=" + this.KAo);
    init();
    com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
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
      cj(-1, "");
      finish();
    }
    AppMethodBeat.o(65496);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final p paramp)
  {
    AppMethodBeat.i(65499);
    if ((paramp instanceof an))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.KAr = ((an)paramp);
        paramString = new ad();
        paramString.field_mNativeUrl = this.Kra;
        paramString.field_hbType = this.KAr.ihy;
        paramString.field_hbStatus = this.KAr.ihz;
        paramString.field_receiveStatus = this.KAr.ihA;
        u.iiy().a(paramString);
        this.KqM = this.KAr.CAf;
        this.KAq = this.KAr.ihy;
        com.tencent.mm.plugin.report.service.h.OAn.b(13050, new Object[] { Integer.valueOf(this.KzV), Integer.valueOf(1), this.KAr.KtS });
        if ((ah.fXk()) && (this.KAr.Ksa != null) && (this.KAr.Ksa.lTH != 1))
        {
          Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "is not atomic luckymoney, go to LuckyMoneyBusiReceiveUIV2");
          this.KAa = true;
          paramp = getIntent();
          paramString = paramp;
          if (paramp == null) {
            paramString = new Intent();
          }
          paramString.putExtra("key_sendid", this.KqM);
          paramString.putExtra("key_type", this.KAq);
          paramString.putExtra("key_lucky_money_busi_receive_resp", this.KAr.Kuf);
          paramString.setClass(getContext(), WalletPayUPayUI.class);
          startActivityForResult(paramString, 2);
          setContentViewVisibility(8);
          AppMethodBeat.o(65499);
          return true;
        }
        this.KAa = false;
        if (this.KAr.ihA == 2)
        {
          cj(-1, "");
          doSceneProgress(new aq(this.KqM, 11, 0, this.Kra, "v1.0"), false);
          AppMethodBeat.o(65499);
          return true;
        }
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.hide();
        }
        ah.s(this.KmZ, this.KAr.KtX);
        ah.a(getContext(), this.KnP, this.KAr.KtM);
        ah.p(this.KAh, this.KAr.Ksd);
        if ((this.KAr.ihA != 1) && (this.KAr.ihz != 4) && (this.KAr.ihz != 5) && (this.KAr.ihz != 1)) {
          if (!Util.isNullOrNil(this.KAr.KtS))
          {
            this.KAp = this.KAr.KtS;
            if (this.KAr.KtT == 1) {
              this.KAn.setVisibility(8);
            }
          }
          else
          {
            this.KnQ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65486);
                b localb = new b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
                if (LuckyMoneyBusiReceiveUI.f(LuckyMoneyBusiReceiveUI.this).isChecked()) {
                  com.tencent.mm.plugin.report.service.h.OAn.b(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this)), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).KtS });
                }
                for (;;)
                {
                  LuckyMoneyBusiReceiveUI.i(LuckyMoneyBusiReceiveUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(65486);
                  return;
                  com.tencent.mm.plugin.report.service.h.OAn.b(13050, new Object[] { Integer.valueOf(LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this)), Integer.valueOf(2), "" });
                }
              }
            });
            if (Util.isNullOrNil(this.KAr.KrL)) {
              break label665;
            }
            this.KAe.setText(this.KAr.KrL);
            label544:
            if (Util.isNullOrNil(this.KAr.KtY)) {
              break label677;
            }
            this.KAf.setText(this.KAr.KtY);
          }
        }
        for (;;)
        {
          ah.a(this.KnV, null);
          getContentView().setVisibility(0);
          break;
          Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.KAr.KtS);
          if (this.KAr.KtQ == 1) {
            this.KAn.setChecked(true);
          }
          for (;;)
          {
            this.KAn.setText(this.KAr.KtR);
            break;
            this.KAn.setChecked(false);
          }
          label665:
          this.KAe.setVisibility(8);
          break label544;
          label677:
          this.KAf.setVisibility(8);
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          this.KAe.setVisibility(4);
          this.KAf.setText(this.KAr.KrL);
          this.KnQ.setVisibility(8);
          this.KnR.setVisibility(8);
          if (this.KAq == 1)
          {
            this.KAi.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65487);
                Object localObject = new b();
                ((b)localObject).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
                com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
                localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                ((Intent)localObject).putExtra("key_sendid", LuckyMoneyBusiReceiveUI.h(LuckyMoneyBusiReceiveUI.this).CAf);
                ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView = LuckyMoneyBusiReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyBusiReceiveUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65487);
              }
            });
            this.KAi.setVisibility(0);
          }
          else
          {
            this.KAi.setVisibility(8);
          }
        }
      }
    }
    else if ((paramp instanceof am))
    {
      this.KnQ.setVisibility(0);
      ah.o(this.KnR);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        cj(-1, "");
        paramp = (am)paramp;
        paramString = new ad();
        paramString.field_mNativeUrl = this.Kra;
        paramString.field_hbType = paramp.KtU.ihy;
        paramString.field_receiveAmount = paramp.KtU.ihV;
        paramString.field_receiveTime = System.currentTimeMillis();
        paramString.field_hbStatus = paramp.KtU.ihz;
        paramString.field_receiveStatus = paramp.KtU.ihA;
        if (paramString.field_receiveAmount > 0L) {
          u.iiy().a(paramString);
        }
        if (com.tencent.mm.plugin.wallet_core.utils.j.a(paramp.KtV))
        {
          Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "should intercept");
          setContentViewVisibility(8);
          new com.tencent.mm.plugin.wallet_core.utils.j(this).a(paramp.KtV, new j.a()
          {
            public final void a(dfc paramAnonymousdfc)
            {
              AppMethodBeat.i(284388);
              Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "click intercept button");
              LuckyMoneyBusiReceiveUI.a(LuckyMoneyBusiReceiveUI.this, "");
              LuckyMoneyBusiReceiveUI.this.finish();
              AppMethodBeat.o(284388);
            }
          });
          AppMethodBeat.o(65499);
          return true;
        }
        if (paramp.ihA == 2)
        {
          if ((paramp.wYz <= 1) || ((paramp.Ksa != null) && (paramp.Ksa.lTH != 1)))
          {
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
            paramString = new Intent();
            paramString.putExtra("key_sendid", paramp.CAf);
            paramString.putExtra("key_static_from_scene", this.KzV);
            if (paramp.Koa != null) {
              paramString.putExtra("key_realname_guide_helper", paramp.Koa);
            }
            try
            {
              paramString.putExtra("key_detail_info", paramp.KtU.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              if (com.tencent.mm.k.i.aRC().getInt("PlayCoinSound", 0) > 0) {
                paramString.putExtra("play_sound", true);
              }
              com.tencent.mm.br.c.b(getContext(), "luckymoney", ".ui.LuckyMoneyBusiDetailUI", paramString);
              finish();
              AppMethodBeat.o(65499);
              return true;
            }
            catch (IOException paramp)
            {
              for (;;)
              {
                Log.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramp.getLocalizedMessage());
              }
            }
          }
          paramString = findViewById(a.f.lucky_money_busi_receive_top_ll);
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramString.getHeight());
          localTranslateAnimation.setDuration(400L);
          localTranslateAnimation.setFillAfter(true);
          localTranslateAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(284392);
              paramString.setVisibility(8);
              AppMethodBeat.o(284392);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation) {}
          });
          paramString.startAnimation(localTranslateAnimation);
          this.KmQ.setText(com.tencent.mm.wallet_core.ui.i.formatMoney2f(paramp.ihV / 100.0D));
          this.KnP.setText(paramp.KtM);
          this.KAe.setVisibility(8);
          this.KAf.setVisibility(8);
          this.KAg.setVisibility(0);
          this.KnQ.setVisibility(8);
          this.KnR.setVisibility(8);
          if (!Util.isNullOrNil(paramp.KtP))
          {
            paramString = paramp.KtP;
            this.KAl.setText(paramString);
            this.KAm.setVisibility(0);
            com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + paramp.wYz);
            if ((paramp.wYz <= 1) && ((paramp.Ksa == null) || (paramp.Ksa.lTH != 1))) {
              break label1553;
            }
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
            this.KAs = paramp.Koa;
            this.KAl.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(65492);
                b localb = new b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                LuckyMoneyBusiReceiveUI.k(LuckyMoneyBusiReceiveUI.this).setVisibility(4);
                LuckyMoneyBusiReceiveUI.l(LuckyMoneyBusiReceiveUI.this).setVisibility(8);
                LuckyMoneyBusiReceiveUI.m(LuckyMoneyBusiReceiveUI.this).setVisibility(8);
                if ((paramp.Ksa != null) && (!Util.isNullOrNil(paramp.Ksa.Krr))) {}
                for (paramAnonymousView = paramp.Ksa.Krr;; paramAnonymousView = LuckyMoneyBusiReceiveUI.this.getString(a.i.lucky_money_share_friends_tips))
                {
                  LuckyMoneyBusiReceiveUI.n(LuckyMoneyBusiReceiveUI.this).setText(paramAnonymousView);
                  LuckyMoneyBusiReceiveUI.o(LuckyMoneyBusiReceiveUI.this).setText(paramp.KtN);
                  LuckyMoneyBusiReceiveUI.p(LuckyMoneyBusiReceiveUI.this).setVisibility(0);
                  LuckyMoneyBusiReceiveUI.n(LuckyMoneyBusiReceiveUI.this).setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(284375);
                      b localb = new b();
                      localb.cH(paramAnonymous2View);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                      com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
                      ah.a(LuckyMoneyBusiReceiveUI.this, 1, false);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(284375);
                    }
                  });
                  ah.a(LuckyMoneyBusiReceiveUI.k(LuckyMoneyBusiReceiveUI.this), new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(284378);
                      LuckyMoneyBusiReceiveUI.k(LuckyMoneyBusiReceiveUI.this).setVisibility(0);
                      AppMethodBeat.o(284378);
                    }
                  });
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(65492);
                  return;
                }
              }
            });
            label1526:
            this.KAl.setVisibility(0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(65499);
          return true;
          paramString = getString(a.i.lucky_money_share);
          break;
          label1553:
          this.KAl.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65493);
              b localb = new b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              LuckyMoneyBusiReceiveUI.this.finish();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65493);
            }
          });
          break label1526;
          this.KAe.setVisibility(4);
          this.KAf.setText(paramp.KrL);
          this.KnQ.setVisibility(8);
          this.KnR.setVisibility(8);
          if (this.KAq == 1)
          {
            this.KAi.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(284290);
                Object localObject = new b();
                ((b)localObject).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
                localObject = new Intent();
                ((Intent)localObject).setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                if (paramp.Koa != null) {
                  ((Intent)localObject).putExtra("key_realname_guide_helper", paramp.Koa);
                }
                ((Intent)localObject).putExtra("key_native_url", LuckyMoneyBusiReceiveUI.j(LuckyMoneyBusiReceiveUI.this));
                ((Intent)localObject).putExtra("key_sendid", paramp.CAf);
                ((Intent)localObject).putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.g(LuckyMoneyBusiReceiveUI.this));
                paramAnonymousView = LuckyMoneyBusiReceiveUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LuckyMoneyBusiReceiveUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(284290);
              }
            });
            this.KAi.setVisibility(0);
          }
          else
          {
            this.KAi.setVisibility(8);
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
        this.KnQ.setBackgroundResource(a.e.festival_lucky_money_open_btn_normal);
        boolean bool = ah.a(this, paramInt2, paramp, paramString, false, new DialogInterface.OnClickListener()new e.a
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new e.a()
        {
          public final Intent v(int paramAnonymousInt, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(284402);
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
            AppMethodBeat.o(284402);
            return null;
          }
        }, 1005);
        AppMethodBeat.o(65499);
        return bool;
      }
    }
    else
    {
      if ((paramp instanceof bh))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          k.cZ(this, getString(a.i.has_send));
          com.tencent.mm.plugin.report.service.h.OAn.b(11701, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
          finish();
          AppMethodBeat.o(65499);
          return true;
        }
        k.cZ(this, paramString);
        AppMethodBeat.o(65499);
        return true;
      }
      if ((paramp instanceof al))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          doSceneProgress(new an(this.KqM, this.Kra, this.KAo, getIntent().getStringExtra("packageExt")));
          AppMethodBeat.o(65499);
          return true;
        }
      }
      else
      {
        if ((paramp instanceof ai))
        {
          AppMethodBeat.o(65499);
          return true;
        }
        if ((paramp instanceof aq))
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.hide();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramp = (aq)paramp;
            paramString = new Intent();
            paramString.setClass(getContext(), LuckyMoneyBusiDetailUI.class);
            try
            {
              paramString.putExtra("key_detail_info", paramp.KtU.toByteArray());
              paramString.putExtra("key_jump_from", 2);
              paramString.putExtra("key_native_url", this.Kra);
              paramString.putExtra("key_sendid", this.KqM);
              paramString.putExtra("key_static_from_scene", this.KzV);
              paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
              com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramString.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              finish();
              AppMethodBeat.o(65499);
              return true;
            }
            catch (IOException paramp)
            {
              for (;;)
              {
                Log.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + paramp.getLocalizedMessage());
              }
            }
          }
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      cj(2, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI
 * JD-Core Version:    0.7.0.1
 */