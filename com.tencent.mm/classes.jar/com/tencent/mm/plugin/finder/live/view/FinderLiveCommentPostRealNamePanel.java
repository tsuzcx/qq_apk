package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.b.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "check", "", "checkBox", "Landroid/widget/CheckBox;", "licenseContent", "Landroid/widget/TextView;", "realNameCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "verifyUrl", "", "webviewForwardCallback", "Lkotlin/Function3;", "Landroid/content/Intent;", "intent", "requestCode", "init", "onActivityResult", "resultCode", "data", "setDialogHeight", "height", "", "setWebviewForwardCallback", "callback", "showDialog", "Companion", "plugin-finder_release"})
public final class FinderLiveCommentPostRealNamePanel
  extends LinearLayout
{
  public static final a yTH;
  private CheckBox checkBox;
  public String kwF;
  private boolean msB;
  private q<? super Context, ? super Intent, ? super Integer, x> yTD;
  public kotlin.g.a.b<? super Boolean, x> yTE;
  private TextView yTF;
  public g yTG;
  
  static
  {
    AppMethodBeat.i(280609);
    yTH = new a((byte)0);
    AppMethodBeat.o(280609);
  }
  
  public FinderLiveCommentPostRealNamePanel(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(280606);
    this.kwF = "";
    init(paramContext);
    AppMethodBeat.o(280606);
  }
  
  public FinderLiveCommentPostRealNamePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(280607);
    this.kwF = "";
    init(paramContext);
    AppMethodBeat.o(280607);
  }
  
  public FinderLiveCommentPostRealNamePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(280608);
    this.kwF = "";
    init(paramContext);
    AppMethodBeat.o(280608);
  }
  
  private final void init(final Context paramContext)
  {
    AppMethodBeat.i(280603);
    Object localObject1 = View.inflate(paramContext, b.g.finder_live_comment_post_real_name_ui, (ViewGroup)this);
    Object localObject2 = ((View)localObject1).findViewById(b.f.license_checkbox);
    p.j(localObject2, "root.findViewById(R.id.license_checkbox)");
    this.checkBox = ((CheckBox)localObject2);
    localObject2 = this.checkBox;
    if (localObject2 == null) {
      p.bGy("checkBox");
    }
    ((CheckBox)localObject2).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new b(this));
    localObject1 = ((View)localObject1).findViewById(b.f.license_content);
    p.j(localObject1, "root.findViewById(R.id.license_content)");
    this.yTF = ((TextView)localObject1);
    localObject1 = this.yTF;
    if (localObject1 == null) {
      p.bGy("licenseContent");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new c(this, paramContext));
    this.yTG = new g(paramContext, 2, 1);
    localObject1 = this.yTG;
    if (localObject1 == null) {
      p.bGy("bottomDialog");
    }
    ((g)localObject1).ah((CharSequence)paramContext.getResources().getString(b.h.live_face_verify_ok));
    localObject1 = this.yTG;
    if (localObject1 == null) {
      p.bGy("bottomDialog");
    }
    ((g)localObject1).a((g.a)new d(this, paramContext));
    paramContext = this.yTG;
    if (paramContext == null) {
      p.bGy("bottomDialog");
    }
    paramContext.ayu(1);
    paramContext = this.yTG;
    if (paramContext == null) {
      p.bGy("bottomDialog");
    }
    paramContext.setCustomView((View)this);
    AppMethodBeat.o(280603);
  }
  
  public final void setDialogHeight(double paramDouble)
  {
    AppMethodBeat.i(280605);
    g localg = this.yTG;
    if (localg == null) {
      p.bGy("bottomDialog");
    }
    localg.setHeight((int)paramDouble);
    AppMethodBeat.o(280605);
  }
  
  public final void setWebviewForwardCallback(q<? super Context, ? super Intent, ? super Integer, x> paramq)
  {
    AppMethodBeat.i(280604);
    p.k(paramq, "callback");
    this.yTD = paramq;
    AppMethodBeat.o(280604);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel$Companion;", "", "()V", "REQUEST_CODE_FACE_VERIFY", "", "TAG", "", "url", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class b
    implements CompoundButton.OnCheckedChangeListener
  {
    b(FinderLiveCommentPostRealNamePanel paramFinderLiveCommentPostRealNamePanel) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(287699);
      FinderLiveCommentPostRealNamePanel.a(this.yTI, paramBoolean);
      if (paramBoolean)
      {
        FinderLiveCommentPostRealNamePanel.b(this.yTI).ayu(0);
        AppMethodBeat.o(287699);
        return;
      }
      FinderLiveCommentPostRealNamePanel.b(this.yTI).ayu(1);
      AppMethodBeat.o(287699);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderLiveCommentPostRealNamePanel paramFinderLiveCommentPostRealNamePanel, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290539);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = new Intent();
      paramView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy");
      localObject = FinderLiveCommentPostRealNamePanel.c(this.yTI);
      if (localObject != null) {
        ((q)localObject).c(paramContext, paramView, null);
      }
      a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290539);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick"})
  static final class d
    implements g.a
  {
    d(FinderLiveCommentPostRealNamePanel paramFinderLiveCommentPostRealNamePanel, Context paramContext) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(281196);
      if ((FinderLiveCommentPostRealNamePanel.a(this.yTI)) && (!Util.isNullOrNil(FinderLiveCommentPostRealNamePanel.d(this.yTI))))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("open_custom_style_url", true);
        localIntent.putExtra("forceHideShare", true);
        localIntent.putExtra("show_native_web_view", true);
        localIntent.putExtra("rawUrl", FinderLiveCommentPostRealNamePanel.d(this.yTI));
        localIntent.putExtra("screen_orientation", 1);
        q localq = FinderLiveCommentPostRealNamePanel.c(this.yTI);
        if (localq != null) {
          localq.c(paramContext, localIntent, Integer.valueOf(10000));
        }
        m.yCt.a(s.bg.yLD);
      }
      AppMethodBeat.o(281196);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCommentPostRealNamePanel
 * JD-Core Version:    0.7.0.1
 */