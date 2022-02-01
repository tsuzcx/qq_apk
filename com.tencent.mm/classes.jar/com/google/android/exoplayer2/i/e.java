package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private static final Pattern dkj;
  private static final Pattern dkk;
  private static final Pattern dkl;
  private static final Map<String, Integer> dkm;
  
  static
  {
    AppMethodBeat.i(93132);
    dkj = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    dkk = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    dkl = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    HashMap localHashMap = new HashMap();
    dkm = localHashMap;
    localHashMap.put("aliceblue", Integer.valueOf(-984833));
    dkm.put("antiquewhite", Integer.valueOf(-332841));
    dkm.put("aqua", Integer.valueOf(-16711681));
    dkm.put("aquamarine", Integer.valueOf(-8388652));
    dkm.put("azure", Integer.valueOf(-983041));
    dkm.put("beige", Integer.valueOf(-657956));
    dkm.put("bisque", Integer.valueOf(-6972));
    dkm.put("black", Integer.valueOf(-16777216));
    dkm.put("blanchedalmond", Integer.valueOf(-5171));
    dkm.put("blue", Integer.valueOf(-16776961));
    dkm.put("blueviolet", Integer.valueOf(-7722014));
    dkm.put("brown", Integer.valueOf(-5952982));
    dkm.put("burlywood", Integer.valueOf(-2180985));
    dkm.put("cadetblue", Integer.valueOf(-10510688));
    dkm.put("chartreuse", Integer.valueOf(-8388864));
    dkm.put("chocolate", Integer.valueOf(-2987746));
    dkm.put("coral", Integer.valueOf(-32944));
    dkm.put("cornflowerblue", Integer.valueOf(-10185235));
    dkm.put("cornsilk", Integer.valueOf(-1828));
    dkm.put("crimson", Integer.valueOf(-2354116));
    dkm.put("cyan", Integer.valueOf(-16711681));
    dkm.put("darkblue", Integer.valueOf(-16777077));
    dkm.put("darkcyan", Integer.valueOf(-16741493));
    dkm.put("darkgoldenrod", Integer.valueOf(-4684277));
    dkm.put("darkgray", Integer.valueOf(-5658199));
    dkm.put("darkgreen", Integer.valueOf(-16751616));
    dkm.put("darkgrey", Integer.valueOf(-5658199));
    dkm.put("darkkhaki", Integer.valueOf(-4343957));
    dkm.put("darkmagenta", Integer.valueOf(-7667573));
    dkm.put("darkolivegreen", Integer.valueOf(-11179217));
    dkm.put("darkorange", Integer.valueOf(-29696));
    dkm.put("darkorchid", Integer.valueOf(-6737204));
    dkm.put("darkred", Integer.valueOf(-7667712));
    dkm.put("darksalmon", Integer.valueOf(-1468806));
    dkm.put("darkseagreen", Integer.valueOf(-7357297));
    dkm.put("darkslateblue", Integer.valueOf(-12042869));
    dkm.put("darkslategray", Integer.valueOf(-13676721));
    dkm.put("darkslategrey", Integer.valueOf(-13676721));
    dkm.put("darkturquoise", Integer.valueOf(-16724271));
    dkm.put("darkviolet", Integer.valueOf(-7077677));
    dkm.put("deeppink", Integer.valueOf(-60269));
    dkm.put("deepskyblue", Integer.valueOf(-16728065));
    dkm.put("dimgray", Integer.valueOf(-9868951));
    dkm.put("dimgrey", Integer.valueOf(-9868951));
    dkm.put("dodgerblue", Integer.valueOf(-14774017));
    dkm.put("firebrick", Integer.valueOf(-5103070));
    dkm.put("floralwhite", Integer.valueOf(-1296));
    dkm.put("forestgreen", Integer.valueOf(-14513374));
    dkm.put("fuchsia", Integer.valueOf(-65281));
    dkm.put("gainsboro", Integer.valueOf(-2302756));
    dkm.put("ghostwhite", Integer.valueOf(-460545));
    dkm.put("gold", Integer.valueOf(-10496));
    dkm.put("goldenrod", Integer.valueOf(-2448096));
    dkm.put("gray", Integer.valueOf(-8355712));
    dkm.put("green", Integer.valueOf(-16744448));
    dkm.put("greenyellow", Integer.valueOf(-5374161));
    dkm.put("grey", Integer.valueOf(-8355712));
    dkm.put("honeydew", Integer.valueOf(-983056));
    dkm.put("hotpink", Integer.valueOf(-38476));
    dkm.put("indianred", Integer.valueOf(-3318692));
    dkm.put("indigo", Integer.valueOf(-11861886));
    dkm.put("ivory", Integer.valueOf(-16));
    dkm.put("khaki", Integer.valueOf(-989556));
    dkm.put("lavender", Integer.valueOf(-1644806));
    dkm.put("lavenderblush", Integer.valueOf(-3851));
    dkm.put("lawngreen", Integer.valueOf(-8586240));
    dkm.put("lemonchiffon", Integer.valueOf(-1331));
    dkm.put("lightblue", Integer.valueOf(-5383962));
    dkm.put("lightcoral", Integer.valueOf(-1015680));
    dkm.put("lightcyan", Integer.valueOf(-2031617));
    dkm.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    dkm.put("lightgray", Integer.valueOf(-2894893));
    dkm.put("lightgreen", Integer.valueOf(-7278960));
    dkm.put("lightgrey", Integer.valueOf(-2894893));
    dkm.put("lightpink", Integer.valueOf(-18751));
    dkm.put("lightsalmon", Integer.valueOf(-24454));
    dkm.put("lightseagreen", Integer.valueOf(-14634326));
    dkm.put("lightskyblue", Integer.valueOf(-7876870));
    dkm.put("lightslategray", Integer.valueOf(-8943463));
    dkm.put("lightslategrey", Integer.valueOf(-8943463));
    dkm.put("lightsteelblue", Integer.valueOf(-5192482));
    dkm.put("lightyellow", Integer.valueOf(-32));
    dkm.put("lime", Integer.valueOf(-16711936));
    dkm.put("limegreen", Integer.valueOf(-13447886));
    dkm.put("linen", Integer.valueOf(-331546));
    dkm.put("magenta", Integer.valueOf(-65281));
    dkm.put("maroon", Integer.valueOf(-8388608));
    dkm.put("mediumaquamarine", Integer.valueOf(-10039894));
    dkm.put("mediumblue", Integer.valueOf(-16777011));
    dkm.put("mediumorchid", Integer.valueOf(-4565549));
    dkm.put("mediumpurple", Integer.valueOf(-7114533));
    dkm.put("mediumseagreen", Integer.valueOf(-12799119));
    dkm.put("mediumslateblue", Integer.valueOf(-8689426));
    dkm.put("mediumspringgreen", Integer.valueOf(-16713062));
    dkm.put("mediumturquoise", Integer.valueOf(-12004916));
    dkm.put("mediumvioletred", Integer.valueOf(-3730043));
    dkm.put("midnightblue", Integer.valueOf(-15132304));
    dkm.put("mintcream", Integer.valueOf(-655366));
    dkm.put("mistyrose", Integer.valueOf(-6943));
    dkm.put("moccasin", Integer.valueOf(-6987));
    dkm.put("navajowhite", Integer.valueOf(-8531));
    dkm.put("navy", Integer.valueOf(-16777088));
    dkm.put("oldlace", Integer.valueOf(-133658));
    dkm.put("olive", Integer.valueOf(-8355840));
    dkm.put("olivedrab", Integer.valueOf(-9728477));
    dkm.put("orange", Integer.valueOf(-23296));
    dkm.put("orangered", Integer.valueOf(-47872));
    dkm.put("orchid", Integer.valueOf(-2461482));
    dkm.put("palegoldenrod", Integer.valueOf(-1120086));
    dkm.put("palegreen", Integer.valueOf(-6751336));
    dkm.put("paleturquoise", Integer.valueOf(-5247250));
    dkm.put("palevioletred", Integer.valueOf(-2396013));
    dkm.put("papayawhip", Integer.valueOf(-4139));
    dkm.put("peachpuff", Integer.valueOf(-9543));
    dkm.put("peru", Integer.valueOf(-3308225));
    dkm.put("pink", Integer.valueOf(-16181));
    dkm.put("plum", Integer.valueOf(-2252579));
    dkm.put("powderblue", Integer.valueOf(-5185306));
    dkm.put("purple", Integer.valueOf(-8388480));
    dkm.put("rebeccapurple", Integer.valueOf(-10079335));
    dkm.put("red", Integer.valueOf(-65536));
    dkm.put("rosybrown", Integer.valueOf(-4419697));
    dkm.put("royalblue", Integer.valueOf(-12490271));
    dkm.put("saddlebrown", Integer.valueOf(-7650029));
    dkm.put("salmon", Integer.valueOf(-360334));
    dkm.put("sandybrown", Integer.valueOf(-744352));
    dkm.put("seagreen", Integer.valueOf(-13726889));
    dkm.put("seashell", Integer.valueOf(-2578));
    dkm.put("sienna", Integer.valueOf(-6270419));
    dkm.put("silver", Integer.valueOf(-4144960));
    dkm.put("skyblue", Integer.valueOf(-7876885));
    dkm.put("slateblue", Integer.valueOf(-9807155));
    dkm.put("slategray", Integer.valueOf(-9404272));
    dkm.put("slategrey", Integer.valueOf(-9404272));
    dkm.put("snow", Integer.valueOf(-1286));
    dkm.put("springgreen", Integer.valueOf(-16711809));
    dkm.put("steelblue", Integer.valueOf(-12156236));
    dkm.put("tan", Integer.valueOf(-2968436));
    dkm.put("teal", Integer.valueOf(-16744320));
    dkm.put("thistle", Integer.valueOf(-2572328));
    dkm.put("tomato", Integer.valueOf(-40121));
    dkm.put("transparent", Integer.valueOf(0));
    dkm.put("turquoise", Integer.valueOf(-12525360));
    dkm.put("violet", Integer.valueOf(-1146130));
    dkm.put("wheat", Integer.valueOf(-663885));
    dkm.put("white", Integer.valueOf(-1));
    dkm.put("whitesmoke", Integer.valueOf(-657931));
    dkm.put("yellow", Integer.valueOf(-256));
    dkm.put("yellowgreen", Integer.valueOf(-6632142));
    AppMethodBeat.o(93132);
  }
  
  private static int G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93131);
    paramInt1 = v(255, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(93131);
    return paramInt1;
  }
  
  public static int cY(String paramString)
  {
    AppMethodBeat.i(93128);
    int i = g(paramString, false);
    AppMethodBeat.o(93128);
    return i;
  }
  
  public static int cZ(String paramString)
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
        paramString = dkl;
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
        i = v(i, Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
        AppMethodBeat.o(93130);
        return i;
        paramString = dkk;
        break;
      }
    }
    else if (str.startsWith("rgb"))
    {
      paramString = dkj.matcher(str);
      if (paramString.matches())
      {
        i = G(Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
        AppMethodBeat.o(93130);
        return i;
      }
    }
    else
    {
      paramString = (Integer)dkm.get(x.ds(str));
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
  
  private static int v(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.exoplayer2.i.e
 * JD-Core Version:    0.7.0.1
 */