package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.io.InputStream;

@Deprecated
public abstract interface DataApi
{
  public static final String ACTION_DATA_CHANGED = "com.google.android.gms.wearable.DATA_CHANGED";
  public static final int FILTER_LITERAL = 0;
  public static final int FILTER_PREFIX = 1;
  
  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataListener paramDataListener);
  
  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataListener paramDataListener, Uri paramUri, int paramInt);
  
  public abstract PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri);
  
  public abstract PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri, int paramInt);
  
  public abstract PendingResult<DataItemResult> getDataItem(GoogleApiClient paramGoogleApiClient, Uri paramUri);
  
  public abstract PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri);
  
  public abstract PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri, int paramInt);
  
  public abstract PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, Asset paramAsset);
  
  public abstract PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, DataItemAsset paramDataItemAsset);
  
  public abstract PendingResult<DataItemResult> putDataItem(GoogleApiClient paramGoogleApiClient, PutDataRequest paramPutDataRequest);
  
  public abstract PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, DataListener paramDataListener);
  
  @Deprecated
  public static abstract interface DataItemResult
    extends Result
  {
    public abstract DataItem getDataItem();
  }
  
  @Deprecated
  public static abstract interface DataListener
  {
    public abstract void onDataChanged(DataEventBuffer paramDataEventBuffer);
  }
  
  @Deprecated
  public static abstract interface DeleteDataItemsResult
    extends Result
  {
    public abstract int getNumDeleted();
  }
  
  @Deprecated
  public static abstract interface GetFdForAssetResult
    extends Releasable, Result
  {
    public abstract ParcelFileDescriptor getFd();
    
    public abstract InputStream getInputStream();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.DataApi
 * JD-Core Version:    0.7.0.1
 */