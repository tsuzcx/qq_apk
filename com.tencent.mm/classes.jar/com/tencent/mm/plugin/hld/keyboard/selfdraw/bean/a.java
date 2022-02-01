package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.c;
import com.tencent.mm.plugin.hld.model.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"getDataFromListSafe", "T", "dataList", "", "modeInt", "", "(Ljava/util/List;I)Ljava/lang/Object;", "getKeyData", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyOriginData;", "getKeyboardConfig", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginConfig;", "getKeyboardData", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginData;", "plugin-hld_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final <T> T R(List<? extends T> paramList, int paramInt)
  {
    AppMethodBeat.i(313145);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(313145);
      return null;
    }
    q localq = q.Jwz;
    if (q.YD(paramInt)) {
      if (!s.p(paramList.get(c.JsY.ordinal()), paramList.get(c.JsZ.ordinal()))) {
        paramInt = c.JsZ.ordinal();
      }
    }
    while ((paramInt >= paramList.size()) || (paramList.get(paramInt) == null))
    {
      paramList = paramList.get(0);
      AppMethodBeat.o(313145);
      return paramList;
      if (!s.p(paramList.get(c.JsY.ordinal()), paramList.get(c.Jta.ordinal())))
      {
        paramInt = c.Jta.ordinal();
      }
      else
      {
        paramInt = c.JsY.ordinal();
        continue;
        localq = q.Jwz;
        if (q.jt(paramInt, 1))
        {
          paramInt = c.JsZ.ordinal();
        }
        else
        {
          localq = q.Jwz;
          if (q.jt(paramInt, 2)) {
            paramInt = c.Jta.ordinal();
          } else {
            paramInt = c.JsY.ordinal();
          }
        }
      }
    }
    paramList = paramList.get(paramInt);
    AppMethodBeat.o(313145);
    return paramList;
  }
  
  private static KeyData a(KeyOriginData paramKeyOriginData, int paramInt)
  {
    AppMethodBeat.i(313136);
    s.u(paramKeyOriginData, "<this>");
    String str2 = (String)R(paramKeyOriginData.getId(), paramInt);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramKeyOriginData = new KeyData(str1, (Integer)R(paramKeyOriginData.getType(), paramInt), (String)R(paramKeyOriginData.getDrawerType(), paramInt), (String)R(paramKeyOriginData.getMainText(), paramInt), (Integer)R(paramKeyOriginData.getMainTextSize(), paramInt), (String)R(paramKeyOriginData.getMainTextColor(), paramInt), (String)R(paramKeyOriginData.getFloatText(), paramInt), (Integer)R(paramKeyOriginData.getFloatTextSize(), paramInt), (String)R(paramKeyOriginData.getFloatTextColor(), paramInt), (String)R(paramKeyOriginData.getImgSrc(), paramInt), (Float)R(paramKeyOriginData.getIconWidth(), paramInt), (Float)R(paramKeyOriginData.getIconHeight(), paramInt), (Float)R(paramKeyOriginData.getBgCorner(), paramInt), (String)R(paramKeyOriginData.getBgColor(), paramInt), (String)R(paramKeyOriginData.getShadowColor(), paramInt), (Float)R(paramKeyOriginData.getShadowHeight(), paramInt), (String)R(paramKeyOriginData.getInitialColor(), paramInt), (String)R(paramKeyOriginData.getPressMaskColor(), paramInt), (Float)R(paramKeyOriginData.getWidth(), paramInt), (Float)R(paramKeyOriginData.getHeight(), paramInt), (Float)R(paramKeyOriginData.getLeftMargin(), paramInt), (Float)R(paramKeyOriginData.getLeftPadding(), paramInt), (Float)R(paramKeyOriginData.getTopMargin(), paramInt), (Float)R(paramKeyOriginData.getTopPadding(), paramInt), (Float)R(paramKeyOriginData.getBottomPadding(), paramInt), (Float)R(paramKeyOriginData.getRightMargin(), paramInt), (Float)R(paramKeyOriginData.getRightPadding(), paramInt), (Boolean)R(paramKeyOriginData.getClickable(), paramInt), (Boolean)R(paramKeyOriginData.getLongClickable(), paramInt), (Integer)R(paramKeyOriginData.getTouchFunctionCode(), paramInt), (Integer)R(paramKeyOriginData.getClickFunctionCode(), paramInt), (Integer)R(paramKeyOriginData.getLongClickFunctionCode(), paramInt), (Boolean)R(paramKeyOriginData.getSwipeable(), paramInt));
    AppMethodBeat.o(313136);
    return paramKeyOriginData;
  }
  
  public static final KeyboardData a(KeyboardOriginData paramKeyboardOriginData, int paramInt)
  {
    AppMethodBeat.i(313127);
    s.u(paramKeyboardOriginData, "<this>");
    Object localObject1 = paramKeyboardOriginData.getConfig();
    s.u(localObject1, "<this>");
    localObject1 = new KeyboardConfig((Float)R(((KeyboardOriginConfig)localObject1).getVWidth(), paramInt), (Float)R(((KeyboardOriginConfig)localObject1).getVHeight(), paramInt), (Integer)R(((KeyboardOriginConfig)localObject1).getLine(), paramInt), ((KeyboardOriginConfig)localObject1).getLineHeight(), (Float)R(((KeyboardOriginConfig)localObject1).getLineGap(), paramInt), (Boolean)R(((KeyboardOriginConfig)localObject1).getSwipeable(), paramInt), (Float)R(((KeyboardOriginConfig)localObject1).getPaddingLeft(), paramInt), (Float)R(((KeyboardOriginConfig)localObject1).getPaddingRight(), paramInt), (Float)R(((KeyboardOriginConfig)localObject1).getMarginLeft(), paramInt), (Float)R(((KeyboardOriginConfig)localObject1).getMarginRight(), paramInt), (Float)R(((KeyboardOriginConfig)localObject1).getMarginTop(), paramInt), (Float)R(((KeyboardOriginConfig)localObject1).getMarginBottom(), paramInt));
    KeyData localKeyData = a(paramKeyboardOriginData.getKeyDefaultConfig(), paramInt);
    Object localObject2 = (Iterable)paramKeyboardOriginData.getKeys();
    paramKeyboardOriginData = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Iterable)((Iterator)localObject2).next();
      Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localCollection.add(a((KeyOriginData)((Iterator)localObject3).next(), paramInt));
      }
      paramKeyboardOriginData.add((List)localCollection);
    }
    paramKeyboardOriginData = new KeyboardData((KeyboardConfig)localObject1, localKeyData, (List)paramKeyboardOriginData);
    AppMethodBeat.o(313127);
    return paramKeyboardOriginData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.a
 * JD-Core Version:    0.7.0.1
 */