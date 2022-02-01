package com.tencent.liteapp.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.tencent.liteapp.a.d;
import com.tencent.liteapp.a.e;
import com.tencent.liteapp.b.b;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppUICallback;
import com.tencent.mm.plugin.lite.LiteAppCenter.PageInfo;
import com.tencent.wxa.c;
import com.tencent.wxa.ui.a;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class WxaLiteAppFragment
  extends WxaLiteAppBaseFragment
  implements LiteAppCenter.ILiteAppUICallback
{
  private LiteAppCenter.PageInfo egW;
  private long pageId = -1L;
  
  public final String anP()
  {
    return this.egQ;
  }
  
  public final String anQ()
  {
    AppMethodBeat.i(219156);
    long l = this.pageId;
    AppMethodBeat.o(219156);
    return String.valueOf(l);
  }
  
  public final Map anR()
  {
    AppMethodBeat.i(219162);
    if (this.egW != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("activityId", Long.valueOf(this.egW.appUuid));
      ((HashMap)localObject).put("appId", this.egS.appId);
      ((HashMap)localObject).put("appPtr", Long.valueOf(this.egW.appPtr));
      ((HashMap)localObject).put("pageViewId", Long.valueOf(this.egW.pageId));
      ((HashMap)localObject).put("basePath", this.egW.basePath);
      ((HashMap)localObject).put("pageRenderPtr", Long.valueOf(this.egW.renderId));
      ((HashMap)localObject).put("flags", Integer.valueOf(this.egW.flags));
      ((HashMap)localObject).put("startTime", Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(219162);
      return localObject;
    }
    Object localObject = super.anR();
    AppMethodBeat.o(219162);
    return localObject;
  }
  
  public void closeWindow(Intent paramIntent) {}
  
  public boolean hasCutOut()
  {
    return false;
  }
  
  public void navigateBack(boolean paramBoolean)
  {
    AppMethodBeat.i(219170);
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219095);
        WxaLiteAppFragment.this.onBackPressed();
        AppMethodBeat.o(219095);
      }
    });
    AppMethodBeat.o(219170);
  }
  
  public void onCheckSumFail(String paramString, List<String> paramList) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(219108);
    super.onCreate(paramBundle);
    AppMethodBeat.o(219108);
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(219141);
    anL();
    int i;
    if (this.egS != null)
    {
      b.i("WxaLiteAp.WxaLiteAppFragment", "Use WxaLiteAppInfo", new Object[0]);
      long l = System.currentTimeMillis();
      i = c.keQ().d(this.egR.flutterEngine);
      if (!TextUtils.isEmpty(this.egV)) {
        break label517;
      }
      this.egW = LiteAppCenter.showIndexView(this.egS.appId, this.egS.path, this.egS.egI, this.brD, i);
      if (this.egW.success == 2)
      {
        Toast.makeText(getActivity(), "当前的基础库和框架不支持本业务包!", 0).show();
        getActivity().finish();
      }
      b.i("WxaLiteAp.WxaLiteAppFragment", "Use WxaLiteAppInfo end showIndexView use %d", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
      if (this.egW == null) {
        break label558;
      }
      this.mAppId = this.egS.appId;
      this.appPtr = this.egW.appPtr;
      this.pageId = this.egW.pageId;
      this.egQ = String.valueOf(this.egW.appUuid);
      this.renderId = this.egW.renderId;
      b.d("WxaLiteAp.WxaLiteAppFragment", "Use WxaLiteAppInfo pageInfo %s", new Object[] { this.egW.toString() });
    }
    for (;;)
    {
      Map localMap = anR();
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
          this.egQ = localMap.get("activityId").toString();
        }
        if (localMap.containsKey("pageRenderPtr")) {
          this.renderId = Long.valueOf(localMap.get("pageRenderPtr").toString()).longValue();
        }
      }
      paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      paramLayoutInflater.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(219103);
          paramLayoutInflater.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          WxaLiteAppFragment.a(WxaLiteAppFragment.this, paramLayoutInflater);
          AppMethodBeat.o(219103);
        }
      });
      if (this.renderId <= 0L)
      {
        paramLayoutInflater = LayoutInflater.from(getContext()).inflate(a.e.empty_view, null);
        paramLayoutInflater.findViewById(a.d.root).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(219122);
            WxaLiteAppFragment.this.getActivity().finish();
            AppMethodBeat.o(219122);
          }
        });
      }
      AppMethodBeat.o(219141);
      return paramLayoutInflater;
      label517:
      this.egW = LiteAppCenter.showView(this.egS.appId, this.egV, this.brD, this.egS.path, this.egS.egI, i);
      break;
      label558:
      b.i("WxaLiteAp.WxaLiteAppFragment", "Use WxaLiteAppInfo fail, pageInfo is null.", new Object[0]);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(219125);
    super.onDestroy();
    LiteAppCenter.unsetUICallback(this.appPtr, this);
    AppMethodBeat.o(219125);
  }
  
  public void onShowPageTimeStamp(long paramLong1, long paramLong2) {}
  
  public void onStart()
  {
    AppMethodBeat.i(219116);
    super.onStart();
    LiteAppCenter.setLocale(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());
    LiteAppCenter.setUICallback(this.appPtr, this);
    AppMethodBeat.o(219116);
  }
  
  public void setFlags(int paramInt) {}
  
  public void setKeepScreenOn(final boolean paramBoolean)
  {
    AppMethodBeat.i(219192);
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219102);
        WxaLiteAppFragment.this.getView().setKeepScreenOn(paramBoolean);
        AppMethodBeat.o(219102);
      }
    });
    AppMethodBeat.o(219192);
  }
  
  public void setPageOrientation(int paramInt) {}
  
  public void showPage(LiteAppCenter.PageInfo paramPageInfo) {}
  
  public void vibrateLong(long paramLong)
  {
    AppMethodBeat.i(219184);
    Vibrator localVibrator = (Vibrator)getActivity().getSystemService("vibrator");
    if (localVibrator == null)
    {
      AppMethodBeat.o(219184);
      return;
    }
    localVibrator.vibrate(paramLong);
    AppMethodBeat.o(219184);
  }
  
  public void vibrateShort(long paramLong, int paramInt)
  {
    AppMethodBeat.i(219188);
    Vibrator localVibrator = (Vibrator)getActivity().getSystemService("vibrator");
    if (localVibrator == null)
    {
      AppMethodBeat.o(219188);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (localVibrator.hasAmplitudeControl()))
    {
      localVibrator.vibrate(VibrationEffect.createOneShot(paramLong, paramInt));
      AppMethodBeat.o(219188);
      return;
    }
    localVibrator.vibrate(paramLong);
    AppMethodBeat.o(219188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppFragment
 * JD-Core Version:    0.7.0.1
 */