package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginConfig;", "", "vWidth", "", "", "vHeight", "line", "", "lineHeight", "lineGap", "swipeable", "", "paddingLeft", "paddingRight", "marginLeft", "marginRight", "marginTop", "marginBottom", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getLine", "()Ljava/util/List;", "setLine", "(Ljava/util/List;)V", "getLineGap", "setLineGap", "getLineHeight", "setLineHeight", "getMarginBottom", "setMarginBottom", "getMarginLeft", "setMarginLeft", "getMarginRight", "setMarginRight", "getMarginTop", "setMarginTop", "getPaddingLeft", "setPaddingLeft", "getPaddingRight", "setPaddingRight", "getSwipeable", "setSwipeable", "getVHeight", "setVHeight", "getVWidth", "setVWidth", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KeyboardOriginConfig
{
  private List<Integer> line;
  private List<Float> lineGap;
  private List<Float> lineHeight;
  private List<Float> marginBottom;
  private List<Float> marginLeft;
  private List<Float> marginRight;
  private List<Float> marginTop;
  private List<Float> paddingLeft;
  private List<Float> paddingRight;
  private List<Boolean> swipeable;
  private List<Float> vHeight;
  private List<Float> vWidth;
  
  public KeyboardOriginConfig(List<Float> paramList1, List<Float> paramList2, List<Integer> paramList, List<Float> paramList3, List<Float> paramList4, List<Boolean> paramList5, List<Float> paramList6, List<Float> paramList7, List<Float> paramList8, List<Float> paramList9, List<Float> paramList10, List<Float> paramList11)
  {
    AppMethodBeat.i(313126);
    this.vWidth = paramList1;
    this.vHeight = paramList2;
    this.line = paramList;
    this.lineHeight = paramList3;
    this.lineGap = paramList4;
    this.swipeable = paramList5;
    this.paddingLeft = paramList6;
    this.paddingRight = paramList7;
    this.marginLeft = paramList8;
    this.marginRight = paramList9;
    this.marginTop = paramList10;
    this.marginBottom = paramList11;
    AppMethodBeat.o(313126);
  }
  
  public final List<Float> component1()
  {
    return this.vWidth;
  }
  
  public final List<Float> component10()
  {
    return this.marginRight;
  }
  
  public final List<Float> component11()
  {
    return this.marginTop;
  }
  
  public final List<Float> component12()
  {
    return this.marginBottom;
  }
  
  public final List<Float> component2()
  {
    return this.vHeight;
  }
  
  public final List<Integer> component3()
  {
    return this.line;
  }
  
  public final List<Float> component4()
  {
    return this.lineHeight;
  }
  
  public final List<Float> component5()
  {
    return this.lineGap;
  }
  
  public final List<Boolean> component6()
  {
    return this.swipeable;
  }
  
  public final List<Float> component7()
  {
    return this.paddingLeft;
  }
  
  public final List<Float> component8()
  {
    return this.paddingRight;
  }
  
  public final List<Float> component9()
  {
    return this.marginLeft;
  }
  
  public final KeyboardOriginConfig copy(List<Float> paramList1, List<Float> paramList2, List<Integer> paramList, List<Float> paramList3, List<Float> paramList4, List<Boolean> paramList5, List<Float> paramList6, List<Float> paramList7, List<Float> paramList8, List<Float> paramList9, List<Float> paramList10, List<Float> paramList11)
  {
    AppMethodBeat.i(313289);
    s.u(paramList1, "vWidth");
    s.u(paramList2, "vHeight");
    s.u(paramList, "line");
    s.u(paramList3, "lineHeight");
    s.u(paramList4, "lineGap");
    s.u(paramList5, "swipeable");
    s.u(paramList6, "paddingLeft");
    s.u(paramList7, "paddingRight");
    s.u(paramList8, "marginLeft");
    s.u(paramList9, "marginRight");
    s.u(paramList10, "marginTop");
    s.u(paramList11, "marginBottom");
    paramList1 = new KeyboardOriginConfig(paramList1, paramList2, paramList, paramList3, paramList4, paramList5, paramList6, paramList7, paramList8, paramList9, paramList10, paramList11);
    AppMethodBeat.o(313289);
    return paramList1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(313301);
    if (this == paramObject)
    {
      AppMethodBeat.o(313301);
      return true;
    }
    if (!(paramObject instanceof KeyboardOriginConfig))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    paramObject = (KeyboardOriginConfig)paramObject;
    if (!s.p(this.vWidth, paramObject.vWidth))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    if (!s.p(this.vHeight, paramObject.vHeight))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    if (!s.p(this.line, paramObject.line))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    if (!s.p(this.lineHeight, paramObject.lineHeight))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    if (!s.p(this.lineGap, paramObject.lineGap))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    if (!s.p(this.swipeable, paramObject.swipeable))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    if (!s.p(this.paddingLeft, paramObject.paddingLeft))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    if (!s.p(this.paddingRight, paramObject.paddingRight))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    if (!s.p(this.marginLeft, paramObject.marginLeft))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    if (!s.p(this.marginRight, paramObject.marginRight))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    if (!s.p(this.marginTop, paramObject.marginTop))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    if (!s.p(this.marginBottom, paramObject.marginBottom))
    {
      AppMethodBeat.o(313301);
      return false;
    }
    AppMethodBeat.o(313301);
    return true;
  }
  
  public final List<Integer> getLine()
  {
    return this.line;
  }
  
  public final List<Float> getLineGap()
  {
    return this.lineGap;
  }
  
  public final List<Float> getLineHeight()
  {
    return this.lineHeight;
  }
  
  public final List<Float> getMarginBottom()
  {
    return this.marginBottom;
  }
  
  public final List<Float> getMarginLeft()
  {
    return this.marginLeft;
  }
  
  public final List<Float> getMarginRight()
  {
    return this.marginRight;
  }
  
  public final List<Float> getMarginTop()
  {
    return this.marginTop;
  }
  
  public final List<Float> getPaddingLeft()
  {
    return this.paddingLeft;
  }
  
  public final List<Float> getPaddingRight()
  {
    return this.paddingRight;
  }
  
  public final List<Boolean> getSwipeable()
  {
    return this.swipeable;
  }
  
  public final List<Float> getVHeight()
  {
    return this.vHeight;
  }
  
  public final List<Float> getVWidth()
  {
    return this.vWidth;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(313298);
    int i = this.vWidth.hashCode();
    int j = this.vHeight.hashCode();
    int k = this.line.hashCode();
    int m = this.lineHeight.hashCode();
    int n = this.lineGap.hashCode();
    int i1 = this.swipeable.hashCode();
    int i2 = this.paddingLeft.hashCode();
    int i3 = this.paddingRight.hashCode();
    int i4 = this.marginLeft.hashCode();
    int i5 = this.marginRight.hashCode();
    int i6 = this.marginTop.hashCode();
    int i7 = this.marginBottom.hashCode();
    AppMethodBeat.o(313298);
    return ((((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7;
  }
  
  public final void setLine(List<Integer> paramList)
  {
    AppMethodBeat.i(313170);
    s.u(paramList, "<set-?>");
    this.line = paramList;
    AppMethodBeat.o(313170);
  }
  
  public final void setLineGap(List<Float> paramList)
  {
    AppMethodBeat.i(313184);
    s.u(paramList, "<set-?>");
    this.lineGap = paramList;
    AppMethodBeat.o(313184);
  }
  
  public final void setLineHeight(List<Float> paramList)
  {
    AppMethodBeat.i(313177);
    s.u(paramList, "<set-?>");
    this.lineHeight = paramList;
    AppMethodBeat.o(313177);
  }
  
  public final void setMarginBottom(List<Float> paramList)
  {
    AppMethodBeat.i(313236);
    s.u(paramList, "<set-?>");
    this.marginBottom = paramList;
    AppMethodBeat.o(313236);
  }
  
  public final void setMarginLeft(List<Float> paramList)
  {
    AppMethodBeat.i(313216);
    s.u(paramList, "<set-?>");
    this.marginLeft = paramList;
    AppMethodBeat.o(313216);
  }
  
  public final void setMarginRight(List<Float> paramList)
  {
    AppMethodBeat.i(313223);
    s.u(paramList, "<set-?>");
    this.marginRight = paramList;
    AppMethodBeat.o(313223);
  }
  
  public final void setMarginTop(List<Float> paramList)
  {
    AppMethodBeat.i(313228);
    s.u(paramList, "<set-?>");
    this.marginTop = paramList;
    AppMethodBeat.o(313228);
  }
  
  public final void setPaddingLeft(List<Float> paramList)
  {
    AppMethodBeat.i(313206);
    s.u(paramList, "<set-?>");
    this.paddingLeft = paramList;
    AppMethodBeat.o(313206);
  }
  
  public final void setPaddingRight(List<Float> paramList)
  {
    AppMethodBeat.i(313209);
    s.u(paramList, "<set-?>");
    this.paddingRight = paramList;
    AppMethodBeat.o(313209);
  }
  
  public final void setSwipeable(List<Boolean> paramList)
  {
    AppMethodBeat.i(313197);
    s.u(paramList, "<set-?>");
    this.swipeable = paramList;
    AppMethodBeat.o(313197);
  }
  
  public final void setVHeight(List<Float> paramList)
  {
    AppMethodBeat.i(313157);
    s.u(paramList, "<set-?>");
    this.vHeight = paramList;
    AppMethodBeat.o(313157);
  }
  
  public final void setVWidth(List<Float> paramList)
  {
    AppMethodBeat.i(313146);
    s.u(paramList, "<set-?>");
    this.vWidth = paramList;
    AppMethodBeat.o(313146);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(313295);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("KeyboardOriginConfig(vWidth=").append(this.vWidth).append(", vHeight=").append(this.vHeight).append(", line=").append(this.line).append(", lineHeight=").append(this.lineHeight).append(", lineGap=").append(this.lineGap).append(", swipeable=").append(this.swipeable).append(", paddingLeft=").append(this.paddingLeft).append(", paddingRight=").append(this.paddingRight).append(", marginLeft=").append(this.marginLeft).append(", marginRight=").append(this.marginRight).append(", marginTop=").append(this.marginTop).append(", marginBottom=");
    ((StringBuilder)localObject).append(this.marginBottom).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(313295);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardOriginConfig
 * JD-Core Version:    0.7.0.1
 */