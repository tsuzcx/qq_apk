package com.tencent.mm.openim.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.storage.au;
import com.tencent.threadpool.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/report/OpenImKefuReporter;", "", "()V", "TAG", "", "getShareScene", "", "username", "reportAction", "", "contact", "Lcom/tencent/mm/openim/contact/OpenIMKefuContact;", "action", "scene", "timestamp", "", "reportEnterKefuFolder", "reportShareCardSuccess", "toUser", "Action", "ShareScene", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ptO;
  
  static
  {
    AppMethodBeat.i(235759);
    ptO = new a();
    AppMethodBeat.o(235759);
  }
  
  public static final void B(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235742);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(235742);
      return;
    }
    long l = System.currentTimeMillis();
    com.tencent.threadpool.h.ahAA.bo(new a..ExternalSyntheticLambda1(paramString, paramInt1, paramInt2, l));
    AppMethodBeat.o(235742);
  }
  
  private static void a(com.tencent.mm.openim.a.c paramc, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(235744);
    if (paramc == null)
    {
      AppMethodBeat.o(235744);
      return;
    }
    if (paramLong != 0L) {}
    for (;;)
    {
      com.tencent.threadpool.h.ahAA.bo(new a..ExternalSyntheticLambda0(paramc, paramInt1, paramInt2, paramLong));
      AppMethodBeat.o(235744);
      return;
      paramLong = System.currentTimeMillis();
    }
  }
  
  private static final void a(String paramString, com.tencent.mm.openim.a.c paramc, long paramLong)
  {
    AppMethodBeat.i(235756);
    String str;
    int i;
    if (paramString == null)
    {
      str = "";
      if (((CharSequence)str).length() != 0) {
        break label157;
      }
      i = 1;
      label29:
      if (i == 0) {
        break label163;
      }
      i = 0;
    }
    for (;;)
    {
      str = ((e)com.tencent.mm.kernel.h.ax(e.class)).cc(paramc.field_openImAppId, paramc.field_openImDescWordingId);
      com.tencent.mm.plugin.report.service.h.OAn.b(23393, new Object[] { paramc.field_username, paramc.field_nickname, paramc.field_openImAppId, str, Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(i), paramString, paramc.field_finderUsername, Long.valueOf(paramLong) });
      AppMethodBeat.o(235756);
      return;
      str = paramString;
      break;
      label157:
      i = 0;
      break label29;
      label163:
      if (au.bwO(str)) {
        i = 3;
      } else if (au.bwQ(str)) {
        i = 6;
      } else if (ab.II(str)) {
        i = 4;
      } else if (au.bwF(str)) {
        i = 5;
      } else if (au.bwE(str)) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  private static final void b(com.tencent.mm.openim.a.c paramc, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(235753);
    String str = ((e)com.tencent.mm.kernel.h.ax(e.class)).cc(paramc.field_openImAppId, paramc.field_openImDescWordingId);
    com.tencent.mm.plugin.report.service.h.OAn.b(23393, new Object[] { paramc.field_username, paramc.field_nickname, paramc.field_openImAppId, str, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), "", paramc.field_finderUsername, Long.valueOf(paramLong) });
    AppMethodBeat.o(235753);
  }
  
  private static final void b(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(235752);
    paramString = ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).RC(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(235752);
      return;
    }
    a(paramString, paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(235752);
  }
  
  public static final void bm(String paramString, int paramInt)
  {
    AppMethodBeat.i(235740);
    B(paramString, paramInt, 0);
    AppMethodBeat.o(235740);
  }
  
  public static final void ce(String paramString1, String paramString2)
  {
    AppMethodBeat.i(235748);
    long l = System.currentTimeMillis();
    paramString1 = ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).RC(paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(235748);
      return;
    }
    com.tencent.threadpool.h.ahAA.bo(new a..ExternalSyntheticLambda2(paramString2, paramString1, l));
    AppMethodBeat.o(235748);
  }
  
  public static final void xI(int paramInt)
  {
    AppMethodBeat.i(235738);
    com.tencent.mm.plugin.report.service.h.OAn.b(23393, new Object[] { "", "", "", "", Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(235738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.d.a
 * JD-Core Version:    0.7.0.1
 */