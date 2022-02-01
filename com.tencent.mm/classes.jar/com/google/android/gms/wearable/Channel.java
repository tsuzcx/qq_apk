package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

@Deprecated
public abstract interface Channel
  extends Parcelable
{
  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener);
  
  public abstract PendingResult<Status> close(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> close(GoogleApiClient paramGoogleApiClient, int paramInt);
  
  public abstract PendingResult<GetInputStreamResult> getInputStream(GoogleApiClient paramGoogleApiClient);
  
  public abstract String getNodeId();
  
  public abstract PendingResult<GetOutputStreamResult> getOutputStream(GoogleApiClient paramGoogleApiClient);
  
  public abstract String getPath();
  
  public abstract PendingResult<Status> receiveFile(GoogleApiClient paramGoogleApiClient, Uri paramUri, boolean paramBoolean);
  
  public abstract PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener);
  
  public abstract PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, Uri paramUri);
  
  public abstract PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, Uri paramUri, long paramLong1, long paramLong2);
  
  @Deprecated
  public static abstract interface GetInputStreamResult
    extends Releasable, Result
  {
    @Nullable
    public abstract InputStream getInputStream();
  }
  
  @Deprecated
  public static abstract interface GetOutputStreamResult
    extends Releasable, Result
  {
    @Nullable
    public abstract OutputStream getOutputStream();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.Channel
 * JD-Core Version:    0.7.0.1
 */