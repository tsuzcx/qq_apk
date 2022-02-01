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
  public com.tencent.magicbrush.e cuW;
  public d cvg;
  public volatile b cvh;
  public final Queue<String> cvi;
  public e cvj;
  public Context mContext;
  public volatile int mState;
  
  public e()
  {
    AppMethodBeat.i(130524);
    this.mState = 0;
    this.cvi = new LinkedList();
    this.cvj = new e((byte)0);
    AppMethodBeat.o(130524);
  }
  
  private void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(130527);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("level", paramInt);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("wxClient: ".concat(String.valueOf(paramString)));
      localJSONObject.put("logs", localJSONArray);
      dq(localJSONObject.toString());
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
    switch (3.cvl[parama.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      h(i, paramString);
      AppMethodBeat.o(130526);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void dq(final String paramString)
  {
    AppMethodBeat.i(130525);
    Log.i("MicroMsg.GameInspector", "hy: on js logged : %s", new Object[] { paramString });
    synchronized (this.cvi)
    {
      if (this.mState != 1)
      {
        this.cvi.add(paramString);
        AppMethodBeat.o(130525);
        return;
      }
      if (this.cvh == null)
      {
        AppMethodBeat.o(130525);
        return;
      }
    }
    this.cvh.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130517);
        if (e.this.cvh != null) {
          e.this.cvh.log(paramString);
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
      cvm = new a("DEBUG", 0);
      cvn = new a("INFO", 1);
      cvo = new a("WARNING", 2);
      cvp = new a("ERROR", 3);
      cvq = new a[] { cvm, cvn, cvo, cvp };
      AppMethodBeat.o(130521);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    public k cuQ;
    public com.tencent.magicbrush.e cvr;
    public FrameLayout cvs;
    public boolean cvt;
    public boolean cvu;
    public e.c cvv = null;
  }
  
  public static abstract interface c
  {
    public abstract void F(List<f> paramList);
  }
  
  static final class d
    implements Runnable
  {
    private d cvg;
    private e.e cvj;
    
    public final void run()
    {
      AppMethodBeat.i(130522);
      if (this.cvg == null)
      {
        AppMethodBeat.o(130522);
        return;
      }
      if (this.cvj != null) {
        this.cvj.release(this);
      }
      AppMethodBeat.o(130522);
    }
  }
  
  static final class e
    extends com.tencent.luggage.game.g.b<e.d>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.c.e
 * JD-Core Version:    0.7.0.1
 */