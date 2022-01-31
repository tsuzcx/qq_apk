package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.ac;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.model.c;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyNotHookReceiveUI
  extends LuckyMoneyBaseUI
{
  private ViewGroup iux;
  private TextView kRB;
  private c.a lhf;
  private String liJ;
  private EmojiInfo lkU;
  private int maxSize;
  private TextView nIU;
  private String nnY;
  private ImageView ojp;
  private TextView okf;
  Button okg;
  private View okh;
  private ImageView oki;
  private TextView okj;
  private ImageView oml;
  public int opL;
  aq opT;
  private String orH;
  private String orJ;
  private RelativeLayout osF;
  private BaseEmojiView osG;
  private TextView osH;
  private LinearLayout osI;
  private MMAnimateView osJ;
  private int osW;
  private ac otb;
  private long otr;
  private int ott;
  private f otu;
  private int otw;
  private LinearLayout ovn;
  private View ovo;
  private ImageView ovp;
  private ImageView ovq;
  private RelativeLayout ovr;
  private ad ovs;
  private String ovt;
  private boolean ovu;
  private int textSize;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public LuckyMoneyNotHookReceiveUI()
  {
    AppMethodBeat.i(42860);
    this.tipDialog = null;
    this.maxSize = 0;
    this.textSize = 0;
    this.ovs = null;
    this.opL = 0;
    this.ovu = false;
    this.lhf = new LuckyMoneyNotHookReceiveUI.1(this);
    this.otr = 0L;
    this.ott = 3;
    this.otw = 0;
    this.otu = new LuckyMoneyNotHookReceiveUI.9(this);
    AppMethodBeat.o(42860);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(42869);
    this.otw = 4;
    this.osG.setEmojiInfo(paramEmojiInfo);
    this.ovq.setVisibility(0);
    this.otb = new ac();
    this.otb.cRI = 8L;
    this.otb.ake();
    AppMethodBeat.o(42869);
  }
  
  private void a(an paraman)
  {
    AppMethodBeat.i(42872);
    com.tencent.mm.plugin.luckymoney.model.k localk = paraman.ooO;
    Object localObject;
    if (localk.cMR == 2)
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
      ((Intent)localObject).putExtra("key_lucky_money_can_received", true);
      try
      {
        ((Intent)localObject).putExtra("key_detail_info", paraman.ooO.toByteArray());
        ((Intent)localObject).putExtra("key_jump_from", 2);
        ((Intent)localObject).putExtra("key_native_url", paraman.cMO);
        ((Intent)localObject).putExtra("key_sendid", paraman.ojA);
        if (com.tencent.mm.m.g.Nq().getInt("PlayCoinSound", 0) > 0) {
          ((Intent)localObject).putExtra("play_sound", true);
        }
        if (paraman.okp != null) {
          ((Intent)localObject).putExtra("key_realname_guide_helper", paraman.okp);
        }
        ((Intent)localObject).putExtra("key_username", getIntent().getStringExtra("key_username"));
        ((Intent)localObject).putExtra("key_emoji_switch", paraman.opd);
        ((Intent)localObject).putExtra("key_detail_emoji_md5", paraman.opb);
        ((Intent)localObject).putExtra("key_detail_emoji_type", paraman.opc);
        startActivity((Intent)localObject);
        finish();
        paraman = new ad();
        paraman.field_mNativeUrl = this.orJ;
        paraman.field_hbType = localk.cMP;
        paraman.field_receiveAmount = localk.cNd;
        paraman.field_receiveTime = System.currentTimeMillis();
        paraman.field_hbStatus = localk.cMQ;
        paraman.field_receiveStatus = localk.cMR;
        if (paraman.field_receiveAmount > 0L) {
          t.cTK().a(paraman);
        }
        AppMethodBeat.o(42872);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ab.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localIOException.getLocalizedMessage());
        }
      }
    }
    this.okg.setBackgroundResource(2130839503);
    this.okg.setText(2131301276);
    this.okg.setOnClickListener(null);
    this.okg.setVisibility(8);
    if (!bo.isNullOrNil(localk.okM))
    {
      this.kRB.setText(localk.okM);
      this.kRB.setVisibility(0);
    }
    for (;;)
    {
      this.nIU.setText(localk.onq);
      localObject = (RelativeLayout.LayoutParams)this.okh.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = BackwardSupportUtil.b.b(getContext(), 30.0F);
      this.okh.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((!r.Zn().equals(this.nnY)) && (localk.cMP != 1)) {
        break;
      }
      this.okh.setVisibility(0);
      this.okh.setOnClickListener(new LuckyMoneyNotHookReceiveUI.5(this, paraman));
      this.oki.setVisibility(8);
      AppMethodBeat.o(42872);
      return;
      this.kRB.setVisibility(8);
    }
    this.okh.setVisibility(8);
    this.oki.setVisibility(0);
    AppMethodBeat.o(42872);
  }
  
  private void bMV()
  {
    AppMethodBeat.i(42867);
    if (this.okg == null)
    {
      AppMethodBeat.o(42867);
      return;
    }
    com.tencent.mm.plugin.normsg.a.b.pgQ.AQ(this.okg.getId());
    Object localObject = ah.getContext().getSharedPreferences(ah.dsP(), 0);
    ah.getContext();
    localObject = aa.f((SharedPreferences)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0) && ((((String)localObject).equals("zh_CN")) || (((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK"))))
    {
      AppMethodBeat.o(42867);
      return;
    }
    this.okg.setBackgroundResource(2130839518);
    this.okg.setText(2131301279);
    AppMethodBeat.o(42867);
  }
  
  private int bOh()
  {
    AppMethodBeat.i(42873);
    if (r.Zn().equals(this.nnY))
    {
      AppMethodBeat.o(42873);
      return 1;
    }
    AppMethodBeat.o(42873);
    return 0;
  }
  
  private void ja(boolean paramBoolean)
  {
    AppMethodBeat.i(42868);
    ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle:%s", new Object[] { Boolean.TRUE });
    this.osH.setVisibility(8);
    this.otw = 1;
    if (paramBoolean) {
      this.ott = 3;
    }
    do
    {
      this.lkU = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNn.asP(this.liJ);
      if (this.lkU == null) {
        break;
      }
      if ((com.tencent.mm.vfs.e.avI(this.lkU.dQB()) <= 0L) && (!this.lkU.vY()) && (!this.lkU.dzq())) {
        break label228;
      }
      this.osG.setVisibility(0);
      A(this.lkU);
      yE(3);
      AppMethodBeat.o(42868);
      return;
      this.ott -= 1;
    } while (this.ott != 0);
    ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle fail!");
    this.osI.setVisibility(8);
    this.osH.setVisibility(0);
    yE(1);
    this.otw = 2;
    AppMethodBeat.o(42868);
    return;
    this.lkU = new EmojiInfo();
    this.lkU.field_md5 = this.liJ;
    this.lkU.field_type = this.osW;
    label228:
    if (paramBoolean)
    {
      this.osG.setVisibility(8);
      yE(2);
      this.osI.setVisibility(0);
      this.osJ.setImageResource(2131231608);
      com.tencent.mm.plugin.emoji.model.i.blo().lhf = this.lhf;
    }
    com.tencent.mm.plugin.emoji.model.i.blo().t(this.lkU);
    com.tencent.mm.kernel.g.RK().eHt.a(697, this.otu);
    AppMethodBeat.o(42868);
  }
  
  private void yE(int paramInt)
  {
    AppMethodBeat.i(42870);
    Object localObject = (LinearLayout.LayoutParams)this.ovn.getLayoutParams();
    switch (paramInt)
    {
    default: 
      paramInt = BackwardSupportUtil.b.b(this, 53.0F);
    }
    for (;;)
    {
      ((LinearLayout.LayoutParams)localObject).topMargin = paramInt;
      this.ovn.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.ovn.invalidate();
      localObject = (RelativeLayout.LayoutParams)this.ovr.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = (paramInt - BackwardSupportUtil.b.b(this, 53.0F));
      this.ovr.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.ovr.invalidate();
      AppMethodBeat.o(42870);
      return;
      paramInt = BackwardSupportUtil.b.b(this, 113.0F);
      continue;
      paramInt = BackwardSupportUtil.b.b(this, 97.0F);
      continue;
      com.tencent.mm.emoji.decode.b localb = MMGIFJNIFactory.Companion.getDecoder(this.lkU);
      paramInt = (int)(localb.Or() * this.osG.getEmojiDensityScale());
      localb.destroy();
      int i = BackwardSupportUtil.b.b(this, 150.0F);
      if ((paramInt >= i) || (bo.hl(paramInt, 0)))
      {
        paramInt = BackwardSupportUtil.b.b(this, 53.0F);
      }
      else
      {
        int j = BackwardSupportUtil.b.b(this, 53.0F);
        paramInt = (i - paramInt) / 2 + j;
      }
    }
  }
  
  private static int yF(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 0) {
      return 2;
    }
    return 0;
  }
  
  public boolean enableActivityAnimation()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(42865);
    super.finish();
    overridePendingTransition(0, 2131034180);
    AppMethodBeat.o(42865);
  }
  
  public int getLayoutId()
  {
    return 2130970043;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42866);
    setActionbarColor(-839716110);
    this.ovo = findViewById(2131825810);
    this.iux = ((ViewGroup)findViewById(2131825809));
    this.ovn = ((LinearLayout)findViewById(2131825817));
    this.ojp = ((ImageView)findViewById(2131825680));
    this.okf = ((TextView)findViewById(2131825681));
    this.kRB = ((TextView)findViewById(2131825686));
    this.nIU = ((TextView)findViewById(2131825818));
    this.osF = ((RelativeLayout)findViewById(2131825633));
    this.osG = ((BaseEmojiView)findViewById(2131825634));
    this.osH = ((TextView)findViewById(2131825635));
    this.osI = ((LinearLayout)findViewById(2131825636));
    this.osJ = ((MMAnimateView)findViewById(2131825637));
    this.okg = ((Button)findViewById(2131825819));
    this.okj = ((TextView)findViewById(2131825821));
    this.okh = findViewById(2131825820);
    this.oki = ((ImageView)findViewById(2131825687));
    this.ovp = ((ImageView)findViewById(2131825811));
    this.oml = ((ImageView)findViewById(2131825688));
    this.oml.setOnClickListener(new LuckyMoneyNotHookReceiveUI.6(this));
    this.ovq = ((ImageView)findViewById(2131825816));
    this.ovr = ((RelativeLayout)findViewById(2131825813));
    this.osH.setOnClickListener(new LuckyMoneyNotHookReceiveUI.7(this));
    this.kRB.setLines(2);
    TextView localTextView = this.kRB;
    if (Build.VERSION.SDK_INT >= 27)
    {
      localTextView.setAutoSizeTextTypeWithDefaults(1);
      this.maxSize = ((int)(com.tencent.mm.cb.a.ap(getContext(), 2131428520) * 1.125F));
      this.textSize = com.tencent.mm.cb.a.ao(getContext(), 2131428520);
      if (this.textSize <= this.maxSize) {
        break label469;
      }
    }
    label469:
    for (int i = this.maxSize;; i = this.textSize)
    {
      this.textSize = i;
      getContentView().setVisibility(8);
      this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), 3, 2131493306, getString(2131301086), true, new LuckyMoneyNotHookReceiveUI.8(this));
      bMV();
      AppMethodBeat.o(42866);
      return;
      if (!(localTextView instanceof android.support.v4.widget.b)) {
        break;
      }
      ((android.support.v4.widget.b)localTextView).setAutoSizeTextTypeWithDefaults(1);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42861);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131690605));
    }
    this.orJ = getIntent().getStringExtra("key_native_url");
    this.ovt = getIntent().getStringExtra("key_cropname");
    ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "nativeUrl= " + bo.nullAsNil(this.orJ));
    initView();
    paramBundle = Uri.parse(bo.nullAsNil(this.orJ));
    try
    {
      this.orH = paramBundle.getQueryParameter("sendid");
      label132:
      this.ovs = t.cTK().afw(this.orJ);
      if ((this.ovs != null) && (this.ovs.field_receiveAmount > 0L) && (bo.hl(this.ovs.field_receiveTime) < 86400000L))
      {
        ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache this item %s %s", new Object[] { Long.valueOf(this.ovs.field_receiveTime), bo.nullAsNil(this.orJ) });
        paramBundle = new Intent();
        paramBundle.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramBundle.putExtra("key_native_url", this.ovs.field_mNativeUrl);
        paramBundle.putExtra("key_sendid", this.orH);
        paramBundle.putExtra("key_anim_slide", true);
        paramBundle.putExtra("key_lucky_money_can_received", true);
        paramBundle.putExtra("key_username", getIntent().getStringExtra("key_username"));
        startActivity(paramBundle);
        finish();
        AppMethodBeat.o(42861);
        return;
      }
      if (!bo.isNullOrNil(this.orH))
      {
        int i = bo.getInt(paramBundle.getQueryParameter("channelid"), 1);
        this.nnY = paramBundle.getQueryParameter("sendusername");
        doSceneProgress(new aq(i, this.orH, this.orJ, getIntent().getIntExtra("key_way", 0), "v1.0"), false);
        if (this.tipDialog != null) {
          this.tipDialog.show();
        }
        AppMethodBeat.o(42861);
        return;
      }
      finish();
      ab.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "sendid null & finish");
      AppMethodBeat.o(42861);
      return;
    }
    catch (Exception localException)
    {
      break label132;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42862);
    super.onDestroy();
    if ((this.otw == 1) || (this.otw == 2))
    {
      this.otb = new ac();
      this.otb.cRI = 9L;
      this.otb.ake();
    }
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    com.tencent.mm.plugin.emoji.model.i.blo().lhf = null;
    com.tencent.mm.kernel.g.RK().eHt.b(697, this.otu);
    AppMethodBeat.o(42862);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(42864);
    super.onPause();
    com.tencent.mm.modelstat.d.o("LuckyMoneyReceiveUI", this.otr, bo.aox());
    AppMethodBeat.o(42864);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42863);
    super.onResume();
    this.otr = bo.aox();
    AppMethodBeat.o(42863);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42871);
    ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramm.getType());
    label591:
    boolean bool;
    if ((paramm instanceof aq))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.opT = ((aq)paramm);
        this.opL = this.opT.opL;
        com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(5), Integer.valueOf(yF(this.opT.cMP)), Integer.valueOf(bOh()), Integer.valueOf(0), Integer.valueOf(1) });
        paramString = new ad();
        paramString.field_mNativeUrl = this.orJ;
        paramString.field_hbType = this.opT.cMP;
        paramString.field_hbStatus = this.opT.cMQ;
        paramString.field_receiveStatus = this.opT.cMR;
        t.cTK().a(paramString);
        if (this.opT.cMR == 2)
        {
          doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.af(this.orH, 11, 0, this.orJ, "v1.0"), false);
          AppMethodBeat.o(42871);
          return true;
        }
        if (!bo.isNullOrNil(this.opT.opb))
        {
          this.otb = new ac();
          this.otb.cRI = 7L;
          this.otb.ake();
        }
        x.b(this.ojp, this.opT.ont, this.opT.onN);
        x.a(getContext(), this.okf, getString(2131301337, new Object[] { this.opT.opH }));
        this.ovn.post(new LuckyMoneyNotHookReceiveUI.10(this));
        if ((this.opT.cMR != 1) && (this.opT.cMQ != 4) && (this.opT.cMQ != 5) && (this.opT.cMQ != 1))
        {
          if (!bo.isNullOrNil(this.opT.onq))
          {
            this.kRB.setText(this.opT.onq);
            this.kRB.setVisibility(0);
          }
          if (!bo.isNullOrNil(this.opT.oiG))
          {
            x.a(getContext(), this.nIU, this.opT.oiG);
            this.nIU.setVisibility(0);
            this.kRB.setVisibility(8);
          }
          if ((!bo.isNullOrNil(this.opT.opb)) && (bo.hl(this.opL, 1)))
          {
            paramString = (LinearLayout.LayoutParams)this.ovn.getLayoutParams();
            paramString.topMargin = BackwardSupportUtil.b.b(getContext(), 53.0F);
            this.ovn.setLayoutParams(paramString);
            this.liJ = this.opT.opb;
            this.osW = this.opT.opc;
            this.osF.setVisibility(0);
            ja(true);
            this.okg.setOnClickListener(new LuckyMoneyNotHookReceiveUI.11(this));
            bool = false;
            if ((!r.Zn().equals(this.nnY)) && ((this.opT.cMP != 1) || (!bool))) {
              break label1299;
            }
            if (this.opT.cMP == 1) {
              this.okj.setText(2131301211);
            }
            this.okh.setVisibility(0);
            this.okh.setOnClickListener(new LuckyMoneyNotHookReceiveUI.12(this, bool));
            this.oki.setVisibility(8);
            label693:
            if ((this.opT.opN != null) && (this.opT.opN.opR != null))
            {
              paramString = this.opT.opN.opR;
              ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "render envelope");
              if (paramString != null)
              {
                ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.ovp, paramString, null);
                this.ovp.setVisibility(0);
                this.oki.setVisibility(8);
                this.ovu = true;
              }
              if (this.opT.opN.opR.xjM == null) {
                break label1319;
              }
            }
          }
        }
        label1287:
        label1299:
        label1319:
        for (paramString = this.opT.opN.opR.xjM.xjW;; paramString = "")
        {
          paramm = getIntent().getStringExtra("key_username");
          if (!bo.isNullOrNil(this.opT.opN.opR.xjL)) {
            this.ovt = this.opT.opN.opR.xjL;
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(16598, new Object[] { Integer.valueOf(2), this.ovt, paramString, paramm });
          if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
          {
            this.tipDialog.setOnDismissListener(new LuckyMoneyNotHookReceiveUI.2(this));
            this.tipDialog.dismiss();
          }
          this.iux.setBackgroundResource(2131690243);
          com.tencent.mm.ui.af.o(this, getResources().getColor(2131690243));
          getContentView().setVisibility(0);
          this.ovo.setVisibility(0);
          x.dr(this.ovo);
          break;
          paramString = (LinearLayout.LayoutParams)this.ovn.getLayoutParams();
          paramString.topMargin = BackwardSupportUtil.b.b(getContext(), 106.0F);
          this.ovn.setLayoutParams(paramString);
          paramm = (RelativeLayout.LayoutParams)this.ovr.getLayoutParams();
          paramm.topMargin = (paramString.topMargin - BackwardSupportUtil.b.b(this, 53.0F));
          this.ovr.setLayoutParams(paramm);
          this.ovr.invalidate();
          break label591;
          this.okg.setVisibility(8);
          if (!bo.isNullOrNil(this.opT.okM))
          {
            this.kRB.setText(this.opT.okM);
            this.kRB.setVisibility(0);
            label1112:
            if (bo.isNullOrNil(this.opT.onq)) {
              break label1287;
            }
            this.nIU.setText(this.opT.onq);
            this.nIU.setVisibility(0);
            this.nIU.setSingleLine(false);
          }
          for (;;)
          {
            paramString = (LinearLayout.LayoutParams)this.ovn.getLayoutParams();
            paramString.topMargin = BackwardSupportUtil.b.b(getContext(), 106.0F);
            this.ovn.setLayoutParams(paramString);
            paramm = (RelativeLayout.LayoutParams)this.okh.getLayoutParams();
            paramm.bottomMargin = BackwardSupportUtil.b.b(getContext(), 30.0F);
            this.okh.setLayoutParams(paramm);
            paramm = (RelativeLayout.LayoutParams)this.ovr.getLayoutParams();
            paramm.topMargin = (paramString.topMargin - BackwardSupportUtil.b.b(this, 53.0F));
            this.ovr.setLayoutParams(paramm);
            this.ovr.invalidate();
            bool = true;
            break;
            this.kRB.setVisibility(8);
            break label1112;
            this.nIU.setVisibility(8);
          }
          this.okh.setVisibility(8);
          this.oki.setVisibility(0);
          break label693;
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(42871);
      return false;
    }
    if ((paramm instanceof an))
    {
      x.d(this.okg);
      this.okg.setClickable(true);
      bMV();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (an)paramm;
        k.a(this, k.a.oxx);
        if ((paramString.isJumpRemind()) && (paramString.jumpRemind.a(this, new LuckyMoneyNotHookReceiveUI.3(this, paramString))))
        {
          AppMethodBeat.o(42871);
          return true;
        }
        a(paramString);
        if (this.ovu) {
          com.tencent.mm.plugin.report.service.h.qsU.cT(991, 13);
        }
        AppMethodBeat.o(42871);
        return true;
      }
      if (paramInt2 == 416)
      {
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        paramString = new Bundle();
        paramString.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNotHookReceiveUI");
        paramString.putString("realname_verify_process_jump_plugin", "luckymoney");
        this.okg.setBackgroundResource(2130838860);
        new LuckyMoneyNotHookReceiveUI.4(this);
        bool = x.a(this, paramInt2, paramm, paramString, false, null, 1003);
        AppMethodBeat.o(42871);
        return bool;
      }
    }
    else if ((paramm instanceof com.tencent.mm.plugin.luckymoney.model.af))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.luckymoney.model.af)paramm;
        paramm = new Intent();
        paramm.setClass(getContext(), LuckyMoneyBeforeDetailUI.class);
        paramm.putExtra("key_lucky_money_can_received", true);
        try
        {
          paramm.putExtra("key_detail_info", paramString.ooO.toByteArray());
          paramm.putExtra("key_jump_from", 2);
          paramm.putExtra("key_native_url", this.orJ);
          paramm.putExtra("key_sendid", this.orH);
          paramm.putExtra("key_anim_slide", true);
          paramm.putExtra("key_detail_emoji_md5", paramString.opb);
          paramm.putExtra("key_detail_emoji_type", paramString.opc);
          paramm.putExtra("key_username", getIntent().getStringExtra("key_username"));
          paramm.putExtra("key_emoji_switch", paramString.opd);
          startActivity(paramm);
          finish();
          AppMethodBeat.o(42871);
          return true;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ab.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + localIOException.getLocalizedMessage());
          }
        }
      }
      com.tencent.mm.ui.base.h.bO(this, paramString);
      finish();
      AppMethodBeat.o(42871);
      return true;
    }
    AppMethodBeat.o(42871);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI
 * JD-Core Version:    0.7.0.1
 */