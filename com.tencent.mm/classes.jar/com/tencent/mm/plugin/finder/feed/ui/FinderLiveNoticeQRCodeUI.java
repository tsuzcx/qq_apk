package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.an;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.y;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveNoticeQRCodeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveNoticeQRCodeUI
  extends MMFinderUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365523);
    Set localSet = ar.setOf(an.class);
    AppMethodBeat.o(365523);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365513);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    paramBundle = getWindow().getDecorView();
    s.s(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    c.h((Activity)this, false);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    getWindow().setStatusBarColor(0);
    getController().s((Activity)this, getResources().getColor(p.b.transparent));
    paramBundle = getWindow();
    if (!aw.isDarkMode()) {}
    for (boolean bool = true;; bool = false)
    {
      aw.c(paramBundle, bool);
      AppMethodBeat.o(365513);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveNoticeQRCodeUI
 * JD-Core Version:    0.7.0.1
 */