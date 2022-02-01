package com.tencent.mm.plugin.brandservice.ui.c;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "adRequest", "", "message", "", "subType", "callback", "canvasRequest", "businessId", "", "reqJson", "deleteCanvasCard", "fieldId", "getData", "getInfo", "", "key", "onItemClick", "pos", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
  extends com.tencent.mm.plugin.ax.b
{
  public abstract void adRequest(String paramString1, String paramString2, String paramString3);
  
  public abstract void canvasRequest(Number paramNumber, String paramString1, String paramString2);
  
  public abstract void deleteCanvasCard(String paramString);
  
  public abstract String getData();
  
  public abstract Object getInfo(String paramString);
  
  public abstract void onItemClick(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.c.b
 * JD-Core Version:    0.7.0.1
 */