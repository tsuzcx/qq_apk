package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.hp.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.d.de;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;

public class CommonLogicTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CommonLogicTask> CREATOR;
  public Bundle dow;
  public Runnable rPi;
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
    this.dow = new Bundle();
    AppMethodBeat.o(83046);
  }
  
  CommonLogicTask(Parcel paramParcel)
  {
    AppMethodBeat.i(83047);
    this.dow = new Bundle();
    e(paramParcel);
    AppMethodBeat.o(83047);
  }
  
  private static int Bo(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(83043);
    try
    {
      int j = bt.getInt(com.tencent.mm.m.g.Zd().getValue(paramString), 1);
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
  
  public final void aEA()
  {
    AppMethodBeat.i(83041);
    if (this.rPi != null) {
      this.rPi.run();
    }
    AppMethodBeat.o(83041);
  }
  
  public final void aEz()
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
      aXw();
      AppMethodBeat.o(83042);
      return;
      if (this.dow != null)
      {
        bool1 = this.dow.getBoolean("permission_allow", false);
        Object localObject1 = this.dow.getString("url");
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
          AppMethodBeat.o(83042);
          return;
        }
        p.a.BNw.a(aj.getContext(), (String)localObject1, bool1);
        continue;
        if (this.dow != null)
        {
          localObject1 = this.dow.getIntArray("getConfigStgKey");
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
            com.tencent.mm.kernel.g.afC();
            ((ArrayList)localObject2).add(bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(k, null)));
            i += 1;
          }
          this.dow.putStringArrayList("getConfigStgValue", (ArrayList)localObject2);
          continue;
          if (this.dow != null)
          {
            localObject1 = this.dow.getString("localId");
            localObject1 = com.tencent.mm.plugin.webview.modeltools.g.emF().awC((String)localObject1);
            if (localObject1 != null)
            {
              this.dow.putParcelable("item", (Parcelable)localObject1);
              continue;
              i = Bo("WebViewDownLoadFileSwitch");
              if (this.dow == null) {
                this.dow = new Bundle();
              }
              localObject1 = this.dow;
              if (i == 1) {}
              for (;;)
              {
                ((Bundle)localObject1).putBoolean("allowDownloadFile", bool1);
                break;
                bool1 = false;
              }
              i = Bo("EnableWebviewScanQRCode");
              localObject1 = this.dow;
              if (i == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((Bundle)localObject1).putBoolean("allow_webview_scan", bool1);
                break;
              }
              this.dow.putBoolean("has_set_uin", com.tencent.mm.kernel.g.afw());
              continue;
              localObject1 = aw.awI(this.dow.getString("localId"));
              this.dow.putString("file_path", (String)localObject1);
              continue;
              localObject1 = this.dow.getString("game_hv_menu_appid");
              localObject2 = new hp();
              ((hp)localObject2).dll.BX = 3;
              ((hp)localObject2).dll.dln = ((String)localObject1);
              com.tencent.mm.sdk.b.a.ESL.l((b)localObject2);
              this.dow.putString("game_hv_menu_pbcache", ((hp)localObject2).dlm.result);
              continue;
              localObject1 = com.tencent.mm.plugin.game.commlib.a.cBm();
              if (localObject1 != null)
              {
                localObject2 = new GameSettingParams();
                ((GameSettingParams)localObject2).BmR = ((de)localObject1).gHT;
                ((GameSettingParams)localObject2).BmS = ((de)localObject1).rYr;
                ((GameSettingParams)localObject2).BmT = ((de)localObject1).sdM;
                this.dow.putParcelable("game_setting_params", (Parcelable)localObject2);
                continue;
                c.aP(this.dow);
              }
            }
          }
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(83045);
    this.type = paramParcel.readInt();
    this.dow = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(83045);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(83044);
    paramParcel.writeInt(this.type);
    paramParcel.writeBundle(this.dow);
    AppMethodBeat.o(83044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask
 * JD-Core Version:    0.7.0.1
 */