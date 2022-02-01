package com.miui.easygo.sdk;

import android.content.Context;
import android.os.Bundle;
import com.miui.easygo.callback.IEasyGoCallback;
import com.miui.easygo.manager.EasyGoManager;
import com.miui.easygo.sdk.module.EasyGoRet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public final class EasyGo
{
  private static final String TAG = "EasyGo";
  private EasyGoManager mEasyGoManager;
  
  public EasyGo(Context paramContext)
  {
    AppMethodBeat.i(222744);
    AppMethodBeat.i("EasyGo".hashCode());
    this.mEasyGoManager = null;
    if (getRomSupStatus(paramContext) == 0) {
      this.mEasyGoManager = new EasyGoManager(paramContext);
    }
    AppMethodBeat.o("EasyGo".hashCode());
    AppMethodBeat.o(222744);
  }
  
  private List<Integer> assembleInitFailRet(String[] paramArrayOfString)
  {
    AppMethodBeat.i(222747);
    AppMethodBeat.i("assembleInitFailRet".hashCode());
    if (paramArrayOfString == null) {}
    for (paramArrayOfString = null;; paramArrayOfString = Collections.nCopies(paramArrayOfString.length, Integer.valueOf(507)))
    {
      AppMethodBeat.o("assembleInitFailRet".hashCode());
      AppMethodBeat.o(222747);
      return paramArrayOfString;
    }
  }
  
  private int getRomSupStatus(Context paramContext)
  {
    AppMethodBeat.i(222753);
    AppMethodBeat.i("getRomSupStatus".hashCode());
    try
    {
      int i = new EasyGoManager(paramContext).getRomSupStatus(paramContext, "1.0.2");
      AppMethodBeat.o("getRomSupStatus".hashCode());
      AppMethodBeat.o(222753);
      return i;
    }
    catch (NoClassDefFoundError paramContext)
    {
      AppMethodBeat.o("getRomSupStatus".hashCode());
      AppMethodBeat.o(222753);
      return 506;
    }
    catch (SecurityException paramContext)
    {
      AppMethodBeat.o("getRomSupStatus".hashCode());
      AppMethodBeat.o(222753);
      return 508;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o("getRomSupStatus".hashCode());
      AppMethodBeat.o(222753);
    }
    return 509;
  }
  
  public final List<Integer> init(String[] paramArrayOfString)
  {
    AppMethodBeat.i(222755);
    AppMethodBeat.i("init".hashCode());
    if (this.mEasyGoManager == null) {}
    for (paramArrayOfString = assembleInitFailRet(paramArrayOfString);; paramArrayOfString = this.mEasyGoManager.init(paramArrayOfString))
    {
      AppMethodBeat.o("init".hashCode());
      AppMethodBeat.o(222755);
      return paramArrayOfString;
    }
  }
  
  public final void invokeAsync(String paramString1, String paramString2, JSONObject paramJSONObject, Bundle paramBundle, IEasyGoCallback paramIEasyGoCallback)
  {
    AppMethodBeat.i(222757);
    AppMethodBeat.i("invokeAsync".hashCode());
    if (this.mEasyGoManager != null) {
      this.mEasyGoManager.invokeAsync(paramString1, paramString2, paramJSONObject, paramBundle, paramIEasyGoCallback);
    }
    AppMethodBeat.o("invokeAsync".hashCode());
    AppMethodBeat.o(222757);
  }
  
  public final EasyGoRet invokeSync(String paramString1, String paramString2, JSONObject paramJSONObject, Bundle paramBundle)
  {
    AppMethodBeat.i(222758);
    AppMethodBeat.i("invokeSync".hashCode());
    if (this.mEasyGoManager == null) {}
    for (paramString1 = new EasyGoRet(507, new Bundle());; paramString1 = new EasyGoRet(this.mEasyGoManager.invokeSync(paramString1, paramString2, paramJSONObject, paramBundle)))
    {
      AppMethodBeat.o("invokeSync".hashCode());
      AppMethodBeat.o(222758);
      return paramString1;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(222760);
    AppMethodBeat.i("release".hashCode());
    if (this.mEasyGoManager != null) {
      this.mEasyGoManager.release();
    }
    AppMethodBeat.o("release".hashCode());
    AppMethodBeat.o(222760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.miui.easygo.sdk.EasyGo
 * JD-Core Version:    0.7.0.1
 */