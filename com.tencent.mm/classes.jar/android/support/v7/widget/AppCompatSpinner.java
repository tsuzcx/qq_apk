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
import android.support.v4.view.p;
import android.support.v4.view.q;
import android.support.v7.a.a.a;
import android.support.v7.c.a.b;
import android.support.v7.view.menu.s;
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
  implements p
{
  private static final int[] aah = { 16843505 };
  private ac Uj;
  private final Context WB;
  private final f Zo;
  private SpinnerAdapter aai;
  private final boolean aaj;
  private b aak;
  private int aal;
  private final Rect ec;
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.spinnerStyle);
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
    //   4: invokespecial 63	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 65	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 67	android/graphics/Rect:<init>	()V
    //   15: putfield 69	android/support/v7/widget/AppCompatSpinner:ec	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 74	android/support/v7/a/a$j:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic 79	android/support/v7/widget/ax:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/ax;
    //   28: astore 8
    //   30: aload_0
    //   31: new 81	android/support/v7/widget/f
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 84	android/support/v7/widget/f:<init>	(Landroid/view/View;)V
    //   39: putfield 86	android/support/v7/widget/AppCompatSpinner:Zo	Landroid/support/v7/widget/f;
    //   42: aload 8
    //   44: getstatic 89	android/support/v7/a/a$j:Spinner_popupTheme	I
    //   47: iconst_0
    //   48: invokevirtual 93	android/support/v7/widget/ax:getResourceId	(II)I
    //   51: istore 5
    //   53: iload 5
    //   55: ifeq +276 -> 331
    //   58: new 95	android/support/v7/view/d
    //   61: dup
    //   62: aload_1
    //   63: iload 5
    //   65: invokespecial 98	android/support/v7/view/d:<init>	(Landroid/content/Context;I)V
    //   68: astore 7
    //   70: aload_0
    //   71: aload 7
    //   73: putfield 100	android/support/v7/widget/AppCompatSpinner:WB	Landroid/content/Context;
    //   76: aload_0
    //   77: getfield 100	android/support/v7/widget/AppCompatSpinner:WB	Landroid/content/Context;
    //   80: ifnull +161 -> 241
    //   83: aload_1
    //   84: aload_2
    //   85: getstatic 43	android/support/v7/widget/AppCompatSpinner:aah	[I
    //   88: iload_3
    //   89: iconst_0
    //   90: invokevirtual 106	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   93: astore 7
    //   95: iload 4
    //   97: istore 5
    //   99: aload 7
    //   101: iconst_0
    //   102: invokevirtual 112	android/content/res/TypedArray:hasValue	(I)Z
    //   105: ifeq +12 -> 117
    //   108: aload 7
    //   110: iconst_0
    //   111: iconst_0
    //   112: invokevirtual 115	android/content/res/TypedArray:getInt	(II)I
    //   115: istore 5
    //   117: iload 5
    //   119: istore 6
    //   121: aload 7
    //   123: ifnull +12 -> 135
    //   126: aload 7
    //   128: invokevirtual 118	android/content/res/TypedArray:recycle	()V
    //   131: iload 5
    //   133: istore 6
    //   135: iload 6
    //   137: iconst_1
    //   138: if_icmpne +103 -> 241
    //   141: new 13	android/support/v7/widget/AppCompatSpinner$b
    //   144: dup
    //   145: aload_0
    //   146: aload_0
    //   147: getfield 100	android/support/v7/widget/AppCompatSpinner:WB	Landroid/content/Context;
    //   150: aload_2
    //   151: iload_3
    //   152: invokespecial 121	android/support/v7/widget/AppCompatSpinner$b:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   155: astore 7
    //   157: aload_0
    //   158: getfield 100	android/support/v7/widget/AppCompatSpinner:WB	Landroid/content/Context;
    //   161: aload_2
    //   162: getstatic 74	android/support/v7/a/a$j:Spinner	[I
    //   165: iload_3
    //   166: iconst_0
    //   167: invokestatic 79	android/support/v7/widget/ax:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/ax;
    //   170: astore 9
    //   172: aload_0
    //   173: aload 9
    //   175: getstatic 124	android/support/v7/a/a$j:Spinner_android_dropDownWidth	I
    //   178: bipush 254
    //   180: invokevirtual 127	android/support/v7/widget/ax:getLayoutDimension	(II)I
    //   183: putfield 129	android/support/v7/widget/AppCompatSpinner:aal	I
    //   186: aload 7
    //   188: aload 9
    //   190: getstatic 132	android/support/v7/a/a$j:Spinner_android_popupBackground	I
    //   193: invokevirtual 136	android/support/v7/widget/ax:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   196: invokevirtual 140	android/support/v7/widget/AppCompatSpinner$b:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   199: aload 7
    //   201: aload 8
    //   203: getstatic 143	android/support/v7/a/a$j:Spinner_android_prompt	I
    //   206: invokevirtual 147	android/support/v7/widget/ax:getString	(I)Ljava/lang/String;
    //   209: putfield 151	android/support/v7/widget/AppCompatSpinner$b:aaq	Ljava/lang/CharSequence;
    //   212: aload 9
    //   214: getfield 155	android/support/v7/widget/ax:alZ	Landroid/content/res/TypedArray;
    //   217: invokevirtual 118	android/content/res/TypedArray:recycle	()V
    //   220: aload_0
    //   221: aload 7
    //   223: putfield 157	android/support/v7/widget/AppCompatSpinner:aak	Landroid/support/v7/widget/AppCompatSpinner$b;
    //   226: aload_0
    //   227: new 8	android/support/v7/widget/AppCompatSpinner$1
    //   230: dup
    //   231: aload_0
    //   232: aload_0
    //   233: aload 7
    //   235: invokespecial 160	android/support/v7/widget/AppCompatSpinner$1:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/AppCompatSpinner$b;)V
    //   238: putfield 162	android/support/v7/widget/AppCompatSpinner:Uj	Landroid/support/v7/widget/ac;
    //   241: getstatic 165	android/support/v7/a/a$j:Spinner_android_entries	I
    //   244: istore 4
    //   246: aload 8
    //   248: getfield 155	android/support/v7/widget/ax:alZ	Landroid/content/res/TypedArray;
    //   251: iload 4
    //   253: invokevirtual 169	android/content/res/TypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   256: astore 7
    //   258: aload 7
    //   260: ifnull +28 -> 288
    //   263: new 171	android/widget/ArrayAdapter
    //   266: dup
    //   267: aload_1
    //   268: ldc 172
    //   270: aload 7
    //   272: invokespecial 175	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   275: astore_1
    //   276: aload_1
    //   277: getstatic 180	android/support/v7/a/a$g:support_simple_spinner_dropdown_item	I
    //   280: invokevirtual 184	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   283: aload_0
    //   284: aload_1
    //   285: invokevirtual 188	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   288: aload 8
    //   290: getfield 155	android/support/v7/widget/ax:alZ	Landroid/content/res/TypedArray;
    //   293: invokevirtual 118	android/content/res/TypedArray:recycle	()V
    //   296: aload_0
    //   297: iconst_1
    //   298: putfield 190	android/support/v7/widget/AppCompatSpinner:aaj	Z
    //   301: aload_0
    //   302: getfield 192	android/support/v7/widget/AppCompatSpinner:aai	Landroid/widget/SpinnerAdapter;
    //   305: ifnull +16 -> 321
    //   308: aload_0
    //   309: aload_0
    //   310: getfield 192	android/support/v7/widget/AppCompatSpinner:aai	Landroid/widget/SpinnerAdapter;
    //   313: invokevirtual 188	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   316: aload_0
    //   317: aconst_null
    //   318: putfield 192	android/support/v7/widget/AppCompatSpinner:aai	Landroid/widget/SpinnerAdapter;
    //   321: aload_0
    //   322: getfield 86	android/support/v7/widget/AppCompatSpinner:Zo	Landroid/support/v7/widget/f;
    //   325: aload_2
    //   326: iload_3
    //   327: invokevirtual 195	android/support/v7/widget/f:b	(Landroid/util/AttributeSet;I)V
    //   330: return
    //   331: getstatic 200	android/os/Build$VERSION:SDK_INT	I
    //   334: bipush 23
    //   336: if_icmpge +9 -> 345
    //   339: aload_1
    //   340: astore 7
    //   342: goto -272 -> 70
    //   345: aconst_null
    //   346: astore 7
    //   348: goto -278 -> 70
    //   351: astore 7
    //   353: aconst_null
    //   354: astore 7
    //   356: iload 4
    //   358: istore 6
    //   360: aload 7
    //   362: ifnull -227 -> 135
    //   365: aload 7
    //   367: invokevirtual 118	android/content/res/TypedArray:recycle	()V
    //   370: iload 4
    //   372: istore 6
    //   374: goto -239 -> 135
    //   377: astore_1
    //   378: aconst_null
    //   379: astore_2
    //   380: aload_2
    //   381: ifnull +7 -> 388
    //   384: aload_2
    //   385: invokevirtual 118	android/content/res/TypedArray:recycle	()V
    //   388: aload_1
    //   389: athrow
    //   390: astore_1
    //   391: aload 7
    //   393: astore_2
    //   394: goto -14 -> 380
    //   397: astore 9
    //   399: goto -43 -> 356
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	AppCompatSpinner
    //   0	402	1	paramContext	Context
    //   0	402	2	paramAttributeSet	AttributeSet
    //   0	402	3	paramInt1	int
    //   0	402	4	paramInt2	int
    //   51	81	5	i	int
    //   119	254	6	j	int
    //   68	279	7	localObject1	Object
    //   351	1	7	localException1	java.lang.Exception
    //   354	38	7	localObject2	Object
    //   28	261	8	localax1	ax
    //   170	43	9	localax2	ax
    //   397	1	9	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   83	95	351	java/lang/Exception
    //   83	95	377	finally
    //   99	117	390	finally
    //   99	117	397	java/lang/Exception
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
        paramDrawable.getPadding(this.ec);
        return this.ec.left + this.ec.right + k;
      }
      return k;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.Zo != null) {
      this.Zo.gf();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    if (this.aak != null) {
      return this.aak.aeJ;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    if (this.aak != null) {
      return this.aak.getVerticalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownVerticalOffset();
    }
    return 0;
  }
  
  public int getDropDownWidth()
  {
    if (this.aak != null) {
      return this.aal;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownWidth();
    }
    return 0;
  }
  
  public Drawable getPopupBackground()
  {
    if (this.aak != null) {
      return this.aak.afe.getBackground();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getPopupBackground();
    }
    return null;
  }
  
  public Context getPopupContext()
  {
    if (this.aak != null) {
      return this.WB;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return super.getPopupContext();
    }
    return null;
  }
  
  public CharSequence getPrompt()
  {
    if (this.aak != null) {
      return this.aak.aaq;
    }
    return super.getPrompt();
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.Zo != null) {
      return this.Zo.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.Zo != null) {
      return this.Zo.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.aak != null) && (this.aak.afe.isShowing())) {
      this.aak.dismiss();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.aak != null) && (View.MeasureSpec.getMode(paramInt1) == -2147483648)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.Uj != null) && (this.Uj.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    if (this.aak != null)
    {
      if (!this.aak.afe.isShowing()) {
        this.aak.show();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.aaj) {
      this.aai = paramSpinnerAdapter;
    }
    do
    {
      return;
      super.setAdapter(paramSpinnerAdapter);
    } while (this.aak == null);
    if (this.WB == null) {}
    for (Context localContext = getContext();; localContext = this.WB)
    {
      this.aak.setAdapter(new a(paramSpinnerAdapter, localContext.getTheme()));
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.Zo != null) {
      this.Zo.ge();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.Zo != null) {
      this.Zo.bp(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    if (this.aak != null) {
      this.aak.aeJ = paramInt;
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setDropDownHorizontalOffset(paramInt);
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    if (this.aak != null) {
      this.aak.setVerticalOffset(paramInt);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setDropDownVerticalOffset(paramInt);
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (this.aak != null) {
      this.aal = paramInt;
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setDropDownWidth(paramInt);
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.aak != null) {
      this.aak.setBackgroundDrawable(paramDrawable);
    }
    while (Build.VERSION.SDK_INT < 16) {
      return;
    }
    super.setPopupBackgroundDrawable(paramDrawable);
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(b.g(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    if (this.aak != null)
    {
      this.aak.aaq = paramCharSequence;
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.Zo != null) {
      this.Zo.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.Zo != null) {
      this.Zo.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  private static final class a
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter aao;
    private ListAdapter aap;
    
    public a(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
    {
      this.aao = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        this.aap = ((ListAdapter)paramSpinnerAdapter);
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
      ListAdapter localListAdapter = this.aap;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public final int getCount()
    {
      if (this.aao == null) {
        return 0;
      }
      return this.aao.getCount();
    }
    
    public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (this.aao == null) {
        return null;
      }
      return this.aao.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public final Object getItem(int paramInt)
    {
      if (this.aao == null) {
        return null;
      }
      return this.aao.getItem(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      if (this.aao == null) {
        return -1L;
      }
      return this.aao.getItemId(paramInt);
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
      return (this.aao != null) && (this.aao.hasStableIds());
    }
    
    public final boolean isEmpty()
    {
      return getCount() == 0;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = this.aap;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.aao != null) {
        this.aao.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.aao != null) {
        this.aao.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  private final class b
    extends ListPopupWindow
  {
    ListAdapter NK;
    CharSequence aaq;
    final Rect aar = new Rect();
    
    public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      this.aeU = AppCompatSpinner.this;
      setModal(true);
      this.aeT = 0;
      this.aeW = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppCompatSpinner.this.setSelection(paramAnonymousInt);
          if (AppCompatSpinner.this.getOnItemClickListener() != null) {
            AppCompatSpinner.this.performItemClick(paramAnonymousView, paramAnonymousInt, AppCompatSpinner.b.this.NK.getItemId(paramAnonymousInt));
          }
          AppCompatSpinner.b.this.dismiss();
        }
      };
    }
    
    final void gl()
    {
      Object localObject = this.afe.getBackground();
      int i;
      int m;
      int n;
      int i1;
      int j;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(AppCompatSpinner.b(AppCompatSpinner.this));
        if (bf.bF(AppCompatSpinner.this))
        {
          i = AppCompatSpinner.b(AppCompatSpinner.this).right;
          m = AppCompatSpinner.this.getPaddingLeft();
          n = AppCompatSpinner.this.getPaddingRight();
          i1 = AppCompatSpinner.this.getWidth();
          if (AppCompatSpinner.c(AppCompatSpinner.this) != -2) {
            break label246;
          }
          j = AppCompatSpinner.this.a((SpinnerAdapter)this.NK, this.afe.getBackground());
          int k = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.b(AppCompatSpinner.this).left - AppCompatSpinner.b(AppCompatSpinner.this).right;
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
        if (bf.bF(AppCompatSpinner.this)) {
          i = i1 - n - this.aal + i;
        }
        for (;;)
        {
          this.aeJ = i;
          return;
          i = -AppCompatSpinner.b(AppCompatSpinner.this).left;
          break;
          localObject = AppCompatSpinner.b(AppCompatSpinner.this);
          AppCompatSpinner.b(AppCompatSpinner.this).right = 0;
          ((Rect)localObject).left = 0;
          i = 0;
          break;
          label246:
          if (AppCompatSpinner.c(AppCompatSpinner.this) == -1)
          {
            setContentWidth(i1 - m - n);
            break label171;
          }
          setContentWidth(AppCompatSpinner.c(AppCompatSpinner.this));
          break label171;
          i += m;
        }
      }
    }
    
    public final void setAdapter(ListAdapter paramListAdapter)
    {
      super.setAdapter(paramListAdapter);
      this.NK = paramListAdapter;
    }
    
    public final void show()
    {
      boolean bool = this.afe.isShowing();
      gl();
      hf();
      super.show();
      this.aeH.setChoiceMode(1);
      int i = AppCompatSpinner.this.getSelectedItemPosition();
      Object localObject = this.aeH;
      if ((this.afe.isShowing()) && (localObject != null))
      {
        ((z)localObject).setListSelectionHidden(false);
        ((z)localObject).setSelection(i);
        if (((z)localObject).getChoiceMode() != 0) {
          ((z)localObject).setItemChecked(i, true);
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
          if ((q.ao(localAppCompatSpinner)) && (localAppCompatSpinner.getGlobalVisibleRect(localb.aar))) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppCompatSpinner.b.this.dismiss();
            return;
          }
          AppCompatSpinner.b.this.gl();
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