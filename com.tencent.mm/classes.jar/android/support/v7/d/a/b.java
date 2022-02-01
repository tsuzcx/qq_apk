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
  b ach;
  private Rect aci;
  private Drawable acj;
  private Drawable ack;
  private boolean acl;
  int acm = -1;
  private int acn = -1;
  private Runnable aco;
  private long acp;
  private long acq;
  private a acr;
  private int mAlpha = 255;
  private boolean xp;
  
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
    //   1: getfield 62	android/support/v7/d/a/b:acr	Landroid/support/v7/d/a/b$a;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 10	android/support/v7/d/a/b$a
    //   11: dup
    //   12: invokespecial 63	android/support/v7/d/a/b$a:<init>	()V
    //   15: putfield 62	android/support/v7/d/a/b:acr	Landroid/support/v7/d/a/b$a;
    //   18: aload_0
    //   19: getfield 62	android/support/v7/d/a/b:acr	Landroid/support/v7/d/a/b$a;
    //   22: astore_2
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 67	android/graphics/drawable/Drawable:getCallback	()Landroid/graphics/drawable/Drawable$Callback;
    //   28: putfield 71	android/support/v7/d/a/b$a:wZ	Landroid/graphics/drawable/Drawable$Callback;
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 75	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   36: aload_0
    //   37: getfield 77	android/support/v7/d/a/b:ach	Landroid/support/v7/d/a/b$b;
    //   40: getfield 80	android/support/v7/d/a/b$b:acQ	I
    //   43: ifgt +18 -> 61
    //   46: aload_0
    //   47: getfield 82	android/support/v7/d/a/b:acl	Z
    //   50: ifeq +11 -> 61
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 41	android/support/v7/d/a/b:mAlpha	I
    //   58: invokevirtual 86	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   61: aload_0
    //   62: getfield 77	android/support/v7/d/a/b:ach	Landroid/support/v7/d/a/b$b;
    //   65: getfield 89	android/support/v7/d/a/b$b:acS	Z
    //   68: ifeq +146 -> 214
    //   71: aload_1
    //   72: aload_0
    //   73: getfield 77	android/support/v7/d/a/b:ach	Landroid/support/v7/d/a/b$b;
    //   76: getfield 93	android/support/v7/d/a/b$b:xo	Landroid/graphics/ColorFilter;
    //   79: invokevirtual 97	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   82: aload_1
    //   83: aload_0
    //   84: invokevirtual 101	android/support/v7/d/a/b:isVisible	()Z
    //   87: iconst_1
    //   88: invokevirtual 105	android/graphics/drawable/Drawable:setVisible	(ZZ)Z
    //   91: pop
    //   92: aload_1
    //   93: aload_0
    //   94: getfield 77	android/support/v7/d/a/b:ach	Landroid/support/v7/d/a/b$b;
    //   97: getfield 108	android/support/v7/d/a/b$b:acP	Z
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
    //   156: getfield 77	android/support/v7/d/a/b:ach	Landroid/support/v7/d/a/b$b;
    //   159: getfield 150	android/support/v7/d/a/b$b:ym	Z
    //   162: invokevirtual 153	android/graphics/drawable/Drawable:setAutoMirrored	(Z)V
    //   165: aload_0
    //   166: getfield 155	android/support/v7/d/a/b:aci	Landroid/graphics/Rect;
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
    //   204: getfield 62	android/support/v7/d/a/b:acr	Landroid/support/v7/d/a/b$a;
    //   207: invokevirtual 176	android/support/v7/d/a/b$a:hv	()Landroid/graphics/drawable/Drawable$Callback;
    //   210: invokevirtual 75	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   213: return
    //   214: aload_0
    //   215: getfield 77	android/support/v7/d/a/b:ach	Landroid/support/v7/d/a/b$b;
    //   218: getfield 179	android/support/v7/d/a/b$b:acT	Z
    //   221: ifeq +14 -> 235
    //   224: aload_1
    //   225: aload_0
    //   226: getfield 77	android/support/v7/d/a/b:ach	Landroid/support/v7/d/a/b$b;
    //   229: getfield 183	android/support/v7/d/a/b$b:Kr	Landroid/content/res/ColorStateList;
    //   232: invokestatic 188	android/support/v4/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    //   235: aload_0
    //   236: getfield 77	android/support/v7/d/a/b:ach	Landroid/support/v7/d/a/b$b;
    //   239: getfield 191	android/support/v7/d/a/b$b:acU	Z
    //   242: ifeq -160 -> 82
    //   245: aload_1
    //   246: aload_0
    //   247: getfield 77	android/support/v7/d/a/b:ach	Landroid/support/v7/d/a/b$b;
    //   250: getfield 195	android/support/v7/d/a/b$b:yl	Landroid/graphics/PorterDuff$Mode;
    //   253: invokestatic 198	android/support/v4/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    //   256: goto -174 -> 82
    //   259: astore_2
    //   260: aload_1
    //   261: aload_0
    //   262: getfield 62	android/support/v7/d/a/b:acr	Landroid/support/v7/d/a/b$a;
    //   265: invokevirtual 176	android/support/v7/d/a/b$a:hv	()Landroid/graphics/drawable/Drawable$Callback;
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
  
  final void Y(boolean paramBoolean)
  {
    this.acl = true;
    long l = SystemClock.uptimeMillis();
    if (this.acj != null)
    {
      if (this.acp != 0L)
      {
        if (this.acp > l) {
          break label132;
        }
        this.acj.setAlpha(this.mAlpha);
      }
    }
    else {
      this.acp = 0L;
    }
    int i = 0;
    if (this.ack != null)
    {
      j = i;
      if (this.acq != 0L)
      {
        if (this.acq > l) {
          break label179;
        }
        this.ack.setVisible(false, false);
        this.ack = null;
        this.acn = -1;
      }
    }
    else
    {
      this.acq = 0L;
    }
    for (int j = i;; j = 1)
    {
      if ((paramBoolean) && (j != 0)) {
        scheduleSelf(this.aco, 16L + l);
      }
      return;
      label132:
      i = (int)((this.acp - l) * 255L) / this.ach.acQ;
      this.acj.setAlpha((255 - i) * this.mAlpha / 255);
      i = 1;
      break;
      label179:
      i = (int)((this.acq - l) * 255L) / this.ach.acR;
      this.ack.setAlpha(i * this.mAlpha / 255);
    }
  }
  
  protected void a(b paramb)
  {
    this.ach = paramb;
    if (this.acm >= 0)
    {
      this.acj = paramb.getChild(this.acm);
      if (this.acj != null) {
        m(this.acj);
      }
    }
    this.acn = -1;
    this.ack = null;
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    b localb = this.ach;
    if (paramTheme != null)
    {
      localb.hx();
      int j = localb.acz;
      Drawable[] arrayOfDrawable = localb.acy;
      int i = 0;
      while (i < j)
      {
        if ((arrayOfDrawable[i] != null) && (arrayOfDrawable[i].canApplyTheme()))
        {
          arrayOfDrawable[i].applyTheme(paramTheme);
          localb.acw |= arrayOfDrawable[i].getChangingConfigurations();
        }
        i += 1;
      }
      localb.e(paramTheme.getResources());
    }
  }
  
  public boolean canApplyTheme()
  {
    return this.ach.canApplyTheme();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.acj != null) {
      this.acj.draw(paramCanvas);
    }
    if (this.ack != null) {
      this.ack.draw(paramCanvas);
    }
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.ach.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (this.ach.canConstantState())
    {
      this.ach.mChangingConfigurations = getChangingConfigurations();
      return this.ach;
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.acj;
  }
  
  public void getHotspotBounds(Rect paramRect)
  {
    if (this.aci != null)
    {
      paramRect.set(this.aci);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.ach.acD)
    {
      b localb = this.ach;
      if (!localb.acE) {
        localb.computeConstantSize();
      }
      return localb.acG;
    }
    if (this.acj != null) {
      return this.acj.getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.ach.acD)
    {
      b localb = this.ach;
      if (!localb.acE) {
        localb.computeConstantSize();
      }
      return localb.acF;
    }
    if (this.acj != null) {
      return this.acj.getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getMinimumHeight()
  {
    if (this.ach.acD)
    {
      b localb = this.ach;
      if (!localb.acE) {
        localb.computeConstantSize();
      }
      return localb.acI;
    }
    if (this.acj != null) {
      return this.acj.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    if (this.ach.acD)
    {
      b localb = this.ach;
      if (!localb.acE) {
        localb.computeConstantSize();
      }
      return localb.acH;
    }
    if (this.acj != null) {
      return this.acj.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    int i = -2;
    if ((this.acj == null) || (!this.acj.isVisible())) {
      return -2;
    }
    b localb = this.ach;
    if (localb.acJ) {
      return localb.acK;
    }
    localb.hx();
    int k = localb.acz;
    Drawable[] arrayOfDrawable = localb.acy;
    if (k > 0) {
      i = arrayOfDrawable[0].getOpacity();
    }
    int j = 1;
    while (j < k)
    {
      i = Drawable.resolveOpacity(i, arrayOfDrawable[j].getOpacity());
      j += 1;
    }
    localb.acK = i;
    localb.acJ = true;
    return i;
  }
  
  public void getOutline(Outline paramOutline)
  {
    if (this.acj != null) {
      this.acj.getOutline(paramOutline);
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 1;
    b localb = this.ach;
    int k;
    boolean bool;
    if (localb.acA)
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
      if ((localb.acC != null) || (localb.acB))
      {
        localObject1 = localb.acC;
        break;
      }
      localb.hx();
      Rect localRect = new Rect();
      k = localb.acz;
      Drawable[] arrayOfDrawable = localb.acy;
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
      localb.acB = true;
      localb.acC = ((Rect)localObject1);
      break;
      bool = false;
      break label76;
      if (this.acj != null)
      {
        bool = this.acj.getPadding(paramRect);
        break label76;
      }
      bool = super.getPadding(paramRect);
      break label76;
    }
  }
  
  b hs()
  {
    return this.ach;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.ach != null) {
      this.ach.hw();
    }
    if ((paramDrawable == this.acj) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public boolean isAutoMirrored()
  {
    return this.ach.ym;
  }
  
  public boolean isStateful()
  {
    boolean bool2 = false;
    b localb = this.ach;
    if (localb.acL) {
      return localb.acM;
    }
    localb.hx();
    int j = localb.acz;
    Drawable[] arrayOfDrawable = localb.acy;
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
        localb.acM = bool1;
        localb.acL = true;
        return bool1;
      }
      i += 1;
    }
  }
  
  public void jumpToCurrentState()
  {
    int j = 1;
    int i = 0;
    if (this.ack != null)
    {
      this.ack.jumpToCurrentState();
      this.ack = null;
      this.acn = -1;
      i = 1;
    }
    if (this.acj != null)
    {
      this.acj.jumpToCurrentState();
      if (this.acl) {
        this.acj.setAlpha(this.mAlpha);
      }
    }
    if (this.acq != 0L)
    {
      this.acq = 0L;
      i = 1;
    }
    if (this.acp != 0L)
    {
      this.acp = 0L;
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
    if ((!this.xp) && (super.mutate() == this))
    {
      b localb = hs();
      localb.ht();
      a(localb);
      this.xp = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.ack != null) {
      this.ack.setBounds(paramRect);
    }
    if (this.acj != null) {
      this.acj.setBounds(paramRect);
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    b localb = this.ach;
    int j = this.acm;
    int k = localb.acz;
    Drawable[] arrayOfDrawable = localb.acy;
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
    if (this.ack != null) {
      return this.ack.setLevel(paramInt);
    }
    if (this.acj != null) {
      return this.acj.setLevel(paramInt);
    }
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.ack != null) {
      return this.ack.setState(paramArrayOfInt);
    }
    if (this.acj != null) {
      return this.acj.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.acj) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  final boolean selectDrawable(int paramInt)
  {
    if (paramInt == this.acm) {
      return false;
    }
    long l = SystemClock.uptimeMillis();
    if (this.ach.acR > 0)
    {
      if (this.ack != null) {
        this.ack.setVisible(false, false);
      }
      if (this.acj != null)
      {
        this.ack = this.acj;
        this.acn = this.acm;
        this.acq = (this.ach.acR + l);
        if ((paramInt < 0) || (paramInt >= this.ach.acz)) {
          break label235;
        }
        Drawable localDrawable = this.ach.getChild(paramInt);
        this.acj = localDrawable;
        this.acm = paramInt;
        if (localDrawable != null)
        {
          if (this.ach.acQ > 0) {
            this.acp = (l + this.ach.acQ);
          }
          m(localDrawable);
        }
        label149:
        if ((this.acp != 0L) || (this.acq != 0L))
        {
          if (this.aco != null) {
            break label248;
          }
          this.aco = new Runnable()
          {
            public final void run()
            {
              b.this.Y(true);
              b.this.invalidateSelf();
            }
          };
        }
      }
    }
    for (;;)
    {
      Y(true);
      invalidateSelf();
      return true;
      this.ack = null;
      this.acn = -1;
      this.acq = 0L;
      break;
      if (this.acj == null) {
        break;
      }
      this.acj.setVisible(false, false);
      break;
      label235:
      this.acj = null;
      this.acm = -1;
      break label149;
      label248:
      unscheduleSelf(this.aco);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if ((!this.acl) || (this.mAlpha != paramInt))
    {
      this.acl = true;
      this.mAlpha = paramInt;
      if (this.acj != null)
      {
        if (this.acp != 0L) {
          break label50;
        }
        this.acj.setAlpha(paramInt);
      }
    }
    return;
    label50:
    Y(false);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.ach.ym != paramBoolean)
    {
      this.ach.ym = paramBoolean;
      if (this.acj != null) {
        a.a(this.acj, this.ach.ym);
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.ach.acS = true;
    if (this.ach.xo != paramColorFilter)
    {
      this.ach.xo = paramColorFilter;
      if (this.acj != null) {
        this.acj.setColorFilter(paramColorFilter);
      }
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (this.ach.acP != paramBoolean)
    {
      this.ach.acP = paramBoolean;
      if (this.acj != null) {
        this.acj.setDither(this.ach.acP);
      }
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.acj != null) {
      a.a(this.acj, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.aci == null) {
      this.aci = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      if (this.acj != null) {
        a.a(this.acj, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      return;
      this.aci.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.ach.acT = true;
    if (this.ach.Kr != paramColorStateList)
    {
      this.ach.Kr = paramColorStateList;
      a.a(this.acj, paramColorStateList);
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.ach.acU = true;
    if (this.ach.yl != paramMode)
    {
      this.ach.yl = paramMode;
      a.a(this.acj, paramMode);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.ack != null) {
      this.ack.setVisible(paramBoolean1, paramBoolean2);
    }
    if (this.acj != null) {
      this.acj.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if ((paramDrawable == this.acj) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
  
  static final class a
    implements Drawable.Callback
  {
    Drawable.Callback wZ;
    
    public final Drawable.Callback hv()
    {
      Drawable.Callback localCallback = this.wZ;
      this.wZ = null;
      return localCallback;
    }
    
    public final void invalidateDrawable(Drawable paramDrawable) {}
    
    public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      if (this.wZ != null) {
        this.wZ.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
    }
    
    public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      if (this.wZ != null) {
        this.wZ.unscheduleDrawable(paramDrawable, paramRunnable);
      }
    }
  }
  
  static abstract class b
    extends Drawable.ConstantState
  {
    ColorStateList Kr;
    boolean acA = false;
    boolean acB;
    Rect acC;
    boolean acD = false;
    boolean acE;
    int acF;
    int acG;
    int acH;
    int acI;
    boolean acJ;
    int acK;
    boolean acL;
    boolean acM;
    boolean acN;
    boolean acO;
    boolean acP = true;
    int acQ = 0;
    int acR = 0;
    boolean acS;
    boolean acT;
    boolean acU;
    final b act;
    Resources acu;
    int acv = 160;
    int acw;
    SparseArray<Drawable.ConstantState> acx;
    Drawable[] acy;
    int acz;
    int mChangingConfigurations;
    int mLayoutDirection;
    ColorFilter xo;
    boolean xp;
    PorterDuff.Mode yl;
    boolean ym;
    
    b(b paramb, b paramb1, Resources paramResources)
    {
      this.act = paramb1;
      int i;
      if (paramResources != null)
      {
        paramb1 = paramResources;
        this.acu = paramb1;
        if (paramb == null) {
          break label450;
        }
        i = paramb.acv;
        label65:
        this.acv = b.b(paramResources, i);
        if (paramb == null) {
          break label488;
        }
        this.mChangingConfigurations = paramb.mChangingConfigurations;
        this.acw = paramb.acw;
        this.acN = true;
        this.acO = true;
        this.acA = paramb.acA;
        this.acD = paramb.acD;
        this.acP = paramb.acP;
        this.xp = paramb.xp;
        this.mLayoutDirection = paramb.mLayoutDirection;
        this.acQ = paramb.acQ;
        this.acR = paramb.acR;
        this.ym = paramb.ym;
        this.xo = paramb.xo;
        this.acS = paramb.acS;
        this.Kr = paramb.Kr;
        this.yl = paramb.yl;
        this.acT = paramb.acT;
        this.acU = paramb.acU;
        if (paramb.acv == this.acv)
        {
          if (paramb.acB)
          {
            this.acC = new Rect(paramb.acC);
            this.acB = true;
          }
          if (paramb.acE)
          {
            this.acF = paramb.acF;
            this.acG = paramb.acG;
            this.acH = paramb.acH;
            this.acI = paramb.acI;
            this.acE = true;
          }
        }
        if (paramb.acJ)
        {
          this.acK = paramb.acK;
          this.acJ = true;
        }
        if (paramb.acL)
        {
          this.acM = paramb.acM;
          this.acL = true;
        }
        paramb1 = paramb.acy;
        this.acy = new Drawable[paramb1.length];
        this.acz = paramb.acz;
        paramb = paramb.acx;
        if (paramb == null) {
          break label456;
        }
        this.acx = paramb.clone();
        label378:
        int k = this.acz;
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
          this.acx.put(i, paramb);
        }
      }
      for (;;)
      {
        i += 1;
        break label388;
        if (paramb != null)
        {
          paramb1 = paramb.acu;
          break;
        }
        paramb1 = null;
        break;
        label450:
        i = 0;
        break label65;
        label456:
        this.acx = new SparseArray(this.acz);
        break label378;
        label474:
        this.acy[i] = paramb1[i];
      }
      label488:
      this.acy = new Drawable[10];
      this.acz = 0;
    }
    
    private Drawable n(Drawable paramDrawable)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(this.mLayoutDirection);
      }
      paramDrawable = paramDrawable.mutate();
      paramDrawable.setCallback(this.act);
      return paramDrawable;
    }
    
    public final int addChild(Drawable paramDrawable)
    {
      int i = this.acz;
      if (i >= this.acy.length) {
        growArray(i, i + 10);
      }
      paramDrawable.mutate();
      paramDrawable.setVisible(false, true);
      paramDrawable.setCallback(this.act);
      this.acy[i] = paramDrawable;
      this.acz += 1;
      this.acw |= paramDrawable.getChangingConfigurations();
      hw();
      this.acC = null;
      this.acB = false;
      this.acE = false;
      this.acN = false;
      return i;
    }
    
    public boolean canApplyTheme()
    {
      int j = this.acz;
      Drawable[] arrayOfDrawable = this.acy;
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
          localObject = (Drawable.ConstantState)this.acx.get(i);
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
          if (this.acN)
          {
            bool = this.acO;
            return bool;
          }
          hx();
          this.acN = true;
          int j = this.acz;
          Drawable[] arrayOfDrawable = this.acy;
          int i = 0;
          if (i >= j) {
            break label79;
          }
          if (arrayOfDrawable[i].getConstantState() == null)
          {
            this.acO = false;
            continue;
          }
          i += 1;
        }
        finally {}
        continue;
        label79:
        this.acO = true;
        bool = true;
      }
    }
    
    final void computeConstantSize()
    {
      int i = 0;
      this.acE = true;
      hx();
      int j = this.acz;
      Drawable[] arrayOfDrawable = this.acy;
      this.acG = -1;
      this.acF = -1;
      this.acI = 0;
      this.acH = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        int k = localDrawable.getIntrinsicWidth();
        if (k > this.acF) {
          this.acF = k;
        }
        k = localDrawable.getIntrinsicHeight();
        if (k > this.acG) {
          this.acG = k;
        }
        k = localDrawable.getMinimumWidth();
        if (k > this.acH) {
          this.acH = k;
        }
        k = localDrawable.getMinimumHeight();
        if (k > this.acI) {
          this.acI = k;
        }
        i += 1;
      }
    }
    
    final void e(Resources paramResources)
    {
      if (paramResources != null)
      {
        this.acu = paramResources;
        int i = b.b(paramResources, this.acv);
        int j = this.acv;
        this.acv = i;
        if (j != i)
        {
          this.acE = false;
          this.acB = false;
        }
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations | this.acw;
    }
    
    public final Drawable getChild(int paramInt)
    {
      Object localObject = this.acy[paramInt];
      if (localObject != null) {}
      Drawable localDrawable;
      do
      {
        return localObject;
        if (this.acx == null) {
          break;
        }
        int i = this.acx.indexOfKey(paramInt);
        if (i < 0) {
          break;
        }
        localDrawable = n(((Drawable.ConstantState)this.acx.valueAt(i)).newDrawable(this.acu));
        this.acy[paramInt] = localDrawable;
        this.acx.removeAt(i);
        localObject = localDrawable;
      } while (this.acx.size() != 0);
      this.acx = null;
      return localDrawable;
      return null;
    }
    
    public void growArray(int paramInt1, int paramInt2)
    {
      Drawable[] arrayOfDrawable = new Drawable[paramInt2];
      System.arraycopy(this.acy, 0, arrayOfDrawable, 0, paramInt1);
      this.acy = arrayOfDrawable;
    }
    
    void ht()
    {
      int j = this.acz;
      Drawable[] arrayOfDrawable = this.acy;
      int i = 0;
      while (i < j)
      {
        if (arrayOfDrawable[i] != null) {
          arrayOfDrawable[i].mutate();
        }
        i += 1;
      }
      this.xp = true;
    }
    
    final void hw()
    {
      this.acJ = false;
      this.acL = false;
    }
    
    final void hx()
    {
      if (this.acx != null)
      {
        int j = this.acx.size();
        int i = 0;
        while (i < j)
        {
          int k = this.acx.keyAt(i);
          Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.acx.valueAt(i);
          this.acy[k] = n(localConstantState.newDrawable(this.acu));
          i += 1;
        }
        this.acx = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.d.a.b
 * JD-Core Version:    0.7.0.1
 */