package com.tencent.mm.plugin.finder.viewmodel.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.protocal.protobuf.FinderContact;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListUIC$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "getFIRST_PAGE_FILE_NAME", "()Ljava/lang/String;", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "plugin-finder_release"})
public final class FinderFollowListUIC$a
{
  public static g f(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(206158);
    p.h(paramFinderContact, "fcontact");
    g localg = new g();
    String str2 = paramFinderContact.username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localg.setUsername(str1);
    str2 = paramFinderContact.headUrl;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localg.ahY(str1);
    str2 = paramFinderContact.nickname;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localg.to(str1);
    localg.field_version = paramFinderContact.seq;
    str2 = paramFinderContact.signature;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localg.field_signature = str1;
    localg.field_follow_Flag = paramFinderContact.followFlag;
    str2 = paramFinderContact.nickname;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localg.field_pyInitial = f.Jl(str1);
    localg.field_followTime = paramFinderContact.followTime;
    str2 = paramFinderContact.coverImgUrl;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localg.field_coverImg = str1;
    localg.field_spamStatus = paramFinderContact.spamStatus;
    localg.field_authInfo = paramFinderContact.authInfo;
    localg.field_extInfo = paramFinderContact.extInfo;
    localg.field_extFlag = paramFinderContact.extFlag;
    AppMethodBeat.o(206158);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC.a
 * JD-Core Version:    0.7.0.1
 */