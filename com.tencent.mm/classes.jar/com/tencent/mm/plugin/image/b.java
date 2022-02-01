package com.tencent.mm.plugin.image;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.UnsupportedEncodingException;

public final class b
{
  public String JEV;
  public String JEW;
  public int JEX;
  public int JEY;
  public int JEZ;
  public int JFa;
  public int JFb;
  public int JFc;
  public String md5;
  
  private static int Pp(String paramString)
  {
    AppMethodBeat.i(151489);
    try
    {
      paramString = BitmapUtil.getImageOptions(paramString);
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
  
  public static int aIP(String paramString)
  {
    AppMethodBeat.i(260353);
    int i = Pp(paramString);
    if (paramString.indexOf("png") >= 0) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(260353);
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
  
  public static String aIQ(String paramString)
  {
    AppMethodBeat.i(151488);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151488);
      return "";
    }
    paramString = paramString.replace(",", ";");
    AppMethodBeat.o(151488);
    return paramString;
  }
  
  public static String alV(String paramString)
  {
    AppMethodBeat.i(151487);
    paramString = y.bi(paramString, 0, 6);
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
        Log.e("MicroMsg.ImgExtInfoReport", "getFileExt UnsupportedEncodingException:".concat(String.valueOf(paramString)));
        paramString = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.image.b
 * JD-Core Version:    0.7.0.1
 */