package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaFinderRegManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.wallet_core.utils.m;
import com.tencent.mm.sdk.platformtools.Log;

public class MMKindaFinderRegManagerImpl
  implements KindaFinderRegManager
{
  private final String TAG = "MicorMsg.MMFinderRegManagerImpl";
  
  public void startFinderFeeds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(226384);
    Log.i("MicorMsg.MMFinderRegManagerImpl", "startFinderProfile feedid：%s，nonceid：%s", new Object[] { paramString1, paramString2 });
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if (!(localActivity instanceof UIPageFragmentActivity))
    {
      Log.e("MicorMsg.MMFinderRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", new Object[] { localActivity.getClass().getName() });
      AppMethodBeat.o(226384);
      return;
    }
    ((cn)h.az(cn.class)).getFinderUtilApi().h(localActivity, paramString1, paramString2, m.asD(1));
    AppMethodBeat.o(226384);
  }
  
  public void startFinderProfile(String paramString)
  {
    AppMethodBeat.i(226382);
    Log.i("MicorMsg.MMFinderRegManagerImpl", "startFinderProfile username：%s", new Object[] { paramString });
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if (!(localActivity instanceof UIPageFragmentActivity))
    {
      Log.e("MicorMsg.MMFinderRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", new Object[] { localActivity.getClass().getName() });
      AppMethodBeat.o(226382);
      return;
    }
    ((cn)h.az(cn.class)).getFinderUtilApi().G(localActivity, paramString, m.asD(1));
    AppMethodBeat.o(226382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.MMKindaFinderRegManagerImpl
 * JD-Core Version:    0.7.0.1
 */