package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.comps.offlinemap.OfflineItem;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class ca
  extends JsonComposer
{
  @Json(name="domain1")
  public String a;
  @Json(name="dirNew")
  public String b;
  @Json(name="domain")
  public String c;
  @Json(name="fileversion")
  public int d;
  @Json(name="updateData")
  public List<by> e;
  
  public final by a(OfflineItem paramOfflineItem)
  {
    AppMethodBeat.i(222180);
    Object localObject = this.e;
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (by)localIterator.next();
        if (paramOfflineItem.getPinyin().equals(((by)localObject).c)) {
          ((by)localObject).a = ("https://" + this.c + this.b);
        }
      }
    }
    for (paramOfflineItem = (OfflineItem)localObject;; paramOfflineItem = null)
    {
      AppMethodBeat.o(222180);
      return paramOfflineItem;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ca
 * JD-Core Version:    0.7.0.1
 */