package com.tencent.mm.plugin.finder.music;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "playerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "Lkotlin/collections/HashMap;", "attach", "", "view", "player", "clear", "detach", "onDestroy", "pauseAll", "filter", "Lkotlin/Function1;", "Landroid/view/View;", "", "pauseFocusMusic", "resumeFocusMusic", "plugin-finder_release"})
public final class FinderImgFeedMusicPlayerManager
  extends UIComponent
{
  public HashMap<FinderImgFeedMusicTag, a> uPC;
  
  public FinderImgFeedMusicPlayerManager(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(248934);
    this.uPC = new HashMap();
    AppMethodBeat.o(248934);
  }
  
  public FinderImgFeedMusicPlayerManager(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(248933);
    this.uPC = new HashMap();
    AppMethodBeat.o(248933);
  }
  
  public final void F(b<? super View, Boolean> paramb)
  {
    AppMethodBeat.i(248931);
    Iterator localIterator = ((Map)this.uPC).entrySet().iterator();
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
        if ((((FinderImgFeedMusicTag)localObject1).musicInfo != null) && (((FinderImgFeedMusicTag)localObject1).uPD != null)) {
          break label150;
        }
        Log.i("FinderImgFeedMusicTag", "[pauseMusicAuto] musicInfo = " + ((FinderImgFeedMusicTag)localObject1).musicInfo + ",player = " + ((FinderImgFeedMusicTag)localObject1).uPD);
        break;
      }
      label148:
      continue;
      label150:
      localObject2 = ((FinderImgFeedMusicTag)localObject1).uPD;
      if ((localObject2 != null) && (!((a)localObject2).isPlaying()))
      {
        Log.i("FinderImgFeedMusicTag", "[pauseMusicAuto] music paused");
      }
      else
      {
        ((FinderImgFeedMusicTag)localObject1).uPE = false;
        ((FinderImgFeedMusicTag)localObject1).uPF = false;
        ((FinderImgFeedMusicTag)localObject1).uPG = false;
        if (((FinderImgFeedMusicTag)localObject1).musicInfo != null)
        {
          localObject2 = ((FinderImgFeedMusicTag)localObject1).uPD;
          if (localObject2 != null) {
            ((a)localObject2).pause();
          }
          ((FinderImgFeedMusicTag)localObject1).dld();
        }
      }
    }
    AppMethodBeat.o(248931);
  }
  
  public final void a(FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
  {
    AppMethodBeat.i(248930);
    p.h(paramFinderImgFeedMusicTag, "view");
    a locala = (a)this.uPC.get(paramFinderImgFeedMusicTag);
    if (locala != null) {
      locala.release();
    }
    this.uPC.remove(paramFinderImgFeedMusicTag);
    Log.i("FinderImgFeedMusicPlayer", paramFinderImgFeedMusicTag.getId() + " dettach, player size:" + this.uPC.size());
    AppMethodBeat.o(248930);
  }
  
  public final void a(FinderImgFeedMusicTag paramFinderImgFeedMusicTag, a parama)
  {
    AppMethodBeat.i(248929);
    p.h(paramFinderImgFeedMusicTag, "view");
    p.h(parama, "player");
    if (!this.uPC.containsKey(paramFinderImgFeedMusicTag))
    {
      ((Map)this.uPC).put(paramFinderImgFeedMusicTag, parama);
      Log.i("FinderImgFeedMusicPlayer", paramFinderImgFeedMusicTag.getId() + " attach, player size:" + this.uPC.size());
      AppMethodBeat.o(248929);
      return;
    }
    a(paramFinderImgFeedMusicTag);
    ((Map)this.uPC).put(paramFinderImgFeedMusicTag, parama);
    Log.i("FinderImgFeedMusicPlayer", paramFinderImgFeedMusicTag.getId() + " attach, already exist");
    AppMethodBeat.o(248929);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(248932);
    Iterator localIterator = ((Map)this.uPC).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).release();
    }
    this.uPC.clear();
    AppMethodBeat.o(248932);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(248928);
    super.onDestroy();
    clear();
    AppMethodBeat.o(248928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.FinderImgFeedMusicPlayerManager
 * JD-Core Version:    0.7.0.1
 */