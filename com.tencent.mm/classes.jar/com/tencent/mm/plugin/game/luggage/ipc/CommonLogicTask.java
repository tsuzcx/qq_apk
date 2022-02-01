package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.id.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.d.dm;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;

public class CommonLogicTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CommonLogicTask> CREATOR;
  public Bundle dxT;
  public Runnable tTI;
  public int type;
  
  static
  {
    AppMethodBeat.i(83048);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(83048);
  }
  
  public CommonLogicTask()
  {
    AppMethodBeat.i(83046);
    this.dxT = new Bundle();
    AppMethodBeat.o(83046);
  }
  
  CommonLogicTask(Parcel paramParcel)
  {
    AppMethodBeat.i(83047);
    this.dxT = new Bundle();
    e(paramParcel);
    AppMethodBeat.o(83047);
  }
  
  private static int II(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(83043);
    try
    {
      int j = bt.getInt(com.tencent.mm.n.g.acA().getValue(paramString), 1);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(83043);
    return i;
  }
  
  public final void aOA()
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
      bhX();
      AppMethodBeat.o(83042);
      return;
      if (this.dxT != null)
      {
        bool1 = this.dxT.getBoolean("permission_allow", false);
        Object localObject1 = this.dxT.getString("url");
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
          AppMethodBeat.o(83042);
          return;
        }
        q.a.EJC.a(aj.getContext(), (String)localObject1, bool1);
        continue;
        if (this.dxT != null)
        {
          localObject1 = this.dxT.getIntArray("getConfigStgKey");
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
            com.tencent.mm.kernel.g.ajD();
            ((ArrayList)localObject2).add(bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(k, null)));
            i += 1;
          }
          this.dxT.putStringArrayList("getConfigStgValue", (ArrayList)localObject2);
          continue;
          if (this.dxT != null)
          {
            localObject1 = this.dxT.getString("localId");
            localObject1 = com.tencent.mm.plugin.webview.modeltools.g.eQU().aHu((String)localObject1);
            if (localObject1 != null)
            {
              this.dxT.putParcelable("item", (Parcelable)localObject1);
              continue;
              i = II("WebViewDownLoadFileSwitch");
              if (this.dxT == null) {
                this.dxT = new Bundle();
              }
              localObject1 = this.dxT;
              if (i == 1) {}
              for (;;)
              {
                ((Bundle)localObject1).putBoolean("allowDownloadFile", bool1);
                break;
                bool1 = false;
              }
              i = II("EnableWebviewScanQRCode");
              localObject1 = this.dxT;
              if (i == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((Bundle)localObject1).putBoolean("allow_webview_scan", bool1);
                break;
              }
              this.dxT.putBoolean("has_set_uin", com.tencent.mm.kernel.g.ajx());
              continue;
              localObject1 = ax.aHB(this.dxT.getString("localId"));
              this.dxT.putString("file_path", (String)localObject1);
              continue;
              localObject1 = this.dxT.getString("game_hv_menu_appid");
              localObject2 = new id();
              ((id)localObject2).duG.EN = 3;
              ((id)localObject2).duG.param = ((String)localObject1);
              com.tencent.mm.sdk.b.a.IbL.l((b)localObject2);
              this.dxT.putString("game_hv_menu_pbcache", ((id)localObject2).duH.result);
              continue;
              localObject1 = com.tencent.mm.plugin.game.commlib.a.cWQ();
              if (localObject1 != null)
              {
                localObject2 = new GameSettingParams();
                ((GameSettingParams)localObject2).EiI = ((dm)localObject1).hAD;
                ((GameSettingParams)localObject2).EiJ = ((dm)localObject1).udZ;
                ((GameSettingParams)localObject2).EiK = ((dm)localObject1).ujP;
                this.dxT.putParcelable("game_setting_params", (Parcelable)localObject2);
                continue;
                c.aY(this.dxT);
              }
            }
          }
        }
      }
    }
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(83041);
    if (this.tTI != null) {
      this.tTI.run();
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
    this.dxT = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(83045);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(83044);
    paramParcel.writeInt(this.type);
    paramParcel.writeBundle(this.dxT);
    AppMethodBeat.o(83044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask
 * JD-Core Version:    0.7.0.1
 */