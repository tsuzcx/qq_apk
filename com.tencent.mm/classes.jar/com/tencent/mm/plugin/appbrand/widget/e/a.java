package com.tencent.mm.plugin.appbrand.widget.e;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
  extends FrameLayout
  implements View.OnClickListener, f
{
  private final Runnable hBN = new a.1(this);
  private ViewPropertyAnimator hBO;
  ViewPropertyAnimator hBP;
  private TextView hoV;
  private final ah mHandler = new ah(Looper.getMainLooper());
  
  public a(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(a.e.app_brand_show_no_icon_toast, this, true);
    this.hoV = ((TextView)findViewById(a.d.title));
    setOnClickListener(this);
  }
  
  public final void a(FrameLayout paramFrameLayout)
  {
    paramFrameLayout.addView(this, new FrameLayout.LayoutParams(-2, -2, 17));
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void onClick(View paramView) {}
  
  public final void xk(String paramString)
  {
    this.hoV.setText(paramString);
    this.mHandler.removeCallbacks(this.hBN);
    this.mHandler.postDelayed(this.hBN, hBV);
    if ((getAlpha() == 1.0F) || (this.hBO != null)) {
      return;
    }
    setVisibility(0);
    animate().cancel();
    paramString = animate();
    this.hBO = paramString;
    paramString.alpha(1.0F).setListener(new a.2(this)).start();
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.a
 * JD-Core Version:    0.7.0.1
 */