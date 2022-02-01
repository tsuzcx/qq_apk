package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.h;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.bv;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.j;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "check", "", "checkBox", "Landroid/widget/CheckBox;", "licenseContent", "Landroid/widget/TextView;", "realNameCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "verifyUrl", "", "webviewForwardCallback", "Lkotlin/Function3;", "Landroid/content/Intent;", "intent", "requestCode", "init", "onActivityResult", "resultCode", "data", "setDialogHeight", "height", "", "setLicenseText", "tv", "setWebviewForwardCallback", "callback", "showDialog", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveCommentPostRealNamePanel
  extends LinearLayout
{
  public static final FinderLiveCommentPostRealNamePanel.a DMd;
  private TextView Bqr;
  private q<? super Context, ? super Intent, ? super Integer, ah> DMe;
  public b<? super Boolean, ah> DMf;
  public j DMg;
  private CheckBox checkBox;
  public String nag;
  private boolean plZ;
  
  static
  {
    AppMethodBeat.i(358046);
    DMd = new FinderLiveCommentPostRealNamePanel.a((byte)0);
    AppMethodBeat.o(358046);
  }
  
  public FinderLiveCommentPostRealNamePanel(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(357980);
    this.nag = "";
    init(paramContext);
    AppMethodBeat.o(357980);
  }
  
  public FinderLiveCommentPostRealNamePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(357987);
    this.nag = "";
    init(paramContext);
    AppMethodBeat.o(357987);
  }
  
  public FinderLiveCommentPostRealNamePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357992);
    this.nag = "";
    init(paramContext);
    AppMethodBeat.o(357992);
  }
  
  private static final void a(FinderLiveCommentPostRealNamePanel paramFinderLiveCommentPostRealNamePanel, Context paramContext)
  {
    AppMethodBeat.i(358031);
    s.u(paramFinderLiveCommentPostRealNamePanel, "this$0");
    s.u(paramContext, "$context");
    if ((paramFinderLiveCommentPostRealNamePanel.plZ) && (!Util.isNullOrNil(paramFinderLiveCommentPostRealNamePanel.nag)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("open_custom_style_url", true);
      localIntent.putExtra("forceHideShare", true);
      localIntent.putExtra("show_native_web_view", true);
      localIntent.putExtra("rawUrl", paramFinderLiveCommentPostRealNamePanel.nag);
      localIntent.putExtra("screen_orientation", 1);
      paramFinderLiveCommentPostRealNamePanel = paramFinderLiveCommentPostRealNamePanel.DMe;
      if (paramFinderLiveCommentPostRealNamePanel != null) {
        paramFinderLiveCommentPostRealNamePanel.invoke(paramContext, localIntent, Integer.valueOf(10000));
      }
      k.Doi.a(q.bv.DDu);
    }
    AppMethodBeat.o(358031);
  }
  
  private static final void a(FinderLiveCommentPostRealNamePanel paramFinderLiveCommentPostRealNamePanel, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = null;
    paramCompoundButton = null;
    AppMethodBeat.i(358021);
    s.u(paramFinderLiveCommentPostRealNamePanel, "this$0");
    paramFinderLiveCommentPostRealNamePanel.plZ = paramBoolean;
    if (paramBoolean)
    {
      paramFinderLiveCommentPostRealNamePanel = paramFinderLiveCommentPostRealNamePanel.DMg;
      if (paramFinderLiveCommentPostRealNamePanel == null)
      {
        s.bIx("bottomDialog");
        paramFinderLiveCommentPostRealNamePanel = paramCompoundButton;
      }
      for (;;)
      {
        paramFinderLiveCommentPostRealNamePanel.aFe(0);
        AppMethodBeat.o(358021);
        return;
      }
    }
    paramFinderLiveCommentPostRealNamePanel = paramFinderLiveCommentPostRealNamePanel.DMg;
    if (paramFinderLiveCommentPostRealNamePanel == null)
    {
      s.bIx("bottomDialog");
      paramFinderLiveCommentPostRealNamePanel = localObject;
    }
    for (;;)
    {
      paramFinderLiveCommentPostRealNamePanel.aFe(1);
      AppMethodBeat.o(358021);
      return;
    }
  }
  
  private final void init(Context paramContext)
  {
    Object localObject2 = null;
    AppMethodBeat.i(358004);
    View localView = View.inflate(paramContext, p.f.Cds, (ViewGroup)this);
    Object localObject1 = localView.findViewById(p.e.BVV);
    s.s(localObject1, "root.findViewById(R.id.license_checkbox)");
    this.checkBox = ((CheckBox)localObject1);
    Object localObject3 = this.checkBox;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("checkBox");
      localObject1 = null;
    }
    ((CheckBox)localObject1).setOnCheckedChangeListener(new FinderLiveCommentPostRealNamePanel..ExternalSyntheticLambda0(this));
    localObject1 = localView.findViewById(p.e.BVW);
    s.s(localObject1, "root.findViewById(R.id.license_content)");
    this.Bqr = ((TextView)localObject1);
    localObject3 = this.Bqr;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("licenseContent");
      localObject1 = null;
    }
    setLicenseText((TextView)localObject1);
    this.DMg = new j(paramContext, 2, 1);
    localObject1 = this.DMg;
    if (localObject1 == null)
    {
      s.bIx("bottomDialog");
      localObject1 = null;
      ((j)localObject1).au((CharSequence)paramContext.getResources().getString(b.h.live_face_verify_ok));
      localObject3 = this.DMg;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("bottomDialog");
        localObject1 = null;
      }
      ((j)localObject1).agfR = new FinderLiveCommentPostRealNamePanel..ExternalSyntheticLambda1(this, paramContext);
      localObject1 = this.DMg;
      paramContext = (Context)localObject1;
      if (localObject1 == null)
      {
        s.bIx("bottomDialog");
        paramContext = null;
      }
      paramContext.aFe(1);
      paramContext = this.DMg;
      if (paramContext != null) {
        break label263;
      }
      s.bIx("bottomDialog");
      paramContext = localObject2;
    }
    label263:
    for (;;)
    {
      paramContext.setCustomView((View)this);
      AppMethodBeat.o(358004);
      return;
      break;
    }
  }
  
  private final void setLicenseText(TextView paramTextView)
  {
    AppMethodBeat.i(358017);
    Object localObject1 = paramTextView.getContext().getResources().getString(p.h.Cid);
    s.s(localObject1, "tv.context.resources.get…inder_live_anchor_iterms)");
    Object localObject2 = am.aixg;
    localObject2 = paramTextView.getContext().getResources().getString(p.h.Cjy, new Object[] { localObject1 });
    s.s(localObject2, "tv.context.resources.get…alname_license, firstStr)");
    localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[0], 0));
    s.s(localObject2, "java.lang.String.format(format, *args)");
    int i = n.a((CharSequence)localObject2, (String)localObject1, 0, false, 6);
    int j = ((String)localObject1).length();
    localObject1 = new SpannableString((CharSequence)localObject2);
    ((SpannableString)localObject1).setSpan(new b(this), i, i + j, 33);
    paramTextView.setHighlightColor(paramTextView.getContext().getResources().getColor(17170445));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject1);
    AppMethodBeat.o(358017);
  }
  
  public final void setDialogHeight(double paramDouble)
  {
    AppMethodBeat.i(358077);
    j localj2 = this.DMg;
    j localj1 = localj2;
    if (localj2 == null)
    {
      s.bIx("bottomDialog");
      localj1 = null;
    }
    localj1.setHeight((int)paramDouble);
    AppMethodBeat.o(358077);
  }
  
  public final void setWebviewForwardCallback(q<? super Context, ? super Intent, ? super Integer, ah> paramq)
  {
    AppMethodBeat.i(358072);
    s.u(paramq, "callback");
    this.DMe = paramq;
    AppMethodBeat.o(358072);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel$setLicenseText$firstClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ClickableSpan
  {
    b(FinderLiveCommentPostRealNamePanel paramFinderLiveCommentPostRealNamePanel) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(357493);
      s.u(paramView, "widget");
      paramView = new Intent();
      paramView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy");
      q localq = FinderLiveCommentPostRealNamePanel.a(this.DMh);
      if (localq != null)
      {
        Context localContext = this.DMh.getContext();
        s.s(localContext, "context");
        localq.invoke(localContext, paramView, null);
      }
      AppMethodBeat.o(357493);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(357498);
      s.u(paramTextPaint, "ds");
      paramTextPaint.setColor(Color.parseColor("#7D90A9"));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(357498);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCommentPostRealNamePanel
 * JD-Core Version:    0.7.0.1
 */