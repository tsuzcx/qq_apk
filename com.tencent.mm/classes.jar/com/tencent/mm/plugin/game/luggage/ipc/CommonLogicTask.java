package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.gv.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;

public class CommonLogicTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CommonLogicTask> CREATOR;
  public Bundle mEJ;
  public Runnable njB;
  public int type;
  
  static
  {
    AppMethodBeat.i(135863);
    CREATOR = new CommonLogicTask.1();
    AppMethodBeat.o(135863);
  }
  
  public CommonLogicTask()
  {
    AppMethodBeat.i(135861);
    this.mEJ = new Bundle();
    AppMethodBeat.o(135861);
  }
  
  CommonLogicTask(Parcel paramParcel)
  {
    AppMethodBeat.i(135862);
    this.mEJ = new Bundle();
    f(paramParcel);
    AppMethodBeat.o(135862);
  }
  
  private static int wp(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(135858);
    try
    {
      int j = bo.getInt(com.tencent.mm.m.g.Nq().getValue(paramString), 1);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(135858);
    return i;
  }
  
  public final void ata()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i = 0;
    AppMethodBeat.i(135857);
    switch (this.type)
    {
    }
    for (;;)
    {
      aBp();
      AppMethodBeat.o(135857);
      return;
      if (this.mEJ != null)
      {
        bool1 = this.mEJ.getBoolean("permission_allow", false);
        Object localObject1 = this.mEJ.getString("url");
        if (bo.isNullOrNil((String)localObject1))
        {
          ab.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
          AppMethodBeat.o(135857);
          return;
        }
        r.a.vJD.a(ah.getContext(), (String)localObject1, bool1);
        continue;
        if (this.mEJ != null)
        {
          localObject1 = this.mEJ.getIntArray("getConfigStgKey");
          if ((localObject1 == null) || (localObject1.length == 0))
          {
            AppMethodBeat.o(135857);
            return;
          }
          Object localObject2 = new ArrayList();
          int j = localObject1.length;
          while (i < j)
          {
            int k = localObject1[i];
            com.tencent.mm.kernel.g.RM();
            ((ArrayList)localObject2).add(bo.nullAsNil((String)com.tencent.mm.kernel.g.RL().Ru().get(k, null)));
            i += 1;
          }
          this.mEJ.putStringArrayList("getConfigStgValue", (ArrayList)localObject2);
          continue;
          if (this.mEJ != null)
          {
            localObject1 = this.mEJ.getString("localId");
            localObject1 = com.tencent.mm.plugin.webview.modeltools.g.dcE().ahh((String)localObject1);
            if (localObject1 != null)
            {
              this.mEJ.putParcelable("item", (Parcelable)localObject1);
              continue;
              i = wp("WebViewDownLoadFileSwitch");
              if (this.mEJ == null) {
                this.mEJ = new Bundle();
              }
              localObject1 = this.mEJ;
              if (i == 1) {}
              for (;;)
              {
                ((Bundle)localObject1).putBoolean("allowDownloadFile", bool1);
                break;
                bool1 = false;
              }
              i = wp("EnableWebviewScanQRCode");
              localObject1 = this.mEJ;
              if (i == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((Bundle)localObject1).putBoolean("allow_webview_scan", bool1);
                break;
              }
              this.mEJ.putBoolean("has_set_uin", com.tencent.mm.kernel.g.RG());
              continue;
              localObject1 = ar.aho(this.mEJ.getString("localId"));
              this.mEJ.putString("file_path", (String)localObject1);
              continue;
              localObject1 = this.mEJ.getString("game_hv_menu_appid");
              localObject2 = new gv();
              ((gv)localObject2).cvM.vA = 3;
              ((gv)localObject2).cvM.cvO = ((String)localObject1);
              com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
              this.mEJ.putString("game_hv_menu_pbcache", ((gv)localObject2).cvN.result);
              continue;
              localObject1 = com.tencent.mm.plugin.game.commlib.a.bFc();
              if (localObject1 != null)
              {
                localObject2 = new GameSettingParams();
                ((GameSettingParams)localObject2).vmD = ((dd)localObject1).color;
                ((GameSettingParams)localObject2).vmE = ((dd)localObject1).noW;
                this.mEJ.putParcelable("game_setting_params", (Parcelable)localObject2);
                continue;
                c.aw(this.mEJ);
              }
            }
          }
        }
      }
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(135856);
    if (this.njB != null) {
      this.njB.run();
    }
    AppMethodBeat.o(135856);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(135860);
    this.type = paramParcel.readInt();
    this.mEJ = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(135860);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(135859);
    paramParcel.writeInt(this.type);
    paramParcel.writeBundle(this.mEJ);
    AppMethodBeat.o(135859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask
 * JD-Core Version:    0.7.0.1
 */