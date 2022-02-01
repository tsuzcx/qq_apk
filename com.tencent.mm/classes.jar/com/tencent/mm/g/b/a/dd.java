package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class dd
  extends a
{
  private String _ID;
  private long dVd;
  private long dXH;
  private long eeb;
  private long eec;
  private long eed;
  private long eee;
  private long eef;
  private long eeg;
  private String eeh;
  private String eei;
  private long eej;
  private long eek;
  private String eel;
  private String eem;
  public long een;
  private long eeo;
  private long eep;
  private String eeq;
  private String eer;
  private String ees;
  private long eet;
  private String eeu;
  private String eev;
  private String eew;
  public long eex;
  
  public dd()
  {
    this._ID = "";
    this.dXH = 0L;
    this.eeb = 0L;
    this.eec = 0L;
    this.eed = 0L;
    this.eee = 0L;
    this.eef = 0L;
    this.eeg = 0L;
    this.eeh = "";
    this.eei = "";
    this.eej = 0L;
    this.eek = 0L;
    this.eel = "";
    this.eem = "";
    this.een = 0L;
    this.dVd = 0L;
    this.eeo = 0L;
    this.eep = 0L;
    this.eeq = "";
    this.eer = "";
    this.ees = "";
    this.eet = 0L;
    this.eeu = "";
    this.eev = "";
    this.eew = "";
    this.eex = 0L;
  }
  
  public dd(String paramString)
  {
    AppMethodBeat.i(94820);
    this._ID = "";
    this.dXH = 0L;
    this.eeb = 0L;
    this.eec = 0L;
    this.eed = 0L;
    this.eee = 0L;
    this.eef = 0L;
    this.eeg = 0L;
    this.eeh = "";
    this.eei = "";
    this.eej = 0L;
    this.eek = 0L;
    this.eel = "";
    this.eem = "";
    this.een = 0L;
    this.dVd = 0L;
    this.eeo = 0L;
    this.eep = 0L;
    this.eeq = "";
    this.eer = "";
    this.ees = "";
    this.eet = 0L;
    this.eeu = "";
    this.eev = "";
    this.eew = "";
    this.eex = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 26) {
          break label537;
        }
        String[] arrayOfString = new String[26];
        Arrays.fill(arrayOfString, 0, 26, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label537:
    for (;;)
    {
      this._ID = t("ID", paramString[0], true);
      this.dXH = bt.getLong(paramString[1], 0L);
      this.eeb = bt.getLong(paramString[2], 0L);
      this.eec = bt.getLong(paramString[3], 0L);
      this.eed = bt.getLong(paramString[4], 0L);
      this.eee = bt.getLong(paramString[5], 0L);
      this.eef = bt.getLong(paramString[6], 0L);
      this.eeg = bt.getLong(paramString[7], 0L);
      this.eeh = t("FNumber", paramString[8], true);
      this.eei = t("ExposureTime", paramString[9], true);
      this.eej = bt.getLong(paramString[10], 0L);
      this.eek = bt.getLong(paramString[11], 0L);
      this.eel = t("LensModel", paramString[12], true);
      this.eem = t("CreatTime", paramString[13], true);
      this.een = bt.getLong(paramString[14], 0L);
      this.dVd = bt.getLong(paramString[15], 0L);
      this.eeo = bt.getLong(paramString[16], 0L);
      this.eep = bt.getLong(paramString[17], 0L);
      this.eeq = t("make", paramString[18], true);
      this.eer = t("software", paramString[19], true);
      this.ees = t("fileExt", paramString[20], true);
      this.eet = bt.getLong(paramString[21], 0L);
      this.eeu = t("YCbCrSubSampling", paramString[22], true);
      this.eev = t("md5", paramString[23], true);
      mr(paramString[24]);
      this.eex = bt.getLong(paramString[25], 0L);
      AppMethodBeat.o(94820);
      return;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(94822);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this._ID);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eec);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eed);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eee);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eei);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eej);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eek);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eel);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eem);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.een);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eep);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eer);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ees);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eet);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eev);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eew);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eex);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(94822);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(94823);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ID:").append(this._ID);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.dXH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginWidth:").append(this.eeb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginHeight:").append(this.eec);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedWidth:").append(this.eed);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedHeight:").append(this.eee);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginSize:").append(this.eef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedSize:").append(this.eeg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FNumber:").append(this.eeh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposureTime:").append(this.eei);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ISO:").append(this.eej);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Flash:").append(this.eek);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LensModel:").append(this.eel);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreatTime:").append(this.eem);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFromWeChat:").append(this.een);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneType:").append(this.eeo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSource:").append(this.eep);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("make:").append(this.eeq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("software:").append(this.eer);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileExt:").append(this.ees);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("faceCount:").append(this.eet);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("YCbCrSubSampling:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.eev);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("publishId:").append(this.eew);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("destMeidaType:").append(this.eex);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94823);
    return localObject;
  }
  
  public final int getId()
  {
    return 16585;
  }
  
  public final dd mr(String paramString)
  {
    AppMethodBeat.i(94821);
    this.eew = t("publishId", paramString, true);
    AppMethodBeat.o(94821);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dd
 * JD-Core Version:    0.7.0.1
 */