package com.tencent.mm.e;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class g
{
  c eYv;
  Rect eYz;
  private int fkQ;
  Rect fkY;
  float flW;
  private int flX;
  private Rect flY;
  int flZ;
  private boolean fle;
  private float flk;
  private float fll;
  float flm;
  float fln;
  float flo;
  float flp;
  int fma;
  int fmb;
  int fmc;
  
  public g(c paramc, float paramFloat, Rect paramRect)
  {
    AppMethodBeat.i(260032);
    this.fkQ = ((int)MMApplicationContext.getResources().getDimension(a.c.box_padding));
    this.flX = 0;
    this.fle = false;
    this.flW = paramFloat;
    this.eYv = paramc;
    this.eYz = paramRect;
    this.fkY = paramc.fkY;
    AppMethodBeat.o(260032);
  }
  
  private void a(RectF paramRectF, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(260052);
    Log.i("FixRatioCropHelper", "translateImage cropDirection:" + paramInt + " eventPosDelta:" + paramFloat);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(260052);
      return;
      if (((int)paramRectF.bottom <= (int)this.fln) && ((int)paramRectF.bottom <= this.eYz.bottom))
      {
        if (paramFloat > this.fln - paramRectF.bottom)
        {
          Log.i("FixRatioCropHelper", "translateImage bottom 11:" + (this.fln - paramRectF.bottom));
          getMainMatrix().postTranslate(0.0F, this.fln - paramRectF.bottom);
          AppMethodBeat.o(260052);
          return;
        }
        Log.i("FixRatioCropHelper", "translateImage bottom 22:".concat(String.valueOf(paramFloat)));
        getMainMatrix().postTranslate(0.0F, paramFloat);
        AppMethodBeat.o(260052);
        return;
      }
      Log.i("FixRatioCropHelper", "translateImage bottom else :".concat(String.valueOf(paramFloat)));
      AppMethodBeat.o(260052);
      return;
      if (((int)paramRectF.top >= (int)this.flm) && ((int)paramRectF.top >= this.eYz.top))
      {
        if (paramFloat > paramRectF.top - this.flm)
        {
          Log.i("FixRatioCropHelper", "translateImage imageRect.top - mEdgeTop - imageRect.left:" + (paramRectF.top - this.flm));
          getMainMatrix().postTranslate(0.0F, this.flm - paramRectF.top);
          AppMethodBeat.o(260052);
          return;
        }
        Log.i("FixRatioCropHelper", "translateImage top eventPosDelta:".concat(String.valueOf(paramFloat)));
        getMainMatrix().postTranslate(0.0F, paramFloat);
        AppMethodBeat.o(260052);
        return;
        if (((int)paramRectF.right <= (int)this.flp) && ((int)paramRectF.right <= this.eYz.right))
        {
          if (paramFloat > this.flp - paramRectF.right)
          {
            getMainMatrix().postTranslate(this.flp - paramRectF.right, 0.0F);
            AppMethodBeat.o(260052);
            return;
          }
          getMainMatrix().postTranslate(paramFloat, 0.0F);
          AppMethodBeat.o(260052);
          return;
          Log.i("FixRatioCropHelper", "translateImage LEFT begin");
          if (((int)paramRectF.left >= (int)this.flo) && ((int)paramRectF.left >= this.eYz.left))
          {
            if (paramFloat > paramRectF.left - this.flo)
            {
              Log.i("FixRatioCropHelper", "translateImage left mEdgeLeft - imageRect.left:" + (this.flo - paramRectF.left));
              getMainMatrix().postTranslate(this.flo - paramRectF.left, 0.0F);
              AppMethodBeat.o(260052);
              return;
            }
            Log.i("FixRatioCropHelper", "translateImage left eventPosDelta:".concat(String.valueOf(paramFloat)));
            getMainMatrix().postTranslate(paramFloat, 0.0F);
            AppMethodBeat.o(260052);
            return;
          }
          Log.i("FixRatioCropHelper", "translateImage LEFT else");
        }
      }
    }
  }
  
  private void a(RectF paramRectF, int paramInt)
  {
    AppMethodBeat.i(260047);
    Log.i("FixRatioCropHelper", "scaleImage cropDirection:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(260047);
      return;
      float f;
      if ((this.eYz.height() > paramRectF.height()) && (this.eYz.bottom < this.fkY.bottom))
      {
        f = this.eYz.height() / paramRectF.height();
        getMainMatrix().postScale(f, f, this.eYz.centerX(), this.eYz.top);
        Log.i("FixRatioCropHelper", "scaleImage bottom 11 :".concat(String.valueOf(f)));
      }
      if (this.eYz.width() > paramRectF.width())
      {
        f = this.eYz.width() / paramRectF.width();
        getMainMatrix().postScale(f, f, this.eYz.centerX(), this.eYz.top);
        Log.i("FixRatioCropHelper", "scaleImage bottom 22 :".concat(String.valueOf(f)));
        AppMethodBeat.o(260047);
        return;
        if ((this.eYz.height() > paramRectF.height()) && (this.eYz.top > this.fkY.top))
        {
          f = this.eYz.height() / paramRectF.height();
          Log.i("FixRatioCropHelper", "scaleImage TOP 11 :".concat(String.valueOf(f)));
          getMainMatrix().postScale(f, f, this.eYz.centerX(), this.eYz.bottom);
        }
        if (this.eYz.width() > paramRectF.width())
        {
          f = this.eYz.width() / paramRectF.width();
          Log.i("FixRatioCropHelper", "scaleImage TOP 22 :".concat(String.valueOf(f)));
          getMainMatrix().postScale(f, f, this.eYz.centerX(), this.eYz.bottom);
          AppMethodBeat.o(260047);
          return;
          if ((this.eYz.width() > paramRectF.width()) && (this.eYz.right < this.fkY.right))
          {
            f = this.eYz.width() / paramRectF.width();
            Log.i("FixRatioCropHelper", "scaleImage RIGHT 11 :".concat(String.valueOf(f)));
            getMainMatrix().postScale(f, f, this.eYz.left, this.eYz.centerY());
          }
          if (this.eYz.height() > paramRectF.height())
          {
            f = this.eYz.height() / paramRectF.height();
            Log.i("FixRatioCropHelper", "scaleImage RIGHT 22 :".concat(String.valueOf(f)));
            getMainMatrix().postScale(f, f, this.eYz.left, this.eYz.centerY());
            AppMethodBeat.o(260047);
            return;
            if ((this.eYz.width() > paramRectF.width()) && (this.eYz.left > this.fkY.left))
            {
              f = this.eYz.width() / paramRectF.width();
              Log.i("FixRatioCropHelper", "scaleImage LEFT 11 :".concat(String.valueOf(f)));
              getMainMatrix().postScale(f, f, this.eYz.right, this.eYz.centerY());
            }
            if (this.eYz.height() > paramRectF.height())
            {
              f = this.eYz.height() / paramRectF.height();
              Log.i("FixRatioCropHelper", "scaleImage LEFT 22 :".concat(String.valueOf(f)));
              getMainMatrix().postScale(f, f, this.eYz.right, this.eYz.centerY());
            }
          }
        }
      }
    }
  }
  
  private void b(RectF paramRectF, int paramInt)
  {
    AppMethodBeat.i(260049);
    if ((paramInt & 0x1) == 1) {
      a(paramRectF, this.eYz.left - this.flY.left, 1);
    }
    if ((paramInt & 0x4) == 4) {
      a(paramRectF, this.eYz.right - this.flY.right, 4);
    }
    if ((paramInt & 0x2) == 2) {
      a(paramRectF, this.eYz.top - this.flY.top, 2);
    }
    if ((paramInt & 0x8) == 8) {
      a(paramRectF, this.eYz.bottom - this.flY.bottom, 8);
    }
    AppMethodBeat.o(260049);
  }
  
  private void c(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(260039);
    if (this.eYz.top >= this.fkY.top)
    {
      if (paramInt1 > this.eYz.top - this.fkY.top) {
        e(this.fkY.top, paramInt2, paramRect);
      }
    }
    else
    {
      if (this.eYz.top > this.eYz.bottom - this.fkQ * 2) {
        e(this.eYz.bottom - this.fkQ * 2, paramInt2, paramRect);
      }
      if (this.eYz.top < this.fkY.top) {
        e(this.fkY.top, paramInt2, paramRect);
      }
      paramRect = this.eYv.fkE.hou().getBaseBoardView().getCurImageRect();
      if (paramInt2 <= 2) {
        break label188;
      }
      b(paramRect, paramInt2);
    }
    for (;;)
    {
      a(paramRect, 2);
      AppMethodBeat.o(260039);
      return;
      e(this.eYz.top - paramInt1, paramInt2, paramRect);
      break;
      label188:
      b(paramRect, 2);
      b(paramRect, 1);
      b(paramRect, 4);
    }
  }
  
  private void d(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(260042);
    if (this.eYz.bottom <= this.fkY.bottom)
    {
      if (paramInt1 <= this.fkY.bottom - this.eYz.bottom) {
        break label174;
      }
      f(this.fkY.bottom, paramInt2, paramRect);
      if (this.eYz.bottom < this.eYz.top + this.fkQ * 2) {
        f(this.eYz.top + this.fkQ * 2, paramInt2, paramRect);
      }
      if (this.eYz.bottom > this.fkY.bottom) {
        f(this.eYz.bottom, paramInt2, paramRect);
      }
      paramRect = this.eYv.fkE.hou().getBaseBoardView().getCurImageRect();
      if (paramInt2 <= 8) {
        break label192;
      }
      b(paramRect, paramInt2);
    }
    for (;;)
    {
      a(paramRect, 8);
      AppMethodBeat.o(260042);
      return;
      label174:
      f(this.eYz.bottom + paramInt1, paramInt2, paramRect);
      break;
      label192:
      b(paramRect, 8);
      b(paramRect, 1);
      b(paramRect, 4);
    }
  }
  
  private void e(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(260056);
    int i;
    for (;;)
    {
      i = (int)((paramRect.bottom - paramInt1) * this.flW);
      switch (paramInt2)
      {
      case 4: 
      case 5: 
      default: 
        AppMethodBeat.o(260056);
        return;
      case 2: 
        paramInt2 = paramRect.centerX();
        this.fmc = (paramInt2 - i / 2);
        this.fmb = (i / 2 + paramInt2);
        if (paramInt2 < this.fkY.centerX())
        {
          if (this.fmc >= this.fkY.left) {
            break label138;
          }
          paramInt2 = 6;
        }
        else
        {
          if (this.fmb <= this.fkY.right) {
            break label138;
          }
          paramInt2 = 3;
        }
        break;
      }
    }
    label138:
    this.eYz.left = this.fmc;
    do
    {
      this.eYz.right = this.fmb;
      this.eYz.top = paramInt1;
      break;
      this.fmc = (paramRect.right - i);
      if (this.fmc < this.fkY.left)
      {
        paramInt1 = paramRect.right;
        paramInt2 = this.fkY.left;
        this.eYz.left = this.fkY.left;
        this.eYz.top = ((int)(paramRect.bottom - (paramInt1 - paramInt2) / this.flW));
        AppMethodBeat.o(260056);
        return;
      }
      this.eYz.left = this.fmc;
      this.eYz.top = paramInt1;
      AppMethodBeat.o(260056);
      return;
      this.fmb = (i + paramRect.left);
    } while (this.eYz.right <= this.fkY.right);
    paramInt1 = this.fkY.right;
    paramInt2 = paramRect.left;
    this.eYz.right = this.fkY.right;
    this.eYz.top = ((int)(paramRect.bottom - (paramInt1 - paramInt2) / this.flW));
    AppMethodBeat.o(260056);
  }
  
  private void f(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(260060);
    int i;
    for (;;)
    {
      i = (int)((paramInt1 - paramRect.top) * this.flW);
      switch (paramInt2)
      {
      case 10: 
      case 11: 
      default: 
        AppMethodBeat.o(260060);
        return;
      case 8: 
        paramInt2 = paramRect.centerX();
        this.fmc = (paramInt2 - i / 2);
        this.fmb = (i / 2 + paramInt2);
        if (paramInt2 < this.fkY.centerX())
        {
          if (this.fmc >= this.fkY.left) {
            break label155;
          }
          Log.i("FixRatioCropHelper", "change direct to right_bottom");
          paramInt2 = 12;
        }
        else
        {
          if (this.fmb <= this.fkY.right) {
            break label155;
          }
          Log.i("FixRatioCropHelper", "change direct to RIGHT_TOP");
          paramInt2 = 9;
        }
        break;
      }
    }
    label155:
    this.eYz.left = this.fmc;
    do
    {
      this.eYz.right = this.fmb;
      this.eYz.bottom = paramInt1;
      break;
      this.fmc = (paramRect.right - i);
      Log.i("FixRatioCropHelper", "adjustBottom RIGHT_BOTTOM :" + this.eYz);
      if (this.fmc < this.fkY.left)
      {
        paramInt1 = paramRect.right;
        paramInt2 = this.fkY.left;
        this.eYz.left = this.fkY.left;
        Rect localRect = this.eYz;
        f = paramRect.top;
        localRect.bottom = ((int)((paramInt1 - paramInt2) / this.flW + f));
        AppMethodBeat.o(260060);
        return;
      }
      this.eYz.left = this.fmc;
      this.eYz.bottom = paramInt1;
      AppMethodBeat.o(260060);
      return;
      this.fmb = (i + paramRect.left);
      Log.i("FixRatioCropHelper", "adjustBottom RIGHT_BOTTOM" + this.eYz);
    } while (this.fmb <= this.fkY.right);
    paramInt1 = this.fkY.right;
    paramInt2 = paramRect.left;
    this.eYz.right = this.fkY.right;
    paramRect = this.eYz;
    float f = this.eYz.top;
    paramRect.bottom = ((int)((paramInt1 - paramInt2) / this.flW + f));
    AppMethodBeat.o(260060);
  }
  
  private void g(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(260062);
    if (this.eYz.left >= this.fkY.left)
    {
      if (paramInt1 > this.eYz.left - this.fkY.left) {
        h(this.fkY.left, paramInt2, paramRect);
      }
    }
    else
    {
      if (this.eYz.left > this.eYz.right - this.fkQ * 2) {
        h(this.eYz.right - this.fkQ * 2, paramInt2, paramRect);
      }
      if (this.eYz.left < this.fkY.left) {
        h(this.fkY.left, paramInt2, paramRect);
      }
      paramRect = this.eYv.fkE.hou().getBaseBoardView().getCurImageRect();
      if (paramInt2 <= 1) {
        break label190;
      }
      b(paramRect, paramInt2);
    }
    for (;;)
    {
      a(paramRect, 1);
      AppMethodBeat.o(260062);
      return;
      h(this.eYz.left - paramInt1, paramInt2, paramRect);
      break;
      label190:
      b(paramRect, 1);
      b(paramRect, 8);
      b(paramRect, 2);
    }
  }
  
  private Matrix getMainMatrix()
  {
    AppMethodBeat.i(260076);
    Matrix localMatrix = this.eYv.fkE.hou().getBaseBoardView().getMainMatrix();
    AppMethodBeat.o(260076);
    return localMatrix;
  }
  
  private void h(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(260067);
    int i;
    for (;;)
    {
      i = (int)((paramRect.right - paramInt1) / this.flW);
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(260067);
        return;
      case 1: 
        float f = paramRect.centerY();
        this.flZ = ((int)(f - i / 2));
        this.fma = ((int)(i / 2 + f));
        Log.i("FixRatioCropHelper", "adjustLeft :" + this.eYz + " LEFT");
        if (f >= this.fkY.centerY())
        {
          if (this.fma <= this.fkY.bottom) {
            break label180;
          }
          paramInt2 = 3;
        }
        else
        {
          if (this.flZ >= this.fkY.top) {
            break label180;
          }
          paramInt2 = 9;
        }
        break;
      }
    }
    label180:
    this.eYz.top = this.flZ;
    do
    {
      this.eYz.bottom = this.fma;
      this.eYz.left = paramInt1;
      break;
      this.flZ = (paramRect.bottom - i);
      if (this.flZ <= this.fkY.top)
      {
        paramInt1 = paramRect.bottom;
        paramInt2 = this.fkY.top;
        this.eYz.top = this.fkY.top;
      }
      for (this.eYz.left = ((int)(paramRect.right - (paramInt1 - paramInt2) * this.flW));; this.eYz.left = paramInt1)
      {
        Log.i("FixRatioCropHelper", "adjustLeft :" + this.eYz + " LEFT_TOP");
        AppMethodBeat.o(260067);
        return;
        this.eYz.top = this.flZ;
      }
      this.fma = (i + paramRect.top);
      Log.i("FixRatioCropHelper", "adjustLeft :" + this.eYz + " LEFT_BOTTOM");
    } while (this.fma < this.fkY.bottom);
    paramInt1 = this.fkY.bottom;
    paramInt2 = paramRect.top;
    this.eYz.bottom = this.fkY.bottom;
    this.eYz.left = ((int)(paramRect.right - (paramInt1 - paramInt2) * this.flW));
    AppMethodBeat.o(260067);
  }
  
  private void i(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(260069);
    if (this.eYz.right <= this.fkY.right)
    {
      if (paramInt1 > this.fkY.right - this.eYz.right)
      {
        Log.i("FixRatioCropHelper", "changeRight outof bound:");
        j(this.fkY.right, paramInt2, paramRect);
      }
    }
    else
    {
      if (this.eYz.right < this.eYz.left + this.fkQ * 2)
      {
        Log.i("FixRatioCropHelper", "changeRight < 2 padding>: " + this.eYz.right);
        j(this.eYz.left + this.fkQ * 2, paramInt2, paramRect);
      }
      if (this.eYz.right > this.fkY.right)
      {
        Log.i("FixRatioCropHelper", "changeRight after out of bound>: " + this.eYz.right);
        j(this.fkY.right, paramInt2, paramRect);
      }
      paramRect = this.eYv.fkE.hou().getBaseBoardView().getCurImageRect();
      if (paramInt2 <= 4) {
        break label269;
      }
      b(paramRect, paramInt2);
    }
    for (;;)
    {
      a(paramRect, 4);
      AppMethodBeat.o(260069);
      return;
      Log.i("FixRatioCropHelper", "changeRight normal eventPosDelta: ".concat(String.valueOf(paramInt1)));
      j(this.eYz.right + paramInt1, paramInt2, paramRect);
      break;
      label269:
      b(paramRect, 4);
      b(paramRect, 8);
      b(paramRect, 2);
    }
  }
  
  private void j(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(260074);
    int i = (int)((paramInt1 - paramRect.left) / this.flW);
    Log.i("FixRatioCropHelper", "adjustRight delta:".concat(String.valueOf(i)));
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(260074);
      return;
      paramInt2 = paramRect.centerY();
      this.flZ = (paramInt2 - i / 2);
      this.fma = (i / 2 + paramInt2);
      Log.i("FixRatioCropHelper", "adjustRight right mBoxRect :" + this.eYz);
      if (paramInt2 > this.fkY.centerY())
      {
        if (this.fma <= this.fkY.bottom) {
          break label180;
        }
        paramInt2 = 6;
        break;
      }
      if (this.flZ < this.fkY.top)
      {
        paramInt2 = 12;
        break;
      }
      label180:
      this.eYz.right = paramInt1;
      this.eYz.top = this.flZ;
      this.eYz.bottom = this.fma;
      AppMethodBeat.o(260074);
      return;
      this.flZ = (paramRect.bottom - i);
      Log.i("FixRatioCropHelper", "adjustRight RIGHT_TOP mBoxRect :" + this.eYz);
      if (this.flZ < this.fkY.top)
      {
        paramInt1 = paramRect.bottom;
        paramInt2 = this.fkY.top;
        this.eYz.top = this.fkY.top;
        paramRect = this.eYz;
        float f = this.eYz.left;
        paramRect.right = ((int)((paramInt1 - paramInt2) * this.flW + f));
        AppMethodBeat.o(260074);
        return;
      }
      this.eYz.top = this.flZ;
      this.eYz.right = paramInt1;
      AppMethodBeat.o(260074);
      return;
      this.fma = (i + paramRect.top);
      Log.i("FixRatioCropHelper", "adjustRight RIGHT_BOTTOM mBoxRect.top :" + this.eYz);
      if (this.eYz.bottom > this.fkY.bottom)
      {
        paramInt1 = this.fkY.bottom;
        paramInt2 = paramRect.top;
        this.eYz.bottom = this.fkY.bottom;
        this.eYz.right = (paramInt1 - paramInt2 + this.eYz.left);
        AppMethodBeat.o(260074);
        return;
      }
      this.eYz.bottom = this.fma;
      this.eYz.right = paramInt1;
    }
  }
  
  final boolean w(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(260037);
    Object localObject = this.eYv.fkE.hou().getBaseBoardView().getCurImageRect();
    this.flm = (((RectF)localObject).top - (((RectF)localObject).bottom - this.eYz.bottom));
    this.fln = (((RectF)localObject).bottom + (this.eYz.top - ((RectF)localObject).top));
    this.flo = (((RectF)localObject).left - (((RectF)localObject).right - this.eYz.right));
    final float f1 = ((RectF)localObject).right;
    this.flp = (this.eYz.left - ((RectF)localObject).left + f1);
    if (this.flp > this.fkY.right) {
      this.flp = this.fkY.right;
    }
    if (this.flo < this.fkQ) {
      this.flo = this.fkQ;
    }
    if (this.fln > this.fkY.bottom) {
      this.fln = this.fkY.bottom;
    }
    if (this.flm < this.fkQ) {
      this.flm = this.fkQ;
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
          boolean bool = this.fle;
          AppMethodBeat.o(260037);
          return bool;
          this.flX = 0;
          this.fle = false;
          continue;
          Log.i("FixRatioCropHelper", "ACTION_DOWN moveDirection :" + this.flX);
          this.fle = false;
          if (this.eYv.flc != null) {
            this.eYv.flc.cancel();
          }
          if (this.eYv.fkV.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.flX |= 0x8;
          }
          if (this.eYv.fkU.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.flX |= 0x2;
          }
          if (this.eYv.fkW.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.flX |= 0x1;
          }
          if (this.eYv.fkX.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.flX |= 0x4;
          }
          this.eYv.flj = false;
          if (this.flX > 0)
          {
            this.fle = true;
            this.flk = paramMotionEvent.getX();
            this.fll = paramMotionEvent.getY();
          }
        }
      } while (!this.fle);
      Log.i("FixRatioCropHelper", "ACTION_MOVE moveDirection :" + this.flX + "mBoxRect：" + this.eYz + " originRect:" + this.flY);
      this.flY = new Rect(this.eYz);
      if ((paramMotionEvent.getPointerCount() == 1) && (this.flX > 0)) {
        switch (this.flX)
        {
        case 5: 
        case 7: 
        case 10: 
        case 11: 
        default: 
          label664:
          this.eYv.acK();
          this.fle = true;
          this.eYv.acH();
          this.flk = paramMotionEvent.getX();
          this.fll = paramMotionEvent.getY();
        }
      }
      for (;;)
      {
        this.eYv.u(paramMotionEvent);
        break;
        if (this.eYz.right < this.eYz.left) {
          break label664;
        }
        Log.i("FixRatioCropHelper", "moveDirection: RIGHT xDelta:" + (paramMotionEvent.getX() - this.flk));
        i((int)(paramMotionEvent.getX() - this.flk), this.flX, this.flY);
        break label664;
        if ((this.eYz.right < this.eYz.left) || (this.eYz.bottom < this.eYz.top)) {
          break label664;
        }
        f1 = this.fll - paramMotionEvent.getY();
        f2 = paramMotionEvent.getX() - this.flk;
        Log.i("FixRatioCropHelper", "moveDirection: " + this.flX + " xDelta:" + f2 + " yDelta:" + f1);
        if (Math.abs(f1) >= Math.abs(f2))
        {
          i((int)f1, this.flX, this.flY);
          break label664;
        }
        i((int)f2, this.flX, this.flY);
        break label664;
        if ((this.eYz.right < this.eYz.left) || (this.eYz.bottom < this.eYz.top)) {
          break label664;
        }
        f1 = paramMotionEvent.getY() - this.fll;
        f2 = paramMotionEvent.getX() - this.flk;
        Log.i("FixRatioCropHelper", "moveDirection: " + this.flX + " xDelta:" + f2 + " yDelta:" + f1);
        if (Math.abs(f1) >= Math.abs(f2 / this.flW))
        {
          Log.i("FixRatioCropHelper", "moveDirection: " + this.flX + " yDelta:" + f1);
          d((int)f1, this.flX, this.flY);
          break label664;
        }
        Log.i("FixRatioCropHelper", "moveDirection: " + this.flX + " xDelta:" + f2 / this.flW);
        d((int)(f2 / this.flW), this.flX, this.flY);
        break label664;
        Log.i("FixRatioCropHelper", "moveDirection: LEFT xDelta:" + (this.flk - paramMotionEvent.getX()));
        if (this.eYz.right < this.eYz.left) {
          break label664;
        }
        g((int)(this.flk - paramMotionEvent.getX()), this.flX, this.flY);
        break label664;
        if ((this.eYz.right < this.eYz.left) || (this.eYz.bottom < this.eYz.top)) {
          break label664;
        }
        f1 = this.fll - paramMotionEvent.getY();
        f2 = this.flk - paramMotionEvent.getX();
        Log.i("FixRatioCropHelper", "moveDirection: " + this.flX + " xDelta:" + f2 + " yDelta:" + f1);
        if (Math.abs(f1) >= Math.abs(f2))
        {
          c((int)f1, this.flX, this.flY);
          break label664;
        }
        c((int)f2, this.flX, this.flY);
        break label664;
        if ((this.eYz.right < this.eYz.left) || (this.eYz.bottom < this.eYz.top)) {
          break label664;
        }
        f1 = paramMotionEvent.getY() - this.fll;
        f2 = this.flk - paramMotionEvent.getX();
        Log.i("FixRatioCropHelper", "moveDirection: " + this.flX + " xDelta:" + f2 + " yDelta:" + f1);
        if (Math.abs(f1) >= Math.abs(f2))
        {
          g((int)f1, this.flX, this.flY);
          break label664;
        }
        g((int)f2, this.flX, this.flY);
        break label664;
        if (this.eYz.bottom < this.eYz.top) {
          break label664;
        }
        c((int)(this.fll - paramMotionEvent.getY()), this.flX, this.flY);
        break label664;
        if (this.eYz.bottom < this.eYz.top) {
          break label664;
        }
        d((int)(paramMotionEvent.getY() - this.fll), this.flX, this.flY);
        break label664;
        this.fle = false;
      }
    }
    f1 = this.fkY.width() * 1.0F / this.eYz.width();
    float f2 = this.fkY.height() * 1.0F / this.eYz.height();
    label1657:
    long l;
    if (f1 < f2)
    {
      f2 = this.fkY.centerX();
      float f3 = this.fkY.centerY();
      float f4 = this.eYz.centerX();
      float f5 = this.eYz.centerY();
      paramMotionEvent = h.ZvG;
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(259762);
          g.this.eYv.flc.eYC = 1000L;
          g.this.eYv.flc.a(f1, g.this.eYz, this.flv, this.flw);
          g.this.eYv.flc.play();
          AppMethodBeat.o(259762);
        }
      };
      if (!this.fle) {
        break label1773;
      }
      l = 0L;
      label1730:
      paramMotionEvent.n((Runnable)localObject, l);
      if (this.flX <= 0) {
        break label1781;
      }
    }
    label1773:
    label1781:
    for (this.fle = true;; this.fle = false)
    {
      this.flX = 0;
      this.eYv.acI();
      break;
      f1 = f2;
      break label1657;
      l = 100L;
      break label1730;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.g
 * JD-Core Version:    0.7.0.1
 */