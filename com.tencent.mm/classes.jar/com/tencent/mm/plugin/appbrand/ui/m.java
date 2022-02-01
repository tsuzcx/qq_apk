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
public class m
  extends b
  implements w
{
  private View arb;
  private final Bitmap mJu;
  private TextView mJv;
  
  public m(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(48782);
    this.mJu = paramBitmap;
    yL(true);
    setBackground(new BitmapDrawable(getResources(), paramBitmap));
    paramContext = LayoutInflater.from(paramContext).inflate(2131493061, this, false);
    this.arb = paramContext;
    addView(paramContext);
    paramBitmap = (TextView)paramContext.findViewById(2131305902);
    this.mJv = paramBitmap;
    paramBitmap.setText(2131755490);
    paramContext.findViewById(2131301215).setVisibility(8);
    AppMethodBeat.o(48782);
  }
  
  public final void dX(String paramString1, String paramString2) {}
  
  public View getView()
  {
    return this;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(48784);
    super.onDetachedFromWindow();
    this.mJu.recycle();
    AppMethodBeat.o(48784);
  }
  
  public void setProgress(int paramInt) {}
  
  public void setPromptText(String paramString)
  {
    AppMethodBeat.i(223133);
    this.mJv.setText(paramString);
    AppMethodBeat.o(223133);
  }
  
  public void setPromptVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(223132);
    View localView = this.arb;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(223132);
      return;
    }
  }
  
  public final void uD(int paramInt) {}
  
  public void v(final a<z> parama)
  {
    AppMethodBeat.i(223134);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48781);
        final m localm = m.this;
        if ((localm.getParent() instanceof ViewGroup))
        {
          final ViewGroup localViewGroup = (ViewGroup)localm.getParent();
          localm.animate().alpha(0.0F).withEndAction(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48780);
              localm.setVisibility(8);
              localViewGroup.removeView(localm);
              if (m.1.this.mGz != null) {
                m.1.this.mGz.invoke();
              }
              AppMethodBeat.o(48780);
            }
          }).withStartAction(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48779);
              m.a(m.this);
              AppMethodBeat.o(48779);
            }
          }).start();
        }
        AppMethodBeat.o(48781);
      }
    });
    AppMethodBeat.o(223134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.m
 * JD-Core Version:    0.7.0.1
 */