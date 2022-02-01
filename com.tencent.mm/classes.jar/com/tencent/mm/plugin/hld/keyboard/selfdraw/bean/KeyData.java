package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;", "", "id", "", "type", "", "drawerType", "mainText", "mainTextSize", "mainTextColor", "floatText", "floatTextSize", "floatTextColor", "imgSrc", "iconWidth", "", "iconHeight", "bgCorner", "bgColor", "shadowColor", "shadowHeight", "initialColor", "pressMaskColor", "width", "height", "leftMargin", "leftPadding", "topMargin", "topPadding", "bottomPadding", "rightMargin", "rightPadding", "clickable", "", "longClickable", "touchFunctionCode", "clickFunctionCode", "longClickFunctionCode", "swipeable", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "getBgCorner", "()Ljava/lang/Float;", "setBgCorner", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getBottomPadding", "setBottomPadding", "getClickFunctionCode", "()Ljava/lang/Integer;", "setClickFunctionCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getClickable", "()Ljava/lang/Boolean;", "setClickable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDrawerType", "setDrawerType", "getFloatText", "setFloatText", "getFloatTextColor", "setFloatTextColor", "getFloatTextSize", "setFloatTextSize", "getHeight", "setHeight", "getIconHeight", "setIconHeight", "getIconWidth", "setIconWidth", "getId", "setId", "getImgSrc", "setImgSrc", "getInitialColor", "setInitialColor", "getLeftMargin", "setLeftMargin", "getLeftPadding", "setLeftPadding", "getLongClickFunctionCode", "setLongClickFunctionCode", "getLongClickable", "setLongClickable", "getMainText", "setMainText", "getMainTextColor", "setMainTextColor", "getMainTextSize", "setMainTextSize", "getPressMaskColor", "setPressMaskColor", "getRightMargin", "setRightMargin", "getRightPadding", "setRightPadding", "getShadowColor", "setShadowColor", "getShadowHeight", "setShadowHeight", "getSwipeable", "setSwipeable", "getTopMargin", "setTopMargin", "getTopPadding", "setTopPadding", "getTouchFunctionCode", "setTouchFunctionCode", "getType", "setType", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;", "equals", "other", "", "hashCode", "toString", "plugin-hld_release"})
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
    AppMethodBeat.i(214509);
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
    AppMethodBeat.o(214509);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(214516);
    Object localObject = super.clone();
    AppMethodBeat.o(214516);
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
    AppMethodBeat.i(214566);
    p.k(paramString1, "id");
    paramString1 = new KeyData(paramString1, paramInteger1, paramString2, paramString3, paramInteger2, paramString4, paramString5, paramInteger3, paramString6, paramString7, paramFloat1, paramFloat2, paramFloat3, paramString8, paramString9, paramFloat4, paramString10, paramString11, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramBoolean1, paramBoolean2, paramInteger4, paramInteger5, paramInteger6, paramBoolean3);
    AppMethodBeat.o(214566);
    return paramString1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(214578);
    if (this != paramObject)
    {
      if ((paramObject instanceof KeyData))
      {
        paramObject = (KeyData)paramObject;
        if ((!p.h(this.id, paramObject.id)) || (!p.h(this.type, paramObject.type)) || (!p.h(this.drawerType, paramObject.drawerType)) || (!p.h(this.mainText, paramObject.mainText)) || (!p.h(this.mainTextSize, paramObject.mainTextSize)) || (!p.h(this.mainTextColor, paramObject.mainTextColor)) || (!p.h(this.floatText, paramObject.floatText)) || (!p.h(this.floatTextSize, paramObject.floatTextSize)) || (!p.h(this.floatTextColor, paramObject.floatTextColor)) || (!p.h(this.imgSrc, paramObject.imgSrc)) || (!p.h(this.iconWidth, paramObject.iconWidth)) || (!p.h(this.iconHeight, paramObject.iconHeight)) || (!p.h(this.bgCorner, paramObject.bgCorner)) || (!p.h(this.bgColor, paramObject.bgColor)) || (!p.h(this.shadowColor, paramObject.shadowColor)) || (!p.h(this.shadowHeight, paramObject.shadowHeight)) || (!p.h(this.initialColor, paramObject.initialColor)) || (!p.h(this.pressMaskColor, paramObject.pressMaskColor)) || (!p.h(this.width, paramObject.width)) || (!p.h(this.height, paramObject.height)) || (!p.h(this.leftMargin, paramObject.leftMargin)) || (!p.h(this.leftPadding, paramObject.leftPadding)) || (!p.h(this.topMargin, paramObject.topMargin)) || (!p.h(this.topPadding, paramObject.topPadding)) || (!p.h(this.bottomPadding, paramObject.bottomPadding)) || (!p.h(this.rightMargin, paramObject.rightMargin)) || (!p.h(this.rightPadding, paramObject.rightPadding)) || (!p.h(this.clickable, paramObject.clickable)) || (!p.h(this.longClickable, paramObject.longClickable)) || (!p.h(this.touchFunctionCode, paramObject.touchFunctionCode)) || (!p.h(this.clickFunctionCode, paramObject.clickFunctionCode)) || (!p.h(this.longClickFunctionCode, paramObject.longClickFunctionCode)) || (!p.h(this.swipeable, paramObject.swipeable))) {}
      }
    }
    else
    {
      AppMethodBeat.o(214578);
      return true;
    }
    AppMethodBeat.o(214578);
    return false;
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
    int i28 = 0;
    AppMethodBeat.i(214576);
    Object localObject = this.id;
    int i;
    int j;
    label43:
    int k;
    label60:
    int m;
    label78:
    int n;
    label96:
    int i1;
    label114:
    int i2;
    label132:
    int i3;
    label150:
    int i4;
    label168:
    int i5;
    label186:
    int i6;
    label204:
    int i7;
    label222:
    int i8;
    label240:
    int i9;
    label258:
    int i10;
    label276:
    int i11;
    label294:
    int i12;
    label312:
    int i13;
    label330:
    int i14;
    label348:
    int i15;
    label366:
    int i16;
    label384:
    int i17;
    label402:
    int i18;
    label420:
    int i19;
    label438:
    int i20;
    label456:
    int i21;
    label474:
    int i22;
    label492:
    int i23;
    label510:
    int i24;
    label528:
    int i25;
    label546:
    int i26;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.type;
      if (localObject == null) {
        break label803;
      }
      j = localObject.hashCode();
      localObject = this.drawerType;
      if (localObject == null) {
        break label808;
      }
      k = localObject.hashCode();
      localObject = this.mainText;
      if (localObject == null) {
        break label813;
      }
      m = localObject.hashCode();
      localObject = this.mainTextSize;
      if (localObject == null) {
        break label819;
      }
      n = localObject.hashCode();
      localObject = this.mainTextColor;
      if (localObject == null) {
        break label825;
      }
      i1 = localObject.hashCode();
      localObject = this.floatText;
      if (localObject == null) {
        break label831;
      }
      i2 = localObject.hashCode();
      localObject = this.floatTextSize;
      if (localObject == null) {
        break label837;
      }
      i3 = localObject.hashCode();
      localObject = this.floatTextColor;
      if (localObject == null) {
        break label843;
      }
      i4 = localObject.hashCode();
      localObject = this.imgSrc;
      if (localObject == null) {
        break label849;
      }
      i5 = localObject.hashCode();
      localObject = this.iconWidth;
      if (localObject == null) {
        break label855;
      }
      i6 = localObject.hashCode();
      localObject = this.iconHeight;
      if (localObject == null) {
        break label861;
      }
      i7 = localObject.hashCode();
      localObject = this.bgCorner;
      if (localObject == null) {
        break label867;
      }
      i8 = localObject.hashCode();
      localObject = this.bgColor;
      if (localObject == null) {
        break label873;
      }
      i9 = localObject.hashCode();
      localObject = this.shadowColor;
      if (localObject == null) {
        break label879;
      }
      i10 = localObject.hashCode();
      localObject = this.shadowHeight;
      if (localObject == null) {
        break label885;
      }
      i11 = localObject.hashCode();
      localObject = this.initialColor;
      if (localObject == null) {
        break label891;
      }
      i12 = localObject.hashCode();
      localObject = this.pressMaskColor;
      if (localObject == null) {
        break label897;
      }
      i13 = localObject.hashCode();
      localObject = this.width;
      if (localObject == null) {
        break label903;
      }
      i14 = localObject.hashCode();
      localObject = this.height;
      if (localObject == null) {
        break label909;
      }
      i15 = localObject.hashCode();
      localObject = this.leftMargin;
      if (localObject == null) {
        break label915;
      }
      i16 = localObject.hashCode();
      localObject = this.leftPadding;
      if (localObject == null) {
        break label921;
      }
      i17 = localObject.hashCode();
      localObject = this.topMargin;
      if (localObject == null) {
        break label927;
      }
      i18 = localObject.hashCode();
      localObject = this.topPadding;
      if (localObject == null) {
        break label933;
      }
      i19 = localObject.hashCode();
      localObject = this.bottomPadding;
      if (localObject == null) {
        break label939;
      }
      i20 = localObject.hashCode();
      localObject = this.rightMargin;
      if (localObject == null) {
        break label945;
      }
      i21 = localObject.hashCode();
      localObject = this.rightPadding;
      if (localObject == null) {
        break label951;
      }
      i22 = localObject.hashCode();
      localObject = this.clickable;
      if (localObject == null) {
        break label957;
      }
      i23 = localObject.hashCode();
      localObject = this.longClickable;
      if (localObject == null) {
        break label963;
      }
      i24 = localObject.hashCode();
      localObject = this.touchFunctionCode;
      if (localObject == null) {
        break label969;
      }
      i25 = localObject.hashCode();
      localObject = this.clickFunctionCode;
      if (localObject == null) {
        break label975;
      }
      i26 = localObject.hashCode();
      label564:
      localObject = this.longClickFunctionCode;
      if (localObject == null) {
        break label981;
      }
    }
    label803:
    label808:
    label813:
    label819:
    label825:
    label831:
    label837:
    label843:
    label849:
    label981:
    for (int i27 = localObject.hashCode();; i27 = 0)
    {
      localObject = this.swipeable;
      if (localObject != null) {
        i28 = localObject.hashCode();
      }
      AppMethodBeat.o(214576);
      return (i27 + (i26 + (i25 + (i24 + (i23 + (i22 + (i21 + (i20 + (i19 + (i18 + (i17 + (i16 + (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i28;
      i = 0;
      break;
      j = 0;
      break label43;
      k = 0;
      break label60;
      m = 0;
      break label78;
      n = 0;
      break label96;
      i1 = 0;
      break label114;
      i2 = 0;
      break label132;
      i3 = 0;
      break label150;
      i4 = 0;
      break label168;
      i5 = 0;
      break label186;
      label855:
      i6 = 0;
      break label204;
      label861:
      i7 = 0;
      break label222;
      label867:
      i8 = 0;
      break label240;
      label873:
      i9 = 0;
      break label258;
      label879:
      i10 = 0;
      break label276;
      label885:
      i11 = 0;
      break label294;
      label891:
      i12 = 0;
      break label312;
      i13 = 0;
      break label330;
      i14 = 0;
      break label348;
      i15 = 0;
      break label366;
      i16 = 0;
      break label384;
      i17 = 0;
      break label402;
      i18 = 0;
      break label420;
      i19 = 0;
      break label438;
      i20 = 0;
      break label456;
      i21 = 0;
      break label474;
      i22 = 0;
      break label492;
      i23 = 0;
      break label510;
      i24 = 0;
      break label528;
      i25 = 0;
      break label546;
      i26 = 0;
      break label564;
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
    AppMethodBeat.i(214428);
    p.k(paramString, "<set-?>");
    this.id = paramString;
    AppMethodBeat.o(214428);
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
    AppMethodBeat.i(214573);
    String str = "KeyData(id=" + this.id + ", type=" + this.type + ", drawerType=" + this.drawerType + ", mainText=" + this.mainText + ", mainTextSize=" + this.mainTextSize + ", mainTextColor=" + this.mainTextColor + ", floatText=" + this.floatText + ", floatTextSize=" + this.floatTextSize + ", floatTextColor=" + this.floatTextColor + ", imgSrc=" + this.imgSrc + ", iconWidth=" + this.iconWidth + ", iconHeight=" + this.iconHeight + ", bgCorner=" + this.bgCorner + ", bgColor=" + this.bgColor + ", shadowColor=" + this.shadowColor + ", shadowHeight=" + this.shadowHeight + ", initialColor=" + this.initialColor + ", pressMaskColor=" + this.pressMaskColor + ", width=" + this.width + ", height=" + this.height + ", leftMargin=" + this.leftMargin + ", leftPadding=" + this.leftPadding + ", topMargin=" + this.topMargin + ", topPadding=" + this.topPadding + ", bottomPadding=" + this.bottomPadding + ", rightMargin=" + this.rightMargin + ", rightPadding=" + this.rightPadding + ", clickable=" + this.clickable + ", longClickable=" + this.longClickable + ", touchFunctionCode=" + this.touchFunctionCode + ", clickFunctionCode=" + this.clickFunctionCode + ", longClickFunctionCode=" + this.longClickFunctionCode + ", swipeable=" + this.swipeable + ")";
    AppMethodBeat.o(214573);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyData
 * JD-Core Version:    0.7.0.1
 */