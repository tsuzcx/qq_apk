package com.tencent.liteapp.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.liteapp.b.b;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppUICallback;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WxaLiteAppFragment
  extends WxaLiteAppBaseFragment
  implements LiteAppCenter.ILiteAppUICallback
{
  private LiteAppCenter.PageInfo cpn;
  private long pageId = -1L;
  
  public final String NE()
  {
    return this.cpc;
  }
  
  public final String NF()
  {
    AppMethodBeat.i(258689);
    long l = this.pageId;
    AppMethodBeat.o(258689);
    return String.valueOf(l);
  }
  
  public final Map NG()
  {
    AppMethodBeat.i(258690);
    if (this.cpn != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("activityId", Long.valueOf(this.cpn.appUuid));
      ((HashMap)localObject).put("appId", this.cpe.appId);
      ((HashMap)localObject).put("appPtr", Long.valueOf(this.cpn.appPtr));
      ((HashMap)localObject).put("pageViewId", Long.valueOf(this.cpn.pageId));
      ((HashMap)localObject).put("basePath", this.cpn.basePath);
      ((HashMap)localObject).put("pageRenderPtr", Long.valueOf(this.cpn.renderId));
      ((HashMap)localObject).put("flags", Integer.valueOf(this.cpn.flags));
      ((HashMap)localObject).put("startTime", Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(258690);
      return localObject;
    }
    Object localObject = super.NG();
    AppMethodBeat.o(258690);
    return localObject;
  }
  
  public boolean hasCutOut()
  {
    return false;
  }
  
  public void navigateBack(boolean paramBoolean)
  {
    AppMethodBeat.i(258692);
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(258682);
        WxaLiteAppFragment.this.onBackPressed();
        AppMethodBeat.o(258682);
      }
    });
    AppMethodBeat.o(258692);
  }
  
  public void onCheckSumFail(String paramString, List<String> paramList) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(258683);
    super.onCreate(paramBundle);
    AppMethodBeat.o(258683);
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(258687);
    Nu();
    if (this.cpe != null)
    {
      b.i("WxaLiteAp.WxaLiteAppFragment", "Use WxaLiteAppInfo", new Object[0]);
      long l = System.currentTimeMillis();
      if (!TextUtils.isEmpty(this.cph)) {
        break label380;
      }
      this.cpn = LiteAppCenter.showIndexView(this.cpe.appId, this.cpe.path, this.cpe.coX, this.Ln);
      b.i("WxaLiteAp.WxaLiteAppFragment", "Use WxaLiteAppInfo end showIndexView use %d", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
      if (this.cpn == null) {
        break label419;
      }
      this.mAppId = this.cpe.appId;
      this.appPtr = this.cpn.appPtr;
      this.pageId = this.cpn.pageId;
      this.cpc = String.valueOf(this.cpn.appUuid);
      b.d("WxaLiteAp.WxaLiteAppFragment", "Use WxaLiteAppInfo pageInfo %s", new Object[] { this.cpn.toString() });
    }
    for (;;)
    {
      Map localMap = NG();
      if (localMap != null)
      {
        if (localMap.containsKey("startTime"))
        {
          Long.valueOf(localMap.get("startTime").toString()).longValue();
          System.currentTimeMillis();
        }
        if (localMap.containsKey("appId")) {
          this.mAppId = String.valueOf(localMap.get("appId"));
        }
        if (localMap.containsKey("appPtr")) {
          this.appPtr = Long.valueOf(localMap.get("appPtr").toString()).longValue();
        }
        if (localMap.containsKey("pageViewId")) {
          this.pageId = Long.valueOf(localMap.get("pageViewId").toString()).longValue();
        }
        if (localMap.containsKey("activityId")) {
          this.cpc = localMap.get("activityId").toString();
        }
      }
      paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      paramLayoutInflater.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(258679);
          paramLayoutInflater.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          WxaLiteAppFragment.a(WxaLiteAppFragment.this, paramLayoutInflater);
          AppMethodBeat.o(258679);
        }
      });
      AppMethodBeat.o(258687);
      return paramLayoutInflater;
      label380:
      this.cpn = LiteAppCenter.showView(this.cpe.appId, this.cph, this.Ln, this.cpe.path, this.cpe.coX);
      break;
      label419:
      b.i("WxaLiteAp.WxaLiteAppFragment", "Use WxaLiteAppInfo fail, pageInfo is null.", new Object[0]);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(258685);
    super.onDestroy();
    LiteAppCenter.unsetUICallback(this.appPtr, this);
    AppMethodBeat.o(258685);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(258684);
    super.onStart();
    LiteAppCenter.setUICallback(this.appPtr, this);
    AppMethodBeat.o(258684);
  }
  
  public void setFlags(int paramInt) {}
  
  public void showPage(LiteAppCenter.PageInfo paramPageInfo) {}
  
  public void vibrateLong(long paramLong)
  {
    AppMethodBeat.i(258694);
    Vibrator localVibrator = (Vibrator)getActivity().getSystemService("vibrator");
    if (localVibrator == null)
    {
      AppMethodBeat.o(258694);
      return;
    }
    localVibrator.vibrate(paramLong);
    AppMethodBeat.o(258694);
  }
  
  public void vibrateShort(long paramLong, int paramInt)
  {
    AppMethodBeat.i(258695);
    Vibrator localVibrator = (Vibrator)getActivity().getSystemService("vibrator");
    if (localVibrator == null)
    {
      AppMethodBeat.o(258695);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (localVibrator.hasAmplitudeControl()))
    {
      localVibrator.vibrate(VibrationEffect.createOneShot(paramLong, paramInt));
      AppMethodBeat.o(258695);
      return;
    }
    localVibrator.vibrate(paramLong);
    AppMethodBeat.o(258695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppFragment
 * JD-Core Version:    0.7.0.1
 */