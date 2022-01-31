package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.n;
import com.tencent.mm.g.b.a.o;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.wallet_core.c.k;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyNewYearSendUI
  extends LuckyMoneyBaseUI
{
  private int cEU;
  private Dialog gKM;
  private View.OnClickListener gMO;
  private EmojiInfo lkU;
  private Button lqP;
  private int mChannel;
  private ak mHandler;
  private TextView nIU;
  private String ope;
  private int opg;
  private int opn;
  private LinkedList<u> opq;
  private int oqI;
  private String oqM;
  private String orH;
  private a osR;
  private View osS;
  private ChatFooterPanel osX;
  private ViewGroup osZ;
  private int ote;
  private View ouI;
  private View ouJ;
  private TextView ouK;
  private ImageView ouL;
  private TextView ouM;
  private ImageView ouN;
  private ImageView ouO;
  private TextView ouP;
  private LinearLayout ouQ;
  private MMAnimateView ouR;
  private LinearLayout ouS;
  private String ouT;
  private boolean ouU;
  private int ouV;
  private int ouW;
  private EmojiInfo ouX;
  private n ouY;
  private o ouZ;
  private LuckyMoneyAutoScrollView oug;
  private TextView ouh;
  private ImageView ouv;
  private View ouw;
  private BaseEmojiView oux;
  private int ova;
  private int ovb;
  private int ovc;
  private int ovd;
  private int ove;
  private int ovf;
  private long ovg;
  private String ovh;
  private int ovi;
  private com.tencent.mm.emoji.d.a ovj;
  private String ovk;
  
  public LuckyMoneyNewYearSendUI()
  {
    AppMethodBeat.i(42823);
    this.gKM = null;
    this.ouU = true;
    this.ouV = 0;
    this.opn = 0;
    this.ouW = 0;
    this.mHandler = new ak();
    this.ova = 1;
    this.ote = 0;
    this.ovb = 0;
    this.ovc = 0;
    this.ovd = 0;
    this.ove = 0;
    this.ovf = 0;
    this.ovg = 0L;
    this.orH = "";
    this.ovh = "";
    this.gMO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42813);
        if (paramAnonymousView.getId() == 2131825740)
        {
          com.tencent.mm.plugin.report.service.h.qsU.e(13079, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
          ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSendBtn click!");
          LuckyMoneyNewYearSendUI.b(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(42813);
          return;
        }
        if (paramAnonymousView.getId() == 2131825741)
        {
          LuckyMoneyNewYearSendUI.this.finish();
          com.tencent.mm.plugin.report.service.h.qsU.e(13079, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new n());
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).cRI = 11L;
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).ake();
          LuckyMoneyNewYearSendUI.d(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(42813);
          return;
        }
        if ((paramAnonymousView.getId() == 2131825727) || (paramAnonymousView.getId() == 2131825728))
        {
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new n());
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).cRI = 3L;
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).ake();
          LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
          AppMethodBeat.o(42813);
          return;
        }
        if (paramAnonymousView.getId() == 2131825732)
        {
          LuckyMoneyNewYearSendUI.f(LuckyMoneyNewYearSendUI.this);
          LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 0);
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yEO, "");
          com.tencent.mm.plugin.report.service.h.qsU.e(13079, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new n());
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).cRI = 5L;
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).ake();
          AppMethodBeat.o(42813);
          return;
        }
        if (paramAnonymousView.getId() == 2131825739)
        {
          paramAnonymousView = LuckyMoneyNewYearSendUI.h(LuckyMoneyNewYearSendUI.this);
          paramAnonymousView.hasCallBack = false;
          paramAnonymousView.orl.setVisibility(0);
          paramAnonymousView.orm.setVisibility(0);
          paramAnonymousView.orn.setVisibility(0);
          paramAnonymousView.orr.setVisibility(4);
          paramAnonymousView.ors.setVisibility(4);
          paramAnonymousView.ort.setVisibility(4);
          LuckyMoneyNewYearSendUI.i(LuckyMoneyNewYearSendUI.this);
          com.tencent.mm.plugin.report.service.h.qsU.e(13079, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, new n());
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).cRI = 2L;
          LuckyMoneyNewYearSendUI.c(LuckyMoneyNewYearSendUI.this).ake();
          AppMethodBeat.o(42813);
          return;
        }
        if (paramAnonymousView.getId() == 2131825733)
        {
          paramAnonymousView = com.tencent.mm.emoji.d.d.eyp;
          com.tencent.mm.emoji.d.d.ge(LuckyMoneyNewYearSendUI.j(LuckyMoneyNewYearSendUI.this));
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, false);
          LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 4);
          AppMethodBeat.o(42813);
          return;
        }
        if (paramAnonymousView.getId() == 2131825731) {
          LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
        }
        AppMethodBeat.o(42813);
      }
    };
    this.ovi = 0;
    this.ovj = new LuckyMoneyNewYearSendUI.4(this);
    this.cEU = 0;
    this.ovk = "";
    AppMethodBeat.o(42823);
  }
  
  private void Sy(String paramString)
  {
    AppMethodBeat.i(42830);
    this.lkU = i.getEmojiStorageMgr().yNn.asP(paramString);
    this.oux.setEmojiInfo(this.lkU);
    yC(2);
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yEO, paramString);
    AppMethodBeat.o(42830);
  }
  
  private void bOf()
  {
    AppMethodBeat.i(42829);
    this.ouY = new n();
    this.ouY.cRI = 10L;
    this.ouY.ake();
    this.ote = 2;
    this.osR.show();
    if (bo.hl(this.ouV, 1)) {}
    for (int i = ChatFooterPanel.vQu;; i = ChatFooterPanel.vQr)
    {
      com.tencent.mm.plugin.luckymoney.ui.a.a.a(this.osZ, this.osX, i, new LuckyMoneyNewYearSendUI.7(this));
      AppMethodBeat.o(42829);
      return;
    }
  }
  
  private void bOg()
  {
    AppMethodBeat.i(42833);
    this.ovb += 1;
    int i;
    if ((this.opq != null) && (this.opq.size() > 0))
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RJ();
      i = com.tencent.mm.kernel.a.getUin();
      int j = this.opq.size();
      int k = (int)(System.currentTimeMillis() % j);
      i = (new Random(i).nextInt(j) + k) % j;
      ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:".concat(String.valueOf(i)));
    }
    for (;;)
    {
      this.ouW = i;
      if ((this.ouW >= 0) && (this.ouW < this.opq.size()))
      {
        this.opg = ((u)this.opq.get(this.ouW)).ooz;
        this.ope = ((u)this.opq.get(this.ouW)).ooA;
      }
      ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.ouW + " randomAmount:" + this.opg + " randomWishing:" + this.ope);
      this.oug.setFinalText(com.tencent.mm.wallet_core.ui.e.E(this.opg / 100.0D));
      jc(false);
      this.oug.setFocusable(false);
      this.oug.setContentDescription("");
      this.oug.a(new LuckyMoneyNewYearSendUI.11(this));
      AppMethodBeat.o(42833);
      return;
      ab.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
      i = -1;
    }
  }
  
  private void jc(boolean paramBoolean)
  {
    AppMethodBeat.i(42834);
    this.lqP.setClickable(paramBoolean);
    if (paramBoolean)
    {
      if ((this.lqP.getBackground() != null) && (this.lqP.getBackground().mutate() != null)) {
        this.lqP.getBackground().mutate().setAlpha(255);
      }
      this.lqP.setTextColor(getResources().getColor(2131690254));
      AppMethodBeat.o(42834);
      return;
    }
    if ((this.lqP.getBackground() != null) && (this.lqP.getBackground().mutate() != null)) {
      this.lqP.getBackground().mutate().setAlpha(128);
    }
    this.lqP.setTextColor(getResources().getColor(2131690255));
    AppMethodBeat.o(42834);
  }
  
  private void yB(int paramInt)
  {
    AppMethodBeat.i(42828);
    this.ouZ = new o();
    this.ouZ.cRJ = paramInt;
    this.ouZ.cRK = this.ova;
    this.ouZ.cRL = this.ovb;
    this.ouZ.cRM = this.ovc;
    this.ouZ.cRN = this.ovd;
    this.ouZ.cRQ = this.ove;
    this.ouZ.cRO = this.ovf;
    o localo = this.ouZ;
    if (this.lkU == null) {}
    for (String str = "";; str = this.lkU.Al())
    {
      localo.fg(str);
      this.ouZ.ake();
      AppMethodBeat.o(42828);
      return;
    }
  }
  
  private void yC(int paramInt)
  {
    AppMethodBeat.i(42831);
    if (bo.hl(this.opn, 0))
    {
      this.ouv.setVisibility(0);
      this.ouJ.setVisibility(8);
      this.ouw.setVisibility(8);
      AppMethodBeat.o(42831);
      return;
    }
    this.ouv.setVisibility(8);
    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "exchangeExpressionState() state:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42831);
      return;
      this.ouJ.setVisibility(0);
      this.ouK.setText(2131301190);
      this.ouw.setVisibility(8);
      AppMethodBeat.o(42831);
      return;
      this.ouJ.setVisibility(8);
      this.ouw.setVisibility(0);
      this.ouN.setVisibility(0);
      this.oux.setVisibility(8);
      this.ouO.setVisibility(8);
      this.ouP.setVisibility(8);
      this.ouQ.setVisibility(8);
      AppMethodBeat.o(42831);
      return;
      if (this.ouX != null)
      {
        this.ouY = new n();
        this.ouY.cRI = 4L;
        this.ouY.ake();
      }
      this.ouX = this.lkU;
      if (this.ote == 0) {
        if (com.tencent.mm.plugin.emoji.h.b.y(this.lkU)) {
          this.ova = 2;
        }
      }
      for (;;)
      {
        this.ouJ.setVisibility(8);
        this.ouw.setVisibility(0);
        this.ouN.setVisibility(8);
        this.oux.setVisibility(0);
        this.ouO.setVisibility(0);
        this.ouP.setVisibility(8);
        this.ouQ.setVisibility(8);
        AppMethodBeat.o(42831);
        return;
        if (com.tencent.mm.plugin.emoji.h.b.x(this.lkU))
        {
          this.ova = 4;
        }
        else
        {
          this.ova = 3;
          continue;
          if (this.ote == 1)
          {
            this.ova = 2;
            this.ovc += 1;
          }
          else if (this.ote == 2)
          {
            if (com.tencent.mm.plugin.emoji.h.b.y(this.lkU))
            {
              this.ova = 2;
              this.ovf += 1;
            }
            else if (com.tencent.mm.plugin.emoji.h.b.x(this.lkU))
            {
              this.ova = 4;
              this.ove += 1;
            }
            else
            {
              this.ova = 3;
              this.ovd += 1;
            }
          }
        }
      }
      this.ouJ.setVisibility(8);
      this.ouw.setVisibility(0);
      this.ouN.setVisibility(8);
      this.oux.setVisibility(8);
      this.ouO.setVisibility(8);
      this.ouP.setVisibility(0);
      this.ouQ.setVisibility(8);
      AppMethodBeat.o(42831);
      return;
      this.ouJ.setVisibility(8);
      this.ouw.setVisibility(0);
      this.ouN.setVisibility(8);
      this.oux.setVisibility(8);
      this.ouO.setVisibility(8);
      this.ouP.setVisibility(8);
      this.ouQ.setVisibility(0);
      this.ouR.setImageResource(2131231608);
      AppMethodBeat.o(42831);
      return;
      this.ouJ.setVisibility(0);
      this.ouK.setText(2131301261);
      this.ouw.setVisibility(8);
    }
  }
  
  private void yD(int paramInt)
  {
    AppMethodBeat.i(42832);
    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
    com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
    if (this.gKM != null) {
      if (!this.gKM.isShowing()) {
        this.gKM.show();
      }
    }
    for (;;)
    {
      String str2 = r.Zn();
      String str1 = "";
      int i = 0;
      if (this.lkU != null)
      {
        str1 = this.lkU.Al();
        i = this.lkU.field_type;
      }
      ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend() mUniqueId:%s userConfirmJump:%s lastPayResult:%s mSendId:%s", new Object[] { this.ovh, Integer.valueOf(paramInt), Integer.valueOf(this.cEU), this.orH });
      doSceneProgress(new ap(this.opg, this.ope, x.St(str2), this.ouT, str2, r.Zp(), this.oqI, str1, i, this.ovh, paramInt, this.cEU, this.orH), false);
      AppMethodBeat.o(42832);
      return;
      this.gKM = com.tencent.mm.wallet_core.ui.g.a(getContext(), true, new LuckyMoneyNewYearSendUI.10(this));
    }
  }
  
  public int getLayoutId()
  {
    return 2130970037;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42826);
    setActionbarColor(-839716110);
    setContentViewVisibility(8);
    this.ouI = findViewById(2131825724);
    this.ouh = ((TextView)findViewById(2131825738));
    this.oug = ((LuckyMoneyAutoScrollView)findViewById(2131825737));
    this.nIU = ((TextView)findViewById(2131825736));
    this.lqP = ((Button)findViewById(2131825740));
    this.lqP.setOnClickListener(this.gMO);
    ((ImageView)findViewById(2131825741)).setOnClickListener(this.gMO);
    this.ouv = ((ImageView)findViewById(2131825725));
    this.ouJ = findViewById(2131825726);
    this.ouK = ((TextView)findViewById(2131825728));
    this.ouL = ((ImageView)findViewById(2131825727));
    this.ouL.setOnClickListener(this.gMO);
    this.ouM = ((TextView)findViewById(2131825728));
    this.ouM.setOnClickListener(this.gMO);
    this.ouw = findViewById(2131825729);
    this.oux = ((BaseEmojiView)findViewById(2131825731));
    this.oux.setOnClickListener(this.gMO);
    this.ouO = ((ImageView)findViewById(2131825732));
    this.ouO.setOnClickListener(this.gMO);
    this.ouN = ((ImageView)findViewById(2131825730));
    this.ouP = ((TextView)findViewById(2131825733));
    this.ouP.setOnClickListener(this.gMO);
    this.ouQ = ((LinearLayout)findViewById(2131825734));
    this.ouR = ((MMAnimateView)findViewById(2131825735));
    this.ouS = ((LinearLayout)findViewById(2131825739));
    this.ouS.setOnClickListener(this.gMO);
    this.osR = new a(this);
    this.osS = getLayoutInflater().inflate(2130970026, null);
    this.osR.setContentView(this.osS, new ViewGroup.LayoutParams(-1, -1));
    this.osS.findViewById(2131825661).setOnClickListener(new LuckyMoneyNewYearSendUI.1(this));
    this.osR.oqT = new a.a()
    {
      public final void bNL()
      {
        AppMethodBeat.i(42812);
        LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
        AppMethodBeat.o(42812);
      }
    };
    this.osZ = ((ViewGroup)this.osS.findViewById(2131825663));
    this.osX = com.tencent.mm.pluginsdk.ui.chat.e.vYI.dK(getContext());
    com.tencent.mm.plugin.luckymoney.ui.a.a.a(this.osX);
    AppMethodBeat.o(42826);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42836);
    Object localObject1;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(42836);
      return;
    case 1: 
      if (paramInt2 == -1)
      {
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
        com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
        if ((paramIntent == null) || (!paramIntent.hasExtra("key_realname_guide_helper"))) {
          break label837;
        }
        localObject1 = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
        if (localObject1 == null) {
          break label837;
        }
        if (!((RealnameGuideHelper)localObject1).b(this, null, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(42810);
            LuckyMoneyNewYearSendUI.this.finish();
            AppMethodBeat.o(42810);
          }
        })) {
          paramInt1 = 1;
        }
      }
      break;
    }
    for (;;)
    {
      if (this.lkU == null)
      {
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() mEmojiInfo == null");
        localObject1 = br.F(this.oqM, "msg");
        if (localObject1 == null)
        {
          ab.e("MicroMsg.LuckyMoneyNewYearSendUI", "luckymoneyNewYearSendUI onActivityResult values is null");
          finish();
          AppMethodBeat.o(42836);
          return;
          paramInt1 = 0;
        }
      }
      else
      {
        for (;;)
        {
          try
          {
            int i = this.oqM.indexOf("<wcpayinfo>");
            if ((i > 0) && (i < this.oqM.length()))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              if (this.lkU != null) {
                break label366;
              }
              localObject1 = new EmojiInfo();
              com.tencent.mm.plugin.luckymoney.a.b.a(localStringBuilder, (bb)localObject1, 0);
              localObject1 = new StringBuilder(this.oqM.substring(0, i));
              String str = this.oqM.substring(i).trim();
              ((StringBuilder)localObject1).append(localStringBuilder).append(str);
              this.oqM = ((StringBuilder)localObject1).toString();
            }
            ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() success");
          }
          catch (Exception localException)
          {
            ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() Exception:%s", new Object[] { localException.getMessage() });
          }
          break;
          label366:
          localObject2 = this.lkU;
        }
      }
      Object localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
      if (com.tencent.mm.plugin.luckymoney.b.a.bMG().bMJ().Sr((String)localObject2))
      {
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb! mMsgXml:%s", new Object[] { this.oqM });
        x.J(this.oqM, this.ouT, 3);
        if (paramInt1 == 0) {
          finish();
        }
        this.ouY = new n();
        if (this.ova != 1) {
          break label574;
        }
        this.ouY.cRI = 8L;
        label474:
        this.ouY.ake();
        yB(1);
      }
      for (;;)
      {
        localObject2 = r.Zn();
        if (paramInt2 != -1) {
          break label649;
        }
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode == RESULT_OK");
        this.cEU = 1;
        this.ovk = "";
        paramIntent = new al(this.orH, this.ovh, 1, (String)localObject2, bo.nullAsNil(this.ouT));
        com.tencent.mm.kernel.g.RK().eHt.a(paramIntent, 0);
        AppMethodBeat.o(42836);
        return;
        ab.e("MicroMsg.LuckyMoneyNewYearSendUI", "it is a duplicate msg");
        break;
        label574:
        if (this.ova == 2)
        {
          this.ouY.cRI = 6L;
          break label474;
        }
        if (this.ova == 3)
        {
          this.ouY.cRI = 7L;
          break label474;
        }
        if (this.ova != 4) {
          break label474;
        }
        this.ouY.cRI = 14L;
        break label474;
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
      }
      label649:
      if (paramIntent != null) {}
      for (this.cEU = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.cEU = 3)
      {
        this.ovk = this.orH;
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.cEU) });
        paramIntent = new al(this.orH, this.ovh, this.cEU, (String)localObject2, bo.nullAsNil(this.ouT));
        break;
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "doNetSceneLuckyMoneyReport() data == null");
      }
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.ovg = paramIntent.getLongExtra("key_enter_time", 0L);
        }
        if (!bo.ah(this.ovg, 0L))
        {
          yC(4);
          jc(false);
          paramIntent = com.tencent.mm.emoji.d.b.eyc;
          com.tencent.mm.emoji.d.b.a(this.ovg, this.ovj);
          AppMethodBeat.o(42836);
          return;
        }
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "mTimeEnter == 0L go emoji capture failed!");
        AppMethodBeat.o(42836);
        return;
      }
      ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "go emoji capture failed!");
      break;
      label837:
      paramInt1 = 0;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(42827);
    yB(2);
    finish();
    AppMethodBeat.o(42827);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42824);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
    this.ouT = getIntent().getStringExtra("key_username");
    this.oqI = getIntent().getIntExtra("key_way", 0);
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    if (bo.isNullOrNil(this.ouT))
    {
      ab.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
      finish();
    }
    initView();
    doSceneProgress(new ag("v1.0", ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJl, Integer.valueOf(0))).intValue()));
    com.tencent.mm.plugin.report.service.h.qsU.e(13079, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    AppMethodBeat.o(42824);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42825);
    super.onDestroy();
    if ((this.gKM != null) && (this.gKM.isShowing())) {
      this.gKM.dismiss();
    }
    if (this.osX != null)
    {
      ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "commentfooter release");
      this.osX.onPause();
      this.osX.Ay();
      this.osX.destroy();
    }
    com.tencent.mm.emoji.d.b localb = com.tencent.mm.emoji.d.b.eyc;
    com.tencent.mm.emoji.d.b.b(this.ovg, this.ovj);
    AppMethodBeat.o(42825);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42835);
    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramm.getType());
    if ((paramm instanceof ag))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ag)paramm;
        this.opg = paramString.opg;
        this.ope = paramString.ope;
        this.ouV = paramString.opm;
        this.opn = paramString.opn;
        this.ovh = paramString.feA;
        this.opq = paramString.opq;
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "enableSelfIe is %s", new Object[] { Integer.valueOf(this.ouV) });
        bOg();
        ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
        if ((this.opq != null) && (this.opq.size() > 0))
        {
          ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
          this.ouS.setVisibility(0);
          this.nIU.getLayoutParams();
          this.nIU.setTextSize(1, 21.0F);
          this.ouh.setTextSize(1, 15.0F);
          this.oug.eD(getResources().getDimensionPixelOffset(2131428545), getResources().getDimensionPixelOffset(2131428541));
          paramString = (LinearLayout.LayoutParams)this.oug.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131428528);
          this.oug.setLayoutParams(paramString);
          this.oug.invalidate();
          paramString = (LinearLayout.LayoutParams)this.ouS.getLayoutParams();
          paramString.topMargin = getResources().getDimensionPixelOffset(2131428531);
          this.ouS.setLayoutParams(paramString);
          this.ouS.invalidate();
          paramString = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yEO, "");
          if (!bo.isNullOrNil(paramString)) {
            break label412;
          }
          yC(0);
        }
        for (;;)
        {
          setContentViewVisibility(0);
          x.a(this.ouI, null);
          AppMethodBeat.o(42835);
          return true;
          ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
          this.ouS.setVisibility(8);
          break;
          label412:
          Sy(paramString);
        }
      }
      finish();
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(42835);
        return false;
        if ((paramm instanceof ao))
        {
          if ((this.gKM != null) && (this.gKM.isShowing())) {
            this.gKM.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (ao)paramm;
            this.oqM = paramString.opz;
            paramm = new PayInfo();
            paramm.cnI = paramString.opy;
            paramm.cCD = 37;
            paramm.cCy = this.mChannel;
            com.tencent.mm.pluginsdk.wallet.h.a(this, paramm, 1);
            AppMethodBeat.o(42835);
            return true;
          }
          ab.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
        else
        {
          if (!(paramm instanceof ap)) {
            break;
          }
          if ((this.gKM != null) && (this.gKM.isShowing())) {
            this.gKM.dismiss();
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
            paramString = (ap)paramm;
            this.oqM = paramString.opz;
            this.orH = paramString.ojA;
            if (paramString.isJumpRemind())
            {
              ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() NetScenePrepareNewYearLuckyMoney show JumpRemind Alert");
              paramString.jumpRemind.a(this, new LuckyMoneyNewYearSendUI.12(this));
              AppMethodBeat.o(42835);
              return true;
            }
            paramm = new PayInfo();
            paramm.cnI = paramString.opy;
            paramm.cCD = 37;
            paramm.cCy = this.mChannel;
            com.tencent.mm.pluginsdk.wallet.h.a(this, paramm, 1);
            AppMethodBeat.o(42835);
            return true;
          }
          if (paramInt2 == 268502454)
          {
            com.tencent.mm.ui.base.h.a(this, paramString, "", new LuckyMoneyNewYearSendUI.2(this, paramm));
            AppMethodBeat.o(42835);
            return true;
          }
          ab.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
      }
    } while (!(paramm instanceof al));
    AppMethodBeat.o(42835);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI
 * JD-Core Version:    0.7.0.1
 */