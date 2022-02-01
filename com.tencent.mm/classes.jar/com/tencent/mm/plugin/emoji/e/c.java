package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;

public class c
{
  public static c pCu;
  public ArrayList<String> pCv;
  public boolean pCw;
  public boolean pCx;
  
  public c()
  {
    AppMethodBeat.i(108415);
    this.pCv = new ArrayList();
    this.pCw = true;
    this.pCx = false;
    AppMethodBeat.o(108415);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108417);
    if (paramEmojiInfo != null)
    {
      paramEmojiInfo.field_reserved4 = 0;
      k.getEmojiStorageMgr().ILn.L(paramEmojiInfo);
      k.cgP().u(paramEmojiInfo);
      if (paramBoolean)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(231L, 0L, 1L, false);
        AppMethodBeat.o(108417);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(231L, 1L, 1L, false);
    }
    AppMethodBeat.o(108417);
  }
  
  private void c(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108418);
    if (this.pCv == null) {
      this.pCv = new ArrayList();
    }
    this.pCv.add(paramEmojiInfo.field_groupId);
    paramEmojiInfo = new com.tencent.mm.plugin.emoji.f.g(paramEmojiInfo.field_groupId);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramEmojiInfo, 0);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(231L, 3L, 1L, false);
      AppMethodBeat.o(108418);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(231L, 2L, 1L, false);
    AppMethodBeat.o(108418);
  }
  
  public static c cgq()
  {
    AppMethodBeat.i(108416);
    if (pCu == null) {}
    try
    {
      pCu = new c();
      c localc = pCu;
      AppMethodBeat.o(108416);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(108416);
    }
  }
  
  private static boolean cgr()
  {
    AppMethodBeat.i(108419);
    if ((ay.is3G(aj.getContext())) || (ay.is4G(aj.getContext())) || (ay.is2G(aj.getContext())))
    {
      AppMethodBeat.o(108419);
      return true;
    }
    AppMethodBeat.o(108419);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.c
 * JD-Core Version:    0.7.0.1
 */