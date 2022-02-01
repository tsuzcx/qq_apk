package com.tencent.mm.plugin.finder.live.viewmodel.data.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/SysTextBoxMsg;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "isLocal", "", "source", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(ZLcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "msgContent", "", "getMsgContent", "()Ljava/lang/String;", "setMsgContent", "(Ljava/lang/String;)V", "payload", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgBoxCommentInfo;", "getPayload", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgBoxCommentInfo;", "setPayload", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgBoxCommentInfo;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getContent", "logInfo", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends b
{
  public edf akgO;
  public String hWn;
  
  public l(bdm parambdm)
  {
    super(true, parambdm);
    AppMethodBeat.i(371691);
    a locala = (a)new edf();
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
        parambdm = this.akgO;
        if (parambdm == null) {
          break label170;
        }
      }
      parambdm = (edf)parambdm;
      if (parambdm != null) {
        break;
      }
      parambdm = localObject;
      if (parambdm == null)
      {
        parambdm = (l)this;
        parambdm.jKA();
        parambdm.a(new edf());
        parambdm.Rb("");
      }
      AppMethodBeat.o(371691);
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
    AppMethodBeat.i(371718);
    s.u(paramString, "<set-?>");
    this.hWn = paramString;
    AppMethodBeat.o(371718);
  }
  
  private void a(edf paramedf)
  {
    AppMethodBeat.i(371701);
    s.u(paramedf, "<set-?>");
    this.akgO = paramedf;
    AppMethodBeat.o(371701);
  }
  
  private String jKy()
  {
    AppMethodBeat.i(371711);
    String str = this.hWn;
    if (str != null)
    {
      AppMethodBeat.o(371711);
      return str;
    }
    s.bIx("msgContent");
    AppMethodBeat.o(371711);
    return null;
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(371724);
    s.u(paramk, "obj");
    if ((paramk instanceof l))
    {
      int i = super.a(paramk);
      AppMethodBeat.o(371724);
      return i;
    }
    AppMethodBeat.o(371724);
    return -1;
  }
  
  public final String eYN()
  {
    AppMethodBeat.i(371732);
    String str = "SysTextBoxMsg content:" + jKy() + ", " + super.eYN();
    AppMethodBeat.o(371732);
    return str;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(371738);
    String str = jKy();
    AppMethodBeat.o(371738);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a.l
 * JD-Core Version:    0.7.0.1
 */