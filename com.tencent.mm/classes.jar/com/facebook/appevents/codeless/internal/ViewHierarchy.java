package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.j;
import android.util.Base64;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewHierarchy
{
  private static final int ADAPTER_VIEW_ITEM_BITMASK = 9;
  private static final int BUTTON_BITMASK = 2;
  private static final int CHECKBOX_BITMASK = 15;
  private static final String CHILDREN_VIEW_KEY = "childviews";
  private static final String CLASS_NAME_KEY = "classname";
  private static final String CLASS_TYPE_BITMASK_KEY = "classtypebitmask";
  private static final int CLICKABLE_VIEW_BITMASK = 5;
  private static final String DESC_KEY = "description";
  private static final String DIMENSION_HEIGHT_KEY = "height";
  private static final String DIMENSION_KEY = "dimension";
  private static final String DIMENSION_LEFT_KEY = "left";
  private static final String DIMENSION_SCROLL_X_KEY = "scrollx";
  private static final String DIMENSION_SCROLL_Y_KEY = "scrolly";
  private static final String DIMENSION_TOP_KEY = "top";
  private static final String DIMENSION_VISIBILITY_KEY = "visibility";
  private static final String DIMENSION_WIDTH_KEY = "width";
  private static final String GET_ACCESSIBILITY_METHOD = "getAccessibilityDelegate";
  private static final String HINT_KEY = "hint";
  private static final String ICON_BITMAP = "icon_image";
  private static final int ICON_MAX_EDGE_LENGTH = 44;
  private static final String ID_KEY = "id";
  private static final int IMAGEVIEW_BITMASK = 1;
  private static final int INPUT_BITMASK = 11;
  private static final int LABEL_BITMASK = 10;
  private static final int PICKER_BITMASK = 12;
  private static final int RADIO_GROUP_BITMASK = 14;
  private static final int RATINGBAR_BITMASK = 16;
  private static final int REACT_NATIVE_BUTTON_BITMASK = 6;
  private static final int SWITCH_BITMASK = 13;
  private static final String TAG;
  private static final String TAG_KEY = "tag";
  private static final int TEXTVIEW_BITMASK = 0;
  private static final String TEXT_IS_BOLD = "is_bold";
  private static final String TEXT_IS_ITALIC = "is_italic";
  private static final String TEXT_KEY = "text";
  private static final String TEXT_SIZE = "font_size";
  private static final String TEXT_STYLE = "text_style";
  
  static
  {
    AppMethodBeat.i(72132);
    TAG = ViewHierarchy.class.getCanonicalName();
    AppMethodBeat.o(72132);
  }
  
  public static List<View> getChildrenOfView(View paramView)
  {
    AppMethodBeat.i(72118);
    ArrayList localArrayList = new ArrayList();
    if ((paramView != null) && ((paramView instanceof ViewGroup)))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramView.getChildAt(i));
        i += 1;
      }
    }
    AppMethodBeat.o(72118);
    return localArrayList;
  }
  
  private static int getClassTypeBitmask(View paramView)
  {
    AppMethodBeat.i(72122);
    int j = 0;
    if ((paramView instanceof ImageView)) {
      j = 2;
    }
    int i = j;
    if (isClickableView(paramView)) {
      i = j | 0x20;
    }
    j = i;
    if (isAdapterViewItem(paramView)) {
      j = i | 0x200;
    }
    if ((paramView instanceof TextView))
    {
      i = j | 0x400 | 0x1;
      j = i;
      if ((paramView instanceof Button))
      {
        i |= 0x4;
        if ((paramView instanceof Switch)) {
          j = i | 0x2000;
        }
      }
      else
      {
        i = j;
        if ((paramView instanceof EditText)) {
          i = j | 0x800;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(72122);
      return i;
      j = i;
      if (!(paramView instanceof CheckBox)) {
        break;
      }
      j = i | 0x8000;
      break;
      if (((paramView instanceof Spinner)) || ((paramView instanceof DatePicker)))
      {
        i = j | 0x1000;
      }
      else if ((paramView instanceof RatingBar))
      {
        i = j | 0x10000;
      }
      else if ((paramView instanceof RadioGroup))
      {
        i = j | 0x4000;
      }
      else
      {
        i = j;
        if ((paramView instanceof ViewGroup))
        {
          i = j;
          if (isRCTButton(paramView)) {
            i = j | 0x40;
          }
        }
      }
    }
  }
  
  public static JSONObject getDictionaryOfView(View paramView)
  {
    AppMethodBeat.i(72121);
    localObject = new JSONObject();
    try
    {
      localJSONObject = setBasicInfoOfView(paramView, (JSONObject)localObject);
    }
    catch (JSONException paramView)
    {
      for (;;)
      {
        int i;
        label34:
        label79:
        paramView = (View)localObject;
      }
    }
    try
    {
      localObject = new JSONArray();
      paramView = getChildrenOfView(paramView);
      i = 0;
      if (i < paramView.size())
      {
        ((JSONArray)localObject).put(getDictionaryOfView((View)paramView.get(i)));
        i += 1;
        break label34;
      }
      localJSONObject.put("childviews", localObject);
      paramView = localJSONObject;
    }
    catch (JSONException paramView)
    {
      paramView = localJSONObject;
      break label79;
    }
    AppMethodBeat.o(72121);
    return paramView;
  }
  
  private static JSONObject getDimensionOfView(View paramView)
  {
    AppMethodBeat.i(72127);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("top", paramView.getTop());
      localJSONObject.put("left", paramView.getLeft());
      localJSONObject.put("width", paramView.getWidth());
      localJSONObject.put("height", paramView.getHeight());
      localJSONObject.put("scrollx", paramView.getScrollX());
      localJSONObject.put("scrolly", paramView.getScrollY());
      localJSONObject.put("visibility", paramView.getVisibility());
      label90:
      AppMethodBeat.o(72127);
      return localJSONObject;
    }
    catch (JSONException paramView)
    {
      break label90;
    }
  }
  
  public static View.AccessibilityDelegate getExistingDelegate(View paramView)
  {
    AppMethodBeat.i(72128);
    try
    {
      paramView = (View.AccessibilityDelegate)paramView.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(paramView, new Object[0]);
      AppMethodBeat.o(72128);
      return paramView;
    }
    catch (NoSuchMethodException paramView)
    {
      AppMethodBeat.o(72128);
      return null;
    }
    catch (NullPointerException paramView)
    {
      AppMethodBeat.o(72128);
      return null;
    }
    catch (SecurityException paramView)
    {
      AppMethodBeat.o(72128);
      return null;
    }
    catch (IllegalAccessException paramView)
    {
      AppMethodBeat.o(72128);
      return null;
    }
    catch (InvocationTargetException paramView)
    {
      AppMethodBeat.o(72128);
    }
    return null;
  }
  
  public static View.OnTouchListener getExistingOnTouchListener(View paramView)
  {
    AppMethodBeat.i(72129);
    try
    {
      Field localField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
      if (localField != null) {
        localField.setAccessible(true);
      }
      paramView = localField.get(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(72129);
        return null;
      }
      localField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
      if (localField == null) {
        break label123;
      }
      localField.setAccessible(true);
      paramView = (View.OnTouchListener)localField.get(paramView);
    }
    catch (NoSuchFieldException paramView)
    {
      Utility.logd(TAG, paramView);
      AppMethodBeat.o(72129);
      return null;
    }
    catch (ClassNotFoundException paramView)
    {
      for (;;)
      {
        Utility.logd(TAG, paramView);
      }
    }
    catch (IllegalAccessException paramView)
    {
      for (;;)
      {
        Utility.logd(TAG, paramView);
        continue;
        paramView = null;
      }
    }
    AppMethodBeat.o(72129);
    return paramView;
  }
  
  public static String getHintOfView(View paramView)
  {
    AppMethodBeat.i(72126);
    CharSequence localCharSequence = null;
    if ((paramView instanceof TextView)) {
      localCharSequence = ((TextView)paramView).getHint();
    }
    while (localCharSequence == null)
    {
      AppMethodBeat.o(72126);
      return "";
      if ((paramView instanceof EditText)) {
        localCharSequence = ((EditText)paramView).getHint();
      }
    }
    paramView = localCharSequence.toString();
    AppMethodBeat.o(72126);
    return paramView;
  }
  
  public static ViewGroup getParentOfView(View paramView)
  {
    AppMethodBeat.i(72117);
    if (paramView == null)
    {
      AppMethodBeat.o(72117);
      return null;
    }
    paramView = paramView.getParent();
    if ((paramView != null) && ((paramView instanceof ViewGroup)))
    {
      paramView = (ViewGroup)paramView;
      AppMethodBeat.o(72117);
      return paramView;
    }
    AppMethodBeat.o(72117);
    return null;
  }
  
  public static String getTextOfView(View paramView)
  {
    AppMethodBeat.i(72125);
    Object localObject;
    if ((paramView instanceof TextView))
    {
      localObject = ((TextView)paramView).getText();
      if ((paramView instanceof Switch))
      {
        if (!((Switch)paramView).isChecked()) {
          break label59;
        }
        localObject = "1";
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(72125);
        return "";
        label59:
        localObject = "0";
        continue;
        if ((paramView instanceof Spinner))
        {
          paramView = ((Spinner)paramView).getSelectedItem();
          if (paramView == null) {
            break label326;
          }
          localObject = paramView.toString();
          continue;
        }
        if ((paramView instanceof DatePicker))
        {
          paramView = (DatePicker)paramView;
          localObject = String.format("%04d-%02d-%02d", new Object[] { Integer.valueOf(paramView.getYear()), Integer.valueOf(paramView.getMonth()), Integer.valueOf(paramView.getDayOfMonth()) });
          continue;
        }
        if ((paramView instanceof TimePicker))
        {
          paramView = (TimePicker)paramView;
          localObject = String.format("%02d:%02d", new Object[] { Integer.valueOf(paramView.getCurrentHour().intValue()), Integer.valueOf(paramView.getCurrentMinute().intValue()) });
          continue;
        }
        if ((paramView instanceof RadioGroup))
        {
          paramView = (RadioGroup)paramView;
          int j = paramView.getCheckedRadioButtonId();
          int k = paramView.getChildCount();
          int i = 0;
          for (;;)
          {
            if (i >= k) {
              break label278;
            }
            localObject = paramView.getChildAt(i);
            if ((((View)localObject).getId() == j) && ((localObject instanceof RadioButton)))
            {
              localObject = ((RadioButton)localObject).getText();
              break;
            }
            i += 1;
          }
          label278:
          localObject = null;
          continue;
        }
        if ((paramView instanceof RatingBar)) {
          localObject = String.valueOf(((RatingBar)paramView).getRating());
        }
      }
      else
      {
        paramView = localObject.toString();
        AppMethodBeat.o(72125);
        return paramView;
      }
      localObject = null;
      continue;
      label326:
      localObject = null;
    }
  }
  
  private static boolean isAdapterViewItem(View paramView)
  {
    AppMethodBeat.i(72124);
    paramView = paramView.getParent();
    if ((paramView != null) && (((paramView instanceof AdapterView)) || ((paramView instanceof j))))
    {
      AppMethodBeat.o(72124);
      return true;
    }
    AppMethodBeat.o(72124);
    return false;
  }
  
  public static boolean isClickableView(View paramView)
  {
    AppMethodBeat.i(72123);
    try
    {
      Object localObject = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
      if (localObject != null) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = ((Field)localObject).get(paramView);
      if (localObject == null)
      {
        AppMethodBeat.o(72123);
        return false;
      }
      paramView = null;
      Field localField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
      if (localField != null) {
        paramView = (View.OnClickListener)localField.get(localObject);
      }
      if (paramView != null)
      {
        AppMethodBeat.o(72123);
        return true;
      }
      AppMethodBeat.o(72123);
      return false;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(72123);
    }
    return false;
  }
  
  public static boolean isRCTButton(View paramView)
  {
    AppMethodBeat.i(72130);
    if ((paramView.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup")) && (getExistingDelegate(paramView) != null) && (((ViewGroup)paramView).getChildCount() > 0))
    {
      AppMethodBeat.o(72130);
      return true;
    }
    AppMethodBeat.o(72130);
    return false;
  }
  
  public static boolean isRCTTextView(View paramView)
  {
    AppMethodBeat.i(72131);
    boolean bool = paramView.getClass().getName().equals("com.facebook.react.views.view.ReactTextView");
    AppMethodBeat.o(72131);
    return bool;
  }
  
  public static JSONObject setAppearanceOfView(View paramView, JSONObject paramJSONObject, float paramFloat)
  {
    AppMethodBeat.i(72120);
    try
    {
      Object localObject = new JSONObject();
      if ((paramView instanceof TextView))
      {
        TextView localTextView = (TextView)paramView;
        Typeface localTypeface = localTextView.getTypeface();
        if (localTypeface != null)
        {
          ((JSONObject)localObject).put("font_size", localTextView.getTextSize());
          ((JSONObject)localObject).put("is_bold", localTypeface.isBold());
          ((JSONObject)localObject).put("is_italic", localTypeface.isItalic());
          paramJSONObject.put("text_style", localObject);
        }
      }
      if ((paramView instanceof ImageView))
      {
        localObject = ((ImageView)paramView).getDrawable();
        if (((localObject instanceof BitmapDrawable)) && (paramView.getHeight() / paramFloat <= 44.0F) && (paramView.getWidth() / paramFloat <= 44.0F))
        {
          paramView = ((BitmapDrawable)localObject).getBitmap();
          localObject = new ByteArrayOutputStream();
          paramView.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
          paramJSONObject.put("icon_image", Base64.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0));
        }
      }
    }
    catch (JSONException paramView)
    {
      for (;;)
      {
        Utility.logd(TAG, paramView);
      }
    }
    AppMethodBeat.o(72120);
    return paramJSONObject;
  }
  
  public static JSONObject setBasicInfoOfView(View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72119);
    for (;;)
    {
      try
      {
        String str1 = getTextOfView(paramView);
        String str2 = getHintOfView(paramView);
        Object localObject = paramView.getTag();
        CharSequence localCharSequence = paramView.getContentDescription();
        paramJSONObject.put("classname", paramView.getClass().getCanonicalName());
        paramJSONObject.put("classtypebitmask", getClassTypeBitmask(paramView));
        paramJSONObject.put("id", paramView.getId());
        if (SensitiveUserDataUtils.isSensitiveUserData(paramView)) {
          continue;
        }
        paramJSONObject.put("text", str1);
        paramJSONObject.put("hint", str2);
        if (localObject != null) {
          paramJSONObject.put("tag", localObject.toString());
        }
        if (localCharSequence != null) {
          paramJSONObject.put("description", localCharSequence.toString());
        }
        paramJSONObject.put("dimension", getDimensionOfView(paramView));
      }
      catch (JSONException paramView)
      {
        Utility.logd(TAG, paramView);
        continue;
      }
      AppMethodBeat.o(72119);
      return paramJSONObject;
      paramJSONObject.put("text", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.appevents.codeless.internal.ViewHierarchy
 * JD-Core Version:    0.7.0.1
 */