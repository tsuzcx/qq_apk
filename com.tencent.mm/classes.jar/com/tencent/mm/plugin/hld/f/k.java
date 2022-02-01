package com.tencent.mm.plugin.hld.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.g;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.u;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/utils/WxImeUIUtil;", "", "()V", "TAG", "", "alternativeWordMaxWidth", "", "associateWordMaxWidth", "colorCacheMap", "", "currentDarkMode", "", "currentInputType", "Ljava/lang/Integer;", "currentOrientation", "lastInputType", "lastOrientation", "mHeightScale", "", "getMHeightScale", "()D", "setMHeightScale", "(D)V", "mKeyboardBottomHeight", "", "getMKeyboardBottomHeight", "()F", "setMKeyboardBottomHeight", "(F)V", "mKeyboardHeight", "getMKeyboardHeight", "()I", "setMKeyboardHeight", "(I)V", "mScreenWidth", "getMScreenWidth", "setMScreenWidth", "mWidthScale", "getMWidthScale", "setMWidthScale", "measuredTextView", "Landroid/widget/TextView;", "nightColorCacheMap", "percent15ScreenWidth", "percent5ScreenWidth", "checkSDCardAvailable", "colorHexToDecimal", "", "hex", "getAdjustTextSize", "text", "allWidth", "maxSize", "minSize", "getAlternativeWordMaxWidth", "getAssociateWordMaxWidth", "getColorByString", "context", "Landroid/content/Context;", "colorString", "getCurInputType", "()Ljava/lang/Integer;", "getCurOrientation", "getHeightScale", "getKeyboardBottomHeight", "getKeyboardHeight", "getLastInputType", "getLastOrientation", "getMeasureWidth", "textSize", "getPercent20ScreenWidth", "getPercent5ScreenWidth", "getRealBottomHeight", "getRealNavigationBarHeight", "getRealNavigationBarVisibility", "getScreenWidth", "getWidthScale", "hexCharDecimal", "hexChar", "", "init", "", "orientation", "isLandscape", "isPaddingViewType", "viewType", "loadBitmapFromView", "Landroid/graphics/Bitmap;", "v", "Landroid/view/View;", "measureTextViewHeight", "textView", "", "deviceWidth", "reset", "resetLastOrientation", "updateConfiguration", "updateInputType", "inputType", "(Ljava/lang/Integer;)V", "viewSaveToImage", "view", "ordinal", "ener", "Lcom/tencent/mm/plugin/hld/utils/WxImeUIUtil$OnSaveListEner;", "OnSaveListEner", "plugin-hld_release"})
@SuppressLint({"StaticFieldLeak"})
public final class k
{
  private static float DHA;
  private static int DHB;
  private static int DHC;
  public static int DHD;
  private static int DHE;
  private static final Map<String, Integer> DHF;
  private static final Map<String, Integer> DHG;
  public static final k DHH;
  public static Integer DHs;
  public static Integer DHt;
  public static boolean DHu;
  private static Integer DHv;
  private static Integer DHw;
  private static TextView DHx;
  private static double DHy;
  private static double DHz;
  private static int jPS;
  private static int mScreenWidth;
  
  static
  {
    AppMethodBeat.i(210559);
    DHH = new k();
    DHu = ar.isDarkMode();
    DHF = (Map)new LinkedHashMap();
    DHG = (Map)new LinkedHashMap();
    AppMethodBeat.o(210559);
  }
  
  public static boolean UK(int paramInt)
  {
    return paramInt >= 5;
  }
  
  public static float a(String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(210551);
    p.k(paramString, "text");
    if (DHx == null) {
      DHx = new TextView(MMApplicationContext.getContext());
    }
    TextView localTextView = DHx;
    if (localTextView != null) {
      for (;;)
      {
        f = paramFloat1;
        if (paramFloat1 <= paramFloat2) {
          break;
        }
        localTextView.setTextSize(0, paramFloat1);
        f = paramFloat1;
        if (localTextView.getPaint().measureText(paramString) < paramInt) {
          break;
        }
        paramFloat1 -= 1.0F;
      }
    }
    float f = paramFloat1;
    if (f < paramFloat2)
    {
      AppMethodBeat.o(210551);
      return paramFloat2;
    }
    AppMethodBeat.o(210551);
    return f;
  }
  
