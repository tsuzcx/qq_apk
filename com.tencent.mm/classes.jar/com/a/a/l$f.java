package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

 enum l$f
{
  private static final Map<String, f> aOa;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(214940);
    aUk = new f("CLASS", 0);
    aUl = new f("clip", 1);
    aUm = new f("clip_path", 2);
    aUn = new f("clipPathUnits", 3);
    aUo = new f("clip_rule", 4);
    aUp = new f("color", 5);
    aUq = new f("cx", 6);
    aUr = new f("cy", 7);
    aUs = new f("direction", 8);
    aUt = new f("dx", 9);
    aUu = new f("dy", 10);
    aUv = new f("fx", 11);
    aUw = new f("fy", 12);
    aUx = new f("d", 13);
    aUy = new f("display", 14);
    aUz = new f("fill", 15);
    aUA = new f("fill_rule", 16);
    aUB = new f("fill_opacity", 17);
    aUC = new f("font", 18);
    aUD = new f("font_family", 19);
    aUE = new f("font_size", 20);
    aUF = new f("font_weight", 21);
    aUG = new f("font_style", 22);
    aUH = new f("gradientTransform", 23);
    aUI = new f("gradientUnits", 24);
    aUJ = new f("height", 25);
    aUK = new f("href", 26);
    aUL = new f("image_rendering", 27);
    aUM = new f("marker", 28);
    aUN = new f("marker_start", 29);
    aUO = new f("marker_mid", 30);
    aUP = new f("marker_end", 31);
    aUQ = new f("markerHeight", 32);
    aUR = new f("markerUnits", 33);
    aUS = new f("markerWidth", 34);
    aUT = new f("mask", 35);
    aUU = new f("maskContentUnits", 36);
    aUV = new f("maskUnits", 37);
    aUW = new f("media", 38);
    aUX = new f("offset", 39);
    aUY = new f("opacity", 40);
    aUZ = new f("orient", 41);
    aVa = new f("overflow", 42);
    aVb = new f("pathLength", 43);
    aVc = new f("patternContentUnits", 44);
    aVd = new f("patternTransform", 45);
    aVe = new f("patternUnits", 46);
    aVf = new f("points", 47);
    aVg = new f("preserveAspectRatio", 48);
    aVh = new f("r", 49);
    aVi = new f("refX", 50);
    aVj = new f("refY", 51);
    aVk = new f("requiredFeatures", 52);
    aVl = new f("requiredExtensions", 53);
    aVm = new f("requiredFormats", 54);
    aVn = new f("requiredFonts", 55);
    aVo = new f("rx", 56);
    aVp = new f("ry", 57);
    aVq = new f("solid_color", 58);
    aVr = new f("solid_opacity", 59);
    aVs = new f("spreadMethod", 60);
    aVt = new f("startOffset", 61);
    aVu = new f("stop_color", 62);
    aVv = new f("stop_opacity", 63);
    aVw = new f("stroke", 64);
    aVx = new f("stroke_dasharray", 65);
    aVy = new f("stroke_dashoffset", 66);
    aVz = new f("stroke_linecap", 67);
    aVA = new f("stroke_linejoin", 68);
    aVB = new f("stroke_miterlimit", 69);
    aVC = new f("stroke_opacity", 70);
    aVD = new f("stroke_width", 71);
    aVE = new f("style", 72);
    aVF = new f("systemLanguage", 73);
    aVG = new f("text_anchor", 74);
    aVH = new f("text_decoration", 75);
    aVI = new f("transform", 76);
    aVJ = new f("type", 77);
    aVK = new f("vector_effect", 78);
    aVL = new f("version", 79);
    aVM = new f("viewBox", 80);
    aVN = new f("width", 81);
    aVO = new f("x", 82);
    aVP = new f("y", 83);
    aVQ = new f("x1", 84);
    aVR = new f("y1", 85);
    aVS = new f("x2", 86);
    aVT = new f("y2", 87);
    aVU = new f("viewport_fill", 88);
    aVV = new f("viewport_fill_opacity", 89);
    aVW = new f("visibility", 90);
    aVX = new f("UNSUPPORTED", 91);
    aVY = new f[] { aUk, aUl, aUm, aUn, aUo, aUp, aUq, aUr, aUs, aUt, aUu, aUv, aUw, aUx, aUy, aUz, aUA, aUB, aUC, aUD, aUE, aUF, aUG, aUH, aUI, aUJ, aUK, aUL, aUM, aUN, aUO, aUP, aUQ, aUR, aUS, aUT, aUU, aUV, aUW, aUX, aUY, aUZ, aVa, aVb, aVc, aVd, aVe, aVf, aVg, aVh, aVi, aVj, aVk, aVl, aVm, aVn, aVo, aVp, aVq, aVr, aVs, aVt, aVu, aVv, aVw, aVx, aVy, aVz, aVA, aVB, aVC, aVD, aVE, aVF, aVG, aVH, aVI, aVJ, aVK, aVL, aVM, aVN, aVO, aVP, aVQ, aVR, aVS, aVT, aVU, aVV, aVW, aVX };
    aOa = new HashMap();
    f[] arrayOff = values();
    int j = arrayOff.length;
    if (i < j)
    {
      f localf = arrayOff[i];
      if (localf == aUk) {
        aOa.put("class", localf);
      }
      for (;;)
      {
        i += 1;
        break;
        if (localf != aVX)
        {
          String str = localf.name().replace('_', '-');
          aOa.put(str, localf);
        }
      }
    }
    AppMethodBeat.o(214940);
  }
  
  private l$f() {}
  
  public static f aM(String paramString)
  {
    AppMethodBeat.i(214939);
    paramString = (f)aOa.get(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(214939);
      return paramString;
    }
    paramString = aVX;
    AppMethodBeat.o(214939);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.a.a.l.f
 * JD-Core Version:    0.7.0.1
 */