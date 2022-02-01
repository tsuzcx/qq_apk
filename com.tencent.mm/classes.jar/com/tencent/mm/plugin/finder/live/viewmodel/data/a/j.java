package com.tencent.mm.plugin.finder.live.viewmodel.data.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.w.a.a.a.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/LocationBoxMsg;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "isLocal", "", "source", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(ZLcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "msgContent", "", "getMsgContent", "()Ljava/lang/String;", "setMsgContent", "(Ljava/lang/String;)V", "payload", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLocationInfo;", "getPayload", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLocationInfo;", "setPayload", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLocationInfo;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getContent", "logInfo", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends b
{
  public bel akgM;
  public String hWn;
  public boi location;
  
  public j(bdm parambdm)
  {
    super(false, parambdm);
    AppMethodBeat.i(371673);
    a locala = (a)new bel();
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
          localObject = kLg().content;
          parambdm = (bdm)localObject;
          if (localObject == null) {
            parambdm = "";
          }
          Rb(parambdm);
          localObject = kLg().location;
          parambdm = (bdm)localObject;
          if (localObject == null) {
            parambdm = new boi();
          }
          setLocation(parambdm);
          parambdm = ah.aiuX;
        }
      }
      parambdm = (bel)parambdm;
      if (parambdm != null) {
        break;
      }
      parambdm = (bdm)localObject;
      if (parambdm == null)
      {
        parambdm = (j)this;
        parambdm.jKA();
        parambdm.a(new bel());
        parambdm.Rb("");
        parambdm.setLocation(new boi());
      }
      AppMethodBeat.o(371673);
      return;
    }
  }
  
  private void Rb(String paramString)
  {
    AppMethodBeat.i(371700);
    s.u(paramString, "<set-?>");
    this.hWn = paramString;
    AppMethodBeat.o(371700);
  }
  
  private void a(bel parambel)
  {
    AppMethodBeat.i(371687);
    s.u(parambel, "<set-?>");
    this.akgM = parambel;
    AppMethodBeat.o(371687);
  }
  
  private String jKy()
  {
    AppMethodBeat.i(371692);
    String str = this.hWn;
    if (str != null)
    {
      AppMethodBeat.o(371692);
      return str;
    }
    s.bIx("msgContent");
    AppMethodBeat.o(371692);
    return null;
  }
  
  private bel kLg()
  {
    AppMethodBeat.i(371679);
    bel localbel = this.akgM;
    if (localbel != null)
    {
      AppMethodBeat.o(371679);
      return localbel;
    }
    s.bIx("payload");
    AppMethodBeat.o(371679);
    return null;
  }
  
  private void setLocation(boi paramboi)
  {
    AppMethodBeat.i(371710);
    s.u(paramboi, "<set-?>");
    this.location = paramboi;
    AppMethodBeat.o(371710);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(371723);
    s.u(paramk, "obj");
    if ((paramk instanceof j))
    {
      int i = super.a(paramk);
      AppMethodBeat.o(371723);
      return i;
    }
    AppMethodBeat.o(371723);
    return -1;
  }
  
  public final String eYN()
  {
    AppMethodBeat.i(371731);
    String str = "LocationBoxMsg content:" + jKy() + ", location:" + getLocation().city + super.eYN();
    AppMethodBeat.o(371731);
    return str;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(371739);
    String str = getLocation().city;
    CharSequence localCharSequence = (CharSequence)jKy();
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
      localCharSequence = (CharSequence)str;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label100;
      }
    }
    label100:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label105;
      }
      str = MMApplicationContext.getContext().getString(a.i.finder_live_comment_i_am_in_the_specified_city, new Object[] { str });
      s.s(str, "{\n            MMApplicat…ied_city, city)\n        }");
      AppMethodBeat.o(371739);
      return str;
      i = 0;
      break;
    }
    label105:
    str = jKy();
    AppMethodBeat.o(371739);
    return str;
  }
  
  public final boi getLocation()
  {
    AppMethodBeat.i(371717);
    boi localboi = this.location;
    if (localboi != null)
    {
      AppMethodBeat.o(371717);
      return localboi;
    }
    s.bIx("location");
    AppMethodBeat.o(371717);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a.j
 * JD-Core Version:    0.7.0.1
 */