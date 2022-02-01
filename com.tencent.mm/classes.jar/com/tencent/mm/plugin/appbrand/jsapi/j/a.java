package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.threadpool.i;
import org.json.JSONObject;

public final class a
{
  private static int qvo = -1;
  private static int qvp = 0;
  private static boolean qvq = false;
  public static int[] rZf = { ba.i.appbrand_handoffFail_NotSupported, ba.i.appbrand_handoffFail_NotSupported, ba.i.appbrand_handoffFail_InvalidLogin, ba.i.appbrand_handoffFail_LowVersion, ba.i.appbrand_handoffFail_NotSupported };
  
  public static void ab(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(329743);
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(329742);
        Toast localToast = Toast.makeText(a.this, "", 3000);
        View localView = View.inflate(a.this, a.h.text_toast, null);
        ((TextView)localView.findViewById(a.g.toast_text)).setText(paramString);
        localToast.setGravity(17, 0, 0);
        localToast.setView(localView);
        localToast.show();
        AppMethodBeat.o(329742);
      }
    });
    AppMethodBeat.o(329743);
  }
  
  public static void eK(Context paramContext)
  {
    AppMethodBeat.i(329738);
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(329741);
        Toast localToast = Toast.makeText(a.this, "", 3000);
        View localView = View.inflate(a.this, a.h.center_toast, null);
        ((WeImageView)localView.findViewById(a.g.toast_img)).setImageResource(ba.h.icons_outlined_colorful_handoff_success);
        final TextView localTextView = (TextView)localView.findViewById(a.g.toast_text);
        localTextView.setText(a.this.getString(ba.i.appbrand_handoffOk));
        localTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(329733);
            if (localTextView.getLineCount() > 1) {
              localTextView.setTextSize(0, com.tencent.mm.cd.a.br(a.this, a.e.DescTextSize));
            }
            localTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            AppMethodBeat.o(329733);
          }
        });
        localToast.setGravity(17, 0, 0);
        localToast.setView(localView);
        localToast.show();
        AppMethodBeat.o(329741);
      }
    });
    AppMethodBeat.o(329738);
  }
  
  public static int p(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(329735);
    qvo = u.Uy(paramString2).qvo;
    qvp = u.Uy(paramString2).qvp;
    boolean bool = u.Uy(paramString2).qvq;
    qvq = bool;
    if ((!bool) || (qvo == -1) || (qvp == 0))
    {
      Log.i(paramString1, "invalid login,isWXOnline: %b , iconType : %d ,clientVersion: %d", new Object[] { Boolean.valueOf(qvq), Integer.valueOf(qvo), Integer.valueOf(qvp) });
      AppMethodBeat.o(329735);
      return 2;
    }
    if ((qvo == 1) || (qvo == 2))
    {
      JSONObject localJSONObject = com.tencent.mm.plugin.webview.luggage.c.c.ZL(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zsd, ""));
      if (qvo == 2) {}
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
        AppMethodBeat.o(329735);
        return 4;
      }
      int i = localJSONObject.optInt(str, 0);
      int j = localJSONObject.optInt(paramString2, 0);
      if ((1 != i) || (j == 0))
      {
        Log.i(paramString1, "pc not supported ,iconType: %d ,isGame :%b", new Object[] { Integer.valueOf(qvo), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(329735);
        return 4;
      }
      if (qvp < j)
      {
        Log.i(paramString1, "version is old,clientVersion: %d ,isGame :%b", new Object[] { Integer.valueOf(qvp), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(329735);
        return 3;
      }
    }
    else
    {
      Log.i(paramString1, "invalid login,iconType:" + qvo);
      AppMethodBeat.o(329735);
      return 2;
    }
    AppMethodBeat.o(329735);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a
 * JD-Core Version:    0.7.0.1
 */