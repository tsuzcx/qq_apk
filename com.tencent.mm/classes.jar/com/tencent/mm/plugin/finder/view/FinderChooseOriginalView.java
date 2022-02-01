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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "flag", "getFlag", "()I", "setFlag", "(I)V", "onFlagChangedListener", "Lkotlin/Function1;", "", "getOnFlagChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnFlagChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "tipTv", "Landroid/widget/TextView;", "getTipTv", "()Landroid/widget/TextView;", "setTipTv", "(Landroid/widget/TextView;)V", "refreshView", "setOriginalFlag", "original", "plugin-finder_release"})
public final class FinderChooseOriginalView
  extends LinearLayout
{
  private final String TAG;
  private int dEu;
  private TextView iFP;
  private d.g.a.b<? super Integer, d.z> tdw;
  
  public FinderChooseOriginalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205686);
    this.TAG = "Finder.FinderChooseOriginalView";
    this.dEu = 1;
    setOrientation(1);
    com.tencent.mm.ui.z.jV(getContext()).inflate(2131496174, (ViewGroup)this, true);
    paramContext = findViewById(2131307899);
    p.g(paramContext, "findViewById(R.id.original_tip_tv)");
    this.iFP = ((TextView)paramContext);
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205683);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        paramAnonymousView = new d(this.tdx.getContext());
        paramAnonymousView.GC(2131496241);
        localObject1 = (TextView)paramAnonymousView.kFh.findViewById(2131307903);
        p.g(localObject1, "titleTv");
        al.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject1 = paramAnonymousView.kFh.findViewById(2131307904);
        Object localObject2 = paramAnonymousView.kFh.findViewById(2131307902);
        if (this.tdx.getFlag() == 1)
        {
          p.g(localObject1, "yesIv");
          ((View)localObject1).setVisibility(0);
          p.g(localObject2, "noIv");
          ((View)localObject2).setVisibility(8);
          localObject1 = k.sWF;
          int i = k.cNR();
          localObject1 = paramAnonymousView.kFh.findViewById(2131307886);
          p.g(localObject1, "rootView.findViewById<Te…R.id.no_original_desc_tv)");
          ((TextView)localObject1).setText((CharSequence)this.tdx.getContext().getString(2131766480, new Object[] { String.valueOf(i) }));
          if (i <= 0) {
            break label327;
          }
          paramAnonymousView.kFh.findViewById(2131307896).setOnClickListener((View.OnClickListener)new a(paramAnonymousView, this));
        }
        for (;;)
        {
          paramAnonymousView.kFh.findViewById(2131307905).setOnClickListener((View.OnClickListener)new b(paramAnonymousView, this));
          paramAnonymousView.kFh.findViewById(2131307901).setOnClickListener((View.OnClickListener)new c(paramAnonymousView, this));
          paramAnonymousView.cPF();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205683);
          return;
          p.g(localObject1, "yesIv");
          ((View)localObject1).setVisibility(8);
          p.g(localObject2, "noIv");
          ((View)localObject2).setVisibility(0);
          break;
          label327:
          localObject1 = paramAnonymousView.kFh.findViewById(2131307896);
          p.g(localObject1, "rootView.findViewById<Vi…(R.id.original_no_layout)");
          ((View)localObject1).setClickable(false);
          localObject1 = (TextView)paramAnonymousView.kFh.findViewById(2131307887);
          localObject2 = this.tdx.getContext();
          p.g(localObject2, "context");
          ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099677));
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$1"})
      static final class a
        implements View.OnClickListener
      {
        a(d paramd, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(205679);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramView);
          a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          jdField_this.tdx.setOriginalFlag(2);
          this.sqD.bqD();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205679);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$2"})
      static final class b
        implements View.OnClickListener
      {
        b(d paramd, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(205680);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramView);
          a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          jdField_this.tdx.setOriginalFlag(1);
          this.sqD.bqD();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205680);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$3"})
      static final class c
        implements View.OnClickListener
      {
        c(d paramd, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(205682);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramView);
          a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramView = new d(jdField_this.tdx.getContext());
          paramView.GC(2131496237);
          paramView.kFh.findViewById(2131307298).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(205681);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              this.sqD.bqD();
              a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(205681);
            }
          });
          paramView.cPF();
          this.sqD.bqD();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205682);
        }
      }
    });
    AppMethodBeat.o(205686);
  }
  
  public FinderChooseOriginalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205687);
    this.TAG = "Finder.FinderChooseOriginalView";
    this.dEu = 1;
    setOrientation(1);
    com.tencent.mm.ui.z.jV(getContext()).inflate(2131496174, (ViewGroup)this, true);
    paramContext = findViewById(2131307899);
    p.g(paramContext, "findViewById(R.id.original_tip_tv)");
    this.iFP = ((TextView)paramContext);
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205683);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        paramAnonymousView = new d(this.tdx.getContext());
        paramAnonymousView.GC(2131496241);
        localObject1 = (TextView)paramAnonymousView.kFh.findViewById(2131307903);
        p.g(localObject1, "titleTv");
        al.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject1 = paramAnonymousView.kFh.findViewById(2131307904);
        Object localObject2 = paramAnonymousView.kFh.findViewById(2131307902);
        if (this.tdx.getFlag() == 1)
        {
          p.g(localObject1, "yesIv");
          ((View)localObject1).setVisibility(0);
          p.g(localObject2, "noIv");
          ((View)localObject2).setVisibility(8);
          localObject1 = k.sWF;
          int i = k.cNR();
          localObject1 = paramAnonymousView.kFh.findViewById(2131307886);
          p.g(localObject1, "rootView.findViewById<Te…R.id.no_original_desc_tv)");
          ((TextView)localObject1).setText((CharSequence)this.tdx.getContext().getString(2131766480, new Object[] { String.valueOf(i) }));
          if (i <= 0) {
            break label327;
          }
          paramAnonymousView.kFh.findViewById(2131307896).setOnClickListener((View.OnClickListener)new a(paramAnonymousView, this));
        }
        for (;;)
        {
          paramAnonymousView.kFh.findViewById(2131307905).setOnClickListener((View.OnClickListener)new b(paramAnonymousView, this));
          paramAnonymousView.kFh.findViewById(2131307901).setOnClickListener((View.OnClickListener)new c(paramAnonymousView, this));
          paramAnonymousView.cPF();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205683);
          return;
          p.g(localObject1, "yesIv");
          ((View)localObject1).setVisibility(8);
          p.g(localObject2, "noIv");
          ((View)localObject2).setVisibility(0);
          break;
          label327:
          localObject1 = paramAnonymousView.kFh.findViewById(2131307896);
          p.g(localObject1, "rootView.findViewById<Vi…(R.id.original_no_layout)");
          ((View)localObject1).setClickable(false);
          localObject1 = (TextView)paramAnonymousView.kFh.findViewById(2131307887);
          localObject2 = this.tdx.getContext();
          p.g(localObject2, "context");
          ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099677));
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$1"})
      static final class a
        implements View.OnClickListener
      {
        a(d paramd, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(205679);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramView);
          a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          jdField_this.tdx.setOriginalFlag(2);
          this.sqD.bqD();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205679);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$2"})
      static final class b
        implements View.OnClickListener
      {
        b(d paramd, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(205680);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramView);
          a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          jdField_this.tdx.setOriginalFlag(1);
          this.sqD.bqD();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205680);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$3"})
      static final class c
        implements View.OnClickListener
      {
        c(d paramd, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(205682);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramView);
          a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramView = new d(jdField_this.tdx.getContext());
          paramView.GC(2131496237);
          paramView.kFh.findViewById(2131307298).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(205681);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              this.sqD.bqD();
              a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(205681);
            }
          });
          paramView.cPF();
          this.sqD.bqD();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205682);
        }
      }
    });
    AppMethodBeat.o(205687);
  }
  
  public final int getFlag()
  {
    return this.dEu;
  }
  
  public final d.g.a.b<Integer, d.z> getOnFlagChangedListener()
  {
    return this.tdw;
  }
  
  public final TextView getTipTv()
  {
    return this.iFP;
  }
  
  public final void setFlag(int paramInt)
  {
    this.dEu = paramInt;
  }
  
  public final void setOnFlagChangedListener(d.g.a.b<? super Integer, d.z> paramb)
  {
    this.tdw = paramb;
  }
  
  public final void setOriginalFlag(int paramInt)
  {
    AppMethodBeat.i(205685);
    this.dEu = paramInt;
    if (this.dEu == 1) {
      this.iFP.setText(2131766471);
    }
    for (;;)
    {
      d.g.a.b localb = this.tdw;
      if (localb == null) {
        break;
      }
      localb.invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(205685);
      return;
      if (this.dEu == 2) {
        this.iFP.setText(2131766452);
      } else {
        this.iFP.setText((CharSequence)"");
      }
    }
    AppMethodBeat.o(205685);
  }
  
  public final void setTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(205684);
    p.h(paramTextView, "<set-?>");
    this.iFP = paramTextView;
    AppMethodBeat.o(205684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderChooseOriginalView
 * JD-Core Version:    0.7.0.1
 */