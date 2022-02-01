package com.tencent.luggage.game.c;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public com.tencent.magicbrush.e ctk;
  public d ctu;
  public volatile b ctv;
  public final Queue<String> ctw;
  public e.e cty;
  public Context mContext;
  public volatile int mState;
  
  public e()
  {
    AppMethodBeat.i(130524);
    this.mState = 0;
    this.ctw = new LinkedList();
    this.cty = new e.e((byte)0);
    AppMethodBeat.o(130524);
  }
  
  private void i(int paramInt, String paramString)
  {
    AppMethodBeat.i(130527);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("level", paramInt);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("wxClient: ".concat(String.valueOf(paramString)));
      localJSONObject.put("logs", localJSONArray);
      dH(localJSONObject.toString());
      AppMethodBeat.o(130527);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.GameInspector", paramString, "hy: vConsole json error", new Object[0]);
      AppMethodBeat.o(130527);
    }
  }
  
  public final void a(a parama, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(130526);
    if ((parama == null) || (Util.isNullOrNil(paramString)))
    {
      Log.e("MicroMsg.GameInspector", "hy: not valid console!");
      AppMethodBeat.o(130526);
      return;
    }
    int i = j;
    switch (3.ctA[parama.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      i(i, paramString);
      AppMethodBeat.o(130526);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void dH(final String paramString)
  {
    AppMethodBeat.i(130525);
    Log.i("MicroMsg.GameInspector", "hy: on js logged : %s", new Object[] { paramString });
    synchronized (this.ctw)
    {
      if (this.mState != 1)
      {
        this.ctw.add(paramString);
        AppMethodBeat.o(130525);
        return;
      }
      if (this.ctv == null)
      {
        AppMethodBeat.o(130525);
        return;
      }
    }
    this.ctv.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130517);
        if (e.this.ctv != null) {
          e.this.ctv.log(paramString);
        }
        AppMethodBeat.o(130517);
      }
    });
    AppMethodBeat.o(130525);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(130521);
      ctB = new a("DEBUG", 0);
      ctC = new a("INFO", 1);
      ctD = new a("WARNING", 2);
      ctE = new a("ERROR", 3);
      ctF = new a[] { ctB, ctC, ctD, ctE };
      AppMethodBeat.o(130521);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    public com.tencent.magicbrush.e ctG;
    public FrameLayout ctH;
    public boolean ctI;
    public boolean ctJ;
    public e.c ctK = null;
    public j cte;
  }
  
  public static abstract interface c
  {
    public abstract void C(List<f> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.c.e
 * JD-Core Version:    0.7.0.1
 */