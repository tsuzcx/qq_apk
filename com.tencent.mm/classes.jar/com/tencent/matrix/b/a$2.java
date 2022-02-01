package com.tencent.matrix.b;

import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

final class a$2
  implements Runnable
{
  a$2(a parama, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    ad.i("MicroMsg.AnrReportListener", "[happen] %s", new Object[] { this.cwc.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.b.a.2
 * JD-Core Version:    0.7.0.1
 */