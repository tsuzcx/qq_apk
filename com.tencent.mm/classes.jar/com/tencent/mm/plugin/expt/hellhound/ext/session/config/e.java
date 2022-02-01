package com.tencent.mm.plugin.expt.hellhound.ext.session.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.h;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.ezj;
import com.tencent.mm.protocal.protobuf.ezk;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  private static e zKH;
  public final IListener zKI;
  
  private e()
  {
    AppMethodBeat.i(122114);
    this.zKI = new HellSessionUBACloudConfig.1(this, f.hfK);
    AppMethodBeat.o(122114);
  }
  
  private static List<ezk> asJ(String paramString)
  {
    AppMethodBeat.i(122118);
    int k;
    try
    {
      paramString = new JSONObject(paramString);
      paramString = paramString.optJSONArray("sessionUBAConfigs");
      if (paramString != null)
      {
        k = paramString.length();
        if (k > 0) {}
      }
      else
      {
        AppMethodBeat.o(122118);
        return null;
      }
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfig", paramString, "HellSessionUBACloudConfig parse crash", new Object[0]);
      AppMethodBeat.o(122118);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < k)
    {
      Object localObject = paramString.optJSONObject(i);
      if (localObject != null)
      {
        ezk localezk = new ezk();
        localezk.hJW = ((JSONObject)localObject).optString("pageName");
        localObject = ((JSONObject)localObject).optJSONArray("businessParams");
        if (localObject != null)
        {
          int m = ((JSONArray)localObject).length();
          if (m > 0)
          {
            int j = 0;
            while (j < m)
            {
              JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(j);
              if (localJSONObject != null)
              {
                eag localeag = new eag();
                localeag.className = localJSONObject.optString("className");
                localeag.dataPath = localJSONObject.optString("dataPath");
                localeag.action = localJSONObject.optString("action");
                localezk.YVe.add(localeag);
              }
              j += 1;
            }
          }
        }
        localArrayList.add(localezk);
      }
      i += 1;
    }
    AppMethodBeat.o(122118);
    return localArrayList;
  }
  
  public static boolean dLL()
  {
    AppMethodBeat.i(122117);
    ezj localezj = h.dMh();
    if (localezj == null)
    {
      AppMethodBeat.o(122117);
      return true;
    }
    boolean bool = localezj.lKI;
    AppMethodBeat.o(122117);
    return bool;
  }
  
  public static e dLP()
  {
    AppMethodBeat.i(122115);
    if (zKH == null) {}
    try
    {
      if (zKH == null) {
        zKH = new e();
      }
      e locale = zKH;
      AppMethodBeat.o(122115);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(122115);
    }
  }
  
  public static ezj dLQ()
  {
    AppMethodBeat.i(122116);
    ezj localezj = h.dMh();
    AppMethodBeat.o(122116);
    return localezj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.config.e
 * JD-Core Version:    0.7.0.1
 */