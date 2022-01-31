package com.tencent.mm.plugin.card.ui;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.m.a;
import com.tencent.mm.plugin.card.d.d.7;
import com.tencent.mm.plugin.card.d.d.8;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.ArrayList;

public class CardShopUI
  extends DrawStatusBarActivity
  implements m.a
{
  private ListView Nn;
  private ProgressDialog ecf;
  private View.OnClickListener fvj = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if (paramAnonymousView.getId() == a.d.shop_poi_layout)
      {
        paramAnonymousView = (mb)paramAnonymousView.getTag();
        if (paramAnonymousView != null)
        {
          com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, paramAnonymousView.bRt, paramAnonymousView.bTc, paramAnonymousView.ekZ);
          com.tencent.mm.plugin.report.service.h.nFQ.f(11941, new Object[] { Integer.valueOf(5), CardShopUI.c(CardShopUI.this).azB(), CardShopUI.c(CardShopUI.this).azC(), "", paramAnonymousView.name });
        }
      }
    }
  };
  BroadcastReceiver hWU = new CardShopUI.4(this);
  private String ijW;
  private com.tencent.mm.plugin.card.base.b ikk;
  private ArrayList<mb> ikq = new ArrayList();
  private boolean iqE = false;
  private String iwK = "";
  private CardShopUI.a iwL;
  private LinearLayout iwM;
  private View iwN;
  private TextView iwO;
  
  private void aCh()
  {
    y.i("MicroMsg.CardShopUI", "openLocation");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.LOCALE_CHANGED");
    registerReceiver(this.hWU, localIntentFilter);
    if (aCi())
    {
      aCj();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(a.g.card_report_location_confirm_nogps, new Object[] { getString(a.g.card_adapted_stores) }), getString(a.g.app_tip), new d.7(this), new d.8());
  }
  
  private static boolean aCi()
  {
    if ((!l.Oc()) && (!l.Od())) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  private void aCj()
  {
    if (am.aAv().a(this.iwK, this.ijW, this))
    {
      AppCompatActivity localAppCompatActivity = this.mController.uMN;
      getString(a.g.app_tip);
      this.ecf = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(a.g.card_getting_shop_list), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          paramAnonymousDialogInterface = am.aAv();
          paramAnonymousDialogInterface.a(CardShopUI.d(CardShopUI.this), CardShopUI.this);
          if (paramAnonymousDialogInterface.ilk != null) {
            g.DO().dJT.c(paramAnonymousDialogInterface.ilk);
          }
        }
      });
      return;
    }
    com.tencent.mm.ui.base.h.bC(this, getString(a.g.card_get_shop_list_fail));
  }
  
  public final void a(boolean paramBoolean, ArrayList<mb> paramArrayList)
  {
    if (this.ecf != null)
    {
      this.ecf.dismiss();
      this.ecf = null;
    }
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      y.d("MicroMsg.CardShopUI", "onGotCardShop, isOk = %b, shop list size = %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      if (paramBoolean) {
        break;
      }
      y.e("MicroMsg.CardShopUI", "onGotCardShop fail");
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      y.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
      return;
    }
    if (this.ikq != null)
    {
      this.ikq.clear();
      this.ikq.addAll(paramArrayList);
      this.iwN.setVisibility(0);
    }
    for (;;)
    {
      this.iwL.notifyDataSetChanged();
      return;
      this.iwN.setVisibility(8);
    }
  }
  
  protected final int getLayoutId()
  {
    return a.e.card_shop_ui;
  }
  
  protected final void initView()
  {
    if (!TextUtils.isEmpty(this.ikk.azx().sIT)) {
      setMMTitle(this.ikk.azx().sIT);
    }
    for (;;)
    {
      this.Nn = ((ListView)findViewById(a.d.card_shop_lv));
      this.iwM = ((LinearLayout)View.inflate(getBaseContext(), a.e.card_list_header_view, null));
      this.Nn.addHeaderView(this.iwM);
      this.iwL = new CardShopUI.a(this, (byte)0);
      this.Nn.setAdapter(this.iwL);
      Intent localIntent = getIntent();
      this.Nn.setOnItemClickListener(new CardShopUI.1(this, localIntent));
      setBackBtn(new CardShopUI.2(this));
      this.iwN = View.inflate(this, a.e.card_list_header_tip_layout, null);
      if (this.iwM != null) {
        this.iwM.addView(this.iwN);
      }
      this.iwO = ((TextView)this.iwN.findViewById(a.d.card_list_header_tips));
      this.iwO.setText(a.g.card_shop_list_header_tips);
      this.iwN.setVisibility(8);
      com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, getStatusBarColor(), true);
      return;
      setMMTitle(a.g.card_adapted_stores);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.ikk = ((com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info_data"));
    String str = getIntent().getStringExtra("KEY_CARD_TP_ID");
    paramBundle = getIntent().getStringExtra("KEY_CARD_ID");
    if (this.ikk != null)
    {
      y.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
      this.iwK = this.ikk.azC();
      paramBundle = this.ikk.azB();
    }
    for (;;)
    {
      this.ijW = paramBundle;
      do
      {
        if (TextUtils.isEmpty(this.iwK))
        {
          y.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
          finish();
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
        y.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        this.iqE = bool;
        if (this.iqE) {
          aCh();
        }
        initView();
        return;
      } while (TextUtils.isEmpty(str));
      this.iwK = str;
      if (TextUtils.isEmpty(paramBundle)) {
        paramBundle = "";
      }
    }
  }
  
  protected void onDestroy()
  {
    if (this.iqE) {
      unregisterReceiver(this.hWU);
    }
    am.aAv().a(this.iwK, this);
    super.onDestroy();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.CardShopUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (paramArrayOfInt[0] != 0) {
        break;
      }
      y.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.iqE);
    } while (this.iqE);
    this.iqE = true;
    aCh();
    return;
    com.tencent.mm.ui.base.h.a(this, getString(a.g.permission_location_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.confirm_dialog_cancel), false, new CardShopUI.6(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI
 * JD-Core Version:    0.7.0.1
 */