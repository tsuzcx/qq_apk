package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.tasks.Task;
import java.util.List;

public abstract class NodeClient
  extends GoogleApi<Wearable.WearableOptions>
{
  public NodeClient(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, Wearable.API, null, paramSettings);
  }
  
  public NodeClient(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, Wearable.API, null, paramSettings);
  }
  
  public abstract Task<List<Node>> getConnectedNodes();
  
  public abstract Task<Node> getLocalNode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.NodeClient
 * JD-Core Version:    0.7.0.1
 */