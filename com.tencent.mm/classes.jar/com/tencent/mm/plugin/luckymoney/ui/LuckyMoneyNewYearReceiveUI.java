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
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.o;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearReceiveUI
  extends LuckyMoneyBaseUI
{
  private String dPb;
  private String fVg;
  private String imagePath;
  private aq mHandler;
  private TextView mdh;
  private bv oYw;
  private c.a pKA;
  private EmojiInfo pOS;
  private ImageView pjj;
  private p tipDialog;
  private TextView uSM;
  public int vCC;
  private String vHa;
  private LuckyMoneyAutoScrollView vJQ;
  private TextView vJR;
  private TextView vJS;
  private LinearLayout vJT;
  private ImageView vJU;
  private LinearLayout vJV;
  private LinearLayout vJW;
  private MMAnimateView vJX;
  private TextView vJY;
  private LinearLayout vJZ;
  private TextView vKa;
  private ImageView vKb;
  private ImageView vKc;
  private MMAnimateView vKd;
  private ImageView vKe;
  private View vKf;
  private BaseEmojiView vKg;
  private boolean vKh;
  private String vKi;
  private int vKj;
  private String vKk;
  private String vKl;
  private boolean vKm;
  private View vxa;
  
  public LuckyMoneyNewYearReceiveUI()
  {
    AppMethodBeat.i(65673);
    this.tipDialog = null;
    this.vCC = 0;
    this.vKh = false;
    this.vKi = "";
    this.vKk = "";
    this.vKl = "";
    this.imagePath = "";
    this.mHandler = new aq();
    this.vKm = false;
    this.pKA = new c.a()
    {
      public final void a(final boolean paramAnonymousBoolean, final EmojiInfo paramAnonymousEmojiInfo)
      {
        AppMethodBeat.i(65662);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65661);
            if ((paramAnonymousEmojiInfo != null) && (LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this) != null) && (LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this).Lj().equals(paramAnonymousEmojiInfo.Lj())))
            {
              if (paramAnonymousBoolean)
              {
                ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings success.");
                LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.aWl(LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this).Lj()));
                LuckyMoneyNewYearReceiveUI.b(LuckyMoneyNewYearReceiveUI.this).setVisibility(8);
                LuckyMoneyNewYearReceiveUI.c(LuckyMoneyNewYearReceiveUI.this).setVisibility(0);
                LuckyMoneyNewYearReceiveUI.c(LuckyMoneyNewYearReceiveUI.this).setEmojiInfo(LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this));
                AppMethodBeat.o(65661);
                return;
              }
              ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings error.");
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
  
  private void JS(int paramInt)
  {
    AppMethodBeat.i(65682);
    ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() localReceiveStatus:%s newStatus:%s", new Object[] { Integer.valueOf(this.vKj), Integer.valueOf(paramInt) });
    if (this.oYw == null)
    {
      ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() mEmojiInfo == null");
      AppMethodBeat.o(65682);
      return;
    }
    if ((bu.jB(this.vKj, paramInt)) || (bu.jB(this.vKj, 2)))
    {
      AppMethodBeat.o(65682);
      return;
    }
    try
    {
      Object localObject2 = new StringBuilder(this.oYw.field_content);
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
        this.oYw.setContent(localStringBuilder.toString());
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(this.oYw.field_msgId, this.oYw);
        ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() success msgXml:%s", new Object[] { localStringBuilder });
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
      ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(65682);
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(65681);
    doSceneProgress(new ap(paramInt1, paramInt2, paramString1, paramString2, z.dlp(), v.aAE(), getIntent().getStringExtra("key_username"), "v1.0", paramString3), false);
    AppMethodBeat.o(65681);
  }
  
  private void dmt()
  {
    AppMethodBeat.i(65678);
    this.vJY.setVisibility(8);
    this.pOS = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.aWl(this.vKi);
    if (this.pOS == null)
    {
      ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showExpression() mEmojiInfo == null ");
      AppMethodBeat.o(65678);
      return;
    }
    if ((o.aZR(this.pOS.fSQ()) > 0L) || (this.pOS.Ee()) || (this.pOS.fxr()))
    {
      this.vKg.setVisibility(0);
      this.vKg.setEmojiInfo(this.pOS);
      AppMethodBeat.o(65678);
      return;
    }
    this.vKg.setVisibility(8);
    this.vJW.setVisibility(0);
    this.vJX.setImageResource(2131690763);
    com.tencent.mm.plugin.emoji.model.k.cif().pKA = this.pKA;
    com.tencent.mm.plugin.emoji.model.k.cif().u(this.pOS);
    AppMethodBeat.o(65678);
  }
  
  private void dmu()
  {
    AppMethodBeat.i(65679);
    this.vKd.setImageResource(2131690764);
    AppMethodBeat.o(65679);
  }
  
  private void of(boolean paramBoolean)
  {
    AppMethodBeat.i(65683);
    if (paramBoolean)
    {
      this.vJZ.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.vJZ.getLayoutParams()).addRule(3, 2131301881);
      this.vKa.setText(getString(2131760948));
      this.vJZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65671);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto detail!");
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
    this.vJZ.setVisibility(0);
    this.vJZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65672);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto BalanceManagerUI!");
        com.tencent.mm.pluginsdk.wallet.f.aw(LuckyMoneyNewYearReceiveUI.this.getContext(), 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65672);
      }
    });
    this.vKa.setText(getString(2131760946));
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
    this.vxa = findViewById(2131301882);
    this.vJQ = ((LuckyMoneyAutoScrollView)findViewById(2131301878));
    this.vJR = ((TextView)findViewById(2131301717));
    this.uSM = ((TextView)findViewById(2131301889));
    this.pjj = ((ImageView)findViewById(2131301879));
    this.vJT = ((LinearLayout)findViewById(2131301887));
    this.mdh = ((TextView)findViewById(2131301885));
    this.vJU = ((ImageView)findViewById(2131301886));
    this.vJS = ((TextView)findViewById(2131301888));
    this.vJV = ((LinearLayout)findViewById(2131301884));
    this.vKd = ((MMAnimateView)findViewById(2131303142));
    this.vKe = ((ImageView)findViewById(2131301869));
    this.vKf = findViewById(2131301866);
    this.vKg = ((BaseEmojiView)findViewById(2131301862));
    this.vJY = ((TextView)findViewById(2131301873));
    this.vJW = ((LinearLayout)findViewById(2131301870));
    this.vJX = ((MMAnimateView)findViewById(2131301501));
    this.vJZ = ((LinearLayout)findViewById(2131301738));
    this.vKa = ((TextView)findViewById(2131301739));
    this.vJY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65663);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LuckyMoneyNewYearReceiveUI.e(LuckyMoneyNewYearReceiveUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65663);
      }
    });
    this.vKb = ((ImageView)findViewById(2131301876));
    this.vKb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65664);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LuckyMoneyNewYearReceiveUI.this.finish();
        com.tencent.mm.plugin.report.service.g.yxI.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65664);
      }
    });
    this.vKc = ((ImageView)findViewById(2131301875));
    this.vKc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65665);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LuckyMoneyNewYearReceiveUI.this.finish();
        com.tencent.mm.plugin.report.service.g.yxI.f(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(2) });
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
        LuckyMoneyNewYearReceiveUI.this.vGY.forceCancel();
        if ((LuckyMoneyNewYearReceiveUI.g(LuckyMoneyNewYearReceiveUI.this).getVisibility() == 8) || (LuckyMoneyNewYearReceiveUI.h(LuckyMoneyNewYearReceiveUI.this).getVisibility() == 4))
        {
          ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
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
    this.fVg = getIntent().getStringExtra("key_username");
    this.vKi = getIntent().getStringExtra("key_emoji_md5");
    long l = getIntent().getLongExtra("key_msgid", 0L);
    this.oYw = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(l);
    this.vKj = getIntent().getIntExtra("key_msg_newyear_localreceivestatus", 0);
    this.dPb = getIntent().getStringExtra("key_native_url");
    ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "emojiMd5:" + this.vKi);
    paramBundle = Uri.parse(bu.nullAsNil(this.dPb));
    try
    {
      this.vHa = paramBundle.getQueryParameter("sendid");
      initView();
      if (!bu.isNullOrNil(this.vHa))
      {
        doSceneProgress(new as(bu.getInt(paramBundle.getQueryParameter("channelid"), 1), this.vHa, this.dPb, 1, "v1.0"), false);
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
        ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onCreate() Exception:%s", new Object[] { localException.getMessage() });
      }
      finish();
      ae.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
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
    com.tencent.mm.plugin.emoji.model.k.cif().pKA = null;
    AppMethodBeat.o(65676);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65675);
    super.onResume();
    if (this.vKm) {
      finish();
    }
    AppMethodBeat.o(65675);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(65680);
    ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
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
        this.vCC = paramString.vCC;
        if (paramString.vAs == 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label667;
          }
          ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
          if (paramString.dPd != 4) {
            this.vJV.setVisibility(8);
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.dPd == 5) {
            break label595;
          }
          paramn = com.tencent.mm.wallet_core.ui.f.C(paramString.vCL / 100.0D);
          this.vJQ.setContentDescription(paramn);
          this.vJQ.setFinalText(paramn);
          this.vJQ.dmb();
          z.a(getContext(), this.uSM, paramString.vvw);
          this.vJT.setVisibility(8);
          this.vJV.setVisibility(0);
          if (paramString.dPd != 4) {
            break label583;
          }
          a.b.d(this.pjj, this.fVg);
          JS(2);
          this.vJS.setText(paramString.vAh);
          this.vJS.setTextSize(1, 16.0F);
          paramn = (RelativeLayout.LayoutParams)this.vJV.getLayoutParams();
          paramn.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this, 82);
          this.vJV.setLayoutParams(paramn);
          this.vJV.invalidate();
          dmu();
          setContentViewVisibility(0);
          z.a(this.vxa, null);
          this.vKb.setVisibility(0);
          this.vKc.setVisibility(8);
          bool = true;
          if ((paramString.dPd == 5) || (paramString.dPd == 1)) {
            bool = false;
          }
          ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + paramString.dPd + ", isValidStatus is " + bool);
          if ((!bu.jB(this.vCC, 1)) || (bu.isNullOrNil(this.vKi))) {
            break label1246;
          }
          paramInt1 = 1;
          if ((paramInt1 == 0) || (!bool)) {
            break label1251;
          }
          this.vKf.setVisibility(0);
          this.vKe.setVisibility(8);
          dmt();
          if ((paramInt1 == 0) || (!bool)) {
            break label1271;
          }
          this.uSM.getLayoutParams();
          this.uSM.setTextSize(1, 21.0F);
          this.vJR.setTextSize(1, 15.0F);
          this.vJQ.gx(getResources().getDimensionPixelOffset(2131166534), getResources().getDimensionPixelOffset(2131166530));
          paramString = (LinearLayout.LayoutParams)this.vJQ.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166517);
          this.vJQ.setLayoutParams(paramString);
          this.vJQ.invalidate();
        }
        for (;;)
        {
          AppMethodBeat.o(65680);
          return true;
          paramInt1 = 0;
          break;
          label583:
          this.pjj.setVisibility(8);
          break label258;
          findViewById(2131301880).setVisibility(8);
          ((TextView)findViewById(2131301881)).setText(paramString.vAh);
          ((TextView)findViewById(2131301881)).setVisibility(0);
          ((TextView)findViewById(2131301881)).setTextSize(24.0F);
          of(true);
          JS(1);
          break label323;
          label667:
          ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
          if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username")))
          {
            a.b.d(this.pjj, getIntent().getStringExtra("key_username"));
            label708:
            this.vJS.setTextSize(1, 16.0F);
            z.a(getContext(), this.vJS, paramString.vCK + getString(2131760907));
            paramn = (RelativeLayout.LayoutParams)this.vJV.getLayoutParams();
            paramn.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this, 30);
            this.vJV.setLayoutParams(paramn);
            this.vJV.invalidate();
            this.vJV.setVisibility(0);
            this.vJT.setVisibility(8);
            if ((paramString.dPe != 0) || (paramString.dPd == 4) || (paramString.dPd == 5) || (paramString.dPd == 1)) {
              break label1054;
            }
            if (!"0".equals(paramString.vBY)) {
              break label1027;
            }
            paramn = this.vGY;
            str1 = paramString.vBZ;
            String str2 = paramString.vCa;
            String str3 = paramString.vCb;
            String str4 = paramString.vCc;
            a.a local6 = new a.a()
            {
              public final boolean run(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(65667);
                ae.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + paramAnonymousInt1 + ";errCode=" + paramAnonymousInt2 + ";errMsg=" + paramAnonymousString + ";hadAgree = " + paramAnonymousBoolean);
                if (paramAnonymousInt1 == 1) {
                  LuckyMoneyNewYearReceiveUI.this.finish();
                }
                for (;;)
                {
                  AppMethodBeat.o(65667);
                  return true;
                  if (paramAnonymousInt1 == 2) {
                    LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.cSM, paramString.vwq, paramString.dPb, paramString.vCP);
                  } else if ((paramAnonymousInt1 == 0) && (paramAnonymousBoolean)) {
                    LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.cSM, paramString.vwq, paramString.dPb, paramString.vCP);
                  }
                }
              }
            };
            new com.tencent.mm.plugin.wallet_core.id_verify.util.a().a(this, paramn, str1, str2, str3, str4, local6, true, 1005);
          }
          for (;;)
          {
            paramn = (LinearLayout.LayoutParams)this.vJT.getLayoutParams();
            paramn.topMargin = getResources().getDimensionPixelOffset(2131166538);
            this.vJT.setLayoutParams(paramn);
            this.vJT.invalidate();
            this.mdh.setTextSize(1, 12.0F);
            this.vKb.setVisibility(8);
            this.vKc.setVisibility(0);
            break;
            if (TextUtils.isEmpty(paramString.vAk)) {
              break label708;
            }
            z.b(this.pjj, paramString.vAk, paramString.vAE);
            break label708;
            label1027:
            a(paramString.msgType, paramString.cSM, paramString.vwq, paramString.dPb, paramString.vCP);
          }
          label1054:
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.dPd != 5)
          {
            paramn = com.tencent.mm.wallet_core.ui.f.C(paramString.vCL / 100.0D);
            this.vJQ.setContentDescription(paramn);
            this.vJQ.setFinalText(paramn);
            this.vJQ.dmb();
            z.a(getContext(), this.uSM, paramString.vvw);
            JS(2);
            dmu();
            of(false);
          }
          for (;;)
          {
            setContentViewVisibility(0);
            z.a(this.vxa, null);
            break;
            this.vJZ.setVisibility(8);
            findViewById(2131301880).setVisibility(8);
            ((TextView)findViewById(2131301881)).setText(paramString.vAh);
            ((TextView)findViewById(2131301881)).setVisibility(0);
            ((TextView)findViewById(2131301881)).setTextSize(24.0F);
            JS(1);
          }
          label1246:
          paramInt1 = 0;
          break label434;
          label1251:
          this.vKf.setVisibility(8);
          this.vKe.setVisibility(0);
          break label464;
          label1271:
          this.uSM.setTextSize(1, 21.0F);
          this.vJR.setTextSize(1, 18.0F);
          this.vJQ.gx(getResources().getDimensionPixelOffset(2131166535), getResources().getDimensionPixelOffset(2131166531));
          this.vJQ.invalidate();
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(65680);
      return false;
    }
    if ((paramn instanceof ap))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ap)paramn;
        if (com.tencent.mm.plugin.wallet_core.utils.c.a(paramString.vCD))
        {
          setContentViewVisibility(4);
          paramn = new com.tencent.mm.plugin.wallet_core.utils.c(this);
          paramn.DFD = true;
          paramn.b(paramString.vCD);
          AppMethodBeat.o(65680);
          return true;
        }
        this.vCC = paramString.vCC;
        if (!bu.jB(this.vCC, 1))
        {
          this.vKf.setVisibility(8);
          this.vKe.setVisibility(0);
        }
        paramn = paramString.vBT;
        this.mdh.setText(paramString.vBT.vAh);
        str1 = com.tencent.mm.wallet_core.ui.f.C(paramString.vBT.dPq / 100.0D);
        this.vJQ.setContentDescription(str1);
        this.vJQ.setFinalText(str1);
        this.vJQ.a(new LuckyMoneyAutoScrollView.a()
        {
          public final void dmc()
          {
            AppMethodBeat.i(65670);
            LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this).setVisibility(4);
            z.a(LuckyMoneyNewYearReceiveUI.this.getContext(), LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this), paramString.vBT.vvw);
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
            localAlphaAnimation.setDuration(500L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(65669);
                if (com.tencent.mm.n.g.acL().getInt("PlayCoinSound", 0) > 0) {
                  k.a(LuckyMoneyNewYearReceiveUI.this, k.a.vND);
                }
                if (LuckyMoneyNewYearReceiveUI.7.this.vKq.vxf != null) {
                  LuckyMoneyNewYearReceiveUI.7.this.vKq.vxf.b(LuckyMoneyNewYearReceiveUI.this, null, null);
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
        if ((paramn.dPd == 4) && (!TextUtils.isEmpty(paramString.vBT.vAh))) {
          this.vJU.setVisibility(8);
        }
        of(false);
        setContentViewVisibility(0);
        z.a(this.vxa, null);
        JS(2);
        dmu();
        AppMethodBeat.o(65680);
        return true;
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        this.vKm = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI
 * JD-Core Version:    0.7.0.1
 */