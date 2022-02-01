package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.g.a.g;
import com.tencent.mm.plugin.exdevice.g.b.d;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.ffn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.a;
import com.tencent.mm.ui.base.MMPullDownView.b;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import junit.framework.Assert;

public class ExdeviceProfileUI
  extends MMSecDataActivity
  implements com.tencent.mm.plugin.exdevice.g.b.e
{
  private static int rJm = 0;
  private TextPaint ayn;
  private int huY;
  private GestureDetector jKk;
  private String mAppName;
  private boolean mIsDestroyed;
  private String mRa;
  private String mwj;
  private List<String> rCR;
  private List<String> rCS;
  private String rCo;
  private boolean rCz;
  private q rGN;
  private String rIS;
  private String rIT;
  private com.tencent.mm.plugin.exdevice.g.b.a.a rIU;
  private ArrayList<String> rIV;
  private ffn rIW;
  private ExdeviceProfileAffectedUserView rIX;
  private ImageView rIY;
  private ListView rIZ;
  private ExdeviceProfileListHeader rJa;
  private a rJb;
  private View rJc;
  private String rJd;
  private String rJe;
  private boolean rJf;
  private boolean rJg;
  private int rJh;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.i> rJi;
  private o.g rJj;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.h> rJk;
  private com.tencent.mm.plugin.exdevice.b.b<g> rJl;
  private Runnable rJn;
  private com.tencent.mm.plugin.exdevice.b.b<g> rJo;
  private List<String> rJp;
  private com.tencent.mm.plugin.exdevice.b.b<com.tencent.mm.plugin.exdevice.g.a.l> rJq;
  private com.tencent.mm.plugin.exdevice.g.a.l rJr;
  private IListener<pd> rJs;
  private MMPullDownView.a rJt;
  
  public ExdeviceProfileUI()
  {
    AppMethodBeat.i(24132);
    this.mIsDestroyed = false;
    this.rGN = null;
    this.rJi = new com.tencent.mm.plugin.exdevice.b.b() {};
    this.ayn = new TextPaint(1);
    this.huY = 0;
    this.rJj = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(179628);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.plugin.sport.a.c.pl(27);
          ExdeviceProfileUI.m(ExdeviceProfileUI.this);
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.plugin.sport.a.c.pl(26);
          ExdeviceProfileUI.n(ExdeviceProfileUI.this);
          AppMethodBeat.o(179628);
          return;
          ExdeviceProfileUI.o(ExdeviceProfileUI.this);
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.ui.base.h.a(ExdeviceProfileUI.this.getContext(), ExdeviceProfileUI.this.getString(2131758925), null, true, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(179627);
              bg.aVF();
              paramAnonymous2DialogInterface = com.tencent.mm.model.c.aSN().Kn(ExdeviceProfileUI.p(ExdeviceProfileUI.this));
              com.tencent.mm.plugin.sport.a.c.pl(37);
              ab.r(paramAnonymous2DialogInterface);
              ExdeviceProfileUI.q(ExdeviceProfileUI.this).alive();
              if (ExdeviceProfileUI.c(ExdeviceProfileUI.this) != null) {
                ExdeviceProfileUI.c(ExdeviceProfileUI.this).show();
              }
              AppMethodBeat.o(179627);
            }
          }, null);
          AppMethodBeat.o(179628);
          return;
          ExdeviceProfileUI.b(ExdeviceProfileUI.this, true);
          com.tencent.mm.plugin.sport.a.c.pl(10);
          ad.cKT();
          com.tencent.mm.plugin.exdevice.g.b.c.c("", ExdeviceProfileUI.r(ExdeviceProfileUI.this), ExdeviceProfileUI.p(ExdeviceProfileUI.this), 3);
          AppMethodBeat.o(179628);
          return;
          com.tencent.mm.plugin.sport.a.c.pl(41);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("rawUrl", ExdeviceProfileUI.k(ExdeviceProfileUI.this));
          com.tencent.mm.br.c.b(ExdeviceProfileUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
        }
      }
    };
    this.rJk = new ExdeviceProfileUI.2(this);
    this.rJl = new ExdeviceProfileUI.3(this);
    this.rJn = new ExdeviceProfileUI.15(this);
    this.rJo = new ExdeviceProfileUI.16(this);
    this.rJq = new ExdeviceProfileUI.18(this);
    this.rJs = new ExdeviceProfileUI.21(this);
    this.rJt = new ExdeviceProfileUI.23(this);
    AppMethodBeat.o(24132);
  }
  
  private void cLO()
  {
    AppMethodBeat.i(24135);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179617);
        ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
        AppMethodBeat.o(179617);
      }
    });
    AppMethodBeat.o(24135);
  }
  
  private void cLQ()
  {
    AppMethodBeat.i(24138);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179603);
        ExdeviceProfileUI.f(ExdeviceProfileUI.this);
        ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
        AppMethodBeat.o(179603);
      }
    });
    AppMethodBeat.o(24138);
  }
  
  private void cLR()
  {
    AppMethodBeat.i(24140);
    String str = z.aTY();
    if (this.rJc != null) {
      this.rJc.setVisibility(8);
    }
    if ((!Util.isNullOrNil(str)) && (str.equals(this.mRa)))
    {
      if ((this.rIU != null) && (Util.isNullOrNil(this.rIU.field_championUrl)) && (this.rJc != null)) {
        this.rJc.setVisibility(0);
      }
      if (this.rJa != null)
      {
        this.rJa.setOnClickListener(new ExdeviceProfileUI.13(this));
        AppMethodBeat.o(24140);
      }
    }
    else if ((this.rIU != null) && (!Util.isNullOrNil(this.rIU.field_championUrl)) && (this.rJa != null))
    {
      this.rJa.setOnClickListener(new ExdeviceProfileUI.14(this));
    }
    AppMethodBeat.o(24140);
  }
  
  private void cLS()
  {
    AppMethodBeat.i(24141);
    if (this.rIU != null)
    {
      if ((this.mwj != this.rIU.field_championUrl) && ((this.mwj == null) || (!this.mwj.equals(this.rIU.field_championUrl))))
      {
        com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.rIY, this.rIU.field_championUrl);
        this.mwj = this.rIU.field_championUrl;
        AppMethodBeat.o(24141);
      }
    }
    else
    {
      this.rIY.setImageResource(2131100237);
      this.mwj = null;
    }
    AppMethodBeat.o(24141);
  }
  
  public final void b(String paramString, d paramd)
  {
    AppMethodBeat.i(24143);
    if (("HardDeviceChampionInfo".equals(paramString)) && (this.mRa.equals(paramd.username)))
    {
      Log.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
      this.rIU = ad.cKP().anF(this.mRa);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179614);
          ExdeviceProfileUI.x(ExdeviceProfileUI.this);
          ExdeviceProfileUI.l(ExdeviceProfileUI.this).notifyDataSetChanged();
          ExdeviceProfileUI.y(ExdeviceProfileUI.this);
          AppMethodBeat.o(179614);
        }
      });
    }
    AppMethodBeat.o(24143);
  }
  
  public final void cLP()
  {
    AppMethodBeat.i(231703);
    com.tencent.mm.plugin.sport.a.c.pl(17);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mRa);
    bg.azz().a(new g(localArrayList, this.rJl), 0);
    AppMethodBeat.o(231703);
  }
  
  public int getLayoutId()
  {
    return 2131494035;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(231704);
    HashSet localHashSet = new HashSet(super.importUIComponents());
    localHashSet.add(SportProfileUIC.class);
    AppMethodBeat.o(231704);
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
        Toast.makeText(this, 2131765834, 1).show();
        AppMethodBeat.o(24142);
        return;
        if (paramInt2 == -1)
        {
          if (paramIntent == null) {}
          String str2;
          for (String str1 = null;; str1 = paramIntent.getStringExtra("Select_Conv_User"))
          {
            str2 = ac.fb(this);
            if ((str1 != null) && (str1.length() != 0)) {
              break;
            }
            Log.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
            AppMethodBeat.o(24142);
            return;
          }
          ac.a(this, str1, str2, paramIntent.getStringExtra("custom_send_text"), this.rJe);
          com.tencent.mm.ui.base.h.cD(getContext(), getResources().getString(2131755986));
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
            if (this.rGN != null) {
              this.rGN.show();
            }
            bg.azz().a(new g(paramIntent, this.rJo), 0);
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
    this.rIS = paramBundle.getStringExtra("rank_id");
    this.mRa = paramBundle.getStringExtra("username");
    this.rIT = paramBundle.getStringExtra("usernickname");
    paramBundle = z.aTY();
    if (paramBundle != null) {
      this.rJg = paramBundle.equals(this.mRa);
    }
    this.mAppName = getIntent().getStringExtra("app_username");
    this.rJf = ad.cKN().anD(this.mRa);
    Log.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", new Object[] { Boolean.valueOf(this.rJf) });
    boolean bool;
    int m;
    Object localObject2;
    if (!Util.isNullOrNil(this.mRa))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.rIU = ad.cKP().anF(this.mRa);
      this.rIV = getIntent().getStringArrayListExtra("key_affected_semi");
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      ((SportProfileUIC)com.tencent.mm.ui.component.a.b(this).get(SportProfileUIC.class)).rCB = this.rIS;
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      ((SportProfileUIC)com.tencent.mm.ui.component.a.b(this).get(SportProfileUIC.class)).appName = this.mAppName;
      getString(2131755998);
      this.rGN = com.tencent.mm.ui.base.h.b(this, getString(2131762446), true, new ExdeviceProfileUI.5(this));
      this.rIX = ((ExdeviceProfileAffectedUserView)findViewById(2131300190));
      this.rIY = ((ImageView)findViewById(2131300193));
      this.rIZ = ((ListView)findViewById(2131300214));
      paramBundle = (MMPullDownView)findViewById(2131306315);
      this.rIX.setAffectedUserInfo(this.rIV);
      cLS();
      this.rJc = findViewById(2131307646);
      this.jKk = new GestureDetector(getContext(), new ExdeviceProfileUI.a(this, (byte)0));
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setTopViewVisible(false);
      paramBundle.setBottomViewVisible(false);
      paramBundle.setIsBottomShowAll(false);
      paramBundle.setIsTopShowAll(false);
      paramBundle.setCanOverScrool(true);
      paramBundle.setOnInterceptTouchEventListener(this.rJt);
      paramBundle.setAtBottomCallBack(new ExdeviceProfileUI.6(this));
      paramBundle.setAtTopCallBack(new ExdeviceProfileUI.7(this));
      paramBundle.setOnBottomLoadDataListener(new ExdeviceProfileUI.8(this));
      paramBundle.setOnScrollChangedListener(new MMPullDownView.b()
      {
        public final void cLT()
        {
          AppMethodBeat.i(179607);
          ExdeviceProfileUI.v(ExdeviceProfileUI.this);
          AppMethodBeat.o(179607);
        }
      });
      localObject1 = new ExdeviceProfileListHeader(this);
      m = com.tencent.mm.plugin.exdevice.k.b.D(this, getResources().getDimensionPixelSize(2131165327));
      localObject2 = getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject2).widthPixels <= ((DisplayMetrics)localObject2).heightPixels) {
        break label947;
      }
    }
    label947:
    for (int i = getResources().getDimensionPixelSize(2131165255);; i = getResources().getDimensionPixelSize(2131165256))
    {
      int j = getResources().getDimensionPixelSize(2131165337);
      int k = getResources().getDimensionPixelSize(2131165336);
      localObject2 = getWindowManager().getDefaultDisplay();
      k = ((Display)localObject2).getHeight() / 2 - m - i - j / 2 - k;
      if (((Display)localObject2).getHeight() > 0)
      {
        j = k;
        if (k > 0) {}
      }
      else
      {
        j = getResources().getDimensionPixelSize(2131165321);
      }
      ((ExdeviceProfileListHeader)localObject1).setMinimumHeight(j);
      ((ExdeviceProfileListHeader)localObject1).setMinimumWidth(((Display)localObject2).getWidth());
      ((ExdeviceProfileListHeader)localObject1).setTag(Integer.valueOf(((Display)localObject2).getHeight() / 2 - m - i));
      this.rJa = ((ExdeviceProfileListHeader)localObject1);
      this.rIZ.addHeaderView(this.rJa, null, false);
      this.rJb = new a(getContext(), this.mRa);
      this.rIZ.setAdapter(this.rJb);
      this.rIZ.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(179608);
          ExdeviceProfileUI.v(ExdeviceProfileUI.this);
          AppMethodBeat.o(179608);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.rIX.setUsername(this.mRa);
      this.rJc.setOnClickListener(new ExdeviceProfileUI.11(this));
      paramBundle.setCanOverScrool(false);
      paramBundle = new RelativeLayout.LayoutParams(com.tencent.mm.cb.a.jn(this), ((Integer)this.rJa.getTag()).intValue());
      this.rIY.setLayoutParams(paramBundle);
      cLR();
      ad.cKU().a(this);
      bg.azz().a(new com.tencent.mm.plugin.exdevice.g.a.i(this, this.mRa, Util.nullAsNil(this.mAppName), this.rJi), 0);
      try
      {
        this.huY = getResources().getDimensionPixelSize(2131165346);
        if (this.huY <= 0) {
          this.huY = 60;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", paramBundle, "", new Object[0]);
          if (this.huY <= 0) {
            this.huY = 60;
          }
        }
      }
      finally
      {
        if (this.huY > 0) {
          break label1006;
        }
        this.huY = 60;
        AppMethodBeat.o(24133);
      }
      Log.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[] { Integer.valueOf(this.huY) });
      if (!this.rJg) {
        break label1014;
      }
      paramBundle = getString(2131758881);
      setMMTitle(paramBundle);
      setBackBtn(new ExdeviceProfileUI.27(this));
      Log.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.mRa);
      if (z.aTY().equals(this.mRa))
      {
        paramBundle = new wp();
        paramBundle.ecH.action = 3;
        EventCenter.instance.asyncPublish(paramBundle, new Executor()
        {
          public final void execute(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(179609);
            com.tencent.f.h.RTc.aX(paramAnonymousRunnable);
            AppMethodBeat.o(179609);
          }
        });
      }
      AppMethodBeat.o(24133);
      return;
      bool = false;
      break;
    }
    label1006:
    label1014:
    paramBundle = this.mRa;
    i = this.huY;
    Object localObject1 = aa.getDisplayName(paramBundle);
    if ((paramBundle.equalsIgnoreCase((String)localObject1)) && (!Util.isNullOrNil(this.rIT))) {}
    for (paramBundle = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), this.rIT);; paramBundle = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)localObject1))
    {
      localObject1 = TextUtils.ellipsize(paramBundle, this.ayn, i, TextUtils.TruncateAt.END);
      Log.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[] { Integer.valueOf(i), paramBundle, localObject1 });
      paramBundle = com.tencent.mm.pluginsdk.ui.span.l.c(this, getString(2131758885, new Object[] { localObject1 }));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24139);
    if (this.rJr != null) {
      bg.azz().a(this.rJr);
    }
    this.rJs.dead();
    this.mIsDestroyed = true;
    super.onDestroy();
    ad.cKU().b(this);
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
    cLO();
    if (!this.rJg)
    {
      ad.cKN().anD(this.mRa);
      cLQ();
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