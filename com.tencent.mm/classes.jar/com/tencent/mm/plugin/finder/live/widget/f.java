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
import com.tencent.mm.ac.d;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.live.util.g;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "", "root", "Landroid/view/View;", "anchorUsername", "", "liveCoverUrl", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V", "getAnchorUsername", "()Ljava/lang/String;", "setAnchorUsername", "(Ljava/lang/String;)V", "backImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "btnClickCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "ok", "", "errCode", "", "errPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "icon", "license", "Landroid/widget/TextView;", "licenseClickCallback", "url", "getLiveCoverUrl", "setLiveCoverUrl", "okBtn", "Landroid/widget/Button;", "title", "type", "getLicenseText", "Landroid/text/SpannableString;", "textSize", "getLicenseTxt", "str", "strForIndex", "hide", "setLicenseClickCallback", "callback", "show", "showBlurBg", "showContent", "showNormalBg", "Companion", "plugin-finder_release"})
public final class f
{
  private static final String TAG = "Finder.FinderLiveExceptionWidget";
  private static final int WARNING = 4;
  private static final String uGq = "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy";
  private static final int uGr = 1;
  private static final int uGs = 2;
  private static final int uGt = 3;
  private static final int uGu = 5;
  private static final int uGv = 6;
  private static final int uGw = 7;
  public static final c uGx;
  private int errCode;
  private final View gvQ;
  private final Button hPX;
  private final TextView hbb;
  private String hwd;
  private int type;
  private String uEu;
  private kotlin.g.a.b<? super Boolean, x> uGk;
  public kotlin.g.a.b<? super String, x> uGl;
  private final WeImageView uGm;
  private final WeImageView uGn;
  private final TextView uGo;
  private avr uGp;
  
  static
  {
    AppMethodBeat.i(248093);
    uGx = new c((byte)0);
    TAG = "Finder.FinderLiveExceptionWidget";
    uGq = "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy";
    uGr = 1;
    uGs = 2;
    uGt = 3;
    WARNING = 4;
    uGu = 5;
    uGv = 6;
    uGw = 7;
    AppMethodBeat.o(248093);
  }
  
