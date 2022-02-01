package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.abv;
import com.tencent.mm.f.a.dr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class q
{
  Set<String> uFi;
  Set<String> uFj;
  Set<String> uFk;
  IListener uFl;
  IListener uFm;
  
  public q()
  {
    AppMethodBeat.i(108657);
    this.uFl = new IListener() {};
    this.uFm = new IListener() {};
    EventCenter.instance.addListener(this.uFl);
    EventCenter.instance.addListener(this.uFm);
    this.uFi = Collections.synchronizedSet(new HashSet());
    this.uFj = Collections.synchronizedSet(new HashSet());
    this.uFk = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(108657);
  }
  
  final void cUU()
  {
    AppMethodBeat.i(108658);
    for (;;)
    {
      if (this.uFj.isEmpty())
      {
        Log.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
        AppMethodBeat.o(108658);
        return;
      }
      if (!this.uFk.isEmpty())
      {
        Log.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[] { this.uFk.toString() });
        AppMethodBeat.o(108658);
        return;
      }
      localObject = this.uFj.iterator();
      if (localObject == null) {
        break label198;
      }
      localObject = (String)((Iterator)localObject).next();
      this.uFj.remove(localObject);
      EmojiGroupInfo localEmojiGroupInfo = p.getEmojiStorageMgr().VFI.dt((String)localObject, true);
      if ((localEmojiGroupInfo == null) || ((localEmojiGroupInfo.field_flag & 0x100) <= 0)) {
        break;
      }
      Log.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[] { localObject });
    }
    Log.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[] { localObject });
    this.uFk.add(localObject);
    Object localObject = new com.tencent.mm.plugin.emoji.f.h((String)localObject, "");
    com.tencent.mm.kernel.h.aHF().kcd.a((com.tencent.mm.an.q)localObject, 0);
    label198:
    AppMethodBeat.o(108658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.q
 * JD-Core Version:    0.7.0.1
 */