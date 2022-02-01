package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "isValid", "", "()Z", "type", "", "getType", "()Ljava/lang/String;", "toJson", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends com.tencent.mm.sticker.a
{
  public abstract String getType();
  
  public abstract boolean isValid();
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = super.toJson();
    localJSONObject.put("type", getType());
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.a
 * JD-Core Version:    0.7.0.1
 */