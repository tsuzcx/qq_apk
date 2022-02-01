package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;", "", "id", "", "type", "", "drawerType", "mainText", "mainTextSize", "mainTextColor", "floatText", "floatTextSize", "floatTextColor", "imgSrc", "iconWidth", "", "iconHeight", "bgCorner", "bgColor", "shadowColor", "shadowHeight", "initialColor", "pressMaskColor", "width", "height", "leftMargin", "leftPadding", "topMargin", "topPadding", "bottomPadding", "rightMargin", "rightPadding", "clickable", "", "longClickable", "touchFunctionCode", "clickFunctionCode", "longClickFunctionCode", "swipeable", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "getBgCorner", "()Ljava/lang/Float;", "setBgCorner", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getBottomPadding", "setBottomPadding", "getClickFunctionCode", "()Ljava/lang/Integer;", "setClickFunctionCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getClickable", "()Ljava/lang/Boolean;", "setClickable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDrawerType", "setDrawerType", "getFloatText", "setFloatText", "getFloatTextColor", "setFloatTextColor", "getFloatTextSize", "setFloatTextSize", "getHeight", "setHeight", "getIconHeight", "setIconHeight", "getIconWidth", "setIconWidth", "getId", "setId", "getImgSrc", "setImgSrc", "getInitialColor", "setInitialColor", "getLeftMargin", "setLeftMargin", "getLeftPadding", "setLeftPadding", "getLongClickFunctionCode", "setLongClickFunctionCode", "getLongClickable", "setLongClickable", "getMainText", "setMainText", "getMainTextColor", "setMainTextColor", "getMainTextSize", "setMainTextSize", "getPressMaskColor", "setPressMaskColor", "getRightMargin", "setRightMargin", "getRightPadding", "setRightPadding", "getShadowColor", "setShadowColor", "getShadowHeight", "setShadowHeight", "getSwipeable", "setSwipeable", "getTopMargin", "setTopMargin", "getTopPadding", "setTopPadding", "getTouchFunctionCode", "setTouchFunctionCode", "getType", "setType", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;", "equals", "other", "", "hashCode", "toString", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KeyData
  implements Cloneable
{
  private String bgColor;
  private Float bgCorner;
  private Float bottomPadding;
  private Integer clickFunctionCode;
  private Boolean clickable;
  private String drawerType;
  private String floatText;
  private String floatTextColor;
  private Integer floatTextSize;
  private Float height;
  private Float iconHeight;
  private Float iconWidth;
  private String id;
  private String imgSrc;
  private String initialColor;
  private Float leftMargin;
  private Float leftPadding;
  private Integer longClickFunctionCode;
  private Boolean longClickable;
  private String mainText;
  private String mainTextColor;
  private Integer mainTextSize;
  private String pressMaskColor;
  private Float rightMargin;
  private Float rightPadding;
  private String shadowColor;
  private Float shadowHeight;
  private Boolean swipeable;
  private Float topMargin;
  private Float topPadding;
  private Integer touchFunctionCode;
  private Integer type;
  private Float width;
  
  public KeyData()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1, null);
  }
  
  public KeyData(String paramString1, Integer paramInteger1, String paramString2, String paramString3, Integer paramInteger2, String paramString4, String paramString5, Integer paramInteger3, String paramString6, String paramString7, Float paramFloat1, Float paramFloat2, Float paramFloat3, String paramString8, String paramString9, Float paramFloat4, String paramString10, String paramString11, Float paramFloat5, Float paramFloat6, Float paramFloat7, Float paramFloat8, Float paramFloat9, Float paramFloat10, Float paramFloat11, Float paramFloat12, Float paramFloat13, Boolean paramBoolean1, Boolean paramBoolean2, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Boolean paramBoolean3)
  {
    AppMethodBeat.i(313150);
    this.id = paramString1;
    this.type = paramInteger1;
    this.drawerType = paramString2;
    this.mainText = paramString3;
    this.mainTextSize = paramInteger2;
    this.mainTextColor = paramString4;
    this.floatText = paramString5;
    this.floatTextSize = paramInteger3;
    this.floatTextColor = paramString6;
    this.imgSrc = paramString7;
    this.iconWidth = paramFloat1;
    this.iconHeight = paramFloat2;
    this.bgCorner = paramFloat3;
    this.bgColor = paramString8;
    this.shadowColor = paramString9;
    this.shadowHeight = paramFloat4;
    this.initialColor = paramString10;
    this.pressMaskColor = paramString11;
    this.width = paramFloat5;
    this.height = paramFloat6;
    this.leftMargin = paramFloat7;
    this.leftPadding = paramFloat8;
    this.topMargin = paramFloat9;
    this.topPadding = paramFloat10;
    this.bottomPadding = paramFloat11;
    this.rightMargin = paramFloat12;
    this.rightPadding = paramFloat13;
    this.clickable = paramBoolean1;
    this.longClickable = paramBoolean2;
    this.touchFunctionCode = paramInteger4;
    this.clickFunctionCode = paramInteger5;
    this.longClickFunctionCode = paramInteger6;
    this.swipeable = paramBoolean3;
    AppMethodBeat.o(313150);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(313407);
    Object localObject = super.clone();
    AppMethodBeat.o(313407);
    return localObject;
  }
  
  public final String component1()
  {
    return this.id;
  }
  
  public final String component10()
  {
    return this.imgSrc;
  }
  
  public final Float component11()
  {
    return this.iconWidth;
  }
  
  public final Float component12()
  {
    return this.iconHeight;
  }
  
  public final Float component13()
  {
    return this.bgCorner;
  }
  
  public final String component14()
  {
    return this.bgColor;
  }
  
  public final String component15()
  {
    return this.shadowColor;
  }
  
  public final Float component16()
  {
    return this.shadowHeight;
  }
  
  public final String component17()
  {
    return this.initialColor;
  }
  
  public final String component18()
  {
    return this.pressMaskColor;
  }
  
  public final Float component19()
  {
    return this.width;
  }
  
  public final Integer component2()
  {
    return this.type;
  }
  
  public final Float component20()
  {
    return this.height;
  }
  
  public final Float component21()
  {
    return this.leftMargin;
  }
  
  public final Float component22()
  {
    return this.leftPadding;
  }
  
  public final Float component23()
  {
    return this.topMargin;
  }
  
  public final Float component24()
  {
    return this.topPadding;
  }
  
  public final Float component25()
  {
    return this.bottomPadding;
  }
  
  public final Float component26()
  {
    return this.rightMargin;
  }
  
  public final Float component27()
  {
    return this.rightPadding;
  }
  
  public final Boolean component28()
  {
    return this.clickable;
  }
  
  public final Boolean component29()
  {
    return this.longClickable;
  }
  
  public final String component3()
  {
    return this.drawerType;
  }
  
  public final Integer component30()
  {
    return this.touchFunctionCode;
  }
  
  public final Integer component31()
  {
    return this.clickFunctionCode;
  }
  
  public final Integer component32()
  {
    return this.longClickFunctionCode;
  }
  
  public final Boolean component33()
  {
    return this.swipeable;
  }
  
  public final String component4()
  {
    return this.mainText;
  }
  
  public final Integer component5()
  {
    return this.mainTextSize;
  }
  
  public final String component6()
  {
    return this.mainTextColor;
  }
  
  public final String component7()
  {
    return this.floatText;
  }
  
  public final Integer component8()
  {
    return this.floatTextSize;
  }
  
  public final String component9()
  {
    return this.floatTextColor;
  }
  
  public final KeyData copy(String paramString1, Integer paramInteger1, String paramString2, String paramString3, Integer paramInteger2, String paramString4, String paramString5, Integer paramInteger3, String paramString6, String paramString7, Float paramFloat1, Float paramFloat2, Float paramFloat3, String paramString8, String paramString9, Float paramFloat4, String paramString10, String paramString11, Float paramFloat5, Float paramFloat6, Float paramFloat7, Float paramFloat8, Float paramFloat9, Float paramFloat10, Float paramFloat11, Float paramFloat12, Float paramFloat13, Boolean paramBoolean1, Boolean paramBoolean2, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Boolean paramBoolean3)
  {
    AppMethodBeat.i(313528);
    s.u(paramString1, "id");
    paramString1 = new KeyData(paramString1, paramInteger1, paramString2, paramString3, paramInteger2, paramString4, paramString5, paramInteger3, paramString6, paramString7, paramFloat1, paramFloat2, paramFloat3, paramString8, paramString9, paramFloat4, paramString10, paramString11, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramBoolean1, paramBoolean2, paramInteger4, paramInteger5, paramInteger6, paramBoolean3);
    AppMethodBeat.o(313528);
    return paramString1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(313551);
    if (this == paramObject)
    {
      AppMethodBeat.o(313551);
      return true;
    }
    if (!(paramObject instanceof KeyData))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    paramObject = (KeyData)paramObject;
    if (!s.p(this.id, paramObject.id))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.type, paramObject.type))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.drawerType, paramObject.drawerType))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.mainText, paramObject.mainText))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.mainTextSize, paramObject.mainTextSize))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.mainTextColor, paramObject.mainTextColor))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.floatText, paramObject.floatText))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.floatTextSize, paramObject.floatTextSize))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.floatTextColor, paramObject.floatTextColor))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.imgSrc, paramObject.imgSrc))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.iconWidth, paramObject.iconWidth))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.iconHeight, paramObject.iconHeight))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.bgCorner, paramObject.bgCorner))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.bgColor, paramObject.bgColor))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.shadowColor, paramObject.shadowColor))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.shadowHeight, paramObject.shadowHeight))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.initialColor, paramObject.initialColor))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.pressMaskColor, paramObject.pressMaskColor))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.width, paramObject.width))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.height, paramObject.height))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.leftMargin, paramObject.leftMargin))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.leftPadding, paramObject.leftPadding))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.topMargin, paramObject.topMargin))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.topPadding, paramObject.topPadding))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.bottomPadding, paramObject.bottomPadding))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.rightMargin, paramObject.rightMargin))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.rightPadding, paramObject.rightPadding))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.clickable, paramObject.clickable))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.longClickable, paramObject.longClickable))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.touchFunctionCode, paramObject.touchFunctionCode))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.clickFunctionCode, paramObject.clickFunctionCode))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.longClickFunctionCode, paramObject.longClickFunctionCode))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    if (!s.p(this.swipeable, paramObject.swipeable))
    {
      AppMethodBeat.o(313551);
      return false;
    }
    AppMethodBeat.o(313551);
    return true;
  }
  
  public final String getBgColor()
  {
    return this.bgColor;
  }
  
  public final Float getBgCorner()
  {
    return this.bgCorner;
  }
  
  public final Float getBottomPadding()
  {
    return this.bottomPadding;
  }
  
  public final Integer getClickFunctionCode()
  {
    return this.clickFunctionCode;
  }
  
  public final Boolean getClickable()
  {
    return this.clickable;
  }
  
  public final String getDrawerType()
  {
    return this.drawerType;
  }
  
  public final String getFloatText()
  {
    return this.floatText;
  }
  
  public final String getFloatTextColor()
  {
    return this.floatTextColor;
  }
  
  public final Integer getFloatTextSize()
  {
    return this.floatTextSize;
  }
  
  public final Float getHeight()
  {
    return this.height;
  }
  
  public final Float getIconHeight()
  {
    return this.iconHeight;
  }
  
  public final Float getIconWidth()
  {
    return this.iconWidth;
  }
  
  public final String getId()
  {
    return this.id;
  }
  
  public final String getImgSrc()
  {
    return this.imgSrc;
  }
  
  public final String getInitialColor()
  {
    return this.initialColor;
  }
  
  public final Float getLeftMargin()
  {
    return this.leftMargin;
  }
  
  public final Float getLeftPadding()
  {
    return this.leftPadding;
  }
  
  public final Integer getLongClickFunctionCode()
  {
    return this.longClickFunctionCode;
  }
  
  public final Boolean getLongClickable()
  {
    return this.longClickable;
  }
  
  public final String getMainText()
  {
    return this.mainText;
  }
  
  public final String getMainTextColor()
  {
    return this.mainTextColor;
  }
  
  public final Integer getMainTextSize()
  {
    return this.mainTextSize;
  }
  
  public final String getPressMaskColor()
  {
    return this.pressMaskColor;
  }
  
  public final Float getRightMargin()
  {
    return this.rightMargin;
  }
  
  public final Float getRightPadding()
  {
    return this.rightPadding;
  }
  
  public final String getShadowColor()
  {
    return this.shadowColor;
  }
  
  public final Float getShadowHeight()
  {
    return this.shadowHeight;
  }
  
  public final Boolean getSwipeable()
  {
    return this.swipeable;
  }
  
  public final Float getTopMargin()
  {
    return this.topMargin;
  }
  
  public final Float getTopPadding()
  {
    return this.topPadding;
  }
  
  public final Integer getTouchFunctionCode()
  {
    return this.touchFunctionCode;
  }
  
  public final Integer getType()
  {
    return this.type;
  }
  
  public final Float getWidth()
  {
    return this.width;
  }
  
  public final int hashCode()
  {
    int i27 = 0;
    AppMethodBeat.i(313543);
    int i28 = this.id.hashCode();
    int i;
    int j;
    label36:
    int k;
    label45:
    int m;
    label55:
    int n;
    label65:
    int i1;
    label75:
    int i2;
    label85:
    int i3;
    label95:
    int i4;
    label105:
    int i5;
    label115:
    int i6;
    label125:
    int i7;
    label135:
    int i8;
    label145:
    int i9;
    label155:
    int i10;
    label165:
    int i11;
    label175:
    int i12;
    label185:
    int i13;
    label195:
    int i14;
    label205:
    int i15;
    label215:
    int i16;
    label225:
    int i17;
    label235:
    int i18;
    label245:
    int i19;
    label255:
    int i20;
    label265:
    int i21;
    label275:
    int i22;
    label285:
    int i23;
    label295:
    int i24;
    label305:
    int i25;
    label315:
    int i26;
    if (this.type == null)
    {
      i = 0;
      if (this.drawerType != null) {
        break label541;
      }
      j = 0;
      if (this.mainText != null) {
        break label552;
      }
      k = 0;
      if (this.mainTextSize != null) {
        break label563;
      }
      m = 0;
      if (this.mainTextColor != null) {
        break label575;
      }
      n = 0;
      if (this.floatText != null) {
        break label587;
      }
      i1 = 0;
      if (this.floatTextSize != null) {
        break label599;
      }
      i2 = 0;
      if (this.floatTextColor != null) {
        break label611;
      }
      i3 = 0;
      if (this.imgSrc != null) {
        break label623;
      }
      i4 = 0;
      if (this.iconWidth != null) {
        break label635;
      }
      i5 = 0;
      if (this.iconHeight != null) {
        break label647;
      }
      i6 = 0;
      if (this.bgCorner != null) {
        break label659;
      }
      i7 = 0;
      if (this.bgColor != null) {
        break label671;
      }
      i8 = 0;
      if (this.shadowColor != null) {
        break label683;
      }
      i9 = 0;
      if (this.shadowHeight != null) {
        break label695;
      }
      i10 = 0;
      if (this.initialColor != null) {
        break label707;
      }
      i11 = 0;
      if (this.pressMaskColor != null) {
        break label719;
      }
      i12 = 0;
      if (this.width != null) {
        break label731;
      }
      i13 = 0;
      if (this.height != null) {
        break label743;
      }
      i14 = 0;
      if (this.leftMargin != null) {
        break label755;
      }
      i15 = 0;
      if (this.leftPadding != null) {
        break label767;
      }
      i16 = 0;
      if (this.topMargin != null) {
        break label779;
      }
      i17 = 0;
      if (this.topPadding != null) {
        break label791;
      }
      i18 = 0;
      if (this.bottomPadding != null) {
        break label803;
      }
      i19 = 0;
      if (this.rightMargin != null) {
        break label815;
      }
      i20 = 0;
      if (this.rightPadding != null) {
        break label827;
      }
      i21 = 0;
      if (this.clickable != null) {
        break label839;
      }
      i22 = 0;
      if (this.longClickable != null) {
        break label851;
      }
      i23 = 0;
      if (this.touchFunctionCode != null) {
        break label863;
      }
      i24 = 0;
      if (this.clickFunctionCode != null) {
        break label875;
      }
      i25 = 0;
      if (this.longClickFunctionCode != null) {
        break label887;
      }
      i26 = 0;
      label325:
      if (this.swipeable != null) {
        break label899;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(313543);
      return (i26 + (i25 + (i24 + (i23 + (i22 + (i21 + (i20 + (i19 + (i18 + (i17 + (i16 + (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + i28 * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i27;
      i = this.type.hashCode();
      break;
      label541:
      j = this.drawerType.hashCode();
      break label36;
      label552:
      k = this.mainText.hashCode();
      break label45;
      label563:
      m = this.mainTextSize.hashCode();
      break label55;
      label575:
      n = this.mainTextColor.hashCode();
      break label65;
      label587:
      i1 = this.floatText.hashCode();
      break label75;
      label599:
      i2 = this.floatTextSize.hashCode();
      break label85;
      label611:
      i3 = this.floatTextColor.hashCode();
      break label95;
      label623:
      i4 = this.imgSrc.hashCode();
      break label105;
      label635:
      i5 = this.iconWidth.hashCode();
      break label115;
      label647:
      i6 = this.iconHeight.hashCode();
      break label125;
      label659:
      i7 = this.bgCorner.hashCode();
      break label135;
      label671:
      i8 = this.bgColor.hashCode();
      break label145;
      label683:
      i9 = this.shadowColor.hashCode();
      break label155;
      label695:
      i10 = this.shadowHeight.hashCode();
      break label165;
      label707:
      i11 = this.initialColor.hashCode();
      break label175;
      label719:
      i12 = this.pressMaskColor.hashCode();
      break label185;
      label731:
      i13 = this.width.hashCode();
      break label195;
      label743:
      i14 = this.height.hashCode();
      break label205;
      label755:
      i15 = this.leftMargin.hashCode();
      break label215;
      label767:
      i16 = this.leftPadding.hashCode();
      break label225;
      label779:
      i17 = this.topMargin.hashCode();
      break label235;
      label791:
      i18 = this.topPadding.hashCode();
      break label245;
      label803:
      i19 = this.bottomPadding.hashCode();
      break label255;
      label815:
      i20 = this.rightMargin.hashCode();
      break label265;
      label827:
      i21 = this.rightPadding.hashCode();
      break label275;
      label839:
      i22 = this.clickable.hashCode();
      break label285;
      label851:
      i23 = this.longClickable.hashCode();
      break label295;
      label863:
      i24 = this.touchFunctionCode.hashCode();
      break label305;
      label875:
      i25 = this.clickFunctionCode.hashCode();
      break label315;
      label887:
      i26 = this.longClickFunctionCode.hashCode();
      break label325;
      label899:
      i27 = this.swipeable.hashCode();
    }
  }
  
  public final void setBgColor(String paramString)
  {
    this.bgColor = paramString;
  }
  
  public final void setBgCorner(Float paramFloat)
  {
    this.bgCorner = paramFloat;
  }
  
  public final void setBottomPadding(Float paramFloat)
  {
    this.bottomPadding = paramFloat;
  }
  
  public final void setClickFunctionCode(Integer paramInteger)
  {
    this.clickFunctionCode = paramInteger;
  }
  
  public final void setClickable(Boolean paramBoolean)
  {
    this.clickable = paramBoolean;
  }
  
  public final void setDrawerType(String paramString)
  {
    this.drawerType = paramString;
  }
  
  public final void setFloatText(String paramString)
  {
    this.floatText = paramString;
  }
  
  public final void setFloatTextColor(String paramString)
  {
    this.floatTextColor = paramString;
  }
  
  public final void setFloatTextSize(Integer paramInteger)
  {
    this.floatTextSize = paramInteger;
  }
  
  public final void setHeight(Float paramFloat)
  {
    this.height = paramFloat;
  }
  
  public final void setIconHeight(Float paramFloat)
  {
    this.iconHeight = paramFloat;
  }
  
  public final void setIconWidth(Float paramFloat)
  {
    this.iconWidth = paramFloat;
  }
  
  public final void setId(String paramString)
  {
    AppMethodBeat.i(313190);
    s.u(paramString, "<set-?>");
    this.id = paramString;
    AppMethodBeat.o(313190);
  }
  
  public final void setImgSrc(String paramString)
  {
    this.imgSrc = paramString;
  }
  
  public final void setInitialColor(String paramString)
  {
    this.initialColor = paramString;
  }
  
  public final void setLeftMargin(Float paramFloat)
  {
    this.leftMargin = paramFloat;
  }
  
  public final void setLeftPadding(Float paramFloat)
  {
    this.leftPadding = paramFloat;
  }
  
  public final void setLongClickFunctionCode(Integer paramInteger)
  {
    this.longClickFunctionCode = paramInteger;
  }
  
  public final void setLongClickable(Boolean paramBoolean)
  {
    this.longClickable = paramBoolean;
  }
  
  public final void setMainText(String paramString)
  {
    this.mainText = paramString;
  }
  
  public final void setMainTextColor(String paramString)
  {
    this.mainTextColor = paramString;
  }
  
  public final void setMainTextSize(Integer paramInteger)
  {
    this.mainTextSize = paramInteger;
  }
  
  public final void setPressMaskColor(String paramString)
  {
    this.pressMaskColor = paramString;
  }
  
  public final void setRightMargin(Float paramFloat)
  {
    this.rightMargin = paramFloat;
  }
  
  public final void setRightPadding(Float paramFloat)
  {
    this.rightPadding = paramFloat;
  }
  
  public final void setShadowColor(String paramString)
  {
    this.shadowColor = paramString;
  }
  
  public final void setShadowHeight(Float paramFloat)
  {
    this.shadowHeight = paramFloat;
  }
  
  public final void setSwipeable(Boolean paramBoolean)
  {
    this.swipeable = paramBoolean;
  }
  
  public final void setTopMargin(Float paramFloat)
  {
    this.topMargin = paramFloat;
  }
  
  public final void setTopPadding(Float paramFloat)
  {
    this.topPadding = paramFloat;
  }
  
  public final void setTouchFunctionCode(Integer paramInteger)
  {
    this.touchFunctionCode = paramInteger;
  }
  
  public final void setType(Integer paramInteger)
  {
    this.type = paramInteger;
  }
  
  public final void setWidth(Float paramFloat)
  {
    this.width = paramFloat;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(313535);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("KeyData(id=").append(this.id).append(", type=").append(this.type).append(", drawerType=").append(this.drawerType).append(", mainText=").append(this.mainText).append(", mainTextSize=").append(this.mainTextSize).append(", mainTextColor=").append(this.mainTextColor).append(", floatText=").append(this.floatText).append(", floatTextSize=").append(this.floatTextSize).append(", floatTextColor=").append(this.floatTextColor).append(", imgSrc=").append(this.imgSrc).append(", iconWidth=").append(this.iconWidth).append(", iconHeight=");
    ((StringBuilder)localObject).append(this.iconHeight).append(", bgCorner=").append(this.bgCorner).append(", bgColor=").append(this.bgColor).append(", shadowColor=").append(this.shadowColor).append(", shadowHeight=").append(this.shadowHeight).append(", initialColor=").append(this.initialColor).append(", pressMaskColor=").append(this.pressMaskColor).append(", width=").append(this.width).append(", height=").append(this.height).append(", leftMargin=").append(this.leftMargin).append(", leftPadding=").append(this.leftPadding).append(", topMargin=").append(this.topMargin);
    ((StringBuilder)localObject).append(", topPadding=").append(this.topPadding).append(", bottomPadding=").append(this.bottomPadding).append(", rightMargin=").append(this.rightMargin).append(", rightPadding=").append(this.rightPadding).append(", clickable=").append(this.clickable).append(", longClickable=").append(this.longClickable).append(", touchFunctionCode=").append(this.touchFunctionCode).append(", clickFunctionCode=").append(this.clickFunctionCode).append(", longClickFunctionCode=").append(this.longClickFunctionCode).append(", swipeable=").append(this.swipeable).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(313535);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyData
 * JD-Core Version:    0.7.0.1
 */