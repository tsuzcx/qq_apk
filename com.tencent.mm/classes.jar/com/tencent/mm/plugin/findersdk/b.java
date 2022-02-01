package com.tencent.mm.plugin.findersdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/FinderAssertCat;", "Lcom/tencent/mm/kt/IAssert;", "()V", "assertEquals", "", "key", "", "expected", "", "actual", "isReport", "", "isThrow", "message", "Lkotlin/Function0;", "assertFalse", "condition", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "assertTrue", "finder-sdk_release"})
public final class b
  implements f
{
  public static final b BuZ;
  
  static
  {
    AppMethodBeat.i(209077);
    BuZ = new b();
    AppMethodBeat.o(209077);
  }
  
  private b()
  {
    AppMethodBeat.i(209076);
    b.a locala = (b.a)new b.a()
    {
      public final int Na(String paramAnonymousString)
      {
        AppMethodBeat.i(208491);
        p.k(paramAnonymousString, "key");
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
                                    AppMethodBeat.o(208491);
                                    return 0;
                                  } while (!paramAnonymousString.equals("layoutIdError"));
                                  AppMethodBeat.o(208491);
                                  return 3;
                                } while (!paramAnonymousString.equals("liveInitContentViewError"));
                                AppMethodBeat.o(208491);
                                return 13;
                              } while (!paramAnonymousString.equals("opt_moov_fail"));
                              AppMethodBeat.o(208491);
                              return 1;
                            } while (!paramAnonymousString.equals("liveInvalidBadgeTag"));
                            AppMethodBeat.o(208491);
                            return 9;
                          } while (!paramAnonymousString.equals("finderStreamReturnInvalidFeed"));
                          AppMethodBeat.o(208491);
                          return 15;
                        } while (!paramAnonymousString.equals("cgiReportNormal"));
                        AppMethodBeat.o(208491);
                        return 12;
                      } while (!paramAnonymousString.equals("NetSceneFinderFollow_fromCommentScene_0"));
                      AppMethodBeat.o(208491);
                      return 2;
                    } while (!paramAnonymousString.equals("liveVisitorUIParamsInvalid"));
                    AppMethodBeat.o(208491);
                    return 6;
                  } while (!paramAnonymousString.equals("cgiReportError"));
                  AppMethodBeat.o(208491);
                  return 11;
                } while (!paramAnonymousString.equals("liveInvalidBadgeInfoColor"));
                AppMethodBeat.o(208491);
                return 8;
              } while (!paramAnonymousString.equals("liveCheckCommentMsgErr"));
              AppMethodBeat.o(208491);
              return 10;
            } while (!paramAnonymousString.equals("liveHeartBeatLocalErr"));
            AppMethodBeat.o(208491);
            return 5;
          } while (!paramAnonymousString.equals("liveHeartBeatSvrErr"));
          AppMethodBeat.o(208491);
          return 4;
        } while (!paramAnonymousString.equals("optimizeMP4VFS_fail"));
        AppMethodBeat.o(208491);
        return 7;
      }
    };
    this.Bva = new com.tencent.mm.ae.b(new Long[] { Long.valueOf(1535L), Long.valueOf(1536L) }, "FinderAssertCat", locala);
    AppMethodBeat.o(209076);
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, a<String> parama)
  {
    AppMethodBeat.i(209081);
    p.k(paramString, "key");
    p.k(parama, "message");
    this.Bva.a(paramString, paramBoolean1, paramBoolean2, paramBoolean3, parama);
    AppMethodBeat.o(209081);
  }
  
  public final void b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, a<String> parama)
  {
    AppMethodBeat.i(209078);
    p.k(paramString, "key");
    p.k(parama, "message");
    this.Bva.b(paramString, paramBoolean1, paramBoolean2, paramBoolean3, parama);
    AppMethodBeat.o(209078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b
 * JD-Core Version:    0.7.0.1
 */