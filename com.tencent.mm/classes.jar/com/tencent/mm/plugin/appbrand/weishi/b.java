package com.tencent.mm.plugin.appbrand.weishi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.launching.params.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@SuppressLint({"ViewConstructor"})
public final class b
  extends FrameLayout
  implements r
{
  private i gRG;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b iLW;
  private ImageView jab;
  private View jae;
  
  public b(Context paramContext, i parami)
  {
    super(paramContext);
    AppMethodBeat.i(133630);
    this.gRG = parami;
    setClickable(true);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2130968741, this);
    this.jae = findViewById(2131821419);
    this.jab = ((ImageView)findViewById(2131821245));
    paramContext = (LinearLayout)findViewById(2131821420);
    this.iLW = f.a.dl(getContext());
    paramContext.addView(this.iLW.getActionView());
    this.iLW.setNavResetStyleListener(new b.1(this));
    this.iLW.setFullscreenMode(true);
    this.iLW.setForegroundStyle(false);
    this.iLW.fb(false);
    this.iLW.aOM();
    this.iLW.setBackButtonClickListener(new b.2(this));
    a(this.gRG, this.jab, null);
    AppMethodBeat.o(133630);
  }
  
  private static void a(ImageView paramImageView, String paramString1, String paramString2, Runnable paramRunnable)
  {
    AppMethodBeat.i(143618);
    ab.i("MicroMsg.AppBrandThumbLoadingSplash", "loadThumbImage:%s", new Object[] { paramString1 });
    com.tencent.mm.modelappbrand.a.b.acD().a(new b.3(paramImageView, paramRunnable, paramString2), paramString1, null, null);
    AppMethodBeat.o(143618);
  }
  
  public static void a(i parami, ImageView paramImageView, Runnable paramRunnable)
  {
    AppMethodBeat.i(143617);
    if ((parami.wZ() instanceof AppBrandInitConfigLU))
    {
      Object localObject = (AppBrandInitConfigLU)parami.wZ();
      parami = ((AppBrandInitConfigLU)localObject).bDa.thumbUrl;
      localObject = ((AppBrandInitConfigLU)localObject).bDa.inD;
      ab.i("MicroMsg.AppBrandThumbLoadingSplash", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", new Object[] { parami, localObject });
      if (!bo.isNullOrNil(parami))
      {
        a(paramImageView, parami, "file://".concat(String.valueOf(localObject)), paramRunnable);
        AppMethodBeat.o(143617);
        return;
      }
      if (!bo.isNullOrNil((String)localObject)) {
        a(paramImageView, "file://".concat(String.valueOf(localObject)), null, paramRunnable);
      }
    }
    AppMethodBeat.o(143617);
  }
  
  public final void aHA()
  {
    AppMethodBeat.i(133632);
    post(new b.4(this));
    AppMethodBeat.o(133632);
  }
  
  public final void aHB() {}
  
  public final void cD(String paramString1, String paramString2) {}
  
  public final View getView()
  {
    return this;
  }
  
  public final void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.b
 * JD-Core Version:    0.7.0.1
 */