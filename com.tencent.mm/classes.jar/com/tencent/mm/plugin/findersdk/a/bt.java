package com.tencent.mm.plugin.findersdk.a;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsKeyWordsService;", "Lcom/tencent/mm/kernel/service/IService;", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "getKeyWordsDataList", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsKeyWordsService$GetKeyWordsDataCallback;", "removeOnStorageChange", "GetKeyWordsDataCallback", "TriggerInfo", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bt
  extends a
{
  public abstract void a(a parama);
  
  public abstract void l(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void m(MStorage.IOnStorageChange paramIOnStorageChange);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsKeyWordsService$GetKeyWordsDataCallback;", "", "onDone", "", "dataList", "", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsKeyWordsService$TriggerInfo;", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void onDone(List<bt.b> paramList);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsKeyWordsService$TriggerInfo;", "", "localId", "", "(J)V", "endTime", "", "getEndTime", "()I", "setEndTime", "(I)V", "jumpDest", "getJumpDest", "setJumpDest", "jumpScene", "getJumpScene", "setJumpScene", "keyWord", "", "getKeyWord", "()Ljava/lang/String;", "setKeyWord", "(Ljava/lang/String;)V", "getLocalId", "()J", "passByInfo", "getPassByInfo", "setPassByInfo", "starTime", "getStarTime", "setStarTime", "component1", "copy", "equals", "", "other", "hashCode", "toString", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public String BgC;
    public int Hcx;
    public int Hcy;
    public int Hcz;
    public int endTime;
    private final long localId;
    public String oQy;
    
    public b(long paramLong)
    {
      this.localId = paramLong;
      this.Hcx = -1;
      this.Hcy = -1;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return false;
        }
        paramObject = (b)paramObject;
      } while (this.localId == paramObject.localId);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(273986);
      int i = q.a..ExternalSyntheticBackport0.m(this.localId);
      AppMethodBeat.o(273986);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(273981);
      String str = "TriggerInfo(localId=" + this.localId + ')';
      AppMethodBeat.o(273981);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.bt
 * JD-Core Version:    0.7.0.1
 */