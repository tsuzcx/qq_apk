package com.tencent.mm.plugin.hld.keyboard.selfdraw.bean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.c;
import com.tencent.mm.plugin.hld.model.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getDataFromListSafe", "T", "dataList", "", "modeInt", "", "(Ljava/util/List;I)Ljava/lang/Object;", "getKeyData", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyData;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyOriginData;", "getKeyboardConfig", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginConfig;", "getKeyboardData", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginData;", "plugin-hld_release"})
public final class a
{
  private static KeyData a(KeyOriginData paramKeyOriginData, int paramInt)
  {
    AppMethodBeat.i(210014);
    p.k(paramKeyOriginData, "$this$getKeyData");
    String str2 = (String)y(paramKeyOriginData.getId(), paramInt);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramKeyOriginData = new KeyData(str1, (Integer)y(paramKeyOriginData.getType(), paramInt), (String)y(paramKeyOriginData.getDrawerType(), paramInt), (String)y(paramKeyOriginData.getMainText(), paramInt), (Integer)y(paramKeyOriginData.getMainTextSize(), paramInt), (String)y(paramKeyOriginData.getMainTextColor(), paramInt), (String)y(paramKeyOriginData.getFloatText(), paramInt), (Integer)y(paramKeyOriginData.getFloatTextSize(), paramInt), (String)y(paramKeyOriginData.getFloatTextColor(), paramInt), (String)y(paramKeyOriginData.getImgSrc(), paramInt), (Float)y(paramKeyOriginData.getIconWidth(), paramInt), (Float)y(paramKeyOriginData.getIconHeight(), paramInt), (Float)y(paramKeyOriginData.getBgCorner(), paramInt), (String)y(paramKeyOriginData.getBgColor(), paramInt), (String)y(paramKeyOriginData.getShadowColor(), paramInt), (Float)y(paramKeyOriginData.getShadowHeight(), paramInt), (String)y(paramKeyOriginData.getInitialColor(), paramInt), (String)y(paramKeyOriginData.getPressMaskColor(), paramInt), (Float)y(paramKeyOriginData.getWidth(), paramInt), (Float)y(paramKeyOriginData.getHeight(), paramInt), (Float)y(paramKeyOriginData.getLeftMargin(), paramInt), (Float)y(paramKeyOriginData.getLeftPadding(), paramInt), (Float)y(paramKeyOriginData.getTopMargin(), paramInt), (Float)y(paramKeyOriginData.getTopPadding(), paramInt), (Float)y(paramKeyOriginData.getBottomPadding(), paramInt), (Float)y(paramKeyOriginData.getRightMargin(), paramInt), (Float)y(paramKeyOriginData.getRightPadding(), paramInt), (Boolean)y(paramKeyOriginData.getClickable(), paramInt), (Boolean)y(paramKeyOriginData.getLongClickable(), paramInt), (Integer)y(paramKeyOriginData.getTouchFunctionCode(), paramInt), (Integer)y(paramKeyOriginData.getClickFunctionCode(), paramInt), (Integer)y(paramKeyOriginData.getLongClickFunctionCode(), paramInt), (Boolean)y(paramKeyOriginData.getSwipeable(), paramInt));
    AppMethodBeat.o(210014);
    return paramKeyOriginData;
  }
  
  public static final KeyboardData a(KeyboardOriginData paramKeyboardOriginData, int paramInt)
  {
    AppMethodBeat.i(210013);
    p.k(paramKeyboardOriginData, "$this$getKeyboardData");
    Object localObject1 = paramKeyboardOriginData.getConfig();
    p.k(localObject1, "$this$getKeyboardConfig");
    localObject1 = new KeyboardConfig((Float)y(((KeyboardOriginConfig)localObject1).getVWidth(), paramInt), (Float)y(((KeyboardOriginConfig)localObject1).getVHeight(), paramInt), (Integer)y(((KeyboardOriginConfig)localObject1).getLine(), paramInt), ((KeyboardOriginConfig)localObject1).getLineHeight(), (Float)y(((KeyboardOriginConfig)localObject1).getLineGap(), paramInt), (Boolean)y(((KeyboardOriginConfig)localObject1).getSwipeable(), paramInt), (Float)y(((KeyboardOriginConfig)localObject1).getPaddingLeft(), paramInt), (Float)y(((KeyboardOriginConfig)localObject1).getPaddingRight(), paramInt), (Float)y(((KeyboardOriginConfig)localObject1).getMarginLeft(), paramInt), (Float)y(((KeyboardOriginConfig)localObject1).getMarginRight(), paramInt), (Float)y(((KeyboardOriginConfig)localObject1).getMarginTop(), paramInt), (Float)y(((KeyboardOriginConfig)localObject1).getMarginBottom(), paramInt));
    KeyData localKeyData = a(paramKeyboardOriginData.getKeyDefaultConfig(), paramInt);
    Object localObject2 = (Iterable)paramKeyboardOriginData.getKeys();
    paramKeyboardOriginData = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Iterable)((Iterator)localObject2).next();
      Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localCollection.add(a((KeyOriginData)((Iterator)localObject3).next(), paramInt));
      }
      paramKeyboardOriginData.add((List)localCollection);
    }
    paramKeyboardOriginData = new KeyboardData((KeyboardConfig)localObject1, localKeyData, (List)paramKeyboardOriginData);
    AppMethodBeat.o(210013);
    return paramKeyboardOriginData;
  }
  
  private static final <T> T y(List<? extends T> paramList, int paramInt)
  {
    AppMethodBeat.i(210015);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(210015);
      return null;
    }
    r localr = r.DEQ;
    if (r.UF(paramInt)) {
      if ((p.h(paramList.get(c.DzX.ordinal()), paramList.get(c.DzY.ordinal())) ^ true)) {
        paramInt = c.DzY.ordinal();
      }
    }
    while ((paramInt >= paramList.size()) || (paramList.get(paramInt) == null))
    {
      paramList = paramList.get(0);
      AppMethodBeat.o(210015);
      return paramList;
      if ((p.h(paramList.get(c.DzX.ordinal()), paramList.get(c.DzZ.ordinal())) ^ true))
      {
        paramInt = c.DzZ.ordinal();
      }
      else
      {
        paramInt = c.DzX.ordinal();
        continue;
        localr = r.DEQ;
        if (r.hP(paramInt, 1))
        {
          paramInt = c.DzY.ordinal();
        }
        else
        {
          localr = r.DEQ;
          if (r.hP(paramInt, 2)) {
            paramInt = c.DzZ.ordinal();
          } else {
            paramInt = c.DzX.ordinal();
          }
        }
      }
    }
    paramList = paramList.get(paramInt);
    AppMethodBeat.o(210015);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.a
 * JD-Core Version:    0.7.0.1
 */