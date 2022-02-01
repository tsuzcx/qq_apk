package com.tencent.mm.emoji.loader.e;

import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "finished", "", "requests", "", "Lcom/tencent/mm/emoji/loader/request/Request;", "kotlin.jvm.PlatformType", "", "result", "running", "runningInQueue", "started", "addRequest", "", "request", "call", "getTaskKey", "", "onResult", "success", "removeRequest", "run", "start", "async", "uniqueId", "plugin-emojisdk_release"})
public abstract class c
  extends com.tencent.mm.loader.g.c
  implements Runnable
{
  private boolean bWS;
  private boolean gjF;
  final EmojiInfo gjb;
  private final List<i<?>> requests;
  private boolean result;
  private boolean running;
  private boolean started;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    this.gjb = paramEmojiInfo;
    this.requests = Collections.synchronizedList((List)new LinkedList());
  }
  
  public abstract String aeJ();
  
  public final String aeK()
  {
    return aeJ();
  }
  
  public final void c(i<?> parami)
  {
    p.h(parami, "request");
    if (this.bWS) {
      parami.dh(this.result);
    }
    while (this.requests.contains(parami)) {
      return;
    }
    this.requests.add(parami);
  }
  
  public final void call()
  {
    this.gjF = true;
    run();
  }
  
  public final void d(i<?> parami)
  {
    p.h(parami, "request");
    this.requests.remove(parami);
    if (this.requests.size() == 0)
    {
      ad.d(d.aeD(), "cancel " + aeJ() + ", " + this.running);
      if (!this.running)
      {
        parami = e.giz;
        e.vR(aeJ());
        dg(false);
      }
    }
  }
  
  public void dg(boolean paramBoolean)
  {
    this.result = paramBoolean;
    this.bWS = true;
    if (this.gjF) {
      a(j.hfK);
    }
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      Object localObject1 = this.requests;
      p.g(localObject1, "requests");
      try
      {
        localLinkedList.addAll((Collection)this.requests);
        this.requests.clear();
        z localz = z.MKo;
        localObject1 = ((Iterable)localLinkedList).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ((i)((Iterator)localObject1).next()).dh(paramBoolean);
          continue;
          localObject1 = e.giz;
          e.vR(aeJ());
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
      e locale = e.giz;
      e.a(aeJ(), this, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.c
 * JD-Core Version:    0.7.0.1
 */