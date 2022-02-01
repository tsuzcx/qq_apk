package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.view.b;
import androidx.appcompat.view.b.a;
import androidx.appcompat.widget.Toolbar;

public abstract class d
{
  private static int fQ = -1;
  
  public static d a(Activity paramActivity, c paramc)
  {
    return new AppCompatDelegateImpl(paramActivity, paramActivity.getWindow(), paramc);
  }
  
  public static d a(Dialog paramDialog, c paramc)
  {
    return new AppCompatDelegateImpl(paramDialog.getContext(), paramDialog.getWindow(), paramc);
  }
  
  public static int aL()
  {
    return fQ;
  }
  
  public abstract boolean P(int paramInt);
  
  public abstract void aI();
  
  public abstract void aJ();
  
  public abstract boolean aK();
  
  public abstract void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract <T extends View> T findViewById(int paramInt);
  
  public abstract a.a getDrawerToggleDelegate();
  
  public abstract MenuInflater getMenuInflater();
  
  public abstract ActionBar getSupportActionBar();
  
  public abstract void invalidateOptionsMenu();
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onPostResume();
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract void setContentView(int paramInt);
  
  public abstract void setContentView(View paramView);
  
  public abstract void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void setSupportActionBar(Toolbar paramToolbar);
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public abstract b startSupportActionMode(b.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.app.d
 * JD-Core Version:    0.7.0.1
 */