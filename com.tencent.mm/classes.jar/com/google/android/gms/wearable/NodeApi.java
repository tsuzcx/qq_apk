package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.util.List;

@Deprecated
public abstract interface NodeApi
{
  public abstract PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient paramGoogleApiClient);
  
  @Deprecated
  public static abstract interface GetConnectedNodesResult
    extends Result
  {
    public abstract List<Node> getNodes();
  }
  
  @Deprecated
  public static abstract interface GetLocalNodeResult
    extends Result
  {
    public abstract Node getNode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.NodeApi
 * JD-Core Version:    0.7.0.1
 */