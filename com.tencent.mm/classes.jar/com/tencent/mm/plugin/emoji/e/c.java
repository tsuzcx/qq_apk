package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;

public class c
{
  public static c pIY;
  public ArrayList<String> pIZ;
  public boolean pJa;
  public boolean pJb;
  
  public c()
  {
    AppMethodBeat.i(108415);
    this.pIZ = new ArrayList();
    this.pJa = true;
    this.pJb = false;
    AppMethodBeat.o(108415);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108417);
    if (paramEmojiInfo != null)
    {
      paramEmojiInfo.field_reserved4 = 0;
      k.getEmojiStorageMgr().JfU.L(paramEmojiInfo);
      k.cif().u(paramEmojiInfo);
      if (paramBoolean)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(231L, 0L, 1L, false);
        AppMethodBeat.o(108417);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(231L, 1L, 1L, false);
    }
    AppMethodBeat.o(108417);
  }
  
  private void c(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108418);
    if (this.pIZ == null) {
      this.pIZ = new ArrayList();
    }
    this.pIZ.add(paramEmojiInfo.field_groupId);
    paramEmojiInfo = new com.tencent.mm.plugin.emoji.f.g(paramEmojiInfo.field_groupId);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramEmojiInfo, 0);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(231L, 3L, 1L, false);
      AppMethodBeat.o(108418);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(231L, 2L, 1L, false);
    AppMethodBeat.o(108418);
  }
  
  public static c chG()
  {
    AppMethodBeat.i(108416);
    if (pIY == null) {}
    try
    {
      pIY = new c();
      c localc = pIY;
      AppMethodBeat.o(108416);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(108416);
    }
  }
  
  private static boolean chH()
  {
    AppMethodBeat.i(108419);
    if ((az.is3G(ak.getContext())) || (az.is4G(ak.getContext())) || (az.is2G(ak.getContext())))
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