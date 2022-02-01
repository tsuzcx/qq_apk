package com.tencent.mapsdk.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class lq
  implements RequestProcessor
{
  private final String b;
  
  static
  {
    AppMethodBeat.i(222891);
    if (!lq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      AppMethodBeat.o(222891);
      return;
    }
  }
  
  private lq(String paramString)
  {
    this.b = paramString;
  }
  
  public static lq a(String paramString)
  {
    AppMethodBeat.i(222867);
    paramString = new lq(paramString);
    AppMethodBeat.o(222867);
    return paramString;
  }
  
  private static void a(NetRequest paramNetRequest, String paramString)
  {
    AppMethodBeat.i(222883);
    if ((paramNetRequest == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(222883);
      return;
    }
    Uri localUri = Uri.parse(paramNetRequest.url);
    HashMap localHashMap = new HashMap();
    switch (1.a[paramNetRequest.mNetMethod.ordinal()])
    {
    }
    for (;;)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localUri.getPath()).append("?");
      Object localObject2;
      int i;
      String str;
      Object localObject3;
      if (!localHashMap.isEmpty())
      {
        localObject2 = new ArrayList(localHashMap.keySet());
        Collections.sort((List)localObject2);
        i = 0;
        for (;;)
        {
          if (i < ((List)localObject2).size())
          {
            str = (String)((List)localObject2).get(i);
            localObject3 = localHashMap.get(str);
            if (localObject3 != null)
            {
              if (i == ((List)localObject2).size() - 1) {
                ((StringBuilder)localObject1).append(str).append("=").append(localObject3.toString());
              }
            }
            else
            {
              i += 1;
              continue;
              localObject1 = localUri.getQuery();
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break;
              }
              if ((!a) && (localObject1 == null))
              {
                paramNetRequest = new AssertionError();
                AppMethodBeat.o(222883);
                throw paramNetRequest;
              }
              localObject1 = ((String)localObject1).split("&");
              int j = localObject1.length;
              i = 0;
              while (i < j)
              {
                localObject2 = localObject1[i].split("=");
                localHashMap.put(localObject2[0], localObject2[1]);
                i += 1;
              }
              if ((paramNetRequest.postData != null) && (paramNetRequest.postData.length <= 0)) {
                break;
              }
              localObject1 = new String(paramNetRequest.postData);
            }
          }
        }
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = ((JSONObject)localObject1).names();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          str = ((JSONArray)localObject2).optString(i);
          localHashMap.put(str, ((JSONObject)localObject1).opt(str));
          i += 1;
        }
        ((StringBuilder)localObject1).append(str).append("=").append(localObject3.toString()).append("&");
      }
      catch (JSONException localJSONException) {}
      ((StringBuilder)localObject1).append(paramString);
      paramString = Util.getMD5String(((StringBuilder)localObject1).toString());
      paramNetRequest.url = localUri.buildUpon().appendQueryParameter("sig", paramString).build().toString();
      AppMethodBeat.o(222883);
      return;
    }
  }
  
  public void onRequest(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(222911);
    String str1 = this.b;
    if ((paramNetRequest == null) || (TextUtils.isEmpty(str1)))
    {
      AppMethodBeat.o(222911);
      return;
    }
    Uri localUri = Uri.parse(paramNetRequest.url);
    HashMap localHashMap = new HashMap();
    switch (1.a[paramNetRequest.mNetMethod.ordinal()])
    {
    }
    for (;;)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localUri.getPath()).append("?");
      Object localObject2;
      int i;
      String str2;
      Object localObject3;
      if (!localHashMap.isEmpty())
      {
        localObject2 = new ArrayList(localHashMap.keySet());
        Collections.sort((List)localObject2);
        i = 0;
        for (;;)
        {
          if (i < ((List)localObject2).size())
          {
            str2 = (String)((List)localObject2).get(i);
            localObject3 = localHashMap.get(str2);
            if (localObject3 != null)
            {
              if (i == ((List)localObject2).size() - 1) {
                ((StringBuilder)localObject1).append(str2).append("=").append(localObject3.toString());
              }
            }
            else
            {
              i += 1;
              continue;
              localObject1 = localUri.getQuery();
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break;
              }
              if ((!a) && (localObject1 == null))
              {
                paramNetRequest = new AssertionError();
                AppMethodBeat.o(222911);
                throw paramNetRequest;
              }
              localObject1 = ((String)localObject1).split("&");
              int j = localObject1.length;
              i = 0;
              while (i < j)
              {
                localObject2 = localObject1[i].split("=");
                localHashMap.put(localObject2[0], localObject2[1]);
                i += 1;
              }
              if ((paramNetRequest.postData != null) && (paramNetRequest.postData.length <= 0)) {
                break;
              }
              localObject1 = new String(paramNetRequest.postData);
            }
          }
        }
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = ((JSONObject)localObject1).names();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          str2 = ((JSONArray)localObject2).optString(i);
          localHashMap.put(str2, ((JSONObject)localObject1).opt(str2));
          i += 1;
        }
        ((StringBuilder)localObject1).append(str2).append("=").append(localObject3.toString()).append("&");
      }
      catch (JSONException localJSONException) {}
      ((StringBuilder)localObject1).append(str1);
      str1 = Util.getMD5String(((StringBuilder)localObject1).toString());
      paramNetRequest.url = localUri.buildUpon().appendQueryParameter("sig", str1).build().toString();
      AppMethodBeat.o(222911);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lq
 * JD-Core Version:    0.7.0.1
 */