package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;", "", "vWidth", "", "vHeight", "line", "", "lineHeight", "", "lineGap", "swipeable", "", "paddingLeft", "paddingRight", "marginLeft", "marginRight", "marginTop", "marginBottom", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getLine", "()Ljava/lang/Integer;", "setLine", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLineGap", "()Ljava/lang/Float;", "setLineGap", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getLineHeight", "()Ljava/util/List;", "setLineHeight", "(Ljava/util/List;)V", "getMarginBottom", "setMarginBottom", "getMarginLeft", "setMarginLeft", "getMarginRight", "setMarginRight", "getMarginTop", "setMarginTop", "getPaddingLeft", "setPaddingLeft", "getPaddingRight", "setPaddingRight", "getSwipeable", "()Ljava/lang/Boolean;", "setSwipeable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getVHeight", "setVHeight", "getVWidth", "setVWidth", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;", "equals", "other", "hashCode", "toString", "", "plugin-hld_release"})
public final class KeyboardConfig
{
  private Integer line;
  private Float lineGap;
  private List<Float> lineHeight;
  private Float marginBottom;
  private Float marginLeft;
  private Float marginRight;
  private Float marginTop;
  private Float paddingLeft;
  private Float paddingRight;
  private Boolean swipeable;
  private Float vHeight;
  private Float vWidth;
  
  public KeyboardConfig(Float paramFloat1, Float paramFloat2, Integer paramInteger, List<Float> paramList, Float paramFloat3, Boolean paramBoolean, Float paramFloat4, Float paramFloat5, Float paramFloat6, Float paramFloat7, Float paramFloat8, Float paramFloat9)
  {
    this.vWidth = paramFloat1;
    this.vHeight = paramFloat2;
    this.line = paramInteger;
    this.lineHeight = paramList;
    this.lineGap = paramFloat3;
    this.swipeable = paramBoolean;
    this.paddingLeft = paramFloat4;
    this.paddingRight = paramFloat5;
    this.marginLeft = paramFloat6;
    this.marginRight = paramFloat7;
    this.marginTop = paramFloat8;
    this.marginBottom = paramFloat9;
  }
  
  public final Float component1()
  {
    return this.vWidth;
  }
  
  public final Float component10()
  {
    return this.marginRight;
  }
  
  public final Float component11()
  {
    return this.marginTop;
  }
  
  public final Float component12()
  {
    return this.marginBottom;
  }
  
  public final Float component2()
  {
    return this.vHeight;
  }
  
  public final Integer component3()
  {
    return this.line;
  }
  
  public final List<Float> component4()
  {
    return this.lineHeight;
  }
  
  public final Float component5()
  {
    return this.lineGap;
  }
  
  public final Boolean component6()
  {
    return this.swipeable;
  }
  
  public final Float component7()
  {
    return this.paddingLeft;
  }
  
  public final Float component8()
  {
    return this.paddingRight;
  }
  
  public final Float component9()
  {
    return this.marginLeft;
  }
  
