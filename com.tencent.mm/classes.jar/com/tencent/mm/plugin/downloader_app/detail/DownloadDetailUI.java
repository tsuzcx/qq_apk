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
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.i;
import com.tencent.luggage.d.m;
import com.tencent.luggage.d.p;
import com.tencent.luggage.h.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.lang.reflect.Field;

public class DownloadDetailUI
  extends MMActivity
  implements e.e
{
  private a pob;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initSwipeBack()
  {
    AppMethodBeat.i(8793);
    super.initSwipeBack();
    if (getSwipeBackLayout() == null)
    {
      AppMethodBeat.o(8793);
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
      AppMethodBeat.o(8793);
      return;
      localb.addView(localView1);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(8795);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.pob.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(8795);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(8792);
    if (!this.pob.onBackPressed()) {
      finish();
    }
    AppMethodBeat.o(8792);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(8788);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.DownloadDetailUI", "onCreate");
    paramBundle = getIntent().getStringExtra("rawUrl");
    if (bt.isNullOrNil(paramBundle))
    {
      ad.e("MicroMsg.DownloadDetailUI", "url is null");
      AppMethodBeat.o(8788);
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setFormat(-3);
    setMMTitle(getResources().getString(2131761940));
    setActionbarColor(getResources().getColor(2131100260));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(8786);
        DownloadDetailUI.this.finish();
        AppMethodBeat.o(8786);
        return false;
      }
    });
    int i = getResources().getColor(2131100260);
    Window localWindow;
    if ((Build.VERSION.SDK_INT >= 21) && (getSwipeBackLayout() == null) && (Build.VERSION.SDK_INT >= 21))
    {
      localWindow = ((Activity)this).getWindow();
      if ((Build.VERSION.SDK_INT >= 23) && (com.tencent.mm.ui.statusbar.d.c(localWindow, true))) {
        break label251;
      }
      if (Build.VERSION.SDK_INT >= 21) {
        i = al.Xp(i);
      }
    }
    label251:
    for (;;)
    {
      localWindow.setStatusBarColor(i);
      this.pob = new a(this);
      setContentView(this.pob.chr);
      this.pob.a(new m()
      {
        public final h k(String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          boolean bool = true;
          AppMethodBeat.i(8787);
          p localp = d.ex(DownloadDetailUI.this);
          if (localp == null) {}
          for (;;)
          {
            ad.i("MicroMsg.DownloadDetailUI", "preloadDetail is null ? %b", new Object[] { Boolean.valueOf(bool) });
            if (localp == null) {
              d.aat(paramAnonymousString);
            }
            paramAnonymousString = new c(DownloadDetailUI.a(DownloadDetailUI.this).chy, localp, paramAnonymousBundle);
            AppMethodBeat.o(8787);
            return paramAnonymousString;
            bool = false;
          }
        }
      });
      this.pob.h(paramBundle, getIntent().getExtras());
      AppMethodBeat.o(8788);
      return;
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(8794);
    super.onCreateBeforeSetContentView();
    AppMethodBeat.o(8794);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(8791);
    super.onDestroy();
    ad.i("MicroMsg.DownloadDetailUI", "onDestroy");
    this.pob.destroy();
    ad.i("MicroMsg.DownloadDetailUI", "fixInputMethodManagerLeak");
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    int i;
    if (localInputMethodManager != null)
    {
      ad.i("MicroMsg.DownloadDetailUI", "fixInputMethodManagerLeak, imm");
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
            break label209;
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
          ad.printErrStackTrace("MicroMsg.DownloadDetailUI", localThrowable, "", new Object[0]);
        }
      }
      System.gc();
      AppMethodBeat.o(8791);
      return;
      label209:
      i += 1;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(8790);
    super.onPause();
    ad.i("MicroMsg.DownloadDetailUI", "onPause");
    this.pob.onPause();
    AppMethodBeat.o(8790);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(8789);
    super.onResume();
    ad.i("MicroMsg.DownloadDetailUI", "onResume");
    this.pob.onResume();
    AppMethodBeat.o(8789);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.DownloadDetailUI
 * JD-Core Version:    0.7.0.1
 */