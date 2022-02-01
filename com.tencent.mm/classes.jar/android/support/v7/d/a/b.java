package android.support.v7.d.a;

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
import android.support.v4.graphics.drawable.a;
import android.util.DisplayMetrics;
import android.util.SparseArray;

class b
  extends Drawable
  implements Drawable.Callback
{
  b Zj;
  private Rect Zk;
  private Drawable Zl;
  private Drawable Zm;
  private boolean Zn;
  int Zo = -1;
  private int Zp = -1;
  private Runnable Zq;
  private long Zr;
  private long Zs;
  private a Zt;
  private int mAlpha = 255;
  private boolean uq;
  
  static int b(Resources paramResources, int paramInt)
  {
    if (paramResources == null) {}
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      return i;
      paramInt = paramResources.getDisplayMetrics().densityDpi;
    }
  }
  
  /* Error */
  private void m(Drawable paramDrawable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	android/support/v7/d/a/b:Zt	Landroid/support/v7/d/a/b$a;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 10	android/support/v7/d/a/b$a
    //   11: dup
    //   12: invokespecial 63	android/support/v7/d/a/b$a:<init>	()V
    //   15: putfield 62	android/support/v7/d/a/b:Zt	Landroid/support/v7/d/a/b$a;
    //   18: aload_0
    //   19: getfield 62	android/support/v7/d/a/b:Zt	Landroid/support/v7/d/a/b$a;
    //   22: astore_2
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 67	android/graphics/drawable/Drawable:getCallback	()Landroid/graphics/drawable/Drawable$Callback;
    //   28: putfield 71	android/support/v7/d/a/b$a:tZ	Landroid/graphics/drawable/Drawable$Callback;
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 75	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   36: aload_0
    //   37: getfield 77	android/support/v7/d/a/b:Zj	Landroid/support/v7/d/a/b$b;
    //   40: getfield 80	android/support/v7/d/a/b$b:ZS	I
    //   43: ifgt +18 -> 61
    //   46: aload_0
    //   47: getfield 82	android/support/v7/d/a/b:Zn	Z
    //   50: ifeq +11 -> 61
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 41	android/support/v7/d/a/b:mAlpha	I
    //   58: invokevirtual 86	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   61: aload_0
    //   62: getfield 77	android/support/v7/d/a/b:Zj	Landroid/support/v7/d/a/b$b;
    //   65: getfield 89	android/support/v7/d/a/b$b:ZU	Z
    //   68: ifeq +146 -> 214
    //   71: aload_1
    //   72: aload_0
    //   73: getfield 77	android/support/v7/d/a/b:Zj	Landroid/support/v7/d/a/b$b;
    //   76: getfield 93	android/support/v7/d/a/b$b:up	Landroid/graphics/ColorFilter;
    //   79: invokevirtual 97	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   82: aload_1
    //   83: aload_0
    //   84: invokevirtual 101	android/support/v7/d/a/b:isVisible	()Z
    //   87: iconst_1
    //   88: invokevirtual 105	android/graphics/drawable/Drawable:setVisible	(ZZ)Z
    //   91: pop
    //   92: aload_1
    //   93: aload_0
    //   94: getfield 77	android/support/v7/d/a/b:Zj	Landroid/support/v7/d/a/b$b;
    //   97: getfield 108	android/support/v7/d/a/b$b:ZR	Z
    //   100: invokevirtual 112	android/graphics/drawable/Drawable:setDither	(Z)V
    //   103: aload_1
    //   104: aload_0
    //   105: invokevirtual 116	android/support/v7/d/a/b:getState	()[I
    //   108: invokevirtual 120	android/graphics/drawable/Drawable:setState	([I)Z
    //   111: pop
    //   112: aload_1
    //   113: aload_0
    //   114: invokevirtual 124	android/support/v7/d/a/b:getLevel	()I
    //   117: invokevirtual 128	android/graphics/drawable/Drawable:setLevel	(I)Z
    //   120: pop
    //   121: aload_1
    //   122: aload_0
    //   123: invokevirtual 132	android/support/v7/d/a/b:getBounds	()Landroid/graphics/Rect;
    //   126: invokevirtual 136	android/graphics/drawable/Drawable:setBounds	(Landroid/graphics/Rect;)V
    //   129: getstatic 141	android/os/Build$VERSION:SDK_INT	I
    //   132: bipush 23
    //   134: if_icmplt +12 -> 146
    //   137: aload_1
    //   138: aload_0
    //   139: invokevirtual 144	android/support/v7/d/a/b:getLayoutDirection	()I
    //   142: invokevirtual 147	android/graphics/drawable/Drawable:setLayoutDirection	(I)Z
    //   145: pop
    //   146: getstatic 141	android/os/Build$VERSION:SDK_INT	I
    //   149: bipush 19
    //   151: if_icmplt +14 -> 165
    //   154: aload_1
    //   155: aload_0
    //   156: getfield 77	android/support/v7/d/a/b:Zj	Landroid/support/v7/d/a/b$b;
    //   159: getfield 150	android/support/v7/d/a/b$b:vp	Z
    //   162: invokevirtual 153	android/graphics/drawable/Drawable:setAutoMirrored	(Z)V
    //   165: aload_0
    //   166: getfield 155	android/support/v7/d/a/b:Zk	Landroid/graphics/Rect;
    //   169: astore_2
    //   170: getstatic 141	android/os/Build$VERSION:SDK_INT	I
    //   173: bipush 21
    //   175: if_icmplt +27 -> 202
    //   178: aload_2
    //   179: ifnull +23 -> 202
    //   182: aload_1
    //   183: aload_2
    //   184: getfield 160	android/graphics/Rect:left	I
    //   187: aload_2
    //   188: getfield 163	android/graphics/Rect:top	I
    //   191: aload_2
    //   192: getfield 166	android/graphics/Rect:right	I
    //   195: aload_2
    //   196: getfield 169	android/graphics/Rect:bottom	I
    //   199: invokevirtual 173	android/graphics/drawable/Drawable:setHotspotBounds	(IIII)V
    //   202: aload_1
    //   203: aload_0
    //   204: getfield 62	android/support/v7/d/a/b:Zt	Landroid/support/v7/d/a/b$a;
    //   207: invokevirtual 176	android/support/v7/d/a/b$a:gN	()Landroid/graphics/drawable/Drawable$Callback;
    //   210: invokevirtual 75	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   213: return
    //   214: aload_0
    //   215: getfield 77	android/support/v7/d/a/b:Zj	Landroid/support/v7/d/a/b$b;
    //   218: getfield 179	android/support/v7/d/a/b$b:ZV	Z
    //   221: ifeq +14 -> 235
    //   224: aload_1
    //   225: aload_0
    //   226: getfield 77	android/support/v7/d/a/b:Zj	Landroid/support/v7/d/a/b$b;
    //   229: getfield 183	android/support/v7/d/a/b$b:Hr	Landroid/content/res/ColorStateList;
    //   232: invokestatic 188	android/support/v4/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    //   235: aload_0
    //   236: getfield 77	android/support/v7/d/a/b:Zj	Landroid/support/v7/d/a/b$b;
    //   239: getfield 191	android/support/v7/d/a/b$b:ZW	Z
    //   242: ifeq -160 -> 82
    //   245: aload_1
    //   246: aload_0
    //   247: getfield 77	android/support/v7/d/a/b:Zj	Landroid/support/v7/d/a/b$b;
    //   250: getfield 195	android/support/v7/d/a/b$b:vo	Landroid/graphics/PorterDuff$Mode;
    //   253: invokestatic 198	android/support/v4/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    //   256: goto -174 -> 82
    //   259: astore_2
    //   260: aload_1
    //   261: aload_0
    //   262: getfield 62	android/support/v7/d/a/b:Zt	Landroid/support/v7/d/a/b$a;
    //   265: invokevirtual 176	android/support/v7/d/a/b$a:gN	()Landroid/graphics/drawable/Drawable$Callback;
    //   268: invokevirtual 75	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   271: aload_2
    //   272: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	b
    //   0	273	1	paramDrawable	Drawable
    //   22	174	2	localObject1	Object
    //   259	13	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	61	259	finally
    //   61	82	259	finally
    //   82	146	259	finally
    //   146	165	259	finally
    //   165	178	259	finally
    //   182	202	259	finally
    //   214	235	259	finally
    //   235	256	259	finally
  }
  
  final void Z(boolean paramBoolean)
  {
    this.Zn = true;
    long l = SystemClock.uptimeMillis();
    if (this.Zl != null)
    {
      if (this.Zr != 0L)
      {
        if (this.Zr > l) {
          break label132;
        }
        this.Zl.setAlpha(this.mAlpha);
      }
    }
    else {
      this.Zr = 0L;
    }
    int i = 0;
    if (this.Zm != null)
    {
      j = i;
      if (this.Zs != 0L)
      {
        if (this.Zs > l) {
          break label179;
        }
        this.Zm.setVisible(false, false);
        this.Zm = null;
        this.Zp = -1;
      }
    }
    else
    {
      this.Zs = 0L;
    }
    for (int j = i;; j = 1)
    {
      if ((paramBoolean) && (j != 0)) {
        scheduleSelf(this.Zq, 16L + l);
      }
      return;
      label132:
      i = (int)((this.Zr - l) * 255L) / this.Zj.ZS;
      this.Zl.setAlpha((255 - i) * this.mAlpha / 255);
      i = 1;
      break;
      label179:
      i = (int)((this.Zs - l) * 255L) / this.Zj.ZT;
      this.Zm.setAlpha(i * this.mAlpha / 255);
    }
  }
  
  protected void a(b paramb)
  {
    this.Zj = paramb;
    if (this.Zo >= 0)
    {
      this.Zl = paramb.getChild(this.Zo);
      if (this.Zl != null) {
        m(this.Zl);
      }
    }
    this.Zp = -1;
    this.Zm = null;
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    b localb = this.Zj;
    if (paramTheme != null)
    {
      localb.gP();
      int j = localb.ZB;
      Drawable[] arrayOfDrawable = localb.ZA;
      int i = 0;
      while (i < j)
      {
        if ((arrayOfDrawable[i] != null) && (arrayOfDrawable[i].canApplyTheme()))
        {
          arrayOfDrawable[i].applyTheme(paramTheme);
          localb.Zy |= arrayOfDrawable[i].getChangingConfigurations();
        }
        i += 1;
      }
      localb.e(paramTheme.getResources());
    }
  }
  
  public boolean canApplyTheme()
  {
    return this.Zj.canApplyTheme();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.Zl != null) {
      this.Zl.draw(paramCanvas);
    }
    if (this.Zm != null) {
      this.Zm.draw(paramCanvas);
    }
  }
  
  b gK()
  {
    return this.Zj;
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.Zj.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (this.Zj.canConstantState())
    {
      this.Zj.mChangingConfigurations = getChangingConfigurations();
      return this.Zj;
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.Zl;
  }
  
  public void getHotspotBounds(Rect paramRect)
  {
    if (this.Zk != null)
    {
      paramRect.set(this.Zk);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.Zj.ZF)
    {
      b localb = this.Zj;
      if (!localb.ZG) {
        localb.computeConstantSize();
      }
      return localb.ZI;
    }
    if (this.Zl != null) {
      return this.Zl.getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.Zj.ZF)
    {
      b localb = this.Zj;
      if (!localb.ZG) {
        localb.computeConstantSize();
      }
      return localb.ZH;
    }
    if (this.Zl != null) {
      return this.Zl.getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getMinimumHeight()
  {
    if (this.Zj.ZF)
    {
      b localb = this.Zj;
      if (!localb.ZG) {
        localb.computeConstantSize();
      }
      return localb.ZK;
    }
    if (this.Zl != null) {
      return this.Zl.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    if (this.Zj.ZF)
    {
      b localb = this.Zj;
      if (!localb.ZG) {
        localb.computeConstantSize();
      }
      return localb.ZJ;
    }
    if (this.Zl != null) {
      return this.Zl.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    int i = -2;
    if ((this.Zl == null) || (!this.Zl.isVisible())) {
      return -2;
    }
    b localb = this.Zj;
    if (localb.ZL) {
      return localb.ZM;
    }
    localb.gP();
    int k = localb.ZB;
    Drawable[] arrayOfDrawable = localb.ZA;
    if (k > 0) {
      i = arrayOfDrawable[0].getOpacity();
    }
    int j = 1;
    while (j < k)
    {
      i = Drawable.resolveOpacity(i, arrayOfDrawable[j].getOpacity());
      j += 1;
    }
    localb.ZM = i;
    localb.ZL = true;
    return i;
  }
  
  public void getOutline(Outline paramOutline)
  {
    if (this.Zl != null) {
      this.Zl.getOutline(paramOutline);
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 1;
    b localb = this.Zj;
    int k;
    boolean bool;
    if (localb.ZC)
    {
      localObject1 = localObject2;
      if (localObject1 == null) {
        break label351;
      }
      paramRect.set((Rect)localObject1);
      i = ((Rect)localObject1).left;
      k = ((Rect)localObject1).top;
      int m = ((Rect)localObject1).bottom;
      if ((((Rect)localObject1).right | i | k | m) == 0) {
        break label345;
      }
      bool = true;
      label76:
      if ((!isAutoMirrored()) || (getLayoutDirection() != 1)) {
        break label381;
      }
    }
    label345:
    label351:
    label381:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        i = paramRect.left;
        paramRect.left = paramRect.right;
        paramRect.right = i;
      }
      return bool;
      if ((localb.ZE != null) || (localb.ZD))
      {
        localObject1 = localb.ZE;
        break;
      }
      localb.gP();
      Rect localRect = new Rect();
      k = localb.ZB;
      Drawable[] arrayOfDrawable = localb.ZA;
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
      localb.ZD = true;
      localb.ZE = ((Rect)localObject1);
      break;
      bool = false;
      break label76;
      if (this.Zl != null)
      {
        bool = this.Zl.getPadding(paramRect);
        break label76;
      }
      bool = super.getPadding(paramRect);
      break label76;
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.Zj != null) {
      this.Zj.gO();
    }
    if ((paramDrawable == this.Zl) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public boolean isAutoMirrored()
  {
    return this.Zj.vp;
  }
  
  public boolean isStateful()
  {
    boolean bool2 = false;
    b localb = this.Zj;
    if (localb.ZN) {
      return localb.ZO;
    }
    localb.gP();
    int j = localb.ZB;
    Drawable[] arrayOfDrawable = localb.ZA;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfDrawable[i].isStateful()) {
          bool1 = true;
        }
      }
      else
      {
        localb.ZO = bool1;
        localb.ZN = true;
        return bool1;
      }
      i += 1;
    }
  }
  
  public void jumpToCurrentState()
  {
    int j = 1;
    int i = 0;
    if (this.Zm != null)
    {
      this.Zm.jumpToCurrentState();
      this.Zm = null;
      this.Zp = -1;
      i = 1;
    }
    if (this.Zl != null)
    {
      this.Zl.jumpToCurrentState();
      if (this.Zn) {
        this.Zl.setAlpha(this.mAlpha);
      }
    }
    if (this.Zs != 0L)
    {
      this.Zs = 0L;
      i = 1;
    }
    if (this.Zr != 0L)
    {
      this.Zr = 0L;
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        invalidateSelf();
      }
      return;
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.uq) && (super.mutate() == this))
    {
      b localb = gK();
      localb.gL();
      a(localb);
      this.uq = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.Zm != null) {
      this.Zm.setBounds(paramRect);
    }
    if (this.Zl != null) {
      this.Zl.setBounds(paramRect);
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    b localb = this.Zj;
    int j = this.Zo;
    int k = localb.ZB;
    Drawable[] arrayOfDrawable = localb.ZA;
    int i = 0;
    boolean bool1 = false;
    if (i < k)
    {
      if (arrayOfDrawable[i] == null) {
        break label86;
      }
      if (Build.VERSION.SDK_INT < 23) {
        break label93;
      }
    }
    label86:
    label93:
    for (boolean bool2 = arrayOfDrawable[i].setLayoutDirection(paramInt);; bool2 = false)
    {
      if (i == j) {}
      for (;;)
      {
        i += 1;
        bool1 = bool2;
        break;
        localb.mLayoutDirection = paramInt;
        return bool1;
        bool2 = bool1;
      }
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.Zm != null) {
      return this.Zm.setLevel(paramInt);
    }
    if (this.Zl != null) {
      return this.Zl.setLevel(paramInt);
    }
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.Zm != null) {
      return this.Zm.setState(paramArrayOfInt);
    }
    if (this.Zl != null) {
      return this.Zl.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.Zl) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  final boolean selectDrawable(int paramInt)
  {
    if (paramInt == this.Zo) {
      return false;
    }
    long l = SystemClock.uptimeMillis();
    if (this.Zj.ZT > 0)
    {
      if (this.Zm != null) {
        this.Zm.setVisible(false, false);
      }
      if (this.Zl != null)
      {
        this.Zm = this.Zl;
        this.Zp = this.Zo;
        this.Zs = (this.Zj.ZT + l);
        if ((paramInt < 0) || (paramInt >= this.Zj.ZB)) {
          break label235;
        }
        Drawable localDrawable = this.Zj.getChild(paramInt);
        this.Zl = localDrawable;
        this.Zo = paramInt;
        if (localDrawable != null)
        {
          if (this.Zj.ZS > 0) {
            this.Zr = (l + this.Zj.ZS);
          }
          m(localDrawable);
        }
        label149:
        if ((this.Zr != 0L) || (this.Zs != 0L))
        {
          if (this.Zq != null) {
            break label248;
          }
          this.Zq = new Runnable()
          {
            public final void run()
            {
              b.this.Z(true);
              b.this.invalidateSelf();
            }
          };
        }
      }
    }
    for (;;)
    {
      Z(true);
      invalidateSelf();
      return true;
      this.Zm = null;
      this.Zp = -1;
      this.Zs = 0L;
      break;
      if (this.Zl == null) {
        break;
      }
      this.Zl.setVisible(false, false);
      break;
      label235:
      this.Zl = null;
      this.Zo = -1;
      break label149;
      label248:
      unscheduleSelf(this.Zq);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if ((!this.Zn) || (this.mAlpha != paramInt))
    {
      this.Zn = true;
      this.mAlpha = paramInt;
      if (this.Zl != null)
      {
        if (this.Zr != 0L) {
          break label50;
        }
        this.Zl.setAlpha(paramInt);
      }
    }
    return;
    label50:
    Z(false);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.Zj.vp != paramBoolean)
    {
      this.Zj.vp = paramBoolean;
      if (this.Zl != null) {
        a.a(this.Zl, this.Zj.vp);
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.Zj.ZU = true;
    if (this.Zj.up != paramColorFilter)
    {
      this.Zj.up = paramColorFilter;
      if (this.Zl != null) {
        this.Zl.setColorFilter(paramColorFilter);
      }
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (this.Zj.ZR != paramBoolean)
    {
      this.Zj.ZR = paramBoolean;
      if (this.Zl != null) {
        this.Zl.setDither(this.Zj.ZR);
      }
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.Zl != null) {
      a.a(this.Zl, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.Zk == null) {
      this.Zk = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      if (this.Zl != null) {
        a.a(this.Zl, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      return;
      this.Zk.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.Zj.ZV = true;
    if (this.Zj.Hr != paramColorStateList)
    {
      this.Zj.Hr = paramColorStateList;
      a.a(this.Zl, paramColorStateList);
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.Zj.ZW = true;
    if (this.Zj.vo != paramMode)
    {
      this.Zj.vo = paramMode;
      a.a(this.Zl, paramMode);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.Zm != null) {
      this.Zm.setVisible(paramBoolean1, paramBoolean2);
    }
    if (this.Zl != null) {
      this.Zl.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if ((paramDrawable == this.Zl) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
  
  static final class a
    implements Drawable.Callback
  {
    Drawable.Callback tZ;
    
    public final Drawable.Callback gN()
    {
      Drawable.Callback localCallback = this.tZ;
      this.tZ = null;
      return localCallback;
    }
    
    public final void invalidateDrawable(Drawable paramDrawable) {}
    
    public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      if (this.tZ != null) {
        this.tZ.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
    }
    
    public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      if (this.tZ != null) {
        this.tZ.unscheduleDrawable(paramDrawable, paramRunnable);
      }
    }
  }
  
  static abstract class b
    extends Drawable.ConstantState
  {
    ColorStateList Hr;
    Drawable[] ZA;
    int ZB;
    boolean ZC = false;
    boolean ZD;
    Rect ZE;
    boolean ZF = false;
    boolean ZG;
    int ZH;
    int ZI;
    int ZJ;
    int ZK;
    boolean ZL;
    int ZM;
    boolean ZN;
    boolean ZO;
    boolean ZP;
    boolean ZQ;
    boolean ZR = true;
    int ZS = 0;
    int ZT = 0;
    boolean ZU;
    boolean ZV;
    boolean ZW;
    final b Zv;
    Resources Zw;
    int Zx = 160;
    int Zy;
    SparseArray<Drawable.ConstantState> Zz;
    int mChangingConfigurations;
    int mLayoutDirection;
    ColorFilter up;
    boolean uq;
    PorterDuff.Mode vo;
    boolean vp;
    
    b(b paramb, b paramb1, Resources paramResources)
    {
      this.Zv = paramb1;
      int i;
      if (paramResources != null)
      {
        paramb1 = paramResources;
        this.Zw = paramb1;
        if (paramb == null) {
          break label450;
        }
        i = paramb.Zx;
        label65:
        this.Zx = b.b(paramResources, i);
        if (paramb == null) {
          break label488;
        }
        this.mChangingConfigurations = paramb.mChangingConfigurations;
        this.Zy = paramb.Zy;
        this.ZP = true;
        this.ZQ = true;
        this.ZC = paramb.ZC;
        this.ZF = paramb.ZF;
        this.ZR = paramb.ZR;
        this.uq = paramb.uq;
        this.mLayoutDirection = paramb.mLayoutDirection;
        this.ZS = paramb.ZS;
        this.ZT = paramb.ZT;
        this.vp = paramb.vp;
        this.up = paramb.up;
        this.ZU = paramb.ZU;
        this.Hr = paramb.Hr;
        this.vo = paramb.vo;
        this.ZV = paramb.ZV;
        this.ZW = paramb.ZW;
        if (paramb.Zx == this.Zx)
        {
          if (paramb.ZD)
          {
            this.ZE = new Rect(paramb.ZE);
            this.ZD = true;
          }
          if (paramb.ZG)
          {
            this.ZH = paramb.ZH;
            this.ZI = paramb.ZI;
            this.ZJ = paramb.ZJ;
            this.ZK = paramb.ZK;
            this.ZG = true;
          }
        }
        if (paramb.ZL)
        {
          this.ZM = paramb.ZM;
          this.ZL = true;
        }
        if (paramb.ZN)
        {
          this.ZO = paramb.ZO;
          this.ZN = true;
        }
        paramb1 = paramb.ZA;
        this.ZA = new Drawable[paramb1.length];
        this.ZB = paramb.ZB;
        paramb = paramb.Zz;
        if (paramb == null) {
          break label456;
        }
        this.Zz = paramb.clone();
        label378:
        int k = this.ZB;
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
          this.Zz.put(i, paramb);
        }
      }
      for (;;)
      {
        i += 1;
        break label388;
        if (paramb != null)
        {
          paramb1 = paramb.Zw;
          break;
        }
        paramb1 = null;
        break;
        label450:
        i = 0;
        break label65;
        label456:
        this.Zz = new SparseArray(this.ZB);
        break label378;
        label474:
        this.ZA[i] = paramb1[i];
      }
      label488:
      this.ZA = new Drawable[10];
      this.ZB = 0;
    }
    
    private Drawable n(Drawable paramDrawable)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(this.mLayoutDirection);
      }
      paramDrawable = paramDrawable.mutate();
      paramDrawable.setCallback(this.Zv);
      return paramDrawable;
    }
    
    public final int addChild(Drawable paramDrawable)
    {
      int i = this.ZB;
      if (i >= this.ZA.length) {
        growArray(i, i + 10);
      }
      paramDrawable.mutate();
      paramDrawable.setVisible(false, true);
      paramDrawable.setCallback(this.Zv);
      this.ZA[i] = paramDrawable;
      this.ZB += 1;
      this.Zy |= paramDrawable.getChangingConfigurations();
      gO();
      this.ZE = null;
      this.ZD = false;
      this.ZG = false;
      this.ZP = false;
      return i;
    }
    
    public boolean canApplyTheme()
    {
      int j = this.ZB;
      Drawable[] arrayOfDrawable = this.ZA;
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
          localObject = (Drawable.ConstantState)this.Zz.get(i);
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
          if (this.ZP)
          {
            bool = this.ZQ;
            return bool;
          }
          gP();
          this.ZP = true;
          int j = this.ZB;
          Drawable[] arrayOfDrawable = this.ZA;
          int i = 0;
          if (i >= j) {
            break label79;
          }
          if (arrayOfDrawable[i].getConstantState() == null)
          {
            this.ZQ = false;
            continue;
          }
          i += 1;
        }
        finally {}
        continue;
        label79:
        this.ZQ = true;
        bool = true;
      }
    }
    
    final void computeConstantSize()
    {
      int i = 0;
      this.ZG = true;
      gP();
      int j = this.ZB;
      Drawable[] arrayOfDrawable = this.ZA;
      this.ZI = -1;
      this.ZH = -1;
      this.ZK = 0;
      this.ZJ = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        int k = localDrawable.getIntrinsicWidth();
        if (k > this.ZH) {
          this.ZH = k;
        }
        k = localDrawable.getIntrinsicHeight();
        if (k > this.ZI) {
          this.ZI = k;
        }
        k = localDrawable.getMinimumWidth();
        if (k > this.ZJ) {
          this.ZJ = k;
        }
        k = localDrawable.getMinimumHeight();
        if (k > this.ZK) {
          this.ZK = k;
        }
        i += 1;
      }
    }
    
    final void e(Resources paramResources)
    {
      if (paramResources != null)
      {
        this.Zw = paramResources;
        int i = b.b(paramResources, this.Zx);
        int j = this.Zx;
        this.Zx = i;
        if (j != i)
        {
          this.ZG = false;
          this.ZD = false;
        }
      }
    }
    
    void gL()
    {
      int j = this.ZB;
      Drawable[] arrayOfDrawable = this.ZA;
      int i = 0;
      while (i < j)
      {
        if (arrayOfDrawable[i] != null) {
          arrayOfDrawable[i].mutate();
        }
        i += 1;
      }
      this.uq = true;
    }
    
    final void gO()
    {
      this.ZL = false;
      this.ZN = false;
    }
    
    final void gP()
    {
      if (this.Zz != null)
      {
        int j = this.Zz.size();
        int i = 0;
        while (i < j)
        {
          int k = this.Zz.keyAt(i);
          Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.Zz.valueAt(i);
          this.ZA[k] = n(localConstantState.newDrawable(this.Zw));
          i += 1;
        }
        this.Zz = null;
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations | this.Zy;
    }
    
    public final Drawable getChild(int paramInt)
    {
      Object localObject = this.ZA[paramInt];
      if (localObject != null) {}
      Drawable localDrawable;
      do
      {
        return localObject;
        if (this.Zz == null) {
          break;
        }
        int i = this.Zz.indexOfKey(paramInt);
        if (i < 0) {
          break;
        }
        localDrawable = n(((Drawable.ConstantState)this.Zz.valueAt(i)).newDrawable(this.Zw));
        this.ZA[paramInt] = localDrawable;
        this.Zz.removeAt(i);
        localObject = localDrawable;
      } while (this.Zz.size() != 0);
      this.Zz = null;
      return localDrawable;
      return null;
    }
    
    public void growArray(int paramInt1, int paramInt2)
    {
      Drawable[] arrayOfDrawable = new Drawable[paramInt2];
      System.arraycopy(this.ZA, 0, arrayOfDrawable, 0, paramInt1);
      this.ZA = arrayOfDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.d.a.b
 * JD-Core Version:    0.7.0.1
 */