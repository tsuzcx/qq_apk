package com.tencent.mm.compatible.util;

import com.tencent.mm.loader.a.b;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class e
  extends b
{
  public static final String dzA = h.getExternalStorageDirectory().getParent();
  public static String dzB = bkH + "Download/";
  public static String dzC;
  public static String dzD;
  public static String dzE = bkH + "vusericon/";
  public static String dzF = bkH + "Game/";
  public static String dzG = bkH + "CDNTemp/";
  public static String dzH = bkH + "Download/VoiceRemind";
  public static String dzI = bkH + "watchdog/";
  public static String dzJ = bkH + "xlog";
  public static String dzK = bkH + "avatar/";
  public static String dzL = bkH + "exdevice/";
  public static String dzM = bkH + "newyear/";
  public static String dzN = bkH + "expose/";
  public static String dzO = bkH + "f2flucky/";
  public static String dzP = bkH + "WebviewCache/";
  public static String dzQ = bkH + "pattern_recognition/";
  public static String dzR = bkH + "sniffer/";
  
  public static void fc(String paramString)
  {
    y.i("MicroMsg.CConstants", "initSdCardPath start SDCARD_ROOT: " + bkF);
    if (bk.bl(paramString))
    {
      paramString = az.crF();
      int j = paramString.size();
      int i = 0;
      while (i < j)
      {
        y.i("MicroMsg.CConstants", "initSdCardPath start list i = " + i + " StatMountParse: " + paramString.get(i));
        i += 1;
      }
      if (j > 1) {
        Collections.sort(paramString, new Comparator() {});
      }
      if ((j > 0) && (paramString.get(0) != null) && (!bk.bl(((az.a)paramString.get(0)).uhW)))
      {
        bkF = ((az.a)paramString.get(0)).uhW;
        i = 0;
        while (i < j)
        {
          y.i("MicroMsg.CConstants", "initSdCardPath end list i = " + i + " StatMountParse: " + paramString.get(i));
          i += 1;
        }
      }
    }
    else
    {
      bkF = paramString;
    }
    bkH = bkF + bkG;
    dzB = bkH + "Download/";
    dzE = bkH + "vusericon/";
    dzF = bkH + "Game/";
    dzG = bkH + "CDNTemp/";
    dzI = bkH + "watchdog/";
    dzJ = bkH + "xlog";
    dOR = bkH + "crash/";
    dzK = bkH + "avatar/";
    dzC = bkH + "Cache/";
    String str = bkH + "WeChat/";
    paramString = bkH + "WeiXin/";
    if (!com.tencent.mm.a.e.bK(str)) {
      if (!com.tencent.mm.a.e.bK(paramString)) {}
    }
    for (;;)
    {
      dzD = paramString;
      y.i("MicroMsg.CConstants", "initSdCardPath end SDCARD_ROOT: " + bkF);
      return;
      if (!x.cqJ().equals("zh_CN")) {
        paramString = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.e
 * JD-Core Version:    0.7.0.1
 */