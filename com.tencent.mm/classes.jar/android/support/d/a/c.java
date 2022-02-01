package android.support.d.a;

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
  ArrayList<Object> fy = null;
  private Context mContext;
  private a wW;
  private ArgbEvaluator wX = null;
  private Animator.AnimatorListener wY = null;
  final Drawable.Callback wZ = new Drawable.Callback()
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
    this.wW = new a();
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
        if (this.wX == null) {
          this.wX = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(this.wX);
      }
    }
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    if (this.xk != null) {
      android.support.v4.graphics.drawable.a.a(this.xk, paramTheme);
    }
  }
  
  public final boolean canApplyTheme()
  {
    if (this.xk != null) {
      return android.support.v4.graphics.drawable.a.g(this.xk);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.xk != null) {
      this.xk.draw(paramCanvas);
    }
    do
    {
      return;
      this.wW.xb.draw(paramCanvas);
    } while (!this.wW.xc.isStarted());
    invalidateSelf();
  }
  
  public final int getAlpha()
  {
    if (this.xk != null) {
      return android.support.v4.graphics.drawable.a.f(this.xk);
    }
    return this.wW.xb.getAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.xk != null) {
      return this.xk.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.wW.mChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.xk != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new b(this.xk.getConstantState());
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.xk != null) {
      return this.xk.getIntrinsicHeight();
    }
    return this.wW.xb.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.xk != null) {
      return this.xk.getIntrinsicWidth();
    }
    return this.wW.xb.getIntrinsicWidth();
  }
  
  public final int getOpacity()
  {
    if (this.xk != null) {
      return this.xk.getOpacity();
    }
    return this.wW.xb.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.xk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xk, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
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
        localObject1 = g.a(paramResources, paramTheme, paramAttributeSet, a.wO);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = i.a(paramResources, i, paramTheme);
          ((i)localObject2).xq = false;
          ((i)localObject2).setCallback(this.wZ);
          if (this.wW.xb != null) {
            this.wW.xb.setCallback(null);
          }
          this.wW.xb = ((i)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
      label182:
      while (!"target".equals(localObject1))
      {
        i = paramXmlPullParser.next();
        break;
      }
      Object localObject2 = paramResources.obtainAttributes(paramAttributeSet, a.wP);
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
        ((Animator)localObject1).setTarget(this.wW.xb.xm.yj.yi.get(str));
        if (Build.VERSION.SDK_INT < 21) {
          b((Animator)localObject1);
        }
        if (this.wW.xd == null)
        {
          this.wW.xd = new ArrayList();
          this.wW.xe = new android.support.v4.e.a();
        }
        this.wW.xd.add(localObject1);
        this.wW.xe.put(localObject1, str);
        ((TypedArray)localObject2).recycle();
        break;
      }
      label391:
      ((TypedArray)localObject2).recycle();
      throw new IllegalStateException("Context can't be null when inflating animators");
    }
    paramResources = this.wW;
    if (paramResources.xc == null) {
      paramResources.xc = new AnimatorSet();
    }
    paramResources.xc.playTogether(paramResources.xd);
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.xk != null) {
      return android.support.v4.graphics.drawable.a.e(this.xk);
    }
    return this.wW.xb.isAutoMirrored();
  }
  
  public final boolean isRunning()
  {
    if (this.xk != null) {
      return ((AnimatedVectorDrawable)this.xk).isRunning();
    }
    return this.wW.xc.isRunning();
  }
  
  public final boolean isStateful()
  {
    if (this.xk != null) {
      return this.xk.isStateful();
    }
    return this.wW.xb.isStateful();
  }
  
  public final Drawable mutate()
  {
    if (this.xk != null) {
      this.xk.mutate();
    }
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.xk != null)
    {
      this.xk.setBounds(paramRect);
      return;
    }
    this.wW.xb.setBounds(paramRect);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (this.xk != null) {
      return this.xk.setLevel(paramInt);
    }
    return this.wW.xb.setLevel(paramInt);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.xk != null) {
      return this.xk.setState(paramArrayOfInt);
    }
    return this.wW.xb.setState(paramArrayOfInt);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.xk != null)
    {
      this.xk.setAlpha(paramInt);
      return;
    }
    this.wW.xb.setAlpha(paramInt);
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.xk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xk, paramBoolean);
      return;
    }
    this.wW.xb.setAutoMirrored(paramBoolean);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.xk != null)
    {
      this.xk.setColorFilter(paramColorFilter);
      return;
    }
    this.wW.xb.setColorFilter(paramColorFilter);
  }
  
  public final void setTint(int paramInt)
  {
    if (this.xk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xk, paramInt);
      return;
    }
    this.wW.xb.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.xk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xk, paramColorStateList);
      return;
    }
    this.wW.xb.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.xk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xk, paramMode);
      return;
    }
    this.wW.xb.setTintMode(paramMode);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.xk != null) {
      return this.xk.setVisible(paramBoolean1, paramBoolean2);
    }
    this.wW.xb.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void start()
  {
    if (this.xk != null) {
      ((AnimatedVectorDrawable)this.xk).start();
    }
    while (this.wW.xc.isStarted()) {
      return;
    }
    this.wW.xc.start();
    invalidateSelf();
  }
  
  public final void stop()
  {
    if (this.xk != null)
    {
      ((AnimatedVectorDrawable)this.xk).stop();
      return;
    }
    this.wW.xc.end();
  }
  
  static final class a
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    i xb;
    AnimatorSet xc;
    ArrayList<Animator> xd;
    android.support.v4.e.a<Animator, String> xe;
    
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
    private final Drawable.ConstantState xf;
    
    public b(Drawable.ConstantState paramConstantState)
    {
      this.xf = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.xf.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.xf.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      c localc = new c();
      localc.xk = this.xf.newDrawable();
      localc.xk.setCallback(localc.wZ);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      c localc = new c();
      localc.xk = this.xf.newDrawable(paramResources);
      localc.xk.setCallback(localc.wZ);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      c localc = new c();
      localc.xk = this.xf.newDrawable(paramResources, paramTheme);
      localc.xk.setCallback(localc.wZ);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.d.a.c
 * JD-Core Version:    0.7.0.1
 */