  public final KeyboardConfig copy(Float paramFloat1, Float paramFloat2, Integer paramInteger, List<Float> paramList, Float paramFloat3, Boolean paramBoolean, Float paramFloat4, Float paramFloat5, Float paramFloat6, Float paramFloat7, Float paramFloat8, Float paramFloat9)
  {
    AppMethodBeat.i(210745);
    paramFloat1 = new KeyboardConfig(paramFloat1, paramFloat2, paramInteger, paramList, paramFloat3, paramBoolean, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
    AppMethodBeat.o(210745);
    return paramFloat1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(210750);
    if (this != paramObject)
    {
      if ((paramObject instanceof KeyboardConfig))
      {
        paramObject = (KeyboardConfig)paramObject;
        if ((!p.h(this.vWidth, paramObject.vWidth)) || (!p.h(this.vHeight, paramObject.vHeight)) || (!p.h(this.line, paramObject.line)) || (!p.h(this.lineHeight, paramObject.lineHeight)) || (!p.h(this.lineGap, paramObject.lineGap)) || (!p.h(this.swipeable, paramObject.swipeable)) || (!p.h(this.paddingLeft, paramObject.paddingLeft)) || (!p.h(this.paddingRight, paramObject.paddingRight)) || (!p.h(this.marginLeft, paramObject.marginLeft)) || (!p.h(this.marginRight, paramObject.marginRight)) || (!p.h(this.marginTop, paramObject.marginTop)) || (!p.h(this.marginBottom, paramObject.marginBottom))) {}
      }
    }
    else
    {
      AppMethodBeat.o(210750);
      return true;
    }
    AppMethodBeat.o(210750);
    return false;
  }
  
  public final Integer getLine()
  {
    return this.line;
  }
  
  public final Float getLineGap()
  {
    return this.lineGap;
  }
  
  public final List<Float> getLineHeight()
  {
    return this.lineHeight;
  }
  
  public final Float getMarginBottom()
  {
    return this.marginBottom;
  }
  
  public final Float getMarginLeft()
  {
    return this.marginLeft;
  }
  
  public final Float getMarginRight()
  {
    return this.marginRight;
  }
  
  public final Float getMarginTop()
  {
    return this.marginTop;
  }
  
  public final Float getPaddingLeft()
  {
    return this.paddingLeft;
  }
  
  public final Float getPaddingRight()
  {
    return this.paddingRight;
  }
  
  public final Boolean getSwipeable()
  {
    return this.swipeable;
  }
  
  public final Float getVHeight()
  {
    return this.vHeight;
  }
  
  public final Float getVWidth()
  {
    return this.vWidth;
  }
  
  public final int hashCode()
  {
    int i7 = 0;
    AppMethodBeat.i(210749);
    Object localObject = this.vWidth;
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
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.vHeight;
      if (localObject == null) {
        break label297;
      }
      j = localObject.hashCode();
      localObject = this.line;
      if (localObject == null) {
        break label302;
      }
      k = localObject.hashCode();
      localObject = this.lineHeight;
      if (localObject == null) {
        break label307;
      }
      m = localObject.hashCode();
      localObject = this.lineGap;
      if (localObject == null) {
        break label313;
      }
      n = localObject.hashCode();
      localObject = this.swipeable;
      if (localObject == null) {
        break label319;
      }
      i1 = localObject.hashCode();
      localObject = this.paddingLeft;
      if (localObject == null) {
        break label325;
      }
      i2 = localObject.hashCode();
      localObject = this.paddingRight;
      if (localObject == null) {
        break label331;
      }
      i3 = localObject.hashCode();
      localObject = this.marginLeft;
      if (localObject == null) {
        break label337;
      }
      i4 = localObject.hashCode();
      localObject = this.marginRight;
      if (localObject == null) {
        break label343;
      }
      i5 = localObject.hashCode();
      label185:
      localObject = this.marginTop;
      if (localObject == null) {
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
    for (int i6 = localObject.hashCode();; i6 = 0)
    {
      localObject = this.marginBottom;
      if (localObject != null) {
        i7 = localObject.hashCode();
      }
      AppMethodBeat.o(210749);
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
  
  public final void setLine(Integer paramInteger)
  {
    this.line = paramInteger;
  }
  
  public final void setLineGap(Float paramFloat)
  {
    this.lineGap = paramFloat;
  }
  
  public final void setLineHeight(List<Float> paramList)
  {
    this.lineHeight = paramList;
  }
  
  public final void setMarginBottom(Float paramFloat)
  {
    this.marginBottom = paramFloat;
  }
  
  public final void setMarginLeft(Float paramFloat)
  {
    this.marginLeft = paramFloat;
  }
  
  public final void setMarginRight(Float paramFloat)
  {
    this.marginRight = paramFloat;
  }
  
  public final void setMarginTop(Float paramFloat)
  {
    this.marginTop = paramFloat;
  }
  
  public final void setPaddingLeft(Float paramFloat)
  {
    this.paddingLeft = paramFloat;
  }
  
  public final void setPaddingRight(Float paramFloat)
  {
    this.paddingRight = paramFloat;
  }
  
  public final void setSwipeable(Boolean paramBoolean)
  {
    this.swipeable = paramBoolean;
  }
  
  public final void setVHeight(Float paramFloat)
  {
    this.vHeight = paramFloat;
  }
  
  public final void setVWidth(Float paramFloat)
  {
    this.vWidth = paramFloat;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210748);
    String str = "KeyboardConfig(vWidth=" + this.vWidth + ", vHeight=" + this.vHeight + ", line=" + this.line + ", lineHeight=" + this.lineHeight + ", lineGap=" + this.lineGap + ", swipeable=" + this.swipeable + ", paddingLeft=" + this.paddingLeft + ", paddingRight=" + this.paddingRight + ", marginLeft=" + this.marginLeft + ", marginRight=" + this.marginRight + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ")";
    AppMethodBeat.o(210748);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardConfig
 * JD-Core Version:    0.7.0.1
 */