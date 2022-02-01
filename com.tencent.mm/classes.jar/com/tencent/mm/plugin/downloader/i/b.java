package com.tencent.mm.plugin.downloader.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  public static void a(long paramLong, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(89136);
    ad.d("MicroMsg.FileDownloadSP", "speed = ".concat(String.valueOf(paramFloat)));
    int i = Math.round(100.0F * paramFloat);
    String str = i + "_" + paramInt;
    ad.d("MicroMsg.FileDownloadSP", "speedStr = ".concat(String.valueOf(str)));
    m(paramLong, str);
    AppMethodBeat.o(89136);
  }
  
  private static void m(long paramLong, String paramString)
  {
    AppMethodBeat.i(89137);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("download_pref", 0);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(89137);
      return;
    }
    String str = localSharedPreferences.getString(String.valueOf(paramLong), "");
    if (bt.isNullOrNil(str)) {}
    int i;
    for (paramString = "1_" + paramString + "|";; paramString = str + (i + 1) + "_" + paramString + "|")
    {
      ad.d("MicroMsg.FileDownloadSP", "saveDownloadSpeed, speedStr = ".concat(String.valueOf(paramString)));
      localSharedPreferences.edit().putString(String.valueOf(paramLong), paramString).apply();
      AppMethodBeat.o(89137);
      return;
      String[] arrayOfString = str.split("\\|");
      i = bt.getInt(arrayOfString[(arrayOfString.length - 1)].split("_")[0], 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.i.b
 * JD-Core Version:    0.7.0.1
 */