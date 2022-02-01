package androidx.l.a.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.core.content.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public final class c
  extends h
  implements b
{
  ArrayList<b.a> byN;
  private a cin;
  private ArgbEvaluator cio;
  private Animator.AnimatorListener cip;
  final Drawable.Callback jW;
  private Context mContext;
  
  c()
  {
    this(null, (byte)0);
  }
  
  private c(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private c(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(192687);
    this.cio = null;
    this.cip = null;
    this.byN = null;
    this.jW = new Drawable.Callback()
    {
      public final void invalidateDrawable(Drawable paramAnonymousDrawable)
      {
        AppMethodBeat.i(192699);
        c.this.invalidateSelf();
        AppMethodBeat.o(192699);
      }
      
      public final void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
      {
        AppMethodBeat.i(192712);
        c.this.scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
        AppMethodBeat.o(192712);
      }
      
      public final void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(192722);
        c.this.unscheduleSelf(paramAnonymousRunnable);
        AppMethodBeat.o(192722);
      }
    };
    this.mContext = paramContext;
    this.cin = new a();
    AppMethodBeat.o(192687);
  }
  
  private void a(Animator paramAnimator)
  {
    AppMethodBeat.i(192717);
    Object localObject;
    if ((paramAnimator instanceof AnimatorSet))
    {
      localObject = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          a((Animator)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      localObject = paramAnimator.getPropertyName();
      if (("fillColor".equals(localObject)) || ("strokeColor".equals(localObject)))
      {
        if (this.cio == null) {
          this.cio = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(this.cio);
      }
    }
    AppMethodBeat.o(192717);
  }
  
  public static c d(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(192702);
    paramContext = new c(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    AppMethodBeat.o(192702);
    return paramContext;
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    AppMethodBeat.i(192949);
    if (this.cix != null)
    {
      androidx.core.graphics.drawable.a.a(this.cix, paramTheme);
      AppMethodBeat.o(192949);
      return;
    }
    AppMethodBeat.o(192949);
  }
  
  public final boolean canApplyTheme()
  {
    AppMethodBeat.i(192959);
    if (this.cix != null)
    {
      boolean bool = androidx.core.graphics.drawable.a.p(this.cix);
      AppMethodBeat.o(192959);
      return bool;
    }
    AppMethodBeat.o(192959);
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192768);
    if (this.cix != null)
    {
      this.cix.draw(paramCanvas);
      AppMethodBeat.o(192768);
      return;
    }
    this.cin.cir.draw(paramCanvas);
    if (this.cin.cis.isStarted()) {
      invalidateSelf();
    }
    AppMethodBeat.o(192768);
  }
  
  public final int getAlpha()
  {
    AppMethodBeat.i(192812);
    if (this.cix != null)
    {
      i = androidx.core.graphics.drawable.a.o(this.cix);
      AppMethodBeat.o(192812);
      return i;
    }
    int i = this.cin.cir.getAlpha();
    AppMethodBeat.o(192812);
    return i;
  }
  
  public final int getChangingConfigurations()
  {
    AppMethodBeat.i(192754);
    if (this.cix != null)
    {
      i = this.cix.getChangingConfigurations();
      AppMethodBeat.o(192754);
      return i;
    }
    int i = super.getChangingConfigurations();
    int j = this.cin.mChangingConfigurations;
    AppMethodBeat.o(192754);
    return i | j;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    AppMethodBeat.i(192740);
    if ((this.cix != null) && (Build.VERSION.SDK_INT >= 24))
    {
      b localb = new b(this.cix.getConstantState());
      AppMethodBeat.o(192740);
      return localb;
    }
    AppMethodBeat.o(192740);
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(192905);
    if (this.cix != null)
    {
      i = this.cix.getIntrinsicHeight();
      AppMethodBeat.o(192905);
      return i;
    }
    int i = this.cin.cir.getIntrinsicHeight();
    AppMethodBeat.o(192905);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(192896);
    if (this.cix != null)
    {
      i = this.cix.getIntrinsicWidth();
      AppMethodBeat.o(192896);
      return i;
    }
    int i = this.cin.cir.getIntrinsicWidth();
    AppMethodBeat.o(192896);
    return i;
  }
  
  public final int getOpacity()
  {
    AppMethodBeat.i(192885);
    if (this.cix != null)
    {
      i = this.cix.getOpacity();
      AppMethodBeat.o(192885);
      return i;
    }
    int i = this.cin.cir.getOpacity();
    AppMethodBeat.o(192885);
    return i;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(192942);
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
    AppMethodBeat.o(192942);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(192932);
    if (this.cix != null)
    {
      androidx.core.graphics.drawable.a.a(this.cix, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      AppMethodBeat.o(192932);
      return;
    }
    int i = paramXmlPullParser.getEventType();
    int j = paramXmlPullParser.getDepth();
    if ((i != 1) && ((paramXmlPullParser.getDepth() >= j + 1) || (i != 3)))
    {
      if (i == 2)
      {
        localObject1 = paramXmlPullParser.getName();
        if (!"animated-vector".equals(localObject1)) {
          break label193;
        }
        localObject1 = g.a(paramResources, paramTheme, paramAttributeSet, a.aEw);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = i.e(paramResources, i, paramTheme);
          ((i)localObject2).ciz = false;
          ((i)localObject2).setCallback(this.jW);
          if (this.cin.cir != null) {
            this.cin.cir.setCallback(null);
          }
          this.cin.cir = ((i)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
      label193:
      while (!"target".equals(localObject1))
      {
        i = paramXmlPullParser.next();
        break;
      }
      Object localObject2 = paramResources.obtainAttributes(paramAttributeSet, a.aEx);
      String str = ((TypedArray)localObject2).getString(0);
      i = ((TypedArray)localObject2).getResourceId(1, 0);
      if (i != 0)
      {
        if (this.mContext == null) {
          break label402;
        }
        localObject1 = this.mContext;
        if (Build.VERSION.SDK_INT < 24) {
          break label380;
        }
      }
      label380:
      for (Object localObject1 = AnimatorInflater.loadAnimator((Context)localObject1, i);; localObject1 = e.a((Context)localObject1, ((Context)localObject1).getResources(), ((Context)localObject1).getTheme(), i))
      {
        ((Animator)localObject1).setTarget(this.cin.cir.ciy.cjo.cjn.get(str));
        if (Build.VERSION.SDK_INT < 21) {
          a((Animator)localObject1);
        }
        if (this.cin.lB == null)
        {
          this.cin.lB = new ArrayList();
          this.cin.cit = new androidx.b.a();
        }
        this.cin.lB.add(localObject1);
        this.cin.cit.put(localObject1, str);
        ((TypedArray)localObject2).recycle();
        break;
      }
      label402:
      ((TypedArray)localObject2).recycle();
      paramResources = new IllegalStateException("Context can't be null when inflating animators");
      AppMethodBeat.o(192932);
      throw paramResources;
    }
    paramResources = this.cin;
    if (paramResources.cis == null) {
      paramResources.cis = new AnimatorSet();
    }
    paramResources.cis.playTogether(paramResources.lB);
    AppMethodBeat.o(192932);
  }
  
  public final boolean isAutoMirrored()
  {
    AppMethodBeat.i(192912);
    if (this.cix != null)
    {
      bool = androidx.core.graphics.drawable.a.n(this.cix);
      AppMethodBeat.o(192912);
      return bool;
    }
    boolean bool = this.cin.cir.isAutoMirrored();
    AppMethodBeat.o(192912);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(192971);
    if (this.cix != null)
    {
      bool = ((AnimatedVectorDrawable)this.cix).isRunning();
      AppMethodBeat.o(192971);
      return bool;
    }
    boolean bool = this.cin.cis.isRunning();
    AppMethodBeat.o(192971);
    return bool;
  }
  
  public final boolean isStateful()
  {
    AppMethodBeat.i(192873);
    if (this.cix != null)
    {
      bool = this.cix.isStateful();
      AppMethodBeat.o(192873);
      return bool;
    }
    boolean bool = this.cin.cir.isStateful();
    AppMethodBeat.o(192873);
    return bool;
  }
  
  public final Drawable mutate()
  {
    AppMethodBeat.i(192728);
    if (this.cix != null) {
      this.cix.mutate();
    }
    AppMethodBeat.o(192728);
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(192778);
    if (this.cix != null)
    {
      this.cix.setBounds(paramRect);
      AppMethodBeat.o(192778);
      return;
    }
    this.cin.cir.setBounds(paramRect);
    AppMethodBeat.o(192778);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    AppMethodBeat.i(192798);
    if (this.cix != null)
    {
      bool = this.cix.setLevel(paramInt);
      AppMethodBeat.o(192798);
      return bool;
    }
    boolean bool = this.cin.cir.setLevel(paramInt);
    AppMethodBeat.o(192798);
    return bool;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(192789);
    if (this.cix != null)
    {
      bool = this.cix.setState(paramArrayOfInt);
      AppMethodBeat.o(192789);
      return bool;
    }
    boolean bool = this.cin.cir.setState(paramArrayOfInt);
    AppMethodBeat.o(192789);
    return bool;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(192823);
    if (this.cix != null)
    {
      this.cix.setAlpha(paramInt);
      AppMethodBeat.o(192823);
      return;
    }
    this.cin.cir.setAlpha(paramInt);
    AppMethodBeat.o(192823);
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    AppMethodBeat.i(192919);
    if (this.cix != null)
    {
      androidx.core.graphics.drawable.a.b(this.cix, paramBoolean);
      AppMethodBeat.o(192919);
      return;
    }
    this.cin.cir.setAutoMirrored(paramBoolean);
    AppMethodBeat.o(192919);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(192835);
    if (this.cix != null)
    {
      this.cix.setColorFilter(paramColorFilter);
      AppMethodBeat.o(192835);
      return;
    }
    this.cin.cir.setColorFilter(paramColorFilter);
    AppMethodBeat.o(192835);
  }
  
  public final void setTint(int paramInt)
  {
    AppMethodBeat.i(192844);
    if (this.cix != null)
    {
      androidx.core.graphics.drawable.a.a(this.cix, paramInt);
      AppMethodBeat.o(192844);
      return;
    }
    this.cin.cir.setTint(paramInt);
    AppMethodBeat.o(192844);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(192851);
    if (this.cix != null)
    {
      androidx.core.graphics.drawable.a.a(this.cix, paramColorStateList);
      AppMethodBeat.o(192851);
      return;
    }
    this.cin.cir.setTintList(paramColorStateList);
    AppMethodBeat.o(192851);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(192858);
    if (this.cix != null)
    {
      androidx.core.graphics.drawable.a.a(this.cix, paramMode);
      AppMethodBeat.o(192858);
      return;
    }
    this.cin.cir.setTintMode(paramMode);
    AppMethodBeat.o(192858);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192866);
    if (this.cix != null)
    {
      paramBoolean1 = this.cix.setVisible(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(192866);
      return paramBoolean1;
    }
    this.cin.cir.setVisible(paramBoolean1, paramBoolean2);
    paramBoolean1 = super.setVisible(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(192866);
    return paramBoolean1;
  }
  
  public final void start()
  {
    AppMethodBeat.i(192980);
    if (this.cix != null)
    {
      ((AnimatedVectorDrawable)this.cix).start();
      AppMethodBeat.o(192980);
      return;
    }
    if (this.cin.cis.isStarted())
    {
      AppMethodBeat.o(192980);
      return;
    }
    this.cin.cis.start();
    invalidateSelf();
    AppMethodBeat.o(192980);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(192987);
    if (this.cix != null)
    {
      ((AnimatedVectorDrawable)this.cix).stop();
      AppMethodBeat.o(192987);
      return;
    }
    this.cin.cis.end();
    AppMethodBeat.o(192987);
  }
  
  static final class a
    extends Drawable.ConstantState
  {
    i cir;
    AnimatorSet cis;
    androidx.b.a<Animator, String> cit;
    ArrayList<Animator> lB;
    int mChangingConfigurations;
    
    public final int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(192700);
      IllegalStateException localIllegalStateException = new IllegalStateException("No constant state support for SDK < 24.");
      AppMethodBeat.o(192700);
      throw localIllegalStateException;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(192713);
      paramResources = new IllegalStateException("No constant state support for SDK < 24.");
      AppMethodBeat.o(192713);
      throw paramResources;
    }
  }
  
  static final class b
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState ciu;
    
    public b(Drawable.ConstantState paramConstantState)
    {
      this.ciu = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      AppMethodBeat.i(192729);
      boolean bool = this.ciu.canApplyTheme();
      AppMethodBeat.o(192729);
      return bool;
    }
    
    public final int getChangingConfigurations()
    {
      AppMethodBeat.i(192741);
      int i = this.ciu.getChangingConfigurations();
      AppMethodBeat.o(192741);
      return i;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(192696);
      c localc = new c();
      localc.cix = this.ciu.newDrawable();
      localc.cix.setCallback(localc.jW);
      AppMethodBeat.o(192696);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(192709);
      c localc = new c();
      localc.cix = this.ciu.newDrawable(paramResources);
      localc.cix.setCallback(localc.jW);
      AppMethodBeat.o(192709);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(192720);
      c localc = new c();
      localc.cix = this.ciu.newDrawable(paramResources, paramTheme);
      localc.cix.setCallback(localc.jW);
      AppMethodBeat.o(192720);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.l.a.a.c
 * JD-Core Version:    0.7.0.1
 */