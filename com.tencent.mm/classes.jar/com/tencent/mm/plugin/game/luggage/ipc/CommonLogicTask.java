package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.jj;
import com.tencent.mm.f.a.jj.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.protobuf.dw;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.game.d;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public class CommonLogicTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CommonLogicTask> CREATOR;
  public Runnable CAH;
  public Bundle fKb;
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
    this.fKb = new Bundle();
    AppMethodBeat.o(83046);
  }
  
  CommonLogicTask(Parcel paramParcel)
  {
    AppMethodBeat.i(83047);
    this.fKb = new Bundle();
    f(paramParcel);
    AppMethodBeat.o(83047);
  }
  
  private static int ZG(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(83043);
    try
    {
      int j = Util.getInt(com.tencent.mm.n.h.axc().getValue(paramString), 1);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(83043);
    return i;
  }
  
  public final void RW()
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
      bPt();
      AppMethodBeat.o(83042);
      return;
      if (this.fKb != null)
      {
        bool1 = this.fKb.getBoolean("permission_allow", false);
        Object localObject1 = this.fKb.getString("url");
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
          AppMethodBeat.o(83042);
          return;
        }
        q.a.QSe.b(MMApplicationContext.getContext(), (String)localObject1, bool1);
        continue;
        if (this.fKb != null)
        {
          localObject1 = this.fKb.getIntArray("getConfigStgKey");
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
            com.tencent.mm.kernel.h.aHH();
            ((ArrayList)localObject2).add(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(k, null)));
            i += 1;
          }
          this.fKb.putStringArrayList("getConfigStgValue", (ArrayList)localObject2);
          continue;
          if (this.fKb != null)
          {
            localObject1 = this.fKb.getString("localId");
            localObject1 = com.tencent.mm.plugin.webview.modeltools.f.gWt().bkI((String)localObject1);
            if (localObject1 != null)
            {
              this.fKb.putParcelable("item", (Parcelable)localObject1);
              continue;
              i = ZG("WebViewDownLoadFileSwitch");
              if (this.fKb == null) {
                this.fKb = new Bundle();
              }
              localObject1 = this.fKb;
              if (i == 1) {}
              for (;;)
              {
                ((Bundle)localObject1).putBoolean("allowDownloadFile", bool1);
                break;
                bool1 = false;
              }
              i = ZG("EnableWebviewScanQRCode");
              localObject1 = this.fKb;
              if (i == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((Bundle)localObject1).putBoolean("allow_webview_scan", bool1);
                break;
              }
              this.fKb.putBoolean("has_set_uin", com.tencent.mm.kernel.h.aHB());
              continue;
              localObject1 = az.bkT(this.fKb.getString("localId"));
              this.fKb.putString("file_path", (String)localObject1);
              continue;
              localObject1 = this.fKb.getString("game_hv_menu_appid");
              localObject2 = new jj();
              ((jj)localObject2).fGE.Vh = 3;
              ((jj)localObject2).fGE.param = ((String)localObject1);
              EventCenter.instance.publish((IEvent)localObject2);
              this.fKb.putString("game_hv_menu_pbcache", ((jj)localObject2).fGF.result);
              continue;
              localObject1 = a.ewc();
              if (localObject1 != null)
              {
                localObject2 = new GameSettingParams();
                ((GameSettingParams)localObject2).QnG = ((dw)localObject1).lmL;
                ((GameSettingParams)localObject2).QnH = ((dw)localObject1).CLD;
                ((GameSettingParams)localObject2).QnI = ((dw)localObject1).CRy;
                this.fKb.putParcelable("game_setting_params", (Parcelable)localObject2);
                continue;
                d.bj(this.fKb);
              }
            }
          }
        }
      }
    }
  }
  
  public final void bsK()
  {
    AppMethodBeat.i(83041);
    if (this.CAH != null) {
      this.CAH.run();
    }
    AppMethodBeat.o(83041);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(83045);
    this.type = paramParcel.readInt();
    this.fKb = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(83045);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(83044);
    paramParcel.writeInt(this.type);
    paramParcel.writeBundle(this.fKb);
    AppMethodBeat.o(83044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask
 * JD-Core Version:    0.7.0.1
 */