package com.tencent.mm.plugin.finder.live.viewmodel.data.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/AtBoxMsg;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "isLocal", "", "source", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(ZLcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "msgContent", "", "getMsgContent", "()Ljava/lang/String;", "setMsgContent", "(Ljava/lang/String;)V", "payload", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgFriendChatCommentInfo;", "getPayload", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgFriendChatCommentInfo;", "setPayload", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgFriendChatCommentInfo;)V", "remind_contacts", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "Lkotlin/collections/ArrayList;", "getRemind_contacts", "()Ljava/util/ArrayList;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getContent", "logInfo", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  public bed akfW;
  public final ArrayList<bgh> akfX;
  public String hWn;
  
  public a(bdm parambdm)
  {
    super(false, parambdm);
    AppMethodBeat.i(371669);
    this.akfX = new ArrayList();
    com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)new bed();
    parambdm = parambdm.ZNY;
    if (parambdm == null) {}
    for (parambdm = null;; parambdm = parambdm.toByteArray())
    {
      try
      {
        locala.parseFrom(parambdm);
        parambdm = locala;
      }
      catch (Exception parambdm)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { parambdm });
          parambdm = null;
          continue;
          a(parambdm);
          str = jKx().content;
          parambdm = str;
          if (str == null) {
            parambdm = "";
          }
          Rb(parambdm);
          parambdm = Boolean.valueOf(this.akfX.addAll((Collection)jKx().ZOH));
        }
      }
      parambdm = (bed)parambdm;
      if (parambdm != null) {
        break;
      }
      parambdm = str;
      if (parambdm == null)
      {
        parambdm = (a)this;
        parambdm.jKA();
        parambdm.a(new bed());
        parambdm.Rb("");
      }
      AppMethodBeat.o(371669);
      return;
    }
  }
  
  private void Rb(String paramString)
  {
    AppMethodBeat.i(371686);
    s.u(paramString, "<set-?>");
    this.hWn = paramString;
    AppMethodBeat.o(371686);
  }
  
  private void a(bed parambed)
  {
    AppMethodBeat.i(371680);
    s.u(parambed, "<set-?>");
    this.akfW = parambed;
    AppMethodBeat.o(371680);
  }
  
  private bed jKx()
  {
    AppMethodBeat.i(371675);
    bed localbed = this.akfW;
    if (localbed != null)
    {
      AppMethodBeat.o(371675);
      return localbed;
    }
    s.bIx("payload");
    AppMethodBeat.o(371675);
    return null;
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(371703);
    s.u(paramk, "obj");
    if ((paramk instanceof a))
    {
      int i = super.a(paramk);
      AppMethodBeat.o(371703);
      return i;
    }
    AppMethodBeat.o(371703);
    return -1;
  }
  
  public final String eYN()
  {
    AppMethodBeat.i(371713);
    String str = "AtBoxMsg, content:" + jKy() + ", contacts:" + p.a((Iterable)this.akfX, null, null, null, 0, null, (kotlin.g.a.b)a.a.akfY, 31) + ", " + super.eYN();
    AppMethodBeat.o(371713);
    return str;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(371720);
    String str = jKy();
    AppMethodBeat.o(371720);
    return str;
  }
  
  public final String jKy()
  {
    AppMethodBeat.i(371693);
    String str = this.hWn;
    if (str != null)
    {
      AppMethodBeat.o(371693);
      return str;
    }
    s.bIx("msgContent");
    AppMethodBeat.o(371693);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a.a
 * JD-Core Version:    0.7.0.1
 */