package com.tencent.mm.plugin.image;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.vfs.i;
import java.io.UnsupportedEncodingException;

public final class b
{
  public String md5;
  public String uJq;
  public String uJr;
  public int uJs;
  public int uJt;
  public int uJu;
  public int uJv;
  public int uJw;
  public int uJx;
  
  private static int GA(String paramString)
  {
    AppMethodBeat.i(151489);
    try
    {
      paramString = g.aQc(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(151489);
        return 0;
      }
      paramString = paramString.outMimeType;
      if (paramString == null)
      {
        AppMethodBeat.o(151489);
        return 0;
      }
      paramString = paramString.toLowerCase();
      int i = paramString.indexOf("png");
      if (i >= 0)
      {
        AppMethodBeat.o(151489);
        return 1;
      }
      i = paramString.indexOf("jpg");
      if (i >= 0)
      {
        AppMethodBeat.o(151489);
        return 2;
      }
      i = paramString.indexOf("jpeg");
      if (i >= 0)
      {
        AppMethodBeat.o(151489);
        return 2;
      }
      i = paramString.indexOf("wxam");
      if (i >= 0)
      {
        AppMethodBeat.o(151489);
        return 4;
      }
      AppMethodBeat.o(151489);
      return 0;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(151489);
    }
    return 0;
  }
  
  public static String ZF(String paramString)
  {
    AppMethodBeat.i(151487);
    paramString = i.aY(paramString, 0, 6);
    if ((paramString == null) || (paramString.length != 6))
    {
      AppMethodBeat.o(151487);
      return "";
    }
    try
    {
      paramString = new String(paramString, "UTF-8");
      AppMethodBeat.o(151487);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.ImgExtInfoReport", "getFileExt UnsupportedEncodingException:".concat(String.valueOf(paramString)));
        paramString = "";
      }
    }
  }
  
  public static int ans(String paramString)
  {
    AppMethodBeat.i(195322);
    int i = GA(paramString);
    if (paramString.indexOf("png") >= 0) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(195322);
      return i;
      if ((paramString.indexOf("jpg") >= 0) || (paramString.indexOf("jpeg") >= 0)) {
        i = 2;
      } else if (paramString.indexOf("mp4") >= 0) {
        i = 3;
      } else if (paramString.indexOf("wxam") >= 0) {
        i = 4;
      }
    }
  }
  
  public static String ant(String paramString)
  {
    AppMethodBeat.i(151488);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151488);
      return "";
    }
    paramString = paramString.replace(",", ";");
    AppMethodBeat.o(151488);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.image.b
 * JD-Core Version:    0.7.0.1
 */