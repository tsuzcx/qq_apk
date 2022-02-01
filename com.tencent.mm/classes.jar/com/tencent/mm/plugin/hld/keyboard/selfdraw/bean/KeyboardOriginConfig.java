package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginConfig;", "", "vWidth", "", "", "vHeight", "line", "", "lineHeight", "lineGap", "swipeable", "", "paddingLeft", "paddingRight", "marginLeft", "marginRight", "marginTop", "marginBottom", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getLine", "()Ljava/util/List;", "setLine", "(Ljava/util/List;)V", "getLineGap", "setLineGap", "getLineHeight", "setLineHeight", "getMarginBottom", "setMarginBottom", "getMarginLeft", "setMarginLeft", "getMarginRight", "setMarginRight", "getMarginTop", "setMarginTop", "getPaddingLeft", "setPaddingLeft", "getPaddingRight", "setPaddingRight", "getSwipeable", "setSwipeable", "getVHeight", "setVHeight", "getVWidth", "setVWidth", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-hld_release"})
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
    AppMethodBeat.i(216124);
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
    AppMethodBeat.o(216124);
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
    AppMethodBeat.i(216133);
    p.k(paramList1, "vWidth");
    p.k(paramList2, "vHeight");
    p.k(paramList, "line");
    p.k(paramList3, "lineHeight");
    p.k(paramList4, "lineGap");
    p.k(paramList5, "swipeable");
    p.k(paramList6, "paddingLeft");
    p.k(paramList7, "paddingRight");
    p.k(paramList8, "marginLeft");
    p.k(paramList9, "marginRight");
    p.k(paramList10, "marginTop");
    p.k(paramList11, "marginBottom");
    paramList1 = new KeyboardOriginConfig(paramList1, paramList2, paramList, paramList3, paramList4, paramList5, paramList6, paramList7, paramList8, paramList9, paramList10, paramList11);
    AppMethodBeat.o(216133);
    return paramList1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216145);
    if (this != paramObject)
    {
      if ((paramObject instanceof KeyboardOriginConfig))
      {
        paramObject = (KeyboardOriginConfig)paramObject;
        if ((!p.h(this.vWidth, paramObject.vWidth)) || (!p.h(this.vHeight, paramObject.vHeight)) || (!p.h(this.line, paramObject.line)) || (!p.h(this.lineHeight, paramObject.lineHeight)) || (!p.h(this.lineGap, paramObject.lineGap)) || (!p.h(this.swipeable, paramObject.swipeable)) || (!p.h(this.paddingLeft, paramObject.paddingLeft)) || (!p.h(this.paddingRight, paramObject.paddingRight)) || (!p.h(this.marginLeft, paramObject.marginLeft)) || (!p.h(this.marginRight, paramObject.marginRight)) || (!p.h(this.marginTop, paramObject.marginTop)) || (!p.h(this.marginBottom, paramObject.marginBottom))) {}
      }
    }
    else
    {
      AppMethodBeat.o(216145);
      return true;
    }
    AppMethodBeat.o(216145);
    return false;
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
    int i7 = 0;
    AppMethodBeat.i(216142);
    List localList = this.vWidth;
    int i;
    int j;
    label42:
    int k;
    label59:
    int m;
    label77:
    int n;
    label95:
    int i1;
    label113:
    int i2;
    label131:
    int i3;
    label149:
    int i4;
    label167:
    int i5;
    if (localList != null)
    {
      i = localList.hashCode();
      localList = this.vHeight;
      if (localList == null) {
        break label297;
      }
      j = localList.hashCode();
      localList = this.line;
      if (localList == null) {
        break label302;
      }
      k = localList.hashCode();
      localList = this.lineHeight;
      if (localList == null) {
        break label307;
      }
      m = localList.hashCode();
      localList = this.lineGap;
      if (localList == null) {
        break label313;
      }
      n = localList.hashCode();
      localList = this.swipeable;
      if (localList == null) {
        break label319;
      }
      i1 = localList.hashCode();
      localList = this.paddingLeft;
      if (localList == null) {
        break label325;
      }
      i2 = localList.hashCode();
      localList = this.paddingRight;
      if (localList == null) {
        break label331;
      }
      i3 = localList.hashCode();
      localList = this.marginLeft;
      if (localList == null) {
        break label337;
      }
      i4 = localList.hashCode();
      localList = this.marginRight;
      if (localList == null) {
        break label343;
      }
      i5 = localList.hashCode();
      label185:
      localList = this.marginTop;
      if (localList == null) {
        break label349;
      }
    }
    label297:
    label302:
    label307:
    label313:
    label319:
    label325:
    label331:
    label337:
    label343:
    label349:
    for (int i6 = localList.hashCode();; i6 = 0)
    {
      localList = this.marginBottom;
      if (localList != null) {
        i7 = localList.hashCode();
      }
      AppMethodBeat.o(216142);
      return (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i7;
      i = 0;
      break;
      j = 0;
      break label42;
      k = 0;
      break label59;
      m = 0;
      break label77;
      n = 0;
      break label95;
      i1 = 0;
      break label113;
      i2 = 0;
      break label131;
      i3 = 0;
      break label149;
      i4 = 0;
      break label167;
      i5 = 0;
      break label185;
    }
  }
  
  public final void setLine(List<Integer> paramList)
  {
    AppMethodBeat.i(216094);
    p.k(paramList, "<set-?>");
    this.line = paramList;
    AppMethodBeat.o(216094);
  }
  
  public final void setLineGap(List<Float> paramList)
  {
    AppMethodBeat.i(216101);
    p.k(paramList, "<set-?>");
    this.lineGap = paramList;
    AppMethodBeat.o(216101);
  }
  
  public final void setLineHeight(List<Float> paramList)
  {
    AppMethodBeat.i(216099);
    p.k(paramList, "<set-?>");
    this.lineHeight = paramList;
    AppMethodBeat.o(216099);
  }
  
  public final void setMarginBottom(List<Float> paramList)
  {
    AppMethodBeat.i(216122);
    p.k(paramList, "<set-?>");
    this.marginBottom = paramList;
    AppMethodBeat.o(216122);
  }
  
  public final void setMarginLeft(List<Float> paramList)
  {
    AppMethodBeat.i(216114);
    p.k(paramList, "<set-?>");
    this.marginLeft = paramList;
    AppMethodBeat.o(216114);
  }
  
  public final void setMarginRight(List<Float> paramList)
  {
    AppMethodBeat.i(216117);
    p.k(paramList, "<set-?>");
    this.marginRight = paramList;
    AppMethodBeat.o(216117);
  }
  
  public final void setMarginTop(List<Float> paramList)
  {
    AppMethodBeat.i(216119);
    p.k(paramList, "<set-?>");
    this.marginTop = paramList;
    AppMethodBeat.o(216119);
  }
  
  public final void setPaddingLeft(List<Float> paramList)
  {
    AppMethodBeat.i(216109);
    p.k(paramList, "<set-?>");
    this.paddingLeft = paramList;
    AppMethodBeat.o(216109);
  }
  
  public final void setPaddingRight(List<Float> paramList)
  {
    AppMethodBeat.i(216112);
    p.k(paramList, "<set-?>");
    this.paddingRight = paramList;
    AppMethodBeat.o(216112);
  }
  
  public final void setSwipeable(List<Boolean> paramList)
  {
    AppMethodBeat.i(216106);
    p.k(paramList, "<set-?>");
    this.swipeable = paramList;
    AppMethodBeat.o(216106);
  }
  
  public final void setVHeight(List<Float> paramList)
  {
    AppMethodBeat.i(216092);
    p.k(paramList, "<set-?>");
    this.vHeight = paramList;
    AppMethodBeat.o(216092);
  }
  
  public final void setVWidth(List<Float> paramList)
  {
    AppMethodBeat.i(216090);
    p.k(paramList, "<set-?>");
    this.vWidth = paramList;
    AppMethodBeat.o(216090);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216138);
    String str = "KeyboardOriginConfig(vWidth=" + this.vWidth + ", vHeight=" + this.vHeight + ", line=" + this.line + ", lineHeight=" + this.lineHeight + ", lineGap=" + this.lineGap + ", swipeable=" + this.swipeable + ", paddingLeft=" + this.paddingLeft + ", paddingRight=" + this.paddingRight + ", marginLeft=" + this.marginLeft + ", marginRight=" + this.marginRight + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ")";
    AppMethodBeat.o(216138);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardOriginConfig
 * JD-Core Version:    0.7.0.1
 */