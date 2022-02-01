package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private static final Pattern bwr;
  private static final Pattern bws;
  private static final Pattern bwt;
  private static final Map<String, Integer> bwu;
  
  static
  {
    AppMethodBeat.i(93132);
    bwr = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    bws = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    bwt = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    HashMap localHashMap = new HashMap();
    bwu = localHashMap;
    localHashMap.put("aliceblue", Integer.valueOf(-984833));
    bwu.put("antiquewhite", Integer.valueOf(-332841));
    bwu.put("aqua", Integer.valueOf(-16711681));
    bwu.put("aquamarine", Integer.valueOf(-8388652));
    bwu.put("azure", Integer.valueOf(-983041));
    bwu.put("beige", Integer.valueOf(-657956));
    bwu.put("bisque", Integer.valueOf(-6972));
    bwu.put("black", Integer.valueOf(-16777216));
    bwu.put("blanchedalmond", Integer.valueOf(-5171));
    bwu.put("blue", Integer.valueOf(-16776961));
    bwu.put("blueviolet", Integer.valueOf(-7722014));
    bwu.put("brown", Integer.valueOf(-5952982));
    bwu.put("burlywood", Integer.valueOf(-2180985));
    bwu.put("cadetblue", Integer.valueOf(-10510688));
    bwu.put("chartreuse", Integer.valueOf(-8388864));
    bwu.put("chocolate", Integer.valueOf(-2987746));
    bwu.put("coral", Integer.valueOf(-32944));
    bwu.put("cornflowerblue", Integer.valueOf(-10185235));
    bwu.put("cornsilk", Integer.valueOf(-1828));
    bwu.put("crimson", Integer.valueOf(-2354116));
    bwu.put("cyan", Integer.valueOf(-16711681));
    bwu.put("darkblue", Integer.valueOf(-16777077));
    bwu.put("darkcyan", Integer.valueOf(-16741493));
    bwu.put("darkgoldenrod", Integer.valueOf(-4684277));
    bwu.put("darkgray", Integer.valueOf(-5658199));
    bwu.put("darkgreen", Integer.valueOf(-16751616));
    bwu.put("darkgrey", Integer.valueOf(-5658199));
    bwu.put("darkkhaki", Integer.valueOf(-4343957));
    bwu.put("darkmagenta", Integer.valueOf(-7667573));
    bwu.put("darkolivegreen", Integer.valueOf(-11179217));
    bwu.put("darkorange", Integer.valueOf(-29696));
    bwu.put("darkorchid", Integer.valueOf(-6737204));
    bwu.put("darkred", Integer.valueOf(-7667712));
    bwu.put("darksalmon", Integer.valueOf(-1468806));
    bwu.put("darkseagreen", Integer.valueOf(-7357297));
    bwu.put("darkslateblue", Integer.valueOf(-12042869));
    bwu.put("darkslategray", Integer.valueOf(-13676721));
    bwu.put("darkslategrey", Integer.valueOf(-13676721));
    bwu.put("darkturquoise", Integer.valueOf(-16724271));
    bwu.put("darkviolet", Integer.valueOf(-7077677));
    bwu.put("deeppink", Integer.valueOf(-60269));
    bwu.put("deepskyblue", Integer.valueOf(-16728065));
    bwu.put("dimgray", Integer.valueOf(-9868951));
    bwu.put("dimgrey", Integer.valueOf(-9868951));
    bwu.put("dodgerblue", Integer.valueOf(-14774017));
    bwu.put("firebrick", Integer.valueOf(-5103070));
    bwu.put("floralwhite", Integer.valueOf(-1296));
    bwu.put("forestgreen", Integer.valueOf(-14513374));
    bwu.put("fuchsia", Integer.valueOf(-65281));
    bwu.put("gainsboro", Integer.valueOf(-2302756));
    bwu.put("ghostwhite", Integer.valueOf(-460545));
    bwu.put("gold", Integer.valueOf(-10496));
    bwu.put("goldenrod", Integer.valueOf(-2448096));
    bwu.put("gray", Integer.valueOf(-8355712));
    bwu.put("green", Integer.valueOf(-16744448));
    bwu.put("greenyellow", Integer.valueOf(-5374161));
    bwu.put("grey", Integer.valueOf(-8355712));
    bwu.put("honeydew", Integer.valueOf(-983056));
    bwu.put("hotpink", Integer.valueOf(-38476));
    bwu.put("indianred", Integer.valueOf(-3318692));
    bwu.put("indigo", Integer.valueOf(-11861886));
    bwu.put("ivory", Integer.valueOf(-16));
    bwu.put("khaki", Integer.valueOf(-989556));
    bwu.put("lavender", Integer.valueOf(-1644806));
    bwu.put("lavenderblush", Integer.valueOf(-3851));
    bwu.put("lawngreen", Integer.valueOf(-8586240));
    bwu.put("lemonchiffon", Integer.valueOf(-1331));
    bwu.put("lightblue", Integer.valueOf(-5383962));
    bwu.put("lightcoral", Integer.valueOf(-1015680));
    bwu.put("lightcyan", Integer.valueOf(-2031617));
    bwu.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    bwu.put("lightgray", Integer.valueOf(-2894893));
    bwu.put("lightgreen", Integer.valueOf(-7278960));
    bwu.put("lightgrey", Integer.valueOf(-2894893));
    bwu.put("lightpink", Integer.valueOf(-18751));
    bwu.put("lightsalmon", Integer.valueOf(-24454));
    bwu.put("lightseagreen", Integer.valueOf(-14634326));
    bwu.put("lightskyblue", Integer.valueOf(-7876870));
    bwu.put("lightslategray", Integer.valueOf(-8943463));
    bwu.put("lightslategrey", Integer.valueOf(-8943463));
    bwu.put("lightsteelblue", Integer.valueOf(-5192482));
    bwu.put("lightyellow", Integer.valueOf(-32));
    bwu.put("lime", Integer.valueOf(-16711936));
    bwu.put("limegreen", Integer.valueOf(-13447886));
    bwu.put("linen", Integer.valueOf(-331546));
    bwu.put("magenta", Integer.valueOf(-65281));
    bwu.put("maroon", Integer.valueOf(-8388608));
    bwu.put("mediumaquamarine", Integer.valueOf(-10039894));
    bwu.put("mediumblue", Integer.valueOf(-16777011));
    bwu.put("mediumorchid", Integer.valueOf(-4565549));
    bwu.put("mediumpurple", Integer.valueOf(-7114533));
    bwu.put("mediumseagreen", Integer.valueOf(-12799119));
    bwu.put("mediumslateblue", Integer.valueOf(-8689426));
    bwu.put("mediumspringgreen", Integer.valueOf(-16713062));
    bwu.put("mediumturquoise", Integer.valueOf(-12004916));
    bwu.put("mediumvioletred", Integer.valueOf(-3730043));
    bwu.put("midnightblue", Integer.valueOf(-15132304));
    bwu.put("mintcream", Integer.valueOf(-655366));
    bwu.put("mistyrose", Integer.valueOf(-6943));
    bwu.put("moccasin", Integer.valueOf(-6987));
    bwu.put("navajowhite", Integer.valueOf(-8531));
    bwu.put("navy", Integer.valueOf(-16777088));
    bwu.put("oldlace", Integer.valueOf(-133658));
    bwu.put("olive", Integer.valueOf(-8355840));
    bwu.put("olivedrab", Integer.valueOf(-9728477));
    bwu.put("orange", Integer.valueOf(-23296));
    bwu.put("orangered", Integer.valueOf(-47872));
    bwu.put("orchid", Integer.valueOf(-2461482));
    bwu.put("palegoldenrod", Integer.valueOf(-1120086));
    bwu.put("palegreen", Integer.valueOf(-6751336));
    bwu.put("paleturquoise", Integer.valueOf(-5247250));
    bwu.put("palevioletred", Integer.valueOf(-2396013));
    bwu.put("papayawhip", Integer.valueOf(-4139));
    bwu.put("peachpuff", Integer.valueOf(-9543));
    bwu.put("peru", Integer.valueOf(-3308225));
    bwu.put("pink", Integer.valueOf(-16181));
    bwu.put("plum", Integer.valueOf(-2252579));
    bwu.put("powderblue", Integer.valueOf(-5185306));
    bwu.put("purple", Integer.valueOf(-8388480));
    bwu.put("rebeccapurple", Integer.valueOf(-10079335));
    bwu.put("red", Integer.valueOf(-65536));
    bwu.put("rosybrown", Integer.valueOf(-4419697));
    bwu.put("royalblue", Integer.valueOf(-12490271));
    bwu.put("saddlebrown", Integer.valueOf(-7650029));
    bwu.put("salmon", Integer.valueOf(-360334));
    bwu.put("sandybrown", Integer.valueOf(-744352));
    bwu.put("seagreen", Integer.valueOf(-13726889));
    bwu.put("seashell", Integer.valueOf(-2578));
    bwu.put("sienna", Integer.valueOf(-6270419));
    bwu.put("silver", Integer.valueOf(-4144960));
    bwu.put("skyblue", Integer.valueOf(-7876885));
    bwu.put("slateblue", Integer.valueOf(-9807155));
    bwu.put("slategray", Integer.valueOf(-9404272));
    bwu.put("slategrey", Integer.valueOf(-9404272));
    bwu.put("snow", Integer.valueOf(-1286));
    bwu.put("springgreen", Integer.valueOf(-16711809));
    bwu.put("steelblue", Integer.valueOf(-12156236));
    bwu.put("tan", Integer.valueOf(-2968436));
    bwu.put("teal", Integer.valueOf(-16744320));
    bwu.put("thistle", Integer.valueOf(-2572328));
    bwu.put("tomato", Integer.valueOf(-40121));
    bwu.put("transparent", Integer.valueOf(0));
    bwu.put("turquoise", Integer.valueOf(-12525360));
    bwu.put("violet", Integer.valueOf(-1146130));
    bwu.put("wheat", Integer.valueOf(-663885));
    bwu.put("white", Integer.valueOf(-1));
    bwu.put("whitesmoke", Integer.valueOf(-657931));
    bwu.put("yellow", Integer.valueOf(-256));
    bwu.put("yellowgreen", Integer.valueOf(-6632142));
    AppMethodBeat.o(93132);
  }
  
  public static int aC(String paramString)
  {
    AppMethodBeat.i(93128);
    int i = h(paramString, false);
    AppMethodBeat.o(93128);
    return i;
  }
  
  public static int aD(String paramString)
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
        paramString = bwt;
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
        paramString = bws;
        break;
      }
    }
    else if (str.startsWith("rgb"))
    {
      paramString = bwr.matcher(str);
      if (paramString.matches())
      {
        i = rgb(Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
        AppMethodBeat.o(93130);
        return i;
      }
    }
    else
    {
      paramString = (Integer)bwu.get(x.aO(str));
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