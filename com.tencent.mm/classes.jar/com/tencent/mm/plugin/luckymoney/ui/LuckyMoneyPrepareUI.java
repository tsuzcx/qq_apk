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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
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
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.g.b.a.dy;
import com.tencent.mm.g.b.a.dz;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.luckymoney.model.ab;
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
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bd;
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
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements g
{
  private int dFo;
  private int fPp;
  private av jkD;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private boolean mKindaEnable;
  private com.tencent.mm.sdk.b.c<op> mPayLoopInterruptListener;
  private String mSessionId;
  private int mType;
  private TextView mkS;
  private EmojiInfo pIn;
  private Button pOj;
  private TextView peG;
  public Dialog tipDialog;
  private String vAA;
  private boolean vAB;
  private int vAC;
  private String vAD;
  private int vAE;
  private long vAF;
  private long vAG;
  private String vAH;
  private com.tencent.mm.ui.widget.d vAI;
  private boolean vAJ;
  private boolean vAK;
  private boolean vAL;
  private boolean vAM;
  private com.tencent.mm.sdk.b.c<tu> vAN;
  private Dialog vAi;
  private Dialog vAj;
  private RelativeLayout vAk;
  private TextView vAl;
  private TextView vAm;
  private ImageView vAn;
  private ImageView vAo;
  private ImageView vAp;
  private TextView vAq;
  private int vAr;
  private String vAs;
  private String vAt;
  private RealnameGuideHelper vAu;
  private String vAv;
  private String vAw;
  private dz vAx;
  private int vAy;
  private String vAz;
  private j vjG;
  private b vkA;
  private LuckyMoneyNumInputView vkr;
  private LuckyMoneyTextInputView vkt;
  private Button vku;
  private MMScrollView vkx;
  private TextView vky;
  private com.tencent.mm.plugin.luckymoney.model.e vob;
  private int vqo;
  private LuckyMoneyMoneyInputView vrB;
  private View vrC;
  private View vrD;
  private ViewGroup vrE;
  private int vrF;
  private String vrG;
  private int vrH;
  private boolean vrI;
  private String vrJ;
  private String vuW;
  private int vwC;
  private a vwn;
  private View vwo;
  private ChatFooterPanel vwv;
  private ViewGroup vwx;
  private dy vwz;
  private int vyG;
  private String vyN;
  private String vyQ;
  
  public LuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(65882);
    this.vkr = null;
    this.vrB = null;
    this.vkt = null;
    this.peG = null;
    this.vku = null;
    this.pOj = null;
    this.tipDialog = null;
    this.vAi = null;
    this.vAj = null;
    this.vkA = new b();
    this.jkD = null;
    this.vAr = 1;
    this.vAs = com.tencent.mm.wallet_core.ui.e.aYF("CNY");
    this.vAt = null;
    this.vuW = "";
    this.vyG = 1;
    this.vwC = 0;
    this.vAB = false;
    this.mPayLoopInterruptListener = new LuckyMoneyPrepareUI.1(this);
    this.vAJ = false;
    this.vAK = false;
    this.vAL = false;
    this.vAM = false;
    this.vAN = new com.tencent.mm.sdk.b.c() {};
    this.dFo = 0;
    this.vyQ = "";
    AppMethodBeat.o(65882);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(65897);
    this.vkt.A(paramEmojiInfo);
    if ((this.vwC == 0) || (this.vwC == 2)) {
      if (com.tencent.mm.plugin.emoji.h.b.y(paramEmojiInfo)) {
        this.vyG = 2;
      }
    }
    for (;;)
    {
      this.vwz = new dy();
      this.vwz.ecM = 1L;
      this.vwz.aLk();
      AppMethodBeat.o(65897);
      return;
      if (com.tencent.mm.plugin.emoji.h.b.w(paramEmojiInfo))
      {
        this.vyG = 4;
      }
      else
      {
        this.vyG = 3;
        continue;
        if (this.vwC == 1) {
          this.vyG = 2;
        }
      }
    }
  }
  
  private void Jz(int paramInt)
  {
    AppMethodBeat.i(65888);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() userConfirmJump:%s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(diH()), Integer.valueOf(4) });
    com.tencent.mm.plugin.report.service.g.yhR.f(15511, new Object[] { Integer.valueOf(this.vAr), Integer.valueOf(2) });
    if (this.vrB.dhQ() != 0)
    {
      t.makeText(getContext(), 2131765031, 0).show();
      AppMethodBeat.o(65888);
      return;
    }
    int i = this.vkr.getInput();
    double d = this.vrB.getInput();
    long l2 = 0L;
    long l1;
    if (this.mType == 1)
    {
      l1 = com.tencent.mm.wallet_core.ui.e.E(d);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(356354, Integer.valueOf(i));
      str = this.vkt.getInput().replace("\r", "").replace("\n", "");
      localObject = str;
      if (bt.isNullOrNil(str)) {
        if (!bt.isNullOrNil(this.vAt)) {
          break label336;
        }
      }
    }
    label336:
    for (Object localObject = getString(2131760843);; localObject = this.vAt)
    {
      hideTenpayKB();
      if (this.fPp != 2) {
        break label345;
      }
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.d(i, (int)l1, this.mType, (int)l2), false);
      djF();
      AppMethodBeat.o(65888);
      return;
      l1 = com.tencent.mm.wallet_core.ui.e.E(i * d);
      l2 = com.tencent.mm.wallet_core.ui.e.E(d);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(356353, Integer.valueOf(i));
      break;
    }
    label345:
    String str = getIntent().getStringExtra("key_username");
    if (this.vAr == 1)
    {
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() ifGetConfig=%s mUniqueId=%s waitingGetConfig=%s ifAutoRMBPrePareBtn=%s", new Object[] { Boolean.valueOf(this.vAJ), bt.nullAsNil(this.vyN), Boolean.valueOf(this.vAK), Boolean.valueOf(this.vAL) });
      if (this.vAJ)
      {
        a(paramInt, str, i, l1, l2, (String)localObject);
        AppMethodBeat.o(65888);
        return;
      }
      this.vAL = true;
      this.vAC = paramInt;
      this.vAD = str;
      this.vAE = i;
      this.vAF = l1;
      this.vAG = l2;
      this.vAH = ((String)localObject);
      if (this.vAj != null) {
        this.vAj.show();
      }
      for (;;)
      {
        if (!this.vAK) {
          oe(false);
        }
        AppMethodBeat.o(65888);
        return;
        this.vAj = com.tencent.mm.ui.base.h.a(this, 3, 2131820985, getString(2131760709), true, new DialogInterface.OnCancelListener()
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
            LuckyMoneyPrepareUI.this.vuU.forceCancel();
            AppMethodBeat.o(65829);
          }
        });
      }
    }
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "currency=%s userConfiremJump:%s", new Object[] { Integer.valueOf(this.vAr), Integer.valueOf(paramInt) });
    addSceneEndListener(1647);
    if ((this.vrI) && (!bt.isNullOrNil(str))) {}
    for (localObject = new aj(i, l1, l2, this.mType, (String)localObject, str, z.diq(), com.tencent.mm.model.u.aAm(), this.vAr);; localObject = new aj(i, l1, l2, this.mType, (String)localObject, null, z.diq(), com.tencent.mm.model.u.aAm(), this.vAr))
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
    if (this.pIn != null)
    {
      str2 = this.pIn.Lb();
      i = this.pIn.field_type;
    }
    String str1 = "";
    if (this.vob != null) {
      str1 = this.vob.vnJ;
    }
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB. userConfirmJump:%s lastPayResult:%s mSendId:%s mUniqueId:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.dFo), this.vuW, this.vyN });
    if ((this.vrI) && (!bt.isNullOrNil(paramString1))) {}
    for (paramString1 = new com.tencent.mm.plugin.luckymoney.model.aq(paramInt2, paramLong1, paramLong2, this.mType, paramString2, z.diq(), paramString1, z.ze(paramString1), com.tencent.mm.model.u.aAm(), com.tencent.mm.model.u.aAo(), this.vrF, str1, this.vyN, paramInt1, this.dFo, this.vuW, str2, i);; paramString1 = new com.tencent.mm.plugin.luckymoney.model.aq(paramInt2, paramLong1, paramLong2, this.mType, paramString2, z.diq(), null, null, com.tencent.mm.model.u.aAm(), com.tencent.mm.model.u.aAo(), this.vrF, str1, this.vyN, paramInt1, this.dFo, this.vuW, str2, i))
    {
      doSceneProgress(paramString1, false);
      if (!bt.isNullOrNil(str1)) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(991, 11);
      }
      djF();
      AppMethodBeat.o(65890);
      return;
    }
  }
  
  private void apf(String paramString)
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
  
  private void apg(String paramString)
  {
    AppMethodBeat.i(65911);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ag(this.vuW, paramString, this.vAv), false);
    AppMethodBeat.o(65911);
  }
  
  private void b(double paramDouble, String paramString)
  {
    AppMethodBeat.i(65908);
    if (bt.isNullOrNil(paramString))
    {
      this.peG.setText(com.tencent.mm.wallet_core.ui.e.D(paramDouble));
      AppMethodBeat.o(65908);
      return;
    }
    this.peG.setText(paramString + com.tencent.mm.wallet_core.ui.e.C(paramDouble));
    AppMethodBeat.o(65908);
  }
  
  private void b(bnu parambnu)
  {
    AppMethodBeat.i(65892);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "update envelope");
    if ((this.vob != null) && (parambnu != null) && (this.fPp != 2))
    {
      this.vAk.setVisibility(0);
      boolean bool = com.tencent.mm.z.c.aht().a(al.a.ICr, al.a.ICt);
      Object localObject;
      if (!this.vAB)
      {
        localObject = com.tencent.mm.plugin.report.service.g.yhR;
        if (!bool) {
          break label233;
        }
      }
      label233:
      for (int i = 2;; i = 1)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject).f(18890, new Object[] { Integer.valueOf(1), Integer.valueOf(i), this.mSessionId });
        this.vAB = true;
        if ((!this.vob.vnK) || (bt.isNullOrNil(this.vob.vnL))) {
          break label334;
        }
        localObject = bt.lO((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICv, ""), ",");
        Iterator localIterator = ((List)localObject).iterator();
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
        } while (!str.equals(this.vob.vnI.Gat));
        ad.d("MicroMsg.LuckyMoneyPrepareUI", "has alert illegal: %s", new Object[] { str });
        AppMethodBeat.o(65892);
        return;
      }
      ((List)localObject).add(this.vob.vnI.Gat);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICv, bt.m((List)localObject, ","));
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "show alert illegal: %s", new Object[] { this.vob.vnI.Gat });
      com.tencent.mm.ui.base.h.a(getContext(), this.vob.vnL, "", getString(2131766205), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      label334:
      if ((parambnu == null) || (parambnu.cOK != 1)) {
        break label448;
      }
      this.vAk.setEnabled(false);
      if (!bt.isNullOrNil(parambnu.GIn)) {
        this.vAl.setText(parambnu.GIn);
      }
      this.vAn.setImageBitmap(null);
      this.vAo.setVisibility(8);
      this.vAl.setTextColor(getResources().getColor(2131099660));
    }
    for (;;)
    {
      if ((parambnu == null) || (parambnu.hzE != 2)) {
        break label581;
      }
      this.vAm.setVisibility(0);
      AppMethodBeat.o(65892);
      return;
      this.vAk.setVisibility(8);
      break;
      label448:
      if ((parambnu != null) && (!bt.isNullOrNil(parambnu.GHY)))
      {
        this.vAk.setEnabled(true);
        this.vAl.setText(parambnu.GHY);
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.vAn, parambnu);
        this.vAo.setVisibility(0);
        this.vAl.setTextColor(getResources().getColor(2131100020));
      }
      else
      {
        this.vAk.setEnabled(true);
        this.vAn.setImageBitmap(null);
        this.vAl.setText("");
        this.vAo.setVisibility(0);
        this.vAl.setTextColor(getResources().getColor(2131100020));
      }
    }
    label581:
    this.vAm.setVisibility(8);
    AppMethodBeat.o(65892);
  }
  
  private int diH()
  {
    AppMethodBeat.i(65909);
    if (this.vrI)
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
  
  private void djF()
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
        LuckyMoneyPrepareUI.this.vuU.forceCancel();
        AppMethodBeat.o(65830);
      }
    });
    this.tipDialog.setCancelable(false);
    AppMethodBeat.o(65889);
  }
  
  private boolean djG()
  {
    AppMethodBeat.i(65907);
    if ((this.vjG != null) && (!bt.isNullOrNil(this.vjG.vnY)))
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
    String str2 = com.tencent.mm.model.u.aAm();
    if (paramInt == -1)
    {
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode == RESULT_OK");
      this.dFo = 1;
      this.vyQ = "";
      paramIntent = new an(this.vuW, this.vyN, 1, str2, bt.nullAsNil(str1));
      com.tencent.mm.kernel.g.ajB().gAO.a(paramIntent, 0);
      AppMethodBeat.o(65899);
      return;
    }
    if (paramIntent != null) {}
    for (this.dFo = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.dFo = 3)
    {
      this.vyQ = this.vuW;
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.dFo) });
      paramIntent = new an(this.vuW, this.vyN, this.dFo, str2, bt.nullAsNil(str1));
      break;
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "doNetSceneLuckyMoneyReport() data == null");
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(65891);
    if (this.vAr == 1)
    {
      addIconOptionMenu(0, 2131690603, new LuckyMoneyPrepareUI.5(this));
      AppMethodBeat.o(65891);
      return;
    }
    addIconOptionMenu(0, 2131233032, new LuckyMoneyPrepareUI.6(this));
    AppMethodBeat.o(65891);
  }
  
  private void oe(boolean paramBoolean)
  {
    AppMethodBeat.i(65894);
    ad.i("MicroMsg.LuckyMoneyPrepareUI", "do get config");
    if (paramBoolean) {
      this.vAi = z.fI(getContext());
    }
    this.vAK = true;
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICu, Integer.valueOf(0))).intValue();
    this.vAy = i;
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ai("v1.0", i, (byte)0), false);
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
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      boolean firstTime = true;
      
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    localView.setOnClickListener(new LuckyMoneyPrepareUI.40(this));
    AppMethodBeat.o(65903);
  }
  
  public final void dhR()
  {
    AppMethodBeat.i(65906);
    com.tencent.mm.plugin.luckymoney.b.a.dhH();
    this.vjG = com.tencent.mm.plugin.luckymoney.b.a.dhI().dil();
    int i;
    double d2;
    double d1;
    if ((this.vrB.dhQ() != 3) && (this.vkr.dhQ() != 3))
    {
      i = this.vkr.getInput();
      d2 = this.vrB.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.vrB.getInput();
      }
    }
    for (;;)
    {
      if (this.vkA.djp())
      {
        ad.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
        this.vku.setClickable(false);
        this.vku.setEnabled(false);
        b(d2, this.vAs);
        AppMethodBeat.o(65906);
        return;
        if (i > 0) {
          d1 = com.tencent.mm.wallet_core.ui.e.a(String.valueOf(d2), String.valueOf(i), String.valueOf(this.vjG.vjc).length() + 2, RoundingMode.HALF_UP);
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
          label427:
          boolean bool1;
          if (bool2)
          {
            this.vku.setClickable(false);
            this.vku.setEnabled(false);
            break;
            if ((d2 > this.vjG.vjf) && (this.vjG.vjf > 0.0D))
            {
              this.vkA.TW(getString(2131760977, new Object[] { Math.round(this.vjG.vjf), bt.bI(this.vjG.vji, "") }));
              bool2 = true;
              continue;
            }
            if (d1 <= 0.0D) {
              break label1052;
            }
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d1)));
            if (this.mType == 0)
            {
              if ((d1 <= this.vjG.vjd) || (this.vjG.vjd <= 0.0D)) {
                break label1046;
              }
              if (djG())
              {
                this.vkA.TW(getString(2131760923, new Object[] { this.vjG.vnY, Math.round(this.vjG.vjd), bt.bI(this.vjG.vji, "") }));
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
                break label897;
              }
              bool2 = bool1;
              if (d1 < this.vjG.vje)
              {
                if (!djG()) {
                  break label848;
                }
                this.vkA.TW(getString(2131760925, new Object[] { this.vjG.vnY, com.tencent.mm.wallet_core.ui.e.C(this.vjG.vje), bt.bI(this.vjG.vji, "") }));
                label555:
                bool2 = true;
              }
            }
            label848:
            do
            {
              ad.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
              break;
              this.vkA.TW(getString(2131760922, new Object[] { Math.round(this.vjG.vjd), bt.bI(this.vjG.vji, "") }));
              break label427;
              if ((d1 <= this.vjG.vjg) || (this.vjG.vjg <= 0.0D)) {
                break label1046;
              }
              if ((this.vjG != null) && (!bt.isNullOrNil(this.vjG.vnY))) {
                this.vkA.TW(getString(2131760923, new Object[] { this.vjG.vnY, Math.round(this.vjG.vjg), bt.bI(this.vjG.vji, "") }));
              }
              for (;;)
              {
                this.vkr.onError();
                this.vrB.onError();
                bool1 = true;
                break;
                this.vkA.TW(getString(2131760922, new Object[] { Math.round(this.vjG.vjg), bt.bI(this.vjG.vji, "") }));
              }
              this.vkA.TW(getString(2131760924, new Object[] { com.tencent.mm.wallet_core.ui.e.C(this.vjG.vje), bt.bI(this.vjG.vji, "") }));
              break label555;
              bool2 = bool1;
            } while (d1 >= 0.01D);
            label897:
            if (djG()) {
              this.vkA.TW(getString(2131760925, new Object[] { this.vjG.vnY, "0.01", bt.bI(this.vjG.vji, "") }));
            }
            for (;;)
            {
              this.vkr.onError();
              this.vrB.onError();
              bool2 = true;
              break;
              this.vkA.TW(getString(2131760924, new Object[] { "0.01", bt.bI(this.vjG.vji, "") }));
            }
            this.vku.setClickable(true);
            this.vku.setEnabled(true);
            break;
            label1046:
            bool1 = false;
          }
          label1052:
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
    if ((paramKeyEvent.getKeyCode() == 4) && (this.vrC.getVisibility() == 0))
    {
      this.vrC.setVisibility(8);
      dje();
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
    if (this.vAu != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_realname_guide_helper", this.vAu);
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
      apg(str);
    }
    finish();
    AppMethodBeat.o(65901);
  }
  
  public void initView()
  {
    AppMethodBeat.i(65886);
    setBackBtn(new LuckyMoneyPrepareUI.12(this));
    this.vrC = findViewById(2131301905);
    this.vrD = findViewById(2131301908);
    this.pOj = ((Button)findViewById(2131301907));
    this.vkt = ((LuckyMoneyTextInputView)findViewById(2131301959));
    this.vkt.setHintText(getString(2131760843));
    this.vku = ((Button)findViewById(2131301896));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    this.mkS = ((TextView)findViewById(2131301894));
    this.vkr = ((LuckyMoneyNumInputView)findViewById(2131301891));
    this.vrB = ((LuckyMoneyMoneyInputView)findViewById(2131301715));
    this.peG = ((TextView)findViewById(2131301909));
    this.vrE = ((ViewGroup)findViewById(2131301903));
    this.vkx = ((MMScrollView)findViewById(2131301943));
    this.vky = ((TextView)findViewById(2131301901));
    this.vAk = ((RelativeLayout)findViewById(2131301802));
    this.vAl = ((TextView)findViewById(2131301808));
    this.vAm = ((TextView)findViewById(2131307213));
    this.vAn = ((ImageView)findViewById(2131301801));
    this.vAo = ((ImageView)findViewById(2131301800));
    this.vAp = ((ImageView)findViewById(2131301803));
    this.vAq = ((TextView)findViewById(2131301804));
    this.vwn = new a(this);
    this.vwo = getLayoutInflater().inflate(2131494640, null);
    this.vwn.setContentView(this.vwo, new ViewGroup.LayoutParams(-1, -1));
    this.vwo.findViewById(2131301796).setOnClickListener(new LuckyMoneyPrepareUI.22(this));
    this.vwn.vum = new LuckyMoneyPrepareUI.33(this);
    this.vwx = ((ViewGroup)this.vwo.findViewById(2131301798));
    this.vwv = com.tencent.mm.pluginsdk.ui.chat.e.FdJ.eA(getContext());
    this.vAw = getIntent().getStringExtra("key_username");
    this.vwv.setTalkerName(this.vAw);
    this.vwv.setShowSmiley(false);
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
      this.vrB.setTitle(getString(2131760978));
      this.vrB.setShowGroupIcon(true);
      localObject1 = new LinearLayout.LayoutParams(-1, -1);
      localObject2 = new LinearLayout.LayoutParams(-1, com.tencent.mm.cc.a.ax(this, 2131166515));
      if (this.mType != 1) {
        break label1356;
      }
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 13);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 13);
      this.vkt.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.vAk.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.vrB.setOnInputValidChangerListener(this);
      this.vrB.setHint(getString(2131760895));
      this.vkr.setOnInputValidChangerListener(this);
      this.vkr.setHint(getString(2131760911));
      this.vkt.setOnInputValidChangerListener(this);
      if (!al.isDarkMode()) {
        break label1386;
      }
      this.vAp.setImageResource(2131233108);
      localObject1 = (EditText)this.vrB.findViewById(2131301810);
      localObject2 = (EditText)this.vkr.findViewById(2131301810);
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).addTextChangedListener(new LuckyMoneyPrepareUI.11(this, (EditText)localObject1));
      ((EditText)localObject2).addTextChangedListener(new LuckyMoneyPrepareUI.13(this, (EditText)localObject2));
      ((EditText)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65840);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          this.val$hintTv.setOnClickListener(null);
          this.vkC.setOnClickListener(null);
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
      localObject3 = (TextView)this.vrB.findViewById(2131301716);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65841);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            this.val$hintTv.setOnClickListener(null);
            this.vkC.setOnClickListener(null);
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
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65842);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          this.val$hintTv.setOnClickListener(null);
          this.vkC.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ai(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ai(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
          LuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
          LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
          LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65842);
        }
      });
      ((MMEditText)this.vkt.findViewById(2131301944)).setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(65843);
          this.val$hintTv.setOnClickListener(null);
          this.vkC.setOnClickListener(null);
          LuckyMoneyPrepareUI.this.ai(LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this), 2);
          LuckyMoneyPrepareUI.this.ai(LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this), 0);
          AppMethodBeat.o(65843);
        }
      });
      if (this.vjG != null)
      {
        if (this.mType != 1) {
          break label1399;
        }
        this.vrB.setMaxAmount(this.vjG.vjf);
        this.vrB.setMinAmount(this.vjG.vje);
        if (this.vjG.paJ != 1) {
          apf(this.vjG.vji);
        }
      }
      if ((!this.vrI) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1416;
      }
      this.vkr.setNum("1");
      label951:
      this.vkr.setMaxNum(this.vjG.vjc);
      this.vkr.setMinNum(1);
      ad.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.vkr.getInput());
      this.vrB.setMaxLen(12);
      if (djG()) {
        this.vku.setText(getString(2131760935, new Object[] { this.vjG.vnY }));
      }
      if ((!this.vrI) && (this.fPp != 2)) {
        break label1874;
      }
      if (!djG()) {
        break label1428;
      }
      setMMTitle(getString(2131760976, new Object[] { this.vjG.vnY }));
      label1093:
      i = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.vrI) || (i != 0)) {
        break label1438;
      }
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
      this.vkr.setVisibility(8);
    }
    for (;;)
    {
      this.vku.setOnClickListener(new w()
      {
        public final void caN()
        {
          AppMethodBeat.i(65880);
          LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new dy());
          LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).ecM = 6L;
          LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aLk();
          if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(LuckyMoneyPrepareUI.this))
          {
            ad.w("MicroMsg.LuckyMoneyPrepareUI", "can not request hb while authen");
            com.tencent.mm.plugin.report.service.g.yhR.dD(965, 55);
            AppMethodBeat.o(65880);
            return;
          }
          LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this);
          AppMethodBeat.o(65880);
        }
      });
      this.vkA.a(this.vkr);
      this.vkA.a(this.vrB);
      this.vkA.a(this.vkt);
      localObject1 = (TextView)findViewById(2131301898);
      this.vkA.n((TextView)localObject1);
      this.jkD = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(65881);
          int i;
          double d2;
          if ((LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).dhQ() != 3) && (LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).dhQ() != 3))
          {
            i = LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).getInput();
            d2 = LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).getInput();
            d1 = d2;
            if (LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this) != 0) {}
          }
          for (double d1 = d2 * i;; d1 = 0.0D)
          {
            if ((d1 == 0.0D) || (d1 > LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).vjf) || (LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).djq()))
            {
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setClickable(false);
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setEnabled(false);
            }
            for (;;)
            {
              ad.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d1 + ", hasErr=" + LuckyMoneyPrepareUI.j(LuckyMoneyPrepareUI.this).djq());
              LuckyMoneyPrepareUI.l(LuckyMoneyPrepareUI.this).fkZ();
              AppMethodBeat.o(65881);
              return false;
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setClickable(true);
              LuckyMoneyPrepareUI.k(LuckyMoneyPrepareUI.this).setEnabled(true);
            }
          }
        }
      }, false);
      if (this.vkx != null) {
        this.vkx.setOnTouchListener(new LuckyMoneyPrepareUI.2(this));
      }
      this.vrB.setType(this.mType);
      init();
      final boolean bool = com.tencent.mm.z.c.aht().a(al.a.ICr, al.a.ICt);
      this.vAk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(65834);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          ad.d("MicroMsg.LuckyMoneyPrepareUI", "click envelope layout: %s", new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this)) });
          if (LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this) == 0)
          {
            LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null, false, bool);
            paramAnonymousView = com.tencent.mm.plugin.report.service.g.yhR;
            if (!bool) {
              break label212;
            }
          }
          label212:
          for (int i = 2;; i = 1)
          {
            paramAnonymousView.f(18890, new Object[] { Integer.valueOf(2), Integer.valueOf(i), LuckyMoneyPrepareUI.x(LuckyMoneyPrepareUI.this) });
            com.tencent.mm.plugin.report.service.g.yhR.f(16822, new Object[] { Integer.valueOf(1) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65834);
            return;
            paramAnonymousView = z.fI(LuckyMoneyPrepareUI.this.getContext());
            localObject = com.tencent.mm.plugin.luckymoney.model.g.dig();
            ((com.tencent.mm.plugin.luckymoney.model.g)localObject).b(new com.tencent.mm.plugin.luckymoney.model.c(""));
            ((com.tencent.mm.wallet_core.c.a)localObject).a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
            break;
          }
        }
      });
      if (bool) {
        this.vAq.setVisibility(0);
      }
      if (this.vob != null) {
        b(this.vob.vnI);
      }
      AppMethodBeat.o(65886);
      return;
      setMMTitle(2131760909);
      this.vrB.setTitle(getString(2131760979));
      this.vrB.setShowGroupIcon(false);
      break;
      label1356:
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 16);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cc.a.fromDPToPix(getContext(), 16);
      break label565;
      label1386:
      this.vAp.setImageResource(2131233107);
      break label650;
      label1399:
      this.vrB.setMaxAmount(this.vjG.vjd);
      break label883;
      label1416:
      this.vkr.setNum("");
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
      if ((this.vrI) && (i > 0))
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
        this.vrB.setGroupIconIv(2131233029);
        ((com.tencent.mm.plugin.wallet_core.ui.l)localObject5).DfS = new l.a()
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
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setMaxAmount(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).vjd);
            LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this).setText(this.vkG);
            com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(3) });
            AppMethodBeat.o(65877);
          }
        };
        ((com.tencent.mm.plugin.wallet_core.ui.l)localObject4).DfS = new l.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65878);
            int i = LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this).getInput();
            double d = LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).getInput();
            LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, 1);
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setType(LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this));
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setMaxAmount(LuckyMoneyPrepareUI.e(LuckyMoneyPrepareUI.this).vjf);
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setTitle(LuckyMoneyPrepareUI.this.getString(2131760978));
            LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setShowGroupIcon(true);
            if ((d > 0.0D) && (i > 0)) {
              LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this).setAmount(com.tencent.mm.wallet_core.ui.e.C(d * i));
            }
            LuckyMoneyPrepareUI.f(LuckyMoneyPrepareUI.this).setText(localSpannableString);
            com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(2) });
            AppMethodBeat.o(65878);
          }
        };
        this.mkS.setMovementMethod(LinkMovementMethod.getInstance());
        if (com.tencent.mm.ui.a.a.a.fyf().fye()) {
          this.mkS.setOnClickListener(new LuckyMoneyPrepareUI.43(this, localSpannableString, (com.tencent.mm.plugin.wallet_core.ui.l)localObject5, (com.tencent.mm.plugin.wallet_core.ui.l)localObject4));
        }
        this.mkS.setTextColor(getResources().getColor(2131100021));
        this.mkS.setText(localSpannableString);
        this.mkS.setVisibility(0);
        break;
        if (this.fPp == 2)
        {
          ad.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
          this.vkt.setVisibility(8);
        }
      }
      label1874:
      if (this.mType == 1)
      {
        this.mkS.setText(this.vjG.vnU);
        this.mkS.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.mkS.setText(this.vjG.vnV);
        this.mkS.setVisibility(0);
      }
    }
  }
  
  public final void j(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(65902);
    if (paramIntent.hasExtra("key_realname_guide_helper")) {
      this.vAu = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
    }
    if (paramInt == -1)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(diH()), Integer.valueOf(5) });
      Object localObject1 = getIntent().getStringExtra("key_username");
      if ((this.vrI) && (!bt.isNullOrNil((String)localObject1)))
      {
        com.tencent.mm.ui.base.h.cl(this, getString(2131760233));
        Object localObject2 = bw.M(this.vrJ, "msg");
        if (localObject2 == null)
        {
          ad.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
          finish();
          AppMethodBeat.o(65902);
          return;
        }
        localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
        if (com.tencent.mm.plugin.luckymoney.b.a.dhH().dhK().aoT((String)localObject2))
        {
          ad.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
          if (!z.Z(this.vrJ, (String)localObject1, 1))
          {
            ad.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
            com.tencent.mm.plugin.luckymoney.b.a.dhH().dhK().aoU((String)localObject2);
          }
          h(paramInt, paramIntent);
          localObject1 = new com.tencent.mm.plugin.luckymoney.story.b.e();
          ((com.tencent.mm.plugin.luckymoney.story.b.e)localObject1).field_send_id = ((String)localObject2);
          if (!com.tencent.mm.plugin.luckymoney.b.a.dhH().dhG().get((com.tencent.mm.sdk.e.c)localObject1, new String[0]))
          {
            ((com.tencent.mm.plugin.luckymoney.story.b.e)localObject1).field_open_count = 0;
            ad.d("MicroMsg.LuckyMoneyPrepareUI", "insert record: %s, %s", new Object[] { localObject2, Boolean.valueOf(com.tencent.mm.plugin.luckymoney.b.a.dhH().dhG().insert((com.tencent.mm.sdk.e.c)localObject1)) });
          }
          this.vAx = new dz();
          this.vAx.ehi = this.vyG;
          if (this.pIn != null) {
            break label417;
          }
          localObject1 = "";
          label339:
          this.vAx.nh((String)localObject1);
          this.vAx.aLk();
          ad.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.vyG), localObject1 });
          finish();
        }
      }
      for (;;)
      {
        apg(paramIntent.getStringExtra("key_trans_id"));
        AppMethodBeat.o(65902);
        return;
        ad.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
        break;
        label417:
        localObject1 = this.pIn.Lb();
        break label339;
        djf();
        localObject1 = findViewById(2131301906);
        this.vrC.setVisibility(0);
        z.a((View)localObject1, null);
        this.pOj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(65868);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
            z.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.G(LuckyMoneyPrepareUI.this), true);
            LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65867);
                LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
                LuckyMoneyPrepareUI.this.dje();
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
            LuckyMoneyPrepareUI.this.dje();
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
        this.vAu = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
      }
      Object localObject1;
      if (paramInt2 == -1)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(diH()), Integer.valueOf(5) });
        localObject1 = getIntent().getStringExtra("key_username");
        if ((this.vrI) && (!bt.isNullOrNil((String)localObject1)))
        {
          Object localObject2 = bw.M(this.vrJ, "msg");
          if (localObject2 == null)
          {
            ad.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(65900);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.dhH().dhK().aoT((String)localObject2))
          {
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!z.Z(this.vrJ, (String)localObject1, 1))
            {
              ad.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.dhH().dhK().aoU((String)localObject2);
            }
            label297:
            h(paramInt2, paramIntent);
            this.vAx = new dz();
            this.vAx.ehi = this.vyG;
            if (this.pIn != null) {
              break label425;
            }
            localObject1 = "";
            label337:
            this.vAx.nh((String)localObject1);
            this.vAx.aLk();
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", new Object[] { Integer.valueOf(this.vyG), localObject1 });
            finish();
          }
        }
        for (;;)
        {
          localObject1 = "";
          if (paramIntent != null) {
            localObject1 = paramIntent.getStringExtra("key_trans_id");
          }
          apg((String)localObject1);
          break;
          ad.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          break label297;
          label425:
          localObject1 = this.pIn.Lb();
          break label337;
          djf();
          localObject1 = findViewById(2131301906);
          this.vrC.setVisibility(0);
          z.a((View)localObject1, null);
          this.pOj.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65864);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(6) });
              z.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this), LuckyMoneyPrepareUI.G(LuckyMoneyPrepareUI.this), true);
              LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(65863);
                  LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
                  LuckyMoneyPrepareUI.this.dje();
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
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              LuckyMoneyPrepareUI.H(LuckyMoneyPrepareUI.this).setVisibility(8);
              LuckyMoneyPrepareUI.this.dje();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65866);
            }
          });
          h(paramInt2, paramIntent);
        }
      }
      if (com.tencent.mm.wallet_core.c.ag.bw(paramIntent))
      {
        finish();
        AppMethodBeat.o(65900);
        return;
      }
      if (com.tencent.mm.wallet_core.c.ag.bx(paramIntent))
      {
        AppMethodBeat.o(65900);
        return;
      }
      h(paramInt2, paramIntent);
      continue;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(diH()), Integer.valueOf(7), localObject1 });
        if (!bt.isNullOrNil((String)localObject1)) {
          doSceneProgress(new at(((String)localObject1).replaceAll(",", "|"), this.vrG, "v1.0"));
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
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
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
            i(paramInt2, paramIntent);
            continue;
            if (paramInt2 == -1)
            {
              this.vrE.removeAllViews();
              oe(true);
            }
            else
            {
              oe(false);
              com.tencent.mm.plugin.report.service.g.yhR.f(16822, new Object[] { Integer.valueOf(2) });
              continue;
              if (paramInt2 == -1)
              {
                localObject1 = "";
                if (paramIntent != null) {
                  localObject1 = paramIntent.getStringExtra("gif_md5");
                }
                if (!bt.isNullOrNil((String)localObject1))
                {
                  this.pIn = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn.aUK((String)localObject1);
                  A(this.pIn);
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
    this.vrF = getIntent().getIntExtra("key_way", 3);
    this.fPp = getIntent().getIntExtra("key_from", 0);
    if (this.fPp == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.vrI = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      this.mSessionId = getIntent().getStringExtra("key_session_id");
      oe(false);
      com.tencent.mm.plugin.luckymoney.b.a.dhH();
      this.vjG = com.tencent.mm.plugin.luckymoney.b.a.dhI().dil();
      com.tencent.mm.plugin.luckymoney.b.a.dhH();
      this.vob = com.tencent.mm.plugin.luckymoney.b.a.dhI().dim();
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.vrF + "mChannel:" + this.mChannel);
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.vrI + ", config " + this.vjG);
      initView();
      com.tencent.mm.sdk.b.a.IbL.b(this.vAN);
      this.mPayLoopInterruptListener.alive();
      com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(diH()), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.b.fQJ();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.qwl, true);
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.fUT();
      AppMethodBeat.o(65883);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65893);
    super.onDestroy();
    this.vkA.clear();
    this.jkD.fkZ();
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.vwv != null)
    {
      ad.i("MicroMsg.LuckyMoneyPrepareUI", "commentfooter release");
      this.vwv.onPause();
      this.vwv.fbE();
      this.vwv.destroy();
    }
    com.tencent.mm.sdk.b.a.IbL.d(this.vAN);
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
      if (this.vAM)
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
          this.vrH = localaq.par;
          this.vrG = localaq.vkl;
          this.vrJ = localaq.vqz;
          this.vuW = localaq.vkl;
          this.vAv = localaq.vqD;
          if (!((com.tencent.mm.plugin.luckymoney.model.aq)paramn).isJumpRemind()) {
            break;
          }
          ad.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() NetScenePrepareLuckyMoney show JumpRemind Alert");
          ((com.tencent.mm.plugin.luckymoney.model.aq)paramn).jumpRemind.a(this, new LuckyMoneyPrepareUI.20(this));
          AppMethodBeat.o(65896);
          return true;
        }
        paramString = new PayInfo();
        paramString.dlu = localaq.thm;
        paramString.dCC = 37;
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
        this.vku.setEnabled(false);
        this.vku.setClickable(false);
        this.jkD.az(5000L, 5000L);
        com.tencent.mm.ui.base.h.cl(this, paramString);
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
      this.dFo = 2;
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
        if (this.vrI)
        {
          com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
          com.tencent.mm.sdk.platformtools.aq.o(new LuckyMoneyPrepareUI.23(this), 1800L);
        }
        for (;;)
        {
          AppMethodBeat.o(65896);
          return true;
          djf();
          this.vrD.setVisibility(0);
          this.vrD.postDelayed(new LuckyMoneyPrepareUI.24(this), 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.e(getContext(), paramString, "", getString(2131760958), getString(2131755691), new LuckyMoneyPrepareUI.25(this), new LuckyMoneyPrepareUI.26(this));
        AppMethodBeat.o(65896);
        return true;
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.model.ai))
      {
        ad.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString);
        if ((this.vAi != null) && (this.vAi.isShowing())) {
          this.vAi.dismiss();
        }
        if ((this.vAj != null) && (this.vAj.isShowing())) {
          this.vAj.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (com.tencent.mm.plugin.luckymoney.model.ai)paramn;
          this.vAJ = true;
          this.vqo = paramString.vqo;
          if (!bt.jx(paramString.vqp, 1))
          {
            this.vkt.of(true);
            com.tencent.mm.plugin.luckymoney.b.a.dhH();
            this.vjG = com.tencent.mm.plugin.luckymoney.b.a.dhI().dil();
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.vjG);
            if (this.mType != 1) {
              break label1492;
            }
            this.vrB.setMaxAmount(this.vjG.vjf);
            label867:
            this.vrB.setMinAmount(this.vjG.vje);
            this.vkr.setMaxNum(this.vjG.vjc);
            this.vAs = paramString.vjh;
            this.vAr = paramString.paJ;
            this.vAt = paramString.vjr;
            if (bt.isNullOrNil(this.vyN)) {
              this.vyN = paramString.dBg;
            }
            if ((!bt.isNullOrNil(this.vAt)) && (this.vkt != null)) {
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
            if ((paramString.vqf) && (this.vrI))
            {
              paramn = (TextView)findViewById(2131301899);
              paramn.setOnClickListener(new LuckyMoneyPrepareUI.29(this));
              com.tencent.mm.plugin.report.service.g.yhR.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(diH()), Integer.valueOf(8) });
              paramn.setVisibility(8);
            }
            if (bt.isNullOrNil(paramString.iTH)) {
              break label1509;
            }
            ad.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.iTH);
            this.vky.setText(paramString.iTH);
            if (!bt.isNullOrNil(paramString.vqh)) {
              this.vky.setOnClickListener(new LuckyMoneyPrepareUI.30(this, paramString));
            }
            this.vky.setVisibility(0);
            label1144:
            paramn = new h.c();
            if ((paramString.vqj == null) || (bt.isNullOrNil(paramString.vqj.content))) {
              break label1521;
            }
            paramn.textColor = getResources().getColor(2131101114);
            label1188:
            this.vrE.removeAllViews();
            h.a(this, this.vrE, paramString.vqj, paramn);
            apf(paramString.vji);
            if (this.vAr == 1) {
              break label1539;
            }
            b(this.vrB.getInput(), this.vAs);
            label1240:
            com.tencent.mm.plugin.luckymoney.b.a.dhH();
            this.vob = com.tencent.mm.plugin.luckymoney.b.a.dhI().dim();
            init();
            if (this.vob == null) {
              break label1565;
            }
            if (this.vob.vnI != null)
            {
              this.vAy = this.vob.vnI.GIm;
              this.vAz = this.vob.vnI.GIk;
              this.vAA = this.vob.vnI.GIl;
            }
            b(this.vob.vnI);
            com.tencent.mm.plugin.report.service.g.yhR.dD(991, 10);
            label1339:
            if (this.vAL)
            {
              ad.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick()");
              a(this.vAC, this.vAD, this.vAE, this.vAF, this.vAG, this.vAH);
            }
          }
        }
        for (;;)
        {
          ad.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig waitingGetConfig:%s ifAutoRMBPrePareBtn:%s", new Object[] { Boolean.valueOf(this.vAK), Boolean.valueOf(this.vAL) });
          this.vAK = false;
          this.vAL = false;
          AppMethodBeat.o(65896);
          return true;
          this.vkt.of(false);
          if ((this.pIn != null) && (!bt.isNullOrNil(this.pIn.Lb()))) {
            this.vkt.A(this.pIn);
          }
          this.vkt.setmOnEmojiSelectClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65857);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new dy());
              LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).ecM = 2L;
              LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aLk();
              final boolean bool = bt.K(paramAnonymousView.getTag(), "delete");
              if ((!bool) && (!bt.jx(paramString.vqo, 1)))
              {
                LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, 2);
                LuckyMoneyPrepareUI.A(LuckyMoneyPrepareUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65857);
                return;
              }
              paramAnonymousView = new com.tencent.mm.ui.widget.d(LuckyMoneyPrepareUI.this.getContext(), 1, false);
              paramAnonymousView.KJy = new n.d()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(65855);
                  if (!bool)
                  {
                    if (bt.jx(LuckyMoneyPrepareUI.27.this.vrL.vqo, 1)) {
                      paramAnonymous2l.jI(1, 2131760908);
                    }
                    paramAnonymous2l.jI(2, 2131760952);
                    AppMethodBeat.o(65855);
                    return;
                  }
                  paramAnonymous2l.a(3, LuckyMoneyPrepareUI.this.getResources().getColor(2131100596), LuckyMoneyPrepareUI.this.getContext().getString(2131760844));
                  AppMethodBeat.o(65855);
                }
              };
              paramAnonymousView.KJz = new n.e()
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
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new dy());
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).ecM = 4L;
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aLk();
                    AppMethodBeat.o(65856);
                    return;
                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, 2);
                    LuckyMoneyPrepareUI.A(LuckyMoneyPrepareUI.this);
                    AppMethodBeat.o(65856);
                    return;
                    LuckyMoneyPrepareUI.C(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem = LuckyMoneyPrepareUI.D(LuckyMoneyPrepareUI.this);
                    paramAnonymous2MenuItem.vBe.setTag("");
                    paramAnonymous2MenuItem.vBf.setVisibility(0);
                    paramAnonymous2MenuItem.vBg.setVisibility(8);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null);
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, new dy());
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).ecM = 5L;
                    LuckyMoneyPrepareUI.h(LuckyMoneyPrepareUI.this).aLk();
                  }
                }
              };
              paramAnonymousView.cMW();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(65857);
            }
          });
          break;
          label1492:
          this.vrB.setMaxAmount(this.vjG.vjd);
          break label867;
          label1509:
          this.vky.setVisibility(8);
          break label1144;
          label1521:
          paramn.textColor = getResources().getColor(2131100482);
          break label1188;
          label1539:
          if (this.mType != 1) {
            break label1240;
          }
          b(this.vrB.getInput(), this.vAs);
          break label1240;
          label1565:
          b(null);
          break label1339;
          if (this.vAL)
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
          paramString = ((aj)paramn).paU;
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
              this.vuW = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn).vkl;
              this.vAv = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn).vlD;
              paramString = new PayInfo();
              paramString.dlu = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramn).dlu;
              paramString.dCC = 37;
              if ((!this.mKindaEnable) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_F2F_HONGBAO_PAY_SWTICH_KEY"))) {
                break label1922;
              }
              if (paramString.htZ == null) {
                paramString.htZ = new Bundle();
              }
              paramString.htZ.putBoolean("isF2FHongBao", true);
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
            af.w(37, paramString.dlu, paramInt2);
            com.tencent.mm.pluginsdk.wallet.f.a(this, paramString, 4);
            continue;
            af.w(37, "", paramInt2);
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