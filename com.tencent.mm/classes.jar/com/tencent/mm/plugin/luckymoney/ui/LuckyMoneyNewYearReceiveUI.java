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
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearReceiveUI
  extends LuckyMoneyBaseUI
{
  private String dNL;
  private String fTa;
  private String imagePath;
  private TextView lYA;
  private com.tencent.mm.sdk.platformtools.ap mHandler;
  private bu oRU;
  private c.a pDW;
  private EmojiInfo pIn;
  private ImageView pcD;
  private p tipDialog;
  private TextView uGZ;
  private View vkV;
  public int vqx;
  private String vuW;
  private LuckyMoneyAutoScrollView vxM;
  private TextView vxN;
  private TextView vxO;
  private LinearLayout vxP;
  private ImageView vxQ;
  private LinearLayout vxR;
  private LinearLayout vxS;
  private MMAnimateView vxT;
  private TextView vxU;
  private LinearLayout vxV;
  private TextView vxW;
  private ImageView vxX;
  private ImageView vxY;
  private MMAnimateView vxZ;
  private ImageView vya;
  private View vyb;
  private BaseEmojiView vyc;
  private boolean vyd;
  private String vye;
  private int vyf;
  private String vyg;
  private String vyh;
  private boolean vyi;
  
  public LuckyMoneyNewYearReceiveUI()
  {
    AppMethodBeat.i(65673);
    this.tipDialog = null;
    this.vqx = 0;
    this.vyd = false;
    this.vye = "";
    this.vyg = "";
    this.vyh = "";
    this.imagePath = "";
    this.mHandler = new com.tencent.mm.sdk.platformtools.ap();
    this.vyi = false;
    this.pDW = new c.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65662);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65661);
            if ((paramAnonymousEmojiInfo != null) && (LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this) != null) && (LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this).Lb().equals(paramAnonymousEmojiInfo.Lb())))
            {
              if (paramAnonymousBoolean)
              {
                ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings success.");
                LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn.aUK(LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this).Lb()));
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
  
  private void Jt(int paramInt)
  {
    AppMethodBeat.i(65682);
    ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() localReceiveStatus:%s newStatus:%s", new Object[] { Integer.valueOf(this.vyf), Integer.valueOf(paramInt) });
    if (this.oRU == null)
    {
      ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() mEmojiInfo == null");
      AppMethodBeat.o(65682);
      return;
    }
    if ((bt.jx(this.vyf, paramInt)) || (bt.jx(this.vyf, 2)))
    {
      AppMethodBeat.o(65682);
      return;
    }
    try
    {
      Object localObject2 = new StringBuilder(this.oRU.field_content);
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
        this.oRU.setContent(localStringBuilder.toString());
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(this.oRU.field_msgId, this.oRU);
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
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ap(paramInt1, paramInt2, paramString1, paramString2, z.diq(), com.tencent.mm.model.u.aAo(), getIntent().getStringExtra("key_username"), "v1.0", paramString3), false);
    AppMethodBeat.o(65681);
  }
  
  private void dju()
  {
    AppMethodBeat.i(65678);
    this.vxU.setVisibility(8);
    this.pIn = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn.aUK(this.vye);
    if (this.pIn == null)
    {
      ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showExpression() mEmojiInfo == null ");
      AppMethodBeat.o(65678);
      return;
    }
    if ((com.tencent.mm.vfs.i.aYo(this.pIn.gzQ()) > 0L) || (this.pIn.Eb()) || (this.pIn.fOy()))
    {
      this.vyc.setVisibility(0);
      this.vyc.setEmojiInfo(this.pIn);
      AppMethodBeat.o(65678);
      return;
    }
    this.vyc.setVisibility(8);
    this.vxS.setVisibility(0);
    this.vxT.setImageResource(2131690763);
    com.tencent.mm.plugin.emoji.model.k.cgP().pDW = this.pDW;
    com.tencent.mm.plugin.emoji.model.k.cgP().u(this.pIn);
    AppMethodBeat.o(65678);
  }
  
  private void djv()
  {
    AppMethodBeat.i(65679);
    this.vxZ.setImageResource(2131690764);
    AppMethodBeat.o(65679);
  }
  
  private void oa(boolean paramBoolean)
  {
    AppMethodBeat.i(65683);
    if (paramBoolean)
    {
      this.vxV.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.vxV.getLayoutParams()).addRule(3, 2131301881);
      this.vxW.setText(getString(2131760948));
      this.vxV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65671);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto detail!");
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_native_url", LuckyMoneyNewYearReceiveUI.j(LuckyMoneyNewYearReceiveUI.this));
          d.b(LuckyMoneyNewYearReceiveUI.this, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65671);
        }
      });
      AppMethodBeat.o(65683);
      return;
    }
    this.vxV.setVisibility(0);
    this.vxV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65672);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto BalanceManagerUI!");
        com.tencent.mm.pluginsdk.wallet.f.aw(LuckyMoneyNewYearReceiveUI.this.getContext(), 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65672);
      }
    });
    this.vxW.setText(getString(2131760946));
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
    this.vkV = findViewById(2131301882);
    this.vxM = ((LuckyMoneyAutoScrollView)findViewById(2131301878));
    this.vxN = ((TextView)findViewById(2131301717));
    this.uGZ = ((TextView)findViewById(2131301889));
    this.pcD = ((ImageView)findViewById(2131301879));
    this.vxP = ((LinearLayout)findViewById(2131301887));
    this.lYA = ((TextView)findViewById(2131301885));
    this.vxQ = ((ImageView)findViewById(2131301886));
    this.vxO = ((TextView)findViewById(2131301888));
    this.vxR = ((LinearLayout)findViewById(2131301884));
    this.vxZ = ((MMAnimateView)findViewById(2131303142));
    this.vya = ((ImageView)findViewById(2131301869));
    this.vyb = findViewById(2131301866);
    this.vyc = ((BaseEmojiView)findViewById(2131301862));
    this.vxU = ((TextView)findViewById(2131301873));
    this.vxS = ((LinearLayout)findViewById(2131301870));
    this.vxT = ((MMAnimateView)findViewById(2131301501));
    this.vxV = ((LinearLayout)findViewById(2131301738));
    this.vxW = ((TextView)findViewById(2131301739));
    this.vxU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65663);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LuckyMoneyNewYearReceiveUI.e(LuckyMoneyNewYearReceiveUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65663);
      }
    });
    this.vxX = ((ImageView)findViewById(2131301876));
    this.vxX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65664);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LuckyMoneyNewYearReceiveUI.this.finish();
        com.tencent.mm.plugin.report.service.g.yhR.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65664);
      }
    });
    this.vxY = ((ImageView)findViewById(2131301875));
    this.vxY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65665);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LuckyMoneyNewYearReceiveUI.this.finish();
        com.tencent.mm.plugin.report.service.g.yhR.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65665);
      }
    });
    setContentViewVisibility(8);
    this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(65666);
        if ((LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this) != null) && (LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this).isShowing())) {
          LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this).dismiss();
        }
        LuckyMoneyNewYearReceiveUI.this.vuU.forceCancel();
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
    this.fTa = getIntent().getStringExtra("key_username");
    this.vye = getIntent().getStringExtra("key_emoji_md5");
    long l = getIntent().getLongExtra("key_msgid", 0L);
    this.oRU = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(l);
    this.vyf = getIntent().getIntExtra("key_msg_newyear_localreceivestatus", 0);
    this.dNL = getIntent().getStringExtra("key_native_url");
    ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "emojiMd5:" + this.vye);
    paramBundle = Uri.parse(bt.nullAsNil(this.dNL));
    try
    {
      this.vuW = paramBundle.getQueryParameter("sendid");
      initView();
      if (!bt.isNullOrNil(this.vuW))
      {
        doSceneProgress(new as(bt.getInt(paramBundle.getQueryParameter("channelid"), 1), this.vuW, this.dNL, 1, "v1.0"), false);
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
    com.tencent.mm.plugin.emoji.model.k.cgP().pDW = null;
    AppMethodBeat.o(65676);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65675);
    super.onResume();
    if (this.vyi) {
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
        this.vqx = paramString.vqx;
        if (paramString.von == 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label667;
          }
          ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
          if (paramString.dNN != 4) {
            this.vxR.setVisibility(8);
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.dNN == 5) {
            break label595;
          }
          paramn = com.tencent.mm.wallet_core.ui.e.C(paramString.vqG / 100.0D);
          this.vxM.setContentDescription(paramn);
          this.vxM.setFinalText(paramn);
          this.vxM.djc();
          z.a(getContext(), this.uGZ, paramString.vjr);
          this.vxP.setVisibility(8);
          this.vxR.setVisibility(0);
          if (paramString.dNN != 4) {
            break label583;
          }
          a.b.d(this.pcD, this.fTa);
          Jt(2);
          this.vxO.setText(paramString.voc);
          this.vxO.setTextSize(1, 16.0F);
          paramn = (RelativeLayout.LayoutParams)this.vxR.getLayoutParams();
          paramn.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this, 82);
          this.vxR.setLayoutParams(paramn);
          this.vxR.invalidate();
          djv();
          setContentViewVisibility(0);
          z.a(this.vkV, null);
          this.vxX.setVisibility(0);
          this.vxY.setVisibility(8);
          bool = true;
          if ((paramString.dNN == 5) || (paramString.dNN == 1)) {
            bool = false;
          }
          ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + paramString.dNN + ", isValidStatus is " + bool);
          if ((!bt.jx(this.vqx, 1)) || (bt.isNullOrNil(this.vye))) {
            break label1246;
          }
          paramInt1 = 1;
          if ((paramInt1 == 0) || (!bool)) {
            break label1251;
          }
          this.vyb.setVisibility(0);
          this.vya.setVisibility(8);
          dju();
          if ((paramInt1 == 0) || (!bool)) {
            break label1271;
          }
          this.uGZ.getLayoutParams();
          this.uGZ.setTextSize(1, 21.0F);
          this.vxN.setTextSize(1, 15.0F);
          this.vxM.gx(getResources().getDimensionPixelOffset(2131166534), getResources().getDimensionPixelOffset(2131166530));
          paramString = (LinearLayout.LayoutParams)this.vxM.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166517);
          this.vxM.setLayoutParams(paramString);
          this.vxM.invalidate();
        }
        for (;;)
        {
          AppMethodBeat.o(65680);
          return true;
          paramInt1 = 0;
          break;
          label583:
          this.pcD.setVisibility(8);
          break label258;
          findViewById(2131301880).setVisibility(8);
          ((TextView)findViewById(2131301881)).setText(paramString.voc);
          ((TextView)findViewById(2131301881)).setVisibility(0);
          ((TextView)findViewById(2131301881)).setTextSize(24.0F);
          oa(true);
          Jt(1);
          break label323;
          label667:
          ad.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
          if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username")))
          {
            a.b.d(this.pcD, getIntent().getStringExtra("key_username"));
            label708:
            this.vxO.setTextSize(1, 16.0F);
            z.a(getContext(), this.vxO, paramString.vqF + getString(2131760907));
            paramn = (RelativeLayout.LayoutParams)this.vxR.getLayoutParams();
            paramn.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this, 30);
            this.vxR.setLayoutParams(paramn);
            this.vxR.invalidate();
            this.vxR.setVisibility(0);
            this.vxP.setVisibility(8);
            if ((paramString.dNO != 0) || (paramString.dNN == 4) || (paramString.dNN == 5) || (paramString.dNN == 1)) {
              break label1054;
            }
            if (!"0".equals(paramString.vpT)) {
              break label1027;
            }
            paramn = this.vuU;
            str1 = paramString.vpU;
            String str2 = paramString.vpV;
            String str3 = paramString.vpW;
            String str4 = paramString.vpX;
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
                    LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.cSc, paramString.vkl, paramString.dNL, paramString.vqK);
                  } else if ((paramAnonymousInt1 == 0) && (paramAnonymousBoolean)) {
                    LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.cSc, paramString.vkl, paramString.dNL, paramString.vqK);
                  }
                }
              }
            };
            new com.tencent.mm.plugin.wallet_core.id_verify.util.a().a(this, paramn, str1, str2, str3, str4, local6, true, 1005);
          }
          for (;;)
          {
            paramn = (LinearLayout.LayoutParams)this.vxP.getLayoutParams();
            paramn.topMargin = getResources().getDimensionPixelOffset(2131166538);
            this.vxP.setLayoutParams(paramn);
            this.vxP.invalidate();
            this.lYA.setTextSize(1, 12.0F);
            this.vxX.setVisibility(8);
            this.vxY.setVisibility(0);
            break;
            if (TextUtils.isEmpty(paramString.vof)) {
              break label708;
            }
            z.b(this.pcD, paramString.vof, paramString.voz);
            break label708;
            label1027:
            a(paramString.msgType, paramString.cSc, paramString.vkl, paramString.dNL, paramString.vqK);
          }
          label1054:
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.dNN != 5)
          {
            paramn = com.tencent.mm.wallet_core.ui.e.C(paramString.vqG / 100.0D);
            this.vxM.setContentDescription(paramn);
            this.vxM.setFinalText(paramn);
            this.vxM.djc();
            z.a(getContext(), this.uGZ, paramString.vjr);
            Jt(2);
            djv();
            oa(false);
          }
          for (;;)
          {
            setContentViewVisibility(0);
            z.a(this.vkV, null);
            break;
            this.vxV.setVisibility(8);
            findViewById(2131301880).setVisibility(8);
            ((TextView)findViewById(2131301881)).setText(paramString.voc);
            ((TextView)findViewById(2131301881)).setVisibility(0);
            ((TextView)findViewById(2131301881)).setTextSize(24.0F);
            Jt(1);
          }
          label1246:
          paramInt1 = 0;
          break label434;
          label1251:
          this.vyb.setVisibility(8);
          this.vya.setVisibility(0);
          break label464;
          label1271:
          this.uGZ.setTextSize(1, 21.0F);
          this.vxN.setTextSize(1, 18.0F);
          this.vxM.gx(getResources().getDimensionPixelOffset(2131166535), getResources().getDimensionPixelOffset(2131166531));
          this.vxM.invalidate();
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
        if (com.tencent.mm.plugin.wallet_core.utils.c.a(paramString.vqy))
        {
          setContentViewVisibility(4);
          paramn = new com.tencent.mm.plugin.wallet_core.utils.c(this);
          paramn.DnY = true;
          paramn.b(paramString.vqy);
          AppMethodBeat.o(65680);
          return true;
        }
        this.vqx = paramString.vqx;
        if (!bt.jx(this.vqx, 1))
        {
          this.vyb.setVisibility(8);
          this.vya.setVisibility(0);
        }
        paramn = paramString.vpO;
        this.lYA.setText(paramString.vpO.voc);
        str1 = com.tencent.mm.wallet_core.ui.e.C(paramString.vpO.dOa / 100.0D);
        this.vxM.setContentDescription(str1);
        this.vxM.setFinalText(str1);
        this.vxM.a(new LuckyMoneyAutoScrollView.a()
        {
          public final void djd()
          {
            AppMethodBeat.i(65670);
            LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this).setVisibility(4);
            z.a(LuckyMoneyNewYearReceiveUI.this.getContext(), LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this), paramString.vpO.vjr);
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
            localAlphaAnimation.setDuration(500L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(65669);
                if (com.tencent.mm.n.g.acA().getInt("PlayCoinSound", 0) > 0) {
                  k.a(LuckyMoneyNewYearReceiveUI.this, k.a.vBz);
                }
                if (LuckyMoneyNewYearReceiveUI.7.this.vym.vla != null) {
                  LuckyMoneyNewYearReceiveUI.7.this.vym.vla.b(LuckyMoneyNewYearReceiveUI.this, null, null);
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
        if ((paramn.dNN == 4) && (!TextUtils.isEmpty(paramString.vpO.voc))) {
          this.vxQ.setVisibility(8);
        }
        oa(false);
        setContentViewVisibility(0);
        z.a(this.vkV, null);
        Jt(2);
        djv();
        AppMethodBeat.o(65680);
        return true;
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        this.vyi = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI
 * JD-Core Version:    0.7.0.1
 */