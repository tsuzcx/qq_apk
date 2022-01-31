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
  private ActionBarContextView QQ;
  private b.a Rn;
  private WeakReference<View> Ro;
  private boolean SV;
  private h dm;
  private Context mContext;
  private boolean mFinished;
  
  public e(Context paramContext, ActionBarContextView paramActionBarContextView, b.a parama, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.QQ = paramActionBarContextView;
    this.Rn = parama;
    paramContext = new h(paramActionBarContextView.getContext());
    paramContext.VD = 1;
    this.dm = paramContext;
    this.dm.a(this);
    this.SV = paramBoolean;
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    return this.Rn.a(this, paramMenuItem);
  }
  
  public final void b(h paramh)
  {
    invalidate();
    this.QQ.showOverflowMenu();
  }
  
  public final void finish()
  {
    if (this.mFinished) {
      return;
    }
    this.mFinished = true;
    this.QQ.sendAccessibilityEvent(32);
    this.Rn.a(this);
  }
  
  public final View getCustomView()
  {
    if (this.Ro != null) {
      return (View)this.Ro.get();
    }
    return null;
  }
  
  public final Menu getMenu()
  {
    return this.dm;
  }
  
  public final MenuInflater getMenuInflater()
  {
    return new g(this.QQ.getContext());
  }
  
  public final CharSequence getSubtitle()
  {
    return this.QQ.getSubtitle();
  }
  
  public final CharSequence getTitle()
  {
    return this.QQ.getTitle();
  }
  
  public final void invalidate()
  {
    this.Rn.b(this, this.dm);
  }
  
  public final boolean isTitleOptional()
  {
    return this.QQ.WY;
  }
  
  public final void setCustomView(View paramView)
  {
    this.QQ.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      this.Ro = paramView;
      return;
    }
  }
  
  public final void setSubtitle(int paramInt)
  {
    setSubtitle(this.mContext.getString(paramInt));
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.QQ.setSubtitle(paramCharSequence);
  }
  
  public final void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.QQ.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    this.QQ.setTitleOptional(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.e
 * JD-Core Version:    0.7.0.1
 */