package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaterialModel
  implements Parcelable
{
  public static final Parcelable.Creator<MaterialModel> CREATOR;
  private static final Map<String, String> tsd;
  public final String mimeType;
  public String trT;
  
  static
  {
    AppMethodBeat.i(323664);
    HashMap localHashMap = new HashMap(32);
    localHashMap.put("docm", "application/vnd.ms-word.document.macroEnabled.12");
    localHashMap.put("xlsm", "application/vnd.ms-excel.sheet.macroEnabled.12");
    localHashMap.put("wps", "application/wps-office.wps");
    localHashMap.put("et", "application/wps-office.et");
    localHashMap.put("rar", "application/vnd.rar");
    localHashMap.put("7z", "application/x-7z-compressed");
    localHashMap.put("psd", "application/x-photoshop");
    localHashMap.put("dwg", "application/acad");
    localHashMap.put("cdr", "application/x-cdr");
    localHashMap.put("dxf", "application/dxf");
    localHashMap.put("stp", "application/step");
    localHashMap.put("rtf", "application/rtf");
    localHashMap.put("ai", "application/postscript");
    localHashMap.put("doc", "application/msword");
    localHashMap.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    localHashMap.put("xls", "application/vnd.ms-excel");
    localHashMap.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    localHashMap.put("ppt", "application/vnd.ms-powerpoint");
    localHashMap.put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
    localHashMap.put("txt", "text/plain");
    localHashMap.put("csv", "text/csv");
    localHashMap.put("pdf", "application/pdf");
    localHashMap.put("zip", "application/zip");
    tsd = Collections.unmodifiableMap(localHashMap);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(323664);
  }
  
  protected MaterialModel(Parcel paramParcel)
  {
    AppMethodBeat.i(323656);
    this.mimeType = Util.nullAs(paramParcel.readString(), "");
    this.trT = Util.nullAs(paramParcel.readString(), "");
    AppMethodBeat.o(323656);
  }
  
  private MaterialModel(String paramString1, String paramString2)
  {
    this.mimeType = paramString1;
    this.trT = paramString2;
  }
  
  public static MaterialModel aer(String paramString)
  {
    AppMethodBeat.i(323612);
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromWebView, materialUrl: ".concat(String.valueOf(paramString)));
    paramString = new MaterialModel("text/html", paramString);
    AppMethodBeat.o(323612);
    return paramString;
  }
  
  public static MaterialModel aes(String paramString)
  {
    AppMethodBeat.i(323621);
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, materialLocalPath: ".concat(String.valueOf(paramString)));
    String str3 = y.alV(paramString);
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, materialExt: ".concat(String.valueOf(str3)));
    String str2 = aet(str3);
    String str1 = str2;
    if (str2 == null) {
      str1 = MimeTypeUtil.getMimeTypeByFileExt(str3);
    }
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, mimeType: ".concat(String.valueOf(str1)));
    if (str1 == null)
    {
      AppMethodBeat.o(323621);
      return null;
    }
    paramString = new MaterialModel(str1, paramString);
    AppMethodBeat.o(323621);
    return paramString;
  }
  
  private static String aet(String paramString)
  {
    AppMethodBeat.i(323643);
    Log.d("MicroMsg.AppBrand.MaterialModel", "getMimeTypeByFileExtHardCode, fileExt: ".concat(String.valueOf(paramString)));
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(323643);
      return null;
    }
    paramString = paramString.toLowerCase();
    paramString = (String)tsd.get(paramString);
    AppMethodBeat.o(323643);
    return paramString;
  }
  
  public static MaterialModel cDu()
  {
    AppMethodBeat.i(323637);
    MaterialModel localMaterialModel = new MaterialModel("", "");
    AppMethodBeat.o(323637);
    return localMaterialModel;
  }
  
  public static MaterialModel fg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(323600);
    Log.d("MicroMsg.AppBrand.MaterialModel", "from, mimeType: %s, materialPath: %s", new Object[] { paramString1, paramString2 });
    paramString1 = new MaterialModel(paramString1, paramString2);
    AppMethodBeat.o(323600);
    return paramString1;
  }
  
  public static MaterialModel fh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(323629);
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, materialLocalPath: %s, materialExt: %s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = aes(paramString1);
      AppMethodBeat.o(323629);
      return paramString1;
    }
    String str2 = aet(paramString2);
    String str1 = str2;
    if (str2 == null) {
      str1 = MimeTypeUtil.getMimeTypeByFileExt(paramString2);
    }
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, mimeType: ".concat(String.valueOf(str1)));
    if (str1 == null)
    {
      AppMethodBeat.o(323629);
      return null;
    }
    paramString1 = new MaterialModel(str1, paramString1);
    AppMethodBeat.o(323629);
    return paramString1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(323669);
    String str = "MaterialModel{mimeType='" + this.mimeType + '\'' + ", materialPath='" + this.trT + '\'' + '}';
    AppMethodBeat.o(323669);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(323683);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.trT);
    AppMethodBeat.o(323683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel
 * JD-Core Version:    0.7.0.1
 */