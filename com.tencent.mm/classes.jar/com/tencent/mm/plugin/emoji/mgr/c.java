package com.tencent.mm.plugin.emoji.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.widget.a.g.c;
import java.util.ArrayList;

public class c
{
  public static c xKQ;
  public ArrayList<String> xKR;
  public boolean xKS;
  public boolean xKT;
  
  public c()
  {
    AppMethodBeat.i(108415);
    this.xKR = new ArrayList();
    this.xKS = true;
    this.xKT = false;
    AppMethodBeat.o(108415);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108417);
    if (paramEmojiInfo != null)
    {
      paramEmojiInfo.field_reserved4 = 0;
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.N(paramEmojiInfo);
      com.tencent.mm.plugin.emoji.model.s.dAj().u(paramEmojiInfo);
      if (paramBoolean)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(231L, 0L, 1L, false);
        AppMethodBeat.o(108417);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(231L, 1L, 1L, false);
    }
    AppMethodBeat.o(108417);
  }
  
  private void c(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108418);
    if (this.xKR == null) {
      this.xKR = new ArrayList();
    }
    this.xKR.add(paramEmojiInfo.field_groupId);
    paramEmojiInfo = new com.tencent.mm.plugin.emoji.e.h(paramEmojiInfo.field_groupId);
    com.tencent.mm.kernel.h.baD().mCm.a(paramEmojiInfo, 0);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(231L, 3L, 1L, false);
      AppMethodBeat.o(108418);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(231L, 2L, 1L, false);
    AppMethodBeat.o(108418);
  }
  
  public static c dzq()
  {
    AppMethodBeat.i(108416);
    if (xKQ == null) {}
    try
    {
      xKQ = new c();
      c localc = xKQ;
      AppMethodBeat.o(108416);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(108416);
    }
  }
  
  private static boolean dzr()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.mgr.c
 * JD-Core Version:    0.7.0.1
 */