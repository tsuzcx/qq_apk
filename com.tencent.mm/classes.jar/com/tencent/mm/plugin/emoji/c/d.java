package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;

public abstract interface d
  extends a
{
  public abstract bh getEmojiDescMgr();
  
  public abstract com.tencent.mm.pluginsdk.b.d getEmojiMgr();
  
  public abstract bl getEmojiStorageMgr();
  
  public abstract e getProvider();
  
  public abstract void removeEmojiMgr();
  
  public abstract void setEmojiMgr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c.d
 * JD-Core Version:    0.7.0.1
 */