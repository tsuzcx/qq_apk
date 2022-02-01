package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.b;
import d.g.a.a;
import d.z;

@SuppressLint({"ViewConstructor"})
public class l
  extends b
  implements v
{
  private View arb;
  private final Bitmap mEp;
  private TextView mEq;
  
  public l(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(48782);
    this.mEp = paramBitmap;
    yy(true);
    setBackground(new BitmapDrawable(getResources(), paramBitmap));
    paramContext = LayoutInflater.from(paramContext).inflate(2131493061, this, false);
    this.arb = paramContext;
    addView(paramContext);
    paramBitmap = (TextView)paramContext.findViewById(2131305902);
    this.mEq = paramBitmap;
    paramBitmap.setText(2131755490);
    paramContext.findViewById(2131301215).setVisibility(8);
    AppMethodBeat.o(48782);
  }
  
  public final void dV(String paramString1, String paramString2) {}
  
  public View getView()
  {
    return this;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(48784);
    super.onDetachedFromWindow();
    this.mEp.recycle();
    AppMethodBeat.o(48784);
  }
  
  public void setProgress(int paramInt) {}
  
  public void setPromptText(String paramString)
  {
    AppMethodBeat.i(188900);
    this.mEq.setText(paramString);
    AppMethodBeat.o(188900);
  }
  
  public void setPromptVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(188899);
    View localView = this.arb;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(188899);
      return;
    }
  }
  
  public void u(final a<z> parama)
  {
    AppMethodBeat.i(188901);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48781);
        final l locall = l.this;
        if ((locall.getParent() instanceof ViewGroup))
        {
          final ViewGroup localViewGroup = (ViewGroup)locall.getParent();
          locall.animate().alpha(0.0F).withEndAction(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48780);
              locall.setVisibility(8);
              localViewGroup.removeView(locall);
              if (l.1.this.mBu != null) {
                l.1.this.mBu.invoke();
              }
              AppMethodBeat.o(48780);
            }
          }).withStartAction(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48779);
              l.a(l.this);
              AppMethodBeat.o(48779);
            }
          }).start();
        }
        AppMethodBeat.o(48781);
      }
    });
    AppMethodBeat.o(188901);
  }
  
  public final void ux(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.l
 * JD-Core Version:    0.7.0.1
 */