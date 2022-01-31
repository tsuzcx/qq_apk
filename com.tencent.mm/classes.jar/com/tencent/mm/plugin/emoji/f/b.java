package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public class b
  extends am
{
  private static int iZl = 0;
  private static b iZm;
  private static r iZn;
  private static f iZo = new b.1();
  
  private b()
  {
    super(new b.a(), true);
  }
  
  public static final b aHY()
  {
    if (iZm == null) {}
    for (;;)
    {
      try
      {
        if (iZm == null) {
          iZm = new b();
        }
        return iZm;
      }
      finally {}
      iZm.stopTimer();
    }
  }
  
  public static void aHZ()
  {
    iZl = 0;
    iZn = new r("com.tencent.xin.emoticon.tusiji", 1);
    g.DO().dJT.a(iZn, 0);
    g.DO().dJT.a(413, iZo);
    y.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
  }
  
  public static void ch()
  {
    if (iZn != null) {
      g.DO().dJT.c(iZn);
    }
    g.DO().dJT.b(413, iZo);
    y.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
  }
  
  public final void aIa()
  {
    stopTimer();
    i.aHU().g(a.aJK(), 3, iZl, "");
    ch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.b
 * JD-Core Version:    0.7.0.1
 */