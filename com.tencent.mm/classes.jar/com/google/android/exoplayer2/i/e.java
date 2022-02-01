package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private static final Pattern bqF;
  private static final Pattern bqG;
  private static final Pattern bqH;
  private static final Map<String, Integer> bqI;
  
  static
  {
    AppMethodBeat.i(93132);
    bqF = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    bqG = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    bqH = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    HashMap localHashMap = new HashMap();
    bqI = localHashMap;
    localHashMap.put("aliceblue", Integer.valueOf(-984833));
    bqI.put("antiquewhite", Integer.valueOf(-332841));
    bqI.put("aqua", Integer.valueOf(-16711681));
    bqI.put("aquamarine", Integer.valueOf(-8388652));
    bqI.put("azure", Integer.valueOf(-983041));
    bqI.put("beige", Integer.valueOf(-657956));
    bqI.put("bisque", Integer.valueOf(-6972));
    bqI.put("black", Integer.valueOf(-16777216));
    bqI.put("blanchedalmond", Integer.valueOf(-5171));
    bqI.put("blue", Integer.valueOf(-16776961));
    bqI.put("blueviolet", Integer.valueOf(-7722014));
    bqI.put("brown", Integer.valueOf(-5952982));
    bqI.put("burlywood", Integer.valueOf(-2180985));
    bqI.put("cadetblue", Integer.valueOf(-10510688));
    bqI.put("chartreuse", Integer.valueOf(-8388864));
    bqI.put("chocolate", Integer.valueOf(-2987746));
    bqI.put("coral", Integer.valueOf(-32944));
    bqI.put("cornflowerblue", Integer.valueOf(-10185235));
    bqI.put("cornsilk", Integer.valueOf(-1828));
    bqI.put("crimson", Integer.valueOf(-2354116));
    bqI.put("cyan", Integer.valueOf(-16711681));
    bqI.put("darkblue", Integer.valueOf(-16777077));
    bqI.put("darkcyan", Integer.valueOf(-16741493));
    bqI.put("darkgoldenrod", Integer.valueOf(-4684277));
    bqI.put("darkgray", Integer.valueOf(-5658199));
    bqI.put("darkgreen", Integer.valueOf(-16751616));
    bqI.put("darkgrey", Integer.valueOf(-5658199));
    bqI.put("darkkhaki", Integer.valueOf(-4343957));
    bqI.put("darkmagenta", Integer.valueOf(-7667573));
    bqI.put("darkolivegreen", Integer.valueOf(-11179217));
    bqI.put("darkorange", Integer.valueOf(-29696));
    bqI.put("darkorchid", Integer.valueOf(-6737204));
    bqI.put("darkred", Integer.valueOf(-7667712));
    bqI.put("darksalmon", Integer.valueOf(-1468806));
    bqI.put("darkseagreen", Integer.valueOf(-7357297));
    bqI.put("darkslateblue", Integer.valueOf(-12042869));
    bqI.put("darkslategray", Integer.valueOf(-13676721));
    bqI.put("darkslategrey", Integer.valueOf(-13676721));
    bqI.put("darkturquoise", Integer.valueOf(-16724271));
    bqI.put("darkviolet", Integer.valueOf(-7077677));
    bqI.put("deeppink", Integer.valueOf(-60269));
    bqI.put("deepskyblue", Integer.valueOf(-16728065));
    bqI.put("dimgray", Integer.valueOf(-9868951));
    bqI.put("dimgrey", Integer.valueOf(-9868951));
    bqI.put("dodgerblue", Integer.valueOf(-14774017));
    bqI.put("firebrick", Integer.valueOf(-5103070));
    bqI.put("floralwhite", Integer.valueOf(-1296));
    bqI.put("forestgreen", Integer.valueOf(-14513374));
    bqI.put("fuchsia", Integer.valueOf(-65281));
    bqI.put("gainsboro", Integer.valueOf(-2302756));
    bqI.put("ghostwhite", Integer.valueOf(-460545));
    bqI.put("gold", Integer.valueOf(-10496));
    bqI.put("goldenrod", Integer.valueOf(-2448096));
    bqI.put("gray", Integer.valueOf(-8355712));
    bqI.put("green", Integer.valueOf(-16744448));
    bqI.put("greenyellow", Integer.valueOf(-5374161));
    bqI.put("grey", Integer.valueOf(-8355712));
    bqI.put("honeydew", Integer.valueOf(-983056));
    bqI.put("hotpink", Integer.valueOf(-38476));
    bqI.put("indianred", Integer.valueOf(-3318692));
    bqI.put("indigo", Integer.valueOf(-11861886));
    bqI.put("ivory", Integer.valueOf(-16));
    bqI.put("khaki", Integer.valueOf(-989556));
    bqI.put("lavender", Integer.valueOf(-1644806));
    bqI.put("lavenderblush", Integer.valueOf(-3851));
    bqI.put("lawngreen", Integer.valueOf(-8586240));
    bqI.put("lemonchiffon", Integer.valueOf(-1331));
    bqI.put("lightblue", Integer.valueOf(-5383962));
    bqI.put("lightcoral", Integer.valueOf(-1015680));
    bqI.put("lightcyan", Integer.valueOf(-2031617));
    bqI.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    bqI.put("lightgray", Integer.valueOf(-2894893));
    bqI.put("lightgreen", Integer.valueOf(-7278960));
    bqI.put("lightgrey", Integer.valueOf(-2894893));
    bqI.put("lightpink", Integer.valueOf(-18751));
    bqI.put("lightsalmon", Integer.valueOf(-24454));
    bqI.put("lightseagreen", Integer.valueOf(-14634326));
    bqI.put("lightskyblue", Integer.valueOf(-7876870));
    bqI.put("lightslategray", Integer.valueOf(-8943463));
    bqI.put("lightslategrey", Integer.valueOf(-8943463));
    bqI.put("lightsteelblue", Integer.valueOf(-5192482));
    bqI.put("lightyellow", Integer.valueOf(-32));
    bqI.put("lime", Integer.valueOf(-16711936));
    bqI.put("limegreen", Integer.valueOf(-13447886));
    bqI.put("linen", Integer.valueOf(-331546));
    bqI.put("magenta", Integer.valueOf(-65281));
    bqI.put("maroon", Integer.valueOf(-8388608));
    bqI.put("mediumaquamarine", Integer.valueOf(-10039894));
    bqI.put("mediumblue", Integer.valueOf(-16777011));
    bqI.put("mediumorchid", Integer.valueOf(-4565549));
    bqI.put("mediumpurple", Integer.valueOf(-7114533));
    bqI.put("mediumseagreen", Integer.valueOf(-12799119));
    bqI.put("mediumslateblue", Integer.valueOf(-8689426));
    bqI.put("mediumspringgreen", Integer.valueOf(-16713062));
    bqI.put("mediumturquoise", Integer.valueOf(-12004916));
    bqI.put("mediumvioletred", Integer.valueOf(-3730043));
    bqI.put("midnightblue", Integer.valueOf(-15132304));
    bqI.put("mintcream", Integer.valueOf(-655366));
    bqI.put("mistyrose", Integer.valueOf(-6943));
    bqI.put("moccasin", Integer.valueOf(-6987));
    bqI.put("navajowhite", Integer.valueOf(-8531));
    bqI.put("navy", Integer.valueOf(-16777088));
    bqI.put("oldlace", Integer.valueOf(-133658));
    bqI.put("olive", Integer.valueOf(-8355840));
    bqI.put("olivedrab", Integer.valueOf(-9728477));
    bqI.put("orange", Integer.valueOf(-23296));
    bqI.put("orangered", Integer.valueOf(-47872));
    bqI.put("orchid", Integer.valueOf(-2461482));
    bqI.put("palegoldenrod", Integer.valueOf(-1120086));
    bqI.put("palegreen", Integer.valueOf(-6751336));
    bqI.put("paleturquoise", Integer.valueOf(-5247250));
    bqI.put("palevioletred", Integer.valueOf(-2396013));
    bqI.put("papayawhip", Integer.valueOf(-4139));
    bqI.put("peachpuff", Integer.valueOf(-9543));
    bqI.put("peru", Integer.valueOf(-3308225));
    bqI.put("pink", Integer.valueOf(-16181));
    bqI.put("plum", Integer.valueOf(-2252579));
    bqI.put("powderblue", Integer.valueOf(-5185306));
    bqI.put("purple", Integer.valueOf(-8388480));
    bqI.put("rebeccapurple", Integer.valueOf(-10079335));
    bqI.put("red", Integer.valueOf(-65536));
    bqI.put("rosybrown", Integer.valueOf(-4419697));
    bqI.put("royalblue", Integer.valueOf(-12490271));
    bqI.put("saddlebrown", Integer.valueOf(-7650029));
    bqI.put("salmon", Integer.valueOf(-360334));
    bqI.put("sandybrown", Integer.valueOf(-744352));
    bqI.put("seagreen", Integer.valueOf(-13726889));
    bqI.put("seashell", Integer.valueOf(-2578));
    bqI.put("sienna", Integer.valueOf(-6270419));
    bqI.put("silver", Integer.valueOf(-4144960));
    bqI.put("skyblue", Integer.valueOf(-7876885));
    bqI.put("slateblue", Integer.valueOf(-9807155));
    bqI.put("slategray", Integer.valueOf(-9404272));
    bqI.put("slategrey", Integer.valueOf(-9404272));
    bqI.put("snow", Integer.valueOf(-1286));
    bqI.put("springgreen", Integer.valueOf(-16711809));
    bqI.put("steelblue", Integer.valueOf(-12156236));
    bqI.put("tan", Integer.valueOf(-2968436));
    bqI.put("teal", Integer.valueOf(-16744320));
    bqI.put("thistle", Integer.valueOf(-2572328));
    bqI.put("tomato", Integer.valueOf(-40121));
    bqI.put("transparent", Integer.valueOf(0));
    bqI.put("turquoise", Integer.valueOf(-12525360));
    bqI.put("violet", Integer.valueOf(-1146130));
    bqI.put("wheat", Integer.valueOf(-663885));
    bqI.put("white", Integer.valueOf(-1));
    bqI.put("whitesmoke", Integer.valueOf(-657931));
    bqI.put("yellow", Integer.valueOf(-256));
    bqI.put("yellowgreen", Integer.valueOf(-6632142));
    AppMethodBeat.o(93132);
  }
  
  public static int bG(String paramString)
  {
    AppMethodBeat.i(93128);
    int i = g(paramString, false);
    AppMethodBeat.o(93128);
    return i;
  }
  
  public static int bH(String paramString)
  {
    AppMethodBeat.i(93129);
    int i = g(paramString, true);
    AppMethodBeat.o(93129);
    return i;
  }
  
  private static int g(String paramString, boolean paramBoolean)
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
        paramString = bqH;
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
        i = m(i, Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
        AppMethodBeat.o(93130);
        return i;
        paramString = bqG;
        break;
      }
    }
    else if (str.startsWith("rgb"))
    {
      paramString = bqF.matcher(str);
      if (paramString.matches())
      {
        i = q(Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
        AppMethodBeat.o(93130);
        return i;
      }
    }
    else
    {
      paramString = (Integer)bqI.get(x.bS(str));
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
  
  private static int m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  private static int q(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93131);
    paramInt1 = m(255, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(93131);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.i.e
 * JD-Core Version:    0.7.0.1
 */