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
  b Sg;
  private Rect Sh;
  private Drawable Si;
  private Drawable Sj;
  private boolean Sk;
  int Sl = -1;
  private int Sm = -1;
  private Runnable Sn;
  private long So;
  private long Sp;
  private a Sq;
  private int mAlpha = 255;
  private boolean nP;
  
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
  private void h(Drawable paramDrawable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	android/support/v7/d/a/b:Sq	Landroid/support/v7/d/a/b$a;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 10	android/support/v7/d/a/b$a
    //   11: dup
    //   12: invokespecial 63	android/support/v7/d/a/b$a:<init>	()V
    //   15: putfield 62	android/support/v7/d/a/b:Sq	Landroid/support/v7/d/a/b$a;
    //   18: aload_0
    //   19: getfield 62	android/support/v7/d/a/b:Sq	Landroid/support/v7/d/a/b$a;
    //   22: astore_2
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 67	android/graphics/drawable/Drawable:getCallback	()Landroid/graphics/drawable/Drawable$Callback;
    //   28: putfield 71	android/support/v7/d/a/b$a:nz	Landroid/graphics/drawable/Drawable$Callback;
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 75	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   36: aload_0
    //   37: getfield 77	android/support/v7/d/a/b:Sg	Landroid/support/v7/d/a/b$b;
    //   40: getfield 80	android/support/v7/d/a/b$b:SP	I
    //   43: ifgt +18 -> 61
    //   46: aload_0
    //   47: getfield 82	android/support/v7/d/a/b:Sk	Z
    //   50: ifeq +11 -> 61
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 41	android/support/v7/d/a/b:mAlpha	I
    //   58: invokevirtual 86	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   61: aload_0
    //   62: getfield 77	android/support/v7/d/a/b:Sg	Landroid/support/v7/d/a/b$b;
    //   65: getfield 89	android/support/v7/d/a/b$b:SR	Z
    //   68: ifeq +146 -> 214
    //   71: aload_1
    //   72: aload_0
    //   73: getfield 77	android/support/v7/d/a/b:Sg	Landroid/support/v7/d/a/b$b;
    //   76: getfield 93	android/support/v7/d/a/b$b:nO	Landroid/graphics/ColorFilter;
    //   79: invokevirtual 97	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   82: aload_1
    //   83: aload_0
    //   84: invokevirtual 101	android/support/v7/d/a/b:isVisible	()Z
    //   87: iconst_1
    //   88: invokevirtual 105	android/graphics/drawable/Drawable:setVisible	(ZZ)Z
    //   91: pop
    //   92: aload_1
    //   93: aload_0
    //   94: getfield 77	android/support/v7/d/a/b:Sg	Landroid/support/v7/d/a/b$b;
    //   97: getfield 108	android/support/v7/d/a/b$b:SO	Z
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
    //   156: getfield 77	android/support/v7/d/a/b:Sg	Landroid/support/v7/d/a/b$b;
    //   159: getfield 150	android/support/v7/d/a/b$b:oN	Z
    //   162: invokevirtual 153	android/graphics/drawable/Drawable:setAutoMirrored	(Z)V
    //   165: aload_0
    //   166: getfield 155	android/support/v7/d/a/b:Sh	Landroid/graphics/Rect;
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
    //   204: getfield 62	android/support/v7/d/a/b:Sq	Landroid/support/v7/d/a/b$a;
    //   207: invokevirtual 176	android/support/v7/d/a/b$a:fr	()Landroid/graphics/drawable/Drawable$Callback;
    //   210: invokevirtual 75	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   213: return
    //   214: aload_0
    //   215: getfield 77	android/support/v7/d/a/b:Sg	Landroid/support/v7/d/a/b$b;
    //   218: getfield 179	android/support/v7/d/a/b$b:SS	Z
    //   221: ifeq +14 -> 235
    //   224: aload_1
    //   225: aload_0
    //   226: getfield 77	android/support/v7/d/a/b:Sg	Landroid/support/v7/d/a/b$b;
    //   229: getfield 183	android/support/v7/d/a/b$b:AW	Landroid/content/res/ColorStateList;
    //   232: invokestatic 188	android/support/v4/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    //   235: aload_0
    //   236: getfield 77	android/support/v7/d/a/b:Sg	Landroid/support/v7/d/a/b$b;
    //   239: getfield 191	android/support/v7/d/a/b$b:ST	Z
    //   242: ifeq -160 -> 82
    //   245: aload_1
    //   246: aload_0
    //   247: getfield 77	android/support/v7/d/a/b:Sg	Landroid/support/v7/d/a/b$b;
    //   250: getfield 195	android/support/v7/d/a/b$b:oM	Landroid/graphics/PorterDuff$Mode;
    //   253: invokestatic 198	android/support/v4/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    //   256: goto -174 -> 82
    //   259: astore_2
    //   260: aload_1
    //   261: aload_0
    //   262: getfield 62	android/support/v7/d/a/b:Sq	Landroid/support/v7/d/a/b$a;
    //   265: invokevirtual 176	android/support/v7/d/a/b$a:fr	()Landroid/graphics/drawable/Drawable$Callback;
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
  
  final void T(boolean paramBoolean)
  {
    this.Sk = true;
    long l = SystemClock.uptimeMillis();
    if (this.Si != null)
    {
      if (this.So != 0L)
      {
        if (this.So > l) {
          break label132;
        }
        this.Si.setAlpha(this.mAlpha);
      }
    }
    else {
      this.So = 0L;
    }
    int i = 0;
    if (this.Sj != null)
    {
      j = i;
      if (this.Sp != 0L)
      {
        if (this.Sp > l) {
          break label179;
        }
        this.Sj.setVisible(false, false);
        this.Sj = null;
        this.Sm = -1;
      }
    }
    else
    {
      this.Sp = 0L;
    }
    for (int j = i;; j = 1)
    {
      if ((paramBoolean) && (j != 0)) {
        scheduleSelf(this.Sn, 16L + l);
      }
      return;
      label132:
      i = (int)((this.So - l) * 255L) / this.Sg.SP;
      this.Si.setAlpha((255 - i) * this.mAlpha / 255);
      i = 1;
      break;
      label179:
      i = (int)((this.Sp - l) * 255L) / this.Sg.SQ;
      this.Sj.setAlpha(i * this.mAlpha / 255);
    }
  }
  
  protected void a(b paramb)
  {
    this.Sg = paramb;
    if (this.Sl >= 0)
    {
      this.Si = paramb.getChild(this.Sl);
      if (this.Si != null) {
        h(this.Si);
      }
    }
    this.Sm = -1;
    this.Sj = null;
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    b localb = this.Sg;
    if (paramTheme != null)
    {
      localb.ft();
      int j = localb.Sy;
      Drawable[] arrayOfDrawable = localb.Sx;
      int i = 0;
      while (i < j)
      {
        if ((arrayOfDrawable[i] != null) && (arrayOfDrawable[i].canApplyTheme()))
        {
          arrayOfDrawable[i].applyTheme(paramTheme);
          localb.Sv |= arrayOfDrawable[i].getChangingConfigurations();
        }
        i += 1;
      }
      localb.e(paramTheme.getResources());
    }
  }
  
  public boolean canApplyTheme()
  {
    return this.Sg.canApplyTheme();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.Si != null) {
      this.Si.draw(paramCanvas);
    }
    if (this.Sj != null) {
      this.Sj.draw(paramCanvas);
    }
  }
  
  b fo()
  {
    return this.Sg;
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.Sg.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (this.Sg.canConstantState())
    {
      this.Sg.mChangingConfigurations = getChangingConfigurations();
      return this.Sg;
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.Si;
  }
  
  public void getHotspotBounds(Rect paramRect)
  {
    if (this.Sh != null)
    {
      paramRect.set(this.Sh);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.Sg.SC)
    {
      b localb = this.Sg;
      if (!localb.SD) {
        localb.computeConstantSize();
      }
      return localb.SF;
    }
    if (this.Si != null) {
      return this.Si.getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.Sg.SC)
    {
      b localb = this.Sg;
      if (!localb.SD) {
        localb.computeConstantSize();
      }
      return localb.SE;
    }
    if (this.Si != null) {
      return this.Si.getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getMinimumHeight()
  {
    if (this.Sg.SC)
    {
      b localb = this.Sg;
      if (!localb.SD) {
        localb.computeConstantSize();
      }
      return localb.SH;
    }
    if (this.Si != null) {
      return this.Si.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    if (this.Sg.SC)
    {
      b localb = this.Sg;
      if (!localb.SD) {
        localb.computeConstantSize();
      }
      return localb.SG;
    }
    if (this.Si != null) {
      return this.Si.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    int i = -2;
    if ((this.Si == null) || (!this.Si.isVisible())) {
      return -2;
    }
    b localb = this.Sg;
    if (localb.SI) {
      return localb.SJ;
    }
    localb.ft();
    int k = localb.Sy;
    Drawable[] arrayOfDrawable = localb.Sx;
    if (k > 0) {
      i = arrayOfDrawable[0].getOpacity();
    }
    int j = 1;
    while (j < k)
    {
      i = Drawable.resolveOpacity(i, arrayOfDrawable[j].getOpacity());
      j += 1;
    }
    localb.SJ = i;
    localb.SI = true;
    return i;
  }
  
  public void getOutline(Outline paramOutline)
  {
    if (this.Si != null) {
      this.Si.getOutline(paramOutline);
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 1;
    b localb = this.Sg;
    int k;
    boolean bool;
    if (localb.Sz)
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
      if ((localb.SB != null) || (localb.SA))
      {
        localObject1 = localb.SB;
        break;
      }
      localb.ft();
      Rect localRect = new Rect();
      k = localb.Sy;
      Drawable[] arrayOfDrawable = localb.Sx;
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
      localb.SA = true;
      localb.SB = ((Rect)localObject1);
      break;
      bool = false;
      break label76;
      if (this.Si != null)
      {
        bool = this.Si.getPadding(paramRect);
        break label76;
      }
      bool = super.getPadding(paramRect);
      break label76;
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.Sg != null) {
      this.Sg.fs();
    }
    if ((paramDrawable == this.Si) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public boolean isAutoMirrored()
  {
    return this.Sg.oN;
  }
  
  public boolean isStateful()
  {
    boolean bool2 = false;
    b localb = this.Sg;
    if (localb.SK) {
      return localb.SL;
    }
    localb.ft();
    int j = localb.Sy;
    Drawable[] arrayOfDrawable = localb.Sx;
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
        localb.SL = bool1;
        localb.SK = true;
        return bool1;
      }
      i += 1;
    }
  }
  
  public void jumpToCurrentState()
  {
    int j = 1;
    int i = 0;
    if (this.Sj != null)
    {
      this.Sj.jumpToCurrentState();
      this.Sj = null;
      this.Sm = -1;
      i = 1;
    }
    if (this.Si != null)
    {
      this.Si.jumpToCurrentState();
      if (this.Sk) {
        this.Si.setAlpha(this.mAlpha);
      }
    }
    if (this.Sp != 0L)
    {
      this.Sp = 0L;
      i = 1;
    }
    if (this.So != 0L)
    {
      this.So = 0L;
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
    if ((!this.nP) && (super.mutate() == this))
    {
      b localb = fo();
      localb.fp();
      a(localb);
      this.nP = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.Sj != null) {
      this.Sj.setBounds(paramRect);
    }
    if (this.Si != null) {
      this.Si.setBounds(paramRect);
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    b localb = this.Sg;
    int j = this.Sl;
    int k = localb.Sy;
    Drawable[] arrayOfDrawable = localb.Sx;
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
    if (this.Sj != null) {
      return this.Sj.setLevel(paramInt);
    }
    if (this.Si != null) {
      return this.Si.setLevel(paramInt);
    }
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.Sj != null) {
      return this.Sj.setState(paramArrayOfInt);
    }
    if (this.Si != null) {
      return this.Si.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.Si) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  final boolean selectDrawable(int paramInt)
  {
    if (paramInt == this.Sl) {
      return false;
    }
    long l = SystemClock.uptimeMillis();
    if (this.Sg.SQ > 0)
    {
      if (this.Sj != null) {
        this.Sj.setVisible(false, false);
      }
      if (this.Si != null)
      {
        this.Sj = this.Si;
        this.Sm = this.Sl;
        this.Sp = (this.Sg.SQ + l);
        if ((paramInt < 0) || (paramInt >= this.Sg.Sy)) {
          break label235;
        }
        Drawable localDrawable = this.Sg.getChild(paramInt);
        this.Si = localDrawable;
        this.Sl = paramInt;
        if (localDrawable != null)
        {
          if (this.Sg.SP > 0) {
            this.So = (l + this.Sg.SP);
          }
          h(localDrawable);
        }
        label149:
        if ((this.So != 0L) || (this.Sp != 0L))
        {
          if (this.Sn != null) {
            break label248;
          }
          this.Sn = new Runnable()
          {
            public final void run()
            {
              b.this.T(true);
              b.this.invalidateSelf();
            }
          };
        }
      }
    }
    for (;;)
    {
      T(true);
      invalidateSelf();
      return true;
      this.Sj = null;
      this.Sm = -1;
      this.Sp = 0L;
      break;
      if (this.Si == null) {
        break;
      }
      this.Si.setVisible(false, false);
      break;
      label235:
      this.Si = null;
      this.Sl = -1;
      break label149;
      label248:
      unscheduleSelf(this.Sn);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if ((!this.Sk) || (this.mAlpha != paramInt))
    {
      this.Sk = true;
      this.mAlpha = paramInt;
      if (this.Si != null)
      {
        if (this.So != 0L) {
          break label50;
        }
        this.Si.setAlpha(paramInt);
      }
    }
    return;
    label50:
    T(false);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.Sg.oN != paramBoolean)
    {
      this.Sg.oN = paramBoolean;
      if (this.Si != null) {
        a.a(this.Si, this.Sg.oN);
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.Sg.SR = true;
    if (this.Sg.nO != paramColorFilter)
    {
      this.Sg.nO = paramColorFilter;
      if (this.Si != null) {
        this.Si.setColorFilter(paramColorFilter);
      }
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (this.Sg.SO != paramBoolean)
    {
      this.Sg.SO = paramBoolean;
      if (this.Si != null) {
        this.Si.setDither(this.Sg.SO);
      }
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.Si != null) {
      a.a(this.Si, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.Sh == null) {
      this.Sh = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      if (this.Si != null) {
        a.a(this.Si, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      return;
      this.Sh.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.Sg.SS = true;
    if (this.Sg.AW != paramColorStateList)
    {
      this.Sg.AW = paramColorStateList;
      a.a(this.Si, paramColorStateList);
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.Sg.ST = true;
    if (this.Sg.oM != paramMode)
    {
      this.Sg.oM = paramMode;
      a.a(this.Si, paramMode);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.Sj != null) {
      this.Sj.setVisible(paramBoolean1, paramBoolean2);
    }
    if (this.Si != null) {
      this.Si.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if ((paramDrawable == this.Si) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
  
  static final class a
    implements Drawable.Callback
  {
    Drawable.Callback nz;
    
    public final Drawable.Callback fr()
    {
      Drawable.Callback localCallback = this.nz;
      this.nz = null;
      return localCallback;
    }
    
    public final void invalidateDrawable(Drawable paramDrawable) {}
    
    public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      if (this.nz != null) {
        this.nz.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
    }
    
    public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      if (this.nz != null) {
        this.nz.unscheduleDrawable(paramDrawable, paramRunnable);
      }
    }
  }
  
  static abstract class b
    extends Drawable.ConstantState
  {
    ColorStateList AW;
    boolean SA;
    Rect SB;
    boolean SC = false;
    boolean SD;
    int SE;
    int SF;
    int SG;
    int SH;
    boolean SI;
    int SJ;
    boolean SK;
    boolean SL;
    boolean SM;
    boolean SN;
    boolean SO = true;
    int SP = 0;
    int SQ = 0;
    boolean SR;
    boolean SS;
    boolean ST;
    final b Ss;
    Resources St;
    int Su = 160;
    int Sv;
    SparseArray<Drawable.ConstantState> Sw;
    Drawable[] Sx;
    int Sy;
    boolean Sz = false;
    int mChangingConfigurations;
    int mLayoutDirection;
    ColorFilter nO;
    boolean nP;
    PorterDuff.Mode oM;
    boolean oN;
    
    b(b paramb, b paramb1, Resources paramResources)
    {
      this.Ss = paramb1;
      int i;
      if (paramResources != null)
      {
        paramb1 = paramResources;
        this.St = paramb1;
        if (paramb == null) {
          break label450;
        }
        i = paramb.Su;
        label65:
        this.Su = b.b(paramResources, i);
        if (paramb == null) {
          break label488;
        }
        this.mChangingConfigurations = paramb.mChangingConfigurations;
        this.Sv = paramb.Sv;
        this.SM = true;
        this.SN = true;
        this.Sz = paramb.Sz;
        this.SC = paramb.SC;
        this.SO = paramb.SO;
        this.nP = paramb.nP;
        this.mLayoutDirection = paramb.mLayoutDirection;
        this.SP = paramb.SP;
        this.SQ = paramb.SQ;
        this.oN = paramb.oN;
        this.nO = paramb.nO;
        this.SR = paramb.SR;
        this.AW = paramb.AW;
        this.oM = paramb.oM;
        this.SS = paramb.SS;
        this.ST = paramb.ST;
        if (paramb.Su == this.Su)
        {
          if (paramb.SA)
          {
            this.SB = new Rect(paramb.SB);
            this.SA = true;
          }
          if (paramb.SD)
          {
            this.SE = paramb.SE;
            this.SF = paramb.SF;
            this.SG = paramb.SG;
            this.SH = paramb.SH;
            this.SD = true;
          }
        }
        if (paramb.SI)
        {
          this.SJ = paramb.SJ;
          this.SI = true;
        }
        if (paramb.SK)
        {
          this.SL = paramb.SL;
          this.SK = true;
        }
        paramb1 = paramb.Sx;
        this.Sx = new Drawable[paramb1.length];
        this.Sy = paramb.Sy;
        paramb = paramb.Sw;
        if (paramb == null) {
          break label456;
        }
        this.Sw = paramb.clone();
        label378:
        int k = this.Sy;
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
          this.Sw.put(i, paramb);
        }
      }
      for (;;)
      {
        i += 1;
        break label388;
        if (paramb != null)
        {
          paramb1 = paramb.St;
          break;
        }
        paramb1 = null;
        break;
        label450:
        i = 0;
        break label65;
        label456:
        this.Sw = new SparseArray(this.Sy);
        break label378;
        label474:
        this.Sx[i] = paramb1[i];
      }
      label488:
      this.Sx = new Drawable[10];
      this.Sy = 0;
    }
    
    private Drawable i(Drawable paramDrawable)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(this.mLayoutDirection);
      }
      paramDrawable = paramDrawable.mutate();
      paramDrawable.setCallback(this.Ss);
      return paramDrawable;
    }
    
    public final int addChild(Drawable paramDrawable)
    {
      int i = this.Sy;
      if (i >= this.Sx.length) {
        growArray(i, i + 10);
      }
      paramDrawable.mutate();
      paramDrawable.setVisible(false, true);
      paramDrawable.setCallback(this.Ss);
      this.Sx[i] = paramDrawable;
      this.Sy += 1;
      this.Sv |= paramDrawable.getChangingConfigurations();
      fs();
      this.SB = null;
      this.SA = false;
      this.SD = false;
      this.SM = false;
      return i;
    }
    
    public boolean canApplyTheme()
    {
      int j = this.Sy;
      Drawable[] arrayOfDrawable = this.Sx;
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
          localObject = (Drawable.ConstantState)this.Sw.get(i);
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
          if (this.SM)
          {
            bool = this.SN;
            return bool;
          }
          ft();
          this.SM = true;
          int j = this.Sy;
          Drawable[] arrayOfDrawable = this.Sx;
          int i = 0;
          if (i >= j) {
            break label79;
          }
          if (arrayOfDrawable[i].getConstantState() == null)
          {
            this.SN = false;
            continue;
          }
          i += 1;
        }
        finally {}
        continue;
        label79:
        this.SN = true;
        bool = true;
      }
    }
    
    final void computeConstantSize()
    {
      int i = 0;
      this.SD = true;
      ft();
      int j = this.Sy;
      Drawable[] arrayOfDrawable = this.Sx;
      this.SF = -1;
      this.SE = -1;
      this.SH = 0;
      this.SG = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        int k = localDrawable.getIntrinsicWidth();
        if (k > this.SE) {
          this.SE = k;
        }
        k = localDrawable.getIntrinsicHeight();
        if (k > this.SF) {
          this.SF = k;
        }
        k = localDrawable.getMinimumWidth();
        if (k > this.SG) {
          this.SG = k;
        }
        k = localDrawable.getMinimumHeight();
        if (k > this.SH) {
          this.SH = k;
        }
        i += 1;
      }
    }
    
    final void e(Resources paramResources)
    {
      if (paramResources != null)
      {
        this.St = paramResources;
        int i = b.b(paramResources, this.Su);
        int j = this.Su;
        this.Su = i;
        if (j != i)
        {
          this.SD = false;
          this.SA = false;
        }
      }
    }
    
    void fp()
    {
      int j = this.Sy;
      Drawable[] arrayOfDrawable = this.Sx;
      int i = 0;
      while (i < j)
      {
        if (arrayOfDrawable[i] != null) {
          arrayOfDrawable[i].mutate();
        }
        i += 1;
      }
      this.nP = true;
    }
    
    final void fs()
    {
      this.SI = false;
      this.SK = false;
    }
    
    final void ft()
    {
      if (this.Sw != null)
      {
        int j = this.Sw.size();
        int i = 0;
        while (i < j)
        {
          int k = this.Sw.keyAt(i);
          Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.Sw.valueAt(i);
          this.Sx[k] = i(localConstantState.newDrawable(this.St));
          i += 1;
        }
        this.Sw = null;
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations | this.Sv;
    }
    
    public final Drawable getChild(int paramInt)
    {
      Object localObject = this.Sx[paramInt];
      if (localObject != null) {}
      Drawable localDrawable;
      do
      {
        return localObject;
        if (this.Sw == null) {
          break;
        }
        int i = this.Sw.indexOfKey(paramInt);
        if (i < 0) {
          break;
        }
        localDrawable = i(((Drawable.ConstantState)this.Sw.valueAt(i)).newDrawable(this.St));
        this.Sx[paramInt] = localDrawable;
        this.Sw.removeAt(i);
        localObject = localDrawable;
      } while (this.Sw.size() != 0);
      this.Sw = null;
      return localDrawable;
      return null;
    }
    
    public void growArray(int paramInt1, int paramInt2)
    {
      Drawable[] arrayOfDrawable = new Drawable[paramInt2];
      System.arraycopy(this.Sx, 0, arrayOfDrawable, 0, paramInt1);
      this.Sx = arrayOfDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.d.a.b
 * JD-Core Version:    0.7.0.1
 */