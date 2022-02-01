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
  private h YO;
  private b.a YP;
  private WeakReference<View> YQ;
  private ActionBarContextView Ys;
  private boolean abD;
  private Context mContext;
  private boolean mFinished;
  
  public e(Context paramContext, ActionBarContextView paramActionBarContextView, b.a parama, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.Ys = paramActionBarContextView;
    this.YP = parama;
    paramContext = new h(paramActionBarContextView.getContext());
    paramContext.aes = 1;
    this.YO = paramContext;
    this.YO.a(this);
    this.abD = paramBoolean;
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    return this.YP.a(this, paramMenuItem);
  }
  
  public final void b(h paramh)
  {
    invalidate();
    this.Ys.showOverflowMenu();
  }
  
  public final void finish()
  {
    if (this.mFinished) {
      return;
    }
    this.mFinished = true;
    this.Ys.sendAccessibilityEvent(32);
    this.YP.a(this);
  }
  
  public final View getCustomView()
  {
    if (this.YQ != null) {
      return (View)this.YQ.get();
    }
    return null;
  }
  
  public final Menu getMenu()
  {
    return this.YO;
  }
  
  public final MenuInflater getMenuInflater()
  {
    return new g(this.Ys.getContext());
  }
  
  public final CharSequence getSubtitle()
  {
    return this.Ys.getSubtitle();
  }
  
  public final CharSequence getTitle()
  {
    return this.Ys.getTitle();
  }
  
  public final void invalidate()
  {
    this.YP.b(this, this.YO);
  }
  
  public final boolean isTitleOptional()
  {
    return this.Ys.afK;
  }
  
  public final void setCustomView(View paramView)
  {
    this.Ys.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      this.YQ = paramView;
      return;
    }
  }
  
  public final void setSubtitle(int paramInt)
  {
    setSubtitle(this.mContext.getString(paramInt));
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.Ys.setSubtitle(paramCharSequence);
  }
  
  public final void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Ys.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    this.Ys.setTitleOptional(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.e
 * JD-Core Version:    0.7.0.1
 */