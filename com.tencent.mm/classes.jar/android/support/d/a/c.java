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
  ArrayList<Object> fw = null;
  private Context mContext;
  private a wP;
  private ArgbEvaluator wQ = null;
  private Animator.AnimatorListener wR = null;
  final Drawable.Callback wS = new Drawable.Callback()
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
    this.wP = new a();
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
        if (this.wQ == null) {
          this.wQ = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(this.wQ);
      }
    }
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    if (this.xd != null) {
      android.support.v4.graphics.drawable.a.a(this.xd, paramTheme);
    }
  }
  
  public final boolean canApplyTheme()
  {
    if (this.xd != null) {
      return android.support.v4.graphics.drawable.a.g(this.xd);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.xd != null) {
      this.xd.draw(paramCanvas);
    }
    do
    {
      return;
      this.wP.wU.draw(paramCanvas);
    } while (!this.wP.wV.isStarted());
    invalidateSelf();
  }
  
  public final int getAlpha()
  {
    if (this.xd != null) {
      return android.support.v4.graphics.drawable.a.f(this.xd);
    }
    return this.wP.wU.getAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.xd != null) {
      return this.xd.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.wP.mChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.xd != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new b(this.xd.getConstantState());
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.xd != null) {
      return this.xd.getIntrinsicHeight();
    }
    return this.wP.wU.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.xd != null) {
      return this.xd.getIntrinsicWidth();
    }
    return this.wP.wU.getIntrinsicWidth();
  }
  
  public final int getOpacity()
  {
    if (this.xd != null) {
      return this.xd.getOpacity();
    }
    return this.wP.wU.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.xd != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xd, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
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
        localObject1 = g.a(paramResources, paramTheme, paramAttributeSet, a.wH);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = i.a(paramResources, i, paramTheme);
          ((i)localObject2).xj = false;
          ((i)localObject2).setCallback(this.wS);
          if (this.wP.wU != null) {
            this.wP.wU.setCallback(null);
          }
          this.wP.wU = ((i)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
      label182:
      while (!"target".equals(localObject1))
      {
        i = paramXmlPullParser.next();
        break;
      }
      Object localObject2 = paramResources.obtainAttributes(paramAttributeSet, a.wI);
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
        ((Animator)localObject1).setTarget(this.wP.wU.xf.yd.yc.get(str));
        if (Build.VERSION.SDK_INT < 21) {
          b((Animator)localObject1);
        }
        if (this.wP.wW == null)
        {
          this.wP.wW = new ArrayList();
          this.wP.wX = new android.support.v4.e.a();
        }
        this.wP.wW.add(localObject1);
        this.wP.wX.put(localObject1, str);
        ((TypedArray)localObject2).recycle();
        break;
      }
      label391:
      ((TypedArray)localObject2).recycle();
      throw new IllegalStateException("Context can't be null when inflating animators");
    }
    paramResources = this.wP;
    if (paramResources.wV == null) {
      paramResources.wV = new AnimatorSet();
    }
    paramResources.wV.playTogether(paramResources.wW);
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.xd != null) {
      return android.support.v4.graphics.drawable.a.e(this.xd);
    }
    return this.wP.wU.isAutoMirrored();
  }
  
  public final boolean isRunning()
  {
    if (this.xd != null) {
      return ((AnimatedVectorDrawable)this.xd).isRunning();
    }
    return this.wP.wV.isRunning();
  }
  
  public final boolean isStateful()
  {
    if (this.xd != null) {
      return this.xd.isStateful();
    }
    return this.wP.wU.isStateful();
  }
  
  public final Drawable mutate()
  {
    if (this.xd != null) {
      this.xd.mutate();
    }
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.xd != null)
    {
      this.xd.setBounds(paramRect);
      return;
    }
    this.wP.wU.setBounds(paramRect);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (this.xd != null) {
      return this.xd.setLevel(paramInt);
    }
    return this.wP.wU.setLevel(paramInt);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.xd != null) {
      return this.xd.setState(paramArrayOfInt);
    }
    return this.wP.wU.setState(paramArrayOfInt);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.xd != null)
    {
      this.xd.setAlpha(paramInt);
      return;
    }
    this.wP.wU.setAlpha(paramInt);
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.xd != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xd, paramBoolean);
      return;
    }
    this.wP.wU.setAutoMirrored(paramBoolean);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.xd != null)
    {
      this.xd.setColorFilter(paramColorFilter);
      return;
    }
    this.wP.wU.setColorFilter(paramColorFilter);
  }
  
  public final void setTint(int paramInt)
  {
    if (this.xd != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xd, paramInt);
      return;
    }
    this.wP.wU.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.xd != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xd, paramColorStateList);
      return;
    }
    this.wP.wU.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.xd != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xd, paramMode);
      return;
    }
    this.wP.wU.setTintMode(paramMode);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.xd != null) {
      return this.xd.setVisible(paramBoolean1, paramBoolean2);
    }
    this.wP.wU.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void start()
  {
    if (this.xd != null) {
      ((AnimatedVectorDrawable)this.xd).start();
    }
    while (this.wP.wV.isStarted()) {
      return;
    }
    this.wP.wV.start();
    invalidateSelf();
  }
  
  public final void stop()
  {
    if (this.xd != null)
    {
      ((AnimatedVectorDrawable)this.xd).stop();
      return;
    }
    this.wP.wV.end();
  }
  
  static final class a
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    i wU;
    AnimatorSet wV;
    ArrayList<Animator> wW;
    android.support.v4.e.a<Animator, String> wX;
    
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
    private final Drawable.ConstantState wY;
    
    public b(Drawable.ConstantState paramConstantState)
    {
      this.wY = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.wY.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.wY.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      c localc = new c();
      localc.xd = this.wY.newDrawable();
      localc.xd.setCallback(localc.wS);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      c localc = new c();
      localc.xd = this.wY.newDrawable(paramResources);
      localc.xd.setCallback(localc.wS);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      c localc = new c();
      localc.xd = this.wY.newDrawable(paramResources, paramTheme);
      localc.xd.setCallback(localc.wS);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.d.a.c
 * JD-Core Version:    0.7.0.1
 */