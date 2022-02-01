package com.tencent.luggage.game.c;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public com.tencent.magicbrush.d cja;
  public d cjk;
  public volatile b cjl;
  public final Queue<String> cjm;
  public e cjn;
  public Context mContext;
  public volatile int mState;
  
  public e()
  {
    AppMethodBeat.i(130524);
    this.mState = 0;
    this.cjm = new LinkedList();
    this.cjn = new e((byte)0);
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
      cR(localJSONObject.toString());
      AppMethodBeat.o(130527);
      return;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.GameInspector", paramString, "hy: vConsole json error", new Object[0]);
      AppMethodBeat.o(130527);
    }
  }
  
  public final void a(a parama, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(130526);
    if ((parama == null) || (bu.isNullOrNil(paramString)))
    {
      ae.e("MicroMsg.GameInspector", "hy: not valid console!");
      AppMethodBeat.o(130526);
      return;
    }
    int i = j;
    switch (3.cjp[parama.ordinal()])
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
  
  public final void cR(final String paramString)
  {
    AppMethodBeat.i(130525);
    ae.i("MicroMsg.GameInspector", "hy: on js logged : %s", new Object[] { paramString });
    synchronized (this.cjm)
    {
      if (this.mState != 1)
      {
        this.cjm.add(paramString);
        AppMethodBeat.o(130525);
        return;
      }
      if (this.cjl == null)
      {
        AppMethodBeat.o(130525);
        return;
      }
    }
    this.cjl.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130517);
        if (e.this.cjl != null) {
          e.this.cjl.log(paramString);
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
      cjq = new a("DEBUG", 0);
      cjr = new a("INFO", 1);
      cjs = new a("WARNING", 2);
      cjt = new a("ERROR", 3);
      cju = new a[] { cjq, cjr, cjs, cjt };
      AppMethodBeat.o(130521);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    public h ciV;
    public com.tencent.magicbrush.d cjv;
    public FrameLayout cjw;
    public boolean cjx;
    public boolean cjy;
    public e.c cjz = null;
  }
  
  static final class d
    implements Runnable
  {
    private d cjk;
    private e.e cjn;
    
    public final void run()
    {
      AppMethodBeat.i(130522);
      if (this.cjk == null)
      {
        AppMethodBeat.o(130522);
        return;
      }
      if (this.cjn != null) {
        this.cjn.release(this);
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