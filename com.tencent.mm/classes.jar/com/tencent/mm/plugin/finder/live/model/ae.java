package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLivePoiMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getContent", "", "getPayLoadContent", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
  extends h
{
  public ae(bdm parambdm)
  {
    super(parambdm);
    AppMethodBeat.i(359188);
    AppMethodBeat.o(359188);
  }
  
  public final Object ekF()
  {
    byte[] arrayOfByte = null;
    AppMethodBeat.i(359194);
    if (this.CER.msg_type == 20035)
    {
      bel localbel = new bel();
      b localb = this.CER.ZNY;
      if (localb == null) {}
      for (;;)
      {
        localbel.parseFrom(arrayOfByte);
        AppMethodBeat.o(359194);
        return localbel;
        arrayOfByte = localb.toByteArray();
      }
    }
    AppMethodBeat.o(359194);
    return null;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(359204);
    Object localObject1 = ekF();
    if ((localObject1 instanceof bel))
    {
      localObject1 = (bel)localObject1;
      if (localObject1 != null) {
        break label55;
      }
      localObject1 = null;
      label28:
      if (localObject1 != null) {
        break label77;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label202;
      }
      localObject1 = super.getContent();
      AppMethodBeat.o(359204);
      return localObject1;
      localObject1 = null;
      break;
      label55:
      localObject1 = ((bel)localObject1).location;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label28;
      }
      localObject1 = ((boi)localObject1).city;
      break label28;
      label77:
      Object localObject2 = ekF();
      label94:
      label100:
      int i;
      if ((localObject2 instanceof bel))
      {
        localObject2 = (bel)localObject2;
        if (localObject2 != null) {
          break label155;
        }
        localObject2 = null;
        localObject2 = (CharSequence)localObject2;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label163;
        }
        i = 1;
        label120:
        if (i != 0) {
          break label181;
        }
        localObject1 = ekF();
        if (!(localObject1 instanceof bel)) {
          break label168;
        }
      }
      label155:
      label163:
      label168:
      for (localObject1 = (bel)localObject1;; localObject1 = null)
      {
        if (localObject1 != null) {
          break label173;
        }
        localObject1 = null;
        break;
        localObject2 = null;
        break label94;
        localObject2 = ((bel)localObject2).content;
        break label100;
        i = 0;
        break label120;
      }
      label173:
      localObject1 = ((bel)localObject1).content;
      continue;
      label181:
      localObject1 = MMApplicationContext.getContext().getString(p.h.finder_live_comment_i_am_in_the_specified_city, new Object[] { localObject1 });
    }
    label202:
    AppMethodBeat.o(359204);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ae
 * JD-Core Version:    0.7.0.1
 */