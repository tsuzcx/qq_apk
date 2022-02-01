package com.tencent.mm.plugin.ipcall.ui;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ms;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.gdh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallShareCouponUI
  extends MMActivity
  implements h
{
  private IListener JLG;
  private ImageView JPA;
  private LinearLayout JPB;
  private LinearLayout JPC;
  private LinearLayout JPD;
  private LinearLayout JPE;
  private ImageView JPF;
  private LinearLayout JPH;
  private ImageView JPI;
  private TextView JPJ;
  private TextView JPK;
  private TextView JPL;
  private ImageView JPM;
  private TextView JPN;
  private TextView JPO;
  private View JPP;
  private IPCallDynamicTextView JPQ;
  private com.tencent.mm.plugin.ipcall.model.f.b JPR;
  private LinkedList<gdh> JPS;
  private boolean JPT;
  private String JPb;
  private String JPc;
  private String JPd;
  private String JPe;
  private String JPf;
  private String JPg;
  private String JPh;
  private RelativeLayout JPv;
  private TextView JPw;
  private ImageView JPx;
  private RelativeLayout JPy;
  private TextView JPz;
  private String mDesc;
  private String mTitle;
  private String mWording;
  private ProgressDialog xZJ;
  
  public IPCallShareCouponUI()
  {
    AppMethodBeat.i(25953);
    this.JPR = new com.tencent.mm.plugin.ipcall.model.f.b();
    this.JPb = null;
    this.mDesc = null;
    this.JPc = null;
    this.mTitle = null;
    this.mWording = null;
    this.JPd = null;
    this.JPe = null;
    this.JPf = null;
    this.JPg = null;
    this.JPh = null;
    this.JPS = null;
    this.JLG = new IListener(com.tencent.mm.app.f.hfK) {};
    this.JPT = false;
    AppMethodBeat.o(25953);
  }
  
  private void a(cwc paramcwc)
  {
    this.JPb = paramcwc.aaBn;
    this.mDesc = paramcwc.IGG;
    this.JPc = paramcwc.aaBo;
    this.mTitle = paramcwc.hAP;
    this.mWording = paramcwc.IHZ;
    this.JPd = paramcwc.aaBp;
    this.JPf = paramcwc.aaBq;
    this.JPg = paramcwc.aaBr;
    this.JPh = paramcwc.aaBs;
    this.JPS = paramcwc.aaAY;
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(25957);
    if (!Util.isNullOrNil(this.JPf))
    {
      if (this.JPe == null)
      {
        this.JPQ.setValue(this.JPf, this.JPf);
        this.JPe = this.JPf;
      }
    }
    else
    {
      this.JPN.getText();
      this.JPN.setText(this.JPg);
      if (!Util.isNullOrNil(this.JPg)) {
        break label188;
      }
      this.JPN.setVisibility(8);
    }
    StringBuffer localStringBuffer;
    for (;;)
    {
      localStringBuffer = new StringBuffer("");
      if ((this.JPS == null) || (this.JPS.size() <= 0)) {
        break label199;
      }
      Iterator localIterator = this.JPS.iterator();
      while (localIterator.hasNext())
      {
        gdh localgdh = (gdh)localIterator.next();
        if ((localgdh != null) && (!Util.isNullOrNil(localgdh.acbp))) {
          localStringBuffer.append(localgdh.acbp).append('\n');
        }
      }
      this.JPQ.setValue(this.JPe, this.JPf);
      break;
      label188:
      this.JPN.setVisibility(0);
    }
    label199:
    if (!Util.isNullOrNil(localStringBuffer.toString()))
    {
      if (localStringBuffer.charAt(localStringBuffer.length() - 1) == '\n') {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      this.JPO.setText(localStringBuffer.toString());
      this.JPO.setVisibility(0);
    }
    while ((this.JPN.getVisibility() == 0) && (this.JPO.getVisibility() == 0))
    {
      this.JPP.setVisibility(0);
      AppMethodBeat.o(25957);
      return;
      this.JPO.setText("");
      this.JPO.setVisibility(8);
    }
    this.JPP.setVisibility(8);
    AppMethodBeat.o(25957);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gkL;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25954);
    super.onCreate(paramBundle);
    bh.aZW().a(257, this);
    this.JLG.alive();
    setMMTitle(R.l.gLf);
    setBackBtn(new IPCallShareCouponUI.8(this));
    removeAllOptionMenu();
    addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25943);
        paramAnonymousMenuItem = com.tencent.mm.plugin.ipcall.a.c.fSO();
        int i;
        if ((paramAnonymousMenuItem != null) && (!Util.isNullOrNil(paramAnonymousMenuItem.aaBx))) {
          if (i.aRC().getInt("WCOWebPayListSwitch", 0) > 0)
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
            paramAnonymousMenuItem[0] = IPCallShareCouponUI.this.getString(R.l.gLe);
            paramAnonymousMenuItem[1] = IPCallShareCouponUI.this.getString(R.l.gKs);
            paramAnonymousMenuItem[2] = IPCallShareCouponUI.this.getString(R.l.gKe);
            IPCallShareCouponUI.a(IPCallShareCouponUI.this, true);
          }
        }
        for (;;)
        {
          k.b(IPCallShareCouponUI.this.getContext(), null, paramAnonymousMenuItem, null, new k.d()
          {
            public final void qz(int paramAnonymous2Int)
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
          paramAnonymousMenuItem[0] = IPCallShareCouponUI.this.getString(R.l.gKs);
          paramAnonymousMenuItem[1] = IPCallShareCouponUI.this.getString(R.l.gKe);
          IPCallShareCouponUI.a(IPCallShareCouponUI.this, false);
        }
      }
    });
    this.JPQ = ((IPCallDynamicTextView)findViewById(R.h.ftr));
    this.JPv = ((RelativeLayout)findViewById(R.h.fUk));
    this.JPw = ((TextView)findViewById(R.h.fUn));
    this.JPx = ((ImageView)findViewById(R.h.fUl));
    bh.bCz();
    if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acKI, Boolean.FALSE)).booleanValue()) {
      this.JPx.setVisibility(0);
    }
    bh.bCz();
    paramBundle = (String)com.tencent.mm.model.c.ban().get(at.a.acKH, "");
    this.JPw.setText(paramBundle);
    this.JPy = ((RelativeLayout)findViewById(R.h.fTH));
    this.JPz = ((TextView)findViewById(R.h.fSV));
    this.JPA = ((ImageView)findViewById(R.h.fST));
    bh.bCz();
    paramBundle = (String)com.tencent.mm.model.c.ban().get(at.a.acKJ, "");
    this.JPz.setText(paramBundle);
    this.JPN = ((TextView)findViewById(R.h.fDL));
    this.JPO = ((TextView)findViewById(R.h.fSS));
    this.JPP = findViewById(R.h.fXN);
    this.JPB = ((LinearLayout)findViewById(R.h.fGT));
    this.JPM = ((ImageView)findViewById(R.h.new_dot));
    bh.bCz();
    if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acKK, Boolean.FALSE)).booleanValue()) {
      this.JPM.setVisibility(0);
    }
    this.JPJ = ((TextView)findViewById(R.h.fRz));
    this.JPK = ((TextView)findViewById(R.h.fqX));
    this.JPL = ((TextView)findViewById(R.h.fYl));
    this.JPC = ((LinearLayout)findViewById(R.h.fXv));
    this.JPD = ((LinearLayout)findViewById(R.h.fOV));
    this.JPH = ((LinearLayout)findViewById(R.h.fVD));
    this.JPI = ((ImageView)findViewById(R.h.fVE));
    this.JPE = ((LinearLayout)findViewById(R.h.fOF));
    this.JPF = ((ImageView)findViewById(R.h.fOG));
    bh.bCz();
    if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acKQ, Boolean.FALSE)).booleanValue()) {
      this.JPF.setVisibility(0);
    }
    int i;
    label555:
    label583:
    label589:
    label610:
    Object localObject1;
    label775:
    Object localObject2;
    if (com.tencent.mm.plugin.ipcall.a.c.fSN())
    {
      i = 1;
      if (i != 0) {
        this.JPv.setVisibility(8);
      }
      if ((com.tencent.mm.plugin.ipcall.a.c.fSN()) || (i.aRC().getInt("WCOPackagePurchaseSwitch", 0) == 0)) {
        break label1055;
      }
      i = 1;
      if (i != 0) {
        this.JPy.setVisibility(0);
      }
      if (i.aRC().getInt("WCOAccountDetailSwitch", 0) != 1) {
        break label1060;
      }
      i = 1;
      if (i == 0) {
        break label1065;
      }
      i = 1;
      if (i != 0) {
        this.JPB.setVisibility(8);
      }
      if (!com.tencent.mm.plugin.ipcall.a.c.fSN()) {
        break label1070;
      }
      i = 1;
      if (i != 0) {
        this.JPC.setVisibility(8);
      }
      this.JPJ.setOnClickListener(new IPCallShareCouponUI.9(this));
      this.JPK.setOnClickListener(new IPCallShareCouponUI.10(this));
      this.JPB.setOnClickListener(new IPCallShareCouponUI.11(this));
      this.JPC.setOnClickListener(new IPCallShareCouponUI.12(this));
      this.JPE.setOnClickListener(new IPCallShareCouponUI.13(this));
      this.JPD.setOnClickListener(new IPCallShareCouponUI.14(this));
      this.JPv.setOnClickListener(new IPCallShareCouponUI.15(this));
      this.JPy.setOnClickListener(new IPCallShareCouponUI.2(this));
      this.JPH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25938);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          Intent localIntent = new Intent();
          paramAnonymousView = IPCallShareCouponUI.this.getString(R.l.gKL) + "&usedcc=";
          localObject = com.tencent.mm.plugin.ipcall.model.c.fRb().fRe();
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
              String str = com.tencent.mm.plugin.ipcall.a.a.aJx(((Integer)((List)localObject).get(j)).toString());
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
              for (localObject = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);; localObject = paramAnonymousView + com.tencent.mm.plugin.ipcall.a.a.aJx(com.tencent.mm.plugin.ipcall.a.c.fSL()))
              {
                localIntent.putExtra("rawUrl", (String)localObject);
                localIntent.putExtra("showShare", false);
                com.tencent.mm.br.c.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25938);
                return;
              }
            }
          }
        }
      });
      paramBundle = com.tencent.mm.plugin.ipcall.a.c.fSO();
      if (paramBundle == null) {
        break label1105;
      }
      a(paramBundle);
      refreshView();
      if (!com.tencent.mm.plugin.ipcall.a.c.fSN()) {
        break label1177;
      }
      paramBundle = getString(R.l.gLU);
      localObject1 = getString(R.l.gLT);
      localObject2 = paramBundle + (String)localObject1;
      localObject1 = new IPCallShareCouponUI.5(this);
      localObject2 = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject2);
      i = paramBundle.length();
      int j = ((Spannable)localObject2).length();
      if ((i < 0) || (i >= j) || (j < 0) || (j > ((Spannable)localObject2).length())) {
        break label1155;
      }
      ((Spannable)localObject2).setSpan(localObject1, i, j, 33);
      label889:
      this.JPL.setText((CharSequence)localObject2);
      this.JPL.setMovementMethod(LinkMovementMethod.getInstance());
      this.JPL.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = (LinearLayout)findViewById(R.h.fMw);
      if ((paramBundle != null) && (this.JPv.getVisibility() == 8) && (this.JPy.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (LinearLayout)findViewById(R.h.fMx);
      if ((paramBundle != null) && (this.JPC.getVisibility() == 8) && (this.JPD.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      this.JPR.start();
      AppMethodBeat.o(25954);
      return;
      if (i.aRC().getInt("WCOPurchaseSwitch", 0) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1050;
        }
        i = 1;
        break;
      }
      label1050:
      i = 0;
      break;
      label1055:
      i = 0;
      break label555;
      label1060:
      i = 0;
      break label583;
      label1065:
      i = 0;
      break label589;
      label1070:
      if (i.aRC().getInt("WCOInviteFriend", 0) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1100;
        }
        i = 1;
        break;
      }
      label1100:
      i = 0;
      break label610;
      label1105:
      this.JPQ.setText("0");
      paramBundle = getContext();
      getString(R.l.app_tip);
      this.xZJ = k.a(paramBundle, getString(R.l.gKx), true, new IPCallShareCouponUI.4(this));
      break label775;
      label1155:
      ((Spannable)localObject2).setSpan(localObject1, 0, ((Spannable)localObject2).length(), 33);
      break label889;
      label1177:
      this.JPL.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25956);
    super.onDestroy();
    bh.aZW().b(257, this);
    this.JLG.dead();
    this.JPR.JJf = Util.nowMilliSecond();
    this.JPR.finish();
    AppMethodBeat.o(25956);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25955);
    super.onResume();
    com.tencent.mm.plugin.ipcall.model.g.b.fRS().xL(false);
    AppMethodBeat.o(25955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(25958);
    if ((paramp instanceof g))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(((g)paramp).JIN);
        refreshView();
        if ((this.xZJ != null) && (this.xZJ.isShowing())) {
          this.xZJ.dismiss();
        }
        AppMethodBeat.o(25958);
        return;
      }
      if ((this.xZJ != null) && (this.xZJ.isShowing()))
      {
        this.xZJ.dismiss();
        k.d(getContext(), getString(R.l.gKv), getString(R.l.ip_call_func_name), new IPCallShareCouponUI.7(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI
 * JD-Core Version:    0.7.0.1
 */