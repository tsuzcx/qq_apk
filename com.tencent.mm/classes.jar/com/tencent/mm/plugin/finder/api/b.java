package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"info", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "toLocal", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "local", "toServer", "plugin-finder_release"})
public final class b
{
  public static final g a(FinderContact paramFinderContact, g paramg)
  {
    AppMethodBeat.i(242182);
    p.h(paramFinderContact, "$this$toLocal");
    label27:
    g localg;
    long l;
    if (!Util.isNullOrNil(paramFinderContact.username))
    {
      i = 1;
      if (i == 0) {
        break label359;
      }
      if (paramFinderContact == null) {
        break label374;
      }
      localg = paramg;
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
      localg.asL(paramg);
      str = paramFinderContact.nickname;
      paramg = str;
      if (str == null) {
        paramg = "";
      }
      localg.setNickname(paramg);
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
      localg.field_pyInitial = f.Si(paramg);
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
      localg.field_liveCoverImg = paramFinderContact.liveCoverImgUrl;
      localg.field_liveStatus = paramFinderContact.liveStatus;
      paramg = paramFinderContact.live_info;
      if (paramg == null) {
        break label364;
      }
      l = paramg.LBA;
      label310:
      localg.field_liveAnchorStatusFlag = l;
      localg.field_friendFollowCount = paramFinderContact.friend_follow_count;
      paramFinderContact = paramFinderContact.live_info;
      if (paramFinderContact == null) {
        break label369;
      }
    }
    label359:
    label364:
    label369:
    for (int i = paramFinderContact.LBB;; i = 0)
    {
      localg.field_liveSwitchFlag = i;
      AppMethodBeat.o(242182);
      return localg;
      i = 0;
      break;
      paramFinderContact = null;
      break label27;
      l = 0L;
      break label310;
    }
    label374:
    Log.e("Finder.FinderContactEx", "error FinderContact username is null " + Util.getStack());
    paramFinderContact = new g();
    AppMethodBeat.o(242182);
    return paramFinderContact;
  }
  
  public static final FinderContact a(g paramg)
  {
    AppMethodBeat.i(242183);
    p.h(paramg, "$this$toServer");
    FinderContact localFinderContact = new FinderContact();
    localFinderContact.username = paramg.getUsername();
    localFinderContact.headUrl = paramg.cXH();
    localFinderContact.nickname = paramg.getNickname();
    localFinderContact.seq = paramg.field_version;
    localFinderContact.signature = paramg.field_signature;
    localFinderContact.followFlag = paramg.field_follow_Flag;
    localFinderContact.followTime = paramg.field_followTime;
    localFinderContact.coverImgUrl = paramg.field_coverImg;
    localFinderContact.authInfo = paramg.field_authInfo;
    localFinderContact.coverImgUrl = paramg.field_coverImg;
    localFinderContact.spamStatus = paramg.field_spamStatus;
    localFinderContact.extInfo = paramg.field_extInfo;
    localFinderContact.originalFlag = paramg.field_originalFlag;
    localFinderContact.originalEntranceFlag = paramg.field_originalEntranceFlag;
    localFinderContact.originalInfo = paramg.field_originalInfo;
    localFinderContact.extFlag = paramg.field_extFlag;
    localFinderContact.liveCoverImgUrl = paramg.field_liveCoverImg;
    localFinderContact.liveStatus = paramg.field_liveStatus;
    apr localapr = new apr();
    localapr.LBA = paramg.field_liveAnchorStatusFlag;
    localapr.LBB = ((int)paramg.field_liveSwitchFlag);
    localFinderContact.live_info = localapr;
    localFinderContact.friend_follow_count = paramg.field_friendFollowCount;
    AppMethodBeat.o(242183);
    return localFinderContact;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.b
 * JD-Core Version:    0.7.0.1
 */