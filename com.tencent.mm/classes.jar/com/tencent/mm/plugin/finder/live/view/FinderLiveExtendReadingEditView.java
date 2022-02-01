package com.tencent.mm.plugin.finder.live.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveExtendReadingEditView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "TAG", "", "addBtn", "Landroid/widget/TextView;", "bgView", "Landroid/view/View;", "closeBtn", "contentView", "currentScene", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "onDimissListener", "Lkotlin/Function0;", "", "getOnDimissListener", "()Lkotlin/jvm/functions/Function0;", "setOnDimissListener", "(Lkotlin/jvm/functions/Function0;)V", "onSuccData", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "scene", "uri", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsArticleItem;", "item", "getOnSuccData", "()Lkotlin/jvm/functions/Function3;", "setOnSuccData", "(Lkotlin/jvm/functions/Function3;)V", "tipsTv", "titleTv", "urlEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "checkEnableAdd", "close", "hideInput", "initView", "isUrlValid", "", "url", "onKeyboardHeightChanged", "height", "isResized", "refreshTips", "requestEditFocus", "show", "showErrTips", "tips", "showInput", "showInternal", "keyboardHeight", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveExtendReadingEditView
  extends RelativeLayout
  implements h
{
  public static final FinderLiveExtendReadingEditView.a DMq;
  private static final int DMx;
  private static final int DMy;
  private View AhP;
  private TextView DMr;
  private MMEditText DMs;
  public TextView DMt;
  private int DMu;
  private q<? super Integer, ? super String, ? super byt, ah> DMv;
  private kotlin.g.a.a<ah> DMw;
  private final String TAG;
  private View contentView;
  private i lKz;
  private View niB;
  private TextView titleTv;
  
  static
  {
    AppMethodBeat.i(357638);
    DMq = new FinderLiveExtendReadingEditView.a((byte)0);
    DMx = 1;
    DMy = 2;
    AppMethodBeat.o(357638);
  }
  
  public FinderLiveExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(357534);
    this.TAG = "Finder.FinderExtendReadingEditView";
    this.DMu = DMx;
    initView();
    AppMethodBeat.o(357534);
  }
  
  public FinderLiveExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357540);
    this.TAG = "Finder.FinderExtendReadingEditView";
    this.DMu = DMx;
    initView();
    AppMethodBeat.o(357540);
  }
  
  private static final void a(FinderLiveExtendReadingEditView paramFinderLiveExtendReadingEditView, ValueAnimator paramValueAnimator1, ValueAnimator paramValueAnimator2)
  {
    Object localObject = null;
    AppMethodBeat.i(371521);
    s.u(paramFinderLiveExtendReadingEditView, "this$0");
    Log.i(paramFinderLiveExtendReadingEditView.TAG, s.X("[animatedValue] ", paramValueAnimator1.getAnimatedValue()));
    View localView = paramFinderLiveExtendReadingEditView.contentView;
    paramValueAnimator1 = localView;
    if (localView == null)
    {
      s.bIx("contentView");
      paramValueAnimator1 = null;
    }
    paramValueAnimator1 = paramValueAnimator1.getLayoutParams();
    if (paramValueAnimator1 == null)
    {
      paramFinderLiveExtendReadingEditView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(371521);
      throw paramFinderLiveExtendReadingEditView;
    }
    paramValueAnimator1 = (ViewGroup.MarginLayoutParams)paramValueAnimator1;
    paramValueAnimator2 = paramValueAnimator2.getAnimatedValue();
    if (paramValueAnimator2 == null)
    {
      paramFinderLiveExtendReadingEditView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(371521);
      throw paramFinderLiveExtendReadingEditView;
    }
    paramValueAnimator1.bottomMargin = ((Integer)paramValueAnimator2).intValue();
    paramFinderLiveExtendReadingEditView = paramFinderLiveExtendReadingEditView.contentView;
    if (paramFinderLiveExtendReadingEditView == null)
    {
      s.bIx("contentView");
      paramFinderLiveExtendReadingEditView = localObject;
    }
    for (;;)
    {
      paramFinderLiveExtendReadingEditView.requestLayout();
      AppMethodBeat.o(371521);
      return;
    }
  }
  
  private static final void a(FinderLiveExtendReadingEditView paramFinderLiveExtendReadingEditView, View paramView)
  {
    AppMethodBeat.i(357595);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderLiveExtendReadingEditView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveExtendReadingEditView, "this$0");
    paramFinderLiveExtendReadingEditView.close();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357595);
  }
  
  private static final void a(FinderLiveExtendReadingEditView paramFinderLiveExtendReadingEditView, InputMethodManager paramInputMethodManager)
  {
    AppMethodBeat.i(357608);
    s.u(paramFinderLiveExtendReadingEditView, "this$0");
    MMEditText localMMEditText2 = paramFinderLiveExtendReadingEditView.DMs;
    MMEditText localMMEditText1 = localMMEditText2;
    if (localMMEditText2 == null)
    {
      s.bIx("urlEditText");
      localMMEditText1 = null;
    }
    localMMEditText1.requestFocus();
    localMMEditText2 = paramFinderLiveExtendReadingEditView.DMs;
    localMMEditText1 = localMMEditText2;
    if (localMMEditText2 == null)
    {
      s.bIx("urlEditText");
      localMMEditText1 = null;
    }
    localMMEditText1.requestFocusFromTouch();
    if (paramInputMethodManager != null)
    {
      localMMEditText1 = paramFinderLiveExtendReadingEditView.DMs;
      paramFinderLiveExtendReadingEditView = localMMEditText1;
      if (localMMEditText1 == null)
      {
        s.bIx("urlEditText");
        paramFinderLiveExtendReadingEditView = null;
      }
      paramInputMethodManager.showSoftInput((View)paramFinderLiveExtendReadingEditView, 2);
    }
    AppMethodBeat.o(357608);
  }
  
  private static final void a(FinderLiveExtendReadingEditView paramFinderLiveExtendReadingEditView, String paramString, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(357614);
    Object localObject2 = new Object();
    b localb = new b();
    localb.cH(paramFinderLiveExtendReadingEditView);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    s.u(paramFinderLiveExtendReadingEditView, "this$0");
    s.u(paramString, "$clipStr");
    localObject2 = paramFinderLiveExtendReadingEditView.DMs;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      s.bIx("urlEditText");
      paramView = null;
    }
    paramView.setText((CharSequence)paramString);
    paramView = paramFinderLiveExtendReadingEditView.DMt;
    paramString = paramView;
    if (paramView == null)
    {
      s.bIx("tipsTv");
      paramString = null;
    }
    paramString.setVisibility(4);
    paramView = paramFinderLiveExtendReadingEditView.DMs;
    paramString = paramView;
    if (paramView == null)
    {
      s.bIx("urlEditText");
      paramString = null;
    }
    paramFinderLiveExtendReadingEditView = paramFinderLiveExtendReadingEditView.DMs;
    if (paramFinderLiveExtendReadingEditView == null)
    {
      s.bIx("urlEditText");
      paramFinderLiveExtendReadingEditView = localObject1;
    }
    for (;;)
    {
      paramString.setSelection(paramFinderLiveExtendReadingEditView.getText().length());
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(357614);
      return;
    }
  }
  
  private static boolean axV(String paramString)
  {
    AppMethodBeat.i(357589);
    s.u(paramString, "url");
    if ((!Util.isNullOrNil(paramString)) && ((n.U(paramString, "http", true)) || (n.U(paramString, "https", true))))
    {
      AppMethodBeat.o(357589);
      return true;
    }
    AppMethodBeat.o(357589);
    return false;
  }
  
  private static final void b(FinderLiveExtendReadingEditView paramFinderLiveExtendReadingEditView, View paramView)
  {
    AppMethodBeat.i(357601);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderLiveExtendReadingEditView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveExtendReadingEditView, "this$0");
    paramFinderLiveExtendReadingEditView.close();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357601);
  }
  
  private static final void b(final FinderLiveExtendReadingEditView paramFinderLiveExtendReadingEditView, String paramString, View paramView)
  {
    AppMethodBeat.i(357618);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderLiveExtendReadingEditView);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveExtendReadingEditView, "this$0");
    s.u(paramString, "$url");
    if ((paramFinderLiveExtendReadingEditView.DMu != DMx) && (paramFinderLiveExtendReadingEditView.DMu == DMy)) {}
    for (int i = 4;; i = 1)
    {
      paramView = w.GgV;
      w.a(i, paramString, (r)new b(paramString, paramFinderLiveExtendReadingEditView));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(357618);
      return;
    }
  }
  
  private final void evh()
  {
    AppMethodBeat.i(357561);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    MMEditText localMMEditText2 = this.DMs;
    MMEditText localMMEditText1 = localMMEditText2;
    if (localMMEditText2 == null)
    {
      s.bIx("urlEditText");
      localMMEditText1 = null;
    }
    localMMEditText1.postDelayed(new FinderLiveExtendReadingEditView..ExternalSyntheticLambda5(this, localInputMethodManager), 100L);
    AppMethodBeat.o(357561);
  }
  
  private void evi()
  {
    Object localObject3 = null;
    AppMethodBeat.i(357586);
    Object localObject1 = ClipboardHelper.getText().toString();
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localObject4 = this.DMt;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("tipsTv");
        localObject2 = null;
      }
      ((TextView)localObject2).setTextColor(getContext().getColor(p.b.Link_100));
      localObject4 = this.DMt;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("tipsTv");
        localObject2 = null;
      }
      ((TextView)localObject2).setOnClickListener(null);
      if ((!Util.isNullOrNil((String)localObject1)) && (axV((String)localObject1))) {
        break;
      }
      localObject2 = this.DMt;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("tipsTv");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(4);
      localObject2 = this.DMt;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("tipsTv");
        localObject1 = null;
      }
      ((TextView)localObject1).setOnClickListener(null);
      AppMethodBeat.o(357586);
      return;
    }
    Object localObject4 = this.DMs;
    Object localObject2 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("urlEditText");
      localObject2 = null;
    }
    if (s.p(((MMEditText)localObject2).getText().toString(), localObject1))
    {
      localObject2 = this.DMt;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("tipsTv");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(4);
      localObject2 = this.DMt;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("tipsTv");
        localObject1 = null;
      }
      ((TextView)localObject1).setOnClickListener(null);
      AppMethodBeat.o(357586);
      return;
    }
    localObject4 = this.DMt;
    localObject2 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("tipsTv");
      localObject2 = null;
    }
    ((TextView)localObject2).setVisibility(0);
    localObject2 = this.DMt;
    if (localObject2 == null)
    {
      s.bIx("tipsTv");
      localObject2 = null;
      ((TextView)localObject2).setText((CharSequence)getContext().getString(p.h.Crv, new Object[] { localObject1 }));
      localObject2 = this.DMt;
      if (localObject2 != null) {
        break label358;
      }
      s.bIx("tipsTv");
      localObject2 = localObject3;
    }
    label358:
    for (;;)
    {
      ((TextView)localObject2).setOnClickListener(new FinderLiveExtendReadingEditView..ExternalSyntheticLambda3(this, (String)localObject1));
      AppMethodBeat.o(357586);
      return;
      break;
    }
  }
  
  private final void fDv()
  {
    AppMethodBeat.i(371517);
    Object localObject = getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(371517);
      throw ((Throwable)localObject);
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)localObject;
    MMEditText localMMEditText = this.DMs;
    localObject = localMMEditText;
    if (localMMEditText == null)
    {
      s.bIx("urlEditText");
      localObject = null;
    }
    localInputMethodManager.hideSoftInputFromWindow(((MMEditText)localObject).getWindowToken(), 0);
    AppMethodBeat.o(371517);
  }
  
  private final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(357552);
    View localView = af.mU(getContext()).inflate(p.f.Cdz, (ViewGroup)this);
    Object localObject1 = localView.findViewById(p.e.BUw);
    s.s(localObject1, "view.findViewById(R.id.finder_promote_mp_close)");
    this.niB = ((View)localObject1);
    localObject1 = localView.findViewById(p.e.finder_extend_reading_edit_add);
    s.s(localObject1, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.DMr = ((TextView)localObject1);
    localObject1 = localView.findViewById(p.e.title_tv);
    s.s(localObject1, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)localObject1);
    localObject1 = localView.findViewById(p.e.reading_layout);
    s.s(localObject1, "view.findViewById(R.id.reading_layout)");
    this.contentView = ((View)localObject1);
    localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
    Object localObject3 = this.titleTv;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("titleTv");
      localObject1 = null;
    }
    com.tencent.mm.plugin.vlog.util.a.iM((View)localObject1);
    localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
    localObject3 = this.DMr;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("addBtn");
      localObject1 = null;
    }
    com.tencent.mm.plugin.vlog.util.a.iM((View)localObject1);
    localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
    localObject3 = this.niB;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("closeBtn");
      localObject1 = null;
    }
    com.tencent.mm.plugin.vlog.util.a.iM((View)localObject1);
    localObject3 = this.titleTv;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("titleTv");
      localObject1 = null;
    }
    aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = localView.findViewById(p.e.finder_extend_reading_edit_et);
    s.s(localObject1, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.DMs = ((MMEditText)localObject1);
    localObject1 = localView.findViewById(p.e.finder_extend_reading_edit_tips);
    s.s(localObject1, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.DMt = ((TextView)localObject1);
    localObject1 = localView.findViewById(p.e.finder_extend_reading_edit_bg);
    s.s(localObject1, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.AhP = ((View)localObject1);
    localObject3 = this.niB;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("closeBtn");
      localObject1 = null;
    }
    ((View)localObject1).setOnClickListener(new FinderLiveExtendReadingEditView..ExternalSyntheticLambda2(this));
    localObject3 = this.AhP;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("bgView");
      localObject1 = null;
    }
    ((View)localObject1).setOnClickListener(new FinderLiveExtendReadingEditView..ExternalSyntheticLambda1(this));
    localObject1 = this.DMs;
    if (localObject1 == null)
    {
      s.bIx("urlEditText");
      localObject1 = null;
    }
    for (;;)
    {
      ((MMEditText)localObject1).addTextChangedListener((TextWatcher)new c(this));
      evi();
      evj();
      localObject1 = getContext();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(357552);
      throw ((Throwable)localObject1);
    }
    this.lKz = new i((Activity)localObject1);
    localObject1 = this.lKz;
    if (localObject1 == null)
    {
      s.bIx("keyboardHeightProvider");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((i)localObject1).afIL = ((h)this);
      AppMethodBeat.o(357552);
      return;
    }
  }
  
  public final void Dk(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(357705);
    Object localObject1 = this.DMs;
    if (localObject1 == null)
    {
      s.bIx("urlEditText");
      localObject1 = null;
      ((MMEditText)localObject1).setText((CharSequence)"");
      this.DMu = paramInt;
      setVisibility(0);
      evi();
      i locali = this.lKz;
      localObject1 = locali;
      if (locali == null)
      {
        s.bIx("keyboardHeightProvider");
        localObject1 = null;
      }
      ((i)localObject1).start();
      if (paramInt != DMy) {
        break label136;
      }
      localObject1 = this.titleTv;
      if (localObject1 != null) {
        break label133;
      }
      s.bIx("titleTv");
      localObject1 = localObject2;
      ((TextView)localObject1).setText((CharSequence)getContext().getString(p.h.Zuh));
    }
    label133:
    label136:
    while (paramInt != DMx) {
      for (;;)
      {
        evh();
        AppMethodBeat.o(357705);
        return;
        break;
      }
    }
    localObject1 = this.titleTv;
    if (localObject1 == null)
    {
      s.bIx("titleTv");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((TextView)localObject1).setText((CharSequence)getContext().getString(p.h.Zua));
      break;
    }
  }
  
  public final void close()
  {
    Object localObject2 = null;
    AppMethodBeat.i(357574);
    Object localObject3 = this.lKz;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("keyboardHeightProvider");
      localObject1 = null;
    }
    ((i)localObject1).close();
    fDv();
    localObject3 = this.contentView;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("contentView");
      localObject1 = null;
    }
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(357574);
      throw ((Throwable)localObject1);
    }
    localObject3 = (RelativeLayout.LayoutParams)localObject1;
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = 0;
    localObject1 = this.contentView;
    if (localObject1 == null)
    {
      s.bIx("contentView");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      setVisibility(8);
      localObject1 = this.DMw;
      if (localObject1 != null) {
        ((kotlin.g.a.a)localObject1).invoke();
      }
      AppMethodBeat.o(357574);
      return;
    }
  }
  
  public final void evj()
  {
    TextView localTextView2 = null;
    TextView localTextView1 = null;
    AppMethodBeat.i(357710);
    Object localObject2 = this.DMs;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("urlEditText");
      localObject1 = null;
    }
    localObject2 = ((MMEditText)localObject1).getText().toString();
    if (!Util.isNullOrNil((String)localObject2))
    {
      localTextView2 = this.DMr;
      localObject1 = localTextView2;
      if (localTextView2 == null)
      {
        s.bIx("addBtn");
        localObject1 = null;
      }
      ((TextView)localObject1).setOnClickListener(new FinderLiveExtendReadingEditView..ExternalSyntheticLambda4(this, (String)localObject2));
      localTextView2 = this.DMr;
      localObject1 = localTextView2;
      if (localTextView2 == null)
      {
        s.bIx("addBtn");
        localObject1 = null;
      }
      ((TextView)localObject1).setTextColor(getResources().getColor(p.b.White));
      localObject1 = this.DMr;
      if (localObject1 == null)
      {
        s.bIx("addBtn");
        localObject1 = localTextView1;
      }
      for (;;)
      {
        ((TextView)localObject1).setBackgroundResource(p.d.BAq);
        AppMethodBeat.o(357710);
        return;
      }
    }
    localTextView1 = this.DMr;
    localObject1 = localTextView1;
    if (localTextView1 == null)
    {
      s.bIx("addBtn");
      localObject1 = null;
    }
    ((TextView)localObject1).setOnClickListener(null);
    localTextView1 = this.DMr;
    localObject1 = localTextView1;
    if (localTextView1 == null)
    {
      s.bIx("addBtn");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(p.b.BW_100_Alpha_0_2));
    localObject1 = this.DMr;
    if (localObject1 == null)
    {
      s.bIx("addBtn");
      localObject1 = localTextView2;
    }
    for (;;)
    {
      ((TextView)localObject1).setBackgroundResource(p.d.BAs);
      AppMethodBeat.o(357710);
      return;
    }
  }
  
  public final kotlin.g.a.a<ah> getOnDimissListener()
  {
    return this.DMw;
  }
  
  public final q<Integer, String, byt, ah> getOnSuccData()
  {
    return this.DMv;
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(357719);
    View localView = this.contentView;
    Object localObject1 = localView;
    if (localView == null)
    {
      s.bIx("contentView");
      localObject1 = null;
    }
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(357719);
      throw ((Throwable)localObject1);
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    int i = bf.bk(getContext()) + paramInt;
    if ((paramInt > 0) && (((RelativeLayout.LayoutParams)localObject1).bottomMargin != i))
    {
      localObject1 = ObjectAnimator.ofInt(new int[] { 0, i });
      ((ValueAnimator)localObject1).setDuration(200L);
      ((ValueAnimator)localObject1).addUpdateListener(new FinderLiveExtendReadingEditView..ExternalSyntheticLambda0(this, (ValueAnimator)localObject1));
      ((ValueAnimator)localObject1).start();
    }
    while (paramInt != 0)
    {
      setVisibility(0);
      AppMethodBeat.o(357719);
      return;
    }
    localView = this.contentView;
    localObject1 = localView;
    if (localView == null)
    {
      s.bIx("contentView");
      localObject1 = null;
    }
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(357719);
      throw ((Throwable)localObject1);
    }
    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = bf.bk(getContext());
    localObject1 = this.contentView;
    if (localObject1 == null)
    {
      s.bIx("contentView");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((View)localObject1).requestLayout();
      break;
    }
  }
  
  public final void setOnDimissListener(kotlin.g.a.a<ah> parama)
  {
    this.DMw = parama;
  }
  
  public final void setOnSuccData(q<? super Integer, ? super String, ? super byt, ah> paramq)
  {
    this.DMv = paramq;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errCode", "", "errMsg", "", "link", "item", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsArticleItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements r<Integer, String, String, byt, ah>
  {
    b(String paramString, FinderLiveExtendReadingEditView paramFinderLiveExtendReadingEditView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveExtendReadingEditView$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements TextWatcher
  {
    c(FinderLiveExtendReadingEditView paramFinderLiveExtendReadingEditView) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(357767);
      if (((CharSequence)String.valueOf(paramEditable)).length() == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          TextView localTextView = FinderLiveExtendReadingEditView.b(this.DMz);
          paramEditable = localTextView;
          if (localTextView == null)
          {
            s.bIx("tipsTv");
            paramEditable = null;
          }
          paramEditable.setVisibility(4);
        }
        this.DMz.evj();
        AppMethodBeat.o(357767);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveExtendReadingEditView
 * JD-Core Version:    0.7.0.1
 */