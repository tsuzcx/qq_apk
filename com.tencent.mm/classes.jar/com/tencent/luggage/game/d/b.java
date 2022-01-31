package com.tencent.luggage.game.d;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.t.m;
import java.util.LinkedList;

public final class b
{
  public f bAm;
  h bAn;
  boolean bAo;
  public View bAp;
  LinkedList<String> bAq;
  boolean bAr;
  private Context mContext;
  private MBRuntime mbRuntime;
  
  public b(f paramf, MBRuntime paramMBRuntime, Context paramContext, h paramh)
  {
    AppMethodBeat.i(140375);
    this.bAo = false;
    this.bAr = false;
    this.bAn = paramh;
    this.bAm = paramf;
    this.mContext = paramContext;
    this.mbRuntime = paramMBRuntime;
    this.bAm.ao(paramContext);
    this.bAm.uH().uI();
    this.bAp = new a(this.mContext);
    this.bAp.setOnClickListener(new b.1(this));
    this.bAm.a(new b.2(this));
    this.bAm.loadUrl("wagame://WAGameVConsole.html");
    this.bAm.setTranslationY(100000.0F);
    this.bAm.setVisibility(8);
    AppMethodBeat.o(140375);
  }
  
  final void bN(String paramString)
  {
    AppMethodBeat.i(140378);
    paramString = m.Fr(paramString);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.bAm.by("console._log('" + paramString + "')");
      AppMethodBeat.o(140378);
      return;
    }
    this.bAm.loadUrl("javascript:console._log('" + paramString + "')");
    AppMethodBeat.o(140378);
  }
  
  final int getDisplayHeight()
  {
    AppMethodBeat.i(140376);
    int i = (int)(this.mbRuntime.getSystemDisplayHeight() * this.mContext.getResources().getDisplayMetrics().density);
    AppMethodBeat.o(140376);
    return i + 1;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(140377);
    if (this.bAr)
    {
      bN(paramString);
      AppMethodBeat.o(140377);
      return;
    }
    if (this.bAq == null) {
      this.bAq = new LinkedList();
    }
    this.bAq.add(paramString);
    AppMethodBeat.o(140377);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(140379);
    this.bAm.getView().post(paramRunnable);
    AppMethodBeat.o(140379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.d.b
 * JD-Core Version:    0.7.0.1
 */