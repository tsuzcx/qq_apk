package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/AdSnsCache;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/AdCache;", "id", "", "data", "Lcom/tencent/mm/json/JSONObject;", "(JLcom/tencent/mm/json/JSONObject;)V", "buttonTitle", "", "getButtonTitle", "()Ljava/lang/String;", "setButtonTitle", "(Ljava/lang/String;)V", "canvasId", "getCanvasId", "()J", "setCanvasId", "(J)V", "canvasType", "", "getCanvasType", "()I", "setCanvasType", "(I)V", "getData", "()Lcom/tencent/mm/json/JSONObject;", "type", "getType", "setType", "url", "getUrl", "setUrl", "uxInfo", "getUxInfo", "setUxInfo", "toString", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final a Beu;
  private final i Bed;
  public long Bev;
  private int Bew;
  public String hBr;
  private final long id;
  public int type;
  private String url;
  public String uxInfo;
  
  static
  {
    AppMethodBeat.i(366036);
    Beu = new a((byte)0);
    AppMethodBeat.o(366036);
  }
  
  public b(long paramLong, i parami)
  {
    super(paramLong);
    AppMethodBeat.i(366030);
    this.id = paramLong;
    this.Bed = parami;
    this.url = "";
    this.uxInfo = "";
    this.hBr = "";
    this.url = this.Bed.optString("url");
    this.type = this.Bed.optInt("ad_type");
    parami = this.Bed.optString("uxinfo");
    s.s(parami, "data.optString(Constants…r.AdInfoKeys.KEY_UX_INFO)");
    this.uxInfo = parami;
    this.Bev = this.Bed.optLong("canvas_id");
    this.Bew = this.Bed.optInt("canvas_type");
    parami = this.Bed.optString("button_title");
    s.s(parami, "data.optString(Constants…nfoKeys.KEY_BUTTON_TITLE)");
    this.hBr = parami;
    Log.i("AdSnsCache", "data:" + this.Bed + " url :" + this.url + " type :" + this.type + " canvasId:" + this.Bev + " canvasType:" + this.Bew + " buttonTitle:" + this.hBr + " uxInfo:" + this.uxInfo);
    AppMethodBeat.o(366030);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(366042);
    String str = "AdSnsCache id:" + d.hF(this.id) + " type:" + this.type + " canvasId:" + this.Bev + " url:" + this.url;
    AppMethodBeat.o(366042);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/AdSnsCache$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.b
 * JD-Core Version:    0.7.0.1
 */