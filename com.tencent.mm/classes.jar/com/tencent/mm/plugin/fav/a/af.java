package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.akg;
import java.util.List;

public abstract interface af
  extends d
{
  public abstract void checkFavItem(akg paramakg);
  
  public abstract void checkFavItem(List<ajt> paramList);
  
  public abstract r getCheckCdnService();
  
  public abstract u getEditService();
  
  public abstract o getFavCdnService();
  
  public abstract q getFavCdnStorage();
  
  public abstract s getFavConfigStorage();
  
  public abstract t getFavEditInfoStorage();
  
  public abstract x getFavItemInfoStorage();
  
  public abstract aa getFavSearchStorage();
  
  public abstract int getFavSizeLimit(boolean paramBoolean, int paramInt);
  
  public abstract int getFavSizeLimitInMB(boolean paramBoolean, int paramInt);
  
  public abstract l getFavTagSetMgr();
  
  public abstract int getFileSizeLimit(boolean paramBoolean);
  
  public abstract int getFileSizeLimitInMB(boolean paramBoolean);
  
  public abstract int getImageSizeLimitInMB(boolean paramBoolean);
  
  public abstract z getModService();
  
  public abstract ac getSendService();
  
  public abstract int getVideoSizeLimit(boolean paramBoolean);
  
  public abstract int getVideoSizeLimitInMB(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.af
 * JD-Core Version:    0.7.0.1
 */