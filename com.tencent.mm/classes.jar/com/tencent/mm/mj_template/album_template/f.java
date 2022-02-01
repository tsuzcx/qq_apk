package com.tencent.mm.mj_template.album_template;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.plugin.c.h;
import com.tencent.mm.ui.base.x;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/MaasProgressDialog;", "Lcom/tencent/mm/ui/base/MMSafeProgressDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getContentView", "()Landroid/view/View;", "contentView$delegate", "Lkotlin/Lazy;", "msgView", "Landroid/widget/TextView;", "getMsgView", "()Landroid/widget/TextView;", "msgView$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setMessage", "msg", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends x
{
  public static final int Ue = 8;
  private final j nWC;
  private final j nWD;
  
  public f(Context paramContext)
  {
    super(paramContext, c.h.mmalertdialog);
    AppMethodBeat.i(240412);
    this.nWC = k.cm((a)new a(this));
    this.nWD = k.cm((a)new b(this));
    AppMethodBeat.o(240412);
  }
  
  private final TextView bwS()
  {
    AppMethodBeat.i(240424);
    TextView localTextView = (TextView)this.nWD.getValue();
    AppMethodBeat.o(240424);
    return localTextView;
  }
  
  private final View getContentView()
  {
    AppMethodBeat.i(240417);
    View localView = (View)this.nWC.getValue();
    AppMethodBeat.o(240417);
    return localView;
  }
  
  public final void Hy(String paramString)
  {
    AppMethodBeat.i(240442);
    s.u(paramString, "msg");
    bwS().setText((CharSequence)paramString);
    AppMethodBeat.o(240442);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(240438);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setLayout(-1, -2);
    }
    setContentView(getContentView(), new ViewGroup.LayoutParams(-1, -1));
    setCancelable(false);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(240438);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<View>
  {
    a(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<TextView>
  {
    b(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.f
 * JD-Core Version:    0.7.0.1
 */