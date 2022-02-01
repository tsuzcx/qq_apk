package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;

public class c
{
  public static c qZt;
  public ArrayList<String> qZu;
  public boolean qZv;
  public boolean qZw;
  
  public c()
  {
    AppMethodBeat.i(108415);
    this.qZu = new ArrayList();
    this.qZv = true;
    this.qZw = false;
    AppMethodBeat.o(108415);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108417);
    if (paramEmojiInfo != null)
    {
      paramEmojiInfo.field_reserved4 = 0;
      k.getEmojiStorageMgr().OpN.M(paramEmojiInfo);
      k.cGd().u(paramEmojiInfo);
      if (paramBoolean)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(231L, 0L, 1L, false);
        AppMethodBeat.o(108417);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(231L, 1L, 1L, false);
    }
    AppMethodBeat.o(108417);
  }
  
  private void c(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108418);
    if (this.qZu == null) {
      this.qZu = new ArrayList();
    }
    this.qZu.add(paramEmojiInfo.field_groupId);
    paramEmojiInfo = new com.tencent.mm.plugin.emoji.f.h(paramEmojiInfo.field_groupId);
    g.aAg().hqi.a(paramEmojiInfo, 0);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(231L, 3L, 1L, false);
      AppMethodBeat.o(108418);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(231L, 2L, 1L, false);
    AppMethodBeat.o(108418);
  }
  
  public static c cFD()
  {
    AppMethodBeat.i(108416);
    if (qZt == null) {}
    try
    {
      qZt = new c();
      c localc = qZt;
      AppMethodBeat.o(108416);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(108416);
    }
  }
  
  private static boolean cFE()
  {
    AppMethodBeat.i(108419);
    if ((NetStatusUtil.is3G(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext())) || (NetStatusUtil.is2G(MMApplicationContext.getContext())))
    {
      AppMethodBeat.o(108419);
      return true;
    }
    AppMethodBeat.o(108419);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.c
 * JD-Core Version:    0.7.0.1
 */