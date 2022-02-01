package com.tencent.mm.plugin.finder.feed.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTestNumFormat;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "kotlin.jvm.PlatformType", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "editText$delegate", "Lkotlin/Lazy;", "result", "Landroid/widget/TextView;", "getResult", "()Landroid/widget/TextView;", "result$delegate", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTestNumFormat
  extends MMFinderUI
{
  private final j Bsi;
  private final j Bsj;
  
  public FinderTestNumFormat()
  {
    AppMethodBeat.i(364776);
    this.Bsi = k.cm((a)new a(this));
    this.Bsj = k.cm((a)new c(this));
    AppMethodBeat.o(364776);
  }
  
  private final MMEditText getEditText()
  {
    AppMethodBeat.i(364781);
    MMEditText localMMEditText = (MMEditText)this.Bsi.getValue();
    AppMethodBeat.o(364781);
    return localMMEditText;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_live_number_test_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364802);
    super.onCreate(paramBundle);
    getEditText().addTextChangedListener((TextWatcher)new b(this));
    AppMethodBeat.o(364802);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMEditText;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<MMEditText>
  {
    a(FinderTestNumFormat paramFinderTestNumFormat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderTestNumFormat$onCreate$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TextWatcher
  {
    b(FinderTestNumFormat paramFinderTestNumFormat) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(365069);
      long l = Util.safeParseLong(Util.nullAsNil(FinderTestNumFormat.a(this.Bsk).getText().toString()));
      FinderTestNumFormat.b(this.Bsk).setText((CharSequence)((g)h.ax(g.class)).jp(l));
      AppMethodBeat.o(365069);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<TextView>
  {
    c(FinderTestNumFormat paramFinderTestNumFormat)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTestNumFormat
 * JD-Core Version:    0.7.0.1
 */