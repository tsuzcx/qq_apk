package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class t
{
  Set<String> xNK;
  Set<String> xNL;
  Set<String> xNM;
  IListener xNN;
  IListener xNO;
  
  public t()
  {
    AppMethodBeat.i(108657);
    this.xNN = new WearEmojiLogic.1(this, f.hfK);
    this.xNO = new WearEmojiLogic.2(this, f.hfK);
    this.xNN.alive();
    this.xNO.alive();
    this.xNK = Collections.synchronizedSet(new HashSet());
    this.xNL = Collections.synchronizedSet(new HashSet());
    this.xNM = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(108657);
  }
  
  final void dAr()
  {
    AppMethodBeat.i(108658);
    for (;;)
    {
      if (this.xNL.isEmpty())
      {
        Log.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
        AppMethodBeat.o(108658);
        return;
      }
      if (!this.xNM.isEmpty())
      {
        Log.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[] { this.xNM.toString() });
        AppMethodBeat.o(108658);
        return;
      }
      localObject = this.xNL.iterator();
      if (localObject == null) {
        break label198;
      }
      localObject = (String)((Iterator)localObject).next();
      this.xNL.remove(localObject);
      EmojiGroupInfo localEmojiGroupInfo = s.getEmojiStorageMgr().adjv.ec((String)localObject, true);
      if ((localEmojiGroupInfo == null) || ((localEmojiGroupInfo.field_flag & 0x100) <= 0)) {
        break;
      }
      Log.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[] { localObject });
    }
    Log.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[] { localObject });
    this.xNM.add(localObject);
    Object localObject = new com.tencent.mm.plugin.emoji.e.h((String)localObject, "");
    com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
    label198:
    AppMethodBeat.o(108658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.t
 * JD-Core Version:    0.7.0.1
 */