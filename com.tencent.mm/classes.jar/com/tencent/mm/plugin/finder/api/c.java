package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"info", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "toLocal", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "local", "toServer", "plugin-finder-base_release"})
public final class c
{
  public static final i a(FinderContact paramFinderContact, i parami)
  {
    AppMethodBeat.i(258174);
    p.k(paramFinderContact, "$this$toLocal");
    label27:
    i locali;
    String str;
    long l;
    if (!Util.isNullOrNil(paramFinderContact.username))
    {
      i = 1;
      if (i == 0) {
        break label391;
      }
      if (paramFinderContact == null) {
        break label406;
      }
      locali = parami;
      if (parami == null) {
        locali = new i();
      }
      str = paramFinderContact.username;
      parami = str;
      if (str == null) {
        parami = "";
      }
      locali.setUsername(parami);
      str = paramFinderContact.headUrl;
      parami = str;
      if (str == null) {
        parami = "";
      }
      locali.aAS(parami);
      str = paramFinderContact.nickname;
      parami = str;
      if (str == null) {
        parami = "";
      }
      locali.setNickname(parami);
      locali.field_version = paramFinderContact.seq;
      str = paramFinderContact.signature;
      parami = str;
      if (str == null) {
        parami = "";
      }
      locali.field_signature = parami;
      locali.field_follow_Flag = paramFinderContact.followFlag;
      str = paramFinderContact.nickname;
      parami = str;
      if (str == null) {
        parami = "";
      }
      locali.field_pyInitial = f.ZK(parami);
      locali.field_followTime = paramFinderContact.followTime;
      str = paramFinderContact.coverImgUrl;
      parami = str;
      if (str == null) {
        parami = "";
      }
      locali.field_coverImg = parami;
      locali.field_spamStatus = paramFinderContact.spamStatus;
      locali.field_authInfo = paramFinderContact.authInfo;
      locali.field_extInfo = paramFinderContact.extInfo;
      locali.field_originalFlag = paramFinderContact.originalFlag;
      locali.field_originalEntranceFlag = paramFinderContact.originalEntranceFlag;
      locali.field_originalInfo = paramFinderContact.originalInfo;
      locali.field_extFlag = paramFinderContact.extFlag;
      locali.field_liveCoverImg = paramFinderContact.liveCoverImgUrl;
      locali.field_liveStatus = paramFinderContact.liveStatus;
      parami = paramFinderContact.live_info;
      if (parami == null) {
        break label396;
      }
      l = parami.SEj;
      label310:
      locali.field_liveAnchorStatusFlag = l;
      locali.field_friendFollowCount = paramFinderContact.friend_follow_count;
      parami = paramFinderContact.live_info;
      if (parami == null) {
        break label401;
      }
    }
    label391:
    label396:
    label401:
    for (int i = parami.SEk;; i = 0)
    {
      locali.field_liveSwitchFlag = i;
      str = paramFinderContact.wx_username_v5;
      parami = str;
      if (str == null) {
        parami = "";
      }
      locali.field_v5username = parami;
      locali.field_feedCount = paramFinderContact.feedCount;
      AppMethodBeat.o(258174);
      return locali;
      i = 0;
      break;
      paramFinderContact = null;
      break label27;
      l = 0L;
      break label310;
    }
    label406:
    Log.e("Finder.FinderContactEx", "error FinderContact username is null " + Util.getStack());
    paramFinderContact = new i();
    AppMethodBeat.o(258174);
    return paramFinderContact;
  }
  
  public static final FinderContact a(i parami)
  {
    AppMethodBeat.i(258175);
    p.k(parami, "$this$toServer");
    FinderContact localFinderContact = new FinderContact();
    localFinderContact.username = parami.getUsername();
    localFinderContact.headUrl = parami.Mm();
    localFinderContact.nickname = parami.getNickname();
    localFinderContact.seq = parami.field_version;
    localFinderContact.signature = parami.field_signature;
    localFinderContact.followFlag = parami.field_follow_Flag;
    localFinderContact.followTime = parami.field_followTime;
    localFinderContact.coverImgUrl = parami.field_coverImg;
    localFinderContact.authInfo = parami.field_authInfo;
    localFinderContact.coverImgUrl = parami.field_coverImg;
    localFinderContact.spamStatus = parami.field_spamStatus;
    localFinderContact.extInfo = parami.field_extInfo;
    localFinderContact.originalFlag = parami.field_originalFlag;
    localFinderContact.originalEntranceFlag = parami.field_originalEntranceFlag;
    localFinderContact.originalInfo = parami.field_originalInfo;
    localFinderContact.extFlag = parami.field_extFlag;
    localFinderContact.liveCoverImgUrl = parami.field_liveCoverImg;
    localFinderContact.liveStatus = parami.field_liveStatus;
    Object localObject = new arf();
    ((arf)localObject).SEj = parami.field_liveAnchorStatusFlag;
    ((arf)localObject).SEk = ((int)parami.field_liveSwitchFlag);
    localFinderContact.live_info = ((arf)localObject);
    localFinderContact.friend_follow_count = parami.field_friendFollowCount;
    localObject = parami.field_v5username;
    parami = (i)localObject;
    if (localObject == null) {
      parami = "";
    }
    localFinderContact.wx_username_v5 = parami;
    AppMethodBeat.o(258175);
    return localFinderContact;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.c
 * JD-Core Version:    0.7.0.1
 */