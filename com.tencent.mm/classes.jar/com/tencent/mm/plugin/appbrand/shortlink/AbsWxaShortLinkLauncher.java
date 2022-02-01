package com.tencent.mm.plugin.appbrand.shortlink;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher;", "", "()V", "getBusinessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "getShortLinkCgiCache", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "innerLaunch", "", "ctx", "Landroid/app/Activity;", "params", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "resultCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "Lkotlin/ParameterName;", "name", "errorCode", "launch", "Landroid/content/Context;", "launchResultCallback", "", "success", "launchWithLink", "link", "", "showLaunchWxaTipDialog", "launchWithLinkNoCheck", "onDecodeLinkFailed", "url", "onLaunchDone", "onLinkDecodeDone", "onLinkIllegal", "onUserCancel", "Companion", "WxaShortLinkLaunchParams", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class AbsWxaShortLinkLauncher
{
  public static final AbsWxaShortLinkLauncher.a tUK = new AbsWxaShortLinkLauncher.a((byte)0);
  private static final Pattern tUL;
  
  static
  {
    Pattern localPattern = Pattern.compile("^mp://\\w+");
    s.s(localPattern, "compile(\"^$SHORT_LINK_SCHEME\\\\w+\")");
    tUL = localPattern;
  }
  
  protected static void f(Activity paramActivity, String paramString)
  {
    s.u(paramActivity, "ctx");
    s.u(paramString, "url");
  }
  
  protected abstract void a(Context paramContext, WxaShortLinkLaunchParams paramWxaShortLinkLaunchParams, b<? super Boolean, ah> paramb);
  
  protected boolean a(Activity paramActivity, boolean paramBoolean)
  {
    s.u(paramActivity, "ctx");
    return true;
  }
  
  public final void b(Activity paramActivity, final String paramString, final b<? super WxaShortLinkLaunchErrorCode, ah> paramb)
  {
    s.u(paramActivity, "ctx");
    s.u(paramString, "link");
    m localm = (m)new c(paramActivity, paramb, this, paramString);
    Object localObject = cJx();
    if (localObject == null) {}
    for (localObject = null; localObject != null; localObject = ((a)localObject).agb(paramString))
    {
      Log.i("MicroMsg.AbsWxaShortLinkLauncher", s.X("use cache for link:", paramString));
      localm.invoke(Boolean.TRUE, localObject);
      return;
    }
    if (tUL.matcher((CharSequence)paramString).matches())
    {
      new com.tencent.mm.plugin.appbrand.shortlink.cgi.a();
      com.tencent.mm.plugin.appbrand.shortlink.cgi.a.a(paramString, cJw(), localm);
      return;
    }
    s.u(paramActivity, "ctx");
    s.u(paramString, "url");
    paramb.invoke(WxaShortLinkLaunchErrorCode.ILLEGAL_LINK);
  }
  
  protected void b(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    s.u(paramActivity, "ctx");
    s.u(paramString, "url");
  }
  
  public final void c(Activity paramActivity, final String paramString, final b<? super WxaShortLinkLaunchErrorCode, ah> paramb)
  {
    s.u(paramActivity, "ctx");
    s.u(paramString, "link");
    paramb = (m)new d(paramActivity, paramb, this, paramString);
    paramActivity = cJx();
    if (paramActivity == null) {}
    for (paramActivity = null;; paramActivity = paramActivity.agb(paramString))
    {
      if (paramActivity != null)
      {
        Log.i("MicroMsg.AbsWxaShortLinkLauncher", s.X("use cache for link:", paramString));
        paramb.invoke(Boolean.TRUE, paramActivity);
      }
      return;
    }
  }
  
  protected abstract a.b cJw();
  
  protected a cJx()
  {
    return null;
  }
  
  protected void g(Activity paramActivity, String paramString)
  {
    s.u(paramActivity, "ctx");
    s.u(paramString, "url");
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "Landroid/os/Parcelable;", "appId", "", "path", "version", "", "versionType", "shortLink", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getPath", "getShortLink", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class WxaShortLinkLaunchParams
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaShortLinkLaunchParams> CREATOR;
    public final String appId;
    public final int euz;
    public final String path;
    public final String qAX;
    public final int version;
    
    static
    {
      AppMethodBeat.i(321816);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(321816);
    }
    
    public WxaShortLinkLaunchParams(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
    {
      AppMethodBeat.i(321811);
      this.appId = paramString1;
      this.path = paramString2;
      this.version = paramInt1;
      this.euz = paramInt2;
      this.qAX = paramString3;
      AppMethodBeat.o(321811);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(321839);
      if (this == paramObject)
      {
        AppMethodBeat.o(321839);
        return true;
      }
      if (!(paramObject instanceof WxaShortLinkLaunchParams))
      {
        AppMethodBeat.o(321839);
        return false;
      }
      paramObject = (WxaShortLinkLaunchParams)paramObject;
      if (!s.p(this.appId, paramObject.appId))
      {
        AppMethodBeat.o(321839);
        return false;
      }
      if (!s.p(this.path, paramObject.path))
      {
        AppMethodBeat.o(321839);
        return false;
      }
      if (this.version != paramObject.version)
      {
        AppMethodBeat.o(321839);
        return false;
      }
      if (this.euz != paramObject.euz)
      {
        AppMethodBeat.o(321839);
        return false;
      }
      if (!s.p(this.qAX, paramObject.qAX))
      {
        AppMethodBeat.o(321839);
        return false;
      }
      AppMethodBeat.o(321839);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(321829);
      int i = this.appId.hashCode();
      int j = this.path.hashCode();
      int k = this.version;
      int m = this.euz;
      int n = this.qAX.hashCode();
      AppMethodBeat.o(321829);
      return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(321824);
      String str = "WxaShortLinkLaunchParams(appId=" + this.appId + ", path=" + this.path + ", version=" + this.version + ", versionType=" + this.euz + ", shortLink=" + this.qAX + ')';
      AppMethodBeat.o(321824);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(321850);
      s.u(paramParcel, "out");
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.path);
      paramParcel.writeInt(this.version);
      paramParcel.writeInt(this.euz);
      paramParcel.writeString(this.qAX);
      AppMethodBeat.o(321850);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams>
    {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Boolean, ah>
  {
    b(AbsWxaShortLinkLauncher paramAbsWxaShortLinkLauncher, Activity paramActivity, AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams paramWxaShortLinkLaunchParams, b<? super WxaShortLinkLaunchErrorCode, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "cgiSuccess", "", "info", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Boolean, WxaShortLinkInfo, ah>
  {
    c(Activity paramActivity, b<? super WxaShortLinkLaunchErrorCode, ah> paramb, AbsWxaShortLinkLauncher paramAbsWxaShortLinkLauncher, String paramString)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(AbsWxaShortLinkLauncher paramAbsWxaShortLinkLauncher, Activity paramActivity, WxaShortLinkInfo paramWxaShortLinkInfo, String paramString, b<? super WxaShortLinkLaunchErrorCode, ah> paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "cgiSuccess", "", "info", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<Boolean, WxaShortLinkInfo, ah>
  {
    d(Activity paramActivity, b<? super WxaShortLinkLaunchErrorCode, ah> paramb, AbsWxaShortLinkLauncher paramAbsWxaShortLinkLauncher, String paramString)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(AbsWxaShortLinkLauncher paramAbsWxaShortLinkLauncher, Activity paramActivity, WxaShortLinkInfo paramWxaShortLinkInfo, String paramString, b<? super WxaShortLinkLaunchErrorCode, ah> paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher
 * JD-Core Version:    0.7.0.1
 */