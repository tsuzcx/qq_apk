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
  public static long dfZ = -1L;
  private a dfX = null;
  int dfY = 0;
  private Context mContext = null;
  private int mType = 0;
  
  public n(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
  }
  
  private void Uc()
  {
    AppMethodBeat.i(87614);
    g localg1 = r.bs(this.mContext).M(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    g localg2 = r.bs(this.mContext).M(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2) })));
    g localg3 = r.bs(this.mContext).M(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    if ((s.b(localg1, localg2)) && (s.b(localg1, localg3)))
    {
      s.Uf();
      AppMethodBeat.o(87614);
      return;
    }
    localg1 = s.a(s.a(localg1, localg2), s.a(localg1, localg3));
    new StringBuilder("local mid check failed, redress with mid:").append(localg1.toString());
    s.Uf();
    r.bs(this.mContext).b(localg1);
    AppMethodBeat.o(87614);
  }
  
  private void r(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(87615);
    if (i.dfN != null)
    {
      if (j.dfT == 1)
      {
        s.Uf();
        AppMethodBeat.o(87615);
        return;
      }
      if ((j.dfU > 0) && (this.dfY > j.dfU))
      {
        new StringBuilder("limit dispatch:").append(j.dfU);
        s.Uf();
        AppMethodBeat.o(87615);
        return;
      }
      paramJSONObject = new m(this.mContext, paramJSONObject).toJSONObject().toString();
      "request data:".concat(String.valueOf(paramJSONObject));
      s.Uf();
      i.dfN.eW("[" + paramJSONObject + "]");
      dfZ = System.currentTimeMillis();
      this.dfY += 1;
    }
    AppMethodBeat.o(87615);
  }
  
  public final void run()
  {
    AppMethodBeat.i(87616);
    new StringBuilder("request type:").append(this.mType);
    s.Uf();
    switch (this.mType)
    {
    default: 
      new StringBuilder("wrong type:").append(this.mType);
      s.Uf();
      AppMethodBeat.o(87616);
      return;
    case 1: 
      r(null);
      AppMethodBeat.o(87616);
      return;
    }
    if (this.dfX == null) {
      this.dfX = r.bs(this.mContext).Ue();
    }
    long l1 = System.currentTimeMillis();
    if (i.dfO <= 0L) {
      i.dfO = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
    }
    long l2 = Math.abs(l1 - i.dfO);
    new StringBuilder("check entity: ").append(this.dfX.toString()).append(",duration:").append(l2);
    s.Uf();
    if ((this.dfX.dfq < 0) || (this.dfX.dfq > 100)) {
      this.dfX.dfq = 3;
    }
    long l3 = this.dfX.dfq * e.dfI;
    new StringBuilder("duration:").append(l2).append(",maxCheckDays:").append(l3).append(",mLastCheckTime:").append(i.dfO).append(",mCheckEntity:").append(this.dfX);
    s.Uf();
    JSONObject localJSONObject;
    if (l2 < l3)
    {
      if (l2 > e.dfI)
      {
        Uc();
        AppMethodBeat.o(87616);
      }
    }
    else
    {
      Uc();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("dur", l2);
      localJSONObject.put("md", l3);
      localJSONObject.put("lct", i.dfO);
      localJSONObject.put("cur", l1);
      label352:
      if (dfZ <= 0L) {
        r(localJSONObject);
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