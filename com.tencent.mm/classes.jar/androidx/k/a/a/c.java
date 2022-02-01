package androidx.k.a.a;

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
  ArrayList<Object> Sx;
  private a atQ;
  private ArgbEvaluator atR;
  private Animator.AnimatorListener atS;
  final Drawable.Callback jb;
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
    AppMethodBeat.i(202395);
    this.atR = null;
    this.atS = null;
    this.Sx = null;
    this.jb = new Drawable.Callback()
    {
      public final void invalidateDrawable(Drawable paramAnonymousDrawable)
      {
        AppMethodBeat.i(202361);
        c.this.invalidateSelf();
        AppMethodBeat.o(202361);
      }
      
      public final void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
      {
        AppMethodBeat.i(202364);
        c.this.scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
        AppMethodBeat.o(202364);
      }
      
      public final void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(202367);
        c.this.unscheduleSelf(paramAnonymousRunnable);
        AppMethodBeat.o(202367);
      }
    };
    this.mContext = paramContext;
    this.atQ = new a();
    AppMethodBeat.o(202395);
  }
  
  private void a(Animator paramAnimator)
  {
    AppMethodBeat.i(202483);
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
        if (this.atR == null) {
          this.atR = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(this.atR);
      }
    }
    AppMethodBeat.o(202483);
  }
  
  public static c d(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(202397);
    paramContext = new c(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    AppMethodBeat.o(202397);
    return paramContext;
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    AppMethodBeat.i(202477);
    if (this.aua != null)
    {
      androidx.core.graphics.drawable.a.a(this.aua, paramTheme);
      AppMethodBeat.o(202477);
      return;
    }
    AppMethodBeat.o(202477);
  }
  
  public final boolean canApplyTheme()
  {
    AppMethodBeat.i(202479);
    if (this.aua != null)
    {
      boolean bool = androidx.core.graphics.drawable.a.n(this.aua);
      AppMethodBeat.o(202479);
      return bool;
    }
    AppMethodBeat.o(202479);
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(202405);
    if (this.aua != null)
    {
      this.aua.draw(paramCanvas);
      AppMethodBeat.o(202405);
      return;
    }
    this.atQ.atU.draw(paramCanvas);
    if (this.atQ.atV.isStarted()) {
      invalidateSelf();
    }
    AppMethodBeat.o(202405);
  }
  
  public final int getAlpha()
  {
    AppMethodBeat.i(202418);
    if (this.aua != null)
    {
      i = androidx.core.graphics.drawable.a.m(this.aua);
      AppMethodBeat.o(202418);
      return i;
    }
    int i = this.atQ.atU.getAlpha();
    AppMethodBeat.o(202418);
    return i;
  }
  
  public final int getChangingConfigurations()
  {
    AppMethodBeat.i(202402);
    if (this.aua != null)
    {
      i = this.aua.getChangingConfigurations();
      AppMethodBeat.o(202402);
      return i;
    }
    int i = super.getChangingConfigurations();
    int j = this.atQ.mChangingConfigurations;
    AppMethodBeat.o(202402);
    return i | j;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    AppMethodBeat.i(202401);
    if ((this.aua != null) && (Build.VERSION.SDK_INT >= 24))
    {
      b localb = new b(this.aua.getConstantState());
      AppMethodBeat.o(202401);
      return localb;
    }
    AppMethodBeat.o(202401);
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(202440);
    if (this.aua != null)
    {
      i = this.aua.getIntrinsicHeight();
      AppMethodBeat.o(202440);
      return i;
    }
    int i = this.atQ.atU.getIntrinsicHeight();
    AppMethodBeat.o(202440);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(202437);
    if (this.aua != null)
    {
      i = this.aua.getIntrinsicWidth();
      AppMethodBeat.o(202437);
      return i;
    }
    int i = this.atQ.atU.getIntrinsicWidth();
    AppMethodBeat.o(202437);
    return i;
  }
  
  public final int getOpacity()
  {
    AppMethodBeat.i(202434);
    if (this.aua != null)
    {
      i = this.aua.getOpacity();
      AppMethodBeat.o(202434);
      return i;
    }
    int i = this.atQ.atU.getOpacity();
    AppMethodBeat.o(202434);
    return i;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(202475);
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
    AppMethodBeat.o(202475);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(202472);
    if (this.aua != null)
    {
      androidx.core.graphics.drawable.a.a(this.aua, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      AppMethodBeat.o(202472);
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
        localObject1 = g.a(paramResources, paramTheme, paramAttributeSet, a.atI);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = i.c(paramResources, i, paramTheme);
          ((i)localObject2).auc = false;
          ((i)localObject2).setCallback(this.jb);
          if (this.atQ.atU != null) {
            this.atQ.atU.setCallback(null);
          }
          this.atQ.atU = ((i)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
      label193:
      while (!"target".equals(localObject1))
      {
        i = paramXmlPullParser.next();
        break;
      }
      Object localObject2 = paramResources.obtainAttributes(paramAttributeSet, a.atJ);
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
        ((Animator)localObject1).setTarget(this.atQ.atU.aub.auR.auQ.get(str));
        if (Build.VERSION.SDK_INT < 21) {
          a((Animator)localObject1);
        }
        if (this.atQ.kF == null)
        {
          this.atQ.kF = new ArrayList();
          this.atQ.atW = new androidx.b.a();
        }
        this.atQ.kF.add(localObject1);
        this.atQ.atW.put(localObject1, str);
        ((TypedArray)localObject2).recycle();
        break;
      }
      label402:
      ((TypedArray)localObject2).recycle();
      paramResources = new IllegalStateException("Context can't be null when inflating animators");
      AppMethodBeat.o(202472);
      throw paramResources;
    }
    paramResources = this.atQ;
    if (paramResources.atV == null) {
      paramResources.atV = new AnimatorSet();
    }
    paramResources.atV.playTogether(paramResources.kF);
    AppMethodBeat.o(202472);
  }
  
  public final boolean isAutoMirrored()
  {
    AppMethodBeat.i(202442);
    if (this.aua != null)
    {
      bool = androidx.core.graphics.drawable.a.l(this.aua);
      AppMethodBeat.o(202442);
      return bool;
    }
    boolean bool = this.atQ.atU.isAutoMirrored();
    AppMethodBeat.o(202442);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(202487);
    if (this.aua != null)
    {
      bool = ((AnimatedVectorDrawable)this.aua).isRunning();
      AppMethodBeat.o(202487);
      return bool;
    }
    boolean bool = this.atQ.atV.isRunning();
    AppMethodBeat.o(202487);
    return bool;
  }
  
  public final boolean isStateful()
  {
    AppMethodBeat.i(202432);
    if (this.aua != null)
    {
      bool = this.aua.isStateful();
      AppMethodBeat.o(202432);
      return bool;
    }
    boolean bool = this.atQ.atU.isStateful();
    AppMethodBeat.o(202432);
    return bool;
  }
  
  public final Drawable mutate()
  {
    AppMethodBeat.i(202396);
    if (this.aua != null) {
      this.aua.mutate();
    }
    AppMethodBeat.o(202396);
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(202411);
    if (this.aua != null)
    {
      this.aua.setBounds(paramRect);
      AppMethodBeat.o(202411);
      return;
    }
    this.atQ.atU.setBounds(paramRect);
    AppMethodBeat.o(202411);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    AppMethodBeat.i(202417);
    if (this.aua != null)
    {
      bool = this.aua.setLevel(paramInt);
      AppMethodBeat.o(202417);
      return bool;
    }
    boolean bool = this.atQ.atU.setLevel(paramInt);
    AppMethodBeat.o(202417);
    return bool;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(202414);
    if (this.aua != null)
    {
      bool = this.aua.setState(paramArrayOfInt);
      AppMethodBeat.o(202414);
      return bool;
    }
    boolean bool = this.atQ.atU.setState(paramArrayOfInt);
    AppMethodBeat.o(202414);
    return bool;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(202421);
    if (this.aua != null)
    {
      this.aua.setAlpha(paramInt);
      AppMethodBeat.o(202421);
      return;
    }
    this.atQ.atU.setAlpha(paramInt);
    AppMethodBeat.o(202421);
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    AppMethodBeat.i(202446);
    if (this.aua != null)
    {
      androidx.core.graphics.drawable.a.b(this.aua, paramBoolean);
      AppMethodBeat.o(202446);
      return;
    }
    this.atQ.atU.setAutoMirrored(paramBoolean);
    AppMethodBeat.o(202446);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(202422);
    if (this.aua != null)
    {
      this.aua.setColorFilter(paramColorFilter);
      AppMethodBeat.o(202422);
      return;
    }
    this.atQ.atU.setColorFilter(paramColorFilter);
    AppMethodBeat.o(202422);
  }
  
  public final void setTint(int paramInt)
  {
    AppMethodBeat.i(202425);
    if (this.aua != null)
    {
      androidx.core.graphics.drawable.a.a(this.aua, paramInt);
      AppMethodBeat.o(202425);
      return;
    }
    this.atQ.atU.setTint(paramInt);
    AppMethodBeat.o(202425);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(202427);
    if (this.aua != null)
    {
      androidx.core.graphics.drawable.a.a(this.aua, paramColorStateList);
      AppMethodBeat.o(202427);
      return;
    }
    this.atQ.atU.setTintList(paramColorStateList);
    AppMethodBeat.o(202427);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(202429);
    if (this.aua != null)
    {
      androidx.core.graphics.drawable.a.a(this.aua, paramMode);
      AppMethodBeat.o(202429);
      return;
    }
    this.atQ.atU.setTintMode(paramMode);
    AppMethodBeat.o(202429);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(202431);
    if (this.aua != null)
    {
      paramBoolean1 = this.aua.setVisible(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(202431);
      return paramBoolean1;
    }
    this.atQ.atU.setVisible(paramBoolean1, paramBoolean2);
    paramBoolean1 = super.setVisible(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(202431);
    return paramBoolean1;
  }
  
  public final void start()
  {
    AppMethodBeat.i(202489);
    if (this.aua != null)
    {
      ((AnimatedVectorDrawable)this.aua).start();
      AppMethodBeat.o(202489);
      return;
    }
    if (this.atQ.atV.isStarted())
    {
      AppMethodBeat.o(202489);
      return;
    }
    this.atQ.atV.start();
    invalidateSelf();
    AppMethodBeat.o(202489);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(202493);
    if (this.aua != null)
    {
      ((AnimatedVectorDrawable)this.aua).stop();
      AppMethodBeat.o(202493);
      return;
    }
    this.atQ.atV.end();
    AppMethodBeat.o(202493);
  }
  
  static final class a
    extends Drawable.ConstantState
  {
    i atU;
    AnimatorSet atV;
    androidx.b.a<Animator, String> atW;
    ArrayList<Animator> kF;
    int mChangingConfigurations;
    
    public final int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(202372);
      IllegalStateException localIllegalStateException = new IllegalStateException("No constant state support for SDK < 24.");
      AppMethodBeat.o(202372);
      throw localIllegalStateException;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(202373);
      paramResources = new IllegalStateException("No constant state support for SDK < 24.");
      AppMethodBeat.o(202373);
      throw paramResources;
    }
  }
  
  static final class b
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState atX;
    
    public b(Drawable.ConstantState paramConstantState)
    {
      this.atX = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      AppMethodBeat.i(202388);
      boolean bool = this.atX.canApplyTheme();
      AppMethodBeat.o(202388);
      return bool;
    }
    
    public final int getChangingConfigurations()
    {
      AppMethodBeat.i(202390);
      int i = this.atX.getChangingConfigurations();
      AppMethodBeat.o(202390);
      return i;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(202381);
      c localc = new c();
      localc.aua = this.atX.newDrawable();
      localc.aua.setCallback(localc.jb);
      AppMethodBeat.o(202381);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(202382);
      c localc = new c();
      localc.aua = this.atX.newDrawable(paramResources);
      localc.aua.setCallback(localc.jb);
      AppMethodBeat.o(202382);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(202386);
      c localc = new c();
      localc.aua = this.atX.newDrawable(paramResources, paramTheme);
      localc.aua.setCallback(localc.jb);
      AppMethodBeat.o(202386);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.k.a.a.c
 * JD-Core Version:    0.7.0.1
 */