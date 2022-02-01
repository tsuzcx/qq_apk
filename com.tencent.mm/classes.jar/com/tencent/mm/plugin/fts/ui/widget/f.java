package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.mm.plugin.websearch.webview.d;
import com.tencent.mm.protocal.protobuf.gia;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/widget/IPardusUIComponent;", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "Lcom/tencent/mm/protocal/protobuf/WebSearchHomeContext;", "pardusAction", "", "area", "", "requestObj", "Lorg/json/JSONObject;", "renderFinish", "showFTSSearchBar", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
  extends d<gia>
{
  public abstract void bj(JSONObject paramJSONObject);
  
  public abstract void d(int paramInt, JSONObject paramJSONObject);
  
  public abstract void fzz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */