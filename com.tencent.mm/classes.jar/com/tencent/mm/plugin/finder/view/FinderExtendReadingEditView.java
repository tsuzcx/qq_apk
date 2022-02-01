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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.widget.MMEditText;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingEditView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addBtn", "Landroid/widget/TextView;", "bgView", "Landroid/view/View;", "closeBtn", "onAddListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "", "onCloseListener", "Lkotlin/Function0;", "tipsTv", "titleTv", "urlEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "checkEnableAdd", "isUrlValid", "", "url", "refreshTips", "requestEditFocus", "setListener", "plugin-finder_release"})
public final class FinderExtendReadingEditView
  extends RelativeLayout
{
  private final String TAG;
  private final View gVy;
  private final TextView opV;
  private final View rxm;
  private final TextView sTA;
  public final MMEditText sTB;
  public d.g.a.b<? super String, d.z> sTy;
  public d.g.a.a<d.z> sTz;
  private final TextView titleTv;
  
  public FinderExtendReadingEditView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168315);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = com.tencent.mm.ui.z.jO(getContext()).inflate(2131494030, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    final View localView = paramContext.findViewById(2131299994);
    d.g.b.p.g(localView, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.gVy = localView;
    localView = paramContext.findViewById(2131299992);
    d.g.b.p.g(localView, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.sTA = ((TextView)localView);
    localView = paramContext.findViewById(2131305948);
    d.g.b.p.g(localView, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)localView);
    al.a((Paint)this.titleTv.getPaint(), 0.8F);
    localView = findViewById(2131303783);
    localView.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.sTC.getContext();
        d.g.b.p.g(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        d.g.b.p.g(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.sTC.getContext();
        d.g.b.p.g(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        d.g.b.p.g(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + as.ej(this.sTC.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    localView = paramContext.findViewById(2131299995);
    d.g.b.p.g(localView, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.sTB = ((MMEditText)localView);
    localView = paramContext.findViewById(2131299996);
    d.g.b.p.g(localView, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.opV = ((TextView)localView);
    paramContext = paramContext.findViewById(2131299993);
    d.g.b.p.g(paramContext, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.rxm = paramContext;
    this.gVy.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = FinderExtendReadingEditView.d(this.sTC);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168308);
      }
    });
    this.rxm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = FinderExtendReadingEditView.d(this.sTC);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168309);
      }
    });
    this.sTB.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.sTC.cNi();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    cNh();
    cNi();
    AppMethodBeat.o(168315);
  }
  
  public FinderExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168316);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = com.tencent.mm.ui.z.jO(getContext()).inflate(2131494030, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    paramAttributeSet = paramContext.findViewById(2131299994);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.gVy = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299992);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.sTA = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131305948);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    al.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramAttributeSet = findViewById(2131303783);
    paramAttributeSet.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.sTC.getContext();
        d.g.b.p.g(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        d.g.b.p.g(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.sTC.getContext();
        d.g.b.p.g(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        d.g.b.p.g(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + as.ej(this.sTC.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    paramAttributeSet = paramContext.findViewById(2131299995);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.sTB = ((MMEditText)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299996);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.opV = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131299993);
    d.g.b.p.g(paramContext, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.rxm = paramContext;
    this.gVy.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = FinderExtendReadingEditView.d(this.sTC);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168308);
      }
    });
    this.rxm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = FinderExtendReadingEditView.d(this.sTC);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168309);
      }
    });
    this.sTB.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.sTC.cNi();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    cNh();
    cNi();
    AppMethodBeat.o(168316);
  }
  
  public FinderExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168317);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = com.tencent.mm.ui.z.jO(getContext()).inflate(2131494030, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    paramAttributeSet = paramContext.findViewById(2131299994);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.gVy = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299992);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.sTA = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131305948);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    al.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramAttributeSet = findViewById(2131303783);
    paramAttributeSet.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.sTC.getContext();
        d.g.b.p.g(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        d.g.b.p.g(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.sTC.getContext();
        d.g.b.p.g(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        d.g.b.p.g(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + as.ej(this.sTC.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    paramAttributeSet = paramContext.findViewById(2131299995);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.sTB = ((MMEditText)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299996);
    d.g.b.p.g(paramAttributeSet, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.opV = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131299993);
    d.g.b.p.g(paramContext, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.rxm = paramContext;
    this.gVy.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = FinderExtendReadingEditView.d(this.sTC);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168308);
      }
    });
    this.rxm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = FinderExtendReadingEditView.d(this.sTC);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168309);
      }
    });
    this.sTB.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.sTC.cNi();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    cNh();
    cNi();
    AppMethodBeat.o(168317);
  }
  
  public final void cNh()
  {
    AppMethodBeat.i(168313);
    Object localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
    localObject = com.tencent.mm.plugin.finder.utils.p.cLz();
    if (!bt.isNullOrNil((String)localObject))
    {
      d.g.b.p.h(localObject, "url");
      if (bt.isNullOrNil((String)localObject)) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i == 0; i = 0)
    {
      this.opV.setVisibility(8);
      AppMethodBeat.o(168313);
      return;
    }
    if (d.g.b.p.i(this.sTB.getText().toString(), localObject))
    {
      this.opV.setVisibility(8);
      AppMethodBeat.o(168313);
      return;
    }
    this.opV.setVisibility(0);
    this.opV.setText((CharSequence)getContext().getString(2131759201, new Object[] { localObject }));
    this.opV.setOnClickListener((View.OnClickListener)new b(this, (String)localObject));
    AppMethodBeat.o(168313);
  }
  
  public final void cNi()
  {
    AppMethodBeat.i(168314);
    final String str = this.sTB.getText().toString();
    if (!bt.isNullOrNil(str))
    {
      this.sTA.setOnClickListener((View.OnClickListener)new a(this, str));
      this.sTA.setTextColor(getResources().getColor(2131099828));
      this.sTA.setBackgroundResource(2131232336);
      AppMethodBeat.o(168314);
      return;
    }
    this.sTA.setOnClickListener(null);
    this.sTA.setTextColor(getResources().getColor(2131100368));
    this.sTA.setBackgroundResource(2131232335);
    AppMethodBeat.o(168314);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderExtendReadingEditView paramFinderExtendReadingEditView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168311);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$checkEnableAdd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      FinderExtendReadingEditView.c(this.sTC).invoke(str);
      FinderExtendReadingEditView.a(this.sTC).setText((CharSequence)"");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$checkEnableAdd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168311);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderExtendReadingEditView paramFinderExtendReadingEditView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168312);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$refreshTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      FinderExtendReadingEditView.a(this.sTC).setText((CharSequence)this.sTE);
      FinderExtendReadingEditView.b(this.sTC).setVisibility(8);
      FinderExtendReadingEditView.a(this.sTC).setSelection(FinderExtendReadingEditView.a(this.sTC).getText().length());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$refreshTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168312);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView
 * JD-Core Version:    0.7.0.1
 */