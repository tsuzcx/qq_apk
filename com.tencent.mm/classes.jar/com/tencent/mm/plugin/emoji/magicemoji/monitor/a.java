package com.tencent.mm.plugin.emoji.magicemoji.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.magicemoji.a.d;
import com.tencent.mm.plugin.emoji.magicemoji.d.a.b;
import com.tencent.mm.plugin.emoji.magicemoji.d.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/monitor/MagicEmojiCrashMonitor;", "Lcom/tencent/mm/plugin/emoji/magicemoji/api/IMagicEmojiLifecycleListener;", "Lcom/tencent/mm/sdk/crash/ICrashReporter$ICrashReportListener;", "()V", "mCrashTimes", "", "onCrashDumped", "", "message", "", "onServiceDestroy", "reason", "onServicePlayed", "resetCrashTimes", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements d, ICrashReporter.ICrashReportListener
{
  public static final a.a xJu;
  private int xJv;
  
  static
  {
    AppMethodBeat.i(270194);
    xJu = new a.a((byte)0);
    AppMethodBeat.o(270194);
  }
  
  public a()
  {
    AppMethodBeat.i(270183);
    Object localObject = MultiProcessMMKV.getMMKV("MagicEmojiStorage");
    int i = ((MultiProcessMMKV)localObject).getInt("ClientVersion", -1);
    u localu = new u(a.b.xKb);
    if ((i != -1) && (i != BuildInfo.CLIENT_VERSION_INT))
    {
      dyY();
      if (localu.jKS()) {
        localu.diJ();
      }
      Log.i("MicroMsg.MagicEmojiCrashMonitor", "stevecai: reset crash times because of upgrade");
    }
    for (;;)
    {
      CrashReportFactory.addCrashReportListener((ICrashReporter.ICrashReportListener)this);
      Log.d("MicroMsg.MagicEmojiCrashMonitor", "stevecai: crash report listener registered ok");
      AppMethodBeat.o(270183);
      return;
      if (localu.jKS()) {
        if (localu.diJ())
        {
          this.xJv += 1;
          ((MultiProcessMMKV)localObject).putInt("ClientVersion", BuildInfo.CLIENT_VERSION_INT);
          ((MultiProcessMMKV)localObject).putInt("CrashTimes", this.xJv);
          localObject = e.xKw;
          e.AQ(37);
          Log.i("MicroMsg.MagicEmojiCrashMonitor", "stevecai: crash detected");
        }
        else
        {
          Log.e("MicroMsg.MagicEmojiCrashMonitor", "stevecai: crash found but delete failed");
        }
      }
    }
  }
  
  /* Error */
  private final void dyY()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 147
    //   4: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 124	com/tencent/mm/plugin/emoji/magicemoji/monitor/a:xJv	I
    //   11: ifne +11 -> 22
    //   14: ldc 147
    //   16: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: ldc 104
    //   24: ldc 149
    //   26: aload_0
    //   27: getfield 124	com/tencent/mm/plugin/emoji/magicemoji/monitor/a:xJv	I
    //   30: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   33: invokestatic 161	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 124	com/tencent/mm/plugin/emoji/magicemoji/monitor/a:xJv	I
    //   44: ldc 67
    //   46: invokestatic 73	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   49: astore_1
    //   50: aload_1
    //   51: ldc 75
    //   53: getstatic 95	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   56: invokevirtual 128	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   59: pop
    //   60: aload_1
    //   61: ldc 130
    //   63: iconst_0
    //   64: invokevirtual 128	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putInt	(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    //   67: pop
    //   68: ldc 147
    //   70: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: goto -54 -> 19
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	a
    //   49	12	1	localMultiProcessMMKV	MultiProcessMMKV
    //   76	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	76	finally
    //   22	73	76	finally
  }
  
  public final void Kk(int paramInt)
  {
    AppMethodBeat.i(270207);
    CrashReportFactory.removeCrashReportListener((ICrashReporter.ICrashReportListener)this);
    AppMethodBeat.o(270207);
  }
  
  public final void dyt()
  {
    AppMethodBeat.i(270233);
    s.u(this, "this");
    AppMethodBeat.o(270233);
  }
  
  public final void dyu()
  {
    AppMethodBeat.i(270257);
    s.u(this, "this");
    AppMethodBeat.o(270257);
  }
  
  public final void dyv()
  {
    AppMethodBeat.i(270248);
    s.u(this, "this");
    AppMethodBeat.o(270248);
  }
  
  public final void dyw()
  {
    AppMethodBeat.i(270218);
    if (this.xJv > 0) {
      h.ahAA.p(new a..ExternalSyntheticLambda0(this), 10000L);
    }
    AppMethodBeat.o(270218);
  }
  
  public final void dyx()
  {
    AppMethodBeat.i(270241);
    s.u(this, "this");
    AppMethodBeat.o(270241);
  }
  
  public final void onCrashDumped(String paramString)
  {
    AppMethodBeat.i(270226);
    paramString = new u(a.b.xKb);
    if (!paramString.jKS()) {
      try
      {
        paramString.jKZ();
        Log.i("MicroMsg.MagicEmojiCrashMonitor", "stevecai: onCrashDumped: crash happen");
        AppMethodBeat.o(270226);
        return;
      }
      catch (IOException paramString)
      {
        Log.printErrStackTrace("MicroMsg.MagicEmojiCrashMonitor", (Throwable)paramString, "dump magic emoji crash file failed", new Object[0]);
      }
    }
    AppMethodBeat.o(270226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.monitor.a
 * JD-Core Version:    0.7.0.1
 */