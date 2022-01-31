package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
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
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.a.ra;
import com.tencent.mm.g.b.a.ac;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LuckyMoneyPrepareUI
  extends LuckyMoneyBaseUI
  implements g
{
  private int cEU;
  private int ejF;
  private ap gIs;
  public Dialog gKM;
  private TextView kRB;
  private TextView kRx;
  private EmojiInfo lkU;
  private Button lqP;
  private int mChannel;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private boolean mKindaEnable;
  private com.tencent.mm.sdk.b.c<ml> mPayLoopInterruptListener;
  private int mType;
  private com.tencent.mm.plugin.luckymoney.model.i oiV;
  private LuckyMoneyNumInputView ojG;
  private LuckyMoneyTextInputView ojI;
  private Button ojJ;
  private MMScrollView ojM;
  private TextView ojN;
  private b ojP;
  private com.tencent.mm.plugin.luckymoney.model.d onp;
  private int opo;
  private LuckyMoneyMoneyInputView oqE;
  private View oqF;
  private View oqG;
  private ViewGroup oqH;
  private int oqI;
  private String oqJ;
  private int oqK;
  private boolean oqL;
  private String oqM;
  private String orH;
  private a osR;
  private View osS;
  private ChatFooterPanel osX;
  private ViewGroup osZ;
  private ac otb;
  private int ote;
  private int ova;
  private String ovh;
  private String ovk;
  private String owA;
  private int owB;
  private long owC;
  private long owD;
  private String owE;
  private com.tencent.mm.ui.widget.d owF;
  private boolean owG;
  private boolean owH;
  private boolean owI;
  private boolean owJ;
  private com.tencent.mm.sdk.b.c<ra> owK;
  private Dialog own;
  private Dialog owo;
  private RelativeLayout owp;
  private TextView owq;
  private ImageView owr;
  private TextView ows;
  private int owt;
  private String owu;
  private String owv;
  private RealnameGuideHelper oww;
  private String owx;
  private com.tencent.mm.g.b.a.ad owy;
  private int owz;
  
  public LuckyMoneyPrepareUI()
  {
    AppMethodBeat.i(42993);
    this.ojG = null;
    this.oqE = null;
    this.ojI = null;
    this.kRx = null;
    this.ojJ = null;
    this.lqP = null;
    this.gKM = null;
    this.own = null;
    this.owo = null;
    this.ojP = new b();
    this.gIs = null;
    this.owt = 1;
    this.owu = com.tencent.mm.wallet_core.ui.e.awa("CNY");
    this.owv = null;
    this.orH = "";
    this.ova = 1;
    this.ote = 0;
    this.mPayLoopInterruptListener = new LuckyMoneyPrepareUI.1(this);
    this.owG = false;
    this.owH = false;
    this.owI = false;
    this.owJ = false;
    this.owK = new LuckyMoneyPrepareUI.19(this);
    this.cEU = 0;
    this.ovk = "";
    AppMethodBeat.o(42993);
  }
  
  private void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(43008);
    this.ojI.A(paramEmojiInfo);
    if ((this.ote == 0) || (this.ote == 2)) {
      if (com.tencent.mm.plugin.emoji.h.b.y(paramEmojiInfo)) {
        this.ova = 2;
      }
    }
    for (;;)
    {
      this.otb = new ac();
      this.otb.cRI = 1L;
      this.otb.ake();
      AppMethodBeat.o(43008);
      return;
      if (com.tencent.mm.plugin.emoji.h.b.x(paramEmojiInfo))
      {
        this.ova = 4;
      }
      else
      {
        this.ova = 3;
        continue;
        if (this.ote == 1) {
          this.ova = 2;
        }
      }
    }
  }
  
  private void Sz(String paramString)
  {
    AppMethodBeat.i(43020);
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
    doSceneProgress(new ae(this.orH, paramString, this.owx), false);
    AppMethodBeat.o(43020);
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(43001);
    String str2 = "";
    int i = 0;
    if (this.lkU != null)
    {
      str2 = this.lkU.Al();
      i = this.lkU.field_type;
    }
    String str1 = "";
    if (this.onp != null) {
      str1 = this.onp.omX;
    }
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB. userConfirmJump:%s lastPayResult:%s mSendId:%s mUniqueId:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.cEU), this.orH, this.ovh });
    if ((this.oqL) && (!bo.isNullOrNil(paramString1))) {}
    for (paramString1 = new ao(paramInt2, paramLong1, paramLong2, this.mType, paramString2, x.bNq(), paramString1, x.nD(paramString1), r.Zn(), r.Zp(), this.oqI, str1, this.ovh, paramInt1, this.cEU, this.orH, str2, i);; paramString1 = new ao(paramInt2, paramLong1, paramLong2, this.mType, paramString2, x.bNq(), null, null, r.Zn(), r.Zp(), this.oqI, str1, this.ovh, paramInt1, this.cEU, this.orH, str2, i))
    {
      doSceneProgress(paramString1, false);
      if (!bo.isNullOrNil(str1)) {
        com.tencent.mm.plugin.report.service.h.qsU.cT(991, 11);
      }
      bOk();
      AppMethodBeat.o(43001);
      return;
    }
  }
  
  private void a(aus paramaus)
  {
    AppMethodBeat.i(43003);
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "update envelope");
    if ((this.onp != null) && (paramaus != null) && (this.ejF != 2))
    {
      this.owp.setVisibility(0);
      if ((this.onp.omY) && (!bo.isNullOrNil(this.onp.omZ)))
      {
        List localList = bo.ih((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJm, ""), ",");
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.equals(this.onp.omW.materialId))
          {
            ab.d("MicroMsg.LuckyMoneyPrepareUI", "has alert illegal: %s", new Object[] { str });
            AppMethodBeat.o(43003);
            return;
          }
        }
        localList.add(this.onp.omW.materialId);
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJm, bo.d(localList, ","));
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "show alert illegal: %s", new Object[] { this.onp.omW.materialId });
        com.tencent.mm.ui.base.h.a(getContext(), this.onp.omZ, "", getString(2131305958), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    while ((paramaus != null) && (!bo.isNullOrNil(paramaus.xjL)))
    {
      this.owq.setText(paramaus.xjL);
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.owr, paramaus);
      AppMethodBeat.o(43003);
      return;
      this.owp.setVisibility(8);
    }
    this.owr.setImageBitmap(null);
    this.owq.setText("");
    AppMethodBeat.o(43003);
  }
  
  private int bNH()
  {
    AppMethodBeat.i(43018);
    if (this.oqL)
    {
      if (getIntent().getIntExtra("key_chatroom_num", 0) > 0)
      {
        AppMethodBeat.o(43018);
        return 2;
      }
      AppMethodBeat.o(43018);
      return 1;
    }
    AppMethodBeat.o(43018);
    return 3;
  }
  
  private void bOk()
  {
    AppMethodBeat.i(43000);
    if (this.gKM != null)
    {
      this.gKM.show();
      AppMethodBeat.o(43000);
      return;
    }
    this.gKM = com.tencent.mm.wallet_core.ui.g.a(getContext(), true, new LuckyMoneyPrepareUI.4(this));
    this.gKM.setCancelable(false);
    AppMethodBeat.o(43000);
  }
  
  private boolean bOl()
  {
    AppMethodBeat.i(43016);
    if ((this.oiV != null) && (!bo.isNullOrNil(this.oiV.onn)))
    {
      AppMethodBeat.o(43016);
      return true;
    }
    AppMethodBeat.o(43016);
    return false;
  }
  
  private void c(double paramDouble, String paramString)
  {
    AppMethodBeat.i(43017);
    if (bo.isNullOrNil(paramString))
    {
      this.kRx.setText(com.tencent.mm.wallet_core.ui.e.F(paramDouble));
      AppMethodBeat.o(43017);
      return;
    }
    this.kRx.setText(paramString + com.tencent.mm.wallet_core.ui.e.E(paramDouble));
    AppMethodBeat.o(43017);
  }
  
  private void ff(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43009);
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=".concat(String.valueOf(paramString1)));
    TextView localTextView = (TextView)findViewById(2131825701);
    if (!bo.isNullOrNil(paramString1)) {
      localTextView.setText(paramString1);
    }
    while (!bo.isNullOrNil(paramString2))
    {
      c(0.0D, paramString2);
      AppMethodBeat.o(43009);
      return;
      localTextView.setText(getString(2131301196));
    }
    c(0.0D, com.tencent.mm.wallet_core.ui.e.awa("CNY"));
    AppMethodBeat.o(43009);
  }
  
  private void g(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(43010);
    String str1 = getIntent().getStringExtra("key_username");
    String str2 = r.Zn();
    if (paramInt == -1)
    {
      ab.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode == RESULT_OK");
      this.cEU = 1;
      this.ovk = "";
      paramIntent = new com.tencent.mm.plugin.luckymoney.model.al(this.orH, this.ovh, 1, str2, bo.nullAsNil(str1));
      com.tencent.mm.kernel.g.RK().eHt.a(paramIntent, 0);
      AppMethodBeat.o(43010);
      return;
    }
    if (paramIntent != null) {}
    for (this.cEU = paramIntent.getIntExtra("key_pay_reslut_type", 3);; this.cEU = 3)
    {
      this.ovk = this.orH;
      ab.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", new Object[] { Integer.valueOf(this.cEU) });
      paramIntent = new com.tencent.mm.plugin.luckymoney.model.al(this.orH, this.ovh, this.cEU, str2, bo.nullAsNil(str1));
      break;
      ab.i("MicroMsg.LuckyMoneyPrepareUI", "doNetSceneLuckyMoneyReport() data == null");
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(43002);
    if (this.owt == 1)
    {
      addIconOptionMenu(0, 2130839668, new LuckyMoneyPrepareUI.5(this));
      AppMethodBeat.o(43002);
      return;
    }
    addIconOptionMenu(0, 2130839419, new LuckyMoneyPrepareUI.6(this));
    AppMethodBeat.o(43002);
  }
  
  private void jd(boolean paramBoolean)
  {
    AppMethodBeat.i(43005);
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "do get config");
    if (paramBoolean) {
      this.own = x.ev(getContext());
    }
    this.owH = true;
    doSceneProgress(new ag("v1.0", ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJl, Integer.valueOf(0))).intValue(), (byte)0), false);
    AppMethodBeat.o(43005);
  }
  
  private void yH(int paramInt)
  {
    AppMethodBeat.i(42999);
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() userConfirmJump:%s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bNH()), Integer.valueOf(4) });
    com.tencent.mm.plugin.report.service.h.qsU.e(15511, new Object[] { Integer.valueOf(this.owt), Integer.valueOf(2) });
    if (this.oqE.bMP() != 0)
    {
      t.makeText(getContext(), 2131304847, 0).show();
      AppMethodBeat.o(42999);
      return;
    }
    int i = this.ojG.getInput();
    double d = this.oqE.getInput();
    long l2 = 0L;
    long l1;
    if (this.mType == 1)
    {
      l1 = com.tencent.mm.wallet_core.ui.e.G(d);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(356354, Integer.valueOf(i));
      str = this.ojI.getInput().replace("\r", "").replace("\n", "");
      localObject = str;
      if (bo.isNullOrNil(str)) {
        if (!bo.isNullOrNil(this.owv)) {
          break label335;
        }
      }
    }
    label335:
    for (Object localObject = getString(2131301208);; localObject = this.owv)
    {
      hideTenpayKB();
      if (this.ejF != 2) {
        break label344;
      }
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.d(i, (int)l1, this.mType, (int)l2), false);
      bOk();
      AppMethodBeat.o(42999);
      return;
      l1 = com.tencent.mm.wallet_core.ui.e.G(i * d);
      l2 = com.tencent.mm.wallet_core.ui.e.G(d);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(356353, Integer.valueOf(i));
      break;
    }
    label344:
    String str = getIntent().getStringExtra("key_username");
    if (this.owt == 1)
    {
      ab.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() ifGetConfig=%s mUniqueId=%s waitingGetConfig=%s ifAutoRMBPrePareBtn=%s", new Object[] { Boolean.valueOf(this.owG), bo.nullAsNil(this.ovh), Boolean.valueOf(this.owH), Boolean.valueOf(this.owI) });
      if (this.owG)
      {
        a(paramInt, str, i, l1, l2, (String)localObject);
        AppMethodBeat.o(42999);
        return;
      }
      this.owI = true;
      this.owz = paramInt;
      this.owA = str;
      this.owB = i;
      this.owC = l1;
      this.owD = l2;
      this.owE = ((String)localObject);
      if (this.owo != null) {
        this.owo.show();
      }
      for (;;)
      {
        if (!this.owH) {
          jd(false);
        }
        AppMethodBeat.o(42999);
        return;
        this.owo = com.tencent.mm.ui.base.h.a(this, 3, 2131493306, getString(2131301086), true, new LuckyMoneyPrepareUI.3(this));
      }
    }
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "currency=%s userConfiremJump:%s", new Object[] { Integer.valueOf(this.owt), Integer.valueOf(paramInt) });
    addSceneEndListener(1647);
    if ((this.oqL) && (!bo.isNullOrNil(str))) {}
    for (localObject = new ah(i, l1, l2, this.mType, (String)localObject, str, x.bNq(), r.Zn(), this.owt);; localObject = new ah(i, l1, l2, this.mType, (String)localObject, null, x.bNq(), r.Zn(), this.owt))
    {
      doSceneProgress((m)localObject, false);
      break;
    }
  }
  
  protected final void Z(View paramView, int paramInt)
  {
    AppMethodBeat.i(43012);
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131822419));
    this.mKBLayout = findViewById(2131822418);
    View localView = findViewById(2131822420);
    EditText localEditText = (EditText)paramView.findViewById(2131825700);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null))
    {
      AppMethodBeat.o(43012);
      return;
    }
    com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new LuckyMoneyPrepareUI.37(this, paramInt, localEditText));
    localEditText.setOnClickListener(new LuckyMoneyPrepareUI.38(this, paramInt, localEditText));
    TextView localTextView = (TextView)paramView.findViewById(2131825701);
    if (localTextView != null) {
      localTextView.setOnClickListener(new LuckyMoneyPrepareUI.39(this, localEditText, paramView, paramInt));
    }
    localView.setOnClickListener(new LuckyMoneyPrepareUI.40(this));
    AppMethodBeat.o(43012);
  }
  
  public final void bMQ()
  {
    AppMethodBeat.i(43015);
    com.tencent.mm.plugin.luckymoney.b.a.bMG();
    this.oiV = com.tencent.mm.plugin.luckymoney.b.a.bMH().bNk();
    int i;
    double d2;
    double d1;
    if ((this.oqE.bMP() != 3) && (this.ojG.bMP() != 3))
    {
      i = this.ojG.getInput();
      d2 = this.oqE.getInput();
      if (this.mType == 0)
      {
        d2 *= i;
        d1 = this.oqE.getInput();
      }
    }
    for (;;)
    {
      if (this.ojP.bNY())
      {
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
        this.ojJ.setClickable(false);
        this.ojJ.setEnabled(false);
        c(d2, this.owu);
        AppMethodBeat.o(43015);
        return;
        if (i > 0) {
          d1 = this.oqE.getInput() / i;
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
          label406:
          boolean bool1;
          if (bool2)
          {
            this.ojJ.setClickable(false);
            this.ojJ.setEnabled(false);
            break;
            if ((d2 > this.oiV.oiu) && (this.oiV.oiu > 0.0D))
            {
              this.ojP.EC(getString(2131301332, new Object[] { Math.round(this.oiV.oiu), bo.bf(this.oiV.oix, "") }));
              bool2 = true;
              continue;
            }
            if (d1 <= 0.0D) {
              break label1029;
            }
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d1)));
            if (this.mType == 0)
            {
              if ((d1 <= this.oiV.ois) || (this.oiV.ois <= 0.0D)) {
                break label1023;
              }
              if (bOl())
              {
                this.ojP.EC(getString(2131301281, new Object[] { this.oiV.onn, Math.round(this.oiV.ois), bo.bf(this.oiV.oix, "") }));
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool1 + " for max value");
            bool2 = bool1;
            if (!bool1)
            {
              if (this.mType != 0) {
                break label874;
              }
              bool2 = bool1;
              if (d1 < this.oiV.oit)
              {
                if (!bOl()) {
                  break label825;
                }
                this.ojP.EC(getString(2131301283, new Object[] { this.oiV.onn, com.tencent.mm.wallet_core.ui.e.E(this.oiV.oit), bo.bf(this.oiV.oix, "") }));
                label533:
                bool2 = true;
              }
            }
            label825:
            label874:
            do
            {
              ab.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + bool2 + " for min value");
              break;
              this.ojP.EC(getString(2131301280, new Object[] { Math.round(this.oiV.ois), bo.bf(this.oiV.oix, "") }));
              break label406;
              if ((d1 <= this.oiV.oiv) || (this.oiV.oiv <= 0.0D)) {
                break label1023;
              }
              if ((this.oiV != null) && (!bo.isNullOrNil(this.oiV.onn))) {
                this.ojP.EC(getString(2131301281, new Object[] { this.oiV.onn, Math.round(this.oiV.oiv), bo.bf(this.oiV.oix, "") }));
              }
              for (;;)
              {
                this.ojG.onError();
                this.oqE.onError();
                bool1 = true;
                break;
                this.ojP.EC(getString(2131301280, new Object[] { Math.round(this.oiV.oiv), bo.bf(this.oiV.oix, "") }));
              }
              this.ojP.EC(getString(2131301282, new Object[] { com.tencent.mm.wallet_core.ui.e.E(this.oiV.oit), bo.bf(this.oiV.oix, "") }));
              break label533;
              bool2 = bool1;
            } while (d1 >= 0.01D);
            if (bOl()) {
              this.ojP.EC(getString(2131301283, new Object[] { this.oiV.onn, "0.01", bo.bf(this.oiV.oix, "") }));
            }
            for (;;)
            {
              this.ojG.onError();
              this.oqE.onError();
              bool2 = true;
              break;
              this.ojP.EC(getString(2131301282, new Object[] { "0.01", bo.bf(this.oiV.oix, "") }));
            }
            this.ojJ.setClickable(true);
            this.ojJ.setEnabled(true);
            break;
            label1023:
            bool1 = false;
          }
          label1029:
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
    AppMethodBeat.i(43006);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.oqF.getVisibility() == 0))
    {
      this.oqF.setVisibility(8);
      bNP();
      AppMethodBeat.o(43006);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(43006);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(43019);
    if (this.oww != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_realname_guide_helper", this.oww);
      com.tencent.mm.bq.d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
    }
    super.finish();
    AppMethodBeat.o(43019);
  }
  
  public int getLayoutId()
  {
    return 2130970042;
  }
  
  public final void h(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(142099);
    if (paramInt == -1)
    {
      String str = "";
      if (paramIntent != null) {
        str = paramIntent.getStringExtra("key_trans_id");
      }
      Sz(str);
    }
    finish();
    AppMethodBeat.o(142099);
  }
  
  protected final void hideTenpayKB()
  {
    AppMethodBeat.i(43014);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown())) {
      this.mKBLayout.setVisibility(8);
    }
    AppMethodBeat.o(43014);
  }
  
  public final void i(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(142100);
    if (paramIntent.hasExtra("key_realname_guide_helper")) {
      this.oww = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
    }
    Object localObject1;
    if (paramInt == -1)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bNH()), Integer.valueOf(5) });
      localObject1 = getIntent().getStringExtra("key_username");
      if ((!this.oqL) || (bo.isNullOrNil((String)localObject1))) {
        break label260;
      }
      com.tencent.mm.ui.base.h.bO(this, getString(2131300637));
      Object localObject2 = br.F(this.oqM, "msg");
      if (localObject2 == null)
      {
        ab.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
        finish();
        AppMethodBeat.o(142100);
        return;
      }
      localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
      if (!com.tencent.mm.plugin.luckymoney.b.a.bMG().bMJ().Sr((String)localObject2)) {
        break label249;
      }
      ab.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
      if (!x.J(this.oqM, (String)localObject1, 1))
      {
        ab.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
        com.tencent.mm.plugin.luckymoney.b.a.bMG().bMJ().Ss((String)localObject2);
      }
      finish();
    }
    for (;;)
    {
      Sz(paramIntent.getStringExtra("key_trans_id"));
      AppMethodBeat.o(142100);
      return;
      label249:
      ab.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
      break;
      label260:
      bNQ();
      localObject1 = findViewById(2131825802);
      this.oqF.setVisibility(0);
      x.a((View)localObject1, null);
      this.lqP.setOnClickListener(new LuckyMoneyPrepareUI.35(this));
      ((ImageView)findViewById(2131825804)).setOnClickListener(new LuckyMoneyPrepareUI.36(this));
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(42997);
    setBackBtn(new LuckyMoneyPrepareUI.12(this));
    this.oqF = findViewById(2131825801);
    this.oqG = findViewById(2131825806);
    this.lqP = ((Button)findViewById(2131825805));
    this.ojI = ((LuckyMoneyTextInputView)findViewById(2131825789));
    this.ojI.setHintText(getString(2131301208));
    this.ojJ = ((Button)findViewById(2131825798));
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131822419));
    this.mKBLayout = findViewById(2131822418);
    this.kRB = ((TextView)findViewById(2131825786));
    this.ojG = ((LuckyMoneyNumInputView)findViewById(2131825787));
    this.oqE = ((LuckyMoneyMoneyInputView)findViewById(2131825785));
    this.kRx = ((TextView)findViewById(2131825797));
    this.oqH = ((ViewGroup)findViewById(2131825800));
    this.ojM = ((MMScrollView)findViewById(2131825783));
    this.ojN = ((TextView)findViewById(2131825784));
    this.owp = ((RelativeLayout)findViewById(2131825790));
    this.owq = ((TextView)findViewById(2131825796));
    this.owr = ((ImageView)findViewById(2131825792));
    this.ows = ((TextView)findViewById(2131825794));
    this.osR = new a(this);
    this.osS = getLayoutInflater().inflate(2130970026, null);
    this.osR.setContentView(this.osS, new ViewGroup.LayoutParams(-1, -1));
    this.osS.findViewById(2131825661).setOnClickListener(new LuckyMoneyPrepareUI.22(this));
    this.osR.oqT = new LuckyMoneyPrepareUI.33(this);
    this.osZ = ((ViewGroup)this.osS.findViewById(2131825663));
    this.osX = com.tencent.mm.pluginsdk.ui.chat.e.vYI.dK(getContext());
    com.tencent.mm.plugin.luckymoney.ui.a.a.a(this.osX);
    Object localObject1;
    Object localObject2;
    label495:
    Object localObject3;
    label786:
    label861:
    label1002:
    int i;
    if (this.mType == 1)
    {
      setMMTitle(2131301237);
      this.oqE.setTitle(getString(2131301333));
      this.oqE.setShowGroupIcon(true);
      localObject1 = new LinearLayout.LayoutParams(-1, -1);
      localObject2 = new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.ao(this, 2131428526));
      if (this.mType != 1) {
        break label1261;
      }
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 13);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 13);
      this.ojI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.owp.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.oqE.setOnInputValidChangerListener(this);
      this.oqE.setHint(getString(2131301253));
      this.ojG.setOnInputValidChangerListener(this);
      this.ojG.setHint(getString(2131301269));
      this.ojI.setOnInputValidChangerListener(this);
      localObject1 = (EditText)this.oqE.findViewById(2131825700);
      localObject2 = (EditText)this.ojG.findViewById(2131825700);
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject1);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject1, 0);
      ((EditText)localObject1).addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(42951);
          if (paramAnonymousEditable.toString().startsWith(".")) {
            paramAnonymousEditable.insert(0, "0");
          }
          String str = paramAnonymousEditable.toString();
          int i = str.indexOf(".");
          int j = str.length();
          if ((i >= 0) && (j - i > 3)) {
            paramAnonymousEditable.delete(i + 3, j);
          }
          for (;;)
          {
            this.val$hintTv.setContentDescription(paramAnonymousEditable.toString());
            AppMethodBeat.o(42951);
            return;
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
      ((EditText)localObject2).addTextChangedListener(new LuckyMoneyPrepareUI.13(this, (EditText)localObject2));
      ((EditText)localObject1).setOnClickListener(new LuckyMoneyPrepareUI.14(this, (EditText)localObject1, (EditText)localObject2));
      ((EditText)localObject1).requestFocus();
      localObject3 = (TextView)this.oqE.findViewById(2131825701);
      if (localObject3 != null) {
        ((TextView)localObject3).setOnClickListener(new LuckyMoneyPrepareUI.15(this, (EditText)localObject1, (EditText)localObject2));
      }
      com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText((EditText)localObject2);
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput((View)localObject2, 0);
      ((EditText)localObject2).setOnClickListener(new LuckyMoneyPrepareUI.16(this, (EditText)localObject1, (EditText)localObject2));
      ((MMEditText)this.ojI.findViewById(2131825833)).setOnFocusChangeListener(new LuckyMoneyPrepareUI.17(this, (EditText)localObject1, (EditText)localObject2));
      if (this.oiV != null)
      {
        if (this.mType != 1) {
          break label1290;
        }
        this.oqE.setMaxAmount(this.oiV.oiu);
        this.oqE.setMinAmount(this.oiV.oit);
        if (this.oiV.kNE != 1) {
          ff(this.oiV.oix, this.oiV.oiw);
        }
      }
      if ((!this.oqL) || (getIntent().getIntExtra("key_chatroom_num", 0) > 1)) {
        break label1307;
      }
      this.ojG.setNum("1");
      this.ojG.setMaxNum(this.oiV.oir);
      this.ojG.setMinNum(1);
      ab.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.ojG.getInput());
      this.oqE.setMaxLen(12);
      if (bOl()) {
        this.ojJ.setText(getString(2131301293, new Object[] { this.oiV.onn }));
      }
      if ((!this.oqL) && (this.ejF != 2)) {
        break label1755;
      }
      if (!bOl()) {
        break label1319;
      }
      setMMTitle(getString(2131301331, new Object[] { this.oiV.onn }));
      i = getIntent().getIntExtra("key_chatroom_num", 0);
      if ((!this.oqL) || (i != 0)) {
        break label1329;
      }
      ab.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
      this.ojG.setVisibility(8);
    }
    for (;;)
    {
      this.ojJ.setOnClickListener(new LuckyMoneyPrepareUI.44(this));
      this.ojP.a(this.ojG);
      this.ojP.a(this.oqE);
      this.ojP.a(this.ojI);
      localObject1 = (TextView)findViewById(2131825807);
      this.ojP.i((TextView)localObject1);
      this.gIs = new ap(new LuckyMoneyPrepareUI.45(this), false);
      if (this.ojM != null) {
        this.ojM.setOnTouchListener(new LuckyMoneyPrepareUI.2(this));
      }
      this.oqE.setType(this.mType);
      init();
      this.owp.setOnClickListener(new LuckyMoneyPrepareUI.7(this));
      if (com.tencent.mm.x.c.PJ().a(ac.a.yJi, ac.a.yJk)) {
        this.ows.setVisibility(0);
      }
      if (this.onp != null) {
        a(this.onp.omW);
      }
      AppMethodBeat.o(42997);
      return;
      setMMTitle(2131301267);
      this.oqE.setTitle(getString(2131301334));
      this.oqE.setShowGroupIcon(false);
      break;
      label1261:
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
      break label495;
      label1290:
      this.oqE.setMaxAmount(this.oiV.ois);
      break label786;
      label1307:
      this.ojG.setNum("");
      break label861;
      label1319:
      setMMTitle(2131301330);
      break label1002;
      label1329:
      localObject2 = getString(2131301225);
      Object localObject4 = getString(2131301240);
      localObject1 = getString(2131301219);
      localObject3 = getString(2131301241);
      Object localObject5;
      if ((this.oqL) && (i > 0))
      {
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", new Object[] { Integer.valueOf(i) });
        localObject2 = getString(2131301243);
        localObject1 = getString(2131301242);
        localObject5 = (TextView)findViewById(2131825788);
        ((TextView)localObject5).setText(getString(2131301268, new Object[] { Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8)) }));
        ((TextView)localObject5).setVisibility(0);
      }
      for (;;)
      {
        localObject5 = new com.tencent.mm.plugin.wallet_core.ui.j(this);
        ((com.tencent.mm.plugin.wallet_core.ui.j)localObject5).mColor = getResources().getColor(2131690259);
        SpannableString localSpannableString = new SpannableString((String)localObject2 + (String)localObject4);
        localSpannableString.setSpan(localObject5, ((String)localObject2).length(), ((String)localObject2).length() + ((String)localObject4).length(), 33);
        localObject2 = new SpannableString((String)localObject1 + (String)localObject3);
        localObject4 = new com.tencent.mm.plugin.wallet_core.ui.j(this);
        ((com.tencent.mm.plugin.wallet_core.ui.j)localObject4).mColor = getResources().getColor(2131690259);
        ((SpannableString)localObject2).setSpan(localObject4, ((String)localObject1).length(), ((String)localObject1).length() + ((String)localObject3).length(), 33);
        this.oqE.setGroupIconIv(2130839417);
        ((com.tencent.mm.plugin.wallet_core.ui.j)localObject5).uqj = new LuckyMoneyPrepareUI.41(this, (SpannableString)localObject2);
        ((com.tencent.mm.plugin.wallet_core.ui.j)localObject4).uqj = new LuckyMoneyPrepareUI.42(this, localSpannableString);
        this.kRB.setMovementMethod(LinkMovementMethod.getInstance());
        if (a.a.dDt().dDs()) {
          this.kRB.setOnClickListener(new LuckyMoneyPrepareUI.43(this, localSpannableString, (com.tencent.mm.plugin.wallet_core.ui.j)localObject5, (com.tencent.mm.plugin.wallet_core.ui.j)localObject4));
        }
        this.kRB.setTextColor(getResources().getColor(2131689766));
        this.kRB.setText(localSpannableString);
        this.kRB.setVisibility(0);
        break;
        if (this.ejF == 2)
        {
          ab.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
          this.ojI.setVisibility(8);
        }
      }
      label1755:
      if (this.mType == 1)
      {
        this.kRB.setText(this.oiV.onj);
        this.kRB.setVisibility(0);
      }
      else if (this.mType == 0)
      {
        this.kRB.setText(this.oiV.onk);
        this.kRB.setVisibility(0);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(43011);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(43011);
      return;
      if ((paramIntent != null) && (paramIntent.hasExtra("key_realname_guide_helper"))) {
        this.oww = ((RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper"));
      }
      Object localObject1;
      Object localObject2;
      if (paramInt2 == -1)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bNH()), Integer.valueOf(5) });
        localObject1 = getIntent().getStringExtra("key_username");
        if ((this.oqL) && (!bo.isNullOrNil((String)localObject1)))
        {
          localObject2 = br.F(this.oqM, "msg");
          if (localObject2 == null)
          {
            ab.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
            finish();
            AppMethodBeat.o(43011);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.paymsgid");
          if (com.tencent.mm.plugin.luckymoney.b.a.bMG().bMJ().Sr((String)localObject2))
          {
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
            if (!x.J(this.oqM, (String)localObject1, 1))
            {
              ab.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
              com.tencent.mm.plugin.luckymoney.b.a.bMG().bMJ().Ss((String)localObject2);
            }
            label294:
            g(paramInt2, paramIntent);
            this.owy = new com.tencent.mm.g.b.a.ad();
            this.owy.cTZ = this.ova;
            localObject2 = this.owy;
            if (this.lkU != null) {
              break label397;
            }
            localObject1 = "";
            label340:
            ((com.tencent.mm.g.b.a.ad)localObject2).fy((String)localObject1);
            this.owy.ake();
            finish();
          }
        }
        for (;;)
        {
          localObject1 = "";
          if (paramIntent != null) {
            localObject1 = paramIntent.getStringExtra("key_trans_id");
          }
          Sz((String)localObject1);
          break;
          ab.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
          break label294;
          label397:
          localObject1 = this.lkU.Al();
          break label340;
          bNQ();
          localObject1 = findViewById(2131825802);
          this.oqF.setVisibility(0);
          x.a((View)localObject1, null);
          this.lqP.setOnClickListener(new LuckyMoneyPrepareUI.32(this));
          ((ImageView)findViewById(2131825804)).setOnClickListener(new LuckyMoneyPrepareUI.34(this));
          g(paramInt2, paramIntent);
        }
      }
      if (com.tencent.mm.plugin.wallet_core.utils.c.av(paramIntent))
      {
        finish();
        AppMethodBeat.o(43011);
        return;
      }
      if (com.tencent.mm.plugin.wallet_core.utils.c.aw(paramIntent))
      {
        AppMethodBeat.o(43011);
        return;
      }
      g(paramInt2, paramIntent);
      continue;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bNH()), Integer.valueOf(7), localObject1 });
        if (!bo.isNullOrNil((String)localObject1)) {
          doSceneProgress(new ar(((String)localObject1).replaceAll(",", "|"), this.oqJ, "v1.0"));
        } else {
          finish();
        }
      }
      else if (paramInt2 == 0)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(getContext(), LuckyMoneyMyRecordUI.class);
        ((Intent)localObject1).putExtra("key_type", 1);
        startActivity((Intent)localObject1);
        continue;
        if ((paramIntent != null) && (paramIntent.hasExtra("result_data")))
        {
          localObject1 = paramIntent.getBundleExtra("result_data");
          if (localObject1 != null)
          {
            int i = bo.getInt(((Bundle)localObject1).getString("payState", "2"), 0);
            ab.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i + ";STATE_H5_PAY_SUCC=0");
            if (i == 0) {
              finish();
            }
          }
          else
          {
            ab.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
            continue;
            h(paramInt2, paramIntent);
            continue;
            if (paramInt2 == -1)
            {
              this.oqH.removeAllViews();
              jd(true);
              if (paramIntent != null)
              {
                localObject1 = paramIntent.getByteArrayExtra(e.e.yVc);
                if (localObject1 != null)
                {
                  localObject2 = new aus();
                  try
                  {
                    ((aus)localObject2).parseFrom((byte[])localObject1);
                    a((aus)localObject2);
                  }
                  catch (IOException localIOException)
                  {
                    ab.printErrStackTrace("MicroMsg.LuckyMoneyPrepareUI", localIOException, "", new Object[0]);
                  }
                }
              }
            }
            else
            {
              jd(false);
              com.tencent.mm.plugin.report.service.h.qsU.e(16822, new Object[] { Integer.valueOf(2) });
              continue;
              if (paramInt2 == -1)
              {
                String str = "";
                if (paramIntent != null) {
                  str = paramIntent.getStringExtra("gif_md5");
                }
                if (!bo.isNullOrNil(str))
                {
                  this.lkU = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNn.asP(str);
                  A(this.lkU);
                }
                else
                {
                  ab.i("MicroMsg.LuckyMoneyPrepareUI", "md5 == null go emoji capture failed!");
                }
              }
              else
              {
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "go emoji capture failed!");
              }
            }
          }
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(42998);
    finish();
    AppMethodBeat.o(42998);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42994);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131690248));
    setActionbarElementColor(-16777216);
    hideActionbarLine();
    this.mType = getIntent().getIntExtra("key_type", 1);
    this.oqI = getIntent().getIntExtra("key_way", 3);
    this.ejF = getIntent().getIntExtra("key_from", 0);
    if (this.ejF == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.oqL = bool;
      this.mChannel = getIntent().getIntExtra("pay_channel", -1);
      jd(false);
      com.tencent.mm.plugin.luckymoney.b.a.bMG();
      this.oiV = com.tencent.mm.plugin.luckymoney.b.a.bMH().bNk();
      com.tencent.mm.plugin.luckymoney.b.a.bMG();
      this.onp = com.tencent.mm.plugin.luckymoney.b.a.bMH().bNl();
      ab.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.oqI + "mChannel:" + this.mChannel);
      ab.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.oqL + ", config " + this.oiV);
      initView();
      com.tencent.mm.sdk.b.a.ymk.b(this.owK);
      this.mPayLoopInterruptListener.alive();
      com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bNH()), Integer.valueOf(1) });
      com.tencent.mm.wallet_core.b.dRI();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.dpQ();
      AppMethodBeat.o(42994);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(43004);
    super.onDestroy();
    this.ojP.clear();
    this.gIs.dtj();
    if ((this.gKM != null) && (this.gKM.isShowing())) {
      this.gKM.dismiss();
    }
    if (this.osX != null)
    {
      ab.i("MicroMsg.LuckyMoneyPrepareUI", "commentfooter release");
      this.osX.onPause();
      this.osX.Ay();
      this.osX.destroy();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.owK);
    this.mPayLoopInterruptListener.dead();
    AppMethodBeat.o(43004);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(43013);
    if ((paramInt == 4) && (this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      AppMethodBeat.o(43013);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(43013);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42995);
    super.onResume();
    addSceneEndListener(1970);
    AppMethodBeat.o(42995);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(43007);
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramm.getType());
    if ((paramm instanceof ao))
    {
      if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_HONGBAO_PAY_SWTICH_KEY"))) {}
      for (int i = 1;; i = 0)
      {
        if ((this.gKM != null) && (this.gKM.isShowing()) && (i == 0)) {
          this.gKM.dismiss();
        }
        if (!this.owJ) {
          break;
        }
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
        AppMethodBeat.o(43007);
        return true;
      }
      ao localao = (ao)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.oqK = localao.kNn;
        this.oqJ = localao.ojA;
        this.oqM = localao.opz;
        this.orH = localao.ojA;
        this.owx = localao.opF;
        if (((ao)paramm).isJumpRemind())
        {
          ab.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() NetScenePrepareLuckyMoney show JumpRemind Alert");
          ((ao)paramm).jumpRemind.a(this, new LuckyMoneyPrepareUI.20(this));
          AppMethodBeat.o(43007);
          return true;
        }
        paramString = new PayInfo();
        paramString.cnI = localao.opy;
        paramString.cCD = 37;
        paramString.cCy = this.mChannel;
        if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_HONGBAO_PAY_SWTICH_KEY"))) {
          ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).startSNSPay(this, paramString);
        }
        for (;;)
        {
          AppMethodBeat.o(43007);
          return true;
          com.tencent.mm.pluginsdk.wallet.h.a(this, paramString, 1);
        }
      }
      if (paramInt2 == 401)
      {
        this.ojJ.setEnabled(false);
        this.ojJ.setClickable(false);
        this.gIs.ag(5000L, 5000L);
        com.tencent.mm.ui.base.h.bO(this, paramString);
        AppMethodBeat.o(43007);
        return true;
      }
      if (paramInt2 == 268502454)
      {
        com.tencent.mm.ui.base.h.a(this, paramString, "", new LuckyMoneyPrepareUI.21(this, paramm));
        AppMethodBeat.o(43007);
        return true;
      }
      this.cEU = 2;
      paramm = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramm = getString(2131305682);
      }
      com.tencent.mm.ui.base.h.a(this, paramm, null, false, new LuckyMoneyPrepareUI.18(this));
      AppMethodBeat.o(43007);
      return true;
    }
    if ((paramm instanceof ar))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.oqL)
        {
          com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131300637));
          com.tencent.mm.sdk.platformtools.al.p(new LuckyMoneyPrepareUI.23(this), 1800L);
        }
        for (;;)
        {
          AppMethodBeat.o(43007);
          return true;
          bNQ();
          this.oqG.setVisibility(0);
          this.oqG.postDelayed(new LuckyMoneyPrepareUI.24(this), 1000L);
        }
      }
      if (paramInt2 == 402)
      {
        com.tencent.mm.ui.base.h.d(getContext(), paramString, "", getString(2131301313), getString(2131296888), new LuckyMoneyPrepareUI.25(this), new LuckyMoneyPrepareUI.26(this));
        AppMethodBeat.o(43007);
        return true;
      }
    }
    else
    {
      if ((paramm instanceof ag))
      {
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString);
        if ((this.own != null) && (this.own.isShowing())) {
          this.own.dismiss();
        }
        if ((this.owo != null) && (this.owo.isShowing())) {
          this.owo.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = (ag)paramm;
          this.owG = true;
          this.opo = paramString.opo;
          if (!bo.hl(paramString.opp, 1))
          {
            this.ojI.je(true);
            com.tencent.mm.plugin.luckymoney.b.a.bMG();
            this.oiV = com.tencent.mm.plugin.luckymoney.b.a.bMH().bNk();
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.oiV);
            if (this.mType != 1) {
              break label1407;
            }
            this.oqE.setMaxAmount(this.oiV.oiu);
            label841:
            this.oqE.setMinAmount(this.oiV.oit);
            this.ojG.setMaxNum(this.oiV.oir);
            this.owu = paramString.oiw;
            this.owt = paramString.kNE;
            this.owv = paramString.oiG;
            if (bo.isNullOrNil(this.ovh)) {
              this.ovh = paramString.feA;
            }
            if ((!bo.isNullOrNil(this.owv)) && (this.ojI != null)) {
              com.tencent.mm.sdk.platformtools.al.d(new LuckyMoneyPrepareUI.28(this));
            }
            if ((paramString.opf) && (this.oqL))
            {
              paramm = (TextView)findViewById(2131825799);
              paramm.setOnClickListener(new LuckyMoneyPrepareUI.29(this));
              com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bNH()), Integer.valueOf(8) });
              paramm.setVisibility(8);
            }
            if (bo.isNullOrNil(paramString.kNG)) {
              break label1424;
            }
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + paramString.kNG);
            this.ojN.setText(paramString.kNG);
            if (!bo.isNullOrNil(paramString.oph)) {
              this.ojN.setOnClickListener(new LuckyMoneyPrepareUI.30(this, paramString));
            }
            this.ojN.setVisibility(0);
            label1117:
            paramm = new h.c();
            if ((paramString.opj == null) || (bo.isNullOrNil(paramString.opj.content))) {
              break label1436;
            }
            paramm.textColor = getResources().getColor(2131690648);
            label1161:
            this.oqH.removeAllViews();
            h.a(this, this.oqH, paramString.opj, paramm);
            ff(paramString.oix, paramString.oiw);
            c(this.oqE.getInput(), this.owu);
            com.tencent.mm.plugin.luckymoney.b.a.bMG();
            this.onp = com.tencent.mm.plugin.luckymoney.b.a.bMH().bNl();
            init();
            if (this.onp == null) {
              break label1454;
            }
            a(this.onp.omW);
            com.tencent.mm.plugin.report.service.h.qsU.cT(991, 10);
            label1256:
            if (this.owI)
            {
              ab.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick()");
              a(this.owz, this.owA, this.owB, this.owC, this.owD, this.owE);
            }
          }
        }
        for (;;)
        {
          ab.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig waitingGetConfig:%s ifAutoRMBPrePareBtn:%s", new Object[] { Boolean.valueOf(this.owH), Boolean.valueOf(this.owI) });
          this.owH = false;
          this.owI = false;
          AppMethodBeat.o(43007);
          return true;
          this.ojI.je(false);
          if ((this.lkU != null) && (!bo.isNullOrNil(this.lkU.Al()))) {
            this.ojI.A(this.lkU);
          }
          this.ojI.setmOnEmojiSelectClickListener(new LuckyMoneyPrepareUI.27(this, paramString));
          break;
          label1407:
          this.oqE.setMaxAmount(this.oiV.ois);
          break label841;
          label1424:
          this.ojN.setVisibility(8);
          break label1117;
          label1436:
          paramm.textColor = getResources().getColor(2131690159);
          break label1161;
          label1454:
          a(null);
          break label1256;
          if (this.owI)
          {
            paramm = paramString;
            if (bo.isNullOrNil(paramString)) {
              paramm = getString(2131296926);
            }
            t.makeText(this, paramm, 0).show();
          }
        }
      }
      if ((paramm instanceof ah))
      {
        removeSceneEndListener(1647);
        if ((this.gKM != null) && (this.gKM.isShowing())) {
          this.gKM.dismiss();
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((ah)paramm).kNR;
          if (!bo.isNullOrNil(paramString))
          {
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
            paramm = new Intent();
            paramm.putExtra("rawUrl", paramString);
            paramm.putExtra("showShare", false);
            com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramm, 3);
          }
          for (;;)
          {
            AppMethodBeat.o(43007);
            return true;
            ab.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
          }
        }
      }
      else
      {
        if ((paramm instanceof com.tencent.mm.plugin.luckymoney.f2f.a.d))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0)) {
            if ((this.mKindaEnable) && (((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_F2F_HONGBAO_PAY_SWTICH_KEY")))
            {
              paramInt1 = 1;
              if ((this.gKM != null) && (this.gKM.isShowing()) && (paramInt1 == 0)) {
                this.gKM.dismiss();
              }
              this.orH = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramm).ojA;
              this.owx = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramm).okQ;
              paramString = new PayInfo();
              paramString.cnI = ((com.tencent.mm.plugin.luckymoney.f2f.a.d)paramm).cnI;
              paramString.cCD = 37;
              if ((!this.mKindaEnable) || (!((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_F2F_HONGBAO_PAY_SWTICH_KEY"))) {
                break label1841;
              }
              if (paramString.wgv == null) {
                paramString.wgv = new Bundle();
              }
              paramString.wgv.putBoolean("isF2FHongBao", true);
              ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).startSNSPay(this, paramString);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(43007);
            return true;
            paramInt1 = 0;
            break;
            label1841:
            com.tencent.mm.wallet_core.c.ad.q(37, paramString.cnI, paramInt2);
            com.tencent.mm.pluginsdk.wallet.h.a(this, paramString, 4);
            continue;
            com.tencent.mm.wallet_core.c.ad.q(37, "", paramInt2);
            if (!bo.isNullOrNil(paramString)) {
              com.tencent.mm.ui.base.h.b(this, paramString, getString(2131301198), true);
            }
            this.gKM.dismiss();
          }
        }
        if ((paramm instanceof com.tencent.mm.plugin.luckymoney.model.al))
        {
          AppMethodBeat.o(43007);
          return true;
        }
      }
    }
    AppMethodBeat.o(43007);
    return false;
  }
  
  public void onStop()
  {
    AppMethodBeat.i(42996);
    super.onStop();
    removeSceneEndListener(1970);
    AppMethodBeat.o(42996);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI
 * JD-Core Version:    0.7.0.1
 */