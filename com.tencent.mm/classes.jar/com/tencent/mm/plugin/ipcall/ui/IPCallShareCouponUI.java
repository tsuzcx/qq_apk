package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ln;
import com.tencent.mm.model.bh;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.protocal.protobuf.cfz;
import com.tencent.mm.protocal.protobuf.fgv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallShareCouponUI
  extends MMActivity
  implements i
{
  private ProgressDialog DUF;
  private IListener DUw;
  private String DXT;
  private String DXU;
  private String DXV;
  private String DXW;
  private String DXX;
  private String DXY;
  private String DXZ;
  private TextView DYA;
  private TextView DYB;
  private TextView DYC;
  private ImageView DYD;
  private TextView DYE;
  private TextView DYF;
  private View DYG;
  private IPCallDynamicTextView DYH;
  private com.tencent.mm.plugin.ipcall.model.f.b DYI;
  private LinkedList<fgv> DYJ;
  private boolean DYK;
  private RelativeLayout DYn;
  private TextView DYo;
  private ImageView DYp;
  private RelativeLayout DYq;
  private TextView DYr;
  private ImageView DYs;
  private LinearLayout DYt;
  private LinearLayout DYu;
  private LinearLayout DYv;
  private LinearLayout DYw;
  private ImageView DYx;
  private LinearLayout DYy;
  private ImageView DYz;
  private String mDesc;
  private String mTitle;
  private String mWording;
  
  public IPCallShareCouponUI()
  {
    AppMethodBeat.i(25953);
    this.DYI = new com.tencent.mm.plugin.ipcall.model.f.b();
    this.DXT = null;
    this.mDesc = null;
    this.DXU = null;
    this.mTitle = null;
    this.mWording = null;
    this.DXV = null;
    this.DXW = null;
    this.DXX = null;
    this.DXY = null;
    this.DXZ = null;
    this.DYJ = null;
    this.DUw = new IListener() {};
    this.DYK = false;
    AppMethodBeat.o(25953);
  }
  
  private void a(cfz paramcfz)
  {
    this.DXT = paramcfz.Tnh;
    this.mDesc = paramcfz.CMB;
    this.DXU = paramcfz.Tni;
    this.mTitle = paramcfz.fwr;
    this.mWording = paramcfz.CNP;
    this.DXV = paramcfz.Tnj;
    this.DXX = paramcfz.Tnk;
    this.DXY = paramcfz.Tnl;
    this.DXZ = paramcfz.Tnm;
    this.DYJ = paramcfz.TmS;
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(25957);
    if (!Util.isNullOrNil(this.DXX))
    {
      if (this.DXW == null)
      {
        this.DYH.setValue(this.DXX, this.DXX);
        this.DXW = this.DXX;
      }
    }
    else
    {
      this.DYE.getText();
      this.DYE.setText(this.DXY);
      if (!Util.isNullOrNil(this.DXY)) {
        break label188;
      }
      this.DYE.setVisibility(8);
    }
    StringBuffer localStringBuffer;
    for (;;)
    {
      localStringBuffer = new StringBuffer("");
      if ((this.DYJ == null) || (this.DYJ.size() <= 0)) {
        break label199;
      }
      Iterator localIterator = this.DYJ.iterator();
      while (localIterator.hasNext())
      {
        fgv localfgv = (fgv)localIterator.next();
        if ((localfgv != null) && (!Util.isNullOrNil(localfgv.Uht))) {
          localStringBuffer.append(localfgv.Uht).append('\n');
        }
      }
      this.DYH.setValue(this.DXW, this.DXX);
      break;
      label188:
      this.DYE.setVisibility(0);
    }
    label199:
    if (!Util.isNullOrNil(localStringBuffer.toString()))
    {
      if (localStringBuffer.charAt(localStringBuffer.length() - 1) == '\n') {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      this.DYF.setText(localStringBuffer.toString());
      this.DYF.setVisibility(0);
    }
    while ((this.DYE.getVisibility() == 0) && (this.DYF.getVisibility() == 0))
    {
      this.DYG.setVisibility(0);
      AppMethodBeat.o(25957);
      return;
      this.DYF.setText("");
      this.DYF.setVisibility(8);
    }
    this.DYG.setVisibility(8);
    AppMethodBeat.o(25957);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.ehQ;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25954);
    super.onCreate(paramBundle);
    bh.aGY().a(257, this);
    EventCenter.instance.addListener(this.DUw);
    setMMTitle(R.l.eJy);
    setBackBtn(new IPCallShareCouponUI.8(this));
    removeAllOptionMenu();
    addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25943);
        paramAnonymousMenuItem = com.tencent.mm.plugin.ipcall.a.c.eKP();
        int i;
        if ((paramAnonymousMenuItem != null) && (!Util.isNullOrNil(paramAnonymousMenuItem.Tnr))) {
          if (com.tencent.mm.n.h.axc().getInt("WCOWebPayListSwitch", 0) > 0)
          {
            i = 1;
            if (i == 0) {
              break label136;
            }
            i = 1;
            label44:
            if (i == 0) {
              break label141;
            }
            paramAnonymousMenuItem = new String[3];
            paramAnonymousMenuItem[0] = IPCallShareCouponUI.this.getString(R.l.eJx);
            paramAnonymousMenuItem[1] = IPCallShareCouponUI.this.getString(R.l.eIL);
            paramAnonymousMenuItem[2] = IPCallShareCouponUI.this.getString(R.l.eIx);
            IPCallShareCouponUI.a(IPCallShareCouponUI.this, true);
          }
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.b(IPCallShareCouponUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.d()
          {
            public final void qy(int paramAnonymous2Int)
            {
              AppMethodBeat.i(25942);
              int i = paramAnonymous2Int;
              if (!IPCallShareCouponUI.h(IPCallShareCouponUI.this)) {
                i = paramAnonymous2Int + 1;
              }
              switch (i)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(25942);
                return;
                IPCallShareCouponUI.i(IPCallShareCouponUI.this);
                AppMethodBeat.o(25942);
                return;
                IPCallShareCouponUI.d(IPCallShareCouponUI.this);
                AppMethodBeat.o(25942);
                return;
                IPCallShareCouponUI.e(IPCallShareCouponUI.this);
              }
            }
          });
          AppMethodBeat.o(25943);
          return true;
          i = 0;
          break;
          label136:
          i = 0;
          break label44;
          label141:
          paramAnonymousMenuItem = new String[2];
          paramAnonymousMenuItem[0] = IPCallShareCouponUI.this.getString(R.l.eIL);
          paramAnonymousMenuItem[1] = IPCallShareCouponUI.this.getString(R.l.eIx);
          IPCallShareCouponUI.a(IPCallShareCouponUI.this, false);
        }
      }
    });
    this.DYH = ((IPCallDynamicTextView)findViewById(R.h.dta));
    this.DYn = ((RelativeLayout)findViewById(R.h.dSk));
    this.DYo = ((TextView)findViewById(R.h.dSn));
    this.DYp = ((ImageView)findViewById(R.h.dSl));
    bh.beI();
    if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vjo, Boolean.FALSE)).booleanValue()) {
      this.DYp.setVisibility(0);
    }
    bh.beI();
    paramBundle = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vjn, "");
    this.DYo.setText(paramBundle);
    this.DYq = ((RelativeLayout)findViewById(R.h.dRH));
    this.DYr = ((TextView)findViewById(R.h.dQP));
    this.DYs = ((ImageView)findViewById(R.h.dQN));
    bh.beI();
    paramBundle = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vjp, "");
    this.DYr.setText(paramBundle);
    this.DYE = ((TextView)findViewById(R.h.dCT));
    this.DYF = ((TextView)findViewById(R.h.dQM));
    this.DYG = findViewById(R.h.dVs);
    this.DYt = ((LinearLayout)findViewById(R.h.dFN));
    this.DYD = ((ImageView)findViewById(R.h.new_dot));
    bh.beI();
    if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vjq, Boolean.FALSE)).booleanValue()) {
      this.DYD.setVisibility(0);
    }
    this.DYA = ((TextView)findViewById(R.h.dPw));
    this.DYB = ((TextView)findViewById(R.h.dqJ));
    this.DYC = ((TextView)findViewById(R.h.dVO));
    this.DYu = ((LinearLayout)findViewById(R.h.dUZ));
    this.DYv = ((LinearLayout)findViewById(R.h.dNb));
    this.DYy = ((LinearLayout)findViewById(R.h.dTw));
    this.DYz = ((ImageView)findViewById(R.h.dTx));
    this.DYw = ((LinearLayout)findViewById(R.h.dMT));
    this.DYx = ((ImageView)findViewById(R.h.dMU));
    bh.beI();
    if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vjw, Boolean.FALSE)).booleanValue()) {
      this.DYx.setVisibility(0);
    }
    int i;
    label559:
    label587:
    label593:
    label614:
    Object localObject1;
    label779:
    Object localObject2;
    if (com.tencent.mm.plugin.ipcall.a.c.eKO())
    {
      i = 1;
      if (i != 0) {
        this.DYn.setVisibility(8);
      }
      if ((com.tencent.mm.plugin.ipcall.a.c.eKO()) || (com.tencent.mm.n.h.axc().getInt("WCOPackagePurchaseSwitch", 0) == 0)) {
        break label1059;
      }
      i = 1;
      if (i != 0) {
        this.DYq.setVisibility(0);
      }
      if (com.tencent.mm.n.h.axc().getInt("WCOAccountDetailSwitch", 0) != 1) {
        break label1064;
      }
      i = 1;
      if (i == 0) {
        break label1069;
      }
      i = 1;
      if (i != 0) {
        this.DYt.setVisibility(8);
      }
      if (!com.tencent.mm.plugin.ipcall.a.c.eKO()) {
        break label1074;
      }
      i = 1;
      if (i != 0) {
        this.DYu.setVisibility(8);
      }
      this.DYA.setOnClickListener(new IPCallShareCouponUI.9(this));
      this.DYB.setOnClickListener(new IPCallShareCouponUI.10(this));
      this.DYt.setOnClickListener(new IPCallShareCouponUI.11(this));
      this.DYu.setOnClickListener(new IPCallShareCouponUI.12(this));
      this.DYw.setOnClickListener(new IPCallShareCouponUI.13(this));
      this.DYv.setOnClickListener(new IPCallShareCouponUI.14(this));
      this.DYn.setOnClickListener(new IPCallShareCouponUI.15(this));
      this.DYq.setOnClickListener(new IPCallShareCouponUI.2(this));
      this.DYy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25938);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          Intent localIntent = new Intent();
          paramAnonymousView = IPCallShareCouponUI.this.getString(R.l.eJe) + "&usedcc=";
          localObject = com.tencent.mm.plugin.ipcall.model.c.eJb().eJe();
          int i;
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            i = ((List)localObject).size();
            if (i <= 5) {
              break label287;
            }
            i = 5;
          }
          label284:
          label287:
          for (;;)
          {
            int j = 0;
            if (j < i)
            {
              String str = com.tencent.mm.plugin.ipcall.a.a.aMD(((Integer)((List)localObject).get(j)).toString());
              if (Util.isNullOrNil(str)) {
                break label284;
              }
              paramAnonymousView = paramAnonymousView + str + "|";
            }
            for (;;)
            {
              j += 1;
              break;
              localObject = paramAnonymousView;
              if (paramAnonymousView.endsWith("|")) {}
              for (localObject = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);; localObject = paramAnonymousView + com.tencent.mm.plugin.ipcall.a.a.aMD(com.tencent.mm.plugin.ipcall.a.c.eKM()))
              {
                localIntent.putExtra("rawUrl", (String)localObject);
                localIntent.putExtra("showShare", false);
                com.tencent.mm.by.c.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25938);
                return;
              }
            }
          }
        }
      });
      paramBundle = com.tencent.mm.plugin.ipcall.a.c.eKP();
      if (paramBundle == null) {
        break label1109;
      }
      a(paramBundle);
      refreshView();
      if (!com.tencent.mm.plugin.ipcall.a.c.eKO()) {
        break label1181;
      }
      paramBundle = getString(R.l.eKn);
      localObject1 = getString(R.l.eKm);
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
      this.DYC.setText((CharSequence)localObject2);
      this.DYC.setMovementMethod(LinkMovementMethod.getInstance());
      this.DYC.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = (LinearLayout)findViewById(R.h.dKU);
      if ((paramBundle != null) && (this.DYn.getVisibility() == 8) && (this.DYq.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (LinearLayout)findViewById(R.h.dKV);
      if ((paramBundle != null) && (this.DYu.getVisibility() == 8) && (this.DYv.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      this.DYI.start();
      AppMethodBeat.o(25954);
      return;
      if (com.tencent.mm.n.h.axc().getInt("WCOPurchaseSwitch", 0) == 1) {}
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
      if (com.tencent.mm.n.h.axc().getInt("WCOInviteFriend", 0) == 1) {}
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
      this.DYH.setText("0");
      paramBundle = getContext();
      getString(R.l.app_tip);
      this.DUF = com.tencent.mm.ui.base.h.a(paramBundle, getString(R.l.eIQ), true, new IPCallShareCouponUI.4(this));
      break label779;
      label1159:
      ((Spannable)localObject2).setSpan(localObject1, 0, ((Spannable)localObject2).length(), 33);
      break label893;
      label1181:
      this.DYC.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25956);
    super.onDestroy();
    bh.aGY().b(257, this);
    EventCenter.instance.removeListener(this.DUw);
    this.DYI.DRV = Util.nowMilliSecond();
    this.DYI.finish();
    AppMethodBeat.o(25956);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25955);
    super.onResume();
    com.tencent.mm.plugin.ipcall.model.g.b.eJS().tA(false);
    AppMethodBeat.o(25955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25958);
    if ((paramq instanceof g))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(((g)paramq).DRD);
        refreshView();
        if ((this.DUF != null) && (this.DUF.isShowing())) {
          this.DUF.dismiss();
        }
        AppMethodBeat.o(25958);
        return;
      }
      if ((this.DUF != null) && (this.DUF.isShowing()))
      {
        this.DUF.dismiss();
        com.tencent.mm.ui.base.h.d(getContext(), getString(R.l.eIO), getString(R.l.ip_call_func_name), new IPCallShareCouponUI.7(this));
      }
    }
    AppMethodBeat.o(25958);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI
 * JD-Core Version:    0.7.0.1
 */