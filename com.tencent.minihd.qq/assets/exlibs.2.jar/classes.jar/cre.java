import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

public class cre
  extends View
{
  static final long jdField_a_of_type_Long = 20L;
  static final long jdField_b_of_type_Long = 5000L;
  protected double a;
  int jdField_a_of_type_Int = 0;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  Rect jdField_a_of_type_AndroidGraphicsRect;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839280);
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839290);
  protected int c;
  long c;
  protected int d = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
  
  public cre(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(2130706432);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect);
    this.jdField_c_of_type_Int = (paramInt4 - paramInt2 - this.d);
    this.jdField_a_of_type_Double = (this.jdField_c_of_type_Int / 5000.0D);
    this.jdField_a_of_type_AndroidGraphicsRect = localRect;
    invalidate();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    if ((localRect == null) || (localRect.left == 0)) {
      paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    do
    {
      return;
      paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, localRect.top, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, localRect.top, localRect.left, localRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(localRect.right, localRect.top, this.jdField_a_of_type_Int, localRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, localRect.bottom, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    } while (!this.jdField_a_of_type_Boolean);
    int i = (int)((System.currentTimeMillis() - this.jdField_c_of_type_Long) * this.jdField_a_of_type_Double) % this.jdField_c_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect.left, localRect.top + i, localRect.right, i + localRect.top + this.d);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    postInvalidateDelayed(20L, localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    invalidate();
  }
  
  public void postInvalidateDelayed(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.postInvalidateDelayed(paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    postDelayed(new crf(this, paramInt1, paramInt2, paramInt3, paramInt4), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cre
 * JD-Core Version:    0.7.0.1
 */