package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetFileResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetJceResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import java.util.ArrayList;

public abstract interface cv
  extends ch.a
{
  @NetJceResolver(inJce=CSFileUpdateReq.class, outJce=SCFileUpdateRsp.class, queryRange={5, 10})
  @NetRequest(constQuery="pf=androidsdk&fr=02001", method=NetMethod.POST, path="fileupdate", queryKeys={"sdkver", "suid", "appsuid", "nt", "api_key"})
  public abstract ds.a<SCFileUpdateRsp> checkUpdate(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArrayList<FileUpdateReq> paramArrayList, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10);
  
  @NetFileResolver(outFile="offline_city_list.json", queryRange={0})
  @NetRequest(authority="mapapi.qq.com", method=NetMethod.GET, path="sdk/config/offline_city_detail_v2.json")
  public abstract dr.a downloadOfflineMapCityList(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cv
 * JD-Core Version:    0.7.0.1
 */