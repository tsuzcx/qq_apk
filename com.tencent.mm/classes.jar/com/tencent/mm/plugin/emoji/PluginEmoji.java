package com.tencent.mm.plugin.emoji;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.emoji.b.b.a;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.d.d.a;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;

public class PluginEmoji
  extends f
  implements com.tencent.mm.plugin.emoji.b.d
{
  private com.tencent.mm.pluginsdk.a.d iUm;
  com.tencent.mm.pluginsdk.a.e iUn;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    d.a.a(com.tencent.mm.cd.g.csM());
    com.tencent.mm.cd.b.csC();
    h.clh();
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.emoji.b.c.class, d.aGv());
  }
  
  public void dependency()
  {
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      pin(e.aGz());
      if (paramg.Ex()) {
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.e(new a()));
      }
    }
    com.tencent.mm.ui.e.b.c.a(new PluginEmoji.1(this));
    com.tencent.mm.ui.e.c.b.a(new PluginEmoji.2(this));
    com.tencent.mm.api.s.bve = new PluginEmoji.3(this);
  }
  
  public aq getEmojiDescMgr()
  {
    return b.a.iWe.getEmojiDescMgr();
  }
  
  public com.tencent.mm.pluginsdk.a.d getEmojiMgr()
  {
    setEmojiMgr();
    return this.iUm;
  }
  
  public at getEmojiStorageMgr()
  {
    return b.a.iWe.getEmojiStorageMgr();
  }
  
  public com.tencent.mm.pluginsdk.a.e getProvider()
  {
    if (this.iUn == null) {
      this.iUn = new com.tencent.mm.ca.a();
    }
    return this.iUn;
  }
  
  public void installed()
  {
    alias(com.tencent.mm.plugin.emoji.b.d.class);
  }
  
  public String name()
  {
    return "plugin-emoji";
  }
  
  public void removeEmojiMgr()
  {
    this.iUm = null;
  }
  
  public void setEmojiMgr()
  {
    if (this.iUm == null) {
      this.iUm = b.a.iWe.getEmojiMgr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji
 * JD-Core Version:    0.7.0.1
 */