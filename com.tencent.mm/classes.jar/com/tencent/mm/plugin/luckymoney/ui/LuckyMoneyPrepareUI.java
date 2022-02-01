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
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.g.b.a.ea;
import com.tencent.mm.g.b.a.eb;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.luckymoney.model.ab;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements g
{
  private int dGt;
  private int fRv;
  private aw jnx;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private boolean mKindaEnable;
  private com.tencent.mm.sdk.b.c<oq> mPayLoopInterruptListener;
  private String mSessionId;
  private int mType;
  private TextView mpP;
  private EmojiInfo pOS;
  private Button pUO;
  private TextView plm;
  public Dialog tipDialog;
  private com.tencent.mm.plugin.luckymoney.model.e vAg;
  private int vCt;
  private LuckyMoneyMoneyInputView vDG;
  private View vDH;
  private View vDI;
  private ViewGroup vDJ;
  private int vDK;
  private String vDL;
  private int vDM;
  private boolean vDN;
  private String vDO;
  private String vHa;
  private ViewGroup vIB;
  private ea vID;
  private int vIG;
  private a vIr;
  private View vIs;
  private ChatFooterPanel vIz;
  private int vKK;
  private String vKR;
  private String vKU;
  private String vMA;
  private eb vMB;
  private int vMC;
  private String vMD;
  private String vME;
  private boolean vMF;
  private int vMG;
  private String vMH;
  private int vMI;
  private long vMJ;
  private long vMK;
  private String vML;
  private com.tencent.mm.ui.widget.d vMM;
  private boolean vMN;
  private boolean vMO;
  private boolean vMP;
  private boolean vMQ;
  private com.tencent.mm.sdk.b.c<tv> vMR;
  private Dialog vMm;
  private Dialog vMn;
  private RelativeLayout vMo;
  private TextView vMp;
  private TextView vMq;
  private ImageView vMr;
  private ImageView vMs;
  private ImageView vMt;
  private TextView vMu;
  private int vMv;
  private String vMw;
  private String vMx;
  private RealnameGuideHelper vMy;
  private String vMz;
  private j vvL;
  private MMScrollView vwC;
  private TextView vwD;
  private b vwF;
  private LuckyMoneyNumInputView vww;
  private LuckyMoneyTextInputView vwy;
  private Button vwz;
  
  public LuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65882);
    this.vww = null;
    this.vDG = null;
    this.vwy = null;
    this.plm = null;
    this.vwz = null;
    this.pUO = null;
    this.tipDialog = null;
    this.vMm = null;
    this.vMn = null;
    this.vwF = new b();
    this.jnx = null;
    this.vMv = 1;
    this.vMw = com.tencent.mm.wallet_core.ui.f.bai("CNY");
    this.vMx = null;
    this.vHa = "";
    this.vKK = 1;
    this.vIG = 0;
    this.vMF = false;
    this.mPayLoopInterruptListener = new com.tencent.mm.sdk.b.c() {};
    this.vMN = false;
    this.vMO = false;
    this.vMP = false;
    this.vMQ = false;
    this.vMR = new com.tencent.mm.sdk.b.c() {};
    this.dGt = 0;
    this.vKU = "";
    AppMethodBeat.o(65882);
  }
  
  private void B(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65897);
    this.vwy.B(paramEmojiInfo);
    if ((this.vIG == 0) || (this.vIG == 2)) {
      if (com.tencent.mm.plugin.emoji.h.b.y(paramEmojiInfo)) {
        this.vKK = 2;
      }
    }
    for (;;)
    {
      this.vID = new ea();
      this.vID.eeh = 1L;
      this.vID.aLH();
      AppMethodBeat.o(65897);
      return;
      if (com.tencent.mm.plugin.emoji.h.b.w(paramEmojiInfo))
      {
        this.vKK = 4;
      }
      else
      {
        this.vKK = 3;
        continue;
        if (this.vIG == 1) {
          this.vKK = 2;
        }
      }
    }
  }
  
  private void JY(int paramInt)
  {
    AppMethodBeat.i(65888);
    ae.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() userConfirmJump:%s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(dlG()), Integer.valueOf(4) });
    com.tencent.mm.plugin.report.service.g.yxI.f(15511, new Object[] { Integer.valueOf(this.vMv), Integer.valueOf(2) });
    if (this.vDG.dkP() != 0)
    {
      t.makeText(getContext(), 2131765031, 0).show();
      AppMethodBeat.o(65888);
      return;
    }
    int i = this.vww.getInput();
    double d = this.vDG.getInput();
    long l2 = 0L;
    long l1;
    if (this.mType == 1)
    {
      l1 = com.tencent.mm.wallet_core.ui.f.E(d);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(356354, Integer.valueOf(i));
      str = this.vwy.getInput().replace("\r", "").replace("\n", "");
      localObject = str;
      if (bu.isNullOrNil(str)) {
        if (!bu.isNullOrNil(this.vMx)) {
          break label338;
        }
      }
    }
    label338:
    for (Object localObject = getString(2131760843);; localObject = this.vMx)
    {
      hideTenpayKB();
      if (this.fRv != 2) {
        break label347;
      }
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.d(i, (int)l1, this.mType, (int)l2), false);
      dmE();
      AppMethodBeat.o(65888);
      return;
      l1 = com.tencent.mm.wallet_core.ui.f.E(i * d);
      l2 = com.tencent.mm.wallet_core.ui.f.E(d);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(356353, Integer.valueOf(i));
      break;
    }
    label347:
    String str = getIntent().getStringExtra("key_username");
    if (this.vMv == 1)
    {
      ae.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() ifGetConfig=%s mUniqueId=%s waitingGetConfig=%s ifAutoRMBPrePareBtn=%s", new Object[] { Boolean.valueOf(this.vMN), bu.nullAsNil(this.vKR), Boolean.valueOf(this.vMO), Boolean.valueOf(this.vMP) });
      if (this.vMN)
      {
        a(paramInt, str, i, l1, l2, (String)localObject);
        AppMethodBeat.o(65888);
        return;
      }
      this.vMP = true;
      this.vMG = paramInt;
      this.vMH = str;
      this.vMI = i;
      this.vMJ = l1;
      this.vMK = l2;
      this.vML = ((String)localObject);
      if (this.vMn != null) {
        this.vMn.show();
      }
      for (;;)
      {
        if (!this.vMO) {
          oj(false);
        }
        AppMethodBeat.o(65888);
        return;
        this.vMn = com.tencent.mm.ui.base.h.a(this, 3, 2131820985, getString(2131760709), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(65829);
            ae.i("MicroMsg.LuckyMoneyPrepareUI", "coperationTipDialogNoTransparent onCancel()");
            LuckyMoneyPrepareUI.m(LuckyMoneyPrepareUI.this);
            LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this);
            if ((LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this) != null) && (LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this).isShowing())) {
              LuckyMoneyPrepareUI.o(LuckyMoneyPrepareUI.this).dismiss();
            }
            if ((LuckyMoneyPrepareUI.p(LuckyMoneyPrepareUI.this).getVisibility() == 8) || (LuckyMoneyPrepareUI.q(LuckyMoneyPrepareUI.this).getVisibility() == 4))
            {
              ae.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
              LuckyMoneyPrepareUI.this.finish();
            }
            LuckyMoneyPrepareUI.this.vGY.forceCancel();
            AppMethodBeat.o(65829);
          }
        });
      }
    }
    ae.i("MicroMsg.LuckyMoneyPrepareUI", "currency=%s userConfiremJump:%s", new Object[] { Integer.valueOf(this.vMv), Integer.valueOf(paramInt) });
    addSceneEndListener(1647);
    if ((this.vDN) && (!bu.isNullOrNil(str))) {}
    for (localObject = new com.tencent.mm.plugin.luckymoney.model.aj(i, l1, l2, this.mType, (String)localObject, str, z.dlp(), v.aAC(), this.vMv);; localObject = new com.tencent.mm.plugin.luckymoney.model.aj(i, l1, l2, this.mType, (String)localObject, null, z.dlp(), v.aAC(), this.vMv))
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
    if (this.pOS != null)
    {
      str2 = this.pOS.Lj();
      i = this.pOS.field_type;
    }
    String str1 = "";
    if (this.vAg != null) {
      str1 = this.vAg.vzO;
    }
    ae.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB. userConfirmJump:%s lastPayResult:%s mSendId:%s mUniqueId:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.dGt), this.vHa, this.vKR });
    if ((this.vDN) && (!bu.isNullOrNil(paramString1))) {}
    for (paramString1 = new com.tencent.mm.plugin.luckymoney.model.aq(paramInt2, paramLong1, paramLong2, this.mType, paramString2, z.dlp(), paramString1, z.zO(paramString1), v.aAC(), v.aAE(), this.vDK, str1, this.vKR, paramInt1, this.dGt, this.vHa, str2, i);; paramString1 = new com.tencent.mm.plugin.luckymoney.model.aq(paramInt2, paramLong1, paramLong2, this.mType, paramString2, z.dlp(), null, null, v.aAC(), v.aAE(), this.vDK, str1, this.vKR, paramInt1, this.dGt, this.vHa, str2, i))
    {
      doSceneProgress(paramString1, false);
      if (!bu.isNullOrNil(str1)) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(991, 11);
      }
      dmE();
      AppMethodBeat.o(65890);
      return;
    }
  }
  
  private void aqk(String paramString)
  {
    AppMethodBeat.i(65898);
    ae.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=".concat(String.valueOf(paramString)));
    TextView localTextView = (TextView)findViewById(2131301716);
    if (!bu.isNullOrNil(paramString))
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(65898);
      return;
    }
    localTextView.setText(getString(2131760830));
    AppMethodBeat.o(65898);
  }
  
  private void aql(String paramString)
  {
    AppMethodBeat.i(65911);
    ae.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ag(this.vHa, paramString, this.vMz), false);
    AppMethodBeat.o(65911);
  }
  
  private void b(double paramDouble, String paramString)
  {
    AppMethodBeat.i(65908);
    if (bu.isNullOrNil(paramString))
    {
      this.plm.setText(com.tencent.mm.wallet_core.ui.f.D(paramDouble));
      AppMethodBeat.o(65908);
      return;
    }
    this.plm.setText(paramString + com.tencent.mm.wallet_core.ui.f.C(paramDouble));
    AppMethodBeat.o(65908);
  }
  
  private void b(bom parambom)
  {
    AppMethodBeat.i(65892);
    ae.i("MicroMsg.LuckyMoneyPrepareUI", "update envelope");
    if ((this.vAg != null) && (parambom != null) && (this.fRv != 2))
    {
      this.vMo.setVisibility(0);
      boolean bool = com.tencent.mm.y.c.ahI().a(am.a.IWR, am.a.IWT);
      Object localObject;
      if (!this.vMF)
      {
        localObject = com.tencent.mm.plugin.report.service.g.yxI;
        if (!bool) {
          break label234;
        }
      }
      label234:
      for (int i = 2;; i = 1)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject).f(18890, new Object[] { Integer.valueOf(1), Integer.valueOf(i), this.mSessionId });
        this.vMF = true;
        if ((!this.vAg.vzP) || (bu.isNullOrNil(this.vAg.vzQ))) {
          break label336;
        }
        localObject = bu.lV((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWV, ""), ",");
        Iterator localIterator = ((List)localObject).iterator();
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
        } while (!str.equals(this.vAg.vzN.Gta));
        ae.d("MicroMsg.LuckyMoneyPrepareUI", "has alert illegal: %s", new Object[] { str });
        AppMethodBeat.o(65892);
        return;
      }
      ((List)localObject).add(this.vAg.vzN.Gta);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWV, bu.m((List)localObject, ","));
      ae.i("MicroMsg.LuckyMoneyPrepareUI", "show alert illegal: %s", new Object[] { this.vAg.vzN.Gta });
      com.tencent.mm.ui.base.h.a(getContext(), this.vAg.vzQ, "", getString(2131766205), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      label336:
      if ((parambom == null) || (parambom.cPu != 1)) {
        break label450;
      }
      this.vMo.setEnabled(false);
      if (!bu.isNullOrNil(parambom.HbP)) {
        this.vMp.setText(parambom.HbP);
      }
      this.vMr.setImageBitmap(null);
      this.vMs.setVisibility(8);
      this.vMp.setTextColor(getResources().getColor(2131099660));
    }
    for (;;)
    {
      if ((parambom == null) || (parambom.hCs != 2)) {
        break label584;
      }
      this.vMq.setVisibility(0);
      AppMethodBeat.o(65892);
      return;
      this.vMo.setVisibility(8);
      break;
      label450:
      if ((parambom != null) && (!bu.isNullOrNil(parambom.HbA)))
      {
        this.vMo.setEnabled(true);
        this.vMp.setText(parambom.HbA);
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.vMr, parambom);
        this.vMs.setVisibility(0);
        this.vMp.setTextColor(getResources().getColor(2131100020));
      }
      else
      {
        this.vMo.setEnabled(true);
        this.vMr.setImageBitmap(null);
        this.vMp.setText("");
        this.vMs.setVisibility(0);
        this.vMp.setTextColor(getResources().getColor(2131100020));
      }
    }
    label584:
    this.vMq.setVisibility(8);
    AppMethodBeat.o(65892);
  }
  
  private int dlG()
  {
    AppMethodBeat.i(65909);
    if (this.vDN)
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
  
  private void dmE()
  {
    AppMethodBeat.i(65889);
    if (this.tipDialog != null)
    {
      this.tipDialog.show();
      AppMethodBeat.o(65889);
      return;
    }
    this.tipDialog = com.tencent.mm.wallet_core.ui.h.a(getContext(), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(65830);
        if ((LuckyMoneyPrepareUI.r(LuckyMoneyPrepareUI.this) != null) && (LuckyMoneyPrepareUI.r(LuckyMoneyPrepareUI.this).isShowing())) {
          LuckyMoneyPrepareUI.r(LuckyMoneyPrepareUI.this).dismiss();
        }
        if ((LuckyMoneyPrepareUI.s(LuckyMoneyPrepareUI.this).getVisibility() == 8) || (LuckyMoneyPrepareUI.t(LuckyMoneyPrepareUI.this).getVisibility() == 4))
        {
          ae.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
          LuckyMoneyPrepareUI.this.finish();
        }
        LuckyMoneyPrepareUI.this.vGY.forceCancel();
        AppMethodBeat.o(65830);
      }
    });
    this.tipDialog.setCancelable(false);
    AppMethodBeat.o(65889);
  }
  
  private boolean dmF()
  {
    AppMethodBeat.i(65907);
    if ((this.vvL != null) && (!bu.isNullOrNil(this.vvL.vAd)))
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
    String str2 = v.aAC();
    if (paramInt == -1)
    {
      ae.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode == RESULT_OK");
      this.dGt = 1;
      this.vKU = "";
      paramIntent = new an(this.vHa, this.vKR, 1, str2, bu.nullAsNil(str1));
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramIntent, 0);
      AppMethodBeat.o(65899);
      return;
    }
    if (paramIntent != null) {}
    for (this.dGt = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.dGt = 3)
    {
      this.vKU = this.vHa;
      ae.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.dGt) });
      paramIntent = new an(this.vHa, this.vKR, this.dGt, str2, bu.nullAsNil(str1));
      break;
      ae.i("MicroMsg.LuckyMoneyPrepareUI", "doNetSceneLuckyMoneyReport() data == null");
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(65891);
    if (this.vMv == 1)
    {
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(65831);
          LuckyMoneyPrepareUI.u(LuckyMoneyPrepareUI.this);
          AppMethodBeat.o(65831);
          return true;
        }
      });
      AppMethodBeat.o(65891);
      return;
    }
    addIconOptionMenu(0, 2131233032, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65832);
        if ((LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this) != null) && (!bu.isNullOrNil(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).vAc))) {
          com.tencent.mm.wallet_core.ui.f.p(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).vAc, false);
        }
        for (;;)
        {
          AppMethodBeat.o(65832);
          return true;
          com.tencent.mm.wallet_core.ui.f.p(LuckyMoneyPrepareUI.this.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
        }
      }
    });
    AppMethodBeat.o(65891);
  }
  
  private void oj(boolean paramBoolean)
  {
    AppMethodBeat.i(65894);
    ae.i("MicroMsg.LuckyMoneyPrepareUI", "do get config");
    if (paramBoolean) {
      this.vMm = z.fO(getContext());
    }
    this.vMO = true;
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWU, Integer.valueOf(0))).intValue();
    this.vMC = i;
    doSceneProgress(new ai("v1.0", i, (byte)0), false);
    AppMethodBeat.o(65894);
  }
  
  protected final void ai(final View paramView, final int paramInt)
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
    com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      boolean firstTime = true;
      
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(65872);
        if ((paramAnonymousView.isFocused()) && (!this.val$isShowSysKB))
        {
          ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new com.tencent.mm.sdk.platformtools.aq().postDelayed(new Runnable()
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
        new com.tencent.mm.sdk.platformtools.aq().postDelayed(new Runnable()
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((!LuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
        {
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, paramInt);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65873);
          return;
          if (this.val$isShowSysKB)
          {
            LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
            LuckyMoneyPrepareUI.I(LuckyMoneyPrepareUI.this).setVisibility(0);
            ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
          }
        }
      }
    });
    TextView localTextView = (TextView)paramView.findViewById(2131301716);
    if (localTextView != null) {
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65875);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((LuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB)) {
            if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
              LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(localEditText);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65875);
            return;
            if ((!LuckyMoneyPrepareUI.this.mKBLayout.isShown()) && (!this.val$isShowSysKB))
            {
              ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              new com.tencent.mm.sdk.platformtools.aq().postDelayed(new Runnable()
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
            }
            else if (this.val$isShowSysKB)
            {
              LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
              ((InputMethodManager)LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
            }
          }
        }
      });
    }
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65876);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LuckyMoneyPrepareUI.this.hideTenpayKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65876);
      }
    });
    AppMethodBeat.o(65903);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65895);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.vDH.getVisibility() == 0))
    {
      this.vDH.setVisibility(8);
      dmd();
      AppMethodBeat.o(65895);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65895);
    return bool;
  }
  
  public final void dkQ()
  {
    AppMethodBeat.i(65906);
    com.tencent.mm.plugin.luckymoney.b.a.dkG();
    this.vvL = com.tencent.mm.plugin.luckymoney.b.a.dkH().dlk();
    int i;
    double d2;
    double d1;
    if ((this.vDG.dkP() != 3) && (this.vww.dkP() != 3))
    {
      i = this.vww.getInput();
      d2 = this.vDG.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.vDG.getInput();
      }
    }
    for (;;)
    {
      if (this.vwF.dmo())
      {
        ae.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
        this.vwz.setClickable(false);
        this.vwz.setEnabled(false);
        b(d2, this.vMw);
        AppMethodBeat.o(65906);
        return;
        if (i > 0) {
          d1 = com.tencent.mm.wallet_core.ui.f.a(String.valueOf(d2), String.valueOf(i), String.valueOf(this.vvL.vvh).length() + 2, RoundingMode.HALF_UP);
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
          label429:
          boolean bool1;
          if (bool2)
          {
            this.vwz.setClickable(false);
            this.vwz.setEnabled(false);
            break;
            if ((d2 > this.vvL.vvk) && (this.vvL.vvk > 0.0D))
            {
              this.vwF.UG(getString(2131760977, new Object[] { Math.round(this.vvL.vvk), bu.bI(this.vvL.vvn, "") }));
              bool2 = true;
              continue;
            }
            if (d1 <= 0.0D) {
              break label1061;
            }
            ae.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d1)));
            if (this.mType == 0)
            {
              if ((d1 <= this.vvL.vvi) || (this.vvL.vvi <= 0.0D)) {
                break label1055;
              }
              if (dmF())
              {
                this.vwF.UG(getString(2131760923, new Object[] { this.vvL.vAd, Math.round(this.vvL.vvi), bu.bI(this.vvL.vvn, "") }));
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            ae.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
            bool2 = bool1;
            if (!bool1)
            {
              if (this.mType != 0) {
                break label904;
              }
              bool2 = bool1;
              if (d1 < this.vvL.vvj)
              {
                if (!dmF()) {
                  break label854;
                }
                this.vwF.UG(getString(2131760925, new Object[] { this.vvL.vAd, com.tencent.mm.wallet_core.ui.f.C(this.vvL.vvj), bu.bI(this.vvL.vvn, "") }));
                label558:
                bool2 = true;
              }
            }
            label854:
            do
            {
              ae.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
              break;
              this.vwF.UG(getString(2131760922, new Object[] { Math.round(this.vvL.vvi), bu.bI(this.vvL.vvn, "") }));
              break label429;
              if ((d1 <= this.vvL.vvl) || (this.vvL.vvl <= 0.0D)) {
                break label1055;
              }
              if ((this.vvL != null) && (!bu.isNullOrNil(this.vvL.vAd))) {
                this.vwF.UG(getString(2131760923, new Object[] { this.vvL.vAd, Math.round(this.vvL.vvl), bu.bI(this.vvL.vvn, "") }));
              }
              for (;;)
              {
                this.vww.onError();
                this.vDG.onError();
                bool1 = true;
                break;
                this.vwF.UG(getString(2131760922, new Object[] { Math.round(this.vvL.vvl), bu.bI(this.vvL.vvn, "") }));
              }
              this.vwF.UG(getString(2131760924, new Object[] { com.tencent.mm.wallet_core.ui.f.C(this.vvL.vvj), bu.bI(this.vvL.vvn, "") }));
              break label558;
              bool2 = bool1;
            } while (d1 >= 0.01D);
            label904:
            if (dmF()) {
              this.vwF.UG(getString(2131760925, new Object[] { this.vvL.vAd, "0.01", bu.bI(this.vvL.vvn, "") }));
            }
            for (;;)
            {
              this.vww.onError();
              this.vDG.onError();
              bool2 = true;
              break;
              this.vwF.UG(getString(2131760924, new Object[] { "0.01", bu.bI(this.vvL.vvn, "") }));
            }
            this.vwz.setClickable(true);
            this.vwz.setEnabled(true);
            break;
            label1055:
            bool1 = false;
          }
          label1061:
          bool2 = false;
        }
      }
      d1 = 0.0D;
      continue;
      d1 = 0.0D;
      d2 = 0.0D;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(65910);
    if (this.vMy != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_realname_guide_helper", this.vMy);
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
      aql(str);
    }
    finish();
    AppMethodBeat.o(65901);
  }
  
  public void initView()
  {
    AppMethodBeat.i(65886);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65838);
        LuckyMoneyPrepareUI.this.finish();
        AppMethodBeat.o(65838);
        return true;
      }
    });
    this.vDH = findViewById(2131301905);
    this.vDI = findViewById(2131301908);
    this.pUO = ((Button)findViewById(2131301907));
    this.vwy = ((LuckyMoneyTextInputView)findViewById(2131301959));
    this.vwy.setHintText(getString(2131760843));
    this.vwz = ((Button)findViewById(2131301896));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    this.mpP = ((TextView)findViewById(2131301894));
    this.vww = ((LuckyMoneyNumInputView)findViewById(2131301891));
    this.vDG = ((LuckyMoneyMoneyInputView)findViewById(2131301715));
    this.plm = ((TextView)findViewById(2131301909));
    this.vDJ = ((ViewGroup)findViewById(2131301903));
    this.vwC = ((MMScrollView)findViewById(2131301943));
    this.vwD = ((TextView)findViewById(2131301901));
    this.vMo = ((RelativeLayout)findViewById(2131301802));
    this.vMp = ((TextView)findViewById(2131301808));
    this.vMq = ((TextView)findViewById(2131307213));
    this.vMr = ((ImageView)findViewById(2131301801));
    this.vMs = ((ImageView)findViewById(2131301800));
    this.vMt = ((ImageView)findViewById(2131301803));
    this.vMu = ((TextView)findViewById(2131301804));
    this.vIr = new a(this);
    this.vIs = getLayoutInflater().inflate(2131494640, null);
    this.vIr.setContentView(this.vIs, new ViewGroup.LayoutParams(-1, -1));
    this.vIs.findViewById(2131301796).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65851);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65851);
      }
    });
    this.vIr.vGq = new a.a()
    {
      public final void dlZ()
      {
        AppMethodBeat.i(65865);
        LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
        AppMethodBeat.o(65865);
      }
    };
    this.vIB = ((ViewGroup)this.vIs.findViewById(2131301798));
    this.vIz = com.tencent.mm.pluginsdk.ui.chat.e.Fwh.eE(getContext());
    this.vMA = getIntent().getStringExtra("key_username");
    this.vIz.setTalkerName(this.vMA);
    this.vIz.setShowSmiley(false);
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
      this.vDG.setTitle(getString(2131760978));
      this.vDG.setShowGroupIcon(true);
      localObject1 = new LinearLayout.LayoutParams(-1, -1);
      localObject2 = new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.ax(this, 2131166515));
      if (this.mType != 1) {
        break label1356;
      }
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 13);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 13);
      this.vwy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.vMo.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.vDG.setOnInputValidChangerListener(this);
      this.vDG.setHint(getString(2131760895));
      this.vww.setOnInputValidChangerListener(this);
      this.vww.setHint(getString(2131760911));
      this.vwy.setOnInputValidChangerListener(this);
      if (!al.isDarkMode()) {
        break label1386;
      }
      this.vMt.setImageResource(2131233108);
      localObject1 = (EditText)this.vDG.findViewById(2131301810);
      localObject2 = (EditText)this.vww.findViewById(2131301810);
      com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText((EditText)localObject1);
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
          this.vwH.setContentDescription(paramAnonymousEditable.toString());
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          this.val$hintTv.setOnClickListener(null);
          this.vwH.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ai(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ai(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
          LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65840);
        }
      });
      ((EditText)localObject1).requestFocus();
      localObject3 = (TextView)this.vDG.findViewById(2131301716);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65841);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            this.val$hintTv.setOnClickListener(null);
            this.vwH.setOnClickListener(null);
            LuckyMoneyPrepareUI.this.ai(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
            LuckyMoneyPrepareUI.this.ai(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
            LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
            LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(this.val$hintTv);
            LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65841);
          }
        });
      }
      com.tencent.mm.wallet_core.ui.f.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65842);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          this.val$hintTv.setOnClickListener(null);
          this.vwH.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ai(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ai(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
          LuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65842);
        }
      });
      ((MMEditText)this.vwy.findViewById(2131301944)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(65843);
          this.val$hintTv.setOnClickListener(null);
          this.vwH.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ai(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ai(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(65843);
        }
      });
      if (this.vvL != null)
      {
        if (this.mType != 1) {
          break label1399;
        }
        this.vDG.setMaxAmount(this.vvL.vvk);
        this.vDG.setMinAmount(this.vvL.vvj);
        if (this.vvL.phn != 1) {
          aqk(this.vvL.vvn);
        }
      }
      if ((!this.vDN) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1416;
      }
      this.vww.setNum("1");
      label951:
      this.vww.setMaxNum(this.vvL.vvh);
      this.vww.setMinNum(1);
      ae.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.vww.getInput());
      this.vDG.setMaxLen(12);
      if (dmF()) {
        this.vwz.setText(getString(2131760935, new Object[] { this.vvL.vAd }));
      }
      if ((!this.vDN) && (this.fRv != 2)) {
        break label1875;
      }
      if (!dmF()) {
        break label1429;
      }
      setMMTitle(getString(2131760976, new Object[] { this.vvL.vAd }));
      label1093:
      i = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.vDN) || (i != 0)) {
        break label1439;
      }
      ae.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
      this.vww.setVisibility(8);
    }
    for (;;)
    {
      this.vwz.setOnClickListener(new w()
      {
        public final void ccc()
        {
          AppMethodBeat.i(65880);
          LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new ea());
          LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).eeh = 6L;
          LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aLH();
          if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(LuckyMoneyPrepareUI.this))
          {
            ae.w("MicroMsg.LuckyMoneyPrepareUI", "can not request hb while authen");
            com.tencent.mm.plugin.report.service.g.yxI.dD(965, 55);
            AppMethodBeat.o(65880);
            return;
          }
          LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this);
          AppMethodBeat.o(65880);
        }
      });
      this.vwF.a(this.vww);
      this.vwF.a(this.vDG);
      this.vwF.a(this.vwy);
      localObject1 = (TextView)findViewById(2131301898);
      this.vwF.m((TextView)localObject1);
      this.jnx = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(65881);
          int i;
          double d2;
          if ((LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).dkP() != 3) && (LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).dkP() != 3))
          {
            i = LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).getInput();
            d2 = LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).getInput();
            d1 = d2;
            if (LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this) != 0) {}
          }
          for (double d1 = d2 * i;; d1 = 0.0D)
          {
            if ((d1 == 0.0D) || (d1 > LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).vvk) || (LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).dmp()))
            {
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setClickable(false);
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setEnabled(false);
            }
            for (;;)
            {
              ae.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).dmp());
              LuckyMoneyPrepareUI.l(LuckyMoneyPrepareUI.this).foU();
              AppMethodBeat.o(65881);
              return false;
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setClickable(true);
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setEnabled(true);
            }
          }
        }
      }, false);
      if (this.vwC != null) {
        this.vwC.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(65828);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              LuckyMoneyPrepareUI.this.hideTenpayKB();
              LuckyMoneyPrepareUI.this.hideVKB();
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(65828);
            return false;
          }
        });
      }
      this.vDG.setType(this.mType);
      init();
      final boolean bool = com.tencent.mm.y.c.ahI().a(am.a.IWR, am.a.IWT);
      this.vMo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(65834);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          ae.d("MicroMsg.LuckyMoneyPrepareUI", "click envelope layout: %s", new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this)) });
          if (LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this) == 0)
          {
            LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null, false, bool);
            paramAnonymousView = com.tencent.mm.plugin.report.service.g.yxI;
            if (!bool) {
              break label212;
            }
          }
          label212:
          for (int i = 2;; i = 1)
          {
            paramAnonymousView.f(18890, new Object[] { Integer.valueOf(2), Integer.valueOf(i), LuckyMoneyPrepareUI.x(LuckyMoneyPrepareUI.this) });
            com.tencent.mm.plugin.report.service.g.yxI.f(16822, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65834);
            return;
            paramAnonymousView = z.fO(LuckyMoneyPrepareUI.this.getContext());
            localObject = com.tencent.mm.plugin.luckymoney.model.g.dlf();
            ((com.tencent.mm.plugin.luckymoney.model.g)localObject).b(new com.tencent.mm.plugin.luckymoney.model.c(""));
            ((com.tencent.mm.wallet_core.c.a)localObject).a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
            break;
          }
        }
      });
      if (bool) {
        this.vMu.setVisibility(0);
      }
      if (this.vAg != null) {
        b(this.vAg.vzN);
      }
      AppMethodBeat.o(65886);
      return;
      setMMTitle(2131760909);
      this.vDG.setTitle(getString(2131760979));
      this.vDG.setShowGroupIcon(false);
      break;
      label1356:
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
      break label565;
      label1386:
      this.vMt.setImageResource(2131233107);
      break label650;
      label1399:
      this.vDG.setMaxAmount(this.vvL.vvi);
      break label883;
      label1416:
      this.vww.setNum("");
      break label951;
      label1429:
      setMMTitle(2131760975);
      break label1093;
      label1439:
      localObject2 = getString(2131760867);
      Object localObject4 = getString(2131760882);
      localObject1 = getString(2131760861);
      localObject3 = getString(2131760883);
      Object localObject5;
      if ((this.vDN) && (i > 0))
      {
        ae.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", new Object[] { Integer.valueOf(i) });
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
        this.vDG.setGroupIconIv(2131233029);
        ((com.tencent.mm.plugin.wallet_core.ui.l)localObject5).Dxw = new l.a()
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
              LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setAmount(com.tencent.mm.wallet_core.ui.f.C(d / i));
            }
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setMaxAmount(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).vvi);
            LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this).setText(this.vwL);
            com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
            AppMethodBeat.o(65877);
          }
        };
        ((com.tencent.mm.plugin.wallet_core.ui.l)localObject4).Dxw = new l.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65878);
            int i = LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).getInput();
            double d = LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).getInput();
            LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 1);
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setType(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this));
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setMaxAmount(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).vvk);
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setTitle(LuckyMoneyPrepareUI.this.getString(2131760978));
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setShowGroupIcon(true);
            if ((d > 0.0D) && (i > 0)) {
              LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setAmount(com.tencent.mm.wallet_core.ui.f.C(d * i));
            }
            LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this).setText(localSpannableString);
            com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
            AppMethodBeat.o(65878);
          }
        };
        this.mpP.setMovementMethod(LinkMovementMethod.getInstance());
        if (com.tencent.mm.ui.a.a.a.fCh().fCg()) {
          this.mpP.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65879);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              if (!com.tencent.mm.ui.a.a.a.fCh().fCg())
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65879);
                return;
              }
              if (LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this).getText().toString().equals(localSpannableString.toString())) {
                this.vNd.onClick(paramAnonymousView);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65879);
                return;
                this.vNe.onClick(paramAnonymousView);
              }
            }
          });
        }
        this.mpP.setTextColor(getResources().getColor(2131100021));
        this.mpP.setText(localSpannableString);
        this.mpP.setVisibility(0);
        break;
        if (this.fRv == 2)
        {
          ae.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
          this.vwy.setVisibility(8);
        }
      }
      label1875:
      if (this.mType == 1)
      {
        this.mpP.setText(this.vvL.vzZ);
        this.mpP.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.mpP.setText(this.vvL.vAa);
        this.mpP.setVisibility(0);
      }
    }
  }
  
  public final void j(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65902);
    if (paramIntent.hasExtra("key_realname_guide_helper")) {
      this.vMy = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
    }
    if (paramInt == -1)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(dlG()), Integer.valueOf(5) });
      Object localObject1 = getIntent().getStringExtra("key_username");
      if ((this.vDN) && (!bu.isNullOrNil((String)localObject1)))
      {
        com.tencent.mm.ui.base.h.cm(this, getString(2131760233));
        Object localObject2 = bx.M(this.vDO, "msg");
        if (localObject2 == null)
        {
          ae.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
          finish();
          AppMethodBeat.o(65902);
          return;
        }
        localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
        if (com.tencent.mm.plugin.luckymoney.b.a.dkG().dkJ().apY((String)localObject2))
        {
          ae.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
          if (!z.Z(this.vDO, (String)localObject1, 1))
          {
            ae.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
            com.tencent.mm.plugin.luckymoney.b.a.dkG().dkJ().apZ((String)localObject2);
          }
          h(paramInt, paramIntent);
          localObject1 = new com.tencent.mm.plugin.luckymoney.story.b.e();
          ((com.tencent.mm.plugin.luckymoney.story.b.e)localObject1).field_send_id = ((String)localObject2);
          if (!com.tencent.mm.plugin.luckymoney.b.a.dkG().dkF().get((com.tencent.mm.sdk.e.c)localObject1, new String[0]))
          {
            ((com.tencent.mm.plugin.luckymoney.story.b.e)localObject1).field_open_count = 0;
            ae.d("MicroMsg.LuckyMoneyPrepareUI", "insert record: %s, %s", new Object[] { localObject2, Boolean.valueOf(com.tencent.mm.plugin.luckymoney.b.a.dkG().dkF().insert((com.tencent.mm.sdk.e.c)localObject1)) });
          }
          this.vMB = new eb();
          this.vMB.eiS = this.vKK;
          if (this.pOS != null) {
            break label418;
          }
          localObject1 = "";
          label340:
          this.vMB.nC((String)localObject1);
          this.vMB.aLH();
          ae.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.vKK), localObject1 });
          finish();
        }
      }
      for (;;)
      {
        aql(paramIntent.getStringExtra("key_trans_id"));
        AppMethodBeat.o(65902);
        return;
        ae.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
        break;
        label418:
        localObject1 = this.pOS.Lj();
        break label340;
        dme();
        localObject1 = findViewById(2131301906);
        this.vDH.setVisibility(0);
        z.a((View)localObject1, null);
        this.pUO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65868);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
            z.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.G(LuckyMoneyPrepareUI.this), true);
            LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65867);
                LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
                LuckyMoneyPrepareUI.this.dmd();
                AppMethodBeat.o(65867);
              }
            }, 100L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65868);
          }
        });
        ((ImageView)findViewById(2131301897)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65869);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
            LuckyMoneyPrepareUI.this.dmd();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        this.vMy = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
      }
      Object localObject1;
      if (paramInt2 == -1)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(dlG()), Integer.valueOf(5) });
        localObject1 = getIntent().getStringExtra("key_username");
        if ((this.vDN) && (!bu.isNullOrNil((String)localObject1)))
        {
          Object localObject2 = bx.M(this.vDO, "msg");
          if (localObject2 == null)
          {
            ae.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65900);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.dkG().dkJ().apY((String)localObject2))
          {
            ae.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!z.Z(this.vDO, (String)localObject1, 1))
            {
              ae.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.dkG().dkJ().apZ((String)localObject2);
            }
            label297:
            h(paramInt2, paramIntent);
            this.vMB = new eb();
            this.vMB.eiS = this.vKK;
            if (this.pOS != null) {
              break label427;
            }
            localObject1 = "";
            label338:
            this.vMB.nC((String)localObject1);
            this.vMB.aLH();
            ae.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.vKK), localObject1 });
            finish();
          }
        }
        for (;;)
        {
          localObject1 = "";
          if (paramIntent != null) {
            localObject1 = paramIntent.getStringExtra("key_trans_id");
          }
          aql((String)localObject1);
          break;
          ae.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          break label297;
          label427:
          localObject1 = this.pOS.Lj();
          break label338;
          dme();
          localObject1 = findViewById(2131301906);
          this.vDH.setVisibility(0);
          z.a((View)localObject1, null);
          this.pUO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65864);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
              z.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.G(LuckyMoneyPrepareUI.this), true);
              LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(65863);
                  LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
                  LuckyMoneyPrepareUI.this.dmd();
                  AppMethodBeat.o(65863);
                }
              }, 100L);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65864);
            }
          });
          ((ImageView)findViewById(2131301897)).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65866);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
              LuckyMoneyPrepareUI.this.dmd();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65866);
            }
          });
          h(paramInt2, paramIntent);
        }
      }
      if (com.tencent.mm.wallet_core.c.ag.bx(paramIntent))
      {
        finish();
        AppMethodBeat.o(65900);
        return;
      }
      if (com.tencent.mm.wallet_core.c.ag.by(paramIntent))
      {
        AppMethodBeat.o(65900);
        return;
      }
      h(paramInt2, paramIntent);
      continue;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(dlG()), Integer.valueOf(7), localObject1 });
        if (!bu.isNullOrNil((String)localObject1)) {
          doSceneProgress(new at(((String)localObject1).replaceAll(",", "|"), this.vDL, "v1.0"));
        } else {
          finish();
        }
      }
      else if (paramInt2 == 0)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(getContext(), LuckyMoneyMyRecordUI.class);
        ((Intent)localObject1).putExtra("key_type", 1);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
        if ((paramIntent != null) && (paramIntent.hasExtra("result_data")))
        {
          localObject1 = paramIntent.getBundleExtra("result_data");
          if (localObject1 != null)
          {
            int i = bu.getInt(((Bundle)localObject1).getString("payState", "2"), 0);
            ae.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i + ";STATE_H5_PAY_SUCC=0");
            if (i == 0) {
              finish();
            }
          }
          else
          {
            ae.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
            continue;
            i(paramInt2, paramIntent);
            continue;
            if (paramInt2 == -1)
            {
              this.vDJ.removeAllViews();
              oj(true);
            }
            else
            {
              oj(false);
              com.tencent.mm.plugin.report.service.g.yxI.f(16822, new Object[] { Integer.valueOf(2) });
              continue;
              if (paramInt2 == -1)
              {
                localObject1 = "";
                if (paramIntent != null) {
                  localObject1 = paramIntent.getStringExtra("gif_md5");
                }
                if (!bu.isNullOrNil((String)localObject1))
                {
                  this.pOS = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.aWl((String)localObject1);
                  B(this.pOS);
                }
                else
                {
                  ae.i("MicroMsg.LuckyMoneyPrepareUI", "md5 == null go emoji capture failed!");
                }
              }
              else
              {
                ae.i("MicroMsg.LuckyMoneyPrepareUI", "go emoji capture failed!");
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
    this.vDK = getIntent().getIntExtra("key_way", 3);
    this.fRv = getIntent().getIntExtra("key_from", 0);
    if (this.fRv == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.vDN = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      this.mSessionId = getIntent().getStringExtra("key_session_id");
      oj(false);
      com.tencent.mm.plugin.luckymoney.b.a.dkG();
      this.vvL = com.tencent.mm.plugin.luckymoney.b.a.dkH().dlk();
      com.tencent.mm.plugin.luckymoney.b.a.dkG();
      this.vAg = com.tencent.mm.plugin.luckymoney.b.a.dkH().dll();
      ae.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.vDK + "mChannel:" + this.mChannel);
      ae.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.vDN + ", config " + this.vvL);
      initView();
      com.tencent.mm.sdk.b.a.IvT.b(this.vMR);
      this.mPayLoopInterruptListener.alive();
      com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(dlG()), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.b.fVf();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.qDk, true);
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.fZs();
      AppMethodBeat.o(65883);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65893);
    super.onDestroy();
    this.vwF.clear();
    this.jnx.foU();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.vIz != null)
    {
      ae.i("MicroMsg.LuckyMoneyPrepareUI", "commentfooter release");
      this.vIz.onPause();
      this.vIz.ffs();
      this.vIz.destroy();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.vMR);
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
    ae.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.aq))
    {
      if (this.vMQ)
      {
        ae.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
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
          this.vDM = localaq.pgV;
          this.vDL = localaq.vwq;
          this.vDO = localaq.vCE;
          this.vHa = localaq.vwq;
          this.vMz = localaq.vCI;
          if (!((com.tencent.mm.plugin.luckymoney.model.aq)paramn).isJumpRemind()) {
            break;
          }
          ae.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() NetScenePrepareLuckyMoney show JumpRemind Alert");
          ((com.tencent.mm.plugin.luckymoney.model.aq)paramn).jumpRemind.a(this, new com.tencent.mm.wallet_core.c.h()
          {
            public final void bu(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(65848);
              ae.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onNext()");
              if ((bu.jB(paramAnonymousInt, 2)) && (bu.lX(paramAnonymousString, "requestwxhb")))
              {
                LuckyMoneyPrepareUI.z(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(65848);
                return;
              }
              if (bu.jB(paramAnonymousInt, 1)) {
                com.tencent.mm.plugin.account.a.b.a.b(LuckyMoneyPrepareUI.this, paramAnonymousString, 0, true);
              }
              AppMethodBeat.o(65848);
            }
            
            public final void onCancel()
            {
              AppMethodBeat.i(65849);
              ae.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onCancel()");
              AppMethodBeat.o(65849);
            }
          });
          AppMethodBeat.o(65896);
          return true;
        }
        paramString = new PayInfo();
        paramString.dmw = localaq.tsf;
        paramString.dDH = 37;
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
        this.vwz.setEnabled(false);
        this.vwz.setClickable(false);
        this.jnx.ay(5000L, 5000L);
        com.tencent.mm.ui.base.h.cm(this, paramString);
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
            if (com.tencent.mm.plugin.luckymoney.model.aq.j(paramn))
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
      this.dGt = 2;
      paramn = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramn = getString(2131765901);
      }
      com.tencent.mm.ui.base.h.a(this, paramn, null, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(65844);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(65844);
        }
      });
      AppMethodBeat.o(65896);
      return true;
    }
    if ((paramn instanceof at))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.vDN)
        {
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65852);
              LuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(65852);
            }
          }, 1800L);
        }
        for (;;)
        {
          AppMethodBeat.o(65896);
          return true;
          dme();
          this.vDI.setVisibility(0);
          this.vDI.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65853);
              Object localObject = new Intent();
              ((Intent)localObject).setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyIndexUI.class);
              ((Intent)localObject).addFlags(67108864);
              AppCompatActivity localAppCompatActivity = LuckyMoneyPrepareUI.this.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$31", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localAppCompatActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localAppCompatActivity, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$31", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              LuckyMoneyPrepareUI.this.finish();
              AppMethodBeat.o(65853);
            }
          }, 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.e(getContext(), paramString, "", getString(2131760958), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(65854);
            Object localObject = new Intent();
            ((Intent)localObject).setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyMyRecordUI.class);
            ((Intent)localObject).putExtra("key_type", 1);
            paramAnonymousDialogInterface = LuckyMoneyPrepareUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(65854);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(65896);
        return true;
      }
    }
    else
    {
      if ((paramn instanceof ai))
      {
        ae.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString);
        if ((this.vMm != null) && (this.vMm.isShowing())) {
          this.vMm.dismiss();
        }
        if ((this.vMn != null) && (this.vMn.isShowing())) {
          this.vMn.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (ai)paramn;
          this.vMN = true;
          this.vCt = paramString.vCt;
          if (!bu.jB(paramString.vCu, 1))
          {
            this.vwy.ok(true);
            com.tencent.mm.plugin.luckymoney.b.a.dkG();
            this.vvL = com.tencent.mm.plugin.luckymoney.b.a.dkH().dlk();
            ae.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.vvL);
            if (this.mType != 1) {
              break label1494;
            }
            this.vDG.setMaxAmount(this.vvL.vvk);
            label869:
            this.vDG.setMinAmount(this.vvL.vvj);
            this.vww.setMaxNum(this.vvL.vvh);
            this.vMw = paramString.vvm;
            this.vMv = paramString.phn;
            this.vMx = paramString.vvw;
            if (bu.isNullOrNil(this.vKR)) {
              this.vKR = paramString.dCl;
            }
            if ((!bu.isNullOrNil(this.vMx)) && (this.vwy != null)) {
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(65858);
                  LuckyMoneyPrepareUI.D(LuckyMoneyPrepareUI.this).setHintText(LuckyMoneyPrepareUI.E(LuckyMoneyPrepareUI.this));
                  AppMethodBeat.o(65858);
                }
              });
            }
            if ((paramString.vCk) && (this.vDN))
            {
              paramn = (TextView)findViewById(2131301899);
              paramn.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(65859);
                  Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                  com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(9) });
                  localObject = new Intent();
                  ((Intent)localObject).setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyCanShareListUI.class);
                  paramAnonymousView = LuckyMoneyPrepareUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$36", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$36", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(65859);
                }
              });
              com.tencent.mm.plugin.report.service.g.yxI.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(dlG()), Integer.valueOf(8) });
              paramn.setVisibility(8);
            }
            if (bu.isNullOrNil(paramString.iWA)) {
              break label1511;
            }
            ae.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.iWA);
            this.vwD.setText(paramString.iWA);
            if (!bu.isNullOrNil(paramString.vCm)) {
              this.vwD.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(65860);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  com.tencent.mm.wallet_core.ui.f.p(LuckyMoneyPrepareUI.this.getContext(), paramString.vCm, false);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(65860);
                }
              });
            }
            this.vwD.setVisibility(0);
            label1146:
            paramn = new h.c();
            if ((paramString.vCo == null) || (bu.isNullOrNil(paramString.vCo.content))) {
              break label1523;
            }
            paramn.textColor = getResources().getColor(2131101114);
            label1190:
            this.vDJ.removeAllViews();
            h.a(this, this.vDJ, paramString.vCo, paramn);
            aqk(paramString.vvn);
            if (this.vMv == 1) {
              break label1541;
            }
            b(this.vDG.getInput(), this.vMw);
            label1242:
            com.tencent.mm.plugin.luckymoney.b.a.dkG();
            this.vAg = com.tencent.mm.plugin.luckymoney.b.a.dkH().dll();
            init();
            if (this.vAg == null) {
              break label1567;
            }
            if (this.vAg.vzN != null)
            {
              this.vMC = this.vAg.vzN.HbO;
              this.vMD = this.vAg.vzN.HbM;
              this.vME = this.vAg.vzN.HbN;
            }
            b(this.vAg.vzN);
            com.tencent.mm.plugin.report.service.g.yxI.dD(991, 10);
            label1341:
            if (this.vMP)
            {
              ae.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick()");
              a(this.vMG, this.vMH, this.vMI, this.vMJ, this.vMK, this.vML);
            }
          }
        }
        for (;;)
        {
          ae.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig waitingGetConfig:%s ifAutoRMBPrePareBtn:%s", new Object[] { Boolean.valueOf(this.vMO), Boolean.valueOf(this.vMP) });
          this.vMO = false;
          this.vMP = false;
          AppMethodBeat.o(65896);
          return true;
          this.vwy.ok(false);
          if ((this.pOS != null) && (!bu.isNullOrNil(this.pOS.Lj()))) {
            this.vwy.B(this.pOS);
          }
          this.vwy.setmOnEmojiSelectClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65857);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new ea());
              LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).eeh = 2L;
              LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aLH();
              final boolean bool = bu.K(paramAnonymousView.getTag(), "delete");
              if ((!bool) && (!bu.jB(paramString.vCt, 1)))
              {
                LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, 2);
                LuckyMoneyPrepareUI.A(LuckyMoneyPrepareUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65857);
                return;
              }
              paramAnonymousView = new com.tencent.mm.ui.widget.d(LuckyMoneyPrepareUI.this.getContext(), 1, false);
              paramAnonymousView.LfS = new n.d()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(65855);
                  if (!bool)
                  {
                    if (bu.jB(LuckyMoneyPrepareUI.27.this.vDQ.vCt, 1)) {
                      paramAnonymous2l.jM(1, 2131760908);
                    }
                    paramAnonymous2l.jM(2, 2131760952);
                    AppMethodBeat.o(65855);
                    return;
                  }
                  paramAnonymous2l.a(3, LuckyMoneyPrepareUI.this.getResources().getColor(2131100596), LuckyMoneyPrepareUI.this.getContext().getString(2131760844));
                  AppMethodBeat.o(65855);
                }
              };
              paramAnonymousView.LfT = new n.e()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(65856);
                  ae.i("MicroMsg.LuckyMoneyPrepareUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()) });
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(65856);
                    return;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, 1);
                    com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyPrepareUI.this, 4, LuckyMoneyPrepareUI.B(LuckyMoneyPrepareUI.this));
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new ea());
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).eeh = 4L;
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aLH();
                    AppMethodBeat.o(65856);
                    return;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, 2);
                    LuckyMoneyPrepareUI.A(LuckyMoneyPrepareUI.this);
                    AppMethodBeat.o(65856);
                    return;
                    LuckyMoneyPrepareUI.C(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem = LuckyMoneyPrepareUI.D(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem.vNi.setTag("");
                    paramAnonymous2MenuItem.vNj.setVisibility(0);
                    paramAnonymous2MenuItem.vNk.setVisibility(8);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new ea());
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).eeh = 5L;
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aLH();
                  }
                }
              };
              paramAnonymousView.cPF();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65857);
            }
          });
          break;
          label1494:
          this.vDG.setMaxAmount(this.vvL.vvi);
          break label869;
          label1511:
          this.vwD.setVisibility(8);
          break label1146;
          label1523:
          paramn.textColor = getResources().getColor(2131100482);
          break label1190;
          label1541:
          if (this.mType != 1) {
            break label1242;
          }
          b(this.vDG.getInput(), this.vMw);
          break label1242;
          label1567:
          b(null);
          break label1341;
          if (this.vMP)
          {
            paramn = paramString;
            if (bu.isNullOrNil(paramString)) {
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
          paramString = ((com.tencent.mm.plugin.luckymoney.model.aj)paramn).phy;
          if (!bu.isNullOrNil(paramString))
          {
            ae.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
            com.tencent.mm.wallet_core.ui.f.a(getContext(), paramString, false, 3);
          }
          for (;;)
          {
            AppMethodBeat.o(65896);
            return true;
            ae.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
          }
        }
      }
      else
      {
        if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.d))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_F2F_HONGBAO_PAY_SWTICH_KEY"))) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if ((this.tipDialog != null) && (this.tipDialog.isShowing()) && (paramInt1 == 0)) {
                this.tipDialog.dismiss();
              }
              paramString = (com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn;
              if (!com.tencent.mm.plugin.wallet_core.utils.c.a(paramString.vxH.GyE)) {
                break;
              }
              if (this.tipDialog != null) {
                this.tipDialog.dismiss();
              }
              new com.tencent.mm.plugin.wallet_core.utils.c(this).b(paramString.vxH.GyE);
              AppMethodBeat.o(65896);
              return true;
            }
            this.vHa = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn).vwq;
            this.vMz = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn).vxI;
            paramString = new PayInfo();
            paramString.dmw = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn).dmw;
            paramString.dDH = 37;
            if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_F2F_HONGBAO_PAY_SWTICH_KEY")))
            {
              if (paramString.hwN == null) {
                paramString.hwN = new Bundle();
              }
              paramString.hwN.putBoolean("isF2FHongBao", true);
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, paramString);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(65896);
            return true;
            af.w(37, paramString.dmw, paramInt2);
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, 4);
            continue;
            af.w(37, "", paramInt2);
            if (!bu.isNullOrNil(paramString)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */