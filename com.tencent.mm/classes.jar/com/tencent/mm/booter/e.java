package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.x5.sdk.d;

public final class e
{
  public static final class a
    extends e.c
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(19875);
      if ((paramContext == null) || (paramIntent == null))
      {
        AppMethodBeat.o(19875);
        return;
      }
      super.onReceive(paramContext, paramIntent);
      paramContext = paramIntent.getStringExtra("toolsmp_process_action_code_key");
      if ((!bt.isNullOrNil(paramContext)) && (paramContext.equals("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH"))) {
        ai.eMn().t(paramIntent.getStringExtra("toolsmp_param_preload_url"), paramIntent.getIntExtra("toolsmp_param_preload_search_biz", -1), paramIntent.getBooleanExtra("toolsmp_param_preload_search_biz_need_reset", false));
      }
      AppMethodBeat.o(19875);
    }
  }
  
  public static final class b
    implements MMReceivers.a
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(19877);
      if ((paramContext == null) || (paramIntent == null))
      {
        AppMethodBeat.o(19877);
        return;
      }
      ad.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
      d.reset(paramContext);
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(19876);
          com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/booter/MMProcessReceivers$SandBoxProcessReceiverImpl$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)locala.mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/booter/MMProcessReceivers$SandBoxProcessReceiverImpl$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          AppMethodBeat.o(19876);
        }
      }, 5000L);
      AppMethodBeat.o(19877);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.e
 * JD-Core Version:    0.7.0.1
 */