package com.tencent.mm.plugin.appbrand.shortlink;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher;", "", "()V", "getBusinessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "getShortLinkCgiCache", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "innerLaunch", "", "ctx", "Landroid/app/Activity;", "params", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "resultCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "Lkotlin/ParameterName;", "name", "errorCode", "launch", "Landroid/content/Context;", "launchResultCallback", "", "success", "launchWithLink", "link", "", "showLaunchWxaTipDialog", "onDecodeLinkFailed", "url", "onLaunchDone", "onLinkDecodeDone", "onLinkIllegal", "onUserCancel", "Companion", "WxaShortLinkLaunchParams", "luggage-wechat-full-sdk_release"})
public abstract class AbsWxaShortLinkLauncher
{
  public static final a nNA = new a((byte)0);
  private static final Pattern nNz;
  
  static
  {
    Pattern localPattern = Pattern.compile("^mp://\\w+");
    p.g(localPattern, "Pattern.compile(\"^$SHORT_LINK_SCHEME\\\\w+\")");
    nNz = localPattern;
  }
  
  protected static void d(Activity paramActivity, String paramString)
  {
    p.h(paramActivity, "ctx");
    p.h(paramString, "url");
  }
  
  protected static void e(Activity paramActivity, String paramString)
  {
    p.h(paramActivity, "ctx");
    p.h(paramString, "url");
  }
  
  protected static void f(Activity paramActivity, String paramString)
  {
    p.h(paramActivity, "ctx");
    p.h(paramString, "url");
  }
  
  public final void a(final Activity paramActivity, final String paramString, final b<? super WxaShortLinkLaunchErrorCode, x> paramb)
  {
    p.h(paramActivity, "ctx");
    p.h(paramString, "link");
    m localm = (m)new c(this, paramActivity, paramb, paramString);
    Object localObject = bVy();
    if (localObject != null) {}
    for (localObject = ((a)localObject).aeX(paramString); localObject != null; localObject = null)
    {
      Log.i("MicroMsg.AbsWxaShortLinkLauncher", "use cache for link:".concat(String.valueOf(paramString)));
      localm.invoke(Boolean.TRUE, localObject);
      return;
    }
    if (nNz.matcher((CharSequence)paramString).matches())
    {
      new com.tencent.mm.plugin.appbrand.shortlink.cgi.a();
      com.tencent.mm.plugin.appbrand.shortlink.cgi.a.a(paramString, bVx(), localm);
      return;
    }
    p.h(paramActivity, "ctx");
    p.h(paramString, "url");
    paramb.invoke(WxaShortLinkLaunchErrorCode.ILLEGAL_LINK);
  }
  
  protected abstract void a(Context paramContext, WxaShortLinkLaunchParams paramWxaShortLinkLaunchParams, b<? super Boolean, x> paramb);
  
  protected boolean a(Activity paramActivity, boolean paramBoolean)
  {
    p.h(paramActivity, "ctx");
    return true;
  }
  
  protected abstract a.b bVx();
  
  protected a bVy()
  {
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "Landroid/os/Parcelable;", "appId", "", "path", "version", "", "versionType", "shortLink", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getPath", "getShortLink", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"})
  public static final class WxaShortLinkLaunchParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    public final String appId;
    public final int iOo;
    public final String kHQ;
    public final String path;
    public final int version;
    
    static
    {
      AppMethodBeat.i(230166);
      CREATOR = new a();
      AppMethodBeat.o(230166);
    }
    
    public WxaShortLinkLaunchParams(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
    {
      AppMethodBeat.i(230161);
      this.appId = paramString1;
      this.path = paramString2;
      this.version = paramInt1;
      this.iOo = paramInt2;
      this.kHQ = paramString3;
      AppMethodBeat.o(230161);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(230164);
      if (this != paramObject)
      {
        if ((paramObject instanceof WxaShortLinkLaunchParams))
        {
          paramObject = (WxaShortLinkLaunchParams)paramObject;
          if ((!p.j(this.appId, paramObject.appId)) || (!p.j(this.path, paramObject.path)) || (this.version != paramObject.version) || (this.iOo != paramObject.iOo) || (!p.j(this.kHQ, paramObject.kHQ))) {}
        }
      }
      else
      {
        AppMethodBeat.o(230164);
        return true;
      }
      AppMethodBeat.o(230164);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(230163);
      String str = this.appId;
      int i;
      if (str != null)
      {
        i = str.hashCode();
        str = this.path;
        if (str == null) {
          break label104;
        }
      }
      label104:
      for (int j = str.hashCode();; j = 0)
      {
        int m = this.version;
        int n = this.iOo;
        str = this.kHQ;
        if (str != null) {
          k = str.hashCode();
        }
        AppMethodBeat.o(230163);
        return (((j + i * 31) * 31 + m) * 31 + n) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(230162);
      String str = "WxaShortLinkLaunchParams(appId=" + this.appId + ", path=" + this.path + ", version=" + this.version + ", versionType=" + this.iOo + ", shortLink=" + this.kHQ + ")";
      AppMethodBeat.o(230162);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(230165);
      p.h(paramParcel, "parcel");
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.path);
      paramParcel.writeInt(this.version);
      paramParcel.writeInt(this.iOo);
      paramParcel.writeString(this.kHQ);
      AppMethodBeat.o(230165);
    }
    
    @l(hxD={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(230160);
        p.h(paramParcel, "in");
        paramParcel = new AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams(paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString());
        AppMethodBeat.o(230160);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams[paramInt];
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$Companion;", "", "()V", "SHORT_LINK_SCHEME_PATTERN", "Ljava/util/regex/Pattern;", "getSHORT_LINK_SCHEME_PATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "invoke"})
  static final class b
    extends q
    implements b<Boolean, x>
  {
    b(AbsWxaShortLinkLauncher paramAbsWxaShortLinkLauncher, Activity paramActivity, AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams paramWxaShortLinkLaunchParams, b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "cgiSuccess", "", "info", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "invoke"})
  static final class c
    extends q
    implements m<Boolean, WxaShortLinkInfo, x>
  {
    c(AbsWxaShortLinkLauncher paramAbsWxaShortLinkLauncher, Activity paramActivity, b paramb, String paramString)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(AbsWxaShortLinkLauncher.c paramc, Activity paramActivity, WxaShortLinkInfo paramWxaShortLinkInfo)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher
 * JD-Core Version:    0.7.0.1
 */