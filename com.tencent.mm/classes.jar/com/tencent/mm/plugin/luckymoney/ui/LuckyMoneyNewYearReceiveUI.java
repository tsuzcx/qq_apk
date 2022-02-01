package com.tencent.mm.plugin.luckymoney.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.model.i.a;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ba;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.plugin.wallet_core.utils.j;
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
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.y;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearReceiveUI
  extends LuckyMoneyBaseUI
{
  private String Ilf;
  private TextView JCr;
  private LuckyMoneyAutoScrollView KDH;
  private TextView KDI;
  private TextView KDJ;
  private LinearLayout KDK;
  private ImageView KDL;
  private LinearLayout KDM;
  private LinearLayout KDN;
  private MMAnimateView KDO;
  private TextView KDP;
  private LinearLayout KDQ;
  private TextView KDR;
  private ImageView KDS;
  private ImageView KDT;
  private MMAnimateView KDU;
  private ImageView KDV;
  private View KDW;
  private BaseEmojiView KDX;
  private boolean KDY;
  private int KDZ;
  private String KEa;
  private String KEb;
  private boolean KEc;
  private View KnV;
  private String KqM;
  public int KuI;
  private String ihx;
  private String imagePath;
  private String lMU;
  private MMHandler mHandler;
  private w tipDialog;
  private TextView ttK;
  private cc wPy;
  private i.a xMB;
  private EmojiInfo xRp;
  private ImageView xaN;
  
  public LuckyMoneyNewYearReceiveUI()
  {
    AppMethodBeat.i(65673);
    this.tipDialog = null;
    this.KuI = 0;
    this.KDY = false;
    this.Ilf = "";
    this.KEa = "";
    this.KEb = "";
    this.imagePath = "";
    this.mHandler = new MMHandler();
    this.KEc = false;
    this.xMB = new i.a()
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
                LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, s.getEmojiStorageMgr().adju.bza(LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this).getMd5()));
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
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65681);
    doSceneProgress(new ba(paramInt1, paramInt2, paramString1, paramString2, ah.fXi(), com.tencent.mm.model.z.bAO(), getIntent().getStringExtra("key_username"), "v1.0", paramString3), false);
    AppMethodBeat.o(65681);
  }
  
  private void aac(int paramInt)
  {
    AppMethodBeat.i(65682);
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() localReceiveStatus:%s newStatus:%s", new Object[] { Integer.valueOf(this.KDZ), Integer.valueOf(paramInt) });
    if (this.wPy == null)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() mEmojiInfo == null");
      AppMethodBeat.o(65682);
      return;
    }
    if ((Util.isEqual(this.KDZ, paramInt)) || (Util.isEqual(this.KDZ, 2)))
    {
      AppMethodBeat.o(65682);
      return;
    }
    try
    {
      Object localObject2 = new StringBuilder(this.wPy.field_content);
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
        this.wPy.setContent(localStringBuilder.toString());
        ((n)h.ax(n.class)).gaZ().a(this.wPy.field_msgId, this.wPy);
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
  
  private void fYx()
  {
    AppMethodBeat.i(65678);
    this.KDP.setVisibility(8);
    this.xRp = s.getEmojiStorageMgr().adju.bza(this.Ilf);
    if (this.xRp == null)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showExpression() mEmojiInfo == null ");
      AppMethodBeat.o(65678);
      return;
    }
    if ((y.bEl(this.xRp.kMn()) > 0L) || (this.xRp.aqJ()) || (this.xRp.kMe()))
    {
      this.KDX.setVisibility(0);
      this.KDX.setEmojiInfo(this.xRp);
      AppMethodBeat.o(65678);
      return;
    }
    this.KDX.setVisibility(8);
    this.KDN.setVisibility(0);
    this.KDO.setImageResource(a.h.lucky_money_newyear_creat_loading);
    s.dAj().xMB = this.xMB;
    s.dAj().u(this.xRp);
    AppMethodBeat.o(65678);
  }
  
  private void fYy()
  {
    AppMethodBeat.i(65679);
    this.KDU.setImageResource(a.h.lucky_money_newyear_particle);
    AppMethodBeat.o(65679);
  }
  
  private void ye(boolean paramBoolean)
  {
    AppMethodBeat.i(65683);
    if (paramBoolean)
    {
      this.KDQ.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.KDQ.getLayoutParams()).addRule(3, a.f.lucky_money_newyear_receive_invalid_status);
      this.KDR.setText(getString(a.i.lucky_money_see_detail));
      this.KDQ.setOnClickListener(new LuckyMoneyNewYearReceiveUI.10(this));
      AppMethodBeat.o(65683);
      return;
    }
    this.KDQ.setVisibility(0);
    this.KDQ.setOnClickListener(new LuckyMoneyNewYearReceiveUI.2(this));
    this.KDR.setText(getString(a.i.lucky_money_saved_tips));
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
    this.KnV = findViewById(a.f.lucky_money_newyear_receive_ll);
    this.KDH = ((LuckyMoneyAutoScrollView)findViewById(a.f.lucky_money_newyear_receive_amount));
    this.KDI = ((TextView)findViewById(a.f.lucky_money_amount_unit_title_tv));
    this.JCr = ((TextView)findViewById(a.f.lucky_money_newyear_receive_wishing));
    this.xaN = ((ImageView)findViewById(a.f.lucky_money_newyear_receive_avatar));
    this.KDK = ((LinearLayout)findViewById(a.f.lucky_money_newyear_receive_status_layout));
    this.ttK = ((TextView)findViewById(a.f.lucky_money_newyear_receive_status));
    this.KDL = ((ImageView)findViewById(a.f.lucky_money_newyear_receive_status_icon));
    this.KDJ = ((TextView)findViewById(a.f.lucky_money_newyear_receive_title));
    this.KDM = ((LinearLayout)findViewById(a.f.lucky_money_newyear_receive_senderdesc));
    this.KDU = ((MMAnimateView)findViewById(a.f.particle_gif_image));
    this.KDV = ((ImageView)findViewById(a.f.lucky_money_new_year_good));
    this.KDW = findViewById(a.f.lucky_money_new_year_expression_layout);
    this.KDX = ((BaseEmojiView)findViewById(a.f.lucky_money_new_year_expression));
    this.KDP = ((TextView)findViewById(a.f.lucky_money_new_year_reload_expression));
    this.KDN = ((LinearLayout)findViewById(a.f.lucky_money_new_year_loading_expression));
    this.KDO = ((MMAnimateView)findViewById(a.f.loading_image));
    this.KDQ = ((LinearLayout)findViewById(a.f.lucky_money_click_area));
    this.KDR = ((TextView)findViewById(a.f.lucky_money_click_tv));
    this.KDP.setOnClickListener(new LuckyMoneyNewYearReceiveUI.3(this));
    this.KDS = ((ImageView)findViewById(a.f.lucky_money_new_year_take_cancle_iv));
    this.KDS.setOnClickListener(new LuckyMoneyNewYearReceiveUI.4(this));
    this.KDT = ((ImageView)findViewById(a.f.lucky_money_new_year_take_cancle_good_iv));
    this.KDT.setOnClickListener(new LuckyMoneyNewYearReceiveUI.5(this));
    setContentViewVisibility(8);
    this.tipDialog = k.a(getContext(), getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(65666);
        if ((LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this) != null) && (LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this).isShowing())) {
          LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this).dismiss();
        }
        LuckyMoneyNewYearReceiveUI.this.KzD.forceCancel();
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
    this.lMU = getIntent().getStringExtra("key_username");
    this.Ilf = getIntent().getStringExtra("key_emoji_md5");
    long l = getIntent().getLongExtra("key_msgid", 0L);
    this.wPy = ((n)h.ax(n.class)).gaZ().sl(l);
    this.KDZ = getIntent().getIntExtra("key_msg_newyear_localreceivestatus", 0);
    this.ihx = getIntent().getStringExtra("key_native_url");
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "emojiMd5:" + this.Ilf);
    paramBundle = Uri.parse(Util.nullAsNil(this.ihx));
    try
    {
      this.KqM = paramBundle.getQueryParameter("sendid");
      initView();
      if (!Util.isNullOrNil(this.KqM))
      {
        doSceneProgress(new bf(Util.getInt(paramBundle.getQueryParameter("channelid"), 1), this.KqM, this.ihx, 1, "v1.0", ""), false);
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
    s.dAj().xMB = null;
    AppMethodBeat.o(65676);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65675);
    super.onResume();
    if (this.KEc) {
      finish();
    }
    AppMethodBeat.o(65675);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(65680);
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramp.getType());
    label316:
    boolean bool;
    if ((paramp instanceof bf))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (bf)paramp;
        this.KuI = paramString.KuI;
        if (paramString.fXn())
        {
          Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
          if (paramString.ihz != 4) {
            this.KDM.setVisibility(8);
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.ihz != 5)
          {
            paramp = com.tencent.mm.wallet_core.ui.i.formatMoney2f(paramString.KuU / 100.0D);
            this.KDH.setContentDescription(paramp);
            this.KDH.setFinalText(paramp);
            this.KDH.fYc();
            ah.a(getContext(), this.JCr, paramString.Kmq);
            this.KDK.setVisibility(8);
            this.KDM.setVisibility(0);
            if (paramString.ihz == 4)
            {
              a.b.h(this.xaN, this.lMU);
              aac(2);
              this.KDJ.setText(paramString.KrL);
              this.KDJ.setTextSize(1, 16.0F);
              paramp = (RelativeLayout.LayoutParams)this.KDM.getLayoutParams();
              paramp.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this, 82);
              this.KDM.setLayoutParams(paramp);
              this.KDM.invalidate();
              fYy();
              setContentViewVisibility(0);
              ah.a(this.KnV, null);
              this.KDS.setVisibility(0);
              this.KDT.setVisibility(8);
              bool = true;
              if ((paramString.ihz == 5) || (paramString.ihz == 1)) {
                bool = false;
              }
              Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + paramString.ihz + ", isValidStatus is " + bool);
              if ((!Util.isEqual(this.KuI, 1)) || (Util.isNullOrNil(this.Ilf))) {
                break label1197;
              }
              paramInt1 = 1;
              label427:
              if ((paramInt1 == 0) || (!bool)) {
                break label1202;
              }
              this.KDW.setVisibility(0);
              this.KDV.setVisibility(8);
              fYx();
              label457:
              if ((paramInt1 == 0) || (!bool)) {
                break label1222;
              }
              this.JCr.getLayoutParams();
              this.JCr.setTextSize(1, 21.0F);
              this.KDI.setTextSize(1, 15.0F);
              this.KDH.jF(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height));
              paramString = (LinearLayout.LayoutParams)this.KDH.getLayoutParams();
              paramString.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_new_year_amount_top_margin_for_normal);
              this.KDH.setLayoutParams(paramString);
              this.KDH.invalidate();
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(65680);
          return true;
          this.xaN.setVisibility(8);
          break;
          findViewById(a.f.lucky_money_newyear_receive_desc_area).setVisibility(8);
          ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setText(paramString.KrL);
          ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setVisibility(0);
          ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setTextSize(24.0F);
          ye(true);
          aac(1);
          break label316;
          Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
          if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username")))
          {
            a.b.h(this.xaN, getIntent().getStringExtra("key_username"));
            label694:
            this.KDJ.setTextSize(1, 16.0F);
            ah.a(getContext(), this.KDJ, paramString.KuS + getString(a.i.lucky_money_newyear_send_hb));
            paramp = (RelativeLayout.LayoutParams)this.KDM.getLayoutParams();
            paramp.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this, 30);
            this.KDM.setLayoutParams(paramp);
            this.KDM.invalidate();
            this.KDM.setVisibility(0);
            this.KDK.setVisibility(8);
            if ((paramString.ihA != 0) || (paramString.ihz == 4) || (paramString.ihz == 5) || (paramString.ihz == 1)) {
              break label1005;
            }
            if (!"0".equals(paramString.Kua)) {
              break label978;
            }
            com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.KzD, paramString.Kub, paramString.Kuc, paramString.Kud, paramString.Kue, new a.a()
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
                    LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.channelId, paramString.CAf, paramString.ihx, paramString.KuX);
                  } else if ((paramAnonymousInt1 == 0) && (paramAnonymousBoolean)) {
                    LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.channelId, paramString.CAf, paramString.ihx, paramString.KuX);
                  }
                }
              }
            });
          }
          for (;;)
          {
            paramp = (LinearLayout.LayoutParams)this.KDK.getLayoutParams();
            paramp.topMargin = getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_receive_status_layout_top_margin_for_receiver);
            this.KDK.setLayoutParams(paramp);
            this.KDK.invalidate();
            this.ttK.setTextSize(1, 12.0F);
            this.KDS.setVisibility(8);
            this.KDT.setVisibility(0);
            break;
            if (TextUtils.isEmpty(paramString.KrO)) {
              break label694;
            }
            ah.a(this.xaN, paramString.KrO, paramString.Ksi);
            break label694;
            label978:
            a(paramString.msgType, paramString.channelId, paramString.CAf, paramString.ihx, paramString.KuX);
          }
          label1005:
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.ihz != 5)
          {
            paramp = com.tencent.mm.wallet_core.ui.i.formatMoney2f(paramString.KuU / 100.0D);
            this.KDH.setContentDescription(paramp);
            this.KDH.setFinalText(paramp);
            this.KDH.fYc();
            ah.a(getContext(), this.JCr, paramString.Kmq);
            aac(2);
            fYy();
            ye(false);
          }
          for (;;)
          {
            setContentViewVisibility(0);
            ah.a(this.KnV, null);
            break;
            this.KDQ.setVisibility(8);
            findViewById(a.f.lucky_money_newyear_receive_desc_area).setVisibility(8);
            ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setText(paramString.KrL);
            ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setVisibility(0);
            ((TextView)findViewById(a.f.lucky_money_newyear_receive_invalid_status)).setTextSize(24.0F);
            aac(1);
          }
          label1197:
          paramInt1 = 0;
          break label427;
          label1202:
          this.KDW.setVisibility(8);
          this.KDV.setVisibility(0);
          break label457;
          label1222:
          this.JCr.setTextSize(1, 21.0F);
          this.KDI.setTextSize(1, 18.0F);
          this.KDH.jF(getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_width_for_normal), getResources().getDimensionPixelOffset(a.d.lucky_money_newyear_num_height_for_normal));
          this.KDH.invalidate();
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(65680);
      return false;
    }
    if ((paramp instanceof ba))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ba)paramp;
        if (j.a(paramString.KtV))
        {
          setContentViewVisibility(4);
          paramp = new j(this);
          paramp.VYj = true;
          paramp.b(paramString.KtV);
          AppMethodBeat.o(65680);
          return true;
        }
        this.KuI = paramString.KuI;
        if (!Util.isEqual(this.KuI, 1))
        {
          this.KDW.setVisibility(8);
          this.KDV.setVisibility(0);
        }
        paramp = paramString.KtU;
        this.ttK.setText(paramString.KtU.KrL);
        String str = com.tencent.mm.wallet_core.ui.i.formatMoney2f(paramString.KtU.ihV / 100.0D);
        this.KDH.setContentDescription(str);
        this.KDH.setFinalText(str);
        this.KDH.a(new LuckyMoneyAutoScrollView.a()
        {
          public final void fYe()
          {
            AppMethodBeat.i(65670);
            LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this).setVisibility(4);
            ah.a(LuckyMoneyNewYearReceiveUI.this.getContext(), LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this), paramString.KtU.Kmq);
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
            localAlphaAnimation.setDuration(500L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(65669);
                if (com.tencent.mm.k.i.aRC().getInt("PlayCoinSound", 0) > 0) {
                  l.play(LuckyMoneyNewYearReceiveUI.this, a.i.lucky_cashrecivedrevised);
                }
                if (LuckyMoneyNewYearReceiveUI.8.this.KEg.Koa != null) {
                  LuckyMoneyNewYearReceiveUI.8.this.KEg.Koa.b(LuckyMoneyNewYearReceiveUI.this, null, null);
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
        if ((paramp.ihz == 4) && (!TextUtils.isEmpty(paramString.KtU.KrL))) {
          this.KDL.setVisibility(8);
        }
        ye(false);
        setContentViewVisibility(0);
        ah.a(this.KnV, null);
        aac(2);
        fYy();
        AppMethodBeat.o(65680);
        return true;
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        this.KEc = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
        paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
        bool = ah.a(this, paramInt2, paramp, paramString, true, null, null, 1004);
        AppMethodBeat.o(65680);
        return bool;
      }
      paramp = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramp = getString(a.i.wallet_unknown_err);
      }
      k.a(this, paramp, null, false, new LuckyMoneyNewYearReceiveUI.9(this));
      AppMethodBeat.o(65680);
      return true;
    }
    AppMethodBeat.o(65680);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI
 * JD-Core Version:    0.7.0.1
 */