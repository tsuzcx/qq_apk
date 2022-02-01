package com.tencent.mm.plugin.flash.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
{
  private static JSONObject a(JSONObject paramJSONObject, int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(264781);
    JSONObject localJSONObject1 = new JSONObject();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(264781);
      return localJSONObject1;
      localJSONObject1.put("face_image", YTAGFaceReflectForWXJNIInterface.verifyDataToJpg(paramString, paramJSONObject.getJSONObject("live_image").getString("image")));
      paramJSONObject = paramJSONObject.getJSONObject("live_image").getJSONArray("five_points");
      paramString = new JSONArray();
      for (paramInt = i; paramInt < paramJSONObject.length(); paramInt = paramInt + 1 + 1)
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("x", Util.getFloat(String.valueOf(paramJSONObject.get(paramInt)), 0.0F));
        localJSONObject2.put("y", Util.getFloat(String.valueOf(paramJSONObject.get(paramInt + 1)), 0.0F));
        paramString.put(localJSONObject2);
      }
      localJSONObject1.put("coordinate_list", paramString);
      continue;
      localJSONObject1.put("face_image", YTAGFaceReflectForWXJNIInterface.verifyDataToJpg(paramString, paramJSONObject.getJSONObject("livedata").getJSONArray("frames").getJSONObject(0).getString("image")));
      paramJSONObject = new JSONArray();
      for (paramInt = 0; paramInt < 90; paramInt = paramInt + 1 + 1)
      {
        paramString = new JSONObject();
        paramString.put("x", 0);
        paramString.put("y", 0);
        paramJSONObject.put(paramString);
      }
      localJSONObject1.put("coordinate_list", paramJSONObject);
    }
  }
  
  private static byte[] iA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(264794);
    paramString1 = YTAGFaceReflectForWXJNIInterface.encrypt(paramString1, paramString2, paramString2.getBytes().length);
    AppMethodBeat.o(264794);
    return paramString1;
  }
  
  public static String j(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(264843);
    for (;;)
    {
      JSONObject localJSONObject1;
      try
      {
        localJSONObject1 = new JSONObject(paramString1);
        ng localng = new ng();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("app_id", paramString3);
        localJSONObject2.put("business_name", "");
        localJSONObject2.put("person_id", "");
        localJSONObject2.put("live_type", paramInt);
        localJSONObject2.put("req_type", "live");
        paramString1 = new JSONObject();
        switch (paramInt)
        {
        case 3: 
          paramString3 = new JSONObject();
          localJSONObject2.put("livedata", paramString3);
          paramString1 = new JSONArray();
          paramString1.put(a(localJSONObject1, paramInt, paramString2));
          localJSONObject2.put("face_frame_list", paramString1);
          paramString1 = o(paramString2, localJSONObject2);
          localng.YOZ = b.cX(paramString1);
          localng.YOY = b.cX(v(paramString2, paramString1));
          paramString1 = k.dPd();
          k.e(localng.toByteArray(), paramString1);
          Log.i("MicroMsg.FaceFlashDataUtil", "save verify result to bioId:%s file:%s  fileSize:%s  fileMd5:%s", new Object[] { paramString2, paramString1, Long.valueOf(y.bEl(paramString1)), y.bEs(paramString1) });
          AppMethodBeat.o(264843);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramString1, "reflect get yt result data error", new Object[0]);
        AppMethodBeat.o(264843);
        return "";
      }
      paramString3 = new JSONObject();
      paramString3.put("reflect_data", localJSONObject1.optJSONObject("reflect_data"));
      paramString3.put("color_data", localJSONObject1.optString("color_data"));
      paramString3.put("platform", 2);
      paramString1.put("live_image", localJSONObject1.optJSONObject("live_image"));
      paramString1.put("eye_image", localJSONObject1.optJSONObject("eye_image"));
      paramString1.put("mouth_image", localJSONObject1.optJSONObject("mouth_image"));
      paramString1.put("action_video", localJSONObject1.getString("action_video"));
      paramString1.put("select_data", localJSONObject1.optJSONObject("select_data").toString());
      paramString1.put("action_str", localJSONObject1.optString("action_str", ""));
      paramString1.put("check_conf", localJSONObject1.optJSONObject("check_conf"));
      paramString1.put("mode", localJSONObject1.optInt("mode"));
      paramString3.put("onetwinkle_data", paramString1);
      continue;
      paramString3 = localJSONObject1.getJSONObject("livedata");
      paramString1 = paramString3;
      if (paramString3 == null)
      {
        paramString1 = new JSONObject();
        Log.e("MicroMsg.FaceFlashManagerError", "LIVE_REFLECTION does not have livedata");
      }
      paramString3 = paramString1;
      if (paramString1.has("select_data"))
      {
        paramString3 = new JSONObject();
        paramString3.put("select_data", paramString1.optJSONObject("select_data").toString());
        paramString1.put("onetwinkle_data", paramString3);
        paramString3 = paramString1;
      }
    }
  }
  
  public static byte[] l(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(264822);
    paramJSONObject = paramJSONObject.getJSONObject("livedata");
    paramJSONObject.put("time_point_list", new JSONArray());
    Object localObject1 = paramJSONObject.getJSONArray("frames");
    paramJSONObject.remove("frames");
    JSONArray localJSONArray1 = new JSONArray();
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      localObject4 = (JSONObject)((JSONArray)localObject1).get(i);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("face_image", ((JSONObject)localObject4).get("image"));
      localObject3 = ((JSONObject)localObject4).getJSONArray("x_coordinates");
      localObject4 = ((JSONObject)localObject4).getJSONArray("y_coordinates");
      JSONArray localJSONArray2 = new JSONArray();
      int j = 0;
      while (j < ((JSONArray)localObject3).length())
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("x", ((JSONArray)localObject3).get(j));
        localJSONObject.put("y", ((JSONArray)localObject4).get(j));
        localJSONArray2.put(localJSONObject);
        j += 1;
      }
      ((JSONObject)localObject2).put("coordinate_list", localJSONArray2);
      localJSONArray1.put(localObject2);
      i += 1;
    }
    paramJSONObject.put("face_live_pic_list_new", localJSONArray1);
    if (paramJSONObject.has("select_data"))
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("select_data", paramJSONObject.optJSONObject("select_data").toString());
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("onetwinkle_data", localObject2);
      paramJSONObject.put("livedata", localObject3);
    }
    localObject1 = ((JSONArray)localObject1).getJSONObject(0).getString("image");
    Object localObject2 = paramJSONObject.getString("mouth_lip_reading");
    Object localObject3 = new JSONArray();
    Object localObject4 = new JSONObject();
    ((JSONObject)localObject4).put("face_image", FaceProNative.addVerifyData2Jpg(paramString, (String)localObject2, (String)localObject1));
    ((JSONObject)localObject4).put("coordinate_list", localJSONArray1.getJSONObject(0).get("coordinate_list"));
    ((JSONArray)localObject3).put(localObject4);
    paramJSONObject.put("face_frame_list", localObject3);
    paramJSONObject = o(paramString, paramJSONObject);
    AppMethodBeat.o(264822);
    return paramJSONObject;
  }
  
  private static byte[] o(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(264787);
    paramString = iA(paramString, paramJSONObject.toString());
    AppMethodBeat.o(264787);
    return paramString;
  }
  
  public static byte[] v(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(264805);
    JSONObject localJSONObject = new JSONObject();
    paramArrayOfByte = YTAGFaceReflectForWXJNIInterface.faceMd5(paramArrayOfByte, paramArrayOfByte.length);
    localJSONObject.put("face_lib_version", 3);
    localJSONObject.put("md5", paramArrayOfByte);
    Log.i("MicroMsg.FaceFlashDataUtil", "getBioHeader md5:%s", new Object[] { paramArrayOfByte });
    paramString = iA(paramString, localJSONObject.toString());
    AppMethodBeat.o(264805);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b.f
 * JD-Core Version:    0.7.0.1
 */