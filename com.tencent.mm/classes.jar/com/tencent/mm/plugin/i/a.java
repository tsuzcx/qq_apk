package com.tencent.mm.plugin.i;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.io.UnsupportedEncodingException;

public final class a
{
  public String cqq;
  public String nLb;
  public String nLc;
  public int nLd;
  public int nLe;
  public int nLf;
  public int nLg;
  public int nLh;
  public int nLi;
  
  public static String QU(String paramString)
  {
    AppMethodBeat.i(79093);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79093);
      return "";
    }
    paramString = paramString.replace(",", ";");
    AppMethodBeat.o(79093);
    return paramString;
  }
  
  public static String cP(String paramString)
  {
    AppMethodBeat.i(79092);
    paramString = e.i(paramString, 0, 6);
    if ((paramString == null) || (paramString.length != 6))
    {
      AppMethodBeat.o(79092);
      return "";
    }
    try
    {
      paramString = new String(paramString, "UTF-8");
      AppMethodBeat.o(79092);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.ImgExtInfoReport", "getFileExt UnsupportedEncodingException:".concat(String.valueOf(paramString)));
        paramString = "";
      }
    }
  }
  
  public static int uD(String paramString)
  {
    AppMethodBeat.i(79094);
    try
    {
      paramString = d.aoT(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(79094);
        return 0;
      }
      paramString = paramString.outMimeType;
      if (paramString == null)
      {
        AppMethodBeat.o(79094);
        return 0;
      }
      paramString = paramString.toLowerCase();
      int i = paramString.indexOf("png");
      if (i >= 0)
      {
        AppMethodBeat.o(79094);
        return 1;
      }
      i = paramString.indexOf("jpg");
      if (i >= 0)
      {
        AppMethodBeat.o(79094);
        return 2;
      }
      i = paramString.indexOf("jpeg");
      if (i >= 0)
      {
        AppMethodBeat.o(79094);
        return 2;
      }
      AppMethodBeat.o(79094);
      return 0;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(79094);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a
 * JD-Core Version:    0.7.0.1
 */