  public static void a(final View paramView, final int paramInt, final boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(210556);
    p.k(paramView, "view");
    paramView.setDrawingCacheEnabled(true);
    paramView.setDrawingCacheQuality(1048576);
    paramView.setDrawingCacheBackgroundColor(-1);
    paramView.layout(0, 0, paramView.getWidth(), paramView.getHeight());
    com.tencent.e.h.ZvG.be((Runnable)new b(parama, paramView, paramInt, paramBoolean));
    AppMethodBeat.o(210556);
  }
  
  public static int b(TextView paramTextView, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(210546);
    p.k(paramTextView, "textView");
    p.k(paramCharSequence, "text");
    paramTextView.setText(paramCharSequence);
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(paramInt, -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramInt = paramTextView.getMeasuredHeight();
    AppMethodBeat.o(210546);
    return paramInt;
  }
  
  public static int bf(Context paramContext, String paramString)
  {
    long l = 0L;
    int j = 0;
    AppMethodBeat.i(210557);
    p.k(paramContext, "context");
    if (paramString == null)
    {
      AppMethodBeat.o(210557);
      return 0;
    }
    int i;
    if (kotlin.n.n.M(paramString, "#", false))
    {
      paramString = paramString.substring(1);
      p.j(paramString, "(this as java.lang.String).substring(startIndex)");
      p.k(paramString, "hex");
      if ((paramString.length() != 6) && (paramString.length() != 8)) {
        l = 0L;
      }
      for (;;)
      {
        i = (int)l;
        AppMethodBeat.o(210557);
        return i;
        paramContext = paramString;
        if (paramString.length() == 6) {
          paramContext = "FF".concat(String.valueOf(paramString));
        }
        int k = ((CharSequence)paramContext).length();
        if (j < k)
        {
          i = paramContext.charAt(j);
          if (65 > i)
          {
            label145:
            if (97 <= i) {
              break label191;
            }
            label151:
            i -= 48;
          }
          for (;;)
          {
            l = l * 16L + i;
            j += 1;
            break;
            if (70 < i) {
              break label145;
            }
            i = i - 65 + 10;
            continue;
            label191:
            if (102 < i) {
              break label151;
            }
            i = i - 97 + 10;
          }
        }
      }
    }
    if (kotlin.n.n.M(paramString, "@color/", false))
    {
      String str = paramString.substring(7);
      p.j(str, "(this as java.lang.String).substring(startIndex)");
      if (ar.isDarkMode()) {}
      for (paramString = DHG;; paramString = DHF)
      {
        Integer localInteger = (Integer)paramString.get(str);
        if (localInteger == null) {
          break;
        }
        i = localInteger.intValue();
        AppMethodBeat.o(210557);
        return i;
      }
      i = a.w(paramContext, paramContext.getResources().getIdentifier(str, "color", paramContext.getPackageName()));
      paramString.put(str, Integer.valueOf(i));
      AppMethodBeat.o(210557);
      return i;
    }
    AppMethodBeat.o(210557);
    return 0;
  }
  
  public static float c(float paramFloat, String paramString)
  {
    AppMethodBeat.i(210552);
    p.k(paramString, "text");
    if (DHx == null) {
      DHx = new TextView(MMApplicationContext.getContext());
    }
    float f = 0.0F;
    TextView localTextView = DHx;
    if (localTextView != null)
    {
      localTextView.setTextSize(0, paramFloat);
      f = localTextView.getPaint().measureText(paramString);
    }
    AppMethodBeat.o(210552);
    return f;
  }
  
  public static Integer eGL()
  {
    return DHs;
  }
  
  public static Integer eGM()
  {
    return DHt;
  }
  
  public static void eGN()
  {
    DHt = DHs;
  }
  
  public static Integer eGO()
  {
    return DHw;
  }
  
  public static Integer eGP()
  {
    return DHv;
  }
  
  public static int eGQ()
  {
    AppMethodBeat.i(210547);
    if (DHB != 0)
    {
      i = DHB;
      AppMethodBeat.o(210547);
      return i;
    }
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "MMApplicationContext.getContext().resources");
    localObject = ((Resources)localObject).getDisplayMetrics();
    if (isLandscape()) {}
    for (int i = (int)(((DisplayMetrics)localObject).heightPixels * 0.2D);; i = (int)(((DisplayMetrics)localObject).widthPixels * 0.2D))
    {
      DHB = i;
      AppMethodBeat.o(210547);
      return i;
    }
  }
  
