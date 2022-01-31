package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.model.c;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.ui.base.p;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearReceiveUI
  extends LuckyMoneyBaseUI
{
  private String cMO;
  private String ejr;
  private String imageId;
  private String imagePath;
  private TextView iuP;
  private bi kEz;
  private ImageView kPy;
  private c.a lhf;
  private EmojiInfo lkU;
  private ak mHandler;
  private TextView nIU;
  private View okk;
  public int opx;
  private String orH;
  private int ouA;
  private String ouB;
  private boolean ouC;
  private LuckyMoneyAutoScrollView oug;
  private TextView ouh;
  private TextView oui;
  private LinearLayout ouj;
  private ImageView ouk;
  private LinearLayout oul;
  private LinearLayout oum;
  private MMAnimateView oun;
  private TextView ouo;
  private LinearLayout oup;
  private TextView ouq;
  private ImageView our;
  private ImageView ous;
  private MMAnimateView ouu;
  private ImageView ouv;
  private View ouw;
  private BaseEmojiView oux;
  private boolean ouy;
  private String ouz;
  private p tipDialog;
  
  public LuckyMoneyNewYearReceiveUI()
  {
    AppMethodBeat.i(42795);
    this.tipDialog = null;
    this.opx = 0;
    this.ouy = false;
    this.ouz = "";
    this.imageId = "";
    this.ouB = "";
    this.imagePath = "";
    this.mHandler = new ak();
    this.ouC = false;
    this.lhf = new LuckyMoneyNewYearReceiveUI.1(this);
    AppMethodBeat.o(42795);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(42803);
    doSceneProgress(new an(paramInt1, paramInt2, paramString1, paramString2, x.bNq(), r.Zp(), getIntent().getStringExtra("key_username"), "v1.0", paramString3), false);
    AppMethodBeat.o(42803);
  }
  
  private void bOd()
  {
    AppMethodBeat.i(42800);
    this.ouo.setVisibility(8);
    this.lkU = i.getEmojiStorageMgr().yNn.asP(this.ouz);
    if (this.lkU == null)
    {
      ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showExpression() mEmojiInfo == null ");
      AppMethodBeat.o(42800);
      return;
    }
    if ((com.tencent.mm.vfs.e.avI(this.lkU.dQB()) > 0L) || (this.lkU.vY()) || (this.lkU.dzq()))
    {
      this.oux.setVisibility(0);
      this.oux.setEmojiInfo(this.lkU);
      AppMethodBeat.o(42800);
      return;
    }
    this.oux.setVisibility(8);
    this.oum.setVisibility(0);
    this.oun.setImageResource(2131231608);
    i.blo().lhf = this.lhf;
    i.blo().t(this.lkU);
    AppMethodBeat.o(42800);
  }
  
  private void bOe()
  {
    AppMethodBeat.i(42801);
    this.ouu.setImageResource(2131231609);
    AppMethodBeat.o(42801);
  }
  
  private void jb(boolean paramBoolean)
  {
    AppMethodBeat.i(42805);
    if (paramBoolean)
    {
      this.oup.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.oup.getLayoutParams()).addRule(3, 2131825753);
      this.ouq.setText(getString(2131301303));
      this.oup.setOnClickListener(new LuckyMoneyNewYearReceiveUI.8(this));
      AppMethodBeat.o(42805);
      return;
    }
    this.oup.setVisibility(0);
    this.oup.setOnClickListener(new LuckyMoneyNewYearReceiveUI.9(this));
    this.ouq.setText(getString(2131301301));
    AppMethodBeat.o(42805);
  }
  
  private void yA(int paramInt)
  {
    AppMethodBeat.i(42804);
    ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() localReceiveStatus:%s newStatus:%s", new Object[] { Integer.valueOf(this.ouA), Integer.valueOf(paramInt) });
    if (this.kEz == null)
    {
      ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() mEmojiInfo == null");
      AppMethodBeat.o(42804);
      return;
    }
    if ((bo.hl(this.ouA, paramInt)) || (bo.hl(this.ouA, 2)))
    {
      AppMethodBeat.o(42804);
      return;
    }
    try
    {
      Object localObject2 = new StringBuilder(this.kEz.field_content);
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
        this.kEz.setContent(localStringBuilder.toString());
        ((j)g.E(j.class)).bPQ().a(this.kEz.field_msgId, this.kEz);
        ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() success msgXml:%s", new Object[] { localStringBuilder });
        AppMethodBeat.o(42804);
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
      ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(42804);
    }
  }
  
  public int getLayoutId()
  {
    return 2130970038;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42799);
    setActionbarColor(-839716110);
    this.okk = findViewById(2131825742);
    this.oug = ((LuckyMoneyAutoScrollView)findViewById(2131825748));
    this.ouh = ((TextView)findViewById(2131825738));
    this.nIU = ((TextView)findViewById(2131825747));
    this.kPy = ((ImageView)findViewById(2131825758));
    this.ouj = ((LinearLayout)findViewById(2131825749));
    this.iuP = ((TextView)findViewById(2131825751));
    this.ouk = ((ImageView)findViewById(2131825750));
    this.oui = ((TextView)findViewById(2131825759));
    this.oul = ((LinearLayout)findViewById(2131825757));
    this.ouu = ((MMAnimateView)findViewById(2131825752));
    this.ouv = ((ImageView)findViewById(2131825725));
    this.ouw = findViewById(2131825729);
    this.oux = ((BaseEmojiView)findViewById(2131825731));
    this.ouo = ((TextView)findViewById(2131825744));
    this.oum = ((LinearLayout)findViewById(2131825745));
    this.oun = ((MMAnimateView)findViewById(2131825735));
    this.oup = ((LinearLayout)findViewById(2131825754));
    this.ouq = ((TextView)findViewById(2131825755));
    this.ouo.setOnClickListener(new LuckyMoneyNewYearReceiveUI.2(this));
    this.our = ((ImageView)findViewById(2131825741));
    this.our.setOnClickListener(new LuckyMoneyNewYearReceiveUI.3(this));
    this.ous = ((ImageView)findViewById(2131825760));
    this.ous.setOnClickListener(new LuckyMoneyNewYearReceiveUI.4(this));
    setContentViewVisibility(8);
    this.tipDialog = com.tencent.mm.ui.base.h.b(getContext(), getString(2131301086), true, new LuckyMoneyNewYearReceiveUI.5(this));
    AppMethodBeat.o(42799);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42796);
    super.onCreate(paramBundle);
    this.ejr = getIntent().getStringExtra("key_username");
    this.ouz = getIntent().getStringExtra("key_emoji_md5");
    long l = getIntent().getLongExtra("key_msgid", 0L);
    this.kEz = ((j)g.E(j.class)).bPQ().kB(l);
    this.ouA = getIntent().getIntExtra("key_msg_newyear_localreceivestatus", 0);
    this.cMO = getIntent().getStringExtra("key_native_url");
    ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "emojiMd5:" + this.ouz);
    paramBundle = Uri.parse(bo.nullAsNil(this.cMO));
    try
    {
      this.orH = paramBundle.getQueryParameter("sendid");
      initView();
      if (!bo.isNullOrNil(this.orH))
      {
        doSceneProgress(new aq(bo.getInt(paramBundle.getQueryParameter("channelid"), 1), this.orH, this.cMO, 1, "v1.0"), false);
        if (this.tipDialog != null) {
          this.tipDialog.show();
        }
        AppMethodBeat.o(42796);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onCreate() Exception:%s", new Object[] { localException.getMessage() });
      }
      finish();
      ab.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
      AppMethodBeat.o(42796);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42798);
    super.onDestroy();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    i.blo().lhf = null;
    AppMethodBeat.o(42798);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42797);
    super.onResume();
    if (this.ouC) {
      finish();
    }
    AppMethodBeat.o(42797);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42802);
    ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramm.getType());
    label258:
    label323:
    boolean bool;
    label434:
    label464:
    label595:
    String str1;
    if ((paramm instanceof aq))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aq)paramm;
        this.opx = paramString.opx;
        if (paramString.onB == 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label667;
          }
          ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
          if (paramString.cMQ != 4) {
            this.oul.setVisibility(8);
          }
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.cMQ == 5) {
            break label595;
          }
          paramm = com.tencent.mm.wallet_core.ui.e.E(paramString.opI / 100.0D);
          this.oug.setContentDescription(paramm);
          this.oug.setFinalText(paramm);
          this.oug.bNN();
          x.a(getContext(), this.nIU, paramString.oiG);
          this.ouj.setVisibility(8);
          this.oul.setVisibility(0);
          if (paramString.cMQ != 4) {
            break label583;
          }
          a.b.s(this.kPy, this.ejr);
          yA(2);
          this.oui.setText(paramString.onq);
          this.oui.setTextSize(1, 16.0F);
          paramm = (RelativeLayout.LayoutParams)this.oul.getLayoutParams();
          paramm.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this, 82);
          this.oul.setLayoutParams(paramm);
          this.oul.invalidate();
          bOe();
          setContentViewVisibility(0);
          x.a(this.okk, null);
          this.our.setVisibility(0);
          this.ous.setVisibility(8);
          bool = true;
          if ((paramString.cMQ == 5) || (paramString.cMQ == 1)) {
            bool = false;
          }
          ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + paramString.cMQ + ", isValidStatus is " + bool);
          if ((!bo.hl(this.opx, 1)) || (bo.isNullOrNil(this.ouz))) {
            break label1244;
          }
          paramInt1 = 1;
          if ((paramInt1 == 0) || (!bool)) {
            break label1249;
          }
          this.ouw.setVisibility(0);
          this.ouv.setVisibility(8);
          bOd();
          if ((paramInt1 == 0) || (!bool)) {
            break label1269;
          }
          this.nIU.getLayoutParams();
          this.nIU.setTextSize(1, 21.0F);
          this.ouh.setTextSize(1, 15.0F);
          this.oug.eD(getResources().getDimensionPixelOffset(2131428545), getResources().getDimensionPixelOffset(2131428541));
          paramString = (LinearLayout.LayoutParams)this.oug.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131428528);
          this.oug.setLayoutParams(paramString);
          this.oug.invalidate();
        }
        for (;;)
        {
          AppMethodBeat.o(42802);
          return true;
          paramInt1 = 0;
          break;
          label583:
          this.kPy.setVisibility(8);
          break label258;
          findViewById(2131825746).setVisibility(8);
          ((TextView)findViewById(2131825753)).setText(paramString.onq);
          ((TextView)findViewById(2131825753)).setVisibility(0);
          ((TextView)findViewById(2131825753)).setTextSize(24.0F);
          jb(true);
          yA(1);
          break label323;
          label667:
          ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
          if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username")))
          {
            a.b.s(this.kPy, getIntent().getStringExtra("key_username"));
            label706:
            this.oui.setTextSize(1, 16.0F);
            x.a(getContext(), this.oui, paramString.opH + getString(2131301265));
            paramm = (RelativeLayout.LayoutParams)this.oul.getLayoutParams();
            paramm.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this, 30);
            this.oul.setLayoutParams(paramm);
            this.oul.invalidate();
            this.oul.setVisibility(0);
            this.ouj.setVisibility(8);
            if ((paramString.cMR != 0) || (paramString.cMQ == 4) || (paramString.cMQ == 5) || (paramString.cMQ == 1)) {
              break label1052;
            }
            if (!"0".equals(paramString.ooT)) {
              break label1025;
            }
            paramm = this.orz;
            str1 = paramString.ooU;
            String str2 = paramString.ooV;
            String str3 = paramString.ooW;
            String str4 = paramString.ooX;
            LuckyMoneyNewYearReceiveUI.6 local6 = new LuckyMoneyNewYearReceiveUI.6(this, paramString);
            new com.tencent.mm.plugin.wallet_core.id_verify.util.a().a(this, paramm, str1, str2, str3, str4, local6, true, 1005);
          }
          for (;;)
          {
            paramm = (LinearLayout.LayoutParams)this.ouj.getLayoutParams();
            paramm.topMargin = getResources().getDimensionPixelOffset(2131428549);
            this.ouj.setLayoutParams(paramm);
            this.ouj.invalidate();
            this.iuP.setTextSize(1, 12.0F);
            this.our.setVisibility(8);
            this.ous.setVisibility(0);
            break;
            if (TextUtils.isEmpty(paramString.ont)) {
              break label706;
            }
            x.b(this.kPy, paramString.ont, paramString.onN);
            break label706;
            label1025:
            a(paramString.msgType, paramString.bWu, paramString.ojA, paramString.cMO, paramString.opM);
          }
          label1052:
          if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
            this.tipDialog.dismiss();
          }
          if (paramString.cMQ != 5)
          {
            paramm = com.tencent.mm.wallet_core.ui.e.E(paramString.opI / 100.0D);
            this.oug.setContentDescription(paramm);
            this.oug.setFinalText(paramm);
            this.oug.bNN();
            x.a(getContext(), this.nIU, paramString.oiG);
            yA(2);
            bOe();
            jb(false);
          }
          for (;;)
          {
            setContentViewVisibility(0);
            x.a(this.okk, null);
            break;
            this.oup.setVisibility(8);
            findViewById(2131825746).setVisibility(8);
            ((TextView)findViewById(2131825753)).setText(paramString.onq);
            ((TextView)findViewById(2131825753)).setVisibility(0);
            ((TextView)findViewById(2131825753)).setTextSize(24.0F);
            yA(1);
          }
          label1244:
          paramInt1 = 0;
          break label434;
          label1249:
          this.ouw.setVisibility(8);
          this.ouv.setVisibility(0);
          break label464;
          label1269:
          this.nIU.setTextSize(1, 21.0F);
          this.ouh.setTextSize(1, 18.0F);
          this.oug.eD(getResources().getDimensionPixelOffset(2131428546), getResources().getDimensionPixelOffset(2131428542));
          this.oug.invalidate();
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(42802);
      return false;
    }
    if ((paramm instanceof an))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (an)paramm;
        this.opx = paramString.opx;
        if (!bo.hl(this.opx, 1))
        {
          this.ouw.setVisibility(8);
          this.ouv.setVisibility(0);
        }
        paramm = paramString.ooO;
        this.iuP.setText(paramString.ooO.onq);
        str1 = com.tencent.mm.wallet_core.ui.e.E(paramString.ooO.cNd / 100.0D);
        this.oug.setContentDescription(str1);
        this.oug.setFinalText(str1);
        this.oug.a(new LuckyMoneyNewYearReceiveUI.7(this, paramString));
        if ((paramm.cMQ == 4) && (!TextUtils.isEmpty(paramString.ooO.onq))) {
          this.ouk.setVisibility(8);
        }
        jb(false);
        setContentViewVisibility(0);
        x.a(this.okk, null);
        yA(2);
        bOe();
        AppMethodBeat.o(42802);
        return true;
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        this.ouC = true;
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
        paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
        bool = x.a(this, paramInt2, paramm, paramString, true, null, 1004);
        AppMethodBeat.o(42802);
        return bool;
      }
    }
    AppMethodBeat.o(42802);
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