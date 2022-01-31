package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet
{
  private static final int ALPHA = 43;
  private static final int BARRIER_ALLOWS_GONE_WIDGETS = 74;
  private static final int BARRIER_DIRECTION = 72;
  private static final int BARRIER_TYPE = 1;
  public static final int BASELINE = 5;
  private static final int BASELINE_TO_BASELINE = 1;
  public static final int BOTTOM = 4;
  private static final int BOTTOM_MARGIN = 2;
  private static final int BOTTOM_TO_BOTTOM = 3;
  private static final int BOTTOM_TO_TOP = 4;
  public static final int CHAIN_PACKED = 2;
  public static final int CHAIN_SPREAD = 0;
  public static final int CHAIN_SPREAD_INSIDE = 1;
  private static final int CHAIN_USE_RTL = 71;
  private static final int CIRCLE = 61;
  private static final int CIRCLE_ANGLE = 63;
  private static final int CIRCLE_RADIUS = 62;
  private static final int CONSTRAINT_REFERENCED_IDS = 73;
  private static final boolean DEBUG = false;
  private static final int DIMENSION_RATIO = 5;
  private static final int EDITOR_ABSOLUTE_X = 6;
  private static final int EDITOR_ABSOLUTE_Y = 7;
  private static final int ELEVATION = 44;
  public static final int END = 7;
  private static final int END_MARGIN = 8;
  private static final int END_TO_END = 9;
  private static final int END_TO_START = 10;
  public static final int GONE = 8;
  private static final int GONE_BOTTOM_MARGIN = 11;
  private static final int GONE_END_MARGIN = 12;
  private static final int GONE_LEFT_MARGIN = 13;
  private static final int GONE_RIGHT_MARGIN = 14;
  private static final int GONE_START_MARGIN = 15;
  private static final int GONE_TOP_MARGIN = 16;
  private static final int GUIDE_BEGIN = 17;
  private static final int GUIDE_END = 18;
  private static final int GUIDE_PERCENT = 19;
  private static final int HEIGHT_DEFAULT = 55;
  private static final int HEIGHT_MAX = 57;
  private static final int HEIGHT_MIN = 59;
  private static final int HEIGHT_PERCENT = 70;
  public static final int HORIZONTAL = 0;
  private static final int HORIZONTAL_BIAS = 20;
  public static final int HORIZONTAL_GUIDELINE = 0;
  private static final int HORIZONTAL_STYLE = 41;
  private static final int HORIZONTAL_WEIGHT = 39;
  public static final int INVISIBLE = 4;
  private static final int LAYOUT_HEIGHT = 21;
  private static final int LAYOUT_VISIBILITY = 22;
  private static final int LAYOUT_WIDTH = 23;
  public static final int LEFT = 1;
  private static final int LEFT_MARGIN = 24;
  private static final int LEFT_TO_LEFT = 25;
  private static final int LEFT_TO_RIGHT = 26;
  public static final int MATCH_CONSTRAINT = 0;
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  private static final int ORIENTATION = 27;
  public static final int PARENT_ID = 0;
  public static final int RIGHT = 2;
  private static final int RIGHT_MARGIN = 28;
  private static final int RIGHT_TO_LEFT = 29;
  private static final int RIGHT_TO_RIGHT = 30;
  private static final int ROTATION = 60;
  private static final int ROTATION_X = 45;
  private static final int ROTATION_Y = 46;
  private static final int SCALE_X = 47;
  private static final int SCALE_Y = 48;
  public static final int START = 6;
  private static final int START_MARGIN = 31;
  private static final int START_TO_END = 32;
  private static final int START_TO_START = 33;
  private static final String TAG = "ConstraintSet";
  public static final int TOP = 3;
  private static final int TOP_MARGIN = 34;
  private static final int TOP_TO_BOTTOM = 35;
  private static final int TOP_TO_TOP = 36;
  private static final int TRANSFORM_PIVOT_X = 49;
  private static final int TRANSFORM_PIVOT_Y = 50;
  private static final int TRANSLATION_X = 51;
  private static final int TRANSLATION_Y = 52;
  private static final int TRANSLATION_Z = 53;
  public static final int UNSET = -1;
  private static final int UNUSED = 75;
  public static final int VERTICAL = 1;
  private static final int VERTICAL_BIAS = 37;
  public static final int VERTICAL_GUIDELINE = 1;
  private static final int VERTICAL_STYLE = 42;
  private static final int VERTICAL_WEIGHT = 40;
  private static final int VIEW_ID = 38;
  private static final int[] VISIBILITY_FLAGS = { 0, 4, 8 };
  public static final int VISIBLE = 0;
  private static final int WIDTH_DEFAULT = 54;
  private static final int WIDTH_MAX = 56;
  private static final int WIDTH_MIN = 58;
  private static final int WIDTH_PERCENT = 69;
  public static final int WRAP_CONTENT = -2;
  private static SparseIntArray mapToConstant;
  private HashMap<Integer, Constraint> mConstraints = new HashMap();
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    mapToConstant = localSparseIntArray;
    localSparseIntArray.append(55, 25);
    mapToConstant.append(56, 26);
    mapToConstant.append(58, 29);
    mapToConstant.append(59, 30);
    mapToConstant.append(64, 36);
    mapToConstant.append(63, 35);
    mapToConstant.append(37, 4);
    mapToConstant.append(36, 3);
    mapToConstant.append(34, 1);
    mapToConstant.append(72, 6);
    mapToConstant.append(73, 7);
    mapToConstant.append(44, 17);
    mapToConstant.append(45, 18);
    mapToConstant.append(46, 19);
    mapToConstant.append(0, 27);
    mapToConstant.append(60, 32);
    mapToConstant.append(61, 33);
    mapToConstant.append(43, 10);
    mapToConstant.append(42, 9);
    mapToConstant.append(76, 13);
    mapToConstant.append(79, 16);
    mapToConstant.append(77, 14);
    mapToConstant.append(74, 11);
    mapToConstant.append(78, 15);
    mapToConstant.append(75, 12);
    mapToConstant.append(67, 40);
    mapToConstant.append(53, 39);
    mapToConstant.append(52, 41);
    mapToConstant.append(66, 42);
    mapToConstant.append(51, 20);
    mapToConstant.append(65, 37);
    mapToConstant.append(41, 5);
    mapToConstant.append(54, 75);
    mapToConstant.append(62, 75);
    mapToConstant.append(57, 75);
    mapToConstant.append(35, 75);
    mapToConstant.append(33, 75);
    mapToConstant.append(5, 24);
    mapToConstant.append(7, 28);
    mapToConstant.append(23, 31);
    mapToConstant.append(24, 8);
    mapToConstant.append(6, 34);
    mapToConstant.append(8, 2);
    mapToConstant.append(3, 23);
    mapToConstant.append(4, 21);
    mapToConstant.append(2, 22);
    mapToConstant.append(13, 43);
    mapToConstant.append(26, 44);
    mapToConstant.append(21, 45);
    mapToConstant.append(22, 46);
    mapToConstant.append(20, 60);
    mapToConstant.append(18, 47);
    mapToConstant.append(19, 48);
    mapToConstant.append(14, 49);
    mapToConstant.append(15, 50);
    mapToConstant.append(16, 51);
    mapToConstant.append(17, 52);
    mapToConstant.append(25, 53);
    mapToConstant.append(68, 54);
    mapToConstant.append(47, 55);
    mapToConstant.append(69, 56);
    mapToConstant.append(48, 57);
    mapToConstant.append(70, 58);
    mapToConstant.append(49, 59);
    mapToConstant.append(38, 61);
    mapToConstant.append(40, 62);
    mapToConstant.append(39, 63);
    mapToConstant.append(1, 38);
    mapToConstant.append(71, 69);
    mapToConstant.append(50, 70);
    mapToConstant.append(29, 71);
    mapToConstant.append(28, 72);
    mapToConstant.append(30, 73);
    mapToConstant.append(27, 74);
  }
  
  private int[] convertReferenceString(View paramView, String paramString)
  {
    paramString = paramString.split(",");
    Context localContext = paramView.getContext();
    int[] arrayOfInt = new int[paramString.length];
    int m = 0;
    int k = 0;
    Object localObject;
    if (m < paramString.length) {
      localObject = paramString[m].trim();
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
          break label185;
        }
        localObject = ((ConstraintLayout)paramView.getParent()).getDesignInformation(0, localObject);
        if ((localObject == null) || (!(localObject instanceof Integer))) {
          break label185;
        }
        i = ((Integer)localObject).intValue();
        arrayOfInt[k] = i;
        m += 1;
        k += 1;
      }
      catch (Exception localException)
      {
        i = 0;
        continue;
      }
      if (k != paramString.length) {
        return Arrays.copyOf(arrayOfInt, k);
      }
      return arrayOfInt;
      label185:
      int i = j;
    }
  }
  
  private void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramArrayOfInt.length < 2) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if (paramArrayOfFloat != null) {
      get(paramArrayOfInt[0]).horizontalWeight = paramArrayOfFloat[0];
    }
    get(paramArrayOfInt[0]).horizontalChainStyle = paramInt5;
    connect(paramArrayOfInt[0], paramInt6, paramInt1, paramInt2, -1);
    paramInt1 = 1;
    while (paramInt1 < paramArrayOfInt.length)
    {
      connect(paramArrayOfInt[paramInt1], paramInt6, paramArrayOfInt[(paramInt1 - 1)], paramInt7, -1);
      connect(paramArrayOfInt[(paramInt1 - 1)], paramInt7, paramArrayOfInt[paramInt1], paramInt6, -1);
      if (paramArrayOfFloat != null) {
        get(paramArrayOfInt[paramInt1]).horizontalWeight = paramArrayOfFloat[paramInt1];
      }
      paramInt1 += 1;
    }
    connect(paramArrayOfInt[(paramArrayOfInt.length - 1)], paramInt7, paramInt3, paramInt4, -1);
  }
  
  private Constraint fillFromAttributeList(Context paramContext, AttributeSet paramAttributeSet)
  {
    Constraint localConstraint = new Constraint(null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
    populateConstraint(localConstraint, paramContext);
    paramContext.recycle();
    return localConstraint;
  }
  
  private Constraint get(int paramInt)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt))) {
      this.mConstraints.put(Integer.valueOf(paramInt), new Constraint(null));
    }
    return (Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
  }
  
  private static int lookupID(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    int i = paramTypedArray.getResourceId(paramInt1, paramInt2);
    paramInt2 = i;
    if (i == -1) {
      paramInt2 = paramTypedArray.getInt(paramInt1, -1);
    }
    return paramInt2;
  }
  
  private void populateConstraint(Constraint paramConstraint, TypedArray paramTypedArray)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    if (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      switch (mapToConstant.get(k))
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
        new StringBuilder("Unknown attribute 0x").append(Integer.toHexString(k)).append("   ").append(mapToConstant.get(k));
      }
      for (;;)
      {
        i += 1;
        break;
        paramConstraint.leftToLeft = lookupID(paramTypedArray, k, paramConstraint.leftToLeft);
        continue;
        paramConstraint.leftToRight = lookupID(paramTypedArray, k, paramConstraint.leftToRight);
        continue;
        paramConstraint.rightToLeft = lookupID(paramTypedArray, k, paramConstraint.rightToLeft);
        continue;
        paramConstraint.rightToRight = lookupID(paramTypedArray, k, paramConstraint.rightToRight);
        continue;
        paramConstraint.topToTop = lookupID(paramTypedArray, k, paramConstraint.topToTop);
        continue;
        paramConstraint.topToBottom = lookupID(paramTypedArray, k, paramConstraint.topToBottom);
        continue;
        paramConstraint.bottomToTop = lookupID(paramTypedArray, k, paramConstraint.bottomToTop);
        continue;
        paramConstraint.bottomToBottom = lookupID(paramTypedArray, k, paramConstraint.bottomToBottom);
        continue;
        paramConstraint.baselineToBaseline = lookupID(paramTypedArray, k, paramConstraint.baselineToBaseline);
        continue;
        paramConstraint.editorAbsoluteX = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.editorAbsoluteX);
        continue;
        paramConstraint.editorAbsoluteY = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.editorAbsoluteY);
        continue;
        paramConstraint.guideBegin = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.guideBegin);
        continue;
        paramConstraint.guideEnd = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.guideEnd);
        continue;
        paramConstraint.guidePercent = paramTypedArray.getFloat(k, paramConstraint.guidePercent);
        continue;
        paramConstraint.orientation = paramTypedArray.getInt(k, paramConstraint.orientation);
        continue;
        paramConstraint.startToEnd = lookupID(paramTypedArray, k, paramConstraint.startToEnd);
        continue;
        paramConstraint.startToStart = lookupID(paramTypedArray, k, paramConstraint.startToStart);
        continue;
        paramConstraint.endToStart = lookupID(paramTypedArray, k, paramConstraint.endToStart);
        continue;
        paramConstraint.endToEnd = lookupID(paramTypedArray, k, paramConstraint.endToEnd);
        continue;
        paramConstraint.circleConstraint = lookupID(paramTypedArray, k, paramConstraint.circleConstraint);
        continue;
        paramConstraint.circleRadius = paramTypedArray.getDimensionPixelSize(k, paramConstraint.circleRadius);
        continue;
        paramConstraint.circleAngle = paramTypedArray.getFloat(k, paramConstraint.circleAngle);
        continue;
        paramConstraint.goneLeftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneLeftMargin);
        continue;
        paramConstraint.goneTopMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneTopMargin);
        continue;
        paramConstraint.goneRightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneRightMargin);
        continue;
        paramConstraint.goneBottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneBottomMargin);
        continue;
        paramConstraint.goneStartMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneStartMargin);
        continue;
        paramConstraint.goneEndMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneEndMargin);
        continue;
        paramConstraint.horizontalBias = paramTypedArray.getFloat(k, paramConstraint.horizontalBias);
        continue;
        paramConstraint.verticalBias = paramTypedArray.getFloat(k, paramConstraint.verticalBias);
        continue;
        paramConstraint.leftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.leftMargin);
        continue;
        paramConstraint.rightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.rightMargin);
        continue;
        paramConstraint.startMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.startMargin);
        continue;
        paramConstraint.endMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.endMargin);
        continue;
        paramConstraint.topMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.topMargin);
        continue;
        paramConstraint.bottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.bottomMargin);
        continue;
        paramConstraint.mWidth = paramTypedArray.getLayoutDimension(k, paramConstraint.mWidth);
        continue;
        paramConstraint.mHeight = paramTypedArray.getLayoutDimension(k, paramConstraint.mHeight);
        continue;
        paramConstraint.visibility = paramTypedArray.getInt(k, paramConstraint.visibility);
        paramConstraint.visibility = VISIBILITY_FLAGS[paramConstraint.visibility];
        continue;
        paramConstraint.alpha = paramTypedArray.getFloat(k, paramConstraint.alpha);
        continue;
        paramConstraint.applyElevation = true;
        paramConstraint.elevation = paramTypedArray.getDimension(k, paramConstraint.elevation);
        continue;
        paramConstraint.rotation = paramTypedArray.getFloat(k, paramConstraint.rotation);
        continue;
        paramConstraint.rotationX = paramTypedArray.getFloat(k, paramConstraint.rotationX);
        continue;
        paramConstraint.rotationY = paramTypedArray.getFloat(k, paramConstraint.rotationY);
        continue;
        paramConstraint.scaleX = paramTypedArray.getFloat(k, paramConstraint.scaleX);
        continue;
        paramConstraint.scaleY = paramTypedArray.getFloat(k, paramConstraint.scaleY);
        continue;
        paramConstraint.transformPivotX = paramTypedArray.getFloat(k, paramConstraint.transformPivotX);
        continue;
        paramConstraint.transformPivotY = paramTypedArray.getFloat(k, paramConstraint.transformPivotY);
        continue;
        paramConstraint.translationX = paramTypedArray.getDimension(k, paramConstraint.translationX);
        continue;
        paramConstraint.translationY = paramTypedArray.getDimension(k, paramConstraint.translationY);
        continue;
        paramConstraint.translationZ = paramTypedArray.getDimension(k, paramConstraint.translationZ);
        continue;
        paramConstraint.verticalWeight = paramTypedArray.getFloat(k, paramConstraint.verticalWeight);
        continue;
        paramConstraint.horizontalWeight = paramTypedArray.getFloat(k, paramConstraint.horizontalWeight);
        continue;
        paramConstraint.verticalChainStyle = paramTypedArray.getInt(k, paramConstraint.verticalChainStyle);
        continue;
        paramConstraint.horizontalChainStyle = paramTypedArray.getInt(k, paramConstraint.horizontalChainStyle);
        continue;
        paramConstraint.mViewId = paramTypedArray.getResourceId(k, paramConstraint.mViewId);
        continue;
        paramConstraint.dimensionRatio = paramTypedArray.getString(k);
        continue;
        paramConstraint.widthPercent = paramTypedArray.getFloat(k, 1.0F);
        continue;
        paramConstraint.heightPercent = paramTypedArray.getFloat(k, 1.0F);
        continue;
        paramConstraint.mBarrierDirection = paramTypedArray.getInt(k, paramConstraint.mBarrierDirection);
        continue;
        paramConstraint.mReferenceIdString = paramTypedArray.getString(k);
        continue;
        paramConstraint.mBarrierAllowsGoneWidgets = paramTypedArray.getBoolean(k, paramConstraint.mBarrierAllowsGoneWidgets);
        continue;
        new StringBuilder("unused attribute 0x").append(Integer.toHexString(k)).append("   ").append(mapToConstant.get(k));
      }
    }
  }
  
  private String sideToString(int paramInt)
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
  
  public void addToHorizontalChain(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0)
    {
      i = 1;
      connect(paramInt1, 1, paramInt2, i, 0);
      if (paramInt3 != 0) {
        break label67;
      }
    }
    label67:
    for (int i = 2;; i = 1)
    {
      connect(paramInt1, 2, paramInt3, i, 0);
      if (paramInt2 != 0) {
        connect(paramInt2, 2, paramInt1, 1, 0);
      }
      if (paramInt3 != 0) {
        connect(paramInt3, 1, paramInt1, 2, 0);
      }
      return;
      i = 2;
      break;
    }
  }
  
  public void addToHorizontalChainRTL(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0)
    {
      i = 6;
      connect(paramInt1, 6, paramInt2, i, 0);
      if (paramInt3 != 0) {
        break label76;
      }
    }
    label76:
    for (int i = 7;; i = 6)
    {
      connect(paramInt1, 7, paramInt3, i, 0);
      if (paramInt2 != 0) {
        connect(paramInt2, 7, paramInt1, 6, 0);
      }
      if (paramInt3 != 0) {
        connect(paramInt3, 6, paramInt1, 7, 0);
      }
      return;
      i = 7;
      break;
    }
  }
  
  public void addToVerticalChain(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0)
    {
      i = 3;
      connect(paramInt1, 3, paramInt2, i, 0);
      if (paramInt3 != 0) {
        break label67;
      }
    }
    label67:
    for (int i = 4;; i = 3)
    {
      connect(paramInt1, 4, paramInt3, i, 0);
      if (paramInt2 != 0) {
        connect(paramInt2, 4, paramInt1, 3, 0);
      }
      if (paramInt2 != 0) {
        connect(paramInt3, 3, paramInt1, 4, 0);
      }
      return;
      i = 4;
      break;
    }
  }
  
  public void applyTo(ConstraintLayout paramConstraintLayout)
  {
    applyToInternal(paramConstraintLayout);
    paramConstraintLayout.setConstraintSet(null);
  }
  
  void applyToInternal(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    Object localObject1 = new HashSet(this.mConstraints.keySet());
    int i = 0;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (i < j)
    {
      localObject2 = paramConstraintLayout.getChildAt(i);
      int k = ((View)localObject2).getId();
      if (k == -1) {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
      if (this.mConstraints.containsKey(Integer.valueOf(k)))
      {
        ((HashSet)localObject1).remove(Integer.valueOf(k));
        localObject3 = (Constraint)this.mConstraints.get(Integer.valueOf(k));
        if ((localObject2 instanceof Barrier)) {
          ((Constraint)localObject3).mHelperType = 1;
        }
        if (((Constraint)localObject3).mHelperType != -1) {
          switch (((Constraint)localObject3).mHelperType)
          {
          }
        }
      }
      for (;;)
      {
        localObject4 = (ConstraintLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((Constraint)localObject3).applyTo((ConstraintLayout.LayoutParams)localObject4);
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((View)localObject2).setVisibility(((Constraint)localObject3).visibility);
        if (Build.VERSION.SDK_INT >= 17)
        {
          ((View)localObject2).setAlpha(((Constraint)localObject3).alpha);
          ((View)localObject2).setRotation(((Constraint)localObject3).rotation);
          ((View)localObject2).setRotationX(((Constraint)localObject3).rotationX);
          ((View)localObject2).setRotationY(((Constraint)localObject3).rotationY);
          ((View)localObject2).setScaleX(((Constraint)localObject3).scaleX);
          ((View)localObject2).setScaleY(((Constraint)localObject3).scaleY);
          if (!Float.isNaN(((Constraint)localObject3).transformPivotX)) {
            ((View)localObject2).setPivotX(((Constraint)localObject3).transformPivotX);
          }
          if (!Float.isNaN(((Constraint)localObject3).transformPivotY)) {
            ((View)localObject2).setPivotY(((Constraint)localObject3).transformPivotY);
          }
          ((View)localObject2).setTranslationX(((Constraint)localObject3).translationX);
          ((View)localObject2).setTranslationY(((Constraint)localObject3).translationY);
          if (Build.VERSION.SDK_INT >= 21)
          {
            ((View)localObject2).setTranslationZ(((Constraint)localObject3).translationZ);
            if (((Constraint)localObject3).applyElevation) {
              ((View)localObject2).setElevation(((Constraint)localObject3).elevation);
            }
          }
        }
        i += 1;
        break;
        localObject4 = (Barrier)localObject2;
        ((Barrier)localObject4).setId(k);
        ((Barrier)localObject4).setType(((Constraint)localObject3).mBarrierDirection);
        ((Barrier)localObject4).setAllowsGoneWidget(((Constraint)localObject3).mBarrierAllowsGoneWidgets);
        if (((Constraint)localObject3).mReferenceIds != null)
        {
          ((Barrier)localObject4).setReferencedIds(((Constraint)localObject3).mReferenceIds);
        }
        else if (((Constraint)localObject3).mReferenceIdString != null)
        {
          ((Constraint)localObject3).mReferenceIds = convertReferenceString((View)localObject4, ((Constraint)localObject3).mReferenceIdString);
          ((Barrier)localObject4).setReferencedIds(((Constraint)localObject3).mReferenceIds);
        }
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject1).next();
      localObject2 = (Constraint)this.mConstraints.get(localObject3);
      if (((Constraint)localObject2).mHelperType != -1) {}
      switch (((Constraint)localObject2).mHelperType)
      {
      default: 
        if (((Constraint)localObject2).mIsGuideline)
        {
          localObject4 = new Guideline(paramConstraintLayout.getContext());
          ((Guideline)localObject4).setId(((Integer)localObject3).intValue());
          localObject3 = paramConstraintLayout.generateDefaultLayoutParams();
          ((Constraint)localObject2).applyTo((ConstraintLayout.LayoutParams)localObject3);
          paramConstraintLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
        }
        break;
      case 1: 
        label524:
        localObject4 = new Barrier(paramConstraintLayout.getContext());
        ((Barrier)localObject4).setId(((Integer)localObject3).intValue());
        if (((Constraint)localObject2).mReferenceIds != null) {
          ((Barrier)localObject4).setReferencedIds(((Constraint)localObject2).mReferenceIds);
        }
        for (;;)
        {
          ((Barrier)localObject4).setType(((Constraint)localObject2).mBarrierDirection);
          ConstraintLayout.LayoutParams localLayoutParams = paramConstraintLayout.generateDefaultLayoutParams();
          ((Barrier)localObject4).validateParams();
          ((Constraint)localObject2).applyTo(localLayoutParams);
          paramConstraintLayout.addView((View)localObject4, localLayoutParams);
          break label524;
          break;
          if (((Constraint)localObject2).mReferenceIdString != null)
          {
            ((Constraint)localObject2).mReferenceIds = convertReferenceString((View)localObject4, ((Constraint)localObject2).mReferenceIdString);
            ((Barrier)localObject4).setReferencedIds(((Constraint)localObject2).mReferenceIds);
          }
        }
      }
    }
  }
  
  public void center(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    if (paramInt4 < 0) {
      throw new IllegalArgumentException("margin must be > 0");
    }
    if (paramInt7 < 0) {
      throw new IllegalArgumentException("margin must be > 0");
    }
    if ((paramFloat <= 0.0F) || (paramFloat > 1.0F)) {
      throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    }
    if ((paramInt3 == 1) || (paramInt3 == 2))
    {
      connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
      connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
      ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
      return;
    }
    if ((paramInt3 == 6) || (paramInt3 == 7))
    {
      connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
      connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
      ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
      return;
    }
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 1, 0, 0, 2, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 2, 0, paramInt2, 1, 0, 0.5F);
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 6, 0, 0, 7, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 7, 0, paramInt2, 6, 0, 0.5F);
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  public void centerVertically(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 3, 0, 0, 4, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 4, 0, paramInt2, 3, 0, 0.5F);
  }
  
  public void centerVertically(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
  }
  
  public void clear(int paramInt)
  {
    this.mConstraints.remove(Integer.valueOf(paramInt));
  }
  
  public void clear(int paramInt1, int paramInt2)
  {
    Constraint localConstraint;
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt1));
    }
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 1: 
      localConstraint.leftToRight = -1;
      localConstraint.leftToLeft = -1;
      localConstraint.leftMargin = -1;
      localConstraint.goneLeftMargin = -1;
      return;
    case 2: 
      localConstraint.rightToRight = -1;
      localConstraint.rightToLeft = -1;
      localConstraint.rightMargin = -1;
      localConstraint.goneRightMargin = -1;
      return;
    case 3: 
      localConstraint.topToBottom = -1;
      localConstraint.topToTop = -1;
      localConstraint.topMargin = -1;
      localConstraint.goneTopMargin = -1;
      return;
    case 4: 
      localConstraint.bottomToTop = -1;
      localConstraint.bottomToBottom = -1;
      localConstraint.bottomMargin = -1;
      localConstraint.goneBottomMargin = -1;
      return;
    case 5: 
      localConstraint.baselineToBaseline = -1;
      return;
    case 6: 
      localConstraint.startToEnd = -1;
      localConstraint.startToStart = -1;
      localConstraint.startMargin = -1;
      localConstraint.goneStartMargin = -1;
      return;
    }
    localConstraint.endToStart = -1;
    localConstraint.endToEnd = -1;
    localConstraint.endMargin = -1;
    localConstraint.goneEndMargin = -1;
  }
  
  public void clone(Context paramContext, int paramInt)
  {
    clone((ConstraintLayout)LayoutInflater.from(paramContext).inflate(paramInt, null));
  }
  
  public void clone(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    this.mConstraints.clear();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramConstraintLayout.getChildAt(i);
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)((View)localObject).getLayoutParams();
      int k = ((View)localObject).getId();
      if (k == -1) {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
      if (!this.mConstraints.containsKey(Integer.valueOf(k))) {
        this.mConstraints.put(Integer.valueOf(k), new Constraint(null));
      }
      Constraint localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(k));
      localConstraint.fillFrom(k, localLayoutParams);
      localConstraint.visibility = ((View)localObject).getVisibility();
      if (Build.VERSION.SDK_INT >= 17)
      {
        localConstraint.alpha = ((View)localObject).getAlpha();
        localConstraint.rotation = ((View)localObject).getRotation();
        localConstraint.rotationX = ((View)localObject).getRotationX();
        localConstraint.rotationY = ((View)localObject).getRotationY();
        localConstraint.scaleX = ((View)localObject).getScaleX();
        localConstraint.scaleY = ((View)localObject).getScaleY();
        float f1 = ((View)localObject).getPivotX();
        float f2 = ((View)localObject).getPivotY();
        if ((f1 != 0.0D) || (f2 != 0.0D))
        {
          localConstraint.transformPivotX = f1;
          localConstraint.transformPivotY = f2;
        }
        localConstraint.translationX = ((View)localObject).getTranslationX();
        localConstraint.translationY = ((View)localObject).getTranslationY();
        if (Build.VERSION.SDK_INT >= 21)
        {
          localConstraint.translationZ = ((View)localObject).getTranslationZ();
          if (localConstraint.applyElevation) {
            localConstraint.elevation = ((View)localObject).getElevation();
          }
        }
      }
      if ((localObject instanceof Barrier))
      {
        localObject = (Barrier)localObject;
        localConstraint.mBarrierAllowsGoneWidgets = ((Barrier)localObject).allowsGoneWidget();
        localConstraint.mReferenceIds = ((Barrier)localObject).getReferencedIds();
        localConstraint.mBarrierDirection = ((Barrier)localObject).getType();
      }
      i += 1;
    }
  }
  
  public void clone(ConstraintSet paramConstraintSet)
  {
    this.mConstraints.clear();
    Iterator localIterator = paramConstraintSet.mConstraints.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.mConstraints.put(localInteger, ((Constraint)paramConstraintSet.mConstraints.get(localInteger)).clone());
    }
  }
  
  public void clone(Constraints paramConstraints)
  {
    int j = paramConstraints.getChildCount();
    this.mConstraints.clear();
    int i = 0;
    while (i < j)
    {
      View localView = paramConstraints.getChildAt(i);
      Constraints.LayoutParams localLayoutParams = (Constraints.LayoutParams)localView.getLayoutParams();
      int k = localView.getId();
      if (k == -1) {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
      if (!this.mConstraints.containsKey(Integer.valueOf(k))) {
        this.mConstraints.put(Integer.valueOf(k), new Constraint(null));
      }
      Constraint localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(k));
      if ((localView instanceof ConstraintHelper)) {
        localConstraint.fillFromConstraints((ConstraintHelper)localView, k, localLayoutParams);
      }
      localConstraint.fillFromConstraints(k, localLayoutParams);
      i += 1;
    }
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      this.mConstraints.put(Integer.valueOf(paramInt1), new Constraint(null));
    }
    Constraint localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException(sideToString(paramInt2) + " to " + sideToString(paramInt4) + " unknown");
    case 1: 
      if (paramInt4 == 1)
      {
        localConstraint.leftToLeft = paramInt3;
        localConstraint.leftToRight = -1;
        return;
      }
      if (paramInt4 == 2)
      {
        localConstraint.leftToRight = paramInt3;
        localConstraint.leftToLeft = -1;
        return;
      }
      throw new IllegalArgumentException("left to " + sideToString(paramInt4) + " undefined");
    case 2: 
      if (paramInt4 == 1)
      {
        localConstraint.rightToLeft = paramInt3;
        localConstraint.rightToRight = -1;
        return;
      }
      if (paramInt4 == 2)
      {
        localConstraint.rightToRight = paramInt3;
        localConstraint.rightToLeft = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 3: 
      if (paramInt4 == 3)
      {
        localConstraint.topToTop = paramInt3;
        localConstraint.topToBottom = -1;
        localConstraint.baselineToBaseline = -1;
        return;
      }
      if (paramInt4 == 4)
      {
        localConstraint.topToBottom = paramInt3;
        localConstraint.topToTop = -1;
        localConstraint.baselineToBaseline = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 4: 
      if (paramInt4 == 4)
      {
        localConstraint.bottomToBottom = paramInt3;
        localConstraint.bottomToTop = -1;
        localConstraint.baselineToBaseline = -1;
        return;
      }
      if (paramInt4 == 3)
      {
        localConstraint.bottomToTop = paramInt3;
        localConstraint.bottomToBottom = -1;
        localConstraint.baselineToBaseline = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 5: 
      if (paramInt4 == 5)
      {
        localConstraint.baselineToBaseline = paramInt3;
        localConstraint.bottomToBottom = -1;
        localConstraint.bottomToTop = -1;
        localConstraint.topToTop = -1;
        localConstraint.topToBottom = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 6: 
      if (paramInt4 == 6)
      {
        localConstraint.startToStart = paramInt3;
        localConstraint.startToEnd = -1;
        return;
      }
      if (paramInt4 == 7)
      {
        localConstraint.startToEnd = paramInt3;
        localConstraint.startToStart = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    }
    if (paramInt4 == 7)
    {
      localConstraint.endToEnd = paramInt3;
      localConstraint.endToStart = -1;
      return;
    }
    if (paramInt4 == 6)
    {
      localConstraint.endToStart = paramInt3;
      localConstraint.endToEnd = -1;
      return;
    }
    throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      this.mConstraints.put(Integer.valueOf(paramInt1), new Constraint(null));
    }
    Constraint localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException(sideToString(paramInt2) + " to " + sideToString(paramInt4) + " unknown");
    case 1: 
      if (paramInt4 == 1)
      {
        localConstraint.leftToLeft = paramInt3;
        localConstraint.leftToRight = -1;
      }
      for (;;)
      {
        localConstraint.leftMargin = paramInt5;
        return;
        if (paramInt4 != 2) {
          break;
        }
        localConstraint.leftToRight = paramInt3;
        localConstraint.leftToLeft = -1;
      }
      throw new IllegalArgumentException("Left to " + sideToString(paramInt4) + " undefined");
    case 2: 
      if (paramInt4 == 1)
      {
        localConstraint.rightToLeft = paramInt3;
        localConstraint.rightToRight = -1;
      }
      for (;;)
      {
        localConstraint.rightMargin = paramInt5;
        return;
        if (paramInt4 != 2) {
          break;
        }
        localConstraint.rightToRight = paramInt3;
        localConstraint.rightToLeft = -1;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 3: 
      if (paramInt4 == 3)
      {
        localConstraint.topToTop = paramInt3;
        localConstraint.topToBottom = -1;
      }
      for (localConstraint.baselineToBaseline = -1;; localConstraint.baselineToBaseline = -1)
      {
        localConstraint.topMargin = paramInt5;
        return;
        if (paramInt4 != 4) {
          break;
        }
        localConstraint.topToBottom = paramInt3;
        localConstraint.topToTop = -1;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 4: 
      if (paramInt4 == 4)
      {
        localConstraint.bottomToBottom = paramInt3;
        localConstraint.bottomToTop = -1;
      }
      for (localConstraint.baselineToBaseline = -1;; localConstraint.baselineToBaseline = -1)
      {
        localConstraint.bottomMargin = paramInt5;
        return;
        if (paramInt4 != 3) {
          break;
        }
        localConstraint.bottomToTop = paramInt3;
        localConstraint.bottomToBottom = -1;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 5: 
      if (paramInt4 == 5)
      {
        localConstraint.baselineToBaseline = paramInt3;
        localConstraint.bottomToBottom = -1;
        localConstraint.bottomToTop = -1;
        localConstraint.topToTop = -1;
        localConstraint.topToBottom = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 6: 
      if (paramInt4 == 6)
      {
        localConstraint.startToStart = paramInt3;
        localConstraint.startToEnd = -1;
      }
      for (;;)
      {
        localConstraint.startMargin = paramInt5;
        return;
        if (paramInt4 != 7) {
          break;
        }
        localConstraint.startToEnd = paramInt3;
        localConstraint.startToStart = -1;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    }
    if (paramInt4 == 7)
    {
      localConstraint.endToEnd = paramInt3;
      localConstraint.endToStart = -1;
    }
    for (;;)
    {
      localConstraint.endMargin = paramInt5;
      return;
      if (paramInt4 != 6) {
        break;
      }
      localConstraint.endToStart = paramInt3;
      localConstraint.endToEnd = -1;
    }
    throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
  }
  
  public void constrainCircle(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    Constraint localConstraint = get(paramInt1);
    localConstraint.circleConstraint = paramInt2;
    localConstraint.circleRadius = paramInt3;
    localConstraint.circleAngle = paramFloat;
  }
  
  public void constrainDefaultHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).heightDefault = paramInt2;
  }
  
  public void constrainDefaultWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).widthDefault = paramInt2;
  }
  
  public void constrainHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).mHeight = paramInt2;
  }
  
  public void constrainMaxHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).heightMax = paramInt2;
  }
  
  public void constrainMaxWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).widthMax = paramInt2;
  }
  
  public void constrainMinHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).heightMin = paramInt2;
  }
  
  public void constrainMinWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).widthMin = paramInt2;
  }
  
  public void constrainPercentHeight(int paramInt, float paramFloat)
  {
    get(paramInt).heightPercent = paramFloat;
  }
  
  public void constrainPercentWidth(int paramInt, float paramFloat)
  {
    get(paramInt).widthPercent = paramFloat;
  }
  
  public void constrainWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).mWidth = paramInt2;
  }
  
  public void create(int paramInt1, int paramInt2)
  {
    Constraint localConstraint = get(paramInt1);
    localConstraint.mIsGuideline = true;
    localConstraint.orientation = paramInt2;
  }
  
  public void createBarrier(int paramInt1, int paramInt2, int... paramVarArgs)
  {
    Constraint localConstraint = get(paramInt1);
    localConstraint.mHelperType = 1;
    localConstraint.mBarrierDirection = paramInt2;
    localConstraint.mIsGuideline = false;
    localConstraint.mReferenceIds = paramVarArgs;
  }
  
  public void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    createHorizontalChain(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfFloat, paramInt5, 1, 2);
  }
  
  public void createHorizontalChainRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    createHorizontalChain(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfFloat, paramInt5, 6, 7);
  }
  
  public void createVerticalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    if (paramArrayOfInt.length < 2) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if (paramArrayOfFloat != null) {
      get(paramArrayOfInt[0]).verticalWeight = paramArrayOfFloat[0];
    }
    get(paramArrayOfInt[0]).verticalChainStyle = paramInt5;
    connect(paramArrayOfInt[0], 3, paramInt1, paramInt2, 0);
    paramInt1 = 1;
    while (paramInt1 < paramArrayOfInt.length)
    {
      connect(paramArrayOfInt[paramInt1], 3, paramArrayOfInt[(paramInt1 - 1)], 4, 0);
      connect(paramArrayOfInt[(paramInt1 - 1)], 4, paramArrayOfInt[paramInt1], 3, 0);
      if (paramArrayOfFloat != null) {
        get(paramArrayOfInt[paramInt1]).verticalWeight = paramArrayOfFloat[paramInt1];
      }
      paramInt1 += 1;
    }
    connect(paramArrayOfInt[(paramArrayOfInt.length - 1)], 4, paramInt3, paramInt4, 0);
  }
  
  public boolean getApplyElevation(int paramInt)
  {
    return get(paramInt).applyElevation;
  }
  
  public Constraint getParameters(int paramInt)
  {
    return get(paramInt);
  }
  
  public void load(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    for (;;)
    {
      try
      {
        paramInt = localXmlResourceParser.getEventType();
      }
      catch (IOException paramContext)
      {
        String str;
        Constraint localConstraint;
        return;
        if (paramInt == 1) {
          return;
        }
        switch (paramInt)
        {
        }
        continue;
      }
      catch (XmlPullParserException paramContext) {}
      paramInt = localXmlResourceParser.next();
      continue;
      localXmlResourceParser.getName();
      continue;
      str = localXmlResourceParser.getName();
      localConstraint = fillFromAttributeList(paramContext, Xml.asAttributeSet(localXmlResourceParser));
      if (str.equalsIgnoreCase("Guideline")) {
        localConstraint.mIsGuideline = true;
      }
      this.mConstraints.put(Integer.valueOf(localConstraint.mViewId), localConstraint);
    }
  }
  
  public void removeFromHorizontalChain(int paramInt)
  {
    Constraint localConstraint;
    int i;
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt)))
    {
      localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
      i = localConstraint.leftToRight;
      j = localConstraint.rightToLeft;
      if ((i == -1) && (j == -1)) {
        break label153;
      }
      if ((i == -1) || (j == -1)) {
        break label93;
      }
      connect(i, 2, j, 1, 0);
      connect(j, 1, i, 2, 0);
    }
    for (;;)
    {
      clear(paramInt, 1);
      clear(paramInt, 2);
      return;
      label93:
      if ((i != -1) || (j != -1)) {
        if (localConstraint.rightToRight != -1) {
          connect(i, 2, localConstraint.rightToRight, 2, 0);
        } else if (localConstraint.leftToLeft != -1) {
          connect(j, 1, localConstraint.leftToLeft, 1, 0);
        }
      }
    }
    label153:
    int j = localConstraint.startToEnd;
    int k = localConstraint.endToStart;
    if ((j != -1) || (k != -1))
    {
      if ((j == -1) || (k == -1)) {
        break label227;
      }
      connect(j, 7, k, 6, 0);
      connect(k, 6, i, 7, 0);
    }
    for (;;)
    {
      clear(paramInt, 6);
      clear(paramInt, 7);
      return;
      label227:
      if ((i != -1) || (k != -1)) {
        if (localConstraint.rightToRight != -1) {
          connect(i, 7, localConstraint.rightToRight, 7, 0);
        } else if (localConstraint.leftToLeft != -1) {
          connect(k, 6, localConstraint.leftToLeft, 6, 0);
        }
      }
    }
  }
  
  public void removeFromVerticalChain(int paramInt)
  {
    Constraint localConstraint;
    int i;
    int j;
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt)))
    {
      localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
      i = localConstraint.topToBottom;
      j = localConstraint.bottomToTop;
      if ((i != -1) || (j != -1))
      {
        if ((i == -1) || (j == -1)) {
          break label93;
        }
        connect(i, 4, j, 3, 0);
        connect(j, 3, i, 4, 0);
      }
    }
    for (;;)
    {
      clear(paramInt, 3);
      clear(paramInt, 4);
      return;
      label93:
      if ((i != -1) || (j != -1)) {
        if (localConstraint.bottomToBottom != -1) {
          connect(i, 4, localConstraint.bottomToBottom, 4, 0);
        } else if (localConstraint.topToTop != -1) {
          connect(j, 3, localConstraint.topToTop, 3, 0);
        }
      }
    }
  }
  
  public void setAlpha(int paramInt, float paramFloat)
  {
    get(paramInt).alpha = paramFloat;
  }
  
  public void setApplyElevation(int paramInt, boolean paramBoolean)
  {
    get(paramInt).applyElevation = paramBoolean;
  }
  
  public void setBarrierType(int paramInt1, int paramInt2) {}
  
  public void setDimensionRatio(int paramInt, String paramString)
  {
    get(paramInt).dimensionRatio = paramString;
  }
  
  public void setElevation(int paramInt, float paramFloat)
  {
    get(paramInt).elevation = paramFloat;
    get(paramInt).applyElevation = true;
  }
  
  public void setGoneMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    Constraint localConstraint = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 1: 
      localConstraint.goneLeftMargin = paramInt3;
      return;
    case 2: 
      localConstraint.goneRightMargin = paramInt3;
      return;
    case 3: 
      localConstraint.goneTopMargin = paramInt3;
      return;
    case 4: 
      localConstraint.goneBottomMargin = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 6: 
      localConstraint.goneStartMargin = paramInt3;
      return;
    }
    localConstraint.goneEndMargin = paramInt3;
  }
  
  public void setGuidelineBegin(int paramInt1, int paramInt2)
  {
    get(paramInt1).guideBegin = paramInt2;
    get(paramInt1).guideEnd = -1;
    get(paramInt1).guidePercent = -1.0F;
  }
  
  public void setGuidelineEnd(int paramInt1, int paramInt2)
  {
    get(paramInt1).guideEnd = paramInt2;
    get(paramInt1).guideBegin = -1;
    get(paramInt1).guidePercent = -1.0F;
  }
  
  public void setGuidelinePercent(int paramInt, float paramFloat)
  {
    get(paramInt).guidePercent = paramFloat;
    get(paramInt).guideEnd = -1;
    get(paramInt).guideBegin = -1;
  }
  
  public void setHorizontalBias(int paramInt, float paramFloat)
  {
    get(paramInt).horizontalBias = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt1, int paramInt2)
  {
    get(paramInt1).horizontalChainStyle = paramInt2;
  }
  
  public void setHorizontalWeight(int paramInt, float paramFloat)
  {
    get(paramInt).horizontalWeight = paramFloat;
  }
  
  public void setMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    Constraint localConstraint = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 1: 
      localConstraint.leftMargin = paramInt3;
      return;
    case 2: 
      localConstraint.rightMargin = paramInt3;
      return;
    case 3: 
      localConstraint.topMargin = paramInt3;
      return;
    case 4: 
      localConstraint.bottomMargin = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 6: 
      localConstraint.startMargin = paramInt3;
      return;
    }
    localConstraint.endMargin = paramInt3;
  }
  
  public void setRotation(int paramInt, float paramFloat)
  {
    get(paramInt).rotation = paramFloat;
  }
  
  public void setRotationX(int paramInt, float paramFloat)
  {
    get(paramInt).rotationX = paramFloat;
  }
  
  public void setRotationY(int paramInt, float paramFloat)
  {
    get(paramInt).rotationY = paramFloat;
  }
  
  public void setScaleX(int paramInt, float paramFloat)
  {
    get(paramInt).scaleX = paramFloat;
  }
  
  public void setScaleY(int paramInt, float paramFloat)
  {
    get(paramInt).scaleY = paramFloat;
  }
  
  public void setTransformPivot(int paramInt, float paramFloat1, float paramFloat2)
  {
    Constraint localConstraint = get(paramInt);
    localConstraint.transformPivotY = paramFloat2;
    localConstraint.transformPivotX = paramFloat1;
  }
  
  public void setTransformPivotX(int paramInt, float paramFloat)
  {
    get(paramInt).transformPivotX = paramFloat;
  }
  
  public void setTransformPivotY(int paramInt, float paramFloat)
  {
    get(paramInt).transformPivotY = paramFloat;
  }
  
  public void setTranslation(int paramInt, float paramFloat1, float paramFloat2)
  {
    Constraint localConstraint = get(paramInt);
    localConstraint.translationX = paramFloat1;
    localConstraint.translationY = paramFloat2;
  }
  
  public void setTranslationX(int paramInt, float paramFloat)
  {
    get(paramInt).translationX = paramFloat;
  }
  
  public void setTranslationY(int paramInt, float paramFloat)
  {
    get(paramInt).translationY = paramFloat;
  }
  
  public void setTranslationZ(int paramInt, float paramFloat)
  {
    get(paramInt).translationZ = paramFloat;
  }
  
  public void setVerticalBias(int paramInt, float paramFloat)
  {
    get(paramInt).verticalBias = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt1, int paramInt2)
  {
    get(paramInt1).verticalChainStyle = paramInt2;
  }
  
  public void setVerticalWeight(int paramInt, float paramFloat)
  {
    get(paramInt).verticalWeight = paramFloat;
  }
  
  public void setVisibility(int paramInt1, int paramInt2)
  {
    get(paramInt1).visibility = paramInt2;
  }
  
  static class Constraint
  {
    static final int UNSET = -1;
    public float alpha = 1.0F;
    public boolean applyElevation = false;
    public int baselineToBaseline = -1;
    public int bottomMargin = -1;
    public int bottomToBottom = -1;
    public int bottomToTop = -1;
    public float circleAngle = 0.0F;
    public int circleConstraint = -1;
    public int circleRadius = 0;
    public boolean constrainedHeight = false;
    public boolean constrainedWidth = false;
    public String dimensionRatio = null;
    public int editorAbsoluteX = -1;
    public int editorAbsoluteY = -1;
    public float elevation = 0.0F;
    public int endMargin = -1;
    public int endToEnd = -1;
    public int endToStart = -1;
    public int goneBottomMargin = -1;
    public int goneEndMargin = -1;
    public int goneLeftMargin = -1;
    public int goneRightMargin = -1;
    public int goneStartMargin = -1;
    public int goneTopMargin = -1;
    public int guideBegin = -1;
    public int guideEnd = -1;
    public float guidePercent = -1.0F;
    public int heightDefault = 0;
    public int heightMax = -1;
    public int heightMin = -1;
    public float heightPercent = 1.0F;
    public float horizontalBias = 0.5F;
    public int horizontalChainStyle = 0;
    public float horizontalWeight = 0.0F;
    public int leftMargin = -1;
    public int leftToLeft = -1;
    public int leftToRight = -1;
    public boolean mBarrierAllowsGoneWidgets = false;
    public int mBarrierDirection = -1;
    public int mHeight;
    public int mHelperType = -1;
    boolean mIsGuideline = false;
    public String mReferenceIdString;
    public int[] mReferenceIds;
    int mViewId;
    public int mWidth;
    public int orientation = -1;
    public int rightMargin = -1;
    public int rightToLeft = -1;
    public int rightToRight = -1;
    public float rotation = 0.0F;
    public float rotationX = 0.0F;
    public float rotationY = 0.0F;
    public float scaleX = 1.0F;
    public float scaleY = 1.0F;
    public int startMargin = -1;
    public int startToEnd = -1;
    public int startToStart = -1;
    public int topMargin = -1;
    public int topToBottom = -1;
    public int topToTop = -1;
    public float transformPivotX = (0.0F / 0.0F);
    public float transformPivotY = (0.0F / 0.0F);
    public float translationX = 0.0F;
    public float translationY = 0.0F;
    public float translationZ = 0.0F;
    public float verticalBias = 0.5F;
    public int verticalChainStyle = 0;
    public float verticalWeight = 0.0F;
    public int visibility = 0;
    public int widthDefault = 0;
    public int widthMax = -1;
    public int widthMin = -1;
    public float widthPercent = 1.0F;
    
    private void fillFrom(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
    {
      this.mViewId = paramInt;
      this.leftToLeft = paramLayoutParams.leftToLeft;
      this.leftToRight = paramLayoutParams.leftToRight;
      this.rightToLeft = paramLayoutParams.rightToLeft;
      this.rightToRight = paramLayoutParams.rightToRight;
      this.topToTop = paramLayoutParams.topToTop;
      this.topToBottom = paramLayoutParams.topToBottom;
      this.bottomToTop = paramLayoutParams.bottomToTop;
      this.bottomToBottom = paramLayoutParams.bottomToBottom;
      this.baselineToBaseline = paramLayoutParams.baselineToBaseline;
      this.startToEnd = paramLayoutParams.startToEnd;
      this.startToStart = paramLayoutParams.startToStart;
      this.endToStart = paramLayoutParams.endToStart;
      this.endToEnd = paramLayoutParams.endToEnd;
      this.horizontalBias = paramLayoutParams.horizontalBias;
      this.verticalBias = paramLayoutParams.verticalBias;
      this.dimensionRatio = paramLayoutParams.dimensionRatio;
      this.circleConstraint = paramLayoutParams.circleConstraint;
      this.circleRadius = paramLayoutParams.circleRadius;
      this.circleAngle = paramLayoutParams.circleAngle;
      this.editorAbsoluteX = paramLayoutParams.editorAbsoluteX;
      this.editorAbsoluteY = paramLayoutParams.editorAbsoluteY;
      this.orientation = paramLayoutParams.orientation;
      this.guidePercent = paramLayoutParams.guidePercent;
      this.guideBegin = paramLayoutParams.guideBegin;
      this.guideEnd = paramLayoutParams.guideEnd;
      this.mWidth = paramLayoutParams.width;
      this.mHeight = paramLayoutParams.height;
      this.leftMargin = paramLayoutParams.leftMargin;
      this.rightMargin = paramLayoutParams.rightMargin;
      this.topMargin = paramLayoutParams.topMargin;
      this.bottomMargin = paramLayoutParams.bottomMargin;
      this.verticalWeight = paramLayoutParams.verticalWeight;
      this.horizontalWeight = paramLayoutParams.horizontalWeight;
      this.verticalChainStyle = paramLayoutParams.verticalChainStyle;
      this.horizontalChainStyle = paramLayoutParams.horizontalChainStyle;
      this.constrainedWidth = paramLayoutParams.constrainedWidth;
      this.constrainedHeight = paramLayoutParams.constrainedHeight;
      this.widthDefault = paramLayoutParams.matchConstraintDefaultWidth;
      this.heightDefault = paramLayoutParams.matchConstraintDefaultHeight;
      this.constrainedWidth = paramLayoutParams.constrainedWidth;
      this.widthMax = paramLayoutParams.matchConstraintMaxWidth;
      this.heightMax = paramLayoutParams.matchConstraintMaxHeight;
      this.widthMin = paramLayoutParams.matchConstraintMinWidth;
      this.heightMin = paramLayoutParams.matchConstraintMinHeight;
      this.widthPercent = paramLayoutParams.matchConstraintPercentWidth;
      this.heightPercent = paramLayoutParams.matchConstraintPercentHeight;
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.endMargin = paramLayoutParams.getMarginEnd();
        this.startMargin = paramLayoutParams.getMarginStart();
      }
    }
    
    private void fillFromConstraints(int paramInt, Constraints.LayoutParams paramLayoutParams)
    {
      fillFrom(paramInt, paramLayoutParams);
      this.alpha = paramLayoutParams.alpha;
      this.rotation = paramLayoutParams.rotation;
      this.rotationX = paramLayoutParams.rotationX;
      this.rotationY = paramLayoutParams.rotationY;
      this.scaleX = paramLayoutParams.scaleX;
      this.scaleY = paramLayoutParams.scaleY;
      this.transformPivotX = paramLayoutParams.transformPivotX;
      this.transformPivotY = paramLayoutParams.transformPivotY;
      this.translationX = paramLayoutParams.translationX;
      this.translationY = paramLayoutParams.translationY;
      this.translationZ = paramLayoutParams.translationZ;
      this.elevation = paramLayoutParams.elevation;
      this.applyElevation = paramLayoutParams.applyElevation;
    }
    
    private void fillFromConstraints(ConstraintHelper paramConstraintHelper, int paramInt, Constraints.LayoutParams paramLayoutParams)
    {
      fillFromConstraints(paramInt, paramLayoutParams);
      if ((paramConstraintHelper instanceof Barrier))
      {
        this.mHelperType = 1;
        paramConstraintHelper = (Barrier)paramConstraintHelper;
        this.mBarrierDirection = paramConstraintHelper.getType();
        this.mReferenceIds = paramConstraintHelper.getReferencedIds();
      }
    }
    
    public void applyTo(ConstraintLayout.LayoutParams paramLayoutParams)
    {
      paramLayoutParams.leftToLeft = this.leftToLeft;
      paramLayoutParams.leftToRight = this.leftToRight;
      paramLayoutParams.rightToLeft = this.rightToLeft;
      paramLayoutParams.rightToRight = this.rightToRight;
      paramLayoutParams.topToTop = this.topToTop;
      paramLayoutParams.topToBottom = this.topToBottom;
      paramLayoutParams.bottomToTop = this.bottomToTop;
      paramLayoutParams.bottomToBottom = this.bottomToBottom;
      paramLayoutParams.baselineToBaseline = this.baselineToBaseline;
      paramLayoutParams.startToEnd = this.startToEnd;
      paramLayoutParams.startToStart = this.startToStart;
      paramLayoutParams.endToStart = this.endToStart;
      paramLayoutParams.endToEnd = this.endToEnd;
      paramLayoutParams.leftMargin = this.leftMargin;
      paramLayoutParams.rightMargin = this.rightMargin;
      paramLayoutParams.topMargin = this.topMargin;
      paramLayoutParams.bottomMargin = this.bottomMargin;
      paramLayoutParams.goneStartMargin = this.goneStartMargin;
      paramLayoutParams.goneEndMargin = this.goneEndMargin;
      paramLayoutParams.horizontalBias = this.horizontalBias;
      paramLayoutParams.verticalBias = this.verticalBias;
      paramLayoutParams.circleConstraint = this.circleConstraint;
      paramLayoutParams.circleRadius = this.circleRadius;
      paramLayoutParams.circleAngle = this.circleAngle;
      paramLayoutParams.dimensionRatio = this.dimensionRatio;
      paramLayoutParams.editorAbsoluteX = this.editorAbsoluteX;
      paramLayoutParams.editorAbsoluteY = this.editorAbsoluteY;
      paramLayoutParams.verticalWeight = this.verticalWeight;
      paramLayoutParams.horizontalWeight = this.horizontalWeight;
      paramLayoutParams.verticalChainStyle = this.verticalChainStyle;
      paramLayoutParams.horizontalChainStyle = this.horizontalChainStyle;
      paramLayoutParams.constrainedWidth = this.constrainedWidth;
      paramLayoutParams.constrainedHeight = this.constrainedHeight;
      paramLayoutParams.matchConstraintDefaultWidth = this.widthDefault;
      paramLayoutParams.matchConstraintDefaultHeight = this.heightDefault;
      paramLayoutParams.matchConstraintMaxWidth = this.widthMax;
      paramLayoutParams.matchConstraintMaxHeight = this.heightMax;
      paramLayoutParams.matchConstraintMinWidth = this.widthMin;
      paramLayoutParams.matchConstraintMinHeight = this.heightMin;
      paramLayoutParams.matchConstraintPercentWidth = this.widthPercent;
      paramLayoutParams.matchConstraintPercentHeight = this.heightPercent;
      paramLayoutParams.orientation = this.orientation;
      paramLayoutParams.guidePercent = this.guidePercent;
      paramLayoutParams.guideBegin = this.guideBegin;
      paramLayoutParams.guideEnd = this.guideEnd;
      paramLayoutParams.width = this.mWidth;
      paramLayoutParams.height = this.mHeight;
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramLayoutParams.setMarginStart(this.startMargin);
        paramLayoutParams.setMarginEnd(this.endMargin);
      }
      paramLayoutParams.validate();
    }
    
    public Constraint clone()
    {
      Constraint localConstraint = new Constraint();
      localConstraint.mIsGuideline = this.mIsGuideline;
      localConstraint.mWidth = this.mWidth;
      localConstraint.mHeight = this.mHeight;
      localConstraint.guideBegin = this.guideBegin;
      localConstraint.guideEnd = this.guideEnd;
      localConstraint.guidePercent = this.guidePercent;
      localConstraint.leftToLeft = this.leftToLeft;
      localConstraint.leftToRight = this.leftToRight;
      localConstraint.rightToLeft = this.rightToLeft;
      localConstraint.rightToRight = this.rightToRight;
      localConstraint.topToTop = this.topToTop;
      localConstraint.topToBottom = this.topToBottom;
      localConstraint.bottomToTop = this.bottomToTop;
      localConstraint.bottomToBottom = this.bottomToBottom;
      localConstraint.baselineToBaseline = this.baselineToBaseline;
      localConstraint.startToEnd = this.startToEnd;
      localConstraint.startToStart = this.startToStart;
      localConstraint.endToStart = this.endToStart;
      localConstraint.endToEnd = this.endToEnd;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.verticalBias = this.verticalBias;
      localConstraint.dimensionRatio = this.dimensionRatio;
      localConstraint.editorAbsoluteX = this.editorAbsoluteX;
      localConstraint.editorAbsoluteY = this.editorAbsoluteY;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.orientation = this.orientation;
      localConstraint.leftMargin = this.leftMargin;
      localConstraint.rightMargin = this.rightMargin;
      localConstraint.topMargin = this.topMargin;
      localConstraint.bottomMargin = this.bottomMargin;
      localConstraint.endMargin = this.endMargin;
      localConstraint.startMargin = this.startMargin;
      localConstraint.visibility = this.visibility;
      localConstraint.goneLeftMargin = this.goneLeftMargin;
      localConstraint.goneTopMargin = this.goneTopMargin;
      localConstraint.goneRightMargin = this.goneRightMargin;
      localConstraint.goneBottomMargin = this.goneBottomMargin;
      localConstraint.goneEndMargin = this.goneEndMargin;
      localConstraint.goneStartMargin = this.goneStartMargin;
      localConstraint.verticalWeight = this.verticalWeight;
      localConstraint.horizontalWeight = this.horizontalWeight;
      localConstraint.horizontalChainStyle = this.horizontalChainStyle;
      localConstraint.verticalChainStyle = this.verticalChainStyle;
      localConstraint.alpha = this.alpha;
      localConstraint.applyElevation = this.applyElevation;
      localConstraint.elevation = this.elevation;
      localConstraint.rotation = this.rotation;
      localConstraint.rotationX = this.rotationX;
      localConstraint.rotationY = this.rotationY;
      localConstraint.scaleX = this.scaleX;
      localConstraint.scaleY = this.scaleY;
      localConstraint.transformPivotX = this.transformPivotX;
      localConstraint.transformPivotY = this.transformPivotY;
      localConstraint.translationX = this.translationX;
      localConstraint.translationY = this.translationY;
      localConstraint.translationZ = this.translationZ;
      localConstraint.constrainedWidth = this.constrainedWidth;
      localConstraint.constrainedHeight = this.constrainedHeight;
      localConstraint.widthDefault = this.widthDefault;
      localConstraint.heightDefault = this.heightDefault;
      localConstraint.widthMax = this.widthMax;
      localConstraint.heightMax = this.heightMax;
      localConstraint.widthMin = this.widthMin;
      localConstraint.heightMin = this.heightMin;
      localConstraint.widthPercent = this.widthPercent;
      localConstraint.heightPercent = this.heightPercent;
      localConstraint.mBarrierDirection = this.mBarrierDirection;
      localConstraint.mHelperType = this.mHelperType;
      if (this.mReferenceIds != null) {
        localConstraint.mReferenceIds = Arrays.copyOf(this.mReferenceIds, this.mReferenceIds.length);
      }
      localConstraint.circleConstraint = this.circleConstraint;
      localConstraint.circleRadius = this.circleRadius;
      localConstraint.circleAngle = this.circleAngle;
      localConstraint.mBarrierAllowsGoneWidgets = this.mBarrierAllowsGoneWidgets;
      return localConstraint;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.ConstraintSet
 * JD-Core Version:    0.7.0.1
 */