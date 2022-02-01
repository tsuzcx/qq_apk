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
import com.tencent.mm.g.a.ck;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CardConsumeSuccessUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private final String TAG;
  private p fQJ;
  private View.OnClickListener jtG;
  ap lRx;
  private View mContentView;
  private long mStartTime;
  private TextView oCF;
  private TextView oCG;
  private TextView oCH;
  private TextView oCI;
  private ImageView oCJ;
  private Button oCK;
  private CheckBox oCL;
  private j oCM;
  private String oCN;
  private String oCO;
  int oCP;
  int oCQ;
  public int oCR;
  private String oCS;
  private String oCT;
  public ArrayList<String> oCU;
  public ArrayList<String> oCV;
  private TextView oCt;
  private TextView oCu;
  private String oww;
  private String oxI;
  
  public CardConsumeSuccessUI()
  {
    AppMethodBeat.i(113055);
    this.TAG = "MicroMsg.CardConsumeSuccessUI";
    this.oww = "";
    this.oCN = "";
    this.oxI = "";
    this.oCO = "";
    this.oCP = 0;
    this.oCQ = 0;
    this.oCR = 0;
    this.oCS = "";
    this.oCT = "";
    this.oCU = new ArrayList();
    this.oCV = new ArrayList();
    this.mStartTime = 0L;
    this.lRx = new ap(Looper.getMainLooper());
    this.fQJ = null;
    this.jtG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113052);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeSuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramAnonymousView.getId() == 2131296314) {
          CardConsumeSuccessUI.a(CardConsumeSuccessUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeSuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113052);
          return;
          if (paramAnonymousView.getId() == 2131305532)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("KLabel_range_index", CardConsumeSuccessUI.this.oCR);
            paramAnonymousView.putExtra("Klabel_name_list", CardConsumeSuccessUI.b(CardConsumeSuccessUI.this));
            paramAnonymousView.putExtra("Kother_user_name_list", CardConsumeSuccessUI.c(CardConsumeSuccessUI.this));
            paramAnonymousView.putExtra("k_sns_label_ui_title", CardConsumeSuccessUI.this.getString(2131756983));
            paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
            paramAnonymousView.putExtra("KLabel_is_filter_private", true);
            com.tencent.mm.bs.d.b(CardConsumeSuccessUI.this, "sns", ".ui.SnsLabelUI", paramAnonymousView, 1);
          }
        }
      }
    };
    AppMethodBeat.o(113055);
  }
  
  private static void Aw(int paramInt)
  {
    AppMethodBeat.i(113068);
    ad.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is ".concat(String.valueOf(paramInt)));
    ck localck = new ck();
    localck.dnq.bZU = paramInt;
    com.tencent.mm.sdk.b.a.IbL.l(localck);
    AppMethodBeat.o(113068);
  }
  
  private boolean YF(String paramString)
  {
    AppMethodBeat.i(113058);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
      AppMethodBeat.o(113058);
      return false;
    }
    this.oCM = s.Zp(paramString);
    if (this.oCM == null)
    {
      ad.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(113058);
      return false;
    }
    AppMethodBeat.o(113058);
    return true;
  }
  
  @TargetApi(16)
  private void YG(String paramString)
  {
    AppMethodBeat.i(113064);
    int i = l.Zh(paramString);
    this.mContentView.setBackgroundColor(i);
    setActionbarColor(i);
    if (com.tencent.mm.compatible.util.d.ly(16)) {
      this.oCK.setBackground(l.eU(i, getResources().getDimensionPixelSize(2131165954) / 2));
    }
    for (;;)
    {
      this.mContentView.invalidate();
      AppMethodBeat.o(113064);
      return;
      this.oCK.setBackgroundDrawable(l.eU(i, getResources().getDimensionPixelSize(2131165954) / 2));
    }
  }
  
  private void YH(String paramString)
  {
    AppMethodBeat.i(113066);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131756792);
    }
    h.a(this, str, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(113054);
        paramAnonymousDialogInterface.dismiss();
        CardConsumeSuccessUI.bVB();
        CardConsumeSuccessUI.this.finish();
        AppMethodBeat.o(113054);
      }
    });
    AppMethodBeat.o(113066);
  }
  
  private String bVA()
  {
    AppMethodBeat.i(113070);
    String str;
    if ((!TextUtils.isEmpty(this.oCS)) && (!TextUtils.isEmpty(this.oCT)))
    {
      str = this.oCS + "," + l.Zk(this.oCT);
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.oCS))
    {
      str = this.oCS;
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.oCT))
    {
      str = l.Zk(this.oCT);
      AppMethodBeat.o(113070);
      return str;
    }
    AppMethodBeat.o(113070);
    return "";
  }
  
  private void bVz()
  {
    AppMethodBeat.i(113063);
    getContentView().setBackgroundColor(getResources().getColor(2131100084));
    findViewById(2131304240).setVisibility(4);
    AppMethodBeat.o(113063);
  }
  
  private void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(113056);
    if (paramBoolean)
    {
      this.fQJ = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(113056);
      return;
    }
    if ((this.fQJ != null) && (this.fQJ.isShowing()))
    {
      this.fQJ.dismiss();
      this.fQJ = null;
    }
    AppMethodBeat.o(113056);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113062);
    if (this.oCM == null)
    {
      ad.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
      AppMethodBeat.o(113062);
      return;
    }
    findViewById(2131304240).setVisibility(0);
    ts localts;
    if ((!TextUtils.isEmpty(this.oCM.oBH)) && (!TextUtils.isEmpty(this.oCM.oBI)))
    {
      this.oCL.setText(this.oCM.oBH);
      this.oCL.setVisibility(0);
      if ((this.oCM.dbZ == null) || (this.oCM.dbZ.size() <= 0)) {
        break label413;
      }
      this.oCG.setText(getString(2131756821, new Object[] { Integer.valueOf(this.oCM.dbZ.size()) }));
      localts = ((com.tencent.mm.plugin.card.sharecard.model.q)this.oCM.dbZ.get(0)).oyX;
      if (localts == null) {
        break label398;
      }
      YG(localts.hAD);
      this.oCt.setText(localts.oze);
      this.oCu.setText(localts.title);
      int i = getResources().getDimensionPixelSize(2131165979);
      if (TextUtils.isEmpty(localts.hzB)) {
        break label351;
      }
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.arU();
      com.tencent.mm.aw.q.aIK();
      ((c.a)localObject).idJ = null;
      ((c.a)localObject).hdP = m.Yt(localts.hzB);
      ((c.a)localObject).idr = true;
      ((c.a)localObject).hfi = true;
      ((c.a)localObject).idp = true;
      ((c.a)localObject).hdS = i;
      ((c.a)localObject).hdR = i;
      ((c.a)localObject).idD = 2131233400;
      localObject = ((c.a)localObject).aJc();
      com.tencent.mm.aw.q.aIJ().a(localts.hzB, this.oCJ, (c)localObject);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localts.FRH)) {
        break label372;
      }
      this.oCK.setText(2131756818);
      AppMethodBeat.o(113062);
      return;
      this.oCL.setVisibility(8);
      ad.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
      break;
      label351:
      ad.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
      this.oCJ.setImageResource(2131233400);
    }
    label372:
    ad.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
    this.oCK.setText(localts.FRH);
    AppMethodBeat.o(113062);
    return;
    label398:
    ad.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    AppMethodBeat.o(113062);
    return;
    label413:
    this.oCK.setEnabled(false);
    ad.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
    AppMethodBeat.o(113062);
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
        CardConsumeSuccessUI.bVB();
        AppMethodBeat.o(113051);
        return true;
      }
    });
    this.mContentView = getContentView();
    this.oCt = ((TextView)findViewById(2131297743));
    this.oCu = ((TextView)findViewById(2131297863));
    this.oCF = ((TextView)findViewById(2131297773));
    this.oCG = ((TextView)findViewById(2131305533));
    this.oCH = ((TextView)findViewById(2131305532));
    this.oCI = ((TextView)findViewById(2131305531));
    this.oCJ = ((ImageView)findViewById(2131297828));
    this.oCK = ((Button)findViewById(2131296314));
    this.oCL = ((CheckBox)findViewById(2131296966));
    this.oCK.setOnClickListener(this.jtG);
    this.oCL.setOnClickListener(this.jtG);
    this.oCH.setOnClickListener(this.jtG);
    if (this.oCM != null) {
      updateView();
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
      this.oCR = paramIntent.getIntExtra("Ktag_range_index", 0);
      ad.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.oCR) });
      if (this.oCR >= 2)
      {
        this.oCS = paramIntent.getStringExtra("Klabel_name_list");
        this.oCT = paramIntent.getStringExtra("Kother_user_name_list");
        ad.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.oCR), this.oCS });
        if ((TextUtils.isEmpty(this.oCS)) && (TextUtils.isEmpty(this.oCT)))
        {
          ad.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
          AppMethodBeat.o(113069);
          return;
        }
        paramIntent = Arrays.asList(this.oCS.split(","));
        this.oCV = l.cH(paramIntent);
        this.oCU = l.cG(paramIntent);
        if ((this.oCT != null) && (this.oCT.length() > 0))
        {
          paramIntent = Arrays.asList(this.oCT.split(","));
          this.oCU.addAll(paramIntent);
        }
        if (this.oCV != null) {
          ad.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.oCV.size());
        }
        if (this.oCU != null)
        {
          ad.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.oCU.size());
          paramIntent = this.oCU.iterator();
          while (paramIntent.hasNext()) {
            ad.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (this.oCR == 2)
        {
          this.oCI.setVisibility(0);
          this.oCI.setText(getString(2131756982, new Object[] { bVA() }));
          AppMethodBeat.o(113069);
          return;
        }
        if (this.oCR == 3)
        {
          this.oCI.setVisibility(0);
          this.oCI.setText(getString(2131756981, new Object[] { bVA() }));
          AppMethodBeat.o(113069);
          return;
        }
        this.oCI.setVisibility(8);
        AppMethodBeat.o(113069);
        return;
      }
      this.oCI.setVisibility(8);
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
    com.tencent.mm.kernel.g.ajB().gAO.a(902, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(910, this);
    paramBundle = "";
    this.oCP = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject;
    if (this.oCP == 1)
    {
      ad.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
      this.oCN = getIntent().getStringExtra("key_consumed_card_id");
      this.oCO = getIntent().getStringExtra("key_consumed_Code");
      if (TextUtils.isEmpty(this.oCN))
      {
        ad.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
        Aw(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      ad.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.oCO);
      jt(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d("", this.oCN, this.oCO);
      com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject, 0);
      bVz();
    }
    for (this.oCQ = 7;; this.oCQ = 4)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.oCQ), "", Integer.valueOf(0), "" });
      initView();
      if (!TextUtils.isEmpty(paramBundle)) {
        YG(paramBundle);
      }
      AppMethodBeat.o(113057);
      return;
      if (this.oCP != 2) {
        break;
      }
      ad.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
      this.oww = getIntent().getStringExtra("key_card_id");
      if (TextUtils.isEmpty(this.oww))
      {
        ad.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
        Aw(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      ad.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.oww);
      jt(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d(this.oww, "", "");
      com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject, 0);
      bVz();
    }
    ad.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
    this.oww = getIntent().getStringExtra("KEY_CARD_ID");
    if (!YF(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON")))
    {
      ad.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
      Aw(0);
      finish();
      AppMethodBeat.o(113057);
      return;
    }
    if ((this.oCM != null) && (!bt.hj(this.oCM.dbZ)))
    {
      paramBundle = ((com.tencent.mm.plugin.card.sharecard.model.q)this.oCM.dbZ.get(0)).oyX;
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.hAD;; paramBundle = "")
    {
      localObject = paramBundle;
      if (bt.isNullOrNil(paramBundle)) {
        localObject = getIntent().getStringExtra("KEY_CARD_COLOR");
      }
      this.oCQ = getIntent().getIntExtra("key_stastic_scene", 0);
      paramBundle = (Bundle)localObject;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113060);
    com.tencent.mm.kernel.g.ajB().gAO.b(902, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(910, this);
    long l = System.currentTimeMillis() - this.mStartTime;
    if (!TextUtils.isEmpty(this.oww)) {
      com.tencent.mm.plugin.report.service.g.yhR.f(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.oCP), this.oxI, this.oww, Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113060);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.oCP), this.oxI, this.oCN, Long.valueOf(l) });
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113067);
    if (paramInt == 4)
    {
      ad.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
      Aw(0);
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
    jt(false);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.g)paramn;
        if (paramString.ozR == 0)
        {
          h.cl(this, getString(2131756794));
          setResult(-1);
          this.oCK.setEnabled(false);
          l.bYC();
          ad.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
          Aw(-1);
          paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).ozQ;
          paramn = new ShareCardInfo();
          com.tencent.mm.plugin.card.d.f.a(paramn, paramString);
          l.a(paramn);
          am.bUU().onChange();
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        ad.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + paramString.ozR);
        com.tencent.mm.plugin.card.d.d.c(this, paramString.ozS);
        h.cl(this, getString(2131756790));
        AppMethodBeat.o(113065);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramn;
        if (paramString.ozR == 0)
        {
          if ((!TextUtils.isEmpty(paramString.ozQ)) && (YF(paramString.ozQ)))
          {
            ad.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
            this.lRx.post(new Runnable()
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
          if (this.oCP == 1)
          {
            Aw(0);
            finish();
            AppMethodBeat.o(113065);
            return;
          }
          bVz();
          YH(paramString.ozS);
          if (bt.isNullOrNil(paramString.ozS))
          {
            h.cl(this, getString(2131756792));
            AppMethodBeat.o(113065);
            return;
          }
          h.cl(this, paramString.ozS);
          AppMethodBeat.o(113065);
          return;
        }
        if (this.oCP == 1)
        {
          Aw(0);
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        ad.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + paramString.ozR);
        bVz();
        YH(paramString.ozS);
        AppMethodBeat.o(113065);
      }
    }
    else
    {
      if (((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d)) && (this.oCP == 1))
      {
        Aw(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI
 * JD-Core Version:    0.7.0.1
 */