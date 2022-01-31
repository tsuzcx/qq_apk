package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.j;
import android.support.v4.app.o;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.appusage.r;
import com.tencent.mm.plugin.appbrand.appusage.r.d;
import com.tencent.mm.plugin.appbrand.ui.recents.n;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.Locale;

public final class AppBrandLauncherUI
  extends DrawStatusBarActivity
  implements com.tencent.mm.plugin.appbrand.ui.a.b
{
  public static final int hcS = v.fAu;
  private int hcT = -1;
  private boolean hcU;
  private n hcV;
  public r.d hcW;
  
  public final void dC(boolean paramBoolean)
  {
    if (this.hcV != null) {
      this.hcV.dC(paramBoolean);
    }
    if ((paramBoolean) && (this.hcW != null)) {
      this.hcW.fJi[4] = "1";
    }
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected final int getStatusBarColor()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (l.b(getWindow()))) {
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return hcS;
    }
    return super.getStatusBarColor();
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.hcT = paramInt1;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      String str = paramIntent.getStringExtra("key_session_id");
      paramInt1 = paramIntent.getIntExtra("ftsbizscene", 0);
      y.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", new Object[] { str, com.tencent.mm.modelappbrand.b.dZM });
      h.nFQ.f(13929, new Object[] { str, com.tencent.mm.modelappbrand.b.dZM, Integer.valueOf(2), Integer.valueOf(paramInt1) });
    }
  }
  
  public final void onBackPressed()
  {
    finish();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      return;
    }
    if (!i.acO())
    {
      finish();
      return;
    }
    overridePendingTransition(MMFragmentActivity.a.uOe, MMFragmentActivity.a.uOf);
    this.hcU = getIntent().getBooleanExtra("extra_show_recommend", false);
    boolean bool = getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false);
    setTitleBarDoubleClickListener(new AppBrandLauncherUI.1(this));
    setMMTitle(getResources().getString(y.j.app_brand_entrance));
    setBackBtn(new AppBrandLauncherUI.2(this), y.i.actionbar_icon_dark_back);
    if (com.tencent.mm.plugin.appbrand.q.a.aoz()) {
      addIconOptionMenu(b.hdb.ordinal(), y.j.top_item_desc_search, y.i.actionbar_icon_dark_search, new AppBrandLauncherUI.3(this), null);
    }
    ta(-855310);
    findViewById(16908290).setBackgroundColor(-855310);
    if ((this.hcU) && (!bool)) {
      getSupportFragmentManager().bP().b(16908290, new com.tencent.mm.plugin.appbrand.ui.recommend.a()).commit();
    }
    Object localObject;
    for (;;)
    {
      h.nFQ.a(465L, 0L, 1L, false);
      if (com.tencent.mm.plugin.appbrand.q.a.aoz()) {
        break;
      }
      y.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
      com.tencent.mm.cl.b.afs("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
      if (r.adk()) {
        this.hcW = new r.d();
      }
      r.adm();
      i.acP();
      return;
      paramBundle = getLifecycle();
      localObject = new n(this);
      this.hcV = ((n)localObject);
      paramBundle.addObserver((LifecycleObserver)localObject);
    }
    long l2 = System.currentTimeMillis();
    paramBundle = g.DP().Dz().get(ac.a.uuQ, null);
    if ((paramBundle != null) && ((paramBundle instanceof Long))) {}
    for (long l1 = ((Long)paramBundle).longValue();; l1 = 0L)
    {
      paramBundle = Locale.getDefault().getLanguage();
      localObject = g.DP().Dz().get(ac.a.uuN, null);
      if ((l2 - l1 >= 3600000L) || (localObject == null) || (!localObject.equals(paramBundle))) {
        g.DO().dJT.a(new com.tencent.mm.plugin.appbrand.n.b(), 0);
      }
      y.v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", new Object[] { localObject, paramBundle, Long.valueOf(l1), Long.valueOf(l2) });
      break;
    }
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    super.onCreateBeforeSetContentView();
    getWindow().setSoftInputMode(3);
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    q.adg();
    if (this.hcW != null)
    {
      r.d locald = this.hcW;
      h.nFQ.f(14113, (Object[])locald.fJi);
      this.hcW = null;
    }
  }
  
  protected final void onResume()
  {
    int i;
    if (this.hcT > 0)
    {
      if (this.hcT != 1) {
        break label50;
      }
      i = 7;
    }
    for (;;)
    {
      this.hcT = 0;
      a locala = (a)super.getSupportFragmentManager().Z(16908290);
      if (locala != null) {
        locala.setScene(i);
      }
      super.onResume();
      return;
      label50:
      if (this.hcT == 2) {
        i = 6;
      } else if (this.hcT == 3) {
        i = 9;
      } else if (this.hcT == 4) {
        i = 12;
      } else {
        i = 4;
      }
    }
  }
  
  public final void setTitle(int paramInt)
  {
    setMMTitle(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    N(paramCharSequence);
  }
  
  public static abstract class a
    extends Fragment
  {
    public View QR;
    public int fzn;
    private final ah hcZ = new ah(Looper.getMainLooper());
    public String hda;
    
    public final void F(Runnable paramRunnable)
    {
      if (paramRunnable != null) {
        this.hcZ.post(paramRunnable);
      }
    }
    
    public void aoV() {}
    
    public final <T extends View> T aoW()
    {
      return this.QR.findViewById(16908298);
    }
    
    public final View getContentView()
    {
      return this.QR;
    }
    
    public abstract int getLayoutId();
    
    public abstract void initView();
    
    @SuppressLint({"ResourceType"})
    public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      if (getLayoutId() < 0) {}
      for (this.QR = new FrameLayout(paramViewGroup.getContext());; this.QR = paramLayoutInflater.inflate(getLayoutId(), null))
      {
        initView();
        return this.QR;
      }
    }
    
    public final void runOnUiThread(Runnable paramRunnable)
    {
      if (getActivity() == null) {
        return;
      }
      getActivity().runOnUiThread(paramRunnable);
    }
    
    public void setScene(int paramInt)
    {
      this.fzn = paramInt;
    }
  }
  
  private static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI
 * JD-Core Version:    0.7.0.1
 */