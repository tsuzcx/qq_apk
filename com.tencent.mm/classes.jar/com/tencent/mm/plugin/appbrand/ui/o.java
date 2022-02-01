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
import kotlin.g.a.a;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public class o
  extends b
  implements ab
{
  private View arn;
  private final Bitmap nWt;
  private TextView nWu;
  
  public o(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(48782);
    this.nWt = paramBitmap;
    CF(true);
    setBackground(new BitmapDrawable(getResources(), paramBitmap));
    paramContext = LayoutInflater.from(paramContext).inflate(2131493100, this, false);
    this.arn = paramContext;
    addView(paramContext);
    paramBitmap = (TextView)paramContext.findViewById(2131309195);
    this.nWu = paramBitmap;
    paramBitmap.setText(2131755528);
    paramContext.findViewById(2131302896).setVisibility(8);
    AppMethodBeat.o(48782);
  }
  
  public final void eo(String paramString1, String paramString2) {}
  
  public View getView()
  {
    return this;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(48784);
    super.onDetachedFromWindow();
    this.nWt.recycle();
    AppMethodBeat.o(48784);
  }
  
  public void setProgress(int paramInt) {}
  
  public void setPromptText(String paramString)
  {
    AppMethodBeat.i(227667);
    this.nWu.setText(paramString);
    AppMethodBeat.o(227667);
  }
  
  public void setPromptVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(227666);
    View localView = this.arn;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(227666);
      return;
    }
  }
  
  public final void yu(int paramInt) {}
  
  public void z(final a<x> parama)
  {
    AppMethodBeat.i(227668);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48781);
        final o localo = o.this;
        if ((localo.getParent() instanceof ViewGroup))
        {
          final ViewGroup localViewGroup = (ViewGroup)localo.getParent();
          localo.animate().alpha(0.0F).withEndAction(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48780);
              localo.setVisibility(8);
              localViewGroup.removeView(localo);
              if (o.1.this.nTx != null) {
                o.1.this.nTx.invoke();
              }
              AppMethodBeat.o(48780);
            }
          }).withStartAction(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48779);
              o.a(o.this);
              AppMethodBeat.o(48779);
            }
          }).start();
        }
        AppMethodBeat.o(48781);
      }
    });
    AppMethodBeat.o(227668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.o
 * JD-Core Version:    0.7.0.1
 */