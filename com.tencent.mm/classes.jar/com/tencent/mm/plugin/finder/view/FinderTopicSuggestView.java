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
import com.tencent.mm.protocal.protobuf.alk;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.v;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "listLayout", "listScrollView", "Landroid/widget/ScrollView;", "onItemSelected", "Lkotlin/Function1;", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function1;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function1;)V", "initView", "refresh", "suggestions", "", "Lcom/tencent/mm/protocal/protobuf/FinderSuggestion;", "plugin-finder_release"})
public final class FinderTopicSuggestView
  extends LinearLayout
{
  private final String TAG;
  public ScrollView qXX;
  public LinearLayout qXY;
  private b<? super String, y> qXZ;
  
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
    k.g(localView, "findViewById(R.id.topic_suggest_item_scrollview)");
    this.qXX = ((ScrollView)localView);
    localView = findViewById(2131306035);
    k.g(localView, "findViewById(R.id.topic_suggest_list)");
    this.qXY = ((LinearLayout)localView);
    AppMethodBeat.o(168422);
  }
  
  public final b<String, y> getOnItemSelected()
  {
    return this.qXZ;
  }
  
  public final void setOnItemSelected(b<? super String, y> paramb)
  {
    this.qXZ = paramb;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class a
    implements View.OnClickListener
  {
    public a(FinderTopicSuggestView paramFinderTopicSuggestView, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168421);
      paramView = this.qYa.getOnItemSelected();
      if (paramView != null)
      {
        Object localObject = this.qYb;
        k.g(localObject, "suggestItemView");
        localObject = ((View)localObject).getTag();
        if (localObject == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSuggestion");
          AppMethodBeat.o(168421);
          throw paramView;
        }
        localObject = ((alk)localObject).DmF;
        k.g(localObject, "(suggestItemView.tag as FinderSuggestion).suggest");
        paramView.aA(localObject);
      }
      this.qYa.setVisibility(8);
      AppMethodBeat.o(168421);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTopicSuggestView
 * JD-Core Version:    0.7.0.1
 */