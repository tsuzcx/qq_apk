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
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.z;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderExtendReadingEditView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addBtn", "Landroid/widget/TextView;", "bgView", "Landroid/view/View;", "closeBtn", "onAddListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "link", "", "onCloseListener", "Lkotlin/Function0;", "tipsTv", "titleTv", "urlEditText", "Lcom/tencent/mm/ui/widget/MMEditText;", "checkEnableAdd", "isUrlValid", "", "url", "refreshTips", "requestEditFocus", "setListener", "plugin-finder_release"})
public final class FinderExtendReadingEditView
  extends RelativeLayout
{
  private final String TAG;
  private final View gBO;
  private final TextView nNp;
  private final View qNk;
  public b<? super String, y> rWJ;
  public a<y> rWK;
  private final TextView rWL;
  public final MMEditText rWM;
  private final TextView titleTv;
  
  public FinderExtendReadingEditView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168315);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = z.jD(getContext()).inflate(2131494030, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    final View localView = paramContext.findViewById(2131299994);
    k.g(localView, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.gBO = localView;
    localView = paramContext.findViewById(2131299992);
    k.g(localView, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.rWL = ((TextView)localView);
    localView = paramContext.findViewById(2131305948);
    k.g(localView, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)localView);
    aj.a((Paint)this.titleTv.getPaint(), 0.8F);
    localView = findViewById(2131303783);
    localView.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.rWN.getContext();
        k.g(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        k.g(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.rWN.getContext();
        k.g(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        k.g(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + aq.ej(this.rWN.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    localView = paramContext.findViewById(2131299995);
    k.g(localView, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.rWM = ((MMEditText)localView);
    localView = paramContext.findViewById(2131299996);
    k.g(localView, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.nNp = ((TextView)localView);
    paramContext = paramContext.findViewById(2131299993);
    k.g(paramContext, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.qNk = paramContext;
    this.gBO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        paramAnonymousView = FinderExtendReadingEditView.d(this.rWN);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(168308);
          return;
        }
        AppMethodBeat.o(168308);
      }
    });
    this.qNk.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        paramAnonymousView = FinderExtendReadingEditView.d(this.rWN);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(168309);
          return;
        }
        AppMethodBeat.o(168309);
      }
    });
    this.rWM.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.rWN.cEP();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    cEO();
    cEP();
    AppMethodBeat.o(168315);
  }
  
  public FinderExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168316);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = z.jD(getContext()).inflate(2131494030, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    paramAttributeSet = paramContext.findViewById(2131299994);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.gBO = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299992);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.rWL = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131305948);
    k.g(paramAttributeSet, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    aj.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramAttributeSet = findViewById(2131303783);
    paramAttributeSet.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.rWN.getContext();
        k.g(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        k.g(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.rWN.getContext();
        k.g(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        k.g(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + aq.ej(this.rWN.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    paramAttributeSet = paramContext.findViewById(2131299995);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.rWM = ((MMEditText)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299996);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.nNp = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131299993);
    k.g(paramContext, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.qNk = paramContext;
    this.gBO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        paramAnonymousView = FinderExtendReadingEditView.d(this.rWN);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(168308);
          return;
        }
        AppMethodBeat.o(168308);
      }
    });
    this.qNk.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        paramAnonymousView = FinderExtendReadingEditView.d(this.rWN);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(168309);
          return;
        }
        AppMethodBeat.o(168309);
      }
    });
    this.rWM.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.rWN.cEP();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    cEO();
    cEP();
    AppMethodBeat.o(168316);
  }
  
  public FinderExtendReadingEditView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168317);
    this.TAG = "Finder.FinderExtendReadingEditView";
    paramContext = z.jD(getContext()).inflate(2131494030, null);
    addView(paramContext, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    paramAttributeSet = paramContext.findViewById(2131299994);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…xtend_reading_edit_close)");
    this.gBO = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(2131299992);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…_extend_reading_edit_add)");
    this.rWL = ((TextView)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131305948);
    k.g(paramAttributeSet, "view.findViewById(R.id.title_tv)");
    this.titleTv = ((TextView)paramAttributeSet);
    aj.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramAttributeSet = findViewById(2131303783);
    paramAttributeSet.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168307);
        View localView = localView;
        Object localObject = this.rWN.getContext();
        k.g(localObject, "context");
        int i = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        k.g(localObject, "layout");
        int j = ((View)localObject).getTop();
        localObject = this.rWN.getContext();
        k.g(localObject, "context");
        int k = (int)((Context)localObject).getResources().getDimension(2131165289);
        localObject = localView;
        k.g(localObject, "layout");
        localView.setPadding(i, j, k, ((View)localObject).getBottom() + aq.ej(this.rWN.getContext()));
        AppMethodBeat.o(168307);
      }
    });
    paramAttributeSet = paramContext.findViewById(2131299995);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…r_extend_reading_edit_et)");
    this.rWM = ((MMEditText)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(2131299996);
    k.g(paramAttributeSet, "view.findViewById(R.id.f…extend_reading_edit_tips)");
    this.nNp = ((TextView)paramAttributeSet);
    paramContext = paramContext.findViewById(2131299993);
    k.g(paramContext, "view.findViewById(R.id.f…r_extend_reading_edit_bg)");
    this.qNk = paramContext;
    this.gBO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168308);
        paramAnonymousView = FinderExtendReadingEditView.d(this.rWN);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(168308);
          return;
        }
        AppMethodBeat.o(168308);
      }
    });
    this.qNk.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(168309);
        paramAnonymousView = FinderExtendReadingEditView.d(this.rWN);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(168309);
          return;
        }
        AppMethodBeat.o(168309);
      }
    });
    this.rWM.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(168310);
        this.rWN.cEP();
        AppMethodBeat.o(168310);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    cEO();
    cEP();
    AppMethodBeat.o(168317);
  }
  
  public final void cEO()
  {
    AppMethodBeat.i(168313);
    Object localObject = n.rPN;
    localObject = n.cDi();
    if (!bs.isNullOrNil((String)localObject))
    {
      k.h(localObject, "url");
      if (bs.isNullOrNil((String)localObject)) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i == 0; i = 0)
    {
      this.nNp.setVisibility(8);
      AppMethodBeat.o(168313);
      return;
    }
    if (k.g(this.rWM.getText().toString(), localObject))
    {
      this.nNp.setVisibility(8);
      AppMethodBeat.o(168313);
      return;
    }
    this.nNp.setVisibility(0);
    this.nNp.setText((CharSequence)getContext().getString(2131759201, new Object[] { localObject }));
    this.nNp.setOnClickListener((View.OnClickListener)new b(this, (String)localObject));
    AppMethodBeat.o(168313);
  }
  
  public final void cEP()
  {
    AppMethodBeat.i(168314);
    final String str = this.rWM.getText().toString();
    if (!bs.isNullOrNil(str))
    {
      this.rWL.setOnClickListener((View.OnClickListener)new a(this, str));
      this.rWL.setTextColor(getResources().getColor(2131099828));
      this.rWL.setBackgroundResource(2131232336);
      AppMethodBeat.o(168314);
      return;
    }
    this.rWL.setOnClickListener(null);
    this.rWL.setTextColor(getResources().getColor(2131100368));
    this.rWL.setBackgroundResource(2131232335);
    AppMethodBeat.o(168314);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderExtendReadingEditView paramFinderExtendReadingEditView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168311);
      FinderExtendReadingEditView.c(this.rWN).ay(str);
      FinderExtendReadingEditView.a(this.rWN).setText((CharSequence)"");
      AppMethodBeat.o(168311);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderExtendReadingEditView paramFinderExtendReadingEditView, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168312);
      FinderExtendReadingEditView.a(this.rWN).setText((CharSequence)this.rWP);
      FinderExtendReadingEditView.b(this.rWN).setVisibility(8);
      FinderExtendReadingEditView.a(this.rWN).setSelection(FinderExtendReadingEditView.a(this.rWN).getText().length());
      AppMethodBeat.o(168312);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExtendReadingEditView
 * JD-Core Version:    0.7.0.1
 */