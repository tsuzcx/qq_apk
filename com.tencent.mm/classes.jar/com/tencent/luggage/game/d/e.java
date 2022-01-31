package com.tencent.luggage.game.d;

import android.content.Context;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private static volatile e bAD;
  public d bAB;
  public volatile b bAC;
  public final Queue<String> bAE;
  private e.c bAF;
  public Context mContext;
  public volatile int mState;
  public MBRuntime mbRuntime;
  
  private e()
  {
    AppMethodBeat.i(140404);
    this.mState = 0;
    this.bAE = new LinkedList();
    this.bAF = new e.c((byte)0);
    AppMethodBeat.o(140404);
  }
  
  private void g(int paramInt, String paramString)
  {
    AppMethodBeat.i(140407);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("level", paramInt);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("wxClient: ".concat(String.valueOf(paramString)));
      localJSONObject.put("logs", localJSONArray);
      bQ(localJSONObject.toString());
      AppMethodBeat.o(140407);
      return;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.GameInspector", paramString, "hy: vConsole json error", new Object[0]);
      AppMethodBeat.o(140407);
    }
  }
  
  public static void release()
  {
    AppMethodBeat.i(140403);
    if (bAD != null) {
      try
      {
        if (bAD != null)
        {
          e locale = bAD;
          locale.mState = 2;
          locale.bAF.bCB.clear();
          locale.mbRuntime = null;
          if (locale.bAC != null)
          {
            locale.bAC.bAm.destroy();
            locale.bAC = null;
          }
          if (locale.bAB != null)
          {
            locale.bAB.bAz.stopTimer();
            locale.bAB = null;
          }
          bAD = null;
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(140403);
      }
    }
    AppMethodBeat.o(140403);
  }
  
  public static e uJ()
  {
    AppMethodBeat.i(140402);
    if (bAD == null) {}
    try
    {
      if (bAD == null) {
        bAD = new e();
      }
      e locale = bAD;
      AppMethodBeat.o(140402);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(140402);
    }
  }
  
  public final void a(e.a parama, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(140406);
    if ((parama == null) || (bo.isNullOrNil(paramString)))
    {
      ab.e("MicroMsg.GameInspector", "hy: not valid console!");
      AppMethodBeat.o(140406);
      return;
    }
    int i = j;
    switch (e.3.bAH[parama.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      g(i, paramString);
      AppMethodBeat.o(140406);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void bQ(String paramString)
  {
    AppMethodBeat.i(140405);
    synchronized (this.bAE)
    {
      if (this.mState != 1)
      {
        this.bAE.add(paramString);
        AppMethodBeat.o(140405);
        return;
      }
      if (this.bAC == null)
      {
        AppMethodBeat.o(140405);
        return;
      }
    }
    this.bAC.post(new e.2(this, paramString));
    AppMethodBeat.o(140405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.d.e
 * JD-Core Version:    0.7.0.1
 */