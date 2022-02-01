package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/AdMutualCache;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/AdCache;", "id", "", "data", "Lcom/tencent/mm/json/JSONObject;", "(JLcom/tencent/mm/json/JSONObject;)V", "adH", "", "getAdH", "()I", "setAdH", "(I)V", "adW", "getAdW", "setAdW", "aid", "", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "caption", "getCaption", "setCaption", "getData", "()Lcom/tencent/mm/json/JSONObject;", "description", "getDescription", "setDescription", "exposeIntervalTime", "getExposeIntervalTime", "()J", "setExposeIntervalTime", "(J)V", "exposedTime", "getExposedTime", "setExposedTime", "iconUrl", "getIconUrl", "setIconUrl", "getId", "isExposed", "", "()Z", "setExposed", "(Z)V", "isVisibleExposed", "setVisibleExposed", "posId", "getPosId", "setPosId", "url", "getUrl", "setUrl", "uxinfo", "getUxinfo", "setUxinfo", "endExpose", "", "report", "startExpose", "toString", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.finder.feed.model.internal.a
{
  public static final a xFB;
  private String aid;
  public String caption;
  public String description;
  public String iconUrl;
  private final long id;
  public String jDL;
  public String url;
  public final i xFA;
  public boolean xFv;
  private long xFw;
  public String xFx;
  public int xFy;
  public int xFz;
  public boolean xpx;
  
  static
  {
    AppMethodBeat.i(285322);
    xFB = new a((byte)0);
    AppMethodBeat.o(285322);
  }
  
  public a(long paramLong, i parami)
  {
    super(paramLong);
    AppMethodBeat.i(285321);
    this.id = paramLong;
    this.xFA = parami;
    this.iconUrl = "";
    this.description = "";
    this.caption = "";
    this.jDL = "";
    this.aid = "";
    this.xFx = "";
    this.url = this.xFA.optString("url");
    parami = this.xFA.optString("uxinfo");
    p.j(parami, "data.optString(Constants…r.AdInfoKeys.KEY_UX_INFO)");
    this.jDL = parami;
    parami = this.xFA.optString("aid");
    p.j(parami, "data.optString(ConstantsFinder.AdInfoKeys.KEY_AID)");
    this.aid = parami;
    parami = this.xFA.optString("ad_posid");
    p.j(parami, "data.optString(Constants…er.AdInfoKeys.KEY_POS_ID)");
    this.xFx = parami;
    Log.i("Finder.AdMutualCache", "id :" + this.id);
    try
    {
      parami = new JSONArray(this.xFA.optString("crt_info"));
      if (parami.length() > 0)
      {
        parami = parami.getJSONObject(0);
        this.iconUrl = parami.optString("image_url");
        parami = parami.optJSONObject("card_info");
        if (parami != null)
        {
          String str = parami.optString("description");
          p.j(str, "optString(KEY_DESCRIPTION)");
          this.description = str;
          parami = parami.optString("caption");
          p.j(parami, "optString(KEY_CAPTION)");
          this.caption = parami;
          AppMethodBeat.o(285321);
          return;
        }
        AppMethodBeat.o(285321);
        return;
      }
    }
    catch (Exception parami)
    {
      AppMethodBeat.o(285321);
    }
  }
  
  public final void duf()
  {
    AppMethodBeat.i(285319);
    Log.i("Finder.AdMutualCache", "startExpose");
    if (!this.xpx) {
      this.xFw = cm.bfD();
    }
    AppMethodBeat.o(285319);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(285320);
    String str = "id:" + d.Fw(this.id) + " url:" + this.url + " description:" + this.description + " caption:" + this.caption + " isExposed:" + this.xpx;
    AppMethodBeat.o(285320);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/AdMutualCache$Companion;", "", "()V", "EXPOSE_LIMIT", "", "TAG", "", "THREAD_TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.a
 * JD-Core Version:    0.7.0.1
 */