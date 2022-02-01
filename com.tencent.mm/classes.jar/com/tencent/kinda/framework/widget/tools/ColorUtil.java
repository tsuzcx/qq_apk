package com.tencent.kinda.framework.widget.tools;

import android.util.Pair;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Iterator;

public class ColorUtil
{
  public static long MergeColors(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(19320);
    long l1 = paramLong1;
    if (paramLong1 < 0L) {
      l1 = absColor(paramLong1);
    }
    paramLong1 = paramLong2;
    if (paramLong2 < 0L) {
      paramLong1 = absColor(paramLong2);
    }
    long l2 = getAlpha(l1);
    paramLong2 = l2;
    if (l2 == 0L) {
      paramLong2 = 255L;
    }
    long l3 = getRed(l1);
    l2 = getGreen(l1);
    l1 = getBlue(l1);
    long l6 = getAlpha(paramLong1);
    long l5 = getRed(paramLong1);
    long l4 = getGreen(paramLong1);
    paramLong1 = getBlue(paramLong1);
    double d1 = (float)l6 / 255.0F;
    double d2 = l6;
    paramLong2 = (paramLong2 * (1.0D - d1) + d2);
    d2 = l5;
    l3 = (l3 * (1.0D - d1) + d2 * d1);
    d2 = l4;
    l2 = (l2 * (1.0D - d1) + d2 * d1);
    d2 = paramLong1;
    paramLong1 = (l1 * (1.0D - d1) + d2 * d1);
    AppMethodBeat.o(19320);
    return paramLong2 << 24 | l3 << 16 | l2 << 8 | paramLong1;
  }
  
