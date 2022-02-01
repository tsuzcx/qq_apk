package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.be;

public abstract interface d
  extends a
{
  public abstract ba getEmojiDescMgr();
  
  public abstract com.tencent.mm.pluginsdk.a.d getEmojiMgr();
  
  public abstract be getEmojiStorageMgr();
  
  public abstract e getProvider();
  
  public abstract void removeEmojiMgr();
  
  public abstract void setEmojiMgr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.b.d
 * JD-Core Version:    0.7.0.1
 */