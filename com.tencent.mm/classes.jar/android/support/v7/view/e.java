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
  private h aaQ;
  private b.a aaR;
  private WeakReference<View> aaS;
  private ActionBarContextView aau;
  private boolean adH;
  private Context mContext;
  private boolean mFinished;
  
  public e(Context paramContext, ActionBarContextView paramActionBarContextView, b.a parama, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.aau = paramActionBarContextView;
    this.aaR = parama;
    paramContext = new h(paramActionBarContextView.getContext());
    paramContext.agw = 1;
    this.aaQ = paramContext;
    this.aaQ.a(this);
    this.adH = paramBoolean;
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    return this.aaR.a(this, paramMenuItem);
  }
  
  public final void b(h paramh)
  {
    invalidate();
    this.aau.showOverflowMenu();
  }
  
  public final void finish()
  {
    if (this.mFinished) {
      return;
    }
    this.mFinished = true;
    this.aau.sendAccessibilityEvent(32);
    this.aaR.a(this);
  }
  
  public final View getCustomView()
  {
    if (this.aaS != null) {
      return (View)this.aaS.get();
    }
    return null;
  }
  
  public final Menu getMenu()
  {
    return this.aaQ;
  }
  
  public final MenuInflater getMenuInflater()
  {
    return new g(this.aau.getContext());
  }
  
  public final CharSequence getSubtitle()
  {
    return this.aau.getSubtitle();
  }
  
  public final CharSequence getTitle()
  {
    return this.aau.getTitle();
  }
  
  public final void invalidate()
  {
    this.aaR.b(this, this.aaQ);
  }
  
  public final boolean isTitleOptional()
  {
    return this.aau.ahO;
  }
  
  public final void setCustomView(View paramView)
  {
    this.aau.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      this.aaS = paramView;
      return;
    }
  }
  
  public final void setSubtitle(int paramInt)
  {
    setSubtitle(this.mContext.getString(paramInt));
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.aau.setSubtitle(paramCharSequence);
  }
  
  public final void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.aau.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    this.aau.setTitleOptional(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.e
 * JD-Core Version:    0.7.0.1
 */