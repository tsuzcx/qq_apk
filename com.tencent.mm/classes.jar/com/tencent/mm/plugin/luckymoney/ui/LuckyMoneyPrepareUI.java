package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.api.p;
import com.tencent.mm.api.z.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.b.a.br;
import com.tencent.mm.g.b.a.bs;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.luckymoney.model.aj;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements g
{
  private int dvA;
  private int fsv;
  private av irp;
  private TextView lln;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private boolean mKindaEnable;
  private com.tencent.mm.sdk.b.c<nx> mPayLoopInterruptListener;
  private String mSessionId;
  private int mType;
  private TextView nXQ;
  private EmojiInfo oBl;
  private Button oHj;
  private j sYI;
  private TextView sZA;
  private b sZC;
  private LuckyMoneyNumInputView sZt;
  private LuckyMoneyTextInputView sZv;
  private Button sZw;
  private MMScrollView sZz;
  private com.tencent.mm.plugin.luckymoney.model.e tdg;
  private int tft;
  private LuckyMoneyMoneyInputView tgI;
  private View tgJ;
  private View tgK;
  private ViewGroup tgL;
  private int tgM;
  private String tgN;
  private int tgO;
  private boolean tgP;
  private String tgQ;
  public Dialog tipDialog;
  private String tka;
  private ViewGroup tlB;
  private br tlD;
  private int tlG;
  private a tlr;
  private View tls;
  private ChatFooterPanel tlz;
  private int tnK;
  private String tnR;
  private String tnU;
  private String tpA;
  private String tpB;
  private bs tpC;
  private int tpD;
  private String tpE;
  private String tpF;
  private boolean tpG;
  private int tpH;
  private String tpI;
  private int tpJ;
  private long tpK;
  private long tpL;
  private String tpM;
  private com.tencent.mm.ui.widget.d tpN;
  private boolean tpO;
  private boolean tpP;
  private boolean tpQ;
  private boolean tpR;
  private com.tencent.mm.sdk.b.c<st> tpS;
  private Dialog tpn;
  private Dialog tpo;
  private RelativeLayout tpp;
  private TextView tpq;
  private TextView tpr;
  private ImageView tps;
  private ImageView tpt;
  private ImageView tpu;
  private TextView tpv;
  private int tpw;
  private String tpx;
  private String tpy;
  private RealnameGuideHelper tpz;
  
  public LuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65882);
    this.sZt = null;
    this.tgI = null;
    this.sZv = null;
    this.nXQ = null;
    this.sZw = null;
    this.oHj = null;
    this.tipDialog = null;
    this.tpn = null;
    this.tpo = null;
    this.sZC = new b();
    this.irp = null;
    this.tpw = 1;
    this.tpx = com.tencent.mm.wallet_core.ui.e.aNd("CNY");
    this.tpy = null;
    this.tka = "";
    this.tnK = 1;
    this.tlG = 0;
    this.tpG = false;
    this.mPayLoopInterruptListener = new LuckyMoneyPrepareUI.1(this);
    this.tpO = false;
    this.tpP = false;
    this.tpQ = false;
    this.tpR = false;
    this.tpS = new com.tencent.mm.sdk.b.c() {};
    this.dvA = 0;
    this.tnU = "";
    AppMethodBeat.o(65882);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65897);
    this.sZv.A(paramEmojiInfo);
    if ((this.tlG == 0) || (this.tlG == 2)) {
      if (com.tencent.mm.plugin.emoji.h.b.y(paramEmojiInfo)) {
        this.tnK = 2;
      }
    }
    for (;;)
    {
      this.tlD = new br();
      this.tlD.dMW = 1L;
      this.tlD.aBj();
      AppMethodBeat.o(65897);
      return;
      if (com.tencent.mm.plugin.emoji.h.b.w(paramEmojiInfo))
      {
        this.tnK = 4;
      }
      else
      {
        this.tnK = 3;
        continue;
        if (this.tlG == 1) {
          this.tnK = 2;
        }
      }
    }
  }
  
  private void Gi(int paramInt)
  {
    AppMethodBeat.i(65888);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() userConfirmJump:%s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cLP()), Integer.valueOf(4) });
    com.tencent.mm.plugin.report.service.h.vKh.f(15511, new Object[] { Integer.valueOf(this.tpw), Integer.valueOf(2) });
    if (this.tgI.cKY() != 0)
    {
      t.makeText(getContext(), 2131765031, 0).show();
      AppMethodBeat.o(65888);
      return;
    }
    int i = this.sZt.getInput();
    double d = this.tgI.getInput();
    long l2 = 0L;
    long l1;
    if (this.mType == 1)
    {
      l1 = com.tencent.mm.wallet_core.ui.e.F(d);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(356354, Integer.valueOf(i));
      str = this.sZv.getInput().replace("\r", "").replace("\n", "");
      localObject = str;
      if (bt.isNullOrNil(str)) {
        if (!bt.isNullOrNil(this.tpy)) {
          break label336;
        }
      }
    }
    label336:
    for (Object localObject = getString(2131760843);; localObject = this.tpy)
    {
      hideTenpayKB();
      if (this.fsv != 2) {
        break label345;
      }
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.d(i, (int)l1, this.mType, (int)l2), false);
      cMM();
      AppMethodBeat.o(65888);
      return;
      l1 = com.tencent.mm.wallet_core.ui.e.F(i * d);
      l2 = com.tencent.mm.wallet_core.ui.e.F(d);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(356353, Integer.valueOf(i));
      break;
    }
    label345:
    String str = getIntent().getStringExtra("key_username");
    if (this.tpw == 1)
    {
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() ifGetConfig=%s mUniqueId=%s waitingGetConfig=%s ifAutoRMBPrePareBtn=%s", new Object[] { Boolean.valueOf(this.tpO), bt.nullAsNil(this.tnR), Boolean.valueOf(this.tpP), Boolean.valueOf(this.tpQ) });
      if (this.tpO)
      {
        a(paramInt, str, i, l1, l2, (String)localObject);
        AppMethodBeat.o(65888);
        return;
      }
      this.tpQ = true;
      this.tpH = paramInt;
      this.tpI = str;
      this.tpJ = i;
      this.tpK = l1;
      this.tpL = l2;
      this.tpM = ((String)localObject);
      if (this.tpo != null) {
        this.tpo.show();
      }
      for (;;)
      {
        if (!this.tpP) {
          mS(false);
        }
        AppMethodBeat.o(65888);
        return;
        this.tpo = com.tencent.mm.ui.base.h.a(this, 3, 2131820985, getString(2131760709), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(65829);
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "coperationTipDialogNoTransparent onCancel()");
            LuckyMoneyPrepareUI.m(LuckyMoneyPrepareUI.this);
            LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this);
            if ((LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this) != null) && (LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this).isShowing())) {
              LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this).dismiss();
            }
            if ((LuckyMoneyPrepareUI.p(LuckyMoneyPrepareUI.this).getVisibility() == 8) || (LuckyMoneyPrepareUI.q(LuckyMoneyPrepareUI.this).getVisibility() == 4))
            {
              ad.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
              LuckyMoneyPrepareUI.this.finish();
            }
            LuckyMoneyPrepareUI.this.tjY.forceCancel();
            AppMethodBeat.o(65829);
          }
        });
      }
    }
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "currency=%s userConfiremJump:%s", new Object[] { Integer.valueOf(this.tpw), Integer.valueOf(paramInt) });
    addSceneEndListener(1647);
    if ((this.tgP) && (!bt.isNullOrNil(str))) {}
    for (localObject = new aj(i, l1, l2, this.mType, (String)localObject, str, z.cLy(), com.tencent.mm.model.u.aqG(), this.tpw);; localObject = new aj(i, l1, l2, this.mType, (String)localObject, null, z.cLy(), com.tencent.mm.model.u.aqG(), this.tpw))
    {
      doSceneProgress((n)localObject, false);
      break;
    }
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(65890);
    String str2 = "";
    int i = 0;
    if (this.oBl != null)
    {
      str2 = this.oBl.JS();
      i = this.oBl.field_type;
    }
    String str1 = "";
    if (this.tdg != null) {
      str1 = this.tdg.tcO;
    }
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB. userConfirmJump:%s lastPayResult:%s mSendId:%s mUniqueId:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.dvA), this.tka, this.tnR });
    if ((this.tgP) && (!bt.isNullOrNil(paramString1))) {}
    for (paramString1 = new com.tencent.mm.plugin.luckymoney.model.aq(paramInt2, paramLong1, paramLong2, this.mType, paramString2, z.cLy(), paramString1, z.sg(paramString1), com.tencent.mm.model.u.aqG(), com.tencent.mm.model.u.aqI(), this.tgM, str1, this.tnR, paramInt1, this.dvA, this.tka, str2, i);; paramString1 = new com.tencent.mm.plugin.luckymoney.model.aq(paramInt2, paramLong1, paramLong2, this.mType, paramString2, z.cLy(), null, null, com.tencent.mm.model.u.aqG(), com.tencent.mm.model.u.aqI(), this.tgM, str1, this.tnR, paramInt1, this.dvA, this.tka, str2, i))
    {
      doSceneProgress(paramString1, false);
      if (!bt.isNullOrNil(str1)) {
        com.tencent.mm.plugin.report.service.h.vKh.dB(991, 11);
      }
      cMM();
      AppMethodBeat.o(65890);
      return;
    }
  }
  
  private void afy(String paramString)
  {
    AppMethodBeat.i(65898);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=".concat(String.valueOf(paramString)));
    TextView localTextView = (TextView)findViewById(2131301716);
    if (!bt.isNullOrNil(paramString))
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(65898);
      return;
    }
    localTextView.setText(getString(2131760830));
    AppMethodBeat.o(65898);
  }
  
  private void afz(String paramString)
  {
    AppMethodBeat.i(65911);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ag(this.tka, paramString, this.tpA), false);
    AppMethodBeat.o(65911);
  }
  
  private void b(double paramDouble, String paramString)
  {
    AppMethodBeat.i(65908);
    if (bt.isNullOrNil(paramString))
    {
      this.nXQ.setText(com.tencent.mm.wallet_core.ui.e.E(paramDouble));
      AppMethodBeat.o(65908);
      return;
    }
    this.nXQ.setText(paramString + com.tencent.mm.wallet_core.ui.e.D(paramDouble));
    AppMethodBeat.o(65908);
  }
  
  private void b(bfu parambfu)
  {
    AppMethodBeat.i(65892);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "update envelope");
    if ((this.tdg != null) && (parambfu != null) && (this.fsv != 2))
    {
      this.tpp.setVisibility(0);
      boolean bool = com.tencent.mm.z.c.adr().a(ae.a.Fsg, ae.a.Fsi);
      Object localObject;
      if (!this.tpG)
      {
        localObject = com.tencent.mm.plugin.report.service.h.vKh;
        if (!bool) {
          break label233;
        }
      }
      label233:
      for (int i = 2;; i = 1)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).f(18890, new Object[] { Integer.valueOf(1), Integer.valueOf(i), this.mSessionId });
        this.tpG = true;
        if ((!this.tdg.tcP) || (bt.isNullOrNil(this.tdg.tcQ))) {
          break label334;
        }
        localObject = bt.kS((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fsk, ""), ",");
        Iterator localIterator = ((List)localObject).iterator();
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
        } while (!str.equals(this.tdg.tcN.Daf));
        ad.d("MicroMsg.LuckyMoneyPrepareUI", "has alert illegal: %s", new Object[] { str });
        AppMethodBeat.o(65892);
        return;
      }
      ((List)localObject).add(this.tdg.tcN.Daf);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fsk, bt.n((List)localObject, ","));
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "show alert illegal: %s", new Object[] { this.tdg.tcN.Daf });
      com.tencent.mm.ui.base.h.a(getContext(), this.tdg.tcQ, "", getString(2131766205), new LuckyMoneyPrepareUI.8(this));
      label334:
      if ((parambfu == null) || (parambfu.cGx != 1)) {
        break label448;
      }
      this.tpp.setEnabled(false);
      if (!bt.isNullOrNil(parambfu.DDv)) {
        this.tpq.setText(parambfu.DDv);
      }
      this.tps.setImageBitmap(null);
      this.tpt.setVisibility(8);
      this.tpq.setTextColor(getResources().getColor(2131099660));
    }
    for (;;)
    {
      if ((parambfu == null) || (parambfu.gGU != 2)) {
        break label581;
      }
      this.tpr.setVisibility(0);
      AppMethodBeat.o(65892);
      return;
      this.tpp.setVisibility(8);
      break;
      label448:
      if ((parambfu != null) && (!bt.isNullOrNil(parambfu.DDg)))
      {
        this.tpp.setEnabled(true);
        this.tpq.setText(parambfu.DDg);
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.tps, parambfu);
        this.tpt.setVisibility(0);
        this.tpq.setTextColor(getResources().getColor(2131100020));
      }
      else
      {
        this.tpp.setEnabled(true);
        this.tps.setImageBitmap(null);
        this.tpq.setText("");
        this.tpt.setVisibility(0);
        this.tpq.setTextColor(getResources().getColor(2131100020));
      }
    }
    label581:
    this.tpr.setVisibility(8);
    AppMethodBeat.o(65892);
  }
  
  private int cLP()
  {
    AppMethodBeat.i(65909);
    if (this.tgP)
    {
      if (getIntent().getIntExtra("key_chatroom_num", 0) > 0)
      {
        AppMethodBeat.o(65909);
        return 2;
      }
      AppMethodBeat.o(65909);
      return 1;
    }
    AppMethodBeat.o(65909);
    return 3;
  }
  
  private void cMM()
  {
    AppMethodBeat.i(65889);
    if (this.tipDialog != null)
    {
      this.tipDialog.show();
      AppMethodBeat.o(65889);
      return;
    }
    this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(getContext(), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(65830);
        if ((LuckyMoneyPrepareUI.r(LuckyMoneyPrepareUI.this) != null) && (LuckyMoneyPrepareUI.r(LuckyMoneyPrepareUI.this).isShowing())) {
          LuckyMoneyPrepareUI.r(LuckyMoneyPrepareUI.this).dismiss();
        }
        if ((LuckyMoneyPrepareUI.s(LuckyMoneyPrepareUI.this).getVisibility() == 8) || (LuckyMoneyPrepareUI.t(LuckyMoneyPrepareUI.this).getVisibility() == 4))
        {
          ad.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
          LuckyMoneyPrepareUI.this.finish();
        }
        LuckyMoneyPrepareUI.this.tjY.forceCancel();
        AppMethodBeat.o(65830);
      }
    });
    this.tipDialog.setCancelable(false);
    AppMethodBeat.o(65889);
  }
  
  private boolean cMN()
  {
    AppMethodBeat.i(65907);
    if ((this.sYI != null) && (!bt.isNullOrNil(this.sYI.tdd)))
    {
      AppMethodBeat.o(65907);
      return true;
    }
    AppMethodBeat.o(65907);
    return false;
  }
  
  private void g(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65899);
    String str1 = getIntent().getStringExtra("key_username");
    String str2 = com.tencent.mm.model.u.aqG();
    if (paramInt == -1)
    {
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode == RESULT_OK");
      this.dvA = 1;
      this.tnU = "";
      paramIntent = new an(this.tka, this.tnR, 1, str2, bt.nullAsNil(str1));
      com.tencent.mm.kernel.g.afA().gcy.a(paramIntent, 0);
      AppMethodBeat.o(65899);
      return;
    }
    if (paramIntent != null) {}
    for (this.dvA = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.dvA = 3)
    {
      this.tnU = this.tka;
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.dvA) });
      paramIntent = new an(this.tka, this.tnR, this.dvA, str2, bt.nullAsNil(str1));
      break;
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "doNetSceneLuckyMoneyReport() data == null");
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(65891);
    if (this.tpw == 1)
    {
      addIconOptionMenu(0, 2131690603, new LuckyMoneyPrepareUI.5(this));
      AppMethodBeat.o(65891);
      return;
    }
    addIconOptionMenu(0, 2131233032, new LuckyMoneyPrepareUI.6(this));
    AppMethodBeat.o(65891);
  }
  
  private void mS(boolean paramBoolean)
  {
    AppMethodBeat.i(65894);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "do get config");
    if (paramBoolean) {
      this.tpn = z.fr(getContext());
    }
    this.tpP = true;
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fsj, Integer.valueOf(0))).intValue();
    this.tpD = i;
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ai("v1.0", i, (byte)0), false);
    AppMethodBeat.o(65894);
  }
  
  protected final void ag(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(65903);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    View localView = findViewById(2131305696);
    final EditText localEditText = (EditText)paramView.findViewById(2131301810);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(65903);
      return;
    }
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      boolean cde = true;
      
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65872);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new ap().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65870);
              if ((!LuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (paramAnonymousView.isShown()))
              {
                LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                LuckyMoneyPrepareUI.I(LuckyMoneyPrepareUI.this).setVisibility(8);
              }
              LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.37.this.val$editMode);
              LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
              ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              AppMethodBeat.o(65870);
            }
          }, 300L);
          AppMethodBeat.o(65872);
          return;
        }
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(65871);
            LuckyMoneyPrepareUI.I(LuckyMoneyPrepareUI.this).setVisibility(0);
            LuckyMoneyPrepareUI.this.hideTenpayKB();
            ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(LuckyMoneyPrepareUI.37.this.val$hintTv, 0);
            AppMethodBeat.o(65871);
          }
        }, 200L);
        AppMethodBeat.o(65872);
      }
    });
    localEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65873);
        if ((!LuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
        {
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, paramInt);
          AppMethodBeat.o(65873);
          return;
        }
        if (this.val$isShowSysKB)
        {
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
          LuckyMoneyPrepareUI.I(LuckyMoneyPrepareUI.this).setVisibility(0);
          ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
        }
        AppMethodBeat.o(65873);
      }
    });
    TextView localTextView = (TextView)paramView.findViewById(2131301716);
    if (localTextView != null) {
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65875);
          if ((LuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
          {
            if (LuckyMoneyPrepareUI.this.mKeyboard != null)
            {
              LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(localEditText);
              AppMethodBeat.o(65875);
            }
          }
          else
          {
            if ((!LuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
            {
              ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              new ap().postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(65874);
                  LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                  LuckyMoneyPrepareUI.39.this.val$parent.requestFocus();
                  if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
                    LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(LuckyMoneyPrepareUI.39.this.val$hintTv);
                  }
                  LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.39.this.val$editMode);
                  AppMethodBeat.o(65874);
                }
              }, 200L);
              AppMethodBeat.o(65875);
              return;
            }
            if (this.val$isShowSysKB)
            {
              LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
              ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
            }
          }
          AppMethodBeat.o(65875);
        }
      });
    }
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65876);
        LuckyMoneyPrepareUI.this.hideTenpayKB();
        AppMethodBeat.o(65876);
      }
    });
    AppMethodBeat.o(65903);
  }
  
  public final void cKZ()
  {
    AppMethodBeat.i(65906);
    com.tencent.mm.plugin.luckymoney.b.a.cKP();
    this.sYI = com.tencent.mm.plugin.luckymoney.b.a.cKQ().cLt();
    int i;
    double d2;
    double d1;
    if ((this.tgI.cKY() != 3) && (this.sZt.cKY() != 3))
    {
      i = this.sZt.getInput();
      d2 = this.tgI.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.tgI.getInput();
      }
    }
    for (;;)
    {
      if (this.sZC.cMw())
      {
        ad.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
        this.sZw.setClickable(false);
        this.sZw.setEnabled(false);
        b(d2, this.tpx);
        AppMethodBeat.o(65906);
        return;
        if (i > 0) {
          d1 = this.tgI.getInput() / i;
        }
      }
      else
      {
        boolean bool2;
        if ((d2 == 0.0D) || (d1 == 0.0D)) {
          bool2 = true;
        }
        for (;;)
        {
          label408:
          boolean bool1;
          if (bool2)
          {
            this.sZw.setClickable(false);
            this.sZw.setEnabled(false);
            break;
            if ((d2 > this.sYI.sYh) && (this.sYI.sYh > 0.0D))
            {
              this.sZC.Mp(getString(2131760977, new Object[] { Math.round(this.sYI.sYh), bt.by(this.sYI.sYk, "") }));
              bool2 = true;
              continue;
            }
            if (d1 <= 0.0D) {
              break label1033;
            }
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d1)));
            if (this.mType == 0)
            {
              if ((d1 <= this.sYI.sYf) || (this.sYI.sYf <= 0.0D)) {
                break label1027;
              }
              if (cMN())
              {
                this.sZC.Mp(getString(2131760923, new Object[] { this.sYI.tdd, Math.round(this.sYI.sYf), bt.by(this.sYI.sYk, "") }));
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
            bool2 = bool1;
            if (!bool1)
            {
              if (this.mType != 0) {
                break label878;
              }
              bool2 = bool1;
              if (d1 < this.sYI.sYg)
              {
                if (!cMN()) {
                  break label829;
                }
                this.sZC.Mp(getString(2131760925, new Object[] { this.sYI.tdd, com.tencent.mm.wallet_core.ui.e.D(this.sYI.sYg), bt.by(this.sYI.sYk, "") }));
                label536:
                bool2 = true;
              }
            }
            label829:
            label878:
            do
            {
              ad.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
              break;
              this.sZC.Mp(getString(2131760922, new Object[] { Math.round(this.sYI.sYf), bt.by(this.sYI.sYk, "") }));
              break label408;
              if ((d1 <= this.sYI.sYi) || (this.sYI.sYi <= 0.0D)) {
                break label1027;
              }
              if ((this.sYI != null) && (!bt.isNullOrNil(this.sYI.tdd))) {
                this.sZC.Mp(getString(2131760923, new Object[] { this.sYI.tdd, Math.round(this.sYI.sYi), bt.by(this.sYI.sYk, "") }));
              }
              for (;;)
              {
                this.sZt.onError();
                this.tgI.onError();
                bool1 = true;
                break;
                this.sZC.Mp(getString(2131760922, new Object[] { Math.round(this.sYI.sYi), bt.by(this.sYI.sYk, "") }));
              }
              this.sZC.Mp(getString(2131760924, new Object[] { com.tencent.mm.wallet_core.ui.e.D(this.sYI.sYg), bt.by(this.sYI.sYk, "") }));
              break label536;
              bool2 = bool1;
            } while (d1 >= 0.01D);
            if (cMN()) {
              this.sZC.Mp(getString(2131760925, new Object[] { this.sYI.tdd, "0.01", bt.by(this.sYI.sYk, "") }));
            }
            for (;;)
            {
              this.sZt.onError();
              this.tgI.onError();
              bool2 = true;
              break;
              this.sZC.Mp(getString(2131760924, new Object[] { "0.01", bt.by(this.sYI.sYk, "") }));
            }
            this.sZw.setClickable(true);
            this.sZw.setEnabled(true);
            break;
            label1027:
            bool1 = false;
          }
          label1033:
          bool2 = false;
        }
      }
      d1 = 0.0D;
      continue;
      d1 = 0.0D;
      d2 = 0.0D;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65895);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.tgJ.getVisibility() == 0))
    {
      this.tgJ.setVisibility(8);
      cMl();
      AppMethodBeat.o(65895);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65895);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(65910);
    if (this.tpz != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_realname_guide_helper", this.tpz);
      com.tencent.mm.bs.d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
    }
    super.finish();
    AppMethodBeat.o(65910);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494656;
  }
  
  public final void h(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65901);
    if (paramInt == -1)
    {
      String str = "";
      if (paramIntent != null) {
        str = paramIntent.getStringExtra("key_trans_id");
      }
      afz(str);
    }
    finish();
    AppMethodBeat.o(65901);
  }
  
  protected final void hideTenpayKB()
  {
    AppMethodBeat.i(65905);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown())) {
      this.mKBLayout.setVisibility(8);
    }
    AppMethodBeat.o(65905);
  }
  
  public final void i(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65902);
    if (paramIntent.hasExtra("key_realname_guide_helper")) {
      this.tpz = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
    }
    if (paramInt == -1)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cLP()), Integer.valueOf(5) });
      Object localObject1 = getIntent().getStringExtra("key_username");
      if ((this.tgP) && (!bt.isNullOrNil((String)localObject1)))
      {
        com.tencent.mm.ui.base.h.cf(this, getString(2131760233));
        Object localObject2 = bw.K(this.tgQ, "msg");
        if (localObject2 == null)
        {
          ad.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
          finish();
          AppMethodBeat.o(65902);
          return;
        }
        localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
        if (com.tencent.mm.plugin.luckymoney.b.a.cKP().cKS().afm((String)localObject2))
        {
          ad.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
          if (!z.V(this.tgQ, (String)localObject1, 1))
          {
            ad.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
            com.tencent.mm.plugin.luckymoney.b.a.cKP().cKS().afn((String)localObject2);
          }
          g(paramInt, paramIntent);
          this.tpC = new bs();
          this.tpC.dPU = this.tnK;
          if (this.oBl != null) {
            break label347;
          }
          localObject1 = "";
          label269:
          this.tpC.ip((String)localObject1);
          this.tpC.aBj();
          ad.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.tnK), localObject1 });
          finish();
        }
      }
      for (;;)
      {
        afz(paramIntent.getStringExtra("key_trans_id"));
        AppMethodBeat.o(65902);
        return;
        ad.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
        break;
        label347:
        localObject1 = this.oBl.JS();
        break label269;
        cMm();
        localObject1 = findViewById(2131301906);
        this.tgJ.setVisibility(0);
        z.a((View)localObject1, null);
        this.oHj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65868);
            com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
            z.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.G(LuckyMoneyPrepareUI.this), true);
            LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65867);
                LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
                LuckyMoneyPrepareUI.this.cMl();
                AppMethodBeat.o(65867);
              }
            }, 100L);
            AppMethodBeat.o(65868);
          }
        });
        ((ImageView)findViewById(2131301897)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65869);
            LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
            LuckyMoneyPrepareUI.this.cMl();
            AppMethodBeat.o(65869);
          }
        });
        g(paramInt, paramIntent);
      }
    }
    g(paramInt, paramIntent);
    AppMethodBeat.o(65902);
  }
  
  public void initView()
  {
    AppMethodBeat.i(65886);
    setBackBtn(new LuckyMoneyPrepareUI.12(this));
    this.tgJ = findViewById(2131301905);
    this.tgK = findViewById(2131301908);
    this.oHj = ((Button)findViewById(2131301907));
    this.sZv = ((LuckyMoneyTextInputView)findViewById(2131301959));
    this.sZv.setHintText(getString(2131760843));
    this.sZw = ((Button)findViewById(2131301896));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    this.lln = ((TextView)findViewById(2131301894));
    this.sZt = ((LuckyMoneyNumInputView)findViewById(2131301891));
    this.tgI = ((LuckyMoneyMoneyInputView)findViewById(2131301715));
    this.nXQ = ((TextView)findViewById(2131301909));
    this.tgL = ((ViewGroup)findViewById(2131301903));
    this.sZz = ((MMScrollView)findViewById(2131301943));
    this.sZA = ((TextView)findViewById(2131301901));
    this.tpp = ((RelativeLayout)findViewById(2131301802));
    this.tpq = ((TextView)findViewById(2131301808));
    this.tpr = ((TextView)findViewById(2131307213));
    this.tps = ((ImageView)findViewById(2131301801));
    this.tpt = ((ImageView)findViewById(2131301800));
    this.tpu = ((ImageView)findViewById(2131301803));
    this.tpv = ((TextView)findViewById(2131301804));
    this.tlr = new a(this);
    this.tls = getLayoutInflater().inflate(2131494640, null);
    this.tlr.setContentView(this.tls, new ViewGroup.LayoutParams(-1, -1));
    this.tls.findViewById(2131301796).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65851);
        LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
        AppMethodBeat.o(65851);
      }
    });
    this.tlr.tjq = new a.a()
    {
      public final void cMh()
      {
        AppMethodBeat.i(65865);
        LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
        AppMethodBeat.o(65865);
      }
    };
    this.tlB = ((ViewGroup)this.tls.findViewById(2131301798));
    this.tlz = com.tencent.mm.pluginsdk.ui.chat.e.Cgj.es(getContext());
    this.tpB = getIntent().getStringExtra("key_username");
    this.tlz.setTalkerName(this.tpB);
    this.tlz.setShowSmiley(false);
    Object localObject1;
    Object localObject2;
    label565:
    Object localObject3;
    label650:
    label883:
    int i;
    if (this.mType == 1)
    {
      setMMTitle(2131760879);
      this.tgI.setTitle(getString(2131760978));
      this.tgI.setShowGroupIcon(true);
      localObject1 = new LinearLayout.LayoutParams(-1, -1);
      localObject2 = new LinearLayout.LayoutParams(-1, com.tencent.mm.cd.a.ao(this, 2131166515));
      if (this.mType != 1) {
        break label1356;
      }
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 13);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 13);
      this.sZv.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.tpp.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.tgI.setOnInputValidChangerListener(this);
      this.tgI.setHint(getString(2131760895));
      this.sZt.setOnInputValidChangerListener(this);
      this.sZt.setHint(getString(2131760911));
      this.sZv.setOnInputValidChangerListener(this);
      if (!com.tencent.mm.ui.ai.Eq()) {
        break label1386;
      }
      this.tpu.setImageResource(2131233108);
      localObject1 = (EditText)this.tgI.findViewById(2131301810);
      localObject2 = (EditText)this.sZt.findViewById(2131301810);
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(65837);
          String str = paramAnonymousEditable.toString();
          int i;
          int j;
          if (str.startsWith("."))
          {
            paramAnonymousEditable.insert(0, "0");
            str = paramAnonymousEditable.toString();
            i = str.indexOf(".");
            j = str.length();
            if ((i < 0) || (j - i <= 3)) {
              break label108;
            }
            paramAnonymousEditable.delete(i + 3, j);
          }
          for (;;)
          {
            this.val$hintTv.setContentDescription(paramAnonymousEditable.toString());
            AppMethodBeat.o(65837);
            return;
            if (!WalletFormView.a(str, this.val$hintTv)) {
              break;
            }
            AppMethodBeat.o(65837);
            return;
            label108:
            if (i > 6) {
              paramAnonymousEditable.delete(6, i);
            } else if ((i == -1) && (j > 6)) {
              paramAnonymousEditable.delete(6, j);
            }
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      ((EditText)localObject2).addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(65839);
          this.sZE.setContentDescription(paramAnonymousEditable.toString());
          AppMethodBeat.o(65839);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      ((EditText)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65840);
          this.val$hintTv.setOnClickListener(null);
          this.sZE.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ag(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ag(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
          LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          AppMethodBeat.o(65840);
        }
      });
      ((EditText)localObject1).requestFocus();
      localObject3 = (TextView)this.tgI.findViewById(2131301716);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65841);
            this.val$hintTv.setOnClickListener(null);
            this.sZE.setOnClickListener(null);
            LuckyMoneyPrepareUI.this.ag(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
            LuckyMoneyPrepareUI.this.ag(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
            LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(this.val$hintTv);
            LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
            AppMethodBeat.o(65841);
          }
        });
      }
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65842);
          this.val$hintTv.setOnClickListener(null);
          this.sZE.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ag(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ag(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
          LuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          AppMethodBeat.o(65842);
        }
      });
      ((MMEditText)this.sZv.findViewById(2131301944)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(65843);
          this.val$hintTv.setOnClickListener(null);
          this.sZE.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ag(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ag(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(65843);
        }
      });
      if (this.sYI != null)
      {
        if (this.mType != 1) {
          break label1399;
        }
        this.tgI.setMaxAmount(this.sYI.sYh);
        this.tgI.setMinAmount(this.sYI.sYg);
        if (this.sYI.nTT != 1) {
          afy(this.sYI.sYk);
        }
      }
      if ((!this.tgP) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1416;
      }
      this.sZt.setNum("1");
      label951:
      this.sZt.setMaxNum(this.sYI.sYe);
      this.sZt.setMinNum(1);
      ad.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.sZt.getInput());
      this.tgI.setMaxLen(12);
      if (cMN()) {
        this.sZw.setText(getString(2131760935, new Object[] { this.sYI.tdd }));
      }
      if ((!this.tgP) && (this.fsv != 2)) {
        break label1874;
      }
      if (!cMN()) {
        break label1428;
      }
      setMMTitle(getString(2131760976, new Object[] { this.sYI.tdd }));
      label1093:
      i = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.tgP) || (i != 0)) {
        break label1438;
      }
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
      this.sZt.setVisibility(8);
    }
    for (;;)
    {
      this.sZw.setOnClickListener(new v()
      {
        public final void bOU()
        {
          AppMethodBeat.i(65880);
          LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new br());
          LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).dMW = 6L;
          LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aBj();
          LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this);
          AppMethodBeat.o(65880);
        }
      });
      this.sZC.a(this.sZt);
      this.sZC.a(this.tgI);
      this.sZC.a(this.sZv);
      localObject1 = (TextView)findViewById(2131301898);
      this.sZC.n((TextView)localObject1);
      this.irp = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(65881);
          int i;
          double d2;
          if ((LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).cKY() != 3) && (LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).cKY() != 3))
          {
            i = LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).getInput();
            d2 = LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).getInput();
            d1 = d2;
            if (LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this) != 0) {}
          }
          for (double d1 = d2 * i;; d1 = 0.0D)
          {
            if ((d1 == 0.0D) || (d1 > LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).sYh) || (LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).cMx()))
            {
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setClickable(false);
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setEnabled(false);
            }
            for (;;)
            {
              ad.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).cMx());
              LuckyMoneyPrepareUI.l(LuckyMoneyPrepareUI.this).eFX();
              AppMethodBeat.o(65881);
              return false;
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setClickable(true);
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setEnabled(true);
            }
          }
        }
      }, false);
      if (this.sZz != null) {
        this.sZz.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(65828);
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              LuckyMoneyPrepareUI.this.hideTenpayKB();
              LuckyMoneyPrepareUI.this.hideVKB();
            }
            AppMethodBeat.o(65828);
            return false;
          }
        });
      }
      this.tgI.setType(this.mType);
      init();
      final boolean bool = com.tencent.mm.z.c.adr().a(ae.a.Fsg, ae.a.Fsi);
      this.tpp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(65834);
          ad.d("MicroMsg.LuckyMoneyPrepareUI", "click envelope layout: %s", new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this)) });
          if (LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this) == 0)
          {
            LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null, false, bool);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.vKh;
            if (!bool) {
              break label171;
            }
          }
          label171:
          for (int i = 2;; i = 1)
          {
            paramAnonymousView.f(18890, new Object[] { Integer.valueOf(2), Integer.valueOf(i), LuckyMoneyPrepareUI.x(LuckyMoneyPrepareUI.this) });
            com.tencent.mm.plugin.report.service.h.vKh.f(16822, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(65834);
            return;
            paramAnonymousView = z.fr(LuckyMoneyPrepareUI.this.getContext());
            com.tencent.mm.plugin.luckymoney.model.g localg = com.tencent.mm.plugin.luckymoney.model.g.cLo();
            localg.b(new com.tencent.mm.plugin.luckymoney.model.c(""));
            localg.a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
            break;
          }
        }
      });
      if (bool) {
        this.tpv.setVisibility(0);
      }
      if (this.tdg != null) {
        b(this.tdg.tcN);
      }
      AppMethodBeat.o(65886);
      return;
      setMMTitle(2131760909);
      this.tgI.setTitle(getString(2131760979));
      this.tgI.setShowGroupIcon(false);
      break;
      label1356:
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
      break label565;
      label1386:
      this.tpu.setImageResource(2131233107);
      break label650;
      label1399:
      this.tgI.setMaxAmount(this.sYI.sYf);
      break label883;
      label1416:
      this.sZt.setNum("");
      break label951;
      label1428:
      setMMTitle(2131760975);
      break label1093;
      label1438:
      localObject2 = getString(2131760867);
      Object localObject4 = getString(2131760882);
      localObject1 = getString(2131760861);
      localObject3 = getString(2131760883);
      Object localObject5;
      if ((this.tgP) && (i > 0))
      {
        ad.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", new Object[] { Integer.valueOf(i) });
        localObject2 = getString(2131760885);
        localObject1 = getString(2131760884);
        localObject5 = (TextView)findViewById(2131301902);
        ((TextView)localObject5).setText(getString(2131760910, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) }));
        ((TextView)localObject5).setVisibility(0);
      }
      for (;;)
      {
        localObject5 = new com.tencent.mm.plugin.wallet_core.ui.l(this);
        ((com.tencent.mm.plugin.wallet_core.ui.l)localObject5).mColor = getResources().getColor(2131100599);
        final SpannableString localSpannableString = new SpannableString((String)localObject2 + (String)localObject4);
        localSpannableString.setSpan(localObject5, ((String)localObject2).length(), ((String)localObject2).length() + ((String)localObject4).length(), 33);
        localObject2 = new SpannableString((String)localObject1 + (String)localObject3);
        localObject4 = new com.tencent.mm.plugin.wallet_core.ui.l(this);
        ((com.tencent.mm.plugin.wallet_core.ui.l)localObject4).mColor = getResources().getColor(2131100599);
        ((SpannableString)localObject2).setSpan(localObject4, ((String)localObject1).length(), ((String)localObject1).length() + ((String)localObject3).length(), 33);
        this.tgI.setGroupIconIv(2131233029);
        ((com.tencent.mm.plugin.wallet_core.ui.l)localObject5).Anf = new l.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65877);
            int i = LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).getInput();
            double d = LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).getInput();
            LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 0);
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setType(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this));
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setShowGroupIcon(false);
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setTitle(LuckyMoneyPrepareUI.this.getString(2131760979));
            if ((d > 0.0D) && (i > 0)) {
              LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setAmount(com.tencent.mm.wallet_core.ui.e.D(d / i));
            }
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setMaxAmount(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).sYf);
            LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this).setText(this.sZI);
            com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
            AppMethodBeat.o(65877);
          }
        };
        ((com.tencent.mm.plugin.wallet_core.ui.l)localObject4).Anf = new l.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65878);
            int i = LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).getInput();
            double d = LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).getInput();
            LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 1);
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setType(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this));
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setMaxAmount(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).sYh);
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setTitle(LuckyMoneyPrepareUI.this.getString(2131760978));
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setShowGroupIcon(true);
            if ((d > 0.0D) && (i > 0)) {
              LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setAmount(com.tencent.mm.wallet_core.ui.e.D(d * i));
            }
            LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this).setText(localSpannableString);
            com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
            AppMethodBeat.o(65878);
          }
        };
        this.lln.setMovementMethod(LinkMovementMethod.getInstance());
        if (com.tencent.mm.ui.a.a.a.eSf().eSe()) {
          this.lln.setOnClickListener(new LuckyMoneyPrepareUI.43(this, localSpannableString, (com.tencent.mm.plugin.wallet_core.ui.l)localObject5, (com.tencent.mm.plugin.wallet_core.ui.l)localObject4));
        }
        this.lln.setTextColor(getResources().getColor(2131100021));
        this.lln.setText(localSpannableString);
        this.lln.setVisibility(0);
        break;
        if (this.fsv == 2)
        {
          ad.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
          this.sZv.setVisibility(8);
        }
      }
      label1874:
      if (this.mType == 1)
      {
        this.lln.setText(this.sYI.tcZ);
        this.lln.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.lln.setText(this.sYI.tda);
        this.lln.setVisibility(0);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(65900);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(65900);
      return;
      if ((paramIntent != null) && (paramIntent.hasExtra("key_realname_guide_helper"))) {
        this.tpz = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
      }
      Object localObject1;
      if (paramInt2 == -1)
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cLP()), Integer.valueOf(5) });
        localObject1 = getIntent().getStringExtra("key_username");
        if ((this.tgP) && (!bt.isNullOrNil((String)localObject1)))
        {
          Object localObject2 = bw.K(this.tgQ, "msg");
          if (localObject2 == null)
          {
            ad.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65900);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.cKP().cKS().afm((String)localObject2))
          {
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!z.V(this.tgQ, (String)localObject1, 1))
            {
              ad.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.cKP().cKS().afn((String)localObject2);
            }
            label297:
            g(paramInt2, paramIntent);
            this.tpC = new bs();
            this.tpC.dPU = this.tnK;
            if (this.oBl != null) {
              break label425;
            }
            localObject1 = "";
            label337:
            this.tpC.ip((String)localObject1);
            this.tpC.aBj();
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.tnK), localObject1 });
            finish();
          }
        }
        for (;;)
        {
          localObject1 = "";
          if (paramIntent != null) {
            localObject1 = paramIntent.getStringExtra("key_trans_id");
          }
          afz((String)localObject1);
          break;
          ad.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          break label297;
          label425:
          localObject1 = this.oBl.JS();
          break label337;
          cMm();
          localObject1 = findViewById(2131301906);
          this.tgJ.setVisibility(0);
          z.a((View)localObject1, null);
          this.oHj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65864);
              com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
              z.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.G(LuckyMoneyPrepareUI.this), true);
              LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(65863);
                  LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
                  LuckyMoneyPrepareUI.this.cMl();
                  AppMethodBeat.o(65863);
                }
              }, 100L);
              AppMethodBeat.o(65864);
            }
          });
          ((ImageView)findViewById(2131301897)).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65866);
              LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
              LuckyMoneyPrepareUI.this.cMl();
              AppMethodBeat.o(65866);
            }
          });
          g(paramInt2, paramIntent);
        }
      }
      if (com.tencent.mm.wallet_core.c.ag.bq(paramIntent))
      {
        finish();
        AppMethodBeat.o(65900);
        return;
      }
      if (com.tencent.mm.wallet_core.c.ag.br(paramIntent))
      {
        AppMethodBeat.o(65900);
        return;
      }
      g(paramInt2, paramIntent);
      continue;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cLP()), Integer.valueOf(7), localObject1 });
        if (!bt.isNullOrNil((String)localObject1)) {
          doSceneProgress(new at(((String)localObject1).replaceAll(",", "|"), this.tgN, "v1.0"));
        } else {
          finish();
        }
      }
      else if (paramInt2 == 0)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(getContext(), LuckyMoneyMyRecordUI.class);
        ((Intent)localObject1).putExtra("key_type", 1);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        if ((paramIntent != null) && (paramIntent.hasExtra("result_data")))
        {
          localObject1 = paramIntent.getBundleExtra("result_data");
          if (localObject1 != null)
          {
            int i = bt.getInt(((Bundle)localObject1).getString("payState", "2"), 0);
            ad.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i + ";STATE_H5_PAY_SUCC=0");
            if (i == 0) {
              finish();
            }
          }
          else
          {
            ad.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
            continue;
            h(paramInt2, paramIntent);
            continue;
            if (paramInt2 == -1)
            {
              this.tgL.removeAllViews();
              mS(true);
            }
            else
            {
              mS(false);
              com.tencent.mm.plugin.report.service.h.vKh.f(16822, new Object[] { Integer.valueOf(2) });
              continue;
              if (paramInt2 == -1)
              {
                localObject1 = "";
                if (paramIntent != null) {
                  localObject1 = paramIntent.getStringExtra("gif_md5");
                }
                if (!bt.isNullOrNil((String)localObject1))
                {
                  this.oBl = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.aJx((String)localObject1);
                  A(this.oBl);
                }
                else
                {
                  ad.i("MicroMsg.LuckyMoneyPrepareUI", "md5 == null go emoji capture failed!");
                }
              }
              else
              {
                ad.i("MicroMsg.LuckyMoneyPrepareUI", "go emoji capture failed!");
              }
            }
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(65887);
    finish();
    AppMethodBeat.o(65887);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65883);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131100587));
    setActionbarElementColor(getResources().getColor(2131099732));
    hideActionbarLine();
    this.mType = getIntent().getIntExtra("key_type", 1);
    this.tgM = getIntent().getIntExtra("key_way", 3);
    this.fsv = getIntent().getIntExtra("key_from", 0);
    if (this.fsv == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.tgP = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      this.mSessionId = getIntent().getStringExtra("key_session_id");
      mS(false);
      com.tencent.mm.plugin.luckymoney.b.a.cKP();
      this.sYI = com.tencent.mm.plugin.luckymoney.b.a.cKQ().cLt();
      com.tencent.mm.plugin.luckymoney.b.a.cKP();
      this.tdg = com.tencent.mm.plugin.luckymoney.b.a.cKQ().cLu();
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.tgM + "mChannel:" + this.mChannel);
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.tgP + ", config " + this.sYI);
      initView();
      com.tencent.mm.sdk.b.a.ESL.b(this.tpS);
      this.mPayLoopInterruptListener.alive();
      com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cLP()), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.b.fjk();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.pom, true);
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.fnl();
      AppMethodBeat.o(65883);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65893);
    super.onDestroy();
    this.sZC.clear();
    this.irp.eFX();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.tlz != null)
    {
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "commentfooter release");
      this.tlz.onPause();
      this.tlz.exm();
      this.tlz.destroy();
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.tpS);
    this.mPayLoopInterruptListener.dead();
    AppMethodBeat.o(65893);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65904);
    if ((paramInt == 4) && (this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      AppMethodBeat.o(65904);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(65904);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65884);
    super.onResume();
    addSceneEndListener(1970);
    AppMethodBeat.o(65884);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(65896);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.aq))
    {
      if (this.tpR)
      {
        ad.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
        AppMethodBeat.o(65896);
        return true;
      }
      com.tencent.mm.plugin.luckymoney.model.aq localaq = (com.tencent.mm.plugin.luckymoney.model.aq)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_HONGBAO_PAY_SWTICH_KEY"))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (paramInt1 == 0)) {
            this.tipDialog.dismiss();
          }
          this.tgO = localaq.nTB;
          this.tgN = localaq.sZn;
          this.tgQ = localaq.tfE;
          this.tka = localaq.sZn;
          this.tpA = localaq.tfK;
          if (!((com.tencent.mm.plugin.luckymoney.model.aq)paramn).isJumpRemind()) {
            break;
          }
          ad.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() NetScenePrepareLuckyMoney show JumpRemind Alert");
          ((com.tencent.mm.plugin.luckymoney.model.aq)paramn).jumpRemind.a(this, new com.tencent.mm.wallet_core.c.h()
          {
            public final void bm(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(65848);
              ad.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onNext()");
              if ((bt.iY(paramAnonymousInt, 2)) && (bt.kU(paramAnonymousString, "requestwxhb")))
              {
                LuckyMoneyPrepareUI.z(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(65848);
                return;
              }
              if (bt.iY(paramAnonymousInt, 1)) {
                com.tencent.mm.plugin.account.a.b.a.b(LuckyMoneyPrepareUI.this, paramAnonymousString, 0, true);
              }
              AppMethodBeat.o(65848);
            }
            
            public final void onCancel()
            {
              AppMethodBeat.i(65849);
              ad.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onCancel()");
              AppMethodBeat.o(65849);
            }
          });
          AppMethodBeat.o(65896);
          return true;
        }
        paramString = new PayInfo();
        paramString.dcE = localaq.rcq;
        paramString.dtb = 37;
        paramString.channel = this.mChannel;
        if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_HONGBAO_PAY_SWTICH_KEY"))) {
          ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, paramString);
        }
        for (;;)
        {
          AppMethodBeat.o(65896);
          return true;
          com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, 1);
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if (paramInt2 == 401)
      {
        this.sZw.setEnabled(false);
        this.sZw.setClickable(false);
        this.irp.av(5000L, 5000L);
        com.tencent.mm.ui.base.h.cf(this, paramString);
        AppMethodBeat.o(65896);
        return true;
      }
      if (paramInt2 == 268502454)
      {
        com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(65850);
            if (com.tencent.mm.plugin.luckymoney.model.aq.k(paramn))
            {
              LuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(65850);
              return;
            }
            AppMethodBeat.o(65850);
          }
        });
        AppMethodBeat.o(65896);
        return true;
      }
      this.dvA = 2;
      paramn = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramn = getString(2131765901);
      }
      com.tencent.mm.ui.base.h.a(this, paramn, null, false, new LuckyMoneyPrepareUI.18(this));
      AppMethodBeat.o(65896);
      return true;
    }
    if ((paramn instanceof at))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.tgP)
        {
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
          com.tencent.mm.sdk.platformtools.aq.n(new LuckyMoneyPrepareUI.23(this), 1800L);
        }
        for (;;)
        {
          AppMethodBeat.o(65896);
          return true;
          cMm();
          this.tgK.setVisibility(0);
          this.tgK.postDelayed(new LuckyMoneyPrepareUI.24(this), 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.d(getContext(), paramString, "", getString(2131760958), getString(2131755691), new LuckyMoneyPrepareUI.25(this), new LuckyMoneyPrepareUI.26(this));
        AppMethodBeat.o(65896);
        return true;
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.ai))
      {
        ad.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString);
        if ((this.tpn != null) && (this.tpn.isShowing())) {
          this.tpn.dismiss();
        }
        if ((this.tpo != null) && (this.tpo.isShowing())) {
          this.tpo.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.luckymoney.model.ai)paramn;
          this.tpO = true;
          this.tft = paramString.tft;
          if (!bt.iY(paramString.tfu, 1))
          {
            this.sZv.mT(true);
            com.tencent.mm.plugin.luckymoney.b.a.cKP();
            this.sYI = com.tencent.mm.plugin.luckymoney.b.a.cKQ().cLt();
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.sYI);
            if (this.mType != 1) {
              break label1492;
            }
            this.tgI.setMaxAmount(this.sYI.sYh);
            label867:
            this.tgI.setMinAmount(this.sYI.sYg);
            this.sZt.setMaxNum(this.sYI.sYe);
            this.tpx = paramString.sYj;
            this.tpw = paramString.nTT;
            this.tpy = paramString.sYt;
            if (bt.isNullOrNil(this.tnR)) {
              this.tnR = paramString.drI;
            }
            if ((!bt.isNullOrNil(this.tpy)) && (this.sZv != null)) {
              com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(65858);
                  LuckyMoneyPrepareUI.D(LuckyMoneyPrepareUI.this).setHintText(LuckyMoneyPrepareUI.E(LuckyMoneyPrepareUI.this));
                  AppMethodBeat.o(65858);
                }
              });
            }
            if ((paramString.tfk) && (this.tgP))
            {
              paramn = (TextView)findViewById(2131301899);
              paramn.setOnClickListener(new LuckyMoneyPrepareUI.29(this));
              com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cLP()), Integer.valueOf(8) });
              paramn.setVisibility(8);
            }
            if (bt.isNullOrNil(paramString.iau)) {
              break label1509;
            }
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.iau);
            this.sZA.setText(paramString.iau);
            if (!bt.isNullOrNil(paramString.tfm)) {
              this.sZA.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(65860);
                  com.tencent.mm.wallet_core.ui.e.p(LuckyMoneyPrepareUI.this.getContext(), paramString.tfm, false);
                  AppMethodBeat.o(65860);
                }
              });
            }
            this.sZA.setVisibility(0);
            label1144:
            paramn = new h.c();
            if ((paramString.tfo == null) || (bt.isNullOrNil(paramString.tfo.content))) {
              break label1521;
            }
            paramn.textColor = getResources().getColor(2131101114);
            label1188:
            this.tgL.removeAllViews();
            h.a(this, this.tgL, paramString.tfo, paramn);
            afy(paramString.sYk);
            if (this.tpw == 1) {
              break label1539;
            }
            b(this.tgI.getInput(), this.tpx);
            label1240:
            com.tencent.mm.plugin.luckymoney.b.a.cKP();
            this.tdg = com.tencent.mm.plugin.luckymoney.b.a.cKQ().cLu();
            init();
            if (this.tdg == null) {
              break label1565;
            }
            if (this.tdg.tcN != null)
            {
              this.tpD = this.tdg.tcN.DDu;
              this.tpE = this.tdg.tcN.DDs;
              this.tpF = this.tdg.tcN.DDt;
            }
            b(this.tdg.tcN);
            com.tencent.mm.plugin.report.service.h.vKh.dB(991, 10);
            label1339:
            if (this.tpQ)
            {
              ad.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick()");
              a(this.tpH, this.tpI, this.tpJ, this.tpK, this.tpL, this.tpM);
            }
          }
        }
        for (;;)
        {
          ad.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig waitingGetConfig:%s ifAutoRMBPrePareBtn:%s", new Object[] { Boolean.valueOf(this.tpP), Boolean.valueOf(this.tpQ) });
          this.tpP = false;
          this.tpQ = false;
          AppMethodBeat.o(65896);
          return true;
          this.sZv.mT(false);
          if ((this.oBl != null) && (!bt.isNullOrNil(this.oBl.JS()))) {
            this.sZv.A(this.oBl);
          }
          this.sZv.setmOnEmojiSelectClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65857);
              LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new br());
              LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).dMW = 2L;
              LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aBj();
              final boolean bool = bt.I(paramAnonymousView.getTag(), "delete");
              if ((!bool) && (!bt.iY(paramString.tft, 1)))
              {
                LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, 2);
                LuckyMoneyPrepareUI.A(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(65857);
                return;
              }
              paramAnonymousView = new com.tencent.mm.ui.widget.d(LuckyMoneyPrepareUI.this.getContext(), 1, false);
              paramAnonymousView.HrX = new n.c()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(65855);
                  if (!bool)
                  {
                    if (bt.iY(LuckyMoneyPrepareUI.27.this.tgS.tft, 1)) {
                      paramAnonymous2l.jj(1, 2131760908);
                    }
                    paramAnonymous2l.jj(2, 2131760952);
                    AppMethodBeat.o(65855);
                    return;
                  }
                  paramAnonymous2l.a(3, LuckyMoneyPrepareUI.this.getResources().getColor(2131100596), LuckyMoneyPrepareUI.this.getContext().getString(2131760844));
                  AppMethodBeat.o(65855);
                }
              };
              paramAnonymousView.HrY = new n.d()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(65856);
                  ad.i("MicroMsg.LuckyMoneyPrepareUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(65856);
                    return;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, 1);
                    com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyPrepareUI.this, 4, LuckyMoneyPrepareUI.B(LuckyMoneyPrepareUI.this));
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new br());
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).dMW = 4L;
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aBj();
                    AppMethodBeat.o(65856);
                    return;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, 2);
                    LuckyMoneyPrepareUI.A(LuckyMoneyPrepareUI.this);
                    AppMethodBeat.o(65856);
                    return;
                    LuckyMoneyPrepareUI.C(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem = LuckyMoneyPrepareUI.D(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem.tqj.setTag("");
                    paramAnonymous2MenuItem.tqk.setVisibility(0);
                    paramAnonymous2MenuItem.tql.setVisibility(8);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new br());
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).dMW = 5L;
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aBj();
                  }
                }
              };
              paramAnonymousView.csG();
              AppMethodBeat.o(65857);
            }
          });
          break;
          label1492:
          this.tgI.setMaxAmount(this.sYI.sYf);
          break label867;
          label1509:
          this.sZA.setVisibility(8);
          break label1144;
          label1521:
          paramn.textColor = getResources().getColor(2131100482);
          break label1188;
          label1539:
          if (this.mType != 1) {
            break label1240;
          }
          b(this.tgI.getInput(), this.tpx);
          break label1240;
          label1565:
          b(null);
          break label1339;
          if (this.tpQ)
          {
            paramn = paramString;
            if (bt.isNullOrNil(paramString)) {
              paramn = getString(2131755733);
            }
            t.makeText(this, paramn, 0).show();
          }
        }
      }
      if ((paramn instanceof aj))
      {
        removeSceneEndListener(1647);
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((aj)paramn).nUe;
          if (!bt.isNullOrNil(paramString))
          {
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
            com.tencent.mm.wallet_core.ui.e.a(getContext(), paramString, false, 3);
          }
          for (;;)
          {
            AppMethodBeat.o(65896);
            return true;
            ad.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
          }
        }
      }
      else
      {
        if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.d))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0)) {
            if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_F2F_HONGBAO_PAY_SWTICH_KEY")))
            {
              paramInt1 = 1;
              if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (paramInt1 == 0)) {
                this.tipDialog.dismiss();
              }
              this.tka = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn).sZn;
              this.tpA = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn).taG;
              paramString = new PayInfo();
              paramString.dcE = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn).dcE;
              paramString.dtb = 37;
              if ((!this.mKindaEnable) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_F2F_HONGBAO_PAY_SWTICH_KEY"))) {
                break label1922;
              }
              if (paramString.Cos == null) {
                paramString.Cos = new Bundle();
              }
              paramString.Cos.putBoolean("isF2FHongBao", true);
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, paramString);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(65896);
            return true;
            paramInt1 = 0;
            break;
            label1922:
            af.v(37, paramString.dcE, paramInt2);
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, 4);
            continue;
            af.v(37, "", paramInt2);
            if (!bt.isNullOrNil(paramString)) {
              com.tencent.mm.ui.base.h.c(this, paramString, getString(2131760832), true);
            }
            this.tipDialog.dismiss();
          }
        }
        if ((paramn instanceof an))
        {
          AppMethodBeat.o(65896);
          return true;
        }
      }
    }
    AppMethodBeat.o(65896);
    return false;
  }
  
  public void onStop()
  {
    AppMethodBeat.i(65885);
    super.onStop();
    removeSceneEndListener(1970);
    AppMethodBeat.o(65885);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */