package com.tencent.mm.media.editor.c;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ab;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/touch/TouchTracker;", "", "()V", "TAG", "", "boundArrayDst", "", "getBoundArrayDst", "()[F", "setBoundArrayDst", "([F)V", "boundArrayOut", "getBoundArrayOut", "setBoundArrayOut", "boundArraySrc", "getBoundArraySrc", "setBoundArraySrc", "height", "", "getHeight", "()I", "setHeight", "(I)V", "holdX", "", "getHoldX", "()F", "setHoldX", "(F)V", "holdY", "getHoldY", "setHoldY", "holdingThreshold", "getHoldingThreshold", "setHoldingThreshold", "lastDrag", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "pIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pIndices", "pivotDst", "pivotType", "Lcom/tencent/mm/media/editor/touch/TouchTracker$PivotType;", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "state", "Lcom/tencent/mm/media/editor/touch/TouchTracker$TouchState;", "transStart", "transformBoundArray", "getTransformBoundArray", "setTransformBoundArray", "width", "getWidth", "setWidth", "appendTouchEvent", "", "event", "Landroid/view/MotionEvent;", "findIndices", "", "findMaxBottom", "findMaxRight", "findMinLeft", "findMinTop", "inSafeArea", "newLeft", "newTop", "newRight", "newBottom", "resetHold", "updateState", "PivotType", "TouchState", "plugin-mediaeditor_release"})
public final class c
{
  private final String TAG;
  public float aNk;
  public float aNl;
  public Matrix eY;
  private ArrayList<Integer> gQi;
  private ArrayList<Integer> gQj;
  private float[] gQk;
  private float[] gQl;
  private float[] gQm;
  private b gQn;
  public Rect gQo;
  public int gQp;
  private float gQq;
  private float gQr;
  private float[] gQs;
  private float[] gQt;
  public float[] gQu;
  private float[] gQv;
  private c.a gQw;
  public int height;
  public int width;
  
  public c()
  {
    AppMethodBeat.i(93614);
    this.TAG = "TouchTracker";
    this.gQi = new ArrayList();
    this.gQj = new ArrayList();
    this.gQk = new float[2];
    this.gQl = new float[4];
    this.gQm = new float[2];
    this.gQn = b.gQA;
    this.eY = new Matrix();
    this.gQs = new float[8];
    this.gQt = new float[8];
    this.gQu = new float[4];
    this.gQv = new float[4];
    this.aNk = 10.0F;
    this.aNl = 0.1F;
    this.gQw = c.a.gQx;
    this.eY.setScale(1.0F, 1.0F);
    AppMethodBeat.o(93614);
  }
  
  private final float aqA()
  {
    AppMethodBeat.i(93611);
    float f2 = this.gQt[1];
    float[] arrayOfFloat = this.gQt;
    int k = arrayOfFloat.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      float f3 = arrayOfFloat[j];
      float f1 = f2;
      switch (i)
      {
      default: 
        f1 = f2;
      }
      for (;;)
      {
        j += 1;
        i += 1;
        f2 = f1;
        break;
        f1 = Math.min(f2, f3);
        continue;
        f1 = Math.min(f2, f3);
        continue;
        f1 = Math.min(f2, f3);
      }
    }
    AppMethodBeat.o(93611);
    return f2;
  }
  
  private final float aqB()
  {
    AppMethodBeat.i(93612);
    float f2 = this.gQt[0];
    float[] arrayOfFloat = this.gQt;
    int k = arrayOfFloat.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      float f3 = arrayOfFloat[j];
      float f1 = f2;
      switch (i)
      {
      default: 
        f1 = f2;
      }
      for (;;)
      {
        j += 1;
        i += 1;
        f2 = f1;
        break;
        f1 = Math.max(f2, f3);
        continue;
        f1 = Math.max(f2, f3);
        continue;
        f1 = Math.max(f2, f3);
      }
    }
    AppMethodBeat.o(93612);
    return f2;
  }
  
  private final float aqC()
  {
    AppMethodBeat.i(93613);
    float f2 = this.gQt[1];
    float[] arrayOfFloat = this.gQt;
    int k = arrayOfFloat.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      float f3 = arrayOfFloat[j];
      float f1 = f2;
      switch (i)
      {
      default: 
        f1 = f2;
      }
      for (;;)
      {
        j += 1;
        i += 1;
        f2 = f1;
        break;
        f1 = Math.max(f2, f3);
        continue;
        f1 = Math.max(f2, f3);
        continue;
        f1 = Math.max(f2, f3);
      }
    }
    AppMethodBeat.o(93613);
    return f2;
  }
  
  private final float aqz()
  {
    AppMethodBeat.i(93610);
    float f2 = this.gQt[0];
    float[] arrayOfFloat = this.gQt;
    int k = arrayOfFloat.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      float f3 = arrayOfFloat[j];
      float f1 = f2;
      switch (i)
      {
      default: 
        f1 = f2;
      }
      for (;;)
      {
        j += 1;
        i += 1;
        f2 = f1;
        break;
        f1 = Math.min(f2, f3);
        continue;
        f1 = Math.min(f2, f3);
        continue;
        f1 = Math.min(f2, f3);
      }
    }
    AppMethodBeat.o(93610);
    return f2;
  }
  
  private final void u(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(93608);
    Object localObject1;
    Object localObject2;
    if (this.gQi.size() == 1)
    {
      this.gQn = b.gQB;
      localObject1 = this.gQk;
      localObject2 = this.gQj.get(0);
      k.g(localObject2, "pIndices[0]");
      localObject1[0] = paramMotionEvent.getX(((Number)localObject2).intValue());
      localObject1 = this.gQk;
      localObject2 = this.gQj.get(0);
      k.g(localObject2, "pIndices[0]");
      localObject1[1] = paramMotionEvent.getY(((Number)localObject2).intValue());
      AppMethodBeat.o(93608);
      return;
    }
    if (this.gQi.size() == 2)
    {
      this.gQn = b.gQC;
      if (this.gQw == c.a.gQy) {
        this.eY.mapPoints(this.gQm, new float[] { this.width / 2.0F, this.height / 2.0F });
      }
      localObject1 = new Matrix();
      this.eY.invert((Matrix)localObject1);
      v(paramMotionEvent);
      localObject2 = this.gQl;
      Object localObject3 = this.gQj.get(0);
      k.g(localObject3, "pIndices[0]");
      float f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
      localObject3 = this.gQj.get(0);
      k.g(localObject3, "pIndices[0]");
      float f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
      localObject3 = this.gQj.get(1);
      k.g(localObject3, "pIndices[1]");
      float f3 = paramMotionEvent.getX(((Number)localObject3).intValue());
      localObject3 = this.gQj.get(1);
      k.g(localObject3, "pIndices[1]");
      ((Matrix)localObject1).mapPoints((float[])localObject2, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject3).intValue()) });
    }
    AppMethodBeat.o(93608);
  }
  
  private final void v(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(93609);
    Iterator localIterator = ((Iterable)j.o((Collection)this.gQi)).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ab)localIterator).nextInt();
      ArrayList localArrayList = this.gQj;
      Object localObject = this.gQi.get(i);
      k.g(localObject, "pIds[i]");
      localArrayList.set(i, Integer.valueOf(paramMotionEvent.findPointerIndex(((Number)localObject).intValue())));
    }
    AppMethodBeat.o(93609);
  }
  
  public final void l(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(93606);
    k.h(paramArrayOfFloat, "<set-?>");
    this.gQs = paramArrayOfFloat;
    AppMethodBeat.o(93606);
  }
  
  public final void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(93605);
    k.h(paramMatrix, "<set-?>");
    this.eY = paramMatrix;
    AppMethodBeat.o(93605);
  }
  
  public final boolean t(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(93607);
    k.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(93607);
      return true;
      Object localObject1 = new float[2];
      Object localObject2 = new Matrix();
      this.eY.invert((Matrix)localObject2);
      ((Matrix)localObject2).mapPoints((float[])localObject1, new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
      if ((localObject1[0] < 0.0F) || (localObject1[0] > this.width) || (localObject1[1] < 0.0F) || (localObject1[1] > this.height))
      {
        AppMethodBeat.o(93607);
        return false;
      }
      this.gQi.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
      this.gQj.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
      u(paramMotionEvent);
      continue;
      this.gQi.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
      this.gQj.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
      u(paramMotionEvent);
      continue;
      v(paramMotionEvent);
      if (paramMotionEvent.getPointerCount() == 1) {
        this.gQn = b.gQB;
      }
      localObject1 = this.gQn;
      float f3;
      float f2;
      float f1;
      int i;
      switch (d.cfA[localObject1.ordinal()])
      {
      default: 
        break;
      case 1: 
        localObject1 = this.gQj.get(0);
        k.g(localObject1, "pIndices[0]");
        f3 = paramMotionEvent.getX(((Number)localObject1).intValue());
        localObject1 = this.gQj.get(0);
        k.g(localObject1, "pIndices[0]");
        float f4 = paramMotionEvent.getY(((Number)localObject1).intValue());
        f2 = f3 - this.gQk[0];
        f1 = f4 - this.gQk[1];
        this.eY.postTranslate(f2, f1);
        this.gQk[0] = f3;
        this.gQk[1] = f4;
        this.eY.mapPoints(this.gQt, this.gQs);
        this.gQu[0] = aqz();
        this.gQu[1] = aqA();
        this.gQu[2] = aqB();
        this.gQu[3] = aqC();
        if (this.gQo != null)
        {
          f3 = this.gQu[0] + f2;
          f4 = this.gQu[1] + f1;
          float f5 = this.gQu[2] + f2;
          float f6 = this.gQu[3] + f1;
          paramMotionEvent = this.gQo;
          if (paramMotionEvent == null) {
            k.fOy();
          }
          if (f3 > paramMotionEvent.left)
          {
            paramMotionEvent = this.gQo;
            if (paramMotionEvent == null) {
              k.fOy();
            }
            if (f3 < paramMotionEvent.right)
            {
              paramMotionEvent = this.gQo;
              if (paramMotionEvent == null) {
                k.fOy();
              }
              if (f4 > paramMotionEvent.top)
              {
                paramMotionEvent = this.gQo;
                if (paramMotionEvent == null) {
                  k.fOy();
                }
                if (f4 < paramMotionEvent.bottom)
                {
                  paramMotionEvent = this.gQo;
                  if (paramMotionEvent == null) {
                    k.fOy();
                  }
                  if (f5 > paramMotionEvent.left)
                  {
                    paramMotionEvent = this.gQo;
                    if (paramMotionEvent == null) {
                      k.fOy();
                    }
                    if (f5 < paramMotionEvent.right)
                    {
                      paramMotionEvent = this.gQo;
                      if (paramMotionEvent == null) {
                        k.fOy();
                      }
                      if (f6 > paramMotionEvent.top)
                      {
                        paramMotionEvent = this.gQo;
                        if (paramMotionEvent == null) {
                          k.fOy();
                        }
                        if (f6 >= paramMotionEvent.bottom) {}
                      }
                    }
                  }
                }
              }
            }
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label1100;
            }
            f2 = Math.abs(f2);
            f1 = Math.abs(f1);
            paramMotionEvent = this.gQo;
            if (paramMotionEvent == null) {
              k.fOy();
            }
            if ((paramMotionEvent.left >= this.gQu[0]) && (this.gQq <= this.gQp))
            {
              paramMotionEvent = this.eY;
              localObject1 = this.gQo;
              if (localObject1 == null) {
                k.fOy();
              }
              paramMotionEvent.postTranslate(((Rect)localObject1).left - this.gQu[0], 0.0F);
              this.gQq += f2;
            }
            paramMotionEvent = this.gQo;
            if (paramMotionEvent == null) {
              k.fOy();
            }
            if ((paramMotionEvent.top >= this.gQu[1]) && (this.gQr <= this.gQp))
            {
              paramMotionEvent = this.eY;
              localObject1 = this.gQo;
              if (localObject1 == null) {
                k.fOy();
              }
              paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).top - this.gQu[1]);
              this.gQr += f1;
            }
            paramMotionEvent = this.gQo;
            if (paramMotionEvent == null) {
              k.fOy();
            }
            if ((paramMotionEvent.right <= this.gQu[2]) && (this.gQq <= this.gQp))
            {
              paramMotionEvent = this.eY;
              localObject1 = this.gQo;
              if (localObject1 == null) {
                k.fOy();
              }
              paramMotionEvent.postTranslate(((Rect)localObject1).right - this.gQu[2], 0.0F);
              this.gQq = (f2 + this.gQq);
            }
            paramMotionEvent = this.gQo;
            if (paramMotionEvent == null) {
              k.fOy();
            }
            if ((paramMotionEvent.bottom > this.gQu[3]) || (this.gQr > this.gQp)) {
              break;
            }
            paramMotionEvent = this.eY;
            localObject1 = this.gQo;
            if (localObject1 == null) {
              k.fOy();
            }
            paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).bottom - this.gQu[3]);
            this.gQr += f1;
            break;
          }
        }
        this.gQq = 0.0F;
        this.gQr = 0.0F;
        break;
      case 2: 
        label1100:
        localObject1 = this.eY;
        localObject2 = this.gQl;
        Object localObject3 = this.gQj.get(0);
        k.g(localObject3, "pIndices[0]");
        f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.gQj.get(0);
        k.g(localObject3, "pIndices[0]");
        f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
        localObject3 = this.gQj.get(1);
        k.g(localObject3, "pIndices[1]");
        f3 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.gQj.get(1);
        k.g(localObject3, "pIndices[1]");
        ((Matrix)localObject1).setPolyToPoly((float[])localObject2, 0, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject3).intValue()) }, 0, 2);
        if (this.gQw == c.a.gQy)
        {
          localObject1 = new float[2];
          this.eY.mapPoints((float[])localObject1, new float[] { this.width / 2.0F, this.height / 2.0F });
          this.eY.postTranslate(this.gQm[0] - localObject1[0], this.gQm[1] - localObject1[1]);
        }
        localObject1 = new float[2];
        localObject2 = this.gQj.get(0);
        k.g(localObject2, "pIndices[0]");
        f1 = paramMotionEvent.getX(((Number)localObject2).intValue());
        localObject2 = this.gQj.get(1);
        k.g(localObject2, "pIndices[1]");
        localObject1[0] = ((paramMotionEvent.getX(((Number)localObject2).intValue()) + f1) / 2.0F);
        localObject2 = this.gQj.get(0);
        k.g(localObject2, "pIndices[0]");
        f1 = paramMotionEvent.getY(((Number)localObject2).intValue());
        localObject2 = this.gQj.get(1);
        k.g(localObject2, "pIndices[1]");
        localObject1[1] = ((paramMotionEvent.getY(((Number)localObject2).intValue()) + f1) / 2.0F);
        paramMotionEvent = b.gQh;
        paramMotionEvent = this.eY;
        f1 = this.aNl;
        f2 = this.aNk;
        k.h(paramMotionEvent, "matrix");
        k.h(localObject1, "pivotSrc");
        k.h(paramMotionEvent, "matrix");
        localObject2 = new float[9];
        paramMotionEvent.getValues((float[])localObject2);
        double d1 = localObject2[0];
        double d2 = localObject2[3];
        f3 = (float)Math.sqrt(d2 * d2 + d1 * d1);
        if (f3 < f1) {}
        for (;;)
        {
          localObject3 = new Matrix();
          paramMotionEvent.invert((Matrix)localObject3);
          localObject2 = new float[2];
          ((Matrix)localObject3).mapPoints((float[])localObject2, (float[])localObject1);
          localObject3 = new float[9];
          paramMotionEvent.getValues((float[])localObject3);
          d1 = localObject3[0];
          d2 = localObject3[3];
          double d3 = localObject3[4];
          Math.sqrt(d1 * d1 + d2 * d2);
          f2 = (float)Math.round(Math.atan2(d2, d3) * 57.295779513082323D);
          paramMotionEvent.setTranslate(-localObject2[0], -localObject2[1]);
          paramMotionEvent.postScale(f1, f1);
          paramMotionEvent.postRotate(f2);
          paramMotionEvent.postTranslate(localObject1[0], localObject1[1]);
          do
          {
            this.eY.mapPoints(this.gQt, this.gQs);
            this.gQu[0] = aqz();
            this.gQu[1] = aqA();
            this.gQu[2] = aqB();
            this.gQu[3] = aqC();
            break;
          } while (f3 <= f2);
          f1 = f2;
        }
        v(paramMotionEvent);
        i = this.gQj.indexOf(Integer.valueOf(paramMotionEvent.getActionIndex()));
        this.gQj.remove(i);
        this.gQi.remove(i);
        u(paramMotionEvent);
        continue;
        this.gQn = b.gQA;
        this.gQi.clear();
        this.gQj.clear();
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/touch/TouchTracker$TouchState;", "", "(Ljava/lang/String;I)V", "NONE", "DRAG", "SCALE", "plugin-mediaeditor_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(93601);
      b localb1 = new b("NONE", 0);
      gQA = localb1;
      b localb2 = new b("DRAG", 1);
      gQB = localb2;
      b localb3 = new b("SCALE", 2);
      gQC = localb3;
      gQD = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(93601);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.editor.c.c
 * JD-Core Version:    0.7.0.1
 */