package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class zzfl
  extends NodeClient
{
  private final NodeApi zzem;
  
  public zzfl(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, paramSettings);
    AppMethodBeat.i(101304);
    this.zzem = new zzfg();
    AppMethodBeat.o(101304);
  }
  
  public zzfl(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, paramSettings);
    AppMethodBeat.i(101303);
    this.zzem = new zzfg();
    AppMethodBeat.o(101303);
  }
  
  public final Task<List<Node>> getConnectedNodes()
  {
    AppMethodBeat.i(101306);
    Task localTask = PendingResultUtil.toTask(this.zzem.getConnectedNodes(asGoogleApiClient()), zzfn.zzbx);
    AppMethodBeat.o(101306);
    return localTask;
  }
  
  public final Task<Node> getLocalNode()
  {
    AppMethodBeat.i(101305);
    Task localTask = PendingResultUtil.toTask(this.zzem.getLocalNode(asGoogleApiClient()), zzfm.zzbx);
    AppMethodBeat.o(101305);
    return localTask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfl
 * JD-Core Version:    0.7.0.1
 */