  public static int eGR()
  {
    AppMethodBeat.i(210548);
    if (DHC != 0)
    {
      i = DHC;
      AppMethodBeat.o(210548);
      return i;
    }
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "MMApplicationContext.getContext().resources");
    localObject = ((Resources)localObject).getDisplayMetrics();
    if (isLandscape()) {}
    for (int i = (int)(((DisplayMetrics)localObject).heightPixels * 0.05D);; i = (int)(((DisplayMetrics)localObject).widthPixels * 0.05D))
    {
      DHC = i;
      AppMethodBeat.o(210548);
      return i;
    }
  }
  
  public static int eGS()
  {
    AppMethodBeat.i(210549);
    if (DHE != 0)
    {
      i = DHE;
      AppMethodBeat.o(210549);
      return i;
    }
    Object localObject;
    if (isLandscape())
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
    }
    for (int i = (int)(((Context)localObject).getResources().getDimension(a.d.ime_width) - a.aZ(MMApplicationContext.getContext(), a.d.keyboard_strike_right_container_width) - a.aZ(MMApplicationContext.getContext(), a.d.Edge_1_5_A));; i = ((Resources)localObject).getDisplayMetrics().widthPixels - a.aZ(MMApplicationContext.getContext(), a.d.keyboard_strike_right_container_width) - a.aZ(MMApplicationContext.getContext(), a.d.Edge_1_5_A))
    {
      DHE = i;
      AppMethodBeat.o(210549);
      return i;
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources();
      p.j(localObject, "MMApplicationContext.getContext().resources");
    }
  }
  
  public static int gV(Context paramContext)
  {
    AppMethodBeat.i(210542);
    p.k(paramContext, "context");
    if (jPS == 0) {
      jPS = a.aZ(paramContext, a.d.ime_height);
    }
    int i = jPS;
    AppMethodBeat.o(210542);
    return i;
  }
  
  public static float gW(Context paramContext)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(210543);
    if (DHA == 0.0F)
    {
      f1 = f2;
      if (paramContext != null)
      {
        paramContext = paramContext.getResources();
        f1 = f2;
        if (paramContext != null) {
          f1 = paramContext.getDimension(a.d.ime_keyboard_height);
        }
      }
      DHA = f1;
    }
    float f1 = DHA;
    AppMethodBeat.o(210543);
    return f1;
  }
  
  public static double gX(Context paramContext)
  {
    AppMethodBeat.i(210544);
    p.k(paramContext, "context");
    Object localObject;
    if (DHy == 0.0D)
    {
      localObject = paramContext.getResources();
      p.j(localObject, "context.resources");
      localObject = ((Resources)localObject).getDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels == 0)
      {
        AppMethodBeat.o(210544);
        return 1.0D;
      }
      if (!isLandscape()) {
        break label164;
      }
    }
    label164:
    for (double d = paramContext.getResources().getDimension(a.d.ime_width) / 662.0D;; d = ((DisplayMetrics)localObject).widthPixels / 400.0D)
    {
      DHy = d;
      Log.d("WxIme.WxImeUIUtil", "getWidthScale: displayMetrics(" + ((DisplayMetrics)localObject).heightPixels + ", " + ((DisplayMetrics)localObject).widthPixels + ") isLandscape " + isLandscape());
      Log.i("WxIme.WxImeUIUtil", "getWidthScale:%s", new Object[] { Double.valueOf(DHy) });
      d = DHy;
      AppMethodBeat.o(210544);
      return d;
    }
  }
  
  public static double gY(Context paramContext)
  {
    AppMethodBeat.i(210545);
    p.k(paramContext, "context");
    if (DHz == 0.0D)
    {
      DHz = paramContext.getResources().getDimension(a.d.S2_button_height) / paramContext.getResources().getInteger(a.g.S2_button_height);
      Log.i("WxIme.WxImeUIUtil", "getHeightScale:%s", new Object[] { Double.valueOf(DHz) });
    }
    double d = DHz;
    AppMethodBeat.o(210545);
    return d;
  }
  
  public static int gZ(Context paramContext)
  {
    AppMethodBeat.i(210555);
    if (paramContext == null)
    {
      i = 0;
      if ((i <= 0) || (i == ar.getStatusBarHeight(paramContext))) {
        break label174;
      }
      i = 1;
      label26:
      if (i == 0) {
        break label179;
      }
      i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (i <= 0) {
        break label187;
      }
    }
    label174:
    label179:
    label187:
    for (int i = Resources.getSystem().getDimensionPixelSize(i);; i = 0)
    {
      AppMethodBeat.o(210555);
      return i;
      Object localObject1 = paramContext.getSystemService("window");
      if (localObject1 == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(210555);
        throw paramContext;
      }
      localObject1 = (WindowManager)localObject1;
      if (localObject1 == null)
      {
        Log.e("WxIme.WxImeUIUtil", "getRealBottomHeight, get NULL windowManager");
        i = 0;
        break;
      }
      Object localObject2 = ((WindowManager)localObject1).getDefaultDisplay();
      localObject1 = new Point();
      ((Display)localObject2).getSize((Point)localObject1);
      localObject2 = ar.au(paramContext);
      i = Math.max(((Point)localObject1).y, ((Point)localObject1).x);
      i = Math.max(((Point)localObject2).y, ((Point)localObject2).x) - i;
      break;
      i = 0;
      break label26;
      AppMethodBeat.o(210555);
      return 0;
    }
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(210541);
    p.k(paramContext, "context");
    if (mScreenWidth == 0)
    {
      paramContext = paramContext.getResources();
      p.j(paramContext, "context.resources");
      paramContext = paramContext.getDisplayMetrics();
      if (paramContext.widthPixels == 0)
      {
        AppMethodBeat.o(210541);
        return 1080;
      }
      mScreenWidth = paramContext.widthPixels;
      Log.d("WxIme.WxImeUIUtil", "getScreenWidth: displayMetrics(" + paramContext.heightPixels + ", " + paramContext.widthPixels + ')');
      Log.i("WxIme.WxImeUIUtil", "getScreenWidth:%s", new Object[] { Integer.valueOf(mScreenWidth) });
    }
    int i = mScreenWidth;
    AppMethodBeat.o(210541);
    return i;
  }
  
  public static void init(int paramInt)
  {
    AppMethodBeat.i(210536);
    DHs = Integer.valueOf(paramInt);
    AppMethodBeat.o(210536);
  }
  
  public static boolean isLandscape()
  {
    AppMethodBeat.i(210539);
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "MMApplicationContext.getContext().resources");
    if (((Resources)localObject).getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(210539);
      return true;
    }
    AppMethodBeat.o(210539);
    return false;
  }
  
  public static void q(Integer paramInteger)
  {
    DHv = DHw;
    DHw = paramInteger;
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(210540);
    Log.i("WxIme.WxImeUIUtil", "reset");
    mScreenWidth = 0;
    DHy = 0.0D;
    DHz = 0.0D;
    DHB = 0;
    DHC = 0;
    DHE = 0;
    DHD = 0;
    jPS = 0;
    DHA = 0.0F;
    a.hqX();
    Object localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
    if (localObject != null)
    {
      localObject = ((d)localObject).eCD();
      if (localObject != null) {
        ((com.tencent.mm.plugin.hld.a.b)localObject).reset();
      }
    }
    localObject = g.DCm;
    g.reset();
    localObject = com.tencent.mm.ui.k.b.XIY;
    com.tencent.mm.ui.k.b.hXi().clear();
    localObject = com.tencent.mm.plugin.hld.model.n.DEn;
    com.tencent.mm.plugin.hld.model.n.reset();
    g.DCm.gO(paramContext);
    localObject = com.tencent.mm.plugin.hld.model.f.DBL;
    com.tencent.mm.plugin.hld.model.f.reset(paramContext);
    localObject = com.tencent.mm.plugin.hld.candidate.f.Dvh;
    p.k(paramContext, "context");
    ((com.tencent.mm.plugin.hld.candidate.f)localObject).onHide();
    com.tencent.mm.plugin.hld.candidate.f.Dva = false;
    ((com.tencent.mm.plugin.hld.candidate.f)localObject).init(paramContext);
    AppMethodBeat.o(210540);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/utils/WxImeUIUtil$OnSaveListEner;", "", "onFailure", "", "error", "", "onFinish", "onStart", "onSucceed", "filePath", "plugin-hld_release"})
  public static abstract interface a
  {
    public abstract void dL(String paramString);
    
    public abstract void onFinish();
    
    public abstract void onStart();
    
    public abstract void onSucceed(String paramString);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(k.a parama, View paramView, int paramInt, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(209833);
      Object localObject1 = this.DHI;
      if (localObject1 != null) {
        ((k.a)localObject1).onStart();
      }
      OutputStream localOutputStream2 = null;
      k.a locala = null;
      String str = null;
      OutputStream localOutputStream1 = localOutputStream2;
      localObject1 = locala;
      for (;;)
      {
        try
        {
          localObject3 = k.DHH;
          localOutputStream1 = localOutputStream2;
          localObject1 = locala;
          localObject3 = k.fk(paramView);
          localOutputStream1 = localOutputStream2;
          localObject1 = locala;
          k localk = k.DHH;
          localOutputStream1 = localOutputStream2;
          localObject1 = locala;
          if (!k.eGT()) {
            continue;
          }
          localOutputStream1 = localOutputStream2;
          localObject1 = locala;
          str = l.DHK.aG(paramInt, paramBoolean);
          localOutputStream1 = localOutputStream2;
          localObject1 = locala;
          localOutputStream2 = u.Te(str);
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          ((Bitmap)localObject3).compress(Bitmap.CompressFormat.PNG, 90, localOutputStream2);
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          localOutputStream2.flush();
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          localOutputStream2.close();
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          locala = this.DHI;
          localObject1 = localOutputStream2;
          if (locala != null)
          {
            localOutputStream1 = localOutputStream2;
            localObject1 = localOutputStream2;
            locala.onSucceed(str);
            localObject1 = localOutputStream2;
          }
          if (localObject1 != null) {
            ((OutputStream)localObject1).close();
          }
        }
        catch (Exception localException)
        {
          Object localObject3;
          localObject1 = localOutputStream1;
          locala = this.DHI;
          if (locala == null) {
            continue;
          }
          localObject1 = localOutputStream1;
          locala.dL(localException.getMessage());
          localObject1 = localOutputStream1;
          Log.e("WxIme.WxImeUIUtil", "viewSaveToImage " + localException.getMessage());
          if (localOutputStream1 == null) {
            continue;
          }
          localOutputStream1.close();
          continue;
        }
        finally
        {
          if (localObject1 == null) {
            continue;
          }
          ((OutputStream)localObject1).close();
          AppMethodBeat.o(209833);
        }
        paramView.destroyDrawingCache();
        localObject1 = this.DHI;
        if (localObject1 == null) {
          break label324;
        }
        ((k.a)localObject1).onFinish();
        AppMethodBeat.o(209833);
        return;
        localOutputStream1 = localOutputStream2;
        localObject1 = locala;
        localObject3 = this.DHI;
        localObject1 = str;
        if (localObject3 != null)
        {
          localOutputStream1 = localOutputStream2;
          localObject1 = locala;
          ((k.a)localObject3).dL("create fail!");
          localObject1 = str;
        }
      }
      label324:
      AppMethodBeat.o(209833);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.k
 * JD-Core Version:    0.7.0.1
 */