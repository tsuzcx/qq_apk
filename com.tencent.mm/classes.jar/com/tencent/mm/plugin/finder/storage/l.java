package com.tencent.mm.plugin.finder.storage;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.i;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig;", "", "jsonStr", "", "(Ljava/lang/String;)V", "configList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig$Config;", "getConfigList", "()Ljava/util/List;", "Companion", "Config", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  private static boolean FKB;
  public static final a FKz;
  private static final String TAG;
  final List<l.b> FKA;
  
  static
  {
    AppMethodBeat.i(166965);
    FKz = new a((byte)0);
    TAG = "Finder.FinderFakeVideoConfig";
    AppMethodBeat.o(166965);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(166964);
    this.FKA = ((List)new ArrayList());
    try
    {
      paramString = new i(paramString).Fr("configs");
      if (paramString != null)
      {
        int k = paramString.length();
        if (k > 0)
        {
          int j;
          do
          {
            j = i + 1;
            Object localObject = paramString.su(i);
            if (localObject != null)
            {
              String str1 = ((i)localObject).optString("brands");
              String str2 = ((i)localObject).optString("models");
              i = ((i)localObject).optInt("maxSize", 0);
              if (i > 0)
              {
                localObject = this.FKA;
                s.s(str1, "brands");
                s.s(str2, "models");
                ((List)localObject).add(new l.b(str1, str2, i));
              }
            }
            i = j;
          } while (j < k);
        }
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(166964);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugEnable", "", "getDebugEnable", "()Z", "setDebugEnable", "(Z)V", "getConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig;", "hitConfig", "videoSize", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean Tq(int paramInt)
    {
      AppMethodBeat.i(166959);
      String str1 = Build.BRAND;
      s.s(str1, "BRAND");
      str1 = str1.toLowerCase();
      s.s(str1, "(this as java.lang.String).toLowerCase()");
      String str2 = q.aPo();
      s.s(str2, "getModel()");
      str2 = str2.toLowerCase();
      s.s(str2, "(this as java.lang.String).toLowerCase()");
      Object localObject1 = d.FAy;
      localObject1 = d.eRp();
      s.s(localObject1, "FinderConfig.FAKE_VIDEO_CONFIG_JSON");
      Object localObject2 = ((Iterable)new l((String)localObject1).FKA).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (l.b)((Iterator)localObject2).next();
        if (((n.a((CharSequence)((l.b)localObject1).FKC, (CharSequence)str1, false)) || (n.a((CharSequence)((l.b)localObject1).FKD, (CharSequence)str2, false)) || (Util.isNullOrNil(((l.b)localObject1).FKC))) && (paramInt > ((l.b)localObject1).maxSize) && (((l.b)localObject1).maxSize > 0))
        {
          localObject2 = l.FKz;
          Log.i(l.access$getTAG$cp(), "hitConfig brand:" + str1 + ", model:" + str2 + ", videoSize:" + paramInt + "; config brands:" + ((l.b)localObject1).FKC + ", models:" + ((l.b)localObject1).FKD + ", maxSize:" + ((l.b)localObject1).maxSize);
          AppMethodBeat.o(166959);
          return true;
        }
      }
      if (Log.getLogLevel() <= 1)
      {
        boolean bool = l.eZg();
        AppMethodBeat.o(166959);
        return bool;
      }
      AppMethodBeat.o(166959);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.l
 * JD-Core Version:    0.7.0.1
 */