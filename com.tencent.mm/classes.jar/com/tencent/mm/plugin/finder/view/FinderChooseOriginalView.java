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
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "flag", "getFlag", "()I", "setFlag", "(I)V", "onFlagChangedListener", "Lkotlin/Function1;", "", "getOnFlagChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnFlagChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "tipTv", "Landroid/widget/TextView;", "getTipTv", "()Landroid/widget/TextView;", "setTipTv", "(Landroid/widget/TextView;)V", "refreshView", "setOriginalFlag", "original", "plugin-finder_release"})
public final class FinderChooseOriginalView
  extends LinearLayout
{
  private kotlin.g.a.b<? super Integer, x> AUP;
  private final String TAG;
  private int cUP;
  private TextView mrN;
  
  public FinderChooseOriginalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(291378);
    this.TAG = "Finder.FinderChooseOriginalView";
    this.cUP = 1;
    setOrientation(1);
    ad.kS(getContext()).inflate(b.g.finder_choose_original_view, (ViewGroup)this, true);
    paramContext = findViewById(b.f.original_tip_tv);
    p.j(paramContext, "findViewById(R.id.original_tip_tv)");
    this.mrN = ((TextView)paramContext);
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(267924);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramAnonymousView = new e(this.AUQ.getContext());
        paramAnonymousView.RB(b.g.finder_original_type_bottom_sheet);
        localObject1 = (TextView)paramAnonymousView.oFW.findViewById(b.f.original_type_title);
        p.j(localObject1, "titleTv");
        ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject1 = paramAnonymousView.oFW.findViewById(b.f.original_type_yes_iv);
        Object localObject2 = paramAnonymousView.oFW.findViewById(b.f.original_type_no_iv);
        if (this.AUQ.getFlag() == 1)
        {
          p.j(localObject1, "yesIv");
          ((View)localObject1).setVisibility(0);
          p.j(localObject2, "noIv");
          ((View)localObject2).setVisibility(8);
          localObject1 = v.ADV;
          int i = v.edi();
          localObject1 = paramAnonymousView.oFW.findViewById(b.f.no_original_desc_tv);
          p.j(localObject1, "rootView.findViewById<Te…R.id.no_original_desc_tv)");
          ((TextView)localObject1).setText((CharSequence)this.AUQ.getContext().getString(b.j.finder_original_type_no_desc, new Object[] { String.valueOf(i) }));
          if (i <= 0) {
            break label336;
          }
          paramAnonymousView.oFW.findViewById(b.f.original_no_layout).setOnClickListener((View.OnClickListener)new a(paramAnonymousView, this));
        }
        for (;;)
        {
          paramAnonymousView.oFW.findViewById(b.f.original_yes_layout).setOnClickListener((View.OnClickListener)new b(paramAnonymousView, this));
          paramAnonymousView.oFW.findViewById(b.f.original_type_help).setOnClickListener((View.OnClickListener)new c(paramAnonymousView, this));
          paramAnonymousView.eik();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(267924);
          return;
          p.j(localObject1, "yesIv");
          ((View)localObject1).setVisibility(8);
          p.j(localObject2, "noIv");
          ((View)localObject2).setVisibility(0);
          break;
          label336:
          localObject1 = paramAnonymousView.oFW.findViewById(b.f.original_no_layout);
          p.j(localObject1, "rootView.findViewById<Vi…(R.id.original_no_layout)");
          ((View)localObject1).setClickable(false);
          localObject1 = (TextView)paramAnonymousView.oFW.findViewById(b.f.no_original_title_tv);
          localObject2 = this.AUQ.getContext();
          p.j(localObject2, "context");
          ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.BW_70));
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$1"})
      static final class a
        implements View.OnClickListener
      {
        a(e parame, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(290152);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramView);
          a.c("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          jdField_this.AUQ.setOriginalFlag(2);
          this.wZH.bYF();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(290152);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$2"})
      static final class b
        implements View.OnClickListener
      {
        b(e parame, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(279722);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramView);
          a.c("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          jdField_this.AUQ.setOriginalFlag(1);
          this.wZH.bYF();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279722);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$3"})
      static final class c
        implements View.OnClickListener
      {
        c(e parame, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(281491);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramView);
          a.c("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramView = new e(jdField_this.AUQ.getContext());
          paramView.RB(b.g.finder_original_define_bottom_sheet);
          paramView.oFW.findViewById(b.f.close_bottom_sheet_layout).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(267023);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              a.c("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              this.wZH.bYF();
              a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(267023);
            }
          });
          paramView.eik();
          this.wZH.bYF();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(281491);
        }
      }
    });
    AppMethodBeat.o(291378);
  }
  
  public FinderChooseOriginalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(291379);
    this.TAG = "Finder.FinderChooseOriginalView";
    this.cUP = 1;
    setOrientation(1);
    ad.kS(getContext()).inflate(b.g.finder_choose_original_view, (ViewGroup)this, true);
    paramContext = findViewById(b.f.original_tip_tv);
    p.j(paramContext, "findViewById(R.id.original_tip_tv)");
    this.mrN = ((TextView)paramContext);
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(267924);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramAnonymousView = new e(this.AUQ.getContext());
        paramAnonymousView.RB(b.g.finder_original_type_bottom_sheet);
        localObject1 = (TextView)paramAnonymousView.oFW.findViewById(b.f.original_type_title);
        p.j(localObject1, "titleTv");
        ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject1 = paramAnonymousView.oFW.findViewById(b.f.original_type_yes_iv);
        Object localObject2 = paramAnonymousView.oFW.findViewById(b.f.original_type_no_iv);
        if (this.AUQ.getFlag() == 1)
        {
          p.j(localObject1, "yesIv");
          ((View)localObject1).setVisibility(0);
          p.j(localObject2, "noIv");
          ((View)localObject2).setVisibility(8);
          localObject1 = v.ADV;
          int i = v.edi();
          localObject1 = paramAnonymousView.oFW.findViewById(b.f.no_original_desc_tv);
          p.j(localObject1, "rootView.findViewById<Te…R.id.no_original_desc_tv)");
          ((TextView)localObject1).setText((CharSequence)this.AUQ.getContext().getString(b.j.finder_original_type_no_desc, new Object[] { String.valueOf(i) }));
          if (i <= 0) {
            break label336;
          }
          paramAnonymousView.oFW.findViewById(b.f.original_no_layout).setOnClickListener((View.OnClickListener)new a(paramAnonymousView, this));
        }
        for (;;)
        {
          paramAnonymousView.oFW.findViewById(b.f.original_yes_layout).setOnClickListener((View.OnClickListener)new b(paramAnonymousView, this));
          paramAnonymousView.oFW.findViewById(b.f.original_type_help).setOnClickListener((View.OnClickListener)new c(paramAnonymousView, this));
          paramAnonymousView.eik();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(267924);
          return;
          p.j(localObject1, "yesIv");
          ((View)localObject1).setVisibility(8);
          p.j(localObject2, "noIv");
          ((View)localObject2).setVisibility(0);
          break;
          label336:
          localObject1 = paramAnonymousView.oFW.findViewById(b.f.original_no_layout);
          p.j(localObject1, "rootView.findViewById<Vi…(R.id.original_no_layout)");
          ((View)localObject1).setClickable(false);
          localObject1 = (TextView)paramAnonymousView.oFW.findViewById(b.f.no_original_title_tv);
          localObject2 = this.AUQ.getContext();
          p.j(localObject2, "context");
          ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.BW_70));
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$1"})
      static final class a
        implements View.OnClickListener
      {
        a(e parame, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(290152);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramView);
          a.c("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          jdField_this.AUQ.setOriginalFlag(2);
          this.wZH.bYF();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(290152);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$2"})
      static final class b
        implements View.OnClickListener
      {
        b(e parame, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(279722);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramView);
          a.c("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          jdField_this.AUQ.setOriginalFlag(1);
          this.wZH.bYF();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279722);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$3"})
      static final class c
        implements View.OnClickListener
      {
        c(e parame, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(281491);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramView);
          a.c("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramView = new e(jdField_this.AUQ.getContext());
          paramView.RB(b.g.finder_original_define_bottom_sheet);
          paramView.oFW.findViewById(b.f.close_bottom_sheet_layout).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(267023);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              a.c("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              this.wZH.bYF();
              a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(267023);
            }
          });
          paramView.eik();
          this.wZH.bYF();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(281491);
        }
      }
    });
    AppMethodBeat.o(291379);
  }
  
  public final int getFlag()
  {
    return this.cUP;
  }
  
  public final kotlin.g.a.b<Integer, x> getOnFlagChangedListener()
  {
    return this.AUP;
  }
  
  public final TextView getTipTv()
  {
    return this.mrN;
  }
  
  public final void setFlag(int paramInt)
  {
    this.cUP = paramInt;
  }
  
  public final void setOnFlagChangedListener(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.AUP = paramb;
  }
  
  public final void setOriginalFlag(int paramInt)
  {
    AppMethodBeat.i(291377);
    this.cUP = paramInt;
    if (this.cUP == 1) {
      this.mrN.setText(b.j.finder_original_feed_tip);
    }
    for (;;)
    {
      kotlin.g.a.b localb = this.AUP;
      if (localb == null) {
        break;
      }
      localb.invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(291377);
      return;
      if (this.cUP == 2) {
        this.mrN.setText(b.j.finder_no_original_feed_tip);
      } else {
        this.mrN.setText((CharSequence)"");
      }
    }
    AppMethodBeat.o(291377);
  }
  
  public final void setTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(291376);
    p.k(paramTextView, "<set-?>");
    this.mrN = paramTextView;
    AppMethodBeat.o(291376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderChooseOriginalView
 * JD-Core Version:    0.7.0.1
 */