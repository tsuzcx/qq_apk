package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAccountLogOutUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fansLayout", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getFansLayout", "()Landroid/widget/TextView;", "fansLayout$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
{
  private final j FdV;
  private final String TAG;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338240);
    this.TAG = "FinderAccountLogOutUIC";
    this.FdV = k.cm((kotlin.g.a.a)new a(paramAppCompatActivity));
    AppMethodBeat.o(338240);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(338251);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAccountLogOutUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.getActivity().finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderAccountLogOutUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338251);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338264);
    super.onCreate(paramBundle);
    Log.i(this.TAG, "FinderAccountLogOutUIC [onCreate]");
    ((TextView)this.FdV.getValue()).setOnClickListener(new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(338264);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<TextView>
  {
    a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.d
 * JD-Core Version:    0.7.0.1
 */