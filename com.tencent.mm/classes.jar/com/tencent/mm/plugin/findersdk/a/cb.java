package com.tencent.mm.plugin.findersdk.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import kotlin.Metadata;
import kotlinx.coroutines.b.g;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderWebSearchService;", "Lcom/tencent/mm/kernel/service/IService;", "enterFinderSearch", "", "context", "Landroid/content/Context;", "json", "Lorg/json/JSONObject;", "enterFinderTimeline", "getFinderItemDetail", "Lkotlinx/coroutines/flow/Flow;", "", "preloadFinderItem", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface cb
  extends a
{
  public abstract boolean f(Context paramContext, JSONObject paramJSONObject);
  
  public abstract boolean g(Context paramContext, JSONObject paramJSONObject);
  
  public abstract g<String> h(Context paramContext, JSONObject paramJSONObject);
  
  public abstract boolean i(Context paramContext, JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.cb
 * JD-Core Version:    0.7.0.1
 */