package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.d;
import com.tencent.mm.ui.widget.b.d.a;

public final class JsApiShowImageOperateSheet
  extends a<z>
{
  public static final int CTRL_INDEX = 626;
  public static final String NAME = "showImageOperateSheet";
  
  static final class BottomSheetLogicHelper$IPCProcessQRCodeResultRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<IPCProcessQRCodeResultRequest> CREATOR;
    private JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult hAe;
    private String hAf;
    private String hAg;
    
    static
    {
      AppMethodBeat.i(130589);
      CREATOR = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.1();
      AppMethodBeat.o(130589);
    }
    
    protected BottomSheetLogicHelper$IPCProcessQRCodeResultRequest() {}
    
    protected BottomSheetLogicHelper$IPCProcessQRCodeResultRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(130587);
      this.hAe = ((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult)paramParcel.readParcelable(IPCProcessQRCodeResultRequest.class.getClassLoader()));
      this.hAf = paramParcel.readString();
      this.hAg = paramParcel.readString();
      AppMethodBeat.o(130587);
    }
    
    public final boolean aBm()
    {
      return true;
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> aBo()
    {
      return JsApiShowImageOperateSheet.BottomSheetLogicHelper.b.class;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(130588);
      paramParcel.writeParcelable(this.hAe, paramInt);
      paramParcel.writeString(this.hAf);
      paramParcel.writeString(this.hAg);
      AppMethodBeat.o(130588);
    }
  }
  
  static final class BottomSheetLogicHelper$b
    extends AppBrandProxyUIProcessTask
  {
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(130590);
      if (!(paramProcessRequest instanceof JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest))
      {
        ab.e("MicroMsg.JsApiShowImageOperateSheet", "IPCProcessQRCodeResultTask request instance not valid");
        AppMethodBeat.o(130590);
        return;
      }
      paramProcessRequest = (JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest)paramProcessRequest;
      cg localcg = new cg();
      localcg.cpD.activity = aBf();
      localcg.cpD.cnR = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
      localcg.cpD.cpE = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.b(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
      localcg.cpD.cpF = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.e(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
      localcg.cpD.scene = 44;
      Bundle localBundle = new Bundle();
      localBundle.putInt("stat_scene", 6);
      localBundle.putString("stat_app_id", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.b(paramProcessRequest));
      localBundle.putString("stat_url", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.c(paramProcessRequest));
      localcg.cpD.cpJ = localBundle;
      com.tencent.mm.sdk.b.a.ymk.l(localcg);
      AppMethodBeat.o(130590);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet
 * JD-Core Version:    0.7.0.1
 */