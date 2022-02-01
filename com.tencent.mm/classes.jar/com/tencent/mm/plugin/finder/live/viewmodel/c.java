package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.f;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveCreateAccountUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "hide", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "show", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  private final String TAG;
  public View lBX;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356173);
    this.TAG = "Finder.FinderGameLiveCreateAccountUIC";
    AppMethodBeat.o(356173);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(356200);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveCreateAccountUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramc.getActivity().finish();
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveCreateAccountUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356200);
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(356210);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveCreateAccountUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.s.GgL;
    if (com.tencent.mm.plugin.finder.utils.s.feR() == 19L)
    {
      paramView = com.tencent.mm.plugin.finder.utils.s.GgL;
      com.tencent.mm.plugin.finder.utils.s.TU(4);
    }
    paramView = new Intent();
    paramView.putExtra("key_create_scene", 4);
    paramView.putExtra("scene", 2);
    paramView.putExtra("key_router_to_profile", false);
    ((f)com.tencent.mm.kernel.h.ax(f.class)).x((Context)paramc.getActivity(), paramView);
    com.tencent.mm.plugin.report.service.h.OAn.b(20694, new Object[] { Integer.valueOf(1) });
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveCreateAccountUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356210);
  }
  
  private View getRoot()
  {
    AppMethodBeat.i(356179);
    View localView = this.lBX;
    if (localView != null)
    {
      AppMethodBeat.o(356179);
      return localView;
    }
    kotlin.g.b.s.bIx("root");
    AppMethodBeat.o(356179);
    return null;
  }
  
  private static final void gk(View paramView)
  {
    AppMethodBeat.i(356189);
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    localRect.inset(localRect.width() * -2, -localRect.width());
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(356189);
      throw paramView;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, paramView));
    AppMethodBeat.o(356189);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(356271);
    getRoot().setVisibility(8);
    AppMethodBeat.o(356271);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356248);
    super.onCreate(paramBundle);
    paramBundle = findViewById(p.e.BUX);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.game_live_create_account_area)");
    kotlin.g.b.s.u(paramBundle, "<set-?>");
    this.lBX = paramBundle;
    paramBundle = findViewById(p.e.BUQ);
    paramBundle.post(new c..ExternalSyntheticLambda2(paramBundle));
    paramBundle.setOnClickListener(new c..ExternalSyntheticLambda1(this));
    paramBundle = findViewById(p.e.BCA);
    kotlin.g.b.s.s(paramBundle, "findViewById<TextView>(R.id.create_title_tv)");
    i.setTextBold((TextView)paramBundle);
    findViewById(p.e.create_account).setOnClickListener(new c..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(356248);
  }
  
  public final void show()
  {
    AppMethodBeat.i(356261);
    com.tencent.mm.plugin.finder.utils.s locals = com.tencent.mm.plugin.finder.utils.s.GgL;
    if ((com.tencent.mm.plugin.finder.utils.s.feR() == 19L) && (getRoot().getVisibility() == 8))
    {
      locals = com.tencent.mm.plugin.finder.utils.s.GgL;
      com.tencent.mm.plugin.finder.utils.s.TU(3);
    }
    getRoot().setVisibility(0);
    AppMethodBeat.o(356261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.c
 * JD-Core Version:    0.7.0.1
 */