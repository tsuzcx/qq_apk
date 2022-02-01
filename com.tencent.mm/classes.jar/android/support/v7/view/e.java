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
  private h XT;
  private b.a XU;
  private WeakReference<View> XV;
  private ActionBarContextView Xx;
  private boolean aaI;
  private Context mContext;
  private boolean mFinished;
  
  public e(Context paramContext, ActionBarContextView paramActionBarContextView, b.a parama, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.Xx = paramActionBarContextView;
    this.XU = parama;
    paramContext = new h(paramActionBarContextView.getContext());
    paramContext.ady = 1;
    this.XT = paramContext;
    this.XT.a(this);
    this.aaI = paramBoolean;
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    return this.XU.a(this, paramMenuItem);
  }
  
  public final void b(h paramh)
  {
    invalidate();
    this.Xx.showOverflowMenu();
  }
  
  public final void finish()
  {
    if (this.mFinished) {
      return;
    }
    this.mFinished = true;
    this.Xx.sendAccessibilityEvent(32);
    this.XU.a(this);
  }
  
  public final View getCustomView()
  {
    if (this.XV != null) {
      return (View)this.XV.get();
    }
    return null;
  }
  
  public final Menu getMenu()
  {
    return this.XT;
  }
  
  public final MenuInflater getMenuInflater()
  {
    return new g(this.Xx.getContext());
  }
  
  public final CharSequence getSubtitle()
  {
    return this.Xx.getSubtitle();
  }
  
  public final CharSequence getTitle()
  {
    return this.Xx.getTitle();
  }
  
  public final void invalidate()
  {
    this.XU.b(this, this.XT);
  }
  
  public final boolean isTitleOptional()
  {
    return this.Xx.aeQ;
  }
  
  public final void setCustomView(View paramView)
  {
    this.Xx.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      this.XV = paramView;
      return;
    }
  }
  
  public final void setSubtitle(int paramInt)
  {
    setSubtitle(this.mContext.getString(paramInt));
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.Xx.setSubtitle(paramCharSequence);
  }
  
  public final void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Xx.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    this.Xx.setTitleOptional(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.e
 * JD-Core Version:    0.7.0.1
 */