package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
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
  private int CO;
  private int DJ;
  SparseArray<View> EG;
  private ArrayList<ConstraintHelper> EH;
  private final ArrayList<androidx.constraintlayout.a.a.f> EI;
  g EJ;
  private int EK;
  private boolean EL;
  private a EM;
  private int EN;
  private HashMap<String, Integer> EO;
  private int EP;
  private int EQ;
  int ER;
  int ES;
  int ET;
  int EU;
  private androidx.constraintlayout.a.f EV;
  private int lj;
  private int uJ;
  
  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(194678);
    this.EG = new SparseArray();
    this.EH = new ArrayList(4);
    this.EI = new ArrayList(100);
    this.EJ = new g();
    this.lj = 0;
    this.CO = 0;
    this.uJ = 2147483647;
    this.EK = 2147483647;
    this.EL = true;
    this.DJ = 7;
    this.EM = null;
    this.EN = -1;
    this.EO = new HashMap();
    this.EP = -1;
    this.EQ = -1;
    this.ER = -1;
    this.ES = -1;
    this.ET = 0;
    this.EU = 0;
    f(null);
    AppMethodBeat.o(194678);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194683);
    this.EG = new SparseArray();
    this.EH = new ArrayList(4);
    this.EI = new ArrayList(100);
    this.EJ = new g();
    this.lj = 0;
    this.CO = 0;
    this.uJ = 2147483647;
    this.EK = 2147483647;
    this.EL = true;
    this.DJ = 7;
    this.EM = null;
    this.EN = -1;
    this.EO = new HashMap();
    this.EP = -1;
    this.EQ = -1;
    this.ER = -1;
    this.ES = -1;
    this.ET = 0;
    this.EU = 0;
    f(paramAttributeSet);
    AppMethodBeat.o(194683);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194687);
    this.EG = new SparseArray();
    this.EH = new ArrayList(4);
    this.EI = new ArrayList(100);
    this.EJ = new g();
    this.lj = 0;
    this.CO = 0;
    this.uJ = 2147483647;
    this.EK = 2147483647;
    this.EL = true;
    this.DJ = 7;
    this.EM = null;
    this.EN = -1;
    this.EO = new HashMap();
    this.EP = -1;
    this.EQ = -1;
    this.ER = -1;
    this.ES = -1;
    this.ET = 0;
    this.EU = 0;
    f(paramAttributeSet);
    AppMethodBeat.o(194687);
  }
  
  private final androidx.constraintlayout.a.a.f bf(int paramInt)
  {
    AppMethodBeat.i(194729);
    if (paramInt == 0)
    {
      localObject = this.EJ;
      AppMethodBeat.o(194729);
      return localObject;
    }
    View localView = (View)this.EG.get(paramInt);
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
      localObject = this.EJ;
      AppMethodBeat.o(194729);
      return localObject;
    }
    if (localObject == null)
    {
      AppMethodBeat.o(194729);
      return null;
    }
    localObject = ((LayoutParams)((View)localObject).getLayoutParams()).Gh;
    AppMethodBeat.o(194729);
    return localObject;
  }
  
  private void c(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(194667);
    if (((paramObject1 instanceof String)) && ((paramObject2 instanceof Integer)))
    {
      if (this.EO == null) {
        this.EO = new HashMap();
      }
      String str = (String)paramObject1;
      int i = str.indexOf("/");
      paramObject1 = str;
      if (i != -1) {
        paramObject1 = str.substring(i + 1);
      }
      i = ((Integer)paramObject2).intValue();
      this.EO.put(paramObject1, Integer.valueOf(i));
    }
    AppMethodBeat.o(194667);
  }
  
  private void f(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(194696);
    this.EJ.CV = this;
    this.EG.put(getId(), this);
    this.EM = null;
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
          this.lj = paramAttributeSet.getDimensionPixelOffset(j, this.lj);
        }
        do
        {
          for (;;)
          {
            i += 1;
            break;
            if (j == R.styleable.ConstraintLayout_Layout_android_minHeight)
            {
              this.CO = paramAttributeSet.getDimensionPixelOffset(j, this.CO);
            }
            else if (j == R.styleable.ConstraintLayout_Layout_android_maxWidth)
            {
              this.uJ = paramAttributeSet.getDimensionPixelOffset(j, this.uJ);
            }
            else if (j == R.styleable.ConstraintLayout_Layout_android_maxHeight)
            {
              this.EK = paramAttributeSet.getDimensionPixelOffset(j, this.EK);
            }
            else
            {
              if (j != R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                break label185;
              }
              this.DJ = paramAttributeSet.getInt(j, this.DJ);
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
          this.EM = new a();
          a locala = this.EM;
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
          this.EM = null;
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
          this.EN = m;
          break;
          str = localXmlResourceParser.getName();
          localObject = Xml.asAttributeSet(localXmlResourceParser);
          locala1 = new a.a((byte)0);
          localObject = localContext.obtainStyledAttributes((AttributeSet)localObject, R.styleable.ConstraintSet);
          a.a(locala1, (TypedArray)localObject);
          ((TypedArray)localObject).recycle();
          if (str.equalsIgnoreCase("Guideline")) {
            locala1.Gn = true;
          }
          localXmlPullParserException.Gl.put(Integer.valueOf(locala1.Go), locala1);
        }
        catch (IOException localIOException) {}
      }
      paramAttributeSet.recycle();
      this.EJ.DJ = this.DJ;
      AppMethodBeat.o(194696);
      return;
      label404:
      if (j != 1) {
        switch (j)
        {
        }
      }
    }
  }
  
  private void ga()
  {
    AppMethodBeat.i(194763);
    this.EJ.fP();
    if (this.EV != null)
    {
      AppMethodBeat.o(194763);
      throw null;
    }
    AppMethodBeat.o(194763);
  }
  
  protected static LayoutParams gb()
  {
    AppMethodBeat.i(194777);
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    AppMethodBeat.o(194777);
    return localLayoutParams;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(194700);
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14) {
      onViewAdded(paramView);
    }
    AppMethodBeat.o(194700);
  }
  
  public final View bg(int paramInt)
  {
    AppMethodBeat.i(194782);
    View localView = (View)this.EG.get(paramInt);
    AppMethodBeat.o(194782);
    return localView;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(194786);
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
    AppMethodBeat.o(194786);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(194779);
    paramLayoutParams = new LayoutParams(paramLayoutParams);
    AppMethodBeat.o(194779);
    return paramLayoutParams;
  }
  
  public int getMaxHeight()
  {
    return this.EK;
  }
  
  public int getMaxWidth()
  {
    return this.uJ;
  }
  
  public int getMinHeight()
  {
    return this.CO;
  }
  
  public int getMinWidth()
  {
    return this.lj;
  }
  
  public int getOptimizationLevel()
  {
    return this.EJ.DJ;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(194771);
    paramInt2 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      androidx.constraintlayout.a.a.f localf = localLayoutParams.Gh;
      if (((localView.getVisibility() != 8) || (localLayoutParams.FU) || (localLayoutParams.FV) || (paramBoolean)) && (!localLayoutParams.FW))
      {
        paramInt3 = localf.fC();
        paramInt4 = localf.fD();
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
    paramInt2 = this.EH.size();
    if (paramInt2 > 0)
    {
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        ((ConstraintHelper)this.EH.get(paramInt1)).fZ();
        paramInt1 += 1;
      }
    }
    AppMethodBeat.o(194771);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194758);
    System.currentTimeMillis();
    int i13 = View.MeasureSpec.getMode(paramInt1);
    int i14 = View.MeasureSpec.getSize(paramInt1);
    int i15 = View.MeasureSpec.getMode(paramInt2);
    int i16 = View.MeasureSpec.getSize(paramInt2);
    int i11 = getPaddingLeft();
    int i12 = getPaddingTop();
    this.EJ.setX(i11);
    this.EJ.setY(i12);
    Object localObject1 = this.EJ;
    int i = this.uJ;
    ((androidx.constraintlayout.a.a.f)localObject1).Cn[0] = i;
    localObject1 = this.EJ;
    i = this.EK;
    ((androidx.constraintlayout.a.a.f)localObject1).Cn[1] = i;
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
      localObject1 = this.EJ;
      if (getLayoutDirection() == 1)
      {
        bool = true;
        ((g)localObject1).tL = bool;
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
      localObject1 = f.a.Do;
      localObject2 = f.a.Do;
      getLayoutParams();
      switch (i1)
      {
      default: 
        i = 0;
        switch (k)
        {
        default: 
          j = 0;
          this.EJ.setMinWidth(0);
          this.EJ.setMinHeight(0);
          this.EJ.a((f.a)localObject1);
          this.EJ.setWidth(i);
          this.EJ.b((f.a)localObject2);
          this.EJ.setHeight(j);
          this.EJ.setMinWidth(this.lj - getPaddingLeft() - getPaddingRight());
          this.EJ.setMinHeight(this.CO - getPaddingTop() - getPaddingBottom());
          i9 = this.EJ.getWidth();
          i10 = this.EJ.getHeight();
          if (!this.EL) {
            break label6090;
          }
          this.EL = false;
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
        this.EI.clear();
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
            c(localObject2, Integer.valueOf(((View)localObject3).getId()));
            j = ((String)localObject2).indexOf('/');
            localObject1 = localObject2;
            if (j != -1) {
              localObject1 = ((String)localObject2).substring(j + 1);
            }
            bf(((View)localObject3).getId()).CY = ((String)localObject1);
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
        localObject1 = f.a.Dp;
        break label239;
        localObject1 = f.a.Dp;
        i = 0;
        break label239;
        i = Math.min(this.uJ, i) - (i2 + i3);
        break label239;
        localObject2 = f.a.Dp;
        break label279;
        localObject2 = f.a.Dp;
        j = 0;
        break label279;
        j = Math.min(this.EK, j) - (m + n);
        break label279;
      }
      i += 1;
    }
    label662:
    i = 0;
    while (i < i17)
    {
      localObject1 = u(getChildAt(i));
      if (localObject1 != null) {
        ((androidx.constraintlayout.a.a.f)localObject1).reset();
      }
      i += 1;
    }
    if (this.EN != -1)
    {
      i = 0;
      while (i < i17)
      {
        localObject1 = getChildAt(i);
        if ((((View)localObject1).getId() == this.EN) && ((localObject1 instanceof Constraints))) {
          this.EM = ((Constraints)localObject1).getConstraintSet();
        }
        i += 1;
      }
    }
    if (this.EM != null) {
      this.EM.d(this);
    }
    this.EJ.fX();
    int j = this.EH.size();
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        ((ConstraintHelper)this.EH.get(i)).a(this);
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
      localObject2 = u((View)localObject3);
      if (localObject2 != null)
      {
        localObject1 = (LayoutParams)((View)localObject3).getLayoutParams();
        ((LayoutParams)localObject1).validate();
        if (!((LayoutParams)localObject1).Gi) {
          break label1098;
        }
        ((LayoutParams)localObject1).Gi = false;
        label945:
        ((androidx.constraintlayout.a.a.f)localObject2).CX = ((View)localObject3).getVisibility();
        if (((LayoutParams)localObject1).FW) {
          ((androidx.constraintlayout.a.a.f)localObject2).CX = 8;
        }
        ((androidx.constraintlayout.a.a.f)localObject2).CV = localObject3;
        this.EJ.e((androidx.constraintlayout.a.a.f)localObject2);
        if ((!((LayoutParams)localObject1).FS) || (!((LayoutParams)localObject1).FR)) {
          this.EI.add(localObject2);
        }
        if (!((LayoutParams)localObject1).FU) {
          break label1202;
        }
        localObject2 = (i)localObject2;
        j = ((LayoutParams)localObject1).Ge;
        i = ((LayoutParams)localObject1).Gf;
        f1 = ((LayoutParams)localObject1).Gg;
        if (Build.VERSION.SDK_INT < 17)
        {
          j = ((LayoutParams)localObject1).EW;
          i = ((LayoutParams)localObject1).EX;
          f1 = ((LayoutParams)localObject1).EY;
        }
        if (f1 == -1.0F) {
          break label1170;
        }
        ((i)localObject2).g(f1);
      }
      label1098:
      while ((((LayoutParams)localObject1).EZ == -1) && (((LayoutParams)localObject1).Fa == -1) && (((LayoutParams)localObject1).Fb == -1) && (((LayoutParams)localObject1).Fc == -1) && (((LayoutParams)localObject1).Fm == -1) && (((LayoutParams)localObject1).Fl == -1) && (((LayoutParams)localObject1).Fn == -1) && (((LayoutParams)localObject1).Fo == -1) && (((LayoutParams)localObject1).Fd == -1) && (((LayoutParams)localObject1).Fe == -1) && (((LayoutParams)localObject1).Ff == -1) && (((LayoutParams)localObject1).Fg == -1) && (((LayoutParams)localObject1).Fh == -1) && (((LayoutParams)localObject1).FM == -1) && (((LayoutParams)localObject1).FN == -1) && (((LayoutParams)localObject1).Fi == -1) && (((LayoutParams)localObject1).width != -1) && (((LayoutParams)localObject1).height != -1)) {
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
              c(str, Integer.valueOf(((View)localObject3).getId()));
              str = str.substring(str.indexOf("id/") + 3);
              bf(((View)localObject3).getId()).CY = str;
            }
            catch (Resources.NotFoundException localNotFoundException2) {}
          }
          break label945;
          if (j != -1) {
            ((i)localObject2).aZ(j);
          } else if (i != -1) {
            ((i)localObject2).bc(i);
          }
        }
      }
      label1170:
      label1202:
      m = ((LayoutParams)localObject1).FX;
      k = ((LayoutParams)localObject1).FY;
      i3 = ((LayoutParams)localObject1).FZ;
      i2 = ((LayoutParams)localObject1).Ga;
      i4 = ((LayoutParams)localObject1).Gb;
      i1 = ((LayoutParams)localObject1).Gc;
      f2 = ((LayoutParams)localObject1).Gd;
      if (Build.VERSION.SDK_INT >= 17) {
        break label6064;
      }
      k = ((LayoutParams)localObject1).EZ;
      m = ((LayoutParams)localObject1).Fa;
      i7 = ((LayoutParams)localObject1).Fb;
      i8 = ((LayoutParams)localObject1).Fc;
      i6 = ((LayoutParams)localObject1).Fp;
      n = ((LayoutParams)localObject1).Fr;
      f1 = ((LayoutParams)localObject1).Fv;
      i = m;
      j = k;
      if (k == -1)
      {
        i = m;
        j = k;
        if (m == -1)
        {
          if (((LayoutParams)localObject1).Fm == -1) {
            break label2036;
          }
          j = ((LayoutParams)localObject1).Fm;
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
      if (((LayoutParams)localObject1).Fn != -1)
      {
        i2 = ((LayoutParams)localObject1).Fn;
        i1 = i8;
        i4 = i6;
        label1607:
        if (((LayoutParams)localObject1).Fi == -1) {
          break label2121;
        }
        localObject3 = bf(((LayoutParams)localObject1).Fi);
        if (localObject3 != null)
        {
          f1 = ((LayoutParams)localObject1).Fk;
          i = ((LayoutParams)localObject1).Fj;
          ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BR, (androidx.constraintlayout.a.a.f)localObject3, e.c.BR, i, 0);
          ((androidx.constraintlayout.a.a.f)localObject2).Co = f1;
        }
        if ((bool) && ((((LayoutParams)localObject1).FM != -1) || (((LayoutParams)localObject1).FN != -1))) {
          ((androidx.constraintlayout.a.a.f)localObject2).u(((LayoutParams)localObject1).FM, ((LayoutParams)localObject1).FN);
        }
        if (((LayoutParams)localObject1).FR) {
          break label2682;
        }
        if (((LayoutParams)localObject1).width != -1) {
          break label2665;
        }
        ((androidx.constraintlayout.a.a.f)localObject2).a(f.a.Dr);
        ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BM).Bw = ((LayoutParams)localObject1).leftMargin;
        ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BO).Bw = ((LayoutParams)localObject1).rightMargin;
        label1762:
        if (((LayoutParams)localObject1).FS) {
          break label2720;
        }
        if (((LayoutParams)localObject1).height != -1) {
          break label2703;
        }
        ((androidx.constraintlayout.a.a.f)localObject2).b(f.a.Dr);
        ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BN).Bw = ((LayoutParams)localObject1).topMargin;
        ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BP).Bw = ((LayoutParams)localObject1).bottomMargin;
      }
      for (;;)
      {
        if (((LayoutParams)localObject1).Fx != null) {
          ((androidx.constraintlayout.a.a.f)localObject2).x(((LayoutParams)localObject1).Fx);
        }
        f1 = ((LayoutParams)localObject1).FA;
        ((androidx.constraintlayout.a.a.f)localObject2).Di[0] = f1;
        f1 = ((LayoutParams)localObject1).FB;
        ((androidx.constraintlayout.a.a.f)localObject2).Di[1] = f1;
        ((androidx.constraintlayout.a.a.f)localObject2).De = ((LayoutParams)localObject1).FC;
        ((androidx.constraintlayout.a.a.f)localObject2).Df = ((LayoutParams)localObject1).FD;
        i = ((LayoutParams)localObject1).FE;
        j = ((LayoutParams)localObject1).FG;
        k = ((LayoutParams)localObject1).FI;
        f1 = ((LayoutParams)localObject1).FK;
        ((androidx.constraintlayout.a.a.f)localObject2).BZ = i;
        ((androidx.constraintlayout.a.a.f)localObject2).Cc = j;
        ((androidx.constraintlayout.a.a.f)localObject2).Cd = k;
        ((androidx.constraintlayout.a.a.f)localObject2).Ce = f1;
        if ((f1 < 1.0F) && (((androidx.constraintlayout.a.a.f)localObject2).BZ == 0)) {
          ((androidx.constraintlayout.a.a.f)localObject2).BZ = 2;
        }
        i = ((LayoutParams)localObject1).FF;
        j = ((LayoutParams)localObject1).FH;
        k = ((LayoutParams)localObject1).FJ;
        f1 = ((LayoutParams)localObject1).FL;
        ((androidx.constraintlayout.a.a.f)localObject2).Ca = i;
        ((androidx.constraintlayout.a.a.f)localObject2).Cf = j;
        ((androidx.constraintlayout.a.a.f)localObject2).Cg = k;
        ((androidx.constraintlayout.a.a.f)localObject2).Ch = f1;
        if ((f1 >= 1.0F) || (((androidx.constraintlayout.a.a.f)localObject2).Ca != 0)) {
          break;
        }
        ((androidx.constraintlayout.a.a.f)localObject2).Ca = 2;
        break;
        label2036:
        i = m;
        j = k;
        if (((LayoutParams)localObject1).Fl == -1) {
          break label1517;
        }
        i = ((LayoutParams)localObject1).Fl;
        j = k;
        break label1517;
        f2 = f1;
        i1 = n;
        i2 = i8;
        i3 = i7;
        i4 = i6;
        k = i;
        m = j;
        if (((LayoutParams)localObject1).Fo == -1) {
          break label6064;
        }
        i1 = ((LayoutParams)localObject1).Fo;
        i2 = i7;
        i4 = i6;
        break label1607;
        label2121:
        if (j != -1)
        {
          localObject3 = bf(j);
          if (localObject3 != null) {
            ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BM, (androidx.constraintlayout.a.a.f)localObject3, e.c.BM, ((LayoutParams)localObject1).leftMargin, i4);
          }
          label2160:
          if (i2 == -1) {
            break label2521;
          }
          localObject3 = bf(i2);
          if (localObject3 != null) {
            ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BO, (androidx.constraintlayout.a.a.f)localObject3, e.c.BM, ((LayoutParams)localObject1).rightMargin, n);
          }
          if (((LayoutParams)localObject1).Fd == -1) {
            break label2563;
          }
          localObject3 = bf(((LayoutParams)localObject1).Fd);
          if (localObject3 != null) {
            ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BN, (androidx.constraintlayout.a.a.f)localObject3, e.c.BN, ((LayoutParams)localObject1).topMargin, ((LayoutParams)localObject1).Fq);
          }
          if (((LayoutParams)localObject1).Ff == -1) {
            break label2614;
          }
          localObject3 = bf(((LayoutParams)localObject1).Ff);
          if (localObject3 != null) {
            ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BP, (androidx.constraintlayout.a.a.f)localObject3, e.c.BN, ((LayoutParams)localObject1).bottomMargin, ((LayoutParams)localObject1).Fs);
          }
        }
        for (;;)
        {
          label2199:
          label2247:
          if (((LayoutParams)localObject1).Fh != -1)
          {
            localObject4 = (View)this.EG.get(((LayoutParams)localObject1).Fh);
            localObject3 = bf(((LayoutParams)localObject1).Fh);
            if ((localObject3 != null) && (localObject4 != null) && ((((View)localObject4).getLayoutParams() instanceof LayoutParams)))
            {
              localObject4 = (LayoutParams)((View)localObject4).getLayoutParams();
              ((LayoutParams)localObject1).FT = true;
              ((LayoutParams)localObject4).FT = true;
              ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BQ).a(((androidx.constraintlayout.a.a.f)localObject3).a(e.c.BQ), 0, -1, e.b.BI, 0, true);
              ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BN).reset();
              ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BP).reset();
            }
          }
          if ((f1 >= 0.0F) && (f1 != 0.5F)) {
            ((androidx.constraintlayout.a.a.f)localObject2).CT = f1;
          }
          if ((((LayoutParams)localObject1).Fw < 0.0F) || (((LayoutParams)localObject1).Fw == 0.5F)) {
            break;
          }
          ((androidx.constraintlayout.a.a.f)localObject2).CU = ((LayoutParams)localObject1).Fw;
          break;
          if (i == -1) {
            break label2160;
          }
          localObject3 = bf(i);
          if (localObject3 == null) {
            break label2160;
          }
          ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BM, (androidx.constraintlayout.a.a.f)localObject3, e.c.BO, ((LayoutParams)localObject1).leftMargin, i4);
          break label2160;
          label2521:
          if (i1 == -1) {
            break label2199;
          }
          localObject3 = bf(i1);
          if (localObject3 == null) {
            break label2199;
          }
          ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BO, (androidx.constraintlayout.a.a.f)localObject3, e.c.BO, ((LayoutParams)localObject1).rightMargin, n);
          break label2199;
          label2563:
          if (((LayoutParams)localObject1).Fe == -1) {
            break label2247;
          }
          localObject3 = bf(((LayoutParams)localObject1).Fe);
          if (localObject3 == null) {
            break label2247;
          }
          ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BN, (androidx.constraintlayout.a.a.f)localObject3, e.c.BP, ((LayoutParams)localObject1).topMargin, ((LayoutParams)localObject1).Fq);
          break label2247;
          label2614:
          if (((LayoutParams)localObject1).Fg != -1)
          {
            localObject3 = bf(((LayoutParams)localObject1).Fg);
            if (localObject3 != null) {
              ((androidx.constraintlayout.a.a.f)localObject2).a(e.c.BP, (androidx.constraintlayout.a.a.f)localObject3, e.c.BP, ((LayoutParams)localObject1).bottomMargin, ((LayoutParams)localObject1).Fs);
            }
          }
        }
        label2665:
        ((androidx.constraintlayout.a.a.f)localObject2).a(f.a.Dq);
        ((androidx.constraintlayout.a.a.f)localObject2).setWidth(0);
        break label1762;
        label2682:
        ((androidx.constraintlayout.a.a.f)localObject2).a(f.a.Do);
        ((androidx.constraintlayout.a.a.f)localObject2).setWidth(((LayoutParams)localObject1).width);
        break label1762;
        label2703:
        ((androidx.constraintlayout.a.a.f)localObject2).b(f.a.Dq);
        ((androidx.constraintlayout.a.a.f)localObject2).setHeight(0);
        continue;
        label2720:
        ((androidx.constraintlayout.a.a.f)localObject2).b(f.a.Do);
        ((androidx.constraintlayout.a.a.f)localObject2).setHeight(((LayoutParams)localObject1).height);
      }
    }
    label2741:
    label2936:
    label6009:
    for (i5 = 1;; i5 = 0)
    {
      if ((this.DJ & 0x8) == 8) {
        i4 = 1;
      }
      while (i4 != 0)
      {
        this.EJ.fQ();
        this.EJ.z(i9, i10);
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
              localObject3 = ((LayoutParams)localObject2).Gh;
              if ((!((LayoutParams)localObject2).FU) && (!((LayoutParams)localObject2).FV))
              {
                ((androidx.constraintlayout.a.a.f)localObject3).CX = ((View)localObject1).getVisibility();
                m = ((LayoutParams)localObject2).width;
                n = ((LayoutParams)localObject2).height;
                if ((m != 0) && (n != 0)) {
                  break label2936;
                }
                ((androidx.constraintlayout.a.a.f)localObject3).fA().invalidate();
                ((androidx.constraintlayout.a.a.f)localObject3).fB().invalidate();
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
            if (this.EV != null)
            {
              AppMethodBeat.o(194758);
              throw null;
            }
            if (m == -2)
            {
              bool = true;
              ((androidx.constraintlayout.a.a.f)localObject3).Ci = bool;
              if (n != -2) {
                break label3161;
              }
            }
            for (bool = true;; bool = false)
            {
              ((androidx.constraintlayout.a.a.f)localObject3).Cj = bool;
              m = ((View)localObject1).getMeasuredWidth();
              n = ((View)localObject1).getMeasuredHeight();
              ((androidx.constraintlayout.a.a.f)localObject3).setWidth(m);
              ((androidx.constraintlayout.a.a.f)localObject3).setHeight(n);
              if (j != 0) {
                ((androidx.constraintlayout.a.a.f)localObject3).CQ = m;
              }
              if (k != 0) {
                ((androidx.constraintlayout.a.a.f)localObject3).CR = n;
              }
              if (((LayoutParams)localObject2).FT)
              {
                j = ((View)localObject1).getBaseline();
                if (j != -1) {
                  ((androidx.constraintlayout.a.a.f)localObject3).CN = j;
                }
              }
              if ((!((LayoutParams)localObject2).FR) || (!((LayoutParams)localObject2).FS)) {
                break;
              }
              ((androidx.constraintlayout.a.a.f)localObject3).fA().be(m);
              ((androidx.constraintlayout.a.a.f)localObject3).fB().be(n);
              break;
              bool = false;
              break label3012;
            }
          }
        }
        this.EJ.fR();
        i6 = 0;
        if (i6 >= i19) {
          break label4488;
        }
        localObject1 = getChildAt(i6);
        if (((View)localObject1).getVisibility() != 8)
        {
          localObject2 = (LayoutParams)((View)localObject1).getLayoutParams();
          localObject3 = ((LayoutParams)localObject2).Gh;
          if ((!((LayoutParams)localObject2).FU) && (!((LayoutParams)localObject2).FV))
          {
            ((androidx.constraintlayout.a.a.f)localObject3).CX = ((View)localObject1).getVisibility();
            n = ((LayoutParams)localObject2).width;
            m = ((LayoutParams)localObject2).height;
            if ((n == 0) || (m == 0))
            {
              localObject4 = ((androidx.constraintlayout.a.a.f)localObject3).a(e.c.BM).Bs;
              m localm1 = ((androidx.constraintlayout.a.a.f)localObject3).a(e.c.BO).Bs;
              if ((((androidx.constraintlayout.a.a.f)localObject3).a(e.c.BM).Bv != null) && (((androidx.constraintlayout.a.a.f)localObject3).a(e.c.BO).Bv != null))
              {
                k = 1;
                m localm2 = ((androidx.constraintlayout.a.a.f)localObject3).a(e.c.BN).Bs;
                m localm3 = ((androidx.constraintlayout.a.a.f)localObject3).a(e.c.BP).Bs;
                if ((((androidx.constraintlayout.a.a.f)localObject3).a(e.c.BN).Bv == null) || (((androidx.constraintlayout.a.a.f)localObject3).a(e.c.BP).Bv == null)) {
                  break label3666;
                }
                i7 = 1;
                if ((n == 0) && (m == 0) && (k != 0) && (i7 != 0)) {
                  break label3955;
                }
                i8 = 0;
                if (this.EJ.fM() == f.a.Dp) {
                  break label3672;
                }
                j = 1;
                if (this.EJ.fN() == f.a.Dp) {
                  break label3678;
                }
                i = 1;
                if (j == 0) {
                  ((androidx.constraintlayout.a.a.f)localObject3).fA().invalidate();
                }
                if (i == 0) {
                  ((androidx.constraintlayout.a.a.f)localObject3).fB().invalidate();
                }
                if (n != 0) {
                  break label3711;
                }
                if ((j == 0) || (!((androidx.constraintlayout.a.a.f)localObject3).fw()) || (k == 0) || (!((m)localObject4).fW()) || (!localm1.fW())) {
                  break label3684;
                }
                n = (int)(localm1.El - ((m)localObject4).El);
                ((androidx.constraintlayout.a.a.f)localObject3).fA().be(n);
                k = 0;
                i2 = getChildMeasureSpec(paramInt1, i18, n);
                i3 = n;
                i1 = k;
                n = j;
                if (m != 0) {
                  break label3772;
                }
                if ((i == 0) || (!((androidx.constraintlayout.a.a.f)localObject3).fx()) || (i7 == 0) || (!localm2.fW()) || (!localm3.fW())) {
                  break label3753;
                }
                k = (int)(localm3.El - localm2.El);
                ((androidx.constraintlayout.a.a.f)localObject3).fB().be(k);
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
                  if (this.EV == null) {
                    break label3811;
                  }
                  AppMethodBeat.o(194758);
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
              ((androidx.constraintlayout.a.a.f)localObject3).Ci = bool;
              if (m != -2) {
                break label3970;
              }
              bool = true;
              label3838:
              ((androidx.constraintlayout.a.a.f)localObject3).Cj = bool;
              k = ((View)localObject1).getMeasuredWidth();
              m = ((View)localObject1).getMeasuredHeight();
              ((androidx.constraintlayout.a.a.f)localObject3).setWidth(k);
              ((androidx.constraintlayout.a.a.f)localObject3).setHeight(m);
              if (i1 != 0) {
                ((androidx.constraintlayout.a.a.f)localObject3).CQ = k;
              }
              if (j != 0) {
                ((androidx.constraintlayout.a.a.f)localObject3).CR = m;
              }
              if (n == 0) {
                break label3976;
              }
              ((androidx.constraintlayout.a.a.f)localObject3).fA().be(k);
              if (i == 0) {
                break label3988;
              }
              ((androidx.constraintlayout.a.a.f)localObject3).fB().be(m);
            }
          }
        }
        for (;;)
        {
          if (((LayoutParams)localObject2).FT)
          {
            i = ((View)localObject1).getBaseline();
            if (i != -1) {
              ((androidx.constraintlayout.a.a.f)localObject3).CN = i;
            }
          }
          i6 += 1;
          break;
          label3964:
          bool = false;
          break label3821;
          bool = false;
          break label3838;
          ((androidx.constraintlayout.a.a.f)localObject3).fA().state = 2;
          break label3912;
          ((androidx.constraintlayout.a.a.f)localObject3).fB().state = 2;
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
          localObject3 = ((LayoutParams)localObject2).Gh;
          if ((!((LayoutParams)localObject2).FU) && (!((LayoutParams)localObject2).FV))
          {
            ((androidx.constraintlayout.a.a.f)localObject3).CX = ((View)localObject1).getVisibility();
            i1 = ((LayoutParams)localObject2).width;
            i2 = ((LayoutParams)localObject2).height;
            if ((((LayoutParams)localObject2).FR) || (((LayoutParams)localObject2).FS) || ((!((LayoutParams)localObject2).FR) && (((LayoutParams)localObject2).FE == 1)) || (((LayoutParams)localObject2).width == -1) || ((!((LayoutParams)localObject2).FS) && ((((LayoutParams)localObject2).FF == 1) || (((LayoutParams)localObject2).height == -1))))
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
              if (this.EV == null) {
                break label4353;
              }
              AppMethodBeat.o(194758);
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
            ((androidx.constraintlayout.a.a.f)localObject3).Ci = bool;
            if (i2 != -2) {
              break label4482;
            }
          }
        }
        for (bool = true;; bool = false)
        {
          ((androidx.constraintlayout.a.a.f)localObject3).Cj = bool;
          m = ((View)localObject1).getMeasuredWidth();
          k = ((View)localObject1).getMeasuredHeight();
          ((androidx.constraintlayout.a.a.f)localObject3).setWidth(m);
          ((androidx.constraintlayout.a.a.f)localObject3).setHeight(k);
          if (i != 0) {
            ((androidx.constraintlayout.a.a.f)localObject3).CQ = m;
          }
          if (j != 0) {
            ((androidx.constraintlayout.a.a.f)localObject3).CR = k;
          }
          if (((LayoutParams)localObject2).FT)
          {
            i = ((View)localObject1).getBaseline();
            if (i != -1) {
              ((androidx.constraintlayout.a.a.f)localObject3).CN = i;
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
            if (((Placeholder)localObject2).GR != null)
            {
              localObject1 = (LayoutParams)((Placeholder)localObject2).getLayoutParams();
              localObject2 = (LayoutParams)((Placeholder)localObject2).GR.getLayoutParams();
              ((LayoutParams)localObject2).Gh.CX = 0;
              ((LayoutParams)localObject1).Gh.setWidth(((LayoutParams)localObject2).Gh.getWidth());
              ((LayoutParams)localObject1).Gh.setHeight(((LayoutParams)localObject2).Gh.getHeight());
              ((LayoutParams)localObject2).Gh.CX = 8;
            }
          }
          i += 1;
        }
        j = this.EH.size();
        if (j > 0)
        {
          i = 0;
          while (i < j)
          {
            this.EH.get(i);
            i += 1;
          }
        }
        if ((getChildCount() > 0) && (i5 != 0)) {
          androidx.constraintlayout.a.a.a.a(this.EJ);
        }
        if (this.EJ.DE)
        {
          if ((this.EJ.DF) && (i13 == -2147483648))
          {
            if (this.EJ.DH < i14) {
              this.EJ.setWidth(this.EJ.DH);
            }
            this.EJ.a(f.a.Do);
          }
          if ((this.EJ.DG) && (i15 == -2147483648))
          {
            if (this.EJ.DI < i16) {
              this.EJ.setHeight(this.EJ.DI);
            }
            this.EJ.b(f.a.Do);
          }
        }
        if ((this.DJ & 0x20) == 32)
        {
          i = this.EJ.getWidth();
          j = this.EJ.getHeight();
          if ((this.EP != i) && (i13 == 1073741824)) {
            androidx.constraintlayout.a.a.a.a(this.EJ.DD, 0, i);
          }
          if ((this.EQ != j) && (i15 == 1073741824)) {
            androidx.constraintlayout.a.a.a.a(this.EJ.DD, 1, j);
          }
          if ((this.EJ.DF) && (this.EJ.DH > i14)) {
            androidx.constraintlayout.a.a.a.a(this.EJ.DD, 0, i14);
          }
          if ((this.EJ.DG) && (this.EJ.DI > i16)) {
            androidx.constraintlayout.a.a.a.a(this.EJ.DD, 1, i16);
          }
        }
        if (getChildCount() > 0) {
          ga();
        }
        j = 0;
        i = 0;
        i6 = this.EI.size();
        i7 = i12 + getPaddingBottom();
        i8 = i11 + getPaddingRight();
        if (i6 > 0)
        {
          m = 0;
          if (this.EJ.fM() == f.a.Dp)
          {
            i1 = 1;
            if (this.EJ.fN() != f.a.Dp) {
              break label5268;
            }
            i2 = 1;
            j = Math.max(this.EJ.getWidth(), this.lj);
            k = Math.max(this.EJ.getHeight(), this.CO);
            i3 = 0;
          }
          for (;;)
          {
            if (i3 >= i6) {
              break label5566;
            }
            localObject1 = (androidx.constraintlayout.a.a.f)this.EI.get(i3);
            localObject2 = (View)((androidx.constraintlayout.a.a.f)localObject1).CV;
            if (localObject2 == null) {
              break label5970;
            }
            localObject3 = (LayoutParams)((View)localObject2).getLayoutParams();
            if ((((LayoutParams)localObject3).FV) || (((LayoutParams)localObject3).FU) || (((View)localObject2).getVisibility() == 8) || ((i4 != 0) && (((androidx.constraintlayout.a.a.f)localObject1).fA().fW()) && (((androidx.constraintlayout.a.a.f)localObject1).fB().fW()))) {
              break label5970;
            }
            if ((((LayoutParams)localObject3).width == -2) && (((LayoutParams)localObject3).FR))
            {
              n = getChildMeasureSpec(paramInt1, i8, ((LayoutParams)localObject3).width);
              if ((((LayoutParams)localObject3).height != -2) || (!((LayoutParams)localObject3).FS)) {
                break label5290;
              }
            }
            for (i5 = getChildMeasureSpec(paramInt2, i7, ((LayoutParams)localObject3).height);; i5 = View.MeasureSpec.makeMeasureSpec(((androidx.constraintlayout.a.a.f)localObject1).getHeight(), 1073741824))
            {
              ((View)localObject2).measure(n, i5);
              if (this.EV == null) {
                break label5306;
              }
              AppMethodBeat.o(194758);
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
              ((androidx.constraintlayout.a.a.f)localObject1).fA().be(n);
            }
            if ((i1 == 0) || (((androidx.constraintlayout.a.a.f)localObject1).fG() <= j)) {
              break label6002;
            }
            m = Math.max(j, ((androidx.constraintlayout.a.a.f)localObject1).fG() + ((androidx.constraintlayout.a.a.f)localObject1).a(e.c.BO).fv());
            j = 1;
            if (i5 == ((androidx.constraintlayout.a.a.f)localObject1).getHeight()) {
              break label5995;
            }
            ((androidx.constraintlayout.a.a.f)localObject1).setHeight(i5);
            if (i4 != 0) {
              ((androidx.constraintlayout.a.a.f)localObject1).fB().be(i5);
            }
            if ((i2 == 0) || (((androidx.constraintlayout.a.a.f)localObject1).fH() <= k)) {
              break label5988;
            }
            j = Math.max(k, ((androidx.constraintlayout.a.a.f)localObject1).fH() + ((androidx.constraintlayout.a.a.f)localObject1).a(e.c.BP).fv());
            n = 1;
            k = j;
            j = n;
            if (((LayoutParams)localObject3).FT)
            {
              i5 = ((View)localObject2).getBaseline();
              j = n;
              if (i5 != -1)
              {
                j = n;
                if (i5 != ((androidx.constraintlayout.a.a.f)localObject1).CN)
                {
                  ((androidx.constraintlayout.a.a.f)localObject1).CN = i5;
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
            this.EJ.setWidth(i9);
            this.EJ.setHeight(i10);
            if (i4 != 0) {
              this.EJ.fR();
            }
            ga();
            m = 0;
            if (this.EJ.getWidth() < j)
            {
              this.EJ.setWidth(j);
              m = 1;
            }
            if (this.EJ.getHeight() < k)
            {
              this.EJ.setHeight(k);
              m = 1;
            }
            if (m != 0) {
              ga();
            }
          }
          k = 0;
          for (;;)
          {
            j = i;
            if (k >= i6) {
              break;
            }
            localObject1 = (androidx.constraintlayout.a.a.f)this.EI.get(k);
            localObject2 = (View)((androidx.constraintlayout.a.a.f)localObject1).CV;
            if ((localObject2 != null) && ((((View)localObject2).getMeasuredWidth() != ((androidx.constraintlayout.a.a.f)localObject1).getWidth()) || (((View)localObject2).getMeasuredHeight() != ((androidx.constraintlayout.a.a.f)localObject1).getHeight())) && (((androidx.constraintlayout.a.a.f)localObject1).CX != 8))
            {
              ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(((androidx.constraintlayout.a.a.f)localObject1).getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(((androidx.constraintlayout.a.a.f)localObject1).getHeight(), 1073741824));
              if (this.EV != null)
              {
                AppMethodBeat.o(194758);
                throw null;
              }
            }
            k += 1;
          }
        }
        i = this.EJ.getWidth() + i8;
        k = this.EJ.getHeight() + i7;
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramInt1 = resolveSizeAndState(i, paramInt1, j);
          i = resolveSizeAndState(k, paramInt2, j << 16);
          paramInt2 = Math.min(this.uJ, paramInt1 & 0xFFFFFF);
          i = Math.min(this.EK, i & 0xFFFFFF);
          paramInt1 = paramInt2;
          if (this.EJ.DL) {
            paramInt1 = paramInt2 | 0x1000000;
          }
          paramInt2 = i;
          if (this.EJ.DM) {
            paramInt2 = i | 0x1000000;
          }
          setMeasuredDimension(paramInt1, paramInt2);
          this.EP = paramInt1;
          this.EQ = paramInt2;
          AppMethodBeat.o(194758);
          return;
        }
        setMeasuredDimension(i, k);
        this.EP = i;
        this.EQ = k;
        AppMethodBeat.o(194758);
        return;
      }
    }
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(194710);
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewAdded(paramView);
    }
    Object localObject = u(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof i)))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      ((LayoutParams)localObject).Gh = new i();
      ((LayoutParams)localObject).FU = true;
      ((i)((LayoutParams)localObject).Gh).setOrientation(((LayoutParams)localObject).FO);
    }
    if ((paramView instanceof ConstraintHelper))
    {
      localObject = (ConstraintHelper)paramView;
      ((ConstraintHelper)localObject).fY();
      ((LayoutParams)paramView.getLayoutParams()).FV = true;
      if (!this.EH.contains(localObject)) {
        this.EH.add(localObject);
      }
    }
    this.EG.put(paramView.getId(), paramView);
    this.EL = true;
    AppMethodBeat.o(194710);
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(194713);
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewRemoved(paramView);
    }
    this.EG.remove(paramView.getId());
    androidx.constraintlayout.a.a.f localf = u(paramView);
    this.EJ.f(localf);
    this.EH.remove(paramView);
    this.EI.remove(localf);
    this.EL = true;
    AppMethodBeat.o(194713);
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(194703);
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14) {
      onViewRemoved(paramView);
    }
    AppMethodBeat.o(194703);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(194788);
    super.requestLayout();
    this.EL = true;
    this.EP = -1;
    this.EQ = -1;
    this.ER = -1;
    this.ES = -1;
    this.ET = 0;
    this.EU = 0;
    AppMethodBeat.o(194788);
  }
  
  public void setConstraintSet(a parama)
  {
    this.EM = parama;
  }
  
  public void setId(int paramInt)
  {
    AppMethodBeat.i(194688);
    this.EG.remove(getId());
    super.setId(paramInt);
    this.EG.put(getId(), this);
    AppMethodBeat.o(194688);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(194725);
    if (paramInt == this.EK)
    {
      AppMethodBeat.o(194725);
      return;
    }
    this.EK = paramInt;
    requestLayout();
    AppMethodBeat.o(194725);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(194723);
    if (paramInt == this.uJ)
    {
      AppMethodBeat.o(194723);
      return;
    }
    this.uJ = paramInt;
    requestLayout();
    AppMethodBeat.o(194723);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(194718);
    if (paramInt == this.CO)
    {
      AppMethodBeat.o(194718);
      return;
    }
    this.CO = paramInt;
    requestLayout();
    AppMethodBeat.o(194718);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(194715);
    if (paramInt == this.lj)
    {
      AppMethodBeat.o(194715);
      return;
    }
    this.lj = paramInt;
    requestLayout();
    AppMethodBeat.o(194715);
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.EJ.DJ = paramInt;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final androidx.constraintlayout.a.a.f u(View paramView)
  {
    AppMethodBeat.i(194732);
    if (paramView == this)
    {
      paramView = this.EJ;
      AppMethodBeat.o(194732);
      return paramView;
    }
    if (paramView == null)
    {
      AppMethodBeat.o(194732);
      return null;
    }
    paramView = ((LayoutParams)paramView.getLayoutParams()).Gh;
    AppMethodBeat.o(194732);
    return paramView;
  }
  
  public final Object u(Object paramObject)
  {
    AppMethodBeat.i(194671);
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ((this.EO != null) && (this.EO.containsKey(paramObject)))
      {
        paramObject = this.EO.get(paramObject);
        AppMethodBeat.o(194671);
        return paramObject;
      }
    }
    AppMethodBeat.o(194671);
    return null;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int EW;
    public int EX;
    public float EY;
    public int EZ;
    public float FA;
    public float FB;
    public int FC;
    public int FD;
    public int FE;
    public int FF;
    public int FG;
    public int FH;
    public int FI;
    public int FJ;
    public float FK;
    public float FL;
    public int FM;
    public int FN;
    public int FO;
    public boolean FP;
    public boolean FQ;
    boolean FR;
    boolean FS;
    boolean FT;
    boolean FU;
    boolean FV;
    boolean FW;
    int FX;
    int FY;
    int FZ;
    public int Fa;
    public int Fb;
    public int Fc;
    public int Fd;
    public int Fe;
    public int Ff;
    public int Fg;
    public int Fh;
    public int Fi;
    public int Fj;
    public float Fk;
    public int Fl;
    public int Fm;
    public int Fn;
    public int Fo;
    public int Fp;
    public int Fq;
    public int Fr;
    public int Fs;
    public int Ft;
    public int Fu;
    public float Fv;
    public float Fw;
    public String Fx;
    float Fy;
    int Fz;
    int Ga;
    int Gb;
    int Gc;
    float Gd;
    int Ge;
    int Gf;
    float Gg;
    androidx.constraintlayout.a.a.f Gh;
    public boolean Gi;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      AppMethodBeat.i(194639);
      this.EW = -1;
      this.EX = -1;
      this.EY = -1.0F;
      this.EZ = -1;
      this.Fa = -1;
      this.Fb = -1;
      this.Fc = -1;
      this.Fd = -1;
      this.Fe = -1;
      this.Ff = -1;
      this.Fg = -1;
      this.Fh = -1;
      this.Fi = -1;
      this.Fj = 0;
      this.Fk = 0.0F;
      this.Fl = -1;
      this.Fm = -1;
      this.Fn = -1;
      this.Fo = -1;
      this.Fp = -1;
      this.Fq = -1;
      this.Fr = -1;
      this.Fs = -1;
      this.Ft = -1;
      this.Fu = -1;
      this.Fv = 0.5F;
      this.Fw = 0.5F;
      this.Fx = null;
      this.Fy = 0.0F;
      this.Fz = 1;
      this.FA = -1.0F;
      this.FB = -1.0F;
      this.FC = 0;
      this.FD = 0;
      this.FE = 0;
      this.FF = 0;
      this.FG = 0;
      this.FH = 0;
      this.FI = 0;
      this.FJ = 0;
      this.FK = 1.0F;
      this.FL = 1.0F;
      this.FM = -1;
      this.FN = -1;
      this.FO = -1;
      this.FP = false;
      this.FQ = false;
      this.FR = true;
      this.FS = true;
      this.FT = false;
      this.FU = false;
      this.FV = false;
      this.FW = false;
      this.FX = -1;
      this.FY = -1;
      this.FZ = -1;
      this.Ga = -1;
      this.Gb = -1;
      this.Gc = -1;
      this.Gd = 0.5F;
      this.Gh = new androidx.constraintlayout.a.a.f();
      this.Gi = false;
      AppMethodBeat.o(194639);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(194627);
      this.EW = -1;
      this.EX = -1;
      this.EY = -1.0F;
      this.EZ = -1;
      this.Fa = -1;
      this.Fb = -1;
      this.Fc = -1;
      this.Fd = -1;
      this.Fe = -1;
      this.Ff = -1;
      this.Fg = -1;
      this.Fh = -1;
      this.Fi = -1;
      this.Fj = 0;
      this.Fk = 0.0F;
      this.Fl = -1;
      this.Fm = -1;
      this.Fn = -1;
      this.Fo = -1;
      this.Fp = -1;
      this.Fq = -1;
      this.Fr = -1;
      this.Fs = -1;
      this.Ft = -1;
      this.Fu = -1;
      this.Fv = 0.5F;
      this.Fw = 0.5F;
      this.Fx = null;
      this.Fy = 0.0F;
      this.Fz = 1;
      this.FA = -1.0F;
      this.FB = -1.0F;
      this.FC = 0;
      this.FD = 0;
      this.FE = 0;
      this.FF = 0;
      this.FG = 0;
      this.FH = 0;
      this.FI = 0;
      this.FJ = 0;
      this.FK = 1.0F;
      this.FL = 1.0F;
      this.FM = -1;
      this.FN = -1;
      this.FO = -1;
      this.FP = false;
      this.FQ = false;
      this.FR = true;
      this.FS = true;
      this.FT = false;
      this.FU = false;
      this.FV = false;
      this.FW = false;
      this.FX = -1;
      this.FY = -1;
      this.FZ = -1;
      this.Ga = -1;
      this.Gb = -1;
      this.Gc = -1;
      this.Gd = 0.5F;
      this.Gh = new androidx.constraintlayout.a.a.f();
      this.Gi = false;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int k = paramContext.getIndexCount();
      int i = 0;
      if (i < k)
      {
        int j = paramContext.getIndex(i);
        switch (a.Gj.get(j))
        {
        }
        for (;;)
        {
          i += 1;
          break;
          this.EZ = paramContext.getResourceId(j, this.EZ);
          if (this.EZ == -1)
          {
            this.EZ = paramContext.getInt(j, -1);
            continue;
            this.Fa = paramContext.getResourceId(j, this.Fa);
            if (this.Fa == -1)
            {
              this.Fa = paramContext.getInt(j, -1);
              continue;
              this.Fb = paramContext.getResourceId(j, this.Fb);
              if (this.Fb == -1)
              {
                this.Fb = paramContext.getInt(j, -1);
                continue;
                this.Fc = paramContext.getResourceId(j, this.Fc);
                if (this.Fc == -1)
                {
                  this.Fc = paramContext.getInt(j, -1);
                  continue;
                  this.Fd = paramContext.getResourceId(j, this.Fd);
                  if (this.Fd == -1)
                  {
                    this.Fd = paramContext.getInt(j, -1);
                    continue;
                    this.Fe = paramContext.getResourceId(j, this.Fe);
                    if (this.Fe == -1)
                    {
                      this.Fe = paramContext.getInt(j, -1);
                      continue;
                      this.Ff = paramContext.getResourceId(j, this.Ff);
                      if (this.Ff == -1)
                      {
                        this.Ff = paramContext.getInt(j, -1);
                        continue;
                        this.Fg = paramContext.getResourceId(j, this.Fg);
                        if (this.Fg == -1)
                        {
                          this.Fg = paramContext.getInt(j, -1);
                          continue;
                          this.Fh = paramContext.getResourceId(j, this.Fh);
                          if (this.Fh == -1)
                          {
                            this.Fh = paramContext.getInt(j, -1);
                            continue;
                            this.Fi = paramContext.getResourceId(j, this.Fi);
                            if (this.Fi == -1)
                            {
                              this.Fi = paramContext.getInt(j, -1);
                              continue;
                              this.Fj = paramContext.getDimensionPixelSize(j, this.Fj);
                              continue;
                              this.Fk = (paramContext.getFloat(j, this.Fk) % 360.0F);
                              if (this.Fk < 0.0F)
                              {
                                this.Fk = ((360.0F - this.Fk) % 360.0F);
                                continue;
                                this.FM = paramContext.getDimensionPixelOffset(j, this.FM);
                                continue;
                                this.FN = paramContext.getDimensionPixelOffset(j, this.FN);
                                continue;
                                this.EW = paramContext.getDimensionPixelOffset(j, this.EW);
                                continue;
                                this.EX = paramContext.getDimensionPixelOffset(j, this.EX);
                                continue;
                                this.EY = paramContext.getFloat(j, this.EY);
                                continue;
                                this.FO = paramContext.getInt(j, this.FO);
                                continue;
                                this.Fl = paramContext.getResourceId(j, this.Fl);
                                if (this.Fl == -1)
                                {
                                  this.Fl = paramContext.getInt(j, -1);
                                  continue;
                                  this.Fm = paramContext.getResourceId(j, this.Fm);
                                  if (this.Fm == -1)
                                  {
                                    this.Fm = paramContext.getInt(j, -1);
                                    continue;
                                    this.Fn = paramContext.getResourceId(j, this.Fn);
                                    if (this.Fn == -1)
                                    {
                                      this.Fn = paramContext.getInt(j, -1);
                                      continue;
                                      this.Fo = paramContext.getResourceId(j, this.Fo);
                                      if (this.Fo == -1)
                                      {
                                        this.Fo = paramContext.getInt(j, -1);
                                        continue;
                                        this.Fp = paramContext.getDimensionPixelSize(j, this.Fp);
                                        continue;
                                        this.Fq = paramContext.getDimensionPixelSize(j, this.Fq);
                                        continue;
                                        this.Fr = paramContext.getDimensionPixelSize(j, this.Fr);
                                        continue;
                                        this.Fs = paramContext.getDimensionPixelSize(j, this.Fs);
                                        continue;
                                        this.Ft = paramContext.getDimensionPixelSize(j, this.Ft);
                                        continue;
                                        this.Fu = paramContext.getDimensionPixelSize(j, this.Fu);
                                        continue;
                                        this.Fv = paramContext.getFloat(j, this.Fv);
                                        continue;
                                        this.Fw = paramContext.getFloat(j, this.Fw);
                                        continue;
                                        this.Fx = paramContext.getString(j);
                                        this.Fy = (0.0F / 0.0F);
                                        this.Fz = -1;
                                        if (this.Fx != null)
                                        {
                                          int m = this.Fx.length();
                                          j = this.Fx.indexOf(',');
                                          if ((j > 0) && (j < m - 1))
                                          {
                                            paramAttributeSet = this.Fx.substring(0, j);
                                            if (paramAttributeSet.equalsIgnoreCase("W"))
                                            {
                                              this.Fz = 0;
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
                                              int n = this.Fx.indexOf(':');
                                              if ((n < 0) || (n >= m - 1)) {
                                                break label1657;
                                              }
                                              paramAttributeSet = this.Fx.substring(j, n);
                                              String str = this.Fx.substring(n + 1);
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
                                                if (this.Fz != 1) {
                                                  break label1641;
                                                }
                                                this.Fy = Math.abs(f2 / f1);
                                              }
                                              catch (NumberFormatException paramAttributeSet) {}
                                            }
                                            break;
                                            if (!paramAttributeSet.equalsIgnoreCase("H")) {
                                              break label1495;
                                            }
                                            this.Fz = 1;
                                            break label1495;
                                            j = 0;
                                          }
                                          label1641:
                                          f1 /= f2;
                                          this.Fy = Math.abs(f1);
                                          continue;
                                          label1657:
                                          paramAttributeSet = this.Fx.substring(j);
                                          if (paramAttributeSet.length() > 0)
                                          {
                                            try
                                            {
                                              this.Fy = Float.parseFloat(paramAttributeSet);
                                            }
                                            catch (NumberFormatException paramAttributeSet) {}
                                            continue;
                                            this.FA = paramContext.getFloat(j, this.FA);
                                            continue;
                                            this.FB = paramContext.getFloat(j, this.FB);
                                            continue;
                                            this.FC = paramContext.getInt(j, 0);
                                            continue;
                                            this.FD = paramContext.getInt(j, 0);
                                            continue;
                                            this.FP = paramContext.getBoolean(j, this.FP);
                                            continue;
                                            this.FQ = paramContext.getBoolean(j, this.FQ);
                                            continue;
                                            this.FE = paramContext.getInt(j, 0);
                                            if (this.FE == 1)
                                            {
                                              continue;
                                              this.FF = paramContext.getInt(j, 0);
                                              if (this.FF == 1)
                                              {
                                                continue;
                                                try
                                                {
                                                  this.FG = paramContext.getDimensionPixelSize(j, this.FG);
                                                }
                                                catch (Exception paramAttributeSet) {}
                                                if (paramContext.getInt(j, this.FG) == -2)
                                                {
                                                  this.FG = -2;
                                                  continue;
                                                  try
                                                  {
                                                    this.FI = paramContext.getDimensionPixelSize(j, this.FI);
                                                  }
                                                  catch (Exception paramAttributeSet) {}
                                                  if (paramContext.getInt(j, this.FI) == -2)
                                                  {
                                                    this.FI = -2;
                                                    continue;
                                                    this.FK = Math.max(0.0F, paramContext.getFloat(j, this.FK));
                                                    continue;
                                                    try
                                                    {
                                                      this.FH = paramContext.getDimensionPixelSize(j, this.FH);
                                                    }
                                                    catch (Exception paramAttributeSet) {}
                                                    if (paramContext.getInt(j, this.FH) == -2)
                                                    {
                                                      this.FH = -2;
                                                      continue;
                                                      try
                                                      {
                                                        this.FJ = paramContext.getDimensionPixelSize(j, this.FJ);
                                                      }
                                                      catch (Exception paramAttributeSet) {}
                                                      if (paramContext.getInt(j, this.FJ) == -2)
                                                      {
                                                        this.FJ = -2;
                                                        continue;
                                                        this.FL = Math.max(0.0F, paramContext.getFloat(j, this.FL));
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
      validate();
      AppMethodBeat.o(194627);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      AppMethodBeat.i(194646);
      this.EW = -1;
      this.EX = -1;
      this.EY = -1.0F;
      this.EZ = -1;
      this.Fa = -1;
      this.Fb = -1;
      this.Fc = -1;
      this.Fd = -1;
      this.Fe = -1;
      this.Ff = -1;
      this.Fg = -1;
      this.Fh = -1;
      this.Fi = -1;
      this.Fj = 0;
      this.Fk = 0.0F;
      this.Fl = -1;
      this.Fm = -1;
      this.Fn = -1;
      this.Fo = -1;
      this.Fp = -1;
      this.Fq = -1;
      this.Fr = -1;
      this.Fs = -1;
      this.Ft = -1;
      this.Fu = -1;
      this.Fv = 0.5F;
      this.Fw = 0.5F;
      this.Fx = null;
      this.Fy = 0.0F;
      this.Fz = 1;
      this.FA = -1.0F;
      this.FB = -1.0F;
      this.FC = 0;
      this.FD = 0;
      this.FE = 0;
      this.FF = 0;
      this.FG = 0;
      this.FH = 0;
      this.FI = 0;
      this.FJ = 0;
      this.FK = 1.0F;
      this.FL = 1.0F;
      this.FM = -1;
      this.FN = -1;
      this.FO = -1;
      this.FP = false;
      this.FQ = false;
      this.FR = true;
      this.FS = true;
      this.FT = false;
      this.FU = false;
      this.FV = false;
      this.FW = false;
      this.FX = -1;
      this.FY = -1;
      this.FZ = -1;
      this.Ga = -1;
      this.Gb = -1;
      this.Gc = -1;
      this.Gd = 0.5F;
      this.Gh = new androidx.constraintlayout.a.a.f();
      this.Gi = false;
      AppMethodBeat.o(194646);
    }
    
    @TargetApi(17)
    public void resolveLayoutDirection(int paramInt)
    {
      AppMethodBeat.i(194658);
      int i = this.leftMargin;
      int j = this.rightMargin;
      super.resolveLayoutDirection(paramInt);
      this.FZ = -1;
      this.Ga = -1;
      this.FX = -1;
      this.FY = -1;
      this.Gb = -1;
      this.Gc = -1;
      this.Gb = this.Fp;
      this.Gc = this.Fr;
      this.Gd = this.Fv;
      this.Ge = this.EW;
      this.Gf = this.EX;
      this.Gg = this.EY;
      if (1 == getLayoutDirection())
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label449;
        }
        paramInt = 0;
        if (this.Fl == -1) {
          break label368;
        }
        this.FZ = this.Fl;
        paramInt = 1;
        label133:
        if (this.Fn != -1)
        {
          this.FY = this.Fn;
          paramInt = 1;
        }
        if (this.Fo != -1)
        {
          this.FX = this.Fo;
          paramInt = 1;
        }
        if (this.Ft != -1) {
          this.Gc = this.Ft;
        }
        if (this.Fu != -1) {
          this.Gb = this.Fu;
        }
        if (paramInt != 0) {
          this.Gd = (1.0F - this.Fv);
        }
        if ((this.FU) && (this.FO == 1))
        {
          if (this.EY == -1.0F) {
            break label389;
          }
          this.Gg = (1.0F - this.EY);
          this.Ge = -1;
          this.Gf = -1;
        }
        label260:
        if ((this.Fn != -1) || (this.Fo != -1) || (this.Fm != -1) || (this.Fl != -1)) {
          break label615;
        }
        if (this.Fb == -1) {
          break label548;
        }
        this.FZ = this.Fb;
        if ((this.rightMargin <= 0) && (j > 0)) {
          this.rightMargin = j;
        }
      }
      for (;;)
      {
        if (this.EZ == -1) {
          break label583;
        }
        this.FX = this.EZ;
        if ((this.leftMargin > 0) || (i <= 0)) {
          break label615;
        }
        this.leftMargin = i;
        AppMethodBeat.o(194658);
        return;
        paramInt = 0;
        break;
        label368:
        if (this.Fm == -1) {
          break label133;
        }
        this.Ga = this.Fm;
        paramInt = 1;
        break label133;
        label389:
        if (this.EW != -1)
        {
          this.Gf = this.EW;
          this.Ge = -1;
          this.Gg = -1.0F;
          break label260;
        }
        if (this.EX == -1) {
          break label260;
        }
        this.Ge = this.EX;
        this.Gf = -1;
        this.Gg = -1.0F;
        break label260;
        label449:
        if (this.Fl != -1) {
          this.FY = this.Fl;
        }
        if (this.Fm != -1) {
          this.FX = this.Fm;
        }
        if (this.Fn != -1) {
          this.FZ = this.Fn;
        }
        if (this.Fo != -1) {
          this.Ga = this.Fo;
        }
        if (this.Ft != -1) {
          this.Gb = this.Ft;
        }
        if (this.Fu == -1) {
          break label260;
        }
        this.Gc = this.Fu;
        break label260;
        label548:
        if (this.Fc != -1)
        {
          this.Ga = this.Fc;
          if ((this.rightMargin <= 0) && (j > 0)) {
            this.rightMargin = j;
          }
        }
      }
      label583:
      if (this.Fa != -1)
      {
        this.FY = this.Fa;
        if ((this.leftMargin <= 0) && (i > 0)) {
          this.leftMargin = i;
        }
      }
      label615:
      AppMethodBeat.o(194658);
    }
    
    public final void validate()
    {
      AppMethodBeat.i(194631);
      this.FU = false;
      this.FR = true;
      this.FS = true;
      if ((this.width == -2) && (this.FP))
      {
        this.FR = false;
        this.FE = 1;
      }
      if ((this.height == -2) && (this.FQ))
      {
        this.FS = false;
        this.FF = 1;
      }
      if ((this.width == 0) || (this.width == -1))
      {
        this.FR = false;
        if ((this.width == 0) && (this.FE == 1))
        {
          this.width = -2;
          this.FP = true;
        }
      }
      if ((this.height == 0) || (this.height == -1))
      {
        this.FS = false;
        if ((this.height == 0) && (this.FF == 1))
        {
          this.height = -2;
          this.FQ = true;
        }
      }
      if ((this.EY != -1.0F) || (this.EW != -1) || (this.EX != -1))
      {
        this.FU = true;
        this.FR = true;
        this.FS = true;
        if (!(this.Gh instanceof i)) {
          this.Gh = new i();
        }
        ((i)this.Gh).setOrientation(this.FO);
      }
      AppMethodBeat.o(194631);
    }
    
    static final class a
    {
      public static final SparseIntArray Gj;
      
      static
      {
        AppMethodBeat.i(194598);
        SparseIntArray localSparseIntArray = new SparseIntArray();
        Gj = localSparseIntArray;
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
        Gj.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
        Gj.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
        AppMethodBeat.o(194598);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintLayout
 * JD-Core Version:    0.7.0.1
 */