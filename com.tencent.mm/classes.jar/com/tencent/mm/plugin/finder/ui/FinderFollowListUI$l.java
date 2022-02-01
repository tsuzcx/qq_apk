package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderContact;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderFollowListUI$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "getFIRST_PAGE_FILE_NAME", "()Ljava/lang/String;", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "plugin-finder_release"})
public final class FinderFollowListUI$l
{
  public static com.tencent.mm.plugin.finder.api.f c(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(199224);
    k.h(paramFinderContact, "fcontact");
    com.tencent.mm.plugin.finder.api.f localf = new com.tencent.mm.plugin.finder.api.f();
    String str2 = paramFinderContact.username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localf.setUsername(str1);
    str2 = paramFinderContact.headUrl;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localf.YQ(str1);
    str2 = paramFinderContact.nickname;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localf.nd(str1);
    localf.field_version = paramFinderContact.seq;
    str2 = paramFinderContact.signature;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localf.field_signature = str1;
    localf.field_follow_Flag = paramFinderContact.followFlag;
    str2 = paramFinderContact.nickname;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localf.field_pyInitial = com.tencent.mm.platformtools.f.Bs(str1);
    localf.field_followTime = paramFinderContact.followTime;
    str2 = paramFinderContact.coverImgUrl;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localf.field_coverImg = str1;
    localf.field_spamStatus = paramFinderContact.spamStatus;
    localf.field_authInfo = paramFinderContact.authInfo;
    localf.field_extInfo = paramFinderContact.extInfo;
    AppMethodBeat.o(199224);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFollowListUI.l
 * JD-Core Version:    0.7.0.1
 */