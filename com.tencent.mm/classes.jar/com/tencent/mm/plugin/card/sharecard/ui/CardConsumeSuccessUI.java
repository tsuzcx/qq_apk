package com.tencent.mm.plugin.card.sharecard.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CardConsumeSuccessUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private final String TAG;
  private p ftP;
  private View.OnClickListener iAw;
  ap kQO;
  private View mContentView;
  private long mStartTime;
  private String nqb;
  private String nrn;
  private TextView nvZ;
  public ArrayList<String> nwA;
  public ArrayList<String> nwB;
  private TextView nwa;
  private TextView nwl;
  private TextView nwm;
  private TextView nwn;
  private TextView nwo;
  private ImageView nwp;
  private Button nwq;
  private CheckBox nwr;
  private j nws;
  private String nwt;
  private String nwu;
  int nwv;
  int nww;
  public int nwx;
  private String nwy;
  private String nwz;
  
  public CardConsumeSuccessUI()
  {
    AppMethodBeat.i(113055);
    this.TAG = "MicroMsg.CardConsumeSuccessUI";
    this.nqb = "";
    this.nwt = "";
    this.nrn = "";
    this.nwu = "";
    this.nwv = 0;
    this.nww = 0;
    this.nwx = 0;
    this.nwy = "";
    this.nwz = "";
    this.nwA = new ArrayList();
    this.nwB = new ArrayList();
    this.mStartTime = 0L;
    this.kQO = new ap(Looper.getMainLooper());
    this.ftP = null;
    this.iAw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113052);
        if (paramAnonymousView.getId() == 2131296314)
        {
          CardConsumeSuccessUI.a(CardConsumeSuccessUI.this);
          AppMethodBeat.o(113052);
          return;
        }
        if (paramAnonymousView.getId() == 2131305532)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("KLabel_range_index", CardConsumeSuccessUI.this.nwx);
          paramAnonymousView.putExtra("Klabel_name_list", CardConsumeSuccessUI.b(CardConsumeSuccessUI.this));
          paramAnonymousView.putExtra("Kother_user_name_list", CardConsumeSuccessUI.c(CardConsumeSuccessUI.this));
          paramAnonymousView.putExtra("k_sns_label_ui_title", CardConsumeSuccessUI.this.getString(2131756983));
          paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
          paramAnonymousView.putExtra("KLabel_is_filter_private", true);
          com.tencent.mm.bs.d.b(CardConsumeSuccessUI.this, "sns", ".ui.SnsLabelUI", paramAnonymousView, 1);
        }
        AppMethodBeat.o(113052);
      }
    };
    AppMethodBeat.o(113055);
  }
  
  private boolean QK(String paramString)
  {
    AppMethodBeat.i(113058);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
      AppMethodBeat.o(113058);
      return false;
    }
    this.nws = s.Ru(paramString);
    if (this.nws == null)
    {
      ad.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(113058);
      return false;
    }
    AppMethodBeat.o(113058);
    return true;
  }
  
  @TargetApi(16)
  private void QL(String paramString)
  {
    AppMethodBeat.i(113064);
    int i = l.Rm(paramString);
    this.mContentView.setBackgroundColor(i);
    setActionbarColor(i);
    if (com.tencent.mm.compatible.util.d.lf(16)) {
      this.nwq.setBackground(l.eN(i, getResources().getDimensionPixelSize(2131165954) / 2));
    }
    for (;;)
    {
      this.mContentView.invalidate();
      AppMethodBeat.o(113064);
      return;
      this.nwq.setBackgroundDrawable(l.eN(i, getResources().getDimensionPixelSize(2131165954) / 2));
    }
  }
  
  private void QM(String paramString)
  {
    AppMethodBeat.i(113066);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131756792);
    }
    com.tencent.mm.ui.base.h.a(this, str, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(113054);
        paramAnonymousDialogInterface.dismiss();
        CardConsumeSuccessUI.bJJ();
        CardConsumeSuccessUI.this.finish();
        AppMethodBeat.o(113054);
      }
    });
    AppMethodBeat.o(113066);
  }
  
  private void bJH()
  {
    AppMethodBeat.i(113063);
    getContentView().setBackgroundColor(getResources().getColor(2131100084));
    findViewById(2131304240).setVisibility(4);
    AppMethodBeat.o(113063);
  }
  
  private String bJI()
  {
    AppMethodBeat.i(113070);
    String str;
    if ((!TextUtils.isEmpty(this.nwy)) && (!TextUtils.isEmpty(this.nwz)))
    {
      str = this.nwy + "," + l.Rp(this.nwz);
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.nwy))
    {
      str = this.nwy;
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.nwz))
    {
      str = l.Rp(this.nwz);
      AppMethodBeat.o(113070);
      return str;
    }
    AppMethodBeat.o(113070);
    return "";
  }
  
  private void cE()
  {
    AppMethodBeat.i(113062);
    if (this.nws == null)
    {
      ad.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
      AppMethodBeat.o(113062);
      return;
    }
    findViewById(2131304240).setVisibility(0);
    ro localro;
    if ((!TextUtils.isEmpty(this.nws.nvn)) && (!TextUtils.isEmpty(this.nws.nvo)))
    {
      this.nwr.setText(this.nws.nvn);
      this.nwr.setVisibility(0);
      if ((this.nws.cTm == null) || (this.nws.cTm.size() <= 0)) {
        break label413;
      }
      this.nwm.setText(getString(2131756821, new Object[] { Integer.valueOf(this.nws.cTm.size()) }));
      localro = ((com.tencent.mm.plugin.card.sharecard.model.q)this.nws.cTm.get(0)).nsC;
      if (localro == null) {
        break label398;
      }
      QL(localro.gHT);
      this.nvZ.setText(localro.nsK);
      this.nwa.setText(localro.title);
      int i = getResources().getDimensionPixelSize(2131165979);
      if (TextUtils.isEmpty(localro.gGR)) {
        break label351;
      }
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aih();
      o.ayK();
      ((c.a)localObject).hkl = null;
      ((c.a)localObject).gjt = m.Qy(localro.gGR);
      ((c.a)localObject).hjU = true;
      ((c.a)localObject).gkG = true;
      ((c.a)localObject).hjS = true;
      ((c.a)localObject).gjw = i;
      ((c.a)localObject).gjv = i;
      ((c.a)localObject).hkf = 2131233400;
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(localro.gGR, this.nwp, (c)localObject);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localro.CRN)) {
        break label372;
      }
      this.nwq.setText(2131756818);
      AppMethodBeat.o(113062);
      return;
      this.nwr.setVisibility(8);
      ad.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
      break;
      label351:
      ad.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
      this.nwp.setImageResource(2131233400);
    }
    label372:
    ad.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
    this.nwq.setText(localro.CRN);
    AppMethodBeat.o(113062);
    return;
    label398:
    ad.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    AppMethodBeat.o(113062);
    return;
    label413:
    this.nwq.setEnabled(false);
    ad.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
    AppMethodBeat.o(113062);
  }
  
  private void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(113056);
    if (paramBoolean)
    {
      this.ftP = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(113056);
      return;
    }
    if ((this.ftP != null) && (this.ftP.isShowing()))
    {
      this.ftP.dismiss();
      this.ftP = null;
    }
    AppMethodBeat.o(113056);
  }
  
  private static void yX(int paramInt)
  {
    AppMethodBeat.i(113068);
    ad.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is ".concat(String.valueOf(paramInt)));
    ch localch = new ch();
    localch.dey.bRZ = paramInt;
    com.tencent.mm.sdk.b.a.ESL.l(localch);
    AppMethodBeat.o(113068);
  }
  
  public int getLayoutId()
  {
    return 2131493265;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113061);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113051);
        CardConsumeSuccessUI.this.finish();
        CardConsumeSuccessUI.bJJ();
        AppMethodBeat.o(113051);
        return true;
      }
    });
    this.mContentView = getContentView();
    this.nvZ = ((TextView)findViewById(2131297743));
    this.nwa = ((TextView)findViewById(2131297863));
    this.nwl = ((TextView)findViewById(2131297773));
    this.nwm = ((TextView)findViewById(2131305533));
    this.nwn = ((TextView)findViewById(2131305532));
    this.nwo = ((TextView)findViewById(2131305531));
    this.nwp = ((ImageView)findViewById(2131297828));
    this.nwq = ((Button)findViewById(2131296314));
    this.nwr = ((CheckBox)findViewById(2131296966));
    this.nwq.setOnClickListener(this.iAw);
    this.nwr.setOnClickListener(this.iAw);
    this.nwn.setOnClickListener(this.iAw);
    if (this.nws != null) {
      cE();
    }
    AppMethodBeat.o(113061);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(113069);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113069);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(113069);
        return;
      }
      this.nwx = paramIntent.getIntExtra("Ktag_range_index", 0);
      ad.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.nwx) });
      if (this.nwx >= 2)
      {
        this.nwy = paramIntent.getStringExtra("Klabel_name_list");
        this.nwz = paramIntent.getStringExtra("Kother_user_name_list");
        ad.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.nwx), this.nwy });
        if ((TextUtils.isEmpty(this.nwy)) && (TextUtils.isEmpty(this.nwz)))
        {
          ad.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
          AppMethodBeat.o(113069);
          return;
        }
        paramIntent = Arrays.asList(this.nwy.split(","));
        this.nwB = l.cE(paramIntent);
        this.nwA = l.cD(paramIntent);
        if ((this.nwz != null) && (this.nwz.length() > 0))
        {
          paramIntent = Arrays.asList(this.nwz.split(","));
          this.nwA.addAll(paramIntent);
        }
        if (this.nwB != null) {
          ad.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.nwB.size());
        }
        if (this.nwA != null)
        {
          ad.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.nwA.size());
          paramIntent = this.nwA.iterator();
          while (paramIntent.hasNext()) {
            ad.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (this.nwx == 2)
        {
          this.nwo.setVisibility(0);
          this.nwo.setText(getString(2131756982, new Object[] { bJI() }));
          AppMethodBeat.o(113069);
          return;
        }
        if (this.nwx == 3)
        {
          this.nwo.setVisibility(0);
          this.nwo.setText(getString(2131756981, new Object[] { bJI() }));
          AppMethodBeat.o(113069);
          return;
        }
        this.nwo.setVisibility(8);
        AppMethodBeat.o(113069);
        return;
      }
      this.nwo.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113057);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
    this.mStartTime = System.currentTimeMillis();
    setMMTitle("");
    setResult(0);
    com.tencent.mm.kernel.g.afA().gcy.a(902, this);
    com.tencent.mm.kernel.g.afA().gcy.a(910, this);
    paramBundle = "";
    this.nwv = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject;
    if (this.nwv == 1)
    {
      ad.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
      this.nwt = getIntent().getStringExtra("key_consumed_card_id");
      this.nwu = getIntent().getStringExtra("key_consumed_Code");
      if (TextUtils.isEmpty(this.nwt))
      {
        ad.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
        yX(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      ad.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.nwu);
      iF(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d("", this.nwt, this.nwu);
      com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
      bJH();
    }
    for (this.nww = 7;; this.nww = 4)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(11324, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.nww), "", Integer.valueOf(0), "" });
      initView();
      if (!TextUtils.isEmpty(paramBundle)) {
        QL(paramBundle);
      }
      AppMethodBeat.o(113057);
      return;
      if (this.nwv != 2) {
        break;
      }
      ad.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
      this.nqb = getIntent().getStringExtra("key_card_id");
      if (TextUtils.isEmpty(this.nqb))
      {
        ad.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
        yX(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      ad.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.nqb);
      iF(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d(this.nqb, "", "");
      com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
      bJH();
    }
    ad.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
    this.nqb = getIntent().getStringExtra("KEY_CARD_ID");
    if (!QK(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON")))
    {
      ad.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
      yX(0);
      finish();
      AppMethodBeat.o(113057);
      return;
    }
    if ((this.nws != null) && (!bt.gL(this.nws.cTm)))
    {
      paramBundle = ((com.tencent.mm.plugin.card.sharecard.model.q)this.nws.cTm.get(0)).nsC;
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.gHT;; paramBundle = "")
    {
      localObject = paramBundle;
      if (bt.isNullOrNil(paramBundle)) {
        localObject = getIntent().getStringExtra("KEY_CARD_COLOR");
      }
      this.nww = getIntent().getIntExtra("key_stastic_scene", 0);
      paramBundle = (Bundle)localObject;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113060);
    com.tencent.mm.kernel.g.afA().gcy.b(902, this);
    com.tencent.mm.kernel.g.afA().gcy.b(910, this);
    long l = System.currentTimeMillis() - this.mStartTime;
    if (!TextUtils.isEmpty(this.nqb)) {
      com.tencent.mm.plugin.report.service.h.vKh.f(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.nwv), this.nrn, this.nqb, Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113060);
      return;
      com.tencent.mm.plugin.report.service.h.vKh.f(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.nwv), this.nrn, this.nwt, Long.valueOf(l) });
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113067);
    if (paramInt == 4)
    {
      ad.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
      yX(0);
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113067);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113059);
    super.onResume();
    AppMethodBeat.o(113059);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(113065);
    ad.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " scene cmd is " + paramn.getType());
    iF(false);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.g)paramn;
        if (paramString.ntx == 0)
        {
          com.tencent.mm.ui.base.h.cf(this, getString(2131756794));
          setResult(-1);
          this.nwq.setEnabled(false);
          l.bMM();
          ad.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
          yX(-1);
          paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).ntw;
          paramn = new ShareCardInfo();
          f.a(paramn, paramString);
          l.a(paramn);
          am.bJc().onChange();
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        ad.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + paramString.ntx);
        com.tencent.mm.plugin.card.d.d.c(this, paramString.nty);
        com.tencent.mm.ui.base.h.cf(this, getString(2131756790));
        AppMethodBeat.o(113065);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramn;
        if (paramString.ntx == 0)
        {
          if ((!TextUtils.isEmpty(paramString.ntw)) && (QK(paramString.ntw)))
          {
            ad.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
            this.kQO.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(113053);
                CardConsumeSuccessUI.d(CardConsumeSuccessUI.this);
                AppMethodBeat.o(113053);
              }
            });
            AppMethodBeat.o(113065);
            return;
          }
          ad.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
          if (this.nwv == 1)
          {
            yX(0);
            finish();
            AppMethodBeat.o(113065);
            return;
          }
          bJH();
          QM(paramString.nty);
          if (bt.isNullOrNil(paramString.nty))
          {
            com.tencent.mm.ui.base.h.cf(this, getString(2131756792));
            AppMethodBeat.o(113065);
            return;
          }
          com.tencent.mm.ui.base.h.cf(this, paramString.nty);
          AppMethodBeat.o(113065);
          return;
        }
        if (this.nwv == 1)
        {
          yX(0);
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        ad.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + paramString.ntx);
        bJH();
        QM(paramString.nty);
        AppMethodBeat.o(113065);
      }
    }
    else
    {
      if (((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d)) && (this.nwv == 1))
      {
        yX(0);
        finish();
        AppMethodBeat.o(113065);
        return;
      }
      com.tencent.mm.plugin.card.d.d.c(this, paramString);
    }
    AppMethodBeat.o(113065);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI
 * JD-Core Version:    0.7.0.1
 */