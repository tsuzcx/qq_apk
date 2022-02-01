package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.di;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class l
{
  Set<String> pFg;
  Set<String> pFh;
  Set<String> pFi;
  com.tencent.mm.sdk.b.c pFj;
  com.tencent.mm.sdk.b.c pFk;
  
  public l()
  {
    AppMethodBeat.i(108657);
    this.pFj = new l.1(this);
    this.pFk = new com.tencent.mm.sdk.b.c() {};
    a.IbL.c(this.pFj);
    a.IbL.c(this.pFk);
    this.pFg = Collections.synchronizedSet(new HashSet());
    this.pFh = Collections.synchronizedSet(new HashSet());
    this.pFi = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(108657);
  }
  
  final void cgW()
  {
    AppMethodBeat.i(108658);
    for (;;)
    {
      if (this.pFh.isEmpty())
      {
        ad.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
        AppMethodBeat.o(108658);
        return;
      }
      if (!this.pFi.isEmpty())
      {
        ad.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[] { this.pFi.toString() });
        AppMethodBeat.o(108658);
        return;
      }
      localObject = this.pFh.iterator();
      if (localObject == null) {
        break label198;
      }
      localObject = (String)((Iterator)localObject).next();
      this.pFh.remove(localObject);
      EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().ILo.cJ((String)localObject, true);
      if ((localEmojiGroupInfo == null) || ((localEmojiGroupInfo.field_flag & 0x100) <= 0)) {
        break;
      }
      ad.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[] { localObject });
    }
    ad.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[] { localObject });
    this.pFi.add(localObject);
    Object localObject = new com.tencent.mm.plugin.emoji.f.g((String)localObject, "");
    com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject, 0);
    label198:
    AppMethodBeat.o(108658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.l
 * JD-Core Version:    0.7.0.1
 */