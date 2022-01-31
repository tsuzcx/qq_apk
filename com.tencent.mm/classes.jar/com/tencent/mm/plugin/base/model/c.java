package com.tencent.mm.plugin.base.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Process;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.w.a.a;
import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.ui.widget.b.e.b;

public final class c
{
  public static Pair<Integer, Integer> a(final Context paramContext, final String paramString, boolean paramBoolean1, final boolean paramBoolean2, final c.a parama)
  {
    AppMethodBeat.i(155992);
    a.a locala = a.cmp();
    int j = locala.cmq();
    boolean bool = locala.cmr();
    final e.a locala1 = new e.a(paramContext);
    Object localObject1 = paramContext.getResources();
    Object localObject3;
    Object localObject2;
    int i;
    if (j == -1)
    {
      locala1.avx(((Resources)localObject1).getString(2131303693));
      localObject3 = ((Resources)localObject1).getString(2131303695);
      localObject2 = ((Resources)localObject1).getString(2131303692);
      locala1.aj((CharSequence)localObject3);
      if (bool)
      {
        localObject3 = (LinearLayout)LayoutInflater.from(paramContext).inflate(2130968636, null);
        TextView localTextView1 = (TextView)((LinearLayout)localObject3).findViewById(2131821069);
        TextView localTextView2 = (TextView)((LinearLayout)localObject3).findViewById(2131821070);
        localTextView1.setText((CharSequence)localObject2);
        localTextView2.setText(2131303690);
        locala1.fv((View)localObject3);
        locala1.Rm(2131303689);
        locala1.AHt = ((Resources)localObject1).getString(2131296546);
        localTextView2.setOnClickListener(new c.7(paramContext, paramString, paramBoolean2));
        locala1.a(new e.b()
        {
          public final void u(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(155986);
            if (paramAnonymousBoolean1)
            {
              this.jLt.eR(paramContext);
              if (paramBoolean2) {
                h.qsU.e(15783, new Object[] { Integer.valueOf(this.iqK), Integer.valueOf(0), paramString });
              }
            }
            for (;;)
            {
              parama.d(paramAnonymousBoolean2, paramString, this.iqK);
              AppMethodBeat.o(155986);
              return;
              c.a(locala1, this.iqK, paramString, paramBoolean2);
            }
          }
        });
        i = 2;
      }
    }
    while ((j == 0) || (paramBoolean1))
    {
      paramContext = new Pair(Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(155992);
      return paramContext;
      locala1.avu((String)localObject2);
      locala1.Rm(2131303690);
      locala1.AHt = ((Resources)localObject1).getString(2131296546);
      locala1.a(new c.9(paramContext, paramString, paramBoolean2, locala1, parama));
      i = 4;
      continue;
      if (j == 1)
      {
        localObject2 = ((Resources)localObject1).getString(2131303694);
        parama = ((Resources)localObject1).getString(2131303691);
        locala1.AHt = ((Resources)localObject1).getString(2131296888);
        locala1.aj((CharSequence)localObject2);
        if (bool)
        {
          localObject1 = (LinearLayout)LayoutInflater.from(paramContext).inflate(2130968636, null);
          localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131821069);
          localObject3 = (TextView)((LinearLayout)localObject1).findViewById(2131821070);
          ((TextView)localObject2).setText(parama);
          ((TextView)localObject3).setText(2131303690);
          locala1.fv((View)localObject1);
          locala1.Rm(2131303689);
          ((TextView)localObject3).setOnClickListener(new c.10(paramContext, paramString, paramBoolean2));
          locala1.a(new c.11(locala1, paramString, paramBoolean2), new c.12(locala, paramContext, paramBoolean2, paramString));
          i = 1;
        }
        else
        {
          locala1.avu(parama);
          locala1.Rm(2131303690);
          locala1.AHt = ((Resources)localObject1).getString(2131296888);
          locala1.a(new c.2(locala1, paramString, paramBoolean2), new c.3(paramContext, paramString, paramBoolean2));
          i = 3;
        }
      }
      else
      {
        i = -1;
      }
    }
    locala1.show();
    if (paramBoolean2) {
      h.qsU.e(15788, new Object[] { Integer.valueOf(i), Integer.valueOf(0), paramString });
    }
    ab.i("MicroMsg.ShortcutUtil", "permissionJumpStatus = ".concat(String.valueOf(i)));
    paramContext = new Pair(Integer.valueOf(j), Integer.valueOf(i));
    AppMethodBeat.o(155992);
    return paramContext;
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(155993);
    Resources localResources = paramContext.getResources();
    if (paramInt1 == 0)
    {
      com.tencent.mm.ui.widget.snackbar.b.l((Activity)paramContext, localResources.getString(2131303696));
      if (paramBoolean2)
      {
        h.qsU.e(15787, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), paramString });
        AppMethodBeat.o(155993);
      }
    }
    else if ((paramBoolean1) && ((paramInt2 == 2) || (paramInt2 == 4)))
    {
      localResources = paramContext.getResources();
      com.tencent.mm.ui.widget.snackbar.b.a((Activity)paramContext, localResources.getString(2131303696), localResources.getString(2131303690), new c.4(paramContext, paramInt2, paramString, paramBoolean2));
      if (paramBoolean2) {
        h.qsU.e(15787, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(0), paramString });
      }
    }
    AppMethodBeat.o(155993);
  }
  
  public static void a(Context paramContext, c.b paramb)
  {
    AppMethodBeat.i(155991);
    ab.i("MicroMsg.ShortcutUtil", "addShortCut()");
    boolean bool = ah.getContext().getSharedPreferences(ah.dsP(), 0).getBoolean("no_more_show_add_short_cut_dialog", false);
    Pair localPair = a(paramContext, null, bool, false, new c.1(paramContext));
    paramb.aVB();
    al.d(new c.5(paramb, paramContext, localPair, bool));
    AppMethodBeat.o(155991);
  }
  
  public static String av(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151604);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(151604);
      return null;
    }
    ab.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[] { bo.az(ah.getContext(), Process.myPid()) });
    if (paramBoolean) {}
    for (String str = q.getAndroidId();; str = q.bP(true))
    {
      paramString = b.dc(paramString, str);
      if (!bo.isNullOrNil(paramString)) {
        break;
      }
      AppMethodBeat.o(151604);
      return null;
    }
    paramString = "shortcut_" + b.S(paramString.getBytes());
    AppMethodBeat.o(151604);
    return paramString;
  }
  
  public static String dd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151603);
    if ((paramString1 == null) || (paramString1.length() <= 0) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(151603);
      return null;
    }
    ab.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[] { bo.az(ah.getContext(), Process.myPid()) });
    if ((paramString1.startsWith("shortcut_")) && (paramString1.length() > 9))
    {
      String str = paramString1.substring(9);
      if ((str != null) && (str.length() > 0))
      {
        paramString1 = b.dc(new String(b.GB(str)), paramString2);
        AppMethodBeat.o(151603);
        return paramString1;
      }
    }
    AppMethodBeat.o(151603);
    return paramString1;
  }
  
  public static String de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79082);
    paramString1 = g.w((g.w(paramString1.getBytes()) + b.dc(paramString2, paramString1)).getBytes());
    AppMethodBeat.o(79082);
    return paramString1;
  }
  
  public static String decrypt(String paramString)
  {
    AppMethodBeat.i(79081);
    paramString = dd(paramString, q.bP(true));
    AppMethodBeat.o(79081);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c
 * JD-Core Version:    0.7.0.1
 */