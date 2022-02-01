package com.tencent.mm.plugin.finder.api;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class b
{
  private static boolean DEBUG = false;
  private static final String TAG = "Finder.FinderContactLogic";
  private static final String qnV = "@finder";
  private static final a qnW;
  public static final a qnX;
  
  static
  {
    AppMethodBeat.i(165145);
    qnX = new a((byte)0);
    TAG = "Finder.FinderContactLogic";
    qnV = "@finder";
    qnW = ((PluginFinder)g.ad(PluginFinder.class)).getFinderContactCache();
    AppMethodBeat.o(165145);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "TAG", "", "TAG_FINDER_CONTACT", "getTAG_FINDER_CONTACT", "()Ljava/lang/String;", "cacheItems", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "checkContactCacheAvailable", "username", "deleteCache", "", "deleteContact", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContactFromDB", "getSelf", "hardCodeSelf", "isContactExists", "isFinderContactUser", "isFollow", "isNeedShowUnFollow", "operationSetFollow", "finderUserName", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "followFlag", "", "operationSetIsNeedShowUnFollow", "replaceContact", "contact", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "operation", "ct", "onlyMemory", "replaceContactInDB", "replaceMinContact", "selectFollowedContact", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "limit", "updateCache", "updateContact", "plugin-finder_release"})
  public static final class a
  {
    public static f YL(String paramString)
    {
      AppMethodBeat.i(165132);
      k.h(paramString, "username");
      if (k.g(paramString, u.aqO()))
      {
        paramString = ckq();
        AppMethodBeat.o(165132);
        return paramString;
      }
      Object localObject = b.ckp().YK(paramString);
      if (localObject != null)
      {
        localObject = (CharSequence)((f)localObject).field_username;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label102;
        }
        i = 1;
        if ((i == 0) && (!k.g(paramString, u.aqO()))) {
          break label107;
        }
      }
      label102:
      label107:
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label112;
        }
        paramString = b.ckp().YK(paramString);
        AppMethodBeat.o(165132);
        return paramString;
        i = 0;
        break;
      }
      label112:
      localObject = YM(paramString);
      if (localObject != null) {
        c((f)localObject);
      }
      paramString = b.ckp().YK(paramString);
      AppMethodBeat.o(165132);
      return paramString;
    }
    
    private static f YM(String paramString)
    {
      AppMethodBeat.i(165133);
      f localf = ((PluginFinder)g.ad(PluginFinder.class)).getContactStorage().YL(paramString);
      String str2 = b.access$getTAG$cp();
      if (localf != null) {}
      for (String str1 = localf.ckt();; str1 = null)
      {
        ad.i(str2, "get contact %s %s", new Object[] { paramString, str1 });
        AppMethodBeat.o(165133);
        return localf;
      }
    }
    
    public static boolean YN(String paramString)
    {
      AppMethodBeat.i(165134);
      k.h(paramString, "username");
      ad.d(b.access$getTAG$cp(), "isContact  %s exists ?", new Object[] { paramString });
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(165134);
        return false;
      }
      if ((b.ckp().YK(paramString) != null) || (YM(paramString) != null))
      {
        AppMethodBeat.o(165134);
        return true;
      }
      AppMethodBeat.o(165134);
      return false;
    }
    
    public static boolean YO(String paramString)
    {
      AppMethodBeat.i(165143);
      if (paramString != null)
      {
        a locala = b.qnX;
        paramString = YL(paramString);
        if (paramString != null)
        {
          int i = paramString.field_follow_Flag;
          paramString = f.qok;
          if (i == f.ckw())
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
    
    public static void a(String paramString, boolean paramBoolean, d.g.a.b<? super Boolean, y> paramb)
    {
      AppMethodBeat.i(165137);
      k.h(paramString, "finderUserName");
      k.h(paramb, "callback");
      Object localObject2 = b.access$getTAG$cp();
      Object localObject3 = new StringBuilder("operationSetFollow ").append(paramString).append(' ').append(paramBoolean).append(" and cacheItem ");
      Object localObject1 = b.ckp().YK(paramString);
      if (localObject1 != null) {}
      for (localObject1 = ((f)localObject1).ckt();; localObject1 = null)
      {
        ad.i((String)localObject2, (String)localObject1);
        localObject3 = (d.g.a.b)new a(paramBoolean);
        localObject2 = YL(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new f();
          ((f)localObject1).field_username = paramString;
        }
        paramString = (f)((d.g.a.b)localObject3).aA(localObject1);
        c(paramString);
        a(paramString);
        paramb.aA(Boolean.valueOf(paramBoolean));
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
      if (((c)localObject1).YL(paramf.getUsername()) == null)
      {
        k.h(paramf, "contact");
        localObject2 = paramf.convertTo();
        i = (int)((c)localObject1).qJE.insert("FinderContact", "", (ContentValues)localObject2);
        ad.i("Finder.FinderContactStorage", "insert contact " + paramf + ' ' + i);
        if (i > 0)
        {
          if (bool) {
            ((c)localObject1).doNotify("FinderContact", 3, ((c)localObject1).qJE);
          }
          localObject1 = b.access$getTAG$cp();
          localObject2 = new StringBuilder("replaceContact success=").append(bool).append(' ').append(paramf.getUsername()).append(' ').append(paramf.ckt()).append(' ');
          if (!b.ahp()) {
            break label309;
          }
        }
      }
      label309:
      for (paramf = bt.eGN();; paramf = "")
      {
        ad.i((String)localObject1, paramf);
        AppMethodBeat.o(165135);
        return bool;
        bool = false;
        break;
        k.h(paramf, "contact");
        localObject2 = paramf.convertTo();
        ((ContentValues)localObject2).remove("rowid");
        i = ((c)localObject1).qJE.update("FinderContact", (ContentValues)localObject2, "username=?", new String[] { paramf.field_username });
        ad.i("Finder.FinderContactStorage", "updateContact " + paramf.cku() + ' ' + i);
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
        ad.e(b.access$getTAG$cp(), "error FinderContact username is null " + bt.eGN());
        AppMethodBeat.o(165140);
        return false;
      }
      localObject1 = paramFinderContact.username;
      k.g(localObject1, "fcontact.username");
      Object localObject2 = YL((String)localObject1);
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
      ((f)localObject1).YQ((String)localObject2);
      str = paramFinderContact.nickname;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      ((f)localObject1).nd((String)localObject2);
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
      ((f)localObject1).field_pyInitial = com.tencent.mm.platformtools.f.Bs((String)localObject2);
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
      b.ahp();
      ad.i(b.access$getTAG$cp(), "replaceContact contact %s result %s", new Object[] { ((f)localObject1).getUsername(), ((f)localObject1).ckt() });
      c((f)localObject1);
      a((f)localObject1);
      AppMethodBeat.o(165140);
      return true;
    }
    
    public static boolean b(f paramf)
    {
      AppMethodBeat.i(165136);
      k.h(paramf, "contact");
      String str = b.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("update contact ").append(paramf.getUsername()).append(' ').append(paramf.ckt()).append(' ');
      if (b.ahp()) {}
      for (Object localObject = bt.eGN();; localObject = "")
      {
        ad.i(str, localObject);
        if (!YN(paramf.getUsername())) {
          break;
        }
        c(paramf);
        if (YM(paramf.getUsername()) != null)
        {
          localObject = b.qnX;
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
        ad.e(b.access$getTAG$cp(), "error FinderContact username is null " + bt.eGN());
        AppMethodBeat.o(165141);
        return false;
      }
      localObject1 = paramFinderContact.username;
      k.g(localObject1, "fcontact.username");
      Object localObject2 = YL((String)localObject1);
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
      ((f)localObject1).YQ((String)localObject2);
      str1 = paramFinderContact.nickname;
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      ((f)localObject1).nd((String)localObject2);
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
        if (!b.ahp()) {
          break label480;
        }
        str1 = b.access$getTAG$cp();
        StringBuilder localStringBuilder1 = new StringBuilder("replaceMinContact fcontact : ");
        k.h(paramFinderContact, "$this$info");
        StringBuilder localStringBuilder2 = new StringBuilder("info:userName:").append(paramFinderContact.username).append(" nickname: ").append(paramFinderContact.nickname).append(" followFlag: ").append(paramFinderContact.followFlag).append(" auth: ");
        localObject2 = paramFinderContact.authInfo;
        if (localObject2 == null) {
          break label475;
        }
        localObject2 = ((FinderAuthInfo)localObject2).realName;
        label355:
        localStringBuilder2 = localStringBuilder2.append((String)localObject2).append(" signature: ").append(paramFinderContact.signature).append(" headUrl_len: ");
        String str2 = paramFinderContact.headUrl;
        localObject2 = localObject3;
        if (str2 != null) {
          localObject2 = Integer.valueOf(str2.length());
        }
        ad.i(str1, localStringBuilder2.append(localObject2).append(", originalFlag:").append(paramFinderContact.originalFlag).toString() + "  from " + bt.eGN());
      }
      for (;;)
      {
        c((f)localObject1);
        AppMethodBeat.o(165141);
        return true;
        ((f)localObject1).field_authInfo = paramFinderContact.authInfo;
        break;
        label475:
        localObject2 = null;
        break label355;
        label480:
        ad.i(b.access$getTAG$cp(), "replaceMinContact result %s onlyMemory true", new Object[] { ((f)localObject1).cku() });
      }
    }
    
    public static void c(f paramf)
    {
      AppMethodBeat.i(165142);
      b.ckp().a(paramf.getUsername(), paramf);
      AppMethodBeat.o(165142);
    }
    
    public static f ckq()
    {
      AppMethodBeat.i(165131);
      Object localObject1 = b.ckp();
      Object localObject2 = u.aqO();
      k.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
      localObject1 = ((a)localObject1).YK((String)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new f();
        ((f)localObject1).field_username = u.aqO();
      }
      for (;;)
      {
        localObject2 = f.qok;
        ((f)localObject1).field_follow_Flag = f.ckw();
        localObject2 = g.afB();
        k.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).afk().get(ae.a.FvX, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((f)localObject1).field_nickname = ((String)localObject2);
        localObject2 = g.afB();
        k.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).afk().get(ae.a.FvZ, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((f)localObject1).field_avatarUrl = ((String)localObject2);
        localObject2 = g.afB();
        k.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).afk().get(ae.a.Fwb, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((f)localObject1).field_coverImg = ((String)localObject2);
        localObject2 = g.afB();
        k.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).afk().get(ae.a.FvY, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((f)localObject1).field_signature = ((String)localObject2);
        localObject2 = g.afB();
        k.g(localObject2, "MMKernel.storage()");
        ((f)localObject1).field_originalFlag = ((com.tencent.mm.kernel.e)localObject2).afk().getInt(ae.a.Fwe, 0);
        localObject2 = g.afB();
        k.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).afk().get(ae.a.Fwa, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        Object localObject3 = (String)localObject2;
        if (!bt.isNullOrNil((String)localObject3))
        {
          ((f)localObject1).field_authInfo = new FinderAuthInfo();
          localObject2 = (com.tencent.mm.bx.a)((f)localObject1).field_authInfo;
          localObject3 = bt.aGd((String)localObject3);
        }
        for (;;)
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject3);
            AppMethodBeat.o(165131);
            return localObject1;
          }
          catch (Exception localException)
          {
            ad.l("safeParser", "", new Object[] { localException });
            continue;
          }
          ((f)localObject1).field_authInfo = null;
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "invoke"})
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