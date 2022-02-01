package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.utils.f;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveCreateAccountUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "hide", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "show", "plugin-finder_release"})
public final class c
  extends UIComponent
{
  private final String TAG;
  public View jac;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(280072);
    this.TAG = "Finder.FinderGameLiveCreateAccountUIC";
    AppMethodBeat.o(280072);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(280071);
    View localView = this.jac;
    if (localView == null) {
      p.bGy("root");
    }
    localView.setVisibility(8);
    AppMethodBeat.o(280071);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(280069);
    super.onCreate(paramBundle);
    paramBundle = findViewById(b.f.game_live_create_account_area);
    p.j(paramBundle, "findViewById(R.id.game_live_create_account_area)");
    this.jac = paramBundle;
    paramBundle = findViewById(b.f.game_auth_top_close);
    paramBundle.post((Runnable)new a(paramBundle));
    paramBundle.setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = findViewById(b.f.create_title_tv);
    p.j(paramBundle, "findViewById<TextView>(R.id.create_title_tv)");
    f.i((TextView)paramBundle);
    findViewById(b.f.create_account).setOnClickListener((View.OnClickListener)new c(this));
    AppMethodBeat.o(280069);
  }
  
  public final void show()
  {
    AppMethodBeat.i(280070);
    Object localObject = o.ADA;
    if (o.ecW() == 19L)
    {
      localObject = this.jac;
      if (localObject == null) {
        p.bGy("root");
      }
      if (((View)localObject).getVisibility() == 8)
      {
        localObject = o.ADA;
        o.QJ(3);
      }
    }
    localObject = this.jac;
    if (localObject == null) {
      p.bGy("root");
    }
    ((View)localObject).setVisibility(0);
    AppMethodBeat.o(280070);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(284437);
      Object localObject1 = new Rect();
      this.xOk.getHitRect((Rect)localObject1);
      ((Rect)localObject1).inset(((Rect)localObject1).width() * -2, -((Rect)localObject1).width());
      Object localObject2 = this.xOk;
      p.j(localObject2, "topBack");
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(284437);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, this.xOk));
      AppMethodBeat.o(284437);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(286916);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveCreateAccountUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zbl.getActivity().finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveCreateAccountUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286916);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(265856);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveCreateAccountUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = o.ADA;
      if (o.ecW() == 19L)
      {
        paramView = o.ADA;
        o.QJ(4);
      }
      paramView = new Intent();
      paramView.putExtra("key_create_scene", 4);
      paramView.putExtra("scene", 2);
      paramView.putExtra("key_router_to_profile", false);
      localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.w((Context)this.zbl.getActivity(), paramView);
      h.IzE.a(20694, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveCreateAccountUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265856);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.c
 * JD-Core Version:    0.7.0.1
 */