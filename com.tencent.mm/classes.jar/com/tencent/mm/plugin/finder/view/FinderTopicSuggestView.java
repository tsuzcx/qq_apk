package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "listLayout", "listScrollView", "Landroid/widget/ScrollView;", "onItemSelected", "Lkotlin/Function1;", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function1;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function1;)V", "initView", "refresh", "suggestions", "", "Lcom/tencent/mm/protocal/protobuf/FinderSuggestion;", "plugin-finder_release"})
public final class FinderTopicSuggestView
  extends LinearLayout
{
  private final String TAG;
  private ScrollView wpG;
  private LinearLayout wpH;
  private b<? super String, x> wpI;
  
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
    LayoutInflater.from(getContext()).inflate(2131494661, (ViewGroup)this, true);
    View localView = findViewById(2131309354);
    p.g(localView, "findViewById(R.id.topic_suggest_item_scrollview)");
    this.wpG = ((ScrollView)localView);
    localView = findViewById(2131309355);
    p.g(localView, "findViewById(R.id.topic_suggest_list)");
    this.wpH = ((LinearLayout)localView);
    AppMethodBeat.o(168422);
  }
  
  public final b<String, x> getOnItemSelected()
  {
    return this.wpI;
  }
  
  public final void setOnItemSelected(b<? super String, x> paramb)
  {
    this.wpI = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTopicSuggestView
 * JD-Core Version:    0.7.0.1
 */