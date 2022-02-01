package com.tencent.mm.plugin.fav.ui.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import kotlin.Metadata;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fav/ui/accessibility/NoteEditorUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MMBaseAccessibilityConfig
{
  public static final b.a AjR;
  
  static
  {
    AppMethodBeat.i(274541);
    AjR = new b.a((byte)0);
    AppMethodBeat.o(274541);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(274535);
    AppMethodBeat.o(274535);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(274549);
    int i = R.h.action_option_icon;
    view(i, i).type(ViewType.Button).desc((kotlin.g.a.b)new b(this));
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(R.i.gmF);
    localConfigHelper.view(R.h.gdG).desc(R.l.gOU);
    localConfigHelper.view(R.h.gdH).desc(R.l.gOV);
    localConfigHelper.view(R.h.gdF).desc(R.l.gOT);
    localConfigHelper.view(R.h.gdI).desc(R.l.gOX);
    localConfigHelper.view(R.h.gdJ).desc(R.l.gOW);
    localConfigHelper.view(R.h.gdS).desc(R.l.gZo);
    localConfigHelper = root(R.i.gmF);
    localConfigHelper.view(R.h.fOx).desc(R.l.gZn).type(ViewType.Button).clickAs(R.h.fOw).disableChildren();
    localConfigHelper.view(R.h.gdR).desc(R.l.gZm).type(ViewType.Button).clickAs(R.h.fJX).disableChildren();
    localConfigHelper.view(R.h.gdP).desc(R.l.gZk).type(ViewType.Button).clickAs(R.h.fHM).disableChildren();
    localConfigHelper.view(R.h.gdS).desc(R.l.gZo).type(ViewType.Button).clickAs(R.h.fJY).disableChildren();
    localConfigHelper.view(R.h.gdQ).desc(R.l.gZl).type(ViewType.Button).clickAs(R.h.fJW).disableChildren();
    localConfigHelper = root(R.i.gmG);
    localConfigHelper.view(R.h.fSk).desc(R.l.gZm).type(ViewType.Button).clickAs(R.h.fSj).disableChildren();
    localConfigHelper.view(R.h.fGx).desc(R.l.gOU).type(ViewType.Button).clickAs(R.h.fGw).disableChildren();
    localConfigHelper.view(R.h.gbO).desc(R.l.gZi).type(ViewType.Button).clickAs(R.h.video_thumb).disableChildren();
    localConfigHelper = root(R.h.voice_player);
    localConfigHelper.view(R.h.voice_player_length).desc(R.l.gXW).type(ViewType.Button);
    localConfigHelper.view(R.h.voice_player_total_length).desc((kotlin.g.a.b)c.AjT);
    localConfigHelper.view(R.h.voice_player_progress_container).desc(R.l.gXX).type(ViewType.TextView).clickAs(R.h.voice_player_progress).disableChildren();
    localConfigHelper.view(R.h.voice_player).desc(R.l.note_type_record).type(ViewType.TextView);
    AppMethodBeat.o(274549);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<View, String>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<View, String>
  {
    public static final c AjT;
    
    static
    {
      AppMethodBeat.i(274531);
      AjT = new c();
      AppMethodBeat.o(274531);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.b
 * JD-Core Version:    0.7.0.1
 */