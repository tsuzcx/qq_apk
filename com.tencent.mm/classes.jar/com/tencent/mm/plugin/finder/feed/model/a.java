package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/AdMutualInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/AdCache;", "id", "", "data", "Lcom/tencent/mm/json/JSONObject;", "(JLcom/tencent/mm/json/JSONObject;)V", "adH", "", "getAdH", "()I", "setAdH", "(I)V", "adW", "getAdW", "setAdW", "aid", "getAid", "()J", "setAid", "(J)V", "caption", "", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "getData", "()Lcom/tencent/mm/json/JSONObject;", "description", "getDescription", "setDescription", "exposeIntervalTime", "getExposeIntervalTime", "setExposeIntervalTime", "exposedTime", "getExposedTime", "setExposedTime", "iconUrl", "getIconUrl", "setIconUrl", "getId", "isExposed", "", "()Z", "setExposed", "(Z)V", "isVisibleExposed", "setVisibleExposed", "posId", "getPosId", "setPosId", "url", "getUrl", "setUrl", "uxinfo", "getUxinfo", "setUxinfo", "endExpose", "", "report", "startExpose", "toString", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.feed.model.internal.a
{
  public static final a Ber;
  private boolean AMQ;
  private final i Bed;
  private long Bee;
  private String Bef;
  private long Bes;
  private String Bet;
  private String description;
  private String iconUrl;
  private final long id;
  private String mdG;
  private String url;
  
  static
  {
    AppMethodBeat.i(366052);
    Ber = new a((byte)0);
    AppMethodBeat.o(366052);
  }
  
  public a(long paramLong, i parami)
  {
    super(paramLong);
    AppMethodBeat.i(366047);
    this.id = paramLong;
    this.Bed = parami;
    this.iconUrl = "";
    this.description = "";
    this.Bet = "";
    this.mdG = "";
    this.Bef = "";
    this.url = this.Bed.optString("url");
    parami = this.Bed.optString("uxinfo");
    s.s(parami, "data.optString(Constants…r.AdInfoKeys.KEY_UX_INFO)");
    this.mdG = parami;
    this.Bee = this.Bed.optLong("aid");
    parami = this.Bed.optString("ad_posid");
    s.s(parami, "data.optString(Constants…er.AdInfoKeys.KEY_POS_ID)");
    this.Bef = parami;
    Log.i("Finder.AdMutualCache", "id :" + this.id + " aid:" + this.Bee);
    try
    {
      parami = new JSONArray(this.Bed.optString("crt_info"));
      if (parami.length() > 0)
      {
        parami = parami.getJSONObject(0);
        this.iconUrl = parami.optString("image_url");
        parami = parami.optJSONObject("card_info");
        if (parami != null)
        {
          String str = parami.optString("description");
          s.s(str, "optString(KEY_DESCRIPTION)");
          s.u(str, "<set-?>");
          this.description = str;
          parami = parami.optString("caption");
          s.s(parami, "optString(KEY_CAPTION)");
          s.u(parami, "<set-?>");
          this.Bet = parami;
          AppMethodBeat.o(366047);
          return;
        }
      }
    }
    catch (Exception parami)
    {
      AppMethodBeat.o(366047);
    }
  }
  
  public final void edE()
  {
    AppMethodBeat.i(366058);
    Log.i("Finder.AdMutualCache", "startExpose");
    if (!this.AMQ) {
      this.Bes = cn.bDv();
    }
    AppMethodBeat.o(366058);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(366065);
    String str = "id:" + d.hF(this.id) + " url:" + this.url + " description:" + this.description + " caption:" + this.Bet + " isExposed:" + this.AMQ;
    AppMethodBeat.o(366065);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/AdMutualInfo$Companion;", "", "()V", "EXPOSE_LIMIT", "", "TAG", "", "THREAD_TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.a
 * JD-Core Version:    0.7.0.1
 */