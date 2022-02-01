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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/touch/TouchTracker;", "", "()V", "TAG", "", "boundArrayDst", "", "getBoundArrayDst", "()[F", "setBoundArrayDst", "([F)V", "boundArrayOut", "getBoundArrayOut", "setBoundArrayOut", "boundArraySrc", "getBoundArraySrc", "setBoundArraySrc", "height", "", "getHeight", "()I", "setHeight", "(I)V", "holdX", "", "getHoldX", "()F", "setHoldX", "(F)V", "holdY", "getHoldY", "setHoldY", "holdingThreshold", "getHoldingThreshold", "setHoldingThreshold", "lastDrag", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "pIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pIndices", "pivotDst", "pivotType", "Lcom/tencent/mm/media/editor/touch/TouchTracker$PivotType;", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "state", "Lcom/tencent/mm/media/editor/touch/TouchTracker$TouchState;", "transStart", "transformBoundArray", "getTransformBoundArray", "setTransformBoundArray", "width", "getWidth", "setWidth", "appendTouchEvent", "", "event", "Landroid/view/MotionEvent;", "findIndices", "", "findMaxBottom", "findMaxRight", "findMinLeft", "findMinTop", "inSafeArea", "newLeft", "newTop", "newRight", "newBottom", "resetHold", "updateState", "PivotType", "TouchState", "plugin-mediaeditor_release"})
public final class c
{
  private final String TAG;
  public float aMu;
  public float aMv;
  public Matrix dY;
  private ArrayList<Integer> gpA;
  private ArrayList<Integer> gpB;
  private float[] gpC;
  private float[] gpD;
  private float[] gpE;
  private b gpF;
  public Rect gpG;
  public int gpH;
  private float gpI;
  private float gpJ;
  private float[] gpK;
  private float[] gpL;
  public float[] gpM;
  private float[] gpN;
  private c.a gpO;
  public int height;
  public int width;
  
  public c()
  {
    AppMethodBeat.i(93614);
    this.TAG = "TouchTracker";
    this.gpA = new ArrayList();
    this.gpB = new ArrayList();
    this.gpC = new float[2];
    this.gpD = new float[4];
    this.gpE = new float[2];
    this.gpF = b.gpS;
    this.dY = new Matrix();
    this.gpK = new float[8];
    this.gpL = new float[8];
    this.gpM = new float[4];
    this.gpN = new float[4];
    this.aMu = 10.0F;
    this.aMv = 0.1F;
    this.gpO = c.a.gpP;
    this.dY.setScale(1.0F, 1.0F);
    AppMethodBeat.o(93614);
  }
  
  private final float ajA()
  {
    AppMethodBeat.i(93610);
    float f2 = this.gpL[0];
    float[] arrayOfFloat = this.gpL;
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
  
  private final float ajB()
  {
    AppMethodBeat.i(93611);
    float f2 = this.gpL[1];
    float[] arrayOfFloat = this.gpL;
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
  
  private final float ajC()
  {
    AppMethodBeat.i(93612);
    float f2 = this.gpL[0];
    float[] arrayOfFloat = this.gpL;
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
  
  private final float ajD()
  {
    AppMethodBeat.i(93613);
    float f2 = this.gpL[1];
    float[] arrayOfFloat = this.gpL;
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
  
  private final void w(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(93608);
    Object localObject1;
    Object localObject2;
    if (this.gpA.size() == 1)
    {
      this.gpF = b.gpT;
      localObject1 = this.gpC;
      localObject2 = this.gpB.get(0);
      k.g(localObject2, "pIndices[0]");
      localObject1[0] = paramMotionEvent.getX(((Number)localObject2).intValue());
      localObject1 = this.gpC;
      localObject2 = this.gpB.get(0);
      k.g(localObject2, "pIndices[0]");
      localObject1[1] = paramMotionEvent.getY(((Number)localObject2).intValue());
      AppMethodBeat.o(93608);
      return;
    }
    if (this.gpA.size() == 2)
    {
      this.gpF = b.gpU;
      if (this.gpO == c.a.gpQ) {
        this.dY.mapPoints(this.gpE, new float[] { this.width / 2.0F, this.height / 2.0F });
      }
      localObject1 = new Matrix();
      this.dY.invert((Matrix)localObject1);
      x(paramMotionEvent);
      localObject2 = this.gpD;
      Object localObject3 = this.gpB.get(0);
      k.g(localObject3, "pIndices[0]");
      float f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
      localObject3 = this.gpB.get(0);
      k.g(localObject3, "pIndices[0]");
      float f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
      localObject3 = this.gpB.get(1);
      k.g(localObject3, "pIndices[1]");
      float f3 = paramMotionEvent.getX(((Number)localObject3).intValue());
      localObject3 = this.gpB.get(1);
      k.g(localObject3, "pIndices[1]");
      ((Matrix)localObject1).mapPoints((float[])localObject2, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject3).intValue()) });
    }
    AppMethodBeat.o(93608);
  }
  
  private final void x(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(93609);
    Iterator localIterator = ((Iterable)j.n((Collection)this.gpA)).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ab)localIterator).nextInt();
      ArrayList localArrayList = this.gpB;
      Object localObject = this.gpA.get(i);
      k.g(localObject, "pIds[i]");
      localArrayList.set(i, Integer.valueOf(paramMotionEvent.findPointerIndex(((Number)localObject).intValue())));
    }
    AppMethodBeat.o(93609);
  }
  
  public final void l(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(93606);
    k.h(paramArrayOfFloat, "<set-?>");
    this.gpK = paramArrayOfFloat;
    AppMethodBeat.o(93606);
  }
  
  public final void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(93605);
    k.h(paramMatrix, "<set-?>");
    this.dY = paramMatrix;
    AppMethodBeat.o(93605);
  }
  
  public final boolean v(MotionEvent paramMotionEvent)
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
      this.dY.invert((Matrix)localObject2);
      ((Matrix)localObject2).mapPoints((float[])localObject1, new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
      if ((localObject1[0] < 0.0F) || (localObject1[0] > this.width) || (localObject1[1] < 0.0F) || (localObject1[1] > this.height))
      {
        AppMethodBeat.o(93607);
        return false;
      }
      this.gpA.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
      this.gpB.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
      w(paramMotionEvent);
      continue;
      this.gpA.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
      this.gpB.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
      w(paramMotionEvent);
      continue;
      x(paramMotionEvent);
      if (paramMotionEvent.getPointerCount() == 1) {
        this.gpF = b.gpT;
      }
      localObject1 = this.gpF;
      float f3;
      float f2;
      float f1;
      int i;
      switch (d.ciE[localObject1.ordinal()])
      {
      default: 
        break;
      case 1: 
        localObject1 = this.gpB.get(0);
        k.g(localObject1, "pIndices[0]");
        f3 = paramMotionEvent.getX(((Number)localObject1).intValue());
        localObject1 = this.gpB.get(0);
        k.g(localObject1, "pIndices[0]");
        float f4 = paramMotionEvent.getY(((Number)localObject1).intValue());
        f2 = f3 - this.gpC[0];
        f1 = f4 - this.gpC[1];
        this.dY.postTranslate(f2, f1);
        this.gpC[0] = f3;
        this.gpC[1] = f4;
        this.dY.mapPoints(this.gpL, this.gpK);
        this.gpM[0] = ajA();
        this.gpM[1] = ajB();
        this.gpM[2] = ajC();
        this.gpM[3] = ajD();
        if (this.gpG != null)
        {
          f3 = this.gpM[0] + f2;
          f4 = this.gpM[1] + f1;
          float f5 = this.gpM[2] + f2;
          float f6 = this.gpM[3] + f1;
          paramMotionEvent = this.gpG;
          if (paramMotionEvent == null) {
            k.fvU();
          }
          if (f3 > paramMotionEvent.left)
          {
            paramMotionEvent = this.gpG;
            if (paramMotionEvent == null) {
              k.fvU();
            }
            if (f3 < paramMotionEvent.right)
            {
              paramMotionEvent = this.gpG;
              if (paramMotionEvent == null) {
                k.fvU();
              }
              if (f4 > paramMotionEvent.top)
              {
                paramMotionEvent = this.gpG;
                if (paramMotionEvent == null) {
                  k.fvU();
                }
                if (f4 < paramMotionEvent.bottom)
                {
                  paramMotionEvent = this.gpG;
                  if (paramMotionEvent == null) {
                    k.fvU();
                  }
                  if (f5 > paramMotionEvent.left)
                  {
                    paramMotionEvent = this.gpG;
                    if (paramMotionEvent == null) {
                      k.fvU();
                    }
                    if (f5 < paramMotionEvent.right)
                    {
                      paramMotionEvent = this.gpG;
                      if (paramMotionEvent == null) {
                        k.fvU();
                      }
                      if (f6 > paramMotionEvent.top)
                      {
                        paramMotionEvent = this.gpG;
                        if (paramMotionEvent == null) {
                          k.fvU();
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
            paramMotionEvent = this.gpG;
            if (paramMotionEvent == null) {
              k.fvU();
            }
            if ((paramMotionEvent.left >= this.gpM[0]) && (this.gpI <= this.gpH))
            {
              paramMotionEvent = this.dY;
              localObject1 = this.gpG;
              if (localObject1 == null) {
                k.fvU();
              }
              paramMotionEvent.postTranslate(((Rect)localObject1).left - this.gpM[0], 0.0F);
              this.gpI += f2;
            }
            paramMotionEvent = this.gpG;
            if (paramMotionEvent == null) {
              k.fvU();
            }
            if ((paramMotionEvent.top >= this.gpM[1]) && (this.gpJ <= this.gpH))
            {
              paramMotionEvent = this.dY;
              localObject1 = this.gpG;
              if (localObject1 == null) {
                k.fvU();
              }
              paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).top - this.gpM[1]);
              this.gpJ += f1;
            }
            paramMotionEvent = this.gpG;
            if (paramMotionEvent == null) {
              k.fvU();
            }
            if ((paramMotionEvent.right <= this.gpM[2]) && (this.gpI <= this.gpH))
            {
              paramMotionEvent = this.dY;
              localObject1 = this.gpG;
              if (localObject1 == null) {
                k.fvU();
              }
              paramMotionEvent.postTranslate(((Rect)localObject1).right - this.gpM[2], 0.0F);
              this.gpI = (f2 + this.gpI);
            }
            paramMotionEvent = this.gpG;
            if (paramMotionEvent == null) {
              k.fvU();
            }
            if ((paramMotionEvent.bottom > this.gpM[3]) || (this.gpJ > this.gpH)) {
              break;
            }
            paramMotionEvent = this.dY;
            localObject1 = this.gpG;
            if (localObject1 == null) {
              k.fvU();
            }
            paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).bottom - this.gpM[3]);
            this.gpJ += f1;
            break;
          }
        }
        this.gpI = 0.0F;
        this.gpJ = 0.0F;
        break;
      case 2: 
        label1100:
        localObject1 = this.dY;
        localObject2 = this.gpD;
        Object localObject3 = this.gpB.get(0);
        k.g(localObject3, "pIndices[0]");
        f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.gpB.get(0);
        k.g(localObject3, "pIndices[0]");
        f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
        localObject3 = this.gpB.get(1);
        k.g(localObject3, "pIndices[1]");
        f3 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.gpB.get(1);
        k.g(localObject3, "pIndices[1]");
        ((Matrix)localObject1).setPolyToPoly((float[])localObject2, 0, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject3).intValue()) }, 0, 2);
        if (this.gpO == c.a.gpQ)
        {
          localObject1 = new float[2];
          this.dY.mapPoints((float[])localObject1, new float[] { this.width / 2.0F, this.height / 2.0F });
          this.dY.postTranslate(this.gpE[0] - localObject1[0], this.gpE[1] - localObject1[1]);
        }
        localObject1 = new float[2];
        localObject2 = this.gpB.get(0);
        k.g(localObject2, "pIndices[0]");
        f1 = paramMotionEvent.getX(((Number)localObject2).intValue());
        localObject2 = this.gpB.get(1);
        k.g(localObject2, "pIndices[1]");
        localObject1[0] = ((paramMotionEvent.getX(((Number)localObject2).intValue()) + f1) / 2.0F);
        localObject2 = this.gpB.get(0);
        k.g(localObject2, "pIndices[0]");
        f1 = paramMotionEvent.getY(((Number)localObject2).intValue());
        localObject2 = this.gpB.get(1);
        k.g(localObject2, "pIndices[1]");
        localObject1[1] = ((paramMotionEvent.getY(((Number)localObject2).intValue()) + f1) / 2.0F);
        paramMotionEvent = b.gpz;
        paramMotionEvent = this.dY;
        f1 = this.aMv;
        f2 = this.aMu;
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
            this.dY.mapPoints(this.gpL, this.gpK);
            this.gpM[0] = ajA();
            this.gpM[1] = ajB();
            this.gpM[2] = ajC();
            this.gpM[3] = ajD();
            break;
          } while (f3 <= f2);
          f1 = f2;
        }
        x(paramMotionEvent);
        i = this.gpB.indexOf(Integer.valueOf(paramMotionEvent.getActionIndex()));
        this.gpB.remove(i);
        this.gpA.remove(i);
        w(paramMotionEvent);
        continue;
        this.gpF = b.gpS;
        this.gpA.clear();
        this.gpB.clear();
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/touch/TouchTracker$TouchState;", "", "(Ljava/lang/String;I)V", "NONE", "DRAG", "SCALE", "plugin-mediaeditor_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(93601);
      b localb1 = new b("NONE", 0);
      gpS = localb1;
      b localb2 = new b("DRAG", 1);
      gpT = localb2;
      b localb3 = new b("SCALE", 2);
      gpU = localb3;
      gpV = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(93601);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.c.c
 * JD-Core Version:    0.7.0.1
 */