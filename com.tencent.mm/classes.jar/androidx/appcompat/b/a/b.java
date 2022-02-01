package androidx.appcompat.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import androidx.core.graphics.drawable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class b
  extends Drawable
  implements Drawable.Callback
{
  private boolean jA;
  private b jK;
  private Rect jL;
  private Drawable jM;
  private Drawable jN;
  private boolean jO;
  private int jP = -1;
  private int jQ = -1;
  private Runnable jR;
  private long jS;
  private long jT;
  private a jU;
  private int mAlpha = 255;
  
  static int a(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(199314);
    if (paramResources == null) {}
    while (paramInt == 0)
    {
      AppMethodBeat.o(199314);
      return 160;
      paramInt = paramResources.getDisplayMetrics().densityDpi;
    }
    AppMethodBeat.o(199314);
    return paramInt;
  }
  
  /* Error */
  private void b(Drawable paramDrawable)
  {
    // Byte code:
    //   0: ldc 70
    //   2: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 72	androidx/appcompat/b/a/b:jU	Landroidx/appcompat/b/a/b$a;
    //   9: ifnonnull +14 -> 23
    //   12: aload_0
    //   13: new 10	androidx/appcompat/b/a/b$a
    //   16: dup
    //   17: invokespecial 73	androidx/appcompat/b/a/b$a:<init>	()V
    //   20: putfield 72	androidx/appcompat/b/a/b:jU	Landroidx/appcompat/b/a/b$a;
    //   23: aload_0
    //   24: getfield 72	androidx/appcompat/b/a/b:jU	Landroidx/appcompat/b/a/b$a;
    //   27: astore_2
    //   28: aload_2
    //   29: aload_1
    //   30: invokevirtual 77	android/graphics/drawable/Drawable:getCallback	()Landroid/graphics/drawable/Drawable$Callback;
    //   33: putfield 81	androidx/appcompat/b/a/b$a:jW	Landroid/graphics/drawable/Drawable$Callback;
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 85	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   41: aload_0
    //   42: getfield 87	androidx/appcompat/b/a/b:jK	Landroidx/appcompat/b/a/b$b;
    //   45: getfield 90	androidx/appcompat/b/a/b$b:ku	I
    //   48: ifgt +18 -> 66
    //   51: aload_0
    //   52: getfield 92	androidx/appcompat/b/a/b:jO	Z
    //   55: ifeq +11 -> 66
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 41	androidx/appcompat/b/a/b:mAlpha	I
    //   63: invokevirtual 95	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   66: aload_0
    //   67: getfield 87	androidx/appcompat/b/a/b:jK	Landroidx/appcompat/b/a/b$b;
    //   70: getfield 98	androidx/appcompat/b/a/b$b:ky	Z
    //   73: ifeq +151 -> 224
    //   76: aload_1
    //   77: aload_0
    //   78: getfield 87	androidx/appcompat/b/a/b:jK	Landroidx/appcompat/b/a/b$b;
    //   81: getfield 102	androidx/appcompat/b/a/b$b:kx	Landroid/graphics/ColorFilter;
    //   84: invokevirtual 106	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   87: aload_1
    //   88: aload_0
    //   89: invokevirtual 110	androidx/appcompat/b/a/b:isVisible	()Z
    //   92: iconst_1
    //   93: invokevirtual 114	android/graphics/drawable/Drawable:setVisible	(ZZ)Z
    //   96: pop
    //   97: aload_1
    //   98: aload_0
    //   99: getfield 87	androidx/appcompat/b/a/b:jK	Landroidx/appcompat/b/a/b$b;
    //   102: getfield 117	androidx/appcompat/b/a/b$b:kt	Z
    //   105: invokevirtual 121	android/graphics/drawable/Drawable:setDither	(Z)V
    //   108: aload_1
    //   109: aload_0
    //   110: invokevirtual 125	androidx/appcompat/b/a/b:getState	()[I
    //   113: invokevirtual 129	android/graphics/drawable/Drawable:setState	([I)Z
    //   116: pop
    //   117: aload_1
    //   118: aload_0
    //   119: invokevirtual 133	androidx/appcompat/b/a/b:getLevel	()I
    //   122: invokevirtual 137	android/graphics/drawable/Drawable:setLevel	(I)Z
    //   125: pop
    //   126: aload_1
    //   127: aload_0
    //   128: invokevirtual 141	androidx/appcompat/b/a/b:getBounds	()Landroid/graphics/Rect;
    //   131: invokevirtual 145	android/graphics/drawable/Drawable:setBounds	(Landroid/graphics/Rect;)V
    //   134: getstatic 150	android/os/Build$VERSION:SDK_INT	I
    //   137: bipush 23
    //   139: if_icmplt +12 -> 151
    //   142: aload_1
    //   143: aload_0
    //   144: invokevirtual 153	androidx/appcompat/b/a/b:getLayoutDirection	()I
    //   147: invokevirtual 156	android/graphics/drawable/Drawable:setLayoutDirection	(I)Z
    //   150: pop
    //   151: getstatic 150	android/os/Build$VERSION:SDK_INT	I
    //   154: bipush 19
    //   156: if_icmplt +14 -> 170
    //   159: aload_1
    //   160: aload_0
    //   161: getfield 87	androidx/appcompat/b/a/b:jK	Landroidx/appcompat/b/a/b$b;
    //   164: getfield 159	androidx/appcompat/b/a/b$b:kw	Z
    //   167: invokevirtual 162	android/graphics/drawable/Drawable:setAutoMirrored	(Z)V
    //   170: aload_0
    //   171: getfield 164	androidx/appcompat/b/a/b:jL	Landroid/graphics/Rect;
    //   174: astore_2
    //   175: getstatic 150	android/os/Build$VERSION:SDK_INT	I
    //   178: bipush 21
    //   180: if_icmplt +27 -> 207
    //   183: aload_2
    //   184: ifnull +23 -> 207
    //   187: aload_1
    //   188: aload_2
    //   189: getfield 169	android/graphics/Rect:left	I
    //   192: aload_2
    //   193: getfield 172	android/graphics/Rect:top	I
    //   196: aload_2
    //   197: getfield 175	android/graphics/Rect:right	I
    //   200: aload_2
    //   201: getfield 178	android/graphics/Rect:bottom	I
    //   204: invokevirtual 182	android/graphics/drawable/Drawable:setHotspotBounds	(IIII)V
    //   207: aload_1
    //   208: aload_0
    //   209: getfield 72	androidx/appcompat/b/a/b:jU	Landroidx/appcompat/b/a/b$a;
    //   212: invokevirtual 185	androidx/appcompat/b/a/b$a:cn	()Landroid/graphics/drawable/Drawable$Callback;
    //   215: invokevirtual 85	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   218: ldc 70
    //   220: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: return
    //   224: aload_0
    //   225: getfield 87	androidx/appcompat/b/a/b:jK	Landroidx/appcompat/b/a/b$b;
    //   228: getfield 188	androidx/appcompat/b/a/b$b:kB	Z
    //   231: ifeq +14 -> 245
    //   234: aload_1
    //   235: aload_0
    //   236: getfield 87	androidx/appcompat/b/a/b:jK	Landroidx/appcompat/b/a/b$b;
    //   239: getfield 192	androidx/appcompat/b/a/b$b:kz	Landroid/content/res/ColorStateList;
    //   242: invokestatic 197	androidx/core/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    //   245: aload_0
    //   246: getfield 87	androidx/appcompat/b/a/b:jK	Landroidx/appcompat/b/a/b$b;
    //   249: getfield 200	androidx/appcompat/b/a/b$b:kC	Z
    //   252: ifeq -165 -> 87
    //   255: aload_1
    //   256: aload_0
    //   257: getfield 87	androidx/appcompat/b/a/b:jK	Landroidx/appcompat/b/a/b$b;
    //   260: getfield 204	androidx/appcompat/b/a/b$b:kA	Landroid/graphics/PorterDuff$Mode;
    //   263: invokestatic 207	androidx/core/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    //   266: goto -179 -> 87
    //   269: astore_2
    //   270: aload_1
    //   271: aload_0
    //   272: getfield 72	androidx/appcompat/b/a/b:jU	Landroidx/appcompat/b/a/b$a;
    //   275: invokevirtual 185	androidx/appcompat/b/a/b$a:cn	()Landroid/graphics/drawable/Drawable$Callback;
    //   278: invokevirtual 85	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   281: ldc 70
    //   283: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: aload_2
    //   287: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	b
    //   0	288	1	paramDrawable	Drawable
    //   27	174	2	localObject1	Object
    //   269	18	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   41	66	269	finally
    //   66	87	269	finally
    //   87	151	269	finally
    //   151	170	269	finally
    //   170	183	269	finally
    //   187	207	269	finally
    //   224	245	269	finally
    //   245	266	269	finally
  }
  
  final void I(boolean paramBoolean)
  {
    AppMethodBeat.i(199618);
    this.jO = true;
    long l = SystemClock.uptimeMillis();
    if (this.jM != null)
    {
      if (this.jS != 0L)
      {
        if (this.jS > l) {
          break label142;
        }
        this.jM.setAlpha(this.mAlpha);
      }
    }
    else {
      this.jS = 0L;
    }
    int i = 0;
    if (this.jN != null)
    {
      j = i;
      if (this.jT != 0L)
      {
        if (this.jT > l) {
          break label189;
        }
        this.jN.setVisible(false, false);
        this.jN = null;
        this.jQ = -1;
      }
    }
    else
    {
      this.jT = 0L;
    }
    for (int j = i;; j = 1)
    {
      if ((paramBoolean) && (j != 0)) {
        scheduleSelf(this.jR, 16L + l);
      }
      AppMethodBeat.o(199618);
      return;
      label142:
      i = (int)((this.jS - l) * 255L) / this.jK.ku;
      this.jM.setAlpha((255 - i) * this.mAlpha / 255);
      i = 1;
      break;
      label189:
      i = (int)((this.jT - l) * 255L) / this.jK.kv;
      this.jN.setAlpha(i * this.mAlpha / 255);
    }
  }
  
  final boolean X(int paramInt)
  {
    AppMethodBeat.i(199603);
    if (paramInt == this.jP)
    {
      AppMethodBeat.o(199603);
      return false;
    }
    long l = SystemClock.uptimeMillis();
    if (this.jK.kv > 0)
    {
      if (this.jN != null) {
        this.jN.setVisible(false, false);
      }
      if (this.jM != null)
      {
        this.jN = this.jM;
        this.jQ = this.jP;
        this.jT = (this.jK.kv + l);
        if ((paramInt < 0) || (paramInt >= this.jK.kd)) {
          break label250;
        }
        Drawable localDrawable = this.jK.Y(paramInt);
        this.jM = localDrawable;
        this.jP = paramInt;
        if (localDrawable != null)
        {
          if (this.jK.ku > 0) {
            this.jS = (l + this.jK.ku);
          }
          b(localDrawable);
        }
        label159:
        if ((this.jS != 0L) || (this.jT != 0L))
        {
          if (this.jR != null) {
            break label263;
          }
          this.jR = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(199301);
              b.this.I(true);
              b.this.invalidateSelf();
              AppMethodBeat.o(199301);
            }
          };
        }
      }
    }
    for (;;)
    {
      I(true);
      invalidateSelf();
      AppMethodBeat.o(199603);
      return true;
      this.jN = null;
      this.jQ = -1;
      this.jT = 0L;
      break;
      if (this.jM == null) {
        break;
      }
      this.jM.setVisible(false, false);
      break;
      label250:
      this.jM = null;
      this.jP = -1;
      break label159;
      label263:
      unscheduleSelf(this.jR);
    }
  }
  
  protected void a(b paramb)
  {
    AppMethodBeat.i(199684);
    this.jK = paramb;
    if (this.jP >= 0)
    {
      this.jM = paramb.Y(this.jP);
      if (this.jM != null) {
        b(this.jM);
      }
    }
    this.jQ = -1;
    this.jN = null;
    AppMethodBeat.o(199684);
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    AppMethodBeat.i(199650);
    b localb = this.jK;
    if (paramTheme != null)
    {
      localb.cp();
      int j = localb.kd;
      Drawable[] arrayOfDrawable = localb.kc;
      int i = 0;
      while (i < j)
      {
        if ((arrayOfDrawable[i] != null) && (arrayOfDrawable[i].canApplyTheme()))
        {
          arrayOfDrawable[i].applyTheme(paramTheme);
          localb.ka |= arrayOfDrawable[i].getChangingConfigurations();
        }
        i += 1;
      }
      localb.e(paramTheme.getResources());
    }
    AppMethodBeat.o(199650);
  }
  
  public boolean canApplyTheme()
  {
    AppMethodBeat.i(199653);
    boolean bool = this.jK.canApplyTheme();
    AppMethodBeat.o(199653);
    return bool;
  }
  
  b cj()
  {
    return this.jK;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(199321);
    if (this.jM != null) {
      this.jM.draw(paramCanvas);
    }
    if (this.jN != null) {
      this.jN.draw(paramCanvas);
    }
    AppMethodBeat.o(199321);
  }
  
  final void e(Resources paramResources)
  {
    AppMethodBeat.i(199637);
    this.jK.e(paramResources);
    AppMethodBeat.o(199637);
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public int getChangingConfigurations()
  {
    AppMethodBeat.i(199325);
    int i = super.getChangingConfigurations();
    int j = this.jK.getChangingConfigurations();
    AppMethodBeat.o(199325);
    return i | j;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    AppMethodBeat.i(199663);
    if (this.jK.canConstantState())
    {
      this.jK.mChangingConfigurations = getChangingConfigurations();
      b localb = this.jK;
      AppMethodBeat.o(199663);
      return localb;
    }
    AppMethodBeat.o(199663);
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.jM;
  }
  
  final int getCurrentIndex()
  {
    return this.jP;
  }
  
  public void getHotspotBounds(Rect paramRect)
  {
    AppMethodBeat.i(199446);
    if (this.jL != null)
    {
      paramRect.set(this.jL);
      AppMethodBeat.o(199446);
      return;
    }
    super.getHotspotBounds(paramRect);
    AppMethodBeat.o(199446);
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(199503);
    int i;
    if (this.jK.kh)
    {
      b localb = this.jK;
      if (!localb.ki) {
        localb.cq();
      }
      i = localb.kk;
      AppMethodBeat.o(199503);
      return i;
    }
    if (this.jM != null)
    {
      i = this.jM.getIntrinsicHeight();
      AppMethodBeat.o(199503);
      return i;
    }
    AppMethodBeat.o(199503);
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(199493);
    int i;
    if (this.jK.kh)
    {
      b localb = this.jK;
      if (!localb.ki) {
        localb.cq();
      }
      i = localb.kj;
      AppMethodBeat.o(199493);
      return i;
    }
    if (this.jM != null)
    {
      i = this.jM.getIntrinsicWidth();
      AppMethodBeat.o(199493);
      return i;
    }
    AppMethodBeat.o(199493);
    return -1;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(199526);
    int i;
    if (this.jK.kh)
    {
      b localb = this.jK;
      if (!localb.ki) {
        localb.cq();
      }
      i = localb.km;
      AppMethodBeat.o(199526);
      return i;
    }
    if (this.jM != null)
    {
      i = this.jM.getMinimumHeight();
      AppMethodBeat.o(199526);
      return i;
    }
    AppMethodBeat.o(199526);
    return 0;
  }
  
  public int getMinimumWidth()
  {
    AppMethodBeat.i(199514);
    int i;
    if (this.jK.kh)
    {
      b localb = this.jK;
      if (!localb.ki) {
        localb.cq();
      }
      i = localb.kl;
      AppMethodBeat.o(199514);
      return i;
    }
    if (this.jM != null)
    {
      i = this.jM.getMinimumWidth();
      AppMethodBeat.o(199514);
      return i;
    }
    AppMethodBeat.o(199514);
    return 0;
  }
  
  public int getOpacity()
  {
    int i = -2;
    AppMethodBeat.i(199577);
    if ((this.jM == null) || (!this.jM.isVisible()))
    {
      AppMethodBeat.o(199577);
      return -2;
    }
    b localb = this.jK;
    if (localb.kn)
    {
      i = localb.ko;
      AppMethodBeat.o(199577);
      return i;
    }
    localb.cp();
    int k = localb.kd;
    Drawable[] arrayOfDrawable = localb.kc;
    if (k > 0) {
      i = arrayOfDrawable[0].getOpacity();
    }
    int j = 1;
    while (j < k)
    {
      i = Drawable.resolveOpacity(i, arrayOfDrawable[j].getOpacity());
      j += 1;
    }
    localb.ko = i;
    localb.kn = true;
    AppMethodBeat.o(199577);
    return i;
  }
  
  public void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(199339);
    if (this.jM != null) {
      this.jM.getOutline(paramOutline);
    }
    AppMethodBeat.o(199339);
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 1;
    AppMethodBeat.i(199333);
    b localb = this.jK;
    int k;
    boolean bool;
    if (localb.ke)
    {
      localObject1 = localObject2;
      if (localObject1 == null) {
        break label363;
      }
      paramRect.set((Rect)localObject1);
      i = ((Rect)localObject1).left;
      k = ((Rect)localObject1).top;
      int m = ((Rect)localObject1).bottom;
      if ((((Rect)localObject1).right | i | k | m) == 0) {
        break label357;
      }
      bool = true;
      label82:
      if ((!isAutoMirrored()) || (getLayoutDirection() != 1)) {
        break label393;
      }
    }
    label393:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        i = paramRect.left;
        paramRect.left = paramRect.right;
        paramRect.right = i;
      }
      AppMethodBeat.o(199333);
      return bool;
      if ((localb.kg != null) || (localb.kf))
      {
        localObject1 = localb.kg;
        break;
      }
      localb.cp();
      Rect localRect = new Rect();
      k = localb.kd;
      Drawable[] arrayOfDrawable = localb.kc;
      i = 0;
      while (i < k)
      {
        Object localObject3 = localObject1;
        if (arrayOfDrawable[i].getPadding(localRect))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Rect(0, 0, 0, 0);
          }
          if (localRect.left > ((Rect)localObject2).left) {
            ((Rect)localObject2).left = localRect.left;
          }
          if (localRect.top > ((Rect)localObject2).top) {
            ((Rect)localObject2).top = localRect.top;
          }
          if (localRect.right > ((Rect)localObject2).right) {
            ((Rect)localObject2).right = localRect.right;
          }
          localObject3 = localObject2;
          if (localRect.bottom > ((Rect)localObject2).bottom)
          {
            ((Rect)localObject2).bottom = localRect.bottom;
            localObject3 = localObject2;
          }
        }
        i += 1;
        localObject1 = localObject3;
      }
      localb.kf = true;
      localb.kg = ((Rect)localObject1);
      break;
      label357:
      bool = false;
      break label82;
      label363:
      if (this.jM != null)
      {
        bool = this.jM.getPadding(paramRect);
        break label82;
      }
      bool = super.getPadding(paramRect);
      break label82;
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199537);
    if (this.jK != null) {
      this.jK.co();
    }
    if ((paramDrawable == this.jM) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
    AppMethodBeat.o(199537);
  }
  
  public boolean isAutoMirrored()
  {
    return this.jK.kw;
  }
  
  public boolean isStateful()
  {
    boolean bool2 = false;
    AppMethodBeat.i(199399);
    b localb = this.jK;
    boolean bool1;
    if (localb.kp)
    {
      bool1 = localb.kq;
      AppMethodBeat.o(199399);
      return bool1;
    }
    localb.cp();
    int j = localb.kd;
    Drawable[] arrayOfDrawable = localb.kc;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (arrayOfDrawable[i].isStateful()) {
          bool1 = true;
        }
      }
      else
      {
        localb.kq = bool1;
        localb.kp = true;
        AppMethodBeat.o(199399);
        return bool1;
      }
      i += 1;
    }
  }
  
  public void jumpToCurrentState()
  {
    int j = 1;
    AppMethodBeat.i(199420);
    int i = 0;
    if (this.jN != null)
    {
      this.jN.jumpToCurrentState();
      this.jN = null;
      this.jQ = -1;
      i = 1;
    }
    if (this.jM != null)
    {
      this.jM.jumpToCurrentState();
      if (this.jO) {
        this.jM.setAlpha(this.mAlpha);
      }
    }
    if (this.jT != 0L)
    {
      this.jT = 0L;
      i = 1;
    }
    if (this.jS != 0L)
    {
      this.jS = 0L;
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        invalidateSelf();
      }
      AppMethodBeat.o(199420);
      return;
    }
  }
  
  public Drawable mutate()
  {
    AppMethodBeat.i(199669);
    if ((!this.jA) && (super.mutate() == this))
    {
      b localb = cj();
      localb.ck();
      a(localb);
      this.jA = true;
    }
    AppMethodBeat.o(199669);
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(199389);
    if (this.jN != null) {
      this.jN.setBounds(paramRect);
    }
    if (this.jM != null) {
      this.jM.setBounds(paramRect);
    }
    AppMethodBeat.o(199389);
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    AppMethodBeat.i(199478);
    b localb = this.jK;
    int j = this.jP;
    int k = localb.kd;
    Drawable[] arrayOfDrawable = localb.kc;
    int i = 0;
    boolean bool1 = false;
    if (i < k)
    {
      if (arrayOfDrawable[i] == null) {
        break label98;
      }
      if (Build.VERSION.SDK_INT < 23) {
        break label105;
      }
    }
    label98:
    label105:
    for (boolean bool2 = arrayOfDrawable[i].setLayoutDirection(paramInt);; bool2 = false)
    {
      if (i == j) {}
      for (;;)
      {
        i += 1;
        bool1 = bool2;
        break;
        localb.mLayoutDirection = paramInt;
        AppMethodBeat.o(199478);
        return bool1;
        bool2 = bool1;
      }
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    AppMethodBeat.i(199465);
    boolean bool;
    if (this.jN != null)
    {
      bool = this.jN.setLevel(paramInt);
      AppMethodBeat.o(199465);
      return bool;
    }
    if (this.jM != null)
    {
      bool = this.jM.setLevel(paramInt);
      AppMethodBeat.o(199465);
      return bool;
    }
    AppMethodBeat.o(199465);
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(199457);
    boolean bool;
    if (this.jN != null)
    {
      bool = this.jN.setState(paramArrayOfInt);
      AppMethodBeat.o(199457);
      return bool;
    }
    if (this.jM != null)
    {
      bool = this.jM.setState(paramArrayOfInt);
      AppMethodBeat.o(199457);
      return bool;
    }
    AppMethodBeat.o(199457);
    return false;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(199546);
    if ((paramDrawable == this.jM) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
    AppMethodBeat.o(199546);
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(199343);
    if ((!this.jO) || (this.mAlpha != paramInt))
    {
      this.jO = true;
      this.mAlpha = paramInt;
      if (this.jM != null)
      {
        if (this.jS == 0L)
        {
          this.jM.setAlpha(paramInt);
          AppMethodBeat.o(199343);
          return;
        }
        I(false);
      }
    }
    AppMethodBeat.o(199343);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    AppMethodBeat.i(199406);
    if (this.jK.kw != paramBoolean)
    {
      this.jK.kw = paramBoolean;
      if (this.jM != null) {
        a.b(this.jM, this.jK.kw);
      }
    }
    AppMethodBeat.o(199406);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(199365);
    this.jK.ky = true;
    if (this.jK.kx != paramColorFilter)
    {
      this.jK.kx = paramColorFilter;
      if (this.jM != null) {
        this.jM.setColorFilter(paramColorFilter);
      }
    }
    AppMethodBeat.o(199365);
  }
  
  public void setDither(boolean paramBoolean)
  {
    AppMethodBeat.i(199357);
    if (this.jK.kt != paramBoolean)
    {
      this.jK.kt = paramBoolean;
      if (this.jM != null) {
        this.jM.setDither(this.jK.kt);
      }
    }
    AppMethodBeat.o(199357);
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199427);
    if (this.jM != null) {
      a.a(this.jM, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(199427);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199436);
    if (this.jL == null) {
      this.jL = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      if (this.jM != null) {
        a.a(this.jM, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(199436);
      return;
      this.jL.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(199370);
    this.jK.kB = true;
    if (this.jK.kz != paramColorStateList)
    {
      this.jK.kz = paramColorStateList;
      a.a(this.jM, paramColorStateList);
    }
    AppMethodBeat.o(199370);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(199380);
    this.jK.kC = true;
    if (this.jK.kA != paramMode)
    {
      this.jK.kA = paramMode;
      a.a(this.jM, paramMode);
    }
    AppMethodBeat.o(199380);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(199566);
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.jN != null) {
      this.jN.setVisible(paramBoolean1, paramBoolean2);
    }
    if (this.jM != null) {
      this.jM.setVisible(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(199566);
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    AppMethodBeat.i(199556);
    if ((paramDrawable == this.jM) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
    AppMethodBeat.o(199556);
  }
  
  static final class a
    implements Drawable.Callback
  {
    Drawable.Callback jW;
    
    public final Drawable.Callback cn()
    {
      Drawable.Callback localCallback = this.jW;
      this.jW = null;
      return localCallback;
    }
    
    public final void invalidateDrawable(Drawable paramDrawable) {}
    
    public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(199316);
      if (this.jW != null) {
        this.jW.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
      AppMethodBeat.o(199316);
    }
    
    public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      AppMethodBeat.i(199327);
      if (this.jW != null) {
        this.jW.unscheduleDrawable(paramDrawable, paramRunnable);
      }
      AppMethodBeat.o(199327);
    }
  }
  
  static abstract class b
    extends Drawable.ConstantState
  {
    boolean jA;
    final b jX;
    Resources jY;
    int jZ = 160;
    PorterDuff.Mode kA;
    boolean kB;
    boolean kC;
    int ka;
    SparseArray<Drawable.ConstantState> kb;
    Drawable[] kc;
    int kd;
    boolean ke = false;
    boolean kf;
    Rect kg;
    boolean kh = false;
    boolean ki;
    int kj;
    int kk;
    int kl;
    int km;
    boolean kn;
    int ko;
    boolean kp;
    boolean kq;
    boolean kr;
    boolean ks;
    boolean kt = true;
    int ku = 0;
    int kv = 0;
    boolean kw;
    ColorFilter kx;
    boolean ky;
    ColorStateList kz;
    int mChangingConfigurations;
    int mLayoutDirection;
    
    b(b paramb, b paramb1, Resources paramResources)
    {
      this.jX = paramb1;
      int i;
      if (paramResources != null)
      {
        paramb1 = paramResources;
        this.jY = paramb1;
        if (paramb == null) {
          break label450;
        }
        i = paramb.jZ;
        label65:
        this.jZ = b.a(paramResources, i);
        if (paramb == null) {
          break label488;
        }
        this.mChangingConfigurations = paramb.mChangingConfigurations;
        this.ka = paramb.ka;
        this.kr = true;
        this.ks = true;
        this.ke = paramb.ke;
        this.kh = paramb.kh;
        this.kt = paramb.kt;
        this.jA = paramb.jA;
        this.mLayoutDirection = paramb.mLayoutDirection;
        this.ku = paramb.ku;
        this.kv = paramb.kv;
        this.kw = paramb.kw;
        this.kx = paramb.kx;
        this.ky = paramb.ky;
        this.kz = paramb.kz;
        this.kA = paramb.kA;
        this.kB = paramb.kB;
        this.kC = paramb.kC;
        if (paramb.jZ == this.jZ)
        {
          if (paramb.kf)
          {
            this.kg = new Rect(paramb.kg);
            this.kf = true;
          }
          if (paramb.ki)
          {
            this.kj = paramb.kj;
            this.kk = paramb.kk;
            this.kl = paramb.kl;
            this.km = paramb.km;
            this.ki = true;
          }
        }
        if (paramb.kn)
        {
          this.ko = paramb.ko;
          this.kn = true;
        }
        if (paramb.kp)
        {
          this.kq = paramb.kq;
          this.kp = true;
        }
        paramb1 = paramb.kc;
        this.kc = new Drawable[paramb1.length];
        this.kd = paramb.kd;
        paramb = paramb.kb;
        if (paramb == null) {
          break label456;
        }
        this.kb = paramb.clone();
        label378:
        int k = this.kd;
        i = j;
        label388:
        if (i >= k) {
          return;
        }
        if (paramb1[i] != null)
        {
          paramb = paramb1[i].getConstantState();
          if (paramb == null) {
            break label474;
          }
          this.kb.put(i, paramb);
        }
      }
      for (;;)
      {
        i += 1;
        break label388;
        if (paramb != null)
        {
          paramb1 = paramb.jY;
          break;
        }
        paramb1 = null;
        break;
        label450:
        i = 0;
        break label65;
        label456:
        this.kb = new SparseArray(this.kd);
        break label378;
        label474:
        this.kc[i] = paramb1[i];
      }
      label488:
      this.kc = new Drawable[10];
      this.kd = 0;
    }
    
    private Drawable d(Drawable paramDrawable)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(this.mLayoutDirection);
      }
      paramDrawable = paramDrawable.mutate();
      paramDrawable.setCallback(this.jX);
      return paramDrawable;
    }
    
    public final Drawable Y(int paramInt)
    {
      Object localObject = this.kc[paramInt];
      if (localObject != null) {}
      Drawable localDrawable;
      do
      {
        return localObject;
        if (this.kb == null) {
          break;
        }
        int i = this.kb.indexOfKey(paramInt);
        if (i < 0) {
          break;
        }
        localDrawable = d(((Drawable.ConstantState)this.kb.valueAt(i)).newDrawable(this.jY));
        this.kc[paramInt] = localDrawable;
        this.kb.removeAt(i);
        localObject = localDrawable;
      } while (this.kb.size() != 0);
      this.kb = null;
      return localDrawable;
      return null;
    }
    
    public final int c(Drawable paramDrawable)
    {
      int i = this.kd;
      if (i >= this.kc.length) {
        m(i, i + 10);
      }
      paramDrawable.mutate();
      paramDrawable.setVisible(false, true);
      paramDrawable.setCallback(this.jX);
      this.kc[i] = paramDrawable;
      this.kd += 1;
      this.ka |= paramDrawable.getChangingConfigurations();
      co();
      this.kg = null;
      this.kf = false;
      this.ki = false;
      this.kr = false;
      return i;
    }
    
    public boolean canApplyTheme()
    {
      int j = this.kd;
      Drawable[] arrayOfDrawable = this.kc;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfDrawable[i];
        if (localObject != null)
        {
          if (((Drawable)localObject).canApplyTheme()) {
            return true;
          }
        }
        else
        {
          localObject = (Drawable.ConstantState)this.kb.get(i);
          if ((localObject != null) && (((Drawable.ConstantState)localObject).canApplyTheme())) {
            return true;
          }
        }
        i += 1;
      }
      return false;
    }
    
    public final boolean canConstantState()
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          if (this.kr)
          {
            bool = this.ks;
            return bool;
          }
          cp();
          this.kr = true;
          int j = this.kd;
          Drawable[] arrayOfDrawable = this.kc;
          int i = 0;
          if (i >= j) {
            break label79;
          }
          if (arrayOfDrawable[i].getConstantState() == null)
          {
            this.ks = false;
            continue;
          }
          i += 1;
        }
        finally {}
        continue;
        label79:
        this.ks = true;
        bool = true;
      }
    }
    
    void ck()
    {
      int j = this.kd;
      Drawable[] arrayOfDrawable = this.kc;
      int i = 0;
      while (i < j)
      {
        if (arrayOfDrawable[i] != null) {
          arrayOfDrawable[i].mutate();
        }
        i += 1;
      }
      this.jA = true;
    }
    
    final void co()
    {
      this.kn = false;
      this.kp = false;
    }
    
    final void cp()
    {
      if (this.kb != null)
      {
        int j = this.kb.size();
        int i = 0;
        while (i < j)
        {
          int k = this.kb.keyAt(i);
          Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.kb.valueAt(i);
          this.kc[k] = d(localConstantState.newDrawable(this.jY));
          i += 1;
        }
        this.kb = null;
      }
    }
    
    final void cq()
    {
      int i = 0;
      this.ki = true;
      cp();
      int j = this.kd;
      Drawable[] arrayOfDrawable = this.kc;
      this.kk = -1;
      this.kj = -1;
      this.km = 0;
      this.kl = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        int k = localDrawable.getIntrinsicWidth();
        if (k > this.kj) {
          this.kj = k;
        }
        k = localDrawable.getIntrinsicHeight();
        if (k > this.kk) {
          this.kk = k;
        }
        k = localDrawable.getMinimumWidth();
        if (k > this.kl) {
          this.kl = k;
        }
        k = localDrawable.getMinimumHeight();
        if (k > this.km) {
          this.km = k;
        }
        i += 1;
      }
    }
    
    final void e(Resources paramResources)
    {
      if (paramResources != null)
      {
        this.jY = paramResources;
        int i = b.a(paramResources, this.jZ);
        int j = this.jZ;
        this.jZ = i;
        if (j != i)
        {
          this.ki = false;
          this.kf = false;
        }
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations | this.ka;
    }
    
    public void m(int paramInt1, int paramInt2)
    {
      Drawable[] arrayOfDrawable = new Drawable[paramInt2];
      System.arraycopy(this.kc, 0, arrayOfDrawable, 0, paramInt1);
      this.kc = arrayOfDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.b.a.b
 * JD-Core Version:    0.7.0.1
 */