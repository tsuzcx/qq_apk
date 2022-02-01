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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.protocal.protobuf.uz;
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
  private com.tencent.mm.ui.base.q gxX;
  private View.OnClickListener kuO;
  private View mContentView;
  private long mStartTime;
  MMHandler ndA;
  private String pQH;
  private String pRT;
  private TextView pWJ;
  private TextView pWK;
  private TextView pWV;
  private TextView pWW;
  private TextView pWX;
  private TextView pWY;
  private ImageView pWZ;
  private Button pXa;
  private CheckBox pXb;
  private j pXc;
  private String pXd;
  private String pXe;
  int pXf;
  int pXg;
  public int pXh;
  private String pXi;
  private String pXj;
  public ArrayList<String> pXk;
  public ArrayList<String> pXl;
  
  public CardConsumeSuccessUI()
  {
    AppMethodBeat.i(113055);
    this.TAG = "MicroMsg.CardConsumeSuccessUI";
    this.pQH = "";
    this.pXd = "";
    this.pRT = "";
    this.pXe = "";
    this.pXf = 0;
    this.pXg = 0;
    this.pXh = 0;
    this.pXi = "";
    this.pXj = "";
    this.pXk = new ArrayList();
    this.pXl = new ArrayList();
    this.mStartTime = 0L;
    this.ndA = new MMHandler(Looper.getMainLooper());
    this.gxX = null;
    this.kuO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(113052);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/sharecard/ui/CardConsumeSuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView.getId() == 2131296327) {
          CardConsumeSuccessUI.a(CardConsumeSuccessUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/CardConsumeSuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113052);
          return;
          if (paramAnonymousView.getId() == 2131308751)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("KLabel_range_index", CardConsumeSuccessUI.this.pXh);
            paramAnonymousView.putExtra("Klabel_name_list", CardConsumeSuccessUI.b(CardConsumeSuccessUI.this));
            paramAnonymousView.putExtra("Kother_user_name_list", CardConsumeSuccessUI.c(CardConsumeSuccessUI.this));
            paramAnonymousView.putExtra("k_sns_label_ui_title", CardConsumeSuccessUI.this.getString(2131757153));
            paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
            paramAnonymousView.putExtra("KLabel_is_filter_private", true);
            com.tencent.mm.br.c.b(CardConsumeSuccessUI.this, "sns", ".ui.SnsLabelUI", paramAnonymousView, 1);
          }
        }
      }
    };
    AppMethodBeat.o(113055);
  }
  
  private static void En(int paramInt)
  {
    AppMethodBeat.i(113068);
    Log.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is ".concat(String.valueOf(paramInt)));
    cn localcn = new cn();
    localcn.dFI.resultCode = paramInt;
    EventCenter.instance.publish(localcn);
    AppMethodBeat.o(113068);
  }
  
  private boolean ajB(String paramString)
  {
    AppMethodBeat.i(113058);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
      AppMethodBeat.o(113058);
      return false;
    }
    this.pXc = s.akm(paramString);
    if (this.pXc == null)
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(113058);
      return false;
    }
    AppMethodBeat.o(113058);
    return true;
  }
  
  @TargetApi(16)
  private void ajC(String paramString)
  {
    AppMethodBeat.i(113064);
    int i = l.ake(paramString);
    this.mContentView.setBackgroundColor(i);
    setActionbarColor(i);
    if (com.tencent.mm.compatible.util.d.oD(16)) {
      this.pXa.setBackground(l.fi(i, getResources().getDimensionPixelSize(2131165986) / 2));
    }
    for (;;)
    {
      this.mContentView.invalidate();
      AppMethodBeat.o(113064);
      return;
      this.pXa.setBackgroundDrawable(l.fi(i, getResources().getDimensionPixelSize(2131165986) / 2));
    }
  }
  
  private void ajD(String paramString)
  {
    AppMethodBeat.i(113066);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131756957);
    }
    com.tencent.mm.ui.base.h.a(this, str, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(113054);
        paramAnonymousDialogInterface.dismiss();
        CardConsumeSuccessUI.cuH();
        CardConsumeSuccessUI.this.finish();
        AppMethodBeat.o(113054);
      }
    });
    AppMethodBeat.o(113066);
  }
  
  private void cuF()
  {
    AppMethodBeat.i(113063);
    getContentView().setBackgroundColor(getResources().getColor(2131100115));
    findViewById(2131307159).setVisibility(4);
    AppMethodBeat.o(113063);
  }
  
  private String cuG()
  {
    AppMethodBeat.i(113070);
    String str;
    if ((!TextUtils.isEmpty(this.pXi)) && (!TextUtils.isEmpty(this.pXj)))
    {
      str = this.pXi + "," + l.akh(this.pXj);
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.pXi))
    {
      str = this.pXi;
      AppMethodBeat.o(113070);
      return str;
    }
    if (!TextUtils.isEmpty(this.pXj))
    {
      str = l.akh(this.pXj);
      AppMethodBeat.o(113070);
      return str;
    }
    AppMethodBeat.o(113070);
    return "";
  }
  
  private void ku(boolean paramBoolean)
  {
    AppMethodBeat.i(113056);
    if (paramBoolean)
    {
      this.gxX = com.tencent.mm.ui.base.q.a(this, getString(2131762446), true, 0, null);
      AppMethodBeat.o(113056);
      return;
    }
    if ((this.gxX != null) && (this.gxX.isShowing()))
    {
      this.gxX.dismiss();
      this.gxX = null;
    }
    AppMethodBeat.o(113056);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(113062);
    if (this.pXc == null)
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
      AppMethodBeat.o(113062);
      return;
    }
    findViewById(2131307159).setVisibility(0);
    uz localuz;
    if ((!TextUtils.isEmpty(this.pXc.pVX)) && (!TextUtils.isEmpty(this.pXc.pVY)))
    {
      this.pXb.setText(this.pXc.pVX);
      this.pXb.setVisibility(0);
      if ((this.pXc.dtS == null) || (this.pXc.dtS.size() <= 0)) {
        break label413;
      }
      this.pWW.setText(getString(2131756986, new Object[] { Integer.valueOf(this.pXc.dtS.size()) }));
      localuz = ((com.tencent.mm.plugin.card.sharecard.model.q)this.pXc.dtS.get(0)).pTh;
      if (localuz == null) {
        break label398;
      }
      ajC(localuz.ixw);
      this.pWJ.setText(localuz.gTG);
      this.pWK.setText(localuz.title);
      int i = getResources().getDimensionPixelSize(2131166011);
      if (TextUtils.isEmpty(localuz.iwv)) {
        break label351;
      }
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aKJ();
      com.tencent.mm.av.q.bcW();
      ((c.a)localObject).jbw = null;
      ((c.a)localObject).fullPath = m.ajp(localuz.iwv);
      ((c.a)localObject).jbf = true;
      ((c.a)localObject).iaT = true;
      ((c.a)localObject).jbd = true;
      ((c.a)localObject).hZA = i;
      ((c.a)localObject).hZz = i;
      ((c.a)localObject).jbq = 2131234198;
      localObject = ((c.a)localObject).bdv();
      com.tencent.mm.av.q.bcV().a(localuz.iwv, this.pWZ, (com.tencent.mm.av.a.a.c)localObject);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localuz.LeJ)) {
        break label372;
      }
      this.pXa.setText(2131756983);
      AppMethodBeat.o(113062);
      return;
      this.pXb.setVisibility(8);
      Log.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
      break;
      label351:
      Log.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
      this.pWZ.setImageResource(2131234198);
    }
    label372:
    Log.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
    this.pXa.setText(localuz.LeJ);
    AppMethodBeat.o(113062);
    return;
    label398:
    Log.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    AppMethodBeat.o(113062);
    return;
    label413:
    this.pXa.setEnabled(false);
    Log.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
    AppMethodBeat.o(113062);
  }
  
  public int getLayoutId()
  {
    return 2131493352;
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
        CardConsumeSuccessUI.cuH();
        AppMethodBeat.o(113051);
        return true;
      }
    });
    this.mContentView = getContentView();
    this.pWJ = ((TextView)findViewById(2131298056));
    this.pWK = ((TextView)findViewById(2131298179));
    this.pWV = ((TextView)findViewById(2131298088));
    this.pWW = ((TextView)findViewById(2131308752));
    this.pWX = ((TextView)findViewById(2131308751));
    this.pWY = ((TextView)findViewById(2131308750));
    this.pWZ = ((ImageView)findViewById(2131298144));
    this.pXa = ((Button)findViewById(2131296327));
    this.pXb = ((CheckBox)findViewById(2131297081));
    this.pXa.setOnClickListener(this.kuO);
    this.pXb.setOnClickListener(this.kuO);
    this.pWX.setOnClickListener(this.kuO);
    if (this.pXc != null) {
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
      this.pXh = paramIntent.getIntExtra("Ktag_range_index", 0);
      Log.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.pXh) });
      if (this.pXh >= 2)
      {
        this.pXi = paramIntent.getStringExtra("Klabel_name_list");
        this.pXj = paramIntent.getStringExtra("Kother_user_name_list");
        Log.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.pXh), this.pXi });
        if ((TextUtils.isEmpty(this.pXi)) && (TextUtils.isEmpty(this.pXj)))
        {
          Log.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
          AppMethodBeat.o(113069);
          return;
        }
        paramIntent = Arrays.asList(this.pXi.split(","));
        this.pXl = l.cZ(paramIntent);
        this.pXk = l.cY(paramIntent);
        if ((this.pXj != null) && (this.pXj.length() > 0))
        {
          paramIntent = Arrays.asList(this.pXj.split(","));
          this.pXk.addAll(paramIntent);
        }
        if (this.pXl != null) {
          Log.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.pXl.size());
        }
        if (this.pXk != null)
        {
          Log.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.pXk.size());
          paramIntent = this.pXk.iterator();
          while (paramIntent.hasNext()) {
            Log.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (this.pXh == 2)
        {
          this.pWY.setVisibility(0);
          this.pWY.setText(getString(2131757152, new Object[] { cuG() }));
          AppMethodBeat.o(113069);
          return;
        }
        if (this.pXh == 3)
        {
          this.pWY.setVisibility(0);
          this.pWY.setText(getString(2131757151, new Object[] { cuG() }));
          AppMethodBeat.o(113069);
          return;
        }
        this.pWY.setVisibility(8);
        AppMethodBeat.o(113069);
        return;
      }
      this.pWY.setVisibility(8);
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
    com.tencent.mm.kernel.g.aAg().hqi.a(902, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(910, this);
    paramBundle = "";
    this.pXf = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject;
    if (this.pXf == 1)
    {
      Log.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
      this.pXd = getIntent().getStringExtra("key_consumed_card_id");
      this.pXe = getIntent().getStringExtra("key_consumed_Code");
      if (TextUtils.isEmpty(this.pXd))
      {
        Log.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
        En(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      Log.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.pXe);
      ku(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d("", this.pXd, this.pXe);
      com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
      cuF();
    }
    for (this.pXg = 7;; this.pXg = 4)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11324, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.pXg), "", Integer.valueOf(0), "" });
      initView();
      if (!TextUtils.isEmpty(paramBundle)) {
        ajC(paramBundle);
      }
      AppMethodBeat.o(113057);
      return;
      if (this.pXf != 2) {
        break;
      }
      Log.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
      this.pQH = getIntent().getStringExtra("key_card_id");
      if (TextUtils.isEmpty(this.pQH))
      {
        Log.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
        En(0);
        finish();
        AppMethodBeat.o(113057);
        return;
      }
      Log.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.pQH);
      ku(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d(this.pQH, "", "");
      com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
      cuF();
    }
    Log.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
    this.pQH = getIntent().getStringExtra("KEY_CARD_ID");
    if (!ajB(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON")))
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
      En(0);
      finish();
      AppMethodBeat.o(113057);
      return;
    }
    if ((this.pXc != null) && (!Util.isNullOrNil(this.pXc.dtS)))
    {
      paramBundle = ((com.tencent.mm.plugin.card.sharecard.model.q)this.pXc.dtS.get(0)).pTh;
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.ixw;; paramBundle = "")
    {
      localObject = paramBundle;
      if (Util.isNullOrNil(paramBundle)) {
        localObject = getIntent().getStringExtra("KEY_CARD_COLOR");
      }
      this.pXg = getIntent().getIntExtra("key_stastic_scene", 0);
      paramBundle = (Bundle)localObject;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113060);
    com.tencent.mm.kernel.g.aAg().hqi.b(902, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(910, this);
    long l = System.currentTimeMillis() - this.mStartTime;
    if (!TextUtils.isEmpty(this.pQH)) {
      com.tencent.mm.plugin.report.service.h.CyF.a(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.pXf), this.pRT, this.pQH, Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      AppMethodBeat.o(113060);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.pXf), this.pRT, this.pXd, Long.valueOf(l) });
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113067);
    if (paramInt == 4)
    {
      Log.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
      En(0);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(113065);
    Log.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " scene cmd is " + paramq.getType());
    ku(false);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.g)paramq;
        if (paramString.pTZ == 0)
        {
          com.tencent.mm.ui.base.h.cD(this, getString(2131756959));
          setResult(-1);
          this.pXa.setEnabled(false);
          l.cxG();
          Log.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
          En(-1);
          paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramq).pTY;
          paramq = new ShareCardInfo();
          f.a(paramq, paramString);
          l.a(paramq);
          am.ctX().onChange();
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        Log.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + paramString.pTZ);
        com.tencent.mm.plugin.card.d.d.c(this, paramString.pUa);
        com.tencent.mm.ui.base.h.cD(this, getString(2131756955));
        AppMethodBeat.o(113065);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramq;
        if (paramString.pTZ == 0)
        {
          if ((!TextUtils.isEmpty(paramString.pTY)) && (ajB(paramString.pTY)))
          {
            Log.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
            this.ndA.post(new Runnable()
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
          if (this.pXf == 1)
          {
            En(0);
            finish();
            AppMethodBeat.o(113065);
            return;
          }
          cuF();
          ajD(paramString.pUa);
          if (Util.isNullOrNil(paramString.pUa))
          {
            com.tencent.mm.ui.base.h.cD(this, getString(2131756957));
            AppMethodBeat.o(113065);
            return;
          }
          com.tencent.mm.ui.base.h.cD(this, paramString.pUa);
          AppMethodBeat.o(113065);
          return;
        }
        if (this.pXf == 1)
        {
          En(0);
          finish();
          AppMethodBeat.o(113065);
          return;
        }
        Log.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + paramString.pTZ);
        cuF();
        ajD(paramString.pUa);
        AppMethodBeat.o(113065);
      }
    }
    else
    {
      if (((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.d)) && (this.pXf == 1))
      {
        En(0);
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