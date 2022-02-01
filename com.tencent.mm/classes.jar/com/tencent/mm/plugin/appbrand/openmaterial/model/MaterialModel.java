package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaterialModel
  implements Parcelable
{
  public static final Parcelable.Creator<MaterialModel> CREATOR;
  private static final Map<String, String> qnw;
  public final String mimeType;
  public String qnl;
  
  static
  {
    AppMethodBeat.i(190738);
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
    qnw = Collections.unmodifiableMap(localHashMap);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(190738);
  }
  
  protected MaterialModel(Parcel paramParcel)
  {
    AppMethodBeat.i(190722);
    this.mimeType = Util.nullAs(paramParcel.readString(), "");
    this.qnl = Util.nullAs(paramParcel.readString(), "");
    AppMethodBeat.o(190722);
  }
  
  private MaterialModel(String paramString1, String paramString2)
  {
    this.mimeType = paramString1;
    this.qnl = paramString2;
  }
  
  public static MaterialModel alk(String paramString)
  {
    AppMethodBeat.i(190697);
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromWebView, materialUrl: ".concat(String.valueOf(paramString)));
    paramString = new MaterialModel("text/html", paramString);
    AppMethodBeat.o(190697);
    return paramString;
  }
  
  public static MaterialModel all(String paramString)
  {
    AppMethodBeat.i(190698);
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, materialLocalPath: ".concat(String.valueOf(paramString)));
    String str3 = u.asq(paramString);
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, materialExt: ".concat(String.valueOf(str3)));
    String str2 = alm(str3);
    String str1 = str2;
    if (str2 == null) {
      str1 = MimeTypeUtil.getMimeTypeByFileExt(str3);
    }
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, mimeType: ".concat(String.valueOf(str1)));
    if (str1 == null)
    {
      AppMethodBeat.o(190698);
      return null;
    }
    paramString = new MaterialModel(str1, paramString);
    AppMethodBeat.o(190698);
    return paramString;
  }
  
  private static String alm(String paramString)
  {
    AppMethodBeat.i(190712);
    Log.d("MicroMsg.AppBrand.MaterialModel", "getMimeTypeByFileExtHardCode, fileExt: ".concat(String.valueOf(paramString)));
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(190712);
      return null;
    }
    paramString = paramString.toLowerCase();
    paramString = (String)qnw.get(paramString);
    AppMethodBeat.o(190712);
    return paramString;
  }
  
  public static MaterialModel ccW()
  {
    AppMethodBeat.i(190708);
    MaterialModel localMaterialModel = new MaterialModel("", "");
    AppMethodBeat.o(190708);
    return localMaterialModel;
  }
  
  public static MaterialModel eP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190695);
    Log.d("MicroMsg.AppBrand.MaterialModel", "from, mimeType: %s, materialPath: %s", new Object[] { paramString1, paramString2 });
    paramString1 = new MaterialModel(paramString1, paramString2);
    AppMethodBeat.o(190695);
    return paramString1;
  }
  
  public static MaterialModel eQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190704);
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, materialLocalPath: %s, materialExt: %s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = all(paramString1);
      AppMethodBeat.o(190704);
      return paramString1;
    }
    String str2 = alm(paramString2);
    String str1 = str2;
    if (str2 == null) {
      str1 = MimeTypeUtil.getMimeTypeByFileExt(paramString2);
    }
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, mimeType: ".concat(String.valueOf(str1)));
    if (str1 == null)
    {
      AppMethodBeat.o(190704);
      return null;
    }
    paramString1 = new MaterialModel(str1, paramString1);
    AppMethodBeat.o(190704);
    return paramString1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(190719);
    String str = "MaterialModel{mimeType='" + this.mimeType + '\'' + ", materialPath='" + this.qnl + '\'' + '}';
    AppMethodBeat.o(190719);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(190724);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.qnl);
    AppMethodBeat.o(190724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel
 * JD-Core Version:    0.7.0.1
 */