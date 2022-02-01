package com.pay.ui.payWeb.jsbridge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.webkit.WebView;

public class APRoundedWebView
  extends WebView
{
  private final int a = 18;
  private Context b;
  private int c;
  private int d;
  private int e;
  private Paint f;
  private Paint g;
  private Path h;
  private SparseArray<RectF> i;
  private boolean[] j = new boolean[4];
  private boolean k = false;
  
  public APRoundedWebView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public APRoundedWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public APRoundedWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private RectF a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 += paramInt1;
    RectF localRectF2 = (RectF)this.i.get(paramInt3);
    RectF localRectF1 = localRectF2;
    if (localRectF2 == null)
    {
      localRectF1 = new RectF(0.0F, paramInt1, paramInt2, paramInt3);
      this.i.put(paramInt3, localRectF1);
    }
    return localRectF1;
  }
  
  private void a(Context paramContext)
  {
    this.b = paramContext;
    paramContext = this.j;
    boolean[] arrayOfBoolean1 = this.j;
    boolean[] arrayOfBoolean2 = this.j;
    this.j[3] = false;
    arrayOfBoolean2[2] = false;
    arrayOfBoolean1[1] = false;
    paramContext[0] = 0;
    this.e = a(this.b, 5);
    this.f = b();
    this.g = c();
    this.i = new SparseArray();
    this.h = new Path();
    this.h.setFillType(Path.FillType.INVERSE_WINDING);
    setLayerType(1, null);
    if ((Build.VERSION.SDK_INT < 18) && (Build.VERSION.SDK_INT >= 11) && (a()))
    {
      this.k = true;
      setLayerType(1, null);
    }
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: new 110	java/util/Properties
    //   3: dup
    //   4: invokespecial 111	java/util/Properties:<init>	()V
    //   7: astore 5
    //   9: iconst_0
    //   10: istore_1
    //   11: iconst_0
    //   12: istore_0
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore_2
    //   18: new 113	java/io/FileInputStream
    //   21: dup
    //   22: new 115	java/io/File
    //   25: dup
    //   26: invokestatic 121	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   29: ldc 123
    //   31: invokespecial 126	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   34: invokespecial 129	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: astore_3
    //   38: aload 5
    //   40: aload_3
    //   41: invokevirtual 133	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   44: aload 5
    //   46: ldc 135
    //   48: aconst_null
    //   49: invokevirtual 139	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: ifnonnull +27 -> 79
    //   55: aload 5
    //   57: ldc 141
    //   59: aconst_null
    //   60: invokevirtual 139	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   63: ifnonnull +16 -> 79
    //   66: aload 5
    //   68: ldc 143
    //   70: aconst_null
    //   71: invokevirtual 139	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +5 -> 81
    //   79: iconst_1
    //   80: istore_0
    //   81: iload_0
    //   82: istore_1
    //   83: aload_3
    //   84: invokevirtual 148	java/io/InputStream:close	()V
    //   87: iload_0
    //   88: ireturn
    //   89: astore_2
    //   90: aload_2
    //   91: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   94: iload_1
    //   95: ireturn
    //   96: astore 4
    //   98: aload_3
    //   99: astore_2
    //   100: aload 4
    //   102: astore_3
    //   103: goto +36 -> 139
    //   106: astore 4
    //   108: goto +14 -> 122
    //   111: astore_3
    //   112: goto +27 -> 139
    //   115: astore_2
    //   116: aload 4
    //   118: astore_3
    //   119: aload_2
    //   120: astore 4
    //   122: aload_3
    //   123: astore_2
    //   124: aload 4
    //   126: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   129: aload_3
    //   130: ifnull +7 -> 137
    //   133: aload_3
    //   134: invokevirtual 148	java/io/InputStream:close	()V
    //   137: iconst_0
    //   138: ireturn
    //   139: aload_2
    //   140: ifnull +15 -> 155
    //   143: aload_2
    //   144: invokevirtual 148	java/io/InputStream:close	()V
    //   147: goto +8 -> 155
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   155: aload_3
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	76	0	bool1	boolean
    //   10	85	1	bool2	boolean
    //   17	59	2	str	java.lang.String
    //   89	2	2	localIOException1	java.io.IOException
    //   99	1	2	localObject1	java.lang.Object
    //   115	5	2	localIOException2	java.io.IOException
    //   123	21	2	localObject2	java.lang.Object
    //   150	2	2	localIOException3	java.io.IOException
    //   37	66	3	localObject3	java.lang.Object
    //   111	1	3	localObject4	java.lang.Object
    //   118	38	3	localIOException4	java.io.IOException
    //   14	1	4	localObject5	java.lang.Object
    //   96	5	4	localObject6	java.lang.Object
    //   106	11	4	localIOException5	java.io.IOException
    //   120	5	4	localObject7	java.lang.Object
    //   7	60	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   83	87	89	java/io/IOException
    //   133	137	89	java/io/IOException
    //   38	75	96	finally
    //   38	75	106	java/io/IOException
    //   18	38	111	finally
    //   124	129	111	finally
    //   18	38	115	java/io/IOException
    //   143	147	150	java/io/IOException
  }
  
  private Paint b()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(Color.parseColor("#dd000000"));
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    return localPaint;
  }
  
  private Paint c()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(0);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    return localPaint;
  }
  
  private boolean getShouldBeRounded()
  {
    boolean[] arrayOfBoolean = this.j;
    int n = arrayOfBoolean.length;
    int m = 0;
    while (m < n)
    {
      if (arrayOfBoolean[m] != 0) {
        return true;
      }
      m += 1;
    }
    return false;
  }
  
  public final int a(Context paramContext, int paramInt)
  {
    return (int)(paramInt * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (getShouldBeRounded())
    {
      this.h.reset();
      this.h.setFillType(Path.FillType.INVERSE_WINDING);
      float[] arrayOfFloat = new float[8];
      int m = 0;
      while (m < this.j.length)
      {
        int n;
        if (this.j[m] != 0)
        {
          n = m * 2;
          float f1 = this.e;
          arrayOfFloat[(n + 1)] = f1;
          arrayOfFloat[n] = f1;
        }
        else
        {
          n = m * 2;
          arrayOfFloat[(n + 1)] = 0.0F;
          arrayOfFloat[n] = 0.0F;
        }
        m += 1;
      }
      this.h.addRoundRect(a(getScrollY(), this.c, this.d), arrayOfFloat, Path.Direction.CW);
      paramCanvas.drawPath(this.h, this.g);
      if (!this.k) {
        paramCanvas.drawPath(this.h, this.f);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (getShouldBeRounded())
    {
      this.c = paramInt1;
      this.d = paramInt2;
    }
  }
  
  public void setShouldBeRounded(int paramInt)
  {
    paramInt &= 0xF;
    boolean[] arrayOfBoolean = this.j;
    int n = 0;
    if ((paramInt & 0x1) == 1) {
      m = 1;
    } else {
      m = 0;
    }
    arrayOfBoolean[0] = m;
    arrayOfBoolean = this.j;
    if ((paramInt & 0x2) == 2) {
      m = 1;
    } else {
      m = 0;
    }
    arrayOfBoolean[1] = m;
    arrayOfBoolean = this.j;
    if ((paramInt & 0x4) == 4) {
      m = 1;
    } else {
      m = 0;
    }
    arrayOfBoolean[2] = m;
    arrayOfBoolean = this.j;
    int m = n;
    if ((paramInt & 0x8) == 8) {
      m = 1;
    }
    arrayOfBoolean[3] = m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.jsbridge.APRoundedWebView
 * JD-Core Version:    0.7.0.1
 */