package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.v;
import com.tencent.mm.pluginsdk.ui.applet.w;
import com.tencent.mm.sdk.platformtools.Log;

public class JsApiPrivateAddContact
  extends c<k>
{
  public static final int CTRL_INDEX = 407;
  public static final String NAME = "private_addContact";
  
  protected int cpW()
  {
    return 1;
  }
  
  static final class AddContactRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<AddContactRequest> CREATOR;
    int rAk;
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
      readParcel(paramParcel);
      AppMethodBeat.o(45604);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> getTaskClass()
    {
      return JsApiPrivateAddContact.a.class;
    }
    
    public final void readParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(45605);
      this.userName = paramParcel.readString();
      this.scene = paramParcel.readInt();
      this.rAk = paramParcel.readInt();
      AppMethodBeat.o(45605);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45606);
      paramParcel.writeString(this.userName);
      paramParcel.writeInt(this.scene);
      paramParcel.writeInt(this.rAk);
      AppMethodBeat.o(45606);
    }
  }
  
  static final class AddContactResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<AddContactResult> CREATOR;
    private int resultCode;
    
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
      readParcel(paramParcel);
      AppMethodBeat.o(45609);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void readParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(45610);
      this.resultCode = paramParcel.readInt();
      AppMethodBeat.o(45610);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45611);
      paramParcel.writeInt(this.resultCode);
      AppMethodBeat.o(45611);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      boolean bool = true;
      AppMethodBeat.i(45614);
      final JsApiPrivateAddContact.AddContactResult localAddContactResult = new JsApiPrivateAddContact.AddContactResult();
      if (!(paramProcessRequest instanceof JsApiPrivateAddContact.AddContactRequest))
      {
        Log.w("MicroMsg.JsApiPrivateAddContact", "handleRequest !(request instanceof AddContactRequest)");
        JsApiPrivateAddContact.AddContactResult.a(localAddContactResult, -1);
        finishProcess(localAddContactResult);
        AppMethodBeat.o(45614);
        return;
      }
      paramProcessRequest = (JsApiPrivateAddContact.AddContactRequest)paramProcessRequest;
      a locala = new a();
      if (paramProcessRequest.rAk == 1) {}
      for (;;)
      {
        locala.XNl = bool;
        ((i)h.ax(i.class)).a(getActivityContext(), paramProcessRequest.userName, paramProcessRequest.scene, new v()
        {
          public final void onAddContact(int paramAnonymousInt)
          {
            AppMethodBeat.i(45613);
            Log.i("MicroMsg.JsApiPrivateAddContact", "onAddContact resultCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            JsApiPrivateAddContact.AddContactResult.a(localAddContactResult, paramAnonymousInt);
            JsApiPrivateAddContact.a.a(JsApiPrivateAddContact.a.this, localAddContactResult);
            AppMethodBeat.o(45613);
          }
        }, locala).show();
        AppMethodBeat.o(45614);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact
 * JD-Core Version:    0.7.0.1
 */