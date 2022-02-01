package com.tencent.mm.plugin.appbrand.config;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "enable", "", "height", "", "activityAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "closeWhenClickEmptyArea", "bgShapeConf", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "forceLightMode", "closeWhenClickEmptyAreaConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "capsuleType", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CapsuleType;", "supportGesture", "showHalfScreenCommonHeader", "halfScreenStatusChangeListener", "Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "splashLoadingType", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$SplashLoadingType;", "showHalfScreenCustomHeader", "forbidSlidingUpGesture", "loadingDarkModeStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$LoadingDarkModeStyle;", "showBgMask", "shareActionConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ShareActionConfig;", "width", "landscapeHeight", "landscapeWidth", "autoFullScreenWhenTap", "showSplashBackButton", "consumeNavigationBarHeight", "mode", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Mode;", "(ZILcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;ZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;ZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CapsuleType;ZZLcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$SplashLoadingType;ZZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$LoadingDarkModeStyle;ZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ShareActionConfig;IIIZZZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Mode;)V", "value", "appServiceType", "getAppServiceType", "()I", "setAppServiceType", "(I)V", "isEnable", "()Z", "describeContents", "getActivityAnimStyle", "context", "Landroid/content/Context;", "getLoadingDarkModeStyle", "performCloseHalfScreen", "activity", "Landroid/app/Activity;", "toAnimationRes", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "style", "toBuilder", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Builder;", "toString", "", "writeToParcel", "", "flags", "ActivityAnimationStyle", "BackgroundShapeConfig", "Builder", "CapsuleType", "CloseWhenClickEmptyAreaConfig", "Companion", "LoadingDarkModeStyle", "Mode", "ShareActionConfig", "SplashLoadingType", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HalfScreenConfig
  implements Parcelable
{
  public static final Parcelable.Creator<HalfScreenConfig> CREATOR;
  public static final HalfScreenConfig.d qZI;
  public static final HalfScreenConfig rad;
  public int appServiceType;
  private final boolean enable;
  public final int height;
  private final a qZJ;
  public final boolean qZK;
  public final BackgroundShapeConfig qZL;
  public final CloseWhenClickEmptyAreaConfig qZM;
  public final c qZN;
  public final boolean qZO;
  public final boolean qZP;
  public final WeAppHalfScreenStatusChangeListener qZQ;
  public final HalfScreenConfig.h qZR;
  public final boolean qZS;
  public final boolean qZT;
  private final f qZU;
  public final boolean qZV;
  public final ShareActionConfig qZW;
  public final int qZX;
  public final int qZY;
  public final boolean qZZ;
  public final boolean qkq;
  public final boolean raa;
  public final boolean rab;
  public final g rac;
  public final int width;
  
  static
  {
    AppMethodBeat.i(323436);
    qZI = new HalfScreenConfig.d((byte)0);
    CREATOR = (Parcelable.Creator)new e();
    rad = new HalfScreenConfig(false, 0, null, false, null, false, null, null, false, false, null, null, false, false, null, false, null, 0, 0, 0, false, false, false, null, 16777212);
    AppMethodBeat.o(323436);
  }
  
  public HalfScreenConfig(Parcel paramParcel) {}
  
  public HalfScreenConfig(boolean paramBoolean1, int paramInt1, a parama, boolean paramBoolean2, BackgroundShapeConfig paramBackgroundShapeConfig, boolean paramBoolean3, CloseWhenClickEmptyAreaConfig paramCloseWhenClickEmptyAreaConfig, c paramc, boolean paramBoolean4, boolean paramBoolean5, WeAppHalfScreenStatusChangeListener paramWeAppHalfScreenStatusChangeListener, HalfScreenConfig.h paramh, boolean paramBoolean6, boolean paramBoolean7, f paramf, boolean paramBoolean8, ShareActionConfig paramShareActionConfig, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, g paramg)
  {
    AppMethodBeat.i(323425);
    this.height = paramInt1;
    this.qZJ = parama;
    this.qZK = paramBoolean2;
    this.qZL = paramBackgroundShapeConfig;
    this.qkq = paramBoolean3;
    this.qZM = paramCloseWhenClickEmptyAreaConfig;
    this.qZN = paramc;
    this.qZO = paramBoolean4;
    this.qZP = paramBoolean5;
    this.qZQ = paramWeAppHalfScreenStatusChangeListener;
    this.qZR = paramh;
    this.qZS = paramBoolean6;
    this.qZT = paramBoolean7;
    this.qZU = paramf;
    this.qZV = paramBoolean8;
    this.qZW = paramShareActionConfig;
    this.width = paramInt2;
    this.qZX = paramInt3;
    this.qZY = paramInt4;
    this.qZZ = paramBoolean9;
    this.raa = paramBoolean10;
    this.rab = paramBoolean11;
    this.rac = paramg;
    this.enable = paramBoolean1;
    AppMethodBeat.o(323425);
  }
  
  public final f ckP()
  {
    if ((this.qZU == f.rav) && (this.qkq)) {
      return f.raw;
    }
    return this.qZU;
  }
  
  public final b ckQ()
  {
    AppMethodBeat.i(323455);
    b localb = new b();
    localb.ix(isEnable());
    localb.zF(this.height);
    localb.zG(this.width);
    localb.zH(this.qZX);
    localb.zI(this.qZY);
    localb.a(this.qZJ);
    localb.iy(this.qZK);
    localb.a(this.qZM);
    localb.a(this.qZL);
    localb.iz(this.qkq);
    localb.a(this.qZM);
    localb.a(this.qZN);
    localb.iA(this.qZO);
    localb.iC(this.qZP);
    localb.a(this.qZQ);
    localb.a(this.qZR);
    localb.iD(this.qZS);
    localb.iA(this.qZT);
    localb.a(this.qZU);
    localb.iE(this.qZV);
    localb.a(this.qZW);
    localb.iF(this.qZZ);
    localb.iG(this.raa);
    localb.iH(this.rab);
    localb.a(this.rac);
    AppMethodBeat.o(323455);
    return localb;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final a ez(Context paramContext)
  {
    AppMethodBeat.i(323442);
    s.u(paramContext, "context");
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      paramContext = a.raf;
      AppMethodBeat.o(323442);
      return paramContext;
    }
    paramContext = this.qZJ;
    AppMethodBeat.o(323442);
    return paramContext;
  }
  
  public final boolean isEnable()
  {
    return (this.enable) && (this.height != 0) && (this.appServiceType != 4);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(323458);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HalfScreenConfig(height=").append(this.height).append(", activityAnimStyle=").append(this.qZJ).append(", closeWhenClickEmptyArea=").append(this.qZK).append(", bgShapeConf=").append(this.qZL).append(", forceLightMode=").append(this.qkq).append(", closeWhenClickEmptyAreaConfig=").append(this.qZM).append(", capsuleType=").append(this.qZN).append(", supportGesture=").append(this.qZO).append(", showHalfScreenCommonHeader=").append(this.qZP).append(", halfScreenStatusChangeListener=").append(this.qZQ).append(", splashLoadingType=").append(this.qZR).append(", showHalfScreenCustomHeader=");
    ((StringBuilder)localObject).append(this.qZS).append(", forbidSlidingUpGesture=").append(this.qZT).append(", loadingDarkModeStyle=").append(this.qZU).append(", showBgMask=").append(this.qZV).append(", shareActionConfig=").append(this.qZW).append(", autoFullScreenWhenTap=").append(this.qZZ).append(", consumeNavigationBarHeight=").append(this.rab).append(", appServiceType=").append(this.appServiceType).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(323458);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(323448);
    s.u(paramParcel, "parcel");
    int i;
    if (isEnable())
    {
      i = 1;
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.height);
      paramParcel.writeString(this.qZJ.name());
      if (!this.qZK) {
        break label328;
      }
      b1 = 1;
      label59:
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable((Parcelable)this.qZL, paramInt);
      if (!this.qkq) {
        break label333;
      }
      b1 = 1;
      label85:
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable((Parcelable)this.qZM, paramInt);
      paramParcel.writeString(this.qZN.name());
      if (!this.qZO) {
        break label338;
      }
      b1 = 1;
      label122:
      paramParcel.writeByte(b1);
      if (!this.qZP) {
        break label343;
      }
      b1 = 1;
      label136:
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable((Parcelable)this.qZQ, paramInt);
      paramParcel.writeString(this.qZR.name());
      if (!this.qZS) {
        break label348;
      }
      b1 = 1;
      label173:
      paramParcel.writeByte(b1);
      if (!this.qZT) {
        break label353;
      }
      b1 = 1;
      label187:
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.qZU.name());
      if (!this.qZV) {
        break label358;
      }
      b1 = 1;
      label212:
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable((Parcelable)this.qZW, paramInt);
      paramParcel.writeInt(this.width);
      paramParcel.writeInt(this.qZX);
      paramParcel.writeInt(this.qZY);
      if (!this.qZZ) {
        break label363;
      }
      b1 = 1;
      label262:
      paramParcel.writeByte(b1);
      if (!this.raa) {
        break label368;
      }
      b1 = 1;
      label276:
      paramParcel.writeByte(b1);
      if (!this.rab) {
        break label373;
      }
    }
    label328:
    label333:
    label338:
    label343:
    label348:
    label353:
    label358:
    label363:
    label368:
    label373:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.rac.name());
      paramParcel.writeInt(this.appServiceType);
      AppMethodBeat.o(323448);
      return;
      i = 0;
      break;
      b1 = 0;
      break label59;
      b1 = 0;
      break label85;
      b1 = 0;
      break label122;
      b1 = 0;
      break label136;
      b1 = 0;
      break label173;
      b1 = 0;
      break label187;
      b1 = 0;
      break label212;
      b1 = 0;
      break label262;
      b1 = 0;
      break label276;
    }
  }
  
  public final void zE(int paramInt)
  {
    AppMethodBeat.i(323439);
    this.appServiceType = paramInt;
    Log.i("MicroMsg.HalfScreenConfig", "set appServiceType[" + paramInt + ']');
    AppMethodBeat.o(323439);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "cornerRadius", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FZZZZ)V", "getBottomLeft", "()Z", "getBottomRight", "getCornerRadius", "()F", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "getRadiusArray", "", "context", "Landroid/content/Context;", "hashCode", "toString", "", "writeToParcel", "", "flags", "Companion", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class BackgroundShapeConfig
    implements Parcelable
  {
    public static final Parcelable.Creator<BackgroundShapeConfig> CREATOR;
    public static final HalfScreenConfig.BackgroundShapeConfig.a rah;
    public static final BackgroundShapeConfig ram;
    public final float dwJ;
    public final boolean rai;
    public final boolean raj;
    public final boolean rak;
    public final boolean ral;
    
    static
    {
      AppMethodBeat.i(323460);
      rah = new HalfScreenConfig.BackgroundShapeConfig.a((byte)0);
      ram = new BackgroundShapeConfig(0.0F, false, false, 31);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(323460);
    }
    
    public BackgroundShapeConfig()
    {
      this(0.0F, false, false, 31);
    }
    
    public BackgroundShapeConfig(float paramFloat, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.dwJ = paramFloat;
      this.rai = paramBoolean1;
      this.raj = paramBoolean2;
      this.rak = paramBoolean3;
      this.ral = paramBoolean4;
    }
    
    public BackgroundShapeConfig(Parcel paramParcel) {}
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(323474);
      if (this == paramObject)
      {
        AppMethodBeat.o(323474);
        return true;
      }
      if (!(paramObject instanceof BackgroundShapeConfig))
      {
        AppMethodBeat.o(323474);
        return false;
      }
      paramObject = (BackgroundShapeConfig)paramObject;
      if (!s.p(Float.valueOf(this.dwJ), Float.valueOf(paramObject.dwJ)))
      {
        AppMethodBeat.o(323474);
        return false;
      }
      if (this.rai != paramObject.rai)
      {
        AppMethodBeat.o(323474);
        return false;
      }
      if (this.raj != paramObject.raj)
      {
        AppMethodBeat.o(323474);
        return false;
      }
      if (this.rak != paramObject.rak)
      {
        AppMethodBeat.o(323474);
        return false;
      }
      if (this.ral != paramObject.ral)
      {
        AppMethodBeat.o(323474);
        return false;
      }
      AppMethodBeat.o(323474);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(323466);
      String str = "BackgroundShapeConfig(cornerRadius=" + this.dwJ + ", topLeft=" + this.rai + ", topRight=" + this.raj + ", bottomLeft=" + this.rak + ", bottomRight=" + this.ral + ')';
      AppMethodBeat.o(323466);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(323462);
      s.u(paramParcel, "parcel");
      paramParcel.writeFloat(this.dwJ);
      if (this.rai)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.raj) {
          break label90;
        }
        b1 = 1;
        label45:
        paramParcel.writeByte(b1);
        if (!this.rak) {
          break label95;
        }
        b1 = 1;
        label59:
        paramParcel.writeByte(b1);
        if (!this.ral) {
          break label100;
        }
      }
      label90:
      label95:
      label100:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(323462);
        return;
        b1 = 0;
        break;
        b1 = 0;
        break label45;
        b1 = 0;
        break label59;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Parcelable.Creator<HalfScreenConfig.BackgroundShapeConfig>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "activityClassName", "", "closeAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;)V", "getActivityClassName", "()Ljava/lang/String;", "getCloseAnimStyle", "()Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class CloseWhenClickEmptyAreaConfig
    implements Parcelable
  {
    public static final Parcelable.Creator<CloseWhenClickEmptyAreaConfig> CREATOR;
    public static final HalfScreenConfig.CloseWhenClickEmptyAreaConfig.a rar;
    public static final CloseWhenClickEmptyAreaConfig rau;
    public final String ras;
    public final HalfScreenConfig.a rat;
    
    static
    {
      AppMethodBeat.i(323402);
      rar = new HalfScreenConfig.CloseWhenClickEmptyAreaConfig.a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      rau = new CloseWhenClickEmptyAreaConfig("", HalfScreenConfig.a.rae);
      AppMethodBeat.o(323402);
    }
    
    public CloseWhenClickEmptyAreaConfig(Parcel paramParcel)
    {
      this(str1, HalfScreenConfig.a.valueOf(paramParcel));
      AppMethodBeat.i(323399);
      AppMethodBeat.o(323399);
    }
    
    public CloseWhenClickEmptyAreaConfig(String paramString, HalfScreenConfig.a parama)
    {
      AppMethodBeat.i(323395);
      this.ras = paramString;
      this.rat = parama;
      AppMethodBeat.o(323395);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(323416);
      if (this == paramObject)
      {
        AppMethodBeat.o(323416);
        return true;
      }
      if (!(paramObject instanceof CloseWhenClickEmptyAreaConfig))
      {
        AppMethodBeat.o(323416);
        return false;
      }
      paramObject = (CloseWhenClickEmptyAreaConfig)paramObject;
      if (!s.p(this.ras, paramObject.ras))
      {
        AppMethodBeat.o(323416);
        return false;
      }
      if (this.rat != paramObject.rat)
      {
        AppMethodBeat.o(323416);
        return false;
      }
      AppMethodBeat.o(323416);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(323412);
      int i = this.ras.hashCode();
      int j = this.rat.hashCode();
      AppMethodBeat.o(323412);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(323410);
      String str = "CloseWhenClickEmptyAreaConfig(activityClassName=" + this.ras + ", closeAnimStyle=" + this.rat + ')';
      AppMethodBeat.o(323410);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(323405);
      s.u(paramParcel, "parcel");
      paramParcel.writeString(this.ras);
      paramParcel.writeString(this.rat.name());
      AppMethodBeat.o(323405);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Parcelable.Creator<HalfScreenConfig.CloseWhenClickEmptyAreaConfig>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ShareActionConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "showShare", "", "token", "", "(ZLjava/lang/String;)V", "getShowShare", "()Z", "getToken", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ShareActionConfig
    implements Parcelable
  {
    public static final Parcelable.Creator<ShareActionConfig> CREATOR;
    public static final HalfScreenConfig.ShareActionConfig.a raC;
    public static final ShareActionConfig raD;
    public final boolean hTH;
    public final String token;
    
    static
    {
      AppMethodBeat.i(323426);
      raC = new HalfScreenConfig.ShareActionConfig.a((byte)0);
      raD = new ShareActionConfig();
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(323426);
    }
    
    private ShareActionConfig(byte paramByte)
    {
      this();
    }
    
    public ShareActionConfig(Parcel paramParcel) {}
    
    public ShareActionConfig(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(323413);
      this.hTH = paramBoolean;
      this.token = paramString;
      AppMethodBeat.o(323413);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(323437);
      if (this == paramObject)
      {
        AppMethodBeat.o(323437);
        return true;
      }
      if (!(paramObject instanceof ShareActionConfig))
      {
        AppMethodBeat.o(323437);
        return false;
      }
      paramObject = (ShareActionConfig)paramObject;
      if (this.hTH != paramObject.hTH)
      {
        AppMethodBeat.o(323437);
        return false;
      }
      if (!s.p(this.token, paramObject.token))
      {
        AppMethodBeat.o(323437);
        return false;
      }
      AppMethodBeat.o(323437);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(323431);
      String str = "ShareActionConfig(showShare=" + this.hTH + ", token=" + this.token + ')';
      AppMethodBeat.o(323431);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(323427);
      s.u(paramParcel, "parcel");
      if (this.hTH) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.token);
        AppMethodBeat.o(323427);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ShareActionConfig$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ShareActionConfig;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ShareActionConfig;", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Parcelable.Creator<HalfScreenConfig.ShareActionConfig>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "", "(Ljava/lang/String;I)V", "POPUP", "SLIDE", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(323495);
      rae = new a("POPUP", 0);
      raf = new a("SLIDE", 1);
      rag = new a[] { rae, raf };
      AppMethodBeat.o(323495);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Builder;", "", "()V", "activityAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "autoFullScreenWhenTap", "", "bgShapeConf", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "capsuleType", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CapsuleType;", "closeWhenClickEmptyArea", "closeWhenClickEmptyAreaConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "consumeNavigationBarHeight", "enable", "forbidSlidingUpGesture", "forceLightMode", "halfScreenStatusChangeListener", "Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "height", "", "landscapeHeight", "landscapeWidth", "loadingDarkModeStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$LoadingDarkModeStyle;", "mode", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Mode;", "shareActionConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ShareActionConfig;", "showBgMask", "showHalfScreenCommonHeader", "showHalfScreenCustomHeader", "showSplashBackButton", "splashLoadingType", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$SplashLoadingType;", "supportGesture", "width", "build", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private boolean enable;
    private int height = -1;
    private HalfScreenConfig.a qZJ = HalfScreenConfig.a.rae;
    private boolean qZK;
    private HalfScreenConfig.BackgroundShapeConfig qZL = HalfScreenConfig.BackgroundShapeConfig.ram;
    private HalfScreenConfig.CloseWhenClickEmptyAreaConfig qZM = HalfScreenConfig.CloseWhenClickEmptyAreaConfig.rau;
    private HalfScreenConfig.c qZN = HalfScreenConfig.c.ran;
    private boolean qZO;
    private boolean qZP;
    private WeAppHalfScreenStatusChangeListener qZQ;
    private HalfScreenConfig.h qZR = HalfScreenConfig.h.raF;
    private boolean qZS;
    private boolean qZT;
    private HalfScreenConfig.f qZU = HalfScreenConfig.f.rav;
    private boolean qZV;
    private HalfScreenConfig.ShareActionConfig qZW = HalfScreenConfig.ShareActionConfig.raD;
    private int qZX = -2;
    private int qZY = -2;
    private boolean qZZ = true;
    private boolean qkq;
    private boolean raa = true;
    private boolean rab = true;
    private HalfScreenConfig.g rac = HalfScreenConfig.g.raz;
    private int width = -1;
    
    public final b a(HalfScreenConfig.BackgroundShapeConfig paramBackgroundShapeConfig)
    {
      AppMethodBeat.i(323534);
      s.u(paramBackgroundShapeConfig, "bgShapeConf");
      ((b)this).qZL = paramBackgroundShapeConfig;
      paramBackgroundShapeConfig = (b)this;
      AppMethodBeat.o(323534);
      return paramBackgroundShapeConfig;
    }
    
    public final b a(HalfScreenConfig.CloseWhenClickEmptyAreaConfig paramCloseWhenClickEmptyAreaConfig)
    {
      AppMethodBeat.i(323541);
      s.u(paramCloseWhenClickEmptyAreaConfig, "closeWhenClickEmptyAreaConfig");
      ((b)this).qZM = paramCloseWhenClickEmptyAreaConfig;
      paramCloseWhenClickEmptyAreaConfig = (b)this;
      AppMethodBeat.o(323541);
      return paramCloseWhenClickEmptyAreaConfig;
    }
    
    public final b a(HalfScreenConfig.ShareActionConfig paramShareActionConfig)
    {
      AppMethodBeat.i(323598);
      s.u(paramShareActionConfig, "shareActionConfig");
      ((b)this).qZW = paramShareActionConfig;
      paramShareActionConfig = (b)this;
      AppMethodBeat.o(323598);
      return paramShareActionConfig;
    }
    
    public final b a(HalfScreenConfig.a parama)
    {
      AppMethodBeat.i(323522);
      s.u(parama, "activityAnimStyle");
      ((b)this).qZJ = parama;
      parama = (b)this;
      AppMethodBeat.o(323522);
      return parama;
    }
    
    public final b a(HalfScreenConfig.c paramc)
    {
      AppMethodBeat.i(323547);
      s.u(paramc, "capsuleType");
      ((b)this).qZN = paramc;
      paramc = (b)this;
      AppMethodBeat.o(323547);
      return paramc;
    }
    
    public final b a(HalfScreenConfig.f paramf)
    {
      AppMethodBeat.i(323584);
      s.u(paramf, "loadingDarkModeStyle");
      ((b)this).qZU = paramf;
      paramf = (b)this;
      AppMethodBeat.o(323584);
      return paramf;
    }
    
    public final b a(HalfScreenConfig.g paramg)
    {
      AppMethodBeat.i(323630);
      s.u(paramg, "mode");
      ((b)this).rac = paramg;
      paramg = (b)this;
      AppMethodBeat.o(323630);
      return paramg;
    }
    
    public final b a(HalfScreenConfig.h paramh)
    {
      AppMethodBeat.i(323568);
      s.u(paramh, "splashLoadingType");
      ((b)this).qZR = paramh;
      paramh = (b)this;
      AppMethodBeat.o(323568);
      return paramh;
    }
    
    public final b a(WeAppHalfScreenStatusChangeListener paramWeAppHalfScreenStatusChangeListener)
    {
      ((b)this).qZQ = paramWeAppHalfScreenStatusChangeListener;
      return (b)this;
    }
    
    public final HalfScreenConfig ckR()
    {
      AppMethodBeat.i(323639);
      HalfScreenConfig localHalfScreenConfig = new HalfScreenConfig(this.enable, this.height, this.qZJ, this.qZK, this.qZL, this.qkq, this.qZM, this.qZN, this.qZO, this.qZP, this.qZQ, this.qZR, this.qZS, this.qZT, this.qZU, this.qZV, this.qZW, this.width, this.qZX, this.qZY, this.qZZ, this.raa, this.rab, this.rac);
      AppMethodBeat.o(323639);
      return localHalfScreenConfig;
    }
    
    public final b iA(boolean paramBoolean)
    {
      ((b)this).qZO = paramBoolean;
      return (b)this;
    }
    
    public final b iB(boolean paramBoolean)
    {
      ((b)this).qZT = paramBoolean;
      return (b)this;
    }
    
    public final b iC(boolean paramBoolean)
    {
      ((b)this).qZP = paramBoolean;
      return (b)this;
    }
    
    public final b iD(boolean paramBoolean)
    {
      ((b)this).qZS = paramBoolean;
      return (b)this;
    }
    
    public final b iE(boolean paramBoolean)
    {
      ((b)this).qZV = paramBoolean;
      return (b)this;
    }
    
    public final b iF(boolean paramBoolean)
    {
      ((b)this).qZZ = paramBoolean;
      return (b)this;
    }
    
    public final b iG(boolean paramBoolean)
    {
      ((b)this).raa = paramBoolean;
      return (b)this;
    }
    
    public final b iH(boolean paramBoolean)
    {
      ((b)this).rab = paramBoolean;
      return (b)this;
    }
    
    public final b ix(boolean paramBoolean)
    {
      ((b)this).enable = paramBoolean;
      return (b)this;
    }
    
    public final b iy(boolean paramBoolean)
    {
      ((b)this).qZK = paramBoolean;
      return (b)this;
    }
    
    public final b iz(boolean paramBoolean)
    {
      ((b)this).qkq = paramBoolean;
      return (b)this;
    }
    
    public final b zF(int paramInt)
    {
      ((b)this).height = paramInt;
      return (b)this;
    }
    
    public final b zG(int paramInt)
    {
      ((b)this).width = paramInt;
      return (b)this;
    }
    
    public final b zH(int paramInt)
    {
      ((b)this).qZX = paramInt;
      return (b)this;
    }
    
    public final b zI(int paramInt)
    {
      ((b)this).qZY = paramInt;
      return (b)this;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CapsuleType;", "", "(Ljava/lang/String;I)V", "NORMAL", "SINGLE_CLOSE", "HIDE", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(323502);
      ran = new c("NORMAL", 0);
      rao = new c("SINGLE_CLOSE", 1);
      rap = new c("HIDE", 2);
      raq = new c[] { ran, rao, rap };
      AppMethodBeat.o(323502);
    }
    
    private c() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Parcelable.Creator<HalfScreenConfig>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$LoadingDarkModeStyle;", "", "(Ljava/lang/String;I)V", "NORMAL", "FORCE_LIGHT", "FORCE_DARK", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum f
  {
    static
    {
      AppMethodBeat.i(323498);
      rav = new f("NORMAL", 0);
      raw = new f("FORCE_LIGHT", 1);
      rax = new f("FORCE_DARK", 2);
      ray = new f[] { rav, raw, rax };
      AppMethodBeat.o(323498);
    }
    
    private f() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Mode;", "", "(Ljava/lang/String;I)V", "NORMAL", "EMBED", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum g
  {
    static
    {
      AppMethodBeat.i(323506);
      raz = new g("NORMAL", 0);
      raA = new g("EMBED", 1);
      raB = new g[] { raz, raA };
      AppMethodBeat.o(323506);
    }
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.HalfScreenConfig
 * JD-Core Version:    0.7.0.1
 */