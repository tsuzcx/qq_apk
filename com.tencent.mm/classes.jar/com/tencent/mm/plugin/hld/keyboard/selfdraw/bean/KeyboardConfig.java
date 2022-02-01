package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;", "", "vWidth", "", "vHeight", "line", "", "lineHeight", "", "lineGap", "swipeable", "", "paddingLeft", "paddingRight", "marginLeft", "marginRight", "marginTop", "marginBottom", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getLine", "()Ljava/lang/Integer;", "setLine", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLineGap", "()Ljava/lang/Float;", "setLineGap", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getLineHeight", "()Ljava/util/List;", "setLineHeight", "(Ljava/util/List;)V", "getMarginBottom", "setMarginBottom", "getMarginLeft", "setMarginLeft", "getMarginRight", "setMarginRight", "getMarginTop", "setMarginTop", "getPaddingLeft", "setPaddingLeft", "getPaddingRight", "setPaddingRight", "getSwipeable", "()Ljava/lang/Boolean;", "setSwipeable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getVHeight", "setVHeight", "getVWidth", "setVWidth", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;", "equals", "other", "hashCode", "toString", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
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
    AppMethodBeat.i(313278);
    paramFloat1 = new KeyboardConfig(paramFloat1, paramFloat2, paramInteger, paramList, paramFloat3, paramBoolean, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
    AppMethodBeat.o(313278);
    return paramFloat1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(313291);
    if (this == paramObject)
    {
      AppMethodBeat.o(313291);
      return true;
    }
    if (!(paramObject instanceof KeyboardConfig))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    paramObject = (KeyboardConfig)paramObject;
    if (!s.p(this.vWidth, paramObject.vWidth))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    if (!s.p(this.vHeight, paramObject.vHeight))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    if (!s.p(this.line, paramObject.line))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    if (!s.p(this.lineHeight, paramObject.lineHeight))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    if (!s.p(this.lineGap, paramObject.lineGap))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    if (!s.p(this.swipeable, paramObject.swipeable))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    if (!s.p(this.paddingLeft, paramObject.paddingLeft))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    if (!s.p(this.paddingRight, paramObject.paddingRight))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    if (!s.p(this.marginLeft, paramObject.marginLeft))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    if (!s.p(this.marginRight, paramObject.marginRight))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    if (!s.p(this.marginTop, paramObject.marginTop))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    if (!s.p(this.marginBottom, paramObject.marginBottom))
    {
      AppMethodBeat.o(313291);
      return false;
    }
    AppMethodBeat.o(313291);
    return true;
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
    AppMethodBeat.i(313286);
    int i;
    int j;
    label26:
    int k;
    label35:
    int m;
    label45:
    int n;
    label55:
    int i1;
    label65:
    int i2;
    label75:
    int i3;
    label85:
    int i4;
    label95:
    int i5;
    label105:
    int i6;
    if (this.vWidth == null)
    {
      i = 0;
      if (this.vHeight != null) {
        break label204;
      }
      j = 0;
      if (this.line != null) {
        break label215;
      }
      k = 0;
      if (this.lineHeight != null) {
        break label226;
      }
      m = 0;
      if (this.lineGap != null) {
        break label238;
      }
      n = 0;
      if (this.swipeable != null) {
        break label250;
      }
      i1 = 0;
      if (this.paddingLeft != null) {
        break label262;
      }
      i2 = 0;
      if (this.paddingRight != null) {
        break label274;
      }
      i3 = 0;
      if (this.marginLeft != null) {
        break label286;
      }
      i4 = 0;
      if (this.marginRight != null) {
        break label298;
      }
      i5 = 0;
      if (this.marginTop != null) {
        break label310;
      }
      i6 = 0;
      label115:
      if (this.marginBottom != null) {
        break label322;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(313286);
      return (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i7;
      i = this.vWidth.hashCode();
      break;
      label204:
      j = this.vHeight.hashCode();
      break label26;
      label215:
      k = this.line.hashCode();
      break label35;
      label226:
      m = this.lineHeight.hashCode();
      break label45;
      label238:
      n = this.lineGap.hashCode();
      break label55;
      label250:
      i1 = this.swipeable.hashCode();
      break label65;
      label262:
      i2 = this.paddingLeft.hashCode();
      break label75;
      label274:
      i3 = this.paddingRight.hashCode();
      break label85;
      label286:
      i4 = this.marginLeft.hashCode();
      break label95;
      label298:
      i5 = this.marginRight.hashCode();
      break label105;
      label310:
      i6 = this.marginTop.hashCode();
      break label115;
      label322:
      i7 = this.marginBottom.hashCode();
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
    AppMethodBeat.i(313283);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("KeyboardConfig(vWidth=").append(this.vWidth).append(", vHeight=").append(this.vHeight).append(", line=").append(this.line).append(", lineHeight=").append(this.lineHeight).append(", lineGap=").append(this.lineGap).append(", swipeable=").append(this.swipeable).append(", paddingLeft=").append(this.paddingLeft).append(", paddingRight=").append(this.paddingRight).append(", marginLeft=").append(this.marginLeft).append(", marginRight=").append(this.marginRight).append(", marginTop=").append(this.marginTop).append(", marginBottom=");
    ((StringBuilder)localObject).append(this.marginBottom).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(313283);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardConfig
 * JD-Core Version:    0.7.0.1
 */