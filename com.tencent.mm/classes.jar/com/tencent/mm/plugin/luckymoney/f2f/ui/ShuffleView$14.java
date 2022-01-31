package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class ShuffleView$14
  implements GestureDetector.OnGestureListener
{
  ShuffleView$14(ShuffleView paramShuffleView) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    y.d("ShuffleView", "gesture down");
    switch (ShuffleView.l(this.lPv).lPA)
    {
    }
    for (;;)
    {
      return false;
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int i = 0;
      while (i < ShuffleView.d(this.lPv))
      {
        paramMotionEvent = ShuffleView.a(this.lPv, i);
        if ((paramMotionEvent != null) && (paramMotionEvent.contains(j, k)))
        {
          paramMotionEvent = (View)ShuffleView.e(this.lPv).get(i);
          if ((ShuffleView.h(this.lPv) != paramMotionEvent) && (ShuffleView.h(this.lPv) != null)) {
            ShuffleView.m(this.lPv);
          }
          while (ShuffleView.h(this.lPv) != paramMotionEvent)
          {
            ShuffleView.b(this.lPv, i);
            return true;
          }
          y.i("ShuffleView", "down on the select card");
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    y.i("ShuffleView", "fling up " + paramFloat2);
    if (paramFloat2 < -ShuffleView.r(this.lPv))
    {
      switch (ShuffleView.l(this.lPv).lPA)
      {
      }
      for (;;)
      {
        return true;
        if (ShuffleView.h(this.lPv) != null) {
          ShuffleView.m(this.lPv);
        }
        if (ShuffleView.k(this.lPv) != null)
        {
          if (ShuffleView.n(this.lPv) != null) {
            ShuffleView.n(this.lPv).th(ShuffleView.d(this.lPv));
          }
          ShuffleView.c(this.lPv, ShuffleView.i(this.lPv));
        }
      }
    }
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int j;
    int k;
    if (paramMotionEvent2.getActionMasked() == 2)
    {
      j = (int)paramMotionEvent2.getX();
      k = (int)paramMotionEvent2.getY();
      switch (ShuffleView.l(this.lPv).lPA)
      {
      }
    }
    label655:
    label658:
    for (;;)
    {
      return false;
      if (Math.abs(paramFloat2) < ShuffleView.o(this.lPv))
      {
        int i = 0;
        if (i < ShuffleView.d(this.lPv))
        {
          paramMotionEvent1 = ShuffleView.a(this.lPv, i);
          if ((paramMotionEvent1 != null) && (paramMotionEvent1.contains(j, k)))
          {
            paramMotionEvent1 = (View)ShuffleView.e(this.lPv).get(i);
            if ((ShuffleView.h(this.lPv) == paramMotionEvent1) || (ShuffleView.h(this.lPv) == null)) {
              break label193;
            }
            ShuffleView.m(this.lPv);
          }
          label193:
          while (ShuffleView.h(this.lPv) != paramMotionEvent1)
          {
            if (ShuffleView.k(this.lPv) != paramMotionEvent1)
            {
              ShuffleView.p(this.lPv);
              ShuffleView.b(this.lPv, i);
            }
            i += 1;
            break;
          }
          y.i("ShuffleView", "scroll on the select card");
        }
      }
      if (Math.abs(paramFloat1) < ShuffleView.o(this.lPv))
      {
        y.d("ShuffleView", "scroll distanceY:" + paramFloat2);
        if (ShuffleView.k(this.lPv) != null) {
          paramMotionEvent1 = ShuffleView.k(this.lPv);
        }
        for (;;)
        {
          if (paramMotionEvent1 == null) {
            break label658;
          }
          y.i("ShuffleView", "scroll translationY:" + paramMotionEvent1.getTranslationY() + "," + paramMotionEvent1.getHeight() / 7);
          if ((int)paramMotionEvent1.getTranslationY() <= -paramMotionEvent1.getHeight() / 7)
          {
            if ((paramFloat2 >= 0.0F) || (Math.abs(paramFloat2) <= ShuffleView.o(this.lPv))) {
              break;
            }
            if ((int)paramFloat2 <= -paramMotionEvent1.getHeight() / 7) {
              paramMotionEvent1.setTranslationY(0.0F);
            }
            for (;;)
            {
              if (paramMotionEvent1 != ShuffleView.h(this.lPv)) {
                break label493;
              }
              ShuffleView.a(this.lPv, ShuffleView.h(this.lPv));
              ShuffleView.d(this.lPv, ShuffleView.f(this.lPv));
              if (ShuffleView.q(this.lPv).isStarted())
              {
                y.i("ShuffleView", "scroll when select view is animation");
                ShuffleView.q(this.lPv).cancel();
              }
              ShuffleView.b(this.lPv, null);
              ShuffleView.e(this.lPv, 0);
              return false;
              if (ShuffleView.h(this.lPv) == null) {
                break label655;
              }
              paramMotionEvent1 = ShuffleView.h(this.lPv);
              break;
              paramMotionEvent1.setTranslationY(paramMotionEvent1.getTranslationY() - paramFloat2);
            }
            label493:
            break;
          }
          if (paramMotionEvent1.getTranslationY() == 0.0F)
          {
            if ((paramFloat2 <= 0.0F) || (Math.abs(paramFloat2) <= ShuffleView.o(this.lPv))) {
              break;
            }
            if ((int)paramFloat2 >= paramMotionEvent1.getHeight() / 7)
            {
              paramMotionEvent1.setTranslationY(-paramMotionEvent1.getHeight() / 7);
              return false;
            }
            paramMotionEvent1.setTranslationY(paramMotionEvent1.getTranslationY() - paramFloat2);
            return false;
          }
          if (paramFloat2 < 0.0F)
          {
            if (paramMotionEvent1.getTranslationY() - paramFloat2 >= 0.0F)
            {
              paramMotionEvent1.setTranslationY(0.0F);
              return false;
            }
            paramMotionEvent1.setTranslationY(paramMotionEvent1.getTranslationY() - paramFloat2);
            return false;
          }
          if ((int)(paramMotionEvent1.getTranslationY() - paramFloat2) <= -paramMotionEvent1.getHeight() / 7)
          {
            paramMotionEvent1.setTranslationY(-paramMotionEvent1.getHeight() / 7);
            return false;
          }
          paramMotionEvent1.setTranslationY(paramMotionEvent1.getTranslationY() - paramFloat2);
          return false;
          paramMotionEvent1 = null;
        }
      }
    }
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    switch (ShuffleView.l(this.lPv).lPA)
    {
    default: 
      return false;
    }
    if (ShuffleView.h(this.lPv) != null)
    {
      y.d("ShuffleView", "click the select card");
      if (ShuffleView.n(this.lPv) != null) {
        ShuffleView.n(this.lPv).dd(ShuffleView.f(this.lPv), ShuffleView.d(this.lPv));
      }
      ShuffleView.m(this.lPv);
    }
    if (ShuffleView.k(this.lPv) != null)
    {
      if (ShuffleView.n(this.lPv) != null) {
        ShuffleView.n(this.lPv).th(ShuffleView.d(this.lPv));
      }
      ShuffleView.c(this.lPv, ShuffleView.i(this.lPv));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.14
 * JD-Core Version:    0.7.0.1
 */