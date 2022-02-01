package com.tencent.mm.plugin.bizui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class b
{
  public static d a(s params, String paramString1, String paramString2, String paramString3, final y.a parama1, final y.a parama2)
  {
    AppMethodBeat.i(123722);
    Object localObject = new d.a(params.JvK);
    ((d.a)localObject).a(a.decodeResource(params.JvK.getResources(), 2131690054), false, 3);
    ((d.a)localObject).zf(false);
    ((d.a)localObject).zg(false);
    ((d.a)localObject).aZl(paramString1).afT(17);
    localObject = ((d.a)localObject).fQv();
    AppCompatActivity localAppCompatActivity = params.JvK;
    if (!bu.isNullOrNil(paramString3))
    {
      paramString1 = paramString3;
      if (paramString3.length() != 0) {}
    }
    else
    {
      paramString1 = localAppCompatActivity.getResources().getString(2131757562);
    }
    if (!bu.isNullOrNil(paramString2))
    {
      paramString3 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString3 = localAppCompatActivity.getResources().getString(2131755691);
    }
    ((d)localObject).a(paramString1, true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(123720);
        this.nUJ.dismiss();
        if (parama2 != null) {
          parama2.a(true, this.nUJ.fQs(), this.nUJ.fQt());
        }
        AppMethodBeat.o(123720);
      }
    });
    ((d)localObject).b(paramString3, true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(123721);
        this.nUJ.dismiss();
        if (parama1 != null) {
          parama1.a(false, null, 0);
        }
        AppMethodBeat.o(123721);
      }
    });
    ((d)localObject).aaX(params.JvK.getResources().getColor(2131100035));
    ((d)localObject).show();
    AppMethodBeat.o(123722);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.bizui.a.b
 * JD-Core Version:    0.7.0.1
 */