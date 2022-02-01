package com.tencent.mm.plugin.finder.live.model.frameset;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetDataLoader;", "", "()V", "NEED_RELOAD_MAX_INTERVAL", "", "TAG", "", "lastLoadFrameTime", "", "paramList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetLayoutParam;", "Lkotlin/collections/ArrayList;", "fakeFrameData", "filterFrameSetList", "parentId", "frameSetParamList", "loadDefaultConfig", "loadFrameSetLayoutData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a CMr;
  private static long CMs;
  private static final int CMt;
  private static ArrayList<b> CMu;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(359862);
    CMr = new a();
    TAG = "Finder.FinderLiveFrameSetDataLoader";
    CMt = 60000;
    CMu = new ArrayList();
    AppMethodBeat.o(359862);
  }
  
  public static ArrayList<b> emZ()
  {
    AppMethodBeat.i(359849);
    Log.i(TAG, "loadFrameSetLayoutData");
    long l = System.currentTimeMillis();
    int i;
    Object localObject3;
    Object localObject6;
    synchronized (CMu)
    {
      if (!((Collection)CMu).isEmpty()) {}
      for (i = 1; (i != 0) && (l - CMs <= CMt); i = 0)
      {
        Log.e(TAG, "fetch from frameSetData cache");
        localObject3 = CMu;
        AppMethodBeat.o(359849);
        return localObject3;
      }
      localObject3 = ah.aiuX;
      localObject3 = ((c)h.ax(c.class)).a(c.a.yHv, "");
      Log.i(TAG, "exptGameFrameSetData:%s", new Object[] { localObject3 });
      ??? = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        ??? = new JSONArray();
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).putOpt("id", "portrait_game_ai_interpreter");
        ((JSONObject)localObject3).putOpt("parentId", "game_player_frame_set_container");
        ((JSONObject)localObject3).putOpt("portrait", Integer.valueOf(1));
        ((JSONObject)localObject3).putOpt("bit", Integer.valueOf(0));
        ((JSONObject)localObject3).putOpt("marginRight", Integer.valueOf(12));
        ((JSONObject)localObject3).putOpt("marginBottom", Integer.valueOf(4));
        ((JSONObject)localObject3).putOpt("width", Integer.valueOf(84));
        ((JSONObject)localObject3).putOpt("height", Integer.valueOf(20));
        ((JSONObject)localObject3).putOpt("alignParentRight", Integer.valueOf(1));
        ((JSONObject)localObject3).putOpt("alignParentBottom", Integer.valueOf(1));
        localObject6 = new JSONObject();
        ((JSONObject)localObject6).putOpt("id", "landscape_game_bottom_right");
        ((JSONObject)localObject6).putOpt("parentId", "game_player_frame_set_container");
        ((JSONObject)localObject6).putOpt("landscape", Integer.valueOf(1));
        ((JSONObject)localObject6).putOpt("clearScreen", Integer.valueOf(1));
        ((JSONObject)localObject6).putOpt("bit", Integer.valueOf(3));
        ((JSONObject)localObject6).putOpt("marginRight", Integer.valueOf(24));
        ((JSONObject)localObject6).putOpt("marginBottom", Integer.valueOf(90));
        ((JSONObject)localObject6).putOpt("width", Integer.valueOf(136));
        ((JSONObject)localObject6).putOpt("height", Integer.valueOf(115));
        ((JSONObject)localObject6).putOpt("alignParentRight", Integer.valueOf(1));
        ((JSONObject)localObject6).putOpt("alignParentBottom", Integer.valueOf(1));
        ((JSONArray)???).put(localObject3);
        ((JSONArray)???).put(localObject6);
        Log.i(TAG, "loadDefaultConfig:%s", new Object[] { ((JSONArray)???).toString() });
        ??? = ((JSONArray)???).toString();
        s.s(???, "arrayJSONObject.toString()");
      }
      if (!TextUtils.isEmpty((CharSequence)???)) {
        break label533;
      }
      Log.e(TAG, "loadFrameSetLayoutData exptGameFrameSetData is empty!");
    }
    synchronized (CMu)
    {
      CMu.clear();
      localObject3 = CMu;
      AppMethodBeat.o(359849);
      return localObject3;
      localObject4 = finally;
      AppMethodBeat.o(359849);
      throw localObject4;
    }
    synchronized (CMu)
    {
      label533:
      localObject6 = b.b.CMW;
      ??? = b.b.awG((String)???);
      Log.i(TAG, "parseRetList size :%d", new Object[] { Integer.valueOf(((ArrayList)???).size()) });
      CMu.clear();
      CMu.addAll((Collection)???);
      if (!((Collection)CMu).isEmpty())
      {
        i = 1;
        if (i != 0) {
          CMs = l;
        }
        ??? = ah.aiuX;
        ??? = CMu;
        AppMethodBeat.o(359849);
        return ???;
      }
      i = 0;
    }
  }
  
  public static ArrayList<b> i(String paramString, ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(359855);
    s.u(paramString, "parentId");
    s.u(paramArrayList, "frameSetParamList");
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(359855);
      return localArrayList;
    }
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      b localb = (b)paramArrayList.next();
      if (paramString.equals(localb.parentId)) {
        localArrayList.add(localb);
      }
    }
    AppMethodBeat.o(359855);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.frameset.a
 * JD-Core Version:    0.7.0.1
 */