package com.tencent.mm.plugin.hld.keyboard.selfdraw;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "", "parent", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "bgCorner", "getBgCorner", "setBgCorner", "clickFunctionCode", "getClickFunctionCode", "setClickFunctionCode", "clickable", "", "getClickable", "()Z", "setClickable", "(Z)V", "drawRect", "Landroid/graphics/Rect;", "getDrawRect", "()Landroid/graphics/Rect;", "setDrawRect", "(Landroid/graphics/Rect;)V", "drawerType", "", "getDrawerType", "()Ljava/lang/String;", "setDrawerType", "(Ljava/lang/String;)V", "floatText", "getFloatText", "setFloatText", "floatTextColor", "getFloatTextColor", "setFloatTextColor", "floatTextSize", "getFloatTextSize", "setFloatTextSize", "height", "getHeight", "setHeight", "hitRect", "getHitRect", "setHitRect", "iconHeight", "getIconHeight", "setIconHeight", "iconWidth", "getIconWidth", "setIconWidth", "id", "getId", "setId", "imgSrc", "getImgSrc", "setImgSrc", "initialColor", "getInitialColor", "setInitialColor", "longClickFunctionCode", "getLongClickFunctionCode", "setLongClickFunctionCode", "longClickListener", "Lkotlin/Function1;", "longClickable", "getLongClickable", "setLongClickable", "mainText", "getMainText", "setMainText", "mainTextColor", "getMainTextColor", "setMainTextColor", "mainTextSize", "getMainTextSize", "setMainTextSize", "onButtonPressListener", "", "onButtonUpListener", "onClickListener", "getParent", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "pressMaskColor", "getPressMaskColor", "setPressMaskColor", "shadowColor", "getShadowColor", "setShadowColor", "shadowHeight", "getShadowHeight", "setShadowHeight", "value", "status", "getStatus", "setStatus", "swipeable", "getSwipeable", "setSwipeable", "touchFunctionCode", "getTouchFunctionCode", "setTouchFunctionCode", "type", "getType", "setType", "width", "getWidth", "setWidth", "callOnClick", "callOnLongClick", "callOnPress", "callOnUp", "isHit", "x", "y", "onStatusChange", "old", "new", "reset", "selected", "setOnButtonPressListener", "l", "setOnButtonUpListener", "setOnClickListener", "setOnLongClickListener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  kotlin.g.a.b<? super b, ah> Hop;
  private final KeyboardView JsE;
  public Rect JsF;
  public Rect JsG;
  public int JsH;
  public int JsI;
  public int JsJ;
  public int JsK;
  public int JsL;
  public int JsM;
  public int JsN;
  int JsO;
  public int JsP;
  int JsQ;
  boolean JsR;
  int JsS;
  boolean JsT;
  public int JsU;
  kotlin.g.a.b<? super b, Boolean> JsV;
  kotlin.g.a.b<? super b, ah> JsW;
  kotlin.g.a.b<? super b, ah> JsX;
  public int bgColor;
  String drawerType;
  public String floatText;
  int height;
  public int iconHeight;
  public int iconWidth;
  public String id;
  public String mainText;
  boolean sdN;
  public int shadowColor;
  public int type;
  public String vXL;
  public int width;
  
  public b(KeyboardView paramKeyboardView)
  {
    AppMethodBeat.i(313032);
    this.JsE = paramKeyboardView;
    this.id = "";
    this.JsF = new Rect();
    this.JsG = new Rect();
    this.drawerType = "";
    this.mainText = "";
    this.floatText = "";
    this.JsQ = -1;
    this.JsS = -1;
    this.JsU = -1;
    this.vXL = "initial";
    AppMethodBeat.o(313032);
  }
  
  final void ajZ(String paramString)
  {
    AppMethodBeat.i(313076);
    this.vXL = paramString;
    this.JsE.invalidate();
    AppMethodBeat.o(313076);
  }
  
  public final void fLQ()
  {
    AppMethodBeat.i(313083);
    ajZ("initial");
    kotlin.g.a.b localb = this.JsX;
    if (localb != null) {
      localb.invoke(this);
    }
    AppMethodBeat.o(313083);
  }
  
  public final boolean jo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(313068);
    boolean bool = this.JsF.contains(paramInt1, paramInt2);
    AppMethodBeat.o(313068);
    return bool;
  }
  
  public final void setDrawerType(String paramString)
  {
    AppMethodBeat.i(313044);
    s.u(paramString, "<set-?>");
    this.drawerType = paramString;
    AppMethodBeat.o(313044);
  }
  
  public final void setFloatText(String paramString)
  {
    AppMethodBeat.i(313060);
    s.u(paramString, "<set-?>");
    this.floatText = paramString;
    AppMethodBeat.o(313060);
  }
  
  public final void setId(String paramString)
  {
    AppMethodBeat.i(313039);
    s.u(paramString, "<set-?>");
    this.id = paramString;
    AppMethodBeat.o(313039);
  }
  
  public final void setMainText(String paramString)
  {
    AppMethodBeat.i(313054);
    s.u(paramString, "<set-?>");
    this.mainText = paramString;
    AppMethodBeat.o(313054);
  }
  
  public final void wV(boolean paramBoolean)
  {
    AppMethodBeat.i(313091);
    if (paramBoolean) {}
    for (String str = "press";; str = "initial")
    {
      ajZ(str);
      AppMethodBeat.o(313091);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.b
 * JD-Core Version:    0.7.0.1
 */