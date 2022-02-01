package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class l
{
  Set<String> rcd;
  Set<String> rce;
  Set<String> rcf;
  IListener rcg;
  IListener rch;
  
  public l()
  {
    AppMethodBeat.i(108657);
    this.rcg = new l.1(this);
    this.rch = new IListener() {};
    EventCenter.instance.addListener(this.rcg);
    EventCenter.instance.addListener(this.rch);
    this.rcd = Collections.synchronizedSet(new HashSet());
    this.rce = Collections.synchronizedSet(new HashSet());
    this.rcf = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(108657);
  }
  
  final void cGl()
  {
    AppMethodBeat.i(108658);
    for (;;)
    {
      if (this.rce.isEmpty())
      {
        Log.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
        AppMethodBeat.o(108658);
        return;
      }
      if (!this.rcf.isEmpty())
      {
        Log.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[] { this.rcf.toString() });
        AppMethodBeat.o(108658);
        return;
      }
      localObject = this.rce.iterator();
      if (localObject == null) {
        break label198;
      }
      localObject = (String)((Iterator)localObject).next();
      this.rce.remove(localObject);
      EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().OpO.di((String)localObject, true);
      if ((localEmojiGroupInfo == null) || ((localEmojiGroupInfo.field_flag & 0x100) <= 0)) {
        break;
      }
      Log.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[] { localObject });
    }
    Log.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[] { localObject });
    this.rcf.add(localObject);
    Object localObject = new h((String)localObject, "");
    g.aAg().hqi.a((q)localObject, 0);
    label198:
    AppMethodBeat.o(108658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.l
 * JD-Core Version:    0.7.0.1
 */