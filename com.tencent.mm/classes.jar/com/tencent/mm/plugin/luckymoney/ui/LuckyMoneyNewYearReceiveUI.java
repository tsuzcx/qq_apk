package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.i.a;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.az;
import com.tencent.mm.plugin.luckymoney.model.be;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.vfs.u;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearReceiveUI
  extends LuckyMoneyBaseUI
{
  private TextView DLp;
  public int EBI;
  private LuckyMoneyAutoScrollView EJZ;
  private TextView EKa;
  private TextView EKb;
  private LinearLayout EKc;
  private ImageView EKd;
  private LinearLayout EKe;
  private LinearLayout EKf;
  private MMAnimateView EKg;
  private TextView EKh;
  private LinearLayout EKi;
  private TextView EKj;
  private ImageView EKk;
  private ImageView EKl;
  private MMAnimateView EKm;
  private ImageView EKn;
  private View EKo;
  private BaseEmojiView EKp;
  private boolean EKq;
  private String EKr;
  private int EKs;
  private String EKt;
  private String EKu;
  private boolean EKv;
  private View Evn;
  private String ExZ;
  private String gbn;
  private String imagePath;
  private String jkq;
  private MMHandler mHandler;
  private TextView qph;
  private ca tMi;
  private ImageView tXu;
  private s tipDialog;
  private i.a uEk;
  private EmojiInfo uIz;
  
  public LuckyMoneyNewYearReceiveUI()
  {
    AppMethodBeat.i(65673);
    this.tipDialog = null;
    this.EBI = 0;
    this.EKq = false;
    this.EKr = "";
    this.EKt = "";
    this.EKu = "";
    this.imagePath = "";
    this.mHandler = new MMHandler();
    this.EKv = false;
    this.uEk = new i.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65662);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65661);
            if ((paramAnonymousEmojiInfo != null) && (LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this) != null) && (LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this).getMd5().equals(paramAnonymousEmojiInfo.getMd5())))
            {
              if (paramAnonymousBoolean)
              {
                Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings success.");
                LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, p.getEmojiStorageMgr().VFH.bxK(LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this).getMd5()));
                LuckyMoneyNewYearReceiveUI.b(LuckyMoneyNewYearReceiveUI.this).setVisibility(8);
                LuckyMoneyNewYearReceiveUI.c(LuckyMoneyNewYearReceiveUI.this).setVisibility(0);
                LuckyMoneyNewYearReceiveUI.c(LuckyMoneyNewYearReceiveUI.this).setEmojiInfo(LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this));
                AppMethodBeat.o(65661);
                return;
              }
              Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings error.");
              LuckyMoneyNewYearReceiveUI.b(LuckyMoneyNewYearReceiveUI.this).setVisibility(8);
              LuckyMoneyNewYearReceiveUI.d(LuckyMoneyNewYearReceiveUI.this).setVisibility(0);
            }
            AppMethodBeat.o(65661);
          }
        });
        AppMethodBeat.o(65662);
      }
    };
    AppMethodBeat.o(65673);
  }
  
  private void Wg(int paramInt)
  {
    AppMethodBeat.i(65682);
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() localReceiveStatus:%s newStatus:%s", new Object[] { Integer.valueOf(this.EKs), Integer.valueOf(paramInt) });
    if (this.tMi == null)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() mEmojiInfo == null");
      AppMethodBeat.o(65682);
      return;
    }
    if ((Util.isEqual(this.EKs, paramInt)) || (Util.isEqual(this.EKs, 2)))
    {
      AppMethodBeat.o(65682);
      return;
    }
    try
    {
      Object localObject2 = new StringBuilder(this.tMi.field_content);
      Object localObject1 = new StringBuilder();
      int i = ((StringBuilder)localObject2).indexOf("<localreceivestatus>");
      StringBuilder localStringBuilder;
      if ((i > 0) && (i < ((StringBuilder)localObject2).length()))
      {
        localStringBuilder = new StringBuilder(((StringBuilder)localObject2).substring(0, i + 20));
        localObject1 = ((StringBuilder)localObject2).substring(i + 21);
        localStringBuilder.append(paramInt).append((String)localObject1);
      }
      for (;;)
      {
        this.tMi.setContent(localStringBuilder.toString());
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.tMi.field_msgId, this.tMi);
        Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() success msgXml:%s", new Object[] { localStringBuilder });
        AppMethodBeat.o(65682);
        return;
        i = ((StringBuilder)localObject2).indexOf("<emoji>");
        if ((i > 0) && (i < ((StringBuilder)localObject2).length()))
        {
          ((StringBuilder)localObject1).append("<localreceivestatus>").append(paramInt).append("</localreceivestatus>");
          localStringBuilder = new StringBuilder(((StringBuilder)localObject2).substring(0, i + 7));
          localObject2 = ((StringBuilder)localObject2).substring(i + 7).trim();
          localStringBuilder.append((CharSequence)localObject1).append((String)localObject2);
        }
        else
        {
          i = ((StringBuilder)localObject2).indexOf("<wcpayinfo>");
          ((StringBuilder)localObject1).append("<emoji><localreceivestatus>").append(paramInt).append("</localreceivestatus></emoji>");
          localStringBuilder = new StringBuilder(((StringBuilder)localObject2).substring(0, i));
          localObject2 = ((StringBuilder)localObject2).substring(i).trim();
          localStringBuilder.append((CharSequence)localObject1).append((String)localObject2);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(65682);
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65681);
    doSceneProgress(new az(paramInt1, paramInt2, paramString1, paramString2, ag.eOH(), z.bdb(), getIntent().getStringExtra("key_username"), "v1.0", paramString3), false);
    AppMethodBeat.o(65681);
  }
  
  private void ePR()
  {
    AppMethodBeat.i(65678);
    this.EKh.setVisibility(8);
    this.uIz = p.getEmojiStorageMgr().VFH.bxK(this.EKr);
    if (this.uIz == null)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showExpression() mEmojiInfo == null ");
      AppMethodBeat.o(65678);
      return;
    }
    if ((u.bBQ(this.uIz.ifh()) > 0L) || (this.uIz.Qv()) || (this.uIz.hBu()))
    {
      this.EKp.setVisibility(0);
      this.EKp.setEmojiInfo(this.uIz);
      AppMethodBeat.o(65678);
      return;
    }
    this.EKp.setVisibility(8);
    this.EKf.setVisibility(0);
    this.EKg.setImageResource(a.h.lucky_money_newyear_creat_loading);
    p.cUM().uEk = this.uEk;
    p.cUM().u(this.uIz);
    AppMethodBeat.o(65678);
  }
  
  private void ePS()
  {
    AppMethodBeat.i(65679);
    this.EKm.setImageResource(a.h.lucky_money_newyear_particle);
    AppMethodBeat.o(65679);
  }
  
  private void tQ(boolean paramBoolean)
  {
    AppMethodBeat.i(65683);
    if (paramBoolean)
    {
      this.EKi.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.EKi.getLayoutParams()).addRule(3, a.f.lucky_money_newyear_receive_invalid_status);
      this.EKj.setText(getString(a.i.lucky_money_see_detail));
      this.EKi.setOnClickListener(new LuckyMoneyNewYearReceiveUI.8(this));
      AppMethodBeat.o(65683);
      return;
    }
    this.EKi.setVisibility(0);
    this.EKi.setOnClickListener(new LuckyMoneyNewYearReceiveUI.9(this));
    this.EKj.setText(getString(a.i.lucky_money_saved_tips));
    AppMethodBeat.o(65683);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_newyear_receive_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65677);
    setActionbarColor(-839716110);
    this.Evn = findViewById(a.f.lucky_money_newyear_receive_ll);
    this.EJZ = ((LuckyMoneyAutoScrollView)findViewById(a.f.lucky_money_newyear_receive_amount));
    this.EKa = ((TextView)findViewById(a.f.lucky_money_amount_unit_title_tv));
    this.DLp = ((TextView)findViewById(a.f.lucky_money_newyear_receive_wishing));
    this.tXu = ((ImageView)findViewById(a.f.lucky_money_newyear_receive_avatar));
    this.EKc = ((LinearLayout)findViewById(a.f.lucky_money_newyear_receive_status_layout));
    this.qph = ((TextView)findViewById(a.f.lucky_money_newyear_receive_status));
    this.EKd = ((ImageView)findViewById(a.f.lucky_money_newyear_receive_status_icon));
    this.EKb = ((TextView)findViewById(a.f.lucky_money_newyear_receive_title));
    this.EKe = ((LinearLayout)findViewById(a.f.lucky_money_newyear_receive_senderdesc));
    this.EKm = ((MMAnimateView)findViewById(a.f.particle_gif_image));
    this.EKn = ((ImageView)findViewById(a.f.lucky_money_new_year_good));
    this.EKo = findViewById(a.f.lucky_money_new_year_expression_layout);
    this.EKp = ((BaseEmojiView)findViewById(a.f.lucky_money_new_year_expression));
    this.EKh = ((TextView)findViewById(a.f.lucky_money_new_year_reload_expression));
    this.EKf = ((LinearLayout)findViewById(a.f.lucky_money_new_year_loading_expression));
    this.EKg = ((MMAnimateView)findViewById(a.f.loading_image));
    this.EKi = ((LinearLayout)findViewById(a.f.lucky_money_click_area));
    this.EKj = ((TextView)findViewById(a.f.lucky_money_click_tv));
    this.EKh.setOnClickListener(new LuckyMoneyNewYearReceiveUI.2(this));
    this.EKk = ((ImageView)findViewById(a.f.lucky_money_new_year_take_cancle_iv));
    this.EKk.setOnClickListener(new LuckyMoneyNewYearReceiveUI.3(this));
    this.EKl = ((ImageView)findViewById(a.f.lucky_money_new_year_take_cancle_good_iv));
    this.EKl.setOnClickListener(new LuckyMoneyNewYearReceiveUI.4(this));
    setContentViewVisibility(8);
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(65666);
        if ((LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this) != null) && (LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this).isShowing())) {
          LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this).dismiss();
        }
        LuckyMoneyNewYearReceiveUI.this.EGu.forceCancel();
        if ((LuckyMoneyNewYearReceiveUI.g(LuckyMoneyNewYearReceiveUI.this).getVisibility() == 8) || (LuckyMoneyNewYearReceiveUI.h(LuckyMoneyNewYearReceiveUI.this).getVisibility() == 4))
        {
          Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
          LuckyMoneyNewYearReceiveUI.this.finish();
        }
        AppMethodBeat.o(65666);
      }
    });
    AppMethodBeat.o(65677);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65674);
    super.onCreate(paramBundle);
    this.jkq = getIntent().getStringExtra("key_username");
    this.EKr = getIntent().getStringExtra("key_emoji_md5");
    long l = getIntent().getLongExtra("key_msgid", 0L);
    this.tMi = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(l);
    this.EKs = getIntent().getIntExtra("key_msg_newyear_localreceivestatus", 0);
    this.gbn = getIntent().getStringExtra("key_native_url");
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "emojiMd5:" + this.EKr);
    paramBundle = Uri.parse(Util.nullAsNil(this.gbn));
    try
    {
      this.ExZ = paramBundle.getQueryParameter("sendid");
      initView();
      if (!Util.isNullOrNil(this.ExZ))
      {
        doSceneProgress(new be(Util.getInt(paramBundle.getQueryParameter("channelid"), 1), this.ExZ, this.gbn, 1, "v1.0", ""), false);
        if (this.tipDialog != null) {
          this.tipDialog.show();
        }
        AppMethodBeat.o(65674);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onCreate() Exception:%s", new Object[] { localException.getMessage() });
      }
      finish();
      Log.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
      AppMethodBeat.o(65674);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65676);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    p.cUM().uEk = null;
    AppMethodBeat.o(65676);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65675);
    super.onResume();
    if (this.EKv) {
      finish();
    }
    AppMethodBeat.o(65675);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(65680);
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramq.getType());
    if ((paramq instanceof be)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (be)paramq;
        this.EBI = paramString.EBI;
        if (paramString.Ezj == 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label664;
          }
          Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
          if (paramString.gbp != 4) {
            this.EKe.setVisibility(8);
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.gbp == 5) {
            break label592;
          }
          paramq = com.tencent.mm.wallet_core.ui.g.formatMoney2f(paramString.EBT / 100.0D);
          this.EJZ.setContentDescription(paramq);
          this.EJZ.setFinalText(paramq);
          this.EJZ.ePy();
          ag.a(getContext(), this.DLp, paramString.EtJ);
          this.EKc.setVisibility(8);
          this.EKe.setVisibility(0);
          if (paramString.gbp != 4) {
            break label580;
          }
          a.b.d(this.tXu, this.jkq);
          Wg(2);
          label258:
          this.EKb.setText(paramString.EyY);
          this.EKb.setTextSize(1, 16.0F);
          paramq = (RelativeLayout.LayoutParams)this.EKe.getLayoutParams();
          paramq.bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this, 82);
          this.EKe.setLayoutParams(paramq);
          this.EKe.invalidate();
          ePS();
          label323:
          setContentViewVisibility(0);
          ag.a(this.Evn, null);
          this.EKk.setVisibility(0);
          this.EKl.setVisibility(8);
          if ((paramString.gbp != 5) && (paramString.gbp != 1)) {
            break label1688;
          }
        }
      }
    }
    label1688:
    for (boolean bool = false;; bool = true)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + paramString.gbp + ", isValidStatus is " + bool);
      if ((Util.isEqual(this.EBI, 1)) && (!Util.isNullOrNil(this.EKr)))
      {
        paramInt1 = 1;
        label431:
        if ((paramInt1 == 0) || (!bool)) {
          break label1213;
        }
        this.EKo.setVisibility(0);
        this.EKn.setVisibility(8);
        ePR();
        label461:
        if ((paramInt1 == 0) || (!bool)) {
          break label1233;
        }
        this.DLp.getLayoutParams();
        this.DLp.setTextSize(1, 21.0F);
        this.EKa.setTextSize(1, 15.0F);
        this.EJZ.ia(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height));
        paramString = (LinearLayout.LayoutParams)this.EJZ.getLayoutParams();
        paramString.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_amount_top_margin_for_normal);
        this.EJZ.setLayoutParams(paramString);
        this.EJZ.invalidate();
      }
      for (;;)
      {
        AppMethodBeat.o(65680);
        return true;
        paramInt1 = 0;
        break;
        label580:
        this.tXu.setVisibility(8);
        break label258;
        label592:
        findViewById(a.f.lucky_money_newyear_receive_desc_area).setVisibility(8);
        ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setText(paramString.EyY);
        ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setVisibility(0);
        ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setTextSize(24.0F);
        tQ(true);
        Wg(1);
        break label323;
        label664:
        Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
        if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username")))
        {
          a.b.d(this.tXu, getIntent().getStringExtra("key_username"));
          label705:
          this.EKb.setTextSize(1, 16.0F);
          ag.a(getContext(), this.EKb, paramString.EBR + getString(a.i.lucky_money_newyear_send_hb));
          paramq = (RelativeLayout.LayoutParams)this.EKe.getLayoutParams();
          paramq.bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this, 30);
          this.EKe.setLayoutParams(paramq);
          this.EKe.invalidate();
          this.EKe.setVisibility(0);
          this.EKc.setVisibility(8);
          if ((paramString.gbq != 0) || (paramString.gbp == 4) || (paramString.gbp == 5) || (paramString.gbp == 1)) {
            break label1016;
          }
          if (!"0".equals(paramString.EBd)) {
            break label989;
          }
          com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.EGu, paramString.EBe, paramString.EBf, paramString.EBg, paramString.EBh, new a.a()
          {
            public final boolean run(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(65667);
              Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + paramAnonymousInt1 + ";errCode=" + paramAnonymousInt2 + ";errMsg=" + paramAnonymousString + ";hadAgree = " + paramAnonymousBoolean);
              if (paramAnonymousInt1 == 1) {
                LuckyMoneyNewYearReceiveUI.this.finish();
              }
              for (;;)
              {
                AppMethodBeat.o(65667);
                return true;
                if (paramAnonymousInt1 == 2) {
                  LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.channelId, paramString.ybP, paramString.gbn, paramString.EBW);
                } else if ((paramAnonymousInt1 == 0) && (paramAnonymousBoolean)) {
                  LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.channelId, paramString.ybP, paramString.gbn, paramString.EBW);
                }
              }
            }
          });
        }
        for (;;)
        {
          paramq = (LinearLayout.LayoutParams)this.EKc.getLayoutParams();
          paramq.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_receive_status_layout_top_margin_for_receiver);
          this.EKc.setLayoutParams(paramq);
          this.EKc.invalidate();
          this.qph.setTextSize(1, 12.0F);
          this.EKk.setVisibility(8);
          this.EKl.setVisibility(0);
          break;
          if (TextUtils.isEmpty(paramString.Ezb)) {
            break label705;
          }
          ag.a(this.tXu, paramString.Ezb, paramString.Ezw);
          break label705;
          label989:
          a(paramString.msgType, paramString.channelId, paramString.ybP, paramString.gbn, paramString.EBW);
        }
        label1016:
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        if (paramString.gbp != 5)
        {
          paramq = com.tencent.mm.wallet_core.ui.g.formatMoney2f(paramString.EBT / 100.0D);
          this.EJZ.setContentDescription(paramq);
          this.EJZ.setFinalText(paramq);
          this.EJZ.ePy();
          ag.a(getContext(), this.DLp, paramString.EtJ);
          Wg(2);
          ePS();
          tQ(false);
        }
        for (;;)
        {
          setContentViewVisibility(0);
          ag.a(this.Evn, null);
          break;
          this.EKi.setVisibility(8);
          findViewById(a.f.lucky_money_newyear_receive_desc_area).setVisibility(8);
          ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setText(paramString.EyY);
          ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setVisibility(0);
          ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setTextSize(24.0F);
          Wg(1);
        }
        paramInt1 = 0;
        break label431;
        label1213:
        this.EKo.setVisibility(8);
        this.EKn.setVisibility(0);
        break label461;
        label1233:
        this.DLp.setTextSize(1, 21.0F);
        this.EKa.setTextSize(1, 18.0F);
        this.EJZ.ia(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width_for_normal), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height_for_normal));
        this.EJZ.invalidate();
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(65680);
      return false;
      if ((paramq instanceof az))
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (az)paramq;
          if (com.tencent.mm.plugin.wallet_core.utils.g.a(paramString.EAY))
          {
            setContentViewVisibility(4);
            paramq = new com.tencent.mm.plugin.wallet_core.utils.g(this);
            paramq.Phv = true;
            paramq.b(paramString.EAY);
            AppMethodBeat.o(65680);
            return true;
          }
          this.EBI = paramString.EBI;
          if (!Util.isEqual(this.EBI, 1))
          {
            this.EKo.setVisibility(8);
            this.EKn.setVisibility(0);
          }
          paramq = paramString.EAX;
          this.qph.setText(paramString.EAX.EyY);
          String str = com.tencent.mm.wallet_core.ui.g.formatMoney2f(paramString.EAX.gbJ / 100.0D);
          this.EJZ.setContentDescription(str);
          this.EJZ.setFinalText(str);
          this.EJZ.a(new LuckyMoneyAutoScrollView.a()
          {
            public final void ePz()
            {
              AppMethodBeat.i(65670);
              LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this).setVisibility(4);
              ag.a(LuckyMoneyNewYearReceiveUI.this.getContext(), LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this), paramString.EAX.EtJ);
              AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
              localAlphaAnimation.setDuration(500L);
              localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
              {
                public final void onAnimationEnd(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(65669);
                  if (com.tencent.mm.n.h.axc().getInt("PlayCoinSound", 0) > 0) {
                    l.play(LuckyMoneyNewYearReceiveUI.this, a.i.lucky_cashrecivedrevised);
                  }
                  if (LuckyMoneyNewYearReceiveUI.7.this.EKz.Evs != null) {
                    LuckyMoneyNewYearReceiveUI.7.this.EKz.Evs.b(LuckyMoneyNewYearReceiveUI.this, null, null);
                  }
                  AppMethodBeat.o(65669);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                
                public final void onAnimationStart(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(65668);
                  LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this).setVisibility(0);
                  AppMethodBeat.o(65668);
                }
              });
              LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this).startAnimation(localAlphaAnimation);
              AppMethodBeat.o(65670);
            }
          });
          if ((paramq.gbp == 4) && (!TextUtils.isEmpty(paramString.EAX.EyY))) {
            this.EKd.setVisibility(8);
          }
          tQ(false);
          setContentViewVisibility(0);
          ag.a(this.Evn, null);
          Wg(2);
          ePS();
          AppMethodBeat.o(65680);
          return true;
        }
        if (paramInt2 == 416)
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          this.EKv = true;
          paramString = new Bundle();
          paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
          paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
          bool = ag.a(this, paramInt2, paramq, paramString, true, null, null, 1004);
          AppMethodBeat.o(65680);
          return bool;
        }
      }
      AppMethodBeat.o(65680);
      return false;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI
 * JD-Core Version:    0.7.0.1
 */