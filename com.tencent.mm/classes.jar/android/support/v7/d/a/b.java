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
  b abU;
  private Rect abV;
  private Drawable abW;
  private Drawable abX;
  private boolean abY;
  int abZ = -1;
  private int aca = -1;
  private Runnable acb;
  private long acc;
  private long acd;
  private a ace;
  private int mAlpha = 255;
  private boolean xi;
  
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
    //   1: getfield 62	android/support/v7/d/a/b:ace	Landroid/support/v7/d/a/b$a;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 10	android/support/v7/d/a/b$a
    //   11: dup
    //   12: invokespecial 63	android/support/v7/d/a/b$a:<init>	()V
    //   15: putfield 62	android/support/v7/d/a/b:ace	Landroid/support/v7/d/a/b$a;
    //   18: aload_0
    //   19: getfield 62	android/support/v7/d/a/b:ace	Landroid/support/v7/d/a/b$a;
    //   22: astore_2
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 67	android/graphics/drawable/Drawable:getCallback	()Landroid/graphics/drawable/Drawable$Callback;
    //   28: putfield 71	android/support/v7/d/a/b$a:wS	Landroid/graphics/drawable/Drawable$Callback;
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 75	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   36: aload_0
    //   37: getfield 77	android/support/v7/d/a/b:abU	Landroid/support/v7/d/a/b$b;
    //   40: getfield 80	android/support/v7/d/a/b$b:acD	I
    //   43: ifgt +18 -> 61
    //   46: aload_0
    //   47: getfield 82	android/support/v7/d/a/b:abY	Z
    //   50: ifeq +11 -> 61
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 41	android/support/v7/d/a/b:mAlpha	I
    //   58: invokevirtual 86	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   61: aload_0
    //   62: getfield 77	android/support/v7/d/a/b:abU	Landroid/support/v7/d/a/b$b;
    //   65: getfield 89	android/support/v7/d/a/b$b:acF	Z
    //   68: ifeq +146 -> 214
    //   71: aload_1
    //   72: aload_0
    //   73: getfield 77	android/support/v7/d/a/b:abU	Landroid/support/v7/d/a/b$b;
    //   76: getfield 93	android/support/v7/d/a/b$b:xh	Landroid/graphics/ColorFilter;
    //   79: invokevirtual 97	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   82: aload_1
    //   83: aload_0
    //   84: invokevirtual 101	android/support/v7/d/a/b:isVisible	()Z
    //   87: iconst_1
    //   88: invokevirtual 105	android/graphics/drawable/Drawable:setVisible	(ZZ)Z
    //   91: pop
    //   92: aload_1
    //   93: aload_0
    //   94: getfield 77	android/support/v7/d/a/b:abU	Landroid/support/v7/d/a/b$b;
    //   97: getfield 108	android/support/v7/d/a/b$b:acC	Z
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
    //   156: getfield 77	android/support/v7/d/a/b:abU	Landroid/support/v7/d/a/b$b;
    //   159: getfield 150	android/support/v7/d/a/b$b:yg	Z
    //   162: invokevirtual 153	android/graphics/drawable/Drawable:setAutoMirrored	(Z)V
    //   165: aload_0
    //   166: getfield 155	android/support/v7/d/a/b:abV	Landroid/graphics/Rect;
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
    //   204: getfield 62	android/support/v7/d/a/b:ace	Landroid/support/v7/d/a/b$a;
    //   207: invokevirtual 176	android/support/v7/d/a/b$a:hm	()Landroid/graphics/drawable/Drawable$Callback;
    //   210: invokevirtual 75	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   213: return
    //   214: aload_0
    //   215: getfield 77	android/support/v7/d/a/b:abU	Landroid/support/v7/d/a/b$b;
    //   218: getfield 179	android/support/v7/d/a/b$b:acG	Z
    //   221: ifeq +14 -> 235
    //   224: aload_1
    //   225: aload_0
    //   226: getfield 77	android/support/v7/d/a/b:abU	Landroid/support/v7/d/a/b$b;
    //   229: getfield 183	android/support/v7/d/a/b$b:Kh	Landroid/content/res/ColorStateList;
    //   232: invokestatic 188	android/support/v4/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    //   235: aload_0
    //   236: getfield 77	android/support/v7/d/a/b:abU	Landroid/support/v7/d/a/b$b;
    //   239: getfield 191	android/support/v7/d/a/b$b:acH	Z
    //   242: ifeq -160 -> 82
    //   245: aload_1
    //   246: aload_0
    //   247: getfield 77	android/support/v7/d/a/b:abU	Landroid/support/v7/d/a/b$b;
    //   250: getfield 195	android/support/v7/d/a/b$b:yf	Landroid/graphics/PorterDuff$Mode;
    //   253: invokestatic 198	android/support/v4/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    //   256: goto -174 -> 82
    //   259: astore_2
    //   260: aload_1
    //   261: aload_0
    //   262: getfield 62	android/support/v7/d/a/b:ace	Landroid/support/v7/d/a/b$a;
    //   265: invokevirtual 176	android/support/v7/d/a/b$a:hm	()Landroid/graphics/drawable/Drawable$Callback;
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
    this.abY = true;
    long l = SystemClock.uptimeMillis();
    if (this.abW != null)
    {
      if (this.acc != 0L)
      {
        if (this.acc > l) {
          break label132;
        }
        this.abW.setAlpha(this.mAlpha);
      }
    }
    else {
      this.acc = 0L;
    }
    int i = 0;
    if (this.abX != null)
    {
      j = i;
      if (this.acd != 0L)
      {
        if (this.acd > l) {
          break label179;
        }
        this.abX.setVisible(false, false);
        this.abX = null;
        this.aca = -1;
      }
    }
    else
    {
      this.acd = 0L;
    }
    for (int j = i;; j = 1)
    {
      if ((paramBoolean) && (j != 0)) {
        scheduleSelf(this.acb, 16L + l);
      }
      return;
      label132:
      i = (int)((this.acc - l) * 255L) / this.abU.acD;
      this.abW.setAlpha((255 - i) * this.mAlpha / 255);
      i = 1;
      break;
      label179:
      i = (int)((this.acd - l) * 255L) / this.abU.acE;
      this.abX.setAlpha(i * this.mAlpha / 255);
    }
  }
  
  protected void a(b paramb)
  {
    this.abU = paramb;
    if (this.abZ >= 0)
    {
      this.abW = paramb.getChild(this.abZ);
      if (this.abW != null) {
        m(this.abW);
      }
    }
    this.aca = -1;
    this.abX = null;
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    b localb = this.abU;
    if (paramTheme != null)
    {
      localb.ho();
      int j = localb.acm;
      Drawable[] arrayOfDrawable = localb.acl;
      int i = 0;
      while (i < j)
      {
        if ((arrayOfDrawable[i] != null) && (arrayOfDrawable[i].canApplyTheme()))
        {
          arrayOfDrawable[i].applyTheme(paramTheme);
          localb.acj |= arrayOfDrawable[i].getChangingConfigurations();
        }
        i += 1;
      }
      localb.e(paramTheme.getResources());
    }
  }
  
  public boolean canApplyTheme()
  {
    return this.abU.canApplyTheme();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.abW != null) {
      this.abW.draw(paramCanvas);
    }
    if (this.abX != null) {
      this.abX.draw(paramCanvas);
    }
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.abU.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (this.abU.canConstantState())
    {
      this.abU.mChangingConfigurations = getChangingConfigurations();
      return this.abU;
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.abW;
  }
  
  public void getHotspotBounds(Rect paramRect)
  {
    if (this.abV != null)
    {
      paramRect.set(this.abV);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.abU.acq)
    {
      b localb = this.abU;
      if (!localb.acr) {
        localb.computeConstantSize();
      }
      return localb.act;
    }
    if (this.abW != null) {
      return this.abW.getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.abU.acq)
    {
      b localb = this.abU;
      if (!localb.acr) {
        localb.computeConstantSize();
      }
      return localb.acs;
    }
    if (this.abW != null) {
      return this.abW.getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getMinimumHeight()
  {
    if (this.abU.acq)
    {
      b localb = this.abU;
      if (!localb.acr) {
        localb.computeConstantSize();
      }
      return localb.acv;
    }
    if (this.abW != null) {
      return this.abW.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    if (this.abU.acq)
    {
      b localb = this.abU;
      if (!localb.acr) {
        localb.computeConstantSize();
      }
      return localb.acu;
    }
    if (this.abW != null) {
      return this.abW.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    int i = -2;
    if ((this.abW == null) || (!this.abW.isVisible())) {
      return -2;
    }
    b localb = this.abU;
    if (localb.acw) {
      return localb.acx;
    }
    localb.ho();
    int k = localb.acm;
    Drawable[] arrayOfDrawable = localb.acl;
    if (k > 0) {
      i = arrayOfDrawable[0].getOpacity();
    }
    int j = 1;
    while (j < k)
    {
      i = Drawable.resolveOpacity(i, arrayOfDrawable[j].getOpacity());
      j += 1;
    }
    localb.acx = i;
    localb.acw = true;
    return i;
  }
  
  public void getOutline(Outline paramOutline)
  {
    if (this.abW != null) {
      this.abW.getOutline(paramOutline);
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 1;
    b localb = this.abU;
    int k;
    boolean bool;
    if (localb.acn)
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
      if ((localb.acp != null) || (localb.aco))
      {
        localObject1 = localb.acp;
        break;
      }
      localb.ho();
      Rect localRect = new Rect();
      k = localb.acm;
      Drawable[] arrayOfDrawable = localb.acl;
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
      localb.aco = true;
      localb.acp = ((Rect)localObject1);
      break;
      bool = false;
      break label76;
      if (this.abW != null)
      {
        bool = this.abW.getPadding(paramRect);
        break label76;
      }
      bool = super.getPadding(paramRect);
      break label76;
    }
  }
  
  b hj()
  {
    return this.abU;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.abU != null) {
      this.abU.hn();
    }
    if ((paramDrawable == this.abW) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public boolean isAutoMirrored()
  {
    return this.abU.yg;
  }
  
  public boolean isStateful()
  {
    boolean bool2 = false;
    b localb = this.abU;
    if (localb.acy) {
      return localb.acz;
    }
    localb.ho();
    int j = localb.acm;
    Drawable[] arrayOfDrawable = localb.acl;
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
        localb.acz = bool1;
        localb.acy = true;
        return bool1;
      }
      i += 1;
    }
  }
  
  public void jumpToCurrentState()
  {
    int j = 1;
    int i = 0;
    if (this.abX != null)
    {
      this.abX.jumpToCurrentState();
      this.abX = null;
      this.aca = -1;
      i = 1;
    }
    if (this.abW != null)
    {
      this.abW.jumpToCurrentState();
      if (this.abY) {
        this.abW.setAlpha(this.mAlpha);
      }
    }
    if (this.acd != 0L)
    {
      this.acd = 0L;
      i = 1;
    }
    if (this.acc != 0L)
    {
      this.acc = 0L;
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
    if ((!this.xi) && (super.mutate() == this))
    {
      b localb = hj();
      localb.hk();
      a(localb);
      this.xi = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.abX != null) {
      this.abX.setBounds(paramRect);
    }
    if (this.abW != null) {
      this.abW.setBounds(paramRect);
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    b localb = this.abU;
    int j = this.abZ;
    int k = localb.acm;
    Drawable[] arrayOfDrawable = localb.acl;
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
    if (this.abX != null) {
      return this.abX.setLevel(paramInt);
    }
    if (this.abW != null) {
      return this.abW.setLevel(paramInt);
    }
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.abX != null) {
      return this.abX.setState(paramArrayOfInt);
    }
    if (this.abW != null) {
      return this.abW.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.abW) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  final boolean selectDrawable(int paramInt)
  {
    if (paramInt == this.abZ) {
      return false;
    }
    long l = SystemClock.uptimeMillis();
    if (this.abU.acE > 0)
    {
      if (this.abX != null) {
        this.abX.setVisible(false, false);
      }
      if (this.abW != null)
      {
        this.abX = this.abW;
        this.aca = this.abZ;
        this.acd = (this.abU.acE + l);
        if ((paramInt < 0) || (paramInt >= this.abU.acm)) {
          break label235;
        }
        Drawable localDrawable = this.abU.getChild(paramInt);
        this.abW = localDrawable;
        this.abZ = paramInt;
        if (localDrawable != null)
        {
          if (this.abU.acD > 0) {
            this.acc = (l + this.abU.acD);
          }
          m(localDrawable);
        }
        label149:
        if ((this.acc != 0L) || (this.acd != 0L))
        {
          if (this.acb != null) {
            break label248;
          }
          this.acb = new Runnable()
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
      this.abX = null;
      this.aca = -1;
      this.acd = 0L;
      break;
      if (this.abW == null) {
        break;
      }
      this.abW.setVisible(false, false);
      break;
      label235:
      this.abW = null;
      this.abZ = -1;
      break label149;
      label248:
      unscheduleSelf(this.acb);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if ((!this.abY) || (this.mAlpha != paramInt))
    {
      this.abY = true;
      this.mAlpha = paramInt;
      if (this.abW != null)
      {
        if (this.acc != 0L) {
          break label50;
        }
        this.abW.setAlpha(paramInt);
      }
    }
    return;
    label50:
    Z(false);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.abU.yg != paramBoolean)
    {
      this.abU.yg = paramBoolean;
      if (this.abW != null) {
        a.a(this.abW, this.abU.yg);
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.abU.acF = true;
    if (this.abU.xh != paramColorFilter)
    {
      this.abU.xh = paramColorFilter;
      if (this.abW != null) {
        this.abW.setColorFilter(paramColorFilter);
      }
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (this.abU.acC != paramBoolean)
    {
      this.abU.acC = paramBoolean;
      if (this.abW != null) {
        this.abW.setDither(this.abU.acC);
      }
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.abW != null) {
      a.a(this.abW, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.abV == null) {
      this.abV = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      if (this.abW != null) {
        a.a(this.abW, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      return;
      this.abV.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.abU.acG = true;
    if (this.abU.Kh != paramColorStateList)
    {
      this.abU.Kh = paramColorStateList;
      a.a(this.abW, paramColorStateList);
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.abU.acH = true;
    if (this.abU.yf != paramMode)
    {
      this.abU.yf = paramMode;
      a.a(this.abW, paramMode);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.abX != null) {
      this.abX.setVisible(paramBoolean1, paramBoolean2);
    }
    if (this.abW != null) {
      this.abW.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if ((paramDrawable == this.abW) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
  
  static final class a
    implements Drawable.Callback
  {
    Drawable.Callback wS;
    
    public final Drawable.Callback hm()
    {
      Drawable.Callback localCallback = this.wS;
      this.wS = null;
      return localCallback;
    }
    
    public final void invalidateDrawable(Drawable paramDrawable) {}
    
    public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      if (this.wS != null) {
        this.wS.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
    }
    
    public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      if (this.wS != null) {
        this.wS.unscheduleDrawable(paramDrawable, paramRunnable);
      }
    }
  }
  
  static abstract class b
    extends Drawable.ConstantState
  {
    ColorStateList Kh;
    boolean acA;
    boolean acB;
    boolean acC = true;
    int acD = 0;
    int acE = 0;
    boolean acF;
    boolean acG;
    boolean acH;
    final b acg;
    Resources ach;
    int aci = 160;
    int acj;
    SparseArray<Drawable.ConstantState> ack;
    Drawable[] acl;
    int acm;
    boolean acn = false;
    boolean aco;
    Rect acp;
    boolean acq = false;
    boolean acr;
    int acs;
    int act;
    int acu;
    int acv;
    boolean acw;
    int acx;
    boolean acy;
    boolean acz;
    int mChangingConfigurations;
    int mLayoutDirection;
    ColorFilter xh;
    boolean xi;
    PorterDuff.Mode yf;
    boolean yg;
    
    b(b paramb, b paramb1, Resources paramResources)
    {
      this.acg = paramb1;
      int i;
      if (paramResources != null)
      {
        paramb1 = paramResources;
        this.ach = paramb1;
        if (paramb == null) {
          break label450;
        }
        i = paramb.aci;
        label65:
        this.aci = b.b(paramResources, i);
        if (paramb == null) {
          break label488;
        }
        this.mChangingConfigurations = paramb.mChangingConfigurations;
        this.acj = paramb.acj;
        this.acA = true;
        this.acB = true;
        this.acn = paramb.acn;
        this.acq = paramb.acq;
        this.acC = paramb.acC;
        this.xi = paramb.xi;
        this.mLayoutDirection = paramb.mLayoutDirection;
        this.acD = paramb.acD;
        this.acE = paramb.acE;
        this.yg = paramb.yg;
        this.xh = paramb.xh;
        this.acF = paramb.acF;
        this.Kh = paramb.Kh;
        this.yf = paramb.yf;
        this.acG = paramb.acG;
        this.acH = paramb.acH;
        if (paramb.aci == this.aci)
        {
          if (paramb.aco)
          {
            this.acp = new Rect(paramb.acp);
            this.aco = true;
          }
          if (paramb.acr)
          {
            this.acs = paramb.acs;
            this.act = paramb.act;
            this.acu = paramb.acu;
            this.acv = paramb.acv;
            this.acr = true;
          }
        }
        if (paramb.acw)
        {
          this.acx = paramb.acx;
          this.acw = true;
        }
        if (paramb.acy)
        {
          this.acz = paramb.acz;
          this.acy = true;
        }
        paramb1 = paramb.acl;
        this.acl = new Drawable[paramb1.length];
        this.acm = paramb.acm;
        paramb = paramb.ack;
        if (paramb == null) {
          break label456;
        }
        this.ack = paramb.clone();
        label378:
        int k = this.acm;
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
          this.ack.put(i, paramb);
        }
      }
      for (;;)
      {
        i += 1;
        break label388;
        if (paramb != null)
        {
          paramb1 = paramb.ach;
          break;
        }
        paramb1 = null;
        break;
        label450:
        i = 0;
        break label65;
        label456:
        this.ack = new SparseArray(this.acm);
        break label378;
        label474:
        this.acl[i] = paramb1[i];
      }
      label488:
      this.acl = new Drawable[10];
      this.acm = 0;
    }
    
    private Drawable n(Drawable paramDrawable)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(this.mLayoutDirection);
      }
      paramDrawable = paramDrawable.mutate();
      paramDrawable.setCallback(this.acg);
      return paramDrawable;
    }
    
    public final int addChild(Drawable paramDrawable)
    {
      int i = this.acm;
      if (i >= this.acl.length) {
        growArray(i, i + 10);
      }
      paramDrawable.mutate();
      paramDrawable.setVisible(false, true);
      paramDrawable.setCallback(this.acg);
      this.acl[i] = paramDrawable;
      this.acm += 1;
      this.acj |= paramDrawable.getChangingConfigurations();
      hn();
      this.acp = null;
      this.aco = false;
      this.acr = false;
      this.acA = false;
      return i;
    }
    
    public boolean canApplyTheme()
    {
      int j = this.acm;
      Drawable[] arrayOfDrawable = this.acl;
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
          localObject = (Drawable.ConstantState)this.ack.get(i);
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
          if (this.acA)
          {
            bool = this.acB;
            return bool;
          }
          ho();
          this.acA = true;
          int j = this.acm;
          Drawable[] arrayOfDrawable = this.acl;
          int i = 0;
          if (i >= j) {
            break label79;
          }
          if (arrayOfDrawable[i].getConstantState() == null)
          {
            this.acB = false;
            continue;
          }
          i += 1;
        }
        finally {}
        continue;
        label79:
        this.acB = true;
        bool = true;
      }
    }
    
    final void computeConstantSize()
    {
      int i = 0;
      this.acr = true;
      ho();
      int j = this.acm;
      Drawable[] arrayOfDrawable = this.acl;
      this.act = -1;
      this.acs = -1;
      this.acv = 0;
      this.acu = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        int k = localDrawable.getIntrinsicWidth();
        if (k > this.acs) {
          this.acs = k;
        }
        k = localDrawable.getIntrinsicHeight();
        if (k > this.act) {
          this.act = k;
        }
        k = localDrawable.getMinimumWidth();
        if (k > this.acu) {
          this.acu = k;
        }
        k = localDrawable.getMinimumHeight();
        if (k > this.acv) {
          this.acv = k;
        }
        i += 1;
      }
    }
    
    final void e(Resources paramResources)
    {
      if (paramResources != null)
      {
        this.ach = paramResources;
        int i = b.b(paramResources, this.aci);
        int j = this.aci;
        this.aci = i;
        if (j != i)
        {
          this.acr = false;
          this.aco = false;
        }
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations | this.acj;
    }
    
    public final Drawable getChild(int paramInt)
    {
      Object localObject = this.acl[paramInt];
      if (localObject != null) {}
      Drawable localDrawable;
      do
      {
        return localObject;
        if (this.ack == null) {
          break;
        }
        int i = this.ack.indexOfKey(paramInt);
        if (i < 0) {
          break;
        }
        localDrawable = n(((Drawable.ConstantState)this.ack.valueAt(i)).newDrawable(this.ach));
        this.acl[paramInt] = localDrawable;
        this.ack.removeAt(i);
        localObject = localDrawable;
      } while (this.ack.size() != 0);
      this.ack = null;
      return localDrawable;
      return null;
    }
    
    public void growArray(int paramInt1, int paramInt2)
    {
      Drawable[] arrayOfDrawable = new Drawable[paramInt2];
      System.arraycopy(this.acl, 0, arrayOfDrawable, 0, paramInt1);
      this.acl = arrayOfDrawable;
    }
    
    void hk()
    {
      int j = this.acm;
      Drawable[] arrayOfDrawable = this.acl;
      int i = 0;
      while (i < j)
      {
        if (arrayOfDrawable[i] != null) {
          arrayOfDrawable[i].mutate();
        }
        i += 1;
      }
      this.xi = true;
    }
    
    final void hn()
    {
      this.acw = false;
      this.acy = false;
    }
    
    final void ho()
    {
      if (this.ack != null)
      {
        int j = this.ack.size();
        int i = 0;
        while (i < j)
        {
          int k = this.ack.keyAt(i);
          Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.ack.valueAt(i);
          this.acl[k] = n(localConstantState.newDrawable(this.ach));
          i += 1;
        }
        this.ack = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.d.a.b
 * JD-Core Version:    0.7.0.1
 */