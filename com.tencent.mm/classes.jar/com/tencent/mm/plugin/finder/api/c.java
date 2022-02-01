package com.tencent.mm.plugin.finder.api;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bp;
import d.g.b.p;
import d.g.b.q;
import d.v;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class c
{
  private static boolean DEBUG = false;
  private static final String TAG = "Finder.FinderContactLogic";
  private static final a rHm;
  public static final a rHn;
  
  static
  {
    AppMethodBeat.i(165145);
    rHn = new a((byte)0);
    TAG = "Finder.FinderContactLogic";
    rHm = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderContactCache();
    AppMethodBeat.o(165145);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "TAG", "", "TAG_FINDER_CONTACT", "cacheItems", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "checkContactCacheAvailable", "username", "deleteCache", "", "deleteContact", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContactFromDB", "getSelf", "hardCodeSelf", "isContactExists", "isFinderContactUser", "isFollow", "isNeedShowUnFollow", "isPrivate", "isWaiting", "operationSetFollow", "finderUserName", "followFlag", "", "operationSetIsNeedShowUnFollow", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "replaceContact", "contact", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "operation", "ct", "onlyMemory", "replaceContactInDB", "replaceMinContact", "selectFollowedContact", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "limit", "updateCache", "updateContact", "plugin-finder_release"})
  public static final class a
  {
    private static boolean a(g paramg)
    {
      boolean bool = false;
      AppMethodBeat.i(165135);
      Object localObject1 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getContactStorage();
      p.h(paramg, "ct");
      paramg.field_updateTime = cf.aCM();
      Object localObject2;
      int i;
      StringBuilder localStringBuilder;
      if (((com.tencent.mm.plugin.finder.storage.c)localObject1).agW(paramg.getUsername()) == null)
      {
        p.h(paramg, "contact");
        localObject2 = paramg.convertTo();
        i = (int)((com.tencent.mm.plugin.finder.storage.c)localObject1).sxB.insert("FinderContact", "", (ContentValues)localObject2);
        ad.i("Finder.FinderContactStorage", "insert contact " + paramg + ' ' + i);
        if (i > 0) {
          bool = true;
        }
        if (bool) {
          ((com.tencent.mm.plugin.finder.storage.c)localObject1).doNotify("FinderContact", 4, paramg.getUsername());
        }
        localObject2 = c.access$getTAG$cp();
        localStringBuilder = new StringBuilder("replaceContact success=").append(bool).append(' ').append(paramg.getUsername()).append(' ').append(paramg.cxO()).append(' ');
        if (!c.access$getDEBUG$cp()) {
          break label339;
        }
      }
      label339:
      for (localObject1 = bt.flS();; localObject1 = "")
      {
        ad.i((String)localObject2, localObject1);
        if (bool)
        {
          localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
          ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azp().d(g.e(paramg), true);
        }
        AppMethodBeat.o(165135);
        return bool;
        p.h(paramg, "contact");
        localObject2 = paramg.convertTo();
        ((ContentValues)localObject2).remove("rowid");
        i = ((com.tencent.mm.plugin.finder.storage.c)localObject1).sxB.update("FinderContact", (ContentValues)localObject2, "username=?", new String[] { paramg.field_username });
        ad.i("Finder.FinderContactStorage", "updateContact " + paramg.cxP() + ' ' + i);
        if (i <= 0) {
          break;
        }
        bool = true;
        break;
      }
    }
    
    public static boolean a(FinderContact paramFinderContact)
    {
      AppMethodBeat.i(165140);
      p.h(paramFinderContact, "fcontact");
      Object localObject = (CharSequence)paramFinderContact.username;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        ad.e(c.access$getTAG$cp(), "error FinderContact username is null " + bt.flS());
        AppMethodBeat.o(165140);
        return false;
      }
      localObject = paramFinderContact.username;
      p.g(localObject, "fcontact.username");
      paramFinderContact = b.a(paramFinderContact, agW((String)localObject));
      c.access$getDEBUG$cp();
      ad.i(c.access$getTAG$cp(), "replaceContact contact %s result %s", new Object[] { paramFinderContact.getUsername(), paramFinderContact.cxO() });
      d(paramFinderContact);
      a(paramFinderContact);
      AppMethodBeat.o(165140);
      return true;
    }
    
    public static g agW(String paramString)
    {
      AppMethodBeat.i(165132);
      p.h(paramString, "username");
      if (p.i(paramString, u.aAu()))
      {
        paramString = cxJ();
        AppMethodBeat.o(165132);
        return paramString;
      }
      Object localObject = c.cxI().agV(paramString);
      if (localObject != null)
      {
        localObject = (CharSequence)((g)localObject).field_username;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label106;
        }
        i = 1;
        if ((i == 0) && (!p.i(paramString, u.aAu()))) {
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
        paramString = c.cxI().agV(paramString);
        AppMethodBeat.o(165132);
        return paramString;
        i = 0;
        break;
      }
      label116:
      localObject = agX(paramString);
      if (localObject != null) {
        d((g)localObject);
      }
      paramString = c.cxI().agV(paramString);
      AppMethodBeat.o(165132);
      return paramString;
    }
    
    private static g agX(String paramString)
    {
      AppMethodBeat.i(165133);
      g localg = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getContactStorage().agW(paramString);
      String str2 = c.access$getTAG$cp();
      if (localg != null) {}
      for (String str1 = localg.cxO();; str1 = null)
      {
        ad.i(str2, "get contact %s %s", new Object[] { paramString, str1 });
        AppMethodBeat.o(165133);
        return localg;
      }
    }
    
    public static boolean agY(String paramString)
    {
      AppMethodBeat.i(165134);
      p.h(paramString, "username");
      ad.d(c.access$getTAG$cp(), "isContact  %s exists ?", new Object[] { paramString });
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(165134);
        return false;
      }
      if ((c.cxI().agV(paramString) != null) || (agX(paramString) != null))
      {
        AppMethodBeat.o(165134);
        return true;
      }
      AppMethodBeat.o(165134);
      return false;
    }
    
    public static boolean agZ(String paramString)
    {
      AppMethodBeat.i(165143);
      if (paramString != null)
      {
        a locala = c.rHn;
        paramString = agW(paramString);
        if (paramString != null)
        {
          int i = paramString.field_follow_Flag;
          paramString = g.rHB;
          if (i == g.cxS())
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
    
    public static boolean aha(String paramString)
    {
      AppMethodBeat.i(201004);
      if (paramString != null)
      {
        a locala = c.rHn;
        paramString = agW(paramString);
        if (paramString != null)
        {
          int i = paramString.field_follow_Flag;
          paramString = g.rHB;
          if (i == g.cxR())
          {
            AppMethodBeat.o(201004);
            return true;
          }
        }
        AppMethodBeat.o(201004);
        return false;
      }
      AppMethodBeat.o(201004);
      return false;
    }
    
    public static boolean b(g paramg)
    {
      AppMethodBeat.i(165136);
      p.h(paramg, "contact");
      String str = c.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("update contact ").append(paramg.getUsername()).append(' ').append(paramg.cxO()).append(' ');
      if (c.access$getDEBUG$cp()) {}
      for (Object localObject = bt.flS();; localObject = "")
      {
        ad.i(str, localObject);
        if (!agY(paramg.getUsername())) {
          break;
        }
        d(paramg);
        if (agX(paramg.getUsername()) != null)
        {
          localObject = c.rHn;
          a(paramg);
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
      p.h(paramFinderContact, "fcontact");
      Object localObject1 = (CharSequence)paramFinderContact.username;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        ad.e(c.access$getTAG$cp(), "error FinderContact username is null " + bt.flS());
        AppMethodBeat.o(165141);
        return false;
      }
      localObject1 = paramFinderContact.username;
      p.g(localObject1, "fcontact.username");
      Object localObject2 = agW((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new g();
      }
      String str1 = paramFinderContact.username;
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      ((g)localObject1).setUsername((String)localObject2);
      str1 = paramFinderContact.headUrl;
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      ((g)localObject1).ahb((String)localObject2);
      str1 = paramFinderContact.nickname;
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      ((g)localObject1).sT((String)localObject2);
      localObject2 = ((g)localObject1).field_authInfo;
      if (localObject2 != null)
      {
        if (paramFinderContact.authInfo != null)
        {
          ((FinderAuthInfo)localObject2).appName = paramFinderContact.authInfo.appName;
          ((FinderAuthInfo)localObject2).authProfession = paramFinderContact.authInfo.authProfession;
          ((FinderAuthInfo)localObject2).authIconType = paramFinderContact.authInfo.authIconType;
          ((FinderAuthInfo)localObject2).detailLink = paramFinderContact.authInfo.detailLink;
          ((FinderAuthInfo)localObject2).realName = paramFinderContact.authInfo.realName;
          ((FinderAuthInfo)localObject2).authIconUrl = paramFinderContact.authInfo.authIconUrl;
        }
        ((g)localObject1).field_extInfo = paramFinderContact.extInfo;
        if (!c.access$getDEBUG$cp()) {
          break label487;
        }
        str1 = c.access$getTAG$cp();
        StringBuilder localStringBuilder1 = new StringBuilder("replaceMinContact fcontact : ");
        p.h(paramFinderContact, "$this$info");
        StringBuilder localStringBuilder2 = new StringBuilder("info:userName:").append(paramFinderContact.username).append(" nickname: ").append(paramFinderContact.nickname).append(" followFlag: ").append(paramFinderContact.followFlag).append(" auth: ");
        localObject2 = paramFinderContact.authInfo;
        if (localObject2 == null) {
          break label482;
        }
        localObject2 = ((FinderAuthInfo)localObject2).realName;
        label362:
        localStringBuilder2 = localStringBuilder2.append((String)localObject2).append(" signature: ").append(paramFinderContact.signature).append(" headUrl_len: ");
        String str2 = paramFinderContact.headUrl;
        localObject2 = localObject3;
        if (str2 != null) {
          localObject2 = Integer.valueOf(str2.length());
        }
        ad.i(str1, localStringBuilder2.append(localObject2).append(", originalFlag:").append(paramFinderContact.originalFlag).toString() + "  from " + bt.flS());
      }
      for (;;)
      {
        d((g)localObject1);
        AppMethodBeat.o(165141);
        return true;
        ((g)localObject1).field_authInfo = paramFinderContact.authInfo;
        break;
        label482:
        localObject2 = null;
        break label362;
        label487:
        ad.i(c.access$getTAG$cp(), "replaceMinContact result %s onlyMemory true", new Object[] { ((g)localObject1).cxP() });
      }
    }
    
    public static boolean c(g paramg)
    {
      AppMethodBeat.i(201003);
      p.h(paramg, "contact");
      d(paramg);
      boolean bool = a(paramg);
      AppMethodBeat.o(201003);
      return bool;
    }
    
    public static g cxJ()
    {
      AppMethodBeat.i(165131);
      Object localObject1 = c.cxI();
      Object localObject2 = u.aAu();
      p.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
      localObject1 = ((a)localObject1).agV((String)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new g();
        ((g)localObject1).field_username = u.aAu();
      }
      for (;;)
      {
        localObject2 = g.rHB;
        ((g)localObject1).field_follow_Flag = g.cxS();
        localObject2 = com.tencent.mm.kernel.g.ajC();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajl().get(al.a.IGx, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((g)localObject1).field_nickname = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.g.ajC();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajl().get(al.a.IGz, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((g)localObject1).field_avatarUrl = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.g.ajC();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajl().get(al.a.IGB, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((g)localObject1).field_coverImg = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.g.ajC();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajl().get(al.a.IGy, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((g)localObject1).field_signature = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.g.ajC();
        p.g(localObject2, "MMKernel.storage()");
        ((g)localObject1).field_originalFlag = ((com.tencent.mm.kernel.e)localObject2).ajl().getInt(al.a.IGE, 0);
        localObject2 = com.tencent.mm.kernel.g.ajC();
        p.g(localObject2, "MMKernel.storage()");
        ((g)localObject1).field_extFlag = ((com.tencent.mm.kernel.e)localObject2).ajl().getInt(al.a.IGW, 0);
        localObject2 = com.tencent.mm.kernel.g.ajC();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajl().get(al.a.IGA, "");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        Object localObject3 = (String)localObject2;
        if (!bt.isNullOrNil((String)localObject3))
        {
          ((g)localObject1).field_authInfo = new FinderAuthInfo();
          localObject2 = (com.tencent.mm.bx.a)((g)localObject1).field_authInfo;
          localObject3 = bt.aRa((String)localObject3);
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
          ((g)localObject1).field_authInfo = null;
        }
      }
    }
    
    public static void d(g paramg)
    {
      AppMethodBeat.i(165142);
      String str1 = paramg.getUsername();
      c.cxI().a(str1, paramg);
      paramg = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramg, "MMKernel.service(IMessengerStorage::class.java)");
      paramg = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramg).azp();
      String str2 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage().aix(str1);
      paramg.akd(str1);
      paramg.akd(str2);
      AppMethodBeat.o(165142);
    }
    
    public static void dj(String paramString, int paramInt)
    {
      AppMethodBeat.i(201002);
      p.h(paramString, "finderUserName");
      Object localObject2 = c.access$getTAG$cp();
      Object localObject3 = new StringBuilder("operationSetFollow ").append(paramString).append(' ').append(paramInt).append(" and cacheItem ");
      Object localObject1 = c.cxI().agV(paramString);
      if (localObject1 != null) {}
      for (localObject1 = ((g)localObject1).cxO();; localObject1 = null)
      {
        ad.i((String)localObject2, (String)localObject1);
        localObject3 = (d.g.a.b)new a(paramInt);
        localObject2 = agW(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new g();
          ((g)localObject1).field_username = paramString;
        }
        paramString = (g)((d.g.a.b)localObject3).invoke(localObject1);
        d(paramString);
        a(paramString);
        AppMethodBeat.o(201002);
        return;
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<g, g>
    {
      a(int paramInt)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.c
 * JD-Core Version:    0.7.0.1
 */