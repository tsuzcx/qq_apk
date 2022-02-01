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
  public static long cGD = -1L;
  private a cGB = null;
  int cGC = 0;
  private Context mContext = null;
  private int mType = 0;
  
  public n(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
  }
  
  private void Iy()
  {
    AppMethodBeat.i(87614);
    g localg1 = r.aW(this.mContext).P(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    g localg2 = r.aW(this.mContext).P(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2) })));
    g localg3 = r.aW(this.mContext).P(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    if ((s.b(localg1, localg2)) && (s.b(localg1, localg3)))
    {
      s.IB();
      AppMethodBeat.o(87614);
      return;
    }
    localg1 = s.a(s.a(localg1, localg2), s.a(localg1, localg3));
    new StringBuilder("local mid check failed, redress with mid:").append(localg1.toString());
    s.IB();
    r.aW(this.mContext).b(localg1);
    AppMethodBeat.o(87614);
  }
  
  private void n(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(87615);
    if (i.cGr != null)
    {
      if (j.cGx == 1)
      {
        s.IB();
        AppMethodBeat.o(87615);
        return;
      }
      if ((j.cGy > 0) && (this.cGC > j.cGy))
      {
        new StringBuilder("limit dispatch:").append(j.cGy);
        s.IB();
        AppMethodBeat.o(87615);
        return;
      }
      paramJSONObject = new m(this.mContext, paramJSONObject).toJSONObject().toString();
      "request data:".concat(String.valueOf(paramJSONObject));
      s.IB();
      i.cGr.dx("[" + paramJSONObject + "]");
      cGD = System.currentTimeMillis();
      this.cGC += 1;
    }
    AppMethodBeat.o(87615);
  }
  
  public final void run()
  {
    AppMethodBeat.i(87616);
    new StringBuilder("request type:").append(this.mType);
    s.IB();
    switch (this.mType)
    {
    default: 
      new StringBuilder("wrong type:").append(this.mType);
      s.IB();
      AppMethodBeat.o(87616);
      return;
    case 1: 
      n(null);
      AppMethodBeat.o(87616);
      return;
    }
    if (this.cGB == null) {
      this.cGB = r.aW(this.mContext).IA();
    }
    long l1 = System.currentTimeMillis();
    if (i.cGs <= 0L) {
      i.cGs = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
    }
    long l2 = Math.abs(l1 - i.cGs);
    new StringBuilder("check entity: ").append(this.cGB.toString()).append(",duration:").append(l2);
    s.IB();
    if ((this.cGB.cFU < 0) || (this.cGB.cFU > 100)) {
      this.cGB.cFU = 3;
    }
    long l3 = this.cGB.cFU * e.cGm;
    new StringBuilder("duration:").append(l2).append(",maxCheckDays:").append(l3).append(",mLastCheckTime:").append(i.cGs).append(",mCheckEntity:").append(this.cGB);
    s.IB();
    JSONObject localJSONObject;
    if (l2 < l3)
    {
      if (l2 > e.cGm)
      {
        Iy();
        AppMethodBeat.o(87616);
      }
    }
    else
    {
      Iy();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("dur", l2);
      localJSONObject.put("md", l3);
      localJSONObject.put("lct", i.cGs);
      localJSONObject.put("cur", l1);
      label352:
      if (cGD <= 0L) {
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