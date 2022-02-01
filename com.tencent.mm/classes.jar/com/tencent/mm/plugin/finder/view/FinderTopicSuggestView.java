package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.protocal.protobuf.aru;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "listLayout", "listScrollView", "Landroid/widget/ScrollView;", "onItemSelected", "Lkotlin/Function1;", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function1;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function1;)V", "initView", "refresh", "suggestions", "", "Lcom/tencent/mm/protocal/protobuf/FinderSuggestion;", "plugin-finder_release"})
public final class FinderTopicSuggestView
  extends LinearLayout
{
  private final String TAG;
  public ScrollView sWg;
  public LinearLayout sWh;
  private d.g.a.b<? super String, z> sWi;
  
  public FinderTopicSuggestView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168423);
    this.TAG = "Finder.FinderTopicSuggestView";
    initView();
    AppMethodBeat.o(168423);
  }
  
  public FinderTopicSuggestView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168424);
    this.TAG = "Finder.FinderTopicSuggestView";
    initView();
    AppMethodBeat.o(168424);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(168422);
    setOrientation(1);
    LayoutInflater.from(getContext()).inflate(2131494120, (ViewGroup)this, true);
    View localView = findViewById(2131306034);
    p.g(localView, "findViewById(R.id.topic_suggest_item_scrollview)");
    this.sWg = ((ScrollView)localView);
    localView = findViewById(2131306035);
    p.g(localView, "findViewById(R.id.topic_suggest_list)");
    this.sWh = ((LinearLayout)localView);
    AppMethodBeat.o(168422);
  }
  
  public final d.g.a.b<String, z> getOnItemSelected()
  {
    return this.sWi;
  }
  
  public final void setOnItemSelected(d.g.a.b<? super String, z> paramb)
  {
    this.sWi = paramb;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class a
    implements View.OnClickListener
  {
    public a(FinderTopicSuggestView paramFinderTopicSuggestView, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168421);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      a.b("com/tencent/mm/plugin/finder/view/FinderTopicSuggestView$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = this.sWj.getOnItemSelected();
      if (paramView != null)
      {
        localObject = this.sWk;
        p.g(localObject, "suggestItemView");
        localObject = ((View)localObject).getTag();
        if (localObject == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSuggestion");
          AppMethodBeat.o(168421);
          throw paramView;
        }
        localObject = ((aru)localObject).Gqe;
        p.g(localObject, "(suggestItemView.tag as FinderSuggestion).suggest");
        paramView.invoke(localObject);
      }
      this.sWj.setVisibility(8);
      a.a(this, "com/tencent/mm/plugin/finder/view/FinderTopicSuggestView$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168421);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTopicSuggestView
 * JD-Core Version:    0.7.0.1
 */