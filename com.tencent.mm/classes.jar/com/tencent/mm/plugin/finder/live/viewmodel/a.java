package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameFinishUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "desc", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "succ", "", "getSucc", "()Z", "setSucc", "(Z)V", "title", "getTitle", "setTitle", "getDescTv", "Landroid/widget/TextView;", "hide", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setData", "show", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
{
  private final String TAG;
  private String desc;
  private boolean hKy;
  public View lBX;
  private String title;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356295);
    this.TAG = "Finder.FinderGameFinishUIC";
    this.hKy = true;
    this.title = "";
    this.desc = "";
    AppMethodBeat.o(356295);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(356320);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameFinishUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.getActivity().finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameFinishUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356320);
  }
  
  private final void bSZ()
  {
    AppMethodBeat.i(356314);
    WeImageView localWeImageView = (WeImageView)getRoot().findViewById(p.e.BUL);
    if (this.hKy)
    {
      localWeImageView.setImageResource(p.g.finder_live_icon);
      localWeImageView.setIconColor(getResources().getColor(p.b.finder_live_logo_color));
    }
    for (;;)
    {
      ((TextView)getRoot().findViewById(p.e.BUM)).setText((CharSequence)this.title);
      ((TextView)getRoot().findViewById(p.e.BUK)).setText((CharSequence)this.desc);
      getRoot().findViewById(p.e.finish_btn).setOnClickListener(new a..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(356314);
      return;
      localWeImageView.setImageResource(p.g.icons_filled_error);
      localWeImageView.setIconColor(getResources().getColor(p.b.finder_live_logo_color));
    }
  }
  
  private View getRoot()
  {
    AppMethodBeat.i(356306);
    View localView = this.lBX;
    if (localView != null)
    {
      AppMethodBeat.o(356306);
      return localView;
    }
    s.bIx("root");
    AppMethodBeat.o(356306);
    return null;
  }
  
  public final void e(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(356344);
    s.u(paramString1, "title");
    s.u(paramString2, "desc");
    this.hKy = paramBoolean;
    this.title = paramString1;
    this.desc = paramString2;
    AppMethodBeat.o(356344);
  }
  
  public final TextView getDescTv()
  {
    AppMethodBeat.i(356358);
    Object localObject = getRoot().findViewById(p.e.BUK);
    s.s(localObject, "root.findViewById(R.id.finish_desc_tv)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(356358);
    return localObject;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(356368);
    getRoot().setVisibility(8);
    AppMethodBeat.o(356368);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356336);
    super.onCreate(paramBundle);
    paramBundle = findViewById(p.e.BUJ);
    s.s(paramBundle, "findViewById(R.id.finish_area)");
    s.u(paramBundle, "<set-?>");
    this.lBX = paramBundle;
    AppMethodBeat.o(356336);
  }
  
  public final void show()
  {
    AppMethodBeat.i(356349);
    bSZ();
    getRoot().setVisibility(0);
    AppMethodBeat.o(356349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.a
 * JD-Core Version:    0.7.0.1
 */