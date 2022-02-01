package com.tencent.mm.plugin.finder.live.viewmodel.data.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/ReplyBoxMsg;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "isLocal", "", "source", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(ZLcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "msgContent", "", "getMsgContent", "()Ljava/lang/String;", "setMsgContent", "(Ljava/lang/String;)V", "payload", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgReplyCommentInfo;", "getPayload", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgReplyCommentInfo;", "setPayload", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgReplyCommentInfo;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getContent", "logInfo", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends b
{
  public bes akgN;
  public String hWn;
  
  public k(bdm parambdm)
  {
    super(false, parambdm);
    AppMethodBeat.i(371677);
    a locala = (a)new bes();
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
        }
        a(parambdm);
        parambdm = this.akgN;
        if (parambdm == null) {
          break label170;
        }
      }
      parambdm = (bes)parambdm;
      if (parambdm != null) {
        break;
      }
      parambdm = localObject;
      if (parambdm == null)
      {
        parambdm = (k)this;
        parambdm.jKA();
        parambdm.a(new bes());
        parambdm.Rb("");
      }
      AppMethodBeat.o(371677);
      return;
    }
    for (;;)
    {
      str = parambdm.content;
      parambdm = str;
      if (str == null) {
        parambdm = "";
      }
      Rb(parambdm);
      parambdm = ah.aiuX;
      break;
      label170:
      s.bIx("payload");
      parambdm = str;
    }
  }
  
  private void Rb(String paramString)
  {
    AppMethodBeat.i(371689);
    s.u(paramString, "<set-?>");
    this.hWn = paramString;
    AppMethodBeat.o(371689);
  }
  
  private void a(bes parambes)
  {
    AppMethodBeat.i(371683);
    s.u(parambes, "<set-?>");
    this.akgN = parambes;
    AppMethodBeat.o(371683);
  }
  
  public final int a(com.tencent.mm.plugin.finder.feed.model.internal.k paramk)
  {
    AppMethodBeat.i(371707);
    s.u(paramk, "obj");
    if ((paramk instanceof k))
    {
      int i = super.a(paramk);
      AppMethodBeat.o(371707);
      return i;
    }
    AppMethodBeat.o(371707);
    return -1;
  }
  
  public final String eYN()
  {
    AppMethodBeat.i(371715);
    String str = "ReplyBoxMsg content:" + jKy() + ", " + super.eYN();
    AppMethodBeat.o(371715);
    return str;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(371722);
    String str = jKy();
    AppMethodBeat.o(371722);
    return str;
  }
  
  public final String jKy()
  {
    AppMethodBeat.i(371696);
    String str = this.hWn;
    if (str != null)
    {
      AppMethodBeat.o(371696);
      return str;
    }
    s.bIx("msgContent");
    AppMethodBeat.o(371696);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a.k
 * JD-Core Version:    0.7.0.1
 */