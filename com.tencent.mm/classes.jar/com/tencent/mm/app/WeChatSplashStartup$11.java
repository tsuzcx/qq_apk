package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

final class WeChatSplashStartup$11
  implements g
{
  WeChatSplashStartup$11(WeChatSplashStartup paramWeChatSplashStartup) {}
  
  public final void aDv()
  {
    AppMethodBeat.i(239241);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(239241);
      return;
    }
    h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239130);
        try
        {
          long l2 = MultiProcessMMKV.getMMKV("SnsMMKV").getLong("SnsMMKVCleanDbCount", -1L);
          long l1 = l2;
          if (l2 < 0L)
          {
            l1 = al.hgB().hlb();
            MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVCleanDbCount", l1);
          }
          Log.i("MicroMsg.WeChatSplashStartup", "cleanSnsTablesByTimeLimit snsDbCount:%s", new Object[] { Long.valueOf(l1) });
          AppMethodBeat.o(239130);
          return;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(239130);
        }
      }
    }, "SnsCleanDb");
    AppMethodBeat.o(239241);
  }
  
  public final void dZ(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.11
 * JD-Core Version:    0.7.0.1
 */