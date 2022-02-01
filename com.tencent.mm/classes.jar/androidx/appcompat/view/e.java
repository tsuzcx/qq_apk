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
  private ActionBarContextView iR;
  private h jo;
  private b.a jp;
  private WeakReference<View> jq;
  private boolean kK;
  private Context mContext;
  private boolean mFinished;
  
  public e(Context paramContext, ActionBarContextView paramActionBarContextView, b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(200657);
    this.mContext = paramContext;
    this.iR = paramActionBarContextView;
    this.jp = parama;
    paramContext = new h(paramActionBarContextView.getContext());
    paramContext.nF = 1;
    this.jo = paramContext;
    this.jo.a(this);
    this.kK = paramBoolean;
    AppMethodBeat.o(200657);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(200818);
    invalidate();
    this.iR.dv();
    AppMethodBeat.o(200818);
  }
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(200808);
    boolean bool = this.jp.a(this, paramMenuItem);
    AppMethodBeat.o(200808);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(200740);
    if (this.mFinished)
    {
      AppMethodBeat.o(200740);
      return;
    }
    this.mFinished = true;
    this.iR.sendAccessibilityEvent(32);
    this.jp.a(this);
    AppMethodBeat.o(200740);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(200783);
    if (this.jq != null)
    {
      View localView = (View)this.jq.get();
      AppMethodBeat.o(200783);
      return localView;
    }
    AppMethodBeat.o(200783);
    return null;
  }
  
  public final Menu getMenu()
  {
    return this.jo;
  }
  
  public final MenuInflater getMenuInflater()
  {
    AppMethodBeat.i(200797);
    g localg = new g(this.iR.getContext());
    AppMethodBeat.o(200797);
    return localg;
  }
  
  public final CharSequence getSubtitle()
  {
    AppMethodBeat.i(200775);
    CharSequence localCharSequence = this.iR.getSubtitle();
    AppMethodBeat.o(200775);
    return localCharSequence;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(200761);
    CharSequence localCharSequence = this.iR.getTitle();
    AppMethodBeat.o(200761);
    return localCharSequence;
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(200729);
    this.jp.b(this, this.jo);
    AppMethodBeat.o(200729);
  }
  
  public final boolean isTitleOptional()
  {
    return this.iR.pb;
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(200720);
    this.iR.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      this.jq = paramView;
      AppMethodBeat.o(200720);
      return;
    }
  }
  
  public final void setSubtitle(int paramInt)
  {
    AppMethodBeat.i(200692);
    setSubtitle(this.mContext.getString(paramInt));
    AppMethodBeat.o(200692);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200671);
    this.iR.setSubtitle(paramCharSequence);
    AppMethodBeat.o(200671);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(200685);
    setTitle(this.mContext.getString(paramInt));
    AppMethodBeat.o(200685);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200665);
    this.iR.setTitle(paramCharSequence);
    AppMethodBeat.o(200665);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    AppMethodBeat.i(200704);
    super.setTitleOptionalHint(paramBoolean);
    this.iR.setTitleOptional(paramBoolean);
    AppMethodBeat.o(200704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.e
 * JD-Core Version:    0.7.0.1
 */