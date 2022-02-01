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
import android.text.SpannableString;
import android.text.TextUtils;
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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.p;
import com.tencent.mm.api.z.a;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.tc;
import com.tencent.mm.g.b.a.df;
import com.tencent.mm.g.b.a.dg;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.luckymoney.model.ab;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements g
{
  private int dtm;
  private int fwc;
  private com.tencent.mm.sdk.platformtools.au iRv;
  private TextView lLe;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private boolean mKindaEnable;
  private com.tencent.mm.sdk.b.c<og> mPayLoopInterruptListener;
  private String mSessionId;
  private int mType;
  private TextView oBl;
  private EmojiInfo peL;
  private Button pkJ;
  public Dialog tipDialog;
  private j ugW;
  private LuckyMoneyNumInputView uhH;
  private LuckyMoneyTextInputView uhJ;
  private Button uhK;
  private MMScrollView uhN;
  private TextView uhO;
  private b uhQ;
  private com.tencent.mm.plugin.luckymoney.model.e ulv;
  private int unI;
  private LuckyMoneyMoneyInputView uoX;
  private View uoY;
  private View uoZ;
  private ViewGroup upa;
  private int upb;
  private String upc;
  private int upd;
  private boolean upe;
  private String upf;
  private String ust;
  private a utK;
  private View utL;
  private ChatFooterPanel utS;
  private ViewGroup utU;
  private df utW;
  private int utZ;
  private int uwd;
  private String uwk;
  private String uwn;
  private Dialog uxF;
  private Dialog uxG;
  private RelativeLayout uxH;
  private TextView uxI;
  private TextView uxJ;
  private ImageView uxK;
  private ImageView uxL;
  private ImageView uxM;
  private TextView uxN;
  private int uxO;
  private String uxP;
  private String uxQ;
  private RealnameGuideHelper uxR;
  private String uxS;
  private String uxT;
  private dg uxU;
  private int uxV;
  private String uxW;
  private String uxX;
  private boolean uxY;
  private int uxZ;
  private String uya;
  private int uyb;
  private long uyc;
  private long uyd;
  private String uye;
  private com.tencent.mm.ui.widget.d uyf;
  private boolean uyg;
  private boolean uyh;
  private boolean uyi;
  private boolean uyj;
  private com.tencent.mm.sdk.b.c<tc> uyk;
  
  public LuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65882);
    this.uhH = null;
    this.uoX = null;
    this.uhJ = null;
    this.oBl = null;
    this.uhK = null;
    this.pkJ = null;
    this.tipDialog = null;
    this.uxF = null;
    this.uxG = null;
    this.uhQ = new b();
    this.iRv = null;
    this.uxO = 1;
    this.uxP = com.tencent.mm.wallet_core.ui.e.aSG("CNY");
    this.uxQ = null;
    this.ust = "";
    this.uwd = 1;
    this.utZ = 0;
    this.uxY = false;
    this.mPayLoopInterruptListener = new com.tencent.mm.sdk.b.c() {};
    this.uyg = false;
    this.uyh = false;
    this.uyi = false;
    this.uyj = false;
    this.uyk = new com.tencent.mm.sdk.b.c() {};
    this.dtm = 0;
    this.uwn = "";
    AppMethodBeat.o(65882);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65897);
    this.uhJ.A(paramEmojiInfo);
    if ((this.utZ == 0) || (this.utZ == 2)) {
      if (com.tencent.mm.plugin.emoji.h.b.y(paramEmojiInfo)) {
        this.uwd = 2;
      }
    }
    for (;;)
    {
      this.utW = new df();
      this.utW.dNx = 1L;
      this.utW.aHZ();
      AppMethodBeat.o(65897);
      return;
      if (com.tencent.mm.plugin.emoji.h.b.w(paramEmojiInfo))
      {
        this.uwd = 4;
      }
      else
      {
        this.uwd = 3;
        continue;
        if (this.utZ == 1) {
          this.uwd = 2;
        }
      }
    }
  }
  
  private void Id(int paramInt)
  {
    AppMethodBeat.i(65888);
    ac.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() userConfirmJump:%s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cZv()), Integer.valueOf(4) });
    com.tencent.mm.plugin.report.service.h.wUl.f(15511, new Object[] { Integer.valueOf(this.uxO), Integer.valueOf(2) });
    if (this.uoX.cYE() != 0)
    {
      t.makeText(getContext(), 2131765031, 0).show();
      AppMethodBeat.o(65888);
      return;
    }
    int i = this.uhH.getInput();
    double d = this.uoX.getInput();
    long l2 = 0L;
    long l1;
    if (this.mType == 1)
    {
      l1 = com.tencent.mm.wallet_core.ui.e.E(d);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(356354, Integer.valueOf(i));
      str = this.uhJ.getInput().replace("\r", "").replace("\n", "");
      localObject = str;
      if (bs.isNullOrNil(str)) {
        if (!bs.isNullOrNil(this.uxQ)) {
          break label336;
        }
      }
    }
    label336:
    for (Object localObject = getString(2131760843);; localObject = this.uxQ)
    {
      hideTenpayKB();
      if (this.fwc != 2) {
        break label345;
      }
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.d(i, (int)l1, this.mType, (int)l2), false);
      das();
      AppMethodBeat.o(65888);
      return;
      l1 = com.tencent.mm.wallet_core.ui.e.E(i * d);
      l2 = com.tencent.mm.wallet_core.ui.e.E(d);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(356353, Integer.valueOf(i));
      break;
    }
    label345:
    String str = getIntent().getStringExtra("key_username");
    if (this.uxO == 1)
    {
      ac.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() ifGetConfig=%s mUniqueId=%s waitingGetConfig=%s ifAutoRMBPrePareBtn=%s", new Object[] { Boolean.valueOf(this.uyg), bs.nullAsNil(this.uwk), Boolean.valueOf(this.uyh), Boolean.valueOf(this.uyi) });
      if (this.uyg)
      {
        a(paramInt, str, i, l1, l2, (String)localObject);
        AppMethodBeat.o(65888);
        return;
      }
      this.uyi = true;
      this.uxZ = paramInt;
      this.uya = str;
      this.uyb = i;
      this.uyc = l1;
      this.uyd = l2;
      this.uye = ((String)localObject);
      if (this.uxG != null) {
        this.uxG.show();
      }
      for (;;)
      {
        if (!this.uyh) {
          nK(false);
        }
        AppMethodBeat.o(65888);
        return;
        this.uxG = com.tencent.mm.ui.base.h.a(this, 3, 2131820985, getString(2131760709), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(65829);
            ac.i("MicroMsg.LuckyMoneyPrepareUI", "coperationTipDialogNoTransparent onCancel()");
            LuckyMoneyPrepareUI.m(LuckyMoneyPrepareUI.this);
            LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this);
            if ((LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this) != null) && (LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this).isShowing())) {
              LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this).dismiss();
            }
            if ((LuckyMoneyPrepareUI.p(LuckyMoneyPrepareUI.this).getVisibility() == 8) || (LuckyMoneyPrepareUI.q(LuckyMoneyPrepareUI.this).getVisibility() == 4))
            {
              ac.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
              LuckyMoneyPrepareUI.this.finish();
            }
            LuckyMoneyPrepareUI.this.usr.forceCancel();
            AppMethodBeat.o(65829);
          }
        });
      }
    }
    ac.i("MicroMsg.LuckyMoneyPrepareUI", "currency=%s userConfiremJump:%s", new Object[] { Integer.valueOf(this.uxO), Integer.valueOf(paramInt) });
    addSceneEndListener(1647);
    if ((this.upe) && (!bs.isNullOrNil(str))) {}
    for (localObject = new com.tencent.mm.plugin.luckymoney.model.aj(i, l1, l2, this.mType, (String)localObject, str, z.cZe(), com.tencent.mm.model.u.axw(), this.uxO);; localObject = new com.tencent.mm.plugin.luckymoney.model.aj(i, l1, l2, this.mType, (String)localObject, null, z.cZe(), com.tencent.mm.model.u.axw(), this.uxO))
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
    if (this.peL != null)
    {
      str2 = this.peL.JC();
      i = this.peL.field_type;
    }
    String str1 = "";
    if (this.ulv != null) {
      str1 = this.ulv.uld;
    }
    ac.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB. userConfirmJump:%s lastPayResult:%s mSendId:%s mUniqueId:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.dtm), this.ust, this.uwk });
    if ((this.upe) && (!bs.isNullOrNil(paramString1))) {}
    for (paramString1 = new aq(paramInt2, paramLong1, paramLong2, this.mType, paramString2, z.cZe(), paramString1, z.wj(paramString1), com.tencent.mm.model.u.axw(), com.tencent.mm.model.u.axy(), this.upb, str1, this.uwk, paramInt1, this.dtm, this.ust, str2, i);; paramString1 = new aq(paramInt2, paramLong1, paramLong2, this.mType, paramString2, z.cZe(), null, null, com.tencent.mm.model.u.axw(), com.tencent.mm.model.u.axy(), this.upb, str1, this.uwk, paramInt1, this.dtm, this.ust, str2, i))
    {
      doSceneProgress(paramString1, false);
      if (!bs.isNullOrNil(str1)) {
        com.tencent.mm.plugin.report.service.h.wUl.dB(991, 11);
      }
      das();
      AppMethodBeat.o(65890);
      return;
    }
  }
  
  private void aks(String paramString)
  {
    AppMethodBeat.i(65898);
    ac.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=".concat(String.valueOf(paramString)));
    TextView localTextView = (TextView)findViewById(2131301716);
    if (!bs.isNullOrNil(paramString))
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(65898);
      return;
    }
    localTextView.setText(getString(2131760830));
    AppMethodBeat.o(65898);
  }
  
  private void akt(String paramString)
  {
    AppMethodBeat.i(65911);
    ac.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ag(this.ust, paramString, this.uxS), false);
    AppMethodBeat.o(65911);
  }
  
  private void b(double paramDouble, String paramString)
  {
    AppMethodBeat.i(65908);
    if (bs.isNullOrNil(paramString))
    {
      this.oBl.setText(com.tencent.mm.wallet_core.ui.e.D(paramDouble));
      AppMethodBeat.o(65908);
      return;
    }
    this.oBl.setText(paramString + com.tencent.mm.wallet_core.ui.e.C(paramDouble));
    AppMethodBeat.o(65908);
  }
  
  private void b(bjm parambjm)
  {
    AppMethodBeat.i(65892);
    ac.i("MicroMsg.LuckyMoneyPrepareUI", "update envelope");
    if ((this.ulv != null) && (parambjm != null) && (this.fwc != 2))
    {
      this.uxH.setVisibility(0);
      boolean bool = com.tencent.mm.y.c.aeH().a(ah.a.GPX, ah.a.GPZ);
      Object localObject;
      if (!this.uxY)
      {
        localObject = com.tencent.mm.plugin.report.service.h.wUl;
        if (!bool) {
          break label233;
        }
      }
      label233:
      for (int i = 2;; i = 1)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).f(18890, new Object[] { Integer.valueOf(1), Integer.valueOf(i), this.mSessionId });
        this.uxY = true;
        if ((!this.ulv.ule) || (bs.isNullOrNil(this.ulv.ulf))) {
          break label334;
        }
        localObject = bs.lp((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQb, ""), ",");
        Iterator localIterator = ((List)localObject).iterator();
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
        } while (!str.equals(this.ulv.ulc.Etc));
        ac.d("MicroMsg.LuckyMoneyPrepareUI", "has alert illegal: %s", new Object[] { str });
        AppMethodBeat.o(65892);
        return;
      }
      ((List)localObject).add(this.ulv.ulc.Etc);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQb, bs.n((List)localObject, ","));
      ac.i("MicroMsg.LuckyMoneyPrepareUI", "show alert illegal: %s", new Object[] { this.ulv.ulc.Etc });
      com.tencent.mm.ui.base.h.a(getContext(), this.ulv.ulf, "", getString(2131766205), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      label334:
      if ((parambjm == null) || (parambjm.cDF != 1)) {
        break label448;
      }
      this.uxH.setEnabled(false);
      if (!bs.isNullOrNil(parambjm.EYR)) {
        this.uxI.setText(parambjm.EYR);
      }
      this.uxK.setImageBitmap(null);
      this.uxL.setVisibility(8);
      this.uxI.setTextColor(getResources().getColor(2131099660));
    }
    for (;;)
    {
      if ((parambjm == null) || (parambjm.hhv != 2)) {
        break label581;
      }
      this.uxJ.setVisibility(0);
      AppMethodBeat.o(65892);
      return;
      this.uxH.setVisibility(8);
      break;
      label448:
      if ((parambjm != null) && (!bs.isNullOrNil(parambjm.EYC)))
      {
        this.uxH.setEnabled(true);
        this.uxI.setText(parambjm.EYC);
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.uxK, parambjm);
        this.uxL.setVisibility(0);
        this.uxI.setTextColor(getResources().getColor(2131100020));
      }
      else
      {
        this.uxH.setEnabled(true);
        this.uxK.setImageBitmap(null);
        this.uxI.setText("");
        this.uxL.setVisibility(0);
        this.uxI.setTextColor(getResources().getColor(2131100020));
      }
    }
    label581:
    this.uxJ.setVisibility(8);
    AppMethodBeat.o(65892);
  }
  
  private int cZv()
  {
    AppMethodBeat.i(65909);
    if (this.upe)
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
  
  private void das()
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
          ac.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
          LuckyMoneyPrepareUI.this.finish();
        }
        LuckyMoneyPrepareUI.this.usr.forceCancel();
        AppMethodBeat.o(65830);
      }
    });
    this.tipDialog.setCancelable(false);
    AppMethodBeat.o(65889);
  }
  
  private boolean dat()
  {
    AppMethodBeat.i(65907);
    if ((this.ugW != null) && (!bs.isNullOrNil(this.ugW.uls)))
    {
      AppMethodBeat.o(65907);
      return true;
    }
    AppMethodBeat.o(65907);
    return false;
  }
  
  private void h(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65899);
    String str1 = getIntent().getStringExtra("key_username");
    String str2 = com.tencent.mm.model.u.axw();
    if (paramInt == -1)
    {
      ac.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode == RESULT_OK");
      this.dtm = 1;
      this.uwn = "";
      paramIntent = new an(this.ust, this.uwk, 1, str2, bs.nullAsNil(str1));
      com.tencent.mm.kernel.g.agQ().ghe.a(paramIntent, 0);
      AppMethodBeat.o(65899);
      return;
    }
    if (paramIntent != null) {}
    for (this.dtm = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.dtm = 3)
    {
      this.uwn = this.ust;
      ac.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.dtm) });
      paramIntent = new an(this.ust, this.uwk, this.dtm, str2, bs.nullAsNil(str1));
      break;
      ac.i("MicroMsg.LuckyMoneyPrepareUI", "doNetSceneLuckyMoneyReport() data == null");
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(65891);
    if (this.uxO == 1)
    {
      addIconOptionMenu(0, 2131690603, new LuckyMoneyPrepareUI.5(this));
      AppMethodBeat.o(65891);
      return;
    }
    addIconOptionMenu(0, 2131233032, new LuckyMoneyPrepareUI.6(this));
    AppMethodBeat.o(65891);
  }
  
  private void nK(boolean paramBoolean)
  {
    AppMethodBeat.i(65894);
    ac.i("MicroMsg.LuckyMoneyPrepareUI", "do get config");
    if (paramBoolean) {
      this.uxF = z.fD(getContext());
    }
    this.uyh = true;
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQa, Integer.valueOf(0))).intValue();
    this.uxV = i;
    doSceneProgress(new ai("v1.0", i, (byte)0), false);
    AppMethodBeat.o(65894);
  }
  
  protected final void ah(final View paramView, final int paramInt)
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
      boolean cab = true;
      
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65872);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new ao().postDelayed(new Runnable()
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
        new ao().postDelayed(new Runnable()
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
              new ao().postDelayed(new Runnable()
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
  
  public final void cYF()
  {
    AppMethodBeat.i(65906);
    com.tencent.mm.plugin.luckymoney.b.a.cYv();
    this.ugW = com.tencent.mm.plugin.luckymoney.b.a.cYw().cYZ();
    int i;
    double d2;
    double d1;
    if ((this.uoX.cYE() != 3) && (this.uhH.cYE() != 3))
    {
      i = this.uhH.getInput();
      d2 = this.uoX.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.uoX.getInput();
      }
    }
    for (;;)
    {
      if (this.uhQ.dac())
      {
        ac.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
        this.uhK.setClickable(false);
        this.uhK.setEnabled(false);
        b(d2, this.uxP);
        AppMethodBeat.o(65906);
        return;
        if (i > 0) {
          d1 = this.uoX.getInput() / i;
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
            this.uhK.setClickable(false);
            this.uhK.setEnabled(false);
            break;
            if ((d2 > this.ugW.ugv) && (this.ugW.ugv > 0.0D))
            {
              this.uhQ.Qr(getString(2131760977, new Object[] { Math.round(this.ugW.ugv), bs.bG(this.ugW.ugy, "") }));
              bool2 = true;
              continue;
            }
            if (d1 <= 0.0D) {
              break label1033;
            }
            ac.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d1)));
            if (this.mType == 0)
            {
              if ((d1 <= this.ugW.ugt) || (this.ugW.ugt <= 0.0D)) {
                break label1027;
              }
              if (dat())
              {
                this.uhQ.Qr(getString(2131760923, new Object[] { this.ugW.uls, Math.round(this.ugW.ugt), bs.bG(this.ugW.ugy, "") }));
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            ac.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
            bool2 = bool1;
            if (!bool1)
            {
              if (this.mType != 0) {
                break label878;
              }
              bool2 = bool1;
              if (d1 < this.ugW.ugu)
              {
                if (!dat()) {
                  break label829;
                }
                this.uhQ.Qr(getString(2131760925, new Object[] { this.ugW.uls, com.tencent.mm.wallet_core.ui.e.C(this.ugW.ugu), bs.bG(this.ugW.ugy, "") }));
                label536:
                bool2 = true;
              }
            }
            label829:
            label878:
            do
            {
              ac.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
              break;
              this.uhQ.Qr(getString(2131760922, new Object[] { Math.round(this.ugW.ugt), bs.bG(this.ugW.ugy, "") }));
              break label408;
              if ((d1 <= this.ugW.ugw) || (this.ugW.ugw <= 0.0D)) {
                break label1027;
              }
              if ((this.ugW != null) && (!bs.isNullOrNil(this.ugW.uls))) {
                this.uhQ.Qr(getString(2131760923, new Object[] { this.ugW.uls, Math.round(this.ugW.ugw), bs.bG(this.ugW.ugy, "") }));
              }
              for (;;)
              {
                this.uhH.onError();
                this.uoX.onError();
                bool1 = true;
                break;
                this.uhQ.Qr(getString(2131760922, new Object[] { Math.round(this.ugW.ugw), bs.bG(this.ugW.ugy, "") }));
              }
              this.uhQ.Qr(getString(2131760924, new Object[] { com.tencent.mm.wallet_core.ui.e.C(this.ugW.ugu), bs.bG(this.ugW.ugy, "") }));
              break label536;
              bool2 = bool1;
            } while (d1 >= 0.01D);
            if (dat()) {
              this.uhQ.Qr(getString(2131760925, new Object[] { this.ugW.uls, "0.01", bs.bG(this.ugW.ugy, "") }));
            }
            for (;;)
            {
              this.uhH.onError();
              this.uoX.onError();
              bool2 = true;
              break;
              this.uhQ.Qr(getString(2131760924, new Object[] { "0.01", bs.bG(this.ugW.ugy, "") }));
            }
            this.uhK.setClickable(true);
            this.uhK.setEnabled(true);
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
    if ((paramKeyEvent.getKeyCode() == 4) && (this.uoY.getVisibility() == 0))
    {
      this.uoY.setVisibility(8);
      cZR();
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
    if (this.uxR != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_realname_guide_helper", this.uxR);
      com.tencent.mm.br.d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
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
    AppMethodBeat.i(65901);
    if (paramInt == -1)
    {
      String str = "";
      if (paramIntent != null) {
        str = paramIntent.getStringExtra("key_trans_id");
      }
      akt(str);
    }
    finish();
    AppMethodBeat.o(65901);
  }
  
  public void initView()
  {
    AppMethodBeat.i(65886);
    setBackBtn(new LuckyMoneyPrepareUI.12(this));
    this.uoY = findViewById(2131301905);
    this.uoZ = findViewById(2131301908);
    this.pkJ = ((Button)findViewById(2131301907));
    this.uhJ = ((LuckyMoneyTextInputView)findViewById(2131301959));
    this.uhJ.setHintText(getString(2131760843));
    this.uhK = ((Button)findViewById(2131301896));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    this.lLe = ((TextView)findViewById(2131301894));
    this.uhH = ((LuckyMoneyNumInputView)findViewById(2131301891));
    this.uoX = ((LuckyMoneyMoneyInputView)findViewById(2131301715));
    this.oBl = ((TextView)findViewById(2131301909));
    this.upa = ((ViewGroup)findViewById(2131301903));
    this.uhN = ((MMScrollView)findViewById(2131301943));
    this.uhO = ((TextView)findViewById(2131301901));
    this.uxH = ((RelativeLayout)findViewById(2131301802));
    this.uxI = ((TextView)findViewById(2131301808));
    this.uxJ = ((TextView)findViewById(2131307213));
    this.uxK = ((ImageView)findViewById(2131301801));
    this.uxL = ((ImageView)findViewById(2131301800));
    this.uxM = ((ImageView)findViewById(2131301803));
    this.uxN = ((TextView)findViewById(2131301804));
    this.utK = new a(this);
    this.utL = getLayoutInflater().inflate(2131494640, null);
    this.utK.setContentView(this.utL, new ViewGroup.LayoutParams(-1, -1));
    this.utL.findViewById(2131301796).setOnClickListener(new LuckyMoneyPrepareUI.22(this));
    this.utK.urJ = new LuckyMoneyPrepareUI.33(this);
    this.utU = ((ViewGroup)this.utL.findViewById(2131301798));
    this.utS = com.tencent.mm.pluginsdk.ui.chat.e.DyA.eA(getContext());
    this.uxT = getIntent().getStringExtra("key_username");
    this.utS.setTalkerName(this.uxT);
    this.utS.setShowSmiley(false);
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
      this.uoX.setTitle(getString(2131760978));
      this.uoX.setShowGroupIcon(true);
      localObject1 = new LinearLayout.LayoutParams(-1, -1);
      localObject2 = new LinearLayout.LayoutParams(-1, com.tencent.mm.cc.a.au(this, 2131166515));
      if (this.mType != 1) {
        break label1356;
      }
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 13);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 13);
      this.uhJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.uxH.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.uoX.setOnInputValidChangerListener(this);
      this.uoX.setHint(getString(2131760895));
      this.uhH.setOnInputValidChangerListener(this);
      this.uhH.setHint(getString(2131760911));
      this.uhJ.setOnInputValidChangerListener(this);
      if (!com.tencent.mm.ui.aj.DT()) {
        break label1386;
      }
      this.uxM.setImageResource(2131233108);
      localObject1 = (EditText)this.uoX.findViewById(2131301810);
      localObject2 = (EditText)this.uhH.findViewById(2131301810);
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).addTextChangedListener(new LuckyMoneyPrepareUI.11(this, (EditText)localObject1));
      ((EditText)localObject2).addTextChangedListener(new LuckyMoneyPrepareUI.13(this, (EditText)localObject2));
      ((EditText)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65840);
          this.val$hintTv.setOnClickListener(null);
          this.uhS.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ah(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ah(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
          LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          AppMethodBeat.o(65840);
        }
      });
      ((EditText)localObject1).requestFocus();
      localObject3 = (TextView)this.uoX.findViewById(2131301716);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65841);
            this.val$hintTv.setOnClickListener(null);
            this.uhS.setOnClickListener(null);
            LuckyMoneyPrepareUI.this.ah(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
            LuckyMoneyPrepareUI.this.ah(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
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
          this.uhS.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ah(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ah(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
          LuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          AppMethodBeat.o(65842);
        }
      });
      ((MMEditText)this.uhJ.findViewById(2131301944)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(65843);
          this.val$hintTv.setOnClickListener(null);
          this.uhS.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ah(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ah(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(65843);
        }
      });
      if (this.ugW != null)
      {
        if (this.mType != 1) {
          break label1399;
        }
        this.uoX.setMaxAmount(this.ugW.ugv);
        this.uoX.setMinAmount(this.ugW.ugu);
        if (this.ugW.oxo != 1) {
          aks(this.ugW.ugy);
        }
      }
      if ((!this.upe) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1416;
      }
      this.uhH.setNum("1");
      label951:
      this.uhH.setMaxNum(this.ugW.ugs);
      this.uhH.setMinNum(1);
      ac.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.uhH.getInput());
      this.uoX.setMaxLen(12);
      if (dat()) {
        this.uhK.setText(getString(2131760935, new Object[] { this.ugW.uls }));
      }
      if ((!this.upe) && (this.fwc != 2)) {
        break label1874;
      }
      if (!dat()) {
        break label1428;
      }
      setMMTitle(getString(2131760976, new Object[] { this.ugW.uls }));
      label1093:
      i = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.upe) || (i != 0)) {
        break label1438;
      }
      ac.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
      this.uhH.setVisibility(8);
    }
    for (;;)
    {
      this.uhK.setOnClickListener(new w()
      {
        public final void bWk()
        {
          AppMethodBeat.i(65880);
          LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new df());
          LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).dNx = 6L;
          LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aHZ();
          if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(LuckyMoneyPrepareUI.this))
          {
            ac.w("MicroMsg.LuckyMoneyPrepareUI", "can not request hb while authen");
            com.tencent.mm.plugin.report.service.h.wUl.dB(965, 55);
            AppMethodBeat.o(65880);
            return;
          }
          LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this);
          AppMethodBeat.o(65880);
        }
      });
      this.uhQ.a(this.uhH);
      this.uhQ.a(this.uoX);
      this.uhQ.a(this.uhJ);
      localObject1 = (TextView)findViewById(2131301898);
      this.uhQ.n((TextView)localObject1);
      this.iRv = new com.tencent.mm.sdk.platformtools.au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(65881);
          int i;
          double d2;
          if ((LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).cYE() != 3) && (LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).cYE() != 3))
          {
            i = LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).getInput();
            d2 = LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).getInput();
            d1 = d2;
            if (LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this) != 0) {}
          }
          for (double d1 = d2 * i;; d1 = 0.0D)
          {
            if ((d1 == 0.0D) || (d1 > LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).ugv) || (LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).dad()))
            {
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setClickable(false);
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setEnabled(false);
            }
            for (;;)
            {
              ac.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).dad());
              LuckyMoneyPrepareUI.l(LuckyMoneyPrepareUI.this).eVs();
              AppMethodBeat.o(65881);
              return false;
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setClickable(true);
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setEnabled(true);
            }
          }
        }
      }, false);
      if (this.uhN != null) {
        this.uhN.setOnTouchListener(new View.OnTouchListener()
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
      this.uoX.setType(this.mType);
      init();
      final boolean bool = com.tencent.mm.y.c.aeH().a(ah.a.GPX, ah.a.GPZ);
      this.uxH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(65834);
          ac.d("MicroMsg.LuckyMoneyPrepareUI", "click envelope layout: %s", new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this)) });
          if (LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this) == 0)
          {
            LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null, false, bool);
            paramAnonymousView = com.tencent.mm.plugin.report.service.h.wUl;
            if (!bool) {
              break label171;
            }
          }
          label171:
          for (int i = 2;; i = 1)
          {
            paramAnonymousView.f(18890, new Object[] { Integer.valueOf(2), Integer.valueOf(i), LuckyMoneyPrepareUI.x(LuckyMoneyPrepareUI.this) });
            com.tencent.mm.plugin.report.service.h.wUl.f(16822, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(65834);
            return;
            paramAnonymousView = z.fD(LuckyMoneyPrepareUI.this.getContext());
            com.tencent.mm.plugin.luckymoney.model.g localg = com.tencent.mm.plugin.luckymoney.model.g.cYU();
            localg.b(new com.tencent.mm.plugin.luckymoney.model.c(""));
            localg.a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
            break;
          }
        }
      });
      if (bool) {
        this.uxN.setVisibility(0);
      }
      if (this.ulv != null) {
        b(this.ulv.ulc);
      }
      AppMethodBeat.o(65886);
      return;
      setMMTitle(2131760909);
      this.uoX.setTitle(getString(2131760979));
      this.uoX.setShowGroupIcon(false);
      break;
      label1356:
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 16);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 16);
      break label565;
      label1386:
      this.uxM.setImageResource(2131233107);
      break label650;
      label1399:
      this.uoX.setMaxAmount(this.ugW.ugt);
      break label883;
      label1416:
      this.uhH.setNum("");
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
      if ((this.upe) && (i > 0))
      {
        ac.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", new Object[] { Integer.valueOf(i) });
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
        this.uoX.setGroupIconIv(2131233029);
        ((com.tencent.mm.plugin.wallet_core.ui.l)localObject5).BFA = new l.a()
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
              LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setAmount(com.tencent.mm.wallet_core.ui.e.C(d / i));
            }
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setMaxAmount(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).ugt);
            LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this).setText(this.uhW);
            com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
            AppMethodBeat.o(65877);
          }
        };
        ((com.tencent.mm.plugin.wallet_core.ui.l)localObject4).BFA = new l.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65878);
            int i = LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).getInput();
            double d = LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).getInput();
            LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 1);
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setType(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this));
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setMaxAmount(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).ugv);
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setTitle(LuckyMoneyPrepareUI.this.getString(2131760978));
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setShowGroupIcon(true);
            if ((d > 0.0D) && (i > 0)) {
              LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setAmount(com.tencent.mm.wallet_core.ui.e.C(d * i));
            }
            LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this).setText(localSpannableString);
            com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
            AppMethodBeat.o(65878);
          }
        };
        this.lLe.setMovementMethod(LinkMovementMethod.getInstance());
        if (com.tencent.mm.ui.a.a.a.fhP().fhO()) {
          this.lLe.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65879);
              if (!com.tencent.mm.ui.a.a.a.fhP().fhO())
              {
                AppMethodBeat.o(65879);
                return;
              }
              if (LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this).getText().toString().equals(localSpannableString.toString()))
              {
                this.uyw.onClick(paramAnonymousView);
                AppMethodBeat.o(65879);
                return;
              }
              this.uyx.onClick(paramAnonymousView);
              AppMethodBeat.o(65879);
            }
          });
        }
        this.lLe.setTextColor(getResources().getColor(2131100021));
        this.lLe.setText(localSpannableString);
        this.lLe.setVisibility(0);
        break;
        if (this.fwc == 2)
        {
          ac.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
          this.uhJ.setVisibility(8);
        }
      }
      label1874:
      if (this.mType == 1)
      {
        this.lLe.setText(this.ugW.ulo);
        this.lLe.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.lLe.setText(this.ugW.ulp);
        this.lLe.setVisibility(0);
      }
    }
  }
  
  public final void j(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65902);
    if (paramIntent.hasExtra("key_realname_guide_helper")) {
      this.uxR = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
    }
    if (paramInt == -1)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cZv()), Integer.valueOf(5) });
      Object localObject1 = getIntent().getStringExtra("key_username");
      if ((this.upe) && (!bs.isNullOrNil((String)localObject1)))
      {
        com.tencent.mm.ui.base.h.cg(this, getString(2131760233));
        Object localObject2 = bv.L(this.upf, "msg");
        if (localObject2 == null)
        {
          ac.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
          finish();
          AppMethodBeat.o(65902);
          return;
        }
        localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
        if (com.tencent.mm.plugin.luckymoney.b.a.cYv().cYy().akg((String)localObject2))
        {
          ac.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
          if (!z.W(this.upf, (String)localObject1, 1))
          {
            ac.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
            com.tencent.mm.plugin.luckymoney.b.a.cYv().cYy().akh((String)localObject2);
          }
          h(paramInt, paramIntent);
          localObject1 = new com.tencent.mm.plugin.luckymoney.story.b.e();
          ((com.tencent.mm.plugin.luckymoney.story.b.e)localObject1).field_send_id = ((String)localObject2);
          if (!com.tencent.mm.plugin.luckymoney.b.a.cYv().cYu().get((com.tencent.mm.sdk.e.c)localObject1, new String[0]))
          {
            ((com.tencent.mm.plugin.luckymoney.story.b.e)localObject1).field_open_count = 0;
            ac.d("MicroMsg.LuckyMoneyPrepareUI", "insert record: %s, %s", new Object[] { localObject2, Boolean.valueOf(com.tencent.mm.plugin.luckymoney.b.a.cYv().cYu().insert((com.tencent.mm.sdk.e.c)localObject1)) });
          }
          this.uxU = new dg();
          this.uxU.dRL = this.uwd;
          if (this.peL != null) {
            break label417;
          }
          localObject1 = "";
          label339:
          this.uxU.le((String)localObject1);
          this.uxU.aHZ();
          ac.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.uwd), localObject1 });
          finish();
        }
      }
      for (;;)
      {
        akt(paramIntent.getStringExtra("key_trans_id"));
        AppMethodBeat.o(65902);
        return;
        ac.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
        break;
        label417:
        localObject1 = this.peL.JC();
        break label339;
        cZS();
        localObject1 = findViewById(2131301906);
        this.uoY.setVisibility(0);
        z.a((View)localObject1, null);
        this.pkJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65868);
            com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
            z.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.G(LuckyMoneyPrepareUI.this), true);
            LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65867);
                LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
                LuckyMoneyPrepareUI.this.cZR();
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
            LuckyMoneyPrepareUI.this.cZR();
            AppMethodBeat.o(65869);
          }
        });
        h(paramInt, paramIntent);
      }
    }
    h(paramInt, paramIntent);
    AppMethodBeat.o(65902);
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
        this.uxR = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
      }
      Object localObject1;
      if (paramInt2 == -1)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cZv()), Integer.valueOf(5) });
        localObject1 = getIntent().getStringExtra("key_username");
        if ((this.upe) && (!bs.isNullOrNil((String)localObject1)))
        {
          Object localObject2 = bv.L(this.upf, "msg");
          if (localObject2 == null)
          {
            ac.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65900);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.cYv().cYy().akg((String)localObject2))
          {
            ac.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!z.W(this.upf, (String)localObject1, 1))
            {
              ac.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.cYv().cYy().akh((String)localObject2);
            }
            label297:
            h(paramInt2, paramIntent);
            this.uxU = new dg();
            this.uxU.dRL = this.uwd;
            if (this.peL != null) {
              break label425;
            }
            localObject1 = "";
            label337:
            this.uxU.le((String)localObject1);
            this.uxU.aHZ();
            ac.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.uwd), localObject1 });
            finish();
          }
        }
        for (;;)
        {
          localObject1 = "";
          if (paramIntent != null) {
            localObject1 = paramIntent.getStringExtra("key_trans_id");
          }
          akt((String)localObject1);
          break;
          ac.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          break label297;
          label425:
          localObject1 = this.peL.JC();
          break label337;
          cZS();
          localObject1 = findViewById(2131301906);
          this.uoY.setVisibility(0);
          z.a((View)localObject1, null);
          this.pkJ.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65864);
              com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
              z.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.G(LuckyMoneyPrepareUI.this), true);
              LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(65863);
                  LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
                  LuckyMoneyPrepareUI.this.cZR();
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
              LuckyMoneyPrepareUI.this.cZR();
              AppMethodBeat.o(65866);
            }
          });
          h(paramInt2, paramIntent);
        }
      }
      if (com.tencent.mm.wallet_core.c.ag.br(paramIntent))
      {
        finish();
        AppMethodBeat.o(65900);
        return;
      }
      if (com.tencent.mm.wallet_core.c.ag.bs(paramIntent))
      {
        AppMethodBeat.o(65900);
        return;
      }
      h(paramInt2, paramIntent);
      continue;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cZv()), Integer.valueOf(7), localObject1 });
        if (!bs.isNullOrNil((String)localObject1)) {
          doSceneProgress(new at(((String)localObject1).replaceAll(",", "|"), this.upc, "v1.0"));
        } else {
          finish();
        }
      }
      else if (paramInt2 == 0)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(getContext(), LuckyMoneyMyRecordUI.class);
        ((Intent)localObject1).putExtra("key_type", 1);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        if ((paramIntent != null) && (paramIntent.hasExtra("result_data")))
        {
          localObject1 = paramIntent.getBundleExtra("result_data");
          if (localObject1 != null)
          {
            int i = bs.getInt(((Bundle)localObject1).getString("payState", "2"), 0);
            ac.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i + ";STATE_H5_PAY_SUCC=0");
            if (i == 0) {
              finish();
            }
          }
          else
          {
            ac.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
            continue;
            i(paramInt2, paramIntent);
            continue;
            if (paramInt2 == -1)
            {
              this.upa.removeAllViews();
              nK(true);
            }
            else
            {
              nK(false);
              com.tencent.mm.plugin.report.service.h.wUl.f(16822, new Object[] { Integer.valueOf(2) });
              continue;
              if (paramInt2 == -1)
              {
                localObject1 = "";
                if (paramIntent != null) {
                  localObject1 = paramIntent.getStringExtra("gif_md5");
                }
                if (!bs.isNullOrNil((String)localObject1))
                {
                  this.peL = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.aOT((String)localObject1);
                  A(this.peL);
                }
                else
                {
                  ac.i("MicroMsg.LuckyMoneyPrepareUI", "md5 == null go emoji capture failed!");
                }
              }
              else
              {
                ac.i("MicroMsg.LuckyMoneyPrepareUI", "go emoji capture failed!");
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
    this.upb = getIntent().getIntExtra("key_way", 3);
    this.fwc = getIntent().getIntExtra("key_from", 0);
    if (this.fwc == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.upe = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      this.mSessionId = getIntent().getStringExtra("key_session_id");
      nK(false);
      com.tencent.mm.plugin.luckymoney.b.a.cYv();
      this.ugW = com.tencent.mm.plugin.luckymoney.b.a.cYw().cYZ();
      com.tencent.mm.plugin.luckymoney.b.a.cYv();
      this.ulv = com.tencent.mm.plugin.luckymoney.b.a.cYw().cZa();
      ac.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.upb + "mChannel:" + this.mChannel);
      ac.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.upe + ", config " + this.ugW);
      initView();
      com.tencent.mm.sdk.b.a.GpY.b(this.uyk);
      this.mPayLoopInterruptListener.alive();
      com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cZv()), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.b.fzz();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.pRO, true);
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.fDB();
      AppMethodBeat.o(65883);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65893);
    super.onDestroy();
    this.uhQ.clear();
    this.iRv.eVs();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.utS != null)
    {
      ac.i("MicroMsg.LuckyMoneyPrepareUI", "commentfooter release");
      this.utS.onPause();
      this.utS.eMG();
      this.utS.destroy();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.uyk);
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(65896);
    ac.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof aq))
    {
      if (this.uyj)
      {
        ac.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
        AppMethodBeat.o(65896);
        return true;
      }
      aq localaq = (aq)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_HONGBAO_PAY_SWTICH_KEY"))) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (paramInt1 == 0)) {
            this.tipDialog.dismiss();
          }
          this.upd = localaq.owW;
          this.upc = localaq.uhB;
          this.upf = localaq.unT;
          this.ust = localaq.uhB;
          this.uxS = localaq.unZ;
          if (!((aq)paramn).isJumpRemind()) {
            break;
          }
          ac.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() NetScenePrepareLuckyMoney show JumpRemind Alert");
          ((aq)paramn).jumpRemind.a(this, new LuckyMoneyPrepareUI.20(this));
          AppMethodBeat.o(65896);
          return true;
        }
        paramString = new PayInfo();
        paramString.dac = localaq.skK;
        paramString.dqL = 37;
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
        this.uhK.setEnabled(false);
        this.uhK.setClickable(false);
        this.iRv.au(5000L, 5000L);
        com.tencent.mm.ui.base.h.cg(this, paramString);
        AppMethodBeat.o(65896);
        return true;
      }
      if (paramInt2 == 268502454)
      {
        com.tencent.mm.ui.base.h.d(this, paramString, "", new LuckyMoneyPrepareUI.21(this, paramn));
        AppMethodBeat.o(65896);
        return true;
      }
      this.dtm = 2;
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
        if (this.upe)
        {
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
          ap.n(new LuckyMoneyPrepareUI.23(this), 1800L);
        }
        for (;;)
        {
          AppMethodBeat.o(65896);
          return true;
          cZS();
          this.uoZ.setVisibility(0);
          this.uoZ.postDelayed(new LuckyMoneyPrepareUI.24(this), 1000L);
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
      if ((paramn instanceof ai))
      {
        ac.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString);
        if ((this.uxF != null) && (this.uxF.isShowing())) {
          this.uxF.dismiss();
        }
        if ((this.uxG != null) && (this.uxG.isShowing())) {
          this.uxG.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (ai)paramn;
          this.uyg = true;
          this.unI = paramString.unI;
          if (!bs.jl(paramString.unJ, 1))
          {
            this.uhJ.nL(true);
            com.tencent.mm.plugin.luckymoney.b.a.cYv();
            this.ugW = com.tencent.mm.plugin.luckymoney.b.a.cYw().cYZ();
            ac.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.ugW);
            if (this.mType != 1) {
              break label1492;
            }
            this.uoX.setMaxAmount(this.ugW.ugv);
            label867:
            this.uoX.setMinAmount(this.ugW.ugu);
            this.uhH.setMaxNum(this.ugW.ugs);
            this.uxP = paramString.ugx;
            this.uxO = paramString.oxo;
            this.uxQ = paramString.ugH;
            if (bs.isNullOrNil(this.uwk)) {
              this.uwk = paramString.dpt;
            }
            if ((!bs.isNullOrNil(this.uxQ)) && (this.uhJ != null)) {
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(65858);
                  LuckyMoneyPrepareUI.D(LuckyMoneyPrepareUI.this).setHintText(LuckyMoneyPrepareUI.E(LuckyMoneyPrepareUI.this));
                  AppMethodBeat.o(65858);
                }
              });
            }
            if ((paramString.unz) && (this.upe))
            {
              paramn = (TextView)findViewById(2131301899);
              paramn.setOnClickListener(new LuckyMoneyPrepareUI.29(this));
              com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(cZv()), Integer.valueOf(8) });
              paramn.setVisibility(8);
            }
            if (bs.isNullOrNil(paramString.iAx)) {
              break label1509;
            }
            ac.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.iAx);
            this.uhO.setText(paramString.iAx);
            if (!bs.isNullOrNil(paramString.unB)) {
              this.uhO.setOnClickListener(new LuckyMoneyPrepareUI.30(this, paramString));
            }
            this.uhO.setVisibility(0);
            label1144:
            paramn = new h.c();
            if ((paramString.unD == null) || (bs.isNullOrNil(paramString.unD.content))) {
              break label1521;
            }
            paramn.textColor = getResources().getColor(2131101114);
            label1188:
            this.upa.removeAllViews();
            h.a(this, this.upa, paramString.unD, paramn);
            aks(paramString.ugy);
            if (this.uxO == 1) {
              break label1539;
            }
            b(this.uoX.getInput(), this.uxP);
            label1240:
            com.tencent.mm.plugin.luckymoney.b.a.cYv();
            this.ulv = com.tencent.mm.plugin.luckymoney.b.a.cYw().cZa();
            init();
            if (this.ulv == null) {
              break label1565;
            }
            if (this.ulv.ulc != null)
            {
              this.uxV = this.ulv.ulc.EYQ;
              this.uxW = this.ulv.ulc.EYO;
              this.uxX = this.ulv.ulc.EYP;
            }
            b(this.ulv.ulc);
            com.tencent.mm.plugin.report.service.h.wUl.dB(991, 10);
            label1339:
            if (this.uyi)
            {
              ac.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick()");
              a(this.uxZ, this.uya, this.uyb, this.uyc, this.uyd, this.uye);
            }
          }
        }
        for (;;)
        {
          ac.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig waitingGetConfig:%s ifAutoRMBPrePareBtn:%s", new Object[] { Boolean.valueOf(this.uyh), Boolean.valueOf(this.uyi) });
          this.uyh = false;
          this.uyi = false;
          AppMethodBeat.o(65896);
          return true;
          this.uhJ.nL(false);
          if ((this.peL != null) && (!bs.isNullOrNil(this.peL.JC()))) {
            this.uhJ.A(this.peL);
          }
          this.uhJ.setmOnEmojiSelectClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65857);
              LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new df());
              LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).dNx = 2L;
              LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aHZ();
              final boolean bool = bs.I(paramAnonymousView.getTag(), "delete");
              if ((!bool) && (!bs.jl(paramString.unI, 1)))
              {
                LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, 2);
                LuckyMoneyPrepareUI.A(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(65857);
                return;
              }
              paramAnonymousView = new com.tencent.mm.ui.widget.d(LuckyMoneyPrepareUI.this.getContext(), 1, false);
              paramAnonymousView.ISu = new n.c()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(65855);
                  if (!bool)
                  {
                    if (bs.jl(LuckyMoneyPrepareUI.27.this.uph.unI, 1)) {
                      paramAnonymous2l.jw(1, 2131760908);
                    }
                    paramAnonymous2l.jw(2, 2131760952);
                    AppMethodBeat.o(65855);
                    return;
                  }
                  paramAnonymous2l.a(3, LuckyMoneyPrepareUI.this.getResources().getColor(2131100596), LuckyMoneyPrepareUI.this.getContext().getString(2131760844));
                  AppMethodBeat.o(65855);
                }
              };
              paramAnonymousView.ISv = new n.d()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(65856);
                  ac.i("MicroMsg.LuckyMoneyPrepareUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(65856);
                    return;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, 1);
                    com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyPrepareUI.this, 4, LuckyMoneyPrepareUI.B(LuckyMoneyPrepareUI.this));
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new df());
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).dNx = 4L;
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aHZ();
                    AppMethodBeat.o(65856);
                    return;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, 2);
                    LuckyMoneyPrepareUI.A(LuckyMoneyPrepareUI.this);
                    AppMethodBeat.o(65856);
                    return;
                    LuckyMoneyPrepareUI.C(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem = LuckyMoneyPrepareUI.D(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem.uyB.setTag("");
                    paramAnonymous2MenuItem.uyC.setVisibility(0);
                    paramAnonymous2MenuItem.uyD.setVisibility(8);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new df());
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).dNx = 5L;
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aHZ();
                  }
                }
              };
              paramAnonymousView.cED();
              AppMethodBeat.o(65857);
            }
          });
          break;
          label1492:
          this.uoX.setMaxAmount(this.ugW.ugt);
          break label867;
          label1509:
          this.uhO.setVisibility(8);
          break label1144;
          label1521:
          paramn.textColor = getResources().getColor(2131100482);
          break label1188;
          label1539:
          if (this.mType != 1) {
            break label1240;
          }
          b(this.uoX.getInput(), this.uxP);
          break label1240;
          label1565:
          b(null);
          break label1339;
          if (this.uyi)
          {
            paramn = paramString;
            if (bs.isNullOrNil(paramString)) {
              paramn = getString(2131755733);
            }
            t.makeText(this, paramn, 0).show();
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.aj))
      {
        removeSceneEndListener(1647);
        if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
          this.tipDialog.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((com.tencent.mm.plugin.luckymoney.model.aj)paramn).oxz;
          if (!bs.isNullOrNil(paramString))
          {
            ac.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
            com.tencent.mm.wallet_core.ui.e.a(getContext(), paramString, false, 3);
          }
          for (;;)
          {
            AppMethodBeat.o(65896);
            return true;
            ac.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
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
              this.ust = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn).uhB;
              this.uxS = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn).uiV;
              paramString = new PayInfo();
              paramString.dac = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn).dac;
              paramString.dqL = 37;
              if ((!this.mKindaEnable) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_F2F_HONGBAO_PAY_SWTICH_KEY"))) {
                break label1922;
              }
              if (paramString.hbR == null) {
                paramString.hbR = new Bundle();
              }
              paramString.hbR.putBoolean("isF2FHongBao", true);
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
            af.x(37, paramString.dac, paramInt2);
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, 4);
            continue;
            af.x(37, "", paramInt2);
            if (!bs.isNullOrNil(paramString)) {
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