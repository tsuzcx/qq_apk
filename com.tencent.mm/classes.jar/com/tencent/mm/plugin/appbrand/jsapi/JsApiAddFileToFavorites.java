package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddFileToFavorites;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "doAddFileToFavorites", "", "activity", "Landroid/app/Activity;", "filePath", "", "fileExt", "fileName", "doFavoriteAnyProcess", "", "handleErrorTypeAnyProcess", "", "ret", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "DoFavoriteParams", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiAddFileToFavorites
  extends c<f>
{
  private static final int CTRL_INDEX = 958;
  private static final String NAME = "addFileToFavorites";
  public static final JsApiAddFileToFavorites.a rwZ;
  
  static
  {
    AppMethodBeat.i(325667);
    rwZ = new JsApiAddFileToFavorites.a((byte)0);
    AppMethodBeat.o(325667);
  }
  
  private static final IPCInteger a(DoFavoriteParams paramDoFavoriteParams)
  {
    AppMethodBeat.i(325665);
    try
    {
      String str1 = paramDoFavoriteParams.filePath;
      String str2 = paramDoFavoriteParams.lPJ;
      paramDoFavoriteParams = paramDoFavoriteParams.fileName;
      dn localdn = new dn();
      ((af)com.tencent.mm.kernel.h.ax(af.class)).a(localdn, 6, str1, dm.I(str1, str2, paramDoFavoriteParams), "");
      localdn.publish();
      i = localdn.hDs.ret;
      Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", s.X("doFavoriteMainProcess, ret: ", Integer.valueOf(i)));
      Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", s.X("doFavoriteMainProcess, result: ", Integer.valueOf(i)));
      paramDoFavoriteParams = new IPCInteger(i);
      AppMethodBeat.o(325665);
      return paramDoFavoriteParams;
    }
    catch (Exception paramDoFavoriteParams)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", s.X("doFavoriteMainProcess, fail since ", paramDoFavoriteParams));
        int i = -2147483648;
      }
    }
  }
  
  private static final void a(JsApiAddFileToFavorites paramJsApiAddFileToFavorites, Activity paramActivity, String paramString1, String paramString2, String paramString3, f paramf, int paramInt)
  {
    AppMethodBeat.i(325661);
    s.u(paramJsApiAddFileToFavorites, "this$0");
    paramString1 = (IPCInteger)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new DoFavoriteParams(paramString1, paramString2, paramString3), JsApiAddFileToFavorites..ExternalSyntheticLambda0.INSTANCE);
    int i;
    label57:
    boolean bool;
    if (paramString1 == null)
    {
      paramString1 = null;
      Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", s.X("doFavoriteAnyProcess, result: ", paramString1));
      if (paramString1 != null) {
        break label135;
      }
      i = -2147483648;
      d.uiThread((kotlin.g.a.a)new JsApiAddFileToFavorites.b(i, paramActivity));
      if (i != 0) {
        break label144;
      }
      bool = true;
      label81:
      Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", s.X("invoke, success: ", Boolean.valueOf(bool)));
      if (!bool) {
        break label150;
      }
    }
    label135:
    label144:
    label150:
    for (paramActivity = "ok";; paramActivity = "fail")
    {
      paramf.callback(paramInt, paramJsApiAddFileToFavorites.ZP(paramActivity));
      AppMethodBeat.o(325661);
      return;
      paramString1 = Integer.valueOf(paramString1.value);
      break;
      i = paramString1.intValue();
      break label57;
      bool = false;
      break label81;
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    String str = null;
    AppMethodBeat.i(325678);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, env is null");
      AppMethodBeat.o(325678);
      return;
    }
    Object localObject1 = paramf.getContext();
    if ((localObject1 instanceof Activity)) {}
    for (localObject1 = (Activity)localObject1; localObject1 == null; localObject1 = null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, activity is null");
      paramf.callback(paramInt, ZP("fail:activity is null"));
      AppMethodBeat.o(325678);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(325678);
      return;
    }
    Object localObject3 = paramJSONObject.optString("filePath");
    Object localObject2 = (CharSequence)localObject3;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, filePath is empty");
      paramf.callback(paramInt, ZP("fail:filePath is empty"));
      AppMethodBeat.o(325678);
      return;
    }
    s.s(localObject3, "filePath");
    w localw;
    if (n.U((String)localObject3, "wxfile://", false))
    {
      localObject2 = org.apache.commons.b.c.bKZ((String)localObject3);
      Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, filePath: " + localObject3 + ", fileExt: " + localObject2);
      localw = paramf.getFileSystem();
      if (localw != null) {
        break label323;
      }
      label258:
      localObject3 = (CharSequence)str;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label352;
      }
    }
    label323:
    label352:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label358;
      }
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, filePath is illegal");
      paramf.callback(paramInt, ZP("fail:filePath is illegal"));
      AppMethodBeat.o(325678);
      return;
      localObject2 = "";
      break;
      localObject3 = localw.Wm((String)localObject3);
      if (localObject3 == null) {
        break label258;
      }
      str = ah.v(((u)localObject3).jKT());
      break label258;
    }
    label358:
    Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", s.X("invoke, realFilePath: ", str));
    paramJSONObject = paramJSONObject.optString("fileName");
    Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", s.X("invoke, fileName: ", paramJSONObject));
    com.tencent.threadpool.h.ahAA.bm(new JsApiAddFileToFavorites..ExternalSyntheticLambda1(this, (Activity)localObject1, str, (String)localObject2, paramJSONObject, paramf, paramInt));
    AppMethodBeat.o(325678);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddFileToFavorites$DoFavoriteParams;", "Landroid/os/Parcelable;", "filePath", "", "fileExt", "fileName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileExt", "()Ljava/lang/String;", "getFileName", "getFilePath", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class DoFavoriteParams
    implements Parcelable
  {
    public static final Parcelable.Creator<DoFavoriteParams> CREATOR;
    final String fileName;
    final String filePath;
    final String lPJ;
    
    static
    {
      AppMethodBeat.i(325715);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(325715);
    }
    
    public DoFavoriteParams(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(325710);
      this.filePath = paramString1;
      this.lPJ = paramString2;
      this.fileName = paramString3;
      AppMethodBeat.o(325710);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(325723);
      if (this == paramObject)
      {
        AppMethodBeat.o(325723);
        return true;
      }
      if (!(paramObject instanceof DoFavoriteParams))
      {
        AppMethodBeat.o(325723);
        return false;
      }
      paramObject = (DoFavoriteParams)paramObject;
      if (!s.p(this.filePath, paramObject.filePath))
      {
        AppMethodBeat.o(325723);
        return false;
      }
      if (!s.p(this.lPJ, paramObject.lPJ))
      {
        AppMethodBeat.o(325723);
        return false;
      }
      if (!s.p(this.fileName, paramObject.fileName))
      {
        AppMethodBeat.o(325723);
        return false;
      }
      AppMethodBeat.o(325723);
      return true;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(325719);
      int k = this.filePath.hashCode();
      int i;
      if (this.lPJ == null)
      {
        i = 0;
        if (this.fileName != null) {
          break label59;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(325719);
        return (i + k * 31) * 31 + j;
        i = this.lPJ.hashCode();
        break;
        label59:
        j = this.fileName.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(325716);
      String str = "DoFavoriteParams(filePath=" + this.filePath + ", fileExt=" + this.lPJ + ", fileName=" + this.fileName + ')';
      AppMethodBeat.o(325716);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(325729);
      s.u(paramParcel, "out");
      paramParcel.writeString(this.filePath);
      paramParcel.writeString(this.lPJ);
      paramParcel.writeString(this.fileName);
      AppMethodBeat.o(325729);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<JsApiAddFileToFavorites.DoFavoriteParams>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddFileToFavorites
 * JD-Core Version:    0.7.0.1
 */