package com.facebook.share.internal;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class OpenGraphJSONUtility
{
  private static JSONArray toJSONArray(List paramList, PhotoJSONProcessor paramPhotoJSONProcessor)
  {
    AppMethodBeat.i(8188);
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put(toJSONValue(paramList.next(), paramPhotoJSONProcessor));
    }
    AppMethodBeat.o(8188);
    return localJSONArray;
  }
  
  public static JSONObject toJSONObject(ShareOpenGraphAction paramShareOpenGraphAction, PhotoJSONProcessor paramPhotoJSONProcessor)
  {
    AppMethodBeat.i(8186);
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramShareOpenGraphAction.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject.put(str, toJSONValue(paramShareOpenGraphAction.get(str), paramPhotoJSONProcessor));
    }
    AppMethodBeat.o(8186);
    return localJSONObject;
  }
  
  private static JSONObject toJSONObject(ShareOpenGraphObject paramShareOpenGraphObject, PhotoJSONProcessor paramPhotoJSONProcessor)
  {
    AppMethodBeat.i(8187);
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramShareOpenGraphObject.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject.put(str, toJSONValue(paramShareOpenGraphObject.get(str), paramPhotoJSONProcessor));
    }
    AppMethodBeat.o(8187);
    return localJSONObject;
  }
  
  public static Object toJSONValue(Object paramObject, PhotoJSONProcessor paramPhotoJSONProcessor)
  {
    AppMethodBeat.i(8189);
    if (paramObject == null)
    {
      paramObject = JSONObject.NULL;
      AppMethodBeat.o(8189);
      return paramObject;
    }
    if (((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)))
    {
      AppMethodBeat.o(8189);
      return paramObject;
    }
    if ((paramObject instanceof SharePhoto))
    {
      if (paramPhotoJSONProcessor != null)
      {
        paramObject = paramPhotoJSONProcessor.toJSONObject((SharePhoto)paramObject);
        AppMethodBeat.o(8189);
        return paramObject;
      }
      AppMethodBeat.o(8189);
      return null;
    }
    if ((paramObject instanceof ShareOpenGraphObject))
    {
      paramObject = toJSONObject((ShareOpenGraphObject)paramObject, paramPhotoJSONProcessor);
      AppMethodBeat.o(8189);
      return paramObject;
    }
    if ((paramObject instanceof List))
    {
      paramObject = toJSONArray((List)paramObject, paramPhotoJSONProcessor);
      AppMethodBeat.o(8189);
      return paramObject;
    }
    paramObject = new IllegalArgumentException("Invalid object found for JSON serialization: " + paramObject.toString());
    AppMethodBeat.o(8189);
    throw paramObject;
  }
  
  public static abstract interface PhotoJSONProcessor
  {
    public abstract JSONObject toJSONObject(SharePhoto paramSharePhoto);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.OpenGraphJSONUtility
 * JD-Core Version:    0.7.0.1
 */