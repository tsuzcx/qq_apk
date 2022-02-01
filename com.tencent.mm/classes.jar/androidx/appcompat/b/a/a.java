package androidx.appcompat.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.a.j;
import androidx.b.h;
import androidx.core.content.a.g;
import androidx.l.a.a.c;
import androidx.l.a.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a
  extends d
{
  private static final String LOGTAG;
  private boolean jA;
  private b jw;
  private f jx;
  private int jy;
  private int jz;
  
  static
  {
    AppMethodBeat.i(199352);
    LOGTAG = a.class.getSimpleName();
    AppMethodBeat.o(199352);
  }
  
  public a()
  {
    this(null, null);
  }
  
  a(b paramb, Resources paramResources)
  {
    super((byte)0);
    AppMethodBeat.i(199306);
    this.jy = -1;
    this.jz = -1;
    a(new b(paramb, this, paramResources));
    onStateChange(getState());
    jumpToCurrentState();
    AppMethodBeat.o(199306);
  }
  
  public static a a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(199320);
    Object localObject = paramXmlPullParser.getName();
    if (!((String)localObject).equals("animated-selector"))
    {
      paramContext = new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + (String)localObject);
      AppMethodBeat.o(199320);
      throw paramContext;
    }
    localObject = new a();
    TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.j.AnimatedStateListDrawableCompat);
    ((a)localObject).setVisible(localTypedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_visible, true), true);
    b localb = ((a)localObject).jw;
    if (Build.VERSION.SDK_INT >= 21) {
      localb.mChangingConfigurations |= localTypedArray.getChangingConfigurations();
    }
    localb.ke = localTypedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_variablePadding, localb.ke);
    localb.kh = localTypedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_constantSize, localb.kh);
    localb.ku = localTypedArray.getInt(a.j.AnimatedStateListDrawableCompat_android_enterFadeDuration, localb.ku);
    localb.kv = localTypedArray.getInt(a.j.AnimatedStateListDrawableCompat_android_exitFadeDuration, localb.kv);
    ((a)localObject).setDither(localTypedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_dither, localb.kt));
    ((a)localObject).e(paramResources);
    localTypedArray.recycle();
    ((a)localObject).b(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    ((a)localObject).onStateChange(((a)localObject).getState());
    AppMethodBeat.o(199320);
    return localObject;
  }
  
  private void b(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(199332);
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
          Object localObject1 = g.a(paramResources, paramTheme, paramAttributeSet, a.j.AnimatedStateListDrawableItem);
          int n = ((TypedArray)localObject1).getResourceId(a.j.AnimatedStateListDrawableItem_android_id, 0);
          Object localObject2 = null;
          i = ((TypedArray)localObject1).getResourceId(a.j.AnimatedStateListDrawableItem_android_drawable, -1);
          if (i > 0) {
            localObject2 = androidx.appcompat.a.a.a.m(paramContext, i);
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
            if (i != 2)
            {
              paramContext = new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
              AppMethodBeat.o(199332);
              throw paramContext;
            }
            if (!paramXmlPullParser.getName().equals("vector")) {
              break label406;
            }
            localObject1 = i.d(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
          }
          while (localObject1 == null)
          {
            paramContext = new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            AppMethodBeat.o(199332);
            throw paramContext;
            label406:
            if (Build.VERSION.SDK_INT >= 21) {
              localObject1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
            } else {
              localObject1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
            }
          }
          localObject2 = this.jw;
          i = ((d.a)localObject2).c((Drawable)localObject1);
          ((d.a)localObject2).kF[i] = arrayOfInt;
          ((b)localObject2).jD.put(i, Integer.valueOf(n));
        }
        else if (paramXmlPullParser.getName().equals("transition"))
        {
          c(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        }
      }
    }
    AppMethodBeat.o(199332);
  }
  
  private int c(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(199340);
    Object localObject = g.a(paramResources, paramTheme, paramAttributeSet, a.j.AnimatedStateListDrawableTransition);
    int i = ((TypedArray)localObject).getResourceId(a.j.AnimatedStateListDrawableTransition_android_fromId, -1);
    int j = ((TypedArray)localObject).getResourceId(a.j.AnimatedStateListDrawableTransition_android_toId, -1);
    Drawable localDrawable = null;
    int k = ((TypedArray)localObject).getResourceId(a.j.AnimatedStateListDrawableTransition_android_drawable, -1);
    if (k > 0) {
      localDrawable = androidx.appcompat.a.a.a.m(paramContext, k);
    }
    boolean bool = ((TypedArray)localObject).getBoolean(a.j.AnimatedStateListDrawableTransition_android_reversible, false);
    ((TypedArray)localObject).recycle();
    localObject = localDrawable;
    if (localDrawable == null)
    {
      do
      {
        k = paramXmlPullParser.next();
      } while (k == 4);
      if (k != 2)
      {
        paramContext = new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        AppMethodBeat.o(199340);
        throw paramContext;
      }
      if (!paramXmlPullParser.getName().equals("animated-vector")) {
        break label227;
      }
      localObject = c.d(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    while (localObject == null)
    {
      paramContext = new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
      AppMethodBeat.o(199340);
      throw paramContext;
      label227:
      if (Build.VERSION.SDK_INT >= 21) {
        localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      } else {
        localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
      }
    }
    if ((i == -1) || (j == -1))
    {
      paramContext = new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
      AppMethodBeat.o(199340);
      throw paramContext;
    }
    i = this.jw.a(i, j, (Drawable)localObject, bool);
    AppMethodBeat.o(199340);
    return i;
  }
  
  private b ch()
  {
    AppMethodBeat.i(199346);
    b localb = new b(this.jw, this, null);
    AppMethodBeat.o(199346);
    return localb;
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(199409);
    super.a(paramb);
    if ((paramb instanceof b)) {
      this.jw = ((b)paramb);
    }
    AppMethodBeat.o(199409);
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public void jumpToCurrentState()
  {
    AppMethodBeat.i(199373);
    super.jumpToCurrentState();
    if (this.jx != null)
    {
      this.jx.stop();
      this.jx = null;
      X(this.jy);
      this.jy = -1;
      this.jz = -1;
    }
    AppMethodBeat.o(199373);
  }
  
  public Drawable mutate()
  {
    AppMethodBeat.i(199401);
    if ((!this.jA) && (super.mutate() == this))
    {
      this.jw.ck();
      this.jA = true;
    }
    AppMethodBeat.o(199401);
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(199392);
    int j = this.jw.e(paramArrayOfInt);
    Object localObject;
    int i;
    if (j != getCurrentIndex())
    {
      localObject = this.jx;
      if (localObject != null) {
        if (j == this.jy)
        {
          i = 1;
          if ((i == 0) && (!X(j))) {
            break label465;
          }
        }
      }
    }
    label203:
    label460:
    label465:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject = getCurrent();
      boolean bool2 = bool1;
      if (localObject != null) {
        bool2 = bool1 | ((Drawable)localObject).setState(paramArrayOfInt);
      }
      AppMethodBeat.o(199392);
      return bool2;
      if ((j == this.jz) && (((f)localObject).cl()))
      {
        ((f)localObject).cm();
        this.jy = this.jz;
        this.jz = j;
        i = 1;
        break;
      }
      i = this.jy;
      ((f)localObject).stop();
      int k;
      int m;
      for (;;)
      {
        this.jx = null;
        this.jz = -1;
        this.jy = -1;
        localObject = this.jw;
        k = ((b)localObject).W(i);
        m = ((b)localObject).W(j);
        if ((m != 0) && (k != 0)) {
          break label203;
        }
        i = 0;
        break;
        i = getCurrentIndex();
      }
      long l = b.l(k, m);
      int n = (int)((Long)((b)localObject).jC.get(l, Long.valueOf(-1L))).longValue();
      if (n < 0)
      {
        i = 0;
        break;
      }
      l = b.l(k, m);
      Drawable localDrawable;
      if ((((Long)((b)localObject).jC.get(l, Long.valueOf(-1L))).longValue() & 0x0) != 0L)
      {
        bool1 = true;
        X(n);
        localDrawable = getCurrent();
        if (!(localDrawable instanceof AnimationDrawable)) {
          break label410;
        }
        l = b.l(k, m);
        if ((((Long)((b)localObject).jC.get(l, Long.valueOf(-1L))).longValue() & 0x0) == 0L) {
          break label404;
        }
        bool2 = true;
        label354:
        localObject = new a.d((AnimationDrawable)localDrawable, bool2, bool1);
      }
      for (;;)
      {
        ((f)localObject).start();
        this.jx = ((f)localObject);
        this.jz = i;
        this.jy = j;
        i = 1;
        break;
        bool1 = false;
        break label290;
        bool2 = false;
        break label354;
        if ((localDrawable instanceof c))
        {
          localObject = new c((c)localDrawable);
        }
        else
        {
          if (!(localDrawable instanceof Animatable)) {
            break label460;
          }
          localObject = new a.a((Animatable)localDrawable);
        }
      }
      i = 0;
      break;
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(199361);
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if ((this.jx != null) && ((bool) || (paramBoolean2)))
    {
      if (!paramBoolean1) {
        break label47;
      }
      this.jx.start();
    }
    for (;;)
    {
      AppMethodBeat.o(199361);
      return bool;
      label47:
      jumpToCurrentState();
    }
  }
  
  static final class b
    extends d.a
  {
    androidx.b.d<Long> jC;
    h<Integer> jD;
    
    b(b paramb, a parama, Resources paramResources)
    {
      super(parama, paramResources);
      AppMethodBeat.i(199272);
      if (paramb != null)
      {
        this.jC = paramb.jC;
        this.jD = paramb.jD;
        AppMethodBeat.o(199272);
        return;
      }
      this.jC = new androidx.b.d();
      this.jD = new h();
      AppMethodBeat.o(199272);
    }
    
    static long l(int paramInt1, int paramInt2)
    {
      return paramInt1 << 32 | paramInt2;
    }
    
    final int W(int paramInt)
    {
      AppMethodBeat.i(199298);
      if (paramInt < 0)
      {
        AppMethodBeat.o(199298);
        return 0;
      }
      paramInt = ((Integer)this.jD.d(paramInt, Integer.valueOf(0))).intValue();
      AppMethodBeat.o(199298);
      return paramInt;
    }
    
    final int a(int paramInt1, int paramInt2, Drawable paramDrawable, boolean paramBoolean)
    {
      AppMethodBeat.i(199288);
      int i = super.c(paramDrawable);
      long l2 = l(paramInt1, paramInt2);
      long l1 = 0L;
      if (paramBoolean) {
        l1 = 8589934592L;
      }
      this.jC.b(l2, Long.valueOf(i | l1));
      if (paramBoolean)
      {
        l2 = l(paramInt2, paramInt1);
        this.jC.b(l2, Long.valueOf(l1 | i | 0x0));
      }
      AppMethodBeat.o(199288);
      return i;
    }
    
    final void ck()
    {
      AppMethodBeat.i(199284);
      this.jC = this.jC.ll();
      this.jD = this.jD.lo();
      AppMethodBeat.o(199284);
    }
    
    final int e(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(199292);
      int i = super.f(paramArrayOfInt);
      if (i >= 0)
      {
        AppMethodBeat.o(199292);
        return i;
      }
      i = super.f(StateSet.WILD_CARD);
      AppMethodBeat.o(199292);
      return i;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(199304);
      a locala = new a(this, null);
      AppMethodBeat.o(199304);
      return locala;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(199312);
      paramResources = new a(this, paramResources);
      AppMethodBeat.o(199312);
      return paramResources;
    }
  }
  
  static final class c
    extends a.f
  {
    private final c jE;
    
    c(c paramc)
    {
      super();
      this.jE = paramc;
    }
    
    public final void start()
    {
      AppMethodBeat.i(199271);
      this.jE.start();
      AppMethodBeat.o(199271);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(199278);
      this.jE.stop();
      AppMethodBeat.o(199278);
    }
  }
  
  static abstract class f
  {
    public boolean cl()
    {
      return false;
    }
    
    public void cm() {}
    
    public abstract void start();
    
    public abstract void stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.b.a.a
 * JD-Core Version:    0.7.0.1
 */