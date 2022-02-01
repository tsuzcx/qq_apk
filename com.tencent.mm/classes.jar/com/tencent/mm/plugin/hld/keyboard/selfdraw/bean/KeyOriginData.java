package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyOriginData;", "", "id", "", "", "type", "", "drawerType", "mainText", "mainTextSize", "mainTextColor", "floatText", "floatTextSize", "floatTextColor", "imgSrc", "iconWidth", "", "iconHeight", "bgCorner", "bgColor", "shadowColor", "shadowHeight", "initialColor", "pressMaskColor", "width", "height", "leftMargin", "leftPadding", "topMargin", "topPadding", "bottomPadding", "rightMargin", "rightPadding", "clickable", "", "longClickable", "touchFunctionCode", "clickFunctionCode", "longClickFunctionCode", "swipeable", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBgColor", "()Ljava/util/List;", "setBgColor", "(Ljava/util/List;)V", "getBgCorner", "setBgCorner", "getBottomPadding", "setBottomPadding", "getClickFunctionCode", "setClickFunctionCode", "getClickable", "setClickable", "getDrawerType", "setDrawerType", "getFloatText", "setFloatText", "getFloatTextColor", "setFloatTextColor", "getFloatTextSize", "setFloatTextSize", "getHeight", "setHeight", "getIconHeight", "setIconHeight", "getIconWidth", "setIconWidth", "getId", "setId", "getImgSrc", "setImgSrc", "getInitialColor", "setInitialColor", "getLeftMargin", "setLeftMargin", "getLeftPadding", "setLeftPadding", "getLongClickFunctionCode", "setLongClickFunctionCode", "getLongClickable", "setLongClickable", "getMainText", "setMainText", "getMainTextColor", "setMainTextColor", "getMainTextSize", "setMainTextSize", "getPressMaskColor", "setPressMaskColor", "getRightMargin", "setRightMargin", "getRightPadding", "setRightPadding", "getShadowColor", "setShadowColor", "getShadowHeight", "setShadowHeight", "getSwipeable", "setSwipeable", "getTopMargin", "setTopMargin", "getTopPadding", "setTopPadding", "getTouchFunctionCode", "setTouchFunctionCode", "getType", "setType", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-hld_release"})
public final class KeyOriginData
{
  private List<String> bgColor;
  private List<Float> bgCorner;
  private List<Float> bottomPadding;
  private List<Integer> clickFunctionCode;
  private List<Boolean> clickable;
  private List<String> drawerType;
  private List<String> floatText;
  private List<String> floatTextColor;
  private List<Integer> floatTextSize;
  private List<Float> height;
  private List<Float> iconHeight;
  private List<Float> iconWidth;
  private List<String> id;
  private List<String> imgSrc;
  private List<String> initialColor;
  private List<Float> leftMargin;
  private List<Float> leftPadding;
  private List<Integer> longClickFunctionCode;
  private List<Boolean> longClickable;
  private List<String> mainText;
  private List<String> mainTextColor;
  private List<Integer> mainTextSize;
  private List<String> pressMaskColor;
  private List<Float> rightMargin;
  private List<Float> rightPadding;
  private List<String> shadowColor;
  private List<Float> shadowHeight;
  private List<Boolean> swipeable;
  private List<Float> topMargin;
  private List<Float> topPadding;
  private List<Integer> touchFunctionCode;
  private List<Integer> type;
  private List<Float> width;
  
