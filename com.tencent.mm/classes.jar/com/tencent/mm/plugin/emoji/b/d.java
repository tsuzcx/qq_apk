package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.az;

public abstract interface d
  extends a
{
  public abstract av getEmojiDescMgr();
  
  public abstract com.tencent.mm.pluginsdk.a.d getEmojiMgr();
  
  public abstract az getEmojiStorageMgr();
  
  public abstract e getProvider();
  
  public abstract void removeEmojiMgr();
  
  public abstract void setEmojiMgr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.b.d
 * JD-Core Version:    0.7.0.1
 */