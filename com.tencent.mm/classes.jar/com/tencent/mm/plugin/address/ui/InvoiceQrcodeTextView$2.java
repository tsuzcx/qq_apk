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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.g;

final class InvoiceQrcodeTextView$2
  implements View.OnLongClickListener
{
  InvoiceQrcodeTextView$2(InvoiceQrcodeTextView paramInvoiceQrcodeTextView) {}
  
  public final boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(231579);
    Object localObject1 = new b();
    ((b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject1).axR());
    paramView = (TextView)paramView;
    if (paramView.getText() != null)
    {
      localObject1 = paramView.getText();
      Object localObject2 = new SpannableString((CharSequence)localObject1);
      ((SpannableString)localObject2).setSpan(new BackgroundColorSpan(paramView.getContext().getResources().getColor(2131100677)), 0, ((CharSequence)localObject1).length(), 33);
      paramView.setText((CharSequence)localObject2);
      localObject2 = new com.tencent.mm.ui.widget.b.a(paramView.getContext(), paramView);
      ((com.tencent.mm.ui.widget.b.a)localObject2).QSs = new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(231576);
          paramAnonymousContextMenu.add(paramView.getContext().getString(2131755772));
          AppMethodBeat.o(231576);
        }
      };
      ((com.tencent.mm.ui.widget.b.a)localObject2).HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(231577);
          if (paramAnonymousInt == 0)
          {
            ClipboardHelper.setText(paramView.getText().toString());
            h.cC(paramView.getContext(), paramView.getContext().getString(2131755773));
          }
          AppMethodBeat.o(231577);
        }
      };
      ((com.tencent.mm.ui.widget.b.a)localObject2).QwU = new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(231578);
          paramView.setText(this.kuz);
          AppMethodBeat.o(231578);
        }
      };
      ((com.tencent.mm.ui.widget.b.a)localObject2).ez(InvoiceQrcodeTextView.a(this.kux), InvoiceQrcodeTextView.b(this.kux));
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/address/ui/InvoiceQrcodeTextView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(231579);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.2
 * JD-Core Version:    0.7.0.1
 */