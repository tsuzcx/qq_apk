package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.game.f.f;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static volatile d gbk;
  public c gbi;
  public volatile b gbj;
  public final Queue<String> gbl = new LinkedList();
  private d.c gbm = new d.c((byte)0);
  public String mAppId;
  public Context mContext;
  public volatile int mState = 0;
  
  public static d agy()
  {
    if (gbk == null) {}
    try
    {
      if (gbk == null) {
        gbk = new d();
      }
      return gbk;
    }
    finally {}
  }
  
  public static void release()
  {
    if (gbk != null) {
      try
      {
        if (gbk != null)
        {
          gbk.mState = 2;
          gbk.gbm.gdq.clear();
          gbk = null;
        }
        return;
      }
      finally {}
    }
  }
  
  public final void E(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("level", paramInt);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("wxClient: " + paramString);
      localJSONObject.put("logs", localJSONArray);
      tx(localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.GameInspector", paramString, "hy: vConsole json error", new Object[0]);
    }
  }
  
  public final void tx(String paramString)
  {
    synchronized (this.gbl)
    {
      if (this.mState != 1)
      {
        this.gbl.add(paramString);
        return;
      }
      if (this.gbj != null)
      {
        this.gbj.post(new d.2(this, paramString));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.d
 * JD-Core Version:    0.7.0.1
 */