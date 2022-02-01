package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kk;
import com.tencent.mm.autogen.a.kk.b;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.protobuf.ea;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.game.d;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;

public class CommonLogicTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CommonLogicTask> CREATOR;
  public Runnable Iut;
  public Bundle hPH;
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
    this.hPH = new Bundle();
    AppMethodBeat.o(83046);
  }
  
  CommonLogicTask(Parcel paramParcel)
  {
    AppMethodBeat.i(83047);
    this.hPH = new Bundle();
    h(paramParcel);
    AppMethodBeat.o(83047);
  }
  
  private static int RW(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(83043);
    try
    {
      int j = Util.getInt(i.aRC().getValue(paramString), 1);
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
  
  public final void asn()
  {
    int i = 0;
    boolean bool = true;
    AppMethodBeat.i(83042);
    switch (this.type)
    {
    }
    for (;;)
    {
      cpA();
      AppMethodBeat.o(83042);
      return;
      if (this.hPH != null)
      {
        bool = this.hPH.getBoolean("permission_allow", false);
        Object localObject1 = this.hPH.getString("url");
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
          AppMethodBeat.o(83042);
          return;
        }
        r.a.XNV.b(MMApplicationContext.getContext(), (String)localObject1, bool);
        continue;
        if (this.hPH != null)
        {
          localObject1 = this.hPH.getIntArray("getConfigStgKey");
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
            h.baF();
            ((ArrayList)localObject2).add(Util.nullAsNil((String)h.baE().ban().d(k, null)));
            i += 1;
          }
          this.hPH.putStringArrayList("getConfigStgValue", (ArrayList)localObject2);
          continue;
          if (this.hPH != null)
          {
            localObject1 = this.hPH.getString("localId");
            localObject1 = g.ivZ().bks((String)localObject1);
            if (localObject1 != null)
            {
              this.hPH.putParcelable("item", (Parcelable)localObject1);
              continue;
              if (((c)h.ax(c.class)).a(c.a.yNu, 1) == 1) {}
              for (bool = true;; bool = false)
              {
                if (this.hPH == null) {
                  this.hPH = new Bundle();
                }
                this.hPH.putBoolean("allowDownloadFile", bool);
                break;
              }
              i = RW("EnableWebviewScanQRCode");
              localObject1 = this.hPH;
              if (i == 1) {}
              for (;;)
              {
                ((Bundle)localObject1).putBoolean("allow_webview_scan", bool);
                break;
                bool = false;
              }
              this.hPH.putBoolean("has_set_uin", h.baz());
              continue;
              localObject1 = az.bkC(this.hPH.getString("localId"));
              this.hPH.putString("file_path", (String)localObject1);
              continue;
              localObject1 = this.hPH.getString("game_hv_menu_appid");
              localObject2 = new kk();
              ((kk)localObject2).hMa.bUl = 3;
              ((kk)localObject2).hMa.param = ((String)localObject1);
              ((kk)localObject2).publish();
              this.hPH.putString("game_hv_menu_pbcache", ((kk)localObject2).hMb.result);
              continue;
              localObject1 = a.fDS();
              if (localObject1 != null)
              {
                localObject2 = new GameSettingParams();
                ((GameSettingParams)localObject2).XfU = ((ea)localObject1).nRQ;
                ((GameSettingParams)localObject2).XfV = ((ea)localObject1).IFK;
                ((GameSettingParams)localObject2).XfW = ((ea)localObject1).ILO;
                this.hPH.putParcelable("game_setting_params", (Parcelable)localObject2);
                continue;
                d.bO(this.hPH);
              }
            }
          }
        }
      }
    }
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(83041);
    if (this.Iut != null) {
      this.Iut.run();
    }
    AppMethodBeat.o(83041);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(83045);
    this.type = paramParcel.readInt();
    this.hPH = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(83045);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(83044);
    paramParcel.writeInt(this.type);
    paramParcel.writeBundle(this.hPH);
    AppMethodBeat.o(83044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask
 * JD-Core Version:    0.7.0.1
 */