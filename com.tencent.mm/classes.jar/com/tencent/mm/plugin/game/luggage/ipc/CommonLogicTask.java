package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.ie.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.d.dv;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;

public class CommonLogicTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CommonLogicTask> CREATOR;
  public Bundle dyY;
  public int type;
  public Runnable ueA;
  
  static
  {
    AppMethodBeat.i(83048);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(83048);
  }
  
  public CommonLogicTask()
  {
    AppMethodBeat.i(83046);
    this.dyY = new Bundle();
    AppMethodBeat.o(83046);
  }
  
  CommonLogicTask(Parcel paramParcel)
  {
    AppMethodBeat.i(83047);
    this.dyY = new Bundle();
    e(paramParcel);
    AppMethodBeat.o(83047);
  }
  
  private static int Jh(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(83043);
    try
    {
      int j = bu.getInt(com.tencent.mm.n.g.acL().getValue(paramString), 1);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(83043);
    return i;
  }
  
  public final void aOX()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i = 0;
    AppMethodBeat.i(83042);
    switch (this.type)
    {
    }
    for (;;)
    {
      biG();
      AppMethodBeat.o(83042);
      return;
      if (this.dyY != null)
      {
        bool1 = this.dyY.getBoolean("permission_allow", false);
        Object localObject1 = this.dyY.getString("url");
        if (bu.isNullOrNil((String)localObject1))
        {
          ae.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
          AppMethodBeat.o(83042);
          return;
        }
        q.a.Fca.a(ak.getContext(), (String)localObject1, bool1);
        continue;
        if (this.dyY != null)
        {
          localObject1 = this.dyY.getIntArray("getConfigStgKey");
          if ((localObject1 == null) || (localObject1.length == 0))
          {
            AppMethodBeat.o(83042);
            return;
          }
          Object localObject2 = new ArrayList();
          int j = localObject1.length;
          while (i < j)
          {
            int k = localObject1[i];
            com.tencent.mm.kernel.g.ajS();
            ((ArrayList)localObject2).add(bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(k, null)));
            i += 1;
          }
          this.dyY.putStringArrayList("getConfigStgValue", (ArrayList)localObject2);
          continue;
          if (this.dyY != null)
          {
            localObject1 = this.dyY.getString("localId");
            localObject1 = com.tencent.mm.plugin.webview.modeltools.g.eUG().aIN((String)localObject1);
            if (localObject1 != null)
            {
              this.dyY.putParcelable("item", (Parcelable)localObject1);
              continue;
              i = Jh("WebViewDownLoadFileSwitch");
              if (this.dyY == null) {
                this.dyY = new Bundle();
              }
              localObject1 = this.dyY;
              if (i == 1) {}
              for (;;)
              {
                ((Bundle)localObject1).putBoolean("allowDownloadFile", bool1);
                break;
                bool1 = false;
              }
              i = Jh("EnableWebviewScanQRCode");
              localObject1 = this.dyY;
              if (i == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((Bundle)localObject1).putBoolean("allow_webview_scan", bool1);
                break;
              }
              this.dyY.putBoolean("has_set_uin", com.tencent.mm.kernel.g.ajM());
              continue;
              localObject1 = ax.aIU(this.dyY.getString("localId"));
              this.dyY.putString("file_path", (String)localObject1);
              continue;
              localObject1 = this.dyY.getString("game_hv_menu_appid");
              localObject2 = new ie();
              ((ie)localObject2).dvL.EN = 3;
              ((ie)localObject2).dvL.param = ((String)localObject1);
              com.tencent.mm.sdk.b.a.IvT.l((b)localObject2);
              this.dyY.putString("game_hv_menu_pbcache", ((ie)localObject2).dvM.result);
              continue;
              localObject1 = com.tencent.mm.plugin.game.commlib.a.cZu();
              if (localObject1 != null)
              {
                localObject2 = new GameSettingParams();
                ((GameSettingParams)localObject2).EAM = ((dv)localObject1).hDr;
                ((GameSettingParams)localObject2).EAN = ((dv)localObject1).uph;
                ((GameSettingParams)localObject2).EAO = ((dv)localObject1).uvn;
                this.dyY.putParcelable("game_setting_params", (Parcelable)localObject2);
                continue;
                c.aZ(this.dyY);
              }
            }
          }
        }
      }
    }
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(83041);
    if (this.ueA != null) {
      this.ueA.run();
    }
    AppMethodBeat.o(83041);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(83045);
    this.type = paramParcel.readInt();
    this.dyY = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(83045);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(83044);
    paramParcel.writeInt(this.type);
    paramParcel.writeBundle(this.dyY);
    AppMethodBeat.o(83044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask
 * JD-Core Version:    0.7.0.1
 */