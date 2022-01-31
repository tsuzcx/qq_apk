package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.a.gr;
import com.tencent.mm.h.a.gr.b;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.game.d.dc;
import com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;

public class CommonLogicTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<CommonLogicTask> CREATOR = new CommonLogicTask.1();
  public Runnable kNf;
  public Bundle kke = new Bundle();
  public int type;
  
  public CommonLogicTask() {}
  
  CommonLogicTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  private static int oX(String paramString)
  {
    try
    {
      int i = bk.getInt(com.tencent.mm.m.g.AA().getValue(paramString), 1);
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: " + paramString);
    }
    return 1;
  }
  
  public final void Zu()
  {
    int i = 0;
    boolean bool2 = true;
    boolean bool1 = true;
    switch (this.type)
    {
    }
    for (;;)
    {
      ahI();
      Object localObject1;
      do
      {
        return;
        if (this.kke == null) {
          break;
        }
        bool1 = this.kke.getBoolean("permission_allow", false);
        localObject1 = this.kke.getString("url");
        if (bk.bl((String)localObject1))
        {
          y.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
          return;
        }
        p.a.rSH.a(ae.getContext(), (String)localObject1, bool1);
        break;
        if (this.kke == null) {
          break;
        }
        localObject1 = this.kke.getIntArray("getConfigStgKey");
      } while ((localObject1 == null) || (localObject1.length == 0));
      Object localObject2 = new ArrayList();
      int j = localObject1.length;
      while (i < j)
      {
        int k = localObject1[i];
        au.Hx();
        ((ArrayList)localObject2).add(bk.pm((String)com.tencent.mm.model.c.Dz().get(k, null)));
        i += 1;
      }
      this.kke.putStringArrayList("getConfigStgValue", (ArrayList)localObject2);
      continue;
      if (this.kke != null)
      {
        localObject1 = this.kke.getString("localId");
        localObject1 = com.tencent.mm.plugin.webview.modeltools.g.ccL().Sl((String)localObject1);
        if (localObject1 != null)
        {
          this.kke.putParcelable("item", (Parcelable)localObject1);
          continue;
          i = oX("WebViewDownLoadFileSwitch");
          if (this.kke == null) {
            this.kke = new Bundle();
          }
          localObject1 = this.kke;
          if (i == 1) {}
          for (;;)
          {
            ((Bundle)localObject1).putBoolean("allowDownloadFile", bool1);
            break;
            bool1 = false;
          }
          i = oX("EnableWebviewScanQRCode");
          localObject1 = this.kke;
          if (i == 1) {}
          for (bool1 = bool2;; bool1 = false)
          {
            ((Bundle)localObject1).putBoolean("allow_webview_scan", bool1);
            break;
          }
          this.kke.putBoolean("has_set_uin", au.DK());
          continue;
          localObject1 = new cj();
          com.tencent.mm.pluginsdk.model.e.a((cj)localObject1, 1, this.kke.getString("image_path", ""));
          com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
          this.kke.putInt("fav_simple_img_result", ((cj)localObject1).bIx.ret);
          continue;
          localObject1 = am.Sp(this.kke.getString("localId"));
          this.kke.putString("file_path", (String)localObject1);
          continue;
          localObject1 = this.kke.getString("game_hv_menu_appid");
          localObject2 = new gr();
          ((gr)localObject2).bOv.uC = 3;
          ((gr)localObject2).bOv.bOx = ((String)localObject1);
          com.tencent.mm.sdk.b.a.udP.m((b)localObject2);
          this.kke.putString("game_hv_menu_pbcache", ((gr)localObject2).bOw.result);
          continue;
          localObject1 = com.tencent.mm.plugin.game.commlib.a.aYn();
          if (localObject1 != null)
          {
            localObject2 = new GameSettingParams();
            ((GameSettingParams)localObject2).rwl = ((dc)localObject1).color;
            ((GameSettingParams)localObject2).rwm = ((dc)localObject1).kQS;
            this.kke.putParcelable("game_setting_params", (Parcelable)localObject2);
            continue;
            com.tencent.mm.plugin.webview.ui.tools.game.c.ad(this.kke);
          }
        }
      }
    }
  }
  
  public final void Zv()
  {
    if (this.kNf != null) {
      this.kNf.run();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.kke = paramParcel.readBundle(getClass().getClassLoader());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeBundle(this.kke);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask
 * JD-Core Version:    0.7.0.1
 */