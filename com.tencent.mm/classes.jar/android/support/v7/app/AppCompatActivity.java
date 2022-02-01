package android.support.v7.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ab;
import android.support.v4.app.ab.a;
import android.support.v4.app.q;
import android.support.v7.view.b.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.be;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import java.util.ArrayList;

public class AppCompatActivity
  extends FragmentActivity
  implements ab.a, c
{
  private d mDelegate;
  private Resources mResources;
  private int mThemeId = 0;
  
  private boolean performMenuItemShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 26) && (!paramKeyEvent.isCtrlPressed()) && (!KeyEvent.metaStateHasNoModifiers(paramKeyEvent.getMetaState())) && (paramKeyEvent.getRepeatCount() == 0) && (!KeyEvent.isModifierKey(paramKeyEvent.getKeyCode())))
    {
      Window localWindow = getWindow();
      if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().dispatchKeyShortcutEvent(paramKeyEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().addContentView(paramView, paramLayoutParams);
  }
  
  public void closeOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((getWindow().hasFeature(0)) && ((localActionBar == null) || (!localActionBar.gx()))) {
      super.closeOptionsMenu();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    ActionBar localActionBar = getSupportActionBar();
    if ((i == 82) && (localActionBar != null) && (localActionBar.b(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    return getDelegate().findViewById(paramInt);
  }
  
  public d getDelegate()
  {
    if (this.mDelegate == null) {
      this.mDelegate = d.a(this, this);
    }
    return this.mDelegate;
  }
  
  public a.a getDrawerToggleDelegate()
  {
    return getDelegate().getDrawerToggleDelegate();
  }
  
  public MenuInflater getMenuInflater()
  {
    return getDelegate().getMenuInflater();
  }
  
  public Resources getResources()
  {
    if ((this.mResources == null) && (be.nk())) {
      this.mResources = new be(this, super.getResources());
    }
    if (this.mResources == null) {
      return super.getResources();
    }
    return this.mResources;
  }
  
  public ActionBar getSupportActionBar()
  {
    return getDelegate().getSupportActionBar();
  }
  
  public Intent getSupportParentActivityIntent()
  {
    return q.h(this);
  }
  
  public void invalidateOptionsMenu()
  {
    getDelegate().invalidateOptionsMenu();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getDelegate().onConfigurationChanged(paramConfiguration);
    if (this.mResources != null)
    {
      DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
      this.mResources.updateConfiguration(paramConfiguration, localDisplayMetrics);
    }
  }
  
  public void onContentChanged()
  {
    onSupportContentChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    d locald = getDelegate();
    locald.gB();
    locald.onCreate(paramBundle);
    if ((locald.gC()) && (this.mThemeId != 0))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label55;
      }
      onApplyThemeResource(getTheme(), this.mThemeId, false);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      return;
      label55:
      setTheme(this.mThemeId);
    }
  }
  
  public void onCreateSupportNavigateUpTaskStack(ab paramab)
  {
    Intent localIntent = ((ab.a)this).getSupportParentActivityIntent();
    if (localIntent == null) {
      localIntent = q.h(this);
    }
    for (;;)
    {
      if (localIntent != null)
      {
        ComponentName localComponentName2 = localIntent.getComponent();
        ComponentName localComponentName1 = localComponentName2;
        if (localComponentName2 == null) {
          localComponentName1 = localIntent.resolveActivity(paramab.IT.getPackageManager());
        }
        paramab.a(localComponentName1);
        paramab.IS.add(localIntent);
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getDelegate().onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (performMenuItemShortcut(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0)) {
      return onSupportNavigateUp();
    }
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    getDelegate().gA();
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    getDelegate().onPostResume();
  }
  
  public void onPrepareSupportNavigateUpTaskStack(ab paramab) {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    getDelegate().onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    getDelegate().onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    getDelegate().onStop();
  }
  
  public void onSupportActionModeFinished(android.support.v7.view.b paramb) {}
  
  public void onSupportActionModeStarted(android.support.v7.view.b paramb) {}
  
  @Deprecated
  public void onSupportContentChanged() {}
  
  public boolean onSupportNavigateUp()
  {
    Object localObject = getSupportParentActivityIntent();
    if (localObject != null)
    {
      if (supportShouldUpRecreateTask((Intent)localObject))
      {
        localObject = ab.R(this);
        onCreateSupportNavigateUpTaskStack((ab)localObject);
        onPrepareSupportNavigateUpTaskStack((ab)localObject);
        if (((ab)localObject).IS.isEmpty()) {
          throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] arrayOfIntent = (Intent[])((ab)localObject).IS.toArray(new Intent[((ab)localObject).IS.size()]);
        arrayOfIntent[0] = new Intent(arrayOfIntent[0]).addFlags(268484608);
        android.support.v4.content.b.a(((ab)localObject).IT, arrayOfIntent);
      }
      for (;;)
      {
        try
        {
          android.support.v4.app.a.d(this);
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
    return false;
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    getDelegate().setTitle(paramCharSequence);
  }
  
  public android.support.v7.view.b onWindowStartingSupportActionMode(b.a parama)
  {
    return null;
  }
  
  public void openOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((getWindow().hasFeature(0)) && ((localActionBar == null) || (!localActionBar.gw()))) {
      super.openOptionsMenu();
    }
  }
  
  public void setContentView(int paramInt)
  {
    getDelegate().setContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    getDelegate().setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().setContentView(paramView, paramLayoutParams);
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    getDelegate().setSupportActionBar(paramToolbar);
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
    super.setTheme(paramInt);
    this.mThemeId = paramInt;
  }
  
  public android.support.v7.view.b startSupportActionMode(b.a parama)
  {
    return getDelegate().startSupportActionMode(parama);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    getDelegate().invalidateOptionsMenu();
  }
  
  public void supportNavigateUpTo(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      navigateUpTo(paramIntent);
      return;
    }
    paramIntent.addFlags(67108864);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "android/support/v4/app/NavUtils", "navigateUpTo", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "android/support/v4/app/NavUtils", "navigateUpTo", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    return getDelegate().requestWindowFeature(paramInt);
  }
  
  public boolean supportShouldUpRecreateTask(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return shouldUpRecreateTask(paramIntent);
    }
    paramIntent = getIntent().getAction();
    return (paramIntent != null) && (!paramIntent.equals("android.intent.action.MAIN"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatActivity
 * JD-Core Version:    0.7.0.1
 */