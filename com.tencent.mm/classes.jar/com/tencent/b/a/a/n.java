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
  public static long cOQ = -1L;
  private a cOO = null;
  int cOP = 0;
  private Context mContext = null;
  private int mType = 0;
  
  public n(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
  }
  
  private void JH()
  {
    AppMethodBeat.i(87614);
    g localg1 = r.aX(this.mContext).G(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1) })));
    g localg2 = r.aX(this.mContext).G(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2) })));
    g localg3 = r.aX(this.mContext).G(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(4) })));
    if ((s.b(localg1, localg2)) && (s.b(localg1, localg3)))
    {
      s.JK();
      AppMethodBeat.o(87614);
      return;
    }
    localg1 = s.a(s.a(localg1, localg2), s.a(localg1, localg3));
    new StringBuilder("local mid check failed, redress with mid:").append(localg1.toString());
    s.JK();
    r.aX(this.mContext).b(localg1);
    AppMethodBeat.o(87614);
  }
  
  private void n(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(87615);
    if (i.cOE != null)
    {
      if (j.cOK == 1)
      {
        s.JK();
        AppMethodBeat.o(87615);
        return;
      }
      if ((j.cOL > 0) && (this.cOP > j.cOL))
      {
        new StringBuilder("limit dispatch:").append(j.cOL);
        s.JK();
        AppMethodBeat.o(87615);
        return;
      }
      paramJSONObject = new m(this.mContext, paramJSONObject).toJSONObject().toString();
      "request data:".concat(String.valueOf(paramJSONObject));
      s.JK();
      i.cOE.ei("[" + paramJSONObject + "]");
      cOQ = System.currentTimeMillis();
      this.cOP += 1;
    }
    AppMethodBeat.o(87615);
  }
  
  public final void run()
  {
    AppMethodBeat.i(87616);
    new StringBuilder("request type:").append(this.mType);
    s.JK();
    switch (this.mType)
    {
    default: 
      new StringBuilder("wrong type:").append(this.mType);
      s.JK();
      AppMethodBeat.o(87616);
      return;
    case 1: 
      n(null);
      AppMethodBeat.o(87616);
      return;
    }
    if (this.cOO == null) {
      this.cOO = r.aX(this.mContext).JJ();
    }
    long l1 = System.currentTimeMillis();
    if (i.cOF <= 0L) {
      i.cOF = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
    }
    long l2 = Math.abs(l1 - i.cOF);
    new StringBuilder("check entity: ").append(this.cOO.toString()).append(",duration:").append(l2);
    s.JK();
    if ((this.cOO.cOh < 0) || (this.cOO.cOh > 100)) {
      this.cOO.cOh = 3;
    }
    long l3 = this.cOO.cOh * e.cOz;
    new StringBuilder("duration:").append(l2).append(",maxCheckDays:").append(l3).append(",mLastCheckTime:").append(i.cOF).append(",mCheckEntity:").append(this.cOO);
    s.JK();
    JSONObject localJSONObject;
    if (l2 < l3)
    {
      if (l2 > e.cOz)
      {
        JH();
        AppMethodBeat.o(87616);
      }
    }
    else
    {
      JH();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("dur", l2);
      localJSONObject.put("md", l3);
      localJSONObject.put("lct", i.cOF);
      localJSONObject.put("cur", l1);
      label352:
      if (cOQ <= 0L) {
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