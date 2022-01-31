package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

final class VerifyQQUI$b
  implements MenuItem.OnMenuItemClickListener
{
  WeakReference<VerifyQQUI> bJz;
  
  protected VerifyQQUI$b(VerifyQQUI paramVerifyQQUI)
  {
    AppMethodBeat.i(13784);
    this.bJz = new WeakReference(paramVerifyQQUI);
    AppMethodBeat.o(13784);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(13785);
    paramMenuItem = (VerifyQQUI)this.bJz.get();
    if ((paramMenuItem == null) || (paramMenuItem.isFinishing()))
    {
      AppMethodBeat.o(13785);
      return true;
    }
    Object localObject = (EditText)paramMenuItem.findViewById(2131821821);
    EditText localEditText = (EditText)paramMenuItem.findViewById(2131821822);
    localObject = ((EditText)localObject).getText().toString().trim();
    VerifyQQUI.a(paramMenuItem, localEditText.getText().toString().trim());
    try
    {
      VerifyQQUI.a(paramMenuItem, bo.getLong((String)localObject, 0L));
      if (VerifyQQUI.c(paramMenuItem) < 10000L)
      {
        h.h(paramMenuItem.getContext(), 2131297650, 2131297648);
        AppMethodBeat.o(13785);
        return true;
      }
    }
    catch (Exception localException)
    {
      h.h(paramMenuItem.getContext(), 2131297650, 2131297648);
      AppMethodBeat.o(13785);
      return true;
    }
    if (VerifyQQUI.d(paramMenuItem).equals(""))
    {
      h.h(paramMenuItem.getContext(), 2131297649, 2131297648);
      AppMethodBeat.o(13785);
      return true;
    }
    paramMenuItem.hideVKB();
    final b localb = new b(VerifyQQUI.c(paramMenuItem), VerifyQQUI.d(paramMenuItem), "", "", "", VerifyQQUI.f(paramMenuItem), VerifyQQUI.g(paramMenuItem), false);
    g.Rc().a(localb, 0);
    localObject = paramMenuItem.getContext();
    paramMenuItem.getString(2131297652);
    VerifyQQUI.a(paramMenuItem, h.b((Context)localObject, paramMenuItem.getString(2131297643), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(13783);
        g.Rc().a(localb);
        AppMethodBeat.o(13783);
      }
    }));
    AppMethodBeat.o(13785);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.VerifyQQUI.b
 * JD-Core Version:    0.7.0.1
 */