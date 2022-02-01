package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i.d;
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
  final ArrayList<b> wUq;
  final ArrayList<b> wUr;
  ArrayList<b> wUs;
  long wUt;
  final ArrayList<a> wUu;
  d<?> wUv;
  
  public k()
  {
    AppMethodBeat.i(90816);
    this.wUs = new ArrayList(10);
    this.wUt = 0L;
    this.wUu = new ArrayList(2);
    this.wUq = new ArrayList(10);
    this.wUr = new ArrayList(10);
    AppMethodBeat.o(90816);
  }
  
  final String Je(int paramInt)
  {
    AppMethodBeat.i(184466);
    if (this.wUq != null)
    {
      Object localObject = this.wUq.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if ((localb != null) && (paramInt == localb.wTC))
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
  
  final void drf()
  {
    AppMethodBeat.i(268308);
    this.wUq.clear();
    this.wUr.clear();
    AppMethodBeat.o(268308);
  }
  
  final Map<String, Object> drg()
  {
    AppMethodBeat.i(268315);
    HashMap localHashMap = new HashMap();
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    try
    {
      Iterator localIterator = this.wUr.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        localJSONArray1.put(localb.openId);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("openId", localb.openId);
        localJSONObject.put("memberId", localb.wTC);
        localJSONObject.put("type", localb.status);
        localJSONArray2.put(localJSONObject);
        continue;
        AppMethodBeat.o(268315);
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
  
  static abstract interface a
  {
    public abstract void V(ArrayList<b> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.k
 * JD-Core Version:    0.7.0.1
 */