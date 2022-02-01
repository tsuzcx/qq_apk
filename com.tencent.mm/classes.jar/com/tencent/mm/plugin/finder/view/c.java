package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.b.p;
import d.v;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderBottomDialogHelper;", "", "()V", "Companion", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "FinderBottomDialogHelper";
  public static final a tdm;
  
  static
  {
    AppMethodBeat.i(168222);
    tdm = new a((byte)0);
    TAG = "FinderBottomDialogHelper";
    AppMethodBeat.o(168222);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion;", "", "()V", "TAG", "", "showConfirmDialog", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "title", "msg", "lok", "Landroid/content/DialogInterface$OnClickListener;", "lcancel", "ldismiss", "Landroid/content/DialogInterface$OnDismissListener;", "ok", "cancel", "plugin-finder_release"})
  public static final class a
  {
    public static e a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(205673);
      p.h(paramContext, "context");
      e locale = new e(paramContext, 1, false);
      Object localObject = View.inflate(paramContext, 2131494011, null);
      if (localObject == null)
      {
        paramContext = new v("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
        AppMethodBeat.o(205673);
        throw paramContext;
      }
      localObject = (RoundedCornerFrameLayout)localObject;
      TextView localTextView = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(2131300013);
      p.g(localTextView, "msgTv");
      localTextView.setText((CharSequence)bu.nullAsNil(paramString2));
      paramString2 = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(2131300077);
      if (!bu.isNullOrNil(paramString1))
      {
        p.g(paramString2, "titleTv");
        paramString2.setText((CharSequence)paramString1);
      }
      paramString1 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(2131302999);
      if (!bu.isNullOrNil(paramString3))
      {
        p.g(paramString1, "okBtn");
        paramString1.setText((CharSequence)paramString3);
      }
      paramString2 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(2131297690);
      if (!bu.isNullOrNil(paramString4))
      {
        p.g(paramString2, "cancelBtn");
        paramString2.setText((CharSequence)paramString4);
      }
      ((RoundedCornerFrameLayout)localObject).p(aq.fromDPToPix(paramContext, 12), aq.fromDPToPix(paramContext, 12), 0.0F, 0.0F);
      paramString1.setOnClickListener((View.OnClickListener)new a(locale, paramOnClickListener1));
      paramString2.setOnClickListener((View.OnClickListener)new b(locale, paramOnClickListener2));
      locale.b((e.b)new c(paramOnDismissListener));
      locale.a((n.d)new d(locale, (RoundedCornerFrameLayout)localObject));
      locale.fQw();
      locale.cPF();
      AppMethodBeat.o(205673);
      return locale;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(e parame, DialogInterface.OnClickListener paramOnClickListener) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(205669);
        b localb = new b();
        localb.bd(paramView);
        a.b("com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.tdn.bqD();
        paramView = paramOnClickListener1;
        if (paramView != null) {
          paramView.onClick(null, -1);
        }
        a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205669);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(e parame, DialogInterface.OnClickListener paramOnClickListener) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(205670);
        b localb = new b();
        localb.bd(paramView);
        a.b("com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.tdn.bqD();
        paramView = paramOnClickListener2;
        if (paramView != null) {
          paramView.onClick(null, -2);
        }
        a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205670);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onDismiss"})
    static final class c
      implements e.b
    {
      c(DialogInterface.OnDismissListener paramOnDismissListener) {}
      
      public final void onDismiss()
      {
        AppMethodBeat.i(205671);
        DialogInterface.OnDismissListener localOnDismissListener = this.tdq;
        if (localOnDismissListener != null)
        {
          localOnDismissListener.onDismiss(null);
          AppMethodBeat.o(205671);
          return;
        }
        AppMethodBeat.o(205671);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class d
      implements n.d
    {
      d(e parame, RoundedCornerFrameLayout paramRoundedCornerFrameLayout) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(205672);
        paraml.clear();
        this.tdn.setFooterView(null);
        this.tdn.setFooterView((View)this.tdr);
        AppMethodBeat.o(205672);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.c
 * JD-Core Version:    0.7.0.1
 */