package com.tencent.map.lib.gl.model;

import android.graphics.Bitmap;
import android.opengl.GLU;
import android.view.MotionEvent;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.gl.c;
import com.tencent.tencentmap.mapsdk.a.hu;
import com.tencent.tencentmap.mapsdk.a.hv;
import com.tencent.tencentmap.mapsdk.a.hy;
import com.tencent.tencentmap.mapsdk.a.ic;
import javax.microedition.khronos.opengles.GL10;

public class a
  extends b
  implements hu
{
  public static final int ELEMENT_ANIMATOR_ALPHA = 1;
  public static final int ELEMENT_ANIMATOR_ROTATE = 4;
  public static final int ELEMENT_ANIMATOR_SCALE = 2;
  public static final int ELEMENT_ANIMATOR_TRANSLATE = 3;
  public static final int STATE_DISABLE = 2;
  public static final int STATE_FOCUS = 1;
  public static final int STATE_NORMAL = 0;
  protected float alpha = 1.0F;
  private a.a mAdapter;
  private int mState;
  private a.b mTextureListener;
  protected float rotate = 0.0F;
  protected float scaleX = 1.0F;
  protected float scaleY = 1.0F;
  protected float translateX = 0.0F;
  protected float translateY = 0.0F;
  
  private void drawTexture(GL10 paramGL10, com.tencent.map.lib.gl.b paramb)
  {
    String str = getIdByState();
    int j = paramb.a(str);
    int i = j;
    if (j == 0)
    {
      Bitmap localBitmap1 = this.mAdapter.getTextureBm(this.mState);
      Bitmap localBitmap2 = c.a(localBitmap1);
      i = c.a(paramGL10, localBitmap2);
      if (localBitmap2 != localBitmap1) {
        localBitmap2.recycle();
      }
      if (this.mTextureListener != null) {
        this.mTextureListener.a(localBitmap1);
      }
      paramb.a(str, i);
    }
    if (i != 0) {
      super.drawWithTexture(paramGL10, i);
    }
  }
  
  private String getIdByState()
  {
    return this.mAdapter.getTextureUID() + "_" + this.mState;
  }
  
  private void performDraw(GL10 paramGL10, com.tencent.map.lib.gl.b paramb)
  {
    paramGL10.glPushMatrix();
    if (prepareDraw(paramGL10))
    {
      if (!this.mAdapter.hasTexture()) {
        break label39;
      }
      drawTexture(paramGL10, paramb);
    }
    for (;;)
    {
      paramGL10.glPopMatrix();
      return;
      label39:
      super.drawWithTexture(paramGL10, 0);
    }
  }
  
  public hv animator(int paramInt, Object paramObject1, Object paramObject2)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ic.a(this, 1, new double[] { ((Number)paramObject1).doubleValue(), ((Number)paramObject2).doubleValue() });
    case 2: 
      return ic.a(this, 2, new hy(), new Object[] { paramObject1, paramObject2 });
    case 3: 
      return ic.a(this, 3, new hy(), new Object[] { paramObject1, paramObject2 });
    }
    return ic.a(this, 4, new double[] { ((Number)paramObject1).doubleValue(), ((Number)paramObject2).doubleValue() });
  }
  
  public void draw(GL10 paramGL10, com.tencent.map.lib.gl.b paramb)
  {
    try
    {
      if (this.mAdapter == null) {
        throw new RuntimeException("please setAdapter first");
      }
    }
    finally {}
    paramGL10.glColor4f(this.alpha, this.alpha, this.alpha, this.alpha);
    paramGL10.glScalef(this.scaleX, this.scaleY, 1.0F);
    paramGL10.glTranslatef(this.translateX, this.translateY, 0.0F);
    paramGL10.glRotatef(this.rotate, 0.0F, 0.0F, 1.0F);
    performDraw(paramGL10, paramb);
    paramGL10.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
  }
  
  public void drawWithOrthogo(GL10 paramGL10, com.tencent.map.lib.gl.b paramb, int paramInt1, int paramInt2)
  {
    paramGL10.glMatrixMode(5889);
    paramGL10.glPushMatrix();
    paramGL10.glLoadIdentity();
    GLU.gluOrtho2D(paramGL10, 0.0F, paramInt1, 0.0F, paramInt2);
    draw(paramGL10, paramb);
    paramGL10.glPopMatrix();
    paramGL10.glMatrixMode(5888);
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public boolean onTap(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected boolean prepareDraw(GL10 paramGL10)
  {
    return true;
  }
  
  public void rebuild(float[] paramArrayOfFloat1, short[] paramArrayOfShort, float[] paramArrayOfFloat2)
  {
    try
    {
      setVertices(paramArrayOfFloat1);
      setIndices(paramArrayOfShort);
      setTextureCoordinates(paramArrayOfFloat2);
      return;
    }
    finally
    {
      paramArrayOfFloat1 = finally;
      throw paramArrayOfFloat1;
    }
  }
  
  public void setAdapter(a.a parama)
  {
    try
    {
      this.mAdapter = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void setPropertyValue(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.alpha = ((Number)paramObject).floatValue();
      return;
    case 2: 
      paramObject = (DoublePoint)paramObject;
      this.scaleX = ((float)paramObject.x);
      this.scaleY = ((float)paramObject.y);
      return;
    case 3: 
      paramObject = (DoublePoint)paramObject;
      this.translateX = ((float)paramObject.x);
      this.translateY = ((float)paramObject.y);
      return;
    }
    this.rotate = ((Number)paramObject).floatValue();
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
    this.alpha = 1.0F;
    this.scaleX = 1.0F;
    this.scaleY = 1.0F;
    this.translateX = 0.0F;
    this.translateY = 0.0F;
  }
  
  public void setTextureListener(a.b paramb)
  {
    this.mTextureListener = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.map.lib.gl.model.a
 * JD-Core Version:    0.7.0.1
 */