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
import com.tencent.mm.g.a.ck;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CardConsumeSuccessUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private final String TAG;
  private p fSP;
  private View.OnClickListener jwB;
  aq lVY;
  private View mContentView;
  private long mStartTime;
  private String oCY;
  private String oEk;
  private TextView oIV;
  private TextView oIW;
  private TextView oJh;
  private TextView oJi;
  private TextView oJj;
  private TextView oJk;
  private ImageView oJl;
  private Button oJm;
  private CheckBox oJn;
  private j oJo;
  private String oJp;
  private String oJq;
  int oJr;
  int oJs;
  public int oJt;
  private String oJu;
  private String oJv;
  public ArrayList<String> oJw;
  public ArrayList<String> oJx;
  
  public CardConsumeSuccessUI()
  {
    AppMethodBeat.i(113055);
    this.TAG = "MicroMsg.CardConsumeSuccessUI";
    this.oCY = "";
    this.oJp = "";
    this.oEk = "";
    this.oJq = "";
    this.oJr = 0;
    this.oJs = 0;
    this.oJt = 0;
    this.oJu = "";
    this.oJv = "";
    this.oJw = new ArrayList();
    this.oJx = new ArrayList();
    this.mStartTime = 0L;
    this.lVY = new aq(Looper.getMainLooper());
    this.fSP = null;
    this.jwB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113052);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeSuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
            paramAnonymousView.putExtra("KLabel_range_index", CardConsumeSuccessUI.this.oJt);
            paramAnonymousView.putExtra("Klabel_name_list", CardConsumeSuccessUI.b(CardConsumeSuccessUI.this));
            paramAnonymousView.putExtra("Kother_user_name_list", CardConsumeSuccessUI.c(CardConsumeSuccessUI.this));
            paramAnonymousView.putExtra("k_sns_label_ui_title", CardConsumeSuccessUI.this.getString(2131756983));
            paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
            paramAnonymousView.putExtra("KLabel_is_filter_private", true);
            com.tencent.mm.br.d.b(CardConsumeSuccessUI.this, "sns", ".ui.SnsLabelUI", paramAnonymousView, 1);
          }
        }
      }
    };
    AppMethodBeat.o(113055);
  }
  
  private static void AI(int paramInt)
  {
    AppMethodBeat.i(113068);
    ae.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is ".concat(String.valueOf(paramInt)));
    ck localck = new ck();
    localck.dos.bZU = paramInt;
    com.tencent.mm.sdk.b.a.IvT.l(localck);
    AppMethodBeat.o(113068);
  }
  
  private boolean Zw(String paramString)
  {
    AppMethodBeat.i(113058);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
      AppMethodBeat.o(113058);
      return false;
    }
    this.oJo = s.aag(paramString);
    if (this.oJo == null)
    {
      ae.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(113058);
      return false;
    }
    AppMethodBeat.o(113058);
    return true;
  }
  
  @TargetApi(16)
  private void Zx(String paramString)
  {
    AppMethodBeat.i(113064);
    int i = l.ZY(paramString);
    this.mContentView.setBackgroundColor(i);
    setActionbarColor(i);
    if (com.tencent.mm.compatible.util.d.lA(16)) {
      this.oJm.setBackground(l.eV(i, getResources().getDimensionPixelSize(2131165954) / 2));
    }
    for (;;)
    {
      this.mContentView.invalidate();
      AppMethodBeat.o(113064);
      return;
      this.oJm.setBackgroundDrawable(l.eV(i, getResources().getDimensionPixelSize(2131165954) / 2));
    }
  }
  
  private void Zy(String paramString)
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
        CardConsumeSuccessUI.bWQ();
        CardConsumeSuccessUI.this.finish();
        AppMethodBeat.o(113054);
      }
    });
    AppMethodBeat.o(113066);
  }
  
  private void bWO()
  {
    AppMethodBeat.i(113063);
    getContentView().setBackgroundColor(getResources().getColor(2131100084));
    findViewById(2131304240).setVisibility(4);
    AppMethodBeat.o(113063);
  }
  
  private String bWP()
  {
    AppMethodBeat.i(113070);
    String str;
    if ((!TextUtils.isEmpty(this.oJu)) && (!TextUtils.isEmpty(this.oJv)))
    {
      str = this.oJu + "," + l.aab(this.oJv);
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.oJu))
    {
      str = this.oJu;
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.oJv))
    {
      str = l.aab(this.oJv);
      AppMethodBeat.o(113070);
      return str;
    }
    AppMethodBeat.o(113070);
    return "";
  }
  
  private void js(boolean paramBoolean)
  {
    AppMethodBeat.i(113056);
    if (paramBoolean)
    {
      this.fSP = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(113056);
      return;
    }
    if ((this.fSP != null) && (this.fSP.isShowing()))
    {
      this.fSP.dismiss();
      this.fSP = null;
    }
    AppMethodBeat.o(113056);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113062);
    if (this.oJo == null)
    {
      ae.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
      AppMethodBeat.o(113062);
      return;
    }
    findViewById(2131304240).setVisibility(0);
    tu localtu;
    if ((!TextUtils.isEmpty(this.oJo.oIj)) && (!TextUtils.isEmpty(this.oJo.oIk)))
    {
      this.oJn.setText(this.oJo.oIj);
      this.oJn.setVisibility(0);
      if ((this.oJo.ddb == null) || (this.oJo.ddb.size() <= 0)) {
        break label413;
      }
      this.oJi.setText(getString(2131756821, new Object[] { Integer.valueOf(this.oJo.ddb.size()) }));
      localtu = ((com.tencent.mm.plugin.card.sharecard.model.q)this.oJo.ddb.get(0)).oFz;
      if (localtu == null) {
        break label398;
      }
      Zx(localtu.hDr);
      this.oIV.setText(localtu.oFG);
      this.oIW.setText(localtu.title);
      int i = getResources().getDimensionPixelSize(2131165979);
      if (TextUtils.isEmpty(localtu.hCp)) {
        break label351;
      }
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.asj();
      com.tencent.mm.av.q.aJc();
      ((c.a)localObject).igB = null;
      ((c.a)localObject).hgD = m.Zk(localtu.hCp);
      ((c.a)localObject).igk = true;
      ((c.a)localObject).hhW = true;
      ((c.a)localObject).igi = true;
      ((c.a)localObject).hgG = i;
      ((c.a)localObject).hgF = i;
      ((c.a)localObject).igv = 2131233400;
      localObject = ((c.a)localObject).aJu();
      com.tencent.mm.av.q.aJb().a(localtu.hCp, this.oJl, (c)localObject);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localtu.Gkg)) {
        break label372;
      }
      this.oJm.setText(2131756818);
      AppMethodBeat.o(113062);
      return;
      this.oJn.setVisibility(8);
      ae.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
      break;
      label351:
      ae.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
      this.oJl.setImageResource(2131233400);
    }
    label372:
    ae.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
    this.oJm.setText(localtu.Gkg);
    AppMethodBeat.o(113062);
    return;
    label398:
    ae.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    AppMethodBeat.o(113062);
    return;
    label413:
    this.oJm.setEnabled(false);
    ae.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
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
        CardConsumeSuccessUI.bWQ();
        AppMethodBeat.o(113051);
        return true;
      }
    });
    this.mContentView = getContentView();
    this.oIV = ((TextView)findViewById(2131297743));
    this.oIW = ((TextView)findViewById(2131297863));
    this.oJh = ((TextView)findViewById(2131297773));
    this.oJi = ((TextView)findViewById(2131305533));
    this.oJj = ((TextView)findViewById(2131305532));
    this.oJk = ((TextView)findViewById(2131305531));
    this.oJl = ((ImageView)findViewById(2131297828));
    this.oJm = ((Button)findViewById(2131296314));
    this.oJn = ((CheckBox)findViewById(2131296966));
    this.oJm.setOnClickListener(this.jwB);
    this.oJn.setOnClickListener(this.jwB);
    this.oJj.setOnClickListener(this.jwB);
    if (this.oJo != null) {
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
      this.oJt = paramIntent.getIntExtra("Ktag_range_index", 0);
      ae.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.oJt) });
      if (this.oJt >= 2)
      {
        this.oJu = paramIntent.getStringExtra("Klabel_name_list");
        this.oJv = paramIntent.getStringExtra("Kother_user_name_list");
        ae.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.oJt), this.oJu });
        if ((TextUtils.isEmpty(this.oJu)) && (TextUtils.isEmpty(this.oJv)))
        {
          ae.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
          AppMethodBeat.o(113069);
          return;
        }
        paramIntent = Arrays.asList(this.oJu.split(","));
        this.oJx = l.cK(paramIntent);
        this.oJw = l.cJ(paramIntent);
        if ((this.oJv != null) && (this.oJv.length() > 0))
        {
          paramIntent = Arrays.asList(this.oJv.split(","));
          this.oJw.addAll(paramIntent);
        }
        if (this.oJx != null) {
          ae.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.oJx.size());
        }
        if (this.oJw != null)
        {
          ae.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.oJw.size());
          paramIntent = this.oJw.iterator();
          while (paramIntent.hasNext()) {
            ae.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (this.oJt == 2)
        {
          this.oJk.setVisibility(0);
          this.oJk.setText(getString(2131756982, new Object[] { bWP() }));
          AppMethodBeat.o(113069);
          return;
        }
        if (this.oJt == 3)
        {
          this.oJk.setVisibility(0);
          this.oJk.setText(getString(2131756981, new Object[] { bWP() }));
          AppMethodBeat.o(113069);
          return;
        }
        this.oJk.setVisibility(8);
        AppMethodBeat.o(113069);
        return;
      }
      this.oJk.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113057);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
    this.mStartTime = System.currentTimeMillis();
    setMMTitle("");
    setResult(0);
    com.tencent.mm.kernel.g.ajQ().gDv.a(902, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(910, this);
    paramBundle = "";
    this.oJr = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject;
    if (this.oJr == 1)
    {
      ae.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
      this.oJp = getIntent().getStringExtra("key_consumed_card_id");
      this.oJq = getIntent().getStringExtra("key_consumed_Code");
      if (TextUtils.isEmpty(this.oJp))
      {
        ae.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
        AI(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      ae.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.oJq);
      js(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d("", this.oJp, this.oJq);
      com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject, 0);
      bWO();
    }
    for (this.oJs = 7;; this.oJs = 4)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.oJs), "", Integer.valueOf(0), "" });
      initView();
      if (!TextUtils.isEmpty(paramBundle)) {
        Zx(paramBundle);
      }
      AppMethodBeat.o(113057);
      return;
      if (this.oJr != 2) {
        break;
      }
      ae.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
      this.oCY = getIntent().getStringExtra("key_card_id");
      if (TextUtils.isEmpty(this.oCY))
      {
        ae.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
        AI(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      ae.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.oCY);
      js(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d(this.oCY, "", "");
      com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject, 0);
      bWO();
    }
    ae.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
    this.oCY = getIntent().getStringExtra("KEY_CARD_ID");
    if (!Zw(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON")))
    {
      ae.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
      AI(0);
      finish();
      AppMethodBeat.o(113057);
      return;
    }
    if ((this.oJo != null) && (!bu.ht(this.oJo.ddb)))
    {
      paramBundle = ((com.tencent.mm.plugin.card.sharecard.model.q)this.oJo.ddb.get(0)).oFz;
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.hDr;; paramBundle = "")
    {
      localObject = paramBundle;
      if (bu.isNullOrNil(paramBundle)) {
        localObject = getIntent().getStringExtra("KEY_CARD_COLOR");
      }
      this.oJs = getIntent().getIntExtra("key_stastic_scene", 0);
      paramBundle = (Bundle)localObject;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113060);
    com.tencent.mm.kernel.g.ajQ().gDv.b(902, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(910, this);
    long l = System.currentTimeMillis() - this.mStartTime;
    if (!TextUtils.isEmpty(this.oCY)) {
      com.tencent.mm.plugin.report.service.g.yxI.f(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.oJr), this.oEk, this.oCY, Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113060);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.f(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.oJr), this.oEk, this.oJp, Long.valueOf(l) });
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113067);
    if (paramInt == 4)
    {
      ae.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
      AI(0);
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
    ae.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " scene cmd is " + paramn.getType());
    js(false);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.g)paramn;
        if (paramString.oGt == 0)
        {
          h.cm(this, getString(2131756794));
          setResult(-1);
          this.oJm.setEnabled(false);
          l.bZR();
          ae.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
          AI(-1);
          paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).oGs;
          paramn = new ShareCardInfo();
          com.tencent.mm.plugin.card.d.f.a(paramn, paramString);
          l.a(paramn);
          am.bWj().onChange();
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        ae.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + paramString.oGt);
        com.tencent.mm.plugin.card.d.d.c(this, paramString.oGu);
        h.cm(this, getString(2131756790));
        AppMethodBeat.o(113065);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramn;
        if (paramString.oGt == 0)
        {
          if ((!TextUtils.isEmpty(paramString.oGs)) && (Zw(paramString.oGs)))
          {
            ae.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
            this.lVY.post(new Runnable()
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
          ae.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
          if (this.oJr == 1)
          {
            AI(0);
            finish();
            AppMethodBeat.o(113065);
            return;
          }
          bWO();
          Zy(paramString.oGu);
          if (bu.isNullOrNil(paramString.oGu))
          {
            h.cm(this, getString(2131756792));
            AppMethodBeat.o(113065);
            return;
          }
          h.cm(this, paramString.oGu);
          AppMethodBeat.o(113065);
          return;
        }
        if (this.oJr == 1)
        {
          AI(0);
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        ae.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + paramString.oGt);
        bWO();
        Zy(paramString.oGu);
        AppMethodBeat.o(113065);
      }
    }
    else
    {
      if (((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.d)) && (this.oJr == 1))
      {
        AI(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI
 * JD-Core Version:    0.7.0.1
 */