package com.tencent.mm.plugin.finder.storage;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig;", "", "jsonStr", "", "(Ljava/lang/String;)V", "configList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig$Config;", "getConfigList", "()Ljava/util/List;", "Companion", "Config", "plugin-finder_release"})
public final class j
{
  private static final String TAG = "Finder.FinderFakeVideoConfig";
  private static boolean vDC;
  public static final a vDD;
  final List<b> vDB;
  
  static
  {
    AppMethodBeat.i(166965);
    vDD = new a((byte)0);
    TAG = "Finder.FinderFakeVideoConfig";
    AppMethodBeat.o(166965);
  }
  
  public j(String paramString)
  {
    AppMethodBeat.i(166964);
    this.vDB = ((List)new ArrayList());
    for (;;)
    {
      int i;
      try
      {
        paramString = new i(paramString).FI("configs");
        if (paramString != null)
        {
          int j = paramString.length();
          i = 0;
          if (i < j)
          {
            Object localObject = paramString.pZ(i);
            String str1 = ((i)localObject).optString("brands");
            String str2 = ((i)localObject).optString("models");
            int k = ((i)localObject).optInt("maxSize", 0);
            if (k > 0)
            {
              localObject = this.vDB;
              p.g(str1, "brands");
              p.g(str2, "models");
              ((List)localObject).add(new b(str1, str2, k));
            }
          }
          else
          {
            AppMethodBeat.o(166964);
          }
        }
        else
        {
          AppMethodBeat.o(166964);
          return;
        }
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(166964);
        return;
      }
      i += 1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugEnable", "", "getDebugEnable", "()Z", "setDebugEnable", "(Z)V", "getConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig;", "hitConfig", "videoSize", "", "plugin-finder_release"})
  public static final class a
  {
    public static boolean KY(int paramInt)
    {
      AppMethodBeat.i(166959);
      Object localObject1 = Build.BRAND;
      p.g(localObject1, "Build.BRAND");
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(166959);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((String)localObject1).toLowerCase();
      p.g(localObject1, "(this as java.lang.String).toLowerCase()");
      String str = Build.MODEL;
      p.g(str, "Build.MODEL");
      if (str == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(166959);
        throw ((Throwable)localObject1);
      }
      str = str.toLowerCase();
      p.g(str, "(this as java.lang.String).toLowerCase()");
      Object localObject2 = c.vCb;
      localObject2 = c.drK();
      p.g(localObject2, "FinderConfig.FAKE_VIDEO_CONFIG_JSON");
      Object localObject3 = ((Iterable)new j((String)localObject2).vDB).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (j.b)((Iterator)localObject3).next();
        if (((n.a((CharSequence)((j.b)localObject2).vDE, (CharSequence)localObject1, false)) || (n.a((CharSequence)((j.b)localObject2).vDF, (CharSequence)str, false)) || (Util.isNullOrNil(((j.b)localObject2).vDE))) && (paramInt > ((j.b)localObject2).maxSize) && (((j.b)localObject2).maxSize > 0))
        {
          localObject3 = j.vDD;
          Log.i(j.access$getTAG$cp(), "hitConfig brand:" + (String)localObject1 + ", model:" + str + ", videoSize:" + paramInt + "; config brands:" + ((j.b)localObject2).vDE + ", models:" + ((j.b)localObject2).vDF + ", maxSize:" + ((j.b)localObject2).maxSize);
          AppMethodBeat.o(166959);
          return true;
        }
      }
      if (Log.getLogLevel() <= 1)
      {
        boolean bool = j.dxA();
        AppMethodBeat.o(166959);
        return bool;
      }
      AppMethodBeat.o(166959);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderFakeVideoConfig$Config;", "", "brands", "", "models", "maxSize", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBrands", "()Ljava/lang/String;", "getMaxSize", "()I", "getModels", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    final int maxSize;
    final String vDE;
    final String vDF;
    
    public b(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(166960);
      this.vDE = paramString1;
      this.vDF = paramString2;
      this.maxSize = paramInt;
      AppMethodBeat.o(166960);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(166963);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.vDE, paramObject.vDE)) || (!p.j(this.vDF, paramObject.vDF)) || (this.maxSize != paramObject.maxSize)) {}
        }
      }
      else
      {
        AppMethodBeat.o(166963);
        return true;
      }
      AppMethodBeat.o(166963);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(166962);
      String str = this.vDE;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.vDF;
        if (str != null) {
          j = str.hashCode();
        }
        int k = this.maxSize;
        AppMethodBeat.o(166962);
        return (i * 31 + j) * 31 + k;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166961);
      String str = "Config(brands=" + this.vDE + ", models=" + this.vDF + ", maxSize=" + this.maxSize + ")";
      AppMethodBeat.o(166961);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.j
 * JD-Core Version:    0.7.0.1
 */