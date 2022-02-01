package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;

public class c
{
  public static c ovk;
  public ArrayList<String> ovl;
  public boolean ovm;
  public boolean ovn;
  
  public c()
  {
    AppMethodBeat.i(108415);
    this.ovl = new ArrayList();
    this.ovm = true;
    this.ovn = false;
    AppMethodBeat.o(108415);
  }
  
  public static void b(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108417);
    if (paramEmojiInfo != null)
    {
      paramEmojiInfo.field_reserved4 = 0;
      k.getEmojiStorageMgr().FyY.M(paramEmojiInfo);
      k.bUY().u(paramEmojiInfo);
      if (paramBoolean)
      {
        h.vKh.idkeyStat(231L, 0L, 1L, false);
        AppMethodBeat.o(108417);
        return;
      }
      h.vKh.idkeyStat(231L, 1L, 1L, false);
    }
    AppMethodBeat.o(108417);
  }
  
  private static boolean bUA()
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
  
  public static c bUz()
  {
    AppMethodBeat.i(108416);
    if (ovk == null) {}
    try
    {
      ovk = new c();
      c localc = ovk;
      AppMethodBeat.o(108416);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(108416);
    }
  }
  
  private void c(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108418);
    if (this.ovl == null) {
      this.ovl = new ArrayList();
    }
    this.ovl.add(paramEmojiInfo.field_groupId);
    paramEmojiInfo = new com.tencent.mm.plugin.emoji.f.g(paramEmojiInfo.field_groupId);
    com.tencent.mm.kernel.g.afA().gcy.a(paramEmojiInfo, 0);
    if (paramBoolean)
    {
      h.vKh.idkeyStat(231L, 3L, 1L, false);
      AppMethodBeat.o(108418);
      return;
    }
    h.vKh.idkeyStat(231L, 2L, 1L, false);
    AppMethodBeat.o(108418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.c
 * JD-Core Version:    0.7.0.1
 */