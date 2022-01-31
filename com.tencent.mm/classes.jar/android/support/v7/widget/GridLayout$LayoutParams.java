package android.support.v7.widget;

import android.content.res.TypedArray;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class GridLayout$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  private static final int BOTTOM_MARGIN = 6;
  private static final int LEFT_MARGIN;
  private static final int MARGIN;
  private static final int RIGHT_MARGIN;
  private static final int TOP_MARGIN;
  private static final GridLayout.f afo;
  private static final int afp;
  private static final int afq = 10;
  private static final int afr = 11;
  private static final int afs = 12;
  private static final int aft = 7;
  private static final int afu = 8;
  private static final int afv = 9;
  private static final int afw = 13;
  public GridLayout.i afx = GridLayout.i.afC;
  public GridLayout.i afy = GridLayout.i.afC;
  
  static
  {
    GridLayout.f localf = new GridLayout.f(-2147483648, -2147483647);
    afo = localf;
    afp = localf.size();
    MARGIN = 2;
    LEFT_MARGIN = 3;
    TOP_MARGIN = 4;
    RIGHT_MARGIN = 5;
  }
  
  public GridLayout$LayoutParams()
  {
    this(locali, locali, (byte)0);
  }
  
  /* Error */
  public GridLayout$LayoutParams(android.content.Context paramContext, android.util.AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 80	android/view/ViewGroup$MarginLayoutParams:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: getstatic 74	android/support/v7/widget/GridLayout$i:afC	Landroid/support/v7/widget/GridLayout$i;
    //   10: putfield 82	android/support/v7/widget/GridLayout$LayoutParams:afx	Landroid/support/v7/widget/GridLayout$i;
    //   13: aload_0
    //   14: getstatic 74	android/support/v7/widget/GridLayout$i:afC	Landroid/support/v7/widget/GridLayout$i;
    //   17: putfield 84	android/support/v7/widget/GridLayout$LayoutParams:afy	Landroid/support/v7/widget/GridLayout$i;
    //   20: aload_1
    //   21: aload_2
    //   22: getstatic 90	android/support/v7/e/a$a:GridLayout_Layout	[I
    //   25: invokevirtual 96	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   28: astore 7
    //   30: aload 7
    //   32: getstatic 46	android/support/v7/widget/GridLayout$LayoutParams:MARGIN	I
    //   35: ldc 31
    //   37: invokevirtual 102	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   40: istore 4
    //   42: aload_0
    //   43: aload 7
    //   45: getstatic 48	android/support/v7/widget/GridLayout$LayoutParams:LEFT_MARGIN	I
    //   48: iload 4
    //   50: invokevirtual 102	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   53: putfield 105	android/support/v7/widget/GridLayout$LayoutParams:leftMargin	I
    //   56: aload_0
    //   57: aload 7
    //   59: getstatic 50	android/support/v7/widget/GridLayout$LayoutParams:TOP_MARGIN	I
    //   62: iload 4
    //   64: invokevirtual 102	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   67: putfield 108	android/support/v7/widget/GridLayout$LayoutParams:topMargin	I
    //   70: aload_0
    //   71: aload 7
    //   73: getstatic 52	android/support/v7/widget/GridLayout$LayoutParams:RIGHT_MARGIN	I
    //   76: iload 4
    //   78: invokevirtual 102	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   81: putfield 111	android/support/v7/widget/GridLayout$LayoutParams:rightMargin	I
    //   84: aload_0
    //   85: aload 7
    //   87: getstatic 54	android/support/v7/widget/GridLayout$LayoutParams:BOTTOM_MARGIN	I
    //   90: iload 4
    //   92: invokevirtual 102	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   95: putfield 114	android/support/v7/widget/GridLayout$LayoutParams:bottomMargin	I
    //   98: aload 7
    //   100: invokevirtual 117	android/content/res/TypedArray:recycle	()V
    //   103: aload_1
    //   104: aload_2
    //   105: getstatic 90	android/support/v7/e/a$a:GridLayout_Layout	[I
    //   108: invokevirtual 96	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   111: astore_1
    //   112: aload_1
    //   113: getstatic 68	android/support/v7/widget/GridLayout$LayoutParams:afw	I
    //   116: iconst_0
    //   117: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
    //   120: istore 4
    //   122: aload_1
    //   123: getstatic 56	android/support/v7/widget/GridLayout$LayoutParams:afq	I
    //   126: ldc 31
    //   128: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
    //   131: istore 5
    //   133: aload_1
    //   134: getstatic 58	android/support/v7/widget/GridLayout$LayoutParams:afr	I
    //   137: getstatic 44	android/support/v7/widget/GridLayout$LayoutParams:afp	I
    //   140: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
    //   143: istore 6
    //   145: aload_1
    //   146: getstatic 60	android/support/v7/widget/GridLayout$LayoutParams:afs	I
    //   149: fconst_0
    //   150: invokevirtual 124	android/content/res/TypedArray:getFloat	(IF)F
    //   153: fstore_3
    //   154: aload_0
    //   155: iload 5
    //   157: iload 6
    //   159: iload 4
    //   161: iconst_1
    //   162: invokestatic 128	android/support/v7/widget/GridLayout:j	(IZ)Landroid/support/v7/widget/GridLayout$a;
    //   165: fload_3
    //   166: invokestatic 132	android/support/v7/widget/GridLayout:a	(IILandroid/support/v7/widget/GridLayout$a;F)Landroid/support/v7/widget/GridLayout$i;
    //   169: putfield 84	android/support/v7/widget/GridLayout$LayoutParams:afy	Landroid/support/v7/widget/GridLayout$i;
    //   172: aload_1
    //   173: getstatic 62	android/support/v7/widget/GridLayout$LayoutParams:aft	I
    //   176: ldc 31
    //   178: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
    //   181: istore 5
    //   183: aload_1
    //   184: getstatic 64	android/support/v7/widget/GridLayout$LayoutParams:afu	I
    //   187: getstatic 44	android/support/v7/widget/GridLayout$LayoutParams:afp	I
    //   190: invokevirtual 120	android/content/res/TypedArray:getInt	(II)I
    //   193: istore 6
    //   195: aload_1
    //   196: getstatic 66	android/support/v7/widget/GridLayout$LayoutParams:afv	I
    //   199: fconst_0
    //   200: invokevirtual 124	android/content/res/TypedArray:getFloat	(IF)F
    //   203: fstore_3
    //   204: aload_0
    //   205: iload 5
    //   207: iload 6
    //   209: iload 4
    //   211: iconst_0
    //   212: invokestatic 128	android/support/v7/widget/GridLayout:j	(IZ)Landroid/support/v7/widget/GridLayout$a;
    //   215: fload_3
    //   216: invokestatic 132	android/support/v7/widget/GridLayout:a	(IILandroid/support/v7/widget/GridLayout$a;F)Landroid/support/v7/widget/GridLayout$i;
    //   219: putfield 82	android/support/v7/widget/GridLayout$LayoutParams:afx	Landroid/support/v7/widget/GridLayout$i;
    //   222: aload_1
    //   223: invokevirtual 117	android/content/res/TypedArray:recycle	()V
    //   226: return
    //   227: astore_1
    //   228: aload 7
    //   230: invokevirtual 117	android/content/res/TypedArray:recycle	()V
    //   233: aload_1
    //   234: athrow
    //   235: astore_2
    //   236: aload_1
    //   237: invokevirtual 117	android/content/res/TypedArray:recycle	()V
    //   240: aload_2
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	LayoutParams
    //   0	242	1	paramContext	android.content.Context
    //   0	242	2	paramAttributeSet	android.util.AttributeSet
    //   153	63	3	f	float
    //   40	170	4	i	int
    //   131	75	5	j	int
    //   143	65	6	k	int
    //   28	201	7	localTypedArray	TypedArray
    // Exception table:
    //   from	to	target	type
    //   30	98	227	finally
    //   112	222	235	finally
  }
  
  public GridLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.afx = paramLayoutParams.afx;
    this.afy = paramLayoutParams.afy;
  }
  
  private GridLayout$LayoutParams(GridLayout.i parami1, GridLayout.i parami2)
  {
    super(-2, -2);
    setMargins(-2147483648, -2147483648, -2147483648, -2147483648);
    this.afx = parami1;
    this.afy = parami2;
  }
  
  private GridLayout$LayoutParams(GridLayout.i parami1, GridLayout.i parami2, byte paramByte)
  {
    this(parami1, parami2);
  }
  
  public GridLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public GridLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (LayoutParams)paramObject;
      if (!this.afy.equals(paramObject.afy)) {
        return false;
      }
    } while (this.afx.equals(paramObject.afx));
    return false;
  }
  
  public int hashCode()
  {
    return this.afx.hashCode() * 31 + this.afy.hashCode();
  }
  
  protected void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    this.width = paramTypedArray.getLayoutDimension(paramInt1, -2);
    this.height = paramTypedArray.getLayoutDimension(paramInt2, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.GridLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */