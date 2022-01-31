package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.e.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public Object ceG;
  public com.tencent.mm.audio.mix.f.d cfs;
  public HashMap<String, b> cft;
  public HashMap<String, com.tencent.mm.ag.b> cfu;
  public List<String> cfv;
  public LinkedList<String> cfw;
  
  public a(com.tencent.mm.audio.mix.f.d paramd)
  {
    AppMethodBeat.i(137038);
    this.cft = new HashMap();
    this.cfu = new HashMap();
    this.cfv = new ArrayList();
    this.cfw = new LinkedList();
    this.ceG = new Object();
    this.cfs = paramd;
    com.tencent.mm.audio.mix.b.d.De().clearCache();
    AppMethodBeat.o(137038);
  }
  
  public final void Dm()
  {
    AppMethodBeat.i(137041);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopAll");
    Iterator localIterator = this.cfw.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (b)this.cft.get(localObject);
      if ((localObject != null) && (!((b)localObject).cfz) && (!((b)localObject).Dn()))
      {
        localObject = ((b)localObject).cfA;
        if (localObject != null) {
          ((k)localObject).stop();
        }
      }
    }
    AppMethodBeat.o(137041);
  }
  
  public final boolean b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(137044);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "doDecodeAudio");
    if (this.cfs == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "mPlayer is null!");
      AppMethodBeat.o(137044);
      return false;
    }
    Object localObject2 = (com.tencent.mm.ag.b)this.cfu.get(paramString);
    if (localObject2 == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      AppMethodBeat.o(137044);
      return false;
    }
    Object localObject1 = (b)this.cft.get(paramString);
    k localk;
    if (localObject1 != null)
    {
      if ((((b)localObject1).cfz) && (!this.cfs.chs.Dt()) && (!this.cfs.chs.ei(paramString)))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
        AppMethodBeat.o(137044);
        return true;
      }
      if (((b)localObject1).cfz)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, reset source and decoder to run");
        ((b)localObject1).cfz = false;
        paramString = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.ag.b)localObject2);
        ((b)localObject1).b(f.a(this.cfs, paramString, paramBoolean2));
        h.a((i)localObject1);
        AppMethodBeat.o(137044);
        return true;
      }
      localk = ((b)localObject1).cfA;
      if ((localk == null) || (!paramBoolean1)) {
        break label305;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "force decode to stop and create new task to run");
      localk.stop();
    }
    label305:
    do
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is not exist, create new task to run");
      localObject1 = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.ag.b)localObject2);
      localObject1 = f.a(this.cfs, (com.tencent.mm.audio.mix.g.b)localObject1, paramBoolean2);
      localObject2 = new b(new a.1(this), paramString);
      ((b)localObject2).b((k)localObject1);
      h.a((i)localObject2);
      this.cft.put(paramString, localObject2);
      AppMethodBeat.o(137044);
      return true;
      if ((localk != null) && (localk.Ds()) && (!localk.Dt()))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "resume decoder to run");
        localk.resume();
        AppMethodBeat.o(137044);
        return true;
      }
      if ((localk != null) && (localk.Dt()))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "decoder to stop, reset task run");
        ((b)localObject1).cfz = false;
        paramString = new com.tencent.mm.audio.mix.g.a((com.tencent.mm.ag.b)localObject2);
        ((b)localObject1).b(f.a(this.cfs, paramString, paramBoolean2));
        h.a((i)localObject1);
        AppMethodBeat.o(137044);
        return true;
      }
    } while (localk == null);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is run and playing audio");
    AppMethodBeat.o(137044);
    return true;
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(137039);
    this.cft.clear();
    this.cfw.clear();
    this.cfu.clear();
    AppMethodBeat.o(137039);
  }
  
  public final boolean dX(String paramString)
  {
    AppMethodBeat.i(137040);
    synchronized (this.ceG)
    {
      boolean bool = this.cfv.contains(paramString);
      AppMethodBeat.o(137040);
      return bool;
    }
  }
  
  public final void dY(String paramString)
  {
    AppMethodBeat.i(137042);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "startDecode audioId:%s", new Object[] { paramString });
    b(paramString, false, false);
    AppMethodBeat.o(137042);
  }
  
  public final void dZ(String paramString)
  {
    AppMethodBeat.i(137043);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopDecode audioId:%s", new Object[] { paramString });
    b localb = (b)this.cft.get(paramString);
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(137043);
      return;
    }
    if (localb.cfz)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(137043);
      return;
    }
    k localk = localb.cfA;
    if (localk != null)
    {
      localk.stop();
      localb.cfA = null;
      this.cft.remove(paramString);
    }
    AppMethodBeat.o(137043);
  }
  
  public final boolean ea(String paramString)
  {
    AppMethodBeat.i(137047);
    paramString = (b)this.cft.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(137047);
      return true;
    }
    if (paramString.cfz)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(137047);
      return true;
    }
    if (paramString.Dn())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(137047);
      return true;
    }
    AppMethodBeat.o(137047);
    return false;
  }
  
  public final boolean eb(String paramString)
  {
    AppMethodBeat.i(137048);
    b localb = (b)this.cft.get(paramString);
    if ((localb != null) && (localb.cfz) && (!this.cfs.chs.Dt()) && (!this.cfs.chs.ei(paramString)))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
      AppMethodBeat.o(137048);
      return true;
    }
    AppMethodBeat.o(137048);
    return false;
  }
  
  public final boolean u(String paramString, int paramInt)
  {
    AppMethodBeat.i(137045);
    if (!v(paramString, paramInt))
    {
      AppMethodBeat.o(137045);
      return false;
    }
    v(paramString, paramInt);
    paramString = (b)this.cft.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(137045);
      return false;
    }
    if (paramString.cfz)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(137045);
      return false;
    }
    if (paramString.Dn())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(137045);
      return false;
    }
    paramString = paramString.cfA;
    if (paramString != null) {
      paramString.seek(paramInt);
    }
    AppMethodBeat.o(137045);
    return true;
  }
  
  public final boolean v(String paramString, int paramInt)
  {
    AppMethodBeat.i(137046);
    com.tencent.mm.ag.b localb = (com.tencent.mm.ag.b)this.cfu.get(paramString);
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      AppMethodBeat.o(137046);
      return false;
    }
    localb.startTime = paramInt;
    AppMethodBeat.o(137046);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.a
 * JD-Core Version:    0.7.0.1
 */