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
  ArrayList<Object> dC = null;
  private Context mContext;
  private a uW;
  private ArgbEvaluator uX = null;
  private Animator.AnimatorListener uY = null;
  final Drawable.Callback uZ = new Drawable.Callback()
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
    this.uW = new a();
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
        if (this.uX == null) {
          this.uX = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(this.uX);
      }
    }
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    if (this.vk != null) {
      android.support.v4.graphics.drawable.a.a(this.vk, paramTheme);
    }
  }
  
  public final boolean canApplyTheme()
  {
    if (this.vk != null) {
      return android.support.v4.graphics.drawable.a.g(this.vk);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.vk != null) {
      this.vk.draw(paramCanvas);
    }
    do
    {
      return;
      this.uW.vb.draw(paramCanvas);
    } while (!this.uW.vc.isStarted());
    invalidateSelf();
  }
  
  public final int getAlpha()
  {
    if (this.vk != null) {
      return android.support.v4.graphics.drawable.a.f(this.vk);
    }
    return this.uW.vb.getAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.vk != null) {
      return this.vk.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.uW.mChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.vk != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new b(this.vk.getConstantState());
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.vk != null) {
      return this.vk.getIntrinsicHeight();
    }
    return this.uW.vb.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.vk != null) {
      return this.vk.getIntrinsicWidth();
    }
    return this.uW.vb.getIntrinsicWidth();
  }
  
  public final int getOpacity()
  {
    if (this.vk != null) {
      return this.vk.getOpacity();
    }
    return this.uW.vb.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.vk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.vk, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
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
        localObject1 = g.a(paramResources, paramTheme, paramAttributeSet, a.uO);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = i.a(paramResources, i, paramTheme);
          ((i)localObject2).vq = false;
          ((i)localObject2).setCallback(this.uZ);
          if (this.uW.vb != null) {
            this.uW.vb.setCallback(null);
          }
          this.uW.vb = ((i)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
      label182:
      while (!"target".equals(localObject1))
      {
        i = paramXmlPullParser.next();
        break;
      }
      Object localObject2 = paramResources.obtainAttributes(paramAttributeSet, a.uP);
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
        ((Animator)localObject1).setTarget(this.uW.vb.vm.wl.wk.get(str));
        if (Build.VERSION.SDK_INT < 21) {
          b((Animator)localObject1);
        }
        if (this.uW.vd == null)
        {
          this.uW.vd = new ArrayList();
          this.uW.ve = new android.support.v4.e.a();
        }
        this.uW.vd.add(localObject1);
        this.uW.ve.put(localObject1, str);
        ((TypedArray)localObject2).recycle();
        break;
      }
      label391:
      ((TypedArray)localObject2).recycle();
      throw new IllegalStateException("Context can't be null when inflating animators");
    }
    paramResources = this.uW;
    if (paramResources.vc == null) {
      paramResources.vc = new AnimatorSet();
    }
    paramResources.vc.playTogether(paramResources.vd);
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.vk != null) {
      return android.support.v4.graphics.drawable.a.e(this.vk);
    }
    return this.uW.vb.isAutoMirrored();
  }
  
  public final boolean isRunning()
  {
    if (this.vk != null) {
      return ((AnimatedVectorDrawable)this.vk).isRunning();
    }
    return this.uW.vc.isRunning();
  }
  
  public final boolean isStateful()
  {
    if (this.vk != null) {
      return this.vk.isStateful();
    }
    return this.uW.vb.isStateful();
  }
  
  public final Drawable mutate()
  {
    if (this.vk != null) {
      this.vk.mutate();
    }
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.vk != null)
    {
      this.vk.setBounds(paramRect);
      return;
    }
    this.uW.vb.setBounds(paramRect);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (this.vk != null) {
      return this.vk.setLevel(paramInt);
    }
    return this.uW.vb.setLevel(paramInt);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.vk != null) {
      return this.vk.setState(paramArrayOfInt);
    }
    return this.uW.vb.setState(paramArrayOfInt);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.vk != null)
    {
      this.vk.setAlpha(paramInt);
      return;
    }
    this.uW.vb.setAlpha(paramInt);
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.vk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.vk, paramBoolean);
      return;
    }
    this.uW.vb.setAutoMirrored(paramBoolean);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.vk != null)
    {
      this.vk.setColorFilter(paramColorFilter);
      return;
    }
    this.uW.vb.setColorFilter(paramColorFilter);
  }
  
  public final void setTint(int paramInt)
  {
    if (this.vk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.vk, paramInt);
      return;
    }
    this.uW.vb.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.vk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.vk, paramColorStateList);
      return;
    }
    this.uW.vb.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.vk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.vk, paramMode);
      return;
    }
    this.uW.vb.setTintMode(paramMode);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.vk != null) {
      return this.vk.setVisible(paramBoolean1, paramBoolean2);
    }
    this.uW.vb.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void start()
  {
    if (this.vk != null) {
      ((AnimatedVectorDrawable)this.vk).start();
    }
    while (this.uW.vc.isStarted()) {
      return;
    }
    this.uW.vc.start();
    invalidateSelf();
  }
  
  public final void stop()
  {
    if (this.vk != null)
    {
      ((AnimatedVectorDrawable)this.vk).stop();
      return;
    }
    this.uW.vc.end();
  }
  
  static final class a
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    i vb;
    AnimatorSet vc;
    ArrayList<Animator> vd;
    android.support.v4.e.a<Animator, String> ve;
    
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
    private final Drawable.ConstantState vf;
    
    public b(Drawable.ConstantState paramConstantState)
    {
      this.vf = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.vf.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.vf.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      c localc = new c();
      localc.vk = this.vf.newDrawable();
      localc.vk.setCallback(localc.uZ);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      c localc = new c();
      localc.vk = this.vf.newDrawable(paramResources);
      localc.vk.setCallback(localc.uZ);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      c localc = new c();
      localc.vk = this.vf.newDrawable(paramResources, paramTheme);
      localc.vk.setCallback(localc.uZ);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.d.a.c
 * JD-Core Version:    0.7.0.1
 */