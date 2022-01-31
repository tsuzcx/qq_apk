package com.tencent.mm.plugin.downloader.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static void a(long paramLong, float paramFloat, int paramInt)
  {
    y.d("MicroMsg.FileDownloadSP", "speed = " + paramFloat);
    int i = Math.round(100.0F * paramFloat);
    String str1 = i + "_" + paramInt;
    y.d("MicroMsg.FileDownloadSP", "speedStr = " + str1);
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("download_pref", 0);
    String str2;
    if (localSharedPreferences != null)
    {
      str2 = localSharedPreferences.getString(String.valueOf(paramLong), "");
      if (!bk.bl(str2)) {
        break label187;
      }
    }
    for (str1 = "1_" + str1 + "|";; str1 = str2 + (paramInt + 1) + "_" + str1 + "|")
    {
      y.d("MicroMsg.FileDownloadSP", "saveDownloadSpeed, speedStr = " + str1);
      localSharedPreferences.edit().putString(String.valueOf(paramLong), str1).apply();
      return;
      label187:
      String[] arrayOfString = str2.split("\\|");
      paramInt = bk.getInt(arrayOfString[(arrayOfString.length - 1)].split("_")[0], 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.h.b
 * JD-Core Version:    0.7.0.1
 */