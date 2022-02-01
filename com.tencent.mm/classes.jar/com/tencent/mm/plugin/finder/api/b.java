package com.tencent.mm.plugin.finder.api;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class b
{
  private static boolean DEBUG = false;
  private static final String TAG = "Finder.FinderContactLogic";
  private static final String qWr = "@finder";
  private static final a qWs;
  public static final a qWt;
  
  static
  {
    AppMethodBeat.i(165145);
    qWt = new a((byte)0);
    TAG = "Finder.FinderContactLogic";
    qWr = "@finder";
    qWs = ((PluginFinder)g.ad(PluginFinder.class)).getFinderContactCache();
    AppMethodBeat.o(165145);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "TAG", "", "TAG_FINDER_CONTACT", "getTAG_FINDER_CONTACT", "()Ljava/lang/String;", "cacheItems", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "checkContactCacheAvailable", "username", "deleteCache", "", "deleteContact", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContactFromDB", "getSelf", "hardCodeSelf", "isContactExists", "isFinderContactUser", "isFollow", "isNeedShowUnFollow", "operationSetFollow", "finderUserName", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "followFlag", "", "operationSetIsNeedShowUnFollow", "replaceContact", "contact", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "operation", "ct", "onlyMemory", "replaceContactInDB", "replaceMinContact", "selectFollowedContact", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "limit", "updateCache", "updateContact", "plugin-finder_release"})
  public static final class a
  {
    public static void a(String paramString, boolean paramBoolean, d.g.a.b<? super Boolean, y> paramb)
    {
      AppMethodBeat.i(165137);
      k.h(paramString, "finderUserName");
      k.h(paramb, "callback");
      Object localObject2 = b.access$getTAG$cp();
      Object localObject3 = new StringBuilder("operationSetFollow ").append(paramString).append(' ').append(paramBoolean).append(" and cacheItem ");
      Object localObject1 = b.crW().adg(paramString);
      if (localObject1 != null) {}
      for (localObject1 = ((f)localObject1).csa();; localObject1 = null)
      {
        ac.i((String)localObject2, (String)localObject1);
        localObject3 = (d.g.a.b)new a(paramBoolean);
        localObject2 = adh(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new f();
          ((f)localObject1).field_username = paramString;
        }
        paramString = (f)((d.g.a.b)localObject3).ay(localObject1);
        c(paramString);
        a(paramString);
        paramb.ay(Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(165137);
        return;
      }
    }
    
    public static boolean a(f paramf)
    {
      boolean bool = true;
      AppMethodBeat.i(165135);
      Object localObject1 = ((PluginFinder)g.ad(PluginFinder.class)).getContactStorage();
      k.h(paramf, "ct");
      Object localObject2;
      int i;
      if (((c)localObject1).adh(paramf.getUsername()) == null)
      {
        k.h(paramf, "contact");
        localObject2 = paramf.convertTo();
        i = (int)((c)localObject1).rCY.insert("FinderContact", "", (ContentValues)localObject2);
        ac.i("Finder.FinderContactStorage", "insert contact " + paramf + ' ' + i);
        if (i > 0)
        {
          if (bool) {
            ((c)localObject1).doNotify("FinderContact", 3, ((c)localObject1).rCY);
          }
          localObject1 = b.access$getTAG$cp();
          localObject2 = new StringBuilder("replaceContact success=").append(bool).append(' ').append(paramf.getUsername()).append(' ').append(paramf.csa()).append(' ');
          if (!b.aor()) {
            break label298;
          }
        }
      }
      label298:
      for (paramf = bs.eWi();; paramf = "")
      {
        ac.i((String)localObject1, paramf);
        AppMethodBeat.o(165135);
        return bool;
        bool = false;
        break;
        k.h(paramf, "contact");
        localObject2 = paramf.convertTo();
        ((ContentValues)localObject2).remove("rowid");
        i = ((c)localObject1).rCY.update("FinderContact", (ContentValues)localObject2, "username=?", new String[] { paramf.field_username });
        ac.i("Finder.FinderContactStorage", "updateContact " + paramf.csb() + ' ' + i);
        if (i > 0) {
          break;
        }
        bool = false;
        break;
      }
    }
    
    public static boolean a(FinderContact paramFinderContact)
    {
      AppMethodBeat.i(165140);
      k.h(paramFinderContact, "fcontact");
      Object localObject1 = (CharSequence)paramFinderContact.username;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        ac.e(b.access$getTAG$cp(), "error FinderContact username is null " + bs.eWi());
        AppMethodBeat.o(165140);
        return false;
      }
      localObject1 = paramFinderContact.username;
      k.g(localObject1, "fcontact.username");
      Object localObject2 = adh((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new f();
      }
      String str = paramFinderContact.username;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((f)localObject1).setUsername((String)localObject2);
      str = paramFinderContact.headUrl;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((f)localObject1).adl((String)localObject2);
      str = paramFinderContact.nickname;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((f)localObject1).qj((String)localObject2);
      ((f)localObject1).field_version = paramFinderContact.seq;
      str = paramFinderContact.signature;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((f)localObject1).field_signature = ((String)localObject2);
      ((f)localObject1).field_follow_Flag = paramFinderContact.followFlag;
      str = paramFinderContact.nickname;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((f)localObject1).field_pyInitial = com.tencent.mm.platformtools.f.Fw((String)localObject2);
      ((f)localObject1).field_followTime = paramFinderContact.followTime;
      str = paramFinderContact.coverImgUrl;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((f)localObject1).field_coverImg = ((String)localObject2);
      ((f)localObject1).field_spamStatus = paramFinderContact.spamStatus;
      ((f)localObject1).field_authInfo = paramFinderContact.authInfo;
      ((f)localObject1).field_extInfo = paramFinderContact.extInfo;
      ((f)localObject1).field_originalFlag = paramFinderContact.originalFlag;
      ((f)localObject1).field_originalInfo = paramFinderContact.originalInfo;
      b.aor();
      ac.i(b.access$getTAG$cp(), "replaceContact contact %s result %s", new Object[] { ((f)localObject1).getUsername(), ((f)localObject1).csa() });
      c((f)localObject1);
      a((f)localObject1);
      AppMethodBeat.o(165140);
      return true;
    }
    
    public static f adh(String paramString)
    {
      AppMethodBeat.i(165132);
      k.h(paramString, "username");
      if (k.g(paramString, u.axE()))
      {
        paramString = crX();
        AppMethodBeat.o(165132);
        return paramString;
      }
      Object localObject = b.crW().adg(paramString);
      if (localObject != null)
      {
        localObject = (CharSequence)((f)localObject).field_username;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label106;
        }
        i = 1;
        if ((i == 0) && (!k.g(paramString, u.axE()))) {
          break label111;
        }
      }
      label106:
      label111:
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label116;
        }
        paramString = b.crW().adg(paramString);
        AppMethodBeat.o(165132);
        return paramString;
        i = 0;
        break;
      }
      label116:
      localObject = adi(paramString);
      if (localObject != null) {
        c((f)localObject);
      }
      paramString = b.crW().adg(paramString);
      AppMethodBeat.o(165132);
      return paramString;
    }
    
    private static f adi(String paramString)
    {
      AppMethodBeat.i(165133);
      f localf = ((PluginFinder)g.ad(PluginFinder.class)).getContactStorage().adh(paramString);
      String str2 = b.access$getTAG$cp();
      if (localf != null) {}
      for (String str1 = localf.csa();; str1 = null)
      {
        ac.i(str2, "get contact %s %s", new Object[] { paramString, str1 });
        AppMethodBeat.o(165133);
        return localf;
      }
    }
    
    public static boolean adj(String paramString)
    {
      AppMethodBeat.i(165134);
      k.h(paramString, "username");
      ac.d(b.access$getTAG$cp(), "isContact  %s exists ?", new Object[] { paramString });
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(165134);
        return false;
      }
      if ((b.crW().adg(paramString) != null) || (adi(paramString) != null))
      {
        AppMethodBeat.o(165134);
        return true;
      }
      AppMethodBeat.o(165134);
      return false;
    }
    
    public static boolean adk(String paramString)
    {
      AppMethodBeat.i(165143);
      if (paramString != null)
      {
        a locala = b.qWt;
        paramString = adh(paramString);
        if (paramString != null)
        {
          int i = paramString.field_follow_Flag;
          paramString = f.qWF;
          if (i == f.csd())
          {
            AppMethodBeat.o(165143);
            return true;
          }
        }
        AppMethodBeat.o(165143);
        return false;
      }
      AppMethodBeat.o(165143);
      return false;
    }
    
    public static boolean b(f paramf)
    {
      AppMethodBeat.i(165136);
      k.h(paramf, "contact");
      String str = b.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("update contact ").append(paramf.getUsername()).append(' ').append(paramf.csa()).append(' ');
      if (b.aor()) {}
      for (Object localObject = bs.eWi();; localObject = "")
      {
        ac.i(str, localObject);
        if (!adj(paramf.getUsername())) {
          break;
        }
        c(paramf);
        if (adi(paramf.getUsername()) != null)
        {
          localObject = b.qWt;
          a(paramf);
        }
        AppMethodBeat.o(165136);
        return true;
      }
      AppMethodBeat.o(165136);
      return false;
    }
    
    public static boolean b(FinderContact paramFinderContact)
    {
      Object localObject3 = null;
      AppMethodBeat.i(165141);
      k.h(paramFinderContact, "fcontact");
      Object localObject1 = (CharSequence)paramFinderContact.username;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        ac.e(b.access$getTAG$cp(), "error FinderContact username is null " + bs.eWi());
        AppMethodBeat.o(165141);
        return false;
      }
      localObject1 = paramFinderContact.username;
      k.g(localObject1, "fcontact.username");
      Object localObject2 = adh((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new f();
      }
      String str1 = paramFinderContact.username;
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      ((f)localObject1).setUsername((String)localObject2);
      str1 = paramFinderContact.headUrl;
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      ((f)localObject1).adl((String)localObject2);
      str1 = paramFinderContact.nickname;
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      ((f)localObject1).qj((String)localObject2);
      localObject2 = ((f)localObject1).field_authInfo;
      if (localObject2 != null)
      {
        if (paramFinderContact.authInfo != null)
        {
          ((FinderAuthInfo)localObject2).appName = paramFinderContact.authInfo.appName;
          ((FinderAuthInfo)localObject2).authProfession = paramFinderContact.authInfo.authProfession;
          ((FinderAuthInfo)localObject2).authIconType = paramFinderContact.authInfo.authIconType;
          ((FinderAuthInfo)localObject2).detailLink = paramFinderContact.authInfo.detailLink;
          ((FinderAuthInfo)localObject2).realName = paramFinderContact.authInfo.realName;
        }
        ((f)localObject1).field_extInfo = paramFinderContact.extInfo;
        if (!b.aor()) {
          break label476;
        }
        str1 = b.access$getTAG$cp();
        StringBuilder localStringBuilder1 = new StringBuilder("replaceMinContact fcontact : ");
        k.h(paramFinderContact, "$this$info");
        StringBuilder localStringBuilder2 = new StringBuilder("info:userName:").append(paramFinderContact.username).append(" nickname: ").append(paramFinderContact.nickname).append(" followFlag: ").append(paramFinderContact.followFlag).append(" auth: ");
        localObject2 = paramFinderContact.authInfo;
        if (localObject2 == null) {
          break label471;
        }
        localObject2 = ((FinderAuthInfo)localObject2).realName;
        label351:
        localStringBuilder2 = localStringBuilder2.append((String)localObject2).append(" signature: ").append(paramFinderContact.signature).append(" headUrl_len: ");
        String str2 = paramFinderContact.headUrl;
        localObject2 = localObject3;
        if (str2 != null) {
          localObject2 = Integer.valueOf(str2.length());
        }
        ac.i(str1, localStringBuilder2.append(localObject2).append(", originalFlag:").append(paramFinderContact.originalFlag).toString() + "  from " + bs.eWi());
      }
      for (;;)
      {
        c((f)localObject1);
        AppMethodBeat.o(165141);
        return true;
        ((f)localObject1).field_authInfo = paramFinderContact.authInfo;
        break;
        label471:
        localObject2 = null;
        break label351;
        label476:
        ac.i(b.access$getTAG$cp(), "replaceMinContact result %s onlyMemory true", new Object[] { ((f)localObject1).csb() });
      }
    }
    
    public static void c(f paramf)
    {
      AppMethodBeat.i(165142);
      b.crW().a(paramf.getUsername(), paramf);
      AppMethodBeat.o(165142);
    }
    
    public static f crX()
    {
      AppMethodBeat.i(165131);
      Object localObject1 = b.crW();
      Object localObject2 = u.axE();
      k.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
      localObject1 = ((a)localObject1).adg((String)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new f();
        ((f)localObject1).field_username = u.axE();
      }
      for (;;)
      {
        localObject2 = f.qWF;
        ((f)localObject1).field_follow_Flag = f.csd();
        localObject2 = g.agR();
        k.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).agA().get(ah.a.GTR, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((f)localObject1).field_nickname = ((String)localObject2);
        localObject2 = g.agR();
        k.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).agA().get(ah.a.GTT, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((f)localObject1).field_avatarUrl = ((String)localObject2);
        localObject2 = g.agR();
        k.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).agA().get(ah.a.GTV, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((f)localObject1).field_coverImg = ((String)localObject2);
        localObject2 = g.agR();
        k.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).agA().get(ah.a.GTS, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((f)localObject1).field_signature = ((String)localObject2);
        localObject2 = g.agR();
        k.g(localObject2, "MMKernel.storage()");
        ((f)localObject1).field_originalFlag = ((com.tencent.mm.kernel.e)localObject2).agA().getInt(ah.a.GTY, 0);
        localObject2 = g.agR();
        k.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).agA().get(ah.a.GTU, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        Object localObject3 = (String)localObject2;
        if (!bs.isNullOrNil((String)localObject3))
        {
          ((f)localObject1).field_authInfo = new FinderAuthInfo();
          localObject2 = (com.tencent.mm.bw.a)((f)localObject1).field_authInfo;
          localObject3 = bs.aLu((String)localObject3);
        }
        for (;;)
        {
          try
          {
            ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject3);
            AppMethodBeat.o(165131);
            return localObject1;
          }
          catch (Exception localException)
          {
            ac.l("safeParser", "", new Object[] { localException });
            continue;
          }
          ((f)localObject1).field_authInfo = null;
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<f, f>
    {
      a(boolean paramBoolean)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.b
 * JD-Core Version:    0.7.0.1
 */