package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class e
  extends b
{
  public static String esA;
  public static String esB;
  public static String esC;
  public static String esD;
  public static String esE;
  public static String esF;
  public static String esG;
  public static String esH;
  public static String esI;
  public static String esJ;
  public static String esK;
  public static String esL;
  public static String esM;
  public static String esN;
  public static String esO;
  public static String esP;
  public static String esQ;
  public static String esR;
  public static String esS;
  public static String esT;
  public static String esU;
  public static String esV;
  public static String esW;
  public static String esX;
  public static String esY;
  public static String esZ;
  public static final String eso;
  public static String esp;
  public static String esq;
  public static String esr;
  public static String ess;
  public static String est;
  public static String esu;
  public static String esv;
  public static String esw;
  public static String esx;
  public static String esy;
  public static String esz;
  public static String eta;
  public static String etb;
  public static String etc;
  public static String etd;
  public static String ete;
  
  static
  {
    AppMethodBeat.i(93069);
    eso = h.getExternalStorageDirectory().getParent();
    esp = eQz + "appbrand/";
    esq = eQz + "Download/";
    ess = eQz + "vusericon/";
    est = eQz + "Game/";
    esu = eQz + "CDNTemp/";
    esv = eQz + "Download/VoiceRemind";
    esw = eQz + "watchdog/";
    esx = eQz + "xlog";
    esy = eQz + "avatar/";
    esz = eQz + "exdevice/";
    esA = eQz + "newyear/";
    esB = eQz + "expose/";
    esC = eQz + "f2flucky/";
    esD = eQz + "WebviewCache/";
    esE = eQz + "pattern_recognition/";
    esF = eQz + "sniffer/";
    esG = eQz + "browser/";
    esH = eQz + "card/";
    esJ = eQz + "CheckResUpdate/";
    esK = eQz + "crash/";
    esL = eQz + "diskcache/";
    esM = eQz + "FailMsgFileCache/";
    esN = eQz + "fts/";
    esO = eQz + "Handler/";
    esP = eQz + "MixAudio/";
    esQ = eQz + "preloadedRes/";
    esR = eQz + "recovery/";
    esS = eQz + "share/";
    esT = esS + "upload_cache/";
    esU = eQz + "sns_ad_landingpages/";
    esV = eQz + "SQLTrace/";
    esW = eQz + "tracedog/";
    esX = eQz + "vproxy/";
    esY = eQz + "wagamefiles/";
    esZ = eQz + "wallet/";
    eta = eQz + "wepkg/";
    etb = eQz + "wxacache/";
    etc = eQz + "wxafiles/";
    etd = eQz + "wxajscahce/";
    ete = eQz + "wxanewfiles/";
    AppMethodBeat.o(93069);
  }
  
  public static void lo(String paramString)
  {
    AppMethodBeat.i(93068);
    ab.i("MicroMsg.CConstants", "initSdCardPath start SDCARD_ROOT: " + eQx);
    if (bo.isNullOrNil(paramString))
    {
      paramString = bd.dtF();
      int j = paramString.size();
      int i = 0;
      while (i < j)
      {
        ab.i("MicroMsg.CConstants", "initSdCardPath start list i = " + i + " StatMountParse: " + paramString.get(i));
        i += 1;
      }
      if (j > 1) {
        Collections.sort(paramString, new Comparator() {});
      }
      if ((j > 0) && (paramString.get(0) != null) && (!bo.isNullOrNil(((bd.a)paramString.get(0)).yqc)))
      {
        eQx = ((bd.a)paramString.get(0)).yqc;
        i = 0;
        while (i < j)
        {
          ab.i("MicroMsg.CConstants", "initSdCardPath end list i = " + i + " StatMountParse: " + paramString.get(i));
          i += 1;
        }
      }
    }
    else
    {
      eQx = paramString;
    }
    eQz = eQx + eQy;
    esq = eQz + "Download/";
    ess = eQz + "vusericon/";
    est = eQz + "Game/";
    esu = eQz + "CDNTemp/";
    esx = eQz + "xlog";
    eQA = eQz + "crash/";
    esy = eQz + "avatar/";
    esI = eQz + "Cache/";
    String str = eQz + "WeChat/";
    paramString = eQz + "WeiXin/";
    if (!com.tencent.mm.a.e.cN(str)) {
      if (!com.tencent.mm.a.e.cN(paramString)) {}
    }
    for (;;)
    {
      esr = paramString;
      ab.i("MicroMsg.CConstants", "initSdCardPath end SDCARD_ROOT: " + eQx);
      AppMethodBeat.o(93068);
      return;
      if (!aa.dsG().equals("zh_CN")) {
        paramString = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.e
 * JD-Core Version:    0.7.0.1
 */