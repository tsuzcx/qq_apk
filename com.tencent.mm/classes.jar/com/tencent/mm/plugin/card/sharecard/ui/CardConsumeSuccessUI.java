package com.tencent.mm.plugin.card.sharecard.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CardConsumeSuccessUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private View Qz;
  private final String TAG;
  private com.tencent.mm.ui.base.p ehb;
  private View.OnClickListener gMO;
  ak ipC;
  private String kkW;
  private String kmh;
  private TextView kqF;
  private TextView kqG;
  private TextView kqS;
  private TextView kqT;
  private TextView kqU;
  private TextView kqV;
  private ImageView kqW;
  private Button kqX;
  private CheckBox kqY;
  private j kqZ;
  private String kra;
  private String krb;
  int krc;
  int krd;
  public int kre;
  private String krf;
  private String krg;
  public ArrayList<String> krh;
  public ArrayList<String> kri;
  private long mStartTime;
  
  public CardConsumeSuccessUI()
  {
    AppMethodBeat.i(88121);
    this.TAG = "MicroMsg.CardConsumeSuccessUI";
    this.kkW = "";
    this.kra = "";
    this.kmh = "";
    this.krb = "";
    this.krc = 0;
    this.krd = 0;
    this.kre = 0;
    this.krf = "";
    this.krg = "";
    this.krh = new ArrayList();
    this.kri = new ArrayList();
    this.mStartTime = 0L;
    this.ipC = new ak(Looper.getMainLooper());
    this.ehb = null;
    this.gMO = new CardConsumeSuccessUI.2(this);
    AppMethodBeat.o(88121);
  }
  
  private boolean Ia(String paramString)
  {
    AppMethodBeat.i(88124);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
      AppMethodBeat.o(88124);
      return false;
    }
    this.kqZ = r.IJ(paramString);
    if (this.kqZ == null)
    {
      ab.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(88124);
      return false;
    }
    AppMethodBeat.o(88124);
    return true;
  }
  
  @TargetApi(16)
  private void Ib(String paramString)
  {
    AppMethodBeat.i(88130);
    int i = l.IB(paramString);
    this.Qz.setBackgroundColor(i);
    setActionbarColor(i);
    if (com.tencent.mm.compatible.util.d.fv(16)) {
      this.kqX.setBackground(l.dR(i, getResources().getDimensionPixelSize(2131428155) / 2));
    }
    for (;;)
    {
      this.Qz.invalidate();
      AppMethodBeat.o(88130);
      return;
      this.kqX.setBackgroundDrawable(l.dR(i, getResources().getDimensionPixelSize(2131428155) / 2));
    }
  }
  
  private void Ic(String paramString)
  {
    AppMethodBeat.i(88132);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131297860);
    }
    com.tencent.mm.ui.base.h.a(this, str, "", false, new CardConsumeSuccessUI.4(this));
    AppMethodBeat.o(88132);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(88128);
    if (this.kqZ == null)
    {
      ab.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
      AppMethodBeat.o(88128);
      return;
    }
    findViewById(2131822048).setVisibility(0);
    pg localpg;
    if ((!TextUtils.isEmpty(this.kqZ.kpT)) && (!TextUtils.isEmpty(this.kqZ.kpU)))
    {
      this.kqY.setText(this.kqZ.kpT);
      this.kqY.setVisibility(0);
      if ((this.kqZ.ceo == null) || (this.kqZ.ceo.size() <= 0)) {
        break label413;
      }
      this.kqT.setText(getString(2131297889, new Object[] { Integer.valueOf(this.kqZ.ceo.size()) }));
      localpg = ((q)this.kqZ.ceo.get(0)).kno;
      if (localpg == null) {
        break label398;
      }
      Ib(localpg.color);
      this.kqF.setText(localpg.knw);
      this.kqG.setText(localpg.title);
      int i = getResources().getDimensionPixelSize(2131428180);
      if (TextUtils.isEmpty(localpg.kmm)) {
        break label351;
      }
      Object localObject = new c.a();
      ((c.a)localObject).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject).eOd = null;
      ((c.a)localObject).eNO = com.tencent.mm.plugin.card.model.m.HO(localpg.kmm);
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eOk = true;
      ((c.a)localObject).eNK = true;
      ((c.a)localObject).eNT = i;
      ((c.a)localObject).eNS = i;
      ((c.a)localObject).eNY = 2130839758;
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(localpg.kmm, this.kqW, (c)localObject);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localpg.wGi)) {
        break label372;
      }
      this.kqX.setText(2131297886);
      AppMethodBeat.o(88128);
      return;
      this.kqY.setVisibility(8);
      ab.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
      break;
      label351:
      ab.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
      this.kqW.setImageResource(2130839758);
    }
    label372:
    ab.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
    this.kqX.setText(localpg.wGi);
    AppMethodBeat.o(88128);
    return;
    label398:
    ab.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    AppMethodBeat.o(88128);
    return;
    label413:
    this.kqX.setEnabled(false);
    ab.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
    AppMethodBeat.o(88128);
  }
  
  private void bcJ()
  {
    AppMethodBeat.i(88129);
    getContentView().setBackgroundColor(getResources().getColor(2131689824));
    findViewById(2131822048).setVisibility(4);
    AppMethodBeat.o(88129);
  }
  
  private String bcK()
  {
    AppMethodBeat.i(88136);
    String str;
    if ((!TextUtils.isEmpty(this.krf)) && (!TextUtils.isEmpty(this.krg)))
    {
      str = this.krf + "," + l.IE(this.krg);
      AppMethodBeat.o(88136);
      return str;
    }
    if (!TextUtils.isEmpty(this.krf))
    {
      str = this.krf;
      AppMethodBeat.o(88136);
      return str;
    }
    if (!TextUtils.isEmpty(this.krg))
    {
      str = l.IE(this.krg);
      AppMethodBeat.o(88136);
      return str;
    }
    AppMethodBeat.o(88136);
    return "";
  }
  
  private void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(88122);
    if (paramBoolean)
    {
      this.ehb = com.tencent.mm.ui.base.p.b(this, getString(2131301086), true, null);
      AppMethodBeat.o(88122);
      return;
    }
    if ((this.ehb != null) && (this.ehb.isShowing()))
    {
      this.ehb.dismiss();
      this.ehb = null;
    }
    AppMethodBeat.o(88122);
  }
  
  private static void te(int paramInt)
  {
    AppMethodBeat.i(88134);
    ab.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is ".concat(String.valueOf(paramInt)));
    cc localcc = new cc();
    localcc.cpB.bpE = paramInt;
    com.tencent.mm.sdk.b.a.ymk.l(localcc);
    AppMethodBeat.o(88134);
  }
  
  public int getLayoutId()
  {
    return 2130968923;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88127);
    setBackBtn(new CardConsumeSuccessUI.1(this));
    this.Qz = getContentView();
    this.kqF = ((TextView)findViewById(2131821971));
    this.kqG = ((TextView)findViewById(2131821973));
    this.kqS = ((TextView)findViewById(2131821974));
    this.kqT = ((TextView)findViewById(2131822051));
    this.kqU = ((TextView)findViewById(2131822054));
    this.kqV = ((TextView)findViewById(2131822055));
    this.kqW = ((ImageView)findViewById(2131821970));
    this.kqX = ((Button)findViewById(2131822052));
    this.kqY = ((CheckBox)findViewById(2131822053));
    this.kqX.setOnClickListener(this.gMO);
    this.kqY.setOnClickListener(this.gMO);
    this.kqU.setOnClickListener(this.gMO);
    if (this.kqZ != null) {
      bJ();
    }
    AppMethodBeat.o(88127);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(88135);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88135);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(88135);
        return;
      }
      this.kre = paramIntent.getIntExtra("Ktag_range_index", 0);
      ab.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.kre) });
      if (this.kre >= 2)
      {
        this.krf = paramIntent.getStringExtra("Klabel_name_list");
        this.krg = paramIntent.getStringExtra("Kother_user_name_list");
        ab.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.kre), this.krf });
        if ((TextUtils.isEmpty(this.krf)) && (TextUtils.isEmpty(this.krg)))
        {
          ab.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
          AppMethodBeat.o(88135);
          return;
        }
        paramIntent = Arrays.asList(this.krf.split(","));
        this.kri = l.bi(paramIntent);
        this.krh = l.bh(paramIntent);
        if ((this.krg != null) && (this.krg.length() > 0))
        {
          paramIntent = Arrays.asList(this.krg.split(","));
          this.krh.addAll(paramIntent);
        }
        if (this.kri != null) {
          ab.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.kri.size());
        }
        if (this.krh != null)
        {
          ab.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.krh.size());
          paramIntent = this.krh.iterator();
          while (paramIntent.hasNext()) {
            ab.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (this.kre == 2)
        {
          this.kqV.setVisibility(0);
          this.kqV.setText(getString(2131298040, new Object[] { bcK() }));
          AppMethodBeat.o(88135);
          return;
        }
        if (this.kre == 3)
        {
          this.kqV.setVisibility(0);
          this.kqV.setText(getString(2131298039, new Object[] { bcK() }));
          AppMethodBeat.o(88135);
          return;
        }
        this.kqV.setVisibility(8);
        AppMethodBeat.o(88135);
        return;
      }
      this.kqV.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88123);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
    this.mStartTime = System.currentTimeMillis();
    setMMTitle("");
    setResult(0);
    com.tencent.mm.kernel.g.RK().eHt.a(902, this);
    com.tencent.mm.kernel.g.RK().eHt.a(910, this);
    paramBundle = "";
    this.krc = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject;
    if (this.krc == 1)
    {
      ab.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
      this.kra = getIntent().getStringExtra("key_consumed_card_id");
      this.krb = getIntent().getStringExtra("key_consumed_Code");
      if (TextUtils.isEmpty(this.kra))
      {
        ab.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
        te(0);
        finish();
        AppMethodBeat.o(88123);
        return;
      }
      ab.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.krb);
      fV(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d("", this.kra, this.krb);
      com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject, 0);
      bcJ();
    }
    for (this.krd = 7;; this.krd = 4)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(11324, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.krd), "", Integer.valueOf(0), "" });
      initView();
      if (!TextUtils.isEmpty(paramBundle)) {
        Ib(paramBundle);
      }
      AppMethodBeat.o(88123);
      return;
      if (this.krc != 2) {
        break;
      }
      ab.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
      this.kkW = getIntent().getStringExtra("key_card_id");
      if (TextUtils.isEmpty(this.kkW))
      {
        ab.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
        te(0);
        finish();
        AppMethodBeat.o(88123);
        return;
      }
      ab.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.kkW);
      fV(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d(this.kkW, "", "");
      com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject, 0);
      bcJ();
    }
    ab.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
    this.kkW = getIntent().getStringExtra("KEY_CARD_ID");
    if (!Ia(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON")))
    {
      ab.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
      te(0);
      finish();
      AppMethodBeat.o(88123);
      return;
    }
    if ((this.kqZ != null) && (!bo.es(this.kqZ.ceo)))
    {
      paramBundle = ((q)this.kqZ.ceo.get(0)).kno;
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.color;; paramBundle = "")
    {
      localObject = paramBundle;
      if (bo.isNullOrNil(paramBundle)) {
        localObject = getIntent().getStringExtra("KEY_CARD_COLOR");
      }
      this.krd = getIntent().getIntExtra("key_stastic_scene", 0);
      paramBundle = (Bundle)localObject;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88126);
    com.tencent.mm.kernel.g.RK().eHt.b(902, this);
    com.tencent.mm.kernel.g.RK().eHt.b(910, this);
    long l = System.currentTimeMillis() - this.mStartTime;
    if (!TextUtils.isEmpty(this.kkW)) {
      com.tencent.mm.plugin.report.service.h.qsU.e(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.krc), this.kmh, this.kkW, Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(88126);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.krc), this.kmh, this.kra, Long.valueOf(l) });
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(88133);
    if (paramInt == 4)
    {
      ab.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
      te(0);
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(88133);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(88125);
    super.onResume();
    AppMethodBeat.o(88125);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(88131);
    ab.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " scene cmd is " + paramm.getType());
    fV(false);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.g)paramm;
        if (paramString.koj == 0)
        {
          com.tencent.mm.ui.base.h.bO(this, getString(2131297862));
          setResult(-1);
          this.kqX.setEnabled(false);
          l.bfB();
          ab.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
          te(-1);
          paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).koi;
          paramm = new ShareCardInfo();
          com.tencent.mm.plugin.card.d.f.a(paramm, paramString);
          l.a(paramm);
          am.bck().onChange();
          finish();
          AppMethodBeat.o(88131);
          return;
        }
        ab.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + paramString.koj);
        com.tencent.mm.plugin.card.d.d.c(this, paramString.kok);
        com.tencent.mm.ui.base.h.bO(this, getString(2131297858));
        AppMethodBeat.o(88131);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramm;
        if (paramString.koj == 0)
        {
          if ((!TextUtils.isEmpty(paramString.koi)) && (Ia(paramString.koi)))
          {
            ab.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
            this.ipC.post(new CardConsumeSuccessUI.3(this));
            AppMethodBeat.o(88131);
            return;
          }
          ab.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
          if (this.krc == 1)
          {
            te(0);
            finish();
            AppMethodBeat.o(88131);
            return;
          }
          bcJ();
          Ic(paramString.kok);
          if (bo.isNullOrNil(paramString.kok))
          {
            com.tencent.mm.ui.base.h.bO(this, getString(2131297860));
            AppMethodBeat.o(88131);
            return;
          }
          com.tencent.mm.ui.base.h.bO(this, paramString.kok);
          AppMethodBeat.o(88131);
          return;
        }
        if (this.krc == 1)
        {
          te(0);
          finish();
          AppMethodBeat.o(88131);
          return;
        }
        ab.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + paramString.koj);
        bcJ();
        Ic(paramString.kok);
        AppMethodBeat.o(88131);
      }
    }
    else
    {
      if (((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.d)) && (this.krc == 1))
      {
        te(0);
        finish();
        AppMethodBeat.o(88131);
        return;
      }
      com.tencent.mm.plugin.card.d.d.c(this, paramString);
    }
    AppMethodBeat.o(88131);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI
 * JD-Core Version:    0.7.0.1
 */