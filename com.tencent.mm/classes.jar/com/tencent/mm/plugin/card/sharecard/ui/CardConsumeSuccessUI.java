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
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.a.cr;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CardConsumeSuccessUI
  extends MMActivity
  implements i
{
  private final String TAG;
  private com.tencent.mm.ui.base.s jhZ;
  private View mContentView;
  private long mStartTime;
  private View.OnClickListener nmC;
  MMHandler qdR;
  private String tmG;
  private String tnT;
  private TextView tsG;
  private TextView tsH;
  private TextView tsS;
  private TextView tsT;
  private TextView tsU;
  private TextView tsV;
  private ImageView tsW;
  private Button tsX;
  private CheckBox tsY;
  private j tsZ;
  private String tta;
  private String ttb;
  int ttc;
  int ttd;
  public int tte;
  private String ttf;
  private String ttg;
  public ArrayList<String> tth;
  public ArrayList<String> tti;
  
  public CardConsumeSuccessUI()
  {
    AppMethodBeat.i(113055);
    this.TAG = "MicroMsg.CardConsumeSuccessUI";
    this.tmG = "";
    this.tta = "";
    this.tnT = "";
    this.ttb = "";
    this.ttc = 0;
    this.ttd = 0;
    this.tte = 0;
    this.ttf = "";
    this.ttg = "";
    this.tth = new ArrayList();
    this.tti = new ArrayList();
    this.mStartTime = 0L;
    this.qdR = new MMHandler(Looper.getMainLooper());
    this.jhZ = null;
    this.nmC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113052);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeSuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (paramAnonymousView.getId() == a.d.tav) {
          CardConsumeSuccessUI.a(CardConsumeSuccessUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeSuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113052);
          return;
          if (paramAnonymousView.getId() == a.d.tgW)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("KLabel_range_index", CardConsumeSuccessUI.this.tte);
            paramAnonymousView.putExtra("Klabel_name_list", CardConsumeSuccessUI.b(CardConsumeSuccessUI.this));
            paramAnonymousView.putExtra("Kother_user_name_list", CardConsumeSuccessUI.c(CardConsumeSuccessUI.this));
            paramAnonymousView.putExtra("k_sns_label_ui_title", CardConsumeSuccessUI.this.getString(a.g.tlD));
            paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
            paramAnonymousView.putExtra("KLabel_is_filter_private", true);
            com.tencent.mm.by.c.b(CardConsumeSuccessUI.this, "sns", ".ui.SnsLabelUI", paramAnonymousView, 1);
          }
        }
      }
    };
    AppMethodBeat.o(113055);
  }
  
  private static void HO(int paramInt)
  {
    AppMethodBeat.i(113068);
    Log.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is ".concat(String.valueOf(paramInt)));
    cr localcr = new cr();
    localcr.fyp.resultCode = paramInt;
    EventCenter.instance.publish(localcr);
    AppMethodBeat.o(113068);
  }
  
  private boolean aro(String paramString)
  {
    AppMethodBeat.i(113058);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
      AppMethodBeat.o(113058);
      return false;
    }
    this.tsZ = com.tencent.mm.plugin.card.d.s.arZ(paramString);
    if (this.tsZ == null)
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(113058);
      return false;
    }
    AppMethodBeat.o(113058);
    return true;
  }
  
  @TargetApi(16)
  private void arp(String paramString)
  {
    AppMethodBeat.i(113064);
    int i = l.arR(paramString);
    this.mContentView.setBackgroundColor(i);
    setActionbarColor(i);
    if (com.tencent.mm.compatible.util.d.qV(16)) {
      this.tsX.setBackground(l.fF(i, getResources().getDimensionPixelSize(a.b.sZz) / 2));
    }
    for (;;)
    {
      this.mContentView.invalidate();
      AppMethodBeat.o(113064);
      return;
      this.tsX.setBackgroundDrawable(l.fF(i, getResources().getDimensionPixelSize(a.b.sZz) / 2));
    }
  }
  
  private void arq(String paramString)
  {
    AppMethodBeat.i(113066);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(a.g.tjA);
    }
    com.tencent.mm.ui.base.h.a(this, str, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(113054);
        paramAnonymousDialogInterface.dismiss();
        CardConsumeSuccessUI.cIj();
        CardConsumeSuccessUI.this.finish();
        AppMethodBeat.o(113054);
      }
    });
    AppMethodBeat.o(113066);
  }
  
  private void cIh()
  {
    AppMethodBeat.i(113063);
    getContentView().setBackgroundColor(getResources().getColor(a.a.sZs));
    findViewById(a.d.rootView).setVisibility(4);
    AppMethodBeat.o(113063);
  }
  
  private String cIi()
  {
    AppMethodBeat.i(113070);
    String str;
    if ((!TextUtils.isEmpty(this.ttf)) && (!TextUtils.isEmpty(this.ttg)))
    {
      str = this.ttf + "," + l.arU(this.ttg);
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.ttf))
    {
      str = this.ttf;
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.ttg))
    {
      str = l.arU(this.ttg);
      AppMethodBeat.o(113070);
      return str;
    }
    AppMethodBeat.o(113070);
    return "";
  }
  
  private void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(113056);
    if (paramBoolean)
    {
      this.jhZ = com.tencent.mm.ui.base.s.a(this, getString(a.g.loading_tips), true, 0, null);
      AppMethodBeat.o(113056);
      return;
    }
    if ((this.jhZ != null) && (this.jhZ.isShowing()))
    {
      this.jhZ.dismiss();
      this.jhZ = null;
    }
    AppMethodBeat.o(113056);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113062);
    if (this.tsZ == null)
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
      AppMethodBeat.o(113062);
      return;
    }
    findViewById(a.d.rootView).setVisibility(0);
    vb localvb;
    if ((!TextUtils.isEmpty(this.tsZ.trX)) && (!TextUtils.isEmpty(this.tsZ.trY)))
    {
      this.tsY.setText(this.tsZ.trX);
      this.tsY.setVisibility(0);
      if ((this.tsZ.fmA == null) || (this.tsZ.fmA.size() <= 0)) {
        break label413;
      }
      this.tsT.setText(getString(a.g.tjV, new Object[] { Integer.valueOf(this.tsZ.fmA.size()) }));
      localvb = ((com.tencent.mm.plugin.card.sharecard.model.q)this.tsZ.fmA.get(0)).tpi;
      if (localvb == null) {
        break label398;
      }
      arp(localvb.lmL);
      this.tsG.setText(localvb.jEi);
      this.tsH.setText(localvb.title);
      int i = getResources().getDimensionPixelSize(a.b.sZN);
      if (TextUtils.isEmpty(localvb.llI)) {
        break label351;
      }
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
      com.tencent.mm.ay.q.bmm();
      ((c.a)localObject).lRV = null;
      ((c.a)localObject).fullPath = m.arc(localvb.llI);
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).kPz = true;
      ((c.a)localObject).lRB = true;
      ((c.a)localObject).kOg = i;
      ((c.a)localObject).kOf = i;
      ((c.a)localObject).lRP = a.c.my_card_package_defaultlogo;
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(localvb.llI, this.tsW, (com.tencent.mm.ay.a.a.c)localObject);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localvb.SfX)) {
        break label372;
      }
      this.tsX.setText(a.g.tjT);
      AppMethodBeat.o(113062);
      return;
      this.tsY.setVisibility(8);
      Log.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
      break;
      label351:
      Log.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
      this.tsW.setImageResource(a.c.my_card_package_defaultlogo);
    }
    label372:
    Log.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
    this.tsX.setText(localvb.SfX);
    AppMethodBeat.o(113062);
    return;
    label398:
    Log.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    AppMethodBeat.o(113062);
    return;
    label413:
    this.tsX.setEnabled(false);
    Log.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
    AppMethodBeat.o(113062);
  }
  
  public int getLayoutId()
  {
    return a.e.thU;
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
        CardConsumeSuccessUI.cIj();
        AppMethodBeat.o(113051);
        return true;
      }
    });
    this.mContentView = getContentView();
    this.tsG = ((TextView)findViewById(a.d.duY));
    this.tsH = ((TextView)findViewById(a.d.tcV));
    this.tsS = ((TextView)findViewById(a.d.tbJ));
    this.tsT = ((TextView)findViewById(a.d.tgX));
    this.tsU = ((TextView)findViewById(a.d.tgW));
    this.tsV = ((TextView)findViewById(a.d.tgV));
    this.tsW = ((ImageView)findViewById(a.d.tcw));
    this.tsX = ((Button)findViewById(a.d.tav));
    this.tsY = ((CheckBox)findViewById(a.d.taI));
    this.tsX.setOnClickListener(this.nmC);
    this.tsY.setOnClickListener(this.nmC);
    this.tsU.setOnClickListener(this.nmC);
    if (this.tsZ != null) {
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
      this.tte = paramIntent.getIntExtra("Ktag_range_index", 0);
      Log.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.tte) });
      if (this.tte >= 2)
      {
        this.ttf = paramIntent.getStringExtra("Klabel_name_list");
        this.ttg = paramIntent.getStringExtra("Kother_user_name_list");
        Log.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.tte), this.ttf });
        if ((TextUtils.isEmpty(this.ttf)) && (TextUtils.isEmpty(this.ttg)))
        {
          Log.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
          AppMethodBeat.o(113069);
          return;
        }
        paramIntent = Arrays.asList(this.ttf.split(","));
        this.tti = l.cW(paramIntent);
        this.tth = l.cV(paramIntent);
        if ((this.ttg != null) && (this.ttg.length() > 0))
        {
          paramIntent = Arrays.asList(this.ttg.split(","));
          this.tth.addAll(paramIntent);
        }
        if (this.tti != null) {
          Log.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.tti.size());
        }
        if (this.tth != null)
        {
          Log.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.tth.size());
          paramIntent = this.tth.iterator();
          while (paramIntent.hasNext()) {
            Log.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (this.tte == 2)
        {
          this.tsV.setVisibility(0);
          this.tsV.setText(getString(a.g.tlC, new Object[] { cIi() }));
          AppMethodBeat.o(113069);
          return;
        }
        if (this.tte == 3)
        {
          this.tsV.setVisibility(0);
          this.tsV.setText(getString(a.g.tlB, new Object[] { cIi() }));
          AppMethodBeat.o(113069);
          return;
        }
        this.tsV.setVisibility(8);
        AppMethodBeat.o(113069);
        return;
      }
      this.tsV.setVisibility(8);
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
    com.tencent.mm.kernel.h.aHF().kcd.a(902, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(910, this);
    paramBundle = "";
    this.ttc = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject;
    if (this.ttc == 1)
    {
      Log.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
      this.tta = getIntent().getStringExtra("key_consumed_card_id");
      this.ttb = getIntent().getStringExtra("key_consumed_Code");
      if (TextUtils.isEmpty(this.tta))
      {
        Log.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
        HO(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      Log.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.ttb);
      lG(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d("", this.tta, this.ttb);
      com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject, 0);
      cIh();
    }
    for (this.ttd = 7;; this.ttd = 4)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.ttd), "", Integer.valueOf(0), "" });
      initView();
      if (!TextUtils.isEmpty(paramBundle)) {
        arp(paramBundle);
      }
      AppMethodBeat.o(113057);
      return;
      if (this.ttc != 2) {
        break;
      }
      Log.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
      this.tmG = getIntent().getStringExtra("key_card_id");
      if (TextUtils.isEmpty(this.tmG))
      {
        Log.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
        HO(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      Log.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.tmG);
      lG(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d(this.tmG, "", "");
      com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject, 0);
      cIh();
    }
    Log.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
    this.tmG = getIntent().getStringExtra("KEY_CARD_ID");
    if (!aro(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON")))
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
      HO(0);
      finish();
      AppMethodBeat.o(113057);
      return;
    }
    if ((this.tsZ != null) && (!Util.isNullOrNil(this.tsZ.fmA)))
    {
      paramBundle = ((com.tencent.mm.plugin.card.sharecard.model.q)this.tsZ.fmA.get(0)).tpi;
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.lmL;; paramBundle = "")
    {
      localObject = paramBundle;
      if (Util.isNullOrNil(paramBundle)) {
        localObject = getIntent().getStringExtra("KEY_CARD_COLOR");
      }
      this.ttd = getIntent().getIntExtra("key_stastic_scene", 0);
      paramBundle = (Bundle)localObject;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113060);
    com.tencent.mm.kernel.h.aHF().kcd.b(902, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(910, this);
    long l = System.currentTimeMillis() - this.mStartTime;
    if (!TextUtils.isEmpty(this.tmG)) {
      com.tencent.mm.plugin.report.service.h.IzE.a(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.ttc), this.tnT, this.tmG, Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113060);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.ttc), this.tnT, this.tta, Long.valueOf(l) });
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113067);
    if (paramInt == 4)
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
      HO(0);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(113065);
    Log.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " scene cmd is " + paramq.getType());
    lG(false);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof g))
      {
        paramString = (g)paramq;
        if (paramString.tqa == 0)
        {
          com.tencent.mm.ui.base.h.cO(this, getString(a.g.tjB));
          setResult(-1);
          this.tsX.setEnabled(false);
          l.cLi();
          Log.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
          HO(-1);
          paramString = ((g)paramq).tpZ;
          paramq = new ShareCardInfo();
          f.a(paramq, paramString);
          l.a(paramq);
          am.cHz().onChange();
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        Log.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + paramString.tqa);
        com.tencent.mm.plugin.card.d.d.c(this, paramString.tqb);
        com.tencent.mm.ui.base.h.cO(this, getString(a.g.tjy));
        AppMethodBeat.o(113065);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramq;
        if (paramString.tqa == 0)
        {
          if ((!TextUtils.isEmpty(paramString.tpZ)) && (aro(paramString.tpZ)))
          {
            Log.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
            this.qdR.post(new Runnable()
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
          if (this.ttc == 1)
          {
            HO(0);
            finish();
            AppMethodBeat.o(113065);
            return;
          }
          cIh();
          arq(paramString.tqb);
          if (Util.isNullOrNil(paramString.tqb))
          {
            com.tencent.mm.ui.base.h.cO(this, getString(a.g.tjA));
            AppMethodBeat.o(113065);
            return;
          }
          com.tencent.mm.ui.base.h.cO(this, paramString.tqb);
          AppMethodBeat.o(113065);
          return;
        }
        if (this.ttc == 1)
        {
          HO(0);
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        Log.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + paramString.tqa);
        cIh();
        arq(paramString.tqb);
        AppMethodBeat.o(113065);
      }
    }
    else
    {
      if (((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.d)) && (this.ttc == 1))
      {
        HO(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI
 * JD-Core Version:    0.7.0.1
 */