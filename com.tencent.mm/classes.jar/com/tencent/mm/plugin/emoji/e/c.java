package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;

public class c
{
  public static c oYK;
  public ArrayList<String> oYL;
  public boolean oYM;
  public boolean oYN;
  
  public c()
  {
    AppMethodBeat.i(108415);
    this.oYL = new ArrayList();
    this.oYM = true;
    this.oYN = false;
    AppMethodBeat.o(108415);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108417);
    if (paramEmojiInfo != null)
    {
      paramEmojiInfo.field_reserved4 = 0;
      k.getEmojiStorageMgr().GXZ.M(paramEmojiInfo);
      k.ccl().u(paramEmojiInfo);
      if (paramBoolean)
      {
        h.wUl.idkeyStat(231L, 0L, 1L, false);
        AppMethodBeat.o(108417);
        return;
      }
      h.wUl.idkeyStat(231L, 1L, 1L, false);
    }
    AppMethodBeat.o(108417);
  }
  
  private void c(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108418);
    if (this.oYL == null) {
      this.oYL = new ArrayList();
    }
    this.oYL.add(paramEmojiInfo.field_groupId);
    paramEmojiInfo = new com.tencent.mm.plugin.emoji.f.g(paramEmojiInfo.field_groupId);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramEmojiInfo, 0);
    if (paramBoolean)
    {
      h.wUl.idkeyStat(231L, 3L, 1L, false);
      AppMethodBeat.o(108418);
      return;
    }
    h.wUl.idkeyStat(231L, 2L, 1L, false);
    AppMethodBeat.o(108418);
  }
  
  public static c cbM()
  {
    AppMethodBeat.i(108416);
    if (oYK == null) {}
    try
    {
      oYK = new c();
      c localc = oYK;
      AppMethodBeat.o(108416);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(108416);
    }
  }
  
  private static boolean cbN()
  {
    AppMethodBeat.i(108419);
    if ((ax.is3G(ai.getContext())) || (ax.is4G(ai.getContext())) || (ax.is2G(ai.getContext())))
    {
      AppMethodBeat.o(108419);
      return true;
    }
    AppMethodBeat.o(108419);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.c
 * JD-Core Version:    0.7.0.1
 */