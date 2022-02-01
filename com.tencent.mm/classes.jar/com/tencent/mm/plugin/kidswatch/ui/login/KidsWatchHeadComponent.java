package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeBtnCallBack", "Lkotlin/Function0;", "", "getCloseBtnCallBack", "()Lkotlin/jvm/functions/Function0;", "setCloseBtnCallBack", "(Lkotlin/jvm/functions/Function0;)V", "prepareViews", "setCloseIconResId", "resId", "setTitle", "title", "", "showHelpIcon", "Companion", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KidsWatchHeadComponent
  extends RelativeLayout
{
  public static final KidsWatchHeadComponent.a JTw;
  private kotlin.g.a.a<ah> JTx;
  
  static
  {
    AppMethodBeat.i(262221);
    JTw = new KidsWatchHeadComponent.a((byte)0);
    AppMethodBeat.o(262221);
  }
  
  public KidsWatchHeadComponent(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(262196);
    AppMethodBeat.o(262196);
  }
  
  public KidsWatchHeadComponent(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(262185);
    setNestedScrollingEnabled(true);
    View.inflate(paramContext, b.f.JSo, (ViewGroup)this);
    ((TextView)findViewById(b.e.gac)).setVisibility(4);
    ((WeImageView)findViewById(b.e.JRP)).setVisibility(4);
    ((WeImageView)findViewById(b.e.JRI)).setBackground(getContext().getDrawable(b.g.icons_outlined_close));
    ((WeImageView)findViewById(b.e.JRI)).setOnClickListener(new KidsWatchHeadComponent..ExternalSyntheticLambda0(this));
    ((WeImageView)findViewById(b.e.JRP)).setOnClickListener(new KidsWatchHeadComponent..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(262185);
  }
  
  private static final void a(KidsWatchHeadComponent paramKidsWatchHeadComponent, View paramView)
  {
    AppMethodBeat.i(262206);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramKidsWatchHeadComponent);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramKidsWatchHeadComponent, "this$0");
    Log.d("KidsWatchHeadComponent", "close clicked");
    paramKidsWatchHeadComponent = paramKidsWatchHeadComponent.getCloseBtnCallBack();
    if (paramKidsWatchHeadComponent != null) {
      paramKidsWatchHeadComponent.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262206);
  }
  
  private static final void b(KidsWatchHeadComponent paramKidsWatchHeadComponent, View paramView)
  {
    AppMethodBeat.i(262212);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramKidsWatchHeadComponent);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramKidsWatchHeadComponent, "this$0");
    Log.i("KidsWatchHeadComponent", "click help icon");
    paramView = com.tencent.mm.plugin.kidswatch.b.a.JTW;
    paramKidsWatchHeadComponent = paramKidsWatchHeadComponent.getContext();
    s.s(paramKidsWatchHeadComponent, "context");
    com.tencent.mm.plugin.kidswatch.b.a.i(paramKidsWatchHeadComponent, "wxaaff6b96fc2cd3c6", "pages/help/help.html", "1");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchHeadComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262212);
  }
  
  public final void fSR()
  {
    AppMethodBeat.i(262262);
    ((WeImageView)findViewById(b.e.JRP)).setVisibility(0);
    AppMethodBeat.o(262262);
  }
  
  public final kotlin.g.a.a<ah> getCloseBtnCallBack()
  {
    return this.JTx;
  }
  
  public final void setCloseBtnCallBack(kotlin.g.a.a<ah> parama)
  {
    this.JTx = parama;
  }
  
  public final void setCloseIconResId(int paramInt)
  {
    AppMethodBeat.i(262255);
    ((WeImageView)findViewById(b.e.JRI)).setBackground(getContext().getDrawable(paramInt));
    AppMethodBeat.o(262255);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(262247);
    s.u(paramString, "title");
    ((TextView)findViewById(b.e.gac)).setText((CharSequence)paramString);
    ((TextView)findViewById(b.e.gac)).setVisibility(0);
    AppMethodBeat.o(262247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchHeadComponent
 * JD-Core Version:    0.7.0.1
 */