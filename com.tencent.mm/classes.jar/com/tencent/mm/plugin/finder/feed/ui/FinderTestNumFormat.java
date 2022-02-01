package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTestNumFormat;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "kotlin.jvm.PlatformType", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "editText$delegate", "Lkotlin/Lazy;", "result", "Landroid/widget/TextView;", "getResult", "()Landroid/widget/TextView;", "result$delegate", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderTestNumFormat
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  private final f xSD;
  private final f xSF;
  
  public FinderTestNumFormat()
  {
    AppMethodBeat.i(275891);
    this.xSD = g.ar((kotlin.g.a.a)new b(this));
    this.xSF = g.ar((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(275891);
  }
  
  private final MMEditText getEditText()
  {
    AppMethodBeat.i(293315);
    MMEditText localMMEditText = (MMEditText)this.xSD.getValue();
    AppMethodBeat.o(293315);
    return localMMEditText;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(275898);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(275898);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(275896);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(275896);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_number_test_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(275889);
    super.onCreate(paramBundle);
    getEditText().addTextChangedListener((TextWatcher)new c(this));
    AppMethodBeat.o(275889);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMEditText;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<MMEditText>
  {
    b(FinderTestNumFormat paramFinderTestNumFormat)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderTestNumFormat$onCreate$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-finder_release"})
  public static final class c
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(293182);
      paramEditable = FinderTestNumFormat.a(this.xSG);
      p.j(paramEditable, "editText");
      long l = Util.safeParseLong(Util.nullAsNil(paramEditable.getText().toString()));
      paramEditable = FinderTestNumFormat.b(this.xSG);
      p.j(paramEditable, "result");
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      paramEditable.setText((CharSequence)com.tencent.mm.plugin.finder.live.utils.a.XU(l));
      AppMethodBeat.o(293182);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<TextView>
  {
    d(FinderTestNumFormat paramFinderTestNumFormat)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTestNumFormat
 * JD-Core Version:    0.7.0.1
 */