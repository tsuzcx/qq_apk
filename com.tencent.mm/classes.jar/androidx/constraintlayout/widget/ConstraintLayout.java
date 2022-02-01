package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.e.b;
import androidx.constraintlayout.a.a.e.c;
import androidx.constraintlayout.a.a.f.a;
import androidx.constraintlayout.a.a.g;
import androidx.constraintlayout.a.a.i;
import androidx.constraintlayout.a.a.m;
import androidx.constraintlayout.a.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintLayout
  extends ViewGroup
{
  private int biW;
  private int bjR;
  SparseArray<View> bkN;
  private ArrayList<ConstraintHelper> bkO;
  private final ArrayList<androidx.constraintlayout.a.a.f> bkP;
  g bkQ;
  private int bkR;
  private boolean bkS;
  private a bkT;
  private int bkU;
  private HashMap<String, Integer> bkV;
  private int bkW;
  private int bkX;
  int bkY;
  int bkZ;
  int bla;
  int blb;
  private androidx.constraintlayout.a.f blc;
  private int mf;
  private int vF;
  
  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(194170);
    this.bkN = new SparseArray();
    this.bkO = new ArrayList(4);
    this.bkP = new ArrayList(100);
    this.bkQ = new g();
    this.mf = 0;
    this.biW = 0;
    this.vF = 2147483647;
    this.bkR = 2147483647;
    this.bkS = true;
    this.bjR = 7;
    this.bkT = null;
    this.bkU = -1;
    this.bkV = new HashMap();
    this.bkW = -1;
    this.bkX = -1;
    this.bkY = -1;
    this.bkZ = -1;
    this.bla = 0;
    this.blb = 0;
    f(null);
    AppMethodBeat.o(194170);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194179);
    this.bkN = new SparseArray();
    this.bkO = new ArrayList(4);
    this.bkP = new ArrayList(100);
    this.bkQ = new g();
    this.mf = 0;
    this.biW = 0;
    this.vF = 2147483647;
    this.bkR = 2147483647;
    this.bkS = true;
    this.bjR = 7;
    this.bkT = null;
    this.bkU = -1;
    this.bkV = new HashMap();
    this.bkW = -1;
    this.bkX = -1;
    this.bkY = -1;
    this.bkZ = -1;
    this.bla = 0;
    this.blb = 0;
    f(paramAttributeSet);
    AppMethodBeat.o(194179);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194187);
    this.bkN = new SparseArray();
    this.bkO = new ArrayList(4);
    this.bkP = new ArrayList(100);
    this.bkQ = new g();
    this.mf = 0;
    this.biW = 0;
    this.vF = 2147483647;
    this.bkR = 2147483647;
    this.bkS = true;
    this.bjR = 7;
    this.bkT = null;
    this.bkU = -1;
    this.bkV = new HashMap();
    this.bkW = -1;
    this.bkX = -1;
    this.bkY = -1;
    this.bkZ = -1;
    this.bla = 0;
    this.blb = 0;
    f(paramAttributeSet);
    AppMethodBeat.o(194187);
  }
  
  private void Dj()
  {
    AppMethodBeat.i(194203);
    this.bkQ.CY();
    if (this.blc != null)
    {
      AppMethodBeat.o(194203);
      throw null;
    }
    AppMethodBeat.o(194203);
  }
  
  protected static LayoutParams Dk()
  {
    AppMethodBeat.i(194206);
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    AppMethodBeat.o(194206);
    return localLayoutParams;
  }
  
  private final androidx.constraintlayout.a.a.f dT(int paramInt)
  {
    AppMethodBeat.i(194200);
    if (paramInt == 0)
    {
      localObject = this.bkQ;
      AppMethodBeat.o(194200);
      return localObject;
    }
    View localView = (View)this.bkN.get(paramInt);
    Object localObject = localView;
    if (localView == null)
    {
      localView = findViewById(paramInt);
      localObject = localView;
      if (localView != null)
      {
        localObject = localView;
        if (localView != this)
        {
          localObject = localView;
          if (localView.getParent() == this)
          {
            onViewAdded(localView);
            localObject = localView;
          }
        }
      }
    }
    if (localObject == this)
    {
      localObject = this.bkQ;
      AppMethodBeat.o(194200);
      return localObject;
    }
    if (localObject == null)
    {
      AppMethodBeat.o(194200);
      return null;
    }
    localObject = ((LayoutParams)((View)localObject).getLayoutParams()).bml;
    AppMethodBeat.o(194200);
    return localObject;
  }
  
  private void f(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(194195);
    this.bkQ.bjc = this;
    this.bkN.put(getId(), this);
    this.bkT = null;
    int j;
    label185:
    int m;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int k = paramAttributeSet.getIndexCount();
      int i = 0;
      if (i < k)
      {
        j = paramAttributeSet.getIndex(i);
        if (j == R.styleable.ConstraintLayout_Layout_android_minWidth) {
          this.mf = paramAttributeSet.getDimensionPixelOffset(j, this.mf);
        }
        do
        {
          for (;;)
          {
            i += 1;
            break;
            if (j == R.styleable.ConstraintLayout_Layout_android_minHeight)
            {
              this.biW = paramAttributeSet.getDimensionPixelOffset(j, this.biW);
            }
            else if (j == R.styleable.ConstraintLayout_Layout_android_maxWidth)
            {
              this.vF = paramAttributeSet.getDimensionPixelOffset(j, this.vF);
            }
            else if (j == R.styleable.ConstraintLayout_Layout_android_maxHeight)
            {
              this.bkR = paramAttributeSet.getDimensionPixelOffset(j, this.bkR);
            }
            else
            {
              if (j != R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                break label185;
              }
              this.bjR = paramAttributeSet.getInt(j, this.bjR);
            }
          }
        } while (j != R.styleable.ConstraintLayout_Layout_constraintSet);
        m = paramAttributeSet.getResourceId(j, 0);
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          this.bkT = new a();
          a locala = this.bkT;
          localContext = getContext();
          localXmlResourceParser = localContext.getResources().getXml(m);
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          Context localContext;
          XmlResourceParser localXmlResourceParser;
          String str;
          Object localObject;
          a.a locala1;
          this.bkT = null;
          continue;
        }
        try
        {
          j = localXmlResourceParser.getEventType();
          break label404;
          j = localXmlResourceParser.next();
          break label404;
          localXmlResourceParser.getName();
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          this.bkU = m;
          break;
          str = localXmlResourceParser.getName();
          localObject = Xml.asAttributeSet(localXmlResourceParser);
          locala1 = new a.a((byte)0);
          localObject = localContext.obtainStyledAttributes((AttributeSet)localObject, R.styleable.ConstraintSet);
          a.a(locala1, (TypedArray)localObject);
          ((TypedArray)localObject).recycle();
          if (str.equalsIgnoreCase("Guideline")) {
            locala1.bmr = true;
          }
          localXmlPullParserException.bmp.put(Integer.valueOf(locala1.bms), locala1);
        }
        catch (IOException localIOException) {}
      }
      paramAttributeSet.recycle();
      this.bkQ.bjR = this.bjR;
      AppMethodBeat.o(194195);
      return;
      label404:
      if (j != 1) {
        switch (j)
        {
        }
      }
    }
  }
  
  private void k(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(194162);
    if (((paramObject1 instanceof String)) && ((paramObject2 instanceof Integer)))
    {
      if (this.bkV == null) {
        this.bkV = new HashMap();
      }
      String str = (String)paramObject1;
      int i = str.indexOf("/");
      paramObject1 = str;
      if (i != -1) {
        paramObject1 = str.substring(i + 1);
      }
      i = ((Integer)paramObject2).intValue();
      this.bkV.put(paramObject1, Integer.valueOf(i));
    }
    AppMethodBeat.o(194162);
  }
  
  public final androidx.constraintlayout.a.a.f D(View paramView)
  {
    AppMethodBeat.i(194296);
    if (paramView == this)
    {
      paramView = this.bkQ;
      AppMethodBeat.o(194296);
      return paramView;
    }
    if (paramView == null)
    {
      AppMethodBeat.o(194296);
      return null;
    }
    paramView = ((LayoutParams)paramView.getLayoutParams()).bml;
    AppMethodBeat.o(194296);
    return paramView;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(194222);
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14) {
      onViewAdded(paramView);
    }
    AppMethodBeat.o(194222);
  }
  
  public final Object at(Object paramObject)
  {
    AppMethodBeat.i(194212);
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ((this.bkV != null) && (this.bkV.containsKey(paramObject)))
      {
        paramObject = this.bkV.get(paramObject);
        AppMethodBeat.o(194212);
        return paramObject;
      }
    }
    AppMethodBeat.o(194212);
    return null;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final View dU(int paramInt)
  {
    AppMethodBeat.i(194395);
    View localView = (View)this.bkN.get(paramInt);
    AppMethodBeat.o(194395);
    return localView;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(194403);
    super.dispatchDraw(paramCanvas);
    if (isInEditMode())
    {
      int j = getChildCount();
      float f1 = getWidth();
      float f2 = getHeight();
      int i = 0;
      while (i < j)
      {
        Object localObject = getChildAt(i);
        if (((View)localObject).getVisibility() != 8)
        {
          localObject = ((View)localObject).getTag();
          if ((localObject != null) && ((localObject instanceof String)))
          {
            localObject = ((String)localObject).split(",");
            if (localObject.length == 4)
            {
              int m = Integer.parseInt(localObject[0]);
              int i1 = Integer.parseInt(localObject[1]);
              int n = Integer.parseInt(localObject[2]);
              int k = Integer.parseInt(localObject[3]);
              m = (int)(m / 1080.0F * f1);
              i1 = (int)(i1 / 1920.0F * f2);
              n = (int)(n / 1080.0F * f1);
              k = (int)(k / 1920.0F * f2);
              localObject = new Paint();
              ((Paint)localObject).setColor(-65536);
              paramCanvas.drawLine(m, i1, m + n, i1, (Paint)localObject);
              paramCanvas.drawLine(m + n, i1, m + n, i1 + k, (Paint)localObject);
              paramCanvas.drawLine(m + n, i1 + k, m, i1 + k, (Paint)localObject);
              paramCanvas.drawLine(m, i1 + k, m, i1, (Paint)localObject);
              ((Paint)localObject).setColor(-16711936);
              paramCanvas.drawLine(m, i1, m + n, i1 + k, (Paint)localObject);
              paramCanvas.drawLine(m, i1 + k, m + n, i1, (Paint)localObject);
            }
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(194403);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(194378);
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(194378);
    return paramLayoutParams;
  }
  
  public int getMaxHeight()
  {
    return this.bkR;
  }
  
  public int getMaxWidth()
  {
    return this.vF;
  }
  
  public int getMinHeight()
  {
    return this.biW;
  }
  
  public int getMinWidth()
  {
    return this.mf;
  }
  
  public int getOptimizationLevel()
  {
    return this.bkQ.bjR;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(194361);
    paramInt2 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      androidx.constraintlayout.a.a.f localf = localLayoutParams.bml;
      if (((localView.getVisibility() != 8) || (localLayoutParams.blY) || (localLayoutParams.blZ) || (paramBoolean)) && (!localLayoutParams.bma))
      {
        paramInt3 = localf.CL();
        paramInt4 = localf.CM();
        int i = localf.getWidth() + paramInt3;
        int j = localf.getHeight() + paramInt4;
        localView.layout(paramInt3, paramInt4, i, j);
        if ((localView instanceof Placeholder))
        {
          localView = ((Placeholder)localView).getContent();
          if (localView != null)
          {
            localView.setVisibility(0);
            localView.layout(paramInt3, paramInt4, i, j);
          }
        }
      }
      paramInt1 += 1;
    }
    paramInt2 = this.bkO.size();
    if (paramInt2 > 0)
    {
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        ((ConstraintHelper)this.bkO.get(paramInt1)).Di();
        paramInt1 += 1;
      }
    }
    AppMethodBeat.o(194361);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194352);
    System.currentTimeMillis();
    int i13 = View.MeasureSpec.getMode(paramInt1);
    int i14 = View.MeasureSpec.getSize(paramInt1);
    int i15 = View.MeasureSpec.getMode(paramInt2);
    int i16 = View.MeasureSpec.getSize(paramInt2);
    int i11 = getPaddingLeft();
    int i12 = getPaddingTop();
    this.bkQ.setX(i11);
    this.bkQ.setY(i12);
    Object localObject1 = this.bkQ;
    int i = this.vF;
    ((androidx.constraintlayout.a.a.f)localObject1).biu[0] = i;
    localObject1 = this.bkQ;
    i = this.bkR;
    ((androidx.constraintlayout.a.a.f)localObject1).biu[1] = i;
    boolean bool;
    int i1;
    int k;
    int m;
    int n;
    int i2;
    int i3;
    Object localObject2;
    label239:
    int i9;
    label279:
    int i10;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject1 = this.bkQ;
      if (getLayoutDirection() == 1)
      {
        bool = true;
        ((g)localObject1).uK = bool;
      }
    }
    else
    {
      i1 = View.MeasureSpec.getMode(paramInt1);
      i = View.MeasureSpec.getSize(paramInt1);
      k = View.MeasureSpec.getMode(paramInt2);
      j = View.MeasureSpec.getSize(paramInt2);
      m = getPaddingTop();
      n = getPaddingBottom();
      i2 = getPaddingLeft();
      i3 = getPaddingRight();
      localObject1 = f.a.bjw;
      localObject2 = f.a.bjw;
      getLayoutParams();
      switch (i1)
      {
      default: 
        i = 0;
        switch (k)
        {
        default: 
          j = 0;
          this.bkQ.setMinWidth(0);
          this.bkQ.setMinHeight(0);
          this.bkQ.a((f.a)localObject1);
          this.bkQ.setWidth(i);
          this.bkQ.b((f.a)localObject2);
          this.bkQ.setHeight(j);
          this.bkQ.setMinWidth(this.mf - getPaddingLeft() - getPaddingRight());
          this.bkQ.setMinHeight(this.biW - getPaddingTop() - getPaddingBottom());
          i9 = this.bkQ.getWidth();
          i10 = this.bkQ.getHeight();
          if (!this.bkS) {
            break label6090;
          }
          this.bkS = false;
          m = getChildCount();
          k = 0;
          i = 0;
        }
        break;
      }
    }
    int i17;
    Object localObject3;
    for (;;)
    {
      j = k;
      if (i < m)
      {
        if (getChildAt(i).isLayoutRequested()) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break label2741;
        }
        this.bkP.clear();
        bool = isInEditMode();
        i17 = getChildCount();
        if (!bool) {
          break label662;
        }
        i = 0;
        while (i < i17)
        {
          localObject3 = getChildAt(i);
          try
          {
            localObject2 = getResources().getResourceName(((View)localObject3).getId());
            k(localObject2, Integer.valueOf(((View)localObject3).getId()));
            j = ((String)localObject2).indexOf('/');
            localObject1 = localObject2;
            if (j != -1) {
              localObject1 = ((String)localObject2).substring(j + 1);
            }
            dT(((View)localObject3).getId()).bjf = ((String)localObject1);
          }
          catch (Resources.NotFoundException localNotFoundException1)
          {
            for (;;)
            {
              int i4;
              float f2;
              int i7;
              int i8;
              int i6;
              Object localObject4;
              continue;
              n = m;
              continue;
              n = j;
              j = m;
              continue;
              j = k;
              continue;
              n = j;
              continue;
              m = j;
              continue;
              n = m;
              m = j;
              j = n;
              continue;
              j = 0;
              continue;
              j = 0;
              k = i2;
              i = m;
              m = i1;
              continue;
              j = 0;
              k = m;
              continue;
              k = 0;
              continue;
              float f1 = f2;
              n = i1;
              i1 = i2;
              i2 = i3;
              i = k;
              j = m;
            }
          }
          i += 1;
        }
        bool = false;
        break;
        localObject1 = f.a.bjx;
        break label239;
        localObject1 = f.a.bjx;
        i = 0;
        break label239;
        i = Math.min(this.vF, i) - (i2 + i3);
        break label239;
        localObject2 = f.a.bjx;
        break label279;
        localObject2 = f.a.bjx;
        j = 0;
        break label279;
        j = Math.min(this.bkR, j) - (m + n);
        break label279;
      }
      i += 1;
    }
    label662:
    i = 0;
    while (i < i17)
    {
      localObject1 = D(getChildAt(i));
      if (localObject1 != null) {
        ((androidx.constraintlayout.a.a.f)localObject1).reset();
      }
      i += 1;
    }
    if (this.bkU != -1)
    {
      i = 0;
      while (i < i17)
      {
        localObject1 = getChildAt(i);
        if ((((View)localObject1).getId() == this.bkU) && ((localObject1 instanceof Constraints))) {
          this.bkT = ((Constraints)localObject1).getConstraintSet();
        }
        i += 1;
      }
    }
    if (this.bkT != null) {
      this.bkT.d(this);
    }
    this.bkQ.Dg();
    int j = this.bkO.size();
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        ((ConstraintHelper)this.bkO.get(i)).a(this);
        i += 1;
      }
    }
    i = 0;
    while (i < i17)
    {
      localObject1 = getChildAt(i);
      if ((localObject1 instanceof Placeholder)) {
        ((Placeholder)localObject1).a(this);
      }
      i += 1;
    }
    int i5 = 0;
    if (i5 < i17)
    {
      localObject3 = getChildAt(i5);
      localObject2 = D((View)localObject3);
      if (localObject2 != null)
      {
        localObject1 = (LayoutParams)((View)localObject3).getLayoutParams();
        ((LayoutParams)localObject1).Dl();
        if (!((LayoutParams)localObject1).bmm) {
          break label1098;
        }
        ((LayoutParams)localObject1).bmm = false;
        label945:
        ((androidx.constraintlayout.a.a.f)localObject2).bje = ((View)localObject3).getVisibility();
        if (((LayoutParams)localObject1).bma) {
          ((androidx.constraintlayout.a.a.f)localObject2).bje = 8;
        }
        ((androidx.constraintlayout.a.a.f)localObject2).bjc = localObject3;
        this.bkQ.e((androidx.constraintlayout.a.a.f)localObject2);
        if ((!((LayoutParams)localObject1).blW) || (!((LayoutParams)localObject1).blV)) {
          this.bkP.add(localObject2);
        }
        if (!((LayoutParams)localObject1).blY) {
          break label1202;
        }
        localObject2 = (i)localObject2;
        j = ((LayoutParams)localObject1).bmi;
        i = ((LayoutParams)localObject1).bmj;
        f1 = ((LayoutParams)localObject1).bmk;
        if (Build.VERSION.SDK_INT < 17)
        {
          j = ((LayoutParams)localObject1).bld;
          i = ((LayoutParams)localObject1).ble;
          f1 = ((LayoutParams)localObject1).blf;
        }
        if (f1 == -1.0F) {
          break label1170;
        }
        ((i)localObject2).am(f1);
      }
      label1098:
      while ((((LayoutParams)localObject1).blg == -1) && (((LayoutParams)localObject1).blh == -1) && (((LayoutParams)localObject1).bli == -1) && (((LayoutParams)localObject1).blj == -1) && (((LayoutParams)localObject1).blt == -1) && (((LayoutParams)localObject1).bls == -1) && (((LayoutParams)localObject1).blu == -1) && (((LayoutParams)localObject1).blv == -1) && (((LayoutParams)localObject1).blk == -1) && (((LayoutParams)localObject1).bll == -1) && (((LayoutParams)localObject1).blm == -1) && (((LayoutParams)localObject1).bln == -1) && (((LayoutParams)localObject1).blo == -1) && (((LayoutParams)localObject1).blR == -1) && (((LayoutParams)localObject1).blS == -1) && (((LayoutParams)localObject1).blp == -1) && (((LayoutParams)localObject1).width != -1) && (((LayoutParams)localObject1).height != -1)) {
        for (;;)
        {
          for (;;)
          {
            i5 += 1;
            break;
            if (!bool) {
              break label945;
            }
            try
            {
              String str = getResources().getResourceName(((View)localObject3).getId());
              k(str, Integer.valueOf(((View)localObject3).getId()));
              str = str.substring(str.indexOf("id/") + 3);
              dT(((View)localObject3).getId()).bjf = str;
            }
            catch (Resources.NotFoundException localNotFoundException2) {}
          }
          break label945;
          if (j != -1) {
            ((i)localObject2).dP(j);
          } else if (i != -1) {
            ((i)localObject2).dQ(i);
          }
        }
      }
      label1170:
      label1202:
      m = ((LayoutParams)localObject1).bmb;
      k = ((LayoutParams)localObject1).bmc;
      i3 = ((LayoutParams)localObject1).bmd;
      i2 = ((LayoutParams)localObject1).bme;
      i4 = ((LayoutParams)localObject1).bmf;
      i1 = ((LayoutParams)localObject1).bmg;
      f2 = ((LayoutParams)localObject1).bmh;
      if (Build.VERSION.SDK_INT >= 17) {
        break label6064;
      }
      k = ((LayoutParams)localObject1).blg;
      m = ((LayoutParams)localObject1).blh;
      i7 = ((LayoutParams)localObject1).bli;
      i8 = ((LayoutParams)localObject1).blj;
      i6 = ((LayoutParams)localObject1).blw;
      n = ((LayoutParams)localObject1).bly;
      f1 = ((LayoutParams)localObject1).atU;
      i = m;
      j = k;
      if (k == -1)
      {
        i = m;
        j = k;
        if (m == -1)
        {
          if (((LayoutParams)localObject1).blt == -1) {
            break label2036;
          }
          j = ((LayoutParams)localObject1).blt;
          i = m;
        }
      }
      label1517:
      f2 = f1;
      i1 = n;
      i2 = i8;
      i3 = i7;
      i4 = i6;
      k = i;
      m = j;
      if (i7 != -1) {
        break label6064;
      }
      f2 = f1;
      i1 = n;
      i2 = i8;
      i3 = i7;
      i4 = i6;
      k = i;
      m = j;
      if (i8 != -1) {
        break label6064;
      }
      if (((LayoutParams)localObject1).blu != -1)
      {
        i2 = ((LayoutParams)localObject1).blu;
        i1 = i8;
        i4 = i6;
        label1607:
        if (((LayoutParams)localObject1).blp == -1) {
          break label2121;
        }
        localObject3 = dT(((LayoutParams)localObject1).blp);
        if (localObject3 != null)
        {
          f1 = ((LayoutParams)localObject1).blr;
          i = ((LayoutParams)localObject1).blq;
          ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhY, (androidx.constraintlayout.a.a.f)localObject3, e.c.bhY, i, 0);
          ((androidx.constraintlayout.a.a.f)localObject2).biv = f1;
        }
        if ((bool) && ((((LayoutParams)localObject1).blR != -1) || (((LayoutParams)localObject1).blS != -1))) {
          ((androidx.constraintlayout.a.a.f)localObject2).ao(((LayoutParams)localObject1).blR, ((LayoutParams)localObject1).blS);
        }
        if (((LayoutParams)localObject1).blV) {
          break label2682;
        }
        if (((LayoutParams)localObject1).width != -1) {
          break label2665;
        }
        ((androidx.constraintlayout.a.a.f)localObject2).a(f.a.bjz);
        ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhT).bhE = ((LayoutParams)localObject1).leftMargin;
        ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhV).bhE = ((LayoutParams)localObject1).rightMargin;
        label1762:
        if (((LayoutParams)localObject1).blW) {
          break label2720;
        }
        if (((LayoutParams)localObject1).height != -1) {
          break label2703;
        }
        ((androidx.constraintlayout.a.a.f)localObject2).b(f.a.bjz);
        ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhU).bhE = ((LayoutParams)localObject1).topMargin;
        ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhW).bhE = ((LayoutParams)localObject1).bottomMargin;
      }
      for (;;)
      {
        if (((LayoutParams)localObject1).blC != null) {
          ((androidx.constraintlayout.a.a.f)localObject2).ap(((LayoutParams)localObject1).blC);
        }
        f1 = ((LayoutParams)localObject1).blF;
        ((androidx.constraintlayout.a.a.f)localObject2).bjq[0] = f1;
        f1 = ((LayoutParams)localObject1).blG;
        ((androidx.constraintlayout.a.a.f)localObject2).bjq[1] = f1;
        ((androidx.constraintlayout.a.a.f)localObject2).bjm = ((LayoutParams)localObject1).blH;
        ((androidx.constraintlayout.a.a.f)localObject2).bjn = ((LayoutParams)localObject1).blI;
        i = ((LayoutParams)localObject1).blJ;
        j = ((LayoutParams)localObject1).blL;
        k = ((LayoutParams)localObject1).blN;
        f1 = ((LayoutParams)localObject1).blP;
        ((androidx.constraintlayout.a.a.f)localObject2).big = i;
        ((androidx.constraintlayout.a.a.f)localObject2).bij = j;
        ((androidx.constraintlayout.a.a.f)localObject2).bik = k;
        ((androidx.constraintlayout.a.a.f)localObject2).bil = f1;
        if ((f1 < 1.0F) && (((androidx.constraintlayout.a.a.f)localObject2).big == 0)) {
          ((androidx.constraintlayout.a.a.f)localObject2).big = 2;
        }
        i = ((LayoutParams)localObject1).blK;
        j = ((LayoutParams)localObject1).blM;
        k = ((LayoutParams)localObject1).blO;
        f1 = ((LayoutParams)localObject1).blQ;
        ((androidx.constraintlayout.a.a.f)localObject2).bih = i;
        ((androidx.constraintlayout.a.a.f)localObject2).bim = j;
        ((androidx.constraintlayout.a.a.f)localObject2).bin = k;
        ((androidx.constraintlayout.a.a.f)localObject2).bio = f1;
        if ((f1 >= 1.0F) || (((androidx.constraintlayout.a.a.f)localObject2).bih != 0)) {
          break;
        }
        ((androidx.constraintlayout.a.a.f)localObject2).bih = 2;
        break;
        label2036:
        i = m;
        j = k;
        if (((LayoutParams)localObject1).bls == -1) {
          break label1517;
        }
        i = ((LayoutParams)localObject1).bls;
        j = k;
        break label1517;
        f2 = f1;
        i1 = n;
        i2 = i8;
        i3 = i7;
        i4 = i6;
        k = i;
        m = j;
        if (((LayoutParams)localObject1).blv == -1) {
          break label6064;
        }
        i1 = ((LayoutParams)localObject1).blv;
        i2 = i7;
        i4 = i6;
        break label1607;
        label2121:
        if (j != -1)
        {
          localObject3 = dT(j);
          if (localObject3 != null) {
            ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhT, (androidx.constraintlayout.a.a.f)localObject3, e.c.bhT, ((LayoutParams)localObject1).leftMargin, i4);
          }
          label2160:
          if (i2 == -1) {
            break label2521;
          }
          localObject3 = dT(i2);
          if (localObject3 != null) {
            ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhV, (androidx.constraintlayout.a.a.f)localObject3, e.c.bhT, ((LayoutParams)localObject1).rightMargin, n);
          }
          if (((LayoutParams)localObject1).blk == -1) {
            break label2563;
          }
          localObject3 = dT(((LayoutParams)localObject1).blk);
          if (localObject3 != null) {
            ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhU, (androidx.constraintlayout.a.a.f)localObject3, e.c.bhU, ((LayoutParams)localObject1).topMargin, ((LayoutParams)localObject1).blx);
          }
          if (((LayoutParams)localObject1).blm == -1) {
            break label2614;
          }
          localObject3 = dT(((LayoutParams)localObject1).blm);
          if (localObject3 != null) {
            ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhW, (androidx.constraintlayout.a.a.f)localObject3, e.c.bhU, ((LayoutParams)localObject1).bottomMargin, ((LayoutParams)localObject1).blz);
          }
        }
        for (;;)
        {
          label2199:
          label2247:
          if (((LayoutParams)localObject1).blo != -1)
          {
            localObject4 = (View)this.bkN.get(((LayoutParams)localObject1).blo);
            localObject3 = dT(((LayoutParams)localObject1).blo);
            if ((localObject3 != null) && (localObject4 != null) && ((((View)localObject4).getLayoutParams() instanceof LayoutParams)))
            {
              localObject4 = (LayoutParams)((View)localObject4).getLayoutParams();
              ((LayoutParams)localObject1).blX = true;
              ((LayoutParams)localObject4).blX = true;
              ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhX).a(((androidx.constraintlayout.a.a.f)localObject3).a(e.c.bhX), 0, -1, e.b.bhP, 0, true);
              ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhU).reset();
              ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhW).reset();
            }
          }
          if ((f1 >= 0.0F) && (f1 != 0.5F)) {
            ((androidx.constraintlayout.a.a.f)localObject2).bja = f1;
          }
          if ((((LayoutParams)localObject1).atV < 0.0F) || (((LayoutParams)localObject1).atV == 0.5F)) {
            break;
          }
          ((androidx.constraintlayout.a.a.f)localObject2).bjb = ((LayoutParams)localObject1).atV;
          break;
          if (i == -1) {
            break label2160;
          }
          localObject3 = dT(i);
          if (localObject3 == null) {
            break label2160;
          }
          ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhT, (androidx.constraintlayout.a.a.f)localObject3, e.c.bhV, ((LayoutParams)localObject1).leftMargin, i4);
          break label2160;
          label2521:
          if (i1 == -1) {
            break label2199;
          }
          localObject3 = dT(i1);
          if (localObject3 == null) {
            break label2199;
          }
          ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhV, (androidx.constraintlayout.a.a.f)localObject3, e.c.bhV, ((LayoutParams)localObject1).rightMargin, n);
          break label2199;
          label2563:
          if (((LayoutParams)localObject1).bll == -1) {
            break label2247;
          }
          localObject3 = dT(((LayoutParams)localObject1).bll);
          if (localObject3 == null) {
            break label2247;
          }
          ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhU, (androidx.constraintlayout.a.a.f)localObject3, e.c.bhW, ((LayoutParams)localObject1).topMargin, ((LayoutParams)localObject1).blx);
          break label2247;
          label2614:
          if (((LayoutParams)localObject1).bln != -1)
          {
            localObject3 = dT(((LayoutParams)localObject1).bln);
            if (localObject3 != null) {
              ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.bhW, (androidx.constraintlayout.a.a.f)localObject3, e.c.bhW, ((LayoutParams)localObject1).bottomMargin, ((LayoutParams)localObject1).blz);
            }
          }
        }
        label2665:
        ((androidx.constraintlayout.a.a.f)localObject2).a(f.a.bjy);
        ((androidx.constraintlayout.a.a.f)localObject2).setWidth(0);
        break label1762;
        label2682:
        ((androidx.constraintlayout.a.a.f)localObject2).a(f.a.bjw);
        ((androidx.constraintlayout.a.a.f)localObject2).setWidth(((LayoutParams)localObject1).width);
        break label1762;
        label2703:
        ((androidx.constraintlayout.a.a.f)localObject2).b(f.a.bjy);
        ((androidx.constraintlayout.a.a.f)localObject2).setHeight(0);
        continue;
        label2720:
        ((androidx.constraintlayout.a.a.f)localObject2).b(f.a.bjw);
        ((androidx.constraintlayout.a.a.f)localObject2).setHeight(((LayoutParams)localObject1).height);
      }
    }
    label2741:
    label2936:
    label6009:
    for (i5 = 1;; i5 = 0)
    {
      if ((this.bjR & 0x8) == 8) {
        i4 = 1;
      }
      while (i4 != 0)
      {
        this.bkQ.CZ();
        this.bkQ.at(i9, i10);
        i17 = getPaddingTop() + getPaddingBottom();
        int i18 = getPaddingLeft() + getPaddingRight();
        int i19 = getChildCount();
        i = 0;
        for (;;)
        {
          if (i < i19)
          {
            localObject1 = getChildAt(i);
            if (((View)localObject1).getVisibility() != 8)
            {
              localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
              localObject3 = ((LayoutParams)localObject2).bml;
              if ((!((LayoutParams)localObject2).blY) && (!((LayoutParams)localObject2).blZ))
              {
                ((androidx.constraintlayout.a.a.f)localObject3).bje = ((View)localObject1).getVisibility();
                m = ((LayoutParams)localObject2).width;
                n = ((LayoutParams)localObject2).height;
                if ((m != 0) && (n != 0)) {
                  break label2936;
                }
                ((androidx.constraintlayout.a.a.f)localObject3).CJ().invalidate();
                ((androidx.constraintlayout.a.a.f)localObject3).CK().invalidate();
              }
            }
            i += 1;
            continue;
            i4 = 0;
            break;
            j = 0;
            k = 0;
            if (m == -2) {
              j = 1;
            }
            i1 = getChildMeasureSpec(paramInt1, i18, m);
            if (n == -2) {
              k = 1;
            }
            ((View)localObject1).measure(i1, getChildMeasureSpec(paramInt2, i17, n));
            if (this.blc != null)
            {
              AppMethodBeat.o(194352);
              throw null;
            }
            if (m == -2)
            {
              bool = true;
              ((androidx.constraintlayout.a.a.f)localObject3).bip = bool;
              if (n != -2) {
                break label3161;
              }
            }
            for (bool = true;; bool = false)
            {
              ((androidx.constraintlayout.a.a.f)localObject3).biq = bool;
              m = ((View)localObject1).getMeasuredWidth();
              n = ((View)localObject1).getMeasuredHeight();
              ((androidx.constraintlayout.a.a.f)localObject3).setWidth(m);
              ((androidx.constraintlayout.a.a.f)localObject3).setHeight(n);
              if (j != 0) {
                ((androidx.constraintlayout.a.a.f)localObject3).biX = m;
              }
              if (k != 0) {
                ((androidx.constraintlayout.a.a.f)localObject3).biY = n;
              }
              if (((LayoutParams)localObject2).blX)
              {
                j = ((View)localObject1).getBaseline();
                if (j != -1) {
                  ((androidx.constraintlayout.a.a.f)localObject3).biV = j;
                }
              }
              if ((!((LayoutParams)localObject2).blV) || (!((LayoutParams)localObject2).blW)) {
                break;
              }
              ((androidx.constraintlayout.a.a.f)localObject3).CJ().dS(m);
              ((androidx.constraintlayout.a.a.f)localObject3).CK().dS(n);
              break;
              bool = false;
              break label3012;
            }
          }
        }
        this.bkQ.Da();
        i6 = 0;
        if (i6 >= i19) {
          break label4488;
        }
        localObject1 = getChildAt(i6);
        if (((View)localObject1).getVisibility() != 8)
        {
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          localObject3 = ((LayoutParams)localObject2).bml;
          if ((!((LayoutParams)localObject2).blY) && (!((LayoutParams)localObject2).blZ))
          {
            ((androidx.constraintlayout.a.a.f)localObject3).bje = ((View)localObject1).getVisibility();
            n = ((LayoutParams)localObject2).width;
            m = ((LayoutParams)localObject2).height;
            if ((n == 0) || (m == 0))
            {
              localObject4 = ((androidx.constraintlayout.a.a.f)localObject3).a(e.c.bhT).bhA;
              m localm1 = ((androidx.constraintlayout.a.a.f)localObject3).a(e.c.bhV).bhA;
              if ((((androidx.constraintlayout.a.a.f)localObject3).a(e.c.bhT).bhD != null) && (((androidx.constraintlayout.a.a.f)localObject3).a(e.c.bhV).bhD != null))
              {
                k = 1;
                m localm2 = ((androidx.constraintlayout.a.a.f)localObject3).a(e.c.bhU).bhA;
                m localm3 = ((androidx.constraintlayout.a.a.f)localObject3).a(e.c.bhW).bhA;
                if ((((androidx.constraintlayout.a.a.f)localObject3).a(e.c.bhU).bhD == null) || (((androidx.constraintlayout.a.a.f)localObject3).a(e.c.bhW).bhD == null)) {
                  break label3666;
                }
                i7 = 1;
                if ((n == 0) && (m == 0) && (k != 0) && (i7 != 0)) {
                  break label3955;
                }
                i8 = 0;
                if (this.bkQ.CV() == f.a.bjx) {
                  break label3672;
                }
                j = 1;
                if (this.bkQ.CW() == f.a.bjx) {
                  break label3678;
                }
                i = 1;
                if (j == 0) {
                  ((androidx.constraintlayout.a.a.f)localObject3).CJ().invalidate();
                }
                if (i == 0) {
                  ((androidx.constraintlayout.a.a.f)localObject3).CK().invalidate();
                }
                if (n != 0) {
                  break label3711;
                }
                if ((j == 0) || (!((androidx.constraintlayout.a.a.f)localObject3).CF()) || (k == 0) || (!((m)localObject4).Df()) || (!localm1.Df())) {
                  break label3684;
                }
                n = (int)(localm1.bkt - ((m)localObject4).bkt);
                ((androidx.constraintlayout.a.a.f)localObject3).CJ().dS(n);
                k = 0;
                i2 = getChildMeasureSpec(paramInt1, i18, n);
                i3 = n;
                i1 = k;
                n = j;
                if (m != 0) {
                  break label3772;
                }
                if ((i == 0) || (!((androidx.constraintlayout.a.a.f)localObject3).CG()) || (i7 == 0) || (!localm2.Df()) || (!localm3.Df())) {
                  break label3753;
                }
                k = (int)(localm3.bkt - localm2.bkt);
                ((androidx.constraintlayout.a.a.f)localObject3).CK().dS(k);
                j = 0;
              }
              for (;;)
              {
                i7 = getChildMeasureSpec(paramInt2, i17, k);
                m = k;
                k = i7;
                for (;;)
                {
                  ((View)localObject1).measure(i2, k);
                  if (this.blc == null) {
                    break label3811;
                  }
                  AppMethodBeat.o(194352);
                  throw null;
                  k = 0;
                  break;
                  i7 = 0;
                  break label3383;
                  j = 0;
                  break label3422;
                  i = 0;
                  break label3438;
                  i2 = getChildMeasureSpec(paramInt1, i18, -2);
                  j = 0;
                  i1 = 1;
                  i3 = n;
                  n = j;
                  break label3552;
                  label3711:
                  if (n == -1)
                  {
                    i2 = getChildMeasureSpec(paramInt1, i18, -1);
                    i1 = 0;
                    i3 = n;
                    n = j;
                    break label3552;
                  }
                  if (n != -2) {
                    break label6058;
                  }
                  k = 1;
                  break label3530;
                  k = getChildMeasureSpec(paramInt2, i17, -2);
                  j = 1;
                  i = 0;
                  continue;
                  if (m != -1) {
                    break label3794;
                  }
                  k = getChildMeasureSpec(paramInt2, i17, -1);
                  j = i8;
                }
                if (m != -2) {
                  break label6048;
                }
                j = 1;
                k = m;
              }
              if (i3 != -2) {
                break label3964;
              }
              bool = true;
              ((androidx.constraintlayout.a.a.f)localObject3).bip = bool;
              if (m != -2) {
                break label3970;
              }
              bool = true;
              label3838:
              ((androidx.constraintlayout.a.a.f)localObject3).biq = bool;
              k = ((View)localObject1).getMeasuredWidth();
              m = ((View)localObject1).getMeasuredHeight();
              ((androidx.constraintlayout.a.a.f)localObject3).setWidth(k);
              ((androidx.constraintlayout.a.a.f)localObject3).setHeight(m);
              if (i1 != 0) {
                ((androidx.constraintlayout.a.a.f)localObject3).biX = k;
              }
              if (j != 0) {
                ((androidx.constraintlayout.a.a.f)localObject3).biY = m;
              }
              if (n == 0) {
                break label3976;
              }
              ((androidx.constraintlayout.a.a.f)localObject3).CJ().dS(k);
              if (i == 0) {
                break label3988;
              }
              ((androidx.constraintlayout.a.a.f)localObject3).CK().dS(m);
            }
          }
        }
        for (;;)
        {
          if (((LayoutParams)localObject2).blX)
          {
            i = ((View)localObject1).getBaseline();
            if (i != -1) {
              ((androidx.constraintlayout.a.a.f)localObject3).biV = i;
            }
          }
          i6 += 1;
          break;
          label3964:
          bool = false;
          break label3821;
          bool = false;
          break label3838;
          ((androidx.constraintlayout.a.a.f)localObject3).CJ().state = 2;
          break label3912;
          ((androidx.constraintlayout.a.a.f)localObject3).CK().state = 2;
        }
      }
      i3 = getPaddingTop() + getPaddingBottom();
      i6 = getPaddingLeft() + getPaddingRight();
      i7 = getChildCount();
      n = 0;
      if (n < i7)
      {
        localObject1 = getChildAt(n);
        if (((View)localObject1).getVisibility() != 8)
        {
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          localObject3 = ((LayoutParams)localObject2).bml;
          if ((!((LayoutParams)localObject2).blY) && (!((LayoutParams)localObject2).blZ))
          {
            ((androidx.constraintlayout.a.a.f)localObject3).bje = ((View)localObject1).getVisibility();
            i1 = ((LayoutParams)localObject2).width;
            i2 = ((LayoutParams)localObject2).height;
            if ((((LayoutParams)localObject2).blV) || (((LayoutParams)localObject2).blW) || ((!((LayoutParams)localObject2).blV) && (((LayoutParams)localObject2).blJ == 1)) || (((LayoutParams)localObject2).width == -1) || ((!((LayoutParams)localObject2).blW) && ((((LayoutParams)localObject2).blK == 1) || (((LayoutParams)localObject2).height == -1))))
            {
              i = 1;
              m = 0;
              j = 0;
              if (i == 0) {
                continue;
              }
              if (i1 != 0) {
                break label4261;
              }
              k = getChildMeasureSpec(paramInt1, i6, -2);
              i = 1;
              if (i2 != 0) {
                break label4309;
              }
              m = getChildMeasureSpec(paramInt2, i3, -2);
              j = 1;
            }
            for (;;)
            {
              ((View)localObject1).measure(k, m);
              if (this.blc == null) {
                break label4353;
              }
              AppMethodBeat.o(194352);
              throw null;
              i = 0;
              break;
              if (i1 == -1)
              {
                k = getChildMeasureSpec(paramInt1, i6, -1);
                i = 0;
                break label4213;
              }
              i = j;
              if (i1 == -2) {
                i = 1;
              }
              k = getChildMeasureSpec(paramInt1, i6, i1);
              break label4213;
              if (i2 == -1)
              {
                m = getChildMeasureSpec(paramInt2, i3, -1);
                j = 0;
              }
              else
              {
                if (i2 != -2) {
                  break label6024;
                }
                j = 1;
                m = getChildMeasureSpec(paramInt2, i3, i2);
              }
            }
            if (i1 != -2) {
              break label4476;
            }
            bool = true;
            ((androidx.constraintlayout.a.a.f)localObject3).bip = bool;
            if (i2 != -2) {
              break label4482;
            }
          }
        }
        for (bool = true;; bool = false)
        {
          ((androidx.constraintlayout.a.a.f)localObject3).biq = bool;
          m = ((View)localObject1).getMeasuredWidth();
          k = ((View)localObject1).getMeasuredHeight();
          ((androidx.constraintlayout.a.a.f)localObject3).setWidth(m);
          ((androidx.constraintlayout.a.a.f)localObject3).setHeight(k);
          if (i != 0) {
            ((androidx.constraintlayout.a.a.f)localObject3).biX = m;
          }
          if (j != 0) {
            ((androidx.constraintlayout.a.a.f)localObject3).biY = k;
          }
          if (((LayoutParams)localObject2).blX)
          {
            i = ((View)localObject1).getBaseline();
            if (i != -1) {
              ((androidx.constraintlayout.a.a.f)localObject3).biV = i;
            }
          }
          n += 1;
          break;
          label4476:
          bool = false;
          break label4363;
        }
      }
      else
      {
        j = getChildCount();
        i = 0;
        while (i < j)
        {
          localObject1 = getChildAt(i);
          if ((localObject1 instanceof Placeholder))
          {
            localObject2 = (Placeholder)localObject1;
            if (((Placeholder)localObject2).bmR != null)
            {
              localObject1 = (LayoutParams)((Placeholder)localObject2).getLayoutParams();
              localObject2 = (LayoutParams)((Placeholder)localObject2).bmR.getLayoutParams();
              ((LayoutParams)localObject2).bml.bje = 0;
              ((LayoutParams)localObject1).bml.setWidth(((LayoutParams)localObject2).bml.getWidth());
              ((LayoutParams)localObject1).bml.setHeight(((LayoutParams)localObject2).bml.getHeight());
              ((LayoutParams)localObject2).bml.bje = 8;
            }
          }
          i += 1;
        }
        j = this.bkO.size();
        if (j > 0)
        {
          i = 0;
          while (i < j)
          {
            this.bkO.get(i);
            i += 1;
          }
        }
        if ((getChildCount() > 0) && (i5 != 0)) {
          androidx.constraintlayout.a.a.a.a(this.bkQ);
        }
        if (this.bkQ.bjM)
        {
          if ((this.bkQ.bjN) && (i13 == -2147483648))
          {
            if (this.bkQ.bjP < i14) {
              this.bkQ.setWidth(this.bkQ.bjP);
            }
            this.bkQ.a(f.a.bjw);
          }
          if ((this.bkQ.bjO) && (i15 == -2147483648))
          {
            if (this.bkQ.bjQ < i16) {
              this.bkQ.setHeight(this.bkQ.bjQ);
            }
            this.bkQ.b(f.a.bjw);
          }
        }
        if ((this.bjR & 0x20) == 32)
        {
          i = this.bkQ.getWidth();
          j = this.bkQ.getHeight();
          if ((this.bkW != i) && (i13 == 1073741824)) {
            androidx.constraintlayout.a.a.a.g(this.bkQ.bjL, 0, i);
          }
          if ((this.bkX != j) && (i15 == 1073741824)) {
            androidx.constraintlayout.a.a.a.g(this.bkQ.bjL, 1, j);
          }
          if ((this.bkQ.bjN) && (this.bkQ.bjP > i14)) {
            androidx.constraintlayout.a.a.a.g(this.bkQ.bjL, 0, i14);
          }
          if ((this.bkQ.bjO) && (this.bkQ.bjQ > i16)) {
            androidx.constraintlayout.a.a.a.g(this.bkQ.bjL, 1, i16);
          }
        }
        if (getChildCount() > 0) {
          Dj();
        }
        j = 0;
        i = 0;
        i6 = this.bkP.size();
        i7 = i12 + getPaddingBottom();
        i8 = i11 + getPaddingRight();
        if (i6 > 0)
        {
          m = 0;
          if (this.bkQ.CV() == f.a.bjx)
          {
            i1 = 1;
            if (this.bkQ.CW() != f.a.bjx) {
              break label5268;
            }
            i2 = 1;
            j = Math.max(this.bkQ.getWidth(), this.mf);
            k = Math.max(this.bkQ.getHeight(), this.biW);
            i3 = 0;
          }
          for (;;)
          {
            if (i3 >= i6) {
              break label5566;
            }
            localObject1 = (androidx.constraintlayout.a.a.f)this.bkP.get(i3);
            localObject2 = (View)((androidx.constraintlayout.a.a.f)localObject1).bjc;
            if (localObject2 == null) {
              break label5970;
            }
            localObject3 = (LayoutParams)((View)localObject2).getLayoutParams();
            if ((((LayoutParams)localObject3).blZ) || (((LayoutParams)localObject3).blY) || (((View)localObject2).getVisibility() == 8) || ((i4 != 0) && (((androidx.constraintlayout.a.a.f)localObject1).CJ().Df()) && (((androidx.constraintlayout.a.a.f)localObject1).CK().Df()))) {
              break label5970;
            }
            if ((((LayoutParams)localObject3).width == -2) && (((LayoutParams)localObject3).blV))
            {
              n = getChildMeasureSpec(paramInt1, i8, ((LayoutParams)localObject3).width);
              if ((((LayoutParams)localObject3).height != -2) || (!((LayoutParams)localObject3).blW)) {
                break label5290;
              }
            }
            for (i5 = getChildMeasureSpec(paramInt2, i7, ((LayoutParams)localObject3).height);; i5 = View.MeasureSpec.makeMeasureSpec(((androidx.constraintlayout.a.a.f)localObject1).getHeight(), 1073741824))
            {
              ((View)localObject2).measure(n, i5);
              if (this.blc == null) {
                break label5306;
              }
              AppMethodBeat.o(194352);
              throw null;
              i1 = 0;
              break;
              i2 = 0;
              break label5042;
              n = View.MeasureSpec.makeMeasureSpec(((androidx.constraintlayout.a.a.f)localObject1).getWidth(), 1073741824);
              break label5207;
            }
            n = ((View)localObject2).getMeasuredWidth();
            i5 = ((View)localObject2).getMeasuredHeight();
            if (n == ((androidx.constraintlayout.a.a.f)localObject1).getWidth()) {
              break label6009;
            }
            ((androidx.constraintlayout.a.a.f)localObject1).setWidth(n);
            if (i4 != 0) {
              ((androidx.constraintlayout.a.a.f)localObject1).CJ().dS(n);
            }
            if ((i1 == 0) || (((androidx.constraintlayout.a.a.f)localObject1).CP() <= j)) {
              break label6002;
            }
            m = Math.max(j, ((androidx.constraintlayout.a.a.f)localObject1).CP() + ((androidx.constraintlayout.a.a.f)localObject1).a(e.c.bhV).CE());
            j = 1;
            if (i5 == ((androidx.constraintlayout.a.a.f)localObject1).getHeight()) {
              break label5995;
            }
            ((androidx.constraintlayout.a.a.f)localObject1).setHeight(i5);
            if (i4 != 0) {
              ((androidx.constraintlayout.a.a.f)localObject1).CK().dS(i5);
            }
            if ((i2 == 0) || (((androidx.constraintlayout.a.a.f)localObject1).CQ() <= k)) {
              break label5988;
            }
            j = Math.max(k, ((androidx.constraintlayout.a.a.f)localObject1).CQ() + ((androidx.constraintlayout.a.a.f)localObject1).a(e.c.bhW).CE());
            n = 1;
            k = j;
            j = n;
            if (((LayoutParams)localObject3).blX)
            {
              i5 = ((View)localObject2).getBaseline();
              j = n;
              if (i5 != -1)
              {
                j = n;
                if (i5 != ((androidx.constraintlayout.a.a.f)localObject1).biV)
                {
                  ((androidx.constraintlayout.a.a.f)localObject1).biV = i5;
                  j = 1;
                }
              }
            }
            if (Build.VERSION.SDK_INT < 11) {
              break label5977;
            }
            i = combineMeasuredStates(i, ((View)localObject2).getMeasuredState());
            n = j;
            j = m;
            i3 += 1;
            m = n;
          }
          if (m != 0)
          {
            this.bkQ.setWidth(i9);
            this.bkQ.setHeight(i10);
            if (i4 != 0) {
              this.bkQ.Da();
            }
            Dj();
            m = 0;
            if (this.bkQ.getWidth() < j)
            {
              this.bkQ.setWidth(j);
              m = 1;
            }
            if (this.bkQ.getHeight() < k)
            {
              this.bkQ.setHeight(k);
              m = 1;
            }
            if (m != 0) {
              Dj();
            }
          }
          k = 0;
          for (;;)
          {
            j = i;
            if (k >= i6) {
              break;
            }
            localObject1 = (androidx.constraintlayout.a.a.f)this.bkP.get(k);
            localObject2 = (View)((androidx.constraintlayout.a.a.f)localObject1).bjc;
            if ((localObject2 != null) && ((((View)localObject2).getMeasuredWidth() != ((androidx.constraintlayout.a.a.f)localObject1).getWidth()) || (((View)localObject2).getMeasuredHeight() != ((androidx.constraintlayout.a.a.f)localObject1).getHeight())) && (((androidx.constraintlayout.a.a.f)localObject1).bje != 8))
            {
              ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(((androidx.constraintlayout.a.a.f)localObject1).getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(((androidx.constraintlayout.a.a.f)localObject1).getHeight(), 1073741824));
              if (this.blc != null)
              {
                AppMethodBeat.o(194352);
                throw null;
              }
            }
            k += 1;
          }
        }
        i = this.bkQ.getWidth() + i8;
        k = this.bkQ.getHeight() + i7;
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramInt1 = resolveSizeAndState(i, paramInt1, j);
          i = resolveSizeAndState(k, paramInt2, j << 16);
          paramInt2 = Math.min(this.vF, paramInt1 & 0xFFFFFF);
          i = Math.min(this.bkR, i & 0xFFFFFF);
          paramInt1 = paramInt2;
          if (this.bkQ.bjT) {
            paramInt1 = paramInt2 | 0x1000000;
          }
          paramInt2 = i;
          if (this.bkQ.bjU) {
            paramInt2 = i | 0x1000000;
          }
          setMeasuredDimension(paramInt1, paramInt2);
          this.bkW = paramInt1;
          this.bkX = paramInt2;
          AppMethodBeat.o(194352);
          return;
        }
        setMeasuredDimension(i, k);
        this.bkW = i;
        this.bkX = k;
        AppMethodBeat.o(194352);
        return;
      }
    }
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(194239);
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewAdded(paramView);
    }
    Object localObject = D(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof i)))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      ((LayoutParams)localObject).bml = new i();
      ((LayoutParams)localObject).blY = true;
      ((i)((LayoutParams)localObject).bml).setOrientation(((LayoutParams)localObject).orientation);
    }
    if ((paramView instanceof ConstraintHelper))
    {
      localObject = (ConstraintHelper)paramView;
      ((ConstraintHelper)localObject).Dh();
      ((LayoutParams)paramView.getLayoutParams()).blZ = true;
      if (!this.bkO.contains(localObject)) {
        this.bkO.add(localObject);
      }
    }
    this.bkN.put(paramView.getId(), paramView);
    this.bkS = true;
    AppMethodBeat.o(194239);
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(194246);
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewRemoved(paramView);
    }
    this.bkN.remove(paramView.getId());
    androidx.constraintlayout.a.a.f localf = D(paramView);
    this.bkQ.f(localf);
    this.bkO.remove(paramView);
    this.bkP.remove(localf);
    this.bkS = true;
    AppMethodBeat.o(194246);
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(194231);
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14) {
      onViewRemoved(paramView);
    }
    AppMethodBeat.o(194231);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(194409);
    super.requestLayout();
    this.bkS = true;
    this.bkW = -1;
    this.bkX = -1;
    this.bkY = -1;
    this.bkZ = -1;
    this.bla = 0;
    this.blb = 0;
    AppMethodBeat.o(194409);
  }
  
  public void setConstraintSet(a parama)
  {
    this.bkT = parama;
  }
  
  public void setId(int paramInt)
  {
    AppMethodBeat.i(194215);
    this.bkN.remove(getId());
    super.setId(paramInt);
    this.bkN.put(getId(), this);
    AppMethodBeat.o(194215);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(194281);
    if (paramInt == this.bkR)
    {
      AppMethodBeat.o(194281);
      return;
    }
    this.bkR = paramInt;
    requestLayout();
    AppMethodBeat.o(194281);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(194276);
    if (paramInt == this.vF)
    {
      AppMethodBeat.o(194276);
      return;
    }
    this.vF = paramInt;
    requestLayout();
    AppMethodBeat.o(194276);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(194257);
    if (paramInt == this.biW)
    {
      AppMethodBeat.o(194257);
      return;
    }
    this.biW = paramInt;
    requestLayout();
    AppMethodBeat.o(194257);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(194253);
    if (paramInt == this.mf)
    {
      AppMethodBeat.o(194253);
      return;
    }
    this.mf = paramInt;
    requestLayout();
    AppMethodBeat.o(194253);
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.bkQ.bjR = paramInt;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public float atU;
    public float atV;
    public int blA;
    public int blB;
    public String blC;
    float blD;
    int blE;
    public float blF;
    public float blG;
    public int blH;
    public int blI;
    public int blJ;
    public int blK;
    public int blL;
    public int blM;
    public int blN;
    public int blO;
    public float blP;
    public float blQ;
    public int blR;
    public int blS;
    public boolean blT;
    public boolean blU;
    boolean blV;
    boolean blW;
    boolean blX;
    boolean blY;
    boolean blZ;
    public int bld;
    public int ble;
    public float blf;
    public int blg;
    public int blh;
    public int bli;
    public int blj;
    public int blk;
    public int bll;
    public int blm;
    public int bln;
    public int blo;
    public int blp;
    public int blq;
    public float blr;
    public int bls;
    public int blt;
    public int blu;
    public int blv;
    public int blw;
    public int blx;
    public int bly;
    public int blz;
    boolean bma;
    int bmb;
    int bmc;
    int bmd;
    int bme;
    int bmf;
    int bmg;
    float bmh;
    int bmi;
    int bmj;
    float bmk;
    androidx.constraintlayout.a.a.f bml;
    public boolean bmm;
    public int orientation;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      AppMethodBeat.i(194217);
      this.bld = -1;
      this.ble = -1;
      this.blf = -1.0F;
      this.blg = -1;
      this.blh = -1;
      this.bli = -1;
      this.blj = -1;
      this.blk = -1;
      this.bll = -1;
      this.blm = -1;
      this.bln = -1;
      this.blo = -1;
      this.blp = -1;
      this.blq = 0;
      this.blr = 0.0F;
      this.bls = -1;
      this.blt = -1;
      this.blu = -1;
      this.blv = -1;
      this.blw = -1;
      this.blx = -1;
      this.bly = -1;
      this.blz = -1;
      this.blA = -1;
      this.blB = -1;
      this.atU = 0.5F;
      this.atV = 0.5F;
      this.blC = null;
      this.blD = 0.0F;
      this.blE = 1;
      this.blF = -1.0F;
      this.blG = -1.0F;
      this.blH = 0;
      this.blI = 0;
      this.blJ = 0;
      this.blK = 0;
      this.blL = 0;
      this.blM = 0;
      this.blN = 0;
      this.blO = 0;
      this.blP = 1.0F;
      this.blQ = 1.0F;
      this.blR = -1;
      this.blS = -1;
      this.orientation = -1;
      this.blT = false;
      this.blU = false;
      this.blV = true;
      this.blW = true;
      this.blX = false;
      this.blY = false;
      this.blZ = false;
      this.bma = false;
      this.bmb = -1;
      this.bmc = -1;
      this.bmd = -1;
      this.bme = -1;
      this.bmf = -1;
      this.bmg = -1;
      this.bmh = 0.5F;
      this.bml = new androidx.constraintlayout.a.a.f();
      this.bmm = false;
      AppMethodBeat.o(194217);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(194211);
      this.bld = -1;
      this.ble = -1;
      this.blf = -1.0F;
      this.blg = -1;
      this.blh = -1;
      this.bli = -1;
      this.blj = -1;
      this.blk = -1;
      this.bll = -1;
      this.blm = -1;
      this.bln = -1;
      this.blo = -1;
      this.blp = -1;
      this.blq = 0;
      this.blr = 0.0F;
      this.bls = -1;
      this.blt = -1;
      this.blu = -1;
      this.blv = -1;
      this.blw = -1;
      this.blx = -1;
      this.bly = -1;
      this.blz = -1;
      this.blA = -1;
      this.blB = -1;
      this.atU = 0.5F;
      this.atV = 0.5F;
      this.blC = null;
      this.blD = 0.0F;
      this.blE = 1;
      this.blF = -1.0F;
      this.blG = -1.0F;
      this.blH = 0;
      this.blI = 0;
      this.blJ = 0;
      this.blK = 0;
      this.blL = 0;
      this.blM = 0;
      this.blN = 0;
      this.blO = 0;
      this.blP = 1.0F;
      this.blQ = 1.0F;
      this.blR = -1;
      this.blS = -1;
      this.orientation = -1;
      this.blT = false;
      this.blU = false;
      this.blV = true;
      this.blW = true;
      this.blX = false;
      this.blY = false;
      this.blZ = false;
      this.bma = false;
      this.bmb = -1;
      this.bmc = -1;
      this.bmd = -1;
      this.bme = -1;
      this.bmf = -1;
      this.bmg = -1;
      this.bmh = 0.5F;
      this.bml = new androidx.constraintlayout.a.a.f();
      this.bmm = false;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int k = paramContext.getIndexCount();
      int i = 0;
      if (i < k)
      {
        int j = paramContext.getIndex(i);
        switch (a.bmn.get(j))
        {
        }
        for (;;)
        {
          i += 1;
          break;
          this.blg = paramContext.getResourceId(j, this.blg);
          if (this.blg == -1)
          {
            this.blg = paramContext.getInt(j, -1);
            continue;
            this.blh = paramContext.getResourceId(j, this.blh);
            if (this.blh == -1)
            {
              this.blh = paramContext.getInt(j, -1);
              continue;
              this.bli = paramContext.getResourceId(j, this.bli);
              if (this.bli == -1)
              {
                this.bli = paramContext.getInt(j, -1);
                continue;
                this.blj = paramContext.getResourceId(j, this.blj);
                if (this.blj == -1)
                {
                  this.blj = paramContext.getInt(j, -1);
                  continue;
                  this.blk = paramContext.getResourceId(j, this.blk);
                  if (this.blk == -1)
                  {
                    this.blk = paramContext.getInt(j, -1);
                    continue;
                    this.bll = paramContext.getResourceId(j, this.bll);
                    if (this.bll == -1)
                    {
                      this.bll = paramContext.getInt(j, -1);
                      continue;
                      this.blm = paramContext.getResourceId(j, this.blm);
                      if (this.blm == -1)
                      {
                        this.blm = paramContext.getInt(j, -1);
                        continue;
                        this.bln = paramContext.getResourceId(j, this.bln);
                        if (this.bln == -1)
                        {
                          this.bln = paramContext.getInt(j, -1);
                          continue;
                          this.blo = paramContext.getResourceId(j, this.blo);
                          if (this.blo == -1)
                          {
                            this.blo = paramContext.getInt(j, -1);
                            continue;
                            this.blp = paramContext.getResourceId(j, this.blp);
                            if (this.blp == -1)
                            {
                              this.blp = paramContext.getInt(j, -1);
                              continue;
                              this.blq = paramContext.getDimensionPixelSize(j, this.blq);
                              continue;
                              this.blr = (paramContext.getFloat(j, this.blr) % 360.0F);
                              if (this.blr < 0.0F)
                              {
                                this.blr = ((360.0F - this.blr) % 360.0F);
                                continue;
                                this.blR = paramContext.getDimensionPixelOffset(j, this.blR);
                                continue;
                                this.blS = paramContext.getDimensionPixelOffset(j, this.blS);
                                continue;
                                this.bld = paramContext.getDimensionPixelOffset(j, this.bld);
                                continue;
                                this.ble = paramContext.getDimensionPixelOffset(j, this.ble);
                                continue;
                                this.blf = paramContext.getFloat(j, this.blf);
                                continue;
                                this.orientation = paramContext.getInt(j, this.orientation);
                                continue;
                                this.bls = paramContext.getResourceId(j, this.bls);
                                if (this.bls == -1)
                                {
                                  this.bls = paramContext.getInt(j, -1);
                                  continue;
                                  this.blt = paramContext.getResourceId(j, this.blt);
                                  if (this.blt == -1)
                                  {
                                    this.blt = paramContext.getInt(j, -1);
                                    continue;
                                    this.blu = paramContext.getResourceId(j, this.blu);
                                    if (this.blu == -1)
                                    {
                                      this.blu = paramContext.getInt(j, -1);
                                      continue;
                                      this.blv = paramContext.getResourceId(j, this.blv);
                                      if (this.blv == -1)
                                      {
                                        this.blv = paramContext.getInt(j, -1);
                                        continue;
                                        this.blw = paramContext.getDimensionPixelSize(j, this.blw);
                                        continue;
                                        this.blx = paramContext.getDimensionPixelSize(j, this.blx);
                                        continue;
                                        this.bly = paramContext.getDimensionPixelSize(j, this.bly);
                                        continue;
                                        this.blz = paramContext.getDimensionPixelSize(j, this.blz);
                                        continue;
                                        this.blA = paramContext.getDimensionPixelSize(j, this.blA);
                                        continue;
                                        this.blB = paramContext.getDimensionPixelSize(j, this.blB);
                                        continue;
                                        this.atU = paramContext.getFloat(j, this.atU);
                                        continue;
                                        this.atV = paramContext.getFloat(j, this.atV);
                                        continue;
                                        this.blC = paramContext.getString(j);
                                        this.blD = (0.0F / 0.0F);
                                        this.blE = -1;
                                        if (this.blC != null)
                                        {
                                          int m = this.blC.length();
                                          j = this.blC.indexOf(',');
                                          if ((j > 0) && (j < m - 1))
                                          {
                                            paramAttributeSet = this.blC.substring(0, j);
                                            if (paramAttributeSet.equalsIgnoreCase("W"))
                                            {
                                              this.blE = 0;
                                              label1495:
                                              j += 1;
                                            }
                                          }
                                          float f1;
                                          float f2;
                                          for (;;)
                                          {
                                            for (;;)
                                            {
                                              int n = this.blC.indexOf(':');
                                              if ((n < 0) || (n >= m - 1)) {
                                                break label1657;
                                              }
                                              paramAttributeSet = this.blC.substring(j, n);
                                              String str = this.blC.substring(n + 1);
                                              if ((paramAttributeSet.length() <= 0) || (str.length() <= 0)) {
                                                break;
                                              }
                                              try
                                              {
                                                f1 = Float.parseFloat(paramAttributeSet);
                                                f2 = Float.parseFloat(str);
                                                if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
                                                  break;
                                                }
                                                if (this.blE != 1) {
                                                  break label1641;
                                                }
                                                this.blD = Math.abs(f2 / f1);
                                              }
                                              catch (NumberFormatException paramAttributeSet) {}
                                            }
                                            break;
                                            if (!paramAttributeSet.equalsIgnoreCase("H")) {
                                              break label1495;
                                            }
                                            this.blE = 1;
                                            break label1495;
                                            j = 0;
                                          }
                                          label1641:
                                          f1 /= f2;
                                          this.blD = Math.abs(f1);
                                          continue;
                                          label1657:
                                          paramAttributeSet = this.blC.substring(j);
                                          if (paramAttributeSet.length() > 0)
                                          {
                                            try
                                            {
                                              this.blD = Float.parseFloat(paramAttributeSet);
                                            }
                                            catch (NumberFormatException paramAttributeSet) {}
                                            continue;
                                            this.blF = paramContext.getFloat(j, this.blF);
                                            continue;
                                            this.blG = paramContext.getFloat(j, this.blG);
                                            continue;
                                            this.blH = paramContext.getInt(j, 0);
                                            continue;
                                            this.blI = paramContext.getInt(j, 0);
                                            continue;
                                            this.blT = paramContext.getBoolean(j, this.blT);
                                            continue;
                                            this.blU = paramContext.getBoolean(j, this.blU);
                                            continue;
                                            this.blJ = paramContext.getInt(j, 0);
                                            if (this.blJ == 1)
                                            {
                                              continue;
                                              this.blK = paramContext.getInt(j, 0);
                                              if (this.blK == 1)
                                              {
                                                continue;
                                                try
                                                {
                                                  this.blL = paramContext.getDimensionPixelSize(j, this.blL);
                                                }
                                                catch (Exception paramAttributeSet) {}
                                                if (paramContext.getInt(j, this.blL) == -2)
                                                {
                                                  this.blL = -2;
                                                  continue;
                                                  try
                                                  {
                                                    this.blN = paramContext.getDimensionPixelSize(j, this.blN);
                                                  }
                                                  catch (Exception paramAttributeSet) {}
                                                  if (paramContext.getInt(j, this.blN) == -2)
                                                  {
                                                    this.blN = -2;
                                                    continue;
                                                    this.blP = Math.max(0.0F, paramContext.getFloat(j, this.blP));
                                                    continue;
                                                    try
                                                    {
                                                      this.blM = paramContext.getDimensionPixelSize(j, this.blM);
                                                    }
                                                    catch (Exception paramAttributeSet) {}
                                                    if (paramContext.getInt(j, this.blM) == -2)
                                                    {
                                                      this.blM = -2;
                                                      continue;
                                                      try
                                                      {
                                                        this.blO = paramContext.getDimensionPixelSize(j, this.blO);
                                                      }
                                                      catch (Exception paramAttributeSet) {}
                                                      if (paramContext.getInt(j, this.blO) == -2)
                                                      {
                                                        this.blO = -2;
                                                        continue;
                                                        this.blQ = Math.max(0.0F, paramContext.getFloat(j, this.blQ));
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      paramContext.recycle();
      Dl();
      AppMethodBeat.o(194211);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      AppMethodBeat.i(194228);
      this.bld = -1;
      this.ble = -1;
      this.blf = -1.0F;
      this.blg = -1;
      this.blh = -1;
      this.bli = -1;
      this.blj = -1;
      this.blk = -1;
      this.bll = -1;
      this.blm = -1;
      this.bln = -1;
      this.blo = -1;
      this.blp = -1;
      this.blq = 0;
      this.blr = 0.0F;
      this.bls = -1;
      this.blt = -1;
      this.blu = -1;
      this.blv = -1;
      this.blw = -1;
      this.blx = -1;
      this.bly = -1;
      this.blz = -1;
      this.blA = -1;
      this.blB = -1;
      this.atU = 0.5F;
      this.atV = 0.5F;
      this.blC = null;
      this.blD = 0.0F;
      this.blE = 1;
      this.blF = -1.0F;
      this.blG = -1.0F;
      this.blH = 0;
      this.blI = 0;
      this.blJ = 0;
      this.blK = 0;
      this.blL = 0;
      this.blM = 0;
      this.blN = 0;
      this.blO = 0;
      this.blP = 1.0F;
      this.blQ = 1.0F;
      this.blR = -1;
      this.blS = -1;
      this.orientation = -1;
      this.blT = false;
      this.blU = false;
      this.blV = true;
      this.blW = true;
      this.blX = false;
      this.blY = false;
      this.blZ = false;
      this.bma = false;
      this.bmb = -1;
      this.bmc = -1;
      this.bmd = -1;
      this.bme = -1;
      this.bmf = -1;
      this.bmg = -1;
      this.bmh = 0.5F;
      this.bml = new androidx.constraintlayout.a.a.f();
      this.bmm = false;
      AppMethodBeat.o(194228);
    }
    
    public final void Dl()
    {
      AppMethodBeat.i(194238);
      this.blY = false;
      this.blV = true;
      this.blW = true;
      if ((this.width == -2) && (this.blT))
      {
        this.blV = false;
        this.blJ = 1;
      }
      if ((this.height == -2) && (this.blU))
      {
        this.blW = false;
        this.blK = 1;
      }
      if ((this.width == 0) || (this.width == -1))
      {
        this.blV = false;
        if ((this.width == 0) && (this.blJ == 1))
        {
          this.width = -2;
          this.blT = true;
        }
      }
      if ((this.height == 0) || (this.height == -1))
      {
        this.blW = false;
        if ((this.height == 0) && (this.blK == 1))
        {
          this.height = -2;
          this.blU = true;
        }
      }
      if ((this.blf != -1.0F) || (this.bld != -1) || (this.ble != -1))
      {
        this.blY = true;
        this.blV = true;
        this.blW = true;
        if (!(this.bml instanceof i)) {
          this.bml = new i();
        }
        ((i)this.bml).setOrientation(this.orientation);
      }
      AppMethodBeat.o(194238);
    }
    
    public void resolveLayoutDirection(int paramInt)
    {
      AppMethodBeat.i(194252);
      int i = this.leftMargin;
      int j = this.rightMargin;
      super.resolveLayoutDirection(paramInt);
      this.bmd = -1;
      this.bme = -1;
      this.bmb = -1;
      this.bmc = -1;
      this.bmf = -1;
      this.bmg = -1;
      this.bmf = this.blw;
      this.bmg = this.bly;
      this.bmh = this.atU;
      this.bmi = this.bld;
      this.bmj = this.ble;
      this.bmk = this.blf;
      if (1 == getLayoutDirection())
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label449;
        }
        paramInt = 0;
        if (this.bls == -1) {
          break label368;
        }
        this.bmd = this.bls;
        paramInt = 1;
        label133:
        if (this.blu != -1)
        {
          this.bmc = this.blu;
          paramInt = 1;
        }
        if (this.blv != -1)
        {
          this.bmb = this.blv;
          paramInt = 1;
        }
        if (this.blA != -1) {
          this.bmg = this.blA;
        }
        if (this.blB != -1) {
          this.bmf = this.blB;
        }
        if (paramInt != 0) {
          this.bmh = (1.0F - this.atU);
        }
        if ((this.blY) && (this.orientation == 1))
        {
          if (this.blf == -1.0F) {
            break label389;
          }
          this.bmk = (1.0F - this.blf);
          this.bmi = -1;
          this.bmj = -1;
        }
        label260:
        if ((this.blu != -1) || (this.blv != -1) || (this.blt != -1) || (this.bls != -1)) {
          break label615;
        }
        if (this.bli == -1) {
          break label548;
        }
        this.bmd = this.bli;
        if ((this.rightMargin <= 0) && (j > 0)) {
          this.rightMargin = j;
        }
      }
      for (;;)
      {
        if (this.blg == -1) {
          break label583;
        }
        this.bmb = this.blg;
        if ((this.leftMargin > 0) || (i <= 0)) {
          break label615;
        }
        this.leftMargin = i;
        AppMethodBeat.o(194252);
        return;
        paramInt = 0;
        break;
        label368:
        if (this.blt == -1) {
          break label133;
        }
        this.bme = this.blt;
        paramInt = 1;
        break label133;
        label389:
        if (this.bld != -1)
        {
          this.bmj = this.bld;
          this.bmi = -1;
          this.bmk = -1.0F;
          break label260;
        }
        if (this.ble == -1) {
          break label260;
        }
        this.bmi = this.ble;
        this.bmj = -1;
        this.bmk = -1.0F;
        break label260;
        label449:
        if (this.bls != -1) {
          this.bmc = this.bls;
        }
        if (this.blt != -1) {
          this.bmb = this.blt;
        }
        if (this.blu != -1) {
          this.bmd = this.blu;
        }
        if (this.blv != -1) {
          this.bme = this.blv;
        }
        if (this.blA != -1) {
          this.bmf = this.blA;
        }
        if (this.blB == -1) {
          break label260;
        }
        this.bmg = this.blB;
        break label260;
        label548:
        if (this.blj != -1)
        {
          this.bme = this.blj;
          if ((this.rightMargin <= 0) && (j > 0)) {
            this.rightMargin = j;
          }
        }
      }
      label583:
      if (this.blh != -1)
      {
        this.bmc = this.blh;
        if ((this.leftMargin <= 0) && (i > 0)) {
          this.leftMargin = i;
        }
      }
      label615:
      AppMethodBeat.o(194252);
    }
    
    static final class a
    {
      public static final SparseIntArray bmn;
      
      static
      {
        AppMethodBeat.i(194169);
        SparseIntArray localSparseIntArray = new SparseIntArray();
        bmn = localSparseIntArray;
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
        bmn.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
        bmn.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
        AppMethodBeat.o(194169);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintLayout
 * JD-Core Version:    0.7.0.1
 */