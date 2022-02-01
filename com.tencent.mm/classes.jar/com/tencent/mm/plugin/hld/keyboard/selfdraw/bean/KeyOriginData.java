package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyOriginData;", "", "id", "", "", "type", "", "drawerType", "mainText", "mainTextSize", "mainTextColor", "floatText", "floatTextSize", "floatTextColor", "imgSrc", "iconWidth", "", "iconHeight", "bgCorner", "bgColor", "shadowColor", "shadowHeight", "initialColor", "pressMaskColor", "width", "height", "leftMargin", "leftPadding", "topMargin", "topPadding", "bottomPadding", "rightMargin", "rightPadding", "clickable", "", "longClickable", "touchFunctionCode", "clickFunctionCode", "longClickFunctionCode", "swipeable", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBgColor", "()Ljava/util/List;", "setBgColor", "(Ljava/util/List;)V", "getBgCorner", "setBgCorner", "getBottomPadding", "setBottomPadding", "getClickFunctionCode", "setClickFunctionCode", "getClickable", "setClickable", "getDrawerType", "setDrawerType", "getFloatText", "setFloatText", "getFloatTextColor", "setFloatTextColor", "getFloatTextSize", "setFloatTextSize", "getHeight", "setHeight", "getIconHeight", "setIconHeight", "getIconWidth", "setIconWidth", "getId", "setId", "getImgSrc", "setImgSrc", "getInitialColor", "setInitialColor", "getLeftMargin", "setLeftMargin", "getLeftPadding", "setLeftPadding", "getLongClickFunctionCode", "setLongClickFunctionCode", "getLongClickable", "setLongClickable", "getMainText", "setMainText", "getMainTextColor", "setMainTextColor", "getMainTextSize", "setMainTextSize", "getPressMaskColor", "setPressMaskColor", "getRightMargin", "setRightMargin", "getRightPadding", "setRightPadding", "getShadowColor", "setShadowColor", "getShadowHeight", "setShadowHeight", "getSwipeable", "setSwipeable", "getTopMargin", "setTopMargin", "getTopPadding", "setTopPadding", "getTouchFunctionCode", "setTouchFunctionCode", "getType", "setType", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
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
    AppMethodBeat.i(313493);
    paramList1 = new KeyOriginData(paramList1, paramList2, paramList3, paramList4, paramList5, paramList6, paramList7, paramList8, paramList9, paramList10, paramList11, paramList12, paramList13, paramList14, paramList15, paramList16, paramList17, paramList18, paramList19, paramList20, paramList21, paramList22, paramList23, paramList24, paramList25, paramList26, paramList27, paramList28, paramList29, paramList30, paramList31, paramList32, paramList33);
    AppMethodBeat.o(313493);
    return paramList1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(313517);
    if (this == paramObject)
    {
      AppMethodBeat.o(313517);
      return true;
    }
    if (!(paramObject instanceof KeyOriginData))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    paramObject = (KeyOriginData)paramObject;
    if (!s.p(this.id, paramObject.id))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.type, paramObject.type))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.drawerType, paramObject.drawerType))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.mainText, paramObject.mainText))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.mainTextSize, paramObject.mainTextSize))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.mainTextColor, paramObject.mainTextColor))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.floatText, paramObject.floatText))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.floatTextSize, paramObject.floatTextSize))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.floatTextColor, paramObject.floatTextColor))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.imgSrc, paramObject.imgSrc))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.iconWidth, paramObject.iconWidth))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.iconHeight, paramObject.iconHeight))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.bgCorner, paramObject.bgCorner))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.bgColor, paramObject.bgColor))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.shadowColor, paramObject.shadowColor))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.shadowHeight, paramObject.shadowHeight))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.initialColor, paramObject.initialColor))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.pressMaskColor, paramObject.pressMaskColor))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.width, paramObject.width))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.height, paramObject.height))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.leftMargin, paramObject.leftMargin))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.leftPadding, paramObject.leftPadding))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.topMargin, paramObject.topMargin))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.topPadding, paramObject.topPadding))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.bottomPadding, paramObject.bottomPadding))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.rightMargin, paramObject.rightMargin))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.rightPadding, paramObject.rightPadding))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.clickable, paramObject.clickable))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.longClickable, paramObject.longClickable))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.touchFunctionCode, paramObject.touchFunctionCode))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.clickFunctionCode, paramObject.clickFunctionCode))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.longClickFunctionCode, paramObject.longClickFunctionCode))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    if (!s.p(this.swipeable, paramObject.swipeable))
    {
      AppMethodBeat.o(313517);
      return false;
    }
    AppMethodBeat.o(313517);
    return true;
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
    AppMethodBeat.i(313511);
    int i;
    int j;
    label27:
    int k;
    label36:
    int m;
    label46:
    int n;
    label56:
    int i1;
    label66:
    int i2;
    label76:
    int i3;
    label86:
    int i4;
    label96:
    int i5;
    label106:
    int i6;
    label116:
    int i7;
    label126:
    int i8;
    label136:
    int i9;
    label146:
    int i10;
    label156:
    int i11;
    label166:
    int i12;
    label176:
    int i13;
    label186:
    int i14;
    label196:
    int i15;
    label206:
    int i16;
    label216:
    int i17;
    label226:
    int i18;
    label236:
    int i19;
    label246:
    int i20;
    label256:
    int i21;
    label266:
    int i22;
    label276:
    int i23;
    label286:
    int i24;
    label296:
    int i25;
    label306:
    int i26;
    label316:
    int i27;
    if (this.id == null)
    {
      i = 0;
      if (this.type != null) {
        break label542;
      }
      j = 0;
      if (this.drawerType != null) {
        break label553;
      }
      k = 0;
      if (this.mainText != null) {
        break label564;
      }
      m = 0;
      if (this.mainTextSize != null) {
        break label576;
      }
      n = 0;
      if (this.mainTextColor != null) {
        break label588;
      }
      i1 = 0;
      if (this.floatText != null) {
        break label600;
      }
      i2 = 0;
      if (this.floatTextSize != null) {
        break label612;
      }
      i3 = 0;
      if (this.floatTextColor != null) {
        break label624;
      }
      i4 = 0;
      if (this.imgSrc != null) {
        break label636;
      }
      i5 = 0;
      if (this.iconWidth != null) {
        break label648;
      }
      i6 = 0;
      if (this.iconHeight != null) {
        break label660;
      }
      i7 = 0;
      if (this.bgCorner != null) {
        break label672;
      }
      i8 = 0;
      if (this.bgColor != null) {
        break label684;
      }
      i9 = 0;
      if (this.shadowColor != null) {
        break label696;
      }
      i10 = 0;
      if (this.shadowHeight != null) {
        break label708;
      }
      i11 = 0;
      if (this.initialColor != null) {
        break label720;
      }
      i12 = 0;
      if (this.pressMaskColor != null) {
        break label732;
      }
      i13 = 0;
      if (this.width != null) {
        break label744;
      }
      i14 = 0;
      if (this.height != null) {
        break label756;
      }
      i15 = 0;
      if (this.leftMargin != null) {
        break label768;
      }
      i16 = 0;
      if (this.leftPadding != null) {
        break label780;
      }
      i17 = 0;
      if (this.topMargin != null) {
        break label792;
      }
      i18 = 0;
      if (this.topPadding != null) {
        break label804;
      }
      i19 = 0;
      if (this.bottomPadding != null) {
        break label816;
      }
      i20 = 0;
      if (this.rightMargin != null) {
        break label828;
      }
      i21 = 0;
      if (this.rightPadding != null) {
        break label840;
      }
      i22 = 0;
      if (this.clickable != null) {
        break label852;
      }
      i23 = 0;
      if (this.longClickable != null) {
        break label864;
      }
      i24 = 0;
      if (this.touchFunctionCode != null) {
        break label876;
      }
      i25 = 0;
      if (this.clickFunctionCode != null) {
        break label888;
      }
      i26 = 0;
      if (this.longClickFunctionCode != null) {
        break label900;
      }
      i27 = 0;
      label326:
      if (this.swipeable != null) {
        break label912;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(313511);
      return (i27 + (i26 + (i25 + (i24 + (i23 + (i22 + (i21 + (i20 + (i19 + (i18 + (i17 + (i16 + (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i28;
      i = this.id.hashCode();
      break;
      label542:
      j = this.type.hashCode();
      break label27;
      label553:
      k = this.drawerType.hashCode();
      break label36;
      label564:
      m = this.mainText.hashCode();
      break label46;
      label576:
      n = this.mainTextSize.hashCode();
      break label56;
      label588:
      i1 = this.mainTextColor.hashCode();
      break label66;
      label600:
      i2 = this.floatText.hashCode();
      break label76;
      label612:
      i3 = this.floatTextSize.hashCode();
      break label86;
      label624:
      i4 = this.floatTextColor.hashCode();
      break label96;
      label636:
      i5 = this.imgSrc.hashCode();
      break label106;
      label648:
      i6 = this.iconWidth.hashCode();
      break label116;
      label660:
      i7 = this.iconHeight.hashCode();
      break label126;
      label672:
      i8 = this.bgCorner.hashCode();
      break label136;
      label684:
      i9 = this.bgColor.hashCode();
      break label146;
      label696:
      i10 = this.shadowColor.hashCode();
      break label156;
      label708:
      i11 = this.shadowHeight.hashCode();
      break label166;
      label720:
      i12 = this.initialColor.hashCode();
      break label176;
      label732:
      i13 = this.pressMaskColor.hashCode();
      break label186;
      label744:
      i14 = this.width.hashCode();
      break label196;
      label756:
      i15 = this.height.hashCode();
      break label206;
      label768:
      i16 = this.leftMargin.hashCode();
      break label216;
      label780:
      i17 = this.leftPadding.hashCode();
      break label226;
      label792:
      i18 = this.topMargin.hashCode();
      break label236;
      label804:
      i19 = this.topPadding.hashCode();
      break label246;
      label816:
      i20 = this.bottomPadding.hashCode();
      break label256;
      label828:
      i21 = this.rightMargin.hashCode();
      break label266;
      label840:
      i22 = this.rightPadding.hashCode();
      break label276;
      label852:
      i23 = this.clickable.hashCode();
      break label286;
      label864:
      i24 = this.longClickable.hashCode();
      break label296;
      label876:
      i25 = this.touchFunctionCode.hashCode();
      break label306;
      label888:
      i26 = this.clickFunctionCode.hashCode();
      break label316;
      label900:
      i27 = this.longClickFunctionCode.hashCode();
      break label326;
      label912:
      i28 = this.swipeable.hashCode();
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
    AppMethodBeat.i(313503);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("KeyOriginData(id=").append(this.id).append(", type=").append(this.type).append(", drawerType=").append(this.drawerType).append(", mainText=").append(this.mainText).append(", mainTextSize=").append(this.mainTextSize).append(", mainTextColor=").append(this.mainTextColor).append(", floatText=").append(this.floatText).append(", floatTextSize=").append(this.floatTextSize).append(", floatTextColor=").append(this.floatTextColor).append(", imgSrc=").append(this.imgSrc).append(", iconWidth=").append(this.iconWidth).append(", iconHeight=");
    ((StringBuilder)localObject).append(this.iconHeight).append(", bgCorner=").append(this.bgCorner).append(", bgColor=").append(this.bgColor).append(", shadowColor=").append(this.shadowColor).append(", shadowHeight=").append(this.shadowHeight).append(", initialColor=").append(this.initialColor).append(", pressMaskColor=").append(this.pressMaskColor).append(", width=").append(this.width).append(", height=").append(this.height).append(", leftMargin=").append(this.leftMargin).append(", leftPadding=").append(this.leftPadding).append(", topMargin=").append(this.topMargin);
    ((StringBuilder)localObject).append(", topPadding=").append(this.topPadding).append(", bottomPadding=").append(this.bottomPadding).append(", rightMargin=").append(this.rightMargin).append(", rightPadding=").append(this.rightPadding).append(", clickable=").append(this.clickable).append(", longClickable=").append(this.longClickable).append(", touchFunctionCode=").append(this.touchFunctionCode).append(", clickFunctionCode=").append(this.clickFunctionCode).append(", longClickFunctionCode=").append(this.longClickFunctionCode).append(", swipeable=").append(this.swipeable).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(313503);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyOriginData
 * JD-Core Version:    0.7.0.1
 */