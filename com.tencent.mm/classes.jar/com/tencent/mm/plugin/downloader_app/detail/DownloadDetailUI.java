package com.tencent.mm.plugin.downloader_app.detail;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.luggage.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.lang.reflect.Field;

public class DownloadDetailUI
  extends MMActivity
{
  private a lae;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initSwipeBack()
  {
    AppMethodBeat.i(136038);
    super.initSwipeBack();
    if (getSwipeBackLayout() == null)
    {
      AppMethodBeat.o(136038);
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
      AppMethodBeat.o(136038);
      return;
      localb.addView(localView1);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(136040);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.lae.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(136040);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(136037);
    if (!this.lae.onBackPressed()) {
      finish();
    }
    AppMethodBeat.o(136037);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(136033);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.DownloadDetailUI", "onCreate");
    paramBundle = getIntent().getStringExtra("rawUrl");
    if (bo.isNullOrNil(paramBundle))
    {
      ab.e("MicroMsg.DownloadDetailUI", "url is null");
      AppMethodBeat.o(136033);
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setFormat(-3);
    setMMTitle(getResources().getString(2131302101));
    setActionbarColor(getResources().getColor(2131689974));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(136031);
        DownloadDetailUI.this.finish();
        AppMethodBeat.o(136031);
        return false;
      }
    });
    int i = getResources().getColor(2131689974);
    Window localWindow;
    if ((Build.VERSION.SDK_INT >= 21) && (getSwipeBackLayout() == null) && (Build.VERSION.SDK_INT >= 21))
    {
      localWindow = ((Activity)this).getWindow();
      if ((Build.VERSION.SDK_INT >= 23) && (d.a(localWindow, true))) {
        break label248;
      }
      if (Build.VERSION.SDK_INT >= 21) {
        i = af.Kq(i);
      }
    }
    label248:
    for (;;)
    {
      localWindow.setStatusBarColor(i);
      this.lae = new a(this);
      setContentView(this.lae.byO);
      this.lae.a(new DownloadDetailUI.2(this));
      this.lae.h(paramBundle, getIntent().getExtras());
      AppMethodBeat.o(136033);
      return;
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(136039);
    super.onCreateBeforeSetContentView();
    AppMethodBeat.o(136039);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(136036);
    super.onDestroy();
    ab.i("MicroMsg.DownloadDetailUI", "onDestroy");
    this.lae.destroy();
    ab.i("MicroMsg.DownloadDetailUI", "fixInputMethodManagerLeak");
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    int i;
    if (localInputMethodManager != null)
    {
      ab.i("MicroMsg.DownloadDetailUI", "fixInputMethodManagerLeak, imm");
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
          ab.printErrStackTrace("MicroMsg.DownloadDetailUI", localThrowable, "", new Object[0]);
        }
      }
      System.gc();
      AppMethodBeat.o(136036);
      return;
      label207:
      i += 1;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(136035);
    super.onPause();
    ab.i("MicroMsg.DownloadDetailUI", "onPause");
    this.lae.onPause();
    AppMethodBeat.o(136035);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(136034);
    super.onResume();
    ab.i("MicroMsg.DownloadDetailUI", "onResume");
    this.lae.onResume();
    AppMethodBeat.o(136034);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.DownloadDetailUI
 * JD-Core Version:    0.7.0.1
 */