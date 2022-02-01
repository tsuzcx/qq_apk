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
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.i;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearReceiveUI
  extends LuckyMoneyBaseUI
{
  private String dBy;
  private String fzK;
  private String imagePath;
  private TextView lzc;
  private ao mHandler;
  private bo ooz;
  private ImageView ozi;
  private c.a pam;
  private EmojiInfo peL;
  private TextView tEq;
  private p tipDialog;
  private View uim;
  public int unR;
  private String ust;
  private boolean uvA;
  private String uvB;
  private int uvC;
  private String uvD;
  private String uvE;
  private boolean uvF;
  private LuckyMoneyAutoScrollView uvj;
  private TextView uvk;
  private TextView uvl;
  private LinearLayout uvm;
  private ImageView uvn;
  private LinearLayout uvo;
  private LinearLayout uvp;
  private MMAnimateView uvq;
  private TextView uvr;
  private LinearLayout uvs;
  private TextView uvt;
  private ImageView uvu;
  private ImageView uvv;
  private MMAnimateView uvw;
  private ImageView uvx;
  private View uvy;
  private BaseEmojiView uvz;
  
  public LuckyMoneyNewYearReceiveUI()
  {
    AppMethodBeat.i(65673);
    this.tipDialog = null;
    this.unR = 0;
    this.uvA = false;
    this.uvB = "";
    this.uvD = "";
    this.uvE = "";
    this.imagePath = "";
    this.mHandler = new ao();
    this.uvF = false;
    this.pam = new c.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65662);
        com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65661);
            if ((paramAnonymousEmojiInfo != null) && (LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this) != null) && (LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this).JC().equals(paramAnonymousEmojiInfo.JC())))
            {
              if (paramAnonymousBoolean)
              {
                ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings success.");
                LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.aOT(LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this).JC()));
                LuckyMoneyNewYearReceiveUI.b(LuckyMoneyNewYearReceiveUI.this).setVisibility(8);
                LuckyMoneyNewYearReceiveUI.c(LuckyMoneyNewYearReceiveUI.this).setVisibility(0);
                LuckyMoneyNewYearReceiveUI.c(LuckyMoneyNewYearReceiveUI.this).setEmojiInfo(LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this));
                AppMethodBeat.o(65661);
                return;
              }
              ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings error.");
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
  
  private void HX(int paramInt)
  {
    AppMethodBeat.i(65682);
    ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() localReceiveStatus:%s newStatus:%s", new Object[] { Integer.valueOf(this.uvC), Integer.valueOf(paramInt) });
    if (this.ooz == null)
    {
      ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() mEmojiInfo == null");
      AppMethodBeat.o(65682);
      return;
    }
    if ((bs.jl(this.uvC, paramInt)) || (bs.jl(this.uvC, 2)))
    {
      AppMethodBeat.o(65682);
      return;
    }
    try
    {
      Object localObject2 = new StringBuilder(this.ooz.field_content);
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
        this.ooz.setContent(localStringBuilder.toString());
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(this.ooz.field_msgId, this.ooz);
        ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() success msgXml:%s", new Object[] { localStringBuilder });
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
      ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(65682);
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65681);
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ap(paramInt1, paramInt2, paramString1, paramString2, z.cZe(), com.tencent.mm.model.u.axy(), getIntent().getStringExtra("key_username"), "v1.0", paramString3), false);
    AppMethodBeat.o(65681);
  }
  
  private void dah()
  {
    AppMethodBeat.i(65678);
    this.uvr.setVisibility(8);
    this.peL = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.aOT(this.uvB);
    if (this.peL == null)
    {
      ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showExpression() mEmojiInfo == null ");
      AppMethodBeat.o(65678);
      return;
    }
    if ((i.aSp(this.peL.ghd()) > 0L) || (this.peL.CC()) || (this.peL.fxI()))
    {
      this.uvz.setVisibility(0);
      this.uvz.setEmojiInfo(this.peL);
      AppMethodBeat.o(65678);
      return;
    }
    this.uvz.setVisibility(8);
    this.uvp.setVisibility(0);
    this.uvq.setImageResource(2131690763);
    com.tencent.mm.plugin.emoji.model.k.ccl().pam = this.pam;
    com.tencent.mm.plugin.emoji.model.k.ccl().u(this.peL);
    AppMethodBeat.o(65678);
  }
  
  private void dai()
  {
    AppMethodBeat.i(65679);
    this.uvw.setImageResource(2131690764);
    AppMethodBeat.o(65679);
  }
  
  private void nG(boolean paramBoolean)
  {
    AppMethodBeat.i(65683);
    if (paramBoolean)
    {
      this.uvs.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.uvs.getLayoutParams()).addRule(3, 2131301881);
      this.uvt.setText(getString(2131760948));
      this.uvs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65671);
          ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto detail!");
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_native_url", LuckyMoneyNewYearReceiveUI.j(LuckyMoneyNewYearReceiveUI.this));
          d.b(LuckyMoneyNewYearReceiveUI.this, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramAnonymousView);
          AppMethodBeat.o(65671);
        }
      });
      AppMethodBeat.o(65683);
      return;
    }
    this.uvs.setVisibility(0);
    this.uvs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65672);
        ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto BalanceManagerUI!");
        com.tencent.mm.pluginsdk.wallet.f.at(LuckyMoneyNewYearReceiveUI.this.getContext(), 1);
        AppMethodBeat.o(65672);
      }
    });
    this.uvt.setText(getString(2131760946));
    AppMethodBeat.o(65683);
  }
  
  public int getLayoutId()
  {
    return 2131494652;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65677);
    setActionbarColor(-839716110);
    this.uim = findViewById(2131301882);
    this.uvj = ((LuckyMoneyAutoScrollView)findViewById(2131301878));
    this.uvk = ((TextView)findViewById(2131301717));
    this.tEq = ((TextView)findViewById(2131301889));
    this.ozi = ((ImageView)findViewById(2131301879));
    this.uvm = ((LinearLayout)findViewById(2131301887));
    this.lzc = ((TextView)findViewById(2131301885));
    this.uvn = ((ImageView)findViewById(2131301886));
    this.uvl = ((TextView)findViewById(2131301888));
    this.uvo = ((LinearLayout)findViewById(2131301884));
    this.uvw = ((MMAnimateView)findViewById(2131303142));
    this.uvx = ((ImageView)findViewById(2131301869));
    this.uvy = findViewById(2131301866);
    this.uvz = ((BaseEmojiView)findViewById(2131301862));
    this.uvr = ((TextView)findViewById(2131301873));
    this.uvp = ((LinearLayout)findViewById(2131301870));
    this.uvq = ((MMAnimateView)findViewById(2131301501));
    this.uvs = ((LinearLayout)findViewById(2131301738));
    this.uvt = ((TextView)findViewById(2131301739));
    this.uvr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65663);
        LuckyMoneyNewYearReceiveUI.e(LuckyMoneyNewYearReceiveUI.this);
        AppMethodBeat.o(65663);
      }
    });
    this.uvu = ((ImageView)findViewById(2131301876));
    this.uvu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65664);
        LuckyMoneyNewYearReceiveUI.this.finish();
        com.tencent.mm.plugin.report.service.h.wUl.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
        AppMethodBeat.o(65664);
      }
    });
    this.uvv = ((ImageView)findViewById(2131301875));
    this.uvv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65665);
        LuckyMoneyNewYearReceiveUI.this.finish();
        com.tencent.mm.plugin.report.service.h.wUl.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
        AppMethodBeat.o(65665);
      }
    });
    setContentViewVisibility(8);
    this.tipDialog = com.tencent.mm.ui.base.h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(65666);
        if ((LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this) != null) && (LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this).isShowing())) {
          LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this).dismiss();
        }
        LuckyMoneyNewYearReceiveUI.this.usr.forceCancel();
        if ((LuckyMoneyNewYearReceiveUI.g(LuckyMoneyNewYearReceiveUI.this).getVisibility() == 8) || (LuckyMoneyNewYearReceiveUI.h(LuckyMoneyNewYearReceiveUI.this).getVisibility() == 4))
        {
          ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
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
    this.fzK = getIntent().getStringExtra("key_username");
    this.uvB = getIntent().getStringExtra("key_emoji_md5");
    long l = getIntent().getLongExtra("key_msgid", 0L);
    this.ooz = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(l);
    this.uvC = getIntent().getIntExtra("key_msg_newyear_localreceivestatus", 0);
    this.dBy = getIntent().getStringExtra("key_native_url");
    ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "emojiMd5:" + this.uvB);
    paramBundle = Uri.parse(bs.nullAsNil(this.dBy));
    try
    {
      this.ust = paramBundle.getQueryParameter("sendid");
      initView();
      if (!bs.isNullOrNil(this.ust))
      {
        doSceneProgress(new as(bs.getInt(paramBundle.getQueryParameter("channelid"), 1), this.ust, this.dBy, 1, "v1.0"), false);
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
        ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onCreate() Exception:%s", new Object[] { localException.getMessage() });
      }
      finish();
      ac.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
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
    com.tencent.mm.plugin.emoji.model.k.ccl().pam = null;
    AppMethodBeat.o(65676);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65675);
    super.onResume();
    if (this.uvF) {
      finish();
    }
    AppMethodBeat.o(65675);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(65680);
    ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    label258:
    label323:
    boolean bool;
    label434:
    label464:
    label595:
    String str1;
    if ((paramn instanceof as))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (as)paramn;
        this.unR = paramString.unR;
        if (paramString.ulH == 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label667;
          }
          ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
          if (paramString.dBA != 4) {
            this.uvo.setVisibility(8);
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.dBA == 5) {
            break label595;
          }
          paramn = com.tencent.mm.wallet_core.ui.e.C(paramString.uoc / 100.0D);
          this.uvj.setContentDescription(paramn);
          this.uvj.setFinalText(paramn);
          this.uvj.cZP();
          z.a(getContext(), this.tEq, paramString.ugH);
          this.uvm.setVisibility(8);
          this.uvo.setVisibility(0);
          if (paramString.dBA != 4) {
            break label583;
          }
          a.b.d(this.ozi, this.fzK);
          HX(2);
          this.uvl.setText(paramString.ulw);
          this.uvl.setTextSize(1, 16.0F);
          paramn = (RelativeLayout.LayoutParams)this.uvo.getLayoutParams();
          paramn.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this, 82);
          this.uvo.setLayoutParams(paramn);
          this.uvo.invalidate();
          dai();
          setContentViewVisibility(0);
          z.a(this.uim, null);
          this.uvu.setVisibility(0);
          this.uvv.setVisibility(8);
          bool = true;
          if ((paramString.dBA == 5) || (paramString.dBA == 1)) {
            bool = false;
          }
          ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + paramString.dBA + ", isValidStatus is " + bool);
          if ((!bs.jl(this.unR, 1)) || (bs.isNullOrNil(this.uvB))) {
            break label1246;
          }
          paramInt1 = 1;
          if ((paramInt1 == 0) || (!bool)) {
            break label1251;
          }
          this.uvy.setVisibility(0);
          this.uvx.setVisibility(8);
          dah();
          if ((paramInt1 == 0) || (!bool)) {
            break label1271;
          }
          this.tEq.getLayoutParams();
          this.tEq.setTextSize(1, 21.0F);
          this.uvk.setTextSize(1, 15.0F);
          this.uvj.gg(getResources().getDimensionPixelOffset(2131166534), getResources().getDimensionPixelOffset(2131166530));
          paramString = (LinearLayout.LayoutParams)this.uvj.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166517);
          this.uvj.setLayoutParams(paramString);
          this.uvj.invalidate();
        }
        for (;;)
        {
          AppMethodBeat.o(65680);
          return true;
          paramInt1 = 0;
          break;
          label583:
          this.ozi.setVisibility(8);
          break label258;
          findViewById(2131301880).setVisibility(8);
          ((TextView)findViewById(2131301881)).setText(paramString.ulw);
          ((TextView)findViewById(2131301881)).setVisibility(0);
          ((TextView)findViewById(2131301881)).setTextSize(24.0F);
          nG(true);
          HX(1);
          break label323;
          label667:
          ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
          if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username")))
          {
            a.b.d(this.ozi, getIntent().getStringExtra("key_username"));
            label708:
            this.uvl.setTextSize(1, 16.0F);
            z.a(getContext(), this.uvl, paramString.uob + getString(2131760907));
            paramn = (RelativeLayout.LayoutParams)this.uvo.getLayoutParams();
            paramn.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this, 30);
            this.uvo.setLayoutParams(paramn);
            this.uvo.invalidate();
            this.uvo.setVisibility(0);
            this.uvm.setVisibility(8);
            if ((paramString.dBB != 0) || (paramString.dBA == 4) || (paramString.dBA == 5) || (paramString.dBA == 1)) {
              break label1054;
            }
            if (!"0".equals(paramString.unn)) {
              break label1027;
            }
            paramn = this.usr;
            str1 = paramString.uno;
            String str2 = paramString.unp;
            String str3 = paramString.unq;
            String str4 = paramString.unr;
            a.a local6 = new a.a()
            {
              public final boolean run(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(65667);
                ac.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + paramAnonymousInt1 + ";errCode=" + paramAnonymousInt2 + ";errMsg=" + paramAnonymousString + ";hadAgree = " + paramAnonymousBoolean);
                if (paramAnonymousInt1 == 1) {
                  LuckyMoneyNewYearReceiveUI.this.finish();
                }
                for (;;)
                {
                  AppMethodBeat.o(65667);
                  return true;
                  if (paramAnonymousInt1 == 2) {
                    LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.cGY, paramString.uhB, paramString.dBy, paramString.uog);
                  } else if ((paramAnonymousInt1 == 0) && (paramAnonymousBoolean)) {
                    LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.cGY, paramString.uhB, paramString.dBy, paramString.uog);
                  }
                }
              }
            };
            new com.tencent.mm.plugin.wallet_core.id_verify.util.a().a(this, paramn, str1, str2, str3, str4, local6, true, 1005);
          }
          for (;;)
          {
            paramn = (LinearLayout.LayoutParams)this.uvm.getLayoutParams();
            paramn.topMargin = getResources().getDimensionPixelOffset(2131166538);
            this.uvm.setLayoutParams(paramn);
            this.uvm.invalidate();
            this.lzc.setTextSize(1, 12.0F);
            this.uvu.setVisibility(8);
            this.uvv.setVisibility(0);
            break;
            if (TextUtils.isEmpty(paramString.ulz)) {
              break label708;
            }
            z.b(this.ozi, paramString.ulz, paramString.ulT);
            break label708;
            label1027:
            a(paramString.msgType, paramString.cGY, paramString.uhB, paramString.dBy, paramString.uog);
          }
          label1054:
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.dBA != 5)
          {
            paramn = com.tencent.mm.wallet_core.ui.e.C(paramString.uoc / 100.0D);
            this.uvj.setContentDescription(paramn);
            this.uvj.setFinalText(paramn);
            this.uvj.cZP();
            z.a(getContext(), this.tEq, paramString.ugH);
            HX(2);
            dai();
            nG(false);
          }
          for (;;)
          {
            setContentViewVisibility(0);
            z.a(this.uim, null);
            break;
            this.uvs.setVisibility(8);
            findViewById(2131301880).setVisibility(8);
            ((TextView)findViewById(2131301881)).setText(paramString.ulw);
            ((TextView)findViewById(2131301881)).setVisibility(0);
            ((TextView)findViewById(2131301881)).setTextSize(24.0F);
            HX(1);
          }
          label1246:
          paramInt1 = 0;
          break label434;
          label1251:
          this.uvy.setVisibility(8);
          this.uvx.setVisibility(0);
          break label464;
          label1271:
          this.tEq.setTextSize(1, 21.0F);
          this.uvk.setTextSize(1, 18.0F);
          this.uvj.gg(getResources().getDimensionPixelOffset(2131166535), getResources().getDimensionPixelOffset(2131166531));
          this.uvj.invalidate();
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(65680);
      return false;
    }
    if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.ap))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.luckymoney.model.ap)paramn;
        if (com.tencent.mm.plugin.wallet_core.utils.c.a(paramString.unS))
        {
          setContentViewVisibility(4);
          paramn = new com.tencent.mm.plugin.wallet_core.utils.c(this);
          paramn.BNG = true;
          paramn.b(paramString.unS);
          AppMethodBeat.o(65680);
          return true;
        }
        this.unR = paramString.unR;
        if (!bs.jl(this.unR, 1))
        {
          this.uvy.setVisibility(8);
          this.uvx.setVisibility(0);
        }
        paramn = paramString.uni;
        this.lzc.setText(paramString.uni.ulw);
        str1 = com.tencent.mm.wallet_core.ui.e.C(paramString.uni.dBN / 100.0D);
        this.uvj.setContentDescription(str1);
        this.uvj.setFinalText(str1);
        this.uvj.a(new LuckyMoneyAutoScrollView.a()
        {
          public final void cZQ()
          {
            AppMethodBeat.i(65670);
            LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this).setVisibility(4);
            z.a(LuckyMoneyNewYearReceiveUI.this.getContext(), LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this), paramString.uni.ugH);
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
            localAlphaAnimation.setDuration(500L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(65669);
                if (com.tencent.mm.m.g.ZY().getInt("PlayCoinSound", 0) > 0) {
                  k.a(LuckyMoneyNewYearReceiveUI.this, k.a.uyW);
                }
                if (LuckyMoneyNewYearReceiveUI.7.this.uvJ.uis != null) {
                  LuckyMoneyNewYearReceiveUI.7.this.uvJ.uis.b(LuckyMoneyNewYearReceiveUI.this, null, null);
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
        if ((paramn.dBA == 4) && (!TextUtils.isEmpty(paramString.uni.ulw))) {
          this.uvn.setVisibility(8);
        }
        nG(false);
        setContentViewVisibility(0);
        z.a(this.uim, null);
        HX(2);
        dai();
        AppMethodBeat.o(65680);
        return true;
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        this.uvF = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
        paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
        bool = z.a(this, paramInt2, paramn, paramString, true, null, 1004);
        AppMethodBeat.o(65680);
        return bool;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI
 * JD-Core Version:    0.7.0.1
 */