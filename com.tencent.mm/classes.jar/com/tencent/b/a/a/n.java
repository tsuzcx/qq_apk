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
  public static long cDL = -1L;
  private a cDJ = null;
  int cDK = 0;
  private Context mContext = null;
  private int mType = 0;
  
  public n(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
  }
  
  private void Ih()
  {
    AppMethodBeat.i(87614);
    g localg1 = r.aX(this.mContext).G(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    g localg2 = r.aX(this.mContext).G(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2) })));
    g localg3 = r.aX(this.mContext).G(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    if ((s.b(localg1, localg2)) && (s.b(localg1, localg3)))
    {
      s.Ik();
      AppMethodBeat.o(87614);
      return;
    }
    localg1 = s.a(s.a(localg1, localg2), s.a(localg1, localg3));
    new StringBuilder("local mid check failed, redress with mid:").append(localg1.toString());
    s.Ik();
    r.aX(this.mContext).b(localg1);
    AppMethodBeat.o(87614);
  }
  
  private void n(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(87615);
    if (i.cDz != null)
    {
      if (j.cDF == 1)
      {
        s.Ik();
        AppMethodBeat.o(87615);
        return;
      }
      if ((j.cDG > 0) && (this.cDK > j.cDG))
      {
        new StringBuilder("limit dispatch:").append(j.cDG);
        s.Ik();
        AppMethodBeat.o(87615);
        return;
      }
      paramJSONObject = new m(this.mContext, paramJSONObject).toJSONObject().toString();
      "request data:".concat(String.valueOf(paramJSONObject));
      s.Ik();
      i.cDz.dm("[" + paramJSONObject + "]");
      cDL = System.currentTimeMillis();
      this.cDK += 1;
    }
    AppMethodBeat.o(87615);
  }
  
  public final void run()
  {
    AppMethodBeat.i(87616);
    new StringBuilder("request type:").append(this.mType);
    s.Ik();
    switch (this.mType)
    {
    default: 
      new StringBuilder("wrong type:").append(this.mType);
      s.Ik();
      AppMethodBeat.o(87616);
      return;
    case 1: 
      n(null);
      AppMethodBeat.o(87616);
      return;
    }
    if (this.cDJ == null) {
      this.cDJ = r.aX(this.mContext).Ij();
    }
    long l1 = System.currentTimeMillis();
    if (i.cDA <= 0L) {
      i.cDA = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
    }
    long l2 = Math.abs(l1 - i.cDA);
    new StringBuilder("check entity: ").append(this.cDJ.toString()).append(",duration:").append(l2);
    s.Ik();
    if ((this.cDJ.cDc < 0) || (this.cDJ.cDc > 100)) {
      this.cDJ.cDc = 3;
    }
    long l3 = this.cDJ.cDc * e.cDu;
    new StringBuilder("duration:").append(l2).append(",maxCheckDays:").append(l3).append(",mLastCheckTime:").append(i.cDA).append(",mCheckEntity:").append(this.cDJ);
    s.Ik();
    JSONObject localJSONObject;
    if (l2 < l3)
    {
      if (l2 > e.cDu)
      {
        Ih();
        AppMethodBeat.o(87616);
      }
    }
    else
    {
      Ih();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("dur", l2);
      localJSONObject.put("md", l3);
      localJSONObject.put("lct", i.cDA);
      localJSONObject.put("cur", l1);
      label352:
      if (cDL <= 0L) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.n
 * JD-Core Version:    0.7.0.1
 */