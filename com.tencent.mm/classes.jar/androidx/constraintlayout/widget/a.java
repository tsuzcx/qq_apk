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
  private static final int[] bmo;
  private static SparseIntArray bmq;
  HashMap<Integer, a> bmp;
  
  static
  {
    AppMethodBeat.i(194258);
    bmo = new int[] { 0, 4, 8 };
    SparseIntArray localSparseIntArray = new SparseIntArray();
    bmq = localSparseIntArray;
    localSparseIntArray.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    bmq.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    bmq.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    bmq.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
    bmq.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
    bmq.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    bmq.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    bmq.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    bmq.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    bmq.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
    bmq.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
    bmq.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
    bmq.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
    bmq.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
    bmq.append(R.styleable.ConstraintSet_android_orientation, 27);
    bmq.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
    bmq.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
    bmq.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    bmq.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    bmq.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
    bmq.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
    bmq.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
    bmq.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
    bmq.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
    bmq.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
    bmq.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
    bmq.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
    bmq.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    bmq.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    bmq.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
    bmq.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
    bmq.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
    bmq.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 75);
    bmq.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 75);
    bmq.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 75);
    bmq.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 75);
    bmq.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 75);
    bmq.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
    bmq.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
    bmq.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
    bmq.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
    bmq.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
    bmq.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
    bmq.append(R.styleable.ConstraintSet_android_layout_width, 23);
    bmq.append(R.styleable.ConstraintSet_android_layout_height, 21);
    bmq.append(R.styleable.ConstraintSet_android_visibility, 22);
    bmq.append(R.styleable.ConstraintSet_android_alpha, 43);
    bmq.append(R.styleable.ConstraintSet_android_elevation, 44);
    bmq.append(R.styleable.ConstraintSet_android_rotationX, 45);
    bmq.append(R.styleable.ConstraintSet_android_rotationY, 46);
    bmq.append(R.styleable.ConstraintSet_android_rotation, 60);
    bmq.append(R.styleable.ConstraintSet_android_scaleX, 47);
    bmq.append(R.styleable.ConstraintSet_android_scaleY, 48);
    bmq.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
    bmq.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
    bmq.append(R.styleable.ConstraintSet_android_translationX, 51);
    bmq.append(R.styleable.ConstraintSet_android_translationY, 52);
    bmq.append(R.styleable.ConstraintSet_android_translationZ, 53);
    bmq.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
    bmq.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
    bmq.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
    bmq.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
    bmq.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
    bmq.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
    bmq.append(R.styleable.ConstraintSet_layout_constraintCircle, 61);
    bmq.append(R.styleable.ConstraintSet_layout_constraintCircleRadius, 62);
    bmq.append(R.styleable.ConstraintSet_layout_constraintCircleAngle, 63);
    bmq.append(R.styleable.ConstraintSet_android_id, 38);
    bmq.append(R.styleable.ConstraintSet_layout_constraintWidth_percent, 69);
    bmq.append(R.styleable.ConstraintSet_layout_constraintHeight_percent, 70);
    bmq.append(R.styleable.ConstraintSet_chainUseRtl, 71);
    bmq.append(R.styleable.ConstraintSet_barrierDirection, 72);
    bmq.append(R.styleable.ConstraintSet_constraint_referenced_ids, 73);
    bmq.append(R.styleable.ConstraintSet_barrierAllowsGoneWidgets, 74);
    AppMethodBeat.o(194258);
  }
  
  public a()
  {
    AppMethodBeat.i(194201);
    this.bmp = new HashMap();
    AppMethodBeat.o(194201);
  }
  
  private static int a(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194209);
    int i = paramTypedArray.getResourceId(paramInt1, paramInt2);
    paramInt2 = i;
    if (i == -1) {
      paramInt2 = paramTypedArray.getInt(paramInt1, -1);
    }
    AppMethodBeat.o(194209);
    return paramInt2;
  }
  
  static void a(a parama, TypedArray paramTypedArray)
  {
    AppMethodBeat.i(194227);
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    if (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      switch (bmq.get(k))
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
        new StringBuilder("Unknown attribute 0x").append(Integer.toHexString(k)).append("   ").append(bmq.get(k));
      }
      for (;;)
      {
        i += 1;
        break;
        parama.blg = a(paramTypedArray, k, parama.blg);
        continue;
        parama.blh = a(paramTypedArray, k, parama.blh);
        continue;
        parama.bli = a(paramTypedArray, k, parama.bli);
        continue;
        parama.blj = a(paramTypedArray, k, parama.blj);
        continue;
        parama.blk = a(paramTypedArray, k, parama.blk);
        continue;
        parama.bll = a(paramTypedArray, k, parama.bll);
        continue;
        parama.blm = a(paramTypedArray, k, parama.blm);
        continue;
        parama.bln = a(paramTypedArray, k, parama.bln);
        continue;
        parama.blo = a(paramTypedArray, k, parama.blo);
        continue;
        parama.blR = paramTypedArray.getDimensionPixelOffset(k, parama.blR);
        continue;
        parama.blS = paramTypedArray.getDimensionPixelOffset(k, parama.blS);
        continue;
        parama.bld = paramTypedArray.getDimensionPixelOffset(k, parama.bld);
        continue;
        parama.ble = paramTypedArray.getDimensionPixelOffset(k, parama.ble);
        continue;
        parama.blf = paramTypedArray.getFloat(k, parama.blf);
        continue;
        parama.orientation = paramTypedArray.getInt(k, parama.orientation);
        continue;
        parama.bls = a(paramTypedArray, k, parama.bls);
        continue;
        parama.blt = a(paramTypedArray, k, parama.blt);
        continue;
        parama.blu = a(paramTypedArray, k, parama.blu);
        continue;
        parama.blv = a(paramTypedArray, k, parama.blv);
        continue;
        parama.blp = a(paramTypedArray, k, parama.blp);
        continue;
        parama.blq = paramTypedArray.getDimensionPixelSize(k, parama.blq);
        continue;
        parama.blr = paramTypedArray.getFloat(k, parama.blr);
        continue;
        parama.blw = paramTypedArray.getDimensionPixelSize(k, parama.blw);
        continue;
        parama.blx = paramTypedArray.getDimensionPixelSize(k, parama.blx);
        continue;
        parama.bly = paramTypedArray.getDimensionPixelSize(k, parama.bly);
        continue;
        parama.blz = paramTypedArray.getDimensionPixelSize(k, parama.blz);
        continue;
        parama.blA = paramTypedArray.getDimensionPixelSize(k, parama.blA);
        continue;
        parama.blB = paramTypedArray.getDimensionPixelSize(k, parama.blB);
        continue;
        parama.atU = paramTypedArray.getFloat(k, parama.atU);
        continue;
        parama.atV = paramTypedArray.getFloat(k, parama.atV);
        continue;
        parama.bmt = paramTypedArray.getDimensionPixelSize(k, parama.bmt);
        continue;
        parama.bmu = paramTypedArray.getDimensionPixelSize(k, parama.bmu);
        continue;
        parama.bmy = paramTypedArray.getDimensionPixelSize(k, parama.bmy);
        continue;
        parama.bmx = paramTypedArray.getDimensionPixelSize(k, parama.bmx);
        continue;
        parama.bmv = paramTypedArray.getDimensionPixelSize(k, parama.bmv);
        continue;
        parama.bmw = paramTypedArray.getDimensionPixelSize(k, parama.bmw);
        continue;
        parama.mWidth = paramTypedArray.getLayoutDimension(k, parama.mWidth);
        continue;
        parama.mHeight = paramTypedArray.getLayoutDimension(k, parama.mHeight);
        continue;
        parama.visibility = paramTypedArray.getInt(k, parama.visibility);
        parama.visibility = bmo[parama.visibility];
        continue;
        parama.alpha = paramTypedArray.getFloat(k, parama.alpha);
        continue;
        parama.bmz = true;
        parama.bmA = paramTypedArray.getDimension(k, parama.bmA);
        continue;
        parama.rotation = paramTypedArray.getFloat(k, parama.rotation);
        continue;
        parama.ayf = paramTypedArray.getFloat(k, parama.ayf);
        continue;
        parama.ayg = paramTypedArray.getFloat(k, parama.ayg);
        continue;
        parama.scaleX = paramTypedArray.getFloat(k, parama.scaleX);
        continue;
        parama.scaleY = paramTypedArray.getFloat(k, parama.scaleY);
        continue;
        parama.bmB = paramTypedArray.getFloat(k, parama.bmB);
        continue;
        parama.bmC = paramTypedArray.getFloat(k, parama.bmC);
        continue;
        parama.ayc = paramTypedArray.getDimension(k, parama.ayc);
        continue;
        parama.ayd = paramTypedArray.getDimension(k, parama.ayd);
        continue;
        parama.bmD = paramTypedArray.getDimension(k, parama.bmD);
        continue;
        parama.blG = paramTypedArray.getFloat(k, parama.blG);
        continue;
        parama.blF = paramTypedArray.getFloat(k, parama.blF);
        continue;
        parama.blI = paramTypedArray.getInt(k, parama.blI);
        continue;
        parama.blH = paramTypedArray.getInt(k, parama.blH);
        continue;
        parama.bms = paramTypedArray.getResourceId(k, parama.bms);
        continue;
        parama.blC = paramTypedArray.getString(k);
        continue;
        parama.widthPercent = paramTypedArray.getFloat(k, 1.0F);
        continue;
        parama.heightPercent = paramTypedArray.getFloat(k, 1.0F);
        continue;
        parama.bmL = paramTypedArray.getInt(k, parama.bmL);
        continue;
        parama.bmO = paramTypedArray.getString(k);
        continue;
        parama.bmK = paramTypedArray.getBoolean(k, parama.bmK);
        continue;
        new StringBuilder("unused attribute 0x").append(Integer.toHexString(k)).append("   ").append(bmq.get(k));
      }
    }
    AppMethodBeat.o(194227);
  }
  
  private static int[] a(View paramView, String paramString)
  {
    AppMethodBeat.i(194242);
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
        localObject = ((ConstraintLayout)paramView.getParent()).at(localObject);
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
        AppMethodBeat.o(194242);
        return paramView;
      }
      label201:
      int i = j;
    }
  }
  
  private static String dV(int paramInt)
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
  
  public final void au(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194317);
    if (this.bmp.containsKey(Integer.valueOf(paramInt1)))
    {
      Object localObject = (a)this.bmp.get(Integer.valueOf(paramInt1));
      switch (paramInt2)
      {
      default: 
        localObject = new IllegalArgumentException("unknown constraint");
        AppMethodBeat.o(194317);
        throw ((Throwable)localObject);
      case 1: 
        ((a)localObject).blh = -1;
        ((a)localObject).blg = -1;
        ((a)localObject).bmt = -1;
        ((a)localObject).blw = -1;
        AppMethodBeat.o(194317);
        return;
      case 2: 
        ((a)localObject).blj = -1;
        ((a)localObject).bli = -1;
        ((a)localObject).bmu = -1;
        ((a)localObject).bly = -1;
        AppMethodBeat.o(194317);
        return;
      case 3: 
        ((a)localObject).bll = -1;
        ((a)localObject).blk = -1;
        ((a)localObject).bmv = -1;
        ((a)localObject).blx = -1;
        AppMethodBeat.o(194317);
        return;
      case 4: 
        ((a)localObject).blm = -1;
        ((a)localObject).bln = -1;
        ((a)localObject).bmw = -1;
        ((a)localObject).blz = -1;
        AppMethodBeat.o(194317);
        return;
      case 5: 
        ((a)localObject).blo = -1;
        AppMethodBeat.o(194317);
        return;
      case 6: 
        ((a)localObject).bls = -1;
        ((a)localObject).blt = -1;
        ((a)localObject).bmy = -1;
        ((a)localObject).blA = -1;
        AppMethodBeat.o(194317);
        return;
      }
      ((a)localObject).blu = -1;
      ((a)localObject).blv = -1;
      ((a)localObject).bmx = -1;
      ((a)localObject).blB = -1;
      AppMethodBeat.o(194317);
      return;
    }
    AppMethodBeat.o(194317);
  }
  
  public final void b(ConstraintLayout paramConstraintLayout)
  {
    AppMethodBeat.i(194270);
    int j = paramConstraintLayout.getChildCount();
    this.bmp.clear();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramConstraintLayout.getChildAt(i);
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)((View)localObject).getLayoutParams();
      int k = ((View)localObject).getId();
      if (k == -1)
      {
        paramConstraintLayout = new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        AppMethodBeat.o(194270);
        throw paramConstraintLayout;
      }
      if (!this.bmp.containsKey(Integer.valueOf(k))) {
        this.bmp.put(Integer.valueOf(k), new a((byte)0));
      }
      a locala = (a)this.bmp.get(Integer.valueOf(k));
      locala.a(k, localLayoutParams);
      locala.visibility = ((View)localObject).getVisibility();
      if (Build.VERSION.SDK_INT >= 17)
      {
        locala.alpha = ((View)localObject).getAlpha();
        locala.rotation = ((View)localObject).getRotation();
        locala.ayf = ((View)localObject).getRotationX();
        locala.ayg = ((View)localObject).getRotationY();
        locala.scaleX = ((View)localObject).getScaleX();
        locala.scaleY = ((View)localObject).getScaleY();
        float f1 = ((View)localObject).getPivotX();
        float f2 = ((View)localObject).getPivotY();
        if ((f1 != 0.0D) || (f2 != 0.0D))
        {
          locala.bmB = f1;
          locala.bmC = f2;
        }
        locala.ayc = ((View)localObject).getTranslationX();
        locala.ayd = ((View)localObject).getTranslationY();
        if (Build.VERSION.SDK_INT >= 21)
        {
          locala.bmD = ((View)localObject).getTranslationZ();
          if (locala.bmz) {
            locala.bmA = ((View)localObject).getElevation();
          }
        }
      }
      if ((localObject instanceof Barrier))
      {
        localObject = (Barrier)localObject;
        locala.bmK = ((Barrier)localObject).bkH.bhk;
        locala.bmN = ((Barrier)localObject).getReferencedIds();
        locala.bmL = ((Barrier)localObject).getType();
      }
      i += 1;
    }
    AppMethodBeat.o(194270);
  }
  
  public final void c(ConstraintLayout paramConstraintLayout)
  {
    AppMethodBeat.i(194277);
    d(paramConstraintLayout);
    paramConstraintLayout.setConstraintSet(null);
    AppMethodBeat.o(194277);
  }
  
  final void d(ConstraintLayout paramConstraintLayout)
  {
    AppMethodBeat.i(194292);
    int j = paramConstraintLayout.getChildCount();
    Object localObject1 = new HashSet(this.bmp.keySet());
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
        AppMethodBeat.o(194292);
        throw paramConstraintLayout;
      }
      if (this.bmp.containsKey(Integer.valueOf(k)))
      {
        ((HashSet)localObject1).remove(Integer.valueOf(k));
        localObject3 = (a)this.bmp.get(Integer.valueOf(k));
        if ((localObject2 instanceof Barrier)) {
          ((a)localObject3).bmM = 1;
        }
        if (((a)localObject3).bmM != -1) {
          switch (((a)localObject3).bmM)
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
          ((View)localObject2).setRotationX(((a)localObject3).ayf);
          ((View)localObject2).setRotationY(((a)localObject3).ayg);
          ((View)localObject2).setScaleX(((a)localObject3).scaleX);
          ((View)localObject2).setScaleY(((a)localObject3).scaleY);
          if (!Float.isNaN(((a)localObject3).bmB)) {
            ((View)localObject2).setPivotX(((a)localObject3).bmB);
          }
          if (!Float.isNaN(((a)localObject3).bmC)) {
            ((View)localObject2).setPivotY(((a)localObject3).bmC);
          }
          ((View)localObject2).setTranslationX(((a)localObject3).ayc);
          ((View)localObject2).setTranslationY(((a)localObject3).ayd);
          if (Build.VERSION.SDK_INT >= 21)
          {
            ((View)localObject2).setTranslationZ(((a)localObject3).bmD);
            if (((a)localObject3).bmz) {
              ((View)localObject2).setElevation(((a)localObject3).bmA);
            }
          }
        }
        i += 1;
        break;
        localObject4 = (Barrier)localObject2;
        ((Barrier)localObject4).setId(k);
        ((Barrier)localObject4).setType(((a)localObject3).bmL);
        ((Barrier)localObject4).setAllowsGoneWidget(((a)localObject3).bmK);
        if (((a)localObject3).bmN != null)
        {
          ((Barrier)localObject4).setReferencedIds(((a)localObject3).bmN);
        }
        else if (((a)localObject3).bmO != null)
        {
          ((a)localObject3).bmN = a((View)localObject4, ((a)localObject3).bmO);
          ((Barrier)localObject4).setReferencedIds(((a)localObject3).bmN);
        }
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject1).next();
      localObject2 = (a)this.bmp.get(localObject3);
      if (((a)localObject2).bmM != -1) {}
      switch (((a)localObject2).bmM)
      {
      default: 
        if (((a)localObject2).bmr)
        {
          localObject4 = new Guideline(paramConstraintLayout.getContext());
          ((Guideline)localObject4).setId(((Integer)localObject3).intValue());
          localObject3 = ConstraintLayout.Dk();
          ((a)localObject2).a((ConstraintLayout.LayoutParams)localObject3);
          paramConstraintLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
        }
        break;
      case 1: 
        label536:
        localObject4 = new Barrier(paramConstraintLayout.getContext());
        ((Barrier)localObject4).setId(((Integer)localObject3).intValue());
        if (((a)localObject2).bmN != null) {
          ((Barrier)localObject4).setReferencedIds(((a)localObject2).bmN);
        }
        for (;;)
        {
          ((Barrier)localObject4).setType(((a)localObject2).bmL);
          ConstraintLayout.LayoutParams localLayoutParams = ConstraintLayout.Dk();
          ((Barrier)localObject4).Dh();
          ((a)localObject2).a(localLayoutParams);
          paramConstraintLayout.addView((View)localObject4, localLayoutParams);
          break label536;
          break;
          if (((a)localObject2).bmO != null)
          {
            ((a)localObject2).bmN = a((View)localObject4, ((a)localObject2).bmO);
            ((Barrier)localObject4).setReferencedIds(((a)localObject2).bmN);
          }
        }
      }
    }
    AppMethodBeat.o(194292);
  }
  
  public final void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(194302);
    if (!this.bmp.containsKey(Integer.valueOf(paramInt1))) {
      this.bmp.put(Integer.valueOf(paramInt1), new a((byte)0));
    }
    Object localObject = (a)this.bmp.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      localObject = new IllegalArgumentException(dV(paramInt2) + " to " + dV(paramInt4) + " unknown");
      AppMethodBeat.o(194302);
      throw ((Throwable)localObject);
    case 1: 
      if (paramInt4 == 1)
      {
        ((a)localObject).blg = paramInt3;
        ((a)localObject).blh = -1;
      }
      for (;;)
      {
        ((a)localObject).bmt = paramInt5;
        AppMethodBeat.o(194302);
        return;
        if (paramInt4 != 2) {
          break;
        }
        ((a)localObject).blh = paramInt3;
        ((a)localObject).blg = -1;
      }
      localObject = new IllegalArgumentException("Left to " + dV(paramInt4) + " undefined");
      AppMethodBeat.o(194302);
      throw ((Throwable)localObject);
    case 2: 
      if (paramInt4 == 1)
      {
        ((a)localObject).bli = paramInt3;
        ((a)localObject).blj = -1;
      }
      for (;;)
      {
        ((a)localObject).bmu = paramInt5;
        AppMethodBeat.o(194302);
        return;
        if (paramInt4 != 2) {
          break;
        }
        ((a)localObject).blj = paramInt3;
        ((a)localObject).bli = -1;
      }
      localObject = new IllegalArgumentException("right to " + dV(paramInt4) + " undefined");
      AppMethodBeat.o(194302);
      throw ((Throwable)localObject);
    case 3: 
      if (paramInt4 == 3)
      {
        ((a)localObject).blk = paramInt3;
        ((a)localObject).bll = -1;
      }
      for (((a)localObject).blo = -1;; ((a)localObject).blo = -1)
      {
        ((a)localObject).bmv = paramInt5;
        AppMethodBeat.o(194302);
        return;
        if (paramInt4 != 4) {
          break;
        }
        ((a)localObject).bll = paramInt3;
        ((a)localObject).blk = -1;
      }
      localObject = new IllegalArgumentException("right to " + dV(paramInt4) + " undefined");
      AppMethodBeat.o(194302);
      throw ((Throwable)localObject);
    case 4: 
      if (paramInt4 == 4)
      {
        ((a)localObject).bln = paramInt3;
        ((a)localObject).blm = -1;
      }
      for (((a)localObject).blo = -1;; ((a)localObject).blo = -1)
      {
        ((a)localObject).bmw = paramInt5;
        AppMethodBeat.o(194302);
        return;
        if (paramInt4 != 3) {
          break;
        }
        ((a)localObject).blm = paramInt3;
        ((a)localObject).bln = -1;
      }
      localObject = new IllegalArgumentException("right to " + dV(paramInt4) + " undefined");
      AppMethodBeat.o(194302);
      throw ((Throwable)localObject);
    case 5: 
      if (paramInt4 == 5)
      {
        ((a)localObject).blo = paramInt3;
        ((a)localObject).bln = -1;
        ((a)localObject).blm = -1;
        ((a)localObject).blk = -1;
        ((a)localObject).bll = -1;
        AppMethodBeat.o(194302);
        return;
      }
      localObject = new IllegalArgumentException("right to " + dV(paramInt4) + " undefined");
      AppMethodBeat.o(194302);
      throw ((Throwable)localObject);
    case 6: 
      if (paramInt4 == 6)
      {
        ((a)localObject).blt = paramInt3;
        ((a)localObject).bls = -1;
      }
      for (;;)
      {
        ((a)localObject).bmy = paramInt5;
        AppMethodBeat.o(194302);
        return;
        if (paramInt4 != 7) {
          break;
        }
        ((a)localObject).bls = paramInt3;
        ((a)localObject).blt = -1;
      }
      localObject = new IllegalArgumentException("right to " + dV(paramInt4) + " undefined");
      AppMethodBeat.o(194302);
      throw ((Throwable)localObject);
    }
    if (paramInt4 == 7)
    {
      ((a)localObject).blv = paramInt3;
      ((a)localObject).blu = -1;
    }
    for (;;)
    {
      ((a)localObject).bmx = paramInt5;
      AppMethodBeat.o(194302);
      return;
      if (paramInt4 != 6) {
        break;
      }
      ((a)localObject).blu = paramInt3;
      ((a)localObject).blv = -1;
    }
    localObject = new IllegalArgumentException("right to " + dV(paramInt4) + " undefined");
    AppMethodBeat.o(194302);
    throw ((Throwable)localObject);
  }
  
  public final void l(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(194307);
    if (!this.bmp.containsKey(Integer.valueOf(paramInt1))) {
      this.bmp.put(Integer.valueOf(paramInt1), new a((byte)0));
    }
    Object localObject = (a)this.bmp.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      localObject = new IllegalArgumentException(dV(paramInt2) + " to " + dV(paramInt4) + " unknown");
      AppMethodBeat.o(194307);
      throw ((Throwable)localObject);
    case 1: 
      if (paramInt4 == 1)
      {
        ((a)localObject).blg = paramInt3;
        ((a)localObject).blh = -1;
        AppMethodBeat.o(194307);
        return;
      }
      if (paramInt4 == 2)
      {
        ((a)localObject).blh = paramInt3;
        ((a)localObject).blg = -1;
        AppMethodBeat.o(194307);
        return;
      }
      localObject = new IllegalArgumentException("left to " + dV(paramInt4) + " undefined");
      AppMethodBeat.o(194307);
      throw ((Throwable)localObject);
    case 2: 
      if (paramInt4 == 1)
      {
        ((a)localObject).bli = paramInt3;
        ((a)localObject).blj = -1;
        AppMethodBeat.o(194307);
        return;
      }
      if (paramInt4 == 2)
      {
        ((a)localObject).blj = paramInt3;
        ((a)localObject).bli = -1;
        AppMethodBeat.o(194307);
        return;
      }
      localObject = new IllegalArgumentException("right to " + dV(paramInt4) + " undefined");
      AppMethodBeat.o(194307);
      throw ((Throwable)localObject);
    case 3: 
      if (paramInt4 == 3)
      {
        ((a)localObject).blk = paramInt3;
        ((a)localObject).bll = -1;
        ((a)localObject).blo = -1;
        AppMethodBeat.o(194307);
        return;
      }
      if (paramInt4 == 4)
      {
        ((a)localObject).bll = paramInt3;
        ((a)localObject).blk = -1;
        ((a)localObject).blo = -1;
        AppMethodBeat.o(194307);
        return;
      }
      localObject = new IllegalArgumentException("right to " + dV(paramInt4) + " undefined");
      AppMethodBeat.o(194307);
      throw ((Throwable)localObject);
    case 4: 
      if (paramInt4 == 4)
      {
        ((a)localObject).bln = paramInt3;
        ((a)localObject).blm = -1;
        ((a)localObject).blo = -1;
        AppMethodBeat.o(194307);
        return;
      }
      if (paramInt4 == 3)
      {
        ((a)localObject).blm = paramInt3;
        ((a)localObject).bln = -1;
        ((a)localObject).blo = -1;
        AppMethodBeat.o(194307);
        return;
      }
      localObject = new IllegalArgumentException("right to " + dV(paramInt4) + " undefined");
      AppMethodBeat.o(194307);
      throw ((Throwable)localObject);
    case 5: 
      if (paramInt4 == 5)
      {
        ((a)localObject).blo = paramInt3;
        ((a)localObject).bln = -1;
        ((a)localObject).blm = -1;
        ((a)localObject).blk = -1;
        ((a)localObject).bll = -1;
        AppMethodBeat.o(194307);
        return;
      }
      localObject = new IllegalArgumentException("right to " + dV(paramInt4) + " undefined");
      AppMethodBeat.o(194307);
      throw ((Throwable)localObject);
    case 6: 
      if (paramInt4 == 6)
      {
        ((a)localObject).blt = paramInt3;
        ((a)localObject).bls = -1;
        AppMethodBeat.o(194307);
        return;
      }
      if (paramInt4 == 7)
      {
        ((a)localObject).bls = paramInt3;
        ((a)localObject).blt = -1;
        AppMethodBeat.o(194307);
        return;
      }
      localObject = new IllegalArgumentException("right to " + dV(paramInt4) + " undefined");
      AppMethodBeat.o(194307);
      throw ((Throwable)localObject);
    }
    if (paramInt4 == 7)
    {
      ((a)localObject).blv = paramInt3;
      ((a)localObject).blu = -1;
      AppMethodBeat.o(194307);
      return;
    }
    if (paramInt4 == 6)
    {
      ((a)localObject).blu = paramInt3;
      ((a)localObject).blv = -1;
      AppMethodBeat.o(194307);
      return;
    }
    localObject = new IllegalArgumentException("right to " + dV(paramInt4) + " undefined");
    AppMethodBeat.o(194307);
    throw ((Throwable)localObject);
  }
  
  static final class a
  {
    public float alpha = 1.0F;
    public float atU = 0.5F;
    public float atV = 0.5F;
    public float ayc = 0.0F;
    public float ayd = 0.0F;
    public float ayf = 0.0F;
    public float ayg = 0.0F;
    public int blA = -1;
    public int blB = -1;
    public String blC = null;
    public float blF = 0.0F;
    public float blG = 0.0F;
    public int blH = 0;
    public int blI = 0;
    public int blR = -1;
    public int blS = -1;
    public boolean blT = false;
    public boolean blU = false;
    public int bld = -1;
    public int ble = -1;
    public float blf = -1.0F;
    public int blg = -1;
    public int blh = -1;
    public int bli = -1;
    public int blj = -1;
    public int blk = -1;
    public int bll = -1;
    public int blm = -1;
    public int bln = -1;
    public int blo = -1;
    public int blp = -1;
    public int blq = 0;
    public float blr = 0.0F;
    public int bls = -1;
    public int blt = -1;
    public int blu = -1;
    public int blv = -1;
    public int blw = -1;
    public int blx = -1;
    public int bly = -1;
    public int blz = -1;
    public float bmA = 0.0F;
    public float bmB = (0.0F / 0.0F);
    public float bmC = (0.0F / 0.0F);
    public float bmD = 0.0F;
    public int bmE = 0;
    public int bmF = 0;
    public int bmG = -1;
    public int bmH = -1;
    public int bmI = -1;
    public int bmJ = -1;
    public boolean bmK = false;
    public int bmL = -1;
    public int bmM = -1;
    public int[] bmN;
    public String bmO;
    boolean bmr = false;
    int bms;
    public int bmt = -1;
    public int bmu = -1;
    public int bmv = -1;
    public int bmw = -1;
    public int bmx = -1;
    public int bmy = -1;
    public boolean bmz = false;
    public float heightPercent = 1.0F;
    public int mHeight;
    public int mWidth;
    public int orientation = -1;
    public float rotation = 0.0F;
    public float scaleX = 1.0F;
    public float scaleY = 1.0F;
    public int visibility = 0;
    public float widthPercent = 1.0F;
    
    final void a(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
    {
      AppMethodBeat.i(194214);
      this.bms = paramInt;
      this.blg = paramLayoutParams.blg;
      this.blh = paramLayoutParams.blh;
      this.bli = paramLayoutParams.bli;
      this.blj = paramLayoutParams.blj;
      this.blk = paramLayoutParams.blk;
      this.bll = paramLayoutParams.bll;
      this.blm = paramLayoutParams.blm;
      this.bln = paramLayoutParams.bln;
      this.blo = paramLayoutParams.blo;
      this.bls = paramLayoutParams.bls;
      this.blt = paramLayoutParams.blt;
      this.blu = paramLayoutParams.blu;
      this.blv = paramLayoutParams.blv;
      this.atU = paramLayoutParams.atU;
      this.atV = paramLayoutParams.atV;
      this.blC = paramLayoutParams.blC;
      this.blp = paramLayoutParams.blp;
      this.blq = paramLayoutParams.blq;
      this.blr = paramLayoutParams.blr;
      this.blR = paramLayoutParams.blR;
      this.blS = paramLayoutParams.blS;
      this.orientation = paramLayoutParams.orientation;
      this.blf = paramLayoutParams.blf;
      this.bld = paramLayoutParams.bld;
      this.ble = paramLayoutParams.ble;
      this.mWidth = paramLayoutParams.width;
      this.mHeight = paramLayoutParams.height;
      this.bmt = paramLayoutParams.leftMargin;
      this.bmu = paramLayoutParams.rightMargin;
      this.bmv = paramLayoutParams.topMargin;
      this.bmw = paramLayoutParams.bottomMargin;
      this.blG = paramLayoutParams.blG;
      this.blF = paramLayoutParams.blF;
      this.blI = paramLayoutParams.blI;
      this.blH = paramLayoutParams.blH;
      this.blT = paramLayoutParams.blT;
      this.blU = paramLayoutParams.blU;
      this.bmE = paramLayoutParams.blJ;
      this.bmF = paramLayoutParams.blK;
      this.blT = paramLayoutParams.blT;
      this.bmG = paramLayoutParams.blN;
      this.bmH = paramLayoutParams.blO;
      this.bmI = paramLayoutParams.blL;
      this.bmJ = paramLayoutParams.blM;
      this.widthPercent = paramLayoutParams.blP;
      this.heightPercent = paramLayoutParams.blQ;
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.bmx = paramLayoutParams.getMarginEnd();
        this.bmy = paramLayoutParams.getMarginStart();
      }
      AppMethodBeat.o(194214);
    }
    
    final void a(int paramInt, Constraints.LayoutParams paramLayoutParams)
    {
      AppMethodBeat.i(194207);
      a(paramInt, paramLayoutParams);
      this.alpha = paramLayoutParams.alpha;
      this.rotation = paramLayoutParams.rotation;
      this.ayf = paramLayoutParams.ayf;
      this.ayg = paramLayoutParams.ayg;
      this.scaleX = paramLayoutParams.scaleX;
      this.scaleY = paramLayoutParams.scaleY;
      this.bmB = paramLayoutParams.bmB;
      this.bmC = paramLayoutParams.bmC;
      this.ayc = paramLayoutParams.ayc;
      this.ayd = paramLayoutParams.ayd;
      this.bmD = paramLayoutParams.bmD;
      this.bmA = paramLayoutParams.bmA;
      this.bmz = paramLayoutParams.bmz;
      AppMethodBeat.o(194207);
    }
    
    public final void a(ConstraintLayout.LayoutParams paramLayoutParams)
    {
      AppMethodBeat.i(194224);
      paramLayoutParams.blg = this.blg;
      paramLayoutParams.blh = this.blh;
      paramLayoutParams.bli = this.bli;
      paramLayoutParams.blj = this.blj;
      paramLayoutParams.blk = this.blk;
      paramLayoutParams.bll = this.bll;
      paramLayoutParams.blm = this.blm;
      paramLayoutParams.bln = this.bln;
      paramLayoutParams.blo = this.blo;
      paramLayoutParams.bls = this.bls;
      paramLayoutParams.blt = this.blt;
      paramLayoutParams.blu = this.blu;
      paramLayoutParams.blv = this.blv;
      paramLayoutParams.leftMargin = this.bmt;
      paramLayoutParams.rightMargin = this.bmu;
      paramLayoutParams.topMargin = this.bmv;
      paramLayoutParams.bottomMargin = this.bmw;
      paramLayoutParams.blA = this.blA;
      paramLayoutParams.blB = this.blB;
      paramLayoutParams.atU = this.atU;
      paramLayoutParams.atV = this.atV;
      paramLayoutParams.blp = this.blp;
      paramLayoutParams.blq = this.blq;
      paramLayoutParams.blr = this.blr;
      paramLayoutParams.blC = this.blC;
      paramLayoutParams.blR = this.blR;
      paramLayoutParams.blS = this.blS;
      paramLayoutParams.blG = this.blG;
      paramLayoutParams.blF = this.blF;
      paramLayoutParams.blI = this.blI;
      paramLayoutParams.blH = this.blH;
      paramLayoutParams.blT = this.blT;
      paramLayoutParams.blU = this.blU;
      paramLayoutParams.blJ = this.bmE;
      paramLayoutParams.blK = this.bmF;
      paramLayoutParams.blN = this.bmG;
      paramLayoutParams.blO = this.bmH;
      paramLayoutParams.blL = this.bmI;
      paramLayoutParams.blM = this.bmJ;
      paramLayoutParams.blP = this.widthPercent;
      paramLayoutParams.blQ = this.heightPercent;
      paramLayoutParams.orientation = this.orientation;
      paramLayoutParams.blf = this.blf;
      paramLayoutParams.bld = this.bld;
      paramLayoutParams.ble = this.ble;
      paramLayoutParams.width = this.mWidth;
      paramLayoutParams.height = this.mHeight;
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramLayoutParams.setMarginStart(this.bmy);
        paramLayoutParams.setMarginEnd(this.bmx);
      }
      paramLayoutParams.Dl();
      AppMethodBeat.o(194224);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.widget.a
 * JD-Core Version:    0.7.0.1
 */