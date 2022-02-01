package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.widget.ActionBarContextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class e
  extends b
  implements h.a
{
  private ActionBarContextView hT;
  private h is;
  private b.a it;
  private WeakReference<View> iu;
  private boolean jO;
  private Context mContext;
  private boolean mFinished;
  
  public e(Context paramContext, ActionBarContextView paramActionBarContextView, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(238909);
    this.mContext = paramContext;
    this.hT = paramActionBarContextView;
    this.it = parama;
    paramContext = new h(paramActionBarContextView.getContext());
    paramContext.mG = 1;
    this.is = paramContext;
    this.is.a(this);
    this.jO = paramBoolean;
    AppMethodBeat.o(238909);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(238934);
    invalidate();
    this.hT.cC();
    AppMethodBeat.o(238934);
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(238932);
    boolean bool = this.it.a(this, paramMenuItem);
    AppMethodBeat.o(238932);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(238922);
    if (this.mFinished)
    {
      AppMethodBeat.o(238922);
      return;
    }
    this.mFinished = true;
    this.hT.sendAccessibilityEvent(32);
    this.it.a(this);
    AppMethodBeat.o(238922);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(238928);
    if (this.iu != null)
    {
      View localView = (View)this.iu.get();
      AppMethodBeat.o(238928);
      return localView;
    }
    AppMethodBeat.o(238928);
    return null;
  }
  
  public final Menu getMenu()
  {
    return this.is;
  }
  
  public final MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(238930);
    g localg = new g(this.hT.getContext());
    AppMethodBeat.o(238930);
    return localg;
  }
  
  public final CharSequence getSubtitle()
  {
    AppMethodBeat.i(238927);
    CharSequence localCharSequence = this.hT.getSubtitle();
    AppMethodBeat.o(238927);
    return localCharSequence;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(238925);
    CharSequence localCharSequence = this.hT.getTitle();
    AppMethodBeat.o(238925);
    return localCharSequence;
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(238920);
    this.it.b(this, this.is);
    AppMethodBeat.o(238920);
  }
  
  public final boolean isTitleOptional()
  {
    return this.hT.oc;
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(238919);
    this.hT.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      this.iu = paramView;
      AppMethodBeat.o(238919);
      return;
    }
  }
  
  public final void setSubtitle(int paramInt)
  {
    AppMethodBeat.i(238916);
    setSubtitle(this.mContext.getString(paramInt));
    AppMethodBeat.o(238916);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(238913);
    this.hT.setSubtitle(paramCharSequence);
    AppMethodBeat.o(238913);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(238914);
    setTitle(this.mContext.getString(paramInt));
    AppMethodBeat.o(238914);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(238911);
    this.hT.setTitle(paramCharSequence);
    AppMethodBeat.o(238911);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    AppMethodBeat.i(238917);
    super.setTitleOptionalHint(paramBoolean);
    this.hT.setTitleOptional(paramBoolean);
    AppMethodBeat.o(238917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.e
 * JD-Core Version:    0.7.0.1
 */