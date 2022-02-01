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
  private boolean iF;
  private b iP;
  private Rect iQ;
  private Drawable iR;
  private Drawable iS;
  private boolean iT;
  private int iU = -1;
  private int iV = -1;
  private Runnable iW;
  private long iX;
  private long iY;
  private a iZ;
  private int mAlpha = 255;
  
  static int a(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(238806);
    if (paramResources == null) {}
    while (paramInt == 0)
    {
      AppMethodBeat.o(238806);
      return 160;
      paramInt = paramResources.getDisplayMetrics().densityDpi;
    }
    AppMethodBeat.o(238806);
    return paramInt;
  }
  
  /* Error */
  private void a(Drawable paramDrawable)
  {
    // Byte code:
    //   0: ldc 70
    //   2: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 72	androidx/appcompat/b/a/b:iZ	Landroidx/appcompat/b/a/b$a;
    //   9: ifnonnull +14 -> 23
    //   12: aload_0
    //   13: new 10	androidx/appcompat/b/a/b$a
    //   16: dup
    //   17: invokespecial 73	androidx/appcompat/b/a/b$a:<init>	()V
    //   20: putfield 72	androidx/appcompat/b/a/b:iZ	Landroidx/appcompat/b/a/b$a;
    //   23: aload_0
    //   24: getfield 72	androidx/appcompat/b/a/b:iZ	Landroidx/appcompat/b/a/b$a;
    //   27: astore_2
    //   28: aload_2
    //   29: aload_1
    //   30: invokevirtual 77	android/graphics/drawable/Drawable:getCallback	()Landroid/graphics/drawable/Drawable$Callback;
    //   33: putfield 81	androidx/appcompat/b/a/b$a:jb	Landroid/graphics/drawable/Drawable$Callback;
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 85	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   41: aload_0
    //   42: getfield 87	androidx/appcompat/b/a/b:iP	Landroidx/appcompat/b/a/b$b;
    //   45: getfield 90	androidx/appcompat/b/a/b$b:jz	I
    //   48: ifgt +18 -> 66
    //   51: aload_0
    //   52: getfield 92	androidx/appcompat/b/a/b:iT	Z
    //   55: ifeq +11 -> 66
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 41	androidx/appcompat/b/a/b:mAlpha	I
    //   63: invokevirtual 95	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   66: aload_0
    //   67: getfield 87	androidx/appcompat/b/a/b:iP	Landroidx/appcompat/b/a/b$b;
    //   70: getfield 98	androidx/appcompat/b/a/b$b:jD	Z
    //   73: ifeq +151 -> 224
    //   76: aload_1
    //   77: aload_0
    //   78: getfield 87	androidx/appcompat/b/a/b:iP	Landroidx/appcompat/b/a/b$b;
    //   81: getfield 102	androidx/appcompat/b/a/b$b:jC	Landroid/graphics/ColorFilter;
    //   84: invokevirtual 106	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   87: aload_1
    //   88: aload_0
    //   89: invokevirtual 110	androidx/appcompat/b/a/b:isVisible	()Z
    //   92: iconst_1
    //   93: invokevirtual 114	android/graphics/drawable/Drawable:setVisible	(ZZ)Z
    //   96: pop
    //   97: aload_1
    //   98: aload_0
    //   99: getfield 87	androidx/appcompat/b/a/b:iP	Landroidx/appcompat/b/a/b$b;
    //   102: getfield 117	androidx/appcompat/b/a/b$b:jy	Z
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
    //   161: getfield 87	androidx/appcompat/b/a/b:iP	Landroidx/appcompat/b/a/b$b;
    //   164: getfield 159	androidx/appcompat/b/a/b$b:jB	Z
    //   167: invokevirtual 162	android/graphics/drawable/Drawable:setAutoMirrored	(Z)V
    //   170: aload_0
    //   171: getfield 164	androidx/appcompat/b/a/b:iQ	Landroid/graphics/Rect;
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
    //   209: getfield 72	androidx/appcompat/b/a/b:iZ	Landroidx/appcompat/b/a/b$a;
    //   212: invokevirtual 185	androidx/appcompat/b/a/b$a:bu	()Landroid/graphics/drawable/Drawable$Callback;
    //   215: invokevirtual 85	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   218: ldc 70
    //   220: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: return
    //   224: aload_0
    //   225: getfield 87	androidx/appcompat/b/a/b:iP	Landroidx/appcompat/b/a/b$b;
    //   228: getfield 188	androidx/appcompat/b/a/b$b:jG	Z
    //   231: ifeq +14 -> 245
    //   234: aload_1
    //   235: aload_0
    //   236: getfield 87	androidx/appcompat/b/a/b:iP	Landroidx/appcompat/b/a/b$b;
    //   239: getfield 192	androidx/appcompat/b/a/b$b:jE	Landroid/content/res/ColorStateList;
    //   242: invokestatic 197	androidx/core/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    //   245: aload_0
    //   246: getfield 87	androidx/appcompat/b/a/b:iP	Landroidx/appcompat/b/a/b$b;
    //   249: getfield 200	androidx/appcompat/b/a/b$b:jH	Z
    //   252: ifeq -165 -> 87
    //   255: aload_1
    //   256: aload_0
    //   257: getfield 87	androidx/appcompat/b/a/b:iP	Landroidx/appcompat/b/a/b$b;
    //   260: getfield 204	androidx/appcompat/b/a/b$b:jF	Landroid/graphics/PorterDuff$Mode;
    //   263: invokestatic 207	androidx/core/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    //   266: goto -179 -> 87
    //   269: astore_2
    //   270: aload_1
    //   271: aload_0
    //   272: getfield 72	androidx/appcompat/b/a/b:iZ	Landroidx/appcompat/b/a/b$a;
    //   275: invokevirtual 185	androidx/appcompat/b/a/b$a:bu	()Landroid/graphics/drawable/Drawable$Callback;
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
  
  final void E(boolean paramBoolean)
  {
    AppMethodBeat.i(238798);
    this.iT = true;
    long l = SystemClock.uptimeMillis();
    if (this.iR != null)
    {
      if (this.iX != 0L)
      {
        if (this.iX > l) {
          break label142;
        }
        this.iR.setAlpha(this.mAlpha);
      }
    }
    else {
      this.iX = 0L;
    }
    int i = 0;
    if (this.iS != null)
    {
      j = i;
      if (this.iY != 0L)
      {
        if (this.iY > l) {
          break label189;
        }
        this.iS.setVisible(false, false);
        this.iS = null;
        this.iV = -1;
      }
    }
    else
    {
      this.iY = 0L;
    }
    for (int j = i;; j = 1)
    {
      if ((paramBoolean) && (j != 0)) {
        scheduleSelf(this.iW, 16L + l);
      }
      AppMethodBeat.o(238798);
      return;
      label142:
      i = (int)((this.iX - l) * 255L) / this.iP.jz;
      this.iR.setAlpha((255 - i) * this.mAlpha / 255);
      i = 1;
      break;
      label189:
      i = (int)((this.iY - l) * 255L) / this.iP.jA;
      this.iS.setAlpha(i * this.mAlpha / 255);
    }
  }
  
  final boolean Z(int paramInt)
  {
    AppMethodBeat.i(238793);
    if (paramInt == this.iU)
    {
      AppMethodBeat.o(238793);
      return false;
    }
    long l = SystemClock.uptimeMillis();
    if (this.iP.jA > 0)
    {
      if (this.iS != null) {
        this.iS.setVisible(false, false);
      }
      if (this.iR != null)
      {
        this.iS = this.iR;
        this.iV = this.iU;
        this.iY = (this.iP.jA + l);
        if ((paramInt < 0) || (paramInt >= this.iP.ji)) {
          break label250;
        }
        Drawable localDrawable = this.iP.aa(paramInt);
        this.iR = localDrawable;
        this.iU = paramInt;
        if (localDrawable != null)
        {
          if (this.iP.jz > 0) {
            this.iX = (l + this.iP.jz);
          }
          a(localDrawable);
        }
        label159:
        if ((this.iX != 0L) || (this.iY != 0L))
        {
          if (this.iW != null) {
            break label263;
          }
          this.iW = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(238726);
              b.this.E(true);
              b.this.invalidateSelf();
              AppMethodBeat.o(238726);
            }
          };
        }
      }
    }
    for (;;)
    {
      E(true);
      invalidateSelf();
      AppMethodBeat.o(238793);
      return true;
      this.iS = null;
      this.iV = -1;
      this.iY = 0L;
      break;
      if (this.iR == null) {
        break;
      }
      this.iR.setVisible(false, false);
      break;
      label250:
      this.iR = null;
      this.iU = -1;
      break label159;
      label263:
      unscheduleSelf(this.iW);
    }
  }
  
  protected void a(b paramb)
  {
    AppMethodBeat.i(238805);
    this.iP = paramb;
    if (this.iU >= 0)
    {
      this.iR = paramb.aa(this.iU);
      if (this.iR != null) {
        a(this.iR);
      }
    }
    this.iV = -1;
    this.iS = null;
    AppMethodBeat.o(238805);
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    AppMethodBeat.i(238801);
    b localb = this.iP;
    if (paramTheme != null)
    {
      localb.bw();
      int j = localb.ji;
      Drawable[] arrayOfDrawable = localb.jh;
      int i = 0;
      while (i < j)
      {
        if ((arrayOfDrawable[i] != null) && (arrayOfDrawable[i].canApplyTheme()))
        {
          arrayOfDrawable[i].applyTheme(paramTheme);
          localb.jf |= arrayOfDrawable[i].getChangingConfigurations();
        }
        i += 1;
      }
      localb.e(paramTheme.getResources());
    }
    AppMethodBeat.o(238801);
  }
  
  b bq()
  {
    return this.iP;
  }
  
  public boolean canApplyTheme()
  {
    AppMethodBeat.i(238802);
    boolean bool = this.iP.canApplyTheme();
    AppMethodBeat.o(238802);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(238742);
    if (this.iR != null) {
      this.iR.draw(paramCanvas);
    }
    if (this.iS != null) {
      this.iS.draw(paramCanvas);
    }
    AppMethodBeat.o(238742);
  }
  
  final void e(Resources paramResources)
  {
    AppMethodBeat.i(238800);
    this.iP.e(paramResources);
    AppMethodBeat.o(238800);
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public int getChangingConfigurations()
  {
    AppMethodBeat.i(238743);
    int i = super.getChangingConfigurations();
    int j = this.iP.getChangingConfigurations();
    AppMethodBeat.o(238743);
    return i | j;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    AppMethodBeat.i(238803);
    if (this.iP.canConstantState())
    {
      this.iP.mChangingConfigurations = getChangingConfigurations();
      b localb = this.iP;
      AppMethodBeat.o(238803);
      return localb;
    }
    AppMethodBeat.o(238803);
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.iR;
  }
  
  final int getCurrentIndex()
  {
    return this.iU;
  }
  
  public void getHotspotBounds(Rect paramRect)
  {
    AppMethodBeat.i(238764);
    if (this.iQ != null)
    {
      paramRect.set(this.iQ);
      AppMethodBeat.o(238764);
      return;
    }
    super.getHotspotBounds(paramRect);
    AppMethodBeat.o(238764);
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(238770);
    int i;
    if (this.iP.jm)
    {
      b localb = this.iP;
      if (!localb.jn) {
        localb.bx();
      }
      i = localb.jp;
      AppMethodBeat.o(238770);
      return i;
    }
    if (this.iR != null)
    {
      i = this.iR.getIntrinsicHeight();
      AppMethodBeat.o(238770);
      return i;
    }
    AppMethodBeat.o(238770);
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(238769);
    int i;
    if (this.iP.jm)
    {
      b localb = this.iP;
      if (!localb.jn) {
        localb.bx();
      }
      i = localb.jo;
      AppMethodBeat.o(238769);
      return i;
    }
    if (this.iR != null)
    {
      i = this.iR.getIntrinsicWidth();
      AppMethodBeat.o(238769);
      return i;
    }
    AppMethodBeat.o(238769);
    return -1;
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(238773);
    int i;
    if (this.iP.jm)
    {
      b localb = this.iP;
      if (!localb.jn) {
        localb.bx();
      }
      i = localb.jr;
      AppMethodBeat.o(238773);
      return i;
    }
    if (this.iR != null)
    {
      i = this.iR.getMinimumHeight();
      AppMethodBeat.o(238773);
      return i;
    }
    AppMethodBeat.o(238773);
    return 0;
  }
  
  public int getMinimumWidth()
  {
    AppMethodBeat.i(238772);
    int i;
    if (this.iP.jm)
    {
      b localb = this.iP;
      if (!localb.jn) {
        localb.bx();
      }
      i = localb.jq;
      AppMethodBeat.o(238772);
      return i;
    }
    if (this.iR != null)
    {
      i = this.iR.getMinimumWidth();
      AppMethodBeat.o(238772);
      return i;
    }
    AppMethodBeat.o(238772);
    return 0;
  }
  
  public int getOpacity()
  {
    int i = -2;
    AppMethodBeat.i(238789);
    if ((this.iR == null) || (!this.iR.isVisible()))
    {
      AppMethodBeat.o(238789);
      return -2;
    }
    b localb = this.iP;
    if (localb.js)
    {
      i = localb.jt;
      AppMethodBeat.o(238789);
      return i;
    }
    localb.bw();
    int k = localb.ji;
    Drawable[] arrayOfDrawable = localb.jh;
    if (k > 0) {
      i = arrayOfDrawable[0].getOpacity();
    }
    int j = 1;
    while (j < k)
    {
      i = Drawable.resolveOpacity(i, arrayOfDrawable[j].getOpacity());
      j += 1;
    }
    localb.jt = i;
    localb.js = true;
    AppMethodBeat.o(238789);
    return i;
  }
  
  public void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(238746);
    if (this.iR != null) {
      this.iR.getOutline(paramOutline);
    }
    AppMethodBeat.o(238746);
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 1;
    AppMethodBeat.i(238744);
    b localb = this.iP;
    int k;
    boolean bool;
    if (localb.jj)
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
      AppMethodBeat.o(238744);
      return bool;
      if ((localb.jl != null) || (localb.jk))
      {
        localObject1 = localb.jl;
        break;
      }
      localb.bw();
      Rect localRect = new Rect();
      k = localb.ji;
      Drawable[] arrayOfDrawable = localb.jh;
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
      localb.jk = true;
      localb.jl = ((Rect)localObject1);
      break;
      label357:
      bool = false;
      break label82;
      label363:
      if (this.iR != null)
      {
        bool = this.iR.getPadding(paramRect);
        break label82;
      }
      bool = super.getPadding(paramRect);
      break label82;
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(238777);
    if (this.iP != null) {
      this.iP.bv();
    }
    if ((paramDrawable == this.iR) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
    AppMethodBeat.o(238777);
  }
  
  public boolean isAutoMirrored()
  {
    return this.iP.jB;
  }
  
  public boolean isStateful()
  {
    boolean bool2 = false;
    AppMethodBeat.i(238757);
    b localb = this.iP;
    boolean bool1;
    if (localb.ju)
    {
      bool1 = localb.jv;
      AppMethodBeat.o(238757);
      return bool1;
    }
    localb.bw();
    int j = localb.ji;
    Drawable[] arrayOfDrawable = localb.jh;
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
        localb.jv = bool1;
        localb.ju = true;
        AppMethodBeat.o(238757);
        return bool1;
      }
      i += 1;
    }
  }
  
  public void jumpToCurrentState()
  {
    int j = 1;
    AppMethodBeat.i(238761);
    int i = 0;
    if (this.iS != null)
    {
      this.iS.jumpToCurrentState();
      this.iS = null;
      this.iV = -1;
      i = 1;
    }
    if (this.iR != null)
    {
      this.iR.jumpToCurrentState();
      if (this.iT) {
        this.iR.setAlpha(this.mAlpha);
      }
    }
    if (this.iY != 0L)
    {
      this.iY = 0L;
      i = 1;
    }
    if (this.iX != 0L)
    {
      this.iX = 0L;
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        invalidateSelf();
      }
      AppMethodBeat.o(238761);
      return;
    }
  }
  
  public Drawable mutate()
  {
    AppMethodBeat.i(238804);
    if ((!this.iF) && (super.mutate() == this))
    {
      b localb = bq();
      localb.br();
      a(localb);
      this.iF = true;
    }
    AppMethodBeat.o(238804);
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(238756);
    if (this.iS != null) {
      this.iS.setBounds(paramRect);
    }
    if (this.iR != null) {
      this.iR.setBounds(paramRect);
    }
    AppMethodBeat.o(238756);
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    AppMethodBeat.i(238767);
    b localb = this.iP;
    int j = this.iU;
    int k = localb.ji;
    Drawable[] arrayOfDrawable = localb.jh;
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
        AppMethodBeat.o(238767);
        return bool1;
        bool2 = bool1;
      }
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    AppMethodBeat.i(238766);
    boolean bool;
    if (this.iS != null)
    {
      bool = this.iS.setLevel(paramInt);
      AppMethodBeat.o(238766);
      return bool;
    }
    if (this.iR != null)
    {
      bool = this.iR.setLevel(paramInt);
      AppMethodBeat.o(238766);
      return bool;
    }
    AppMethodBeat.o(238766);
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(238765);
    boolean bool;
    if (this.iS != null)
    {
      bool = this.iS.setState(paramArrayOfInt);
      AppMethodBeat.o(238765);
      return bool;
    }
    if (this.iR != null)
    {
      bool = this.iR.setState(paramArrayOfInt);
      AppMethodBeat.o(238765);
      return bool;
    }
    AppMethodBeat.o(238765);
    return false;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(238780);
    if ((paramDrawable == this.iR) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
    AppMethodBeat.o(238780);
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(238748);
    if ((!this.iT) || (this.mAlpha != paramInt))
    {
      this.iT = true;
      this.mAlpha = paramInt;
      if (this.iR != null)
      {
        if (this.iX == 0L)
        {
          this.iR.setAlpha(paramInt);
          AppMethodBeat.o(238748);
          return;
        }
        E(false);
      }
    }
    AppMethodBeat.o(238748);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    AppMethodBeat.i(238758);
    if (this.iP.jB != paramBoolean)
    {
      this.iP.jB = paramBoolean;
      if (this.iR != null) {
        a.b(this.iR, this.iP.jB);
      }
    }
    AppMethodBeat.o(238758);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(238751);
    this.iP.jD = true;
    if (this.iP.jC != paramColorFilter)
    {
      this.iP.jC = paramColorFilter;
      if (this.iR != null) {
        this.iR.setColorFilter(paramColorFilter);
      }
    }
    AppMethodBeat.o(238751);
  }
  
  public void setDither(boolean paramBoolean)
  {
    AppMethodBeat.i(238750);
    if (this.iP.jy != paramBoolean)
    {
      this.iP.jy = paramBoolean;
      if (this.iR != null) {
        this.iR.setDither(this.iP.jy);
      }
    }
    AppMethodBeat.o(238750);
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(238762);
    if (this.iR != null) {
      a.a(this.iR, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(238762);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(238763);
    if (this.iQ == null) {
      this.iQ = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      if (this.iR != null) {
        a.a(this.iR, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(238763);
      return;
      this.iQ.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(238753);
    this.iP.jG = true;
    if (this.iP.jE != paramColorStateList)
    {
      this.iP.jE = paramColorStateList;
      a.a(this.iR, paramColorStateList);
    }
    AppMethodBeat.o(238753);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(238755);
    this.iP.jH = true;
    if (this.iP.jF != paramMode)
    {
      this.iP.jF = paramMode;
      a.a(this.iR, paramMode);
    }
    AppMethodBeat.o(238755);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(238786);
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.iS != null) {
      this.iS.setVisible(paramBoolean1, paramBoolean2);
    }
    if (this.iR != null) {
      this.iR.setVisible(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(238786);
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    AppMethodBeat.i(238785);
    if ((paramDrawable == this.iR) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
    AppMethodBeat.o(238785);
  }
  
  static final class a
    implements Drawable.Callback
  {
    Drawable.Callback jb;
    
    public final Drawable.Callback bu()
    {
      Drawable.Callback localCallback = this.jb;
      this.jb = null;
      return localCallback;
    }
    
    public final void invalidateDrawable(Drawable paramDrawable) {}
    
    public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(238727);
      if (this.jb != null) {
        this.jb.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
      AppMethodBeat.o(238727);
    }
    
    public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      AppMethodBeat.i(238728);
      if (this.jb != null) {
        this.jb.unscheduleDrawable(paramDrawable, paramRunnable);
      }
      AppMethodBeat.o(238728);
    }
  }
  
  static abstract class b
    extends Drawable.ConstantState
  {
    boolean iF;
    int jA = 0;
    boolean jB;
    ColorFilter jC;
    boolean jD;
    ColorStateList jE;
    PorterDuff.Mode jF;
    boolean jG;
    boolean jH;
    final b jc;
    Resources jd;
    int je = 160;
    int jf;
    SparseArray<Drawable.ConstantState> jg;
    Drawable[] jh;
    int ji;
    boolean jj = false;
    boolean jk;
    Rect jl;
    boolean jm = false;
    boolean jn;
    int jo;
    int jp;
    int jq;
    int jr;
    boolean js;
    int jt;
    boolean ju;
    boolean jv;
    boolean jw;
    boolean jx;
    boolean jy = true;
    int jz = 0;
    int mChangingConfigurations;
    int mLayoutDirection;
    
    b(b paramb, b paramb1, Resources paramResources)
    {
      this.jc = paramb1;
      int i;
      if (paramResources != null)
      {
        paramb1 = paramResources;
        this.jd = paramb1;
        if (paramb == null) {
          break label450;
        }
        i = paramb.je;
        label65:
        this.je = b.a(paramResources, i);
        if (paramb == null) {
          break label488;
        }
        this.mChangingConfigurations = paramb.mChangingConfigurations;
        this.jf = paramb.jf;
        this.jw = true;
        this.jx = true;
        this.jj = paramb.jj;
        this.jm = paramb.jm;
        this.jy = paramb.jy;
        this.iF = paramb.iF;
        this.mLayoutDirection = paramb.mLayoutDirection;
        this.jz = paramb.jz;
        this.jA = paramb.jA;
        this.jB = paramb.jB;
        this.jC = paramb.jC;
        this.jD = paramb.jD;
        this.jE = paramb.jE;
        this.jF = paramb.jF;
        this.jG = paramb.jG;
        this.jH = paramb.jH;
        if (paramb.je == this.je)
        {
          if (paramb.jk)
          {
            this.jl = new Rect(paramb.jl);
            this.jk = true;
          }
          if (paramb.jn)
          {
            this.jo = paramb.jo;
            this.jp = paramb.jp;
            this.jq = paramb.jq;
            this.jr = paramb.jr;
            this.jn = true;
          }
        }
        if (paramb.js)
        {
          this.jt = paramb.jt;
          this.js = true;
        }
        if (paramb.ju)
        {
          this.jv = paramb.jv;
          this.ju = true;
        }
        paramb1 = paramb.jh;
        this.jh = new Drawable[paramb1.length];
        this.ji = paramb.ji;
        paramb = paramb.jg;
        if (paramb == null) {
          break label456;
        }
        this.jg = paramb.clone();
        label378:
        int k = this.ji;
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
          this.jg.put(i, paramb);
        }
      }
      for (;;)
      {
        i += 1;
        break label388;
        if (paramb != null)
        {
          paramb1 = paramb.jd;
          break;
        }
        paramb1 = null;
        break;
        label450:
        i = 0;
        break label65;
        label456:
        this.jg = new SparseArray(this.ji);
        break label378;
        label474:
        this.jh[i] = paramb1[i];
      }
      label488:
      this.jh = new Drawable[10];
      this.ji = 0;
    }
    
    private Drawable c(Drawable paramDrawable)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(this.mLayoutDirection);
      }
      paramDrawable = paramDrawable.mutate();
      paramDrawable.setCallback(this.jc);
      return paramDrawable;
    }
    
    public final Drawable aa(int paramInt)
    {
      Object localObject = this.jh[paramInt];
      if (localObject != null) {}
      Drawable localDrawable;
      do
      {
        return localObject;
        if (this.jg == null) {
          break;
        }
        int i = this.jg.indexOfKey(paramInt);
        if (i < 0) {
          break;
        }
        localDrawable = c(((Drawable.ConstantState)this.jg.valueAt(i)).newDrawable(this.jd));
        this.jh[paramInt] = localDrawable;
        this.jg.removeAt(i);
        localObject = localDrawable;
      } while (this.jg.size() != 0);
      this.jg = null;
      return localDrawable;
      return null;
    }
    
    public final int b(Drawable paramDrawable)
    {
      int i = this.ji;
      if (i >= this.jh.length) {
        h(i, i + 10);
      }
      paramDrawable.mutate();
      paramDrawable.setVisible(false, true);
      paramDrawable.setCallback(this.jc);
      this.jh[i] = paramDrawable;
      this.ji += 1;
      this.jf |= paramDrawable.getChangingConfigurations();
      bv();
      this.jl = null;
      this.jk = false;
      this.jn = false;
      this.jw = false;
      return i;
    }
    
    void br()
    {
      int j = this.ji;
      Drawable[] arrayOfDrawable = this.jh;
      int i = 0;
      while (i < j)
      {
        if (arrayOfDrawable[i] != null) {
          arrayOfDrawable[i].mutate();
        }
        i += 1;
      }
      this.iF = true;
    }
    
    final void bv()
    {
      this.js = false;
      this.ju = false;
    }
    
    final void bw()
    {
      if (this.jg != null)
      {
        int j = this.jg.size();
        int i = 0;
        while (i < j)
        {
          int k = this.jg.keyAt(i);
          Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.jg.valueAt(i);
          this.jh[k] = c(localConstantState.newDrawable(this.jd));
          i += 1;
        }
        this.jg = null;
      }
    }
    
    final void bx()
    {
      int i = 0;
      this.jn = true;
      bw();
      int j = this.ji;
      Drawable[] arrayOfDrawable = this.jh;
      this.jp = -1;
      this.jo = -1;
      this.jr = 0;
      this.jq = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        int k = localDrawable.getIntrinsicWidth();
        if (k > this.jo) {
          this.jo = k;
        }
        k = localDrawable.getIntrinsicHeight();
        if (k > this.jp) {
          this.jp = k;
        }
        k = localDrawable.getMinimumWidth();
        if (k > this.jq) {
          this.jq = k;
        }
        k = localDrawable.getMinimumHeight();
        if (k > this.jr) {
          this.jr = k;
        }
        i += 1;
      }
    }
    
    public boolean canApplyTheme()
    {
      int j = this.ji;
      Drawable[] arrayOfDrawable = this.jh;
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
          localObject = (Drawable.ConstantState)this.jg.get(i);
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
          if (this.jw)
          {
            bool = this.jx;
            return bool;
          }
          bw();
          this.jw = true;
          int j = this.ji;
          Drawable[] arrayOfDrawable = this.jh;
          int i = 0;
          if (i >= j) {
            break label79;
          }
          if (arrayOfDrawable[i].getConstantState() == null)
          {
            this.jx = false;
            continue;
          }
          i += 1;
        }
        finally {}
        continue;
        label79:
        this.jx = true;
        bool = true;
      }
    }
    
    final void e(Resources paramResources)
    {
      if (paramResources != null)
      {
        this.jd = paramResources;
        int i = b.a(paramResources, this.je);
        int j = this.je;
        this.je = i;
        if (j != i)
        {
          this.jn = false;
          this.jk = false;
        }
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations | this.jf;
    }
    
    public void h(int paramInt1, int paramInt2)
    {
      Drawable[] arrayOfDrawable = new Drawable[paramInt2];
      System.arraycopy(this.jh, 0, arrayOfDrawable, 0, paramInt1);
      this.jh = arrayOfDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.b.a.b
 * JD-Core Version:    0.7.0.1
 */