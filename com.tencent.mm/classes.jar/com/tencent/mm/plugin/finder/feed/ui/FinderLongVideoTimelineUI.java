package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.megavideo.uic.b;
import com.tencent.mm.plugin.finder.megavideo.uic.c;
import com.tencent.mm.plugin.finder.megavideo.uic.e;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.i;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "router", "", "getRouter", "()I", "setRouter", "(I)V", "getCommentScene", "getForceOrientation", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderLongVideoTimelineUI
  extends MMFinderUI
{
  public static final a Bqh;
  public int Bqi;
  
  static
  {
    AppMethodBeat.i(365753);
    Bqh = new a((byte)0);
    AppMethodBeat.o(365753);
  }
  
  public FinderLongVideoTimelineUI()
  {
    this.FVH = true;
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 4;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(365787);
    int i = a.Op(this.Bqi);
    AppMethodBeat.o(365787);
    return i;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365765);
    this.Bqi = getIntent().getIntExtra("KEY_ROUTER_UI", 0);
    Object localObject;
    switch (this.Bqi)
    {
    case 4: 
    default: 
      localObject = com.tencent.mm.plugin.finder.megavideo.uic.d.class;
    }
    for (;;)
    {
      localObject = ar.setOf(new Class[] { localObject, i.class });
      AppMethodBeat.o(365765);
      return localObject;
      localObject = com.tencent.mm.plugin.finder.megavideo.uic.d.class;
      continue;
      localObject = b.class;
      continue;
      localObject = c.class;
      continue;
      localObject = e.class;
      continue;
      localObject = com.tencent.mm.plugin.finder.megavideo.uic.d.class;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(365777);
    super.onBackPressed();
    overridePendingTransition(e.a.anim_not_change, e.a.sight_slide_bottom_out);
    AppMethodBeat.o(365777);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365773);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setSystemUiVisibility(1792);
    com.tencent.mm.ui.statusbar.d.g(getWindow());
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    setNavigationbarColor(getResources().getColor(e.b.transparent));
    AppMethodBeat.o(365773);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI$Companion;", "", "()V", "TAG", "", "getMegaVideoCommentScene", "", "router", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int Op(int paramInt)
    {
      int i = 45;
      switch (paramInt)
      {
      default: 
        i = 0;
      case 0: 
      case 5: 
        return i;
      case 1: 
        return 47;
      case 2: 
        return 46;
      case 3: 
        return 48;
      }
      return 53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI
 * JD-Core Version:    0.7.0.1
 */