package com.tencent.mm.plugin.finder.loader;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "rawUrl", "", "urlFormat", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "mediumSizeUrl", "getMediumSizeUrl", "mediumSizeUrl$delegate", "Lkotlin/Lazy;", "originSizeUrl", "getOriginSizeUrl", "originSizeUrl$delegate", "getRawUrl", "rawUrlUniqueValue", "getRawUrlUniqueValue", "rawUrlUniqueValue$delegate", "smallSizeUrl", "getSmallSizeUrl", "smallSizeUrl$delegate", "uniqueValue", "url", "checkNeedReplaceSuffix", "", "checkUrl", "targetFormat", "getDecodeKey", "getMediaType", "getPath", "getRawUrlPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "isLegal", "needCheckOriginUrlCache", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements r
{
  public static final b.a EwV;
  private final v EwW;
  private final j EwX;
  private final j EwY;
  private final j EwZ;
  public final String Exa;
  private final j Exb;
  final String idu;
  private final String md5;
  private final String url;
  
  static
  {
    AppMethodBeat.i(331850);
    EwV = new b.a((byte)0);
    AppMethodBeat.o(331850);
  }
  
  public b(String paramString, v paramv)
  {
    AppMethodBeat.i(331827);
    this.idu = paramString;
    this.EwW = paramv;
    this.EwX = k.cm((a)c.Exc);
    this.EwY = k.cm((a)f.Exf);
    this.EwZ = k.cm((a)d.Exd);
    String str = this.idu;
    if (str == null)
    {
      paramv = null;
      this.url = paramv;
      paramv = this.url;
      paramString = paramv;
      if (paramv == null) {
        paramString = "";
      }
      this.md5 = MD5Util.getMD5String(paramString);
      this.Exa = s.X("finder_avatar_", this.md5);
      this.Exb = k.cm((a)new e(this));
      AppMethodBeat.o(331827);
      return;
    }
    paramString = this.EwW;
    if (n.rs(str, "/0")) {
      if (paramString == v.FLE)
      {
        paramString = eCc();
        s.s(paramString, "originSizeUrl");
        if (n.rs("/0", paramString)) {
          break label249;
        }
      }
    }
    label249:
    for (int i = 1;; i = 0)
    {
      paramv = str;
      if (i == 0) {
        break;
      }
      paramString = this.EwW;
      switch (b.b.$EnumSwitchMapping$0[paramString.ordinal()])
      {
      default: 
        paramString = new RuntimeException("Wrong url format");
        AppMethodBeat.o(331827);
        throw paramString;
      }
    }
    paramString = eCc();
    for (;;)
    {
      paramv = str;
      if (!Util.isNullOrNil(paramString))
      {
        i = str.length();
        int j = str.length();
        s.s(paramString, "targetFormatSuffix");
        paramString = (CharSequence)paramString;
        paramv = n.a((CharSequence)str, i - 1, j, paramString).toString();
      }
      break;
      paramString = (String)this.EwX.getValue();
      continue;
      paramString = (String)this.EwY.getValue();
    }
  }
  
  private final String eCc()
  {
    AppMethodBeat.i(331842);
    String str = (String)this.EwZ.getValue();
    AppMethodBeat.o(331842);
    return str;
  }
  
  public final String aUt()
  {
    return this.Exa;
  }
  
  public final v eCd()
  {
    return v.FKZ;
  }
  
  public final String eCe()
  {
    return "";
  }
  
  public final String eCf()
  {
    return "";
  }
  
  public final String eCg()
  {
    return "";
  }
  
  public final String eCh()
  {
    AppMethodBeat.i(331903);
    String str = (String)this.Exb.getValue();
    AppMethodBeat.o(331903);
    return str;
  }
  
  public final String eCi()
  {
    AppMethodBeat.i(331946);
    String str = Util.nullAsNil(this.url);
    s.s(str, "nullAsNil(url)");
    AppMethodBeat.o(331946);
    return str;
  }
  
  public final boolean eCj()
  {
    AppMethodBeat.i(331959);
    if (!TextUtils.equals((CharSequence)this.idu, (CharSequence)this.url))
    {
      AppMethodBeat.o(331959);
      return true;
    }
    AppMethodBeat.o(331959);
    return false;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166298);
    Object localObject = bm.GlZ;
    localObject = bm.a(this);
    AppMethodBeat.o(166298);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(331937);
    String str = Util.nullAsNil(this.url);
    s.s(str, "nullAsNil(url)");
    AppMethodBeat.o(331937);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<String>
  {
    public static final c Exc;
    
    static
    {
      AppMethodBeat.i(331706);
      Exc = new c();
      AppMethodBeat.o(331706);
    }
    
    c()
    {
      super();
    }
    
    private static String emu()
    {
      AppMethodBeat.i(331698);
      try
      {
        Object localObject1 = d.FAy;
        localObject1 = new JSONObject(d.eQr()).optString("medium", "132");
        AppMethodBeat.o(331698);
        return localObject1;
      }
      finally
      {
        for (;;)
        {
          Log.e("FinderAvatar", "mediumSizeUrl:", new Object[] { localObject2 });
          String str = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<String>
  {
    public static final d Exd;
    
    static
    {
      AppMethodBeat.i(331700);
      Exd = new d();
      AppMethodBeat.o(331700);
    }
    
    d()
    {
      super();
    }
    
    private static String emu()
    {
      AppMethodBeat.i(331693);
      try
      {
        Object localObject1 = d.FAy;
        localObject1 = new JSONObject(d.eQr()).optString("origin", "0");
        AppMethodBeat.o(331693);
        return localObject1;
      }
      finally
      {
        for (;;)
        {
          Log.e("FinderAvatar", "originSizeUrl:", new Object[] { localObject2 });
          String str = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<String>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<String>
  {
    public static final f Exf;
    
    static
    {
      AppMethodBeat.i(331692);
      Exf = new f();
      AppMethodBeat.o(331692);
    }
    
    f()
    {
      super();
    }
    
    private static String emu()
    {
      AppMethodBeat.i(331686);
      try
      {
        Object localObject1 = d.FAy;
        localObject1 = new JSONObject(d.eQr()).optString("small", "64");
        AppMethodBeat.o(331686);
        return localObject1;
      }
      finally
      {
        for (;;)
        {
          Log.e("FinderAvatar", "smallSizeUrl:", new Object[] { localObject2 });
          String str = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.b
 * JD-Core Version:    0.7.0.1
 */