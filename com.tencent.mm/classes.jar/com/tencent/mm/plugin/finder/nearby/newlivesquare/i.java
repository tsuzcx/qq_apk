package com.tencent.mm.plugin.finder.nearby.newlivesquare;

import android.os.SystemClock;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.report.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/FinderMarkReadUtils;", "", "()V", "TAG", "", "skipReport", "", "getSkipReport", "()Z", "setSkipReport", "(Z)V", "handleFinderMarkRead", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i akhB;
  private static boolean akhC;
  
  static
  {
    AppMethodBeat.i(370475);
    akhB = new i();
    AppMethodBeat.o(370475);
  }
  
  public static void PY(boolean paramBoolean)
  {
    akhC = paramBoolean;
  }
  
  public static void R(Set<com.tencent.mm.view.recyclerview.b<a>> paramSet)
  {
    AppMethodBeat.i(370473);
    s.u(paramSet, "recordsSet");
    if (akhC)
    {
      AppMethodBeat.o(370473);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramSet).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)localIterator.next();
      if ((localb.agNK instanceof com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b))
      {
        dmk localdmk = new dmk();
        com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b localb1 = (com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.b)localb.agNK;
        localdmk.hKN = localb1.bZA();
        paramSet = ay.EDk;
        ay.a(localdmk, 94);
        localdmk.aaSu = ((int)localb.HsA);
        localdmk.aaSv = localb.afqR;
        localdmk.sessionBuffer = localb1.getSessionBuffer();
        paramSet = localb.view;
        label159:
        int i;
        if (paramSet == null)
        {
          paramSet = null;
          if (paramSet != null) {
            break label371;
          }
          i = ((Number)Integer.valueOf(0)).intValue();
          label174:
          localdmk.aaSw = i;
          paramSet = localb.view;
          if (paramSet != null) {
            break label379;
          }
          paramSet = null;
        }
        for (;;)
        {
          Object localObject = paramSet;
          if (paramSet == null) {
            localObject = Boolean.FALSE;
          }
          localdmk.aaSx = ((Boolean)localObject).booleanValue();
          localLinkedList.add(localdmk);
          Log.i("Finder.FinderMarkReadUtils", "onExposeTimeRecorded pos:" + localb.afqR + " auto_play_time_ms:" + localdmk.aaSw + " auto_play_with_sound:" + localdmk.aaSx + " exposeTime:" + localb.HsA + " nick:" + localb1.feedObject.getFeedObject().nickname);
          break;
          paramSet = paramSet.getTag(f.d.nearby_live_card_auto_play_time_tag);
          if (paramSet == null)
          {
            paramSet = null;
            break label159;
          }
          long l;
          if ((paramSet instanceof Long))
          {
            l = ((Number)paramSet).longValue();
            label340:
            if (l == 0L) {
              break label366;
            }
          }
          label366:
          for (i = (int)(SystemClock.elapsedRealtime() - l);; i = 0)
          {
            paramSet = Integer.valueOf(i);
            break;
            l = 0L;
            break label340;
          }
          label371:
          i = paramSet.intValue();
          break label174;
          label379:
          paramSet = paramSet.getTag(f.d.nearby_live_card_is_mute_tag);
          if (paramSet == null) {
            paramSet = null;
          } else {
            paramSet = Boolean.valueOf(((Boolean)paramSet).booleanValue());
          }
        }
      }
    }
    paramSet = e.EQU;
    e.F(94, (List)localLinkedList);
    paramSet = ay.EDk;
    ay.aN(localLinkedList);
    AppMethodBeat.o(370473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.i
 * JD-Core Version:    0.7.0.1
 */