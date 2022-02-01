package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.pluginsdk.ui.applet.v;
import com.tencent.mm.pluginsdk.ui.applet.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public class JsApiPrivateAddContact
  extends a<h>
{
  public static final int CTRL_INDEX = 407;
  public static final String NAME = "private_addContact";
  
  protected int aXR()
  {
    return 1;
  }
  
  static final class AddContactRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<AddContactRequest> CREATOR;
    int jzc;
    int scene;
    String userName;
    
    static
    {
      AppMethodBeat.i(45607);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45607);
    }
    
    AddContactRequest() {}
    
    AddContactRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(45604);
      j(paramParcel);
      AppMethodBeat.o(45604);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> aWl()
    {
      return JsApiPrivateAddContact.a.class;
    }
    
    public final void j(Parcel paramParcel)
    {
      AppMethodBeat.i(45605);
      this.userName = paramParcel.readString();
      this.scene = paramParcel.readInt();
      this.jzc = paramParcel.readInt();
      AppMethodBeat.o(45605);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45606);
      paramParcel.writeString(this.userName);
      paramParcel.writeInt(this.scene);
      paramParcel.writeInt(this.jzc);
      AppMethodBeat.o(45606);
    }
  }
  
  static final class AddContactResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<AddContactResult> CREATOR;
    private int bRZ;
    
    static
    {
      AppMethodBeat.i(45612);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45612);
    }
    
    AddContactResult() {}
    
    AddContactResult(Parcel paramParcel)
    {
      AppMethodBeat.i(45609);
      j(paramParcel);
      AppMethodBeat.o(45609);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      AppMethodBeat.i(45610);
      this.bRZ = paramParcel.readInt();
      AppMethodBeat.o(45610);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45611);
      paramParcel.writeInt(this.bRZ);
      AppMethodBeat.o(45611);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      boolean bool = true;
      AppMethodBeat.i(45614);
      Object localObject = new JsApiPrivateAddContact.AddContactResult();
      if (!(paramProcessRequest instanceof JsApiPrivateAddContact.AddContactRequest))
      {
        ad.w("MicroMsg.JsApiPrivateAddContact", "handleRequest !(request instanceof AddContactRequest)");
        JsApiPrivateAddContact.AddContactResult.a((JsApiPrivateAddContact.AddContactResult)localObject, -1);
        b((AppBrandProxyUIProcessTask.ProcessResult)localObject);
        AppMethodBeat.o(45614);
        return;
      }
      paramProcessRequest = (JsApiPrivateAddContact.AddContactRequest)paramProcessRequest;
      com.tencent.mm.pluginsdk.h localh = (com.tencent.mm.pluginsdk.h)g.ab(com.tencent.mm.pluginsdk.h.class);
      MMActivity localMMActivity = aXi();
      String str = paramProcessRequest.userName;
      int i = paramProcessRequest.scene;
      localObject = new v()
      {
        public final void ru(int paramAnonymousInt)
        {
          AppMethodBeat.i(45613);
          ad.i("MicroMsg.JsApiPrivateAddContact", "onAddContact resultCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          JsApiPrivateAddContact.AddContactResult.a(this.jzd, paramAnonymousInt);
          JsApiPrivateAddContact.a.a(JsApiPrivateAddContact.a.this, this.jzd);
          AppMethodBeat.o(45613);
        }
      };
      if (paramProcessRequest.jzc == 1) {}
      for (;;)
      {
        localh.a(localMMActivity, str, i, (v)localObject, bool, "").show();
        AppMethodBeat.o(45614);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact
 * JD-Core Version:    0.7.0.1
 */