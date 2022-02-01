package com.tencent.luggage.game.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.magicbrush.d;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.utils.r;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public g ciU;
  h ciV;
  boolean ciW;
  public View ciX;
  LinkedList<String> ciY;
  boolean ciZ;
  private d cja;
  private Context mContext;
  
  public b(g paramg, d paramd, Context paramContext, h paramh)
  {
    AppMethodBeat.i(130495);
    this.ciW = false;
    this.ciZ = false;
    this.ciV = paramh;
    this.ciU = paramg;
    this.mContext = paramContext;
    this.cja = paramd;
    this.ciU.aw(paramContext);
    this.ciU.CE().CF();
    this.ciX = new a(this.mContext);
    this.ciX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(130487);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/luggage/game/inspector/ConsoleViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = b.this;
        if (paramAnonymousView.ciW)
        {
          localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject).addUpdateListener(new b.3(paramAnonymousView));
          ((ValueAnimator)localObject).start();
        }
        for (paramAnonymousView.ciW = false;; paramAnonymousView.ciW = true)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/luggage/game/inspector/ConsoleViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(130487);
          return;
          paramAnonymousView.ciU.setTranslationY(paramAnonymousView.getDisplayHeight());
          paramAnonymousView.ciU.setVisibility(0);
          localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
          ((ValueAnimator)localObject).addUpdateListener(new b.4(paramAnonymousView));
          ((ValueAnimator)localObject).start();
        }
      }
    });
    this.ciU.a(new g.b()
    {
      public final void CD()
      {
        AppMethodBeat.i(130489);
        b.this.ciZ = true;
        if ((b.this.ciY != null) && (!b.this.ciY.isEmpty()))
        {
          Iterator localIterator = b.this.ciY.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            b.this.cN(str);
          }
        }
        AppMethodBeat.o(130489);
      }
      
      public final boolean cO(String paramAnonymousString)
      {
        AppMethodBeat.i(130488);
        boolean bool = "wagame://servicewechat.com/WAGameVConsole.html".equals(paramAnonymousString);
        AppMethodBeat.o(130488);
        return bool;
      }
      
      public final InputStream cP(String paramAnonymousString)
      {
        AppMethodBeat.i(130490);
        paramAnonymousString = b.this.ciV.aWe().openRead(paramAnonymousString);
        AppMethodBeat.o(130490);
        return paramAnonymousString;
      }
    });
    this.ciU.loadUrl("wagame://servicewechat.com/WAGameVConsole.html");
    this.ciU.setTranslationY(100000.0F);
    this.ciU.setVisibility(8);
    AppMethodBeat.o(130495);
  }
  
  final void cN(String paramString)
  {
    AppMethodBeat.i(130498);
    paramString = r.VN(paramString);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.ciU.cQ("console._log('" + paramString + "')");
      AppMethodBeat.o(130498);
      return;
    }
    this.ciU.loadUrl("javascript:console._log('" + paramString + "')");
    AppMethodBeat.o(130498);
  }
  
  final int getDisplayHeight()
  {
    AppMethodBeat.i(130496);
    int i = (int)(this.cja.cxr.find(0).getWidth() * this.mContext.getResources().getDisplayMetrics().density);
    AppMethodBeat.o(130496);
    return i + 1;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(220715);
    View localView = this.ciU.getView();
    AppMethodBeat.o(220715);
    return localView;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(130497);
    if (this.ciZ)
    {
      cN(paramString);
      AppMethodBeat.o(130497);
      return;
    }
    if (this.ciY == null) {
      this.ciY = new LinkedList();
    }
    this.ciY.add(paramString);
    AppMethodBeat.o(130497);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(130499);
    this.ciU.getView().post(paramRunnable);
    AppMethodBeat.o(130499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.c.b
 * JD-Core Version:    0.7.0.1
 */