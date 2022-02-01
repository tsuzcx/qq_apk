package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.aof;
import java.util.List;

public abstract interface ag
  extends a
{
  public abstract void checkFavItem(aof paramaof);
  
  public abstract void checkFavItem(List<ans> paramList);
  
  public abstract s getCheckCdnService();
  
  public abstract v getEditService();
  
  public abstract p getFavCdnService();
  
  public abstract r getFavCdnStorage();
  
  public abstract t getFavConfigStorage();
  
  public abstract u getFavEditInfoStorage();
  
  public abstract y getFavItemInfoStorage();
  
  public abstract ab getFavSearchStorage();
  
  public abstract long getFavSizeLimit(boolean paramBoolean, int paramInt);
  
  public abstract int getFavSizeLimitInMB(boolean paramBoolean, int paramInt);
  
  public abstract l getFavTagSetMgr();
  
  public abstract long getFileSizeLimit(boolean paramBoolean);
  
  public abstract int getFileSizeLimitInMB(boolean paramBoolean);
  
  public abstract int getImageSizeLimitInMB(boolean paramBoolean);
  
  public abstract aa getModService();
  
  public abstract ad getSendService();
  
  public abstract long getVideoSizeLimit(boolean paramBoolean);
  
  public abstract int getVideoSizeLimitInMB(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ag
 * JD-Core Version:    0.7.0.1
 */