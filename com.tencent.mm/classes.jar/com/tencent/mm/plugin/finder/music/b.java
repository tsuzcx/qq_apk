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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "playerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "Lkotlin/collections/HashMap;", "attach", "", "view", "player", "clearAll", "detach", "onDestroy", "pauseAll", "filter", "Lkotlin/Function1;", "Landroid/view/View;", "", "pauseFocusMusic", "remove", "resumeFocusMusic", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
{
  public HashMap<FinderImgFeedMusicTag, a> EEK;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(330881);
    this.EEK = new HashMap();
    AppMethodBeat.o(330881);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(330886);
    this.EEK = new HashMap();
    AppMethodBeat.o(330886);
  }
  
  public final void a(FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
  {
    AppMethodBeat.i(330907);
    s.u(paramFinderImgFeedMusicTag, "view");
    this.EEK.remove(paramFinderImgFeedMusicTag);
    AppMethodBeat.o(330907);
  }
  
  public final void a(FinderImgFeedMusicTag paramFinderImgFeedMusicTag, a parama)
  {
    AppMethodBeat.i(330901);
    s.u(paramFinderImgFeedMusicTag, "view");
    s.u(parama, "player");
    if (!this.EEK.containsKey(paramFinderImgFeedMusicTag))
    {
      ((Map)this.EEK).put(paramFinderImgFeedMusicTag, parama);
      Log.i("FinderImgFeedMusicPlayer", paramFinderImgFeedMusicTag.getId() + " attach, player size:" + this.EEK.size());
      AppMethodBeat.o(330901);
      return;
    }
    b(paramFinderImgFeedMusicTag);
    ((Map)this.EEK).put(paramFinderImgFeedMusicTag, parama);
    Log.i("FinderImgFeedMusicPlayer", paramFinderImgFeedMusicTag.getId() + " attach, already exist");
    AppMethodBeat.o(330901);
  }
  
  public final void as(kotlin.g.a.b<? super View, Boolean> paramb)
  {
    AppMethodBeat.i(330932);
    Iterator localIterator = ((Map)this.EEK).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (Boolean)paramb.invoke(((Map.Entry)localObject1).getKey());
      if (localObject2 == null) {}
      for (boolean bool = false;; bool = ((Boolean)localObject2).booleanValue())
      {
        if (bool) {
          break label151;
        }
        localObject1 = (FinderImgFeedMusicTag)((Map.Entry)localObject1).getKey();
        if ((((FinderImgFeedMusicTag)localObject1).musicInfo != null) && (((FinderImgFeedMusicTag)localObject1).EEM != null)) {
          break label153;
        }
        Log.i("FinderImgFeedMusicTag", "[pauseMusicAuto] musicInfo = " + ((FinderImgFeedMusicTag)localObject1).musicInfo + ",player = " + ((FinderImgFeedMusicTag)localObject1).EEM);
        break;
      }
      label151:
      continue;
      label153:
      localObject2 = ((FinderImgFeedMusicTag)localObject1).EEM;
      if ((localObject2 != null) && (!((a)localObject2).isPlaying())) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label194;
        }
        Log.i("FinderImgFeedMusicTag", "[pauseMusicAuto] music paused");
        break;
      }
      label194:
      ((FinderImgFeedMusicTag)localObject1).EEN = false;
      ((FinderImgFeedMusicTag)localObject1).EEO = false;
      ((FinderImgFeedMusicTag)localObject1).EEP = false;
      if (((FinderImgFeedMusicTag)localObject1).musicInfo != null)
      {
        localObject2 = ((FinderImgFeedMusicTag)localObject1).getPlayer();
        if (localObject2 != null) {
          ((a)localObject2).pause();
        }
        ((FinderImgFeedMusicTag)localObject1).eDS();
      }
    }
    AppMethodBeat.o(330932);
  }
  
  public final void b(FinderImgFeedMusicTag paramFinderImgFeedMusicTag)
  {
    AppMethodBeat.i(330914);
    s.u(paramFinderImgFeedMusicTag, "view");
    a locala = (a)this.EEK.get(paramFinderImgFeedMusicTag);
    if (locala != null) {
      locala.release();
    }
    this.EEK.remove(paramFinderImgFeedMusicTag);
    Log.i("FinderImgFeedMusicPlayer", paramFinderImgFeedMusicTag.getId() + " dettach, player size:" + this.EEK.size());
    AppMethodBeat.o(330914);
  }
  
  public final void clearAll()
  {
    AppMethodBeat.i(330941);
    Iterator localIterator = ((Map)this.EEK).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).release();
    }
    this.EEK.clear();
    AppMethodBeat.o(330941);
  }
  
  public final void eDQ()
  {
    AppMethodBeat.i(330922);
    Iterator localIterator = ((Map)this.EEK).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((FinderImgFeedMusicTag)localEntry.getKey()).EEN)
      {
        ((FinderImgFeedMusicTag)localEntry.getKey()).setShouldMusicResume(((a)localEntry.getValue()).isPlaying());
        ((FinderImgFeedMusicTag)localEntry.getKey()).bLg();
      }
    }
    AppMethodBeat.o(330922);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(330893);
    super.onDestroy();
    clearAll();
    AppMethodBeat.o(330893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.b
 * JD-Core Version:    0.7.0.1
 */