  public f(View paramView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(248091);
    this.gvQ = paramView;
    this.hwd = paramString1;
    this.uEu = paramString2;
    paramView = this.gvQ.findViewById(2131300182);
    p.g(paramView, "root.findViewById(R.id.exception_icon)");
    this.uGm = ((WeImageView)paramView);
    paramView = this.gvQ.findViewById(2131300183);
    p.g(paramView, "root.findViewById(R.id.exception_ok_btn)");
    this.hPX = ((Button)paramView);
    paramView = this.gvQ.findViewById(2131300186);
    p.g(paramView, "root.findViewById(R.id.exception_top_back)");
    this.uGn = ((WeImageView)paramView);
    paramView = this.gvQ.findViewById(2131300184);
    p.g(paramView, "root.findViewById(R.id.exception_tip)");
    this.uGo = ((TextView)paramView);
    paramView = this.gvQ.findViewById(2131300185);
    p.g(paramView, "root.findViewById(R.id.exception_title)");
    this.hbb = ((TextView)paramView);
    this.type = uGr;
    this.hPX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(248078);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.uGy.hide();
        paramAnonymousView = f.c(this.uGy);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke(Boolean.TRUE);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248078);
      }
    });
    paramView = this.uGn;
    paramString1 = paramView.getLayoutParams();
    if (paramString1 == null)
    {
      paramView = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(248091);
      throw paramView;
    }
    paramString1 = (ViewGroup.MarginLayoutParams)paramString1;
    paramString1.topMargin += au.getStatusBarHeight(this.gvQ.getContext());
    paramView.setOnClickListener((View.OnClickListener)new a(this));
    paramView.post((Runnable)new b(paramView));
    ao.a((Paint)this.hbb.getPaint(), 0.8F);
    ao.a((Paint)this.hPX.getPaint(), 0.8F);
    AppMethodBeat.o(248091);
  }
  
  private final SpannableString a(avr paramavr, int paramInt)
  {
    AppMethodBeat.i(248085);
    Object localObject;
    int i;
    if (paramavr != null)
    {
      localObject = (CharSequence)paramavr.dQx;
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
      if (paramavr == null) {
        break label122;
      }
      localObject = paramavr.dQx;
      label67:
      Log.i(str, (String)localObject);
      if (paramavr == null) {
        break label128;
      }
      paramavr = paramavr.dQx;
      if (paramavr == null) {
        break label128;
      }
    }
    label128:
    for (paramavr = (CharSequence)paramavr;; paramavr = (CharSequence)"")
    {
      paramavr = new SpannableString(paramavr);
      AppMethodBeat.o(248085);
      return paramavr;
      i = 0;
      break;
      label122:
      localObject = null;
      break label67;
    }
    label137:
    paramavr = com.tencent.mm.pluginsdk.ui.span.l.g(this.gvQ.getContext(), (CharSequence)paramavr.dQx, paramInt);
    p.g(paramavr, "MMSpanManager.spanForSmi…ckSpanStyle.NORMAL, null)");
    AppMethodBeat.o(248085);
    return paramavr;
  }
  
  private final void djC()
  {
    AppMethodBeat.i(248086);
    View localView = this.gvQ;
    Context localContext = this.gvQ.getContext();
    p.g(localContext, "root.context");
    localView.setBackgroundColor(localContext.getResources().getColor(2131099650));
    AppMethodBeat.o(248086);
  }
  
  private final SpannableString gN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(248084);
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
      AppMethodBeat.o(248084);
      return localSpannableString;
    }
  }
  
  private final void showBlurBg()
  {
    AppMethodBeat.i(248087);
    g localg = g.uwd;
    g.a(this.hwd, this.uEu, this.gvQ);
    AppMethodBeat.o(248087);
  }
  
  public final void a(final int paramInt1, final avr paramavr, final int paramInt2, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(248088);
    d.h((kotlin.g.a.a)new f(this, paramInt1, paramavr, paramInt2, paramb));
    AppMethodBeat.o(248088);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(248090);
    d.h((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(248090);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$2$1"})
  static final class a
    implements View.OnClickListener
  {
    a(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248077);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.uGy.hide();
      paramView = f.c(this.uGy);
      if (paramView != null) {
        paramView.invoke(Boolean.FALSE);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248077);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(WeImageView paramWeImageView) {}
    
    public final void run()
    {
      AppMethodBeat.i(248079);
      Object localObject = new Rect();
      this.uGz.getHitRect((Rect)localObject);
      ((Rect)localObject).inset(-((Rect)localObject).width(), -((Rect)localObject).width());
      ViewParent localViewParent = this.uGz.getParent();
      if (localViewParent == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(248079);
        throw ((Throwable)localObject);
      }
      ((View)localViewParent).setTouchDelegate(new TouchDelegate((Rect)localObject, (View)this.uGz));
      AppMethodBeat.o(248079);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$Companion;", "", "()V", "ANCHOR_FORCE_QUIT", "", "getANCHOR_FORCE_QUIT", "()I", "ANCHOR_POST_ERROR", "getANCHOR_POST_ERROR", "ANCHOR_REALNAME", "getANCHOR_REALNAME", "ANCHOR_SHOW_ERR_PAGE", "getANCHOR_SHOW_ERR_PAGE", "LICENSE_URL", "", "getLICENSE_URL", "()Ljava/lang/String;", "TAG", "getTAG", "VISITOR_KICKED_MEMBER", "getVISITOR_KICKED_MEMBER", "VISITOR_PRIVATE_COUNT", "getVISITOR_PRIVATE_COUNT", "WARNING", "getWARNING", "plugin-finder_release"})
  public static final class c {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$getLicenseTxt$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class d
    extends ClickableSpan
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248080);
      p.h(paramView, "widget");
      Object localObject1 = f.uGx;
      localObject1 = f.access$getTAG$cp();
      Object localObject2 = new StringBuilder("license click,licenseClickCallback is null:");
      if (f.a(this.uGy) == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i((String)localObject1, bool);
        if (f.a(this.uGy) == null) {
          break label108;
        }
        paramView = f.a(this.uGy);
        if (paramView == null) {
          break;
        }
        localObject1 = f.uGx;
        paramView.invoke(f.djD());
        AppMethodBeat.o(248080);
        return;
      }
      AppMethodBeat.o(248080);
      return;
      label108:
      localObject1 = new Intent();
      localObject2 = f.uGx;
      ((Intent)localObject1).putExtra("rawUrl", f.djD());
      c.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      AppMethodBeat.o(248080);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(248081);
      p.h(paramTextPaint, "ds");
      Context localContext = f.b(this.uGy).getContext();
      p.g(localContext, "root.context");
      paramTextPaint.setColor(localContext.getResources().getColor(2131099787));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(248081);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(f paramf, int paramInt1, avr paramavr, int paramInt2, kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.f
 * JD-Core Version:    0.7.0.1
 */