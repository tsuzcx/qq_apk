package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.e.a;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public class e
  extends Dialog
  implements c
{
  private final e.a XE = new e.a()
  {
    public final boolean superDispatchKeyEvent(KeyEvent paramAnonymousKeyEvent)
    {
      return e.this.superDispatchKeyEvent(paramAnonymousKeyEvent);
    }
  };
  private d mDelegate;
  
  public e(Context paramContext, int paramInt)
  {
    super(paramContext, i);
    getDelegate().onCreate(null);
    getDelegate().ge();
  }
  
  private d getDelegate()
  {
    if (this.mDelegate == null) {
      this.mDelegate = d.a(this, this);
    }
    return this.mDelegate;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().addContentView(paramView, paramLayoutParams);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    return android.support.v4.view.e.a(this.XE, localView, this, paramKeyEvent);
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    return getDelegate().findViewById(paramInt);
  }
  
  public final boolean gt()
  {
    return getDelegate().requestWindowFeature(1);
  }
  
  public void invalidateOptionsMenu()
  {
    getDelegate().invalidateOptionsMenu();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    getDelegate().gd();
    super.onCreate(paramBundle);
    getDelegate().onCreate(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    getDelegate().onStop();
  }
  
  public void onSupportActionModeFinished(b paramb) {}
  
  public void onSupportActionModeStarted(b paramb) {}
  
  public b onWindowStartingSupportActionMode(b.a parama)
  {
    return null;
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
  
  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
    getDelegate().setTitle(getContext().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    getDelegate().setTitle(paramCharSequence);
  }
  
  final boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.e
 * JD-Core Version:    0.7.0.1
 */