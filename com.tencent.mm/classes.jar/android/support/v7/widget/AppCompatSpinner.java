package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class AppCompatSpinner
  extends Spinner
  implements android.support.v4.view.s
{
  private static final int[] akV = { 16843505 };
  private ab aeX;
  private final Context ahr;
  private SpinnerAdapter akW;
  private final boolean akX;
  b akY;
  int akZ;
  private final e akc;
  final Rect mTempRect;
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969554);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  /* Error */
  private AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 59	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 61	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 63	android/graphics/Rect:<init>	()V
    //   15: putfield 65	android/support/v7/widget/AppCompatSpinner:mTempRect	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 70	android/support/v7/a/a$a:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic 75	android/support/v7/widget/az:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/az;
    //   28: astore 8
    //   30: aload_0
    //   31: new 77	android/support/v7/widget/e
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 80	android/support/v7/widget/e:<init>	(Landroid/view/View;)V
    //   39: putfield 82	android/support/v7/widget/AppCompatSpinner:akc	Landroid/support/v7/widget/e;
    //   42: aload 8
    //   44: iconst_4
    //   45: iconst_0
    //   46: invokevirtual 86	android/support/v7/widget/az:getResourceId	(II)I
    //   49: istore 5
    //   51: iload 5
    //   53: ifeq +263 -> 316
    //   56: new 88	android/support/v7/view/d
    //   59: dup
    //   60: aload_1
    //   61: iload 5
    //   63: invokespecial 91	android/support/v7/view/d:<init>	(Landroid/content/Context;I)V
    //   66: astore 7
    //   68: aload_0
    //   69: aload 7
    //   71: putfield 93	android/support/v7/widget/AppCompatSpinner:ahr	Landroid/content/Context;
    //   74: aload_0
    //   75: getfield 93	android/support/v7/widget/AppCompatSpinner:ahr	Landroid/content/Context;
    //   78: ifnull +155 -> 233
    //   81: aload_1
    //   82: aload_2
    //   83: getstatic 43	android/support/v7/widget/AppCompatSpinner:akV	[I
    //   86: iload_3
    //   87: iconst_0
    //   88: invokevirtual 99	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   91: astore 7
    //   93: iload 4
    //   95: istore 5
    //   97: aload 7
    //   99: iconst_0
    //   100: invokevirtual 105	android/content/res/TypedArray:hasValue	(I)Z
    //   103: ifeq +12 -> 115
    //   106: aload 7
    //   108: iconst_0
    //   109: iconst_0
    //   110: invokevirtual 108	android/content/res/TypedArray:getInt	(II)I
    //   113: istore 5
    //   115: iload 5
    //   117: istore 6
    //   119: aload 7
    //   121: ifnull +12 -> 133
    //   124: aload 7
    //   126: invokevirtual 111	android/content/res/TypedArray:recycle	()V
    //   129: iload 5
    //   131: istore 6
    //   133: iload 6
    //   135: iconst_1
    //   136: if_icmpne +97 -> 233
    //   139: new 13	android/support/v7/widget/AppCompatSpinner$b
    //   142: dup
    //   143: aload_0
    //   144: aload_0
    //   145: getfield 93	android/support/v7/widget/AppCompatSpinner:ahr	Landroid/content/Context;
    //   148: aload_2
    //   149: iload_3
    //   150: invokespecial 114	android/support/v7/widget/AppCompatSpinner$b:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   153: astore 7
    //   155: aload_0
    //   156: getfield 93	android/support/v7/widget/AppCompatSpinner:ahr	Landroid/content/Context;
    //   159: aload_2
    //   160: getstatic 70	android/support/v7/a/a$a:Spinner	[I
    //   163: iload_3
    //   164: iconst_0
    //   165: invokestatic 75	android/support/v7/widget/az:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/az;
    //   168: astore 9
    //   170: aload_0
    //   171: aload 9
    //   173: iconst_3
    //   174: bipush 254
    //   176: invokevirtual 117	android/support/v7/widget/az:getLayoutDimension	(II)I
    //   179: putfield 119	android/support/v7/widget/AppCompatSpinner:akZ	I
    //   182: aload 7
    //   184: aload 9
    //   186: iconst_1
    //   187: invokevirtual 123	android/support/v7/widget/az:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   190: invokevirtual 127	android/support/v7/widget/AppCompatSpinner$b:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   193: aload 7
    //   195: aload 8
    //   197: iconst_2
    //   198: invokevirtual 131	android/support/v7/widget/az:getString	(I)Ljava/lang/String;
    //   201: putfield 135	android/support/v7/widget/AppCompatSpinner$b:ale	Ljava/lang/CharSequence;
    //   204: aload 9
    //   206: getfield 139	android/support/v7/widget/az:ayy	Landroid/content/res/TypedArray;
    //   209: invokevirtual 111	android/content/res/TypedArray:recycle	()V
    //   212: aload_0
    //   213: aload 7
    //   215: putfield 141	android/support/v7/widget/AppCompatSpinner:akY	Landroid/support/v7/widget/AppCompatSpinner$b;
    //   218: aload_0
    //   219: new 8	android/support/v7/widget/AppCompatSpinner$1
    //   222: dup
    //   223: aload_0
    //   224: aload_0
    //   225: aload 7
    //   227: invokespecial 144	android/support/v7/widget/AppCompatSpinner$1:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/AppCompatSpinner$b;)V
    //   230: putfield 146	android/support/v7/widget/AppCompatSpinner:aeX	Landroid/support/v7/widget/ab;
    //   233: aload 8
    //   235: getfield 139	android/support/v7/widget/az:ayy	Landroid/content/res/TypedArray;
    //   238: iconst_0
    //   239: invokevirtual 150	android/content/res/TypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   242: astore 7
    //   244: aload 7
    //   246: ifnull +27 -> 273
    //   249: new 152	android/widget/ArrayAdapter
    //   252: dup
    //   253: aload_1
    //   254: ldc 153
    //   256: aload 7
    //   258: invokespecial 156	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   261: astore_1
    //   262: aload_1
    //   263: ldc 157
    //   265: invokevirtual 161	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   268: aload_0
    //   269: aload_1
    //   270: invokevirtual 165	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   273: aload 8
    //   275: getfield 139	android/support/v7/widget/az:ayy	Landroid/content/res/TypedArray;
    //   278: invokevirtual 111	android/content/res/TypedArray:recycle	()V
    //   281: aload_0
    //   282: iconst_1
    //   283: putfield 167	android/support/v7/widget/AppCompatSpinner:akX	Z
    //   286: aload_0
    //   287: getfield 169	android/support/v7/widget/AppCompatSpinner:akW	Landroid/widget/SpinnerAdapter;
    //   290: ifnull +16 -> 306
    //   293: aload_0
    //   294: aload_0
    //   295: getfield 169	android/support/v7/widget/AppCompatSpinner:akW	Landroid/widget/SpinnerAdapter;
    //   298: invokevirtual 165	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   301: aload_0
    //   302: aconst_null
    //   303: putfield 169	android/support/v7/widget/AppCompatSpinner:akW	Landroid/widget/SpinnerAdapter;
    //   306: aload_0
    //   307: getfield 82	android/support/v7/widget/AppCompatSpinner:akc	Landroid/support/v7/widget/e;
    //   310: aload_2
    //   311: iload_3
    //   312: invokevirtual 172	android/support/v7/widget/e:a	(Landroid/util/AttributeSet;I)V
    //   315: return
    //   316: getstatic 177	android/os/Build$VERSION:SDK_INT	I
    //   319: bipush 23
    //   321: if_icmpge +9 -> 330
    //   324: aload_1
    //   325: astore 7
    //   327: goto -259 -> 68
    //   330: aconst_null
    //   331: astore 7
    //   333: goto -265 -> 68
    //   336: astore 7
    //   338: aconst_null
    //   339: astore 7
    //   341: iload 4
    //   343: istore 6
    //   345: aload 7
    //   347: ifnull -214 -> 133
    //   350: aload 7
    //   352: invokevirtual 111	android/content/res/TypedArray:recycle	()V
    //   355: iload 4
    //   357: istore 6
    //   359: goto -226 -> 133
    //   362: astore_1
    //   363: aconst_null
    //   364: astore_2
    //   365: aload_2
    //   366: ifnull +7 -> 373
    //   369: aload_2
    //   370: invokevirtual 111	android/content/res/TypedArray:recycle	()V
    //   373: aload_1
    //   374: athrow
    //   375: astore_1
    //   376: aload 7
    //   378: astore_2
    //   379: goto -14 -> 365
    //   382: astore 9
    //   384: goto -43 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	AppCompatSpinner
    //   0	387	1	paramContext	Context
    //   0	387	2	paramAttributeSet	AttributeSet
    //   0	387	3	paramInt1	int
    //   0	387	4	paramInt2	int
    //   49	81	5	i	int
    //   117	241	6	j	int
    //   66	266	7	localObject1	Object
    //   336	1	7	localException1	java.lang.Exception
    //   339	38	7	localObject2	Object
    //   28	246	8	localaz1	az
    //   168	37	9	localaz2	az
    //   382	1	9	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   81	93	336	java/lang/Exception
    //   81	93	362	finally
    //   97	115	375	finally
    //   97	115	382	java/lang/Exception
  }
  
  final int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int n = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int i = Math.max(0, getSelectedItemPosition());
    int i2 = Math.min(paramSpinnerAdapter.getCount(), i + 15);
    int j = Math.max(0, i - (15 - (i2 - i)));
    i = 0;
    View localView = null;
    int k = 0;
    if (j < i2)
    {
      int m = paramSpinnerAdapter.getItemViewType(j);
      if (m == i) {
        break label204;
      }
      localView = null;
      i = m;
    }
    label204:
    for (;;)
    {
      localView = paramSpinnerAdapter.getView(j, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(this.mTempRect);
        return this.mTempRect.left + this.mTempRect.right + k;
      }
      return k;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.akc != null) {
      this.akc.jg();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    if (this.akY != null) {
      return this.akY.are;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    if (this.akY != null) {
      return this.akY.getVerticalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownVerticalOffset();
    }
    return 0;
  }
  
  public int getDropDownWidth()
  {
    if (this.akY != null) {
      return this.akZ;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownWidth();
    }
    return 0;
  }
  
  public Drawable getPopupBackground()
  {
    if (this.akY != null) {
      return this.akY.arA.getBackground();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getPopupBackground();
    }
    return null;
  }
  
  public Context getPopupContext()
  {
    if (this.akY != null) {
      return this.ahr;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return super.getPopupContext();
    }
    return null;
  }
  
  public CharSequence getPrompt()
  {
    if (this.akY != null) {
      return this.akY.ale;
    }
    return super.getPrompt();
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.akc != null) {
      return this.akc.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.akc != null) {
      return this.akc.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.akY != null) && (this.akY.arA.isShowing())) {
      this.akY.dismiss();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.akY != null) && (View.MeasureSpec.getMode(paramInt1) == -2147483648)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.aeX != null) && (this.aeX.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    if (this.akY != null)
    {
      if (!this.akY.arA.isShowing()) {
        this.akY.show();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.akX) {
      this.akW = paramSpinnerAdapter;
    }
    do
    {
      return;
      super.setAdapter(paramSpinnerAdapter);
    } while (this.akY == null);
    if (this.ahr == null) {}
    for (Context localContext = getContext();; localContext = this.ahr)
    {
      this.akY.setAdapter(new a(paramSpinnerAdapter, localContext.getTheme()));
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.akc != null) {
      this.akc.jf();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.akc != null) {
      this.akc.bH(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    if (this.akY != null) {
      this.akY.are = paramInt;
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setDropDownHorizontalOffset(paramInt);
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    if (this.akY != null) {
      this.akY.setVerticalOffset(paramInt);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setDropDownVerticalOffset(paramInt);
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (this.akY != null) {
      this.akZ = paramInt;
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setDropDownWidth(paramInt);
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.akY != null) {
      this.akY.setBackgroundDrawable(paramDrawable);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setPopupBackgroundDrawable(paramDrawable);
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(a.l(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    if (this.akY != null)
    {
      this.akY.ale = paramCharSequence;
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.akc != null) {
      this.akc.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.akc != null) {
      this.akc.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  static final class a
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter alc;
    private ListAdapter ald;
    
    public a(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
    {
      this.alc = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        this.ald = ((ListAdapter)paramSpinnerAdapter);
      }
      if ((paramTheme != null) && (Build.VERSION.SDK_INT >= 23) && ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter)))
      {
        paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
        if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
          paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
        }
      }
    }
    
    public final boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = this.ald;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public final int getCount()
    {
      if (this.alc == null) {
        return 0;
      }
      return this.alc.getCount();
    }
    
    public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (this.alc == null) {
        return null;
      }
      return this.alc.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public final Object getItem(int paramInt)
    {
      if (this.alc == null) {
        return null;
      }
      return this.alc.getItem(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      if (this.alc == null) {
        return -1L;
      }
      return this.alc.getItemId(paramInt);
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public final int getViewTypeCount()
    {
      return 1;
    }
    
    public final boolean hasStableIds()
    {
      return (this.alc != null) && (this.alc.hasStableIds());
    }
    
    public final boolean isEmpty()
    {
      return getCount() == 0;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = this.ald;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.alc != null) {
        this.alc.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.alc != null) {
        this.alc.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  final class b
    extends ListPopupWindow
  {
    ListAdapter GO;
    CharSequence ale;
    final Rect alf = new Rect();
    
    public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      this.arp = AppCompatSpinner.this;
      setModal(true);
      this.aro = 0;
      this.ars = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppCompatSpinner.this.setSelection(paramAnonymousInt);
          if (AppCompatSpinner.this.getOnItemClickListener() != null) {
            AppCompatSpinner.this.performItemClick(paramAnonymousView, paramAnonymousInt, AppCompatSpinner.b.this.GO.getItemId(paramAnonymousInt));
          }
          AppCompatSpinner.b.this.dismiss();
        }
      };
    }
    
    final void jn()
    {
      Object localObject = this.arA.getBackground();
      int i;
      int m;
      int n;
      int i1;
      int j;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(AppCompatSpinner.this.mTempRect);
        if (bh.d(AppCompatSpinner.this))
        {
          i = AppCompatSpinner.this.mTempRect.right;
          m = AppCompatSpinner.this.getPaddingLeft();
          n = AppCompatSpinner.this.getPaddingRight();
          i1 = AppCompatSpinner.this.getWidth();
          if (AppCompatSpinner.this.akZ != -2) {
            break label246;
          }
          j = AppCompatSpinner.this.a((SpinnerAdapter)this.GO, this.arA.getBackground());
          int k = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left - AppCompatSpinner.this.mTempRect.right;
          if (j <= k) {
            break label294;
          }
          j = k;
        }
      }
      label294:
      for (;;)
      {
        setContentWidth(Math.max(j, i1 - m - n));
        label171:
        if (bh.d(AppCompatSpinner.this)) {
          i = i1 - n - this.akZ + i;
        }
        for (;;)
        {
          this.are = i;
          return;
          i = -AppCompatSpinner.this.mTempRect.left;
          break;
          localObject = AppCompatSpinner.this.mTempRect;
          AppCompatSpinner.this.mTempRect.right = 0;
          ((Rect)localObject).left = 0;
          i = 0;
          break;
          label246:
          if (AppCompatSpinner.this.akZ == -1)
          {
            setContentWidth(i1 - m - n);
            break label171;
          }
          setContentWidth(AppCompatSpinner.this.akZ);
          break label171;
          i += m;
        }
      }
    }
    
    public final void setAdapter(ListAdapter paramListAdapter)
    {
      super.setAdapter(paramListAdapter);
      this.GO = paramListAdapter;
    }
    
    public final void show()
    {
      boolean bool = this.arA.isShowing();
      jn();
      kC();
      super.show();
      this.arc.setChoiceMode(1);
      int i = AppCompatSpinner.this.getSelectedItemPosition();
      Object localObject = this.arc;
      if ((this.arA.isShowing()) && (localObject != null))
      {
        ((y)localObject).setListSelectionHidden(false);
        ((y)localObject).setSelection(i);
        if (((y)localObject).getChoiceMode() != 0) {
          ((y)localObject).setItemChecked(i, true);
        }
      }
      if (bool) {}
      do
      {
        return;
        localObject = AppCompatSpinner.this.getViewTreeObserver();
      } while (localObject == null);
      final ViewTreeObserver.OnGlobalLayoutListener local2 = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppCompatSpinner.b localb = AppCompatSpinner.b.this;
          AppCompatSpinner localAppCompatSpinner = AppCompatSpinner.this;
          if ((u.aD(localAppCompatSpinner)) && (localAppCompatSpinner.getGlobalVisibleRect(localb.alf))) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppCompatSpinner.b.this.dismiss();
            return;
          }
          AppCompatSpinner.b.this.jn();
          AppCompatSpinner.b.a(AppCompatSpinner.b.this);
        }
      };
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
      setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          ViewTreeObserver localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
          if (localViewTreeObserver != null) {
            localViewTreeObserver.removeGlobalOnLayoutListener(local2);
          }
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner
 * JD-Core Version:    0.7.0.1
 */