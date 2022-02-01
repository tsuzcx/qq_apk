package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"info", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "toLocal", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "local", "toServer", "plugin-finder_release"})
public final class b
{
  public static final g a(FinderContact paramFinderContact, g paramg)
  {
    AppMethodBeat.i(201423);
    p.h(paramFinderContact, "$this$toLocal");
    int i;
    if (!bu.isNullOrNil(paramFinderContact.username))
    {
      i = 1;
      if (i == 0) {
        break label272;
      }
    }
    for (;;)
    {
      if (paramFinderContact == null) {
        break label277;
      }
      g localg = paramg;
      if (paramg == null) {
        localg = new g();
      }
      String str = paramFinderContact.username;
      paramg = str;
      if (str == null) {
        paramg = "";
      }
      localg.setUsername(paramg);
      str = paramFinderContact.headUrl;
      paramg = str;
      if (str == null) {
        paramg = "";
      }
      localg.ahY(paramg);
      str = paramFinderContact.nickname;
      paramg = str;
      if (str == null) {
        paramg = "";
      }
      localg.to(paramg);
      localg.field_version = paramFinderContact.seq;
      str = paramFinderContact.signature;
      paramg = str;
      if (str == null) {
        paramg = "";
      }
      localg.field_signature = paramg;
      localg.field_follow_Flag = paramFinderContact.followFlag;
      str = paramFinderContact.nickname;
      paramg = str;
      if (str == null) {
        paramg = "";
      }
      localg.field_pyInitial = f.Jl(paramg);
      localg.field_followTime = paramFinderContact.followTime;
      str = paramFinderContact.coverImgUrl;
      paramg = str;
      if (str == null) {
        paramg = "";
      }
      localg.field_coverImg = paramg;
      localg.field_spamStatus = paramFinderContact.spamStatus;
      localg.field_authInfo = paramFinderContact.authInfo;
      localg.field_extInfo = paramFinderContact.extInfo;
      localg.field_originalFlag = paramFinderContact.originalFlag;
      localg.field_originalEntranceFlag = paramFinderContact.originalEntranceFlag;
      localg.field_originalInfo = paramFinderContact.originalInfo;
      localg.field_extFlag = paramFinderContact.extFlag;
      AppMethodBeat.o(201423);
      return localg;
      i = 0;
      break;
      label272:
      paramFinderContact = null;
    }
    label277:
    ae.e("Finder.FinderContactEx", "error FinderContact username is null " + bu.fpN());
    paramFinderContact = new g();
    AppMethodBeat.o(201423);
    return paramFinderContact;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.b
 * JD-Core Version:    0.7.0.1
 */