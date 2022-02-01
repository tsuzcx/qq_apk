package com.tencent.mm.plugin.finder.loader;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "rawUrl", "", "urlFormat", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "mediumSizeUrl", "getMediumSizeUrl", "mediumSizeUrl$delegate", "Lkotlin/Lazy;", "originSizeUrl", "getOriginSizeUrl", "originSizeUrl$delegate", "getRawUrl", "rawUrlUniqueValue", "getRawUrlUniqueValue", "rawUrlUniqueValue$delegate", "smallSizeUrl", "getSmallSizeUrl", "smallSizeUrl$delegate", "uniqueValue", "url", "checkNeedReplaceSuffix", "", "checkUrl", "targetFormat", "getDecodeKey", "getMediaType", "getPath", "getRawUrlPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "isLegal", "needCheckOriginUrlCache", "Companion", "plugin-finder_release"})
public final class e
  implements w
{
  public static final a zti;
  final String fXu;
  private final String md5;
  private final String url;
  private final f ztc;
  private final f ztd;
  private final f zte;
  public final String ztf;
  private final f ztg;
  private final u zth;
  
  static
  {
    AppMethodBeat.i(279717);
    zti = new a((byte)0);
    AppMethodBeat.o(279717);
  }
  
  public e(String paramString, u paramu)
  {
    AppMethodBeat.i(279716);
    this.fXu = paramString;
    this.zth = paramu;
    this.ztc = g.ar((a)b.ztj);
    this.ztd = g.ar((a)e.ztm);
    this.zte = g.ar((a)c.ztk);
    String str = this.fXu;
    int i;
    label184:
    int j;
    if (str != null)
    {
      paramString = this.zth;
      if (n.pu(str, "/0")) {
        if (paramString == u.AlO)
        {
          paramString = dIW();
          p.j(paramString, "originSizeUrl");
          if (n.pu("/0", paramString)) {
            break label184;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        paramu = str;
        if (i == 0) {
          break;
        }
        paramString = this.zth;
        switch (f.$EnumSwitchMapping$0[paramString.ordinal()])
        {
        default: 
          paramString = (Throwable)new RuntimeException("Wrong url format");
          AppMethodBeat.o(279716);
          throw paramString;
        }
      }
      paramString = dIW();
      for (;;)
      {
        paramu = str;
        if (Util.isNullOrNil(paramString)) {
          break label300;
        }
        i = str.length();
        j = str.length();
        p.j(paramString, "targetFormatSuffix");
        paramString = (CharSequence)paramString;
        if (str != null) {
          break;
        }
        paramString = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(279716);
        throw paramString;
        paramString = (String)this.ztc.getValue();
        continue;
        paramString = (String)this.ztd.getValue();
      }
    }
    for (paramu = n.a((CharSequence)str, i - 1, j, paramString).toString();; paramu = null)
    {
      label300:
      this.url = paramu;
      paramu = this.url;
      paramString = paramu;
      if (paramu == null) {
        paramString = "";
      }
      this.md5 = MD5Util.getMD5String(paramString);
      this.ztf = ("finder_avatar_" + this.md5);
      this.ztg = g.ar((a)new d(this));
      AppMethodBeat.o(279716);
      return;
    }
  }
  
  private final String dIW()
  {
    AppMethodBeat.i(279711);
    String str = (String)this.zte.getValue();
    AppMethodBeat.o(279711);
    return str;
  }
  
  public final String aBv()
  {
    return this.ztf;
  }
  
  public final String aJi()
  {
    AppMethodBeat.i(279714);
    String str = Util.nullAsNil(this.url);
    p.j(str, "Util.nullAsNil(url)");
    AppMethodBeat.o(279714);
    return str;
  }
  
  public final u dIX()
  {
    return u.Alz;
  }
  
  public final String dIY()
  {
    return "";
  }
  
  public final String dIZ()
  {
    return "";
  }
  
  public final String dJa()
  {
    return "";
  }
  
  public final String dJb()
  {
    AppMethodBeat.i(279712);
    String str = (String)this.ztg.getValue();
    AppMethodBeat.o(279712);
    return str;
  }
  
  public final boolean dJc()
  {
    AppMethodBeat.i(279715);
    if (!TextUtils.equals((CharSequence)this.fXu, (CharSequence)this.url))
    {
      AppMethodBeat.o(279715);
      return true;
    }
    AppMethodBeat.o(279715);
    return false;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166298);
    Object localObject = av.AJz;
    localObject = av.a(this);
    AppMethodBeat.o(166298);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(279713);
    String str = Util.nullAsNil(this.url);
    p.j(str, "Util.nullAsNil(url)");
    AppMethodBeat.o(279713);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderAvatar$Companion;", "", "()V", "TAG", "", "URL_ORIGIN_SUFFIX", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<String>
  {
    public static final b ztj;
    
    static
    {
      AppMethodBeat.i(273083);
      ztj = new b();
      AppMethodBeat.o(273083);
    }
    
    b()
    {
      super();
    }
    
    private static String bLp()
    {
      AppMethodBeat.i(273082);
      try
      {
        Object localObject = d.AjH;
        localObject = new JSONObject(d.dSe()).optString("medium", "132");
        AppMethodBeat.o(273082);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("FinderAvatar", "mediumSizeUrl:", new Object[] { localThrowable });
          String str = "";
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements a<String>
  {
    public static final c ztk;
    
    static
    {
      AppMethodBeat.i(291233);
      ztk = new c();
      AppMethodBeat.o(291233);
    }
    
    c()
    {
      super();
    }
    
    private static String bLp()
    {
      AppMethodBeat.i(291232);
      try
      {
        Object localObject = d.AjH;
        localObject = new JSONObject(d.dSe()).optString("origin", "0");
        AppMethodBeat.o(291232);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("FinderAvatar", "originSizeUrl:", new Object[] { localThrowable });
          String str = "";
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<String>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements a<String>
  {
    public static final e ztm;
    
    static
    {
      AppMethodBeat.i(274957);
      ztm = new e();
      AppMethodBeat.o(274957);
    }
    
    e()
    {
      super();
    }
    
    private static String bLp()
    {
      AppMethodBeat.i(274956);
      try
      {
        Object localObject = d.AjH;
        localObject = new JSONObject(d.dSe()).optString("small", "64");
        AppMethodBeat.o(274956);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("FinderAvatar", "smallSizeUrl:", new Object[] { localThrowable });
          String str = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.e
 * JD-Core Version:    0.7.0.1
 */