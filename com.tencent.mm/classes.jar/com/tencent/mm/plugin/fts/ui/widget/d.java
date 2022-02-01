package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.mm.plugin.websearch.webview.c;
import com.tencent.mm.protocal.protobuf.fll;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fts/ui/widget/IPardusUIComponent;", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "Lcom/tencent/mm/protocal/protobuf/WebSearchHomeContext;", "pardusAction", "", "area", "", "requestObj", "Lorg/json/JSONObject;", "renderFinish", "showFTSSearchBar", "ui-fts_release"})
public abstract interface d
  extends c<fll>
{
  public abstract void aW(JSONObject paramJSONObject);
  
  public abstract void b(int paramInt, JSONObject paramJSONObject);
  
  public abstract void esA();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */