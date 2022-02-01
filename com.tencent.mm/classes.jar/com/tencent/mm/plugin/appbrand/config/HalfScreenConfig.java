package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "enable", "", "height", "", "activityAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "closeWhenClickEmptyArea", "bgShapeConf", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "forceLightMode", "closeWhenClickEmptyAreaConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "capsuleType", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CapsuleType;", "supportGesture", "showHalfScreenCommonHeader", "halfScreenStatusChangeListener", "Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "splashLoadingType", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$SplashLoadingType;", "showHalfScreenCustomHeader", "(ZILcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;ZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;ZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CapsuleType;ZZLcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$SplashLoadingType;Z)V", "value", "appServiceType", "getAppServiceType", "()I", "setAppServiceType", "(I)V", "isEnable", "()Z", "describeContents", "performCloseHalfScreen", "activity", "Landroid/app/Activity;", "toAnimationRes", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "style", "toBuilder", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Builder;", "toString", "", "writeToParcel", "", "flags", "ActivityAnimationStyle", "BackgroundShapeConfig", "Builder", "CapsuleType", "CloseWhenClickEmptyAreaConfig", "Companion", "SplashLoadingType", "data-model_release"})
public final class HalfScreenConfig
  implements Parcelable
{
  public static final Parcelable.Creator<HalfScreenConfig> CREATOR;
  public static final HalfScreenConfig nZJ;
  public static final d nZK;
  public int cwR;
  private final boolean enable;
  public final int height;
  public final boolean nZA;
  public final BackgroundShapeConfig nZB;
  public final CloseWhenClickEmptyAreaConfig nZC;
  public final c nZD;
  public final boolean nZE;
  public final boolean nZF;
  public final WeAppHalfScreenStatusChangeListener nZG;
  public final f nZH;
  public final boolean nZI;
  public final a nZz;
  public final boolean nnk;
  
  static
  {
    AppMethodBeat.i(187866);
    nZK = new d((byte)0);
    CREATOR = (Parcelable.Creator)new HalfScreenConfig.e();
    nZJ = new HalfScreenConfig(false, 0, null, false, null, false, null, null, false, false, null, null, false, 8188);
    AppMethodBeat.o(187866);
  }
  
  public HalfScreenConfig(Parcel paramParcel) {}
  
  public HalfScreenConfig(boolean paramBoolean1, int paramInt, a parama, boolean paramBoolean2, BackgroundShapeConfig paramBackgroundShapeConfig, boolean paramBoolean3, CloseWhenClickEmptyAreaConfig paramCloseWhenClickEmptyAreaConfig, c paramc, boolean paramBoolean4, boolean paramBoolean5, WeAppHalfScreenStatusChangeListener paramWeAppHalfScreenStatusChangeListener, f paramf, boolean paramBoolean6)
  {
    AppMethodBeat.i(187860);
    this.height = paramInt;
    this.nZz = parama;
    this.nZA = paramBoolean2;
    this.nZB = paramBackgroundShapeConfig;
    this.nnk = paramBoolean3;
    this.nZC = paramCloseWhenClickEmptyAreaConfig;
    this.nZD = paramc;
    this.nZE = paramBoolean4;
    this.nZF = paramBoolean5;
    this.nZG = paramWeAppHalfScreenStatusChangeListener;
    this.nZH = paramf;
    this.nZI = paramBoolean6;
    this.enable = paramBoolean1;
    AppMethodBeat.o(187860);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean isEnable()
  {
    return (this.enable) && (this.height != 0) && (this.cwR != 4);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187859);
    String str = "HalfScreenConfig(height=" + this.height + ", activityAnimStyle=" + this.nZz + ", closeWhenClickEmptyArea=" + this.nZA + ", bgShapeConf=" + this.nZB + ", forceLightMode=" + this.nnk + ", closeWhenClickEmptyAreaConfig=" + this.nZC + ", capsuleType=" + this.nZD + ", supportGesture=" + this.nZE + ", showHalfScreenCommonHeader=" + this.nZF + ", halfScreenStatusChangeListener=" + this.nZG + ", splashLoadingType=" + this.nZH + ", showHalfScreenCustomHeader=" + this.nZI + ", appServiceType=" + this.cwR + ')';
    AppMethodBeat.o(187859);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(187856);
    p.k(paramParcel, "parcel");
    int i;
    if (isEnable())
    {
      i = 1;
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.height);
      paramParcel.writeString(this.nZz.name());
      if (!this.nZA) {
        break label200;
      }
      b1 = 1;
      label59:
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable((Parcelable)this.nZB, paramInt);
      if (!this.nnk) {
        break label205;
      }
      b1 = 1;
      label85:
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable((Parcelable)this.nZC, paramInt);
      paramParcel.writeString(this.nZD.name());
      if (!this.nZE) {
        break label210;
      }
      b1 = 1;
      label122:
      paramParcel.writeByte(b1);
      if (!this.nZF) {
        break label215;
      }
      b1 = 1;
      label136:
      paramParcel.writeByte(b1);
      paramParcel.writeParcelable((Parcelable)this.nZG, paramInt);
      paramParcel.writeString(this.nZH.name());
      if (!this.nZI) {
        break label220;
      }
    }
    label200:
    label205:
    label210:
    label215:
    label220:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.cwR);
      AppMethodBeat.o(187856);
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
    }
  }
  
  public final void zq(int paramInt)
  {
    AppMethodBeat.i(187855);
    this.cwR = paramInt;
    Log.i("MicroMsg.HalfScreenConfig", "set appServiceType[" + paramInt + ']');
    AppMethodBeat.o(187855);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "cornerRadius", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FZZZZ)V", "getBottomLeft", "()Z", "getBottomRight", "getCornerRadius", "()F", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "getRadiusArray", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "Companion", "data-model_release"})
  public static final class BackgroundShapeConfig
    implements Parcelable
  {
    public static final Parcelable.Creator<BackgroundShapeConfig> CREATOR;
    public static final BackgroundShapeConfig nZS;
    public static final a nZT;
    public final float bDI;
    public final boolean nZO;
    public final boolean nZP;
    public final boolean nZQ;
    public final boolean nZR;
    
    static
    {
      AppMethodBeat.i(187247);
      nZT = new a((byte)0);
      nZS = new BackgroundShapeConfig(0.0F, false, false, 31);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(187247);
    }
    
    public BackgroundShapeConfig()
    {
      this(0.0F, false, false, 31);
    }
    
    public BackgroundShapeConfig(float paramFloat, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.bDI = paramFloat;
      this.nZO = paramBoolean1;
      this.nZP = paramBoolean2;
      this.nZQ = paramBoolean3;
      this.nZR = paramBoolean4;
    }
    
    public BackgroundShapeConfig(Parcel paramParcel) {}
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(187262);
      if (this != paramObject)
      {
        if ((paramObject instanceof BackgroundShapeConfig))
        {
          paramObject = (BackgroundShapeConfig)paramObject;
          if ((Float.compare(this.bDI, paramObject.bDI) != 0) || (this.nZO != paramObject.nZO) || (this.nZP != paramObject.nZP) || (this.nZQ != paramObject.nZQ) || (this.nZR != paramObject.nZR)) {}
        }
      }
      else
      {
        AppMethodBeat.o(187262);
        return true;
      }
      AppMethodBeat.o(187262);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(187248);
      String str = "BackgroundShapeConfig(cornerRadius=" + this.bDI + ", topLeft=" + this.nZO + ", topRight=" + this.nZP + ", bottomLeft=" + this.nZQ + ", bottomRight=" + this.nZR + ")";
      AppMethodBeat.o(187248);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(187243);
      p.k(paramParcel, "parcel");
      paramParcel.writeFloat(this.bDI);
      if (this.nZO)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.nZP) {
          break label90;
        }
        b1 = 1;
        label45:
        paramParcel.writeByte(b1);
        if (!this.nZQ) {
          break label95;
        }
        b1 = 1;
        label59:
        paramParcel.writeByte(b1);
        if (!this.nZR) {
          break label100;
        }
      }
      label90:
      label95:
      label100:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(187243);
        return;
        b1 = 0;
        break;
        b1 = 0;
        break label45;
        b1 = 0;
        break label59;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "DUMMY", "data-model_release"})
    public static final class a {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "data-model_release"})
    public static final class b
      implements Parcelable.Creator<HalfScreenConfig.BackgroundShapeConfig>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "activityClassName", "", "closeAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;)V", "getActivityClassName", "()Ljava/lang/String;", "getCloseAnimStyle", "()Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "data-model_release"})
  public static final class CloseWhenClickEmptyAreaConfig
    implements Parcelable
  {
    public static final Parcelable.Creator<CloseWhenClickEmptyAreaConfig> CREATOR;
    public static final CloseWhenClickEmptyAreaConfig oaa;
    public static final a oab;
    public final String nZY;
    public final HalfScreenConfig.a nZZ;
    
    static
    {
      AppMethodBeat.i(186840);
      oab = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      oaa = new CloseWhenClickEmptyAreaConfig("", HalfScreenConfig.a.nZL);
      AppMethodBeat.o(186840);
    }
    
    public CloseWhenClickEmptyAreaConfig(Parcel paramParcel)
    {
      this(str1, HalfScreenConfig.a.valueOf(paramParcel));
      AppMethodBeat.i(186838);
      AppMethodBeat.o(186838);
    }
    
    public CloseWhenClickEmptyAreaConfig(String paramString, HalfScreenConfig.a parama)
    {
      AppMethodBeat.i(186834);
      this.nZY = paramString;
      this.nZZ = parama;
      AppMethodBeat.o(186834);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(186846);
      if (this != paramObject)
      {
        if ((paramObject instanceof CloseWhenClickEmptyAreaConfig))
        {
          paramObject = (CloseWhenClickEmptyAreaConfig)paramObject;
          if ((!p.h(this.nZY, paramObject.nZY)) || (!p.h(this.nZZ, paramObject.nZZ))) {}
        }
      }
      else
      {
        AppMethodBeat.o(186846);
        return true;
      }
      AppMethodBeat.o(186846);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(186843);
      Object localObject = this.nZY;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.nZZ;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(186843);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(186841);
      String str = "CloseWhenClickEmptyAreaConfig(activityClassName=" + this.nZY + ", closeAnimStyle=" + this.nZZ + ")";
      AppMethodBeat.o(186841);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(186830);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.nZY);
      paramParcel.writeString(this.nZZ.name());
      AppMethodBeat.o(186830);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "DUMMY", "EXTRA_START_BY_HALF_SCREEN_EMPTY_AREA_CLICK_SCENE", "", "data-model_release"})
    public static final class a {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "data-model_release"})
    public static final class b
      implements Parcelable.Creator<HalfScreenConfig.CloseWhenClickEmptyAreaConfig>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "", "(Ljava/lang/String;I)V", "POPUP", "SLIDE", "data-model_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(188637);
      a locala1 = new a("POPUP", 0);
      nZL = locala1;
      a locala2 = new a("SLIDE", 1);
      nZM = locala2;
      nZN = new a[] { locala1, locala2 };
      AppMethodBeat.o(188637);
    }
    
    private a() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Builder;", "", "()V", "activityAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "bgShapeConf", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "capsuleType", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CapsuleType;", "closeWhenClickEmptyArea", "", "closeWhenClickEmptyAreaConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "enable", "forceLightMode", "halfScreenStatusChangeListener", "Lcom/tencent/mm/plugin/appbrand/config/WeAppHalfScreenStatusChangeListener;", "height", "", "showHalfScreenCommonHeader", "showHalfScreenCustomHeader", "splashLoadingType", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$SplashLoadingType;", "supportGesture", "build", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "data-model_release"})
  public static final class b
  {
    private boolean enable;
    private int height;
    private boolean nZA;
    private HalfScreenConfig.BackgroundShapeConfig nZB = HalfScreenConfig.BackgroundShapeConfig.nZS;
    private HalfScreenConfig.CloseWhenClickEmptyAreaConfig nZC = HalfScreenConfig.CloseWhenClickEmptyAreaConfig.oaa;
    private HalfScreenConfig.c nZD = HalfScreenConfig.c.nZU;
    private boolean nZE;
    private boolean nZF;
    private WeAppHalfScreenStatusChangeListener nZG;
    private HalfScreenConfig.f nZH = HalfScreenConfig.f.oad;
    private boolean nZI;
    private HalfScreenConfig.a nZz = HalfScreenConfig.a.nZL;
    private boolean nnk;
    
    public final b a(HalfScreenConfig.BackgroundShapeConfig paramBackgroundShapeConfig)
    {
      AppMethodBeat.i(187321);
      p.k(paramBackgroundShapeConfig, "bgShapeConf");
      ((b)this).nZB = paramBackgroundShapeConfig;
      paramBackgroundShapeConfig = (b)this;
      AppMethodBeat.o(187321);
      return paramBackgroundShapeConfig;
    }
    
    public final b a(HalfScreenConfig.CloseWhenClickEmptyAreaConfig paramCloseWhenClickEmptyAreaConfig)
    {
      AppMethodBeat.i(187326);
      p.k(paramCloseWhenClickEmptyAreaConfig, "closeWhenClickEmptyAreaConfig");
      ((b)this).nZC = paramCloseWhenClickEmptyAreaConfig;
      paramCloseWhenClickEmptyAreaConfig = (b)this;
      AppMethodBeat.o(187326);
      return paramCloseWhenClickEmptyAreaConfig;
    }
    
    public final b a(HalfScreenConfig.a parama)
    {
      AppMethodBeat.i(187315);
      p.k(parama, "activityAnimStyle");
      ((b)this).nZz = parama;
      parama = (b)this;
      AppMethodBeat.o(187315);
      return parama;
    }
    
    public final b a(HalfScreenConfig.c paramc)
    {
      AppMethodBeat.i(187327);
      p.k(paramc, "capsuleType");
      ((b)this).nZD = paramc;
      paramc = (b)this;
      AppMethodBeat.o(187327);
      return paramc;
    }
    
    public final b a(HalfScreenConfig.f paramf)
    {
      AppMethodBeat.i(187330);
      p.k(paramf, "splashLoadingType");
      ((b)this).nZH = paramf;
      paramf = (b)this;
      AppMethodBeat.o(187330);
      return paramf;
    }
    
    public final b a(WeAppHalfScreenStatusChangeListener paramWeAppHalfScreenStatusChangeListener)
    {
      ((b)this).nZG = paramWeAppHalfScreenStatusChangeListener;
      return (b)this;
    }
    
    public final HalfScreenConfig bLu()
    {
      AppMethodBeat.i(187333);
      HalfScreenConfig localHalfScreenConfig = new HalfScreenConfig(this.enable, this.height, this.nZz, this.nZA, this.nZB, this.nnk, this.nZC, this.nZD, this.nZE, this.nZF, this.nZG, this.nZH, this.nZI);
      AppMethodBeat.o(187333);
      return localHalfScreenConfig;
    }
    
    public final b hG(boolean paramBoolean)
    {
      ((b)this).enable = paramBoolean;
      return (b)this;
    }
    
    public final b hH(boolean paramBoolean)
    {
      ((b)this).nZA = paramBoolean;
      return (b)this;
    }
    
    public final b hI(boolean paramBoolean)
    {
      ((b)this).nnk = paramBoolean;
      return (b)this;
    }
    
    public final b hJ(boolean paramBoolean)
    {
      ((b)this).nZE = paramBoolean;
      return (b)this;
    }
    
    public final b hK(boolean paramBoolean)
    {
      ((b)this).nZF = paramBoolean;
      return (b)this;
    }
    
    public final b hL(boolean paramBoolean)
    {
      ((b)this).nZI = paramBoolean;
      return (b)this;
    }
    
    public final b zr(int paramInt)
    {
      ((b)this).height = paramInt;
      return (b)this;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CapsuleType;", "", "(Ljava/lang/String;I)V", "NORMAL", "SINGLE_CLOSE", "HIDE", "data-model_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(186989);
      c localc1 = new c("NORMAL", 0);
      nZU = localc1;
      c localc2 = new c("SINGLE_CLOSE", 1);
      nZV = localc2;
      c localc3 = new c("HIDE", 2);
      nZW = localc3;
      nZX = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(186989);
    }
    
    private c() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "DUMMY", "HEIGHT_MATCH_PARENT", "", "TAG", "", "data-model_release"})
  public static final class d {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$SplashLoadingType;", "", "(Ljava/lang/String;I)V", "NORMAL", "FAKE_NATIVE", "data-model_release"})
  public static enum f
  {
    static
    {
      AppMethodBeat.i(190067);
      f localf1 = new f("NORMAL", 0);
      oac = localf1;
      f localf2 = new f("FAKE_NATIVE", 1);
      oad = localf2;
      oae = new f[] { localf1, localf2 };
      AppMethodBeat.o(190067);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.HalfScreenConfig
 * JD-Core Version:    0.7.0.1
 */