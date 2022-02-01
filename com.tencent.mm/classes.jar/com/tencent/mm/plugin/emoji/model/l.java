package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class l
{
  com.tencent.mm.sdk.b.c pbA;
  Set<String> pbw;
  Set<String> pbx;
  Set<String> pby;
  com.tencent.mm.sdk.b.c pbz;
  
  public l()
  {
    AppMethodBeat.i(108657);
    this.pbz = new com.tencent.mm.sdk.b.c() {};
    this.pbA = new com.tencent.mm.sdk.b.c() {};
    a.GpY.c(this.pbz);
    a.GpY.c(this.pbA);
    this.pbw = Collections.synchronizedSet(new HashSet());
    this.pbx = Collections.synchronizedSet(new HashSet());
    this.pby = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(108657);
  }
  
  final void ccs()
  {
    AppMethodBeat.i(108658);
    for (;;)
    {
      if (this.pbx.isEmpty())
      {
        ac.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
        AppMethodBeat.o(108658);
        return;
      }
      if (!this.pby.isEmpty())
      {
        ac.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[] { this.pby.toString() });
        AppMethodBeat.o(108658);
        return;
      }
      localObject = this.pbx.iterator();
      if (localObject == null) {
        break label198;
      }
      localObject = (String)((Iterator)localObject).next();
      this.pbx.remove(localObject);
      EmojiGroupInfo localEmojiGroupInfo = k.getEmojiStorageMgr().GYa.cE((String)localObject, true);
      if ((localEmojiGroupInfo == null) || ((localEmojiGroupInfo.field_flag & 0x100) <= 0)) {
        break;
      }
      ac.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[] { localObject });
    }
    ac.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[] { localObject });
    this.pby.add(localObject);
    Object localObject = new com.tencent.mm.plugin.emoji.f.g((String)localObject, "");
    com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
    label198:
    AppMethodBeat.o(108658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.l
 * JD-Core Version:    0.7.0.1
 */