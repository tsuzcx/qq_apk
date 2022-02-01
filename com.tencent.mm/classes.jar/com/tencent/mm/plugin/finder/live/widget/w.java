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
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.util.g;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "", "root", "Landroid/view/View;", "anchorUsername", "", "liveCoverUrl", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V", "getAnchorUsername", "()Ljava/lang/String;", "setAnchorUsername", "(Ljava/lang/String;)V", "backImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "btnClickCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "ok", "", "errCode", "", "errPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "icon", "license", "Landroid/widget/TextView;", "licenseClickCallback", "url", "getLiveCoverUrl", "setLiveCoverUrl", "okBtn", "Landroid/widget/Button;", "title", "type", "getLicenseText", "Landroid/text/SpannableString;", "textSize", "getLicenseTxt", "str", "strForIndex", "hide", "setLicenseClickCallback", "callback", "show", "showBlurBg", "showContent", "showNormalBg", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final w.a EoA;
  private static final String EoH;
  private static final int EoI;
  private static final int EoJ;
  private static final int EoK;
  private static final int EoL;
  private static final int EoM;
  private static final int EoN;
  private static final String TAG;
  private static final int WARNING;
  private static final int akhl;
  private String EcY;
  private kotlin.g.a.b<? super Boolean, ah> EoB;
  public kotlin.g.a.b<? super String, ah> EoC;
  private final WeImageView EoD;
  private final WeImageView EoE;
  private final TextView EoF;
  private bgq EoG;
  private int errCode;
  private final View lBX;
  private String mIC;
  private final TextView mll;
  private final Button nhC;
  private int type;
  
  static
  {
    AppMethodBeat.i(362513);
    EoA = new w.a((byte)0);
    TAG = "Finder.FinderLiveExceptionWidget";
    EoH = "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy";
    EoI = 1;
    EoJ = 2;
    EoK = 3;
    WARNING = 4;
    EoL = 5;
    EoM = 6;
    EoN = 7;
    akhl = 8;
    AppMethodBeat.o(362513);
  }
  
  public w(View paramView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(362238);
    this.lBX = paramView;
    this.mIC = paramString1;
    this.EcY = paramString2;
    paramView = this.lBX.findViewById(p.e.BCR);
    s.s(paramView, "root.findViewById(R.id.exception_icon)");
    this.EoD = ((WeImageView)paramView);
    paramView = this.lBX.findViewById(p.e.BCS);
    s.s(paramView, "root.findViewById(R.id.exception_ok_btn)");
    this.nhC = ((Button)paramView);
    paramView = this.lBX.findViewById(p.e.BCV);
    s.s(paramView, "root.findViewById(R.id.exception_top_back)");
    this.EoE = ((WeImageView)paramView);
    paramView = this.lBX.findViewById(p.e.BCT);
    s.s(paramView, "root.findViewById(R.id.exception_tip)");
    this.EoF = ((TextView)paramView);
    paramView = this.lBX.findViewById(p.e.BCU);
    s.s(paramView, "root.findViewById(R.id.exception_title)");
    this.mll = ((TextView)paramView);
    this.type = EoI;
    this.nhC.setOnClickListener(new w..ExternalSyntheticLambda0(this));
    paramView = this.EoE;
    paramString1 = paramView.getLayoutParams();
    if (paramString1 == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(362238);
      throw paramView;
    }
    paramString1 = (ViewGroup.MarginLayoutParams)paramString1;
    paramString1.topMargin += bf.getStatusBarHeight(this.lBX.getContext());
    paramView.setOnClickListener(new w..ExternalSyntheticLambda1(this));
    paramView.post(new w..ExternalSyntheticLambda2(paramView));
    aw.a((Paint)this.mll.getPaint(), 0.8F);
    aw.a((Paint)this.nhC.getPaint(), 0.8F);
    AppMethodBeat.o(362238);
  }
  
  private final SpannableString a(bgq parambgq, int paramInt)
  {
    AppMethodBeat.i(362283);
    Object localObject;
    int i;
    if (parambgq != null)
    {
      localObject = (CharSequence)parambgq.wording;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label126;
        }
      }
    }
    else
    {
      String str = TAG;
      if (parambgq != null) {
        break label97;
      }
      localObject = null;
      label52:
      Log.i(str, s.X("getLicenseText: error page is null, wording = ", localObject));
      if (parambgq != null) {
        break label106;
      }
      parambgq = "";
    }
    for (;;)
    {
      parambgq = new SpannableString((CharSequence)parambgq);
      AppMethodBeat.o(362283);
      return parambgq;
      i = 0;
      break;
      label97:
      localObject = parambgq.wording;
      break label52;
      label106:
      localObject = parambgq.wording;
      parambgq = (bgq)localObject;
      if (localObject == null) {
        parambgq = "";
      }
    }
    label126:
    parambgq = p.f(this.lBX.getContext(), (CharSequence)parambgq.wording, paramInt);
    s.s(parambgq, "spanForSmileyAndLinkWith…ckSpanStyle.NORMAL, null)");
    AppMethodBeat.o(362283);
    return parambgq;
  }
  
  private static final void a(w paramw, View paramView)
  {
    AppMethodBeat.i(362328);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramw);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramw, "this$0");
    paramw.hide();
    paramw = paramw.EoB;
    if (paramw != null) {
      paramw.invoke(Boolean.TRUE);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362328);
  }
  
  private static final void b(w paramw, View paramView)
  {
    AppMethodBeat.i(362342);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramw);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramw, "this$0");
    paramw.hide();
    paramw = paramw.EoB;
    if (paramw != null) {
      paramw.invoke(Boolean.FALSE);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362342);
  }
  
  private static final void b(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(362352);
    s.u(paramWeImageView, "$this_apply");
    Rect localRect = new Rect();
    paramWeImageView.getHitRect(localRect);
    localRect.inset(-localRect.width(), -localRect.width());
    ViewParent localViewParent = paramWeImageView.getParent();
    if (localViewParent == null)
    {
      paramWeImageView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(362352);
      throw paramWeImageView;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, (View)paramWeImageView));
    AppMethodBeat.o(362352);
  }
  
  private final void eAy()
  {
    AppMethodBeat.i(362299);
    this.lBX.setBackgroundColor(this.lBX.getContext().getResources().getColor(p.b.BG_2));
    AppMethodBeat.o(362299);
  }
  
  private final SpannableString hV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(362269);
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
      localSpannableString.setSpan(new b(this), j, i, 33);
      AppMethodBeat.o(362269);
      return localSpannableString;
    }
  }
  
  private final void showBlurBg()
  {
    AppMethodBeat.i(362311);
    g localg = g.DIp;
    g.a(this.mIC, this.EcY, this.lBX);
    AppMethodBeat.o(362311);
  }
  
  public final void a(final int paramInt1, final bgq parambgq, final int paramInt2, final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(362556);
    d.uiThread((kotlin.g.a.a)new d(this, paramInt1, parambgq, paramInt2, paramb));
    AppMethodBeat.o(362556);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(362563);
    d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(362563);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget$getLicenseTxt$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ClickableSpan
  {
    b(w paramw) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(362160);
      s.u(paramView, "widget");
      Object localObject = w.EoA;
      localObject = w.access$getTAG$cp();
      if (w.a(this.EoO) == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i((String)localObject, s.X("license click,licenseClickCallback is null:", Boolean.valueOf(bool)));
        if (w.a(this.EoO) == null) {
          break;
        }
        paramView = w.a(this.EoO);
        if (paramView == null) {
          break label126;
        }
        localObject = w.EoA;
        paramView.invoke(w.eAz());
        AppMethodBeat.o(362160);
        return;
      }
      localObject = new Intent();
      w.a locala = w.EoA;
      ((Intent)localObject).putExtra("rawUrl", w.eAz());
      c.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      label126:
      AppMethodBeat.o(362160);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(362167);
      s.u(paramTextPaint, "ds");
      paramTextPaint.setColor(w.b(this.EoO).getContext().getResources().getColor(p.b.Link_80));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(362167);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(w paramw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(w paramw, int paramInt1, bgq parambgq, int paramInt2, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.w
 * JD-Core Version:    0.7.0.1
 */