  public KeyOriginData()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1, null);
  }
  
  public KeyOriginData(List<String> paramList1, List<Integer> paramList2, List<String> paramList3, List<String> paramList4, List<Integer> paramList5, List<String> paramList6, List<String> paramList7, List<Integer> paramList8, List<String> paramList9, List<String> paramList10, List<Float> paramList11, List<Float> paramList12, List<Float> paramList13, List<String> paramList14, List<String> paramList15, List<Float> paramList16, List<String> paramList17, List<String> paramList18, List<Float> paramList19, List<Float> paramList20, List<Float> paramList21, List<Float> paramList22, List<Float> paramList23, List<Float> paramList24, List<Float> paramList25, List<Float> paramList26, List<Float> paramList27, List<Boolean> paramList28, List<Boolean> paramList29, List<Integer> paramList30, List<Integer> paramList31, List<Integer> paramList32, List<Boolean> paramList33)
  {
    this.id = paramList1;
    this.type = paramList2;
    this.drawerType = paramList3;
    this.mainText = paramList4;
    this.mainTextSize = paramList5;
    this.mainTextColor = paramList6;
    this.floatText = paramList7;
    this.floatTextSize = paramList8;
    this.floatTextColor = paramList9;
    this.imgSrc = paramList10;
    this.iconWidth = paramList11;
    this.iconHeight = paramList12;
    this.bgCorner = paramList13;
    this.bgColor = paramList14;
    this.shadowColor = paramList15;
    this.shadowHeight = paramList16;
    this.initialColor = paramList17;
    this.pressMaskColor = paramList18;
    this.width = paramList19;
    this.height = paramList20;
    this.leftMargin = paramList21;
    this.leftPadding = paramList22;
    this.topMargin = paramList23;
    this.topPadding = paramList24;
    this.bottomPadding = paramList25;
    this.rightMargin = paramList26;
    this.rightPadding = paramList27;
    this.clickable = paramList28;
    this.longClickable = paramList29;
    this.touchFunctionCode = paramList30;
    this.clickFunctionCode = paramList31;
    this.longClickFunctionCode = paramList32;
    this.swipeable = paramList33;
  }
  
  public final List<String> component1()
  {
    return this.id;
  }
  
  public final List<String> component10()
  {
    return this.imgSrc;
  }
  
  public final List<Float> component11()
  {
    return this.iconWidth;
  }
  
  public final List<Float> component12()
  {
    return this.iconHeight;
  }
  
  public final List<Float> component13()
  {
    return this.bgCorner;
  }
  
  public final List<String> component14()
  {
    return this.bgColor;
  }
  
  public final List<String> component15()
  {
    return this.shadowColor;
  }
  
  public final List<Float> component16()
  {
    return this.shadowHeight;
  }
  
  public final List<String> component17()
  {
    return this.initialColor;
  }
  
  public final List<String> component18()
  {
    return this.pressMaskColor;
  }
  
  public final List<Float> component19()
  {
    return this.width;
  }
  
  public final List<Integer> component2()
  {
    return this.type;
  }
  
  public final List<Float> component20()
  {
    return this.height;
  }
  
  public final List<Float> component21()
  {
    return this.leftMargin;
  }
  
  public final List<Float> component22()
  {
    return this.leftPadding;
  }
  
  public final List<Float> component23()
  {
    return this.topMargin;
  }
  
  public final List<Float> component24()
  {
    return this.topPadding;
  }
  
  public final List<Float> component25()
  {
    return this.bottomPadding;
  }
  
  public final List<Float> component26()
  {
    return this.rightMargin;
  }
  
  public final List<Float> component27()
  {
    return this.rightPadding;
  }
  
  public final List<Boolean> component28()
  {
    return this.clickable;
  }
  
  public final List<Boolean> component29()
  {
    return this.longClickable;
  }
  
  public final List<String> component3()
  {
    return this.drawerType;
  }
  
  public final List<Integer> component30()
  {
    return this.touchFunctionCode;
  }
  
  public final List<Integer> component31()
  {
    return this.clickFunctionCode;
  }
  
  public final List<Integer> component32()
  {
    return this.longClickFunctionCode;
  }
  
  public final List<Boolean> component33()
  {
    return this.swipeable;
  }
  
  public final List<String> component4()
  {
    return this.mainText;
  }
  
  public final List<Integer> component5()
  {
    return this.mainTextSize;
  }
  
  public final List<String> component6()
  {
    return this.mainTextColor;
  }
  
  public final List<String> component7()
  {
    return this.floatText;
  }
  
  public final List<Integer> component8()
  {
    return this.floatTextSize;
  }
  
  public final List<String> component9()
  {
    return this.floatTextColor;
  }
  
  public final KeyOriginData copy(List<String> paramList1, List<Integer> paramList2, List<String> paramList3, List<String> paramList4, List<Integer> paramList5, List<String> paramList6, List<String> paramList7, List<Integer> paramList8, List<String> paramList9, List<String> paramList10, List<Float> paramList11, List<Float> paramList12, List<Float> paramList13, List<String> paramList14, List<String> paramList15, List<Float> paramList16, List<String> paramList17, List<String> paramList18, List<Float> paramList19, List<Float> paramList20, List<Float> paramList21, List<Float> paramList22, List<Float> paramList23, List<Float> paramList24, List<Float> paramList25, List<Float> paramList26, List<Float> paramList27, List<Boolean> paramList28, List<Boolean> paramList29, List<Integer> paramList30, List<Integer> paramList31, List<Integer> paramList32, List<Boolean> paramList33)
  {
    AppMethodBeat.i(212547);
    paramList1 = new KeyOriginData(paramList1, paramList2, paramList3, paramList4, paramList5, paramList6, paramList7, paramList8, paramList9, paramList10, paramList11, paramList12, paramList13, paramList14, paramList15, paramList16, paramList17, paramList18, paramList19, paramList20, paramList21, paramList22, paramList23, paramList24, paramList25, paramList26, paramList27, paramList28, paramList29, paramList30, paramList31, paramList32, paramList33);
    AppMethodBeat.o(212547);
    return paramList1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(212552);
    if (this != paramObject)
    {
      if ((paramObject instanceof KeyOriginData))
      {
        paramObject = (KeyOriginData)paramObject;
        if ((!p.h(this.id, paramObject.id)) || (!p.h(this.type, paramObject.type)) || (!p.h(this.drawerType, paramObject.drawerType)) || (!p.h(this.mainText, paramObject.mainText)) || (!p.h(this.mainTextSize, paramObject.mainTextSize)) || (!p.h(this.mainTextColor, paramObject.mainTextColor)) || (!p.h(this.floatText, paramObject.floatText)) || (!p.h(this.floatTextSize, paramObject.floatTextSize)) || (!p.h(this.floatTextColor, paramObject.floatTextColor)) || (!p.h(this.imgSrc, paramObject.imgSrc)) || (!p.h(this.iconWidth, paramObject.iconWidth)) || (!p.h(this.iconHeight, paramObject.iconHeight)) || (!p.h(this.bgCorner, paramObject.bgCorner)) || (!p.h(this.bgColor, paramObject.bgColor)) || (!p.h(this.shadowColor, paramObject.shadowColor)) || (!p.h(this.shadowHeight, paramObject.shadowHeight)) || (!p.h(this.initialColor, paramObject.initialColor)) || (!p.h(this.pressMaskColor, paramObject.pressMaskColor)) || (!p.h(this.width, paramObject.width)) || (!p.h(this.height, paramObject.height)) || (!p.h(this.leftMargin, paramObject.leftMargin)) || (!p.h(this.leftPadding, paramObject.leftPadding)) || (!p.h(this.topMargin, paramObject.topMargin)) || (!p.h(this.topPadding, paramObject.topPadding)) || (!p.h(this.bottomPadding, paramObject.bottomPadding)) || (!p.h(this.rightMargin, paramObject.rightMargin)) || (!p.h(this.rightPadding, paramObject.rightPadding)) || (!p.h(this.clickable, paramObject.clickable)) || (!p.h(this.longClickable, paramObject.longClickable)) || (!p.h(this.touchFunctionCode, paramObject.touchFunctionCode)) || (!p.h(this.clickFunctionCode, paramObject.clickFunctionCode)) || (!p.h(this.longClickFunctionCode, paramObject.longClickFunctionCode)) || (!p.h(this.swipeable, paramObject.swipeable))) {}
      }
    }
    else
    {
      AppMethodBeat.o(212552);
      return true;
    }
    AppMethodBeat.o(212552);
    return false;
  }
  
  public final List<String> getBgColor()
  {
    return this.bgColor;
  }
  
  public final List<Float> getBgCorner()
  {
    return this.bgCorner;
  }
  
  public final List<Float> getBottomPadding()
  {
    return this.bottomPadding;
  }
  
  public final List<Integer> getClickFunctionCode()
  {
    return this.clickFunctionCode;
  }
  
  public final List<Boolean> getClickable()
  {
    return this.clickable;
  }
  
  public final List<String> getDrawerType()
  {
    return this.drawerType;
  }
  
  public final List<String> getFloatText()
  {
    return this.floatText;
  }
  
  public final List<String> getFloatTextColor()
  {
    return this.floatTextColor;
  }
  
  public final List<Integer> getFloatTextSize()
  {
    return this.floatTextSize;
  }
  
  public final List<Float> getHeight()
  {
    return this.height;
  }
  
  public final List<Float> getIconHeight()
  {
    return this.iconHeight;
  }
  
  public final List<Float> getIconWidth()
  {
    return this.iconWidth;
  }
  
  public final List<String> getId()
  {
    return this.id;
  }
  
  public final List<String> getImgSrc()
  {
    return this.imgSrc;
  }
  
  public final List<String> getInitialColor()
  {
    return this.initialColor;
  }
  
  public final List<Float> getLeftMargin()
  {
    return this.leftMargin;
  }
  
  public final List<Float> getLeftPadding()
  {
    return this.leftPadding;
  }
  
  public final List<Integer> getLongClickFunctionCode()
  {
    return this.longClickFunctionCode;
  }
  
  public final List<Boolean> getLongClickable()
  {
    return this.longClickable;
  }
  
  public final List<String> getMainText()
  {
    return this.mainText;
  }
  
  public final List<String> getMainTextColor()
  {
    return this.mainTextColor;
  }
  
  public final List<Integer> getMainTextSize()
  {
    return this.mainTextSize;
  }
  
  public final List<String> getPressMaskColor()
  {
    return this.pressMaskColor;
  }
  
  public final List<Float> getRightMargin()
  {
    return this.rightMargin;
  }
  
  public final List<Float> getRightPadding()
  {
    return this.rightPadding;
  }
  
  public final List<String> getShadowColor()
  {
    return this.shadowColor;
  }
  
  public final List<Float> getShadowHeight()
  {
    return this.shadowHeight;
  }
  
  public final List<Boolean> getSwipeable()
  {
    return this.swipeable;
  }
  
  public final List<Float> getTopMargin()
  {
    return this.topMargin;
  }
  
  public final List<Float> getTopPadding()
  {
    return this.topPadding;
  }
  
  public final List<Integer> getTouchFunctionCode()
  {
    return this.touchFunctionCode;
  }
  
  public final List<Integer> getType()
  {
    return this.type;
  }
  
  public final List<Float> getWidth()
  {
    return this.width;
  }
  
  public final int hashCode()
  {
    int i28 = 0;
    AppMethodBeat.i(212550);
    List localList = this.id;
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
    if (localList != null)
    {
      i = localList.hashCode();
      localList = this.type;
      if (localList == null) {
        break label803;
      }
      j = localList.hashCode();
      localList = this.drawerType;
      if (localList == null) {
        break label808;
      }
      k = localList.hashCode();
      localList = this.mainText;
      if (localList == null) {
        break label813;
      }
      m = localList.hashCode();
      localList = this.mainTextSize;
      if (localList == null) {
        break label819;
      }
      n = localList.hashCode();
      localList = this.mainTextColor;
      if (localList == null) {
        break label825;
      }
      i1 = localList.hashCode();
      localList = this.floatText;
      if (localList == null) {
        break label831;
      }
      i2 = localList.hashCode();
      localList = this.floatTextSize;
      if (localList == null) {
        break label837;
      }
      i3 = localList.hashCode();
      localList = this.floatTextColor;
      if (localList == null) {
        break label843;
      }
      i4 = localList.hashCode();
      localList = this.imgSrc;
      if (localList == null) {
        break label849;
      }
      i5 = localList.hashCode();
      localList = this.iconWidth;
      if (localList == null) {
        break label855;
      }
      i6 = localList.hashCode();
      localList = this.iconHeight;
      if (localList == null) {
        break label861;
      }
      i7 = localList.hashCode();
      localList = this.bgCorner;
      if (localList == null) {
        break label867;
      }
      i8 = localList.hashCode();
      localList = this.bgColor;
      if (localList == null) {
        break label873;
      }
      i9 = localList.hashCode();
      localList = this.shadowColor;
      if (localList == null) {
        break label879;
      }
      i10 = localList.hashCode();
      localList = this.shadowHeight;
      if (localList == null) {
        break label885;
      }
      i11 = localList.hashCode();
      localList = this.initialColor;
      if (localList == null) {
        break label891;
      }
      i12 = localList.hashCode();
      localList = this.pressMaskColor;
      if (localList == null) {
        break label897;
      }
      i13 = localList.hashCode();
      localList = this.width;
      if (localList == null) {
        break label903;
      }
      i14 = localList.hashCode();
      localList = this.height;
      if (localList == null) {
        break label909;
      }
      i15 = localList.hashCode();
      localList = this.leftMargin;
      if (localList == null) {
        break label915;
      }
      i16 = localList.hashCode();
      localList = this.leftPadding;
      if (localList == null) {
        break label921;
      }
      i17 = localList.hashCode();
      localList = this.topMargin;
      if (localList == null) {
        break label927;
      }
      i18 = localList.hashCode();
      localList = this.topPadding;
      if (localList == null) {
        break label933;
      }
      i19 = localList.hashCode();
      localList = this.bottomPadding;
      if (localList == null) {
        break label939;
      }
      i20 = localList.hashCode();
      localList = this.rightMargin;
      if (localList == null) {
        break label945;
      }
      i21 = localList.hashCode();
      localList = this.rightPadding;
      if (localList == null) {
        break label951;
      }
      i22 = localList.hashCode();
      localList = this.clickable;
      if (localList == null) {
        break label957;
      }
      i23 = localList.hashCode();
      localList = this.longClickable;
      if (localList == null) {
        break label963;
      }
      i24 = localList.hashCode();
      localList = this.touchFunctionCode;
      if (localList == null) {
        break label969;
      }
      i25 = localList.hashCode();
      localList = this.clickFunctionCode;
      if (localList == null) {
        break label975;
      }
      i26 = localList.hashCode();
      label564:
      localList = this.longClickFunctionCode;
      if (localList == null) {
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
    for (int i27 = localList.hashCode();; i27 = 0)
    {
      localList = this.swipeable;
      if (localList != null) {
        i28 = localList.hashCode();
      }
      AppMethodBeat.o(212550);
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
  
  public final void setBgColor(List<String> paramList)
  {
    this.bgColor = paramList;
  }
  
  public final void setBgCorner(List<Float> paramList)
  {
    this.bgCorner = paramList;
  }
  
  public final void setBottomPadding(List<Float> paramList)
  {
    this.bottomPadding = paramList;
  }
  
  public final void setClickFunctionCode(List<Integer> paramList)
  {
    this.clickFunctionCode = paramList;
  }
  
  public final void setClickable(List<Boolean> paramList)
  {
    this.clickable = paramList;
  }
  
  public final void setDrawerType(List<String> paramList)
  {
    this.drawerType = paramList;
  }
  
  public final void setFloatText(List<String> paramList)
  {
    this.floatText = paramList;
  }
  
  public final void setFloatTextColor(List<String> paramList)
  {
    this.floatTextColor = paramList;
  }
  
  public final void setFloatTextSize(List<Integer> paramList)
  {
    this.floatTextSize = paramList;
  }
  
  public final void setHeight(List<Float> paramList)
  {
    this.height = paramList;
  }
  
  public final void setIconHeight(List<Float> paramList)
  {
    this.iconHeight = paramList;
  }
  
  public final void setIconWidth(List<Float> paramList)
  {
    this.iconWidth = paramList;
  }
  
  public final void setId(List<String> paramList)
  {
    this.id = paramList;
  }
  
  public final void setImgSrc(List<String> paramList)
  {
    this.imgSrc = paramList;
  }
  
  public final void setInitialColor(List<String> paramList)
  {
    this.initialColor = paramList;
  }
  
  public final void setLeftMargin(List<Float> paramList)
  {
    this.leftMargin = paramList;
  }
  
  public final void setLeftPadding(List<Float> paramList)
  {
    this.leftPadding = paramList;
  }
  
  public final void setLongClickFunctionCode(List<Integer> paramList)
  {
    this.longClickFunctionCode = paramList;
  }
  
  public final void setLongClickable(List<Boolean> paramList)
  {
    this.longClickable = paramList;
  }
  
  public final void setMainText(List<String> paramList)
  {
    this.mainText = paramList;
  }
  
  public final void setMainTextColor(List<String> paramList)
  {
    this.mainTextColor = paramList;
  }
  
  public final void setMainTextSize(List<Integer> paramList)
  {
    this.mainTextSize = paramList;
  }
  
  public final void setPressMaskColor(List<String> paramList)
  {
    this.pressMaskColor = paramList;
  }
  
  public final void setRightMargin(List<Float> paramList)
  {
    this.rightMargin = paramList;
  }
  
  public final void setRightPadding(List<Float> paramList)
  {
    this.rightPadding = paramList;
  }
  
  public final void setShadowColor(List<String> paramList)
  {
    this.shadowColor = paramList;
  }
  
  public final void setShadowHeight(List<Float> paramList)
  {
    this.shadowHeight = paramList;
  }
  
  public final void setSwipeable(List<Boolean> paramList)
  {
    this.swipeable = paramList;
  }
  
  public final void setTopMargin(List<Float> paramList)
  {
    this.topMargin = paramList;
  }
  
  public final void setTopPadding(List<Float> paramList)
  {
    this.topPadding = paramList;
  }
  
  public final void setTouchFunctionCode(List<Integer> paramList)
  {
    this.touchFunctionCode = paramList;
  }
  
  public final void setType(List<Integer> paramList)
  {
    this.type = paramList;
  }
  
  public final void setWidth(List<Float> paramList)
  {
    this.width = paramList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212549);
    String str = "KeyOriginData(id=" + this.id + ", type=" + this.type + ", drawerType=" + this.drawerType + ", mainText=" + this.mainText + ", mainTextSize=" + this.mainTextSize + ", mainTextColor=" + this.mainTextColor + ", floatText=" + this.floatText + ", floatTextSize=" + this.floatTextSize + ", floatTextColor=" + this.floatTextColor + ", imgSrc=" + this.imgSrc + ", iconWidth=" + this.iconWidth + ", iconHeight=" + this.iconHeight + ", bgCorner=" + this.bgCorner + ", bgColor=" + this.bgColor + ", shadowColor=" + this.shadowColor + ", shadowHeight=" + this.shadowHeight + ", initialColor=" + this.initialColor + ", pressMaskColor=" + this.pressMaskColor + ", width=" + this.width + ", height=" + this.height + ", leftMargin=" + this.leftMargin + ", leftPadding=" + this.leftPadding + ", topMargin=" + this.topMargin + ", topPadding=" + this.topPadding + ", bottomPadding=" + this.bottomPadding + ", rightMargin=" + this.rightMargin + ", rightPadding=" + this.rightPadding + ", clickable=" + this.clickable + ", longClickable=" + this.longClickable + ", touchFunctionCode=" + this.touchFunctionCode + ", clickFunctionCode=" + this.clickFunctionCode + ", longClickFunctionCode=" + this.longClickFunctionCode + ", swipeable=" + this.swipeable + ")";
    AppMethodBeat.o(212549);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyOriginData
 * JD-Core Version:    0.7.0.1
 */