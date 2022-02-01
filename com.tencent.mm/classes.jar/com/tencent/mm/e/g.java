package com.tencent.mm.e;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class g
{
  c dgO;
  Rect dgS;
  float dsA;
  float dsB;
  float dsC;
  float dsD;
  private int dsd;
  Rect dsl;
  private boolean dsr;
  private float dsy;
  private float dsz;
  float dtn;
  private int dto;
  private Rect dtp;
  int dtq;
  int dtr;
  int dtt;
  int dtu;
  
  public g(c paramc, float paramFloat, Rect paramRect)
  {
    AppMethodBeat.i(204729);
    this.dsd = ((int)MMApplicationContext.getResources().getDimension(2131165963));
    this.dto = 0;
    this.dsr = false;
    this.dtn = paramFloat;
    this.dgO = paramc;
    this.dgS = paramRect;
    this.dsl = paramc.dsl;
    AppMethodBeat.o(204729);
  }
  
  private void a(RectF paramRectF, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(204735);
    Log.i("FixRatioCropHelper", "translateImage cropDirection:" + paramInt + " eventPosDelta:" + paramFloat);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(204735);
      return;
      if (((int)paramRectF.bottom <= (int)this.dsB) && ((int)paramRectF.bottom <= this.dgS.bottom))
      {
        if (paramFloat > this.dsB - paramRectF.bottom)
        {
          Log.i("FixRatioCropHelper", "translateImage bottom 11:" + (this.dsB - paramRectF.bottom));
          getMainMatrix().postTranslate(0.0F, this.dsB - paramRectF.bottom);
          AppMethodBeat.o(204735);
          return;
        }
        Log.i("FixRatioCropHelper", "translateImage bottom 22:".concat(String.valueOf(paramFloat)));
        getMainMatrix().postTranslate(0.0F, paramFloat);
        AppMethodBeat.o(204735);
        return;
      }
      Log.i("FixRatioCropHelper", "translateImage bottom else :".concat(String.valueOf(paramFloat)));
      AppMethodBeat.o(204735);
      return;
      if (((int)paramRectF.top >= (int)this.dsA) && ((int)paramRectF.top >= this.dgS.top))
      {
        if (paramFloat > paramRectF.top - this.dsA)
        {
          Log.i("FixRatioCropHelper", "translateImage imageRect.top - mEdgeTop - imageRect.left:" + (paramRectF.top - this.dsA));
          getMainMatrix().postTranslate(0.0F, this.dsA - paramRectF.top);
          AppMethodBeat.o(204735);
          return;
        }
        Log.i("FixRatioCropHelper", "translateImage top eventPosDelta:".concat(String.valueOf(paramFloat)));
        getMainMatrix().postTranslate(0.0F, paramFloat);
        AppMethodBeat.o(204735);
        return;
        if (((int)paramRectF.right <= (int)this.dsD) && ((int)paramRectF.right <= this.dgS.right))
        {
          if (paramFloat > this.dsD - paramRectF.right)
          {
            getMainMatrix().postTranslate(this.dsD - paramRectF.right, 0.0F);
            AppMethodBeat.o(204735);
            return;
          }
          getMainMatrix().postTranslate(paramFloat, 0.0F);
          AppMethodBeat.o(204735);
          return;
          Log.i("FixRatioCropHelper", "translateImage LEFT begin");
          if (((int)paramRectF.left >= (int)this.dsC) && ((int)paramRectF.left >= this.dgS.left))
          {
            if (paramFloat > paramRectF.left - this.dsC)
            {
              Log.i("FixRatioCropHelper", "translateImage left mEdgeLeft - imageRect.left:" + (this.dsC - paramRectF.left));
              getMainMatrix().postTranslate(this.dsC - paramRectF.left, 0.0F);
              AppMethodBeat.o(204735);
              return;
            }
            Log.i("FixRatioCropHelper", "translateImage left eventPosDelta:".concat(String.valueOf(paramFloat)));
            getMainMatrix().postTranslate(paramFloat, 0.0F);
            AppMethodBeat.o(204735);
            return;
          }
          Log.i("FixRatioCropHelper", "translateImage LEFT else");
        }
      }
    }
  }
  
  private void a(RectF paramRectF, int paramInt)
  {
    AppMethodBeat.i(204733);
    Log.i("FixRatioCropHelper", "scaleImage cropDirection:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(204733);
      return;
      float f;
      if ((this.dgS.height() > paramRectF.height()) && (this.dgS.bottom < this.dsl.bottom))
      {
        f = this.dgS.height() / paramRectF.height();
        getMainMatrix().postScale(f, f, this.dgS.centerX(), this.dgS.top);
        Log.i("FixRatioCropHelper", "scaleImage bottom 11 :".concat(String.valueOf(f)));
      }
      if (this.dgS.width() > paramRectF.width())
      {
        f = this.dgS.width() / paramRectF.width();
        getMainMatrix().postScale(f, f, this.dgS.centerX(), this.dgS.top);
        Log.i("FixRatioCropHelper", "scaleImage bottom 22 :".concat(String.valueOf(f)));
        AppMethodBeat.o(204733);
        return;
        if ((this.dgS.height() > paramRectF.height()) && (this.dgS.top > this.dsl.top))
        {
          f = this.dgS.height() / paramRectF.height();
          Log.i("FixRatioCropHelper", "scaleImage TOP 11 :".concat(String.valueOf(f)));
          getMainMatrix().postScale(f, f, this.dgS.centerX(), this.dgS.bottom);
        }
        if (this.dgS.width() > paramRectF.width())
        {
          f = this.dgS.width() / paramRectF.width();
          Log.i("FixRatioCropHelper", "scaleImage TOP 22 :".concat(String.valueOf(f)));
          getMainMatrix().postScale(f, f, this.dgS.centerX(), this.dgS.bottom);
          AppMethodBeat.o(204733);
          return;
          if ((this.dgS.width() > paramRectF.width()) && (this.dgS.right < this.dsl.right))
          {
            f = this.dgS.width() / paramRectF.width();
            Log.i("FixRatioCropHelper", "scaleImage RIGHT 11 :".concat(String.valueOf(f)));
            getMainMatrix().postScale(f, f, this.dgS.left, this.dgS.centerY());
          }
          if (this.dgS.height() > paramRectF.height())
          {
            f = this.dgS.height() / paramRectF.height();
            Log.i("FixRatioCropHelper", "scaleImage RIGHT 22 :".concat(String.valueOf(f)));
            getMainMatrix().postScale(f, f, this.dgS.left, this.dgS.centerY());
            AppMethodBeat.o(204733);
            return;
            if ((this.dgS.width() > paramRectF.width()) && (this.dgS.left > this.dsl.left))
            {
              f = this.dgS.width() / paramRectF.width();
              Log.i("FixRatioCropHelper", "scaleImage LEFT 11 :".concat(String.valueOf(f)));
              getMainMatrix().postScale(f, f, this.dgS.right, this.dgS.centerY());
            }
            if (this.dgS.height() > paramRectF.height())
            {
              f = this.dgS.height() / paramRectF.height();
              Log.i("FixRatioCropHelper", "scaleImage LEFT 22 :".concat(String.valueOf(f)));
              getMainMatrix().postScale(f, f, this.dgS.right, this.dgS.centerY());
            }
          }
        }
      }
    }
  }
  
  private void b(RectF paramRectF, int paramInt)
  {
    AppMethodBeat.i(204734);
    if ((paramInt & 0x1) == 1) {
      a(paramRectF, this.dgS.left - this.dtp.left, 1);
    }
    if ((paramInt & 0x4) == 4) {
      a(paramRectF, this.dgS.right - this.dtp.right, 4);
    }
    if ((paramInt & 0x2) == 2) {
      a(paramRectF, this.dgS.top - this.dtp.top, 2);
    }
    if ((paramInt & 0x8) == 8) {
      a(paramRectF, this.dgS.bottom - this.dtp.bottom, 8);
    }
    AppMethodBeat.o(204734);
  }
  
  private void c(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(204731);
    if (this.dgS.top >= this.dsl.top)
    {
      if (paramInt1 > this.dgS.top - this.dsl.top) {
        e(this.dsl.top, paramInt2, paramRect);
      }
    }
    else
    {
      if (this.dgS.top > this.dgS.bottom - this.dsd * 2) {
        e(this.dgS.bottom - this.dsd * 2, paramInt2, paramRect);
      }
      if (this.dgS.top < this.dsl.top) {
        e(this.dsl.top, paramInt2, paramRect);
      }
      paramRect = this.dgO.drS.gth().getBaseBoardView().getCurImageRect();
      if (paramInt2 <= 2) {
        break label188;
      }
      b(paramRect, paramInt2);
    }
    for (;;)
    {
      a(paramRect, 2);
      AppMethodBeat.o(204731);
      return;
      e(this.dgS.top - paramInt1, paramInt2, paramRect);
      break;
      label188:
      b(paramRect, 2);
      b(paramRect, 1);
      b(paramRect, 4);
    }
  }
  
  private void d(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(204732);
    if (this.dgS.bottom <= this.dsl.bottom)
    {
      if (paramInt1 <= this.dsl.bottom - this.dgS.bottom) {
        break label174;
      }
      f(this.dsl.bottom, paramInt2, paramRect);
      if (this.dgS.bottom < this.dgS.top + this.dsd * 2) {
        f(this.dgS.top + this.dsd * 2, paramInt2, paramRect);
      }
      if (this.dgS.bottom > this.dsl.bottom) {
        f(this.dgS.bottom, paramInt2, paramRect);
      }
      paramRect = this.dgO.drS.gth().getBaseBoardView().getCurImageRect();
      if (paramInt2 <= 8) {
        break label192;
      }
      b(paramRect, paramInt2);
    }
    for (;;)
    {
      a(paramRect, 8);
      AppMethodBeat.o(204732);
      return;
      label174:
      f(this.dgS.bottom + paramInt1, paramInt2, paramRect);
      break;
      label192:
      b(paramRect, 8);
      b(paramRect, 1);
      b(paramRect, 4);
    }
  }
  
  private void e(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(204736);
    int i;
    for (;;)
    {
      i = (int)((paramRect.bottom - paramInt1) * this.dtn);
      switch (paramInt2)
      {
      case 4: 
      case 5: 
      default: 
        AppMethodBeat.o(204736);
        return;
      case 2: 
        paramInt2 = paramRect.centerX();
        this.dtu = (paramInt2 - i / 2);
        this.dtt = (i / 2 + paramInt2);
        if (paramInt2 < this.dsl.centerX())
        {
          if (this.dtu >= this.dsl.left) {
            break label138;
          }
          paramInt2 = 6;
        }
        else
        {
          if (this.dtt <= this.dsl.right) {
            break label138;
          }
          paramInt2 = 3;
        }
        break;
      }
    }
    label138:
    this.dgS.left = this.dtu;
    do
    {
      this.dgS.right = this.dtt;
      this.dgS.top = paramInt1;
      break;
      this.dtu = (paramRect.right - i);
      if (this.dtu < this.dsl.left)
      {
        paramInt1 = paramRect.right;
        paramInt2 = this.dsl.left;
        this.dgS.left = this.dsl.left;
        this.dgS.top = ((int)(paramRect.bottom - (paramInt1 - paramInt2) / this.dtn));
        AppMethodBeat.o(204736);
        return;
      }
      this.dgS.left = this.dtu;
      this.dgS.top = paramInt1;
      AppMethodBeat.o(204736);
      return;
      this.dtt = (i + paramRect.left);
    } while (this.dgS.right <= this.dsl.right);
    paramInt1 = this.dsl.right;
    paramInt2 = paramRect.left;
    this.dgS.right = this.dsl.right;
    this.dgS.top = ((int)(paramRect.bottom - (paramInt1 - paramInt2) / this.dtn));
    AppMethodBeat.o(204736);
  }
  
  private void f(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(204737);
    int i;
    for (;;)
    {
      i = (int)((paramInt1 - paramRect.top) * this.dtn);
      switch (paramInt2)
      {
      case 10: 
      case 11: 
      default: 
        AppMethodBeat.o(204737);
        return;
      case 8: 
        paramInt2 = paramRect.centerX();
        this.dtu = (paramInt2 - i / 2);
        this.dtt = (i / 2 + paramInt2);
        if (paramInt2 < this.dsl.centerX())
        {
          if (this.dtu >= this.dsl.left) {
            break label155;
          }
          Log.i("FixRatioCropHelper", "change direct to right_bottom");
          paramInt2 = 12;
        }
        else
        {
          if (this.dtt <= this.dsl.right) {
            break label155;
          }
          Log.i("FixRatioCropHelper", "change direct to RIGHT_TOP");
          paramInt2 = 9;
        }
        break;
      }
    }
    label155:
    this.dgS.left = this.dtu;
    do
    {
      this.dgS.right = this.dtt;
      this.dgS.bottom = paramInt1;
      break;
      this.dtu = (paramRect.right - i);
      Log.i("FixRatioCropHelper", "adjustBottom RIGHT_BOTTOM :" + this.dgS);
      if (this.dtu < this.dsl.left)
      {
        paramInt1 = paramRect.right;
        paramInt2 = this.dsl.left;
        this.dgS.left = this.dsl.left;
        Rect localRect = this.dgS;
        f = paramRect.top;
        localRect.bottom = ((int)((paramInt1 - paramInt2) / this.dtn + f));
        AppMethodBeat.o(204737);
        return;
      }
      this.dgS.left = this.dtu;
      this.dgS.bottom = paramInt1;
      AppMethodBeat.o(204737);
      return;
      this.dtt = (i + paramRect.left);
      Log.i("FixRatioCropHelper", "adjustBottom RIGHT_BOTTOM" + this.dgS);
    } while (this.dtt <= this.dsl.right);
    paramInt1 = this.dsl.right;
    paramInt2 = paramRect.left;
    this.dgS.right = this.dsl.right;
    paramRect = this.dgS;
    float f = this.dgS.top;
    paramRect.bottom = ((int)((paramInt1 - paramInt2) / this.dtn + f));
    AppMethodBeat.o(204737);
  }
  
  private void g(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(204738);
    if (this.dgS.left >= this.dsl.left)
    {
      if (paramInt1 > this.dgS.left - this.dsl.left) {
        h(this.dsl.left, paramInt2, paramRect);
      }
    }
    else
    {
      if (this.dgS.left > this.dgS.right - this.dsd * 2) {
        h(this.dgS.right - this.dsd * 2, paramInt2, paramRect);
      }
      if (this.dgS.left < this.dsl.left) {
        h(this.dsl.left, paramInt2, paramRect);
      }
      paramRect = this.dgO.drS.gth().getBaseBoardView().getCurImageRect();
      if (paramInt2 <= 1) {
        break label190;
      }
      b(paramRect, paramInt2);
    }
    for (;;)
    {
      a(paramRect, 1);
      AppMethodBeat.o(204738);
      return;
      h(this.dgS.left - paramInt1, paramInt2, paramRect);
      break;
      label190:
      b(paramRect, 1);
      b(paramRect, 8);
      b(paramRect, 2);
    }
  }
  
  private Matrix getMainMatrix()
  {
    AppMethodBeat.i(204742);
    Matrix localMatrix = this.dgO.drS.gth().getBaseBoardView().getMainMatrix();
    AppMethodBeat.o(204742);
    return localMatrix;
  }
  
  private void h(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(204739);
    int i;
    for (;;)
    {
      i = (int)((paramRect.right - paramInt1) / this.dtn);
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(204739);
        return;
      case 1: 
        float f = paramRect.centerY();
        this.dtq = ((int)(f - i / 2));
        this.dtr = ((int)(i / 2 + f));
        Log.i("FixRatioCropHelper", "adjustLeft :" + this.dgS + " LEFT");
        if (f >= this.dsl.centerY())
        {
          if (this.dtr <= this.dsl.bottom) {
            break label180;
          }
          paramInt2 = 3;
        }
        else
        {
          if (this.dtq >= this.dsl.top) {
            break label180;
          }
          paramInt2 = 9;
        }
        break;
      }
    }
    label180:
    this.dgS.top = this.dtq;
    do
    {
      this.dgS.bottom = this.dtr;
      this.dgS.left = paramInt1;
      break;
      this.dtq = (paramRect.bottom - i);
      if (this.dtq <= this.dsl.top)
      {
        paramInt1 = paramRect.bottom;
        paramInt2 = this.dsl.top;
        this.dgS.top = this.dsl.top;
      }
      for (this.dgS.left = ((int)(paramRect.right - (paramInt1 - paramInt2) * this.dtn));; this.dgS.left = paramInt1)
      {
        Log.i("FixRatioCropHelper", "adjustLeft :" + this.dgS + " LEFT_TOP");
        AppMethodBeat.o(204739);
        return;
        this.dgS.top = this.dtq;
      }
      this.dtr = (i + paramRect.top);
      Log.i("FixRatioCropHelper", "adjustLeft :" + this.dgS + " LEFT_BOTTOM");
    } while (this.dtr < this.dsl.bottom);
    paramInt1 = this.dsl.bottom;
    paramInt2 = paramRect.top;
    this.dgS.bottom = this.dsl.bottom;
    this.dgS.left = ((int)(paramRect.right - (paramInt1 - paramInt2) * this.dtn));
    AppMethodBeat.o(204739);
  }
  
  private void i(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(204740);
    if (this.dgS.right <= this.dsl.right)
    {
      if (paramInt1 > this.dsl.right - this.dgS.right)
      {
        Log.i("FixRatioCropHelper", "changeRight outof bound:");
        j(this.dsl.right, paramInt2, paramRect);
      }
    }
    else
    {
      if (this.dgS.right < this.dgS.left + this.dsd * 2)
      {
        Log.i("FixRatioCropHelper", "changeRight < 2 padding>: " + this.dgS.right);
        j(this.dgS.left + this.dsd * 2, paramInt2, paramRect);
      }
      if (this.dgS.right > this.dsl.right)
      {
        Log.i("FixRatioCropHelper", "changeRight after out of bound>: " + this.dgS.right);
        j(this.dsl.right, paramInt2, paramRect);
      }
      paramRect = this.dgO.drS.gth().getBaseBoardView().getCurImageRect();
      if (paramInt2 <= 4) {
        break label269;
      }
      b(paramRect, paramInt2);
    }
    for (;;)
    {
      a(paramRect, 4);
      AppMethodBeat.o(204740);
      return;
      Log.i("FixRatioCropHelper", "changeRight normal eventPosDelta: ".concat(String.valueOf(paramInt1)));
      j(this.dgS.right + paramInt1, paramInt2, paramRect);
      break;
      label269:
      b(paramRect, 4);
      b(paramRect, 8);
      b(paramRect, 2);
    }
  }
  
  private void j(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(204741);
    int i = (int)((paramInt1 - paramRect.left) / this.dtn);
    Log.i("FixRatioCropHelper", "adjustRight delta:".concat(String.valueOf(i)));
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(204741);
      return;
      paramInt2 = paramRect.centerY();
      this.dtq = (paramInt2 - i / 2);
      this.dtr = (i / 2 + paramInt2);
      Log.i("FixRatioCropHelper", "adjustRight right mBoxRect :" + this.dgS);
      if (paramInt2 > this.dsl.centerY())
      {
        if (this.dtr <= this.dsl.bottom) {
          break label180;
        }
        paramInt2 = 6;
        break;
      }
      if (this.dtq < this.dsl.top)
      {
        paramInt2 = 12;
        break;
      }
      label180:
      this.dgS.right = paramInt1;
      this.dgS.top = this.dtq;
      this.dgS.bottom = this.dtr;
      AppMethodBeat.o(204741);
      return;
      this.dtq = (paramRect.bottom - i);
      Log.i("FixRatioCropHelper", "adjustRight RIGHT_TOP mBoxRect :" + this.dgS);
      if (this.dtq < this.dsl.top)
      {
        paramInt1 = paramRect.bottom;
        paramInt2 = this.dsl.top;
        this.dgS.top = this.dsl.top;
        paramRect = this.dgS;
        float f = this.dgS.left;
        paramRect.right = ((int)((paramInt1 - paramInt2) * this.dtn + f));
        AppMethodBeat.o(204741);
        return;
      }
      this.dgS.top = this.dtq;
      this.dgS.right = paramInt1;
      AppMethodBeat.o(204741);
      return;
      this.dtr = (i + paramRect.top);
      Log.i("FixRatioCropHelper", "adjustRight RIGHT_BOTTOM mBoxRect.top :" + this.dgS);
      if (this.dgS.bottom > this.dsl.bottom)
      {
        paramInt1 = this.dsl.bottom;
        paramInt2 = paramRect.top;
        this.dgS.bottom = this.dsl.bottom;
        this.dgS.right = (paramInt1 - paramInt2 + this.dgS.left);
        AppMethodBeat.o(204741);
        return;
      }
      this.dgS.bottom = this.dtr;
      this.dgS.right = paramInt1;
    }
  }
  
  final boolean v(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204730);
    Object localObject = this.dgO.drS.gth().getBaseBoardView().getCurImageRect();
    this.dsA = (((RectF)localObject).top - (((RectF)localObject).bottom - this.dgS.bottom));
    this.dsB = (((RectF)localObject).bottom + (this.dgS.top - ((RectF)localObject).top));
    this.dsC = (((RectF)localObject).left - (((RectF)localObject).right - this.dgS.right));
    final float f1 = ((RectF)localObject).right;
    this.dsD = (this.dgS.left - ((RectF)localObject).left + f1);
    if (this.dsD > this.dsl.right) {
      this.dsD = this.dsl.right;
    }
    if (this.dsC < this.dsd) {
      this.dsC = this.dsd;
    }
    if (this.dsB > this.dsl.bottom) {
      this.dsB = this.dsl.bottom;
    }
    if (this.dsA < this.dsd) {
      this.dsA = this.dsd;
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
          boolean bool = this.dsr;
          AppMethodBeat.o(204730);
          return bool;
          this.dto = 0;
          this.dsr = false;
          continue;
          Log.i("FixRatioCropHelper", "ACTION_DOWN moveDirection :" + this.dto);
          this.dsr = false;
          if (this.dgO.dsp != null) {
            this.dgO.dsp.cancel();
          }
          if (this.dgO.dsi.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.dto |= 0x8;
          }
          if (this.dgO.dsh.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.dto |= 0x2;
          }
          if (this.dgO.dsj.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.dto |= 0x1;
          }
          if (this.dgO.dsk.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.dto |= 0x4;
          }
          this.dgO.dsx = false;
          if (this.dto > 0)
          {
            this.dsr = true;
            this.dsy = paramMotionEvent.getX();
            this.dsz = paramMotionEvent.getY();
          }
        }
      } while (!this.dsr);
      Log.i("FixRatioCropHelper", "ACTION_MOVE moveDirection :" + this.dto + "mBoxRect：" + this.dgS + " originRect:" + this.dtp);
      this.dtp = new Rect(this.dgS);
      if ((paramMotionEvent.getPointerCount() == 1) && (this.dto > 0)) {
        switch (this.dto)
        {
        case 5: 
        case 7: 
        case 10: 
        case 11: 
        default: 
          label664:
          this.dgO.Ye();
          this.dsr = true;
          this.dgO.Yb();
          this.dsy = paramMotionEvent.getX();
          this.dsz = paramMotionEvent.getY();
        }
      }
      for (;;)
      {
        this.dgO.t(paramMotionEvent);
        break;
        if (this.dgS.right < this.dgS.left) {
          break label664;
        }
        Log.i("FixRatioCropHelper", "moveDirection: RIGHT xDelta:" + (paramMotionEvent.getX() - this.dsy));
        i((int)(paramMotionEvent.getX() - this.dsy), this.dto, this.dtp);
        break label664;
        if ((this.dgS.right < this.dgS.left) || (this.dgS.bottom < this.dgS.top)) {
          break label664;
        }
        f1 = this.dsz - paramMotionEvent.getY();
        f2 = paramMotionEvent.getX() - this.dsy;
        Log.i("FixRatioCropHelper", "moveDirection: " + this.dto + " xDelta:" + f2 + " yDelta:" + f1);
        if (Math.abs(f1) >= Math.abs(f2))
        {
          i((int)f1, this.dto, this.dtp);
          break label664;
        }
        i((int)f2, this.dto, this.dtp);
        break label664;
        if ((this.dgS.right < this.dgS.left) || (this.dgS.bottom < this.dgS.top)) {
          break label664;
        }
        f1 = paramMotionEvent.getY() - this.dsz;
        f2 = paramMotionEvent.getX() - this.dsy;
        Log.i("FixRatioCropHelper", "moveDirection: " + this.dto + " xDelta:" + f2 + " yDelta:" + f1);
        if (Math.abs(f1) >= Math.abs(f2 / this.dtn))
        {
          Log.i("FixRatioCropHelper", "moveDirection: " + this.dto + " yDelta:" + f1);
          d((int)f1, this.dto, this.dtp);
          break label664;
        }
        Log.i("FixRatioCropHelper", "moveDirection: " + this.dto + " xDelta:" + f2 / this.dtn);
        d((int)(f2 / this.dtn), this.dto, this.dtp);
        break label664;
        Log.i("FixRatioCropHelper", "moveDirection: LEFT xDelta:" + (this.dsy - paramMotionEvent.getX()));
        if (this.dgS.right < this.dgS.left) {
          break label664;
        }
        g((int)(this.dsy - paramMotionEvent.getX()), this.dto, this.dtp);
        break label664;
        if ((this.dgS.right < this.dgS.left) || (this.dgS.bottom < this.dgS.top)) {
          break label664;
        }
        f1 = this.dsz - paramMotionEvent.getY();
        f2 = this.dsy - paramMotionEvent.getX();
        Log.i("FixRatioCropHelper", "moveDirection: " + this.dto + " xDelta:" + f2 + " yDelta:" + f1);
        if (Math.abs(f1) >= Math.abs(f2))
        {
          c((int)f1, this.dto, this.dtp);
          break label664;
        }
        c((int)f2, this.dto, this.dtp);
        break label664;
        if ((this.dgS.right < this.dgS.left) || (this.dgS.bottom < this.dgS.top)) {
          break label664;
        }
        f1 = paramMotionEvent.getY() - this.dsz;
        f2 = this.dsy - paramMotionEvent.getX();
        Log.i("FixRatioCropHelper", "moveDirection: " + this.dto + " xDelta:" + f2 + " yDelta:" + f1);
        if (Math.abs(f1) >= Math.abs(f2))
        {
          g((int)f1, this.dto, this.dtp);
          break label664;
        }
        g((int)f2, this.dto, this.dtp);
        break label664;
        if (this.dgS.bottom < this.dgS.top) {
          break label664;
        }
        c((int)(this.dsz - paramMotionEvent.getY()), this.dto, this.dtp);
        break label664;
        if (this.dgS.bottom < this.dgS.top) {
          break label664;
        }
        d((int)(paramMotionEvent.getY() - this.dsz), this.dto, this.dtp);
        break label664;
        this.dsr = false;
      }
    }
    f1 = this.dsl.width() * 1.0F / this.dgS.width();
    float f2 = this.dsl.height() * 1.0F / this.dgS.height();
    label1657:
    long l;
    if (f1 < f2)
    {
      f2 = this.dsl.centerX();
      float f3 = this.dsl.centerY();
      float f4 = this.dgS.centerX();
      float f5 = this.dgS.centerY();
      paramMotionEvent = h.RTc;
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(204728);
          g.this.dgO.dsp.dgV = 1000L;
          g.this.dgO.dsp.a(f1, g.this.dgS, this.dsK, this.dsL);
          g.this.dgO.dsp.play();
          AppMethodBeat.o(204728);
        }
      };
      if (!this.dsr) {
        break label1773;
      }
      l = 0L;
      label1730:
      paramMotionEvent.n((Runnable)localObject, l);
      if (this.dto <= 0) {
        break label1781;
      }
    }
    label1773:
    label1781:
    for (this.dsr = true;; this.dsr = false)
    {
      this.dto = 0;
      this.dgO.Yc();
      break;
      f1 = f2;
      break label1657;
      l = 100L;
      break label1730;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.e.g
 * JD-Core Version:    0.7.0.1
 */