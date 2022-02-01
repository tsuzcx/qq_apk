package com.tencent.mm.plugin.expt.hellhound.ext.session.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/SessionPagePathMatch;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final a zKR;
  
  static
  {
    AppMethodBeat.i(300198);
    zKR = new a((byte)0);
    AppMethodBeat.o(300198);
  }
  
  public static final String ata(String paramString)
  {
    AppMethodBeat.i(300195);
    if (paramString == null)
    {
      AppMethodBeat.o(300195);
      return null;
    }
    String str1 = "";
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (c != '^')
      {
        str1 = s.X(str1, Character.valueOf(c));
        i += 1;
      }
      else if (paramString.charAt(i + 1) != '^')
      {
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(300195);
          throw paramString;
        }
        String str2 = paramString.substring(i + 1, i + 3);
        s.s(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int k = a.eo(str2, 2);
        c = paramString.charAt(i + 3);
        int j = a.eo(String.valueOf(c) + "", 1) + 5;
        s.checkNotNull(str1);
        k = str1.length() - k - j;
        str2 = str1.substring(k, j + k);
        s.s(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        str1 = s.X(str1, str2);
        i += 4;
      }
      else
      {
        str1 = s.X(str1, "^".concat(String.valueOf("")));
        i += 2;
      }
    }
    AppMethodBeat.o(300195);
    return str1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/SessionPagePathMatch$Companion;", "", "()V", "LZ77_DECODE_CHAR", "", "LZ77_DECODE_INT_BASE", "", "LZ77_DECODE_INT_CEIL_CODE", "LZ77_DECODE_INT_FLOOR_CODE", "LZ77_DECODE_MIN_STRING_LEN", "PARAM_TYPE_PAGE", "PARAM_TYPE_VIEW", "decodeJson", "", "json", "decodeReferenceInt", "data", "width", "decodeReferenceLength", "decompressJson", "getPagesInPathConfig", "", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "curPageName", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static int eo(String paramString, int paramInt)
    {
      AppMethodBeat.i(300197);
      int i;
      int j;
      int k;
      if (paramInt > 0)
      {
        i = 0;
        j = 0;
        k = i + 1;
        int m = j * 64;
        int n = paramString.charAt(i);
        if (32 <= n) {
          if (n <= 95)
          {
            i = 1;
            label47:
            j = m;
            if (i != 0)
            {
              j = m + (n - 32);
              if (k < paramInt) {
                break label86;
              }
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(300197);
        return j;
        i = 0;
        break label47;
        i = 0;
        break label47;
        label86:
        i = k;
        break;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.d.e
 * JD-Core Version:    0.7.0.1
 */