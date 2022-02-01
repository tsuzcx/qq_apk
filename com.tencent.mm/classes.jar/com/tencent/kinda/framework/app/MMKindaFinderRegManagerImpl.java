package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaFinderRegManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.sdk.platformtools.Log;

public class MMKindaFinderRegManagerImpl
  implements KindaFinderRegManager
{
  private final String TAG = "MicorMsg.MMFinderRegManagerImpl";
  
  public void startFinderFeeds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(264259);
    Log.i("MicorMsg.MMFinderRegManagerImpl", "startFinderProfile feedid：%s，nonceid：%s", new Object[] { paramString1, paramString2 });
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if (!(localActivity instanceof UIPageFragmentActivity))
    {
      Log.e("MicorMsg.MMFinderRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", new Object[] { localActivity.getClass().getName() });
      AppMethodBeat.o(264259);
      return;
    }
    ((ak)h.ag(ak.class)).getFinderUtilApi().F(localActivity, paramString1, paramString2);
    AppMethodBeat.o(264259);
  }
  
  public void startFinderProfile(String paramString)
  {
    AppMethodBeat.i(264258);
    Log.i("MicorMsg.MMFinderRegManagerImpl", "startFinderProfile username：%s", new Object[] { paramString });
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if (!(localActivity instanceof UIPageFragmentActivity))
    {
      Log.e("MicorMsg.MMFinderRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", new Object[] { localActivity.getClass().getName() });
      AppMethodBeat.o(264258);
      return;
    }
    ((ak)h.ag(ak.class)).getFinderUtilApi().aM(localActivity, paramString);
    AppMethodBeat.o(264258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.MMKindaFinderRegManagerImpl
 * JD-Core Version:    0.7.0.1
 */