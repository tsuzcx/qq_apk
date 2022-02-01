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
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s.as;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "check", "", "checkBox", "Landroid/widget/CheckBox;", "licenseContent", "Landroid/widget/TextView;", "realNameCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "verifyUrl", "", "webviewForwardCallback", "Lkotlin/Function3;", "Landroid/content/Intent;", "intent", "requestCode", "init", "onActivityResult", "resultCode", "data", "setDialogHeight", "height", "", "setWebviewForwardCallback", "callback", "showDialog", "Companion", "plugin-finder_release"})
public final class FinderLiveCommentPostRealNamePanel
  extends LinearLayout
{
  public static final a uyp;
  private CheckBox checkBox;
  public String hJl;
  private boolean jCx;
  private q<? super Context, ? super Intent, ? super Integer, x> uyl;
  public kotlin.g.a.b<? super Boolean, x> uym;
  private TextView uyn;
  public g uyo;
  
  static
  {
    AppMethodBeat.i(247443);
    uyp = new a((byte)0);
    AppMethodBeat.o(247443);
  }
  
  public FinderLiveCommentPostRealNamePanel(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(247440);
    this.hJl = "";
    init(paramContext);
    AppMethodBeat.o(247440);
  }
  
  public FinderLiveCommentPostRealNamePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(247441);
    this.hJl = "";
    init(paramContext);
    AppMethodBeat.o(247441);
  }
  
  public FinderLiveCommentPostRealNamePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(247442);
    this.hJl = "";
    init(paramContext);
    AppMethodBeat.o(247442);
  }
  
  private final void init(final Context paramContext)
  {
    AppMethodBeat.i(247437);
    Object localObject1 = View.inflate(paramContext, 2131494386, (ViewGroup)this);
    Object localObject2 = ((View)localObject1).findViewById(2131303161);
    p.g(localObject2, "root.findViewById(R.id.license_checkbox)");
    this.checkBox = ((CheckBox)localObject2);
    localObject2 = this.checkBox;
    if (localObject2 == null) {
      p.btv("checkBox");
    }
    ((CheckBox)localObject2).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new b(this));
    localObject1 = ((View)localObject1).findViewById(2131303162);
    p.g(localObject1, "root.findViewById(R.id.license_content)");
    this.uyn = ((TextView)localObject1);
    localObject1 = this.uyn;
    if (localObject1 == null) {
      p.btv("licenseContent");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new c(this, paramContext));
    this.uyo = new g(paramContext, 2, 1);
    localObject1 = this.uyo;
    if (localObject1 == null) {
      p.btv("bottomDialog");
    }
    ((g)localObject1).T((CharSequence)paramContext.getResources().getString(2131762293));
    localObject1 = this.uyo;
    if (localObject1 == null) {
      p.btv("bottomDialog");
    }
    ((g)localObject1).a((g.a)new d(this, paramContext));
    paramContext = this.uyo;
    if (paramContext == null) {
      p.btv("bottomDialog");
    }
    paramContext.ape(1);
    paramContext = this.uyo;
    if (paramContext == null) {
      p.btv("bottomDialog");
    }
    paramContext.setCustomView((View)this);
    AppMethodBeat.o(247437);
  }
  
  public final void setDialogHeight(double paramDouble)
  {
    AppMethodBeat.i(247439);
    g localg = this.uyo;
    if (localg == null) {
      p.btv("bottomDialog");
    }
    localg.setHeight((int)paramDouble);
    AppMethodBeat.o(247439);
  }
  
  public final void setWebviewForwardCallback(q<? super Context, ? super Intent, ? super Integer, x> paramq)
  {
    AppMethodBeat.i(247438);
    p.h(paramq, "callback");
    this.uyl = paramq;
    AppMethodBeat.o(247438);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel$Companion;", "", "()V", "REQUEST_CODE_FACE_VERIFY", "", "TAG", "", "url", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class b
    implements CompoundButton.OnCheckedChangeListener
  {
    b(FinderLiveCommentPostRealNamePanel paramFinderLiveCommentPostRealNamePanel) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(247434);
      FinderLiveCommentPostRealNamePanel.a(this.uyq, paramBoolean);
      if (paramBoolean)
      {
        FinderLiveCommentPostRealNamePanel.b(this.uyq).ape(0);
        AppMethodBeat.o(247434);
        return;
      }
      FinderLiveCommentPostRealNamePanel.b(this.uyq).ape(1);
      AppMethodBeat.o(247434);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderLiveCommentPostRealNamePanel paramFinderLiveCommentPostRealNamePanel, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247435);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = new Intent();
      paramView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy");
      localObject = FinderLiveCommentPostRealNamePanel.c(this.uyq);
      if (localObject != null) {
        ((q)localObject).d(paramContext, paramView, null);
      }
      a.a(this, "com/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247435);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClick"})
  static final class d
    implements g.a
  {
    d(FinderLiveCommentPostRealNamePanel paramFinderLiveCommentPostRealNamePanel, Context paramContext) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(247436);
      if ((FinderLiveCommentPostRealNamePanel.a(this.uyq)) && (!Util.isNullOrNil(FinderLiveCommentPostRealNamePanel.d(this.uyq))))
      {
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("open_custom_style_url", true);
        ((Intent)localObject).putExtra("forceHideShare", true);
        ((Intent)localObject).putExtra("show_native_web_view", true);
        ((Intent)localObject).putExtra("rawUrl", FinderLiveCommentPostRealNamePanel.d(this.uyq));
        ((Intent)localObject).putExtra("screen_orientation", 1);
        q localq = FinderLiveCommentPostRealNamePanel.c(this.uyq);
        if (localq != null) {
          localq.d(paramContext, localObject, Integer.valueOf(10000));
        }
        localObject = m.vli;
        m.a(s.as.vrF);
      }
      AppMethodBeat.o(247436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCommentPostRealNamePanel
 * JD-Core Version:    0.7.0.1
 */