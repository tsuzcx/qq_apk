package com.tencent.mm.plugin.game.luggage;

import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.luggage.e.f;
import com.tencent.luggage.j.d;
import com.tencent.luggage.j.d.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.model.GameWebViewLaunchParams;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;

public class LuggageGameWebViewUI
  extends MMActivity
{
  private a kMI;
  private int kMJ = -1;
  private GameWebPerformanceInfo kMv;
  
  protected final void ahA()
  {
    if (this.kMJ != -1)
    {
      setRequestedOrientation(this.kMJ);
      return;
    }
    this.uMo = getSharedPreferences(ae.cqR(), 4).getBoolean("settings_landscape_mode", false);
    if (this.uMo)
    {
      setRequestedOrientation(-1);
      return;
    }
    setRequestedOrientation(1);
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected void initSwipeBack()
  {
    super.initSwipeBack();
    if (getSwipeBackLayout() == null) {
      return;
    }
    View localView1 = getSwipeBackLayout().getChildAt(0);
    getSwipeBackLayout().removeView(localView1);
    b localb = new b(this);
    if ((localView1 instanceof FrameLayout))
    {
      View localView2 = ((FrameLayout)localView1).getChildAt(0);
      ViewGroup.LayoutParams localLayoutParams = localView2.getLayoutParams();
      ((FrameLayout)localView1).removeView(localView2);
      localb.addView(localView2, localLayoutParams);
    }
    for (;;)
    {
      getSwipeBackLayout().addView(localb);
      getSwipeBackLayout().setContentView(localb);
      return;
      localb.addView(localView1);
    }
  }
  
  public final boolean noActionBar()
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    d locald = this.kMI.bit;
    Iterator localIterator = locald.bjH.iterator();
    while (localIterator.hasNext()) {
      if (((d.a)localIterator.next()).b(paramInt1, paramInt2, paramIntent)) {
        return;
      }
    }
    locald.bjF.get(paramInt1);
    locald.bjF.delete(paramInt1);
  }
  
  public void onBackPressed()
  {
    if (!this.kMI.qc()) {
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    overridePendingTransition(MMFragmentActivity.a.uOi, MMFragmentActivity.a.uOj);
    y.i("MicroMsg.LuggageGameWebViewUI", "onCreate, startTime: %d, now: %d", new Object[] { Long.valueOf(getIntent().getLongExtra("start_activity_time", 0L)), Long.valueOf(System.currentTimeMillis()) });
    paramBundle = getIntent().getStringExtra("rawUrl");
    if (bk.bl(paramBundle)) {
      y.e("MicroMsg.LuggageGameWebViewUI", "url is null");
    }
    do
    {
      do
      {
        return;
        this.kMv = GameWebPerformanceInfo.fv(paramBundle);
        this.kMv.url = paramBundle;
        this.kMv.startTime = getIntent().getLongExtra("start_time", System.currentTimeMillis());
        this.kMv.dCE = getIntent().getLongExtra("gamecenterui_createtime", 0L);
        this.kMv.dCF = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        this.kMv.dCK = System.currentTimeMillis();
        this.kMv.dCA = 1;
        com.tencent.mm.plugin.webview.luggage.c.a.w(System.currentTimeMillis(), paramBundle);
        if (Build.VERSION.SDK_INT >= 11) {
          getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        this.kMI = new a(this);
        setContentView(this.kMI.biq);
        this.kMI.a(new LuggageGameWebViewUI.1(this, paramBundle));
        this.kMI.d(paramBundle, getIntent().getExtras());
        paramBundle = (GameWebViewLaunchParams)getIntent().getParcelableExtra("launchParams");
      } while (paramBundle == null);
      paramBundle = paramBundle.kRd;
    } while (paramBundle == null);
    new Handler().postDelayed(new LuggageGameWebViewUI.2(this, paramBundle), 400L);
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
    supportRequestWindowFeature(9);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.LuggageGameWebViewUI", "onDestroy");
    com.tencent.mm.plugin.webview.luggage.c.a.clean();
    this.kMI.destroy();
    y.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak");
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    int i;
    if (localInputMethodManager != null)
    {
      y.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak, imm");
      i = 0;
    }
    for (;;)
    {
      if (i < 3)
      {
        Object localObject1 = new String[] { "mCurRootView", "mServedView", "mNextServedView" }[i];
        try
        {
          localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
          if (!((Field)localObject1).isAccessible()) {
            ((Field)localObject1).setAccessible(true);
          }
          Object localObject2 = ((Field)localObject1).get(localInputMethodManager);
          if ((localObject2 == null) || (!(localObject2 instanceof View))) {
            break label207;
          }
          localObject2 = (View)localObject2;
          if ((((View)localObject2).getContext() instanceof ContextWrapper))
          {
            if (((ContextWrapper)((View)localObject2).getContext()).getBaseContext() == this) {
              ((Field)localObject1).set(localInputMethodManager, null);
            }
          }
          else if (((View)localObject2).getContext() == this) {
            ((Field)localObject1).set(localInputMethodManager, null);
          }
        }
        catch (Throwable localThrowable)
        {
          y.printErrStackTrace("MicroMsg.LuggageGameWebViewUI", localThrowable, "", new Object[0]);
        }
      }
      System.gc();
      return;
      label207:
      i += 1;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    y.i("MicroMsg.LuggageGameWebViewUI", "onPause");
    this.kMI.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    y.i("MicroMsg.LuggageGameWebViewUI", "onResume");
    this.kMI.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI
 * JD-Core Version:    0.7.0.1
 */