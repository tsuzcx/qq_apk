package com.tencent.mm.plugin.card.sharecard.ui;

import android.annotation.TargetApi;
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
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.h.a.bz;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CardConsumeSuccessUI
  extends DrawStatusBarActivity
  implements com.tencent.mm.ah.f
{
  private View QR;
  private final String TAG = "MicroMsg.CardConsumeSuccessUI";
  private com.tencent.mm.ui.base.p dpF = null;
  private View.OnClickListener fvj = new CardConsumeSuccessUI.2(this);
  ah gNQ = new ah(Looper.getMainLooper());
  private String ijW = "";
  private String ilj = "";
  private TextView ipK;
  private TextView ipL;
  private TextView ipM;
  private TextView ipN;
  private ImageView ipO;
  private Button ipP;
  private CheckBox ipQ;
  private j ipR;
  private String ipS = "";
  private String ipT = "";
  int ipU = 0;
  int ipV = 0;
  public int ipW = 0;
  private String ipX = "";
  private String ipY = "";
  public ArrayList<String> ipZ = new ArrayList();
  private TextView ipy;
  private TextView ipz;
  public ArrayList<String> iqa = new ArrayList();
  private long mStartTime = 0L;
  
  private void aAX()
  {
    this.mController.contentView.setBackgroundColor(getResources().getColor(a.a.card_bg_color));
    findViewById(a.d.rootView).setVisibility(4);
  }
  
  private String aAY()
  {
    if ((!TextUtils.isEmpty(this.ipX)) && (!TextUtils.isEmpty(this.ipY))) {
      return this.ipX + "," + l.yV(this.ipY);
    }
    if (!TextUtils.isEmpty(this.ipX)) {
      return this.ipX;
    }
    if (!TextUtils.isEmpty(this.ipY)) {
      return l.yV(this.ipY);
    }
    return "";
  }
  
  private void aZ()
  {
    if (this.ipR == null)
    {
      y.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
      return;
    }
    findViewById(a.d.rootView).setVisibility(0);
    mg localmg;
    if ((!TextUtils.isEmpty(this.ipR.ioM)) && (!TextUtils.isEmpty(this.ipR.ioN)))
    {
      this.ipQ.setText(this.ipR.ioM);
      this.ipQ.setVisibility(0);
      if ((this.ipR.ioK == null) || (this.ipR.ioK.size() <= 0)) {
        break label383;
      }
      this.ipL.setText(getString(a.g.card_consumed_success_count_tip, new Object[] { Integer.valueOf(this.ipR.ioK.size()) }));
      localmg = ((q)this.ipR.ioK.get(0)).ims;
      if (localmg == null) {
        break label374;
      }
      yA(localmg.color);
      this.ipy.setText(localmg.imA);
      this.ipz.setText(localmg.title);
      int i = getResources().getDimensionPixelSize(a.b.card_list_logo_height);
      if (TextUtils.isEmpty(localmg.ilp)) {
        break label333;
      }
      Object localObject = new c.a();
      ((c.a)localObject).eri = e.bkH;
      o.OO();
      ((c.a)localObject).erB = null;
      ((c.a)localObject).erh = com.tencent.mm.plugin.card.model.m.yn(localmg.ilp);
      ((c.a)localObject).erf = true;
      ((c.a)localObject).erD = true;
      ((c.a)localObject).erd = true;
      ((c.a)localObject).erm = i;
      ((c.a)localObject).erl = i;
      ((c.a)localObject).eru = a.c.my_card_package_defaultlogo;
      localObject = ((c.a)localObject).OV();
      o.ON().a(localmg.ilp, this.ipO, (c)localObject);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localmg.sIz)) {
        break label354;
      }
      this.ipP.setText(a.g.card_consume_accept_btn);
      return;
      this.ipQ.setVisibility(8);
      y.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
      break;
      label333:
      y.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
      this.ipO.setImageResource(a.c.my_card_package_defaultlogo);
    }
    label354:
    y.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
    this.ipP.setText(localmg.sIz);
    return;
    label374:
    y.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    return;
    label383:
    this.ipP.setEnabled(false);
    y.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
  }
  
  private void ew(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.dpF = com.tencent.mm.ui.base.p.b(this, getString(a.g.loading_tips), true, 0, null);
    }
    while ((this.dpF == null) || (!this.dpF.isShowing())) {
      return;
    }
    this.dpF.dismiss();
    this.dpF = null;
  }
  
  private static void oU(int paramInt)
  {
    y.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is " + paramInt);
    bz localbz = new bz();
    localbz.bIg.aYY = paramInt;
    com.tencent.mm.sdk.b.a.udP.m(localbz);
  }
  
  @TargetApi(16)
  private void yA(String paramString)
  {
    int i = l.yR(paramString);
    this.QR.setBackgroundColor(i);
    ta(i);
    com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, i, true);
    if (com.tencent.mm.compatible.util.d.gF(16)) {
      this.ipP.setBackground(l.cx(i, getResources().getDimensionPixelSize(a.b.card_accept_btn_height) / 2));
    }
    for (;;)
    {
      this.QR.invalidate();
      return;
      this.ipP.setBackgroundDrawable(l.cx(i, getResources().getDimensionPixelSize(a.b.card_accept_btn_height) / 2));
    }
  }
  
  private void yB(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(a.g.card_accept_over_limite);
    }
    com.tencent.mm.ui.base.h.a(this, str, "", false, new CardConsumeSuccessUI.4(this));
  }
  
  private boolean yz(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
      return false;
    }
    this.ipR = r.za(paramString);
    if (this.ipR == null)
    {
      y.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is " + paramString);
      return false;
    }
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.e.card_consume_success_ui;
  }
  
  protected final void initView()
  {
    setBackBtn(new CardConsumeSuccessUI.1(this));
    this.QR = this.mController.contentView;
    this.ipy = ((TextView)findViewById(a.d.card_brand_name));
    this.ipz = ((TextView)findViewById(a.d.card_name));
    this.ipK = ((TextView)findViewById(a.d.card_count));
    this.ipL = ((TextView)findViewById(a.d.success_tips));
    this.ipM = ((TextView)findViewById(a.d.success_share_tv));
    this.ipN = ((TextView)findViewById(a.d.success_share_detail_tv));
    this.ipO = ((ImageView)findViewById(a.d.card_img));
    this.ipP = ((Button)findViewById(a.d.accept_btn));
    this.ipQ = ((CheckBox)findViewById(a.d.attention_checkbox));
    this.ipP.setOnClickListener(this.fvj);
    this.ipQ.setOnClickListener(this.fvj);
    this.ipM.setOnClickListener(this.fvj);
    if (this.ipR != null) {
      aZ();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    this.ipW = paramIntent.getIntExtra("Ktag_range_index", 0);
    y.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.ipW) });
    if (this.ipW >= 2)
    {
      this.ipX = paramIntent.getStringExtra("Klabel_name_list");
      this.ipY = paramIntent.getStringExtra("Kother_user_name_list");
      y.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.ipW), this.ipX });
      if ((TextUtils.isEmpty(this.ipX)) && (TextUtils.isEmpty(this.ipY)))
      {
        y.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
        return;
      }
      paramIntent = Arrays.asList(this.ipX.split(","));
      this.iqa = l.aT(paramIntent);
      this.ipZ = l.aS(paramIntent);
      if ((this.ipY != null) && (this.ipY.length() > 0))
      {
        paramIntent = Arrays.asList(this.ipY.split(","));
        this.ipZ.addAll(paramIntent);
      }
      if (this.iqa != null) {
        y.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.iqa.size());
      }
      if (this.ipZ != null)
      {
        y.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.ipZ.size());
        paramIntent = this.ipZ.iterator();
        while (paramIntent.hasNext()) {
          y.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[] { (String)paramIntent.next() });
        }
      }
      if (this.ipW == 2)
      {
        this.ipN.setVisibility(0);
        this.ipN.setText(getString(a.g.card_share_card_private_setting_share, new Object[] { aAY() }));
        return;
      }
      if (this.ipW == 3)
      {
        this.ipN.setVisibility(0);
        this.ipN.setText(getString(a.g.card_share_card_private_setting_not_share, new Object[] { aAY() }));
        return;
      }
      this.ipN.setVisibility(8);
      return;
    }
    this.ipN.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
    this.mStartTime = System.currentTimeMillis();
    setMMTitle("");
    setResult(0);
    com.tencent.mm.kernel.g.DO().dJT.a(902, this);
    com.tencent.mm.kernel.g.DO().dJT.a(910, this);
    paramBundle = "";
    this.ipU = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject;
    if (this.ipU == 1)
    {
      y.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
      this.ipS = getIntent().getStringExtra("key_consumed_card_id");
      this.ipT = getIntent().getStringExtra("key_consumed_Code");
      if (TextUtils.isEmpty(this.ipS))
      {
        y.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
        oU(0);
        finish();
        return;
      }
      y.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.ipT);
      ew(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d("", this.ipS, this.ipT);
      com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject, 0);
      aAX();
    }
    for (this.ipV = 7;; this.ipV = 4)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(11324, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.ipV), "", Integer.valueOf(0), "" });
      initView();
      if (TextUtils.isEmpty(paramBundle)) {
        break;
      }
      yA(paramBundle);
      return;
      if (this.ipU != 2) {
        break label434;
      }
      y.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
      this.ijW = getIntent().getStringExtra("key_card_id");
      if (TextUtils.isEmpty(this.ijW))
      {
        y.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
        oU(0);
        finish();
        return;
      }
      y.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.ijW);
      ew(true);
      localObject = new com.tencent.mm.plugin.card.sharecard.model.d(this.ijW, "", "");
      com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject, 0);
      aAX();
    }
    label434:
    y.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
    this.ijW = getIntent().getStringExtra("KEY_CARD_ID");
    if (!yz(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON")))
    {
      y.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
      oU(0);
      finish();
      return;
    }
    if ((this.ipR != null) && (!bk.dk(this.ipR.ioK)))
    {
      paramBundle = ((q)this.ipR.ioK.get(0)).ims;
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.color;; paramBundle = "")
    {
      localObject = paramBundle;
      if (bk.bl(paramBundle)) {
        localObject = getIntent().getStringExtra("KEY_CARD_COLOR");
      }
      this.ipV = getIntent().getIntExtra("key_stastic_scene", 0);
      paramBundle = (Bundle)localObject;
      break;
    }
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.kernel.g.DO().dJT.b(902, this);
    com.tencent.mm.kernel.g.DO().dJT.b(910, this);
    long l = System.currentTimeMillis() - this.mStartTime;
    if (!TextUtils.isEmpty(this.ijW)) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.ipU), this.ilj, this.ijW, Long.valueOf(l) });
    }
    for (;;)
    {
      super.onDestroy();
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.f(13219, new Object[] { "CardConsumeSuccessUI", Integer.valueOf(this.ipU), this.ilj, this.ipS, Long.valueOf(l) });
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      y.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
      oU(0);
      finish();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " scene cmd is " + paramm.getType());
    ew(false);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = (com.tencent.mm.plugin.card.sharecard.model.g)paramm;
        if (paramString.ino == 0)
        {
          com.tencent.mm.ui.base.h.bC(this, getString(a.g.card_accept_success_tips));
          setResult(-1);
          this.ipP.setEnabled(false);
          l.aDe();
          y.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
          oU(-1);
          paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).inn;
          paramm = new ShareCardInfo();
          com.tencent.mm.plugin.card.d.f.a(paramm, paramString);
          l.a(paramm);
          am.aAz().axs();
          finish();
        }
      }
      while (!(paramm instanceof com.tencent.mm.plugin.card.sharecard.model.d))
      {
        return;
        y.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + paramString.ino);
        com.tencent.mm.plugin.card.d.d.b(this, paramString.inp);
        com.tencent.mm.ui.base.h.bC(this, getString(a.g.card_accept_fail_tips));
        return;
      }
      paramString = (com.tencent.mm.plugin.card.sharecard.model.d)paramm;
      if (paramString.ino == 0)
      {
        if ((!TextUtils.isEmpty(paramString.inn)) && (yz(paramString.inn)))
        {
          y.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
          this.gNQ.post(new CardConsumeSuccessUI.3(this));
          return;
        }
        y.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
        if (this.ipU == 1)
        {
          oU(0);
          finish();
          return;
        }
        aAX();
        yB(paramString.inp);
        if (bk.bl(paramString.inp))
        {
          com.tencent.mm.ui.base.h.bC(this, getString(a.g.card_accept_over_limite));
          return;
        }
        com.tencent.mm.ui.base.h.bC(this, paramString.inp);
        return;
      }
      if (this.ipU == 1)
      {
        oU(0);
        finish();
        return;
      }
      y.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + paramString.ino);
      aAX();
      yB(paramString.inp);
      return;
    }
    if (((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.d)) && (this.ipU == 1))
    {
      oU(0);
      finish();
      return;
    }
    com.tencent.mm.plugin.card.d.d.b(this, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI
 * JD-Core Version:    0.7.0.1
 */