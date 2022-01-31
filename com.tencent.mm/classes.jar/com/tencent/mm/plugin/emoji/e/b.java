package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

public class b
{
  public static b iWu;
  public ArrayList<String> iWv = new ArrayList();
  public boolean iWw = true;
  public boolean iWx = false;
  
  public static void a(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    if (paramEmojiInfo != null)
    {
      paramEmojiInfo.field_reserved4 = 0;
      i.getEmojiStorageMgr().uBb.r(paramEmojiInfo);
      i.aHO().i(paramEmojiInfo);
      if (paramBoolean) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(231L, 0L, 1L, false);
      }
    }
    else
    {
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(231L, 1L, 1L, false);
  }
  
  public static b aGZ()
  {
    if (iWu == null) {}
    try
    {
      iWu = new b();
      return iWu;
    }
    finally {}
  }
  
  private static boolean aHa()
  {
    return (aq.is3G(ae.getContext())) || (aq.is4G(ae.getContext())) || (aq.is2G(ae.getContext()));
  }
  
  private void b(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    if (this.iWv == null) {
      this.iWv = new ArrayList();
    }
    this.iWv.add(paramEmojiInfo.field_groupId);
    paramEmojiInfo = new com.tencent.mm.plugin.emoji.f.h(paramEmojiInfo.field_groupId);
    g.DO().dJT.a(paramEmojiInfo, 0);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(231L, 3L, 1L, false);
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(231L, 2L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b
 * JD-Core Version:    0.7.0.1
 */