package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  final ArrayList<b> tRa;
  final ArrayList<b> tRb;
  ArrayList<b> tRc;
  long tRd;
  final ArrayList<a> tRe;
  d<?> tRf;
  
  public k()
  {
    AppMethodBeat.i(90816);
    this.tRc = new ArrayList(10);
    this.tRd = 0L;
    this.tRe = new ArrayList(2);
    this.tRa = new ArrayList(10);
    this.tRb = new ArrayList(10);
    AppMethodBeat.o(90816);
  }
  
  final String IB(int paramInt)
  {
    AppMethodBeat.i(184466);
    if (this.tRa != null)
    {
      Object localObject = this.tRa.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if ((localb != null) && (paramInt == localb.tQm))
        {
          localObject = localb.openId;
          AppMethodBeat.o(184466);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(184466);
    return null;
  }
  
  final Map<String, Object> cNA()
  {
    AppMethodBeat.i(202743);
    HashMap localHashMap = new HashMap();
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    try
    {
      Iterator localIterator = this.tRb.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        localJSONArray1.put(localb.openId);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("openId", localb.openId);
        localJSONObject.put("memberId", localb.tQm);
        localJSONObject.put("type", localb.status);
        localJSONArray2.put(localJSONObject);
        continue;
        AppMethodBeat.o(202743);
      }
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceMemberMgr", localJSONException, "", new Object[0]);
    }
    for (;;)
    {
      return localHashMap;
      localHashMap.put("openIdList", localJSONException);
      localHashMap.put("data", localJSONArray2);
    }
  }
  
  final void cNz()
  {
    AppMethodBeat.i(202739);
    this.tRa.clear();
    this.tRb.clear();
    AppMethodBeat.o(202739);
  }
  
  static abstract interface a
  {
    public abstract void R(ArrayList<b> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.k
 * JD-Core Version:    0.7.0.1
 */