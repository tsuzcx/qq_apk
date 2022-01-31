package com.tencent.mm.plugin.emoji;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.emoji.b.b.a;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.d.d.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;

public class PluginEmoji
  extends f
  implements com.tencent.mm.plugin.emoji.b.d
{
  private com.tencent.mm.pluginsdk.a.d ldq;
  com.tencent.mm.pluginsdk.a.e ldr;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(62327);
    d.a.a(com.tencent.mm.cd.g.dvk());
    com.tencent.mm.cd.b.duW();
    h.dlR();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.emoji.b.c.class, d.bkd());
    AppMethodBeat.o(62327);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(62326);
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    AppMethodBeat.o(62326);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(62328);
    if (paramg.SD())
    {
      pin(e.bki());
      if (paramg.SD()) {
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.e(new a()));
      }
    }
    for (;;)
    {
      com.tencent.mm.ui.f.b.c.a(new PluginEmoji.1(this));
      com.tencent.mm.ui.f.c.b.a(new PluginEmoji.2(this));
      com.tencent.mm.api.u.bWp = new PluginEmoji.3(this);
      AppMethodBeat.o(62328);
      return;
      if (paramg.mI(":tools"))
      {
        paramg = new IntentFilter(EmojiUpdateReceiver.ACTION);
        ah.getContext().registerReceiver(new EmojiUpdateReceiver(), paramg);
      }
    }
  }
  
  public aq getEmojiDescMgr()
  {
    AppMethodBeat.i(62333);
    aq localaq = b.a.lfk.getEmojiDescMgr();
    AppMethodBeat.o(62333);
    return localaq;
  }
  
  public com.tencent.mm.pluginsdk.a.d getEmojiMgr()
  {
    AppMethodBeat.i(62330);
    setEmojiMgr();
    com.tencent.mm.pluginsdk.a.d locald = this.ldq;
    AppMethodBeat.o(62330);
    return locald;
  }
  
  public at getEmojiStorageMgr()
  {
    AppMethodBeat.i(62332);
    at localat = b.a.lfk.getEmojiStorageMgr();
    AppMethodBeat.o(62332);
    return localat;
  }
  
  public com.tencent.mm.pluginsdk.a.e getProvider()
  {
    AppMethodBeat.i(62331);
    if (this.ldr == null) {
      this.ldr = new com.tencent.mm.ca.a();
    }
    com.tencent.mm.pluginsdk.a.e locale = this.ldr;
    AppMethodBeat.o(62331);
    return locale;
  }
  
  public void installed()
  {
    AppMethodBeat.i(62325);
    alias(com.tencent.mm.plugin.emoji.b.d.class);
    AppMethodBeat.o(62325);
  }
  
  public String name()
  {
    return "plugin-emoji";
  }
  
  public void removeEmojiMgr()
  {
    this.ldq = null;
  }
  
  public void setEmojiMgr()
  {
    AppMethodBeat.i(62329);
    if (this.ldq == null) {
      this.ldq = b.a.lfk.getEmojiMgr();
    }
    AppMethodBeat.o(62329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji
 * JD-Core Version:    0.7.0.1
 */