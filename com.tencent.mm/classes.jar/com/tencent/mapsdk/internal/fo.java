package com.tencent.mapsdk.internal;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONException;

public final class fo
{
  public static final int a = 0;
  public static final int b = 1;
  public int c;
  public int d;
  public JSONArray e;
  public String[] f;
  
  public fo()
  {
    AppMethodBeat.i(221651);
    this.f = new String[0];
    AppMethodBeat.o(221651);
  }
  
  public fo(int paramInt1, int paramInt2, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(221660);
    this.f = new String[0];
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramJSONArray;
    if (this.e == null)
    {
      this.f = null;
      AppMethodBeat.o(221660);
      return;
    }
    paramInt2 = this.e.length();
    this.f = new String[paramInt2];
    paramInt1 = i;
    for (;;)
    {
      if (paramInt1 < paramInt2) {}
      try
      {
        this.f[paramInt1] = this.e.getString(paramInt1);
        paramInt1 += 1;
      }
      catch (JSONException paramJSONArray)
      {
        this.f = null;
        kh.c(Log.getStackTraceString(paramJSONArray));
        AppMethodBeat.o(221660);
      }
    }
    AppMethodBeat.o(221660);
    return;
  }
  
  private int c()
  {
    return this.c;
  }
  
  private int d()
  {
    return this.d;
  }
  
  private JSONArray e()
  {
    return this.e;
  }
  
  private String[] f()
  {
    return this.f;
  }
  
  public final boolean a()
  {
    return this.c == 1;
  }
  
  public final boolean b()
  {
    return this.d == 1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221713);
    Object localObject = new StringBuffer("IndoorAuth{");
    ((StringBuffer)localObject).append("mEnabled=").append(this.c);
    ((StringBuffer)localObject).append(", mType=").append(this.d);
    ((StringBuffer)localObject).append(", mBuildingJsonArray=").append(this.e);
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221713);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fo
 * JD-Core Version:    0.7.0.1
 */