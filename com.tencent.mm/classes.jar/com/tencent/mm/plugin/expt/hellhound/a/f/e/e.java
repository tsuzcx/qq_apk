package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/SessionPagePathMatch;", "", "()V", "Companion", "plugin-expt_release"})
public final class e
{
  public static final a qZn;
  
  static
  {
    AppMethodBeat.i(210974);
    qZn = new a((byte)0);
    AppMethodBeat.o(210974);
  }
  
  public static final String afn(String paramString)
  {
    AppMethodBeat.i(210975);
    if (paramString == null)
    {
      AppMethodBeat.o(210975);
      return null;
    }
    String str1 = "";
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (c != '^')
      {
        str1 = p.C(str1, Character.valueOf(c));
        i += 1;
      }
      else if (paramString.charAt(i + 1) != '^')
      {
        String str2 = paramString.substring(i + 1, i + 3);
        p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int k = a.dg(str2, 2);
        c = paramString.charAt(i + 3);
        int j = a.dg(String.valueOf(c) + "", 1) + 5;
        if (str1 == null) {
          p.gfZ();
        }
        k = str1.length() - k - j;
        str2 = str1.substring(k, j + k);
        p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        str1 = str1 + str2;
        i += 4;
      }
      else
      {
        str1 = p.C(str1, "^".concat(String.valueOf("")));
        i += 2;
      }
    }
    AppMethodBeat.o(210975);
    return str1;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/SessionPagePathMatch$Companion;", "", "()V", "LZ77_DECODE_CHAR", "", "LZ77_DECODE_INT_BASE", "", "LZ77_DECODE_INT_CEIL_CODE", "LZ77_DECODE_INT_FLOOR_CODE", "LZ77_DECODE_MIN_STRING_LEN", "PARAM_TYPE_PAGE", "PARAM_TYPE_VIEW", "decodeJson", "", "json", "decodeReferenceInt", "data", "width", "decodeReferenceLength", "decompressJson", "getPagesInPathConfig", "", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "curPageName", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "plugin-expt_release"})
  public static final class a
  {
    static int dg(String paramString, int paramInt)
    {
      AppMethodBeat.i(210973);
      int j = 0;
      int i = 0;
      for (;;)
      {
        int k = i;
        int m;
        if (j < paramInt)
        {
          i *= 64;
          m = paramString.charAt(j);
          if (32 <= m) {
            break label47;
          }
          k = i;
        }
        label47:
        do
        {
          AppMethodBeat.o(210973);
          return k;
          k = i;
        } while (95 < m);
        i += m - 32;
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.e
 * JD-Core Version:    0.7.0.1
 */