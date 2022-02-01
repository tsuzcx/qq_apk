package com.tencent.mm.plugin.finder.live.utils.fake;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.aq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftCmd;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveGiftCmd;", "()V", "TAG", "", "sendGift", "", "intent", "Landroid/content/Intent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements aq
{
  public static final a DKg;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(351078);
    DKg = new a();
    TAG = "FinderLiveGiftCmd";
    AppMethodBeat.o(351078);
  }
  
  public final void ay(Intent paramIntent)
  {
    AppMethodBeat.i(351090);
    s.u(paramIntent, "intent");
    Object localObject1 = paramIntent.getStringExtra("gift_id");
    int i = k.qu(Util.safeParseInt(paramIntent.getStringExtra("count")), 1);
    long l = Util.safeParseLong(paramIntent.getStringExtra("delay"));
    boolean bool;
    String str;
    Object localObject2;
    if (Util.safeParseInt(paramIntent.getStringExtra("isSelf")) == 1)
    {
      bool = true;
      str = paramIntent.getStringExtra("comboId");
      Log.i(TAG, "gift_id " + localObject1 + " count " + i + " delay: " + l + " isSelf:" + bool + " comboId:" + str);
      paramIntent = e.DKw;
      localObject2 = c.DKj;
      localObject2 = ((Map)c.euV()).entrySet().iterator();
      label155:
      if (!((Iterator)localObject2).hasNext()) {
        break label215;
      }
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!s.p(((c.b)localEntry.getValue()).DbF, localObject1)) {
        break label334;
      }
      paramIntent = localEntry.getKey();
    }
    label334:
    for (;;)
    {
      break label155;
      bool = false;
      break;
      label215:
      localObject1 = new LinkedList();
      localObject2 = c.DKj;
      paramIntent = (c.c)c.euW().get(paramIntent);
      if (paramIntent == null) {
        paramIntent = null;
      }
      for (;;)
      {
        if ((bool) && (paramIntent != null)) {
          paramIntent.euX();
        }
        if ((!Util.isNullOrNil(str)) && (paramIntent != null))
        {
          s.checkNotNull(str);
          paramIntent.axS(str);
        }
        ((LinkedList)localObject1).offerLast(paramIntent);
        paramIntent = c.DKj;
        c.gH((List)localObject1);
        AppMethodBeat.o(351090);
        return;
        paramIntent = paramIntent.Pv(i);
        if (paramIntent == null) {
          paramIntent = null;
        } else {
          paramIntent.DKr = l;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.fake.a
 * JD-Core Version:    0.7.0.1
 */