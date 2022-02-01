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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CardConsumeSuccessUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private final String TAG;
  private p fxw;
  private View.OnClickListener jax;
  ao lso;
  private View mContentView;
  private long mStartTime;
  private String nTb;
  private String nUn;
  private TextView nYZ;
  public ArrayList<String> nZA;
  public ArrayList<String> nZB;
  private TextView nZa;
  private TextView nZl;
  private TextView nZm;
  private TextView nZn;
  private TextView nZo;
  private ImageView nZp;
  private Button nZq;
  private CheckBox nZr;
  private j nZs;
  private String nZt;
  private String nZu;
  int nZv;
  int nZw;
  public int nZx;
  private String nZy;
  private String nZz;
  
  public CardConsumeSuccessUI()
  {
    AppMethodBeat.i(113055);
    this.TAG = "MicroMsg.CardConsumeSuccessUI";
    this.nTb = "";
    this.nZt = "";
    this.nUn = "";
    this.nZu = "";
    this.nZv = 0;
    this.nZw = 0;
    this.nZx = 0;
    this.nZy = "";
    this.nZz = "";
    this.nZA = new ArrayList();
    this.nZB = new ArrayList();
    this.mStartTime = 0L;
    this.lso = new ao(Looper.getMainLooper());
    this.fxw = null;
    this.jax = new View.OnClickListener()
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
          paramAnonymousView.putExtra("KLabel_range_index", CardConsumeSuccessUI.this.nZx);
          paramAnonymousView.putExtra("Klabel_name_list", CardConsumeSuccessUI.b(CardConsumeSuccessUI.this));
          paramAnonymousView.putExtra("Kother_user_name_list", CardConsumeSuccessUI.c(CardConsumeSuccessUI.this));
          paramAnonymousView.putExtra("k_sns_label_ui_title", CardConsumeSuccessUI.this.getString(2131756983));
          paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
          paramAnonymousView.putExtra("KLabel_is_filter_private", true);
          com.tencent.mm.br.d.b(CardConsumeSuccessUI.this, "sns", ".ui.SnsLabelUI", paramAnonymousView, 1);
        }
        AppMethodBeat.o(113052);
      }
    };
    AppMethodBeat.o(113055);
  }
  
  private boolean UW(String paramString)
  {
    AppMethodBeat.i(113058);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
      AppMethodBeat.o(113058);
      return false;
    }
    this.nZs = s.VG(paramString);
    if (this.nZs == null)
    {
      ac.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(113058);
      return false;
    }
    AppMethodBeat.o(113058);
    return true;
  }
  
  @TargetApi(16)
  private void UX(String paramString)
  {
    AppMethodBeat.i(113064);
    int i = l.Vy(paramString);
    this.mContentView.setBackgroundColor(i);
    setActionbarColor(i);
    if (com.tencent.mm.compatible.util.d.kZ(16)) {
      this.nZq.setBackground(l.eQ(i, getResources().getDimensionPixelSize(2131165954) / 2));
    }
    for (;;)
    {
      this.mContentView.invalidate();
      AppMethodBeat.o(113064);
      return;
      this.nZq.setBackgroundDrawable(l.eQ(i, getResources().getDimensionPixelSize(2131165954) / 2));
    }
  }
  
  private void UY(String paramString)
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
        CardConsumeSuccessUI.bQW();
        CardConsumeSuccessUI.this.finish();
        AppMethodBeat.o(113054);
      }
    });
    AppMethodBeat.o(113066);
  }
  
  private void bQU()
  {
    AppMethodBeat.i(113063);
    getContentView().setBackgroundColor(getResources().getColor(2131100084));
    findViewById(2131304240).setVisibility(4);
    AppMethodBeat.o(113063);
  }
  
  private String bQV()
  {
    AppMethodBeat.i(113070);
    String str;
    if ((!TextUtils.isEmpty(this.nZy)) && (!TextUtils.isEmpty(this.nZz)))
    {
      str = this.nZy + "," + l.VB(this.nZz);
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.nZy))
    {
      str = this.nZy;
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.nZz))
    {
      str = l.VB(this.nZz);
      AppMethodBeat.o(113070);
      return str;
    }
    AppMethodBeat.o(113070);
    return "";
  }
  
  private void cL()
  {
    AppMethodBeat.i(113062);
    if (this.nZs == null)
    {
      ac.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
      AppMethodBeat.o(113062);
      return;
    }
    findViewById(2131304240).setVisibility(0);
    ry localry;
    if ((!TextUtils.isEmpty(this.nZs.nYn)) && (!TextUtils.isEmpty(this.nZs.nYo)))
    {
      this.nZr.setText(this.nZs.nYn);
      this.nZr.setVisibility(0);
      if ((this.nZs.cQJ == null) || (this.nZs.cQJ.size() <= 0)) {
        break label413;
      }
      this.nZm.setText(getString(2131756821, new Object[] { Integer.valueOf(this.nZs.cQJ.size()) }));
      localry = ((com.tencent.mm.plugin.card.sharecard.model.q)this.nZs.cQJ.get(0)).nVC;
      if (localry == null) {
        break label398;
      }
      UX(localry.hiu);
      this.nYZ.setText(localry.nVK);
      this.nZa.setText(localry.title);
      int i = getResources().getDimensionPixelSize(2131165979);
      if (TextUtils.isEmpty(localry.hhs)) {
        break label351;
      }
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
      o.aFC();
      ((c.a)localObject).hKO = null;
      ((c.a)localObject).gKe = m.UK(localry.hhs);
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).gLt = true;
      ((c.a)localObject).hKv = true;
      ((c.a)localObject).gKh = i;
      ((c.a)localObject).gKg = i;
      ((c.a)localObject).hKI = 2131233400;
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(localry.hhs, this.nZp, (c)localObject);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localry.Eky)) {
        break label372;
      }
      this.nZq.setText(2131756818);
      AppMethodBeat.o(113062);
      return;
      this.nZr.setVisibility(8);
      ac.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
      break;
      label351:
      ac.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
      this.nZp.setImageResource(2131233400);
    }
    label372:
    ac.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
    this.nZq.setText(localry.Eky);
    AppMethodBeat.o(113062);
    return;
    label398:
    ac.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    AppMethodBeat.o(113062);
    return;
    label413:
    this.nZq.setEnabled(false);
    ac.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
    AppMethodBeat.o(113062);
  }
  
  private void ji(boolean paramBoolean)
  {
    AppMethodBeat.i(113056);
    if (paramBoolean)
    {
      this.fxw = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(113056);
      return;
    }
    if ((this.fxw != null) && (this.fxw.isShowing()))
    {
      this.fxw.dismiss();
      this.fxw = null;
    }
    AppMethodBeat.o(113056);
  }
  
  private static void zN(int paramInt)
  {
    AppMethodBeat.i(113068);
    ac.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is ".concat(String.valueOf(paramInt)));
    ch localch = new ch();
    localch.dbU.bPH = paramInt;
    com.tencent.mm.sdk.b.a.GpY.l(localch);
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
        CardConsumeSuccessUI.bQW();
        AppMethodBeat.o(113051);
        return true;
      }
    });
    this.mContentView = getContentView();
    this.nYZ = ((TextView)findViewById(2131297743));
    this.nZa = ((TextView)findViewById(2131297863));
    this.nZl = ((TextView)findViewById(2131297773));
    this.nZm = ((TextView)findViewById(2131305533));
    this.nZn = ((TextView)findViewById(2131305532));
    this.nZo = ((TextView)findViewById(2131305531));
    this.nZp = ((ImageView)findViewById(2131297828));
    this.nZq = ((Button)findViewById(2131296314));
    this.nZr = ((CheckBox)findViewById(2131296966));
    this.nZq.setOnClickListener(this.jax);
    this.nZr.setOnClickListener(this.jax);
    this.nZn.setOnClickListener(this.jax);
    if (this.nZs != null) {
      cL();
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
      this.nZx = paramIntent.getIntExtra("Ktag_range_index", 0);
      ac.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.nZx) });
      if (this.nZx >= 2)
      {
        this.nZy = paramIntent.getStringExtra("Klabel_name_list");
        this.nZz = paramIntent.getStringExtra("Kother_user_name_list");
        ac.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.nZx), this.nZy });
        if ((TextUtils.isEmpty(this.nZy)) && (TextUtils.isEmpty(this.nZz)))
        {
          ac.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
          AppMethodBeat.o(113069);
          return;
        }
        paramIntent = Arrays.asList(this.nZy.split(","));
        this.nZB = l.cG(paramIntent);
        this.nZA = l.cF(paramIntent);
        if ((this.nZz != null) && (this.nZz.length() > 0))
        {
          paramIntent = Arrays.asList(this.nZz.split(","));
          this.nZA.addAll(paramIntent);
        }
        if (this.nZB != null) {
          ac.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.nZB.size());
        }
        if (this.nZA != null)
        {
          ac.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.nZA.size());
          paramIntent = this.nZA.iterator();
          while (paramIntent.hasNext()) {
            ac.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (this.nZx == 2)
        {
          this.nZo.setVisibility(0);
          this.nZo.setText(getString(2131756982, new Object[] { bQV() }));
          AppMethodBeat.o(113069);
          return;
        }
        if (this.nZx == 3)
        {
          this.nZo.setVisibility(0);
          this.nZo.setText(getString(2131756981, new Object[] { bQV() }));
          AppMethodBeat.o(113069);
          return;
        }
        this.nZo.setVisibility(8);
        AppMethodBeat.o(113069);
        return;
      }
      this.nZo.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113057);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
    this.mStartTime = System.currentTimeMillis();
    setMMTitle("");
    setResult(0);
    com.tencent.mm.kernel.g.agQ().ghe.a(902, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(910, this);
    paramBundle = "";
    this.nZv = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject;
    if (this.nZv == 1)
    {
      ac.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
      this.nZt = getIntent().getStringExtra("key_consumed_card_id");
      this.nZu = getIntent().getStringExtra("key_consumed_Code");
      if (TextUtils.isEmpty(this.nZt))
      {
        ac.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
        zN(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      ac.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.nZu);
      ji(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d("", this.nZt, this.nZu);
      com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
      bQU();
    }
    for (this.nZw = 7;; this.nZw = 4)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11324, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.nZw), "", Integer.valueOf(0), "" });
      initView();
      if (!TextUtils.isEmpty(paramBundle)) {
        UX(paramBundle);
      }
      AppMethodBeat.o(113057);
      return;
      if (this.nZv != 2) {
        break;
      }
      ac.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
      this.nTb = getIntent().getStringExtra("key_card_id");
      if (TextUtils.isEmpty(this.nTb))
      {
        ac.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
        zN(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      ac.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.nTb);
      ji(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d(this.nTb, "", "");
      com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
      bQU();
    }
    ac.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
    this.nTb = getIntent().getStringExtra("KEY_CARD_ID");
    if (!UW(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON")))
    {
      ac.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
      zN(0);
      finish();
      AppMethodBeat.o(113057);
      return;
    }
    if ((this.nZs != null) && (!bs.gY(this.nZs.cQJ)))
    {
      paramBundle = ((com.tencent.mm.plugin.card.sharecard.model.q)this.nZs.cQJ.get(0)).nVC;
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.hiu;; paramBundle = "")
    {
      localObject = paramBundle;
      if (bs.isNullOrNil(paramBundle)) {
        localObject = getIntent().getStringExtra("KEY_CARD_COLOR");
      }
      this.nZw = getIntent().getIntExtra("key_stastic_scene", 0);
      paramBundle = (Bundle)localObject;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113060);
    com.tencent.mm.kernel.g.agQ().ghe.b(902, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(910, this);
    long l = System.currentTimeMillis() - this.mStartTime;
    if (!TextUtils.isEmpty(this.nTb)) {
      com.tencent.mm.plugin.report.service.h.wUl.f(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.nZv), this.nUn, this.nTb, Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113060);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.f(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.nZv), this.nUn, this.nZt, Long.valueOf(l) });
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113067);
    if (paramInt == 4)
    {
      ac.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
      zN(0);
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
    ac.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " scene cmd is " + paramn.getType());
    ji(false);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.g)paramn;
        if (paramString.nWx == 0)
        {
          com.tencent.mm.ui.base.h.cg(this, getString(2131756794));
          setResult(-1);
          this.nZq.setEnabled(false);
          l.bTX();
          ac.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
          zN(-1);
          paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).nWw;
          paramn = new ShareCardInfo();
          f.a(paramn, paramString);
          l.a(paramn);
          am.bQp().onChange();
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        ac.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + paramString.nWx);
        com.tencent.mm.plugin.card.d.d.c(this, paramString.nWy);
        com.tencent.mm.ui.base.h.cg(this, getString(2131756790));
        AppMethodBeat.o(113065);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramn;
        if (paramString.nWx == 0)
        {
          if ((!TextUtils.isEmpty(paramString.nWw)) && (UW(paramString.nWw)))
          {
            ac.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
            this.lso.post(new Runnable()
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
          ac.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
          if (this.nZv == 1)
          {
            zN(0);
            finish();
            AppMethodBeat.o(113065);
            return;
          }
          bQU();
          UY(paramString.nWy);
          if (bs.isNullOrNil(paramString.nWy))
          {
            com.tencent.mm.ui.base.h.cg(this, getString(2131756792));
            AppMethodBeat.o(113065);
            return;
          }
          com.tencent.mm.ui.base.h.cg(this, paramString.nWy);
          AppMethodBeat.o(113065);
          return;
        }
        if (this.nZv == 1)
        {
          zN(0);
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        ac.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + paramString.nWx);
        bQU();
        UY(paramString.nWy);
        AppMethodBeat.o(113065);
      }
    }
    else
    {
      if (((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d)) && (this.nZv == 1))
      {
        zN(0);
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