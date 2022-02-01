package com.tencent.mm.emoji.sync;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/IEmojiSyncLoader;", "", "checkSyncEmoji", "", "start", "", "destroy", "getSyncCount", "", "getTargetSyncCount", "getWaitingIndex", "hasMore", "init", "loadMore", "registerCallback", "callback", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "unregisterCallback", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface j
{
  public abstract void a(g.i parami);
  
  public abstract void aWi();
  
  public abstract int aWj();
  
  public abstract int aWk();
  
  public abstract boolean aWl();
  
  public abstract void b(g.i parami);
  
  public abstract void destroy();
  
  public abstract void fo(boolean paramBoolean);
  
  public abstract void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.j
 * JD-Core Version:    0.7.0.1
 */