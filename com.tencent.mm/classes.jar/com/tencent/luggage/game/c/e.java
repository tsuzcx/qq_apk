package com.tencent.luggage.game.c;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public com.tencent.magicbrush.d ciY;
  public d cji;
  public volatile b cjj;
  public final Queue<String> cjk;
  public e cjl;
  public Context mContext;
  public volatile int mState;
  
  public e()
  {
    AppMethodBeat.i(130524);
    this.mState = 0;
    this.cjk = new LinkedList();
    this.cjl = new e((byte)0);
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
      cP(localJSONObject.toString());
      AppMethodBeat.o(130527);
      return;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.GameInspector", paramString, "hy: vConsole json error", new Object[0]);
      AppMethodBeat.o(130527);
    }
  }
  
  public final void a(a parama, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(130526);
    if ((parama == null) || (bt.isNullOrNil(paramString)))
    {
      ad.e("MicroMsg.GameInspector", "hy: not valid console!");
      AppMethodBeat.o(130526);
      return;
    }
    int i = j;
    switch (3.cjn[parama.ordinal()])
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
  
  public final void cP(final String paramString)
  {
    AppMethodBeat.i(130525);
    ad.i("MicroMsg.GameInspector", "hy: on js logged : %s", new Object[] { paramString });
    synchronized (this.cjk)
    {
      if (this.mState != 1)
      {
        this.cjk.add(paramString);
        AppMethodBeat.o(130525);
        return;
      }
      if (this.cjj == null)
      {
        AppMethodBeat.o(130525);
        return;
      }
    }
    this.cjj.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130517);
        if (e.this.cjj != null) {
          e.this.cjj.log(paramString);
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
      cjo = new a("DEBUG", 0);
      cjp = new a("INFO", 1);
      cjq = new a("WARNING", 2);
      cjr = new a("ERROR", 3);
      cjs = new a[] { cjo, cjp, cjq, cjr };
      AppMethodBeat.o(130521);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    public h ciT;
    public com.tencent.magicbrush.d cjt;
    public FrameLayout cju;
    public boolean cjv;
    public boolean cjw;
    public e.c cjx = null;
  }
  
  public static abstract interface c
  {
    public abstract void B(List<f> paramList);
  }
  
  static final class d
    implements Runnable
  {
    private d cji;
    private e.e cjl;
    
    public final void run()
    {
      AppMethodBeat.i(130522);
      if (this.cji == null)
      {
        AppMethodBeat.o(130522);
        return;
      }
      if (this.cjl != null) {
        this.cjl.release(this);
      }
      AppMethodBeat.o(130522);
    }
  }
  
  static final class e
    extends com.tencent.luggage.game.g.b<e.d>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.c.e
 * JD-Core Version:    0.7.0.1
 */