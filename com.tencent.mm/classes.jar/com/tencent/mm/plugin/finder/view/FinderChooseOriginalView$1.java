package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.j;
import com.tencent.mm.ui.aj;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderChooseOriginalView$1
  implements View.OnClickListener
{
  FinderChooseOriginalView$1(FinderChooseOriginalView paramFinderChooseOriginalView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(204096);
    paramView = new c(this.rVC.getContext());
    paramView.EP(2131496241);
    Object localObject1 = (TextView)paramView.khe.findViewById(2131307903);
    k.g(localObject1, "titleTv");
    aj.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = paramView.khe.findViewById(2131307904);
    Object localObject2 = paramView.khe.findViewById(2131307902);
    if (this.rVC.getFlag() == 1)
    {
      k.g(localObject1, "yesIv");
      ((View)localObject1).setVisibility(0);
      k.g(localObject2, "noIv");
      ((View)localObject2).setVisibility(8);
      localObject1 = j.rOX;
      int i = j.cCW();
      localObject1 = paramView.khe.findViewById(2131307886);
      k.g(localObject1, "rootView.findViewById<Te…R.id.no_original_desc_tv)");
      ((TextView)localObject1).setText((CharSequence)this.rVC.getContext().getString(2131766480, new Object[] { String.valueOf(i) }));
      if (i <= 0) {
        break label286;
      }
      paramView.khe.findViewById(2131307896).setOnClickListener((View.OnClickListener)new a(paramView, this));
    }
    for (;;)
    {
      paramView.khe.findViewById(2131307905).setOnClickListener((View.OnClickListener)new b(paramView, this));
      paramView.khe.findViewById(2131307901).setOnClickListener((View.OnClickListener)new c(paramView, this));
      paramView.cED();
      AppMethodBeat.o(204096);
      return;
      k.g(localObject1, "yesIv");
      ((View)localObject1).setVisibility(8);
      k.g(localObject2, "noIv");
      ((View)localObject2).setVisibility(0);
      break;
      label286:
      localObject1 = paramView.khe.findViewById(2131307896);
      k.g(localObject1, "rootView.findViewById<Vi…(R.id.original_no_layout)");
      ((View)localObject1).setClickable(false);
      localObject1 = (TextView)paramView.khe.findViewById(2131307887);
      localObject2 = this.rVC.getContext();
      k.g(localObject2, "context");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(2131099677));
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(c paramc, FinderChooseOriginalView.1 param1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204092);
      jdField_this.rVC.setOriginalFlag(2);
      this.rsz.bmi();
      AppMethodBeat.o(204092);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$2"})
  static final class b
    implements View.OnClickListener
  {
    b(c paramc, FinderChooseOriginalView.1 param1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204093);
      jdField_this.rVC.setOriginalFlag(1);
      this.rsz.bmi();
      AppMethodBeat.o(204093);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/FinderChooseOriginalView$1$1$3"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc, FinderChooseOriginalView.1 param1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204095);
      paramView = new c(jdField_this.rVC.getContext());
      paramView.EP(2131496237);
      paramView.khe.findViewById(2131307298).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(204094);
          this.rsz.bmi();
          AppMethodBeat.o(204094);
        }
      });
      paramView.cED();
      this.rsz.bmi();
      AppMethodBeat.o(204095);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderChooseOriginalView.1
 * JD-Core Version:    0.7.0.1
 */