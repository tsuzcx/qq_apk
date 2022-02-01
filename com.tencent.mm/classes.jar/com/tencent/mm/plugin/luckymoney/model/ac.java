package com.tencent.mm.plugin.luckymoney.model;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aeg;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

public final class ac
{
  public static final String Kty;
  
  static
  {
    AppMethodBeat.i(283947);
    Kty = b.bmr() + "luckymoneynewyear/";
    AppMethodBeat.o(283947);
  }
  
  public static void a(String paramString1, String paramString2, PAGView paramPAGView1, PAGView paramPAGView2, PAGView.PAGViewListener paramPAGViewListener1, PAGView.PAGViewListener paramPAGViewListener2)
  {
    AppMethodBeat.i(283939);
    Log.i("MicroMsg.LuckyMoneyNewYearLogic", "startPAGAnim ：%s ", new Object[] { paramString1 });
    if (paramString1.equals("loop"))
    {
      paramPAGView1.removeListener(paramPAGViewListener1);
      paramPAGView1.addListener(paramPAGViewListener2);
      paramPAGView1.setRepeatCount(0);
    }
    for (;;)
    {
      paramPAGView1.setPath(paramString2);
      paramPAGView1.stop();
      paramPAGView1.flush();
      paramPAGView1.play();
      paramPAGView1.setVisibility(0);
      AppMethodBeat.o(283939);
      return;
      paramPAGView1.removeListener(paramPAGViewListener2);
      paramPAGView1.addListener(paramPAGViewListener1);
      paramPAGView1.setRepeatCount(1);
      paramString1 = new AlphaAnimation(0.0F, 1.0F);
      paramString1.setDuration(500L);
      paramPAGView1.startAnimation(paramString1);
      paramString1.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      if (paramPAGView2 != null) {
        a(paramPAGView2, paramPAGViewListener1, paramPAGViewListener2);
      }
    }
  }
  
  public static void a(PAGView paramPAGView, PAGView.PAGViewListener paramPAGViewListener1, PAGView.PAGViewListener paramPAGViewListener2)
  {
    AppMethodBeat.i(283941);
    Log.i("MicroMsg.LuckyMoneyNewYearLogic", "stopPAGAnim");
    paramPAGView.removeListener(paramPAGViewListener1);
    paramPAGView.removeListener(paramPAGViewListener2);
    paramPAGViewListener1 = new AlphaAnimation(1.0F, 0.0F);
    paramPAGViewListener1.setDuration(500L);
    paramPAGView.startAnimation(paramPAGViewListener1);
    paramPAGViewListener1.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(283885);
        ac.this.setVisibility(8);
        ac.this.stop();
        AppMethodBeat.o(283885);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    AppMethodBeat.o(283941);
  }
  
  public static void aH(View paramView, int paramInt)
  {
    AppMethodBeat.i(283944);
    if (paramInt == 4)
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setAnimationListener(new ac.3(paramView));
      paramView.startAnimation(localAlphaAnimation);
      AppMethodBeat.o(283944);
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(new ac.4(paramView));
    paramView.startAnimation(localAlphaAnimation);
    AppMethodBeat.o(283944);
  }
  
  public static String fXf()
  {
    AppMethodBeat.i(283922);
    String str = Kty + "pagResource.zip";
    AppMethodBeat.o(283922);
    return str;
  }
  
  public static String fXg()
  {
    AppMethodBeat.i(283924);
    String str = Kty + "pagResource";
    AppMethodBeat.o(283924);
    return str;
  }
  
  public static boolean fXh()
  {
    AppMethodBeat.i(283929);
    String str = fXg();
    Log.i("MicroMsg.LuckyMoneyNewYearLogic", "checkPAGAnimResource: %s", new Object[] { str });
    if (!y.ZC(str))
    {
      Log.i("MicroMsg.LuckyMoneyNewYearLogic", "targetPath is not exist");
      AppMethodBeat.o(283929);
      return false;
    }
    u[] arrayOfu = new u(str).jKX();
    if ((arrayOfu != null) && (arrayOfu.length > 0))
    {
      Log.i("MicroMsg.LuckyMoneyNewYearLogic", "targetPath has size : %s", new Object[] { Integer.valueOf(arrayOfu.length) });
      AppMethodBeat.o(283929);
      return true;
    }
    Log.i("MicroMsg.LuckyMoneyNewYearLogic", "targetPath empty: %s", new Object[] { str });
    AppMethodBeat.o(283929);
    return false;
  }
  
  public static void hY(View paramView)
  {
    AppMethodBeat.i(283943);
    aH(paramView, 0);
    AppMethodBeat.o(283943);
  }
  
  public static boolean jY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(283926);
    Log.i("MicroMsg.LuckyMoneyNewYearLogic", "saveFiletoLocal");
    if (y.ZC(paramString2))
    {
      Log.i("MicroMsg.LuckyMoneyNewYearLogic", "fileExists exist, first delete file ：%s", new Object[] { paramString2 });
      y.ew(paramString2, true);
    }
    new u(fXg()).jKY();
    int i = y.aA(paramString1, fXg());
    Log.i("MicroMsg.LuckyMoneyNewYearLogic", "unzip ret: %s", new Object[] { Integer.valueOf(i) });
    y.deleteFile(paramString1);
    paramString1 = new aeg();
    paramString2 = paramString1.iiQ;
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString2.iiS = bool;
      paramString1.publish();
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(283926);
      return true;
    }
    AppMethodBeat.o(283926);
    return false;
  }
  
  public static String jZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(283932);
    paramString1 = Kty + "pagResource/" + paramString1 + paramString2 + ".pag";
    Log.i("MicroMsg.LuckyMoneyNewYearLogic", "getPAGAnimResource :%s", new Object[] { paramString1 });
    if (y.ZC(paramString1))
    {
      Log.i("MicroMsg.LuckyMoneyNewYearLogic", "getPAGAnimResource succ");
      AppMethodBeat.o(283932);
      return paramString1;
    }
    Log.i("MicroMsg.LuckyMoneyNewYearLogic", "getPAGAnimResource fail");
    AppMethodBeat.o(283932);
    return "";
  }
  
  public static void ka(String paramString1, String paramString2)
  {
    boolean bool = true;
    AppMethodBeat.i(283935);
    int i = LuckyMoneyEnvelopeResUpdateListener.jX(paramString1, paramString2);
    Log.i("MicroMsg.LuckyMoneyNewYearLogic", "downloadRet:%s", new Object[] { Integer.valueOf(i) });
    paramString1 = new aeg();
    paramString2 = paramString1.iiQ;
    if (i == 0) {}
    for (;;)
    {
      paramString2.iiR = bool;
      paramString1.publish();
      if (i != 0) {
        break;
      }
      h.OAn.kJ(991, 27);
      AppMethodBeat.o(283935);
      return;
      bool = false;
    }
    h.OAn.kJ(991, 28);
    AppMethodBeat.o(283935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ac
 * JD-Core Version:    0.7.0.1
 */