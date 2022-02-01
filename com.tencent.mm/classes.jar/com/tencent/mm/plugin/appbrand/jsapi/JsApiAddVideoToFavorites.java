package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddVideoToFavorites;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "doAddVideoToFavorites", "", "activity", "Landroid/app/Activity;", "videoPath", "", "thumbPath", "doFavoriteAnyProcess", "", "handleErrorTypeAnyProcess", "", "ret", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "DoFavoriteParams", "plugin-appbrand-integration_release"})
public final class JsApiAddVideoToFavorites
  extends c<e>
{
  private static final int CTRL_INDEX = 959;
  private static final String NAME = "addVideoToFavorites";
  public static final a otI;
  
  static
  {
    AppMethodBeat.i(270537);
    otI = new a((byte)0);
    AppMethodBeat.o(270537);
  }
  
  public final void a(final e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(270536);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, env is null");
      AppMethodBeat.o(270536);
      return;
    }
    Object localObject3 = parame.getContext();
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof Activity)) {
      localObject1 = null;
    }
    localObject3 = (Activity)localObject1;
    if (localObject3 == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, activity is null");
      parame.j(paramInt, agS("fail:activity is null"));
      AppMethodBeat.o(270536);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, data is null");
      parame.j(paramInt, agS("fail:data is null"));
      AppMethodBeat.o(270536);
      return;
    }
    localObject1 = paramJSONObject.optString("videoPath");
    Object localObject4 = (CharSequence)localObject1;
    if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, videoPath is empty");
      parame.j(paramInt, agS("fail:videoPath is empty"));
      AppMethodBeat.o(270536);
      return;
    }
    Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, videoPath: ".concat(String.valueOf(localObject1)));
    localObject4 = parame.getFileSystem();
    if (localObject4 != null)
    {
      localObject1 = ((r)localObject4).adL((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.vfs.q)localObject1).bOF();
        localObject4 = (CharSequence)localObject1;
        if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
          break label299;
        }
      }
    }
    label299:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label305;
      }
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, videoPath is illegal");
      parame.j(paramInt, agS("fail:videoPath is illegal"));
      AppMethodBeat.o(270536);
      return;
      localObject1 = null;
      break;
    }
    label305:
    Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, realVideoPath: ".concat(String.valueOf(localObject1)));
    localObject4 = paramJSONObject.optString("thumbPath");
    Object localObject5 = parame.getFileSystem();
    paramJSONObject = localObject2;
    if (localObject5 != null)
    {
      localObject5 = ((r)localObject5).adL((String)localObject4);
      paramJSONObject = localObject2;
      if (localObject5 != null) {
        paramJSONObject = ((com.tencent.mm.vfs.q)localObject5).bOF();
      }
    }
    Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, thumbPath: " + (String)localObject4 + ", realThumbPath: " + paramJSONObject);
    com.tencent.e.h.ZvG.be((Runnable)new d(this, (Activity)localObject3, (String)localObject1, paramJSONObject, parame, paramInt));
    AppMethodBeat.o(270536);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddVideoToFavorites$DoFavoriteParams;", "Landroid/os/Parcelable;", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "getVideoPath", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  static final class DoFavoriteParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String thumbPath;
    final String videoPath;
    
    static
    {
      AppMethodBeat.i(284269);
      CREATOR = new a();
      AppMethodBeat.o(284269);
    }
    
    public DoFavoriteParams(String paramString1, String paramString2)
    {
      AppMethodBeat.i(284261);
      this.videoPath = paramString1;
      this.thumbPath = paramString2;
      AppMethodBeat.o(284261);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(284266);
      if (this != paramObject)
      {
        if ((paramObject instanceof DoFavoriteParams))
        {
          paramObject = (DoFavoriteParams)paramObject;
          if ((!p.h(this.videoPath, paramObject.videoPath)) || (!p.h(this.thumbPath, paramObject.thumbPath))) {}
        }
      }
      else
      {
        AppMethodBeat.o(284266);
        return true;
      }
      AppMethodBeat.o(284266);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(284264);
      String str = this.videoPath;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.thumbPath;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(284264);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(284262);
      String str = "DoFavoriteParams(videoPath=" + this.videoPath + ", thumbPath=" + this.thumbPath + ")";
      AppMethodBeat.o(284262);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(284268);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.thumbPath);
      AppMethodBeat.o(284268);
    }
    
    @l(iBK={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(279812);
        p.k(paramParcel, "in");
        paramParcel = new JsApiAddVideoToFavorites.DoFavoriteParams(paramParcel.readString(), paramParcel.readString());
        AppMethodBeat.o(279812);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new JsApiAddVideoToFavorites.DoFavoriteParams[paramInt];
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddVideoToFavorites$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_THUMB_PATH", "PARAM_KEY_VIDEO_PATH", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddVideoToFavorites$DoFavoriteParams;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b<InputType, ResultType>
    implements m<JsApiAddVideoToFavorites.DoFavoriteParams, IPCInteger>
  {
    public static final b otJ;
    
    static
    {
      AppMethodBeat.i(275064);
      otJ = new b();
      AppMethodBeat.o(275064);
    }
    
    private static IPCInteger a(JsApiAddVideoToFavorites.DoFavoriteParams paramDoFavoriteParams)
    {
      AppMethodBeat.i(275062);
      for (;;)
      {
        try
        {
          str1 = paramDoFavoriteParams.videoPath;
          str2 = paramDoFavoriteParams.thumbPath;
          paramDoFavoriteParams = new dd();
          j = de.agW(str1);
          if (j > 0) {
            continue;
          }
          Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "doFavoriteMainProcess, durationS: ".concat(String.valueOf(j)));
          i = -2147483648;
        }
        catch (Exception paramDoFavoriteParams)
        {
          String str1;
          String str2;
          int j;
          CharSequence localCharSequence;
          Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "doFavoriteMainProcess, fail since ".concat(String.valueOf(paramDoFavoriteParams)));
          int i = -2147483648;
          continue;
          i = 1;
          continue;
          i = 0;
          continue;
        }
        Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "doFavoriteMainProcess, result: ".concat(String.valueOf(i)));
        paramDoFavoriteParams = new IPCInteger(i);
        AppMethodBeat.o(275062);
        return paramDoFavoriteParams;
        str2 = de.dv(str1, str2);
        localCharSequence = (CharSequence)str2;
        if (localCharSequence == null) {
          continue;
        }
        if (localCharSequence.length() != 0) {
          continue;
        }
        continue;
        if (i != 0)
        {
          Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "doFavoriteMainProcess, thumbPath is empty");
          i = -2147483648;
        }
        else
        {
          ((ae)com.tencent.mm.kernel.h.ae(ae.class)).a(paramDoFavoriteParams, str1, str2, j, "", "");
          EventCenter.instance.publish((IEvent)paramDoFavoriteParams);
          i = paramDoFavoriteParams.fyJ.ret;
          Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "doFavoriteMainProcess, ret: ".concat(String.valueOf(i)));
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements a<x>
  {
    c(int paramInt, Activity paramActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(JsApiAddVideoToFavorites paramJsApiAddVideoToFavorites, Activity paramActivity, String paramString1, String paramString2, e parame, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(276332);
      boolean bool = JsApiAddVideoToFavorites.a(this.otc, this.otN, paramJSONObject);
      Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, success: ".concat(String.valueOf(bool)));
      e locale = parame;
      int i = paramInt;
      JsApiAddVideoToFavorites localJsApiAddVideoToFavorites = this.otM;
      if (bool) {}
      for (String str = "ok";; str = "fail")
      {
        locale.j(i, localJsApiAddVideoToFavorites.agS(str));
        AppMethodBeat.o(276332);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddVideoToFavorites
 * JD-Core Version:    0.7.0.1
 */