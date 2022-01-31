package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class j
{
  Set<String> lhS;
  Set<String> lhT;
  Set<String> lhU;
  c lhV;
  c lhW;
  
  public j()
  {
    AppMethodBeat.i(53082);
    this.lhV = new j.1(this);
    this.lhW = new j.2(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.lhV);
    com.tencent.mm.sdk.b.a.ymk.c(this.lhW);
    this.lhS = Collections.synchronizedSet(new HashSet());
    this.lhT = Collections.synchronizedSet(new HashSet());
    this.lhU = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(53082);
  }
  
  final void blv()
  {
    AppMethodBeat.i(53083);
    for (;;)
    {
      if (this.lhT.isEmpty())
      {
        ab.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
        AppMethodBeat.o(53083);
        return;
      }
      if (!this.lhU.isEmpty())
      {
        ab.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[] { this.lhU.toString() });
        AppMethodBeat.o(53083);
        return;
      }
      localObject = this.lhT.iterator();
      if (localObject == null) {
        break label198;
      }
      localObject = (String)((Iterator)localObject).next();
      this.lhT.remove(localObject);
      EmojiGroupInfo localEmojiGroupInfo = i.getEmojiStorageMgr().yNo.cg((String)localObject, true);
      if ((localEmojiGroupInfo == null) || ((localEmojiGroupInfo.field_flag & 0x100) <= 0)) {
        break;
      }
      ab.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[] { localObject });
    }
    ab.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[] { localObject });
    this.lhU.add(localObject);
    Object localObject = new com.tencent.mm.plugin.emoji.f.g((String)localObject, "");
    com.tencent.mm.kernel.g.RK().eHt.a((m)localObject, 0);
    label198:
    AppMethodBeat.o(53083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.j
 * JD-Core Version:    0.7.0.1
 */