package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class a
{
  private static final int[] Gk;
  private static SparseIntArray Gm;
  HashMap<Integer, a> Gl;
  
  static
  {
    AppMethodBeat.i(194906);
    Gk = new int[] { 0, 4, 8 };
    SparseIntArray localSparseIntArray = new SparseIntArray();
    Gm = localSparseIntArray;
    localSparseIntArray.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    Gm.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    Gm.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    Gm.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
    Gm.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
    Gm.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    Gm.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    Gm.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    Gm.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    Gm.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
    Gm.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
    Gm.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
    Gm.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
    Gm.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
    Gm.append(R.styleable.ConstraintSet_android_orientation, 27);
    Gm.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
    Gm.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
    Gm.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    Gm.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    Gm.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
    Gm.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
    Gm.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
    Gm.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
    Gm.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
    Gm.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
    Gm.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
    Gm.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
    Gm.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    Gm.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    Gm.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
    Gm.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
    Gm.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
    Gm.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 75);
    Gm.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 75);
    Gm.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 75);
    Gm.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 75);
    Gm.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 75);
    Gm.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
    Gm.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
    Gm.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
    Gm.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
    Gm.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
    Gm.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
    Gm.append(R.styleable.ConstraintSet_android_layout_width, 23);
    Gm.append(R.styleable.ConstraintSet_android_layout_height, 21);
    Gm.append(R.styleable.ConstraintSet_android_visibility, 22);
    Gm.append(R.styleable.ConstraintSet_android_alpha, 43);
    Gm.append(R.styleable.ConstraintSet_android_elevation, 44);
    Gm.append(R.styleable.ConstraintSet_android_rotationX, 45);
    Gm.append(R.styleable.ConstraintSet_android_rotationY, 46);
    Gm.append(R.styleable.ConstraintSet_android_rotation, 60);
    Gm.append(R.styleable.ConstraintSet_android_scaleX, 47);
    Gm.append(R.styleable.ConstraintSet_android_scaleY, 48);
    Gm.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
    Gm.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
    Gm.append(R.styleable.ConstraintSet_android_translationX, 51);
    Gm.append(R.styleable.ConstraintSet_android_translationY, 52);
    Gm.append(R.styleable.ConstraintSet_android_translationZ, 53);
    Gm.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
    Gm.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
    Gm.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
    Gm.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
    Gm.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
    Gm.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
    Gm.append(R.styleable.ConstraintSet_layout_constraintCircle, 61);
    Gm.append(R.styleable.ConstraintSet_layout_constraintCircleRadius, 62);
    Gm.append(R.styleable.ConstraintSet_layout_constraintCircleAngle, 63);
    Gm.append(R.styleable.ConstraintSet_android_id, 38);
    Gm.append(R.styleable.ConstraintSet_layout_constraintWidth_percent, 69);
    Gm.append(R.styleable.ConstraintSet_layout_constraintHeight_percent, 70);
    Gm.append(R.styleable.ConstraintSet_chainUseRtl, 71);
    Gm.append(R.styleable.ConstraintSet_barrierDirection, 72);
    Gm.append(R.styleable.ConstraintSet_constraint_referenced_ids, 73);
    Gm.append(R.styleable.ConstraintSet_barrierAllowsGoneWidgets, 74);
    AppMethodBeat.o(194906);
  }
  
  public a()
  {
    AppMethodBeat.i(194832);
    this.Gl = new HashMap();
    AppMethodBeat.o(194832);
  }
  
  private static int a(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194865);
    int i = paramTypedArray.getResourceId(paramInt1, paramInt2);
    paramInt2 = i;
    if (i == -1) {
      paramInt2 = paramTypedArray.getInt(paramInt1, -1);
    }
    AppMethodBeat.o(194865);
    return paramInt2;
  }
  
  static void a(a parama, TypedArray paramTypedArray)
  {
    AppMethodBeat.i(194883);
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    if (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      switch (Gm.get(k))
      {
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
      case 68: 
      default: 
        new StringBuilder("Unknown attribute 0x").append(Integer.toHexString(k)).append("   ").append(Gm.get(k));
      }
      for (;;)
      {
        i += 1;
        break;
        parama.EZ = a(paramTypedArray, k, parama.EZ);
        continue;
        parama.Fa = a(paramTypedArray, k, parama.Fa);
        continue;
        parama.Fb = a(paramTypedArray, k, parama.Fb);
        continue;
        parama.Fc = a(paramTypedArray, k, parama.Fc);
        continue;
        parama.Fd = a(paramTypedArray, k, parama.Fd);
        continue;
        parama.Fe = a(paramTypedArray, k, parama.Fe);
        continue;
        parama.Ff = a(paramTypedArray, k, parama.Ff);
        continue;
        parama.Fg = a(paramTypedArray, k, parama.Fg);
        continue;
        parama.Fh = a(paramTypedArray, k, parama.Fh);
        continue;
        parama.FM = paramTypedArray.getDimensionPixelOffset(k, parama.FM);
        continue;
        parama.FN = paramTypedArray.getDimensionPixelOffset(k, parama.FN);
        continue;
        parama.EW = paramTypedArray.getDimensionPixelOffset(k, parama.EW);
        continue;
        parama.EX = paramTypedArray.getDimensionPixelOffset(k, parama.EX);
        continue;
        parama.EY = paramTypedArray.getFloat(k, parama.EY);
        continue;
        parama.FO = paramTypedArray.getInt(k, parama.FO);
        continue;
        parama.Fl = a(paramTypedArray, k, parama.Fl);
        continue;
        parama.Fm = a(paramTypedArray, k, parama.Fm);
        continue;
        parama.Fn = a(paramTypedArray, k, parama.Fn);
        continue;
        parama.Fo = a(paramTypedArray, k, parama.Fo);
        continue;
        parama.Fi = a(paramTypedArray, k, parama.Fi);
        continue;
        parama.Fj = paramTypedArray.getDimensionPixelSize(k, parama.Fj);
        continue;
        parama.Fk = paramTypedArray.getFloat(k, parama.Fk);
        continue;
        parama.Fp = paramTypedArray.getDimensionPixelSize(k, parama.Fp);
        continue;
        parama.Fq = paramTypedArray.getDimensionPixelSize(k, parama.Fq);
        continue;
        parama.Fr = paramTypedArray.getDimensionPixelSize(k, parama.Fr);
        continue;
        parama.Fs = paramTypedArray.getDimensionPixelSize(k, parama.Fs);
        continue;
        parama.Ft = paramTypedArray.getDimensionPixelSize(k, parama.Ft);
        continue;
        parama.Fu = paramTypedArray.getDimensionPixelSize(k, parama.Fu);
        continue;
        parama.Fv = paramTypedArray.getFloat(k, parama.Fv);
        continue;
        parama.Fw = paramTypedArray.getFloat(k, parama.Fw);
        continue;
        parama.Gp = paramTypedArray.getDimensionPixelSize(k, parama.Gp);
        continue;
        parama.Gq = paramTypedArray.getDimensionPixelSize(k, parama.Gq);
        continue;
        parama.Gu = paramTypedArray.getDimensionPixelSize(k, parama.Gu);
        continue;
        parama.Gt = paramTypedArray.getDimensionPixelSize(k, parama.Gt);
        continue;
        parama.Gr = paramTypedArray.getDimensionPixelSize(k, parama.Gr);
        continue;
        parama.Gs = paramTypedArray.getDimensionPixelSize(k, parama.Gs);
        continue;
        parama.mWidth = paramTypedArray.getLayoutDimension(k, parama.mWidth);
        continue;
        parama.mHeight = paramTypedArray.getLayoutDimension(k, parama.mHeight);
        continue;
        parama.visibility = paramTypedArray.getInt(k, parama.visibility);
        parama.visibility = Gk[parama.visibility];
        continue;
        parama.alpha = paramTypedArray.getFloat(k, parama.alpha);
        continue;
        parama.Gv = true;
        parama.Gw = paramTypedArray.getDimension(k, parama.Gw);
        continue;
        parama.rotation = paramTypedArray.getFloat(k, parama.rotation);
        continue;
        parama.Gx = paramTypedArray.getFloat(k, parama.Gx);
        continue;
        parama.Gy = paramTypedArray.getFloat(k, parama.Gy);
        continue;
        parama.scaleX = paramTypedArray.getFloat(k, parama.scaleX);
        continue;
        parama.scaleY = paramTypedArray.getFloat(k, parama.scaleY);
        continue;
        parama.Gz = paramTypedArray.getFloat(k, parama.Gz);
        continue;
        parama.GA = paramTypedArray.getFloat(k, parama.GA);
        continue;
        parama.GB = paramTypedArray.getDimension(k, parama.GB);
        continue;
        parama.GC = paramTypedArray.getDimension(k, parama.GC);
        continue;
        parama.GD = paramTypedArray.getDimension(k, parama.GD);
        continue;
        parama.FB = paramTypedArray.getFloat(k, parama.FB);
        continue;
        parama.FA = paramTypedArray.getFloat(k, parama.FA);
        continue;
        parama.FD = paramTypedArray.getInt(k, parama.FD);
        continue;
        parama.FC = paramTypedArray.getInt(k, parama.FC);
        continue;
        parama.Go = paramTypedArray.getResourceId(k, parama.Go);
        continue;
        parama.Fx = paramTypedArray.getString(k);
        continue;
        parama.widthPercent = paramTypedArray.getFloat(k, 1.0F);
        continue;
        parama.heightPercent = paramTypedArray.getFloat(k, 1.0F);
        continue;
        parama.GL = paramTypedArray.getInt(k, parama.GL);
        continue;
        parama.GO = paramTypedArray.getString(k);
        continue;
        parama.GK = paramTypedArray.getBoolean(k, parama.GK);
        continue;
        new StringBuilder("unused attribute 0x").append(Integer.toHexString(k)).append("   ").append(Gm.get(k));
      }
    }
    AppMethodBeat.o(194883);
  }
  
  private static int[] a(View paramView, String paramString)
  {
    AppMethodBeat.i(194884);
    String[] arrayOfString = paramString.split(",");
    Context localContext = paramView.getContext();
    paramString = new int[arrayOfString.length];
    int m = 0;
    int k = 0;
    Object localObject;
    if (m < arrayOfString.length) {
      localObject = arrayOfString[m].trim();
    }
    for (;;)
    {
      int j;
      try
      {
        i = R.id.class.getField((String)localObject).getInt(null);
        j = i;
        if (i == 0) {
          j = localContext.getResources().getIdentifier((String)localObject, "id", localContext.getPackageName());
        }
        if ((j != 0) || (!paramView.isInEditMode()) || (!(paramView.getParent() instanceof ConstraintLayout))) {
          break label201;
        }
        localObject = ((ConstraintLayout)paramView.getParent()).u(localObject);
        if ((localObject == null) || (!(localObject instanceof Integer))) {
          break label201;
        }
        i = ((Integer)localObject).intValue();
        paramString[k] = i;
        m += 1;
        k += 1;
      }
      catch (Exception localException)
      {
        i = 0;
        continue;
      }
      if (k != arrayOfString.length) {}
      for (paramView = Arrays.copyOf(paramString, k);; paramView = paramString)
      {
        AppMethodBeat.o(194884);
        return paramView;
      }
      label201:
      int i = j;
    }
  }
  
  private static String bh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "undefined";
    case 1: 
      return "left";
    case 2: 
      return "right";
    case 3: 
      return "top";
    case 4: 
      return "bottom";
    case 5: 
      return "baseline";
    case 6: 
      return "start";
    }
    return "end";
  }
  
  public final void b(ConstraintLayout paramConstraintLayout)
  {
    AppMethodBeat.i(194840);
    int j = paramConstraintLayout.getChildCount();
    this.Gl.clear();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramConstraintLayout.getChildAt(i);
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)((View)localObject).getLayoutParams();
      int k = ((View)localObject).getId();
      if (k == -1)
      {
        paramConstraintLayout = new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        AppMethodBeat.o(194840);
        throw paramConstraintLayout;
      }
      if (!this.Gl.containsKey(Integer.valueOf(k))) {
        this.Gl.put(Integer.valueOf(k), new a((byte)0));
      }
      a locala = (a)this.Gl.get(Integer.valueOf(k));
      locala.a(k, localLayoutParams);
      locala.visibility = ((View)localObject).getVisibility();
      if (Build.VERSION.SDK_INT >= 17)
      {
        locala.alpha = ((View)localObject).getAlpha();
        locala.rotation = ((View)localObject).getRotation();
        locala.Gx = ((View)localObject).getRotationX();
        locala.Gy = ((View)localObject).getRotationY();
        locala.scaleX = ((View)localObject).getScaleX();
        locala.scaleY = ((View)localObject).getScaleY();
        float f1 = ((View)localObject).getPivotX();
        float f2 = ((View)localObject).getPivotY();
        if ((f1 != 0.0D) || (f2 != 0.0D))
        {
          locala.Gz = f1;
          locala.GA = f2;
        }
        locala.GB = ((View)localObject).getTranslationX();
        locala.GC = ((View)localObject).getTranslationY();
        if (Build.VERSION.SDK_INT >= 21)
        {
          locala.GD = ((View)localObject).getTranslationZ();
          if (locala.Gv) {
            locala.Gw = ((View)localObject).getElevation();
          }
        }
      }
      if ((localObject instanceof Barrier))
      {
        localObject = (Barrier)localObject;
        locala.GK = ((Barrier)localObject).Ez.Bc;
        locala.GN = ((Barrier)localObject).getReferencedIds();
        locala.GL = ((Barrier)localObject).getType();
      }
      i += 1;
    }
    AppMethodBeat.o(194840);
  }
  
  public final void c(ConstraintLayout paramConstraintLayout)
  {
    AppMethodBeat.i(194842);
    d(paramConstraintLayout);
    paramConstraintLayout.setConstraintSet(null);
    AppMethodBeat.o(194842);
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(194863);
    if (!this.Gl.containsKey(Integer.valueOf(paramInt1))) {
      this.Gl.put(Integer.valueOf(paramInt1), new a((byte)0));
    }
    Object localObject = (a)this.Gl.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      localObject = new IllegalArgumentException(bh(paramInt2) + " to " + bh(paramInt4) + " unknown");
      AppMethodBeat.o(194863);
      throw ((Throwable)localObject);
    case 1: 
      if (paramInt4 == 1)
      {
        ((a)localObject).EZ = paramInt3;
        ((a)localObject).Fa = -1;
      }
      for (;;)
      {
        ((a)localObject).Gp = 0;
        AppMethodBeat.o(194863);
        return;
        if (paramInt4 != 2) {
          break;
        }
        ((a)localObject).Fa = paramInt3;
        ((a)localObject).EZ = -1;
      }
      localObject = new IllegalArgumentException("Left to " + bh(paramInt4) + " undefined");
      AppMethodBeat.o(194863);
      throw ((Throwable)localObject);
    case 2: 
      if (paramInt4 == 1)
      {
        ((a)localObject).Fb = paramInt3;
        ((a)localObject).Fc = -1;
      }
      for (;;)
      {
        ((a)localObject).Gq = 0;
        AppMethodBeat.o(194863);
        return;
        if (paramInt4 != 2) {
          break;
        }
        ((a)localObject).Fc = paramInt3;
        ((a)localObject).Fb = -1;
      }
      localObject = new IllegalArgumentException("right to " + bh(paramInt4) + " undefined");
      AppMethodBeat.o(194863);
      throw ((Throwable)localObject);
    case 3: 
      if (paramInt4 == 3)
      {
        ((a)localObject).Fd = paramInt3;
        ((a)localObject).Fe = -1;
      }
      for (((a)localObject).Fh = -1;; ((a)localObject).Fh = -1)
      {
        ((a)localObject).Gr = 0;
        AppMethodBeat.o(194863);
        return;
        if (paramInt4 != 4) {
          break;
        }
        ((a)localObject).Fe = paramInt3;
        ((a)localObject).Fd = -1;
      }
      localObject = new IllegalArgumentException("right to " + bh(paramInt4) + " undefined");
      AppMethodBeat.o(194863);
      throw ((Throwable)localObject);
    case 4: 
      if (paramInt4 == 4)
      {
        ((a)localObject).Fg = paramInt3;
        ((a)localObject).Ff = -1;
      }
      for (((a)localObject).Fh = -1;; ((a)localObject).Fh = -1)
      {
        ((a)localObject).Gs = 0;
        AppMethodBeat.o(194863);
        return;
        if (paramInt4 != 3) {
          break;
        }
        ((a)localObject).Ff = paramInt3;
        ((a)localObject).Fg = -1;
      }
      localObject = new IllegalArgumentException("right to " + bh(paramInt4) + " undefined");
      AppMethodBeat.o(194863);
      throw ((Throwable)localObject);
    case 5: 
      if (paramInt4 == 5)
      {
        ((a)localObject).Fh = paramInt3;
        ((a)localObject).Fg = -1;
        ((a)localObject).Ff = -1;
        ((a)localObject).Fd = -1;
        ((a)localObject).Fe = -1;
        AppMethodBeat.o(194863);
        return;
      }
      localObject = new IllegalArgumentException("right to " + bh(paramInt4) + " undefined");
      AppMethodBeat.o(194863);
      throw ((Throwable)localObject);
    case 6: 
      if (paramInt4 == 6)
      {
        ((a)localObject).Fm = paramInt3;
        ((a)localObject).Fl = -1;
      }
      for (;;)
      {
        ((a)localObject).Gu = 0;
        AppMethodBeat.o(194863);
        return;
        if (paramInt4 != 7) {
          break;
        }
        ((a)localObject).Fl = paramInt3;
        ((a)localObject).Fm = -1;
      }
      localObject = new IllegalArgumentException("right to " + bh(paramInt4) + " undefined");
      AppMethodBeat.o(194863);
      throw ((Throwable)localObject);
    }
    if (paramInt4 == 7)
    {
      ((a)localObject).Fo = paramInt3;
      ((a)localObject).Fn = -1;
    }
    for (;;)
    {
      ((a)localObject).Gt = 0;
      AppMethodBeat.o(194863);
      return;
      if (paramInt4 != 6) {
        break;
      }
      ((a)localObject).Fn = paramInt3;
      ((a)localObject).Fo = -1;
    }
    localObject = new IllegalArgumentException("right to " + bh(paramInt4) + " undefined");
    AppMethodBeat.o(194863);
    throw ((Throwable)localObject);
  }
  
  final void d(ConstraintLayout paramConstraintLayout)
  {
    AppMethodBeat.i(194851);
    int j = paramConstraintLayout.getChildCount();
    Object localObject1 = new HashSet(this.Gl.keySet());
    int i = 0;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (i < j)
    {
      localObject2 = paramConstraintLayout.getChildAt(i);
      int k = ((View)localObject2).getId();
      if (k == -1)
      {
        paramConstraintLayout = new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        AppMethodBeat.o(194851);
        throw paramConstraintLayout;
      }
      if (this.Gl.containsKey(Integer.valueOf(k)))
      {
        ((HashSet)localObject1).remove(Integer.valueOf(k));
        localObject3 = (a)this.Gl.get(Integer.valueOf(k));
        if ((localObject2 instanceof Barrier)) {
          ((a)localObject3).GM = 1;
        }
        if (((a)localObject3).GM != -1) {
          switch (((a)localObject3).GM)
          {
          }
        }
      }
      for (;;)
      {
        localObject4 = (ConstraintLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((a)localObject3).a((ConstraintLayout.LayoutParams)localObject4);
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((View)localObject2).setVisibility(((a)localObject3).visibility);
        if (Build.VERSION.SDK_INT >= 17)
        {
          ((View)localObject2).setAlpha(((a)localObject3).alpha);
          ((View)localObject2).setRotation(((a)localObject3).rotation);
          ((View)localObject2).setRotationX(((a)localObject3).Gx);
          ((View)localObject2).setRotationY(((a)localObject3).Gy);
          ((View)localObject2).setScaleX(((a)localObject3).scaleX);
          ((View)localObject2).setScaleY(((a)localObject3).scaleY);
          if (!Float.isNaN(((a)localObject3).Gz)) {
            ((View)localObject2).setPivotX(((a)localObject3).Gz);
          }
          if (!Float.isNaN(((a)localObject3).GA)) {
            ((View)localObject2).setPivotY(((a)localObject3).GA);
          }
          ((View)localObject2).setTranslationX(((a)localObject3).GB);
          ((View)localObject2).setTranslationY(((a)localObject3).GC);
          if (Build.VERSION.SDK_INT >= 21)
          {
            ((View)localObject2).setTranslationZ(((a)localObject3).GD);
            if (((a)localObject3).Gv) {
              ((View)localObject2).setElevation(((a)localObject3).Gw);
            }
          }
        }
        i += 1;
        break;
        localObject4 = (Barrier)localObject2;
        ((Barrier)localObject4).setId(k);
        ((Barrier)localObject4).setType(((a)localObject3).GL);
        ((Barrier)localObject4).setAllowsGoneWidget(((a)localObject3).GK);
        if (((a)localObject3).GN != null)
        {
          ((Barrier)localObject4).setReferencedIds(((a)localObject3).GN);
        }
        else if (((a)localObject3).GO != null)
        {
          ((a)localObject3).GN = a((View)localObject4, ((a)localObject3).GO);
          ((Barrier)localObject4).setReferencedIds(((a)localObject3).GN);
        }
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject1).next();
      localObject2 = (a)this.Gl.get(localObject3);
      if (((a)localObject2).GM != -1) {}
      switch (((a)localObject2).GM)
      {
      default: 
        if (((a)localObject2).Gn)
        {
          localObject4 = new Guideline(paramConstraintLayout.getContext());
          ((Guideline)localObject4).setId(((Integer)localObject3).intValue());
          localObject3 = ConstraintLayout.gb();
          ((a)localObject2).a((ConstraintLayout.LayoutParams)localObject3);
          paramConstraintLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
        }
        break;
      case 1: 
        label536:
        localObject4 = new Barrier(paramConstraintLayout.getContext());
        ((Barrier)localObject4).setId(((Integer)localObject3).intValue());
        if (((a)localObject2).GN != null) {
          ((Barrier)localObject4).setReferencedIds(((a)localObject2).GN);
        }
        for (;;)
        {
          ((Barrier)localObject4).setType(((a)localObject2).GL);
          ConstraintLayout.LayoutParams localLayoutParams = ConstraintLayout.gb();
          ((Barrier)localObject4).fY();
          ((a)localObject2).a(localLayoutParams);
          paramConstraintLayout.addView((View)localObject4, localLayoutParams);
          break label536;
          break;
          if (((a)localObject2).GO != null)
          {
            ((a)localObject2).GN = a((View)localObject4, ((a)localObject2).GO);
            ((Barrier)localObject4).setReferencedIds(((a)localObject2).GN);
          }
        }
      }
    }
    AppMethodBeat.o(194851);
  }
  
  static final class a
  {
    public int EW = -1;
    public int EX = -1;
    public float EY = -1.0F;
    public int EZ = -1;
    public float FA = 0.0F;
    public float FB = 0.0F;
    public int FC = 0;
    public int FD = 0;
    public int FM = -1;
    public int FN = -1;
    public int FO = -1;
    public boolean FP = false;
    public boolean FQ = false;
    public int Fa = -1;
    public int Fb = -1;
    public int Fc = -1;
    public int Fd = -1;
    public int Fe = -1;
    public int Ff = -1;
    public int Fg = -1;
    public int Fh = -1;
    public int Fi = -1;
    public int Fj = 0;
    public float Fk = 0.0F;
    public int Fl = -1;
    public int Fm = -1;
    public int Fn = -1;
    public int Fo = -1;
    public int Fp = -1;
    public int Fq = -1;
    public int Fr = -1;
    public int Fs = -1;
    public int Ft = -1;
    public int Fu = -1;
    public float Fv = 0.5F;
    public float Fw = 0.5F;
    public String Fx = null;
    public float GA = (0.0F / 0.0F);
    public float GB = 0.0F;
    public float GC = 0.0F;
    public float GD = 0.0F;
    public int GE = 0;
    public int GF = 0;
    public int GG = -1;
    public int GH = -1;
    public int GI = -1;
    public int GJ = -1;
    public boolean GK = false;
    public int GL = -1;
    public int GM = -1;
    public int[] GN;
    public String GO;
    boolean Gn = false;
    int Go;
    public int Gp = -1;
    public int Gq = -1;
    public int Gr = -1;
    public int Gs = -1;
    public int Gt = -1;
    public int Gu = -1;
    public boolean Gv = false;
    public float Gw = 0.0F;
    public float Gx = 0.0F;
    public float Gy = 0.0F;
    public float Gz = (0.0F / 0.0F);
    public float alpha = 1.0F;
    public float heightPercent = 1.0F;
    public int mHeight;
    public int mWidth;
    public float rotation = 0.0F;
    public float scaleX = 1.0F;
    public float scaleY = 1.0F;
    public int visibility = 0;
    public float widthPercent = 1.0F;
    
    final void a(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
    {
      AppMethodBeat.i(194809);
      this.Go = paramInt;
      this.EZ = paramLayoutParams.EZ;
      this.Fa = paramLayoutParams.Fa;
      this.Fb = paramLayoutParams.Fb;
      this.Fc = paramLayoutParams.Fc;
      this.Fd = paramLayoutParams.Fd;
      this.Fe = paramLayoutParams.Fe;
      this.Ff = paramLayoutParams.Ff;
      this.Fg = paramLayoutParams.Fg;
      this.Fh = paramLayoutParams.Fh;
      this.Fl = paramLayoutParams.Fl;
      this.Fm = paramLayoutParams.Fm;
      this.Fn = paramLayoutParams.Fn;
      this.Fo = paramLayoutParams.Fo;
      this.Fv = paramLayoutParams.Fv;
      this.Fw = paramLayoutParams.Fw;
      this.Fx = paramLayoutParams.Fx;
      this.Fi = paramLayoutParams.Fi;
      this.Fj = paramLayoutParams.Fj;
      this.Fk = paramLayoutParams.Fk;
      this.FM = paramLayoutParams.FM;
      this.FN = paramLayoutParams.FN;
      this.FO = paramLayoutParams.FO;
      this.EY = paramLayoutParams.EY;
      this.EW = paramLayoutParams.EW;
      this.EX = paramLayoutParams.EX;
      this.mWidth = paramLayoutParams.width;
      this.mHeight = paramLayoutParams.height;
      this.Gp = paramLayoutParams.leftMargin;
      this.Gq = paramLayoutParams.rightMargin;
      this.Gr = paramLayoutParams.topMargin;
      this.Gs = paramLayoutParams.bottomMargin;
      this.FB = paramLayoutParams.FB;
      this.FA = paramLayoutParams.FA;
      this.FD = paramLayoutParams.FD;
      this.FC = paramLayoutParams.FC;
      this.FP = paramLayoutParams.FP;
      this.FQ = paramLayoutParams.FQ;
      this.GE = paramLayoutParams.FE;
      this.GF = paramLayoutParams.FF;
      this.FP = paramLayoutParams.FP;
      this.GG = paramLayoutParams.FI;
      this.GH = paramLayoutParams.FJ;
      this.GI = paramLayoutParams.FG;
      this.GJ = paramLayoutParams.FH;
      this.widthPercent = paramLayoutParams.FK;
      this.heightPercent = paramLayoutParams.FL;
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.Gt = paramLayoutParams.getMarginEnd();
        this.Gu = paramLayoutParams.getMarginStart();
      }
      AppMethodBeat.o(194809);
    }
    
    final void a(int paramInt, Constraints.LayoutParams paramLayoutParams)
    {
      AppMethodBeat.i(194804);
      a(paramInt, paramLayoutParams);
      this.alpha = paramLayoutParams.alpha;
      this.rotation = paramLayoutParams.rotation;
      this.Gx = paramLayoutParams.Gx;
      this.Gy = paramLayoutParams.Gy;
      this.scaleX = paramLayoutParams.scaleX;
      this.scaleY = paramLayoutParams.scaleY;
      this.Gz = paramLayoutParams.Gz;
      this.GA = paramLayoutParams.GA;
      this.GB = paramLayoutParams.GB;
      this.GC = paramLayoutParams.GC;
      this.GD = paramLayoutParams.GD;
      this.Gw = paramLayoutParams.Gw;
      this.Gv = paramLayoutParams.Gv;
      AppMethodBeat.o(194804);
    }
    
    public final void a(ConstraintLayout.LayoutParams paramLayoutParams)
    {
      AppMethodBeat.i(194816);
      paramLayoutParams.EZ = this.EZ;
      paramLayoutParams.Fa = this.Fa;
      paramLayoutParams.Fb = this.Fb;
      paramLayoutParams.Fc = this.Fc;
      paramLayoutParams.Fd = this.Fd;
      paramLayoutParams.Fe = this.Fe;
      paramLayoutParams.Ff = this.Ff;
      paramLayoutParams.Fg = this.Fg;
      paramLayoutParams.Fh = this.Fh;
      paramLayoutParams.Fl = this.Fl;
      paramLayoutParams.Fm = this.Fm;
      paramLayoutParams.Fn = this.Fn;
      paramLayoutParams.Fo = this.Fo;
      paramLayoutParams.leftMargin = this.Gp;
      paramLayoutParams.rightMargin = this.Gq;
      paramLayoutParams.topMargin = this.Gr;
      paramLayoutParams.bottomMargin = this.Gs;
      paramLayoutParams.Ft = this.Ft;
      paramLayoutParams.Fu = this.Fu;
      paramLayoutParams.Fv = this.Fv;
      paramLayoutParams.Fw = this.Fw;
      paramLayoutParams.Fi = this.Fi;
      paramLayoutParams.Fj = this.Fj;
      paramLayoutParams.Fk = this.Fk;
      paramLayoutParams.Fx = this.Fx;
      paramLayoutParams.FM = this.FM;
      paramLayoutParams.FN = this.FN;
      paramLayoutParams.FB = this.FB;
      paramLayoutParams.FA = this.FA;
      paramLayoutParams.FD = this.FD;
      paramLayoutParams.FC = this.FC;
      paramLayoutParams.FP = this.FP;
      paramLayoutParams.FQ = this.FQ;
      paramLayoutParams.FE = this.GE;
      paramLayoutParams.FF = this.GF;
      paramLayoutParams.FI = this.GG;
      paramLayoutParams.FJ = this.GH;
      paramLayoutParams.FG = this.GI;
      paramLayoutParams.FH = this.GJ;
      paramLayoutParams.FK = this.widthPercent;
      paramLayoutParams.FL = this.heightPercent;
      paramLayoutParams.FO = this.FO;
      paramLayoutParams.EY = this.EY;
      paramLayoutParams.EW = this.EW;
      paramLayoutParams.EX = this.EX;
      paramLayoutParams.width = this.mWidth;
      paramLayoutParams.height = this.mHeight;
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramLayoutParams.setMarginStart(this.Gu);
        paramLayoutParams.setMarginEnd(this.Gt);
      }
      paramLayoutParams.validate();
      AppMethodBeat.o(194816);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.widget.a
 * JD-Core Version:    0.7.0.1
 */