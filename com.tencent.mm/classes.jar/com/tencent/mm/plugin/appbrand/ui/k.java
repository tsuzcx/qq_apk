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

@SuppressLint({"ViewConstructor"})
public class k
  extends b
  implements v
{
  private View aoo;
  private final Bitmap lCa;
  private TextView lCb;
  
  public k(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(48782);
    this.lCa = paramBitmap;
    wD(true);
    setBackground(new BitmapDrawable(getResources(), paramBitmap));
    paramContext = LayoutInflater.from(paramContext).inflate(2131493061, this, false);
    this.aoo = paramContext;
    addView(paramContext);
    paramBitmap = (TextView)paramContext.findViewById(2131305902);
    this.lCb = paramBitmap;
    paramBitmap.setText(2131755490);
    paramContext.findViewById(2131301215).setVisibility(8);
    AppMethodBeat.o(48782);
  }
  
  public void bhu()
  {
    AppMethodBeat.i(48783);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48781);
        final k localk = k.this;
        if ((localk.getParent() instanceof ViewGroup))
        {
          final ViewGroup localViewGroup = (ViewGroup)localk.getParent();
          localk.animate().alpha(0.0F).withEndAction(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48780);
              localk.setVisibility(8);
              localViewGroup.removeView(localk);
              AppMethodBeat.o(48780);
            }
          }).withStartAction(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48779);
              k.a(k.this);
              AppMethodBeat.o(48779);
            }
          }).start();
        }
        AppMethodBeat.o(48781);
      }
    });
    AppMethodBeat.o(48783);
  }
  
  public final void dB(String paramString1, String paramString2) {}
  
  public View getView()
  {
    return this;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(48784);
    super.onDetachedFromWindow();
    this.lCa.recycle();
    AppMethodBeat.o(48784);
  }
  
  public void setProgress(int paramInt) {}
  
  public void setPromptText(String paramString)
  {
    AppMethodBeat.i(196189);
    this.lCb.setText(paramString);
    AppMethodBeat.o(196189);
  }
  
  public void setPromptVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(196188);
    View localView = this.aoo;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(196188);
      return;
    }
  }
  
  public final void tc(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.k
 * JD-Core Version:    0.7.0.1
 */