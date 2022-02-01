package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ay;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingEditView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addBtn", "Landroid/widget/TextView;", "bgView", "Landroid/view/View;", "closeBtn", "onAddListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "", "onCloseListener", "Lkotlin/Function0;", "tipsTv", "titleTipsTv", "titleTv", "urlEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "checkEnableAdd", "isUrlValid", "", "url", "refreshTips", "requestEditFocus", "setListener", "plugin-finder_release"})
public final class FinderExtendReadingEditView
  extends RelativeLayout
{
  public kotlin.g.a.b<? super String, x> AWB;
  public kotlin.g.a.a<x> AWC;
  private final TextView AWD;
  public final MMEditText AWE;
  private final TextView AWF;
  private final TextView AWG;
  private final String TAG;
  private final View cCj;
  private final View kFA;
  private final TextView titleTv;
  
  public FinderExtendReadingEditView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168315);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = ad.kS(getContext()).inflate(b.g.finder_extend_reading_edit_view, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    final View localView = paramContext.findViewById(b.f.finder_extend_reading_edit_close);
    p.j(localView, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.kFA = localView;
    localView = paramContext.findViewById(b.f.finder_extend_reading_edit_add);
    p.j(localView, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.AWD = ((TextView)localView);
    localView = paramContext.findViewById(b.f.title_tv);
    p.j(localView, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)localView);
    ar.a((Paint)this.titleTv.getPaint(), 0.8F);
    localView = findViewById(b.f.reading_layout);
    localView.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.AWH.getContext();
        p.j(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(b.d.Edge_2A);
        localObject = localView;
        p.j(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.AWH.getContext();
        p.j(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(b.d.Edge_2A);
        localObject = localView;
        p.j(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + ay.aB(this.AWH.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    localView = paramContext.findViewById(b.f.finder_extend_reading_edit_et);
    p.j(localView, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.AWE = ((MMEditText)localView);
    localView = paramContext.findViewById(b.f.finder_extend_reading_edit_tips);
    p.j(localView, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.AWF = ((TextView)localView);
    localView = paramContext.findViewById(b.f.finder_extend_reading_edit_bg);
    p.j(localView, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.cCj = localView;
    paramContext = paramContext.findViewById(b.f.finder_extend_reading_tips);
    p.j(paramContext, "view.findViewById(R.id.finder_extend_reading_tips)");
    this.AWG = ((TextView)paramContext);
    this.kFA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = FinderExtendReadingEditView.d(this.AWH);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168308);
      }
    });
    this.cCj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = FinderExtendReadingEditView.d(this.AWH);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168309);
      }
    });
    this.AWG.setText((CharSequence)((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuB, this.AWG.getContext().getString(b.j.finder_extend_reading_edit_tips1)));
    this.AWE.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.AWH.eiE();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    eiD();
    eiE();
    AppMethodBeat.o(168315);
  }
  
  public FinderExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168316);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = ad.kS(getContext()).inflate(b.g.finder_extend_reading_edit_view, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    paramAttributeSet = paramContext.findViewById(b.f.finder_extend_reading_edit_close);
    p.j(paramAttributeSet, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.kFA = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(b.f.finder_extend_reading_edit_add);
    p.j(paramAttributeSet, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.AWD = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(b.f.title_tv);
    p.j(paramAttributeSet, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    ar.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramAttributeSet = findViewById(b.f.reading_layout);
    paramAttributeSet.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.AWH.getContext();
        p.j(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(b.d.Edge_2A);
        localObject = localView;
        p.j(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.AWH.getContext();
        p.j(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(b.d.Edge_2A);
        localObject = localView;
        p.j(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + ay.aB(this.AWH.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    paramAttributeSet = paramContext.findViewById(b.f.finder_extend_reading_edit_et);
    p.j(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.AWE = ((MMEditText)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(b.f.finder_extend_reading_edit_tips);
    p.j(paramAttributeSet, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.AWF = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(b.f.finder_extend_reading_edit_bg);
    p.j(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.cCj = paramAttributeSet;
    paramContext = paramContext.findViewById(b.f.finder_extend_reading_tips);
    p.j(paramContext, "view.findViewById(R.id.finder_extend_reading_tips)");
    this.AWG = ((TextView)paramContext);
    this.kFA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = FinderExtendReadingEditView.d(this.AWH);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168308);
      }
    });
    this.cCj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = FinderExtendReadingEditView.d(this.AWH);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168309);
      }
    });
    this.AWG.setText((CharSequence)((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuB, this.AWG.getContext().getString(b.j.finder_extend_reading_edit_tips1)));
    this.AWE.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.AWH.eiE();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    eiD();
    eiE();
    AppMethodBeat.o(168316);
  }
  
  public FinderExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168317);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = ad.kS(getContext()).inflate(b.g.finder_extend_reading_edit_view, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    paramAttributeSet = paramContext.findViewById(b.f.finder_extend_reading_edit_close);
    p.j(paramAttributeSet, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.kFA = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(b.f.finder_extend_reading_edit_add);
    p.j(paramAttributeSet, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.AWD = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(b.f.title_tv);
    p.j(paramAttributeSet, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    ar.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramAttributeSet = findViewById(b.f.reading_layout);
    paramAttributeSet.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.AWH.getContext();
        p.j(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(b.d.Edge_2A);
        localObject = localView;
        p.j(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.AWH.getContext();
        p.j(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(b.d.Edge_2A);
        localObject = localView;
        p.j(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + ay.aB(this.AWH.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    paramAttributeSet = paramContext.findViewById(b.f.finder_extend_reading_edit_et);
    p.j(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.AWE = ((MMEditText)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(b.f.finder_extend_reading_edit_tips);
    p.j(paramAttributeSet, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.AWF = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(b.f.finder_extend_reading_edit_bg);
    p.j(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.cCj = paramAttributeSet;
    paramContext = paramContext.findViewById(b.f.finder_extend_reading_tips);
    p.j(paramContext, "view.findViewById(R.id.finder_extend_reading_tips)");
    this.AWG = ((TextView)paramContext);
    this.kFA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = FinderExtendReadingEditView.d(this.AWH);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168308);
      }
    });
    this.cCj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = FinderExtendReadingEditView.d(this.AWH);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168309);
      }
    });
    this.AWG.setText((CharSequence)((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuB, this.AWG.getContext().getString(b.j.finder_extend_reading_edit_tips1)));
    this.AWE.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.AWH.eiE();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    eiD();
    eiE();
    AppMethodBeat.o(168317);
  }
  
  public final void eiD()
  {
    AppMethodBeat.i(168313);
    Object localObject = aj.AGc;
    localObject = aj.edZ();
    if (!Util.isNullOrNil((String)localObject))
    {
      p.k(localObject, "url");
      if (Util.isNullOrNil((String)localObject)) {
        break label57;
      }
    }
    label57:
    for (int i = 1; i == 0; i = 0)
    {
      this.AWF.setVisibility(8);
      AppMethodBeat.o(168313);
      return;
    }
    if (p.h(this.AWE.getText().toString(), localObject))
    {
      this.AWF.setVisibility(8);
      AppMethodBeat.o(168313);
      return;
    }
    this.AWF.setVisibility(0);
    this.AWF.setText((CharSequence)getContext().getString(b.j.finder_extend_reading_edit_tips2, new Object[] { localObject }));
    this.AWF.setOnClickListener((View.OnClickListener)new b(this, (String)localObject));
    AppMethodBeat.o(168313);
  }
  
  public final void eiE()
  {
    AppMethodBeat.i(168314);
    final String str = this.AWE.getText().toString();
    if (!Util.isNullOrNil(str))
    {
      this.AWD.setOnClickListener((View.OnClickListener)new a(this, str));
      this.AWD.setTextColor(getResources().getColor(b.c.White));
      this.AWD.setBackgroundResource(b.e.finder_btn_orange_enable);
      AppMethodBeat.o(168314);
      return;
    }
    this.AWD.setOnClickListener(null);
    this.AWD.setTextColor(getResources().getColor(b.c.finder_btn_disable_color));
    this.AWD.setBackgroundResource(b.e.finder_btn_orange_disable);
    AppMethodBeat.o(168314);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderExtendReadingEditView paramFinderExtendReadingEditView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168311);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$checkEnableAdd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderExtendReadingEditView.c(this.AWH).invoke(str);
      FinderExtendReadingEditView.a(this.AWH).setText((CharSequence)"");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$checkEnableAdd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168311);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderExtendReadingEditView paramFinderExtendReadingEditView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168312);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$refreshTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderExtendReadingEditView.a(this.AWH).setText((CharSequence)this.AWJ);
      FinderExtendReadingEditView.b(this.AWH).setVisibility(8);
      FinderExtendReadingEditView.a(this.AWH).setSelection(FinderExtendReadingEditView.a(this.AWH).getText().length());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$refreshTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168312);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView
 * JD-Core Version:    0.7.0.1
 */