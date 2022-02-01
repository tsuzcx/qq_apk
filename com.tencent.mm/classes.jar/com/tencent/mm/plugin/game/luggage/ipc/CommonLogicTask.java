package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.it.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.protobuf.dv;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
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
  public Bundle dQL;
  public int type;
  public Runnable xwz;
  
  static
  {
    AppMethodBeat.i(83048);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(83048);
  }
  
  public CommonLogicTask()
  {
    AppMethodBeat.i(83046);
    this.dQL = new Bundle();
    AppMethodBeat.o(83046);
  }
  
  CommonLogicTask(Parcel paramParcel)
  {
    AppMethodBeat.i(83047);
    this.dQL = new Bundle();
    f(paramParcel);
    AppMethodBeat.o(83047);
  }
  
  private static int Se(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(83043);
    try
    {
      int j = Util.getInt(h.aqJ().getValue(paramString), 1);
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
  
  public final void bjj()
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
      bDU();
      AppMethodBeat.o(83042);
      return;
      if (this.dQL != null)
      {
        bool1 = this.dQL.getBoolean("permission_allow", false);
        Object localObject1 = this.dQL.getString("url");
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
          AppMethodBeat.o(83042);
          return;
        }
        q.a.JSZ.a(MMApplicationContext.getContext(), (String)localObject1, bool1);
        continue;
        if (this.dQL != null)
        {
          localObject1 = this.dQL.getIntArray("getConfigStgKey");
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
            com.tencent.mm.kernel.g.aAi();
            ((ArrayList)localObject2).add(Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(k, null)));
            i += 1;
          }
          this.dQL.putStringArrayList("getConfigStgValue", (ArrayList)localObject2);
          continue;
          if (this.dQL != null)
          {
            localObject1 = this.dQL.getString("localId");
            localObject1 = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO((String)localObject1);
            if (localObject1 != null)
            {
              this.dQL.putParcelable("item", (Parcelable)localObject1);
              continue;
              i = Se("WebViewDownLoadFileSwitch");
              if (this.dQL == null) {
                this.dQL = new Bundle();
              }
              localObject1 = this.dQL;
              if (i == 1) {}
              for (;;)
              {
                ((Bundle)localObject1).putBoolean("allowDownloadFile", bool1);
                break;
                bool1 = false;
              }
              i = Se("EnableWebviewScanQRCode");
              localObject1 = this.dQL;
              if (i == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((Bundle)localObject1).putBoolean("allow_webview_scan", bool1);
                break;
              }
              this.dQL.putBoolean("has_set_uin", com.tencent.mm.kernel.g.aAc());
              continue;
              localObject1 = ay.aYZ(this.dQL.getString("localId"));
              this.dQL.putString("file_path", (String)localObject1);
              continue;
              localObject1 = this.dQL.getString("game_hv_menu_appid");
              localObject2 = new it();
              ((it)localObject2).dNs.EX = 3;
              ((it)localObject2).dNs.param = ((String)localObject1);
              EventCenter.instance.publish((IEvent)localObject2);
              this.dQL.putString("game_hv_menu_pbcache", ((it)localObject2).dNt.result);
              continue;
              localObject1 = a.dSU();
              if (localObject1 != null)
              {
                localObject2 = new GameSettingParams();
                ((GameSettingParams)localObject2).Jqj = ((dv)localObject1).ixw;
                ((GameSettingParams)localObject2).Jqk = ((dv)localObject1).xHA;
                ((GameSettingParams)localObject2).Jql = ((dv)localObject1).xNo;
                this.dQL.putParcelable("game_setting_params", (Parcelable)localObject2);
                continue;
                c.bl(this.dQL);
              }
            }
          }
        }
      }
    }
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(83041);
    if (this.xwz != null) {
      this.xwz.run();
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
    this.dQL = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(83045);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(83044);
    paramParcel.writeInt(this.type);
    paramParcel.writeBundle(this.dQL);
    AppMethodBeat.o(83044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask
 * JD-Core Version:    0.7.0.1
 */