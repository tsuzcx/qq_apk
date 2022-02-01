package com.tencent.b.a.a;

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
  public static long cPA = -1L;
  private a cPy = null;
  int cPz = 0;
  private Context mContext = null;
  private int mType = 0;
  
  public n(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
  }
  
  private void JP()
  {
    AppMethodBeat.i(87614);
    g localg1 = r.aY(this.mContext).G(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    g localg2 = r.aY(this.mContext).G(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2) })));
    g localg3 = r.aY(this.mContext).G(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    if ((s.b(localg1, localg2)) && (s.b(localg1, localg3)))
    {
      s.JS();
      AppMethodBeat.o(87614);
      return;
    }
    localg1 = s.a(s.a(localg1, localg2), s.a(localg1, localg3));
    new StringBuilder("local mid check failed, redress with mid:").append(localg1.toString());
    s.JS();
    r.aY(this.mContext).b(localg1);
    AppMethodBeat.o(87614);
  }
  
  private void n(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(87615);
    if (i.cPo != null)
    {
      if (j.cPu == 1)
      {
        s.JS();
        AppMethodBeat.o(87615);
        return;
      }
      if ((j.cPv > 0) && (this.cPz > j.cPv))
      {
        new StringBuilder("limit dispatch:").append(j.cPv);
        s.JS();
        AppMethodBeat.o(87615);
        return;
      }
      paramJSONObject = new m(this.mContext, paramJSONObject).toJSONObject().toString();
      "request data:".concat(String.valueOf(paramJSONObject));
      s.JS();
      i.cPo.en("[" + paramJSONObject + "]");
      cPA = System.currentTimeMillis();
      this.cPz += 1;
    }
    AppMethodBeat.o(87615);
  }
  
  public final void run()
  {
    AppMethodBeat.i(87616);
    new StringBuilder("request type:").append(this.mType);
    s.JS();
    switch (this.mType)
    {
    default: 
      new StringBuilder("wrong type:").append(this.mType);
      s.JS();
      AppMethodBeat.o(87616);
      return;
    case 1: 
      n(null);
      AppMethodBeat.o(87616);
      return;
    }
    if (this.cPy == null) {
      this.cPy = r.aY(this.mContext).JR();
    }
    long l1 = System.currentTimeMillis();
    if (i.cPp <= 0L) {
      i.cPp = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
    }
    long l2 = Math.abs(l1 - i.cPp);
    new StringBuilder("check entity: ").append(this.cPy.toString()).append(",duration:").append(l2);
    s.JS();
    if ((this.cPy.cOR < 0) || (this.cPy.cOR > 100)) {
      this.cPy.cOR = 3;
    }
    long l3 = this.cPy.cOR * e.cPj;
    new StringBuilder("duration:").append(l2).append(",maxCheckDays:").append(l3).append(",mLastCheckTime:").append(i.cPp).append(",mCheckEntity:").append(this.cPy);
    s.JS();
    JSONObject localJSONObject;
    if (l2 < l3)
    {
      if (l2 > e.cPj)
      {
        JP();
        AppMethodBeat.o(87616);
      }
    }
    else
    {
      JP();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("dur", l2);
      localJSONObject.put("md", l3);
      localJSONObject.put("lct", i.cPp);
      localJSONObject.put("cur", l1);
      label352:
      if (cPA <= 0L) {
        n(localJSONObject);
      }
      AppMethodBeat.o(87616);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label352;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.n
 * JD-Core Version:    0.7.0.1
 */