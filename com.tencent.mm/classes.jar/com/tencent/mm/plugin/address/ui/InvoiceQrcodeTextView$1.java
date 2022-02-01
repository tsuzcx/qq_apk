package com.tencent.mm.plugin.address.ui;

import android.content.ClipboardManager;
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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;

final class InvoiceQrcodeTextView$1
  implements View.OnLongClickListener
{
  InvoiceQrcodeTextView$1(InvoiceQrcodeTextView paramInvoiceQrcodeTextView) {}
  
  public final boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(20927);
    final ClipboardManager localClipboardManager = (ClipboardManager)aj.getContext().getSystemService("clipboard");
    paramView = (TextView)paramView;
    if ((paramView.getText() != null) && (localClipboardManager != null))
    {
      final CharSequence localCharSequence = paramView.getText();
      Object localObject = new SpannableString(localCharSequence);
      ((SpannableString)localObject).setSpan(new BackgroundColorSpan(paramView.getContext().getResources().getColor(2131100539)), 0, localCharSequence.length(), 33);
      paramView.setText((CharSequence)localObject);
      localObject = new a(paramView.getContext(), paramView);
      ((a)localObject).HIu = new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(20924);
          paramAnonymousContextMenu.add(paramView.getContext().getString(2131755701));
          AppMethodBeat.o(20924);
        }
      };
      ((a)localObject).HrY = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(20925);
          if (paramAnonymousInt == 0)
          {
            localClipboardManager.setText(paramView.getText().toString());
            h.ce(paramView.getContext(), paramView.getContext().getString(2131755702));
          }
          AppMethodBeat.o(20925);
        }
      };
      ((a)localObject).Hua = new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(20926);
          paramView.setText(localCharSequence);
          AppMethodBeat.o(20926);
        }
      };
      ((a)localObject).eh(0, 0);
    }
    AppMethodBeat.o(20927);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceQrcodeTextView.1
 * JD-Core Version:    0.7.0.1
 */