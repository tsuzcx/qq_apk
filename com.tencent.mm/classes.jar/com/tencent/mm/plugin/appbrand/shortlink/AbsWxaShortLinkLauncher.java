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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher;", "", "()V", "getBusinessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "getShortLinkCgiCache", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "innerLaunch", "", "ctx", "Landroid/app/Activity;", "params", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "resultCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "Lkotlin/ParameterName;", "name", "errorCode", "launch", "Landroid/content/Context;", "launchResultCallback", "", "success", "launchWithLink", "link", "", "showLaunchWxaTipDialog", "launchWithLinkNoCheck", "onDecodeLinkFailed", "url", "onLaunchDone", "onLinkDecodeDone", "onLinkIllegal", "onUserCancel", "Companion", "WxaShortLinkLaunchParams", "luggage-wechat-full-sdk_release"})
public abstract class AbsWxaShortLinkLauncher
{
  private static final Pattern qPU;
  public static final AbsWxaShortLinkLauncher.a qPV = new AbsWxaShortLinkLauncher.a((byte)0);
  
  static
  {
    Pattern localPattern = Pattern.compile("^mp://\\w+");
    p.j(localPattern, "Pattern.compile(\"^$SHORT_LINK_SCHEME\\\\w+\")");
    qPU = localPattern;
  }
  
  protected static void e(Activity paramActivity, String paramString)
  {
    p.k(paramActivity, "ctx");
    p.k(paramString, "url");
  }
  
  protected abstract void a(Context paramContext, WxaShortLinkLaunchParams paramWxaShortLinkLaunchParams, b<? super Boolean, x> paramb);
  
  protected boolean a(Activity paramActivity, boolean paramBoolean)
  {
    p.k(paramActivity, "ctx");
    return true;
  }
  
  public final void b(final Activity paramActivity, final String paramString, final b<? super WxaShortLinkLaunchErrorCode, x> paramb)
  {
    p.k(paramActivity, "ctx");
    p.k(paramString, "link");
    m localm = (m)new c(this, paramActivity, paramb, paramString);
    Object localObject = ciF();
    if (localObject != null) {}
    for (localObject = ((a)localObject).amR(paramString); localObject != null; localObject = null)
    {
      Log.i("MicroMsg.AbsWxaShortLinkLauncher", "use cache for link:".concat(String.valueOf(paramString)));
      localm.invoke(Boolean.TRUE, localObject);
      return;
    }
    if (qPU.matcher((CharSequence)paramString).matches())
    {
      new com.tencent.mm.plugin.appbrand.shortlink.cgi.a();
      com.tencent.mm.plugin.appbrand.shortlink.cgi.a.a(paramString, ciE(), localm);
      return;
    }
    p.k(paramActivity, "ctx");
    p.k(paramString, "url");
    paramb.invoke(WxaShortLinkLaunchErrorCode.ILLEGAL_LINK);
  }
  
  protected void b(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    p.k(paramActivity, "ctx");
    p.k(paramString, "url");
  }
  
  public final void c(final Activity paramActivity, final String paramString, final b<? super WxaShortLinkLaunchErrorCode, x> paramb)
  {
    p.k(paramActivity, "ctx");
    p.k(paramString, "link");
    paramb = (m)new d(this, paramActivity, paramb, paramString);
    paramActivity = ciF();
    if (paramActivity != null) {}
    for (paramActivity = paramActivity.amR(paramString);; paramActivity = null)
    {
      if (paramActivity != null)
      {
        Log.i("MicroMsg.AbsWxaShortLinkLauncher", "use cache for link:".concat(String.valueOf(paramString)));
        paramb.invoke(Boolean.TRUE, paramActivity);
      }
      return;
    }
  }
  
  protected abstract a.b ciE();
  
  protected a ciF()
  {
    return null;
  }
  
  protected void f(Activity paramActivity, String paramString)
  {
    p.k(paramActivity, "ctx");
    p.k(paramString, "url");
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "Landroid/os/Parcelable;", "appId", "", "path", "version", "", "versionType", "shortLink", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getPath", "getShortLink", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"})
  public static final class WxaShortLinkLaunchParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    public final String appId;
    public final int cBU;
    public final String nBJ;
    public final String path;
    public final int version;
    
    static
    {
      AppMethodBeat.i(242270);
      CREATOR = new a();
      AppMethodBeat.o(242270);
    }
    
    public WxaShortLinkLaunchParams(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
    {
      AppMethodBeat.i(242263);
      this.appId = paramString1;
      this.path = paramString2;
      this.version = paramInt1;
      this.cBU = paramInt2;
      this.nBJ = paramString3;
      AppMethodBeat.o(242263);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(242266);
      if (this != paramObject)
      {
        if ((paramObject instanceof WxaShortLinkLaunchParams))
        {
          paramObject = (WxaShortLinkLaunchParams)paramObject;
          if ((!p.h(this.appId, paramObject.appId)) || (!p.h(this.path, paramObject.path)) || (this.version != paramObject.version) || (this.cBU != paramObject.cBU) || (!p.h(this.nBJ, paramObject.nBJ))) {}
        }
      }
      else
      {
        AppMethodBeat.o(242266);
        return true;
      }
      AppMethodBeat.o(242266);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(242265);
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
        int n = this.cBU;
        str = this.nBJ;
        if (str != null) {
          k = str.hashCode();
        }
        AppMethodBeat.o(242265);
        return (((j + i * 31) * 31 + m) * 31 + n) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(242264);
      String str = "WxaShortLinkLaunchParams(appId=" + this.appId + ", path=" + this.path + ", version=" + this.version + ", versionType=" + this.cBU + ", shortLink=" + this.nBJ + ")";
      AppMethodBeat.o(242264);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(242268);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.path);
      paramParcel.writeInt(this.version);
      paramParcel.writeInt(this.cBU);
      paramParcel.writeString(this.nBJ);
      AppMethodBeat.o(242268);
    }
    
    @l(iBK={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(247495);
        p.k(paramParcel, "in");
        paramParcel = new AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams(paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString());
        AppMethodBeat.o(247495);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams[paramInt];
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "invoke"})
  static final class b
    extends q
    implements b<Boolean, x>
  {
    b(AbsWxaShortLinkLauncher paramAbsWxaShortLinkLauncher, Activity paramActivity, AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams paramWxaShortLinkLaunchParams, b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "cgiSuccess", "", "info", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "invoke"})
  static final class c
    extends q
    implements m<Boolean, WxaShortLinkInfo, x>
  {
    c(AbsWxaShortLinkLauncher paramAbsWxaShortLinkLauncher, Activity paramActivity, b paramb, String paramString)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "cgiSuccess", "", "info", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "invoke"})
  static final class d
    extends q
    implements m<Boolean, WxaShortLinkInfo, x>
  {
    d(AbsWxaShortLinkLauncher paramAbsWxaShortLinkLauncher, Activity paramActivity, b paramb, String paramString)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(AbsWxaShortLinkLauncher.d paramd, Activity paramActivity, WxaShortLinkInfo paramWxaShortLinkInfo)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher
 * JD-Core Version:    0.7.0.1
 */