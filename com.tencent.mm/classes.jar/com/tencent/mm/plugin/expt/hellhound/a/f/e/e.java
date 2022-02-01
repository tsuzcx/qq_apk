package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/SessionPagePathMatch;", "", "()V", "Companion", "plugin-expt_release"})
public final class e
{
  public static final a sIP;
  
  static
  {
    AppMethodBeat.i(221137);
    sIP = new a((byte)0);
    AppMethodBeat.o(221137);
  }
  
  public static final String aqU(String paramString)
  {
    AppMethodBeat.i(221138);
    if (paramString == null)
    {
      AppMethodBeat.o(221138);
      return null;
    }
    String str1 = "";
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (c != '^')
      {
        str1 = p.I(str1, Character.valueOf(c));
        i += 1;
      }
      else if (paramString.charAt(i + 1) != '^')
      {
        String str2 = paramString.substring(i + 1, i + 3);
        p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int k = a.dq(str2, 2);
        c = paramString.charAt(i + 3);
        int j = a.dq(String.valueOf(c) + "", 1) + 5;
        if (str1 == null) {
          p.hyc();
        }
        k = str1.length() - k - j;
        str2 = str1.substring(k, j + k);
        p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        str1 = str1 + str2;
        i += 4;
      }
      else
      {
        str1 = p.I(str1, "^".concat(String.valueOf("")));
        i += 2;
      }
    }
    AppMethodBeat.o(221138);
    return str1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/SessionPagePathMatch$Companion;", "", "()V", "LZ77_DECODE_CHAR", "", "LZ77_DECODE_INT_BASE", "", "LZ77_DECODE_INT_CEIL_CODE", "LZ77_DECODE_INT_FLOOR_CODE", "LZ77_DECODE_MIN_STRING_LEN", "PARAM_TYPE_PAGE", "PARAM_TYPE_VIEW", "decodeJson", "", "json", "decodeReferenceInt", "data", "width", "decodeReferenceLength", "decompressJson", "getPagesInPathConfig", "", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "curPageName", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "plugin-expt_release"})
  public static final class a
  {
    static int dq(String paramString, int paramInt)
    {
      AppMethodBeat.i(221136);
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
          AppMethodBeat.o(221136);
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