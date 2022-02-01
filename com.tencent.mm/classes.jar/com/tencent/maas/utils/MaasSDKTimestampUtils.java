package com.tencent.maas.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/maas/utils/MaasSDKTimestampUtils;", "", "()V", "TAG", "", "convertToSimplifiedChinese", "number", "", "convertToSimplifiedChineseForYear", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "formatTimestamp", "timestampMs", "", "format", "localeStr", "getLocationString", "longitude", "", "latitude", "log", "", "tag", "msg", "parseDateNumber2Capital", "date", "trim0", "MaasSDK_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MaasSDKTimestampUtils
{
  public static final MaasSDKTimestampUtils INSTANCE;
  private static final String TAG = "MaasSDKTimestamp";
  
  static
  {
    AppMethodBeat.i(216797);
    INSTANCE = new MaasSDKTimestampUtils();
    AppMethodBeat.o(216797);
  }
  
  private final String convertToSimplifiedChinese(int paramInt)
  {
    AppMethodBeat.i(216777);
    Object localObject1 = String.valueOf(paramInt);
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(216777);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((String)localObject1).toCharArray();
    s.s(localObject1, "(this as java.lang.String).toCharArray()");
    StringBuffer localStringBuffer = new StringBuffer();
    int j = localObject1.length - 1;
    if (j >= 0) {}
    int i;
    for (paramInt = 0;; paramInt = i)
    {
      i = paramInt + 1;
      Object localObject2 = Integer.valueOf(String.valueOf(localObject1[paramInt]));
      s.s(localObject2, "valueOf(digits[i].toString())");
      int k = ((Number)localObject2).intValue();
      localObject2 = new String[] { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" }[k];
      paramInt = localObject1.length - paramInt - 1;
      String str = new String[] { "", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千", "兆" }[paramInt];
      if ((k == 0) && (paramInt % 4 == 0)) {
        localStringBuffer.append(str);
      }
      while (i > j)
      {
        localObject1 = localStringBuffer.toString();
        s.s(localObject1, "sb.toString()");
        AppMethodBeat.o(216777);
        return localObject1;
        if (k == 0)
        {
          localStringBuffer.append((String)localObject2);
        }
        else if ((k == 1) && (paramInt % 4 == 1))
        {
          localStringBuffer.append(str);
        }
        else
        {
          localStringBuffer.append((String)localObject2);
          localStringBuffer.append(str);
        }
      }
    }
  }
  
  private final String convertToSimplifiedChineseForYear(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(216794);
    Map localMap = ak.e(new r[] { v.Y(Character.valueOf('0'), Character.valueOf(38646)), v.Y(Character.valueOf('1'), Character.valueOf('一')), v.Y(Character.valueOf('2'), Character.valueOf('二')), v.Y(Character.valueOf('3'), Character.valueOf('三')), v.Y(Character.valueOf('4'), Character.valueOf('四')), v.Y(Character.valueOf('5'), Character.valueOf('五')), v.Y(Character.valueOf('6'), Character.valueOf('六')), v.Y(Character.valueOf('7'), Character.valueOf('七')), v.Y(Character.valueOf('8'), Character.valueOf('八')), v.Y(Character.valueOf('9'), Character.valueOf('九')) });
    CharSequence localCharSequence = (CharSequence)paramStringBuilder;
    int k = 0;
    int j = 0;
    while (k < localCharSequence.length())
    {
      char c = localCharSequence.charAt(k);
      int i;
      if ('0' <= c) {
        if (c <= '9') {
          i = 1;
        }
      }
      while (i != 0)
      {
        Character localCharacter = (Character)localMap.get(Character.valueOf(c));
        if (localCharacter == null)
        {
          paramStringBuilder = (Throwable)new IllegalStateException("ignored".toString());
          AppMethodBeat.o(216794);
          throw paramStringBuilder;
          i = 0;
          continue;
          i = 0;
        }
        else
        {
          paramStringBuilder.setCharAt(j, localCharacter.charValue());
        }
      }
      k += 1;
      j += 1;
    }
    paramStringBuilder = paramStringBuilder.toString();
    s.s(paramStringBuilder, "number.toString()");
    AppMethodBeat.o(216794);
    return paramStringBuilder;
  }
  
  private final String getLocationString(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(216791);
    String str1;
    if (paramDouble2 > 0.0D)
    {
      str1 = "N";
      if (paramDouble1 <= 0.0D) {
        break label137;
      }
    }
    label137:
    for (String str2 = "E";; str2 = "W")
    {
      double d1 = Math.abs(paramDouble2 - (int)paramDouble2);
      double d2 = Math.abs(paramDouble1 - (int)paramDouble1);
      str1 = (int)paramDouble2 + '°' + d1 * 60.0D + '\'' + str1 + ' ' + (int)paramDouble1 + '°' + d2 * 60.0D + '\'' + str2;
      AppMethodBeat.o(216791);
      return str1;
      str1 = "S";
      break;
    }
  }
  
  private final void log(String paramString1, String paramString2) {}
  
  private final String parseDateNumber2Capital(String paramString)
  {
    AppMethodBeat.i(216770);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int j = 1; j != 0; j = 0)
    {
      AppMethodBeat.o(216770);
      return "";
    }
    if ((paramString.charAt(n.bt((CharSequence)paramString)) == '日') || (paramString.charAt(n.bt((CharSequence)paramString)) == '天'))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      CharSequence localCharSequence = (CharSequence)localStringBuilder;
      int k = 0;
      int m = 0;
      label150:
      label156:
      label168:
      label424:
      label563:
      label565:
      label570:
      label573:
      label575:
      label580:
      label583:
      label585:
      if (m < localCharSequence.length())
      {
        int i = localCharSequence.charAt(m);
        INSTANCE.log("MaasSDKTimestamp", s.X("parse date, char: ", Character.valueOf(i)));
        if (i == 26085)
        {
          j = 1;
          if (j == 0) {
            break label273;
          }
          j = 1;
          if (j == 0) {
            break label331;
          }
          paramString = "";
          j = k - 1;
          if (j < -1) {}
        }
        try
        {
          n = Integer.parseInt(String.valueOf(localStringBuilder.charAt(j)));
          localObject1 = Integer.valueOf(n);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int n;
            localObject2 = null;
          }
          paramString = localObject2 + paramString;
          j -= 1;
        }
        if (localObject1 == null)
        {
          try
          {
            n = Integer.parseInt(paramString);
            paramString = Integer.valueOf(n);
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              paramString = null;
            }
          }
          if (paramString != null) {
            s.s(localStringBuilder.replace(j + 1, k, INSTANCE.convertToSimplifiedChinese(paramString.intValue())), "this.replace(startIndex, endIndex, value)");
          }
        }
        label331:
        label590:
        label593:
        for (;;)
        {
          m += 1;
          k += 1;
          break;
          if (i == 22825)
          {
            j = 1;
            break label150;
          }
          j = 0;
          break label150;
          if (i == 26376)
          {
            j = 1;
            break label156;
          }
          j = 0;
          break label156;
          Object localObject2;
          break label168;
          if ((i == 24180) && (k >= 4))
          {
            j = localStringBuilder.charAt(k - 1);
            if (48 <= j) {
              if (j <= 57)
              {
                j = 1;
                label368:
                if (j == 0) {
                  break label563;
                }
                j = localStringBuilder.charAt(k - 2);
                if (48 > j) {
                  break label570;
                }
                if (j > 57) {
                  break label565;
                }
                j = 1;
                if (j == 0) {
                  break label573;
                }
                j = localStringBuilder.charAt(k - 3);
                if (48 > j) {
                  break label580;
                }
                if (j > 57) {
                  break label575;
                }
                j = 1;
                if (j == 0) {
                  break label583;
                }
                j = localStringBuilder.charAt(k - 4);
                if (48 > j) {
                  break label590;
                }
                if (j > 57) {
                  break label585;
                }
                j = 1;
              }
            }
            for (;;)
            {
              if (j == 0) {
                break label593;
              }
              paramString = INSTANCE;
              localObject2 = new StringBuilder().append(localStringBuilder.charAt(k - 4)).append(localStringBuilder.charAt(k - 3)).append(localStringBuilder.charAt(k - 2)).append(localStringBuilder.charAt(k - 1));
              s.s(localObject2, "StringBuilder()\n                                        .append(realResultDate[i - 4])\n                                        .append(realResultDate[i - 3])\n                                        .append(realResultDate[i - 2])\n                                        .append(realResultDate[i - 1])");
              s.s(localStringBuilder.replace(k - 4, k, paramString.convertToSimplifiedChineseForYear(paramString.trim0((StringBuilder)localObject2))), "this.replace(startIndex, endIndex, value)");
              break;
              j = 0;
              break label368;
              j = 0;
              break label368;
              break;
              j = 0;
              break label396;
              j = 0;
              break label396;
              break;
              j = 0;
              break label424;
              j = 0;
              break label424;
              break;
              j = 0;
              continue;
              j = 0;
            }
          }
        }
      }
      label273:
      paramString = localStringBuilder.toString();
      label396:
      s.s(paramString, "realResultDate.toString()");
      AppMethodBeat.o(216770);
      return paramString;
    }
    AppMethodBeat.o(216770);
    return paramString;
  }
  
  private final StringBuilder trim0(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(216786);
    if (n.bu((CharSequence)paramStringBuilder))
    {
      CharSequence localCharSequence = (CharSequence)paramStringBuilder;
      int i = 0;
      int k;
      for (int j = 0; i < localCharSequence.length(); j = k)
      {
        k = j;
        if (localCharSequence.charAt(i) == '0') {
          k = j + 1;
        }
        i += 1;
      }
      if (j == paramStringBuilder.length())
      {
        paramStringBuilder = new StringBuilder("0");
        AppMethodBeat.o(216786);
        return paramStringBuilder;
      }
      paramStringBuilder = new StringBuilder(n.j((CharSequence)paramStringBuilder, 0, j));
      AppMethodBeat.o(216786);
      return paramStringBuilder;
    }
    AppMethodBeat.o(216786);
    return paramStringBuilder;
  }
  
  public final String formatTimestamp(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(216801);
    s.u(paramString1, "format");
    s.u(paramString2, "localeStr");
    Date localDate = new Date(paramLong);
    for (;;)
    {
      try
      {
        if (s.p(paramString2, "zh_CN"))
        {
          paramString2 = Locale.CHINA;
          if (paramString2 != null) {
            break label181;
          }
          localObject = Locale.CHINA;
          paramString1 = new SimpleDateFormat(paramString1, (Locale)localObject).format(localDate);
          if (!s.p(paramString2, Locale.CHINA))
          {
            INSTANCE.log("MaasSDKTimestamp", s.X("result: ", paramString1));
            AppMethodBeat.o(216801);
            return paramString1;
          }
        }
        else
        {
          if (!s.p(paramString2, "en_US")) {
            break label175;
          }
          paramString2 = Locale.US;
          continue;
        }
        paramString1 = parseDateNumber2Capital(paramString1);
        INSTANCE.log("MaasSDKTimestamp", s.X("result: ", paramString1));
        AppMethodBeat.o(216801);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        log("ParseDateFormat error", paramString1.getMessage());
        AppMethodBeat.o(216801);
        return null;
      }
      label175:
      paramString2 = null;
      continue;
      label181:
      Object localObject = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.maas.utils.MaasSDKTimestampUtils
 * JD-Core Version:    0.7.0.1
 */