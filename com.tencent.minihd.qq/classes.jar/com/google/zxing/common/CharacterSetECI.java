package com.google.zxing.common;

import java.util.HashMap;
import java.util.Map;

public enum CharacterSetECI
{
  private static final Map NAME_TO_ECI;
  private static final Map VALUE_TO_ECI;
  private final String[] otherEncodingNames;
  private final int[] values;
  
  static
  {
    ISO8859_10 = new CharacterSetECI("ISO8859_10", 10, 12, new String[] { "ISO-8859-10" });
    ISO8859_11 = new CharacterSetECI("ISO8859_11", 11, 13, new String[] { "ISO-8859-11" });
    ISO8859_13 = new CharacterSetECI("ISO8859_13", 12, 15, new String[] { "ISO-8859-13" });
    ISO8859_14 = new CharacterSetECI("ISO8859_14", 13, 16, new String[] { "ISO-8859-14" });
    ISO8859_15 = new CharacterSetECI("ISO8859_15", 14, 17, new String[] { "ISO-8859-15" });
    ISO8859_16 = new CharacterSetECI("ISO8859_16", 15, 18, new String[] { "ISO-8859-16" });
    SJIS = new CharacterSetECI("SJIS", 16, 20, new String[] { "Shift_JIS" });
    Cp1250 = new CharacterSetECI("Cp1250", 17, 21, new String[] { "windows-1250" });
    Cp1251 = new CharacterSetECI("Cp1251", 18, 22, new String[] { "windows-1251" });
    Cp1252 = new CharacterSetECI("Cp1252", 19, 23, new String[] { "windows-1252" });
    Cp1256 = new CharacterSetECI("Cp1256", 20, 24, new String[] { "windows-1256" });
    UnicodeBigUnmarked = new CharacterSetECI("UnicodeBigUnmarked", 21, 25, new String[] { "UTF-16BE", "UnicodeBig" });
    UTF8 = new CharacterSetECI("UTF8", 22, 26, new String[] { "UTF-8" });
    ASCII = new CharacterSetECI("ASCII", 23, new int[] { 27, 170 }, new String[] { "US-ASCII" });
    Big5 = new CharacterSetECI("Big5", 24, 28);
    GB18030 = new CharacterSetECI("GB18030", 25, 29, new String[] { "GB2312", "EUC_CN", "GBK" });
    EUC_KR = new CharacterSetECI("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    $VALUES = new CharacterSetECI[] { Cp437, ISO8859_1, ISO8859_2, ISO8859_3, ISO8859_4, ISO8859_5, ISO8859_6, ISO8859_7, ISO8859_8, ISO8859_9, ISO8859_10, ISO8859_11, ISO8859_13, ISO8859_14, ISO8859_15, ISO8859_16, SJIS, Cp1250, Cp1251, Cp1252, Cp1256, UnicodeBigUnmarked, UTF8, ASCII, Big5, GB18030, EUC_KR };
    VALUE_TO_ECI = new HashMap();
    NAME_TO_ECI = new HashMap();
    CharacterSetECI[] arrayOfCharacterSetECI = values();
    int k = arrayOfCharacterSetECI.length;
    int i = 0;
    while (i < k)
    {
      CharacterSetECI localCharacterSetECI = arrayOfCharacterSetECI[i];
      Object localObject1 = localCharacterSetECI.values;
      int m = localObject1.length;
      int j = 0;
      while (j < m)
      {
        int n = localObject1[j];
        VALUE_TO_ECI.put(Integer.valueOf(n), localCharacterSetECI);
        j += 1;
      }
      NAME_TO_ECI.put(localCharacterSetECI.name(), localCharacterSetECI);
      localObject1 = localCharacterSetECI.otherEncodingNames;
      m = localObject1.length;
      j = 0;
      while (j < m)
      {
        Object localObject2 = localObject1[j];
        NAME_TO_ECI.put(localObject2, localCharacterSetECI);
        j += 1;
      }
      i += 1;
    }
  }
  
  private CharacterSetECI(int paramInt)
  {
    this(new int[] { paramInt }, new String[0]);
  }
  
  private CharacterSetECI(int paramInt, String... paramVarArgs)
  {
    this.values = new int[] { paramInt };
    this.otherEncodingNames = paramVarArgs;
  }
  
  private CharacterSetECI(int[] paramArrayOfInt, String... paramVarArgs)
  {
    this.values = paramArrayOfInt;
    this.otherEncodingNames = paramVarArgs;
  }
  
  public static CharacterSetECI getCharacterSetECIByName(String paramString)
  {
    return (CharacterSetECI)NAME_TO_ECI.get(paramString);
  }
  
  public int getValue()
  {
    return this.values[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.google.zxing.common.CharacterSetECI
 * JD-Core Version:    0.7.0.1
 */