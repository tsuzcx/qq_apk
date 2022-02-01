package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.b.k;
import d.v;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderBottomDialogHelper;", "", "()V", "Companion", "plugin-finder_release"})
public final class b
{
  private static final String TAG = "FinderBottomDialogHelper";
  public static final a qVm;
  
  static
  {
    AppMethodBeat.i(168222);
    qVm = new a((byte)0);
    TAG = "FinderBottomDialogHelper";
    AppMethodBeat.o(168222);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderBottomDialogHelper$Companion;", "", "()V", "TAG", "", "showConfirmDialog", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "title", "msg", "lok", "Landroid/content/DialogInterface$OnClickListener;", "lcancel", "ldismiss", "Landroid/content/DialogInterface$OnDismissListener;", "ok", "cancel", "plugin-finder_release"})
  public static final class a
  {
    public static e a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
    {
      AppMethodBeat.i(200023);
      k.h(paramContext, "context");
      e locale = new e(paramContext, 1, false);
      Object localObject = View.inflate(paramContext, 2131494011, null);
      if (localObject == null)
      {
        paramContext = new v("null cannot be cast to non-null type com.tencent.mm.ui.widget.RoundedCornerFrameLayout");
        AppMethodBeat.o(200023);
        throw paramContext;
      }
      localObject = (RoundedCornerFrameLayout)localObject;
      TextView localTextView = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(2131300013);
      k.g(localTextView, "msgTv");
      localTextView.setText((CharSequence)bt.nullAsNil(paramString2));
      paramString2 = (TextView)((RoundedCornerFrameLayout)localObject).findViewById(2131300077);
      if (!bt.isNullOrNil(paramString1))
      {
        k.g(paramString2, "titleTv");
        paramString2.setText((CharSequence)paramString1);
      }
      paramString1 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(2131302999);
      if (!bt.isNullOrNil(paramString3))
      {
        k.g(paramString1, "okBtn");
        paramString1.setText((CharSequence)paramString3);
      }
      paramString2 = (Button)((RoundedCornerFrameLayout)localObject).findViewById(2131297690);
      if (!bt.isNullOrNil(paramString4))
      {
        k.g(paramString2, "cancelBtn");
        paramString2.setText((CharSequence)paramString4);
      }
      ((RoundedCornerFrameLayout)localObject).l(ao.fromDPToPix(paramContext, 12), ao.fromDPToPix(paramContext, 12), 0.0F, 0.0F);
      paramString1.setOnClickListener((View.OnClickListener)new a(locale, paramOnClickListener1));
      paramString2.setOnClickListener((View.OnClickListener)new b(locale, paramOnClickListener2));
      locale.b((e.b)new c(paramOnDismissListener));
      locale.a((n.c)new d(locale, (RoundedCornerFrameLayout)localObject));
      locale.ffu();
      locale.csG();
      AppMethodBeat.o(200023);
      return locale;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(e parame, DialogInterface.OnClickListener paramOnClickListener) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(200019);
        this.Ler.bfo();
        paramView = paramOnClickListener1;
        if (paramView != null)
        {
          paramView.onClick(null, -1);
          AppMethodBeat.o(200019);
          return;
        }
        AppMethodBeat.o(200019);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(e parame, DialogInterface.OnClickListener paramOnClickListener) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(200020);
        this.Ler.bfo();
        paramView = paramOnClickListener2;
        if (paramView != null)
        {
          paramView.onClick(null, -2);
          AppMethodBeat.o(200020);
          return;
        }
        AppMethodBeat.o(200020);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onDismiss"})
    static final class c
      implements e.b
    {
      c(DialogInterface.OnDismissListener paramOnDismissListener) {}
      
      public final void onDismiss()
      {
        AppMethodBeat.i(200021);
        DialogInterface.OnDismissListener localOnDismissListener = this.Leu;
        if (localOnDismissListener != null)
        {
          localOnDismissListener.onDismiss(null);
          AppMethodBeat.o(200021);
          return;
        }
        AppMethodBeat.o(200021);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class d
      implements n.c
    {
      d(e parame, RoundedCornerFrameLayout paramRoundedCornerFrameLayout) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(200022);
        paraml.clear();
        this.Ler.setFooterView(null);
        this.Ler.setFooterView((View)this.Lev);
        AppMethodBeat.o(200022);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.b
 * JD-Core Version:    0.7.0.1
 */