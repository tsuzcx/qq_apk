package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/AdSnsCache;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/AdCache;", "id", "", "data", "Lcom/tencent/mm/json/JSONObject;", "(JLcom/tencent/mm/json/JSONObject;)V", "canvasId", "getCanvasId", "()J", "setCanvasId", "(J)V", "canvasType", "", "getCanvasType", "()I", "setCanvasType", "(I)V", "getData", "()Lcom/tencent/mm/json/JSONObject;", "type", "getType", "setType", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "uxInfo", "getUxInfo", "setUxInfo", "toString", "Companion", "plugin-finder_release"})
public final class b
  extends a
{
  public static final a xFE;
  private final long id;
  public int type;
  private String url;
  public String uxInfo;
  private final i xFA;
  public long xFC;
  private int xFD;
  
  static
  {
    AppMethodBeat.i(288723);
    xFE = new a((byte)0);
    AppMethodBeat.o(288723);
  }
  
  public b(long paramLong, i parami)
  {
    super(paramLong);
    AppMethodBeat.i(288722);
    this.id = paramLong;
    this.xFA = parami;
    this.url = "";
    this.uxInfo = "";
    this.url = this.xFA.optString("url");
    this.type = this.xFA.optInt("ad_type");
    parami = this.xFA.optString("uxinfo");
    p.j(parami, "data.optString(Constants…r.AdInfoKeys.KEY_UX_INFO)");
    this.uxInfo = parami;
    this.xFC = this.xFA.optLong("canvas_id");
    this.xFD = this.xFA.optInt("canvas_type");
    Log.i("AdSnsCache", "data:" + this.xFA + " url :" + this.url + " type :" + this.type + " canvasId:" + this.xFC + " canvasType:" + this.xFD + " uxInfo:" + this.uxInfo);
    AppMethodBeat.o(288722);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(288721);
    String str = "AdSnsCache id:" + d.Fw(this.id) + " type:" + this.type + " canvasId:" + this.xFC + " url:" + this.url;
    AppMethodBeat.o(288721);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/AdSnsCache$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.b
 * JD-Core Version:    0.7.0.1
 */