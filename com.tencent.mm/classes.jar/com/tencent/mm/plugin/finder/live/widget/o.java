package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.util.g;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "", "root", "Landroid/view/View;", "anchorUsername", "", "liveCoverUrl", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V", "getAnchorUsername", "()Ljava/lang/String;", "setAnchorUsername", "(Ljava/lang/String;)V", "backImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "btnClickCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "ok", "", "errCode", "", "errPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "icon", "license", "Landroid/widget/TextView;", "licenseClickCallback", "url", "getLiveCoverUrl", "setLiveCoverUrl", "okBtn", "Landroid/widget/Button;", "title", "type", "getLicenseText", "Landroid/text/SpannableString;", "textSize", "getLicenseTxt", "str", "strForIndex", "hide", "setLicenseClickCallback", "callback", "show", "showBlurBg", "showContent", "showNormalBg", "Companion", "plugin-finder_release"})
public final class o
{
  private static final String TAG = "Finder.FinderLiveExceptionWidget";
  private static final int WARNING = 4;
  private static final String znD = "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy";
  private static final int znE = 1;
  private static final int znF = 2;
  private static final int znG = 3;
  private static final int znH = 5;
  private static final int znI = 6;
  private static final int znJ = 7;
  public static final c znK;
  private int errCode;
  private final TextView jMg;
  private final View jac;
  private final Button kEt;
  private String kig;
  private int type;
  private String zfA;
  private final WeImageView znA;
  private final TextView znB;
  private aze znC;
  private kotlin.g.a.b<? super Boolean, x> znx;
  public kotlin.g.a.b<? super String, x> zny;
  private final WeImageView znz;
  
  static
  {
    AppMethodBeat.i(242430);
    znK = new c((byte)0);
    TAG = "Finder.FinderLiveExceptionWidget";
    znD = "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy";
    znE = 1;
    znF = 2;
    znG = 3;
    WARNING = 4;
    znH = 5;
    znI = 6;
    znJ = 7;
    AppMethodBeat.o(242430);
  }
  
