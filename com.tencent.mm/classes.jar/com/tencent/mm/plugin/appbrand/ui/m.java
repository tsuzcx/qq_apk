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
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.ui.statusbar.b;
import kotlin.g.a.a;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public class m
  extends b
  implements aa
{
  private final Bitmap qXV;
  private TextView qXW;
  private View tj;
  
  public m(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(48782);
    this.qXV = paramBitmap;
    GZ(true);
    setBackground(new BitmapDrawable(getResources(), paramBitmap));
    paramContext = LayoutInflater.from(paramContext).inflate(au.g.app_brand_show_toast, this, false);
    this.tj = paramContext;
    addView(paramContext);
    paramBitmap = (TextView)paramContext.findViewById(au.f.title);
    this.qXW = paramBitmap;
    paramBitmap.setText(au.i.app_brand_jsapi_update_app_updating);
    paramContext.findViewById(au.f.iv_icon).setVisibility(8);
    AppMethodBeat.o(48782);
  }
  
  public final void BU(int paramInt) {}
  
  public final void eC(String paramString1, String paramString2) {}
  
  public View getView()
  {
    return this;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(48784);
    super.onDetachedFromWindow();
    this.qXV.recycle();
    AppMethodBeat.o(48784);
  }
  
  public void setProgress(int paramInt) {}
  
  public void setPromptText(String paramString)
  {
    AppMethodBeat.i(267205);
    this.qXW.setText(paramString);
    AppMethodBeat.o(267205);
  }
  
  public void setPromptVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(267204);
    View localView = this.tj;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(267204);
      return;
    }
  }
  
  public void x(final a<x> parama)
  {
    AppMethodBeat.i(267206);
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
              if (m.1.this.qUY != null) {
                m.1.this.qUY.invoke();
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
    AppMethodBeat.o(267206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.m
 * JD-Core Version:    0.7.0.1
 */