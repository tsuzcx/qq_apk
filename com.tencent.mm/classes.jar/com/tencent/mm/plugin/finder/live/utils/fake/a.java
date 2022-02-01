package com.tencent.mm.plugin.finder.live.utils.fake;

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
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftCmd;", "", "()V", "TAG", "", "sendGift", "", "intent", "Landroid/content/Intent;", "plugin-finder_release"})
public final class a
{
  private static final String TAG = "FinderLiveGiftCmd";
  public static final a yRH;
  
  static
  {
    AppMethodBeat.i(292174);
    yRH = new a();
    TAG = "FinderLiveGiftCmd";
    AppMethodBeat.o(292174);
  }
  
  public static void ak(Intent paramIntent)
  {
    AppMethodBeat.i(292173);
    p.k(paramIntent, "intent");
    Object localObject1 = paramIntent.getStringExtra("gift_id");
    int i = i.ov(Util.safeParseInt(paramIntent.getStringExtra("count")), 1);
    long l = Util.safeParseLong(paramIntent.getStringExtra("delay"));
    boolean bool;
    String str;
    Object localObject2;
    if (Util.safeParseInt(paramIntent.getStringExtra("isSelf")) == 1)
    {
      bool = true;
      str = paramIntent.getStringExtra("comboId");
      Log.i(TAG, "gift_id " + (String)localObject1 + " count " + i + " delay: " + l + " isSelf:" + bool + " comboId:" + str);
      paramIntent = e.ySg;
      localObject2 = c.yRV;
      localObject2 = ((Map)c.dER()).entrySet().iterator();
      label155:
      if (!((Iterator)localObject2).hasNext()) {
        break label218;
      }
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!p.h(((c.b)localEntry.getValue()).yrC, localObject1)) {
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
      localObject2 = c.yRV;
      paramIntent = (c.c)c.dES().get(paramIntent);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.NL(i);
        paramIntent.ySa = l;
      }
      for (;;)
      {
        if ((bool) && (paramIntent != null)) {
          paramIntent.dET();
        }
        if ((!Util.isNullOrNil(str)) && (paramIntent != null))
        {
          p.j(str, "comboId");
          paramIntent.aCR(str);
        }
        ((LinkedList)localObject1).offerLast(paramIntent);
        paramIntent = c.yRV;
        c.ev((List)localObject1);
        AppMethodBeat.o(292173);
        return;
        paramIntent = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.fake.a
 * JD-Core Version:    0.7.0.1
 */