package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.protocal.protobuf.cah;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static d maW;
  public final c maX;
  
  private d()
  {
    AppMethodBeat.i(152370);
    this.maX = new d.1(this);
    AppMethodBeat.o(152370);
  }
  
  public static boolean bsd()
  {
    AppMethodBeat.i(152372);
    cag localcag = com.tencent.mm.plugin.expt.hellhound.a.b.b.d.bst();
    if (localcag == null)
    {
      AppMethodBeat.o(152372);
      return true;
    }
    boolean bool = localcag.eht;
    AppMethodBeat.o(152372);
    return bool;
  }
  
  public static d bsf()
  {
    AppMethodBeat.i(152371);
    if (maW == null) {}
    try
    {
      if (maW == null) {
        maW = new d();
      }
      d locald = maW;
      AppMethodBeat.o(152371);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(152371);
    }
  }
  
  public static cag bsg()
  {
    AppMethodBeat.i(156440);
    cag localcag = com.tencent.mm.plugin.expt.hellhound.a.b.b.d.bst();
    AppMethodBeat.o(156440);
    return localcag;
  }
  
  private static List<cah> parse(String paramString)
  {
    AppMethodBeat.i(152373);
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
        AppMethodBeat.o(152373);
        return null;
      }
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("HellSessionUBACloudConfig", paramString, "HellSessionUBACloudConfig parse crash", new Object[0]);
      AppMethodBeat.o(152373);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < k)
    {
      Object localObject = paramString.optJSONObject(i);
      if (localObject != null)
      {
        cah localcah = new cah();
        localcah.xkf = ((JSONObject)localObject).optString("pageName");
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
                bkh localbkh = new bkh();
                localbkh.className = localJSONObject.optString("className");
                localbkh.dataPath = localJSONObject.optString("dataPath");
                localbkh.action = localJSONObject.optString("action");
                localcah.xLP.add(localbkh);
              }
              j += 1;
            }
          }
        }
        localArrayList.add(localcah);
      }
      i += 1;
    }
    AppMethodBeat.o(152373);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */