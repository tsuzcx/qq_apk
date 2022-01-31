package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.statusbar.b;

public final class g
  extends b
  implements n
{
  private final i fzT;
  private final Bitmap hdM;
  
  public g(Context paramContext, i parami, Bitmap paramBitmap)
  {
    super(paramContext);
    this.hdM = paramBitmap;
    this.fzT = parami;
    setupFullscreen(this.fzT.ZH());
    dN(true);
    setBackground(new BitmapDrawable(getResources(), paramBitmap));
    paramContext = LayoutInflater.from(paramContext).inflate(y.h.app_brand_show_toast, this, false);
    addView(paramContext, new FrameLayout.LayoutParams(-2, -2, 17));
    ((TextView)paramContext.findViewById(y.g.title)).setText(y.j.app_brand_jsapi_update_app_updating);
    paramContext.findViewById(y.g.iv_icon).setVisibility(8);
  }
  
  private void setupFullscreen(boolean paramBoolean)
  {
    Object localObject = l.cx(getContext());
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((Activity)localObject).getWindow();
    } while (localObject == null);
    l.c((Window)localObject, paramBoolean);
  }
  
  public final void a(a.d paramd) {}
  
  public final void aoS()
  {
    post(new g.1(this));
  }
  
  public final void aoT() {}
  
  public final void cd(String paramString1, String paramString2) {}
  
  public final View getView()
  {
    return this;
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.hdM.recycle();
  }
  
  public final void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.g
 * JD-Core Version:    0.7.0.1
 */