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
import androidx.k.a.a.c;
import androidx.k.a.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a
  extends d
{
  private static final String LOGTAG;
  private b iB;
  private f iC;
  private int iD;
  private int iE;
  private boolean iF;
  
  static
  {
    AppMethodBeat.i(238724);
    LOGTAG = a.class.getSimpleName();
    AppMethodBeat.o(238724);
  }
  
  public a()
  {
    this(null, null);
  }
  
  a(b paramb, Resources paramResources)
  {
    super((byte)0);
    AppMethodBeat.i(238667);
    this.iD = -1;
    this.iE = -1;
    a(new b(paramb, this, paramResources));
    onStateChange(getState());
    jumpToCurrentState();
    AppMethodBeat.o(238667);
  }
  
  public static a a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(238669);
    Object localObject = paramXmlPullParser.getName();
    if (!((String)localObject).equals("animated-selector"))
    {
      paramContext = new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + (String)localObject);
      AppMethodBeat.o(238669);
      throw paramContext;
    }
    localObject = new a();
    TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.j.AnimatedStateListDrawableCompat);
    ((a)localObject).setVisible(localTypedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_visible, true), true);
    b localb = ((a)localObject).iB;
    if (Build.VERSION.SDK_INT >= 21) {
      localb.mChangingConfigurations |= localTypedArray.getChangingConfigurations();
    }
    localb.jj = localTypedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_variablePadding, localb.jj);
    localb.jm = localTypedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_constantSize, localb.jm);
    localb.jz = localTypedArray.getInt(a.j.AnimatedStateListDrawableCompat_android_enterFadeDuration, localb.jz);
    localb.jA = localTypedArray.getInt(a.j.AnimatedStateListDrawableCompat_android_exitFadeDuration, localb.jA);
    ((a)localObject).setDither(localTypedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_dither, localb.jy));
    ((a)localObject).e(paramResources);
    localTypedArray.recycle();
    ((a)localObject).b(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    ((a)localObject).onStateChange(((a)localObject).getState());
    AppMethodBeat.o(238669);
    return localObject;
  }
  
  private void b(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(238677);
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
              AppMethodBeat.o(238677);
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
            AppMethodBeat.o(238677);
            throw paramContext;
            label406:
            if (Build.VERSION.SDK_INT >= 21) {
              localObject1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
            } else {
              localObject1 = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
            }
          }
          localObject2 = this.iB;
          i = ((d.a)localObject2).b((Drawable)localObject1);
          ((d.a)localObject2).jJ[i] = arrayOfInt;
          ((b)localObject2).iI.put(i, Integer.valueOf(n));
        }
        else if (paramXmlPullParser.getName().equals("transition"))
        {
          c(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        }
      }
    }
    AppMethodBeat.o(238677);
  }
  
  private b bo()
  {
    AppMethodBeat.i(238680);
    b localb = new b(this.iB, this, null);
    AppMethodBeat.o(238680);
    return localb;
  }
  
  private int c(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(238678);
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
        AppMethodBeat.o(238678);
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
      AppMethodBeat.o(238678);
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
      AppMethodBeat.o(238678);
      throw paramContext;
    }
    i = this.iB.a(i, j, (Drawable)localObject, bool);
    AppMethodBeat.o(238678);
    return i;
  }
  
  protected final void a(b.b paramb)
  {
    AppMethodBeat.i(238683);
    super.a(paramb);
    if ((paramb instanceof b)) {
      this.iB = ((b)paramb);
    }
    AppMethodBeat.o(238683);
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public void jumpToCurrentState()
  {
    AppMethodBeat.i(238672);
    super.jumpToCurrentState();
    if (this.iC != null)
    {
      this.iC.stop();
      this.iC = null;
      Z(this.iD);
      this.iD = -1;
      this.iE = -1;
    }
    AppMethodBeat.o(238672);
  }
  
  public Drawable mutate()
  {
    AppMethodBeat.i(238679);
    if ((!this.iF) && (super.mutate() == this))
    {
      this.iB.br();
      this.iF = true;
    }
    AppMethodBeat.o(238679);
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(238674);
    int j = this.iB.b(paramArrayOfInt);
    Object localObject;
    int i;
    if (j != getCurrentIndex())
    {
      localObject = this.iC;
      if (localObject != null) {
        if (j == this.iD)
        {
          i = 1;
          if ((i == 0) && (!Z(j))) {
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
      AppMethodBeat.o(238674);
      return bool2;
      if ((j == this.iE) && (((f)localObject).bs()))
      {
        ((f)localObject).bt();
        this.iD = this.iE;
        this.iE = j;
        i = 1;
        break;
      }
      i = this.iD;
      ((f)localObject).stop();
      int k;
      int m;
      for (;;)
      {
        this.iC = null;
        this.iE = -1;
        this.iD = -1;
        localObject = this.iB;
        k = ((b)localObject).Y(i);
        m = ((b)localObject).Y(j);
        if ((m != 0) && (k != 0)) {
          break label203;
        }
        i = 0;
        break;
        i = getCurrentIndex();
      }
      long l = b.g(k, m);
      int n = (int)((Long)((b)localObject).iH.get(l, Long.valueOf(-1L))).longValue();
      if (n < 0)
      {
        i = 0;
        break;
      }
      l = b.g(k, m);
      Drawable localDrawable;
      if ((((Long)((b)localObject).iH.get(l, Long.valueOf(-1L))).longValue() & 0x0) != 0L)
      {
        bool1 = true;
        Z(n);
        localDrawable = getCurrent();
        if (!(localDrawable instanceof AnimationDrawable)) {
          break label410;
        }
        l = b.g(k, m);
        if ((((Long)((b)localObject).iH.get(l, Long.valueOf(-1L))).longValue() & 0x0) == 0L) {
          break label404;
        }
        bool2 = true;
        label354:
        localObject = new a.d((AnimationDrawable)localDrawable, bool2, bool1);
      }
      for (;;)
      {
        ((f)localObject).start();
        this.iC = ((f)localObject);
        this.iE = i;
        this.iD = j;
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
    AppMethodBeat.i(238670);
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if ((this.iC != null) && ((bool) || (paramBoolean2)))
    {
      if (!paramBoolean1) {
        break label47;
      }
      this.iC.start();
    }
    for (;;)
    {
      AppMethodBeat.o(238670);
      return bool;
      label47:
      jumpToCurrentState();
    }
  }
  
  static final class b
    extends d.a
  {
    androidx.b.d<Long> iH;
    h<Integer> iI;
    
    b(b paramb, a parama, Resources paramResources)
    {
      super(parama, paramResources);
      AppMethodBeat.i(238635);
      if (paramb != null)
      {
        this.iH = paramb.iH;
        this.iI = paramb.iI;
        AppMethodBeat.o(238635);
        return;
      }
      this.iH = new androidx.b.d();
      this.iI = new h();
      AppMethodBeat.o(238635);
    }
    
    static long g(int paramInt1, int paramInt2)
    {
      return paramInt1 << 32 | paramInt2;
    }
    
    final int Y(int paramInt)
    {
      AppMethodBeat.i(238642);
      if (paramInt < 0)
      {
        AppMethodBeat.o(238642);
        return 0;
      }
      paramInt = ((Integer)this.iI.b(paramInt, Integer.valueOf(0))).intValue();
      AppMethodBeat.o(238642);
      return paramInt;
    }
    
    final int a(int paramInt1, int paramInt2, Drawable paramDrawable, boolean paramBoolean)
    {
      AppMethodBeat.i(238638);
      int i = super.b(paramDrawable);
      long l2 = g(paramInt1, paramInt2);
      long l1 = 0L;
      if (paramBoolean) {
        l1 = 8589934592L;
      }
      this.iH.b(l2, Long.valueOf(i | l1));
      if (paramBoolean)
      {
        l2 = g(paramInt2, paramInt1);
        this.iH.b(l2, Long.valueOf(l1 | i | 0x0));
      }
      AppMethodBeat.o(238638);
      return i;
    }
    
    final int b(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(238639);
      int i = super.c(paramArrayOfInt);
      if (i >= 0)
      {
        AppMethodBeat.o(238639);
        return i;
      }
      i = super.c(StateSet.WILD_CARD);
      AppMethodBeat.o(238639);
      return i;
    }
    
    final void br()
    {
      AppMethodBeat.i(238636);
      this.iH = this.iH.fe();
      this.iI = this.iI.fg();
      AppMethodBeat.o(238636);
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(238643);
      a locala = new a(this, null);
      AppMethodBeat.o(238643);
      return locala;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(238644);
      paramResources = new a(this, paramResources);
      AppMethodBeat.o(238644);
      return paramResources;
    }
  }
  
  static final class c
    extends a.f
  {
    private final c iJ;
    
    c(c paramc)
    {
      super();
      this.iJ = paramc;
    }
    
    public final void start()
    {
      AppMethodBeat.i(238648);
      this.iJ.start();
      AppMethodBeat.o(238648);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(238649);
      this.iJ.stop();
      AppMethodBeat.o(238649);
    }
  }
  
  static abstract class f
  {
    public boolean bs()
    {
      return false;
    }
    
    public void bt() {}
    
    public abstract void start();
    
    public abstract void stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.b.a.a
 * JD-Core Version:    0.7.0.1
 */