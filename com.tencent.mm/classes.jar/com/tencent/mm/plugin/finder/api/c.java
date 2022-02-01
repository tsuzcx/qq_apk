package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizInfoForFinder;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "ignoreOneTimeFlag", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "info", "", "isShowBizIdentity", "toLocal", "local", "notCheckOneTimeFlag", "toServer", "plugin-finder-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final m a(FinderContact paramFinderContact, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(329961);
    s.u(paramFinderContact, "<this>");
    FinderContact localFinderContact;
    label30:
    m localm;
    pu localpu;
    label79:
    label86:
    label120:
    long l;
    if (!Util.isNullOrNil(paramFinderContact.username))
    {
      i = 1;
      if (i == 0) {
        break label584;
      }
      localFinderContact = paramFinderContact;
      if (localFinderContact == null) {
        break label635;
      }
      localm = paramm;
      if (paramm == null) {
        localm = new m();
      }
      paramm = localFinderContact.username;
      paramFinderContact = paramm;
      if (paramm == null) {
        paramFinderContact = "";
      }
      localm.setUsername(paramFinderContact);
      if (!paramBoolean) {
        break label590;
      }
      localpu = null;
      if (localpu != null) {
        break label600;
      }
      paramm = null;
      paramFinderContact = paramm;
      if (paramm == null) {
        paramFinderContact = localFinderContact.headUrl;
      }
      paramm = paramFinderContact;
      if (paramFinderContact == null) {
        paramm = "";
      }
      localm.auZ(paramm);
      if (localpu != null) {
        break label609;
      }
      paramm = null;
      paramFinderContact = paramm;
      if (paramm == null) {
        paramFinderContact = localFinderContact.nickname;
      }
      paramm = paramFinderContact;
      if (paramFinderContact == null) {
        paramm = "";
      }
      localm.setNickname(paramm);
      paramm = localFinderContact.headUrl;
      paramFinderContact = paramm;
      if (paramm == null) {
        paramFinderContact = "";
      }
      s.u(paramFinderContact, "rawAvatarUrl");
      localm.field_rawAvatarUrl = paramFinderContact;
      paramm = localFinderContact.nickname;
      paramFinderContact = paramm;
      if (paramm == null) {
        paramFinderContact = "";
      }
      s.u(paramFinderContact, "rawNickname");
      localm.field_rawNickname = paramFinderContact;
      localm.field_version = localFinderContact.seq;
      paramm = localFinderContact.signature;
      paramFinderContact = paramm;
      if (paramm == null) {
        paramFinderContact = "";
      }
      localm.field_signature = paramFinderContact;
      localm.field_follow_Flag = localFinderContact.followFlag;
      paramm = localFinderContact.nickname;
      paramFinderContact = paramm;
      if (paramm == null) {
        paramFinderContact = "";
      }
      localm.field_pyInitial = f.Sa(paramFinderContact);
      localm.field_followTime = localFinderContact.followTime;
      paramm = localFinderContact.coverImgUrl;
      paramFinderContact = paramm;
      if (paramm == null) {
        paramFinderContact = "";
      }
      localm.field_coverImg = paramFinderContact;
      localm.field_spamStatus = localFinderContact.spamStatus;
      localm.field_authInfo = localFinderContact.authInfo;
      localm.field_extInfo = localFinderContact.extInfo;
      localm.field_originalFlag = localFinderContact.originalFlag;
      localm.field_originalEntranceFlag = localFinderContact.originalEntranceFlag;
      localm.field_originalInfo = localFinderContact.originalInfo;
      localm.field_extFlag = localFinderContact.extFlag;
      localm.field_liveCoverImg = localFinderContact.liveCoverImgUrl;
      localm.field_liveStatus = localFinderContact.liveStatus;
      paramFinderContact = localFinderContact.live_info;
      if (paramFinderContact != null) {
        break label618;
      }
      l = 0L;
      label400:
      localm.field_liveAnchorStatusFlag = l;
      localm.field_friendFollowCount = localFinderContact.friend_follow_count;
      paramFinderContact = localFinderContact.live_info;
      if (paramFinderContact != null) {
        break label627;
      }
    }
    label584:
    label590:
    label600:
    label609:
    label618:
    label627:
    for (int i = 0;; i = paramFinderContact.ZFI)
    {
      localm.field_liveSwitchFlag = i;
      paramm = localFinderContact.wx_username_v5;
      paramFinderContact = paramm;
      if (paramm == null) {
        paramFinderContact = "";
      }
      localm.field_v5username = paramFinderContact;
      localm.field_feedCount = localFinderContact.feedCount;
      localm.field_user_mode = localFinderContact.user_mode;
      paramFinderContact = new aud();
      paramFinderContact.bind_info = localFinderContact.bind_info;
      paramm = ah.aiuX;
      localm.field_bindInfoList = paramFinderContact;
      localm.field_guestInfo = localFinderContact.guest_info;
      localm.field_coverUrl = localFinderContact.coverUrl;
      localm.field_coverEntranceFlag = localFinderContact.coverEntranceFlag;
      paramFinderContact = new bcf();
      paramFinderContact.jump_info = localFinderContact.menu;
      paramm = ah.aiuX;
      localm.field_jumpInfoList = paramFinderContact;
      localm.one_time_flag = localFinderContact.one_time_flag;
      AppMethodBeat.o(329961);
      return localm;
      i = 0;
      break;
      localFinderContact = null;
      break label30;
      localpu = b(localFinderContact);
      break label79;
      paramm = localpu.xkY;
      break label86;
      paramm = localpu.YTl;
      break label120;
      l = paramFinderContact.ZFH;
      break label400;
    }
    label635:
    Log.e("Finder.FinderContactEx", s.X("error FinderContact username is null ", Util.getStack()));
    paramFinderContact = new m();
    AppMethodBeat.o(329961);
    return paramFinderContact;
  }
  
  public static final FinderContact a(m paramm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(329975);
    s.u(paramm, "<this>");
    FinderContact localFinderContact = new FinderContact();
    localFinderContact.username = paramm.getUsername();
    localFinderContact.headUrl = paramm.dUs();
    localFinderContact.nickname = paramm.dUr();
    localFinderContact.seq = paramm.field_version;
    localFinderContact.signature = paramm.field_signature;
    localFinderContact.followFlag = paramm.field_follow_Flag;
    localFinderContact.followTime = paramm.field_followTime;
    localFinderContact.coverImgUrl = paramm.field_coverImg;
    localFinderContact.authInfo = paramm.field_authInfo;
    localFinderContact.coverImgUrl = paramm.field_coverImg;
    localFinderContact.spamStatus = paramm.field_spamStatus;
    localFinderContact.extInfo = paramm.field_extInfo;
    localFinderContact.originalFlag = paramm.field_originalFlag;
    localFinderContact.originalEntranceFlag = paramm.field_originalEntranceFlag;
    localFinderContact.originalInfo = paramm.field_originalInfo;
    localFinderContact.extFlag = paramm.field_extFlag;
    localFinderContact.liveCoverImgUrl = paramm.field_liveCoverImg;
    localFinderContact.liveStatus = paramm.field_liveStatus;
    Object localObject1 = new avn();
    ((avn)localObject1).ZFH = paramm.field_liveAnchorStatusFlag;
    ((avn)localObject1).ZFI = ((int)paramm.field_liveSwitchFlag);
    Object localObject3 = ah.aiuX;
    localFinderContact.live_info = ((avn)localObject1);
    localFinderContact.friend_follow_count = paramm.field_friendFollowCount;
    localObject3 = paramm.field_v5username;
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    localFinderContact.wx_username_v5 = ((String)localObject1);
    localFinderContact.user_mode = paramm.field_user_mode;
    localObject1 = paramm.field_bindInfoList;
    if (localObject1 == null)
    {
      localObject1 = null;
      localFinderContact.bind_info = ((LinkedList)localObject1);
      localFinderContact.guest_info = paramm.field_guestInfo;
      localFinderContact.coverUrl = paramm.field_coverUrl;
      localFinderContact.coverEntranceFlag = paramm.field_coverEntranceFlag;
      paramm = paramm.field_jumpInfoList;
      if (paramm != null) {
        break label336;
      }
    }
    label336:
    for (paramm = localObject2;; paramm = paramm.jump_info)
    {
      localFinderContact.menu = paramm;
      AppMethodBeat.o(329975);
      return localFinderContact;
      localObject1 = ((aud)localObject1).bind_info;
      break;
    }
  }
  
  public static final pu a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(329993);
    s.u(paramm, "<this>");
    int i;
    if (((paramBoolean) || ((paramm.one_time_flag & 0x1) > 0)) && ((paramm.field_user_mode == 2) || (paramm.field_user_mode == 1)))
    {
      i = 1;
      if (i == 0) {
        break label64;
      }
    }
    for (;;)
    {
      if (paramm != null) {
        break label69;
      }
      AppMethodBeat.o(329993);
      return null;
      i = 0;
      break;
      label64:
      paramm = null;
    }
    label69:
    paramm = paramm.field_bindInfoList;
    if (paramm == null)
    {
      AppMethodBeat.o(329993);
      return null;
    }
    paramm = paramm.bind_info;
    if (paramm == null)
    {
      AppMethodBeat.o(329993);
      return null;
    }
    Iterator localIterator = ((Iterable)paramm).iterator();
    if (localIterator.hasNext())
    {
      paramm = localIterator.next();
      if (((auc)paramm).ZEC == 1)
      {
        i = 1;
        label142:
        if (i == 0) {
          break label166;
        }
      }
    }
    for (;;)
    {
      paramm = (auc)paramm;
      if (paramm != null) {
        break label173;
      }
      AppMethodBeat.o(329993);
      return null;
      i = 0;
      break label142;
      label166:
      break;
      paramm = null;
    }
    label173:
    paramm = paramm.biz_info;
    if (paramm == null)
    {
      AppMethodBeat.o(329993);
      return null;
    }
    paramm = paramm.ZEL;
    if (paramm == null)
    {
      AppMethodBeat.o(329993);
      return null;
    }
    paramm = (pu)p.oL((List)paramm);
    AppMethodBeat.o(329993);
    return paramm;
  }
  
  public static final pu b(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(329983);
    s.u(paramFinderContact, "<this>");
    int i;
    if ((c(paramFinderContact)) && ((paramFinderContact.user_mode == 2) || (paramFinderContact.user_mode == 1)))
    {
      i = 1;
      if (i == 0) {
        break label58;
      }
    }
    for (;;)
    {
      if (paramFinderContact != null) {
        break label63;
      }
      AppMethodBeat.o(329983);
      return null;
      i = 0;
      break;
      label58:
      paramFinderContact = null;
    }
    label63:
    paramFinderContact = paramFinderContact.bind_info;
    if (paramFinderContact == null)
    {
      AppMethodBeat.o(329983);
      return null;
    }
    Iterator localIterator = ((Iterable)paramFinderContact).iterator();
    if (localIterator.hasNext())
    {
      paramFinderContact = localIterator.next();
      if (((auc)paramFinderContact).ZEC == 1)
      {
        i = 1;
        label119:
        if (i == 0) {
          break label143;
        }
      }
    }
    for (;;)
    {
      paramFinderContact = (auc)paramFinderContact;
      if (paramFinderContact != null) {
        break label150;
      }
      AppMethodBeat.o(329983);
      return null;
      i = 0;
      break label119;
      label143:
      break;
      paramFinderContact = null;
    }
    label150:
    paramFinderContact = paramFinderContact.biz_info;
    if (paramFinderContact == null)
    {
      AppMethodBeat.o(329983);
      return null;
    }
    paramFinderContact = paramFinderContact.ZEL;
    if (paramFinderContact == null)
    {
      AppMethodBeat.o(329983);
      return null;
    }
    paramFinderContact = (pu)p.oL((List)paramFinderContact);
    AppMethodBeat.o(329983);
    return paramFinderContact;
  }
  
  public static final boolean c(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(330003);
    s.u(paramFinderContact, "<this>");
    if ((paramFinderContact.one_time_flag & 0x1) > 0)
    {
      AppMethodBeat.o(330003);
      return true;
    }
    AppMethodBeat.o(330003);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.c
 * JD-Core Version:    0.7.0.1
 */