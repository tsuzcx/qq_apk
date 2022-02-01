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
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ay;
import com.tencent.mm.plugin.luckymoney.model.bd;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearReceiveUI
  extends LuckyMoneyBaseUI
{
  private String egX;
  private String gAn;
  private String imagePath;
  private MMHandler mHandler;
  private TextView nnA;
  private ca qnv;
  private ImageView qyu;
  private d.a rbg;
  private EmojiInfo rfq;
  private com.tencent.mm.ui.base.q tipDialog;
  private View yRp;
  private String yUc;
  public int yXD;
  private TextView yln;
  private LuckyMoneyAutoScrollView zeW;
  private TextView zeX;
  private TextView zeY;
  private LinearLayout zeZ;
  private ImageView zfa;
  private LinearLayout zfb;
  private LinearLayout zfc;
  private MMAnimateView zfd;
  private TextView zfe;
  private LinearLayout zff;
  private TextView zfg;
  private ImageView zfh;
  private ImageView zfi;
  private MMAnimateView zfj;
  private ImageView zfk;
  private View zfl;
  private BaseEmojiView zfm;
  private boolean zfn;
  private String zfo;
  private int zfp;
  private String zfq;
  private String zfr;
  private boolean zfs;
  
  public LuckyMoneyNewYearReceiveUI()
  {
    AppMethodBeat.i(65673);
    this.tipDialog = null;
    this.yXD = 0;
    this.zfn = false;
    this.zfo = "";
    this.zfq = "";
    this.zfr = "";
    this.imagePath = "";
    this.mHandler = new MMHandler();
    this.zfs = false;
    this.rbg = new d.a()
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
                LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, k.getEmojiStorageMgr().OpN.blk(LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this).getMd5()));
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
  
  private void PU(int paramInt)
  {
    AppMethodBeat.i(65682);
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() localReceiveStatus:%s newStatus:%s", new Object[] { Integer.valueOf(this.zfp), Integer.valueOf(paramInt) });
    if (this.qnv == null)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() mEmojiInfo == null");
      AppMethodBeat.o(65682);
      return;
    }
    if ((Util.isEqual(this.zfp, paramInt)) || (Util.isEqual(this.zfp, 2)))
    {
      AppMethodBeat.o(65682);
      return;
    }
    try
    {
      Object localObject2 = new StringBuilder(this.qnv.field_content);
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
        this.qnv.setContent(localStringBuilder.toString());
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.qnv.field_msgId, this.qnv);
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
    doSceneProgress(new ay(paramInt1, paramInt2, paramString1, paramString2, af.efj(), com.tencent.mm.model.z.aUa(), getIntent().getStringExtra("key_username"), "v1.0", paramString3), false);
    AppMethodBeat.o(65681);
  }
  
  private void ego()
  {
    AppMethodBeat.i(65678);
    this.zfe.setVisibility(8);
    this.rfq = k.getEmojiStorageMgr().OpN.blk(this.zfo);
    if (this.rfq == null)
    {
      Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showExpression() mEmojiInfo == null ");
      AppMethodBeat.o(65678);
      return;
    }
    if ((s.boW(this.rfq.hRM()) > 0L) || (this.rfq.NA()) || (this.rfq.hRB()))
    {
      this.zfm.setVisibility(0);
      this.zfm.setEmojiInfo(this.rfq);
      AppMethodBeat.o(65678);
      return;
    }
    this.zfm.setVisibility(8);
    this.zfc.setVisibility(0);
    this.zfd.setImageResource(2131691047);
    k.cGd().rbg = this.rbg;
    k.cGd().u(this.rfq);
    AppMethodBeat.o(65678);
  }
  
  private void egp()
  {
    AppMethodBeat.i(65679);
    this.zfj.setImageResource(2131691048);
    AppMethodBeat.o(65679);
  }
  
  private void qN(boolean paramBoolean)
  {
    AppMethodBeat.i(65683);
    if (paramBoolean)
    {
      this.zff.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.zff.getLayoutParams()).addRule(3, 2131304200);
      this.zfg.setText(getString(2131762722));
      this.zff.setOnClickListener(new LuckyMoneyNewYearReceiveUI.8(this));
      AppMethodBeat.o(65683);
      return;
    }
    this.zff.setVisibility(0);
    this.zff.setOnClickListener(new LuckyMoneyNewYearReceiveUI.9(this));
    this.zfg.setText(getString(2131762720));
    AppMethodBeat.o(65683);
  }
  
  public int getLayoutId()
  {
    return 2131495375;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65677);
    setActionbarColor(-839716110);
    this.yRp = findViewById(2131304201);
    this.zeW = ((LuckyMoneyAutoScrollView)findViewById(2131304197));
    this.zeX = ((TextView)findViewById(2131304017));
    this.yln = ((TextView)findViewById(2131304208));
    this.qyu = ((ImageView)findViewById(2131304198));
    this.zeZ = ((LinearLayout)findViewById(2131304206));
    this.nnA = ((TextView)findViewById(2131304204));
    this.zfa = ((ImageView)findViewById(2131304205));
    this.zeY = ((TextView)findViewById(2131304207));
    this.zfb = ((LinearLayout)findViewById(2131304203));
    this.zfj = ((MMAnimateView)findViewById(2131305787));
    this.zfk = ((ImageView)findViewById(2131304188));
    this.zfl = findViewById(2131304185);
    this.zfm = ((BaseEmojiView)findViewById(2131304181));
    this.zfe = ((TextView)findViewById(2131304192));
    this.zfc = ((LinearLayout)findViewById(2131304189));
    this.zfd = ((MMAnimateView)findViewById(2131303704));
    this.zff = ((LinearLayout)findViewById(2131304038));
    this.zfg = ((TextView)findViewById(2131304039));
    this.zfe.setOnClickListener(new LuckyMoneyNewYearReceiveUI.2(this));
    this.zfh = ((ImageView)findViewById(2131304195));
    this.zfh.setOnClickListener(new LuckyMoneyNewYearReceiveUI.3(this));
    this.zfi = ((ImageView)findViewById(2131304194));
    this.zfi.setOnClickListener(new LuckyMoneyNewYearReceiveUI.4(this));
    setContentViewVisibility(8);
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131762446), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(65666);
        if ((LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this) != null) && (LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this).isShowing())) {
          LuckyMoneyNewYearReceiveUI.f(LuckyMoneyNewYearReceiveUI.this).dismiss();
        }
        LuckyMoneyNewYearReceiveUI.this.zbX.forceCancel();
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
    this.gAn = getIntent().getStringExtra("key_username");
    this.zfo = getIntent().getStringExtra("key_emoji_md5");
    long l = getIntent().getLongExtra("key_msgid", 0L);
    this.qnv = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(l);
    this.zfp = getIntent().getIntExtra("key_msg_newyear_localreceivestatus", 0);
    this.egX = getIntent().getStringExtra("key_native_url");
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "emojiMd5:" + this.zfo);
    paramBundle = Uri.parse(Util.nullAsNil(this.egX));
    try
    {
      this.yUc = paramBundle.getQueryParameter("sendid");
      initView();
      if (!Util.isNullOrNil(this.yUc))
      {
        doSceneProgress(new bd(Util.getInt(paramBundle.getQueryParameter("channelid"), 1), this.yUc, this.egX, 1, "v1.0", ""), false);
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
    k.cGd().rbg = null;
    AppMethodBeat.o(65676);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65675);
    super.onResume();
    if (this.zfs) {
      finish();
    }
    AppMethodBeat.o(65675);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(65680);
    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramq.getType());
    label258:
    label323:
    boolean bool;
    label434:
    label464:
    label595:
    String str1;
    if ((paramq instanceof bd))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (bd)paramq;
        this.yXD = paramString.yXD;
        if (paramString.yVm == 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label667;
          }
          Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
          if (paramString.egZ != 4) {
            this.zfb.setVisibility(8);
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.egZ == 5) {
            break label595;
          }
          paramq = com.tencent.mm.wallet_core.ui.f.formatMoney2f(paramString.yXO / 100.0D);
          this.zeW.setContentDescription(paramq);
          this.zeW.setFinalText(paramq);
          this.zeW.efX();
          af.a(getContext(), this.yln, paramString.yPK);
          this.zeZ.setVisibility(8);
          this.zfb.setVisibility(0);
          if (paramString.egZ != 4) {
            break label583;
          }
          a.b.d(this.qyu, this.gAn);
          PU(2);
          this.zeY.setText(paramString.yVb);
          this.zeY.setTextSize(1, 16.0F);
          paramq = (RelativeLayout.LayoutParams)this.zfb.getLayoutParams();
          paramq.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this, 82);
          this.zfb.setLayoutParams(paramq);
          this.zfb.invalidate();
          egp();
          setContentViewVisibility(0);
          af.a(this.yRp, null);
          this.zfh.setVisibility(0);
          this.zfi.setVisibility(8);
          bool = true;
          if ((paramString.egZ == 5) || (paramString.egZ == 1)) {
            bool = false;
          }
          Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + paramString.egZ + ", isValidStatus is " + bool);
          if ((!Util.isEqual(this.yXD, 1)) || (Util.isNullOrNil(this.zfo))) {
            break label1246;
          }
          paramInt1 = 1;
          if ((paramInt1 == 0) || (!bool)) {
            break label1251;
          }
          this.zfl.setVisibility(0);
          this.zfk.setVisibility(8);
          ego();
          if ((paramInt1 == 0) || (!bool)) {
            break label1271;
          }
          this.yln.getLayoutParams();
          this.yln.setTextSize(1, 21.0F);
          this.zeX.setTextSize(1, 15.0F);
          this.zeW.gV(getResources().getDimensionPixelOffset(2131166649), getResources().getDimensionPixelOffset(2131166645));
          paramString = (LinearLayout.LayoutParams)this.zeW.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131166632);
          this.zeW.setLayoutParams(paramString);
          this.zeW.invalidate();
        }
        for (;;)
        {
          AppMethodBeat.o(65680);
          return true;
          paramInt1 = 0;
          break;
          label583:
          this.qyu.setVisibility(8);
          break label258;
          findViewById(2131304199).setVisibility(8);
          ((TextView)findViewById(2131304200)).setText(paramString.yVb);
          ((TextView)findViewById(2131304200)).setVisibility(0);
          ((TextView)findViewById(2131304200)).setTextSize(24.0F);
          qN(true);
          PU(1);
          break label323;
          label667:
          Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
          if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username")))
          {
            a.b.d(this.qyu, getIntent().getStringExtra("key_username"));
            label708:
            this.zeY.setTextSize(1, 16.0F);
            af.a(getContext(), this.zeY, paramString.yXN + getString(2131762681));
            paramq = (RelativeLayout.LayoutParams)this.zfb.getLayoutParams();
            paramq.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this, 30);
            this.zfb.setLayoutParams(paramq);
            this.zfb.invalidate();
            this.zfb.setVisibility(0);
            this.zeZ.setVisibility(8);
            if ((paramString.eha != 0) || (paramString.egZ == 4) || (paramString.egZ == 5) || (paramString.egZ == 1)) {
              break label1054;
            }
            if (!"0".equals(paramString.yWY)) {
              break label1027;
            }
            paramq = this.zbX;
            str1 = paramString.yWZ;
            String str2 = paramString.yXa;
            String str3 = paramString.yXb;
            String str4 = paramString.yXc;
            a.a local6 = new a.a()
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
                    LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.channelId, paramString.yQE, paramString.egX, paramString.yXR);
                  } else if ((paramAnonymousInt1 == 0) && (paramAnonymousBoolean)) {
                    LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, paramString.msgType, paramString.channelId, paramString.yQE, paramString.egX, paramString.yXR);
                  }
                }
              }
            };
            new com.tencent.mm.plugin.wallet_core.id_verify.util.a().a(this, paramq, str1, str2, str3, str4, local6, true, 1005);
          }
          for (;;)
          {
            paramq = (LinearLayout.LayoutParams)this.zeZ.getLayoutParams();
            paramq.topMargin = getResources().getDimensionPixelOffset(2131166653);
            this.zeZ.setLayoutParams(paramq);
            this.zeZ.invalidate();
            this.nnA.setTextSize(1, 12.0F);
            this.zfh.setVisibility(8);
            this.zfi.setVisibility(0);
            break;
            if (TextUtils.isEmpty(paramString.yVe)) {
              break label708;
            }
            af.a(this.qyu, paramString.yVe, paramString.yVy);
            break label708;
            label1027:
            a(paramString.msgType, paramString.channelId, paramString.yQE, paramString.egX, paramString.yXR);
          }
          label1054:
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.egZ != 5)
          {
            paramq = com.tencent.mm.wallet_core.ui.f.formatMoney2f(paramString.yXO / 100.0D);
            this.zeW.setContentDescription(paramq);
            this.zeW.setFinalText(paramq);
            this.zeW.efX();
            af.a(getContext(), this.yln, paramString.yPK);
            PU(2);
            egp();
            qN(false);
          }
          for (;;)
          {
            setContentViewVisibility(0);
            af.a(this.yRp, null);
            break;
            this.zff.setVisibility(8);
            findViewById(2131304199).setVisibility(8);
            ((TextView)findViewById(2131304200)).setText(paramString.yVb);
            ((TextView)findViewById(2131304200)).setVisibility(0);
            ((TextView)findViewById(2131304200)).setTextSize(24.0F);
            PU(1);
          }
          label1246:
          paramInt1 = 0;
          break label434;
          label1251:
          this.zfl.setVisibility(8);
          this.zfk.setVisibility(0);
          break label464;
          label1271:
          this.yln.setTextSize(1, 21.0F);
          this.zeX.setTextSize(1, 18.0F);
          this.zeW.gV(getResources().getDimensionPixelOffset(2131166650), getResources().getDimensionPixelOffset(2131166646));
          this.zeW.invalidate();
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(65680);
      return false;
    }
    if ((paramq instanceof ay))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ay)paramq;
        if (c.a(paramString.yXE))
        {
          setContentViewVisibility(4);
          paramq = new c(this);
          paramq.IoO = true;
          paramq.b(paramString.yXE);
          AppMethodBeat.o(65680);
          return true;
        }
        this.yXD = paramString.yXD;
        if (!Util.isEqual(this.yXD, 1))
        {
          this.zfl.setVisibility(8);
          this.zfk.setVisibility(0);
        }
        paramq = paramString.yWT;
        this.nnA.setText(paramString.yWT.yVb);
        str1 = com.tencent.mm.wallet_core.ui.f.formatMoney2f(paramString.yWT.eht / 100.0D);
        this.zeW.setContentDescription(str1);
        this.zeW.setFinalText(str1);
        this.zeW.a(new LuckyMoneyAutoScrollView.a()
        {
          public final void efY()
          {
            AppMethodBeat.i(65670);
            LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this).setVisibility(4);
            af.a(LuckyMoneyNewYearReceiveUI.this.getContext(), LuckyMoneyNewYearReceiveUI.i(LuckyMoneyNewYearReceiveUI.this), paramString.yWT.yPK);
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
            localAlphaAnimation.setDuration(500L);
            localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(65669);
                if (com.tencent.mm.n.h.aqJ().getInt("PlayCoinSound", 0) > 0) {
                  l.a(LuckyMoneyNewYearReceiveUI.this, l.a.zjb);
                }
                if (LuckyMoneyNewYearReceiveUI.7.this.zfw.yRu != null) {
                  LuckyMoneyNewYearReceiveUI.7.this.zfw.yRu.b(LuckyMoneyNewYearReceiveUI.this, null, null);
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
        if ((paramq.egZ == 4) && (!TextUtils.isEmpty(paramString.yWT.yVb))) {
          this.zfa.setVisibility(8);
        }
        qN(false);
        setContentViewVisibility(0);
        af.a(this.yRp, null);
        PU(2);
        egp();
        AppMethodBeat.o(65680);
        return true;
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        this.zfs = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
        paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
        bool = af.a(this, paramInt2, paramq, paramString, true, null, null, 1004);
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