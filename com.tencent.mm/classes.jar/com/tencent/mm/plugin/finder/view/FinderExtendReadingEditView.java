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
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingEditView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addBtn", "Landroid/widget/TextView;", "bgView", "Landroid/view/View;", "closeBtn", "onAddListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "", "onCloseListener", "Lkotlin/Function0;", "tipsTv", "titleTv", "urlEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "checkEnableAdd", "isUrlValid", "", "url", "refreshTips", "requestEditFocus", "setListener", "plugin-finder_release"})
public final class FinderExtendReadingEditView
  extends RelativeLayout
{
  private final String TAG;
  private final TextView nkw;
  public b<? super String, d.y> qWu;
  public a<d.y> qWv;
  private final View qWw;
  private final TextView qWx;
  public final MMEditText qWy;
  private final View qeH;
  private final TextView titleTv;
  
  public FinderExtendReadingEditView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168315);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = com.tencent.mm.ui.y.js(getContext()).inflate(2131494030, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    final View localView = paramContext.findViewById(2131299994);
    k.g(localView, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.qWw = localView;
    localView = paramContext.findViewById(2131299992);
    k.g(localView, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.qWx = ((TextView)localView);
    localView = paramContext.findViewById(2131305948);
    k.g(localView, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)localView);
    ai.a((Paint)this.titleTv.getPaint(), 0.8F);
    localView = findViewById(2131303783);
    localView.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.qWz.getContext();
        k.g(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        k.g(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.qWz.getContext();
        k.g(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        k.g(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + aq.eb(this.qWz.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    localView = paramContext.findViewById(2131299995);
    k.g(localView, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.qWy = ((MMEditText)localView);
    localView = paramContext.findViewById(2131299996);
    k.g(localView, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.nkw = ((TextView)localView);
    paramContext = paramContext.findViewById(2131299993);
    k.g(paramContext, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.qeH = paramContext;
    this.qWw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        paramAnonymousView = FinderExtendReadingEditView.d(this.qWz);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(168308);
          return;
        }
        AppMethodBeat.o(168308);
      }
    });
    this.qeH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        paramAnonymousView = FinderExtendReadingEditView.d(this.qWz);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(168309);
          return;
        }
        AppMethodBeat.o(168309);
      }
    });
    this.qWy.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.qWz.csO();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    csN();
    csO();
    AppMethodBeat.o(168315);
  }
  
  public FinderExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168316);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = com.tencent.mm.ui.y.js(getContext()).inflate(2131494030, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    paramAttributeSet = paramContext.findViewById(2131299994);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.qWw = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299992);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.qWx = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131305948);
    k.g(paramAttributeSet, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    ai.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramAttributeSet = findViewById(2131303783);
    paramAttributeSet.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.qWz.getContext();
        k.g(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        k.g(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.qWz.getContext();
        k.g(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        k.g(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + aq.eb(this.qWz.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    paramAttributeSet = paramContext.findViewById(2131299995);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.qWy = ((MMEditText)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299996);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.nkw = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131299993);
    k.g(paramContext, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.qeH = paramContext;
    this.qWw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        paramAnonymousView = FinderExtendReadingEditView.d(this.qWz);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(168308);
          return;
        }
        AppMethodBeat.o(168308);
      }
    });
    this.qeH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        paramAnonymousView = FinderExtendReadingEditView.d(this.qWz);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(168309);
          return;
        }
        AppMethodBeat.o(168309);
      }
    });
    this.qWy.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.qWz.csO();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    csN();
    csO();
    AppMethodBeat.o(168316);
  }
  
  public FinderExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168317);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = com.tencent.mm.ui.y.js(getContext()).inflate(2131494030, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    paramAttributeSet = paramContext.findViewById(2131299994);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.qWw = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299992);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.qWx = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131305948);
    k.g(paramAttributeSet, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    ai.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramAttributeSet = findViewById(2131303783);
    paramAttributeSet.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.qWz.getContext();
        k.g(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        k.g(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.qWz.getContext();
        k.g(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        k.g(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + aq.eb(this.qWz.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    paramAttributeSet = paramContext.findViewById(2131299995);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.qWy = ((MMEditText)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299996);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.nkw = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131299993);
    k.g(paramContext, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.qeH = paramContext;
    this.qWw.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        paramAnonymousView = FinderExtendReadingEditView.d(this.qWz);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(168308);
          return;
        }
        AppMethodBeat.o(168308);
      }
    });
    this.qeH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        paramAnonymousView = FinderExtendReadingEditView.d(this.qWz);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(168309);
          return;
        }
        AppMethodBeat.o(168309);
      }
    });
    this.qWy.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.qWz.csO();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    csN();
    csO();
    AppMethodBeat.o(168317);
  }
  
  public final void csN()
  {
    AppMethodBeat.i(168313);
    Object localObject = i.qTa;
    localObject = i.crU();
    if (!bt.isNullOrNil((String)localObject))
    {
      k.h(localObject, "url");
      if (bt.isNullOrNil((String)localObject)) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i == 0; i = 0)
    {
      this.nkw.setVisibility(8);
      AppMethodBeat.o(168313);
      return;
    }
    if (k.g(this.qWy.getText().toString(), localObject))
    {
      this.nkw.setVisibility(8);
      AppMethodBeat.o(168313);
      return;
    }
    this.nkw.setVisibility(0);
    this.nkw.setText((CharSequence)getContext().getString(2131759201, new Object[] { localObject }));
    this.nkw.setOnClickListener((View.OnClickListener)new b(this, (String)localObject));
    AppMethodBeat.o(168313);
  }
  
  public final void csO()
  {
    AppMethodBeat.i(168314);
    final String str = this.qWy.getText().toString();
    if (!bt.isNullOrNil(str))
    {
      this.qWx.setOnClickListener((View.OnClickListener)new a(this, str));
      this.qWx.setTextColor(getResources().getColor(2131099828));
      this.qWx.setBackgroundResource(2131232336);
      AppMethodBeat.o(168314);
      return;
    }
    this.qWx.setOnClickListener(null);
    this.qWx.setTextColor(getResources().getColor(2131100368));
    this.qWx.setBackgroundResource(2131232335);
    AppMethodBeat.o(168314);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderExtendReadingEditView paramFinderExtendReadingEditView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168311);
      FinderExtendReadingEditView.c(this.qWz).aA(str);
      FinderExtendReadingEditView.a(this.qWz).setText((CharSequence)"");
      AppMethodBeat.o(168311);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderExtendReadingEditView paramFinderExtendReadingEditView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168312);
      FinderExtendReadingEditView.a(this.qWz).setText((CharSequence)this.qWB);
      FinderExtendReadingEditView.b(this.qWz).setVisibility(8);
      FinderExtendReadingEditView.a(this.qWz).setSelection(FinderExtendReadingEditView.a(this.qWz).getText().length());
      AppMethodBeat.o(168312);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView
 * JD-Core Version:    0.7.0.1
 */