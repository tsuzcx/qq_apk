package com.tencent.mm.plugin.appbrand.aa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.ui.w;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.d;
import com.tencent.mm.sdk.platformtools.ae;
import d.z;

@SuppressLint({"ViewConstructor"})
public final class b
  extends FrameLayout
  implements w
{
  private AppBrandRuntime jDb;
  private ImageView mWF;
  private View mWJ;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b mWK;
  
  public b(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    AppMethodBeat.i(49339);
    this.jDb = paramAppBrandRuntime;
    setClickable(true);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131493064, this);
    this.mWJ = findViewById(2131305152);
    this.mWF = ((ImageView)findViewById(2131305792));
    paramContext = (LinearLayout)findViewById(2131296767);
    this.mWK = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(getContext());
    this.mWK.setFullscreenMode(true);
    paramContext.addView(this.mWK.getActionView());
    this.mWK.setNavResetStyleListener(new b.d()
    {
      public final void a(ImageView paramAnonymousImageView, View paramAnonymousView1, View paramAnonymousView2)
      {
        AppMethodBeat.i(49334);
        if (paramAnonymousImageView != null)
        {
          paramAnonymousImageView.clearColorFilter();
          paramAnonymousImageView.setImageDrawable(com.tencent.mm.svg.a.a.g(b.this.getContext().getResources(), 2131689682));
          paramAnonymousView2 = paramAnonymousImageView.getLayoutParams();
          paramAnonymousView2.height = -1;
          paramAnonymousView2.width = -2;
          paramAnonymousImageView.setLayoutParams(paramAnonymousView2);
        }
        if (paramAnonymousView1 != null) {
          paramAnonymousView1.setBackground(null);
        }
        AppMethodBeat.o(49334);
      }
      
      public final int bvI()
      {
        return mZd;
      }
    });
    this.mWK.setFullscreenMode(true);
    this.mWK.setForegroundStyle(false);
    this.mWK.fE(false);
    this.mWK.fC(true);
    this.mWK.setBackButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49335);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/weishi/AppBrandThumbLoadingSplash$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.AppBrandThumbLoadingSplash", "splash click close button");
        g.bCN();
        if (b.a(b.this) != null)
        {
          h.a(b.a(b.this).mAppId, h.d.jzh);
          b.a(b.this).close();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/weishi/AppBrandThumbLoadingSplash$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(49335);
      }
    });
    g.a(this.jDb, this.mWF);
    AppMethodBeat.o(49339);
  }
  
  public final void dX(String paramString1, String paramString2) {}
  
  public final View getView()
  {
    return this;
  }
  
  public final void setProgress(int paramInt) {}
  
  public final void uD(int paramInt) {}
  
  public final void v(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(223178);
    post(new b.3(this, parama));
    AppMethodBeat.o(223178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.b
 * JD-Core Version:    0.7.0.1
 */