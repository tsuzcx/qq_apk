package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.t;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.a;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.ui.aj;

@SuppressLint({"ViewConstructor"})
public final class ax
  extends FrameLayout
  implements b.a
{
  private v bBK;
  d ixk;
  private b ixl;
  boolean izC;
  
  public ax(Context paramContext, v paramv)
  {
    super(paramContext);
    AppMethodBeat.i(140916);
    this.izC = false;
    this.bBK = paramv;
    paramContext = this.bBK.getPageConfig();
    if (paramContext == null)
    {
      AppMethodBeat.o(140916);
      return;
    }
    if (paramContext.ayo())
    {
      this.ixk = new d(getContext());
      this.ixk.setActuallyVisible(false);
      this.ixl = ((b)this.bBK.iwn.b(getContext(), b.class));
      this.ixl.setFullscreenMode(false);
      this.ixl.fb(false);
      aJX();
      this.ixk.addView(this.ixl);
      addView(this.ixk, -1, -2);
    }
    setBackgroundColor(g.bA(paramContext.hhh, -1));
    AppMethodBeat.o(140916);
  }
  
  private void aJY()
  {
    AppMethodBeat.i(140919);
    if (this.ixl != null)
    {
      if ((getVisibility() == 0) && (t.aw(this)))
      {
        this.ixl.setLoadingIconVisibility(true);
        this.ixk.setActuallyVisible(true);
        AppMethodBeat.o(140919);
        return;
      }
      this.ixl.setLoadingIconVisibility(false);
      this.ixk.setActuallyVisible(false);
    }
    AppMethodBeat.o(140919);
  }
  
  final void aJX()
  {
    AppMethodBeat.i(140917);
    if (this.ixl == null)
    {
      AppMethodBeat.o(140917);
      return;
    }
    if (!TextUtils.isEmpty(this.bBK.getActionBar().getMainTitle())) {
      this.ixl.setMainTitle(this.bBK.getActionBar().getMainTitle());
    }
    for (;;)
    {
      this.ixl.setNavHidden(this.bBK.getActionBar().aOJ());
      AppMethodBeat.o(140917);
      return;
      this.ixl.setMainTitle(getContext().getString(2131296558));
    }
  }
  
  public final void eI(boolean paramBoolean)
  {
    this.izC = paramBoolean;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(140921);
    super.onAttachedToWindow();
    aJY();
    AppMethodBeat.o(140921);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(140922);
    super.onDetachedFromWindow();
    aJY();
    AppMethodBeat.o(140922);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(140918);
    if (paramInt == 0)
    {
      setWillNotDraw(true);
      AppMethodBeat.o(140918);
      return;
    }
    paramInt = 0xFF000000 | paramInt;
    setWillNotDraw(false);
    super.setBackgroundColor(paramInt);
    if (this.ixl != null)
    {
      this.ixl.setBackgroundAlpha(1.0D);
      this.ixl.setBackgroundColor(paramInt);
      if (aj.Ow(paramInt)) {
        break label81;
      }
    }
    for (;;)
    {
      this.ixl.setForegroundStyle(bool);
      AppMethodBeat.o(140918);
      return;
      label81:
      bool = false;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(140920);
    super.setVisibility(paramInt);
    aJY();
    AppMethodBeat.o(140920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ax
 * JD-Core Version:    0.7.0.1
 */