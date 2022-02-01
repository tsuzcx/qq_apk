package com.tencent.mm.plugin.finder.music;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "playerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "Lkotlin/collections/HashMap;", "attach", "", "view", "player", "clear", "detach", "onDestroy", "pauseAll", "filter", "Lkotlin/Function1;", "Landroid/view/View;", "", "pauseFocusMusic", "resumeFocusMusic", "plugin-finder_release"})
public final class b
  extends UIComponent
{
  public HashMap<FinderImgFeedMusicTag, a> zBX;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(244370);
    this.zBX = new HashMap();
    AppMethodBeat.o(244370);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(244372);
    this.zBX = new HashMap();
    AppMethodBeat.o(244372);
  }
  
  public final void M(kotlin.g.a.b<? super View, Boolean> paramb)
  {
    AppMethodBeat.i(244368);
    Iterator localIterator = ((Map)this.zBX).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (Boolean)paramb.invoke(((Map.Entry)localObject1).getKey());
      if (localObject2 != null) {}
      for (boolean bool = ((Boolean)localObject2).booleanValue();; bool = false)
      {
        if (bool) {
          break label148;
        }
        localObject1 = (FinderImgFeedMusicTag)((Map.Entry)localObject1).getKey();
        if ((((FinderImgFeedMusicTag)localObject1).musicInfo != null) && (((FinderImgFeedMusicTag)localObject1).zBY != null)) {
          break label150;
        }
        Log.i("FinderImgFeedMusicTag", "[pauseMusicAuto] musicInfo = " + ((FinderImgFeedMusicTag)localObject1).musicInfo + ",player = " + ((FinderImgFeedMusicTag)localObject1).zBY);
        break;
      }
      label148:
      continue;
      label150:
      localObject2 = ((FinderImgFeedMusicTag)localObject1).zBY;
      if ((localObject2 != null) && (!((a)localObject2).isPlaying()))
      {
        Log.i("FinderImgFeedMusicTag", "[pauseMusicAuto] music paused");
      }
      else
      {
        ((FinderImgFeedMusicTag)localObject1).zBZ = false;
        ((FinderImgFeedMusicTag)localObject1).zCa = false;
        ((FinderImgFeedMusicTag)localObject1).zCb = false;
        if (((FinderImgFeedMusicTag)localObject1).musicInfo != null)
        {
          localObject2 = ((FinderImgFeedMusicTag)localObject1).zBY;
          if (localObject2 != null) {
            ((a)localObject2).pause();
          }
          ((FinderImgFeedMusicTag)localObject1).dLd();
        }
      }
    }
    AppMethodBeat.o(244368);
  }
  
  public final void a(FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
  {
    AppMethodBeat.i(244367);
    p.k(paramFinderImgFeedMusicTag, "view");
    a locala = (a)this.zBX.get(paramFinderImgFeedMusicTag);
    if (locala != null) {
      locala.release();
    }
    this.zBX.remove(paramFinderImgFeedMusicTag);
    Log.i("FinderImgFeedMusicPlayer", paramFinderImgFeedMusicTag.getId() + " dettach, player size:" + this.zBX.size());
    AppMethodBeat.o(244367);
  }
  
  public final void a(FinderImgFeedMusicTag paramFinderImgFeedMusicTag, a parama)
  {
    AppMethodBeat.i(244366);
    p.k(paramFinderImgFeedMusicTag, "view");
    p.k(parama, "player");
    if (!this.zBX.containsKey(paramFinderImgFeedMusicTag))
    {
      ((Map)this.zBX).put(paramFinderImgFeedMusicTag, parama);
      Log.i("FinderImgFeedMusicPlayer", paramFinderImgFeedMusicTag.getId() + " attach, player size:" + this.zBX.size());
      AppMethodBeat.o(244366);
      return;
    }
    a(paramFinderImgFeedMusicTag);
    ((Map)this.zBX).put(paramFinderImgFeedMusicTag, parama);
    Log.i("FinderImgFeedMusicPlayer", paramFinderImgFeedMusicTag.getId() + " attach, already exist");
    AppMethodBeat.o(244366);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(244369);
    Iterator localIterator = ((Map)this.zBX).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).release();
    }
    this.zBX.clear();
    AppMethodBeat.o(244369);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(244364);
    super.onDestroy();
    clear();
    AppMethodBeat.o(244364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.b
 * JD-Core Version:    0.7.0.1
 */