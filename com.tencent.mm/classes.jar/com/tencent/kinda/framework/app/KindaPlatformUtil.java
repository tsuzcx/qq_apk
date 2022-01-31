package com.tencent.kinda.framework.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.AndroidDpiLevel;
import com.tencent.kinda.gen.IOSDevice;
import com.tencent.kinda.gen.IPlatformUtil;
import com.tencent.kinda.gen.Platform;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;

public class KindaPlatformUtil
  implements IPlatformUtil
{
  private final String TAG;
  private final c checkLanguageChangeIListener;
  private VoidStringCallback languageChangeCallback;
  
  public KindaPlatformUtil()
  {
    AppMethodBeat.i(144385);
    this.languageChangeCallback = null;
    this.TAG = "KindaPlatformUtil";
    this.checkLanguageChangeIListener = new KindaPlatformUtil.1(this);
    AppMethodBeat.o(144385);
  }
  
  private float getDensity(Context paramContext)
  {
    AppMethodBeat.i(144394);
    if (paramContext != null)
    {
      float f = paramContext.getResources().getDisplayMetrics().density;
      AppMethodBeat.o(144394);
      return f;
    }
    AppMethodBeat.o(144394);
    return 0.0F;
  }
  
  public int androidAPILevel()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public AndroidDpiLevel androidDpiLevel()
  {
    return AndroidDpiLevel.UNKNOWN;
  }
  
  public String currentLanguageCode()
  {
    AppMethodBeat.i(144387);
    String str = aa.gP(ah.getContext());
    AppMethodBeat.o(144387);
    return str;
  }
  
  public Platform currentPlatform()
  {
    return Platform.ANDROID;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(144386);
    com.tencent.mm.sdk.b.a.ymk.d(this.checkLanguageChangeIListener);
    AppMethodBeat.o(144386);
  }
  
  public float getBottomSafeAreaHeight()
  {
    return 0.0F;
  }
  
  public boolean getExptBoolValue(String paramString)
  {
    AppMethodBeat.i(144395);
    boolean bool = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.LZ(paramString), false);
    AppMethodBeat.o(144395);
    return bool;
  }
  
  public float getLoigcalResolutionHeight()
  {
    AppMethodBeat.i(144391);
    if (KindaContext.get() != null)
    {
      DisplayMetrics localDisplayMetrics = KindaContext.get().getResources().getDisplayMetrics();
      float f = localDisplayMetrics.heightPixels / localDisplayMetrics.density;
      AppMethodBeat.o(144391);
      return f;
    }
    AppMethodBeat.o(144391);
    return 0.0F;
  }
  
  public float getLoigcalResolutionWidth()
  {
    AppMethodBeat.i(144390);
    if (KindaContext.get() != null)
    {
      DisplayMetrics localDisplayMetrics = KindaContext.get().getResources().getDisplayMetrics();
      float f = localDisplayMetrics.widthPixels / localDisplayMetrics.density;
      AppMethodBeat.o(144390);
      return f;
    }
    AppMethodBeat.o(144390);
    return 0.0F;
  }
  
  public float getNavigationBarHeight()
  {
    AppMethodBeat.i(144393);
    if (KindaContext.get() != null)
    {
      Context localContext = KindaContext.get();
      if (!(localContext instanceof MMActivity))
      {
        ab.e("KindaPlatformUtil", "KindaContext.get() is not MMActivity, is %s.", new Object[] { localContext.getClass().getName() });
        AppMethodBeat.o(144393);
        return 0.0F;
      }
      float f = com.tencent.mm.compatible.util.a.p((MMActivity)localContext) / getDensity(localContext);
      AppMethodBeat.o(144393);
      return f;
    }
    AppMethodBeat.o(144393);
    return 0.0F;
  }
  
  public String getPlatformString(String paramString)
  {
    return null;
  }
  
  public float getPx(float paramFloat)
  {
    AppMethodBeat.i(144389);
    if (KindaContext.get() != null)
    {
      paramFloat /= KindaContext.get().getResources().getDisplayMetrics().density;
      AppMethodBeat.o(144389);
      return paramFloat;
    }
    AppMethodBeat.o(144389);
    return paramFloat;
  }
  
  public float getStatusBarHeight()
  {
    AppMethodBeat.i(144392);
    if (KindaContext.get() != null)
    {
      Context localContext = KindaContext.get();
      if (!(localContext instanceof MMActivity))
      {
        ab.e("KindaPlatformUtil", "KindaContext.get() is not MMActivity, is %s.", new Object[] { localContext.getClass().getName() });
        AppMethodBeat.o(144392);
        return 0.0F;
      }
      MMActivity localMMActivity = (MMActivity)localContext;
      Rect localRect = new Rect();
      localMMActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      float f = localRect.top / getDensity(localContext);
      AppMethodBeat.o(144392);
      return f;
    }
    AppMethodBeat.o(144392);
    return 0.0F;
  }
  
  public IOSDevice iOSDevice()
  {
    return IOSDevice.UNKNOWN;
  }
  
  public String iOSVersion()
  {
    return null;
  }
  
  public void setLanguageChangeCallbackImpl(VoidStringCallback paramVoidStringCallback)
  {
    AppMethodBeat.i(144388);
    this.languageChangeCallback = paramVoidStringCallback;
    com.tencent.mm.sdk.b.a.ymk.c(this.checkLanguageChangeIListener);
    AppMethodBeat.o(144388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaPlatformUtil
 * JD-Core Version:    0.7.0.1
 */