package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private static final Pattern byJ;
  private static final Pattern byK;
  private static final Pattern byL;
  private static final Map<String, Integer> byM;
  
  static
  {
    AppMethodBeat.i(93132);
    byJ = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    byK = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    byL = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    HashMap localHashMap = new HashMap();
    byM = localHashMap;
    localHashMap.put("aliceblue", Integer.valueOf(-984833));
    byM.put("antiquewhite", Integer.valueOf(-332841));
    byM.put("aqua", Integer.valueOf(-16711681));
    byM.put("aquamarine", Integer.valueOf(-8388652));
    byM.put("azure", Integer.valueOf(-983041));
    byM.put("beige", Integer.valueOf(-657956));
    byM.put("bisque", Integer.valueOf(-6972));
    byM.put("black", Integer.valueOf(-16777216));
    byM.put("blanchedalmond", Integer.valueOf(-5171));
    byM.put("blue", Integer.valueOf(-16776961));
    byM.put("blueviolet", Integer.valueOf(-7722014));
    byM.put("brown", Integer.valueOf(-5952982));
    byM.put("burlywood", Integer.valueOf(-2180985));
    byM.put("cadetblue", Integer.valueOf(-10510688));
    byM.put("chartreuse", Integer.valueOf(-8388864));
    byM.put("chocolate", Integer.valueOf(-2987746));
    byM.put("coral", Integer.valueOf(-32944));
    byM.put("cornflowerblue", Integer.valueOf(-10185235));
    byM.put("cornsilk", Integer.valueOf(-1828));
    byM.put("crimson", Integer.valueOf(-2354116));
    byM.put("cyan", Integer.valueOf(-16711681));
    byM.put("darkblue", Integer.valueOf(-16777077));
    byM.put("darkcyan", Integer.valueOf(-16741493));
    byM.put("darkgoldenrod", Integer.valueOf(-4684277));
    byM.put("darkgray", Integer.valueOf(-5658199));
    byM.put("darkgreen", Integer.valueOf(-16751616));
    byM.put("darkgrey", Integer.valueOf(-5658199));
    byM.put("darkkhaki", Integer.valueOf(-4343957));
    byM.put("darkmagenta", Integer.valueOf(-7667573));
    byM.put("darkolivegreen", Integer.valueOf(-11179217));
    byM.put("darkorange", Integer.valueOf(-29696));
    byM.put("darkorchid", Integer.valueOf(-6737204));
    byM.put("darkred", Integer.valueOf(-7667712));
    byM.put("darksalmon", Integer.valueOf(-1468806));
    byM.put("darkseagreen", Integer.valueOf(-7357297));
    byM.put("darkslateblue", Integer.valueOf(-12042869));
    byM.put("darkslategray", Integer.valueOf(-13676721));
    byM.put("darkslategrey", Integer.valueOf(-13676721));
    byM.put("darkturquoise", Integer.valueOf(-16724271));
    byM.put("darkviolet", Integer.valueOf(-7077677));
    byM.put("deeppink", Integer.valueOf(-60269));
    byM.put("deepskyblue", Integer.valueOf(-16728065));
    byM.put("dimgray", Integer.valueOf(-9868951));
    byM.put("dimgrey", Integer.valueOf(-9868951));
    byM.put("dodgerblue", Integer.valueOf(-14774017));
    byM.put("firebrick", Integer.valueOf(-5103070));
    byM.put("floralwhite", Integer.valueOf(-1296));
    byM.put("forestgreen", Integer.valueOf(-14513374));
    byM.put("fuchsia", Integer.valueOf(-65281));
    byM.put("gainsboro", Integer.valueOf(-2302756));
    byM.put("ghostwhite", Integer.valueOf(-460545));
    byM.put("gold", Integer.valueOf(-10496));
    byM.put("goldenrod", Integer.valueOf(-2448096));
    byM.put("gray", Integer.valueOf(-8355712));
    byM.put("green", Integer.valueOf(-16744448));
    byM.put("greenyellow", Integer.valueOf(-5374161));
    byM.put("grey", Integer.valueOf(-8355712));
    byM.put("honeydew", Integer.valueOf(-983056));
    byM.put("hotpink", Integer.valueOf(-38476));
    byM.put("indianred", Integer.valueOf(-3318692));
    byM.put("indigo", Integer.valueOf(-11861886));
    byM.put("ivory", Integer.valueOf(-16));
    byM.put("khaki", Integer.valueOf(-989556));
    byM.put("lavender", Integer.valueOf(-1644806));
    byM.put("lavenderblush", Integer.valueOf(-3851));
    byM.put("lawngreen", Integer.valueOf(-8586240));
    byM.put("lemonchiffon", Integer.valueOf(-1331));
    byM.put("lightblue", Integer.valueOf(-5383962));
    byM.put("lightcoral", Integer.valueOf(-1015680));
    byM.put("lightcyan", Integer.valueOf(-2031617));
    byM.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    byM.put("lightgray", Integer.valueOf(-2894893));
    byM.put("lightgreen", Integer.valueOf(-7278960));
    byM.put("lightgrey", Integer.valueOf(-2894893));
    byM.put("lightpink", Integer.valueOf(-18751));
    byM.put("lightsalmon", Integer.valueOf(-24454));
    byM.put("lightseagreen", Integer.valueOf(-14634326));
    byM.put("lightskyblue", Integer.valueOf(-7876870));
    byM.put("lightslategray", Integer.valueOf(-8943463));
    byM.put("lightslategrey", Integer.valueOf(-8943463));
    byM.put("lightsteelblue", Integer.valueOf(-5192482));
    byM.put("lightyellow", Integer.valueOf(-32));
    byM.put("lime", Integer.valueOf(-16711936));
    byM.put("limegreen", Integer.valueOf(-13447886));
    byM.put("linen", Integer.valueOf(-331546));
    byM.put("magenta", Integer.valueOf(-65281));
    byM.put("maroon", Integer.valueOf(-8388608));
    byM.put("mediumaquamarine", Integer.valueOf(-10039894));
    byM.put("mediumblue", Integer.valueOf(-16777011));
    byM.put("mediumorchid", Integer.valueOf(-4565549));
    byM.put("mediumpurple", Integer.valueOf(-7114533));
    byM.put("mediumseagreen", Integer.valueOf(-12799119));
    byM.put("mediumslateblue", Integer.valueOf(-8689426));
    byM.put("mediumspringgreen", Integer.valueOf(-16713062));
    byM.put("mediumturquoise", Integer.valueOf(-12004916));
    byM.put("mediumvioletred", Integer.valueOf(-3730043));
    byM.put("midnightblue", Integer.valueOf(-15132304));
    byM.put("mintcream", Integer.valueOf(-655366));
    byM.put("mistyrose", Integer.valueOf(-6943));
    byM.put("moccasin", Integer.valueOf(-6987));
    byM.put("navajowhite", Integer.valueOf(-8531));
    byM.put("navy", Integer.valueOf(-16777088));
    byM.put("oldlace", Integer.valueOf(-133658));
    byM.put("olive", Integer.valueOf(-8355840));
    byM.put("olivedrab", Integer.valueOf(-9728477));
    byM.put("orange", Integer.valueOf(-23296));
    byM.put("orangered", Integer.valueOf(-47872));
    byM.put("orchid", Integer.valueOf(-2461482));
    byM.put("palegoldenrod", Integer.valueOf(-1120086));
    byM.put("palegreen", Integer.valueOf(-6751336));
    byM.put("paleturquoise", Integer.valueOf(-5247250));
    byM.put("palevioletred", Integer.valueOf(-2396013));
    byM.put("papayawhip", Integer.valueOf(-4139));
    byM.put("peachpuff", Integer.valueOf(-9543));
    byM.put("peru", Integer.valueOf(-3308225));
    byM.put("pink", Integer.valueOf(-16181));
    byM.put("plum", Integer.valueOf(-2252579));
    byM.put("powderblue", Integer.valueOf(-5185306));
    byM.put("purple", Integer.valueOf(-8388480));
    byM.put("rebeccapurple", Integer.valueOf(-10079335));
    byM.put("red", Integer.valueOf(-65536));
    byM.put("rosybrown", Integer.valueOf(-4419697));
    byM.put("royalblue", Integer.valueOf(-12490271));
    byM.put("saddlebrown", Integer.valueOf(-7650029));
    byM.put("salmon", Integer.valueOf(-360334));
    byM.put("sandybrown", Integer.valueOf(-744352));
    byM.put("seagreen", Integer.valueOf(-13726889));
    byM.put("seashell", Integer.valueOf(-2578));
    byM.put("sienna", Integer.valueOf(-6270419));
    byM.put("silver", Integer.valueOf(-4144960));
    byM.put("skyblue", Integer.valueOf(-7876885));
    byM.put("slateblue", Integer.valueOf(-9807155));
    byM.put("slategray", Integer.valueOf(-9404272));
    byM.put("slategrey", Integer.valueOf(-9404272));
    byM.put("snow", Integer.valueOf(-1286));
    byM.put("springgreen", Integer.valueOf(-16711809));
    byM.put("steelblue", Integer.valueOf(-12156236));
    byM.put("tan", Integer.valueOf(-2968436));
    byM.put("teal", Integer.valueOf(-16744320));
    byM.put("thistle", Integer.valueOf(-2572328));
    byM.put("tomato", Integer.valueOf(-40121));
    byM.put("transparent", Integer.valueOf(0));
    byM.put("turquoise", Integer.valueOf(-12525360));
    byM.put("violet", Integer.valueOf(-1146130));
    byM.put("wheat", Integer.valueOf(-663885));
    byM.put("white", Integer.valueOf(-1));
    byM.put("whitesmoke", Integer.valueOf(-657931));
    byM.put("yellow", Integer.valueOf(-256));
    byM.put("yellowgreen", Integer.valueOf(-6632142));
    AppMethodBeat.o(93132);
  }
  
  public static int aH(String paramString)
  {
    AppMethodBeat.i(93128);
    int i = h(paramString, false);
    AppMethodBeat.o(93128);
    return i;
  }
  
  public static int aI(String paramString)
  {
    AppMethodBeat.i(93129);
    int i = h(paramString, true);
    AppMethodBeat.o(93129);
    return i;
  }
  
  private static int argb(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  private static int h(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(93130);
    boolean bool;
    String str;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      bool = true;
      a.checkArgument(bool);
      str = paramString.replace(" ", "");
      if (str.charAt(0) != '#') {
        break label126;
      }
      i = (int)Long.parseLong(str.substring(1), 16);
      if (str.length() != 7) {
        break label83;
      }
      i |= 0xFF000000;
    }
    for (;;)
    {
      AppMethodBeat.o(93130);
      return i;
      bool = false;
      break;
      label83:
      if (str.length() != 9) {
        break label110;
      }
      i = i >>> 8 | (i & 0xFF) << 24;
    }
    label110:
    paramString = new IllegalArgumentException();
    AppMethodBeat.o(93130);
    throw paramString;
    label126:
    if (str.startsWith("rgba"))
    {
      if (paramBoolean)
      {
        paramString = byL;
        paramString = paramString.matcher(str);
        if (!paramString.matches()) {
          break label344;
        }
        if (!paramBoolean) {
          break label227;
        }
      }
      for (i = (int)(255.0F * Float.parseFloat(paramString.group(4)));; i = Integer.parseInt(paramString.group(4), 10))
      {
        i = argb(i, Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
        AppMethodBeat.o(93130);
        return i;
        paramString = byK;
        break;
      }
    }
    else if (str.startsWith("rgb"))
    {
      paramString = byJ.matcher(str);
      if (paramString.matches())
      {
        i = rgb(Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
        AppMethodBeat.o(93130);
        return i;
      }
    }
    else
    {
      paramString = (Integer)byM.get(x.aV(str));
      if (paramString != null)
      {
        i = paramString.intValue();
        AppMethodBeat.o(93130);
        return i;
      }
    }
    label227:
    paramString = new IllegalArgumentException();
    label344:
    AppMethodBeat.o(93130);
    throw paramString;
  }
  
  private static int rgb(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93131);
    paramInt1 = argb(255, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(93131);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.e
 * JD-Core Version:    0.7.0.1
 */