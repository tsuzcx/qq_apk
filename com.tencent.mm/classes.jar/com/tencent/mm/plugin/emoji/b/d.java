package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;

public abstract interface d
  extends a
{
  public abstract az getEmojiDescMgr();
  
  public abstract com.tencent.mm.pluginsdk.a.d getEmojiMgr();
  
  public abstract bd getEmojiStorageMgr();
  
  public abstract e getProvider();
  
  public abstract void removeEmojiMgr();
  
  public abstract void setEmojiMgr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.b.d
 * JD-Core Version:    0.7.0.1
 */