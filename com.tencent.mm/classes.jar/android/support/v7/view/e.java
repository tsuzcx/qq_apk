package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class e
  extends b
  implements h.a
{
  private h aaD;
  private b.a aaE;
  private WeakReference<View> aaF;
  private ActionBarContextView aah;
  private boolean adu;
  private Context mContext;
  private boolean mFinished;
  
  public e(Context paramContext, ActionBarContextView paramActionBarContextView, b.a parama, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.aah = paramActionBarContextView;
    this.aaE = parama;
    paramContext = new h(paramActionBarContextView.getContext());
    paramContext.agj = 1;
    this.aaD = paramContext;
    this.aaD.a(this);
    this.adu = paramBoolean;
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    return this.aaE.a(this, paramMenuItem);
  }
  
  public final void b(h paramh)
  {
    invalidate();
    this.aah.showOverflowMenu();
  }
  
  public final void finish()
  {
    if (this.mFinished) {
      return;
    }
    this.mFinished = true;
    this.aah.sendAccessibilityEvent(32);
    this.aaE.a(this);
  }
  
  public final View getCustomView()
  {
    if (this.aaF != null) {
      return (View)this.aaF.get();
    }
    return null;
  }
  
  public final Menu getMenu()
  {
    return this.aaD;
  }
  
  public final MenuInflater getMenuInflater()
  {
    return new g(this.aah.getContext());
  }
  
  public final CharSequence getSubtitle()
  {
    return this.aah.getSubtitle();
  }
  
  public final CharSequence getTitle()
  {
    return this.aah.getTitle();
  }
  
  public final void invalidate()
  {
    this.aaE.b(this, this.aaD);
  }
  
  public final boolean isTitleOptional()
  {
    return this.aah.ahB;
  }
  
  public final void setCustomView(View paramView)
  {
    this.aah.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      this.aaF = paramView;
      return;
    }
  }
  
  public final void setSubtitle(int paramInt)
  {
    setSubtitle(this.mContext.getString(paramInt));
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.aah.setSubtitle(paramCharSequence);
  }
  
  public final void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.aah.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    this.aah.setTitleOptional(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.e
 * JD-Core Version:    0.7.0.1
 */