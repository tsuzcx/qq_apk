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
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderBottomDialogHelper;", "", "()V", "Companion", "plugin-finder_release"})
public final class d
{
  public static final a AUy;
  private static final String TAG = "FinderBottomDialogHelper";
  
  static
  {
    AppMethodBeat.i(168222);
    AUy = new a((byte)0);
    TAG = "FinderBottomDialogHelper";
    AppMethodBeat.o(168222);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion;", "", "()V", "TAG", "", "showConfirmDialog", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "title", "msg", "lok", "Landroid/content/DialogInterface$OnClickListener;", "lcancel", "ldismiss", "Landroid/content/DialogInterface$OnDismissListener;", "ok", "cancel", "plugin-finder_release"})
  public static final class a
  {
    public static e a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(288823);
      p.k(paramContext, "context");
      e locale = new e(paramContext, 1, false);
      Object localObject = View.inflate(paramContext, b.g.finder_bottom_confirm, null);
      if (localObject == null)
      {
        paramContext = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
        AppMethodBeat.o(288823);
        throw paramContext;
      }
      localObject = (RoundedCornerFrameLayout)localObject;
      TextView localTextView = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(b.f.finder_msg);
      p.j(localTextView, "msgTv");
      localTextView.setText((CharSequence)Util.nullAsNil(paramString2));
      paramString2 = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(b.f.finder_title);
      if (!Util.isNullOrNil(paramString1))
      {
        p.j(paramString2, "titleTv");
        paramString2.setText((CharSequence)paramString1);
      }
      paramString1 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(b.f.ok_btn);
      if (!Util.isNullOrNil(paramString3))
      {
        p.j(paramString1, "okBtn");
        paramString1.setText((CharSequence)paramString3);
      }
      paramString2 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(b.f.cancel_btn);
      if (!Util.isNullOrNil(paramString4))
      {
        p.j(paramString2, "cancelBtn");
        paramString2.setText((CharSequence)paramString4);
      }
      ((RoundedCornerFrameLayout)localObject).v(aw.fromDPToPix(paramContext, 12), aw.fromDPToPix(paramContext, 12), 0.0F, 0.0F);
      paramString1.setOnClickListener((View.OnClickListener)new a(locale, paramOnClickListener1));
      paramString2.setOnClickListener((View.OnClickListener)new b(locale, paramOnClickListener2));
      locale.b((e.b)new c(paramOnDismissListener));
      locale.a((q.f)new d(locale, (RoundedCornerFrameLayout)localObject));
      locale.rn(true);
      locale.eik();
      AppMethodBeat.o(288823);
      return locale;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(e parame, DialogInterface.OnClickListener paramOnClickListener) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(278454);
        b localb = new b();
        localb.bn(paramView);
        a.c("com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.$dialog.bYF();
        paramView = paramOnClickListener1;
        if (paramView != null) {
          paramView.onClick(null, -1);
        }
        a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(278454);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(e parame, DialogInterface.OnClickListener paramOnClickListener) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(269297);
        b localb = new b();
        localb.bn(paramView);
        a.c("com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.$dialog.bYF();
        paramView = paramOnClickListener2;
        if (paramView != null) {
          paramView.onClick(null, -2);
        }
        a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(269297);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
    static final class c
      implements e.b
    {
      c(DialogInterface.OnDismissListener paramOnDismissListener) {}
      
      public final void onDismiss()
      {
        AppMethodBeat.i(291813);
        DialogInterface.OnDismissListener localOnDismissListener = this.$ldismiss;
        if (localOnDismissListener != null)
        {
          localOnDismissListener.onDismiss(null);
          AppMethodBeat.o(291813);
          return;
        }
        AppMethodBeat.o(291813);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class d
      implements q.f
    {
      d(e parame, RoundedCornerFrameLayout paramRoundedCornerFrameLayout) {}
      
      public final void onCreateMMMenu(o paramo)
      {
        AppMethodBeat.i(266715);
        paramo.clear();
        this.$dialog.setFooterView(null);
        this.$dialog.setFooterView((View)this.AUz);
        AppMethodBeat.o(266715);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.d
 * JD-Core Version:    0.7.0.1
 */