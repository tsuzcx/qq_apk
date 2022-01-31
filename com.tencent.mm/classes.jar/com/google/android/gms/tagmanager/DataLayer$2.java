package com.google.android.gms.tagmanager;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class DataLayer$2
  implements DataLayer.zzc.zza
{
  DataLayer$2(DataLayer paramDataLayer) {}
  
  public void zzM(List<DataLayer.zza> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DataLayer.zza localzza = (DataLayer.zza)paramList.next();
      DataLayer.zza(this.zzbFN, this.zzbFN.zzo(localzza.zzAX, localzza.mValue));
    }
    DataLayer.zza(this.zzbFN).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.DataLayer.2
 * JD-Core Version:    0.7.0.1
 */