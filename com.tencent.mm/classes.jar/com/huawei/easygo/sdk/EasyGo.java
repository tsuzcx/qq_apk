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
    AppMethodBeat.i(208250);
    this.mEasyGoManager = null;
    if (getRomSupStatus(paramContext) == 0) {
      this.mEasyGoManager = new EasyGoManager(paramContext);
    }
    AppMethodBeat.o(208250);
  }
  
  private List<Integer> assembleInitFailRet(String[] paramArrayOfString)
  {
    AppMethodBeat.i(208263);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(208263);
      return null;
    }
    paramArrayOfString = Collections.nCopies(paramArrayOfString.length, Integer.valueOf(507));
    AppMethodBeat.o(208263);
    return paramArrayOfString;
  }
  
  private int getRomSupStatus(Context paramContext)
  {
    AppMethodBeat.i(208254);
    try
    {
      int i = new EasyGoManager(paramContext).getRomSupStatus(paramContext, "1.0.2");
      AppMethodBeat.o(208254);
      return i;
    }
    catch (NoClassDefFoundError paramContext)
    {
      AppMethodBeat.o(208254);
      return 506;
    }
    catch (SecurityException paramContext)
    {
      AppMethodBeat.o(208254);
      return 508;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(208254);
    }
    return 509;
  }
  
  public final List<Integer> init(String[] paramArrayOfString)
  {
    AppMethodBeat.i(208270);
    if (this.mEasyGoManager == null)
    {
      paramArrayOfString = assembleInitFailRet(paramArrayOfString);
      AppMethodBeat.o(208270);
      return paramArrayOfString;
    }
    paramArrayOfString = this.mEasyGoManager.init(paramArrayOfString);
    AppMethodBeat.o(208270);
    return paramArrayOfString;
  }
  
  public final void invokeAsync(String paramString1, String paramString2, JSONObject paramJSONObject, Bundle paramBundle, IEasyGoCallback paramIEasyGoCallback)
  {
    AppMethodBeat.i(208283);
    if (this.mEasyGoManager == null)
    {
      AppMethodBeat.o(208283);
      return;
    }
    this.mEasyGoManager.invokeAsync(paramString1, paramString2, paramJSONObject, paramBundle, paramIEasyGoCallback);
    AppMethodBeat.o(208283);
  }
  
  public final EasyGoRet invokeSync(String paramString1, String paramString2, JSONObject paramJSONObject, Bundle paramBundle)
  {
    AppMethodBeat.i(208276);
    if (this.mEasyGoManager == null)
    {
      paramString1 = new EasyGoRet(507, new Bundle());
      AppMethodBeat.o(208276);
      return paramString1;
    }
    paramString1 = new EasyGoRet(this.mEasyGoManager.invokeSync(paramString1, paramString2, paramJSONObject, paramBundle));
    AppMethodBeat.o(208276);
    return paramString1;
  }
  
  public final void release()
  {
    AppMethodBeat.i(208292);
    if (this.mEasyGoManager == null)
    {
      AppMethodBeat.o(208292);
      return;
    }
    this.mEasyGoManager.release();
    AppMethodBeat.o(208292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.huawei.easygo.sdk.EasyGo
 * JD-Core Version:    0.7.0.1
 */