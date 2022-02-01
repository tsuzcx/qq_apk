package android.support.c.a;

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
import android.support.v4.content.a.g;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public final class c
  extends h
  implements b
{
  private Context mContext;
  private a tV;
  private ArgbEvaluator tW = null;
  private Animator.AnimatorListener tX = null;
  ArrayList<Object> tY = null;
  final Drawable.Callback tZ = new Drawable.Callback()
  {
    public final void invalidateDrawable(Drawable paramAnonymousDrawable)
    {
      c.this.invalidateSelf();
    }
    
    public final void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
    {
      c.this.scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
    }
    
    public final void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
    {
      c.this.unscheduleSelf(paramAnonymousRunnable);
    }
  };
  
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
    this.mContext = paramContext;
    this.tV = new a();
  }
  
  public static c a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    paramContext = new c(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return paramContext;
  }
  
  private void b(Animator paramAnimator)
  {
    Object localObject;
    if ((paramAnimator instanceof AnimatorSet))
    {
      localObject = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          b((Animator)((List)localObject).get(i));
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
        if (this.tW == null) {
          this.tW = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(this.tW);
      }
    }
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    if (this.ul != null) {
      android.support.v4.graphics.drawable.a.a(this.ul, paramTheme);
    }
  }
  
  public final boolean canApplyTheme()
  {
    if (this.ul != null) {
      return android.support.v4.graphics.drawable.a.g(this.ul);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.ul != null) {
      this.ul.draw(paramCanvas);
    }
    do
    {
      return;
      this.tV.ub.draw(paramCanvas);
    } while (!this.tV.uc.isStarted());
    invalidateSelf();
  }
  
  public final int getAlpha()
  {
    if (this.ul != null) {
      return android.support.v4.graphics.drawable.a.f(this.ul);
    }
    return this.tV.ub.getAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.ul != null) {
      return this.ul.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.tV.mChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.ul != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new b(this.ul.getConstantState());
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.ul != null) {
      return this.ul.getIntrinsicHeight();
    }
    return this.tV.ub.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.ul != null) {
      return this.ul.getIntrinsicWidth();
    }
    return this.tV.ub.getIntrinsicWidth();
  }
  
  public final int getOpacity()
  {
    if (this.ul != null) {
      return this.ul.getOpacity();
    }
    return this.tV.ub.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.ul != null)
    {
      android.support.v4.graphics.drawable.a.a(this.ul, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
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
          break label182;
        }
        localObject1 = g.a(paramResources, paramTheme, paramAttributeSet, a.tN);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = i.a(paramResources, i, paramTheme);
          ((i)localObject2).ur = false;
          ((i)localObject2).setCallback(this.tZ);
          if (this.tV.ub != null) {
            this.tV.ub.setCallback(null);
          }
          this.tV.ub = ((i)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
      label182:
      while (!"target".equals(localObject1))
      {
        i = paramXmlPullParser.next();
        break;
      }
      Object localObject2 = paramResources.obtainAttributes(paramAttributeSet, a.tO);
      String str = ((TypedArray)localObject2).getString(0);
      i = ((TypedArray)localObject2).getResourceId(1, 0);
      if (i != 0)
      {
        if (this.mContext == null) {
          break label391;
        }
        localObject1 = this.mContext;
        if (Build.VERSION.SDK_INT < 24) {
          break label369;
        }
      }
      label369:
      for (Object localObject1 = AnimatorInflater.loadAnimator((Context)localObject1, i);; localObject1 = e.a((Context)localObject1, ((Context)localObject1).getResources(), ((Context)localObject1).getTheme(), i))
      {
        ((Animator)localObject1).setTarget(this.tV.ub.un.vm.vl.get(str));
        if (Build.VERSION.SDK_INT < 21) {
          b((Animator)localObject1);
        }
        if (this.tV.ud == null)
        {
          this.tV.ud = new ArrayList();
          this.tV.ue = new android.support.v4.e.a();
        }
        this.tV.ud.add(localObject1);
        this.tV.ue.put(localObject1, str);
        ((TypedArray)localObject2).recycle();
        break;
      }
      label391:
      ((TypedArray)localObject2).recycle();
      throw new IllegalStateException("Context can't be null when inflating animators");
    }
    paramResources = this.tV;
    if (paramResources.uc == null) {
      paramResources.uc = new AnimatorSet();
    }
    paramResources.uc.playTogether(paramResources.ud);
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.ul != null) {
      return android.support.v4.graphics.drawable.a.e(this.ul);
    }
    return this.tV.ub.isAutoMirrored();
  }
  
  public final boolean isRunning()
  {
    if (this.ul != null) {
      return ((AnimatedVectorDrawable)this.ul).isRunning();
    }
    return this.tV.uc.isRunning();
  }
  
  public final boolean isStateful()
  {
    if (this.ul != null) {
      return this.ul.isStateful();
    }
    return this.tV.ub.isStateful();
  }
  
  public final Drawable mutate()
  {
    if (this.ul != null) {
      this.ul.mutate();
    }
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.ul != null)
    {
      this.ul.setBounds(paramRect);
      return;
    }
    this.tV.ub.setBounds(paramRect);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (this.ul != null) {
      return this.ul.setLevel(paramInt);
    }
    return this.tV.ub.setLevel(paramInt);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.ul != null) {
      return this.ul.setState(paramArrayOfInt);
    }
    return this.tV.ub.setState(paramArrayOfInt);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.ul != null)
    {
      this.ul.setAlpha(paramInt);
      return;
    }
    this.tV.ub.setAlpha(paramInt);
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.ul != null)
    {
      android.support.v4.graphics.drawable.a.a(this.ul, paramBoolean);
      return;
    }
    this.tV.ub.setAutoMirrored(paramBoolean);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.ul != null)
    {
      this.ul.setColorFilter(paramColorFilter);
      return;
    }
    this.tV.ub.setColorFilter(paramColorFilter);
  }
  
  public final void setTint(int paramInt)
  {
    if (this.ul != null)
    {
      android.support.v4.graphics.drawable.a.a(this.ul, paramInt);
      return;
    }
    this.tV.ub.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.ul != null)
    {
      android.support.v4.graphics.drawable.a.a(this.ul, paramColorStateList);
      return;
    }
    this.tV.ub.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ul != null)
    {
      android.support.v4.graphics.drawable.a.a(this.ul, paramMode);
      return;
    }
    this.tV.ub.setTintMode(paramMode);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.ul != null) {
      return this.ul.setVisible(paramBoolean1, paramBoolean2);
    }
    this.tV.ub.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void start()
  {
    if (this.ul != null) {
      ((AnimatedVectorDrawable)this.ul).start();
    }
    while (this.tV.uc.isStarted()) {
      return;
    }
    this.tV.uc.start();
    invalidateSelf();
  }
  
  public final void stop()
  {
    if (this.ul != null)
    {
      ((AnimatedVectorDrawable)this.ul).stop();
      return;
    }
    this.tV.uc.end();
  }
  
  static final class a
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    i ub;
    AnimatorSet uc;
    ArrayList<Animator> ud;
    android.support.v4.e.a<Animator, String> ue;
    
    public final int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public final Drawable newDrawable()
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
  }
  
  static final class b
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState uf;
    
    public b(Drawable.ConstantState paramConstantState)
    {
      this.uf = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.uf.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.uf.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      c localc = new c();
      localc.ul = this.uf.newDrawable();
      localc.ul.setCallback(localc.tZ);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      c localc = new c();
      localc.ul = this.uf.newDrawable(paramResources);
      localc.ul.setCallback(localc.tZ);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      c localc = new c();
      localc.ul = this.uf.newDrawable(paramResources, paramTheme);
      localc.ul.setCallback(localc.tZ);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.c.a.c
 * JD-Core Version:    0.7.0.1
 */