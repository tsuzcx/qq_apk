package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private static final Pattern baI;
  private static final Pattern baJ;
  private static final Pattern baK;
  private static final Map<String, Integer> baL;
  
  static
  {
    AppMethodBeat.i(95872);
    baI = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    baJ = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    baK = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    HashMap localHashMap = new HashMap();
    baL = localHashMap;
    localHashMap.put("aliceblue", Integer.valueOf(-984833));
    baL.put("antiquewhite", Integer.valueOf(-332841));
    baL.put("aqua", Integer.valueOf(-16711681));
    baL.put("aquamarine", Integer.valueOf(-8388652));
    baL.put("azure", Integer.valueOf(-983041));
    baL.put("beige", Integer.valueOf(-657956));
    baL.put("bisque", Integer.valueOf(-6972));
    baL.put("black", Integer.valueOf(-16777216));
    baL.put("blanchedalmond", Integer.valueOf(-5171));
    baL.put("blue", Integer.valueOf(-16776961));
    baL.put("blueviolet", Integer.valueOf(-7722014));
    baL.put("brown", Integer.valueOf(-5952982));
    baL.put("burlywood", Integer.valueOf(-2180985));
    baL.put("cadetblue", Integer.valueOf(-10510688));
    baL.put("chartreuse", Integer.valueOf(-8388864));
    baL.put("chocolate", Integer.valueOf(-2987746));
    baL.put("coral", Integer.valueOf(-32944));
    baL.put("cornflowerblue", Integer.valueOf(-10185235));
    baL.put("cornsilk", Integer.valueOf(-1828));
    baL.put("crimson", Integer.valueOf(-2354116));
    baL.put("cyan", Integer.valueOf(-16711681));
    baL.put("darkblue", Integer.valueOf(-16777077));
    baL.put("darkcyan", Integer.valueOf(-16741493));
    baL.put("darkgoldenrod", Integer.valueOf(-4684277));
    baL.put("darkgray", Integer.valueOf(-5658199));
    baL.put("darkgreen", Integer.valueOf(-16751616));
    baL.put("darkgrey", Integer.valueOf(-5658199));
    baL.put("darkkhaki", Integer.valueOf(-4343957));
    baL.put("darkmagenta", Integer.valueOf(-7667573));
    baL.put("darkolivegreen", Integer.valueOf(-11179217));
    baL.put("darkorange", Integer.valueOf(-29696));
    baL.put("darkorchid", Integer.valueOf(-6737204));
    baL.put("darkred", Integer.valueOf(-7667712));
    baL.put("darksalmon", Integer.valueOf(-1468806));
    baL.put("darkseagreen", Integer.valueOf(-7357297));
    baL.put("darkslateblue", Integer.valueOf(-12042869));
    baL.put("darkslategray", Integer.valueOf(-13676721));
    baL.put("darkslategrey", Integer.valueOf(-13676721));
    baL.put("darkturquoise", Integer.valueOf(-16724271));
    baL.put("darkviolet", Integer.valueOf(-7077677));
    baL.put("deeppink", Integer.valueOf(-60269));
    baL.put("deepskyblue", Integer.valueOf(-16728065));
    baL.put("dimgray", Integer.valueOf(-9868951));
    baL.put("dimgrey", Integer.valueOf(-9868951));
    baL.put("dodgerblue", Integer.valueOf(-14774017));
    baL.put("firebrick", Integer.valueOf(-5103070));
    baL.put("floralwhite", Integer.valueOf(-1296));
    baL.put("forestgreen", Integer.valueOf(-14513374));
    baL.put("fuchsia", Integer.valueOf(-65281));
    baL.put("gainsboro", Integer.valueOf(-2302756));
    baL.put("ghostwhite", Integer.valueOf(-460545));
    baL.put("gold", Integer.valueOf(-10496));
    baL.put("goldenrod", Integer.valueOf(-2448096));
    baL.put("gray", Integer.valueOf(-8355712));
    baL.put("green", Integer.valueOf(-16744448));
    baL.put("greenyellow", Integer.valueOf(-5374161));
    baL.put("grey", Integer.valueOf(-8355712));
    baL.put("honeydew", Integer.valueOf(-983056));
    baL.put("hotpink", Integer.valueOf(-38476));
    baL.put("indianred", Integer.valueOf(-3318692));
    baL.put("indigo", Integer.valueOf(-11861886));
    baL.put("ivory", Integer.valueOf(-16));
    baL.put("khaki", Integer.valueOf(-989556));
    baL.put("lavender", Integer.valueOf(-1644806));
    baL.put("lavenderblush", Integer.valueOf(-3851));
    baL.put("lawngreen", Integer.valueOf(-8586240));
    baL.put("lemonchiffon", Integer.valueOf(-1331));
    baL.put("lightblue", Integer.valueOf(-5383962));
    baL.put("lightcoral", Integer.valueOf(-1015680));
    baL.put("lightcyan", Integer.valueOf(-2031617));
    baL.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    baL.put("lightgray", Integer.valueOf(-2894893));
    baL.put("lightgreen", Integer.valueOf(-7278960));
    baL.put("lightgrey", Integer.valueOf(-2894893));
    baL.put("lightpink", Integer.valueOf(-18751));
    baL.put("lightsalmon", Integer.valueOf(-24454));
    baL.put("lightseagreen", Integer.valueOf(-14634326));
    baL.put("lightskyblue", Integer.valueOf(-7876870));
    baL.put("lightslategray", Integer.valueOf(-8943463));
    baL.put("lightslategrey", Integer.valueOf(-8943463));
    baL.put("lightsteelblue", Integer.valueOf(-5192482));
    baL.put("lightyellow", Integer.valueOf(-32));
    baL.put("lime", Integer.valueOf(-16711936));
    baL.put("limegreen", Integer.valueOf(-13447886));
    baL.put("linen", Integer.valueOf(-331546));
    baL.put("magenta", Integer.valueOf(-65281));
    baL.put("maroon", Integer.valueOf(-8388608));
    baL.put("mediumaquamarine", Integer.valueOf(-10039894));
    baL.put("mediumblue", Integer.valueOf(-16777011));
    baL.put("mediumorchid", Integer.valueOf(-4565549));
    baL.put("mediumpurple", Integer.valueOf(-7114533));
    baL.put("mediumseagreen", Integer.valueOf(-12799119));
    baL.put("mediumslateblue", Integer.valueOf(-8689426));
    baL.put("mediumspringgreen", Integer.valueOf(-16713062));
    baL.put("mediumturquoise", Integer.valueOf(-12004916));
    baL.put("mediumvioletred", Integer.valueOf(-3730043));
    baL.put("midnightblue", Integer.valueOf(-15132304));
    baL.put("mintcream", Integer.valueOf(-655366));
    baL.put("mistyrose", Integer.valueOf(-6943));
    baL.put("moccasin", Integer.valueOf(-6987));
    baL.put("navajowhite", Integer.valueOf(-8531));
    baL.put("navy", Integer.valueOf(-16777088));
    baL.put("oldlace", Integer.valueOf(-133658));
    baL.put("olive", Integer.valueOf(-8355840));
    baL.put("olivedrab", Integer.valueOf(-9728477));
    baL.put("orange", Integer.valueOf(-23296));
    baL.put("orangered", Integer.valueOf(-47872));
    baL.put("orchid", Integer.valueOf(-2461482));
    baL.put("palegoldenrod", Integer.valueOf(-1120086));
    baL.put("palegreen", Integer.valueOf(-6751336));
    baL.put("paleturquoise", Integer.valueOf(-5247250));
    baL.put("palevioletred", Integer.valueOf(-2396013));
    baL.put("papayawhip", Integer.valueOf(-4139));
    baL.put("peachpuff", Integer.valueOf(-9543));
    baL.put("peru", Integer.valueOf(-3308225));
    baL.put("pink", Integer.valueOf(-16181));
    baL.put("plum", Integer.valueOf(-2252579));
    baL.put("powderblue", Integer.valueOf(-5185306));
    baL.put("purple", Integer.valueOf(-8388480));
    baL.put("rebeccapurple", Integer.valueOf(-10079335));
    baL.put("red", Integer.valueOf(-65536));
    baL.put("rosybrown", Integer.valueOf(-4419697));
    baL.put("royalblue", Integer.valueOf(-12490271));
    baL.put("saddlebrown", Integer.valueOf(-7650029));
    baL.put("salmon", Integer.valueOf(-360334));
    baL.put("sandybrown", Integer.valueOf(-744352));
    baL.put("seagreen", Integer.valueOf(-13726889));
    baL.put("seashell", Integer.valueOf(-2578));
    baL.put("sienna", Integer.valueOf(-6270419));
    baL.put("silver", Integer.valueOf(-4144960));
    baL.put("skyblue", Integer.valueOf(-7876885));
    baL.put("slateblue", Integer.valueOf(-9807155));
    baL.put("slategray", Integer.valueOf(-9404272));
    baL.put("slategrey", Integer.valueOf(-9404272));
    baL.put("snow", Integer.valueOf(-1286));
    baL.put("springgreen", Integer.valueOf(-16711809));
    baL.put("steelblue", Integer.valueOf(-12156236));
    baL.put("tan", Integer.valueOf(-2968436));
    baL.put("teal", Integer.valueOf(-16744320));
    baL.put("thistle", Integer.valueOf(-2572328));
    baL.put("tomato", Integer.valueOf(-40121));
    baL.put("transparent", Integer.valueOf(0));
    baL.put("turquoise", Integer.valueOf(-12525360));
    baL.put("violet", Integer.valueOf(-1146130));
    baL.put("wheat", Integer.valueOf(-663885));
    baL.put("white", Integer.valueOf(-1));
    baL.put("whitesmoke", Integer.valueOf(-657931));
    baL.put("yellow", Integer.valueOf(-256));
    baL.put("yellowgreen", Integer.valueOf(-6632142));
    AppMethodBeat.o(95872);
  }
  
  public static int aE(String paramString)
  {
    AppMethodBeat.i(95868);
    int i = h(paramString, false);
    AppMethodBeat.o(95868);
    return i;
  }
  
  public static int aF(String paramString)
  {
    AppMethodBeat.i(95869);
    int i = h(paramString, true);
    AppMethodBeat.o(95869);
    return i;
  }
  
  private static int argb(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  private static int h(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(95870);
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
      AppMethodBeat.o(95870);
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
    AppMethodBeat.o(95870);
    throw paramString;
    label126:
    if (str.startsWith("rgba"))
    {
      if (paramBoolean)
      {
        paramString = baK;
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
        AppMethodBeat.o(95870);
        return i;
        paramString = baJ;
        break;
      }
    }
    else if (str.startsWith("rgb"))
    {
      paramString = baI.matcher(str);
      if (paramString.matches())
      {
        i = rgb(Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
        AppMethodBeat.o(95870);
        return i;
      }
    }
    else
    {
      paramString = (Integer)baL.get(x.aQ(str));
      if (paramString != null)
      {
        i = paramString.intValue();
        AppMethodBeat.o(95870);
        return i;
      }
    }
    label227:
    paramString = new IllegalArgumentException();
    label344:
    AppMethodBeat.o(95870);
    throw paramString;
  }
  
  private static int rgb(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95871);
    paramInt1 = argb(255, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(95871);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.i.e
 * JD-Core Version:    0.7.0.1
 */