package com.tencent.mm.plugin.hld.f;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Environment;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.g;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/utils/WxImeUIUtil;", "", "()V", "TAG", "", "alternativeWordMaxWidth", "", "associateWordMaxWidth", "colorCacheMap", "", "currentDarkMode", "", "currentInputType", "Ljava/lang/Integer;", "currentOrientation", "lastInputType", "lastOrientation", "mHeightScale", "", "getMHeightScale", "()D", "setMHeightScale", "(D)V", "mKeyboardBottomHeight", "", "getMKeyboardBottomHeight", "()F", "setMKeyboardBottomHeight", "(F)V", "mKeyboardHeight", "getMKeyboardHeight", "()I", "setMKeyboardHeight", "(I)V", "mScreenWidth", "getMScreenWidth", "setMScreenWidth", "mWidthScale", "getMWidthScale", "setMWidthScale", "measuredTextView", "Landroid/widget/TextView;", "nightColorCacheMap", "percent15ScreenWidth", "percent5ScreenWidth", "checkSDCardAvailable", "colorHexToDecimal", "", "hex", "getAdjustTextSize", "text", "allWidth", "maxSize", "minSize", "getAlternativeWordMaxWidth", "getAssociateWordMaxWidth", "getColorByString", "context", "Landroid/content/Context;", "colorString", "getCurInputType", "()Ljava/lang/Integer;", "getCurOrientation", "getHeightScale", "getKeyboardBottomHeight", "getKeyboardHeight", "getLastInputType", "getLastOrientation", "getMeasureWidth", "textSize", "getPercent20ScreenWidth", "getPercent5ScreenWidth", "getRealBottomHeight", "getRealNavigationBarHeight", "getRealNavigationBarVisibility", "getScreenWidth", "getWidthScale", "hexCharDecimal", "hexChar", "", "init", "", "orientation", "isLandscape", "isPaddingViewType", "viewType", "loadBitmapFromView", "Landroid/graphics/Bitmap;", "v", "Landroid/view/View;", "measureTextViewHeight", "textView", "", "deviceWidth", "reset", "resetLastOrientation", "updateConfiguration", "updateInputType", "inputType", "(Ljava/lang/Integer;)V", "viewSaveToImage", "view", "ordinal", "ener", "Lcom/tencent/mm/plugin/hld/utils/WxImeUIUtil$OnSaveListEner;", "OnSaveListEner", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k JyF;
  public static Integer JyG;
  public static Integer JyH;
  public static boolean JyI;
  private static Integer JyJ;
  private static Integer JyK;
  private static TextView JyL;
  private static double JyM;
  private static double JyN;
  private static float JyO;
  private static int JyP;
  private static int JyQ;
  public static int JyR;
  private static int JyS;
  private static final Map<String, Integer> JyT;
  private static final Map<String, Integer> JyU;
  private static int mScreenWidth;
  private static int moI;
  
  static
  {
    AppMethodBeat.i(311790);
    JyF = new k();
    JyI = aw.isDarkMode();
    JyT = (Map)new LinkedHashMap();
    JyU = (Map)new LinkedHashMap();
    AppMethodBeat.o(311790);
  }
  
  public static boolean YI(int paramInt)
  {
    return paramInt >= 5;
  }
  
  public static float a(String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(311713);
    s.u(paramString, "text");
    if (JyL == null) {
      JyL = new TextView(MMApplicationContext.getContext());
    }
    TextView localTextView = JyL;
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
      AppMethodBeat.o(311713);
      return paramFloat2;
    }
    AppMethodBeat.o(311713);
    return f;
  }
  
  public static void a(View paramView, int paramInt, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(311752);
    s.u(paramView, "view");
    paramView.setDrawingCacheEnabled(true);
    paramView.setDrawingCacheQuality(1048576);
    paramView.setDrawingCacheBackgroundColor(-1);
    paramView.layout(0, 0, paramView.getWidth(), paramView.getHeight());
    com.tencent.threadpool.h.ahAA.bm(new k..ExternalSyntheticLambda0(parama, paramView, paramInt, paramBoolean));
    AppMethodBeat.o(311752);
  }
  
  private static final void a(a parama, View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(311784);
    s.u(paramView, "$view");
    if (parama != null) {
      parama.onStart();
    }
    OutputStream localOutputStream2 = null;
    Object localObject2 = null;
    String str = null;
    localOutputStream1 = localOutputStream2;
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
        localOutputStream1 = localOutputStream2;
        localObject1 = localObject2;
        Canvas localCanvas = new Canvas(localBitmap);
        localOutputStream1 = localOutputStream2;
        localObject1 = localObject2;
        localCanvas.drawColor(-1);
        localOutputStream1 = localOutputStream2;
        localObject1 = localObject2;
        paramView.draw(localCanvas);
        localOutputStream1 = localOutputStream2;
        localObject1 = localObject2;
        s.s(localBitmap, "bmp");
        localOutputStream1 = localOutputStream2;
        localObject1 = localObject2;
        if (!s.p(Environment.getExternalStorageState(), "mounted")) {
          continue;
        }
        localOutputStream1 = localOutputStream2;
        localObject1 = localObject2;
        str = l.JyV.bg(paramInt, paramBoolean);
        localOutputStream1 = localOutputStream2;
        localObject1 = localObject2;
        localOutputStream2 = y.ev(str, false);
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        localBitmap.compress(Bitmap.CompressFormat.PNG, 90, localOutputStream2);
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        localOutputStream2.flush();
        localOutputStream1 = localOutputStream2;
        localObject1 = localOutputStream2;
        localOutputStream2.close();
        localObject1 = localOutputStream2;
        if (parama != null)
        {
          localOutputStream1 = localOutputStream2;
          localObject1 = localOutputStream2;
          parama.onSucceed(str);
          localObject1 = localOutputStream2;
        }
        if (localObject1 != null) {
          ((OutputStream)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        if (parama == null) {
          continue;
        }
        localObject1 = localOutputStream1;
        parama.eW(localException.getMessage());
        localObject1 = localOutputStream1;
        Log.e("WxIme.WxImeUIUtil", s.X("viewSaveToImage ", localException.getMessage()));
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
        AppMethodBeat.o(311784);
      }
      paramView.destroyDrawingCache();
      if (parama != null) {
        parama.onFinish();
      }
      AppMethodBeat.o(311784);
      return;
      localObject1 = str;
      if (parama != null)
      {
        localOutputStream1 = localOutputStream2;
        localObject1 = localObject2;
        parama.eW("create fail!");
        localObject1 = str;
      }
    }
  }
  
  public static int b(TextView paramTextView, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(311653);
    s.u(paramTextView, "textView");
    s.u(paramCharSequence, "text");
    paramTextView.setText(paramCharSequence);
    paramTextView.measure(View.MeasureSpec.makeMeasureSpec(paramInt, -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramInt = paramTextView.getMeasuredHeight();
    AppMethodBeat.o(311653);
    return paramInt;
  }
  
  public static int bh(Context paramContext, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(311770);
    s.u(paramContext, "context");
    if (paramString == null)
    {
      AppMethodBeat.o(311770);
      return 0;
    }
    int i;
    if (kotlin.n.n.U(paramString, "#", false))
    {
      paramString = paramString.substring(1);
      s.s(paramString, "(this as java.lang.String).substring(startIndex)");
      s.u(paramString, "hex");
      long l1;
      if ((paramString.length() != 6) && (paramString.length() != 8)) {
        l1 = l2;
      }
      int k;
      do
      {
        i = (int)l1;
        AppMethodBeat.o(311770);
        return i;
        paramContext = paramString;
        if (paramString.length() == 6) {
          paramContext = s.X("FF", paramString);
        }
        k = paramContext.length() - 1;
        l1 = l2;
      } while (k < 0);
      i = 0;
      label131:
      int j = i + 1;
      int m = paramContext.charAt(i);
      if (65 <= m) {
        if (m <= 70)
        {
          i = 1;
          label158:
          if (i == 0) {
            break label207;
          }
          i = m - 65 + 10;
        }
      }
      for (;;)
      {
        l2 = l2 * 16L + i;
        l1 = l2;
        if (j > k) {
          break;
        }
        i = j;
        break label131;
        i = 0;
        break label158;
        i = 0;
        break label158;
        label207:
        if (97 <= m) {
          if (m <= 102) {
            i = 1;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label249;
          }
          i = m - 97 + 10;
          break;
          i = 0;
          continue;
          i = 0;
        }
        label249:
        i = m - 48;
      }
    }
    if (kotlin.n.n.U(paramString, "@color/", false))
    {
      String str = paramString.substring(7);
      s.s(str, "(this as java.lang.String).substring(startIndex)");
      if (aw.isDarkMode()) {}
      Integer localInteger;
      for (paramString = JyU;; paramString = JyT)
      {
        localInteger = (Integer)paramString.get(str);
        if (localInteger != null) {
          break;
        }
        i = a.w(paramContext, paramContext.getResources().getIdentifier(str, "color", paramContext.getPackageName()));
        paramString.put(str, Integer.valueOf(i));
        AppMethodBeat.o(311770);
        return i;
      }
      i = localInteger.intValue();
      AppMethodBeat.o(311770);
      return i;
    }
    AppMethodBeat.o(311770);
    return 0;
  }
  
  public static float c(float paramFloat, String paramString)
  {
    AppMethodBeat.i(311724);
    s.u(paramString, "text");
    if (JyL == null) {
      JyL = new TextView(MMApplicationContext.getContext());
    }
    float f = 0.0F;
    TextView localTextView = JyL;
    if (localTextView != null)
    {
      localTextView.setTextSize(0, paramFloat);
      f = localTextView.getPaint().measureText(paramString);
    }
    AppMethodBeat.o(311724);
    return f;
  }
  
  public static int fOA()
  {
    AppMethodBeat.i(311688);
    if (JyQ != 0)
    {
      i = JyQ;
      AppMethodBeat.o(311688);
      return i;
    }
    DisplayMetrics localDisplayMetrics = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    if (isLandscape()) {}
    for (int i = (int)(localDisplayMetrics.heightPixels * 0.05D);; i = (int)(localDisplayMetrics.widthPixels * 0.05D))
    {
      JyQ = i;
      AppMethodBeat.o(311688);
      return i;
    }
  }
  
  public static int fOB()
  {
    AppMethodBeat.i(311703);
    if (JyS != 0)
    {
      i = JyS;
      AppMethodBeat.o(311703);
      return i;
    }
    if (isLandscape()) {}
    for (int i = (int)(MMApplicationContext.getContext().getResources().getDimension(a.d.ime_width) - a.bs(MMApplicationContext.getContext(), a.d.keyboard_strike_right_container_width) - a.bs(MMApplicationContext.getContext(), a.d.Edge_1_5_A));; i = MMApplicationContext.getContext().getResources().getDisplayMetrics().widthPixels - a.bs(MMApplicationContext.getContext(), a.d.keyboard_strike_right_container_width) - a.bs(MMApplicationContext.getContext(), a.d.Edge_1_5_A))
    {
      JyS = i;
      AppMethodBeat.o(311703);
      return i;
    }
  }
  
  public static Integer fOu()
  {
    return JyG;
  }
  
  public static Integer fOv()
  {
    return JyH;
  }
  
  public static void fOw()
  {
    JyH = JyG;
  }
  
  public static Integer fOx()
  {
    return JyK;
  }
  
  public static Integer fOy()
  {
    return JyJ;
  }
  
  public static int fOz()
  {
    AppMethodBeat.i(311677);
    if (JyP != 0)
    {
      i = JyP;
      AppMethodBeat.o(311677);
      return i;
    }
    DisplayMetrics localDisplayMetrics = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    if (isLandscape()) {}
    for (int i = (int)(localDisplayMetrics.heightPixels * 0.2D);; i = (int)(localDisplayMetrics.widthPixels * 0.2D))
    {
      JyP = i;
      AppMethodBeat.o(311677);
      return i;
    }
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(311615);
    s.u(paramContext, "context");
    if (mScreenWidth == 0)
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      if (paramContext.widthPixels == 0)
      {
        AppMethodBeat.o(311615);
        return 1080;
      }
      mScreenWidth = paramContext.widthPixels;
      Log.d("WxIme.WxImeUIUtil", "getScreenWidth: displayMetrics(" + paramContext.heightPixels + ", " + paramContext.widthPixels + ')');
      Log.i("WxIme.WxImeUIUtil", "getScreenWidth:%s", new Object[] { Integer.valueOf(mScreenWidth) });
    }
    int i = mScreenWidth;
    AppMethodBeat.o(311615);
    return i;
  }
  
  public static int iq(Context paramContext)
  {
    AppMethodBeat.i(311622);
    s.u(paramContext, "context");
    if (moI == 0) {
      moI = a.bs(paramContext, a.d.ime_height);
    }
    int i = moI;
    AppMethodBeat.o(311622);
    return i;
  }
  
  public static float ir(Context paramContext)
  {
    float f = 0.0F;
    AppMethodBeat.i(311627);
    int i;
    if (JyO == 0.0F)
    {
      i = 1;
      if (i != 0) {
        if (paramContext != null) {
          break label47;
        }
      }
    }
    for (;;)
    {
      JyO = f;
      f = JyO;
      AppMethodBeat.o(311627);
      return f;
      i = 0;
      break;
      label47:
      paramContext = paramContext.getResources();
      if (paramContext != null) {
        f = paramContext.getDimension(a.d.ime_keyboard_height);
      }
    }
  }
  
  public static double is(Context paramContext)
  {
    AppMethodBeat.i(311636);
    s.u(paramContext, "context");
    int i;
    if (JyM == 0.0D) {
      i = 1;
    }
    DisplayMetrics localDisplayMetrics;
    while (i != 0)
    {
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (localDisplayMetrics.widthPixels == 0)
      {
        AppMethodBeat.o(311636);
        return 1.0D;
        i = 0;
      }
      else
      {
        if (!isLandscape()) {
          break label170;
        }
      }
    }
    label170:
    for (double d = paramContext.getResources().getDimension(a.d.ime_width) / 662.0D;; d = localDisplayMetrics.widthPixels / 400.0D)
    {
      JyM = d;
      Log.d("WxIme.WxImeUIUtil", "getWidthScale: displayMetrics(" + localDisplayMetrics.heightPixels + ", " + localDisplayMetrics.widthPixels + ") isLandscape " + isLandscape());
      Log.i("WxIme.WxImeUIUtil", "getWidthScale:%s", new Object[] { Double.valueOf(JyM) });
      d = JyM;
      AppMethodBeat.o(311636);
      return d;
    }
  }
  
  public static boolean isLandscape()
  {
    AppMethodBeat.i(311587);
    if (MMApplicationContext.getContext().getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(311587);
      return true;
    }
    AppMethodBeat.o(311587);
    return false;
  }
  
  public static double it(Context paramContext)
  {
    AppMethodBeat.i(311647);
    s.u(paramContext, "context");
    if (JyN == 0.0D) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        JyN = paramContext.getResources().getDimension(a.d.S2_button_height) / paramContext.getResources().getInteger(a.g.S2_button_height);
        Log.i("WxIme.WxImeUIUtil", "getHeightScale:%s", new Object[] { Double.valueOf(JyN) });
      }
      double d = JyN;
      AppMethodBeat.o(311647);
      return d;
    }
  }
  
  public static int iu(Context paramContext)
  {
    AppMethodBeat.i(311739);
    if (paramContext == null)
    {
      i = 0;
      if ((i <= 0) || (i == aw.getStatusBarHeight(paramContext))) {
        break label154;
      }
      i = 1;
      label26:
      if (i == 0) {
        break label159;
      }
      i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (i <= 0) {
        break label167;
      }
    }
    label154:
    label159:
    label167:
    for (int i = Resources.getSystem().getDimensionPixelSize(i);; i = 0)
    {
      AppMethodBeat.o(311739);
      return i;
      Object localObject1 = paramContext.getSystemService("window");
      if (localObject1 == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        AppMethodBeat.o(311739);
        throw paramContext;
      }
      Object localObject2 = ((WindowManager)localObject1).getDefaultDisplay();
      localObject1 = new Point();
      ((Display)localObject2).getSize((Point)localObject1);
      localObject2 = aw.bf(paramContext);
      i = Math.max(((Point)localObject1).y, ((Point)localObject1).x);
      i = Math.max(((Point)localObject2).y, ((Point)localObject2).x) - i;
      break;
      i = 0;
      break label26;
      AppMethodBeat.o(311739);
      return 0;
    }
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(311602);
    Log.i("WxIme.WxImeUIUtil", "reset");
    mScreenWidth = 0;
    JyM = 0.0D;
    JyN = 0.0D;
    JyP = 0;
    JyQ = 0;
    JyS = 0;
    JyR = 0;
    moI = 0;
    JyO = 0.0F;
    a.iRh();
    Object localObject = (d)com.tencent.mm.kernel.h.ax(d.class);
    if (localObject != null)
    {
      localObject = ((d)localObject).fKG();
      if (localObject != null) {
        ((com.tencent.mm.plugin.hld.a.b)localObject).reset();
      }
    }
    localObject = g.JuL;
    g.reset();
    localObject = com.tencent.mm.ui.k.b.afwA;
    com.tencent.mm.ui.k.b.jBF().clear();
    localObject = com.tencent.mm.plugin.hld.model.n.JvW;
    com.tencent.mm.plugin.hld.model.n.reset();
    g.JuL.ii(paramContext);
    localObject = com.tencent.mm.plugin.hld.model.f.JuH;
    com.tencent.mm.plugin.hld.model.f.reset(paramContext);
    com.tencent.mm.plugin.hld.candidate.f.Jor.reset(paramContext);
    AppMethodBeat.o(311602);
  }
  
  public static void sE(int paramInt)
  {
    AppMethodBeat.i(311539);
    JyG = Integer.valueOf(paramInt);
    AppMethodBeat.o(311539);
  }
  
  public static void x(Integer paramInteger)
  {
    JyJ = JyK;
    JyK = paramInteger;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/utils/WxImeUIUtil$OnSaveListEner;", "", "onFailure", "", "error", "", "onFinish", "onStart", "onSucceed", "filePath", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void eW(String paramString);
    
    public abstract void onFinish();
    
    public abstract void onStart();
    
    public abstract void onSucceed(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.k
 * JD-Core Version:    0.7.0.1
 */