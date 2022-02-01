package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/config/LaunchWxaAppInfoParcelized;", "Landroid/os/Parcelable;", "permission", "Lcom/tencent/mm/plugin/appbrand/permission/AppRuntimeApiPermissionBundle;", "errorAction", "opConfig", "", "relyCommLibUpdate", "", "(Lcom/tencent/mm/plugin/appbrand/permission/AppRuntimeApiPermissionBundle;Landroid/os/Parcelable;Ljava/lang/String;Z)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"})
public final class LaunchWxaAppInfoParcelized
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public AppRuntimeApiPermissionBundle cxO;
  public Parcelable cxP;
  public String cxQ;
  public boolean cxR;
  
  static
  {
    AppMethodBeat.i(253074);
    CREATOR = new a();
    AppMethodBeat.o(253074);
  }
  
  public LaunchWxaAppInfoParcelized(AppRuntimeApiPermissionBundle paramAppRuntimeApiPermissionBundle, Parcelable paramParcelable, String paramString, boolean paramBoolean)
  {
    this.cxO = paramAppRuntimeApiPermissionBundle;
    this.cxP = paramParcelable;
    this.cxQ = paramString;
    this.cxR = paramBoolean;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(236693);
      p.k(paramParcel, "in");
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle;
      Parcelable localParcelable;
      String str;
      if (paramParcel.readInt() != 0)
      {
        localAppRuntimeApiPermissionBundle = (AppRuntimeApiPermissionBundle)AppRuntimeApiPermissionBundle.CREATOR.createFromParcel(paramParcel);
        localParcelable = paramParcel.readParcelable(LaunchWxaAppInfoParcelized.class.getClassLoader());
        str = paramParcel.readString();
        if (paramParcel.readInt() == 0) {
          break label83;
        }
      }
      label83:
      for (boolean bool = true;; bool = false)
      {
        paramParcel = new LaunchWxaAppInfoParcelized(localAppRuntimeApiPermissionBundle, localParcelable, str, bool);
        AppMethodBeat.o(236693);
        return paramParcel;
        localAppRuntimeApiPermissionBundle = null;
        break;
      }
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new LaunchWxaAppInfoParcelized[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized
 * JD-Core Version:    0.7.0.1
 */