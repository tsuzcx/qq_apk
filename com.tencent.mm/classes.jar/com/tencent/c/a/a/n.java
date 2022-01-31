package com.tencent.c.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
  implements Runnable
{
  public static long bUT = -1L;
  private a bUR = null;
  int bUS = 0;
  private Context mContext = null;
  private int mType = 0;
  
  public n(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
  }
  
  private void l(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(125733);
    if (i.bUH != null)
    {
      if (j.bUN == 1)
      {
        s.zU();
        AppMethodBeat.o(125733);
        return;
      }
      if ((j.bUO > 0) && (this.bUS > j.bUO))
      {
        new StringBuilder("limit dispatch:").append(j.bUO);
        s.zU();
        AppMethodBeat.o(125733);
        return;
      }
      paramJSONObject = new m(this.mContext, paramJSONObject).toJSONObject().toString();
      "request data:".concat(String.valueOf(paramJSONObject));
      s.zU();
      i.bUH.cG("[" + paramJSONObject + "]");
      bUT = System.currentTimeMillis();
      this.bUS += 1;
    }
    AppMethodBeat.o(125733);
  }
  
  private void zR()
  {
    AppMethodBeat.i(125732);
    g localg1 = r.aN(this.mContext).D(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    g localg2 = r.aN(this.mContext).D(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2) })));
    g localg3 = r.aN(this.mContext).D(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    if ((s.b(localg1, localg2)) && (s.b(localg1, localg3)))
    {
      s.zU();
      AppMethodBeat.o(125732);
      return;
    }
    localg1 = s.a(s.a(localg1, localg2), s.a(localg1, localg3));
    new StringBuilder("local mid check failed, redress with mid:").append(localg1.toString());
    s.zU();
    r.aN(this.mContext).b(localg1);
    AppMethodBeat.o(125732);
  }
  
  public final void run()
  {
    AppMethodBeat.i(125734);
    new StringBuilder("request type:").append(this.mType);
    s.zU();
    switch (this.mType)
    {
    default: 
      new StringBuilder("wrong type:").append(this.mType);
      s.zU();
      AppMethodBeat.o(125734);
      return;
    case 1: 
      l(null);
      AppMethodBeat.o(125734);
      return;
    }
    if (this.bUR == null) {
      this.bUR = r.aN(this.mContext).zT();
    }
    long l1 = System.currentTimeMillis();
    if (i.bUI <= 0L) {
      i.bUI = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
    }
    long l2 = Math.abs(l1 - i.bUI);
    new StringBuilder("check entity: ").append(this.bUR.toString()).append(",duration:").append(l2);
    s.zU();
    if ((this.bUR.bUl < 0) || (this.bUR.bUl > 100)) {
      this.bUR.bUl = 3;
    }
    long l3 = this.bUR.bUl * e.bUC;
    new StringBuilder("duration:").append(l2).append(",maxCheckDays:").append(l3).append(",mLastCheckTime:").append(i.bUI).append(",mCheckEntity:").append(this.bUR);
    s.zU();
    JSONObject localJSONObject;
    if (l2 < l3)
    {
      if (l2 > e.bUC)
      {
        zR();
        AppMethodBeat.o(125734);
      }
    }
    else
    {
      zR();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("dur", l2);
      localJSONObject.put("md", l3);
      localJSONObject.put("lct", i.bUI);
      localJSONObject.put("cur", l1);
      label352:
      if (bUT <= 0L) {
        l(localJSONObject);
      }
      AppMethodBeat.o(125734);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label352;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.c.a.a.n
 * JD-Core Version:    0.7.0.1
 */