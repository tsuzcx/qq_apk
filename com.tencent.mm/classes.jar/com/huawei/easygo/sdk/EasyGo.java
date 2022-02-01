package com.huawei.easygo.sdk;

import android.content.Context;
import android.os.Bundle;
import com.huawei.easygo.callback.IEasyGoCallback;
import com.huawei.easygo.manager.EasyGoManager;
import com.huawei.easygo.sdk.module.EasyGoRet;
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
    AppMethodBeat.i(221839);
    this.mEasyGoManager = null;
    if (getRomSupStatus(paramContext) == 0) {
      this.mEasyGoManager = new EasyGoManager(paramContext);
    }
    AppMethodBeat.o(221839);
  }
  
  private List<Integer> assembleInitFailRet(String[] paramArrayOfString)
  {
    AppMethodBeat.i(221855);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(221855);
      return null;
    }
    paramArrayOfString = Collections.nCopies(paramArrayOfString.length, Integer.valueOf(507));
    AppMethodBeat.o(221855);
    return paramArrayOfString;
  }
  
  private int getRomSupStatus(Context paramContext)
  {
    AppMethodBeat.i(221853);
    try
    {
      int i = new EasyGoManager(paramContext).getRomSupStatus(paramContext, "1.0.2");
      AppMethodBeat.o(221853);
      return i;
    }
    catch (NoClassDefFoundError paramContext)
    {
      AppMethodBeat.o(221853);
      return 506;
    }
    catch (SecurityException paramContext)
    {
      AppMethodBeat.o(221853);
      return 508;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(221853);
    }
    return 509;
  }
  
  public final List<Integer> init(String[] paramArrayOfString)
  {
    AppMethodBeat.i(221842);
    if (this.mEasyGoManager == null)
    {
      paramArrayOfString = assembleInitFailRet(paramArrayOfString);
      AppMethodBeat.o(221842);
      return paramArrayOfString;
    }
    paramArrayOfString = this.mEasyGoManager.init(paramArrayOfString);
    AppMethodBeat.o(221842);
    return paramArrayOfString;
  }
  
  public final void invokeAsync(String paramString1, String paramString2, JSONObject paramJSONObject, Bundle paramBundle, IEasyGoCallback paramIEasyGoCallback)
  {
    AppMethodBeat.i(221849);
    if (this.mEasyGoManager == null)
    {
      AppMethodBeat.o(221849);
      return;
    }
    this.mEasyGoManager.invokeAsync(paramString1, paramString2, paramJSONObject, paramBundle, paramIEasyGoCallback);
    AppMethodBeat.o(221849);
  }
  
  public final EasyGoRet invokeSync(String paramString1, String paramString2, JSONObject paramJSONObject, Bundle paramBundle)
  {
    AppMethodBeat.i(221844);
    if (this.mEasyGoManager == null)
    {
      paramString1 = new EasyGoRet(507, new Bundle());
      AppMethodBeat.o(221844);
      return paramString1;
    }
    paramString1 = new EasyGoRet(this.mEasyGoManager.invokeSync(paramString1, paramString2, paramJSONObject, paramBundle));
    AppMethodBeat.o(221844);
    return paramString1;
  }
  
  public final void release()
  {
    AppMethodBeat.i(221850);
    if (this.mEasyGoManager == null)
    {
      AppMethodBeat.o(221850);
      return;
    }
    this.mEasyGoManager.release();
    AppMethodBeat.o(221850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.huawei.easygo.sdk.EasyGo
 * JD-Core Version:    0.7.0.1
 */