  public static long absColor(long paramLong)
  {
    AppMethodBeat.i(19321);
    if (paramLong >= 0L)
    {
      AppMethodBeat.o(19321);
      return paramLong;
    }
    paramLong = Math.abs(1L + paramLong);
    Object localObject = new ArrayList();
    while (paramLong > 16L)
    {
      ((ArrayList)localObject).add(Integer.valueOf((int)(paramLong - (paramLong >> 4 << 4))));
      paramLong >>= 4;
    }
    ((ArrayList)localObject).add(Integer.valueOf((int)paramLong));
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Integer.valueOf(15 - ((Integer)((Iterator)localObject).next()).intValue()));
    }
    int i = localArrayList.size();
    paramLong = 0L;
    i -= 1;
    while (i >= 0)
    {
      paramLong = paramLong * 16L + ((Integer)localArrayList.get(i)).intValue();
      i -= 1;
    }
    AppMethodBeat.o(19321);
    return paramLong;
  }
  
  public static DynamicColor compatKindaDarkMode(DynamicColor paramDynamicColor, MMViewType paramMMViewType)
  {
    AppMethodBeat.i(19326);
    if (paramDynamicColor == null)
    {
      AppMethodBeat.o(19326);
      return paramDynamicColor;
    }
    int i = ((b)g.ab(b.class)).a(b.a.qyc, 1);
    if (i == 1) {
      switch (1.$SwitchMap$com$tencent$kinda$framework$widget$tools$ColorUtil$MMViewType[paramMMViewType.ordinal()])
      {
      default: 
        paramMMViewType = new Pair(Boolean.FALSE, Long.valueOf(0L));
        if (((Boolean)paramMMViewType.first).booleanValue()) {
          paramDynamicColor.mDarkmodeColor = ((Long)paramMMViewType.second).longValue();
        }
        break;
      }
    }
    for (;;)
    {
      if (i.DEBUG) {
        ad.i("base_MMKView", "compatKindaDarkMode() swt:%s. (mNormalColor:%s mDarkmodeColor:%s)", new Object[] { Integer.valueOf(i), Long.toHexString(absColor(paramDynamicColor.mNormalColor)), Long.toHexString(absColor(paramDynamicColor.mDarkmodeColor)) });
      }
      AppMethodBeat.o(19326);
      return paramDynamicColor;
      paramMMViewType = ColorCompatUtil.getDarkModeColorMMKButtonText(paramDynamicColor.getNormalColor());
      break;
      paramMMViewType = ColorCompatUtil.getDarkModeColorMMKRichLabelView(paramDynamicColor.getNormalColor());
      break;
      paramMMViewType = ColorCompatUtil.getDarkModeColorMMKLabelViewText(paramDynamicColor.getNormalColor());
      break;
      if ((paramDynamicColor.getDarkmodeColor() == -1L) || (paramDynamicColor.getNormalColor() == paramDynamicColor.getDarkmodeColor())) {
        paramDynamicColor.mDarkmodeColor = ColorCompatUtil.getDarkModeColor(paramDynamicColor.getNormalColor(), paramDynamicColor.getDarkmodeColor());
      } else if ((paramDynamicColor.getNormalColor() == -1L) && (paramDynamicColor.getDarkmodeColor() == 0L)) {
        paramDynamicColor.mDarkmodeColor = Long.parseLong("ffFFFFFF", 16);
      }
    }
  }
  
  private static boolean compatKindaDarkModeDefaultColorSw()
  {
    AppMethodBeat.i(19327);
    if (((b)g.ab(b.class)).a(b.a.qye, 1) == 1)
    {
      AppMethodBeat.o(19327);
      return true;
    }
    AppMethodBeat.o(19327);
    return false;
  }
  
  private static long getAlpha(long paramLong)
  {
    return paramLong >> 24;
  }
  
  private static long getBlue(long paramLong)
  {
    return paramLong - (paramLong >> 8 << 8);
  }
  
  public static long getColorByMode(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(19324);
    long l = getColorByMode(paramDynamicColor, true);
    AppMethodBeat.o(19324);
    return l;
  }
  
  public static long getColorByMode(DynamicColor paramDynamicColor, MMViewType paramMMViewType)
  {
    AppMethodBeat.i(19325);
    if (paramDynamicColor == null)
    {
      if (i.DEBUG) {
        ad.d("base_MMKView", "getColorByMode() dynamicColor == null");
      }
      AppMethodBeat.o(19325);
      return 0L;
    }
    if (i.DEBUG) {
      ad.d("base_MMKView", "getColorByMode(mNormalColor:%s mDarkmodeColor:%s) %s", new Object[] { Long.toHexString(absColor(paramDynamicColor.mNormalColor)), Long.toHexString(absColor(paramDynamicColor.mDarkmodeColor)), bt.flS() });
    }
    if (al.isDarkMode())
    {
      l = compatKindaDarkMode(paramDynamicColor, paramMMViewType).getDarkmodeColor();
      AppMethodBeat.o(19325);
      return l;
    }
    long l = paramDynamicColor.mNormalColor;
    AppMethodBeat.o(19325);
    return l;
  }
  
  public static long getColorByMode(DynamicColor paramDynamicColor, boolean paramBoolean)
  {
    AppMethodBeat.i(162116);
    long l = getColorByMode(paramDynamicColor, MMViewType.NONE);
    if ((paramBoolean) && (l == -1L) && (al.isDarkMode()))
    {
      l = al.gD((int)paramDynamicColor.mNormalColor);
      AppMethodBeat.o(162116);
      return l;
    }
    AppMethodBeat.o(162116);
    return l;
  }
  
  public static long getColorByMode(String paramString)
  {
    AppMethodBeat.i(19323);
    DynamicColor localDynamicColor = new DynamicColor();
    localDynamicColor.mNormalColor = Long.parseLong(paramString, 16);
    localDynamicColor.mDarkmodeColor = Long.parseLong(paramString, 16);
    long l = getColorByMode(localDynamicColor);
    AppMethodBeat.o(19323);
    return l;
  }
  
  public static long getColorByModeNoCompat(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(19322);
    if (paramDynamicColor == null)
    {
      if (i.DEBUG) {
        ad.d("base_MMKView", "getColorByModeNoCompat() dynamicColor == null");
      }
      AppMethodBeat.o(19322);
      return 0L;
    }
    if (al.isDarkMode())
    {
      l = paramDynamicColor.getDarkmodeColor();
      AppMethodBeat.o(19322);
      return l;
    }
    long l = paramDynamicColor.getNormalColor();
    AppMethodBeat.o(19322);
    return l;
  }
  
  private static long getGreen(long paramLong)
  {
    return (paramLong >> 8) - (paramLong >> 16 << 8);
  }
  
  private static long getRed(long paramLong)
  {
    return (paramLong >> 16) - (paramLong >> 24 << 8);
  }
  
  public static boolean ifCompatKindaDarkModeDefaultColor()
  {
    AppMethodBeat.i(19328);
    if ((al.isDarkMode()) && (compatKindaDarkModeDefaultColorSw()))
    {
      AppMethodBeat.o(19328);
      return true;
    }
    AppMethodBeat.o(19328);
    return false;
  }
  
  public static enum MMViewType
  {
    static
    {
      AppMethodBeat.i(19319);
      NONE = new MMViewType("NONE", 0);
      MMKButtonText = new MMViewType("MMKButtonText", 1);
      MMKEditText = new MMViewType("MMKEditText", 2);
      MMKImageView = new MMViewType("MMKImageView", 3);
      MMKLabelViewText = new MMViewType("MMKLabelViewText", 4);
      MMKRichLabelView = new MMViewType("MMKRichLabelView", 5);
      $VALUES = new MMViewType[] { NONE, MMKButtonText, MMKEditText, MMKImageView, MMKLabelViewText, MMKRichLabelView };
      AppMethodBeat.o(19319);
    }
    
    private MMViewType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.ColorUtil
 * JD-Core Version:    0.7.0.1
 */