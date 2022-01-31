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
  private b.a QV;
  private WeakReference<View> QW;
  private ActionBarContextView Qy;
  private boolean TF;
  private h eq;
  private Context mContext;
  private boolean mFinished;
  
  public e(Context paramContext, ActionBarContextView paramActionBarContextView, b.a parama, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.Qy = paramActionBarContextView;
    this.QV = parama;
    paramContext = new h(paramActionBarContextView.getContext());
    paramContext.Ws = 1;
    this.eq = paramContext;
    this.eq.a(this);
    this.TF = paramBoolean;
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    return this.QV.a(this, paramMenuItem);
  }
  
  public final void b(h paramh)
  {
    invalidate();
    this.Qy.showOverflowMenu();
  }
  
  public final void finish()
  {
    if (this.mFinished) {
      return;
    }
    this.mFinished = true;
    this.Qy.sendAccessibilityEvent(32);
    this.QV.a(this);
  }
  
  public final View getCustomView()
  {
    if (this.QW != null) {
      return (View)this.QW.get();
    }
    return null;
  }
  
  public final Menu getMenu()
  {
    return this.eq;
  }
  
  public final MenuInflater getMenuInflater()
  {
    return new g(this.Qy.getContext());
  }
  
  public final CharSequence getSubtitle()
  {
    return this.Qy.getSubtitle();
  }
  
  public final CharSequence getTitle()
  {
    return this.Qy.getTitle();
  }
  
  public final void invalidate()
  {
    this.QV.b(this, this.eq);
  }
  
  public final boolean isTitleOptional()
  {
    return this.Qy.XK;
  }
  
  public final void setCustomView(View paramView)
  {
    this.Qy.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      this.QW = paramView;
      return;
    }
  }
  
  public final void setSubtitle(int paramInt)
  {
    setSubtitle(this.mContext.getString(paramInt));
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.Qy.setSubtitle(paramCharSequence);
  }
  
  public final void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Qy.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    this.Qy.setTitleOptional(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.e
 * JD-Core Version:    0.7.0.1
 */