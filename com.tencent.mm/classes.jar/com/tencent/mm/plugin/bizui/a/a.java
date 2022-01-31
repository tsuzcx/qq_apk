package com.tencent.mm.plugin.bizui.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

public final class a
{
  public static c a(q paramq, String paramString1, String paramString2, String paramString3, q.a parama1, q.a parama2)
  {
    AppMethodBeat.i(70044);
    Object localObject = new c.a(paramq.zaO);
    ((c.a)localObject).a(com.tencent.mm.compatible.g.a.decodeResource(paramq.zaO.getResources(), 2131231249), false, 3);
    ((c.a)localObject).rG(false);
    ((c.a)localObject).rH(false);
    ((c.a)localObject).avp(paramString1).Rh(17);
    localObject = ((c.a)localObject).aLZ();
    AppCompatActivity localAppCompatActivity = paramq.zaO;
    if (!bo.isNullOrNil(paramString3))
    {
      paramString1 = paramString3;
      if (paramString3.length() != 0) {}
    }
    else
    {
      paramString1 = localAppCompatActivity.getResources().getString(2131298503);
    }
    if (!bo.isNullOrNil(paramString2))
    {
      paramString3 = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramString3 = localAppCompatActivity.getResources().getString(2131296888);
    }
    ((c)localObject).a(paramString1, true, new a.1((c)localObject, parama2));
    ((c)localObject).b(paramString3, true, new a.2((c)localObject, parama1));
    ((c)localObject).Ra(paramq.zaO.getResources().getColor(2131689778));
    ((c)localObject).show();
    AppMethodBeat.o(70044);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.bizui.a.a
 * JD-Core Version:    0.7.0.1
 */