package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.net.http.HttpProxyRule;
import java.util.List;

public class ck
  extends JsonComposer
{
  @Json(name="privacy_protection")
  public boolean a;
  @Json(name="http_proxy")
  public List<HttpProxyRule> b;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ck
 * JD-Core Version:    0.7.0.1
 */