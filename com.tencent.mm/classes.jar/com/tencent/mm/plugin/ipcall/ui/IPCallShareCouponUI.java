package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.m.e;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.protocal.c.cho;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallShareCouponUI
  extends MMActivity
  implements f
{
  private String dkv = null;
  private ProgressDialog luI;
  private com.tencent.mm.sdk.b.c luz = new IPCallShareCouponUI.1(this);
  private TextView lyA;
  private ImageView lyB;
  private RelativeLayout lyC;
  private TextView lyD;
  private ImageView lyE;
  private LinearLayout lyF;
  private LinearLayout lyG;
  private LinearLayout lyH;
  private LinearLayout lyI;
  private ImageView lyJ;
  private LinearLayout lyK;
  private ImageView lyL;
  private TextView lyM;
  private TextView lyN;
  private TextView lyO;
  private ImageView lyP;
  private TextView lyQ;
  private TextView lyR;
  private View lyS;
  private IPCallDynamicTextView lyT;
  private com.tencent.mm.plugin.ipcall.a.e.b lyU = new com.tencent.mm.plugin.ipcall.a.e.b();
  private LinkedList<cho> lyV = null;
  private boolean lyW = false;
  private String lye = null;
  private String lyf = null;
  private String lyg = null;
  private String lyh = null;
  private String lyi = null;
  private String lyj = null;
  private String lyk = null;
  private String lyl = null;
  private RelativeLayout lyz;
  private String mTitle = null;
  
  private void a(ams paramams)
  {
    this.lye = paramams.tiD;
    this.dkv = paramams.kRN;
    this.lyf = paramams.tiE;
    this.mTitle = paramams.bGw;
    this.lyg = paramams.lsL;
    this.lyh = paramams.tiF;
    this.lyj = paramams.tiG;
    this.lyk = paramams.tiH;
    this.lyl = paramams.tiI;
    this.lyV = paramams.tir;
  }
  
  private void aqU()
  {
    if (!bk.bl(this.lyj))
    {
      if (this.lyi == null)
      {
        this.lyT.setValue(this.lyj, this.lyj);
        this.lyi = this.lyj;
      }
    }
    else
    {
      this.lyQ.getText();
      this.lyQ.setText(this.lyk);
      if (!bk.bl(this.lyk)) {
        break label181;
      }
      this.lyQ.setVisibility(8);
    }
    StringBuffer localStringBuffer;
    for (;;)
    {
      localStringBuffer = new StringBuffer("");
      if ((this.lyV == null) || (this.lyV.size() <= 0)) {
        break label192;
      }
      Iterator localIterator = this.lyV.iterator();
      while (localIterator.hasNext())
      {
        cho localcho = (cho)localIterator.next();
        if ((localcho != null) && (!bk.bl(localcho.tWr))) {
          localStringBuffer.append(localcho.tWr).append('\n');
        }
      }
      this.lyT.setValue(this.lyi, this.lyj);
      break;
      label181:
      this.lyQ.setVisibility(0);
    }
    label192:
    if (!bk.bl(localStringBuffer.toString()))
    {
      if (localStringBuffer.charAt(localStringBuffer.length() - 1) == '\n') {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      this.lyR.setText(localStringBuffer.toString());
      this.lyR.setVisibility(0);
    }
    while ((this.lyQ.getVisibility() == 0) && (this.lyR.getVisibility() == 0))
    {
      this.lyS.setVisibility(0);
      return;
      this.lyR.setText("");
      this.lyR.setVisibility(8);
    }
    this.lyS.setVisibility(8);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ip_call_coupons_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Dk().a(257, this);
    a.udP.c(this.luz);
    setMMTitle(R.l.ip_calladdress_account);
    setBackBtn(new IPCallShareCouponUI.8(this));
    this.mController.removeAllOptionMenu();
    addIconOptionMenu(0, R.g.mm_title_btn_menu, new IPCallShareCouponUI.6(this));
    this.lyT = ((IPCallDynamicTextView)findViewById(R.h.balance));
    this.lyz = ((RelativeLayout)findViewById(R.h.rechargeLayout));
    this.lyA = ((TextView)findViewById(R.h.recharge_info_tv));
    this.lyB = ((ImageView)findViewById(R.h.recharge_dot));
    au.Hx();
    if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uqm, Boolean.valueOf(false))).booleanValue()) {
      this.lyB.setVisibility(0);
    }
    au.Hx();
    paramBundle = (String)com.tencent.mm.model.c.Dz().get(ac.a.uql, "");
    this.lyA.setText(paramBundle);
    this.lyC = ((RelativeLayout)findViewById(R.h.purchase_package_rl));
    this.lyD = ((TextView)findViewById(R.h.package_info_tv));
    this.lyE = ((ImageView)findViewById(R.h.package_dot));
    au.Hx();
    paramBundle = (String)com.tencent.mm.model.c.Dz().get(ac.a.uqn, "");
    this.lyD.setText(paramBundle);
    this.lyQ = ((TextView)findViewById(R.h.coupons_time));
    this.lyR = ((TextView)findViewById(R.h.package_desc_tv));
    this.lyS = findViewById(R.h.small_divider);
    this.lyF = ((LinearLayout)findViewById(R.h.exchange_records));
    this.lyP = ((ImageView)findViewById(R.h.new_dot));
    au.Hx();
    if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uqo, Boolean.valueOf(false))).booleanValue()) {
      this.lyP.setVisibility(0);
    }
    this.lyM = ((TextView)findViewById(R.h.normal_question));
    this.lyN = ((TextView)findViewById(R.h.agreement));
    this.lyO = ((TextView)findViewById(R.h.stop_tip_tv));
    this.lyG = ((LinearLayout)findViewById(R.h.share_coupon));
    this.lyH = ((LinearLayout)findViewById(R.h.my_gift_card));
    this.lyK = ((LinearLayout)findViewById(R.h.see_price));
    this.lyL = ((ImageView)findViewById(R.h.see_price_new_dot));
    this.lyI = ((LinearLayout)findViewById(R.h.msg_center));
    this.lyJ = ((ImageView)findViewById(R.h.msg_center_new_dot));
    au.Hx();
    if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uqu, Boolean.valueOf(false))).booleanValue()) {
      this.lyJ.setVisibility(0);
    }
    int i;
    label557:
    label585:
    label591:
    label612:
    Object localObject1;
    label777:
    Object localObject2;
    if (com.tencent.mm.plugin.ipcall.b.c.bds())
    {
      i = 1;
      if (i != 0) {
        this.lyz.setVisibility(8);
      }
      if ((com.tencent.mm.plugin.ipcall.b.c.bds()) || (com.tencent.mm.m.g.AA().getInt("WCOPackagePurchaseSwitch", 0) == 0)) {
        break label1051;
      }
      i = 1;
      if (i != 0) {
        this.lyC.setVisibility(0);
      }
      if (com.tencent.mm.m.g.AA().getInt("WCOAccountDetailSwitch", 0) != 1) {
        break label1056;
      }
      i = 1;
      if (i == 0) {
        break label1061;
      }
      i = 1;
      if (i != 0) {
        this.lyF.setVisibility(8);
      }
      if (!com.tencent.mm.plugin.ipcall.b.c.bds()) {
        break label1066;
      }
      i = 1;
      if (i != 0) {
        this.lyG.setVisibility(8);
      }
      this.lyM.setOnClickListener(new IPCallShareCouponUI.9(this));
      this.lyN.setOnClickListener(new IPCallShareCouponUI.10(this));
      this.lyF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          IPCallShareCouponUI.f(IPCallShareCouponUI.this);
        }
      });
      this.lyG.setOnClickListener(new IPCallShareCouponUI.12(this));
      this.lyI.setOnClickListener(new IPCallShareCouponUI.13(this));
      this.lyH.setOnClickListener(new IPCallShareCouponUI.14(this));
      this.lyz.setOnClickListener(new IPCallShareCouponUI.15(this));
      this.lyC.setOnClickListener(new IPCallShareCouponUI.2(this));
      this.lyK.setOnClickListener(new IPCallShareCouponUI.3(this));
      paramBundle = com.tencent.mm.plugin.ipcall.b.c.bdt();
      if (paramBundle == null) {
        break label1101;
      }
      a(paramBundle);
      aqU();
      if (!com.tencent.mm.plugin.ipcall.b.c.bds()) {
        break label1176;
      }
      paramBundle = getString(R.l.ipcall_stop_tip);
      localObject1 = getString(R.l.ipcall_stop_see_detail);
      localObject2 = paramBundle + (String)localObject1;
      localObject1 = new IPCallShareCouponUI.5(this);
      localObject2 = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject2);
      i = paramBundle.length();
      int j = ((Spannable)localObject2).length();
      if ((i < 0) || (i >= j) || (j < 0) || (j > ((Spannable)localObject2).length())) {
        break label1154;
      }
      ((Spannable)localObject2).setSpan(localObject1, i, j, 33);
      label891:
      this.lyO.setText((CharSequence)localObject2);
      this.lyO.setMovementMethod(LinkMovementMethod.getInstance());
      this.lyO.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = (LinearLayout)findViewById(R.h.layoutRechargeAndPackage);
      if ((paramBundle != null) && (this.lyz.getVisibility() == 8) && (this.lyC.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (LinearLayout)findViewById(R.h.layoutShareAndCard);
      if ((paramBundle != null) && (this.lyG.getVisibility() == 8) && (this.lyH.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      this.lyU.start();
      return;
      if (com.tencent.mm.m.g.AA().getInt("WCOPurchaseSwitch", 0) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1046;
        }
        i = 1;
        break;
      }
      label1046:
      i = 0;
      break;
      label1051:
      i = 0;
      break label557;
      label1056:
      i = 0;
      break label585;
      label1061:
      i = 0;
      break label591;
      label1066:
      if (com.tencent.mm.m.g.AA().getInt("WCOInviteFriend", 0) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1096;
        }
        i = 1;
        break;
      }
      label1096:
      i = 0;
      break label612;
      label1101:
      this.lyT.setText("0");
      paramBundle = this.mController.uMN;
      getString(R.l.app_tip);
      this.luI = h.b(paramBundle, getString(R.l.ip_call_loading_tip), true, new IPCallShareCouponUI.4(this));
      break label777;
      label1154:
      ((Spannable)localObject2).setSpan(localObject1, 0, ((Spannable)localObject2).length(), 33);
      break label891;
      label1176:
      this.lyO.setVisibility(8);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(257, this);
    a.udP.d(this.luz);
    this.lyU.lrU = bk.UY();
    this.lyU.finish();
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.mm.plugin.ipcall.a.f.b.bcJ().gZ(false);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.ipcall.a.d.g))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label57;
      }
      a(((com.tencent.mm.plugin.ipcall.a.d.g)paramm).lrC);
      aqU();
      if ((this.luI != null) && (this.luI.isShowing())) {
        this.luI.dismiss();
      }
    }
    label57:
    while ((this.luI == null) || (!this.luI.isShowing())) {
      return;
    }
    this.luI.dismiss();
    h.a(this.mController.uMN, getString(R.l.ip_call_load_error_tip), getString(R.l.ip_call_func_name), new IPCallShareCouponUI.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI
 * JD-Core Version:    0.7.0.1
 */