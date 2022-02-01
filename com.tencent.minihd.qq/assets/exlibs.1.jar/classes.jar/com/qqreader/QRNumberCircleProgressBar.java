package com.qqreader;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.minihd.qq.R.styleable;

public class QRNumberCircleProgressBar
  extends View
{
  private static final double[] jdField_a_of_type_ArrayOfDouble = { 0.0D, 0.364413D, 0.4616D, 0.5308310000000001D, 0.586699D, 0.634474D, 0.676734D, 0.714958D, 0.750081D, 0.782736D, 0.813377D, 0.842337D, 0.869872D, 0.896184D, 0.921432D, 0.945747D, 0.969237D, 0.991993D, 1.01409D, 1.0356D, 1.05657D, 1.07706D, 1.0971D, 1.11674D, 1.13601D, 1.15494D, 1.17356D, 1.19189D, 1.20996D, 1.22779D, 1.24539D, 1.26279D, 1.27999D, 1.29702D, 1.31389D, 1.33061D, 1.3472D, 1.36366D, 1.38D, 1.39625D, 1.4124D, 1.42847D, 1.44446D, 1.46039D, 1.47627D, 1.49209D, 1.50788D, 1.52364D, 1.53937D, 1.55509D, 1.570796326794897D, 1.58651D, 1.60222D, 1.61796D, 1.63371D, 1.6495D, 1.66533D, 1.6812D, 1.69713D, 1.71313D, 1.72919D, 1.74535D, 1.76159D, 1.77794D, 1.7944D, 1.81098D, 1.8277D, 1.84457D, 1.8616D, 1.8788D, 1.8962D, 1.9138D, 1.93163D, 1.9497D, 1.96803D, 1.98665D, 2.00558D, 2.02485D, 2.04449D, 2.06454D, 2.08502D, 2.10599D, 2.1275D, 2.1496D, 2.17236D, 2.19585D, 2.22016D, 2.24541D, 2.27172D, 2.29926D, 2.32822D, 2.35886D, 2.39151D, 2.42663D, 2.46486D, 2.50712D, 2.55489D, 2.61076D, 2.67999D, 2.77718D, 3.141592653589793D };
  private static final double[] jdField_b_of_type_ArrayOfDouble = { 0.0D, 20.879326899700871D, 26.447731823238804D, 30.414375934709003D, 33.615376544545882D, 36.352682410783395D, 38.774002053006249D, 40.964075929114315D, 42.976475592952298D, 44.847469272952004D, 46.603069253012357D, 48.262355027711223D, 49.839994316603942D, 51.347560867152168D, 52.794164708298474D, 54.187311587159073D, 55.533189447921373D, 56.837012206521074D, 58.103077046421646D, 59.335509263748058D, 60.537001760137393D, 61.710992282360436D, 62.859199703802609D, 63.984488813439555D, 65.088578484656651D, 66.173187590839305D, 67.240035005372889D, 68.290266643847687D, 69.325601379649086D, 70.347185128367343D, 71.355590847797586D, 72.35253741132523D, 73.338024818950245D, 74.313771944058033D, 75.280351744443735D, 76.23833717790248D, 77.188874160024497D, 78.131962690809843D, 79.068175728053603D, 79.999232145141193D, 80.924558984277482D, 81.8453021610527D, 82.761461675466904D, 83.674183443110294D, 84.584040421778028D, 85.490459653674989D, 86.395160012186579D, 87.298141497312756D, 88.199404109053532D, 89.100093762999194D, 90.0D, 90.900327155300232D, 91.800443851450765D, 92.70227942098667D, 93.604687948317718D, 94.50938830682928D, 95.41638049652137D, 96.325664517394003D, 97.238386285037407D, 98.155118757246726D, 99.07528897622683D, 100.00118877315823D, 100.93167223245069D, 101.86845822748958D, 102.81154675827493D, 103.76151078260183D, 104.71949621606056D, 105.68607601644626D, 106.66182314155404D, 107.64731054917908D, 108.64425711270671D, 109.65266283213694D, 110.67424658085521D, 111.70958131665661D, 112.75981295513141D, 113.82666036966499D, 114.91126947584766D, 116.01535914706473D, 117.1406482567017D, 118.28942863593899D, 119.46284620036691D, 120.66433869675623D, 121.89677091408264D, 123.16300764132176D, 124.4670595830395D, 125.81293744380183D, 127.20579784376484D, 128.65251627647018D, 130.15996823545939D, 131.73789400324964D, 133.39717977794851D, 135.15272246222935D, 137.02342966333148D, 139.03565743983094D, 141.22607509061609D, 143.64739473283896D, 146.38441412017889D, 149.5855293215748D, 153.5521161372655D, 159.12069294814196D, 180.0D };
  private static final String jdField_c_of_type_JavaLangString = "saved_instance";
  private static final String jdField_d_of_type_JavaLangString = "full_mode";
  private static final String jdField_e_of_type_JavaLangString = "text_color";
  private static final String jdField_f_of_type_JavaLangString = "text_size";
  private static final int jdField_g_of_type_Int = 270;
  private static final String jdField_g_of_type_JavaLangString = "circle_radius";
  private static final String jdField_h_of_type_JavaLangString = "reached_bar_color";
  private static final String jdField_i_of_type_JavaLangString = "unreached_bar_color";
  private static final String jdField_j_of_type_JavaLangString = "max";
  private static final String jdField_k_of_type_JavaLangString = "progress";
  private static final int jdField_l_of_type_Int = 0;
  private static final String jdField_l_of_type_JavaLangString = "suffix";
  private static final int jdField_m_of_type_Int = 1;
  private static final String jdField_m_of_type_JavaLangString = "prefix";
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 100;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private String jdField_a_of_type_JavaLangString = "%";
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  private final float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private final float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private float jdField_e_of_type_Float = 0.0F;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float = 0.0F;
  private int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float;
  private float jdField_h_of_type_Float;
  private final int jdField_h_of_type_Int = Color.rgb(255, 255, 255);
  private float jdField_i_of_type_Float;
  private final int jdField_i_of_type_Int = Color.rgb(66, 145, 241);
  private float jdField_j_of_type_Float;
  private final int jdField_j_of_type_Int = Color.rgb(204, 204, 204);
  private final int jdField_k_of_type_Int;
  private String n;
  
  public QRNumberCircleProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QRNumberCircleProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QRNumberCircleProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_d_of_type_Float = a(65.0F);
    this.jdField_c_of_type_Float = a(15.0F);
    this.k = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.H);
    try
    {
      this.jdField_f_of_type_Int = paramContext.getInt(8, this.k);
      this.jdField_b_of_type_Float = paramContext.getDimension(6, this.jdField_d_of_type_Float);
      this.jdField_c_of_type_Int = paramContext.getColor(3, this.jdField_i_of_type_Int);
      this.jdField_d_of_type_Int = paramContext.getColor(2, this.jdField_j_of_type_Int);
      this.jdField_e_of_type_Int = paramContext.getColor(5, this.jdField_h_of_type_Int);
      this.jdField_a_of_type_Float = paramContext.getDimension(4, this.jdField_c_of_type_Float);
      if (paramContext.getInt(7, 0) != 0) {
        this.jdField_b_of_type_Boolean = false;
      }
      setProgress(paramContext.getInt(0, 0));
      setMax(paramContext.getInt(1, 100));
      paramContext.recycle();
      d();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    if (paramBoolean) {}
    for (paramInt = getPaddingLeft() + getPaddingRight(); i1 == 1073741824; paramInt = getPaddingTop() + getPaddingBottom()) {
      return i2;
    }
    paramInt += getSuggestedMinimumHeight();
    if (i1 == -2147483648) {
      return Math.min(paramInt, i2);
    }
    return paramInt;
  }
  
  private void a()
  {
    this.jdField_e_of_type_Float = ((getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) / 2.0F + getPaddingLeft());
    this.jdField_f_of_type_Float = ((getMeasuredHeight() - getPaddingTop() - getPaddingBottom()) / 2.0F + getPaddingTop());
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_e_of_type_Float - this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_f_of_type_Float - this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_e_of_type_Float + this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_f_of_type_Float + this.jdField_b_of_type_Float);
  }
  
  private void c()
  {
    this.n = String.format("%d", new Object[] { Integer.valueOf(a() * 100 / b()) });
    this.n = (this.jdField_b_of_type_JavaLangString + this.n + this.jdField_a_of_type_JavaLangString);
    Rect localRect = new Rect();
    this.jdField_d_of_type_AndroidGraphicsPaint.getTextBounds(this.n, 0, 1, localRect);
    this.g = localRect.width();
    this.jdField_h_of_type_Float = localRect.height();
    this.jdField_i_of_type_Float = (this.jdField_e_of_type_Float + this.g / 2.0F);
    float f1 = this.jdField_e_of_type_Float;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    }
    this.jdField_j_of_type_Float = a(114.0F);
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_d_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_d_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
    this.jdField_d_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.argb(200, 24, 180, 237));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130840676);
      return;
    }
    catch (Exception localException) {}catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  public float a(float paramFloat)
  {
    return getResources().getDisplayMetrics().density * paramFloat + 0.5F;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return (int)this.jdField_b_of_type_Float * 2;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return (int)this.jdField_a_of_type_Float;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.jdField_e_of_type_Float, this.jdField_f_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_Boolean) {
      switch (this.jdField_f_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean) {
        c();
      }
      paramCanvas.drawText(this.n, this.jdField_i_of_type_Float, this.jdField_j_of_type_Float, this.jdField_d_of_type_AndroidGraphicsPaint);
      return;
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 270.0F, a() * 360 / b(), true, this.jdField_c_of_type_AndroidGraphicsPaint);
      continue;
      float f1 = (b() - a()) * 1.0F / b();
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        float f2 = (a(130.0F) - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) / 2.0F;
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, f2, 32.0F, null);
        paramCanvas.drawRect(f2, a(17.0F) + 32.0F, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + f2, 32.0F + a(17.0F) + f1 * (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() - a(34.0F)), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1, true), a(paramInt2, false));
    a();
    b();
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_Int = paramInt;
      invalidate();
    }
  }
  
  public void setProgress(int paramInt)
  {
    if ((paramInt <= b()) && (paramInt >= 0))
    {
      this.jdField_b_of_type_Int = paramInt;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.qqreader.QRNumberCircleProgressBar
 * JD-Core Version:    0.7.0.1
 */