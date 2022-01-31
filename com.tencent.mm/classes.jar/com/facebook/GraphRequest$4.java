package com.facebook;

import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

class GraphRequest$4
  implements GraphRequest.Callback
{
  GraphRequest$4(GraphRequest paramGraphRequest, GraphRequest.Callback paramCallback) {}
  
  public void onCompleted(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(71643);
    Object localObject1 = paramGraphResponse.getJSONObject();
    JSONArray localJSONArray;
    label33:
    int i;
    label40:
    label70:
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).optJSONObject("__debug__");
      if (localObject1 == null) {
        break label186;
      }
      localJSONArray = ((JSONObject)localObject1).optJSONArray("messages");
      if (localJSONArray == null) {
        break label209;
      }
      i = 0;
      if (i >= localJSONArray.length()) {
        break label209;
      }
      localObject3 = localJSONArray.optJSONObject(i);
      if (localObject3 == null) {
        break label192;
      }
      localObject1 = ((JSONObject)localObject3).optString("message");
      if (localObject3 == null) {
        break label197;
      }
      localObject2 = ((JSONObject)localObject3).optString("type");
      label84:
      if (localObject3 == null) {
        break label203;
      }
    }
    label186:
    label192:
    label197:
    label203:
    for (Object localObject3 = ((JSONObject)localObject3).optString("link");; localObject3 = null)
    {
      if ((localObject1 != null) && (localObject2 != null))
      {
        LoggingBehavior localLoggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
        if (((String)localObject2).equals("warning")) {
          localLoggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
        }
        localObject2 = localObject1;
        if (!Utility.isNullOrEmpty((String)localObject3)) {
          localObject2 = (String)localObject1 + " Link: " + (String)localObject3;
        }
        Logger.log(localLoggingBehavior, GraphRequest.TAG, (String)localObject2);
      }
      i += 1;
      break label40;
      localObject1 = null;
      break;
      localJSONArray = null;
      break label33;
      localObject1 = null;
      break label70;
      localObject2 = null;
      break label84;
    }
    label209:
    if (this.val$callback != null) {
      this.val$callback.onCompleted(paramGraphResponse);
    }
    AppMethodBeat.o(71643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.GraphRequest.4
 * JD-Core Version:    0.7.0.1
 */