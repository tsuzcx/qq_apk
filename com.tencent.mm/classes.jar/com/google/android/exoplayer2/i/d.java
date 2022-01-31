package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d
{
  private static final Pattern aSj = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
  private static final Pattern aSk = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
  private static final Pattern aSl = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
  private static final Map<String, Integer> aSm;
  
  static
  {
    HashMap localHashMap = new HashMap();
    aSm = localHashMap;
    localHashMap.put("aliceblue", Integer.valueOf(-984833));
    aSm.put("antiquewhite", Integer.valueOf(-332841));
    aSm.put("aqua", Integer.valueOf(-16711681));
    aSm.put("aquamarine", Integer.valueOf(-8388652));
    aSm.put("azure", Integer.valueOf(-983041));
    aSm.put("beige", Integer.valueOf(-657956));
    aSm.put("bisque", Integer.valueOf(-6972));
    aSm.put("black", Integer.valueOf(-16777216));
    aSm.put("blanchedalmond", Integer.valueOf(-5171));
    aSm.put("blue", Integer.valueOf(-16776961));
    aSm.put("blueviolet", Integer.valueOf(-7722014));
    aSm.put("brown", Integer.valueOf(-5952982));
    aSm.put("burlywood", Integer.valueOf(-2180985));
    aSm.put("cadetblue", Integer.valueOf(-10510688));
    aSm.put("chartreuse", Integer.valueOf(-8388864));
    aSm.put("chocolate", Integer.valueOf(-2987746));
    aSm.put("coral", Integer.valueOf(-32944));
    aSm.put("cornflowerblue", Integer.valueOf(-10185235));
    aSm.put("cornsilk", Integer.valueOf(-1828));
    aSm.put("crimson", Integer.valueOf(-2354116));
    aSm.put("cyan", Integer.valueOf(-16711681));
    aSm.put("darkblue", Integer.valueOf(-16777077));
    aSm.put("darkcyan", Integer.valueOf(-16741493));
    aSm.put("darkgoldenrod", Integer.valueOf(-4684277));
    aSm.put("darkgray", Integer.valueOf(-5658199));
    aSm.put("darkgreen", Integer.valueOf(-16751616));
    aSm.put("darkgrey", Integer.valueOf(-5658199));
    aSm.put("darkkhaki", Integer.valueOf(-4343957));
    aSm.put("darkmagenta", Integer.valueOf(-7667573));
    aSm.put("darkolivegreen", Integer.valueOf(-11179217));
    aSm.put("darkorange", Integer.valueOf(-29696));
    aSm.put("darkorchid", Integer.valueOf(-6737204));
    aSm.put("darkred", Integer.valueOf(-7667712));
    aSm.put("darksalmon", Integer.valueOf(-1468806));
    aSm.put("darkseagreen", Integer.valueOf(-7357297));
    aSm.put("darkslateblue", Integer.valueOf(-12042869));
    aSm.put("darkslategray", Integer.valueOf(-13676721));
    aSm.put("darkslategrey", Integer.valueOf(-13676721));
    aSm.put("darkturquoise", Integer.valueOf(-16724271));
    aSm.put("darkviolet", Integer.valueOf(-7077677));
    aSm.put("deeppink", Integer.valueOf(-60269));
    aSm.put("deepskyblue", Integer.valueOf(-16728065));
    aSm.put("dimgray", Integer.valueOf(-9868951));
    aSm.put("dimgrey", Integer.valueOf(-9868951));
    aSm.put("dodgerblue", Integer.valueOf(-14774017));
    aSm.put("firebrick", Integer.valueOf(-5103070));
    aSm.put("floralwhite", Integer.valueOf(-1296));
    aSm.put("forestgreen", Integer.valueOf(-14513374));
    aSm.put("fuchsia", Integer.valueOf(-65281));
    aSm.put("gainsboro", Integer.valueOf(-2302756));
    aSm.put("ghostwhite", Integer.valueOf(-460545));
    aSm.put("gold", Integer.valueOf(-10496));
    aSm.put("goldenrod", Integer.valueOf(-2448096));
    aSm.put("gray", Integer.valueOf(-8355712));
    aSm.put("green", Integer.valueOf(-16744448));
    aSm.put("greenyellow", Integer.valueOf(-5374161));
    aSm.put("grey", Integer.valueOf(-8355712));
    aSm.put("honeydew", Integer.valueOf(-983056));
    aSm.put("hotpink", Integer.valueOf(-38476));
    aSm.put("indianred", Integer.valueOf(-3318692));
    aSm.put("indigo", Integer.valueOf(-11861886));
    aSm.put("ivory", Integer.valueOf(-16));
    aSm.put("khaki", Integer.valueOf(-989556));
    aSm.put("lavender", Integer.valueOf(-1644806));
    aSm.put("lavenderblush", Integer.valueOf(-3851));
    aSm.put("lawngreen", Integer.valueOf(-8586240));
    aSm.put("lemonchiffon", Integer.valueOf(-1331));
    aSm.put("lightblue", Integer.valueOf(-5383962));
    aSm.put("lightcoral", Integer.valueOf(-1015680));
    aSm.put("lightcyan", Integer.valueOf(-2031617));
    aSm.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    aSm.put("lightgray", Integer.valueOf(-2894893));
    aSm.put("lightgreen", Integer.valueOf(-7278960));
    aSm.put("lightgrey", Integer.valueOf(-2894893));
    aSm.put("lightpink", Integer.valueOf(-18751));
    aSm.put("lightsalmon", Integer.valueOf(-24454));
    aSm.put("lightseagreen", Integer.valueOf(-14634326));
    aSm.put("lightskyblue", Integer.valueOf(-7876870));
    aSm.put("lightslategray", Integer.valueOf(-8943463));
    aSm.put("lightslategrey", Integer.valueOf(-8943463));
    aSm.put("lightsteelblue", Integer.valueOf(-5192482));
    aSm.put("lightyellow", Integer.valueOf(-32));
    aSm.put("lime", Integer.valueOf(-16711936));
    aSm.put("limegreen", Integer.valueOf(-13447886));
    aSm.put("linen", Integer.valueOf(-331546));
    aSm.put("magenta", Integer.valueOf(-65281));
    aSm.put("maroon", Integer.valueOf(-8388608));
    aSm.put("mediumaquamarine", Integer.valueOf(-10039894));
    aSm.put("mediumblue", Integer.valueOf(-16777011));
    aSm.put("mediumorchid", Integer.valueOf(-4565549));
    aSm.put("mediumpurple", Integer.valueOf(-7114533));
    aSm.put("mediumseagreen", Integer.valueOf(-12799119));
    aSm.put("mediumslateblue", Integer.valueOf(-8689426));
    aSm.put("mediumspringgreen", Integer.valueOf(-16713062));
    aSm.put("mediumturquoise", Integer.valueOf(-12004916));
    aSm.put("mediumvioletred", Integer.valueOf(-3730043));
    aSm.put("midnightblue", Integer.valueOf(-15132304));
    aSm.put("mintcream", Integer.valueOf(-655366));
    aSm.put("mistyrose", Integer.valueOf(-6943));
    aSm.put("moccasin", Integer.valueOf(-6987));
    aSm.put("navajowhite", Integer.valueOf(-8531));
    aSm.put("navy", Integer.valueOf(-16777088));
    aSm.put("oldlace", Integer.valueOf(-133658));
    aSm.put("olive", Integer.valueOf(-8355840));
    aSm.put("olivedrab", Integer.valueOf(-9728477));
    aSm.put("orange", Integer.valueOf(-23296));
    aSm.put("orangered", Integer.valueOf(-47872));
    aSm.put("orchid", Integer.valueOf(-2461482));
    aSm.put("palegoldenrod", Integer.valueOf(-1120086));
    aSm.put("palegreen", Integer.valueOf(-6751336));
    aSm.put("paleturquoise", Integer.valueOf(-5247250));
    aSm.put("palevioletred", Integer.valueOf(-2396013));
    aSm.put("papayawhip", Integer.valueOf(-4139));
    aSm.put("peachpuff", Integer.valueOf(-9543));
    aSm.put("peru", Integer.valueOf(-3308225));
    aSm.put("pink", Integer.valueOf(-16181));
    aSm.put("plum", Integer.valueOf(-2252579));
    aSm.put("powderblue", Integer.valueOf(-5185306));
    aSm.put("purple", Integer.valueOf(-8388480));
    aSm.put("rebeccapurple", Integer.valueOf(-10079335));
    aSm.put("red", Integer.valueOf(-65536));
    aSm.put("rosybrown", Integer.valueOf(-4419697));
    aSm.put("royalblue", Integer.valueOf(-12490271));
    aSm.put("saddlebrown", Integer.valueOf(-7650029));
    aSm.put("salmon", Integer.valueOf(-360334));
    aSm.put("sandybrown", Integer.valueOf(-744352));
    aSm.put("seagreen", Integer.valueOf(-13726889));
    aSm.put("seashell", Integer.valueOf(-2578));
    aSm.put("sienna", Integer.valueOf(-6270419));
    aSm.put("silver", Integer.valueOf(-4144960));
    aSm.put("skyblue", Integer.valueOf(-7876885));
    aSm.put("slateblue", Integer.valueOf(-9807155));
    aSm.put("slategray", Integer.valueOf(-9404272));
    aSm.put("slategrey", Integer.valueOf(-9404272));
    aSm.put("snow", Integer.valueOf(-1286));
    aSm.put("springgreen", Integer.valueOf(-16711809));
    aSm.put("steelblue", Integer.valueOf(-12156236));
    aSm.put("tan", Integer.valueOf(-2968436));
    aSm.put("teal", Integer.valueOf(-16744320));
    aSm.put("thistle", Integer.valueOf(-2572328));
    aSm.put("tomato", Integer.valueOf(-40121));
    aSm.put("transparent", Integer.valueOf(0));
    aSm.put("turquoise", Integer.valueOf(-12525360));
    aSm.put("violet", Integer.valueOf(-1146130));
    aSm.put("wheat", Integer.valueOf(-663885));
    aSm.put("white", Integer.valueOf(-1));
    aSm.put("whitesmoke", Integer.valueOf(-657931));
    aSm.put("yellow", Integer.valueOf(-256));
    aSm.put("yellowgreen", Integer.valueOf(-6632142));
  }
  
  private static int argb(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  public static int at(String paramString)
  {
    return f(paramString, false);
  }
  
  public static int au(String paramString)
  {
    return f(paramString, true);
  }
  
  private static int f(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    String str;
    int i;
    for (boolean bool = true;; bool = false)
    {
      a.aB(bool);
      str = paramString.replace(" ", "");
      if (str.charAt(0) != '#') {
        break label101;
      }
      i = (int)Long.parseLong(str.substring(1), 16);
      if (str.length() != 7) {
        break;
      }
      return i | 0xFF000000;
    }
    if (str.length() == 9) {
      return i >>> 8 | (i & 0xFF) << 24;
    }
    throw new IllegalArgumentException();
    label101:
    if (str.startsWith("rgba"))
    {
      if (paramBoolean)
      {
        paramString = aSl;
        paramString = paramString.matcher(str);
        if (!paramString.matches()) {
          break label298;
        }
        if (!paramBoolean) {
          break label194;
        }
      }
      for (i = (int)(255.0F * Float.parseFloat(paramString.group(4)));; i = Integer.parseInt(paramString.group(4), 10))
      {
        return argb(i, Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
        paramString = aSk;
        break;
      }
    }
    else if (str.startsWith("rgb"))
    {
      paramString = aSj.matcher(str);
      if (paramString.matches()) {
        return argb(255, Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
      }
    }
    else
    {
      paramString = (Integer)aSm.get(t.aE(str));
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    label194:
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.i.d
 * JD-Core Version:    0.7.0.1
 */