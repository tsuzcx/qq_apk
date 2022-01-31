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
  private a nv;
  private ArgbEvaluator nw = null;
  private Animator.AnimatorListener nx = null;
  ArrayList<Object> ny = null;
  final Drawable.Callback nz = new Drawable.Callback()
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
    this.nv = new a();
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
        if (this.nw == null) {
          this.nw = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(this.nw);
      }
    }
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    if (this.nK != null) {
      android.support.v4.graphics.drawable.a.a(this.nK, paramTheme);
    }
  }
  
  public final boolean canApplyTheme()
  {
    if (this.nK != null) {
      return android.support.v4.graphics.drawable.a.c(this.nK);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.nK != null) {
      this.nK.draw(paramCanvas);
    }
    do
    {
      return;
      this.nv.nB.draw(paramCanvas);
    } while (!this.nv.nC.isStarted());
    invalidateSelf();
  }
  
  public final int getAlpha()
  {
    if (this.nK != null) {
      return android.support.v4.graphics.drawable.a.b(this.nK);
    }
    return this.nv.nB.getAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.nK != null) {
      return this.nK.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.nv.mChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.nK != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new b(this.nK.getConstantState());
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.nK != null) {
      return this.nK.getIntrinsicHeight();
    }
    return this.nv.nB.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.nK != null) {
      return this.nK.getIntrinsicWidth();
    }
    return this.nv.nB.getIntrinsicWidth();
  }
  
  public final int getOpacity()
  {
    if (this.nK != null) {
      return this.nK.getOpacity();
    }
    return this.nv.nB.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.nK != null)
    {
      android.support.v4.graphics.drawable.a.a(this.nK, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
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
        localObject1 = g.a(paramResources, paramTheme, paramAttributeSet, a.nn);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = i.a(paramResources, i, paramTheme);
          ((i)localObject2).nQ = false;
          ((i)localObject2).setCallback(this.nz);
          if (this.nv.nB != null) {
            this.nv.nB.setCallback(null);
          }
          this.nv.nB = ((i)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
      label182:
      while (!"target".equals(localObject1))
      {
        i = paramXmlPullParser.next();
        break;
      }
      Object localObject2 = paramResources.obtainAttributes(paramAttributeSet, a.no);
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
        ((Animator)localObject1).setTarget(this.nv.nB.nM.oK.oJ.get(str));
        if (Build.VERSION.SDK_INT < 21) {
          a((Animator)localObject1);
        }
        if (this.nv.nD == null)
        {
          this.nv.nD = new ArrayList();
          this.nv.nE = new android.support.v4.e.a();
        }
        this.nv.nD.add(localObject1);
        this.nv.nE.put(localObject1, str);
        ((TypedArray)localObject2).recycle();
        break;
      }
      label391:
      ((TypedArray)localObject2).recycle();
      throw new IllegalStateException("Context can't be null when inflating animators");
    }
    paramResources = this.nv;
    if (paramResources.nC == null) {
      paramResources.nC = new AnimatorSet();
    }
    paramResources.nC.playTogether(paramResources.nD);
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.nK != null) {
      return android.support.v4.graphics.drawable.a.a(this.nK);
    }
    return this.nv.nB.isAutoMirrored();
  }
  
  public final boolean isRunning()
  {
    if (this.nK != null) {
      return ((AnimatedVectorDrawable)this.nK).isRunning();
    }
    return this.nv.nC.isRunning();
  }
  
  public final boolean isStateful()
  {
    if (this.nK != null) {
      return this.nK.isStateful();
    }
    return this.nv.nB.isStateful();
  }
  
  public final Drawable mutate()
  {
    if (this.nK != null) {
      this.nK.mutate();
    }
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.nK != null)
    {
      this.nK.setBounds(paramRect);
      return;
    }
    this.nv.nB.setBounds(paramRect);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (this.nK != null) {
      return this.nK.setLevel(paramInt);
    }
    return this.nv.nB.setLevel(paramInt);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.nK != null) {
      return this.nK.setState(paramArrayOfInt);
    }
    return this.nv.nB.setState(paramArrayOfInt);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.nK != null)
    {
      this.nK.setAlpha(paramInt);
      return;
    }
    this.nv.nB.setAlpha(paramInt);
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.nK != null)
    {
      android.support.v4.graphics.drawable.a.a(this.nK, paramBoolean);
      return;
    }
    this.nv.nB.setAutoMirrored(paramBoolean);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.nK != null)
    {
      this.nK.setColorFilter(paramColorFilter);
      return;
    }
    this.nv.nB.setColorFilter(paramColorFilter);
  }
  
  public final void setTint(int paramInt)
  {
    if (this.nK != null)
    {
      android.support.v4.graphics.drawable.a.a(this.nK, paramInt);
      return;
    }
    this.nv.nB.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.nK != null)
    {
      android.support.v4.graphics.drawable.a.a(this.nK, paramColorStateList);
      return;
    }
    this.nv.nB.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.nK != null)
    {
      android.support.v4.graphics.drawable.a.a(this.nK, paramMode);
      return;
    }
    this.nv.nB.setTintMode(paramMode);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.nK != null) {
      return this.nK.setVisible(paramBoolean1, paramBoolean2);
    }
    this.nv.nB.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void start()
  {
    if (this.nK != null) {
      ((AnimatedVectorDrawable)this.nK).start();
    }
    while (this.nv.nC.isStarted()) {
      return;
    }
    this.nv.nC.start();
    invalidateSelf();
  }
  
  public final void stop()
  {
    if (this.nK != null)
    {
      ((AnimatedVectorDrawable)this.nK).stop();
      return;
    }
    this.nv.nC.end();
  }
  
  static final class a
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    i nB;
    AnimatorSet nC;
    ArrayList<Animator> nD;
    android.support.v4.e.a<Animator, String> nE;
    
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
    private final Drawable.ConstantState nF;
    
    public b(Drawable.ConstantState paramConstantState)
    {
      this.nF = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.nF.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.nF.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      c localc = new c();
      localc.nK = this.nF.newDrawable();
      localc.nK.setCallback(localc.nz);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      c localc = new c();
      localc.nK = this.nF.newDrawable(paramResources);
      localc.nK.setCallback(localc.nz);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      c localc = new c();
      localc.nK = this.nF.newDrawable(paramResources, paramTheme);
      localc.nK.setCallback(localc.nz);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.c.a.c
 * JD-Core Version:    0.7.0.1
 */