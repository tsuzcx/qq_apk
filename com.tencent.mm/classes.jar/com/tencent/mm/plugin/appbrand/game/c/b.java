package com.tencent.mm.plugin.appbrand.game.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mm.plugin.appbrand.game.l;
import com.tencent.mm.plugin.appbrand.v.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;
import java.util.LinkedList;

public final class b
  extends WebView
{
  boolean gbc = false;
  public View gbd;
  private LinkedList<String> gbe;
  private boolean gbf = false;
  
  public b(Context paramContext)
  {
    super(paramContext);
    getSettings().setJavaScriptEnabled(true);
    this.gbd = new a(getContext());
    this.gbd.setOnClickListener(new b.1(this));
    setWebViewClient(new b.2(this));
    loadUrl("wagame://WAGameVConsole.html");
    setTranslationY(getDisplayHeight());
  }
  
  private static int getDisplayHeight()
  {
    Point localPoint = new Point();
    l locall = l.gav;
    l.e(localPoint);
    return localPoint.y;
  }
  
  private void tv(String paramString)
  {
    paramString = i.wI(paramString);
    if (Build.VERSION.SDK_INT >= 19)
    {
      evaluateJavascript("console._log('" + paramString + "')", null);
      return;
    }
    loadUrl("javascript:console._log('" + paramString + "')");
  }
  
  public final View getConsoleButton()
  {
    return this.gbd;
  }
  
  public final void tn(String paramString)
  {
    if (this.gbf)
    {
      tv(paramString);
      return;
    }
    if (this.gbe == null) {
      this.gbe = new LinkedList();
    }
    this.gbe.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.b
 * JD-Core Version:    0.7.0.1
 */