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
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "flag", "getFlag", "()I", "setFlag", "(I)V", "onFlagChangedListener", "Lkotlin/Function1;", "", "getOnFlagChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnFlagChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "tipTv", "Landroid/widget/TextView;", "getTipTv", "()Landroid/widget/TextView;", "setTipTv", "(Landroid/widget/TextView;)V", "refreshView", "setOriginalFlag", "original", "plugin-finder_release"})
public final class FinderChooseOriginalView
  extends LinearLayout
{
  private final String TAG;
  private int cSx;
  private TextView jBS;
  private kotlin.g.a.b<? super Integer, x> wjV;
  
  public FinderChooseOriginalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254687);
    this.TAG = "Finder.FinderChooseOriginalView";
    this.cSx = 1;
    setOrientation(1);
    aa.jQ(getContext()).inflate(2131494216, (ViewGroup)this, true);
    paramContext = findViewById(2131305716);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.original_tip_tv)");
    this.jBS = ((TextView)paramContext);
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(254684);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramAnonymousView = new d(this.wjW.getContext());
        paramAnonymousView.Ml(2131494556);
        localObject1 = (TextView)paramAnonymousView.lJI.findViewById(2131305720);
        kotlin.g.b.p.g(localObject1, "titleTv");
        ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject1 = paramAnonymousView.lJI.findViewById(2131305721);
        Object localObject2 = paramAnonymousView.lJI.findViewById(2131305719);
        if (this.wjW.getFlag() == 1)
        {
          kotlin.g.b.p.g(localObject1, "yesIv");
          ((View)localObject1).setVisibility(0);
          kotlin.g.b.p.g(localObject2, "noIv");
          ((View)localObject2).setVisibility(8);
          localObject1 = com.tencent.mm.plugin.finder.utils.p.vVY;
          int i = com.tencent.mm.plugin.finder.utils.p.dBU();
          localObject1 = paramAnonymousView.lJI.findViewById(2131305453);
          kotlin.g.b.p.g(localObject1, "rootView.findViewById<Te…R.id.no_original_desc_tv)");
          ((TextView)localObject1).setText((CharSequence)this.wjW.getContext().getString(2131760395, new Object[] { String.valueOf(i) }));
          if (i <= 0) {
            break label327;
          }
          paramAnonymousView.lJI.findViewById(2131305711).setOnClickListener((View.OnClickListener)new a(paramAnonymousView, this));
        }
        for (;;)
        {
          paramAnonymousView.lJI.findViewById(2131305722).setOnClickListener((View.OnClickListener)new b(paramAnonymousView, this));
          paramAnonymousView.lJI.findViewById(2131305718).setOnClickListener((View.OnClickListener)new c(paramAnonymousView, this));
          paramAnonymousView.dGm();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254684);
          return;
          kotlin.g.b.p.g(localObject1, "yesIv");
          ((View)localObject1).setVisibility(8);
          kotlin.g.b.p.g(localObject2, "noIv");
          ((View)localObject2).setVisibility(0);
          break;
          label327:
          localObject1 = paramAnonymousView.lJI.findViewById(2131305711);
          kotlin.g.b.p.g(localObject1, "rootView.findViewById<Vi…(R.id.original_no_layout)");
          ((View)localObject1).setClickable(false);
          localObject1 = (TextView)paramAnonymousView.lJI.findViewById(2131305454);
          localObject2 = this.wjW.getContext();
          kotlin.g.b.p.g(localObject2, "context");
          ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099685));
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$1"})
      static final class a
        implements View.OnClickListener
      {
        a(d paramd, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(254680);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramView);
          a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          jdField_this.wjW.setOriginalFlag(2);
          this.tru.bMo();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254680);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$2"})
      static final class b
        implements View.OnClickListener
      {
        b(d paramd, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(254681);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramView);
          a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          jdField_this.wjW.setOriginalFlag(1);
          this.tru.bMo();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254681);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$3"})
      static final class c
        implements View.OnClickListener
      {
        c(d paramd, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(254683);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramView);
          a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramView = new d(jdField_this.wjW.getContext());
          paramView.Ml(2131494551);
          paramView.lJI.findViewById(2131298769).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(254682);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              this.tru.bMo();
              a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(254682);
            }
          });
          paramView.dGm();
          this.tru.bMo();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254683);
        }
      }
    });
    AppMethodBeat.o(254687);
  }
  
  public FinderChooseOriginalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254688);
    this.TAG = "Finder.FinderChooseOriginalView";
    this.cSx = 1;
    setOrientation(1);
    aa.jQ(getContext()).inflate(2131494216, (ViewGroup)this, true);
    paramContext = findViewById(2131305716);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.original_tip_tv)");
    this.jBS = ((TextView)paramContext);
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(254684);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramAnonymousView = new d(this.wjW.getContext());
        paramAnonymousView.Ml(2131494556);
        localObject1 = (TextView)paramAnonymousView.lJI.findViewById(2131305720);
        kotlin.g.b.p.g(localObject1, "titleTv");
        ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject1 = paramAnonymousView.lJI.findViewById(2131305721);
        Object localObject2 = paramAnonymousView.lJI.findViewById(2131305719);
        if (this.wjW.getFlag() == 1)
        {
          kotlin.g.b.p.g(localObject1, "yesIv");
          ((View)localObject1).setVisibility(0);
          kotlin.g.b.p.g(localObject2, "noIv");
          ((View)localObject2).setVisibility(8);
          localObject1 = com.tencent.mm.plugin.finder.utils.p.vVY;
          int i = com.tencent.mm.plugin.finder.utils.p.dBU();
          localObject1 = paramAnonymousView.lJI.findViewById(2131305453);
          kotlin.g.b.p.g(localObject1, "rootView.findViewById<Te…R.id.no_original_desc_tv)");
          ((TextView)localObject1).setText((CharSequence)this.wjW.getContext().getString(2131760395, new Object[] { String.valueOf(i) }));
          if (i <= 0) {
            break label327;
          }
          paramAnonymousView.lJI.findViewById(2131305711).setOnClickListener((View.OnClickListener)new a(paramAnonymousView, this));
        }
        for (;;)
        {
          paramAnonymousView.lJI.findViewById(2131305722).setOnClickListener((View.OnClickListener)new b(paramAnonymousView, this));
          paramAnonymousView.lJI.findViewById(2131305718).setOnClickListener((View.OnClickListener)new c(paramAnonymousView, this));
          paramAnonymousView.dGm();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254684);
          return;
          kotlin.g.b.p.g(localObject1, "yesIv");
          ((View)localObject1).setVisibility(8);
          kotlin.g.b.p.g(localObject2, "noIv");
          ((View)localObject2).setVisibility(0);
          break;
          label327:
          localObject1 = paramAnonymousView.lJI.findViewById(2131305711);
          kotlin.g.b.p.g(localObject1, "rootView.findViewById<Vi…(R.id.original_no_layout)");
          ((View)localObject1).setClickable(false);
          localObject1 = (TextView)paramAnonymousView.lJI.findViewById(2131305454);
          localObject2 = this.wjW.getContext();
          kotlin.g.b.p.g(localObject2, "context");
          ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099685));
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$1"})
      static final class a
        implements View.OnClickListener
      {
        a(d paramd, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(254680);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramView);
          a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          jdField_this.wjW.setOriginalFlag(2);
          this.tru.bMo();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254680);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$2"})
      static final class b
        implements View.OnClickListener
      {
        b(d paramd, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(254681);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramView);
          a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          jdField_this.wjW.setOriginalFlag(1);
          this.tru.bMo();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254681);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$3"})
      static final class c
        implements View.OnClickListener
      {
        c(d paramd, FinderChooseOriginalView.1 param1) {}
        
        public final void onClick(View paramView)
        {
          AppMethodBeat.i(254683);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramView);
          a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramView = new d(jdField_this.wjW.getContext());
          paramView.Ml(2131494551);
          paramView.lJI.findViewById(2131298769).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(254682);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              a.b("com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              this.tru.bMo();
              a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(254682);
            }
          });
          paramView.dGm();
          this.tru.bMo();
          a.a(this, "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$$special$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254683);
        }
      }
    });
    AppMethodBeat.o(254688);
  }
  
  public final int getFlag()
  {
    return this.cSx;
  }
  
  public final kotlin.g.a.b<Integer, x> getOnFlagChangedListener()
  {
    return this.wjV;
  }
  
  public final TextView getTipTv()
  {
    return this.jBS;
  }
  
  public final void setFlag(int paramInt)
  {
    this.cSx = paramInt;
  }
  
  public final void setOnFlagChangedListener(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.wjV = paramb;
  }
  
  public final void setOriginalFlag(int paramInt)
  {
    AppMethodBeat.i(254686);
    this.cSx = paramInt;
    if (this.cSx == 1) {
      this.jBS.setText(2131760385);
    }
    for (;;)
    {
      kotlin.g.a.b localb = this.wjV;
      if (localb == null) {
        break;
      }
      localb.invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(254686);
      return;
      if (this.cSx == 2) {
        this.jBS.setText(2131760343);
      } else {
        this.jBS.setText((CharSequence)"");
      }
    }
    AppMethodBeat.o(254686);
  }
  
  public final void setTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(254685);
    kotlin.g.b.p.h(paramTextView, "<set-?>");
    this.jBS = paramTextView;
    AppMethodBeat.o(254685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderChooseOriginalView
 * JD-Core Version:    0.7.0.1
 */