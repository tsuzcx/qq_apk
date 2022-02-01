package com.tencent.mm.plugin.emoji.magicemoji.monitor;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/monitor/MagicEmojiPerfMonitor;", "Lcom/tencent/mm/plugin/emoji/magicemoji/api/IMagicEmojiLifecycleListener;", "Landroid/content/ComponentCallbacks2;", "exitService", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "payload", "", "(Lkotlin/jvm/functions/Function1;)V", "mMaxMemoryWarningTimes", "getMMaxMemoryWarningTimes", "()I", "mMaxMemoryWarningTimes$delegate", "Lkotlin/Lazy;", "mMemoryWarningTimes", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "onServicePause", "onServiceResume", "onTrimMemory", "level", "triggerMemoryWarning", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements ComponentCallbacks2, com.tencent.mm.plugin.emoji.magicemoji.a.d
{
  public static final a xJw;
  private final kotlin.g.a.b<Integer, ah> xJx;
  private int xJy;
  private final j xJz;
  
  static
  {
    AppMethodBeat.i(270206);
    xJw = new a((byte)0);
    AppMethodBeat.o(270206);
  }
  
  public b(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(270180);
    this.xJx = paramb;
    this.xJz = k.cm((a)b.b.xJA);
    AppMethodBeat.o(270180);
  }
  
  private final int dyZ()
  {
    AppMethodBeat.i(270186);
    int i = ((Number)this.xJz.getValue()).intValue();
    AppMethodBeat.o(270186);
    return i;
  }
  
  private final void dza()
  {
    AppMethodBeat.i(270191);
    this.xJy += 1;
    if (this.xJy >= dyZ())
    {
      Log.w("MicroMsg.MagicEmojiPerfMonitor", "stevecai: too much time and need exit (" + this.xJy + '/' + dyZ() + ')');
      this.xJy = 0;
      com.tencent.mm.ae.d.uiThread((a)new c(this));
    }
    AppMethodBeat.o(270191);
  }
  
  public final void Kk(int paramInt)
  {
    AppMethodBeat.i(270265);
    s.u(this, "this");
    AppMethodBeat.o(270265);
  }
  
  public final void dyt()
  {
    AppMethodBeat.i(270259);
    s.u(this, "this");
    AppMethodBeat.o(270259);
  }
  
  public final void dyu()
  {
    AppMethodBeat.i(270279);
    s.u(this, "this");
    AppMethodBeat.o(270279);
  }
  
  public final void dyv()
  {
    AppMethodBeat.i(270243);
    if (dyZ() >= 0)
    {
      Log.i("MicroMsg.MagicEmojiPerfMonitor", "stevecai: application component callback registered");
      MMApplicationContext.getContext().registerComponentCallbacks((ComponentCallbacks)this);
    }
    AppMethodBeat.o(270243);
  }
  
  public final void dyw()
  {
    AppMethodBeat.i(270272);
    s.u(this, "this");
    AppMethodBeat.o(270272);
  }
  
  public final void dyx()
  {
    AppMethodBeat.i(270251);
    if (dyZ() >= 0)
    {
      Log.i("MicroMsg.MagicEmojiPerfMonitor", "stevecai: application component callback unregistered");
      MMApplicationContext.getContext().unregisterComponentCallbacks((ComponentCallbacks)this);
    }
    AppMethodBeat.o(270251);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(270217);
    s.u(paramConfiguration, "newConfig");
    AppMethodBeat.o(270217);
  }
  
  public final void onLowMemory()
  {
    AppMethodBeat.i(270225);
    Log.w("MicroMsg.MagicEmojiPerfMonitor", "stevecai: onLowMemory() called");
    dza();
    AppMethodBeat.o(270225);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(270232);
    Log.w("MicroMsg.MagicEmojiPerfMonitor", s.X("stevecai: onTrimMemory() called with: level = ", Integer.valueOf(paramInt)));
    dza();
    AppMethodBeat.o(270232);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/monitor/MagicEmojiPerfMonitor$Companion;", "", "()V", "TAG", "", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.monitor.b
 * JD-Core Version:    0.7.0.1
 */