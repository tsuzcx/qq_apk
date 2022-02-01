package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.UnsupportedEncodingException;

public final class a
{
  public static int CL(String paramString)
  {
    k = 0;
    AppMethodBeat.i(43007);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      ac.e("Big5Util", "getStrokesCount buffer is empty");
      AppMethodBeat.o(43007);
      return 0;
    }
    for (;;)
    {
      try
      {
        paramString = paramString.getBytes("big5");
        if ((paramString != null) && (paramString.length >= 2)) {
          continue;
        }
        ac.e("Big5Util", "byteToShort");
        j = 0;
        if ((j < 42048) || (j > 42049)) {
          continue;
        }
        i = 1;
      }
      catch (UnsupportedEncodingException paramString)
      {
        int j;
        ac.e("Big5Util", "exception:%s", new Object[] { bs.m(paramString) });
        int i = k;
        continue;
      }
      AppMethodBeat.o(43007);
      return i;
      i = 0;
      j = 0;
      if (i < 2)
      {
        j = (short)((short)(j << 8) | paramString[i] & 0xFF);
        i += 1;
      }
      else
      {
        j = 0xFFFF & j;
        continue;
        if (((j >= 42050) && (j <= 42067)) || ((j >= 51520) && (j <= 51524)))
        {
          i = 2;
        }
        else if (((j >= 42068) && (j <= 42110)) || ((j >= 51525) && (j <= 51532)))
        {
          i = 3;
        }
        else if (((j >= 42145) && (j <= 42237)) || ((j >= 51533) && (j <= 51548)))
        {
          i = 4;
        }
        else if (((j >= 42238) && (j <= 42463)) || ((j >= 51549) && (j <= 51626)))
        {
          i = 5;
        }
        else if (((j >= 42464) && (j <= 42729)) || ((j >= 51627) && (j <= 51545)))
        {
          i = 6;
        }
        else if (((j >= 42730) && (j <= 43202)) || ((j >= 51802) && (j <= 52144)))
        {
          i = 7;
        }
        else if (((j >= 43203) && (j <= 43844)) || ((j >= 52145) && (j <= 52700)))
        {
          i = 8;
        }
        else if (((j >= 43845) && (j <= 44475)) || ((j >= 52701) && (j <= 53447)) || (j == 63962))
        {
          i = 9;
        }
        else if (((j >= 44476) && (j <= 45229)) || ((j >= 53448) && (j <= 54346)))
        {
          i = 10;
        }
        else if (((j >= 45230) && (j <= 46018)) || ((j >= 54347) && (j <= 55376)))
        {
          i = 11;
        }
        else if (((j >= 46019) && (j <= 46787)) || ((j >= 55377) && (j <= 56496)) || (j == 63963))
        {
          i = 12;
        }
        else if (((j >= 46788) && (j <= 47531)) || ((j >= 56497) && (j <= 57583)) || ((j >= 63958) && (j <= 63960)))
        {
          i = 13;
        }
        else if (((j >= 47532) && (j <= 48116)) || ((j >= 57584) && (j <= 58597)))
        {
          i = 14;
        }
        else if (((j >= 48117) && (j <= 48806)) || ((j >= 58598) && (j <= 59635)) || (j == 63964))
        {
          i = 15;
        }
        else if (((j >= 48807) && (j <= 49268)) || ((j >= 59636) && (j <= 60600)) || (j == 63961))
        {
          i = 16;
        }
        else if (((j >= 49269) && (j <= 49742)) || ((j >= 60601) && (j <= 61366)))
        {
          i = 17;
        }
        else if (((j >= 49743) && (j <= 50014)) || ((j >= 61367) && (j <= 61930)))
        {
          i = 18;
        }
        else if (((j >= 50015) && (j <= 50260)) || ((j >= 61931) && (j <= 62460)))
        {
          i = 19;
        }
        else if (((j >= 50261) && (j <= 50390)) || ((j >= 62461) && (j <= 62911)))
        {
          i = 20;
        }
        else if (((j >= 50135) && (j <= 50538)) || ((j >= 62912) && (j <= 63189)))
        {
          i = 21;
        }
        else if (((j >= 50539) && (j <= 50631)) || ((j >= 63190) && (j <= 63439)))
        {
          i = 22;
        }
        else if (((j >= 50632) && (j <= 50672)) || ((j >= 63440) && (j <= 63652)))
        {
          i = 23;
        }
        else if (((j >= 50673) && (j <= 50772)) || ((j >= 63653) && (j <= 63725)))
        {
          i = 24;
        }
        else if (((j >= 50773) && (j <= 50788)) || ((j >= 63721) && (j <= 63850)))
        {
          i = 25;
        }
        else if (((j >= 50789) && (j <= 50795)) || ((j >= 63906) && (j <= 63905)))
        {
          i = 26;
        }
        else if (((j >= 50796) && (j <= 50805)) || ((j >= 63190) && (j <= 63929)))
        {
          i = 27;
        }
        else if (((j >= 50806) && (j <= 50810)) || ((j >= 63930) && (j <= 63941)))
        {
          i = 28;
        }
        else if ((j < 50811) || (j > 50814))
        {
          i = k;
          if (j >= 63942)
          {
            i = k;
            if (j > 63957) {}
          }
        }
        else
        {
          i = 29;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aw.a
 * JD-Core Version:    0.7.0.1
 */