package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.is;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallShareCouponUI
  extends MMActivity
  implements f
{
  private String mDesc;
  private String mTitle;
  private String mWording;
  private com.tencent.mm.sdk.b.c nRR;
  private ProgressDialog nSa;
  private RelativeLayout nVL;
  private TextView nVM;
  private ImageView nVN;
  private RelativeLayout nVO;
  private TextView nVP;
  private ImageView nVQ;
  private LinearLayout nVR;
  private LinearLayout nVS;
  private LinearLayout nVT;
  private LinearLayout nVU;
  private ImageView nVV;
  private LinearLayout nVW;
  private ImageView nVX;
  private TextView nVY;
  private TextView nVZ;
  private String nVr;
  private String nVs;
  private String nVt;
  private String nVu;
  private String nVv;
  private String nVw;
  private String nVx;
  private TextView nWa;
  private ImageView nWb;
  private TextView nWc;
  private TextView nWd;
  private View nWe;
  private IPCallDynamicTextView nWf;
  private com.tencent.mm.plugin.ipcall.a.e.b nWg;
  private LinkedList<cuz> nWh;
  private boolean nWi;
  
  public IPCallShareCouponUI()
  {
    AppMethodBeat.i(22334);
    this.nWg = new com.tencent.mm.plugin.ipcall.a.e.b();
    this.nVr = null;
    this.mDesc = null;
    this.nVs = null;
    this.mTitle = null;
    this.mWording = null;
    this.nVt = null;
    this.nVu = null;
    this.nVv = null;
    this.nVw = null;
    this.nVx = null;
    this.nWh = null;
    this.nRR = new com.tencent.mm.sdk.b.c() {};
    this.nWi = false;
    AppMethodBeat.o(22334);
  }
  
  private void a(ash paramash)
  {
    this.nVr = paramash.xhp;
    this.mDesc = paramash.Desc;
    this.nVs = paramash.xhq;
    this.mTitle = paramash.Title;
    this.mWording = paramash.nQe;
    this.nVt = paramash.xhr;
    this.nVv = paramash.xhs;
    this.nVw = paramash.xht;
    this.nVx = paramash.xhu;
    this.nWh = paramash.xhd;
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(22338);
    if (!bo.isNullOrNil(this.nVv))
    {
      if (this.nVu == null)
      {
        this.nWf.setValue(this.nVv, this.nVv);
        this.nVu = this.nVv;
      }
    }
    else
    {
      this.nWc.getText();
      this.nWc.setText(this.nVw);
      if (!bo.isNullOrNil(this.nVw)) {
        break label188;
      }
      this.nWc.setVisibility(8);
    }
    StringBuffer localStringBuffer;
    for (;;)
    {
      localStringBuffer = new StringBuffer("");
      if ((this.nWh == null) || (this.nWh.size() <= 0)) {
        break label199;
      }
      Iterator localIterator = this.nWh.iterator();
      while (localIterator.hasNext())
      {
        cuz localcuz = (cuz)localIterator.next();
        if ((localcuz != null) && (!bo.isNullOrNil(localcuz.xKK))) {
          localStringBuffer.append(localcuz.xKK).append('\n');
        }
      }
      this.nWf.setValue(this.nVu, this.nVv);
      break;
      label188:
      this.nWc.setVisibility(0);
    }
    label199:
    if (!bo.isNullOrNil(localStringBuffer.toString()))
    {
      if (localStringBuffer.charAt(localStringBuffer.length() - 1) == '\n') {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      this.nWd.setText(localStringBuffer.toString());
      this.nWd.setVisibility(0);
    }
    while ((this.nWc.getVisibility() == 0) && (this.nWd.getVisibility() == 0))
    {
      this.nWe.setVisibility(0);
      AppMethodBeat.o(22338);
      return;
      this.nWd.setText("");
      this.nWd.setVisibility(8);
    }
    this.nWe.setVisibility(8);
    AppMethodBeat.o(22338);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969927;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22335);
    super.onCreate(paramBundle);
    aw.Rc().a(257, this);
    a.ymk.c(this.nRR);
    setMMTitle(2131300907);
    setBackBtn(new IPCallShareCouponUI.8(this));
    removeAllOptionMenu();
    addIconOptionMenu(0, 2130839668, new IPCallShareCouponUI.6(this));
    this.nWf = ((IPCallDynamicTextView)findViewById(2131825182));
    this.nVL = ((RelativeLayout)findViewById(2131825187));
    this.nVM = ((TextView)findViewById(2131825188));
    this.nVN = ((ImageView)findViewById(2131825189));
    aw.aaz();
    if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yAm, Boolean.FALSE)).booleanValue()) {
      this.nVN.setVisibility(0);
    }
    aw.aaz();
    paramBundle = (String)com.tencent.mm.model.c.Ru().get(ac.a.yAl, "");
    this.nVM.setText(paramBundle);
    this.nVO = ((RelativeLayout)findViewById(2131825190));
    this.nVP = ((TextView)findViewById(2131825191));
    this.nVQ = ((ImageView)findViewById(2131825192));
    aw.aaz();
    paramBundle = (String)com.tencent.mm.model.c.Ru().get(ac.a.yAn, "");
    this.nVP.setText(paramBundle);
    this.nWc = ((TextView)findViewById(2131825183));
    this.nWd = ((TextView)findViewById(2131825185));
    this.nWe = findViewById(2131825184);
    this.nVR = ((LinearLayout)findViewById(2131825201));
    this.nWb = ((ImageView)findViewById(2131825202));
    aw.aaz();
    if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yAo, Boolean.FALSE)).booleanValue()) {
      this.nWb.setVisibility(0);
    }
    this.nVY = ((TextView)findViewById(2131825206));
    this.nVZ = ((TextView)findViewById(2131825207));
    this.nWa = ((TextView)findViewById(2131825205));
    this.nVS = ((LinearLayout)findViewById(2131825194));
    this.nVT = ((LinearLayout)findViewById(2131825196));
    this.nVW = ((LinearLayout)findViewById(2131825203));
    this.nVX = ((ImageView)findViewById(2131825204));
    this.nVU = ((LinearLayout)findViewById(2131825199));
    this.nVV = ((ImageView)findViewById(2131825200));
    aw.aaz();
    if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yAu, Boolean.FALSE)).booleanValue()) {
      this.nVV.setVisibility(0);
    }
    int i;
    label559:
    label587:
    label593:
    label614:
    Object localObject1;
    label779:
    Object localObject2;
    if (com.tencent.mm.plugin.ipcall.b.c.bKO())
    {
      i = 1;
      if (i != 0) {
        this.nVL.setVisibility(8);
      }
      if ((com.tencent.mm.plugin.ipcall.b.c.bKO()) || (com.tencent.mm.m.g.Nq().getInt("WCOPackagePurchaseSwitch", 0) == 0)) {
        break label1059;
      }
      i = 1;
      if (i != 0) {
        this.nVO.setVisibility(0);
      }
      if (com.tencent.mm.m.g.Nq().getInt("WCOAccountDetailSwitch", 0) != 1) {
        break label1064;
      }
      i = 1;
      if (i == 0) {
        break label1069;
      }
      i = 1;
      if (i != 0) {
        this.nVR.setVisibility(8);
      }
      if (!com.tencent.mm.plugin.ipcall.b.c.bKO()) {
        break label1074;
      }
      i = 1;
      if (i != 0) {
        this.nVS.setVisibility(8);
      }
      this.nVY.setOnClickListener(new IPCallShareCouponUI.9(this));
      this.nVZ.setOnClickListener(new IPCallShareCouponUI.10(this));
      this.nVR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22329);
          IPCallShareCouponUI.f(IPCallShareCouponUI.this);
          AppMethodBeat.o(22329);
        }
      });
      this.nVS.setOnClickListener(new IPCallShareCouponUI.12(this));
      this.nVU.setOnClickListener(new IPCallShareCouponUI.13(this));
      this.nVT.setOnClickListener(new IPCallShareCouponUI.14(this));
      this.nVL.setOnClickListener(new IPCallShareCouponUI.15(this));
      this.nVO.setOnClickListener(new IPCallShareCouponUI.2(this));
      this.nVW.setOnClickListener(new IPCallShareCouponUI.3(this));
      paramBundle = com.tencent.mm.plugin.ipcall.b.c.bKP();
      if (paramBundle == null) {
        break label1109;
      }
      a(paramBundle);
      refreshView();
      if (!com.tencent.mm.plugin.ipcall.b.c.bKO()) {
        break label1181;
      }
      paramBundle = getString(2131300963);
      localObject1 = getString(2131300962);
      localObject2 = paramBundle + (String)localObject1;
      localObject1 = new IPCallShareCouponUI.5(this);
      localObject2 = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject2);
      i = paramBundle.length();
      int j = ((Spannable)localObject2).length();
      if ((i < 0) || (i >= j) || (j < 0) || (j > ((Spannable)localObject2).length())) {
        break label1159;
      }
      ((Spannable)localObject2).setSpan(localObject1, i, j, 33);
      label893:
      this.nWa.setText((CharSequence)localObject2);
      this.nWa.setMovementMethod(LinkMovementMethod.getInstance());
      this.nWa.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = (LinearLayout)findViewById(2131825186);
      if ((paramBundle != null) && (this.nVL.getVisibility() == 8) && (this.nVO.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (LinearLayout)findViewById(2131825193);
      if ((paramBundle != null) && (this.nVS.getVisibility() == 8) && (this.nVT.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      this.nWg.start();
      AppMethodBeat.o(22335);
      return;
      if (com.tencent.mm.m.g.Nq().getInt("WCOPurchaseSwitch", 0) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1054;
        }
        i = 1;
        break;
      }
      label1054:
      i = 0;
      break;
      label1059:
      i = 0;
      break label559;
      label1064:
      i = 0;
      break label587;
      label1069:
      i = 0;
      break label593;
      label1074:
      if (com.tencent.mm.m.g.Nq().getInt("WCOInviteFriend", 0) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1104;
        }
        i = 1;
        break;
      }
      label1104:
      i = 0;
      break label614;
      label1109:
      this.nWf.setText("0");
      paramBundle = getContext();
      getString(2131297087);
      this.nSa = h.b(paramBundle, getString(2131300856), true, new IPCallShareCouponUI.4(this));
      break label779;
      label1159:
      ((Spannable)localObject2).setSpan(localObject1, 0, ((Spannable)localObject2).length(), 33);
      break label893;
      label1181:
      this.nWa.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22337);
    super.onDestroy();
    aw.Rc().b(257, this);
    a.ymk.d(this.nRR);
    this.nWg.nPq = bo.aoy();
    this.nWg.finish();
    AppMethodBeat.o(22337);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22336);
    super.onResume();
    com.tencent.mm.plugin.ipcall.a.f.b.bJQ().iJ(false);
    AppMethodBeat.o(22336);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(22339);
    if ((paramm instanceof com.tencent.mm.plugin.ipcall.a.d.g))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(((com.tencent.mm.plugin.ipcall.a.d.g)paramm).nOY);
        refreshView();
        if ((this.nSa != null) && (this.nSa.isShowing())) {
          this.nSa.dismiss();
        }
        AppMethodBeat.o(22339);
        return;
      }
      if ((this.nSa != null) && (this.nSa.isShowing()))
      {
        this.nSa.dismiss();
        h.a(getContext(), getString(2131300854), getString(2131300847), new IPCallShareCouponUI.7(this));
      }
    }
    AppMethodBeat.o(22339);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI
 * JD-Core Version:    0.7.0.1
 */