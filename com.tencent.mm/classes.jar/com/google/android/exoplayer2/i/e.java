package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private static final Pattern bGW;
  private static final Pattern bGX;
  private static final Pattern bGY;
  private static final Map<String, Integer> bGZ;
  
  static
  {
    AppMethodBeat.i(93132);
    bGW = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    bGX = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    bGY = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    HashMap localHashMap = new HashMap();
    bGZ = localHashMap;
    localHashMap.put("aliceblue", Integer.valueOf(-984833));
    bGZ.put("antiquewhite", Integer.valueOf(-332841));
    bGZ.put("aqua", Integer.valueOf(-16711681));
    bGZ.put("aquamarine", Integer.valueOf(-8388652));
    bGZ.put("azure", Integer.valueOf(-983041));
    bGZ.put("beige", Integer.valueOf(-657956));
    bGZ.put("bisque", Integer.valueOf(-6972));
    bGZ.put("black", Integer.valueOf(-16777216));
    bGZ.put("blanchedalmond", Integer.valueOf(-5171));
    bGZ.put("blue", Integer.valueOf(-16776961));
    bGZ.put("blueviolet", Integer.valueOf(-7722014));
    bGZ.put("brown", Integer.valueOf(-5952982));
    bGZ.put("burlywood", Integer.valueOf(-2180985));
    bGZ.put("cadetblue", Integer.valueOf(-10510688));
    bGZ.put("chartreuse", Integer.valueOf(-8388864));
    bGZ.put("chocolate", Integer.valueOf(-2987746));
    bGZ.put("coral", Integer.valueOf(-32944));
    bGZ.put("cornflowerblue", Integer.valueOf(-10185235));
    bGZ.put("cornsilk", Integer.valueOf(-1828));
    bGZ.put("crimson", Integer.valueOf(-2354116));
    bGZ.put("cyan", Integer.valueOf(-16711681));
    bGZ.put("darkblue", Integer.valueOf(-16777077));
    bGZ.put("darkcyan", Integer.valueOf(-16741493));
    bGZ.put("darkgoldenrod", Integer.valueOf(-4684277));
    bGZ.put("darkgray", Integer.valueOf(-5658199));
    bGZ.put("darkgreen", Integer.valueOf(-16751616));
    bGZ.put("darkgrey", Integer.valueOf(-5658199));
    bGZ.put("darkkhaki", Integer.valueOf(-4343957));
    bGZ.put("darkmagenta", Integer.valueOf(-7667573));
    bGZ.put("darkolivegreen", Integer.valueOf(-11179217));
    bGZ.put("darkorange", Integer.valueOf(-29696));
    bGZ.put("darkorchid", Integer.valueOf(-6737204));
    bGZ.put("darkred", Integer.valueOf(-7667712));
    bGZ.put("darksalmon", Integer.valueOf(-1468806));
    bGZ.put("darkseagreen", Integer.valueOf(-7357297));
    bGZ.put("darkslateblue", Integer.valueOf(-12042869));
    bGZ.put("darkslategray", Integer.valueOf(-13676721));
    bGZ.put("darkslategrey", Integer.valueOf(-13676721));
    bGZ.put("darkturquoise", Integer.valueOf(-16724271));
    bGZ.put("darkviolet", Integer.valueOf(-7077677));
    bGZ.put("deeppink", Integer.valueOf(-60269));
    bGZ.put("deepskyblue", Integer.valueOf(-16728065));
    bGZ.put("dimgray", Integer.valueOf(-9868951));
    bGZ.put("dimgrey", Integer.valueOf(-9868951));
    bGZ.put("dodgerblue", Integer.valueOf(-14774017));
    bGZ.put("firebrick", Integer.valueOf(-5103070));
    bGZ.put("floralwhite", Integer.valueOf(-1296));
    bGZ.put("forestgreen", Integer.valueOf(-14513374));
    bGZ.put("fuchsia", Integer.valueOf(-65281));
    bGZ.put("gainsboro", Integer.valueOf(-2302756));
    bGZ.put("ghostwhite", Integer.valueOf(-460545));
    bGZ.put("gold", Integer.valueOf(-10496));
    bGZ.put("goldenrod", Integer.valueOf(-2448096));
    bGZ.put("gray", Integer.valueOf(-8355712));
    bGZ.put("green", Integer.valueOf(-16744448));
    bGZ.put("greenyellow", Integer.valueOf(-5374161));
    bGZ.put("grey", Integer.valueOf(-8355712));
    bGZ.put("honeydew", Integer.valueOf(-983056));
    bGZ.put("hotpink", Integer.valueOf(-38476));
    bGZ.put("indianred", Integer.valueOf(-3318692));
    bGZ.put("indigo", Integer.valueOf(-11861886));
    bGZ.put("ivory", Integer.valueOf(-16));
    bGZ.put("khaki", Integer.valueOf(-989556));
    bGZ.put("lavender", Integer.valueOf(-1644806));
    bGZ.put("lavenderblush", Integer.valueOf(-3851));
    bGZ.put("lawngreen", Integer.valueOf(-8586240));
    bGZ.put("lemonchiffon", Integer.valueOf(-1331));
    bGZ.put("lightblue", Integer.valueOf(-5383962));
    bGZ.put("lightcoral", Integer.valueOf(-1015680));
    bGZ.put("lightcyan", Integer.valueOf(-2031617));
    bGZ.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    bGZ.put("lightgray", Integer.valueOf(-2894893));
    bGZ.put("lightgreen", Integer.valueOf(-7278960));
    bGZ.put("lightgrey", Integer.valueOf(-2894893));
    bGZ.put("lightpink", Integer.valueOf(-18751));
    bGZ.put("lightsalmon", Integer.valueOf(-24454));
    bGZ.put("lightseagreen", Integer.valueOf(-14634326));
    bGZ.put("lightskyblue", Integer.valueOf(-7876870));
    bGZ.put("lightslategray", Integer.valueOf(-8943463));
    bGZ.put("lightslategrey", Integer.valueOf(-8943463));
    bGZ.put("lightsteelblue", Integer.valueOf(-5192482));
    bGZ.put("lightyellow", Integer.valueOf(-32));
    bGZ.put("lime", Integer.valueOf(-16711936));
    bGZ.put("limegreen", Integer.valueOf(-13447886));
    bGZ.put("linen", Integer.valueOf(-331546));
    bGZ.put("magenta", Integer.valueOf(-65281));
    bGZ.put("maroon", Integer.valueOf(-8388608));
    bGZ.put("mediumaquamarine", Integer.valueOf(-10039894));
    bGZ.put("mediumblue", Integer.valueOf(-16777011));
    bGZ.put("mediumorchid", Integer.valueOf(-4565549));
    bGZ.put("mediumpurple", Integer.valueOf(-7114533));
    bGZ.put("mediumseagreen", Integer.valueOf(-12799119));
    bGZ.put("mediumslateblue", Integer.valueOf(-8689426));
    bGZ.put("mediumspringgreen", Integer.valueOf(-16713062));
    bGZ.put("mediumturquoise", Integer.valueOf(-12004916));
    bGZ.put("mediumvioletred", Integer.valueOf(-3730043));
    bGZ.put("midnightblue", Integer.valueOf(-15132304));
    bGZ.put("mintcream", Integer.valueOf(-655366));
    bGZ.put("mistyrose", Integer.valueOf(-6943));
    bGZ.put("moccasin", Integer.valueOf(-6987));
    bGZ.put("navajowhite", Integer.valueOf(-8531));
    bGZ.put("navy", Integer.valueOf(-16777088));
    bGZ.put("oldlace", Integer.valueOf(-133658));
    bGZ.put("olive", Integer.valueOf(-8355840));
    bGZ.put("olivedrab", Integer.valueOf(-9728477));
    bGZ.put("orange", Integer.valueOf(-23296));
    bGZ.put("orangered", Integer.valueOf(-47872));
    bGZ.put("orchid", Integer.valueOf(-2461482));
    bGZ.put("palegoldenrod", Integer.valueOf(-1120086));
    bGZ.put("palegreen", Integer.valueOf(-6751336));
    bGZ.put("paleturquoise", Integer.valueOf(-5247250));
    bGZ.put("palevioletred", Integer.valueOf(-2396013));
    bGZ.put("papayawhip", Integer.valueOf(-4139));
    bGZ.put("peachpuff", Integer.valueOf(-9543));
    bGZ.put("peru", Integer.valueOf(-3308225));
    bGZ.put("pink", Integer.valueOf(-16181));
    bGZ.put("plum", Integer.valueOf(-2252579));
    bGZ.put("powderblue", Integer.valueOf(-5185306));
    bGZ.put("purple", Integer.valueOf(-8388480));
    bGZ.put("rebeccapurple", Integer.valueOf(-10079335));
    bGZ.put("red", Integer.valueOf(-65536));
    bGZ.put("rosybrown", Integer.valueOf(-4419697));
    bGZ.put("royalblue", Integer.valueOf(-12490271));
    bGZ.put("saddlebrown", Integer.valueOf(-7650029));
    bGZ.put("salmon", Integer.valueOf(-360334));
    bGZ.put("sandybrown", Integer.valueOf(-744352));
    bGZ.put("seagreen", Integer.valueOf(-13726889));
    bGZ.put("seashell", Integer.valueOf(-2578));
    bGZ.put("sienna", Integer.valueOf(-6270419));
    bGZ.put("silver", Integer.valueOf(-4144960));
    bGZ.put("skyblue", Integer.valueOf(-7876885));
    bGZ.put("slateblue", Integer.valueOf(-9807155));
    bGZ.put("slategray", Integer.valueOf(-9404272));
    bGZ.put("slategrey", Integer.valueOf(-9404272));
    bGZ.put("snow", Integer.valueOf(-1286));
    bGZ.put("springgreen", Integer.valueOf(-16711809));
    bGZ.put("steelblue", Integer.valueOf(-12156236));
    bGZ.put("tan", Integer.valueOf(-2968436));
    bGZ.put("teal", Integer.valueOf(-16744320));
    bGZ.put("thistle", Integer.valueOf(-2572328));
    bGZ.put("tomato", Integer.valueOf(-40121));
    bGZ.put("transparent", Integer.valueOf(0));
    bGZ.put("turquoise", Integer.valueOf(-12525360));
    bGZ.put("violet", Integer.valueOf(-1146130));
    bGZ.put("wheat", Integer.valueOf(-663885));
    bGZ.put("white", Integer.valueOf(-1));
    bGZ.put("whitesmoke", Integer.valueOf(-657931));
    bGZ.put("yellow", Integer.valueOf(-256));
    bGZ.put("yellowgreen", Integer.valueOf(-6632142));
    AppMethodBeat.o(93132);
  }
  
  private static int argb(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  public static int bv(String paramString)
  {
    AppMethodBeat.i(93128);
    int i = f(paramString, false);
    AppMethodBeat.o(93128);
    return i;
  }
  
  public static int bw(String paramString)
  {
    AppMethodBeat.i(93129);
    int i = f(paramString, true);
    AppMethodBeat.o(93129);
    return i;
  }
  
  private static int f(String paramString, boolean paramBoolean)
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
        paramString = bGY;
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
        paramString = bGX;
        break;
      }
    }
    else if (str.startsWith("rgb"))
    {
      paramString = bGW.matcher(str);
      if (paramString.matches())
      {
        i = rgb(Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
        AppMethodBeat.o(93130);
        return i;
      }
    }
    else
    {
      paramString = (Integer)bGZ.get(x.bH(str));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.i.e
 * JD-Core Version:    0.7.0.1
 */