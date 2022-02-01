package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.q;
import com.tencent.mm.ui.ai;
import d.g.a.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "flag", "getFlag", "()I", "setFlag", "(I)V", "onFlagChangedListener", "Lkotlin/Function1;", "", "getOnFlagChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnFlagChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "tipTv", "Landroid/widget/TextView;", "getTipTv", "()Landroid/widget/TextView;", "setTipTv", "(Landroid/widget/TextView;)V", "refreshView", "setOriginalFlag", "original", "plugin-finder_release"})
public final class FinderChooseOriginalView
  extends LinearLayout
{
  private b<? super Integer, d.y> Lew;
  private final String TAG;
  private int dtM;
  private TextView hJf;
  
  public FinderChooseOriginalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200031);
    this.TAG = "Finder.FinderChooseOriginalView";
    this.dtM = 1;
    setOrientation(1);
    com.tencent.mm.ui.y.js(getContext()).inflate(2131496173, (ViewGroup)this, true);
    paramContext = findViewById(2131307807);
    k.g(paramContext, "findViewById(R.id.original_tip_tv)");
    this.hJf = ((TextView)paramContext);
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200028);
        paramAnonymousView = new c(this.Lex.getContext());
        paramAnonymousView.Do(2131496240);
        Object localObject1 = (TextView)paramAnonymousView.jGG.findViewById(2131307811);
        k.g(localObject1, "titleTv");
        ai.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject1 = paramAnonymousView.jGG.findViewById(2131307812);
        Object localObject2 = paramAnonymousView.jGG.findViewById(2131307810);
        if (this.Lex.getFlag() == 1)
        {
          k.g(localObject1, "yesIv");
          ((View)localObject1).setVisibility(0);
          k.g(localObject2, "noIv");
          ((View)localObject2).setVisibility(8);
          localObject1 = q.LaJ;
          int i = q.fVU();
          localObject1 = paramAnonymousView.jGG.findViewById(2131307794);
          k.g(localObject1, "rootView.findViewById<Te…R.id.no_original_desc_tv)");
          ((TextView)localObject1).setText((CharSequence)this.Lex.getContext().getString(2131766466, new Object[] { String.valueOf(i) }));
          if (i <= 0) {
            break label286;
          }
          paramAnonymousView.jGG.findViewById(2131307804).setOnClickListener((View.OnClickListener)new a(paramAnonymousView, this));
        }
        for (;;)
        {
          paramAnonymousView.jGG.findViewById(2131307813).setOnClickListener((View.OnClickListener)new b(paramAnonymousView, this));
          paramAnonymousView.jGG.findViewById(2131307809).setOnClickListener((View.OnClickListener)new c(paramAnonymousView, this));
          paramAnonymousView.csG();
          AppMethodBeat.o(200028);
          return;
          k.g(localObject1, "yesIv");
          ((View)localObject1).setVisibility(8);
          k.g(localObject2, "noIv");
          ((View)localObject2).setVisibility(0);
          break;
          label286:
          localObject1 = paramAnonymousView.jGG.findViewById(2131307804);
          k.g(localObject1, "rootView.findViewById<Vi…(R.id.original_no_layout)");
          ((View)localObject1).setClickable(false);
          localObject1 = (TextView)paramAnonymousView.jGG.findViewById(2131307795);
          localObject2 = this.Lex.getContext();
          k.g(localObject2, "context");
          ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099677));
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$1"})
      static final class a
        implements View.OnClickListener
      {
        a(c paramc, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(200024);
          jdField_this.Lex.setOriginalFlag(2);
          this.qBy.bfo();
          AppMethodBeat.o(200024);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$2"})
      static final class b
        implements View.OnClickListener
      {
        b(c paramc, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(200025);
          jdField_this.Lex.setOriginalFlag(1);
          this.qBy.bfo();
          AppMethodBeat.o(200025);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$3"})
      static final class c
        implements View.OnClickListener
      {
        c(c paramc, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(200027);
          paramView = new c(jdField_this.Lex.getContext());
          paramView.Do(2131496236);
          paramView.jGG.findViewById(2131307276).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(200026);
              this.qBy.bfo();
              AppMethodBeat.o(200026);
            }
          });
          paramView.csG();
          this.qBy.bfo();
          AppMethodBeat.o(200027);
        }
      }
    });
    AppMethodBeat.o(200031);
  }
  
  public FinderChooseOriginalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200032);
    this.TAG = "Finder.FinderChooseOriginalView";
    this.dtM = 1;
    setOrientation(1);
    com.tencent.mm.ui.y.js(getContext()).inflate(2131496173, (ViewGroup)this, true);
    paramContext = findViewById(2131307807);
    k.g(paramContext, "findViewById(R.id.original_tip_tv)");
    this.hJf = ((TextView)paramContext);
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200028);
        paramAnonymousView = new c(this.Lex.getContext());
        paramAnonymousView.Do(2131496240);
        Object localObject1 = (TextView)paramAnonymousView.jGG.findViewById(2131307811);
        k.g(localObject1, "titleTv");
        ai.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject1 = paramAnonymousView.jGG.findViewById(2131307812);
        Object localObject2 = paramAnonymousView.jGG.findViewById(2131307810);
        if (this.Lex.getFlag() == 1)
        {
          k.g(localObject1, "yesIv");
          ((View)localObject1).setVisibility(0);
          k.g(localObject2, "noIv");
          ((View)localObject2).setVisibility(8);
          localObject1 = q.LaJ;
          int i = q.fVU();
          localObject1 = paramAnonymousView.jGG.findViewById(2131307794);
          k.g(localObject1, "rootView.findViewById<Te…R.id.no_original_desc_tv)");
          ((TextView)localObject1).setText((CharSequence)this.Lex.getContext().getString(2131766466, new Object[] { String.valueOf(i) }));
          if (i <= 0) {
            break label286;
          }
          paramAnonymousView.jGG.findViewById(2131307804).setOnClickListener((View.OnClickListener)new a(paramAnonymousView, this));
        }
        for (;;)
        {
          paramAnonymousView.jGG.findViewById(2131307813).setOnClickListener((View.OnClickListener)new b(paramAnonymousView, this));
          paramAnonymousView.jGG.findViewById(2131307809).setOnClickListener((View.OnClickListener)new c(paramAnonymousView, this));
          paramAnonymousView.csG();
          AppMethodBeat.o(200028);
          return;
          k.g(localObject1, "yesIv");
          ((View)localObject1).setVisibility(8);
          k.g(localObject2, "noIv");
          ((View)localObject2).setVisibility(0);
          break;
          label286:
          localObject1 = paramAnonymousView.jGG.findViewById(2131307804);
          k.g(localObject1, "rootView.findViewById<Vi…(R.id.original_no_layout)");
          ((View)localObject1).setClickable(false);
          localObject1 = (TextView)paramAnonymousView.jGG.findViewById(2131307795);
          localObject2 = this.Lex.getContext();
          k.g(localObject2, "context");
          ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099677));
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$1"})
      static final class a
        implements View.OnClickListener
      {
        a(c paramc, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(200024);
          jdField_this.Lex.setOriginalFlag(2);
          this.qBy.bfo();
          AppMethodBeat.o(200024);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$2"})
      static final class b
        implements View.OnClickListener
      {
        b(c paramc, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(200025);
          jdField_this.Lex.setOriginalFlag(1);
          this.qBy.bfo();
          AppMethodBeat.o(200025);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$3"})
      static final class c
        implements View.OnClickListener
      {
        c(c paramc, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(200027);
          paramView = new c(jdField_this.Lex.getContext());
          paramView.Do(2131496236);
          paramView.jGG.findViewById(2131307276).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(200026);
              this.qBy.bfo();
              AppMethodBeat.o(200026);
            }
          });
          paramView.csG();
          this.qBy.bfo();
          AppMethodBeat.o(200027);
        }
      }
    });
    AppMethodBeat.o(200032);
  }
  
  public final int getFlag()
  {
    return this.dtM;
  }
  
  public final b<Integer, d.y> getOnFlagChangedListener()
  {
    return this.Lew;
  }
  
  public final TextView getTipTv()
  {
    return this.hJf;
  }
  
  public final void setFlag(int paramInt)
  {
    this.dtM = paramInt;
  }
  
  public final void setOnFlagChangedListener(b<? super Integer, d.y> paramb)
  {
    this.Lew = paramb;
  }
  
  public final void setOriginalFlag(int paramInt)
  {
    AppMethodBeat.i(200030);
    this.dtM = paramInt;
    if (this.dtM == 1) {
      this.hJf.setText(2131766457);
    }
    for (;;)
    {
      b localb = this.Lew;
      if (localb == null) {
        break;
      }
      localb.aA(Integer.valueOf(paramInt));
      AppMethodBeat.o(200030);
      return;
      if (this.dtM == 2) {
        this.hJf.setText(2131766436);
      } else {
        this.hJf.setText((CharSequence)"");
      }
    }
    AppMethodBeat.o(200030);
  }
  
  public final void setTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(200029);
    k.h(paramTextView, "<set-?>");
    this.hJf = paramTextView;
    AppMethodBeat.o(200029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderChooseOriginalView
 * JD-Core Version:    0.7.0.1
 */