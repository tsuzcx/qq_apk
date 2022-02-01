package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private static final Pattern bGF;
  private static final Pattern bGG;
  private static final Pattern bGH;
  private static final Map<String, Integer> bGI;
  
  static
  {
    AppMethodBeat.i(93132);
    bGF = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    bGG = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    bGH = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    HashMap localHashMap = new HashMap();
    bGI = localHashMap;
    localHashMap.put("aliceblue", Integer.valueOf(-984833));
    bGI.put("antiquewhite", Integer.valueOf(-332841));
    bGI.put("aqua", Integer.valueOf(-16711681));
    bGI.put("aquamarine", Integer.valueOf(-8388652));
    bGI.put("azure", Integer.valueOf(-983041));
    bGI.put("beige", Integer.valueOf(-657956));
    bGI.put("bisque", Integer.valueOf(-6972));
    bGI.put("black", Integer.valueOf(-16777216));
    bGI.put("blanchedalmond", Integer.valueOf(-5171));
    bGI.put("blue", Integer.valueOf(-16776961));
    bGI.put("blueviolet", Integer.valueOf(-7722014));
    bGI.put("brown", Integer.valueOf(-5952982));
    bGI.put("burlywood", Integer.valueOf(-2180985));
    bGI.put("cadetblue", Integer.valueOf(-10510688));
    bGI.put("chartreuse", Integer.valueOf(-8388864));
    bGI.put("chocolate", Integer.valueOf(-2987746));
    bGI.put("coral", Integer.valueOf(-32944));
    bGI.put("cornflowerblue", Integer.valueOf(-10185235));
    bGI.put("cornsilk", Integer.valueOf(-1828));
    bGI.put("crimson", Integer.valueOf(-2354116));
    bGI.put("cyan", Integer.valueOf(-16711681));
    bGI.put("darkblue", Integer.valueOf(-16777077));
    bGI.put("darkcyan", Integer.valueOf(-16741493));
    bGI.put("darkgoldenrod", Integer.valueOf(-4684277));
    bGI.put("darkgray", Integer.valueOf(-5658199));
    bGI.put("darkgreen", Integer.valueOf(-16751616));
    bGI.put("darkgrey", Integer.valueOf(-5658199));
    bGI.put("darkkhaki", Integer.valueOf(-4343957));
    bGI.put("darkmagenta", Integer.valueOf(-7667573));
    bGI.put("darkolivegreen", Integer.valueOf(-11179217));
    bGI.put("darkorange", Integer.valueOf(-29696));
    bGI.put("darkorchid", Integer.valueOf(-6737204));
    bGI.put("darkred", Integer.valueOf(-7667712));
    bGI.put("darksalmon", Integer.valueOf(-1468806));
    bGI.put("darkseagreen", Integer.valueOf(-7357297));
    bGI.put("darkslateblue", Integer.valueOf(-12042869));
    bGI.put("darkslategray", Integer.valueOf(-13676721));
    bGI.put("darkslategrey", Integer.valueOf(-13676721));
    bGI.put("darkturquoise", Integer.valueOf(-16724271));
    bGI.put("darkviolet", Integer.valueOf(-7077677));
    bGI.put("deeppink", Integer.valueOf(-60269));
    bGI.put("deepskyblue", Integer.valueOf(-16728065));
    bGI.put("dimgray", Integer.valueOf(-9868951));
    bGI.put("dimgrey", Integer.valueOf(-9868951));
    bGI.put("dodgerblue", Integer.valueOf(-14774017));
    bGI.put("firebrick", Integer.valueOf(-5103070));
    bGI.put("floralwhite", Integer.valueOf(-1296));
    bGI.put("forestgreen", Integer.valueOf(-14513374));
    bGI.put("fuchsia", Integer.valueOf(-65281));
    bGI.put("gainsboro", Integer.valueOf(-2302756));
    bGI.put("ghostwhite", Integer.valueOf(-460545));
    bGI.put("gold", Integer.valueOf(-10496));
    bGI.put("goldenrod", Integer.valueOf(-2448096));
    bGI.put("gray", Integer.valueOf(-8355712));
    bGI.put("green", Integer.valueOf(-16744448));
    bGI.put("greenyellow", Integer.valueOf(-5374161));
    bGI.put("grey", Integer.valueOf(-8355712));
    bGI.put("honeydew", Integer.valueOf(-983056));
    bGI.put("hotpink", Integer.valueOf(-38476));
    bGI.put("indianred", Integer.valueOf(-3318692));
    bGI.put("indigo", Integer.valueOf(-11861886));
    bGI.put("ivory", Integer.valueOf(-16));
    bGI.put("khaki", Integer.valueOf(-989556));
    bGI.put("lavender", Integer.valueOf(-1644806));
    bGI.put("lavenderblush", Integer.valueOf(-3851));
    bGI.put("lawngreen", Integer.valueOf(-8586240));
    bGI.put("lemonchiffon", Integer.valueOf(-1331));
    bGI.put("lightblue", Integer.valueOf(-5383962));
    bGI.put("lightcoral", Integer.valueOf(-1015680));
    bGI.put("lightcyan", Integer.valueOf(-2031617));
    bGI.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    bGI.put("lightgray", Integer.valueOf(-2894893));
    bGI.put("lightgreen", Integer.valueOf(-7278960));
    bGI.put("lightgrey", Integer.valueOf(-2894893));
    bGI.put("lightpink", Integer.valueOf(-18751));
    bGI.put("lightsalmon", Integer.valueOf(-24454));
    bGI.put("lightseagreen", Integer.valueOf(-14634326));
    bGI.put("lightskyblue", Integer.valueOf(-7876870));
    bGI.put("lightslategray", Integer.valueOf(-8943463));
    bGI.put("lightslategrey", Integer.valueOf(-8943463));
    bGI.put("lightsteelblue", Integer.valueOf(-5192482));
    bGI.put("lightyellow", Integer.valueOf(-32));
    bGI.put("lime", Integer.valueOf(-16711936));
    bGI.put("limegreen", Integer.valueOf(-13447886));
    bGI.put("linen", Integer.valueOf(-331546));
    bGI.put("magenta", Integer.valueOf(-65281));
    bGI.put("maroon", Integer.valueOf(-8388608));
    bGI.put("mediumaquamarine", Integer.valueOf(-10039894));
    bGI.put("mediumblue", Integer.valueOf(-16777011));
    bGI.put("mediumorchid", Integer.valueOf(-4565549));
    bGI.put("mediumpurple", Integer.valueOf(-7114533));
    bGI.put("mediumseagreen", Integer.valueOf(-12799119));
    bGI.put("mediumslateblue", Integer.valueOf(-8689426));
    bGI.put("mediumspringgreen", Integer.valueOf(-16713062));
    bGI.put("mediumturquoise", Integer.valueOf(-12004916));
    bGI.put("mediumvioletred", Integer.valueOf(-3730043));
    bGI.put("midnightblue", Integer.valueOf(-15132304));
    bGI.put("mintcream", Integer.valueOf(-655366));
    bGI.put("mistyrose", Integer.valueOf(-6943));
    bGI.put("moccasin", Integer.valueOf(-6987));
    bGI.put("navajowhite", Integer.valueOf(-8531));
    bGI.put("navy", Integer.valueOf(-16777088));
    bGI.put("oldlace", Integer.valueOf(-133658));
    bGI.put("olive", Integer.valueOf(-8355840));
    bGI.put("olivedrab", Integer.valueOf(-9728477));
    bGI.put("orange", Integer.valueOf(-23296));
    bGI.put("orangered", Integer.valueOf(-47872));
    bGI.put("orchid", Integer.valueOf(-2461482));
    bGI.put("palegoldenrod", Integer.valueOf(-1120086));
    bGI.put("palegreen", Integer.valueOf(-6751336));
    bGI.put("paleturquoise", Integer.valueOf(-5247250));
    bGI.put("palevioletred", Integer.valueOf(-2396013));
    bGI.put("papayawhip", Integer.valueOf(-4139));
    bGI.put("peachpuff", Integer.valueOf(-9543));
    bGI.put("peru", Integer.valueOf(-3308225));
    bGI.put("pink", Integer.valueOf(-16181));
    bGI.put("plum", Integer.valueOf(-2252579));
    bGI.put("powderblue", Integer.valueOf(-5185306));
    bGI.put("purple", Integer.valueOf(-8388480));
    bGI.put("rebeccapurple", Integer.valueOf(-10079335));
    bGI.put("red", Integer.valueOf(-65536));
    bGI.put("rosybrown", Integer.valueOf(-4419697));
    bGI.put("royalblue", Integer.valueOf(-12490271));
    bGI.put("saddlebrown", Integer.valueOf(-7650029));
    bGI.put("salmon", Integer.valueOf(-360334));
    bGI.put("sandybrown", Integer.valueOf(-744352));
    bGI.put("seagreen", Integer.valueOf(-13726889));
    bGI.put("seashell", Integer.valueOf(-2578));
    bGI.put("sienna", Integer.valueOf(-6270419));
    bGI.put("silver", Integer.valueOf(-4144960));
    bGI.put("skyblue", Integer.valueOf(-7876885));
    bGI.put("slateblue", Integer.valueOf(-9807155));
    bGI.put("slategray", Integer.valueOf(-9404272));
    bGI.put("slategrey", Integer.valueOf(-9404272));
    bGI.put("snow", Integer.valueOf(-1286));
    bGI.put("springgreen", Integer.valueOf(-16711809));
    bGI.put("steelblue", Integer.valueOf(-12156236));
    bGI.put("tan", Integer.valueOf(-2968436));
    bGI.put("teal", Integer.valueOf(-16744320));
    bGI.put("thistle", Integer.valueOf(-2572328));
    bGI.put("tomato", Integer.valueOf(-40121));
    bGI.put("transparent", Integer.valueOf(0));
    bGI.put("turquoise", Integer.valueOf(-12525360));
    bGI.put("violet", Integer.valueOf(-1146130));
    bGI.put("wheat", Integer.valueOf(-663885));
    bGI.put("white", Integer.valueOf(-1));
    bGI.put("whitesmoke", Integer.valueOf(-657931));
    bGI.put("yellow", Integer.valueOf(-256));
    bGI.put("yellowgreen", Integer.valueOf(-6632142));
    AppMethodBeat.o(93132);
  }
  
  private static int argb(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  public static int bv(String paramString)
  {
    AppMethodBeat.i(93128);
    int i = h(paramString, false);
    AppMethodBeat.o(93128);
    return i;
  }
  
  public static int bw(String paramString)
  {
    AppMethodBeat.i(93129);
    int i = h(paramString, true);
    AppMethodBeat.o(93129);
    return i;
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
        paramString = bGH;
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
        paramString = bGG;
        break;
      }
    }
    else if (str.startsWith("rgb"))
    {
      paramString = bGF.matcher(str);
      if (paramString.matches())
      {
        i = rgb(Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
        AppMethodBeat.o(93130);
        return i;
      }
    }
    else
    {
      paramString = (Integer)bGI.get(x.bH(str));
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