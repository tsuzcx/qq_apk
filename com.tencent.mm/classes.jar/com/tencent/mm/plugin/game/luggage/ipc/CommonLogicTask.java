package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.g.a.hw.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.d.de;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.ArrayList;

public class CommonLogicTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CommonLogicTask> CREATOR;
  public Bundle dmf;
  public Runnable sWY;
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
    this.dmf = new Bundle();
    AppMethodBeat.o(83046);
  }
  
  CommonLogicTask(Parcel paramParcel)
  {
    AppMethodBeat.i(83047);
    this.dmf = new Bundle();
    e(paramParcel);
    AppMethodBeat.o(83047);
  }
  
  private static int Fs(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(83043);
    try
    {
      int j = bs.getInt(com.tencent.mm.m.g.ZY().getValue(paramString), 1);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(83043);
    return i;
  }
  
  public final void aLq()
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
      bet();
      AppMethodBeat.o(83042);
      return;
      if (this.dmf != null)
      {
        bool1 = this.dmf.getBoolean("permission_allow", false);
        Object localObject1 = this.dmf.getString("url");
        if (bs.isNullOrNil((String)localObject1))
        {
          ac.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
          AppMethodBeat.o(83042);
          return;
        }
        p.a.DfG.a(ai.getContext(), (String)localObject1, bool1);
        continue;
        if (this.dmf != null)
        {
          localObject1 = this.dmf.getIntArray("getConfigStgKey");
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
            com.tencent.mm.kernel.g.agS();
            ((ArrayList)localObject2).add(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(k, null)));
            i += 1;
          }
          this.dmf.putStringArrayList("getConfigStgValue", (ArrayList)localObject2);
          continue;
          if (this.dmf != null)
          {
            localObject1 = this.dmf.getString("localId");
            localObject1 = com.tencent.mm.plugin.webview.modeltools.g.eCa().aBU((String)localObject1);
            if (localObject1 != null)
            {
              this.dmf.putParcelable("item", (Parcelable)localObject1);
              continue;
              i = Fs("WebViewDownLoadFileSwitch");
              if (this.dmf == null) {
                this.dmf = new Bundle();
              }
              localObject1 = this.dmf;
              if (i == 1) {}
              for (;;)
              {
                ((Bundle)localObject1).putBoolean("allowDownloadFile", bool1);
                break;
                bool1 = false;
              }
              i = Fs("EnableWebviewScanQRCode");
              localObject1 = this.dmf;
              if (i == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((Bundle)localObject1).putBoolean("allow_webview_scan", bool1);
                break;
              }
              this.dmf.putBoolean("has_set_uin", com.tencent.mm.kernel.g.agM());
              continue;
              localObject1 = aw.aCa(this.dmf.getString("localId"));
              this.dmf.putString("file_path", (String)localObject1);
              continue;
              localObject1 = this.dmf.getString("game_hv_menu_appid");
              localObject2 = new hw();
              ((hw)localObject2).diU.CW = 3;
              ((hw)localObject2).diU.param = ((String)localObject1);
              com.tencent.mm.sdk.b.a.GpY.l((b)localObject2);
              this.dmf.putString("game_hv_menu_pbcache", ((hw)localObject2).diV.result);
              continue;
              localObject1 = com.tencent.mm.plugin.game.commlib.a.cOv();
              if (localObject1 != null)
              {
                localObject2 = new GameSettingParams();
                ((GameSettingParams)localObject2).CEY = ((de)localObject1).hiu;
                ((GameSettingParams)localObject2).CEZ = ((de)localObject1).tgj;
                ((GameSettingParams)localObject2).CFa = ((de)localObject1).tlG;
                this.dmf.putParcelable("game_setting_params", (Parcelable)localObject2);
                continue;
                c.aT(this.dmf);
              }
            }
          }
        }
      }
    }
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(83041);
    if (this.sWY != null) {
      this.sWY.run();
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
    this.dmf = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(83045);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(83044);
    paramParcel.writeInt(this.type);
    paramParcel.writeBundle(this.dmf);
    AppMethodBeat.o(83044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask
 * JD-Core Version:    0.7.0.1
 */