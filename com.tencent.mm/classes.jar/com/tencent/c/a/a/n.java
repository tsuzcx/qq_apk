package com.tencent.c.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
  implements Runnable
{
  public static long btJ = -1L;
  private a btH = null;
  int btI = 0;
  private Context mContext = null;
  private int mType = 0;
  
  public n(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
  }
  
  private void e(JSONObject paramJSONObject)
  {
    if ((i.btx == null) || (j.btD == 1)) {
      return;
    }
    if ((j.btE > 0) && (this.btI > j.btE))
    {
      new StringBuilder("limit dispatch:").append(j.btE);
      return;
    }
    paramJSONObject = new m(this.mContext, paramJSONObject).rB().toString();
    i.btx.bD("[" + paramJSONObject + "]");
    btJ = System.currentTimeMillis();
    this.btI += 1;
  }
  
  private void rC()
  {
    g localg1 = r.ap(this.mContext).A(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    g localg2 = r.ap(this.mContext).A(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2) })));
    g localg3 = r.ap(this.mContext).A(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    if ((s.b(localg1, localg2)) && (s.b(localg1, localg3))) {
      return;
    }
    localg1 = s.a(s.a(localg1, localg2), s.a(localg1, localg3));
    new StringBuilder("local mid check failed, redress with mid:").append(localg1.toString());
    r.ap(this.mContext).b(localg1);
  }
  
  public final void run()
  {
    new StringBuilder("request type:").append(this.mType);
    switch (this.mType)
    {
    default: 
      new StringBuilder("wrong type:").append(this.mType);
    }
    for (;;)
    {
      return;
      e(null);
      return;
      if (this.btH == null) {
        this.btH = r.ap(this.mContext).rE();
      }
      long l1 = System.currentTimeMillis();
      if (i.bty <= 0L) {
        i.bty = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
      }
      long l2 = Math.abs(l1 - i.bty);
      new StringBuilder("check entity: ").append(this.btH.toString()).append(",duration:").append(l2);
      if ((this.btH.bsZ < 0) || (this.btH.bsZ > 100)) {
        this.btH.bsZ = 3;
      }
      long l3 = this.btH.bsZ * e.bts;
      new StringBuilder("duration:").append(l2).append(",maxCheckDays:").append(l3).append(",mLastCheckTime:").append(i.bty).append(",mCheckEntity:").append(this.btH);
      if (l2 < l3)
      {
        if (l2 <= e.bts) {
          continue;
        }
        rC();
        return;
      }
      rC();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("dur", l2);
        localJSONObject.put("md", l3);
        localJSONObject.put("lct", i.bty);
        localJSONObject.put("cur", l1);
        label320:
        if (btJ > 0L) {
          continue;
        }
        e(localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label320;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.c.a.a.n
 * JD-Core Version:    0.7.0.1
 */