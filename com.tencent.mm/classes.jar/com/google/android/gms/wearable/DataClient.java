package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.tasks.Task;
import java.io.InputStream;

public abstract class DataClient
  extends GoogleApi<Wearable.WearableOptions>
{
  public static final String ACTION_DATA_CHANGED = "com.google.android.gms.wearable.DATA_CHANGED";
  public static final int FILTER_LITERAL = 0;
  public static final int FILTER_PREFIX = 1;
  
  public DataClient(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, Wearable.API, null, paramSettings);
  }
  
  public DataClient(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, Wearable.API, null, paramSettings);
  }
  
  public abstract Task<Void> addListener(OnDataChangedListener paramOnDataChangedListener);
  
  public abstract Task<Void> addListener(OnDataChangedListener paramOnDataChangedListener, Uri paramUri, int paramInt);
  
  public abstract Task<Integer> deleteDataItems(Uri paramUri);
  
  public abstract Task<Integer> deleteDataItems(Uri paramUri, int paramInt);
  
  public abstract Task<DataItem> getDataItem(Uri paramUri);
  
  public abstract Task<DataItemBuffer> getDataItems();
  
  public abstract Task<DataItemBuffer> getDataItems(Uri paramUri);
  
  public abstract Task<DataItemBuffer> getDataItems(Uri paramUri, int paramInt);
  
  public abstract Task<GetFdForAssetResponse> getFdForAsset(Asset paramAsset);
  
  public abstract Task<GetFdForAssetResponse> getFdForAsset(DataItemAsset paramDataItemAsset);
  
  public abstract Task<DataItem> putDataItem(PutDataRequest paramPutDataRequest);
  
  public abstract Task<Boolean> removeListener(OnDataChangedListener paramOnDataChangedListener);
  
  public static abstract class GetFdForAssetResponse
    implements Releasable
  {
    public abstract ParcelFileDescriptor getFdForAsset();
    
    public abstract InputStream getInputStream();
  }
  
  public static abstract interface OnDataChangedListener
    extends DataApi.DataListener
  {
    public abstract void onDataChanged(DataEventBuffer paramDataEventBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.DataClient
 * JD-Core Version:    0.7.0.1
 */