package com.tencent.mm.plugin.bizui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.plugin.bizui.a.a;
import com.tencent.mm.plugin.bizui.a.c;
import com.tencent.mm.plugin.bizui.a.d;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.y;

public final class b
{
  public static e a(y paramy, String paramString1, String paramString2, String paramString3, final y.a parama1, final y.a parama2)
  {
    AppMethodBeat.i(123722);
    Object localObject = new e.a(paramy.getContext());
    ((e.a)localObject).b(a.decodeResource(paramy.getContext().getResources(), a.c.dialog_successful_icon), false, 3);
    ((e.a)localObject).NC(false);
    ((e.a)localObject).ND(false);
    ((e.a)localObject).bDz(paramString1).aEQ(17);
    localObject = ((e.a)localObject).jHH();
    AppCompatActivity localAppCompatActivity = paramy.getContext();
    if (!Util.isNullOrNil(paramString3))
    {
      paramString1 = paramString3;
      if (paramString3.length() != 0) {}
    }
    else
    {
      paramString1 = localAppCompatActivity.getResources().getString(a.d.confirm_dialog_share);
    }
    if (!Util.isNullOrNil(paramString2))
    {
      paramString3 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString3 = localAppCompatActivity.getResources().getString(a.d.app_cancel);
    }
    ((e)localObject).a(paramString1, true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(123720);
        b.this.dismiss();
        if (parama2 != null) {
          parama2.onDialogClick(true, b.this.jHE(), b.this.jHF());
        }
        AppMethodBeat.o(123720);
      }
    });
    ((e)localObject).b(paramString3, true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(123721);
        b.this.dismiss();
        if (parama1 != null) {
          parama1.onDialogClick(false, null, 0);
        }
        AppMethodBeat.o(123721);
      }
    });
    ((e)localObject).ayj(paramy.getContext().getResources().getColor(a.a.brand_text_color));
    ((e)localObject).show();
    AppMethodBeat.o(123722);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.bizui.a.b
 * JD-Core Version:    0.7.0.1
 */