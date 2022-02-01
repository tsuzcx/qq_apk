package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q.g;

final class InvoiceQrcodeTextView$2
  implements View.OnLongClickListener
{
  InvoiceQrcodeTextView$2(InvoiceQrcodeTextView paramInvoiceQrcodeTextView) {}
  
  public final boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(251981);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject1).aFi());
    paramView = (TextView)paramView;
    if (paramView.getText() != null)
    {
      localObject1 = paramView.getText();
      Object localObject2 = new SpannableString((CharSequence)localObject1);
      ((SpannableString)localObject2).setSpan(new BackgroundColorSpan(paramView.getContext().getResources().getColor(R.e.light_blue_bg_color)), 0, ((CharSequence)localObject1).length(), 33);
      paramView.setText((CharSequence)localObject2);
      localObject2 = new com.tencent.mm.ui.widget.b.a(paramView.getContext(), paramView);
      ((com.tencent.mm.ui.widget.b.a)localObject2).Yrf = new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(286221);
          paramAnonymousContextMenu.add(paramView.getContext().getString(R.l.app_copy));
          AppMethodBeat.o(286221);
        }
      };
      ((com.tencent.mm.ui.widget.b.a)localObject2).ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(291254);
          if (paramAnonymousInt == 0)
          {
            ClipboardHelper.setText(paramView.getText().toString());
            h.cN(paramView.getContext(), paramView.getContext().getString(R.l.app_copy_ok));
          }
          AppMethodBeat.o(291254);
        }
      };
      ((com.tencent.mm.ui.widget.b.a)localObject2).XVa = new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(286255);
          paramView.setText(this.nmn);
          AppMethodBeat.o(286255);
        }
      };
      ((com.tencent.mm.ui.widget.b.a)localObject2).eY(InvoiceQrcodeTextView.a(this.nml), InvoiceQrcodeTextView.b(this.nml));
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(251981);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.2
 * JD-Core Version:    0.7.0.1
 */