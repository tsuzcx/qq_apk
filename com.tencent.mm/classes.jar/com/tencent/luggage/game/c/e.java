package com.tencent.luggage.game.c;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public com.tencent.magicbrush.d bYG;
  public d bYQ;
  public volatile b bYR;
  public final Queue<String> bYS;
  public e bYT;
  public Context mContext;
  public volatile int mState;
  
  public e()
  {
    AppMethodBeat.i(130524);
    this.mState = 0;
    this.bYS = new LinkedList();
    this.bYT = new e((byte)0);
    AppMethodBeat.o(130524);
  }
  
  private void g(int paramInt, String paramString)
  {
    AppMethodBeat.i(130527);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("level", paramInt);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("wxClient: ".concat(String.valueOf(paramString)));
      localJSONObject.put("logs", localJSONArray);
      bV(localJSONObject.toString());
      AppMethodBeat.o(130527);
      return;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("MicroMsg.GameInspector", paramString, "hy: vConsole json error", new Object[0]);
      AppMethodBeat.o(130527);
    }
  }
  
  public final void a(a parama, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(130526);
    if ((parama == null) || (bs.isNullOrNil(paramString)))
    {
      ac.e("MicroMsg.GameInspector", "hy: not valid console!");
      AppMethodBeat.o(130526);
      return;
    }
    int i = j;
    switch (3.bYV[parama.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      g(i, paramString);
      AppMethodBeat.o(130526);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void bV(final String paramString)
  {
    AppMethodBeat.i(130525);
    ac.i("MicroMsg.GameInspector", "hy: on js logged : %s", new Object[] { paramString });
    synchronized (this.bYS)
    {
      if (this.mState != 1)
      {
        this.bYS.add(paramString);
        AppMethodBeat.o(130525);
        return;
      }
      if (this.bYR == null)
      {
        AppMethodBeat.o(130525);
        return;
      }
    }
    this.bYR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130517);
        if (e.this.bYR != null) {
          e.this.bYR.log(paramString);
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
      bYW = new a("DEBUG", 0);
      bYX = new a("INFO", 1);
      bYY = new a("WARNING", 2);
      bYZ = new a("ERROR", 3);
      bZa = new a[] { bYW, bYX, bYY, bYZ };
      AppMethodBeat.o(130521);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    public h bYB;
    public com.tencent.magicbrush.d bZb;
    public FrameLayout bZc;
    public boolean bZd;
    public boolean bZe;
    public e.c bZf = null;
  }
  
  public static abstract interface c
  {
    public abstract void B(List<f> paramList);
  }
  
  static final class d
    implements Runnable
  {
    private d bYQ;
    private e.e bYT;
    
    public final void run()
    {
      AppMethodBeat.i(130522);
      if (this.bYQ == null)
      {
        AppMethodBeat.o(130522);
        return;
      }
      if (this.bYT != null) {
        this.bYT.release(this);
      }
      AppMethodBeat.o(130522);
    }
  }
  
  static final class e
    extends com.tencent.luggage.game.g.b<e.d>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.c.e
 * JD-Core Version:    0.7.0.1
 */