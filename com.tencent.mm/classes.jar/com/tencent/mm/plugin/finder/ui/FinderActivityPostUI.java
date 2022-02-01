package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.activity.uic.e;
import com.tencent.mm.plugin.finder.activity.uic.f;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.y;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderActivityPostUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "scrollView", "Landroid/widget/ScrollView;", "fixActionBar", "", "getLayoutId", "", "hideActionBar", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderActivityPostUI
  extends MMFinderUI
{
  public static final FinderActivityPostUI.a FOl;
  private ScrollView lDL;
  
  static
  {
    AppMethodBeat.i(346702);
    FOl = new FinderActivityPostUI.a((byte)0);
    AppMethodBeat.o(346702);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_activity_post_ui_new;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(346719);
    Set localSet = ar.setOf(new Class[] { e.class, f.class });
    AppMethodBeat.o(346719);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(346714);
    super.onCreate(paramBundle);
    paramBundle = findViewById(e.e.finder_activity_post_scroll);
    s.s(paramBundle, "findViewById(R.id.finder_activity_post_scroll)");
    this.lDL = ((ScrollView)paramBundle);
    c.h((Activity)this, false);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    paramBundle = getWindow().getDecorView();
    s.s(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    int i = bf.getStatusBarHeight((Context)this);
    Object localObject = this.lDL;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("scrollView");
      paramBundle = null;
    }
    paramBundle.setPadding(0, i, 0, 0);
    i = getResources().getColor(e.b.transparent);
    getController().setStatusBarColor(i);
    paramBundle = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramBundle = getContext();
    s.s(paramBundle, "context");
    float f = com.tencent.mm.plugin.finder.accessibility.a.g((Context)paramBundle, 17.0F);
    paramBundle = (TextView)findViewById(e.e.finder_activity_post_title);
    if (paramBundle != null)
    {
      paramBundle.setTextSize(1, f);
      localObject = com.tencent.mm.plugin.vlog.util.a.UsM;
      com.tencent.mm.plugin.vlog.util.a.iM((View)paramBundle);
    }
    paramBundle = (TextView)findViewById(e.e.finder_activity_post_cancel_btn);
    if (paramBundle != null)
    {
      paramBundle.setTextSize(1, f);
      localObject = com.tencent.mm.plugin.vlog.util.a.UsM;
      com.tencent.mm.plugin.vlog.util.a.iM((View)paramBundle);
    }
    AppMethodBeat.o(346714);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(346724);
    super.onDestroy();
    AppMethodBeat.o(346724);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderActivityPostUI
 * JD-Core Version:    0.7.0.1
 */