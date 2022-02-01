package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.qa;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.g.a.i;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ad.a;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.protocal.protobuf.fqo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.event.LifecycleEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public class ExdeviceProfileUI
  extends MMSecDataActivity
  implements com.tencent.mm.plugin.exdevice.g.b.e
{
  private static int voU = 0;
  private int kgV;
  private String mAppName;
  private GestureDetector mBn;
  private boolean mIsDestroyed;
  private String pRV;
  private String puJ;
  private String vhW;
  private List<String> viB;
  private List<String> viC;
  private boolean vij;
  private s vmw;
  private String voA;
  private String voB;
  private com.tencent.mm.plugin.exdevice.g.b.a.a voC;
  private ArrayList<String> voD;
  private fqo voE;
  private ExdeviceProfileAffectedUserView voF;
  private ImageView voG;
  private ListView voH;
  private ExdeviceProfileListHeader voI;
  private a voJ;
  private View voK;
  private String voL;
  private String voM;
  private boolean voN;
  private boolean voO;
  private int voP;
  private com.tencent.mm.plugin.exdevice.b.b<i> voQ;
  private q.g voR;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.h> voS;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.g> voT;
  private Runnable voV;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.g> voW;
  private List<String> voX;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.l> voY;
  private com.tencent.mm.plugin.exdevice.g.a.l voZ;
  private IListener<qa> vpa;
  private MMPullDownView.a vpb;
  private TextPaint wi;
  
  public ExdeviceProfileUI()
  {
    AppMethodBeat.i(24132);
    this.mIsDestroyed = false;
    this.vmw = null;
    this.voQ = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.wi = new TextPaint(1);
    this.kgV = 0;
    this.voR = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(24128);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(24128);
          return;
          com.tencent.mm.plugin.sport.a.d.rE(27);
          ExdeviceProfileUI.m(ExdeviceProfileUI.this);
          AppMethodBeat.o(24128);
          return;
          com.tencent.mm.plugin.sport.a.d.rE(26);
          ExdeviceProfileUI.n(ExdeviceProfileUI.this);
          AppMethodBeat.o(24128);
          return;
          ExdeviceProfileUI.o(ExdeviceProfileUI.this);
          AppMethodBeat.o(24128);
          return;
          com.tencent.mm.ui.base.h.a(ExdeviceProfileUI.this.getContext(), ExdeviceProfileUI.this.getString(R.l.eEk), null, true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(24127);
              bh.beI();
              paramAnonymous2DialogInterface = com.tencent.mm.model.c.bbL().RG(ExdeviceProfileUI.p(ExdeviceProfileUI.this));
              com.tencent.mm.plugin.sport.a.d.rE(37);
              ab.r(paramAnonymous2DialogInterface);
              ExdeviceProfileUI.q(ExdeviceProfileUI.this).alive();
              if (ExdeviceProfileUI.c(ExdeviceProfileUI.this) != null) {
                ExdeviceProfileUI.c(ExdeviceProfileUI.this).show();
              }
              AppMethodBeat.o(24127);
            }
          }, null);
          AppMethodBeat.o(24128);
          return;
          ExdeviceProfileUI.b(ExdeviceProfileUI.this, true);
          com.tencent.mm.plugin.sport.a.d.rE(10);
          ae.cZG();
          com.tencent.mm.plugin.exdevice.g.b.c.c("", ExdeviceProfileUI.r(ExdeviceProfileUI.this), ExdeviceProfileUI.p(ExdeviceProfileUI.this), 3);
          AppMethodBeat.o(24128);
          return;
          com.tencent.mm.plugin.sport.a.d.rE(41);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", ExdeviceProfileUI.k(ExdeviceProfileUI.this));
          com.tencent.mm.by.c.b(ExdeviceProfileUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
        }
      }
    };
    this.voS = new ExdeviceProfileUI.28(this);
    this.voT = new ExdeviceProfileUI.2(this);
    this.voV = new ExdeviceProfileUI.14(this);
    this.voW = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.voY = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.vpa = new ExdeviceProfileUI.20(this);
    this.vpb = new ExdeviceProfileUI.21(this);
    AppMethodBeat.o(24132);
  }
  
  private void daB()
  {
    AppMethodBeat.i(24135);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24125);
        ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
        AppMethodBeat.o(24125);
      }
    });
    AppMethodBeat.o(24135);
  }
  
  private void daD()
  {
    AppMethodBeat.i(24138);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24097);
        ExdeviceProfileUI.f(ExdeviceProfileUI.this);
        ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
        AppMethodBeat.o(24097);
      }
    });
    AppMethodBeat.o(24138);
  }
  
  private void daE()
  {
    AppMethodBeat.i(24140);
    String str = z.bcZ();
    if (this.voK != null) {
      this.voK.setVisibility(8);
    }
    if ((!Util.isNullOrNil(str)) && (str.equals(this.pRV)))
    {
      if ((this.voC != null) && (Util.isNullOrNil(this.voC.field_championUrl)) && (this.voK != null)) {
        this.voK.setVisibility(0);
      }
      if (this.voI != null)
      {
        this.voI.setOnClickListener(new ExdeviceProfileUI.11(this));
        AppMethodBeat.o(24140);
      }
    }
    else if ((this.voC != null) && (!Util.isNullOrNil(this.voC.field_championUrl)) && (this.voI != null))
    {
      this.voI.setOnClickListener(new ExdeviceProfileUI.13(this));
    }
    AppMethodBeat.o(24140);
  }
  
  private void daF()
  {
    AppMethodBeat.i(24141);
    if (this.voC != null)
    {
      if ((this.puJ != this.voC.field_championUrl) && ((this.puJ == null) || (!this.puJ.equals(this.voC.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.voG, this.voC.field_championUrl, R.e.darkgrey);
        this.puJ = this.voC.field_championUrl;
        AppMethodBeat.o(24141);
      }
    }
    else
    {
      this.voG.setImageResource(R.e.darkgrey);
      this.puJ = null;
    }
    AppMethodBeat.o(24141);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.g.b.d paramd)
  {
    AppMethodBeat.i(24143);
    if (("HardDeviceChampionInfo".equals(paramString)) && (this.pRV.equals(paramd.username)))
    {
      Log.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
      this.voC = ae.cZC().avE(this.pRV);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24111);
          ExdeviceProfileUI.x(ExdeviceProfileUI.this);
          ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
          ExdeviceProfileUI.y(ExdeviceProfileUI.this);
          AppMethodBeat.o(24111);
        }
      });
    }
    AppMethodBeat.o(24143);
  }
  
  public final void daC()
  {
    AppMethodBeat.i(266529);
    com.tencent.mm.plugin.sport.a.d.rE(17);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.pRV);
    bh.aGY().a(new com.tencent.mm.plugin.exdevice.g.a.g(localArrayList, this.voT), 0);
    AppMethodBeat.o(266529);
  }
  
  public int getLayoutId()
  {
    return R.i.egE;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(266535);
    HashSet localHashSet = new HashSet(super.importUIComponents());
    localHashSet.add(e.class);
    AppMethodBeat.o(266535);
    return localHashSet;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24142);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (com.tencent.mm.plugin.exdevice.g.a.e.a(this, paramInt1, paramInt2, paramIntent, this.mAppName))
    {
      AppMethodBeat.o(24142);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24142);
      return;
      if (paramInt2 == -1)
      {
        Toast.makeText(this, R.l.share_ok, 1).show();
        AppMethodBeat.o(24142);
        return;
        if (paramInt2 == -1)
        {
          if (paramIntent == null) {}
          String str2;
          for (String str1 = null;; str1 = paramIntent.getStringExtra("Select_Conv_User"))
          {
            str2 = ad.ff(this);
            if ((str1 != null) && (str1.length() != 0)) {
              break;
            }
            Log.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
            AppMethodBeat.o(24142);
            return;
          }
          ad.a(this, str1, str2, paramIntent.getStringExtra("custom_send_text"), this.voM);
          com.tencent.mm.ui.base.h.cO(getContext(), getResources().getString(R.l.app_shared));
          AppMethodBeat.o(24142);
          return;
          if (paramInt2 == -1)
          {
            paramIntent = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
            if (paramIntent == null)
            {
              AppMethodBeat.o(24142);
              return;
            }
            if (this.vmw != null) {
              this.vmw.show();
            }
            bh.aGY().a(new com.tencent.mm.plugin.exdevice.g.a.g(paramIntent, this.voW), 0);
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24133);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.voA = paramBundle.getStringExtra("rank_id");
    this.pRV = paramBundle.getStringExtra("username");
    this.voB = paramBundle.getStringExtra("usernickname");
    paramBundle = z.bcZ();
    if (paramBundle != null) {
      this.voO = paramBundle.equals(this.pRV);
    }
    this.mAppName = getIntent().getStringExtra("app_username");
    this.voN = ae.cZA().avC(this.pRV);
    Log.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", new Object[] { Boolean.valueOf(this.voN) });
    boolean bool;
    int m;
    Object localObject2;
    if (!Util.isNullOrNil(this.pRV))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.voC = ae.cZC().avE(this.pRV);
      this.voD = getIntent().getStringArrayListExtra("key_affected_semi");
      paramBundle = com.tencent.mm.ui.component.g.Xox;
      ((e)com.tencent.mm.ui.component.g.b(this).i(e.class)).vil = this.voA;
      paramBundle = com.tencent.mm.ui.component.g.Xox;
      ((e)com.tencent.mm.ui.component.g.b(this).i(e.class)).appName = this.mAppName;
      getString(R.l.app_tip);
      this.vmw = com.tencent.mm.ui.base.h.b(this, getString(R.l.loading_tips), true, new ExdeviceProfileUI.4(this));
      this.voF = ((ExdeviceProfileAffectedUserView)findViewById(R.h.dFO));
      this.voG = ((ImageView)findViewById(R.h.dFR));
      this.voH = ((ListView)findViewById(R.h.dGc));
      paramBundle = (MMPullDownView)findViewById(R.h.dRF);
      this.voF.setAffectedUserInfo(this.voD);
      daF();
      this.voK = findViewById(R.h.dTO);
      this.mBn = new GestureDetector(getContext(), new ExdeviceProfileUI.a(this, (byte)0));
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setTopViewVisible(false);
      paramBundle.setBottomViewVisible(false);
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setIsTopShowAll(false);
      paramBundle.setCanOverScrool(true);
      paramBundle.setOnInterceptTouchEventListener(this.vpb);
      paramBundle.setAtBottomCallBack(new ExdeviceProfileUI.5(this));
      paramBundle.setAtTopCallBack(new ExdeviceProfileUI.6(this));
      paramBundle.setOnBottomLoadDataListener(new MMPullDownView.e()
      {
        public final boolean cOJ()
        {
          return true;
        }
      });
      paramBundle.setOnScrollChangedListener(new ExdeviceProfileUI.8(this));
      localObject1 = new ExdeviceProfileListHeader(this);
      m = com.tencent.mm.plugin.exdevice.k.b.F(this, getResources().getDimensionPixelSize(R.f.dkS));
      localObject2 = getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject2).widthPixels <= ((DisplayMetrics)localObject2).heightPixels) {
        break label932;
      }
    }
    label932:
    for (int i = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);; i = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort))
    {
      j = getResources().getDimensionPixelSize(R.f.dkU);
      int k = getResources().getDimensionPixelSize(R.f.dkT);
      localObject2 = getWindowManager().getDefaultDisplay();
      k = ((Display)localObject2).getHeight() / 2 - m - i - j / 2 - k;
      if (((Display)localObject2).getHeight() > 0)
      {
        j = k;
        if (k > 0) {}
      }
      else
      {
        j = getResources().getDimensionPixelSize(R.f.dkR);
      }
      ((ExdeviceProfileListHeader)localObject1).setMinimumHeight(j);
      ((ExdeviceProfileListHeader)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceProfileListHeader)localObject1).setTag(Integer.valueOf(((Display)localObject2).getHeight() / 2 - m - i));
      this.voI = ((ExdeviceProfileListHeader)localObject1);
      this.voH.addHeaderView(this.voI, null, false);
      this.voJ = new a(getContext(), this.pRV);
      this.voH.setAdapter(this.voJ);
      this.voH.setOnScrollListener(new ExdeviceProfileUI.9(this));
      this.voF.setUsername(this.pRV);
      this.voK.setOnClickListener(new ExdeviceProfileUI.10(this));
      paramBundle.setCanOverScrool(false);
      paramBundle = new RelativeLayout.LayoutParams(com.tencent.mm.ci.a.kr(this), ((Integer)this.voI.getTag()).intValue());
      this.voG.setLayoutParams(paramBundle);
      daE();
      ae.cZH().a(this);
      bh.aGY().a(new i(this, this.pRV, Util.nullAsNil(this.mAppName), this.voQ), 0);
      try
      {
        this.kgV = getResources().getDimensionPixelSize(R.f.dkY);
        if (this.kgV <= 0) {
          this.kgV = 60;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", paramBundle, "", new Object[0]);
          if (this.kgV <= 0) {
            this.kgV = 60;
          }
        }
      }
      finally
      {
        if (this.kgV > 0) {
          break label991;
        }
        this.kgV = 60;
        AppMethodBeat.o(24133);
      }
      Log.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[] { Integer.valueOf(this.kgV) });
      if (!this.voO) {
        break label999;
      }
      paramBundle = getString(R.l.eDT);
      setMMTitle(paramBundle);
      setBackBtn(new ExdeviceProfileUI.25(this));
      Log.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.pRV);
      if (z.bcZ().equals(this.pRV)) {
        ((com.tencent.mm.plugin.sport.a.c)LifecycleEventCenter.getEvent(com.tencent.mm.plugin.sport.a.c.class)).publish(Integer.valueOf(3));
      }
      AppMethodBeat.o(24133);
      return;
      bool = false;
      break;
    }
    label991:
    label999:
    i = R.l.eDW;
    paramBundle = this.pRV;
    int j = this.kgV;
    Object localObject1 = aa.PJ(paramBundle);
    if ((paramBundle.equalsIgnoreCase((String)localObject1)) && (!Util.isNullOrNil(this.voB))) {}
    for (paramBundle = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), this.voB);; paramBundle = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)localObject1))
    {
      localObject1 = TextUtils.ellipsize(paramBundle, this.wi, j, TextUtils.TruncateAt.END);
      Log.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[] { Integer.valueOf(j), paramBundle, localObject1 });
      paramBundle = com.tencent.mm.pluginsdk.ui.span.l.c(this, getString(i, new Object[] { localObject1 }));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24139);
    if (this.voZ != null) {
      bh.aGY().a(this.voZ);
    }
    this.vpa.dead();
    this.mIsDestroyed = true;
    super.onDestroy();
    ae.cZH().b(this);
    AppMethodBeat.o(24139);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(24136);
    super.onPause();
    AppMethodBeat.o(24136);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24137);
    super.onResume();
    Log.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
    daB();
    if (!this.voO)
    {
      ae.cZA().avC(this.pRV);
      daD();
    }
    AppMethodBeat.o(24137);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */