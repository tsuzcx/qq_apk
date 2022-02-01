package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker;", "", "()V", "TAG", "", "configs", "", "Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "getConfigs", "()Ljava/util/List;", "uploadBigFileConfig", "getUploadBigFileConfig", "()Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "checkAll", "", "clean", "config", "mark", "CheckerConfig", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k Ggi;
  private static final a Ggj;
  private static final List<a> Ggk;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333675);
    Ggi = new k();
    TAG = "Finder.FinderCrashChecker";
    a locala = new a("Finder_UploadBigFileConfig");
    Ggj = locala;
    Ggk = p.listOf(locala);
    AppMethodBeat.o(333675);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(333662);
    s.u(parama, "config");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
    s.s(localMultiProcessMMKV, "mmkv");
    s.u(localMultiProcessMMKV, "mmkv");
    localMultiProcessMMKV.putLong(parama.Ggl, System.currentTimeMillis());
    localMultiProcessMMKV.commit();
    Log.i(TAG, s.X("mark ", parama.Ggl));
    AppMethodBeat.o(333662);
  }
  
  public static a feM()
  {
    return Ggj;
  }
  
  public static void feN()
  {
    AppMethodBeat.i(333670);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
    Iterator localIterator = ((Iterable)Ggk).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      s.s(localMultiProcessMMKV, "mmkv");
      s.u(localMultiProcessMMKV, "mmkv");
      if (localMultiProcessMMKV.getLong(locala.Ggl, 0L) != 0L)
      {
        s.u(localMultiProcessMMKV, "mmkv");
        localMultiProcessMMKV.putLong(locala.Ggl, 0L);
        localMultiProcessMMKV.commit();
        Log.i(TAG, s.X("clean ", locala.Ggl));
        h.OAn.p(locala.id, locala.key, 1L);
        Log.i(TAG, "check " + locala.Ggl + ", hit!");
      }
    }
    AppMethodBeat.o(333670);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderCrashChecker$CheckerConfig;", "", "id", "", "key", "mmkvKey", "", "(JJLjava/lang/String;)V", "getId", "()J", "getKey", "getMmkvKey", "()Ljava/lang/String;", "check", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "clean", "mark", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final String Ggl;
    final long id;
    final long key;
    
    public a(String paramString)
    {
      AppMethodBeat.i(333867);
      this.id = 1253L;
      this.key = 37L;
      this.Ggl = paramString;
      AppMethodBeat.o(333867);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.k
 * JD-Core Version:    0.7.0.1
 */