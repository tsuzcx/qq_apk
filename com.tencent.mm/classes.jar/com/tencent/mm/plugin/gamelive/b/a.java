package com.tencent.mm.plugin.gamelive.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.gamelive.PluginGameLive.IPCLiveControlData;
import com.tencent.mm.plugin.gamelive.PluginGameLive.IPCLiveControlData.b;
import com.tencent.mm.plugin.gamelive.PluginGameLive.c;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveIntPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LivePlayGamePayLoad;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.h;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class a
  implements b.a
{
  private static String TAG = "GameLivePlayGameAnchorInviteWidget";
  private h JfN;
  private JSONObject JfO;
  private boolean JfP;
  private String JfQ;
  private String JfR;
  private String JfS;
  private TextView JfT;
  private TextView JfU;
  private TextView JfV;
  private JSONArray JfW;
  private GameLiveAppbrandEventService.LivePlayGamePayLoad JfX;
  private int JfY;
  private int JfZ;
  private b Jga;
  public com.tencent.mm.plugin.gamelive.b.a Jgb;
  private boolean Jgc;
  public JSONObject eif;
  private final Context mContext;
  
  public a(Context paramContext, JSONObject paramJSONObject, String paramString, int paramInt, com.tencent.mm.plugin.gamelive.b.a parama)
  {
    AppMethodBeat.i(277329);
    this.JfN = null;
    this.JfO = new JSONObject();
    this.JfP = false;
    this.JfQ = "";
    this.JfR = "";
    this.JfS = "";
    this.JfX = new GameLiveAppbrandEventService.LivePlayGamePayLoad((byte)0);
    this.JfY = 6;
    this.JfZ = this.JfY;
    this.Jga = new b(this);
    this.Jgb = null;
    this.Jgc = false;
    this.mContext = paramContext;
    this.eif = paramJSONObject;
    this.Jgb = parama;
    fB(paramString, paramInt);
    refreshView();
    AppMethodBeat.o(277329);
  }
  
  private void Ya(int paramInt)
  {
    this.JfZ = paramInt;
    this.JfX.Jfv = paramInt;
  }
  
  private void fIV()
  {
    AppMethodBeat.i(277335);
    this.JfN.dDn();
    this.JfX.type = 1;
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdU, null, 0, this.JfX), PluginGameLive.c.class, null);
    AppMethodBeat.o(277335);
  }
  
  public final void fB(String paramString, int paramInt)
  {
    AppMethodBeat.i(277454);
    if (this.eif.optBoolean("canJoin", false))
    {
      this.JfP = true;
      this.JfQ = this.eif.optString("title", "");
      this.JfR = this.eif.optString("subTitle", "");
      this.JfS = this.eif.optString("statusWording", "");
      this.JfW = this.eif.optJSONArray("condition");
      this.JfZ = this.eif.optInt("defaultConditionIndex");
      this.JfX.title = this.JfQ;
      this.JfX.Jfw = this.JfR;
      this.JfX.Jfx = this.JfS;
      this.JfX.Jfy = this.eif.optString("teamupExtraData", "");
      this.JfX.appid = paramString;
      this.JfX.euz = paramInt;
      this.JfX.Jfv = this.JfZ;
      this.JfX.path = this.eif.optString("path", "");
      this.JfX.Jfz = this.eif.optInt("sourceType");
      AppMethodBeat.o(277454);
      return;
    }
    this.JfP = false;
    AppMethodBeat.o(277454);
  }
  
  public final void fC(String paramString, int paramInt)
  {
    AppMethodBeat.i(277482);
    if ((this.JfN == null) || (this.JfN.rootView == null))
    {
      Log.e(TAG, "null");
      AppMethodBeat.o(277482);
      return;
    }
    Ya(paramInt);
    ((TextView)this.JfN.rootView.findViewById(ba.f.paygame_team_condition_desc_tv)).setText(paramString);
    AppMethodBeat.o(277482);
  }
  
  public final void refreshView()
  {
    int i = 0;
    AppMethodBeat.i(277471);
    if (!this.JfP)
    {
      this.JfN = new h(this.mContext, 0, false, false);
      this.JfN.agfD = new a..ExternalSyntheticLambda6(this);
      this.JfN.GwS = true;
      this.JfN.aFa(ba.g.app_brand_gamelive_paygame_cannot_join);
      ((ViewGroup)this.JfN.rootView.findViewById(ba.f.gamelive_paygame_back_icon)).setOnClickListener(new a..ExternalSyntheticLambda0(this));
      this.JfN.dDn();
      AppMethodBeat.o(277471);
      return;
    }
    if (this.JfN == null)
    {
      this.JfN = new h(this.mContext, 0, true, false);
      this.JfN = new h(this.mContext, 0, false, false);
      this.JfN.agfD = new a..ExternalSyntheticLambda5(this);
      this.JfN.GwS = true;
      this.JfN.aFa(ba.g.app_brand_gamelive_paygame_root);
      localObject = this.JfN.rootView;
      ((View)localObject).findViewById(ba.f.gamelive_paygame_Button).setOnClickListener(new a..ExternalSyntheticLambda1(this));
      ((ViewGroup)((View)localObject).findViewById(ba.f.gamelive_paygame_back_icon)).setOnClickListener(new a..ExternalSyntheticLambda3(this));
      this.JfT = ((TextView)((View)localObject).findViewById(ba.f.gamelive_paygame_content_title_1));
      this.JfU = ((TextView)((View)localObject).findViewById(ba.f.gamelive_paygame_content_title_2));
      this.JfV = ((TextView)((View)localObject).findViewById(ba.f.gamelive_paygame_content_title_3));
      ((ViewGroup)((View)localObject).findViewById(ba.f.gamelive_paygame_team_condition_layout)).setOnClickListener(new a..ExternalSyntheticLambda2(this));
    }
    this.JfT.setText(this.JfQ);
    this.JfU.setText(this.JfR);
    this.JfV.setText(this.JfS);
    Object localObject = (TextView)this.JfN.rootView.findViewById(ba.f.paygame_team_condition_desc_tv);
    for (;;)
    {
      if (i < this.JfW.length()) {}
      try
      {
        JSONObject localJSONObject = this.JfW.getJSONObject(i);
        if (localJSONObject.optInt("conditionId") == this.JfZ)
        {
          ((TextView)localObject).setText(localJSONObject.optString("wording"));
          fIV();
          AppMethodBeat.o(277471);
          return;
        }
        if (i == this.JfW.length() - 1)
        {
          Ya(localJSONObject.optInt("conditionId"));
          ((TextView)localObject).setText(localJSONObject.optString("wording"));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(TAG, Util.stackTraceToString(localException));
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.b.a
 * JD-Core Version:    0.7.0.1
 */