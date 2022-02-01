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
  b aae;
  private Rect aaf;
  private Drawable aag;
  private Drawable aah;
  private boolean aai;
  int aaj = -1;
  private int aak = -1;
  private Runnable aal;
  private long aam;
  private long aan;
  private a aao;
  private int mAlpha = 255;
  private boolean vp;
  
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
    //   1: getfield 62	android/support/v7/d/a/b:aao	Landroid/support/v7/d/a/b$a;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 10	android/support/v7/d/a/b$a
    //   11: dup
    //   12: invokespecial 63	android/support/v7/d/a/b$a:<init>	()V
    //   15: putfield 62	android/support/v7/d/a/b:aao	Landroid/support/v7/d/a/b$a;
    //   18: aload_0
    //   19: getfield 62	android/support/v7/d/a/b:aao	Landroid/support/v7/d/a/b$a;
    //   22: astore_2
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 67	android/graphics/drawable/Drawable:getCallback	()Landroid/graphics/drawable/Drawable$Callback;
    //   28: putfield 71	android/support/v7/d/a/b$a:uZ	Landroid/graphics/drawable/Drawable$Callback;
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 75	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   36: aload_0
    //   37: getfield 77	android/support/v7/d/a/b:aae	Landroid/support/v7/d/a/b$b;
    //   40: getfield 80	android/support/v7/d/a/b$b:aaN	I
    //   43: ifgt +18 -> 61
    //   46: aload_0
    //   47: getfield 82	android/support/v7/d/a/b:aai	Z
    //   50: ifeq +11 -> 61
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 41	android/support/v7/d/a/b:mAlpha	I
    //   58: invokevirtual 86	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   61: aload_0
    //   62: getfield 77	android/support/v7/d/a/b:aae	Landroid/support/v7/d/a/b$b;
    //   65: getfield 89	android/support/v7/d/a/b$b:aaP	Z
    //   68: ifeq +146 -> 214
    //   71: aload_1
    //   72: aload_0
    //   73: getfield 77	android/support/v7/d/a/b:aae	Landroid/support/v7/d/a/b$b;
    //   76: getfield 93	android/support/v7/d/a/b$b:vo	Landroid/graphics/ColorFilter;
    //   79: invokevirtual 97	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   82: aload_1
    //   83: aload_0
    //   84: invokevirtual 101	android/support/v7/d/a/b:isVisible	()Z
    //   87: iconst_1
    //   88: invokevirtual 105	android/graphics/drawable/Drawable:setVisible	(ZZ)Z
    //   91: pop
    //   92: aload_1
    //   93: aload_0
    //   94: getfield 77	android/support/v7/d/a/b:aae	Landroid/support/v7/d/a/b$b;
    //   97: getfield 108	android/support/v7/d/a/b$b:aaM	Z
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
    //   156: getfield 77	android/support/v7/d/a/b:aae	Landroid/support/v7/d/a/b$b;
    //   159: getfield 150	android/support/v7/d/a/b$b:wo	Z
    //   162: invokevirtual 153	android/graphics/drawable/Drawable:setAutoMirrored	(Z)V
    //   165: aload_0
    //   166: getfield 155	android/support/v7/d/a/b:aaf	Landroid/graphics/Rect;
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
    //   204: getfield 62	android/support/v7/d/a/b:aao	Landroid/support/v7/d/a/b$a;
    //   207: invokevirtual 176	android/support/v7/d/a/b$a:gV	()Landroid/graphics/drawable/Drawable$Callback;
    //   210: invokevirtual 75	android/graphics/drawable/Drawable:setCallback	(Landroid/graphics/drawable/Drawable$Callback;)V
    //   213: return
    //   214: aload_0
    //   215: getfield 77	android/support/v7/d/a/b:aae	Landroid/support/v7/d/a/b$b;
    //   218: getfield 179	android/support/v7/d/a/b$b:aaQ	Z
    //   221: ifeq +14 -> 235
    //   224: aload_1
    //   225: aload_0
    //   226: getfield 77	android/support/v7/d/a/b:aae	Landroid/support/v7/d/a/b$b;
    //   229: getfield 183	android/support/v7/d/a/b$b:Ip	Landroid/content/res/ColorStateList;
    //   232: invokestatic 188	android/support/v4/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V
    //   235: aload_0
    //   236: getfield 77	android/support/v7/d/a/b:aae	Landroid/support/v7/d/a/b$b;
    //   239: getfield 191	android/support/v7/d/a/b$b:aaR	Z
    //   242: ifeq -160 -> 82
    //   245: aload_1
    //   246: aload_0
    //   247: getfield 77	android/support/v7/d/a/b:aae	Landroid/support/v7/d/a/b$b;
    //   250: getfield 195	android/support/v7/d/a/b$b:wn	Landroid/graphics/PorterDuff$Mode;
    //   253: invokestatic 198	android/support/v4/graphics/drawable/a:a	(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V
    //   256: goto -174 -> 82
    //   259: astore_2
    //   260: aload_1
    //   261: aload_0
    //   262: getfield 62	android/support/v7/d/a/b:aao	Landroid/support/v7/d/a/b$a;
    //   265: invokevirtual 176	android/support/v7/d/a/b$a:gV	()Landroid/graphics/drawable/Drawable$Callback;
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
    this.aai = true;
    long l = SystemClock.uptimeMillis();
    if (this.aag != null)
    {
      if (this.aam != 0L)
      {
        if (this.aam > l) {
          break label132;
        }
        this.aag.setAlpha(this.mAlpha);
      }
    }
    else {
      this.aam = 0L;
    }
    int i = 0;
    if (this.aah != null)
    {
      j = i;
      if (this.aan != 0L)
      {
        if (this.aan > l) {
          break label179;
        }
        this.aah.setVisible(false, false);
        this.aah = null;
        this.aak = -1;
      }
    }
    else
    {
      this.aan = 0L;
    }
    for (int j = i;; j = 1)
    {
      if ((paramBoolean) && (j != 0)) {
        scheduleSelf(this.aal, 16L + l);
      }
      return;
      label132:
      i = (int)((this.aam - l) * 255L) / this.aae.aaN;
      this.aag.setAlpha((255 - i) * this.mAlpha / 255);
      i = 1;
      break;
      label179:
      i = (int)((this.aan - l) * 255L) / this.aae.aaO;
      this.aah.setAlpha(i * this.mAlpha / 255);
    }
  }
  
  protected void a(b paramb)
  {
    this.aae = paramb;
    if (this.aaj >= 0)
    {
      this.aag = paramb.getChild(this.aaj);
      if (this.aag != null) {
        m(this.aag);
      }
    }
    this.aak = -1;
    this.aah = null;
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    b localb = this.aae;
    if (paramTheme != null)
    {
      localb.gX();
      int j = localb.aaw;
      Drawable[] arrayOfDrawable = localb.aav;
      int i = 0;
      while (i < j)
      {
        if ((arrayOfDrawable[i] != null) && (arrayOfDrawable[i].canApplyTheme()))
        {
          arrayOfDrawable[i].applyTheme(paramTheme);
          localb.aat |= arrayOfDrawable[i].getChangingConfigurations();
        }
        i += 1;
      }
      localb.e(paramTheme.getResources());
    }
  }
  
  public boolean canApplyTheme()
  {
    return this.aae.canApplyTheme();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.aag != null) {
      this.aag.draw(paramCanvas);
    }
    if (this.aah != null) {
      this.aah.draw(paramCanvas);
    }
  }
  
  b gS()
  {
    return this.aae;
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.aae.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (this.aae.canConstantState())
    {
      this.aae.mChangingConfigurations = getChangingConfigurations();
      return this.aae;
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.aag;
  }
  
  public void getHotspotBounds(Rect paramRect)
  {
    if (this.aaf != null)
    {
      paramRect.set(this.aaf);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.aae.aaA)
    {
      b localb = this.aae;
      if (!localb.aaB) {
        localb.computeConstantSize();
      }
      return localb.aaD;
    }
    if (this.aag != null) {
      return this.aag.getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.aae.aaA)
    {
      b localb = this.aae;
      if (!localb.aaB) {
        localb.computeConstantSize();
      }
      return localb.aaC;
    }
    if (this.aag != null) {
      return this.aag.getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getMinimumHeight()
  {
    if (this.aae.aaA)
    {
      b localb = this.aae;
      if (!localb.aaB) {
        localb.computeConstantSize();
      }
      return localb.aaF;
    }
    if (this.aag != null) {
      return this.aag.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    if (this.aae.aaA)
    {
      b localb = this.aae;
      if (!localb.aaB) {
        localb.computeConstantSize();
      }
      return localb.aaE;
    }
    if (this.aag != null) {
      return this.aag.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    int i = -2;
    if ((this.aag == null) || (!this.aag.isVisible())) {
      return -2;
    }
    b localb = this.aae;
    if (localb.aaG) {
      return localb.aaH;
    }
    localb.gX();
    int k = localb.aaw;
    Drawable[] arrayOfDrawable = localb.aav;
    if (k > 0) {
      i = arrayOfDrawable[0].getOpacity();
    }
    int j = 1;
    while (j < k)
    {
      i = Drawable.resolveOpacity(i, arrayOfDrawable[j].getOpacity());
      j += 1;
    }
    localb.aaH = i;
    localb.aaG = true;
    return i;
  }
  
  public void getOutline(Outline paramOutline)
  {
    if (this.aag != null) {
      this.aag.getOutline(paramOutline);
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 1;
    b localb = this.aae;
    int k;
    boolean bool;
    if (localb.aax)
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
      if ((localb.aaz != null) || (localb.aay))
      {
        localObject1 = localb.aaz;
        break;
      }
      localb.gX();
      Rect localRect = new Rect();
      k = localb.aaw;
      Drawable[] arrayOfDrawable = localb.aav;
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
      localb.aay = true;
      localb.aaz = ((Rect)localObject1);
      break;
      bool = false;
      break label76;
      if (this.aag != null)
      {
        bool = this.aag.getPadding(paramRect);
        break label76;
      }
      bool = super.getPadding(paramRect);
      break label76;
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.aae != null) {
      this.aae.gW();
    }
    if ((paramDrawable == this.aag) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public boolean isAutoMirrored()
  {
    return this.aae.wo;
  }
  
  public boolean isStateful()
  {
    boolean bool2 = false;
    b localb = this.aae;
    if (localb.aaI) {
      return localb.aaJ;
    }
    localb.gX();
    int j = localb.aaw;
    Drawable[] arrayOfDrawable = localb.aav;
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
        localb.aaJ = bool1;
        localb.aaI = true;
        return bool1;
      }
      i += 1;
    }
  }
  
  public void jumpToCurrentState()
  {
    int j = 1;
    int i = 0;
    if (this.aah != null)
    {
      this.aah.jumpToCurrentState();
      this.aah = null;
      this.aak = -1;
      i = 1;
    }
    if (this.aag != null)
    {
      this.aag.jumpToCurrentState();
      if (this.aai) {
        this.aag.setAlpha(this.mAlpha);
      }
    }
    if (this.aan != 0L)
    {
      this.aan = 0L;
      i = 1;
    }
    if (this.aam != 0L)
    {
      this.aam = 0L;
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
    if ((!this.vp) && (super.mutate() == this))
    {
      b localb = gS();
      localb.gT();
      a(localb);
      this.vp = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.aah != null) {
      this.aah.setBounds(paramRect);
    }
    if (this.aag != null) {
      this.aag.setBounds(paramRect);
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    b localb = this.aae;
    int j = this.aaj;
    int k = localb.aaw;
    Drawable[] arrayOfDrawable = localb.aav;
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
    if (this.aah != null) {
      return this.aah.setLevel(paramInt);
    }
    if (this.aag != null) {
      return this.aag.setLevel(paramInt);
    }
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.aah != null) {
      return this.aah.setState(paramArrayOfInt);
    }
    if (this.aag != null) {
      return this.aag.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.aag) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  final boolean selectDrawable(int paramInt)
  {
    if (paramInt == this.aaj) {
      return false;
    }
    long l = SystemClock.uptimeMillis();
    if (this.aae.aaO > 0)
    {
      if (this.aah != null) {
        this.aah.setVisible(false, false);
      }
      if (this.aag != null)
      {
        this.aah = this.aag;
        this.aak = this.aaj;
        this.aan = (this.aae.aaO + l);
        if ((paramInt < 0) || (paramInt >= this.aae.aaw)) {
          break label235;
        }
        Drawable localDrawable = this.aae.getChild(paramInt);
        this.aag = localDrawable;
        this.aaj = paramInt;
        if (localDrawable != null)
        {
          if (this.aae.aaN > 0) {
            this.aam = (l + this.aae.aaN);
          }
          m(localDrawable);
        }
        label149:
        if ((this.aam != 0L) || (this.aan != 0L))
        {
          if (this.aal != null) {
            break label248;
          }
          this.aal = new Runnable()
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
      this.aah = null;
      this.aak = -1;
      this.aan = 0L;
      break;
      if (this.aag == null) {
        break;
      }
      this.aag.setVisible(false, false);
      break;
      label235:
      this.aag = null;
      this.aaj = -1;
      break label149;
      label248:
      unscheduleSelf(this.aal);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if ((!this.aai) || (this.mAlpha != paramInt))
    {
      this.aai = true;
      this.mAlpha = paramInt;
      if (this.aag != null)
      {
        if (this.aam != 0L) {
          break label50;
        }
        this.aag.setAlpha(paramInt);
      }
    }
    return;
    label50:
    Z(false);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.aae.wo != paramBoolean)
    {
      this.aae.wo = paramBoolean;
      if (this.aag != null) {
        a.a(this.aag, this.aae.wo);
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.aae.aaP = true;
    if (this.aae.vo != paramColorFilter)
    {
      this.aae.vo = paramColorFilter;
      if (this.aag != null) {
        this.aag.setColorFilter(paramColorFilter);
      }
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (this.aae.aaM != paramBoolean)
    {
      this.aae.aaM = paramBoolean;
      if (this.aag != null) {
        this.aag.setDither(this.aae.aaM);
      }
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.aag != null) {
      a.a(this.aag, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.aaf == null) {
      this.aaf = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      if (this.aag != null) {
        a.a(this.aag, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      return;
      this.aaf.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.aae.aaQ = true;
    if (this.aae.Ip != paramColorStateList)
    {
      this.aae.Ip = paramColorStateList;
      a.a(this.aag, paramColorStateList);
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.aae.aaR = true;
    if (this.aae.wn != paramMode)
    {
      this.aae.wn = paramMode;
      a.a(this.aag, paramMode);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.aah != null) {
      this.aah.setVisible(paramBoolean1, paramBoolean2);
    }
    if (this.aag != null) {
      this.aag.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if ((paramDrawable == this.aag) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
  
  static final class a
    implements Drawable.Callback
  {
    Drawable.Callback uZ;
    
    public final Drawable.Callback gV()
    {
      Drawable.Callback localCallback = this.uZ;
      this.uZ = null;
      return localCallback;
    }
    
    public final void invalidateDrawable(Drawable paramDrawable) {}
    
    public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      if (this.uZ != null) {
        this.uZ.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
    }
    
    public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      if (this.uZ != null) {
        this.uZ.unscheduleDrawable(paramDrawable, paramRunnable);
      }
    }
  }
  
  static abstract class b
    extends Drawable.ConstantState
  {
    ColorStateList Ip;
    boolean aaA = false;
    boolean aaB;
    int aaC;
    int aaD;
    int aaE;
    int aaF;
    boolean aaG;
    int aaH;
    boolean aaI;
    boolean aaJ;
    boolean aaK;
    boolean aaL;
    boolean aaM = true;
    int aaN = 0;
    int aaO = 0;
    boolean aaP;
    boolean aaQ;
    boolean aaR;
    final b aaq;
    Resources aar;
    int aas = 160;
    int aat;
    SparseArray<Drawable.ConstantState> aau;
    Drawable[] aav;
    int aaw;
    boolean aax = false;
    boolean aay;
    Rect aaz;
    int mChangingConfigurations;
    int mLayoutDirection;
    ColorFilter vo;
    boolean vp;
    PorterDuff.Mode wn;
    boolean wo;
    
    b(b paramb, b paramb1, Resources paramResources)
    {
      this.aaq = paramb1;
      int i;
      if (paramResources != null)
      {
        paramb1 = paramResources;
        this.aar = paramb1;
        if (paramb == null) {
          break label450;
        }
        i = paramb.aas;
        label65:
        this.aas = b.b(paramResources, i);
        if (paramb == null) {
          break label488;
        }
        this.mChangingConfigurations = paramb.mChangingConfigurations;
        this.aat = paramb.aat;
        this.aaK = true;
        this.aaL = true;
        this.aax = paramb.aax;
        this.aaA = paramb.aaA;
        this.aaM = paramb.aaM;
        this.vp = paramb.vp;
        this.mLayoutDirection = paramb.mLayoutDirection;
        this.aaN = paramb.aaN;
        this.aaO = paramb.aaO;
        this.wo = paramb.wo;
        this.vo = paramb.vo;
        this.aaP = paramb.aaP;
        this.Ip = paramb.Ip;
        this.wn = paramb.wn;
        this.aaQ = paramb.aaQ;
        this.aaR = paramb.aaR;
        if (paramb.aas == this.aas)
        {
          if (paramb.aay)
          {
            this.aaz = new Rect(paramb.aaz);
            this.aay = true;
          }
          if (paramb.aaB)
          {
            this.aaC = paramb.aaC;
            this.aaD = paramb.aaD;
            this.aaE = paramb.aaE;
            this.aaF = paramb.aaF;
            this.aaB = true;
          }
        }
        if (paramb.aaG)
        {
          this.aaH = paramb.aaH;
          this.aaG = true;
        }
        if (paramb.aaI)
        {
          this.aaJ = paramb.aaJ;
          this.aaI = true;
        }
        paramb1 = paramb.aav;
        this.aav = new Drawable[paramb1.length];
        this.aaw = paramb.aaw;
        paramb = paramb.aau;
        if (paramb == null) {
          break label456;
        }
        this.aau = paramb.clone();
        label378:
        int k = this.aaw;
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
          this.aau.put(i, paramb);
        }
      }
      for (;;)
      {
        i += 1;
        break label388;
        if (paramb != null)
        {
          paramb1 = paramb.aar;
          break;
        }
        paramb1 = null;
        break;
        label450:
        i = 0;
        break label65;
        label456:
        this.aau = new SparseArray(this.aaw);
        break label378;
        label474:
        this.aav[i] = paramb1[i];
      }
      label488:
      this.aav = new Drawable[10];
      this.aaw = 0;
    }
    
    private Drawable n(Drawable paramDrawable)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(this.mLayoutDirection);
      }
      paramDrawable = paramDrawable.mutate();
      paramDrawable.setCallback(this.aaq);
      return paramDrawable;
    }
    
    public final int addChild(Drawable paramDrawable)
    {
      int i = this.aaw;
      if (i >= this.aav.length) {
        growArray(i, i + 10);
      }
      paramDrawable.mutate();
      paramDrawable.setVisible(false, true);
      paramDrawable.setCallback(this.aaq);
      this.aav[i] = paramDrawable;
      this.aaw += 1;
      this.aat |= paramDrawable.getChangingConfigurations();
      gW();
      this.aaz = null;
      this.aay = false;
      this.aaB = false;
      this.aaK = false;
      return i;
    }
    
    public boolean canApplyTheme()
    {
      int j = this.aaw;
      Drawable[] arrayOfDrawable = this.aav;
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
          localObject = (Drawable.ConstantState)this.aau.get(i);
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
          if (this.aaK)
          {
            bool = this.aaL;
            return bool;
          }
          gX();
          this.aaK = true;
          int j = this.aaw;
          Drawable[] arrayOfDrawable = this.aav;
          int i = 0;
          if (i >= j) {
            break label79;
          }
          if (arrayOfDrawable[i].getConstantState() == null)
          {
            this.aaL = false;
            continue;
          }
          i += 1;
        }
        finally {}
        continue;
        label79:
        this.aaL = true;
        bool = true;
      }
    }
    
    final void computeConstantSize()
    {
      int i = 0;
      this.aaB = true;
      gX();
      int j = this.aaw;
      Drawable[] arrayOfDrawable = this.aav;
      this.aaD = -1;
      this.aaC = -1;
      this.aaF = 0;
      this.aaE = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        int k = localDrawable.getIntrinsicWidth();
        if (k > this.aaC) {
          this.aaC = k;
        }
        k = localDrawable.getIntrinsicHeight();
        if (k > this.aaD) {
          this.aaD = k;
        }
        k = localDrawable.getMinimumWidth();
        if (k > this.aaE) {
          this.aaE = k;
        }
        k = localDrawable.getMinimumHeight();
        if (k > this.aaF) {
          this.aaF = k;
        }
        i += 1;
      }
    }
    
    final void e(Resources paramResources)
    {
      if (paramResources != null)
      {
        this.aar = paramResources;
        int i = b.b(paramResources, this.aas);
        int j = this.aas;
        this.aas = i;
        if (j != i)
        {
          this.aaB = false;
          this.aay = false;
        }
      }
    }
    
    void gT()
    {
      int j = this.aaw;
      Drawable[] arrayOfDrawable = this.aav;
      int i = 0;
      while (i < j)
      {
        if (arrayOfDrawable[i] != null) {
          arrayOfDrawable[i].mutate();
        }
        i += 1;
      }
      this.vp = true;
    }
    
    final void gW()
    {
      this.aaG = false;
      this.aaI = false;
    }
    
    final void gX()
    {
      if (this.aau != null)
      {
        int j = this.aau.size();
        int i = 0;
        while (i < j)
        {
          int k = this.aau.keyAt(i);
          Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.aau.valueAt(i);
          this.aav[k] = n(localConstantState.newDrawable(this.aar));
          i += 1;
        }
        this.aau = null;
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations | this.aat;
    }
    
    public final Drawable getChild(int paramInt)
    {
      Object localObject = this.aav[paramInt];
      if (localObject != null) {}
      Drawable localDrawable;
      do
      {
        return localObject;
        if (this.aau == null) {
          break;
        }
        int i = this.aau.indexOfKey(paramInt);
        if (i < 0) {
          break;
        }
        localDrawable = n(((Drawable.ConstantState)this.aau.valueAt(i)).newDrawable(this.aar));
        this.aav[paramInt] = localDrawable;
        this.aau.removeAt(i);
        localObject = localDrawable;
      } while (this.aau.size() != 0);
      this.aau = null;
      return localDrawable;
      return null;
    }
    
    public void growArray(int paramInt1, int paramInt2)
    {
      Drawable[] arrayOfDrawable = new Drawable[paramInt2];
      System.arraycopy(this.aav, 0, arrayOfDrawable, 0, paramInt1);
      this.aav = arrayOfDrawable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.d.a.b
 * JD-Core Version:    0.7.0.1
 */