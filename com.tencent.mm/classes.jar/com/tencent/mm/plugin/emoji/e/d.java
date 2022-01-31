package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.c;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.a;
import com.tencent.mm.ui.widget.b.e.c;
import java.util.ArrayList;

public class d
{
  public static d lfC;
  public ArrayList<String> lfD;
  public boolean lfE;
  public boolean lfF;
  
  public d()
  {
    AppMethodBeat.i(52852);
    this.lfD = new ArrayList();
    this.lfE = true;
    this.lfF = false;
    AppMethodBeat.o(52852);
  }
  
  public static void a(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(52854);
    if (paramEmojiInfo != null)
    {
      paramEmojiInfo.field_reserved4 = 0;
      i.getEmojiStorageMgr().yNn.K(paramEmojiInfo);
      i.blo().t(paramEmojiInfo);
      if (paramBoolean)
      {
        h.qsU.idkeyStat(231L, 0L, 1L, false);
        AppMethodBeat.o(52854);
        return;
      }
      h.qsU.idkeyStat(231L, 1L, 1L, false);
    }
    AppMethodBeat.o(52854);
  }
  
  private void b(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(52855);
    if (this.lfD == null) {
      this.lfD = new ArrayList();
    }
    this.lfD.add(paramEmojiInfo.field_groupId);
    paramEmojiInfo = new com.tencent.mm.plugin.emoji.f.g(paramEmojiInfo.field_groupId);
    com.tencent.mm.kernel.g.RK().eHt.a(paramEmojiInfo, 0);
    if (paramBoolean)
    {
      h.qsU.idkeyStat(231L, 3L, 1L, false);
      AppMethodBeat.o(52855);
      return;
    }
    h.qsU.idkeyStat(231L, 2L, 1L, false);
    AppMethodBeat.o(52855);
  }
  
  public static d bkN()
  {
    AppMethodBeat.i(52853);
    if (lfC == null) {}
    try
    {
      lfC = new d();
      d locald = lfC;
      AppMethodBeat.o(52853);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(52853);
    }
  }
  
  private static boolean bkO()
  {
    AppMethodBeat.i(52856);
    if ((com.tencent.mm.sdk.platformtools.at.is3G(ah.getContext())) || (com.tencent.mm.sdk.platformtools.at.is4G(ah.getContext())) || (com.tencent.mm.sdk.platformtools.at.is2G(ah.getContext())))
    {
      AppMethodBeat.o(52856);
      return true;
    }
    AppMethodBeat.o(52856);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.d
 * JD-Core Version:    0.7.0.1
 */