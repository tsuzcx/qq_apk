package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.ui.statusbar.b;
import kotlin.g.a.a;

public class p
  extends b
  implements ah
{
  private final Bitmap udX;
  private TextView udY;
  private View uj;
  
  public p(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(48782);
    this.udX = paramBitmap;
    MU(true);
    setBackground(new BitmapDrawable(getResources(), paramBitmap));
    paramContext = LayoutInflater.from(paramContext).inflate(ba.g.app_brand_show_toast, this, false);
    this.uj = paramContext;
    addView(paramContext);
    paramBitmap = (TextView)paramContext.findViewById(ba.f.title);
    this.udY = paramBitmap;
    paramBitmap.setText(ba.i.app_brand_jsapi_update_app_updating);
    paramContext.findViewById(ba.f.iv_icon).setVisibility(8);
    AppMethodBeat.o(48782);
  }
  
  public final void Cj(int paramInt) {}
  
  public void as(final a<kotlin.ah> parama)
  {
    AppMethodBeat.i(322235);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48781);
        final p localp = p.this;
        if ((localp.getParent() instanceof ViewGroup))
        {
          final ViewGroup localViewGroup = (ViewGroup)localp.getParent();
          localp.animate().alpha(0.0F).withEndAction(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48780);
              localp.setVisibility(8);
              localViewGroup.removeView(localp);
              if (p.1.this.uaF != null) {
                p.1.this.uaF.invoke();
              }
              AppMethodBeat.o(48780);
            }
          }).withStartAction(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48779);
              p.a(p.this);
              AppMethodBeat.o(48779);
            }
          }).start();
        }
        AppMethodBeat.o(48781);
      }
    });
    AppMethodBeat.o(322235);
  }
  
  public final void eT(String paramString1, String paramString2) {}
  
  public View getView()
  {
    return this;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(48784);
    super.onDetachedFromWindow();
    this.udX.recycle();
    AppMethodBeat.o(48784);
  }
  
  public void setProgress(int paramInt) {}
  
  public void setPromptText(String paramString)
  {
    AppMethodBeat.i(322225);
    this.udY.setText(paramString);
    AppMethodBeat.o(322225);
  }
  
  public void setPromptVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(322220);
    View localView = this.uj;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(322220);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.p
 * JD-Core Version:    0.7.0.1
 */