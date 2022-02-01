package com.tencent.mm.plugin.appbrand.game.e.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.game.g.b.d;
import com.tencent.mm.plugin.appbrand.game.g.d;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends b
{
  public static final int CTRL_INDEX = 669;
  public static final String NAME = "editGameRecorderVideo";
  
  static ArrayList<GameShareOption> a(y paramy, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(45139);
    ArrayList localArrayList = new ArrayList(1);
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0))
    {
      localArrayList.add(new GameShareOption(0, paramy.getContext().getString(ba.i.appbrand_game_screen_recording_share_to_friends), false));
      AppMethodBeat.o(45139);
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONArray.length()) {
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        localArrayList.add(new GameShareOption(localJSONObject.getInt("id"), localJSONObject.getString("name"), localJSONObject.optBoolean("needExtUrl", false)));
        i += 1;
      }
      catch (JSONException paramJSONArray)
      {
        Log.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderEdit", paramJSONArray, "hy: json exception!", new Object[0]);
        localArrayList.clear();
        localArrayList.add(new GameShareOption(0, paramy.getContext().getString(ba.i.appbrand_game_screen_recording_share_to_friends), false));
        AppMethodBeat.o(45139);
        return localArrayList;
      }
    }
    AppMethodBeat.o(45139);
    return localArrayList;
  }
  
  protected void a(com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt, b.a parama, String paramString, ArrayList<GameShareOption> paramArrayList, b.d paramd)
  {
    AppMethodBeat.i(45140);
    parama = parama.rri;
    if (Util.isNullOrNil(parama))
    {
      a(paramc, paramInt, 1, 802, "clipped file lost");
      AppMethodBeat.o(45140);
      return;
    }
    paramString = new HashMap(2);
    paramString.put("errCode", Integer.valueOf(0));
    paramString.put("videoPath", parama);
    paramc.callback(paramInt, m("ok", paramString));
    AppMethodBeat.o(45140);
  }
  
  protected final void a(y paramy, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(45141);
    Log.w("MicroMsg.WAGameJsApiScreenRecorderEdit", "hy: fail errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("errCode", Integer.valueOf(paramInt3));
    paramy.callback(paramInt1, m(String.format("fail: errType: %d, errCode: %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }), localHashMap));
    AppMethodBeat.o(45141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.c
 * JD-Core Version:    0.7.0.1
 */