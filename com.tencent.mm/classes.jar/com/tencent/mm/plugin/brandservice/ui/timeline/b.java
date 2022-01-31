package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.d;
import com.tencent.mm.at.d.a;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.q;
import java.util.HashMap;

public final class b
  implements d.a
{
  int jWe;
  public HashMap<Long, Integer> jWf;
  private h jWg;
  
  public b(h paramh)
  {
    AppMethodBeat.i(14133);
    this.jWf = new HashMap();
    this.jWg = paramh;
    AppMethodBeat.o(14133);
  }
  
  private void a(com.tencent.mm.at.e parame, q paramq, int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(14134);
    if (o.ahD().a(parame.fDL, paramq.field_msgId, 0, Integer.valueOf(paramInt), 2130838228, this, 0, false) == -2)
    {
      ab.w("MicroMsg.BizTimeLineImgMsgHandler", "it is already download image finish, but imgInfo is old, search db and repair.");
      parame = c(paramq);
      if (parame == null)
      {
        ab.w("MicroMsg.BizTimeLineImgMsgHandler", "get imgInfo by db but it is null.");
        AppMethodBeat.o(14134);
        return;
      }
      parame = g(parame);
      if (com.tencent.mm.vfs.e.cN(parame)) {
        a(parame, paramImageView);
      }
    }
    AppMethodBeat.o(14134);
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(14136);
    if (this.jWe != 0) {}
    for (int i = 2130837949;; i = 0)
    {
      a locala = o.ahG();
      c.a locala1 = new c.a();
      locala1.eOc = "biz_nor_img".concat(String.valueOf(i));
      locala1.eOa = 2131689878;
      locala1.fHt = 1;
      locala.a(paramString, paramImageView, locala1.ahY(), new b.1(this, i));
      AppMethodBeat.o(14136);
      return;
    }
  }
  
  private static com.tencent.mm.at.e c(q paramq)
  {
    AppMethodBeat.i(14138);
    com.tencent.mm.at.e locale1 = null;
    if (paramq.field_msgId > 0L) {
      locale1 = o.ahC().gT(paramq.field_msgId);
    }
    com.tencent.mm.at.e locale2;
    if (locale1 != null)
    {
      locale2 = locale1;
      if (locale1.fDL > 0L) {}
    }
    else
    {
      locale2 = locale1;
      if (paramq.field_msgSvrId > 0L) {
        locale2 = o.ahC().gS(paramq.field_msgSvrId);
      }
    }
    AppMethodBeat.o(14138);
    return locale2;
  }
  
  private static String g(com.tencent.mm.at.e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(14137);
    if (parame == null)
    {
      AppMethodBeat.o(14137);
      return null;
    }
    String str = parame.fDM;
    Object localObject1 = localObject2;
    if (parame.ahh())
    {
      parame = o.ahC().d(parame);
      localObject1 = localObject2;
      if (parame != null)
      {
        parame = o.ahC().q(parame, "", "");
        localObject1 = localObject2;
        if (com.tencent.mm.vfs.e.cN(parame))
        {
          ab.i("MicroMsg.BizTimeLineImgMsgHandler", "hasHdImg");
          localObject1 = parame;
        }
      }
    }
    parame = (com.tencent.mm.at.e)localObject1;
    if (localObject1 == null) {
      parame = o.ahC().q(str, "", "");
    }
    AppMethodBeat.o(14137);
    return parame;
  }
  
  private int hR(long paramLong)
  {
    AppMethodBeat.i(14140);
    if (this.jWf.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((Integer)this.jWf.get(Long.valueOf(paramLong))).intValue();
      AppMethodBeat.o(14140);
      return i;
    }
    AppMethodBeat.o(14140);
    return 0;
  }
  
  private void l(long paramLong, int paramInt)
  {
    AppMethodBeat.i(14141);
    this.jWf.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(14141);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    AppMethodBeat.i(14139);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      ab.i("MicroMsg.BizTimeLineImgMsgHandler", "onImgTaskEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      if (paramInt4 == -5103059)
      {
        l(paramLong2, 2);
        AppMethodBeat.o(14139);
        return;
      }
      l(paramLong2, 3);
      AppMethodBeat.o(14139);
      return;
    }
    l(paramLong2, 1);
    this.jWg.aWN();
    AppMethodBeat.o(14139);
  }
  
  public final void a(q paramq, int paramInt1, ImageView paramImageView, int paramInt2)
  {
    AppMethodBeat.i(14135);
    this.jWe = paramInt2;
    if ((hR(paramq.field_msgId) == 2) || (hR(paramq.field_msgId) == 3))
    {
      AppMethodBeat.o(14135);
      return;
    }
    com.tencent.mm.at.e locale = c(paramq);
    if (locale != null)
    {
      String str = g(locale);
      if (com.tencent.mm.vfs.e.cN(str))
      {
        a(str, paramImageView);
        l(paramq.field_msgId, 1);
        AppMethodBeat.o(14135);
        return;
      }
      a(locale, paramq, paramInt1, paramImageView);
      AppMethodBeat.o(14135);
      return;
    }
    ab.w("MicroMsg.BizTimeLineImgMsgHandler", "showImg img info is null. %d/%d", new Object[] { Long.valueOf(paramq.field_msgId), Long.valueOf(paramq.field_msgSvrId) });
    AppMethodBeat.o(14135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.b
 * JD-Core Version:    0.7.0.1
 */