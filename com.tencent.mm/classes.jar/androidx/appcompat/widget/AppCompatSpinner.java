package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
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
import androidx.appcompat.a.a;
import androidx.appcompat.a.a.a;
import androidx.appcompat.view.menu.s;
import androidx.core.g.u;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatSpinner
  extends Spinner
  implements u
{
  private static final int[] rf = { 16843505 };
  private r lf;
  private final d mBackgroundTintHelper;
  final Rect mTempRect;
  private final Context nE;
  private SpinnerAdapter rg;
  private final boolean rh;
  b ri;
  int rj;
  
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
    //   7: ldc 64
    //   9: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: new 72	android/graphics/Rect
    //   16: dup
    //   17: invokespecial 74	android/graphics/Rect:<init>	()V
    //   20: putfield 76	androidx/appcompat/widget/AppCompatSpinner:mTempRect	Landroid/graphics/Rect;
    //   23: aload_1
    //   24: aload_2
    //   25: getstatic 81	androidx/appcompat/a$j:Spinner	[I
    //   28: iload_3
    //   29: iconst_0
    //   30: invokestatic 86	androidx/appcompat/widget/ac:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/ac;
    //   33: astore 8
    //   35: aload_0
    //   36: new 88	androidx/appcompat/widget/d
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 91	androidx/appcompat/widget/d:<init>	(Landroid/view/View;)V
    //   44: putfield 93	androidx/appcompat/widget/AppCompatSpinner:mBackgroundTintHelper	Landroidx/appcompat/widget/d;
    //   47: aload 8
    //   49: getstatic 96	androidx/appcompat/a$j:Spinner_popupTheme	I
    //   52: iconst_0
    //   53: invokevirtual 100	androidx/appcompat/widget/ac:r	(II)I
    //   56: istore 5
    //   58: iload 5
    //   60: ifeq +281 -> 341
    //   63: new 102	androidx/appcompat/view/d
    //   66: dup
    //   67: aload_1
    //   68: iload 5
    //   70: invokespecial 105	androidx/appcompat/view/d:<init>	(Landroid/content/Context;I)V
    //   73: astore 7
    //   75: aload_0
    //   76: aload 7
    //   78: putfield 107	androidx/appcompat/widget/AppCompatSpinner:nE	Landroid/content/Context;
    //   81: aload_0
    //   82: getfield 107	androidx/appcompat/widget/AppCompatSpinner:nE	Landroid/content/Context;
    //   85: ifnull +161 -> 246
    //   88: aload_1
    //   89: aload_2
    //   90: getstatic 43	androidx/appcompat/widget/AppCompatSpinner:rf	[I
    //   93: iload_3
    //   94: iconst_0
    //   95: invokevirtual 113	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   98: astore 7
    //   100: iload 4
    //   102: istore 5
    //   104: aload 7
    //   106: iconst_0
    //   107: invokevirtual 119	android/content/res/TypedArray:hasValue	(I)Z
    //   110: ifeq +12 -> 122
    //   113: aload 7
    //   115: iconst_0
    //   116: iconst_0
    //   117: invokevirtual 122	android/content/res/TypedArray:getInt	(II)I
    //   120: istore 5
    //   122: iload 5
    //   124: istore 6
    //   126: aload 7
    //   128: ifnull +12 -> 140
    //   131: aload 7
    //   133: invokevirtual 125	android/content/res/TypedArray:recycle	()V
    //   136: iload 5
    //   138: istore 6
    //   140: iload 6
    //   142: iconst_1
    //   143: if_icmpne +103 -> 246
    //   146: new 13	androidx/appcompat/widget/AppCompatSpinner$b
    //   149: dup
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 107	androidx/appcompat/widget/AppCompatSpinner:nE	Landroid/content/Context;
    //   155: aload_2
    //   156: iload_3
    //   157: invokespecial 128	androidx/appcompat/widget/AppCompatSpinner$b:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   160: astore 7
    //   162: aload_0
    //   163: getfield 107	androidx/appcompat/widget/AppCompatSpinner:nE	Landroid/content/Context;
    //   166: aload_2
    //   167: getstatic 81	androidx/appcompat/a$j:Spinner	[I
    //   170: iload_3
    //   171: iconst_0
    //   172: invokestatic 86	androidx/appcompat/widget/ac:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/ac;
    //   175: astore 9
    //   177: aload_0
    //   178: aload 9
    //   180: getstatic 131	androidx/appcompat/a$j:Spinner_android_dropDownWidth	I
    //   183: bipush 254
    //   185: invokevirtual 134	androidx/appcompat/widget/ac:q	(II)I
    //   188: putfield 136	androidx/appcompat/widget/AppCompatSpinner:rj	I
    //   191: aload 7
    //   193: aload 9
    //   195: getstatic 139	androidx/appcompat/a$j:Spinner_android_popupBackground	I
    //   198: invokevirtual 143	androidx/appcompat/widget/ac:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   201: invokevirtual 147	androidx/appcompat/widget/AppCompatSpinner$b:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   204: aload 7
    //   206: aload 8
    //   208: getstatic 150	androidx/appcompat/a$j:Spinner_android_prompt	I
    //   211: invokevirtual 154	androidx/appcompat/widget/ac:getString	(I)Ljava/lang/String;
    //   214: putfield 158	androidx/appcompat/widget/AppCompatSpinner$b:ro	Ljava/lang/CharSequence;
    //   217: aload 9
    //   219: getfield 162	androidx/appcompat/widget/ac:wA	Landroid/content/res/TypedArray;
    //   222: invokevirtual 125	android/content/res/TypedArray:recycle	()V
    //   225: aload_0
    //   226: aload 7
    //   228: putfield 164	androidx/appcompat/widget/AppCompatSpinner:ri	Landroidx/appcompat/widget/AppCompatSpinner$b;
    //   231: aload_0
    //   232: new 8	androidx/appcompat/widget/AppCompatSpinner$1
    //   235: dup
    //   236: aload_0
    //   237: aload_0
    //   238: aload 7
    //   240: invokespecial 167	androidx/appcompat/widget/AppCompatSpinner$1:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/view/View;Landroidx/appcompat/widget/AppCompatSpinner$b;)V
    //   243: putfield 169	androidx/appcompat/widget/AppCompatSpinner:lf	Landroidx/appcompat/widget/r;
    //   246: getstatic 172	androidx/appcompat/a$j:Spinner_android_entries	I
    //   249: istore 4
    //   251: aload 8
    //   253: getfield 162	androidx/appcompat/widget/ac:wA	Landroid/content/res/TypedArray;
    //   256: iload 4
    //   258: invokevirtual 176	android/content/res/TypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   261: astore 7
    //   263: aload 7
    //   265: ifnull +28 -> 293
    //   268: new 178	android/widget/ArrayAdapter
    //   271: dup
    //   272: aload_1
    //   273: ldc 179
    //   275: aload 7
    //   277: invokespecial 182	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   280: astore_1
    //   281: aload_1
    //   282: getstatic 187	androidx/appcompat/a$g:support_simple_spinner_dropdown_item	I
    //   285: invokevirtual 190	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   288: aload_0
    //   289: aload_1
    //   290: invokevirtual 194	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   293: aload 8
    //   295: getfield 162	androidx/appcompat/widget/ac:wA	Landroid/content/res/TypedArray;
    //   298: invokevirtual 125	android/content/res/TypedArray:recycle	()V
    //   301: aload_0
    //   302: iconst_1
    //   303: putfield 196	androidx/appcompat/widget/AppCompatSpinner:rh	Z
    //   306: aload_0
    //   307: getfield 198	androidx/appcompat/widget/AppCompatSpinner:rg	Landroid/widget/SpinnerAdapter;
    //   310: ifnull +16 -> 326
    //   313: aload_0
    //   314: aload_0
    //   315: getfield 198	androidx/appcompat/widget/AppCompatSpinner:rg	Landroid/widget/SpinnerAdapter;
    //   318: invokevirtual 194	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   321: aload_0
    //   322: aconst_null
    //   323: putfield 198	androidx/appcompat/widget/AppCompatSpinner:rg	Landroid/widget/SpinnerAdapter;
    //   326: aload_0
    //   327: getfield 93	androidx/appcompat/widget/AppCompatSpinner:mBackgroundTintHelper	Landroidx/appcompat/widget/d;
    //   330: aload_2
    //   331: iload_3
    //   332: invokevirtual 201	androidx/appcompat/widget/d:a	(Landroid/util/AttributeSet;I)V
    //   335: ldc 64
    //   337: invokestatic 204	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: return
    //   341: getstatic 209	android/os/Build$VERSION:SDK_INT	I
    //   344: bipush 23
    //   346: if_icmpge +9 -> 355
    //   349: aload_1
    //   350: astore 7
    //   352: goto -277 -> 75
    //   355: aconst_null
    //   356: astore 7
    //   358: goto -283 -> 75
    //   361: astore 7
    //   363: aconst_null
    //   364: astore 7
    //   366: iload 4
    //   368: istore 6
    //   370: aload 7
    //   372: ifnull -232 -> 140
    //   375: aload 7
    //   377: invokevirtual 125	android/content/res/TypedArray:recycle	()V
    //   380: iload 4
    //   382: istore 6
    //   384: goto -244 -> 140
    //   387: astore_1
    //   388: aconst_null
    //   389: astore_2
    //   390: aload_2
    //   391: ifnull +7 -> 398
    //   394: aload_2
    //   395: invokevirtual 125	android/content/res/TypedArray:recycle	()V
    //   398: ldc 64
    //   400: invokestatic 204	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: aload_1
    //   404: athrow
    //   405: astore_1
    //   406: aload 7
    //   408: astore_2
    //   409: goto -19 -> 390
    //   412: astore 9
    //   414: goto -48 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	this	AppCompatSpinner
    //   0	417	1	paramContext	Context
    //   0	417	2	paramAttributeSet	AttributeSet
    //   0	417	3	paramInt1	int
    //   0	417	4	paramInt2	int
    //   56	81	5	i	int
    //   124	259	6	j	int
    //   73	284	7	localObject1	Object
    //   361	1	7	localException1	java.lang.Exception
    //   364	43	7	localObject2	Object
    //   33	261	8	localac1	ac
    //   175	43	9	localac2	ac
    //   412	1	9	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   88	100	361	java/lang/Exception
    //   88	100	387	finally
    //   104	122	405	finally
    //   104	122	412	java/lang/Exception
  }
  
  final int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    AppMethodBeat.i(241048);
    if (paramSpinnerAdapter == null)
    {
      AppMethodBeat.o(241048);
      return 0;
    }
    int n = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int i = Math.max(0, getSelectedItemPosition());
    int i2 = Math.min(paramSpinnerAdapter.getCount(), i + 15);
    int k = Math.max(0, i - (15 - (i2 - i)));
    int j = 0;
    View localView = null;
    i = 0;
    if (k < i2)
    {
      int m = paramSpinnerAdapter.getItemViewType(k);
      if (m == j) {
        break label220;
      }
      localView = null;
      j = m;
    }
    label220:
    for (;;)
    {
      localView = paramSpinnerAdapter.getView(k, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(n, i1);
      i = Math.max(i, localView.getMeasuredWidth());
      k += 1;
      break;
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(this.mTempRect);
        i = this.mTempRect.left + this.mTempRect.right + i;
      }
      for (;;)
      {
        AppMethodBeat.o(241048);
        return i;
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(241047);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dm();
    }
    AppMethodBeat.o(241047);
  }
  
  public int getDropDownHorizontalOffset()
  {
    AppMethodBeat.i(241023);
    int i;
    if (this.ri != null)
    {
      i = this.ri.ta;
      AppMethodBeat.o(241023);
      return i;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = super.getDropDownHorizontalOffset();
      AppMethodBeat.o(241023);
      return i;
    }
    AppMethodBeat.o(241023);
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    AppMethodBeat.i(241017);
    int i;
    if (this.ri != null)
    {
      i = this.ri.dL();
      AppMethodBeat.o(241017);
      return i;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = super.getDropDownVerticalOffset();
      AppMethodBeat.o(241017);
      return i;
    }
    AppMethodBeat.o(241017);
    return 0;
  }
  
  public int getDropDownWidth()
  {
    AppMethodBeat.i(241025);
    int i;
    if (this.ri != null)
    {
      i = this.rj;
      AppMethodBeat.o(241025);
      return i;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = super.getDropDownWidth();
      AppMethodBeat.o(241025);
      return i;
    }
    AppMethodBeat.o(241025);
    return 0;
  }
  
  public Drawable getPopupBackground()
  {
    AppMethodBeat.i(241012);
    Drawable localDrawable;
    if (this.ri != null)
    {
      localDrawable = this.ri.ty.getBackground();
      AppMethodBeat.o(241012);
      return localDrawable;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      localDrawable = super.getPopupBackground();
      AppMethodBeat.o(241012);
      return localDrawable;
    }
    AppMethodBeat.o(241012);
    return null;
  }
  
  public Context getPopupContext()
  {
    AppMethodBeat.i(241008);
    Context localContext;
    if (this.ri != null)
    {
      localContext = this.nE;
      AppMethodBeat.o(241008);
      return localContext;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      localContext = super.getPopupContext();
      AppMethodBeat.o(241008);
      return localContext;
    }
    AppMethodBeat.o(241008);
    return null;
  }
  
  public CharSequence getPrompt()
  {
    AppMethodBeat.i(241035);
    if (this.ri != null)
    {
      localCharSequence = this.ri.ro;
      AppMethodBeat.o(241035);
      return localCharSequence;
    }
    CharSequence localCharSequence = super.getPrompt();
    AppMethodBeat.o(241035);
    return localCharSequence;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(241044);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(241044);
      return localColorStateList;
    }
    AppMethodBeat.o(241044);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(241046);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(241046);
      return localMode;
    }
    AppMethodBeat.o(241046);
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(241028);
    super.onDetachedFromWindow();
    if ((this.ri != null) && (this.ri.ty.isShowing())) {
      this.ri.dismiss();
    }
    AppMethodBeat.o(241028);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241030);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.ri != null) && (View.MeasureSpec.getMode(paramInt1) == -2147483648)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
    AppMethodBeat.o(241030);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(241029);
    if ((this.lf != null) && (this.lf.onTouch(this, paramMotionEvent)))
    {
      AppMethodBeat.o(241029);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(241029);
    return bool;
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(241032);
    if (this.ri != null)
    {
      if (!this.ri.ty.isShowing()) {
        this.ri.show();
      }
      AppMethodBeat.o(241032);
      return true;
    }
    boolean bool = super.performClick();
    AppMethodBeat.o(241032);
    return bool;
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    AppMethodBeat.i(241027);
    if (!this.rh)
    {
      this.rg = paramSpinnerAdapter;
      AppMethodBeat.o(241027);
      return;
    }
    super.setAdapter(paramSpinnerAdapter);
    if (this.ri != null) {
      if (this.nE != null) {
        break label75;
      }
    }
    label75:
    for (Context localContext = getContext();; localContext = this.nE)
    {
      this.ri.setAdapter(new a(paramSpinnerAdapter, localContext.getTheme()));
      AppMethodBeat.o(241027);
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(241039);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dl();
    }
    AppMethodBeat.o(241039);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(241037);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ar(paramInt);
    }
    AppMethodBeat.o(241037);
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    AppMethodBeat.i(241021);
    if (this.ri != null)
    {
      this.ri.ta = paramInt;
      AppMethodBeat.o(241021);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownHorizontalOffset(paramInt);
    }
    AppMethodBeat.o(241021);
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    AppMethodBeat.i(241016);
    if (this.ri != null)
    {
      this.ri.ah(paramInt);
      AppMethodBeat.o(241016);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownVerticalOffset(paramInt);
    }
    AppMethodBeat.o(241016);
  }
  
  public void setDropDownWidth(int paramInt)
  {
    AppMethodBeat.i(241024);
    if (this.ri != null)
    {
      this.rj = paramInt;
      AppMethodBeat.o(241024);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownWidth(paramInt);
    }
    AppMethodBeat.o(241024);
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(241010);
    if (this.ri != null)
    {
      this.ri.setBackgroundDrawable(paramDrawable);
      AppMethodBeat.o(241010);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      super.setPopupBackgroundDrawable(paramDrawable);
    }
    AppMethodBeat.o(241010);
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(241011);
    setPopupBackgroundDrawable(a.m(getPopupContext(), paramInt));
    AppMethodBeat.o(241011);
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(241033);
    if (this.ri != null)
    {
      this.ri.ro = paramCharSequence;
      AppMethodBeat.o(241033);
      return;
    }
    super.setPrompt(paramCharSequence);
    AppMethodBeat.o(241033);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(241040);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(241040);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(241045);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(241045);
  }
  
  static final class a
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter rm;
    private ListAdapter rn;
    
    public a(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(240958);
      this.rm = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        this.rn = ((ListAdapter)paramSpinnerAdapter);
      }
      if ((paramTheme != null) && (Build.VERSION.SDK_INT >= 23) && ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter)))
      {
        paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
        if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
          paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
        }
      }
      AppMethodBeat.o(240958);
    }
    
    public final boolean areAllItemsEnabled()
    {
      AppMethodBeat.i(240972);
      ListAdapter localListAdapter = this.rn;
      if (localListAdapter != null)
      {
        boolean bool = localListAdapter.areAllItemsEnabled();
        AppMethodBeat.o(240972);
        return bool;
      }
      AppMethodBeat.o(240972);
      return true;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(240959);
      if (this.rm == null)
      {
        AppMethodBeat.o(240959);
        return 0;
      }
      int i = this.rm.getCount();
      AppMethodBeat.o(240959);
      return i;
    }
    
    public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(240963);
      if (this.rm == null)
      {
        AppMethodBeat.o(240963);
        return null;
      }
      paramView = this.rm.getDropDownView(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(240963);
      return paramView;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(240960);
      if (this.rm == null)
      {
        AppMethodBeat.o(240960);
        return null;
      }
      Object localObject = this.rm.getItem(paramInt);
      AppMethodBeat.o(240960);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(240961);
      if (this.rm == null)
      {
        AppMethodBeat.o(240961);
        return -1L;
      }
      long l = this.rm.getItemId(paramInt);
      AppMethodBeat.o(240961);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(240962);
      paramView = getDropDownView(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(240962);
      return paramView;
    }
    
    public final int getViewTypeCount()
    {
      return 1;
    }
    
    public final boolean hasStableIds()
    {
      AppMethodBeat.i(240965);
      if ((this.rm != null) && (this.rm.hasStableIds()))
      {
        AppMethodBeat.o(240965);
        return true;
      }
      AppMethodBeat.o(240965);
      return false;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(240976);
      if (getCount() == 0)
      {
        AppMethodBeat.o(240976);
        return true;
      }
      AppMethodBeat.o(240976);
      return false;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(240973);
      ListAdapter localListAdapter = this.rn;
      if (localListAdapter != null)
      {
        boolean bool = localListAdapter.isEnabled(paramInt);
        AppMethodBeat.o(240973);
        return bool;
      }
      AppMethodBeat.o(240973);
      return true;
    }
    
    public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      AppMethodBeat.i(240967);
      if (this.rm != null) {
        this.rm.registerDataSetObserver(paramDataSetObserver);
      }
      AppMethodBeat.o(240967);
    }
    
    public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      AppMethodBeat.i(240969);
      if (this.rm != null) {
        this.rm.unregisterDataSetObserver(paramDataSetObserver);
      }
      AppMethodBeat.o(240969);
    }
  }
  
  final class b
    extends ListPopupWindow
  {
    ListAdapter eP;
    CharSequence ro;
    final Rect rp;
    
    public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      AppMethodBeat.i(240993);
      this.rp = new Rect();
      this.tl = AppCompatSpinner.this;
      P(true);
      dK();
      this.tp = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(240981);
          AppCompatSpinner.this.setSelection(paramAnonymousInt);
          if (AppCompatSpinner.this.getOnItemClickListener() != null) {
            AppCompatSpinner.this.performItemClick(paramAnonymousView, paramAnonymousInt, AppCompatSpinner.b.this.eP.getItemId(paramAnonymousInt));
          }
          AppCompatSpinner.b.this.dismiss();
          AppMethodBeat.o(240981);
        }
      };
      AppMethodBeat.o(240993);
    }
    
    final void dt()
    {
      AppMethodBeat.i(240995);
      Object localObject = this.ty.getBackground();
      int i;
      int m;
      int n;
      int i1;
      int j;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(AppCompatSpinner.this.mTempRect);
        if (ai.s(AppCompatSpinner.this))
        {
          i = AppCompatSpinner.this.mTempRect.right;
          m = AppCompatSpinner.this.getPaddingLeft();
          n = AppCompatSpinner.this.getPaddingRight();
          i1 = AppCompatSpinner.this.getWidth();
          if (AppCompatSpinner.this.rj != -2) {
            break label256;
          }
          j = AppCompatSpinner.this.a((SpinnerAdapter)this.eP, this.ty.getBackground());
          int k = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left - AppCompatSpinner.this.mTempRect.right;
          if (j <= k) {
            break label304;
          }
          j = k;
        }
      }
      label256:
      label304:
      for (;;)
      {
        setContentWidth(Math.max(j, i1 - m - n));
        label176:
        if (ai.s(AppCompatSpinner.this)) {
          i = i1 - n - this.rj + i;
        }
        for (;;)
        {
          this.ta = i;
          AppMethodBeat.o(240995);
          return;
          i = -AppCompatSpinner.this.mTempRect.left;
          break;
          localObject = AppCompatSpinner.this.mTempRect;
          AppCompatSpinner.this.mTempRect.right = 0;
          ((Rect)localObject).left = 0;
          i = 0;
          break;
          if (AppCompatSpinner.this.rj == -1)
          {
            setContentWidth(i1 - m - n);
            break label176;
          }
          setContentWidth(AppCompatSpinner.this.rj);
          break label176;
          i += m;
        }
      }
    }
    
    public final void setAdapter(ListAdapter paramListAdapter)
    {
      AppMethodBeat.i(240994);
      super.setAdapter(paramListAdapter);
      this.eP = paramListAdapter;
      AppMethodBeat.o(240994);
    }
    
    public final void show()
    {
      AppMethodBeat.i(240997);
      boolean bool = isShowing();
      dt();
      dN();
      super.show();
      this.sY.setChoiceMode(1);
      int i = AppCompatSpinner.this.getSelectedItemPosition();
      Object localObject = this.sY;
      if ((isShowing()) && (localObject != null))
      {
        ((p)localObject).setListSelectionHidden(false);
        ((p)localObject).setSelection(i);
        if (((p)localObject).getChoiceMode() != 0) {
          ((p)localObject).setItemChecked(i, true);
        }
      }
      if (bool)
      {
        AppMethodBeat.o(240997);
        return;
      }
      localObject = AppCompatSpinner.this.getViewTreeObserver();
      if (localObject != null)
      {
        final ViewTreeObserver.OnGlobalLayoutListener local2 = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(240986);
            AppCompatSpinner.b localb = AppCompatSpinner.b.this;
            AppCompatSpinner localAppCompatSpinner = AppCompatSpinner.this;
            if ((w.al(localAppCompatSpinner)) && (localAppCompatSpinner.getGlobalVisibleRect(localb.rp))) {}
            for (int i = 1; i == 0; i = 0)
            {
              AppCompatSpinner.b.this.dismiss();
              AppMethodBeat.o(240986);
              return;
            }
            AppCompatSpinner.b.this.dt();
            AppCompatSpinner.b.a(AppCompatSpinner.b.this);
            AppMethodBeat.o(240986);
          }
        };
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(local2);
        setOnDismissListener(new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(240991);
            ViewTreeObserver localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (localViewTreeObserver != null) {
              localViewTreeObserver.removeGlobalOnLayoutListener(local2);
            }
            AppMethodBeat.o(240991);
          }
        });
      }
      AppMethodBeat.o(240997);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSpinner
 * JD-Core Version:    0.7.0.1
 */