package androidx.appcompat.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.appcompat.view.b;
import androidx.appcompat.view.b.a;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ah;
import androidx.core.app.a;
import androidx.core.app.m;
import androidx.core.app.m.a;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatActivity
  extends FragmentActivity
  implements c, m.a
{
  private d mDelegate;
  private Resources mResources;
  private int mThemeId = 0;
  
  private boolean performMenuItemShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200433);
    if ((Build.VERSION.SDK_INT < 26) && (!paramKeyEvent.isCtrlPressed()) && (!KeyEvent.metaStateHasNoModifiers(paramKeyEvent.getMetaState())) && (paramKeyEvent.getRepeatCount() == 0) && (!KeyEvent.isModifierKey(paramKeyEvent.getKeyCode())))
    {
      Window localWindow = getWindow();
      if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().dispatchKeyShortcutEvent(paramKeyEvent)))
      {
        AppMethodBeat.o(200433);
        return true;
      }
    }
    AppMethodBeat.o(200433);
    return false;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200505);
    getDelegate().addContentView(paramView, paramLayoutParams);
    AppMethodBeat.o(200505);
  }
  
  public void closeOptionsMenu()
  {
    AppMethodBeat.i(200839);
    ActionBar localActionBar = getSupportActionBar();
    if ((getWindow().hasFeature(0)) && ((localActionBar == null) || (!localActionBar.by()))) {
      super.closeOptionsMenu();
    }
    AppMethodBeat.o(200839);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200806);
    int i = paramKeyEvent.getKeyCode();
    ActionBar localActionBar = getSupportActionBar();
    if ((i == 82) && (localActionBar != null) && (localActionBar.c(paramKeyEvent)))
    {
      AppMethodBeat.o(200806);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(200806);
    return bool;
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    AppMethodBeat.i(200545);
    View localView = getDelegate().findViewById(paramInt);
    AppMethodBeat.o(200545);
    return localView;
  }
  
  public d getDelegate()
  {
    AppMethodBeat.i(200794);
    if (this.mDelegate == null) {
      this.mDelegate = d.a(this, this);
    }
    d locald = this.mDelegate;
    AppMethodBeat.o(200794);
    return locald;
  }
  
  public a.a getDrawerToggleDelegate()
  {
    AppMethodBeat.i(200751);
    a.a locala = getDelegate().getDrawerToggleDelegate();
    AppMethodBeat.o(200751);
    return locala;
  }
  
  public MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(200477);
    MenuInflater localMenuInflater = getDelegate().getMenuInflater();
    AppMethodBeat.o(200477);
    return localMenuInflater;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(200816);
    if ((this.mResources == null) && (ah.fE())) {
      this.mResources = new ah(this, super.getResources());
    }
    if (this.mResources == null)
    {
      localResources = super.getResources();
      AppMethodBeat.o(200816);
      return localResources;
    }
    Resources localResources = this.mResources;
    AppMethodBeat.o(200816);
    return localResources;
  }
  
  public ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(200460);
    ActionBar localActionBar = getDelegate().getSupportActionBar();
    AppMethodBeat.o(200460);
    return localActionBar;
  }
  
  public Intent getSupportParentActivityIntent()
  {
    AppMethodBeat.i(200703);
    Intent localIntent = androidx.core.app.d.f(this);
    AppMethodBeat.o(200703);
    return localIntent;
  }
  
  public void invalidateOptionsMenu()
  {
    AppMethodBeat.i(200602);
    getDelegate().invalidateOptionsMenu();
    AppMethodBeat.o(200602);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(200513);
    super.onConfigurationChanged(paramConfiguration);
    getDelegate().onConfigurationChanged(paramConfiguration);
    if (this.mResources != null)
    {
      DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
      this.mResources.updateConfiguration(paramConfiguration, localDisplayMetrics);
    }
    AppMethodBeat.o(200513);
  }
  
  public void onContentChanged()
  {
    AppMethodBeat.i(200730);
    onSupportContentChanged();
    AppMethodBeat.o(200730);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200439);
    d locald = getDelegate();
    locald.bC();
    locald.onCreate(paramBundle);
    if ((locald.bD()) && (this.mThemeId != 0))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label65;
      }
      onApplyThemeResource(getTheme(), this.mThemeId, false);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      AppMethodBeat.o(200439);
      return;
      label65:
      setTheme(this.mThemeId);
    }
  }
  
  public void onCreateSupportNavigateUpTaskStack(m paramm)
  {
    AppMethodBeat.i(200673);
    paramm.i(this);
    AppMethodBeat.o(200673);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(200563);
    super.onDestroy();
    getDelegate().onDestroy();
    AppMethodBeat.o(200563);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200824);
    if (performMenuItemShortcut(paramInt, paramKeyEvent))
    {
      AppMethodBeat.o(200824);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(200824);
    return bool;
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(200556);
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
    {
      AppMethodBeat.o(200556);
      return true;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((localActionBar.bu() & 0x4) != 0))
    {
      boolean bool = onSupportNavigateUp();
      AppMethodBeat.o(200556);
      return bool;
    }
    AppMethodBeat.o(200556);
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(200762);
    boolean bool = super.onMenuOpened(paramInt, paramMenu);
    AppMethodBeat.o(200762);
    return bool;
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(200771);
    super.onPanelClosed(paramInt, paramMenu);
    AppMethodBeat.o(200771);
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200453);
    super.onPostCreate(paramBundle);
    getDelegate().bB();
    AppMethodBeat.o(200453);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(200522);
    super.onPostResume();
    getDelegate().onPostResume();
    AppMethodBeat.o(200522);
  }
  
  public void onPrepareSupportNavigateUpTaskStack(m paramm) {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(200781);
    super.onSaveInstanceState(paramBundle);
    getDelegate().onSaveInstanceState(paramBundle);
    AppMethodBeat.o(200781);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(200529);
    super.onStart();
    getDelegate().onStart();
    AppMethodBeat.o(200529);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(200536);
    super.onStop();
    getDelegate().onStop();
    AppMethodBeat.o(200536);
  }
  
  public void onSupportActionModeFinished(b paramb) {}
  
  public void onSupportActionModeStarted(b paramb) {}
  
  @Deprecated
  public void onSupportContentChanged() {}
  
  public boolean onSupportNavigateUp()
  {
    AppMethodBeat.i(200691);
    Object localObject = getSupportParentActivityIntent();
    if (localObject != null)
    {
      if (supportShouldUpRecreateTask((Intent)localObject))
      {
        localObject = m.Z(this);
        onCreateSupportNavigateUpTaskStack((m)localObject);
        onPrepareSupportNavigateUpTaskStack((m)localObject);
        ((m)localObject).DD();
      }
      for (;;)
      {
        try
        {
          a.b(this);
          AppMethodBeat.o(200691);
          return true;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          finish();
          continue;
        }
        supportNavigateUpTo(localIllegalStateException);
      }
    }
    AppMethodBeat.o(200691);
    return false;
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(200576);
    super.onTitleChanged(paramCharSequence, paramInt);
    getDelegate().setTitle(paramCharSequence);
    AppMethodBeat.o(200576);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public b onWindowStartingSupportActionMode(b.a parama)
  {
    return null;
  }
  
  public void openOptionsMenu()
  {
    AppMethodBeat.i(200834);
    ActionBar localActionBar = getSupportActionBar();
    if ((getWindow().hasFeature(0)) && ((localActionBar == null) || (!localActionBar.bx()))) {
      super.openOptionsMenu();
    }
    AppMethodBeat.o(200834);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(200485);
    getDelegate().setContentView(paramInt);
    AppMethodBeat.o(200485);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(200492);
    getDelegate().setContentView(paramView);
    AppMethodBeat.o(200492);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200499);
    getDelegate().setContentView(paramView, paramLayoutParams);
    AppMethodBeat.o(200499);
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    AppMethodBeat.i(200469);
    getDelegate().setSupportActionBar(paramToolbar);
    AppMethodBeat.o(200469);
  }
  
  @Deprecated
  public void setSupportProgress(int paramInt) {}
  
  @Deprecated
  public void setSupportProgressBarIndeterminate(boolean paramBoolean) {}
  
  @Deprecated
  public void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean) {}
  
  @Deprecated
  public void setSupportProgressBarVisibility(boolean paramBoolean) {}
  
  public void setTheme(int paramInt)
  {
    AppMethodBeat.i(200445);
    super.setTheme(paramInt);
    this.mThemeId = paramInt;
    AppMethodBeat.o(200445);
  }
  
  public b startSupportActionMode(b.a parama)
  {
    AppMethodBeat.i(200634);
    parama = getDelegate().startSupportActionMode(parama);
    AppMethodBeat.o(200634);
    return parama;
  }
  
  public void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(200594);
    getDelegate().invalidateOptionsMenu();
    AppMethodBeat.o(200594);
  }
  
  public void supportNavigateUpTo(Intent paramIntent)
  {
    AppMethodBeat.i(200723);
    androidx.core.app.d.b(this, paramIntent);
    AppMethodBeat.o(200723);
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    AppMethodBeat.i(200586);
    boolean bool = getDelegate().N(paramInt);
    AppMethodBeat.o(200586);
    return bool;
  }
  
  public boolean supportShouldUpRecreateTask(Intent paramIntent)
  {
    AppMethodBeat.i(200713);
    boolean bool = androidx.core.app.d.a(this, paramIntent);
    AppMethodBeat.o(200713);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatActivity
 * JD-Core Version:    0.7.0.1
 */