package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.b.a;
import com.tencent.mm.ac.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderAssertCat;", "Lcom/tencent/mm/kt/IAssert;", "()V", "assertEquals", "", "key", "", "expected", "", "actual", "isReport", "", "isThrow", "message", "Lkotlin/Function0;", "assertFalse", "condition", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "assertTrue", "plugin-finder_release"})
public final class c
  implements f
{
  public static final c vVc;
  
  static
  {
    AppMethodBeat.i(253356);
    vVc = new c();
    AppMethodBeat.o(253356);
  }
  
  private c()
  {
    AppMethodBeat.i(253355);
    b.a locala = (b.a)new b.a()
    {
      public final int getId(String paramAnonymousString)
      {
        AppMethodBeat.i(253354);
        p.h(paramAnonymousString, "key");
        switch (paramAnonymousString.hashCode())
        {
        }
        while (BuildInfo.DEBUG)
        {
          paramAnonymousString = (Throwable)new RuntimeException("this key[" + paramAnonymousString + "] never define.");
          AppMethodBeat.o(253354);
          throw paramAnonymousString;
          if (paramAnonymousString.equals("layoutIdError"))
          {
            AppMethodBeat.o(253354);
            return 3;
            if (paramAnonymousString.equals("liveInitContentViewError"))
            {
              AppMethodBeat.o(253354);
              return 13;
              if (paramAnonymousString.equals("opt_moov_fail"))
              {
                AppMethodBeat.o(253354);
                return 1;
                if (paramAnonymousString.equals("liveInvalidBadgeTag"))
                {
                  AppMethodBeat.o(253354);
                  return 9;
                  if (paramAnonymousString.equals("finderStreamReturnInvalidFeed"))
                  {
                    AppMethodBeat.o(253354);
                    return 15;
                    if (paramAnonymousString.equals("cgiReportNormal"))
                    {
                      AppMethodBeat.o(253354);
                      return 12;
                      if (paramAnonymousString.equals("NetSceneFinderFollow_fromCommentScene_0"))
                      {
                        AppMethodBeat.o(253354);
                        return 2;
                        if (paramAnonymousString.equals("liveVisitorUIParamsInvalid"))
                        {
                          AppMethodBeat.o(253354);
                          return 6;
                          if (paramAnonymousString.equals("cgiReportError"))
                          {
                            AppMethodBeat.o(253354);
                            return 11;
                            if (paramAnonymousString.equals("liveInvalidBadgeInfoColor"))
                            {
                              AppMethodBeat.o(253354);
                              return 8;
                              if (paramAnonymousString.equals("liveCheckCommentMsgErr"))
                              {
                                AppMethodBeat.o(253354);
                                return 10;
                                if (paramAnonymousString.equals("liveHeartBeatLocalErr"))
                                {
                                  AppMethodBeat.o(253354);
                                  return 5;
                                  if (paramAnonymousString.equals("liveHeartBeatSvrErr"))
                                  {
                                    AppMethodBeat.o(253354);
                                    return 4;
                                    if (paramAnonymousString.equals("iconPreferenceError"))
                                    {
                                      AppMethodBeat.o(253354);
                                      return 15;
                                      if (paramAnonymousString.equals("optimizeMP4VFS_fail"))
                                      {
                                        AppMethodBeat.o(253354);
                                        return 7;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        AppMethodBeat.o(253354);
        return 0;
      }
    };
    this.vVd = new b(new Long[] { Long.valueOf(1535L), Long.valueOf(1536L) }, "FinderAssertCat", locala);
    AppMethodBeat.o(253355);
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, a<String> parama)
  {
    AppMethodBeat.i(253358);
    p.h(paramString, "key");
    p.h(parama, "message");
    this.vVd.a(paramString, paramBoolean1, paramBoolean2, paramBoolean3, parama);
    AppMethodBeat.o(253358);
  }
  
  public final void b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, a<String> parama)
  {
    AppMethodBeat.i(253357);
    p.h(paramString, "key");
    p.h(parama, "message");
    this.vVd.b(paramString, paramBoolean1, paramBoolean2, paramBoolean3, parama);
    AppMethodBeat.o(253357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.c
 * JD-Core Version:    0.7.0.1
 */