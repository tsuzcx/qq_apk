package android.support.v7.d.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.c.a.c;
import android.support.c.a.i;
import android.support.v4.content.a.g;
import android.support.v4.e.f;
import android.support.v4.e.n;
import android.util.AttributeSet;
import android.util.StateSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a
  extends e
{
  private static final String LOGTAG = a.class.getSimpleName();
  private b RT;
  private f RU;
  private int RV = -1;
  private int RW = -1;
  private boolean nP;
  
  public a()
  {
    this(null, null);
  }
  
  a(b paramb, Resources paramResources)
  {
    super((byte)0);
    a(new b(paramb, this, paramResources));
    onStateChange(getState());
    jumpToCurrentState();
  }
  
  public static a b(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject = paramXmlPullParser.getName();
    if (!((String)localObject).equals("animated-selector")) {
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + (String)localObject);
    }
    localObject = new a();
    TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, android.support.v7.a.a.a.AnimatedStateListDrawableCompat);
    ((a)localObject).setVisible(localTypedArray.getBoolean(1, true), true);
    b localb = ((a)localObject).RT;
    if (Build.VERSION.SDK_INT >= 21) {
      localb.mChangingConfigurations |= localTypedArray.getChangingConfigurations();
    }
    localb.Sz = localTypedArray.getBoolean(2, localb.Sz);
    localb.SC = localTypedArray.getBoolean(3, localb.SC);
    localb.SP = localTypedArray.getInt(4, localb.SP);
    localb.SQ = localTypedArray.getInt(5, localb.SQ);
    ((a)localObject).setDither(localTypedArray.getBoolean(0, localb.SO));
    ((b)localObject).Sg.e(paramResources);
    localTypedArray.recycle();
    ((a)localObject).c(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    ((a)localObject).onStateChange(((a)localObject).getState());
    return localObject;
  }
  
  private void c(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    int m = paramXmlPullParser.getDepth() + 1;
    for (;;)
    {
      int i = paramXmlPullParser.next();
      if (i == 1) {
        break;
      }
      int j = paramXmlPullParser.getDepth();
      if ((j < m) && (i == 3)) {
        break;
      }
      if ((i == 2) && (j <= m)) {
        if (paramXmlPullParser.getName().equals("item"))
        {
          Object localObject1 = g.a(paramResources, paramTheme, paramAttributeSet, android.support.v7.a.a.a.AnimatedStateListDrawableItem);
          int n = ((TypedArray)localObject1).getResourceId(0, 0);
          Object localObject2 = null;
          i = ((TypedArray)localObject1).getResourceId(1, -1);
          if (i > 0) {
            localObject2 = android.support.v7.c.a.a.k(paramContext, i);
          }
          ((TypedArray)localObject1).recycle();
          i = 0;
          int i1 = paramAttributeSet.getAttributeCount();
          localObject1 = new int[i1];
          j = 0;
          if (j < i1)
          {
            int k = paramAttributeSet.getAttributeNameResource(j);
            switch (k)
            {
            default: 
              if (!paramAttributeSet.getAttributeBooleanValue(j, false)) {
                break;
              }
            }
            for (;;)
            {
              localObject1[i] = k;
              i += 1;
              for (;;)
              {
                j += 1;
                break;
              }
              k = -k;
            }
          }
          int[] arrayOfInt = StateSet.trimStateSet((int[])localObject1, i);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            do
            {
              i = paramXmlPullParser.next();
            } while (i == 4);
            if (i != 2) {
              throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (!paramXmlPullParser.getName().equals("vector")) {
              break label381;
            }
            localObject1 = i.a(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
          }
          while (localObject1 == null)
          {
            throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            label381:
            if (Build.VERSION.SDK_INT >= 21) {
              localObject1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
            } else {
              localObject1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
            }
          }
          localObject2 = this.RT;
          i = ((e.a)localObject2).addChild((Drawable)localObject1);
          ((e.a)localObject2).Tf[i] = arrayOfInt;
          ((b)localObject2).RZ.put(i, Integer.valueOf(n));
        }
        else if (paramXmlPullParser.getName().equals("transition"))
        {
          d(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        }
      }
    }
  }
  
  private int d(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject = g.a(paramResources, paramTheme, paramAttributeSet, android.support.v7.a.a.a.AnimatedStateListDrawableTransition);
    int i = ((TypedArray)localObject).getResourceId(2, -1);
    int j = ((TypedArray)localObject).getResourceId(1, -1);
    Drawable localDrawable = null;
    int k = ((TypedArray)localObject).getResourceId(0, -1);
    if (k > 0) {
      localDrawable = android.support.v7.c.a.a.k(paramContext, k);
    }
    boolean bool = ((TypedArray)localObject).getBoolean(3, false);
    ((TypedArray)localObject).recycle();
    localObject = localDrawable;
    if (localDrawable == null)
    {
      do
      {
        k = paramXmlPullParser.next();
      } while (k == 4);
      if (k != 2) {
        throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
      }
      if (!paramXmlPullParser.getName().equals("animated-vector")) {
        break label197;
      }
      localObject = c.a(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    while (localObject == null)
    {
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
      label197:
      if (Build.VERSION.SDK_INT >= 21) {
        localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      } else {
        localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
      }
    }
    if ((i == -1) || (j == -1)) {
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }
    return this.RT.a(i, j, (Drawable)localObject, bool);
  }
  
  private b fm()
  {
    return new b(this.RT, this, null);
  }
  
  protected final void a(b.b paramb)
  {
    super.a(paramb);
    if ((paramb instanceof b)) {
      this.RT = ((b)paramb);
    }
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public void jumpToCurrentState()
  {
    super.jumpToCurrentState();
    if (this.RU != null)
    {
      this.RU.stop();
      this.RU = null;
      selectDrawable(this.RV);
      this.RV = -1;
      this.RW = -1;
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.nP) && (super.mutate() == this))
    {
      this.RT.fp();
      this.nP = true;
    }
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int j = this.RT.g(paramArrayOfInt);
    Object localObject;
    int i;
    if (j != this.Sl)
    {
      localObject = this.RU;
      if (localObject != null) {
        if (j == this.RV)
        {
          i = 1;
          if ((i == 0) && (!selectDrawable(j))) {
            break label453;
          }
        }
      }
    }
    label191:
    label448:
    label453:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject = getCurrent();
      boolean bool2 = bool1;
      if (localObject != null) {
        bool2 = bool1 | ((Drawable)localObject).setState(paramArrayOfInt);
      }
      return bool2;
      if ((j == this.RW) && (((f)localObject).fq()))
      {
        ((f)localObject).reverse();
        this.RV = this.RW;
        this.RW = j;
        i = 1;
        break;
      }
      i = this.RV;
      ((f)localObject).stop();
      int k;
      int m;
      for (;;)
      {
        this.RU = null;
        this.RW = -1;
        this.RV = -1;
        localObject = this.RT;
        k = ((b)localObject).aZ(i);
        m = ((b)localObject).aZ(j);
        if ((m != 0) && (k != 0)) {
          break label191;
        }
        i = 0;
        break;
        i = this.Sl;
      }
      long l = b.B(k, m);
      int n = (int)((Long)((b)localObject).RY.get(l, Long.valueOf(-1L))).longValue();
      if (n < 0)
      {
        i = 0;
        break;
      }
      l = b.B(k, m);
      Drawable localDrawable;
      if ((((Long)((b)localObject).RY.get(l, Long.valueOf(-1L))).longValue() & 0x0) != 0L)
      {
        bool1 = true;
        selectDrawable(n);
        localDrawable = getCurrent();
        if (!(localDrawable instanceof AnimationDrawable)) {
          break label398;
        }
        l = b.B(k, m);
        if ((((Long)((b)localObject).RY.get(l, Long.valueOf(-1L))).longValue() & 0x0) == 0L) {
          break label392;
        }
        bool2 = true;
        label342:
        localObject = new d((AnimationDrawable)localDrawable, bool2, bool1);
      }
      for (;;)
      {
        ((f)localObject).start();
        this.RU = ((f)localObject);
        this.RW = i;
        this.RV = j;
        i = 1;
        break;
        bool1 = false;
        break label278;
        bool2 = false;
        break label342;
        if ((localDrawable instanceof c))
        {
          localObject = new c((c)localDrawable);
        }
        else
        {
          if (!(localDrawable instanceof Animatable)) {
            break label448;
          }
          localObject = new a((Animatable)localDrawable);
        }
      }
      i = 0;
      break;
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if ((this.RU != null) && ((bool) || (paramBoolean2)))
    {
      if (paramBoolean1) {
        this.RU.start();
      }
    }
    else {
      return bool;
    }
    jumpToCurrentState();
    return bool;
  }
  
  static final class a
    extends a.f
  {
    private final Animatable RX;
    
    a(Animatable paramAnimatable)
    {
      super();
      this.RX = paramAnimatable;
    }
    
    public final void start()
    {
      this.RX.start();
    }
    
    public final void stop()
    {
      this.RX.stop();
    }
  }
  
  static final class b
    extends e.a
  {
    f<Long> RY;
    n<Integer> RZ;
    
    b(b paramb, a parama, Resources paramResources)
    {
      super(parama, paramResources);
      if (paramb != null)
      {
        this.RY = paramb.RY;
        this.RZ = paramb.RZ;
        return;
      }
      this.RY = new f();
      this.RZ = new n();
    }
    
    static long B(int paramInt1, int paramInt2)
    {
      return paramInt1 << 32 | paramInt2;
    }
    
    final int a(int paramInt1, int paramInt2, Drawable paramDrawable, boolean paramBoolean)
    {
      int i = super.addChild(paramDrawable);
      long l2 = B(paramInt1, paramInt2);
      long l1 = 0L;
      if (paramBoolean) {
        l1 = 8589934592L;
      }
      this.RY.append(l2, Long.valueOf(i | l1));
      if (paramBoolean)
      {
        l2 = B(paramInt2, paramInt1);
        this.RY.append(l2, Long.valueOf(l1 | i | 0x0));
      }
      return i;
    }
    
    final int aZ(int paramInt)
    {
      if (paramInt < 0) {
        return 0;
      }
      return ((Integer)this.RZ.get(paramInt, Integer.valueOf(0))).intValue();
    }
    
    final void fp()
    {
      this.RY = this.RY.dA();
      this.RZ = this.RZ.dB();
    }
    
    final int g(int[] paramArrayOfInt)
    {
      int i = super.h(paramArrayOfInt);
      if (i >= 0) {
        return i;
      }
      return super.h(StateSet.WILD_CARD);
    }
    
    public final Drawable newDrawable()
    {
      return new a(this, null);
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new a(this, paramResources);
    }
  }
  
  static final class c
    extends a.f
  {
    private final c Sa;
    
    c(c paramc)
    {
      super();
      this.Sa = paramc;
    }
    
    public final void start()
    {
      this.Sa.start();
    }
    
    public final void stop()
    {
      this.Sa.stop();
    }
  }
  
  static final class d
    extends a.f
  {
    private final ObjectAnimator Sb;
    private final boolean Sc;
    
    d(AnimationDrawable paramAnimationDrawable, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      int j = paramAnimationDrawable.getNumberOfFrames();
      int i;
      if (paramBoolean1)
      {
        i = j - 1;
        if (!paramBoolean1) {
          break label106;
        }
        j = 0;
      }
      for (;;)
      {
        a.e locale = new a.e(paramAnimationDrawable, paramBoolean1);
        paramAnimationDrawable = ObjectAnimator.ofInt(paramAnimationDrawable, "currentIndex", new int[] { i, j });
        if (Build.VERSION.SDK_INT >= 18) {
          paramAnimationDrawable.setAutoCancel(true);
        }
        paramAnimationDrawable.setDuration(locale.Sf);
        paramAnimationDrawable.setInterpolator(locale);
        this.Sc = paramBoolean2;
        this.Sb = paramAnimationDrawable;
        return;
        i = 0;
        break;
        label106:
        j -= 1;
      }
    }
    
    public final boolean fq()
    {
      return this.Sc;
    }
    
    public final void reverse()
    {
      this.Sb.reverse();
    }
    
    public final void start()
    {
      this.Sb.start();
    }
    
    public final void stop()
    {
      this.Sb.cancel();
    }
  }
  
  static final class e
    implements TimeInterpolator
  {
    private int[] Sd;
    private int Se;
    int Sf;
    
    e(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
    {
      a(paramAnimationDrawable, paramBoolean);
    }
    
    private int a(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
    {
      int m = paramAnimationDrawable.getNumberOfFrames();
      this.Se = m;
      if ((this.Sd == null) || (this.Sd.length < m)) {
        this.Sd = new int[m];
      }
      int[] arrayOfInt = this.Sd;
      int i = 0;
      int j = 0;
      if (i < m)
      {
        if (paramBoolean) {}
        for (int k = m - i - 1;; k = i)
        {
          k = paramAnimationDrawable.getDuration(k);
          arrayOfInt[i] = k;
          i += 1;
          j = k + j;
          break;
        }
      }
      this.Sf = j;
      return j;
    }
    
    public final float getInterpolation(float paramFloat)
    {
      int j = (int)(this.Sf * paramFloat + 0.5F);
      int k = this.Se;
      int[] arrayOfInt = this.Sd;
      int i = 0;
      while ((i < k) && (j >= arrayOfInt[i]))
      {
        j -= arrayOfInt[i];
        i += 1;
      }
      if (i < k) {}
      for (paramFloat = j / this.Sf;; paramFloat = 0.0F) {
        return paramFloat + i / k;
      }
    }
  }
  
  static abstract class f
  {
    public boolean fq()
    {
      return false;
    }
    
    public void reverse() {}
    
    public abstract void start();
    
    public abstract void stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.d.a.a
 * JD-Core Version:    0.7.0.1
 */