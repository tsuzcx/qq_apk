package com.tencent.luggage.game.c;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
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
  public com.tencent.magicbrush.e elf;
  public d elp;
  public volatile b elq;
  public final Queue<String> elr;
  public e els;
  public Context mContext;
  public volatile int mState;
  
  public e()
  {
    AppMethodBeat.i(130524);
    this.mState = 0;
    this.elr = new LinkedList();
    this.els = new e((byte)0);
    AppMethodBeat.o(130524);
  }
  
  private void j(int paramInt, String paramString)
  {
    AppMethodBeat.i(130527);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("level", paramInt);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("wxClient: ".concat(String.valueOf(paramString)));
      localJSONObject.put("logs", localJSONArray);
      eS(localJSONObject.toString());
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
    switch (3.elu[parama.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      j(i, paramString);
      AppMethodBeat.o(130526);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void eS(final String paramString)
  {
    AppMethodBeat.i(130525);
    Log.i("MicroMsg.GameInspector", "hy: on js logged : %s", new Object[] { paramString });
    synchronized (this.elr)
    {
      if (this.mState != 1)
      {
        this.elr.add(paramString);
        AppMethodBeat.o(130525);
        return;
      }
      if (this.elq == null)
      {
        AppMethodBeat.o(130525);
        return;
      }
    }
    this.elq.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130517);
        if (e.this.elq != null) {
          e.this.elq.log(paramString);
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
      elv = new a("DEBUG", 0);
      elw = new a("INFO", 1);
      elx = new a("WARNING", 2);
      ely = new a("ERROR", 3);
      elz = new a[] { elv, elw, elx, ely };
      AppMethodBeat.o(130521);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    public k ekZ;
    public com.tencent.magicbrush.e elA;
    public FrameLayout elB;
    public boolean elC;
    public boolean elD;
    public e.c elE = null;
  }
  
  public static abstract interface c
  {
    public abstract void ba(List<f> paramList);
  }
  
  static final class d
    implements Runnable
  {
    private d elp;
    private e.e els;
    
    public final void run()
    {
      AppMethodBeat.i(130522);
      if (this.elp == null)
      {
        AppMethodBeat.o(130522);
        return;
      }
      if (this.els != null) {
        this.els.release(this);
      }
      AppMethodBeat.o(130522);
    }
  }
  
  static final class e
    extends com.tencent.luggage.game.g.b<e.d>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.c.e
 * JD-Core Version:    0.7.0.1
 */