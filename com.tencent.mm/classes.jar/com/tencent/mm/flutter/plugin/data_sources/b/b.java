package com.tencent.mm.flutter.plugin.data_sources.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.flutter.plugin.a.c;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqz;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"toFinderItem", "Lcom/tencent/mm/flutter/plugin/proto/FinderItem;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "toFinderItemType", "", "plugin-voip-status_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final com.tencent.mm.flutter.plugin.a.b a(FinderObject paramFinderObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(233320);
    s.u(paramFinderObject, "<this>");
    com.tencent.mm.flutter.plugin.a.b localb = new com.tencent.mm.flutter.plugin.a.b();
    localb.msd = (paramFinderObject.createtime * 1000L);
    Object localObject1 = paramFinderObject.objectDesc;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localb.text = ((String)localObject1);
      localb.feedId = paramFinderObject.id;
      localb.nonceId = paramFinderObject.objectNonceId;
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 != null) {
        break label227;
      }
      i = 0;
      label82:
      localb.type = i;
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 != null) {
        break label238;
      }
    }
    label227:
    label238:
    for (localObject1 = null;; localObject1 = ((FinderObjectDesc)localObject1).media)
    {
      if (localObject1 == null) {
        break label246;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        FinderMedia localFinderMedia = (FinderMedia)((Iterator)localObject1).next();
        c localc = new c();
        localc.url = localFinderMedia.url;
        localc.msf = localFinderMedia.url_token;
        localc.thumbUrl = localFinderMedia.thumbUrl;
        localc.msh = localFinderMedia.thumb_url_token;
        localc.decodeKey = localFinderMedia.decodeKey;
        localc.mediaType = rV(localFinderMedia.mediaType);
        localb.media.add(localc);
      }
      localObject1 = ((FinderObjectDesc)localObject1).description;
      break;
      i = rV(((FinderObjectDesc)localObject1).mediaType);
      break label82;
    }
    label246:
    localObject1 = paramFinderObject.objectDesc;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        localb.mse = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).cn(((boi)localObject1).city, ((boi)localObject1).poiName);
      }
      paramFinderObject = paramFinderObject.objectDesc;
      if (paramFinderObject != null) {
        break label320;
      }
      paramFinderObject = localObject2;
    }
    for (;;)
    {
      localb.musicUrl = paramFinderObject;
      AppMethodBeat.o(233320);
      return localb;
      localObject1 = ((FinderObjectDesc)localObject1).location;
      break;
      label320:
      localObject1 = paramFinderObject.feedBgmInfo;
      paramFinderObject = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((bqz)localObject1).musicInfo;
        paramFinderObject = localObject2;
        if (localObject1 != null) {
          paramFinderObject = ((bqj)localObject1).ZYp;
        }
      }
    }
  }
  
  private static int rV(int paramInt)
  {
    AppMethodBeat.i(233315);
    switch (paramInt)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(s.X("Unsupported type: ", Integer.valueOf(paramInt)));
      AppMethodBeat.o(233315);
      throw localIllegalArgumentException;
    case 2: 
      paramInt = a.b.mrm.ordinal();
      AppMethodBeat.o(233315);
      return paramInt;
    case 4: 
      paramInt = a.b.mrn.ordinal();
      AppMethodBeat.o(233315);
      return paramInt;
    }
    paramInt = a.b.mro.ordinal();
    AppMethodBeat.o(233315);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.b.b
 * JD-Core Version:    0.7.0.1
 */