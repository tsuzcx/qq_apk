package com.tencent.mm.plugin.findersdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.b;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/FinderAssertCat;", "Lcom/tencent/mm/kt/IAssert;", "()V", "assertEquals", "", "key", "", "expected", "", "actual", "level", "Lcom/tencent/mm/kt/IAssert$LEVEL;", "isReport", "", "isThrow", "message", "Lkotlin/Function0;", "assertFalse", "condition", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "assertTrue", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements e
{
  public static final b HbT;
  
  static
  {
    AppMethodBeat.i(273734);
    HbT = new b();
    AppMethodBeat.o(273734);
  }
  
  private b()
  {
    AppMethodBeat.i(273730);
    b.a locala = (b.a)new b.a()
    {
      public final int FJ(String paramAnonymousString)
      {
        AppMethodBeat.i(273690);
        s.u(paramAnonymousString, "key");
        switch (paramAnonymousString.hashCode())
        {
        }
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      AppMethodBeat.o(273690);
                                      return 0;
                                    } while (!paramAnonymousString.equals("layoutIdError"));
                                    AppMethodBeat.o(273690);
                                    return 3;
                                  } while (!paramAnonymousString.equals("liveInitContentViewError"));
                                  AppMethodBeat.o(273690);
                                  return 13;
                                } while (!paramAnonymousString.equals("opt_moov_fail"));
                                AppMethodBeat.o(273690);
                                return 1;
                              } while (!paramAnonymousString.equals("liveInvalidBadgeTag"));
                              AppMethodBeat.o(273690);
                              return 9;
                            } while (!paramAnonymousString.equals("finderStreamReturnInvalidFeed"));
                            AppMethodBeat.o(273690);
                            return 15;
                          } while (!paramAnonymousString.equals("finderolympicsdatanull"));
                          AppMethodBeat.o(273690);
                          return 16;
                        } while (!paramAnonymousString.equals("cgiReportNormal"));
                        AppMethodBeat.o(273690);
                        return 12;
                      } while (!paramAnonymousString.equals("NetSceneFinderFollow_fromCommentScene_0"));
                      AppMethodBeat.o(273690);
                      return 2;
                    } while (!paramAnonymousString.equals("liveVisitorUIParamsInvalid"));
                    AppMethodBeat.o(273690);
                    return 6;
                  } while (!paramAnonymousString.equals("cgiReportError"));
                  AppMethodBeat.o(273690);
                  return 11;
                } while (!paramAnonymousString.equals("liveInvalidBadgeInfoColor"));
                AppMethodBeat.o(273690);
                return 8;
              } while (!paramAnonymousString.equals("liveCheckCommentMsgErr"));
              AppMethodBeat.o(273690);
              return 10;
            } while (!paramAnonymousString.equals("liveHeartBeatLocalErr"));
            AppMethodBeat.o(273690);
            return 5;
          } while (!paramAnonymousString.equals("liveHeartBeatSvrErr"));
          AppMethodBeat.o(273690);
          return 4;
        } while (!paramAnonymousString.equals("optimizeMP4VFS_fail"));
        AppMethodBeat.o(273690);
        return 7;
      }
      
      public final int getVersion()
      {
        return 4;
      }
    };
    this.HbU = new com.tencent.mm.ae.b(new Long[] { Long.valueOf(1535L), Long.valueOf(1536L) }, "FinderAssertCat", locala);
    AppMethodBeat.o(273730);
  }
  
  public final void a(String paramString, Object paramObject, e.b paramb, boolean paramBoolean1, boolean paramBoolean2, a<String> parama)
  {
    AppMethodBeat.i(369753);
    s.u(paramString, "key");
    s.u(paramb, "level");
    s.u(parama, "message");
    this.HbU.a(paramString, paramObject, paramb, paramBoolean1, paramBoolean2, parama);
    AppMethodBeat.o(369753);
  }
  
  public final void a(String paramString, boolean paramBoolean1, e.b paramb, boolean paramBoolean2, boolean paramBoolean3, a<String> parama)
  {
    AppMethodBeat.i(273753);
    s.u(paramString, "key");
    s.u(paramb, "level");
    s.u(parama, "message");
    this.HbU.a(paramString, paramBoolean1, paramb, paramBoolean2, paramBoolean3, parama);
    AppMethodBeat.o(273753);
  }
  
  public final void b(String paramString, boolean paramBoolean1, e.b paramb, boolean paramBoolean2, boolean paramBoolean3, a<String> parama)
  {
    AppMethodBeat.i(273744);
    s.u(paramString, "key");
    s.u(paramb, "level");
    s.u(parama, "message");
    this.HbU.b(paramString, paramBoolean1, paramb, paramBoolean2, paramBoolean3, parama);
    AppMethodBeat.o(273744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b
 * JD-Core Version:    0.7.0.1
 */