package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaterialModel
  implements Parcelable
{
  public static final Parcelable.Creator<MaterialModel> CREATOR;
  private static final Map<String, String> nlS;
  public final String mimeType;
  public String nlI;
  
  static
  {
    AppMethodBeat.i(194384);
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
    nlS = Collections.unmodifiableMap(localHashMap);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(194384);
  }
  
  protected MaterialModel(Parcel paramParcel)
  {
    AppMethodBeat.i(194382);
    this.mimeType = Util.nullAs(paramParcel.readString(), "");
    this.nlI = Util.nullAs(paramParcel.readString(), "");
    AppMethodBeat.o(194382);
  }
  
  private MaterialModel(String paramString1, String paramString2)
  {
    this.mimeType = paramString1;
    this.nlI = paramString2;
  }
  
  public static MaterialModel adp(String paramString)
  {
    AppMethodBeat.i(194376);
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromWebView, materialUrl: ".concat(String.valueOf(paramString)));
    paramString = new MaterialModel("text/html", paramString);
    AppMethodBeat.o(194376);
    return paramString;
  }
  
  public static MaterialModel adq(String paramString)
  {
    AppMethodBeat.i(194377);
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, materialLocalPath: ".concat(String.valueOf(paramString)));
    String str3 = s.akC(paramString);
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, materialExt: ".concat(String.valueOf(str3)));
    String str2 = adr(str3);
    String str1 = str2;
    if (str2 == null) {
      str1 = MimeTypeUtil.getMimeTypeByFileExt(str3);
    }
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, mimeType: ".concat(String.valueOf(str1)));
    if (str1 == null)
    {
      AppMethodBeat.o(194377);
      return null;
    }
    paramString = new MaterialModel(str1, paramString);
    AppMethodBeat.o(194377);
    return paramString;
  }
  
  private static String adr(String paramString)
  {
    AppMethodBeat.i(194380);
    Log.d("MicroMsg.AppBrand.MaterialModel", "getMimeTypeByFileExtHardCode, fileExt: ".concat(String.valueOf(paramString)));
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(194380);
      return null;
    }
    paramString = paramString.toLowerCase();
    paramString = (String)nlS.get(paramString);
    AppMethodBeat.o(194380);
    return paramString;
  }
  
  public static MaterialModel bQg()
  {
    AppMethodBeat.i(194379);
    MaterialModel localMaterialModel = new MaterialModel("", "");
    AppMethodBeat.o(194379);
    return localMaterialModel;
  }
  
  public static MaterialModel eB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194375);
    Log.d("MicroMsg.AppBrand.MaterialModel", "from, mimeType: %s, materialPath: %s", new Object[] { paramString1, paramString2 });
    paramString1 = new MaterialModel(paramString1, paramString2);
    AppMethodBeat.o(194375);
    return paramString1;
  }
  
  public static MaterialModel eC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194378);
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, materialLocalPath: %s, materialExt: %s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = adq(paramString1);
      AppMethodBeat.o(194378);
      return paramString1;
    }
    String str2 = adr(paramString2);
    String str1 = str2;
    if (str2 == null) {
      str1 = MimeTypeUtil.getMimeTypeByFileExt(paramString2);
    }
    Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, mimeType: ".concat(String.valueOf(str1)));
    if (str1 == null)
    {
      AppMethodBeat.o(194378);
      return null;
    }
    paramString1 = new MaterialModel(str1, paramString1);
    AppMethodBeat.o(194378);
    return paramString1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(194381);
    String str = "MaterialModel{mimeType='" + this.mimeType + '\'' + ", materialPath='" + this.nlI + '\'' + '}';
    AppMethodBeat.o(194381);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(194383);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeString(this.nlI);
    AppMethodBeat.o(194383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel
 * JD-Core Version:    0.7.0.1
 */