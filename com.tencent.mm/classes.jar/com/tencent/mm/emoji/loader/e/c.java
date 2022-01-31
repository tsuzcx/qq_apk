package com.tencent.mm.emoji.loader.e;

import a.f.b.j;
import a.l;
import a.y;
import com.tencent.mm.emoji.loader.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "finished", "", "requests", "", "Lcom/tencent/mm/emoji/loader/request/Request;", "kotlin.jvm.PlatformType", "", "result", "running", "runningInQueue", "started", "addRequest", "", "request", "call", "getTaskKey", "", "onResult", "success", "removeRequest", "run", "start", "async", "uniqueId", "plugin-emojisdk_release"})
public abstract class c
  extends com.tencent.mm.loader.g.c
  implements Runnable
{
  private boolean bmx;
  private boolean cmX;
  final EmojiInfo evH;
  private boolean ewg;
  private final List<com.tencent.mm.emoji.loader.d.h<?>> requests;
  private boolean running;
  private boolean started;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    this.evH = paramEmojiInfo;
    this.requests = Collections.synchronizedList((List)new LinkedList());
  }
  
  public abstract String Ox();
  
  public final String Oy()
  {
    return Ox();
  }
  
  public final void b(com.tencent.mm.emoji.loader.d.h<?> paramh)
  {
    j.q(paramh, "request");
    if (this.bmx) {
      paramh.cf(this.cmX);
    }
    while (this.requests.contains(paramh)) {
      return;
    }
    this.requests.add(paramh);
  }
  
  public final void c(com.tencent.mm.emoji.loader.d.h<?> paramh)
  {
    j.q(paramh, "request");
    this.requests.remove(paramh);
    if (this.requests.size() == 0)
    {
      ab.d(d.Ot(), "cancel " + Ox() + ", " + this.running);
      if (!this.running)
      {
        paramh = a.evk;
        a.lI(Ox());
        cd(false);
      }
    }
  }
  
  public final void call()
  {
    this.ewg = true;
    run();
  }
  
  public void cd(boolean paramBoolean)
  {
    this.cmX = paramBoolean;
    this.bmx = true;
    if (this.ewg) {
      a(com.tencent.mm.loader.g.h.ePv);
    }
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      Object localObject1 = this.requests;
      j.p(localObject1, "requests");
      try
      {
        localLinkedList.addAll((Collection)this.requests);
        this.requests.clear();
        y localy = y.BMg;
        localObject1 = ((Iterable)localLinkedList).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ((com.tencent.mm.emoji.loader.d.h)((Iterator)localObject1).next()).cf(paramBoolean);
          continue;
          localObject1 = a.evk;
          a.lI(Ox());
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
      a locala = a.evk;
      a.a(Ox(), this, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.c
 * JD-Core Version:    0.7.0.1
 */