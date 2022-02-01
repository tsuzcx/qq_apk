package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
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
import com.tencent.mm.autogen.a.rn;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.g.a.g;
import com.tencent.mm.plugin.exdevice.g.a.h;
import com.tencent.mm.plugin.exdevice.g.a.i;
import com.tencent.mm.plugin.exdevice.g.a.l;
import com.tencent.mm.plugin.exdevice.model.ag;
import com.tencent.mm.plugin.exdevice.model.ag.a;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.gny;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.MMPullDownView.b;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public class ExdeviceProfileUI
  extends MMSecDataActivity
  implements com.tencent.mm.plugin.exdevice.g.b.e
{
  private static int yBq = 0;
  private String mAppName;
  private int mHo;
  private boolean mIsDestroyed;
  private GestureDetector nwZ;
  String sWX;
  private String szP;
  private TextPaint xe;
  private String yAW;
  private String yAX;
  private com.tencent.mm.plugin.exdevice.g.b.a.a yAY;
  private ArrayList<String> yAZ;
  private gny yBa;
  private ExdeviceProfileAffectedUserView yBb;
  private ImageView yBc;
  private ListView yBd;
  private ExdeviceProfileListHeader yBe;
  private a yBf;
  private View yBg;
  private String yBh;
  private String yBi;
  private boolean yBj;
  private boolean yBk;
  private int yBl;
  private com.tencent.mm.plugin.exdevice.b.b<i> yBm;
  private u.i yBn;
  private com.tencent.mm.plugin.exdevice.b.b<h> yBo;
  com.tencent.mm.plugin.exdevice.b.b<g> yBp;
  private Runnable yBr;
  private com.tencent.mm.plugin.exdevice.b.b<g> yBs;
  private List<String> yBt;
  private com.tencent.mm.plugin.exdevice.b.b<l> yBu;
  private l yBv;
  private IListener<rn> yBw;
  private MMPullDownView.a yBx;
  private String ytX;
  private List<String> yuA;
  private List<String> yuB;
  private boolean yui;
  private w yyY;
  
  public ExdeviceProfileUI()
  {
    AppMethodBeat.i(24132);
    this.mIsDestroyed = false;
    this.yyY = null;
    this.yBm = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.xe = new TextPaint(1);
    this.mHo = 0;
    this.yBn = new u.i()
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
          com.tencent.mm.plugin.sport.a.d.rG(27);
          ExdeviceProfileUI.m(ExdeviceProfileUI.this);
          AppMethodBeat.o(24128);
          return;
          com.tencent.mm.plugin.sport.a.d.rG(26);
          ExdeviceProfileUI.n(ExdeviceProfileUI.this);
          AppMethodBeat.o(24128);
          return;
          ExdeviceProfileUI.o(ExdeviceProfileUI.this);
          AppMethodBeat.o(24128);
          return;
          com.tencent.mm.ui.base.k.a(ExdeviceProfileUI.this.getContext(), ExdeviceProfileUI.this.getString(R.l.gHb), null, true, new ExdeviceProfileUI.25.1(this), null);
          AppMethodBeat.o(24128);
          return;
          ExdeviceProfileUI.b(ExdeviceProfileUI.this, true);
          com.tencent.mm.plugin.sport.a.d.rG(10);
          ah.dFZ();
          com.tencent.mm.plugin.exdevice.g.b.c.f("", ExdeviceProfileUI.r(ExdeviceProfileUI.this), ExdeviceProfileUI.p(ExdeviceProfileUI.this), 3);
          AppMethodBeat.o(24128);
          return;
          com.tencent.mm.plugin.sport.a.d.rG(41);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", ExdeviceProfileUI.k(ExdeviceProfileUI.this));
          com.tencent.mm.br.c.b(ExdeviceProfileUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
        }
      }
    };
    this.yBo = new ExdeviceProfileUI.27(this);
    this.yBp = new ExdeviceProfileUI.2(this);
    this.yBr = new ExdeviceProfileUI.14(this);
    this.yBs = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.yBu = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.yBw = new ExdeviceProfileUI.28(this, com.tencent.mm.app.f.hfK);
    this.yBx = new ExdeviceProfileUI.20(this);
    AppMethodBeat.o(24132);
  }
  
  private void dGW()
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
  
  private void dGX()
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
  
  private void dGY()
  {
    AppMethodBeat.i(24140);
    String str = z.bAM();
    if (this.yBg != null) {
      this.yBg.setVisibility(8);
    }
    if ((!Util.isNullOrNil(str)) && (str.equals(this.sWX)))
    {
      if ((this.yAY != null) && (Util.isNullOrNil(this.yAY.field_championUrl)) && (this.yBg != null)) {
        this.yBg.setVisibility(0);
      }
      if (this.yBe != null)
      {
        this.yBe.setOnClickListener(new ExdeviceProfileUI.11(this));
        AppMethodBeat.o(24140);
      }
    }
    else if ((this.yAY != null) && (!Util.isNullOrNil(this.yAY.field_championUrl)) && (this.yBe != null))
    {
      this.yBe.setOnClickListener(new ExdeviceProfileUI.13(this));
    }
    AppMethodBeat.o(24140);
  }
  
  private void dGZ()
  {
    AppMethodBeat.i(24141);
    if (this.yAY != null)
    {
      if ((this.szP != this.yAY.field_championUrl) && ((this.szP == null) || (!this.szP.equals(this.yAY.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.yBc, this.yAY.field_championUrl, R.e.darkgrey);
        this.szP = this.yAY.field_championUrl;
        AppMethodBeat.o(24141);
      }
    }
    else
    {
      this.yBc.setImageResource(R.e.darkgrey);
      this.szP = null;
    }
    AppMethodBeat.o(24141);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.exdevice.g.b.d paramd)
  {
    AppMethodBeat.i(24143);
    if (("HardDeviceChampionInfo".equals(paramString)) && (this.sWX.equals(paramd.username)))
    {
      Log.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
      this.yAY = ah.dFV().apE(this.sWX);
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
  
  public int getLayoutId()
  {
    return R.i.gjA;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(274783);
    HashSet localHashSet = new HashSet(super.importUIComponents());
    localHashSet.add(e.class);
    AppMethodBeat.o(274783);
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
            str2 = ag.gc(this);
            if ((str1 != null) && (str1.length() != 0)) {
              break;
            }
            Log.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
            AppMethodBeat.o(24142);
            return;
          }
          ag.a(this, str1, str2, paramIntent.getStringExtra("custom_send_text"), this.yBi);
          com.tencent.mm.ui.base.k.cZ(getContext(), getResources().getString(R.l.app_shared));
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
            if (this.yyY != null) {
              this.yyY.show();
            }
            bh.aZW().a(new g(paramIntent, this.yBs), 0);
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
    this.yAW = paramBundle.getStringExtra("rank_id");
    this.sWX = paramBundle.getStringExtra("username");
    this.yAX = paramBundle.getStringExtra("usernickname");
    paramBundle = z.bAM();
    if (paramBundle != null) {
      this.yBk = paramBundle.equals(this.sWX);
    }
    this.mAppName = getIntent().getStringExtra("app_username");
    this.yBj = ah.dFT().apC(this.sWX);
    Log.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", new Object[] { Boolean.valueOf(this.yBj) });
    boolean bool;
    int m;
    Object localObject2;
    if (!Util.isNullOrNil(this.sWX))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.yAY = ah.dFV().apE(this.sWX);
      this.yAZ = getIntent().getStringArrayListExtra("key_affected_semi");
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((e)com.tencent.mm.ui.component.k.d(this).q(e.class)).yuk = this.yAW;
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((e)com.tencent.mm.ui.component.k.d(this).q(e.class)).appName = this.mAppName;
      getString(R.l.app_tip);
      this.yyY = com.tencent.mm.ui.base.k.b(this, getString(R.l.loading_tips), true, new ExdeviceProfileUI.4(this));
      this.yBb = ((ExdeviceProfileAffectedUserView)findViewById(R.h.fGU));
      this.yBc = ((ImageView)findViewById(R.h.fGX));
      this.yBd = ((ListView)findViewById(R.h.fHi));
      paramBundle = (MMPullDownView)findViewById(R.h.pull_down_view);
      this.yBb.setAffectedUserInfo(this.yAZ);
      dGZ();
      this.yBg = findViewById(R.h.fVW);
      this.nwZ = new GestureDetector(getContext(), new ExdeviceProfileUI.a(this, (byte)0));
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setTopViewVisible(false);
      paramBundle.setBottomViewVisible(false);
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setIsTopShowAll(false);
      paramBundle.setCanOverScrool(true);
      paramBundle.setOnInterceptTouchEventListener(this.yBx);
      paramBundle.setAtBottomCallBack(new ExdeviceProfileUI.5(this));
      paramBundle.setAtTopCallBack(new ExdeviceProfileUI.6(this));
      paramBundle.setOnBottomLoadDataListener(new ExdeviceProfileUI.7(this));
      paramBundle.setOnScrollChangedListener(new MMPullDownView.b()
      {
        public final void dHa()
        {
          AppMethodBeat.i(24101);
          ExdeviceProfileUI.v(ExdeviceProfileUI.this);
          AppMethodBeat.o(24101);
        }
      });
      localObject1 = new ExdeviceProfileListHeader(this);
      m = com.tencent.mm.plugin.exdevice.k.b.I(this, getResources().getDimensionPixelSize(R.f.fli));
      localObject2 = getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject2).widthPixels <= ((DisplayMetrics)localObject2).heightPixels) {
        break label932;
      }
    }
    label932:
    for (int i = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);; i = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort))
    {
      j = getResources().getDimensionPixelSize(R.f.flk);
      int k = getResources().getDimensionPixelSize(R.f.flj);
      localObject2 = getWindowManager().getDefaultDisplay();
      k = ((Display)localObject2).getHeight() / 2 - m - i - j / 2 - k;
      if (((Display)localObject2).getHeight() > 0)
      {
        j = k;
        if (k > 0) {}
      }
      else
      {
        j = getResources().getDimensionPixelSize(R.f.flh);
      }
      ((ExdeviceProfileListHeader)localObject1).setMinimumHeight(j);
      ((ExdeviceProfileListHeader)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceProfileListHeader)localObject1).setTag(Integer.valueOf(((Display)localObject2).getHeight() / 2 - m - i));
      this.yBe = ((ExdeviceProfileListHeader)localObject1);
      this.yBd.addHeaderView(this.yBe, null, false);
      this.yBf = new a(getContext(), this.sWX);
      this.yBd.setAdapter(this.yBf);
      this.yBd.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(24102);
          ExdeviceProfileUI.v(ExdeviceProfileUI.this);
          AppMethodBeat.o(24102);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.yBb.setUsername(this.sWX);
      this.yBg.setOnClickListener(new ExdeviceProfileUI.10(this));
      paramBundle.setCanOverScrool(false);
      paramBundle = new RelativeLayout.LayoutParams(com.tencent.mm.cd.a.ms(this), ((Integer)this.yBe.getTag()).intValue());
      this.yBc.setLayoutParams(paramBundle);
      dGY();
      ah.dGa().a(this);
      bh.aZW().a(new i(this, this.sWX, Util.nullAsNil(this.mAppName), this.yBm), 0);
      try
      {
        this.mHo = getResources().getDimensionPixelSize(R.f.flo);
        if (this.mHo <= 0) {
          this.mHo = 60;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", paramBundle, "", new Object[0]);
          if (this.mHo <= 0) {
            this.mHo = 60;
          }
        }
      }
      finally
      {
        if (this.mHo > 0) {
          break label991;
        }
        this.mHo = 60;
        AppMethodBeat.o(24133);
      }
      Log.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[] { Integer.valueOf(this.mHo) });
      if (!this.yBk) {
        break label999;
      }
      paramBundle = getString(R.l.gGH);
      setMMTitle(paramBundle);
      setBackBtn(new ExdeviceProfileUI.24(this));
      Log.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.sWX);
      if (z.bAM().equals(this.sWX)) {
        ((com.tencent.mm.plugin.sport.a.c)MvvmEventCenter.getEvent(com.tencent.mm.plugin.sport.a.c.class)).publish(Integer.valueOf(3));
      }
      AppMethodBeat.o(24133);
      return;
      bool = false;
      break;
    }
    label991:
    label999:
    i = R.l.gGK;
    paramBundle = this.sWX;
    int j = this.mHo;
    Object localObject1 = aa.getDisplayName(paramBundle);
    if ((paramBundle.equalsIgnoreCase((String)localObject1)) && (!Util.isNullOrNil(this.yAX))) {}
    for (paramBundle = p.b(getContext(), this.yAX);; paramBundle = p.b(getContext(), (CharSequence)localObject1))
    {
      localObject1 = TextUtils.ellipsize(paramBundle, this.xe, j, TextUtils.TruncateAt.END);
      Log.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[] { Integer.valueOf(j), paramBundle, localObject1 });
      paramBundle = p.b(this, getString(i, new Object[] { localObject1 }));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24139);
    if (this.yBv != null) {
      bh.aZW().a(this.yBv);
    }
    this.yBw.dead();
    this.mIsDestroyed = true;
    super.onDestroy();
    ah.dGa().b(this);
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
    dGW();
    if (!this.yBk)
    {
      ah.dFT().apC(this.sWX);
      dGX();
    }
    AppMethodBeat.o(24137);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */