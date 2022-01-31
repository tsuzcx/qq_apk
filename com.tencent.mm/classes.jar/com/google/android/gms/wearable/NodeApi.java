package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public abstract interface NodeApi
{
  @Deprecated
  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, NodeListener paramNodeListener);
  
  public abstract PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient paramGoogleApiClient);
  
  @Deprecated
  public abstract PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, NodeListener paramNodeListener);
  
  public static abstract interface GetConnectedNodesResult
    extends Result
  {
    public abstract List<Node> getNodes();
  }
  
  @Deprecated
  public static abstract interface NodeListener
  {
    @Deprecated
    public abstract void onPeerConnected(Node paramNode);
    
    @Deprecated
    public abstract void onPeerDisconnected(Node paramNode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.NodeApi
 * JD-Core Version:    0.7.0.1
 */