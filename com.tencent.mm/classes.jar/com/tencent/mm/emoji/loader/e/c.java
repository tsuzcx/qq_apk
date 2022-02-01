package com.tencent.mm.emoji.loader.e;

import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "finished", "", "requests", "", "Lcom/tencent/mm/emoji/loader/request/Request;", "kotlin.jvm.PlatformType", "", "result", "running", "runningInQueue", "started", "addRequest", "", "request", "call", "getTaskKey", "", "onResult", "success", "removeRequest", "run", "start", "async", "uniqueId", "plugin-emojisdk_release"})
public abstract class c
  extends com.tencent.mm.loader.g.c
  implements Runnable
{
  private boolean jHL;
  private boolean jHM;
  final EmojiInfo jHh;
  private final List<i<?>> requests;
  private boolean result;
  private boolean running;
  private boolean started;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    this.jHh = paramEmojiInfo;
    this.requests = Collections.synchronizedList((List)new LinkedList());
  }
  
  public abstract String aBF();
  
  public final String aBG()
  {
    return aBF();
  }
  
  public final void c(i<?> parami)
  {
    p.k(parami, "request");
    if (this.jHM) {
      parami.eq(this.result);
    }
    while (this.requests.contains(parami)) {
      return;
    }
    this.requests.add(parami);
  }
  
  public final void call()
  {
    this.jHL = true;
    run();
  }
  
  public final void d(i<?> parami)
  {
    p.k(parami, "request");
    this.requests.remove(parami);
    if (this.requests.size() == 0)
    {
      Log.d(d.aBy(), "cancel " + aBF() + ", " + this.running);
      if (!this.running)
      {
        parami = e.jGI;
        e.LG(aBF());
        ep(false);
      }
    }
  }
  
  public void ep(boolean paramBoolean)
  {
    this.result = paramBoolean;
    this.jHM = true;
    if (this.jHL) {
      a(j.kQd);
    }
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      Object localObject1 = this.requests;
      p.j(localObject1, "requests");
      try
      {
        localLinkedList.addAll((Collection)this.requests);
        this.requests.clear();
        x localx = x.aazN;
        localObject1 = ((Iterable)localLinkedList).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ((i)((Iterator)localObject1).next()).eq(paramBoolean);
          continue;
          localObject1 = e.jGI;
          e.LG(aBF());
        }
      }
      finally {}
    }
  }
  
  public void run()
  {
    this.running = true;
  }
  
  public final void start(boolean paramBoolean)
  {
    if (!this.started)
    {
      this.started = true;
      e locale = e.jGI;
      e.a(aBF(), this, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.c
 * JD-Core Version:    0.7.0.1
 */