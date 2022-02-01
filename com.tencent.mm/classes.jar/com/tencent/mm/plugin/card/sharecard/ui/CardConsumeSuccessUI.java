package com.tencent.mm.plugin.card.sharecard.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.da;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.f;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CardConsumeSuccessUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private final String TAG;
  private w lKp;
  private View mContentView;
  private long mStartTime;
  private View.OnClickListener qjL;
  MMHandler tiG;
  private String wrg;
  private String wsu;
  int wxA;
  public int wxB;
  private String wxC;
  private String wxD;
  public ArrayList<String> wxE;
  public ArrayList<String> wxF;
  private TextView wxd;
  private TextView wxe;
  private TextView wxp;
  private TextView wxq;
  private TextView wxr;
  private TextView wxs;
  private ImageView wxt;
  private Button wxu;
  private CheckBox wxv;
  private j wxw;
  private String wxx;
  private String wxy;
  int wxz;
  
  public CardConsumeSuccessUI()
  {
    AppMethodBeat.i(113055);
    this.TAG = "MicroMsg.CardConsumeSuccessUI";
    this.wrg = "";
    this.wxx = "";
    this.wsu = "";
    this.wxy = "";
    this.wxz = 0;
    this.wxA = 0;
    this.wxB = 0;
    this.wxC = "";
    this.wxD = "";
    this.wxE = new ArrayList();
    this.wxF = new ArrayList();
    this.mStartTime = 0L;
    this.tiG = new MMHandler(Looper.getMainLooper());
    this.lKp = null;
    this.qjL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113052);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeSuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView.getId() == a.d.weE) {
          CardConsumeSuccessUI.a(CardConsumeSuccessUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeSuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113052);
          return;
          if (paramAnonymousView.getId() == a.d.wlw)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("KLabel_range_index", CardConsumeSuccessUI.this.wxB);
            paramAnonymousView.putExtra("Klabel_name_list", CardConsumeSuccessUI.b(CardConsumeSuccessUI.this));
            paramAnonymousView.putExtra("Kother_user_name_list", CardConsumeSuccessUI.c(CardConsumeSuccessUI.this));
            paramAnonymousView.putExtra("k_sns_label_ui_title", CardConsumeSuccessUI.this.getString(a.g.wqc));
            paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
            paramAnonymousView.putExtra("KLabel_is_filter_private", true);
            com.tencent.mm.br.c.b(CardConsumeSuccessUI.this, "sns", ".ui.SnsLabelUI", paramAnonymousView, 1);
          }
        }
      }
    };
    AppMethodBeat.o(113055);
  }
  
  private static void Ip(int paramInt)
  {
    AppMethodBeat.i(113068);
    Log.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is ".concat(String.valueOf(paramInt)));
    da localda = new da();
    localda.hCU.resultCode = paramInt;
    localda.publish();
    AppMethodBeat.o(113068);
  }
  
  private boolean akT(String paramString)
  {
    AppMethodBeat.i(113058);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
      AppMethodBeat.o(113058);
      return false;
    }
    this.wxw = com.tencent.mm.plugin.card.c.s.alD(paramString);
    if (this.wxw == null)
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(113058);
      return false;
    }
    AppMethodBeat.o(113058);
    return true;
  }
  
  private void akU(String paramString)
  {
    AppMethodBeat.i(113064);
    int i = l.alv(paramString);
    this.mContentView.setBackgroundColor(i);
    setActionbarColor(i);
    if (com.tencent.mm.compatible.util.d.rb(16)) {
      this.wxu.setBackground(l.gx(i, getResources().getDimensionPixelSize(a.b.wdI) / 2));
    }
    for (;;)
    {
      this.mContentView.invalidate();
      AppMethodBeat.o(113064);
      return;
      this.wxu.setBackgroundDrawable(l.gx(i, getResources().getDimensionPixelSize(a.b.wdI) / 2));
    }
  }
  
  private void akV(String paramString)
  {
    AppMethodBeat.i(113066);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(a.g.wnX);
    }
    k.a(this, str, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(113054);
        paramAnonymousDialogInterface.dismiss();
        CardConsumeSuccessUI.dlA();
        CardConsumeSuccessUI.this.finish();
        AppMethodBeat.o(113054);
      }
    });
    AppMethodBeat.o(113066);
  }
  
  private void dly()
  {
    AppMethodBeat.i(113063);
    getContentView().setBackgroundColor(getResources().getColor(a.a.wdB));
    findViewById(a.d.rootView).setVisibility(4);
    AppMethodBeat.o(113063);
  }
  
  private String dlz()
  {
    AppMethodBeat.i(113070);
    String str;
    if ((!TextUtils.isEmpty(this.wxC)) && (!TextUtils.isEmpty(this.wxD)))
    {
      str = this.wxC + "," + l.aly(this.wxD);
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.wxC))
    {
      str = this.wxC;
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.wxD))
    {
      str = l.aly(this.wxD);
      AppMethodBeat.o(113070);
      return str;
    }
    AppMethodBeat.o(113070);
    return "";
  }
  
  private void na(boolean paramBoolean)
  {
    AppMethodBeat.i(113056);
    if (paramBoolean)
    {
      this.lKp = w.a(this, getString(a.g.loading_tips), true, 0, null);
      AppMethodBeat.o(113056);
      return;
    }
    if ((this.lKp != null) && (this.lKp.isShowing()))
    {
      this.lKp.dismiss();
      this.lKp = null;
    }
    AppMethodBeat.o(113056);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113062);
    if (this.wxw == null)
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
      AppMethodBeat.o(113062);
      return;
    }
    findViewById(a.d.rootView).setVisibility(0);
    ws localws;
    if ((!TextUtils.isEmpty(this.wxw.www)) && (!TextUtils.isEmpty(this.wxw.wwx)))
    {
      this.wxv.setText(this.wxw.www);
      this.wxv.setVisibility(0);
      if ((this.wxw.hqL == null) || (this.wxw.hqL.size() <= 0)) {
        break label411;
      }
      this.wxq.setText(getString(a.g.wos, new Object[] { Integer.valueOf(this.wxw.hqL.size()) }));
      localws = ((q)this.wxw.hqL.get(0)).wtH;
      if (localws == null) {
        break label396;
      }
      akU(localws.nRQ);
      this.wxd.setText(localws.mee);
      this.wxe.setText(localws.title);
      int i = getResources().getDimensionPixelSize(a.b.wdU);
      if (TextUtils.isEmpty(localws.nQG)) {
        break label349;
      }
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject).oKH = r.bKf();
      ((c.a)localObject).fullPath = m.akH(localws.nQG);
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).nrc = true;
      ((c.a)localObject).oKn = true;
      ((c.a)localObject).npV = i;
      ((c.a)localObject).npU = i;
      ((c.a)localObject).oKB = a.c.my_card_package_defaultlogo;
      localObject = ((c.a)localObject).bKx();
      r.bKe().a(localws.nQG, this.wxt, (com.tencent.mm.modelimage.loader.a.c)localObject);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localws.ZdS)) {
        break label370;
      }
      this.wxu.setText(a.g.woq);
      AppMethodBeat.o(113062);
      return;
      this.wxv.setVisibility(8);
      Log.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
      break;
      label349:
      Log.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
      this.wxt.setImageResource(a.c.my_card_package_defaultlogo);
    }
    label370:
    Log.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
    this.wxu.setText(localws.ZdS);
    AppMethodBeat.o(113062);
    return;
    label396:
    Log.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    AppMethodBeat.o(113062);
    return;
    label411:
    this.wxu.setEnabled(false);
    Log.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
    AppMethodBeat.o(113062);
  }
  
  public int getLayoutId()
  {
    return a.e.wmt;
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
        CardConsumeSuccessUI.dlA();
        AppMethodBeat.o(113051);
        return true;
      }
    });
    this.mContentView = getContentView();
    this.wxd = ((TextView)findViewById(a.d.fvq));
    this.wxe = ((TextView)findViewById(a.d.whj));
    this.wxp = ((TextView)findViewById(a.d.wfW));
    this.wxq = ((TextView)findViewById(a.d.wlx));
    this.wxr = ((TextView)findViewById(a.d.wlw));
    this.wxs = ((TextView)findViewById(a.d.wlv));
    this.wxt = ((ImageView)findViewById(a.d.wgJ));
    this.wxu = ((Button)findViewById(a.d.weE));
    this.wxv = ((CheckBox)findViewById(a.d.weR));
    this.wxu.setOnClickListener(this.qjL);
    this.wxv.setOnClickListener(this.qjL);
    this.wxr.setOnClickListener(this.qjL);
    if (this.wxw != null) {
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
      this.wxB = paramIntent.getIntExtra("Ktag_range_index", 0);
      Log.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.wxB) });
      if (this.wxB >= 2)
      {
        this.wxC = paramIntent.getStringExtra("Klabel_name_list");
        this.wxD = paramIntent.getStringExtra("Kother_user_name_list");
        Log.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.wxB), this.wxC });
        if ((TextUtils.isEmpty(this.wxC)) && (TextUtils.isEmpty(this.wxD)))
        {
          Log.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
          AppMethodBeat.o(113069);
          return;
        }
        paramIntent = Arrays.asList(this.wxC.split(","));
        this.wxF = l.eR(paramIntent);
        this.wxE = l.eQ(paramIntent);
        if ((this.wxD != null) && (this.wxD.length() > 0))
        {
          paramIntent = Arrays.asList(this.wxD.split(","));
          this.wxE.addAll(paramIntent);
        }
        if (this.wxF != null) {
          Log.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.wxF.size());
        }
        if (this.wxE != null)
        {
          Log.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.wxE.size());
          paramIntent = this.wxE.iterator();
          while (paramIntent.hasNext()) {
            Log.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (this.wxB == 2)
        {
          this.wxs.setVisibility(0);
          this.wxs.setText(getString(a.g.wqb, new Object[] { dlz() }));
          AppMethodBeat.o(113069);
          return;
        }
        if (this.wxB == 3)
        {
          this.wxs.setVisibility(0);
          this.wxs.setText(getString(a.g.wqa, new Object[] { dlz() }));
          AppMethodBeat.o(113069);
          return;
        }
        this.wxs.setVisibility(8);
        AppMethodBeat.o(113069);
        return;
      }
      this.wxs.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113057);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
    this.mStartTime = System.currentTimeMillis();
    setMMTitle("");
    setResult(0);
    com.tencent.mm.kernel.h.baD().mCm.a(902, this);
    com.tencent.mm.kernel.h.baD().mCm.a(910, this);
    paramBundle = "";
    this.wxz = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject;
    if (this.wxz == 1)
    {
      Log.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
      this.wxx = getIntent().getStringExtra("key_consumed_card_id");
      this.wxy = getIntent().getStringExtra("key_consumed_Code");
      if (TextUtils.isEmpty(this.wxx))
      {
        Log.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
        Ip(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      Log.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.wxy);
      na(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d("", this.wxx, this.wxy);
      com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
      dly();
    }
    for (this.wxA = 7;; this.wxA = 4)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.wxA), "", Integer.valueOf(0), "" });
      initView();
      if (!TextUtils.isEmpty(paramBundle)) {
        akU(paramBundle);
      }
      AppMethodBeat.o(113057);
      return;
      if (this.wxz != 2) {
        break;
      }
      Log.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
      this.wrg = getIntent().getStringExtra("key_card_id");
      if (TextUtils.isEmpty(this.wrg))
      {
        Log.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
        Ip(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      Log.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.wrg);
      na(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d(this.wrg, "", "");
      com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
      dly();
    }
    Log.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
    this.wrg = getIntent().getStringExtra("KEY_CARD_ID");
    if (!akT(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON")))
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
      Ip(0);
      finish();
      AppMethodBeat.o(113057);
      return;
    }
    if ((this.wxw != null) && (!Util.isNullOrNil(this.wxw.hqL)))
    {
      paramBundle = ((q)this.wxw.hqL.get(0)).wtH;
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.nRQ;; paramBundle = "")
    {
      localObject = paramBundle;
      if (Util.isNullOrNil(paramBundle)) {
        localObject = getIntent().getStringExtra("KEY_CARD_COLOR");
      }
      this.wxA = getIntent().getIntExtra("key_stastic_scene", 0);
      paramBundle = (Bundle)localObject;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113060);
    com.tencent.mm.kernel.h.baD().mCm.b(902, this);
    com.tencent.mm.kernel.h.baD().mCm.b(910, this);
    long l = System.currentTimeMillis() - this.mStartTime;
    if (!TextUtils.isEmpty(this.wrg)) {
      com.tencent.mm.plugin.report.service.h.OAn.b(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.wxz), this.wsu, this.wrg, Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113060);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.wxz), this.wsu, this.wxx, Long.valueOf(l) });
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113067);
    if (paramInt == 4)
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
      Ip(0);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(113065);
    Log.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " scene cmd is " + paramp.getType());
    na(false);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof g))
      {
        paramString = (g)paramp;
        if (paramString.wuz == 0)
        {
          k.cZ(this, getString(a.g.wnY));
          setResult(-1);
          this.wxu.setEnabled(false);
          l.doQ();
          Log.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
          Ip(-1);
          paramString = ((g)paramp).wuy;
          paramp = new ShareCardInfo();
          f.a(paramp, paramString);
          l.a(paramp);
          am.dkQ().onChange();
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        Log.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + paramString.wuz);
        com.tencent.mm.plugin.card.c.d.b(this, paramString.wuA);
        k.cZ(this, getString(a.g.wnV));
        AppMethodBeat.o(113065);
        return;
      }
      if ((paramp instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramp;
        if (paramString.wuz == 0)
        {
          if ((!TextUtils.isEmpty(paramString.wuy)) && (akT(paramString.wuy)))
          {
            Log.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
            this.tiG.post(new Runnable()
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
          Log.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
          if (this.wxz == 1)
          {
            Ip(0);
            finish();
            AppMethodBeat.o(113065);
            return;
          }
          dly();
          akV(paramString.wuA);
          if (Util.isNullOrNil(paramString.wuA))
          {
            k.cZ(this, getString(a.g.wnX));
            AppMethodBeat.o(113065);
            return;
          }
          k.cZ(this, paramString.wuA);
          AppMethodBeat.o(113065);
          return;
        }
        if (this.wxz == 1)
        {
          Ip(0);
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        Log.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + paramString.wuz);
        dly();
        akV(paramString.wuA);
        AppMethodBeat.o(113065);
      }
    }
    else
    {
      if (((paramp instanceof com.tencent.mm.plugin.card.sharecard.model.d)) && (this.wxz == 1))
      {
        Ip(0);
        finish();
        AppMethodBeat.o(113065);
        return;
      }
      com.tencent.mm.plugin.card.c.d.b(this, paramString);
    }
    AppMethodBeat.o(113065);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI
 * JD-Core Version:    0.7.0.1
 */