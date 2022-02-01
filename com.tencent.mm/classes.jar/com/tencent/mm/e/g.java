package com.tencent.mm.e;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class g
{
  c hbV;
  Rect hbZ;
  float hpA;
  float hpB;
  float hpC;
  private int hpd;
  Rect hpl;
  private boolean hpr;
  private float hpx;
  private float hpy;
  float hpz;
  float hqj;
  private int hqk;
  private Rect hql;
  int hqm;
  int hqn;
  int hqo;
  int hqp;
  
  public g(c paramc, float paramFloat, Rect paramRect)
  {
    AppMethodBeat.i(231832);
    this.hpd = ((int)MMApplicationContext.getResources().getDimension(a.c.box_padding));
    this.hqk = 0;
    this.hpr = false;
    this.hqj = paramFloat;
    this.hbV = paramc;
    this.hbZ = paramRect;
    this.hpl = paramc.hpl;
    AppMethodBeat.o(231832);
  }
  
  private void a(RectF paramRectF, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(231862);
    Log.i("FixRatioCropHelper", "translateImage cropDirection:" + paramInt + " eventPosDelta:" + paramFloat);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(231862);
      return;
      if (((int)paramRectF.bottom <= (int)this.hpA) && ((int)paramRectF.bottom <= this.hbZ.bottom))
      {
        if (paramFloat > this.hpA - paramRectF.bottom)
        {
          Log.i("FixRatioCropHelper", "translateImage bottom 11:" + (this.hpA - paramRectF.bottom));
          getMainMatrix().postTranslate(0.0F, this.hpA - paramRectF.bottom);
          AppMethodBeat.o(231862);
          return;
        }
        Log.i("FixRatioCropHelper", "translateImage bottom 22:".concat(String.valueOf(paramFloat)));
        getMainMatrix().postTranslate(0.0F, paramFloat);
        AppMethodBeat.o(231862);
        return;
      }
      Log.i("FixRatioCropHelper", "translateImage bottom else :".concat(String.valueOf(paramFloat)));
      AppMethodBeat.o(231862);
      return;
      if (((int)paramRectF.top >= (int)this.hpz) && ((int)paramRectF.top >= this.hbZ.top))
      {
        if (paramFloat > paramRectF.top - this.hpz)
        {
          Log.i("FixRatioCropHelper", "translateImage imageRect.top - mEdgeTop - imageRect.left:" + (paramRectF.top - this.hpz));
          getMainMatrix().postTranslate(0.0F, this.hpz - paramRectF.top);
          AppMethodBeat.o(231862);
          return;
        }
        Log.i("FixRatioCropHelper", "translateImage top eventPosDelta:".concat(String.valueOf(paramFloat)));
        getMainMatrix().postTranslate(0.0F, paramFloat);
        AppMethodBeat.o(231862);
        return;
        if (((int)paramRectF.right <= (int)this.hpC) && ((int)paramRectF.right <= this.hbZ.right))
        {
          if (paramFloat > this.hpC - paramRectF.right)
          {
            getMainMatrix().postTranslate(this.hpC - paramRectF.right, 0.0F);
            AppMethodBeat.o(231862);
            return;
          }
          getMainMatrix().postTranslate(paramFloat, 0.0F);
          AppMethodBeat.o(231862);
          return;
          Log.i("FixRatioCropHelper", "translateImage LEFT begin");
          if (((int)paramRectF.left >= (int)this.hpB) && ((int)paramRectF.left >= this.hbZ.left))
          {
            if (paramFloat > paramRectF.left - this.hpB)
            {
              Log.i("FixRatioCropHelper", "translateImage left mEdgeLeft - imageRect.left:" + (this.hpB - paramRectF.left));
              getMainMatrix().postTranslate(this.hpB - paramRectF.left, 0.0F);
              AppMethodBeat.o(231862);
              return;
            }
            Log.i("FixRatioCropHelper", "translateImage left eventPosDelta:".concat(String.valueOf(paramFloat)));
            getMainMatrix().postTranslate(paramFloat, 0.0F);
            AppMethodBeat.o(231862);
            return;
          }
          Log.i("FixRatioCropHelper", "translateImage LEFT else");
        }
      }
    }
  }
  
  private void a(RectF paramRectF, int paramInt)
  {
    AppMethodBeat.i(231851);
    Log.i("FixRatioCropHelper", "scaleImage cropDirection:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(231851);
      return;
      float f;
      if ((this.hbZ.height() > paramRectF.height()) && (this.hbZ.bottom < this.hpl.bottom))
      {
        f = this.hbZ.height() / paramRectF.height();
        getMainMatrix().postScale(f, f, this.hbZ.centerX(), this.hbZ.top);
        Log.i("FixRatioCropHelper", "scaleImage bottom 11 :".concat(String.valueOf(f)));
      }
      if (this.hbZ.width() > paramRectF.width())
      {
        f = this.hbZ.width() / paramRectF.width();
        getMainMatrix().postScale(f, f, this.hbZ.centerX(), this.hbZ.top);
        Log.i("FixRatioCropHelper", "scaleImage bottom 22 :".concat(String.valueOf(f)));
        AppMethodBeat.o(231851);
        return;
        if ((this.hbZ.height() > paramRectF.height()) && (this.hbZ.top > this.hpl.top))
        {
          f = this.hbZ.height() / paramRectF.height();
          Log.i("FixRatioCropHelper", "scaleImage TOP 11 :".concat(String.valueOf(f)));
          getMainMatrix().postScale(f, f, this.hbZ.centerX(), this.hbZ.bottom);
        }
        if (this.hbZ.width() > paramRectF.width())
        {
          f = this.hbZ.width() / paramRectF.width();
          Log.i("FixRatioCropHelper", "scaleImage TOP 22 :".concat(String.valueOf(f)));
          getMainMatrix().postScale(f, f, this.hbZ.centerX(), this.hbZ.bottom);
          AppMethodBeat.o(231851);
          return;
          if ((this.hbZ.width() > paramRectF.width()) && (this.hbZ.right < this.hpl.right))
          {
            f = this.hbZ.width() / paramRectF.width();
            Log.i("FixRatioCropHelper", "scaleImage RIGHT 11 :".concat(String.valueOf(f)));
            getMainMatrix().postScale(f, f, this.hbZ.left, this.hbZ.centerY());
          }
          if (this.hbZ.height() > paramRectF.height())
          {
            f = this.hbZ.height() / paramRectF.height();
            Log.i("FixRatioCropHelper", "scaleImage RIGHT 22 :".concat(String.valueOf(f)));
            getMainMatrix().postScale(f, f, this.hbZ.left, this.hbZ.centerY());
            AppMethodBeat.o(231851);
            return;
            if ((this.hbZ.width() > paramRectF.width()) && (this.hbZ.left > this.hpl.left))
            {
              f = this.hbZ.width() / paramRectF.width();
              Log.i("FixRatioCropHelper", "scaleImage LEFT 11 :".concat(String.valueOf(f)));
              getMainMatrix().postScale(f, f, this.hbZ.right, this.hbZ.centerY());
            }
            if (this.hbZ.height() > paramRectF.height())
            {
              f = this.hbZ.height() / paramRectF.height();
              Log.i("FixRatioCropHelper", "scaleImage LEFT 22 :".concat(String.valueOf(f)));
              getMainMatrix().postScale(f, f, this.hbZ.right, this.hbZ.centerY());
            }
          }
        }
      }
    }
  }
  
  private void b(RectF paramRectF, int paramInt)
  {
    AppMethodBeat.i(231855);
    if ((paramInt & 0x1) == 1) {
      a(paramRectF, this.hbZ.left - this.hql.left, 1);
    }
    if ((paramInt & 0x4) == 4) {
      a(paramRectF, this.hbZ.right - this.hql.right, 4);
    }
    if ((paramInt & 0x2) == 2) {
      a(paramRectF, this.hbZ.top - this.hql.top, 2);
    }
    if ((paramInt & 0x8) == 8) {
      a(paramRectF, this.hbZ.bottom - this.hql.bottom, 8);
    }
    AppMethodBeat.o(231855);
  }
  
  private void c(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(231835);
    if (this.hbZ.top >= this.hpl.top)
    {
      if (paramInt1 > this.hbZ.top - this.hpl.top) {
        e(this.hpl.top, paramInt2, paramRect);
      }
    }
    else
    {
      if (this.hbZ.top > this.hbZ.bottom - this.hpd * 2) {
        e(this.hbZ.bottom - this.hpd * 2, paramInt2, paramRect);
      }
      if (this.hbZ.top < this.hpl.top) {
        e(this.hpl.top, paramInt2, paramRect);
      }
      paramRect = this.hbV.hoR.iPo().getBaseBoardView().getCurImageRect();
      if (paramInt2 <= 2) {
        break label188;
      }
      b(paramRect, paramInt2);
    }
    for (;;)
    {
      a(paramRect, 2);
      AppMethodBeat.o(231835);
      return;
      e(this.hbZ.top - paramInt1, paramInt2, paramRect);
      break;
      label188:
      b(paramRect, 2);
      b(paramRect, 1);
      b(paramRect, 4);
    }
  }
  
  private void d(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(231840);
    if (this.hbZ.bottom <= this.hpl.bottom)
    {
      if (paramInt1 <= this.hpl.bottom - this.hbZ.bottom) {
        break label174;
      }
      f(this.hpl.bottom, paramInt2, paramRect);
      if (this.hbZ.bottom < this.hbZ.top + this.hpd * 2) {
        f(this.hbZ.top + this.hpd * 2, paramInt2, paramRect);
      }
      if (this.hbZ.bottom > this.hpl.bottom) {
        f(this.hbZ.bottom, paramInt2, paramRect);
      }
      paramRect = this.hbV.hoR.iPo().getBaseBoardView().getCurImageRect();
      if (paramInt2 <= 8) {
        break label192;
      }
      b(paramRect, paramInt2);
    }
    for (;;)
    {
      a(paramRect, 8);
      AppMethodBeat.o(231840);
      return;
      label174:
      f(this.hbZ.bottom + paramInt1, paramInt2, paramRect);
      break;
      label192:
      b(paramRect, 8);
      b(paramRect, 1);
      b(paramRect, 4);
    }
  }
  
  private void e(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(231869);
    int i;
    for (;;)
    {
      i = (int)((paramRect.bottom - paramInt1) * this.hqj);
      switch (paramInt2)
      {
      case 4: 
      case 5: 
      default: 
        AppMethodBeat.o(231869);
        return;
      case 2: 
        paramInt2 = paramRect.centerX();
        this.hqp = (paramInt2 - i / 2);
        this.hqo = (i / 2 + paramInt2);
        if (paramInt2 < this.hpl.centerX())
        {
          if (this.hqp >= this.hpl.left) {
            break label138;
          }
          paramInt2 = 6;
        }
        else
        {
          if (this.hqo <= this.hpl.right) {
            break label138;
          }
          paramInt2 = 3;
        }
        break;
      }
    }
    label138:
    this.hbZ.left = this.hqp;
    do
    {
      this.hbZ.right = this.hqo;
      this.hbZ.top = paramInt1;
      break;
      this.hqp = (paramRect.right - i);
      if (this.hqp < this.hpl.left)
      {
        paramInt1 = paramRect.right;
        paramInt2 = this.hpl.left;
        this.hbZ.left = this.hpl.left;
        this.hbZ.top = ((int)(paramRect.bottom - (paramInt1 - paramInt2) / this.hqj));
        AppMethodBeat.o(231869);
        return;
      }
      this.hbZ.left = this.hqp;
      this.hbZ.top = paramInt1;
      AppMethodBeat.o(231869);
      return;
      this.hqo = (i + paramRect.left);
    } while (this.hbZ.right <= this.hpl.right);
    paramInt1 = this.hpl.right;
    paramInt2 = paramRect.left;
    this.hbZ.right = this.hpl.right;
    this.hbZ.top = ((int)(paramRect.bottom - (paramInt1 - paramInt2) / this.hqj));
    AppMethodBeat.o(231869);
  }
  
  private void f(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(231883);
    int i;
    for (;;)
    {
      i = (int)((paramInt1 - paramRect.top) * this.hqj);
      switch (paramInt2)
      {
      case 10: 
      case 11: 
      default: 
        AppMethodBeat.o(231883);
        return;
      case 8: 
        paramInt2 = paramRect.centerX();
        this.hqp = (paramInt2 - i / 2);
        this.hqo = (i / 2 + paramInt2);
        if (paramInt2 < this.hpl.centerX())
        {
          if (this.hqp >= this.hpl.left) {
            break label155;
          }
          Log.i("FixRatioCropHelper", "change direct to right_bottom");
          paramInt2 = 12;
        }
        else
        {
          if (this.hqo <= this.hpl.right) {
            break label155;
          }
          Log.i("FixRatioCropHelper", "change direct to RIGHT_TOP");
          paramInt2 = 9;
        }
        break;
      }
    }
    label155:
    this.hbZ.left = this.hqp;
    do
    {
      this.hbZ.right = this.hqo;
      this.hbZ.bottom = paramInt1;
      break;
      this.hqp = (paramRect.right - i);
      Log.i("FixRatioCropHelper", "adjustBottom RIGHT_BOTTOM :" + this.hbZ);
      if (this.hqp < this.hpl.left)
      {
        paramInt1 = paramRect.right;
        paramInt2 = this.hpl.left;
        this.hbZ.left = this.hpl.left;
        Rect localRect = this.hbZ;
        f = paramRect.top;
        localRect.bottom = ((int)((paramInt1 - paramInt2) / this.hqj + f));
        AppMethodBeat.o(231883);
        return;
      }
      this.hbZ.left = this.hqp;
      this.hbZ.bottom = paramInt1;
      AppMethodBeat.o(231883);
      return;
      this.hqo = (i + paramRect.left);
      Log.i("FixRatioCropHelper", "adjustBottom RIGHT_BOTTOM" + this.hbZ);
    } while (this.hqo <= this.hpl.right);
    paramInt1 = this.hpl.right;
    paramInt2 = paramRect.left;
    this.hbZ.right = this.hpl.right;
    paramRect = this.hbZ;
    float f = this.hbZ.top;
    paramRect.bottom = ((int)((paramInt1 - paramInt2) / this.hqj + f));
    AppMethodBeat.o(231883);
  }
  
  private void g(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(231888);
    if (this.hbZ.left >= this.hpl.left)
    {
      if (paramInt1 > this.hbZ.left - this.hpl.left) {
        h(this.hpl.left, paramInt2, paramRect);
      }
    }
    else
    {
      if (this.hbZ.left > this.hbZ.right - this.hpd * 2) {
        h(this.hbZ.right - this.hpd * 2, paramInt2, paramRect);
      }
      if (this.hbZ.left < this.hpl.left) {
        h(this.hpl.left, paramInt2, paramRect);
      }
      paramRect = this.hbV.hoR.iPo().getBaseBoardView().getCurImageRect();
      if (paramInt2 <= 1) {
        break label190;
      }
      b(paramRect, paramInt2);
    }
    for (;;)
    {
      a(paramRect, 1);
      AppMethodBeat.o(231888);
      return;
      h(this.hbZ.left - paramInt1, paramInt2, paramRect);
      break;
      label190:
      b(paramRect, 1);
      b(paramRect, 8);
      b(paramRect, 2);
    }
  }
  
  private Matrix getMainMatrix()
  {
    AppMethodBeat.i(231895);
    Matrix localMatrix = this.hbV.hoR.iPo().getBaseBoardView().getMainMatrix();
    AppMethodBeat.o(231895);
    return localMatrix;
  }
  
  private void h(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(231892);
    int i;
    for (;;)
    {
      i = (int)((paramRect.right - paramInt1) / this.hqj);
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(231892);
        return;
      case 1: 
        float f = paramRect.centerY();
        this.hqm = ((int)(f - i / 2));
        this.hqn = ((int)(i / 2 + f));
        Log.i("FixRatioCropHelper", "adjustLeft :" + this.hbZ + " LEFT");
        if (f >= this.hpl.centerY())
        {
          if (this.hqn <= this.hpl.bottom) {
            break label180;
          }
          paramInt2 = 3;
        }
        else
        {
          if (this.hqm >= this.hpl.top) {
            break label180;
          }
          paramInt2 = 9;
        }
        break;
      }
    }
    label180:
    this.hbZ.top = this.hqm;
    do
    {
      this.hbZ.bottom = this.hqn;
      this.hbZ.left = paramInt1;
      break;
      this.hqm = (paramRect.bottom - i);
      if (this.hqm <= this.hpl.top)
      {
        paramInt1 = paramRect.bottom;
        paramInt2 = this.hpl.top;
        this.hbZ.top = this.hpl.top;
      }
      for (this.hbZ.left = ((int)(paramRect.right - (paramInt1 - paramInt2) * this.hqj));; this.hbZ.left = paramInt1)
      {
        Log.i("FixRatioCropHelper", "adjustLeft :" + this.hbZ + " LEFT_TOP");
        AppMethodBeat.o(231892);
        return;
        this.hbZ.top = this.hqm;
      }
      this.hqn = (i + paramRect.top);
      Log.i("FixRatioCropHelper", "adjustLeft :" + this.hbZ + " LEFT_BOTTOM");
    } while (this.hqn < this.hpl.bottom);
    paramInt1 = this.hpl.bottom;
    paramInt2 = paramRect.top;
    this.hbZ.bottom = this.hpl.bottom;
    this.hbZ.left = ((int)(paramRect.right - (paramInt1 - paramInt2) * this.hqj));
    AppMethodBeat.o(231892);
  }
  
  private void i(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(231893);
    if (this.hbZ.right <= this.hpl.right)
    {
      if (paramInt1 > this.hpl.right - this.hbZ.right)
      {
        Log.i("FixRatioCropHelper", "changeRight outof bound:");
        j(this.hpl.right, paramInt2, paramRect);
      }
    }
    else
    {
      if (this.hbZ.right < this.hbZ.left + this.hpd * 2)
      {
        Log.i("FixRatioCropHelper", "changeRight < 2 padding>: " + this.hbZ.right);
        j(this.hbZ.left + this.hpd * 2, paramInt2, paramRect);
      }
      if (this.hbZ.right > this.hpl.right)
      {
        Log.i("FixRatioCropHelper", "changeRight after out of bound>: " + this.hbZ.right);
        j(this.hpl.right, paramInt2, paramRect);
      }
      paramRect = this.hbV.hoR.iPo().getBaseBoardView().getCurImageRect();
      if (paramInt2 <= 4) {
        break label269;
      }
      b(paramRect, paramInt2);
    }
    for (;;)
    {
      a(paramRect, 4);
      AppMethodBeat.o(231893);
      return;
      Log.i("FixRatioCropHelper", "changeRight normal eventPosDelta: ".concat(String.valueOf(paramInt1)));
      j(this.hbZ.right + paramInt1, paramInt2, paramRect);
      break;
      label269:
      b(paramRect, 4);
      b(paramRect, 8);
      b(paramRect, 2);
    }
  }
  
  private void j(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(231894);
    int i = (int)((paramInt1 - paramRect.left) / this.hqj);
    Log.i("FixRatioCropHelper", "adjustRight delta:".concat(String.valueOf(i)));
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(231894);
      return;
      paramInt2 = paramRect.centerY();
      this.hqm = (paramInt2 - i / 2);
      this.hqn = (i / 2 + paramInt2);
      Log.i("FixRatioCropHelper", "adjustRight right mBoxRect :" + this.hbZ);
      if (paramInt2 > this.hpl.centerY())
      {
        if (this.hqn <= this.hpl.bottom) {
          break label180;
        }
        paramInt2 = 6;
        break;
      }
      if (this.hqm < this.hpl.top)
      {
        paramInt2 = 12;
        break;
      }
      label180:
      this.hbZ.right = paramInt1;
      this.hbZ.top = this.hqm;
      this.hbZ.bottom = this.hqn;
      AppMethodBeat.o(231894);
      return;
      this.hqm = (paramRect.bottom - i);
      Log.i("FixRatioCropHelper", "adjustRight RIGHT_TOP mBoxRect :" + this.hbZ);
      if (this.hqm < this.hpl.top)
      {
        paramInt1 = paramRect.bottom;
        paramInt2 = this.hpl.top;
        this.hbZ.top = this.hpl.top;
        paramRect = this.hbZ;
        float f = this.hbZ.left;
        paramRect.right = ((int)((paramInt1 - paramInt2) * this.hqj + f));
        AppMethodBeat.o(231894);
        return;
      }
      this.hbZ.top = this.hqm;
      this.hbZ.right = paramInt1;
      AppMethodBeat.o(231894);
      return;
      this.hqn = (i + paramRect.top);
      Log.i("FixRatioCropHelper", "adjustRight RIGHT_BOTTOM mBoxRect.top :" + this.hbZ);
      if (this.hbZ.bottom > this.hpl.bottom)
      {
        paramInt1 = this.hpl.bottom;
        paramInt2 = paramRect.top;
        this.hbZ.bottom = this.hpl.bottom;
        this.hbZ.right = (paramInt1 - paramInt2 + this.hbZ.left);
        AppMethodBeat.o(231894);
        return;
      }
      this.hbZ.bottom = this.hqn;
      this.hbZ.right = paramInt1;
    }
  }
  
  final boolean v(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(231903);
    Object localObject = this.hbV.hoR.iPo().getBaseBoardView().getCurImageRect();
    this.hpz = (((RectF)localObject).top - (((RectF)localObject).bottom - this.hbZ.bottom));
    this.hpA = (((RectF)localObject).bottom + (this.hbZ.top - ((RectF)localObject).top));
    this.hpB = (((RectF)localObject).left - (((RectF)localObject).right - this.hbZ.right));
    final float f1 = ((RectF)localObject).right;
    this.hpC = (this.hbZ.left - ((RectF)localObject).left + f1);
    if (this.hpC > this.hpl.right) {
      this.hpC = this.hpl.right;
    }
    if (this.hpB < this.hpd) {
      this.hpB = this.hpd;
    }
    if (this.hpA > this.hpl.bottom) {
      this.hpA = this.hpl.bottom;
    }
    if (this.hpz < this.hpd) {
      this.hpz = this.hpd;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    default: 
    case 5: 
    case 0: 
    case 2: 
      do
      {
        for (;;)
        {
          boolean bool = this.hpr;
          AppMethodBeat.o(231903);
          return bool;
          this.hqk = 0;
          this.hpr = false;
          continue;
          Log.i("FixRatioCropHelper", "ACTION_DOWN moveDirection :" + this.hqk);
          this.hpr = false;
          if (this.hbV.hpp != null) {
            this.hbV.hpp.cancel();
          }
          if (this.hbV.hpi.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.hqk |= 0x8;
          }
          if (this.hbV.hph.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.hqk |= 0x2;
          }
          if (this.hbV.hpj.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.hqk |= 0x1;
          }
          if (this.hbV.hpk.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.hqk |= 0x4;
          }
          this.hbV.hpw = false;
          if (this.hqk > 0)
          {
            this.hpr = true;
            this.hpx = paramMotionEvent.getX();
            this.hpy = paramMotionEvent.getY();
          }
        }
      } while (!this.hpr);
      Log.i("FixRatioCropHelper", "ACTION_MOVE moveDirection :" + this.hqk + "mBoxRect：" + this.hbZ + " originRect:" + this.hql);
      this.hql = new Rect(this.hbZ);
      if ((paramMotionEvent.getPointerCount() == 1) && (this.hqk > 0)) {
        switch (this.hqk)
        {
        case 5: 
        case 7: 
        case 10: 
        case 11: 
        default: 
          label664:
          this.hbV.aEK();
          this.hpr = true;
          this.hbV.aEH();
          this.hpx = paramMotionEvent.getX();
          this.hpy = paramMotionEvent.getY();
        }
      }
      for (;;)
      {
        this.hbV.t(paramMotionEvent);
        break;
        if (this.hbZ.right < this.hbZ.left) {
          break label664;
        }
        Log.i("FixRatioCropHelper", "moveDirection: RIGHT xDelta:" + (paramMotionEvent.getX() - this.hpx));
        i((int)(paramMotionEvent.getX() - this.hpx), this.hqk, this.hql);
        break label664;
        if ((this.hbZ.right < this.hbZ.left) || (this.hbZ.bottom < this.hbZ.top)) {
          break label664;
        }
        f1 = this.hpy - paramMotionEvent.getY();
        f2 = paramMotionEvent.getX() - this.hpx;
        Log.i("FixRatioCropHelper", "moveDirection: " + this.hqk + " xDelta:" + f2 + " yDelta:" + f1);
        if (Math.abs(f1) >= Math.abs(f2))
        {
          i((int)f1, this.hqk, this.hql);
          break label664;
        }
        i((int)f2, this.hqk, this.hql);
        break label664;
        if ((this.hbZ.right < this.hbZ.left) || (this.hbZ.bottom < this.hbZ.top)) {
          break label664;
        }
        f1 = paramMotionEvent.getY() - this.hpy;
        f2 = paramMotionEvent.getX() - this.hpx;
        Log.i("FixRatioCropHelper", "moveDirection: " + this.hqk + " xDelta:" + f2 + " yDelta:" + f1);
        if (Math.abs(f1) >= Math.abs(f2 / this.hqj))
        {
          Log.i("FixRatioCropHelper", "moveDirection: " + this.hqk + " yDelta:" + f1);
          d((int)f1, this.hqk, this.hql);
          break label664;
        }
        Log.i("FixRatioCropHelper", "moveDirection: " + this.hqk + " xDelta:" + f2 / this.hqj);
        d((int)(f2 / this.hqj), this.hqk, this.hql);
        break label664;
        Log.i("FixRatioCropHelper", "moveDirection: LEFT xDelta:" + (this.hpx - paramMotionEvent.getX()));
        if (this.hbZ.right < this.hbZ.left) {
          break label664;
        }
        g((int)(this.hpx - paramMotionEvent.getX()), this.hqk, this.hql);
        break label664;
        if ((this.hbZ.right < this.hbZ.left) || (this.hbZ.bottom < this.hbZ.top)) {
          break label664;
        }
        f1 = this.hpy - paramMotionEvent.getY();
        f2 = this.hpx - paramMotionEvent.getX();
        Log.i("FixRatioCropHelper", "moveDirection: " + this.hqk + " xDelta:" + f2 + " yDelta:" + f1);
        if (Math.abs(f1) >= Math.abs(f2))
        {
          c((int)f1, this.hqk, this.hql);
          break label664;
        }
        c((int)f2, this.hqk, this.hql);
        break label664;
        if ((this.hbZ.right < this.hbZ.left) || (this.hbZ.bottom < this.hbZ.top)) {
          break label664;
        }
        f1 = paramMotionEvent.getY() - this.hpy;
        f2 = this.hpx - paramMotionEvent.getX();
        Log.i("FixRatioCropHelper", "moveDirection: " + this.hqk + " xDelta:" + f2 + " yDelta:" + f1);
        if (Math.abs(f1) >= Math.abs(f2))
        {
          g((int)f1, this.hqk, this.hql);
          break label664;
        }
        g((int)f2, this.hqk, this.hql);
        break label664;
        if (this.hbZ.bottom < this.hbZ.top) {
          break label664;
        }
        c((int)(this.hpy - paramMotionEvent.getY()), this.hqk, this.hql);
        break label664;
        if (this.hbZ.bottom < this.hbZ.top) {
          break label664;
        }
        d((int)(paramMotionEvent.getY() - this.hpy), this.hqk, this.hql);
        break label664;
        this.hpr = false;
      }
    }
    f1 = this.hpl.width() * 1.0F / this.hbZ.width();
    float f2 = this.hpl.height() * 1.0F / this.hbZ.height();
    label1657:
    long l;
    if (f1 < f2)
    {
      f2 = this.hpl.centerX();
      float f3 = this.hpl.centerY();
      float f4 = this.hbZ.centerX();
      float f5 = this.hbZ.centerY();
      paramMotionEvent = h.ahAA;
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231856);
          g.this.hbV.hpp.hcc = 1000L;
          g.this.hbV.hpp.a(f1, g.this.hbZ, this.hpI, this.hpJ);
          g.this.hbV.hpp.play();
          AppMethodBeat.o(231856);
        }
      };
      if (!this.hpr) {
        break label1773;
      }
      l = 0L;
      label1730:
      paramMotionEvent.o((Runnable)localObject, l);
      if (this.hqk <= 0) {
        break label1781;
      }
    }
    label1773:
    label1781:
    for (this.hpr = true;; this.hpr = false)
    {
      this.hqk = 0;
      this.hbV.aEI();
      break;
      f1 = f2;
      break label1657;
      l = 100L;
      break label1730;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.e.g
 * JD-Core Version:    0.7.0.1
 */