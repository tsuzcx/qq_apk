package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.AndroidDpiLevel;
import com.tencent.kinda.gen.IOSDevice;
import com.tencent.kinda.gen.IPlatformUtil;
import com.tencent.kinda.gen.Platform;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;

public class KindaPlatformUtil
  implements IPlatformUtil
{
  private final String TAG;
  private final com.tencent.mm.sdk.b.c checkLanguageChangeIListener;
  private VoidStringCallback languageChangeCallback;
  private WindowManager.LayoutParams mWindowParams;
  
  public KindaPlatformUtil()
  {
    AppMethodBeat.i(18471);
    this.languageChangeCallback = null;
    this.TAG = "KindaPlatformUtil";
    this.checkLanguageChangeIListener = new com.tencent.mm.sdk.b.c()
    {
      public boolean callback(bi paramAnonymousbi)
      {
        AppMethodBeat.i(18469);
        if (KindaPlatformUtil.this.languageChangeCallback != null) {
          KindaPlatformUtil.this.languageChangeCallback.call(KindaPlatformUtil.this.currentLanguageCode());
        }
        AppMethodBeat.o(18469);
        return true;
      }
    };
    AppMethodBeat.o(18471);
  }
  
  private float getDensity(Context paramContext)
  {
    AppMethodBeat.i(18481);
    if (paramContext != null)
    {
      float f = paramContext.getResources().getDisplayMetrics().density;
      AppMethodBeat.o(18481);
      return f;
    }
    AppMethodBeat.o(18481);
    return 0.0F;
  }
  
  private ah.a[] getRedDotKey(String paramString)
  {
    AppMethodBeat.i(18472);
    ah.a locala;
    if (paramString.equals("receipt"))
    {
      paramString = ah.a.GPo;
      locala = ah.a.GOj;
      AppMethodBeat.o(18472);
      return new ah.a[] { paramString, locala };
    }
    if (paramString.equals("reward"))
    {
      paramString = ah.a.GPq;
      locala = ah.a.GOj;
      AppMethodBeat.o(18472);
      return new ah.a[] { paramString, locala };
    }
    if (paramString.equals("groupaa"))
    {
      paramString = ah.a.GPn;
      locala = ah.a.GOj;
      AppMethodBeat.o(18472);
      return new ah.a[] { paramString, locala };
    }
    if (paramString.equals("faceHongBao"))
    {
      paramString = ah.a.GPp;
      locala = ah.a.GOj;
      AppMethodBeat.o(18472);
      return new ah.a[] { paramString, locala };
    }
    if (paramString.equals("transferBank"))
    {
      paramString = ah.a.GPr;
      locala = ah.a.GOj;
      AppMethodBeat.o(18472);
      return new ah.a[] { paramString, locala };
    }
    AppMethodBeat.o(18472);
    return null;
  }
  
  private void initWindowParamsIfNeed()
  {
    AppMethodBeat.i(18498);
    if (this.mWindowParams == null)
    {
      Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
      if (localActivity != null)
      {
        this.mWindowParams = localActivity.getWindow().getAttributes();
        AppMethodBeat.o(18498);
        return;
      }
      ac.e("KindaPlatformUtil", "KindaContext.getTopOrUIPageFragmentActivity return null, so can't initWindowParamsIfNeed!");
    }
    AppMethodBeat.o(18498);
  }
  
  public int androidAPILevel()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public AndroidDpiLevel androidDpiLevel()
  {
    return AndroidDpiLevel.UNKNOWN;
  }
  
  public byte[] base64Decode(String paramString)
  {
    AppMethodBeat.i(18495);
    paramString = Base64.decode(paramString, 0);
    AppMethodBeat.o(18495);
    return paramString;
  }
  
  public String base64Encode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18496);
    paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 0);
    AppMethodBeat.o(18496);
    return paramArrayOfByte;
  }
  
  public void beginIgnoringInteractionEvents() {}
  
  public String currentLanguageCode()
  {
    AppMethodBeat.i(18474);
    String str = ab.iC(ai.getContext());
    AppMethodBeat.o(18474);
    return str;
  }
  
  public Platform currentPlatform()
  {
    return Platform.ANDROID;
  }
  
  public void endIgnoringInteractionEvents() {}
  
  protected void finalize()
  {
    AppMethodBeat.i(18473);
    com.tencent.mm.sdk.b.a.GpY.d(this.checkLanguageChangeIListener);
    AppMethodBeat.o(18473);
  }
  
  public String genUUID()
  {
    AppMethodBeat.i(18494);
    String str = q.XX();
    AppMethodBeat.o(18494);
    return str;
  }
  
  public float getBottomSafeAreaHeight()
  {
    return 0.0F;
  }
  
  public boolean getExptBoolValue(String paramString)
  {
    AppMethodBeat.i(18482);
    paramString = b.cmk().b(paramString, "", false, false);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(18482);
      return false;
    }
    if (bs.getInt(paramString, 0) != 0)
    {
      AppMethodBeat.o(18482);
      return true;
    }
    AppMethodBeat.o(18482);
    return false;
  }
  
  public float getIphoneSafeAreaBottomHeight()
  {
    return 0.0F;
  }
  
  public float getLoigcalResolutionHeight()
  {
    AppMethodBeat.i(18478);
    if (KindaContext.get() != null)
    {
      DisplayMetrics localDisplayMetrics = KindaContext.get().getResources().getDisplayMetrics();
      float f = localDisplayMetrics.heightPixels / localDisplayMetrics.density;
      AppMethodBeat.o(18478);
      return f;
    }
    AppMethodBeat.o(18478);
    return 0.0F;
  }
  
  public float getLoigcalResolutionWidth()
  {
    AppMethodBeat.i(18477);
    if (KindaContext.get() != null)
    {
      DisplayMetrics localDisplayMetrics = KindaContext.get().getResources().getDisplayMetrics();
      float f = localDisplayMetrics.widthPixels / localDisplayMetrics.density;
      AppMethodBeat.o(18477);
      return f;
    }
    AppMethodBeat.o(18477);
    return 0.0F;
  }
  
  public String getMemoryKVString(String paramString)
  {
    return "";
  }
  
  public float getNavigationBarHeight()
  {
    AppMethodBeat.i(18480);
    if (KindaContext.get() != null)
    {
      Context localContext = KindaContext.get();
      if (!(localContext instanceof MMActivity))
      {
        ac.e("KindaPlatformUtil", "KindaContext.get() is not MMActivity, is %s.", new Object[] { localContext.getClass().getName() });
        AppMethodBeat.o(18480);
        return 0.0F;
      }
      float f = com.tencent.mm.compatible.util.a.u((MMActivity)localContext) / getDensity(localContext);
      AppMethodBeat.o(18480);
      return f;
    }
    AppMethodBeat.o(18480);
    return 0.0F;
  }
  
  public float getPadSplitHeight()
  {
    AppMethodBeat.i(18489);
    float f = getLoigcalResolutionHeight();
    AppMethodBeat.o(18489);
    return f;
  }
  
  public float getPadSplitWidth()
  {
    AppMethodBeat.i(18488);
    float f = getLoigcalResolutionWidth();
    AppMethodBeat.o(18488);
    return f;
  }
  
  public String getPlatformString(String paramString)
  {
    return "";
  }
  
  public float getPx(float paramFloat)
  {
    AppMethodBeat.i(18476);
    if (KindaContext.get() != null)
    {
      paramFloat /= KindaContext.get().getResources().getDisplayMetrics().density;
      AppMethodBeat.o(18476);
      return paramFloat;
    }
    AppMethodBeat.o(18476);
    return paramFloat;
  }
  
  public boolean getRedDotStatus(String paramString)
  {
    AppMethodBeat.i(18484);
    paramString = getRedDotKey(paramString);
    if (paramString != null)
    {
      boolean bool = com.tencent.mm.y.c.aeH().b(paramString[0], paramString[1]);
      AppMethodBeat.o(18484);
      return bool;
    }
    AppMethodBeat.o(18484);
    return false;
  }
  
  public String getRedDotWording(String paramString)
  {
    AppMethodBeat.i(18485);
    if (paramString.equals("receipt"))
    {
      g.agS();
      paramString = (String)g.agR().agA().get(ah.a.GOD, "");
      AppMethodBeat.o(18485);
      return paramString;
    }
    AppMethodBeat.o(18485);
    return null;
  }
  
  public float getScreenBrightness()
  {
    AppMethodBeat.i(18491);
    initWindowParamsIfNeed();
    if (this.mWindowParams != null)
    {
      float f = this.mWindowParams.screenBrightness;
      AppMethodBeat.o(18491);
      return f;
    }
    AppMethodBeat.o(18491);
    return 0.0F;
  }
  
  public float getStatusBarHeight()
  {
    AppMethodBeat.i(18479);
    if (KindaContext.get() != null)
    {
      float f = aj.ji(KindaContext.get());
      AppMethodBeat.o(18479);
      return f;
    }
    AppMethodBeat.o(18479);
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
  
  public boolean isNetworkConnected()
  {
    AppMethodBeat.i(18497);
    boolean bool = ax.isNetworkConnected(ai.getContext());
    AppMethodBeat.o(18497);
    return bool;
  }
  
  public boolean isPad()
  {
    return false;
  }
  
  public void makesureLonglink()
  {
    AppMethodBeat.i(18493);
    com.tencent.mm.wallet_core.ui.e.fAQ();
    AppMethodBeat.o(18493);
  }
  
  public String md5(String paramString)
  {
    AppMethodBeat.i(18483);
    paramString = ah.dg(paramString);
    AppMethodBeat.o(18483);
    return paramString;
  }
  
  public void playVibration()
  {
    AppMethodBeat.i(18490);
    try
    {
      Object localObject = KindaContext.get();
      if (localObject == null)
      {
        ac.e("KindaPlatformUtil", "KindaContext get null while playVibration!");
        AppMethodBeat.o(18490);
        return;
      }
      localObject = (Vibrator)((Context)localObject).getSystemService("vibrator");
      if (localObject == null)
      {
        ac.e("KindaPlatformUtil", "playVibration call getSystemService get null!");
        AppMethodBeat.o(18490);
        return;
      }
      ((Vibrator)localObject).vibrate(15L);
      AppMethodBeat.o(18490);
      return;
    }
    catch (Exception localException)
    {
      ac.e("KindaPlatformUtil", "playVibration exception %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(18490);
    }
  }
  
  public void setIdleTimerDisable(boolean paramBoolean) {}
  
  public void setLanguageChangeCallbackImpl(VoidStringCallback paramVoidStringCallback)
  {
    AppMethodBeat.i(18475);
    this.languageChangeCallback = paramVoidStringCallback;
    com.tencent.mm.sdk.b.a.GpY.c(this.checkLanguageChangeIListener);
    AppMethodBeat.o(18475);
  }
  
  public void setRedDotStatus(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(18486);
    paramString = getRedDotKey(paramString);
    if ((paramString != null) && (!paramBoolean)) {
      com.tencent.mm.y.c.aeH().c(paramString[0], paramString[1]);
    }
    AppMethodBeat.o(18486);
  }
  
  public void setReportLocationState(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(18502);
    ac.i("KindaPlatformUtil", "setLocationState, set wifiSsidState as: [%b], set cellInfoState as [%b].", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    ak localak = s.ery().esi();
    ac.i("MicroMsg.WalletSwitchConfig", "setReportLocation, set wifiSsidState as: [%b], set cellInfoState as [%b].", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      localak.BAx |= 0x40000;
      if (!paramBoolean2) {
        break label143;
      }
    }
    label143:
    for (localak.BAx |= 0x800000;; localak.BAx &= 0xFF7FFFFF)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "setReportLocation, After set, switchBit is [%d]", new Object[] { Integer.valueOf(localak.BAx) });
      AppMethodBeat.o(18502);
      return;
      localak.BAx &= 0xFFFBFFFF;
      break;
    }
  }
  
  public void setScreenBrightness(float paramFloat)
  {
    AppMethodBeat.i(18492);
    initWindowParamsIfNeed();
    if (this.mWindowParams != null)
    {
      this.mWindowParams.screenBrightness = paramFloat;
      Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
      if (localActivity != null)
      {
        localActivity.getWindow().setAttributes(this.mWindowParams);
        AppMethodBeat.o(18492);
        return;
      }
      ac.e("KindaPlatformUtil", "KindaContext.getTopOrUIPageFragmentActivity return null, so can't set ScreenBrightness!");
    }
    AppMethodBeat.o(18492);
  }
  
  public void setStatusBarHidden(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(18487);
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if (!(localActivity instanceof UIPageFragmentActivity))
    {
      ac.e("KindaPlatformUtil", "While setStatusBarHidden, We can't get the UIPageFragmentActivity on the top of stack, which we get is [" + localActivity + "]");
      AppMethodBeat.o(18487);
      return;
    }
    if (paramBoolean1)
    {
      localActivity.getWindow().addFlags(1024);
      AppMethodBeat.o(18487);
      return;
    }
    localActivity.getWindow().clearFlags(1024);
    AppMethodBeat.o(18487);
  }
  
  public boolean shouldReportCellInfo()
  {
    AppMethodBeat.i(18500);
    boolean bool = k.shouldReportCellInfo();
    AppMethodBeat.o(18500);
    return bool;
  }
  
  public boolean shouldReportLocation()
  {
    AppMethodBeat.i(18501);
    boolean bool = k.shouldReportLocation();
    AppMethodBeat.o(18501);
    return bool;
  }
  
  public boolean shouldReportWifiSsid()
  {
    AppMethodBeat.i(18499);
    boolean bool = k.erp();
    AppMethodBeat.o(18499);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaPlatformUtil
 * JD-Core Version:    0.7.0.1
 */