package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameFinishUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "desc", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "succ", "", "getSucc", "()Z", "setSucc", "(Z)V", "title", "getTitle", "setTitle", "getDescTv", "Landroid/widget/TextView;", "hide", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setData", "show", "plugin-finder_release"})
public final class a
  extends UIComponent
{
  private final String TAG;
  private String desc;
  private boolean fFA;
  public View jac;
  private String title;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287994);
    this.TAG = "Finder.FinderGameFinishUIC";
    this.fFA = true;
    this.title = "";
    this.desc = "";
    AppMethodBeat.o(287994);
  }
  
  private final void buQ()
  {
    AppMethodBeat.i(287993);
    Object localObject = this.jac;
    if (localObject == null) {
      p.bGy("root");
    }
    localObject = (WeImageView)((View)localObject).findViewById(b.f.finish_iv);
    if (this.fFA)
    {
      ((WeImageView)localObject).setImageResource(b.i.finder_live_icon);
      ((WeImageView)localObject).setIconColor(getResources().getColor(b.c.finder_live_logo_color));
    }
    for (;;)
    {
      localObject = this.jac;
      if (localObject == null) {
        p.bGy("root");
      }
      localObject = (TextView)((View)localObject).findViewById(b.f.finish_title_tv);
      p.j(localObject, "titleTv");
      ((TextView)localObject).setText((CharSequence)this.title);
      localObject = this.jac;
      if (localObject == null) {
        p.bGy("root");
      }
      localObject = (TextView)((View)localObject).findViewById(b.f.finish_desc_tv);
      p.j(localObject, "descTv");
      ((TextView)localObject).setText((CharSequence)this.desc);
      localObject = this.jac;
      if (localObject == null) {
        p.bGy("root");
      }
      ((View)localObject).findViewById(b.f.finish_btn).setOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(287993);
      return;
      ((WeImageView)localObject).setImageResource(b.i.icons_filled_error);
      ((WeImageView)localObject).setIconColor(getResources().getColor(b.c.finder_live_logo_color));
    }
  }
  
  public final void f(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(287989);
    p.k(paramString1, "title");
    p.k(paramString2, "desc");
    this.fFA = paramBoolean;
    this.title = paramString1;
    this.desc = paramString2;
    AppMethodBeat.o(287989);
  }
  
  public final TextView getDescTv()
  {
    AppMethodBeat.i(287991);
    Object localObject = this.jac;
    if (localObject == null) {
      p.bGy("root");
    }
    localObject = ((View)localObject).findViewById(b.f.finish_desc_tv);
    p.j(localObject, "root.findViewById(R.id.finish_desc_tv)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(287991);
    return localObject;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(287992);
    View localView = this.jac;
    if (localView == null) {
      p.bGy("root");
    }
    localView.setVisibility(8);
    AppMethodBeat.o(287992);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287988);
    super.onCreate(paramBundle);
    paramBundle = findViewById(b.f.finish_area);
    p.j(paramBundle, "findViewById(R.id.finish_area)");
    this.jac = paramBundle;
    AppMethodBeat.o(287988);
  }
  
  public final void show()
  {
    AppMethodBeat.i(287990);
    buQ();
    View localView = this.jac;
    if (localView == null) {
      p.bGy("root");
    }
    localView.setVisibility(0);
    AppMethodBeat.o(287990);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(280353);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameFinishUIC$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zbf.getActivity().finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameFinishUIC$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280353);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.a
 * JD-Core Version:    0.7.0.1
 */