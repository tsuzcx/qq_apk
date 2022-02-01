package com.tencent.mm.plugin.hld.keyboard.selfdraw;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "", "parent", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "bgCorner", "getBgCorner", "setBgCorner", "clickFunctionCode", "getClickFunctionCode", "setClickFunctionCode", "clickable", "", "getClickable", "()Z", "setClickable", "(Z)V", "drawRect", "Landroid/graphics/Rect;", "getDrawRect", "()Landroid/graphics/Rect;", "setDrawRect", "(Landroid/graphics/Rect;)V", "drawerType", "", "getDrawerType", "()Ljava/lang/String;", "setDrawerType", "(Ljava/lang/String;)V", "floatText", "getFloatText", "setFloatText", "floatTextColor", "getFloatTextColor", "setFloatTextColor", "floatTextSize", "getFloatTextSize", "setFloatTextSize", "height", "getHeight", "setHeight", "hitRect", "getHitRect", "setHitRect", "iconHeight", "getIconHeight", "setIconHeight", "iconWidth", "getIconWidth", "setIconWidth", "id", "getId", "setId", "imgSrc", "getImgSrc", "setImgSrc", "initialColor", "getInitialColor", "setInitialColor", "longClickFunctionCode", "getLongClickFunctionCode", "setLongClickFunctionCode", "longClickListener", "Lkotlin/Function1;", "longClickable", "getLongClickable", "setLongClickable", "mainText", "getMainText", "setMainText", "mainTextColor", "getMainTextColor", "setMainTextColor", "mainTextSize", "getMainTextSize", "setMainTextSize", "onButtonPressListener", "", "onButtonUpListener", "onClickListener", "getParent", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "pressMaskColor", "getPressMaskColor", "setPressMaskColor", "shadowColor", "getShadowColor", "setShadowColor", "shadowHeight", "getShadowHeight", "setShadowHeight", "value", "status", "getStatus", "setStatus", "swipeable", "getSwipeable", "setSwipeable", "touchFunctionCode", "getTouchFunctionCode", "setTouchFunctionCode", "type", "getType", "setType", "width", "getWidth", "setWidth", "callOnClick", "callOnLongClick", "callOnPress", "callOnUp", "isHit", "x", "y", "onStatusChange", "old", "new", "reset", "selected", "setOnButtonPressListener", "l", "setOnButtonUpListener", "setOnClickListener", "setOnLongClickListener", "plugin-hld_release"})
public final class b
{
  public Rect DzC;
  public Rect DzD;
  public int DzE;
  public int DzF;
  public int DzG;
  public int DzH;
  public int DzI;
  public int DzJ;
  public int DzK;
  int DzL;
  public int DzM;
  int DzN;
  boolean DzO;
  int DzP;
  boolean DzQ;
  public int DzR;
  kotlin.g.a.b<? super b, Boolean> DzS;
  kotlin.g.a.b<? super b, x> DzT;
  kotlin.g.a.b<? super b, x> DzU;
  kotlin.g.a.b<? super b, x> DzV;
  private final KeyboardView DzW;
  public int bgColor;
  String drawerType;
  public String floatText;
  int height;
  public int iconHeight;
  public int iconWidth;
  public String id;
  public String mainText;
  boolean oYn;
  public String sSq;
  public int shadowColor;
  public int type;
  public int width;
  
  public b(KeyboardView paramKeyboardView)
  {
    AppMethodBeat.i(209943);
    this.DzW = paramKeyboardView;
    this.id = "";
    this.DzC = new Rect();
    this.DzD = new Rect();
    this.drawerType = "";
    this.mainText = "";
    this.floatText = "";
    this.DzN = -1;
    this.DzP = -1;
    this.DzR = -1;
    this.sSq = "initial";
    AppMethodBeat.o(209943);
  }
  
  final void aqA(String paramString)
  {
    AppMethodBeat.i(209932);
    this.sSq = paramString;
    this.DzW.invalidate();
    AppMethodBeat.o(209932);
  }
  
  public final void eDN()
  {
    AppMethodBeat.i(209935);
    aqA("initial");
    kotlin.g.a.b localb = this.DzV;
    if (localb != null)
    {
      localb.invoke(this);
      AppMethodBeat.o(209935);
      return;
    }
    AppMethodBeat.o(209935);
  }
  
  public final boolean hK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209928);
    boolean bool = this.DzC.contains(paramInt1, paramInt2);
    AppMethodBeat.o(209928);
    return bool;
  }
  
  public final void sP(boolean paramBoolean)
  {
    AppMethodBeat.i(209939);
    if (paramBoolean) {}
    for (String str = "press";; str = "initial")
    {
      aqA(str);
      AppMethodBeat.o(209939);
      return;
    }
  }
  
  public final void setDrawerType(String paramString)
  {
    AppMethodBeat.i(209923);
    p.k(paramString, "<set-?>");
    this.drawerType = paramString;
    AppMethodBeat.o(209923);
  }
  
  public final void setFloatText(String paramString)
  {
    AppMethodBeat.i(209925);
    p.k(paramString, "<set-?>");
    this.floatText = paramString;
    AppMethodBeat.o(209925);
  }
  
  public final void setId(String paramString)
  {
    AppMethodBeat.i(209922);
    p.k(paramString, "<set-?>");
    this.id = paramString;
    AppMethodBeat.o(209922);
  }
  
  public final void setMainText(String paramString)
  {
    AppMethodBeat.i(209924);
    p.k(paramString, "<set-?>");
    this.mainText = paramString;
    AppMethodBeat.o(209924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.b
 * JD-Core Version:    0.7.0.1
 */