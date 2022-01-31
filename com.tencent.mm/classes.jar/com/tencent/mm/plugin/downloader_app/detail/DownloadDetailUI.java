package com.tencent.mm.plugin.downloader_app.detail;

import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.luggage.e.f;
import com.tencent.mm.plugin.downloader_app.b.b;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.lang.reflect.Field;

public class DownloadDetailUI
  extends MMActivity
{
  private a iRv;
  
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
  
  public void onBackPressed()
  {
    if (!this.iRv.qc()) {
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.DownloadDetailUI", "onCreate");
    paramBundle = getIntent().getStringExtra("rawUrl");
    if (bk.bl(paramBundle))
    {
      y.e("MicroMsg.DownloadDetailUI", "url is null");
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setFormat(-3);
    setMMTitle(getResources().getString(b.h.plugin_detail_title));
    ta(getResources().getColor(b.b.downloader_action_bar_color));
    setBackBtn(new DownloadDetailUI.1(this));
    int i = getResources().getColor(b.b.downloader_action_bar_color);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (getSwipeBackLayout() != null) {
        break label193;
      }
      com.tencent.mm.plugin.webview.luggage.d.a.c(this, i, true);
    }
    for (;;)
    {
      this.iRv = new a(this);
      setContentView(this.iRv.biq);
      this.iRv.a(new DownloadDetailUI.2(this));
      this.iRv.d(paramBundle, getIntent().getExtras());
      return;
      label193:
      if ((Build.VERSION.SDK_INT >= 21) && (getWindow() != null)) {
        com.tencent.mm.ui.statusbar.a.d(getSwipeBackLayout().getChildAt(0), i, true);
      }
    }
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    super.onCreateBeforeSetContentView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.DownloadDetailUI", "onDestroy");
    this.iRv.destroy();
    y.i("MicroMsg.DownloadDetailUI", "fixInputMethodManagerLeak");
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    int i;
    if (localInputMethodManager != null)
    {
      y.i("MicroMsg.DownloadDetailUI", "fixInputMethodManagerLeak, imm");
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
            break label197;
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
          y.printErrStackTrace("MicroMsg.DownloadDetailUI", localThrowable, "", new Object[0]);
        }
      }
      System.gc();
      return;
      label197:
      i += 1;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    y.i("MicroMsg.DownloadDetailUI", "onPause");
    this.iRv.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    y.i("MicroMsg.DownloadDetailUI", "onResume");
    this.iRv.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.DownloadDetailUI
 * JD-Core Version:    0.7.0.1
 */