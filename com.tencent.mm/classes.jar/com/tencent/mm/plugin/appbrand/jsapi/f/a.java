package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONObject;

public final class a
{
  private static int jjN = -1;
  private static int jjS = 0;
  private static boolean kDf = false;
  public static int[] lWg = { 2131756090, 2131756090, 2131756088, 2131756089, 2131756090 };
  
  public static void ad(Context paramContext, String paramString)
  {
    AppMethodBeat.i(226844);
    h.RTc.aV(new a.2(paramContext, paramString));
    AppMethodBeat.o(226844);
  }
  
  public static void dQ(Context paramContext)
  {
    AppMethodBeat.i(226843);
    h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226840);
        Toast localToast = Toast.makeText(this.val$context, "", 3000);
        View localView = View.inflate(this.val$context, 2131493459, null);
        ((WeImageView)localView.findViewById(2131309259)).setImageResource(2131690772);
        final TextView localTextView = (TextView)localView.findViewById(2131309260);
        localTextView.setText(this.val$context.getString(2131756091));
        localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(226839);
            if (localTextView.getLineCount() > 1) {
              localTextView.setTextSize(0, com.tencent.mm.cb.a.aG(a.1.this.val$context, 2131165261));
            }
            localTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            AppMethodBeat.o(226839);
          }
        });
        localToast.setGravity(17, 0, 0);
        localToast.setView(localView);
        localToast.show();
        AppMethodBeat.o(226840);
      }
    });
    AppMethodBeat.o(226843);
  }
  
  public static int l(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(226842);
    jjN = p.Un(paramString2).jjN;
    jjS = p.Un(paramString2).jjS;
    boolean bool = p.Un(paramString2).kDf;
    kDf = bool;
    if ((!bool) || (jjN == -1) || (jjS == 0))
    {
      Log.i(paramString1, "invalid login,isWXOnline: %b , iconType : %d ,clientVersion: %d", new Object[] { Boolean.valueOf(kDf), Integer.valueOf(jjN), Integer.valueOf(jjS) });
      AppMethodBeat.o(226842);
      return 2;
    }
    if ((jjN == 1) || (jjN == 2))
    {
      JSONObject localJSONObject = com.tencent.mm.plugin.webview.luggage.c.b.Zc(((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.snx, ""));
      if (jjN == 2) {}
      String str;
      for (paramString2 = "mac_appbrand";; paramString2 = "windows_appbrand")
      {
        str = paramString2;
        if (paramBoolean) {
          str = paramString2 + "_game";
        }
        paramString2 = str + "_version";
        if ((localJSONObject != null) && (localJSONObject.has(str)) && (localJSONObject.has(paramString2))) {
          break;
        }
        Log.i(paramString1, "xclient data format wrong ,jsonObject:".concat(String.valueOf(localJSONObject)));
        AppMethodBeat.o(226842);
        return 4;
      }
      int i = localJSONObject.optInt(str, 0);
      int j = localJSONObject.optInt(paramString2, 0);
      if ((1 != i) || (j == 0))
      {
        Log.i(paramString1, "pc not supported ,iconType: %d ,isGame :%b", new Object[] { Integer.valueOf(jjN), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(226842);
        return 4;
      }
      if (jjS < j)
      {
        Log.i(paramString1, "version is old,clientVersion: %d ,isGame :%b", new Object[] { Integer.valueOf(jjS), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(226842);
        return 3;
      }
    }
    else
    {
      Log.i(paramString1, "invalid login,iconType:" + jjN);
      AppMethodBeat.o(226842);
      return 2;
    }
    AppMethodBeat.o(226842);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a
 * JD-Core Version:    0.7.0.1
 */