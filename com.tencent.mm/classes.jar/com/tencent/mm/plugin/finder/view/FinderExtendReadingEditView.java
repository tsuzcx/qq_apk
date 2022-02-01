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
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingEditView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addBtn", "Landroid/widget/TextView;", "bgView", "Landroid/view/View;", "closeBtn", "onAddListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "", "onCloseListener", "Lkotlin/Function0;", "tipsTv", "titleTv", "urlEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "checkEnableAdd", "isUrlValid", "", "url", "refreshTips", "requestEditFocus", "setListener", "plugin-finder_release"})
public final class FinderExtendReadingEditView
  extends RelativeLayout
{
  private final String TAG;
  private final View cBH;
  private final View hRd;
  private final TextView pJV;
  private final TextView titleTv;
  public kotlin.g.a.b<? super String, x> wlE;
  public kotlin.g.a.a<x> wlF;
  private final TextView wlG;
  public final MMEditText wlH;
  
  public FinderExtendReadingEditView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168315);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = aa.jQ(getContext()).inflate(2131494244, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    final View localView = paramContext.findViewById(2131300819);
    p.g(localView, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.hRd = localView;
    localView = paramContext.findViewById(2131300817);
    p.g(localView, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.wlG = ((TextView)localView);
    localView = paramContext.findViewById(2131309249);
    p.g(localView, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)localView);
    ao.a((Paint)this.titleTv.getPaint(), 0.8F);
    localView = findViewById(2131306573);
    localView.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.wlI.getContext();
        p.g(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(2131165296);
        localObject = localView;
        p.g(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.wlI.getContext();
        p.g(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(2131165296);
        localObject = localView;
        p.g(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + av.aD(this.wlI.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    localView = paramContext.findViewById(2131300820);
    p.g(localView, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.wlH = ((MMEditText)localView);
    localView = paramContext.findViewById(2131300821);
    p.g(localView, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.pJV = ((TextView)localView);
    paramContext = paramContext.findViewById(2131300818);
    p.g(paramContext, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.cBH = paramContext;
    this.hRd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = FinderExtendReadingEditView.d(this.wlI);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168308);
      }
    });
    this.cBH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = FinderExtendReadingEditView.d(this.wlI);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168309);
      }
    });
    this.wlH.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.wlI.dGF();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    dGE();
    dGF();
    AppMethodBeat.o(168315);
  }
  
  public FinderExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168316);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = aa.jQ(getContext()).inflate(2131494244, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    paramAttributeSet = paramContext.findViewById(2131300819);
    p.g(paramAttributeSet, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.hRd = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131300817);
    p.g(paramAttributeSet, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.wlG = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131309249);
    p.g(paramAttributeSet, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    ao.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramAttributeSet = findViewById(2131306573);
    paramAttributeSet.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.wlI.getContext();
        p.g(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(2131165296);
        localObject = localView;
        p.g(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.wlI.getContext();
        p.g(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(2131165296);
        localObject = localView;
        p.g(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + av.aD(this.wlI.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    paramAttributeSet = paramContext.findViewById(2131300820);
    p.g(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.wlH = ((MMEditText)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131300821);
    p.g(paramAttributeSet, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.pJV = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131300818);
    p.g(paramContext, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.cBH = paramContext;
    this.hRd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = FinderExtendReadingEditView.d(this.wlI);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168308);
      }
    });
    this.cBH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = FinderExtendReadingEditView.d(this.wlI);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168309);
      }
    });
    this.wlH.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.wlI.dGF();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    dGE();
    dGF();
    AppMethodBeat.o(168316);
  }
  
  public FinderExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168317);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = aa.jQ(getContext()).inflate(2131494244, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    paramAttributeSet = paramContext.findViewById(2131300819);
    p.g(paramAttributeSet, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.hRd = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131300817);
    p.g(paramAttributeSet, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.wlG = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131309249);
    p.g(paramAttributeSet, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    ao.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramAttributeSet = findViewById(2131306573);
    paramAttributeSet.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.wlI.getContext();
        p.g(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(2131165296);
        localObject = localView;
        p.g(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.wlI.getContext();
        p.g(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(2131165296);
        localObject = localView;
        p.g(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + av.aD(this.wlI.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    paramAttributeSet = paramContext.findViewById(2131300820);
    p.g(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.wlH = ((MMEditText)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131300821);
    p.g(paramAttributeSet, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.pJV = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131300818);
    p.g(paramContext, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.cBH = paramContext;
    this.hRd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = FinderExtendReadingEditView.d(this.wlI);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168308);
      }
    });
    this.cBH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = FinderExtendReadingEditView.d(this.wlI);
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168309);
      }
    });
    this.wlH.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.wlI.dGF();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    dGE();
    dGF();
    AppMethodBeat.o(168317);
  }
  
  public final void dGE()
  {
    AppMethodBeat.i(168313);
    Object localObject = y.vXH;
    localObject = y.dCC();
    if (!Util.isNullOrNil((String)localObject))
    {
      p.h(localObject, "url");
      if (Util.isNullOrNil((String)localObject)) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i == 0; i = 0)
    {
      this.pJV.setVisibility(8);
      AppMethodBeat.o(168313);
      return;
    }
    if (p.j(this.wlH.getText().toString(), localObject))
    {
      this.pJV.setVisibility(8);
      AppMethodBeat.o(168313);
      return;
    }
    this.pJV.setVisibility(0);
    this.pJV.setText((CharSequence)getContext().getString(2131759694, new Object[] { localObject }));
    this.pJV.setOnClickListener((View.OnClickListener)new b(this, (String)localObject));
    AppMethodBeat.o(168313);
  }
  
  public final void dGF()
  {
    AppMethodBeat.i(168314);
    final String str = this.wlH.getText().toString();
    if (!Util.isNullOrNil(str))
    {
      this.wlG.setOnClickListener((View.OnClickListener)new a(this, str));
      this.wlG.setTextColor(getResources().getColor(2131099844));
      this.wlG.setBackgroundResource(2131232490);
      AppMethodBeat.o(168314);
      return;
    }
    this.wlG.setOnClickListener(null);
    this.wlG.setTextColor(getResources().getColor(2131100410));
    this.wlG.setBackgroundResource(2131232488);
    AppMethodBeat.o(168314);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderExtendReadingEditView paramFinderExtendReadingEditView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168311);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$checkEnableAdd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderExtendReadingEditView.c(this.wlI).invoke(str);
      FinderExtendReadingEditView.a(this.wlI).setText((CharSequence)"");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$checkEnableAdd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168311);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderExtendReadingEditView paramFinderExtendReadingEditView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168312);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$refreshTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderExtendReadingEditView.a(this.wlI).setText((CharSequence)this.wlK);
      FinderExtendReadingEditView.b(this.wlI).setVisibility(8);
      FinderExtendReadingEditView.a(this.wlI).setSelection(FinderExtendReadingEditView.a(this.wlI).getText().length());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderExtendReadingEditView$refreshTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168312);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView
 * JD-Core Version:    0.7.0.1
 */