package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.act;
import java.util.List;

public abstract interface ae
  extends d
{
  public abstract void checkFavItem(act paramact);
  
  public abstract void checkFavItem(List<acg> paramList);
  
  public abstract r getCheckCdnService();
  
  public abstract u getEditService();
  
  public abstract o getFavCdnService();
  
  public abstract q getFavCdnStorage();
  
  public abstract s getFavConfigStorage();
  
  public abstract t getFavEditInfoStorage();
  
  public abstract x getFavItemInfoStorage();
  
  public abstract aa getFavSearchStorage();
  
  public abstract l getFavTagSetMgr();
  
  public abstract z getModService();
  
  public abstract ac getSendService();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ae
 * JD-Core Version:    0.7.0.1
 */