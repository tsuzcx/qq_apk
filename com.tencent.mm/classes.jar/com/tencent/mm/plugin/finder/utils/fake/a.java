package com.tencent.mm.plugin.finder.utils.fake;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftCmd;", "", "()V", "TAG", "", "sendGift", "", "intent", "Landroid/content/Intent;", "plugin-finder_release"})
public final class a
{
  private static final String TAG = "FinderLiveGiftCmd";
  public static final a waF;
  
  static
  {
    AppMethodBeat.i(253826);
    waF = new a();
    TAG = "FinderLiveGiftCmd";
    AppMethodBeat.o(253826);
  }
  
  public static void as(Intent paramIntent)
  {
    AppMethodBeat.i(253825);
    p.h(paramIntent, "intent");
    Object localObject1 = paramIntent.getStringExtra("gift_id");
    int i = j.mZ(Util.safeParseInt(paramIntent.getStringExtra("count")), 1);
    long l = Util.safeParseLong(paramIntent.getStringExtra("delay"));
    boolean bool;
    String str;
    Object localObject2;
    if (Util.safeParseInt(paramIntent.getStringExtra("isSelf")) == 1)
    {
      bool = true;
      str = paramIntent.getStringExtra("comboId");
      Log.i(TAG, "gift_id " + (String)localObject1 + " count " + i + " delay: " + l + " isSelf:" + bool + " comboId:" + str);
      paramIntent = e.waZ;
      localObject2 = c.waP;
      localObject2 = ((Map)c.dEJ()).entrySet().iterator();
      label155:
      if (!((Iterator)localObject2).hasNext()) {
        break label218;
      }
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!p.j(((c.b)localEntry.getValue()).upZ, localObject1)) {
        break label330;
      }
      paramIntent = (e)localEntry.getKey();
    }
    label330:
    for (;;)
    {
      break label155;
      bool = false;
      break;
      label218:
      localObject1 = new LinkedList();
      localObject2 = c.waP;
      paramIntent = (c.c)c.dEK().get(paramIntent);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.Ma(i);
        paramIntent.waU = l;
      }
      for (;;)
      {
        if ((bool) && (paramIntent != null)) {
          paramIntent.dEL();
        }
        if ((!Util.isNullOrNil(str)) && (paramIntent != null))
        {
          p.g(str, "comboId");
          paramIntent.awF(str);
        }
        ((LinkedList)localObject1).offerLast(paramIntent);
        paramIntent = c.waP;
        c.eD((List)localObject1);
        AppMethodBeat.o(253825);
        return;
        paramIntent = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.fake.a
 * JD-Core Version:    0.7.0.1
 */