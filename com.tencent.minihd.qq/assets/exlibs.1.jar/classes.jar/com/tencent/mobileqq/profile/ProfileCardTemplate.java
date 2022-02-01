package com.tencent.mobileqq.profile;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.StateSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileCardTemplate
{
  public static long a = 0L;
  public static final String a = "qvip_profile_template.json";
  public static final HashMap a;
  public static long b = 0L;
  public static final String b = "background";
  public static long c = 0L;
  public static final String c = "style";
  public static long d = 0L;
  public static final String d = "53";
  public static final int e = 0;
  public static long e = 0L;
  public static final int f = 1;
  public static long f = 0L;
  public static final int g = 2;
  public static long g;
  public int a;
  public boolean a;
  public int b;
  public HashMap b;
  public int c;
  private HashMap c;
  public int d;
  private HashMap d;
  public String e;
  public String f;
  public String g;
  public int h;
  public long h;
  public String h;
  public int i;
  public String i = "";
  public int j;
  public String j = "";
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n;
  public String n;
  public int o;
  public String o;
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  public String v = "";
  public String w = "";
  public String x = "";
  public String y = "";
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 1L;
    jdField_c_of_type_Long = 4L;
    jdField_d_of_type_Long = 5L;
    jdField_e_of_type_Long = 6L;
    jdField_f_of_type_Long = 7L;
    jdField_g_of_type_Long = 8L;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public ProfileCardTemplate()
  {
    this.jdField_h_of_type_Long = 0L;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "0";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_m_of_type_JavaLangString = "";
    this.jdField_n_of_type_JavaLangString = "";
    this.jdField_o_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 0;
    this.jdField_n_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_o_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap.put("top", Integer.valueOf(48));
    this.jdField_c_of_type_JavaUtilHashMap.put("bottom", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("left", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("right", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("center_vertical", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("fill_vertical", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("center_horizontal", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("fill_horizontal", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("center", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("fill", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("clip_vertical", Integer.valueOf(80));
    this.jdField_c_of_type_JavaUtilHashMap.put("clip_horizontal", Integer.valueOf(80));
    this.jdField_d_of_type_JavaUtilHashMap.put("clamp", Shader.TileMode.CLAMP);
    this.jdField_d_of_type_JavaUtilHashMap.put("repeat", Shader.TileMode.REPEAT);
    this.jdField_d_of_type_JavaUtilHashMap.put("mirror", Shader.TileMode.MIRROR);
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_b_of_type_Long), "game");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_c_of_type_Long), "game");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_d_of_type_Long), "game");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_e_of_type_Long), "photo");
    jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(jdField_g_of_type_Long), "simple");
  }
  
  @SuppressLint({"NewApi"})
  public static void a(View paramView, String paramString1, ProfileCardTemplate paramProfileCardTemplate, String paramString2)
  {
    if ((paramView != null) && (paramProfileCardTemplate != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramProfileCardTemplate = paramProfileCardTemplate.jdField_b_of_type_JavaUtilHashMap.get(paramString2);
      if (paramProfileCardTemplate != null)
      {
        if ((!paramString1.equalsIgnoreCase("color")) || (!(paramView instanceof TextView))) {
          break label102;
        }
        paramView = (TextView)paramView;
        if (!(paramProfileCardTemplate instanceof ColorStateList)) {
          break label72;
        }
        paramView.setTextColor((ColorStateList)paramProfileCardTemplate);
      }
    }
    label71:
    label72:
    label102:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          break label71;
                          do
                          {
                            return;
                          } while (!(paramProfileCardTemplate instanceof String));
                          paramString1 = (String)paramProfileCardTemplate;
                        } while (!paramString1.startsWith("#"));
                        paramView.setTextColor(Color.parseColor(paramString1));
                        return;
                        if (!paramString1.equalsIgnoreCase("background")) {
                          break;
                        }
                        if ((paramProfileCardTemplate instanceof Drawable))
                        {
                          paramString1 = ((Drawable)paramProfileCardTemplate).getConstantState().newDrawable();
                          paramProfileCardTemplate = new Rect();
                          paramString1.getPadding(paramProfileCardTemplate);
                          int i1 = paramView.getPaddingTop();
                          int i2 = paramProfileCardTemplate.top;
                          int i3 = paramView.getPaddingLeft();
                          int i4 = paramProfileCardTemplate.left;
                          int i5 = paramView.getPaddingRight();
                          int i6 = paramProfileCardTemplate.right;
                          int i7 = paramView.getPaddingBottom();
                          int i8 = paramProfileCardTemplate.bottom;
                          if (Build.VERSION.SDK_INT >= 16) {
                            paramView.setBackground(paramString1);
                          }
                          for (;;)
                          {
                            paramView.setPadding(i3 + i4, i1 + i2, i5 + i6, i8 + i7);
                            return;
                            paramView.setBackgroundDrawable(paramString1);
                          }
                        }
                      } while (!(paramProfileCardTemplate instanceof String));
                      paramString1 = (String)paramProfileCardTemplate;
                    } while (!paramString1.startsWith("#"));
                    paramView.setBackgroundColor(Color.parseColor(paramString1));
                    return;
                    if ((!paramString1.equalsIgnoreCase("drawableleft")) || (!(paramView instanceof TextView))) {
                      break;
                    }
                  } while (!(paramProfileCardTemplate instanceof Drawable));
                  paramView = (TextView)paramView;
                } while (!(paramProfileCardTemplate instanceof Drawable));
                paramView.setCompoundDrawablesWithIntrinsicBounds(((Drawable)paramProfileCardTemplate).getConstantState().newDrawable(), null, null, null);
                return;
                if ((!paramString1.equalsIgnoreCase("drawableright")) || (!(paramView instanceof TextView))) {
                  break;
                }
              } while (!(paramProfileCardTemplate instanceof Drawable));
              paramView = (TextView)paramView;
            } while (!(paramProfileCardTemplate instanceof Drawable));
            paramView.setCompoundDrawablesWithIntrinsicBounds(null, null, ((Drawable)paramProfileCardTemplate).getConstantState().newDrawable(), null);
            return;
            if ((!paramString1.equalsIgnoreCase("src")) || (!(paramView instanceof ImageView))) {
              break;
            }
          } while (!(paramProfileCardTemplate instanceof Drawable));
          paramView = (ImageView)paramView;
        } while (!(paramProfileCardTemplate instanceof Drawable));
        paramView.setImageDrawable(((Drawable)paramProfileCardTemplate).getConstantState().newDrawable());
        return;
      } while ((!paramString1.equalsIgnoreCase("contentBackground")) || (!(paramView instanceof ListView)) || (!(paramProfileCardTemplate instanceof Drawable)));
      paramView = (ListView)paramView;
    } while (!(paramProfileCardTemplate instanceof Drawable));
    paramView.setContentBackground(((Drawable)paramProfileCardTemplate).getConstantState().newDrawable());
  }
  
  public ColorStateList a(JSONArray paramJSONArray)
  {
    int i4;
    int i3;
    Object localObject1;
    Object localObject2;
    int i5;
    Object localObject3;
    int i1;
    int i2;
    int i6;
    if (paramJSONArray != null)
    {
      i4 = 20;
      i3 = 0;
      localObject1 = new int[20];
      localObject2 = new int[20][];
      int i7 = paramJSONArray.length();
      i5 = 0;
      if (i5 < i7)
      {
        localObject3 = paramJSONArray.optJSONObject(i5);
        if ((localObject3 == null) || (!((JSONObject)localObject3).has("color"))) {
          break label699;
        }
        Object localObject4 = ((JSONObject)localObject3).optString("color");
        if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
          break label699;
        }
        Object localObject5 = ((JSONObject)localObject3).keys();
        int[] arrayOfInt = new int[((JSONObject)localObject3).length()];
        i1 = -65536;
        i2 = 0;
        if (((Iterator)localObject5).hasNext())
        {
          String str = (String)((Iterator)localObject5).next();
          if (str.equalsIgnoreCase("state_pressed")) {
            if (((JSONObject)localObject3).optBoolean("state_pressed"))
            {
              i6 = 16842919;
              label156:
              arrayOfInt[i2] = i6;
              i6 = i2 + 1;
              i2 = i1;
              i1 = i6;
            }
          }
          for (;;)
          {
            label172:
            i6 = i2;
            i2 = i1;
            i1 = i6;
            break;
            i6 = -16842919;
            break label156;
            if (str.equalsIgnoreCase("state_focused"))
            {
              if (((JSONObject)localObject3).optBoolean("state_focused")) {}
              for (i6 = 16842908;; i6 = -16842908)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_selected"))
            {
              if (((JSONObject)localObject3).optBoolean("state_selected")) {}
              for (i6 = 16842913;; i6 = -16842913)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_checkable"))
            {
              if (((JSONObject)localObject3).optBoolean("state_checkable")) {}
              for (i6 = 16842911;; i6 = -16842911)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_checked"))
            {
              if (((JSONObject)localObject3).optBoolean("state_checked")) {}
              for (i6 = 16842912;; i6 = -16842912)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_enabled"))
            {
              if (((JSONObject)localObject3).optBoolean("state_enabled")) {}
              for (i6 = 16842910;; i6 = -16842910)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (str.equalsIgnoreCase("state_window_focused"))
            {
              if (((JSONObject)localObject3).optBoolean("state_window_focused")) {}
              for (i6 = 16842909;; i6 = -16842909)
              {
                arrayOfInt[i2] = i6;
                i6 = i2 + 1;
                i2 = i1;
                i1 = i6;
                break;
              }
            }
            if (!str.equalsIgnoreCase("color")) {
              break label688;
            }
            i6 = Color.parseColor((String)localObject4);
            i1 = i2;
            i2 = i6;
          }
        }
        localObject5 = StateSet.trimStateSet(arrayOfInt, i2);
        if (i3 + 1 < i4) {
          break label682;
        }
        i2 = i3 + 1;
        localObject3 = new int[i2];
        System.arraycopy(localObject1, 0, localObject3, 0, i3);
        localObject4 = new int[i2][];
        System.arraycopy(localObject2, 0, localObject4, 0, i3);
        localObject1 = localObject3;
        localObject2 = localObject4;
        label603:
        localObject1[i3] = i1;
        localObject2[i3] = localObject5;
        i1 = i3 + 1;
        i4 = i2;
      }
    }
    for (;;)
    {
      i5 += 1;
      i3 = i1;
      break;
      paramJSONArray = new int[i3];
      localObject3 = new int[i3][];
      System.arraycopy(localObject1, 0, paramJSONArray, 0, i3);
      System.arraycopy(localObject2, 0, localObject3, 0, i3);
      return new ColorStateList((int[][])localObject3, paramJSONArray);
      return null;
      label682:
      i2 = i4;
      break label603;
      label688:
      i6 = i1;
      i1 = i2;
      i2 = i6;
      break label172;
      label699:
      i1 = i3;
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable fileName=" + paramString);
    }
    String str = null;
    Object localObject2 = null;
    label683:
    label689:
    label694:
    label697:
    for (;;)
    {
      try
      {
        localResources = paramQQAppInterface.a().getResources();
        localObject1 = str;
        if (paramString == null) {
          break label694;
        }
        localObject1 = str;
        if (paramString.length() <= 0) {
          break label694;
        }
        Object localObject3 = ProfileCardUtil.a(paramQQAppInterface, -1L);
        localObject1 = str;
        if (localObject3 == null) {
          break label694;
        }
        localObject1 = str;
        if (((String)localObject3).length() <= 0) {
          break label694;
        }
        localObject1 = (String)localObject3 + File.separator + paramString;
        str = "profilecard:" + (String)localObject1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable filePath=" + (String)localObject1);
        }
        if (paramBoolean)
        {
          localObject3 = (Pair)BaseApplicationImpl.a.get(str);
          if ((localObject3 != null) && (((Pair)localObject3).first != null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable form sImageCache filePath=" + (String)localObject1);
            }
            return ((Drawable.ConstantState)((Pair)localObject3).first).newDrawable();
          }
        }
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inDensity = 320;
        ((BitmapFactory.Options)localObject3).inScreenDensity = paramQQAppInterface.a().getResources().getDisplayMetrics().densityDpi;
        ((BitmapFactory.Options)localObject3).inTargetDensity = paramQQAppInterface.a().getResources().getDisplayMetrics().densityDpi;
        ((BitmapFactory.Options)localObject3).inScaled = true;
        if ((paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg"))) {
          ((BitmapFactory.Options)localObject3).inPreferredConfig = Bitmap.Config.RGB_565;
        }
        paramQQAppInterface = BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject3);
        if (paramQQAppInterface == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable bitmap density=" + paramQQAppInterface.getDensity() + ",width=" + paramQQAppInterface.getWidth() + ",height=" + paramQQAppInterface.getHeight());
        }
        i1 = Utils.getBitmapSize(paramQQAppInterface);
        if (!paramString.endsWith(".9.png")) {
          continue;
        }
        localObject1 = paramQQAppInterface.getNinePatchChunk();
        if (localObject1 == null) {
          break label689;
        }
        paramQQAppInterface = new NinePatchDrawable(localResources, paramQQAppInterface, (byte[])localObject1, new Rect(0, 0, 0, 0), null);
        paramQQAppInterface.setTargetDensity(localResources.getDisplayMetrics());
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        Resources localResources;
        paramQQAppInterface.printStackTrace();
        return null;
        if ((!paramString.endsWith(".png")) && (!paramString.endsWith(".jpg")) && (!paramString.endsWith(".jpeg"))) {
          continue;
        }
        paramQQAppInterface = new BitmapDrawable(localResources, paramQQAppInterface);
        paramQQAppInterface.setTargetDensity(localResources.getDisplayMetrics());
        continue;
        if (!QLog.isColorLevel()) {
          break label683;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable file not ");
        paramQQAppInterface = localObject2;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable bitmap is null");
        int i1 = 0;
        paramQQAppInterface = localObject2;
        continue;
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "getTemplateDrawable exception fileName=" + paramString + ",msg=" + paramQQAppInterface.getMessage());
        return null;
      }
      Object localObject1 = paramQQAppInterface;
      if (paramQQAppInterface != null)
      {
        localObject1 = paramQQAppInterface;
        if (paramBoolean)
        {
          BaseApplicationImpl.a.put(str, new Pair(paramQQAppInterface.getConstantState(), Integer.valueOf(i1)));
          return paramQQAppInterface;
          paramQQAppInterface = localObject2;
          continue;
          paramQQAppInterface = null;
          break label697;
        }
      }
      return localObject1;
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("src")))
    {
      Object localObject = paramJSONObject.optString("src");
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = (BitmapDrawable)a(paramQQAppInterface, (String)localObject, true);
        Iterator localIterator = paramJSONObject.keys();
        if (localObject != null) {
          for (;;)
          {
            paramQQAppInterface = (QQAppInterface)localObject;
            if (!localIterator.hasNext()) {
              break;
            }
            paramQQAppInterface = (String)localIterator.next();
            if (paramQQAppInterface.equalsIgnoreCase("antialias"))
            {
              ((BitmapDrawable)localObject).setAntiAlias(paramJSONObject.optBoolean("antialias"));
            }
            else if (paramQQAppInterface.equalsIgnoreCase("dither"))
            {
              ((BitmapDrawable)localObject).setDither(paramJSONObject.optBoolean("dither"));
            }
            else if (paramQQAppInterface.equalsIgnoreCase("filter"))
            {
              ((BitmapDrawable)localObject).setFilterBitmap(paramJSONObject.optBoolean("filter"));
            }
            else if (paramQQAppInterface.equalsIgnoreCase("gravity"))
            {
              paramQQAppInterface = paramJSONObject.optString("gravity").toLowerCase();
              if ((!TextUtils.isEmpty(paramQQAppInterface)) && (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramQQAppInterface))) {
                ((BitmapDrawable)localObject).setGravity(((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(paramQQAppInterface)).intValue());
              }
            }
            else if (paramQQAppInterface.equalsIgnoreCase("tileMode"))
            {
              paramQQAppInterface = paramJSONObject.optString("tileMode", "disabled").toLowerCase();
              if ((!TextUtils.isEmpty(paramQQAppInterface)) && (this.jdField_d_of_type_JavaUtilHashMap.containsKey(paramQQAppInterface)))
              {
                paramQQAppInterface = (Shader.TileMode)this.jdField_d_of_type_JavaUtilHashMap.get(paramQQAppInterface);
                ((BitmapDrawable)localObject).setTileModeXY(paramQQAppInterface, paramQQAppInterface);
              }
              else
              {
                ((BitmapDrawable)localObject).setTileModeXY(null, null);
              }
            }
          }
        }
      }
    }
    paramQQAppInterface = null;
    return paramQQAppInterface;
  }
  
  public StateListDrawable a(QQAppInterface paramQQAppInterface, JSONArray paramJSONArray)
  {
    StateListDrawable localStateListDrawable;
    int i2;
    Object localObject;
    String str1;
    int[] arrayOfInt;
    int i1;
    Drawable localDrawable;
    label97:
    String str2;
    int i3;
    if (paramJSONArray != null)
    {
      localStateListDrawable = new StateListDrawable();
      int i4 = paramJSONArray.length();
      i2 = 0;
      if (i2 < i4)
      {
        localObject = paramJSONArray.optJSONObject(i2);
        if ((localObject != null) && (((JSONObject)localObject).has("drawable")))
        {
          str1 = ((JSONObject)localObject).optString("drawable");
          if ((str1 != null) && (str1.length() > 0))
          {
            Iterator localIterator = ((JSONObject)localObject).keys();
            arrayOfInt = new int[((JSONObject)localObject).length()];
            i1 = 0;
            localDrawable = null;
            if (localIterator.hasNext())
            {
              str2 = (String)localIterator.next();
              i3 = Build.VERSION.SDK_INT;
              if (str2.equalsIgnoreCase("state_pressed")) {
                if (((JSONObject)localObject).optBoolean("state_pressed"))
                {
                  i3 = 16842919;
                  label151:
                  arrayOfInt[i1] = i3;
                  i1 += 1;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break label97;
      i3 = -16842919;
      break label151;
      if (str2.equalsIgnoreCase("state_focused"))
      {
        if (((JSONObject)localObject).optBoolean("state_focused")) {}
        for (i3 = 16842908;; i3 = -16842908)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if ((str2.equalsIgnoreCase("state_hovered")) && (i3 >= 14))
      {
        if (((JSONObject)localObject).optBoolean("state_hovered")) {}
        for (i3 = 16843623;; i3 = -16843623)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_selected"))
      {
        if (((JSONObject)localObject).optBoolean("state_selected")) {}
        for (i3 = 16842913;; i3 = -16842913)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_checkable"))
      {
        if (((JSONObject)localObject).optBoolean("state_checkable")) {}
        for (i3 = 16842911;; i3 = -16842911)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_checked"))
      {
        if (((JSONObject)localObject).optBoolean("state_checked")) {}
        for (i3 = 16842912;; i3 = -16842912)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_enabled"))
      {
        if (((JSONObject)localObject).optBoolean("state_enabled")) {}
        for (i3 = 16842910;; i3 = -16842910)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if ((str2.equalsIgnoreCase("state_activated")) && (i3 >= 11))
      {
        if (((JSONObject)localObject).optBoolean("state_activated")) {}
        for (i3 = 16843518;; i3 = -16843518)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("state_window_focused"))
      {
        if (((JSONObject)localObject).optBoolean("state_window_focused")) {}
        for (i3 = 16842909;; i3 = -16842909)
        {
          arrayOfInt[i1] = i3;
          i1 += 1;
          break;
        }
      }
      if (str2.equalsIgnoreCase("drawable"))
      {
        localDrawable = a(paramQQAppInterface, str1, true);
        continue;
        localObject = StateSet.trimStateSet(arrayOfInt, i1);
        if (localDrawable != null) {
          localStateListDrawable.addState((int[])localObject, localDrawable);
        }
        i2 += 1;
        break;
        return localStateListDrawable;
        return null;
      }
    }
  }
  
  /* Error */
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lload_2
    //   3: lconst_1
    //   4: lcmp
    //   5: ifne +339 -> 344
    //   8: ldc_w 688
    //   11: astore 9
    //   13: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +31 -> 47
    //   19: ldc_w 441
    //   22: iconst_2
    //   23: new 443	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 690
    //   33: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload 9
    //   38: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 457	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_1
    //   48: ldc2_w 469
    //   51: invokestatic 475	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;J)Ljava/lang/String;
    //   54: astore 10
    //   56: aload 10
    //   58: ifnull +1117 -> 1175
    //   61: aload 10
    //   63: invokevirtual 367	java/lang/String:length	()I
    //   66: ifle +1109 -> 1175
    //   69: new 443	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   76: aload 10
    //   78: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: getstatic 480	java/io/File:separator	Ljava/lang/String;
    //   84: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 9
    //   89: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore 9
    //   97: aconst_null
    //   98: astore 13
    //   100: ldc 86
    //   102: astore 10
    //   104: getstatic 80	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   107: lload 4
    //   109: invokestatic 213	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   112: invokevirtual 233	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast 210	java/lang/String
    //   118: astore 14
    //   120: new 477	java/io/File
    //   123: dup
    //   124: aload 9
    //   126: invokespecial 693	java/io/File:<init>	(Ljava/lang/String;)V
    //   129: astore 9
    //   131: aload 9
    //   133: invokevirtual 696	java/io/File:exists	()Z
    //   136: ifeq +892 -> 1028
    //   139: new 698	java/io/FileInputStream
    //   142: dup
    //   143: aload 9
    //   145: invokespecial 701	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   148: astore 11
    //   150: aload 10
    //   152: astore 12
    //   154: new 703	java/io/ByteArrayOutputStream
    //   157: dup
    //   158: invokespecial 704	java/io/ByteArrayOutputStream:<init>	()V
    //   161: astore 9
    //   163: aload 10
    //   165: astore 12
    //   167: sipush 4096
    //   170: newarray byte
    //   172: astore 13
    //   174: aload 10
    //   176: astore 12
    //   178: aload 11
    //   180: aload 13
    //   182: iconst_0
    //   183: sipush 4096
    //   186: invokevirtual 710	java/io/InputStream:read	([BII)I
    //   189: istore 6
    //   191: iload 6
    //   193: iconst_m1
    //   194: if_icmpeq +158 -> 352
    //   197: aload 10
    //   199: astore 12
    //   201: aload 9
    //   203: aload 13
    //   205: iconst_0
    //   206: iload 6
    //   208: invokevirtual 714	java/io/ByteArrayOutputStream:write	([BII)V
    //   211: goto -37 -> 174
    //   214: astore 9
    //   216: aload 11
    //   218: astore_1
    //   219: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +79 -> 301
    //   225: new 443	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   232: aload 9
    //   234: invokevirtual 718	java/lang/Object:getClass	()Ljava/lang/Class;
    //   237: invokevirtual 723	java/lang/Class:getName	()Ljava/lang/String;
    //   240: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 725
    //   246: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 9
    //   251: invokevirtual 726	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   254: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: astore 10
    //   262: ldc_w 441
    //   265: iconst_2
    //   266: new 443	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   273: ldc_w 728
    //   276: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 12
    //   281: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc_w 730
    //   287: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 10
    //   292: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 457	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload 9
    //   303: invokevirtual 731	java/lang/Exception:printStackTrace	()V
    //   306: aload_1
    //   307: ifnull +862 -> 1169
    //   310: aload_1
    //   311: invokevirtual 734	java/io/InputStream:close	()V
    //   314: iconst_0
    //   315: istore 6
    //   317: iload 6
    //   319: ifeq +798 -> 1117
    //   322: aload_0
    //   323: getfield 152	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   326: invokevirtual 737	java/util/HashMap:size	()I
    //   329: istore 6
    //   331: iload 6
    //   333: ifle +784 -> 1117
    //   336: iconst_1
    //   337: istore 7
    //   339: aload_0
    //   340: monitorexit
    //   341: iload 7
    //   343: ireturn
    //   344: ldc_w 739
    //   347: astore 9
    //   349: goto -336 -> 13
    //   352: aload 10
    //   354: astore 12
    //   356: new 210	java/lang/String
    //   359: dup
    //   360: aload 9
    //   362: invokevirtual 742	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   365: ldc_w 744
    //   368: invokespecial 747	java/lang/String:<init>	([BLjava/lang/String;)V
    //   371: astore 9
    //   373: aload 9
    //   375: ifnull +700 -> 1075
    //   378: aload 10
    //   380: astore 12
    //   382: aload 9
    //   384: invokevirtual 367	java/lang/String:length	()I
    //   387: ifle +688 -> 1075
    //   390: aload 10
    //   392: astore 12
    //   394: new 359	org/json/JSONObject
    //   397: dup
    //   398: aload 9
    //   400: invokespecial 748	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   403: astore 13
    //   405: aload 10
    //   407: astore 12
    //   409: aload 13
    //   411: invokevirtual 371	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   414: astore 15
    //   416: ldc 86
    //   418: astore 9
    //   420: aload 15
    //   422: invokeinterface 379 1 0
    //   427: ifeq +648 -> 1075
    //   430: aload 15
    //   432: invokeinterface 383 1 0
    //   437: checkcast 210	java/lang/String
    //   440: astore 10
    //   442: aload 10
    //   444: astore 12
    //   446: aload 10
    //   448: ldc_w 750
    //   451: invokevirtual 252	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   454: ifne +29 -> 483
    //   457: aload 10
    //   459: astore 12
    //   461: aload 14
    //   463: invokestatic 229	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   466: ifne +513 -> 979
    //   469: aload 10
    //   471: astore 12
    //   473: aload 10
    //   475: aload 14
    //   477: invokevirtual 252	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   480: ifeq +499 -> 979
    //   483: aload 10
    //   485: astore 12
    //   487: aload 13
    //   489: aload 10
    //   491: invokevirtual 753	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   494: astore 17
    //   496: aload 17
    //   498: ifnull +417 -> 915
    //   501: aload 10
    //   503: astore 12
    //   505: aload 17
    //   507: ldc_w 755
    //   510: invokevirtual 366	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   513: astore 16
    //   515: aload 16
    //   517: ifnull +671 -> 1188
    //   520: aload 10
    //   522: astore 12
    //   524: aload 16
    //   526: invokevirtual 367	java/lang/String:length	()I
    //   529: ifle +659 -> 1188
    //   532: aconst_null
    //   533: astore 9
    //   535: aload 10
    //   537: astore 12
    //   539: aload 16
    //   541: ldc_w 757
    //   544: invokevirtual 239	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   547: ifeq +103 -> 650
    //   550: aload 10
    //   552: astore 12
    //   554: aload_0
    //   555: aload 17
    //   557: ldc_w 759
    //   560: invokevirtual 763	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   563: invokevirtual 765	com/tencent/mobileqq/profile/ProfileCardTemplate:a	(Lorg/json/JSONArray;)Landroid/content/res/ColorStateList;
    //   566: astore 9
    //   568: aload 9
    //   570: ifnull +256 -> 826
    //   573: aload 10
    //   575: astore 12
    //   577: aload_0
    //   578: getfield 152	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   581: aload 10
    //   583: aload 9
    //   585: invokevirtual 168	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   588: pop
    //   589: aload 10
    //   591: astore 12
    //   593: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   596: ifeq +592 -> 1188
    //   599: aload 10
    //   601: astore 12
    //   603: ldc_w 441
    //   606: iconst_2
    //   607: new 443	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   614: ldc_w 767
    //   617: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload 10
    //   622: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: ldc_w 769
    //   628: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload_0
    //   632: getfield 152	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   635: invokevirtual 737	java/util/HashMap:size	()I
    //   638: invokevirtual 558	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   641: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 457	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: goto +541 -> 1188
    //   650: aload 10
    //   652: astore 12
    //   654: aload 16
    //   656: ldc_w 771
    //   659: invokevirtual 239	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   662: ifeq +26 -> 688
    //   665: aload 10
    //   667: astore 12
    //   669: aload_0
    //   670: aload_1
    //   671: aload 17
    //   673: ldc_w 759
    //   676: invokevirtual 366	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   679: iconst_1
    //   680: invokevirtual 621	com/tencent/mobileqq/profile/ProfileCardTemplate:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Landroid/graphics/drawable/Drawable;
    //   683: astore 9
    //   685: goto -117 -> 568
    //   688: aload 10
    //   690: astore 12
    //   692: aload 16
    //   694: ldc_w 773
    //   697: invokevirtual 239	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   700: ifeq +25 -> 725
    //   703: aload 10
    //   705: astore 12
    //   707: aload_0
    //   708: aload_1
    //   709: aload 17
    //   711: ldc_w 759
    //   714: invokevirtual 753	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   717: invokevirtual 775	com/tencent/mobileqq/profile/ProfileCardTemplate:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lorg/json/JSONObject;)Landroid/graphics/drawable/Drawable;
    //   720: astore 9
    //   722: goto -154 -> 568
    //   725: aload 10
    //   727: astore 12
    //   729: aload 16
    //   731: ldc_w 777
    //   734: invokevirtual 239	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   737: ifeq +25 -> 762
    //   740: aload 10
    //   742: astore 12
    //   744: aload_0
    //   745: aload_1
    //   746: aload 17
    //   748: ldc_w 759
    //   751: invokevirtual 763	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   754: invokevirtual 779	com/tencent/mobileqq/profile/ProfileCardTemplate:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lorg/json/JSONArray;)Landroid/graphics/drawable/StateListDrawable;
    //   757: astore 9
    //   759: goto -191 -> 568
    //   762: aload 10
    //   764: astore 12
    //   766: aload 16
    //   768: ldc_w 781
    //   771: invokevirtual 239	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   774: ifeq +20 -> 794
    //   777: aload 10
    //   779: astore 12
    //   781: aload 17
    //   783: ldc_w 759
    //   786: invokevirtual 366	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   789: astore 9
    //   791: goto -223 -> 568
    //   794: aload 10
    //   796: astore 12
    //   798: aload 16
    //   800: ldc_w 783
    //   803: invokevirtual 239	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   806: ifeq -238 -> 568
    //   809: aload 10
    //   811: astore 12
    //   813: aload 17
    //   815: ldc_w 759
    //   818: invokevirtual 366	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   821: astore 9
    //   823: goto -255 -> 568
    //   826: aload 10
    //   828: astore 12
    //   830: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   833: ifeq +41 -> 874
    //   836: aload 10
    //   838: astore 12
    //   840: ldc_w 441
    //   843: iconst_2
    //   844: new 443	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   851: ldc_w 767
    //   854: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload 10
    //   859: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: ldc_w 785
    //   865: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: invokestatic 457	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   874: iconst_0
    //   875: istore 8
    //   877: iload 8
    //   879: istore 7
    //   881: aload 11
    //   883: ifnull -544 -> 339
    //   886: aload 11
    //   888: invokevirtual 734	java/io/InputStream:close	()V
    //   891: iload 8
    //   893: istore 7
    //   895: goto -556 -> 339
    //   898: astore_1
    //   899: aload_1
    //   900: invokevirtual 786	java/io/IOException:printStackTrace	()V
    //   903: iload 8
    //   905: istore 7
    //   907: goto -568 -> 339
    //   910: astore_1
    //   911: aload_0
    //   912: monitorexit
    //   913: aload_1
    //   914: athrow
    //   915: aload 10
    //   917: astore 12
    //   919: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   922: ifeq +266 -> 1188
    //   925: aload 10
    //   927: astore 12
    //   929: ldc_w 441
    //   932: iconst_2
    //   933: new 443	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   940: ldc_w 767
    //   943: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: aload 10
    //   948: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: ldc_w 788
    //   954: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   960: invokestatic 457	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   963: goto +225 -> 1188
    //   966: astore_1
    //   967: aload 11
    //   969: ifnull +8 -> 977
    //   972: aload 11
    //   974: invokevirtual 734	java/io/InputStream:close	()V
    //   977: aload_1
    //   978: athrow
    //   979: aload 10
    //   981: astore 12
    //   983: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   986: ifeq +195 -> 1181
    //   989: aload 10
    //   991: astore 12
    //   993: ldc_w 441
    //   996: iconst_2
    //   997: new 443	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   1004: ldc_w 790
    //   1007: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: aload 10
    //   1012: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1018: invokestatic 457	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1021: aload 10
    //   1023: astore 9
    //   1025: goto -605 -> 420
    //   1028: invokestatic 439	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1031: ifeq +13 -> 1044
    //   1034: ldc_w 441
    //   1037: iconst_2
    //   1038: ldc_w 792
    //   1041: invokestatic 457	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1044: iconst_0
    //   1045: istore 8
    //   1047: iload 8
    //   1049: istore 7
    //   1051: iconst_0
    //   1052: ifeq -713 -> 339
    //   1055: new 794	java/lang/NullPointerException
    //   1058: dup
    //   1059: invokespecial 795	java/lang/NullPointerException:<init>	()V
    //   1062: athrow
    //   1063: astore_1
    //   1064: aload_1
    //   1065: invokevirtual 786	java/io/IOException:printStackTrace	()V
    //   1068: iload 8
    //   1070: istore 7
    //   1072: goto -733 -> 339
    //   1075: aload 11
    //   1077: ifnull +98 -> 1175
    //   1080: aload 11
    //   1082: invokevirtual 734	java/io/InputStream:close	()V
    //   1085: iconst_1
    //   1086: istore 6
    //   1088: goto -771 -> 317
    //   1091: astore_1
    //   1092: aload_1
    //   1093: invokevirtual 786	java/io/IOException:printStackTrace	()V
    //   1096: goto -11 -> 1085
    //   1099: astore_1
    //   1100: aload_1
    //   1101: invokevirtual 786	java/io/IOException:printStackTrace	()V
    //   1104: goto -790 -> 314
    //   1107: astore 9
    //   1109: aload 9
    //   1111: invokevirtual 786	java/io/IOException:printStackTrace	()V
    //   1114: goto -137 -> 977
    //   1117: iconst_0
    //   1118: istore 7
    //   1120: goto -781 -> 339
    //   1123: astore_1
    //   1124: aconst_null
    //   1125: astore 11
    //   1127: goto -160 -> 967
    //   1130: astore 9
    //   1132: aload_1
    //   1133: astore 11
    //   1135: aload 9
    //   1137: astore_1
    //   1138: goto -171 -> 967
    //   1141: astore 9
    //   1143: aload 10
    //   1145: astore 12
    //   1147: aload 13
    //   1149: astore_1
    //   1150: goto -931 -> 219
    //   1153: astore 10
    //   1155: aload 9
    //   1157: astore 12
    //   1159: aload 11
    //   1161: astore_1
    //   1162: aload 10
    //   1164: astore 9
    //   1166: goto -947 -> 219
    //   1169: iconst_0
    //   1170: istore 6
    //   1172: goto -855 -> 317
    //   1175: iconst_1
    //   1176: istore 6
    //   1178: goto -861 -> 317
    //   1181: aload 10
    //   1183: astore 9
    //   1185: goto -765 -> 420
    //   1188: aload 10
    //   1190: astore 9
    //   1192: goto -772 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1195	0	this	ProfileCardTemplate
    //   0	1195	1	paramQQAppInterface	QQAppInterface
    //   0	1195	2	paramLong1	long
    //   0	1195	4	paramLong2	long
    //   189	988	6	i1	int
    //   337	782	7	bool1	boolean
    //   875	194	8	bool2	boolean
    //   11	191	9	localObject1	Object
    //   214	88	9	localException1	Exception
    //   347	677	9	localObject2	Object
    //   1107	3	9	localIOException	java.io.IOException
    //   1130	6	9	localObject3	Object
    //   1141	15	9	localException2	Exception
    //   1164	27	9	localObject4	Object
    //   54	1090	10	str1	String
    //   1153	36	10	localException3	Exception
    //   148	1012	11	localObject5	Object
    //   152	1006	12	localObject6	Object
    //   98	1050	13	localObject7	Object
    //   118	358	14	str2	String
    //   414	17	15	localIterator	Iterator
    //   513	286	16	str3	String
    //   494	320	17	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   154	163	214	java/lang/Exception
    //   167	174	214	java/lang/Exception
    //   178	191	214	java/lang/Exception
    //   201	211	214	java/lang/Exception
    //   356	373	214	java/lang/Exception
    //   382	390	214	java/lang/Exception
    //   394	405	214	java/lang/Exception
    //   409	416	214	java/lang/Exception
    //   446	457	214	java/lang/Exception
    //   461	469	214	java/lang/Exception
    //   473	483	214	java/lang/Exception
    //   487	496	214	java/lang/Exception
    //   505	515	214	java/lang/Exception
    //   524	532	214	java/lang/Exception
    //   539	550	214	java/lang/Exception
    //   554	568	214	java/lang/Exception
    //   577	589	214	java/lang/Exception
    //   593	599	214	java/lang/Exception
    //   603	647	214	java/lang/Exception
    //   654	665	214	java/lang/Exception
    //   669	685	214	java/lang/Exception
    //   692	703	214	java/lang/Exception
    //   707	722	214	java/lang/Exception
    //   729	740	214	java/lang/Exception
    //   744	759	214	java/lang/Exception
    //   766	777	214	java/lang/Exception
    //   781	791	214	java/lang/Exception
    //   798	809	214	java/lang/Exception
    //   813	823	214	java/lang/Exception
    //   830	836	214	java/lang/Exception
    //   840	874	214	java/lang/Exception
    //   919	925	214	java/lang/Exception
    //   929	963	214	java/lang/Exception
    //   983	989	214	java/lang/Exception
    //   993	1021	214	java/lang/Exception
    //   886	891	898	java/io/IOException
    //   13	47	910	finally
    //   47	56	910	finally
    //   61	97	910	finally
    //   104	120	910	finally
    //   310	314	910	finally
    //   322	331	910	finally
    //   886	891	910	finally
    //   899	903	910	finally
    //   972	977	910	finally
    //   977	979	910	finally
    //   1055	1063	910	finally
    //   1064	1068	910	finally
    //   1080	1085	910	finally
    //   1092	1096	910	finally
    //   1100	1104	910	finally
    //   1109	1114	910	finally
    //   154	163	966	finally
    //   167	174	966	finally
    //   178	191	966	finally
    //   201	211	966	finally
    //   356	373	966	finally
    //   382	390	966	finally
    //   394	405	966	finally
    //   409	416	966	finally
    //   420	442	966	finally
    //   446	457	966	finally
    //   461	469	966	finally
    //   473	483	966	finally
    //   487	496	966	finally
    //   505	515	966	finally
    //   524	532	966	finally
    //   539	550	966	finally
    //   554	568	966	finally
    //   577	589	966	finally
    //   593	599	966	finally
    //   603	647	966	finally
    //   654	665	966	finally
    //   669	685	966	finally
    //   692	703	966	finally
    //   707	722	966	finally
    //   729	740	966	finally
    //   744	759	966	finally
    //   766	777	966	finally
    //   781	791	966	finally
    //   798	809	966	finally
    //   813	823	966	finally
    //   830	836	966	finally
    //   840	874	966	finally
    //   919	925	966	finally
    //   929	963	966	finally
    //   983	989	966	finally
    //   993	1021	966	finally
    //   1055	1063	1063	java/io/IOException
    //   1080	1085	1091	java/io/IOException
    //   310	314	1099	java/io/IOException
    //   972	977	1107	java/io/IOException
    //   120	150	1123	finally
    //   1028	1044	1123	finally
    //   219	301	1130	finally
    //   301	306	1130	finally
    //   120	150	1141	java/lang/Exception
    //   1028	1044	1141	java/lang/Exception
    //   420	442	1153	java/lang/Exception
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = getClass().getFields();
    localStringBuilder.append("ProfileCardTemplate:");
    int i2 = arrayOfField.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        Field localField = arrayOfField[i1];
        if (localField.getModifiers() != 8) {}
        try
        {
          Object localObject = localField.get(this);
          localStringBuilder.append(localField.getName());
          localStringBuilder.append('=');
          localStringBuilder.append(localObject);
          localStringBuilder.append(',');
          i1 += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardTemplate
 * JD-Core Version:    0.7.0.1
 */