  public o(View paramView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(242426);
    this.jac = paramView;
    this.kig = paramString1;
    this.zfA = paramString2;
    paramView = this.jac.findViewById(b.f.exception_icon);
    p.j(paramView, "root.findViewById(R.id.exception_icon)");
    this.znz = ((WeImageView)paramView);
    paramView = this.jac.findViewById(b.f.exception_ok_btn);
    p.j(paramView, "root.findViewById(R.id.exception_ok_btn)");
    this.kEt = ((Button)paramView);
    paramView = this.jac.findViewById(b.f.exception_top_back);
    p.j(paramView, "root.findViewById(R.id.exception_top_back)");
    this.znA = ((WeImageView)paramView);
    paramView = this.jac.findViewById(b.f.exception_tip);
    p.j(paramView, "root.findViewById(R.id.exception_tip)");
    this.znB = ((TextView)paramView);
    paramView = this.jac.findViewById(b.f.exception_title);
    p.j(paramView, "root.findViewById(R.id.exception_title)");
    this.jMg = ((TextView)paramView);
    this.type = znE;
    this.kEt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(288649);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.znL.hide();
        paramAnonymousView = o.c(this.znL);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Boolean.TRUE);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(288649);
      }
    });
    paramView = this.znA;
    paramString1 = paramView.getLayoutParams();
    if (paramString1 == null)
    {
      paramView = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(242426);
      throw paramView;
    }
    paramString1 = (ViewGroup.MarginLayoutParams)paramString1;
    paramString1.topMargin += ax.getStatusBarHeight(this.jac.getContext());
    paramView.setOnClickListener((View.OnClickListener)new a(this));
    paramView.post((Runnable)new b(paramView));
    ar.a((Paint)this.jMg.getPaint(), 0.8F);
    ar.a((Paint)this.kEt.getPaint(), 0.8F);
    AppMethodBeat.o(242426);
  }
  
  private final SpannableString a(aze paramaze, int paramInt)
  {
    AppMethodBeat.i(242407);
    Object localObject;
    int i;
    if (paramaze != null)
    {
      localObject = (CharSequence)paramaze.wording;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label137;
        }
      }
    }
    else
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("getLicenseText: error page is null, wording = ");
      if (paramaze == null) {
        break label122;
      }
      localObject = paramaze.wording;
      label67:
      Log.i(str, (String)localObject);
      if (paramaze == null) {
        break label128;
      }
      paramaze = paramaze.wording;
      if (paramaze == null) {
        break label128;
      }
    }
    label128:
    for (paramaze = (CharSequence)paramaze;; paramaze = (CharSequence)"")
    {
      paramaze = new SpannableString(paramaze);
      AppMethodBeat.o(242407);
      return paramaze;
      i = 0;
      break;
      label122:
      localObject = null;
      break label67;
    }
    label137:
    paramaze = com.tencent.mm.pluginsdk.ui.span.l.g(this.jac.getContext(), (CharSequence)paramaze.wording, paramInt);
    p.j(paramaze, "MMSpanManager.spanForSmi…ckSpanStyle.NORMAL, null)");
    AppMethodBeat.o(242407);
    return paramaze;
  }
  
  private final void dIb()
  {
    AppMethodBeat.i(242410);
    View localView = this.jac;
    Context localContext = this.jac.getContext();
    p.j(localContext, "root.context");
    localView.setBackgroundColor(localContext.getResources().getColor(b.c.BG_2));
    AppMethodBeat.o(242410);
  }
  
  private final SpannableString he(String paramString1, String paramString2)
  {
    AppMethodBeat.i(242404);
    int j = n.a((CharSequence)paramString1, paramString2, 0, false, 6);
    int i = j + paramString2.length();
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString1);
    if ((j <= 0) || (i > paramString1.length()))
    {
      i = paramString1.length();
      Log.e(TAG, "license text err,all string:" + paramString1 + ",license:" + paramString2);
      j = 0;
    }
    for (;;)
    {
      localSpannableString.setSpan(new d(this), j, i, 33);
      AppMethodBeat.o(242404);
      return localSpannableString;
    }
  }
  
  private final void showBlurBg()
  {
    AppMethodBeat.i(242413);
    g localg = g.yPJ;
    g.a(this.kig, this.zfA, this.jac);
    AppMethodBeat.o(242413);
  }
  
  public final void a(final int paramInt1, final aze paramaze, final int paramInt2, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(242416);
    d.uiThread((kotlin.g.a.a)new f(this, paramInt1, paramaze, paramInt2, paramb));
    AppMethodBeat.o(242416);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(242422);
    d.uiThread((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(242422);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$2$1"})
  static final class a
    implements View.OnClickListener
  {
    a(o paramo) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(277221);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.znL.hide();
      paramView = o.c(this.znL);
      if (paramView != null) {
        paramView.invoke(Boolean.FALSE);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277221);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(WeImageView paramWeImageView) {}
    
    public final void run()
    {
      AppMethodBeat.i(278128);
      Object localObject = new Rect();
      this.znM.getHitRect((Rect)localObject);
      ((Rect)localObject).inset(-((Rect)localObject).width(), -((Rect)localObject).width());
      ViewParent localViewParent = this.znM.getParent();
      if (localViewParent == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(278128);
        throw ((Throwable)localObject);
      }
      ((View)localViewParent).setTouchDelegate(new TouchDelegate((Rect)localObject, (View)this.znM));
      AppMethodBeat.o(278128);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$Companion;", "", "()V", "ANCHOR_FORCE_QUIT", "", "getANCHOR_FORCE_QUIT", "()I", "ANCHOR_POST_ERROR", "getANCHOR_POST_ERROR", "ANCHOR_REALNAME", "getANCHOR_REALNAME", "ANCHOR_SHOW_ERR_PAGE", "getANCHOR_SHOW_ERR_PAGE", "LICENSE_URL", "", "getLICENSE_URL", "()Ljava/lang/String;", "TAG", "getTAG", "VISITOR_KICKED_MEMBER", "getVISITOR_KICKED_MEMBER", "VISITOR_PRIVATE_COUNT", "getVISITOR_PRIVATE_COUNT", "WARNING", "getWARNING", "plugin-finder_release"})
  public static final class c {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$getLicenseTxt$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class d
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(276178);
      p.k(paramView, "widget");
      Object localObject1 = o.znK;
      localObject1 = o.access$getTAG$cp();
      Object localObject2 = new StringBuilder("license click,licenseClickCallback is null:");
      if (o.a(this.znL) == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i((String)localObject1, bool);
        if (o.a(this.znL) == null) {
          break label108;
        }
        paramView = o.a(this.znL);
        if (paramView == null) {
          break;
        }
        localObject1 = o.znK;
        paramView.invoke(o.dIc());
        AppMethodBeat.o(276178);
        return;
      }
      AppMethodBeat.o(276178);
      return;
      label108:
      localObject1 = new Intent();
      localObject2 = o.znK;
      ((Intent)localObject1).putExtra("rawUrl", o.dIc());
      c.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      AppMethodBeat.o(276178);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(276180);
      p.k(paramTextPaint, "ds");
      Context localContext = o.b(this.znL).getContext();
      p.j(localContext, "root.context");
      paramTextPaint.setColor(localContext.getResources().getColor(b.c.Link_80));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(276180);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(o paramo)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(o paramo, int paramInt1, aze paramaze, int paramInt2, kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.o
 * JD-Core Version:    0.7.0.1
 */