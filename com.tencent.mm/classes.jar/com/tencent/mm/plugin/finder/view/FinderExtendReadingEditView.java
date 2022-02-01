package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.c;
import com.tencent.mm.plugin.finder.publish.l.d;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bg;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingEditView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addBtn", "Landroid/widget/TextView;", "bgView", "Landroid/view/View;", "closeBtn", "linkTypeListLayout", "Landroid/widget/LinearLayout;", "onAddListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "", "onCloseListener", "Lkotlin/Function0;", "tipsTv", "titleTipsTv", "titleTv", "urlEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "checkEnableAdd", "hideEditView", "isUrlValid", "", "url", "refreshTips", "requestEditFocus", "setListener", "showEditView", "title", "titleTips", "hint", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderExtendReadingEditView
  extends RelativeLayout
{
  private final View AhP;
  public final TextView DMr;
  public final MMEditText DMs;
  private final TextView DMt;
  public kotlin.g.a.b<? super String, ah> Gyn;
  public kotlin.g.a.a<ah> Gyo;
  public final TextView Gyp;
  public final LinearLayout Gyq;
  private final String TAG;
  private final View niB;
  public final TextView titleTv;
  
  public FinderExtendReadingEditView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168315);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = af.mU(getContext()).inflate(l.f.finder_extend_reading_edit_view, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    Object localObject1 = paramContext.findViewById(l.e.finder_extend_reading_edit_close);
    s.s(localObject1, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.niB = ((View)localObject1);
    localObject1 = paramContext.findViewById(l.e.finder_extend_reading_edit_add);
    s.s(localObject1, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.DMr = ((TextView)localObject1);
    localObject1 = paramContext.findViewById(l.e.title_tv);
    s.s(localObject1, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)localObject1);
    localObject1 = paramContext.findViewById(l.e.finder_extend_link_list_layout);
    s.s(localObject1, "view.findViewById(R.id.f…_extend_link_list_layout)");
    this.Gyq = ((LinearLayout)localObject1);
    localObject1 = this.titleTv;
    Object localObject2 = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    localObject2 = getContext();
    s.s(localObject2, "context");
    ((TextView)localObject1).setTextSize(1, com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject2, 15.0F));
    localObject1 = this.DMr;
    localObject2 = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    localObject2 = getContext();
    s.s(localObject2, "context");
    ((TextView)localObject1).setTextSize(1, com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject2, 16.0F));
    localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
    com.tencent.mm.plugin.vlog.util.a.iM((View)this.titleTv);
    localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
    com.tencent.mm.plugin.vlog.util.a.iM((View)this.DMr);
    localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
    com.tencent.mm.plugin.vlog.util.a.iM(this.niB);
    aw.a((Paint)this.titleTv.getPaint(), 0.8F);
    localObject1 = findViewById(l.e.reading_layout);
    ((View)localObject1).post(new FinderExtendReadingEditView..ExternalSyntheticLambda5((View)localObject1, this));
    ((View)localObject1).setOnClickListener(FinderExtendReadingEditView..ExternalSyntheticLambda4.INSTANCE);
    localObject1 = paramContext.findViewById(l.e.finder_extend_reading_edit_et);
    s.s(localObject1, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.DMs = ((MMEditText)localObject1);
    localObject1 = paramContext.findViewById(l.e.finder_extend_reading_edit_tips);
    s.s(localObject1, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.DMt = ((TextView)localObject1);
    localObject1 = paramContext.findViewById(l.e.finder_extend_reading_edit_bg);
    s.s(localObject1, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.AhP = ((View)localObject1);
    paramContext = paramContext.findViewById(l.e.finder_extend_reading_tips);
    s.s(paramContext, "view.findViewById(R.id.finder_extend_reading_tips)");
    this.Gyp = ((TextView)paramContext);
    this.niB.setOnClickListener(new FinderExtendReadingEditView..ExternalSyntheticLambda1(this));
    this.AhP.setOnClickListener(new FinderExtendReadingEditView..ExternalSyntheticLambda0(this));
    this.DMs.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(345640);
        this.Gyr.evj();
        AppMethodBeat.o(345640);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    evi();
    evj();
    AppMethodBeat.o(168315);
  }
  
  public FinderExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168316);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = af.mU(getContext()).inflate(l.f.finder_extend_reading_edit_view, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    paramAttributeSet = paramContext.findViewById(l.e.finder_extend_reading_edit_close);
    s.s(paramAttributeSet, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.niB = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.e.finder_extend_reading_edit_add);
    s.s(paramAttributeSet, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.DMr = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.e.title_tv);
    s.s(paramAttributeSet, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.e.finder_extend_link_list_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.f…_extend_link_list_layout)");
    this.Gyq = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = this.titleTv;
    Object localObject = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    localObject = getContext();
    s.s(localObject, "context");
    paramAttributeSet.setTextSize(1, com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject, 15.0F));
    paramAttributeSet = this.DMr;
    localObject = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    localObject = getContext();
    s.s(localObject, "context");
    paramAttributeSet.setTextSize(1, com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject, 16.0F));
    paramAttributeSet = com.tencent.mm.plugin.vlog.util.a.UsM;
    com.tencent.mm.plugin.vlog.util.a.iM((View)this.titleTv);
    paramAttributeSet = com.tencent.mm.plugin.vlog.util.a.UsM;
    com.tencent.mm.plugin.vlog.util.a.iM((View)this.DMr);
    paramAttributeSet = com.tencent.mm.plugin.vlog.util.a.UsM;
    com.tencent.mm.plugin.vlog.util.a.iM(this.niB);
    aw.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramAttributeSet = findViewById(l.e.reading_layout);
    paramAttributeSet.post(new FinderExtendReadingEditView..ExternalSyntheticLambda5(paramAttributeSet, this));
    paramAttributeSet.setOnClickListener(FinderExtendReadingEditView..ExternalSyntheticLambda4.INSTANCE);
    paramAttributeSet = paramContext.findViewById(l.e.finder_extend_reading_edit_et);
    s.s(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.DMs = ((MMEditText)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.e.finder_extend_reading_edit_tips);
    s.s(paramAttributeSet, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.DMt = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.e.finder_extend_reading_edit_bg);
    s.s(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.AhP = paramAttributeSet;
    paramContext = paramContext.findViewById(l.e.finder_extend_reading_tips);
    s.s(paramContext, "view.findViewById(R.id.finder_extend_reading_tips)");
    this.Gyp = ((TextView)paramContext);
    this.niB.setOnClickListener(new FinderExtendReadingEditView..ExternalSyntheticLambda1(this));
    this.AhP.setOnClickListener(new FinderExtendReadingEditView..ExternalSyntheticLambda0(this));
    this.DMs.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(345640);
        this.Gyr.evj();
        AppMethodBeat.o(345640);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    evi();
    evj();
    AppMethodBeat.o(168316);
  }
  
  public FinderExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168317);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = af.mU(getContext()).inflate(l.f.finder_extend_reading_edit_view, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    paramAttributeSet = paramContext.findViewById(l.e.finder_extend_reading_edit_close);
    s.s(paramAttributeSet, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.niB = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.e.finder_extend_reading_edit_add);
    s.s(paramAttributeSet, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.DMr = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.e.title_tv);
    s.s(paramAttributeSet, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.e.finder_extend_link_list_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.f…_extend_link_list_layout)");
    this.Gyq = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = this.titleTv;
    Object localObject = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    localObject = getContext();
    s.s(localObject, "context");
    paramAttributeSet.setTextSize(1, com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject, 15.0F));
    paramAttributeSet = this.DMr;
    localObject = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    localObject = getContext();
    s.s(localObject, "context");
    paramAttributeSet.setTextSize(1, com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject, 16.0F));
    paramAttributeSet = com.tencent.mm.plugin.vlog.util.a.UsM;
    com.tencent.mm.plugin.vlog.util.a.iM((View)this.titleTv);
    paramAttributeSet = com.tencent.mm.plugin.vlog.util.a.UsM;
    com.tencent.mm.plugin.vlog.util.a.iM((View)this.DMr);
    paramAttributeSet = com.tencent.mm.plugin.vlog.util.a.UsM;
    com.tencent.mm.plugin.vlog.util.a.iM(this.niB);
    aw.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramAttributeSet = findViewById(l.e.reading_layout);
    paramAttributeSet.post(new FinderExtendReadingEditView..ExternalSyntheticLambda5(paramAttributeSet, this));
    paramAttributeSet.setOnClickListener(FinderExtendReadingEditView..ExternalSyntheticLambda4.INSTANCE);
    paramAttributeSet = paramContext.findViewById(l.e.finder_extend_reading_edit_et);
    s.s(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.DMs = ((MMEditText)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.e.finder_extend_reading_edit_tips);
    s.s(paramAttributeSet, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.DMt = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(l.e.finder_extend_reading_edit_bg);
    s.s(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.AhP = paramAttributeSet;
    paramContext = paramContext.findViewById(l.e.finder_extend_reading_tips);
    s.s(paramContext, "view.findViewById(R.id.finder_extend_reading_tips)");
    this.Gyp = ((TextView)paramContext);
    this.niB.setOnClickListener(new FinderExtendReadingEditView..ExternalSyntheticLambda1(this));
    this.AhP.setOnClickListener(new FinderExtendReadingEditView..ExternalSyntheticLambda0(this));
    this.DMs.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(345640);
        this.Gyr.evj();
        AppMethodBeat.o(345640);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    evi();
    evj();
    AppMethodBeat.o(168317);
  }
  
  private static final void a(View paramView, FinderExtendReadingEditView paramFinderExtendReadingEditView)
  {
    AppMethodBeat.i(344997);
    s.u(paramFinderExtendReadingEditView, "this$0");
    paramView.setPadding((int)paramFinderExtendReadingEditView.getContext().getResources().getDimension(l.c.Edge_2A), paramView.getTop(), (int)paramFinderExtendReadingEditView.getContext().getResources().getDimension(l.c.Edge_2A), paramView.getBottom() + bg.bk(paramFinderExtendReadingEditView.getContext()));
    AppMethodBeat.o(344997);
  }
  
  private static final void a(FinderExtendReadingEditView paramFinderExtendReadingEditView, View paramView)
  {
    AppMethodBeat.i(345005);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderExtendReadingEditView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderExtendReadingEditView, "this$0");
    paramFinderExtendReadingEditView = paramFinderExtendReadingEditView.Gyo;
    if (paramFinderExtendReadingEditView != null) {
      paramFinderExtendReadingEditView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345005);
  }
  
  private static final void a(FinderExtendReadingEditView paramFinderExtendReadingEditView, String paramString, View paramView)
  {
    AppMethodBeat.i(345018);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderExtendReadingEditView);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderExtendReadingEditView, "this$0");
    s.u(paramString, "$clipStr");
    paramFinderExtendReadingEditView.DMs.setText((CharSequence)paramString);
    paramFinderExtendReadingEditView.DMt.setVisibility(8);
    paramFinderExtendReadingEditView.Gyp.setVisibility(0);
    paramFinderExtendReadingEditView.DMs.setSelection(paramFinderExtendReadingEditView.DMs.getText().length());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345018);
  }
  
  private static boolean axV(String paramString)
  {
    AppMethodBeat.i(344992);
    s.u(paramString, "url");
    if (!Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(344992);
      return true;
    }
    AppMethodBeat.o(344992);
    return false;
  }
  
  private static final void b(FinderExtendReadingEditView paramFinderExtendReadingEditView, View paramView)
  {
    AppMethodBeat.i(345008);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderExtendReadingEditView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderExtendReadingEditView, "this$0");
    paramFinderExtendReadingEditView = paramFinderExtendReadingEditView.Gyo;
    if (paramFinderExtendReadingEditView != null) {
      paramFinderExtendReadingEditView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345008);
  }
  
  private static final void b(FinderExtendReadingEditView paramFinderExtendReadingEditView, String paramString, View paramView)
  {
    AppMethodBeat.i(345025);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderExtendReadingEditView);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderExtendReadingEditView, "this$0");
    s.u(paramString, "$url");
    localObject = paramFinderExtendReadingEditView.Gyn;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("onAddListener");
      paramView = null;
    }
    paramView.invoke(paramString);
    paramFinderExtendReadingEditView.DMs.setText((CharSequence)"");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345025);
  }
  
  private static final void de(View paramView)
  {
    AppMethodBeat.i(345001);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345001);
  }
  
  public final void ehE()
  {
    AppMethodBeat.i(345065);
    this.Gyq.setVisibility(0);
    this.Gyp.setVisibility(8);
    this.DMs.setVisibility(8);
    this.DMt.setVisibility(8);
    this.DMr.setVisibility(8);
    this.titleTv.setText((CharSequence)getContext().getResources().getString(l.i.finder_extend_reading_title));
    AppMethodBeat.o(345065);
  }
  
  public final void evi()
  {
    AppMethodBeat.i(168313);
    Object localObject = av.GiL;
    localObject = av.ffS();
    if ((Util.isNullOrNil((String)localObject)) || (!axV((String)localObject)))
    {
      this.DMt.setVisibility(8);
      if (this.DMs.getVisibility() == 0)
      {
        this.Gyp.setVisibility(0);
        AppMethodBeat.o(168313);
      }
    }
    else
    {
      if (s.p(this.DMs.getText().toString(), localObject))
      {
        this.DMt.setVisibility(8);
        AppMethodBeat.o(168313);
        return;
      }
      if (getVisibility() == 0)
      {
        this.DMt.setVisibility(0);
        this.Gyp.setVisibility(8);
      }
      this.DMt.setText((CharSequence)getContext().getString(l.i.finder_extend_reading_edit_tips2, new Object[] { localObject }));
      this.DMt.setOnClickListener(new FinderExtendReadingEditView..ExternalSyntheticLambda2(this, (String)localObject));
    }
    AppMethodBeat.o(168313);
  }
  
  public final void evj()
  {
    AppMethodBeat.i(168314);
    String str = this.DMs.getText().toString();
    if (!Util.isNullOrNil(str))
    {
      this.DMr.setOnClickListener(new FinderExtendReadingEditView..ExternalSyntheticLambda3(this, str));
      this.DMr.setTextColor(getResources().getColor(l.b.White));
      this.DMr.setBackgroundResource(l.d.finder_btn_orange_enable);
      AppMethodBeat.o(168314);
      return;
    }
    this.DMr.setOnClickListener(null);
    this.DMr.setTextColor(getResources().getColor(l.b.finder_btn_disable_color));
    this.DMr.setBackgroundResource(l.d.finder_btn_orange_disable);
    AppMethodBeat.o(168314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView
 * JD-Core Version:    0.7.0.1
 */