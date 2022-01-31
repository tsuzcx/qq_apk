package android.support.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.support.v4.view.b.a;
import android.support.v4.view.b.b;
import android.support.v4.view.b.c;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class d
{
  public static Interpolator loadInterpolator(Context paramContext, int paramInt)
  {
    Object localObject1 = null;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramContext = AnimationUtils.loadInterpolator(paramContext, paramInt);
      return paramContext;
    }
    if (paramInt == 17563663) {}
    try
    {
      paramContext = new a();
      return paramContext;
    }
    catch (XmlPullParserException localXmlPullParserException2)
    {
      paramContext = localObject1;
      localObject1 = localXmlPullParserException2;
      try
      {
        localObject4 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(paramInt));
        ((Resources.NotFoundException)localObject4).initCause(localObject1);
        throw ((Throwable)localObject4);
      }
      finally
      {
        localObject5 = paramContext;
      }
      if (localObject5 != null) {
        ((XmlResourceParser)localObject5).close();
      }
      throw paramContext;
      if (paramInt == 17563661)
      {
        paramContext = new b();
        return paramContext;
      }
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        localObject4 = null;
        localObject5 = localObject4;
        try
        {
          localObject3 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(paramInt));
          localObject5 = localObject4;
          ((Resources.NotFoundException)localObject3).initCause(paramContext);
          localObject5 = localObject4;
          throw ((Throwable)localObject3);
        }
        finally {}
      }
      if (paramInt == 17563662) {
        return new c();
      }
      localObject4 = paramContext.getResources().getAnimation(paramInt);
      localObject5 = localObject4;
    }
    finally
    {
      for (;;)
      {
        try
        {
          paramContext.getResources();
          Object localObject5 = localObject4;
          paramContext.getTheme();
          localObject5 = localObject4;
          int i = ((XmlPullParser)localObject4).getDepth();
          Object localObject3 = null;
          localObject5 = localObject4;
          int j = ((XmlPullParser)localObject4).next();
          if (j == 3)
          {
            localObject5 = localObject4;
            if (((XmlPullParser)localObject4).getDepth() <= i) {}
          }
          else if (j != 1)
          {
            if (j != 2) {
              continue;
            }
            localObject5 = localObject4;
            localObject3 = Xml.asAttributeSet((XmlPullParser)localObject4);
            localObject5 = localObject4;
            String str = ((XmlPullParser)localObject4).getName();
            localObject5 = localObject4;
            if (str.equals("linearInterpolator"))
            {
              localObject5 = localObject4;
              localObject3 = new LinearInterpolator();
              continue;
            }
            localObject5 = localObject4;
            if (str.equals("accelerateInterpolator"))
            {
              localObject5 = localObject4;
              localObject3 = new AccelerateInterpolator(paramContext, (AttributeSet)localObject3);
              continue;
            }
            localObject5 = localObject4;
            if (str.equals("decelerateInterpolator"))
            {
              localObject5 = localObject4;
              localObject3 = new DecelerateInterpolator(paramContext, (AttributeSet)localObject3);
              continue;
            }
            localObject5 = localObject4;
            if (str.equals("accelerateDecelerateInterpolator"))
            {
              localObject5 = localObject4;
              localObject3 = new AccelerateDecelerateInterpolator();
              continue;
            }
            localObject5 = localObject4;
            if (str.equals("cycleInterpolator"))
            {
              localObject5 = localObject4;
              localObject3 = new CycleInterpolator(paramContext, (AttributeSet)localObject3);
              continue;
            }
            localObject5 = localObject4;
            if (str.equals("anticipateInterpolator"))
            {
              localObject5 = localObject4;
              localObject3 = new AnticipateInterpolator(paramContext, (AttributeSet)localObject3);
              continue;
            }
            localObject5 = localObject4;
            if (str.equals("overshootInterpolator"))
            {
              localObject5 = localObject4;
              localObject3 = new OvershootInterpolator(paramContext, (AttributeSet)localObject3);
              continue;
            }
            localObject5 = localObject4;
            if (str.equals("anticipateOvershootInterpolator"))
            {
              localObject5 = localObject4;
              localObject3 = new AnticipateOvershootInterpolator(paramContext, (AttributeSet)localObject3);
              continue;
            }
            localObject5 = localObject4;
            if (str.equals("bounceInterpolator"))
            {
              localObject5 = localObject4;
              localObject3 = new BounceInterpolator();
              continue;
            }
            localObject5 = localObject4;
            if (str.equals("pathInterpolator"))
            {
              localObject5 = localObject4;
              localObject3 = new g(paramContext, (AttributeSet)localObject3, (XmlPullParser)localObject4);
              continue;
            }
            localObject5 = localObject4;
            throw new RuntimeException("Unknown interpolator name: " + ((XmlPullParser)localObject4).getName());
          }
          paramContext = (Context)localObject3;
          if (localObject4 == null) {
            break;
          }
          ((XmlResourceParser)localObject4).close();
          return localObject3;
          paramContext = finally;
          localObject5 = null;
        }
        catch (XmlPullParserException localXmlPullParserException1)
        {
          Object localObject4;
          paramContext = (Context)localObject4;
        }
        catch (IOException paramContext) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.c.a.d
 * JD-Core Version:    0.7.0.1
 */