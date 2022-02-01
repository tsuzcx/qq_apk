package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.Client;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class zzap
  extends zzat
{
  private final ArrayList<Api.Client> zzib;
  
  public zzap(ArrayList<Api.Client> paramArrayList)
  {
    super(paramArrayList, null);
    Object localObject;
    this.zzib = localObject;
  }
  
  public final void zzaq()
  {
    AppMethodBeat.i(11247);
    zzaj.zzd(this.zzhv).zzfq.zzim = zzaj.zzg(this.zzhv);
    ArrayList localArrayList = (ArrayList)this.zzib;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = localArrayList.get(i);
      i += 1;
      ((Api.Client)localObject).getRemoteService(zzaj.zzh(this.zzhv), zzaj.zzd(this.zzhv).zzfq.zzim);
    }
    AppMethodBeat.o(11247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzap
 * JD-Core Version:    0.7.0.1
 */