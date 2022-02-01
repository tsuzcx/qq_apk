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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderBottomDialogHelper;", "", "()V", "Companion", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "FinderBottomDialogHelper";
  public static final a wjK;
  
  static
  {
    AppMethodBeat.i(168222);
    wjK = new a((byte)0);
    TAG = "FinderBottomDialogHelper";
    AppMethodBeat.o(168222);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion;", "", "()V", "TAG", "", "showConfirmDialog", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "title", "msg", "lok", "Landroid/content/DialogInterface$OnClickListener;", "lcancel", "ldismiss", "Landroid/content/DialogInterface$OnDismissListener;", "ok", "cancel", "plugin-finder_release"})
  public static final class a
  {
    public static e a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(254667);
      p.h(paramContext, "context");
      e locale = new e(paramContext, 1, false);
      Object localObject = View.inflate(paramContext, 2131494210, null);
      if (localObject == null)
      {
        paramContext = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
        AppMethodBeat.o(254667);
        throw paramContext;
      }
      localObject = (RoundedCornerFrameLayout)localObject;
      TextView localTextView = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(2131301364);
      p.g(localTextView, "msgTv");
      localTextView.setText((CharSequence)Util.nullAsNil(paramString2));
      paramString2 = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(2131301498);
      if (!Util.isNullOrNil(paramString1))
      {
        p.g(paramString2, "titleTv");
        paramString2.setText((CharSequence)paramString1);
      }
      paramString1 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(2131305592);
      if (!Util.isNullOrNil(paramString3))
      {
        p.g(paramString1, "okBtn");
        paramString1.setText((CharSequence)paramString3);
      }
      paramString2 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(2131297963);
      if (!Util.isNullOrNil(paramString4))
      {
        p.g(paramString2, "cancelBtn");
        paramString2.setText((CharSequence)paramString4);
      }
      ((RoundedCornerFrameLayout)localObject).s(at.fromDPToPix(paramContext, 12), at.fromDPToPix(paramContext, 12), 0.0F, 0.0F);
      paramString1.setOnClickListener((View.OnClickListener)new a(locale, paramOnClickListener1));
      paramString2.setOnClickListener((View.OnClickListener)new b(locale, paramOnClickListener2));
      locale.b((e.b)new c(paramOnDismissListener));
      locale.a((o.f)new d(locale, (RoundedCornerFrameLayout)localObject));
      locale.Dm(true);
      locale.dGm();
      AppMethodBeat.o(254667);
      return locale;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(e parame, DialogInterface.OnClickListener paramOnClickListener) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(254663);
        b localb = new b();
        localb.bm(paramView);
        a.b("com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.$dialog.bMo();
        paramView = paramOnClickListener1;
        if (paramView != null) {
          paramView.onClick(null, -1);
        }
        a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(254663);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(e parame, DialogInterface.OnClickListener paramOnClickListener) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(254664);
        b localb = new b();
        localb.bm(paramView);
        a.b("com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.$dialog.bMo();
        paramView = paramOnClickListener2;
        if (paramView != null) {
          paramView.onClick(null, -2);
        }
        a.a(this, "com/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion$showConfirmDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(254664);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
    static final class c
      implements e.b
    {
      c(DialogInterface.OnDismissListener paramOnDismissListener) {}
      
      public final void onDismiss()
      {
        AppMethodBeat.i(254665);
        DialogInterface.OnDismissListener localOnDismissListener = this.$ldismiss;
        if (localOnDismissListener != null)
        {
          localOnDismissListener.onDismiss(null);
          AppMethodBeat.o(254665);
          return;
        }
        AppMethodBeat.o(254665);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class d
      implements o.f
    {
      d(e parame, RoundedCornerFrameLayout paramRoundedCornerFrameLayout) {}
      
      public final void onCreateMMMenu(m paramm)
      {
        AppMethodBeat.i(254666);
        paramm.clear();
        this.$dialog.setFooterView(null);
        this.$dialog.setFooterView((View)this.wjL);
        AppMethodBeat.o(254666);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.c
 * JD-Core Version:    0.7.0.1
 */