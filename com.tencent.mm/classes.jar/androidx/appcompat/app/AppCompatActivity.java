package androidx.appcompat.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
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
import androidx.core.app.l;
import androidx.core.app.l.a;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class AppCompatActivity
  extends FragmentActivity
  implements c, l.a
{
  private d mDelegate;
  private Resources mResources;
  private int mThemeId = 0;
  
  private boolean performMenuItemShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(238071);
    if ((Build.VERSION.SDK_INT < 26) && (!paramKeyEvent.isCtrlPressed()) && (!KeyEvent.metaStateHasNoModifiers(paramKeyEvent.getMetaState())) && (paramKeyEvent.getRepeatCount() == 0) && (!KeyEvent.isModifierKey(paramKeyEvent.getKeyCode())))
    {
      Window localWindow = getWindow();
      if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().dispatchKeyShortcutEvent(paramKeyEvent)))
      {
        AppMethodBeat.o(238071);
        return true;
      }
    }
    AppMethodBeat.o(238071);
    return false;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(238036);
    getDelegate().addContentView(paramView, paramLayoutParams);
    AppMethodBeat.o(238036);
  }
  
  public void closeOptionsMenu()
  {
    AppMethodBeat.i(238076);
    ActionBar localActionBar = getSupportActionBar();
    if ((getWindow().hasFeature(0)) && ((localActionBar == null) || (!localActionBar.aF()))) {
      super.closeOptionsMenu();
    }
    AppMethodBeat.o(238076);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(238069);
    int i = paramKeyEvent.getKeyCode();
    ActionBar localActionBar = getSupportActionBar();
    if ((i == 82) && (localActionBar != null) && (localActionBar.c(paramKeyEvent)))
    {
      AppMethodBeat.o(238069);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(238069);
    return bool;
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    AppMethodBeat.i(238041);
    View localView = getDelegate().findViewById(paramInt);
    AppMethodBeat.o(238041);
    return localView;
  }
  
  public d getDelegate()
  {
    AppMethodBeat.i(238067);
    if (this.mDelegate == null) {
      this.mDelegate = d.a(this, this);
    }
    d locald = this.mDelegate;
    AppMethodBeat.o(238067);
    return locald;
  }
  
  public a.a getDrawerToggleDelegate()
  {
    AppMethodBeat.i(238062);
    a.a locala = getDelegate().getDrawerToggleDelegate();
    AppMethodBeat.o(238062);
    return locala;
  }
  
  public MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(238030);
    MenuInflater localMenuInflater = getDelegate().getMenuInflater();
    AppMethodBeat.o(238030);
    return localMenuInflater;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(238070);
    if ((this.mResources == null) && (ah.eH())) {
      this.mResources = new ah(this, super.getResources());
    }
    if (this.mResources == null)
    {
      localResources = super.getResources();
      AppMethodBeat.o(238070);
      return localResources;
    }
    Resources localResources = this.mResources;
    AppMethodBeat.o(238070);
    return localResources;
  }
  
  public ActionBar getSupportActionBar()
  {
    AppMethodBeat.i(238028);
    ActionBar localActionBar = getDelegate().getSupportActionBar();
    AppMethodBeat.o(238028);
    return localActionBar;
  }
  
  public Intent getSupportParentActivityIntent()
  {
    AppMethodBeat.i(238053);
    Intent localIntent = androidx.core.app.c.f(this);
    AppMethodBeat.o(238053);
    return localIntent;
  }
  
  public void invalidateOptionsMenu()
  {
    AppMethodBeat.i(238048);
    getDelegate().invalidateOptionsMenu();
    AppMethodBeat.o(238048);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(238037);
    super.onConfigurationChanged(paramConfiguration);
    getDelegate().onConfigurationChanged(paramConfiguration);
    if (this.mResources != null)
    {
      DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
      this.mResources.updateConfiguration(paramConfiguration, localDisplayMetrics);
    }
    AppMethodBeat.o(238037);
  }
  
  public void onContentChanged()
  {
    AppMethodBeat.i(238060);
    onSupportContentChanged();
    AppMethodBeat.o(238060);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(238024);
    d locald = getDelegate();
    locald.aJ();
    locald.onCreate(paramBundle);
    if ((locald.aK()) && (this.mThemeId != 0))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label65;
      }
      onApplyThemeResource(getTheme(), this.mThemeId, false);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      AppMethodBeat.o(238024);
      return;
      label65:
      setTheme(this.mThemeId);
    }
  }
  
  public void onCreateSupportNavigateUpTaskStack(l paraml)
  {
    AppMethodBeat.i(238050);
    Intent localIntent = ((l.a)this).getSupportParentActivityIntent();
    if (localIntent == null) {
      localIntent = androidx.core.app.c.f(this);
    }
    for (;;)
    {
      if (localIntent != null)
      {
        ComponentName localComponentName2 = localIntent.getComponent();
        ComponentName localComponentName1 = localComponentName2;
        if (localComponentName2 == null) {
          localComponentName1 = localIntent.resolveActivity(paraml.JT.getPackageManager());
        }
        paraml.b(localComponentName1);
        paraml.JS.add(localIntent);
      }
      AppMethodBeat.o(238050);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(238043);
    super.onDestroy();
    getDelegate().onDestroy();
    AppMethodBeat.o(238043);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(238072);
    if (performMenuItemShortcut(paramInt, paramKeyEvent))
    {
      AppMethodBeat.o(238072);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(238072);
    return bool;
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(238042);
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
    {
      AppMethodBeat.o(238042);
      return true;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((localActionBar.aC() & 0x4) != 0))
    {
      boolean bool = onSupportNavigateUp();
      AppMethodBeat.o(238042);
      return bool;
    }
    AppMethodBeat.o(238042);
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(238063);
    boolean bool = super.onMenuOpened(paramInt, paramMenu);
    AppMethodBeat.o(238063);
    return bool;
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(238065);
    super.onPanelClosed(paramInt, paramMenu);
    AppMethodBeat.o(238065);
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(238027);
    super.onPostCreate(paramBundle);
    getDelegate().aI();
    AppMethodBeat.o(238027);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(238038);
    super.onPostResume();
    getDelegate().onPostResume();
    AppMethodBeat.o(238038);
  }
  
  public void onPrepareSupportNavigateUpTaskStack(l paraml) {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(238066);
    super.onSaveInstanceState(paramBundle);
    getDelegate().onSaveInstanceState(paramBundle);
    AppMethodBeat.o(238066);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(238039);
    super.onStart();
    getDelegate().onStart();
    AppMethodBeat.o(238039);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(238040);
    super.onStop();
    getDelegate().onStop();
    AppMethodBeat.o(238040);
  }
  
  public void onSupportActionModeFinished(b paramb) {}
  
  public void onSupportActionModeStarted(b paramb) {}
  
  @Deprecated
  public void onSupportContentChanged() {}
  
  public boolean onSupportNavigateUp()
  {
    AppMethodBeat.i(238052);
    Object localObject = getSupportParentActivityIntent();
    if (localObject != null)
    {
      if (supportShouldUpRecreateTask((Intent)localObject))
      {
        localObject = l.O(this);
        onCreateSupportNavigateUpTaskStack((l)localObject);
        onPrepareSupportNavigateUpTaskStack((l)localObject);
        if (((l)localObject).JS.isEmpty())
        {
          localObject = new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
          AppMethodBeat.o(238052);
          throw ((Throwable)localObject);
        }
        Intent[] arrayOfIntent = (Intent[])((l)localObject).JS.toArray(new Intent[((l)localObject).JS.size()]);
        arrayOfIntent[0] = new Intent(arrayOfIntent[0]).addFlags(268484608);
        androidx.core.content.a.a(((l)localObject).JT, arrayOfIntent);
      }
      for (;;)
      {
        try
        {
          androidx.core.app.a.b(this);
          AppMethodBeat.o(238052);
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
    AppMethodBeat.o(238052);
    return false;
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(238044);
    super.onTitleChanged(paramCharSequence, paramInt);
    getDelegate().setTitle(paramCharSequence);
    AppMethodBeat.o(238044);
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
    AppMethodBeat.i(238074);
    ActionBar localActionBar = getSupportActionBar();
    if ((getWindow().hasFeature(0)) && ((localActionBar == null) || (!localActionBar.aE()))) {
      super.openOptionsMenu();
    }
    AppMethodBeat.o(238074);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(238032);
    getDelegate().setContentView(paramInt);
    AppMethodBeat.o(238032);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(238034);
    getDelegate().setContentView(paramView);
    AppMethodBeat.o(238034);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(238035);
    getDelegate().setContentView(paramView, paramLayoutParams);
    AppMethodBeat.o(238035);
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    AppMethodBeat.i(238029);
    getDelegate().setSupportActionBar(paramToolbar);
    AppMethodBeat.o(238029);
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
    AppMethodBeat.i(238026);
    super.setTheme(paramInt);
    this.mThemeId = paramInt;
    AppMethodBeat.o(238026);
  }
  
  public b startSupportActionMode(b.a parama)
  {
    AppMethodBeat.i(238049);
    parama = getDelegate().startSupportActionMode(parama);
    AppMethodBeat.o(238049);
    return parama;
  }
  
  public void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(238046);
    getDelegate().invalidateOptionsMenu();
    AppMethodBeat.o(238046);
  }
  
  public void supportNavigateUpTo(Intent paramIntent)
  {
    AppMethodBeat.i(238058);
    if (Build.VERSION.SDK_INT >= 16)
    {
      navigateUpTo(paramIntent);
      AppMethodBeat.o(238058);
      return;
    }
    paramIntent.addFlags(67108864);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aFh(), "androidx/core/app/NavUtils", "navigateUpTo", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "androidx/core/app/NavUtils", "navigateUpTo", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(238058);
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    AppMethodBeat.i(238045);
    boolean bool = getDelegate().P(paramInt);
    AppMethodBeat.o(238045);
    return bool;
  }
  
  public boolean supportShouldUpRecreateTask(Intent paramIntent)
  {
    AppMethodBeat.i(238056);
    if (Build.VERSION.SDK_INT >= 16)
    {
      boolean bool = shouldUpRecreateTask(paramIntent);
      AppMethodBeat.o(238056);
      return bool;
    }
    paramIntent = getIntent().getAction();
    if ((paramIntent != null) && (!paramIntent.equals("android.intent.action.MAIN")))
    {
      AppMethodBeat.o(238056);
      return true;
    }
    AppMethodBeat.o(238056);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatActivity
 * JD-Core Version:    0.7.0.1
 */