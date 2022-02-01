package com.tencent.mobileqq.magicface.drawable;

import android.text.TextUtils;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PngFrameUtil
{
  public static final String a = PngFrameUtil.class.getSimpleName();
  
  public static int a(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    return Math.abs(new Random().nextInt(paramInt));
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        return -1;
      } while (!paramString.contains("rscType"));
      i = paramString.indexOf("rscType") + "rscType".length() + 1;
    } while (i + 1 >= paramString.length());
    paramString = paramString.substring(i, i + 1);
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private PngPlayParam a(String paramString1, String paramString2)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      localPngPlayParam = new PngPlayParam();
      try
      {
        paramString1 = new JSONObject(paramString1);
        if (paramString1.has("num")) {
          localPngPlayParam.jdField_a_of_type_Int = paramString1.getInt("num");
        }
        if (paramString1.has("process_frame"))
        {
          localObject = paramString1.getJSONObject("process_frame");
          if (((JSONObject)localObject).has("repeat")) {
            localPngPlayParam.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("repeat");
          }
          if (((JSONObject)localObject).has("frame_delay")) {
            localPngPlayParam.c = ((JSONObject)localObject).getInt("frame_delay");
          }
          localObject = ((JSONObject)localObject).getJSONArray("seq_array");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            localPngPlayParam.jdField_a_of_type_ArrayOfJavaLangString = new String[((JSONArray)localObject).length()];
            i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              localPngPlayParam.jdField_a_of_type_ArrayOfJavaLangString[i] = (EmosmUtils.getPngFramePath(paramString2) + ((JSONArray)localObject).getString(i));
              i += 1;
            }
          }
        }
        Object localObject = paramString1.getJSONArray("result_frame");
        paramString1 = localPngPlayParam;
        if (localObject == null) {
          continue;
        }
        paramString1 = localPngPlayParam;
        if (((JSONArray)localObject).length() <= 0) {
          continue;
        }
        localPngPlayParam.jdField_b_of_type_ArrayOfJavaLangString = new String[((JSONArray)localObject).length()];
        int i = j;
        for (;;)
        {
          paramString1 = localPngPlayParam;
          if (i >= ((JSONArray)localObject).length()) {
            break;
          }
          localPngPlayParam.jdField_b_of_type_ArrayOfJavaLangString[i] = (EmosmUtils.getPngFramePath(paramString2) + ((JSONArray)localObject).getString(i));
          i += 1;
        }
        return localPngPlayParam;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  private String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(EmosmUtils.getPngFramePath(paramString));
    localStringBuffer.append("config.json");
    paramString = new File(localStringBuffer.toString());
    if (!paramString.exists()) {
      return null;
    }
    return FileUtils.a(paramString);
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        return 0;
      } while (!paramString.contains("value"));
      i = paramString.indexOf("value") + "value".length() + 1;
    } while (i >= paramString.length());
    paramString = paramString.substring(i);
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public int a(File paramFile)
  {
    paramFile = FileUtils.a(paramFile);
    if (!TextUtils.isEmpty(paramFile)) {
      try
      {
        paramFile = new JSONObject(paramFile);
        if (paramFile.has("rscType"))
        {
          int i = paramFile.getInt("rscType");
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "func getRscType(from local json file),type:" + i);
          }
          return i;
        }
        return 0;
      }
      catch (JSONException paramFile)
      {
        paramFile.printStackTrace();
      }
    }
    return 0;
  }
  
  public PngPlayParam a(String paramString)
  {
    return a(a(paramString), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameUtil
 * JD-Core Version:    0.7.0.1
 */