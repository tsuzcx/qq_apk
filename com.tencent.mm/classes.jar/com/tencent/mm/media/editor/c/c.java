package com.tencent.mm.media.editor.c;

import a.a.ab;
import a.l;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/touch/TouchTracker;", "", "()V", "TAG", "", "boundArrayDst", "", "getBoundArrayDst", "()[F", "setBoundArrayDst", "([F)V", "boundArrayOut", "getBoundArrayOut", "setBoundArrayOut", "boundArraySrc", "getBoundArraySrc", "setBoundArraySrc", "height", "", "getHeight", "()I", "setHeight", "(I)V", "holdX", "", "getHoldX", "()F", "setHoldX", "(F)V", "holdY", "getHoldY", "setHoldY", "holdingThreshold", "getHoldingThreshold", "setHoldingThreshold", "lastDrag", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "pIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pIndices", "pivotDst", "pivotType", "Lcom/tencent/mm/media/editor/touch/TouchTracker$PivotType;", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "state", "Lcom/tencent/mm/media/editor/touch/TouchTracker$TouchState;", "transStart", "transformBoundArray", "getTransformBoundArray", "setTransformBoundArray", "width", "getWidth", "setWidth", "appendTouchEvent", "", "event", "Landroid/view/MotionEvent;", "findIndices", "", "findMaxBottom", "findMaxRight", "findMinLeft", "findMinTop", "inSafeArea", "newLeft", "newTop", "newRight", "newBottom", "resetHold", "updateState", "PivotType", "TouchState", "plugin-mediaeditor_release"})
public final class c
{
  private final String TAG;
  public float arJ;
  public float arK;
  public Matrix asO;
  private float[] eTA;
  private c.b eTB;
  public Rect eTC;
  public int eTD;
  private float eTE;
  private float eTF;
  private float[] eTG;
  private float[] eTH;
  public float[] eTI;
  private float[] eTJ;
  private a eTK;
  private ArrayList<Integer> eTw;
  private ArrayList<Integer> eTx;
  private float[] eTy;
  private float[] eTz;
  public int height;
  public int width;
  
  public c()
  {
    AppMethodBeat.i(12923);
    this.TAG = "TouchTracker";
    this.eTw = new ArrayList();
    this.eTx = new ArrayList();
    this.eTy = new float[2];
    this.eTz = new float[4];
    this.eTA = new float[2];
    this.eTB = c.b.eTO;
    this.asO = new Matrix();
    this.eTG = new float[8];
    this.eTH = new float[8];
    this.eTI = new float[4];
    this.eTJ = new float[4];
    this.arJ = 10.0F;
    this.arK = 0.1F;
    this.eTK = a.eTL;
    this.asO.setScale(1.0F, 1.0F);
    AppMethodBeat.o(12923);
  }
  
  private final float UJ()
  {
    AppMethodBeat.i(12919);
    float f2 = this.eTH[0];
    float[] arrayOfFloat = this.eTH;
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
    AppMethodBeat.o(12919);
    return f2;
  }
  
  private final float UK()
  {
    AppMethodBeat.i(12920);
    float f2 = this.eTH[1];
    float[] arrayOfFloat = this.eTH;
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
    AppMethodBeat.o(12920);
    return f2;
  }
  
  private final float UL()
  {
    AppMethodBeat.i(12921);
    float f2 = this.eTH[0];
    float[] arrayOfFloat = this.eTH;
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
    AppMethodBeat.o(12921);
    return f2;
  }
  
  private final float UM()
  {
    AppMethodBeat.i(12922);
    float f2 = this.eTH[1];
    float[] arrayOfFloat = this.eTH;
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
    AppMethodBeat.o(12922);
    return f2;
  }
  
  private final void v(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(12917);
    Object localObject1;
    Object localObject2;
    if (this.eTw.size() == 1)
    {
      this.eTB = c.b.eTP;
      localObject1 = this.eTy;
      localObject2 = this.eTx.get(0);
      a.f.b.j.p(localObject2, "pIndices[0]");
      localObject1[0] = paramMotionEvent.getX(((Number)localObject2).intValue());
      localObject1 = this.eTy;
      localObject2 = this.eTx.get(0);
      a.f.b.j.p(localObject2, "pIndices[0]");
      localObject1[1] = paramMotionEvent.getY(((Number)localObject2).intValue());
      AppMethodBeat.o(12917);
      return;
    }
    if (this.eTw.size() == 2)
    {
      this.eTB = c.b.eTQ;
      if (this.eTK == a.eTM) {
        this.asO.mapPoints(this.eTA, new float[] { this.width / 2.0F, this.height / 2.0F });
      }
      localObject1 = new Matrix();
      this.asO.invert((Matrix)localObject1);
      w(paramMotionEvent);
      localObject2 = this.eTz;
      Object localObject3 = this.eTx.get(0);
      a.f.b.j.p(localObject3, "pIndices[0]");
      float f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
      localObject3 = this.eTx.get(0);
      a.f.b.j.p(localObject3, "pIndices[0]");
      float f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
      localObject3 = this.eTx.get(1);
      a.f.b.j.p(localObject3, "pIndices[1]");
      float f3 = paramMotionEvent.getX(((Number)localObject3).intValue());
      localObject3 = this.eTx.get(1);
      a.f.b.j.p(localObject3, "pIndices[1]");
      ((Matrix)localObject1).mapPoints((float[])localObject2, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject3).intValue()) });
    }
    AppMethodBeat.o(12917);
  }
  
  private final void w(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(12918);
    Iterator localIterator = ((Iterable)a.a.j.e((Collection)this.eTw)).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ab)localIterator).nextInt();
      ArrayList localArrayList = this.eTx;
      Object localObject = this.eTw.get(i);
      a.f.b.j.p(localObject, "pIds[i]");
      localArrayList.set(i, Integer.valueOf(paramMotionEvent.findPointerIndex(((Number)localObject).intValue())));
    }
    AppMethodBeat.o(12918);
  }
  
  public final void h(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(12915);
    a.f.b.j.q(paramArrayOfFloat, "<set-?>");
    this.eTG = paramArrayOfFloat;
    AppMethodBeat.o(12915);
  }
  
  public final void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(12914);
    a.f.b.j.q(paramMatrix, "<set-?>");
    this.asO = paramMatrix;
    AppMethodBeat.o(12914);
  }
  
  public final boolean u(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(12916);
    a.f.b.j.q(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(12916);
      return true;
      Object localObject1 = new float[2];
      Object localObject2 = new Matrix();
      this.asO.invert((Matrix)localObject2);
      ((Matrix)localObject2).mapPoints((float[])localObject1, new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
      if ((localObject1[0] < 0.0F) || (localObject1[0] > this.width) || (localObject1[1] < 0.0F) || (localObject1[1] > this.height))
      {
        AppMethodBeat.o(12916);
        return false;
      }
      this.eTw.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
      this.eTx.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
      v(paramMotionEvent);
      continue;
      this.eTw.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
      this.eTx.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
      v(paramMotionEvent);
      continue;
      w(paramMotionEvent);
      if (paramMotionEvent.getPointerCount() == 1) {
        this.eTB = c.b.eTP;
      }
      localObject1 = this.eTB;
      float f3;
      float f2;
      float f1;
      int i;
      switch (d.bLo[localObject1.ordinal()])
      {
      default: 
        break;
      case 1: 
        localObject1 = this.eTx.get(0);
        a.f.b.j.p(localObject1, "pIndices[0]");
        f3 = paramMotionEvent.getX(((Number)localObject1).intValue());
        localObject1 = this.eTx.get(0);
        a.f.b.j.p(localObject1, "pIndices[0]");
        float f4 = paramMotionEvent.getY(((Number)localObject1).intValue());
        f2 = f3 - this.eTy[0];
        f1 = f4 - this.eTy[1];
        this.asO.postTranslate(f2, f1);
        this.eTy[0] = f3;
        this.eTy[1] = f4;
        this.asO.mapPoints(this.eTH, this.eTG);
        this.eTI[0] = UJ();
        this.eTI[1] = UK();
        this.eTI[2] = UL();
        this.eTI[3] = UM();
        if (this.eTC != null)
        {
          f3 = this.eTI[0] + f2;
          f4 = this.eTI[1] + f1;
          float f5 = this.eTI[2] + f2;
          float f6 = this.eTI[3] + f1;
          paramMotionEvent = this.eTC;
          if (paramMotionEvent == null) {
            a.f.b.j.ebi();
          }
          if (f3 > paramMotionEvent.left)
          {
            paramMotionEvent = this.eTC;
            if (paramMotionEvent == null) {
              a.f.b.j.ebi();
            }
            if (f3 < paramMotionEvent.right)
            {
              paramMotionEvent = this.eTC;
              if (paramMotionEvent == null) {
                a.f.b.j.ebi();
              }
              if (f4 > paramMotionEvent.top)
              {
                paramMotionEvent = this.eTC;
                if (paramMotionEvent == null) {
                  a.f.b.j.ebi();
                }
                if (f4 < paramMotionEvent.bottom)
                {
                  paramMotionEvent = this.eTC;
                  if (paramMotionEvent == null) {
                    a.f.b.j.ebi();
                  }
                  if (f5 > paramMotionEvent.left)
                  {
                    paramMotionEvent = this.eTC;
                    if (paramMotionEvent == null) {
                      a.f.b.j.ebi();
                    }
                    if (f5 < paramMotionEvent.right)
                    {
                      paramMotionEvent = this.eTC;
                      if (paramMotionEvent == null) {
                        a.f.b.j.ebi();
                      }
                      if (f6 > paramMotionEvent.top)
                      {
                        paramMotionEvent = this.eTC;
                        if (paramMotionEvent == null) {
                          a.f.b.j.ebi();
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
            paramMotionEvent = this.eTC;
            if (paramMotionEvent == null) {
              a.f.b.j.ebi();
            }
            if ((paramMotionEvent.left >= this.eTI[0]) && (this.eTE <= this.eTD))
            {
              paramMotionEvent = this.asO;
              localObject1 = this.eTC;
              if (localObject1 == null) {
                a.f.b.j.ebi();
              }
              paramMotionEvent.postTranslate(((Rect)localObject1).left - this.eTI[0], 0.0F);
              this.eTE += f2;
            }
            paramMotionEvent = this.eTC;
            if (paramMotionEvent == null) {
              a.f.b.j.ebi();
            }
            if ((paramMotionEvent.top >= this.eTI[1]) && (this.eTF <= this.eTD))
            {
              paramMotionEvent = this.asO;
              localObject1 = this.eTC;
              if (localObject1 == null) {
                a.f.b.j.ebi();
              }
              paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).top - this.eTI[1]);
              this.eTF += f1;
            }
            paramMotionEvent = this.eTC;
            if (paramMotionEvent == null) {
              a.f.b.j.ebi();
            }
            if ((paramMotionEvent.right <= this.eTI[2]) && (this.eTE <= this.eTD))
            {
              paramMotionEvent = this.asO;
              localObject1 = this.eTC;
              if (localObject1 == null) {
                a.f.b.j.ebi();
              }
              paramMotionEvent.postTranslate(((Rect)localObject1).right - this.eTI[2], 0.0F);
              this.eTE = (f2 + this.eTE);
            }
            paramMotionEvent = this.eTC;
            if (paramMotionEvent == null) {
              a.f.b.j.ebi();
            }
            if ((paramMotionEvent.bottom > this.eTI[3]) || (this.eTF > this.eTD)) {
              break;
            }
            paramMotionEvent = this.asO;
            localObject1 = this.eTC;
            if (localObject1 == null) {
              a.f.b.j.ebi();
            }
            paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).bottom - this.eTI[3]);
            this.eTF += f1;
            break;
          }
        }
        this.eTE = 0.0F;
        this.eTF = 0.0F;
        break;
      case 2: 
        label1100:
        localObject1 = this.asO;
        localObject2 = this.eTz;
        Object localObject3 = this.eTx.get(0);
        a.f.b.j.p(localObject3, "pIndices[0]");
        f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.eTx.get(0);
        a.f.b.j.p(localObject3, "pIndices[0]");
        f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
        localObject3 = this.eTx.get(1);
        a.f.b.j.p(localObject3, "pIndices[1]");
        f3 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.eTx.get(1);
        a.f.b.j.p(localObject3, "pIndices[1]");
        ((Matrix)localObject1).setPolyToPoly((float[])localObject2, 0, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject3).intValue()) }, 0, 2);
        if (this.eTK == a.eTM)
        {
          localObject1 = new float[2];
          this.asO.mapPoints((float[])localObject1, new float[] { this.width / 2.0F, this.height / 2.0F });
          this.asO.postTranslate(this.eTA[0] - localObject1[0], this.eTA[1] - localObject1[1]);
        }
        localObject1 = new float[2];
        localObject2 = this.eTx.get(0);
        a.f.b.j.p(localObject2, "pIndices[0]");
        f1 = paramMotionEvent.getX(((Number)localObject2).intValue());
        localObject2 = this.eTx.get(1);
        a.f.b.j.p(localObject2, "pIndices[1]");
        localObject1[0] = ((paramMotionEvent.getX(((Number)localObject2).intValue()) + f1) / 2.0F);
        localObject2 = this.eTx.get(0);
        a.f.b.j.p(localObject2, "pIndices[0]");
        f1 = paramMotionEvent.getY(((Number)localObject2).intValue());
        localObject2 = this.eTx.get(1);
        a.f.b.j.p(localObject2, "pIndices[1]");
        localObject1[1] = ((paramMotionEvent.getY(((Number)localObject2).intValue()) + f1) / 2.0F);
        paramMotionEvent = b.eTv;
        paramMotionEvent = this.asO;
        f1 = this.arK;
        f2 = this.arJ;
        a.f.b.j.q(paramMotionEvent, "matrix");
        a.f.b.j.q(localObject1, "pivotSrc");
        a.f.b.j.q(paramMotionEvent, "matrix");
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
            this.asO.mapPoints(this.eTH, this.eTG);
            this.eTI[0] = UJ();
            this.eTI[1] = UK();
            this.eTI[2] = UL();
            this.eTI[3] = UM();
            break;
          } while (f3 <= f2);
          f1 = f2;
        }
        w(paramMotionEvent);
        i = this.eTx.indexOf(Integer.valueOf(paramMotionEvent.getActionIndex()));
        this.eTx.remove(i);
        this.eTw.remove(i);
        v(paramMotionEvent);
        continue;
        this.eTB = c.b.eTO;
        this.eTw.clear();
        this.eTx.clear();
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/touch/TouchTracker$PivotType;", "", "(Ljava/lang/String;I)V", "FREE", "CENTER", "plugin-mediaeditor_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(12907);
      a locala1 = new a("FREE", 0);
      eTL = locala1;
      a locala2 = new a("CENTER", 1);
      eTM = locala2;
      eTN = new a[] { locala1, locala2 };
      AppMethodBeat.o(12907);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.editor.c.c
 * JD-Core Version:    0.7.0.1
 */