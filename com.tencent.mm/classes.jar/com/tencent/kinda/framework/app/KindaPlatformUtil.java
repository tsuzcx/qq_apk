package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.kinda.framework.widget.base.MMKView;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.AndroidDpiLevel;
import com.tencent.kinda.gen.IOSDevice;
import com.tencent.kinda.gen.IPlatformUtil;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KView;
import com.tencent.kinda.gen.Platform;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cb;
import com.tencent.mm.ce.b;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ct;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.util.b.a;

public class KindaPlatformUtil
  implements IPlatformUtil
{
  private final String TAG;
  private final IListener checkLanguageChangeIListener;
  private VoidStringCallback languageChangeCallback;
  
  public KindaPlatformUtil()
  {
    AppMethodBeat.i(18471);
    this.languageChangeCallback = null;
    this.TAG = "KindaPlatformUtil";
    this.checkLanguageChangeIListener = new IListener(com.tencent.mm.app.f.hfK)
    {
      public boolean callback(cb paramAnonymouscb)
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
  
  private at.a[] getRedDotKey(String paramString)
  {
    AppMethodBeat.i(18472);
    at.a locala;
    if (paramString.equalsIgnoreCase("receipt"))
    {
      paramString = at.a.acUq;
      locala = at.a.acTk;
      AppMethodBeat.o(18472);
      return new at.a[] { paramString, locala };
    }
    if (paramString.equalsIgnoreCase("reward"))
    {
      paramString = at.a.acUs;
      locala = at.a.acTk;
      AppMethodBeat.o(18472);
      return new at.a[] { paramString, locala };
    }
    if (paramString.equalsIgnoreCase("groupaa"))
    {
      paramString = at.a.acUp;
      locala = at.a.acTk;
      AppMethodBeat.o(18472);
      return new at.a[] { paramString, locala };
    }
    if (paramString.equalsIgnoreCase("faceHongBao"))
    {
      paramString = at.a.acUr;
      locala = at.a.acTk;
      AppMethodBeat.o(18472);
      return new at.a[] { paramString, locala };
    }
    if ((paramString.equalsIgnoreCase("transferBank")) || (paramString.equalsIgnoreCase("transferMobile")) || (paramString.equalsIgnoreCase("transferMix")))
    {
      paramString = at.a.acUt;
      locala = at.a.acTk;
      AppMethodBeat.o(18472);
      return new at.a[] { paramString, locala };
    }
    AppMethodBeat.o(18472);
    return null;
  }
  
  public void accessibilityAnnounce(KView paramKView, String paramString)
  {
    AppMethodBeat.i(226486);
    if (paramKView == null)
    {
      AppMethodBeat.o(226486);
      return;
    }
    if ((paramKView instanceof MMKView))
    {
      paramKView = ((MMKView)paramKView).getView();
      if (paramKView == null)
      {
        Log.e("KindaPlatformUtil", "announce view is null");
        AppMethodBeat.o(226486);
        return;
      }
      paramKView.announceForAccessibility(paramString);
    }
    AppMethodBeat.o(226486);
  }
  
  public void accessibilityFocus(final KView paramKView)
  {
    AppMethodBeat.i(226479);
    if (paramKView == null)
    {
      AppMethodBeat.o(226479);
      return;
    }
    if ((paramKView instanceof MMKView))
    {
      paramKView = ((MMKView)paramKView).getView();
      if (paramKView == null)
      {
        Log.e("KindaPlatformUtil", "focusFirst view is null");
        AppMethodBeat.o(226479);
        return;
      }
      paramKView.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(226365);
          paramKView.sendAccessibilityEvent(128);
          AppMethodBeat.o(226365);
        }
      });
    }
    AppMethodBeat.o(226479);
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
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(18474);
    return str;
  }
  
  public Platform currentPlatform()
  {
    return Platform.ANDROID;
  }
  
  public boolean delSecurityStore(String paramString)
  {
    return false;
  }
  
  public float dynamicFontSize(float paramFloat)
  {
    AppMethodBeat.i(226490);
    if (KindaContext.get() != null)
    {
      float f = MMKViewUtil.getScaleSize(KindaContext.get());
      AppMethodBeat.o(226490);
      return paramFloat * f;
    }
    AppMethodBeat.o(226490);
    return paramFloat;
  }
  
  public float dynamicSize(float paramFloat)
  {
    return paramFloat;
  }
  
  public float dynamicSizeByFontLevel(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(226493);
    float f = getScaleByFontLevel(paramInt);
    AppMethodBeat.o(226493);
    return f * paramFloat;
  }
  
  public void endIgnoringInteractionEvents() {}
  
  protected void finalize()
  {
    AppMethodBeat.i(18473);
    this.checkLanguageChangeIListener.dead();
    AppMethodBeat.o(18473);
  }
  
  public String genUUID()
  {
    AppMethodBeat.i(18494);
    String str = com.tencent.mm.compatible.deviceinfo.q.aPg();
    AppMethodBeat.o(18494);
    return str;
  }
  
  public String getAndroidRepairConfig(String paramString)
  {
    AppMethodBeat.i(226390);
    if (paramString.equals("use_biometric_prompt"))
    {
      paramString = new StringBuilder();
      com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
      paramString = com.tencent.mm.util.i.a(b.a.agsB, 0);
      AppMethodBeat.o(226390);
      return paramString;
    }
    AppMethodBeat.o(226390);
    return "";
  }
  
  public float getBottomSafeAreaHeight()
  {
    return 0.0F;
  }
  
  public boolean getExptBoolValue(String paramString)
  {
    AppMethodBeat.i(18482);
    paramString = d.dNI().a(paramString, "", false, false);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(18482);
      return false;
    }
    if (Util.getInt(paramString, 0) != 0)
    {
      AppMethodBeat.o(18482);
      return true;
    }
    AppMethodBeat.o(18482);
    return false;
  }
  
  public int getFontLevel()
  {
    AppMethodBeat.i(226497);
    float f = MMKViewUtil.getScaleSize(KindaContext.get());
    int i = 0;
    while (i < MMKViewUtil.fontLevel.length)
    {
      if (aw.bc(f, MMKViewUtil.fontLevel[i]))
      {
        AppMethodBeat.o(226497);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(226497);
    return 1;
  }
  
  public float getIphoneSafeAreaBottomHeight()
  {
    return 0.0F;
  }
  
  public boolean getIsAccessibilityServiceRunning()
  {
    AppMethodBeat.i(226510);
    boolean bool = a.a.jlv().jls();
    AppMethodBeat.o(226510);
    return bool;
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
        Log.e("KindaPlatformUtil", "KindaContext.get() is not MMActivity, is %s.", new Object[] { localContext.getClass().getName() });
        AppMethodBeat.o(18480);
        return 0.0F;
      }
      float f = com.tencent.mm.compatible.util.a.v((MMActivity)localContext) / getDensity(localContext);
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
      boolean bool = com.tencent.mm.aa.c.aYo().b(paramString[0], paramString[1]);
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
      h.baF();
      paramString = (String)h.baE().ban().get(at.a.acTE, "");
      AppMethodBeat.o(18485);
      return paramString;
    }
    AppMethodBeat.o(18485);
    return null;
  }
  
  public float getScaleByFontLevel(int paramInt)
  {
    AppMethodBeat.i(226499);
    int i;
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWZ, 0) == 1)
    {
      i = 1;
      if (i == 0) {
        break label103;
      }
      if (paramInt >= 0) {
        break label59;
      }
      i = 0;
    }
    for (;;)
    {
      float f;
      try
      {
        f = MMKViewUtil.fontLevel[i];
        AppMethodBeat.o(226499);
        return f;
      }
      catch (Exception localException)
      {
        Log.e("KindaPlatformUtil", "getScaleByFontLevel error:%s", new Object[] { localException.getMessage() });
      }
      i = 0;
      break;
      label59:
      i = paramInt;
      if (paramInt >= MMKViewUtil.fontLevel.length)
      {
        paramInt = MMKViewUtil.fontLevel.length;
        i = paramInt - 1;
        continue;
        label103:
        f = 1.0F;
      }
    }
  }
  
  public float getScreenBrightness()
  {
    AppMethodBeat.i(18491);
    Object localObject = KindaContext.getTopOrUIPageFragmentActivity();
    if (localObject == null)
    {
      Log.e("KindaPlatformUtil", "While getScreenBrightness, We can't get the activity on the top of stack");
      AppMethodBeat.o(18491);
      return 0.0F;
    }
    localObject = ((Activity)localObject).getWindow().getAttributes();
    if (localObject != null)
    {
      float f = ((WindowManager.LayoutParams)localObject).screenBrightness;
      AppMethodBeat.o(18491);
      return f;
    }
    AppMethodBeat.o(18491);
    return 0.0F;
  }
  
  public float getStatusBarHeight()
  {
    AppMethodBeat.i(18479);
    Context localContext = KindaContext.get();
    if (localContext != null)
    {
      float f = aw.getStatusBarHeight(localContext) / getDensity(localContext);
      AppMethodBeat.o(18479);
      return f;
    }
    AppMethodBeat.o(18479);
    return 0.0F;
  }
  
  public float getViewScale()
  {
    AppMethodBeat.i(226502);
    int i;
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWZ, 0) == 1)
    {
      i = 1;
      if (i == 0) {
        break label51;
      }
    }
    label51:
    for (float f = com.tencent.mm.ce.c.iRs();; f = 1.0F)
    {
      AppMethodBeat.o(226502);
      return f;
      i = 0;
      break;
    }
  }
  
  public IOSDevice iOSDevice()
  {
    return IOSDevice.UNKNOWN;
  }
  
  public String iOSVersion()
  {
    return null;
  }
  
  public boolean isCareModeOn()
  {
    AppMethodBeat.i(226487);
    boolean bool = b.iRp();
    AppMethodBeat.o(226487);
    return bool;
  }
  
  public boolean isNetworkConnected()
  {
    AppMethodBeat.i(18497);
    boolean bool = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
    AppMethodBeat.o(18497);
    return bool;
  }
  
  public boolean isPad()
  {
    return false;
  }
  
  public byte[] loadSecurityStore(String paramString)
  {
    return new byte[0];
  }
  
  public void makesureLonglink()
  {
    AppMethodBeat.i(18493);
    com.tencent.mm.wallet_core.ui.i.jPt();
    AppMethodBeat.o(18493);
  }
  
  public String md5(String paramString)
  {
    AppMethodBeat.i(18483);
    paramString = MD5Util.getMD5String(paramString);
    AppMethodBeat.o(18483);
    return paramString;
  }
  
  public void openTinyApp(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(226387);
    String str1 = paramITransmitKvData.getString("KindaTinyAppUserName");
    String str2 = paramITransmitKvData.getString("KindaTinyAppPath");
    String str3 = paramITransmitKvData.getString("KindaTinyAppVersion");
    int i = Util.getInt(paramITransmitKvData.getString("KindaTinyAppScene"), 0);
    int j = Util.getInt(paramITransmitKvData.getString("KindaTinyAppType"), 0);
    if (Util.isNullOrNil(str1))
    {
      Log.e("KindaPlatformUtil", "failed openTinyApp for empty appusername");
      AppMethodBeat.o(226387);
      return;
    }
    paramITransmitKvData = (t)h.ax(t.class);
    g localg = new g();
    localg.username = str1;
    localg.qAF = str2;
    int k = Util.getInt(str3, 0);
    if (k > 0) {
      localg.version = k;
    }
    if (i == 0)
    {
      localg.scene = 1034;
      if (j != 0) {
        break label182;
      }
    }
    label182:
    for (localg.euz = 0;; localg.euz = 2)
    {
      paramITransmitKvData.a(MMApplicationContext.getContext(), localg);
      AppMethodBeat.o(226387);
      return;
      localg.scene = i;
      break;
    }
  }
  
  public void playVibration()
  {
    AppMethodBeat.i(18490);
    try
    {
      Object localObject = KindaContext.get();
      if (localObject == null)
      {
        Log.e("KindaPlatformUtil", "KindaContext get null while playVibration!");
        AppMethodBeat.o(18490);
        return;
      }
      localObject = (Vibrator)((Context)localObject).getSystemService("vibrator");
      if (localObject == null)
      {
        Log.e("KindaPlatformUtil", "playVibration call getSystemService get null!");
        AppMethodBeat.o(18490);
        return;
      }
      ((Vibrator)localObject).vibrate(15L);
      AppMethodBeat.o(18490);
      return;
    }
    catch (Exception localException)
    {
      Log.e("KindaPlatformUtil", "playVibration exception %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(18490);
    }
  }
  
  public String resolveLanguageStringForGlobal(String paramString)
  {
    AppMethodBeat.i(226504);
    paramString = ct.Ki(paramString);
    AppMethodBeat.o(226504);
    return paramString;
  }
  
  public String resolveURLStringForGlobal(String paramString)
  {
    AppMethodBeat.i(226503);
    paramString = ct.Kj(paramString);
    AppMethodBeat.o(226503);
    return paramString;
  }
  
  public boolean saveSecurityStore(String paramString, byte[] paramArrayOfByte)
  {
    return false;
  }
  
  public void setIdleTimerDisable(boolean paramBoolean)
  {
    AppMethodBeat.i(226463);
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if (localActivity == null)
    {
      Log.e("KindaPlatformUtil", "While setIdleTimerDisable, We can't get the activity on the top of stack");
      AppMethodBeat.o(226463);
      return;
    }
    if (paramBoolean)
    {
      localActivity.getWindow().addFlags(128);
      AppMethodBeat.o(226463);
      return;
    }
    localActivity.getWindow().clearFlags(128);
    AppMethodBeat.o(226463);
  }
  
  public void setLanguageChangeCallbackImpl(VoidStringCallback paramVoidStringCallback)
  {
    AppMethodBeat.i(18475);
    this.languageChangeCallback = paramVoidStringCallback;
    this.checkLanguageChangeIListener.alive();
    AppMethodBeat.o(18475);
  }
  
  public void setRedDotStatus(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(18486);
    paramString = getRedDotKey(paramString);
    if ((paramString != null) && (!paramBoolean)) {
      com.tencent.mm.aa.c.aYo().c(paramString[0], paramString[1]);
    }
    AppMethodBeat.o(18486);
  }
  
  public void setReportLocationState(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(18502);
    Log.i("KindaPlatformUtil", "setLocationState, set wifiSsidState as: [%b], set cellInfoState as [%b].", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    ak localak = u.iiC().ijp();
    Log.i("MicroMsg.WalletSwitchConfig", "setReportLocation, set wifiSsidState as: [%b], set cellInfoState as [%b].", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      localak.VJX |= 0x40000;
      if (!paramBoolean2) {
        break label143;
      }
    }
    label143:
    for (localak.VJX |= 0x800000;; localak.VJX &= 0xFF7FFFFF)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "setReportLocation, After set, switchBit is [%d]", new Object[] { Integer.valueOf(localak.VJX) });
      AppMethodBeat.o(18502);
      return;
      localak.VJX &= 0xFFFBFFFF;
      break;
    }
  }
  
  public void setScreenBrightness(float paramFloat)
  {
    AppMethodBeat.i(18492);
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if (localActivity == null)
    {
      Log.e("KindaPlatformUtil", "While setScreenBrightness, We can't get the activity on the top of stack");
      AppMethodBeat.o(18492);
      return;
    }
    WindowManager.LayoutParams localLayoutParams = localActivity.getWindow().getAttributes();
    if (localLayoutParams != null)
    {
      localLayoutParams.screenBrightness = paramFloat;
      localActivity.getWindow().setAttributes(localLayoutParams);
    }
    AppMethodBeat.o(18492);
  }
  
  public void setStatusBarHidden(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(18487);
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if (!(localActivity instanceof UIPageFragmentActivity))
    {
      Log.e("KindaPlatformUtil", "While setStatusBarHidden, We can't get the UIPageFragmentActivity on the top of stack, which we get is [" + localActivity + "]");
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
  
  public String sha256(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return "";
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
    boolean bool = k.iit();
    AppMethodBeat.o(18499);
    return bool;
  }
  
  public boolean supportSecurityStore()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaPlatformUtil
 * JD-Core Version:    0.7.0.1
 */