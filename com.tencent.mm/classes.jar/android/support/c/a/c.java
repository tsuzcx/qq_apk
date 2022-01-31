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
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public final class c
  extends h
  implements b
{
  private Animator.AnimatorListener mA = null;
  private ArrayList<Object> mB = null;
  final Drawable.Callback mC = new Drawable.Callback()
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
  private Context mContext;
  private a my;
  private ArgbEvaluator mz = null;
  
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
    this.my = new a();
  }
  
  public static c a(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    paramContext = new c(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return paramContext;
  }
  
  private void a(Animator paramAnimator)
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
        if (this.mz == null) {
          this.mz = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(this.mz);
      }
    }
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    if (this.mN != null) {
      android.support.v4.a.a.a.a(this.mN, paramTheme);
    }
  }
  
  public final boolean canApplyTheme()
  {
    if (this.mN != null) {
      return android.support.v4.a.a.a.d(this.mN);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.mN != null) {
      this.mN.draw(paramCanvas);
    }
    do
    {
      return;
      this.my.mE.draw(paramCanvas);
    } while (!this.my.mF.isStarted());
    invalidateSelf();
  }
  
  public final int getAlpha()
  {
    if (this.mN != null) {
      return android.support.v4.a.a.a.c(this.mN);
    }
    return this.my.mE.getAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.mN != null) {
      return this.mN.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.my.mChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.mN != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new b(this.mN.getConstantState());
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.mN != null) {
      return this.mN.getIntrinsicHeight();
    }
    return this.my.mE.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.mN != null) {
      return this.mN.getIntrinsicWidth();
    }
    return this.my.mE.getIntrinsicWidth();
  }
  
  public final int getOpacity()
  {
    if (this.mN != null) {
      return this.mN.getOpacity();
    }
    return this.my.mE.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.mN != null)
    {
      android.support.v4.a.a.a.a(this.mN, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
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
        localObject1 = android.support.v4.content.a.c.a(paramResources, paramTheme, paramAttributeSet, a.mq);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = i.a(paramResources, i, paramTheme);
          ((i)localObject2).mT = false;
          ((i)localObject2).setCallback(this.mC);
          if (this.my.mE != null) {
            this.my.mE.setCallback(null);
          }
          this.my.mE = ((i)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
      label182:
      while (!"target".equals(localObject1))
      {
        i = paramXmlPullParser.next();
        break;
      }
      Object localObject2 = paramResources.obtainAttributes(paramAttributeSet, a.mr);
      String str = ((TypedArray)localObject2).getString(0);
      i = ((TypedArray)localObject2).getResourceId(1, 0);
      if (i != 0)
      {
        if (this.mContext == null) {
          break label392;
        }
        localObject1 = this.mContext;
        if (Build.VERSION.SDK_INT < 24) {
          break label370;
        }
      }
      label370:
      for (Object localObject1 = AnimatorInflater.loadAnimator((Context)localObject1, i);; localObject1 = e.a((Context)localObject1, ((Context)localObject1).getResources(), ((Context)localObject1).getTheme(), i))
      {
        ((Animator)localObject1).setTarget(this.my.mE.mP.nL.nK.get(str));
        if (Build.VERSION.SDK_INT < 21) {
          a((Animator)localObject1);
        }
        if (a.a(this.my) == null)
        {
          a.a(this.my, new ArrayList());
          this.my.mH = new android.support.v4.f.a();
        }
        a.a(this.my).add(localObject1);
        this.my.mH.put(localObject1, str);
        ((TypedArray)localObject2).recycle();
        break;
      }
      label392:
      ((TypedArray)localObject2).recycle();
      throw new IllegalStateException("Context can't be null when inflating animators");
    }
    paramResources = this.my;
    if (paramResources.mF == null) {
      paramResources.mF = new AnimatorSet();
    }
    paramResources.mF.playTogether(paramResources.mG);
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.mN != null) {
      return android.support.v4.a.a.a.b(this.mN);
    }
    return this.my.mE.isAutoMirrored();
  }
  
  public final boolean isRunning()
  {
    if (this.mN != null) {
      return ((AnimatedVectorDrawable)this.mN).isRunning();
    }
    return this.my.mF.isRunning();
  }
  
  public final boolean isStateful()
  {
    if (this.mN != null) {
      return this.mN.isStateful();
    }
    return this.my.mE.isStateful();
  }
  
  public final Drawable mutate()
  {
    if (this.mN != null) {
      this.mN.mutate();
    }
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.mN != null)
    {
      this.mN.setBounds(paramRect);
      return;
    }
    this.my.mE.setBounds(paramRect);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (this.mN != null) {
      return this.mN.setLevel(paramInt);
    }
    return this.my.mE.setLevel(paramInt);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mN != null) {
      return this.mN.setState(paramArrayOfInt);
    }
    return this.my.mE.setState(paramArrayOfInt);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.mN != null)
    {
      this.mN.setAlpha(paramInt);
      return;
    }
    this.my.mE.setAlpha(paramInt);
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.mN != null)
    {
      android.support.v4.a.a.a.a(this.mN, paramBoolean);
      return;
    }
    this.my.mE.setAutoMirrored(paramBoolean);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mN != null)
    {
      this.mN.setColorFilter(paramColorFilter);
      return;
    }
    this.my.mE.setColorFilter(paramColorFilter);
  }
  
  public final void setTint(int paramInt)
  {
    if (this.mN != null)
    {
      android.support.v4.a.a.a.a(this.mN, paramInt);
      return;
    }
    this.my.mE.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.mN != null)
    {
      android.support.v4.a.a.a.a(this.mN, paramColorStateList);
      return;
    }
    this.my.mE.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mN != null)
    {
      android.support.v4.a.a.a.a(this.mN, paramMode);
      return;
    }
    this.my.mE.setTintMode(paramMode);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mN != null) {
      return this.mN.setVisible(paramBoolean1, paramBoolean2);
    }
    this.my.mE.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void start()
  {
    if (this.mN != null) {
      ((AnimatedVectorDrawable)this.mN).start();
    }
    while (this.my.mF.isStarted()) {
      return;
    }
    this.my.mF.start();
    invalidateSelf();
  }
  
  public final void stop()
  {
    if (this.mN != null)
    {
      ((AnimatedVectorDrawable)this.mN).stop();
      return;
    }
    this.my.mF.end();
  }
  
  private static final class a
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    i mE;
    AnimatorSet mF;
    ArrayList<Animator> mG;
    android.support.v4.f.a<Animator, String> mH;
    
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
  
  private static final class b
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState mI;
    
    public b(Drawable.ConstantState paramConstantState)
    {
      this.mI = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.mI.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.mI.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      c localc = new c();
      localc.mN = this.mI.newDrawable();
      localc.mN.setCallback(localc.mC);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      c localc = new c();
      localc.mN = this.mI.newDrawable(paramResources);
      localc.mN.setCallback(localc.mC);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      c localc = new c();
      localc.mN = this.mI.newDrawable(paramResources, paramTheme);
      localc.mN.setCallback(localc.mC);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.c.a.c
 * JD-Core Version:    0.7.0.1
 */