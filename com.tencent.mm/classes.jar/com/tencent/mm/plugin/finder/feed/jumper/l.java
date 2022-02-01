package com.tencent.mm.plugin.finder.feed.jumper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderMutualJumpInfoCache;", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoCache;", "data", "Lcom/tencent/mm/json/JSONObject;", "(Lcom/tencent/mm/json/JSONObject;)V", "adH", "", "getAdH", "()I", "setAdH", "(I)V", "adW", "getAdW", "setAdW", "aid", "", "getAid", "()J", "setAid", "(J)V", "getData", "()Lcom/tencent/mm/json/JSONObject;", "exposeIntervalTime", "getExposeIntervalTime", "setExposeIntervalTime", "exposedTime", "getExposedTime", "setExposedTime", "isExposed", "", "()Z", "setExposed", "(Z)V", "isVisibleExposed", "setVisibleExposed", "posId", "", "getPosId", "()Ljava/lang/String;", "setPosId", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "uxinfo", "getUxinfo", "setUxinfo", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends j
{
  public static final l.a Bec;
  boolean AMQ;
  final i Bed;
  long Bee;
  String Bef;
  int Beg;
  int Beh;
  String mdG;
  String url;
  
  static
  {
    AppMethodBeat.i(364189);
    Bec = new l.a((byte)0);
    AppMethodBeat.o(364189);
  }
  
  public l(i parami)
  {
    AppMethodBeat.i(364185);
    this.Bed = parami;
    this.url = this.Bed.optString("url");
    this.mdG = "";
    this.Bef = "";
    parami = this.Bed.optString("uxinfo");
    s.s(parami, "data.optString(Constants…r.AdInfoKeys.KEY_UX_INFO)");
    this.mdG = parami;
    this.Bee = this.Bed.optLong("aid");
    parami = this.Bed.optString("ad_posid");
    s.s(parami, "data.optString(Constants…er.AdInfoKeys.KEY_POS_ID)");
    this.Bef = parami;
    Log.i("Finder.MutualJumpInfoCache", s.X("aid:", Long.valueOf(this.Bee)));
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
          this.title = ((CharSequence)parami.optString("description"));
          this.BdX = ((CharSequence)parami.optString("caption"));
          AppMethodBeat.o(364185);
          return;
        }
      }
    }
    catch (Exception parami)
    {
      AppMethodBeat.o(364185);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.l
 * JD-Core Version:    0.7.0.1
 */