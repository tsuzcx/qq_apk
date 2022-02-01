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
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.i;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearReceiveUI
  extends LuckyMoneyBaseUI
{
  private String dDM;
  private String fwd;
  private String imagePath;
  private TextView kXs;
  private com.tencent.mm.sdk.platformtools.ap mHandler;
  private bl nLz;
  private ImageView nVN;
  private EmojiInfo oBl;
  private c.a owM;
  private View sZX;
  private TextView swB;
  public int tfC;
  private p tipDialog;
  private String tka;
  private LuckyMoneyAutoScrollView tmQ;
  private TextView tmR;
  private TextView tmS;
  private LinearLayout tmT;
  private ImageView tmU;
  private LinearLayout tmV;
  private LinearLayout tmW;
  private MMAnimateView tmX;
  private TextView tmY;
  private LinearLayout tmZ;
  private TextView tna;
  private ImageView tnb;
  private ImageView tnc;
  private MMAnimateView tnd;
  private ImageView tne;
  private View tnf;
  private BaseEmojiView tng;
  private boolean tnh;
  private String tni;
  private int tnj;
  private String tnk;
  private String tnl;
  private boolean tnm;
  
  public LuckyMoneyNewYearReceiveUI()
  {
    AppMethodBeat.i(65673);
    this.tipDialog = null;
    this.tfC = 0;
    this.tnh = false;
    this.tni = "";
    this.tnk = "";
    this.tnl = "";
    this.imagePath = "";
    this.mHandler = new com.tencent.mm.sdk.platformtools.ap();
    this.tnm = false;
    this.owM = new c.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65662);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65661);
            if ((paramAnonymousEmojiInfo != null) && (LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this) != null) && (LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this).JS().equals(paramAnonymousEmojiInfo.JS())))
            {
              if (paramAnonymousBoolean)
              {
                ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings success.");
                LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.aJx(LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this).JS()));
                LuckyMoneyNewYearReceiveUI.b(LuckyMoneyNewYearReceiveUI.this).setVisibility(8);
                LuckyMoneyNewYearReceiveUI.c(LuckyMoneyNewYearReceiveUI.this).setVisibility(0);
                LuckyMoneyNewYearReceiveUI.c(LuckyMoneyNewYearReceiveUI.this).setEmojiInfo(LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this));
                AppMethodBeat.o(65661);
                return;
              }
              ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings error.");
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
  
  private void Gc(int paramInt)
  {
    AppMethodBeat.i(65682);
    ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() localReceiveStatus:%s newStatus:%s", new Object[] { Integer.valueOf(this.tnj), Integer.valueOf(paramInt) });
    if (this.nLz == null)
    {
      ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() mEmojiInfo == null");
      AppMethodBeat.o(65682);
      return;
    }
    if ((bt.iY(this.tnj, paramInt)) || (bt.iY(this.tnj, 2)))
    {
      AppMethodBeat.o(65682);
      return;
    }
    try
    {
      Object localObject2 = new StringBuilder(this.nLz.field_content);
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
        this.nLz.setContent(localStringBuilder.toString());
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this.nLz.field_msgId, this.nLz);
        ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() success msgXml:%s", new Object[] { localStringBuilder });
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
      ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(65682);
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65681);
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ap(paramInt1, paramInt2, paramString1, paramString2, z.cLy(), com.tencent.mm.model.u.aqI(), getIntent().getStringExtra("key_username"), "v1.0", paramString3), false);
    AppMethodBeat.o(65681);
  }
  
  private void cMB()
  {
    AppMethodBeat.i(65678);
    this.tmY.setVisibility(8);
    this.oBl = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.aJx(this.tni);
    if (this.oBl == null)
    {
      ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showExpression() mEmojiInfo == null ");
      AppMethodBeat.o(65678);
      return;
    }
    if ((i.aMN(this.oBl.gaa()) > 0L) || (this.oBl.CZ()) || (this.oBl.fZQ()))
    {
      this.tng.setVisibility(0);
      this.tng.setEmojiInfo(this.oBl);
      AppMethodBeat.o(65678);
      return;
    }
    this.tng.setVisibility(8);
    this.tmW.setVisibility(0);
    this.tmX.setImageResource(2131690763);
    com.tencent.mm.plugin.emoji.model.k.bUY().owM = this.owM;
    com.tencent.mm.plugin.emoji.model.k.bUY().u(this.oBl);
    AppMethodBeat.o(65678);
  }
  
  private void cMC()
  {
    AppMethodBeat.i(65679);
    this.tnd.setImageResource(2131690764);
    AppMethodBeat.o(65679);
  }
  
  private void mO(boolean paramBoolean)
  {
    AppMethodBeat.i(65683);
    if (paramBoolean)
    {
      this.tmZ.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.tmZ.getLayoutParams()).addRule(3, 2131301881);
      this.tna.setText(getString(2131760948));
      this.tmZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65671);
          ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto detail!");
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_native_url", LuckyMoneyNewYearReceiveUI.j(LuckyMoneyNewYearReceiveUI.this));
          d.b(LuckyMoneyNewYearReceiveUI.this, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramAnonymousView);
          AppMethodBeat.o(65671);
        }
      });
      AppMethodBeat.o(65683);
      return;
    }
    this.tmZ.setVisibility(0);
    this.tmZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65672);
        ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto BalanceManagerUI!");
        com.tencent.mm.pluginsdk.wallet.f.an(LuckyMoneyNewYearReceiveUI.this.getContext(), 1);
        AppMethodBeat.o(65672);
      }
    });
    this.tna.setText(getString(2131760946));
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
    this.sZX = findViewById(2131301882);
    this.tmQ = ((LuckyMoneyAutoScrollView)findViewById(2131301878));
    this.tmR = ((TextView)findViewById(2131301717));
    this.swB = ((TextView)findViewById(2131301889));
    this.nVN = ((ImageView)findViewById(2131301879));
    this.tmT = ((LinearLayout)findViewById(2131301887));
    this.kXs = ((TextView)findViewById(2131301885));
    this.tmU = ((ImageView)findViewById(2131301886));
    this.tmS = ((TextView)findViewById(2131301888));
    this.tmV = ((LinearLayout)findViewById(2131301884));
    this.tnd = ((MMAnimateView)findViewById(2131303142));
    this.tne = ((ImageView)findViewById(2131301869));
    this.tnf = findViewById(2131301866);
    this.tng = ((BaseEmojiView)findViewById(2131301862));
    this.tmY = ((TextView)findViewById(2131301873));
    this.tmW = ((LinearLayout)findViewById(2131301870));
    this.tmX = ((MMAnimateView)findViewById(2131301501));
    this.tmZ = ((LinearLayout)findViewById(2131301738));
    this.tna = ((TextView)findViewById(2131301739));
    this.tmY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65663);
        LuckyMoneyNewYearReceiveUI.e(LuckyMoneyNewYearReceiveUI.this);
        AppMethodBeat.o(65663);
      }
    });
    this.tnb = ((ImageView)findViewById(2131301876));
    this.tnb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65664);
        LuckyMoneyNewYearReceiveUI.this.finish();
        com.tencent.mm.plugin.report.service.h.vKh.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
        AppMethodBeat.o(65664);
      }
    });
    this.tnc = ((ImageView)findViewById(2131301875));
    this.tnc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65665);
        LuckyMoneyNewYearReceiveUI.this.finish();
        com.tencent.mm.plugin.report.service.h.vKh.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
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
        LuckyMoneyNewYearReceiveUI.this.tjY.forceCancel();
        if ((LuckyMoneyNewYearReceiveUI.g(LuckyMoneyNewYearReceiveUI.this).getVisibility() == 8) || (LuckyMoneyNewYearReceiveUI.h(LuckyMoneyNewYearReceiveUI.this).getVisibility() == 4))
        {
          ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
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
    this.fwd = getIntent().getStringExtra("key_username");
    this.tni = getIntent().getStringExtra("key_emoji_md5");
    long l = getIntent().getLongExtra("key_msgid", 0L);
    this.nLz = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(l);
    this.tnj = getIntent().getIntExtra("key_msg_newyear_localreceivestatus", 0);
    this.dDM = getIntent().getStringExtra("key_native_url");
    ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "emojiMd5:" + this.tni);
    paramBundle = Uri.parse(bt.nullAsNil(this.dDM));
    try
    {
      this.tka = paramBundle.getQueryParameter("sendid");
      initView();
      if (!bt.isNullOrNil(this.tka))
      {
        doSceneProgress(new as(bt.getInt(paramBundle.getQueryParameter("channelid"), 1), this.tka, this.dDM, 1, "v1.0"), false);
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
        ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onCreate() Exception:%s", new Object[] { localException.getMessage() });
      }
      finish();
      ad.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
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
    com.tencent.mm.plugin.emoji.model.k.bUY().owM = null;
    AppMethodBeat.o(65676);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65675);
    super.onResume();
    if (this.tnm) {
      finish();
    }
    AppMethodBeat.o(65675);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(65680);
    ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
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
        this.tfC = paramString.tfC;
        if (paramString.tds == 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label667;
          }
          ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
          if (paramString.dDO != 4) {
            this.tmV.setVisibility(8);
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.dDO == 5) {
            break label595;
          }
          paramn = com.tencent.mm.wallet_core.ui.e.D(paramString.tfN / 100.0D);
          this.tmQ.setContentDescription(paramn);
          this.tmQ.setFinalText(paramn);
          this.tmQ.cMj();
          z.a(getContext(), this.swB, paramString.sYt);
          this.tmT.setVisibility(8);
          this.tmV.setVisibility(0);
          if (paramString.dDO != 4) {
            break label583;
          }
          a.b.d(this.nVN, this.fwd);
          Gc(2);
          this.tmS.setText(paramString.tdh);
          this.tmS.setTextSize(1, 16.0F);
          paramn = (RelativeLayout.LayoutParams)this.tmV.getLayoutParams();
          paramn.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this, 82);
          this.tmV.setLayoutParams(paramn);
          this.tmV.invalidate();
          cMC();
          setContentViewVisibility(0);
          z.a(this.sZX, null);
          this.tnb.setVisibility(0);
          this.tnc.setVisibility(8);
          bool = true;
          if ((paramString.dDO == 5) || (paramString.dDO == 1)) {
            bool = false;
          }
          ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + paramString.dDO + ", isValidStatus is " + bool);
          if ((!bt.iY(this.tfC, 1)) || (bt.isNullOrNil(this.tni))) {
            break label1246;
          }
          paramInt1 = 1;
          if ((paramInt1 == 0) || (!bool)) {
            break label1251;
          }
          this.tnf.setVisibility(0);
          this.tne.setVisibility(8);
          cMB();
          if ((paramInt1 == 0) || (!bool)) {
            break label1271;
          }
          this.swB.getLayoutParams();
          this.swB.setTextSize(1, 21.0F);
          this.tmR.setTextSize(1, 15.0F);
          this.tmQ.fZ(getResources().getDimensionPixelOffset(2131166534), getResources().getDimensionPixelOffset(2131166530));
          paramString = (LinearLayout.LayoutParams)this.tmQ.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166517);
          this.tmQ.setLayoutParams(paramString);
          this.tmQ.invalidate();
        }
        for (;;)
        {
          AppMethodBeat.o(65680);
          return true;
          paramInt1 = 0;
          break;
          label583:
          this.nVN.setVisibility(8);
          break label258;
          findViewById(2131301880).setVisibility(8);
          ((TextView)findViewById(2131301881)).setText(paramString.tdh);
          ((TextView)findViewById(2131301881)).setVisibility(0);
          ((TextView)findViewById(2131301881)).setTextSize(24.0F);
          mO(true);
          Gc(1);
          break label323;
          label667:
          ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
          if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username")))
          {
            a.b.d(this.nVN, getIntent().getStringExtra("key_username"));
            label708:
            this.tmS.setTextSize(1, 16.0F);
            z.a(getContext(), this.tmS, paramString.tfM + getString(2131760907));
            paramn = (RelativeLayout.LayoutParams)this.tmV.getLayoutParams();
            paramn.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this, 30);
            this.tmV.setLayoutParams(paramn);
            this.tmV.invalidate();
            this.tmV.setVisibility(0);
            this.tmT.setVisibility(8);
            if ((paramString.dDP != 0) || (paramString.dDO == 4) || (paramString.dDO == 5) || (paramString.dDO == 1)) {
              break label1054;
            }
            if (!"0".equals(paramString.teY)) {
              break label1027;
            }
            paramn = this.tjY;
            str1 = paramString.teZ;
            String str2 = paramString.tfa;
            String str3 = paramString.tfb;
            String str4 = paramString.tfc;
            a.a local6 = new a.a()
            {
              public final boolean run(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(65667);
                ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + paramAnonymousInt1 + ";errCode=" + paramAnonymousInt2 + ";errMsg=" + paramAnonymousString + ";hadAgree = " + paramAnonymousBoolean);
                if (paramAnonymousInt1 == 1) {
                  LuckyMoneyNewYearReceiveUI.this.finish();
                }
                for (;;)
                {
                  AppMethodBeat.o(65667);
                  return true;
                  if (paramAnonymousInt1 == 2) {
                    LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.cJR, paramString.sZn, paramString.dDM, paramString.tfR);
                  } else if ((paramAnonymousInt1 == 0) && (paramAnonymousBoolean)) {
                    LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.cJR, paramString.sZn, paramString.dDM, paramString.tfR);
                  }
                }
              }
            };
            new com.tencent.mm.plugin.wallet_core.id_verify.util.a().a(this, paramn, str1, str2, str3, str4, local6, true, 1005);
          }
          for (;;)
          {
            paramn = (LinearLayout.LayoutParams)this.tmT.getLayoutParams();
            paramn.topMargin = getResources().getDimensionPixelOffset(2131166538);
            this.tmT.setLayoutParams(paramn);
            this.tmT.invalidate();
            this.kXs.setTextSize(1, 12.0F);
            this.tnb.setVisibility(8);
            this.tnc.setVisibility(0);
            break;
            if (TextUtils.isEmpty(paramString.tdk)) {
              break label708;
            }
            z.b(this.nVN, paramString.tdk, paramString.tdE);
            break label708;
            label1027:
            a(paramString.msgType, paramString.cJR, paramString.sZn, paramString.dDM, paramString.tfR);
          }
          label1054:
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.dDO != 5)
          {
            paramn = com.tencent.mm.wallet_core.ui.e.D(paramString.tfN / 100.0D);
            this.tmQ.setContentDescription(paramn);
            this.tmQ.setFinalText(paramn);
            this.tmQ.cMj();
            z.a(getContext(), this.swB, paramString.sYt);
            Gc(2);
            cMC();
            mO(false);
          }
          for (;;)
          {
            setContentViewVisibility(0);
            z.a(this.sZX, null);
            break;
            this.tmZ.setVisibility(8);
            findViewById(2131301880).setVisibility(8);
            ((TextView)findViewById(2131301881)).setText(paramString.tdh);
            ((TextView)findViewById(2131301881)).setVisibility(0);
            ((TextView)findViewById(2131301881)).setTextSize(24.0F);
            Gc(1);
          }
          label1246:
          paramInt1 = 0;
          break label434;
          label1251:
          this.tnf.setVisibility(8);
          this.tne.setVisibility(0);
          break label464;
          label1271:
          this.swB.setTextSize(1, 21.0F);
          this.tmR.setTextSize(1, 18.0F);
          this.tmQ.fZ(getResources().getDimensionPixelOffset(2131166535), getResources().getDimensionPixelOffset(2131166531));
          this.tmQ.invalidate();
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
        if (com.tencent.mm.plugin.wallet_core.utils.c.a(paramString.tfD))
        {
          setContentViewVisibility(4);
          paramn = new com.tencent.mm.plugin.wallet_core.utils.c(this);
          paramn.Avm = true;
          paramn.b(paramString.tfD);
          AppMethodBeat.o(65680);
          return true;
        }
        this.tfC = paramString.tfC;
        if (!bt.iY(this.tfC, 1))
        {
          this.tnf.setVisibility(8);
          this.tne.setVisibility(0);
        }
        paramn = paramString.teT;
        this.kXs.setText(paramString.teT.tdh);
        str1 = com.tencent.mm.wallet_core.ui.e.D(paramString.teT.dEb / 100.0D);
        this.tmQ.setContentDescription(str1);
        this.tmQ.setFinalText(str1);
        this.tmQ.a(new LuckyMoneyAutoScrollView.a()
        {
          public final void cMk()
          {
            AppMethodBeat.i(65670);
            LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this).setVisibility(4);
            z.a(LuckyMoneyNewYearReceiveUI.this.getContext(), LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this), paramString.teT.sYt);
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
            localAlphaAnimation.setDuration(500L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(65669);
                if (com.tencent.mm.m.g.Zd().getInt("PlayCoinSound", 0) > 0) {
                  k.a(LuckyMoneyNewYearReceiveUI.this, k.a.tqF);
                }
                if (LuckyMoneyNewYearReceiveUI.7.this.tnq.tac != null) {
                  LuckyMoneyNewYearReceiveUI.7.this.tnq.tac.b(LuckyMoneyNewYearReceiveUI.this, null, null);
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
        if ((paramn.dDO == 4) && (!TextUtils.isEmpty(paramString.teT.tdh))) {
          this.tmU.setVisibility(8);
        }
        mO(false);
        setContentViewVisibility(0);
        z.a(this.sZX, null);
        Gc(2);
        cMC();
        AppMethodBeat.o(65680);
        return true;
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        this.tnm = true;
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