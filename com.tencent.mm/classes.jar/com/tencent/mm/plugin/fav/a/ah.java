package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.ary;
import java.util.List;

public abstract interface ah
  extends a
{
  public abstract void checkFavItem(ary paramary);
  
  public abstract void checkFavItem(List<arl> paramList);
  
  public abstract List<g> getAllUploadFailItem();
  
  public abstract s getCheckCdnService();
  
  public abstract v getEditService();
  
  public abstract p getFavCdnService();
  
  public abstract r getFavCdnStorage();
  
  public abstract t getFavConfigStorage();
  
  public abstract u getFavEditInfoStorage();
  
  public abstract y getFavItemInfoStorage();
  
  public abstract ac getFavSearchStorage();
  
  public abstract long getFavSizeLimit(boolean paramBoolean, int paramInt);
  
  public abstract int getFavSizeLimitInMB(boolean paramBoolean, int paramInt);
  
  public abstract l getFavTagSetMgr();
  
  public abstract long getFileSizeLimit(boolean paramBoolean);
  
  public abstract int getFileSizeLimitInMB(boolean paramBoolean);
  
  public abstract int getImageSizeLimitInMB(boolean paramBoolean);
  
  public abstract aa getModService();
  
  public abstract ae getSendService();
  
  public abstract long getVideoSizeLimit(boolean paramBoolean);
  
  public abstract int getVideoSizeLimitInMB(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ah
 * JD-Core Version:    0.7.0.1
 */